package com.IStreamFlare;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LiveStreamLoadResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.SearchResponse;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IStreamFlare.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/IStreamFlare/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J\f\u0010(\u001a\u00020)*\u00020*H\u0002J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u001e2\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020)0\u001e2\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-JF\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u000e2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208062\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020806H\u0096@¢\u0006\u0002\u0010;J\u0016\u0010<\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010-R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006>"}, d2 = {"Lcom/IStreamFlare/IStreamFlare;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/IStreamFlare/HomeRes;", "quickSearch", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDecodedJson", "Companion", "IStreamFlare"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIStreamFlare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IStreamFlare.kt\ncom/IStreamFlare/IStreamFlare\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,581:1\n63#2:582\n64#2,15:584\n63#2:601\n64#2,15:603\n63#2:624\n64#2,15:626\n63#2:643\n64#2,15:645\n93#2,2:666\n63#2:668\n64#2,15:670\n95#2,2:687\n63#2:689\n64#2,15:691\n63#2:708\n64#2,15:710\n63#2:727\n64#2,15:729\n63#2:747\n64#2,15:749\n63#2:766\n64#2,15:768\n63#2:786\n64#2,15:788\n63#2:808\n64#2,15:810\n63#2:827\n64#2,15:829\n63#2:846\n64#2,15:848\n1#3:583\n1#3:602\n1#3:625\n1#3:644\n1#3:669\n1#3:690\n1#3:709\n1#3:728\n1#3:746\n1#3:748\n1#3:767\n1#3:787\n1#3:809\n1#3:828\n1#3:847\n1#3:866\n50#4:599\n43#4:600\n50#4:618\n43#4:619\n50#4:641\n43#4:642\n50#4:660\n43#4:661\n50#4:685\n43#4:686\n50#4:706\n43#4:707\n50#4:725\n43#4:726\n50#4:744\n43#4:745\n50#4:764\n43#4:765\n50#4:783\n43#4:784\n50#4:803\n43#4:804\n50#4:825\n43#4:826\n50#4:844\n43#4:845\n50#4:863\n43#4:864\n1739#5:620\n1814#5,3:621\n1739#5:662\n1814#5,3:663\n2068#5:785\n2068#5,2:805\n2069#5:807\n2068#5:865\n2069#5:867\n*S KotlinDebug\n*F\n+ 1 IStreamFlare.kt\ncom/IStreamFlare/IStreamFlare\n*L\n97#1:582\n97#1:584,15\n109#1:601\n109#1:603,15\n172#1:624\n172#1:626,15\n183#1:643\n183#1:645,15\n197#1:666,2\n197#1:668\n197#1:670,15\n197#1:687,2\n236#1:689\n236#1:691,15\n248#1:708\n248#1:710,15\n264#1:727\n264#1:729,15\n283#1:747\n283#1:749,15\n309#1:766\n309#1:768,15\n334#1:786\n334#1:788,15\n489#1:808\n489#1:810,15\n499#1:827\n499#1:829,15\n562#1:846\n562#1:848,15\n97#1:583\n109#1:602\n172#1:625\n183#1:644\n197#1:669\n236#1:690\n248#1:709\n264#1:728\n283#1:748\n309#1:767\n334#1:787\n489#1:809\n499#1:828\n562#1:847\n97#1:599\n97#1:600\n109#1:618\n109#1:619\n172#1:641\n172#1:642\n183#1:660\n183#1:661\n197#1:685\n197#1:686\n236#1:706\n236#1:707\n248#1:725\n248#1:726\n264#1:744\n264#1:745\n283#1:764\n283#1:765\n309#1:783\n309#1:784\n334#1:803\n334#1:804\n489#1:825\n489#1:826\n499#1:844\n499#1:845\n562#1:863\n562#1:864\n114#1:620\n114#1:621,3\n188#1:662\n188#1:663,3\n314#1:785\n339#1:805,2\n314#1:807\n436#1:865\n436#1:867\n*E\n"})
public final class IStreamFlare extends MainAPI {

    @NotNull
    private static final String cinemeta_url = "https://v3-cinemeta.strem.io/meta";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";

    @NotNull
    private static final Map<String, String> headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", USER_AGENT), TuplesKt.to("x-api-key", "kC7V1f8QRaZyvYnh")});

    @NotNull
    private String mainUrl = "https://stream.hippitunes.pro";

