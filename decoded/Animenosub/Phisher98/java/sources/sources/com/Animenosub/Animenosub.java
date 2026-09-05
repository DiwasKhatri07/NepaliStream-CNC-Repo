package com.Animenosub;

import com.lagradost.api.Log;
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
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Animenosub.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Animenosub/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020'*\u00020(H\u0002J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+JF\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000e2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020503H\u0096@¢\u0006\u0002\u00108R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00069"}, d2 = {"Lcom/Animenosub/Animenosub;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Animenosub"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnimenosub.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animenosub.kt\ncom/Animenosub/Animenosub\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,126:1\n1795#2,10:127\n2068#2:137\n2069#2:139\n1805#2:140\n1795#2,10:141\n2068#2:151\n2069#2:153\n1805#2:154\n1739#2:155\n1814#2,3:156\n1#3:138\n1#3:152\n*S KotlinDebug\n*F\n+ 1 Animenosub.kt\ncom/Animenosub/Animenosub\n*L\n27#1:127,10\n27#1:137\n27#1:139\n27#1:140\n55#1:141,10\n55#1:151\n55#1:153\n55#1:154\n78#1:155\n78#1:156,3\n27#1:138\n55#1:152\n*E\n"})
public final class Animenosub extends MainAPI {

    @NotNull
    private String mainUrl = "https://animenosub.to";

