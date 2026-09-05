package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: MultiMoviesProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MultiMoviesProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002@AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u0004\u0018\u00010'*\u00020(H\u0002J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J*\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u00101J\u0018\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+JF\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u000e2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;092\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020;09H\u0096@¢\u0006\u0002\u0010>J\u000e\u0010?\u001a\u0004\u0018\u00010\u0005*\u00020(H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006B"}, d2 = {"Lcom/phisher98/MultiMoviesProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEmbed", "Lcom/lagradost/nicehttp/NiceResponse;", "postid", "nume", "referUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageAttr", "TrailerUrl", "ResponseHash", "MultiMoviesProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMultiMoviesProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiMoviesProvider.kt\ncom/phisher98/MultiMoviesProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,318:1\n1795#2,10:319\n2068#2:329\n2069#2:331\n1805#2:332\n1795#2,10:333\n2068#2:343\n2069#2:345\n1805#2:346\n1795#2,10:347\n2068#2:357\n2069#2:359\n1805#2:360\n1739#2:361\n1814#2,3:362\n1739#2:367\n1814#2,3:368\n1795#2,10:371\n2068#2:381\n2069#2:383\n1805#2:384\n1749#2:385\n1782#2,3:386\n1749#2:389\n1782#2,4:390\n1785#2:394\n1739#2:395\n1814#2,3:396\n1#3:330\n1#3:344\n1#3:358\n1#3:366\n1#3:382\n1#3:399\n68#4:365\n*S KotlinDebug\n*F\n+ 1 MultiMoviesProvider.kt\ncom/phisher98/MultiMoviesProvider\n*L\n83#1:319,10\n83#1:329\n83#1:331\n83#1:332\n87#1:333,10\n87#1:343\n87#1:345\n87#1:346\n114#1:347,10\n114#1:357\n114#1:359\n114#1:360\n168#1:361\n168#1:362,3\n193#1:367\n193#1:368,3\n202#1:371,10\n202#1:381\n202#1:383\n202#1:384\n207#1:385\n207#1:386,3\n208#1:389\n208#1:390,4\n207#1:394\n262#1:395\n262#1:396,3\n83#1:330\n87#1:344\n114#1:358\n202#1:382\n178#1:365\n*E\n"})
public final class MultiMoviesProvider extends MainAPI {

