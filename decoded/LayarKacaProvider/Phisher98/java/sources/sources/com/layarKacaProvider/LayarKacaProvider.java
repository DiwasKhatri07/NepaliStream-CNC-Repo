package com.layarKacaProvider;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.Episode;
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
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.io.IOException;
import java.net.URI;
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
import kotlin.collections.MapsKt;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: LayarKacaProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/LayarKacaProvider/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u0004\u0018\u00010**\u00020+H\u0002J\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020*0\u001c2\u0006\u0010-\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010(J\u0016\u0010.\u001a\u00020/2\u0006\u0010'\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010(JF\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00102\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000206042\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020604H\u0096@¢\u0006\u0002\u00109J\u0012\u0010:\u001a\u00020\u0005*\u00020\u0005H\u0082@¢\u0006\u0002\u0010(J\u0016\u0010;\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010(J\f\u0010<\u001a\u00020\u0005*\u00020+H\u0002J\u0010\u0010=\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006>"}, d2 = {"Lcom/layarKacaProvider/LayarKacaProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "seriesUrl", "searchurl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProperLink", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIframe", "fetchURL", "getImageAttr", "getBaseUrl", "LayarKacaProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLayarKacaProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayarKacaProvider.kt\ncom/layarKacaProvider/LayarKacaProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 5 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n*L\n1#1,240:1\n1795#2,10:241\n2068#2:251\n2069#2:253\n1805#2:254\n1739#2:261\n1814#2,3:262\n1739#2:265\n1814#2,3:266\n1739#2:271\n1814#2,3:272\n1#3:252\n437#4:255\n513#4,5:256\n32#5,2:269\n*S KotlinDebug\n*F\n+ 1 LayarKacaProvider.kt\ncom/layarKacaProvider/LayarKacaProvider\n*L\n41#1:241,10\n41#1:251\n41#1:253\n41#1:254\n121#1:261\n121#1:262,3\n132#1:265\n132#1:266,3\n195#1:271\n195#1:272,3\n41#1:252\n67#1:255\n67#1:256,5\n147#1:269,2\n*E\n"})
public final class LayarKacaProvider extends MainAPI {

    @NotNull
    private String mainUrl = "https://lk21.de";

    @NotNull
    private String seriesUrl = "https://series.lk21.de";

    @NotNull
    private String searchurl = "https://gudangvape.com";

    @NotNull
    private String name = "LayarKaca";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "id";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.AsianDrama});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getMainUrl() + "/populer/page/", "Film Terplopuler"), TuplesKt.to(getMainUrl() + "/rating/page/", "Film Berdasarkan IMDb Rating"), TuplesKt.to(getMainUrl() + "/most-commented/page/", "Film Dengan Komentar Terbanyak"), TuplesKt.to(this.seriesUrl + "/latest-series/page/", "Series Terbaru"), TuplesKt.to(this.seriesUrl + "/series/asian/page/", "Film Asian Terbaru"), TuplesKt.to(getMainUrl() + "/latest/page/", "Film Upload Terbaru")});

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$fetchURL$1 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider", f = "LayarKacaProvider.kt", i = {0}, l = {212}, m = "fetchURL", n = {"url"}, nl = {213}, s = {"L$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LayarKacaProvider.this.fetchURL(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$getIframe$1 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider", f = "LayarKacaProvider.kt", i = {0}, l = {207}, m = "getIframe", n = {"$this$getIframe"}, nl = {208}, s = {"L$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LayarKacaProvider.this.getIframe(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$getMainPage$1 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider", f = "LayarKacaProvider.kt", i = {0, 0}, l = {40}, m = "getMainPage", n = {"request", "page"}, nl = {41}, s = {"L$0", "I$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LayarKacaProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$getProperLink$1 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider", f = "LayarKacaProvider.kt", i = {0}, l = {49}, m = "getProperLink", n = {"url"}, nl = {50}, s = {"L$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
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
            return LayarKacaProvider.this.getProperLink(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$load$1 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider", f = "LayarKacaProvider.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {116, 117, 118, 164, 175}, m = "load", n = {"url", "url", "fixUrl", "url", "fixUrl", "document", "url", "fixUrl", "document", "baseurl", "title", "poster", "tags", "posterheaders", "year", "tvType", "description", "trailer", "rating", "recommendations", "json", "episodes", "url", "fixUrl", "document", "baseurl", "title", "poster", "tags", "posterheaders", "year", "tvType", "description", "trailer", "rating", "recommendations"}, nl = {117, 118, 119, 175, 142}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13"}, v = 2)
    static final class C00051 extends ContinuationImpl {
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

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LayarKacaProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$loadLinks$1 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider", f = "LayarKacaProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {194, 197}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "isCasting"}, nl = {197, 203}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
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
            return LayarKacaProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$search$1 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider", f = "LayarKacaProvider.kt", i = {0, 1, 1}, l = {85, 86}, m = "search", n = {"query", "query", "refer"}, nl = {86, 87}, s = {"L$0", "L$0", "L$1"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LayarKacaProvider.this.search(null, (Continuation) this);
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
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws IOException {
        C00031 c00031;
        MainPageRequest request2;
        int page2 = page;
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
        Object $result = c00031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00031.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = request.getData() + page2;
                c00031.L$0 = request;
                c00031.I$0 = page2;
                c00031.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00031, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00031.I$0;
                request2 = (MainPageRequest) c00031.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("article figure");
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
        return MainAPIKt.newHomePageResponse$default(request2.getName(), home, (Boolean) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object getProperLink(String url, Continuation<? super String> continuation) {
        C00041 c00041;
        String str;
        String url2;
        String strAttr;
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
        C00041 c00042 = c00041;
        Object $result = c00042.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00042.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (StringsKt.startsWith$default(url, this.seriesUrl, false, 2, (Object) null)) {
                    return url;
                }
                Requests app = MainActivityKt.getApp();
                c00042.L$0 = url;
                c00042.label = 1;
                str = null;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00042, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                url2 = url;
                break;
            case 1:
                url2 = (String) c00042.L$0;
                ResultKt.throwOnFailure($result);
                str = null;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document res = ((NiceResponse) $result).getDocument();
        if (StringsKt.contains(res.select("title").text(), "Nontondrama", true)) {
            Element elementSelectFirst = res.selectFirst("a#openNow");
            if (elementSelectFirst != null && (strAttr = elementSelectFirst.attr("href")) != null) {
                return strAttr;
            }
            Element elementSelectFirst2 = res.selectFirst("div.links a");
            String strAttr2 = elementSelectFirst2 != null ? elementSelectFirst2.attr("href") : str;
            if (strAttr2 != null) {
                return strAttr2;
            }
        }
        return url2;
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) throws IOException {
        String strOwnText;
        String title;
        CharSequence $this$filter$iv;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("h3");
        final Integer episode = null;
        if (elementSelectFirst == null || (strOwnText = elementSelectFirst.ownText()) == null || (title = StringsKt.trim(strOwnText).toString()) == null) {
            return null;
        }
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("a");
        Intrinsics.checkNotNull(elementSelectFirst2);
        String href = MainAPIKt.fixUrl(this, elementSelectFirst2.attr("href"));
        LayarKacaProvider layarKacaProvider = this;
        Element elementSelectFirst3 = $this$toSearchResult.selectFirst("img");
        final String posterUrl = MainAPIKt.fixUrlNull(layarKacaProvider, elementSelectFirst3 != null ? getImageAttr(elementSelectFirst3) : null);
        TvType type = $this$toSearchResult.selectFirst("span.episode") == null ? TvType.Movie : TvType.TvSeries;
        final Map posterheaders = MapsKt.mapOf(TuplesKt.to("Referer", getBaseUrl(posterUrl)));
        if (type != TvType.TvSeries) {
            final String quality = StringsKt.trim($this$toSearchResult.select("div.quality").text()).toString();
            return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return LayarKacaProvider.toSearchResult$lambda$2(posterUrl, posterheaders, quality, (MovieSearchResponse) obj);
                }
            }, 8, (Object) null);
        }
        Element elementSelectFirst4 = $this$toSearchResult.selectFirst("span.episode strong");
        if (elementSelectFirst4 != null && ($this$filter$iv = elementSelectFirst4.text()) != null) {
            CharSequence $this$filterTo$iv$iv = $this$filter$iv;
            Appendable destination$iv$iv = new StringBuilder();
            int length = $this$filterTo$iv$iv.length();
            for (int index$iv$iv = 0; index$iv$iv < length; index$iv$iv++) {
                char element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
                if (Character.isDigit(element$iv$iv)) {
                    destination$iv$iv.append(element$iv$iv);
                }
            }
            String $this$filter$iv2 = ((StringBuilder) destination$iv$iv).toString();
            if ($this$filter$iv2 != null) {
                episode = StringsKt.toIntOrNull($this$filter$iv2);
            }
        }
        return MainAPIKt.newAnimeSearchResponse$default(this, title, href, TvType.TvSeries, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return LayarKacaProvider.toSearchResult$lambda$1(posterUrl, posterheaders, episode, (AnimeSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$1(String $posterUrl, Map $posterheaders, Integer $episode, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($posterUrl);
        $this$newAnimeSearchResponse.setPosterHeaders($posterheaders);
        MainAPIKt.addSub($this$newAnimeSearchResponse, $episode);
        return Unit.INSTANCE;
    }

    static final Unit toSearchResult$lambda$2(String $posterUrl, Map $posterheaders, String $quality, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setPosterHeaders($posterheaders);
        MainAPIKt.addQuality((SearchResponse) $this$newMovieSearchResponse, $quality);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00f9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:24:0x011c  */
    /* JADX WARN: Code duplicated, block: B:26:0x0156  */
    /* JADX WARN: Code duplicated, block: B:27:0x0188  */
    /* JADX WARN: Code duplicated, block: B:29:0x0190  */
    /* JADX WARN: Code duplicated, block: B:35:0x01c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws JSONException {
        C00101 c00101;
        Object obj;
        C00101 c00102;
        Object obj2;
        String query2;
        List results;
        JSONArray arr;
        int i;
        int length;
        String title;
        String slug;
        String type;
        final String posterUrl;
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
                String mainUrl = getMainUrl();
                c00101.L$0 = query;
                c00101.label = 1;
                C00101 c00103 = c00101;
                obj = coroutine_suspended;
                Object obj3 = Requests.get$default(app, mainUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00103, 4094, (Object) null);
                c00102 = c00103;
                if (obj3 == obj) {
                    return obj;
                }
                obj2 = obj3;
                query2 = query;
                String refer = ((NiceResponse) obj2).getUrl();
                Requests app2 = MainActivityKt.getApp();
                String str = this.searchurl + "/search.php?s=" + query2;
                c00102.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00102.L$1 = SpillingKt.nullOutSpilledVariable(refer);
                c00102.label = 2;
                $result = Requests.get$default(app2, str, (Map) null, refer, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00102, 4090, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                String res = ((NiceResponse) $result).getText();
                results = new ArrayList();
                JSONObject root = new JSONObject(res);
                arr = root.getJSONArray("data");
                length = arr.length();
                for (i = 0; i < length; i++) {
                    JSONObject item = arr.getJSONObject(i);
                    title = item.getString("title");
                    slug = item.getString("slug");
                    type = item.getString("type");
                    posterUrl = "https://static-jpg.lk21.party/wp-content/uploads/" + item.optString("poster");
                    if (Intrinsics.areEqual(type, "series")) {
                        results.add(MainAPIKt.newTvSeriesSearchResponse$default(this, title, this.seriesUrl + '/' + slug, TvType.TvSeries, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj4) {
                                return LayarKacaProvider.search$lambda$0(posterUrl, (TvSeriesSearchResponse) obj4);
                            }
                        }, 8, (Object) null));
                    } else if (Intrinsics.areEqual(type, "movie")) {
                        results.add(MainAPIKt.newMovieSearchResponse$default(this, title, getMainUrl() + '/' + slug, TvType.Movie, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj4) {
                                return LayarKacaProvider.search$lambda$1(posterUrl, (MovieSearchResponse) obj4);
                            }
                        }, 8, (Object) null));
                    }
                }
                return results;
            case 1:
                String query3 = (String) c00101.L$0;
                ResultKt.throwOnFailure($result);
                c00102 = c00101;
                obj = coroutine_suspended;
                query2 = query3;
                obj2 = $result;
                String refer2 = ((NiceResponse) obj2).getUrl();
                Requests app3 = MainActivityKt.getApp();
                String str2 = this.searchurl + "/search.php?s=" + query2;
                c00102.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00102.L$1 = SpillingKt.nullOutSpilledVariable(refer2);
                c00102.label = 2;
                $result = Requests.get$default(app3, str2, (Map) null, refer2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00102, 4090, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                String res2 = ((NiceResponse) $result).getText();
                results = new ArrayList();
                JSONObject root2 = new JSONObject(res2);
                arr = root2.getJSONArray("data");
                length = arr.length();
                while (i < length) {
                    JSONObject item2 = arr.getJSONObject(i);
                    title = item2.getString("title");
                    slug = item2.getString("slug");
                    type = item2.getString("type");
                    posterUrl = "https://static-jpg.lk21.party/wp-content/uploads/" + item2.optString("poster");
                    if (Intrinsics.areEqual(type, "series")) {
                        results.add(MainAPIKt.newTvSeriesSearchResponse$default(this, title, this.seriesUrl + '/' + slug, TvType.TvSeries, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj4) {
                                return LayarKacaProvider.search$lambda$0(posterUrl, (TvSeriesSearchResponse) obj4);
                            }
                        }, 8, (Object) null));
                    } else if (Intrinsics.areEqual(type, "movie")) {
                        results.add(MainAPIKt.newMovieSearchResponse$default(this, title, getMainUrl() + '/' + slug, TvType.Movie, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj4) {
                                return LayarKacaProvider.search$lambda$1(posterUrl, (MovieSearchResponse) obj4);
                            }
                        }, 8, (Object) null));
                    }
                }
                return results;
            case 2:
                ResultKt.throwOnFailure($result);
                String res3 = ((NiceResponse) $result).getText();
                results = new ArrayList();
                JSONObject root3 = new JSONObject(res3);
                arr = root3.getJSONArray("data");
                length = arr.length();
                while (i < length) {
                    JSONObject item3 = arr.getJSONObject(i);
                    title = item3.getString("title");
                    slug = item3.getString("slug");
                    type = item3.getString("type");
                    posterUrl = "https://static-jpg.lk21.party/wp-content/uploads/" + item3.optString("poster");
                    if (Intrinsics.areEqual(type, "series")) {
                        results.add(MainAPIKt.newTvSeriesSearchResponse$default(this, title, this.seriesUrl + '/' + slug, TvType.TvSeries, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj4) {
                                return LayarKacaProvider.search$lambda$0(posterUrl, (TvSeriesSearchResponse) obj4);
                            }
                        }, 8, (Object) null));
                    } else if (Intrinsics.areEqual(type, "movie")) {
                        results.add(MainAPIKt.newMovieSearchResponse$default(this, title, getMainUrl() + '/' + slug, TvType.Movie, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj4) {
                                return LayarKacaProvider.search$lambda$1(posterUrl, (MovieSearchResponse) obj4);
                            }
                        }, 8, (Object) null));
                    }
                }
                return results;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final Unit search$lambda$0(String $posterUrl, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    static final Unit search$lambda$1(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0516 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:101:0x0517  */
    /* JADX WARN: Code duplicated, block: B:22:0x0158 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0159  */
    /* JADX WARN: Code duplicated, block: B:26:0x0175 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0176  */
    /* JADX WARN: Code duplicated, block: B:30:0x0184  */
    /* JADX WARN: Code duplicated, block: B:33:0x0195  */
    /* JADX WARN: Code duplicated, block: B:37:0x01ca A[LOOP:0: B:35:0x01c4->B:37:0x01ca, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:40:0x0219  */
    /* JADX WARN: Code duplicated, block: B:43:0x0228  */
    /* JADX WARN: Code duplicated, block: B:46:0x023a  */
    /* JADX WARN: Code duplicated, block: B:47:0x023d  */
    /* JADX WARN: Code duplicated, block: B:50:0x0248  */
    /* JADX WARN: Code duplicated, block: B:53:0x025b  */
    /* JADX WARN: Code duplicated, block: B:56:0x0267  */
    /* JADX WARN: Code duplicated, block: B:57:0x026e  */
    /* JADX WARN: Code duplicated, block: B:60:0x0278  */
    /* JADX WARN: Code duplicated, block: B:61:0x027f  */
    /* JADX WARN: Code duplicated, block: B:65:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:67:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:70:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:73:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:74:0x0306  */
    /* JADX WARN: Code duplicated, block: B:78:0x0344  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:80:0x034c  */
    /* JADX WARN: Code duplicated, block: B:81:0x0351  */
    /* JADX WARN: Code duplicated, block: B:84:0x035c  */
    /* JADX WARN: Code duplicated, block: B:87:0x036d  */
    /* JADX WARN: Code duplicated, block: B:89:0x038a A[LOOP:3: B:88:0x0388->B:89:0x038a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x0403  */
    /* JADX WARN: Code duplicated, block: B:95:0x048a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:96:0x048b  */
    /* JADX WARN: Code duplicated, block: B:98:0x04a1  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws JSONException {
        C00051 c00051;
        Object properLink;
        String fixUrl;
        Object obj;
        String url2;
        Object obj2;
        Object obj3;
        String url3;
        Document document;
        Object objFetchURL;
        Document document2;
        String url4;
        String fixUrl2;
        String baseurl;
        Element elementSelectFirst;
        String string;
        String title;
        String poster;
        Collection destination$iv$iv;
        List tags;
        final Map posterheaders;
        MatchResult matchResultFind$default;
        String str;
        Integer year;
        TvType tvType;
        TvType tvType2;
        Element elementSelectFirst2;
        String description;
        Element elementSelectFirst3;
        String trailer;
        Element elementSelectFirst4;
        String rating;
        Iterable $this$map$iv;
        Collection destination$iv$iv2;
        String title2;
        List recommendations;
        Object objNewMovieLoadResponse;
        String title3;
        String fixUrl3;
        TvType tvType3;
        String poster2;
        Map posterheaders2;
        Integer year2;
        String description2;
        List tags2;
        String title4;
        List recommendations2;
        String url5;
        Element elementSelectFirst5;
        String strData;
        String json;
        List episodes;
        String json2;
        Map posterheaders3;
        String url6;
        Object objNewTvSeriesLoadResponse;
        JSONObject root;
        Iterator<String> itKeys;
        JSONArray seasonArr;
        int length;
        int episodeNo;
        Element elementSelectFirst6;
        String string2;
        Element elementSelectFirst7;
        String strAttr;
        String strText;
        String strText2;
        List groupValues;
        String strText3;
        String url7 = url;
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
                c00052.L$0 = url7;
                c00052.label = 1;
                properLink = getProperLink(url7, c00052);
                if (properLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fixUrl = (String) properLink;
                obj = coroutine_suspended;
                Requests app = MainActivityKt.getApp();
                c00052.L$0 = url7;
                c00052.L$1 = fixUrl;
                c00052.label = 2;
                url2 = url7;
                obj2 = Requests.get$default(app, fixUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00052, 4094, (Object) null);
                c00052 = c00052;
                if (obj2 == obj) {
                    return obj;
                }
                obj3 = obj2;
                url3 = url2;
                document = ((NiceResponse) obj3).getDocument();
                c00052.L$0 = url3;
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl);
                c00052.L$2 = document;
                c00052.label = 3;
                objFetchURL = fetchURL(fixUrl, c00052);
                if (objFetchURL == obj) {
                    return obj;
                }
                document2 = document;
                url4 = url3;
                fixUrl2 = fixUrl;
                baseurl = (String) objFetchURL;
                elementSelectFirst = document2.selectFirst("div.movie-info h1");
                if (elementSelectFirst != null || (strText3 = elementSelectFirst.text()) == null) {
                    string = null;
                } else {
                    string = StringsKt.trim(strText3).toString();
                }
                title = String.valueOf(string);
                poster = document2.select("meta[property=og:image]").attr("content");
                Iterable $this$map$iv2 = document2.select("div.tag-list span");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv : $this$map$iv2) {
                    destination$iv$iv.add(((Element) item$iv$iv).text());
                }
                tags = (List) destination$iv$iv;
                posterheaders = MapsKt.mapOf(TuplesKt.to("Referer", getBaseUrl(poster)));
                matchResultFind$default = Regex.find$default(new Regex("\\d, (\\d+)"), StringsKt.trim(document2.select("div.movie-info h1").text()).toString(), 0, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
                    str = null;
                } else {
                    str = (String) groupValues.get(1);
                }
                year = StringsKt.toIntOrNull(String.valueOf(str));
                if (document2.selectFirst("#season-data") != null) {
                    tvType = TvType.TvSeries;
                } else {
                    tvType = TvType.Movie;
                }
                tvType2 = tvType;
                elementSelectFirst2 = document2.selectFirst("div.meta-info");
                if (elementSelectFirst2 != null || (strText2 = elementSelectFirst2.text()) == null) {
                    description = null;
                } else {
                    description = StringsKt.trim(strText2).toString();
                }
                elementSelectFirst3 = document2.selectFirst("ul.action-left > li:nth-child(3) > a");
                if (elementSelectFirst3 != null) {
                    trailer = elementSelectFirst3.attr("href");
                } else {
                    trailer = null;
                }
                elementSelectFirst4 = document2.selectFirst("div.info-tag strong");
                if (elementSelectFirst4 != null) {
                    rating = elementSelectFirst4.text();
                } else {
                    rating = null;
                }
                $this$map$iv = document2.select("li.slider article");
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv2 : $this$map$iv) {
                    Object $result2 = $result;
                    Element it = (Element) item$iv$iv2;
                    Iterable $this$map$iv3 = $this$map$iv;
                    elementSelectFirst6 = it.selectFirst("h3");
                    if (elementSelectFirst6 != null || (strText = elementSelectFirst6.text()) == null) {
                        string2 = null;
                    } else {
                        string2 = StringsKt.trim(strText).toString();
                    }
                    String recName = String.valueOf(string2);
                    StringBuilder sbAppend = new StringBuilder().append(baseurl);
                    String title5 = title;
                    Element elementSelectFirst8 = it.selectFirst("a");
                    Intrinsics.checkNotNull(elementSelectFirst8);
                    String recHref = sbAppend.append(elementSelectFirst8.attr("href")).toString();
                    LayarKacaProvider layarKacaProvider = this;
                    elementSelectFirst7 = it.selectFirst("img");
                    if (elementSelectFirst7 != null) {
                        strAttr = elementSelectFirst7.attr("src");
                    } else {
                        strAttr = null;
                    }
                    final String recPosterUrl = MainAPIKt.fixUrl(layarKacaProvider, String.valueOf(strAttr));
                    destination$iv$iv2.add(MainAPIKt.newTvSeriesSearchResponse$default(this, recName, recHref, TvType.TvSeries, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj4) {
                            return LayarKacaProvider.load$lambda$1$0(recPosterUrl, posterheaders, (TvSeriesSearchResponse) obj4);
                        }
                    }, 8, (Object) null));
                    $result = $result2;
                    $this$map$iv = $this$map$iv3;
                    title = title5;
                }
                title2 = title;
                recommendations = (List) destination$iv$iv2;
                if (tvType2 == TvType.TvSeries) {
                    TvType tvType4 = TvType.Movie;
                    C00074 c00074 = new C00074(poster, posterheaders, year, description, tags, rating, recommendations, trailer, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl2);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(baseurl);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(posterheaders);
                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(year);
                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(description);
                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(trailer);
                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(rating);
                    c00052.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00052.label = 5;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2, url4, tvType4, url4, c00074, c00052);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    title3 = title2;
                    fixUrl3 = fixUrl2;
                    tvType3 = tvType2;
                    poster2 = poster;
                    posterheaders2 = posterheaders;
                    year2 = year;
                    description2 = description;
                    tags2 = tags;
                    title4 = rating;
                    recommendations2 = recommendations;
                    url5 = trailer;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                elementSelectFirst5 = document2.selectFirst("script#season-data");
                if (elementSelectFirst5 != null) {
                    strData = elementSelectFirst5.data();
                } else {
                    strData = null;
                }
                json = strData;
                episodes = new ArrayList();
                if (json != null) {
                    root = new JSONObject(json);
                    itKeys = root.keys();
                    while (itKeys.hasNext()) {
                        Object element$iv = itKeys.next();
                        String seasonKey = (String) element$iv;
                        String json3 = json;
                        seasonArr = root.getJSONArray(seasonKey);
                        Map posterheaders4 = posterheaders;
                        length = seasonArr.length();
                        JSONObject root2 = root;
                        episodeNo = 0;
                        while (episodeNo < length) {
                            int i = length;
                            JSONObject ep = seasonArr.getJSONObject(episodeNo);
                            JSONArray seasonArr2 = seasonArr;
                            int i2 = episodeNo;
                            Iterator<String> it2 = itKeys;
                            String href = MainAPIKt.fixUrl(this, baseurl + '/' + ep.getString("slug"));
                            final int episodeNo2 = ep.optInt("episode_no");
                            final int seasonNo = ep.optInt("s");
                            episodes.add(MainAPIKt.newEpisode(this, href, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj4) {
                                    return LayarKacaProvider.load$lambda$2$0(episodeNo2, seasonNo, (Episode) obj4);
                                }
                            }));
                            episodeNo = i2 + 1;
                            length = i;
                            seasonArr = seasonArr2;
                            itKeys = it2;
                            url4 = url4;
                        }
                        json = json3;
                        root = root2;
                        posterheaders = posterheaders4;
                    }
                    json2 = json;
                    posterheaders3 = posterheaders;
                    url6 = url4;
                } else {
                    json2 = json;
                    posterheaders3 = posterheaders;
                    url6 = url4;
                }
                TvType tvType5 = TvType.TvSeries;
                C00063 c00063 = new C00063(poster, posterheaders3, year, description, tags, rating, recommendations, trailer, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl2);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(baseurl);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                c00052.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                c00052.L$7 = SpillingKt.nullOutSpilledVariable(posterheaders3);
                c00052.L$8 = SpillingKt.nullOutSpilledVariable(year);
                c00052.L$9 = SpillingKt.nullOutSpilledVariable(tvType2);
                c00052.L$10 = SpillingKt.nullOutSpilledVariable(description);
                c00052.L$11 = SpillingKt.nullOutSpilledVariable(trailer);
                c00052.L$12 = SpillingKt.nullOutSpilledVariable(rating);
                c00052.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                c00052.L$14 = SpillingKt.nullOutSpilledVariable(json2);
                c00052.L$15 = SpillingKt.nullOutSpilledVariable(episodes);
                c00052.label = 4;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, url6, tvType5, episodes, c00063, c00052);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 1:
                url7 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result);
                properLink = $result;
                fixUrl = (String) properLink;
                obj = coroutine_suspended;
                Requests app2 = MainActivityKt.getApp();
                c00052.L$0 = url7;
                c00052.L$1 = fixUrl;
                c00052.label = 2;
                url2 = url7;
                obj2 = Requests.get$default(app2, fixUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00052, 4094, (Object) null);
                c00052 = c00052;
                if (obj2 == obj) {
                    return obj;
                }
                obj3 = obj2;
                url3 = url2;
                document = ((NiceResponse) obj3).getDocument();
                c00052.L$0 = url3;
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl);
                c00052.L$2 = document;
                c00052.label = 3;
                objFetchURL = fetchURL(fixUrl, c00052);
                if (objFetchURL == obj) {
                    return obj;
                }
                document2 = document;
                url4 = url3;
                fixUrl2 = fixUrl;
                baseurl = (String) objFetchURL;
                elementSelectFirst = document2.selectFirst("div.movie-info h1");
                if (elementSelectFirst != null) {
                    string = null;
                } else {
                    string = null;
                }
                title = String.valueOf(string);
                poster = document2.select("meta[property=og:image]").attr("content");
                Iterable $this$map$iv4 = document2.select("div.tag-list span");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                while (r18.hasNext()) {
                    destination$iv$iv.add(((Element) item$iv$iv).text());
                }
                tags = (List) destination$iv$iv;
                posterheaders = MapsKt.mapOf(TuplesKt.to("Referer", getBaseUrl(poster)));
                matchResultFind$default = Regex.find$default(new Regex("\\d, (\\d+)"), StringsKt.trim(document2.select("div.movie-info h1").text()).toString(), 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    str = null;
                } else {
                    str = null;
                }
                year = StringsKt.toIntOrNull(String.valueOf(str));
                if (document2.selectFirst("#season-data") != null) {
                    tvType = TvType.TvSeries;
                } else {
                    tvType = TvType.Movie;
                }
                tvType2 = tvType;
                elementSelectFirst2 = document2.selectFirst("div.meta-info");
                if (elementSelectFirst2 != null) {
                    description = null;
                } else {
                    description = null;
                }
                elementSelectFirst3 = document2.selectFirst("ul.action-left > li:nth-child(3) > a");
                if (elementSelectFirst3 != null) {
                    trailer = elementSelectFirst3.attr("href");
                } else {
                    trailer = null;
                }
                elementSelectFirst4 = document2.selectFirst("div.info-tag strong");
                if (elementSelectFirst4 != null) {
                    rating = elementSelectFirst4.text();
                } else {
                    rating = null;
                }
                $this$map$iv = document2.select("li.slider article");
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r17.hasNext()) {
                    Object $result3 = $result;
                    Element it3 = (Element) item$iv$iv2;
                    Iterable $this$map$iv5 = $this$map$iv;
                    elementSelectFirst6 = it3.selectFirst("h3");
                    if (elementSelectFirst6 != null) {
                        string2 = null;
                    } else {
                        string2 = null;
                    }
                    String recName2 = String.valueOf(string2);
                    StringBuilder sbAppend2 = new StringBuilder().append(baseurl);
                    String title6 = title;
                    Element elementSelectFirst9 = it3.selectFirst("a");
                    Intrinsics.checkNotNull(elementSelectFirst9);
                    String recHref2 = sbAppend2.append(elementSelectFirst9.attr("href")).toString();
                    LayarKacaProvider layarKacaProvider2 = this;
                    elementSelectFirst7 = it3.selectFirst("img");
                    if (elementSelectFirst7 != null) {
                        strAttr = elementSelectFirst7.attr("src");
                    } else {
                        strAttr = null;
                    }
                    final String recPosterUrl2 = MainAPIKt.fixUrl(layarKacaProvider2, String.valueOf(strAttr));
                    destination$iv$iv2.add(MainAPIKt.newTvSeriesSearchResponse$default(this, recName2, recHref2, TvType.TvSeries, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj4) {
                            return LayarKacaProvider.load$lambda$1$0(recPosterUrl2, posterheaders, (TvSeriesSearchResponse) obj4);
                        }
                    }, 8, (Object) null));
                    $result = $result3;
                    $this$map$iv = $this$map$iv5;
                    title = title6;
                }
                title2 = title;
                recommendations = (List) destination$iv$iv2;
                if (tvType2 == TvType.TvSeries) {
                    TvType tvType6 = TvType.Movie;
                    C00074 c00075 = new C00074(poster, posterheaders, year, description, tags, rating, recommendations, trailer, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl2);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(baseurl);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(posterheaders);
                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(year);
                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(description);
                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(trailer);
                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(rating);
                    c00052.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00052.label = 5;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2, url4, tvType6, url4, c00075, c00052);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    title3 = title2;
                    fixUrl3 = fixUrl2;
                    tvType3 = tvType2;
                    poster2 = poster;
                    posterheaders2 = posterheaders;
                    year2 = year;
                    description2 = description;
                    tags2 = tags;
                    title4 = rating;
                    recommendations2 = recommendations;
                    url5 = trailer;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                elementSelectFirst5 = document2.selectFirst("script#season-data");
                if (elementSelectFirst5 != null) {
                    strData = elementSelectFirst5.data();
                } else {
                    strData = null;
                }
                json = strData;
                episodes = new ArrayList();
                if (json != null) {
                    root = new JSONObject(json);
                    itKeys = root.keys();
                    while (itKeys.hasNext()) {
                        Object element$iv2 = itKeys.next();
                        String seasonKey2 = (String) element$iv2;
                        String json4 = json;
                        seasonArr = root.getJSONArray(seasonKey2);
                        Map posterheaders5 = posterheaders;
                        length = seasonArr.length();
                        JSONObject root3 = root;
                        episodeNo = 0;
                        while (episodeNo < length) {
                            int i3 = length;
                            JSONObject ep2 = seasonArr.getJSONObject(episodeNo);
                            JSONArray seasonArr3 = seasonArr;
                            int i4 = episodeNo;
                            Iterator<String> it4 = itKeys;
                            String href2 = MainAPIKt.fixUrl(this, baseurl + '/' + ep2.getString("slug"));
                            final int episodeNo3 = ep2.optInt("episode_no");
                            final int seasonNo2 = ep2.optInt("s");
                            episodes.add(MainAPIKt.newEpisode(this, href2, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj4) {
                                    return LayarKacaProvider.load$lambda$2$0(episodeNo3, seasonNo2, (Episode) obj4);
                                }
                            }));
                            episodeNo = i4 + 1;
                            length = i3;
                            seasonArr = seasonArr3;
                            itKeys = it4;
                            url4 = url4;
                        }
                        json = json4;
                        root = root3;
                        posterheaders = posterheaders5;
                    }
                    json2 = json;
                    posterheaders3 = posterheaders;
                    url6 = url4;
                } else {
                    json2 = json;
                    posterheaders3 = posterheaders;
                    url6 = url4;
                }
                TvType tvType7 = TvType.TvSeries;
                C00063 c00064 = new C00063(poster, posterheaders3, year, description, tags, rating, recommendations, trailer, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl2);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(baseurl);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                c00052.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                c00052.L$7 = SpillingKt.nullOutSpilledVariable(posterheaders3);
                c00052.L$8 = SpillingKt.nullOutSpilledVariable(year);
                c00052.L$9 = SpillingKt.nullOutSpilledVariable(tvType2);
                c00052.L$10 = SpillingKt.nullOutSpilledVariable(description);
                c00052.L$11 = SpillingKt.nullOutSpilledVariable(trailer);
                c00052.L$12 = SpillingKt.nullOutSpilledVariable(rating);
                c00052.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                c00052.L$14 = SpillingKt.nullOutSpilledVariable(json2);
                c00052.L$15 = SpillingKt.nullOutSpilledVariable(episodes);
                c00052.label = 4;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, url6, tvType7, episodes, c00064, c00052);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 2:
                String fixUrl4 = (String) c00052.L$1;
                String url8 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result);
                fixUrl = fixUrl4;
                obj3 = $result;
                obj = coroutine_suspended;
                url3 = url8;
                document = ((NiceResponse) obj3).getDocument();
                c00052.L$0 = url3;
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl);
                c00052.L$2 = document;
                c00052.label = 3;
                objFetchURL = fetchURL(fixUrl, c00052);
                if (objFetchURL == obj) {
                    return obj;
                }
                document2 = document;
                url4 = url3;
                fixUrl2 = fixUrl;
                baseurl = (String) objFetchURL;
                elementSelectFirst = document2.selectFirst("div.movie-info h1");
                if (elementSelectFirst != null) {
                    string = null;
                } else {
                    string = null;
                }
                title = String.valueOf(string);
                poster = document2.select("meta[property=og:image]").attr("content");
                Iterable $this$map$iv6 = document2.select("div.tag-list span");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
                while (r18.hasNext()) {
                    destination$iv$iv.add(((Element) item$iv$iv).text());
                }
                tags = (List) destination$iv$iv;
                posterheaders = MapsKt.mapOf(TuplesKt.to("Referer", getBaseUrl(poster)));
                matchResultFind$default = Regex.find$default(new Regex("\\d, (\\d+)"), StringsKt.trim(document2.select("div.movie-info h1").text()).toString(), 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    str = null;
                } else {
                    str = null;
                }
                year = StringsKt.toIntOrNull(String.valueOf(str));
                if (document2.selectFirst("#season-data") != null) {
                    tvType = TvType.TvSeries;
                } else {
                    tvType = TvType.Movie;
                }
                tvType2 = tvType;
                elementSelectFirst2 = document2.selectFirst("div.meta-info");
                if (elementSelectFirst2 != null) {
                    description = null;
                } else {
                    description = null;
                }
                elementSelectFirst3 = document2.selectFirst("ul.action-left > li:nth-child(3) > a");
                if (elementSelectFirst3 != null) {
                    trailer = elementSelectFirst3.attr("href");
                } else {
                    trailer = null;
                }
                elementSelectFirst4 = document2.selectFirst("div.info-tag strong");
                if (elementSelectFirst4 != null) {
                    rating = elementSelectFirst4.text();
                } else {
                    rating = null;
                }
                $this$map$iv = document2.select("li.slider article");
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r17.hasNext()) {
                    Object $result4 = $result;
                    Element it5 = (Element) item$iv$iv2;
                    Iterable $this$map$iv7 = $this$map$iv;
                    elementSelectFirst6 = it5.selectFirst("h3");
                    if (elementSelectFirst6 != null) {
                        string2 = null;
                    } else {
                        string2 = null;
                    }
                    String recName3 = String.valueOf(string2);
                    StringBuilder sbAppend3 = new StringBuilder().append(baseurl);
                    String title7 = title;
                    Element elementSelectFirst10 = it5.selectFirst("a");
                    Intrinsics.checkNotNull(elementSelectFirst10);
                    String recHref3 = sbAppend3.append(elementSelectFirst10.attr("href")).toString();
                    LayarKacaProvider layarKacaProvider3 = this;
                    elementSelectFirst7 = it5.selectFirst("img");
                    if (elementSelectFirst7 != null) {
                        strAttr = elementSelectFirst7.attr("src");
                    } else {
                        strAttr = null;
                    }
                    final String recPosterUrl3 = MainAPIKt.fixUrl(layarKacaProvider3, String.valueOf(strAttr));
                    destination$iv$iv2.add(MainAPIKt.newTvSeriesSearchResponse$default(this, recName3, recHref3, TvType.TvSeries, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj4) {
                            return LayarKacaProvider.load$lambda$1$0(recPosterUrl3, posterheaders, (TvSeriesSearchResponse) obj4);
                        }
                    }, 8, (Object) null));
                    $result = $result4;
                    $this$map$iv = $this$map$iv7;
                    title = title7;
                }
                title2 = title;
                recommendations = (List) destination$iv$iv2;
                if (tvType2 == TvType.TvSeries) {
                    TvType tvType8 = TvType.Movie;
                    C00074 c00076 = new C00074(poster, posterheaders, year, description, tags, rating, recommendations, trailer, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl2);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(baseurl);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(posterheaders);
                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(year);
                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(description);
                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(trailer);
                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(rating);
                    c00052.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00052.label = 5;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2, url4, tvType8, url4, c00076, c00052);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    title3 = title2;
                    fixUrl3 = fixUrl2;
                    tvType3 = tvType2;
                    poster2 = poster;
                    posterheaders2 = posterheaders;
                    year2 = year;
                    description2 = description;
                    tags2 = tags;
                    title4 = rating;
                    recommendations2 = recommendations;
                    url5 = trailer;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                elementSelectFirst5 = document2.selectFirst("script#season-data");
                if (elementSelectFirst5 != null) {
                    strData = elementSelectFirst5.data();
                } else {
                    strData = null;
                }
                json = strData;
                episodes = new ArrayList();
                if (json != null) {
                    root = new JSONObject(json);
                    itKeys = root.keys();
                    while (itKeys.hasNext()) {
                        Object element$iv3 = itKeys.next();
                        String seasonKey3 = (String) element$iv3;
                        String json5 = json;
                        seasonArr = root.getJSONArray(seasonKey3);
                        Map posterheaders6 = posterheaders;
                        length = seasonArr.length();
                        JSONObject root4 = root;
                        episodeNo = 0;
                        while (episodeNo < length) {
                            int i5 = length;
                            JSONObject ep3 = seasonArr.getJSONObject(episodeNo);
                            JSONArray seasonArr4 = seasonArr;
                            int i6 = episodeNo;
                            Iterator<String> it6 = itKeys;
                            String href3 = MainAPIKt.fixUrl(this, baseurl + '/' + ep3.getString("slug"));
                            final int episodeNo4 = ep3.optInt("episode_no");
                            final int seasonNo3 = ep3.optInt("s");
                            episodes.add(MainAPIKt.newEpisode(this, href3, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj4) {
                                    return LayarKacaProvider.load$lambda$2$0(episodeNo4, seasonNo3, (Episode) obj4);
                                }
                            }));
                            episodeNo = i6 + 1;
                            length = i5;
                            seasonArr = seasonArr4;
                            itKeys = it6;
                            url4 = url4;
                        }
                        json = json5;
                        root = root4;
                        posterheaders = posterheaders6;
                    }
                    json2 = json;
                    posterheaders3 = posterheaders;
                    url6 = url4;
                } else {
                    json2 = json;
                    posterheaders3 = posterheaders;
                    url6 = url4;
                }
                TvType tvType9 = TvType.TvSeries;
                C00063 c00065 = new C00063(poster, posterheaders3, year, description, tags, rating, recommendations, trailer, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl2);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(baseurl);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                c00052.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                c00052.L$7 = SpillingKt.nullOutSpilledVariable(posterheaders3);
                c00052.L$8 = SpillingKt.nullOutSpilledVariable(year);
                c00052.L$9 = SpillingKt.nullOutSpilledVariable(tvType2);
                c00052.L$10 = SpillingKt.nullOutSpilledVariable(description);
                c00052.L$11 = SpillingKt.nullOutSpilledVariable(trailer);
                c00052.L$12 = SpillingKt.nullOutSpilledVariable(rating);
                c00052.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                c00052.L$14 = SpillingKt.nullOutSpilledVariable(json2);
                c00052.L$15 = SpillingKt.nullOutSpilledVariable(episodes);
                c00052.label = 4;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, url6, tvType9, episodes, c00065, c00052);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 3:
                Document document3 = (Document) c00052.L$2;
                String fixUrl5 = (String) c00052.L$1;
                String url9 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result);
                url4 = url9;
                document2 = document3;
                objFetchURL = $result;
                obj = coroutine_suspended;
                fixUrl2 = fixUrl5;
                baseurl = (String) objFetchURL;
                elementSelectFirst = document2.selectFirst("div.movie-info h1");
                if (elementSelectFirst != null) {
                    string = null;
                } else {
                    string = null;
                }
                title = String.valueOf(string);
                poster = document2.select("meta[property=og:image]").attr("content");
                Iterable $this$map$iv8 = document2.select("div.tag-list span");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv8, 10));
                while (r18.hasNext()) {
                    destination$iv$iv.add(((Element) item$iv$iv).text());
                }
                tags = (List) destination$iv$iv;
                posterheaders = MapsKt.mapOf(TuplesKt.to("Referer", getBaseUrl(poster)));
                matchResultFind$default = Regex.find$default(new Regex("\\d, (\\d+)"), StringsKt.trim(document2.select("div.movie-info h1").text()).toString(), 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    str = null;
                } else {
                    str = null;
                }
                year = StringsKt.toIntOrNull(String.valueOf(str));
                if (document2.selectFirst("#season-data") != null) {
                    tvType = TvType.TvSeries;
                } else {
                    tvType = TvType.Movie;
                }
                tvType2 = tvType;
                elementSelectFirst2 = document2.selectFirst("div.meta-info");
                if (elementSelectFirst2 != null) {
                    description = null;
                } else {
                    description = null;
                }
                elementSelectFirst3 = document2.selectFirst("ul.action-left > li:nth-child(3) > a");
                if (elementSelectFirst3 != null) {
                    trailer = elementSelectFirst3.attr("href");
                } else {
                    trailer = null;
                }
                elementSelectFirst4 = document2.selectFirst("div.info-tag strong");
                if (elementSelectFirst4 != null) {
                    rating = elementSelectFirst4.text();
                } else {
                    rating = null;
                }
                $this$map$iv = document2.select("li.slider article");
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r17.hasNext()) {
                    Object $result5 = $result;
                    Element it7 = (Element) item$iv$iv2;
                    Iterable $this$map$iv9 = $this$map$iv;
                    elementSelectFirst6 = it7.selectFirst("h3");
                    if (elementSelectFirst6 != null) {
                        string2 = null;
                    } else {
                        string2 = null;
                    }
                    String recName4 = String.valueOf(string2);
                    StringBuilder sbAppend4 = new StringBuilder().append(baseurl);
                    String title8 = title;
                    Element elementSelectFirst11 = it7.selectFirst("a");
                    Intrinsics.checkNotNull(elementSelectFirst11);
                    String recHref4 = sbAppend4.append(elementSelectFirst11.attr("href")).toString();
                    LayarKacaProvider layarKacaProvider4 = this;
                    elementSelectFirst7 = it7.selectFirst("img");
                    if (elementSelectFirst7 != null) {
                        strAttr = elementSelectFirst7.attr("src");
                    } else {
                        strAttr = null;
                    }
                    final String recPosterUrl4 = MainAPIKt.fixUrl(layarKacaProvider4, String.valueOf(strAttr));
                    destination$iv$iv2.add(MainAPIKt.newTvSeriesSearchResponse$default(this, recName4, recHref4, TvType.TvSeries, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj4) {
                            return LayarKacaProvider.load$lambda$1$0(recPosterUrl4, posterheaders, (TvSeriesSearchResponse) obj4);
                        }
                    }, 8, (Object) null));
                    $result = $result5;
                    $this$map$iv = $this$map$iv9;
                    title = title8;
                }
                title2 = title;
                recommendations = (List) destination$iv$iv2;
                if (tvType2 == TvType.TvSeries) {
                    TvType tvType10 = TvType.Movie;
                    C00074 c00077 = new C00074(poster, posterheaders, year, description, tags, rating, recommendations, trailer, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl2);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(baseurl);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(posterheaders);
                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(year);
                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(description);
                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(trailer);
                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(rating);
                    c00052.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00052.label = 5;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2, url4, tvType10, url4, c00077, c00052);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    title3 = title2;
                    fixUrl3 = fixUrl2;
                    tvType3 = tvType2;
                    poster2 = poster;
                    posterheaders2 = posterheaders;
                    year2 = year;
                    description2 = description;
                    tags2 = tags;
                    title4 = rating;
                    recommendations2 = recommendations;
                    url5 = trailer;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                elementSelectFirst5 = document2.selectFirst("script#season-data");
                if (elementSelectFirst5 != null) {
                    strData = elementSelectFirst5.data();
                } else {
                    strData = null;
                }
                json = strData;
                episodes = new ArrayList();
                if (json != null) {
                    root = new JSONObject(json);
                    itKeys = root.keys();
                    while (itKeys.hasNext()) {
                        Object element$iv4 = itKeys.next();
                        String seasonKey4 = (String) element$iv4;
                        String json6 = json;
                        seasonArr = root.getJSONArray(seasonKey4);
                        Map posterheaders7 = posterheaders;
                        length = seasonArr.length();
                        JSONObject root5 = root;
                        episodeNo = 0;
                        while (episodeNo < length) {
                            int i7 = length;
                            JSONObject ep4 = seasonArr.getJSONObject(episodeNo);
                            JSONArray seasonArr5 = seasonArr;
                            int i8 = episodeNo;
                            Iterator<String> it8 = itKeys;
                            String href4 = MainAPIKt.fixUrl(this, baseurl + '/' + ep4.getString("slug"));
                            final int episodeNo5 = ep4.optInt("episode_no");
                            final int seasonNo4 = ep4.optInt("s");
                            episodes.add(MainAPIKt.newEpisode(this, href4, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj4) {
                                    return LayarKacaProvider.load$lambda$2$0(episodeNo5, seasonNo4, (Episode) obj4);
                                }
                            }));
                            episodeNo = i8 + 1;
                            length = i7;
                            seasonArr = seasonArr5;
                            itKeys = it8;
                            url4 = url4;
                        }
                        json = json6;
                        root = root5;
                        posterheaders = posterheaders7;
                    }
                    json2 = json;
                    posterheaders3 = posterheaders;
                    url6 = url4;
                } else {
                    json2 = json;
                    posterheaders3 = posterheaders;
                    url6 = url4;
                }
                TvType tvType11 = TvType.TvSeries;
                C00063 c00066 = new C00063(poster, posterheaders3, year, description, tags, rating, recommendations, trailer, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl2);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(baseurl);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                c00052.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                c00052.L$7 = SpillingKt.nullOutSpilledVariable(posterheaders3);
                c00052.L$8 = SpillingKt.nullOutSpilledVariable(year);
                c00052.L$9 = SpillingKt.nullOutSpilledVariable(tvType2);
                c00052.L$10 = SpillingKt.nullOutSpilledVariable(description);
                c00052.L$11 = SpillingKt.nullOutSpilledVariable(trailer);
                c00052.L$12 = SpillingKt.nullOutSpilledVariable(rating);
                c00052.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                c00052.L$14 = SpillingKt.nullOutSpilledVariable(json2);
                c00052.L$15 = SpillingKt.nullOutSpilledVariable(episodes);
                c00052.label = 4;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, url6, tvType11, episodes, c00066, c00052);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 4:
                ResultKt.throwOnFailure($result);
                objNewTvSeriesLoadResponse = $result;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 5:
                recommendations2 = (List) c00052.L$13;
                title4 = (String) c00052.L$12;
                url5 = (String) c00052.L$11;
                description2 = (String) c00052.L$10;
                tvType3 = (TvType) c00052.L$9;
                year2 = (Integer) c00052.L$8;
                posterheaders2 = (Map) c00052.L$7;
                tags2 = (List) c00052.L$6;
                poster2 = (String) c00052.L$5;
                title3 = (String) c00052.L$4;
                fixUrl3 = (String) c00052.L$1;
                ResultKt.throwOnFailure($result);
                objNewMovieLoadResponse = $result;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$1$0(String $recPosterUrl, Map $posterheaders, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($recPosterUrl);
        $this$newTvSeriesSearchResponse.setPosterHeaders($posterheaders);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2$0(int $episodeNo, int $seasonNo, Episode $this$newEpisode) {
        $this$newEpisode.setName("Episode " + $episodeNo);
        $this$newEpisode.setSeason(Integer.valueOf($seasonNo));
        $this$newEpisode.setEpisode(Integer.valueOf($episodeNo));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$load$3 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider$load$3", f = "LayarKacaProvider.kt", i = {0}, l = {172}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {173}, s = {"L$0"}, v = 2)
    static final class C00063 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ Map<String, String> $posterheaders;
        final /* synthetic */ String $rating;
        final /* synthetic */ List<TvSeriesSearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00063(String str, Map<String, String> map, Integer num, String str2, List<String> list, String str3, List<TvSeriesSearchResponse> list2, String str4, Continuation<? super C00063> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$posterheaders = map;
            this.$year = num;
            this.$description = str2;
            this.$tags = list;
            this.$rating = str3;
            this.$recommendations = list2;
            this.$trailer = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00063 = new C00063(this.$poster, this.$posterheaders, this.$year, this.$description, this.$tags, this.$rating, this.$recommendations, this.$trailer, continuation);
            c00063.L$0 = obj;
            return c00063;
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
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setPosterHeaders(this.$posterheaders);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setScore(Score.Companion.from10(this.$rating));
                    loadResponse.setRecommendations(this.$recommendations);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(loadResponse);
                    this.label = 1;
                    if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, this.$trailer, (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$load$4 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider$load$4", f = "LayarKacaProvider.kt", i = {0}, l = {183}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {184}, s = {"L$0"}, v = 2)
    static final class C00074 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ Map<String, String> $posterheaders;
        final /* synthetic */ String $rating;
        final /* synthetic */ List<TvSeriesSearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00074(String str, Map<String, String> map, Integer num, String str2, List<String> list, String str3, List<TvSeriesSearchResponse> list2, String str4, Continuation<? super C00074> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$posterheaders = map;
            this.$year = num;
            this.$description = str2;
            this.$tags = list;
            this.$rating = str3;
            this.$recommendations = list2;
            this.$trailer = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00074 = new C00074(this.$poster, this.$posterheaders, this.$year, this.$description, this.$tags, this.$rating, this.$recommendations, this.$trailer, continuation);
            c00074.L$0 = obj;
            return c00074;
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
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setPosterHeaders(this.$posterheaders);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setScore(Score.Companion.from10(this.$rating));
                    loadResponse.setRecommendations(this.$recommendations);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(loadResponse);
                    this.label = 1;
                    if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, this.$trailer, (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
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
    /* JADX WARN: Code duplicated, block: B:24:0x0148 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0149  */
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
        Document document;
        Iterable $this$map$iv;
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
                document = ((NiceResponse) $result).getDocument();
                $this$map$iv = document.select("ul#player-list > li");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Element it = (Element) item$iv$iv;
                    destination$iv$iv.add(MainAPIKt.fixUrl(this, it.select("a").attr("href")));
                    document = document;
                    $this$map$iv = $this$map$iv;
                }
                Document document2 = document;
                c00093 = new C00093(function3, function4, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(document2);
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
                document = ((NiceResponse) $result).getDocument();
                $this$map$iv = document.select("ul#player-list > li");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r14.hasNext()) {
                    Element it2 = (Element) item$iv$iv;
                    destination$iv$iv.add(MainAPIKt.fixUrl(this, it2.select("a").attr("href")));
                    document = document;
                    $this$map$iv = $this$map$iv;
                }
                Document document3 = document;
                c00093 = new C00093(function3, function4, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(document3);
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

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$loadLinks$3 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider$loadLinks$3", f = "LayarKacaProvider.kt", i = {0, 1, 1, 1, 2, 2, 2}, l = {198, 201, 201}, m = "invokeSuspend", n = {"it", "it", "test", "referer", "it", "test", "referer"}, nl = {199, 201, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00093 extends SuspendLambda implements Function2<String, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00093(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00093> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00093 = LayarKacaProvider.this.new C00093(this.$subtitleCallback, this.$callback, continuation);
            c00093.L$0 = obj;
            return c00093;
        }

        public final Object invoke(String str, Continuation<? super Boolean> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0074 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:15:0x0075  */
        /* JADX WARN: Code duplicated, block: B:18:0x009c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:19:0x009d  */
        public final Object invokeSuspend(Object $result) {
            Object iframe;
            String test;
            String referer;
            Object iframe2;
            String referer2;
            String test2;
            Object objLoadExtractor;
            String it = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = it;
                    this.label = 1;
                    iframe = LayarKacaProvider.this.getIframe(it, (Continuation) this);
                    if (iframe == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    test = (String) iframe;
                    referer = LayarKacaProvider.this.getBaseUrl(it);
                    Log.INSTANCE.d("Phisher", test);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(test);
                    this.L$2 = referer;
                    this.label = 2;
                    iframe2 = LayarKacaProvider.this.getIframe(it, (Continuation) this);
                    if (iframe2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    referer2 = test;
                    test2 = referer;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(test2);
                    this.label = 3;
                    objLoadExtractor = ExtractorApiKt.loadExtractor((String) iframe2, test2, this.$subtitleCallback, this.$callback, (Continuation) this);
                    if (objLoadExtractor == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objLoadExtractor;
                case 1:
                    ResultKt.throwOnFailure($result);
                    iframe = $result;
                    test = (String) iframe;
                    referer = LayarKacaProvider.this.getBaseUrl(it);
                    Log.INSTANCE.d("Phisher", test);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(test);
                    this.L$2 = referer;
                    this.label = 2;
                    iframe2 = LayarKacaProvider.this.getIframe(it, (Continuation) this);
                    if (iframe2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    referer2 = test;
                    test2 = referer;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(test2);
                    this.label = 3;
                    objLoadExtractor = ExtractorApiKt.loadExtractor((String) iframe2, test2, this.$subtitleCallback, this.$callback, (Continuation) this);
                    if (objLoadExtractor == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objLoadExtractor;
                case 2:
                    test2 = (String) this.L$2;
                    referer2 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    iframe2 = $result;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(test2);
                    this.label = 3;
                    objLoadExtractor = ExtractorApiKt.loadExtractor((String) iframe2, test2, this.$subtitleCallback, this.$callback, (Continuation) this);
                    if (objLoadExtractor == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objLoadExtractor;
                case 3:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object getIframe(String $this$getIframe, Continuation<? super String> continuation) {
        C00021 c00021;
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
                Requests app = MainActivityKt.getApp();
                String str = this.seriesUrl + '/';
                c00021.L$0 = SpillingKt.nullOutSpilledVariable($this$getIframe);
                c00021.label = 1;
                $result = Requests.get$default(app, $this$getIframe, (Map) null, str, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021, 4090, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return ((NiceResponse) $result).getDocument().select("div.embed-container iframe").attr("src");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object fetchURL(String url, Continuation<? super String> continuation) {
        C00011 c00011;
        String url2;
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
        Object $result = c00011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00011.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00011.L$0 = url;
                c00011.label = 1;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00011, 4062, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                url2 = url;
                break;
            case 1:
                url2 = (String) c00011.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse res = (NiceResponse) $result;
        String href = res.getHeaders().get("location");
        if (href != null) {
            URI it = new URI(href);
            return it.getScheme() + "://" + it.getHost();
        }
        return url2;
    }

    private final String getImageAttr(Element $this$getImageAttr) {
        if ($this$getImageAttr.hasAttr("src")) {
            return $this$getImageAttr.attr("src");
        }
        if ($this$getImageAttr.hasAttr("data-src")) {
            return $this$getImageAttr.attr("data-src");
        }
        return $this$getImageAttr.attr("src");
    }

    @NotNull
    public final String getBaseUrl(@Nullable String url) {
        URI it = new URI(url);
        return it.getScheme() + "://" + it.getHost();
    }
}
