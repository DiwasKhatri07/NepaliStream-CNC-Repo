package com.dudefilms;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
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
import kotlin.Result;
import kotlin.ResultKt;
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
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: dudefilms.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/DudeFilms/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J\f\u0010(\u001a\u00020)*\u00020*H\u0002J\u001e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00102JF\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u00112\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000209072\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020907H\u0096@¢\u0006\u0002\u0010<R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006>"}, d2 = {"Lcom/dudefilms/Dudefilms;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "DudeFilms"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\ndudefilms.kt\nKotlin\n*S Kotlin\n*F\n+ 1 dudefilms.kt\ncom/dudefilms/Dudefilms\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 6 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 7 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,261:1\n1795#2,10:262\n2068#2:272\n2069#2:274\n1805#2:275\n1795#2,10:277\n2068#2:287\n2069#2:289\n1805#2:290\n2068#2:314\n832#2:315\n862#2,2:316\n2068#2:318\n2068#2:319\n2069#2:327\n2069#2:328\n2069#2:329\n296#2,2:333\n1#3:273\n1#3:276\n1#3:288\n1#3:294\n1#3:339\n93#4,2:291\n63#4:293\n64#4,15:295\n95#4,2:312\n93#4,2:336\n63#4:338\n64#4,15:340\n95#4,2:357\n50#5:310\n43#5:311\n50#5:355\n43#5:356\n460#6,7:320\n129#7:330\n158#7,2:331\n160#7:335\n*S KotlinDebug\n*F\n+ 1 dudefilms.kt\ncom/dudefilms/Dudefilms\n*L\n68#1:262,10\n68#1:272\n68#1:274\n68#1:275\n88#1:277,10\n88#1:287\n88#1:289\n88#1:290\n148#1:314\n162#1:315\n162#1:316,2\n163#1:318\n170#1:319\n170#1:327\n163#1:328\n148#1:329\n198#1:333,2\n68#1:273\n88#1:288\n132#1:294\n255#1:339\n132#1:291,2\n132#1:293\n132#1:295,15\n132#1:312,2\n255#1:336,2\n255#1:338\n255#1:340,15\n255#1:357,2\n132#1:310\n132#1:311\n255#1:355\n255#1:356\n186#1:320,7\n194#1:330\n194#1:331,2\n194#1:335\n*E\n"})
public final class Dudefilms extends MainAPI {

    @NotNull
    private static final String cinemeta_url = "https://v3-cinemeta.strem.io/meta";
    private final boolean hasQuickSearch;

