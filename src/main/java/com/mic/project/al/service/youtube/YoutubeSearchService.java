package com.mic.project.al.service.youtube;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.Customsearch;
import com.google.api.services.customsearch.model.Result;
import com.google.api.services.customsearch.model.Search;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.SearchResultSnippet;
import com.google.common.collect.Lists;
import com.mic.project.al.model.RelatedDocuments;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rchejerla on 27/02/18.
 */
public class YoutubeSearchService {

    private static Pattern patternDomainName;
    private static Matcher matcher;
    private static final String DOMAIN_NAME_PATTERN
            = "([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}";

    static {
        patternDomainName = Pattern.compile(DOMAIN_NAME_PATTERN);
    }

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


    public static List<RelatedDocuments> search(String keyWord) {
        List<RelatedDocuments> relatedDocumentss = new ArrayList<>();
        try {
            YouTube.Search.List searchListByKeywordRequest = youtube.search().list("id ,snippet");
            searchListByKeywordRequest.setKey("AIzaSyA0jWoepy300IKDEKs2DvdmcDoehiZ_dak");
            searchListByKeywordRequest.setMaxResults(10l);
            searchListByKeywordRequest.setType("");
            searchListByKeywordRequest.setRegionCode("IN");
            searchListByKeywordRequest.setQ(keyWord);
            SearchListResponse response = searchListByKeywordRequest.execute();
            List<SearchResult> items = response.getItems();

            for (SearchResult item : items) {
                SearchResultSnippet snippet = item.getSnippet();
                RelatedDocuments relatedDocuments = new RelatedDocuments(snippet.getTitle(), snippet.getDescription(), "YT", item.getId().getVideoId(),
                        snippet.getThumbnails().getDefault().getUrl(), item.getId().getVideoId());
                relatedDocumentss.add(relatedDocuments);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return relatedDocumentss;
    }

    public static List<RelatedDocuments> googleSearch(String query) {
        List<RelatedDocuments> relatedDocumentss = Lists.newArrayList();
        try {
            String cx = "002845322276752338984:vxqzfa86nqc";
            Customsearch.Cse.List list = cs.cse().list(query).setCx(cx).setKey("AIzaSyA0jWoepy300IKDEKs2DvdmcDoehiZ_dak").setExcludeTerms("youtube");

            //Execute search
            Search result = list.execute();
            if (result.getItems() != null) {
                for (Result ri : result.getItems()) {
                    RelatedDocuments relatedDocuments = new RelatedDocuments(ri.getTitle(), ri.getSnippet(), "TEXT", ri.getLink(), ri.getImage().getThumbnailLink(), ri.getLink());
                    relatedDocumentss.add(relatedDocuments);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return relatedDocumentss;
    }


    public static void main(String[] args) {
        //search("Hello tutorial");
        googleSearch("Hello tutorial");
    }
}
