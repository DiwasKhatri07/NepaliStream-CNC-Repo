package com.Animeav1;

import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.DubStatus;
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
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Animeav1.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Animeav1/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J\f\u0010(\u001a\u00020)*\u00020*H\u0002J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u001e2\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-J\f\u0010.\u001a\u00020\u001a*\u00020\u0005H\u0002J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-JF\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u000e2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208062\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020806H\u0096@¢\u0006\u0002\u0010;R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006<"}, d2 = {"Lcom/Animeav1/Animeav1;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toTvType", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Animeav1"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnimeav1.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animeav1.kt\ncom/Animeav1/Animeav1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,237:1\n1795#2,10:238\n2068#2:248\n2069#2:250\n1805#2:251\n1795#2,10:252\n2068#2:262\n2069#2:264\n1805#2:265\n1739#2:266\n1814#2,3:267\n296#2,2:270\n1#3:249\n1#3:263\n1#3:272\n*S KotlinDebug\n*F\n+ 1 Animeav1.kt\ncom/Animeav1/Animeav1\n*L\n52#1:238,10\n52#1:248\n52#1:250\n52#1:251\n74#1:252,10\n74#1:262\n74#1:264\n74#1:265\n94#1:266\n94#1:267,3\n153#1:270,2\n52#1:249\n74#1:263\n*E\n"})
public final class Animeav1 extends MainAPI {

    @NotNull
    private String mainUrl = "https://animeav1.com";

