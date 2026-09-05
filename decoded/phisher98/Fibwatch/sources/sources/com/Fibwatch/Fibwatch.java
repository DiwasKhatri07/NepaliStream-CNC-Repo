package com.Fibwatch;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
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
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
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
import kotlin.collections.MapsKt;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
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

/* JADX INFO: compiled from: Fibwatch.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Fibwatch/classes.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J\f\u0010(\u001a\u00020)*\u00020*H\u0002J\u001e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00102JF\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u000e2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000209072\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020907H\u0096@¢\u0006\u0002\u0010<R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006="}, d2 = {"Lcom/Fibwatch/Fibwatch;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "loadLinksMutex", "Lkotlinx/coroutines/sync/Mutex;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Fibwatch"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFibwatch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Fibwatch.kt\ncom/Fibwatch/Fibwatch\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,363:1\n1795#2,10:364\n2068#2:374\n2069#2:376\n1805#2:377\n1795#2,10:378\n2068#2:388\n2069#2:390\n1805#2:391\n777#2:415\n873#2,2:416\n1#3:375\n1#3:389\n1#3:395\n93#4,2:392\n63#4:394\n64#4,15:396\n95#4,2:413\n50#5:411\n43#5:412\n*S KotlinDebug\n*F\n+ 1 Fibwatch.kt\ncom/Fibwatch/Fibwatch\n*L\n70#1:364,10\n70#1:374\n70#1:376\n70#1:377\n95#1:378,10\n95#1:388\n95#1:390\n95#1:391\n311#1:415\n311#1:416,2\n70#1:375\n95#1:389\n305#1:395\n305#1:392,2\n305#1:394\n305#1:396,15\n305#1:413,2\n305#1:411\n305#1:412\n*E\n"})
public class Fibwatch extends MainAPI {

    @NotNull
    private String mainUrl = (String) BuildersKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new Fibwatch$mainUrl$1(null));

    @NotNull
    private String name = "FibWatch";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private final Mutex loadLinksMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("videos/trending", "Trending Videos"), TuplesKt.to("videos/top", "Top Videos"), TuplesKt.to("videos/latest", "Latest Videos"), TuplesKt.to("videos/category/1", "Bangla–Kolkata Movies"), TuplesKt.to("videos/category/852", "Bangla Dubbed"), TuplesKt.to("videos/category/3", "Web Series"), TuplesKt.to("videos/category/4", "Hindi Movies"), TuplesKt.to("videos/category/5", "Hindi Dubbed Movies"), TuplesKt.to("videos/category/9", "Horror Movies"), TuplesKt.to("videos/category/6", "Tamil & Telugu Movies"), TuplesKt.to("videos/category/11", "Kannada Movies"), TuplesKt.to("videos/category/10", "Malayalam Movies"), TuplesKt.to("videos/category/8", "English Movies"), TuplesKt.to("videos/category/12", "Korean Movies"), TuplesKt.to("videos/category/13", "Marathi Movies"), TuplesKt.to("videos/category/7", "Cartoon Movies"), TuplesKt.to("videos/category/853", "Mixed Content"), TuplesKt.to("videos/category/854", "TV Shows"), TuplesKt.to("videos/category/855", "Natok"), TuplesKt.to("videos/category/other", "Other")});

    /* JADX INFO: renamed from: com.Fibwatch.Fibwatch$getMainPage$1 */
    /* JADX INFO: compiled from: Fibwatch.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Fibwatch.Fibwatch", f = "Fibwatch.kt", i = {0, 0, 0}, l = {69}, m = "getMainPage$suspendImpl", n = {"$this", "request", "page"}, nl = {70}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Fibwatch.getMainPage$suspendImpl(Fibwatch.this, 0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Fibwatch.Fibwatch$loadLinks$1 */
    /* JADX INFO: compiled from: Fibwatch.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Fibwatch.Fibwatch", f = "Fibwatch.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {307, 313}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "loadData", "isCasting", "$this", "data", "subtitleCallback", "callback", "loadData", "currentUrls", "combined", "isCasting"}, nl = {308, 354}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Fibwatch.loadLinks$suspendImpl(Fibwatch.this, null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Fibwatch.Fibwatch$search$1 */
    /* JADX INFO: compiled from: Fibwatch.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Fibwatch.Fibwatch", f = "Fibwatch.kt", i = {0, 0, 0}, l = {94}, m = "search$suspendImpl", n = {"$this", "query", "page"}, nl = {95}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Fibwatch.search$suspendImpl(Fibwatch.this, null, 0, (Continuation) this);
        }
    }

    @Nullable
    public Object getMainPage(int i, @NotNull MainPageRequest mainPageRequest, @NotNull Continuation<? super HomePageResponse> continuation) {
        return getMainPage$suspendImpl(this, i, mainPageRequest, continuation);
    }

    @Nullable
    public Object load(@NotNull String str, @NotNull Continuation<? super LoadResponse> continuation) {
        return load$suspendImpl(this, str, continuation);
    }

    @Nullable
    public Object loadLinks(@NotNull String str, boolean z, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        return loadLinks$suspendImpl(this, str, z, function1, function2, continuation);
    }

    @Nullable
    public Object search(@NotNull String str, int i, @NotNull Continuation<? super SearchResponseList> continuation) {
        return search$suspendImpl(this, str, i, continuation);
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
    static /* synthetic */ Object getMainPage$suspendImpl(Fibwatch $this, int page, MainPageRequest request, Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        MainPageRequest request2;
        Fibwatch $this2;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = $this.new C00001(continuation);
            }
        } else {
            c00001 = $this.new C00001(continuation);
        }
        Object $result = c00001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = $this.getMainUrl() + '/' + request.getData() + "?page_id=" + page;
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("pop_up_18", "yes"));
                c00001.L$0 = $this;
                c00001.L$1 = request;
                c00001.I$0 = page;
                c00001.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, mapMapOf, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4078, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                $this2 = $this;
                break;
                break;
            case 1:
                int i = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$1;
                Fibwatch $this3 = (Fibwatch) c00001.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this3;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.video-thumb");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = $this2.toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), home, true), Boxing.boxBoolean(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String strAttr;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("p.hptag");
        if (elementSelectFirst == null || (strAttr = elementSelectFirst.text()) == null) {
            Element elementSelectFirst2 = $this$toSearchResult.selectFirst("div.video-thumb img");
            strAttr = elementSelectFirst2 != null ? elementSelectFirst2.attr("alt") : null;
        }
        String title = UtilsKt.cleanTitle(strAttr);
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult.select("a").attr("href"));
        final String posterUrl = MainAPIKt.fixUrlNull(this, $this$toSearchResult.select("img").attr("src"));
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Fibwatch.Fibwatch$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Fibwatch.toSearchResult$lambda$0(posterUrl, this, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, Fibwatch this$0, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this$0.getMainUrl())));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    static /* synthetic */ Object search$suspendImpl(Fibwatch $this, String query, int page, Continuation<? super SearchResponseList> continuation) {
        C00041 c00041;
        Fibwatch $this2;
        if (continuation instanceof C00041) {
            c00041 = (C00041) continuation;
            if ((c00041.label & Integer.MIN_VALUE) != 0) {
                c00041.label -= Integer.MIN_VALUE;
            } else {
                c00041 = $this.new C00041(continuation);
            }
        } else {
            c00041 = $this.new C00041(continuation);
        }
        Object $result = c00041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00041.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = $this.getMainUrl() + "/search?keyword=" + query + "&page_id=" + page;
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("pop_up_18", "yes"));
                c00041.L$0 = $this;
                c00041.L$1 = SpillingKt.nullOutSpilledVariable(query);
                c00041.I$0 = page;
                c00041.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, mapMapOf, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00041, 4078, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this2 = $this;
                break;
                break;
            case 1:
                int i = c00041.I$0;
                Fibwatch $this3 = (Fibwatch) c00041.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this3;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.video-thumb");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = $this2.toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        return MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv, (Boolean) null, 1, (Object) null);
    }

    /* JADX INFO: renamed from: com.Fibwatch.Fibwatch$load$2 */
    /* JADX INFO: compiled from: Fibwatch.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/LoadResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Fibwatch.Fibwatch$load$2", f = "Fibwatch.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {99, 136, 180, 185, 193, 277, 285}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "document", "rawTitle", "title", "poster", "description", "rawTitleLower", "sxeRegex", "seasonRegex", "episodeRegex", "tvType", "videoId", "toLoadItem", "dedupeByUrl", "regex", "directUrl", "$this$invokeSuspend_u24lambda_u243", "$this$withContext", "document", "rawTitle", "title", "poster", "description", "rawTitleLower", "sxeRegex", "seasonRegex", "episodeRegex", "tvType", "videoId", "toLoadItem", "dedupeByUrl", "regex", "directUrl", "links", "currentRaw", "popupRaw", "currentList", "popupList", "out", "recommendations", "$this$invokeSuspend_u24lambda_u249", "$this$withContext", "document", "rawTitle", "title", "poster", "description", "rawTitleLower", "sxeRegex", "seasonRegex", "episodeRegex", "tvType", "videoId", "toLoadItem", "dedupeByUrl", "regex", "directUrl", "links", "currentRaw", "popupRaw", "currentList", "popupList", "out", "recommendations", "data", "episodesList", "$this$withContext", "document", "rawTitle", "title", "poster", "description", "rawTitleLower", "sxeRegex", "seasonRegex", "episodeRegex", "tvType", "videoId", "toLoadItem", "dedupeByUrl", "regex", "directUrl", "links", "currentRaw", "popupRaw", "currentList", "popupList", "out", "recommendations", "data", "episodesList", "semaphore", "$this$withContext", "document", "rawTitle", "title", "poster", "description", "rawTitleLower", "sxeRegex", "seasonRegex", "episodeRegex", "tvType", "videoId", "toLoadItem", "dedupeByUrl", "regex", "directUrl", "links", "currentRaw", "popupRaw", "currentList", "popupList", "out", "recommendations", "data", "episodesList", "semaphore", "episodes", "$this$withContext", "document", "rawTitle", "title", "poster", "description", "rawTitleLower", "sxeRegex", "seasonRegex", "episodeRegex", "tvType", "videoId", "toLoadItem", "dedupeByUrl", "regex", "directUrl", "links", "currentRaw", "popupRaw", "currentList", "popupList", "out", "recommendations"}, nl = {101, 365, 418, 192, 277, 285, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22"}, v = 2)
    @SourceDebugExtension({"SMAP\nFibwatch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Fibwatch.kt\ncom/Fibwatch/Fibwatch$load$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,363:1\n1#2:364\n1#2:381\n1#2:395\n1#2:415\n73#3,5:365\n73#3,5:418\n1795#4,10:370\n2068#4:380\n2069#4:382\n1805#4:383\n1795#4,10:384\n2068#4:394\n2069#4:396\n1805#4:397\n777#4:398\n873#4:399\n2945#4,3:400\n874#4:403\n1795#4,10:404\n2068#4:414\n2069#4:416\n1805#4:417\n777#4:423\n873#4,2:424\n*S KotlinDebug\n*F\n+ 1 Fibwatch.kt\ncom/Fibwatch/Fibwatch$load$2\n*L\n141#1:381\n145#1:395\n175#1:415\n136#1:365,5\n180#1:418,5\n141#1:370,10\n141#1:380\n141#1:382\n141#1:383\n145#1:384,10\n145#1:394\n145#1:396\n145#1:397\n149#1:398\n149#1:399\n149#1:400,3\n149#1:403\n175#1:404,10\n175#1:414\n175#1:416\n175#1:417\n126#1:423\n126#1:424,2\n*E\n"})
    static final class C00012 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LoadResponse>, Object> {
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
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
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ Fibwatch this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00012(String str, Fibwatch fibwatch, Continuation<? super C00012> continuation) {
            super(2, continuation);
            this.$url = str;
            this.this$0 = fibwatch;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00012 = new C00012(this.$url, this.this$0, continuation);
            c00012.L$0 = obj;
            return c00012;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super LoadResponse> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:111:0x06d3  */
        /* JADX WARN: Code duplicated, block: B:121:0x0766  */
        /* JADX WARN: Code duplicated, block: B:125:0x0789  */
        /* JADX WARN: Code duplicated, block: B:147:0x07f0  */
        /* JADX WARN: Code duplicated, block: B:149:0x07f4  */
        /* JADX WARN: Code duplicated, block: B:150:0x080f  */
        /* JADX WARN: Code duplicated, block: B:152:0x0814  */
        /* JADX WARN: Code duplicated, block: B:155:0x082c  */
        /* JADX WARN: Code duplicated, block: B:158:0x0835  */
        /* JADX WARN: Code duplicated, block: B:180:0x089e  */
        /* JADX WARN: Code duplicated, block: B:182:0x08a2  */
        /* JADX WARN: Code duplicated, block: B:183:0x08bc  */
        /* JADX WARN: Code duplicated, block: B:185:0x08c1  */
        /* JADX WARN: Code duplicated, block: B:188:0x08d9  */
        /* JADX WARN: Code duplicated, block: B:192:0x08ff  */
        /* JADX WARN: Code duplicated, block: B:194:0x0918  */
        /* JADX WARN: Code duplicated, block: B:197:0x0923  */
        /* JADX WARN: Code duplicated, block: B:200:0x092d  */
        /* JADX WARN: Code duplicated, block: B:203:0x094b A[LOOP:3: B:198:0x0927->B:203:0x094b, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:207:0x0956  */
        /* JADX WARN: Code duplicated, block: B:211:0x0975  */
        /* JADX WARN: Code duplicated, block: B:213:0x097b  */
        /* JADX WARN: Code duplicated, block: B:216:0x098b  */
        /* JADX WARN: Code duplicated, block: B:255:0x0a25  */
        /* JADX WARN: Code duplicated, block: B:257:0x0a29 A[Catch: all -> 0x0a6b, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0a6b, blocks: (B:247:0x0a10, B:257:0x0a29), top: B:358:0x0a10 }] */
        /* JADX WARN: Code duplicated, block: B:267:0x0a64  */
        /* JADX WARN: Code duplicated, block: B:272:0x0a79  */
        /* JADX WARN: Code duplicated, block: B:276:0x0aa3  */
        /* JADX WARN: Code duplicated, block: B:278:0x0ab9  */
        /* JADX WARN: Code duplicated, block: B:284:0x0ad8 A[Catch: all -> 0x0c98, TRY_LEAVE, TryCatch #15 {all -> 0x0c98, blocks: (B:282:0x0ad0, B:284:0x0ad8), top: B:380:0x0ad0 }] */
        /* JADX WARN: Code duplicated, block: B:289:0x0bb1 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:28:0x03d4  */
        /* JADX WARN: Code duplicated, block: B:290:0x0bb2  */
        /* JADX WARN: Code duplicated, block: B:312:0x0c3d  */
        /* JADX WARN: Code duplicated, block: B:31:0x03e6  */
        /* JADX WARN: Code duplicated, block: B:322:0x0cfb  */
        /* JADX WARN: Code duplicated, block: B:325:0x0d02  */
        /* JADX WARN: Code duplicated, block: B:326:0x0d07  */
        /* JADX WARN: Code duplicated, block: B:328:0x0d0a  */
        /* JADX WARN: Code duplicated, block: B:32:0x03eb  */
        /* JADX WARN: Code duplicated, block: B:331:0x0d16  */
        /* JADX WARN: Code duplicated, block: B:333:0x0dd7 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:334:0x0dd8  */
        /* JADX WARN: Code duplicated, block: B:336:0x0df4  */
        /* JADX WARN: Code duplicated, block: B:338:0x0ea7 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:339:0x0ea8  */
        /* JADX WARN: Code duplicated, block: B:342:0x0f99 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:343:0x0f9a  */
        /* JADX WARN: Code duplicated, block: B:345:0x0fb4  */
        /* JADX WARN: Code duplicated, block: B:347:0x1087 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:348:0x1088  */
        /* JADX WARN: Code duplicated, block: B:380:0x0ad0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:400:0x0818 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:403:0x08c5 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:406:0x0959 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:407:0x0950 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:408:0x0949 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:411:0x0abe A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:56:0x046b  */
        /* JADX WARN: Code duplicated, block: B:62:0x04a9  */
        /* JADX WARN: Code duplicated, block: B:69:0x04b9  */
        /* JADX WARN: Code duplicated, block: B:71:0x04bc  */
        /* JADX WARN: Code duplicated, block: B:72:0x04ef  */
        /* JADX WARN: Code duplicated, block: B:75:0x04fb A[Catch: all -> 0x0717, TRY_LEAVE, TryCatch #14 {all -> 0x0717, blocks: (B:73:0x04f3, B:75:0x04fb), top: B:378:0x04f3 }] */
        /* JADX WARN: Code duplicated, block: B:86:0x05ae A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:87:0x05af  */
        public final Object invokeSuspend(Object $result) {
            Object obj;
            Document document;
            Element elementSelectFirst;
            String directUrl;
            String strAttr;
            String title;
            Element elementSelectFirst2;
            String strAttr2;
            String poster;
            Element elementSelectFirst3;
            String rawTitleLower;
            Regex episodeRegex;
            TvType tvType;
            TvType tvType2;
            Element elementSelectFirst4;
            String it;
            String videoId;
            Function3 toLoadItem;
            Function1 dedupeByUrl;
            Regex regex;
            Regex sxeRegex;
            String rawTitle;
            Regex seasonRegex;
            MatchResult matchResultFind$default;
            String directUrl2;
            String str;
            boolean z;
            Fibwatch fibwatch;
            CoroutineScope $this$withContext;
            Object obj2;
            Object obj3;
            boolean z2;
            C00012 c00012;
            Object obj4;
            Document document2;
            Regex sxeRegex2;
            Regex seasonRegex2;
            Regex regex2;
            String description;
            Function3 toLoadItem2;
            String poster2;
            String title2;
            String description2;
            Regex episodeRegex2;
            TvType tvType3;
            String title3;
            Function1 dedupeByUrl2;
            String rawTitle2;
            Function1 dedupeByUrl3;
            Links links;
            String description3;
            String directUrl3;
            Object obj5;
            Links links2;
            Regex regex3;
            String poster3;
            String title4;
            TvType tvType4;
            String videoId2;
            Function1 dedupeByUrl4;
            Document document3;
            Regex episodeRegex3;
            Function3 toLoadItem3;
            String directUrl4;
            List groupValues;
            String strAttr3;
            Object obj6;
            Links links3;
            List listEmptyList;
            List currentRaw;
            List listEmptyList2;
            List popupRaw;
            List currentList;
            List $this$filter$iv;
            int $i$f$filter;
            Collection destination$iv$iv;
            List currentRaw2;
            List popupList;
            LoadlinksOut out;
            String status;
            List popupList2;
            List currentList2;
            LoadlinksOut out2;
            Iterable $this$mapNotNull$iv;
            Fibwatch fibwatch2;
            Collection destination$iv$iv2;
            List recommendations;
            TvType tvType5;
            Fibwatch fibwatch3;
            Document document4;
            C00012 c00013;
            List popupRaw2;
            String directUrl5;
            Links links4;
            Regex seasonRegex3;
            List recommendations2;
            Regex regex4;
            List popupList3;
            List currentRaw3;
            String poster4;
            String title5;
            List recommendations3;
            String description4;
            Function3 toLoadItem4;
            String directUrl6;
            Function1 dedupeByUrl5;
            LoadlinksOut out3;
            String rawTitle3;
            String rawTitleLower2;
            TvType tvType6;
            CoroutineScope $this$invokeSuspend_u24lambda_u249;
            Function3 toLoadItem5;
            EpisodesResponse episodesResponse;
            Function3 toLoadItem6;
            String videoId3;
            TvType tvType7;
            String poster5;
            String title6;
            Function1 dedupeByUrl6;
            String description5;
            LoadlinksOut out4;
            List popupList4;
            Object obj7;
            CoroutineScope $this$invokeSuspend_u24lambda_u2410;
            Object objNewMovieLoadResponse;
            SearchResponse searchResult;
            String str2;
            String strSubstringBefore$default;
            String strSubstringBefore$default2;
            String strSubstringBefore$default3;
            String dlUrl;
            String str3;
            boolean z3;
            LoadItem item;
            List $this$none$iv;
            Iterator it2;
            boolean z4;
            LoadItem it3;
            Iterable $this$none$iv2;
            Iterator it4;
            Iterable popup;
            int $i$f$mapNotNull;
            boolean z5;
            LoadItem loadItem;
            Iterable current;
            int $i$f$mapNotNull2;
            boolean z6;
            LoadItem loadItem2;
            Object safe;
            Regex regex5;
            Document document5;
            Function3 toLoadItem7;
            Function1 dedupeByUrl7;
            List popupList5;
            List currentList3;
            String description6;
            String poster6;
            String title7;
            List recommendations4;
            LoadlinksOut out5;
            Object obj8;
            String rawTitle4;
            EpisodesResponse data;
            List<EpisodeItem> listEmptyList3;
            List<EpisodeItem> list;
            String title8;
            List popupList6;
            List currentList4;
            Semaphore semaphore;
            String poster7;
            Object objCoroutineScope;
            List currentRaw4;
            List currentList5;
            String videoId4;
            Regex episodeRegex4;
            Regex episodeRegex5;
            String description7;
            LoadlinksOut out6;
            String title9;
            String description8;
            Document document6;
            List popupList7;
            TvType tvType8;
            Regex seasonRegex4;
            String rawTitleLower3;
            String poster8;
            Regex regex6;
            EpisodesResponse data2;
            Semaphore semaphore2;
            Links links5;
            List popupRaw3;
            List currentRaw5;
            Function3 toLoadItem8;
            Object objNewTvSeriesLoadResponse;
            Object safe2;
            Object objNewTvSeriesLoadResponse2;
            CoroutineScope $this$withContext2 = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = $this$withContext2;
                    this.label = 1;
                    obj = Requests.get$default(MainActivityKt.getApp(), this.$url, (Map) null, (String) null, (Map) null, MapsKt.mapOf(TuplesKt.to("pop_up_18", "yes")), false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4078, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    document = ((NiceResponse) obj).getDocument();
                    elementSelectFirst = document.selectFirst("meta[property=og:title]");
                    directUrl = "Unknown";
                    if (elementSelectFirst != null || (strAttr = elementSelectFirst.attr("content")) == null) {
                        strAttr = "Unknown";
                    }
                    String rawTitle5 = strAttr;
                    title = StringsKt.substringBefore$default(rawTitle5, "S0", (String) null, 2, (Object) null);
                    elementSelectFirst2 = document.selectFirst("meta[property=\"og:image\"]");
                    if (elementSelectFirst2 != null) {
                        strAttr2 = elementSelectFirst2.attr("content");
                    } else {
                        strAttr2 = null;
                    }
                    poster = strAttr2;
                    elementSelectFirst3 = document.selectFirst("meta[property=og:description]");
                    if (elementSelectFirst3 != null && (strAttr3 = elementSelectFirst3.attr("content")) != null) {
                        directUrl = strAttr3;
                    }
                    String lowerCase = rawTitle5.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    rawTitleLower = lowerCase;
                    Regex sxeRegex3 = new Regex("s\\d{1,2}e\\d{1,3}");
                    Regex seasonRegex5 = new Regex("\\bs\\d{1,2}\\b");
                    episodeRegex = new Regex("\\be\\d{1,3}\\b");
                    tvType = (!sxeRegex3.containsMatchIn(rawTitleLower) || seasonRegex5.containsMatchIn(rawTitleLower) || episodeRegex.containsMatchIn(rawTitleLower)) ? TvType.TvSeries : TvType.Movie;
                    tvType2 = tvType;
                    elementSelectFirst4 = document.selectFirst("input#video-id");
                    if (elementSelectFirst4 != null || (it = elementSelectFirst4.attr("value")) == null || StringsKt.isBlank(it)) {
                        it = null;
                    }
                    videoId = it;
                    toLoadItem = new Function3() { // from class: com.Fibwatch.Fibwatch$load$2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj9, Object obj10, Object obj11) {
                            return Fibwatch.C00012.invokeSuspend$lambda$1((String) obj9, (String) obj10, ((Boolean) obj11).booleanValue());
                        }
                    };
                    dedupeByUrl = new Function1() { // from class: com.Fibwatch.Fibwatch$load$2$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj9) {
                            return Fibwatch.C00012.invokeSuspend$lambda$2((List) obj9);
                        }
                    };
                    regex = new Regex("var\\s+VIDEO_URL\\s*=\\s*[\"']([^\"']+)[\"']");
                    sxeRegex = sxeRegex3;
                    rawTitle = rawTitle5;
                    seasonRegex = seasonRegex5;
                    matchResultFind$default = Regex.find$default(regex, document.html(), 0, 2, (Object) null);
                    if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
                        directUrl2 = null;
                    } else {
                        directUrl2 = (String) groupValues.get(1);
                    }
                    str = directUrl2;
                    if (str != null || str.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        fibwatch = this.this$0;
                        try {
                            Result.Companion companion = Result.Companion;
                            if (videoId != null) {
                                Requests app = MainActivityKt.getApp();
                                String str4 = fibwatch.getMainUrl() + "/ajax/resolution_switcher.php?video_id=" + videoId;
                                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("pop_up_18", "yes"));
                                this.L$0 = $this$withContext2;
                                this.L$1 = document;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                                this.L$3 = title;
                                this.L$4 = poster;
                                this.L$5 = directUrl;
                                this.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower);
                                this.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                                this.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex);
                                this.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex);
                                this.L$10 = tvType2;
                                this.L$11 = videoId;
                                try {
                                    this.L$12 = toLoadItem;
                                    try {
                                        this.L$13 = dedupeByUrl;
                                        this.L$14 = SpillingKt.nullOutSpilledVariable(regex);
                                        this.L$15 = SpillingKt.nullOutSpilledVariable(directUrl2);
                                        this.L$16 = SpillingKt.nullOutSpilledVariable($this$withContext2);
                                        $this$withContext = $this$withContext2;
                                        try {
                                            this.label = 2;
                                            description3 = directUrl;
                                            directUrl3 = directUrl2;
                                            z2 = false;
                                            obj4 = coroutine_suspended;
                                            obj2 = "yes";
                                            obj3 = "pop_up_18";
                                            try {
                                                obj5 = Requests.get$default(app, str4, (Map) null, (String) null, (Map) null, mapMapOf, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4078, (Object) null);
                                                c00012 = this;
                                                if (obj5 == obj4) {
                                                    return obj4;
                                                }
                                                document2 = document;
                                                sxeRegex2 = sxeRegex;
                                                seasonRegex2 = seasonRegex;
                                                regex2 = regex;
                                                description = description3;
                                                toLoadItem2 = toLoadItem;
                                                poster2 = poster;
                                                title2 = title;
                                                description2 = directUrl3;
                                                episodeRegex2 = episodeRegex;
                                                tvType3 = tvType2;
                                                title3 = videoId;
                                                dedupeByUrl2 = dedupeByUrl;
                                                rawTitle2 = rawTitle;
                                                try {
                                                    NiceResponse this_$iv = (NiceResponse) obj5;
                                                    try {
                                                        ResponseParser parser = this_$iv.getParser();
                                                        Intrinsics.checkNotNull(parser);
                                                        try {
                                                            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Links.class));
                                                        } catch (Exception e) {
                                                            e$iv = e;
                                                            e$iv.printStackTrace();
                                                            safe = null;
                                                        }
                                                    } catch (Exception e2) {
                                                        e$iv = e2;
                                                    }
                                                    dedupeByUrl3 = dedupeByUrl2;
                                                    links = (Links) safe;
                                                    try {
                                                        obj6 = Result.constructor-impl(links);
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        dedupeByUrl2 = dedupeByUrl3;
                                                        Result.Companion companion2 = Result.Companion;
                                                        dedupeByUrl3 = dedupeByUrl2;
                                                        obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                }
                                                if (Result.isFailure-impl(obj6)) {
                                                    obj6 = null;
                                                }
                                                links2 = (Links) obj6;
                                                directUrl4 = description2;
                                                regex3 = regex2;
                                                toLoadItem3 = toLoadItem2;
                                                videoId2 = title3;
                                                tvType4 = tvType3;
                                                directUrl = description;
                                                title4 = title2;
                                                rawTitle = rawTitle2;
                                                document3 = document2;
                                                dedupeByUrl4 = dedupeByUrl3;
                                                sxeRegex = sxeRegex2;
                                                episodeRegex3 = episodeRegex2;
                                                seasonRegex = seasonRegex2;
                                                poster3 = poster2;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                c00012 = this;
                                                document2 = document;
                                                sxeRegex2 = sxeRegex;
                                                seasonRegex2 = seasonRegex;
                                                regex2 = regex;
                                                description = description3;
                                                toLoadItem2 = toLoadItem;
                                                poster2 = poster;
                                                title2 = title;
                                                description2 = directUrl3;
                                                episodeRegex2 = episodeRegex;
                                                tvType3 = tvType2;
                                                title3 = videoId;
                                                dedupeByUrl2 = dedupeByUrl;
                                                rawTitle2 = rawTitle;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            c00012 = this;
                                            obj2 = "yes";
                                            obj3 = "pop_up_18";
                                            String str5 = directUrl2;
                                            obj4 = coroutine_suspended;
                                            z2 = false;
                                            document2 = document;
                                            sxeRegex2 = sxeRegex;
                                            seasonRegex2 = seasonRegex;
                                            regex2 = regex;
                                            description = directUrl;
                                            toLoadItem2 = toLoadItem;
                                            poster2 = poster;
                                            title2 = title;
                                            description2 = str5;
                                            episodeRegex2 = episodeRegex;
                                            tvType3 = tvType2;
                                            title3 = videoId;
                                            dedupeByUrl2 = dedupeByUrl;
                                            rawTitle2 = rawTitle;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        $this$withContext = $this$withContext2;
                                        obj2 = "yes";
                                        obj3 = "pop_up_18";
                                        String str6 = directUrl2;
                                        z2 = false;
                                        c00012 = this;
                                        obj4 = coroutine_suspended;
                                        document2 = document;
                                        sxeRegex2 = sxeRegex;
                                        seasonRegex2 = seasonRegex;
                                        regex2 = regex;
                                        description = directUrl;
                                        toLoadItem2 = toLoadItem;
                                        poster2 = poster;
                                        title2 = title;
                                        description2 = str6;
                                        episodeRegex2 = episodeRegex;
                                        tvType3 = tvType2;
                                        title3 = videoId;
                                        dedupeByUrl2 = dedupeByUrl;
                                        rawTitle2 = rawTitle;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    $this$withContext = $this$withContext2;
                                    obj2 = "yes";
                                    obj3 = "pop_up_18";
                                    String str7 = directUrl2;
                                    z2 = false;
                                    c00012 = this;
                                    obj4 = coroutine_suspended;
                                    document2 = document;
                                    sxeRegex2 = sxeRegex;
                                    seasonRegex2 = seasonRegex;
                                    regex2 = regex;
                                    description = directUrl;
                                    toLoadItem2 = toLoadItem;
                                    poster2 = poster;
                                    title2 = title;
                                    description2 = str7;
                                    episodeRegex2 = episodeRegex;
                                    tvType3 = tvType2;
                                    title3 = videoId;
                                    dedupeByUrl2 = dedupeByUrl;
                                    rawTitle2 = rawTitle;
                                }
                            } else {
                                $this$withContext = $this$withContext2;
                                obj2 = "yes";
                                obj3 = "pop_up_18";
                                String description9 = directUrl;
                                String directUrl7 = directUrl2;
                                dedupeByUrl3 = dedupeByUrl;
                                z2 = false;
                                c00012 = this;
                                obj4 = coroutine_suspended;
                                document2 = document;
                                sxeRegex2 = sxeRegex;
                                seasonRegex2 = seasonRegex;
                                regex2 = regex;
                                description = description9;
                                toLoadItem2 = toLoadItem;
                                poster2 = poster;
                                title2 = title;
                                description2 = directUrl7;
                                episodeRegex2 = episodeRegex;
                                tvType3 = tvType2;
                                title3 = videoId;
                                links = null;
                                rawTitle2 = rawTitle;
                                obj6 = Result.constructor-impl(links);
                                if (Result.isFailure-impl(obj6)) {
                                    obj6 = null;
                                }
                                links2 = (Links) obj6;
                                directUrl4 = description2;
                                regex3 = regex2;
                                toLoadItem3 = toLoadItem2;
                                videoId2 = title3;
                                tvType4 = tvType3;
                                directUrl = description;
                                title4 = title2;
                                rawTitle = rawTitle2;
                                document3 = document2;
                                dedupeByUrl4 = dedupeByUrl3;
                                sxeRegex = sxeRegex2;
                                episodeRegex3 = episodeRegex2;
                                seasonRegex = seasonRegex2;
                                poster3 = poster2;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            $this$withContext = $this$withContext2;
                            obj2 = "yes";
                            obj3 = "pop_up_18";
                            String str8 = directUrl2;
                            z2 = false;
                            c00012 = this;
                            obj4 = coroutine_suspended;
                            document2 = document;
                            sxeRegex2 = sxeRegex;
                            seasonRegex2 = seasonRegex;
                            regex2 = regex;
                            description = directUrl;
                            toLoadItem2 = toLoadItem;
                            poster2 = poster;
                            title2 = title;
                            description2 = str8;
                            episodeRegex2 = episodeRegex;
                            tvType3 = tvType2;
                            title3 = videoId;
                            dedupeByUrl2 = dedupeByUrl;
                            rawTitle2 = rawTitle;
                        }
                        Result.Companion companion3 = Result.Companion;
                        dedupeByUrl3 = dedupeByUrl2;
                        obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                        if (Result.isFailure-impl(obj6)) {
                            obj6 = null;
                        }
                        links2 = (Links) obj6;
                        directUrl4 = description2;
                        regex3 = regex2;
                        toLoadItem3 = toLoadItem2;
                        videoId2 = title3;
                        tvType4 = tvType3;
                        directUrl = description;
                        title4 = title2;
                        rawTitle = rawTitle2;
                        document3 = document2;
                        dedupeByUrl4 = dedupeByUrl3;
                        sxeRegex = sxeRegex2;
                        episodeRegex3 = episodeRegex2;
                        seasonRegex = seasonRegex2;
                        poster3 = poster2;
                        break;
                    } else {
                        regex3 = regex;
                        links2 = new Links("200", CollectionsKt.listOf(new Current("Auto", directUrl2, false)), CollectionsKt.emptyList());
                        $this$withContext = $this$withContext2;
                        obj2 = "yes";
                        obj3 = "pop_up_18";
                        poster3 = poster;
                        title4 = title;
                        tvType4 = tvType2;
                        videoId2 = videoId;
                        dedupeByUrl4 = dedupeByUrl;
                        z2 = false;
                        c00012 = this;
                        document3 = document;
                        episodeRegex3 = episodeRegex;
                        toLoadItem3 = toLoadItem;
                        obj4 = coroutine_suspended;
                        directUrl4 = directUrl2;
                    }
                    links3 = links2;
                    if (links3 != null || (current = links3.getCurrent()) == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    } else {
                        Iterable $this$mapNotNull$iv2 = current;
                        int $i$f$mapNotNull3 = 0;
                        Collection destination$iv$iv3 = new ArrayList();
                        Iterable $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv2;
                        for (Object element$iv$iv$iv : $this$mapNotNullTo$iv$iv) {
                            Current c = (Current) element$iv$iv$iv;
                            String url = c.getUrl();
                            String string = url != null ? StringsKt.trim(url).toString() : null;
                            String it5 = string;
                            if (it5 != null) {
                                $i$f$mapNotNull2 = $i$f$mapNotNull3;
                                z6 = it5.length() > 0;
                                if (!z6) {
                                    string = null;
                                }
                                if (string != null) {
                                    String it6 = string;
                                    loadItem2 = (LoadItem) toLoadItem3.invoke(c.getRes(), it6, Boxing.boxBoolean(c.getSelected()));
                                } else {
                                    loadItem2 = null;
                                }
                                if (loadItem2 != null) {
                                    destination$iv$iv3.add(loadItem2);
                                }
                                $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                                $this$mapNotNull$iv2 = $this$mapNotNull$iv2;
                                $i$f$mapNotNull3 = $i$f$mapNotNull2;
                            } else {
                                $this$mapNotNull$iv2 = $this$mapNotNull$iv2;
                                $i$f$mapNotNull2 = $i$f$mapNotNull3;
                            }
                            if (!z6) {
                                string = null;
                            }
                            if (string != null) {
                                String it7 = string;
                                loadItem2 = (LoadItem) toLoadItem3.invoke(c.getRes(), it7, Boxing.boxBoolean(c.getSelected()));
                            } else {
                                loadItem2 = null;
                            }
                            if (loadItem2 != null) {
                                destination$iv$iv3.add(loadItem2);
                            }
                            $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                            $this$mapNotNull$iv2 = $this$mapNotNull$iv2;
                            $i$f$mapNotNull3 = $i$f$mapNotNull2;
                        }
                        listEmptyList = (List) destination$iv$iv3;
                    }
                    currentRaw = listEmptyList;
                    if (links3 != null || (popup = links3.getPopup()) == null) {
                        listEmptyList2 = CollectionsKt.emptyList();
                    } else {
                        Iterable $this$mapNotNull$iv3 = popup;
                        int $i$f$mapNotNull4 = 0;
                        Collection destination$iv$iv4 = new ArrayList();
                        Iterable $this$mapNotNullTo$iv$iv2 = $this$mapNotNull$iv3;
                        for (Object element$iv$iv$iv2 : $this$mapNotNullTo$iv$iv2) {
                            Popup p = (Popup) element$iv$iv$iv2;
                            String url2 = p.getUrl();
                            String string2 = url2 != null ? StringsKt.trim(url2).toString() : null;
                            String it8 = string2;
                            if (it8 != null) {
                                $i$f$mapNotNull = $i$f$mapNotNull4;
                                z5 = it8.length() > 0;
                                if (!z5) {
                                    string2 = null;
                                }
                                if (string2 != null) {
                                    String it9 = string2;
                                    loadItem = (LoadItem) toLoadItem3.invoke(p.getRes(), it9, Boxing.boxBoolean(p.getSelected()));
                                } else {
                                    loadItem = null;
                                }
                                if (loadItem != null) {
                                    destination$iv$iv4.add(loadItem);
                                }
                                $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv2;
                                $this$mapNotNull$iv3 = $this$mapNotNull$iv3;
                                $i$f$mapNotNull4 = $i$f$mapNotNull;
                            } else {
                                $this$mapNotNull$iv3 = $this$mapNotNull$iv3;
                                $i$f$mapNotNull = $i$f$mapNotNull4;
                            }
                            if (!z5) {
                                string2 = null;
                            }
                            if (string2 != null) {
                                String it10 = string2;
                                loadItem = (LoadItem) toLoadItem3.invoke(p.getRes(), it10, Boxing.boxBoolean(p.getSelected()));
                            } else {
                                loadItem = null;
                            }
                            if (loadItem != null) {
                                destination$iv$iv4.add(loadItem);
                            }
                            $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv2;
                            $this$mapNotNull$iv3 = $this$mapNotNull$iv3;
                            $i$f$mapNotNull4 = $i$f$mapNotNull;
                        }
                        listEmptyList2 = (List) destination$iv$iv4;
                    }
                    popupRaw = listEmptyList2;
                    currentList = (List) dedupeByUrl4.invoke(currentRaw);
                    $this$filter$iv = popupRaw;
                    $i$f$filter = 0;
                    destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        Iterable $this$filter$iv2 = $this$filter$iv;
                        item = (LoadItem) element$iv$iv;
                        List currentRaw6 = currentRaw;
                        $this$none$iv = currentList;
                        int $i$f$filter2 = $i$f$filter;
                        if (($this$none$iv instanceof Collection) || !$this$none$iv.isEmpty()) {
                            it2 = $this$none$iv.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    Object element$iv = it2.next();
                                    it3 = (LoadItem) element$iv;
                                    $this$none$iv2 = $this$none$iv;
                                    it4 = it2;
                                    if (Intrinsics.areEqual(it3.getUrl(), item.getUrl())) {
                                        z4 = false;
                                    } else {
                                        $this$none$iv = $this$none$iv2;
                                        it2 = it4;
                                    }
                                } else {
                                    z4 = true;
                                }
                            }
                        } else {
                            z4 = true;
                        }
                        if (z4) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        $this$filter$iv = $this$filter$iv2;
                        currentRaw = currentRaw6;
                        $i$f$filter = $i$f$filter2;
                    }
                    currentRaw2 = currentRaw;
                    popupList = (List) dedupeByUrl4.invoke((List) destination$iv$iv);
                    if (links3 != null || (status = links3.getStatus()) == null) {
                        status = "error";
                    }
                    out = new LoadlinksOut(status, currentList, popupList);
                    if (out.getCurrent().isEmpty() || !out.getPopup().isEmpty()) {
                        popupList2 = popupList;
                        currentList2 = currentList;
                        out2 = out;
                    } else {
                        try {
                            Element elementSelectFirst5 = document3.selectFirst("a.hidden-button.buttonDownloadnew, a#fwDownloadBtn, a[href*=url=]");
                            try {
                                if (elementSelectFirst5 != null) {
                                    try {
                                        String strAttr4 = elementSelectFirst5.attr("href");
                                        if (strAttr4 != null) {
                                            popupList2 = popupList;
                                            str2 = null;
                                            try {
                                                String strSubstringAfter$default = StringsKt.substringAfter$default(strAttr4, "url=", (String) null, 2, (Object) null);
                                                if (strSubstringAfter$default != null && (strSubstringBefore$default = StringsKt.substringBefore$default(strSubstringAfter$default, "',", (String) null, 2, (Object) null)) != null && (strSubstringBefore$default2 = StringsKt.substringBefore$default(strSubstringBefore$default, "\"", (String) null, 2, (Object) null)) != null && (strSubstringBefore$default3 = StringsKt.substringBefore$default(strSubstringBefore$default2, "&", (String) null, 2, (Object) null)) != null && (dlUrl = StringsKt.trim(strSubstringBefore$default3).toString()) != null) {
                                                    if (!(dlUrl.length() > 0)) {
                                                        dlUrl = null;
                                                    }
                                                }
                                                str3 = dlUrl;
                                                if (str3 != null || StringsKt.isBlank(str3)) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                if (z3) {
                                                    currentList2 = currentList;
                                                    out2 = out;
                                                } else {
                                                    String normalized = StringsKt.trim(dlUrl).toString();
                                                    LoadItem dlItem = (LoadItem) toLoadItem3.invoke(str2, normalized, Boxing.boxBoolean(z2));
                                                    List current2 = (List) dedupeByUrl4.invoke(CollectionsKt.listOf(dlItem));
                                                    currentList2 = currentList;
                                                    try {
                                                        out2 = out;
                                                        try {
                                                            out2 = new LoadlinksOut(out.getStatus(), current2, CollectionsKt.emptyList());
                                                        } catch (Throwable th8) {
                                                        }
                                                    } catch (Throwable th9) {
                                                        out2 = out;
                                                    }
                                                }
                                            } catch (Throwable th10) {
                                                currentList2 = currentList;
                                                out2 = out;
                                            }
                                        } else {
                                            popupList2 = popupList;
                                            str2 = null;
                                        }
                                    } catch (Throwable th11) {
                                        popupList2 = popupList;
                                        currentList2 = currentList;
                                        out2 = out;
                                    }
                                } else {
                                    popupList2 = popupList;
                                    str2 = null;
                                }
                                str3 = dlUrl;
                                if (str3 != null) {
                                    z3 = true;
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    String normalized2 = StringsKt.trim(dlUrl).toString();
                                    LoadItem dlItem2 = (LoadItem) toLoadItem3.invoke(str2, normalized2, Boxing.boxBoolean(z2));
                                    List current3 = (List) dedupeByUrl4.invoke(CollectionsKt.listOf(dlItem2));
                                    currentList2 = currentList;
                                    out2 = out;
                                    out2 = new LoadlinksOut(out.getStatus(), current3, CollectionsKt.emptyList());
                                } else {
                                    currentList2 = currentList;
                                    out2 = out;
                                }
                            } catch (Throwable th12) {
                                currentList2 = currentList;
                                out2 = out;
                            }
                            dlUrl = str2;
                        } catch (Throwable th13) {
                            popupList2 = popupList;
                            currentList2 = currentList;
                            out2 = out;
                        }
                    }
                    $this$mapNotNull$iv = document3.select("div.col-md-4.no-padding-left.mobile div.videos-list.pt_mn_wtch_rlts_prnt .video-wrapper");
                    fibwatch2 = c00012.this$0;
                    destination$iv$iv2 = new ArrayList();
                    for (Object element$iv$iv$iv3 : $this$mapNotNull$iv) {
                        Iterable $this$mapNotNull$iv4 = $this$mapNotNull$iv;
                        Element it11 = (Element) element$iv$iv$iv3;
                        searchResult = fibwatch2.toSearchResult(it11);
                        if (searchResult != null) {
                            destination$iv$iv2.add(searchResult);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv4;
                    }
                    recommendations = (List) destination$iv$iv2;
                    tvType5 = TvType.TvSeries;
                    fibwatch3 = c00012.this$0;
                    if (tvType4 != tvType5) {
                        Function1 dedupeByUrl8 = dedupeByUrl4;
                        String description10 = directUrl;
                        String title10 = title4;
                        Document document7 = document3;
                        LoadlinksOut out7 = out2;
                        C00012 c00014 = c00012;
                        c00014.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                        c00014.L$1 = SpillingKt.nullOutSpilledVariable(document7);
                        c00014.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                        c00014.L$3 = SpillingKt.nullOutSpilledVariable(title10);
                        c00014.L$4 = SpillingKt.nullOutSpilledVariable(poster3);
                        c00014.L$5 = SpillingKt.nullOutSpilledVariable(description10);
                        c00014.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower);
                        c00014.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                        c00014.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex);
                        c00014.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                        c00014.L$10 = SpillingKt.nullOutSpilledVariable(tvType4);
                        c00014.L$11 = SpillingKt.nullOutSpilledVariable(videoId2);
                        c00014.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem3);
                        c00014.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl8);
                        c00014.L$14 = SpillingKt.nullOutSpilledVariable(regex3);
                        c00014.L$15 = SpillingKt.nullOutSpilledVariable(directUrl4);
                        c00014.L$16 = SpillingKt.nullOutSpilledVariable(links3);
                        c00014.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw2);
                        c00014.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw);
                        c00014.L$19 = SpillingKt.nullOutSpilledVariable(currentList2);
                        c00014.L$20 = SpillingKt.nullOutSpilledVariable(popupList2);
                        c00014.L$21 = SpillingKt.nullOutSpilledVariable(out7);
                        c00014.L$22 = SpillingKt.nullOutSpilledVariable(recommendations);
                        c00014.label = 7;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(fibwatch3, title10, c00014.$url, TvType.Movie, AppUtils.INSTANCE.toJson(out7), new AnonymousClass4(poster3, c00014.this$0, description10, document7, recommendations, null), (Continuation) c00014);
                        if (objNewMovieLoadResponse == obj4) {
                            return obj4;
                        }
                        return objNewMovieLoadResponse;
                    }
                    try {
                        Result.Companion companion4 = Result.Companion;
                        $this$invokeSuspend_u24lambda_u249 = $this$withContext;
                        if (videoId2 == null) {
                            Function1 dedupeByUrl9 = dedupeByUrl4;
                            toLoadItem5 = toLoadItem3;
                            String videoId5 = videoId2;
                            TvType tvType9 = tvType4;
                            String description11 = directUrl;
                            String poster9 = poster3;
                            String title11 = title4;
                            document4 = document3;
                            LoadlinksOut out8 = out2;
                            c00013 = c00012;
                            popupRaw2 = popupRaw;
                            directUrl5 = directUrl4;
                            links4 = links3;
                            seasonRegex3 = seasonRegex;
                            recommendations2 = currentList2;
                            regex4 = regex3;
                            popupList3 = popupList2;
                            currentRaw3 = currentRaw2;
                            poster4 = poster9;
                            title5 = title11;
                            recommendations3 = recommendations;
                            description4 = description11;
                            directUrl6 = videoId5;
                            dedupeByUrl5 = dedupeByUrl9;
                            out3 = out8;
                            episodesResponse = null;
                            rawTitle3 = rawTitle;
                            rawTitleLower2 = rawTitleLower;
                            tvType6 = tvType9;
                            Object obj9 = Result.constructor-impl(episodesResponse);
                            regex5 = regex4;
                            document5 = document4;
                            toLoadItem7 = toLoadItem5;
                            recommendations4 = recommendations3;
                            out5 = out3;
                            dedupeByUrl7 = dedupeByUrl5;
                            popupList5 = popupList3;
                            currentList3 = recommendations2;
                            description6 = description4;
                            poster6 = poster4;
                            title7 = title5;
                            obj8 = obj9;
                            rawTitle4 = rawTitle3;
                            if (Result.isFailure-impl(obj8)) {
                                obj8 = null;
                            }
                            data = (EpisodesResponse) obj8;
                            if (data != null) {
                                listEmptyList3 = data.getEpisodes();
                            } else {
                                listEmptyList3 = null;
                            }
                            if (listEmptyList3 == null) {
                                listEmptyList3 = CollectionsKt.emptyList();
                            }
                            list = listEmptyList3;
                            if (list.isEmpty()) {
                                c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                                c00013.L$1 = SpillingKt.nullOutSpilledVariable(document5);
                                c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                                c00013.L$3 = SpillingKt.nullOutSpilledVariable(title7);
                                c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster6);
                                c00013.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                                c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                                c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                                c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                                c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                                c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                                c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                                c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                                c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                                c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                                c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                                c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                                c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                                c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                                c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList3);
                                c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList5);
                                c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                                c00013.L$22 = SpillingKt.nullOutSpilledVariable(recommendations4);
                                c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                                c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                                c00013.label = 4;
                                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title7, c00013.$url, TvType.TvSeries, CollectionsKt.emptyList(), new AnonymousClass2(poster6, description6, document5, recommendations4, null), (Continuation) c00013);
                                if (objNewTvSeriesLoadResponse == obj4) {
                                    return obj4;
                                }
                                return objNewTvSeriesLoadResponse;
                            }
                            title8 = title7;
                            popupList6 = popupList5;
                            currentList4 = currentList3;
                            semaphore = SemaphoreKt.Semaphore$default(6, 0, 2, (Object) null);
                            Fibwatch$load$2$episodes$1 fibwatch$load$2$episodes$1 = new Fibwatch$load$2$episodes$1(list, semaphore, dedupeByUrl7, toLoadItem7, c00013.this$0, poster6, null);
                            poster7 = poster6;
                            c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                            c00013.L$1 = document5;
                            c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                            c00013.L$3 = title8;
                            c00013.L$4 = poster7;
                            c00013.L$5 = description6;
                            c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                            c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                            c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                            c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                            c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                            c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                            c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                            c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                            c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                            c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                            c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                            c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList4);
                            c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList6);
                            c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                            c00013.L$22 = recommendations4;
                            c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                            c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                            c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore);
                            c00013.label = 5;
                            objCoroutineScope = CoroutineScopeKt.coroutineScope(fibwatch$load$2$episodes$1, (Continuation) c00013);
                            if (objCoroutineScope == obj4) {
                                return obj4;
                            }
                            String str9 = directUrl5;
                            currentRaw4 = currentRaw3;
                            currentList5 = currentList4;
                            videoId4 = directUrl6;
                            episodeRegex4 = episodeRegex3;
                            episodeRegex5 = sxeRegex;
                            description7 = str9;
                            out6 = out5;
                            title9 = title8;
                            description8 = description6;
                            document6 = document5;
                            popupList7 = recommendations4;
                            tvType8 = tvType6;
                            seasonRegex4 = seasonRegex3;
                            rawTitleLower3 = rawTitleLower2;
                            poster8 = poster7;
                            regex6 = regex5;
                            data2 = data;
                            semaphore2 = semaphore;
                            links5 = links4;
                            popupRaw3 = popupRaw2;
                            currentRaw5 = popupList6;
                            toLoadItem8 = toLoadItem7;
                            List episodes = (List) objCoroutineScope;
                            c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                            c00013.L$1 = SpillingKt.nullOutSpilledVariable(document6);
                            c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                            c00013.L$3 = SpillingKt.nullOutSpilledVariable(title9);
                            c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                            c00013.L$5 = SpillingKt.nullOutSpilledVariable(description8);
                            c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower3);
                            c00013.L$7 = SpillingKt.nullOutSpilledVariable(episodeRegex5);
                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex4);
                            c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex4);
                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType8);
                            c00013.L$11 = SpillingKt.nullOutSpilledVariable(videoId4);
                            c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem8);
                            c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                            c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex6);
                            c00013.L$15 = SpillingKt.nullOutSpilledVariable(description7);
                            c00013.L$16 = SpillingKt.nullOutSpilledVariable(links5);
                            c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw4);
                            c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw3);
                            c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList5);
                            c00013.L$20 = SpillingKt.nullOutSpilledVariable(currentRaw5);
                            c00013.L$21 = SpillingKt.nullOutSpilledVariable(out6);
                            c00013.L$22 = SpillingKt.nullOutSpilledVariable(popupList7);
                            c00013.L$23 = SpillingKt.nullOutSpilledVariable(data2);
                            c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                            c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore2);
                            c00013.L$26 = SpillingKt.nullOutSpilledVariable(episodes);
                            c00013.label = 6;
                            objNewTvSeriesLoadResponse2 = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title9, c00013.$url, TvType.TvSeries, episodes, new AnonymousClass3(poster8, c00013.this$0, description8, document6, popupList7, null), (Continuation) c00013);
                            if (objNewTvSeriesLoadResponse2 == obj4) {
                                return obj4;
                            }
                            return objNewTvSeriesLoadResponse2;
                        }
                        Requests app2 = MainActivityKt.getApp();
                        String str10 = fibwatch3.getMainUrl() + "/ajax/episodes.php?video_id=" + videoId2;
                        Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to(obj3, obj2));
                        c00012.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                        c00012.L$1 = document3;
                        c00012.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                        c00012.L$3 = title4;
                        c00012.L$4 = poster3;
                        c00012.L$5 = directUrl;
                        c00012.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower);
                        c00012.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                        c00012.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex);
                        c00012.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                        c00012.L$10 = SpillingKt.nullOutSpilledVariable(tvType4);
                        c00012.L$11 = SpillingKt.nullOutSpilledVariable(videoId2);
                        c00012.L$12 = toLoadItem3;
                        c00012.L$13 = dedupeByUrl4;
                        c00012.L$14 = SpillingKt.nullOutSpilledVariable(regex3);
                        c00012.L$15 = SpillingKt.nullOutSpilledVariable(directUrl4);
                        c00012.L$16 = SpillingKt.nullOutSpilledVariable(links3);
                        c00012.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw2);
                        c00012.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw);
                        c00012.L$19 = SpillingKt.nullOutSpilledVariable(currentList2);
                        c00012.L$20 = SpillingKt.nullOutSpilledVariable(popupList2);
                        c00012.L$21 = SpillingKt.nullOutSpilledVariable(out2);
                        c00012.L$22 = recommendations;
                        c00012.L$23 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u249);
                        c00012.label = 3;
                        toLoadItem6 = toLoadItem3;
                        videoId3 = videoId2;
                        tvType7 = tvType4;
                        poster5 = poster3;
                        title6 = title4;
                        document4 = document3;
                        dedupeByUrl6 = dedupeByUrl4;
                        description5 = directUrl;
                        out4 = out2;
                        popupList4 = popupList2;
                        try {
                            obj7 = Requests.get$default(app2, str10, (Map) null, (String) null, (Map) null, mapMapOf2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4078, (Object) null);
                            c00013 = this;
                            if (obj7 == obj4) {
                                return obj4;
                            }
                            $this$invokeSuspend_u24lambda_u2410 = $this$invokeSuspend_u24lambda_u249;
                            popupRaw2 = popupRaw;
                            directUrl5 = directUrl4;
                            links4 = links3;
                            seasonRegex3 = seasonRegex;
                            recommendations2 = currentList2;
                            regex4 = regex3;
                            popupList3 = popupList4;
                            currentRaw3 = currentRaw2;
                            poster4 = poster5;
                            title5 = title6;
                            recommendations3 = recommendations;
                            description4 = description5;
                            toLoadItem4 = toLoadItem6;
                            directUrl6 = videoId3;
                            dedupeByUrl5 = dedupeByUrl6;
                            out3 = out4;
                            rawTitle3 = rawTitle;
                            rawTitleLower2 = rawTitleLower;
                            tvType6 = tvType7;
                            try {
                                NiceResponse this_$iv2 = (NiceResponse) obj7;
                                try {
                                    ResponseParser parser2 = this_$iv2.getParser();
                                    Intrinsics.checkNotNull(parser2);
                                    try {
                                        try {
                                            safe2 = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(EpisodesResponse.class));
                                        } catch (Exception e3) {
                                            e$iv = e3;
                                            e$iv.printStackTrace();
                                            safe2 = null;
                                        }
                                    } catch (Exception e4) {
                                        e$iv = e4;
                                    }
                                } catch (Exception e5) {
                                    e$iv = e5;
                                }
                                toLoadItem5 = toLoadItem4;
                                episodesResponse = (EpisodesResponse) safe2;
                                try {
                                    Object obj10 = Result.constructor-impl(episodesResponse);
                                    regex5 = regex4;
                                    document5 = document4;
                                    toLoadItem7 = toLoadItem5;
                                    recommendations4 = recommendations3;
                                    out5 = out3;
                                    dedupeByUrl7 = dedupeByUrl5;
                                    popupList5 = popupList3;
                                    currentList3 = recommendations2;
                                    description6 = description4;
                                    poster6 = poster4;
                                    title7 = title5;
                                    obj8 = obj10;
                                    rawTitle4 = rawTitle3;
                                } catch (Throwable th14) {
                                    th = th14;
                                    toLoadItem4 = toLoadItem5;
                                    Result.Companion companion5 = Result.Companion;
                                    regex5 = regex4;
                                    document5 = document4;
                                    toLoadItem7 = toLoadItem4;
                                    dedupeByUrl7 = dedupeByUrl5;
                                    popupList5 = popupList3;
                                    currentList3 = recommendations2;
                                    description6 = description4;
                                    poster6 = poster4;
                                    title7 = title5;
                                    recommendations4 = recommendations3;
                                    out5 = out3;
                                    obj8 = Result.constructor-impl(ResultKt.createFailure(th));
                                    rawTitle4 = rawTitle3;
                                }
                                break;
                            } catch (Throwable th15) {
                                th = th15;
                            }
                            if (Result.isFailure-impl(obj8)) {
                                obj8 = null;
                            }
                            data = (EpisodesResponse) obj8;
                            if (data != null) {
                                listEmptyList3 = data.getEpisodes();
                            } else {
                                listEmptyList3 = null;
                            }
                            if (listEmptyList3 == null) {
                                listEmptyList3 = CollectionsKt.emptyList();
                            }
                            list = listEmptyList3;
                            if (list.isEmpty()) {
                                c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                                c00013.L$1 = SpillingKt.nullOutSpilledVariable(document5);
                                c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                                c00013.L$3 = SpillingKt.nullOutSpilledVariable(title7);
                                c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster6);
                                c00013.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                                c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                                c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                                c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                                c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                                c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                                c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                                c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                                c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                                c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                                c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                                c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                                c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                                c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                                c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList3);
                                c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList5);
                                c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                                c00013.L$22 = SpillingKt.nullOutSpilledVariable(recommendations4);
                                c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                                c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                                c00013.label = 4;
                                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title7, c00013.$url, TvType.TvSeries, CollectionsKt.emptyList(), new AnonymousClass2(poster6, description6, document5, recommendations4, null), (Continuation) c00013);
                                if (objNewTvSeriesLoadResponse == obj4) {
                                    return obj4;
                                }
                                return objNewTvSeriesLoadResponse;
                            }
                            title8 = title7;
                            popupList6 = popupList5;
                            currentList4 = currentList3;
                            semaphore = SemaphoreKt.Semaphore$default(6, 0, 2, (Object) null);
                            Fibwatch$load$2$episodes$1 fibwatch$load$2$episodes$2 = new Fibwatch$load$2$episodes$1(list, semaphore, dedupeByUrl7, toLoadItem7, c00013.this$0, poster6, null);
                            poster7 = poster6;
                            c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                            c00013.L$1 = document5;
                            c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                            c00013.L$3 = title8;
                            c00013.L$4 = poster7;
                            c00013.L$5 = description6;
                            c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                            c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                            c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                            c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                            c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                            c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                            c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                            c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                            c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                            c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                            c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                            c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList4);
                            c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList6);
                            c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                            c00013.L$22 = recommendations4;
                            c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                            c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                            c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore);
                            c00013.label = 5;
                            objCoroutineScope = CoroutineScopeKt.coroutineScope(fibwatch$load$2$episodes$2, (Continuation) c00013);
                            if (objCoroutineScope == obj4) {
                                return obj4;
                            }
                            String str11 = directUrl5;
                            currentRaw4 = currentRaw3;
                            currentList5 = currentList4;
                            videoId4 = directUrl6;
                            episodeRegex4 = episodeRegex3;
                            episodeRegex5 = sxeRegex;
                            description7 = str11;
                            out6 = out5;
                            title9 = title8;
                            description8 = description6;
                            document6 = document5;
                            popupList7 = recommendations4;
                            tvType8 = tvType6;
                            seasonRegex4 = seasonRegex3;
                            rawTitleLower3 = rawTitleLower2;
                            poster8 = poster7;
                            regex6 = regex5;
                            data2 = data;
                            semaphore2 = semaphore;
                            links5 = links4;
                            popupRaw3 = popupRaw2;
                            currentRaw5 = popupList6;
                            toLoadItem8 = toLoadItem7;
                            List episodes2 = (List) objCoroutineScope;
                            c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                            c00013.L$1 = SpillingKt.nullOutSpilledVariable(document6);
                            c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                            c00013.L$3 = SpillingKt.nullOutSpilledVariable(title9);
                            c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                            c00013.L$5 = SpillingKt.nullOutSpilledVariable(description8);
                            c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower3);
                            c00013.L$7 = SpillingKt.nullOutSpilledVariable(episodeRegex5);
                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex4);
                            c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex4);
                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType8);
                            c00013.L$11 = SpillingKt.nullOutSpilledVariable(videoId4);
                            c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem8);
                            c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                            c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex6);
                            c00013.L$15 = SpillingKt.nullOutSpilledVariable(description7);
                            c00013.L$16 = SpillingKt.nullOutSpilledVariable(links5);
                            c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw4);
                            c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw3);
                            c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList5);
                            c00013.L$20 = SpillingKt.nullOutSpilledVariable(currentRaw5);
                            c00013.L$21 = SpillingKt.nullOutSpilledVariable(out6);
                            c00013.L$22 = SpillingKt.nullOutSpilledVariable(popupList7);
                            c00013.L$23 = SpillingKt.nullOutSpilledVariable(data2);
                            c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                            c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore2);
                            c00013.L$26 = SpillingKt.nullOutSpilledVariable(episodes2);
                            c00013.label = 6;
                            objNewTvSeriesLoadResponse2 = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title9, c00013.$url, TvType.TvSeries, episodes2, new AnonymousClass3(poster8, c00013.this$0, description8, document6, popupList7, null), (Continuation) c00013);
                            if (objNewTvSeriesLoadResponse2 == obj4) {
                                return obj4;
                            }
                            return objNewTvSeriesLoadResponse2;
                        } catch (Throwable th16) {
                            th = th16;
                            c00013 = this;
                            popupRaw2 = popupRaw;
                            directUrl5 = directUrl4;
                            links4 = links3;
                            seasonRegex3 = seasonRegex;
                            recommendations2 = currentList2;
                            regex4 = regex3;
                            popupList3 = popupList4;
                            currentRaw3 = currentRaw2;
                            poster4 = poster5;
                            title5 = title6;
                            recommendations3 = recommendations;
                            description4 = description5;
                            toLoadItem4 = toLoadItem6;
                            directUrl6 = videoId3;
                            dedupeByUrl5 = dedupeByUrl6;
                            out3 = out4;
                            rawTitle3 = rawTitle;
                            rawTitleLower2 = rawTitleLower;
                            tvType6 = tvType7;
                        }
                    } catch (Throwable th17) {
                        th = th17;
                        Function1 function1 = dedupeByUrl4;
                        String str12 = videoId2;
                        TvType tvType10 = tvType4;
                        String str13 = poster3;
                        String str14 = title4;
                        document4 = document3;
                        LoadlinksOut loadlinksOut = out2;
                        c00013 = c00012;
                        popupRaw2 = popupRaw;
                        directUrl5 = directUrl4;
                        links4 = links3;
                        seasonRegex3 = seasonRegex;
                        recommendations2 = currentList2;
                        regex4 = regex3;
                        popupList3 = popupList2;
                        currentRaw3 = currentRaw2;
                        poster4 = str13;
                        title5 = str14;
                        recommendations3 = recommendations;
                        description4 = directUrl;
                        toLoadItem4 = toLoadItem3;
                        directUrl6 = str12;
                        dedupeByUrl5 = function1;
                        out3 = loadlinksOut;
                        rawTitle3 = rawTitle;
                        rawTitleLower2 = rawTitleLower;
                        tvType6 = tvType10;
                    }
                    Result.Companion companion6 = Result.Companion;
                    regex5 = regex4;
                    document5 = document4;
                    toLoadItem7 = toLoadItem4;
                    dedupeByUrl7 = dedupeByUrl5;
                    popupList5 = popupList3;
                    currentList3 = recommendations2;
                    description6 = description4;
                    poster6 = poster4;
                    title7 = title5;
                    recommendations4 = recommendations3;
                    out5 = out3;
                    obj8 = Result.constructor-impl(ResultKt.createFailure(th));
                    rawTitle4 = rawTitle3;
                    if (Result.isFailure-impl(obj8)) {
                        obj8 = null;
                    }
                    data = (EpisodesResponse) obj8;
                    if (data != null) {
                        listEmptyList3 = data.getEpisodes();
                    } else {
                        listEmptyList3 = null;
                    }
                    if (listEmptyList3 == null) {
                        listEmptyList3 = CollectionsKt.emptyList();
                    }
                    list = listEmptyList3;
                    if (list.isEmpty()) {
                        c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                        c00013.L$1 = SpillingKt.nullOutSpilledVariable(document5);
                        c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                        c00013.L$3 = SpillingKt.nullOutSpilledVariable(title7);
                        c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster6);
                        c00013.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                        c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                        c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                        c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                        c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                        c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                        c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                        c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                        c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                        c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                        c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList3);
                        c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList5);
                        c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                        c00013.L$22 = SpillingKt.nullOutSpilledVariable(recommendations4);
                        c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                        c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                        c00013.label = 4;
                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title7, c00013.$url, TvType.TvSeries, CollectionsKt.emptyList(), new AnonymousClass2(poster6, description6, document5, recommendations4, null), (Continuation) c00013);
                        if (objNewTvSeriesLoadResponse == obj4) {
                            return obj4;
                        }
                        return objNewTvSeriesLoadResponse;
                    }
                    title8 = title7;
                    popupList6 = popupList5;
                    currentList4 = currentList3;
                    semaphore = SemaphoreKt.Semaphore$default(6, 0, 2, (Object) null);
                    Fibwatch$load$2$episodes$1 fibwatch$load$2$episodes$3 = new Fibwatch$load$2$episodes$1(list, semaphore, dedupeByUrl7, toLoadItem7, c00013.this$0, poster6, null);
                    poster7 = poster6;
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                    c00013.L$1 = document5;
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                    c00013.L$3 = title8;
                    c00013.L$4 = poster7;
                    c00013.L$5 = description6;
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                    c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                    c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                    c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                    c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                    c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList4);
                    c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList6);
                    c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                    c00013.L$22 = recommendations4;
                    c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                    c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                    c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore);
                    c00013.label = 5;
                    objCoroutineScope = CoroutineScopeKt.coroutineScope(fibwatch$load$2$episodes$3, (Continuation) c00013);
                    if (objCoroutineScope == obj4) {
                        return obj4;
                    }
                    String str15 = directUrl5;
                    currentRaw4 = currentRaw3;
                    currentList5 = currentList4;
                    videoId4 = directUrl6;
                    episodeRegex4 = episodeRegex3;
                    episodeRegex5 = sxeRegex;
                    description7 = str15;
                    out6 = out5;
                    title9 = title8;
                    description8 = description6;
                    document6 = document5;
                    popupList7 = recommendations4;
                    tvType8 = tvType6;
                    seasonRegex4 = seasonRegex3;
                    rawTitleLower3 = rawTitleLower2;
                    poster8 = poster7;
                    regex6 = regex5;
                    data2 = data;
                    semaphore2 = semaphore;
                    links5 = links4;
                    popupRaw3 = popupRaw2;
                    currentRaw5 = popupList6;
                    toLoadItem8 = toLoadItem7;
                    List episodes3 = (List) objCoroutineScope;
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(document6);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(title9);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(description8);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower3);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(episodeRegex5);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex4);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex4);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType8);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(videoId4);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem8);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex6);
                    c00013.L$15 = SpillingKt.nullOutSpilledVariable(description7);
                    c00013.L$16 = SpillingKt.nullOutSpilledVariable(links5);
                    c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw4);
                    c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw3);
                    c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList5);
                    c00013.L$20 = SpillingKt.nullOutSpilledVariable(currentRaw5);
                    c00013.L$21 = SpillingKt.nullOutSpilledVariable(out6);
                    c00013.L$22 = SpillingKt.nullOutSpilledVariable(popupList7);
                    c00013.L$23 = SpillingKt.nullOutSpilledVariable(data2);
                    c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                    c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore2);
                    c00013.L$26 = SpillingKt.nullOutSpilledVariable(episodes3);
                    c00013.label = 6;
                    objNewTvSeriesLoadResponse2 = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title9, c00013.$url, TvType.TvSeries, episodes3, new AnonymousClass3(poster8, c00013.this$0, description8, document6, popupList7, null), (Continuation) c00013);
                    if (objNewTvSeriesLoadResponse2 == obj4) {
                        return obj4;
                    }
                    return objNewTvSeriesLoadResponse2;
                case 1:
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    document = ((NiceResponse) obj).getDocument();
                    elementSelectFirst = document.selectFirst("meta[property=og:title]");
                    directUrl = "Unknown";
                    if (elementSelectFirst != null) {
                        strAttr = "Unknown";
                    } else {
                        strAttr = "Unknown";
                    }
                    String rawTitle6 = strAttr;
                    title = StringsKt.substringBefore$default(rawTitle6, "S0", (String) null, 2, (Object) null);
                    elementSelectFirst2 = document.selectFirst("meta[property=\"og:image\"]");
                    if (elementSelectFirst2 != null) {
                        strAttr2 = elementSelectFirst2.attr("content");
                    } else {
                        strAttr2 = null;
                    }
                    poster = strAttr2;
                    elementSelectFirst3 = document.selectFirst("meta[property=og:description]");
                    if (elementSelectFirst3 != null) {
                        directUrl = strAttr3;
                    }
                    String lowerCase2 = rawTitle6.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    rawTitleLower = lowerCase2;
                    Regex sxeRegex4 = new Regex("s\\d{1,2}e\\d{1,3}");
                    Regex seasonRegex6 = new Regex("\\bs\\d{1,2}\\b");
                    episodeRegex = new Regex("\\be\\d{1,3}\\b");
                    if (!sxeRegex4.containsMatchIn(rawTitleLower)) {
                        tvType = TvType.TvSeries;
                    }
                    tvType2 = tvType;
                    elementSelectFirst4 = document.selectFirst("input#video-id");
                    if (elementSelectFirst4 != null) {
                        it = null;
                    } else {
                        it = null;
                    }
                    videoId = it;
                    toLoadItem = new Function3() { // from class: com.Fibwatch.Fibwatch$load$2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj11, Object obj12, Object obj13) {
                            return Fibwatch.C00012.invokeSuspend$lambda$1((String) obj11, (String) obj12, ((Boolean) obj13).booleanValue());
                        }
                    };
                    dedupeByUrl = new Function1() { // from class: com.Fibwatch.Fibwatch$load$2$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj11) {
                            return Fibwatch.C00012.invokeSuspend$lambda$2((List) obj11);
                        }
                    };
                    regex = new Regex("var\\s+VIDEO_URL\\s*=\\s*[\"']([^\"']+)[\"']");
                    sxeRegex = sxeRegex4;
                    rawTitle = rawTitle6;
                    seasonRegex = seasonRegex6;
                    matchResultFind$default = Regex.find$default(regex, document.html(), 0, 2, (Object) null);
                    if (matchResultFind$default != null) {
                        directUrl2 = null;
                    } else {
                        directUrl2 = null;
                    }
                    str = directUrl2;
                    if (str != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (z) {
                        regex3 = regex;
                        links2 = new Links("200", CollectionsKt.listOf(new Current("Auto", directUrl2, false)), CollectionsKt.emptyList());
                        $this$withContext = $this$withContext2;
                        obj2 = "yes";
                        obj3 = "pop_up_18";
                        poster3 = poster;
                        title4 = title;
                        tvType4 = tvType2;
                        videoId2 = videoId;
                        dedupeByUrl4 = dedupeByUrl;
                        z2 = false;
                        c00012 = this;
                        document3 = document;
                        episodeRegex3 = episodeRegex;
                        toLoadItem3 = toLoadItem;
                        obj4 = coroutine_suspended;
                        directUrl4 = directUrl2;
                    } else {
                        fibwatch = this.this$0;
                        Result.Companion companion7 = Result.Companion;
                        if (videoId != null) {
                            Requests app3 = MainActivityKt.getApp();
                            String str16 = fibwatch.getMainUrl() + "/ajax/resolution_switcher.php?video_id=" + videoId;
                            Map mapMapOf3 = MapsKt.mapOf(TuplesKt.to("pop_up_18", "yes"));
                            this.L$0 = $this$withContext2;
                            this.L$1 = document;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                            this.L$3 = title;
                            this.L$4 = poster;
                            this.L$5 = directUrl;
                            this.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex);
                            this.L$10 = tvType2;
                            this.L$11 = videoId;
                            this.L$12 = toLoadItem;
                            this.L$13 = dedupeByUrl;
                            this.L$14 = SpillingKt.nullOutSpilledVariable(regex);
                            this.L$15 = SpillingKt.nullOutSpilledVariable(directUrl2);
                            this.L$16 = SpillingKt.nullOutSpilledVariable($this$withContext2);
                            $this$withContext = $this$withContext2;
                            this.label = 2;
                            description3 = directUrl;
                            directUrl3 = directUrl2;
                            z2 = false;
                            obj4 = coroutine_suspended;
                            obj2 = "yes";
                            obj3 = "pop_up_18";
                            obj5 = Requests.get$default(app3, str16, (Map) null, (String) null, (Map) null, mapMapOf3, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4078, (Object) null);
                            c00012 = this;
                            if (obj5 == obj4) {
                                return obj4;
                            }
                            document2 = document;
                            sxeRegex2 = sxeRegex;
                            seasonRegex2 = seasonRegex;
                            regex2 = regex;
                            description = description3;
                            toLoadItem2 = toLoadItem;
                            poster2 = poster;
                            title2 = title;
                            description2 = directUrl3;
                            episodeRegex2 = episodeRegex;
                            tvType3 = tvType2;
                            title3 = videoId;
                            dedupeByUrl2 = dedupeByUrl;
                            rawTitle2 = rawTitle;
                            NiceResponse this_$iv3 = (NiceResponse) obj5;
                            ResponseParser parser3 = this_$iv3.getParser();
                            Intrinsics.checkNotNull(parser3);
                            safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(Links.class));
                            dedupeByUrl3 = dedupeByUrl2;
                            links = (Links) safe;
                            obj6 = Result.constructor-impl(links);
                            if (Result.isFailure-impl(obj6)) {
                                obj6 = null;
                            }
                            links2 = (Links) obj6;
                            directUrl4 = description2;
                            regex3 = regex2;
                            toLoadItem3 = toLoadItem2;
                            videoId2 = title3;
                            tvType4 = tvType3;
                            directUrl = description;
                            title4 = title2;
                            rawTitle = rawTitle2;
                            document3 = document2;
                            dedupeByUrl4 = dedupeByUrl3;
                            sxeRegex = sxeRegex2;
                            episodeRegex3 = episodeRegex2;
                            seasonRegex = seasonRegex2;
                            poster3 = poster2;
                        } else {
                            $this$withContext = $this$withContext2;
                            obj2 = "yes";
                            obj3 = "pop_up_18";
                            String description12 = directUrl;
                            String directUrl8 = directUrl2;
                            dedupeByUrl3 = dedupeByUrl;
                            z2 = false;
                            c00012 = this;
                            obj4 = coroutine_suspended;
                            document2 = document;
                            sxeRegex2 = sxeRegex;
                            seasonRegex2 = seasonRegex;
                            regex2 = regex;
                            description = description12;
                            toLoadItem2 = toLoadItem;
                            poster2 = poster;
                            title2 = title;
                            description2 = directUrl8;
                            episodeRegex2 = episodeRegex;
                            tvType3 = tvType2;
                            title3 = videoId;
                            links = null;
                            rawTitle2 = rawTitle;
                            obj6 = Result.constructor-impl(links);
                            if (Result.isFailure-impl(obj6)) {
                                obj6 = null;
                            }
                            links2 = (Links) obj6;
                            directUrl4 = description2;
                            regex3 = regex2;
                            toLoadItem3 = toLoadItem2;
                            videoId2 = title3;
                            tvType4 = tvType3;
                            directUrl = description;
                            title4 = title2;
                            rawTitle = rawTitle2;
                            document3 = document2;
                            dedupeByUrl4 = dedupeByUrl3;
                            sxeRegex = sxeRegex2;
                            episodeRegex3 = episodeRegex2;
                            seasonRegex = seasonRegex2;
                            poster3 = poster2;
                        }
                        Result.Companion companion8 = Result.Companion;
                        dedupeByUrl3 = dedupeByUrl2;
                        obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                        if (Result.isFailure-impl(obj6)) {
                            obj6 = null;
                        }
                        links2 = (Links) obj6;
                        directUrl4 = description2;
                        regex3 = regex2;
                        toLoadItem3 = toLoadItem2;
                        videoId2 = title3;
                        tvType4 = tvType3;
                        directUrl = description;
                        title4 = title2;
                        rawTitle = rawTitle2;
                        document3 = document2;
                        dedupeByUrl4 = dedupeByUrl3;
                        sxeRegex = sxeRegex2;
                        episodeRegex3 = episodeRegex2;
                        seasonRegex = seasonRegex2;
                        poster3 = poster2;
                    }
                    links3 = links2;
                    if (links3 != null) {
                        listEmptyList = CollectionsKt.emptyList();
                    } else {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    currentRaw = listEmptyList;
                    if (links3 != null) {
                        listEmptyList2 = CollectionsKt.emptyList();
                    } else {
                        listEmptyList2 = CollectionsKt.emptyList();
                    }
                    popupRaw = listEmptyList2;
                    currentList = (List) dedupeByUrl4.invoke(currentRaw);
                    $this$filter$iv = popupRaw;
                    $i$f$filter = 0;
                    destination$iv$iv = new ArrayList();
                    while (r17.hasNext()) {
                        Iterable $this$filter$iv3 = $this$filter$iv;
                        item = (LoadItem) element$iv$iv;
                        List currentRaw7 = currentRaw;
                        $this$none$iv = currentList;
                        int $i$f$filter3 = $i$f$filter;
                        if ($this$none$iv instanceof Collection) {
                            it2 = $this$none$iv.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    Object element$iv2 = it2.next();
                                    it3 = (LoadItem) element$iv2;
                                    $this$none$iv2 = $this$none$iv;
                                    it4 = it2;
                                    if (Intrinsics.areEqual(it3.getUrl(), item.getUrl())) {
                                        z4 = false;
                                    } else {
                                        $this$none$iv = $this$none$iv2;
                                        it2 = it4;
                                    }
                                } else {
                                    z4 = true;
                                }
                            }
                        } else {
                            it2 = $this$none$iv.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    Object element$iv3 = it2.next();
                                    it3 = (LoadItem) element$iv3;
                                    $this$none$iv2 = $this$none$iv;
                                    it4 = it2;
                                    if (Intrinsics.areEqual(it3.getUrl(), item.getUrl())) {
                                        z4 = false;
                                    } else {
                                        $this$none$iv = $this$none$iv2;
                                        it2 = it4;
                                    }
                                } else {
                                    z4 = true;
                                }
                            }
                        }
                        if (z4) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        $this$filter$iv = $this$filter$iv3;
                        currentRaw = currentRaw7;
                        $i$f$filter = $i$f$filter3;
                    }
                    currentRaw2 = currentRaw;
                    popupList = (List) dedupeByUrl4.invoke((List) destination$iv$iv);
                    if (links3 != null) {
                        status = "error";
                    } else {
                        status = "error";
                    }
                    out = new LoadlinksOut(status, currentList, popupList);
                    if (out.getCurrent().isEmpty()) {
                        popupList2 = popupList;
                        currentList2 = currentList;
                        out2 = out;
                    } else {
                        popupList2 = popupList;
                        currentList2 = currentList;
                        out2 = out;
                    }
                    $this$mapNotNull$iv = document3.select("div.col-md-4.no-padding-left.mobile div.videos-list.pt_mn_wtch_rlts_prnt .video-wrapper");
                    fibwatch2 = c00012.this$0;
                    destination$iv$iv2 = new ArrayList();
                    while (r33.hasNext()) {
                        Iterable $this$mapNotNull$iv5 = $this$mapNotNull$iv;
                        Element it12 = (Element) element$iv$iv$iv3;
                        searchResult = fibwatch2.toSearchResult(it12);
                        if (searchResult != null) {
                            destination$iv$iv2.add(searchResult);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv5;
                    }
                    recommendations = (List) destination$iv$iv2;
                    tvType5 = TvType.TvSeries;
                    fibwatch3 = c00012.this$0;
                    if (tvType4 != tvType5) {
                        Function1 dedupeByUrl10 = dedupeByUrl4;
                        String description13 = directUrl;
                        String title12 = title4;
                        Document document8 = document3;
                        LoadlinksOut out9 = out2;
                        C00012 c00015 = c00012;
                        c00015.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                        c00015.L$1 = SpillingKt.nullOutSpilledVariable(document8);
                        c00015.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                        c00015.L$3 = SpillingKt.nullOutSpilledVariable(title12);
                        c00015.L$4 = SpillingKt.nullOutSpilledVariable(poster3);
                        c00015.L$5 = SpillingKt.nullOutSpilledVariable(description13);
                        c00015.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower);
                        c00015.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                        c00015.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex);
                        c00015.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                        c00015.L$10 = SpillingKt.nullOutSpilledVariable(tvType4);
                        c00015.L$11 = SpillingKt.nullOutSpilledVariable(videoId2);
                        c00015.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem3);
                        c00015.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl10);
                        c00015.L$14 = SpillingKt.nullOutSpilledVariable(regex3);
                        c00015.L$15 = SpillingKt.nullOutSpilledVariable(directUrl4);
                        c00015.L$16 = SpillingKt.nullOutSpilledVariable(links3);
                        c00015.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw2);
                        c00015.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw);
                        c00015.L$19 = SpillingKt.nullOutSpilledVariable(currentList2);
                        c00015.L$20 = SpillingKt.nullOutSpilledVariable(popupList2);
                        c00015.L$21 = SpillingKt.nullOutSpilledVariable(out9);
                        c00015.L$22 = SpillingKt.nullOutSpilledVariable(recommendations);
                        c00015.label = 7;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(fibwatch3, title12, c00015.$url, TvType.Movie, AppUtils.INSTANCE.toJson(out9), new AnonymousClass4(poster3, c00015.this$0, description13, document8, recommendations, null), (Continuation) c00015);
                        if (objNewMovieLoadResponse == obj4) {
                            return obj4;
                        }
                        return objNewMovieLoadResponse;
                    }
                    Result.Companion companion9 = Result.Companion;
                    $this$invokeSuspend_u24lambda_u249 = $this$withContext;
                    if (videoId2 == null) {
                        Function1 dedupeByUrl11 = dedupeByUrl4;
                        toLoadItem5 = toLoadItem3;
                        String videoId6 = videoId2;
                        TvType tvType11 = tvType4;
                        String description14 = directUrl;
                        String poster10 = poster3;
                        String title13 = title4;
                        document4 = document3;
                        LoadlinksOut out10 = out2;
                        c00013 = c00012;
                        popupRaw2 = popupRaw;
                        directUrl5 = directUrl4;
                        links4 = links3;
                        seasonRegex3 = seasonRegex;
                        recommendations2 = currentList2;
                        regex4 = regex3;
                        popupList3 = popupList2;
                        currentRaw3 = currentRaw2;
                        poster4 = poster10;
                        title5 = title13;
                        recommendations3 = recommendations;
                        description4 = description14;
                        directUrl6 = videoId6;
                        dedupeByUrl5 = dedupeByUrl11;
                        out3 = out10;
                        episodesResponse = null;
                        rawTitle3 = rawTitle;
                        rawTitleLower2 = rawTitleLower;
                        tvType6 = tvType11;
                        Object obj11 = Result.constructor-impl(episodesResponse);
                        regex5 = regex4;
                        document5 = document4;
                        toLoadItem7 = toLoadItem5;
                        recommendations4 = recommendations3;
                        out5 = out3;
                        dedupeByUrl7 = dedupeByUrl5;
                        popupList5 = popupList3;
                        currentList3 = recommendations2;
                        description6 = description4;
                        poster6 = poster4;
                        title7 = title5;
                        obj8 = obj11;
                        rawTitle4 = rawTitle3;
                        if (Result.isFailure-impl(obj8)) {
                            obj8 = null;
                        }
                        data = (EpisodesResponse) obj8;
                        if (data != null) {
                            listEmptyList3 = data.getEpisodes();
                        } else {
                            listEmptyList3 = null;
                        }
                        if (listEmptyList3 == null) {
                            listEmptyList3 = CollectionsKt.emptyList();
                        }
                        list = listEmptyList3;
                        if (list.isEmpty()) {
                            c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                            c00013.L$1 = SpillingKt.nullOutSpilledVariable(document5);
                            c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                            c00013.L$3 = SpillingKt.nullOutSpilledVariable(title7);
                            c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster6);
                            c00013.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                            c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                            c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                            c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                            c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                            c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                            c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                            c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                            c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                            c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                            c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                            c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                            c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList3);
                            c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList5);
                            c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                            c00013.L$22 = SpillingKt.nullOutSpilledVariable(recommendations4);
                            c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                            c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                            c00013.label = 4;
                            objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title7, c00013.$url, TvType.TvSeries, CollectionsKt.emptyList(), new AnonymousClass2(poster6, description6, document5, recommendations4, null), (Continuation) c00013);
                            if (objNewTvSeriesLoadResponse == obj4) {
                                return obj4;
                            }
                            return objNewTvSeriesLoadResponse;
                        }
                        title8 = title7;
                        popupList6 = popupList5;
                        currentList4 = currentList3;
                        semaphore = SemaphoreKt.Semaphore$default(6, 0, 2, (Object) null);
                        Fibwatch$load$2$episodes$1 fibwatch$load$2$episodes$4 = new Fibwatch$load$2$episodes$1(list, semaphore, dedupeByUrl7, toLoadItem7, c00013.this$0, poster6, null);
                        poster7 = poster6;
                        c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                        c00013.L$1 = document5;
                        c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                        c00013.L$3 = title8;
                        c00013.L$4 = poster7;
                        c00013.L$5 = description6;
                        c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                        c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                        c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                        c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                        c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                        c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                        c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                        c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                        c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                        c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList4);
                        c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList6);
                        c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                        c00013.L$22 = recommendations4;
                        c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                        c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                        c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore);
                        c00013.label = 5;
                        objCoroutineScope = CoroutineScopeKt.coroutineScope(fibwatch$load$2$episodes$4, (Continuation) c00013);
                        if (objCoroutineScope == obj4) {
                            return obj4;
                        }
                        String str17 = directUrl5;
                        currentRaw4 = currentRaw3;
                        currentList5 = currentList4;
                        videoId4 = directUrl6;
                        episodeRegex4 = episodeRegex3;
                        episodeRegex5 = sxeRegex;
                        description7 = str17;
                        out6 = out5;
                        title9 = title8;
                        description8 = description6;
                        document6 = document5;
                        popupList7 = recommendations4;
                        tvType8 = tvType6;
                        seasonRegex4 = seasonRegex3;
                        rawTitleLower3 = rawTitleLower2;
                        poster8 = poster7;
                        regex6 = regex5;
                        data2 = data;
                        semaphore2 = semaphore;
                        links5 = links4;
                        popupRaw3 = popupRaw2;
                        currentRaw5 = popupList6;
                        toLoadItem8 = toLoadItem7;
                        List episodes4 = (List) objCoroutineScope;
                        c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                        c00013.L$1 = SpillingKt.nullOutSpilledVariable(document6);
                        c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                        c00013.L$3 = SpillingKt.nullOutSpilledVariable(title9);
                        c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                        c00013.L$5 = SpillingKt.nullOutSpilledVariable(description8);
                        c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower3);
                        c00013.L$7 = SpillingKt.nullOutSpilledVariable(episodeRegex5);
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex4);
                        c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex4);
                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType8);
                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(videoId4);
                        c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem8);
                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                        c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex6);
                        c00013.L$15 = SpillingKt.nullOutSpilledVariable(description7);
                        c00013.L$16 = SpillingKt.nullOutSpilledVariable(links5);
                        c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw4);
                        c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw3);
                        c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList5);
                        c00013.L$20 = SpillingKt.nullOutSpilledVariable(currentRaw5);
                        c00013.L$21 = SpillingKt.nullOutSpilledVariable(out6);
                        c00013.L$22 = SpillingKt.nullOutSpilledVariable(popupList7);
                        c00013.L$23 = SpillingKt.nullOutSpilledVariable(data2);
                        c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                        c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore2);
                        c00013.L$26 = SpillingKt.nullOutSpilledVariable(episodes4);
                        c00013.label = 6;
                        objNewTvSeriesLoadResponse2 = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title9, c00013.$url, TvType.TvSeries, episodes4, new AnonymousClass3(poster8, c00013.this$0, description8, document6, popupList7, null), (Continuation) c00013);
                        if (objNewTvSeriesLoadResponse2 == obj4) {
                            return obj4;
                        }
                        return objNewTvSeriesLoadResponse2;
                    }
                    Requests app4 = MainActivityKt.getApp();
                    String str18 = fibwatch3.getMainUrl() + "/ajax/episodes.php?video_id=" + videoId2;
                    Map mapMapOf4 = MapsKt.mapOf(TuplesKt.to(obj3, obj2));
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                    c00012.L$1 = document3;
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                    c00012.L$3 = title4;
                    c00012.L$4 = poster3;
                    c00012.L$5 = directUrl;
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex);
                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(tvType4);
                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(videoId2);
                    c00012.L$12 = toLoadItem3;
                    c00012.L$13 = dedupeByUrl4;
                    c00012.L$14 = SpillingKt.nullOutSpilledVariable(regex3);
                    c00012.L$15 = SpillingKt.nullOutSpilledVariable(directUrl4);
                    c00012.L$16 = SpillingKt.nullOutSpilledVariable(links3);
                    c00012.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw2);
                    c00012.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw);
                    c00012.L$19 = SpillingKt.nullOutSpilledVariable(currentList2);
                    c00012.L$20 = SpillingKt.nullOutSpilledVariable(popupList2);
                    c00012.L$21 = SpillingKt.nullOutSpilledVariable(out2);
                    c00012.L$22 = recommendations;
                    c00012.L$23 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u249);
                    c00012.label = 3;
                    toLoadItem6 = toLoadItem3;
                    videoId3 = videoId2;
                    tvType7 = tvType4;
                    poster5 = poster3;
                    title6 = title4;
                    document4 = document3;
                    dedupeByUrl6 = dedupeByUrl4;
                    description5 = directUrl;
                    out4 = out2;
                    popupList4 = popupList2;
                    obj7 = Requests.get$default(app4, str18, (Map) null, (String) null, (Map) null, mapMapOf4, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4078, (Object) null);
                    c00013 = this;
                    if (obj7 == obj4) {
                        return obj4;
                    }
                    $this$invokeSuspend_u24lambda_u2410 = $this$invokeSuspend_u24lambda_u249;
                    popupRaw2 = popupRaw;
                    directUrl5 = directUrl4;
                    links4 = links3;
                    seasonRegex3 = seasonRegex;
                    recommendations2 = currentList2;
                    regex4 = regex3;
                    popupList3 = popupList4;
                    currentRaw3 = currentRaw2;
                    poster4 = poster5;
                    title5 = title6;
                    recommendations3 = recommendations;
                    description4 = description5;
                    toLoadItem4 = toLoadItem6;
                    directUrl6 = videoId3;
                    dedupeByUrl5 = dedupeByUrl6;
                    out3 = out4;
                    rawTitle3 = rawTitle;
                    rawTitleLower2 = rawTitleLower;
                    tvType6 = tvType7;
                    NiceResponse this_$iv4 = (NiceResponse) obj7;
                    ResponseParser parser4 = this_$iv4.getParser();
                    Intrinsics.checkNotNull(parser4);
                    safe2 = parser4.parseSafe(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(EpisodesResponse.class));
                    toLoadItem5 = toLoadItem4;
                    episodesResponse = (EpisodesResponse) safe2;
                    Object obj12 = Result.constructor-impl(episodesResponse);
                    regex5 = regex4;
                    document5 = document4;
                    toLoadItem7 = toLoadItem5;
                    recommendations4 = recommendations3;
                    out5 = out3;
                    dedupeByUrl7 = dedupeByUrl5;
                    popupList5 = popupList3;
                    currentList3 = recommendations2;
                    description6 = description4;
                    poster6 = poster4;
                    title7 = title5;
                    obj8 = obj12;
                    rawTitle4 = rawTitle3;
                    if (Result.isFailure-impl(obj8)) {
                        obj8 = null;
                    }
                    data = (EpisodesResponse) obj8;
                    if (data != null) {
                        listEmptyList3 = data.getEpisodes();
                    } else {
                        listEmptyList3 = null;
                    }
                    if (listEmptyList3 == null) {
                        listEmptyList3 = CollectionsKt.emptyList();
                    }
                    list = listEmptyList3;
                    if (list.isEmpty()) {
                        c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                        c00013.L$1 = SpillingKt.nullOutSpilledVariable(document5);
                        c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                        c00013.L$3 = SpillingKt.nullOutSpilledVariable(title7);
                        c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster6);
                        c00013.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                        c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                        c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                        c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                        c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                        c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                        c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                        c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                        c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                        c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                        c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList3);
                        c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList5);
                        c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                        c00013.L$22 = SpillingKt.nullOutSpilledVariable(recommendations4);
                        c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                        c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                        c00013.label = 4;
                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title7, c00013.$url, TvType.TvSeries, CollectionsKt.emptyList(), new AnonymousClass2(poster6, description6, document5, recommendations4, null), (Continuation) c00013);
                        if (objNewTvSeriesLoadResponse == obj4) {
                            return obj4;
                        }
                        return objNewTvSeriesLoadResponse;
                    }
                    title8 = title7;
                    popupList6 = popupList5;
                    currentList4 = currentList3;
                    semaphore = SemaphoreKt.Semaphore$default(6, 0, 2, (Object) null);
                    Fibwatch$load$2$episodes$1 fibwatch$load$2$episodes$5 = new Fibwatch$load$2$episodes$1(list, semaphore, dedupeByUrl7, toLoadItem7, c00013.this$0, poster6, null);
                    poster7 = poster6;
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                    c00013.L$1 = document5;
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                    c00013.L$3 = title8;
                    c00013.L$4 = poster7;
                    c00013.L$5 = description6;
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                    c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                    c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                    c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                    c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                    c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList4);
                    c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList6);
                    c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                    c00013.L$22 = recommendations4;
                    c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                    c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                    c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore);
                    c00013.label = 5;
                    objCoroutineScope = CoroutineScopeKt.coroutineScope(fibwatch$load$2$episodes$5, (Continuation) c00013);
                    if (objCoroutineScope == obj4) {
                        return obj4;
                    }
                    String str19 = directUrl5;
                    currentRaw4 = currentRaw3;
                    currentList5 = currentList4;
                    videoId4 = directUrl6;
                    episodeRegex4 = episodeRegex3;
                    episodeRegex5 = sxeRegex;
                    description7 = str19;
                    out6 = out5;
                    title9 = title8;
                    description8 = description6;
                    document6 = document5;
                    popupList7 = recommendations4;
                    tvType8 = tvType6;
                    seasonRegex4 = seasonRegex3;
                    rawTitleLower3 = rawTitleLower2;
                    poster8 = poster7;
                    regex6 = regex5;
                    data2 = data;
                    semaphore2 = semaphore;
                    links5 = links4;
                    popupRaw3 = popupRaw2;
                    currentRaw5 = popupList6;
                    toLoadItem8 = toLoadItem7;
                    List episodes5 = (List) objCoroutineScope;
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(document6);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(title9);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(description8);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower3);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(episodeRegex5);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex4);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex4);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType8);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(videoId4);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem8);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex6);
                    c00013.L$15 = SpillingKt.nullOutSpilledVariable(description7);
                    c00013.L$16 = SpillingKt.nullOutSpilledVariable(links5);
                    c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw4);
                    c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw3);
                    c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList5);
                    c00013.L$20 = SpillingKt.nullOutSpilledVariable(currentRaw5);
                    c00013.L$21 = SpillingKt.nullOutSpilledVariable(out6);
                    c00013.L$22 = SpillingKt.nullOutSpilledVariable(popupList7);
                    c00013.L$23 = SpillingKt.nullOutSpilledVariable(data2);
                    c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                    c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore2);
                    c00013.L$26 = SpillingKt.nullOutSpilledVariable(episodes5);
                    c00013.label = 6;
                    objNewTvSeriesLoadResponse2 = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title9, c00013.$url, TvType.TvSeries, episodes5, new AnonymousClass3(poster8, c00013.this$0, description8, document6, popupList7, null), (Continuation) c00013);
                    if (objNewTvSeriesLoadResponse2 == obj4) {
                        return obj4;
                    }
                    return objNewTvSeriesLoadResponse2;
                    Result.Companion companion10 = Result.Companion;
                    regex5 = regex4;
                    document5 = document4;
                    toLoadItem7 = toLoadItem4;
                    dedupeByUrl7 = dedupeByUrl5;
                    popupList5 = popupList3;
                    currentList3 = recommendations2;
                    description6 = description4;
                    poster6 = poster4;
                    title7 = title5;
                    recommendations4 = recommendations3;
                    out5 = out3;
                    obj8 = Result.constructor-impl(ResultKt.createFailure(th));
                    rawTitle4 = rawTitle3;
                    if (Result.isFailure-impl(obj8)) {
                        obj8 = null;
                    }
                    data = (EpisodesResponse) obj8;
                    if (data != null) {
                        listEmptyList3 = data.getEpisodes();
                    } else {
                        listEmptyList3 = null;
                    }
                    if (listEmptyList3 == null) {
                        listEmptyList3 = CollectionsKt.emptyList();
                    }
                    list = listEmptyList3;
                    if (list.isEmpty()) {
                        c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                        c00013.L$1 = SpillingKt.nullOutSpilledVariable(document5);
                        c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                        c00013.L$3 = SpillingKt.nullOutSpilledVariable(title7);
                        c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster6);
                        c00013.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                        c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                        c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                        c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                        c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                        c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                        c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                        c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                        c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                        c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                        c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList3);
                        c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList5);
                        c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                        c00013.L$22 = SpillingKt.nullOutSpilledVariable(recommendations4);
                        c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                        c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                        c00013.label = 4;
                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title7, c00013.$url, TvType.TvSeries, CollectionsKt.emptyList(), new AnonymousClass2(poster6, description6, document5, recommendations4, null), (Continuation) c00013);
                        if (objNewTvSeriesLoadResponse == obj4) {
                            return obj4;
                        }
                        return objNewTvSeriesLoadResponse;
                    }
                    title8 = title7;
                    popupList6 = popupList5;
                    currentList4 = currentList3;
                    semaphore = SemaphoreKt.Semaphore$default(6, 0, 2, (Object) null);
                    Fibwatch$load$2$episodes$1 fibwatch$load$2$episodes$6 = new Fibwatch$load$2$episodes$1(list, semaphore, dedupeByUrl7, toLoadItem7, c00013.this$0, poster6, null);
                    poster7 = poster6;
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                    c00013.L$1 = document5;
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                    c00013.L$3 = title8;
                    c00013.L$4 = poster7;
                    c00013.L$5 = description6;
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                    c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                    c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                    c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                    c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                    c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList4);
                    c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList6);
                    c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                    c00013.L$22 = recommendations4;
                    c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                    c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                    c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore);
                    c00013.label = 5;
                    objCoroutineScope = CoroutineScopeKt.coroutineScope(fibwatch$load$2$episodes$6, (Continuation) c00013);
                    if (objCoroutineScope == obj4) {
                        return obj4;
                    }
                    String str110 = directUrl5;
                    currentRaw4 = currentRaw3;
                    currentList5 = currentList4;
                    videoId4 = directUrl6;
                    episodeRegex4 = episodeRegex3;
                    episodeRegex5 = sxeRegex;
                    description7 = str110;
                    out6 = out5;
                    title9 = title8;
                    description8 = description6;
                    document6 = document5;
                    popupList7 = recommendations4;
                    tvType8 = tvType6;
                    seasonRegex4 = seasonRegex3;
                    rawTitleLower3 = rawTitleLower2;
                    poster8 = poster7;
                    regex6 = regex5;
                    data2 = data;
                    semaphore2 = semaphore;
                    links5 = links4;
                    popupRaw3 = popupRaw2;
                    currentRaw5 = popupList6;
                    toLoadItem8 = toLoadItem7;
                    List episodes6 = (List) objCoroutineScope;
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(document6);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(title9);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(description8);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower3);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(episodeRegex5);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex4);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex4);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType8);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(videoId4);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem8);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex6);
                    c00013.L$15 = SpillingKt.nullOutSpilledVariable(description7);
                    c00013.L$16 = SpillingKt.nullOutSpilledVariable(links5);
                    c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw4);
                    c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw3);
                    c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList5);
                    c00013.L$20 = SpillingKt.nullOutSpilledVariable(currentRaw5);
                    c00013.L$21 = SpillingKt.nullOutSpilledVariable(out6);
                    c00013.L$22 = SpillingKt.nullOutSpilledVariable(popupList7);
                    c00013.L$23 = SpillingKt.nullOutSpilledVariable(data2);
                    c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                    c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore2);
                    c00013.L$26 = SpillingKt.nullOutSpilledVariable(episodes6);
                    c00013.label = 6;
                    objNewTvSeriesLoadResponse2 = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title9, c00013.$url, TvType.TvSeries, episodes6, new AnonymousClass3(poster8, c00013.this$0, description8, document6, popupList7, null), (Continuation) c00013);
                    if (objNewTvSeriesLoadResponse2 == obj4) {
                        return obj4;
                    }
                    return objNewTvSeriesLoadResponse2;
                case 2:
                    description2 = (String) this.L$15;
                    regex2 = (Regex) this.L$14;
                    dedupeByUrl2 = (Function1) this.L$13;
                    toLoadItem2 = (Function3) this.L$12;
                    title3 = (String) this.L$11;
                    tvType3 = (TvType) this.L$10;
                    episodeRegex2 = (Regex) this.L$9;
                    seasonRegex2 = (Regex) this.L$8;
                    sxeRegex2 = (Regex) this.L$7;
                    rawTitleLower = (String) this.L$6;
                    description = (String) this.L$5;
                    poster2 = (String) this.L$4;
                    title2 = (String) this.L$3;
                    rawTitle2 = (String) this.L$2;
                    document2 = (Document) this.L$1;
                    try {
                        ResultKt.throwOnFailure($result);
                        obj5 = $result;
                        $this$withContext = $this$withContext2;
                        obj2 = "yes";
                        obj3 = "pop_up_18";
                        z2 = false;
                        c00012 = this;
                        obj4 = coroutine_suspended;
                        NiceResponse this_$iv5 = (NiceResponse) obj5;
                        ResponseParser parser5 = this_$iv5.getParser();
                        Intrinsics.checkNotNull(parser5);
                        safe = parser5.parseSafe(this_$iv5.getText(), Reflection.getOrCreateKotlinClass(Links.class));
                        dedupeByUrl3 = dedupeByUrl2;
                        links = (Links) safe;
                        obj6 = Result.constructor-impl(links);
                    } catch (Throwable th18) {
                        th = th18;
                        $this$withContext = $this$withContext2;
                        obj2 = "yes";
                        obj3 = "pop_up_18";
                        z2 = false;
                        c00012 = this;
                        obj4 = coroutine_suspended;
                        break;
                    }
                    if (Result.isFailure-impl(obj6)) {
                        obj6 = null;
                    }
                    links2 = (Links) obj6;
                    directUrl4 = description2;
                    regex3 = regex2;
                    toLoadItem3 = toLoadItem2;
                    videoId2 = title3;
                    tvType4 = tvType3;
                    directUrl = description;
                    title4 = title2;
                    rawTitle = rawTitle2;
                    document3 = document2;
                    dedupeByUrl4 = dedupeByUrl3;
                    sxeRegex = sxeRegex2;
                    episodeRegex3 = episodeRegex2;
                    seasonRegex = seasonRegex2;
                    poster3 = poster2;
                    links3 = links2;
                    if (links3 != null) {
                        listEmptyList = CollectionsKt.emptyList();
                    } else {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    currentRaw = listEmptyList;
                    if (links3 != null) {
                        listEmptyList2 = CollectionsKt.emptyList();
                    } else {
                        listEmptyList2 = CollectionsKt.emptyList();
                    }
                    popupRaw = listEmptyList2;
                    currentList = (List) dedupeByUrl4.invoke(currentRaw);
                    $this$filter$iv = popupRaw;
                    $i$f$filter = 0;
                    destination$iv$iv = new ArrayList();
                    while (r17.hasNext()) {
                        Iterable $this$filter$iv4 = $this$filter$iv;
                        item = (LoadItem) element$iv$iv;
                        List currentRaw8 = currentRaw;
                        $this$none$iv = currentList;
                        int $i$f$filter4 = $i$f$filter;
                        if ($this$none$iv instanceof Collection) {
                            it2 = $this$none$iv.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    Object element$iv4 = it2.next();
                                    it3 = (LoadItem) element$iv4;
                                    $this$none$iv2 = $this$none$iv;
                                    it4 = it2;
                                    if (Intrinsics.areEqual(it3.getUrl(), item.getUrl())) {
                                        z4 = false;
                                    } else {
                                        $this$none$iv = $this$none$iv2;
                                        it2 = it4;
                                    }
                                } else {
                                    z4 = true;
                                }
                            }
                        } else {
                            it2 = $this$none$iv.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    Object element$iv5 = it2.next();
                                    it3 = (LoadItem) element$iv5;
                                    $this$none$iv2 = $this$none$iv;
                                    it4 = it2;
                                    if (Intrinsics.areEqual(it3.getUrl(), item.getUrl())) {
                                        z4 = false;
                                    } else {
                                        $this$none$iv = $this$none$iv2;
                                        it2 = it4;
                                    }
                                } else {
                                    z4 = true;
                                }
                            }
                        }
                        if (z4) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        $this$filter$iv = $this$filter$iv4;
                        currentRaw = currentRaw8;
                        $i$f$filter = $i$f$filter4;
                    }
                    currentRaw2 = currentRaw;
                    popupList = (List) dedupeByUrl4.invoke((List) destination$iv$iv);
                    if (links3 != null) {
                        status = "error";
                    } else {
                        status = "error";
                    }
                    out = new LoadlinksOut(status, currentList, popupList);
                    if (out.getCurrent().isEmpty()) {
                        popupList2 = popupList;
                        currentList2 = currentList;
                        out2 = out;
                    } else {
                        popupList2 = popupList;
                        currentList2 = currentList;
                        out2 = out;
                    }
                    $this$mapNotNull$iv = document3.select("div.col-md-4.no-padding-left.mobile div.videos-list.pt_mn_wtch_rlts_prnt .video-wrapper");
                    fibwatch2 = c00012.this$0;
                    destination$iv$iv2 = new ArrayList();
                    while (r33.hasNext()) {
                        Iterable $this$mapNotNull$iv6 = $this$mapNotNull$iv;
                        Element it13 = (Element) element$iv$iv$iv3;
                        searchResult = fibwatch2.toSearchResult(it13);
                        if (searchResult != null) {
                            destination$iv$iv2.add(searchResult);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv6;
                    }
                    recommendations = (List) destination$iv$iv2;
                    tvType5 = TvType.TvSeries;
                    fibwatch3 = c00012.this$0;
                    if (tvType4 != tvType5) {
                        Function1 dedupeByUrl12 = dedupeByUrl4;
                        String description15 = directUrl;
                        String title14 = title4;
                        Document document9 = document3;
                        LoadlinksOut out11 = out2;
                        C00012 c00016 = c00012;
                        c00016.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                        c00016.L$1 = SpillingKt.nullOutSpilledVariable(document9);
                        c00016.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                        c00016.L$3 = SpillingKt.nullOutSpilledVariable(title14);
                        c00016.L$4 = SpillingKt.nullOutSpilledVariable(poster3);
                        c00016.L$5 = SpillingKt.nullOutSpilledVariable(description15);
                        c00016.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower);
                        c00016.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                        c00016.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex);
                        c00016.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                        c00016.L$10 = SpillingKt.nullOutSpilledVariable(tvType4);
                        c00016.L$11 = SpillingKt.nullOutSpilledVariable(videoId2);
                        c00016.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem3);
                        c00016.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl12);
                        c00016.L$14 = SpillingKt.nullOutSpilledVariable(regex3);
                        c00016.L$15 = SpillingKt.nullOutSpilledVariable(directUrl4);
                        c00016.L$16 = SpillingKt.nullOutSpilledVariable(links3);
                        c00016.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw2);
                        c00016.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw);
                        c00016.L$19 = SpillingKt.nullOutSpilledVariable(currentList2);
                        c00016.L$20 = SpillingKt.nullOutSpilledVariable(popupList2);
                        c00016.L$21 = SpillingKt.nullOutSpilledVariable(out11);
                        c00016.L$22 = SpillingKt.nullOutSpilledVariable(recommendations);
                        c00016.label = 7;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(fibwatch3, title14, c00016.$url, TvType.Movie, AppUtils.INSTANCE.toJson(out11), new AnonymousClass4(poster3, c00016.this$0, description15, document9, recommendations, null), (Continuation) c00016);
                        if (objNewMovieLoadResponse == obj4) {
                            return obj4;
                        }
                        return objNewMovieLoadResponse;
                    }
                    Result.Companion companion11 = Result.Companion;
                    $this$invokeSuspend_u24lambda_u249 = $this$withContext;
                    if (videoId2 == null) {
                        Function1 dedupeByUrl13 = dedupeByUrl4;
                        toLoadItem5 = toLoadItem3;
                        String videoId7 = videoId2;
                        TvType tvType12 = tvType4;
                        String description16 = directUrl;
                        String poster11 = poster3;
                        String title15 = title4;
                        document4 = document3;
                        LoadlinksOut out12 = out2;
                        c00013 = c00012;
                        popupRaw2 = popupRaw;
                        directUrl5 = directUrl4;
                        links4 = links3;
                        seasonRegex3 = seasonRegex;
                        recommendations2 = currentList2;
                        regex4 = regex3;
                        popupList3 = popupList2;
                        currentRaw3 = currentRaw2;
                        poster4 = poster11;
                        title5 = title15;
                        recommendations3 = recommendations;
                        description4 = description16;
                        directUrl6 = videoId7;
                        dedupeByUrl5 = dedupeByUrl13;
                        out3 = out12;
                        episodesResponse = null;
                        rawTitle3 = rawTitle;
                        rawTitleLower2 = rawTitleLower;
                        tvType6 = tvType12;
                        Object obj13 = Result.constructor-impl(episodesResponse);
                        regex5 = regex4;
                        document5 = document4;
                        toLoadItem7 = toLoadItem5;
                        recommendations4 = recommendations3;
                        out5 = out3;
                        dedupeByUrl7 = dedupeByUrl5;
                        popupList5 = popupList3;
                        currentList3 = recommendations2;
                        description6 = description4;
                        poster6 = poster4;
                        title7 = title5;
                        obj8 = obj13;
                        rawTitle4 = rawTitle3;
                        if (Result.isFailure-impl(obj8)) {
                            obj8 = null;
                        }
                        data = (EpisodesResponse) obj8;
                        if (data != null) {
                            listEmptyList3 = data.getEpisodes();
                        } else {
                            listEmptyList3 = null;
                        }
                        if (listEmptyList3 == null) {
                            listEmptyList3 = CollectionsKt.emptyList();
                        }
                        list = listEmptyList3;
                        if (list.isEmpty()) {
                            c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                            c00013.L$1 = SpillingKt.nullOutSpilledVariable(document5);
                            c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                            c00013.L$3 = SpillingKt.nullOutSpilledVariable(title7);
                            c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster6);
                            c00013.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                            c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                            c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                            c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                            c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                            c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                            c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                            c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                            c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                            c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                            c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                            c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                            c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList3);
                            c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList5);
                            c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                            c00013.L$22 = SpillingKt.nullOutSpilledVariable(recommendations4);
                            c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                            c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                            c00013.label = 4;
                            objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title7, c00013.$url, TvType.TvSeries, CollectionsKt.emptyList(), new AnonymousClass2(poster6, description6, document5, recommendations4, null), (Continuation) c00013);
                            if (objNewTvSeriesLoadResponse == obj4) {
                                return obj4;
                            }
                            return objNewTvSeriesLoadResponse;
                        }
                        title8 = title7;
                        popupList6 = popupList5;
                        currentList4 = currentList3;
                        semaphore = SemaphoreKt.Semaphore$default(6, 0, 2, (Object) null);
                        Fibwatch$load$2$episodes$1 fibwatch$load$2$episodes$7 = new Fibwatch$load$2$episodes$1(list, semaphore, dedupeByUrl7, toLoadItem7, c00013.this$0, poster6, null);
                        poster7 = poster6;
                        c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                        c00013.L$1 = document5;
                        c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                        c00013.L$3 = title8;
                        c00013.L$4 = poster7;
                        c00013.L$5 = description6;
                        c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                        c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                        c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                        c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                        c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                        c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                        c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                        c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                        c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                        c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList4);
                        c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList6);
                        c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                        c00013.L$22 = recommendations4;
                        c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                        c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                        c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore);
                        c00013.label = 5;
                        objCoroutineScope = CoroutineScopeKt.coroutineScope(fibwatch$load$2$episodes$7, (Continuation) c00013);
                        if (objCoroutineScope == obj4) {
                            return obj4;
                        }
                        String str111 = directUrl5;
                        currentRaw4 = currentRaw3;
                        currentList5 = currentList4;
                        videoId4 = directUrl6;
                        episodeRegex4 = episodeRegex3;
                        episodeRegex5 = sxeRegex;
                        description7 = str111;
                        out6 = out5;
                        title9 = title8;
                        description8 = description6;
                        document6 = document5;
                        popupList7 = recommendations4;
                        tvType8 = tvType6;
                        seasonRegex4 = seasonRegex3;
                        rawTitleLower3 = rawTitleLower2;
                        poster8 = poster7;
                        regex6 = regex5;
                        data2 = data;
                        semaphore2 = semaphore;
                        links5 = links4;
                        popupRaw3 = popupRaw2;
                        currentRaw5 = popupList6;
                        toLoadItem8 = toLoadItem7;
                        List episodes7 = (List) objCoroutineScope;
                        c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                        c00013.L$1 = SpillingKt.nullOutSpilledVariable(document6);
                        c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                        c00013.L$3 = SpillingKt.nullOutSpilledVariable(title9);
                        c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                        c00013.L$5 = SpillingKt.nullOutSpilledVariable(description8);
                        c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower3);
                        c00013.L$7 = SpillingKt.nullOutSpilledVariable(episodeRegex5);
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex4);
                        c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex4);
                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType8);
                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(videoId4);
                        c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem8);
                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                        c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex6);
                        c00013.L$15 = SpillingKt.nullOutSpilledVariable(description7);
                        c00013.L$16 = SpillingKt.nullOutSpilledVariable(links5);
                        c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw4);
                        c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw3);
                        c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList5);
                        c00013.L$20 = SpillingKt.nullOutSpilledVariable(currentRaw5);
                        c00013.L$21 = SpillingKt.nullOutSpilledVariable(out6);
                        c00013.L$22 = SpillingKt.nullOutSpilledVariable(popupList7);
                        c00013.L$23 = SpillingKt.nullOutSpilledVariable(data2);
                        c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                        c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore2);
                        c00013.L$26 = SpillingKt.nullOutSpilledVariable(episodes7);
                        c00013.label = 6;
                        objNewTvSeriesLoadResponse2 = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title9, c00013.$url, TvType.TvSeries, episodes7, new AnonymousClass3(poster8, c00013.this$0, description8, document6, popupList7, null), (Continuation) c00013);
                        if (objNewTvSeriesLoadResponse2 == obj4) {
                            return obj4;
                        }
                        return objNewTvSeriesLoadResponse2;
                    }
                    Requests app5 = MainActivityKt.getApp();
                    String str112 = fibwatch3.getMainUrl() + "/ajax/episodes.php?video_id=" + videoId2;
                    Map mapMapOf5 = MapsKt.mapOf(TuplesKt.to(obj3, obj2));
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                    c00012.L$1 = document3;
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                    c00012.L$3 = title4;
                    c00012.L$4 = poster3;
                    c00012.L$5 = directUrl;
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex);
                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(tvType4);
                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(videoId2);
                    c00012.L$12 = toLoadItem3;
                    c00012.L$13 = dedupeByUrl4;
                    c00012.L$14 = SpillingKt.nullOutSpilledVariable(regex3);
                    c00012.L$15 = SpillingKt.nullOutSpilledVariable(directUrl4);
                    c00012.L$16 = SpillingKt.nullOutSpilledVariable(links3);
                    c00012.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw2);
                    c00012.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw);
                    c00012.L$19 = SpillingKt.nullOutSpilledVariable(currentList2);
                    c00012.L$20 = SpillingKt.nullOutSpilledVariable(popupList2);
                    c00012.L$21 = SpillingKt.nullOutSpilledVariable(out2);
                    c00012.L$22 = recommendations;
                    c00012.L$23 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u249);
                    c00012.label = 3;
                    toLoadItem6 = toLoadItem3;
                    videoId3 = videoId2;
                    tvType7 = tvType4;
                    poster5 = poster3;
                    title6 = title4;
                    document4 = document3;
                    dedupeByUrl6 = dedupeByUrl4;
                    description5 = directUrl;
                    out4 = out2;
                    popupList4 = popupList2;
                    obj7 = Requests.get$default(app5, str112, (Map) null, (String) null, (Map) null, mapMapOf5, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4078, (Object) null);
                    c00013 = this;
                    if (obj7 == obj4) {
                        return obj4;
                    }
                    $this$invokeSuspend_u24lambda_u2410 = $this$invokeSuspend_u24lambda_u249;
                    popupRaw2 = popupRaw;
                    directUrl5 = directUrl4;
                    links4 = links3;
                    seasonRegex3 = seasonRegex;
                    recommendations2 = currentList2;
                    regex4 = regex3;
                    popupList3 = popupList4;
                    currentRaw3 = currentRaw2;
                    poster4 = poster5;
                    title5 = title6;
                    recommendations3 = recommendations;
                    description4 = description5;
                    toLoadItem4 = toLoadItem6;
                    directUrl6 = videoId3;
                    dedupeByUrl5 = dedupeByUrl6;
                    out3 = out4;
                    rawTitle3 = rawTitle;
                    rawTitleLower2 = rawTitleLower;
                    tvType6 = tvType7;
                    NiceResponse this_$iv6 = (NiceResponse) obj7;
                    ResponseParser parser6 = this_$iv6.getParser();
                    Intrinsics.checkNotNull(parser6);
                    safe2 = parser6.parseSafe(this_$iv6.getText(), Reflection.getOrCreateKotlinClass(EpisodesResponse.class));
                    toLoadItem5 = toLoadItem4;
                    episodesResponse = (EpisodesResponse) safe2;
                    Object obj14 = Result.constructor-impl(episodesResponse);
                    regex5 = regex4;
                    document5 = document4;
                    toLoadItem7 = toLoadItem5;
                    recommendations4 = recommendations3;
                    out5 = out3;
                    dedupeByUrl7 = dedupeByUrl5;
                    popupList5 = popupList3;
                    currentList3 = recommendations2;
                    description6 = description4;
                    poster6 = poster4;
                    title7 = title5;
                    obj8 = obj14;
                    rawTitle4 = rawTitle3;
                    if (Result.isFailure-impl(obj8)) {
                        obj8 = null;
                    }
                    data = (EpisodesResponse) obj8;
                    if (data != null) {
                        listEmptyList3 = data.getEpisodes();
                    } else {
                        listEmptyList3 = null;
                    }
                    if (listEmptyList3 == null) {
                        listEmptyList3 = CollectionsKt.emptyList();
                    }
                    list = listEmptyList3;
                    if (list.isEmpty()) {
                        c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                        c00013.L$1 = SpillingKt.nullOutSpilledVariable(document5);
                        c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                        c00013.L$3 = SpillingKt.nullOutSpilledVariable(title7);
                        c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster6);
                        c00013.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                        c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                        c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                        c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                        c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                        c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                        c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                        c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                        c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                        c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                        c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList3);
                        c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList5);
                        c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                        c00013.L$22 = SpillingKt.nullOutSpilledVariable(recommendations4);
                        c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                        c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                        c00013.label = 4;
                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title7, c00013.$url, TvType.TvSeries, CollectionsKt.emptyList(), new AnonymousClass2(poster6, description6, document5, recommendations4, null), (Continuation) c00013);
                        if (objNewTvSeriesLoadResponse == obj4) {
                            return obj4;
                        }
                        return objNewTvSeriesLoadResponse;
                    }
                    title8 = title7;
                    popupList6 = popupList5;
                    currentList4 = currentList3;
                    semaphore = SemaphoreKt.Semaphore$default(6, 0, 2, (Object) null);
                    Fibwatch$load$2$episodes$1 fibwatch$load$2$episodes$8 = new Fibwatch$load$2$episodes$1(list, semaphore, dedupeByUrl7, toLoadItem7, c00013.this$0, poster6, null);
                    poster7 = poster6;
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                    c00013.L$1 = document5;
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                    c00013.L$3 = title8;
                    c00013.L$4 = poster7;
                    c00013.L$5 = description6;
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                    c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                    c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                    c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                    c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                    c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList4);
                    c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList6);
                    c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                    c00013.L$22 = recommendations4;
                    c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                    c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                    c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore);
                    c00013.label = 5;
                    objCoroutineScope = CoroutineScopeKt.coroutineScope(fibwatch$load$2$episodes$8, (Continuation) c00013);
                    if (objCoroutineScope == obj4) {
                        return obj4;
                    }
                    String str113 = directUrl5;
                    currentRaw4 = currentRaw3;
                    currentList5 = currentList4;
                    videoId4 = directUrl6;
                    episodeRegex4 = episodeRegex3;
                    episodeRegex5 = sxeRegex;
                    description7 = str113;
                    out6 = out5;
                    title9 = title8;
                    description8 = description6;
                    document6 = document5;
                    popupList7 = recommendations4;
                    tvType8 = tvType6;
                    seasonRegex4 = seasonRegex3;
                    rawTitleLower3 = rawTitleLower2;
                    poster8 = poster7;
                    regex6 = regex5;
                    data2 = data;
                    semaphore2 = semaphore;
                    links5 = links4;
                    popupRaw3 = popupRaw2;
                    currentRaw5 = popupList6;
                    toLoadItem8 = toLoadItem7;
                    List episodes8 = (List) objCoroutineScope;
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(document6);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(title9);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(description8);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower3);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(episodeRegex5);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex4);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex4);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType8);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(videoId4);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem8);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex6);
                    c00013.L$15 = SpillingKt.nullOutSpilledVariable(description7);
                    c00013.L$16 = SpillingKt.nullOutSpilledVariable(links5);
                    c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw4);
                    c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw3);
                    c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList5);
                    c00013.L$20 = SpillingKt.nullOutSpilledVariable(currentRaw5);
                    c00013.L$21 = SpillingKt.nullOutSpilledVariable(out6);
                    c00013.L$22 = SpillingKt.nullOutSpilledVariable(popupList7);
                    c00013.L$23 = SpillingKt.nullOutSpilledVariable(data2);
                    c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                    c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore2);
                    c00013.L$26 = SpillingKt.nullOutSpilledVariable(episodes8);
                    c00013.label = 6;
                    objNewTvSeriesLoadResponse2 = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title9, c00013.$url, TvType.TvSeries, episodes8, new AnonymousClass3(poster8, c00013.this$0, description8, document6, popupList7, null), (Continuation) c00013);
                    if (objNewTvSeriesLoadResponse2 == obj4) {
                        return obj4;
                    }
                    return objNewTvSeriesLoadResponse2;
                    Result.Companion companion12 = Result.Companion;
                    regex5 = regex4;
                    document5 = document4;
                    toLoadItem7 = toLoadItem4;
                    dedupeByUrl7 = dedupeByUrl5;
                    popupList5 = popupList3;
                    currentList3 = recommendations2;
                    description6 = description4;
                    poster6 = poster4;
                    title7 = title5;
                    recommendations4 = recommendations3;
                    out5 = out3;
                    obj8 = Result.constructor-impl(ResultKt.createFailure(th));
                    rawTitle4 = rawTitle3;
                    if (Result.isFailure-impl(obj8)) {
                        obj8 = null;
                    }
                    data = (EpisodesResponse) obj8;
                    if (data != null) {
                        listEmptyList3 = data.getEpisodes();
                    } else {
                        listEmptyList3 = null;
                    }
                    if (listEmptyList3 == null) {
                        listEmptyList3 = CollectionsKt.emptyList();
                    }
                    list = listEmptyList3;
                    if (list.isEmpty()) {
                        c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                        c00013.L$1 = SpillingKt.nullOutSpilledVariable(document5);
                        c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                        c00013.L$3 = SpillingKt.nullOutSpilledVariable(title7);
                        c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster6);
                        c00013.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                        c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                        c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                        c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                        c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                        c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                        c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                        c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                        c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                        c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                        c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList3);
                        c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList5);
                        c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                        c00013.L$22 = SpillingKt.nullOutSpilledVariable(recommendations4);
                        c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                        c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                        c00013.label = 4;
                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title7, c00013.$url, TvType.TvSeries, CollectionsKt.emptyList(), new AnonymousClass2(poster6, description6, document5, recommendations4, null), (Continuation) c00013);
                        if (objNewTvSeriesLoadResponse == obj4) {
                            return obj4;
                        }
                        return objNewTvSeriesLoadResponse;
                    }
                    title8 = title7;
                    popupList6 = popupList5;
                    currentList4 = currentList3;
                    semaphore = SemaphoreKt.Semaphore$default(6, 0, 2, (Object) null);
                    Fibwatch$load$2$episodes$1 fibwatch$load$2$episodes$9 = new Fibwatch$load$2$episodes$1(list, semaphore, dedupeByUrl7, toLoadItem7, c00013.this$0, poster6, null);
                    poster7 = poster6;
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                    c00013.L$1 = document5;
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                    c00013.L$3 = title8;
                    c00013.L$4 = poster7;
                    c00013.L$5 = description6;
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                    c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                    c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                    c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                    c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                    c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList4);
                    c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList6);
                    c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                    c00013.L$22 = recommendations4;
                    c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                    c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                    c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore);
                    c00013.label = 5;
                    objCoroutineScope = CoroutineScopeKt.coroutineScope(fibwatch$load$2$episodes$9, (Continuation) c00013);
                    if (objCoroutineScope == obj4) {
                        return obj4;
                    }
                    String str114 = directUrl5;
                    currentRaw4 = currentRaw3;
                    currentList5 = currentList4;
                    videoId4 = directUrl6;
                    episodeRegex4 = episodeRegex3;
                    episodeRegex5 = sxeRegex;
                    description7 = str114;
                    out6 = out5;
                    title9 = title8;
                    description8 = description6;
                    document6 = document5;
                    popupList7 = recommendations4;
                    tvType8 = tvType6;
                    seasonRegex4 = seasonRegex3;
                    rawTitleLower3 = rawTitleLower2;
                    poster8 = poster7;
                    regex6 = regex5;
                    data2 = data;
                    semaphore2 = semaphore;
                    links5 = links4;
                    popupRaw3 = popupRaw2;
                    currentRaw5 = popupList6;
                    toLoadItem8 = toLoadItem7;
                    List episodes9 = (List) objCoroutineScope;
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(document6);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(title9);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(description8);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower3);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(episodeRegex5);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex4);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex4);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType8);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(videoId4);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem8);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex6);
                    c00013.L$15 = SpillingKt.nullOutSpilledVariable(description7);
                    c00013.L$16 = SpillingKt.nullOutSpilledVariable(links5);
                    c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw4);
                    c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw3);
                    c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList5);
                    c00013.L$20 = SpillingKt.nullOutSpilledVariable(currentRaw5);
                    c00013.L$21 = SpillingKt.nullOutSpilledVariable(out6);
                    c00013.L$22 = SpillingKt.nullOutSpilledVariable(popupList7);
                    c00013.L$23 = SpillingKt.nullOutSpilledVariable(data2);
                    c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                    c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore2);
                    c00013.L$26 = SpillingKt.nullOutSpilledVariable(episodes9);
                    c00013.label = 6;
                    objNewTvSeriesLoadResponse2 = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title9, c00013.$url, TvType.TvSeries, episodes9, new AnonymousClass3(poster8, c00013.this$0, description8, document6, popupList7, null), (Continuation) c00013);
                    if (objNewTvSeriesLoadResponse2 == obj4) {
                        return obj4;
                    }
                    return objNewTvSeriesLoadResponse2;
                case 3:
                    $this$invokeSuspend_u24lambda_u2410 = (CoroutineScope) this.L$23;
                    recommendations3 = (List) this.L$22;
                    out3 = (LoadlinksOut) this.L$21;
                    popupList3 = (List) this.L$20;
                    recommendations2 = (List) this.L$19;
                    popupRaw2 = (List) this.L$18;
                    currentRaw3 = (List) this.L$17;
                    links4 = (Links) this.L$16;
                    directUrl5 = (String) this.L$15;
                    regex4 = (Regex) this.L$14;
                    dedupeByUrl5 = (Function1) this.L$13;
                    toLoadItem4 = (Function3) this.L$12;
                    directUrl6 = (String) this.L$11;
                    tvType6 = (TvType) this.L$10;
                    episodeRegex3 = (Regex) this.L$9;
                    seasonRegex3 = (Regex) this.L$8;
                    sxeRegex = (Regex) this.L$7;
                    rawTitleLower2 = (String) this.L$6;
                    description4 = (String) this.L$5;
                    poster4 = (String) this.L$4;
                    title5 = (String) this.L$3;
                    rawTitle3 = (String) this.L$2;
                    Document document10 = (Document) this.L$1;
                    try {
                        ResultKt.throwOnFailure($result);
                        c00013 = this;
                        obj4 = coroutine_suspended;
                        document4 = document10;
                        $this$withContext = $this$withContext2;
                        obj7 = $result;
                        NiceResponse this_$iv7 = (NiceResponse) obj7;
                        ResponseParser parser7 = this_$iv7.getParser();
                        Intrinsics.checkNotNull(parser7);
                        safe2 = parser7.parseSafe(this_$iv7.getText(), Reflection.getOrCreateKotlinClass(EpisodesResponse.class));
                        toLoadItem5 = toLoadItem4;
                        episodesResponse = (EpisodesResponse) safe2;
                        Object obj15 = Result.constructor-impl(episodesResponse);
                        regex5 = regex4;
                        document5 = document4;
                        toLoadItem7 = toLoadItem5;
                        recommendations4 = recommendations3;
                        out5 = out3;
                        dedupeByUrl7 = dedupeByUrl5;
                        popupList5 = popupList3;
                        currentList3 = recommendations2;
                        description6 = description4;
                        poster6 = poster4;
                        title7 = title5;
                        obj8 = obj15;
                        rawTitle4 = rawTitle3;
                    } catch (Throwable th19) {
                        th = th19;
                        c00013 = this;
                        obj4 = coroutine_suspended;
                        document4 = document10;
                        $this$withContext = $this$withContext2;
                        break;
                    }
                    if (Result.isFailure-impl(obj8)) {
                        obj8 = null;
                    }
                    data = (EpisodesResponse) obj8;
                    if (data != null) {
                        listEmptyList3 = data.getEpisodes();
                    } else {
                        listEmptyList3 = null;
                    }
                    if (listEmptyList3 == null) {
                        listEmptyList3 = CollectionsKt.emptyList();
                    }
                    list = listEmptyList3;
                    if (list.isEmpty()) {
                        c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                        c00013.L$1 = SpillingKt.nullOutSpilledVariable(document5);
                        c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                        c00013.L$3 = SpillingKt.nullOutSpilledVariable(title7);
                        c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster6);
                        c00013.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                        c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                        c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                        c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                        c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                        c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                        c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                        c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                        c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                        c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                        c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList3);
                        c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList5);
                        c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                        c00013.L$22 = SpillingKt.nullOutSpilledVariable(recommendations4);
                        c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                        c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                        c00013.label = 4;
                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title7, c00013.$url, TvType.TvSeries, CollectionsKt.emptyList(), new AnonymousClass2(poster6, description6, document5, recommendations4, null), (Continuation) c00013);
                        if (objNewTvSeriesLoadResponse == obj4) {
                            return obj4;
                        }
                        return objNewTvSeriesLoadResponse;
                    }
                    title8 = title7;
                    popupList6 = popupList5;
                    currentList4 = currentList3;
                    semaphore = SemaphoreKt.Semaphore$default(6, 0, 2, (Object) null);
                    Fibwatch$load$2$episodes$1 fibwatch$load$2$episodes$10 = new Fibwatch$load$2$episodes$1(list, semaphore, dedupeByUrl7, toLoadItem7, c00013.this$0, poster6, null);
                    poster7 = poster6;
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                    c00013.L$1 = document5;
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                    c00013.L$3 = title8;
                    c00013.L$4 = poster7;
                    c00013.L$5 = description6;
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower2);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(sxeRegex);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex3);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType6);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(directUrl6);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem7);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex5);
                    c00013.L$15 = SpillingKt.nullOutSpilledVariable(directUrl5);
                    c00013.L$16 = SpillingKt.nullOutSpilledVariable(links4);
                    c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw3);
                    c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw2);
                    c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList4);
                    c00013.L$20 = SpillingKt.nullOutSpilledVariable(popupList6);
                    c00013.L$21 = SpillingKt.nullOutSpilledVariable(out5);
                    c00013.L$22 = recommendations4;
                    c00013.L$23 = SpillingKt.nullOutSpilledVariable(data);
                    c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                    c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore);
                    c00013.label = 5;
                    objCoroutineScope = CoroutineScopeKt.coroutineScope(fibwatch$load$2$episodes$10, (Continuation) c00013);
                    if (objCoroutineScope == obj4) {
                        return obj4;
                    }
                    String str115 = directUrl5;
                    currentRaw4 = currentRaw3;
                    currentList5 = currentList4;
                    videoId4 = directUrl6;
                    episodeRegex4 = episodeRegex3;
                    episodeRegex5 = sxeRegex;
                    description7 = str115;
                    out6 = out5;
                    title9 = title8;
                    description8 = description6;
                    document6 = document5;
                    popupList7 = recommendations4;
                    tvType8 = tvType6;
                    seasonRegex4 = seasonRegex3;
                    rawTitleLower3 = rawTitleLower2;
                    poster8 = poster7;
                    regex6 = regex5;
                    data2 = data;
                    semaphore2 = semaphore;
                    links5 = links4;
                    popupRaw3 = popupRaw2;
                    currentRaw5 = popupList6;
                    toLoadItem8 = toLoadItem7;
                    List episodes10 = (List) objCoroutineScope;
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(document6);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(title9);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(description8);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower3);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(episodeRegex5);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex4);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex4);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType8);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(videoId4);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem8);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex6);
                    c00013.L$15 = SpillingKt.nullOutSpilledVariable(description7);
                    c00013.L$16 = SpillingKt.nullOutSpilledVariable(links5);
                    c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw4);
                    c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw3);
                    c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList5);
                    c00013.L$20 = SpillingKt.nullOutSpilledVariable(currentRaw5);
                    c00013.L$21 = SpillingKt.nullOutSpilledVariable(out6);
                    c00013.L$22 = SpillingKt.nullOutSpilledVariable(popupList7);
                    c00013.L$23 = SpillingKt.nullOutSpilledVariable(data2);
                    c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                    c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore2);
                    c00013.L$26 = SpillingKt.nullOutSpilledVariable(episodes10);
                    c00013.label = 6;
                    objNewTvSeriesLoadResponse2 = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title9, c00013.$url, TvType.TvSeries, episodes10, new AnonymousClass3(poster8, c00013.this$0, description8, document6, popupList7, null), (Continuation) c00013);
                    if (objNewTvSeriesLoadResponse2 == obj4) {
                        return obj4;
                    }
                    return objNewTvSeriesLoadResponse2;
                case 4:
                    ResultKt.throwOnFailure($result);
                    return $result;
                case 5:
                    Semaphore semaphore3 = (Semaphore) this.L$25;
                    List<EpisodeItem> list2 = (List) this.L$24;
                    EpisodesResponse data3 = (EpisodesResponse) this.L$23;
                    List recommendations5 = (List) this.L$22;
                    LoadlinksOut out13 = (LoadlinksOut) this.L$21;
                    List popupList8 = (List) this.L$20;
                    List currentList6 = (List) this.L$19;
                    List popupRaw4 = (List) this.L$18;
                    List currentRaw9 = (List) this.L$17;
                    Links links6 = (Links) this.L$16;
                    String directUrl9 = (String) this.L$15;
                    Regex regex7 = (Regex) this.L$14;
                    Function1 dedupeByUrl14 = (Function1) this.L$13;
                    semaphore2 = semaphore3;
                    toLoadItem8 = (Function3) this.L$12;
                    videoId4 = (String) this.L$11;
                    tvType8 = (TvType) this.L$10;
                    episodeRegex4 = (Regex) this.L$9;
                    seasonRegex4 = (Regex) this.L$8;
                    episodeRegex5 = (Regex) this.L$7;
                    rawTitleLower3 = (String) this.L$6;
                    String description17 = (String) this.L$5;
                    String poster12 = (String) this.L$4;
                    String title16 = (String) this.L$3;
                    String rawTitle7 = (String) this.L$2;
                    Document document11 = (Document) this.L$1;
                    ResultKt.throwOnFailure($result);
                    c00013 = this;
                    obj4 = coroutine_suspended;
                    $this$withContext = $this$withContext2;
                    dedupeByUrl7 = dedupeByUrl14;
                    list = list2;
                    data2 = data3;
                    links5 = links6;
                    poster8 = poster12;
                    title9 = title16;
                    objCoroutineScope = $result;
                    currentList5 = currentList6;
                    regex6 = regex7;
                    currentRaw4 = currentRaw9;
                    currentRaw5 = popupList8;
                    popupList7 = recommendations5;
                    description8 = description17;
                    description7 = directUrl9;
                    popupRaw3 = popupRaw4;
                    out6 = out13;
                    document6 = document11;
                    rawTitle4 = rawTitle7;
                    List episodes11 = (List) objCoroutineScope;
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable($this$withContext);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(document6);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(title9);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(description8);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(rawTitleLower3);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(episodeRegex5);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(seasonRegex4);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(episodeRegex4);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(tvType8);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(videoId4);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(toLoadItem8);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(dedupeByUrl7);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(regex6);
                    c00013.L$15 = SpillingKt.nullOutSpilledVariable(description7);
                    c00013.L$16 = SpillingKt.nullOutSpilledVariable(links5);
                    c00013.L$17 = SpillingKt.nullOutSpilledVariable(currentRaw4);
                    c00013.L$18 = SpillingKt.nullOutSpilledVariable(popupRaw3);
                    c00013.L$19 = SpillingKt.nullOutSpilledVariable(currentList5);
                    c00013.L$20 = SpillingKt.nullOutSpilledVariable(currentRaw5);
                    c00013.L$21 = SpillingKt.nullOutSpilledVariable(out6);
                    c00013.L$22 = SpillingKt.nullOutSpilledVariable(popupList7);
                    c00013.L$23 = SpillingKt.nullOutSpilledVariable(data2);
                    c00013.L$24 = SpillingKt.nullOutSpilledVariable(list);
                    c00013.L$25 = SpillingKt.nullOutSpilledVariable(semaphore2);
                    c00013.L$26 = SpillingKt.nullOutSpilledVariable(episodes11);
                    c00013.label = 6;
                    objNewTvSeriesLoadResponse2 = MainAPIKt.newTvSeriesLoadResponse(c00013.this$0, title9, c00013.$url, TvType.TvSeries, episodes11, new AnonymousClass3(poster8, c00013.this$0, description8, document6, popupList7, null), (Continuation) c00013);
                    if (objNewTvSeriesLoadResponse2 == obj4) {
                        return obj4;
                    }
                    return objNewTvSeriesLoadResponse2;
                case 6:
                    ResultKt.throwOnFailure($result);
                    return $result;
                case 7:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        static final LoadItem invokeSuspend$lambda$1(String r, String u, boolean s) {
            String string = r != null ? StringsKt.trim(r).toString() : null;
            if (string == null) {
                string = "";
            }
            String string2 = u != null ? StringsKt.trim(u).toString() : null;
            return new LoadItem(string, string2 != null ? string2 : "", s);
        }

        static final List invokeSuspend$lambda$2(List list) {
            LinkedHashSet seen = new LinkedHashSet();
            List $this$filter$iv = list;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                LoadItem it = (LoadItem) element$iv$iv;
                if (seen.add(it.getUrl())) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            return (List) destination$iv$iv;
        }

        /* JADX INFO: renamed from: com.Fibwatch.Fibwatch$load$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: Fibwatch.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.Fibwatch.Fibwatch$load$2$2", f = "Fibwatch.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        @SourceDebugExtension({"SMAP\nFibwatch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Fibwatch.kt\ncom/Fibwatch/Fibwatch$load$2$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,363:1\n1739#2:364\n1814#2,3:365\n*S KotlinDebug\n*F\n+ 1 Fibwatch.kt\ncom/Fibwatch/Fibwatch$load$2$2\n*L\n188#1:364\n188#1:365,3\n*E\n"})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $description;
            final /* synthetic */ Document $document;
            final /* synthetic */ String $poster;
            final /* synthetic */ List<SearchResponse> $recommendations;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(String str, String str2, Document document, List<? extends SearchResponse> list, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$poster = str;
                this.$description = str2;
                this.$document = document;
                this.$recommendations = list;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.$poster, this.$description, this.$document, this.$recommendations, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
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
                        $this$newTvSeriesLoadResponse.setPosterUrl(this.$poster);
                        $this$newTvSeriesLoadResponse.setPlot(this.$description);
                        Iterable $this$map$iv = this.$document.select("div.tags-list a[rel='tag']");
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            Element it = (Element) item$iv$iv;
                            destination$iv$iv.add(it.text());
                        }
                        $this$newTvSeriesLoadResponse.setTags((List) destination$iv$iv);
                        $this$newTvSeriesLoadResponse.setRecommendations(this.$recommendations);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.Fibwatch.Fibwatch$load$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: Fibwatch.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.Fibwatch.Fibwatch$load$2$3", f = "Fibwatch.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        @SourceDebugExtension({"SMAP\nFibwatch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Fibwatch.kt\ncom/Fibwatch/Fibwatch$load$2$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,363:1\n1739#2:364\n1814#2,3:365\n*S KotlinDebug\n*F\n+ 1 Fibwatch.kt\ncom/Fibwatch/Fibwatch$load$2$3\n*L\n281#1:364\n281#1:365,3\n*E\n"})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $description;
            final /* synthetic */ Document $document;
            final /* synthetic */ String $poster;
            final /* synthetic */ List<SearchResponse> $recommendations;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ Fibwatch this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(String str, Fibwatch fibwatch, String str2, Document document, List<? extends SearchResponse> list, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$poster = str;
                this.this$0 = fibwatch;
                this.$description = str2;
                this.$document = document;
                this.$recommendations = list;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass3 = new AnonymousClass3(this.$poster, this.this$0, this.$description, this.$document, this.$recommendations, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
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
                        $this$newTvSeriesLoadResponse.setPosterUrl(this.$poster);
                        $this$newTvSeriesLoadResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this.this$0.getMainUrl())));
                        $this$newTvSeriesLoadResponse.setPlot(this.$description);
                        Iterable $this$map$iv = this.$document.select("div.tags-list a[rel='tag']");
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            Element it = (Element) item$iv$iv;
                            destination$iv$iv.add(it.text());
                        }
                        $this$newTvSeriesLoadResponse.setTags((List) destination$iv$iv);
                        $this$newTvSeriesLoadResponse.setRecommendations(this.$recommendations);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.Fibwatch.Fibwatch$load$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: Fibwatch.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.Fibwatch.Fibwatch$load$2$4", f = "Fibwatch.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        @SourceDebugExtension({"SMAP\nFibwatch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Fibwatch.kt\ncom/Fibwatch/Fibwatch$load$2$4\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,363:1\n1739#2:364\n1814#2,3:365\n*S KotlinDebug\n*F\n+ 1 Fibwatch.kt\ncom/Fibwatch/Fibwatch$load$2$4\n*L\n289#1:364\n289#1:365,3\n*E\n"})
        static final class AnonymousClass4 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $description;
            final /* synthetic */ Document $document;
            final /* synthetic */ String $poster;
            final /* synthetic */ List<SearchResponse> $recommendations;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ Fibwatch this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(String str, Fibwatch fibwatch, String str2, Document document, List<? extends SearchResponse> list, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$poster = str;
                this.this$0 = fibwatch;
                this.$description = str2;
                this.$document = document;
                this.$recommendations = list;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass4 = new AnonymousClass4(this.$poster, this.this$0, this.$description, this.$document, this.$recommendations, continuation);
                anonymousClass4.L$0 = obj;
                return anonymousClass4;
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
                        $this$newMovieLoadResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this.this$0.getMainUrl())));
                        $this$newMovieLoadResponse.setPlot(this.$description);
                        Iterable $this$map$iv = this.$document.select("div.tags-list a[rel='tag']");
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            Element it = (Element) item$iv$iv;
                            destination$iv$iv.add(it.text());
                        }
                        $this$newMovieLoadResponse.setTags((List) destination$iv$iv);
                        $this$newMovieLoadResponse.setRecommendations(this.$recommendations);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    static /* synthetic */ Object load$suspendImpl(Fibwatch $this, String url, Continuation<? super LoadResponse> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00012(url, $this, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0127  */
    /* JADX WARN: Code duplicated, block: B:59:0x012c  */
    /* JADX WARN: Code duplicated, block: B:61:0x0159 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x015a  */
    /* JADX WARN: Code duplicated, block: B:66:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:68:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:72:0x0220 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:73:0x0221  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:88:0x01cd A[SYNTHETIC] */
    static /* synthetic */ Object loadLinks$suspendImpl(Fibwatch $this, String data, boolean isCasting, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Boolean> continuation) {
        C00021 c00021;
        Object obj;
        boolean z;
        Object objDecodeFromString;
        LoadlinksOut loadData;
        Object objAmap;
        LoadlinksOut loadData2;
        boolean isCasting2;
        String data2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Set currentUrls;
        Object element$iv$iv;
        Collection destination$iv$iv;
        Object combined;
        C00033 c00033;
        LoadItem it;
        Fibwatch $this2 = $this;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
            } else {
                c00021 = $this2.new C00021(continuation);
            }
        } else {
            c00021 = $this2.new C00021(continuation);
        }
        C00021 c00022 = c00021;
        Object $result = c00022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00022.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                if (data != null) {
                    try {
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(LoadlinksOut.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            z = true;
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                z = true;
                                try {
                                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LoadlinksOut.class), (List) null, 2, (Object) null));
                                    break;
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        Result.Companion companion4 = Result.Companion;
                                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                                    } catch (Exception e) {
                                        objDecodeFromString = null;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                z = true;
                            }
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                            } catch (SerializationException e2) {
                                ArchComponentExtKt.logError(e2);
                                ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv.readValue(data, new TypeReference<LoadlinksOut>() { // from class: com.Fibwatch.Fibwatch$loadLinks$suspendImpl$$inlined$tryParseJson$1
                                });
                            } catch (Throwable th4) {
                                ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(data, new TypeReference<LoadlinksOut>() { // from class: com.Fibwatch.Fibwatch$loadLinks$suspendImpl$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(data, new TypeReference<LoadlinksOut>() { // from class: com.Fibwatch.Fibwatch$loadLinks$suspendImpl$$inlined$tryParseJson$1
                            });
                        }
                    } catch (Exception e3) {
                        z = true;
                        objDecodeFromString = null;
                        loadData = (LoadlinksOut) objDecodeFromString;
                        if (loadData == null) {
                            return Boxing.boxBoolean(z);
                        }
                        List<LoadItem> current = loadData.getCurrent();
                        Fibwatch$loadLinks$currentUrls$1 fibwatch$loadLinks$currentUrls$1 = new Fibwatch$loadLinks$currentUrls$1(null);
                        c00022.L$0 = $this2;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(data);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                        c00022.L$3 = function2;
                        c00022.L$4 = loadData;
                        c00022.Z$0 = isCasting;
                        c00022.label = 1;
                        objAmap = ParCollectionsKt.amap(current, fibwatch$loadLinks$currentUrls$1, c00022);
                        if (objAmap == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        loadData2 = loadData;
                        isCasting2 = isCasting;
                        data2 = data;
                        function3 = function1;
                        function4 = function2;
                        currentUrls = CollectionsKt.toSet((Iterable) objAmap);
                        element$iv$iv = new ArrayList(loadData2.getCurrent().size() + loadData2.getPopup().size());
                        CollectionsKt.addAll((Collection) element$iv$iv, loadData2.getCurrent());
                        ArrayList arrayList = (Collection) element$iv$iv;
                        Iterable $this$filter$iv = loadData2.getPopup();
                        destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv2 : $this$filter$iv) {
                            Object combined2 = element$iv$iv;
                            it = (LoadItem) element$iv$iv2;
                            Object $result2 = $result;
                            if (!currentUrls.contains(StringsKt.trim(it.getUrl()).toString())) {
                                destination$iv$iv.add(element$iv$iv2);
                            }
                            element$iv$iv = combined2;
                            $result = $result2;
                        }
                        combined = element$iv$iv;
                        CollectionsKt.addAll(arrayList, (List) destination$iv$iv);
                        c00033 = $this2.new C00033(function4, null);
                        c00022.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(loadData2);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(currentUrls);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(combined);
                        c00022.Z$0 = isCasting2;
                        c00022.label = 2;
                        if (ParCollectionsKt.amap((List) combined, c00033, c00022) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Boxing.boxBoolean(true);
                    }
                    break;
                } else {
                    objDecodeFromString = null;
                    z = true;
                }
                loadData = (LoadlinksOut) objDecodeFromString;
                if (loadData == null) {
                    return Boxing.boxBoolean(z);
                }
                List<LoadItem> current2 = loadData.getCurrent();
                Fibwatch$loadLinks$currentUrls$1 fibwatch$loadLinks$currentUrls$2 = new Fibwatch$loadLinks$currentUrls$1(null);
                c00022.L$0 = $this2;
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(data);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c00022.L$3 = function2;
                c00022.L$4 = loadData;
                c00022.Z$0 = isCasting;
                c00022.label = 1;
                objAmap = ParCollectionsKt.amap(current2, fibwatch$loadLinks$currentUrls$2, c00022);
                if (objAmap == coroutine_suspended) {
                    return coroutine_suspended;
                }
                loadData2 = loadData;
                isCasting2 = isCasting;
                data2 = data;
                function3 = function1;
                function4 = function2;
                currentUrls = CollectionsKt.toSet((Iterable) objAmap);
                element$iv$iv = new ArrayList(loadData2.getCurrent().size() + loadData2.getPopup().size());
                CollectionsKt.addAll((Collection) element$iv$iv, loadData2.getCurrent());
                ArrayList arrayList2 = (Collection) element$iv$iv;
                Iterable $this$filter$iv2 = loadData2.getPopup();
                destination$iv$iv = new ArrayList();
                while (r18.hasNext()) {
                    Object combined3 = element$iv$iv;
                    it = (LoadItem) element$iv$iv2;
                    Object $result3 = $result;
                    if (!currentUrls.contains(StringsKt.trim(it.getUrl()).toString())) {
                        destination$iv$iv.add(element$iv$iv2);
                    }
                    element$iv$iv = combined3;
                    $result = $result3;
                }
                combined = element$iv$iv;
                CollectionsKt.addAll(arrayList2, (List) destination$iv$iv);
                c00033 = $this2.new C00033(function4, null);
                c00022.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(loadData2);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(currentUrls);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(combined);
                c00022.Z$0 = isCasting2;
                c00022.label = 2;
                if (ParCollectionsKt.amap((List) combined, c00033, c00022) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(true);
            case 1:
                isCasting2 = c00022.Z$0;
                LoadlinksOut loadData3 = (LoadlinksOut) c00022.L$4;
                function4 = (Function1) c00022.L$3;
                function3 = (Function1) c00022.L$2;
                data2 = (String) c00022.L$1;
                $this2 = (Fibwatch) c00022.L$0;
                ResultKt.throwOnFailure($result);
                objAmap = $result;
                loadData2 = loadData3;
                currentUrls = CollectionsKt.toSet((Iterable) objAmap);
                element$iv$iv = new ArrayList(loadData2.getCurrent().size() + loadData2.getPopup().size());
                CollectionsKt.addAll((Collection) element$iv$iv, loadData2.getCurrent());
                ArrayList arrayList3 = (Collection) element$iv$iv;
                Iterable $this$filter$iv3 = loadData2.getPopup();
                destination$iv$iv = new ArrayList();
                while (r18.hasNext()) {
                    Object combined4 = element$iv$iv;
                    it = (LoadItem) element$iv$iv2;
                    Object $result4 = $result;
                    if (!currentUrls.contains(StringsKt.trim(it.getUrl()).toString())) {
                        destination$iv$iv.add(element$iv$iv2);
                    }
                    element$iv$iv = combined4;
                    $result = $result4;
                }
                combined = element$iv$iv;
                CollectionsKt.addAll(arrayList3, (List) destination$iv$iv);
                c00033 = $this2.new C00033(function4, null);
                c00022.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(loadData2);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(currentUrls);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(combined);
                c00022.Z$0 = isCasting2;
                c00022.label = 2;
                if (ParCollectionsKt.amap((List) combined, c00033, c00022) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(true);
            case 2:
                boolean z2 = c00022.Z$0;
                ResultKt.throwOnFailure($result);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Fibwatch.Fibwatch$loadLinks$3 */
    /* JADX INFO: compiled from: Fibwatch.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "item", "Lcom/Fibwatch/LoadItem;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Fibwatch.Fibwatch$loadLinks$3", f = "Fibwatch.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3}, l = {368, 327, 328, 342}, m = "invokeSuspend", n = {"item", "url", "$this$invokeSuspend_u24lambda_u240", "$this$withLock_u24default$iv", "$completion$iv", "isDirectMedia", "item", "url", "$this$invokeSuspend_u24lambda_u240", "$this$withLock_u24default$iv", "$completion$iv", "isDirectMedia", "item", "url", "$this$invokeSuspend_u24lambda_u240", "$this$withLock_u24default$iv", "$completion$iv", "isDirectMedia", "item", "url", "finalUrl", "isDirectMedia"}, nl = {369, 328, 329, 341}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nFibwatch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Fibwatch.kt\ncom/Fibwatch/Fibwatch$loadLinks$3\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,363:1\n117#2,7:364\n125#2,2:372\n1#3:371\n*S KotlinDebug\n*F\n+ 1 Fibwatch.kt\ncom/Fibwatch/Fibwatch$loadLinks$3\n*L\n326#1:364,7\n326#1:372,2\n*E\n"})
    static final class C00033 extends SuspendLambda implements Function2<LoadItem, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        int I$0;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00033(Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00033> continuation) {
            super(2, continuation);
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00033 = Fibwatch.this.new C00033(this.$callback, continuation);
            c00033.L$0 = obj;
            return c00033;
        }

        public final Object invoke(LoadItem loadItem, Continuation<? super Unit> continuation) {
            return create(loadItem, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:100:0x02c0  */
        /* JADX WARN: Code duplicated, block: B:105:0x02ca  */
        /* JADX WARN: Code duplicated, block: B:107:0x02eb  */
        /* JADX WARN: Code duplicated, block: B:109:0x0333 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:110:0x0334  */
        /* JADX WARN: Code duplicated, block: B:47:0x016b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:48:0x016c  */
        /* JADX WARN: Code duplicated, block: B:54:0x01e4 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:55:0x01e5  */
        /* JADX WARN: Code duplicated, block: B:60:0x020d A[Catch: all -> 0x0244, TRY_LEAVE, TryCatch #4 {all -> 0x0244, blocks: (B:58:0x0207, B:60:0x020d), top: B:120:0x0207 }] */
        /* JADX WARN: Code duplicated, block: B:73:0x0235  */
        /* JADX WARN: Code duplicated, block: B:96:0x02b1  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 10, insn: 0x0293: MOVE (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('isDirectMedia' boolean)]), block:B:90:0x0293 */
        /* JADX WARN: Not initialized variable reg: 15, insn: 0x0294: MOVE (r14 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('url' java.lang.String)]), block:B:90:0x0293 */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v65 */
        /* JADX WARN: Type inference failed for: r14v3 */
        /* JADX WARN: Type inference failed for: r20v0 */
        /* JADX WARN: Type inference failed for: r3v19 */
        /* JADX WARN: Type inference failed for: r3v3, types: [com.Fibwatch.Fibwatch$loadLinks$3] */
        /* JADX WARN: Type inference failed for: r3v6 */
        /* JADX WARN: Type inference failed for: r7v17 */
        /* JADX WARN: Type inference failed for: r7v18 */
        /* JADX WARN: Type inference failed for: r7v19 */
        /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Object, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v6 */
        public final Object invokeSuspend(Object obj) {
            int i;
            int i2;
            String str;
            String string;
            boolean z;
            Object obj2;
            Object obj3;
            int i3;
            String str2;
            Mutex mutex;
            Object obj4;
            ?? r7;
            ?? r3;
            String str3;
            Object obj5;
            int i4;
            String str4;
            String str5;
            Function1<ExtractorLink, Unit> function1;
            Object objNewExtractorLink$default;
            ?? r8;
            Object obj6;
            Object obj7;
            Object obj8;
            boolean z2;
            ?? r0;
            int i5;
            int i6;
            boolean z3;
            C00033 c00033;
            String str6;
            Fibwatch fibwatch;
            int i7;
            long duration;
            int i8;
            boolean z4;
            int i9;
            Object obj9;
            C00033 c00034;
            Mutex mutex2;
            Fibwatch fibwatch2;
            String str7;
            int i10;
            Mutex mutex3;
            String str8;
            Object obj10;
            int i11;
            Object obj11;
            Object obj12;
            Object obj13;
            MatchResult matchResultFind$default;
            String str9;
            List groupValues;
            C00033 c00035 = this;
            LoadItem loadItem = (LoadItem) c00035.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean z5 = true;
            try {
                try {
                    switch (c00035.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            string = StringsKt.trim(loadItem.getUrl()).toString();
                            if (string.length() == 0) {
                                return Unit.INSTANCE;
                            }
                            i2 = (StringsKt.contains(string, ".mkv", true) || StringsKt.contains(string, ".mp4", true) || StringsKt.contains(string, ".m3u8", true)) ? 1 : 0;
                            if (i2 != 0) {
                                r3 = c00035;
                                obj5 = coroutine_suspended;
                                loadItem = loadItem;
                                i4 = i2;
                                str3 = string;
                                z = true;
                                r7 = 0;
                            } else {
                                Fibwatch fibwatch3 = Fibwatch.this;
                                try {
                                    Result.Companion companion = Result.Companion;
                                    i5 = 0;
                                    Mutex mutex4 = fibwatch3.loadLinksMutex;
                                    c00035.L$0 = loadItem;
                                    c00035.L$1 = string;
                                    c00035.L$2 = fibwatch3;
                                    c00035.L$3 = mutex4;
                                    c00035.L$4 = SpillingKt.nullOutSpilledVariable(this);
                                    c00035.I$0 = i2;
                                    c00035.label = 1;
                                    if (mutex4.lock((Object) null, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    i6 = i2;
                                    z3 = false;
                                    mutex = mutex4;
                                    c00033 = this;
                                    obj4 = null;
                                    str6 = string;
                                    fibwatch = fibwatch3;
                                    i7 = 0;
                                    try {
                                        Duration.Companion companion2 = Duration.Companion;
                                        duration = DurationKt.toDuration(1500, DurationUnit.MILLISECONDS);
                                        c00035.L$0 = loadItem;
                                        c00035.L$1 = str6;
                                        c00035.L$2 = fibwatch;
                                        c00035.L$3 = mutex;
                                        c00035.L$4 = SpillingKt.nullOutSpilledVariable(c00033);
                                        c00035.I$0 = i6;
                                        c00035.label = 2;
                                        if (DelayKt.delay-VtjQ1oo(duration, c00035) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        i8 = i5;
                                        z4 = z3;
                                        i9 = i6;
                                        obj9 = obj4;
                                        c00034 = c00033;
                                        mutex2 = mutex;
                                        fibwatch2 = fibwatch;
                                        str7 = str6;
                                        try {
                                            Requests app = MainActivityKt.getApp();
                                            String strFixUrl = MainAPIKt.fixUrl(fibwatch2, str7);
                                            Map mapMapOf = MapsKt.mapOf(TuplesKt.to("pop_up_18", "yes"));
                                            c00035.L$0 = loadItem;
                                            c00035.L$1 = str7;
                                            c00035.L$2 = SpillingKt.nullOutSpilledVariable(fibwatch2);
                                            c00035.L$3 = mutex2;
                                            c00035.L$4 = SpillingKt.nullOutSpilledVariable(c00034);
                                            c00035.I$0 = i9;
                                            c00035.label = 3;
                                            i10 = i9;
                                            mutex3 = mutex2;
                                            str8 = str7;
                                            loadItem = loadItem;
                                            obj10 = coroutine_suspended;
                                            i11 = 2;
                                            try {
                                                obj11 = Requests.get$default(app, strFixUrl, (Map) null, (String) null, (Map) null, mapMapOf, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00035, 4078, (Object) null);
                                                obj12 = c00035;
                                                if (obj11 == obj10) {
                                                    return obj10;
                                                }
                                                obj4 = obj9;
                                                str2 = str8;
                                                i3 = i10;
                                                mutex = mutex3;
                                                obj13 = obj10;
                                                try {
                                                    r8 = 0;
                                                    try {
                                                        matchResultFind$default = Regex.find$default(new Regex("var\\s+VIDEO_URL\\s*=\\s*[\"']([^\"']+)[\"']"), ((NiceResponse) obj11).getText(), 0, i11, (Object) null);
                                                        if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
                                                            z = true;
                                                        } else {
                                                            z = true;
                                                            try {
                                                                str9 = (String) groupValues.get(1);
                                                                if (str9 != null) {
                                                                    if (!(str9.length() > 0)) {
                                                                    }
                                                                }
                                                                mutex.unlock(obj4);
                                                                obj8 = Result.constructor-impl(str9);
                                                                obj7 = obj13;
                                                                obj6 = obj12;
                                                                z2 = Result.isFailure-impl(obj8);
                                                                r0 = obj8;
                                                                if (z2) {
                                                                    r0 = r8;
                                                                }
                                                                String str10 = (String) r0;
                                                                i4 = i3;
                                                                str3 = str10;
                                                                string = str2;
                                                                obj5 = obj7;
                                                                r3 = obj6;
                                                                r7 = r8;
                                                            } catch (Throwable th) {
                                                                th = th;
                                                                mutex.unlock(obj4);
                                                                throw th;
                                                            }
                                                        }
                                                        str9 = null;
                                                        mutex.unlock(obj4);
                                                        obj8 = Result.constructor-impl(str9);
                                                        obj7 = obj13;
                                                        obj6 = obj12;
                                                        z2 = Result.isFailure-impl(obj8);
                                                        r0 = obj8;
                                                        if (z2) {
                                                            r0 = r8;
                                                        }
                                                        String str11 = (String) r0;
                                                        i4 = i3;
                                                        str3 = str11;
                                                        string = str2;
                                                        obj5 = obj7;
                                                        r3 = obj6;
                                                        r7 = r8;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                obj4 = obj9;
                                                mutex = mutex3;
                                                mutex.unlock(obj4);
                                                throw th;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            obj4 = obj9;
                                            mutex = mutex2;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        mutex.unlock(obj4);
                                        throw th;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    obj2 = c00035;
                                    obj3 = coroutine_suspended;
                                    z = true;
                                    z5 = false;
                                    Result.Companion companion3 = Result.Companion;
                                    i3 = i2;
                                    str2 = string;
                                    obj8 = Result.constructor-impl(ResultKt.createFailure(th));
                                    obj7 = obj3;
                                    obj6 = obj2;
                                    r8 = z5;
                                }
                            }
                            str4 = str3;
                            str5 = str4;
                            if (str5 != null && str5.length() != 0) {
                                z = false;
                            }
                            if (z) {
                                Log.INSTANCE.w(Fibwatch.this.getName(), "no download url for " + string);
                                return Unit.INSTANCE;
                            }
                            function1 = r3.$callback;
                            LoadItem loadItem2 = loadItem;
                            r3.L$0 = SpillingKt.nullOutSpilledVariable(loadItem2);
                            r3.L$1 = SpillingKt.nullOutSpilledVariable(string);
                            r3.L$2 = SpillingKt.nullOutSpilledVariable(str4);
                            r3.L$3 = function1;
                            r3.L$4 = r7;
                            r3.I$0 = i4;
                            r3.label = 4;
                            objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default(Fibwatch.this.getMainUrl(), Fibwatch.this.getName(), str4, (ExtractorLinkType) null, new AnonymousClass1(loadItem2, Fibwatch.this, r7), (Continuation) r3, 8, (Object) null);
                            if (objNewExtractorLink$default == obj5) {
                                return obj5;
                            }
                            function1.invoke(objNewExtractorLink$default);
                            return Unit.INSTANCE;
                        case 1:
                            i2 = c00035.I$0;
                            C00033 c00036 = (C00033) c00035.L$4;
                            Mutex mutex5 = (Mutex) c00035.L$3;
                            Fibwatch fibwatch4 = (Fibwatch) c00035.L$2;
                            string = (String) c00035.L$1;
                            try {
                                ResultKt.throwOnFailure(obj);
                                str6 = string;
                                fibwatch = fibwatch4;
                                mutex = mutex5;
                                c00033 = c00036;
                                obj4 = null;
                                i6 = i2;
                                z3 = false;
                                i5 = 0;
                                i7 = 0;
                                Duration.Companion companion4 = Duration.Companion;
                                duration = DurationKt.toDuration(1500, DurationUnit.MILLISECONDS);
                                c00035.L$0 = loadItem;
                                c00035.L$1 = str6;
                                c00035.L$2 = fibwatch;
                                c00035.L$3 = mutex;
                                c00035.L$4 = SpillingKt.nullOutSpilledVariable(c00033);
                                c00035.I$0 = i6;
                                c00035.label = 2;
                                if (DelayKt.delay-VtjQ1oo(duration, c00035) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                i8 = i5;
                                z4 = z3;
                                i9 = i6;
                                obj9 = obj4;
                                c00034 = c00033;
                                mutex2 = mutex;
                                fibwatch2 = fibwatch;
                                str7 = str6;
                                Requests app2 = MainActivityKt.getApp();
                                String strFixUrl2 = MainAPIKt.fixUrl(fibwatch2, str7);
                                Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to("pop_up_18", "yes"));
                                c00035.L$0 = loadItem;
                                c00035.L$1 = str7;
                                c00035.L$2 = SpillingKt.nullOutSpilledVariable(fibwatch2);
                                c00035.L$3 = mutex2;
                                c00035.L$4 = SpillingKt.nullOutSpilledVariable(c00034);
                                c00035.I$0 = i9;
                                c00035.label = 3;
                                i10 = i9;
                                mutex3 = mutex2;
                                str8 = str7;
                                loadItem = loadItem;
                                obj10 = coroutine_suspended;
                                i11 = 2;
                                obj11 = Requests.get$default(app2, strFixUrl2, (Map) null, (String) null, (Map) null, mapMapOf2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00035, 4078, (Object) null);
                                obj12 = c00035;
                                if (obj11 == obj10) {
                                    return obj10;
                                }
                                obj4 = obj9;
                                str2 = str8;
                                i3 = i10;
                                mutex = mutex3;
                                obj13 = obj10;
                                r8 = 0;
                                matchResultFind$default = Regex.find$default(new Regex("var\\s+VIDEO_URL\\s*=\\s*[\"']([^\"']+)[\"']"), ((NiceResponse) obj11).getText(), 0, i11, (Object) null);
                                if (matchResultFind$default != null) {
                                    z = true;
                                    str9 = null;
                                } else {
                                    z = true;
                                    str9 = null;
                                }
                                mutex.unlock(obj4);
                                obj8 = Result.constructor-impl(str9);
                                obj7 = obj13;
                                obj6 = obj12;
                                z2 = Result.isFailure-impl(obj8);
                                r0 = obj8;
                                if (z2) {
                                    r0 = r8;
                                }
                                String str12 = (String) r0;
                                i4 = i3;
                                str3 = str12;
                                string = str2;
                                obj5 = obj7;
                                r3 = obj6;
                                r7 = r8;
                                str4 = str3;
                                str5 = str4;
                                if (str5 != null) {
                                    z = false;
                                }
                                if (z) {
                                    Log.INSTANCE.w(Fibwatch.this.getName(), "no download url for " + string);
                                    return Unit.INSTANCE;
                                }
                                function1 = r3.$callback;
                                LoadItem loadItem3 = loadItem;
                                r3.L$0 = SpillingKt.nullOutSpilledVariable(loadItem3);
                                r3.L$1 = SpillingKt.nullOutSpilledVariable(string);
                                r3.L$2 = SpillingKt.nullOutSpilledVariable(str4);
                                r3.L$3 = function1;
                                r3.L$4 = r7;
                                r3.I$0 = i4;
                                r3.label = 4;
                                objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default(Fibwatch.this.getMainUrl(), Fibwatch.this.getName(), str4, (ExtractorLinkType) null, new AnonymousClass1(loadItem3, Fibwatch.this, r7), (Continuation) r3, 8, (Object) null);
                                if (objNewExtractorLink$default == obj5) {
                                    return obj5;
                                }
                                function1.invoke(objNewExtractorLink$default);
                                return Unit.INSTANCE;
                            } catch (Throwable th8) {
                                th = th8;
                                obj2 = c00035;
                                obj3 = coroutine_suspended;
                                z = true;
                                z5 = false;
                                Result.Companion companion5 = Result.Companion;
                                i3 = i2;
                                str2 = string;
                                obj8 = Result.constructor-impl(ResultKt.createFailure(th));
                                obj7 = obj3;
                                obj6 = obj2;
                                r8 = z5;
                            }
                            break;
                        case 2:
                            i7 = 0;
                            int i12 = c00035.I$0;
                            C00033 c00037 = (C00033) c00035.L$4;
                            Mutex mutex6 = (Mutex) c00035.L$3;
                            Fibwatch fibwatch5 = (Fibwatch) c00035.L$2;
                            String str13 = (String) c00035.L$1;
                            ResultKt.throwOnFailure(obj);
                            i8 = 0;
                            z4 = false;
                            i9 = i12;
                            obj9 = null;
                            c00034 = c00037;
                            mutex2 = mutex6;
                            fibwatch2 = fibwatch5;
                            str7 = str13;
                            Requests app3 = MainActivityKt.getApp();
                            String strFixUrl3 = MainAPIKt.fixUrl(fibwatch2, str7);
                            Map mapMapOf3 = MapsKt.mapOf(TuplesKt.to("pop_up_18", "yes"));
                            c00035.L$0 = loadItem;
                            c00035.L$1 = str7;
                            c00035.L$2 = SpillingKt.nullOutSpilledVariable(fibwatch2);
                            c00035.L$3 = mutex2;
                            c00035.L$4 = SpillingKt.nullOutSpilledVariable(c00034);
                            c00035.I$0 = i9;
                            c00035.label = 3;
                            i10 = i9;
                            mutex3 = mutex2;
                            str8 = str7;
                            loadItem = loadItem;
                            obj10 = coroutine_suspended;
                            i11 = 2;
                            obj11 = Requests.get$default(app3, strFixUrl3, (Map) null, (String) null, (Map) null, mapMapOf3, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00035, 4078, (Object) null);
                            obj12 = c00035;
                            if (obj11 == obj10) {
                                return obj10;
                            }
                            obj4 = obj9;
                            str2 = str8;
                            i3 = i10;
                            mutex = mutex3;
                            obj13 = obj10;
                            r8 = 0;
                            matchResultFind$default = Regex.find$default(new Regex("var\\s+VIDEO_URL\\s*=\\s*[\"']([^\"']+)[\"']"), ((NiceResponse) obj11).getText(), 0, i11, (Object) null);
                            if (matchResultFind$default != null) {
                                z = true;
                                str9 = null;
                            } else {
                                z = true;
                                str9 = null;
                            }
                            mutex.unlock(obj4);
                            obj8 = Result.constructor-impl(str9);
                            obj7 = obj13;
                            obj6 = obj12;
                            z2 = Result.isFailure-impl(obj8);
                            r0 = obj8;
                            if (z2) {
                                r0 = r8;
                            }
                            String str14 = (String) r0;
                            i4 = i3;
                            str3 = str14;
                            string = str2;
                            obj5 = obj7;
                            r3 = obj6;
                            r7 = r8;
                            str4 = str3;
                            str5 = str4;
                            if (str5 != null) {
                                z = false;
                            }
                            if (z) {
                                Log.INSTANCE.w(Fibwatch.this.getName(), "no download url for " + string);
                                return Unit.INSTANCE;
                            }
                            function1 = r3.$callback;
                            LoadItem loadItem4 = loadItem;
                            r3.L$0 = SpillingKt.nullOutSpilledVariable(loadItem4);
                            r3.L$1 = SpillingKt.nullOutSpilledVariable(string);
                            r3.L$2 = SpillingKt.nullOutSpilledVariable(str4);
                            r3.L$3 = function1;
                            r3.L$4 = r7;
                            r3.I$0 = i4;
                            r3.label = 4;
                            objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default(Fibwatch.this.getMainUrl(), Fibwatch.this.getName(), str4, (ExtractorLinkType) null, new AnonymousClass1(loadItem4, Fibwatch.this, r7), (Continuation) r3, 8, (Object) null);
                            if (objNewExtractorLink$default == obj5) {
                                return obj5;
                            }
                            function1.invoke(objNewExtractorLink$default);
                            return Unit.INSTANCE;
                        case 3:
                            i3 = c00035.I$0;
                            obj4 = null;
                            mutex = (Mutex) c00035.L$3;
                            str2 = (String) c00035.L$1;
                            ResultKt.throwOnFailure(obj);
                            obj12 = c00035;
                            obj13 = coroutine_suspended;
                            loadItem = loadItem;
                            i11 = 2;
                            obj11 = obj;
                            r8 = 0;
                            matchResultFind$default = Regex.find$default(new Regex("var\\s+VIDEO_URL\\s*=\\s*[\"']([^\"']+)[\"']"), ((NiceResponse) obj11).getText(), 0, i11, (Object) null);
                            if (matchResultFind$default != null) {
                                z = true;
                                str9 = null;
                            } else {
                                z = true;
                                str9 = null;
                            }
                            mutex.unlock(obj4);
                            obj8 = Result.constructor-impl(str9);
                            obj7 = obj13;
                            obj6 = obj12;
                            z2 = Result.isFailure-impl(obj8);
                            r0 = obj8;
                            if (z2) {
                                r0 = r8;
                            }
                            String str15 = (String) r0;
                            i4 = i3;
                            str3 = str15;
                            string = str2;
                            obj5 = obj7;
                            r3 = obj6;
                            r7 = r8;
                            str4 = str3;
                            str5 = str4;
                            if (str5 != null) {
                                z = false;
                            }
                            if (z) {
                                Log.INSTANCE.w(Fibwatch.this.getName(), "no download url for " + string);
                                return Unit.INSTANCE;
                            }
                            function1 = r3.$callback;
                            LoadItem loadItem5 = loadItem;
                            r3.L$0 = SpillingKt.nullOutSpilledVariable(loadItem5);
                            r3.L$1 = SpillingKt.nullOutSpilledVariable(string);
                            r3.L$2 = SpillingKt.nullOutSpilledVariable(str4);
                            r3.L$3 = function1;
                            r3.L$4 = r7;
                            r3.I$0 = i4;
                            r3.label = 4;
                            objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default(Fibwatch.this.getMainUrl(), Fibwatch.this.getName(), str4, (ExtractorLinkType) null, new AnonymousClass1(loadItem5, Fibwatch.this, r7), (Continuation) r3, 8, (Object) null);
                            if (objNewExtractorLink$default == obj5) {
                                return obj5;
                            }
                            function1.invoke(objNewExtractorLink$default);
                            return Unit.INSTANCE;
                        case 4:
                            int i13 = c00035.I$0;
                            Function1<ExtractorLink, Unit> function2 = (Function1) c00035.L$3;
                            ResultKt.throwOnFailure(obj);
                            function1 = function2;
                            objNewExtractorLink$default = obj;
                            function1.invoke(objNewExtractorLink$default);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Throwable th9) {
                    th = th9;
                    i2 = i;
                    string = str;
                    obj3 = c00035;
                    obj2 = coroutine_suspended;
                }
            } catch (Throwable th10) {
                th = th10;
            }
        }

        /* JADX INFO: renamed from: com.Fibwatch.Fibwatch$loadLinks$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: Fibwatch.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.Fibwatch.Fibwatch$loadLinks$3$1", f = "Fibwatch.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ LoadItem $item;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ Fibwatch this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(LoadItem loadItem, Fibwatch fibwatch, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$item = loadItem;
                this.this$0 = fibwatch;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$item, this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
                return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$item.getQuality()));
                        $this$newExtractorLink.setReferer(this.this$0.getMainUrl());
                        $this$newExtractorLink.setHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this.this$0.getMainUrl())));
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }
}
