package com.mic.project.al.service.youtube;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.Customsearch;
import com.google.api.services.customsearch.model.Result;
import com.google.api.services.customsearch.model.Search;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.*;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mic.project.al.model.RelatedDocuments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rchejerla on 27/02/18.
 */
public class YoutubeSearchService {

    private static YouTube youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(),
            new HttpRequestInitializer() {
                public void initialize(HttpRequest request) {
                }
            }).setApplicationName("Video-test").build();


    private static Customsearch cs = new Customsearch.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), new HttpRequestInitializer() {
        public void initialize(HttpRequest request) {
        }
    }).setApplicationName("MyApplication")
      .build();


    public static List<RelatedDocuments> search(String keyWord, long orignalDocId) {
        List<RelatedDocuments> relatedDocumentss = new ArrayList<>();
        try {
            YouTube.Search.List searchListByKeywordRequest = youtube.search().list("id ,snippet");
            searchListByKeywordRequest.setKey("AIzaSyA0jWoepy300IKDEKs2DvdmcDoehiZ_dak");
            searchListByKeywordRequest.setMaxResults(5l);
            searchListByKeywordRequest.setType("");
            searchListByKeywordRequest.setRegionCode("IN");
            searchListByKeywordRequest.setQ(keyWord);
            SearchListResponse response = searchListByKeywordRequest.execute();
            List<SearchResult> items = response.getItems();

            List<String> videoIds = Lists.newArrayList();
            for (SearchResult item : items) {
                SearchResultSnippet snippet = item.getSnippet();
                if (item.getId().getVideoId() == null) {
                    continue;
                }
                videoIds.add(item.getId().getVideoId());
                RelatedDocuments relatedDocuments = new RelatedDocuments(snippet.getTitle(), snippet.getDescription(), "YT", item.getId().getVideoId(),
                        snippet.getThumbnails().getDefault().getUrl(), item.getId().getVideoId());
                relatedDocuments.setOriginalDocId(orignalDocId);
                relatedDocumentss.add(relatedDocuments);
            }

            Map<String, Long> duration = getDuration(videoIds);
            for (RelatedDocuments relatedDocuments : relatedDocumentss) {
                relatedDocuments.setDuration(duration.get(relatedDocuments.getUrl()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return relatedDocumentss;
    }

    public static Map<String, Long> getDuration(List<String> ids) {
        Map<String, Long> longMap = Maps.newHashMap();
        try {
            YouTube.Videos.List videosListMultipleIdsRequest = youtube.videos().list("contentDetails");
            videosListMultipleIdsRequest.setKey("AIzaSyA0jWoepy300IKDEKs2DvdmcDoehiZ_dak");
            videosListMultipleIdsRequest.setId(Joiner.on(",").join(ids));
            VideoListResponse response = videosListMultipleIdsRequest.execute();
            //System.out.println(response.getItems());
            List<Video> items = response.getItems();

            for (Video s : items) {
                VideoContentDetails videoContentDetails = s.getContentDetails();
                Duration d = Duration.parse(videoContentDetails.getDuration());
                longMap.put(s.getId(), d.getSeconds());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return longMap;
    }

    public static List<RelatedDocuments> googleSearch(String query, long orignalDocId) {
        List<RelatedDocuments> relatedDocumentss = Lists.newArrayList();
        try {
            String cx = "002845322276752338984:vxqzfa86nqc";
            Customsearch.Cse.List list = cs.cse().list(query).setCx(cx).setKey("AIzaSyA0jWoepy300IKDEKs2DvdmcDoehiZ_dak").setExcludeTerms("youtube").setNum(5l);

            //Execute search
            Search result = list.execute();
            if (result.getItems() != null) {
                for (Result ri : result.getItems()) {
                    RelatedDocuments relatedDocuments = new RelatedDocuments(ri.getTitle(), ri.getSnippet(), "TEXT", ri.getLink(),
                            ri.getImage() != null ? ri.getImage().getThumbnailLink() : null, ri.getLink());
                    relatedDocuments.setOriginalDocId(orignalDocId);
                    relatedDocumentss.add(relatedDocuments);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return relatedDocumentss;
    }


    public static void main(String[] args) {
        //search("Hello tutorial", 123);
        getDuration(Lists.newArrayList("bP8KOeBgzoI,xXJnLQoWXd4"));
        //googleSearch("Hello tutorial");
    }
}
