package com.Hdmovie2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fleeksoft.ksoup.Ksoup;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.Actor;
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
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: Hdmovie2.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Hdmovie2/classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002GHB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010!\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0096@¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005J\u000e\u0010+\u001a\u0004\u0018\u00010,*\u00020-H\u0002J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020,0\u001f2\u0006\u0010/\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00100J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00100J\u0010\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005H\u0002JF\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00112\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;092\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020;09H\u0096@¢\u0006\u0002\u0010>J\f\u0010?\u001a\u00020\u0005*\u00020\u0005H\u0002J\f\u0010@\u001a\u00020\u0005*\u00020-H\u0002J\u0010\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020=H\u0016J\u0012\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u0014\u0010\u0017\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006I"}, d2 = {"Lcom/Hdmovie2/Hdmovie2;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "directUrl", "getDirectUrl", "setDirectUrl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProperLink", "uri", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "getBaseUrl", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIframe", "getImageAttr", "getVideoInterceptor", "Lokhttp3/Interceptor;", "extractorLink", "getSearchQuality", "Lcom/lagradost/cloudstream3/SearchQuality;", "check", "LinkData", "ResponseHash", "Hdmovie2"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHdmovie2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Hdmovie2.kt\ncom/Hdmovie2/Hdmovie2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 6 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,663:1\n1795#2,10:664\n2068#2:674\n2069#2:676\n1805#2:677\n1795#2,10:678\n2068#2:688\n2069#2:690\n1805#2:691\n1739#2:692\n1814#2,3:693\n1960#2,3:696\n1739#2:699\n1814#2,3:700\n1739#2:703\n1814#2,3:704\n1739#2:707\n1814#2,3:708\n296#2,2:711\n1795#2,10:713\n2068#2:723\n2069#2:725\n1805#2:726\n1795#2,10:727\n2068#2:737\n2069#2:739\n1805#2:740\n1795#2,10:741\n2068#2:751\n2069#2:753\n1805#2:754\n1795#2,10:755\n2068#2:765\n296#2,2:766\n2069#2:769\n1805#2:770\n296#2,2:817\n296#2,2:819\n1739#2:821\n1814#2,3:822\n1#3:675\n1#3:689\n1#3:724\n1#3:738\n1#3:752\n1#3:768\n1#3:774\n1#3:797\n93#4,2:771\n63#4:773\n64#4,15:775\n95#4,2:792\n93#4,2:794\n63#4:796\n64#4,15:798\n95#4,2:815\n50#5:790\n43#5:791\n50#5:813\n43#5:814\n68#6:825\n*S KotlinDebug\n*F\n+ 1 Hdmovie2.kt\ncom/Hdmovie2/Hdmovie2\n*L\n83#1:664,10\n83#1:674\n83#1:676\n83#1:677\n131#1:678,10\n131#1:688\n131#1:690\n131#1:691\n155#1:692\n155#1:693,3\n161#1:696,3\n169#1:699\n169#1:700,3\n176#1:703\n176#1:704,3\n187#1:707\n187#1:708,3\n208#1:711,2\n212#1:713,10\n212#1:723\n212#1:725\n212#1:726\n222#1:727,10\n222#1:737\n222#1:739\n222#1:740\n233#1:741,10\n233#1:751\n233#1:753\n233#1:754\n255#1:755,10\n255#1:765\n260#1:766,2\n255#1:769\n255#1:770\n348#1:817,2\n370#1:819,2\n376#1:821\n376#1:822,3\n83#1:675\n131#1:689\n212#1:724\n222#1:738\n233#1:752\n255#1:768\n315#1:774\n330#1:797\n315#1:771,2\n315#1:773\n315#1:775,15\n315#1:792,2\n330#1:794,2\n330#1:796\n330#1:798,15\n330#1:815,2\n315#1:790\n315#1:791\n330#1:813\n330#1:814\n310#1:825\n*E\n"})
public final class Hdmovie2 extends MainAPI {

