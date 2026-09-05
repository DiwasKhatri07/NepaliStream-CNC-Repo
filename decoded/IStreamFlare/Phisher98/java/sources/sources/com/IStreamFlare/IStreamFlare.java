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
import kotlin.jvm.internal.Ref;
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
@SourceDebugExtension({"SMAP\nIStreamFlare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IStreamFlare.kt\ncom/IStreamFlare/IStreamFlare\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,622:1\n63#2:623\n64#2,15:625\n63#2:642\n64#2,15:644\n63#2:665\n64#2,15:667\n63#2:684\n64#2,15:686\n93#2,2:707\n63#2:709\n64#2,15:711\n95#2,2:728\n63#2:730\n64#2,15:732\n63#2:749\n64#2,15:751\n63#2:768\n64#2,15:770\n63#2:788\n64#2,15:790\n63#2:807\n64#2,15:809\n63#2:827\n64#2,15:829\n63#2:850\n64#2,15:852\n63#2:869\n64#2,15:871\n63#2:888\n64#2,15:890\n63#2:907\n64#2,15:909\n63#2:926\n64#2,15:928\n1#3:624\n1#3:643\n1#3:666\n1#3:685\n1#3:710\n1#3:731\n1#3:750\n1#3:769\n1#3:787\n1#3:789\n1#3:808\n1#3:828\n1#3:849\n1#3:851\n1#3:870\n1#3:889\n1#3:908\n1#3:927\n1#3:946\n50#4:640\n43#4:641\n50#4:659\n43#4:660\n50#4:682\n43#4:683\n50#4:701\n43#4:702\n50#4:726\n43#4:727\n50#4:747\n43#4:748\n50#4:766\n43#4:767\n50#4:785\n43#4:786\n50#4:805\n43#4:806\n50#4:824\n43#4:825\n50#4:844\n43#4:845\n50#4:867\n43#4:868\n50#4:886\n43#4:887\n50#4:905\n43#4:906\n50#4:924\n43#4:925\n50#4:943\n43#4:944\n1739#5:661\n1814#5,3:662\n1739#5:703\n1814#5,3:704\n2068#5:826\n2068#5,2:846\n2069#5:848\n2068#5:945\n2069#5:947\n*S KotlinDebug\n*F\n+ 1 IStreamFlare.kt\ncom/IStreamFlare/IStreamFlare\n*L\n97#1:623\n97#1:625,15\n109#1:642\n109#1:644,15\n172#1:665\n172#1:667,15\n183#1:684\n183#1:686,15\n197#1:707,2\n197#1:709\n197#1:711,15\n197#1:728,2\n236#1:730\n236#1:732,15\n248#1:749\n248#1:751,15\n264#1:768\n264#1:770,15\n283#1:788\n283#1:790,15\n309#1:807\n309#1:809,15\n334#1:827\n334#1:829,15\n500#1:850\n500#1:852,15\n512#1:869\n512#1:871,15\n522#1:888\n522#1:890,15\n532#1:907\n532#1:909,15\n603#1:926\n603#1:928,15\n97#1:624\n109#1:643\n172#1:666\n183#1:685\n197#1:710\n236#1:731\n248#1:750\n264#1:769\n283#1:789\n309#1:808\n334#1:828\n500#1:851\n512#1:870\n522#1:889\n532#1:908\n603#1:927\n97#1:640\n97#1:641\n109#1:659\n109#1:660\n172#1:682\n172#1:683\n183#1:701\n183#1:702\n197#1:726\n197#1:727\n236#1:747\n236#1:748\n248#1:766\n248#1:767\n264#1:785\n264#1:786\n283#1:805\n283#1:806\n309#1:824\n309#1:825\n334#1:844\n334#1:845\n500#1:867\n500#1:868\n512#1:886\n512#1:887\n522#1:905\n522#1:906\n532#1:924\n532#1:925\n603#1:943\n603#1:944\n114#1:661\n114#1:662,3\n188#1:703\n188#1:704,3\n314#1:826\n339#1:846,2\n314#1:848\n436#1:945\n436#1:947\n*E\n"})
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
    private String mainUrl = "https://guten.hippitunes.pro";

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
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare", f = "IStreamFlare.kt", i = {0}, l = {595}, m = "getDecodedJson", n = {"url"}, nl = {598}, s = {"L$0"}, v = 2)
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
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare", f = "IStreamFlare.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8}, l = {514, 520, 524, 530, 534, 541, 558, 563, 573}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "jsonString", "links", "isCasting", "data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "decodedJson", "links", "isCasting", "data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "decodedJson", "links", "isCasting", "data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "extractor", "linkFound", "isCasting", "data", "subtitleCallback", "callback", "extractor", "linkFound", "isCasting", "data", "subtitleCallback", "callback", "type", "isCasting"}, nl = {515, 521, 525, 531, 535, 540, 562, 565, 572}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
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
        return MainAPIKt.newMovieSearchResponse$default(this, title, AppUtils.INSTANCE.toJson(loadData), TvType.Movie, false, new Function1() { // from class: com.IStreamFlare.IStreamFlare$$ExternalSyntheticLambda1
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

    /* JADX WARN: Code duplicated, block: B:119:0x0328 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:120:0x0329  */
    /* JADX WARN: Code duplicated, block: B:136:0x0392  */
    /* JADX WARN: Code duplicated, block: B:148:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:158:0x03ea A[Catch: Exception -> 0x0402, TryCatch #24 {Exception -> 0x0402, blocks: (B:146:0x03c8, B:149:0x03cf, B:159:0x03ff, B:158:0x03ea, B:157:0x03e4, B:145:0x03be, B:152:0x03d5), top: B:288:0x03be, inners: #26 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x0438 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:169:0x0439  */
    /* JADX WARN: Code duplicated, block: B:185:0x04a4  */
    /* JADX WARN: Code duplicated, block: B:197:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:207:0x04fc A[Catch: Exception -> 0x0514, TryCatch #17 {Exception -> 0x0514, blocks: (B:195:0x04da, B:198:0x04e1, B:208:0x0511, B:207:0x04fc, B:206:0x04f6, B:194:0x04d0, B:201:0x04e7), top: B:281:0x04d0, inners: #25 }] */
    /* JADX WARN: Code duplicated, block: B:217:0x054a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:218:0x054b  */
    /* JADX WARN: Code duplicated, block: B:235:0x05eb  */
    /* JADX WARN: Code duplicated, block: B:237:0x0615 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:238:0x0616  */
    /* JADX WARN: Code duplicated, block: B:269:0x0397 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:279:0x04a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:290:0x03d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:292:0x04e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:294:0x01cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:54:0x01e2 A[Catch: Exception -> 0x0246, TryCatch #22 {Exception -> 0x0246, blocks: (B:29:0x0169, B:35:0x0192, B:42:0x01c0, B:45:0x01c7, B:55:0x01fa, B:58:0x0204, B:60:0x020a, B:65:0x0218, B:67:0x021e, B:68:0x022b, B:70:0x0231, B:72:0x023b, B:54:0x01e2, B:53:0x01dc, B:41:0x01b5, B:34:0x0188, B:38:0x0199, B:31:0x0170, B:48:0x01cd), top: B:285:0x0169, inners: #8, #13, #24 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0204 A[Catch: Exception -> 0x0246, TRY_ENTER, TryCatch #22 {Exception -> 0x0246, blocks: (B:29:0x0169, B:35:0x0192, B:42:0x01c0, B:45:0x01c7, B:55:0x01fa, B:58:0x0204, B:60:0x020a, B:65:0x0218, B:67:0x021e, B:68:0x022b, B:70:0x0231, B:72:0x023b, B:54:0x01e2, B:53:0x01dc, B:41:0x01b5, B:34:0x0188, B:38:0x0199, B:31:0x0170, B:48:0x01cd), top: B:285:0x0169, inners: #8, #13, #24 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0214  */
    /* JADX WARN: Code duplicated, block: B:68:0x022b A[Catch: Exception -> 0x0246, TryCatch #22 {Exception -> 0x0246, blocks: (B:29:0x0169, B:35:0x0192, B:42:0x01c0, B:45:0x01c7, B:55:0x01fa, B:58:0x0204, B:60:0x020a, B:65:0x0218, B:67:0x021e, B:68:0x022b, B:70:0x0231, B:72:0x023b, B:54:0x01e2, B:53:0x01dc, B:41:0x01b5, B:34:0x0188, B:38:0x0199, B:31:0x0170, B:48:0x01cd), top: B:285:0x0169, inners: #8, #13, #24 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0231 A[Catch: Exception -> 0x0246, TryCatch #22 {Exception -> 0x0246, blocks: (B:29:0x0169, B:35:0x0192, B:42:0x01c0, B:45:0x01c7, B:55:0x01fa, B:58:0x0204, B:60:0x020a, B:65:0x0218, B:67:0x021e, B:68:0x022b, B:70:0x0231, B:72:0x023b, B:54:0x01e2, B:53:0x01dc, B:41:0x01b5, B:34:0x0188, B:38:0x0199, B:31:0x0170, B:48:0x01cd), top: B:285:0x0169, inners: #8, #13, #24 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0244  */
    /* JADX WARN: Code duplicated, block: B:7:0x0022  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00061 c00061;
        Object obj;
        String strAsText;
        String jsonString;
        List listEmptyList;
        List links;
        Object obj2;
        Object objDecodeFromString;
        Object obj3;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString2;
        JsonNode root;
        JsonNode jsonNode;
        boolean z;
        boolean z2;
        Object obj4;
        Function1<? super ExtractorLink, Unit> function3;
        String data2;
        Function1<? super SubtitleFile, Unit> function4;
        Istreamcdn extractor;
        Ref.BooleanRef linkFound;
        boolean isCasting2;
        Object obj5;
        Function1<? super SubtitleFile, Unit> function5;
        Function1<? super ExtractorLink, Unit> function6;
        Object decodedJson;
        Object decodedJson2;
        String decodedJson3;
        String decodedJson4;
        String data3;
        List listEmptyList2;
        List links2;
        Object obj6;
        DeserializationStrategy deserializationStrategy2;
        Object objDecodeFromString3;
        String decodedJson5;
        String decodedJson6;
        String data4;
        List listEmptyList3;
        List links3;
        Object obj7;
        DeserializationStrategy deserializationStrategy3;
        Object objDecodeFromString4;
        String data5;
        Istreamcdn extractor2;
        Function1<? super ExtractorLink, Unit> function7;
        String data6 = data;
        boolean isCasting3 = isCasting;
        Function1<? super SubtitleFile, Unit> function8 = function1;
        final Function1<? super ExtractorLink, Unit> function9 = function2;
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
        switch (c00062.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String it = StringsKt.trim(data6).toString();
                obj = "kotlinx.serialization.serializer.simple";
                if (StringsKt.startsWith$default(it, "{", false, 2, (Object) null) || StringsKt.startsWith$default(it, "[", false, 2, (Object) null)) {
                    try {
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(JsonNode.class);
                            MagicApiIntrinsics.voidMagicApiCall(obj);
                            obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj3) == null) {
                            if (Result.isFailure-impl(obj3)) {
                                obj3 = null;
                            }
                            deserializationStrategy = (KSerializer) obj3;
                            if (deserializationStrategy != null) {
                                try {
                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                                } catch (SerializationException e) {
                                    ArchComponentExtKt.logError(e);
                                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                    objDecodeFromString2 = $this$readValue$iv$iv.readValue(data, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$1
                                    });
                                } catch (Throwable th2) {
                                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                    objDecodeFromString2 = $this$readValue$iv$iv2.readValue(data, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$1
                                    });
                                }
                            } else {
                                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv3.readValue(data, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$1
                                });
                            }
                            root = (JsonNode) objDecodeFromString2;
                            if (!root.has("encrypted")) {
                                jsonNode = root.get("encrypted");
                                if (jsonNode == null && jsonNode.asBoolean()) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z && root.has("data")) {
                                    strAsText = IStreamFlareParserKt.decryptPayload(root.get("data").asText());
                                } else if (root.has("data")) {
                                    strAsText = data6;
                                } else {
                                    strAsText = data6;
                                }
                            } else if (root.has("data") || !root.get("data").isTextual()) {
                                strAsText = data6;
                            } else {
                                strAsText = root.get("data").asText();
                            }
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, 2, (Object) null));
                            } catch (Throwable th3) {
                                Result.Companion companion4 = Result.Companion;
                                obj3 = Result.constructor-impl(ResultKt.createFailure(th3));
                            }
                            if (Result.isFailure-impl(obj3)) {
                                obj3 = null;
                            }
                            deserializationStrategy = (KSerializer) obj3;
                            if (deserializationStrategy != null) {
                                objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                            } else {
                                ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv4.readValue(data, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$1
                                });
                            }
                            root = (JsonNode) objDecodeFromString2;
                            if (!root.has("encrypted")) {
                                jsonNode = root.get("encrypted");
                                if (jsonNode == null) {
                                    z = false;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    if (root.has("data")) {
                                        strAsText = data6;
                                    } else {
                                        strAsText = data6;
                                    }
                                } else if (root.has("data")) {
                                    strAsText = data6;
                                } else {
                                    strAsText = data6;
                                }
                            } else if (root.has("data")) {
                                strAsText = data6;
                            } else {
                                strAsText = data6;
                            }
                        }
                    } catch (Exception e2) {
                        strAsText = data6;
                    }
                    String jsonString2 = strAsText;
                    try {
                        AppUtils appUtils2 = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion5 = Result.Companion;
                            KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamLinks.class)));
                            MagicApiIntrinsics.voidMagicApiCall(obj);
                            obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                        } catch (Throwable th4) {
                            Result.Companion companion6 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th4));
                        }
                        if (Result.exceptionOrNull-impl(obj2) == null) {
                            jsonString = jsonString2;
                        } else {
                            try {
                                Result.Companion companion7 = Result.Companion;
                                jsonString = jsonString2;
                                try {
                                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                    break;
                                } catch (Throwable th5) {
                                    th = th5;
                                    try {
                                        Result.Companion companion8 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                    } catch (Exception e3) {
                                        listEmptyList = CollectionsKt.emptyList();
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                jsonString = jsonString2;
                            }
                        }
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = null;
                        }
                        DeserializationStrategy deserializationStrategy4 = (KSerializer) obj2;
                        if (deserializationStrategy4 != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy4, jsonString2);
                            } catch (SerializationException e4) {
                                ArchComponentExtKt.logError(e4);
                                ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv5.readValue(jsonString2, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$2
                                });
                            } catch (Throwable th7) {
                                ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv6.readValue(jsonString2, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$2
                                });
                            }
                            listEmptyList = (List) objDecodeFromString;
                            links = listEmptyList;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(jsonString);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(links);
                            c00062.Z$0 = isCasting3;
                            c00062.label = 1;
                            if (loadLinks$processLinks(function9, this, function8, links, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z2 = true;
                        } else {
                            ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv7.readValue(jsonString2, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$2
                            });
                            listEmptyList = (List) objDecodeFromString;
                            links = listEmptyList;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(jsonString);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(links);
                            c00062.Z$0 = isCasting3;
                            c00062.label = 1;
                            if (loadLinks$processLinks(function9, this, function8, links, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z2 = true;
                        }
                    } catch (Exception e5) {
                        jsonString = jsonString2;
                    }
                    break;
                } else if (StringsKt.contains(data6, "getMoviePlayLinks", true)) {
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                    c00062.L$1 = function8;
                    c00062.L$2 = function9;
                    c00062.Z$0 = isCasting3;
                    c00062.label = 2;
                    decodedJson2 = getDecodedJson(data6, c00062);
                    if (decodedJson2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    decodedJson3 = (String) decodedJson2;
                    try {
                        AppUtils appUtils3 = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion9 = Result.Companion;
                            KType kTypeTypeOf3 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamLinks.class)));
                            MagicApiIntrinsics.voidMagicApiCall(obj);
                            obj6 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                        } catch (Throwable th8) {
                            Result.Companion companion10 = Result.Companion;
                            obj6 = Result.constructor-impl(ResultKt.createFailure(th8));
                        }
                        if (Result.exceptionOrNull-impl(obj6) != null) {
                            decodedJson4 = decodedJson3;
                            data3 = data6;
                        } else {
                            try {
                                Result.Companion companion11 = Result.Companion;
                                decodedJson4 = decodedJson3;
                                data3 = data6;
                                try {
                                    obj6 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                    break;
                                } catch (Throwable th9) {
                                    th = th9;
                                    try {
                                        Result.Companion companion12 = Result.Companion;
                                        obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                                    } catch (Exception e6) {
                                        listEmptyList2 = CollectionsKt.emptyList();
                                    }
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                decodedJson4 = decodedJson3;
                                data3 = data6;
                            }
                        }
                        if (Result.isFailure-impl(obj6)) {
                            obj6 = null;
                        }
                        deserializationStrategy2 = (KSerializer) obj6;
                        if (deserializationStrategy2 != null) {
                            try {
                                objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, decodedJson3);
                            } catch (SerializationException e7) {
                                ArchComponentExtKt.logError(e7);
                                ObjectMapper $this$readValue$iv$iv8 = MainAPIKt.getMapper();
                                objDecodeFromString3 = $this$readValue$iv$iv8.readValue(decodedJson3, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$3
                                });
                            } catch (Throwable th11) {
                                ObjectMapper $this$readValue$iv$iv9 = MainAPIKt.getMapper();
                                objDecodeFromString3 = $this$readValue$iv$iv9.readValue(decodedJson3, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$3
                                });
                            }
                            listEmptyList2 = (List) objDecodeFromString3;
                            links2 = listEmptyList2;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson4);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(links2);
                            c00062.Z$0 = isCasting3;
                            c00062.label = 3;
                            if (loadLinks$processLinks(function9, this, function8, links2, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z2 = true;
                        } else {
                            ObjectMapper $this$readValue$iv$iv10 = MainAPIKt.getMapper();
                            objDecodeFromString3 = $this$readValue$iv$iv10.readValue(decodedJson3, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$3
                            });
                            listEmptyList2 = (List) objDecodeFromString3;
                            links2 = listEmptyList2;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson4);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(links2);
                            c00062.Z$0 = isCasting3;
                            c00062.label = 3;
                            if (loadLinks$processLinks(function9, this, function8, links2, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z2 = true;
                        }
                    } catch (Exception e8) {
                        decodedJson4 = decodedJson3;
                        data3 = data6;
                        listEmptyList2 = CollectionsKt.emptyList();
                        links2 = listEmptyList2;
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function8);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson4);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(links2);
                        c00062.Z$0 = isCasting3;
                        c00062.label = 3;
                        if (loadLinks$processLinks(function9, this, function8, links2, c00062) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z2 = true;
                        return Boxing.boxBoolean(z2);
                    }
                    break;
                } else if (StringsKt.contains(data6, "getEpisodePlayLinks", true)) {
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                    c00062.L$1 = function8;
                    c00062.L$2 = function9;
                    c00062.Z$0 = isCasting3;
                    c00062.label = 4;
                    decodedJson = getDecodedJson(data6, c00062);
                    if (decodedJson == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    decodedJson5 = (String) decodedJson;
                    try {
                        AppUtils appUtils4 = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion13 = Result.Companion;
                            KType kTypeTypeOf4 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamLinks.class)));
                            MagicApiIntrinsics.voidMagicApiCall(obj);
                            obj7 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                        } catch (Throwable th12) {
                            Result.Companion companion14 = Result.Companion;
                            obj7 = Result.constructor-impl(ResultKt.createFailure(th12));
                        }
                        if (Result.exceptionOrNull-impl(obj7) != null) {
                            decodedJson6 = decodedJson5;
                            data4 = data6;
                        } else {
                            try {
                                Result.Companion companion15 = Result.Companion;
                                decodedJson6 = decodedJson5;
                                data4 = data6;
                                try {
                                    obj7 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                    break;
                                } catch (Throwable th13) {
                                    th = th13;
                                    try {
                                        Result.Companion companion16 = Result.Companion;
                                        obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                    } catch (Exception e9) {
                                        listEmptyList3 = CollectionsKt.emptyList();
                                    }
                                }
                            } catch (Throwable th14) {
                                th = th14;
                                decodedJson6 = decodedJson5;
                                data4 = data6;
                            }
                        }
                        if (Result.isFailure-impl(obj7)) {
                            obj7 = null;
                        }
                        deserializationStrategy3 = (KSerializer) obj7;
                        if (deserializationStrategy3 != null) {
                            try {
                                objDecodeFromString4 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, decodedJson5);
                            } catch (SerializationException e10) {
                                ArchComponentExtKt.logError(e10);
                                ObjectMapper $this$readValue$iv$iv11 = MainAPIKt.getMapper();
                                objDecodeFromString4 = $this$readValue$iv$iv11.readValue(decodedJson5, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$4
                                });
                            } catch (Throwable th15) {
                                ObjectMapper $this$readValue$iv$iv12 = MainAPIKt.getMapper();
                                objDecodeFromString4 = $this$readValue$iv$iv12.readValue(decodedJson5, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$4
                                });
                            }
                            listEmptyList3 = (List) objDecodeFromString4;
                            links3 = listEmptyList3;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson6);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(links3);
                            c00062.Z$0 = isCasting3;
                            c00062.label = 5;
                            if (loadLinks$processLinks(function9, this, function8, links3, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z2 = true;
                        } else {
                            ObjectMapper $this$readValue$iv$iv13 = MainAPIKt.getMapper();
                            objDecodeFromString4 = $this$readValue$iv$iv13.readValue(decodedJson5, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$4
                            });
                            listEmptyList3 = (List) objDecodeFromString4;
                            links3 = listEmptyList3;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson6);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(links3);
                            c00062.Z$0 = isCasting3;
                            c00062.label = 5;
                            if (loadLinks$processLinks(function9, this, function8, links3, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z2 = true;
                        }
                    } catch (Exception e11) {
                        decodedJson6 = decodedJson5;
                        data4 = data6;
                    }
                    break;
                } else if (StringsKt.contains(data6, "x7flix", true)) {
                    String name = getName();
                    String name2 = getName();
                    ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                    C00073 c00073 = new C00073(data6, null);
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function8);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                    c00062.L$3 = function9;
                    c00062.Z$0 = isCasting3;
                    c00062.label = 6;
                    Object objNewExtractorLink = ExtractorApiKt.newExtractorLink(name2, name, data6, extractorLinkType, c00073, c00062);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj5 = objNewExtractorLink;
                    function5 = function8;
                    function6 = function9;
                    function9.invoke(obj5);
                    z2 = true;
                } else if (StringsKt.contains(data6, ".php?id=", true)) {
                    Istreamcdn extractor3 = new Istreamcdn();
                    final Ref.BooleanRef linkFound2 = new Ref.BooleanRef();
                    Function1<? super ExtractorLink, Unit> function10 = new Function1() { // from class: com.IStreamFlare.IStreamFlare$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj8) {
                            return IStreamFlare.loadLinks$lambda$2(linkFound2, function9, (ExtractorLink) obj8);
                        }
                    };
                    c00062.L$0 = data6;
                    c00062.L$1 = function8;
                    c00062.L$2 = function9;
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(extractor3);
                    c00062.L$4 = linkFound2;
                    c00062.Z$0 = isCasting3;
                    c00062.label = 7;
                    data2 = data;
                    if (extractor3.getUrl(data2, null, function8, function10, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function4 = function1;
                    extractor = extractor3;
                    linkFound = linkFound2;
                    isCasting2 = isCasting3;
                    if (!linkFound.element) {
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(extractor);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(linkFound);
                        c00062.Z$0 = isCasting2;
                        c00062.label = 8;
                        if (ExtractorApiKt.loadExtractor(data2, function4, function9, c00062) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Istreamcdn istreamcdn = extractor;
                        data5 = data2;
                        extractor2 = istreamcdn;
                        function7 = function9;
                        data2 = data5;
                    }
                    z2 = true;
                } else if (StringsKt.startsWith$default(data6, "http", false, 2, (Object) null)) {
                    ExtractorLinkType type = StringsKt.contains(data6, ".m3u8", true) ? ExtractorLinkType.M3U8 : ExtractorApiKt.getINFER_TYPE();
                    String name3 = getName();
                    String name4 = getName();
                    C00085 c00085 = new C00085(null);
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(type);
                    c00062.L$4 = function9;
                    c00062.Z$0 = isCasting3;
                    c00062.label = 9;
                    Object objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name4, name3, data, type, c00085, c00062);
                    if (objNewExtractorLink2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj4 = objNewExtractorLink2;
                    function3 = function9;
                    function9.invoke(obj4);
                    z2 = true;
                } else {
                    z2 = false;
                }
                return Boxing.boxBoolean(z2);
            case 1:
                boolean isCasting4 = c00062.Z$0;
                ResultKt.throwOnFailure($result);
                z2 = true;
                return Boxing.boxBoolean(z2);
            case 2:
                boolean isCasting5 = c00062.Z$0;
                Function1<? super ExtractorLink, Unit> function11 = (Function1) c00062.L$2;
                Function1<? super SubtitleFile, Unit> function12 = (Function1) c00062.L$1;
                data6 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                function9 = function11;
                obj = "kotlinx.serialization.serializer.simple";
                function8 = function12;
                isCasting3 = isCasting5;
                decodedJson2 = $result;
                decodedJson3 = (String) decodedJson2;
                AppUtils appUtils5 = AppUtils.INSTANCE;
                Result.Companion companion17 = Result.Companion;
                KType kTypeTypeOf5 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamLinks.class)));
                MagicApiIntrinsics.voidMagicApiCall(obj);
                obj6 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                if (Result.exceptionOrNull-impl(obj6) != null) {
                    Result.Companion companion18 = Result.Companion;
                    decodedJson4 = decodedJson3;
                    data3 = data6;
                    obj6 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                    break;
                } else {
                    decodedJson4 = decodedJson3;
                    data3 = data6;
                }
                if (Result.isFailure-impl(obj6)) {
                    obj6 = null;
                }
                deserializationStrategy2 = (KSerializer) obj6;
                if (deserializationStrategy2 != null) {
                    objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, decodedJson3);
                    listEmptyList2 = (List) objDecodeFromString3;
                    links2 = listEmptyList2;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function8);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson4);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(links2);
                    c00062.Z$0 = isCasting3;
                    c00062.label = 3;
                    if (loadLinks$processLinks(function9, this, function8, links2, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z2 = true;
                } else {
                    ObjectMapper $this$readValue$iv$iv14 = MainAPIKt.getMapper();
                    objDecodeFromString3 = $this$readValue$iv$iv14.readValue(decodedJson3, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$3
                    });
                    listEmptyList2 = (List) objDecodeFromString3;
                    links2 = listEmptyList2;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function8);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson4);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(links2);
                    c00062.Z$0 = isCasting3;
                    c00062.label = 3;
                    if (loadLinks$processLinks(function9, this, function8, links2, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z2 = true;
                }
                return Boxing.boxBoolean(z2);
            case 3:
                boolean isCasting6 = c00062.Z$0;
                ResultKt.throwOnFailure($result);
                z2 = true;
                return Boxing.boxBoolean(z2);
            case 4:
                boolean isCasting7 = c00062.Z$0;
                Function1<? super ExtractorLink, Unit> function13 = (Function1) c00062.L$2;
                Function1<? super SubtitleFile, Unit> function14 = (Function1) c00062.L$1;
                data6 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                function9 = function13;
                obj = "kotlinx.serialization.serializer.simple";
                function8 = function14;
                isCasting3 = isCasting7;
                decodedJson = $result;
                decodedJson5 = (String) decodedJson;
                AppUtils appUtils6 = AppUtils.INSTANCE;
                Result.Companion companion19 = Result.Companion;
                KType kTypeTypeOf6 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamLinks.class)));
                MagicApiIntrinsics.voidMagicApiCall(obj);
                obj7 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                if (Result.exceptionOrNull-impl(obj7) != null) {
                    Result.Companion companion110 = Result.Companion;
                    decodedJson6 = decodedJson5;
                    data4 = data6;
                    obj7 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                    break;
                } else {
                    decodedJson6 = decodedJson5;
                    data4 = data6;
                }
                if (Result.isFailure-impl(obj7)) {
                    obj7 = null;
                }
                deserializationStrategy3 = (KSerializer) obj7;
                if (deserializationStrategy3 != null) {
                    objDecodeFromString4 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, decodedJson5);
                    listEmptyList3 = (List) objDecodeFromString4;
                    links3 = listEmptyList3;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function8);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson6);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(links3);
                    c00062.Z$0 = isCasting3;
                    c00062.label = 5;
                    if (loadLinks$processLinks(function9, this, function8, links3, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z2 = true;
                } else {
                    ObjectMapper $this$readValue$iv$iv15 = MainAPIKt.getMapper();
                    objDecodeFromString4 = $this$readValue$iv$iv15.readValue(decodedJson5, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$4
                    });
                    listEmptyList3 = (List) objDecodeFromString4;
                    links3 = listEmptyList3;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function8);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson6);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(links3);
                    c00062.Z$0 = isCasting3;
                    c00062.label = 5;
                    if (loadLinks$processLinks(function9, this, function8, links3, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z2 = true;
                }
                return Boxing.boxBoolean(z2);
            case 5:
                boolean isCasting8 = c00062.Z$0;
                ResultKt.throwOnFailure($result);
                z2 = true;
                return Boxing.boxBoolean(z2);
            case 6:
                boolean isCasting9 = c00062.Z$0;
                Function1<? super ExtractorLink, Unit> function15 = (Function1) c00062.L$3;
                function6 = (Function1) c00062.L$2;
                function5 = (Function1) c00062.L$1;
                ResultKt.throwOnFailure($result);
                function9 = function15;
                obj5 = $result;
                function9.invoke(obj5);
                z2 = true;
                return Boxing.boxBoolean(z2);
            case 7:
                isCasting2 = c00062.Z$0;
                linkFound = (Ref.BooleanRef) c00062.L$4;
                Istreamcdn extractor4 = (Istreamcdn) c00062.L$3;
                Function1<? super ExtractorLink, Unit> function16 = (Function1) c00062.L$2;
                function4 = (Function1) c00062.L$1;
                String data7 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                extractor = extractor4;
                data2 = data7;
                function9 = function16;
                if (!linkFound.element) {
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(extractor);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(linkFound);
                    c00062.Z$0 = isCasting2;
                    c00062.label = 8;
                    if (ExtractorApiKt.loadExtractor(data2, function4, function9, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Istreamcdn istreamcdn2 = extractor;
                    data5 = data2;
                    extractor2 = istreamcdn2;
                    function7 = function9;
                    data2 = data5;
                }
                z2 = true;
                return Boxing.boxBoolean(z2);
            case 8:
                boolean isCasting10 = c00062.Z$0;
                extractor2 = (Istreamcdn) c00062.L$3;
                function7 = (Function1) c00062.L$2;
                data5 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                data2 = data5;
                z2 = true;
                return Boxing.boxBoolean(z2);
            case 9:
                boolean z3 = c00062.Z$0;
                Function1<? super ExtractorLink, Unit> function17 = (Function1) c00062.L$4;
                function3 = (Function1) c00062.L$2;
                ResultKt.throwOnFailure($result);
                function9 = function17;
                obj4 = $result;
                function9.invoke(obj4);
                z2 = true;
                return Boxing.boxBoolean(z2);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x0106  */
    /* JADX WARN: Code duplicated, block: B:23:0x0130  */
    /* JADX WARN: Code duplicated, block: B:25:0x013c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0188 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x0189  */
    /* JADX WARN: Code duplicated, block: B:31:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:33:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:35:0x0207 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0208  */
    /* JADX WARN: Code duplicated, block: B:39:0x0225  */
    /* JADX WARN: Code duplicated, block: B:41:0x0268 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x0269  */
    /* JADX WARN: Code duplicated, block: B:44:0x027f  */
    /* JADX WARN: Code duplicated, block: B:45:0x0295  */
    /* JADX WARN: Code duplicated, block: B:47:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:48:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:51:0x02be  */
    /* JADX WARN: Code duplicated, block: B:54:0x0311 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x0312  */
    /* JADX WARN: Code duplicated, block: B:58:0x033b A[LOOP:0: B:17:0x0100->B:58:0x033b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:65:0x011d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x027f -> B:57:0x0334). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0312 -> B:56:0x0325). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:39:0x0225
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object loadLinks$processLinks(kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r21, com.IStreamFlare.IStreamFlare r22, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r23, java.util.List<com.IStreamFlare.StreamLinks> r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            Method dump skipped, instruction units count: 852
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.IStreamFlare.IStreamFlare.loadLinks$processLinks(kotlin.jvm.functions.Function1, com.IStreamFlare.IStreamFlare, kotlin.jvm.functions.Function1, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadLinks$processLinks$lambda$0$1(Ref.BooleanRef $linkFound, Function1 $callback, ExtractorLink extractorLink) {
        $linkFound.element = true;
        $callback.invoke(extractorLink);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.IStreamFlare.IStreamFlare$loadLinks$3 */
    /* JADX INFO: compiled from: IStreamFlare.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare$loadLinks$3", f = "IStreamFlare.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00073 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $data;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00073(String str, Continuation<? super C00073> continuation) {
            super(2, continuation);
            this.$data = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00073 = new C00073(this.$data, continuation);
            c00073.L$0 = obj;
            return c00073;
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

    static final Unit loadLinks$lambda$2(Ref.BooleanRef $linkFound, Function1 $callback, ExtractorLink it) {
        $linkFound.element = true;
        $callback.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.IStreamFlare.IStreamFlare$loadLinks$5 */
    /* JADX INFO: compiled from: IStreamFlare.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare$loadLinks$5", f = "IStreamFlare.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00085 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00085(Continuation<? super C00085> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00085 = new C00085(continuation);
            c00085.L$0 = obj;
            return c00085;
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
