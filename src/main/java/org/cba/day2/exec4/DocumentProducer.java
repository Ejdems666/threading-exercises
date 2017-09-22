package org.cba.day2.exec4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

//This is the class template for the four Producer Threads P1-P4 in the exercise figure
public class DocumentProducer implements Runnable {

    BlockingQueue<String> urlsToUse;
    BlockingQueue<Document> producedDocuments;
    Document doc;

    public DocumentProducer(BlockingQueue<String> urlsToUse, BlockingQueue producedDocuments) {
        this.urlsToUse = urlsToUse;
        this.producedDocuments = producedDocuments;
    }

    @Override
    public void run()
    {
        boolean moreUrlsToFecth = true;
        while (moreUrlsToFecth)
        {
            try
            {
                String url = urlsToUse.poll(10, TimeUnit.SECONDS);

                if (url == null)
                    moreUrlsToFecth = false;
                else
                {
                    doc = Jsoup.connect(url).get();
                    producedDocuments.put(doc);
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

    }

}