    @NotNull
    private String mainUrl = (String) BuildersKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new Hdmovie2$mainUrl$1(null));

    @NotNull
    private String directUrl = "";

    @NotNull
    private String name = "Hdmovie2";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("release/" + Calendar.getInstance().get(1), "Latest"), TuplesKt.to("genre/bollywood", "BollyWood"), TuplesKt.to("movies", "Movies"), TuplesKt.to("genre/hindi-webseries", "Hindi Web Series"), TuplesKt.to("genre/netflix", "Netflix"), TuplesKt.to("genre/zee5", "Zee5"), TuplesKt.to("genre/hindi-dubbed", "Hindi Dubbed"), TuplesKt.to("genre/comedy", "Comedy"), TuplesKt.to("genre/science-fiction", "Science Fiction")});

    /* JADX INFO: renamed from: com.Hdmovie2.Hdmovie2$getMainPage$1 */
    /* JADX INFO: compiled from: Hdmovie2.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Hdmovie2.Hdmovie2", f = "Hdmovie2.kt", i = {0, 0, 0}, l = {81}, m = "getMainPage", n = {"request", "url", "page"}, nl = {83}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Hdmovie2.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Hdmovie2.Hdmovie2$load$1 */
    /* JADX INFO: compiled from: Hdmovie2.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Hdmovie2.Hdmovie2", f = "Hdmovie2.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {147, 243, 267}, m = "load", n = {"url", "url", "request", "document", "title", "background", "posterUrl", "tags", "year", "tvType", "description", "trailer", "rating", "actors", "recommendations", "episodes", "url", "request", "document", "title", "background", "posterUrl", "tags", "year", "tvType", "description", "trailer", "rating", "actors", "recommendations", "hrefs"}, nl = {148, 255, 185}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
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
            return Hdmovie2.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Hdmovie2.Hdmovie2$loadLinks$1 */
    /* JADX INFO: compiled from: Hdmovie2.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Hdmovie2.Hdmovie2", f = "Hdmovie2.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9}, l = {316, 331, 339, 343, 345, 351, 377, 396, 398, 399}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "ajaxUrl", "commonHeaders", "loadDataList", "isCasting", "data", "subtitleCallback", "callback", "ajaxUrl", "commonHeaders", "loadData", "isCasting", "data", "subtitleCallback", "callback", "ajaxUrl", "commonHeaders", "loadData", "source", "isCasting", "data", "subtitleCallback", "callback", "ajaxUrl", "commonHeaders", "isCasting", "data", "subtitleCallback", "callback", "ajaxUrl", "commonHeaders", "isCasting", "data", "subtitleCallback", "callback", "ajaxUrl", "commonHeaders", "document", "playerOptions", "post_id", "type", "isCasting", "data", "subtitleCallback", "callback", "ajaxUrl", "commonHeaders", "document", "playerOptions", "id", "type", "isCasting", "data", "subtitleCallback", "callback", "ajaxUrl", "commonHeaders", "isCasting", "data", "subtitleCallback", "callback", "ajaxUrl", "commonHeaders", "directLinks", "it", "isCasting", "data", "subtitleCallback", "callback", "ajaxUrl", "commonHeaders", "directLinks", "it", "doc", "isCasting"}, nl = {328, 337, 342, 345, 346, 368, 395, 397, 399, 406}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Hdmovie2.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Hdmovie2.Hdmovie2$search$1 */
    /* JADX INFO: compiled from: Hdmovie2.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Hdmovie2.Hdmovie2", f = "Hdmovie2.kt", i = {0}, l = {130}, m = "search", n = {"query"}, nl = {131}, s = {"L$0"}, v = 2)
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
            return Hdmovie2.this.search(null, (Continuation) this);
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
    public final String getDirectUrl() {
        return this.directUrl;
    }

    public final void setDirectUrl(@NotNull String str) {
        this.directUrl = str;
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
        C00021 c00021;
        StringBuilder sb;
        StringBuilder sbAppend;
        MainPageRequest request2;
        int page2 = page;
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
                if (page2 == 1) {
                    sb = new StringBuilder();
                    sbAppend = sb.append(getMainUrl()).append('/').append(request.getData());
                } else {
                    sb = new StringBuilder();
                    sbAppend = sb.append(getMainUrl()).append('/').append(request.getData()).append("/page/").append(page2);
                }
                String url = sbAppend.append('/').toString();
                Requests app = MainActivityKt.getApp();
                c00021.L$0 = request;
                c00021.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00021.I$0 = page2;
                c00021.label = 1;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00021.I$0;
                request2 = (MainPageRequest) c00021.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.items.normal article, div#archive-content article, div.items.full article,article");
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

    @NotNull
    public final String getProperLink(@NotNull String uri) {
        List groupValues;
        List groupValues2;
        String str = null;
        if (StringsKt.contains$default(uri, "/episodes/", false, 2, (Object) null)) {
            String title = StringsKt.substringAfter$default(uri, getMainUrl() + "/episodes/", (String) null, 2, (Object) null);
            MatchResult matchResultFind$default = Regex.find$default(new Regex("(.+?)-season"), title, 0, 2, (Object) null);
            if (matchResultFind$default != null && (groupValues2 = matchResultFind$default.getGroupValues()) != null) {
                str = (String) groupValues2.get(1);
            }
            String title2 = String.valueOf(str);
            return getMainUrl() + "/tvshows/" + title2;
        }
        if (StringsKt.contains$default(uri, "/seasons/", false, 2, (Object) null)) {
            String title3 = StringsKt.substringAfter$default(uri, getMainUrl() + "/seasons/", (String) null, 2, (Object) null);
            MatchResult matchResultFind$default2 = Regex.find$default(new Regex("(.+?)-season"), title3, 0, 2, (Object) null);
            if (matchResultFind$default2 != null && (groupValues = matchResultFind$default2.getGroupValues()) != null) {
                str = (String) groupValues.get(1);
            }
            String title4 = String.valueOf(str);
            return getMainUrl() + "/tvshows/" + title4;
        }
        return uri;
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String title;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("h3 > a");
        if (elementSelectFirst == null || (title = elementSelectFirst.text()) == null) {
            return null;
        }
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("h3 > a");
        Intrinsics.checkNotNull(elementSelectFirst2);
        String href = getProperLink(MainAPIKt.fixUrl(this, elementSelectFirst2.attr("href")));
        final Ref.ObjectRef posterUrl = new Ref.ObjectRef();
        Element elementLast = $this$toSearchResult.select("div.poster img").last();
        posterUrl.element = elementLast != null ? getImageAttr(elementLast) : null;
        if (posterUrl.element != null && StringsKt.contains$default((CharSequence) posterUrl.element, ".gif", false, 2, (Object) null)) {
            posterUrl.element = MainAPIKt.fixUrlNull(this, $this$toSearchResult.select("div.poster img").attr("data-wpfc-original-src"));
        }
        final SearchQuality quality = getSearchQuality($this$toSearchResult.select("span.quality").text());
        final String score = $this$toSearchResult.select("div.rating").text();
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Hdmovie2.Hdmovie2$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Hdmovie2.toSearchResult$lambda$0(posterUrl, quality, score, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(Ref.ObjectRef $posterUrl, SearchQuality $quality, String $score, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl((String) $posterUrl.element);
        $this$newMovieSearchResponse.setQuality($quality);
        $this$newMovieSearchResponse.setScore(Score.Companion.from10($score));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00101 c00101;
        String query2;
        String strText;
        Hdmovie2 hdmovie2 = this;
        if (continuation instanceof C00101) {
            c00101 = (C00101) continuation;
            if ((c00101.label & Integer.MIN_VALUE) != 0) {
                c00101.label -= Integer.MIN_VALUE;
            } else {
                c00101 = hdmovie2.new C00101(continuation);
            }
        } else {
            c00101 = hdmovie2.new C00101(continuation);
        }
        Object $result = c00101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00101.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = hdmovie2.getMainUrl() + "/search/" + query;
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
        Iterable $this$mapNotNull$iv = document.select("article");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            Element titleElement = it.selectFirst("div.title > a, h2.result-title > a");
            String strNewMovieSearchResponse$default = null;
            if (titleElement != null) {
                String typeStr = "";
                String title = StringsKt.trim(new Regex("\\(\\d{4}\\)").replace(titleElement.text(), "")).toString();
                String href = hdmovie2.getProperLink(titleElement.attr("href"));
                Element elementSelectFirst = it.selectFirst("img");
                final String posterUrl = elementSelectFirst != null ? elementSelectFirst.attr("src") : null;
                Element elementSelectFirst2 = it.selectFirst(".result-type");
                if (elementSelectFirst2 != null && (strText = elementSelectFirst2.text()) != null) {
                    typeStr = strText;
                }
                TvType tvType = StringsKt.contains(typeStr, "Movie", true) ? TvType.Movie : TvType.TvSeries;
                strNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(this, title, href, tvType, false, new Function1() { // from class: com.Hdmovie2.Hdmovie2$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj) {
                        return Hdmovie2.search$lambda$0$0(posterUrl, (MovieSearchResponse) obj);
                    }
                }, 8, (Object) null);
            }
            if (strNewMovieSearchResponse$default != null) {
                destination$iv$iv.add(strNewMovieSearchResponse$default);
            }
            hdmovie2 = this;
            document = document;
            $this$mapNotNull$iv = $this$mapNotNull$iv;
            query2 = query2;
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:103:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:109:0x04eb  */
    /* JADX WARN: Code duplicated, block: B:112:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:113:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:115:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:128:0x053c  */
    /* JADX WARN: Code duplicated, block: B:133:0x0558  */
    /* JADX WARN: Code duplicated, block: B:136:0x057b  */
    /* JADX WARN: Code duplicated, block: B:138:0x0591  */
    /* JADX WARN: Code duplicated, block: B:139:0x0598  */
    /* JADX WARN: Code duplicated, block: B:142:0x05d1  */
    /* JADX WARN: Code duplicated, block: B:145:0x05ef  */
    /* JADX WARN: Code duplicated, block: B:148:0x060d  */
    /* JADX WARN: Code duplicated, block: B:150:0x0623  */
    /* JADX WARN: Code duplicated, block: B:151:0x062a  */
    /* JADX WARN: Code duplicated, block: B:154:0x0663  */
    /* JADX WARN: Code duplicated, block: B:157:0x0681  */
    /* JADX WARN: Code duplicated, block: B:160:0x069f  */
    /* JADX WARN: Code duplicated, block: B:162:0x06b5  */
    /* JADX WARN: Code duplicated, block: B:163:0x06bf  */
    /* JADX WARN: Code duplicated, block: B:165:0x06e1  */
    /* JADX WARN: Code duplicated, block: B:166:0x06e3  */
    /* JADX WARN: Code duplicated, block: B:168:0x06e9  */
    /* JADX WARN: Code duplicated, block: B:169:0x06ee  */
    /* JADX WARN: Code duplicated, block: B:172:0x06ff  */
    /* JADX WARN: Code duplicated, block: B:177:0x079c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:178:0x079d  */
    /* JADX WARN: Code duplicated, block: B:180:0x07ba  */
    /* JADX WARN: Code duplicated, block: B:183:0x07e6  */
    /* JADX WARN: Code duplicated, block: B:185:0x07fc  */
    /* JADX WARN: Code duplicated, block: B:186:0x0801  */
    /* JADX WARN: Code duplicated, block: B:189:0x0815  */
    /* JADX WARN: Code duplicated, block: B:195:0x0825  */
    /* JADX WARN: Code duplicated, block: B:198:0x082a  */
    /* JADX WARN: Code duplicated, block: B:199:0x0837  */
    /* JADX WARN: Code duplicated, block: B:201:0x083d  */
    /* JADX WARN: Code duplicated, block: B:215:0x0890  */
    /* JADX WARN: Code duplicated, block: B:220:0x08a8  */
    /* JADX WARN: Code duplicated, block: B:221:0x08af  */
    /* JADX WARN: Code duplicated, block: B:225:0x094c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:226:0x094d  */
    /* JADX WARN: Code duplicated, block: B:239:0x05d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:242:0x0667 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:247:0x0703 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x013c  */
    /* JADX WARN: Code duplicated, block: B:253:0x0246 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:254:0x0240 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x014d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0152  */
    /* JADX WARN: Code duplicated, block: B:31:0x0162  */
    /* JADX WARN: Code duplicated, block: B:32:0x0167  */
    /* JADX WARN: Code duplicated, block: B:36:0x018e A[LOOP:0: B:34:0x0188->B:36:0x018e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:42:0x01df  */
    /* JADX WARN: Code duplicated, block: B:45:0x0201  */
    /* JADX WARN: Code duplicated, block: B:50:0x0218  */
    /* JADX WARN: Code duplicated, block: B:53:0x0222  */
    /* JADX WARN: Code duplicated, block: B:56:0x0242 A[LOOP:10: B:51:0x021c->B:56:0x0242, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:60:0x024a  */
    /* JADX WARN: Code duplicated, block: B:61:0x024d  */
    /* JADX WARN: Code duplicated, block: B:64:0x026e  */
    /* JADX WARN: Code duplicated, block: B:65:0x0275  */
    /* JADX WARN: Code duplicated, block: B:68:0x027f  */
    /* JADX WARN: Code duplicated, block: B:69:0x0286  */
    /* JADX WARN: Code duplicated, block: B:73:0x02aa A[LOOP:1: B:71:0x02a4->B:73:0x02aa, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x0318  */
    /* JADX WARN: Code duplicated, block: B:79:0x0369  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x036e  */
    /* JADX WARN: Code duplicated, block: B:84:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:86:0x03be  */
    /* JADX WARN: Code duplicated, block: B:89:0x03de  */
    /* JADX WARN: Code duplicated, block: B:91:0x0414  */
    /* JADX WARN: Code duplicated, block: B:92:0x0419  */
    /* JADX WARN: Code duplicated, block: B:95:0x04b8  */
    /* JADX WARN: Code duplicated, block: B:97:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:99:0x04d1  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00031 c00031;
        Object obj;
        Object obj2;
        String url2;
        NiceResponse request;
        Document document;
        Element elementSelectFirst;
        String string;
        String title;
        Element elementSelectFirst2;
        String imageAttr;
        String background;
        Element elementSelectFirst3;
        String imageAttr2;
        String posterUrl;
        Collection destination$iv$iv;
        List tags;
        boolean z;
        MatchResult matchResultFind$default;
        String str;
        Integer year;
        TvType tvType;
        TvType tvType2;
        String description;
        Element elementSelectFirst4;
        String trailer;
        Element elementSelectFirst5;
        String rating;
        Iterable $this$map$iv;
        Collection destination$iv$iv2;
        String title2;
        String url3;
        List actors;
        Iterable $this$map$iv2;
        int $i$f$map;
        Collection destination$iv$iv3;
        List recommendations;
        String str2;
        String str3;
        String str4;
        String str5;
        Iterable $this$mapNotNull$iv;
        Collection destination$iv$iv4;
        Object objNewMovieLoadResponse;
        Document document2;
        String posterUrl2;
        Integer year2;
        String background2;
        String description2;
        List tags2;
        String rating2;
        List actors2;
        List recommendations2;
        String hrefs;
        String title3;
        TvType tvType3;
        Element elementSelectFirst6;
        String strText;
        String post;
        Element elementSelectFirst7;
        String str6;
        String str7;
        String str8;
        String post2;
        String strSubstringAfter$default;
        String post3;
        Iterable $this$firstOrNull$iv;
        Object obj3;
        Element elementSelectFirst8;
        String source;
        String str9;
        boolean z2;
        Iterable $this$mapNotNull$iv2;
        int $i$f$mapNotNull;
        Collection destination$iv$iv5;
        Iterable $this$mapNotNullTo$iv$iv;
        int $i$f$mapNotNullTo;
        TvType tvType4;
        List episodes;
        Element a;
        int $i$f$mapNotNull2;
        String source2;
        Iterable $this$mapNotNullTo$iv$iv2;
        int $i$f$mapNotNullTo2;
        TvType tvType5;
        Element elementSelectFirst9;
        final String name;
        Episode episodeNewEpisode;
        Element elementFirst;
        String strAttr;
        Element elementSelectFirst10;
        String str10;
        Iterable iterableClassNames;
        Object element$iv;
        boolean check;
        Iterable $this$mapNotNull$iv3;
        int $i$f$mapNotNull3;
        Collection destination$iv$iv6;
        Iterable $this$mapNotNullTo$iv$iv3;
        int $i$f$mapNotNullTo3;
        Element elementSelectFirst11;
        String name2;
        Episode episodeNewEpisode2;
        Iterable $this$mapNotNull$iv4;
        int $i$f$mapNotNull4;
        Collection destination$iv$iv7;
        Iterable $this$mapNotNullTo$iv$iv4;
        Element elementSelectFirst12;
        String name3;
        Episode episodeNewEpisode3;
        String str11;
        boolean z3;
        Object objNewTvSeriesLoadResponse;
        Iterable $this$map$iv3;
        int $i$f$map2;
        Collection destination$iv$iv8;
        Iterable $this$mapTo$iv$iv;
        int $i$f$mapTo;
        Iterator it;
        Element elementSelectFirst13;
        final String image;
        Element elementSelectFirst14;
        final String recPosterUrl;
        Iterable $this$any$iv;
        Iterator it2;
        List groupValues;
        String strText2;
        Hdmovie2 hdmovie2 = this;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = hdmovie2.new C00031(continuation);
            }
        } else {
            c00031 = hdmovie2.new C00031(continuation);
        }
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                Requests app = MainActivityKt.getApp();
                c00032.L$0 = url;
                c00032.label = 1;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00032, 4094, (Object) null);
                c00032 = c00032;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                request = (NiceResponse) obj2;
                document = request.getDocument();
                hdmovie2.directUrl = hdmovie2.getBaseUrl(request.getUrl());
                elementSelectFirst = document.selectFirst("div.data > h1");
                if (elementSelectFirst != null || (strText2 = elementSelectFirst.text()) == null) {
                    string = null;
                } else {
                    string = StringsKt.trim(strText2).toString();
                }
                title = String.valueOf(string);
                Hdmovie2 hdmovie3 = hdmovie2;
                elementSelectFirst2 = document.selectFirst(".playbox img.cover, .dooplay-player .play .overlay-player img.cover");
                if (elementSelectFirst2 != null) {
                    imageAttr = hdmovie2.getImageAttr(elementSelectFirst2);
                } else {
                    imageAttr = null;
                }
                background = MainAPIKt.fixUrlNull(hdmovie3, imageAttr);
                Hdmovie2 hdmovie4 = hdmovie2;
                elementSelectFirst3 = document.selectFirst("div.poster img");
                if (elementSelectFirst3 != null) {
                    imageAttr2 = hdmovie2.getImageAttr(elementSelectFirst3);
                } else {
                    imageAttr2 = null;
                }
                posterUrl = MainAPIKt.fixUrlNull(hdmovie4, imageAttr2);
                Iterable $this$map$iv4 = document.select("div.sgeneros > a");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                for (Object item$iv$iv : $this$map$iv4) {
                    destination$iv$iv.add(((Element) item$iv$iv).text());
                }
                tags = (List) destination$iv$iv;
                z = false;
                matchResultFind$default = Regex.find$default(new Regex(",\\s?(\\d+)"), StringsKt.trim(document.select("span.date").text()).toString(), 0, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
                    str = null;
                } else {
                    str = (String) groupValues.get(1);
                }
                year = StringsKt.toIntOrNull(String.valueOf(str));
                if (StringsKt.contains(document.select("ul#section > li:first-child").text(), "Episodes", true)) {
                    tvType = TvType.TvSeries;
                } else {
                    $this$any$iv = document.select(".options .dooplay_player_option .title");
                    if (($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                        it2 = $this$any$iv.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = false;
                            } else if (new Regex("\\b(?:Episode\\s*\\d+|EP\\s*\\d+|E\\d{1,3}|S\\d{1,2}E\\d{1,3})\\b", RegexOption.IGNORE_CASE).containsMatchIn(((Element) it2.next()).text())) {
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        tvType = TvType.TvSeries;
                    } else {
                        tvType = TvType.Movie;
                    }
                }
                tvType2 = tvType;
                description = StringsKt.trim(document.select("div.wp-content > p").text()).toString();
                elementSelectFirst4 = document.selectFirst("div.embed iframe");
                if (elementSelectFirst4 != null) {
                    trailer = elementSelectFirst4.attr("src");
                } else {
                    trailer = null;
                }
                elementSelectFirst5 = document.selectFirst("span.dt_rating_vgs");
                if (elementSelectFirst5 != null) {
                    rating = elementSelectFirst5.text();
                } else {
                    rating = null;
                }
                $this$map$iv = document.select("div.persons > div[itemprop=actor]");
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv2 : $this$map$iv) {
                    Object $result2 = $result;
                    Element it3 = (Element) item$iv$iv2;
                    destination$iv$iv2.add(new Actor(it3.select("meta[itemprop=name]").attr("content"), it3.select("img:last-child").attr("src")));
                    $this$map$iv = $this$map$iv;
                    $result = $result2;
                    title = title;
                    url2 = url2;
                }
                title2 = title;
                url3 = url2;
                actors = (List) destination$iv$iv2;
                $this$map$iv2 = document.select("div.owl-item");
                $i$f$map = 0;
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv3 : $this$map$iv2) {
                    Element it4 = (Element) item$iv$iv3;
                    Iterable $this$map$iv5 = $this$map$iv2;
                    Element elementSelectFirst15 = it4.selectFirst("a");
                    Intrinsics.checkNotNull(elementSelectFirst15);
                    int $i$f$map3 = $i$f$map;
                    String recName = (String) CollectionsKt.last(StringsKt.split$default(StringsKt.removeSuffix(elementSelectFirst15.attr("href"), "/"), new String[]{"/"}, false, 0, 6, (Object) null));
                    Element elementSelectFirst16 = it4.selectFirst("a");
                    Intrinsics.checkNotNull(elementSelectFirst16);
                    String recHref = elementSelectFirst16.attr("href");
                    elementSelectFirst14 = it4.selectFirst("img");
                    if (elementSelectFirst14 != null) {
                        recPosterUrl = hdmovie2.getImageAttr(elementSelectFirst14);
                    } else {
                        recPosterUrl = null;
                    }
                    destination$iv$iv3.add(MainAPIKt.newTvSeriesSearchResponse$default(hdmovie2, recName, recHref, TvType.TvSeries, false, new Function1() { // from class: com.Hdmovie2.Hdmovie2$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj4) {
                            return Hdmovie2.load$lambda$3$0(recPosterUrl, (TvSeriesSearchResponse) obj4);
                        }
                    }, 8, (Object) null));
                    $this$map$iv2 = $this$map$iv5;
                    $i$f$map = $i$f$map3;
                }
                recommendations = (List) destination$iv$iv3;
                str2 = "body";
                str3 = "null";
                str4 = "data-post";
                str5 = "data-type";
                if (tvType2 == TvType.TvSeries) {
                    AppUtils appUtils = AppUtils.INSTANCE;
                    $this$mapNotNull$iv = document.select(".dooplay_player_option, ul#playeroptionsul > li");
                    destination$iv$iv4 = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        Iterable $this$mapNotNull$iv5 = $this$mapNotNull$iv;
                        Element it5 = (Element) element$iv$iv$iv;
                        elementSelectFirst6 = it5.selectFirst("span.title");
                        if (elementSelectFirst6 != null) {
                            strText = elementSelectFirst6.text();
                        } else {
                            strText = null;
                        }
                        String name4 = strText;
                        String type = it5.attr(str5);
                        String str12 = str5;
                        post = it5.attr(str4);
                        if (Intrinsics.areEqual(post, str3)) {
                            elementSelectFirst7 = document.selectFirst(str2);
                            if (elementSelectFirst7 != null || ($this$firstOrNull$iv = elementSelectFirst7.classNames()) == null) {
                                str6 = str2;
                                str7 = str3;
                                str8 = str4;
                                post2 = null;
                            } else {
                                Iterator it6 = $this$firstOrNull$iv.iterator();
                                while (true) {
                                    if (it6.hasNext()) {
                                        Object element$iv2 = it6.next();
                                        str6 = str2;
                                        str7 = str3;
                                        str8 = str4;
                                        String post4 = post;
                                        if (StringsKt.startsWith$default((String) element$iv2, "postid-", false, 2, (Object) null)) {
                                            obj3 = element$iv2;
                                        } else {
                                            str4 = str8;
                                            str2 = str6;
                                            str3 = str7;
                                            post = post4;
                                        }
                                    } else {
                                        str6 = str2;
                                        str7 = str3;
                                        str8 = str4;
                                        obj3 = null;
                                    }
                                }
                                String str13 = (String) obj3;
                                if (str13 != null) {
                                    post2 = null;
                                    strSubstringAfter$default = StringsKt.substringAfter$default(str13, "postid-", (String) null, 2, (Object) null);
                                } else {
                                    post2 = null;
                                }
                                post3 = strSubstringAfter$default;
                            }
                            strSubstringAfter$default = post2;
                            post3 = strSubstringAfter$default;
                        } else {
                            str9 = post;
                            if (str9 != null || str9.length() == 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                elementSelectFirst7 = document.selectFirst(str2);
                                if (elementSelectFirst7 != null) {
                                    str6 = str2;
                                    str7 = str3;
                                    str8 = str4;
                                    post2 = null;
                                    strSubstringAfter$default = post2;
                                } else {
                                    str6 = str2;
                                    str7 = str3;
                                    str8 = str4;
                                    post2 = null;
                                    strSubstringAfter$default = post2;
                                }
                                post3 = strSubstringAfter$default;
                            } else {
                                str6 = str2;
                                str7 = str3;
                                str8 = str4;
                                post3 = post;
                                post2 = null;
                            }
                        }
                        String nume = it5.attr("data-nume");
                        elementSelectFirst8 = it5.selectFirst("a");
                        if (elementSelectFirst8 != null) {
                            source = elementSelectFirst8.attr("data-source");
                        } else {
                            source = post2;
                        }
                        destination$iv$iv4.add(new LinkData(name4, type, post3, nume, source));
                        $this$mapNotNull$iv = $this$mapNotNull$iv5;
                        str4 = str8;
                        str5 = str12;
                        str2 = str6;
                        str3 = str7;
                    }
                    String hrefs2 = appUtils.toJson((List) destination$iv$iv4);
                    TvType tvType6 = TvType.Movie;
                    C00053 c00053 = new C00053(posterUrl, year, background, description, tags, rating, actors, recommendations, trailer, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(request);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(document);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(background);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(posterUrl);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(year);
                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(description);
                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(trailer);
                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(rating);
                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(actors);
                    c00032.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00032.L$14 = SpillingKt.nullOutSpilledVariable(hrefs2);
                    c00032.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2, url3, tvType6, hrefs2, c00053, c00032);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    document2 = document;
                    posterUrl2 = posterUrl;
                    year2 = year;
                    background2 = background;
                    description2 = description;
                    tags2 = tags;
                    rating2 = rating;
                    actors2 = actors;
                    recommendations2 = recommendations;
                    hrefs = trailer;
                    title3 = title2;
                    tvType3 = tvType2;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                if (!document.select("ul.episodios > li").isEmpty()) {
                    $this$map$iv3 = document.select("ul.episodios > li");
                    $i$f$map2 = 0;
                    destination$iv$iv8 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                    $this$mapTo$iv$iv = $this$map$iv3;
                    $i$f$mapTo = 0;
                    for (it = $this$mapTo$iv$iv.iterator(); it.hasNext(); it = it) {
                        Object item$iv$iv4 = it.next();
                        Element it7 = (Element) item$iv$iv4;
                        Iterable $this$map$iv6 = $this$map$iv3;
                        String href = it7.select("a").attr("href");
                        int $i$f$map4 = $i$f$map2;
                        final String name5 = MainAPIKt.fixTitle(StringsKt.trim(it7.select("div.episodiotitle > a").text()).toString());
                        Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                        elementSelectFirst13 = it7.selectFirst("div.imagen > img");
                        if (elementSelectFirst13 != null) {
                            image = hdmovie2.getImageAttr(elementSelectFirst13);
                        } else {
                            image = null;
                        }
                        final Integer episode = StringsKt.toIntOrNull((String) CollectionsKt.last(StringsKt.split$default(StringsKt.replace$default(it7.select("div.numerando").text(), " ", "", false, 4, (Object) null), new String[]{"-"}, false, 0, 6, (Object) null)));
                        final Integer season = StringsKt.toIntOrNull((String) CollectionsKt.first(StringsKt.split$default(StringsKt.replace$default(it7.select("div.numerando").text(), " ", "", false, 4, (Object) null), new String[]{"-"}, false, 0, 6, (Object) null)));
                        destination$iv$iv8.add(MainAPIKt.newEpisode(this, href, new Function1() { // from class: com.Hdmovie2.Hdmovie2$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj4) {
                                return Hdmovie2.load$lambda$4$0(name5, episode, season, image, (Episode) obj4);
                            }
                        }));
                        hdmovie2 = this;
                        $this$map$iv3 = $this$map$iv6;
                        $i$f$map2 = $i$f$map4;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                        $i$f$mapTo = $i$f$mapTo;
                    }
                    episodes = (List) destination$iv$iv8;
                    tvType4 = tvType2;
                } else if (document.select("ul#playeroptionsul > li").isEmpty()) {
                    $this$mapNotNull$iv2 = document.select(".dooplay_player .options ul li, #video-sources .options ul li");
                    $i$f$mapNotNull = 0;
                    destination$iv$iv5 = new ArrayList();
                    $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv2;
                    $i$f$mapNotNullTo = 0;
                    for (Object element$iv$iv$iv2 : $this$mapNotNullTo$iv$iv) {
                        Iterable $this$mapNotNull$iv6 = $this$mapNotNull$iv2;
                        a = ((Element) element$iv$iv$iv2).selectFirst("a");
                        if (a == null) {
                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                            $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                            $i$f$mapNotNullTo2 = $i$f$mapNotNullTo;
                            tvType5 = tvType2;
                            episodeNewEpisode = null;
                        } else {
                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                            source2 = a.attr("data-source");
                            $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                            $i$f$mapNotNullTo2 = $i$f$mapNotNullTo;
                            tvType5 = tvType2;
                            if (StringsKt.contains(source2, "youtube", true)) {
                                episodeNewEpisode = null;
                            } else {
                                elementSelectFirst9 = a.selectFirst("span.title");
                                if (elementSelectFirst9 != null) {
                                    name = elementSelectFirst9.text();
                                } else {
                                    name = null;
                                }
                                episodeNewEpisode = MainAPIKt.newEpisode(this, source2, new Function1() { // from class: com.Hdmovie2.Hdmovie2$$ExternalSyntheticLambda5
                                    public final Object invoke(Object obj4) {
                                        return Hdmovie2.load$lambda$8$0(name, (Episode) obj4);
                                    }
                                });
                            }
                        }
                        if (episodeNewEpisode != null) {
                            destination$iv$iv5.add(episodeNewEpisode);
                        }
                        $this$mapNotNull$iv2 = $this$mapNotNull$iv6;
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                        tvType2 = tvType5;
                        $i$f$mapNotNullTo = $i$f$mapNotNullTo2;
                    }
                    tvType4 = tvType2;
                    episodes = (List) destination$iv$iv5;
                } else {
                    elementFirst = document.select("ul#playeroptionsul > li").first();
                    if (elementFirst != null) {
                        strAttr = elementFirst.attr("data-post");
                    } else {
                        strAttr = null;
                    }
                    if (Intrinsics.areEqual(strAttr, "null")) {
                        elementSelectFirst10 = document.selectFirst("body");
                        if (elementSelectFirst10 == null && (iterableClassNames = elementSelectFirst10.classNames()) != null) {
                            Iterable $this$firstOrNull$iv2 = iterableClassNames;
                            int $i$f$firstOrNull = 0;
                            Iterator it8 = $this$firstOrNull$iv2.iterator();
                            while (true) {
                                if (it8.hasNext()) {
                                    element$iv = it8.next();
                                    Iterable $this$firstOrNull$iv3 = $this$firstOrNull$iv2;
                                    String str14 = strAttr;
                                    int $i$f$firstOrNull2 = $i$f$firstOrNull;
                                    if (!StringsKt.startsWith$default((String) element$iv, "postid-", false, 2, (Object) null)) {
                                        $this$firstOrNull$iv2 = $this$firstOrNull$iv3;
                                        strAttr = str14;
                                        $i$f$firstOrNull = $i$f$firstOrNull2;
                                    }
                                } else {
                                    element$iv = null;
                                }
                            }
                            String str15 = (String) element$iv;
                            String strSubstringAfter$default2 = str15 != null ? StringsKt.substringAfter$default(str15, "postid-", (String) null, 2, (Object) null) : null;
                            str10 = strSubstringAfter$default2;
                        }
                        str10 = strSubstringAfter$default2;
                    } else {
                        str11 = strAttr;
                        if (str11 != null || str11.length() == 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            elementSelectFirst10 = document.selectFirst("body");
                            if (elementSelectFirst10 == null) {
                            }
                            str10 = strSubstringAfter$default2;
                        } else {
                            str10 = strAttr;
                        }
                    }
                    check = StringsKt.contains$default(document.select("ul#playeroptionsul > li").toString(), "Super", false, 2, (Object) null);
                    if (check) {
                        $this$mapNotNull$iv4 = CollectionsKt.drop(document.select("ul#playeroptionsul > li"), 1);
                        $i$f$mapNotNull4 = 0;
                        destination$iv$iv7 = new ArrayList();
                        $this$mapNotNullTo$iv$iv4 = $this$mapNotNull$iv4;
                        for (Object element$iv$iv$iv3 : $this$mapNotNullTo$iv$iv4) {
                            Iterable $this$mapNotNull$iv7 = $this$mapNotNull$iv4;
                            Element it9 = (Element) element$iv$iv$iv3;
                            elementSelectFirst12 = it9.selectFirst("span.title");
                            if (elementSelectFirst12 != null) {
                                name3 = elementSelectFirst12.text();
                            } else {
                                name3 = null;
                            }
                            String type2 = it9.attr("data-type");
                            String nume2 = it9.attr("data-nume");
                            boolean check2 = check;
                            Iterable $this$mapNotNullTo$iv$iv5 = $this$mapNotNullTo$iv$iv4;
                            int $i$f$mapNotNull5 = $i$f$mapNotNull4;
                            final String name6 = name3;
                            episodeNewEpisode3 = MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(new LinkData(name3, type2, str10, nume2, null, 16, null)), new Function1() { // from class: com.Hdmovie2.Hdmovie2$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj4) {
                                    return Hdmovie2.load$lambda$6$0(name6, (Episode) obj4);
                                }
                            });
                            if (episodeNewEpisode3 != null) {
                                destination$iv$iv7.add(episodeNewEpisode3);
                            }
                            $this$mapNotNull$iv4 = $this$mapNotNull$iv7;
                            $this$mapNotNullTo$iv$iv4 = $this$mapNotNullTo$iv$iv5;
                            $i$f$mapNotNull4 = $i$f$mapNotNull5;
                            check = check2;
                        }
                        episodes = (List) destination$iv$iv7;
                        tvType4 = tvType2;
                    } else {
                        $this$mapNotNull$iv3 = document.select("ul#playeroptionsul > li");
                        $i$f$mapNotNull3 = 0;
                        destination$iv$iv6 = new ArrayList();
                        $this$mapNotNullTo$iv$iv3 = $this$mapNotNull$iv3;
                        $i$f$mapNotNullTo3 = 0;
                        for (Object element$iv$iv$iv4 : $this$mapNotNullTo$iv$iv3) {
                            Iterable $this$mapNotNull$iv8 = $this$mapNotNull$iv3;
                            Element it10 = (Element) element$iv$iv$iv4;
                            elementSelectFirst11 = it10.selectFirst("span.title");
                            if (elementSelectFirst11 != null) {
                                name2 = elementSelectFirst11.text();
                            } else {
                                name2 = null;
                            }
                            String type3 = it10.attr("data-type");
                            String nume3 = it10.attr("data-nume");
                            int $i$f$mapNotNull6 = $i$f$mapNotNull3;
                            int $i$f$mapNotNullTo4 = $i$f$mapNotNullTo3;
                            Iterable $this$mapNotNullTo$iv$iv6 = $this$mapNotNullTo$iv$iv3;
                            final String name7 = name2;
                            episodeNewEpisode2 = MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(new LinkData(name2, type3, str10, nume3, null, 16, null)), new Function1() { // from class: com.Hdmovie2.Hdmovie2$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj4) {
                                    return Hdmovie2.load$lambda$7$0(name7, (Episode) obj4);
                                }
                            });
                            if (episodeNewEpisode2 != null) {
                                destination$iv$iv6.add(episodeNewEpisode2);
                            }
                            $this$mapNotNull$iv3 = $this$mapNotNull$iv8;
                            $i$f$mapNotNullTo3 = $i$f$mapNotNullTo4;
                            $this$mapNotNullTo$iv$iv3 = $this$mapNotNullTo$iv$iv6;
                            $i$f$mapNotNull3 = $i$f$mapNotNull6;
                        }
                        episodes = (List) destination$iv$iv6;
                        tvType4 = tvType2;
                    }
                }
                TvType tvType7 = TvType.TvSeries;
                C00042 c00042 = new C00042(posterUrl, background, year, description, tags, rating, actors, recommendations, trailer, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(request);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(document);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(background);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(posterUrl);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(year);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(tvType4);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(description);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(trailer);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(rating);
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(actors);
                c00032.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                c00032.L$14 = SpillingKt.nullOutSpilledVariable(episodes);
                c00032.label = 2;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, url3, tvType7, episodes, c00042, c00032);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 1:
                String url4 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url4;
                obj = coroutine_suspended;
                obj2 = $result;
                request = (NiceResponse) obj2;
                document = request.getDocument();
                hdmovie2.directUrl = hdmovie2.getBaseUrl(request.getUrl());
                elementSelectFirst = document.selectFirst("div.data > h1");
                if (elementSelectFirst != null) {
                    string = null;
                } else {
                    string = null;
                }
                title = String.valueOf(string);
                Hdmovie2 hdmovie5 = hdmovie2;
                elementSelectFirst2 = document.selectFirst(".playbox img.cover, .dooplay-player .play .overlay-player img.cover");
                if (elementSelectFirst2 != null) {
                    imageAttr = hdmovie2.getImageAttr(elementSelectFirst2);
                } else {
                    imageAttr = null;
                }
                background = MainAPIKt.fixUrlNull(hdmovie5, imageAttr);
                Hdmovie2 hdmovie6 = hdmovie2;
                elementSelectFirst3 = document.selectFirst("div.poster img");
                if (elementSelectFirst3 != null) {
                    imageAttr2 = hdmovie2.getImageAttr(elementSelectFirst3);
                } else {
                    imageAttr2 = null;
                }
                posterUrl = MainAPIKt.fixUrlNull(hdmovie6, imageAttr2);
                Iterable $this$map$iv7 = document.select("div.sgeneros > a");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv7, 10));
                while (r15.hasNext()) {
                    destination$iv$iv.add(((Element) item$iv$iv).text());
                }
                tags = (List) destination$iv$iv;
                z = false;
                matchResultFind$default = Regex.find$default(new Regex(",\\s?(\\d+)"), StringsKt.trim(document.select("span.date").text()).toString(), 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    str = null;
                } else {
                    str = null;
                }
                year = StringsKt.toIntOrNull(String.valueOf(str));
                if (StringsKt.contains(document.select("ul#section > li:first-child").text(), "Episodes", true)) {
                    $this$any$iv = document.select(".options .dooplay_player_option .title");
                    if ($this$any$iv instanceof Collection) {
                        it2 = $this$any$iv.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = false;
                            } else if (new Regex("\\b(?:Episode\\s*\\d+|EP\\s*\\d+|E\\d{1,3}|S\\d{1,2}E\\d{1,3})\\b", RegexOption.IGNORE_CASE).containsMatchIn(((Element) it2.next()).text())) {
                                z = true;
                            }
                        }
                    } else {
                        it2 = $this$any$iv.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = false;
                            } else if (new Regex("\\b(?:Episode\\s*\\d+|EP\\s*\\d+|E\\d{1,3}|S\\d{1,2}E\\d{1,3})\\b", RegexOption.IGNORE_CASE).containsMatchIn(((Element) it2.next()).text())) {
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        tvType = TvType.TvSeries;
                    } else {
                        tvType = TvType.Movie;
                    }
                } else {
                    tvType = TvType.TvSeries;
                }
                tvType2 = tvType;
                description = StringsKt.trim(document.select("div.wp-content > p").text()).toString();
                elementSelectFirst4 = document.selectFirst("div.embed iframe");
                if (elementSelectFirst4 != null) {
                    trailer = elementSelectFirst4.attr("src");
                } else {
                    trailer = null;
                }
                elementSelectFirst5 = document.selectFirst("span.dt_rating_vgs");
                if (elementSelectFirst5 != null) {
                    rating = elementSelectFirst5.text();
                } else {
                    rating = null;
                }
                $this$map$iv = document.select("div.persons > div[itemprop=actor]");
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r15.hasNext()) {
                    Object $result3 = $result;
                    Element it11 = (Element) item$iv$iv2;
                    destination$iv$iv2.add(new Actor(it11.select("meta[itemprop=name]").attr("content"), it11.select("img:last-child").attr("src")));
                    $this$map$iv = $this$map$iv;
                    $result = $result3;
                    title = title;
                    url2 = url2;
                }
                title2 = title;
                url3 = url2;
                actors = (List) destination$iv$iv2;
                $this$map$iv2 = document.select("div.owl-item");
                $i$f$map = 0;
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r7.hasNext()) {
                    Element it12 = (Element) item$iv$iv3;
                    Iterable $this$map$iv8 = $this$map$iv2;
                    Element elementSelectFirst17 = it12.selectFirst("a");
                    Intrinsics.checkNotNull(elementSelectFirst17);
                    int $i$f$map5 = $i$f$map;
                    String recName2 = (String) CollectionsKt.last(StringsKt.split$default(StringsKt.removeSuffix(elementSelectFirst17.attr("href"), "/"), new String[]{"/"}, false, 0, 6, (Object) null));
                    Element elementSelectFirst18 = it12.selectFirst("a");
                    Intrinsics.checkNotNull(elementSelectFirst18);
                    String recHref2 = elementSelectFirst18.attr("href");
                    elementSelectFirst14 = it12.selectFirst("img");
                    if (elementSelectFirst14 != null) {
                        recPosterUrl = hdmovie2.getImageAttr(elementSelectFirst14);
                    } else {
                        recPosterUrl = null;
                    }
                    destination$iv$iv3.add(MainAPIKt.newTvSeriesSearchResponse$default(hdmovie2, recName2, recHref2, TvType.TvSeries, false, new Function1() { // from class: com.Hdmovie2.Hdmovie2$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj4) {
                            return Hdmovie2.load$lambda$3$0(recPosterUrl, (TvSeriesSearchResponse) obj4);
                        }
                    }, 8, (Object) null));
                    $this$map$iv2 = $this$map$iv8;
                    $i$f$map = $i$f$map5;
                }
                recommendations = (List) destination$iv$iv3;
                str2 = "body";
                str3 = "null";
                str4 = "data-post";
                str5 = "data-type";
                if (tvType2 == TvType.TvSeries) {
                    AppUtils appUtils2 = AppUtils.INSTANCE;
                    $this$mapNotNull$iv = document.select(".dooplay_player_option, ul#playeroptionsul > li");
                    destination$iv$iv4 = new ArrayList();
                    while (r37.hasNext()) {
                        Iterable $this$mapNotNull$iv9 = $this$mapNotNull$iv;
                        Element it13 = (Element) element$iv$iv$iv;
                        elementSelectFirst6 = it13.selectFirst("span.title");
                        if (elementSelectFirst6 != null) {
                            strText = elementSelectFirst6.text();
                        } else {
                            strText = null;
                        }
                        String name8 = strText;
                        String type4 = it13.attr(str5);
                        String str16 = str5;
                        post = it13.attr(str4);
                        if (Intrinsics.areEqual(post, str3)) {
                            elementSelectFirst7 = document.selectFirst(str2);
                            if (elementSelectFirst7 != null) {
                                str6 = str2;
                                str7 = str3;
                                str8 = str4;
                                post2 = null;
                                strSubstringAfter$default = post2;
                            } else {
                                str6 = str2;
                                str7 = str3;
                                str8 = str4;
                                post2 = null;
                                strSubstringAfter$default = post2;
                            }
                            post3 = strSubstringAfter$default;
                        } else {
                            str9 = post;
                            if (str9 != null) {
                                z2 = true;
                            } else {
                                z2 = true;
                            }
                            if (z2) {
                                elementSelectFirst7 = document.selectFirst(str2);
                                if (elementSelectFirst7 != null) {
                                    str6 = str2;
                                    str7 = str3;
                                    str8 = str4;
                                    post2 = null;
                                    strSubstringAfter$default = post2;
                                } else {
                                    str6 = str2;
                                    str7 = str3;
                                    str8 = str4;
                                    post2 = null;
                                    strSubstringAfter$default = post2;
                                }
                                post3 = strSubstringAfter$default;
                            } else {
                                str6 = str2;
                                str7 = str3;
                                str8 = str4;
                                post3 = post;
                                post2 = null;
                            }
                        }
                        String nume4 = it13.attr("data-nume");
                        elementSelectFirst8 = it13.selectFirst("a");
                        if (elementSelectFirst8 != null) {
                            source = elementSelectFirst8.attr("data-source");
                        } else {
                            source = post2;
                        }
                        destination$iv$iv4.add(new LinkData(name8, type4, post3, nume4, source));
                        $this$mapNotNull$iv = $this$mapNotNull$iv9;
                        str4 = str8;
                        str5 = str16;
                        str2 = str6;
                        str3 = str7;
                    }
                    String hrefs3 = appUtils2.toJson((List) destination$iv$iv4);
                    TvType tvType8 = TvType.Movie;
                    C00053 c00054 = new C00053(posterUrl, year, background, description, tags, rating, actors, recommendations, trailer, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(request);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(document);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(background);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(posterUrl);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(year);
                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(description);
                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(trailer);
                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(rating);
                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(actors);
                    c00032.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00032.L$14 = SpillingKt.nullOutSpilledVariable(hrefs3);
                    c00032.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2, url3, tvType8, hrefs3, c00054, c00032);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    document2 = document;
                    posterUrl2 = posterUrl;
                    year2 = year;
                    background2 = background;
                    description2 = description;
                    tags2 = tags;
                    rating2 = rating;
                    actors2 = actors;
                    recommendations2 = recommendations;
                    hrefs = trailer;
                    title3 = title2;
                    tvType3 = tvType2;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                if (!document.select("ul.episodios > li").isEmpty()) {
                    $this$map$iv3 = document.select("ul.episodios > li");
                    $i$f$map2 = 0;
                    destination$iv$iv8 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                    $this$mapTo$iv$iv = $this$map$iv3;
                    $i$f$mapTo = 0;
                    while (it.hasNext()) {
                        Object item$iv$iv5 = it.next();
                        Element it14 = (Element) item$iv$iv5;
                        Iterable $this$map$iv9 = $this$map$iv3;
                        String href2 = it14.select("a").attr("href");
                        int $i$f$map6 = $i$f$map2;
                        final String name9 = MainAPIKt.fixTitle(StringsKt.trim(it14.select("div.episodiotitle > a").text()).toString());
                        Iterable $this$mapTo$iv$iv3 = $this$mapTo$iv$iv;
                        elementSelectFirst13 = it14.selectFirst("div.imagen > img");
                        if (elementSelectFirst13 != null) {
                            image = hdmovie2.getImageAttr(elementSelectFirst13);
                        } else {
                            image = null;
                        }
                        final Integer episode2 = StringsKt.toIntOrNull((String) CollectionsKt.last(StringsKt.split$default(StringsKt.replace$default(it14.select("div.numerando").text(), " ", "", false, 4, (Object) null), new String[]{"-"}, false, 0, 6, (Object) null)));
                        final Integer season2 = StringsKt.toIntOrNull((String) CollectionsKt.first(StringsKt.split$default(StringsKt.replace$default(it14.select("div.numerando").text(), " ", "", false, 4, (Object) null), new String[]{"-"}, false, 0, 6, (Object) null)));
                        destination$iv$iv8.add(MainAPIKt.newEpisode(this, href2, new Function1() { // from class: com.Hdmovie2.Hdmovie2$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj4) {
                                return Hdmovie2.load$lambda$4$0(name9, episode2, season2, image, (Episode) obj4);
                            }
                        }));
                        hdmovie2 = this;
                        $this$map$iv3 = $this$map$iv9;
                        $i$f$map2 = $i$f$map6;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv3;
                        $i$f$mapTo = $i$f$mapTo;
                    }
                    episodes = (List) destination$iv$iv8;
                    tvType4 = tvType2;
                } else if (document.select("ul#playeroptionsul > li").isEmpty()) {
                    elementFirst = document.select("ul#playeroptionsul > li").first();
                    if (elementFirst != null) {
                        strAttr = elementFirst.attr("data-post");
                    } else {
                        strAttr = null;
                    }
                    if (Intrinsics.areEqual(strAttr, "null")) {
                        elementSelectFirst10 = document.selectFirst("body");
                        if (elementSelectFirst10 == null) {
                        }
                        str10 = strSubstringAfter$default2;
                    } else {
                        str11 = strAttr;
                        if (str11 != null) {
                            z3 = true;
                        } else {
                            z3 = true;
                        }
                        if (z3) {
                            elementSelectFirst10 = document.selectFirst("body");
                            if (elementSelectFirst10 == null) {
                            }
                            str10 = strSubstringAfter$default2;
                        } else {
                            str10 = strAttr;
                        }
                    }
                    check = StringsKt.contains$default(document.select("ul#playeroptionsul > li").toString(), "Super", false, 2, (Object) null);
                    if (check) {
                        $this$mapNotNull$iv4 = CollectionsKt.drop(document.select("ul#playeroptionsul > li"), 1);
                        $i$f$mapNotNull4 = 0;
                        destination$iv$iv7 = new ArrayList();
                        $this$mapNotNullTo$iv$iv4 = $this$mapNotNull$iv4;
                        while (r15.hasNext()) {
                            Iterable $this$mapNotNull$iv10 = $this$mapNotNull$iv4;
                            Element it15 = (Element) element$iv$iv$iv3;
                            elementSelectFirst12 = it15.selectFirst("span.title");
                            if (elementSelectFirst12 != null) {
                                name3 = elementSelectFirst12.text();
                            } else {
                                name3 = null;
                            }
                            String type5 = it15.attr("data-type");
                            String nume5 = it15.attr("data-nume");
                            boolean check3 = check;
                            Iterable $this$mapNotNullTo$iv$iv7 = $this$mapNotNullTo$iv$iv4;
                            int $i$f$mapNotNull7 = $i$f$mapNotNull4;
                            final String name10 = name3;
                            episodeNewEpisode3 = MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(new LinkData(name3, type5, str10, nume5, null, 16, null)), new Function1() { // from class: com.Hdmovie2.Hdmovie2$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj4) {
                                    return Hdmovie2.load$lambda$6$0(name10, (Episode) obj4);
                                }
                            });
                            if (episodeNewEpisode3 != null) {
                                destination$iv$iv7.add(episodeNewEpisode3);
                            }
                            $this$mapNotNull$iv4 = $this$mapNotNull$iv10;
                            $this$mapNotNullTo$iv$iv4 = $this$mapNotNullTo$iv$iv7;
                            $i$f$mapNotNull4 = $i$f$mapNotNull7;
                            check = check3;
                        }
                        episodes = (List) destination$iv$iv7;
                        tvType4 = tvType2;
                    } else {
                        $this$mapNotNull$iv3 = document.select("ul#playeroptionsul > li");
                        $i$f$mapNotNull3 = 0;
                        destination$iv$iv6 = new ArrayList();
                        $this$mapNotNullTo$iv$iv3 = $this$mapNotNull$iv3;
                        $i$f$mapNotNullTo3 = 0;
                        while (r14.hasNext()) {
                            Iterable $this$mapNotNull$iv11 = $this$mapNotNull$iv3;
                            Element it16 = (Element) element$iv$iv$iv4;
                            elementSelectFirst11 = it16.selectFirst("span.title");
                            if (elementSelectFirst11 != null) {
                                name2 = elementSelectFirst11.text();
                            } else {
                                name2 = null;
                            }
                            String type6 = it16.attr("data-type");
                            String nume6 = it16.attr("data-nume");
                            int $i$f$mapNotNull8 = $i$f$mapNotNull3;
                            int $i$f$mapNotNullTo5 = $i$f$mapNotNullTo3;
                            Iterable $this$mapNotNullTo$iv$iv8 = $this$mapNotNullTo$iv$iv3;
                            final String name11 = name2;
                            episodeNewEpisode2 = MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(new LinkData(name2, type6, str10, nume6, null, 16, null)), new Function1() { // from class: com.Hdmovie2.Hdmovie2$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj4) {
                                    return Hdmovie2.load$lambda$7$0(name11, (Episode) obj4);
                                }
                            });
                            if (episodeNewEpisode2 != null) {
                                destination$iv$iv6.add(episodeNewEpisode2);
                            }
                            $this$mapNotNull$iv3 = $this$mapNotNull$iv11;
                            $i$f$mapNotNullTo3 = $i$f$mapNotNullTo5;
                            $this$mapNotNullTo$iv$iv3 = $this$mapNotNullTo$iv$iv8;
                            $i$f$mapNotNull3 = $i$f$mapNotNull8;
                        }
                        episodes = (List) destination$iv$iv6;
                        tvType4 = tvType2;
                    }
                } else {
                    $this$mapNotNull$iv2 = document.select(".dooplay_player .options ul li, #video-sources .options ul li");
                    $i$f$mapNotNull = 0;
                    destination$iv$iv5 = new ArrayList();
                    $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv2;
                    $i$f$mapNotNullTo = 0;
                    while (r13.hasNext()) {
                        Iterable $this$mapNotNull$iv12 = $this$mapNotNull$iv2;
                        a = ((Element) element$iv$iv$iv2).selectFirst("a");
                        if (a == null) {
                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                            $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                            $i$f$mapNotNullTo2 = $i$f$mapNotNullTo;
                            tvType5 = tvType2;
                            episodeNewEpisode = null;
                        } else {
                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                            source2 = a.attr("data-source");
                            $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                            $i$f$mapNotNullTo2 = $i$f$mapNotNullTo;
                            tvType5 = tvType2;
                            if (StringsKt.contains(source2, "youtube", true)) {
                                episodeNewEpisode = null;
                            } else {
                                elementSelectFirst9 = a.selectFirst("span.title");
                                if (elementSelectFirst9 != null) {
                                    name = elementSelectFirst9.text();
                                } else {
                                    name = null;
                                }
                                episodeNewEpisode = MainAPIKt.newEpisode(this, source2, new Function1() { // from class: com.Hdmovie2.Hdmovie2$$ExternalSyntheticLambda5
                                    public final Object invoke(Object obj4) {
                                        return Hdmovie2.load$lambda$8$0(name, (Episode) obj4);
                                    }
                                });
                            }
                        }
                        if (episodeNewEpisode != null) {
                            destination$iv$iv5.add(episodeNewEpisode);
                        }
                        $this$mapNotNull$iv2 = $this$mapNotNull$iv12;
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                        tvType2 = tvType5;
                        $i$f$mapNotNullTo = $i$f$mapNotNullTo2;
                    }
                    tvType4 = tvType2;
                    episodes = (List) destination$iv$iv5;
                }
                TvType tvType9 = TvType.TvSeries;
                C00042 c00043 = new C00042(posterUrl, background, year, description, tags, rating, actors, recommendations, trailer, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(request);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(document);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(background);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(posterUrl);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(year);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(tvType4);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(description);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(trailer);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(rating);
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(actors);
                c00032.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                c00032.L$14 = SpillingKt.nullOutSpilledVariable(episodes);
                c00032.label = 2;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, url3, tvType9, episodes, c00043, c00032);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 2:
                ResultKt.throwOnFailure($result);
                objNewTvSeriesLoadResponse = $result;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 3:
                recommendations2 = (List) c00032.L$13;
                actors2 = (List) c00032.L$12;
                rating2 = (String) c00032.L$11;
                hrefs = (String) c00032.L$10;
                description2 = (String) c00032.L$9;
                tvType3 = (TvType) c00032.L$8;
                year2 = (Integer) c00032.L$7;
                tags2 = (List) c00032.L$6;
                posterUrl2 = (String) c00032.L$5;
                background2 = (String) c00032.L$4;
                title3 = (String) c00032.L$3;
                Document document3 = (Document) c00032.L$2;
                String url5 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                url3 = url5;
                objNewMovieLoadResponse = $result;
                document2 = document3;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$3$0(String $recPosterUrl, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($recPosterUrl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$4$0(String $name, Integer $episode, Integer $season, String $image, Episode $this$newEpisode) {
        $this$newEpisode.setName($name);
        $this$newEpisode.setEpisode($episode);
        $this$newEpisode.setSeason($season);
        $this$newEpisode.setPosterUrl($image);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$6$0(String $name, Episode $this$newEpisode) {
        $this$newEpisode.setName($name);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$7$0(String $name, Episode $this$newEpisode) {
        $this$newEpisode.setName($name);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$8$0(String $name, Episode $this$newEpisode) {
        $this$newEpisode.setName($name);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Hdmovie2.Hdmovie2$load$2 */
    /* JADX INFO: compiled from: Hdmovie2.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Hdmovie2.Hdmovie2$load$2", f = "Hdmovie2.kt", i = {0}, l = {252}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {253}, s = {"L$0"}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Actor> $actors;
        final /* synthetic */ String $background;
        final /* synthetic */ String $description;
        final /* synthetic */ String $posterUrl;
        final /* synthetic */ String $rating;
        final /* synthetic */ List<TvSeriesSearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(String str, String str2, Integer num, String str3, List<String> list, String str4, List<Actor> list2, List<TvSeriesSearchResponse> list3, String str5, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$posterUrl = str;
            this.$background = str2;
            this.$year = num;
            this.$description = str3;
            this.$tags = list;
            this.$rating = str4;
            this.$actors = list2;
            this.$recommendations = list3;
            this.$trailer = str5;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(this.$posterUrl, this.$background, this.$year, this.$description, this.$tags, this.$rating, this.$actors, this.$recommendations, this.$trailer, continuation);
            c00042.L$0 = obj;
            return c00042;
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
                    loadResponse.setPosterUrl(this.$posterUrl);
                    loadResponse.setBackgroundPosterUrl(this.$background);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setScore(Score.Companion.from10(this.$rating));
                    LoadResponse.Companion.addActorsOnly(loadResponse, this.$actors);
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

    /* JADX INFO: renamed from: com.Hdmovie2.Hdmovie2$load$3 */
    /* JADX INFO: compiled from: Hdmovie2.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Hdmovie2.Hdmovie2$load$3", f = "Hdmovie2.kt", i = {0}, l = {276}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {277}, s = {"L$0"}, v = 2)
    static final class C00053 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Actor> $actors;
        final /* synthetic */ String $background;
        final /* synthetic */ String $description;
        final /* synthetic */ String $posterUrl;
        final /* synthetic */ String $rating;
        final /* synthetic */ List<TvSeriesSearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00053(String str, Integer num, String str2, String str3, List<String> list, String str4, List<Actor> list2, List<TvSeriesSearchResponse> list3, String str5, Continuation<? super C00053> continuation) {
            super(2, continuation);
            this.$posterUrl = str;
            this.$year = num;
            this.$background = str2;
            this.$description = str3;
            this.$tags = list;
            this.$rating = str4;
            this.$actors = list2;
            this.$recommendations = list3;
            this.$trailer = str5;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00053 = new C00053(this.$posterUrl, this.$year, this.$background, this.$description, this.$tags, this.$rating, this.$actors, this.$recommendations, this.$trailer, continuation);
            c00053.L$0 = obj;
            return c00053;
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
                    loadResponse.setPosterUrl(this.$posterUrl);
                    loadResponse.setYear(this.$year);
                    loadResponse.setBackgroundPosterUrl(this.$background);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setScore(Score.Companion.from10(this.$rating));
                    LoadResponse.Companion.addActorsOnly(loadResponse, this.$actors);
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

    private final String getBaseUrl(String url) {
        Url it = URLUtilsKt.Url(url);
        return it.getProtocol().getName() + "://" + it.getHost();
    }

    /* JADX WARN: Code duplicated, block: B:129:0x046b  */
    /* JADX WARN: Code duplicated, block: B:131:0x0472  */
    /* JADX WARN: Code duplicated, block: B:133:0x047e  */
    /* JADX WARN: Code duplicated, block: B:134:0x0480  */
    /* JADX WARN: Code duplicated, block: B:137:0x0487  */
    /* JADX WARN: Code duplicated, block: B:140:0x048e  */
    /* JADX WARN: Code duplicated, block: B:143:0x04c7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:144:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:147:0x04da  */
    /* JADX WARN: Code duplicated, block: B:149:0x0518 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:150:0x0519  */
    /* JADX WARN: Code duplicated, block: B:168:0x061b  */
    /* JADX WARN: Code duplicated, block: B:183:0x0671  */
    /* JADX WARN: Code duplicated, block: B:187:0x0688  */
    /* JADX WARN: Code duplicated, block: B:190:0x06d1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:191:0x06d2  */
    /* JADX WARN: Code duplicated, block: B:193:0x06e4  */
    /* JADX WARN: Code duplicated, block: B:195:0x06f8  */
    /* JADX WARN: Code duplicated, block: B:196:0x0701  */
    /* JADX WARN: Code duplicated, block: B:199:0x0710  */
    /* JADX WARN: Code duplicated, block: B:205:0x071f  */
    /* JADX WARN: Code duplicated, block: B:208:0x0723  */
    /* JADX WARN: Code duplicated, block: B:209:0x0727  */
    /* JADX WARN: Code duplicated, block: B:211:0x072d  */
    /* JADX WARN: Code duplicated, block: B:224:0x077b  */
    /* JADX WARN: Code duplicated, block: B:229:0x0785  */
    /* JADX WARN: Code duplicated, block: B:231:0x078a  */
    /* JADX WARN: Code duplicated, block: B:233:0x0799  */
    /* JADX WARN: Code duplicated, block: B:234:0x079b  */
    /* JADX WARN: Code duplicated, block: B:238:0x07be A[LOOP:1: B:236:0x07b8->B:238:0x07be, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:241:0x0823 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:242:0x0824  */
    /* JADX WARN: Code duplicated, block: B:246:0x0848  */
    /* JADX WARN: Code duplicated, block: B:248:0x08a0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:249:0x08a1  */
    /* JADX WARN: Code duplicated, block: B:252:0x08b9  */
    /* JADX WARN: Code duplicated, block: B:253:0x08c0  */
    /* JADX WARN: Code duplicated, block: B:256:0x08c5  */
    /* JADX WARN: Code duplicated, block: B:258:0x0925 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:259:0x0926  */
    /* JADX WARN: Code duplicated, block: B:262:0x098a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:264:0x099a  */
    /* JADX WARN: Code duplicated, block: B:267:0x09a5  */
    /* JADX WARN: Code duplicated, block: B:287:0x02f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:56:0x0309 A[Catch: Exception -> 0x0323, TRY_LEAVE, TryCatch #13 {Exception -> 0x0323, blocks: (B:37:0x02b6, B:44:0x02e7, B:47:0x02ee, B:56:0x0309, B:55:0x0303, B:43:0x02dc, B:36:0x02ac, B:40:0x02bd, B:50:0x02f4), top: B:284:0x02ac, inners: #11, #16 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00061 c00061;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Object $result;
        String str;
        String data2;
        boolean z;
        String str2;
        Object obj;
        C00061 c00062;
        String data3;
        Function1<? super SubtitleFile, Unit> function5;
        Function1<? super ExtractorLink, Unit> function6;
        Object obj2;
        Map commonHeaders;
        String ajaxUrl;
        boolean isCasting2;
        String ajaxUrl2;
        boolean isCasting3;
        Map commonHeaders2;
        String ajaxUrl3;
        Map commonHeaders3;
        Object obj3;
        Object objDecodeFromString;
        Object obj4;
        Map commonHeaders4;
        String value$iv$iv;
        LinkData loadData;
        String post;
        String str3;
        String nume;
        String type;
        Function1<? super SubtitleFile, Unit> function7;
        Function1<? super ExtractorLink, Unit> function8;
        Object $result2;
        boolean z2;
        Object obj5;
        int i;
        Object objLoadLinks$fetchSource;
        String source;
        Map commonHeaders5;
        String ajaxUrl4;
        Hdmovie2 hdmovie2;
        LinkData loadData2;
        Map commonHeaders6;
        Object obj6;
        Object objDecodeFromString2;
        Object obj7;
        DeserializationStrategy deserializationStrategy;
        boolean z3;
        String source2;
        String str4;
        Map commonHeaders7;
        String ajaxUrl5;
        Function1<? super ExtractorLink, Unit> function9;
        Function1<? super SubtitleFile, Unit> function10;
        String ajaxUrl6;
        String data4;
        Function1<? super ExtractorLink, Unit> function11;
        Object obj8;
        Function1<? super SubtitleFile, Unit> function12;
        Map commonHeaders8;
        Document document;
        Elements playerOptions;
        Ref.ObjectRef id;
        Element elementSelectFirst;
        String strAttr;
        Element elementSelectFirst2;
        Function1<? super ExtractorLink, Unit> function13;
        boolean z4;
        Iterable iterableClassNames;
        Object element$iv;
        String type2;
        Collection destination$iv$iv;
        Function1<? super SubtitleFile, Unit> function14;
        Function1<? super ExtractorLink, Unit> function15;
        Object objAmap;
        Function1<? super SubtitleFile, Unit> function16;
        Object obj9;
        Function1<? super ExtractorLink, Unit> function17;
        String ajaxUrl7;
        Map commonHeaders9;
        String data5;
        CharSequence charSequence;
        boolean z5;
        Element elementSelectFirst3;
        String str5;
        Elements playerOptions2;
        boolean z6;
        int i2;
        String str6;
        String post_id;
        Object objAmap2;
        Object obj10;
        String ajaxUrl8;
        String data6;
        Iterable iterableClassNames2;
        Object element$iv2;
        Function1<? super SubtitleFile, Unit> function18;
        Function1<? super ExtractorLink, Unit> function19;
        Object obj11;
        String ajaxUrl9;
        Function1<? super SubtitleFile, Unit> function20;
        String ajaxUrl10;
        Function1<? super ExtractorLink, Unit> function21;
        String str7;
        Element elementSelectFirst4;
        String strAttr2;
        String directLinks;
        Function1<? super SubtitleFile, Unit> function22;
        Function1<? super ExtractorLink, Unit> function23;
        String str8;
        boolean isCasting4;
        String it;
        Map commonHeaders10;
        String data7;
        String ajaxUrl11;
        String directLinks2;
        Function1<? super ExtractorLink, Unit> function24;
        Function1<? super SubtitleFile, Unit> function25;
        Object objAmap3;
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
        C00061 c00063 = c00061;
        Object $result3 = c00063.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str9 = "p > a";
        switch (c00063.label) {
            case 0:
                ResultKt.throwOnFailure($result3);
                String ajaxUrl12 = this.directUrl + "/wp-admin/admin-ajax.php";
                Map commonHeaders11 = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "*/*"), TuplesKt.to("X-Requested-With", "XMLHttpRequest")});
                if (StringsKt.startsWith$default(data, "[", false, 2, (Object) null)) {
                    AppUtils appUtils = AppUtils.INSTANCE;
                    if (data != null) {
                        try {
                            Result.Companion companion = Result.Companion;
                            commonHeaders6 = commonHeaders11;
                            try {
                                KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LinkData.class)));
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj6 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                break;
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    Result.Companion companion2 = Result.Companion;
                                    obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Exception e) {
                                    objDecodeFromString2 = null;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            commonHeaders6 = commonHeaders11;
                        }
                        if (Result.exceptionOrNull-impl(obj6) == null) {
                            if (Result.isFailure-impl(obj6)) {
                                obj6 = null;
                            }
                            deserializationStrategy = (KSerializer) obj6;
                            if (deserializationStrategy != null) {
                                try {
                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                                } catch (SerializationException e2) {
                                    ArchComponentExtKt.logError(e2);
                                    ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                    objDecodeFromString2 = $this$readValue$iv$iv$iv.readValue(data, new TypeReference<List<? extends LinkData>>() { // from class: com.Hdmovie2.Hdmovie2$loadLinks$$inlined$tryParseJson$1
                                    });
                                } catch (Throwable th3) {
                                    ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                    objDecodeFromString2 = $this$readValue$iv$iv$iv2.readValue(data, new TypeReference<List<? extends LinkData>>() { // from class: com.Hdmovie2.Hdmovie2$loadLinks$$inlined$tryParseJson$1
                                    });
                                }
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv$iv3.readValue(data, new TypeReference<List<? extends LinkData>>() { // from class: com.Hdmovie2.Hdmovie2$loadLinks$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                obj6 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            } catch (Throwable th4) {
                                Result.Companion companion4 = Result.Companion;
                                obj6 = Result.constructor-impl(ResultKt.createFailure(th4));
                            }
                            if (Result.isFailure-impl(obj6)) {
                                obj6 = null;
                            }
                            deserializationStrategy = (KSerializer) obj6;
                            if (deserializationStrategy != null) {
                                objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv$iv4.readValue(data, new TypeReference<List<? extends LinkData>>() { // from class: com.Hdmovie2.Hdmovie2$loadLinks$$inlined$tryParseJson$1
                                });
                            }
                        }
                        obj7 = objDecodeFromString2;
                        break;
                    } else {
                        commonHeaders6 = commonHeaders11;
                        obj7 = null;
                    }
                    List loadDataList = (List) obj7;
                    if (loadDataList == null) {
                        return Boxing.boxBoolean(false);
                    }
                    Map commonHeaders12 = commonHeaders6;
                    z3 = true;
                    C00072 c00072 = new C00072(function1, function2, ajaxUrl12, commonHeaders12, data, null);
                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00063.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00063.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl12);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders12);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(loadDataList);
                    c00063.Z$0 = isCasting;
                    c00063.label = 1;
                    return ParCollectionsKt.amap(loadDataList, c00072, c00063) == coroutine_suspended ? coroutine_suspended : Boxing.boxBoolean(z3);
                }
                if (StringsKt.startsWith$default(data, "{", false, 2, (Object) null)) {
                    AppUtils appUtils2 = AppUtils.INSTANCE;
                    if (data != null) {
                        try {
                            try {
                                Result.Companion companion5 = Result.Companion;
                                KType kTypeTypeOf2 = Reflection.typeOf(LinkData.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                            } catch (Throwable th5) {
                                Result.Companion companion6 = Result.Companion;
                                obj3 = Result.constructor-impl(ResultKt.createFailure(th5));
                            }
                            if (Result.exceptionOrNull-impl(obj3) == null) {
                                ajaxUrl3 = ajaxUrl12;
                                commonHeaders3 = commonHeaders11;
                                commonHeaders4 = null;
                            } else {
                                try {
                                    Result.Companion companion7 = Result.Companion;
                                    ajaxUrl3 = ajaxUrl12;
                                    try {
                                        commonHeaders3 = commonHeaders11;
                                        commonHeaders4 = null;
                                        try {
                                            obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LinkData.class), (List) null, 2, (Object) null));
                                            break;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            try {
                                                Result.Companion companion8 = Result.Companion;
                                                obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                            } catch (Exception e3) {
                                                objDecodeFromString = null;
                                            }
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        commonHeaders3 = commonHeaders11;
                                        commonHeaders4 = null;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    ajaxUrl3 = ajaxUrl12;
                                    commonHeaders3 = commonHeaders11;
                                    commonHeaders4 = null;
                                }
                            }
                            if (Result.isFailure-impl(obj3)) {
                                obj3 = commonHeaders4;
                            }
                            DeserializationStrategy deserializationStrategy2 = (KSerializer) obj3;
                            if (deserializationStrategy2 != null) {
                                try {
                                    value$iv$iv = data;
                                    try {
                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv$iv);
                                    } catch (SerializationException e4) {
                                        e$iv$iv = e4;
                                        ArchComponentExtKt.logError((Throwable) e$iv$iv);
                                        ObjectMapper $this$readValue$iv$iv$iv5 = MainAPIKt.getMapper();
                                        String content$iv$iv$iv = value$iv$iv;
                                        objDecodeFromString = $this$readValue$iv$iv$iv5.readValue(content$iv$iv$iv, new TypeReference<LinkData>() { // from class: com.Hdmovie2.Hdmovie2$loadLinks$$inlined$tryParseJson$2
                                        });
                                    } catch (Throwable th9) {
                                        ObjectMapper $this$readValue$iv$iv$iv6 = MainAPIKt.getMapper();
                                        String content$iv$iv$iv2 = value$iv$iv;
                                        objDecodeFromString = $this$readValue$iv$iv$iv6.readValue(content$iv$iv$iv2, new TypeReference<LinkData>() { // from class: com.Hdmovie2.Hdmovie2$loadLinks$$inlined$tryParseJson$2
                                        });
                                    }
                                } catch (SerializationException e5) {
                                    e$iv$iv = e5;
                                    value$iv$iv = data;
                                } catch (Throwable th10) {
                                    value$iv$iv = data;
                                }
                                obj4 = objDecodeFromString;
                            } else {
                                value$iv$iv = data;
                            }
                            ObjectMapper $this$readValue$iv$iv$iv7 = MainAPIKt.getMapper();
                            String content$iv$iv$iv3 = value$iv$iv;
                            objDecodeFromString = $this$readValue$iv$iv$iv7.readValue(content$iv$iv$iv3, new TypeReference<LinkData>() { // from class: com.Hdmovie2.Hdmovie2$loadLinks$$inlined$tryParseJson$2
                            });
                        } catch (Exception e6) {
                            ajaxUrl3 = ajaxUrl12;
                            commonHeaders3 = commonHeaders11;
                            objDecodeFromString = null;
                            obj4 = objDecodeFromString;
                            loadData = (LinkData) obj4;
                            if (loadData == null) {
                                return Boxing.boxBoolean(false);
                            }
                            post = loadData.getPost();
                            if (post == null) {
                                str3 = "";
                            } else {
                                str3 = post;
                            }
                            nume = loadData.getNume();
                            if (nume == null) {
                                nume = "";
                            }
                            type = loadData.getType();
                            if (type == null) {
                                type = "";
                            }
                            c00063.L$0 = data;
                            c00063.L$1 = function1;
                            c00063.L$2 = function2;
                            c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl3);
                            c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders3);
                            c00063.L$5 = SpillingKt.nullOutSpilledVariable(loadData);
                            c00063.Z$0 = isCasting;
                            c00063.label = 2;
                            function7 = function1;
                            function8 = function2;
                            $result2 = $result3;
                            Map commonHeaders13 = commonHeaders3;
                            z2 = false;
                            obj5 = null;
                            i = 2;
                            String str10 = nume;
                            String ajaxUrl13 = ajaxUrl3;
                            objLoadLinks$fetchSource = loadLinks$fetchSource(ajaxUrl13, commonHeaders13, data, this, str3, str10, type, c00063);
                            source = ajaxUrl13;
                            commonHeaders5 = commonHeaders13;
                            ajaxUrl4 = data;
                            hdmovie2 = this;
                            if (objLoadLinks$fetchSource == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            loadData2 = loadData;
                            isCasting3 = isCasting;
                            source2 = (String) objLoadLinks$fetchSource;
                            if (!StringsKt.contains$default(source2, "youtube", z2, i, obj5)) {
                                str4 = hdmovie2.directUrl + '/';
                                c00063.L$0 = ajaxUrl4;
                                c00063.L$1 = function7;
                                c00063.L$2 = function8;
                                c00063.L$3 = SpillingKt.nullOutSpilledVariable(source);
                                c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders5);
                                c00063.L$5 = SpillingKt.nullOutSpilledVariable(loadData2);
                                c00063.L$6 = SpillingKt.nullOutSpilledVariable(source2);
                                c00063.Z$0 = isCasting3;
                                c00063.label = 3;
                                if (ExtractorApiKt.loadExtractor(source2, str4, function7, function8, c00063) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                commonHeaders7 = commonHeaders5;
                                ajaxUrl5 = source;
                                function9 = function8;
                                function10 = function7;
                                source = ajaxUrl5;
                                commonHeaders5 = commonHeaders7;
                                function8 = function9;
                                function7 = function10;
                            }
                            Unit unit = Unit.INSTANCE;
                            ajaxUrl6 = source;
                            data4 = ajaxUrl4;
                            function11 = function8;
                            obj8 = coroutine_suspended;
                            function12 = function7;
                            str2 = str9;
                            z = true;
                            commonHeaders8 = commonHeaders5;
                            c00062 = c00063;
                            if (!StringsKt.contains$default(data4, "hdmovie2", false, 2, (Object) null)) {
                                return Boxing.boxBoolean(z);
                            }
                            Requests app = MainActivityKt.getApp();
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                            c00062.L$1 = function12;
                            c00062.L$2 = function11;
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl6);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                            c00062.L$5 = null;
                            c00062.L$6 = null;
                            c00062.L$7 = null;
                            c00062.L$8 = null;
                            c00062.Z$0 = isCasting3;
                            c00062.label = 8;
                            function18 = function12;
                            function19 = function11;
                            C00061 c00064 = c00062;
                            obj11 = obj8;
                            $result3 = Requests.get$default(app, data4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00064, 4094, (Object) null);
                            c00063 = c00064;
                            if ($result3 == obj11) {
                                return obj11;
                            }
                            String str11 = ajaxUrl6;
                            ajaxUrl9 = data4;
                            function20 = function18;
                            ajaxUrl10 = str11;
                            function21 = function19;
                            str7 = str2;
                            elementSelectFirst4 = ((NiceResponse) $result3).getDocument().selectFirst(str7);
                            if (elementSelectFirst4 != null) {
                                strAttr2 = elementSelectFirst4.attr("href");
                            } else {
                                strAttr2 = null;
                            }
                            directLinks = strAttr2;
                            if (directLinks != null) {
                                Requests app2 = MainActivityKt.getApp();
                                c00063.L$0 = SpillingKt.nullOutSpilledVariable(ajaxUrl9);
                                c00063.L$1 = function20;
                                c00063.L$2 = function21;
                                c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl10);
                                c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                                c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks);
                                c00063.L$6 = SpillingKt.nullOutSpilledVariable(directLinks);
                                c00063.Z$0 = isCasting3;
                                c00063.label = 9;
                                function22 = function20;
                                function23 = function21;
                                C00061 c00065 = c00063;
                                str8 = str7;
                                $result3 = Requests.get$default(app2, directLinks, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00065, 4094, (Object) null);
                                c00063 = c00065;
                                if ($result3 == obj11) {
                                    return obj11;
                                }
                                isCasting4 = isCasting3;
                                it = directLinks;
                                commonHeaders10 = commonHeaders8;
                                data7 = ajaxUrl9;
                                ajaxUrl11 = ajaxUrl10;
                                directLinks2 = directLinks;
                                function24 = function23;
                                function25 = function22;
                                Document doc = ((NiceResponse) $result3).getDocument();
                                List listSelect = doc.select(str8);
                                Hdmovie2$loadLinks$7$1 hdmovie2$loadLinks$7$1 = new Hdmovie2$loadLinks$7$1(this, function25, function24, null);
                                c00063.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                                c00063.L$1 = SpillingKt.nullOutSpilledVariable(function25);
                                c00063.L$2 = SpillingKt.nullOutSpilledVariable(function24);
                                c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl11);
                                c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders10);
                                c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks2);
                                c00063.L$6 = SpillingKt.nullOutSpilledVariable(it);
                                c00063.L$7 = SpillingKt.nullOutSpilledVariable(doc);
                                c00063.Z$0 = isCasting4;
                                c00063.label = 10;
                                objAmap3 = ParCollectionsKt.amap(listSelect, hdmovie2$loadLinks$7$1, c00063);
                                if (objAmap3 == obj11) {
                                    return obj11;
                                }
                            }
                            return Boxing.boxBoolean(z);
                        }
                        obj4 = objDecodeFromString;
                        break;
                    } else {
                        ajaxUrl3 = ajaxUrl12;
                        commonHeaders3 = commonHeaders11;
                        obj4 = null;
                    }
                    loadData = (LinkData) obj4;
                    if (loadData == null) {
                        return Boxing.boxBoolean(false);
                    }
                    post = loadData.getPost();
                    if (post == null) {
                        str3 = "";
                    } else {
                        str3 = post;
                    }
                    nume = loadData.getNume();
                    if (nume == null) {
                        nume = "";
                    }
                    type = loadData.getType();
                    if (type == null) {
                        type = "";
                    }
                    c00063.L$0 = data;
                    c00063.L$1 = function1;
                    c00063.L$2 = function2;
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl3);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders3);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(loadData);
                    c00063.Z$0 = isCasting;
                    c00063.label = 2;
                    function7 = function1;
                    function8 = function2;
                    $result2 = $result3;
                    Map commonHeaders14 = commonHeaders3;
                    z2 = false;
                    obj5 = null;
                    i = 2;
                    String str12 = nume;
                    String ajaxUrl14 = ajaxUrl3;
                    objLoadLinks$fetchSource = loadLinks$fetchSource(ajaxUrl14, commonHeaders14, data, this, str3, str12, type, c00063);
                    source = ajaxUrl14;
                    commonHeaders5 = commonHeaders14;
                    ajaxUrl4 = data;
                    hdmovie2 = this;
                    if (objLoadLinks$fetchSource == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    loadData2 = loadData;
                    isCasting3 = isCasting;
                    source2 = (String) objLoadLinks$fetchSource;
                    if (!StringsKt.contains$default(source2, "youtube", z2, i, obj5)) {
                        str4 = hdmovie2.directUrl + '/';
                        c00063.L$0 = ajaxUrl4;
                        c00063.L$1 = function7;
                        c00063.L$2 = function8;
                        c00063.L$3 = SpillingKt.nullOutSpilledVariable(source);
                        c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders5);
                        c00063.L$5 = SpillingKt.nullOutSpilledVariable(loadData2);
                        c00063.L$6 = SpillingKt.nullOutSpilledVariable(source2);
                        c00063.Z$0 = isCasting3;
                        c00063.label = 3;
                        if (ExtractorApiKt.loadExtractor(source2, str4, function7, function8, c00063) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        commonHeaders7 = commonHeaders5;
                        ajaxUrl5 = source;
                        function9 = function8;
                        function10 = function7;
                        source = ajaxUrl5;
                        commonHeaders5 = commonHeaders7;
                        function8 = function9;
                        function7 = function10;
                    }
                    Unit unit2 = Unit.INSTANCE;
                    ajaxUrl6 = source;
                    data4 = ajaxUrl4;
                    function11 = function8;
                    obj8 = coroutine_suspended;
                    function12 = function7;
                    str2 = str9;
                    z = true;
                    commonHeaders8 = commonHeaders5;
                    c00062 = c00063;
                    if (!StringsKt.contains$default(data4, "hdmovie2", false, 2, (Object) null)) {
                        return Boxing.boxBoolean(z);
                    }
                    Requests app3 = MainActivityKt.getApp();
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$1 = function12;
                    c00062.L$2 = function11;
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl6);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                    c00062.L$5 = null;
                    c00062.L$6 = null;
                    c00062.L$7 = null;
                    c00062.L$8 = null;
                    c00062.Z$0 = isCasting3;
                    c00062.label = 8;
                    function18 = function12;
                    function19 = function11;
                    C00061 c00066 = c00062;
                    obj11 = obj8;
                    $result3 = Requests.get$default(app3, data4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00066, 4094, (Object) null);
                    c00063 = c00066;
                    if ($result3 == obj11) {
                        return obj11;
                    }
                    String str13 = ajaxUrl6;
                    ajaxUrl9 = data4;
                    function20 = function18;
                    ajaxUrl10 = str13;
                    function21 = function19;
                    str7 = str2;
                    elementSelectFirst4 = ((NiceResponse) $result3).getDocument().selectFirst(str7);
                    if (elementSelectFirst4 != null) {
                        strAttr2 = elementSelectFirst4.attr("href");
                    } else {
                        strAttr2 = null;
                    }
                    directLinks = strAttr2;
                    if (directLinks != null) {
                        Requests app4 = MainActivityKt.getApp();
                        c00063.L$0 = SpillingKt.nullOutSpilledVariable(ajaxUrl9);
                        c00063.L$1 = function20;
                        c00063.L$2 = function21;
                        c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl10);
                        c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                        c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks);
                        c00063.L$6 = SpillingKt.nullOutSpilledVariable(directLinks);
                        c00063.Z$0 = isCasting3;
                        c00063.label = 9;
                        function22 = function20;
                        function23 = function21;
                        C00061 c00067 = c00063;
                        str8 = str7;
                        $result3 = Requests.get$default(app4, directLinks, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00067, 4094, (Object) null);
                        c00063 = c00067;
                        if ($result3 == obj11) {
                            return obj11;
                        }
                        isCasting4 = isCasting3;
                        it = directLinks;
                        commonHeaders10 = commonHeaders8;
                        data7 = ajaxUrl9;
                        ajaxUrl11 = ajaxUrl10;
                        directLinks2 = directLinks;
                        function24 = function23;
                        function25 = function22;
                        Document doc2 = ((NiceResponse) $result3).getDocument();
                        List listSelect2 = doc2.select(str8);
                        Hdmovie2$loadLinks$7$1 hdmovie2$loadLinks$7$2 = new Hdmovie2$loadLinks$7$1(this, function25, function24, null);
                        c00063.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                        c00063.L$1 = SpillingKt.nullOutSpilledVariable(function25);
                        c00063.L$2 = SpillingKt.nullOutSpilledVariable(function24);
                        c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl11);
                        c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders10);
                        c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks2);
                        c00063.L$6 = SpillingKt.nullOutSpilledVariable(it);
                        c00063.L$7 = SpillingKt.nullOutSpilledVariable(doc2);
                        c00063.Z$0 = isCasting4;
                        c00063.label = 10;
                        objAmap3 = ParCollectionsKt.amap(listSelect2, hdmovie2$loadLinks$7$2, c00063);
                        if (objAmap3 == obj11) {
                            return obj11;
                        }
                    }
                    return Boxing.boxBoolean(z);
                }
                function3 = function1;
                function4 = function2;
                $result = $result3;
                str = "p > a";
                data2 = data;
                if (!StringsKt.contains$default(data2, getMainUrl(), false, 2, (Object) null) && !StringsKt.contains$default(data2, this.directUrl, false, 2, (Object) null)) {
                    String str14 = this.directUrl + '/';
                    c00063.L$0 = data2;
                    c00063.L$1 = function3;
                    c00063.L$2 = function4;
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl12);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders11);
                    c00063.Z$0 = isCasting;
                    c00063.label = 4;
                    if (ExtractorApiKt.loadExtractor(data2, str14, function3, function4, c00063) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ajaxUrl2 = ajaxUrl12;
                    isCasting3 = isCasting;
                    commonHeaders2 = commonHeaders11;
                    ajaxUrl6 = ajaxUrl2;
                    data4 = data2;
                    obj8 = coroutine_suspended;
                    function12 = function3;
                    str2 = str;
                    z = true;
                    commonHeaders8 = commonHeaders2;
                    function11 = function4;
                    c00062 = c00063;
                    if (!StringsKt.contains$default(data4, "hdmovie2", false, 2, (Object) null)) {
                        return Boxing.boxBoolean(z);
                    }
                    Requests app5 = MainActivityKt.getApp();
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$1 = function12;
                    c00062.L$2 = function11;
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl6);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                    c00062.L$5 = null;
                    c00062.L$6 = null;
                    c00062.L$7 = null;
                    c00062.L$8 = null;
                    c00062.Z$0 = isCasting3;
                    c00062.label = 8;
                    function18 = function12;
                    function19 = function11;
                    C00061 c00068 = c00062;
                    obj11 = obj8;
                    $result3 = Requests.get$default(app5, data4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00068, 4094, (Object) null);
                    c00063 = c00068;
                    if ($result3 == obj11) {
                        return obj11;
                    }
                    String str15 = ajaxUrl6;
                    ajaxUrl9 = data4;
                    function20 = function18;
                    ajaxUrl10 = str15;
                    function21 = function19;
                    str7 = str2;
                    elementSelectFirst4 = ((NiceResponse) $result3).getDocument().selectFirst(str7);
                    if (elementSelectFirst4 != null) {
                        strAttr2 = elementSelectFirst4.attr("href");
                    } else {
                        strAttr2 = null;
                    }
                    directLinks = strAttr2;
                    if (directLinks != null) {
                        Requests app6 = MainActivityKt.getApp();
                        c00063.L$0 = SpillingKt.nullOutSpilledVariable(ajaxUrl9);
                        c00063.L$1 = function20;
                        c00063.L$2 = function21;
                        c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl10);
                        c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                        c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks);
                        c00063.L$6 = SpillingKt.nullOutSpilledVariable(directLinks);
                        c00063.Z$0 = isCasting3;
                        c00063.label = 9;
                        function22 = function20;
                        function23 = function21;
                        C00061 c00069 = c00063;
                        str8 = str7;
                        $result3 = Requests.get$default(app6, directLinks, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00069, 4094, (Object) null);
                        c00063 = c00069;
                        if ($result3 == obj11) {
                            return obj11;
                        }
                        isCasting4 = isCasting3;
                        it = directLinks;
                        commonHeaders10 = commonHeaders8;
                        data7 = ajaxUrl9;
                        ajaxUrl11 = ajaxUrl10;
                        directLinks2 = directLinks;
                        function24 = function23;
                        function25 = function22;
                        Document doc3 = ((NiceResponse) $result3).getDocument();
                        List listSelect3 = doc3.select(str8);
                        Hdmovie2$loadLinks$7$1 hdmovie2$loadLinks$7$3 = new Hdmovie2$loadLinks$7$1(this, function25, function24, null);
                        c00063.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                        c00063.L$1 = SpillingKt.nullOutSpilledVariable(function25);
                        c00063.L$2 = SpillingKt.nullOutSpilledVariable(function24);
                        c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl11);
                        c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders10);
                        c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks2);
                        c00063.L$6 = SpillingKt.nullOutSpilledVariable(it);
                        c00063.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                        c00063.Z$0 = isCasting4;
                        c00063.label = 10;
                        objAmap3 = ParCollectionsKt.amap(listSelect3, hdmovie2$loadLinks$7$3, c00063);
                        if (objAmap3 == obj11) {
                            return obj11;
                        }
                    }
                    return Boxing.boxBoolean(z);
                }
                Requests app7 = MainActivityKt.getApp();
                c00063.L$0 = data2;
                c00063.L$1 = function3;
                c00063.L$2 = function4;
                c00063.L$3 = ajaxUrl12;
                c00063.L$4 = commonHeaders11;
                c00063.Z$0 = isCasting;
                c00063.label = 5;
                z = true;
                str2 = str;
                obj = coroutine_suspended;
                Object obj12 = Requests.get$default(app7, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00063, 4094, (Object) null);
                c00062 = c00063;
                if (obj12 == obj) {
                    return obj;
                }
                data3 = data;
                function5 = function1;
                function6 = function2;
                obj2 = obj12;
                commonHeaders = commonHeaders11;
                ajaxUrl = ajaxUrl12;
                isCasting2 = isCasting;
                document = ((NiceResponse) obj2).getDocument();
                playerOptions = document.select(".dooplay_player .options ul li, #video-sources .options ul li");
                String str16 = "/movies/";
                if (((Collection) playerOptions).isEmpty()) {
                    obj8 = obj;
                    id = new Ref.ObjectRef();
                    elementSelectFirst = document.selectFirst("ul#playeroptionsul > li");
                    if (elementSelectFirst != null) {
                        strAttr = elementSelectFirst.attr("data-post");
                    } else {
                        strAttr = null;
                    }
                    id.element = strAttr;
                    if (Intrinsics.areEqual(id.element, "null")) {
                        elementSelectFirst2 = document.selectFirst("body");
                        if (elementSelectFirst2 != null || (iterableClassNames = elementSelectFirst2.classNames()) == null) {
                            function13 = function6;
                            z4 = false;
                        } else {
                            Iterable $this$firstOrNull$iv = iterableClassNames;
                            int $i$f$firstOrNull = 0;
                            Iterator it2 = $this$firstOrNull$iv.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    element$iv = it2.next();
                                    Iterable $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                                    String it3 = (String) element$iv;
                                    int $i$f$firstOrNull2 = $i$f$firstOrNull;
                                    function13 = function6;
                                    Iterator it4 = it2;
                                    z4 = false;
                                    if (!StringsKt.startsWith$default(it3, "postid-", false, 2, (Object) null)) {
                                        $this$firstOrNull$iv = $this$firstOrNull$iv2;
                                        it2 = it4;
                                        $i$f$firstOrNull = $i$f$firstOrNull2;
                                        function6 = function13;
                                    }
                                } else {
                                    function13 = function6;
                                    z4 = false;
                                    element$iv = null;
                                }
                            }
                            String str17 = (String) element$iv;
                            String strSubstringAfter$default = str17 != null ? StringsKt.substringAfter$default(str17, "postid-", (String) null, 2, (Object) null) : null;
                            id.element = strSubstringAfter$default;
                        }
                        id.element = strSubstringAfter$default;
                    } else {
                        charSequence = (CharSequence) id.element;
                        if (charSequence != null || charSequence.length() == 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            elementSelectFirst2 = document.selectFirst("body");
                            if (elementSelectFirst2 != null) {
                                function13 = function6;
                                z4 = false;
                            } else {
                                function13 = function6;
                                z4 = false;
                            }
                            id.element = strSubstringAfter$default;
                        } else {
                            function13 = function6;
                            z4 = false;
                        }
                    }
                    if (id.element == null) {
                        return Boxing.boxBoolean(z4);
                    }
                    if (StringsKt.contains$default(data3, "/movies/", z4, 2, (Object) null)) {
                        type2 = "movie";
                    } else {
                        type2 = "tv";
                    }
                    Iterable $this$map$iv = document.select("ul#playeroptionsul > li");
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        Element it5 = (Element) item$iv$iv;
                        destination$iv$iv.add(it5.attr("data-nume"));
                    }
                    ArrayList arrayList = (List) destination$iv$iv;
                    function14 = function5;
                    function15 = function13;
                    C00096 c00096 = new C00096(id, type2, this, function14, function15, ajaxUrl, commonHeaders, data3, null);
                    c00062.L$0 = data3;
                    c00062.L$1 = function14;
                    c00062.L$2 = function15;
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(document);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(playerOptions);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(id);
                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(type2);
                    c00062.Z$0 = isCasting2;
                    c00062.label = 7;
                    objAmap = ParCollectionsKt.amap(arrayList, c00096, c00062);
                    if (objAmap == obj8) {
                        return obj8;
                    }
                    function16 = function14;
                    obj9 = objAmap;
                    function17 = function15;
                    ajaxUrl7 = ajaxUrl;
                    commonHeaders9 = commonHeaders;
                    data5 = data3;
                    commonHeaders8 = commonHeaders9;
                    function11 = function17;
                    function12 = function16;
                    ajaxUrl6 = ajaxUrl7;
                    data4 = data5;
                    isCasting3 = isCasting2;
                    if (!StringsKt.contains$default(data4, "hdmovie2", false, 2, (Object) null)) {
                        return Boxing.boxBoolean(z);
                    }
                    Requests app8 = MainActivityKt.getApp();
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$1 = function12;
                    c00062.L$2 = function11;
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl6);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                    c00062.L$5 = null;
                    c00062.L$6 = null;
                    c00062.L$7 = null;
                    c00062.L$8 = null;
                    c00062.Z$0 = isCasting3;
                    c00062.label = 8;
                    function18 = function12;
                    function19 = function11;
                    C00061 c000610 = c00062;
                    obj11 = obj8;
                    $result3 = Requests.get$default(app8, data4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000610, 4094, (Object) null);
                    c00063 = c000610;
                    if ($result3 == obj11) {
                        return obj11;
                    }
                    String str18 = ajaxUrl6;
                    ajaxUrl9 = data4;
                    function20 = function18;
                    ajaxUrl10 = str18;
                    function21 = function19;
                    str7 = str2;
                    elementSelectFirst4 = ((NiceResponse) $result3).getDocument().selectFirst(str7);
                    if (elementSelectFirst4 != null) {
                        strAttr2 = elementSelectFirst4.attr("href");
                    } else {
                        strAttr2 = null;
                    }
                    directLinks = strAttr2;
                    if (directLinks != null) {
                        Requests app9 = MainActivityKt.getApp();
                        c00063.L$0 = SpillingKt.nullOutSpilledVariable(ajaxUrl9);
                        c00063.L$1 = function20;
                        c00063.L$2 = function21;
                        c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl10);
                        c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                        c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks);
                        c00063.L$6 = SpillingKt.nullOutSpilledVariable(directLinks);
                        c00063.Z$0 = isCasting3;
                        c00063.label = 9;
                        function22 = function20;
                        function23 = function21;
                        C00061 c000611 = c00063;
                        str8 = str7;
                        $result3 = Requests.get$default(app9, directLinks, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000611, 4094, (Object) null);
                        c00063 = c000611;
                        if ($result3 == obj11) {
                            return obj11;
                        }
                        isCasting4 = isCasting3;
                        it = directLinks;
                        commonHeaders10 = commonHeaders8;
                        data7 = ajaxUrl9;
                        ajaxUrl11 = ajaxUrl10;
                        directLinks2 = directLinks;
                        function24 = function23;
                        function25 = function22;
                        Document doc4 = ((NiceResponse) $result3).getDocument();
                        List listSelect4 = doc4.select(str8);
                        Hdmovie2$loadLinks$7$1 hdmovie2$loadLinks$7$4 = new Hdmovie2$loadLinks$7$1(this, function25, function24, null);
                        c00063.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                        c00063.L$1 = SpillingKt.nullOutSpilledVariable(function25);
                        c00063.L$2 = SpillingKt.nullOutSpilledVariable(function24);
                        c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl11);
                        c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders10);
                        c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks2);
                        c00063.L$6 = SpillingKt.nullOutSpilledVariable(it);
                        c00063.L$7 = SpillingKt.nullOutSpilledVariable(doc4);
                        c00063.Z$0 = isCasting4;
                        c00063.label = 10;
                        objAmap3 = ParCollectionsKt.amap(listSelect4, hdmovie2$loadLinks$7$4, c00063);
                        if (objAmap3 == obj11) {
                            return obj11;
                        }
                    }
                    return Boxing.boxBoolean(z);
                }
                elementSelectFirst3 = document.selectFirst("body");
                if (elementSelectFirst3 == null && (iterableClassNames2 = elementSelectFirst3.classNames()) != null) {
                    Iterable $this$firstOrNull$iv3 = iterableClassNames2;
                    int $i$f$firstOrNull3 = 0;
                    Iterator it6 = $this$firstOrNull$iv3.iterator();
                    while (true) {
                        if (it6.hasNext()) {
                            element$iv2 = it6.next();
                            Iterable $this$firstOrNull$iv4 = $this$firstOrNull$iv3;
                            String it7 = (String) element$iv2;
                            str5 = str16;
                            playerOptions2 = playerOptions;
                            int $i$f$firstOrNull4 = $i$f$firstOrNull3;
                            z6 = false;
                            i2 = 2;
                            str6 = null;
                            if (!StringsKt.startsWith$default(it7, "postid-", false, 2, (Object) null)) {
                                $this$firstOrNull$iv3 = $this$firstOrNull$iv4;
                                str16 = str5;
                                playerOptions = playerOptions2;
                                $i$f$firstOrNull3 = $i$f$firstOrNull4;
                            }
                        } else {
                            str5 = str16;
                            playerOptions2 = playerOptions;
                            z6 = false;
                            i2 = 2;
                            str6 = null;
                            element$iv2 = null;
                        }
                    }
                    String str19 = (String) element$iv2;
                    if (str19 != null) {
                        post_id = StringsKt.substringAfter$default(str19, "postid-", str6, i2, str6);
                    }
                    String post_id2 = post_id;
                    String post_id3 = str5;
                    String type3 = StringsKt.contains$default(data3, post_id3, z6, i2, str6) ? "movie" : "tv";
                    obj8 = obj;
                    C00083 c00083 = new C00083(function5, function6, post_id2, type3, ajaxUrl, commonHeaders, data3, null);
                    c00062.L$0 = data3;
                    c00062.L$1 = function5;
                    c00062.L$2 = function6;
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(document);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(playerOptions2);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(post_id2);
                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(type3);
                    c00062.Z$0 = isCasting2;
                    c00062.label = 6;
                    objAmap2 = ParCollectionsKt.amap((List) playerOptions2, c00083, c00062);
                    if (objAmap2 == obj8) {
                        return obj8;
                    }
                    obj10 = objAmap2;
                    ajaxUrl8 = ajaxUrl;
                    data6 = data3;
                    function12 = function5;
                    function11 = function6;
                    commonHeaders8 = commonHeaders;
                    ajaxUrl6 = ajaxUrl8;
                    data4 = data6;
                    isCasting3 = isCasting2;
                    if (!StringsKt.contains$default(data4, "hdmovie2", false, 2, (Object) null)) {
                        return Boxing.boxBoolean(z);
                    }
                    Requests app10 = MainActivityKt.getApp();
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$1 = function12;
                    c00062.L$2 = function11;
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl6);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                    c00062.L$5 = null;
                    c00062.L$6 = null;
                    c00062.L$7 = null;
                    c00062.L$8 = null;
                    c00062.Z$0 = isCasting3;
                    c00062.label = 8;
                    function18 = function12;
                    function19 = function11;
                    C00061 c000612 = c00062;
                    obj11 = obj8;
                    $result3 = Requests.get$default(app10, data4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000612, 4094, (Object) null);
                    c00063 = c000612;
                    if ($result3 == obj11) {
                        return obj11;
                    }
                    String str110 = ajaxUrl6;
                    ajaxUrl9 = data4;
                    function20 = function18;
                    ajaxUrl10 = str110;
                    function21 = function19;
                    str7 = str2;
                    elementSelectFirst4 = ((NiceResponse) $result3).getDocument().selectFirst(str7);
                    if (elementSelectFirst4 != null) {
                        strAttr2 = elementSelectFirst4.attr("href");
                    } else {
                        strAttr2 = null;
                    }
                    directLinks = strAttr2;
                    if (directLinks != null) {
                        Requests app11 = MainActivityKt.getApp();
                        c00063.L$0 = SpillingKt.nullOutSpilledVariable(ajaxUrl9);
                        c00063.L$1 = function20;
                        c00063.L$2 = function21;
                        c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl10);
                        c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                        c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks);
                        c00063.L$6 = SpillingKt.nullOutSpilledVariable(directLinks);
                        c00063.Z$0 = isCasting3;
                        c00063.label = 9;
                        function22 = function20;
                        function23 = function21;
                        C00061 c000613 = c00063;
                        str8 = str7;
                        $result3 = Requests.get$default(app11, directLinks, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000613, 4094, (Object) null);
                        c00063 = c000613;
                        if ($result3 == obj11) {
                            return obj11;
                        }
                        isCasting4 = isCasting3;
                        it = directLinks;
                        commonHeaders10 = commonHeaders8;
                        data7 = ajaxUrl9;
                        ajaxUrl11 = ajaxUrl10;
                        directLinks2 = directLinks;
                        function24 = function23;
                        function25 = function22;
                        Document doc5 = ((NiceResponse) $result3).getDocument();
                        List listSelect5 = doc5.select(str8);
                        Hdmovie2$loadLinks$7$1 hdmovie2$loadLinks$7$5 = new Hdmovie2$loadLinks$7$1(this, function25, function24, null);
                        c00063.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                        c00063.L$1 = SpillingKt.nullOutSpilledVariable(function25);
                        c00063.L$2 = SpillingKt.nullOutSpilledVariable(function24);
                        c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl11);
                        c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders10);
                        c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks2);
                        c00063.L$6 = SpillingKt.nullOutSpilledVariable(it);
                        c00063.L$7 = SpillingKt.nullOutSpilledVariable(doc5);
                        c00063.Z$0 = isCasting4;
                        c00063.label = 10;
                        objAmap3 = ParCollectionsKt.amap(listSelect5, hdmovie2$loadLinks$7$5, c00063);
                        if (objAmap3 == obj11) {
                            return obj11;
                        }
                    }
                    return Boxing.boxBoolean(z);
                }
                str5 = "/movies/";
                playerOptions2 = playerOptions;
                z6 = false;
                i2 = 2;
                str6 = null;
                post_id = str6;
                String post_id4 = post_id;
                String post_id5 = str5;
                if (StringsKt.contains$default(data3, post_id5, z6, i2, str6)) {
                }
                obj8 = obj;
                C00083 c00084 = new C00083(function5, function6, post_id4, type3, ajaxUrl, commonHeaders, data3, null);
                c00062.L$0 = data3;
                c00062.L$1 = function5;
                c00062.L$2 = function6;
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(document);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(playerOptions2);
                c00062.L$7 = SpillingKt.nullOutSpilledVariable(post_id4);
                c00062.L$8 = SpillingKt.nullOutSpilledVariable(type3);
                c00062.Z$0 = isCasting2;
                c00062.label = 6;
                objAmap2 = ParCollectionsKt.amap((List) playerOptions2, c00084, c00062);
                if (objAmap2 == obj8) {
                    return obj8;
                }
                obj10 = objAmap2;
                ajaxUrl8 = ajaxUrl;
                data6 = data3;
                function12 = function5;
                function11 = function6;
                commonHeaders8 = commonHeaders;
                ajaxUrl6 = ajaxUrl8;
                data4 = data6;
                isCasting3 = isCasting2;
                if (!StringsKt.contains$default(data4, "hdmovie2", false, 2, (Object) null)) {
                    return Boxing.boxBoolean(z);
                }
                Requests app12 = MainActivityKt.getApp();
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                c00062.L$1 = function12;
                c00062.L$2 = function11;
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl6);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                c00062.L$5 = null;
                c00062.L$6 = null;
                c00062.L$7 = null;
                c00062.L$8 = null;
                c00062.Z$0 = isCasting3;
                c00062.label = 8;
                function18 = function12;
                function19 = function11;
                C00061 c000614 = c00062;
                obj11 = obj8;
                $result3 = Requests.get$default(app12, data4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000614, 4094, (Object) null);
                c00063 = c000614;
                if ($result3 == obj11) {
                    return obj11;
                }
                String str111 = ajaxUrl6;
                ajaxUrl9 = data4;
                function20 = function18;
                ajaxUrl10 = str111;
                function21 = function19;
                str7 = str2;
                elementSelectFirst4 = ((NiceResponse) $result3).getDocument().selectFirst(str7);
                if (elementSelectFirst4 != null) {
                    strAttr2 = elementSelectFirst4.attr("href");
                } else {
                    strAttr2 = null;
                }
                directLinks = strAttr2;
                if (directLinks != null) {
                    Requests app13 = MainActivityKt.getApp();
                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(ajaxUrl9);
                    c00063.L$1 = function20;
                    c00063.L$2 = function21;
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl10);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks);
                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(directLinks);
                    c00063.Z$0 = isCasting3;
                    c00063.label = 9;
                    function22 = function20;
                    function23 = function21;
                    C00061 c000615 = c00063;
                    str8 = str7;
                    $result3 = Requests.get$default(app13, directLinks, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000615, 4094, (Object) null);
                    c00063 = c000615;
                    if ($result3 == obj11) {
                        return obj11;
                    }
                    isCasting4 = isCasting3;
                    it = directLinks;
                    commonHeaders10 = commonHeaders8;
                    data7 = ajaxUrl9;
                    ajaxUrl11 = ajaxUrl10;
                    directLinks2 = directLinks;
                    function24 = function23;
                    function25 = function22;
                    Document doc6 = ((NiceResponse) $result3).getDocument();
                    List listSelect6 = doc6.select(str8);
                    Hdmovie2$loadLinks$7$1 hdmovie2$loadLinks$7$6 = new Hdmovie2$loadLinks$7$1(this, function25, function24, null);
                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                    c00063.L$1 = SpillingKt.nullOutSpilledVariable(function25);
                    c00063.L$2 = SpillingKt.nullOutSpilledVariable(function24);
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl11);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders10);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks2);
                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(it);
                    c00063.L$7 = SpillingKt.nullOutSpilledVariable(doc6);
                    c00063.Z$0 = isCasting4;
                    c00063.label = 10;
                    objAmap3 = ParCollectionsKt.amap(listSelect6, hdmovie2$loadLinks$7$6, c00063);
                    if (objAmap3 == obj11) {
                        return obj11;
                    }
                }
                return Boxing.boxBoolean(z);
            case 1:
                boolean z7 = c00063.Z$0;
                ResultKt.throwOnFailure($result3);
                z3 = true;
            case 2:
                isCasting3 = c00063.Z$0;
                LinkData loadData3 = (LinkData) c00063.L$5;
                Map commonHeaders15 = (Map) c00063.L$4;
                String ajaxUrl15 = (String) c00063.L$3;
                Function1<? super ExtractorLink, Unit> function26 = (Function1) c00063.L$2;
                Function1<? super SubtitleFile, Unit> function27 = (Function1) c00063.L$1;
                String data8 = (String) c00063.L$0;
                ResultKt.throwOnFailure($result3);
                function8 = function26;
                function7 = function27;
                $result2 = $result3;
                obj5 = null;
                i = 2;
                ajaxUrl4 = data8;
                z2 = false;
                hdmovie2 = this;
                commonHeaders5 = commonHeaders15;
                loadData2 = loadData3;
                source = ajaxUrl15;
                objLoadLinks$fetchSource = $result2;
                source2 = (String) objLoadLinks$fetchSource;
                if (!StringsKt.contains$default(source2, "youtube", z2, i, obj5)) {
                    str4 = hdmovie2.directUrl + '/';
                    c00063.L$0 = ajaxUrl4;
                    c00063.L$1 = function7;
                    c00063.L$2 = function8;
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(source);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders5);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(loadData2);
                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(source2);
                    c00063.Z$0 = isCasting3;
                    c00063.label = 3;
                    if (ExtractorApiKt.loadExtractor(source2, str4, function7, function8, c00063) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    commonHeaders7 = commonHeaders5;
                    ajaxUrl5 = source;
                    function9 = function8;
                    function10 = function7;
                    source = ajaxUrl5;
                    commonHeaders5 = commonHeaders7;
                    function8 = function9;
                    function7 = function10;
                }
                Unit unit3 = Unit.INSTANCE;
                ajaxUrl6 = source;
                data4 = ajaxUrl4;
                function11 = function8;
                obj8 = coroutine_suspended;
                function12 = function7;
                str2 = str9;
                z = true;
                commonHeaders8 = commonHeaders5;
                c00062 = c00063;
                if (!StringsKt.contains$default(data4, "hdmovie2", false, 2, (Object) null)) {
                    return Boxing.boxBoolean(z);
                }
                Requests app14 = MainActivityKt.getApp();
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                c00062.L$1 = function12;
                c00062.L$2 = function11;
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl6);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                c00062.L$5 = null;
                c00062.L$6 = null;
                c00062.L$7 = null;
                c00062.L$8 = null;
                c00062.Z$0 = isCasting3;
                c00062.label = 8;
                function18 = function12;
                function19 = function11;
                C00061 c000616 = c00062;
                obj11 = obj8;
                $result3 = Requests.get$default(app14, data4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000616, 4094, (Object) null);
                c00063 = c000616;
                if ($result3 == obj11) {
                    return obj11;
                }
                String str112 = ajaxUrl6;
                ajaxUrl9 = data4;
                function20 = function18;
                ajaxUrl10 = str112;
                function21 = function19;
                str7 = str2;
                elementSelectFirst4 = ((NiceResponse) $result3).getDocument().selectFirst(str7);
                if (elementSelectFirst4 != null) {
                    strAttr2 = elementSelectFirst4.attr("href");
                } else {
                    strAttr2 = null;
                }
                directLinks = strAttr2;
                if (directLinks != null) {
                    Requests app15 = MainActivityKt.getApp();
                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(ajaxUrl9);
                    c00063.L$1 = function20;
                    c00063.L$2 = function21;
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl10);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks);
                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(directLinks);
                    c00063.Z$0 = isCasting3;
                    c00063.label = 9;
                    function22 = function20;
                    function23 = function21;
                    C00061 c000617 = c00063;
                    str8 = str7;
                    $result3 = Requests.get$default(app15, directLinks, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000617, 4094, (Object) null);
                    c00063 = c000617;
                    if ($result3 == obj11) {
                        return obj11;
                    }
                    isCasting4 = isCasting3;
                    it = directLinks;
                    commonHeaders10 = commonHeaders8;
                    data7 = ajaxUrl9;
                    ajaxUrl11 = ajaxUrl10;
                    directLinks2 = directLinks;
                    function24 = function23;
                    function25 = function22;
                    Document doc7 = ((NiceResponse) $result3).getDocument();
                    List listSelect7 = doc7.select(str8);
                    Hdmovie2$loadLinks$7$1 hdmovie2$loadLinks$7$7 = new Hdmovie2$loadLinks$7$1(this, function25, function24, null);
                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                    c00063.L$1 = SpillingKt.nullOutSpilledVariable(function25);
                    c00063.L$2 = SpillingKt.nullOutSpilledVariable(function24);
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl11);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders10);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks2);
                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(it);
                    c00063.L$7 = SpillingKt.nullOutSpilledVariable(doc7);
                    c00063.Z$0 = isCasting4;
                    c00063.label = 10;
                    objAmap3 = ParCollectionsKt.amap(listSelect7, hdmovie2$loadLinks$7$7, c00063);
                    if (objAmap3 == obj11) {
                        return obj11;
                    }
                }
                return Boxing.boxBoolean(z);
            case 3:
                isCasting3 = c00063.Z$0;
                commonHeaders7 = (Map) c00063.L$4;
                String ajaxUrl16 = (String) c00063.L$3;
                function9 = (Function1) c00063.L$2;
                function10 = (Function1) c00063.L$1;
                String data9 = (String) c00063.L$0;
                ResultKt.throwOnFailure($result3);
                ajaxUrl5 = ajaxUrl16;
                ajaxUrl4 = data9;
                $result2 = $result3;
                str9 = "p > a";
                source = ajaxUrl5;
                commonHeaders5 = commonHeaders7;
                function8 = function9;
                function7 = function10;
                Unit unit4 = Unit.INSTANCE;
                ajaxUrl6 = source;
                data4 = ajaxUrl4;
                function11 = function8;
                obj8 = coroutine_suspended;
                function12 = function7;
                str2 = str9;
                z = true;
                commonHeaders8 = commonHeaders5;
                c00062 = c00063;
                if (!StringsKt.contains$default(data4, "hdmovie2", false, 2, (Object) null)) {
                    return Boxing.boxBoolean(z);
                }
                Requests app16 = MainActivityKt.getApp();
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                c00062.L$1 = function12;
                c00062.L$2 = function11;
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl6);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                c00062.L$5 = null;
                c00062.L$6 = null;
                c00062.L$7 = null;
                c00062.L$8 = null;
                c00062.Z$0 = isCasting3;
                c00062.label = 8;
                function18 = function12;
                function19 = function11;
                C00061 c000618 = c00062;
                obj11 = obj8;
                $result3 = Requests.get$default(app16, data4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000618, 4094, (Object) null);
                c00063 = c000618;
                if ($result3 == obj11) {
                    return obj11;
                }
                String str113 = ajaxUrl6;
                ajaxUrl9 = data4;
                function20 = function18;
                ajaxUrl10 = str113;
                function21 = function19;
                str7 = str2;
                elementSelectFirst4 = ((NiceResponse) $result3).getDocument().selectFirst(str7);
                if (elementSelectFirst4 != null) {
                    strAttr2 = elementSelectFirst4.attr("href");
                } else {
                    strAttr2 = null;
                }
                directLinks = strAttr2;
                if (directLinks != null) {
                    Requests app17 = MainActivityKt.getApp();
                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(ajaxUrl9);
                    c00063.L$1 = function20;
                    c00063.L$2 = function21;
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl10);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks);
                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(directLinks);
                    c00063.Z$0 = isCasting3;
                    c00063.label = 9;
                    function22 = function20;
                    function23 = function21;
                    C00061 c000619 = c00063;
                    str8 = str7;
                    $result3 = Requests.get$default(app17, directLinks, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000619, 4094, (Object) null);
                    c00063 = c000619;
                    if ($result3 == obj11) {
                        return obj11;
                    }
                    isCasting4 = isCasting3;
                    it = directLinks;
                    commonHeaders10 = commonHeaders8;
                    data7 = ajaxUrl9;
                    ajaxUrl11 = ajaxUrl10;
                    directLinks2 = directLinks;
                    function24 = function23;
                    function25 = function22;
                    Document doc8 = ((NiceResponse) $result3).getDocument();
                    List listSelect8 = doc8.select(str8);
                    Hdmovie2$loadLinks$7$1 hdmovie2$loadLinks$7$8 = new Hdmovie2$loadLinks$7$1(this, function25, function24, null);
                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                    c00063.L$1 = SpillingKt.nullOutSpilledVariable(function25);
                    c00063.L$2 = SpillingKt.nullOutSpilledVariable(function24);
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl11);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders10);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks2);
                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(it);
                    c00063.L$7 = SpillingKt.nullOutSpilledVariable(doc8);
                    c00063.Z$0 = isCasting4;
                    c00063.label = 10;
                    objAmap3 = ParCollectionsKt.amap(listSelect8, hdmovie2$loadLinks$7$8, c00063);
                    if (objAmap3 == obj11) {
                        return obj11;
                    }
                }
                return Boxing.boxBoolean(z);
            case 4:
                isCasting3 = c00063.Z$0;
                commonHeaders2 = (Map) c00063.L$4;
                ajaxUrl2 = (String) c00063.L$3;
                Function1<? super ExtractorLink, Unit> function28 = (Function1) c00063.L$2;
                Function1<? super SubtitleFile, Unit> function29 = (Function1) c00063.L$1;
                String data10 = (String) c00063.L$0;
                ResultKt.throwOnFailure($result3);
                function4 = function28;
                function3 = function29;
                $result = $result3;
                str = "p > a";
                data2 = data10;
                ajaxUrl6 = ajaxUrl2;
                data4 = data2;
                obj8 = coroutine_suspended;
                function12 = function3;
                str2 = str;
                z = true;
                commonHeaders8 = commonHeaders2;
                function11 = function4;
                c00062 = c00063;
                if (!StringsKt.contains$default(data4, "hdmovie2", false, 2, (Object) null)) {
                    return Boxing.boxBoolean(z);
                }
                Requests app18 = MainActivityKt.getApp();
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                c00062.L$1 = function12;
                c00062.L$2 = function11;
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl6);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                c00062.L$5 = null;
                c00062.L$6 = null;
                c00062.L$7 = null;
                c00062.L$8 = null;
                c00062.Z$0 = isCasting3;
                c00062.label = 8;
                function18 = function12;
                function19 = function11;
                C00061 c0006110 = c00062;
                obj11 = obj8;
                $result3 = Requests.get$default(app18, data4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006110, 4094, (Object) null);
                c00063 = c0006110;
                if ($result3 == obj11) {
                    return obj11;
                }
                String str114 = ajaxUrl6;
                ajaxUrl9 = data4;
                function20 = function18;
                ajaxUrl10 = str114;
                function21 = function19;
                str7 = str2;
                elementSelectFirst4 = ((NiceResponse) $result3).getDocument().selectFirst(str7);
                if (elementSelectFirst4 != null) {
                    strAttr2 = elementSelectFirst4.attr("href");
                } else {
                    strAttr2 = null;
                }
                directLinks = strAttr2;
                if (directLinks != null) {
                    Requests app19 = MainActivityKt.getApp();
                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(ajaxUrl9);
                    c00063.L$1 = function20;
                    c00063.L$2 = function21;
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl10);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks);
                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(directLinks);
                    c00063.Z$0 = isCasting3;
                    c00063.label = 9;
                    function22 = function20;
                    function23 = function21;
                    C00061 c0006111 = c00063;
                    str8 = str7;
                    $result3 = Requests.get$default(app19, directLinks, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006111, 4094, (Object) null);
                    c00063 = c0006111;
                    if ($result3 == obj11) {
                        return obj11;
                    }
                    isCasting4 = isCasting3;
                    it = directLinks;
                    commonHeaders10 = commonHeaders8;
                    data7 = ajaxUrl9;
                    ajaxUrl11 = ajaxUrl10;
                    directLinks2 = directLinks;
                    function24 = function23;
                    function25 = function22;
                    Document doc9 = ((NiceResponse) $result3).getDocument();
                    List listSelect9 = doc9.select(str8);
                    Hdmovie2$loadLinks$7$1 hdmovie2$loadLinks$7$9 = new Hdmovie2$loadLinks$7$1(this, function25, function24, null);
                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                    c00063.L$1 = SpillingKt.nullOutSpilledVariable(function25);
                    c00063.L$2 = SpillingKt.nullOutSpilledVariable(function24);
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl11);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders10);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks2);
                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(it);
                    c00063.L$7 = SpillingKt.nullOutSpilledVariable(doc9);
                    c00063.Z$0 = isCasting4;
                    c00063.label = 10;
                    objAmap3 = ParCollectionsKt.amap(listSelect9, hdmovie2$loadLinks$7$9, c00063);
                    if (objAmap3 == obj11) {
                        return obj11;
                    }
                }
                return Boxing.boxBoolean(z);
            case 5:
                boolean isCasting5 = c00063.Z$0;
                Map commonHeaders16 = (Map) c00063.L$4;
                String ajaxUrl17 = (String) c00063.L$3;
                Function1<? super ExtractorLink, Unit> function30 = (Function1) c00063.L$2;
                Function1<? super SubtitleFile, Unit> function31 = (Function1) c00063.L$1;
                String data11 = (String) c00063.L$0;
                ResultKt.throwOnFailure($result3);
                commonHeaders = commonHeaders16;
                function5 = function31;
                c00062 = c00063;
                obj = coroutine_suspended;
                str2 = "p > a";
                z = true;
                isCasting2 = isCasting5;
                data3 = data11;
                ajaxUrl = ajaxUrl17;
                function6 = function30;
                obj2 = $result3;
                document = ((NiceResponse) obj2).getDocument();
                playerOptions = document.select(".dooplay_player .options ul li, #video-sources .options ul li");
                String str115 = "/movies/";
                if (((Collection) playerOptions).isEmpty()) {
                    elementSelectFirst3 = document.selectFirst("body");
                    if (elementSelectFirst3 == null) {
                        str5 = "/movies/";
                        playerOptions2 = playerOptions;
                        z6 = false;
                        i2 = 2;
                        str6 = null;
                        post_id = str6;
                    } else {
                        str5 = "/movies/";
                        playerOptions2 = playerOptions;
                        z6 = false;
                        i2 = 2;
                        str6 = null;
                        post_id = str6;
                    }
                    String post_id6 = post_id;
                    String post_id7 = str5;
                    if (StringsKt.contains$default(data3, post_id7, z6, i2, str6)) {
                    }
                    obj8 = obj;
                    C00083 c00085 = new C00083(function5, function6, post_id6, type3, ajaxUrl, commonHeaders, data3, null);
                    c00062.L$0 = data3;
                    c00062.L$1 = function5;
                    c00062.L$2 = function6;
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(document);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(playerOptions2);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(post_id6);
                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(type3);
                    c00062.Z$0 = isCasting2;
                    c00062.label = 6;
                    objAmap2 = ParCollectionsKt.amap((List) playerOptions2, c00085, c00062);
                    if (objAmap2 == obj8) {
                        return obj8;
                    }
                    obj10 = objAmap2;
                    ajaxUrl8 = ajaxUrl;
                    data6 = data3;
                    function12 = function5;
                    function11 = function6;
                    commonHeaders8 = commonHeaders;
                    ajaxUrl6 = ajaxUrl8;
                    data4 = data6;
                    isCasting3 = isCasting2;
                    if (!StringsKt.contains$default(data4, "hdmovie2", false, 2, (Object) null)) {
                        return Boxing.boxBoolean(z);
                    }
                    Requests app110 = MainActivityKt.getApp();
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$1 = function12;
                    c00062.L$2 = function11;
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl6);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                    c00062.L$5 = null;
                    c00062.L$6 = null;
                    c00062.L$7 = null;
                    c00062.L$8 = null;
                    c00062.Z$0 = isCasting3;
                    c00062.label = 8;
                    function18 = function12;
                    function19 = function11;
                    C00061 c0006112 = c00062;
                    obj11 = obj8;
                    $result3 = Requests.get$default(app110, data4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006112, 4094, (Object) null);
                    c00063 = c0006112;
                    if ($result3 == obj11) {
                        return obj11;
                    }
                    String str116 = ajaxUrl6;
                    ajaxUrl9 = data4;
                    function20 = function18;
                    ajaxUrl10 = str116;
                    function21 = function19;
                    str7 = str2;
                    elementSelectFirst4 = ((NiceResponse) $result3).getDocument().selectFirst(str7);
                    if (elementSelectFirst4 != null) {
                        strAttr2 = elementSelectFirst4.attr("href");
                    } else {
                        strAttr2 = null;
                    }
                    directLinks = strAttr2;
                    if (directLinks != null) {
                        Requests app111 = MainActivityKt.getApp();
                        c00063.L$0 = SpillingKt.nullOutSpilledVariable(ajaxUrl9);
                        c00063.L$1 = function20;
                        c00063.L$2 = function21;
                        c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl10);
                        c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                        c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks);
                        c00063.L$6 = SpillingKt.nullOutSpilledVariable(directLinks);
                        c00063.Z$0 = isCasting3;
                        c00063.label = 9;
                        function22 = function20;
                        function23 = function21;
                        C00061 c0006113 = c00063;
                        str8 = str7;
                        $result3 = Requests.get$default(app111, directLinks, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006113, 4094, (Object) null);
                        c00063 = c0006113;
                        if ($result3 == obj11) {
                            return obj11;
                        }
                        isCasting4 = isCasting3;
                        it = directLinks;
                        commonHeaders10 = commonHeaders8;
                        data7 = ajaxUrl9;
                        ajaxUrl11 = ajaxUrl10;
                        directLinks2 = directLinks;
                        function24 = function23;
                        function25 = function22;
                        Document doc10 = ((NiceResponse) $result3).getDocument();
                        List listSelect10 = doc10.select(str8);
                        Hdmovie2$loadLinks$7$1 hdmovie2$loadLinks$7$10 = new Hdmovie2$loadLinks$7$1(this, function25, function24, null);
                        c00063.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                        c00063.L$1 = SpillingKt.nullOutSpilledVariable(function25);
                        c00063.L$2 = SpillingKt.nullOutSpilledVariable(function24);
                        c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl11);
                        c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders10);
                        c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks2);
                        c00063.L$6 = SpillingKt.nullOutSpilledVariable(it);
                        c00063.L$7 = SpillingKt.nullOutSpilledVariable(doc10);
                        c00063.Z$0 = isCasting4;
                        c00063.label = 10;
                        objAmap3 = ParCollectionsKt.amap(listSelect10, hdmovie2$loadLinks$7$10, c00063);
                        if (objAmap3 == obj11) {
                            return obj11;
                        }
                    }
                    return Boxing.boxBoolean(z);
                }
                obj8 = obj;
                id = new Ref.ObjectRef();
                elementSelectFirst = document.selectFirst("ul#playeroptionsul > li");
                if (elementSelectFirst != null) {
                    strAttr = elementSelectFirst.attr("data-post");
                } else {
                    strAttr = null;
                }
                id.element = strAttr;
                if (Intrinsics.areEqual(id.element, "null")) {
                    elementSelectFirst2 = document.selectFirst("body");
                    if (elementSelectFirst2 != null) {
                        function13 = function6;
                        z4 = false;
                    } else {
                        function13 = function6;
                        z4 = false;
                    }
                    id.element = strSubstringAfter$default;
                } else {
                    charSequence = (CharSequence) id.element;
                    if (charSequence != null) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    if (z5) {
                        elementSelectFirst2 = document.selectFirst("body");
                        if (elementSelectFirst2 != null) {
                            function13 = function6;
                            z4 = false;
                        } else {
                            function13 = function6;
                            z4 = false;
                        }
                        id.element = strSubstringAfter$default;
                    } else {
                        function13 = function6;
                        z4 = false;
                    }
                }
                if (id.element == null) {
                    return Boxing.boxBoolean(z4);
                }
                if (StringsKt.contains$default(data3, "/movies/", z4, 2, (Object) null)) {
                    type2 = "movie";
                } else {
                    type2 = "tv";
                }
                Iterable $this$map$iv2 = document.select("ul#playeroptionsul > li");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r17.hasNext()) {
                    Element it8 = (Element) item$iv$iv;
                    destination$iv$iv.add(it8.attr("data-nume"));
                }
                ArrayList arrayList2 = (List) destination$iv$iv;
                function14 = function5;
                function15 = function13;
                C00096 c00097 = new C00096(id, type2, this, function14, function15, ajaxUrl, commonHeaders, data3, null);
                c00062.L$0 = data3;
                c00062.L$1 = function14;
                c00062.L$2 = function15;
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(document);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(playerOptions);
                c00062.L$7 = SpillingKt.nullOutSpilledVariable(id);
                c00062.L$8 = SpillingKt.nullOutSpilledVariable(type2);
                c00062.Z$0 = isCasting2;
                c00062.label = 7;
                objAmap = ParCollectionsKt.amap(arrayList2, c00097, c00062);
                if (objAmap == obj8) {
                    return obj8;
                }
                function16 = function14;
                obj9 = objAmap;
                function17 = function15;
                ajaxUrl7 = ajaxUrl;
                commonHeaders9 = commonHeaders;
                data5 = data3;
                commonHeaders8 = commonHeaders9;
                function11 = function17;
                function12 = function16;
                ajaxUrl6 = ajaxUrl7;
                data4 = data5;
                isCasting3 = isCasting2;
                if (!StringsKt.contains$default(data4, "hdmovie2", false, 2, (Object) null)) {
                    return Boxing.boxBoolean(z);
                }
                Requests app112 = MainActivityKt.getApp();
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                c00062.L$1 = function12;
                c00062.L$2 = function11;
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl6);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                c00062.L$5 = null;
                c00062.L$6 = null;
                c00062.L$7 = null;
                c00062.L$8 = null;
                c00062.Z$0 = isCasting3;
                c00062.label = 8;
                function18 = function12;
                function19 = function11;
                C00061 c0006114 = c00062;
                obj11 = obj8;
                $result3 = Requests.get$default(app112, data4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006114, 4094, (Object) null);
                c00063 = c0006114;
                if ($result3 == obj11) {
                    return obj11;
                }
                String str117 = ajaxUrl6;
                ajaxUrl9 = data4;
                function20 = function18;
                ajaxUrl10 = str117;
                function21 = function19;
                str7 = str2;
                elementSelectFirst4 = ((NiceResponse) $result3).getDocument().selectFirst(str7);
                if (elementSelectFirst4 != null) {
                    strAttr2 = elementSelectFirst4.attr("href");
                } else {
                    strAttr2 = null;
                }
                directLinks = strAttr2;
                if (directLinks != null) {
                    Requests app113 = MainActivityKt.getApp();
                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(ajaxUrl9);
                    c00063.L$1 = function20;
                    c00063.L$2 = function21;
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl10);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks);
                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(directLinks);
                    c00063.Z$0 = isCasting3;
                    c00063.label = 9;
                    function22 = function20;
                    function23 = function21;
                    C00061 c0006115 = c00063;
                    str8 = str7;
                    $result3 = Requests.get$default(app113, directLinks, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006115, 4094, (Object) null);
                    c00063 = c0006115;
                    if ($result3 == obj11) {
                        return obj11;
                    }
                    isCasting4 = isCasting3;
                    it = directLinks;
                    commonHeaders10 = commonHeaders8;
                    data7 = ajaxUrl9;
                    ajaxUrl11 = ajaxUrl10;
                    directLinks2 = directLinks;
                    function24 = function23;
                    function25 = function22;
                    Document doc11 = ((NiceResponse) $result3).getDocument();
                    List listSelect11 = doc11.select(str8);
                    Hdmovie2$loadLinks$7$1 hdmovie2$loadLinks$7$11 = new Hdmovie2$loadLinks$7$1(this, function25, function24, null);
                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                    c00063.L$1 = SpillingKt.nullOutSpilledVariable(function25);
                    c00063.L$2 = SpillingKt.nullOutSpilledVariable(function24);
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl11);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders10);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks2);
                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(it);
                    c00063.L$7 = SpillingKt.nullOutSpilledVariable(doc11);
                    c00063.Z$0 = isCasting4;
                    c00063.label = 10;
                    objAmap3 = ParCollectionsKt.amap(listSelect11, hdmovie2$loadLinks$7$11, c00063);
                    if (objAmap3 == obj11) {
                        return obj11;
                    }
                }
                return Boxing.boxBoolean(z);
            case 6:
                boolean isCasting6 = c00063.Z$0;
                commonHeaders = (Map) c00063.L$4;
                ajaxUrl8 = (String) c00063.L$3;
                Function1<? super ExtractorLink, Unit> function32 = (Function1) c00063.L$2;
                Function1<? super SubtitleFile, Unit> function33 = (Function1) c00063.L$1;
                data6 = (String) c00063.L$0;
                ResultKt.throwOnFailure($result3);
                c00062 = c00063;
                obj10 = $result3;
                function6 = function32;
                function5 = function33;
                str2 = "p > a";
                z = true;
                isCasting2 = isCasting6;
                obj8 = coroutine_suspended;
                function12 = function5;
                function11 = function6;
                commonHeaders8 = commonHeaders;
                ajaxUrl6 = ajaxUrl8;
                data4 = data6;
                isCasting3 = isCasting2;
                if (!StringsKt.contains$default(data4, "hdmovie2", false, 2, (Object) null)) {
                    return Boxing.boxBoolean(z);
                }
                Requests app114 = MainActivityKt.getApp();
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                c00062.L$1 = function12;
                c00062.L$2 = function11;
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl6);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                c00062.L$5 = null;
                c00062.L$6 = null;
                c00062.L$7 = null;
                c00062.L$8 = null;
                c00062.Z$0 = isCasting3;
                c00062.label = 8;
                function18 = function12;
                function19 = function11;
                C00061 c0006116 = c00062;
                obj11 = obj8;
                $result3 = Requests.get$default(app114, data4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006116, 4094, (Object) null);
                c00063 = c0006116;
                if ($result3 == obj11) {
                    return obj11;
                }
                String str118 = ajaxUrl6;
                ajaxUrl9 = data4;
                function20 = function18;
                ajaxUrl10 = str118;
                function21 = function19;
                str7 = str2;
                elementSelectFirst4 = ((NiceResponse) $result3).getDocument().selectFirst(str7);
                if (elementSelectFirst4 != null) {
                    strAttr2 = elementSelectFirst4.attr("href");
                } else {
                    strAttr2 = null;
                }
                directLinks = strAttr2;
                if (directLinks != null) {
                    Requests app115 = MainActivityKt.getApp();
                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(ajaxUrl9);
                    c00063.L$1 = function20;
                    c00063.L$2 = function21;
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl10);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks);
                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(directLinks);
                    c00063.Z$0 = isCasting3;
                    c00063.label = 9;
                    function22 = function20;
                    function23 = function21;
                    C00061 c0006117 = c00063;
                    str8 = str7;
                    $result3 = Requests.get$default(app115, directLinks, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006117, 4094, (Object) null);
                    c00063 = c0006117;
                    if ($result3 == obj11) {
                        return obj11;
                    }
                    isCasting4 = isCasting3;
                    it = directLinks;
                    commonHeaders10 = commonHeaders8;
                    data7 = ajaxUrl9;
                    ajaxUrl11 = ajaxUrl10;
                    directLinks2 = directLinks;
                    function24 = function23;
                    function25 = function22;
                    Document doc12 = ((NiceResponse) $result3).getDocument();
                    List listSelect12 = doc12.select(str8);
                    Hdmovie2$loadLinks$7$1 hdmovie2$loadLinks$7$12 = new Hdmovie2$loadLinks$7$1(this, function25, function24, null);
                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                    c00063.L$1 = SpillingKt.nullOutSpilledVariable(function25);
                    c00063.L$2 = SpillingKt.nullOutSpilledVariable(function24);
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl11);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders10);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks2);
                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(it);
                    c00063.L$7 = SpillingKt.nullOutSpilledVariable(doc12);
                    c00063.Z$0 = isCasting4;
                    c00063.label = 10;
                    objAmap3 = ParCollectionsKt.amap(listSelect12, hdmovie2$loadLinks$7$12, c00063);
                    if (objAmap3 == obj11) {
                        return obj11;
                    }
                }
                return Boxing.boxBoolean(z);
            case 7:
                boolean isCasting7 = c00063.Z$0;
                Map commonHeaders17 = (Map) c00063.L$4;
                ajaxUrl7 = (String) c00063.L$3;
                function17 = (Function1) c00063.L$2;
                function16 = (Function1) c00063.L$1;
                data5 = (String) c00063.L$0;
                ResultKt.throwOnFailure($result3);
                c00062 = c00063;
                obj9 = $result3;
                commonHeaders9 = commonHeaders17;
                str2 = "p > a";
                z = true;
                isCasting2 = isCasting7;
                obj8 = coroutine_suspended;
                commonHeaders8 = commonHeaders9;
                function11 = function17;
                function12 = function16;
                ajaxUrl6 = ajaxUrl7;
                data4 = data5;
                isCasting3 = isCasting2;
                if (!StringsKt.contains$default(data4, "hdmovie2", false, 2, (Object) null)) {
                    return Boxing.boxBoolean(z);
                }
                Requests app116 = MainActivityKt.getApp();
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                c00062.L$1 = function12;
                c00062.L$2 = function11;
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl6);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                c00062.L$5 = null;
                c00062.L$6 = null;
                c00062.L$7 = null;
                c00062.L$8 = null;
                c00062.Z$0 = isCasting3;
                c00062.label = 8;
                function18 = function12;
                function19 = function11;
                C00061 c0006118 = c00062;
                obj11 = obj8;
                $result3 = Requests.get$default(app116, data4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006118, 4094, (Object) null);
                c00063 = c0006118;
                if ($result3 == obj11) {
                    return obj11;
                }
                String str119 = ajaxUrl6;
                ajaxUrl9 = data4;
                function20 = function18;
                ajaxUrl10 = str119;
                function21 = function19;
                str7 = str2;
                elementSelectFirst4 = ((NiceResponse) $result3).getDocument().selectFirst(str7);
                if (elementSelectFirst4 != null) {
                    strAttr2 = elementSelectFirst4.attr("href");
                } else {
                    strAttr2 = null;
                }
                directLinks = strAttr2;
                if (directLinks != null) {
                    Requests app117 = MainActivityKt.getApp();
                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(ajaxUrl9);
                    c00063.L$1 = function20;
                    c00063.L$2 = function21;
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl10);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks);
                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(directLinks);
                    c00063.Z$0 = isCasting3;
                    c00063.label = 9;
                    function22 = function20;
                    function23 = function21;
                    C00061 c0006119 = c00063;
                    str8 = str7;
                    $result3 = Requests.get$default(app117, directLinks, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006119, 4094, (Object) null);
                    c00063 = c0006119;
                    if ($result3 == obj11) {
                        return obj11;
                    }
                    isCasting4 = isCasting3;
                    it = directLinks;
                    commonHeaders10 = commonHeaders8;
                    data7 = ajaxUrl9;
                    ajaxUrl11 = ajaxUrl10;
                    directLinks2 = directLinks;
                    function24 = function23;
                    function25 = function22;
                    Document doc13 = ((NiceResponse) $result3).getDocument();
                    List listSelect13 = doc13.select(str8);
                    Hdmovie2$loadLinks$7$1 hdmovie2$loadLinks$7$13 = new Hdmovie2$loadLinks$7$1(this, function25, function24, null);
                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                    c00063.L$1 = SpillingKt.nullOutSpilledVariable(function25);
                    c00063.L$2 = SpillingKt.nullOutSpilledVariable(function24);
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl11);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders10);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks2);
                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(it);
                    c00063.L$7 = SpillingKt.nullOutSpilledVariable(doc13);
                    c00063.Z$0 = isCasting4;
                    c00063.label = 10;
                    objAmap3 = ParCollectionsKt.amap(listSelect13, hdmovie2$loadLinks$7$13, c00063);
                    if (objAmap3 == obj11) {
                        return obj11;
                    }
                }
                return Boxing.boxBoolean(z);
            case 8:
                isCasting3 = c00063.Z$0;
                Map commonHeaders18 = (Map) c00063.L$4;
                String ajaxUrl18 = (String) c00063.L$3;
                Function1<? super ExtractorLink, Unit> function34 = (Function1) c00063.L$2;
                Function1<? super SubtitleFile, Unit> function35 = (Function1) c00063.L$1;
                String data12 = (String) c00063.L$0;
                ResultKt.throwOnFailure($result3);
                commonHeaders8 = commonHeaders18;
                ajaxUrl9 = data12;
                ajaxUrl10 = ajaxUrl18;
                function21 = function34;
                function20 = function35;
                obj11 = coroutine_suspended;
                str2 = "p > a";
                z = true;
                str7 = str2;
                elementSelectFirst4 = ((NiceResponse) $result3).getDocument().selectFirst(str7);
                if (elementSelectFirst4 != null) {
                    strAttr2 = elementSelectFirst4.attr("href");
                } else {
                    strAttr2 = null;
                }
                directLinks = strAttr2;
                if (directLinks != null) {
                    Requests app118 = MainActivityKt.getApp();
                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(ajaxUrl9);
                    c00063.L$1 = function20;
                    c00063.L$2 = function21;
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl10);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders8);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks);
                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(directLinks);
                    c00063.Z$0 = isCasting3;
                    c00063.label = 9;
                    function22 = function20;
                    function23 = function21;
                    C00061 c00061110 = c00063;
                    str8 = str7;
                    $result3 = Requests.get$default(app118, directLinks, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00061110, 4094, (Object) null);
                    c00063 = c00061110;
                    if ($result3 == obj11) {
                        return obj11;
                    }
                    isCasting4 = isCasting3;
                    it = directLinks;
                    commonHeaders10 = commonHeaders8;
                    data7 = ajaxUrl9;
                    ajaxUrl11 = ajaxUrl10;
                    directLinks2 = directLinks;
                    function24 = function23;
                    function25 = function22;
                    Document doc14 = ((NiceResponse) $result3).getDocument();
                    List listSelect14 = doc14.select(str8);
                    Hdmovie2$loadLinks$7$1 hdmovie2$loadLinks$7$14 = new Hdmovie2$loadLinks$7$1(this, function25, function24, null);
                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                    c00063.L$1 = SpillingKt.nullOutSpilledVariable(function25);
                    c00063.L$2 = SpillingKt.nullOutSpilledVariable(function24);
                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl11);
                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders10);
                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks2);
                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(it);
                    c00063.L$7 = SpillingKt.nullOutSpilledVariable(doc14);
                    c00063.Z$0 = isCasting4;
                    c00063.label = 10;
                    objAmap3 = ParCollectionsKt.amap(listSelect14, hdmovie2$loadLinks$7$14, c00063);
                    if (objAmap3 == obj11) {
                        return obj11;
                    }
                }
                return Boxing.boxBoolean(z);
            case 9:
                isCasting4 = c00063.Z$0;
                String it9 = (String) c00063.L$6;
                directLinks2 = (String) c00063.L$5;
                commonHeaders10 = (Map) c00063.L$4;
                String ajaxUrl19 = (String) c00063.L$3;
                Function1<? super ExtractorLink, Unit> function36 = (Function1) c00063.L$2;
                function25 = (Function1) c00063.L$1;
                data7 = (String) c00063.L$0;
                ResultKt.throwOnFailure($result3);
                it = it9;
                obj11 = coroutine_suspended;
                ajaxUrl11 = ajaxUrl19;
                str8 = "p > a";
                z = true;
                function24 = function36;
                Document doc15 = ((NiceResponse) $result3).getDocument();
                List listSelect15 = doc15.select(str8);
                Hdmovie2$loadLinks$7$1 hdmovie2$loadLinks$7$15 = new Hdmovie2$loadLinks$7$1(this, function25, function24, null);
                c00063.L$0 = SpillingKt.nullOutSpilledVariable(data7);
                c00063.L$1 = SpillingKt.nullOutSpilledVariable(function25);
                c00063.L$2 = SpillingKt.nullOutSpilledVariable(function24);
                c00063.L$3 = SpillingKt.nullOutSpilledVariable(ajaxUrl11);
                c00063.L$4 = SpillingKt.nullOutSpilledVariable(commonHeaders10);
                c00063.L$5 = SpillingKt.nullOutSpilledVariable(directLinks2);
                c00063.L$6 = SpillingKt.nullOutSpilledVariable(it);
                c00063.L$7 = SpillingKt.nullOutSpilledVariable(doc15);
                c00063.Z$0 = isCasting4;
                c00063.label = 10;
                objAmap3 = ParCollectionsKt.amap(listSelect15, hdmovie2$loadLinks$7$15, c00063);
                if (objAmap3 == obj11) {
                    return obj11;
                }
                return Boxing.boxBoolean(z);
            case 10:
                isCasting4 = c00063.Z$0;
                directLinks2 = (String) c00063.L$5;
                commonHeaders10 = (Map) c00063.L$4;
                ajaxUrl11 = (String) c00063.L$3;
                function24 = (Function1) c00063.L$2;
                function25 = (Function1) c00063.L$1;
                data7 = (String) c00063.L$0;
                ResultKt.throwOnFailure($result3);
                objAmap3 = $result3;
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object loadLinks$fetchSource(String ajaxUrl, Map<String, String> map, String $data, Hdmovie2 this$0, String post, String nume, String type, Continuation<? super String> continuation) {
        Hdmovie2$loadLinks$fetchSource$1 hdmovie2$loadLinks$fetchSource$1;
        Hdmovie2 this$1;
        if (continuation instanceof Hdmovie2$loadLinks$fetchSource$1) {
            hdmovie2$loadLinks$fetchSource$1 = (Hdmovie2$loadLinks$fetchSource$1) continuation;
            if ((hdmovie2$loadLinks$fetchSource$1.label & Integer.MIN_VALUE) != 0) {
                hdmovie2$loadLinks$fetchSource$1.label -= Integer.MIN_VALUE;
            } else {
                hdmovie2$loadLinks$fetchSource$1 = new Hdmovie2$loadLinks$fetchSource$1(continuation);
            }
        } else {
            hdmovie2$loadLinks$fetchSource$1 = new Hdmovie2$loadLinks$fetchSource$1(continuation);
        }
        Object $result = hdmovie2$loadLinks$fetchSource$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (hdmovie2$loadLinks$fetchSource$1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("action", "doo_player_ajax"), TuplesKt.to("post", post), TuplesKt.to("nume", nume), TuplesKt.to("type", type)});
                hdmovie2$loadLinks$fetchSource$1.L$0 = SpillingKt.nullOutSpilledVariable(ajaxUrl);
                hdmovie2$loadLinks$fetchSource$1.L$1 = SpillingKt.nullOutSpilledVariable(map);
                hdmovie2$loadLinks$fetchSource$1.L$2 = SpillingKt.nullOutSpilledVariable($data);
                hdmovie2$loadLinks$fetchSource$1.L$3 = this$0;
                hdmovie2$loadLinks$fetchSource$1.L$4 = SpillingKt.nullOutSpilledVariable(post);
                hdmovie2$loadLinks$fetchSource$1.L$5 = SpillingKt.nullOutSpilledVariable(nume);
                hdmovie2$loadLinks$fetchSource$1.L$6 = SpillingKt.nullOutSpilledVariable(type);
                hdmovie2$loadLinks$fetchSource$1.label = 1;
                $result = Requests.post$default(app, ajaxUrl, map, $data, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, hdmovie2$loadLinks$fetchSource$1, 65496, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this$1 = this$0;
                break;
            case 1:
                this$1 = (Hdmovie2) hdmovie2$loadLinks$fetchSource$1.L$3;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        ResponseParser parser = this_$iv.getParser();
        Intrinsics.checkNotNull(parser);
        ResponseHash response = (ResponseHash) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(ResponseHash.class));
        return this$1.getIframe(response.getEmbed_url());
    }

    /* JADX INFO: renamed from: com.Hdmovie2.Hdmovie2$loadLinks$2 */
    /* JADX INFO: compiled from: Hdmovie2.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "loadData", "Lcom/Hdmovie2/Hdmovie2$LinkData;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Hdmovie2.Hdmovie2$loadLinks$2", f = "Hdmovie2.kt", i = {0, 1, 2, 2}, l = {319, 322, 324}, m = "invokeSuspend", n = {"loadData", "loadData", "loadData", "ajaxSource"}, nl = {321, 323, 327}, s = {"L$0", "L$0", "L$0", "L$1"}, v = 2)
    static final class C00072 extends SuspendLambda implements Function2<LinkData, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $ajaxUrl;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Map<String, String> $commonHeaders;
        final /* synthetic */ String $data;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00072(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str, Map<String, String> map, String str2, Continuation<? super C00072> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$ajaxUrl = str;
            this.$commonHeaders = map;
            this.$data = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00072 = Hdmovie2.this.new C00072(this.$subtitleCallback, this.$callback, this.$ajaxUrl, this.$commonHeaders, this.$data, continuation);
            c00072.L$0 = obj;
            return c00072;
        }

        public final Object invoke(LinkData linkData, Continuation<? super Unit> continuation) {
            return create(linkData, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:37:0x0115 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:38:0x0116  */
        public final Object invokeSuspend(Object $result) {
            Object objLoadLinks$fetchSource;
            String ajaxSource;
            LinkData loadData = (LinkData) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (loadData.getSource() == null || !(StringsKt.startsWith$default(loadData.getSource(), "http", false, 2, (Object) null) || StringsKt.startsWith$default(loadData.getSource(), "//", false, 2, (Object) null))) {
                        if (loadData.getPost() != null && loadData.getNume() != null) {
                            String str = this.$ajaxUrl;
                            Map<String, String> map = this.$commonHeaders;
                            String str2 = this.$data;
                            Hdmovie2 hdmovie2 = Hdmovie2.this;
                            String post = loadData.getPost();
                            String nume = loadData.getNume();
                            String type = loadData.getType();
                            if (type == null) {
                                type = "";
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(loadData);
                            this.label = 2;
                            objLoadLinks$fetchSource = Hdmovie2.loadLinks$fetchSource(str, map, str2, hdmovie2, post, nume, type, (Continuation) this);
                            if (objLoadLinks$fetchSource == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ajaxSource = (String) objLoadLinks$fetchSource;
                            if (!StringsKt.isBlank(ajaxSource) && !StringsKt.contains(ajaxSource, "youtube", true)) {
                                this.L$0 = SpillingKt.nullOutSpilledVariable(loadData);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(ajaxSource);
                                this.label = 3;
                                if (ExtractorApiKt.loadExtractor(ajaxSource, Hdmovie2.this.getDirectUrl() + '/', this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                    } else if (!StringsKt.contains(loadData.getSource(), "youtube", true)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(loadData);
                        this.label = 1;
                        if (ExtractorApiKt.loadExtractor(loadData.getSource(), Hdmovie2.this.getDirectUrl() + '/', this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    objLoadLinks$fetchSource = $result;
                    ajaxSource = (String) objLoadLinks$fetchSource;
                    if (!StringsKt.isBlank(ajaxSource)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(loadData);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(ajaxSource);
                        this.label = 3;
                        if (ExtractorApiKt.loadExtractor(ajaxSource, Hdmovie2.this.getDirectUrl() + '/', this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                case 3:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.Hdmovie2.Hdmovie2$loadLinks$3 */
    /* JADX INFO: compiled from: Hdmovie2.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "li", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Hdmovie2.Hdmovie2$loadLinks$3", f = "Hdmovie2.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {355, 359, 361}, m = "invokeSuspend", n = {"li", "source", "li", "source", "nume", "li", "source", "nume", "ajaxSource"}, nl = {357, 360, 366}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00083 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $ajaxUrl;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Map<String, String> $commonHeaders;
        final /* synthetic */ String $data;
        final /* synthetic */ String $post_id;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ String $type;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00083(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str, String str2, String str3, Map<String, String> map, String str4, Continuation<? super C00083> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$post_id = str;
            this.$type = str2;
            this.$ajaxUrl = str3;
            this.$commonHeaders = map;
            this.$data = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00083 = Hdmovie2.this.new C00083(this.$subtitleCallback, this.$callback, this.$post_id, this.$type, this.$ajaxUrl, this.$commonHeaders, this.$data, continuation);
            c00083.L$0 = obj;
            return c00083;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String source;
            Object objLoadLinks$fetchSource;
            String source2;
            String source3;
            String ajaxSource;
            String ajaxSource2;
            Element li = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Element elementSelectFirst = li.selectFirst("a");
                    String source4 = elementSelectFirst != null ? elementSelectFirst.attr("data-source") : null;
                    String str = source4;
                    if (!(str == null || StringsKt.isBlank(str)) && !StringsKt.contains(source4, "youtube", true)) {
                        if (StringsKt.startsWith$default(source4, "http", false, 2, (Object) null) || StringsKt.startsWith$default(source4, "//", false, 2, (Object) null)) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(li);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(source4);
                            this.label = 1;
                            if (ExtractorApiKt.loadExtractor(source4, Hdmovie2.this.getDirectUrl() + '/', this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            source = source4;
                        } else {
                            String nume = li.attr("data-nume");
                            if (this.$post_id != null && !StringsKt.isBlank(nume)) {
                                this.L$0 = SpillingKt.nullOutSpilledVariable(li);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(source4);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(nume);
                                this.label = 2;
                                objLoadLinks$fetchSource = Hdmovie2.loadLinks$fetchSource(this.$ajaxUrl, this.$commonHeaders, this.$data, Hdmovie2.this, this.$post_id, nume, this.$type, (Continuation) this);
                                if (objLoadLinks$fetchSource == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                source2 = source4;
                                source3 = nume;
                                ajaxSource = (String) objLoadLinks$fetchSource;
                                if (StringsKt.isBlank(ajaxSource) && !StringsKt.contains$default(ajaxSource, "youtube", false, 2, (Object) null)) {
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(li);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(source2);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(source3);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(ajaxSource);
                                    this.label = 3;
                                    if (ExtractorApiKt.loadExtractor(ajaxSource, Hdmovie2.this.getDirectUrl() + '/', this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    ajaxSource2 = source2;
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    source = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                case 2:
                    source3 = (String) this.L$2;
                    source2 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    objLoadLinks$fetchSource = $result;
                    ajaxSource = (String) objLoadLinks$fetchSource;
                    if (StringsKt.isBlank(ajaxSource)) {
                        break;
                    }
                    Unit unit2 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 3:
                    ajaxSource2 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    Unit unit3 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.Hdmovie2.Hdmovie2$loadLinks$6 */
    /* JADX INFO: compiled from: Hdmovie2.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "nume", "", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Hdmovie2.Hdmovie2$loadLinks$6", f = "Hdmovie2.kt", i = {0, 1, 1, 2, 2}, l = {378, 381, 384}, m = "invokeSuspend", n = {"nume", "nume", "source", "nume", "source"}, nl = {379, 383, 388}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 2)
    static final class C00096 extends SuspendLambda implements Function2<String, Continuation<? super Object>, Object> {
        final /* synthetic */ String $ajaxUrl;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Map<String, String> $commonHeaders;
        final /* synthetic */ String $data;
        final /* synthetic */ Ref.ObjectRef<String> $id;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ String $type;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ Hdmovie2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00096(Ref.ObjectRef<String> objectRef, String str, Hdmovie2 hdmovie2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str2, Map<String, String> map, String str3, Continuation<? super C00096> continuation) {
            super(2, continuation);
            this.$id = objectRef;
            this.$type = str;
            this.this$0 = hdmovie2;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$ajaxUrl = str2;
            this.$commonHeaders = map;
            this.$data = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00096 = new C00096(this.$id, this.$type, this.this$0, this.$subtitleCallback, this.$callback, this.$ajaxUrl, this.$commonHeaders, this.$data, continuation);
            c00096.L$0 = obj;
            return c00096;
        }

        public final Object invoke(String str, Continuation<Object> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x006a  */
        /* JADX WARN: Code duplicated, block: B:16:0x00af A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:17:0x00b0  */
        /* JADX WARN: Code duplicated, block: B:19:0x00b3  */
        /* JADX WARN: Code duplicated, block: B:21:0x00c0  */
        /* JADX WARN: Code duplicated, block: B:23:0x00f3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:24:0x00f4  */
        /* JADX WARN: Code duplicated, block: B:26:0x00f7  */
        public final Object invokeSuspend(Object $result) {
            Object objLoadLinks$fetchSource;
            String source;
            Object objLoadExtractor;
            String source2;
            Object objLoadExtractor2;
            String source3;
            String nume = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(nume);
                    this.label = 1;
                    objLoadLinks$fetchSource = Hdmovie2.loadLinks$fetchSource(this.$ajaxUrl, this.$commonHeaders, this.$data, this.this$0, (String) this.$id.element, nume, this.$type, (Continuation) this);
                    if (objLoadLinks$fetchSource == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    source = (String) objLoadLinks$fetchSource;
                    if (StringsKt.contains$default(source, "ok.ru", false, 2, (Object) null)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(nume);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(source);
                        this.label = 2;
                        objLoadExtractor2 = ExtractorApiKt.loadExtractor("https:" + source, this.this$0.getDirectUrl() + '/', this.$subtitleCallback, this.$callback, (Continuation) this);
                        if (objLoadExtractor2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        source3 = source;
                        return objLoadExtractor2;
                    }
                    if (!StringsKt.contains$default(source, "youtube", false, 2, (Object) null)) {
                        Log.INSTANCE.d("Error:", "Not Found");
                        return Unit.INSTANCE;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(nume);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(source);
                    this.label = 3;
                    objLoadExtractor = ExtractorApiKt.loadExtractor(source, this.this$0.getDirectUrl() + '/', this.$subtitleCallback, this.$callback, (Continuation) this);
                    if (objLoadExtractor == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    source2 = source;
                    return objLoadExtractor;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objLoadLinks$fetchSource = $result;
                    source = (String) objLoadLinks$fetchSource;
                    if (StringsKt.contains$default(source, "ok.ru", false, 2, (Object) null)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(nume);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(source);
                        this.label = 2;
                        objLoadExtractor2 = ExtractorApiKt.loadExtractor("https:" + source, this.this$0.getDirectUrl() + '/', this.$subtitleCallback, this.$callback, (Continuation) this);
                        if (objLoadExtractor2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        source3 = source;
                        return objLoadExtractor2;
                    }
                    if (!StringsKt.contains$default(source, "youtube", false, 2, (Object) null)) {
                        Log.INSTANCE.d("Error:", "Not Found");
                        return Unit.INSTANCE;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(nume);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(source);
                    this.label = 3;
                    objLoadExtractor = ExtractorApiKt.loadExtractor(source, this.this$0.getDirectUrl() + '/', this.$subtitleCallback, this.$callback, (Continuation) this);
                    if (objLoadExtractor == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    source2 = source;
                    return objLoadExtractor;
                case 2:
                    source3 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    objLoadExtractor2 = $result;
                    return objLoadExtractor2;
                case 3:
                    source2 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    objLoadExtractor = $result;
                    return objLoadExtractor;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final String getIframe(String $this$getIframe) {
        return Ksoup.parse$default(Ksoup.INSTANCE, $this$getIframe, (String) null, 2, (Object) null).select("iframe").attr("src");
    }

    private final String getImageAttr(Element $this$getImageAttr) {
        if ($this$getImageAttr.hasAttr("data-src")) {
            return $this$getImageAttr.attr("abs:data-src");
        }
        if ($this$getImageAttr.hasAttr("data-lazy-src")) {
            return $this$getImageAttr.attr("abs:data-lazy-src");
        }
        return $this$getImageAttr.hasAttr("srcset") ? StringsKt.substringBefore$default($this$getImageAttr.attr("abs:srcset"), " ", (String) null, 2, (Object) null) : $this$getImageAttr.attr("abs:src");
    }

    @NotNull
    public Interceptor getVideoInterceptor(@NotNull ExtractorLink extractorLink) {
        return new Interceptor() { // from class: com.Hdmovie2.Hdmovie2$$ExternalSyntheticLambda6
            public final Response intercept(Interceptor.Chain chain) {
                return Hdmovie2.getVideoInterceptor$lambda$0(chain);
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0054  */
    static final Response getVideoInterceptor$lambda$0(Interceptor.Chain chain) {
        Request modifiedRequest;
        Request finalRequest;
        String decodedUrl;
        Request request = chain.request();
        String originalUrl = request.url().toString();
        if (!StringsKt.startsWith$default(originalUrl, "https://exxample.com/", false, 2, (Object) null)) {
            modifiedRequest = request;
        } else {
            String encodedPart = StringsKt.removePrefix(originalUrl, "https://exxample.com/");
            try {
                decodedUrl = MainAPIKt.base64Decode(encodedPart);
            } catch (IllegalArgumentException e) {
                System.out.println((Object) ("Failed to decode Base64: " + e.getMessage()));
                decodedUrl = null;
            }
            if (decodedUrl == null) {
                modifiedRequest = request;
            } else {
                modifiedRequest = request.newBuilder().url(decodedUrl).build();
            }
        }
        if (StringsKt.contains$default(modifiedRequest.url().host(), "sukumsanghas.com", false, 2, (Object) null)) {
            finalRequest = modifiedRequest.newBuilder().header("Accept", "*/*").header("Accept-Encoding", "gzip, deflate, br").header("Accept-Language", "en-US,en;q=0.5").header("Cache-Control", "no-cache").header("Connection", "keep-alive").header("DNT", "1").header("Origin", "https://molop.art").header("Pragma", "no-cache").header("Referer", "https://molop.art/").header("Sec-Fetch-Dest", "empty").header("Sec-Fetch-Mode", "cors").header("Sec-Fetch-Site", "cross-site").header("Sec-GPC", "1").header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:137.0) Gecko/20100101 Firefox/137.0").build();
        } else {
            finalRequest = modifiedRequest;
        }
        return chain.proceed(finalRequest);
    }

    /* JADX INFO: compiled from: Hdmovie2.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/Hdmovie2/Hdmovie2$LinkData;", "", "tag", "", "type", "post", "nume", "source", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "getType", "getPost", "getNume", "getSource", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Hdmovie2"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LinkData {

        @Nullable
        private final String nume;

        @Nullable
        private final String post;

        @Nullable
        private final String source;

        @Nullable
        private final String tag;

        @Nullable
        private final String type;

        public LinkData() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ LinkData copy$default(LinkData linkData, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = linkData.tag;
            }
            if ((i & 2) != 0) {
                str2 = linkData.type;
            }
            if ((i & 4) != 0) {
                str3 = linkData.post;
            }
            if ((i & 8) != 0) {
                str4 = linkData.nume;
            }
            if ((i & 16) != 0) {
                str5 = linkData.source;
            }
            String str6 = str5;
            String str7 = str3;
            return linkData.copy(str, str2, str7, str4, str6);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPost() {
            return this.post;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getNume() {
            return this.nume;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        @NotNull
        public final LinkData copy(@Nullable String tag, @Nullable String type, @Nullable String post, @Nullable String nume, @Nullable String source) {
            return new LinkData(tag, type, post, nume, source);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkData)) {
                return false;
            }
            LinkData linkData = (LinkData) other;
            return Intrinsics.areEqual(this.tag, linkData.tag) && Intrinsics.areEqual(this.type, linkData.type) && Intrinsics.areEqual(this.post, linkData.post) && Intrinsics.areEqual(this.nume, linkData.nume) && Intrinsics.areEqual(this.source, linkData.source);
        }

        public int hashCode() {
            return ((((((((this.tag == null ? 0 : this.tag.hashCode()) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.post == null ? 0 : this.post.hashCode())) * 31) + (this.nume == null ? 0 : this.nume.hashCode())) * 31) + (this.source != null ? this.source.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "LinkData(tag=" + this.tag + ", type=" + this.type + ", post=" + this.post + ", nume=" + this.nume + ", source=" + this.source + ')';
        }

        public LinkData(@Nullable String tag, @Nullable String type, @Nullable String post, @Nullable String nume, @Nullable String source) {
            this.tag = tag;
            this.type = type;
            this.post = post;
            this.nume = nume;
            this.source = source;
        }

        public /* synthetic */ LinkData(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
        }

        @Nullable
        public final String getTag() {
            return this.tag;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getPost() {
            return this.post;
        }

        @Nullable
        public final String getNume() {
            return this.nume;
        }

        @Nullable
        public final String getSource() {
            return this.source;
        }
    }

    @Nullable
    public final SearchQuality getSearchQuality(@Nullable String check) {
        if (check == null) {
            return null;
        }
        String u = Normalizer.normalize(check, Normalizer.Form.NFKC).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(u, "toLowerCase(...)");
        List<Pair> patterns = CollectionsKt.listOf(new Pair[]{TuplesKt.to(new Regex("\\b(4k|ds4k|uhd|2160p)\\b", RegexOption.IGNORE_CASE), SearchQuality.FourK), TuplesKt.to(new Regex("\\b(hdts|hdcam|hdtc)\\b", RegexOption.IGNORE_CASE), SearchQuality.HdCam), TuplesKt.to(new Regex("\\b(camrip|cam[- ]?rip)\\b", RegexOption.IGNORE_CASE), SearchQuality.CamRip), TuplesKt.to(new Regex("\\b(cam)\\b", RegexOption.IGNORE_CASE), SearchQuality.Cam), TuplesKt.to(new Regex("\\b(web[- ]?dl|webrip|webdl)\\b", RegexOption.IGNORE_CASE), SearchQuality.WebRip), TuplesKt.to(new Regex("\\b(bluray|bdrip|blu[- ]?ray)\\b", RegexOption.IGNORE_CASE), SearchQuality.BlueRay), TuplesKt.to(new Regex("\\b(1440p|qhd)\\b", RegexOption.IGNORE_CASE), SearchQuality.BlueRay), TuplesKt.to(new Regex("\\b(1080p|fullhd)\\b", RegexOption.IGNORE_CASE), SearchQuality.HD), TuplesKt.to(new Regex("\\b(720p)\\b", RegexOption.IGNORE_CASE), SearchQuality.SD), TuplesKt.to(new Regex("\\b(hdrip|hdtv|HD)\\b", RegexOption.IGNORE_CASE), SearchQuality.HD), TuplesKt.to(new Regex("\\b(dvd)\\b", RegexOption.IGNORE_CASE), SearchQuality.DVD), TuplesKt.to(new Regex("\\b(hq)\\b", RegexOption.IGNORE_CASE), SearchQuality.HQ), TuplesKt.to(new Regex("\\b(rip)\\b", RegexOption.IGNORE_CASE), SearchQuality.CamRip)});
        for (Pair pair : patterns) {
            Regex regex = (Regex) pair.component1();
            SearchQuality quality = (SearchQuality) pair.component2();
            if (regex.containsMatchIn(u)) {
                return quality;
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: Hdmovie2.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/Hdmovie2/Hdmovie2$ResponseHash;", "", "embed_url", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmbed_url", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Hdmovie2"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ResponseHash {

        @NotNull
        private final String embed_url;

        @Nullable
        private final String type;

        public static /* synthetic */ ResponseHash copy$default(ResponseHash responseHash, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = responseHash.embed_url;
            }
            if ((i & 2) != 0) {
                str2 = responseHash.type;
            }
            return responseHash.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEmbed_url() {
            return this.embed_url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final ResponseHash copy(@NotNull String embed_url, @Nullable String type) {
            return new ResponseHash(embed_url, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResponseHash)) {
                return false;
            }
            ResponseHash responseHash = (ResponseHash) other;
            return Intrinsics.areEqual(this.embed_url, responseHash.embed_url) && Intrinsics.areEqual(this.type, responseHash.type);
        }

        public int hashCode() {
            return (this.embed_url.hashCode() * 31) + (this.type == null ? 0 : this.type.hashCode());
        }

        @NotNull
        public String toString() {
            return "ResponseHash(embed_url=" + this.embed_url + ", type=" + this.type + ')';
        }

        public ResponseHash(@NotNull String embed_url, @Nullable String type) {
            this.embed_url = embed_url;
            this.type = type;
        }

        @NotNull
        public final String getEmbed_url() {
            return this.embed_url;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }
    }
}
