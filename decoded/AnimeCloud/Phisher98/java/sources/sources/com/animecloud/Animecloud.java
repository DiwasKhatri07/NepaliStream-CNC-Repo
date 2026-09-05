package com.animecloud;

import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Animecloud.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AnimeCloud/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J\f\u0010(\u001a\u00020)*\u00020*H\u0002J\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u001e2\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-J\u001e\u0010.\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u001e2\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-J\f\u0010/\u001a\u00020)*\u000200H\u0002J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-JF\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u000e2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:082\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020:08H\u0096@¢\u0006\u0002\u0010=R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006>"}, d2 = {"Lcom/animecloud/Animecloud;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/animecloud/HomeDaum;", "quickSearch", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "toSearchResponse", "Lcom/animecloud/Search;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AnimeCloud"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnimecloud.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animecloud.kt\ncom/animecloud/Animecloud\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,196:1\n73#2,5:197\n73#2,5:206\n73#2,5:215\n73#2,5:225\n1739#3:202\n1814#3,3:203\n1739#3:211\n1814#3,3:212\n2068#3:221\n2068#3,2:222\n2069#3:224\n1#4:220\n*S KotlinDebug\n*F\n+ 1 Animecloud.kt\ncom/animecloud/Animecloud\n*L\n64#1:197,5\n107#1:206,5\n131#1:215,5\n188#1:225,5\n74#1:202\n74#1:203,3\n108#1:211\n108#1:212,3\n140#1:221\n153#1:222,2\n140#1:224\n*E\n"})
public final class Animecloud extends MainAPI {

    @NotNull
    private String mainUrl = "https://fireani.me";