    @NotNull
    private String mainUrl = (String) BuildersKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new MultiMoviesProvider$mainUrl$1(null));

    @NotNull
    private String name = "MultiMovies";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime, TvType.AnimeMovie});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("trending/", "Trending"), TuplesKt.to("genre/bollywood-movies/", "Bollywood Movies"), TuplesKt.to("genre/hollywood/", "Hollywood Movies"), TuplesKt.to("genre/south-indian/", "South Indian Movies"), TuplesKt.to("genre/punjabi/", "Punjabi Movies"), TuplesKt.to("genre/amazon-prime/", "Amazon Prime"), TuplesKt.to("genre/disney-hotstar/", "Disney Hotstar"), TuplesKt.to("genre/jio-ott/", "Jio OTT"), TuplesKt.to("genre/netflix/", "Netfilx"), TuplesKt.to("genre/sony-liv/", "Sony Live"), TuplesKt.to("genre/k-drama/", "KDrama"), TuplesKt.to("genre/zee-5/", "Zee5"), TuplesKt.to("genre/anime-hindi/", "Anime Series"), TuplesKt.to("genre/anime-movies/", "Anime Movies"), TuplesKt.to("genre/cartoon-network/", "Cartoon Network"), TuplesKt.to("genre/disney-channel/", "Disney Channel"), TuplesKt.to("genre/hungama/", "Hungama")});

    /* JADX INFO: renamed from: com.phisher98.MultiMoviesProvider$getMainPage$1 */
    /* JADX INFO: compiled from: MultiMoviesProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.MultiMoviesProvider", f = "MultiMoviesProvider.kt", i = {0, 0, 1, 1}, l = {78, 80}, m = "getMainPage", n = {"request", "page", "request", "page"}, nl = {80, 77}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultiMoviesProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.MultiMoviesProvider$load$1 */
    /* JADX INFO: compiled from: MultiMoviesProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.MultiMoviesProvider", f = "MultiMoviesProvider.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {161, 177, 222, 240}, m = "load", n = {"url", "url", "doc", "titleL", "titleRegex", "titleClean", "title", "poster", "bgposter", "tags", "year", "description", "type", "trailerRegex", "trailer", "postId", "url", "doc", "titleL", "titleRegex", "titleClean", "title", "poster", "bgposter", "tags", "year", "description", "type", "trailerRegex", "trailer", "rating", "duration", "actors", "recommendations", "episodes", "url", "doc", "titleL", "titleRegex", "titleClean", "title", "poster", "bgposter", "tags", "year", "description", "type", "trailerRegex", "trailer", "rating", "duration", "actors", "recommendations", "episodes"}, nl = {162, 178, 240, 221}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultiMoviesProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.MultiMoviesProvider$loadLinks$1 */
    /* JADX INFO: compiled from: MultiMoviesProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.MultiMoviesProvider", f = "MultiMoviesProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {261, 268}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "req", "isCasting"}, nl = {268, 302}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultiMoviesProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.MultiMoviesProvider$search$1 */
    /* JADX INFO: compiled from: MultiMoviesProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.MultiMoviesProvider", f = "MultiMoviesProvider.kt", i = {0}, l = {113}, m = "search", n = {"query"}, nl = {114}, s = {"L$0"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultiMoviesProvider.this.search(null, (Continuation) this);
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

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x013a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0158  */
    /* JADX WARN: Code duplicated, block: B:31:0x016a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0178  */
    /* JADX WARN: Code duplicated, block: B:37:0x0196  */
    /* JADX WARN: Code duplicated, block: B:39:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:46:0x016f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x01ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00041 c00041;
        int i;
        C00041 c00042;
        Document document;
        Collection destination$iv$iv;
        List list;
        SearchResponse searchResult;
        Collection destination$iv$iv2;
        SearchResponse searchResult2;
        MainPageRequest request2 = request;
        if (continuation instanceof C00041) {
            c00041 = (C00041) continuation;
            if ((c00041.label & Integer.MIN_VALUE) != 0) {
                c00041.label -= Integer.MIN_VALUE;
            } else {
                c00041 = new C00041(continuation);
            }
        } else {
            c00041 = new C00041(continuation);
        }
        Object $result = c00041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00041.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (page != 1) {
                    C00041 c00043 = c00041;
                    i = 2;
                    Requests app = MainActivityKt.getApp();
                    String str = getMainUrl() + '/' + request2.getData() + "page/" + page + '/';
                    c00043.L$0 = request2;
                    c00043.I$0 = page;
                    c00043.label = 2;
                    $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00043, 4094, (Object) null);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    document = ((NiceResponse) $result).getDocument();
                    if (StringsKt.contains$default(request2.getData(), "/movies", false, i, (Object) null)) {
                        Iterable $this$mapNotNull$iv = document.select("#archive-content > article");
                        destination$iv$iv2 = new ArrayList();
                        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                            Element it = (Element) element$iv$iv$iv;
                            searchResult2 = toSearchResult(it);
                            if (searchResult2 != null) {
                                destination$iv$iv2.add(searchResult2);
                            }
                        }
                        list = (List) destination$iv$iv2;
                    } else {
                        Iterable $this$mapNotNull$iv2 = document.select("div.items > article");
                        destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
                            Element it2 = (Element) element$iv$iv$iv2;
                            searchResult = toSearchResult(it2);
                            if (searchResult != null) {
                                destination$iv$iv.add(searchResult);
                            }
                        }
                        list = (List) destination$iv$iv;
                    }
                    List home = list;
                    return MainAPIKt.newHomePageResponse$default(new HomePageList(request2.getName(), home, false, 4, (DefaultConstructorMarker) null), (Boolean) null, 2, (Object) null);
                }
                Requests app2 = MainActivityKt.getApp();
                String str2 = getMainUrl() + '/' + request2.getData();
                c00041.L$0 = request2;
                c00041.I$0 = page;
                c00041.label = 1;
                C00041 c00044 = c00041;
                i = 2;
                $result = Requests.get$default(app2, str2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00044, 4094, (Object) null);
                c00042 = c00044;
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                document = ((NiceResponse) $result).getDocument();
                if (StringsKt.contains$default(request2.getData(), "/movies", false, i, (Object) null)) {
                    Iterable $this$mapNotNull$iv3 = document.select("#archive-content > article");
                    destination$iv$iv2 = new ArrayList();
                    while (r13.hasNext()) {
                        Element it3 = (Element) element$iv$iv$iv;
                        searchResult2 = toSearchResult(it3);
                        if (searchResult2 != null) {
                            destination$iv$iv2.add(searchResult2);
                        }
                    }
                    list = (List) destination$iv$iv2;
                } else {
                    Iterable $this$mapNotNull$iv4 = document.select("div.items > article");
                    destination$iv$iv = new ArrayList();
                    while (r12.hasNext()) {
                        Element it4 = (Element) element$iv$iv$iv2;
                        searchResult = toSearchResult(it4);
                        if (searchResult != null) {
                            destination$iv$iv.add(searchResult);
                        }
                    }
                    list = (List) destination$iv$iv;
                }
                List home2 = list;
                return MainAPIKt.newHomePageResponse$default(new HomePageList(request2.getName(), home2, false, 4, (DefaultConstructorMarker) null), (Boolean) null, 2, (Object) null);
            case 1:
                int page2 = c00041.I$0;
                request2 = (MainPageRequest) c00041.L$0;
                ResultKt.throwOnFailure($result);
                c00042 = c00041;
                i = 2;
                document = ((NiceResponse) $result).getDocument();
                if (StringsKt.contains$default(request2.getData(), "/movies", false, i, (Object) null)) {
                    Iterable $this$mapNotNull$iv5 = document.select("#archive-content > article");
                    destination$iv$iv2 = new ArrayList();
                    while (r13.hasNext()) {
                        Element it5 = (Element) element$iv$iv$iv;
                        searchResult2 = toSearchResult(it5);
                        if (searchResult2 != null) {
                            destination$iv$iv2.add(searchResult2);
                        }
                    }
                    list = (List) destination$iv$iv2;
                } else {
                    Iterable $this$mapNotNull$iv6 = document.select("div.items > article");
                    destination$iv$iv = new ArrayList();
                    while (r12.hasNext()) {
                        Element it6 = (Element) element$iv$iv$iv2;
                        searchResult = toSearchResult(it6);
                        if (searchResult != null) {
                            destination$iv$iv.add(searchResult);
                        }
                    }
                    list = (List) destination$iv$iv;
                }
                List home3 = list;
                return MainAPIKt.newHomePageResponse$default(new HomePageList(request2.getName(), home3, false, 4, (DefaultConstructorMarker) null), (Boolean) null, 2, (Object) null);
            case 2:
                int i2 = c00041.I$0;
                request2 = (MainPageRequest) c00041.L$0;
                ResultKt.throwOnFailure($result);
                i = 2;
                document = ((NiceResponse) $result).getDocument();
                if (StringsKt.contains$default(request2.getData(), "/movies", false, i, (Object) null)) {
                    Iterable $this$mapNotNull$iv7 = document.select("#archive-content > article");
                    destination$iv$iv2 = new ArrayList();
                    while (r13.hasNext()) {
                        Element it7 = (Element) element$iv$iv$iv;
                        searchResult2 = toSearchResult(it7);
                        if (searchResult2 != null) {
                            destination$iv$iv2.add(searchResult2);
                        }
                    }
                    list = (List) destination$iv$iv2;
                } else {
                    Iterable $this$mapNotNull$iv8 = document.select("div.items > article");
                    destination$iv$iv = new ArrayList();
                    while (r12.hasNext()) {
                        Element it8 = (Element) element$iv$iv$iv2;
                        searchResult = toSearchResult(it8);
                        if (searchResult != null) {
                            destination$iv$iv.add(searchResult);
                        }
                    }
                    list = (List) destination$iv$iv;
                }
                List home4 = list;
                return MainAPIKt.newHomePageResponse$default(new HomePageList(request2.getName(), home4, false, 4, (DefaultConstructorMarker) null), (Boolean) null, 2, (Object) null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String strText;
        String title;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("div.data > h3 > a");
        if (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null || (title = StringsKt.trim(strText).toString()) == null) {
            return null;
        }
        MultiMoviesProvider multiMoviesProvider = this;
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("div.data > h3 > a");
        String href = MainAPIKt.fixUrl(multiMoviesProvider, String.valueOf(elementSelectFirst2 != null ? elementSelectFirst2.attr("href") : null));
        MultiMoviesProvider multiMoviesProvider2 = this;
        Element elementSelectFirst3 = $this$toSearchResult.selectFirst("div.poster > img");
        final String posterUrl = MainAPIKt.fixUrlNull(multiMoviesProvider2, elementSelectFirst3 != null ? getImageAttr(elementSelectFirst3) : null);
        final SearchQuality quality = MainAPIKt.getQualityFromString($this$toSearchResult.select("div.poster > div.mepo > span").text());
        if (StringsKt.contains$default(href, "Movie", false, 2, (Object) null)) {
            return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.phisher98.MultiMoviesProvider$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return MultiMoviesProvider.toSearchResult$lambda$0(posterUrl, quality, (MovieSearchResponse) obj);
                }
            }, 8, (Object) null);
        }
        return MainAPIKt.newTvSeriesSearchResponse$default(this, title, href, TvType.TvSeries, false, new Function1() { // from class: com.phisher98.MultiMoviesProvider$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return MultiMoviesProvider.toSearchResult$lambda$1(posterUrl, quality, (TvSeriesSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, SearchQuality $quality, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setQuality($quality);
        return Unit.INSTANCE;
    }

    static final Unit toSearchResult$lambda$1(String $posterUrl, SearchQuality $quality, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($posterUrl);
        $this$newTvSeriesSearchResponse.setQuality($quality);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00101 c00101;
        String query2;
        if (continuation instanceof C00101) {
            c00101 = (C00101) continuation;
            if ((c00101.label & Integer.MIN_VALUE) != 0) {
                c00101.label -= Integer.MIN_VALUE;
            } else {
                c00101 = new C00101(continuation);
            }
        } else {
            c00101 = new C00101(continuation);
        }
        Object $result = c00101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00101.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/?s=" + query;
                c00101.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00101.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00101, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                query2 = query;
                break;
                break;
            case 1:
                query2 = (String) c00101.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.result-item");
        int $i$f$mapNotNull = 0;
        Collection destination$iv$iv = new ArrayList();
        Iterable $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
        for (Object element$iv$iv$iv : $this$mapNotNullTo$iv$iv) {
            Element it = (Element) element$iv$iv$iv;
            Element elementSelectFirst = it.selectFirst("article > div.details > div.title > a");
            String title = StringsKt.trim(String.valueOf(elementSelectFirst != null ? elementSelectFirst.text() : null)).toString();
            MultiMoviesProvider multiMoviesProvider = this;
            Element elementSelectFirst2 = it.selectFirst("article > div.details > div.title > a");
            String href = MainAPIKt.fixUrl(multiMoviesProvider, String.valueOf(elementSelectFirst2 != null ? elementSelectFirst2.attr("href") : null));
            MultiMoviesProvider multiMoviesProvider2 = this;
            Element elementSelectFirst3 = it.selectFirst("article > div.image > div.thumbnail > a > img");
            final String posterUrl = MainAPIKt.fixUrlNull(multiMoviesProvider2, elementSelectFirst3 != null ? elementSelectFirst3.attr("src") : null);
            final SearchQuality quality = MainAPIKt.getQualityFromString(it.select("div.poster > div.mepo > span").text());
            String type = it.select("article > div.image > div.thumbnail > a > span").text();
            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            String query3 = query2;
            int $i$f$mapNotNull2 = $i$f$mapNotNull;
            Iterable $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
            SearchResponse searchResponseNewTvSeriesSearchResponse$default = StringsKt.contains$default(type, "Movie", false, 2, (Object) null) ? (SearchResponse) MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.phisher98.MultiMoviesProvider$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    return MultiMoviesProvider.search$lambda$0$0(posterUrl, quality, (MovieSearchResponse) obj);
                }
            }, 8, (Object) null) : MainAPIKt.newTvSeriesSearchResponse$default(this, title, href, TvType.TvSeries, false, new Function1() { // from class: com.phisher98.MultiMoviesProvider$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    return MultiMoviesProvider.search$lambda$0$1(posterUrl, quality, (TvSeriesSearchResponse) obj);
                }
            }, 8, (Object) null);
            if (searchResponseNewTvSeriesSearchResponse$default != null) {
                destination$iv$iv.add(searchResponseNewTvSeriesSearchResponse$default);
            }
            document = document;
            $this$mapNotNull$iv = $this$mapNotNull$iv2;
            query2 = query3;
            $i$f$mapNotNull = $i$f$mapNotNull2;
            $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(String $posterUrl, SearchQuality $quality, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setQuality($quality);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$1(String $posterUrl, SearchQuality $quality, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($posterUrl);
        $this$newTvSeriesSearchResponse.setQuality($quality);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getEmbed(String postid, String nume, String referUrl, Continuation<? super NiceResponse> continuation) {
        return Requests.post$default(MainActivityKt.getApp(), getMainUrl() + "/wp-admin/admin-ajax.php", (Map) null, referUrl, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, new FormBody.Builder((Charset) null, 1, (DefaultConstructorMarker) null).addEncoded("action", "doo_player_ajax").addEncoded("post", String.valueOf(postid)).addEncoded("nume", nume).addEncoded("type", "movie").build(), false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, continuation, 65274, (Object) null);
    }

    /* JADX INFO: compiled from: MultiMoviesProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0012\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/phisher98/MultiMoviesProvider$TrailerUrl;", "", "embedUrl", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "embed_url", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmbedUrl", "()Ljava/lang/String;", "setEmbedUrl", "(Ljava/lang/String;)V", "getType", "setType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "MultiMoviesProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class TrailerUrl {

        @Nullable
        private String embedUrl;

        @Nullable
        private String type;

        public static /* synthetic */ TrailerUrl copy$default(TrailerUrl trailerUrl, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = trailerUrl.embedUrl;
            }
            if ((i & 2) != 0) {
                str2 = trailerUrl.type;
            }
            return trailerUrl.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEmbedUrl() {
            return this.embedUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final TrailerUrl copy(@JsonProperty("embed_url") @Nullable String embedUrl, @JsonProperty("type") @Nullable String type) {
            return new TrailerUrl(embedUrl, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TrailerUrl)) {
                return false;
            }
            TrailerUrl trailerUrl = (TrailerUrl) other;
            return Intrinsics.areEqual(this.embedUrl, trailerUrl.embedUrl) && Intrinsics.areEqual(this.type, trailerUrl.type);
        }

        public int hashCode() {
            return ((this.embedUrl == null ? 0 : this.embedUrl.hashCode()) * 31) + (this.type != null ? this.type.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "TrailerUrl(embedUrl=" + this.embedUrl + ", type=" + this.type + ')';
        }

        public TrailerUrl(@JsonProperty("embed_url") @Nullable String embedUrl, @JsonProperty("type") @Nullable String type) {
            this.embedUrl = embedUrl;
            this.type = type;
        }

        @Nullable
        public final String getEmbedUrl() {
            return this.embedUrl;
        }

        public final void setEmbedUrl(@Nullable String str) {
            this.embedUrl = str;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        public final void setType(@Nullable String str) {
            this.type = str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0423  */
    /* JADX WARN: Code duplicated, block: B:104:0x0458  */
    /* JADX WARN: Code duplicated, block: B:106:0x0467  */
    /* JADX WARN: Code duplicated, block: B:109:0x0479  */
    /* JADX WARN: Code duplicated, block: B:110:0x047b  */
    /* JADX WARN: Code duplicated, block: B:113:0x0494  */
    /* JADX WARN: Code duplicated, block: B:120:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:124:0x04e0 A[LOOP:0: B:122:0x04da->B:124:0x04e0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:128:0x0560  */
    /* JADX WARN: Code duplicated, block: B:130:0x0574  */
    /* JADX WARN: Code duplicated, block: B:135:0x05ad  */
    /* JADX WARN: Code duplicated, block: B:137:0x05b5  */
    /* JADX WARN: Code duplicated, block: B:141:0x05ed  */
    /* JADX WARN: Code duplicated, block: B:143:0x05f5  */
    /* JADX WARN: Code duplicated, block: B:148:0x0666  */
    /* JADX WARN: Code duplicated, block: B:150:0x06fc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:151:0x06fd  */
    /* JADX WARN: Code duplicated, block: B:153:0x0718  */
    /* JADX WARN: Code duplicated, block: B:155:0x07ac A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:156:0x07ad  */
    /* JADX WARN: Code duplicated, block: B:168:0x0336 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x0579 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x05f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x024e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0250  */
    /* JADX WARN: Code duplicated, block: B:47:0x029f A[LOOP:4: B:45:0x0299->B:47:0x029f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:61:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:64:0x0305  */
    /* JADX WARN: Code duplicated, block: B:67:0x031d  */
    /* JADX WARN: Code duplicated, block: B:68:0x0320  */
    /* JADX WARN: Code duplicated, block: B:77:0x0384 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:78:0x0385  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:83:0x03c5 A[Catch: Exception -> 0x03dc, TRY_LEAVE, TryCatch #1 {Exception -> 0x03dc, blocks: (B:81:0x03ac, B:83:0x03c5), top: B:164:0x03ac }] */
    /* JADX WARN: Code duplicated, block: B:85:0x03d0  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00051 c00051;
        String str;
        String str2;
        Object obj;
        int i;
        Object obj2;
        String url2;
        Element elementSelectFirst;
        String strText;
        String titleClean;
        String str3;
        String title;
        String str4;
        String poster;
        String bgposter;
        Collection destination$iv$iv;
        List tags;
        Element elementSelectFirst2;
        String titleL;
        Integer numBoxInt;
        Integer year;
        Element elementSelectFirst3;
        String string;
        String description;
        Regex titleRegex;
        String titleClean2;
        String poster2;
        TvType tvType;
        TvType type;
        Regex trailerRegex;
        Ref.ObjectRef trailer;
        String title2;
        final MultiMoviesProvider multiMoviesProvider;
        String url3;
        Document doc;
        Ref.ObjectRef trailer2;
        String poster3;
        String bgposter2;
        Regex titleRegex2;
        String titleClean3;
        Integer year2;
        String description2;
        Ref.ObjectRef objectRef;
        String title3;
        List tags2;
        Regex trailerRegex2;
        String titleL2;
        Object embed;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef trailer3;
        String str5;
        Document doc2;
        Integer year3;
        String description3;
        String poster4;
        String poster5;
        String bgposter3;
        List tags3;
        String url4;
        Regex trailerRegex3;
        Ref.ObjectRef trailer4;
        String titleL3;
        String titleL4;
        TvType type2;
        String strText2;
        String strText3;
        String string2;
        MatchGroupCollection groups;
        List tags4;
        String title4;
        Integer year4;
        String str6;
        String url5;
        String it;
        String titleL5;
        String titleL6;
        String rating;
        Element elementSelectFirst4;
        Integer duration;
        Iterable $this$map$iv;
        Collection destination$iv$iv2;
        Ref.ObjectRef trailer5;
        String title5;
        String url6;
        List actors;
        Iterable $this$mapNotNull$iv;
        Collection destination$iv$iv3;
        List recommendations;
        ArrayList episodes;
        Iterable $this$mapIndexed$iv;
        int $i$f$mapIndexed;
        Collection destination$iv$iv4;
        Iterable $this$mapIndexedTo$iv$iv;
        int $i$f$mapIndexedTo;
        final int index$iv$iv;
        Iterator it2;
        Document doc3;
        Iterable $this$mapIndexed$iv2;
        Collection destination$iv$iv5;
        Iterable $this$mapIndexedTo$iv$iv2;
        int index$iv$iv2;
        SearchResponse searchResult;
        String strText4;
        String strRemoveSuffix;
        String string3;
        MatchResult matchResultFind$default;
        String value;
        String it3;
        String strFixUrlNull;
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
        C00051 c00052 = c00051;
        Object $result = c00052.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00052.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00052.L$0 = url;
                c00052.label = 1;
                str = "href";
                str2 = "src";
                obj = coroutine_suspended;
                i = 0;
                Object obj3 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00052, 4094, (Object) null);
                c00052 = c00052;
                if (obj3 == obj) {
                    return obj;
                }
                obj2 = obj3;
                url2 = url;
                Document doc4 = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = doc4.selectFirst("div.sheader > div.data > h1");
                if (elementSelectFirst != null || (strText = elementSelectFirst.text()) == null) {
                    return null;
                }
                String titleL7 = StringsKt.trim(strText).toString();
                if (titleL7 == null) {
                    return null;
                }
                Regex titleRegex3 = new Regex("(^.*\\)\\d*)");
                MatchResult matchResultFind$default2 = Regex.find$default(titleRegex3, titleL7, i, 2, (Object) null);
                if (matchResultFind$default2 != null && (groups = matchResultFind$default2.getGroups()) != null) {
                    MatchGroup matchGroup = groups.get(1);
                    String value2 = matchGroup != null ? matchGroup.getValue() : null;
                    titleClean = String.valueOf(value2);
                    if (Intrinsics.areEqual(titleClean, "null")) {
                        str3 = titleL7;
                    } else {
                        str3 = titleClean;
                    }
                    title = str3;
                    str4 = str2;
                    poster = MainAPIKt.fixUrlNull(this, doc4.select("div.poster img").attr(str4));
                    String str7 = str;
                    bgposter = MainAPIKt.fixUrlNull(this, doc4.select("div.g-item a").attr(str7));
                    Iterable $this$map$iv2 = doc4.select("div.sgeneros > a");
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    for (Object item$iv$iv : $this$map$iv2) {
                        destination$iv$iv.add(((Element) item$iv$iv).text());
                    }
                    tags = (List) destination$iv$iv;
                    elementSelectFirst2 = doc4.selectFirst("span.date");
                    if (elementSelectFirst2 == null && (strText3 = elementSelectFirst2.text()) != null) {
                        titleL = titleL7;
                        String strSubstringAfter$default = StringsKt.substringAfter$default(strText3, ",", (String) null, 2, (Object) null);
                        if (strSubstringAfter$default != null && (string2 = StringsKt.trim(strSubstringAfter$default).toString()) != null) {
                            numBoxInt = Boxing.boxInt(Integer.parseInt(string2));
                        }
                        year = numBoxInt;
                        elementSelectFirst3 = doc4.selectFirst("#info div.wp-content p");
                        if (elementSelectFirst3 != null || (strText2 = elementSelectFirst3.text()) == null) {
                            string = null;
                        } else {
                            string = StringsKt.trim(strText2).toString();
                        }
                        description = string;
                        titleRegex = titleRegex3;
                        titleClean2 = titleClean;
                        poster2 = str7;
                        if (StringsKt.contains$default(url2, "tvshows", false, 2, (Object) null)) {
                            tvType = TvType.TvSeries;
                        } else {
                            tvType = TvType.Movie;
                        }
                        type = tvType;
                        trailerRegex = new Regex("\"http.*\"");
                        trailer = new Ref.ObjectRef();
                        if (type == TvType.Movie) {
                            try {
                                String postId = doc4.select("#player-option-trailer").attr("data-post");
                                c00052.L$0 = url2;
                                c00052.L$1 = doc4;
                                title2 = str4;
                                try {
                                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(titleL);
                                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(titleRegex);
                                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(titleClean2);
                                    c00052.L$5 = title;
                                    c00052.L$6 = poster;
                                    c00052.L$7 = bgposter;
                                    c00052.L$8 = tags;
                                    c00052.L$9 = year;
                                    c00052.L$10 = description;
                                    c00052.L$11 = type;
                                    c00052.L$12 = trailerRegex;
                                    c00052.L$13 = trailer;
                                    c00052.L$14 = SpillingKt.nullOutSpilledVariable(postId);
                                    c00052.L$15 = trailer;
                                    c00052.L$16 = trailer;
                                    c00052.label = 2;
                                    multiMoviesProvider = this;
                                    try {
                                        embed = multiMoviesProvider.getEmbed(postId, "trailer", url2, c00052);
                                        if (embed == obj) {
                                            return obj;
                                        }
                                        url3 = url2;
                                        doc = doc4;
                                        poster3 = poster;
                                        bgposter2 = bgposter;
                                        titleRegex2 = titleRegex;
                                        titleClean3 = titleClean2;
                                        $result = embed;
                                        year2 = year;
                                        objectRef2 = trailer;
                                        objectRef = objectRef2;
                                        title3 = title;
                                        tags2 = tags;
                                        description2 = description;
                                        trailer3 = objectRef;
                                        trailerRegex2 = trailerRegex;
                                        titleL2 = titleL;
                                        try {
                                            NiceResponse embedResponse = (NiceResponse) $result;
                                            Ref.ObjectRef objectRef3 = objectRef2;
                                            ResponseParser parser = embedResponse.getParser();
                                            Intrinsics.checkNotNull(parser);
                                            trailer2 = trailer3;
                                            try {
                                                TrailerUrl parsed = (TrailerUrl) parser.parse(embedResponse.getText(), Reflection.getOrCreateKotlinClass(TrailerUrl.class));
                                                it3 = parsed.getEmbedUrl();
                                                if (it3 != null) {
                                                    strFixUrlNull = MainAPIKt.fixUrlNull(multiMoviesProvider, it3);
                                                } else {
                                                    strFixUrlNull = null;
                                                }
                                                objectRef = objectRef3;
                                                tags4 = tags2;
                                                title4 = title3;
                                                year4 = year2;
                                                str6 = strFixUrlNull;
                                                url5 = url3;
                                            } catch (Exception e) {
                                                tags4 = tags2;
                                                title4 = title3;
                                                year4 = year2;
                                                str6 = null;
                                                url5 = url3;
                                            }
                                        } catch (Exception e2) {
                                            trailer2 = trailer3;
                                        }
                                        tags3 = tags4;
                                        poster5 = poster3;
                                        year3 = year4;
                                        titleL4 = titleL2;
                                        description3 = description2;
                                        poster4 = title4;
                                        titleL3 = str6;
                                        trailer = objectRef;
                                        bgposter3 = bgposter2;
                                        str5 = title2;
                                        titleClean2 = titleClean3;
                                        titleRegex = titleRegex2;
                                        doc2 = doc;
                                        url4 = url5;
                                        trailerRegex3 = trailerRegex2;
                                        trailer4 = trailer2;
                                        type2 = type;
                                    } catch (Exception e3) {
                                        url3 = url2;
                                        doc = doc4;
                                        trailer2 = trailer;
                                        poster3 = poster;
                                        bgposter2 = bgposter;
                                        titleRegex2 = titleRegex;
                                        titleClean3 = titleClean2;
                                        year2 = year;
                                        description2 = description;
                                        objectRef = trailer2;
                                        title3 = title;
                                        tags2 = tags;
                                        trailerRegex2 = trailerRegex;
                                        titleL2 = titleL;
                                        tags4 = tags2;
                                        title4 = title3;
                                        year4 = year2;
                                        str6 = null;
                                        url5 = url3;
                                        tags3 = tags4;
                                        poster5 = poster3;
                                        year3 = year4;
                                        titleL4 = titleL2;
                                        description3 = description2;
                                        poster4 = title4;
                                        titleL3 = str6;
                                        trailer = objectRef;
                                        bgposter3 = bgposter2;
                                        str5 = title2;
                                        titleClean2 = titleClean3;
                                        titleRegex = titleRegex2;
                                        doc2 = doc;
                                        url4 = url5;
                                        trailerRegex3 = trailerRegex2;
                                        trailer4 = trailer2;
                                        type2 = type;
                                        trailer.element = titleL3;
                                        it = (String) trailer4.element;
                                        if (it != null) {
                                            titleL5 = titleL4;
                                            matchResultFind$default = Regex.find$default(trailerRegex3, it, 0, 2, (Object) null);
                                            if (matchResultFind$default != null) {
                                                titleL6 = null;
                                            } else {
                                                titleL6 = null;
                                            }
                                        } else {
                                            titleL5 = titleL4;
                                            titleL6 = null;
                                        }
                                        trailer4.element = titleL6;
                                        rating = doc2.select("span.dt_rating_vgs").text();
                                        elementSelectFirst4 = doc2.selectFirst("span.runtime");
                                        if (elementSelectFirst4 != null) {
                                            duration = null;
                                        } else {
                                            duration = null;
                                        }
                                        $this$map$iv = doc2.select("div.person");
                                        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                        for (Object item$iv$iv2 : $this$map$iv) {
                                            Iterable $this$map$iv3 = $this$map$iv;
                                            Element it4 = (Element) item$iv$iv2;
                                            destination$iv$iv2.add(new ActorData(new Actor(it4.select("div.data > div.name > a").text(), it4.select("div.img > a > img").attr(str5)), (ActorRole) null, it4.select("div.data > div.caracter").text(), (Actor) null, 10, (DefaultConstructorMarker) null));
                                            $this$map$iv = $this$map$iv3;
                                            trailer4 = trailer4;
                                            poster4 = poster4;
                                            url4 = url4;
                                        }
                                        trailer5 = trailer4;
                                        title5 = poster4;
                                        url6 = url4;
                                        actors = (List) destination$iv$iv2;
                                        $this$mapNotNull$iv = doc2.select("#dtw_content_related-2 article");
                                        destination$iv$iv3 = new ArrayList();
                                        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                            searchResult = multiMoviesProvider.toSearchResult((Element) element$iv$iv$iv);
                                            if (searchResult != null) {
                                                destination$iv$iv3.add(searchResult);
                                            }
                                            $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                        }
                                        recommendations = (List) destination$iv$iv3;
                                        episodes = new ArrayList();
                                        $this$mapIndexed$iv = doc2.select("#seasons ul.episodios");
                                        $i$f$mapIndexed = 0;
                                        destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                                        $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
                                        $i$f$mapIndexedTo = 0;
                                        index$iv$iv = 0;
                                        it2 = $this$mapIndexedTo$iv$iv.iterator();
                                        while (it2.hasNext()) {
                                            Object item$iv$iv3 = it2.next();
                                            int index$iv$iv3 = index$iv$iv + 1;
                                            if (index$iv$iv < 0) {
                                                CollectionsKt.throwIndexOverflow();
                                            }
                                            Document doc5 = doc2;
                                            Element me = (Element) item$iv$iv3;
                                            Iterable $this$mapIndexed$iv3 = $this$mapIndexed$iv;
                                            $this$mapIndexed$iv2 = me.select("li");
                                            int $i$f$mapIndexed2 = $i$f$mapIndexed;
                                            Iterable $this$mapIndexedTo$iv$iv3 = $this$mapIndexedTo$iv$iv;
                                            destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
                                            $this$mapIndexedTo$iv$iv2 = $this$mapIndexed$iv2;
                                            index$iv$iv2 = 0;
                                            for (Object item$iv$iv4 : $this$mapIndexedTo$iv$iv2) {
                                                int index$iv$iv4 = index$iv$iv2 + 1;
                                                if (index$iv$iv2 < 0) {
                                                    CollectionsKt.throwIndexOverflow();
                                                }
                                                final Element it5 = (Element) item$iv$iv4;
                                                Iterator it6 = it2;
                                                final int epNum = index$iv$iv2;
                                                destination$iv$iv5.add(Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode(multiMoviesProvider, it5.select("div.episodiotitle > a").attr(poster2), new Function1() { // from class: com.phisher98.MultiMoviesProvider$$ExternalSyntheticLambda0
                                                    public final Object invoke(Object obj4) {
                                                        return MultiMoviesProvider.load$lambda$5$0$0(it5, index$iv$iv, epNum, multiMoviesProvider, (Episode) obj4);
                                                    }
                                                }))));
                                                index$iv$iv2 = index$iv$iv4;
                                                $this$mapIndexed$iv2 = $this$mapIndexed$iv2;
                                                $this$mapIndexedTo$iv$iv2 = $this$mapIndexedTo$iv$iv2;
                                                $i$f$mapIndexedTo = $i$f$mapIndexedTo;
                                                it2 = it6;
                                            }
                                            destination$iv$iv4.add((List) destination$iv$iv5);
                                            index$iv$iv = index$iv$iv3;
                                            doc2 = doc5;
                                            $this$mapIndexed$iv = $this$mapIndexed$iv3;
                                            $i$f$mapIndexed = $i$f$mapIndexed2;
                                            $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv3;
                                        }
                                        doc3 = doc2;
                                        if (type2 != TvType.Movie) {
                                            C00075 c00075 = new C00075(poster5, bgposter3, year3, description3, tags3, rating, duration, actors, recommendations, trailer5, null);
                                            c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                                            c00052.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                                            c00052.L$2 = SpillingKt.nullOutSpilledVariable(titleL5);
                                            c00052.L$3 = SpillingKt.nullOutSpilledVariable(titleRegex);
                                            c00052.L$4 = SpillingKt.nullOutSpilledVariable(titleClean2);
                                            c00052.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                                            c00052.L$6 = SpillingKt.nullOutSpilledVariable(poster5);
                                            c00052.L$7 = SpillingKt.nullOutSpilledVariable(bgposter3);
                                            c00052.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                                            c00052.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00052.L$10 = SpillingKt.nullOutSpilledVariable(description3);
                                            c00052.L$11 = SpillingKt.nullOutSpilledVariable(type2);
                                            c00052.L$12 = SpillingKt.nullOutSpilledVariable(trailerRegex3);
                                            c00052.L$13 = SpillingKt.nullOutSpilledVariable(trailer5);
                                            c00052.L$14 = SpillingKt.nullOutSpilledVariable(rating);
                                            c00052.L$15 = SpillingKt.nullOutSpilledVariable(duration);
                                            c00052.L$16 = SpillingKt.nullOutSpilledVariable(actors);
                                            c00052.L$17 = SpillingKt.nullOutSpilledVariable(recommendations);
                                            c00052.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                                            c00052.label = 4;
                                            $result = MainAPIKt.newTvSeriesLoadResponse(multiMoviesProvider, title5, url6, TvType.TvSeries, episodes, c00075, c00052);
                                            if ($result == obj) {
                                                return obj;
                                            }
                                            return (LoadResponse) $result;
                                        }
                                        TvType tvType2 = TvType.Movie;
                                        C00064 c00064 = new C00064(poster5, bgposter3, year3, description3, tags3, rating, duration, actors, recommendations, trailer5, null);
                                        c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                                        c00052.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                                        c00052.L$2 = SpillingKt.nullOutSpilledVariable(titleL5);
                                        c00052.L$3 = SpillingKt.nullOutSpilledVariable(titleRegex);
                                        c00052.L$4 = SpillingKt.nullOutSpilledVariable(titleClean2);
                                        c00052.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                                        c00052.L$6 = SpillingKt.nullOutSpilledVariable(poster5);
                                        c00052.L$7 = SpillingKt.nullOutSpilledVariable(bgposter3);
                                        c00052.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                                        c00052.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00052.L$10 = SpillingKt.nullOutSpilledVariable(description3);
                                        c00052.L$11 = SpillingKt.nullOutSpilledVariable(type2);
                                        c00052.L$12 = SpillingKt.nullOutSpilledVariable(trailerRegex3);
                                        c00052.L$13 = SpillingKt.nullOutSpilledVariable(trailer5);
                                        c00052.L$14 = SpillingKt.nullOutSpilledVariable(rating);
                                        c00052.L$15 = SpillingKt.nullOutSpilledVariable(duration);
                                        c00052.L$16 = SpillingKt.nullOutSpilledVariable(actors);
                                        c00052.L$17 = SpillingKt.nullOutSpilledVariable(recommendations);
                                        c00052.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                                        c00052.label = 3;
                                        $result = MainAPIKt.newMovieLoadResponse(multiMoviesProvider, title5, url6, tvType2, url6, c00064, c00052);
                                        if ($result == obj) {
                                            return obj;
                                        }
                                        return (LoadResponse) $result;
                                    }
                                } catch (Exception e4) {
                                    multiMoviesProvider = this;
                                    url3 = url2;
                                    doc = doc4;
                                    trailer2 = trailer;
                                    poster3 = poster;
                                    bgposter2 = bgposter;
                                    titleRegex2 = titleRegex;
                                    titleClean3 = titleClean2;
                                    year2 = year;
                                    description2 = description;
                                    objectRef = trailer2;
                                    title3 = title;
                                    tags2 = tags;
                                    trailerRegex2 = trailerRegex;
                                    titleL2 = titleL;
                                    tags4 = tags2;
                                    title4 = title3;
                                    year4 = year2;
                                    str6 = null;
                                    url5 = url3;
                                    tags3 = tags4;
                                    poster5 = poster3;
                                    year3 = year4;
                                    titleL4 = titleL2;
                                    description3 = description2;
                                    poster4 = title4;
                                    titleL3 = str6;
                                    trailer = objectRef;
                                    bgposter3 = bgposter2;
                                    str5 = title2;
                                    titleClean2 = titleClean3;
                                    titleRegex = titleRegex2;
                                    doc2 = doc;
                                    url4 = url5;
                                    trailerRegex3 = trailerRegex2;
                                    trailer4 = trailer2;
                                    type2 = type;
                                    trailer.element = titleL3;
                                    it = (String) trailer4.element;
                                    if (it != null) {
                                        titleL5 = titleL4;
                                        matchResultFind$default = Regex.find$default(trailerRegex3, it, 0, 2, (Object) null);
                                        if (matchResultFind$default != null) {
                                            titleL6 = null;
                                        } else {
                                            titleL6 = null;
                                        }
                                    } else {
                                        titleL5 = titleL4;
                                        titleL6 = null;
                                    }
                                    trailer4.element = titleL6;
                                    rating = doc2.select("span.dt_rating_vgs").text();
                                    elementSelectFirst4 = doc2.selectFirst("span.runtime");
                                    if (elementSelectFirst4 != null) {
                                        duration = null;
                                    } else {
                                        duration = null;
                                    }
                                    $this$map$iv = doc2.select("div.person");
                                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                    while (r13.hasNext()) {
                                        Iterable $this$map$iv4 = $this$map$iv;
                                        Element it7 = (Element) item$iv$iv2;
                                        destination$iv$iv2.add(new ActorData(new Actor(it7.select("div.data > div.name > a").text(), it7.select("div.img > a > img").attr(str5)), (ActorRole) null, it7.select("div.data > div.caracter").text(), (Actor) null, 10, (DefaultConstructorMarker) null));
                                        $this$map$iv = $this$map$iv4;
                                        trailer4 = trailer4;
                                        poster4 = poster4;
                                        url4 = url4;
                                    }
                                    trailer5 = trailer4;
                                    title5 = poster4;
                                    url6 = url4;
                                    actors = (List) destination$iv$iv2;
                                    $this$mapNotNull$iv = doc2.select("#dtw_content_related-2 article");
                                    destination$iv$iv3 = new ArrayList();
                                    while (r10.hasNext()) {
                                        Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                                        searchResult = multiMoviesProvider.toSearchResult((Element) element$iv$iv$iv);
                                        if (searchResult != null) {
                                            destination$iv$iv3.add(searchResult);
                                        }
                                        $this$mapNotNull$iv = $this$mapNotNull$iv3;
                                    }
                                    recommendations = (List) destination$iv$iv3;
                                    episodes = new ArrayList();
                                    $this$mapIndexed$iv = doc2.select("#seasons ul.episodios");
                                    $i$f$mapIndexed = 0;
                                    destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                                    $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
                                    $i$f$mapIndexedTo = 0;
                                    index$iv$iv = 0;
                                    it2 = $this$mapIndexedTo$iv$iv.iterator();
                                    while (it2.hasNext()) {
                                        Object item$iv$iv5 = it2.next();
                                        int index$iv$iv5 = index$iv$iv + 1;
                                        if (index$iv$iv < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        Document doc6 = doc2;
                                        Element me2 = (Element) item$iv$iv5;
                                        Iterable $this$mapIndexed$iv4 = $this$mapIndexed$iv;
                                        $this$mapIndexed$iv2 = me2.select("li");
                                        int $i$f$mapIndexed3 = $i$f$mapIndexed;
                                        Iterable $this$mapIndexedTo$iv$iv4 = $this$mapIndexedTo$iv$iv;
                                        destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
                                        $this$mapIndexedTo$iv$iv2 = $this$mapIndexed$iv2;
                                        index$iv$iv2 = 0;
                                        while (r41.hasNext()) {
                                            int index$iv$iv6 = index$iv$iv2 + 1;
                                            if (index$iv$iv2 < 0) {
                                                CollectionsKt.throwIndexOverflow();
                                            }
                                            final Element it8 = (Element) item$iv$iv4;
                                            Iterator it9 = it2;
                                            final int epNum2 = index$iv$iv2;
                                            destination$iv$iv5.add(Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode(multiMoviesProvider, it8.select("div.episodiotitle > a").attr(poster2), new Function1() { // from class: com.phisher98.MultiMoviesProvider$$ExternalSyntheticLambda0
                                                public final Object invoke(Object obj4) {
                                                    return MultiMoviesProvider.load$lambda$5$0$0(it8, index$iv$iv, epNum2, multiMoviesProvider, (Episode) obj4);
                                                }
                                            }))));
                                            index$iv$iv2 = index$iv$iv6;
                                            $this$mapIndexed$iv2 = $this$mapIndexed$iv2;
                                            $this$mapIndexedTo$iv$iv2 = $this$mapIndexedTo$iv$iv2;
                                            $i$f$mapIndexedTo = $i$f$mapIndexedTo;
                                            it2 = it9;
                                        }
                                        destination$iv$iv4.add((List) destination$iv$iv5);
                                        index$iv$iv = index$iv$iv5;
                                        doc2 = doc6;
                                        $this$mapIndexed$iv = $this$mapIndexed$iv4;
                                        $i$f$mapIndexed = $i$f$mapIndexed3;
                                        $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv4;
                                    }
                                    doc3 = doc2;
                                    if (type2 != TvType.Movie) {
                                        C00075 c00076 = new C00075(poster5, bgposter3, year3, description3, tags3, rating, duration, actors, recommendations, trailer5, null);
                                        c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                                        c00052.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                                        c00052.L$2 = SpillingKt.nullOutSpilledVariable(titleL5);
                                        c00052.L$3 = SpillingKt.nullOutSpilledVariable(titleRegex);
                                        c00052.L$4 = SpillingKt.nullOutSpilledVariable(titleClean2);
                                        c00052.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                                        c00052.L$6 = SpillingKt.nullOutSpilledVariable(poster5);
                                        c00052.L$7 = SpillingKt.nullOutSpilledVariable(bgposter3);
                                        c00052.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                                        c00052.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00052.L$10 = SpillingKt.nullOutSpilledVariable(description3);
                                        c00052.L$11 = SpillingKt.nullOutSpilledVariable(type2);
                                        c00052.L$12 = SpillingKt.nullOutSpilledVariable(trailerRegex3);
                                        c00052.L$13 = SpillingKt.nullOutSpilledVariable(trailer5);
                                        c00052.L$14 = SpillingKt.nullOutSpilledVariable(rating);
                                        c00052.L$15 = SpillingKt.nullOutSpilledVariable(duration);
                                        c00052.L$16 = SpillingKt.nullOutSpilledVariable(actors);
                                        c00052.L$17 = SpillingKt.nullOutSpilledVariable(recommendations);
                                        c00052.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                                        c00052.label = 4;
                                        $result = MainAPIKt.newTvSeriesLoadResponse(multiMoviesProvider, title5, url6, TvType.TvSeries, episodes, c00076, c00052);
                                        if ($result == obj) {
                                            return obj;
                                        }
                                        return (LoadResponse) $result;
                                    }
                                    TvType tvType3 = TvType.Movie;
                                    C00064 c00065 = new C00064(poster5, bgposter3, year3, description3, tags3, rating, duration, actors, recommendations, trailer5, null);
                                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(titleL5);
                                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(titleRegex);
                                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(titleClean2);
                                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(poster5);
                                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(bgposter3);
                                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(description3);
                                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(type2);
                                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(trailerRegex3);
                                    c00052.L$13 = SpillingKt.nullOutSpilledVariable(trailer5);
                                    c00052.L$14 = SpillingKt.nullOutSpilledVariable(rating);
                                    c00052.L$15 = SpillingKt.nullOutSpilledVariable(duration);
                                    c00052.L$16 = SpillingKt.nullOutSpilledVariable(actors);
                                    c00052.L$17 = SpillingKt.nullOutSpilledVariable(recommendations);
                                    c00052.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                                    c00052.label = 3;
                                    $result = MainAPIKt.newMovieLoadResponse(multiMoviesProvider, title5, url6, tvType3, url6, c00065, c00052);
                                    if ($result == obj) {
                                        return obj;
                                    }
                                    return (LoadResponse) $result;
                                }
                            } catch (Exception e5) {
                                title2 = str4;
                            }
                            break;
                        } else {
                            multiMoviesProvider = this;
                            str5 = str4;
                            String iframeSrc = doc4.select("iframe.rptss").attr(str5);
                            String strFixUrlNull2 = MainAPIKt.fixUrlNull(multiMoviesProvider, iframeSrc);
                            doc2 = doc4;
                            year3 = year;
                            description3 = description;
                            poster4 = title;
                            poster5 = poster;
                            bgposter3 = bgposter;
                            tags3 = tags;
                            url4 = url2;
                            trailerRegex3 = trailerRegex;
                            trailer4 = trailer;
                            titleL3 = strFixUrlNull2;
                            titleL4 = titleL;
                            type2 = type;
                        }
                        trailer.element = titleL3;
                        it = (String) trailer4.element;
                        if (it != null) {
                            titleL5 = titleL4;
                            matchResultFind$default = Regex.find$default(trailerRegex3, it, 0, 2, (Object) null);
                            if (matchResultFind$default != null || (value = matchResultFind$default.getValue()) == null) {
                                titleL6 = null;
                            } else {
                                titleL6 = StringsKt.trim(value, new char[]{'\"'});
                            }
                        } else {
                            titleL5 = titleL4;
                            titleL6 = null;
                        }
                        trailer4.element = titleL6;
                        rating = doc2.select("span.dt_rating_vgs").text();
                        elementSelectFirst4 = doc2.selectFirst("span.runtime");
                        if (elementSelectFirst4 != null || (strText4 = elementSelectFirst4.text()) == null || (strRemoveSuffix = StringsKt.removeSuffix(strText4, " Min.")) == null || (string3 = StringsKt.trim(strRemoveSuffix).toString()) == null) {
                            duration = null;
                        } else {
                            duration = Boxing.boxInt(Integer.parseInt(string3));
                        }
                        $this$map$iv = doc2.select("div.person");
                        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        while (r13.hasNext()) {
                            Iterable $this$map$iv5 = $this$map$iv;
                            Element it10 = (Element) item$iv$iv2;
                            destination$iv$iv2.add(new ActorData(new Actor(it10.select("div.data > div.name > a").text(), it10.select("div.img > a > img").attr(str5)), (ActorRole) null, it10.select("div.data > div.caracter").text(), (Actor) null, 10, (DefaultConstructorMarker) null));
                            $this$map$iv = $this$map$iv5;
                            trailer4 = trailer4;
                            poster4 = poster4;
                            url4 = url4;
                        }
                        trailer5 = trailer4;
                        title5 = poster4;
                        url6 = url4;
                        actors = (List) destination$iv$iv2;
                        $this$mapNotNull$iv = doc2.select("#dtw_content_related-2 article");
                        destination$iv$iv3 = new ArrayList();
                        while (r10.hasNext()) {
                            Iterable $this$mapNotNull$iv4 = $this$mapNotNull$iv;
                            searchResult = multiMoviesProvider.toSearchResult((Element) element$iv$iv$iv);
                            if (searchResult != null) {
                                destination$iv$iv3.add(searchResult);
                            }
                            $this$mapNotNull$iv = $this$mapNotNull$iv4;
                        }
                        recommendations = (List) destination$iv$iv3;
                        episodes = new ArrayList();
                        $this$mapIndexed$iv = doc2.select("#seasons ul.episodios");
                        $i$f$mapIndexed = 0;
                        destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                        $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
                        $i$f$mapIndexedTo = 0;
                        index$iv$iv = 0;
                        it2 = $this$mapIndexedTo$iv$iv.iterator();
                        while (it2.hasNext()) {
                            Object item$iv$iv6 = it2.next();
                            int index$iv$iv7 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            Document doc7 = doc2;
                            Element me3 = (Element) item$iv$iv6;
                            Iterable $this$mapIndexed$iv5 = $this$mapIndexed$iv;
                            $this$mapIndexed$iv2 = me3.select("li");
                            int $i$f$mapIndexed4 = $i$f$mapIndexed;
                            Iterable $this$mapIndexedTo$iv$iv5 = $this$mapIndexedTo$iv$iv;
                            destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
                            $this$mapIndexedTo$iv$iv2 = $this$mapIndexed$iv2;
                            index$iv$iv2 = 0;
                            while (r41.hasNext()) {
                                int index$iv$iv8 = index$iv$iv2 + 1;
                                if (index$iv$iv2 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                final Element it11 = (Element) item$iv$iv4;
                                Iterator it12 = it2;
                                final int epNum3 = index$iv$iv2;
                                destination$iv$iv5.add(Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode(multiMoviesProvider, it11.select("div.episodiotitle > a").attr(poster2), new Function1() { // from class: com.phisher98.MultiMoviesProvider$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj4) {
                                        return MultiMoviesProvider.load$lambda$5$0$0(it11, index$iv$iv, epNum3, multiMoviesProvider, (Episode) obj4);
                                    }
                                }))));
                                index$iv$iv2 = index$iv$iv8;
                                $this$mapIndexed$iv2 = $this$mapIndexed$iv2;
                                $this$mapIndexedTo$iv$iv2 = $this$mapIndexedTo$iv$iv2;
                                $i$f$mapIndexedTo = $i$f$mapIndexedTo;
                                it2 = it12;
                            }
                            destination$iv$iv4.add((List) destination$iv$iv5);
                            index$iv$iv = index$iv$iv7;
                            doc2 = doc7;
                            $this$mapIndexed$iv = $this$mapIndexed$iv5;
                            $i$f$mapIndexed = $i$f$mapIndexed4;
                            $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv5;
                        }
                        doc3 = doc2;
                        if (type2 != TvType.Movie) {
                            C00075 c00077 = new C00075(poster5, bgposter3, year3, description3, tags3, rating, duration, actors, recommendations, trailer5, null);
                            c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                            c00052.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                            c00052.L$2 = SpillingKt.nullOutSpilledVariable(titleL5);
                            c00052.L$3 = SpillingKt.nullOutSpilledVariable(titleRegex);
                            c00052.L$4 = SpillingKt.nullOutSpilledVariable(titleClean2);
                            c00052.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                            c00052.L$6 = SpillingKt.nullOutSpilledVariable(poster5);
                            c00052.L$7 = SpillingKt.nullOutSpilledVariable(bgposter3);
                            c00052.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                            c00052.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                            c00052.L$10 = SpillingKt.nullOutSpilledVariable(description3);
                            c00052.L$11 = SpillingKt.nullOutSpilledVariable(type2);
                            c00052.L$12 = SpillingKt.nullOutSpilledVariable(trailerRegex3);
                            c00052.L$13 = SpillingKt.nullOutSpilledVariable(trailer5);
                            c00052.L$14 = SpillingKt.nullOutSpilledVariable(rating);
                            c00052.L$15 = SpillingKt.nullOutSpilledVariable(duration);
                            c00052.L$16 = SpillingKt.nullOutSpilledVariable(actors);
                            c00052.L$17 = SpillingKt.nullOutSpilledVariable(recommendations);
                            c00052.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                            c00052.label = 4;
                            $result = MainAPIKt.newTvSeriesLoadResponse(multiMoviesProvider, title5, url6, TvType.TvSeries, episodes, c00077, c00052);
                            if ($result == obj) {
                                return obj;
                            }
                            return (LoadResponse) $result;
                        }
                        TvType tvType4 = TvType.Movie;
                        C00064 c00066 = new C00064(poster5, bgposter3, year3, description3, tags3, rating, duration, actors, recommendations, trailer5, null);
                        c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00052.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                        c00052.L$2 = SpillingKt.nullOutSpilledVariable(titleL5);
                        c00052.L$3 = SpillingKt.nullOutSpilledVariable(titleRegex);
                        c00052.L$4 = SpillingKt.nullOutSpilledVariable(titleClean2);
                        c00052.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                        c00052.L$6 = SpillingKt.nullOutSpilledVariable(poster5);
                        c00052.L$7 = SpillingKt.nullOutSpilledVariable(bgposter3);
                        c00052.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                        c00052.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                        c00052.L$10 = SpillingKt.nullOutSpilledVariable(description3);
                        c00052.L$11 = SpillingKt.nullOutSpilledVariable(type2);
                        c00052.L$12 = SpillingKt.nullOutSpilledVariable(trailerRegex3);
                        c00052.L$13 = SpillingKt.nullOutSpilledVariable(trailer5);
                        c00052.L$14 = SpillingKt.nullOutSpilledVariable(rating);
                        c00052.L$15 = SpillingKt.nullOutSpilledVariable(duration);
                        c00052.L$16 = SpillingKt.nullOutSpilledVariable(actors);
                        c00052.L$17 = SpillingKt.nullOutSpilledVariable(recommendations);
                        c00052.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                        c00052.label = 3;
                        $result = MainAPIKt.newMovieLoadResponse(multiMoviesProvider, title5, url6, tvType4, url6, c00066, c00052);
                        if ($result == obj) {
                            return obj;
                        }
                        return (LoadResponse) $result;
                    }
                    titleL = titleL7;
                    numBoxInt = null;
                    year = numBoxInt;
                    elementSelectFirst3 = doc4.selectFirst("#info div.wp-content p");
                    if (elementSelectFirst3 != null) {
                        string = null;
                    } else {
                        string = null;
                    }
                    description = string;
                    titleRegex = titleRegex3;
                    titleClean2 = titleClean;
                    poster2 = str7;
                    if (StringsKt.contains$default(url2, "tvshows", false, 2, (Object) null)) {
                        tvType = TvType.TvSeries;
                    } else {
                        tvType = TvType.Movie;
                    }
                    type = tvType;
                    trailerRegex = new Regex("\"http.*\"");
                    trailer = new Ref.ObjectRef();
                    if (type == TvType.Movie) {
                        String postId2 = doc4.select("#player-option-trailer").attr("data-post");
                        c00052.L$0 = url2;
                        c00052.L$1 = doc4;
                        title2 = str4;
                        c00052.L$2 = SpillingKt.nullOutSpilledVariable(titleL);
                        c00052.L$3 = SpillingKt.nullOutSpilledVariable(titleRegex);
                        c00052.L$4 = SpillingKt.nullOutSpilledVariable(titleClean2);
                        c00052.L$5 = title;
                        c00052.L$6 = poster;
                        c00052.L$7 = bgposter;
                        c00052.L$8 = tags;
                        c00052.L$9 = year;
                        c00052.L$10 = description;
                        c00052.L$11 = type;
                        c00052.L$12 = trailerRegex;
                        c00052.L$13 = trailer;
                        c00052.L$14 = SpillingKt.nullOutSpilledVariable(postId2);
                        c00052.L$15 = trailer;
                        c00052.L$16 = trailer;
                        c00052.label = 2;
                        multiMoviesProvider = this;
                        embed = multiMoviesProvider.getEmbed(postId2, "trailer", url2, c00052);
                        if (embed == obj) {
                            return obj;
                        }
                        url3 = url2;
                        doc = doc4;
                        poster3 = poster;
                        bgposter2 = bgposter;
                        titleRegex2 = titleRegex;
                        titleClean3 = titleClean2;
                        $result = embed;
                        year2 = year;
                        objectRef2 = trailer;
                        objectRef = objectRef2;
                        title3 = title;
                        tags2 = tags;
                        description2 = description;
                        trailer3 = objectRef;
                        trailerRegex2 = trailerRegex;
                        titleL2 = titleL;
                        NiceResponse embedResponse2 = (NiceResponse) $result;
                        Ref.ObjectRef objectRef4 = objectRef2;
                        ResponseParser parser2 = embedResponse2.getParser();
                        Intrinsics.checkNotNull(parser2);
                        trailer2 = trailer3;
                        TrailerUrl parsed2 = (TrailerUrl) parser2.parse(embedResponse2.getText(), Reflection.getOrCreateKotlinClass(TrailerUrl.class));
                        it3 = parsed2.getEmbedUrl();
                        if (it3 != null) {
                            strFixUrlNull = MainAPIKt.fixUrlNull(multiMoviesProvider, it3);
                        } else {
                            strFixUrlNull = null;
                        }
                        objectRef = objectRef4;
                        tags4 = tags2;
                        title4 = title3;
                        year4 = year2;
                        str6 = strFixUrlNull;
                        url5 = url3;
                        tags3 = tags4;
                        poster5 = poster3;
                        year3 = year4;
                        titleL4 = titleL2;
                        description3 = description2;
                        poster4 = title4;
                        titleL3 = str6;
                        trailer = objectRef;
                        bgposter3 = bgposter2;
                        str5 = title2;
                        titleClean2 = titleClean3;
                        titleRegex = titleRegex2;
                        doc2 = doc;
                        url4 = url5;
                        trailerRegex3 = trailerRegex2;
                        trailer4 = trailer2;
                        type2 = type;
                        break;
                    } else {
                        multiMoviesProvider = this;
                        str5 = str4;
                        String iframeSrc2 = doc4.select("iframe.rptss").attr(str5);
                        String strFixUrlNull3 = MainAPIKt.fixUrlNull(multiMoviesProvider, iframeSrc2);
                        doc2 = doc4;
                        year3 = year;
                        description3 = description;
                        poster4 = title;
                        poster5 = poster;
                        bgposter3 = bgposter;
                        tags3 = tags;
                        url4 = url2;
                        trailerRegex3 = trailerRegex;
                        trailer4 = trailer;
                        titleL3 = strFixUrlNull3;
                        titleL4 = titleL;
                        type2 = type;
                    }
                    trailer.element = titleL3;
                    it = (String) trailer4.element;
                    if (it != null) {
                        titleL5 = titleL4;
                        matchResultFind$default = Regex.find$default(trailerRegex3, it, 0, 2, (Object) null);
                        if (matchResultFind$default != null) {
                            titleL6 = null;
                        } else {
                            titleL6 = null;
                        }
                    } else {
                        titleL5 = titleL4;
                        titleL6 = null;
                    }
                    trailer4.element = titleL6;
                    rating = doc2.select("span.dt_rating_vgs").text();
                    elementSelectFirst4 = doc2.selectFirst("span.runtime");
                    if (elementSelectFirst4 != null) {
                        duration = null;
                    } else {
                        duration = null;
                    }
                    $this$map$iv = doc2.select("div.person");
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    while (r13.hasNext()) {
                        Iterable $this$map$iv6 = $this$map$iv;
                        Element it13 = (Element) item$iv$iv2;
                        destination$iv$iv2.add(new ActorData(new Actor(it13.select("div.data > div.name > a").text(), it13.select("div.img > a > img").attr(str5)), (ActorRole) null, it13.select("div.data > div.caracter").text(), (Actor) null, 10, (DefaultConstructorMarker) null));
                        $this$map$iv = $this$map$iv6;
                        trailer4 = trailer4;
                        poster4 = poster4;
                        url4 = url4;
                    }
                    trailer5 = trailer4;
                    title5 = poster4;
                    url6 = url4;
                    actors = (List) destination$iv$iv2;
                    $this$mapNotNull$iv = doc2.select("#dtw_content_related-2 article");
                    destination$iv$iv3 = new ArrayList();
                    while (r10.hasNext()) {
                        Iterable $this$mapNotNull$iv5 = $this$mapNotNull$iv;
                        searchResult = multiMoviesProvider.toSearchResult((Element) element$iv$iv$iv);
                        if (searchResult != null) {
                            destination$iv$iv3.add(searchResult);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv5;
                    }
                    recommendations = (List) destination$iv$iv3;
                    episodes = new ArrayList();
                    $this$mapIndexed$iv = doc2.select("#seasons ul.episodios");
                    $i$f$mapIndexed = 0;
                    destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                    $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
                    $i$f$mapIndexedTo = 0;
                    index$iv$iv = 0;
                    it2 = $this$mapIndexedTo$iv$iv.iterator();
                    while (it2.hasNext()) {
                        Object item$iv$iv7 = it2.next();
                        int index$iv$iv9 = index$iv$iv + 1;
                        if (index$iv$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        Document doc8 = doc2;
                        Element me4 = (Element) item$iv$iv7;
                        Iterable $this$mapIndexed$iv6 = $this$mapIndexed$iv;
                        $this$mapIndexed$iv2 = me4.select("li");
                        int $i$f$mapIndexed5 = $i$f$mapIndexed;
                        Iterable $this$mapIndexedTo$iv$iv6 = $this$mapIndexedTo$iv$iv;
                        destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
                        $this$mapIndexedTo$iv$iv2 = $this$mapIndexed$iv2;
                        index$iv$iv2 = 0;
                        while (r41.hasNext()) {
                            int index$iv$iv10 = index$iv$iv2 + 1;
                            if (index$iv$iv2 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            final Element it14 = (Element) item$iv$iv4;
                            Iterator it15 = it2;
                            final int epNum4 = index$iv$iv2;
                            destination$iv$iv5.add(Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode(multiMoviesProvider, it14.select("div.episodiotitle > a").attr(poster2), new Function1() { // from class: com.phisher98.MultiMoviesProvider$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj4) {
                                    return MultiMoviesProvider.load$lambda$5$0$0(it14, index$iv$iv, epNum4, multiMoviesProvider, (Episode) obj4);
                                }
                            }))));
                            index$iv$iv2 = index$iv$iv10;
                            $this$mapIndexed$iv2 = $this$mapIndexed$iv2;
                            $this$mapIndexedTo$iv$iv2 = $this$mapIndexedTo$iv$iv2;
                            $i$f$mapIndexedTo = $i$f$mapIndexedTo;
                            it2 = it15;
                        }
                        destination$iv$iv4.add((List) destination$iv$iv5);
                        index$iv$iv = index$iv$iv9;
                        doc2 = doc8;
                        $this$mapIndexed$iv = $this$mapIndexed$iv6;
                        $i$f$mapIndexed = $i$f$mapIndexed5;
                        $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv6;
                    }
                    doc3 = doc2;
                    if (type2 != TvType.Movie) {
                        C00075 c00078 = new C00075(poster5, bgposter3, year3, description3, tags3, rating, duration, actors, recommendations, trailer5, null);
                        c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00052.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                        c00052.L$2 = SpillingKt.nullOutSpilledVariable(titleL5);
                        c00052.L$3 = SpillingKt.nullOutSpilledVariable(titleRegex);
                        c00052.L$4 = SpillingKt.nullOutSpilledVariable(titleClean2);
                        c00052.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                        c00052.L$6 = SpillingKt.nullOutSpilledVariable(poster5);
                        c00052.L$7 = SpillingKt.nullOutSpilledVariable(bgposter3);
                        c00052.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                        c00052.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                        c00052.L$10 = SpillingKt.nullOutSpilledVariable(description3);
                        c00052.L$11 = SpillingKt.nullOutSpilledVariable(type2);
                        c00052.L$12 = SpillingKt.nullOutSpilledVariable(trailerRegex3);
                        c00052.L$13 = SpillingKt.nullOutSpilledVariable(trailer5);
                        c00052.L$14 = SpillingKt.nullOutSpilledVariable(rating);
                        c00052.L$15 = SpillingKt.nullOutSpilledVariable(duration);
                        c00052.L$16 = SpillingKt.nullOutSpilledVariable(actors);
                        c00052.L$17 = SpillingKt.nullOutSpilledVariable(recommendations);
                        c00052.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                        c00052.label = 4;
                        $result = MainAPIKt.newTvSeriesLoadResponse(multiMoviesProvider, title5, url6, TvType.TvSeries, episodes, c00078, c00052);
                        if ($result == obj) {
                            return obj;
                        }
                        return (LoadResponse) $result;
                    }
                    TvType tvType5 = TvType.Movie;
                    C00064 c00067 = new C00064(poster5, bgposter3, year3, description3, tags3, rating, duration, actors, recommendations, trailer5, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(titleL5);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(titleRegex);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(titleClean2);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(poster5);
                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(bgposter3);
                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(description3);
                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(type2);
                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(trailerRegex3);
                    c00052.L$13 = SpillingKt.nullOutSpilledVariable(trailer5);
                    c00052.L$14 = SpillingKt.nullOutSpilledVariable(rating);
                    c00052.L$15 = SpillingKt.nullOutSpilledVariable(duration);
                    c00052.L$16 = SpillingKt.nullOutSpilledVariable(actors);
                    c00052.L$17 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00052.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00052.label = 3;
                    $result = MainAPIKt.newMovieLoadResponse(multiMoviesProvider, title5, url6, tvType5, url6, c00067, c00052);
                    if ($result == obj) {
                        return obj;
                    }
                    return (LoadResponse) $result;
                }
                titleClean = String.valueOf(value2);
                if (Intrinsics.areEqual(titleClean, "null")) {
                    str3 = titleL7;
                } else {
                    str3 = titleClean;
                }
                title = str3;
                str4 = str2;
                poster = MainAPIKt.fixUrlNull(this, doc4.select("div.poster img").attr(str4));
                String str8 = str;
                bgposter = MainAPIKt.fixUrlNull(this, doc4.select("div.g-item a").attr(str8));
                Iterable $this$map$iv7 = doc4.select("div.sgeneros > a");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv7, 10));
                while (r22.hasNext()) {
                    destination$iv$iv.add(((Element) item$iv$iv).text());
                }
                tags = (List) destination$iv$iv;
                elementSelectFirst2 = doc4.selectFirst("span.date");
                if (elementSelectFirst2 == null) {
                    titleL = titleL7;
                    numBoxInt = null;
                } else {
                    titleL = titleL7;
                    numBoxInt = null;
                }
                year = numBoxInt;
                elementSelectFirst3 = doc4.selectFirst("#info div.wp-content p");
                if (elementSelectFirst3 != null) {
                    string = null;
                } else {
                    string = null;
                }
                description = string;
                titleRegex = titleRegex3;
                titleClean2 = titleClean;
                poster2 = str8;
                if (StringsKt.contains$default(url2, "tvshows", false, 2, (Object) null)) {
                    tvType = TvType.TvSeries;
                } else {
                    tvType = TvType.Movie;
                }
                type = tvType;
                trailerRegex = new Regex("\"http.*\"");
                trailer = new Ref.ObjectRef();
                if (type == TvType.Movie) {
                    String postId3 = doc4.select("#player-option-trailer").attr("data-post");
                    c00052.L$0 = url2;
                    c00052.L$1 = doc4;
                    title2 = str4;
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(titleL);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(titleRegex);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(titleClean2);
                    c00052.L$5 = title;
                    c00052.L$6 = poster;
                    c00052.L$7 = bgposter;
                    c00052.L$8 = tags;
                    c00052.L$9 = year;
                    c00052.L$10 = description;
                    c00052.L$11 = type;
                    c00052.L$12 = trailerRegex;
                    c00052.L$13 = trailer;
                    c00052.L$14 = SpillingKt.nullOutSpilledVariable(postId3);
                    c00052.L$15 = trailer;
                    c00052.L$16 = trailer;
                    c00052.label = 2;
                    multiMoviesProvider = this;
                    embed = multiMoviesProvider.getEmbed(postId3, "trailer", url2, c00052);
                    if (embed == obj) {
                        return obj;
                    }
                    url3 = url2;
                    doc = doc4;
                    poster3 = poster;
                    bgposter2 = bgposter;
                    titleRegex2 = titleRegex;
                    titleClean3 = titleClean2;
                    $result = embed;
                    year2 = year;
                    objectRef2 = trailer;
                    objectRef = objectRef2;
                    title3 = title;
                    tags2 = tags;
                    description2 = description;
                    trailer3 = objectRef;
                    trailerRegex2 = trailerRegex;
                    titleL2 = titleL;
                    NiceResponse embedResponse3 = (NiceResponse) $result;
                    Ref.ObjectRef objectRef5 = objectRef2;
                    ResponseParser parser3 = embedResponse3.getParser();
                    Intrinsics.checkNotNull(parser3);
                    trailer2 = trailer3;
                    TrailerUrl parsed3 = (TrailerUrl) parser3.parse(embedResponse3.getText(), Reflection.getOrCreateKotlinClass(TrailerUrl.class));
                    it3 = parsed3.getEmbedUrl();
                    if (it3 != null) {
                        strFixUrlNull = MainAPIKt.fixUrlNull(multiMoviesProvider, it3);
                    } else {
                        strFixUrlNull = null;
                    }
                    objectRef = objectRef5;
                    tags4 = tags2;
                    title4 = title3;
                    year4 = year2;
                    str6 = strFixUrlNull;
                    url5 = url3;
                    tags3 = tags4;
                    poster5 = poster3;
                    year3 = year4;
                    titleL4 = titleL2;
                    description3 = description2;
                    poster4 = title4;
                    titleL3 = str6;
                    trailer = objectRef;
                    bgposter3 = bgposter2;
                    str5 = title2;
                    titleClean2 = titleClean3;
                    titleRegex = titleRegex2;
                    doc2 = doc;
                    url4 = url5;
                    trailerRegex3 = trailerRegex2;
                    trailer4 = trailer2;
                    type2 = type;
                    break;
                } else {
                    multiMoviesProvider = this;
                    str5 = str4;
                    String iframeSrc3 = doc4.select("iframe.rptss").attr(str5);
                    String strFixUrlNull4 = MainAPIKt.fixUrlNull(multiMoviesProvider, iframeSrc3);
                    doc2 = doc4;
                    year3 = year;
                    description3 = description;
                    poster4 = title;
                    poster5 = poster;
                    bgposter3 = bgposter;
                    tags3 = tags;
                    url4 = url2;
                    trailerRegex3 = trailerRegex;
                    trailer4 = trailer;
                    titleL3 = strFixUrlNull4;
                    titleL4 = titleL;
                    type2 = type;
                }
                trailer.element = titleL3;
                it = (String) trailer4.element;
                if (it != null) {
                    titleL5 = titleL4;
                    matchResultFind$default = Regex.find$default(trailerRegex3, it, 0, 2, (Object) null);
                    if (matchResultFind$default != null) {
                        titleL6 = null;
                    } else {
                        titleL6 = null;
                    }
                } else {
                    titleL5 = titleL4;
                    titleL6 = null;
                }
                trailer4.element = titleL6;
                rating = doc2.select("span.dt_rating_vgs").text();
                elementSelectFirst4 = doc2.selectFirst("span.runtime");
                if (elementSelectFirst4 != null) {
                    duration = null;
                } else {
                    duration = null;
                }
                $this$map$iv = doc2.select("div.person");
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r13.hasNext()) {
                    Iterable $this$map$iv8 = $this$map$iv;
                    Element it16 = (Element) item$iv$iv2;
                    destination$iv$iv2.add(new ActorData(new Actor(it16.select("div.data > div.name > a").text(), it16.select("div.img > a > img").attr(str5)), (ActorRole) null, it16.select("div.data > div.caracter").text(), (Actor) null, 10, (DefaultConstructorMarker) null));
                    $this$map$iv = $this$map$iv8;
                    trailer4 = trailer4;
                    poster4 = poster4;
                    url4 = url4;
                }
                trailer5 = trailer4;
                title5 = poster4;
                url6 = url4;
                actors = (List) destination$iv$iv2;
                $this$mapNotNull$iv = doc2.select("#dtw_content_related-2 article");
                destination$iv$iv3 = new ArrayList();
                while (r10.hasNext()) {
                    Iterable $this$mapNotNull$iv6 = $this$mapNotNull$iv;
                    searchResult = multiMoviesProvider.toSearchResult((Element) element$iv$iv$iv);
                    if (searchResult != null) {
                        destination$iv$iv3.add(searchResult);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv6;
                }
                recommendations = (List) destination$iv$iv3;
                episodes = new ArrayList();
                $this$mapIndexed$iv = doc2.select("#seasons ul.episodios");
                $i$f$mapIndexed = 0;
                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
                $i$f$mapIndexedTo = 0;
                index$iv$iv = 0;
                it2 = $this$mapIndexedTo$iv$iv.iterator();
                while (it2.hasNext()) {
                    Object item$iv$iv8 = it2.next();
                    int index$iv$iv11 = index$iv$iv + 1;
                    if (index$iv$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Document doc9 = doc2;
                    Element me5 = (Element) item$iv$iv8;
                    Iterable $this$mapIndexed$iv7 = $this$mapIndexed$iv;
                    $this$mapIndexed$iv2 = me5.select("li");
                    int $i$f$mapIndexed6 = $i$f$mapIndexed;
                    Iterable $this$mapIndexedTo$iv$iv7 = $this$mapIndexedTo$iv$iv;
                    destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
                    $this$mapIndexedTo$iv$iv2 = $this$mapIndexed$iv2;
                    index$iv$iv2 = 0;
                    while (r41.hasNext()) {
                        int index$iv$iv12 = index$iv$iv2 + 1;
                        if (index$iv$iv2 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        final Element it17 = (Element) item$iv$iv4;
                        Iterator it18 = it2;
                        final int epNum5 = index$iv$iv2;
                        destination$iv$iv5.add(Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode(multiMoviesProvider, it17.select("div.episodiotitle > a").attr(poster2), new Function1() { // from class: com.phisher98.MultiMoviesProvider$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj4) {
                                return MultiMoviesProvider.load$lambda$5$0$0(it17, index$iv$iv, epNum5, multiMoviesProvider, (Episode) obj4);
                            }
                        }))));
                        index$iv$iv2 = index$iv$iv12;
                        $this$mapIndexed$iv2 = $this$mapIndexed$iv2;
                        $this$mapIndexedTo$iv$iv2 = $this$mapIndexedTo$iv$iv2;
                        $i$f$mapIndexedTo = $i$f$mapIndexedTo;
                        it2 = it18;
                    }
                    destination$iv$iv4.add((List) destination$iv$iv5);
                    index$iv$iv = index$iv$iv11;
                    doc2 = doc9;
                    $this$mapIndexed$iv = $this$mapIndexed$iv7;
                    $i$f$mapIndexed = $i$f$mapIndexed6;
                    $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv7;
                }
                doc3 = doc2;
                if (type2 != TvType.Movie) {
                    C00075 c00079 = new C00075(poster5, bgposter3, year3, description3, tags3, rating, duration, actors, recommendations, trailer5, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(titleL5);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(titleRegex);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(titleClean2);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(poster5);
                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(bgposter3);
                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(description3);
                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(type2);
                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(trailerRegex3);
                    c00052.L$13 = SpillingKt.nullOutSpilledVariable(trailer5);
                    c00052.L$14 = SpillingKt.nullOutSpilledVariable(rating);
                    c00052.L$15 = SpillingKt.nullOutSpilledVariable(duration);
                    c00052.L$16 = SpillingKt.nullOutSpilledVariable(actors);
                    c00052.L$17 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00052.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00052.label = 4;
                    $result = MainAPIKt.newTvSeriesLoadResponse(multiMoviesProvider, title5, url6, TvType.TvSeries, episodes, c00079, c00052);
                    if ($result == obj) {
                        return obj;
                    }
                    return (LoadResponse) $result;
                }
                TvType tvType6 = TvType.Movie;
                C00064 c00068 = new C00064(poster5, bgposter3, year3, description3, tags3, rating, duration, actors, recommendations, trailer5, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(titleL5);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(titleRegex);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(titleClean2);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                c00052.L$6 = SpillingKt.nullOutSpilledVariable(poster5);
                c00052.L$7 = SpillingKt.nullOutSpilledVariable(bgposter3);
                c00052.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                c00052.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                c00052.L$10 = SpillingKt.nullOutSpilledVariable(description3);
                c00052.L$11 = SpillingKt.nullOutSpilledVariable(type2);
                c00052.L$12 = SpillingKt.nullOutSpilledVariable(trailerRegex3);
                c00052.L$13 = SpillingKt.nullOutSpilledVariable(trailer5);
                c00052.L$14 = SpillingKt.nullOutSpilledVariable(rating);
                c00052.L$15 = SpillingKt.nullOutSpilledVariable(duration);
                c00052.L$16 = SpillingKt.nullOutSpilledVariable(actors);
                c00052.L$17 = SpillingKt.nullOutSpilledVariable(recommendations);
                c00052.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                c00052.label = 3;
                $result = MainAPIKt.newMovieLoadResponse(multiMoviesProvider, title5, url6, tvType6, url6, c00068, c00052);
                if ($result == obj) {
                    return obj;
                }
                return (LoadResponse) $result;
            case 1:
                String url7 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                str = "href";
                str2 = "src";
                i = 0;
                url2 = url7;
                obj2 = $result;
                Document doc10 = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = doc10.selectFirst("div.sheader > div.data > h1");
                if (elementSelectFirst != null) {
                    break;
                }
                return null;
            case 2:
                Ref.ObjectRef objectRef6 = (Ref.ObjectRef) c00052.L$16;
                objectRef = (Ref.ObjectRef) c00052.L$15;
                Ref.ObjectRef trailer6 = (Ref.ObjectRef) c00052.L$13;
                trailerRegex2 = (Regex) c00052.L$12;
                type = (TvType) c00052.L$11;
                description2 = (String) c00052.L$10;
                year2 = (Integer) c00052.L$9;
                tags2 = (List) c00052.L$8;
                bgposter2 = (String) c00052.L$7;
                String poster6 = (String) c00052.L$6;
                String title6 = (String) c00052.L$5;
                titleClean3 = (String) c00052.L$4;
                titleRegex2 = (Regex) c00052.L$3;
                String titleL8 = (String) c00052.L$2;
                doc = (Document) c00052.L$1;
                url3 = (String) c00052.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    multiMoviesProvider = this;
                    trailer3 = trailer6;
                    obj = coroutine_suspended;
                    objectRef2 = objectRef6;
                    poster3 = poster6;
                    poster2 = "href";
                    title3 = title6;
                    title2 = "src";
                    titleL2 = titleL8;
                    NiceResponse embedResponse4 = (NiceResponse) $result;
                    Ref.ObjectRef objectRef7 = objectRef2;
                    ResponseParser parser4 = embedResponse4.getParser();
                    Intrinsics.checkNotNull(parser4);
                    trailer2 = trailer3;
                    TrailerUrl parsed4 = (TrailerUrl) parser4.parse(embedResponse4.getText(), Reflection.getOrCreateKotlinClass(TrailerUrl.class));
                    it3 = parsed4.getEmbedUrl();
                    if (it3 != null) {
                        strFixUrlNull = MainAPIKt.fixUrlNull(multiMoviesProvider, it3);
                    } else {
                        strFixUrlNull = null;
                    }
                    objectRef = objectRef7;
                    tags4 = tags2;
                    title4 = title3;
                    year4 = year2;
                    str6 = strFixUrlNull;
                    url5 = url3;
                    break;
                } catch (Exception e6) {
                    obj = coroutine_suspended;
                    trailer2 = trailer6;
                    poster3 = poster6;
                    multiMoviesProvider = this;
                    poster2 = "href";
                    title3 = title6;
                    title2 = "src";
                    titleL2 = titleL8;
                    tags4 = tags2;
                    title4 = title3;
                    year4 = year2;
                    str6 = null;
                    url5 = url3;
                    tags3 = tags4;
                    poster5 = poster3;
                    year3 = year4;
                    titleL4 = titleL2;
                    description3 = description2;
                    poster4 = title4;
                    titleL3 = str6;
                    trailer = objectRef;
                    bgposter3 = bgposter2;
                    str5 = title2;
                    titleClean2 = titleClean3;
                    titleRegex = titleRegex2;
                    doc2 = doc;
                    url4 = url5;
                    trailerRegex3 = trailerRegex2;
                    trailer4 = trailer2;
                    type2 = type;
                    trailer.element = titleL3;
                    it = (String) trailer4.element;
                    if (it != null) {
                        titleL5 = titleL4;
                        matchResultFind$default = Regex.find$default(trailerRegex3, it, 0, 2, (Object) null);
                        if (matchResultFind$default != null) {
                            titleL6 = null;
                        } else {
                            titleL6 = null;
                        }
                    } else {
                        titleL5 = titleL4;
                        titleL6 = null;
                    }
                    trailer4.element = titleL6;
                    rating = doc2.select("span.dt_rating_vgs").text();
                    elementSelectFirst4 = doc2.selectFirst("span.runtime");
                    if (elementSelectFirst4 != null) {
                        duration = null;
                    } else {
                        duration = null;
                    }
                    $this$map$iv = doc2.select("div.person");
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    while (r13.hasNext()) {
                        Iterable $this$map$iv9 = $this$map$iv;
                        Element it19 = (Element) item$iv$iv2;
                        destination$iv$iv2.add(new ActorData(new Actor(it19.select("div.data > div.name > a").text(), it19.select("div.img > a > img").attr(str5)), (ActorRole) null, it19.select("div.data > div.caracter").text(), (Actor) null, 10, (DefaultConstructorMarker) null));
                        $this$map$iv = $this$map$iv9;
                        trailer4 = trailer4;
                        poster4 = poster4;
                        url4 = url4;
                    }
                    trailer5 = trailer4;
                    title5 = poster4;
                    url6 = url4;
                    actors = (List) destination$iv$iv2;
                    $this$mapNotNull$iv = doc2.select("#dtw_content_related-2 article");
                    destination$iv$iv3 = new ArrayList();
                    while (r10.hasNext()) {
                        Iterable $this$mapNotNull$iv7 = $this$mapNotNull$iv;
                        searchResult = multiMoviesProvider.toSearchResult((Element) element$iv$iv$iv);
                        if (searchResult != null) {
                            destination$iv$iv3.add(searchResult);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv7;
                    }
                    recommendations = (List) destination$iv$iv3;
                    episodes = new ArrayList();
                    $this$mapIndexed$iv = doc2.select("#seasons ul.episodios");
                    $i$f$mapIndexed = 0;
                    destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                    $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
                    $i$f$mapIndexedTo = 0;
                    index$iv$iv = 0;
                    it2 = $this$mapIndexedTo$iv$iv.iterator();
                    while (it2.hasNext()) {
                        Object item$iv$iv9 = it2.next();
                        int index$iv$iv13 = index$iv$iv + 1;
                        if (index$iv$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        Document doc11 = doc2;
                        Element me6 = (Element) item$iv$iv9;
                        Iterable $this$mapIndexed$iv8 = $this$mapIndexed$iv;
                        $this$mapIndexed$iv2 = me6.select("li");
                        int $i$f$mapIndexed7 = $i$f$mapIndexed;
                        Iterable $this$mapIndexedTo$iv$iv8 = $this$mapIndexedTo$iv$iv;
                        destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
                        $this$mapIndexedTo$iv$iv2 = $this$mapIndexed$iv2;
                        index$iv$iv2 = 0;
                        while (r41.hasNext()) {
                            int index$iv$iv14 = index$iv$iv2 + 1;
                            if (index$iv$iv2 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            final Element it110 = (Element) item$iv$iv4;
                            Iterator it111 = it2;
                            final int epNum6 = index$iv$iv2;
                            destination$iv$iv5.add(Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode(multiMoviesProvider, it110.select("div.episodiotitle > a").attr(poster2), new Function1() { // from class: com.phisher98.MultiMoviesProvider$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj4) {
                                    return MultiMoviesProvider.load$lambda$5$0$0(it110, index$iv$iv, epNum6, multiMoviesProvider, (Episode) obj4);
                                }
                            }))));
                            index$iv$iv2 = index$iv$iv14;
                            $this$mapIndexed$iv2 = $this$mapIndexed$iv2;
                            $this$mapIndexedTo$iv$iv2 = $this$mapIndexedTo$iv$iv2;
                            $i$f$mapIndexedTo = $i$f$mapIndexedTo;
                            it2 = it111;
                        }
                        destination$iv$iv4.add((List) destination$iv$iv5);
                        index$iv$iv = index$iv$iv13;
                        doc2 = doc11;
                        $this$mapIndexed$iv = $this$mapIndexed$iv8;
                        $i$f$mapIndexed = $i$f$mapIndexed7;
                        $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv8;
                    }
                    doc3 = doc2;
                    if (type2 != TvType.Movie) {
                        C00075 c000710 = new C00075(poster5, bgposter3, year3, description3, tags3, rating, duration, actors, recommendations, trailer5, null);
                        c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00052.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                        c00052.L$2 = SpillingKt.nullOutSpilledVariable(titleL5);
                        c00052.L$3 = SpillingKt.nullOutSpilledVariable(titleRegex);
                        c00052.L$4 = SpillingKt.nullOutSpilledVariable(titleClean2);
                        c00052.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                        c00052.L$6 = SpillingKt.nullOutSpilledVariable(poster5);
                        c00052.L$7 = SpillingKt.nullOutSpilledVariable(bgposter3);
                        c00052.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                        c00052.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                        c00052.L$10 = SpillingKt.nullOutSpilledVariable(description3);
                        c00052.L$11 = SpillingKt.nullOutSpilledVariable(type2);
                        c00052.L$12 = SpillingKt.nullOutSpilledVariable(trailerRegex3);
                        c00052.L$13 = SpillingKt.nullOutSpilledVariable(trailer5);
                        c00052.L$14 = SpillingKt.nullOutSpilledVariable(rating);
                        c00052.L$15 = SpillingKt.nullOutSpilledVariable(duration);
                        c00052.L$16 = SpillingKt.nullOutSpilledVariable(actors);
                        c00052.L$17 = SpillingKt.nullOutSpilledVariable(recommendations);
                        c00052.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                        c00052.label = 4;
                        $result = MainAPIKt.newTvSeriesLoadResponse(multiMoviesProvider, title5, url6, TvType.TvSeries, episodes, c000710, c00052);
                        if ($result == obj) {
                            return obj;
                        }
                        return (LoadResponse) $result;
                    }
                    TvType tvType7 = TvType.Movie;
                    C00064 c00069 = new C00064(poster5, bgposter3, year3, description3, tags3, rating, duration, actors, recommendations, trailer5, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(titleL5);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(titleRegex);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(titleClean2);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(poster5);
                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(bgposter3);
                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(description3);
                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(type2);
                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(trailerRegex3);
                    c00052.L$13 = SpillingKt.nullOutSpilledVariable(trailer5);
                    c00052.L$14 = SpillingKt.nullOutSpilledVariable(rating);
                    c00052.L$15 = SpillingKt.nullOutSpilledVariable(duration);
                    c00052.L$16 = SpillingKt.nullOutSpilledVariable(actors);
                    c00052.L$17 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00052.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00052.label = 3;
                    $result = MainAPIKt.newMovieLoadResponse(multiMoviesProvider, title5, url6, tvType7, url6, c00069, c00052);
                    if ($result == obj) {
                        return obj;
                    }
                    return (LoadResponse) $result;
                }
                tags3 = tags4;
                poster5 = poster3;
                year3 = year4;
                titleL4 = titleL2;
                description3 = description2;
                poster4 = title4;
                titleL3 = str6;
                trailer = objectRef;
                bgposter3 = bgposter2;
                str5 = title2;
                titleClean2 = titleClean3;
                titleRegex = titleRegex2;
                doc2 = doc;
                url4 = url5;
                trailerRegex3 = trailerRegex2;
                trailer4 = trailer2;
                type2 = type;
                trailer.element = titleL3;
                it = (String) trailer4.element;
                if (it != null) {
                    titleL5 = titleL4;
                    matchResultFind$default = Regex.find$default(trailerRegex3, it, 0, 2, (Object) null);
                    if (matchResultFind$default != null) {
                        titleL6 = null;
                    } else {
                        titleL6 = null;
                    }
                } else {
                    titleL5 = titleL4;
                    titleL6 = null;
                }
                trailer4.element = titleL6;
                rating = doc2.select("span.dt_rating_vgs").text();
                elementSelectFirst4 = doc2.selectFirst("span.runtime");
                if (elementSelectFirst4 != null) {
                    duration = null;
                } else {
                    duration = null;
                }
                $this$map$iv = doc2.select("div.person");
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r13.hasNext()) {
                    Iterable $this$map$iv10 = $this$map$iv;
                    Element it112 = (Element) item$iv$iv2;
                    destination$iv$iv2.add(new ActorData(new Actor(it112.select("div.data > div.name > a").text(), it112.select("div.img > a > img").attr(str5)), (ActorRole) null, it112.select("div.data > div.caracter").text(), (Actor) null, 10, (DefaultConstructorMarker) null));
                    $this$map$iv = $this$map$iv10;
                    trailer4 = trailer4;
                    poster4 = poster4;
                    url4 = url4;
                }
                trailer5 = trailer4;
                title5 = poster4;
                url6 = url4;
                actors = (List) destination$iv$iv2;
                $this$mapNotNull$iv = doc2.select("#dtw_content_related-2 article");
                destination$iv$iv3 = new ArrayList();
                while (r10.hasNext()) {
                    Iterable $this$mapNotNull$iv8 = $this$mapNotNull$iv;
                    searchResult = multiMoviesProvider.toSearchResult((Element) element$iv$iv$iv);
                    if (searchResult != null) {
                        destination$iv$iv3.add(searchResult);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv8;
                }
                recommendations = (List) destination$iv$iv3;
                episodes = new ArrayList();
                $this$mapIndexed$iv = doc2.select("#seasons ul.episodios");
                $i$f$mapIndexed = 0;
                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
                $i$f$mapIndexedTo = 0;
                index$iv$iv = 0;
                it2 = $this$mapIndexedTo$iv$iv.iterator();
                while (it2.hasNext()) {
                    Object item$iv$iv10 = it2.next();
                    int index$iv$iv15 = index$iv$iv + 1;
                    if (index$iv$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Document doc12 = doc2;
                    Element me7 = (Element) item$iv$iv10;
                    Iterable $this$mapIndexed$iv9 = $this$mapIndexed$iv;
                    $this$mapIndexed$iv2 = me7.select("li");
                    int $i$f$mapIndexed8 = $i$f$mapIndexed;
                    Iterable $this$mapIndexedTo$iv$iv9 = $this$mapIndexedTo$iv$iv;
                    destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
                    $this$mapIndexedTo$iv$iv2 = $this$mapIndexed$iv2;
                    index$iv$iv2 = 0;
                    while (r41.hasNext()) {
                        int index$iv$iv16 = index$iv$iv2 + 1;
                        if (index$iv$iv2 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        final Element it113 = (Element) item$iv$iv4;
                        Iterator it114 = it2;
                        final int epNum7 = index$iv$iv2;
                        destination$iv$iv5.add(Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode(multiMoviesProvider, it113.select("div.episodiotitle > a").attr(poster2), new Function1() { // from class: com.phisher98.MultiMoviesProvider$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj4) {
                                return MultiMoviesProvider.load$lambda$5$0$0(it113, index$iv$iv, epNum7, multiMoviesProvider, (Episode) obj4);
                            }
                        }))));
                        index$iv$iv2 = index$iv$iv16;
                        $this$mapIndexed$iv2 = $this$mapIndexed$iv2;
                        $this$mapIndexedTo$iv$iv2 = $this$mapIndexedTo$iv$iv2;
                        $i$f$mapIndexedTo = $i$f$mapIndexedTo;
                        it2 = it114;
                    }
                    destination$iv$iv4.add((List) destination$iv$iv5);
                    index$iv$iv = index$iv$iv15;
                    doc2 = doc12;
                    $this$mapIndexed$iv = $this$mapIndexed$iv9;
                    $i$f$mapIndexed = $i$f$mapIndexed8;
                    $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv9;
                }
                doc3 = doc2;
                if (type2 != TvType.Movie) {
                    C00075 c000711 = new C00075(poster5, bgposter3, year3, description3, tags3, rating, duration, actors, recommendations, trailer5, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(titleL5);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(titleRegex);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(titleClean2);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(poster5);
                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(bgposter3);
                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(description3);
                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(type2);
                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(trailerRegex3);
                    c00052.L$13 = SpillingKt.nullOutSpilledVariable(trailer5);
                    c00052.L$14 = SpillingKt.nullOutSpilledVariable(rating);
                    c00052.L$15 = SpillingKt.nullOutSpilledVariable(duration);
                    c00052.L$16 = SpillingKt.nullOutSpilledVariable(actors);
                    c00052.L$17 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00052.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00052.label = 4;
                    $result = MainAPIKt.newTvSeriesLoadResponse(multiMoviesProvider, title5, url6, TvType.TvSeries, episodes, c000711, c00052);
                    if ($result == obj) {
                        return obj;
                    }
                    return (LoadResponse) $result;
                }
                TvType tvType8 = TvType.Movie;
                C00064 c000610 = new C00064(poster5, bgposter3, year3, description3, tags3, rating, duration, actors, recommendations, trailer5, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(titleL5);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(titleRegex);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(titleClean2);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                c00052.L$6 = SpillingKt.nullOutSpilledVariable(poster5);
                c00052.L$7 = SpillingKt.nullOutSpilledVariable(bgposter3);
                c00052.L$8 = SpillingKt.nullOutSpilledVariable(tags3);
                c00052.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                c00052.L$10 = SpillingKt.nullOutSpilledVariable(description3);
                c00052.L$11 = SpillingKt.nullOutSpilledVariable(type2);
                c00052.L$12 = SpillingKt.nullOutSpilledVariable(trailerRegex3);
                c00052.L$13 = SpillingKt.nullOutSpilledVariable(trailer5);
                c00052.L$14 = SpillingKt.nullOutSpilledVariable(rating);
                c00052.L$15 = SpillingKt.nullOutSpilledVariable(duration);
                c00052.L$16 = SpillingKt.nullOutSpilledVariable(actors);
                c00052.L$17 = SpillingKt.nullOutSpilledVariable(recommendations);
                c00052.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                c00052.label = 3;
                $result = MainAPIKt.newMovieLoadResponse(multiMoviesProvider, title5, url6, tvType8, url6, c000610, c00052);
                if ($result == obj) {
                    return obj;
                }
                return (LoadResponse) $result;
            case 3:
                ResultKt.throwOnFailure($result);
                return (LoadResponse) $result;
            case 4:
                ResultKt.throwOnFailure($result);
                return (LoadResponse) $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$5$0$0(Element $it, int $seasonNum, int $epNum, MultiMoviesProvider this$0, Episode $this$newEpisode) {
        $this$newEpisode.setName($it.select("div.episodiotitle > a").text());
        $this$newEpisode.setSeason(Integer.valueOf($seasonNum + 1));
        $this$newEpisode.setEpisode(Integer.valueOf($epNum + 1));
        Element elementSelectFirst = $it.selectFirst("div.imagen > img");
        $this$newEpisode.setPosterUrl(elementSelectFirst != null ? this$0.getImageAttr(elementSelectFirst) : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.MultiMoviesProvider$load$4 */
    /* JADX INFO: compiled from: MultiMoviesProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.MultiMoviesProvider$load$4", f = "MultiMoviesProvider.kt", i = {0}, l = {237}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {238}, s = {"L$0"}, v = 2)
    static final class C00064 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $bgposter;
        final /* synthetic */ String $description;
        final /* synthetic */ Integer $duration;
        final /* synthetic */ String $poster;
        final /* synthetic */ String $rating;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Ref.ObjectRef<String> $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00064(String str, String str2, Integer num, String str3, List<String> list, String str4, Integer num2, List<ActorData> list2, List<? extends SearchResponse> list3, Ref.ObjectRef<String> objectRef, Continuation<? super C00064> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$bgposter = str2;
            this.$year = num;
            this.$description = str3;
            this.$tags = list;
            this.$rating = str4;
            this.$duration = num2;
            this.$actors = list2;
            this.$recommendations = list3;
            this.$trailer = objectRef;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00064 = new C00064(this.$poster, this.$bgposter, this.$year, this.$description, this.$tags, this.$rating, this.$duration, this.$actors, this.$recommendations, this.$trailer, continuation);
            c00064.L$0 = obj;
            return c00064;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = this.$poster;
                    loadResponse.setPosterUrl(str != null ? StringsKt.trim(str).toString() : null);
                    String str2 = this.$bgposter;
                    if (str2 == null) {
                        str2 = this.$poster;
                    }
                    loadResponse.setBackgroundPosterUrl(str2);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setScore(Score.Companion.from10(this.$rating));
                    loadResponse.setDuration(this.$duration);
                    loadResponse.setActors(this.$actors);
                    loadResponse.setRecommendations(this.$recommendations);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(loadResponse);
                    this.label = 1;
                    if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, (String) this.$trailer.element, (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.MultiMoviesProvider$load$5 */
    /* JADX INFO: compiled from: MultiMoviesProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.MultiMoviesProvider$load$5", f = "MultiMoviesProvider.kt", i = {0}, l = {250}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {251}, s = {"L$0"}, v = 2)
    static final class C00075 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $bgposter;
        final /* synthetic */ String $description;
        final /* synthetic */ Integer $duration;
        final /* synthetic */ String $poster;
        final /* synthetic */ String $rating;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Ref.ObjectRef<String> $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00075(String str, String str2, Integer num, String str3, List<String> list, String str4, Integer num2, List<ActorData> list2, List<? extends SearchResponse> list3, Ref.ObjectRef<String> objectRef, Continuation<? super C00075> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$bgposter = str2;
            this.$year = num;
            this.$description = str3;
            this.$tags = list;
            this.$rating = str4;
            this.$duration = num2;
            this.$actors = list2;
            this.$recommendations = list3;
            this.$trailer = objectRef;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00075 = new C00075(this.$poster, this.$bgposter, this.$year, this.$description, this.$tags, this.$rating, this.$duration, this.$actors, this.$recommendations, this.$trailer, continuation);
            c00075.L$0 = obj;
            return c00075;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = this.$poster;
                    loadResponse.setPosterUrl(str != null ? StringsKt.trim(str).toString() : null);
                    String str2 = this.$bgposter;
                    if (str2 == null) {
                        str2 = this.$poster;
                    }
                    loadResponse.setBackgroundPosterUrl(str2);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setScore(Score.Companion.from10(this.$rating));
                    loadResponse.setDuration(this.$duration);
                    loadResponse.setActors(this.$actors);
                    loadResponse.setRecommendations(this.$recommendations);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(loadResponse);
                    this.label = 1;
                    if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, (String) this.$trailer.element, (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
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

    /* JADX WARN: Code duplicated, block: B:21:0x00e9 A[LOOP:0: B:19:0x00e3->B:21:0x00e9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:24:0x0157 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0158  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00081 c00081;
        Object obj;
        boolean z;
        C00081 c00082;
        String data2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Document req;
        Iterable $this$map$iv;
        int $i$f$map;
        Collection destination$iv$iv;
        C00093 c00093;
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
            } else {
                c00081 = new C00081(continuation);
            }
        } else {
            c00081 = new C00081(continuation);
        }
        Object $result = c00081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00081.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00081.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00081.L$1 = function1;
                c00081.L$2 = function2;
                c00081.Z$0 = isCasting;
                c00081.label = 1;
                C00081 c00083 = c00081;
                obj = coroutine_suspended;
                z = true;
                $result = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00083, 4094, (Object) null);
                c00082 = c00083;
                if ($result == obj) {
                    return obj;
                }
                data2 = data;
                isCasting2 = isCasting;
                function3 = function1;
                function4 = function2;
                req = ((NiceResponse) $result).getDocument();
                $this$map$iv = req.select("ul#playeroptionsul li");
                $i$f$map = 0;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Element it = (Element) item$iv$iv;
                    destination$iv$iv.add(new Triple(it.attr("data-post"), it.attr("data-nume"), it.attr("data-type")));
                    req = req;
                    $this$map$iv = $this$map$iv;
                    data2 = data2;
                    $i$f$map = $i$f$map;
                }
                Document req2 = req;
                c00093 = new C00093(function3, function4, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(req2);
                c00082.Z$0 = isCasting2;
                c00082.label = 2;
                if (ParCollectionsKt.amap((List) destination$iv$iv, c00093, c00082) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00081.Z$0;
                function4 = (Function1) c00081.L$2;
                function3 = (Function1) c00081.L$1;
                data2 = (String) c00081.L$0;
                ResultKt.throwOnFailure($result);
                c00082 = c00081;
                obj = coroutine_suspended;
                z = true;
                req = ((NiceResponse) $result).getDocument();
                $this$map$iv = req.select("ul#playeroptionsul li");
                $i$f$map = 0;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r14.hasNext()) {
                    Element it2 = (Element) item$iv$iv;
                    destination$iv$iv.add(new Triple(it2.attr("data-post"), it2.attr("data-nume"), it2.attr("data-type")));
                    req = req;
                    $this$map$iv = $this$map$iv;
                    data2 = data2;
                    $i$f$map = $i$f$map;
                }
                Document req3 = req;
                c00093 = new C00093(function3, function4, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(req3);
                c00082.Z$0 = isCasting2;
                c00082.label = 2;
                if (ParCollectionsKt.amap((List) destination$iv$iv, c00093, c00082) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean z2 = c00081.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.MultiMoviesProvider$loadLinks$3 */
    /* JADX INFO: compiled from: MultiMoviesProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012'\u0010\u0002\u001a#\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u0005\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u0005\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Triple;", "", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.MultiMoviesProvider$loadLinks$3", f = "MultiMoviesProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {270, 290, 292, 295}, m = "invokeSuspend", n = {"<destruct>", "id", "nume", "type", "<destruct>", "id", "nume", "type", "source", "link", "<destruct>", "id", "nume", "type", "source", "link", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "server", "<destruct>", "id", "nume", "type", "source", "link"}, nl = {280, 320, 322, 298}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$10", "L$11", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    @SourceDebugExtension({"SMAP\nMultiMoviesProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiMoviesProvider.kt\ncom/phisher98/MultiMoviesProvider$loadLinks$3\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,318:1\n68#2:319\n1739#3:320\n1814#3,3:321\n*S KotlinDebug\n*F\n+ 1 MultiMoviesProvider.kt\ncom/phisher98/MultiMoviesProvider$loadLinks$3\n*L\n280#1:319\n290#1:320\n290#1:321,3\n*E\n"})
    static final class C00093 extends SuspendLambda implements Function2<Triple<? extends String, ? extends String, ? extends String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00093(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00093> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00093 = MultiMoviesProvider.this.new C00093(this.$subtitleCallback, this.$callback, continuation);
            c00093.L$0 = obj;
            return c00093;
        }

        public final Object invoke(Triple<String, String, String> triple, Continuation<? super Unit> continuation) {
            return create(triple, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:38:0x02cf  */
        /* JADX WARN: Code duplicated, block: B:40:0x0342 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:41:0x0343  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0343 -> B:42:0x0360). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r40) {
            /*
                Method dump skipped, instruction units count: 1018
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.MultiMoviesProvider.C00093.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: MultiMoviesProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003JU\u0010\u0011\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/phisher98/MultiMoviesProvider$ResponseHash;", "", "embed_url", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "key", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmbed_url", "()Ljava/lang/String;", "getKey", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "MultiMoviesProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ResponseHash {

        @NotNull
        private final String embed_url;

        @Nullable
        private final String key;

        @Nullable
        private final String type;

        public static /* synthetic */ ResponseHash copy$default(ResponseHash responseHash, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = responseHash.embed_url;
            }
            if ((i & 2) != 0) {
                str2 = responseHash.key;
            }
            if ((i & 4) != 0) {
                str3 = responseHash.type;
            }
            return responseHash.copy(str, str2, str3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEmbed_url() {
            return this.embed_url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final ResponseHash copy(@JsonProperty("embed_url") @NotNull String embed_url, @JsonProperty("key") @Nullable String key, @JsonProperty("type") @Nullable String type) {
            return new ResponseHash(embed_url, key, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResponseHash)) {
                return false;
            }
            ResponseHash responseHash = (ResponseHash) other;
            return Intrinsics.areEqual(this.embed_url, responseHash.embed_url) && Intrinsics.areEqual(this.key, responseHash.key) && Intrinsics.areEqual(this.type, responseHash.type);
        }

        public int hashCode() {
            return (((this.embed_url.hashCode() * 31) + (this.key == null ? 0 : this.key.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "ResponseHash(embed_url=" + this.embed_url + ", key=" + this.key + ", type=" + this.type + ')';
        }

        public ResponseHash(@JsonProperty("embed_url") @NotNull String embed_url, @JsonProperty("key") @Nullable String key, @JsonProperty("type") @Nullable String type) {
            this.embed_url = embed_url;
            this.key = key;
            this.type = type;
        }

        public /* synthetic */ ResponseHash(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @NotNull
        public final String getEmbed_url() {
            return this.embed_url;
        }

        @Nullable
        public final String getKey() {
            return this.key;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }
    }

    private final String getImageAttr(Element $this$getImageAttr) {
        String it = $this$getImageAttr.attr("data-src");
        if (!(!StringsKt.isBlank(it) && StringsKt.startsWith$default(it, "http", false, 2, (Object) null))) {
            it = null;
        }
        if (it != null) {
            return it;
        }
        String it2 = $this$getImageAttr.attr("src");
        if (!StringsKt.isBlank(it2) && StringsKt.startsWith$default(it2, "http", false, 2, (Object) null)) {
            return it2;
        }
        return null;
    }
}