    @NotNull
    private String mainUrl = (String) BuildersKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new Dudefilms$mainUrl$1(null));

    @NotNull
    private String name = "Dudefilms";

    @NotNull
    private String lang = "hi";
    private final boolean hasMainPage = true;
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("", "HomePage"), TuplesKt.to("category/bollywood", "Bollywood"), TuplesKt.to("category/hollywood", "Hollywood"), TuplesKt.to("category/gujarati", "Gujarati"), TuplesKt.to("category/southindian", "South Indian"), TuplesKt.to("category/webseries", "Web Series"), TuplesKt.to("category/adult/", "Adult")});

    /* JADX INFO: renamed from: com.dudefilms.Dudefilms$getMainPage$1 */
    /* JADX INFO: compiled from: dudefilms.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.dudefilms.Dudefilms", f = "dudefilms.kt", i = {0, 0, 1, 1}, l = {66, 66}, m = "getMainPage", n = {"request", "page", "request", "page"}, nl = {66, 68}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 2)
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
            return Dudefilms.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.dudefilms.Dudefilms$load$1 */
    /* JADX INFO: compiled from: dudefilms.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.dudefilms.Dudefilms", f = "dudefilms.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {94, 113, 130, 168, 212, 229}, m = "load", n = {"url", "url", "doc", "title", "poster", "plot", "descriptions", "typeraw", "year", "tvtype", "genre", "background", "description", "cast", "url", "doc", "title", "poster", "plot", "descriptions", "typeraw", "year", "tvtype", "genre", "background", "description", "cast", "hrefs", "imdbId", "typeset", "url", "doc", "title", "poster", "plot", "descriptions", "typeraw", "year", "tvtype", "genre", "background", "description", "cast", "hrefs", "imdbId", "typeset", "responseData", "episodeUrlMap", "$this$forEach$iv", "element$iv", "h4", "sibling", "$this$forEach$iv", "element$iv", "seasonButton", "seasonPageUrl", "seasonNumber", "url", "doc", "title", "poster", "plot", "descriptions", "typeraw", "year", "tvtype", "genre", "background", "description", "cast", "hrefs", "imdbId", "typeset", "responseData", "episodeUrlMap", "episodes", "url", "doc", "title", "poster", "plot", "descriptions", "typeraw", "year", "tvtype", "genre", "background", "description", "cast", "hrefs", "imdbId", "typeset", "responseData"}, nl = {96, 119, 131, 170, 229, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$20", "L$21", "L$22", "L$23", "L$25", "L$26", "L$27", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
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
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$22;
        Object L$23;
        Object L$24;
        Object L$25;
        Object L$26;
        Object L$27;
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
            return Dudefilms.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.dudefilms.Dudefilms$loadLinks$1 */
    /* JADX INFO: compiled from: dudefilms.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.dudefilms.Dudefilms", f = "dudefilms.kt", i = {0, 0, 0, 0, 0}, l = {256}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "links", "isCasting"}, nl = {259}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
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
            return Dudefilms.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.dudefilms.Dudefilms$search$1 */
    /* JADX INFO: compiled from: dudefilms.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.dudefilms.Dudefilms", f = "dudefilms.kt", i = {0, 0}, l = {87}, m = "search", n = {"query", "page"}, nl = {88}, s = {"L$0", "I$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Dudefilms.this.search(null, 0, (Continuation) this);
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

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
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

    /* JADX WARN: Code duplicated, block: B:27:0x0149  */
    /* JADX WARN: Code duplicated, block: B:29:0x015c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0161 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        boolean z;
        C00001 c00002;
        Document doc;
        Collection destination$iv$iv;
        SearchResponse searchResult;
        int page2 = page;
        MainPageRequest request2 = request;
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
                if (page2 != 1) {
                    C00001 c00003 = c00001;
                    z = true;
                    Requests app = MainActivityKt.getApp();
                    String str = getMainUrl() + '/' + request2.getData() + "page/" + page2;
                    c00003.L$0 = request2;
                    c00003.I$0 = page2;
                    c00003.label = 2;
                    $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00003, 4094, (Object) null);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    doc = ((NiceResponse) $result).getDocument();
                    Iterable $this$mapNotNull$iv = doc.select("div.simple-grid-grid-post");
                    destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        int page3 = page2;
                        Element it = (Element) element$iv$iv$iv;
                        searchResult = toSearchResult(it);
                        if (searchResult != null) {
                            destination$iv$iv.add(searchResult);
                        }
                        page2 = page3;
                    }
                    List home = (List) destination$iv$iv;
                    return MainAPIKt.newHomePageResponse(request2.getName(), home, Boxing.boxBoolean(z));
                }
                Requests app2 = MainActivityKt.getApp();
                String str2 = getMainUrl() + '/' + request2.getData();
                c00001.L$0 = request2;
                c00001.I$0 = page2;
                c00001.label = 1;
                z = true;
                C00001 c00004 = c00001;
                $result = Requests.get$default(app2, str2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00004, 4094, (Object) null);
                c00002 = c00004;
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                doc = ((NiceResponse) $result).getDocument();
                Iterable $this$mapNotNull$iv2 = doc.select("div.simple-grid-grid-post");
                destination$iv$iv = new ArrayList();
                while (r12.hasNext()) {
                    int page4 = page2;
                    Element it2 = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it2);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                    page2 = page4;
                }
                List home2 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(request2.getName(), home2, Boxing.boxBoolean(z));
            case 1:
                page2 = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                c00002 = c00001;
                z = true;
                doc = ((NiceResponse) $result).getDocument();
                Iterable $this$mapNotNull$iv3 = doc.select("div.simple-grid-grid-post");
                destination$iv$iv = new ArrayList();
                while (r12.hasNext()) {
                    int page5 = page2;
                    Element it3 = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it3);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                    page2 = page5;
                }
                List home3 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(request2.getName(), home3, Boxing.boxBoolean(z));
            case 2:
                page2 = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                doc = ((NiceResponse) $result).getDocument();
                Iterable $this$mapNotNull$iv4 = doc.select("div.simple-grid-grid-post");
                destination$iv$iv = new ArrayList();
                while (r12.hasNext()) {
                    int page6 = page2;
                    Element it4 = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it4);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                    page2 = page6;
                }
                List home4 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(request2.getName(), home4, Boxing.boxBoolean(z));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        Element elementSelectFirst = $this$toSearchResult.selectFirst("h3");
        final String title = UtilsKt.cleanTitle(elementSelectFirst != null ? elementSelectFirst.text() : null);
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult.select("h3 a").attr("href"));
        Dudefilms dudefilms = this;
        Elements img = $this$toSearchResult.select("img");
        String it = img.attr("data-src");
        String strAttr = StringsKt.isBlank(it) ? null : it;
        if (strAttr == null) {
            strAttr = img.attr("src");
        }
        final String posterUrl = MainAPIKt.fixUrlNull(dudefilms, strAttr);
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.dudefilms.Dudefilms$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Dudefilms.toSearchResult$lambda$1(posterUrl, title, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$1(String $posterUrl, String $title, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setQuality(UtilsKt.getSearchQuality($title));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00061 c00061;
        if (continuation instanceof C00061) {
            c00061 = (C00061) continuation;
            if ((c00061.label & Integer.MIN_VALUE) != 0) {
                c00061.label -= Integer.MIN_VALUE;
            } else {
                c00061 = new C00061(continuation);
            }
        } else {
            c00061 = new C00061(continuation);
        }
        Object $result = c00061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00061.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/page/" + page + "/?s=" + query;
                c00061.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00061.I$0 = page;
                c00061.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00061, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00061.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document doc = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = doc.select("div.simple-grid-grid-post");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List res = (List) destination$iv$iv;
        return MainAPIKt.toNewSearchResponseList$default(res, (Boolean) null, 1, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:141:0x06d0  */
    /* JADX WARN: Code duplicated, block: B:143:0x0700  */
    /* JADX WARN: Code duplicated, block: B:201:0x0a53 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:149:0x0717 -> B:150:0x0726). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:161:0x077d -> B:162:0x07c7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:169:0x088f -> B:170:0x08b3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:192:0x09ab -> B:193:0x09c7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:202:0x0a59 -> B:203:0x0a63). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r65, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r66) {
        /*
            Method dump skipped, instruction units count: 3322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dudefilms.Dudefilms.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$1$1(ResponseData.Meta.EpisodeDetails $metaEpisode, int $seasonNumber, int $episodeNumber, Episode $this$newEpisode) {
        $this$newEpisode.setName($metaEpisode != null ? $metaEpisode.getName() : null);
        $this$newEpisode.setSeason(Integer.valueOf($seasonNumber));
        $this$newEpisode.setEpisode(Integer.valueOf($episodeNumber));
        $this$newEpisode.setPosterUrl($metaEpisode != null ? $metaEpisode.getThumbnail() : null);
        $this$newEpisode.setDescription($metaEpisode != null ? $metaEpisode.getOverview() : null);
        MainAPIKt.addDate$default($this$newEpisode, $metaEpisode != null ? $metaEpisode.getReleased() : null, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.dudefilms.Dudefilms$load$3 */
    /* JADX INFO: compiled from: dudefilms.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.dudefilms.Dudefilms$load$3", f = "dudefilms.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00023 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $background;
        final /* synthetic */ Ref.ObjectRef<List<String>> $cast;
        final /* synthetic */ Ref.ObjectRef<String> $description;
        final /* synthetic */ Ref.ObjectRef<List<String>> $genre;
        final /* synthetic */ String $imdbId;
        final /* synthetic */ String $plot;
        final /* synthetic */ String $poster;
        final /* synthetic */ ResponseData $responseData;
        final /* synthetic */ Ref.ObjectRef<Integer> $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00023(Ref.ObjectRef<String> objectRef, String str, ResponseData responseData, Ref.ObjectRef<Integer> objectRef2, Ref.ObjectRef<String> objectRef3, String str2, Ref.ObjectRef<List<String>> objectRef4, Ref.ObjectRef<List<String>> objectRef5, String str3, Continuation<? super C00023> continuation) {
            super(2, continuation);
            this.$background = objectRef;
            this.$poster = str;
            this.$responseData = responseData;
            this.$year = objectRef2;
            this.$description = objectRef3;
            this.$plot = str2;
            this.$genre = objectRef4;
            this.$cast = objectRef5;
            this.$imdbId = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00023 = new C00023(this.$background, this.$poster, this.$responseData, this.$year, this.$description, this.$plot, this.$genre, this.$cast, this.$imdbId, continuation);
            c00023.L$0 = obj;
            return c00023;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Integer intOrNull;
            ResponseData.Meta meta;
            ResponseData.Meta meta2;
            String year;
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = (String) this.$background.element;
                    if (str == null) {
                        str = this.$poster;
                    }
                    loadResponse.setBackgroundPosterUrl(str);
                    loadResponse.setPosterUrl(this.$poster);
                    ResponseData responseData = this.$responseData;
                    if (responseData == null || (meta2 = responseData.getMeta()) == null || (year = meta2.getYear()) == null || (intOrNull = StringsKt.toIntOrNull(year)) == null) {
                        intOrNull = (Integer) this.$year.element;
                    }
                    loadResponse.setYear(intOrNull);
                    String str2 = (String) this.$description.element;
                    if (str2 == null) {
                        str2 = this.$plot;
                    }
                    loadResponse.setPlot(str2);
                    loadResponse.setTags((List) this.$genre.element);
                    LoadResponse.Companion.addActorNames(loadResponse, (List) this.$cast.element);
                    Score.Companion companion = Score.Companion;
                    ResponseData responseData2 = this.$responseData;
                    loadResponse.setScore(companion.from10((responseData2 == null || (meta = responseData2.getMeta()) == null) ? null : meta.getImdbRating()));
                    LoadResponse.Companion.addImdbId(loadResponse, this.$imdbId);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.dudefilms.Dudefilms$load$4 */
    /* JADX INFO: compiled from: dudefilms.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.dudefilms.Dudefilms$load$4", f = "dudefilms.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00034 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $background;
        final /* synthetic */ Ref.ObjectRef<List<String>> $cast;
        final /* synthetic */ Ref.ObjectRef<String> $description;
        final /* synthetic */ Ref.ObjectRef<List<String>> $genre;
        final /* synthetic */ String $imdbId;
        final /* synthetic */ String $plot;
        final /* synthetic */ String $poster;
        final /* synthetic */ ResponseData $responseData;
        final /* synthetic */ Ref.ObjectRef<Integer> $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00034(Ref.ObjectRef<String> objectRef, String str, ResponseData responseData, Ref.ObjectRef<Integer> objectRef2, Ref.ObjectRef<String> objectRef3, String str2, Ref.ObjectRef<List<String>> objectRef4, Ref.ObjectRef<List<String>> objectRef5, String str3, Continuation<? super C00034> continuation) {
            super(2, continuation);
            this.$background = objectRef;
            this.$poster = str;
            this.$responseData = responseData;
            this.$year = objectRef2;
            this.$description = objectRef3;
            this.$plot = str2;
            this.$genre = objectRef4;
            this.$cast = objectRef5;
            this.$imdbId = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00034 = new C00034(this.$background, this.$poster, this.$responseData, this.$year, this.$description, this.$plot, this.$genre, this.$cast, this.$imdbId, continuation);
            c00034.L$0 = obj;
            return c00034;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Integer intOrNull;
            ResponseData.Meta meta;
            ResponseData.Meta meta2;
            String year;
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = (String) this.$background.element;
                    if (str == null) {
                        str = this.$poster;
                    }
                    loadResponse.setBackgroundPosterUrl(str);
                    loadResponse.setPosterUrl(this.$poster);
                    ResponseData responseData = this.$responseData;
                    if (responseData == null || (meta2 = responseData.getMeta()) == null || (year = meta2.getYear()) == null || (intOrNull = StringsKt.toIntOrNull(year)) == null) {
                        intOrNull = (Integer) this.$year.element;
                    }
                    loadResponse.setYear(intOrNull);
                    String str2 = (String) this.$description.element;
                    if (str2 == null) {
                        str2 = this.$plot;
                    }
                    loadResponse.setPlot(str2);
                    loadResponse.setTags((List) this.$genre.element);
                    LoadResponse.Companion.addActorNames(loadResponse, (List) this.$cast.element);
                    Score.Companion companion = Score.Companion;
                    ResponseData responseData2 = this.$responseData;
                    loadResponse.setScore(companion.from10((responseData2 == null || (meta = responseData2.getMeta()) == null) ? null : meta.getImdbRating()));
                    LoadResponse.Companion.addImdbId(loadResponse, this.$imdbId);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00041 c00041;
        Object obj;
        Object obj2;
        Object objDecodeFromString;
        boolean z;
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
                AppUtils appUtils = AppUtils.INSTANCE;
                if (data == null) {
                    obj2 = null;
                } else {
                    try {
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)));
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            } catch (Throwable th2) {
                                Result.Companion companion4 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th2));
                            }
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) (Result.isFailure-impl(obj) ? null : obj);
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                            } catch (SerializationException e) {
                                ArchComponentExtKt.logError(e);
                                ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv.readValue(data, new TypeReference<List<? extends String>>() { // from class: com.dudefilms.Dudefilms$loadLinks$$inlined$tryParseJson$1
                                });
                            } catch (Throwable th3) {
                                ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(data, new TypeReference<List<? extends String>>() { // from class: com.dudefilms.Dudefilms$loadLinks$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(data, new TypeReference<List<? extends String>>() { // from class: com.dudefilms.Dudefilms$loadLinks$$inlined$tryParseJson$1
                            });
                        }
                        obj2 = objDecodeFromString;
                    } catch (Exception e2) {
                        obj2 = null;
                    }
                }
                List links = (List) obj2;
                if (links == null) {
                    links = CollectionsKt.emptyList();
                }
                C00052 c00052 = new C00052(function1, function2, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(links);
                c00042.Z$0 = isCasting;
                z = true;
                c00042.label = 1;
                if (ParCollectionsKt.amap(links, c00052, c00042) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                boolean z2 = c00042.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: renamed from: com.dudefilms.Dudefilms$loadLinks$2 */
    /* JADX INFO: compiled from: dudefilms.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.dudefilms.Dudefilms$loadLinks$2", f = "dudefilms.kt", i = {0}, l = {257}, m = "invokeSuspend", n = {"it"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class C00052 extends SuspendLambda implements Function2<String, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00052(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00052> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00052 = Dudefilms.this.new C00052(this.$subtitleCallback, this.$callback, continuation);
            c00052.L$0 = obj;
            return c00052;
        }

        public final Object invoke(String str, Continuation<? super Boolean> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String it = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.label = 1;
                    Object objLoadExtractor = ExtractorApiKt.loadExtractor(it, Dudefilms.this.getName(), this.$subtitleCallback, this.$callback, (Continuation) this);
                    if (objLoadExtractor == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objLoadExtractor;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
