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
import com.phisher98.donation.DonationManager;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
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
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010!J\u001e\u0010%\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0096@¢\u0006\u0002\u0010,J\f\u0010-\u001a\u00020.*\u00020/H\u0002J\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020.0#2\u0006\u00101\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00102J\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020.0#2\u0006\u00101\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00102J\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00102JF\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u000f2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u001f0;2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\u001f0;H\u0096@¢\u0006\u0002\u0010?J\u0016\u0010@\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u00102R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006B"}, d2 = {"Lcom/IStreamFlare/IStreamFlare;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "value", "", "mainUrl", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "syncConfig", "", "force", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/IStreamFlare/HomeRes;", "quickSearch", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDecodedJson", "Companion", "IStreamFlare"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIStreamFlare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IStreamFlare.kt\ncom/IStreamFlare/IStreamFlare\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,667:1\n63#2:668\n64#2,15:670\n63#2:687\n64#2,15:689\n63#2:710\n64#2,15:712\n63#2:729\n64#2,15:731\n93#2,2:752\n63#2:754\n64#2,15:756\n95#2,2:773\n63#2:775\n64#2,15:777\n63#2:794\n64#2,15:796\n63#2:813\n64#2,15:815\n63#2:833\n64#2,15:835\n63#2:852\n64#2,15:854\n63#2:872\n64#2,15:874\n63#2:895\n64#2,15:897\n63#2:914\n64#2,15:916\n63#2:933\n64#2,15:935\n63#2:952\n64#2,15:954\n63#2:971\n64#2,15:973\n1#3:669\n1#3:688\n1#3:711\n1#3:730\n1#3:755\n1#3:776\n1#3:795\n1#3:814\n1#3:832\n1#3:834\n1#3:853\n1#3:873\n1#3:894\n1#3:896\n1#3:915\n1#3:934\n1#3:953\n1#3:972\n1#3:991\n50#4:685\n43#4:686\n50#4:704\n43#4:705\n50#4:727\n43#4:728\n50#4:746\n43#4:747\n50#4:771\n43#4:772\n50#4:792\n43#4:793\n50#4:811\n43#4:812\n50#4:830\n43#4:831\n50#4:850\n43#4:851\n50#4:869\n43#4:870\n50#4:889\n43#4:890\n50#4:912\n43#4:913\n50#4:931\n43#4:932\n50#4:950\n43#4:951\n50#4:969\n43#4:970\n50#4:988\n43#4:989\n1739#5:706\n1814#5,3:707\n1739#5:748\n1814#5,3:749\n2068#5:871\n2068#5,2:891\n2069#5:893\n2068#5:990\n2069#5:992\n*S KotlinDebug\n*F\n+ 1 IStreamFlare.kt\ncom/IStreamFlare/IStreamFlare\n*L\n114#1:668\n114#1:670,15\n126#1:687\n126#1:689,15\n202#1:710\n202#1:712,15\n213#1:729\n213#1:731,15\n228#1:752,2\n228#1:754\n228#1:756,15\n228#1:773,2\n267#1:775\n267#1:777,15\n279#1:794\n279#1:796,15\n295#1:813\n295#1:815,15\n314#1:833\n314#1:835,15\n340#1:852\n340#1:854,15\n365#1:872\n365#1:874,15\n532#1:895\n532#1:897,15\n544#1:914\n544#1:916,15\n554#1:933\n554#1:935,15\n564#1:952\n564#1:954,15\n648#1:971\n648#1:973,15\n114#1:669\n126#1:688\n202#1:711\n213#1:730\n228#1:755\n267#1:776\n279#1:795\n295#1:814\n314#1:834\n340#1:853\n365#1:873\n532#1:896\n544#1:915\n554#1:934\n564#1:953\n648#1:972\n114#1:685\n114#1:686\n126#1:704\n126#1:705\n202#1:727\n202#1:728\n213#1:746\n213#1:747\n228#1:771\n228#1:772\n267#1:792\n267#1:793\n279#1:811\n279#1:812\n295#1:830\n295#1:831\n314#1:850\n314#1:851\n340#1:869\n340#1:870\n365#1:889\n365#1:890\n532#1:912\n532#1:913\n544#1:931\n544#1:932\n554#1:950\n554#1:951\n564#1:969\n564#1:970\n648#1:988\n648#1:989\n131#1:706\n131#1:707,3\n218#1:748\n218#1:749,3\n345#1:871\n370#1:891,2\n345#1:893\n468#1:990\n468#1:992\n*E\n"})
public final class IStreamFlare extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String cinemeta_url = "https://v3-cinemeta.strem.io/meta";

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
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare", f = "IStreamFlare.kt", i = {0, 1, 1, 2, 2, 2}, l = {628, 633, 639}, m = "getDecodedJson", n = {"url", "url", "<unused var>", "url", "<unused var>", "retryUrl"}, nl = {631, 634, 642}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
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
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare", f = "IStreamFlare.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}, l = {80, 97, 102, 104}, m = "getMainPage", n = {"request", "page", "request", "page", "isLiveTv", "request", "<unused var>", "page", "isLiveTv", "request", "<unused var>", "page", "isLiveTv"}, nl = {82, 100, 103, 107}, s = {"L$0", "I$0", "L$0", "I$0", "Z$0", "L$0", "L$1", "I$0", "Z$0", "L$0", "L$1", "I$0", "Z$0"}, v = 2)
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
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare", f = "IStreamFlare.kt", i = {0, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}, l = {226, 238, 262, 291, 310, 335, 359, 421, 442}, m = "load", n = {"url", "url", "res", "url", "res", "type", "endpoint", "isMovie", "url", "res", "type", "endpoint", "rawJson", "parsedElement", "dataElement", "resJson", "$this$load_u24lambda_u240", "isMovie", "url", "res", "type", "endpoint", "rawJson", "parsedElement", "dataElement", "resJson", "imdbId", "it", "$this$load_u24lambda_u242_u240", "isMovie", "url", "res", "type", "endpoint", "rawJson", "parsedElement", "dataElement", "resJson", "imdbId", "responseData", "meta", "poster", "description", "cast", "year", "episodesList", "isMovie", "url", "res", "type", "endpoint", "rawJson", "parsedElement", "dataElement", "resJson", "imdbId", "responseData", "meta", "poster", "description", "cast", "year", "episodesList", "seasonsRaw", "seasons", "$this$forEach$iv", "element$iv", "season", "isMovie", "seasonNumber", "url", "res", "type", "endpoint", "rawJson", "parsedElement", "dataElement", "resJson", "imdbId", "responseData", "meta", "poster", "description", "cast", "year", "episodesList", "seasonsRaw", "seasons", "isMovie", "url", "res", "type", "endpoint", "rawJson", "parsedElement", "dataElement", "resJson", "imdbId", "responseData", "meta", "poster", "description", "cast", "year", "href", "isMovie"}, nl = {228, 248, 266, 293, 312, 339, 358, 440, -1}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$20", "L$21", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "I$0"}, v = 2)
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
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare", f = "IStreamFlare.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9}, l = {465, 546, 552, 556, 562, 566, 573, 590, 595, 605}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "jsonString", "links", "isCasting", "data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "decodedJson", "links", "isCasting", "data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "decodedJson", "links", "isCasting", "data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "extractor", "linkFound", "isCasting", "data", "subtitleCallback", "callback", "extractor", "linkFound", "isCasting", "data", "subtitleCallback", "callback", "type", "isCasting"}, nl = {527, 547, 553, 557, 563, 567, 572, 594, 597, 604}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
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
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlare", f = "IStreamFlare.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4}, l = {180, 186, 191, 193, 207}, m = "search", n = {"query", "query", "url", "query", "url", "<unused var>", "query", "url", "<unused var>", "query", "url", "raw", "outer"}, nl = {183, 189, 192, 196, 209}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 2)
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
        return IStreamFlareConfig.INSTANCE.getServerUrl();
    }

    public void setMainUrl(@NotNull String value) {
        IStreamFlareConfig.INSTANCE.setServerUrl(value);
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/IStreamFlare/IStreamFlare$Companion;", "", "<init>", "()V", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "cinemeta_url", "IStreamFlare"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Map<String, String> getHeaders() {
            return IStreamFlareConfig.INSTANCE.getHeaders();
        }
    }

    static /* synthetic */ Object syncConfig$default(IStreamFlare iStreamFlare, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return iStreamFlare.syncConfig(z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object syncConfig(boolean force, Continuation<? super Unit> continuation) {
        return IStreamFlareConfig.INSTANCE.ensureConfig(force, continuation);
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:114:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:123:0x0316 A[Catch: Exception -> 0x032e, TryCatch #5 {Exception -> 0x032e, blocks: (B:112:0x02f4, B:115:0x02fb, B:124:0x032b, B:123:0x0316, B:122:0x0310, B:111:0x02e9, B:117:0x0301), top: B:158:0x02e9, inners: #16, #20 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x0356 A[LOOP:0: B:132:0x0350->B:134:0x0356, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:162:0x02c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x0213 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x0248 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x0301 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x011f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x0120  */
    /* JADX WARN: Code duplicated, block: B:50:0x0178 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x0179  */
    /* JADX WARN: Code duplicated, block: B:57:0x01d2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:77:0x0241  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:86:0x025d A[Catch: Exception -> 0x0389, TryCatch #8 {Exception -> 0x0389, blocks: (B:62:0x01e5, B:68:0x020b, B:75:0x023b, B:78:0x0242, B:87:0x0272, B:86:0x025d, B:85:0x0257, B:74:0x0230, B:67:0x0201, B:64:0x01ea, B:80:0x0248, B:71:0x0213), top: B:164:0x01e5, inners: #3, #10, #14, #21 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x027b  */
    /* JADX WARN: Code duplicated, block: B:91:0x0284  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        C00011 c00011;
        int page2;
        MainPageRequest request2;
        boolean isLiveTv;
        Object obj;
        Object obj2;
        boolean z;
        int page3;
        MainPageRequest request3;
        boolean isLiveTv2;
        int page4;
        MainPageRequest request4;
        Exception exc;
        boolean isLiveTv3;
        int page5;
        MainPageRequest request5;
        String textLarge;
        MainPageRequest request6;
        boolean isLiveTv4;
        int page6;
        int page7;
        boolean isLiveTv5;
        String responseText;
        Object obj3;
        Object obj4;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        Response root;
        String data;
        String jsonData;
        Iterable homeList;
        Collection destination$iv$iv;
        Object obj5;
        Object obj6;
        DeserializationStrategy deserializationStrategy2;
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
        C00011 c00012 = c00011;
        Object $result = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DonationManager.INSTANCE.checkAndShow(getName());
                c00012.L$0 = request;
                page2 = page;
                c00012.I$0 = page2;
                c00012.label = 1;
                if (syncConfig$default(this, false, c00012, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                isLiveTv = StringsKt.contains(request2.getData(), "android/getAllLiveTV", true);
                try {
                    Requests app = MainActivityKt.getApp();
                    try {
                        String mainPage$buildUrl = getMainPage$buildUrl(request2, page2, this);
                        Map<String, String> headers = INSTANCE.getHeaders();
                        c00012.L$0 = request2;
                        c00012.I$0 = page2;
                        c00012.Z$0 = isLiveTv;
                        c00012.label = 2;
                        page4 = page2;
                        request4 = request2;
                        obj = "kotlinx.serialization.serializer.simple";
                        obj2 = coroutine_suspended;
                        z = true;
                        try {
                            $result = Requests.get$default(app, mainPage$buildUrl, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4092, (Object) null);
                            c00012 = c00012;
                            if ($result == obj2) {
                                return obj2;
                            }
                            page3 = page4;
                            request3 = request4;
                            isLiveTv2 = isLiveTv;
                            try {
                                textLarge = ((NiceResponse) $result).getTextLarge();
                            } catch (Exception e) {
                                e = e;
                                c00012.L$0 = request3;
                                c00012.L$1 = SpillingKt.nullOutSpilledVariable(e);
                                c00012.I$0 = page3;
                                c00012.Z$0 = isLiveTv2;
                                c00012.label = 3;
                                if (syncConfig(z, c00012) == obj2) {
                                    return obj2;
                                }
                                exc = e;
                                isLiveTv3 = isLiveTv2;
                                page5 = page3;
                                request5 = request3;
                                try {
                                    Requests app2 = MainActivityKt.getApp();
                                    String mainPage$buildUrl2 = getMainPage$buildUrl(request5, page5, this);
                                    Map<String, String> headers2 = INSTANCE.getHeaders();
                                    c00012.L$0 = request5;
                                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(exc);
                                    c00012.I$0 = page5;
                                    c00012.Z$0 = isLiveTv3;
                                    c00012.label = 4;
                                    request6 = request5;
                                    isLiveTv4 = isLiveTv3;
                                    page6 = page5;
                                    try {
                                        $result = Requests.get$default(app2, mainPage$buildUrl2, headers2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4092, (Object) null);
                                        if ($result == obj2) {
                                            return obj2;
                                        }
                                        request3 = request6;
                                        page7 = page6;
                                        isLiveTv5 = isLiveTv4;
                                        try {
                                            textLarge = ((NiceResponse) $result).getTextLarge();
                                            isLiveTv2 = isLiveTv5;
                                        } catch (Exception e2) {
                                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                                        }
                                    } catch (Exception e3) {
                                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                                    }
                                } catch (Exception e4) {
                                }
                            }
                            responseText = textLarge;
                            try {
                                AppUtils appUtils = AppUtils.INSTANCE;
                                try {
                                    Result.Companion companion = Result.Companion;
                                    KType kTypeTypeOf = Reflection.typeOf(Response.class);
                                    MagicApiIntrinsics.voidMagicApiCall(obj);
                                    obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                    break;
                                } catch (Throwable th) {
                                    Result.Companion companion2 = Result.Companion;
                                    obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                                if (Result.exceptionOrNull-impl(obj3) != null) {
                                    try {
                                        Result.Companion companion3 = Result.Companion;
                                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Response.class), (List) null, 2, (Object) null));
                                    } catch (Throwable th2) {
                                        Result.Companion companion4 = Result.Companion;
                                        obj3 = Result.constructor-impl(ResultKt.createFailure(th2));
                                    }
                                    break;
                                }
                                obj4 = obj3;
                                if (Result.isFailure-impl(obj4)) {
                                    obj4 = null;
                                }
                                deserializationStrategy = (KSerializer) obj4;
                                if (deserializationStrategy != null) {
                                    try {
                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, responseText);
                                    } catch (SerializationException e5) {
                                        ArchComponentExtKt.logError(e5);
                                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv.readValue(responseText, new TypeReference<Response>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$1
                                        });
                                    } catch (Throwable th3) {
                                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv2.readValue(responseText, new TypeReference<Response>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$1
                                        });
                                    }
                                    break;
                                } else {
                                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv3.readValue(responseText, new TypeReference<Response>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$1
                                    });
                                }
                                root = (Response) objDecodeFromString;
                                if (root.getEncrypted()) {
                                    data = IStreamFlareParserKt.decryptPayload(root.getData());
                                } else {
                                    data = root.getData();
                                }
                                jsonData = data;
                                try {
                                    AppUtils appUtils2 = AppUtils.INSTANCE;
                                    try {
                                        Result.Companion companion5 = Result.Companion;
                                        KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                                        MagicApiIntrinsics.voidMagicApiCall(obj);
                                        obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                    } catch (Throwable th4) {
                                        Result.Companion companion6 = Result.Companion;
                                        obj5 = Result.constructor-impl(ResultKt.createFailure(th4));
                                    }
                                    if (Result.exceptionOrNull-impl(obj5) != null) {
                                        try {
                                            Result.Companion companion7 = Result.Companion;
                                            try {
                                                obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                                break;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                try {
                                                    Result.Companion companion8 = Result.Companion;
                                                    obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                                } catch (Exception e6) {
                                                    homeList = CollectionsKt.emptyList();
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                        }
                                    }
                                    obj6 = obj5;
                                    if (Result.isFailure-impl(obj6)) {
                                        obj6 = null;
                                    }
                                    deserializationStrategy2 = (KSerializer) obj6;
                                    if (deserializationStrategy2 != null) {
                                        try {
                                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonData);
                                        } catch (SerializationException e7) {
                                            ArchComponentExtKt.logError(e7);
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
                                    break;
                                } catch (Exception e8) {
                                }
                                Iterable $this$map$iv = homeList;
                                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                for (Object item$iv$iv : $this$map$iv) {
                                    HomeRes it = (HomeRes) item$iv$iv;
                                    destination$iv$iv.add(toSearchResult(it));
                                }
                                List searchResults = (List) destination$iv$iv;
                                return MainAPIKt.newHomePageResponse(new HomePageList(request3.getName(), searchResults, isLiveTv2), Boxing.boxBoolean(!searchResults.isEmpty()));
                            } catch (Exception e9) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                            }
                        } catch (Exception e10) {
                            e = e10;
                            c00012 = c00012;
                            page3 = page4;
                            request3 = request4;
                            isLiveTv2 = isLiveTv;
                            c00012.L$0 = request3;
                            c00012.L$1 = SpillingKt.nullOutSpilledVariable(e);
                            c00012.I$0 = page3;
                            c00012.Z$0 = isLiveTv2;
                            c00012.label = 3;
                            if (syncConfig(z, c00012) == obj2) {
                                return obj2;
                            }
                            exc = e;
                            isLiveTv3 = isLiveTv2;
                            page5 = page3;
                            request5 = request3;
                            Requests app3 = MainActivityKt.getApp();
                            String mainPage$buildUrl3 = getMainPage$buildUrl(request5, page5, this);
                            Map<String, String> headers3 = INSTANCE.getHeaders();
                            c00012.L$0 = request5;
                            c00012.L$1 = SpillingKt.nullOutSpilledVariable(exc);
                            c00012.I$0 = page5;
                            c00012.Z$0 = isLiveTv3;
                            c00012.label = 4;
                            request6 = request5;
                            isLiveTv4 = isLiveTv3;
                            page6 = page5;
                            $result = Requests.get$default(app3, mainPage$buildUrl3, headers3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4092, (Object) null);
                            if ($result == obj2) {
                                return obj2;
                            }
                            request3 = request6;
                            page7 = page6;
                            isLiveTv5 = isLiveTv4;
                            textLarge = ((NiceResponse) $result).getTextLarge();
                            isLiveTv2 = isLiveTv5;
                            responseText = textLarge;
                            AppUtils appUtils3 = AppUtils.INSTANCE;
                            Result.Companion companion9 = Result.Companion;
                            KType kTypeTypeOf3 = Reflection.typeOf(Response.class);
                            MagicApiIntrinsics.voidMagicApiCall(obj);
                            obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                            if (Result.exceptionOrNull-impl(obj3) != null) {
                                Result.Companion companion10 = Result.Companion;
                                obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Response.class), (List) null, 2, (Object) null));
                                break;
                            }
                            obj4 = obj3;
                            if (Result.isFailure-impl(obj4)) {
                                obj4 = null;
                            }
                            deserializationStrategy = (KSerializer) obj4;
                            if (deserializationStrategy != null) {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, responseText);
                                break;
                            } else {
                                ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv7.readValue(responseText, new TypeReference<Response>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$1
                                });
                            }
                            root = (Response) objDecodeFromString;
                            if (root.getEncrypted()) {
                                data = IStreamFlareParserKt.decryptPayload(root.getData());
                            } else {
                                data = root.getData();
                            }
                            jsonData = data;
                            AppUtils appUtils4 = AppUtils.INSTANCE;
                            Result.Companion companion11 = Result.Companion;
                            KType kTypeTypeOf4 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                            MagicApiIntrinsics.voidMagicApiCall(obj);
                            obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                            if (Result.exceptionOrNull-impl(obj5) != null) {
                                Result.Companion companion12 = Result.Companion;
                                obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                break;
                            }
                            obj6 = obj5;
                            if (Result.isFailure-impl(obj6)) {
                                obj6 = null;
                            }
                            deserializationStrategy2 = (KSerializer) obj6;
                            if (deserializationStrategy2 != null) {
                                ObjectMapper $this$readValue$iv$iv8 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv8.readValue(jsonData, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$2
                                });
                                homeList = (List) objDecodeFromString2;
                                break;
                            } else {
                                objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonData);
                                homeList = (List) objDecodeFromString2;
                                break;
                            }
                            Iterable $this$map$iv2 = homeList;
                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                            while (r13.hasNext()) {
                                HomeRes it2 = (HomeRes) item$iv$iv;
                                destination$iv$iv.add(toSearchResult(it2));
                            }
                            List searchResults2 = (List) destination$iv$iv;
                            return MainAPIKt.newHomePageResponse(new HomePageList(request3.getName(), searchResults2, isLiveTv2), Boxing.boxBoolean(!searchResults2.isEmpty()));
                        }
                    } catch (Exception e11) {
                        e = e11;
                        obj = "kotlinx.serialization.serializer.simple";
                        obj2 = coroutine_suspended;
                        MainPageRequest mainPageRequest = request2;
                        z = true;
                        page3 = page2;
                        request3 = mainPageRequest;
                        isLiveTv2 = isLiveTv;
                    }
                } catch (Exception e12) {
                    e = e12;
                    obj = "kotlinx.serialization.serializer.simple";
                    obj2 = coroutine_suspended;
                    MainPageRequest mainPageRequest2 = request2;
                    z = true;
                    page3 = page2;
                    request3 = mainPageRequest2;
                    isLiveTv2 = isLiveTv;
                }
                break;
            case 1:
                int page8 = c00012.I$0;
                MainPageRequest request7 = (MainPageRequest) c00012.L$0;
                ResultKt.throwOnFailure($result);
                request2 = request7;
                page2 = page8;
                isLiveTv = StringsKt.contains(request2.getData(), "android/getAllLiveTV", true);
                Requests app4 = MainActivityKt.getApp();
                String mainPage$buildUrl4 = getMainPage$buildUrl(request2, page2, this);
                Map<String, String> headers4 = INSTANCE.getHeaders();
                c00012.L$0 = request2;
                c00012.I$0 = page2;
                c00012.Z$0 = isLiveTv;
                c00012.label = 2;
                page4 = page2;
                request4 = request2;
                obj = "kotlinx.serialization.serializer.simple";
                obj2 = coroutine_suspended;
                z = true;
                $result = Requests.get$default(app4, mainPage$buildUrl4, headers4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4092, (Object) null);
                c00012 = c00012;
                if ($result == obj2) {
                    return obj2;
                }
                page3 = page4;
                request3 = request4;
                isLiveTv2 = isLiveTv;
                textLarge = ((NiceResponse) $result).getTextLarge();
                responseText = textLarge;
                AppUtils appUtils5 = AppUtils.INSTANCE;
                Result.Companion companion13 = Result.Companion;
                KType kTypeTypeOf5 = Reflection.typeOf(Response.class);
                MagicApiIntrinsics.voidMagicApiCall(obj);
                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                if (Result.exceptionOrNull-impl(obj3) != null) {
                    Result.Companion companion14 = Result.Companion;
                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Response.class), (List) null, 2, (Object) null));
                    break;
                }
                obj4 = obj3;
                if (Result.isFailure-impl(obj4)) {
                    obj4 = null;
                }
                deserializationStrategy = (KSerializer) obj4;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, responseText);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv9 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv9.readValue(responseText, new TypeReference<Response>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$1
                    });
                }
                root = (Response) objDecodeFromString;
                if (root.getEncrypted()) {
                    data = IStreamFlareParserKt.decryptPayload(root.getData());
                } else {
                    data = root.getData();
                }
                jsonData = data;
                AppUtils appUtils6 = AppUtils.INSTANCE;
                Result.Companion companion15 = Result.Companion;
                KType kTypeTypeOf6 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                MagicApiIntrinsics.voidMagicApiCall(obj);
                obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                if (Result.exceptionOrNull-impl(obj5) != null) {
                    Result.Companion companion16 = Result.Companion;
                    obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                    break;
                }
                obj6 = obj5;
                if (Result.isFailure-impl(obj6)) {
                    obj6 = null;
                }
                deserializationStrategy2 = (KSerializer) obj6;
                if (deserializationStrategy2 != null) {
                    ObjectMapper $this$readValue$iv$iv10 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv10.readValue(jsonData, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$2
                    });
                    homeList = (List) objDecodeFromString2;
                    break;
                } else {
                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonData);
                    homeList = (List) objDecodeFromString2;
                    break;
                }
                Iterable $this$map$iv3 = homeList;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r13.hasNext()) {
                    HomeRes it3 = (HomeRes) item$iv$iv;
                    destination$iv$iv.add(toSearchResult(it3));
                }
                List searchResults3 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(new HomePageList(request3.getName(), searchResults3, isLiveTv2), Boxing.boxBoolean(!searchResults3.isEmpty()));
            case 2:
                isLiveTv2 = c00012.Z$0;
                page3 = c00012.I$0;
                request3 = (MainPageRequest) c00012.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = "kotlinx.serialization.serializer.simple";
                    obj2 = coroutine_suspended;
                    z = true;
                    textLarge = ((NiceResponse) $result).getTextLarge();
                } catch (Exception e13) {
                    e = e13;
                    obj = "kotlinx.serialization.serializer.simple";
                    obj2 = coroutine_suspended;
                    z = true;
                    c00012.L$0 = request3;
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(e);
                    c00012.I$0 = page3;
                    c00012.Z$0 = isLiveTv2;
                    c00012.label = 3;
                    if (syncConfig(z, c00012) == obj2) {
                        return obj2;
                    }
                    exc = e;
                    isLiveTv3 = isLiveTv2;
                    page5 = page3;
                    request5 = request3;
                    Requests app5 = MainActivityKt.getApp();
                    String mainPage$buildUrl5 = getMainPage$buildUrl(request5, page5, this);
                    Map<String, String> headers5 = INSTANCE.getHeaders();
                    c00012.L$0 = request5;
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(exc);
                    c00012.I$0 = page5;
                    c00012.Z$0 = isLiveTv3;
                    c00012.label = 4;
                    request6 = request5;
                    isLiveTv4 = isLiveTv3;
                    page6 = page5;
                    $result = Requests.get$default(app5, mainPage$buildUrl5, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4092, (Object) null);
                    if ($result == obj2) {
                        return obj2;
                    }
                    request3 = request6;
                    page7 = page6;
                    isLiveTv5 = isLiveTv4;
                    textLarge = ((NiceResponse) $result).getTextLarge();
                    isLiveTv2 = isLiveTv5;
                    responseText = textLarge;
                    AppUtils appUtils7 = AppUtils.INSTANCE;
                    Result.Companion companion17 = Result.Companion;
                    KType kTypeTypeOf7 = Reflection.typeOf(Response.class);
                    MagicApiIntrinsics.voidMagicApiCall(obj);
                    obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf7));
                    if (Result.exceptionOrNull-impl(obj3) != null) {
                        Result.Companion companion18 = Result.Companion;
                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Response.class), (List) null, 2, (Object) null));
                        break;
                    }
                    obj4 = obj3;
                    if (Result.isFailure-impl(obj4)) {
                        obj4 = null;
                    }
                    deserializationStrategy = (KSerializer) obj4;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, responseText);
                        break;
                    } else {
                        ObjectMapper $this$readValue$iv$iv11 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv11.readValue(responseText, new TypeReference<Response>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$1
                        });
                    }
                    root = (Response) objDecodeFromString;
                    if (root.getEncrypted()) {
                        data = IStreamFlareParserKt.decryptPayload(root.getData());
                    } else {
                        data = root.getData();
                    }
                    jsonData = data;
                    AppUtils appUtils8 = AppUtils.INSTANCE;
                    Result.Companion companion19 = Result.Companion;
                    KType kTypeTypeOf8 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                    MagicApiIntrinsics.voidMagicApiCall(obj);
                    obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf8));
                    if (Result.exceptionOrNull-impl(obj5) != null) {
                        Result.Companion companion110 = Result.Companion;
                        obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                        break;
                    }
                    obj6 = obj5;
                    if (Result.isFailure-impl(obj6)) {
                        obj6 = null;
                    }
                    deserializationStrategy2 = (KSerializer) obj6;
                    if (deserializationStrategy2 != null) {
                        ObjectMapper $this$readValue$iv$iv12 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv12.readValue(jsonData, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$2
                        });
                        homeList = (List) objDecodeFromString2;
                        break;
                    } else {
                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonData);
                        homeList = (List) objDecodeFromString2;
                        break;
                    }
                    Iterable $this$map$iv4 = homeList;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                    while (r13.hasNext()) {
                        HomeRes it4 = (HomeRes) item$iv$iv;
                        destination$iv$iv.add(toSearchResult(it4));
                    }
                    List searchResults4 = (List) destination$iv$iv;
                    return MainAPIKt.newHomePageResponse(new HomePageList(request3.getName(), searchResults4, isLiveTv2), Boxing.boxBoolean(!searchResults4.isEmpty()));
                }
                responseText = textLarge;
                AppUtils appUtils9 = AppUtils.INSTANCE;
                Result.Companion companion111 = Result.Companion;
                KType kTypeTypeOf9 = Reflection.typeOf(Response.class);
                MagicApiIntrinsics.voidMagicApiCall(obj);
                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf9));
                if (Result.exceptionOrNull-impl(obj3) != null) {
                    Result.Companion companion112 = Result.Companion;
                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Response.class), (List) null, 2, (Object) null));
                    break;
                }
                obj4 = obj3;
                if (Result.isFailure-impl(obj4)) {
                    obj4 = null;
                }
                deserializationStrategy = (KSerializer) obj4;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, responseText);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv13 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv13.readValue(responseText, new TypeReference<Response>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$1
                    });
                }
                root = (Response) objDecodeFromString;
                if (root.getEncrypted()) {
                    data = IStreamFlareParserKt.decryptPayload(root.getData());
                } else {
                    data = root.getData();
                }
                jsonData = data;
                AppUtils appUtils10 = AppUtils.INSTANCE;
                Result.Companion companion113 = Result.Companion;
                KType kTypeTypeOf10 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                MagicApiIntrinsics.voidMagicApiCall(obj);
                obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf10));
                if (Result.exceptionOrNull-impl(obj5) != null) {
                    Result.Companion companion114 = Result.Companion;
                    obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                    break;
                }
                obj6 = obj5;
                if (Result.isFailure-impl(obj6)) {
                    obj6 = null;
                }
                deserializationStrategy2 = (KSerializer) obj6;
                if (deserializationStrategy2 != null) {
                    ObjectMapper $this$readValue$iv$iv14 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv14.readValue(jsonData, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$2
                    });
                    homeList = (List) objDecodeFromString2;
                    break;
                } else {
                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonData);
                    homeList = (List) objDecodeFromString2;
                    break;
                }
                Iterable $this$map$iv5 = homeList;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                while (r13.hasNext()) {
                    HomeRes it5 = (HomeRes) item$iv$iv;
                    destination$iv$iv.add(toSearchResult(it5));
                }
                List searchResults5 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(new HomePageList(request3.getName(), searchResults5, isLiveTv2), Boxing.boxBoolean(!searchResults5.isEmpty()));
            case 3:
                boolean isLiveTv6 = c00012.Z$0;
                int page9 = c00012.I$0;
                Exception exc2 = (Exception) c00012.L$1;
                MainPageRequest request8 = (MainPageRequest) c00012.L$0;
                ResultKt.throwOnFailure($result);
                obj = "kotlinx.serialization.serializer.simple";
                obj2 = coroutine_suspended;
                page5 = page9;
                exc = exc2;
                isLiveTv3 = isLiveTv6;
                request5 = request8;
                Requests app6 = MainActivityKt.getApp();
                String mainPage$buildUrl6 = getMainPage$buildUrl(request5, page5, this);
                Map<String, String> headers6 = INSTANCE.getHeaders();
                c00012.L$0 = request5;
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(exc);
                c00012.I$0 = page5;
                c00012.Z$0 = isLiveTv3;
                c00012.label = 4;
                request6 = request5;
                isLiveTv4 = isLiveTv3;
                page6 = page5;
                $result = Requests.get$default(app6, mainPage$buildUrl6, headers6, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4092, (Object) null);
                if ($result == obj2) {
                    return obj2;
                }
                request3 = request6;
                page7 = page6;
                isLiveTv5 = isLiveTv4;
                textLarge = ((NiceResponse) $result).getTextLarge();
                isLiveTv2 = isLiveTv5;
                responseText = textLarge;
                AppUtils appUtils11 = AppUtils.INSTANCE;
                Result.Companion companion115 = Result.Companion;
                KType kTypeTypeOf11 = Reflection.typeOf(Response.class);
                MagicApiIntrinsics.voidMagicApiCall(obj);
                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf11));
                if (Result.exceptionOrNull-impl(obj3) != null) {
                    Result.Companion companion116 = Result.Companion;
                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Response.class), (List) null, 2, (Object) null));
                    break;
                }
                obj4 = obj3;
                if (Result.isFailure-impl(obj4)) {
                    obj4 = null;
                }
                deserializationStrategy = (KSerializer) obj4;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, responseText);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv15 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv15.readValue(responseText, new TypeReference<Response>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$1
                    });
                }
                root = (Response) objDecodeFromString;
                if (root.getEncrypted()) {
                    data = IStreamFlareParserKt.decryptPayload(root.getData());
                } else {
                    data = root.getData();
                }
                jsonData = data;
                AppUtils appUtils12 = AppUtils.INSTANCE;
                Result.Companion companion117 = Result.Companion;
                KType kTypeTypeOf12 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                MagicApiIntrinsics.voidMagicApiCall(obj);
                obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf12));
                if (Result.exceptionOrNull-impl(obj5) != null) {
                    Result.Companion companion118 = Result.Companion;
                    obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                    break;
                }
                obj6 = obj5;
                if (Result.isFailure-impl(obj6)) {
                    obj6 = null;
                }
                deserializationStrategy2 = (KSerializer) obj6;
                if (deserializationStrategy2 != null) {
                    ObjectMapper $this$readValue$iv$iv16 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv16.readValue(jsonData, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$2
                    });
                    homeList = (List) objDecodeFromString2;
                    break;
                } else {
                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonData);
                    homeList = (List) objDecodeFromString2;
                    break;
                }
                Iterable $this$map$iv6 = homeList;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
                while (r13.hasNext()) {
                    HomeRes it6 = (HomeRes) item$iv$iv;
                    destination$iv$iv.add(toSearchResult(it6));
                }
                List searchResults6 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(new HomePageList(request3.getName(), searchResults6, isLiveTv2), Boxing.boxBoolean(!searchResults6.isEmpty()));
            case 4:
                isLiveTv5 = c00012.Z$0;
                page7 = c00012.I$0;
                request3 = (MainPageRequest) c00012.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = "kotlinx.serialization.serializer.simple";
                    textLarge = ((NiceResponse) $result).getTextLarge();
                    isLiveTv2 = isLiveTv5;
                    responseText = textLarge;
                    AppUtils appUtils13 = AppUtils.INSTANCE;
                    Result.Companion companion119 = Result.Companion;
                    KType kTypeTypeOf13 = Reflection.typeOf(Response.class);
                    MagicApiIntrinsics.voidMagicApiCall(obj);
                    obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf13));
                    if (Result.exceptionOrNull-impl(obj3) != null) {
                        Result.Companion companion1110 = Result.Companion;
                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Response.class), (List) null, 2, (Object) null));
                        break;
                    }
                    obj4 = obj3;
                    if (Result.isFailure-impl(obj4)) {
                        obj4 = null;
                    }
                    deserializationStrategy = (KSerializer) obj4;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, responseText);
                        break;
                    } else {
                        ObjectMapper $this$readValue$iv$iv17 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv17.readValue(responseText, new TypeReference<Response>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$1
                        });
                    }
                    root = (Response) objDecodeFromString;
                    if (root.getEncrypted()) {
                        data = IStreamFlareParserKt.decryptPayload(root.getData());
                    } else {
                        data = root.getData();
                    }
                    jsonData = data;
                    AppUtils appUtils14 = AppUtils.INSTANCE;
                    Result.Companion companion1111 = Result.Companion;
                    KType kTypeTypeOf14 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                    MagicApiIntrinsics.voidMagicApiCall(obj);
                    obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf14));
                    if (Result.exceptionOrNull-impl(obj5) != null) {
                        Result.Companion companion1112 = Result.Companion;
                        obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                        break;
                    }
                    obj6 = obj5;
                    if (Result.isFailure-impl(obj6)) {
                        obj6 = null;
                    }
                    deserializationStrategy2 = (KSerializer) obj6;
                    if (deserializationStrategy2 != null) {
                        ObjectMapper $this$readValue$iv$iv18 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv18.readValue(jsonData, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$getMainPage$$inlined$parseJson$2
                        });
                        homeList = (List) objDecodeFromString2;
                        break;
                    } else {
                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonData);
                        homeList = (List) objDecodeFromString2;
                        break;
                    }
                    Iterable $this$map$iv7 = homeList;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv7, 10));
                    while (r13.hasNext()) {
                        HomeRes it7 = (HomeRes) item$iv$iv;
                        destination$iv$iv.add(toSearchResult(it7));
                    }
                    List searchResults7 = (List) destination$iv$iv;
                    return MainAPIKt.newHomePageResponse(new HomePageList(request3.getName(), searchResults7, isLiveTv2), Boxing.boxBoolean(!searchResults7.isEmpty()));
                } catch (Exception e14) {
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final String getMainPage$buildUrl(MainPageRequest $request, int $page, IStreamFlare this$0) {
        if (StringsKt.endsWith$default($request.getData(), "page", false, 2, (Object) null)) {
            int offset = ($page - 1) * 10;
            return this$0.getMainUrl() + '/' + StringsKt.removeSuffix($request.getData(), "page") + offset;
        }
        return this$0.getMainUrl() + '/' + $request.getData();
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

    /* JADX WARN: Code duplicated, block: B:100:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:110:0x0309  */
    /* JADX WARN: Code duplicated, block: B:123:0x033c  */
    /* JADX WARN: Code duplicated, block: B:132:0x0358 A[Catch: Exception -> 0x0370, TryCatch #0 {Exception -> 0x0370, blocks: (B:102:0x02d1, B:108:0x0303, B:121:0x0336, B:124:0x033d, B:133:0x036d, B:132:0x0358, B:131:0x0352, B:120:0x032b, B:107:0x02f9, B:126:0x0343, B:104:0x02d6), top: B:151:0x02d1, inners: #14, #18, #18 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x0394 A[LOOP:0: B:138:0x038e->B:140:0x0394, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:163:0x0228 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x030c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x0260 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x0343 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x013b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x013c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0178 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x0179  */
    /* JADX WARN: Code duplicated, block: B:55:0x01ea A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:66:0x0225  */
    /* JADX WARN: Code duplicated, block: B:79:0x0259  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:88:0x0275  */
    /* JADX WARN: Code duplicated, block: B:91:0x0295  */
    /* JADX WARN: Code duplicated, block: B:94:0x029d  */
    /* JADX WARN: Code duplicated, block: B:96:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:98:0x02c3 A[RETURN] */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00091 c00091;
        String query2;
        String url;
        Object obj;
        String str;
        String str2;
        String query3;
        String url2;
        String query4;
        Object obj2;
        Exception exc;
        String url3;
        String query5;
        String value$iv;
        String url4;
        String url5;
        boolean z;
        String query6;
        String url6;
        String query7;
        String url7;
        String raw;
        String value$iv2;
        Object obj3;
        int i;
        Object obj4;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        JsonNode outer;
        JsonNode jsonNode;
        boolean z2;
        Iterable homeList;
        Collection destination$iv$iv;
        String value$iv3;
        Object obj5;
        Object obj6;
        Object obj7;
        DeserializationStrategy deserializationStrategy2;
        Object objDecodeFromString2;
        IStreamFlare iStreamFlare = this;
        if (continuation instanceof C00091) {
            c00091 = (C00091) continuation;
            if ((c00091.label & Integer.MIN_VALUE) != 0) {
                c00091.label -= Integer.MIN_VALUE;
            } else {
                c00091 = iStreamFlare.new C00091(continuation);
            }
        } else {
            c00091 = iStreamFlare.new C00091(continuation);
        }
        C00091 c00092 = c00091;
        Object $result = c00092.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00092.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00092.L$0 = query;
                c00092.label = 1;
                if (syncConfig$default(iStreamFlare, false, c00092, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                query2 = query;
                url = iStreamFlare.getMainUrl() + "/android/searchContent/" + query2 + "/1";
                try {
                    Requests app = MainActivityKt.getApp();
                    Map<String, String> headers = INSTANCE.getHeaders();
                    c00092.L$0 = query2;
                    c00092.L$1 = url;
                    c00092.label = 2;
                    query4 = query2;
                    obj = coroutine_suspended;
                    str = "/1";
                    str2 = "/android/searchContent/";
                    try {
                        obj2 = Requests.get$default(app, url, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00092, 4092, (Object) null);
                        c00092 = c00092;
                        if (obj2 == obj) {
                            return obj;
                        }
                        query3 = url;
                        url2 = query4;
                        $result = obj2;
                        try {
                            value$iv = ((NiceResponse) $result).getTextLarge();
                            url4 = query3;
                            url5 = url2;
                            z = true;
                        } catch (Exception e) {
                            e = e;
                            c00092.L$0 = url2;
                            c00092.L$1 = query3;
                            c00092.L$2 = SpillingKt.nullOutSpilledVariable(e);
                            c00092.label = 3;
                            if (iStreamFlare.syncConfig(true, c00092) == obj) {
                                return obj;
                            }
                            exc = e;
                            url3 = query3;
                            query5 = url2;
                            try {
                                Requests app2 = MainActivityKt.getApp();
                                String str3 = iStreamFlare.getMainUrl() + str2 + query5 + str;
                                Map<String, String> headers2 = INSTANCE.getHeaders();
                                c00092.L$0 = SpillingKt.nullOutSpilledVariable(query5);
                                c00092.L$1 = url3;
                                c00092.L$2 = SpillingKt.nullOutSpilledVariable(exc);
                                c00092.label = 4;
                                query6 = query5;
                                url6 = url3;
                                z = true;
                                C00091 c00093 = c00092;
                                try {
                                    $result = Requests.get$default(app2, str3, headers2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00093, 4092, (Object) null);
                                    c00092 = c00093;
                                    if ($result == obj) {
                                        return obj;
                                    }
                                    query7 = query6;
                                    url7 = url6;
                                    try {
                                        value$iv = ((NiceResponse) $result).getTextLarge();
                                        url4 = url7;
                                        url5 = query7;
                                    } catch (Exception e2) {
                                        return CollectionsKt.emptyList();
                                    }
                                } catch (Exception e3) {
                                    return CollectionsKt.emptyList();
                                }
                            } catch (Exception e4) {
                            }
                        }
                        raw = value$iv;
                        AppUtils appUtils = AppUtils.INSTANCE;
                        value$iv2 = value$iv;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(JsonNode.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                            break;
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj3) != null) {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                i = 2;
                                try {
                                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, 2, (Object) null));
                                } catch (Throwable th2) {
                                    th = th2;
                                    Result.Companion companion4 = Result.Companion;
                                    obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                i = 2;
                            }
                            break;
                        } else {
                            i = 2;
                        }
                        obj4 = obj3;
                        if (Result.isFailure-impl(obj4)) {
                            obj4 = null;
                        }
                        deserializationStrategy = (KSerializer) obj4;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv2);
                            } catch (SerializationException e5) {
                                ArchComponentExtKt.logError(e5);
                                ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv.readValue(value$iv2, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$1
                                });
                            } catch (Throwable th4) {
                                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv2.readValue(value$iv2, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$1
                                });
                            }
                            break;
                        } else {
                            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv3.readValue(value$iv2, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$1
                            });
                        }
                        outer = (JsonNode) objDecodeFromString;
                        jsonNode = outer.get("encrypted");
                        if (jsonNode == null && jsonNode.asBoolean() == z) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            c00092.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                            c00092.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                            c00092.L$2 = SpillingKt.nullOutSpilledVariable(raw);
                            c00092.L$3 = SpillingKt.nullOutSpilledVariable(outer);
                            c00092.label = 5;
                            iStreamFlare = this;
                            $result = iStreamFlare.getDecodedJson(url4, c00092);
                            if ($result == obj) {
                                return obj;
                            }
                            raw = (String) $result;
                        } else {
                            iStreamFlare = this;
                        }
                        try {
                            AppUtils appUtils2 = AppUtils.INSTANCE;
                            value$iv3 = raw;
                            try {
                                Result.Companion companion5 = Result.Companion;
                                KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                            } catch (Throwable th5) {
                                Result.Companion companion6 = Result.Companion;
                                obj5 = Result.constructor-impl(ResultKt.createFailure(th5));
                            }
                            if (Result.exceptionOrNull-impl(obj5) != null) {
                                obj6 = null;
                            } else {
                                try {
                                    Result.Companion companion7 = Result.Companion;
                                    obj6 = null;
                                    try {
                                        obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, i, (Object) null));
                                    } catch (Throwable th6) {
                                        th = th6;
                                        Result.Companion companion8 = Result.Companion;
                                        obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    obj6 = null;
                                }
                            }
                            obj7 = obj5;
                            if (Result.isFailure-impl(obj7)) {
                                obj7 = obj6;
                            }
                            deserializationStrategy2 = (KSerializer) obj7;
                            if (deserializationStrategy2 == null) {
                                try {
                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv3);
                                } catch (SerializationException e6) {
                                    ArchComponentExtKt.logError(e6);
                                    ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                    objDecodeFromString2 = $this$readValue$iv$iv4.readValue(value$iv3, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$2
                                    });
                                } catch (Throwable th8) {
                                    ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                    objDecodeFromString2 = $this$readValue$iv$iv5.readValue(value$iv3, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$2
                                    });
                                }
                                homeList = (List) objDecodeFromString2;
                            } else {
                                ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv6.readValue(value$iv3, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$2
                                });
                                homeList = (List) objDecodeFromString2;
                            }
                            break;
                        } catch (Exception e7) {
                            homeList = CollectionsKt.emptyList();
                        }
                        Iterable $this$map$iv = homeList;
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            HomeRes it = (HomeRes) item$iv$iv;
                            destination$iv$iv.add(iStreamFlare.toSearchResult(it));
                        }
                        return (List) destination$iv$iv;
                    } catch (Exception e8) {
                        e = e8;
                        c00092 = c00092;
                        query3 = url;
                        url2 = query4;
                        c00092.L$0 = url2;
                        c00092.L$1 = query3;
                        c00092.L$2 = SpillingKt.nullOutSpilledVariable(e);
                        c00092.label = 3;
                        if (iStreamFlare.syncConfig(true, c00092) == obj) {
                            return obj;
                        }
                        exc = e;
                        url3 = query3;
                        query5 = url2;
                        Requests app3 = MainActivityKt.getApp();
                        String str4 = iStreamFlare.getMainUrl() + str2 + query5 + str;
                        Map<String, String> headers3 = INSTANCE.getHeaders();
                        c00092.L$0 = SpillingKt.nullOutSpilledVariable(query5);
                        c00092.L$1 = url3;
                        c00092.L$2 = SpillingKt.nullOutSpilledVariable(exc);
                        c00092.label = 4;
                        query6 = query5;
                        url6 = url3;
                        z = true;
                        C00091 c00094 = c00092;
                        $result = Requests.get$default(app3, str4, headers3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00094, 4092, (Object) null);
                        c00092 = c00094;
                        if ($result == obj) {
                            return obj;
                        }
                        query7 = query6;
                        url7 = url6;
                        value$iv = ((NiceResponse) $result).getTextLarge();
                        url4 = url7;
                        url5 = query7;
                        raw = value$iv;
                        AppUtils appUtils3 = AppUtils.INSTANCE;
                        value$iv2 = value$iv;
                        Result.Companion companion9 = Result.Companion;
                        KType kTypeTypeOf3 = Reflection.typeOf(JsonNode.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                        if (Result.exceptionOrNull-impl(obj3) != null) {
                            Result.Companion companion10 = Result.Companion;
                            i = 2;
                            obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, 2, (Object) null));
                            break;
                        } else {
                            i = 2;
                        }
                        obj4 = obj3;
                        if (Result.isFailure-impl(obj4)) {
                            obj4 = null;
                        }
                        deserializationStrategy = (KSerializer) obj4;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv2);
                            break;
                        } else {
                            ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv7.readValue(value$iv2, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$1
                            });
                        }
                        outer = (JsonNode) objDecodeFromString;
                        jsonNode = outer.get("encrypted");
                        if (jsonNode == null) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            c00092.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                            c00092.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                            c00092.L$2 = SpillingKt.nullOutSpilledVariable(raw);
                            c00092.L$3 = SpillingKt.nullOutSpilledVariable(outer);
                            c00092.label = 5;
                            iStreamFlare = this;
                            $result = iStreamFlare.getDecodedJson(url4, c00092);
                            if ($result == obj) {
                                return obj;
                            }
                            raw = (String) $result;
                        } else {
                            iStreamFlare = this;
                        }
                        AppUtils appUtils4 = AppUtils.INSTANCE;
                        value$iv3 = raw;
                        Result.Companion companion11 = Result.Companion;
                        KType kTypeTypeOf4 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                        if (Result.exceptionOrNull-impl(obj5) != null) {
                            Result.Companion companion12 = Result.Companion;
                            obj6 = null;
                            obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, i, (Object) null));
                            break;
                        } else {
                            obj6 = null;
                        }
                        obj7 = obj5;
                        if (Result.isFailure-impl(obj7)) {
                            obj7 = obj6;
                        }
                        deserializationStrategy2 = (KSerializer) obj7;
                        if (deserializationStrategy2 == null) {
                            ObjectMapper $this$readValue$iv$iv8 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv8.readValue(value$iv3, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$2
                            });
                            homeList = (List) objDecodeFromString2;
                            break;
                        } else {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv3);
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
                    }
                } catch (Exception e9) {
                    e = e9;
                    obj = coroutine_suspended;
                    str = "/1";
                    str2 = "/android/searchContent/";
                    String str5 = query2;
                    query3 = url;
                    url2 = str5;
                }
                break;
            case 1:
                String query8 = (String) c00092.L$0;
                ResultKt.throwOnFailure($result);
                query2 = query8;
                url = iStreamFlare.getMainUrl() + "/android/searchContent/" + query2 + "/1";
                Requests app4 = MainActivityKt.getApp();
                Map<String, String> headers4 = INSTANCE.getHeaders();
                c00092.L$0 = query2;
                c00092.L$1 = url;
                c00092.label = 2;
                query4 = query2;
                obj = coroutine_suspended;
                str = "/1";
                str2 = "/android/searchContent/";
                obj2 = Requests.get$default(app4, url, headers4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00092, 4092, (Object) null);
                c00092 = c00092;
                if (obj2 == obj) {
                    return obj;
                }
                query3 = url;
                url2 = query4;
                $result = obj2;
                value$iv = ((NiceResponse) $result).getTextLarge();
                url4 = query3;
                url5 = url2;
                z = true;
                raw = value$iv;
                AppUtils appUtils5 = AppUtils.INSTANCE;
                value$iv2 = value$iv;
                Result.Companion companion13 = Result.Companion;
                KType kTypeTypeOf5 = Reflection.typeOf(JsonNode.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                if (Result.exceptionOrNull-impl(obj3) != null) {
                    Result.Companion companion14 = Result.Companion;
                    i = 2;
                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, 2, (Object) null));
                    break;
                } else {
                    i = 2;
                }
                obj4 = obj3;
                if (Result.isFailure-impl(obj4)) {
                    obj4 = null;
                }
                deserializationStrategy = (KSerializer) obj4;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv2);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv9 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv9.readValue(value$iv2, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$1
                    });
                }
                outer = (JsonNode) objDecodeFromString;
                jsonNode = outer.get("encrypted");
                if (jsonNode == null) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                if (z2) {
                    c00092.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                    c00092.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                    c00092.L$2 = SpillingKt.nullOutSpilledVariable(raw);
                    c00092.L$3 = SpillingKt.nullOutSpilledVariable(outer);
                    c00092.label = 5;
                    iStreamFlare = this;
                    $result = iStreamFlare.getDecodedJson(url4, c00092);
                    if ($result == obj) {
                        return obj;
                    }
                    raw = (String) $result;
                } else {
                    iStreamFlare = this;
                }
                AppUtils appUtils6 = AppUtils.INSTANCE;
                value$iv3 = raw;
                Result.Companion companion15 = Result.Companion;
                KType kTypeTypeOf6 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                if (Result.exceptionOrNull-impl(obj5) != null) {
                    Result.Companion companion16 = Result.Companion;
                    obj6 = null;
                    obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, i, (Object) null));
                    break;
                } else {
                    obj6 = null;
                }
                obj7 = obj5;
                if (Result.isFailure-impl(obj7)) {
                    obj7 = obj6;
                }
                deserializationStrategy2 = (KSerializer) obj7;
                if (deserializationStrategy2 == null) {
                    ObjectMapper $this$readValue$iv$iv10 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv10.readValue(value$iv3, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$2
                    });
                    homeList = (List) objDecodeFromString2;
                    break;
                } else {
                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv3);
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
            case 2:
                query3 = (String) c00092.L$1;
                url2 = (String) c00092.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = coroutine_suspended;
                    str = "/1";
                    str2 = "/android/searchContent/";
                    value$iv = ((NiceResponse) $result).getTextLarge();
                    url4 = query3;
                    url5 = url2;
                    z = true;
                } catch (Exception e10) {
                    e = e10;
                    obj = coroutine_suspended;
                    str = "/1";
                    str2 = "/android/searchContent/";
                    c00092.L$0 = url2;
                    c00092.L$1 = query3;
                    c00092.L$2 = SpillingKt.nullOutSpilledVariable(e);
                    c00092.label = 3;
                    if (iStreamFlare.syncConfig(true, c00092) == obj) {
                        return obj;
                    }
                    exc = e;
                    url3 = query3;
                    query5 = url2;
                    Requests app5 = MainActivityKt.getApp();
                    String str6 = iStreamFlare.getMainUrl() + str2 + query5 + str;
                    Map<String, String> headers5 = INSTANCE.getHeaders();
                    c00092.L$0 = SpillingKt.nullOutSpilledVariable(query5);
                    c00092.L$1 = url3;
                    c00092.L$2 = SpillingKt.nullOutSpilledVariable(exc);
                    c00092.label = 4;
                    query6 = query5;
                    url6 = url3;
                    z = true;
                    C00091 c00095 = c00092;
                    $result = Requests.get$default(app5, str6, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00095, 4092, (Object) null);
                    c00092 = c00095;
                    if ($result == obj) {
                        return obj;
                    }
                    query7 = query6;
                    url7 = url6;
                    value$iv = ((NiceResponse) $result).getTextLarge();
                    url4 = url7;
                    url5 = query7;
                    raw = value$iv;
                    AppUtils appUtils7 = AppUtils.INSTANCE;
                    value$iv2 = value$iv;
                    Result.Companion companion17 = Result.Companion;
                    KType kTypeTypeOf7 = Reflection.typeOf(JsonNode.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf7));
                    if (Result.exceptionOrNull-impl(obj3) != null) {
                        Result.Companion companion18 = Result.Companion;
                        i = 2;
                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, 2, (Object) null));
                        break;
                    } else {
                        i = 2;
                    }
                    obj4 = obj3;
                    if (Result.isFailure-impl(obj4)) {
                        obj4 = null;
                    }
                    deserializationStrategy = (KSerializer) obj4;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv2);
                        break;
                    } else {
                        ObjectMapper $this$readValue$iv$iv11 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv11.readValue(value$iv2, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$1
                        });
                    }
                    outer = (JsonNode) objDecodeFromString;
                    jsonNode = outer.get("encrypted");
                    if (jsonNode == null) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        c00092.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                        c00092.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                        c00092.L$2 = SpillingKt.nullOutSpilledVariable(raw);
                        c00092.L$3 = SpillingKt.nullOutSpilledVariable(outer);
                        c00092.label = 5;
                        iStreamFlare = this;
                        $result = iStreamFlare.getDecodedJson(url4, c00092);
                        if ($result == obj) {
                            return obj;
                        }
                        raw = (String) $result;
                    } else {
                        iStreamFlare = this;
                    }
                    AppUtils appUtils8 = AppUtils.INSTANCE;
                    value$iv3 = raw;
                    Result.Companion companion19 = Result.Companion;
                    KType kTypeTypeOf8 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf8));
                    if (Result.exceptionOrNull-impl(obj5) != null) {
                        Result.Companion companion110 = Result.Companion;
                        obj6 = null;
                        obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, i, (Object) null));
                        break;
                    } else {
                        obj6 = null;
                    }
                    obj7 = obj5;
                    if (Result.isFailure-impl(obj7)) {
                        obj7 = obj6;
                    }
                    deserializationStrategy2 = (KSerializer) obj7;
                    if (deserializationStrategy2 == null) {
                        ObjectMapper $this$readValue$iv$iv12 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv12.readValue(value$iv3, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$2
                        });
                        homeList = (List) objDecodeFromString2;
                        break;
                    } else {
                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv3);
                        homeList = (List) objDecodeFromString2;
                        break;
                    }
                    Iterable $this$map$iv4 = homeList;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                    while (r13.hasNext()) {
                        HomeRes it4 = (HomeRes) item$iv$iv;
                        destination$iv$iv.add(iStreamFlare.toSearchResult(it4));
                    }
                    return (List) destination$iv$iv;
                }
                raw = value$iv;
                AppUtils appUtils9 = AppUtils.INSTANCE;
                value$iv2 = value$iv;
                Result.Companion companion111 = Result.Companion;
                KType kTypeTypeOf9 = Reflection.typeOf(JsonNode.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf9));
                if (Result.exceptionOrNull-impl(obj3) != null) {
                    Result.Companion companion112 = Result.Companion;
                    i = 2;
                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, 2, (Object) null));
                    break;
                } else {
                    i = 2;
                }
                obj4 = obj3;
                if (Result.isFailure-impl(obj4)) {
                    obj4 = null;
                }
                deserializationStrategy = (KSerializer) obj4;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv2);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv13 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv13.readValue(value$iv2, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$1
                    });
                }
                outer = (JsonNode) objDecodeFromString;
                jsonNode = outer.get("encrypted");
                if (jsonNode == null) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                if (z2) {
                    c00092.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                    c00092.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                    c00092.L$2 = SpillingKt.nullOutSpilledVariable(raw);
                    c00092.L$3 = SpillingKt.nullOutSpilledVariable(outer);
                    c00092.label = 5;
                    iStreamFlare = this;
                    $result = iStreamFlare.getDecodedJson(url4, c00092);
                    if ($result == obj) {
                        return obj;
                    }
                    raw = (String) $result;
                } else {
                    iStreamFlare = this;
                }
                AppUtils appUtils10 = AppUtils.INSTANCE;
                value$iv3 = raw;
                Result.Companion companion113 = Result.Companion;
                KType kTypeTypeOf10 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf10));
                if (Result.exceptionOrNull-impl(obj5) != null) {
                    Result.Companion companion114 = Result.Companion;
                    obj6 = null;
                    obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, i, (Object) null));
                    break;
                } else {
                    obj6 = null;
                }
                obj7 = obj5;
                if (Result.isFailure-impl(obj7)) {
                    obj7 = obj6;
                }
                deserializationStrategy2 = (KSerializer) obj7;
                if (deserializationStrategy2 == null) {
                    ObjectMapper $this$readValue$iv$iv14 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv14.readValue(value$iv3, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$2
                    });
                    homeList = (List) objDecodeFromString2;
                    break;
                } else {
                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv3);
                    homeList = (List) objDecodeFromString2;
                    break;
                }
                Iterable $this$map$iv5 = homeList;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                while (r13.hasNext()) {
                    HomeRes it5 = (HomeRes) item$iv$iv;
                    destination$iv$iv.add(iStreamFlare.toSearchResult(it5));
                }
                return (List) destination$iv$iv;
            case 3:
                Exception exc2 = (Exception) c00092.L$2;
                String url8 = (String) c00092.L$1;
                String query9 = (String) c00092.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                str = "/1";
                str2 = "/android/searchContent/";
                exc = exc2;
                url3 = url8;
                query5 = query9;
                Requests app6 = MainActivityKt.getApp();
                String str7 = iStreamFlare.getMainUrl() + str2 + query5 + str;
                Map<String, String> headers6 = INSTANCE.getHeaders();
                c00092.L$0 = SpillingKt.nullOutSpilledVariable(query5);
                c00092.L$1 = url3;
                c00092.L$2 = SpillingKt.nullOutSpilledVariable(exc);
                c00092.label = 4;
                query6 = query5;
                url6 = url3;
                z = true;
                C00091 c00096 = c00092;
                $result = Requests.get$default(app6, str7, headers6, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00096, 4092, (Object) null);
                c00092 = c00096;
                if ($result == obj) {
                    return obj;
                }
                query7 = query6;
                url7 = url6;
                value$iv = ((NiceResponse) $result).getTextLarge();
                url4 = url7;
                url5 = query7;
                raw = value$iv;
                AppUtils appUtils11 = AppUtils.INSTANCE;
                value$iv2 = value$iv;
                Result.Companion companion115 = Result.Companion;
                KType kTypeTypeOf11 = Reflection.typeOf(JsonNode.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf11));
                if (Result.exceptionOrNull-impl(obj3) != null) {
                    Result.Companion companion116 = Result.Companion;
                    i = 2;
                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, 2, (Object) null));
                    break;
                } else {
                    i = 2;
                }
                obj4 = obj3;
                if (Result.isFailure-impl(obj4)) {
                    obj4 = null;
                }
                deserializationStrategy = (KSerializer) obj4;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv2);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv15 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv15.readValue(value$iv2, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$1
                    });
                }
                outer = (JsonNode) objDecodeFromString;
                jsonNode = outer.get("encrypted");
                if (jsonNode == null) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                if (z2) {
                    c00092.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                    c00092.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                    c00092.L$2 = SpillingKt.nullOutSpilledVariable(raw);
                    c00092.L$3 = SpillingKt.nullOutSpilledVariable(outer);
                    c00092.label = 5;
                    iStreamFlare = this;
                    $result = iStreamFlare.getDecodedJson(url4, c00092);
                    if ($result == obj) {
                        return obj;
                    }
                    raw = (String) $result;
                } else {
                    iStreamFlare = this;
                }
                AppUtils appUtils12 = AppUtils.INSTANCE;
                value$iv3 = raw;
                Result.Companion companion117 = Result.Companion;
                KType kTypeTypeOf12 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf12));
                if (Result.exceptionOrNull-impl(obj5) != null) {
                    Result.Companion companion118 = Result.Companion;
                    obj6 = null;
                    obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, i, (Object) null));
                    break;
                } else {
                    obj6 = null;
                }
                obj7 = obj5;
                if (Result.isFailure-impl(obj7)) {
                    obj7 = obj6;
                }
                deserializationStrategy2 = (KSerializer) obj7;
                if (deserializationStrategy2 == null) {
                    ObjectMapper $this$readValue$iv$iv16 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv16.readValue(value$iv3, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$2
                    });
                    homeList = (List) objDecodeFromString2;
                    break;
                } else {
                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv3);
                    homeList = (List) objDecodeFromString2;
                    break;
                }
                Iterable $this$map$iv6 = homeList;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
                while (r13.hasNext()) {
                    HomeRes it6 = (HomeRes) item$iv$iv;
                    destination$iv$iv.add(iStreamFlare.toSearchResult(it6));
                }
                return (List) destination$iv$iv;
            case 4:
                url7 = (String) c00092.L$1;
                query7 = (String) c00092.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = coroutine_suspended;
                    z = true;
                    value$iv = ((NiceResponse) $result).getTextLarge();
                    url4 = url7;
                    url5 = query7;
                    raw = value$iv;
                    AppUtils appUtils13 = AppUtils.INSTANCE;
                    value$iv2 = value$iv;
                    Result.Companion companion119 = Result.Companion;
                    KType kTypeTypeOf13 = Reflection.typeOf(JsonNode.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf13));
                    if (Result.exceptionOrNull-impl(obj3) != null) {
                        Result.Companion companion1110 = Result.Companion;
                        i = 2;
                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, 2, (Object) null));
                        break;
                    } else {
                        i = 2;
                    }
                    obj4 = obj3;
                    if (Result.isFailure-impl(obj4)) {
                        obj4 = null;
                    }
                    deserializationStrategy = (KSerializer) obj4;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv2);
                        break;
                    } else {
                        ObjectMapper $this$readValue$iv$iv17 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv17.readValue(value$iv2, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$1
                        });
                    }
                    outer = (JsonNode) objDecodeFromString;
                    jsonNode = outer.get("encrypted");
                    if (jsonNode == null) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        c00092.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                        c00092.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                        c00092.L$2 = SpillingKt.nullOutSpilledVariable(raw);
                        c00092.L$3 = SpillingKt.nullOutSpilledVariable(outer);
                        c00092.label = 5;
                        iStreamFlare = this;
                        $result = iStreamFlare.getDecodedJson(url4, c00092);
                        if ($result == obj) {
                            return obj;
                        }
                        raw = (String) $result;
                    } else {
                        iStreamFlare = this;
                    }
                    AppUtils appUtils14 = AppUtils.INSTANCE;
                    value$iv3 = raw;
                    Result.Companion companion1111 = Result.Companion;
                    KType kTypeTypeOf14 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf14));
                    if (Result.exceptionOrNull-impl(obj5) != null) {
                        Result.Companion companion1112 = Result.Companion;
                        obj6 = null;
                        obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, i, (Object) null));
                        break;
                    } else {
                        obj6 = null;
                    }
                    obj7 = obj5;
                    if (Result.isFailure-impl(obj7)) {
                        obj7 = obj6;
                    }
                    deserializationStrategy2 = (KSerializer) obj7;
                    if (deserializationStrategy2 == null) {
                        ObjectMapper $this$readValue$iv$iv18 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv18.readValue(value$iv3, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$2
                        });
                        homeList = (List) objDecodeFromString2;
                        break;
                    } else {
                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv3);
                        homeList = (List) objDecodeFromString2;
                        break;
                    }
                    Iterable $this$map$iv7 = homeList;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv7, 10));
                    while (r13.hasNext()) {
                        HomeRes it7 = (HomeRes) item$iv$iv;
                        destination$iv$iv.add(iStreamFlare.toSearchResult(it7));
                    }
                    return (List) destination$iv$iv;
                } catch (Exception e11) {
                    return CollectionsKt.emptyList();
                }
            case 5:
                outer = (JsonNode) c00092.L$3;
                raw = (String) c00092.L$2;
                ResultKt.throwOnFailure($result);
                i = 2;
                raw = (String) $result;
                AppUtils appUtils15 = AppUtils.INSTANCE;
                value$iv3 = raw;
                Result.Companion companion1113 = Result.Companion;
                KType kTypeTypeOf15 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HomeRes.class)));
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf15));
                if (Result.exceptionOrNull-impl(obj5) != null) {
                    Result.Companion companion1114 = Result.Companion;
                    obj6 = null;
                    obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, i, (Object) null));
                    break;
                } else {
                    obj6 = null;
                }
                obj7 = obj5;
                if (Result.isFailure-impl(obj7)) {
                    obj7 = obj6;
                }
                deserializationStrategy2 = (KSerializer) obj7;
                if (deserializationStrategy2 == null) {
                    ObjectMapper $this$readValue$iv$iv19 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv19.readValue(value$iv3, new TypeReference<List<? extends HomeRes>>() { // from class: com.IStreamFlare.IStreamFlare$search$$inlined$parseJson$2
                    });
                    homeList = (List) objDecodeFromString2;
                    break;
                } else {
                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv3);
                    homeList = (List) objDecodeFromString2;
                    break;
                }
                Iterable $this$map$iv8 = homeList;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv8, 10));
                while (r13.hasNext()) {
                    HomeRes it8 = (HomeRes) item$iv$iv;
                    destination$iv$iv.add(iStreamFlare.toSearchResult(it8));
                }
                return (List) destination$iv$iv;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:423:0x0bf9  */
    /* JADX WARN: Code duplicated, block: B:426:0x0c0f  */
    /* JADX WARN: Code duplicated, block: B:502:0x0df3  */
    /* JADX WARN: Code duplicated, block: B:504:0x0e09  */
    /* JADX WARN: Code duplicated, block: B:506:0x0e2a  */
    /* JADX WARN: Code duplicated, block: B:508:0x0e3d  */
    /* JADX WARN: Code duplicated, block: B:509:0x0e40  */
    /* JADX WARN: Code duplicated, block: B:510:0x0e64  */
    /* JADX WARN: Code duplicated, block: B:514:0x0e7b  */
    /* JADX WARN: Code duplicated, block: B:515:0x0e8e  */
    /* JADX WARN: Code duplicated, block: B:517:0x0e91  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Path cross not found for [B:646:0x0969, B:312:0x097e], limit reached: 609 */
    /* JADX WARN: Path cross not found for [B:652:0x073c, B:234:0x0751], limit reached: 609 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:440:0x0ce5 -> B:441:0x0cfd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:520:0x0ed4 -> B:521:0x0ee4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r50, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r51) {
        /*
            Method dump skipped, instruction units count: 4368
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

    /* JADX WARN: Code duplicated, block: B:104:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:105:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:114:0x02f5 A[Catch: Exception -> 0x0311, TryCatch #17 {Exception -> 0x0311, blocks: (B:95:0x02a0, B:102:0x02d1, B:106:0x02da, B:115:0x030e, B:114:0x02f5, B:113:0x02ef, B:101:0x02c6, B:94:0x0296, B:98:0x02a7, B:108:0x02e0), top: B:283:0x0296, inners: #14, #25 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0345 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:125:0x0346  */
    /* JADX WARN: Code duplicated, block: B:127:0x0353  */
    /* JADX WARN: Code duplicated, block: B:129:0x0361  */
    /* JADX WARN: Code duplicated, block: B:131:0x0376 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:132:0x0377  */
    /* JADX WARN: Code duplicated, block: B:154:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:164:0x040b A[Catch: Exception -> 0x0427, TryCatch #8 {Exception -> 0x0427, blocks: (B:145:0x03b8, B:152:0x03e9, B:155:0x03f0, B:165:0x0424, B:164:0x040b, B:163:0x0405, B:151:0x03de, B:144:0x03ae, B:158:0x03f6, B:148:0x03bf), top: B:272:0x03ae, inners: #9, #25, #24 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x045b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:175:0x045c  */
    /* JADX WARN: Code duplicated, block: B:177:0x0466  */
    /* JADX WARN: Code duplicated, block: B:179:0x0474  */
    /* JADX WARN: Code duplicated, block: B:181:0x0489 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:182:0x048a  */
    /* JADX WARN: Code duplicated, block: B:204:0x0502  */
    /* JADX WARN: Code duplicated, block: B:214:0x051e A[Catch: Exception -> 0x053a, TryCatch #24 {Exception -> 0x053a, blocks: (B:195:0x04cb, B:202:0x04fc, B:205:0x0503, B:215:0x0537, B:214:0x051e, B:213:0x0518, B:201:0x04f1, B:194:0x04c1, B:198:0x04d2, B:208:0x0509), top: B:293:0x04c1, inners: #6, #23 }] */
    /* JADX WARN: Code duplicated, block: B:224:0x056e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:225:0x056f  */
    /* JADX WARN: Code duplicated, block: B:227:0x0579  */
    /* JADX WARN: Code duplicated, block: B:229:0x0588  */
    /* JADX WARN: Code duplicated, block: B:231:0x05c1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:232:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:234:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:236:0x05de  */
    /* JADX WARN: Code duplicated, block: B:238:0x060c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:239:0x060d  */
    /* JADX WARN: Code duplicated, block: B:242:0x0616  */
    /* JADX WARN: Code duplicated, block: B:244:0x0640 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:246:0x0646  */
    /* JADX WARN: Code duplicated, block: B:248:0x064d  */
    /* JADX WARN: Code duplicated, block: B:250:0x0659  */
    /* JADX WARN: Code duplicated, block: B:252:0x0667  */
    /* JADX WARN: Code duplicated, block: B:253:0x066a  */
    /* JADX WARN: Code duplicated, block: B:256:0x06ad A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:257:0x06ae  */
    /* JADX WARN: Code duplicated, block: B:259:0x06bb  */
    /* JADX WARN: Code duplicated, block: B:270:0x04d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:276:0x0186 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:279:0x02a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:287:0x01b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:295:0x03bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:297:0x01eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:299:0x02e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:301:0x03f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:303:0x0509 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x0182  */
    /* JADX WARN: Code duplicated, block: B:47:0x01de A[Catch: Exception -> 0x0262, PHI: r0
      0x01de: PHI (r0v64 java.lang.Object) = (r0v57 java.lang.Object), (r0v60 java.lang.Object), (r0v63 java.lang.Object) binds: [B:41:0x01b4, B:46:0x01d3, B:43:0x01b7] A[DONT_GENERATE, DONT_INLINE], TryCatch #11 {Exception -> 0x0262, blocks: (B:34:0x0186, B:40:0x01b0, B:47:0x01de, B:50:0x01e5, B:60:0x0218, B:63:0x0222, B:65:0x0228, B:70:0x0234, B:72:0x023a, B:73:0x0247, B:75:0x024d, B:77:0x0257, B:59:0x0200, B:58:0x01fa, B:46:0x01d3, B:39:0x01a6, B:36:0x018d, B:43:0x01b7, B:53:0x01eb), top: B:276:0x0186, inners: #0, #20, #26 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:59:0x0200 A[Catch: Exception -> 0x0262, TryCatch #11 {Exception -> 0x0262, blocks: (B:34:0x0186, B:40:0x01b0, B:47:0x01de, B:50:0x01e5, B:60:0x0218, B:63:0x0222, B:65:0x0228, B:70:0x0234, B:72:0x023a, B:73:0x0247, B:75:0x024d, B:77:0x0257, B:59:0x0200, B:58:0x01fa, B:46:0x01d3, B:39:0x01a6, B:36:0x018d, B:43:0x01b7, B:53:0x01eb), top: B:276:0x0186, inners: #0, #20, #26 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0222 A[Catch: Exception -> 0x0262, TRY_ENTER, TryCatch #11 {Exception -> 0x0262, blocks: (B:34:0x0186, B:40:0x01b0, B:47:0x01de, B:50:0x01e5, B:60:0x0218, B:63:0x0222, B:65:0x0228, B:70:0x0234, B:72:0x023a, B:73:0x0247, B:75:0x024d, B:77:0x0257, B:59:0x0200, B:58:0x01fa, B:46:0x01d3, B:39:0x01a6, B:36:0x018d, B:43:0x01b7, B:53:0x01eb), top: B:276:0x0186, inners: #0, #20, #26 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0228 A[Catch: Exception -> 0x0262, TryCatch #11 {Exception -> 0x0262, blocks: (B:34:0x0186, B:40:0x01b0, B:47:0x01de, B:50:0x01e5, B:60:0x0218, B:63:0x0222, B:65:0x0228, B:70:0x0234, B:72:0x023a, B:73:0x0247, B:75:0x024d, B:77:0x0257, B:59:0x0200, B:58:0x01fa, B:46:0x01d3, B:39:0x01a6, B:36:0x018d, B:43:0x01b7, B:53:0x01eb), top: B:276:0x0186, inners: #0, #20, #26 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0231  */
    /* JADX WARN: Code duplicated, block: B:70:0x0234 A[Catch: Exception -> 0x0262, TryCatch #11 {Exception -> 0x0262, blocks: (B:34:0x0186, B:40:0x01b0, B:47:0x01de, B:50:0x01e5, B:60:0x0218, B:63:0x0222, B:65:0x0228, B:70:0x0234, B:72:0x023a, B:73:0x0247, B:75:0x024d, B:77:0x0257, B:59:0x0200, B:58:0x01fa, B:46:0x01d3, B:39:0x01a6, B:36:0x018d, B:43:0x01b7, B:53:0x01eb), top: B:276:0x0186, inners: #0, #20, #26 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0247 A[Catch: Exception -> 0x0262, TryCatch #11 {Exception -> 0x0262, blocks: (B:34:0x0186, B:40:0x01b0, B:47:0x01de, B:50:0x01e5, B:60:0x0218, B:63:0x0222, B:65:0x0228, B:70:0x0234, B:72:0x023a, B:73:0x0247, B:75:0x024d, B:77:0x0257, B:59:0x0200, B:58:0x01fa, B:46:0x01d3, B:39:0x01a6, B:36:0x018d, B:43:0x01b7, B:53:0x01eb), top: B:276:0x0186, inners: #0, #20, #26 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x024d A[Catch: Exception -> 0x0262, TryCatch #11 {Exception -> 0x0262, blocks: (B:34:0x0186, B:40:0x01b0, B:47:0x01de, B:50:0x01e5, B:60:0x0218, B:63:0x0222, B:65:0x0228, B:70:0x0234, B:72:0x023a, B:73:0x0247, B:75:0x024d, B:77:0x0257, B:59:0x0200, B:58:0x01fa, B:46:0x01d3, B:39:0x01a6, B:36:0x018d, B:43:0x01b7, B:53:0x01eb), top: B:276:0x0186, inners: #0, #20, #26 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0260  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00061 c00061;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        boolean isCasting2;
        String data2;
        String it;
        boolean z;
        String jsonString;
        String jsonString2;
        List listEmptyList;
        List links;
        Function1<? super ExtractorLink, Unit> function5;
        boolean isCasting3;
        String data3;
        Function1<? super SubtitleFile, Unit> function6;
        String value$iv;
        Object obj;
        Object obj2;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        String value$iv2;
        Object obj3;
        DeserializationStrategy deserializationStrategy2;
        Object objDecodeFromString2;
        JsonNode root;
        JsonNode jsonNode;
        boolean z2;
        final Function1<? super ExtractorLink, Unit> function7;
        String data4;
        Function1<? super SubtitleFile, Unit> function8;
        boolean z3;
        ExtractorLinkType infer_type;
        Object objNewExtractorLink;
        Function1<? super ExtractorLink, Unit> function9;
        Function1<? super ExtractorLink, Unit> function10;
        String data5;
        Function1<? super SubtitleFile, Unit> function11;
        Istreamcdn extractor;
        final Ref.BooleanRef linkFound;
        Function1<? super ExtractorLink, Unit> function12;
        Function1<? super SubtitleFile, Unit> function13;
        Ref.BooleanRef linkFound2;
        Function1<? super ExtractorLink, Unit> function14;
        String data6;
        Function1<? super SubtitleFile, Unit> function15;
        boolean isCasting4;
        Function1<? super ExtractorLink, Unit> function16;
        String data7;
        Object objNewExtractorLink2;
        Function1<? super ExtractorLink, Unit> function17;
        Function1<? super ExtractorLink, Unit> function18;
        Function1<? super SubtitleFile, Unit> function19;
        Object decodedJson;
        Function1<? super ExtractorLink, Unit> function20;
        String data8;
        Function1<? super SubtitleFile, Unit> function21;
        Object decodedJson2;
        Function1<? super ExtractorLink, Unit> function22;
        String data9;
        Function1<? super SubtitleFile, Unit> function23;
        String decodedJson3;
        String decodedJson4;
        List listEmptyList2;
        List links2;
        boolean isCasting5;
        Object obj4;
        DeserializationStrategy deserializationStrategy3;
        Object objDecodeFromString3;
        String decodedJson5;
        String decodedJson6;
        List listEmptyList3;
        List links3;
        boolean isCasting6;
        Object obj5;
        DeserializationStrategy deserializationStrategy4;
        Object objDecodeFromString4;
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
                c00062.L$0 = data;
                c00062.L$1 = function1;
                c00062.L$2 = function2;
                c00062.Z$0 = isCasting;
                c00062.label = 1;
                if (syncConfig$default(this, false, c00062, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function3 = function1;
                function4 = function2;
                isCasting2 = isCasting;
                data2 = data;
                it = StringsKt.trim(data2).toString();
                if (!StringsKt.startsWith$default(it, "{", false, 2, (Object) null) || StringsKt.startsWith$default(it, "[", false, 2, (Object) null)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    try {
                        AppUtils appUtils = AppUtils.INSTANCE;
                        value$iv2 = data2;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(JsonNode.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj3) == null) {
                            if (Result.isFailure-impl(obj3)) {
                                obj3 = null;
                            }
                            deserializationStrategy2 = (KSerializer) obj3;
                            if (deserializationStrategy2 != null) {
                                try {
                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                } catch (SerializationException e) {
                                    ArchComponentExtKt.logError(e);
                                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                    objDecodeFromString2 = $this$readValue$iv$iv.readValue(value$iv2, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$1
                                    });
                                } catch (Throwable th2) {
                                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                    objDecodeFromString2 = $this$readValue$iv$iv2.readValue(value$iv2, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$1
                                    });
                                }
                            } else {
                                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv3.readValue(value$iv2, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$1
                                });
                            }
                            root = (JsonNode) objDecodeFromString2;
                            if (!root.has("encrypted")) {
                                jsonNode = root.get("encrypted");
                                if (jsonNode == null && jsonNode.asBoolean()) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (!z2 && root.has("data")) {
                                    jsonString = IStreamFlareParserKt.decryptPayload(root.get("data").asText());
                                } else if (root.has("data")) {
                                    jsonString = data2;
                                } else {
                                    jsonString = data2;
                                }
                            } else if (root.has("data") || !root.get("data").isTextual()) {
                                jsonString = data2;
                            } else {
                                jsonString = root.get("data").asText();
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
                            deserializationStrategy2 = (KSerializer) obj3;
                            if (deserializationStrategy2 != null) {
                                objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                            } else {
                                ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv4.readValue(value$iv2, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$1
                                });
                            }
                            root = (JsonNode) objDecodeFromString2;
                            if (!root.has("encrypted")) {
                                jsonNode = root.get("encrypted");
                                if (jsonNode == null) {
                                    z2 = false;
                                } else {
                                    z2 = false;
                                }
                                if (!z2) {
                                    if (root.has("data")) {
                                        jsonString = data2;
                                    } else {
                                        jsonString = data2;
                                    }
                                } else if (root.has("data")) {
                                    jsonString = data2;
                                } else {
                                    jsonString = data2;
                                }
                            } else if (root.has("data")) {
                                jsonString = data2;
                            } else {
                                jsonString = data2;
                            }
                        }
                    } catch (Exception e2) {
                        jsonString = data2;
                    }
                    try {
                        AppUtils appUtils2 = AppUtils.INSTANCE;
                        value$iv = jsonString;
                        try {
                            Result.Companion companion5 = Result.Companion;
                            jsonString2 = jsonString;
                            try {
                                KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamLinks.class)));
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                break;
                            } catch (Throwable th4) {
                                th = th4;
                                try {
                                    Result.Companion companion6 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Exception e3) {
                                    listEmptyList = CollectionsKt.emptyList();
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            jsonString2 = jsonString;
                        }
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            try {
                                Result.Companion companion7 = Result.Companion;
                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            } catch (Throwable th6) {
                                Result.Companion companion8 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th6));
                            }
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj2 = null;
                        } else {
                            obj2 = obj;
                        }
                        deserializationStrategy = (KSerializer) obj2;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                            } catch (SerializationException e4) {
                                ArchComponentExtKt.logError(e4);
                                ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv5.readValue(value$iv, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$2
                                });
                            } catch (Throwable th7) {
                                ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv6.readValue(value$iv, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$2
                                });
                            }
                            listEmptyList = (List) objDecodeFromString;
                            links = listEmptyList;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(jsonString2);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(links);
                            c00062.Z$0 = isCasting2;
                            c00062.label = 2;
                            if (loadLinks$processLinks(function4, this, function3, links, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function5 = function4;
                            isCasting3 = isCasting2;
                            data3 = data2;
                            function6 = function3;
                            z3 = true;
                        } else {
                            ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv7.readValue(value$iv, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$2
                            });
                            listEmptyList = (List) objDecodeFromString;
                            links = listEmptyList;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(jsonString2);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(links);
                            c00062.Z$0 = isCasting2;
                            c00062.label = 2;
                            if (loadLinks$processLinks(function4, this, function3, links, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function5 = function4;
                            isCasting3 = isCasting2;
                            data3 = data2;
                            function6 = function3;
                            z3 = true;
                        }
                    } catch (Exception e5) {
                        jsonString2 = jsonString;
                    }
                    break;
                } else if (StringsKt.contains(data2, "getMoviePlayLinks", true)) {
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00062.L$1 = function3;
                    c00062.L$2 = function4;
                    c00062.Z$0 = isCasting2;
                    c00062.label = 3;
                    decodedJson2 = getDecodedJson(data2, c00062);
                    if (decodedJson2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function22 = function4;
                    data9 = data2;
                    function23 = function3;
                    decodedJson3 = (String) decodedJson2;
                    try {
                        AppUtils appUtils3 = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion9 = Result.Companion;
                            decodedJson4 = decodedJson3;
                            try {
                                KType kTypeTypeOf3 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamLinks.class)));
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                break;
                            } catch (Throwable th8) {
                                th = th8;
                                try {
                                    Result.Companion companion10 = Result.Companion;
                                    obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Exception e6) {
                                    listEmptyList2 = CollectionsKt.emptyList();
                                }
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            decodedJson4 = decodedJson3;
                        }
                        if (Result.exceptionOrNull-impl(obj4) != null) {
                            try {
                                Result.Companion companion11 = Result.Companion;
                                obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            } catch (Throwable th10) {
                                Result.Companion companion12 = Result.Companion;
                                obj4 = Result.constructor-impl(ResultKt.createFailure(th10));
                            }
                        }
                        if (Result.isFailure-impl(obj4)) {
                            obj4 = null;
                        }
                        deserializationStrategy3 = (KSerializer) obj4;
                        if (deserializationStrategy3 != null) {
                            try {
                                objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, decodedJson3);
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
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data9);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function23);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function22);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson4);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(links2);
                            c00062.Z$0 = isCasting2;
                            c00062.label = 4;
                            if (loadLinks$processLinks(function22, this, function23, links2, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            isCasting5 = isCasting2;
                            z3 = true;
                        } else {
                            ObjectMapper $this$readValue$iv$iv10 = MainAPIKt.getMapper();
                            objDecodeFromString3 = $this$readValue$iv$iv10.readValue(decodedJson3, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$3
                            });
                            listEmptyList2 = (List) objDecodeFromString3;
                            links2 = listEmptyList2;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data9);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function23);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function22);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson4);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(links2);
                            c00062.Z$0 = isCasting2;
                            c00062.label = 4;
                            if (loadLinks$processLinks(function22, this, function23, links2, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            isCasting5 = isCasting2;
                            z3 = true;
                        }
                    } catch (Exception e8) {
                        decodedJson4 = decodedJson3;
                    }
                    break;
                } else if (StringsKt.contains(data2, "getEpisodePlayLinks", true)) {
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00062.L$1 = function3;
                    c00062.L$2 = function4;
                    c00062.Z$0 = isCasting2;
                    c00062.label = 5;
                    decodedJson = getDecodedJson(data2, c00062);
                    if (decodedJson == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function20 = function4;
                    data8 = data2;
                    function21 = function3;
                    decodedJson5 = (String) decodedJson;
                    try {
                        AppUtils appUtils4 = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion13 = Result.Companion;
                            decodedJson6 = decodedJson5;
                            try {
                                KType kTypeTypeOf4 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamLinks.class)));
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                                break;
                            } catch (Throwable th12) {
                                th = th12;
                                try {
                                    Result.Companion companion14 = Result.Companion;
                                    obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Exception e9) {
                                    listEmptyList3 = CollectionsKt.emptyList();
                                }
                            }
                        } catch (Throwable th13) {
                            th = th13;
                            decodedJson6 = decodedJson5;
                        }
                        if (Result.exceptionOrNull-impl(obj5) != null) {
                            try {
                                Result.Companion companion15 = Result.Companion;
                                obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            } catch (Throwable th14) {
                                Result.Companion companion16 = Result.Companion;
                                obj5 = Result.constructor-impl(ResultKt.createFailure(th14));
                            }
                        }
                        if (Result.isFailure-impl(obj5)) {
                            obj5 = null;
                        }
                        deserializationStrategy4 = (KSerializer) obj5;
                        if (deserializationStrategy4 != null) {
                            try {
                                objDecodeFromString4 = MainAPIKt.getJson().decodeFromString(deserializationStrategy4, decodedJson5);
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
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data8);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function21);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function20);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson6);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(links3);
                            c00062.Z$0 = isCasting2;
                            c00062.label = 6;
                            if (loadLinks$processLinks(function20, this, function21, links3, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            isCasting6 = isCasting2;
                            z3 = true;
                        } else {
                            ObjectMapper $this$readValue$iv$iv13 = MainAPIKt.getMapper();
                            objDecodeFromString4 = $this$readValue$iv$iv13.readValue(decodedJson5, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$4
                            });
                            listEmptyList3 = (List) objDecodeFromString4;
                            links3 = listEmptyList3;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data8);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function21);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function20);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson6);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(links3);
                            c00062.Z$0 = isCasting2;
                            c00062.label = 6;
                            if (loadLinks$processLinks(function20, this, function21, links3, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            isCasting6 = isCasting2;
                            z3 = true;
                        }
                    } catch (Exception e11) {
                        decodedJson6 = decodedJson5;
                    }
                    break;
                } else if (StringsKt.contains(data2, "x7flix", true)) {
                    String name = getName();
                    String name2 = getName();
                    ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                    C00073 c00073 = new C00073(data2, null);
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                    c00062.L$3 = function4;
                    c00062.Z$0 = isCasting2;
                    c00062.label = 7;
                    function16 = function4;
                    data7 = data2;
                    objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name2, name, data7, extractorLinkType, c00073, c00062);
                    if (objNewExtractorLink2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function17 = function16;
                    function18 = function17;
                    function19 = function3;
                    function17.invoke(objNewExtractorLink2);
                    z3 = true;
                } else {
                    function7 = function4;
                    data4 = data2;
                    if (StringsKt.contains(data4, ".php?id=", true)) {
                        extractor = new Istreamcdn();
                        linkFound = new Ref.BooleanRef();
                        function12 = new Function1() { // from class: com.IStreamFlare.IStreamFlare$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj6) {
                                return IStreamFlare.loadLinks$lambda$2(linkFound, function7, (ExtractorLink) obj6);
                            }
                        };
                        c00062.L$0 = data4;
                        c00062.L$1 = function3;
                        c00062.L$2 = function7;
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(extractor);
                        c00062.L$4 = linkFound;
                        c00062.Z$0 = isCasting2;
                        c00062.label = 8;
                        function13 = function3;
                        if (extractor.getUrl(data4, null, function13, function12, c00062) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        linkFound2 = linkFound;
                        function14 = function7;
                        data6 = data4;
                        function15 = function13;
                        isCasting4 = isCasting2;
                        if (!linkFound2.element) {
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function15);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function14);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(extractor);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(linkFound2);
                            c00062.Z$0 = isCasting4;
                            c00062.label = 9;
                            if (ExtractorApiKt.loadExtractor(data6, function15, function14, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        z3 = true;
                    } else {
                        function8 = function3;
                        if (StringsKt.startsWith$default(data4, "http", false, 2, (Object) null)) {
                            if (StringsKt.contains(data4, ".m3u8", true)) {
                                infer_type = ExtractorLinkType.M3U8;
                            } else {
                                infer_type = ExtractorApiKt.getINFER_TYPE();
                            }
                            ExtractorLinkType type = infer_type;
                            String name3 = getName();
                            String name4 = getName();
                            C00085 c00085 = new C00085(null);
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(type);
                            c00062.L$4 = function7;
                            c00062.Z$0 = isCasting2;
                            c00062.label = 10;
                            objNewExtractorLink = ExtractorApiKt.newExtractorLink(name4, name3, data4, type, c00085, c00062);
                            if (objNewExtractorLink == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function9 = function7;
                            function10 = function9;
                            data5 = data4;
                            function11 = function8;
                            function9.invoke(objNewExtractorLink);
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    }
                }
                return Boxing.boxBoolean(z3);
            case 1:
                boolean isCasting7 = c00062.Z$0;
                function4 = (Function1) c00062.L$2;
                Function1<? super SubtitleFile, Unit> function24 = (Function1) c00062.L$1;
                data2 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                function3 = function24;
                isCasting2 = isCasting7;
                it = StringsKt.trim(data2).toString();
                if (StringsKt.startsWith$default(it, "{", false, 2, (Object) null)) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    AppUtils appUtils5 = AppUtils.INSTANCE;
                    value$iv2 = data2;
                    Result.Companion companion17 = Result.Companion;
                    KType kTypeTypeOf5 = Reflection.typeOf(JsonNode.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                    if (Result.exceptionOrNull-impl(obj3) == null) {
                        if (Result.isFailure-impl(obj3)) {
                            obj3 = null;
                        }
                        deserializationStrategy2 = (KSerializer) obj3;
                        if (deserializationStrategy2 != null) {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                        } else {
                            ObjectMapper $this$readValue$iv$iv14 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv14.readValue(value$iv2, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$1
                            });
                        }
                        root = (JsonNode) objDecodeFromString2;
                        if (!root.has("encrypted")) {
                            jsonNode = root.get("encrypted");
                            if (jsonNode == null) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                if (root.has("data")) {
                                    jsonString = data2;
                                } else {
                                    jsonString = data2;
                                }
                            } else if (root.has("data")) {
                                jsonString = data2;
                            } else {
                                jsonString = data2;
                            }
                        } else if (root.has("data")) {
                            jsonString = data2;
                        } else {
                            jsonString = data2;
                        }
                    } else {
                        Result.Companion companion18 = Result.Companion;
                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, 2, (Object) null));
                        if (Result.isFailure-impl(obj3)) {
                            obj3 = null;
                        }
                        deserializationStrategy2 = (KSerializer) obj3;
                        if (deserializationStrategy2 != null) {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                        } else {
                            ObjectMapper $this$readValue$iv$iv15 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv15.readValue(value$iv2, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$1
                            });
                        }
                        root = (JsonNode) objDecodeFromString2;
                        if (!root.has("encrypted")) {
                            jsonNode = root.get("encrypted");
                            if (jsonNode == null) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                if (root.has("data")) {
                                    jsonString = data2;
                                } else {
                                    jsonString = data2;
                                }
                            } else if (root.has("data")) {
                                jsonString = data2;
                            } else {
                                jsonString = data2;
                            }
                        } else if (root.has("data")) {
                            jsonString = data2;
                        } else {
                            jsonString = data2;
                        }
                    }
                    AppUtils appUtils6 = AppUtils.INSTANCE;
                    value$iv = jsonString;
                    Result.Companion companion19 = Result.Companion;
                    jsonString2 = jsonString;
                    KType kTypeTypeOf6 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamLinks.class)));
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                    if (Result.exceptionOrNull-impl(obj) != null) {
                        Result.Companion companion20 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                    }
                    if (Result.isFailure-impl(obj)) {
                        obj2 = null;
                    } else {
                        obj2 = obj;
                    }
                    deserializationStrategy = (KSerializer) obj2;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                        listEmptyList = (List) objDecodeFromString;
                        links = listEmptyList;
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(jsonString2);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(links);
                        c00062.Z$0 = isCasting2;
                        c00062.label = 2;
                        if (loadLinks$processLinks(function4, this, function3, links, c00062) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function5 = function4;
                        isCasting3 = isCasting2;
                        data3 = data2;
                        function6 = function3;
                        z3 = true;
                    } else {
                        ObjectMapper $this$readValue$iv$iv16 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv16.readValue(value$iv, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$2
                        });
                        listEmptyList = (List) objDecodeFromString;
                        links = listEmptyList;
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(jsonString2);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(links);
                        c00062.Z$0 = isCasting2;
                        c00062.label = 2;
                        if (loadLinks$processLinks(function4, this, function3, links, c00062) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function5 = function4;
                        isCasting3 = isCasting2;
                        data3 = data2;
                        function6 = function3;
                        z3 = true;
                    }
                    break;
                } else if (StringsKt.contains(data2, "getMoviePlayLinks", true)) {
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00062.L$1 = function3;
                    c00062.L$2 = function4;
                    c00062.Z$0 = isCasting2;
                    c00062.label = 3;
                    decodedJson2 = getDecodedJson(data2, c00062);
                    if (decodedJson2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function22 = function4;
                    data9 = data2;
                    function23 = function3;
                    decodedJson3 = (String) decodedJson2;
                    AppUtils appUtils7 = AppUtils.INSTANCE;
                    Result.Companion companion21 = Result.Companion;
                    decodedJson4 = decodedJson3;
                    KType kTypeTypeOf7 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamLinks.class)));
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf7));
                    if (Result.exceptionOrNull-impl(obj4) != null) {
                        Result.Companion companion110 = Result.Companion;
                        obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                    }
                    if (Result.isFailure-impl(obj4)) {
                        obj4 = null;
                    }
                    deserializationStrategy3 = (KSerializer) obj4;
                    if (deserializationStrategy3 != null) {
                        objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, decodedJson3);
                        listEmptyList2 = (List) objDecodeFromString3;
                        links2 = listEmptyList2;
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data9);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function23);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function22);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson4);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(links2);
                        c00062.Z$0 = isCasting2;
                        c00062.label = 4;
                        if (loadLinks$processLinks(function22, this, function23, links2, c00062) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        isCasting5 = isCasting2;
                        z3 = true;
                    } else {
                        ObjectMapper $this$readValue$iv$iv17 = MainAPIKt.getMapper();
                        objDecodeFromString3 = $this$readValue$iv$iv17.readValue(decodedJson3, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$3
                        });
                        listEmptyList2 = (List) objDecodeFromString3;
                        links2 = listEmptyList2;
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data9);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function23);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function22);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson4);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(links2);
                        c00062.Z$0 = isCasting2;
                        c00062.label = 4;
                        if (loadLinks$processLinks(function22, this, function23, links2, c00062) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        isCasting5 = isCasting2;
                        z3 = true;
                    }
                    break;
                } else if (StringsKt.contains(data2, "getEpisodePlayLinks", true)) {
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00062.L$1 = function3;
                    c00062.L$2 = function4;
                    c00062.Z$0 = isCasting2;
                    c00062.label = 5;
                    decodedJson = getDecodedJson(data2, c00062);
                    if (decodedJson == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function20 = function4;
                    data8 = data2;
                    function21 = function3;
                    decodedJson5 = (String) decodedJson;
                    AppUtils appUtils8 = AppUtils.INSTANCE;
                    Result.Companion companion111 = Result.Companion;
                    decodedJson6 = decodedJson5;
                    KType kTypeTypeOf8 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamLinks.class)));
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf8));
                    if (Result.exceptionOrNull-impl(obj5) != null) {
                        Result.Companion companion112 = Result.Companion;
                        obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                    }
                    if (Result.isFailure-impl(obj5)) {
                        obj5 = null;
                    }
                    deserializationStrategy4 = (KSerializer) obj5;
                    if (deserializationStrategy4 != null) {
                        objDecodeFromString4 = MainAPIKt.getJson().decodeFromString(deserializationStrategy4, decodedJson5);
                        listEmptyList3 = (List) objDecodeFromString4;
                        links3 = listEmptyList3;
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data8);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function21);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function20);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson6);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(links3);
                        c00062.Z$0 = isCasting2;
                        c00062.label = 6;
                        if (loadLinks$processLinks(function20, this, function21, links3, c00062) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        isCasting6 = isCasting2;
                        z3 = true;
                    } else {
                        ObjectMapper $this$readValue$iv$iv18 = MainAPIKt.getMapper();
                        objDecodeFromString4 = $this$readValue$iv$iv18.readValue(decodedJson5, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$4
                        });
                        listEmptyList3 = (List) objDecodeFromString4;
                        links3 = listEmptyList3;
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data8);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function21);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function20);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson6);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(links3);
                        c00062.Z$0 = isCasting2;
                        c00062.label = 6;
                        if (loadLinks$processLinks(function20, this, function21, links3, c00062) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        isCasting6 = isCasting2;
                        z3 = true;
                    }
                    break;
                } else if (StringsKt.contains(data2, "x7flix", true)) {
                    String name5 = getName();
                    String name6 = getName();
                    ExtractorLinkType extractorLinkType2 = ExtractorLinkType.M3U8;
                    C00073 c00074 = new C00073(data2, null);
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                    c00062.L$3 = function4;
                    c00062.Z$0 = isCasting2;
                    c00062.label = 7;
                    function16 = function4;
                    data7 = data2;
                    objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name6, name5, data7, extractorLinkType2, c00074, c00062);
                    if (objNewExtractorLink2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function17 = function16;
                    function18 = function17;
                    function19 = function3;
                    function17.invoke(objNewExtractorLink2);
                    z3 = true;
                } else {
                    function7 = function4;
                    data4 = data2;
                    if (StringsKt.contains(data4, ".php?id=", true)) {
                        extractor = new Istreamcdn();
                        linkFound = new Ref.BooleanRef();
                        function12 = new Function1() { // from class: com.IStreamFlare.IStreamFlare$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj6) {
                                return IStreamFlare.loadLinks$lambda$2(linkFound, function7, (ExtractorLink) obj6);
                            }
                        };
                        c00062.L$0 = data4;
                        c00062.L$1 = function3;
                        c00062.L$2 = function7;
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(extractor);
                        c00062.L$4 = linkFound;
                        c00062.Z$0 = isCasting2;
                        c00062.label = 8;
                        function13 = function3;
                        if (extractor.getUrl(data4, null, function13, function12, c00062) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        linkFound2 = linkFound;
                        function14 = function7;
                        data6 = data4;
                        function15 = function13;
                        isCasting4 = isCasting2;
                        if (!linkFound2.element) {
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function15);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function14);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(extractor);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(linkFound2);
                            c00062.Z$0 = isCasting4;
                            c00062.label = 9;
                            if (ExtractorApiKt.loadExtractor(data6, function15, function14, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        z3 = true;
                    } else {
                        function8 = function3;
                        if (StringsKt.startsWith$default(data4, "http", false, 2, (Object) null)) {
                            if (StringsKt.contains(data4, ".m3u8", true)) {
                                infer_type = ExtractorLinkType.M3U8;
                            } else {
                                infer_type = ExtractorApiKt.getINFER_TYPE();
                            }
                            ExtractorLinkType type2 = infer_type;
                            String name7 = getName();
                            String name8 = getName();
                            C00085 c00086 = new C00085(null);
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(type2);
                            c00062.L$4 = function7;
                            c00062.Z$0 = isCasting2;
                            c00062.label = 10;
                            objNewExtractorLink = ExtractorApiKt.newExtractorLink(name8, name7, data4, type2, c00086, c00062);
                            if (objNewExtractorLink == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function9 = function7;
                            function10 = function9;
                            data5 = data4;
                            function11 = function8;
                            function9.invoke(objNewExtractorLink);
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    }
                }
                return Boxing.boxBoolean(z3);
            case 2:
                isCasting3 = c00062.Z$0;
                function5 = (Function1) c00062.L$2;
                function6 = (Function1) c00062.L$1;
                data3 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                z3 = true;
                return Boxing.boxBoolean(z3);
            case 3:
                boolean isCasting8 = c00062.Z$0;
                Function1<? super ExtractorLink, Unit> function25 = (Function1) c00062.L$2;
                function23 = (Function1) c00062.L$1;
                String data10 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                isCasting2 = isCasting8;
                function22 = function25;
                data9 = data10;
                decodedJson2 = $result;
                decodedJson3 = (String) decodedJson2;
                AppUtils appUtils9 = AppUtils.INSTANCE;
                Result.Companion companion22 = Result.Companion;
                decodedJson4 = decodedJson3;
                KType kTypeTypeOf9 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamLinks.class)));
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf9));
                if (Result.exceptionOrNull-impl(obj4) != null) {
                    Result.Companion companion113 = Result.Companion;
                    obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                    break;
                }
                if (Result.isFailure-impl(obj4)) {
                    obj4 = null;
                }
                deserializationStrategy3 = (KSerializer) obj4;
                if (deserializationStrategy3 != null) {
                    objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, decodedJson3);
                    listEmptyList2 = (List) objDecodeFromString3;
                    links2 = listEmptyList2;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data9);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function23);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function22);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson4);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(links2);
                    c00062.Z$0 = isCasting2;
                    c00062.label = 4;
                    if (loadLinks$processLinks(function22, this, function23, links2, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isCasting5 = isCasting2;
                    z3 = true;
                } else {
                    ObjectMapper $this$readValue$iv$iv19 = MainAPIKt.getMapper();
                    objDecodeFromString3 = $this$readValue$iv$iv19.readValue(decodedJson3, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$3
                    });
                    listEmptyList2 = (List) objDecodeFromString3;
                    links2 = listEmptyList2;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data9);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function23);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function22);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson4);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(links2);
                    c00062.Z$0 = isCasting2;
                    c00062.label = 4;
                    if (loadLinks$processLinks(function22, this, function23, links2, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isCasting5 = isCasting2;
                    z3 = true;
                }
                return Boxing.boxBoolean(z3);
            case 4:
                isCasting5 = c00062.Z$0;
                function22 = (Function1) c00062.L$2;
                function23 = (Function1) c00062.L$1;
                data9 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                z3 = true;
                return Boxing.boxBoolean(z3);
            case 5:
                boolean isCasting9 = c00062.Z$0;
                Function1<? super ExtractorLink, Unit> function26 = (Function1) c00062.L$2;
                function21 = (Function1) c00062.L$1;
                String data11 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                isCasting2 = isCasting9;
                function20 = function26;
                data8 = data11;
                decodedJson = $result;
                decodedJson5 = (String) decodedJson;
                AppUtils appUtils10 = AppUtils.INSTANCE;
                Result.Companion companion114 = Result.Companion;
                decodedJson6 = decodedJson5;
                KType kTypeTypeOf10 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(StreamLinks.class)));
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf10));
                if (Result.exceptionOrNull-impl(obj5) != null) {
                    Result.Companion companion115 = Result.Companion;
                    obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                    break;
                }
                if (Result.isFailure-impl(obj5)) {
                    obj5 = null;
                }
                deserializationStrategy4 = (KSerializer) obj5;
                if (deserializationStrategy4 != null) {
                    objDecodeFromString4 = MainAPIKt.getJson().decodeFromString(deserializationStrategy4, decodedJson5);
                    listEmptyList3 = (List) objDecodeFromString4;
                    links3 = listEmptyList3;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data8);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function21);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function20);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson6);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(links3);
                    c00062.Z$0 = isCasting2;
                    c00062.label = 6;
                    if (loadLinks$processLinks(function20, this, function21, links3, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isCasting6 = isCasting2;
                    z3 = true;
                } else {
                    ObjectMapper $this$readValue$iv$iv110 = MainAPIKt.getMapper();
                    objDecodeFromString4 = $this$readValue$iv$iv110.readValue(decodedJson5, new TypeReference<List<? extends StreamLinks>>() { // from class: com.IStreamFlare.IStreamFlare$loadLinks$$inlined$parseJson$4
                    });
                    listEmptyList3 = (List) objDecodeFromString4;
                    links3 = listEmptyList3;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data8);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function21);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function20);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(decodedJson6);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(links3);
                    c00062.Z$0 = isCasting2;
                    c00062.label = 6;
                    if (loadLinks$processLinks(function20, this, function21, links3, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isCasting6 = isCasting2;
                    z3 = true;
                }
                return Boxing.boxBoolean(z3);
            case 6:
                isCasting6 = c00062.Z$0;
                function20 = (Function1) c00062.L$2;
                function21 = (Function1) c00062.L$1;
                data8 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                z3 = true;
                return Boxing.boxBoolean(z3);
            case 7:
                boolean isCasting10 = c00062.Z$0;
                function17 = (Function1) c00062.L$3;
                function18 = (Function1) c00062.L$2;
                function19 = (Function1) c00062.L$1;
                data7 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink2 = $result;
                function17.invoke(objNewExtractorLink2);
                z3 = true;
                return Boxing.boxBoolean(z3);
            case 8:
                isCasting4 = c00062.Z$0;
                linkFound2 = (Ref.BooleanRef) c00062.L$4;
                extractor = (Istreamcdn) c00062.L$3;
                function14 = (Function1) c00062.L$2;
                function15 = (Function1) c00062.L$1;
                data6 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                if (!linkFound2.element) {
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function15);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function14);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(extractor);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(linkFound2);
                    c00062.Z$0 = isCasting4;
                    c00062.label = 9;
                    if (ExtractorApiKt.loadExtractor(data6, function15, function14, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                z3 = true;
                return Boxing.boxBoolean(z3);
            case 9:
                isCasting4 = c00062.Z$0;
                function14 = (Function1) c00062.L$2;
                function15 = (Function1) c00062.L$1;
                data6 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                z3 = true;
                return Boxing.boxBoolean(z3);
            case 10:
                boolean z4 = c00062.Z$0;
                function9 = (Function1) c00062.L$4;
                function10 = (Function1) c00062.L$2;
                function11 = (Function1) c00062.L$1;
                data5 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function9.invoke(objNewExtractorLink);
                z3 = true;
                return Boxing.boxBoolean(z3);
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
    /* JADX WARN: Code duplicated, block: B:104:0x01bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x01f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ff A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x0100  */
    /* JADX WARN: Code duplicated, block: B:41:0x0111  */
    /* JADX WARN: Code duplicated, block: B:42:0x012f  */
    /* JADX WARN: Code duplicated, block: B:45:0x017e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x017f  */
    /* JADX WARN: Code duplicated, block: B:57:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:70:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:79:0x0208 A[Catch: Exception -> 0x024c, TryCatch #3 {Exception -> 0x024c, blocks: (B:49:0x018c, B:55:0x01b4, B:67:0x01e5, B:71:0x01ed, B:80:0x021d, B:82:0x0229, B:87:0x0235, B:89:0x023d, B:79:0x0208, B:78:0x0202, B:66:0x01db, B:54:0x01aa, B:51:0x0191, B:73:0x01f3), top: B:100:0x018c, inners: #6, #10 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:82:0x0229 A[Catch: Exception -> 0x024c, TryCatch #3 {Exception -> 0x024c, blocks: (B:49:0x018c, B:55:0x01b4, B:67:0x01e5, B:71:0x01ed, B:80:0x021d, B:82:0x0229, B:87:0x0235, B:89:0x023d, B:79:0x0208, B:78:0x0202, B:66:0x01db, B:54:0x01aa, B:51:0x0191, B:73:0x01f3), top: B:100:0x018c, inners: #6, #10 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0232  */
    /* JADX WARN: Code duplicated, block: B:87:0x0235 A[Catch: Exception -> 0x024c, TryCatch #3 {Exception -> 0x024c, blocks: (B:49:0x018c, B:55:0x01b4, B:67:0x01e5, B:71:0x01ed, B:80:0x021d, B:82:0x0229, B:87:0x0235, B:89:0x023d, B:79:0x0208, B:78:0x0202, B:66:0x01db, B:54:0x01aa, B:51:0x0191, B:73:0x01f3), top: B:100:0x018c, inners: #6, #10 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x023d A[Catch: Exception -> 0x024c, TRY_LEAVE, TryCatch #3 {Exception -> 0x024c, blocks: (B:49:0x018c, B:55:0x01b4, B:67:0x01e5, B:71:0x01ed, B:80:0x021d, B:82:0x0229, B:87:0x0235, B:89:0x023d, B:79:0x0208, B:78:0x0202, B:66:0x01db, B:54:0x01aa, B:51:0x0191, B:73:0x01f3), top: B:100:0x018c, inners: #6, #10 }] */
    public final Object getDecodedJson(String url, Continuation<? super String> continuation) {
        C00001 c00001;
        String str;
        Object obj;
        int i;
        String url2;
        String url3;
        String retryUrl;
        String retryUrl2;
        Object obj2;
        String response;
        Object obj3;
        Object obj4;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        JsonNode root;
        JsonNode jsonNode;
        boolean z;
        String str2;
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
                try {
                    Requests app = MainActivityKt.getApp();
                    Map<String, String> headers = INSTANCE.getHeaders();
                    c00002.L$0 = url;
                    c00002.label = 1;
                    str = "data";
                    obj = coroutine_suspended;
                    i = 2;
                    try {
                        Object obj5 = Requests.get$default(app, url, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4092, (Object) null);
                        c00002 = c00002;
                        if (obj5 == obj) {
                            return obj;
                        }
                        url2 = url;
                        $result = obj5;
                        try {
                            retryUrl = ((NiceResponse) $result).getTextLarge();
                        } catch (Exception e) {
                            e = e;
                            c00002.L$0 = url2;
                            c00002.L$1 = SpillingKt.nullOutSpilledVariable(e);
                            c00002.label = i;
                            if (syncConfig(true, c00002) == obj) {
                                return obj;
                            }
                            url3 = url2;
                            if (StringsKt.contains$default(url3, "/android/", false, i, (Object) null)) {
                                retryUrl2 = getMainUrl() + "/android/" + StringsKt.substringAfter$default(url3, "/android/", (String) null, i, (Object) null);
                            } else {
                                retryUrl2 = url3;
                            }
                            Requests app2 = MainActivityKt.getApp();
                            Map<String, String> headers2 = INSTANCE.getHeaders();
                            c00002.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00002.L$1 = SpillingKt.nullOutSpilledVariable(e);
                            c00002.L$2 = SpillingKt.nullOutSpilledVariable(retryUrl2);
                            c00002.label = 3;
                            obj2 = Requests.get$default(app2, retryUrl2, headers2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4092, (Object) null);
                            if (obj2 == obj) {
                                return obj;
                            }
                            $result = obj2;
                            retryUrl = ((NiceResponse) $result).getTextLarge();
                        }
                        response = retryUrl;
                        try {
                            AppUtils appUtils = AppUtils.INSTANCE;
                            try {
                                Result.Companion companion = Result.Companion;
                                KType kTypeTypeOf = Reflection.typeOf(JsonNode.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                break;
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            if (Result.exceptionOrNull-impl(obj3) == null) {
                                try {
                                    Result.Companion companion3 = Result.Companion;
                                    obj4 = null;
                                    try {
                                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, i, (Object) null));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        Result.Companion companion4 = Result.Companion;
                                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj4 = null;
                                }
                                break;
                            } else {
                                obj4 = null;
                            }
                            if (Result.isFailure-impl(obj3)) {
                                obj4 = obj3;
                            }
                            deserializationStrategy = (KSerializer) obj4;
                            if (deserializationStrategy != null) {
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, response);
                                } catch (SerializationException e2) {
                                    ArchComponentExtKt.logError(e2);
                                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv.readValue(response, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$getDecodedJson$$inlined$parseJson$1
                                    });
                                } catch (Throwable th4) {
                                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv2.readValue(response, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$getDecodedJson$$inlined$parseJson$1
                                    });
                                }
                                break;
                            } else {
                                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv3.readValue(response, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$getDecodedJson$$inlined$parseJson$1
                                });
                            }
                            root = (JsonNode) objDecodeFromString;
                            jsonNode = root.get("encrypted");
                            if (jsonNode == null && jsonNode.asBoolean()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                str2 = str;
                                if (root.get(str2) != null) {
                                    return IStreamFlareParserKt.decryptPayload(root.get(str2).asText());
                                }
                            }
                            return response;
                        } catch (Exception e3) {
                            return response;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        c00002 = c00002;
                        url2 = url;
                        c00002.L$0 = url2;
                        c00002.L$1 = SpillingKt.nullOutSpilledVariable(e);
                        c00002.label = i;
                        if (syncConfig(true, c00002) == obj) {
                            return obj;
                        }
                        url3 = url2;
                        if (StringsKt.contains$default(url3, "/android/", false, i, (Object) null)) {
                            retryUrl2 = getMainUrl() + "/android/" + StringsKt.substringAfter$default(url3, "/android/", (String) null, i, (Object) null);
                        } else {
                            retryUrl2 = url3;
                        }
                        Requests app3 = MainActivityKt.getApp();
                        Map<String, String> headers3 = INSTANCE.getHeaders();
                        c00002.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        c00002.L$1 = SpillingKt.nullOutSpilledVariable(e);
                        c00002.L$2 = SpillingKt.nullOutSpilledVariable(retryUrl2);
                        c00002.label = 3;
                        obj2 = Requests.get$default(app3, retryUrl2, headers3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4092, (Object) null);
                        if (obj2 == obj) {
                            return obj;
                        }
                        $result = obj2;
                        retryUrl = ((NiceResponse) $result).getTextLarge();
                        response = retryUrl;
                        AppUtils appUtils2 = AppUtils.INSTANCE;
                        Result.Companion companion5 = Result.Companion;
                        KType kTypeTypeOf2 = Reflection.typeOf(JsonNode.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                        if (Result.exceptionOrNull-impl(obj3) == null) {
                            Result.Companion companion6 = Result.Companion;
                            obj4 = null;
                            obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, i, (Object) null));
                            break;
                        } else {
                            obj4 = null;
                        }
                        if (Result.isFailure-impl(obj3)) {
                            obj4 = obj3;
                        }
                        deserializationStrategy = (KSerializer) obj4;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, response);
                            break;
                        } else {
                            ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv4.readValue(response, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$getDecodedJson$$inlined$parseJson$1
                            });
                        }
                        root = (JsonNode) objDecodeFromString;
                        jsonNode = root.get("encrypted");
                        if (jsonNode == null) {
                            z = false;
                        } else {
                            z = false;
                        }
                        if (z) {
                            str2 = str;
                            if (root.get(str2) != null) {
                                return IStreamFlareParserKt.decryptPayload(root.get(str2).asText());
                            }
                        }
                        return response;
                    }
                } catch (Exception e5) {
                    e = e5;
                    str = "data";
                    obj = coroutine_suspended;
                    i = 2;
                    url2 = url;
                }
                break;
            case 1:
                url2 = (String) c00002.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    str = "data";
                    obj = coroutine_suspended;
                    i = 2;
                    retryUrl = ((NiceResponse) $result).getTextLarge();
                } catch (Exception e6) {
                    e = e6;
                    str = "data";
                    obj = coroutine_suspended;
                    i = 2;
                    c00002.L$0 = url2;
                    c00002.L$1 = SpillingKt.nullOutSpilledVariable(e);
                    c00002.label = i;
                    if (syncConfig(true, c00002) == obj) {
                        return obj;
                    }
                    url3 = url2;
                    if (StringsKt.contains$default(url3, "/android/", false, i, (Object) null)) {
                        retryUrl2 = getMainUrl() + "/android/" + StringsKt.substringAfter$default(url3, "/android/", (String) null, i, (Object) null);
                    } else {
                        retryUrl2 = url3;
                    }
                    Requests app4 = MainActivityKt.getApp();
                    Map<String, String> headers4 = INSTANCE.getHeaders();
                    c00002.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00002.L$1 = SpillingKt.nullOutSpilledVariable(e);
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(retryUrl2);
                    c00002.label = 3;
                    obj2 = Requests.get$default(app4, retryUrl2, headers4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4092, (Object) null);
                    if (obj2 == obj) {
                        return obj;
                    }
                    $result = obj2;
                    retryUrl = ((NiceResponse) $result).getTextLarge();
                    response = retryUrl;
                    AppUtils appUtils3 = AppUtils.INSTANCE;
                    Result.Companion companion7 = Result.Companion;
                    KType kTypeTypeOf3 = Reflection.typeOf(JsonNode.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                    if (Result.exceptionOrNull-impl(obj3) == null) {
                        Result.Companion companion8 = Result.Companion;
                        obj4 = null;
                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, i, (Object) null));
                        break;
                    } else {
                        obj4 = null;
                    }
                    if (Result.isFailure-impl(obj3)) {
                        obj4 = obj3;
                    }
                    deserializationStrategy = (KSerializer) obj4;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, response);
                        break;
                    } else {
                        ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv5.readValue(response, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$getDecodedJson$$inlined$parseJson$1
                        });
                    }
                    root = (JsonNode) objDecodeFromString;
                    jsonNode = root.get("encrypted");
                    if (jsonNode == null) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (z) {
                        str2 = str;
                        if (root.get(str2) != null) {
                            return IStreamFlareParserKt.decryptPayload(root.get(str2).asText());
                        }
                    }
                    return response;
                }
                response = retryUrl;
                AppUtils appUtils4 = AppUtils.INSTANCE;
                Result.Companion companion9 = Result.Companion;
                KType kTypeTypeOf4 = Reflection.typeOf(JsonNode.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                if (Result.exceptionOrNull-impl(obj3) == null) {
                    Result.Companion companion10 = Result.Companion;
                    obj4 = null;
                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, i, (Object) null));
                    break;
                } else {
                    obj4 = null;
                }
                if (Result.isFailure-impl(obj3)) {
                    obj4 = obj3;
                }
                deserializationStrategy = (KSerializer) obj4;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, response);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv6.readValue(response, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$getDecodedJson$$inlined$parseJson$1
                    });
                }
                root = (JsonNode) objDecodeFromString;
                jsonNode = root.get("encrypted");
                if (jsonNode == null) {
                    z = false;
                } else {
                    z = false;
                }
                if (z) {
                    str2 = str;
                    if (root.get(str2) != null) {
                        return IStreamFlareParserKt.decryptPayload(root.get(str2).asText());
                    }
                }
                return response;
            case 2:
                e = (Exception) c00002.L$1;
                String url4 = (String) c00002.L$0;
                ResultKt.throwOnFailure($result);
                str = "data";
                obj = coroutine_suspended;
                i = 2;
                url3 = url4;
                if (StringsKt.contains$default(url3, "/android/", false, i, (Object) null)) {
                    retryUrl2 = getMainUrl() + "/android/" + StringsKt.substringAfter$default(url3, "/android/", (String) null, i, (Object) null);
                } else {
                    retryUrl2 = url3;
                }
                Requests app5 = MainActivityKt.getApp();
                Map<String, String> headers5 = INSTANCE.getHeaders();
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(e);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(retryUrl2);
                c00002.label = 3;
                obj2 = Requests.get$default(app5, retryUrl2, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4092, (Object) null);
                if (obj2 == obj) {
                    return obj;
                }
                $result = obj2;
                retryUrl = ((NiceResponse) $result).getTextLarge();
                response = retryUrl;
                AppUtils appUtils5 = AppUtils.INSTANCE;
                Result.Companion companion11 = Result.Companion;
                KType kTypeTypeOf5 = Reflection.typeOf(JsonNode.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                if (Result.exceptionOrNull-impl(obj3) == null) {
                    Result.Companion companion12 = Result.Companion;
                    obj4 = null;
                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, i, (Object) null));
                    break;
                } else {
                    obj4 = null;
                }
                if (Result.isFailure-impl(obj3)) {
                    obj4 = obj3;
                }
                deserializationStrategy = (KSerializer) obj4;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, response);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv7.readValue(response, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$getDecodedJson$$inlined$parseJson$1
                    });
                }
                root = (JsonNode) objDecodeFromString;
                jsonNode = root.get("encrypted");
                if (jsonNode == null) {
                    z = false;
                } else {
                    z = false;
                }
                if (z) {
                    str2 = str;
                    if (root.get(str2) != null) {
                        return IStreamFlareParserKt.decryptPayload(root.get(str2).asText());
                    }
                }
                return response;
            case 3:
                ResultKt.throwOnFailure($result);
                str = "data";
                i = 2;
                retryUrl = ((NiceResponse) $result).getTextLarge();
                response = retryUrl;
                AppUtils appUtils6 = AppUtils.INSTANCE;
                Result.Companion companion13 = Result.Companion;
                KType kTypeTypeOf6 = Reflection.typeOf(JsonNode.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                if (Result.exceptionOrNull-impl(obj3) == null) {
                    Result.Companion companion14 = Result.Companion;
                    obj4 = null;
                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, i, (Object) null));
                    break;
                } else {
                    obj4 = null;
                }
                if (Result.isFailure-impl(obj3)) {
                    obj4 = obj3;
                }
                deserializationStrategy = (KSerializer) obj4;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, response);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv8 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv8.readValue(response, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlare$getDecodedJson$$inlined$parseJson$1
                    });
                }
                root = (JsonNode) objDecodeFromString;
                jsonNode = root.get("encrypted");
                if (jsonNode == null) {
                    z = false;
                } else {
                    z = false;
                }
                if (z) {
                    str2 = str;
                    if (root.get(str2) != null) {
                        return IStreamFlareParserKt.decryptPayload(root.get(str2).asText());
                    }
                }
                return response;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
