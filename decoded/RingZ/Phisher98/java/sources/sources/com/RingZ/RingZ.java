package com.RingZ;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.DubStatus;
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
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
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
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KType;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RingZ.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/RingZ/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 @2\u00020\u0001:\u0002@AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0082@¢\u0006\u0002\u0010 J \u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\"0\u001cH\u0082@¢\u0006\u0002\u0010 J\u001e\u0010$\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0096@¢\u0006\u0002\u0010+J\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u001c2\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010/J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010/JF\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u000e2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000209072\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020907H\u0096@¢\u0006\u0002\u0010<J$\u0010=\u001a\u00020(2\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00052\b\u0010?\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006B"}, d2 = {"Lcom/RingZ/RingZ;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "defaultMainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getRemoteConfig", "Lcom/RingZ/RingZ$RemoteConfig;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchMainPageFromApi", "Lkotlin/Pair;", "mainPage", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inferQuality", "key", "value", "Companion", "RemoteConfig", "RingZ"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRingZ.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RingZ.kt\ncom/RingZ/RingZ\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 7 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,630:1\n37#2,2:631\n1#3:633\n1#3:637\n93#4,2:634\n63#4:636\n64#4,15:638\n95#4,2:655\n50#5:653\n43#5:654\n1739#6:657\n1814#6,3:658\n1739#6:661\n1814#6,3:662\n296#6,2:665\n1739#6:667\n1814#6,3:668\n296#6,2:671\n1960#6,3:673\n1221#6:683\n1739#6:684\n1814#6,3:685\n460#7,7:676\n*S KotlinDebug\n*F\n+ 1 RingZ.kt\ncom/RingZ/RingZ\n*L\n61#1:631,2\n354#1:637\n354#1:634,2\n354#1:636\n354#1:638,15\n354#1:655,2\n354#1:653\n354#1:654\n358#1:657\n358#1:658,3\n415#1:661\n415#1:662,3\n416#1:665,2\n439#1:667\n439#1:668,3\n440#1:671,2\n566#1:673,3\n399#1:683\n400#1:684\n400#1:685,3\n384#1:676,7\n*E\n"})
public final class RingZ extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Map<String, String> headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("cf-access-client-id", MainAPIKt.base64Decode("ZTNhMTVhZDk5OWRhYjdmMzU5MmYzZDg1NWUwZWM2ZWQuYWNjZXNz")), TuplesKt.to("cf-access-client-secret", MainAPIKt.base64Decode("OGEyMjUzNmUyZGFjODYzNjlhMmNhYTkxMWQ1NWE4OWExMDk5MzljYzY5ZTY2NDZlNTFiZjVkODUyN2ExZGNhNQ0K")), TuplesKt.to("user-agent", "Dart/3.8 (dart:io)")});

    @NotNull
    private String mainUrl = MainAPIKt.base64Decode("aHR0cHM6Ly9kYXRhYXBpLnlvbW92aWVzYXBrLmNvbS8=");

    @NotNull
    private String name = "RingZ";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Anime, TvType.Cartoon});

    @NotNull
    private final List<MainPageData> mainPage = (List) BuildersKt.runBlockingK$default((CoroutineContext) null, new RingZ$mainPage$1(this, null), 1, (Object) null);

    /* JADX INFO: compiled from: RingZ.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TvType.values().length];
            try {
                iArr[TvType.TvSeries.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[TvType.Anime.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.RingZ.RingZ$fetchMainPageFromApi$1 */
    /* JADX INFO: compiled from: RingZ.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.RingZ.RingZ", f = "RingZ.kt", i = {}, l = {113}, m = "fetchMainPageFromApi", n = {}, nl = {115}, s = {}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RingZ.this.fetchMainPageFromApi((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.RingZ.RingZ$getMainPage$1 */
    /* JADX INFO: compiled from: RingZ.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.RingZ.RingZ", f = "RingZ.kt", i = {0, 0, 0}, l = {148}, m = "getMainPage", n = {"request", "url", "page"}, nl = {149}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RingZ.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.RingZ.RingZ$getRemoteConfig$1 */
    /* JADX INFO: compiled from: RingZ.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.RingZ.RingZ", f = "RingZ.kt", i = {}, l = {75}, m = "getRemoteConfig", n = {}, nl = {79}, s = {}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RingZ.this.getRemoteConfig((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.RingZ.RingZ$load$1 */
    /* JADX INFO: compiled from: RingZ.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.RingZ.RingZ", f = "RingZ.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {412, 421, 426, 436, 458, 468}, m = "load", n = {"url", "res", "title", "href", "poster", "genre", "tvTag", "fullUrl", "url", "res", "title", "href", "poster", "genre", "tvTag", "fullUrl", "seriesResText", "webSeriesList", "seriesObj", "allEpisodes", "url", "res", "title", "href", "poster", "genre", "tvTag", "fullUrl", "seriesResText", "webSeriesList", "seriesObj", "allEpisodes", "url", "res", "title", "href", "poster", "genre", "tvTag", "fullUrl", "url", "res", "title", "href", "poster", "genre", "tvTag", "fullUrl", "movieResText", "allMovieDataList", "movie", "linksArray", "keysIter", "url", "res", "title", "href", "poster", "genre", "tvTag", "fullUrl", "movieResText", "allMovieDataList", "movie"}, nl = {413, 426, 435, 437, 468, 409}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
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

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RingZ.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.RingZ.RingZ$loadLinks$1 */
    /* JADX INFO: compiled from: RingZ.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.RingZ.RingZ", f = "RingZ.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {577}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "urlsArray", "item", "urlStr", "keyName", "valueStr", "serverName", "finalUrl", "isCasting", "i", "quality", "needsAppParam"}, nl = {576}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0", "I$0", "I$2", "I$3"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
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

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RingZ.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.RingZ.RingZ$search$1 */
    /* JADX INFO: compiled from: RingZ.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.RingZ.RingZ", f = "RingZ.kt", i = {0, 1, 1, 1, 1, 1}, l = {268, 331}, m = "search", n = {"query", "query", "urls", "results", "url", "type"}, nl = {269, 332}, s = {"L$0", "L$0", "L$1", "L$2", "L$4", "L$5"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RingZ.this.search(null, (Continuation) this);
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

    /* JADX INFO: compiled from: RingZ.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/RingZ/RingZ$Companion;", "", "<init>", "()V", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "RingZ"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Map<String, String> getHeaders() {
            return RingZ.headers;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MainPageData> defaultMainPage() {
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to(getMainUrl() + "/Nwm.json", "Movies");
        pairArr[1] = TuplesKt.to(getMainUrl() + "/Nws.json", "Web Series");
        pairArr[2] = TuplesKt.to(getMainUrl() + "/lstanime.json", "Anime");
        pairArr[3] = MainAPI.Companion.getSettingsForProvider().getEnableAdult() ? TuplesKt.to(getMainUrl() + "/desihub.json", "Adult (18+)") : null;
        Collection $this$toTypedArray$iv = CollectionsKt.listOfNotNull(pairArr);
        Pair[] pairArr2 = (Pair[]) $this$toTypedArray$iv.toArray(new Pair[0]);
        return MainAPIKt.mainPageOf((Pair[]) Arrays.copyOf(pairArr2, pairArr2.length));
    }

    /* JADX INFO: compiled from: RingZ.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/RingZ/RingZ$RemoteConfig;", "", "link1", "", "link2", "latest", "webseries", "anime", "desihub", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLink1", "()Ljava/lang/String;", "getLink2", "getLatest", "getWebseries", "getAnime", "getDesihub", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "RingZ"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class RemoteConfig {

        @Nullable
        private final String anime;

        @Nullable
        private final String desihub;

        @Nullable
        private final String latest;

        @Nullable
        private final String link1;

        @Nullable
        private final String link2;

        @Nullable
        private final String webseries;

        public static /* synthetic */ RemoteConfig copy$default(RemoteConfig remoteConfig, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = remoteConfig.link1;
            }
            if ((i & 2) != 0) {
                str2 = remoteConfig.link2;
            }
            if ((i & 4) != 0) {
                str3 = remoteConfig.latest;
            }
            if ((i & 8) != 0) {
                str4 = remoteConfig.webseries;
            }
            if ((i & 16) != 0) {
                str5 = remoteConfig.anime;
            }
            if ((i & 32) != 0) {
                str6 = remoteConfig.desihub;
            }
            String str7 = str5;
            String str8 = str6;
            return remoteConfig.copy(str, str2, str3, str4, str7, str8);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLink1() {
            return this.link1;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLink2() {
            return this.link2;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLatest() {
            return this.latest;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getWebseries() {
            return this.webseries;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getAnime() {
            return this.anime;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getDesihub() {
            return this.desihub;
        }

        @NotNull
        public final RemoteConfig copy(@Nullable String link1, @Nullable String link2, @Nullable String latest, @Nullable String webseries, @Nullable String anime, @Nullable String desihub) {
            return new RemoteConfig(link1, link2, latest, webseries, anime, desihub);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RemoteConfig)) {
                return false;
            }
            RemoteConfig remoteConfig = (RemoteConfig) other;
            return Intrinsics.areEqual(this.link1, remoteConfig.link1) && Intrinsics.areEqual(this.link2, remoteConfig.link2) && Intrinsics.areEqual(this.latest, remoteConfig.latest) && Intrinsics.areEqual(this.webseries, remoteConfig.webseries) && Intrinsics.areEqual(this.anime, remoteConfig.anime) && Intrinsics.areEqual(this.desihub, remoteConfig.desihub);
        }

        public int hashCode() {
            return ((((((((((this.link1 == null ? 0 : this.link1.hashCode()) * 31) + (this.link2 == null ? 0 : this.link2.hashCode())) * 31) + (this.latest == null ? 0 : this.latest.hashCode())) * 31) + (this.webseries == null ? 0 : this.webseries.hashCode())) * 31) + (this.anime == null ? 0 : this.anime.hashCode())) * 31) + (this.desihub != null ? this.desihub.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "RemoteConfig(link1=" + this.link1 + ", link2=" + this.link2 + ", latest=" + this.latest + ", webseries=" + this.webseries + ", anime=" + this.anime + ", desihub=" + this.desihub + ')';
        }

        public RemoteConfig(@Nullable String link1, @Nullable String link2, @Nullable String latest, @Nullable String webseries, @Nullable String anime, @Nullable String desihub) {
            this.link1 = link1;
            this.link2 = link2;
            this.latest = latest;
            this.webseries = webseries;
            this.anime = anime;
            this.desihub = desihub;
        }

        @Nullable
        public final String getLink1() {
            return this.link1;
        }

        @Nullable
        public final String getLink2() {
            return this.link2;
        }

        @Nullable
        public final String getLatest() {
            return this.latest;
        }

        @Nullable
        public final String getWebseries() {
            return this.webseries;
        }

        @Nullable
        public final String getAnime() {
            return this.anime;
        }

        @Nullable
        public final String getDesihub() {
            return this.desihub;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:24:0x00ce A[Catch: Exception -> 0x0194, TryCatch #1 {Exception -> 0x0194, blocks: (B:22:0x00b8, B:24:0x00ce, B:26:0x00e0, B:28:0x00e8, B:29:0x00ee, B:31:0x00f3, B:33:0x00f9, B:36:0x0107, B:40:0x011e, B:44:0x0134, B:48:0x014a, B:52:0x0160, B:56:0x0176, B:60:0x018c, B:19:0x00b1), top: B:70:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0106 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0107 A[Catch: Exception -> 0x0194, TryCatch #1 {Exception -> 0x0194, blocks: (B:22:0x00b8, B:24:0x00ce, B:26:0x00e0, B:28:0x00e8, B:29:0x00ee, B:31:0x00f3, B:33:0x00f9, B:36:0x0107, B:40:0x011e, B:44:0x0134, B:48:0x014a, B:52:0x0160, B:56:0x0176, B:60:0x018c, B:19:0x00b1), top: B:70:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0119  */
    /* JADX WARN: Code duplicated, block: B:39:0x011c  */
    /* JADX WARN: Code duplicated, block: B:42:0x012f  */
    /* JADX WARN: Code duplicated, block: B:43:0x0132  */
    /* JADX WARN: Code duplicated, block: B:46:0x0145  */
    /* JADX WARN: Code duplicated, block: B:47:0x0148  */
    /* JADX WARN: Code duplicated, block: B:50:0x015b  */
    /* JADX WARN: Code duplicated, block: B:51:0x015e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0171  */
    /* JADX WARN: Code duplicated, block: B:55:0x0174  */
    /* JADX WARN: Code duplicated, block: B:58:0x0187  */
    /* JADX WARN: Code duplicated, block: B:59:0x018a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object getRemoteConfig(Continuation<? super RemoteConfig> continuation) {
        C00021 c00021;
        RingZ ringZ;
        JSONArray jsonArray;
        JSONObject selected;
        int i;
        int length;
        String it;
        String str;
        String it2;
        String str2;
        String it3;
        String str3;
        String it4;
        String str4;
        String it5;
        String str5;
        String it6;
        String str6;
        Long idNum;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
                ringZ = this;
            } else {
                ringZ = this;
                c00021 = ringZ.new C00021(continuation);
            }
        } else {
            ringZ = this;
            c00021 = ringZ.new C00021(continuation);
        }
        C00021 c00022 = c00021;
        Object $result = c00022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00022.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    Requests app = MainActivityKt.getApp();
                    String strBase64Decode = MainAPIKt.base64Decode("aHR0cHM6Ly9tYWluYXBpLnlvbW92aWVzYXBrLmNvbS9y");
                    Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("cf-access-client-id", MainAPIKt.base64Decode("DQo4YjY2ZTdiMTFiYjZhODUxY2U4Njk4YzdkZDVmYTE3Yi5hY2Nlc3M=")), TuplesKt.to("cf-access-client-secret", MainAPIKt.base64Decode("DQoxMDgwOGRkNTZkZWQyNmY4NTU4MjhlZWM5ZjA0ZGE5M2Y1OGJjZDgzNGVjYWM2MThmOWQ1YmM4N2U2MmJjYzMyDQo=")), TuplesKt.to("user-agent", "Dart/3.8 (dart:io)")});
                    c00022.label = 1;
                    try {
                        $result = Requests.get$default(app, strBase64Decode, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        String responseText = ((NiceResponse) $result).getText();
                        jsonArray = new JSONArray(responseText);
                        selected = null;
                        long highestId = Long.MIN_VALUE;
                        length = jsonArray.length();
                        for (i = 0; i < length; i++) {
                            JSONObject obj = jsonArray.getJSONObject(i);
                            idNum = StringsKt.toLongOrNull(obj.optString("id", ""));
                            if (idNum == null && idNum.longValue() > highestId) {
                                long highestId2 = idNum.longValue();
                                selected = obj;
                                highestId = highestId2;
                            }
                        }
                        if (selected == null && jsonArray.length() > 0) {
                            selected = jsonArray.getJSONObject(jsonArray.length() - 1);
                        }
                        if (selected == null) {
                            return null;
                        }
                        it = selected.optString("link1");
                        if (StringsKt.isBlank(it)) {
                            str = null;
                        } else {
                            str = it;
                        }
                        it2 = selected.optString("link2");
                        if (StringsKt.isBlank(it2)) {
                            str2 = null;
                        } else {
                            str2 = it2;
                        }
                        it3 = selected.optString("latest");
                        if (StringsKt.isBlank(it3)) {
                            str3 = null;
                        } else {
                            str3 = it3;
                        }
                        it4 = selected.optString("webseries");
                        if (StringsKt.isBlank(it4)) {
                            str4 = null;
                        } else {
                            str4 = it4;
                        }
                        it5 = selected.optString("anime");
                        if (StringsKt.isBlank(it5)) {
                            str5 = null;
                        } else {
                            str5 = it5;
                        }
                        it6 = selected.optString("desihub");
                        if (StringsKt.isBlank(it6)) {
                            str6 = null;
                        } else {
                            str6 = it6;
                        }
                        return new RemoteConfig(str, str2, str3, str4, str5, str6);
                    } catch (Exception e) {
                        e = e;
                        Log.INSTANCE.e(ringZ.getName(), "Failed to fetch remote config: " + e.getMessage());
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    Log.INSTANCE.e(ringZ.getName(), "Failed to fetch remote config: " + e.getMessage());
                    return null;
                }
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                    String responseText2 = ((NiceResponse) $result).getText();
                    jsonArray = new JSONArray(responseText2);
                    selected = null;
                    long highestId3 = Long.MIN_VALUE;
                    length = jsonArray.length();
                    while (i < length) {
                        JSONObject obj2 = jsonArray.getJSONObject(i);
                        idNum = StringsKt.toLongOrNull(obj2.optString("id", ""));
                        if (idNum == null) {
                        }
                    }
                    if (selected == null) {
                        selected = jsonArray.getJSONObject(jsonArray.length() - 1);
                    }
                    if (selected == null) {
                        return null;
                    }
                    it = selected.optString("link1");
                    if (StringsKt.isBlank(it)) {
                        str = it;
                    } else {
                        str = null;
                    }
                    it2 = selected.optString("link2");
                    if (StringsKt.isBlank(it2)) {
                        str2 = it2;
                    } else {
                        str2 = null;
                    }
                    it3 = selected.optString("latest");
                    if (StringsKt.isBlank(it3)) {
                        str3 = it3;
                    } else {
                        str3 = null;
                    }
                    it4 = selected.optString("webseries");
                    if (StringsKt.isBlank(it4)) {
                        str4 = it4;
                    } else {
                        str4 = null;
                    }
                    it5 = selected.optString("anime");
                    if (StringsKt.isBlank(it5)) {
                        str5 = it5;
                    } else {
                        str5 = null;
                    }
                    it6 = selected.optString("desihub");
                    if (StringsKt.isBlank(it6)) {
                        str6 = it6;
                    } else {
                        str6 = null;
                    }
                    return new RemoteConfig(str, str2, str3, str4, str5, str6);
                } catch (Exception e3) {
                    e = e3;
                    Log.INSTANCE.e(ringZ.getName(), "Failed to fetch remote config: " + e.getMessage());
                    return null;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchMainPageFromApi(Continuation<? super List<Pair<String, String>>> continuation) {
        C00001 c00001;
        Object remoteConfig;
        String it;
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
                c00001.label = 1;
                remoteConfig = getRemoteConfig(c00001);
                if (remoteConfig == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                remoteConfig = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        RemoteConfig config = (RemoteConfig) remoteConfig;
        if (config == null) {
            return CollectionsKt.emptyList();
        }
        String host = config.getLink1();
        if (host == null && (host = config.getLink2()) == null) {
            return CollectionsKt.emptyList();
        }
        String baseUrl = StringsKt.startsWith$default(host, "http", false, 2, (Object) null) ? host : "https://" + host;
        List $this$fetchMainPageFromApi_u24lambda_u240 = CollectionsKt.createListBuilder();
        String it2 = config.getLatest();
        if (it2 != null) {
            Boxing.boxBoolean($this$fetchMainPageFromApi_u24lambda_u240.add(TuplesKt.to(baseUrl + it2, "Movies")));
        }
        String it3 = config.getWebseries();
        if (it3 != null) {
            Boxing.boxBoolean($this$fetchMainPageFromApi_u24lambda_u240.add(TuplesKt.to(baseUrl + it3, "Web Series")));
        }
        String it4 = config.getAnime();
        if (it4 != null) {
            Boxing.boxBoolean($this$fetchMainPageFromApi_u24lambda_u240.add(TuplesKt.to(baseUrl + it4, "Anime")));
        }
        if (MainAPI.Companion.getSettingsForProvider().getEnableAdult() && (it = config.getDesihub()) != null) {
            $this$fetchMainPageFromApi_u24lambda_u240.add(TuplesKt.to(baseUrl + it, "Adult (18+)"));
        }
        return CollectionsKt.build($this$fetchMainPageFromApi_u24lambda_u240);
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws JSONException {
        C00011 c00011;
        RingZ ringZ;
        String url;
        boolean z;
        Object obj;
        MainPageRequest request2;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
                ringZ = this;
            } else {
                ringZ = this;
                c00011 = ringZ.new C00011(continuation);
            }
        } else {
            ringZ = this;
            c00011 = ringZ.new C00011(continuation);
        }
        Object $result = c00011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00011.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                url = request.getData();
                Requests app = MainActivityKt.getApp();
                Map<String, String> map = headers;
                c00011.L$0 = request;
                c00011.L$1 = url;
                c00011.I$0 = page;
                c00011.label = 1;
                z = true;
                obj = Requests.get$default(app, url, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00011, 4092, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
            case 1:
                int i = c00011.I$0;
                url = (String) c00011.L$1;
                MainPageRequest request3 = (MainPageRequest) c00011.L$0;
                ResultKt.throwOnFailure($result);
                request2 = request3;
                z = true;
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String responseString = ((NiceResponse) obj).getText();
        JSONObject json = new JSONObject(responseString);
        if (StringsKt.contains(request2.getName(), "Movies", z)) {
            JSONArray allMovies = getMainPage$getJsonArray(json, "AllMovieDataList", "allMovieDataList");
            List searchResponses = getMainPage$toSearchResponses$default(allMovies, ringZ, url, "Movies", TvType.Movie, null, 16, null);
            return MainAPIKt.newHomePageResponse(CollectionsKt.listOf(new HomePageList(APIHolder.INSTANCE.capitalize(request2.getName()), searchResponses, z)), Boxing.boxBoolean(false));
        }
        String url2 = url;
        if (StringsKt.contains(request2.getName(), "Anime", z)) {
            JSONArray animeList = getMainPage$getJsonArray(json, "webSeriesDataList");
            return MainAPIKt.newHomePageResponse(CollectionsKt.listOf(new HomePageList(APIHolder.INSTANCE.capitalize(request2.getName()), getMainPage$toSearchResponses(animeList, this, url2, "Anime", TvType.Anime, "Anime"), z)), Boxing.boxBoolean(false));
        }
        if (StringsKt.contains(request2.getName(), "Adult", z) || StringsKt.contains(request2.getName(), "Web Series", z)) {
            JSONArray webSeriesList = getMainPage$getJsonArray(json, "webSeriesDataList");
            List searchResponses2 = getMainPage$toSearchResponses$default(webSeriesList, this, url2, "Series", TvType.TvSeries, null, 16, null);
            return MainAPIKt.newHomePageResponse(CollectionsKt.listOf(new HomePageList(APIHolder.INSTANCE.capitalize(request2.getName()), searchResponses2, z)), Boxing.boxBoolean(false));
        }
        JSONArray allMovies2 = getMainPage$getJsonArray(json, "AllMovieDataList", "allMovieDataList");
        List searchResponses3 = getMainPage$toSearchResponses$default(allMovies2, this, url2, "Movies", TvType.Movie, null, 16, null);
        return MainAPIKt.newHomePageResponse(CollectionsKt.listOf(new HomePageList(APIHolder.INSTANCE.capitalize(request2.getName()), searchResponses3, z)), Boxing.boxBoolean(false));
    }

    private static final JSONArray getMainPage$getJsonArray(JSONObject json, String... keys) {
        for (String key : keys) {
            JSONArray it = json.optJSONArray(key);
            if (it != null) {
                return it;
            }
        }
        return new JSONArray();
    }

    private static final LoadURL getMainPage$toLoadURL(JSONObject $this$getMainPage_u24toLoadURL, String url, String type) {
        String strOptString = $this$getMainPage_u24toLoadURL.optString("l", url);
        String strOptString2 = $this$getMainPage_u24toLoadURL.optString("mn");
        String strOptString3 = $this$getMainPage_u24toLoadURL.optString("id");
        String strOptString4 = $this$getMainPage_u24toLoadURL.optString("IH");
        String it = $this$getMainPage_u24toLoadURL.optString("trailer");
        String str = !Intrinsics.areEqual(it, "FALSE") ? it : null;
        String it2 = $this$getMainPage_u24toLoadURL.optString("qlty");
        return new LoadURL(strOptString, strOptString2, strOptString3, strOptString4, str, it2.length() > 0 ? it2 : null, $this$getMainPage_u24toLoadURL.optString("lng"), type, $this$getMainPage_u24toLoadURL.optString("cg"), $this$getMainPage_u24toLoadURL.optString("gn"), $this$getMainPage_u24toLoadURL.toString());
    }

    static /* synthetic */ List getMainPage$toSearchResponses$default(JSONArray jSONArray, RingZ ringZ, String str, String str2, TvType tvType, String str3, int i, Object obj) {
        String str4;
        if ((i & 16) == 0) {
            str4 = str3;
        } else {
            str4 = null;
        }
        return getMainPage$toSearchResponses(jSONArray, ringZ, str, str2, tvType, str4);
    }

    private static final List<MovieSearchResponse> getMainPage$toSearchResponses(JSONArray $this$getMainPage_u24toSearchResponses, RingZ this$0, String url, final String type, TvType tvType, String filterGenre) throws JSONException {
        List list = new ArrayList();
        int length = $this$getMainPage_u24toSearchResponses.length();
        for (int i = 0; i < length; i++) {
            final JSONObject item = $this$getMainPage_u24toSearchResponses.getJSONObject(i);
            if (filterGenre == null || StringsKt.contains(item.optString("gn"), filterGenre, true)) {
                LoadURL loadUrl = getMainPage$toLoadURL(item, url, type);
                list.add(MainAPIKt.newMovieSearchResponse$default(this$0, item.optString("mn"), AppUtils.INSTANCE.toJson(loadUrl), tvType, false, new Function1() { // from class: com.RingZ.RingZ$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        return RingZ.getMainPage$toSearchResponses$lambda$3(item, type, (MovieSearchResponse) obj);
                    }
                }, 8, (Object) null));
            }
        }
        return list;
    }

    static final Unit getMainPage$toSearchResponses$lambda$3(JSONObject $item, String $type, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($item.optString("IH"));
        if (Intrinsics.areEqual($type, "Movies")) {
            String it = $item.optString("qlty");
            if (!(it.length() > 0)) {
                it = null;
            }
            $this$newMovieSearchResponse.setQuality(MainAPIKt.getQualityFromString(it));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x012b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0157 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0158  */
    /* JADX WARN: Code duplicated, block: B:40:0x017f  */
    /* JADX WARN: Code duplicated, block: B:45:0x0191  */
    /* JADX WARN: Code duplicated, block: B:48:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:49:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:51:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:52:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:55:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:56:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:63:0x018e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0158 -> B:37:0x0162). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object search(@org.jetbrains.annotations.NotNull java.lang.String r25, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r26) {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RingZ.RingZ.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object search$fetchJson(String url, Continuation<? super JSONObject> continuation) {
        RingZ$search$fetchJson$1 ringZ$search$fetchJson$1;
        if (continuation instanceof RingZ$search$fetchJson$1) {
            ringZ$search$fetchJson$1 = (RingZ$search$fetchJson$1) continuation;
            if ((ringZ$search$fetchJson$1.label & Integer.MIN_VALUE) != 0) {
                ringZ$search$fetchJson$1.label -= Integer.MIN_VALUE;
            } else {
                ringZ$search$fetchJson$1 = new RingZ$search$fetchJson$1(continuation);
            }
        } else {
            ringZ$search$fetchJson$1 = new RingZ$search$fetchJson$1(continuation);
        }
        Object $result = ringZ$search$fetchJson$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (ringZ$search$fetchJson$1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                Map<String, String> map = headers;
                ringZ$search$fetchJson$1.L$0 = SpillingKt.nullOutSpilledVariable(url);
                ringZ$search$fetchJson$1.label = 1;
                $result = Requests.get$default(app, url, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, ringZ$search$fetchJson$1, 4092, (Object) null);
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
        return new JSONObject(((NiceResponse) $result).getText());
    }

    private static final LoadURL search$toLoadURL(JSONObject $this$search_u24toLoadURL, String type, String fallbackUrl) {
        String strOptString = $this$search_u24toLoadURL.optString("l", fallbackUrl);
        String strOptString2 = $this$search_u24toLoadURL.optString("mn");
        String strOptString3 = $this$search_u24toLoadURL.optString("id");
        String strOptString4 = $this$search_u24toLoadURL.optString("IH");
        String it = $this$search_u24toLoadURL.optString("trailer");
        String str = !Intrinsics.areEqual(it, "FALSE") ? it : null;
        String it2 = $this$search_u24toLoadURL.optString("qlty");
        return new LoadURL(strOptString, strOptString2, strOptString3, strOptString4, str, it2.length() > 0 ? it2 : null, $this$search_u24toLoadURL.optString("lng"), type, $this$search_u24toLoadURL.optString("cg"), $this$search_u24toLoadURL.optString("gn"), $this$search_u24toLoadURL.toString());
    }

    static /* synthetic */ List search$toSearchResponses$default(JSONArray jSONArray, String str, RingZ ringZ, String str2, TvType tvType, String str3, String str4, int i, Object obj) {
        if ((i & 16) != 0) {
            str3 = null;
        }
        if ((i & 32) != 0) {
            str4 = null;
        }
        return search$toSearchResponses(jSONArray, str, ringZ, str2, tvType, str3, str4);
    }

    private static final List<SearchResponse> search$toSearchResponses(JSONArray $this$search_u24toSearchResponses, String $query, RingZ this$0, String type, final TvType tvType, String filterGenre, String fallback) throws JSONException {
        List list = new ArrayList();
        int length = $this$search_u24toSearchResponses.length();
        for (int i = 0; i < length; i++) {
            final JSONObject item = $this$search_u24toSearchResponses.getJSONObject(i);
            String name = item.optString("mn");
            if (StringsKt.contains(name, $query, true) && (filterGenre == null || StringsKt.contains(item.optString("gn"), filterGenre, true))) {
                LoadURL loadUrl = search$toLoadURL(item, type, String.valueOf(fallback));
                list.add(MainAPIKt.newMovieSearchResponse$default(this$0, name, AppUtils.INSTANCE.toJson(loadUrl), tvType, false, new Function1() { // from class: com.RingZ.RingZ$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return RingZ.search$toSearchResponses$lambda$2(item, tvType, (MovieSearchResponse) obj);
                    }
                }, 8, (Object) null));
            }
        }
        return list;
    }

    static final Unit search$toSearchResponses$lambda$2(JSONObject $item, TvType $tvType, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($item.optString("IH"));
        if ($tvType == TvType.Movie) {
            String it = $item.optString("qlty");
            if (!(it.length() > 0)) {
                it = null;
            }
            $this$newMovieSearchResponse.setQuality(MainAPIKt.getQualityFromString(it));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:100:0x0304  */
    /* JADX WARN: Code duplicated, block: B:101:0x0306  */
    /* JADX WARN: Code duplicated, block: B:104:0x0340 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:105:0x0341  */
    /* JADX WARN: Code duplicated, block: B:109:0x037d A[LOOP:3: B:107:0x0377->B:109:0x037d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:113:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:116:0x03c7 A[LOOP:4: B:111:0x03a5->B:116:0x03c7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:120:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:122:0x03de  */
    /* JADX WARN: Code duplicated, block: B:125:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:127:0x044a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:128:0x044b  */
    /* JADX WARN: Code duplicated, block: B:130:0x045b  */
    /* JADX WARN: Code duplicated, block: B:132:0x04c6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:133:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:135:0x04de  */
    /* JADX WARN: Code duplicated, block: B:138:0x051c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:139:0x051d  */
    /* JADX WARN: Code duplicated, block: B:143:0x0558 A[LOOP:0: B:141:0x0552->B:143:0x0558, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:147:0x0585  */
    /* JADX WARN: Code duplicated, block: B:150:0x05a3 A[LOOP:1: B:145:0x057f->B:150:0x05a3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:154:0x05b2  */
    /* JADX WARN: Code duplicated, block: B:157:0x05c1  */
    /* JADX WARN: Code duplicated, block: B:161:0x05eb  */
    /* JADX WARN: Code duplicated, block: B:166:0x0672 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:167:0x0673  */
    /* JADX WARN: Code duplicated, block: B:169:0x068f  */
    /* JADX WARN: Code duplicated, block: B:171:0x06ef A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:172:0x06f0  */
    /* JADX WARN: Code duplicated, block: B:176:0x0707  */
    /* JADX WARN: Code duplicated, block: B:178:0x070f  */
    /* JADX WARN: Code duplicated, block: B:191:0x05a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:0x05ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x05f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:195:0x05d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:200:0x03cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:201:0x03d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0238  */
    /* JADX WARN: Code duplicated, block: B:63:0x023e  */
    /* JADX WARN: Code duplicated, block: B:66:0x0247  */
    /* JADX WARN: Code duplicated, block: B:75:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:83:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:84:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:89:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:91:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:92:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:95:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:97:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:98:0x02fd  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws JSONException, ErrorLoadingException {
        C00031 c00031;
        Object obj;
        Object objDecodeFromString;
        LoadURL res;
        String title;
        String title2;
        String href;
        String poster;
        String genre;
        List genre2;
        String type;
        boolean z;
        String type2;
        boolean z2;
        TvType tvTag;
        String fullUrl;
        Object objLoad$fetchJson;
        LoadURL res2;
        String href2;
        String poster2;
        String fullUrl2;
        String url2;
        TvType tvTag2;
        List genre3;
        String fullUrl3;
        Object objLoad$fetchJson2;
        LoadURL res3;
        String poster3;
        String fullUrl4;
        String title3;
        Object obj2;
        String href3;
        List genre4;
        TvType tvTag3;
        Iterable iterableSplit$default;
        JSONObject seriesResText;
        JSONArray webSeriesList;
        String url3;
        Collection destination$iv$iv;
        IntIterator it;
        String fullUrl5;
        Iterable $this$firstOrNull$iv;
        Iterator it2;
        JSONArray webSeriesList2;
        Object element$iv;
        JSONObject seriesObj;
        List<Episode> listEmptyList;
        List<Episode> list;
        Object objNewAnimeLoadResponse$default;
        Object obj3;
        String href4;
        Object objNewTvSeriesLoadResponse;
        JSONObject it3;
        Iterable $this$firstOrNull$iv2;
        JSONObject movieResText;
        JSONArray allMovieDataList;
        String fullUrl6;
        Collection destination$iv$iv2;
        Iterable $this$mapTo$iv$iv;
        IntIterator it4;
        Iterable $this$firstOrNull$iv3;
        int $i$f$firstOrNull;
        Iterator it5;
        Object element$iv2;
        JSONObject movie;
        String url4;
        String title4;
        Object objNewMovieLoadResponse;
        TvType tvTag4;
        List genre5;
        String poster4;
        LoadURL res4;
        String title5;
        String url5;
        JSONArray linksArray;
        Iterator<String> itKeys;
        String url6;
        Object objNewMovieLoadResponse2;
        TvType tvTag5;
        String url7;
        String href5;
        List genre6;
        String poster5;
        LoadURL res5;
        String poster6;
        String key;
        String value;
        JSONObject entry;
        Iterable $this$firstOrNull$iv4;
        JSONObject it6;
        int $i$f$firstOrNull2;
        MovieLoadResponse movieLoadResponse;
        String url8 = url;
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
                AppUtils appUtils = AppUtils.INSTANCE;
                if (url == null) {
                    objDecodeFromString = null;
                } else {
                    try {
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(LoadURL.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                            break;
                        } catch (Exception e) {
                            objDecodeFromString = null;
                            res = (LoadURL) objDecodeFromString;
                            if (res != null) {
                                throw new ErrorLoadingException("Invalid URL JSON");
                            }
                            title = res.getTitle();
                            if (title == null) {
                                title = "Unknown Title";
                            }
                            title2 = title;
                            href = res.getUrl();
                            if (href != null) {
                                throw new ErrorLoadingException("URL missing");
                            }
                            poster = res.getPosterUrl();
                            genre = res.getGenre();
                            if (genre != null) {
                                genre2 = null;
                            } else {
                                genre2 = null;
                            }
                            type = res.getType();
                            if (type == null) {
                                z = false;
                            } else {
                                z = false;
                            }
                            if (z) {
                                tvTag = TvType.TvSeries;
                            } else {
                                type2 = res.getType();
                                if (type2 == null) {
                                    z2 = false;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    tvTag = TvType.Anime;
                                } else {
                                    tvTag = TvType.Movie;
                                }
                            }
                            switch (WhenMappings.$EnumSwitchMapping$0[tvTag.ordinal()]) {
                                case 1:
                                case 2:
                                    if (StringsKt.startsWith(href, "http", true)) {
                                        fullUrl = href;
                                    } else {
                                        fullUrl = getMainUrl() + '/' + href;
                                    }
                                    c00032.L$0 = url8;
                                    c00032.L$1 = res;
                                    c00032.L$2 = title2;
                                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(href);
                                    c00032.L$4 = poster;
                                    c00032.L$5 = genre2;
                                    c00032.L$6 = tvTag;
                                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(fullUrl);
                                    c00032.label = 1;
                                    objLoad$fetchJson = load$fetchJson(fullUrl, c00032);
                                    if (objLoad$fetchJson == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    res2 = res;
                                    href2 = href;
                                    poster2 = poster;
                                    fullUrl2 = fullUrl;
                                    url2 = url8;
                                    tvTag2 = tvTag;
                                    genre3 = genre2;
                                    seriesResText = (JSONObject) objLoad$fetchJson;
                                    webSeriesList = seriesResText.getJSONArray("webSeriesDataList");
                                    Iterable $this$map$iv = RangesKt.until(0, webSeriesList.length());
                                    url3 = url2;
                                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                    it = $this$map$iv.iterator();
                                    while (it.hasNext()) {
                                        int item$iv$iv = it.nextInt();
                                        destination$iv$iv.add(webSeriesList.getJSONObject(item$iv$iv));
                                        fullUrl2 = fullUrl2;
                                    }
                                    fullUrl5 = fullUrl2;
                                    $this$firstOrNull$iv = (List) destination$iv$iv;
                                    it2 = $this$firstOrNull$iv.iterator();
                                    while (true) {
                                        if (it2.hasNext()) {
                                            element$iv = it2.next();
                                            it3 = (JSONObject) element$iv;
                                            $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                                            webSeriesList2 = webSeriesList;
                                            if (!Intrinsics.areEqual(it3.getString("id"), res2.getId())) {
                                                $this$firstOrNull$iv = $this$firstOrNull$iv2;
                                                webSeriesList = webSeriesList2;
                                            }
                                        } else {
                                            webSeriesList2 = webSeriesList;
                                            element$iv = null;
                                        }
                                    }
                                    seriesObj = (JSONObject) element$iv;
                                    if (seriesObj != null) {
                                        listEmptyList = CollectionsKt.emptyList();
                                    } else {
                                        listEmptyList = CollectionsKt.emptyList();
                                    }
                                    list = listEmptyList;
                                    if (tvTag2 == TvType.TvSeries) {
                                        TvType tvType = TvType.TvSeries;
                                        C00042 c00042 = new C00042(poster2, genre3, null);
                                        c00032.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(res2);
                                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(href2);
                                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(poster2);
                                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(genre3);
                                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(tvTag2);
                                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(fullUrl5);
                                        c00032.L$8 = SpillingKt.nullOutSpilledVariable(seriesResText);
                                        c00032.L$9 = SpillingKt.nullOutSpilledVariable(webSeriesList2);
                                        c00032.L$10 = SpillingKt.nullOutSpilledVariable(seriesObj);
                                        c00032.L$11 = SpillingKt.nullOutSpilledVariable(list);
                                        c00032.label = 2;
                                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, url3, tvType, list, c00042, c00032);
                                        if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        return (LoadResponse) objNewTvSeriesLoadResponse;
                                    }
                                    TvType tvType2 = TvType.Anime;
                                    C00053 c00053 = new C00053(poster2, genre3, list, null);
                                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(res2);
                                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(href2);
                                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(poster2);
                                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(genre3);
                                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(tvTag2);
                                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(fullUrl5);
                                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(seriesResText);
                                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(webSeriesList2);
                                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(seriesObj);
                                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(list);
                                    c00032.label = 3;
                                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title2, url3, tvType2, false, c00053, c00032, 8, (Object) null);
                                    if (objNewAnimeLoadResponse$default == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj3 = objNewAnimeLoadResponse$default;
                                    href4 = href2;
                                    return (LoadResponse) obj3;
                                default:
                                    if (StringsKt.startsWith(href, "http", true)) {
                                        fullUrl3 = href;
                                    } else {
                                        fullUrl3 = getMainUrl() + '/' + href;
                                    }
                                    c00032.L$0 = url8;
                                    c00032.L$1 = res;
                                    c00032.L$2 = title2;
                                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(href);
                                    c00032.L$4 = poster;
                                    c00032.L$5 = genre2;
                                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(tvTag);
                                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(fullUrl3);
                                    c00032.label = 4;
                                    objLoad$fetchJson2 = load$fetchJson(fullUrl3, c00032);
                                    if (objLoad$fetchJson2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    res3 = res;
                                    poster3 = poster;
                                    fullUrl4 = fullUrl3;
                                    title3 = title2;
                                    obj2 = objLoad$fetchJson2;
                                    href3 = href;
                                    genre4 = genre2;
                                    tvTag3 = tvTag;
                                    movieResText = (JSONObject) obj2;
                                    allMovieDataList = movieResText.getJSONArray("AllMovieDataList");
                                    Iterable $this$map$iv2 = RangesKt.until(0, allMovieDataList.length());
                                    fullUrl6 = fullUrl4;
                                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                                    $this$mapTo$iv$iv = $this$map$iv2;
                                    it4 = $this$mapTo$iv$iv.iterator();
                                    while (it4.hasNext()) {
                                        int item$iv$iv2 = it4.nextInt();
                                        destination$iv$iv2.add(allMovieDataList.getJSONObject(item$iv$iv2));
                                        $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                                    }
                                    $this$firstOrNull$iv3 = (List) destination$iv$iv2;
                                    $i$f$firstOrNull = 0;
                                    it5 = $this$firstOrNull$iv3.iterator();
                                    while (true) {
                                        if (it5.hasNext()) {
                                            element$iv2 = it5.next();
                                            $this$firstOrNull$iv4 = $this$firstOrNull$iv3;
                                            it6 = (JSONObject) element$iv2;
                                            $i$f$firstOrNull2 = $i$f$firstOrNull;
                                            if (!Intrinsics.areEqual(it6.optString("id"), res3.getId())) {
                                                $this$firstOrNull$iv3 = $this$firstOrNull$iv4;
                                                $i$f$firstOrNull = $i$f$firstOrNull2;
                                            }
                                        } else {
                                            element$iv2 = null;
                                        }
                                    }
                                    movie = (JSONObject) element$iv2;
                                    if (movie == null) {
                                        url4 = url8;
                                        TvType tvType3 = TvType.Movie;
                                        C00075 c00075 = new C00075(poster3, genre4, null);
                                        c00032.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(res3);
                                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(href3);
                                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(poster3);
                                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(genre4);
                                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(tvTag3);
                                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(fullUrl6);
                                        c00032.L$8 = SpillingKt.nullOutSpilledVariable(movieResText);
                                        c00032.L$9 = SpillingKt.nullOutSpilledVariable(allMovieDataList);
                                        c00032.L$10 = SpillingKt.nullOutSpilledVariable(movie);
                                        c00032.label = 6;
                                        title4 = title3;
                                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title4, url4, tvType3, url4, c00075, c00032);
                                        if (objNewMovieLoadResponse == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        tvTag4 = tvTag3;
                                        genre5 = genre4;
                                        poster4 = poster3;
                                        res4 = res3;
                                        title5 = title4;
                                        url5 = url4;
                                        movieLoadResponse = (MovieLoadResponse) objNewMovieLoadResponse;
                                        return (LoadResponse) movieLoadResponse;
                                    }
                                    linksArray = new JSONArray();
                                    itKeys = movie.keys();
                                    while (itKeys.hasNext()) {
                                        key = itKeys.next();
                                        value = movie.optString(key);
                                        if (!Intrinsics.areEqual(key, "hf")) {
                                            entry = new JSONObject();
                                            String url9 = url8;
                                            entry.put("key", key);
                                            entry.put("value", value);
                                            if (StringsKt.startsWith(value, "http", true)) {
                                                entry.put("url", value);
                                            }
                                            linksArray.put(entry);
                                            url8 = url9;
                                        }
                                    }
                                    url6 = url8;
                                    String strOptString = movie.optString("mn");
                                    TvType tvType4 = TvType.Movie;
                                    String string = linksArray.toString();
                                    C00064 c00064 = new C00064(poster3, genre4, null);
                                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(res3);
                                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(href3);
                                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(poster3);
                                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(genre4);
                                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(tvTag3);
                                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(fullUrl6);
                                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(movieResText);
                                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(allMovieDataList);
                                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(movie);
                                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(linksArray);
                                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(itKeys);
                                    c00032.label = 5;
                                    objNewMovieLoadResponse2 = MainAPIKt.newMovieLoadResponse(this, strOptString, url6, tvType4, string, c00064, c00032);
                                    if (objNewMovieLoadResponse2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    tvTag5 = tvTag3;
                                    url7 = url6;
                                    href5 = href3;
                                    genre6 = genre4;
                                    poster5 = poster3;
                                    res5 = res3;
                                    poster6 = title3;
                                    movieLoadResponse = (MovieLoadResponse) objNewMovieLoadResponse2;
                                    return (LoadResponse) movieLoadResponse;
                            }
                        }
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.exceptionOrNull-impl(obj) != null) {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            try {
                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LoadURL.class), (List) null, 2, (Object) null));
                                break;
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    Result.Companion companion4 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Exception e2) {
                                    objDecodeFromString = null;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                    if (deserializationStrategy != null) {
                        try {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, url);
                        } catch (SerializationException e3) {
                            ArchComponentExtKt.logError(e3);
                            ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv.readValue(url, new TypeReference<LoadURL>() { // from class: com.RingZ.RingZ$load$$inlined$tryParseJson$1
                            });
                        } catch (Throwable th4) {
                            ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(url, new TypeReference<LoadURL>() { // from class: com.RingZ.RingZ$load$$inlined$tryParseJson$1
                            });
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(url, new TypeReference<LoadURL>() { // from class: com.RingZ.RingZ$load$$inlined$tryParseJson$1
                        });
                    }
                }
                res = (LoadURL) objDecodeFromString;
                if (res != null) {
                    throw new ErrorLoadingException("Invalid URL JSON");
                }
                title = res.getTitle();
                if (title == null) {
                    title = "Unknown Title";
                }
                title2 = title;
                href = res.getUrl();
                if (href != null) {
                    throw new ErrorLoadingException("URL missing");
                }
                poster = res.getPosterUrl();
                genre = res.getGenre();
                if (genre != null || (iterableSplit$default = StringsKt.split$default(genre, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                    genre2 = null;
                } else {
                    Iterable $this$map$iv3 = iterableSplit$default;
                    Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                    for (Object item$iv$iv3 : $this$map$iv3) {
                        String it7 = (String) item$iv$iv3;
                        destination$iv$iv3.add(StringsKt.trim(it7).toString());
                        $this$map$iv3 = $this$map$iv3;
                    }
                    genre2 = (List) destination$iv$iv3;
                }
                type = res.getType();
                if (type == null && StringsKt.contains(type, "Series", true)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    tvTag = TvType.TvSeries;
                } else {
                    type2 = res.getType();
                    if (type2 == null && StringsKt.contains(type2, "Anime", true)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        tvTag = TvType.Anime;
                    } else {
                        tvTag = TvType.Movie;
                    }
                }
                switch (WhenMappings.$EnumSwitchMapping$0[tvTag.ordinal()]) {
                    case 1:
                    case 2:
                        if (StringsKt.startsWith(href, "http", true)) {
                            fullUrl = href;
                        } else {
                            fullUrl = getMainUrl() + '/' + href;
                        }
                        c00032.L$0 = url8;
                        c00032.L$1 = res;
                        c00032.L$2 = title2;
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(href);
                        c00032.L$4 = poster;
                        c00032.L$5 = genre2;
                        c00032.L$6 = tvTag;
                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(fullUrl);
                        c00032.label = 1;
                        objLoad$fetchJson = load$fetchJson(fullUrl, c00032);
                        if (objLoad$fetchJson == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        res2 = res;
                        href2 = href;
                        poster2 = poster;
                        fullUrl2 = fullUrl;
                        url2 = url8;
                        tvTag2 = tvTag;
                        genre3 = genre2;
                        seriesResText = (JSONObject) objLoad$fetchJson;
                        webSeriesList = seriesResText.getJSONArray("webSeriesDataList");
                        Iterable $this$map$iv4 = RangesKt.until(0, webSeriesList.length());
                        url3 = url2;
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                        it = $this$map$iv4.iterator();
                        while (it.hasNext()) {
                            int item$iv$iv4 = it.nextInt();
                            destination$iv$iv.add(webSeriesList.getJSONObject(item$iv$iv4));
                            fullUrl2 = fullUrl2;
                        }
                        fullUrl5 = fullUrl2;
                        $this$firstOrNull$iv = (List) destination$iv$iv;
                        it2 = $this$firstOrNull$iv.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                element$iv = it2.next();
                                it3 = (JSONObject) element$iv;
                                $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                                webSeriesList2 = webSeriesList;
                                if (!Intrinsics.areEqual(it3.getString("id"), res2.getId())) {
                                    $this$firstOrNull$iv = $this$firstOrNull$iv2;
                                    webSeriesList = webSeriesList2;
                                }
                            } else {
                                webSeriesList2 = webSeriesList;
                                element$iv = null;
                            }
                        }
                        seriesObj = (JSONObject) element$iv;
                        if (seriesObj != null || (listEmptyList = load$parseEpisodes(this, seriesObj)) == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        list = listEmptyList;
                        if (tvTag2 == TvType.TvSeries) {
                            TvType tvType5 = TvType.TvSeries;
                            C00042 c00043 = new C00042(poster2, genre3, null);
                            c00032.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00032.L$1 = SpillingKt.nullOutSpilledVariable(res2);
                            c00032.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                            c00032.L$3 = SpillingKt.nullOutSpilledVariable(href2);
                            c00032.L$4 = SpillingKt.nullOutSpilledVariable(poster2);
                            c00032.L$5 = SpillingKt.nullOutSpilledVariable(genre3);
                            c00032.L$6 = SpillingKt.nullOutSpilledVariable(tvTag2);
                            c00032.L$7 = SpillingKt.nullOutSpilledVariable(fullUrl5);
                            c00032.L$8 = SpillingKt.nullOutSpilledVariable(seriesResText);
                            c00032.L$9 = SpillingKt.nullOutSpilledVariable(webSeriesList2);
                            c00032.L$10 = SpillingKt.nullOutSpilledVariable(seriesObj);
                            c00032.L$11 = SpillingKt.nullOutSpilledVariable(list);
                            c00032.label = 2;
                            objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, url3, tvType5, list, c00043, c00032);
                            if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return (LoadResponse) objNewTvSeriesLoadResponse;
                        }
                        TvType tvType6 = TvType.Anime;
                        C00053 c00054 = new C00053(poster2, genre3, list, null);
                        c00032.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(res2);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(href2);
                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(poster2);
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(genre3);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(tvTag2);
                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(fullUrl5);
                        c00032.L$8 = SpillingKt.nullOutSpilledVariable(seriesResText);
                        c00032.L$9 = SpillingKt.nullOutSpilledVariable(webSeriesList2);
                        c00032.L$10 = SpillingKt.nullOutSpilledVariable(seriesObj);
                        c00032.L$11 = SpillingKt.nullOutSpilledVariable(list);
                        c00032.label = 3;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title2, url3, tvType6, false, c00054, c00032, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj3 = objNewAnimeLoadResponse$default;
                        href4 = href2;
                        return (LoadResponse) obj3;
                    default:
                        if (StringsKt.startsWith(href, "http", true)) {
                            fullUrl3 = href;
                        } else {
                            fullUrl3 = getMainUrl() + '/' + href;
                        }
                        c00032.L$0 = url8;
                        c00032.L$1 = res;
                        c00032.L$2 = title2;
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(href);
                        c00032.L$4 = poster;
                        c00032.L$5 = genre2;
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(tvTag);
                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(fullUrl3);
                        c00032.label = 4;
                        objLoad$fetchJson2 = load$fetchJson(fullUrl3, c00032);
                        if (objLoad$fetchJson2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        res3 = res;
                        poster3 = poster;
                        fullUrl4 = fullUrl3;
                        title3 = title2;
                        obj2 = objLoad$fetchJson2;
                        href3 = href;
                        genre4 = genre2;
                        tvTag3 = tvTag;
                        movieResText = (JSONObject) obj2;
                        allMovieDataList = movieResText.getJSONArray("AllMovieDataList");
                        Iterable $this$map$iv5 = RangesKt.until(0, allMovieDataList.length());
                        fullUrl6 = fullUrl4;
                        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                        $this$mapTo$iv$iv = $this$map$iv5;
                        it4 = $this$mapTo$iv$iv.iterator();
                        while (it4.hasNext()) {
                            int item$iv$iv5 = it4.nextInt();
                            destination$iv$iv2.add(allMovieDataList.getJSONObject(item$iv$iv5));
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                        }
                        $this$firstOrNull$iv3 = (List) destination$iv$iv2;
                        $i$f$firstOrNull = 0;
                        it5 = $this$firstOrNull$iv3.iterator();
                        while (true) {
                            if (it5.hasNext()) {
                                element$iv2 = it5.next();
                                $this$firstOrNull$iv4 = $this$firstOrNull$iv3;
                                it6 = (JSONObject) element$iv2;
                                $i$f$firstOrNull2 = $i$f$firstOrNull;
                                if (!Intrinsics.areEqual(it6.optString("id"), res3.getId())) {
                                    $this$firstOrNull$iv3 = $this$firstOrNull$iv4;
                                    $i$f$firstOrNull = $i$f$firstOrNull2;
                                }
                            } else {
                                element$iv2 = null;
                            }
                        }
                        movie = (JSONObject) element$iv2;
                        if (movie == null) {
                            url4 = url8;
                            TvType tvType7 = TvType.Movie;
                            C00075 c00076 = new C00075(poster3, genre4, null);
                            c00032.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                            c00032.L$1 = SpillingKt.nullOutSpilledVariable(res3);
                            c00032.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                            c00032.L$3 = SpillingKt.nullOutSpilledVariable(href3);
                            c00032.L$4 = SpillingKt.nullOutSpilledVariable(poster3);
                            c00032.L$5 = SpillingKt.nullOutSpilledVariable(genre4);
                            c00032.L$6 = SpillingKt.nullOutSpilledVariable(tvTag3);
                            c00032.L$7 = SpillingKt.nullOutSpilledVariable(fullUrl6);
                            c00032.L$8 = SpillingKt.nullOutSpilledVariable(movieResText);
                            c00032.L$9 = SpillingKt.nullOutSpilledVariable(allMovieDataList);
                            c00032.L$10 = SpillingKt.nullOutSpilledVariable(movie);
                            c00032.label = 6;
                            title4 = title3;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title4, url4, tvType7, url4, c00076, c00032);
                            if (objNewMovieLoadResponse == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            tvTag4 = tvTag3;
                            genre5 = genre4;
                            poster4 = poster3;
                            res4 = res3;
                            title5 = title4;
                            url5 = url4;
                            movieLoadResponse = (MovieLoadResponse) objNewMovieLoadResponse;
                            return (LoadResponse) movieLoadResponse;
                        }
                        linksArray = new JSONArray();
                        itKeys = movie.keys();
                        while (itKeys.hasNext()) {
                            key = itKeys.next();
                            value = movie.optString(key);
                            if (!Intrinsics.areEqual(key, "hf")) {
                                entry = new JSONObject();
                                String url10 = url8;
                                entry.put("key", key);
                                entry.put("value", value);
                                if (StringsKt.startsWith(value, "http", true)) {
                                    entry.put("url", value);
                                }
                                linksArray.put(entry);
                                url8 = url10;
                            }
                        }
                        url6 = url8;
                        String strOptString2 = movie.optString("mn");
                        TvType tvType8 = TvType.Movie;
                        String string2 = linksArray.toString();
                        C00064 c00065 = new C00064(poster3, genre4, null);
                        c00032.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(res3);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(href3);
                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(poster3);
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(genre4);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(tvTag3);
                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(fullUrl6);
                        c00032.L$8 = SpillingKt.nullOutSpilledVariable(movieResText);
                        c00032.L$9 = SpillingKt.nullOutSpilledVariable(allMovieDataList);
                        c00032.L$10 = SpillingKt.nullOutSpilledVariable(movie);
                        c00032.L$11 = SpillingKt.nullOutSpilledVariable(linksArray);
                        c00032.L$12 = SpillingKt.nullOutSpilledVariable(itKeys);
                        c00032.label = 5;
                        objNewMovieLoadResponse2 = MainAPIKt.newMovieLoadResponse(this, strOptString2, url6, tvType8, string2, c00065, c00032);
                        if (objNewMovieLoadResponse2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        tvTag5 = tvTag3;
                        url7 = url6;
                        href5 = href3;
                        genre6 = genre4;
                        poster5 = poster3;
                        res5 = res3;
                        poster6 = title3;
                        movieLoadResponse = (MovieLoadResponse) objNewMovieLoadResponse2;
                        return (LoadResponse) movieLoadResponse;
                }
                break;
            case 1:
                fullUrl2 = (String) c00032.L$7;
                TvType tvTag6 = (TvType) c00032.L$6;
                List genre7 = (List) c00032.L$5;
                String poster7 = (String) c00032.L$4;
                String href6 = (String) c00032.L$3;
                title2 = (String) c00032.L$2;
                LoadURL res6 = (LoadURL) c00032.L$1;
                String url11 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url11;
                tvTag2 = tvTag6;
                poster2 = poster7;
                href2 = href6;
                res2 = res6;
                objLoad$fetchJson = $result;
                genre3 = genre7;
                seriesResText = (JSONObject) objLoad$fetchJson;
                webSeriesList = seriesResText.getJSONArray("webSeriesDataList");
                Iterable $this$map$iv6 = RangesKt.until(0, webSeriesList.length());
                url3 = url2;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
                it = $this$map$iv6.iterator();
                while (it.hasNext()) {
                    int item$iv$iv6 = it.nextInt();
                    destination$iv$iv.add(webSeriesList.getJSONObject(item$iv$iv6));
                    fullUrl2 = fullUrl2;
                }
                fullUrl5 = fullUrl2;
                $this$firstOrNull$iv = (List) destination$iv$iv;
                it2 = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        element$iv = it2.next();
                        it3 = (JSONObject) element$iv;
                        $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                        webSeriesList2 = webSeriesList;
                        if (!Intrinsics.areEqual(it3.getString("id"), res2.getId())) {
                            $this$firstOrNull$iv = $this$firstOrNull$iv2;
                            webSeriesList = webSeriesList2;
                        }
                    } else {
                        webSeriesList2 = webSeriesList;
                        element$iv = null;
                    }
                }
                seriesObj = (JSONObject) element$iv;
                if (seriesObj != null) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                list = listEmptyList;
                if (tvTag2 == TvType.TvSeries) {
                    TvType tvType9 = TvType.TvSeries;
                    C00042 c00044 = new C00042(poster2, genre3, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(res2);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(href2);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(poster2);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(genre3);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(tvTag2);
                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(fullUrl5);
                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(seriesResText);
                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(webSeriesList2);
                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(seriesObj);
                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(list);
                    c00032.label = 2;
                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, url3, tvType9, list, c00044, c00032);
                    if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return (LoadResponse) objNewTvSeriesLoadResponse;
                }
                TvType tvType10 = TvType.Anime;
                C00053 c00055 = new C00053(poster2, genre3, list, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(res2);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(href2);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(poster2);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(genre3);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(tvTag2);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(fullUrl5);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(seriesResText);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(webSeriesList2);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(seriesObj);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(list);
                c00032.label = 3;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title2, url3, tvType10, false, c00055, c00032, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj3 = objNewAnimeLoadResponse$default;
                href4 = href2;
                return (LoadResponse) obj3;
            case 2:
                ResultKt.throwOnFailure($result);
                objNewTvSeriesLoadResponse = $result;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 3:
                href4 = (String) c00032.L$3;
                ResultKt.throwOnFailure($result);
                obj3 = $result;
                return (LoadResponse) obj3;
            case 4:
                fullUrl4 = (String) c00032.L$7;
                TvType tvTag7 = (TvType) c00032.L$6;
                genre4 = (List) c00032.L$5;
                poster3 = (String) c00032.L$4;
                String href7 = (String) c00032.L$3;
                String title6 = (String) c00032.L$2;
                LoadURL res7 = (LoadURL) c00032.L$1;
                url8 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                tvTag3 = tvTag7;
                res3 = res7;
                href3 = href7;
                title3 = title6;
                obj2 = $result;
                movieResText = (JSONObject) obj2;
                allMovieDataList = movieResText.getJSONArray("AllMovieDataList");
                Iterable $this$map$iv7 = RangesKt.until(0, allMovieDataList.length());
                fullUrl6 = fullUrl4;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv7, 10));
                $this$mapTo$iv$iv = $this$map$iv7;
                it4 = $this$mapTo$iv$iv.iterator();
                while (it4.hasNext()) {
                    int item$iv$iv7 = it4.nextInt();
                    destination$iv$iv2.add(allMovieDataList.getJSONObject(item$iv$iv7));
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                }
                $this$firstOrNull$iv3 = (List) destination$iv$iv2;
                $i$f$firstOrNull = 0;
                it5 = $this$firstOrNull$iv3.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        element$iv2 = it5.next();
                        $this$firstOrNull$iv4 = $this$firstOrNull$iv3;
                        it6 = (JSONObject) element$iv2;
                        $i$f$firstOrNull2 = $i$f$firstOrNull;
                        if (!Intrinsics.areEqual(it6.optString("id"), res3.getId())) {
                            $this$firstOrNull$iv3 = $this$firstOrNull$iv4;
                            $i$f$firstOrNull = $i$f$firstOrNull2;
                        }
                    } else {
                        element$iv2 = null;
                    }
                }
                movie = (JSONObject) element$iv2;
                if (movie == null) {
                    url4 = url8;
                    TvType tvType11 = TvType.Movie;
                    C00075 c00077 = new C00075(poster3, genre4, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(res3);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(href3);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(poster3);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(genre4);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(tvTag3);
                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(fullUrl6);
                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(movieResText);
                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(allMovieDataList);
                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(movie);
                    c00032.label = 6;
                    title4 = title3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title4, url4, tvType11, url4, c00077, c00032);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    tvTag4 = tvTag3;
                    genre5 = genre4;
                    poster4 = poster3;
                    res4 = res3;
                    title5 = title4;
                    url5 = url4;
                    movieLoadResponse = (MovieLoadResponse) objNewMovieLoadResponse;
                    return (LoadResponse) movieLoadResponse;
                }
                linksArray = new JSONArray();
                itKeys = movie.keys();
                while (itKeys.hasNext()) {
                    key = itKeys.next();
                    value = movie.optString(key);
                    if (!Intrinsics.areEqual(key, "hf")) {
                        entry = new JSONObject();
                        String url12 = url8;
                        entry.put("key", key);
                        entry.put("value", value);
                        if (StringsKt.startsWith(value, "http", true)) {
                            entry.put("url", value);
                        }
                        linksArray.put(entry);
                        url8 = url12;
                    }
                }
                url6 = url8;
                String strOptString3 = movie.optString("mn");
                TvType tvType12 = TvType.Movie;
                String string3 = linksArray.toString();
                C00064 c00066 = new C00064(poster3, genre4, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(res3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(href3);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(poster3);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(genre4);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(tvTag3);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(fullUrl6);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(movieResText);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(allMovieDataList);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(movie);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(linksArray);
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(itKeys);
                c00032.label = 5;
                objNewMovieLoadResponse2 = MainAPIKt.newMovieLoadResponse(this, strOptString3, url6, tvType12, string3, c00066, c00032);
                if (objNewMovieLoadResponse2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                tvTag5 = tvTag3;
                url7 = url6;
                href5 = href3;
                genre6 = genre4;
                poster5 = poster3;
                res5 = res3;
                poster6 = title3;
                movieLoadResponse = (MovieLoadResponse) objNewMovieLoadResponse2;
                return (LoadResponse) movieLoadResponse;
            case 5:
                tvTag5 = (TvType) c00032.L$6;
                genre6 = (List) c00032.L$5;
                poster5 = (String) c00032.L$4;
                href5 = (String) c00032.L$3;
                poster6 = (String) c00032.L$2;
                res5 = (LoadURL) c00032.L$1;
                url7 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                objNewMovieLoadResponse2 = $result;
                movieLoadResponse = (MovieLoadResponse) objNewMovieLoadResponse2;
                return (LoadResponse) movieLoadResponse;
            case 6:
                tvTag4 = (TvType) c00032.L$6;
                genre5 = (List) c00032.L$5;
                poster4 = (String) c00032.L$4;
                href3 = (String) c00032.L$3;
                title5 = (String) c00032.L$2;
                res4 = (LoadURL) c00032.L$1;
                url5 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                objNewMovieLoadResponse = $result;
                movieLoadResponse = (MovieLoadResponse) objNewMovieLoadResponse;
                return (LoadResponse) movieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object load$fetchJson(String fullUrl, Continuation<? super JSONObject> continuation) {
        RingZ$load$fetchJson$1 ringZ$load$fetchJson$1;
        if (continuation instanceof RingZ$load$fetchJson$1) {
            ringZ$load$fetchJson$1 = (RingZ$load$fetchJson$1) continuation;
            if ((ringZ$load$fetchJson$1.label & Integer.MIN_VALUE) != 0) {
                ringZ$load$fetchJson$1.label -= Integer.MIN_VALUE;
            } else {
                ringZ$load$fetchJson$1 = new RingZ$load$fetchJson$1(continuation);
            }
        } else {
            ringZ$load$fetchJson$1 = new RingZ$load$fetchJson$1(continuation);
        }
        Object $result = ringZ$load$fetchJson$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (ringZ$load$fetchJson$1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                Map<String, String> map = headers;
                ringZ$load$fetchJson$1.L$0 = SpillingKt.nullOutSpilledVariable(fullUrl);
                ringZ$load$fetchJson$1.label = 1;
                $result = Requests.get$default(app, fullUrl, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, ringZ$load$fetchJson$1, 4092, (Object) null);
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
        return new JSONObject(((NiceResponse) $result).getText());
    }

    private static final List<Episode> load$parseEpisodes(RingZ this$0, JSONObject seriesObj) throws JSONException {
        ArrayList answer$iv;
        Map episodeMap = new LinkedHashMap();
        Iterator<String> itKeys = seriesObj.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            JSONObject serverBlock = seriesObj.optJSONObject(key);
            if (serverBlock != null && serverBlock.has("1")) {
                Iterator<String> itKeys2 = serverBlock.keys();
                while (itKeys2.hasNext()) {
                    String epNum = itKeys2.next();
                    String epUrl = serverBlock.getString(epNum);
                    Object value$iv = episodeMap.get(epNum);
                    if (value$iv == null) {
                        answer$iv = new ArrayList();
                        episodeMap.put(epNum, answer$iv);
                    } else {
                        answer$iv = value$iv;
                    }
                    Object key$iv = answer$iv;
                    List list = (List) key$iv;
                    JSONObject entry = new JSONObject();
                    String niceKey = StringsKt.startsWith(key, "e", true) ? StringsKt.drop(key, 1) : key;
                    entry.put("key", niceKey);
                    entry.put("url", epUrl);
                    entry.put("episode", epNum);
                    list.add(entry);
                }
            }
        }
        Iterable $this$sortedBy$iv = episodeMap.entrySet();
        Iterable $this$map$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.RingZ.RingZ$load$parseEpisodes$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Map.Entry it = (Map.Entry) t;
                Integer numValueOf = Integer.valueOf(Integer.parseInt((String) it.getKey()));
                Map.Entry it2 = (Map.Entry) t2;
                return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(Integer.parseInt((String) it2.getKey())));
            }
        });
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Map.Entry entry2 = (Map.Entry) item$iv$iv;
            final String epNum2 = (String) entry2.getKey();
            List jsonList = (List) entry2.getValue();
            destination$iv$iv.add(MainAPIKt.newEpisode(this$0, jsonList.toString(), new Function1() { // from class: com.RingZ.RingZ$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    return RingZ.load$parseEpisodes$lambda$4$0(epNum2, (Episode) obj);
                }
            }));
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$parseEpisodes$lambda$4$0(String $epNum, Episode $this$newEpisode) {
        $this$newEpisode.setName("Episode " + $epNum);
        $this$newEpisode.setEpisode(Integer.valueOf(Integer.parseInt($epNum)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.RingZ.RingZ$load$2 */
    /* JADX INFO: compiled from: RingZ.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.RingZ.RingZ$load$2", f = "RingZ.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $genre;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(String str, List<String> list, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$genre = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(this.$poster, this.$genre, continuation);
            c00042.L$0 = obj;
            return c00042;
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
                    $this$newTvSeriesLoadResponse.setTags(this.$genre);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.RingZ.RingZ$load$3 */
    /* JADX INFO: compiled from: RingZ.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.RingZ.RingZ$load$3", f = "RingZ.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00053 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Episode> $allEpisodes;
        final /* synthetic */ List<String> $genre;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00053(String str, List<String> list, List<Episode> list2, Continuation<? super C00053> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$genre = list;
            this.$allEpisodes = list2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00053 = new C00053(this.$poster, this.$genre, this.$allEpisodes, continuation);
            c00053.L$0 = obj;
            return c00053;
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
                    $this$newAnimeLoadResponse.setPosterUrl(this.$poster);
                    $this$newAnimeLoadResponse.setTags(this.$genre);
                    MainAPIKt.addEpisodes($this$newAnimeLoadResponse, DubStatus.Subbed, this.$allEpisodes);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.RingZ.RingZ$load$4 */
    /* JADX INFO: compiled from: RingZ.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.RingZ.RingZ$load$4", f = "RingZ.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00064 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $genre;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00064(String str, List<String> list, Continuation<? super C00064> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$genre = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00064 = new C00064(this.$poster, this.$genre, continuation);
            c00064.L$0 = obj;
            return c00064;
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
                    $this$newMovieLoadResponse.setTags(this.$genre);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.RingZ.RingZ$load$5 */
    /* JADX INFO: compiled from: RingZ.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.RingZ.RingZ$load$5", f = "RingZ.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00075 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $genre;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00075(String str, List<String> list, Continuation<? super C00075> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$genre = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00075 = new C00075(this.$poster, this.$genre, continuation);
            c00075.L$0 = obj;
            return c00075;
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
                    $this$newMovieLoadResponse.setTags(this.$genre);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:113:0x0247  */
    /* JADX WARN: Code duplicated, block: B:164:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:168:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:172:0x0307  */
    /* JADX WARN: Code duplicated, block: B:176:0x0315  */
    /* JADX WARN: Code duplicated, block: B:181:0x0325  */
    /* JADX WARN: Code duplicated, block: B:183:0x032e  */
    /* JADX WARN: Code duplicated, block: B:184:0x0330  */
    /* JADX WARN: Code duplicated, block: B:186:0x0333  */
    /* JADX WARN: Code duplicated, block: B:187:0x036d  */
    /* JADX WARN: Code duplicated, block: B:200:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:203:0x03ef A[LOOP:0: B:198:0x03c8->B:203:0x03ef, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:228:0x03ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:191:0x0391 -> B:218:0x04c1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:216:0x049b -> B:217:0x04b4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r28, boolean r29, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r30, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r31, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r32) {
        /*
            Method dump skipped, instruction units count: 1306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RingZ.RingZ.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.RingZ.RingZ$loadLinks$9 */
    /* JADX INFO: compiled from: RingZ.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.RingZ.RingZ$loadLinks$9", f = "RingZ.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00099 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $quality;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00099(int i, Continuation<? super C00099> continuation) {
            super(2, continuation);
            this.$quality = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00099 = new C00099(this.$quality, continuation);
            c00099.L$0 = obj;
            return c00099;
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
                    $this$newExtractorLink.setReferer("");
                    $this$newExtractorLink.setQuality(this.$quality);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private static final int inferQuality$matchQualityFromString(String s) {
        if (s == null) {
            return Qualities.Unknown.getValue();
        }
        String lower = s.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lower, "toLowerCase(...)");
        if (StringsKt.contains$default(lower, "2160", false, 2, (Object) null) || StringsKt.contains$default(lower, "4k", false, 2, (Object) null)) {
            return Qualities.P2160.getValue();
        }
        if (StringsKt.contains$default(lower, "1080", false, 2, (Object) null)) {
            return Qualities.P1080.getValue();
        }
        if (StringsKt.contains$default(lower, "720", false, 2, (Object) null)) {
            return Qualities.P720.getValue();
        }
        if (StringsKt.contains$default(lower, "480", false, 2, (Object) null)) {
            return Qualities.P480.getValue();
        }
        if (StringsKt.contains$default(lower, "360", false, 2, (Object) null)) {
            return Qualities.P360.getValue();
        }
        if (StringsKt.contains$default(lower, "hd", false, 2, (Object) null) && StringsKt.contains$default(lower, "1080", false, 2, (Object) null)) {
            return Qualities.P1080.getValue();
        }
        return (StringsKt.contains$default(lower, "hd", false, 2, (Object) null) && StringsKt.contains$default(lower, "720", false, 2, (Object) null)) ? Qualities.P720.getValue() : Qualities.Unknown.getValue();
    }

    public final int inferQuality(@Nullable String url, @Nullable String key, @Nullable String value) {
        int qFromUrl = inferQuality$matchQualityFromString(url);
        if (qFromUrl != Qualities.Unknown.getValue()) {
            return qFromUrl;
        }
        int qFromKey = inferQuality$matchQualityFromString(key);
        if (qFromKey != Qualities.Unknown.getValue()) {
            return qFromKey;
        }
        int qFromValue = inferQuality$matchQualityFromString(value);
        return qFromValue != Qualities.Unknown.getValue() ? qFromValue : Qualities.Unknown.getValue();
    }
}