    @NotNull
    private String name = "Animenosub";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Anime});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("anime/?status=&type=&order=update&page=", "Recently Updated"), TuplesKt.to("anime/?type=tv&page=", "Anime"), TuplesKt.to("anime/?status=&type=tv&sub=sub&page=", "Anime (SUB)"), TuplesKt.to("anime/?status=&type=tv&sub=dub&page=", "Anime (DUB)"), TuplesKt.to("anime/?status=&type=movie&page=", "Movies")});

    /* JADX INFO: renamed from: com.Animenosub.Animenosub$getMainPage$1 */
    /* JADX INFO: compiled from: Animenosub.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animenosub.Animenosub", f = "Animenosub.kt", i = {0, 0}, l = {26}, m = "getMainPage", n = {"request", "page"}, nl = {27}, s = {"L$0", "I$0"}, v = 2)
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
            return Animenosub.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Animenosub.Animenosub$load$1 */
    /* JADX INFO: compiled from: Animenosub.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animenosub.Animenosub", f = "Animenosub.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {70, 92, 101}, m = "load", n = {"url", "url", "document", "title", "href", "poster", "description", "type", "tvtag", "episodes", "url", "document", "title", "href", "poster", "description", "type", "tvtag"}, nl = {71, 97, 77}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Animenosub.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Animenosub.Animenosub$loadLinks$1 */
    /* JADX INFO: compiled from: Animenosub.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animenosub.Animenosub", f = "Animenosub.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {109, 110}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "isCasting"}, nl = {110, 123}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return Animenosub.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Animenosub.Animenosub$search$1 */
    /* JADX INFO: compiled from: Animenosub.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animenosub.Animenosub", f = "Animenosub.kt", i = {0, 0, 0}, l = {53}, m = "search", n = {"query", "searchResponse", "i"}, nl = {55}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Animenosub.this.search(null, (Continuation) this);
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
                String str = getMainUrl() + '/' + request.getData() + page2;
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
        Iterable $this$mapNotNull$iv = document.select("div.listupd > article");
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
        String title = $this$toSearchResult.select("div.bsx > a").attr("title");
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult.select("div.bsx > a").attr("href"));
        final String posterUrl = MainAPIKt.fixUrlNull(this, $this$toSearchResult.select("div.bsx > a img").attr("src"));
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Animenosub.Animenosub$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Animenosub.toSearchResult$lambda$0(posterUrl, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0063  */
    /* JADX WARN: Code duplicated, block: B:18:0x00c9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:23:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:25:0x010d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0126  */
    /* JADX WARN: Code duplicated, block: B:31:0x0132  */
    /* JADX WARN: Code duplicated, block: B:38:0x0112 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00ca -> B:20:0x00d3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object search(@org.jetbrains.annotations.NotNull java.lang.String r27, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r28) {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Animenosub.Animenosub.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:29:0x0107  */
    /* JADX WARN: Code duplicated, block: B:35:0x0136  */
    /* JADX WARN: Code duplicated, block: B:38:0x0140  */
    /* JADX WARN: Code duplicated, block: B:39:0x0145  */
    /* JADX WARN: Code duplicated, block: B:42:0x0160  */
    /* JADX WARN: Code duplicated, block: B:43:0x0163  */
    /* JADX WARN: Code duplicated, block: B:46:0x016d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0193  */
    /* JADX WARN: Code duplicated, block: B:53:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:57:0x0213  */
    /* JADX WARN: Code duplicated, block: B:58:0x0215  */
    /* JADX WARN: Code duplicated, block: B:60:0x0218  */
    /* JADX WARN: Code duplicated, block: B:65:0x022f  */
    /* JADX WARN: Code duplicated, block: B:69:0x0288 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x0289  */
    /* JADX WARN: Code duplicated, block: B:72:0x0297  */
    /* JADX WARN: Code duplicated, block: B:74:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:75:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:77:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:86:0x0316 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:87:0x0317  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        Object obj2;
        String url2;
        Document document;
        Element elementSelectFirst;
        String string;
        String title;
        Element elementSelectFirst2;
        String str;
        String str2;
        String strAttr;
        String href;
        Ref.ObjectRef poster;
        Element elementSelectFirst3;
        String string2;
        String description;
        Element elementSelectFirst4;
        String strText;
        String type;
        TvType tvtag;
        TvType tvtag2;
        boolean z;
        Object objNewMovieLoadResponse;
        String title2;
        String url3;
        Ref.ObjectRef poster2;
        String url4;
        String title3;
        TvType tvtag3;
        String href2;
        Element elementSelectFirst5;
        String string3;
        String strAttr2;
        Iterable $this$map$iv;
        Collection destination$iv$iv;
        Iterable $this$mapTo$iv$iv;
        boolean z2;
        Object objNewTvSeriesLoadResponse;
        Element elementSelectFirst6;
        String string4;
        String strAttr3;
        String str3;
        Element elementSelectFirst7;
        final String posterr;
        String strText2;
        String strText3;
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
        Object $result = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = url;
                c00012.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("h1.entry-title");
                if (elementSelectFirst != null || (strText3 = elementSelectFirst.text()) == null) {
                    string = null;
                } else {
                    string = StringsKt.trim(strText3).toString();
                }
                title = String.valueOf(string);
                elementSelectFirst2 = document.selectFirst(".eplister li > a");
                str = "href";
                str2 = "";
                if (elementSelectFirst2 != null || (strAttr = elementSelectFirst2.attr("href")) == null) {
                    strAttr = "";
                }
                href = strAttr;
                poster = new Ref.ObjectRef();
                poster.element = document.select("div.ime > img").attr("src");
                elementSelectFirst3 = document.selectFirst("div.entry-content");
                if (elementSelectFirst3 != null || (strText2 = elementSelectFirst3.text()) == null) {
                    string2 = null;
                } else {
                    string2 = StringsKt.trim(strText2).toString();
                }
                description = string2;
                elementSelectFirst4 = document.selectFirst(".spe");
                if (elementSelectFirst4 != null) {
                    strText = elementSelectFirst4.text();
                } else {
                    strText = null;
                }
                type = String.valueOf(strText);
                if (StringsKt.contains$default(type, "Movie", false, 2, (Object) null)) {
                    tvtag = TvType.Movie;
                } else {
                    tvtag = TvType.TvSeries;
                }
                if (tvtag == TvType.TvSeries) {
                    tvtag2 = tvtag;
                    if (((CharSequence) poster.element).length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        elementSelectFirst5 = document.selectFirst("meta[property=og:image]");
                        if (elementSelectFirst5 != null || (strAttr2 = elementSelectFirst5.attr("content")) == null) {
                            string3 = null;
                        } else {
                            string3 = StringsKt.trim(strAttr2).toString();
                        }
                        poster.element = String.valueOf(string3);
                    }
                    TvType tvType = TvType.Movie;
                    C00033 c00033 = new C00033(poster, description, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(title);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(href);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(description);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(type);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(tvtag2);
                    c00012.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, url2, tvType, href, c00033, c00012);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    title2 = title;
                    url3 = url2;
                    poster2 = poster;
                    url4 = description;
                    title3 = type;
                    tvtag3 = tvtag2;
                    href2 = href;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                $this$map$iv = document.select("div.eplister > ul > li");
                TvType tvtag4 = tvtag;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                $this$mapTo$iv$iv = $this$map$iv;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                    Element info = (Element) item$iv$iv;
                    Iterable $this$map$iv2 = $this$map$iv;
                    String href1 = info.select("a").attr(str);
                    String url5 = url2;
                    String str4 = str;
                    str3 = str2;
                    String href3 = href;
                    final String episode = StringsKt.substringBeforeLast$default(StringsKt.substringAfter$default(info.select("a div.epl-title").text(), "-", (String) null, 2, (Object) null), "-", (String) null, 2, (Object) null);
                    elementSelectFirst7 = info.selectFirst("a img");
                    if (elementSelectFirst7 != null || (posterr = elementSelectFirst7.attr("src")) == null) {
                        posterr = str3;
                    }
                    destination$iv$iv.add(MainAPIKt.newEpisode(this, href1, new Function1() { // from class: com.Animenosub.Animenosub$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj3) {
                            return Animenosub.load$lambda$0$0(episode, posterr, (Episode) obj3);
                        }
                    }));
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                    $this$map$iv = $this$map$iv2;
                    url2 = url5;
                    str = str4;
                    str2 = str3;
                    href = href3;
                }
                String url6 = url2;
                String href4 = href;
                List episodes = CollectionsKt.reversed((List) destination$iv$iv);
                if (((CharSequence) poster.element).length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    elementSelectFirst6 = document.selectFirst("meta[property=og:image]");
                    if (elementSelectFirst6 != null || (strAttr3 = elementSelectFirst6.attr("content")) == null) {
                        string4 = null;
                    } else {
                        string4 = StringsKt.trim(strAttr3).toString();
                    }
                    poster.element = String.valueOf(string4);
                }
                TvType tvType2 = TvType.Anime;
                C00022 c00022 = new C00022(poster, description, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(href4);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(description);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(type);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(tvtag4);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(episodes);
                c00012.label = 2;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title, url6, tvType2, episodes, c00022, c00012);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 1:
                String url7 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                url2 = url7;
                obj2 = $result;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("h1.entry-title");
                if (elementSelectFirst != null) {
                    string = null;
                } else {
                    string = null;
                }
                title = String.valueOf(string);
                elementSelectFirst2 = document.selectFirst(".eplister li > a");
                str = "href";
                str2 = "";
                if (elementSelectFirst2 != null) {
                    strAttr = "";
                } else {
                    strAttr = "";
                }
                href = strAttr;
                poster = new Ref.ObjectRef();
                poster.element = document.select("div.ime > img").attr("src");
                elementSelectFirst3 = document.selectFirst("div.entry-content");
                if (elementSelectFirst3 != null) {
                    string2 = null;
                } else {
                    string2 = null;
                }
                description = string2;
                elementSelectFirst4 = document.selectFirst(".spe");
                if (elementSelectFirst4 != null) {
                    strText = elementSelectFirst4.text();
                } else {
                    strText = null;
                }
                type = String.valueOf(strText);
                if (StringsKt.contains$default(type, "Movie", false, 2, (Object) null)) {
                    tvtag = TvType.Movie;
                } else {
                    tvtag = TvType.TvSeries;
                }
                if (tvtag == TvType.TvSeries) {
                    tvtag2 = tvtag;
                    if (((CharSequence) poster.element).length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        elementSelectFirst5 = document.selectFirst("meta[property=og:image]");
                        if (elementSelectFirst5 != null) {
                            string3 = null;
                        } else {
                            string3 = null;
                        }
                        poster.element = String.valueOf(string3);
                    }
                    TvType tvType3 = TvType.Movie;
                    C00033 c00034 = new C00033(poster, description, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(title);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(href);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(description);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(type);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(tvtag2);
                    c00012.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, url2, tvType3, href, c00034, c00012);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    title2 = title;
                    url3 = url2;
                    poster2 = poster;
                    url4 = description;
                    title3 = type;
                    tvtag3 = tvtag2;
                    href2 = href;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                $this$map$iv = document.select("div.eplister > ul > li");
                TvType tvtag5 = tvtag;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                $this$mapTo$iv$iv = $this$map$iv;
                while (r23.hasNext()) {
                    Iterable $this$mapTo$iv$iv3 = $this$mapTo$iv$iv;
                    Element info2 = (Element) item$iv$iv;
                    Iterable $this$map$iv3 = $this$map$iv;
                    String href5 = info2.select("a").attr(str);
                    String url8 = url2;
                    String str5 = str;
                    str3 = str2;
                    String href6 = href;
                    final String episode2 = StringsKt.substringBeforeLast$default(StringsKt.substringAfter$default(info2.select("a div.epl-title").text(), "-", (String) null, 2, (Object) null), "-", (String) null, 2, (Object) null);
                    elementSelectFirst7 = info2.selectFirst("a img");
                    if (elementSelectFirst7 != null) {
                        posterr = str3;
                    } else {
                        posterr = str3;
                    }
                    destination$iv$iv.add(MainAPIKt.newEpisode(this, href5, new Function1() { // from class: com.Animenosub.Animenosub$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj3) {
                            return Animenosub.load$lambda$0$0(episode2, posterr, (Episode) obj3);
                        }
                    }));
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv3;
                    $this$map$iv = $this$map$iv3;
                    url2 = url8;
                    str = str5;
                    str2 = str3;
                    href = href6;
                }
                String url9 = url2;
                String href7 = href;
                List episodes2 = CollectionsKt.reversed((List) destination$iv$iv);
                if (((CharSequence) poster.element).length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    elementSelectFirst6 = document.selectFirst("meta[property=og:image]");
                    if (elementSelectFirst6 != null) {
                        string4 = null;
                    } else {
                        string4 = null;
                    }
                    poster.element = String.valueOf(string4);
                }
                TvType tvType4 = TvType.Anime;
                C00022 c00023 = new C00022(poster, description, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(href7);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(description);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(type);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(tvtag5);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(episodes2);
                c00012.label = 2;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title, url9, tvType4, episodes2, c00023, c00012);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 2:
                ResultKt.throwOnFailure($result);
                objNewTvSeriesLoadResponse = $result;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 3:
                tvtag3 = (TvType) c00012.L$7;
                title3 = (String) c00012.L$6;
                url4 = (String) c00012.L$5;
                poster2 = (Ref.ObjectRef) c00012.L$4;
                href2 = (String) c00012.L$3;
                title2 = (String) c00012.L$2;
                document = (Document) c00012.L$1;
                url3 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                objNewMovieLoadResponse = $result;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$0$0(String $episode, String $posterr, Episode $this$newEpisode) {
        $this$newEpisode.setName($episode);
        $this$newEpisode.setPosterUrl($posterr);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Animenosub.Animenosub$load$2 */
    /* JADX INFO: compiled from: Animenosub.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animenosub.Animenosub$load$2", f = "Animenosub.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00022 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ Ref.ObjectRef<String> $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(Ref.ObjectRef<String> objectRef, String str, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$poster = objectRef;
            this.$description = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$poster, this.$description, continuation);
            c00022.L$0 = obj;
            return c00022;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newTvSeriesLoadResponse.setPosterUrl((String) this.$poster.element);
                    $this$newTvSeriesLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.Animenosub.Animenosub$load$3 */
    /* JADX INFO: compiled from: Animenosub.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animenosub.Animenosub$load$3", f = "Animenosub.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00033 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ Ref.ObjectRef<String> $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00033(Ref.ObjectRef<String> objectRef, String str, Continuation<? super C00033> continuation) {
            super(2, continuation);
            this.$poster = objectRef;
            this.$description = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00033 = new C00033(this.$poster, this.$description, continuation);
            c00033.L$0 = obj;
            return c00033;
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
                    $this$newMovieLoadResponse.setPosterUrl((String) this.$poster.element);
                    $this$newMovieLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00fb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00041 c00041;
        Object obj;
        boolean z;
        C00041 c00042;
        String data2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        List listSelect;
        C00052 c00052;
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
                Requests app = MainActivityKt.getApp();
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00041.L$1 = function1;
                c00041.L$2 = function2;
                c00041.Z$0 = isCasting;
                c00041.label = 1;
                C00041 c00043 = c00041;
                obj = coroutine_suspended;
                z = true;
                $result = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00043, 4094, (Object) null);
                c00042 = c00043;
                if ($result == obj) {
                    return obj;
                }
                data2 = data;
                isCasting2 = isCasting;
                function3 = function1;
                function4 = function2;
                Document document = ((NiceResponse) $result).getDocument();
                listSelect = document.select(".mobius option");
                c00052 = new C00052(function3, function4, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(document);
                c00042.Z$0 = isCasting2;
                c00042.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00052, c00042) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00041.Z$0;
                function4 = (Function1) c00041.L$2;
                function3 = (Function1) c00041.L$1;
                data2 = (String) c00041.L$0;
                ResultKt.throwOnFailure($result);
                c00042 = c00041;
                obj = coroutine_suspended;
                z = true;
                Document document2 = ((NiceResponse) $result).getDocument();
                listSelect = document2.select(".mobius option");
                c00052 = new C00052(function3, function4, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                c00042.Z$0 = isCasting2;
                c00042.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00052, c00042) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean z2 = c00041.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Animenosub.Animenosub$loadLinks$2 */
    /* JADX INFO: compiled from: Animenosub.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "server", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animenosub.Animenosub$loadLinks$2", f = "Animenosub.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {116, 120}, m = "invokeSuspend", n = {"server", "base64", "iframe", "fixiframe", "server", "base64", "iframe"}, nl = {119, 121}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00052 extends SuspendLambda implements Function2<Element, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00052(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00052> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00052 = Animenosub.this.new C00052(this.$subtitleCallback, this.$callback, continuation);
            c00052.L$0 = obj;
            return c00052;
        }

        public final Object invoke(Element element, Continuation<? super Boolean> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String base64;
            Object objLoadExtractor;
            String iframe;
            Object objLoadExtractor2;
            boolean zBooleanValue;
            Element server = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    base64 = server.attr("value");
                    String iframe2 = Jsoup.parse(MainAPIKt.base64Decode(base64)).select("iframe").attr("src");
                    if (StringsKt.startsWith$default(iframe2, "//", false, 2, (Object) null)) {
                        String fixiframe = MainAPIKt.fixUrl(Animenosub.this, iframe2);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(server);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(base64);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(iframe2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(fixiframe);
                        this.label = 1;
                        objLoadExtractor2 = ExtractorApiKt.loadExtractor(fixiframe, fixiframe, this.$subtitleCallback, this.$callback, (Continuation) this);
                        if (objLoadExtractor2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        zBooleanValue = ((Boolean) objLoadExtractor2).booleanValue();
                        return Boxing.boxBoolean(zBooleanValue);
                    }
                    Log.INSTANCE.d("Phisher", iframe2);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(server);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(base64);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(iframe2);
                    this.label = 2;
                    objLoadExtractor = ExtractorApiKt.loadExtractor(iframe2, iframe2, this.$subtitleCallback, this.$callback, (Continuation) this);
                    if (objLoadExtractor == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    iframe = iframe2;
                    zBooleanValue = ((Boolean) objLoadExtractor).booleanValue();
                    return Boxing.boxBoolean(zBooleanValue);
                case 1:
                    ResultKt.throwOnFailure($result);
                    objLoadExtractor2 = $result;
                    zBooleanValue = ((Boolean) objLoadExtractor2).booleanValue();
                    return Boxing.boxBoolean(zBooleanValue);
                case 2:
                    iframe = (String) this.L$2;
                    base64 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    objLoadExtractor = $result;
                    zBooleanValue = ((Boolean) objLoadExtractor).booleanValue();
                    return Boxing.boxBoolean(zBooleanValue);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
