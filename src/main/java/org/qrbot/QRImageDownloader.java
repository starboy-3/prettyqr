package org.qrbot;

public class QRImageDownloader {
    public void downloadImage(String imageUrl, String destinationPath) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(imageUrl);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                try (FileOutputStream fileOutputStream = new FileOutputStream(destinationPath)) {
                    entity.writeTo(fileOutputStream);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