    @NotNull
    private String name = "AnimeAv1";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "es-mx";
    private final boolean hasDownloadSupport = true;
    private final boolean hasQuickSearch = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("catalogo?status=emision", "Emision"), TuplesKt.to("catalogo?status=finalizado", "Finalizado"), TuplesKt.to("catalogo?category=pelicula", "Pelicula"), TuplesKt.to("catalogo?category=ova", "OVA")});

    /* JADX INFO: renamed from: com.Animeav1.Animeav1$getMainPage$1 */
    /* JADX INFO: compiled from: Animeav1.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animeav1.Animeav1", f = "Animeav1.kt", i = {0, 0}, l = {51}, m = "getMainPage", n = {"request", "page"}, nl = {52}, s = {"L$0", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Animeav1.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Animeav1.Animeav1$load$1 */
    /* JADX INFO: compiled from: Animeav1.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animeav1.Animeav1", f = "Animeav1.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {89, 126, 134}, m = "load", n = {"url", "url", "document", "title", "poster", "description", "type", "tags", "year", "score", "href", "episodes", "mediaId", "scriptContent", "episodeZeroRegex", "regex", "match", "url", "document", "title", "poster", "description", "type", "tags", "year", "score", "href"}, nl = {90, 134, 99}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
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

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Animeav1.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Animeav1.Animeav1$loadLinks$1 */
    /* JADX INFO: compiled from: Animeav1.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animeav1.Animeav1", f = "Animeav1.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {150, 186, 196}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "scriptHtml", "embedsPattern", "embedsMatch", "embedsJson", "embedsObject", "subEmbeds", "dubEmbeds", "isCasting", "data", "subtitleCallback", "callback", "document", "scriptHtml", "embedsPattern", "embedsMatch", "embedsJson", "embedsObject", "subEmbeds", "dubEmbeds", "isCasting"}, nl = {154, 196, 206}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Animeav1.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Animeav1.Animeav1$search$1 */
    /* JADX INFO: compiled from: Animeav1.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animeav1.Animeav1", f = "Animeav1.kt", i = {0}, l = {73}, m = "search", n = {"query"}, nl = {74}, s = {"L$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Animeav1.this.search(null, (Continuation) this);
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
        C00001 c00001;
        boolean z;
        MainPageRequest request2;
        int page2 = page;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = new C00001(continuation);
            }
        } else {
            c00001 = new C00001(continuation);
        }
        Object $result = c00001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + '/' + request.getData() + "&page=" + page2;
                c00001.L$0 = request;
                c00001.I$0 = page2;
                c00001.label = 1;
                z = true;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("article");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            int page3 = page2;
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
            page2 = page3;
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), home, false), Boxing.boxBoolean(z));
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String title = $this$toSearchResult.select("h3").text();
        String href = $this$toSearchResult.select("a").attr("href");
        final String posterUrl = MainAPIKt.fixUrlNull(this, $this$toSearchResult.select("figure img").attr("src"));
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Animeav1.Animeav1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Animeav1.toSearchResult$lambda$0(posterUrl, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00071 c00071;
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
        Object $result = c00071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00071.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/catalogo?search=" + query;
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00071.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00071, 4094, (Object) null);
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
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("article");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List results = (List) destination$iv$iv;
        return results;
    }

    private final TvType toTvType(String $this$toTvType) {
        if (StringsKt.contains($this$toTvType, "TV Anime", true)) {
            return TvType.Anime;
        }
        if (StringsKt.contains($this$toTvType, "Película", true)) {
            return TvType.Movie;
        }
        return StringsKt.contains($this$toTvType, "OVA", true) ? TvType.Anime : TvType.Movie;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0117  */
    /* JADX WARN: Code duplicated, block: B:26:0x012f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0135  */
    /* JADX WARN: Code duplicated, block: B:31:0x0166 A[LOOP:0: B:29:0x0160->B:31:0x0166, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x01af  */
    /* JADX WARN: Code duplicated, block: B:40:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:43:0x0203  */
    /* JADX WARN: Code duplicated, block: B:45:0x0214  */
    /* JADX WARN: Code duplicated, block: B:46:0x0219  */
    /* JADX WARN: Code duplicated, block: B:49:0x0237 A[LOOP:1: B:49:0x0237->B:51:0x0292, LOOP_START, PHI: r0 r2 r4 r5 r6
      0x0237: PHI (r0v23 int) = (r0v22 int), (r0v24 int) binds: [B:48:0x0235, B:51:0x0292] A[DONT_GENERATE, DONT_INLINE]
      0x0237: PHI (r2v35 java.lang.String) = (r2v34 java.lang.String), (r2v43 java.lang.String) binds: [B:48:0x0235, B:51:0x0292] A[DONT_GENERATE, DONT_INLINE]
      0x0237: PHI (r4v5 java.lang.String) = (r4v2 java.lang.String), (r4v12 java.lang.String) binds: [B:48:0x0235, B:51:0x0292] A[DONT_GENERATE, DONT_INLINE]
      0x0237: PHI (r5v6 java.lang.String) = (r5v3 java.lang.String), (r5v15 java.lang.String) binds: [B:48:0x0235, B:51:0x0292] A[DONT_GENERATE, DONT_INLINE]
      0x0237: PHI (r6v9 kotlin.text.Regex) = (r6v7 kotlin.text.Regex), (r6v11 kotlin.text.Regex) binds: [B:48:0x0235, B:51:0x0292] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:51:0x0292 A[LOOP:1: B:49:0x0237->B:51:0x0292, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x029d  */
    /* JADX WARN: Code duplicated, block: B:53:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:56:0x033e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x033f  */
    /* JADX WARN: Code duplicated, block: B:59:0x034f  */
    /* JADX WARN: Code duplicated, block: B:61:0x03a9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:66:0x02ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object load(@NotNull String str, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        Object obj2;
        String str2;
        Document document;
        Element elementSelectFirst;
        String strText;
        String str3;
        String strAttr;
        Element elementSelectFirst2;
        String strText2;
        TvType tvType;
        ArrayList arrayList;
        Iterator it;
        ArrayList arrayList2;
        Integer intOrNull;
        String strText3;
        String strFixUrl;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        List list;
        Integer num;
        String str9;
        TvType tvType2;
        ArrayList arrayList3;
        MatchResult matchResultFind$default;
        String str10;
        String strHtml;
        Regex regex;
        MatchResult matchResultFind$default2;
        MatchResult matchResult;
        String str11;
        String str12;
        Regex regex2;
        Object objNewAnimeLoadResponse$default;
        Integer intOrNull2;
        int iIntValue;
        String str13;
        final int i;
        String str14;
        List groupValues;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = new C00011(continuation);
            }
        } else {
            c00011 = new C00011(continuation);
        }
        C00011 c00012 = c00011;
        Object objNewMovieLoadResponse = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                obj = coroutine_suspended;
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = str;
                c00012.label = 1;
                obj2 = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if (obj2 == obj) {
                    return obj;
                }
                str2 = str;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("article h1");
                if (elementSelectFirst != null || (strText = elementSelectFirst.text()) == null) {
                    strText = "Desconocido";
                }
                str3 = strText;
                strAttr = document.select("img.aspect-poster").attr("src");
                elementSelectFirst2 = document.selectFirst("div.entry.text-lead p");
                if (elementSelectFirst2 != null) {
                    strText2 = elementSelectFirst2.text();
                } else {
                    strText2 = null;
                }
                tvType = toTvType(document.select("header div.text-sm").text());
                Iterable iterableSelect = document.select("header a[href*=?genre=]");
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableSelect, 10));
                it = iterableSelect.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Element) it.next()).text());
                }
                arrayList2 = arrayList;
                intOrNull = StringsKt.toIntOrNull(document.select("header div.text-sm span:matches(\\d{4})").text());
                strText3 = document.select("article [class*=ic-star] .text-lead").text();
                strFixUrl = MainAPIKt.fixUrl(this, document.select("div.grid > article a").attr("href"));
                if (tvType == TvType.Anime) {
                    TvType tvType3 = TvType.AnimeMovie;
                    C00034 c00034 = new C00034(strAttr, strText2, arrayList2, intOrNull, strText3, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(str3);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(strAttr);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(strText2);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(tvType);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(arrayList2);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(intOrNull);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(strText3);
                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(strFixUrl);
                    c00012.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str3, str2, tvType3, strFixUrl, c00034, c00012);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    str4 = str3;
                    str5 = str2;
                    str6 = strFixUrl;
                    str7 = strAttr;
                    str8 = strText2;
                    list = arrayList2;
                    num = intOrNull;
                    str9 = strText3;
                    tvType2 = tvType;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                arrayList3 = new ArrayList();
                matchResultFind$default = Regex.find$default(new Regex("/(\\d+)\\.jpg$"), strAttr, 0, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str10 = (String) groupValues.get(1)) == null) {
                    str10 = "0";
                }
                strHtml = document.select("script").html();
                regex = new Regex("number:\\s*0");
                Regex regex3 = new Regex("media:\\{.*?episodesCount:(\\d+).*?slug:\"(.*?)\"", RegexOption.DOT_MATCHES_ALL);
                matchResultFind$default2 = Regex.find$default(regex3, strHtml, 0, 2, (Object) null);
                if (matchResultFind$default2 != null) {
                    intOrNull2 = StringsKt.toIntOrNull((String) matchResultFind$default2.getGroupValues().get(1));
                    if (intOrNull2 != null) {
                        iIntValue = intOrNull2.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    str13 = (String) matchResultFind$default2.getGroupValues().get(2);
                    matchResult = matchResultFind$default2;
                    i = !regex.containsMatchIn(strHtml) ? 1 : 0;
                    if (i <= iIntValue) {
                        while (true) {
                            str11 = str3;
                            str12 = str2;
                            String str15 = "https://animeav1.com/media/" + str13 + '/' + i;
                            str14 = str13;
                            final String str16 = "https://cdn.animeav1.com/screenshots/" + str10 + '/' + i + ".jpg";
                            regex2 = regex;
                            arrayList3.add(MainAPIKt.newEpisode(this, str15, new Function1() { // from class: com.Animeav1.Animeav1$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj3) {
                                    return Animeav1.load$lambda$1(i, str16, (Episode) obj3);
                                }
                            }));
                            if (i != iIntValue) {
                                i++;
                                str13 = str14;
                                str3 = str11;
                                str2 = str12;
                                regex = regex2;
                            }
                        }
                    } else {
                        str11 = str3;
                        str12 = str2;
                        regex2 = regex;
                    }
                } else {
                    matchResult = matchResultFind$default2;
                    str11 = str3;
                    str12 = str2;
                    regex2 = regex;
                }
                TvType tvType4 = TvType.Anime;
                C00023 c00023 = new C00023(arrayList3, strAttr, strText2, arrayList2, intOrNull, strText3, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(str11);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(strAttr);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(strText2);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(tvType);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(arrayList2);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(intOrNull);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(strText3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(strFixUrl);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(arrayList3);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(str10);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(strHtml);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(regex2);
                c00012.L$14 = SpillingKt.nullOutSpilledVariable(regex3);
                c00012.L$15 = SpillingKt.nullOutSpilledVariable(matchResult);
                c00012.label = 2;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, str11, str12, tvType4, false, c00023, c00012, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj) {
                    return obj;
                }
                return (LoadResponse) objNewAnimeLoadResponse$default;
            case 1:
                String str17 = (String) c00012.L$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                str2 = str17;
                obj = coroutine_suspended;
                obj2 = objNewMovieLoadResponse;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("article h1");
                if (elementSelectFirst != null) {
                    strText = "Desconocido";
                } else {
                    strText = "Desconocido";
                }
                str3 = strText;
                strAttr = document.select("img.aspect-poster").attr("src");
                elementSelectFirst2 = document.selectFirst("div.entry.text-lead p");
                if (elementSelectFirst2 != null) {
                    strText2 = elementSelectFirst2.text();
                } else {
                    strText2 = null;
                }
                tvType = toTvType(document.select("header div.text-sm").text());
                Iterable iterableSelect2 = document.select("header a[href*=?genre=]");
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableSelect2, 10));
                it = iterableSelect2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Element) it.next()).text());
                }
                arrayList2 = arrayList;
                intOrNull = StringsKt.toIntOrNull(document.select("header div.text-sm span:matches(\\d{4})").text());
                strText3 = document.select("article [class*=ic-star] .text-lead").text();
                strFixUrl = MainAPIKt.fixUrl(this, document.select("div.grid > article a").attr("href"));
                if (tvType == TvType.Anime) {
                    TvType tvType5 = TvType.AnimeMovie;
                    C00034 c00035 = new C00034(strAttr, strText2, arrayList2, intOrNull, strText3, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(str3);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(strAttr);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(strText2);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(tvType);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(arrayList2);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(intOrNull);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(strText3);
                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(strFixUrl);
                    c00012.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str3, str2, tvType5, strFixUrl, c00035, c00012);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    str4 = str3;
                    str5 = str2;
                    str6 = strFixUrl;
                    str7 = strAttr;
                    str8 = strText2;
                    list = arrayList2;
                    num = intOrNull;
                    str9 = strText3;
                    tvType2 = tvType;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                arrayList3 = new ArrayList();
                matchResultFind$default = Regex.find$default(new Regex("/(\\d+)\\.jpg$"), strAttr, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    str10 = "0";
                } else {
                    str10 = "0";
                }
                strHtml = document.select("script").html();
                regex = new Regex("number:\\s*0");
                Regex regex4 = new Regex("media:\\{.*?episodesCount:(\\d+).*?slug:\"(.*?)\"", RegexOption.DOT_MATCHES_ALL);
                matchResultFind$default2 = Regex.find$default(regex4, strHtml, 0, 2, (Object) null);
                if (matchResultFind$default2 != null) {
                    intOrNull2 = StringsKt.toIntOrNull((String) matchResultFind$default2.getGroupValues().get(1));
                    if (intOrNull2 != null) {
                        iIntValue = intOrNull2.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    str13 = (String) matchResultFind$default2.getGroupValues().get(2);
                    matchResult = matchResultFind$default2;
                    i = !regex.containsMatchIn(strHtml) ? 1 : 0;
                    if (i <= iIntValue) {
                        while (true) {
                            str11 = str3;
                            str12 = str2;
                            String str18 = "https://animeav1.com/media/" + str13 + '/' + i;
                            str14 = str13;
                            final String str19 = "https://cdn.animeav1.com/screenshots/" + str10 + '/' + i + ".jpg";
                            regex2 = regex;
                            arrayList3.add(MainAPIKt.newEpisode(this, str18, new Function1() { // from class: com.Animeav1.Animeav1$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj3) {
                                    return Animeav1.load$lambda$1(i, str19, (Episode) obj3);
                                }
                            }));
                            if (i != iIntValue) {
                                i++;
                                str13 = str14;
                                str3 = str11;
                                str2 = str12;
                                regex = regex2;
                            }
                        }
                    } else {
                        str11 = str3;
                        str12 = str2;
                        regex2 = regex;
                    }
                } else {
                    matchResult = matchResultFind$default2;
                    str11 = str3;
                    str12 = str2;
                    regex2 = regex;
                }
                TvType tvType6 = TvType.Anime;
                C00023 c00024 = new C00023(arrayList3, strAttr, strText2, arrayList2, intOrNull, strText3, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(str11);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(strAttr);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(strText2);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(tvType);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(arrayList2);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(intOrNull);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(strText3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(strFixUrl);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(arrayList3);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(str10);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(strHtml);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(regex2);
                c00012.L$14 = SpillingKt.nullOutSpilledVariable(regex4);
                c00012.L$15 = SpillingKt.nullOutSpilledVariable(matchResult);
                c00012.label = 2;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, str11, str12, tvType6, false, c00024, c00012, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj) {
                    return obj;
                }
                return (LoadResponse) objNewAnimeLoadResponse$default;
            case 2:
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                objNewAnimeLoadResponse$default = objNewMovieLoadResponse;
                return (LoadResponse) objNewAnimeLoadResponse$default;
            case 3:
                str6 = (String) c00012.L$9;
                str9 = (String) c00012.L$8;
                num = (Integer) c00012.L$7;
                list = (List) c00012.L$6;
                tvType2 = (TvType) c00012.L$5;
                str8 = (String) c00012.L$4;
                str7 = (String) c00012.L$3;
                str4 = (String) c00012.L$2;
                document = (Document) c00012.L$1;
                str5 = (String) c00012.L$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final Unit load$lambda$1(int $i, String $epposter, Episode $this$newEpisode) {
        $this$newEpisode.setName("Episode " + $i);
        $this$newEpisode.setEpisode(Integer.valueOf($i));
        $this$newEpisode.setPosterUrl($epposter);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Animeav1.Animeav1$load$3 */
    /* JADX INFO: compiled from: Animeav1.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animeav1.Animeav1$load$3", f = "Animeav1.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00023 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ List<Episode> $episodes;
        final /* synthetic */ String $poster;
        final /* synthetic */ String $score;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00023(List<Episode> list, String str, String str2, List<String> list2, Integer num, String str3, Continuation<? super C00023> continuation) {
            super(2, continuation);
            this.$episodes = list;
            this.$poster = str;
            this.$description = str2;
            this.$tags = list2;
            this.$year = num;
            this.$score = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00023 = new C00023(this.$episodes, this.$poster, this.$description, this.$tags, this.$year, this.$score, continuation);
            c00023.L$0 = obj;
            return c00023;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            AnimeLoadResponse $this$newAnimeLoadResponse = (AnimeLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    MainAPIKt.addEpisodes($this$newAnimeLoadResponse, DubStatus.Subbed, this.$episodes);
                    $this$newAnimeLoadResponse.setPosterUrl(this.$poster);
                    $this$newAnimeLoadResponse.setPlot(this.$description);
                    $this$newAnimeLoadResponse.setTags(this.$tags);
                    $this$newAnimeLoadResponse.setYear(this.$year);
                    $this$newAnimeLoadResponse.setScore(Score.Companion.from10(this.$score));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.Animeav1.Animeav1$load$4 */
    /* JADX INFO: compiled from: Animeav1.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animeav1.Animeav1$load$4", f = "Animeav1.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00034 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ String $score;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00034(String str, String str2, List<String> list, Integer num, String str3, Continuation<? super C00034> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$tags = list;
            this.$year = num;
            this.$score = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00034 = new C00034(this.$poster, this.$description, this.$tags, this.$year, this.$score, continuation);
            c00034.L$0 = obj;
            return c00034;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MovieLoadResponse $this$newMovieLoadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newMovieLoadResponse.setPosterUrl(this.$poster);
                    $this$newMovieLoadResponse.setPlot(this.$description);
                    $this$newMovieLoadResponse.setTags(this.$tags);
                    $this$newMovieLoadResponse.setYear(this.$year);
                    $this$newMovieLoadResponse.setScore(Score.Companion.from10(this.$score));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0137  */
    /* JADX WARN: Code duplicated, block: B:25:0x015c A[LOOP:0: B:20:0x0130->B:25:0x015c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x016d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0172  */
    /* JADX WARN: Code duplicated, block: B:32:0x0175  */
    /* JADX WARN: Code duplicated, block: B:35:0x018c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0191  */
    /* JADX WARN: Code duplicated, block: B:38:0x0194  */
    /* JADX WARN: Code duplicated, block: B:39:0x019b  */
    /* JADX WARN: Code duplicated, block: B:44:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:46:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:48:0x0204 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x0205  */
    /* JADX WARN: Code duplicated, block: B:52:0x0265 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x026d  */
    /* JADX WARN: Code duplicated, block: B:57:0x0163 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x015a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) throws JSONException {
        C00041 c00041;
        boolean z;
        Object $result;
        Object $result2;
        C00041 c00042;
        String data2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Object obj;
        boolean isCasting2;
        Document document;
        Iterator it;
        String data3;
        Object obj2;
        Element element;
        String scriptHtml;
        Regex embedsPattern;
        MatchResult matchResultFind$default;
        String embedsMatch;
        String embedsJson;
        String str;
        JSONObject embedsObject;
        List<Pair<String, String>> listLoadLinks$extractLinks;
        List<Pair<String, String>> listLoadLinks$extractLinks2;
        C00052 c00052;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super SubtitleFile, Unit> function6;
        Document document2;
        JSONObject embedsObject2;
        List<Pair<String, String>> list;
        String data4;
        String embedsMatch2;
        String scriptHtml2;
        List<Pair<String, String>> list2;
        Regex embedsPattern2;
        Object element$iv;
        Element it2;
        Object $result3;
        C00063 c00063;
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
        Object $result4 = c00041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00041.label) {
            case 0:
                ResultKt.throwOnFailure($result4);
                Requests app = MainActivityKt.getApp();
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00041.L$1 = function1;
                c00041.L$2 = function2;
                c00041.Z$0 = isCasting;
                c00041.label = 1;
                z = true;
                C00041 c00043 = c00041;
                $result = $result4;
                $result2 = coroutine_suspended;
                Object obj3 = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00043, 4094, (Object) null);
                c00042 = c00043;
                if (obj3 == $result2) {
                    return $result2;
                }
                data2 = data;
                function3 = function1;
                function4 = function2;
                obj = obj3;
                isCasting2 = isCasting;
                document = ((NiceResponse) obj).getDocument();
                Iterable $this$firstOrNull$iv = document.select("script");
                it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        it2 = (Element) element$iv;
                        $result3 = $result;
                        data3 = data2;
                        if (StringsKt.contains$default(it2.html(), "__sveltekit_", false, 2, (Object) null)) {
                            obj2 = element$iv;
                        } else {
                            data2 = data3;
                            $result = $result3;
                        }
                    } else {
                        data3 = data2;
                        obj2 = null;
                    }
                }
                element = (Element) obj2;
                if (element != null) {
                    scriptHtml = element.html();
                } else {
                    scriptHtml = null;
                }
                if (scriptHtml == null) {
                    scriptHtml = "";
                }
                embedsPattern = new Regex("embeds:\\s*\\{([^}]*\\{[^}]*\\})*[^}]*\\}", RegexOption.DOT_MATCHES_ALL);
                matchResultFind$default = Regex.find$default(embedsPattern, scriptHtml, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    embedsMatch = matchResultFind$default.getValue();
                } else {
                    embedsMatch = null;
                }
                if (embedsMatch != null) {
                    String it3 = embedsMatch;
                    embedsJson = loadLinks$cleanJsToJson(it3);
                } else {
                    embedsJson = null;
                }
                str = embedsJson;
                if (!(str != null || str.length() == 0)) {
                    embedsObject = new JSONObject(embedsJson);
                    listLoadLinks$extractLinks = loadLinks$extractLinks(embedsObject, "SUB");
                    listLoadLinks$extractLinks2 = loadLinks$extractLinks(embedsObject, "DUB");
                    c00052 = new C00052(function3, function4, null);
                    c00042.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00042.L$1 = function3;
                    c00042.L$2 = function4;
                    c00042.L$3 = SpillingKt.nullOutSpilledVariable(document);
                    c00042.L$4 = SpillingKt.nullOutSpilledVariable(scriptHtml);
                    c00042.L$5 = SpillingKt.nullOutSpilledVariable(embedsPattern);
                    c00042.L$6 = SpillingKt.nullOutSpilledVariable(embedsMatch);
                    c00042.L$7 = SpillingKt.nullOutSpilledVariable(embedsJson);
                    c00042.L$8 = SpillingKt.nullOutSpilledVariable(embedsObject);
                    c00042.L$9 = SpillingKt.nullOutSpilledVariable(listLoadLinks$extractLinks);
                    c00042.L$10 = listLoadLinks$extractLinks2;
                    c00042.Z$0 = isCasting2;
                    c00042.label = 2;
                    if (ParCollectionsKt.amap(listLoadLinks$extractLinks, c00052, c00042) == $result2) {
                        return $result2;
                    }
                    function5 = function4;
                    function6 = function3;
                    document2 = document;
                    embedsObject2 = embedsObject;
                    list = listLoadLinks$extractLinks2;
                    data4 = data3;
                    embedsMatch2 = embedsMatch;
                    scriptHtml2 = scriptHtml;
                    list2 = listLoadLinks$extractLinks;
                    embedsPattern2 = embedsPattern;
                    c00063 = new C00063(function6, function5, null);
                    c00042.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00042.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                    c00042.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                    c00042.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                    c00042.L$4 = SpillingKt.nullOutSpilledVariable(scriptHtml2);
                    c00042.L$5 = SpillingKt.nullOutSpilledVariable(embedsPattern2);
                    c00042.L$6 = SpillingKt.nullOutSpilledVariable(embedsMatch2);
                    c00042.L$7 = SpillingKt.nullOutSpilledVariable(embedsJson);
                    c00042.L$8 = SpillingKt.nullOutSpilledVariable(embedsObject2);
                    c00042.L$9 = SpillingKt.nullOutSpilledVariable(list2);
                    c00042.L$10 = SpillingKt.nullOutSpilledVariable(list);
                    c00042.Z$0 = isCasting2;
                    c00042.label = 3;
                    if (ParCollectionsKt.amap(list, c00063, c00042) == $result2) {
                        return $result2;
                    }
                }
                return Boxing.boxBoolean(z);
            case 1:
                boolean isCasting3 = c00041.Z$0;
                function4 = (Function1) c00041.L$2;
                function3 = (Function1) c00041.L$1;
                data2 = (String) c00041.L$0;
                ResultKt.throwOnFailure($result4);
                obj = $result4;
                z = true;
                isCasting2 = isCasting3;
                $result2 = coroutine_suspended;
                c00042 = c00041;
                $result = obj;
                document = ((NiceResponse) obj).getDocument();
                Iterable $this$firstOrNull$iv2 = document.select("script");
                it = $this$firstOrNull$iv2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        it2 = (Element) element$iv;
                        $result3 = $result;
                        data3 = data2;
                        if (StringsKt.contains$default(it2.html(), "__sveltekit_", false, 2, (Object) null)) {
                            obj2 = element$iv;
                        } else {
                            data2 = data3;
                            $result = $result3;
                        }
                    } else {
                        data3 = data2;
                        obj2 = null;
                    }
                }
                element = (Element) obj2;
                if (element != null) {
                    scriptHtml = element.html();
                } else {
                    scriptHtml = null;
                }
                if (scriptHtml == null) {
                    scriptHtml = "";
                }
                embedsPattern = new Regex("embeds:\\s*\\{([^}]*\\{[^}]*\\})*[^}]*\\}", RegexOption.DOT_MATCHES_ALL);
                matchResultFind$default = Regex.find$default(embedsPattern, scriptHtml, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    embedsMatch = matchResultFind$default.getValue();
                } else {
                    embedsMatch = null;
                }
                if (embedsMatch != null) {
                    String it4 = embedsMatch;
                    embedsJson = loadLinks$cleanJsToJson(it4);
                } else {
                    embedsJson = null;
                }
                str = embedsJson;
                if (!(str != null || str.length() == 0)) {
                    embedsObject = new JSONObject(embedsJson);
                    listLoadLinks$extractLinks = loadLinks$extractLinks(embedsObject, "SUB");
                    listLoadLinks$extractLinks2 = loadLinks$extractLinks(embedsObject, "DUB");
                    c00052 = new C00052(function3, function4, null);
                    c00042.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00042.L$1 = function3;
                    c00042.L$2 = function4;
                    c00042.L$3 = SpillingKt.nullOutSpilledVariable(document);
                    c00042.L$4 = SpillingKt.nullOutSpilledVariable(scriptHtml);
                    c00042.L$5 = SpillingKt.nullOutSpilledVariable(embedsPattern);
                    c00042.L$6 = SpillingKt.nullOutSpilledVariable(embedsMatch);
                    c00042.L$7 = SpillingKt.nullOutSpilledVariable(embedsJson);
                    c00042.L$8 = SpillingKt.nullOutSpilledVariable(embedsObject);
                    c00042.L$9 = SpillingKt.nullOutSpilledVariable(listLoadLinks$extractLinks);
                    c00042.L$10 = listLoadLinks$extractLinks2;
                    c00042.Z$0 = isCasting2;
                    c00042.label = 2;
                    if (ParCollectionsKt.amap(listLoadLinks$extractLinks, c00052, c00042) == $result2) {
                        return $result2;
                    }
                    function5 = function4;
                    function6 = function3;
                    document2 = document;
                    embedsObject2 = embedsObject;
                    list = listLoadLinks$extractLinks2;
                    data4 = data3;
                    embedsMatch2 = embedsMatch;
                    scriptHtml2 = scriptHtml;
                    list2 = listLoadLinks$extractLinks;
                    embedsPattern2 = embedsPattern;
                    c00063 = new C00063(function6, function5, null);
                    c00042.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00042.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                    c00042.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                    c00042.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                    c00042.L$4 = SpillingKt.nullOutSpilledVariable(scriptHtml2);
                    c00042.L$5 = SpillingKt.nullOutSpilledVariable(embedsPattern2);
                    c00042.L$6 = SpillingKt.nullOutSpilledVariable(embedsMatch2);
                    c00042.L$7 = SpillingKt.nullOutSpilledVariable(embedsJson);
                    c00042.L$8 = SpillingKt.nullOutSpilledVariable(embedsObject2);
                    c00042.L$9 = SpillingKt.nullOutSpilledVariable(list2);
                    c00042.L$10 = SpillingKt.nullOutSpilledVariable(list);
                    c00042.Z$0 = isCasting2;
                    c00042.label = 3;
                    if (ParCollectionsKt.amap(list, c00063, c00042) == $result2) {
                        return $result2;
                    }
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean isCasting4 = c00041.Z$0;
                List<Pair<String, String>> list3 = (List) c00041.L$10;
                List<Pair<String, String>> list4 = (List) c00041.L$9;
                JSONObject embedsObject3 = (JSONObject) c00041.L$8;
                String embedsJson2 = (String) c00041.L$7;
                String embedsMatch3 = (String) c00041.L$6;
                Regex embedsPattern3 = (Regex) c00041.L$5;
                String scriptHtml3 = (String) c00041.L$4;
                Document document3 = (Document) c00041.L$3;
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c00041.L$2;
                Function1<? super SubtitleFile, Unit> function8 = (Function1) c00041.L$1;
                String data5 = (String) c00041.L$0;
                ResultKt.throwOnFailure($result4);
                function6 = function8;
                list2 = list4;
                embedsObject2 = embedsObject3;
                embedsJson = embedsJson2;
                embedsMatch2 = embedsMatch3;
                embedsPattern2 = embedsPattern3;
                scriptHtml2 = scriptHtml3;
                document2 = document3;
                function5 = function7;
                isCasting2 = isCasting4;
                list = list3;
                z = true;
                data4 = data5;
                $result2 = coroutine_suspended;
                c00042 = c00041;
                c00063 = new C00063(function6, function5, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                c00042.L$4 = SpillingKt.nullOutSpilledVariable(scriptHtml2);
                c00042.L$5 = SpillingKt.nullOutSpilledVariable(embedsPattern2);
                c00042.L$6 = SpillingKt.nullOutSpilledVariable(embedsMatch2);
                c00042.L$7 = SpillingKt.nullOutSpilledVariable(embedsJson);
                c00042.L$8 = SpillingKt.nullOutSpilledVariable(embedsObject2);
                c00042.L$9 = SpillingKt.nullOutSpilledVariable(list2);
                c00042.L$10 = SpillingKt.nullOutSpilledVariable(list);
                c00042.Z$0 = isCasting2;
                c00042.label = 3;
                if (ParCollectionsKt.amap(list, c00063, c00042) == $result2) {
                    return $result2;
                }
                return Boxing.boxBoolean(z);
            case 3:
                boolean z2 = c00041.Z$0;
                embedsMatch2 = (String) c00041.L$6;
                embedsPattern2 = (Regex) c00041.L$5;
                document2 = (Document) c00041.L$3;
                function5 = (Function1) c00041.L$2;
                function6 = (Function1) c00041.L$1;
                data4 = (String) c00041.L$0;
                ResultKt.throwOnFailure($result4);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final String loadLinks$cleanJsToJson(String js) {
        String cleaned = new Regex("^\\s*\\w+\\s*:\\s*").replaceFirst(js, "");
        return StringsKt.trim(new Regex("(?<=[{,])\\s*(\\w+)\\s*:").replace(StringsKt.replace$default(cleaned, "void 0", "null", false, 4, (Object) null), new Function1() { // from class: com.Animeav1.Animeav1$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return Animeav1.loadLinks$cleanJsToJson$lambda$1((MatchResult) obj);
            }
        })).toString();
    }

    static final CharSequence loadLinks$cleanJsToJson$lambda$1(MatchResult it) {
        return '\"' + ((String) it.getGroupValues().get(1)) + "\":";
    }

    private static final List<Pair<String, String>> loadLinks$extractLinks(JSONObject embedsObject, String arrayName) throws JSONException {
        List list = new ArrayList();
        if (embedsObject.has(arrayName)) {
            JSONArray jsonArray = embedsObject.getJSONArray(arrayName);
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                list.add(TuplesKt.to(obj.getString("server"), obj.getString("url")));
            }
        }
        return list;
    }

    /* JADX INFO: renamed from: com.Animeav1.Animeav1$loadLinks$2 */
    /* JADX INFO: compiled from: Animeav1.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animeav1.Animeav1$loadLinks$2", f = "Animeav1.kt", i = {0, 0, 0}, l = {187}, m = "invokeSuspend", n = {"<destruct>", "server", "url"}, nl = {194}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00052 extends SuspendLambda implements Function2<Pair<? extends String, ? extends String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00052(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00052> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00052 = new C00052(this.$subtitleCallback, this.$callback, continuation);
            c00052.L$0 = obj;
            return c00052;
        }

        public final Object invoke(Pair<String, String> pair, Continuation<? super Unit> continuation) {
            return create(pair, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Pair pair = (Pair) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String server = (String) pair.component1();
                    String url = (String) pair.component2();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(pair);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(server);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(url);
                    this.label = 1;
                    if (Animeav1Kt.loadCustomExtractor$default("Animeav1 [SUB:" + server + ']', url, "", this.$subtitleCallback, this.$callback, null, (Continuation) this, 32, null) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.Animeav1.Animeav1$loadLinks$3 */
    /* JADX INFO: compiled from: Animeav1.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animeav1.Animeav1$loadLinks$3", f = "Animeav1.kt", i = {0, 0, 0}, l = {197}, m = "invokeSuspend", n = {"<destruct>", "server", "url"}, nl = {204}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00063 extends SuspendLambda implements Function2<Pair<? extends String, ? extends String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00063(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00063> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00063 = new C00063(this.$subtitleCallback, this.$callback, continuation);
            c00063.L$0 = obj;
            return c00063;
        }

        public final Object invoke(Pair<String, String> pair, Continuation<? super Unit> continuation) {
            return create(pair, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Pair pair = (Pair) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String server = (String) pair.component1();
                    String url = (String) pair.component2();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(pair);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(server);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(url);
                    this.label = 1;
                    if (Animeav1Kt.loadCustomExtractor$default("Animeav1 [DUB:" + server + ']', url, "", this.$subtitleCallback, this.$callback, null, (Continuation) this, 32, null) == coroutine_suspended) {
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