    @NotNull
    private String name = "IStreamFlare";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasDownloadSupport = true;
    private final boolean hasQuickSearch = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("android/getTrending", "Trending"), TuplesKt.to("android/getMostWatched/Movies/page", "Most Watched Movies"), TuplesKt.to("android/getMostWatched/WebSeries/page", "Most Watched Webseries"), TuplesKt.to("android/getRecentContentList/Movies", "Recently Added Movies"), TuplesKt.to("android/getRecentContentList/WebSeries", "Recently Added Webseries"), TuplesKt.to("android/getRandWebSeries", "Webseries"), TuplesKt.to("android/getRandMovies", "Movies"), TuplesKt.to("android/getAllLiveTV", "TV Channels")});

    /* JADX INFO: renamed from: com.IStreamFlare.IStreamFlare$getDecodedJson$1 */
    /* JADX INFO: compiled from: IStreamFlare.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare", f = "IStreamFlare.kt", i = {0}, l = {554}, m = "getDecodedJson", n = {"url"}, nl = {557}, s = {"L$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
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
            return IStreamFlare.this.getDecodedJson(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.IStreamFlare.IStreamFlare$getMainPage$1 */
    /* JADX INFO: compiled from: IStreamFlare.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare", f = "IStreamFlare.kt", i = {0, 0, 0, 0}, l = {91}, m = "getMainPage", n = {"request", "url", "page", "isLiveTv"}, nl = {94}, s = {"L$0", "L$1", "I$0", "Z$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IStreamFlare.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.IStreamFlare.IStreamFlare$load$1 */
    /* JADX INFO: compiled from: IStreamFlare.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare", f = "IStreamFlare.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {207, 231, 260, 279, 304, 328, 390, 411}, m = "load", n = {"url", "res", "url", "res", "type", "endpoint", "isMovie", "url", "res", "type", "endpoint", "rawJson", "parsedElement", "dataElement", "resJson", "$this$load_u24lambda_u240", "isMovie", "url", "res", "type", "endpoint", "rawJson", "parsedElement", "dataElement", "resJson", "imdbId", "it", "$this$load_u24lambda_u242_u240", "isMovie", "url", "res", "type", "endpoint", "rawJson", "parsedElement", "dataElement", "resJson", "imdbId", "responseData", "meta", "poster", "description", "cast", "year", "episodesList", "isMovie", "url", "res", "type", "endpoint", "rawJson", "parsedElement", "dataElement", "resJson", "imdbId", "responseData", "meta", "poster", "description", "cast", "year", "episodesList", "seasonsRaw", "seasons", "$this$forEach$iv", "element$iv", "season", "isMovie", "seasonNumber", "url", "res", "type", "endpoint", "rawJson", "parsedElement", "dataElement", "resJson", "imdbId", "responseData", "meta", "poster", "description", "cast", "year", "episodesList", "seasonsRaw", "seasons", "isMovie", "url", "res", "type", "endpoint", "rawJson", "parsedElement", "dataElement", "resJson", "imdbId", "responseData", "meta", "poster", "description", "cast", "year", "href", "isMovie"}, nl = {217, 235, 262, 281, 308, 327, 409, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$20", "L$21", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
        int I$1;
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
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IStreamFlare.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.IStreamFlare.IStreamFlare$loadLinks$1 */
    /* JADX INFO: compiled from: IStreamFlare.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare", f = "IStreamFlare.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 6}, l = {487, 491, 497, 501, 508, 523, 532}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "decodedJson", "links", "isCasting", "data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "decodedJson", "links", "isCasting", "data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "type", "isCasting"}, nl = {488, 492, 498, 502, 507, 524, 531}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
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
            return IStreamFlare.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.IStreamFlare.IStreamFlare$search$1 */
    /* JADX INFO: compiled from: IStreamFlare.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare", f = "IStreamFlare.kt", i = {0, 0, 1, 1, 1, 1}, l = {167, 177}, m = "search", n = {"query", "url", "query", "url", "raw", "outer"}, nl = {170, 179}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IStreamFlare.this.search(null, (Continuation) this);
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

    /* JADX INFO: compiled from: IStreamFlare.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/IStreamFlare/IStreamFlare$Companion;", "", "<init>", "()V", "USER_AGENT", "", "headers", "", "getHeaders", "()Ljava/util/Map;", "cinemeta_url", "IStreamFlare"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Map<String, String> getHeaders() {
            return IStreamFlare.headers;
        }
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:94:0x028c A[LOOP:0: B:92:0x0286->B:94:0x028c, LOOP_END] */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00011 c00011;
        String url;
        int i;
        MainPageRequest request2;
        boolean isLiveTv;
        Object obj;
        Object objDecodeFromString;
        Iterable homeList;
        Collection destination$iv$iv;
        Object obj2;
        Object objDecodeFromString2;
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
                boolean isLiveTv2 = StringsKt.contains(request.getData(), "android/getAllLiveTV", true);
                if (StringsKt.endsWith$default(request.getData(), "page", false, 2, (Object) null)) {
                    int offset = (page - 1) * 10;
                    url = getMainUrl() + '/' + StringsKt.removeSuffix(request.getData(), "page") + offset;
                } else {
                    url = getMainUrl() + '/' + request.getData();
                }
                Requests app = MainActivityKt.getApp();
                Map<String, String> map = headers;
                c00011.L$0 = request;
                c00011.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00011.I$0 = page;
                c00011.Z$0 = isLiveTv2;
                c00011.label = 1;
                i = 2;
                $result = Requests.get$default(app, url, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00011, 4092, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                isLiveTv = isLiveTv2;
                break;
                break;
            case 1:
                isLiveTv = c00011.Z$0;
                int i2 = c00011.I$0;
                request2 = (MainPageRequest) c00011.L$0;
                ResultKt.throwOnFailure($result);
                i = 2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String responseText = ((NiceResponse) $result).getTextLarge();
        try {
            AppUtils appUtils = AppUtils.INSTANCE;
            try {
                Result.Companion companion = Result.Companion;
                KType kTypeTypeOf = Reflection.typeOf(Response.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.exceptionOrNull-impl(obj) != null) {
                try {
                    Result.Companion companion3 = Result.Companion;
                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Response.class), (List) null, i, (Object) null));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th2));
                }
            }
            Object obj3 = obj;
            if (Result.isFailure-impl(obj3)) {
                obj3 = null;
            }
            DeserializationStrategy deserializationStrategy = (KSerializer) obj3;
            if (deserializationStrategy != null) {
                try {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, responseText);
                } catch (SerializationException e) {
                    ArchComponentExtKt.logError(e);
                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv.readValue(responseText, new TypeReference<Response>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$1
                    });
                } catch (Throwable th3) {
                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv2.readValue(responseText, new TypeReference<Response>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$1
                    });
                }
            } else {
                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv3.readValue(responseText, new TypeReference<Response>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$1
                });
            }
            Response root = (Response) objDecodeFromString;
            String jsonData = root.getEncrypted() ? IStreamFlareParserKt.decryptPayload(root.getData()) : root.getData();
            try {
                AppUtils appUtils2 = AppUtils.INSTANCE;
                try {
                    Result.Companion companion5 = Result.Companion;
                    KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                } catch (Throwable th4) {
                    Result.Companion companion6 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th4));
                }
                if (Result.exceptionOrNull-impl(obj2) != null) {
                    try {
                        Result.Companion companion7 = Result.Companion;
                        try {
                            obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                Result.Companion companion8 = Result.Companion;
                                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            } catch (Exception e2) {
                                homeList = CollectionsKt.emptyList();
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                }
                if (Result.isFailure-impl(obj2)) {
                    obj2 = null;
                }
                DeserializationStrategy deserializationStrategy2 = (KSerializer) obj2;
                if (deserializationStrategy2 != null) {
                    try {
                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonData);
                    } catch (SerializationException e3) {
                        ArchComponentExtKt.logError(e3);
                        ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv4.readValue(jsonData, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$2
                        });
                    } catch (Throwable th7) {
                        ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv5.readValue(jsonData, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$2
                        });
                    }
                    homeList = (List) objDecodeFromString2;
                } else {
                    ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv6.readValue(jsonData, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$2
                    });
                    homeList = (List) objDecodeFromString2;
                }
            } catch (Exception e4) {
                homeList = CollectionsKt.emptyList();
                Iterable $this$map$iv = homeList;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    HomeRes it = (HomeRes) item$iv$iv;
                    destination$iv$iv.add(toSearchResult(it));
                }
                List searchResults = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), searchResults, isLiveTv), Boxing.boxBoolean(!searchResults.isEmpty()));
            }
            Iterable $this$map$iv2 = homeList;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            while (r13.hasNext()) {
                HomeRes it2 = (HomeRes) item$iv$iv;
                destination$iv$iv.add(toSearchResult(it2));
            }
            List searchResults2 = (List) destination$iv$iv;
            return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), searchResults2, isLiveTv), Boxing.boxBoolean(!searchResults2.isEmpty()));
        } catch (Exception e5) {
            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
        }
    }

    private final SearchResponse toSearchResult(HomeRes $this$toSearchResult) {
        String strSubstringBefore$default;
        String custom_tags_name;
        String title = $this$toSearchResult.getName();
        String poster = $this$toSearchResult.getPoster();
        if (poster == null) {
            poster = $this$toSearchResult.getBanner();
        }
        final String posterUrl = poster;
        CustomTag custom_tag = $this$toSearchResult.getCustom_tag();
        if (custom_tag == null || (custom_tags_name = custom_tag.getCustom_tags_name()) == null || (strSubstringBefore$default = StringsKt.substringBefore$default(custom_tags_name, "+", (String) null, 2, (Object) null)) == null) {
            strSubstringBefore$default = "";
        }
        final String quality = strSubstringBefore$default;
        LoadDataObject loadData = new LoadDataObject($this$toSearchResult.getId(), $this$toSearchResult.getTMDB_ID(), $this$toSearchResult.getContent_type(), $this$toSearchResult.getUrl());
        return MainAPIKt.newMovieSearchResponse$default(this, title, AppUtils.INSTANCE.toJson(loadData), TvType.Movie, false, new Function1() { // from class: com.IStreamFlare.IStreamFlare$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return IStreamFlare.toSearchResult$lambda$0(posterUrl, quality, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, String $quality, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setQuality(MainAPIKt.getQualityFromString($quality));
        return Unit.INSTANCE;
    }

    @Nullable
    public Object quickSearch(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        return search(query, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:107:0x021e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x013d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x0136  */
    /* JADX WARN: Code duplicated, block: B:41:0x0152  */
    /* JADX WARN: Code duplicated, block: B:48:0x017d  */
    /* JADX WARN: Code duplicated, block: B:50:0x019f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:74:0x0216  */
    /* JADX WARN: Code duplicated, block: B:75:0x0217  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:84:0x0233 A[Catch: Exception -> 0x024b, TryCatch #5 {Exception -> 0x024b, blocks: (B:54:0x01ad, B:60:0x01df, B:72:0x0210, B:76:0x0218, B:85:0x0248, B:84:0x0233, B:83:0x022d, B:71:0x0206, B:59:0x01d5, B:56:0x01b2, B:78:0x021e), top: B:103:0x01ad, inners: #4, #10 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x026f A[LOOP:0: B:90:0x0269->B:92:0x026f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:97:0x0109 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00091 c00091;
        Object obj;
        int i;
        String query2;
        String url;
        String value$iv;
        String raw;
        Object obj2;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        JsonNode outer;
        JsonNode jsonNode;
        boolean z;
        IStreamFlare iStreamFlare;
        Object decodedJson;
        Iterable homeList;
        Collection destination$iv$iv;
        String value$iv2;
        Object obj3;
        Object obj4;
        DeserializationStrategy deserializationStrategy2;
        Object objDecodeFromString2;
        if (continuation instanceof C00091) {
            c00091 = (C00091) continuation;
            if ((c00091.label & Integer.MIN_VALUE) != 0) {
                c00091.label -= Integer.MIN_VALUE;
            } else {
                c00091 = new C00091(continuation);
            }
        } else {
            c00091 = new C00091(continuation);
        }
        C00091 c00092 = c00091;
        Object $result = c00092.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00092.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url2 = getMainUrl() + "/android/searchContent/" + query + "/1";
                Requests app = MainActivityKt.getApp();
                Map<String, String> map = headers;
                c00092.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00092.L$1 = url2;
                c00092.label = 1;
                obj = coroutine_suspended;
                i = 2;
                Object obj5 = Requests.get$default(app, url2, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00092, 4092, (Object) null);
                c00092 = c00092;
                if (obj5 == obj) {
                    return obj;
                }
                query2 = query;
                url = url2;
                $result = obj5;
                value$iv = ((NiceResponse) $result).getTextLarge();
                raw = value$iv;
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(JsonNode.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    break;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj2) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, i, (Object) null));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    break;
                }
                if (Result.isFailure-impl(obj2)) {
                    obj2 = null;
                }
                deserializationStrategy = (KSerializer) obj2;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(value$iv, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(value$iv, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(value$iv, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$1
                    });
                }
                outer = (JsonNode) objDecodeFromString;
                jsonNode = outer.get("encrypted");
                z = false;
                if (jsonNode != null && jsonNode.asBoolean()) {
                    z = true;
                }
                if (z) {
                    c00092.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                    c00092.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00092.L$2 = SpillingKt.nullOutSpilledVariable(raw);
                    c00092.L$3 = SpillingKt.nullOutSpilledVariable(outer);
                    c00092.label = i;
                    iStreamFlare = this;
                    decodedJson = iStreamFlare.getDecodedJson(url, c00092);
                    if (decodedJson == obj) {
                        return obj;
                    }
                    raw = (String) decodedJson;
                } else {
                    iStreamFlare = this;
                }
                try {
                    AppUtils appUtils2 = AppUtils.INSTANCE;
                    value$iv2 = raw;
                    try {
                        Result.Companion companion5 = Result.Companion;
                        KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                    } catch (Throwable th4) {
                        Result.Companion companion6 = Result.Companion;
                        obj3 = Result.constructor-impl(ResultKt.createFailure(th4));
                    }
                    if (Result.exceptionOrNull-impl(obj3) == null) {
                        obj4 = null;
                    } else {
                        try {
                            Result.Companion companion7 = Result.Companion;
                            obj4 = null;
                            try {
                                obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, i, (Object) null));
                            } catch (Throwable th5) {
                                th = th5;
                                Result.Companion companion8 = Result.Companion;
                                obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            obj4 = null;
                        }
                    }
                    if (!Result.isFailure-impl(obj3)) {
                        obj4 = obj3;
                    }
                    deserializationStrategy2 = (KSerializer) obj4;
                    if (deserializationStrategy2 != null) {
                        try {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                        } catch (SerializationException e2) {
                            ArchComponentExtKt.logError(e2);
                            ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv4.readValue(value$iv2, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$2
                            });
                        } catch (Throwable th7) {
                            ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv5.readValue(value$iv2, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$2
                            });
                        }
                        homeList = (List) objDecodeFromString2;
                    } else {
                        ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv6.readValue(value$iv2, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$2
                        });
                        homeList = (List) objDecodeFromString2;
                    }
                    break;
                } catch (Exception e3) {
                    homeList = CollectionsKt.emptyList();
                }
                Iterable $this$map$iv = homeList;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    HomeRes it = (HomeRes) item$iv$iv;
                    destination$iv$iv.add(iStreamFlare.toSearchResult(it));
                }
                return (List) destination$iv$iv;
            case 1:
                String url3 = (String) c00092.L$1;
                query2 = (String) c00092.L$0;
                ResultKt.throwOnFailure($result);
                url = url3;
                obj = coroutine_suspended;
                i = 2;
                value$iv = ((NiceResponse) $result).getTextLarge();
                raw = value$iv;
                AppUtils appUtils3 = AppUtils.INSTANCE;
                Result.Companion companion9 = Result.Companion;
                KType kTypeTypeOf3 = Reflection.typeOf(JsonNode.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                if (Result.exceptionOrNull-impl(obj2) != null) {
                    Result.Companion companion10 = Result.Companion;
                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, i, (Object) null));
                    break;
                }
                if (Result.isFailure-impl(obj2)) {
                    obj2 = null;
                }
                deserializationStrategy = (KSerializer) obj2;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv7.readValue(value$iv, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$1
                    });
                }
                outer = (JsonNode) objDecodeFromString;
                jsonNode = outer.get("encrypted");
                z = false;
                if (jsonNode != null) {
                    z = true;
                }
                if (z) {
                    c00092.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                    c00092.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00092.L$2 = SpillingKt.nullOutSpilledVariable(raw);
                    c00092.L$3 = SpillingKt.nullOutSpilledVariable(outer);
                    c00092.label = i;
                    iStreamFlare = this;
                    decodedJson = iStreamFlare.getDecodedJson(url, c00092);
                    if (decodedJson == obj) {
                        return obj;
                    }
                    raw = (String) decodedJson;
                } else {
                    iStreamFlare = this;
                }
                AppUtils appUtils4 = AppUtils.INSTANCE;
                value$iv2 = raw;
                Result.Companion companion11 = Result.Companion;
                KType kTypeTypeOf4 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                if (Result.exceptionOrNull-impl(obj3) == null) {
                    Result.Companion companion12 = Result.Companion;
                    obj4 = null;
                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, i, (Object) null));
                    break;
                } else {
                    obj4 = null;
                }
                if (!Result.isFailure-impl(obj3)) {
                    obj4 = obj3;
                }
                deserializationStrategy2 = (KSerializer) obj4;
                if (deserializationStrategy2 != null) {
                    ObjectMapper $this$readValue$iv$iv8 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv8.readValue(value$iv2, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$2
                    });
                    homeList = (List) objDecodeFromString2;
                    break;
                } else {
                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                    homeList = (List) objDecodeFromString2;
                    break;
                }
                Iterable $this$map$iv2 = homeList;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r13.hasNext()) {
                    HomeRes it2 = (HomeRes) item$iv$iv;
                    destination$iv$iv.add(iStreamFlare.toSearchResult(it2));
                }
                return (List) destination$iv$iv;
            case 2:
                outer = (JsonNode) c00092.L$3;
                raw = (String) c00092.L$2;
                ResultKt.throwOnFailure($result);
                decodedJson = $result;
                iStreamFlare = this;
                i = 2;
                raw = (String) decodedJson;
                AppUtils appUtils5 = AppUtils.INSTANCE;
                value$iv2 = raw;
                Result.Companion companion13 = Result.Companion;
                KType kTypeTypeOf5 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                if (Result.exceptionOrNull-impl(obj3) == null) {
                    Result.Companion companion14 = Result.Companion;
                    obj4 = null;
                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, i, (Object) null));
                    break;
                } else {
                    obj4 = null;
                }
                if (!Result.isFailure-impl(obj3)) {
                    obj4 = obj3;
                }
                deserializationStrategy2 = (KSerializer) obj4;
                if (deserializationStrategy2 != null) {
                    ObjectMapper $this$readValue$iv$iv9 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv9.readValue(value$iv2, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$2
                    });
                    homeList = (List) objDecodeFromString2;
                    break;
                } else {
                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                    homeList = (List) objDecodeFromString2;
                    break;
                }
                Iterable $this$map$iv3 = homeList;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r13.hasNext()) {
                    HomeRes it3 = (HomeRes) item$iv$iv;
                    destination$iv$iv.add(iStreamFlare.toSearchResult(it3));
                }
                return (List) destination$iv$iv;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:418:0x0bf2  */
    /* JADX WARN: Code duplicated, block: B:421:0x0c08  */
    /* JADX WARN: Code duplicated, block: B:497:0x0df4  */
    /* JADX WARN: Code duplicated, block: B:499:0x0e0a  */
    /* JADX WARN: Code duplicated, block: B:501:0x0e2b  */
    /* JADX WARN: Code duplicated, block: B:503:0x0e3e  */
    /* JADX WARN: Code duplicated, block: B:504:0x0e41  */
    /* JADX WARN: Code duplicated, block: B:505:0x0e65  */
    /* JADX WARN: Code duplicated, block: B:509:0x0e7c  */
    /* JADX WARN: Code duplicated, block: B:510:0x0e8f  */
    /* JADX WARN: Code duplicated, block: B:512:0x0e92  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Path cross not found for [B:639:0x071f, B:229:0x0734], limit reached: 604 */
    /* JADX WARN: Path cross not found for [B:649:0x0952, B:307:0x0967], limit reached: 604 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:435:0x0cde -> B:436:0x0cfd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:515:0x0ed5 -> B:516:0x0ef1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r50, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r51) {
        /*
            Method dump skipped, instruction units count: 4386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.IStreamFlare.IStreamFlare.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.IStreamFlare.IStreamFlare$load$2 */
    /* JADX INFO: compiled from: IStreamFlare.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/LiveStreamLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare$load$2", f = "IStreamFlare.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00032 extends SuspendLambda implements Function2<LiveStreamLoadResponse, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00032(Continuation<? super C00032> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00032 = new C00032(continuation);
            c00032.L$0 = obj;
            return c00032;
        }

        public final Object invoke(LiveStreamLoadResponse liveStreamLoadResponse, Continuation<? super Unit> continuation) {
            return create(liveStreamLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LiveStreamLoadResponse $this$newLiveStreamLoadResponse = (LiveStreamLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newLiveStreamLoadResponse.setPosterUrl((String) null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$3$0$0(EpisodesRes $episode, int $seasonNumber, int $epNumber, Episode $this$newEpisode) {
        String episoade_Name = $episode.getEpisoade_Name();
        if (StringsKt.isBlank(episoade_Name)) {
            episoade_Name = "Episode " + $epNumber;
        }
        $this$newEpisode.setName(episoade_Name);
        $this$newEpisode.setSeason(Integer.valueOf($seasonNumber));
        $this$newEpisode.setEpisode(Integer.valueOf($epNumber));
        $this$newEpisode.setPosterUrl($episode.getEpisoade_image());
        $this$newEpisode.setDescription($episode.getEpisoade_description());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.IStreamFlare.IStreamFlare$load$4 */
    /* JADX INFO: compiled from: IStreamFlare.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare$load$4", f = "IStreamFlare.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00044 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $cast;
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ HomeRes $resJson;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00044(String str, String str2, Integer num, HomeRes homeRes, List<String> list, Continuation<? super C00044> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$year = num;
            this.$resJson = homeRes;
            this.$cast = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00044 = new C00044(this.$poster, this.$description, this.$year, this.$resJson, this.$cast, continuation);
            c00044.L$0 = obj;
            return c00044;
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
                    loadResponse.setBackgroundPosterUrl(this.$poster);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setYear(this.$year);
                    LoadResponse.Companion.addTMDbId(loadResponse, this.$resJson.getTMDB_ID());
                    LoadResponse.Companion.addActorNames(loadResponse, this.$cast);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.IStreamFlare.IStreamFlare$load$5 */
    /* JADX INFO: compiled from: IStreamFlare.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare$load$5", f = "IStreamFlare.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00055 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $cast;
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ HomeRes $resJson;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00055(String str, String str2, Integer num, HomeRes homeRes, List<String> list, Continuation<? super C00055> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$year = num;
            this.$resJson = homeRes;
            this.$cast = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00055 = new C00055(this.$poster, this.$description, this.$year, this.$resJson, this.$cast, continuation);
            c00055.L$0 = obj;
            return c00055;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setYear(this.$year);
                    LoadResponse.Companion.addTMDbId(loadResponse, this.$resJson.getTMDB_ID());
                    LoadResponse.Companion.addActorNames(loadResponse, this.$cast);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:111:0x02ce A[Catch: Exception -> 0x02ea, TryCatch #8 {Exception -> 0x02ea, blocks: (B:99:0x02ac, B:102:0x02b3, B:112:0x02e7, B:111:0x02ce, B:110:0x02c8, B:98:0x02a2, B:105:0x02b9), top: B:166:0x02a2, inners: #15 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0324 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:124:0x0325  */
    /* JADX WARN: Code duplicated, block: B:172:0x015a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x027d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x02b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x018a  */
    /* JADX WARN: Code duplicated, block: B:42:0x018c  */
    /* JADX WARN: Code duplicated, block: B:54:0x01af A[Catch: Exception -> 0x01cd, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x01cd, blocks: (B:26:0x011d, B:32:0x0153, B:39:0x0184, B:43:0x018d, B:54:0x01af, B:38:0x0179, B:31:0x0149, B:28:0x0124, B:35:0x015a), top: B:156:0x011d, inners: #10, #11 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x01ff A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:67:0x0200  */
    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    /* JADX WARN: Code duplicated, block: B:89:0x027a  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00061 c00061;
        Object obj;
        Function1<? super ExtractorLink, Unit> function3;
        Function1<? super SubtitleFile, Unit> function4;
        Function1<? super ExtractorLink, Unit> function5;
        Object obj2;
        Function1<? super SubtitleFile, Unit> function6;
        Function1<? super ExtractorLink, Unit> function7;
        Function1<? super ExtractorLink, Unit> function8;
        boolean isCasting2;
        Object obj3;
        boolean isCasting3;
        Object obj4;
        String decodedJson;
        String data2;
        List links;
        Object obj5;
        Object obj6;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        String decodedJson2;
        String data3;
        String decodedJson3;
        List links2;
        Object obj7;
        DeserializationStrategy deserializationStrategy2;
        Object objDecodeFromString2;
        String data4 = data;
        Function1<? super SubtitleFile, Unit> function9 = function1;
        Function1<? super ExtractorLink, Unit> function10 = function2;
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
        C00061 c00062 = c00061;
        Object $result = c00062.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (c00062.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (StringsKt.contains(data4, "getMoviePlayLinks", true)) {
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$1 = function9;
                    c00062.L$2 = function10;
                    c00062.Z$0 = isCasting;
                    c00062.label = 1;
                    Object decodedJson4 = getDecodedJson(data4, c00062);
                    if (decodedJson4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isCasting3 = isCasting;
                    obj4 = decodedJson4;
                    decodedJson = (String) obj4;
                    try {
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamLinks.class)));
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj5) != null) {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            } catch (Throwable th2) {
                                Result.Companion companion4 = Result.Companion;
                                obj5 = Result.constructor-impl(ResultKt.createFailure(th2));
                            }
                        }
                        if (Result.isFailure-impl(obj5)) {
                            obj6 = null;
                        } else {
                            obj6 = obj5;
                        }
                        deserializationStrategy = (KSerializer) obj6;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decodedJson);
                                data2 = data4;
                            } catch (SerializationException e) {
                                try {
                                    ArchComponentExtKt.logError(e);
                                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                    data2 = data4;
                                    try {
                                        objDecodeFromString = $this$readValue$iv$iv.readValue(decodedJson, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$1
                                        });
                                    } catch (Exception e2) {
                                        links = CollectionsKt.emptyList();
                                    }
                                } catch (Exception e3) {
                                    data2 = data4;
                                    links = CollectionsKt.emptyList();
                                }
                            } catch (Throwable th3) {
                                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                data2 = data4;
                                objDecodeFromString = $this$readValue$iv$iv2.readValue(decodedJson, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$1
                                });
                            }
                            links = (List) objDecodeFromString;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(links);
                            c00062.Z$0 = isCasting3;
                            c00062.label = 2;
                            if (loadLinks$processLinks(function10, this, function9, links, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z = true;
                        } else {
                            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                            data2 = data4;
                            objDecodeFromString = $this$readValue$iv$iv3.readValue(decodedJson, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$1
                            });
                            links = (List) objDecodeFromString;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(links);
                            c00062.Z$0 = isCasting3;
                            c00062.label = 2;
                            if (loadLinks$processLinks(function10, this, function9, links, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z = true;
                        }
                    } catch (Exception e4) {
                        data2 = data4;
                    }
                    break;
                } else if (StringsKt.contains(data4, "getEpisodePlayLinks", true)) {
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$1 = function9;
                    c00062.L$2 = function10;
                    c00062.Z$0 = isCasting;
                    c00062.label = 3;
                    Object decodedJson5 = getDecodedJson(data4, c00062);
                    if (decodedJson5 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isCasting2 = isCasting;
                    obj3 = decodedJson5;
                    decodedJson2 = (String) obj3;
                    try {
                        AppUtils appUtils2 = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion5 = Result.Companion;
                            data3 = data4;
                            try {
                                KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamLinks.class)));
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj7 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                break;
                            } catch (Throwable th4) {
                                th = th4;
                                try {
                                    Result.Companion companion6 = Result.Companion;
                                    obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Exception e5) {
                                    decodedJson3 = decodedJson2;
                                    links2 = CollectionsKt.emptyList();
                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson3);
                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(links2);
                                    c00062.Z$0 = isCasting2;
                                    c00062.label = 4;
                                    if (loadLinks$processLinks(function10, this, function9, links2, c00062) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    z = true;
                                    return Boxing.boxBoolean(z);
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            data3 = data4;
                        }
                        if (Result.exceptionOrNull-impl(obj7) != null) {
                            decodedJson3 = decodedJson2;
                        } else {
                            try {
                                Result.Companion companion7 = Result.Companion;
                                decodedJson3 = decodedJson2;
                                try {
                                    obj7 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                    break;
                                } catch (Throwable th6) {
                                    th = th6;
                                    try {
                                        Result.Companion companion8 = Result.Companion;
                                        obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                    } catch (Exception e6) {
                                        links2 = CollectionsKt.emptyList();
                                    }
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                decodedJson3 = decodedJson2;
                            }
                        }
                        if (Result.isFailure-impl(obj7)) {
                            obj7 = null;
                        }
                        deserializationStrategy2 = (KSerializer) obj7;
                        if (deserializationStrategy2 != null) {
                            try {
                                objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, decodedJson2);
                            } catch (SerializationException e7) {
                                ArchComponentExtKt.logError(e7);
                                ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv4.readValue(decodedJson2, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$2
                                });
                            } catch (Throwable th8) {
                                ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv5.readValue(decodedJson2, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$2
                                });
                            }
                            links2 = (List) objDecodeFromString2;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson3);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(links2);
                            c00062.Z$0 = isCasting2;
                            c00062.label = 4;
                            if (loadLinks$processLinks(function10, this, function9, links2, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z = true;
                        } else {
                            ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv6.readValue(decodedJson2, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$2
                            });
                            links2 = (List) objDecodeFromString2;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson3);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(links2);
                            c00062.Z$0 = isCasting2;
                            c00062.label = 4;
                            if (loadLinks$processLinks(function10, this, function9, links2, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z = true;
                        }
                    } catch (Exception e8) {
                        data3 = data4;
                        decodedJson3 = decodedJson2;
                    }
                    break;
                } else if (StringsKt.contains(data4, "x7flix", true)) {
                    String name = getName();
                    String name2 = getName();
                    ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                    C00072 c00072 = new C00072(data4, null);
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                    c00062.L$3 = function10;
                    c00062.Z$0 = isCasting;
                    c00062.label = 5;
                    Object objNewExtractorLink = ExtractorApiKt.newExtractorLink(name2, name, data4, extractorLinkType, c00072, c00062);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = objNewExtractorLink;
                    function6 = function9;
                    function7 = function10;
                    function8 = function7;
                    function7.invoke(obj2);
                    z = true;
                } else if (StringsKt.contains(data4, ".php?id=", true)) {
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                    c00062.Z$0 = isCasting;
                    c00062.label = 6;
                    if (ExtractorApiKt.loadExtractor(data4, function9, function10, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function4 = function9;
                    function5 = function10;
                    z = true;
                } else if (StringsKt.startsWith$default(data4, "http", false, 2, (Object) null)) {
                    z = true;
                    ExtractorLinkType type = StringsKt.contains(data4, ".m3u8", true) ? ExtractorLinkType.M3U8 : ExtractorApiKt.getINFER_TYPE();
                    String name3 = getName();
                    String name4 = getName();
                    C00083 c00083 = new C00083(null);
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(type);
                    c00062.L$4 = function10;
                    c00062.Z$0 = isCasting;
                    c00062.label = 7;
                    Object objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name4, name3, data4, type, c00083, c00062);
                    if (objNewExtractorLink2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objNewExtractorLink2;
                    function3 = function10;
                    function3.invoke(obj);
                } else {
                    z = false;
                }
                return Boxing.boxBoolean(z);
            case 1:
                boolean isCasting4 = c00062.Z$0;
                Function1<? super ExtractorLink, Unit> function11 = (Function1) c00062.L$2;
                function9 = (Function1) c00062.L$1;
                data4 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                function10 = function11;
                isCasting3 = isCasting4;
                obj4 = $result;
                decodedJson = (String) obj4;
                AppUtils appUtils3 = AppUtils.INSTANCE;
                Result.Companion companion9 = Result.Companion;
                KType kTypeTypeOf3 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamLinks.class)));
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                if (Result.exceptionOrNull-impl(obj5) != null) {
                    Result.Companion companion10 = Result.Companion;
                    obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                    break;
                }
                if (Result.isFailure-impl(obj5)) {
                    obj6 = null;
                } else {
                    obj6 = obj5;
                }
                deserializationStrategy = (KSerializer) obj6;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decodedJson);
                    data2 = data4;
                    links = (List) objDecodeFromString;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(links);
                    c00062.Z$0 = isCasting3;
                    c00062.label = 2;
                    if (loadLinks$processLinks(function10, this, function9, links, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z = true;
                } else {
                    ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                    data2 = data4;
                    objDecodeFromString = $this$readValue$iv$iv7.readValue(decodedJson, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$1
                    });
                    links = (List) objDecodeFromString;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(links);
                    c00062.Z$0 = isCasting3;
                    c00062.label = 2;
                    if (loadLinks$processLinks(function10, this, function9, links, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z = true;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean isCasting5 = c00062.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            case 3:
                boolean isCasting6 = c00062.Z$0;
                Function1<? super ExtractorLink, Unit> function12 = (Function1) c00062.L$2;
                function9 = (Function1) c00062.L$1;
                data4 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                function10 = function12;
                isCasting2 = isCasting6;
                obj3 = $result;
                decodedJson2 = (String) obj3;
                AppUtils appUtils4 = AppUtils.INSTANCE;
                Result.Companion companion11 = Result.Companion;
                data3 = data4;
                KType kTypeTypeOf4 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamLinks.class)));
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj7 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                if (Result.exceptionOrNull-impl(obj7) != null) {
                    Result.Companion companion12 = Result.Companion;
                    decodedJson3 = decodedJson2;
                    obj7 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                    break;
                } else {
                    decodedJson3 = decodedJson2;
                }
                if (Result.isFailure-impl(obj7)) {
                    obj7 = null;
                }
                deserializationStrategy2 = (KSerializer) obj7;
                if (deserializationStrategy2 != null) {
                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, decodedJson2);
                    links2 = (List) objDecodeFromString2;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson3);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(links2);
                    c00062.Z$0 = isCasting2;
                    c00062.label = 4;
                    if (loadLinks$processLinks(function10, this, function9, links2, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z = true;
                } else {
                    ObjectMapper $this$readValue$iv$iv8 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv8.readValue(decodedJson2, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$2
                    });
                    links2 = (List) objDecodeFromString2;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson3);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(links2);
                    c00062.Z$0 = isCasting2;
                    c00062.label = 4;
                    if (loadLinks$processLinks(function10, this, function9, links2, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z = true;
                }
                return Boxing.boxBoolean(z);
            case 4:
                boolean isCasting7 = c00062.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            case 5:
                boolean isCasting8 = c00062.Z$0;
                function7 = (Function1) c00062.L$3;
                function8 = (Function1) c00062.L$2;
                function6 = (Function1) c00062.L$1;
                ResultKt.throwOnFailure($result);
                obj2 = $result;
                function7.invoke(obj2);
                z = true;
                return Boxing.boxBoolean(z);
            case 6:
                boolean isCasting9 = c00062.Z$0;
                function5 = (Function1) c00062.L$2;
                function4 = (Function1) c00062.L$1;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            case 7:
                boolean z2 = c00062.Z$0;
                function3 = (Function1) c00062.L$4;
                ResultKt.throwOnFailure($result);
                obj = $result;
                function3.invoke(obj);
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:18:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:22:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:24:0x0109  */
    /* JADX WARN: Code duplicated, block: B:27:0x015c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x015d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0177  */
    /* JADX WARN: Code duplicated, block: B:32:0x018b  */
    /* JADX WARN: Code duplicated, block: B:34:0x01c3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:37:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:39:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:40:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:43:0x020a  */
    /* JADX WARN: Code duplicated, block: B:46:0x025e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x025f  */
    /* JADX WARN: Code duplicated, block: B:50:0x028c A[LOOP:0: B:16:0x00cd->B:50:0x028c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x00ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x025f -> B:48:0x0275). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:35:0x01c4
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object loadLinks$processLinks(kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r20, com.IStreamFlare.IStreamFlare r21, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r22, java.util.List<com.IStreamFlare.StreamLinks> r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            Method dump skipped, instruction units count: 678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.IStreamFlare.IStreamFlare.loadLinks$processLinks(kotlin.jvm.functions.Function1, com.IStreamFlare.IStreamFlare, kotlin.jvm.functions.Function1, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.IStreamFlare.IStreamFlare$loadLinks$2 */
    /* JADX INFO: compiled from: IStreamFlare.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare$loadLinks$2", f = "IStreamFlare.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00072 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $data;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00072(String str, Continuation<? super C00072> continuation) {
            super(2, continuation);
            this.$data = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00072 = new C00072(this.$data, continuation);
            c00072.L$0 = obj;
            return c00072;
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
                    $this$newExtractorLink.setReferer(this.$data);
                    $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(""));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.IStreamFlare.IStreamFlare$loadLinks$3 */
    /* JADX INFO: compiled from: IStreamFlare.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare$loadLinks$3", f = "IStreamFlare.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00083 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00083(Continuation<? super C00083> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00083 = new C00083(continuation);
            c00083.L$0 = obj;
            return c00083;
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
                    $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(""));
                    $this$newExtractorLink.setHeaders(IStreamFlare.INSTANCE.getHeaders());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object getDecodedJson(String url, Continuation<? super String> continuation) {
        C00001 c00001;
        boolean z;
        Object obj;
        Object objDecodeFromString;
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
        C00001 c00002 = c00001;
        Object $result = c00002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00002.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                Map<String, String> map = headers;
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00002.label = 1;
                z = true;
                Object obj2 = Requests.get$default(app, url, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4092, (Object) null);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result = obj2;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String response = ((NiceResponse) $result).getTextLarge();
        try {
            AppUtils appUtils = AppUtils.INSTANCE;
            try {
                Result.Companion companion = Result.Companion;
                KType kTypeTypeOf = Reflection.typeOf(JsonNode.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Object obj3 = null;
            if (Result.exceptionOrNull-impl(obj) != null) {
                try {
                    Result.Companion companion3 = Result.Companion;
                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, 2, (Object) null));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th2));
                }
            }
            if (!Result.isFailure-impl(obj)) {
                obj3 = obj;
            }
            DeserializationStrategy deserializationStrategy = (KSerializer) obj3;
            if (deserializationStrategy != null) {
                try {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, response);
                } catch (SerializationException e) {
                    ArchComponentExtKt.logError(e);
                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv.readValue(response, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$getDecodedJson$$inlined$parseJson$1
                    });
                } catch (Throwable th3) {
                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv2.readValue(response, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$getDecodedJson$$inlined$parseJson$1
                    });
                }
            } else {
                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv3.readValue(response, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$getDecodedJson$$inlined$parseJson$1
                });
            }
            JsonNode root = (JsonNode) objDecodeFromString;
            JsonNode jsonNode = root.get("encrypted");
            boolean z2 = false;
            if (jsonNode != null && jsonNode.asBoolean() == z) {
                z2 = true;
            }
            return (!z2 || root.get("data") == null) ? response : IStreamFlareParserKt.decryptPayload(root.get("data").asText());
        } catch (Exception e2) {
            return response;
        }
    }
}