    @NotNull
    private String name = "Animecloud";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "de";
    private final boolean hasDownloadSupport = true;
    private final boolean hasQuickSearch = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Anime});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("ListAnimesByViewCount", "Trending"), TuplesKt.to("ListAnimesByGenre|Action", "Action"), TuplesKt.to("ListAnimesByGenre|Drama", "Drama"), TuplesKt.to("ListAnimesByGenre|Scifi", "Scifi"), TuplesKt.to("ListAnimesByGenre|Mystery", "Mystery"), TuplesKt.to("ListAnimesByGenre|Romanze", "Romanze"), TuplesKt.to("ListAnimesByGenre|Abenteuer", "Abenteuer"), TuplesKt.to("ListAnimesByGenre|EngSub", "EngSub")});

    /* JADX INFO: renamed from: com.animecloud.Animecloud$getMainPage$1 */
    /* JADX INFO: compiled from: Animecloud.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animecloud.Animecloud", f = "Animecloud.kt", i = {0, 0, 0, 0}, l = {64}, m = "getMainPage", n = {"request", "url", "json", "page"}, nl = {197}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Animecloud.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.animecloud.Animecloud$load$1 */
    /* JADX INFO: compiled from: Animecloud.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animecloud.Animecloud", f = "Animecloud.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {129, 165}, m = "load", n = {"url", "json", "url", "json", "document", "title", "poster", "backgroundUrl", "episodes"}, nl = {131, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Animecloud.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.animecloud.Animecloud$loadLinks$1 */
    /* JADX INFO: compiled from: Animecloud.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animecloud.Animecloud", f = "Animecloud.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {187, 188}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "json", "isCasting", "data", "subtitleCallback", "callback", "json", "isCasting"}, nl = {188, 193}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Animecloud.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.animecloud.Animecloud$search$1 */
    /* JADX INFO: compiled from: Animecloud.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animecloud.Animecloud", f = "Animecloud.kt", i = {0, 0}, l = {107}, m = "search", n = {"query", "json"}, nl = {197}, s = {"L$0", "L$1"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Animecloud.this.search(null, (Continuation) this);
        }
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00021 c00021;
        Object obj;
        boolean z;
        MainPageRequest request2;
        int page2;
        Object safe;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
            } else {
                c00021 = new C00021(continuation);
            }
        } else {
            c00021 = new C00021(continuation);
        }
        Object $result = c00021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00021.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url = getMainUrl() + "/api.v1.anime.AnimeService/" + StringsKt.substringBeforeLast$default(request.getData(), "|", (String) null, 2, (Object) null);
                String json = StringsKt.contains$default(request.getData(), "|", false, 2, (Object) null) ? StringsKt.trimMargin$default("\n            {\n            \"page\": " + page + ",\n            \"genre\": \"" + StringsKt.substringAfterLast$default(request.getData(), "|", (String) null, 2, (Object) null) + "\"\n            }\n        ", (String) null, 1, (Object) null) : StringsKt.trimIndent("\n           {\n            \"page\": " + page + "\n            }\n        ");
                Requests app = MainActivityKt.getApp();
                RequestBody requestBodyCreate = RequestBody.Companion.create(json, MediaType.Companion.get("application/json"));
                c00021.L$0 = request;
                c00021.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00021.L$2 = SpillingKt.nullOutSpilledVariable(json);
                c00021.I$0 = page;
                c00021.label = 1;
                obj = null;
                z = false;
                $result = Requests.post$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021, 65278, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                page2 = page;
                break;
                break;
            case 1:
                int page3 = c00021.I$0;
                request2 = (MainPageRequest) c00021.L$0;
                ResultKt.throwOnFailure($result);
                obj = null;
                z = false;
                page2 = page3;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Home.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = obj;
        }
        Home response = (Home) safe;
        if (response == null) {
            return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), CollectionsKt.emptyList(), z), Boxing.boxBoolean(z));
        }
        Iterable $this$map$iv = response.getData();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            HomeDaum it = (HomeDaum) item$iv$iv;
            destination$iv$iv.add(toSearchResult(it));
        }
        List home = (List) destination$iv$iv;
        HomePageList homePageList = new HomePageList(request2.getName(), home, z);
        if (page2 < response.getPages()) {
            z = true;
        }
        return MainAPIKt.newHomePageResponse(homePageList, Boxing.boxBoolean(z));
    }

    private final SearchResponse toSearchResult(HomeDaum $this$toSearchResult) {
        String href = $this$toSearchResult.getSlug();
        final String posterslug = $this$toSearchResult.getPoster();
        return MainAPIKt.newMovieSearchResponse$default(this, $this$toSearchResult.getTitle(), href, TvType.Movie, false, new Function1() { // from class: com.animecloud.Animecloud$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Animecloud.toSearchResult$lambda$0(this.f$0, posterslug, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(Animecloud this$0, String $posterslug, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl(MainAPIKt.fixUrlNull(this$0, this$0.getMainUrl() + "/img/posters/" + $posterslug));
        return Unit.INSTANCE;
    }

    @Nullable
    public Object quickSearch(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        return search(query, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00071 c00071;
        Object safe;
        Iterable data;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
            } else {
                c00071 = new C00071(continuation);
            }
        } else {
            c00071 = new C00071(continuation);
        }
        C00071 c00072 = c00071;
        Object $result = c00072.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00072.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String json = StringsKt.trimIndent("\n        {\n            \"q\": \"" + query + "\"\n        }\n        ");
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/api.v1.AnimeSearchService/SearchAnimes";
                RequestBody requestBodyCreate = RequestBody.Companion.create(json, MediaType.Companion.get("application/json"));
                c00072.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00072.L$1 = SpillingKt.nullOutSpilledVariable(json);
                c00072.label = 1;
                $result = Requests.post$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00072, 65278, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(SearchDaum.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        SearchDaum searchDaum = (SearchDaum) safe;
        if (searchDaum == null || (data = searchDaum.getData()) == null) {
            return null;
        }
        Iterable $this$map$iv = data;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Search it = (Search) item$iv$iv;
            destination$iv$iv.add(toSearchResponse(it));
        }
        List searchResponse = (List) destination$iv$iv;
        return searchResponse;
    }

    private final SearchResponse toSearchResponse(Search $this$toSearchResponse) {
        String title = $this$toSearchResponse.getTitle();
        final String poster = MainAPIKt.fixUrlNull(this, getMainUrl() + "/img/posters/" + $this$toSearchResponse.getPoster());
        String href = $this$toSearchResponse.getSlug();
        return MainAPIKt.newAnimeSearchResponse$default(this, title, href, TvType.TvSeries, false, new Function1() { // from class: com.animecloud.Animecloud$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Animecloud.toSearchResponse$lambda$0(poster, (AnimeSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResponse$lambda$0(String $poster, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($poster);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws ErrorLoadingException {
        C00031 c00031;
        String json;
        Object obj;
        Object objPost$default;
        String url2;
        Object safe;
        EpisodeParser episodeParser;
        Data document;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = new C00031(continuation);
            }
        } else {
            c00031 = new C00031(continuation);
        }
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String json2 = StringsKt.trimIndent("\n        {\n            \"slug\": \"" + StringsKt.substringAfterLast$default(url, "/", (String) null, 2, (Object) null) + "\"\n        }\n        ");
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/api.v1.anime.AnimeService/GetAnime";
                RequestBody requestBodyCreate = RequestBody.Companion.create(json2, MediaType.Companion.get("application/json"));
                c00032.L$0 = url;
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(json2);
                c00032.label = 1;
                json = json2;
                obj = coroutine_suspended;
                objPost$default = Requests.post$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00032, 65278, (Object) null);
                c00032 = c00032;
                if (objPost$default == obj) {
                    return obj;
                }
                url2 = url;
                NiceResponse this_$iv = (NiceResponse) objPost$default;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(EpisodeParser.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                episodeParser = (EpisodeParser) safe;
                if (episodeParser != null || (document = episodeParser.getData()) == null) {
                    throw new ErrorLoadingException("Failed to load anime");
                }
                String title = document.getTitle();
                String it = document.getPoster();
                String poster = it != null ? getMainUrl() + "/img/posters/" + it : null;
                String it2 = document.getBackdrop();
                String backgroundUrl = it2 != null ? getMainUrl() + "/img/posters/bg-" + it2 + ".webp" : null;
                List episodes = new ArrayList();
                Iterable $this$forEach$iv = document.getAnimeSeasons();
                int $i$f$forEach = 0;
                Iterator it3 = $this$forEach$iv.iterator();
                while (it3.hasNext()) {
                    Object element$iv = it3.next();
                    AnimeSeason seasonInfo = (AnimeSeason) element$iv;
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    String title2 = title;
                    final Integer season = StringsKt.contains(seasonInfo.getSeason(), "Filme", true) ? Boxing.boxInt(0) : StringsKt.toIntOrNull(seasonInfo.getSeason());
                    String searchSeason = (season == null || season.intValue() != 0) ? seasonInfo.getSeason() : "Filme";
                    for (Object element$iv2 : seasonInfo.getAnimeEpisodes()) {
                        final AnimeEpisode ep = (AnimeEpisode) element$iv2;
                        String url3 = url2;
                        final Integer episodeNumber = StringsKt.toIntOrNull(ep.getEpisode());
                        int $i$f$forEach2 = $i$f$forEach;
                        List episodes2 = episodes;
                        String href = getMainUrl() + "/&slug=" + document.getSlug() + "&season=" + searchSeason + "&episode=" + ep.getEpisode();
                        episodes2.add(MainAPIKt.newEpisode(this, href, new Function1() { // from class: com.animecloud.Animecloud$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj2) {
                                return Animecloud.load$lambda$2$0$0(ep, season, episodeNumber, this, (Episode) obj2);
                            }
                        }));
                        $i$f$forEach = $i$f$forEach2;
                        url2 = url3;
                        episodes = episodes2;
                        searchSeason = searchSeason;
                        it3 = it3;
                    }
                    $this$forEach$iv = $this$forEach$iv2;
                    title = title2;
                }
                TvType tvType = TvType.Anime;
                C00043 c00043 = new C00043(poster, backgroundUrl, document, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(json);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(document);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(title);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(episodes);
                c00032.label = 2;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title, url2, tvType, episodes, c00043, c00032);
                return $result == obj ? obj : $result;
            case 1:
                String json3 = (String) c00032.L$1;
                String url4 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                json = json3;
                objPost$default = $result;
                url2 = url4;
                NiceResponse this_$iv2 = (NiceResponse) objPost$default;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(EpisodeParser.class));
                episodeParser = (EpisodeParser) safe;
                if (episodeParser != null) {
                }
                throw new ErrorLoadingException("Failed to load anime");
            case 2:
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2$0$0(AnimeEpisode $ep, Integer $season, Integer $episodeNumber, Animecloud this$0, Episode $this$newEpisode) {
        $this$newEpisode.setName("Episode " + $ep.getEpisode());
        $this$newEpisode.setSeason($season);
        $this$newEpisode.setEpisode($episodeNumber);
        String it = $ep.getImage();
        $this$newEpisode.setPosterUrl(it != null ? this$0.getMainUrl() + "/img/thumbs/" + it : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.animecloud.Animecloud$load$3 */
    /* JADX INFO: compiled from: Animecloud.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animecloud.Animecloud$load$3", f = "Animecloud.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00043 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $backgroundUrl;
        final /* synthetic */ Data $document;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00043(String str, String str2, Data data, Continuation<? super C00043> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$backgroundUrl = str2;
            this.$document = data;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00043 = new C00043(this.$poster, this.$backgroundUrl, this.$document, continuation);
            c00043.L$0 = obj;
            return c00043;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setBackgroundPosterUrl(this.$backgroundUrl);
                    loadResponse.setPlot(this.$document.getDesc());
                    loadResponse.setTags(this.$document.getGeneres());
                    String it = this.$document.getImdb();
                    if (it != null) {
                        LoadResponse.Companion.addImdbUrl(loadResponse, it);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x01c5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00051 c00051;
        boolean z;
        Object obj;
        int i;
        C00051 c00052;
        String $result;
        Object obj2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String json;
        Object safe;
        Loadlinks loadlinks;
        LoadlinksData data2;
        List<AnimeEpisodeLink> animeEpisodeLinks;
        Object objAmap;
        String data3;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super SubtitleFile, Unit> function6;
        if (continuation instanceof C00051) {
            c00051 = (C00051) continuation;
            if ((c00051.label & Integer.MIN_VALUE) != 0) {
                c00051.label -= Integer.MIN_VALUE;
            } else {
                c00051 = new C00051(continuation);
            }
        } else {
            c00051 = new C00051(continuation);
        }
        Object $result2 = c00051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00051.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                String json2 = StringsKt.trimIndent("\n        {\n            \"slug\": \"" + StringsKt.substringBefore$default(StringsKt.substringAfterLast$default(data, "&slug=", (String) null, 2, (Object) null), "&", (String) null, 2, (Object) null) + "\",\n            \"season\": \"" + StringsKt.substringBefore$default(StringsKt.substringAfterLast$default(data, "&season=", (String) null, 2, (Object) null), "&", (String) null, 2, (Object) null) + "\",\n            \"episode\": \"" + StringsKt.substringBefore$default(StringsKt.substringAfterLast$default(data, "&episode=", (String) null, 2, (Object) null), "&", (String) null, 2, (Object) null) + "\"\n        }\n        ");
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/api.v1.anime.AnimeService/GetEpisode";
                RequestBody requestBodyCreate = RequestBody.Companion.create(json2, MediaType.Companion.get("application/json"));
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00051.L$1 = function1;
                c00051.L$2 = function2;
                c00051.L$3 = SpillingKt.nullOutSpilledVariable(json2);
                c00051.Z$0 = isCasting;
                c00051.label = 1;
                z = true;
                C00051 c00053 = c00051;
                obj = coroutine_suspended;
                i = 2;
                Object objPost$default = Requests.post$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00053, 65278, (Object) null);
                c00052 = c00053;
                if (objPost$default == obj) {
                    return obj;
                }
                $result = data;
                obj2 = objPost$default;
                isCasting2 = isCasting;
                function3 = function1;
                function4 = function2;
                json = json2;
                NiceResponse this_$iv = (NiceResponse) obj2;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Loadlinks.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                loadlinks = (Loadlinks) safe;
                if (loadlinks != null && (data2 = loadlinks.getData()) != null && (animeEpisodeLinks = data2.getAnimeEpisodeLinks()) != null) {
                    C00062 c00062 = new C00062(function3, function4, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable($result);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(json);
                    c00052.Z$0 = isCasting2;
                    c00052.label = i;
                    objAmap = ParCollectionsKt.amap(animeEpisodeLinks, c00062, c00052);
                    if (objAmap == obj) {
                        return obj;
                    }
                    String str2 = $result;
                    $result2 = objAmap;
                    data3 = str2;
                    function5 = function4;
                    function6 = function3;
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00051.Z$0;
                json = (String) c00051.L$3;
                function4 = (Function1) c00051.L$2;
                function3 = (Function1) c00051.L$1;
                String data4 = (String) c00051.L$0;
                ResultKt.throwOnFailure($result2);
                c00052 = c00051;
                obj = coroutine_suspended;
                i = 2;
                z = true;
                $result = data4;
                obj2 = $result2;
                NiceResponse this_$iv2 = (NiceResponse) obj2;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(Loadlinks.class));
                loadlinks = (Loadlinks) safe;
                if (loadlinks != null) {
                    C00062 c00063 = new C00062(function3, function4, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable($result);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(json);
                    c00052.Z$0 = isCasting2;
                    c00052.label = i;
                    objAmap = ParCollectionsKt.amap(animeEpisodeLinks, c00063, c00052);
                    if (objAmap == obj) {
                        return obj;
                    }
                    String str3 = $result;
                    $result2 = objAmap;
                    data3 = str3;
                    function5 = function4;
                    function6 = function3;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean z2 = c00051.Z$0;
                function5 = (Function1) c00051.L$2;
                function6 = (Function1) c00051.L$1;
                data3 = (String) c00051.L$0;
                ResultKt.throwOnFailure($result2);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.animecloud.Animecloud$loadLinks$2 */
    /* JADX INFO: compiled from: Animecloud.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/animecloud/AnimeEpisodeLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animecloud.Animecloud$loadLinks$2", f = "Animecloud.kt", i = {0, 0, 0}, l = {191}, m = "invokeSuspend", n = {"it", "dubtype", "href"}, nl = {192}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00062 extends SuspendLambda implements Function2<AnimeEpisodeLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00062(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00062> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00062 = Animecloud.this.new C00062(this.$subtitleCallback, this.$callback, continuation);
            c00062.L$0 = obj;
            return c00062;
        }

        public final Object invoke(AnimeEpisodeLink animeEpisodeLink, Continuation<? super Unit> continuation) {
            return create(animeEpisodeLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            AnimeEpisodeLink it = (AnimeEpisodeLink) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String dubtype = it.getLang();
                    String href = it.getLink();
                    StringBuilder sbAppend = new StringBuilder().append(Animecloud.this.getName()).append(' ');
                    String upperCase = dubtype.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(dubtype);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(href);
                    this.label = 1;
                    if (ParserKt.loadSourceNameExtractor(sbAppend.append(upperCase).toString(), href, "", this.$subtitleCallback, this.$callback, "1080P", (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }
}
