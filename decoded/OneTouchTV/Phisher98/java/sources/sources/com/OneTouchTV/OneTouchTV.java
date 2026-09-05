package com.OneTouchTV;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
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
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.StringUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
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
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
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
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: OneTouchTV.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/OneTouchTV/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0006OPQRSTB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"J\u001e\u0010\u001b\u001a\u00020#2\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0096@¢\u0006\u0002\u0010&J\f\u0010'\u001a\u00020(*\u00020)H\u0002J\f\u0010'\u001a\u00020(*\u00020*H\u0002J\f\u0010'\u001a\u00020(*\u00020+H\u0002J\f\u0010,\u001a\u00020-*\u00020(H\u0002J\f\u0010.\u001a\u00020/*\u000200H\u0002J\f\u0010.\u001a\u00020/*\u000201H\u0002J\u0014\u0010,\u001a\u00020-*\u00020/2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00105JF\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u000e2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0:2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020<0:H\u0096@¢\u0006\u0002\u0010?J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0005H\u0002J*\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020\u00052\b\u0010F\u001a\u0004\u0018\u00010!2\u0006\u0010G\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010HJ*\u0010I\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020K0J2\u0006\u0010L\u001a\u00020!2\u0006\u0010M\u001a\u00020!H\u0082@¢\u0006\u0002\u0010NR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006U"}, d2 = {"Lcom/OneTouchTV/OneTouchTV;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "page", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMedia", "Lcom/OneTouchTV/OneTouchTV$OneTouchMedia;", "Lcom/OneTouchTV/OneTouchTVParser$Day;", "Lcom/OneTouchTV/OneTouchTVParser$Week;", "Lcom/OneTouchTV/OneTouchTVParser$Month;", "toSearchResponse", "Lcom/lagradost/cloudstream3/SearchResponse;", "toCleanMedia", "Lcom/OneTouchTV/CleanMedia;", "Lcom/OneTouchTV/RandomSlideShow;", "Lcom/OneTouchTV/Recent;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "t", "fetchTmdbData", "Lcom/OneTouchTV/OneTouchTV$TmdbData;", "title", "year", "isMovie", "(Ljava/lang/String;Ljava/lang/Integer;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchTmdbEpisodes", "", "Lcom/OneTouchTV/OneTouchTV$TmdbEpisode;", "tmdbId", "seasonNumber", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "OneTouchMedia", "LoadData", "ActorItem", "EpisodeItem", "TmdbData", "TmdbEpisode", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOneTouchTV.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneTouchTV.kt\ncom/OneTouchTV/OneTouchTV\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 7 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,745:1\n63#2:746\n64#2,15:748\n63#2:765\n64#2,15:767\n63#2:788\n64#2,15:790\n63#2:811\n64#2,15:813\n63#2:843\n64#2,15:845\n63#2:894\n64#2,15:896\n63#2:965\n64#2,15:967\n63#2:985\n64#2,15:987\n63#2:1027\n64#2,15:1029\n1#3:747\n1#3:766\n1#3:789\n1#3:812\n1#3:830\n1#3:844\n1#3:891\n1#3:895\n1#3:957\n1#3:962\n1#3:966\n1#3:984\n1#3:986\n1#3:1004\n1#3:1024\n1#3:1028\n1#3:1056\n50#4:763\n43#4:764\n50#4:782\n43#4:783\n50#4:805\n43#4:806\n50#4:828\n43#4:829\n50#4:860\n43#4:861\n50#4:911\n43#4:912\n50#4:982\n43#4:983\n50#4:1002\n43#4:1003\n50#4:1044\n43#4:1045\n1739#5:784\n1814#5,3:785\n1739#5:807\n1814#5,3:808\n1739#5:831\n1814#5,3:832\n1739#5:835\n1814#5,3:836\n1739#5:839\n1814#5,3:840\n1665#5:862\n1691#5,3:863\n1694#5,3:873\n1739#5:887\n1814#5,3:888\n1739#5:913\n1814#5,3:914\n1739#5:917\n1814#5,3:918\n1849#5,8:921\n777#5:929\n873#5,2:930\n1665#5:932\n1691#5,3:933\n1694#5,3:943\n1739#5:958\n1814#5,3:959\n1739#5:1005\n1814#5,3:1006\n1739#5:1009\n1814#5,3:1010\n1795#5,10:1013\n2068#5:1023\n2069#5:1025\n1805#5:1026\n2068#5,2:1046\n2068#5,2:1048\n2068#5,2:1050\n1739#5:1052\n1814#5,3:1053\n460#6,7:866\n460#6,7:936\n139#7,10:876\n221#7:886\n222#7:892\n149#7:893\n139#7,10:946\n221#7:956\n222#7:963\n149#7:964\n*S KotlinDebug\n*F\n+ 1 OneTouchTV.kt\ncom/OneTouchTV/OneTouchTV\n*L\n81#1:746\n81#1:748,15\n83#1:765\n83#1:767,15\n145#1:788\n145#1:790,15\n185#1:811\n185#1:813,15\n204#1:843\n204#1:845,15\n230#1:894\n230#1:896,15\n371#1:965\n371#1:967,15\n407#1:985\n407#1:987,15\n494#1:1027\n494#1:1029,15\n81#1:747\n83#1:766\n145#1:789\n185#1:812\n204#1:844\n210#1:891\n230#1:895\n250#1:962\n371#1:966\n407#1:986\n456#1:1024\n494#1:1028\n81#1:763\n81#1:764\n83#1:782\n83#1:783\n145#1:805\n145#1:806\n185#1:828\n185#1:829\n204#1:860\n204#1:861\n230#1:911\n230#1:912\n371#1:982\n371#1:983\n407#1:1002\n407#1:1003\n494#1:1044\n494#1:1045\n93#1:784\n93#1:785,3\n153#1:807\n153#1:808,3\n192#1:831\n192#1:832,3\n195#1:835\n195#1:836,3\n198#1:839\n198#1:840,3\n209#1:862\n209#1:863,3\n209#1:873,3\n214#1:887\n214#1:888,3\n238#1:913\n238#1:914,3\n239#1:917\n239#1:918,3\n242#1:921,8\n244#1:929\n244#1:930,2\n248#1:932\n248#1:933,3\n248#1:943,3\n254#1:958\n254#1:959,3\n432#1:1005\n432#1:1006,3\n441#1:1009\n441#1:1010,3\n456#1:1013,10\n456#1:1023\n456#1:1025\n456#1:1026\n502#1:1046,2\n503#1:1048,2\n504#1:1050,2\n507#1:1052\n507#1:1053,3\n209#1:866,7\n248#1:936,7\n210#1:876,10\n210#1:886\n210#1:892\n210#1:893\n250#1:946,10\n250#1:956\n250#1:963\n250#1:964\n*E\n"})
public final class OneTouchTV extends MainAPI {
    private final boolean hasDownloadSupport;

    @NotNull
    private String mainUrl = MainAPIKt.base64Decode("aHR0cHM6Ly9hcGkzLmRldmNvcnAubWU=");

    @NotNull
    private String name = "OneTouchTV";
    private final boolean hasMainPage = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.AsianDrama, TvType.Anime, TvType.Live});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("vod/filter?type=tv+show&status=ongoing", "TvShows"), TuplesKt.to("vod/filter?type=movie", "Movies"), TuplesKt.to("vod/filter?type=drama", "Drama"), TuplesKt.to("vod/filter?country=asia", "Asia"), TuplesKt.to("vod/filter?country=chinese", "Chinese"), TuplesKt.to("vod/filter?country=filipino", "Filipino"), TuplesKt.to("vod/filter?country=hong+kong", "Hong Kong"), TuplesKt.to("vod/filter?country=japanese", "Japanese"), TuplesKt.to("vod/filter?country=korean", "Korean"), TuplesKt.to("vod/filter?country=singapore", "Singapore"), TuplesKt.to("vod/filter?country=taiwanese", "Taiwanese"), TuplesKt.to("vod/filter?country=thai", "Thai"), TuplesKt.to("tv/channels", "Live TV")});

    /* JADX INFO: renamed from: com.OneTouchTV.OneTouchTV$fetchTmdbData$1 */
    /* JADX INFO: compiled from: OneTouchTV.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.OneTouchTV.OneTouchTV", f = "OneTouchTV.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {683, 688, 691, 701}, m = "fetchTmdbData", n = {"title", "year", "type", "cleanTitle", "encodedTitle", "tmdbApiKey", "searchUrl", "yearParam", "yearUrl", "isMovie", "title", "year", "type", "cleanTitle", "encodedTitle", "tmdbApiKey", "searchUrl", "yearParam", "yearUrl", "yearRes", "yearJson", "isMovie", "title", "year", "type", "cleanTitle", "encodedTitle", "tmdbApiKey", "searchUrl", "isMovie", "title", "year", "type", "cleanTitle", "encodedTitle", "tmdbApiKey", "searchUrl", "res", "json", "results", "first", "detailUrl", "isMovie", "id"}, nl = {684, 691, 693, 702}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
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

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OneTouchTV.this.fetchTmdbData(null, null, false, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.OneTouchTV.OneTouchTV$fetchTmdbEpisodes$1 */
    /* JADX INFO: compiled from: OneTouchTV.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.OneTouchTV.OneTouchTV", f = "OneTouchTV.kt", i = {0, 0, 0, 0}, l = {727}, m = "fetchTmdbEpisodes", n = {"tmdbApiKey", "url", "tmdbId", "seasonNumber"}, nl = {728}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return OneTouchTV.this.fetchTmdbEpisodes(0, 0, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.OneTouchTV.OneTouchTV$getMainPage$1 */
    /* JADX INFO: compiled from: OneTouchTV.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.OneTouchTV.OneTouchTV", f = "OneTouchTV.kt", i = {0, 0, 0}, l = {128}, m = "getMainPage", n = {"request", "url", "page"}, nl = {129}, s = {"L$0", "L$1", "I$0"}, v = 2)
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
            return OneTouchTV.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.OneTouchTV.OneTouchTV$load$1 */
    /* JADX INFO: compiled from: OneTouchTV.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.OneTouchTV.OneTouchTV", f = "OneTouchTV.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {369, 375, 391, 453, 454, 483, 518, 540}, m = "load", n = {"url", "channelId", "url", "channelId", "rawResponse", "decryptedJson", "channelParser", "channel", "url", "url", "rawResponse", "decryptedJson", "parser", "title", "poster", "backgroundposter", "description", "year", "status", "actors", "tags", "seasonRegex", "seasonMatch", "isMovie", "extractedSeason", "url", "rawResponse", "decryptedJson", "parser", "title", "poster", "backgroundposter", "description", "year", "status", "actors", "tags", "seasonRegex", "seasonMatch", "tmdbData", "isMovie", "extractedSeason", "url", "rawResponse", "decryptedJson", "parser", "title", "poster", "backgroundposter", "description", "year", "status", "actors", "tags", "seasonRegex", "seasonMatch", "tmdbData", "tmdbEpisodes", "episodes", "isMovie", "extractedSeason", "url", "rawResponse", "decryptedJson", "parser", "title", "poster", "backgroundposter", "description", "year", "status", "actors", "tags", "seasonRegex", "seasonMatch", "tmdbData", "tmdbEpisodes", "episodes", "recommendation", "epUrl", "isMovie", "extractedSeason", "url", "rawResponse", "decryptedJson", "parser", "title", "poster", "backgroundposter", "description", "year", "status", "actors", "tags", "seasonRegex", "seasonMatch", "tmdbData", "tmdbEpisodes", "episodes", "recommendation", "isMovie", "extractedSeason"}, nl = {370, 390, 392, 454, 456, 485, 540, 516}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "Z$0", "I$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
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

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OneTouchTV.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.OneTouchTV.OneTouchTV$search$1 */
    /* JADX INFO: compiled from: OneTouchTV.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.OneTouchTV.OneTouchTV", f = "OneTouchTV.kt", i = {0, 0, 0}, l = {68}, m = "search", n = {"query", "url", "page"}, nl = {69}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OneTouchTV.this.search(null, 0, (Continuation) this);
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

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:101:0x0291  */
    /* JADX WARN: Code duplicated, block: B:103:0x029b  */
    /* JADX WARN: Code duplicated, block: B:104:0x029e  */
    /* JADX WARN: Code duplicated, block: B:106:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:108:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:109:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:137:0x01d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:150:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:152:0x0205 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0100 A[Catch: Exception -> 0x019f, TRY_ENTER, TRY_LEAVE, TryCatch #9 {Exception -> 0x019f, blocks: (B:31:0x0100, B:37:0x0132, B:44:0x0160, B:47:0x0167, B:57:0x0197, B:56:0x0182, B:55:0x017c, B:43:0x0155, B:36:0x0128, B:85:0x0214, B:33:0x0105, B:40:0x0139, B:50:0x016d, B:80:0x0205), top: B:141:0x00fe, inners: #2, #10, #15, #14 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0166  */
    /* JADX WARN: Code duplicated, block: B:56:0x0182 A[Catch: Exception -> 0x019f, TryCatch #9 {Exception -> 0x019f, blocks: (B:31:0x0100, B:37:0x0132, B:44:0x0160, B:47:0x0167, B:57:0x0197, B:56:0x0182, B:55:0x017c, B:43:0x0155, B:36:0x0128, B:85:0x0214, B:33:0x0105, B:40:0x0139, B:50:0x016d, B:80:0x0205), top: B:141:0x00fe, inners: #2, #10, #15, #14 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x01a4 A[Catch: Exception -> 0x0335, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x0335, blocks: (B:28:0x00e9, B:61:0x01a4, B:67:0x01ca, B:74:0x01f8, B:77:0x01ff, B:87:0x022f, B:86:0x021a, B:73:0x01ed, B:66:0x01c0, B:70:0x01d1, B:63:0x01a9), top: B:135:0x00e9, inners: #5, #14 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:86:0x021a A[Catch: Exception -> 0x0335, TRY_ENTER, TryCatch #4 {Exception -> 0x0335, blocks: (B:28:0x00e9, B:61:0x01a4, B:67:0x01ca, B:74:0x01f8, B:77:0x01ff, B:87:0x022f, B:86:0x021a, B:73:0x01ed, B:66:0x01c0, B:70:0x01d1, B:63:0x01a9), top: B:135:0x00e9, inners: #5, #14 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x023d  */
    /* JADX WARN: Code duplicated, block: B:92:0x0248  */
    /* JADX WARN: Code duplicated, block: B:95:0x0265  */
    /* JADX WARN: Code duplicated, block: B:97:0x0280  */
    /* JADX WARN: Code duplicated, block: B:98:0x0283  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) throws ErrorLoadingException {
        C00081 c00081;
        String decryptedJson;
        Object obj;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        List<SearchResult> result;
        Iterable $this$map$iv;
        Collection destination$iv$iv;
        final SearchResult result2;
        boolean isMovie;
        TvType tvType;
        TvType tvType2;
        String title;
        String str;
        MovieSearchResponse movieSearchResponseNewTvSeriesSearchResponse$default;
        String title2;
        String str2;
        Object obj2;
        DeserializationStrategy deserializationStrategy2;
        Object objDecodeFromString2;
        int page2 = page;
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
        C00081 c00082 = c00081;
        Object $result = c00082.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00082.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url = getMainUrl() + "/vod/search?page=" + page2 + "&keyword=" + query;
                try {
                    Requests app = MainActivityKt.getApp();
                    String str3 = getMainUrl() + '/';
                    c00082.L$0 = SpillingKt.nullOutSpilledVariable(query);
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00082.I$0 = page2;
                    c00082.label = 1;
                    try {
                        Object obj3 = Requests.get$default(app, url, (Map) null, str3, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 4090, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = obj3;
                        try {
                            String responseText = ((NiceResponse) $result).getText();
                            try {
                                decryptedJson = DecryptionKt.decryptString(responseText);
                                try {
                                    try {
                                        if (StringsKt.startsWith$default(StringsKt.trim(decryptedJson).toString(), "[", false, 2, (Object) null)) {
                                            AppUtils appUtils = AppUtils.INSTANCE;
                                            try {
                                                Result.Companion companion = Result.Companion;
                                                KType kTypeTypeOf = Reflection.typeOf(SearchResult[].class, KTypeProjection.Companion.invariant(Reflection.typeOf(SearchResult.class)));
                                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                            } catch (Throwable th) {
                                                Result.Companion companion2 = Result.Companion;
                                                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                            }
                                            if (Result.exceptionOrNull-impl(obj2) != null) {
                                                try {
                                                    Result.Companion companion3 = Result.Companion;
                                                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(SearchResult[].class), (List) null, 2, (Object) null));
                                                } catch (Throwable th2) {
                                                    Result.Companion companion4 = Result.Companion;
                                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                                                }
                                            }
                                            if (Result.isFailure-impl(obj2)) {
                                                obj2 = null;
                                            }
                                            deserializationStrategy2 = (KSerializer) obj2;
                                            if (deserializationStrategy2 != null) {
                                                try {
                                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, decryptedJson);
                                                } catch (SerializationException e) {
                                                    ArchComponentExtKt.logError(e);
                                                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                                    objDecodeFromString2 = $this$readValue$iv$iv.readValue(decryptedJson, new TypeReference<SearchResult[]>() { // from class: com.OneTouchTV.OneTouchTV$search$$inlined$parseJson$1
                                                    });
                                                } catch (Throwable th3) {
                                                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                                    objDecodeFromString2 = $this$readValue$iv$iv2.readValue(decryptedJson, new TypeReference<SearchResult[]>() { // from class: com.OneTouchTV.OneTouchTV$search$$inlined$parseJson$1
                                                    });
                                                }
                                            } else {
                                                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                                objDecodeFromString2 = $this$readValue$iv$iv3.readValue(decryptedJson, new TypeReference<SearchResult[]>() { // from class: com.OneTouchTV.OneTouchTV$search$$inlined$parseJson$1
                                                });
                                            }
                                            result = ArraysKt.toList((Object[]) objDecodeFromString2);
                                            break;
                                        } else {
                                            AppUtils appUtils2 = AppUtils.INSTANCE;
                                            try {
                                                Result.Companion companion5 = Result.Companion;
                                                KType kTypeTypeOf2 = Reflection.typeOf(Search.class);
                                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                            } catch (Throwable th4) {
                                                Result.Companion companion6 = Result.Companion;
                                                obj = Result.constructor-impl(ResultKt.createFailure(th4));
                                            }
                                            if (Result.exceptionOrNull-impl(obj) != null) {
                                                try {
                                                    Result.Companion companion7 = Result.Companion;
                                                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Search.class), (List) null, 2, (Object) null));
                                                } catch (Throwable th5) {
                                                    Result.Companion companion8 = Result.Companion;
                                                    obj = Result.constructor-impl(ResultKt.createFailure(th5));
                                                }
                                            }
                                            if (Result.isFailure-impl(obj)) {
                                                obj = null;
                                            }
                                            deserializationStrategy = (KSerializer) obj;
                                            if (deserializationStrategy != null) {
                                                try {
                                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decryptedJson);
                                                } catch (SerializationException e2) {
                                                    ArchComponentExtKt.logError(e2);
                                                    ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                                    objDecodeFromString = $this$readValue$iv$iv4.readValue(decryptedJson, new TypeReference<Search>() { // from class: com.OneTouchTV.OneTouchTV$search$$inlined$parseJson$2
                                                    });
                                                } catch (Throwable th6) {
                                                    ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                                    objDecodeFromString = $this$readValue$iv$iv5.readValue(decryptedJson, new TypeReference<Search>() { // from class: com.OneTouchTV.OneTouchTV$search$$inlined$parseJson$2
                                                    });
                                                }
                                            } else {
                                                ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                                                objDecodeFromString = $this$readValue$iv$iv6.readValue(decryptedJson, new TypeReference<Search>() { // from class: com.OneTouchTV.OneTouchTV$search$$inlined$parseJson$2
                                                });
                                            }
                                            result = ((Search) objDecodeFromString).getResult();
                                            break;
                                        }
                                        if (result.isEmpty()) {
                                            return MainAPIKt.toNewSearchResponseList$default(CollectionsKt.emptyList(), (Boolean) null, 1, (Object) null);
                                        }
                                        $this$map$iv = result;
                                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                        for (Object item$iv$iv : $this$map$iv) {
                                            result2 = (SearchResult) item$iv$iv;
                                            List<SearchResult> list = result;
                                            Iterable $this$map$iv2 = $this$map$iv;
                                            int page3 = page2;
                                            isMovie = StringsKt.equals(result2.getType(), "movie", true);
                                            if (isMovie) {
                                                tvType = TvType.Movie;
                                            } else {
                                                tvType = TvType.TvSeries;
                                            }
                                            tvType2 = tvType;
                                            if (isMovie) {
                                                OneTouchTV oneTouchTV = this;
                                                title2 = result2.getTitle();
                                                if (title2 == null) {
                                                    str2 = "Unknown";
                                                } else {
                                                    str2 = title2;
                                                }
                                                movieSearchResponseNewTvSeriesSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(oneTouchTV, str2, getMainUrl() + "/vod/" + result2.getId() + "/detail", tvType2, false, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda7
                                                    public final Object invoke(Object obj4) {
                                                        return OneTouchTV.search$lambda$0$0(result2, (MovieSearchResponse) obj4);
                                                    }
                                                }, 8, (Object) null);
                                            } else {
                                                OneTouchTV oneTouchTV2 = this;
                                                title = result2.getTitle();
                                                if (title == null) {
                                                    str = "Unknown";
                                                } else {
                                                    str = title;
                                                }
                                                movieSearchResponseNewTvSeriesSearchResponse$default = MainAPIKt.newTvSeriesSearchResponse$default(oneTouchTV2, str, getMainUrl() + "/vod/" + result2.getId() + "/detail", tvType2, false, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda8
                                                    public final Object invoke(Object obj4) {
                                                        return OneTouchTV.search$lambda$0$1(result2, (TvSeriesSearchResponse) obj4);
                                                    }
                                                }, 8, (Object) null);
                                            }
                                            destination$iv$iv.add((SearchResponse) movieSearchResponseNewTvSeriesSearchResponse$default);
                                            result = list;
                                            $this$map$iv = $this$map$iv2;
                                            page2 = page3;
                                        }
                                        return MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv, (Boolean) null, 1, (Object) null);
                                    } catch (Exception e3) {
                                        return MainAPIKt.toNewSearchResponseList$default(CollectionsKt.emptyList(), (Boolean) null, 1, (Object) null);
                                    }
                                } catch (Exception e4) {
                                }
                            } catch (Exception e5) {
                                return MainAPIKt.toNewSearchResponseList$default(CollectionsKt.emptyList(), (Boolean) null, 1, (Object) null);
                            }
                        } catch (Exception e6) {
                            e = e6;
                            throw new ErrorLoadingException("Failed to fetch search data: " + e.getMessage());
                        }
                    } catch (Exception e7) {
                        e = e7;
                        throw new ErrorLoadingException("Failed to fetch search data: " + e.getMessage());
                    }
                } catch (Exception e8) {
                    e = e8;
                }
                break;
            case 1:
                page2 = c00082.I$0;
                try {
                    ResultKt.throwOnFailure($result);
                    String responseText2 = ((NiceResponse) $result).getText();
                    decryptedJson = DecryptionKt.decryptString(responseText2);
                    if (StringsKt.startsWith$default(StringsKt.trim(decryptedJson).toString(), "[", false, 2, (Object) null)) {
                        AppUtils appUtils3 = AppUtils.INSTANCE;
                        Result.Companion companion9 = Result.Companion;
                        KType kTypeTypeOf3 = Reflection.typeOf(SearchResult[].class, KTypeProjection.Companion.invariant(Reflection.typeOf(SearchResult.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                        if (Result.exceptionOrNull-impl(obj2) != null) {
                            Result.Companion companion10 = Result.Companion;
                            obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(SearchResult[].class), (List) null, 2, (Object) null));
                        }
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = null;
                        }
                        deserializationStrategy2 = (KSerializer) obj2;
                        if (deserializationStrategy2 != null) {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, decryptedJson);
                        } else {
                            ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv7.readValue(decryptedJson, new TypeReference<SearchResult[]>() { // from class: com.OneTouchTV.OneTouchTV$search$$inlined$parseJson$1
                            });
                        }
                        result = ArraysKt.toList((Object[]) objDecodeFromString2);
                        break;
                    } else {
                        AppUtils appUtils4 = AppUtils.INSTANCE;
                        Result.Companion companion11 = Result.Companion;
                        KType kTypeTypeOf4 = Reflection.typeOf(Search.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            Result.Companion companion12 = Result.Companion;
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Search.class), (List) null, 2, (Object) null));
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decryptedJson);
                        } else {
                            ObjectMapper $this$readValue$iv$iv8 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv8.readValue(decryptedJson, new TypeReference<Search>() { // from class: com.OneTouchTV.OneTouchTV$search$$inlined$parseJson$2
                            });
                        }
                        result = ((Search) objDecodeFromString).getResult();
                        break;
                    }
                    if (result.isEmpty()) {
                        return MainAPIKt.toNewSearchResponseList$default(CollectionsKt.emptyList(), (Boolean) null, 1, (Object) null);
                    }
                    $this$map$iv = result;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    while (r12.hasNext()) {
                        result2 = (SearchResult) item$iv$iv;
                        List<SearchResult> list2 = result;
                        Iterable $this$map$iv3 = $this$map$iv;
                        int page4 = page2;
                        isMovie = StringsKt.equals(result2.getType(), "movie", true);
                        if (isMovie) {
                            tvType = TvType.Movie;
                        } else {
                            tvType = TvType.TvSeries;
                        }
                        tvType2 = tvType;
                        if (isMovie) {
                            OneTouchTV oneTouchTV3 = this;
                            title2 = result2.getTitle();
                            if (title2 == null) {
                                str2 = "Unknown";
                            } else {
                                str2 = title2;
                            }
                            movieSearchResponseNewTvSeriesSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(oneTouchTV3, str2, getMainUrl() + "/vod/" + result2.getId() + "/detail", tvType2, false, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda7
                                public final Object invoke(Object obj4) {
                                    return OneTouchTV.search$lambda$0$0(result2, (MovieSearchResponse) obj4);
                                }
                            }, 8, (Object) null);
                        } else {
                            OneTouchTV oneTouchTV4 = this;
                            title = result2.getTitle();
                            if (title == null) {
                                str = "Unknown";
                            } else {
                                str = title;
                            }
                            movieSearchResponseNewTvSeriesSearchResponse$default = MainAPIKt.newTvSeriesSearchResponse$default(oneTouchTV4, str, getMainUrl() + "/vod/" + result2.getId() + "/detail", tvType2, false, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda8
                                public final Object invoke(Object obj4) {
                                    return OneTouchTV.search$lambda$0$1(result2, (TvSeriesSearchResponse) obj4);
                                }
                            }, 8, (Object) null);
                        }
                        destination$iv$iv.add((SearchResponse) movieSearchResponseNewTvSeriesSearchResponse$default);
                        result = list2;
                        $this$map$iv = $this$map$iv3;
                        page2 = page4;
                    }
                    return MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv, (Boolean) null, 1, (Object) null);
                } catch (Exception e9) {
                    e = e9;
                    throw new ErrorLoadingException("Failed to fetch search data: " + e.getMessage());
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(SearchResult $result, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($result.getImage());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$1(SearchResult $result, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($result.getImage());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:101:0x0304  */
    /* JADX WARN: Code duplicated, block: B:103:0x0319  */
    /* JADX WARN: Code duplicated, block: B:120:0x0383  */
    /* JADX WARN: Code duplicated, block: B:129:0x039f A[Catch: Exception -> 0x0528, TryCatch #13 {Exception -> 0x0528, blocks: (B:105:0x0328, B:111:0x034e, B:118:0x037d, B:121:0x0384, B:130:0x03b4, B:129:0x039f, B:128:0x0399, B:117:0x0372, B:110:0x0344, B:114:0x0356, B:107:0x032d, B:123:0x038a), top: B:394:0x0328, inners: #6, #18, #20, #26 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:136:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:138:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:141:0x03f1 A[LOOP:10: B:139:0x03eb->B:141:0x03f1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:143:0x0438  */
    /* JADX WARN: Code duplicated, block: B:146:0x0443  */
    /* JADX WARN: Code duplicated, block: B:149:0x044f  */
    /* JADX WARN: Code duplicated, block: B:151:0x0452  */
    /* JADX WARN: Code duplicated, block: B:154:0x0470 A[LOOP:11: B:152:0x046a->B:154:0x0470, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:158:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:161:0x04bf  */
    /* JADX WARN: Code duplicated, block: B:163:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:166:0x04e0 A[LOOP:12: B:164:0x04da->B:166:0x04e0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:173:0x0548  */
    /* JADX WARN: Code duplicated, block: B:190:0x05b3  */
    /* JADX WARN: Code duplicated, block: B:202:0x05d7 A[Catch: Exception -> 0x076b, TRY_ENTER, TryCatch #1 {Exception -> 0x076b, blocks: (B:175:0x0558, B:181:0x057e, B:188:0x05ad, B:191:0x05b4, B:203:0x05ec, B:202:0x05d7, B:187:0x05a2, B:180:0x0574, B:184:0x0586, B:177:0x055d), top: B:375:0x0558, inners: #0, #7 }] */
    /* JADX WARN: Code duplicated, block: B:206:0x05f5  */
    /* JADX WARN: Code duplicated, block: B:209:0x060b  */
    /* JADX WARN: Code duplicated, block: B:211:0x0619  */
    /* JADX WARN: Code duplicated, block: B:214:0x0627  */
    /* JADX WARN: Code duplicated, block: B:215:0x063b  */
    /* JADX WARN: Code duplicated, block: B:218:0x064e  */
    /* JADX WARN: Code duplicated, block: B:222:0x066f  */
    /* JADX WARN: Code duplicated, block: B:224:0x0691  */
    /* JADX WARN: Code duplicated, block: B:225:0x069c  */
    /* JADX WARN: Code duplicated, block: B:228:0x06d9  */
    /* JADX WARN: Code duplicated, block: B:230:0x06ef  */
    /* JADX WARN: Code duplicated, block: B:234:0x0746  */
    /* JADX WARN: Code duplicated, block: B:242:0x078d  */
    /* JADX WARN: Code duplicated, block: B:251:0x07bd  */
    /* JADX WARN: Code duplicated, block: B:264:0x07f0  */
    /* JADX WARN: Code duplicated, block: B:273:0x080c A[Catch: Exception -> 0x0adc, TryCatch #8 {Exception -> 0x0adc, blocks: (B:243:0x0791, B:249:0x07b7, B:262:0x07ea, B:265:0x07f1, B:274:0x0821, B:273:0x080c, B:272:0x0806, B:261:0x07df, B:248:0x07ad, B:245:0x0796, B:267:0x07f7), top: B:388:0x0791, inners: #4, #14, #27 }] */
    /* JADX WARN: Code duplicated, block: B:277:0x0830  */
    /* JADX WARN: Code duplicated, block: B:280:0x084c A[LOOP:0: B:278:0x0846->B:280:0x084c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:282:0x0865  */
    /* JADX WARN: Code duplicated, block: B:285:0x0875  */
    /* JADX WARN: Code duplicated, block: B:288:0x0891 A[LOOP:1: B:286:0x088b->B:288:0x0891, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:290:0x08a9  */
    /* JADX WARN: Code duplicated, block: B:294:0x08d0  */
    /* JADX WARN: Code duplicated, block: B:296:0x08de  */
    /* JADX WARN: Code duplicated, block: B:303:0x0908  */
    /* JADX WARN: Code duplicated, block: B:305:0x091c  */
    /* JADX WARN: Code duplicated, block: B:307:0x0922  */
    /* JADX WARN: Code duplicated, block: B:308:0x0938  */
    /* JADX WARN: Code duplicated, block: B:311:0x0942  */
    /* JADX WARN: Code duplicated, block: B:312:0x0944  */
    /* JADX WARN: Code duplicated, block: B:315:0x094d  */
    /* JADX WARN: Code duplicated, block: B:320:0x0979  */
    /* JADX WARN: Code duplicated, block: B:326:0x09a0  */
    /* JADX WARN: Code duplicated, block: B:329:0x09ac  */
    /* JADX WARN: Code duplicated, block: B:330:0x09c0  */
    /* JADX WARN: Code duplicated, block: B:335:0x09ee  */
    /* JADX WARN: Code duplicated, block: B:337:0x0a14  */
    /* JADX WARN: Code duplicated, block: B:339:0x0a1d  */
    /* JADX WARN: Code duplicated, block: B:340:0x0a1f  */
    /* JADX WARN: Code duplicated, block: B:342:0x0a22  */
    /* JADX WARN: Code duplicated, block: B:344:0x0a39  */
    /* JADX WARN: Code duplicated, block: B:345:0x0a3f  */
    /* JADX WARN: Code duplicated, block: B:347:0x0a5d  */
    /* JADX WARN: Code duplicated, block: B:351:0x0a85 A[LOOP:6: B:349:0x0a7f->B:351:0x0a85, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:353:0x0aae  */
    /* JADX WARN: Code duplicated, block: B:355:0x0ab7  */
    /* JADX WARN: Code duplicated, block: B:373:0x0586 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:375:0x0558 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:377:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:384:0x0356 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x014c A[Catch: Exception -> 0x01f9, TRY_LEAVE, TryCatch #26 {Exception -> 0x01f9, blocks: (B:36:0x0139, B:38:0x014c), top: B:408:0x0139 }] */
    /* JADX WARN: Code duplicated, block: B:394:0x0328 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:408:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:412:0x07c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:414:0x01bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:416:0x05ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:418:0x07f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:420:0x038a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:425:0x08e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:427:0x08ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:431:0x0950 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:437:0x0abb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:444:0x074a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:447:0x06f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:68:0x01d4 A[Catch: Exception -> 0x01f7, TryCatch #3 {Exception -> 0x01f7, blocks: (B:49:0x0184, B:56:0x01b2, B:59:0x01b9, B:69:0x01e9, B:68:0x01d4, B:67:0x01ce, B:55:0x01a7, B:48:0x017a, B:70:0x01f0, B:52:0x018b, B:62:0x01bf), top: B:379:0x014a, inners: #2, #9, #29 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x01f0 A[Catch: Exception -> 0x01f7, TRY_LEAVE, TryCatch #3 {Exception -> 0x01f7, blocks: (B:49:0x0184, B:56:0x01b2, B:59:0x01b9, B:69:0x01e9, B:68:0x01d4, B:67:0x01ce, B:55:0x01a7, B:48:0x017a, B:70:0x01f0, B:52:0x018b, B:62:0x01bf), top: B:379:0x014a, inners: #2, #9, #29 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:80:0x021f  */
    /* JADX WARN: Code duplicated, block: B:82:0x023a  */
    /* JADX WARN: Code duplicated, block: B:83:0x023d  */
    /* JADX WARN: Code duplicated, block: B:86:0x0247  */
    /* JADX WARN: Code duplicated, block: B:88:0x0251  */
    /* JADX WARN: Code duplicated, block: B:89:0x0254  */
    /* JADX WARN: Code duplicated, block: B:91:0x0290  */
    /* JADX WARN: Code duplicated, block: B:93:0x029e  */
    /* JADX WARN: Code duplicated, block: B:94:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:99:0x02f7  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws ErrorLoadingException {
        C00021 c00021;
        String url;
        boolean z;
        String str;
        Object obj;
        boolean z2;
        MainPageRequest request2;
        int page2;
        String rawResponse;
        String decryptedJson;
        boolean zStartsWith$default;
        String str2;
        List parser;
        List $this$map$iv;
        int $i$f$map;
        Collection destination$iv$iv;
        final SearchResult result;
        String str3;
        boolean isMovie;
        TvType tvType;
        TvType tvType2;
        String title;
        String str4;
        MovieSearchResponse movieSearchResponseNewTvSeriesSearchResponse$default;
        String title2;
        String str5;
        Object obj2;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        Object obj3;
        Object obj4;
        DeserializationStrategy deserializationStrategy2;
        Object objDecodeFromString2;
        OneTouchTVParser parser2;
        List homeLists;
        Iterable day;
        OneTouchTVParser parser3;
        Iterable week;
        Iterable month;
        int i;
        Iterable $this$map$iv2;
        Collection destination$iv$iv2;
        int i2;
        Iterable $this$map$iv3;
        Collection destination$iv$iv3;
        int i3;
        int $i$f$map2;
        Collection destination$iv$iv4;
        Object obj5;
        Object obj6;
        DeserializationStrategy deserializationStrategy3;
        Object objDecodeFromString3;
        ChannelResponse parser4;
        Iterable channels;
        LinkedHashMap destination$iv$iv5;
        Map $this$mapNotNull$iv;
        int $i$f$mapNotNull;
        Collection destination$iv$iv6;
        String category;
        List items;
        List $this$map$iv4;
        Collection destination$iv$iv7;
        Iterable $this$mapTo$iv$iv;
        int $i$f$mapTo;
        HomePageList homePageList;
        String title3;
        String category2;
        String str6;
        Object value$iv$iv$iv;
        Object answer$iv$iv$iv;
        Object obj7;
        Object obj8;
        Object obj9;
        DeserializationStrategy deserializationStrategy4;
        Object objDecodeFromString4;
        MediaResult parser5;
        Iterable randomSlideShow;
        Collection collectionEmptyList;
        Iterable recents;
        Collection collectionEmptyList2;
        List allRawMedia;
        HashSet set$iv;
        ArrayList list$iv;
        ArrayList uniqueMedia;
        Collection destination$iv$iv8;
        List list$iv$iv;
        Map groupedByCountry;
        Map $this$mapNotNull$iv2;
        int $i$f$mapNotNull2;
        Collection destination$iv$iv9;
        Map $this$mapNotNullTo$iv$iv;
        int $i$f$mapNotNullTo;
        String country;
        List items2;
        int $i$f$mapNotNull3;
        HomePageList homePageList2;
        boolean z3;
        String string;
        List $this$map$iv5;
        Collection destination$iv$iv10;
        char it;
        String strValueOf;
        String country2;
        String lowerCase;
        String str7;
        Object value$iv$iv$iv2;
        Object answer$iv$iv$iv2;
        String string2;
        CleanMedia media;
        boolean z4;
        String type;
        boolean zContains;
        CleanMedia it2;
        String id;
        Collection destination$iv$iv11;
        Collection destination$iv$iv12;
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
        C00021 c00022 = c00021;
        Object $result = c00022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00022.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (StringsKt.startsWith$default(request.getData(), "vod/filter", false, 2, (Object) null)) {
                    String sep = StringsKt.contains$default(request.getData(), "?", false, 2, (Object) null) ? "&" : "?";
                    url = getMainUrl() + '/' + request.getData() + sep + "page=" + page;
                } else {
                    url = getMainUrl() + '/' + request.getData();
                }
                try {
                    Requests app = MainActivityKt.getApp();
                    c00022.L$0 = request;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00022.I$0 = page;
                    c00022.label = 1;
                    z = false;
                    str = "vod/filter";
                    obj = null;
                    z2 = false;
                    try {
                        Object obj10 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4094, (Object) null);
                        if (obj10 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        request2 = request;
                        $result = obj10;
                        page2 = page;
                        try {
                            rawResponse = ((NiceResponse) $result).getText();
                            try {
                                decryptedJson = DecryptionKt.decryptString(rawResponse);
                                zStartsWith$default = StringsKt.startsWith$default(request2.getData(), str, z2, 2, obj);
                                str2 = "Unknown";
                                if (zStartsWith$default) {
                                    try {
                                        try {
                                            if (StringsKt.startsWith$default(StringsKt.trim(decryptedJson).toString(), "[", z2, 2, obj)) {
                                                AppUtils appUtils = AppUtils.INSTANCE;
                                                try {
                                                    Result.Companion companion = Result.Companion;
                                                    z = false;
                                                    try {
                                                        KType kTypeTypeOf = Reflection.typeOf(SearchResult[].class, KTypeProjection.Companion.invariant(Reflection.typeOf(SearchResult.class)));
                                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                        obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        Result.Companion companion2 = Result.Companion;
                                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    z = false;
                                                }
                                                if (Result.exceptionOrNull-impl(obj2) != null) {
                                                    try {
                                                        Result.Companion companion3 = Result.Companion;
                                                        obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(SearchResult[].class), (List) null, 2, (Object) null));
                                                    } catch (Throwable th3) {
                                                        Result.Companion companion4 = Result.Companion;
                                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th3));
                                                    }
                                                }
                                                if (Result.isFailure-impl(obj2)) {
                                                    obj2 = null;
                                                }
                                                deserializationStrategy = (KSerializer) obj2;
                                                if (deserializationStrategy != null) {
                                                    try {
                                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decryptedJson);
                                                    } catch (SerializationException e) {
                                                        ArchComponentExtKt.logError(e);
                                                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                                        objDecodeFromString = $this$readValue$iv$iv.readValue(decryptedJson, new TypeReference<SearchResult[]>() { // from class: com.OneTouchTV.OneTouchTV$getMainPage$$inlined$parseJson$1
                                                        });
                                                    } catch (Throwable th4) {
                                                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                                        objDecodeFromString = $this$readValue$iv$iv2.readValue(decryptedJson, new TypeReference<SearchResult[]>() { // from class: com.OneTouchTV.OneTouchTV$getMainPage$$inlined$parseJson$1
                                                        });
                                                    }
                                                } else {
                                                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                                    objDecodeFromString = $this$readValue$iv$iv3.readValue(decryptedJson, new TypeReference<SearchResult[]>() { // from class: com.OneTouchTV.OneTouchTV$getMainPage$$inlined$parseJson$1
                                                    });
                                                }
                                                parser = ArraysKt.toList((Object[]) objDecodeFromString);
                                            } else {
                                                z = false;
                                                parser = CollectionsKt.emptyList();
                                            }
                                        } catch (Exception e2) {
                                            parser = CollectionsKt.emptyList();
                                        }
                                        break;
                                    } catch (Exception e3) {
                                        z = false;
                                    }
                                    $this$map$iv = parser;
                                    $i$f$map = 0;
                                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                    for (Object item$iv$iv : $this$map$iv) {
                                        result = (SearchResult) item$iv$iv;
                                        List parser6 = parser;
                                        str3 = str2;
                                        Iterable $this$map$iv6 = $this$map$iv;
                                        isMovie = StringsKt.equals(result.getType(), "movie", true);
                                        if (isMovie) {
                                            tvType = TvType.Movie;
                                        } else {
                                            tvType = TvType.TvSeries;
                                        }
                                        tvType2 = tvType;
                                        if (isMovie) {
                                            OneTouchTV oneTouchTV = this;
                                            title2 = result.getTitle();
                                            if (title2 == null) {
                                                str5 = str3;
                                            } else {
                                                str5 = title2;
                                            }
                                            movieSearchResponseNewTvSeriesSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(oneTouchTV, str5, getMainUrl() + "/vod/" + result.getId() + "/detail", tvType2, false, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda2
                                                public final Object invoke(Object obj11) {
                                                    return OneTouchTV.getMainPage$lambda$0$0(result, (MovieSearchResponse) obj11);
                                                }
                                            }, 8, (Object) null);
                                        } else {
                                            OneTouchTV oneTouchTV2 = this;
                                            title = result.getTitle();
                                            if (title == null) {
                                                str4 = str3;
                                            } else {
                                                str4 = title;
                                            }
                                            movieSearchResponseNewTvSeriesSearchResponse$default = MainAPIKt.newTvSeriesSearchResponse$default(oneTouchTV2, str4, getMainUrl() + "/vod/" + result.getId() + "/detail", tvType2, false, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda3
                                                public final Object invoke(Object obj11) {
                                                    return OneTouchTV.getMainPage$lambda$0$1(result, (TvSeriesSearchResponse) obj11);
                                                }
                                            }, 8, (Object) null);
                                        }
                                        destination$iv$iv.add((SearchResponse) movieSearchResponseNewTvSeriesSearchResponse$default);
                                        parser = parser6;
                                        str2 = str3;
                                        $this$map$iv = $this$map$iv6;
                                        $i$f$map = $i$f$map;
                                    }
                                    List mapped = (List) destination$iv$iv;
                                    return mapped.isEmpty() ? MainAPIKt.newHomePageResponse(CollectionsKt.emptyList(), Boxing.boxBoolean(z)) : MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), mapped, false), Boxing.boxBoolean(true));
                                }
                                if (Intrinsics.areEqual(request2.getData(), "vod/top")) {
                                    try {
                                        AppUtils appUtils2 = AppUtils.INSTANCE;
                                        try {
                                            Result.Companion companion5 = Result.Companion;
                                            KType kTypeTypeOf2 = Reflection.typeOf(OneTouchTVParser.class);
                                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                            obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                            break;
                                        } catch (Throwable th5) {
                                            Result.Companion companion6 = Result.Companion;
                                            obj3 = Result.constructor-impl(ResultKt.createFailure(th5));
                                        }
                                        if (Result.exceptionOrNull-impl(obj3) != null) {
                                            try {
                                                Result.Companion companion7 = Result.Companion;
                                                obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(OneTouchTVParser.class), (List) null, 2, (Object) null));
                                            } catch (Throwable th6) {
                                                Result.Companion companion8 = Result.Companion;
                                                obj3 = Result.constructor-impl(ResultKt.createFailure(th6));
                                            }
                                            break;
                                        }
                                        obj4 = obj3;
                                        if (Result.isFailure-impl(obj4)) {
                                            obj4 = null;
                                        }
                                        deserializationStrategy2 = (KSerializer) obj4;
                                        if (deserializationStrategy2 != null) {
                                            try {
                                                objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, decryptedJson);
                                            } catch (SerializationException e4) {
                                                ArchComponentExtKt.logError(e4);
                                                ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                                objDecodeFromString2 = $this$readValue$iv$iv4.readValue(decryptedJson, new TypeReference<OneTouchTVParser>() { // from class: com.OneTouchTV.OneTouchTV$getMainPage$$inlined$parseJson$2
                                                });
                                            } catch (Throwable th7) {
                                                ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                                objDecodeFromString2 = $this$readValue$iv$iv5.readValue(decryptedJson, new TypeReference<OneTouchTVParser>() { // from class: com.OneTouchTV.OneTouchTV$getMainPage$$inlined$parseJson$2
                                                });
                                            }
                                            break;
                                        } else {
                                            ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                                            objDecodeFromString2 = $this$readValue$iv$iv6.readValue(decryptedJson, new TypeReference<OneTouchTVParser>() { // from class: com.OneTouchTV.OneTouchTV$getMainPage$$inlined$parseJson$2
                                            });
                                        }
                                        parser2 = (OneTouchTVParser) objDecodeFromString2;
                                        homeLists = new ArrayList();
                                        day = parser2.getDay();
                                        if (day == null) {
                                            parser3 = parser2;
                                        } else {
                                            if (((Collection) day).isEmpty()) {
                                                day = null;
                                            }
                                            if (day != null) {
                                                i3 = 0;
                                                Iterable $this$map$iv7 = day;
                                                $i$f$map2 = 0;
                                                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv7, 10));
                                                for (Object item$iv$iv2 : $this$map$iv7) {
                                                    OneTouchTVParser parser7 = parser2;
                                                    OneTouchTVParser.Day item = (OneTouchTVParser.Day) item$iv$iv2;
                                                    destination$iv$iv4.add(toSearchResponse(toMedia(item)));
                                                    parser2 = parser7;
                                                    $i$f$map2 = $i$f$map2;
                                                    i3 = i3;
                                                }
                                                parser3 = parser2;
                                                Boxing.boxBoolean(homeLists.add(new HomePageList("Top - Day", (List) destination$iv$iv4, false, 4, (DefaultConstructorMarker) null)));
                                            } else {
                                                parser3 = parser2;
                                            }
                                        }
                                        week = parser3.getWeek();
                                        if (week != null) {
                                            if (((Collection) week).isEmpty()) {
                                                week = null;
                                            }
                                            if (week != null) {
                                                i2 = 0;
                                                $this$map$iv3 = week;
                                                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                                                for (Object item$iv$iv3 : $this$map$iv3) {
                                                    int i4 = i2;
                                                    OneTouchTVParser.Week item2 = (OneTouchTVParser.Week) item$iv$iv3;
                                                    destination$iv$iv3.add(toSearchResponse(toMedia(item2)));
                                                    i2 = i4;
                                                    $this$map$iv3 = $this$map$iv3;
                                                }
                                                Boxing.boxBoolean(homeLists.add(new HomePageList("Top - Week", (List) destination$iv$iv3, false, 4, (DefaultConstructorMarker) null)));
                                            }
                                        }
                                        month = parser3.getMonth();
                                        if (month != null) {
                                            if (((Collection) month).isEmpty()) {
                                                month = null;
                                            }
                                            if (month != null) {
                                                i = 0;
                                                $this$map$iv2 = month;
                                                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                                                for (Object item$iv$iv4 : $this$map$iv2) {
                                                    int i5 = i;
                                                    OneTouchTVParser.Month item3 = (OneTouchTVParser.Month) item$iv$iv4;
                                                    destination$iv$iv2.add(toSearchResponse(toMedia(item3)));
                                                    i = i5;
                                                    $this$map$iv2 = $this$map$iv2;
                                                }
                                                Boxing.boxBoolean(homeLists.add(new HomePageList("Top - Month", (List) destination$iv$iv2, false, 4, (DefaultConstructorMarker) null)));
                                            }
                                        }
                                        return MainAPIKt.newHomePageResponse(homeLists, Boxing.boxBoolean(false));
                                    } catch (Exception e5) {
                                        throw new ErrorLoadingException("Failed to parse top JSON: " + e5.getMessage());
                                    }
                                }
                                if (Intrinsics.areEqual(request2.getData(), "tv/channels")) {
                                    try {
                                        AppUtils appUtils3 = AppUtils.INSTANCE;
                                        try {
                                            Result.Companion companion9 = Result.Companion;
                                            KType kTypeTypeOf3 = Reflection.typeOf(ChannelResponse.class);
                                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                            obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                            break;
                                        } catch (Throwable th8) {
                                            Result.Companion companion10 = Result.Companion;
                                            obj5 = Result.constructor-impl(ResultKt.createFailure(th8));
                                        }
                                        if (Result.exceptionOrNull-impl(obj5) != null) {
                                            try {
                                                Result.Companion companion11 = Result.Companion;
                                                obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ChannelResponse.class), (List) null, 2, (Object) null));
                                            } catch (Throwable th9) {
                                                Result.Companion companion12 = Result.Companion;
                                                obj5 = Result.constructor-impl(ResultKt.createFailure(th9));
                                            }
                                            break;
                                        }
                                        obj6 = obj5;
                                        if (Result.isFailure-impl(obj6)) {
                                            obj6 = null;
                                        }
                                        deserializationStrategy3 = (KSerializer) obj6;
                                        if (deserializationStrategy3 != null) {
                                            try {
                                                objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, decryptedJson);
                                                break;
                                            } catch (SerializationException e6) {
                                                try {
                                                    ArchComponentExtKt.logError(e6);
                                                    ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                                                    objDecodeFromString3 = $this$readValue$iv$iv7.readValue(decryptedJson, new TypeReference<ChannelResponse>() { // from class: com.OneTouchTV.OneTouchTV$getMainPage$$inlined$parseJson$3
                                                    });
                                                } catch (Exception e7) {
                                                    e = e7;
                                                    throw new ErrorLoadingException("Failed to parse channels JSON: " + e.getMessage());
                                                }
                                            } catch (Throwable th10) {
                                                ObjectMapper $this$readValue$iv$iv8 = MainAPIKt.getMapper();
                                                objDecodeFromString3 = $this$readValue$iv$iv8.readValue(decryptedJson, new TypeReference<ChannelResponse>() { // from class: com.OneTouchTV.OneTouchTV$getMainPage$$inlined$parseJson$3
                                                });
                                            }
                                        } else {
                                            ObjectMapper $this$readValue$iv$iv9 = MainAPIKt.getMapper();
                                            objDecodeFromString3 = $this$readValue$iv$iv9.readValue(decryptedJson, new TypeReference<ChannelResponse>() { // from class: com.OneTouchTV.OneTouchTV$getMainPage$$inlined$parseJson$3
                                            });
                                        }
                                        parser4 = (ChannelResponse) objDecodeFromString3;
                                        channels = parser4.getChannels();
                                        if (channels != null) {
                                            Iterable $this$groupBy$iv = channels;
                                            destination$iv$iv5 = new LinkedHashMap();
                                            for (Object element$iv$iv : $this$groupBy$iv) {
                                                ChannelItem it3 = (ChannelItem) element$iv$iv;
                                                category2 = it3.getCategory();
                                                if (category2 == null) {
                                                    category2 = "Other";
                                                }
                                                str6 = category2;
                                                value$iv$iv$iv = destination$iv$iv5.get(str6);
                                                if (value$iv$iv$iv == null) {
                                                    answer$iv$iv$iv = new ArrayList();
                                                    destination$iv$iv5.put(str6, answer$iv$iv$iv);
                                                } else {
                                                    answer$iv$iv$iv = value$iv$iv$iv;
                                                }
                                                ((List) answer$iv$iv$iv).add(element$iv$iv);
                                                parser4 = parser4;
                                            }
                                        } else {
                                            destination$iv$iv5 = MapsKt.emptyMap();
                                        }
                                        $this$mapNotNull$iv = destination$iv$iv5;
                                        $i$f$mapNotNull = 0;
                                        destination$iv$iv6 = new ArrayList();
                                        for (Map.Entry element$iv$iv$iv : $this$mapNotNull$iv.entrySet()) {
                                            Map $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                                            category = (String) element$iv$iv$iv.getKey();
                                            items = (List) element$iv$iv$iv.getValue();
                                            if (items.isEmpty()) {
                                                homePageList = null;
                                            } else {
                                                String str8 = category + " Live";
                                                $this$map$iv4 = items;
                                                destination$iv$iv7 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                                                $this$mapTo$iv$iv = $this$map$iv4;
                                                $i$f$mapTo = 0;
                                                for (Object item$iv$iv5 : $this$mapTo$iv$iv) {
                                                    Iterable $this$map$iv8 = $this$map$iv4;
                                                    final ChannelItem channel = (ChannelItem) item$iv$iv5;
                                                    OneTouchTV oneTouchTV3 = this;
                                                    title3 = channel.getTitle();
                                                    if (title3 == null) {
                                                        title3 = "Unknown";
                                                    }
                                                    destination$iv$iv7.add(MainAPIKt.newTvSeriesSearchResponse$default(oneTouchTV3, title3, getMainUrl() + "/tv/channels?id=" + channel.getId(), TvType.Live, false, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda4
                                                        public final Object invoke(Object obj11) {
                                                            return OneTouchTV.getMainPage$lambda$8$0$0(channel, (TvSeriesSearchResponse) obj11);
                                                        }
                                                    }, 8, (Object) null));
                                                    $this$map$iv4 = $this$map$iv8;
                                                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                                                    $i$f$mapTo = $i$f$mapTo;
                                                }
                                                homePageList = new HomePageList(str8, (List) destination$iv$iv7, false);
                                            }
                                            if (homePageList != null) {
                                                destination$iv$iv6.add(homePageList);
                                            }
                                            $this$mapNotNull$iv = $this$mapNotNull$iv3;
                                            $i$f$mapNotNull = $i$f$mapNotNull;
                                            destination$iv$iv5 = destination$iv$iv5;
                                            page2 = page2;
                                            rawResponse = rawResponse;
                                        }
                                        return MainAPIKt.newHomePageResponse((List) destination$iv$iv6, Boxing.boxBoolean(false));
                                    } catch (Exception e8) {
                                        e = e8;
                                        throw new ErrorLoadingException("Failed to parse channels JSON: " + e.getMessage());
                                    }
                                }
                                try {
                                    AppUtils appUtils4 = AppUtils.INSTANCE;
                                    try {
                                        Result.Companion companion13 = Result.Companion;
                                        KType kTypeTypeOf4 = Reflection.typeOf(MediaResult.class);
                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                        obj7 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                                        break;
                                    } catch (Throwable th11) {
                                        Result.Companion companion14 = Result.Companion;
                                        obj7 = Result.constructor-impl(ResultKt.createFailure(th11));
                                    }
                                    if (Result.exceptionOrNull-impl(obj7) == null) {
                                        try {
                                            Result.Companion companion15 = Result.Companion;
                                            obj8 = null;
                                            try {
                                                obj7 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(MediaResult.class), (List) null, 2, (Object) null));
                                            } catch (Throwable th12) {
                                                th = th12;
                                                Result.Companion companion16 = Result.Companion;
                                                obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                            }
                                        } catch (Throwable th13) {
                                            th = th13;
                                            obj8 = null;
                                        }
                                        break;
                                    } else {
                                        obj8 = null;
                                    }
                                    obj9 = obj7;
                                    if (Result.isFailure-impl(obj9)) {
                                        obj9 = obj8;
                                    }
                                    deserializationStrategy4 = (KSerializer) obj9;
                                    if (deserializationStrategy4 != null) {
                                        try {
                                            objDecodeFromString4 = MainAPIKt.getJson().decodeFromString(deserializationStrategy4, decryptedJson);
                                        } catch (SerializationException e9) {
                                            ArchComponentExtKt.logError(e9);
                                            ObjectMapper $this$readValue$iv$iv10 = MainAPIKt.getMapper();
                                            objDecodeFromString4 = $this$readValue$iv$iv10.readValue(decryptedJson, new TypeReference<MediaResult>() { // from class: com.OneTouchTV.OneTouchTV$getMainPage$$inlined$parseJson$4
                                            });
                                        } catch (Throwable th14) {
                                            ObjectMapper $this$readValue$iv$iv11 = MainAPIKt.getMapper();
                                            objDecodeFromString4 = $this$readValue$iv$iv11.readValue(decryptedJson, new TypeReference<MediaResult>() { // from class: com.OneTouchTV.OneTouchTV$getMainPage$$inlined$parseJson$4
                                            });
                                        }
                                        break;
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv12 = MainAPIKt.getMapper();
                                        objDecodeFromString4 = $this$readValue$iv$iv12.readValue(decryptedJson, new TypeReference<MediaResult>() { // from class: com.OneTouchTV.OneTouchTV$getMainPage$$inlined$parseJson$4
                                        });
                                    }
                                    parser5 = (MediaResult) objDecodeFromString4;
                                    List $this$getMainPage_u24lambda_u249 = CollectionsKt.createListBuilder();
                                    randomSlideShow = parser5.getRandomSlideShow();
                                    if (randomSlideShow != null) {
                                        Iterable $this$map$iv9 = randomSlideShow;
                                        destination$iv$iv12 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv9, 10));
                                        for (Object item$iv$iv6 : $this$map$iv9) {
                                            RandomSlideShow it4 = (RandomSlideShow) item$iv$iv6;
                                            destination$iv$iv12.add(toCleanMedia(it4));
                                        }
                                        collectionEmptyList = (List) destination$iv$iv12;
                                    } else {
                                        collectionEmptyList = CollectionsKt.emptyList();
                                    }
                                    $this$getMainPage_u24lambda_u249.addAll(collectionEmptyList);
                                    recents = parser5.getRecents();
                                    if (recents != null) {
                                        Iterable $this$map$iv10 = recents;
                                        destination$iv$iv11 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv10, 10));
                                        for (Object item$iv$iv7 : $this$map$iv10) {
                                            Recent it5 = (Recent) item$iv$iv7;
                                            destination$iv$iv11.add(toCleanMedia(it5));
                                        }
                                        collectionEmptyList2 = (List) destination$iv$iv11;
                                    } else {
                                        collectionEmptyList2 = CollectionsKt.emptyList();
                                    }
                                    $this$getMainPage_u24lambda_u249.addAll(collectionEmptyList2);
                                    allRawMedia = CollectionsKt.build($this$getMainPage_u24lambda_u249);
                                    List $this$distinctBy$iv = allRawMedia;
                                    set$iv = new HashSet();
                                    list$iv = new ArrayList();
                                    for (Object e$iv : $this$distinctBy$iv) {
                                        it2 = (CleanMedia) e$iv;
                                        id = it2.getId();
                                        if (id == null) {
                                            id = it2.getTitle();
                                        }
                                        if (set$iv.add(id)) {
                                            list$iv.add(e$iv);
                                        }
                                    }
                                    uniqueMedia = list$iv;
                                    ArrayList $this$filter$iv = uniqueMedia;
                                    destination$iv$iv8 = new ArrayList();
                                    for (Object element$iv$iv2 : $this$filter$iv) {
                                        media = (CleanMedia) element$iv$iv2;
                                        if (MainAPI.Companion.getSettingsForProvider().getEnableAdult()) {
                                            parser5 = parser5;
                                            allRawMedia = allRawMedia;
                                            uniqueMedia = uniqueMedia;
                                        } else {
                                            type = media.getType();
                                            if (type != null) {
                                                zContains = StringsKt.contains(type, "RAW", true);
                                            } else {
                                                zContains = false;
                                            }
                                            if (!zContains) {
                                                z4 = false;
                                            }
                                            if (z4) {
                                                destination$iv$iv8.add(element$iv$iv2);
                                            }
                                            parser5 = parser5;
                                            uniqueMedia = uniqueMedia;
                                            allRawMedia = allRawMedia;
                                        }
                                        z4 = true;
                                        if (z4) {
                                            destination$iv$iv8.add(element$iv$iv2);
                                        }
                                        parser5 = parser5;
                                        uniqueMedia = uniqueMedia;
                                        allRawMedia = allRawMedia;
                                    }
                                    list$iv$iv = (List) destination$iv$iv8;
                                    List $this$groupBy$iv2 = list$iv$iv;
                                    groupedByCountry = new LinkedHashMap();
                                    for (Object element$iv$iv3 : $this$groupBy$iv2) {
                                        CleanMedia it6 = (CleanMedia) element$iv$iv3;
                                        country2 = it6.getCountry();
                                        if (country2 != null || (string2 = StringsKt.trim(country2).toString()) == null) {
                                            lowerCase = "unknown";
                                        } else {
                                            lowerCase = string2.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                            if (lowerCase == null) {
                                                lowerCase = "unknown";
                                            }
                                        }
                                        str7 = lowerCase;
                                        value$iv$iv$iv2 = groupedByCountry.get(str7);
                                        if (value$iv$iv$iv2 == null) {
                                            answer$iv$iv$iv2 = new ArrayList();
                                            groupedByCountry.put(str7, answer$iv$iv$iv2);
                                        } else {
                                            answer$iv$iv$iv2 = value$iv$iv$iv2;
                                        }
                                        ((List) answer$iv$iv$iv2).add(element$iv$iv3);
                                        list$iv$iv = list$iv$iv;
                                    }
                                    $this$mapNotNull$iv2 = groupedByCountry;
                                    $i$f$mapNotNull2 = 0;
                                    destination$iv$iv9 = new ArrayList();
                                    $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv2;
                                    $i$f$mapNotNullTo = 0;
                                    for (Map.Entry element$iv$iv$iv2 : $this$mapNotNullTo$iv$iv.entrySet()) {
                                        Map $this$mapNotNull$iv4 = $this$mapNotNull$iv2;
                                        country = (String) element$iv$iv$iv2.getKey();
                                        items2 = (List) element$iv$iv$iv2.getValue();
                                        int $i$f$mapNotNull4 = $i$f$mapNotNull2;
                                        $i$f$mapNotNull3 = items2.size();
                                        Map groupedByCountry2 = groupedByCountry;
                                        if ($i$f$mapNotNull3 > 4) {
                                            if (country.length() > 0) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            if (z3) {
                                                StringBuilder sb = new StringBuilder();
                                                it = country.charAt(0);
                                                if (Character.isLowerCase(it)) {
                                                    strValueOf = CharsKt.titlecase(it);
                                                } else {
                                                    strValueOf = String.valueOf(it);
                                                }
                                                StringBuilder sbAppend = sb.append((Object) strValueOf);
                                                String strSubstring = country.substring(1);
                                                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                                string = sbAppend.append(strSubstring).toString();
                                            } else {
                                                string = country;
                                            }
                                            $this$map$iv5 = items2;
                                            int $i$f$mapNotNullTo2 = CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10);
                                            destination$iv$iv10 = new ArrayList($i$f$mapNotNullTo2);
                                            for (Object item$iv$iv8 : $this$map$iv5) {
                                                CleanMedia it7 = (CleanMedia) item$iv$iv8;
                                                destination$iv$iv10.add(toSearchResponse(it7, getMainUrl()));
                                                $this$map$iv5 = $this$map$iv5;
                                            }
                                            homePageList2 = new HomePageList(string, (List) destination$iv$iv10, false);
                                        } else {
                                            $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                                            homePageList2 = null;
                                        }
                                        if (homePageList2 != null) {
                                            destination$iv$iv9.add(homePageList2);
                                        }
                                        $i$f$mapNotNullTo = $i$f$mapNotNullTo;
                                        $this$mapNotNull$iv2 = $this$mapNotNull$iv4;
                                        $i$f$mapNotNull2 = $i$f$mapNotNull4;
                                        groupedByCountry = groupedByCountry2;
                                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                                    }
                                    return MainAPIKt.newHomePageResponse((List) destination$iv$iv9, Boxing.boxBoolean(false));
                                } catch (Exception e10) {
                                    throw new ErrorLoadingException("Failed to parse decrypted JSON: " + e10.getMessage());
                                }
                            } catch (Exception e11) {
                                return MainAPIKt.newHomePageResponse(CollectionsKt.emptyList(), Boxing.boxBoolean(false));
                            }
                        } catch (Exception e12) {
                            e = e12;
                            throw new ErrorLoadingException("Failed to fetch raw response: " + e.getMessage());
                        }
                    } catch (Exception e13) {
                        e = e13;
                        throw new ErrorLoadingException("Failed to fetch raw response: " + e.getMessage());
                    }
                } catch (Exception e14) {
                    e = e14;
                }
                break;
            case 1:
                int page3 = c00022.I$0;
                request2 = (MainPageRequest) c00022.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    str = "vod/filter";
                    obj = null;
                    page2 = page3;
                    z2 = false;
                    rawResponse = ((NiceResponse) $result).getText();
                    decryptedJson = DecryptionKt.decryptString(rawResponse);
                    zStartsWith$default = StringsKt.startsWith$default(request2.getData(), str, z2, 2, obj);
                    str2 = "Unknown";
                    if (zStartsWith$default) {
                        if (StringsKt.startsWith$default(StringsKt.trim(decryptedJson).toString(), "[", z2, 2, obj)) {
                            AppUtils appUtils5 = AppUtils.INSTANCE;
                            Result.Companion companion17 = Result.Companion;
                            z = false;
                            KType kTypeTypeOf5 = Reflection.typeOf(SearchResult[].class, KTypeProjection.Companion.invariant(Reflection.typeOf(SearchResult.class)));
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                            if (Result.exceptionOrNull-impl(obj2) != null) {
                                Result.Companion companion18 = Result.Companion;
                                obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(SearchResult[].class), (List) null, 2, (Object) null));
                            }
                            if (Result.isFailure-impl(obj2)) {
                                obj2 = null;
                            }
                            deserializationStrategy = (KSerializer) obj2;
                            if (deserializationStrategy != null) {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decryptedJson);
                            } else {
                                ObjectMapper $this$readValue$iv$iv13 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv13.readValue(decryptedJson, new TypeReference<SearchResult[]>() { // from class: com.OneTouchTV.OneTouchTV$getMainPage$$inlined$parseJson$1
                                });
                            }
                            parser = ArraysKt.toList((Object[]) objDecodeFromString);
                        } else {
                            z = false;
                            parser = CollectionsKt.emptyList();
                        }
                        $this$map$iv = parser;
                        $i$f$map = 0;
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        while (r11.hasNext()) {
                            result = (SearchResult) item$iv$iv;
                            List parser8 = parser;
                            str3 = str2;
                            Iterable $this$map$iv11 = $this$map$iv;
                            isMovie = StringsKt.equals(result.getType(), "movie", true);
                            if (isMovie) {
                                tvType = TvType.Movie;
                            } else {
                                tvType = TvType.TvSeries;
                            }
                            tvType2 = tvType;
                            if (isMovie) {
                                OneTouchTV oneTouchTV4 = this;
                                title2 = result.getTitle();
                                if (title2 == null) {
                                    str5 = str3;
                                } else {
                                    str5 = title2;
                                }
                                movieSearchResponseNewTvSeriesSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(oneTouchTV4, str5, getMainUrl() + "/vod/" + result.getId() + "/detail", tvType2, false, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj11) {
                                        return OneTouchTV.getMainPage$lambda$0$0(result, (MovieSearchResponse) obj11);
                                    }
                                }, 8, (Object) null);
                            } else {
                                OneTouchTV oneTouchTV5 = this;
                                title = result.getTitle();
                                if (title == null) {
                                    str4 = str3;
                                } else {
                                    str4 = title;
                                }
                                movieSearchResponseNewTvSeriesSearchResponse$default = MainAPIKt.newTvSeriesSearchResponse$default(oneTouchTV5, str4, getMainUrl() + "/vod/" + result.getId() + "/detail", tvType2, false, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj11) {
                                        return OneTouchTV.getMainPage$lambda$0$1(result, (TvSeriesSearchResponse) obj11);
                                    }
                                }, 8, (Object) null);
                            }
                            destination$iv$iv.add((SearchResponse) movieSearchResponseNewTvSeriesSearchResponse$default);
                            parser = parser8;
                            str2 = str3;
                            $this$map$iv = $this$map$iv11;
                            $i$f$map = $i$f$map;
                        }
                        List mapped2 = (List) destination$iv$iv;
                        if (mapped2.isEmpty()) {
                        }
                        break;
                    }
                    if (Intrinsics.areEqual(request2.getData(), "vod/top")) {
                        AppUtils appUtils6 = AppUtils.INSTANCE;
                        Result.Companion companion19 = Result.Companion;
                        KType kTypeTypeOf6 = Reflection.typeOf(OneTouchTVParser.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                        if (Result.exceptionOrNull-impl(obj3) != null) {
                            Result.Companion companion20 = Result.Companion;
                            obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(OneTouchTVParser.class), (List) null, 2, (Object) null));
                            break;
                        }
                        obj4 = obj3;
                        if (Result.isFailure-impl(obj4)) {
                            obj4 = null;
                        }
                        deserializationStrategy2 = (KSerializer) obj4;
                        if (deserializationStrategy2 != null) {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, decryptedJson);
                            break;
                        } else {
                            ObjectMapper $this$readValue$iv$iv14 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv14.readValue(decryptedJson, new TypeReference<OneTouchTVParser>() { // from class: com.OneTouchTV.OneTouchTV$getMainPage$$inlined$parseJson$2
                            });
                        }
                        parser2 = (OneTouchTVParser) objDecodeFromString2;
                        homeLists = new ArrayList();
                        day = parser2.getDay();
                        if (day == null) {
                            parser3 = parser2;
                        } else {
                            if (((Collection) day).isEmpty()) {
                                day = null;
                            }
                            if (day != null) {
                                i3 = 0;
                                Iterable $this$map$iv12 = day;
                                $i$f$map2 = 0;
                                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv12, 10));
                                while (r14.hasNext()) {
                                    OneTouchTVParser parser9 = parser2;
                                    OneTouchTVParser.Day item4 = (OneTouchTVParser.Day) item$iv$iv2;
                                    destination$iv$iv4.add(toSearchResponse(toMedia(item4)));
                                    parser2 = parser9;
                                    $i$f$map2 = $i$f$map2;
                                    i3 = i3;
                                }
                                parser3 = parser2;
                                Boxing.boxBoolean(homeLists.add(new HomePageList("Top - Day", (List) destination$iv$iv4, false, 4, (DefaultConstructorMarker) null)));
                            } else {
                                parser3 = parser2;
                            }
                        }
                        week = parser3.getWeek();
                        if (week != null) {
                            if (((Collection) week).isEmpty()) {
                                week = null;
                            }
                            if (week != null) {
                                i2 = 0;
                                $this$map$iv3 = week;
                                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                                while (r14.hasNext()) {
                                    int i6 = i2;
                                    OneTouchTVParser.Week item5 = (OneTouchTVParser.Week) item$iv$iv3;
                                    destination$iv$iv3.add(toSearchResponse(toMedia(item5)));
                                    i2 = i6;
                                    $this$map$iv3 = $this$map$iv3;
                                }
                                Boxing.boxBoolean(homeLists.add(new HomePageList("Top - Week", (List) destination$iv$iv3, false, 4, (DefaultConstructorMarker) null)));
                            }
                        }
                        month = parser3.getMonth();
                        if (month != null) {
                            if (((Collection) month).isEmpty()) {
                                month = null;
                            }
                            if (month != null) {
                                i = 0;
                                $this$map$iv2 = month;
                                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                                while (r14.hasNext()) {
                                    int i7 = i;
                                    OneTouchTVParser.Month item6 = (OneTouchTVParser.Month) item$iv$iv4;
                                    destination$iv$iv2.add(toSearchResponse(toMedia(item6)));
                                    i = i7;
                                    $this$map$iv2 = $this$map$iv2;
                                }
                                Boxing.boxBoolean(homeLists.add(new HomePageList("Top - Month", (List) destination$iv$iv2, false, 4, (DefaultConstructorMarker) null)));
                            }
                        }
                        return MainAPIKt.newHomePageResponse(homeLists, Boxing.boxBoolean(false));
                    }
                    if (Intrinsics.areEqual(request2.getData(), "tv/channels")) {
                        AppUtils appUtils7 = AppUtils.INSTANCE;
                        Result.Companion companion21 = Result.Companion;
                        KType kTypeTypeOf7 = Reflection.typeOf(ChannelResponse.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf7));
                        if (Result.exceptionOrNull-impl(obj5) != null) {
                            Result.Companion companion110 = Result.Companion;
                            obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ChannelResponse.class), (List) null, 2, (Object) null));
                            break;
                        }
                        obj6 = obj5;
                        if (Result.isFailure-impl(obj6)) {
                            obj6 = null;
                        }
                        deserializationStrategy3 = (KSerializer) obj6;
                        if (deserializationStrategy3 != null) {
                            objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, decryptedJson);
                            break;
                        } else {
                            ObjectMapper $this$readValue$iv$iv15 = MainAPIKt.getMapper();
                            objDecodeFromString3 = $this$readValue$iv$iv15.readValue(decryptedJson, new TypeReference<ChannelResponse>() { // from class: com.OneTouchTV.OneTouchTV$getMainPage$$inlined$parseJson$3
                            });
                        }
                        parser4 = (ChannelResponse) objDecodeFromString3;
                        channels = parser4.getChannels();
                        if (channels != null) {
                            Iterable $this$groupBy$iv3 = channels;
                            destination$iv$iv5 = new LinkedHashMap();
                            while (r11.hasNext()) {
                                ChannelItem it8 = (ChannelItem) element$iv$iv;
                                category2 = it8.getCategory();
                                if (category2 == null) {
                                    category2 = "Other";
                                }
                                str6 = category2;
                                value$iv$iv$iv = destination$iv$iv5.get(str6);
                                if (value$iv$iv$iv == null) {
                                    answer$iv$iv$iv = new ArrayList();
                                    destination$iv$iv5.put(str6, answer$iv$iv$iv);
                                } else {
                                    answer$iv$iv$iv = value$iv$iv$iv;
                                }
                                ((List) answer$iv$iv$iv).add(element$iv$iv);
                                parser4 = parser4;
                            }
                        } else {
                            destination$iv$iv5 = MapsKt.emptyMap();
                        }
                        $this$mapNotNull$iv = destination$iv$iv5;
                        $i$f$mapNotNull = 0;
                        destination$iv$iv6 = new ArrayList();
                        while (r14.hasNext()) {
                            Map $this$mapNotNull$iv5 = $this$mapNotNull$iv;
                            category = (String) element$iv$iv$iv.getKey();
                            items = (List) element$iv$iv$iv.getValue();
                            if (items.isEmpty()) {
                                homePageList = null;
                            } else {
                                String str9 = category + " Live";
                                $this$map$iv4 = items;
                                destination$iv$iv7 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                                $this$mapTo$iv$iv = $this$map$iv4;
                                $i$f$mapTo = 0;
                                while (r32.hasNext()) {
                                    Iterable $this$map$iv13 = $this$map$iv4;
                                    final ChannelItem channel2 = (ChannelItem) item$iv$iv5;
                                    OneTouchTV oneTouchTV6 = this;
                                    title3 = channel2.getTitle();
                                    if (title3 == null) {
                                        title3 = "Unknown";
                                    }
                                    destination$iv$iv7.add(MainAPIKt.newTvSeriesSearchResponse$default(oneTouchTV6, title3, getMainUrl() + "/tv/channels?id=" + channel2.getId(), TvType.Live, false, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda4
                                        public final Object invoke(Object obj11) {
                                            return OneTouchTV.getMainPage$lambda$8$0$0(channel2, (TvSeriesSearchResponse) obj11);
                                        }
                                    }, 8, (Object) null));
                                    $this$map$iv4 = $this$map$iv13;
                                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                                    $i$f$mapTo = $i$f$mapTo;
                                }
                                homePageList = new HomePageList(str9, (List) destination$iv$iv7, false);
                            }
                            if (homePageList != null) {
                                destination$iv$iv6.add(homePageList);
                            }
                            $this$mapNotNull$iv = $this$mapNotNull$iv5;
                            $i$f$mapNotNull = $i$f$mapNotNull;
                            destination$iv$iv5 = destination$iv$iv5;
                            page2 = page2;
                            rawResponse = rawResponse;
                        }
                        return MainAPIKt.newHomePageResponse((List) destination$iv$iv6, Boxing.boxBoolean(false));
                    }
                    AppUtils appUtils8 = AppUtils.INSTANCE;
                    Result.Companion companion111 = Result.Companion;
                    KType kTypeTypeOf8 = Reflection.typeOf(MediaResult.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj7 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf8));
                    if (Result.exceptionOrNull-impl(obj7) == null) {
                        Result.Companion companion112 = Result.Companion;
                        obj8 = null;
                        obj7 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(MediaResult.class), (List) null, 2, (Object) null));
                        break;
                    } else {
                        obj8 = null;
                    }
                    obj9 = obj7;
                    if (Result.isFailure-impl(obj9)) {
                        obj9 = obj8;
                    }
                    deserializationStrategy4 = (KSerializer) obj9;
                    if (deserializationStrategy4 != null) {
                        objDecodeFromString4 = MainAPIKt.getJson().decodeFromString(deserializationStrategy4, decryptedJson);
                        break;
                    } else {
                        ObjectMapper $this$readValue$iv$iv16 = MainAPIKt.getMapper();
                        objDecodeFromString4 = $this$readValue$iv$iv16.readValue(decryptedJson, new TypeReference<MediaResult>() { // from class: com.OneTouchTV.OneTouchTV$getMainPage$$inlined$parseJson$4
                        });
                    }
                    parser5 = (MediaResult) objDecodeFromString4;
                    List $this$getMainPage_u24lambda_u2410 = CollectionsKt.createListBuilder();
                    randomSlideShow = parser5.getRandomSlideShow();
                    if (randomSlideShow != null) {
                        Iterable $this$map$iv14 = randomSlideShow;
                        destination$iv$iv12 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv14, 10));
                        while (r14.hasNext()) {
                            RandomSlideShow it9 = (RandomSlideShow) item$iv$iv6;
                            destination$iv$iv12.add(toCleanMedia(it9));
                        }
                        collectionEmptyList = (List) destination$iv$iv12;
                    } else {
                        collectionEmptyList = CollectionsKt.emptyList();
                    }
                    $this$getMainPage_u24lambda_u2410.addAll(collectionEmptyList);
                    recents = parser5.getRecents();
                    if (recents != null) {
                        Iterable $this$map$iv15 = recents;
                        destination$iv$iv11 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv15, 10));
                        while (r13.hasNext()) {
                            Recent it10 = (Recent) item$iv$iv7;
                            destination$iv$iv11.add(toCleanMedia(it10));
                        }
                        collectionEmptyList2 = (List) destination$iv$iv11;
                    } else {
                        collectionEmptyList2 = CollectionsKt.emptyList();
                    }
                    $this$getMainPage_u24lambda_u2410.addAll(collectionEmptyList2);
                    allRawMedia = CollectionsKt.build($this$getMainPage_u24lambda_u2410);
                    List $this$distinctBy$iv2 = allRawMedia;
                    set$iv = new HashSet();
                    list$iv = new ArrayList();
                    while (r9.hasNext()) {
                        it2 = (CleanMedia) e$iv;
                        id = it2.getId();
                        if (id == null) {
                            id = it2.getTitle();
                        }
                        if (set$iv.add(id)) {
                            list$iv.add(e$iv);
                        }
                    }
                    uniqueMedia = list$iv;
                    ArrayList $this$filter$iv2 = uniqueMedia;
                    destination$iv$iv8 = new ArrayList();
                    while (r11.hasNext()) {
                        media = (CleanMedia) element$iv$iv2;
                        if (MainAPI.Companion.getSettingsForProvider().getEnableAdult()) {
                            type = media.getType();
                            if (type != null) {
                                zContains = StringsKt.contains(type, "RAW", true);
                            } else {
                                zContains = false;
                            }
                            if (!zContains) {
                                z4 = false;
                            }
                            if (z4) {
                                destination$iv$iv8.add(element$iv$iv2);
                            }
                            parser5 = parser5;
                            uniqueMedia = uniqueMedia;
                            allRawMedia = allRawMedia;
                        } else {
                            parser5 = parser5;
                            allRawMedia = allRawMedia;
                            uniqueMedia = uniqueMedia;
                        }
                        z4 = true;
                        if (z4) {
                            destination$iv$iv8.add(element$iv$iv2);
                        }
                        parser5 = parser5;
                        uniqueMedia = uniqueMedia;
                        allRawMedia = allRawMedia;
                    }
                    list$iv$iv = (List) destination$iv$iv8;
                    List $this$groupBy$iv4 = list$iv$iv;
                    groupedByCountry = new LinkedHashMap();
                    while (r9.hasNext()) {
                        CleanMedia it11 = (CleanMedia) element$iv$iv3;
                        country2 = it11.getCountry();
                        if (country2 != null) {
                            lowerCase = "unknown";
                        } else {
                            lowerCase = "unknown";
                        }
                        str7 = lowerCase;
                        value$iv$iv$iv2 = groupedByCountry.get(str7);
                        if (value$iv$iv$iv2 == null) {
                            answer$iv$iv$iv2 = new ArrayList();
                            groupedByCountry.put(str7, answer$iv$iv$iv2);
                        } else {
                            answer$iv$iv$iv2 = value$iv$iv$iv2;
                        }
                        ((List) answer$iv$iv$iv2).add(element$iv$iv3);
                        list$iv$iv = list$iv$iv;
                    }
                    $this$mapNotNull$iv2 = groupedByCountry;
                    $i$f$mapNotNull2 = 0;
                    destination$iv$iv9 = new ArrayList();
                    $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv2;
                    $i$f$mapNotNullTo = 0;
                    while (r11.hasNext()) {
                        Map $this$mapNotNull$iv6 = $this$mapNotNull$iv2;
                        country = (String) element$iv$iv$iv2.getKey();
                        items2 = (List) element$iv$iv$iv2.getValue();
                        int $i$f$mapNotNull5 = $i$f$mapNotNull2;
                        $i$f$mapNotNull3 = items2.size();
                        Map groupedByCountry3 = groupedByCountry;
                        if ($i$f$mapNotNull3 > 4) {
                            if (country.length() > 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                StringBuilder sb2 = new StringBuilder();
                                it = country.charAt(0);
                                if (Character.isLowerCase(it)) {
                                    strValueOf = CharsKt.titlecase(it);
                                } else {
                                    strValueOf = String.valueOf(it);
                                }
                                StringBuilder sbAppend2 = sb2.append((Object) strValueOf);
                                String strSubstring2 = country.substring(1);
                                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                                string = sbAppend2.append(strSubstring2).toString();
                            } else {
                                string = country;
                            }
                            $this$map$iv5 = items2;
                            int $i$f$mapNotNullTo3 = CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10);
                            destination$iv$iv10 = new ArrayList($i$f$mapNotNullTo3);
                            while (r35.hasNext()) {
                                CleanMedia it12 = (CleanMedia) item$iv$iv8;
                                destination$iv$iv10.add(toSearchResponse(it12, getMainUrl()));
                                $this$map$iv5 = $this$map$iv5;
                            }
                            homePageList2 = new HomePageList(string, (List) destination$iv$iv10, false);
                        } else {
                            $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                            homePageList2 = null;
                        }
                        if (homePageList2 != null) {
                            destination$iv$iv9.add(homePageList2);
                        }
                        $i$f$mapNotNullTo = $i$f$mapNotNullTo;
                        $this$mapNotNull$iv2 = $this$mapNotNull$iv6;
                        $i$f$mapNotNull2 = $i$f$mapNotNull5;
                        groupedByCountry = groupedByCountry3;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                    }
                    return MainAPIKt.newHomePageResponse((List) destination$iv$iv9, Boxing.boxBoolean(false));
                } catch (Exception e15) {
                    e = e15;
                    throw new ErrorLoadingException("Failed to fetch raw response: " + e.getMessage());
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$0$0(SearchResult $result, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($result.getImage());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$0$1(SearchResult $result, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($result.getImage());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$8$0$0(ChannelItem $channel, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($channel.getLogo());
        return Unit.INSTANCE;
    }

    private final OneTouchMedia toMedia(OneTouchTVParser.Day $this$toMedia) {
        String title = $this$toMedia.getTitle();
        if (title == null) {
            title = "Unknown Title";
        }
        String id = $this$toMedia.getId();
        if (id == null) {
            id = "0";
        }
        return new OneTouchMedia(title, id, $this$toMedia.getImage(), $this$toMedia.getType(), $this$toMedia.getCountry(), $this$toMedia.getYear(), $this$toMedia.getStatus(), $this$toMedia.isSub());
    }

    private final OneTouchMedia toMedia(OneTouchTVParser.Week $this$toMedia) {
        String title = $this$toMedia.getTitle();
        if (title == null) {
            title = "Unknown Title";
        }
        String id = $this$toMedia.getId();
        if (id == null) {
            id = "0";
        }
        return new OneTouchMedia(title, id, $this$toMedia.getImage(), $this$toMedia.getType(), $this$toMedia.getCountry(), $this$toMedia.getYear(), $this$toMedia.getStatus(), $this$toMedia.isSub());
    }

    private final OneTouchMedia toMedia(OneTouchTVParser.Month $this$toMedia) {
        String title = $this$toMedia.getTitle();
        if (title == null) {
            title = "Unknown Title";
        }
        String id = $this$toMedia.getId();
        if (id == null) {
            id = "0";
        }
        return new OneTouchMedia(title, id, $this$toMedia.getImage(), $this$toMedia.getType(), $this$toMedia.getCountry(), $this$toMedia.getYear(), $this$toMedia.getStatus(), $this$toMedia.isSub());
    }

    private final SearchResponse toSearchResponse(final OneTouchMedia $this$toSearchResponse) {
        boolean isMovie = StringsKt.equals($this$toSearchResponse.getType(), "movie", true);
        TvType tvType = isMovie ? TvType.Movie : TvType.TvSeries;
        return isMovie ? MainAPIKt.newMovieSearchResponse$default(this, $this$toSearchResponse.getTitle(), getMainUrl() + "/vod/" + $this$toSearchResponse.getId() + "/detail", tvType, false, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return OneTouchTV.toSearchResponse$lambda$0($this$toSearchResponse, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null) : MainAPIKt.newTvSeriesSearchResponse$default(this, $this$toSearchResponse.getTitle(), getMainUrl() + "/vod/" + $this$toSearchResponse.getId() + "/detail", tvType, false, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return OneTouchTV.toSearchResponse$lambda$1($this$toSearchResponse, (TvSeriesSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResponse$lambda$0(OneTouchMedia $this_toSearchResponse, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($this_toSearchResponse.getImage());
        return Unit.INSTANCE;
    }

    static final Unit toSearchResponse$lambda$1(OneTouchMedia $this_toSearchResponse, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($this_toSearchResponse.getImage());
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: OneTouchTV.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003Je\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0014\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016¨\u0006%"}, d2 = {"Lcom/OneTouchTV/OneTouchTV$OneTouchMedia;", "", "title", "", "id", "image", "type", "country", "year", "status", "isSub", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getTitle", "()Ljava/lang/String;", "getId", "getImage", "getType", "getCountry", "getYear", "getStatus", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class OneTouchMedia {

        @Nullable
        private final String country;

        @Nullable
        private final String id;

        @Nullable
        private final String image;
        private final boolean isSub;

        @Nullable
        private final String status;

        @NotNull
        private final String title;

        @Nullable
        private final String type;

        @Nullable
        private final String year;

        public OneTouchMedia() {
            this(null, null, null, null, null, null, null, false, 255, null);
        }

        public static /* synthetic */ OneTouchMedia copy$default(OneTouchMedia oneTouchMedia, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = oneTouchMedia.title;
            }
            if ((i & 2) != 0) {
                str2 = oneTouchMedia.id;
            }
            if ((i & 4) != 0) {
                str3 = oneTouchMedia.image;
            }
            if ((i & 8) != 0) {
                str4 = oneTouchMedia.type;
            }
            if ((i & 16) != 0) {
                str5 = oneTouchMedia.country;
            }
            if ((i & 32) != 0) {
                str6 = oneTouchMedia.year;
            }
            if ((i & 64) != 0) {
                str7 = oneTouchMedia.status;
            }
            if ((i & 128) != 0) {
                z = oneTouchMedia.isSub;
            }
            String str8 = str7;
            boolean z2 = z;
            String str9 = str5;
            String str10 = str6;
            return oneTouchMedia.copy(str, str2, str3, str4, str9, str10, str8, z2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getCountry() {
            return this.country;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getIsSub() {
            return this.isSub;
        }

        @NotNull
        public final OneTouchMedia copy(@NotNull String title, @Nullable String id, @Nullable String image, @Nullable String type, @Nullable String country, @Nullable String year, @Nullable String status, boolean isSub) {
            return new OneTouchMedia(title, id, image, type, country, year, status, isSub);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OneTouchMedia)) {
                return false;
            }
            OneTouchMedia oneTouchMedia = (OneTouchMedia) other;
            return Intrinsics.areEqual(this.title, oneTouchMedia.title) && Intrinsics.areEqual(this.id, oneTouchMedia.id) && Intrinsics.areEqual(this.image, oneTouchMedia.image) && Intrinsics.areEqual(this.type, oneTouchMedia.type) && Intrinsics.areEqual(this.country, oneTouchMedia.country) && Intrinsics.areEqual(this.year, oneTouchMedia.year) && Intrinsics.areEqual(this.status, oneTouchMedia.status) && this.isSub == oneTouchMedia.isSub;
        }

        public int hashCode() {
            return (((((((((((((this.title.hashCode() * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.country == null ? 0 : this.country.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.status != null ? this.status.hashCode() : 0)) * 31) + OneTouchTV$OneTouchMedia$$ExternalSyntheticBackport0.m0m(this.isSub);
        }

        @NotNull
        public String toString() {
            return "OneTouchMedia(title=" + this.title + ", id=" + this.id + ", image=" + this.image + ", type=" + this.type + ", country=" + this.country + ", year=" + this.year + ", status=" + this.status + ", isSub=" + this.isSub + ')';
        }

        public OneTouchMedia(@NotNull String title, @Nullable String id, @Nullable String image, @Nullable String type, @Nullable String country, @Nullable String year, @Nullable String status, boolean isSub) {
            this.title = title;
            this.id = id;
            this.image = image;
            this.type = type;
            this.country = country;
            this.year = year;
            this.status = status;
            this.isSub = isSub;
        }

        public /* synthetic */ OneTouchMedia(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "Unknown Title" : str, (i & 2) != 0 ? "0" : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? false : z);
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getImage() {
            return this.image;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getCountry() {
            return this.country;
        }

        @Nullable
        public final String getYear() {
            return this.year;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        public final boolean isSub() {
            return this.isSub;
        }
    }

    private final CleanMedia toCleanMedia(RandomSlideShow $this$toCleanMedia) {
        String id2 = $this$toCleanMedia.getId2();
        if (id2 == null) {
            id2 = $this$toCleanMedia.getId();
        }
        String title = $this$toCleanMedia.getTitle();
        String image = $this$toCleanMedia.getImage();
        String country = $this$toCleanMedia.getCountry();
        String type = $this$toCleanMedia.getType();
        String year = $this$toCleanMedia.getYear();
        String status = $this$toCleanMedia.getStatus();
        Boolean boolIsSub = $this$toCleanMedia.isSub();
        return new CleanMedia(id2, title, image, country, type, year, status, Boolean.valueOf(boolIsSub != null ? boolIsSub.booleanValue() : false));
    }

    private final CleanMedia toCleanMedia(Recent $this$toCleanMedia) {
        String id2 = $this$toCleanMedia.getId2();
        if (id2 == null) {
            id2 = $this$toCleanMedia.getId();
        }
        String title = $this$toCleanMedia.getTitle();
        String image = $this$toCleanMedia.getImage();
        String country = $this$toCleanMedia.getCountry();
        String type = $this$toCleanMedia.getType();
        String year = $this$toCleanMedia.getYear();
        String status = $this$toCleanMedia.getStatus();
        Boolean boolIsSub = $this$toCleanMedia.isSub();
        return new CleanMedia(id2, title, image, country, type, year, status, Boolean.valueOf(boolIsSub != null ? boolIsSub.booleanValue() : false));
    }

    private final SearchResponse toSearchResponse(final CleanMedia $this$toSearchResponse, String mainUrl) {
        String str;
        boolean isMovie = StringsKt.equals($this$toSearchResponse.getType(), "movie", true);
        TvType tvType = isMovie ? TvType.Movie : TvType.TvSeries;
        if (isMovie) {
            OneTouchTV oneTouchTV = this;
            String title = $this$toSearchResponse.getTitle();
            str = title != null ? title : "Unknown";
            StringBuilder sbAppend = new StringBuilder().append(mainUrl).append("/vod/");
            String id = $this$toSearchResponse.getId();
            return MainAPIKt.newMovieSearchResponse$default(oneTouchTV, str, sbAppend.append(id != null ? id : "").append("/detail").toString(), tvType, false, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda9
                public final Object invoke(Object obj) {
                    return OneTouchTV.toSearchResponse$lambda$2($this$toSearchResponse, (MovieSearchResponse) obj);
                }
            }, 8, (Object) null);
        }
        OneTouchTV oneTouchTV2 = this;
        String title2 = $this$toSearchResponse.getTitle();
        str = title2 != null ? title2 : "Unknown";
        StringBuilder sbAppend2 = new StringBuilder().append(mainUrl).append("/vod/");
        String id2 = $this$toSearchResponse.getId();
        return MainAPIKt.newTvSeriesSearchResponse$default(oneTouchTV2, str, sbAppend2.append(id2 != null ? id2 : "").append("/detail").toString(), tvType, false, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                return OneTouchTV.toSearchResponse$lambda$3($this$toSearchResponse, (TvSeriesSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResponse$lambda$2(CleanMedia $this_toSearchResponse, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($this_toSearchResponse.getImage());
        return Unit.INSTANCE;
    }

    static final Unit toSearchResponse$lambda$3(CleanMedia $this_toSearchResponse, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($this_toSearchResponse.getImage());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:102:0x0542  */
    /* JADX WARN: Code duplicated, block: B:115:0x0576  */
    /* JADX WARN: Code duplicated, block: B:127:0x059c A[Catch: Exception -> 0x1038, TRY_ENTER, TryCatch #4 {Exception -> 0x1038, blocks: (B:94:0x0516, B:100:0x053c, B:113:0x0570, B:116:0x0577, B:128:0x05b1, B:127:0x059c, B:112:0x0565, B:99:0x0532, B:96:0x051b), top: B:419:0x0516, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x05ba  */
    /* JADX WARN: Code duplicated, block: B:134:0x05c4  */
    /* JADX WARN: Code duplicated, block: B:150:0x05fc  */
    /* JADX WARN: Code duplicated, block: B:152:0x0602  */
    /* JADX WARN: Code duplicated, block: B:155:0x060b  */
    /* JADX WARN: Code duplicated, block: B:158:0x0613  */
    /* JADX WARN: Code duplicated, block: B:159:0x0618  */
    /* JADX WARN: Code duplicated, block: B:162:0x061f  */
    /* JADX WARN: Code duplicated, block: B:166:0x064d  */
    /* JADX WARN: Code duplicated, block: B:168:0x0663  */
    /* JADX WARN: Code duplicated, block: B:169:0x0666  */
    /* JADX WARN: Code duplicated, block: B:172:0x0670  */
    /* JADX WARN: Code duplicated, block: B:173:0x0673  */
    /* JADX WARN: Code duplicated, block: B:178:0x06bf  */
    /* JADX WARN: Code duplicated, block: B:180:0x06d3  */
    /* JADX WARN: Code duplicated, block: B:181:0x06d6  */
    /* JADX WARN: Code duplicated, block: B:183:0x06da  */
    /* JADX WARN: Code duplicated, block: B:184:0x071e  */
    /* JADX WARN: Code duplicated, block: B:200:0x0788  */
    /* JADX WARN: Code duplicated, block: B:202:0x078b  */
    /* JADX WARN: Code duplicated, block: B:212:0x07b1  */
    /* JADX WARN: Code duplicated, block: B:215:0x07b5  */
    /* JADX WARN: Code duplicated, block: B:219:0x07ff A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:220:0x0800  */
    /* JADX WARN: Code duplicated, block: B:223:0x0815 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:233:0x08d4  */
    /* JADX WARN: Code duplicated, block: B:235:0x08ea A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:236:0x08f7  */
    /* JADX WARN: Code duplicated, block: B:241:0x0914  */
    /* JADX WARN: Code duplicated, block: B:242:0x0919  */
    /* JADX WARN: Code duplicated, block: B:245:0x091f  */
    /* JADX WARN: Code duplicated, block: B:246:0x092c  */
    /* JADX WARN: Code duplicated, block: B:249:0x097a  */
    /* JADX WARN: Code duplicated, block: B:265:0x0a49 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:266:0x0a4a  */
    /* JADX WARN: Code duplicated, block: B:279:0x0aa1  */
    /* JADX WARN: Code duplicated, block: B:295:0x0aee  */
    /* JADX WARN: Code duplicated, block: B:308:0x0b15 A[Catch: Exception -> 0x0e24, TRY_ENTER, TryCatch #15 {Exception -> 0x0e24, blocks: (B:293:0x0ae8, B:296:0x0aef, B:309:0x0b2e, B:308:0x0b15, B:292:0x0ade), top: B:436:0x0ade }] */
    /* JADX WARN: Code duplicated, block: B:315:0x0b4a A[Catch: Exception -> 0x0b79, TRY_LEAVE, TryCatch #36 {Exception -> 0x0b79, blocks: (B:312:0x0b3d, B:313:0x0b44, B:315:0x0b4a), top: B:469:0x0b3d }] */
    /* JADX WARN: Code duplicated, block: B:322:0x0b9e  */
    /* JADX WARN: Code duplicated, block: B:325:0x0baa A[Catch: Exception -> 0x0bd1, TRY_ENTER, TryCatch #29 {Exception -> 0x0bd1, blocks: (B:317:0x0b62, B:318:0x0b70, B:325:0x0baa, B:326:0x0bb1, B:328:0x0bb7, B:329:0x0bcc, B:335:0x0bfa, B:336:0x0c01, B:338:0x0c07, B:339:0x0c1c, B:344:0x0c42), top: B:455:0x0b62 }] */
    /* JADX WARN: Code duplicated, block: B:328:0x0bb7 A[Catch: Exception -> 0x0bd1, LOOP:0: B:326:0x0bb1->B:328:0x0bb7, LOOP_END, TryCatch #29 {Exception -> 0x0bd1, blocks: (B:317:0x0b62, B:318:0x0b70, B:325:0x0baa, B:326:0x0bb1, B:328:0x0bb7, B:329:0x0bcc, B:335:0x0bfa, B:336:0x0c01, B:338:0x0c07, B:339:0x0c1c, B:344:0x0c42), top: B:455:0x0b62 }] */
    /* JADX WARN: Code duplicated, block: B:335:0x0bfa A[Catch: Exception -> 0x0bd1, TRY_ENTER, TryCatch #29 {Exception -> 0x0bd1, blocks: (B:317:0x0b62, B:318:0x0b70, B:325:0x0baa, B:326:0x0bb1, B:328:0x0bb7, B:329:0x0bcc, B:335:0x0bfa, B:336:0x0c01, B:338:0x0c07, B:339:0x0c1c, B:344:0x0c42), top: B:455:0x0b62 }] */
    /* JADX WARN: Code duplicated, block: B:338:0x0c07 A[Catch: Exception -> 0x0bd1, LOOP:1: B:336:0x0c01->B:338:0x0c07, LOOP_END, TryCatch #29 {Exception -> 0x0bd1, blocks: (B:317:0x0b62, B:318:0x0b70, B:325:0x0baa, B:326:0x0bb1, B:328:0x0bb7, B:329:0x0bcc, B:335:0x0bfa, B:336:0x0c01, B:338:0x0c07, B:339:0x0c1c, B:344:0x0c42), top: B:455:0x0b62 }] */
    /* JADX WARN: Code duplicated, block: B:344:0x0c42 A[Catch: Exception -> 0x0bd1, TRY_ENTER, TRY_LEAVE, TryCatch #29 {Exception -> 0x0bd1, blocks: (B:317:0x0b62, B:318:0x0b70, B:325:0x0baa, B:326:0x0bb1, B:328:0x0bb7, B:329:0x0bcc, B:335:0x0bfa, B:336:0x0c01, B:338:0x0c07, B:339:0x0c1c, B:344:0x0c42), top: B:455:0x0b62 }] */
    /* JADX WARN: Code duplicated, block: B:349:0x0c6c  */
    /* JADX WARN: Code duplicated, block: B:351:0x0c74  */
    /* JADX WARN: Code duplicated, block: B:355:0x0c7d  */
    /* JADX WARN: Code duplicated, block: B:358:0x0d1d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:359:0x0d1e  */
    /* JADX WARN: Code duplicated, block: B:361:0x0d2b  */
    /* JADX WARN: Code duplicated, block: B:363:0x0dd3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:364:0x0dd4  */
    /* JADX WARN: Code duplicated, block: B:413:0x0545 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:417:0x03c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:465:0x0aa9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:469:0x0b3d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:473:0x03fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:475:0x057d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:477:0x0af5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:485:0x097e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:493:0x044e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0412  */
    /* JADX WARN: Code duplicated, block: B:60:0x042f  */
    /* JADX WARN: Code duplicated, block: B:63:0x043b  */
    /* JADX WARN: Code duplicated, block: B:69:0x0453  */
    /* JADX WARN: Code duplicated, block: B:71:0x045d  */
    /* JADX WARN: Code duplicated, block: B:74:0x046c  */
    /* JADX WARN: Code duplicated, block: B:77:0x04b5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:78:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws Exception {
        C00031 c00031;
        Object obj;
        String str;
        String str2;
        String url2;
        Object obj2;
        int i;
        String channelId;
        String url3;
        String rawResponse;
        String decryptedJson;
        Object obj3;
        Object obj4;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        ChannelResponse channelParser;
        List<ChannelItem> channels;
        Iterator<T> it;
        Object next;
        ChannelItem channel;
        String title;
        String streamingUrl;
        String decryptedJson2;
        Object obj5;
        Object obj6;
        DeserializationStrategy deserializationStrategy2;
        Object objDecodeFromString2;
        LoadData parser;
        String title2;
        String poster;
        String poster2;
        String backgroundposter;
        String description;
        String year;
        Integer year2;
        String status;
        ShowStatus status2;
        Iterable $this$map$iv;
        String rawResponse2;
        String decryptedJson3;
        Collection destination$iv$iv;
        Iterable $this$mapTo$iv$iv;
        List actors;
        Iterable $this$map$iv2;
        Collection destination$iv$iv2;
        Iterable $this$mapTo$iv$iv2;
        List tags;
        boolean isMovie;
        Regex seasonRegex;
        MatchResult seasonMatch;
        int extractedSeason;
        Integer intOrNull;
        List groupValues;
        OneTouchTV oneTouchTV;
        Object objFetchTmdbData;
        Object $result;
        Object obj7;
        LoadData parser2;
        MatchResult seasonMatch2;
        List actors2;
        List actors3;
        ShowStatus status3;
        boolean isMovie2;
        Regex seasonRegex2;
        List groupValues2;
        Integer intOrNull2;
        String it2;
        boolean z;
        String string;
        String name;
        String str3;
        String image;
        String str4;
        TmdbData tmdbData;
        Object obj8;
        TmdbData tmdbData2;
        final int extractedSeason2;
        Integer year3;
        List actors4;
        String poster3;
        String description2;
        List tags2;
        String decryptedJson4;
        Map mapEmptyMap;
        String title3;
        boolean isMovie3;
        ShowStatus status4;
        String url4;
        Regex seasonRegex3;
        LoadData parser3;
        String rawResponse3;
        MatchResult seasonMatch3;
        String url5;
        TmdbData tmdbData3;
        Regex seasonRegex4;
        int extractedSeason3;
        String decryptedJson5;
        String description3;
        Map tmdbEpisodes;
        Collection destination$iv$iv3;
        TmdbData tmdbData4;
        List tags3;
        List actors5;
        Map tmdbEpisodes2;
        boolean isMovie4;
        String title4;
        ShowStatus status5;
        Integer year4;
        String description4;
        String backgroundposter2;
        String poster4;
        List episodes;
        String url6;
        Object obj9;
        int extractedSeason4;
        Object obj10;
        Object obj11;
        int extractedSeason5;
        String url7;
        String description5;
        ShowStatus status6;
        Integer year5;
        String backgroundposter3;
        String poster5;
        boolean isMovie5;
        String url8;
        TmdbData tmdbData5;
        List episodes2;
        List actors6;
        Regex seasonRegex5;
        MatchResult seasonMatch4;
        final EpisodeItem ep;
        String identifier;
        String playId;
        String episode;
        Integer intOrNull3;
        Integer epNum;
        Map tmdbEpisodes3;
        final Integer epNum2;
        TmdbEpisode tmdbEpisode;
        Map tmdbEpisodes4;
        Episode episodeNewEpisode;
        String topJson;
        Object obj12;
        String title5;
        String url9;
        String url10;
        DeserializationStrategy deserializationStrategy3;
        Object objDecodeFromString3;
        OneTouchTVParser topParser;
        List $this$load_u24lambda_u248;
        Iterable $this$forEach$iv;
        Iterator it3;
        OneTouchTVParser topParser2;
        List list;
        Iterable week;
        Iterable month;
        List allMedia;
        List $this$map$iv3;
        Collection destination$iv$iv4;
        List recommendation;
        Object obj13;
        int extractedSeason6;
        Object objNewTvSeriesLoadResponse;
        Object obj14;
        MatchResult seasonMatch5;
        Regex seasonRegex6;
        List episodes3;
        Map tmdbEpisodes5;
        TmdbData tmdbData6;
        String backgroundposter4;
        String poster6;
        List recommendation2;
        Episode episode2;
        String epUrl;
        Object objNewMovieLoadResponse;
        Object obj15;
        String data;
        Iterable $this$forEach$iv2;
        Iterable $this$forEach$iv3;
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
        Object $result2 = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                if (StringsKt.startsWith$default(url, getMainUrl() + "/tv/channels?id=", false, 2, (Object) null)) {
                    String channelId2 = StringsKt.substringAfter$default(url, "?id=", (String) null, 2, (Object) null);
                    Requests app = MainActivityKt.getApp();
                    String str5 = getMainUrl() + "/tv/channels";
                    c00032.L$0 = url;
                    c00032.L$1 = channelId2;
                    c00032.label = 1;
                    obj2 = coroutine_suspended;
                    i = 2;
                    $result2 = Requests.get$default(app, str5, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00032, 4094, (Object) null);
                    if ($result2 == obj2) {
                        c00032 = c00032;
                        return obj2;
                    }
                    c00032 = c00032;
                    channelId = channelId2;
                    url3 = url;
                    rawResponse = ((NiceResponse) $result2).getText();
                    decryptedJson = DecryptionKt.decryptString(rawResponse);
                    AppUtils appUtils = AppUtils.INSTANCE;
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(ChannelResponse.class);
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
                            obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ChannelResponse.class), (List) null, i, (Object) null));
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
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decryptedJson);
                        } catch (SerializationException e) {
                            ArchComponentExtKt.logError(e);
                            ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv.readValue(decryptedJson, new TypeReference<ChannelResponse>() { // from class: com.OneTouchTV.OneTouchTV$load$$inlined$parseJson$1
                            });
                        } catch (Throwable th3) {
                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv2.readValue(decryptedJson, new TypeReference<ChannelResponse>() { // from class: com.OneTouchTV.OneTouchTV$load$$inlined$parseJson$1
                            });
                        }
                        break;
                    } else {
                        ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv3.readValue(decryptedJson, new TypeReference<ChannelResponse>() { // from class: com.OneTouchTV.OneTouchTV$load$$inlined$parseJson$1
                        });
                    }
                    channelParser = (ChannelResponse) objDecodeFromString;
                    channels = channelParser.getChannels();
                    if (channels != null) {
                        it = channels.iterator();
                        do {
                            if (it.hasNext()) {
                                next = it.next();
                            } else {
                                next = null;
                            }
                            channel = (ChannelItem) next;
                            if (channel != null) {
                                OneTouchTV oneTouchTV2 = this;
                                title = channel.getTitle();
                                if (title == null) {
                                    title = "Unknown";
                                }
                                TvType tvType = TvType.Live;
                                OneTouchTV oneTouchTV3 = this;
                                streamingUrl = channel.getStreamingUrl();
                                if (streamingUrl == null) {
                                    streamingUrl = "";
                                }
                                List listListOf = CollectionsKt.listOf(MainAPIKt.newEpisode(oneTouchTV3, streamingUrl, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda5
                                    public final Object invoke(Object obj16) {
                                        return OneTouchTV.load$lambda$1((Episode) obj16);
                                    }
                                }));
                                C00043 c00043 = new C00043(channel, null);
                                c00032.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                                c00032.L$1 = SpillingKt.nullOutSpilledVariable(channelId);
                                c00032.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse);
                                c00032.L$3 = SpillingKt.nullOutSpilledVariable(decryptedJson);
                                c00032.L$4 = SpillingKt.nullOutSpilledVariable(channelParser);
                                c00032.L$5 = SpillingKt.nullOutSpilledVariable(channel);
                                c00032.label = i;
                                $result2 = MainAPIKt.newTvSeriesLoadResponse(oneTouchTV2, title, url3, tvType, listListOf, c00043, c00032);
                                if ($result2 == obj2) {
                                    return obj2;
                                }
                                return $result2;
                            }
                        } while (!Intrinsics.areEqual(((ChannelItem) next).getId(), channelId));
                        channel = (ChannelItem) next;
                        if (channel != null) {
                            OneTouchTV oneTouchTV4 = this;
                            title = channel.getTitle();
                            if (title == null) {
                                title = "Unknown";
                            }
                            TvType tvType2 = TvType.Live;
                            OneTouchTV oneTouchTV5 = this;
                            streamingUrl = channel.getStreamingUrl();
                            if (streamingUrl == null) {
                                streamingUrl = "";
                            }
                            List listListOf2 = CollectionsKt.listOf(MainAPIKt.newEpisode(oneTouchTV5, streamingUrl, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj16) {
                                    return OneTouchTV.load$lambda$1((Episode) obj16);
                                }
                            }));
                            C00043 c00044 = new C00043(channel, null);
                            c00032.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00032.L$1 = SpillingKt.nullOutSpilledVariable(channelId);
                            c00032.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse);
                            c00032.L$3 = SpillingKt.nullOutSpilledVariable(decryptedJson);
                            c00032.L$4 = SpillingKt.nullOutSpilledVariable(channelParser);
                            c00032.L$5 = SpillingKt.nullOutSpilledVariable(channel);
                            c00032.label = i;
                            $result2 = MainAPIKt.newTvSeriesLoadResponse(oneTouchTV4, title, url3, tvType2, listListOf2, c00044, c00032);
                            if ($result2 == obj2) {
                                return obj2;
                            }
                            return $result2;
                        }
                    }
                    throw new ErrorLoadingException("Channel not found");
                }
                obj = coroutine_suspended;
                try {
                    Requests app2 = MainActivityKt.getApp();
                    c00032.L$0 = url;
                    c00032.label = 3;
                    str = "Failed to parse decrypted JSON: ";
                    str2 = "Failed to decrypt response: ";
                    try {
                        $result2 = Requests.get$default(app2, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00032, 4094, (Object) null);
                        c00032 = c00032;
                        if ($result2 == obj) {
                            return obj;
                        }
                        url2 = url;
                        try {
                            String rawResponse4 = ((NiceResponse) $result2).getText();
                            try {
                                decryptedJson2 = DecryptionKt.decryptString(rawResponse4);
                                try {
                                    AppUtils appUtils2 = AppUtils.INSTANCE;
                                    try {
                                        Result.Companion companion5 = Result.Companion;
                                        KType kTypeTypeOf2 = Reflection.typeOf(LoadData.class);
                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                        obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                        break;
                                    } catch (Throwable th4) {
                                        Result.Companion companion6 = Result.Companion;
                                        obj5 = Result.constructor-impl(ResultKt.createFailure(th4));
                                    }
                                    if (Result.exceptionOrNull-impl(obj5) == null) {
                                        try {
                                            Result.Companion companion7 = Result.Companion;
                                            try {
                                                obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LoadData.class), (List) null, 2, (Object) null));
                                            } catch (Throwable th5) {
                                                th = th5;
                                                Result.Companion companion8 = Result.Companion;
                                                obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                        }
                                        break;
                                    }
                                    obj6 = obj5;
                                    if (Result.isFailure-impl(obj6)) {
                                        obj6 = null;
                                    }
                                    deserializationStrategy2 = (KSerializer) obj6;
                                    if (deserializationStrategy2 != null) {
                                        try {
                                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, decryptedJson2);
                                            break;
                                        } catch (SerializationException e2) {
                                            try {
                                                ArchComponentExtKt.logError(e2);
                                                ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                                objDecodeFromString2 = $this$readValue$iv$iv4.readValue(decryptedJson2, new TypeReference<LoadData>() { // from class: com.OneTouchTV.OneTouchTV$load$$inlined$parseJson$2
                                                });
                                            } catch (Exception e3) {
                                                e = e3;
                                                throw new ErrorLoadingException(str + e.getMessage());
                                            }
                                        } catch (Throwable th7) {
                                            ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                            objDecodeFromString2 = $this$readValue$iv$iv5.readValue(decryptedJson2, new TypeReference<LoadData>() { // from class: com.OneTouchTV.OneTouchTV$load$$inlined$parseJson$2
                                            });
                                        }
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                                        objDecodeFromString2 = $this$readValue$iv$iv6.readValue(decryptedJson2, new TypeReference<LoadData>() { // from class: com.OneTouchTV.OneTouchTV$load$$inlined$parseJson$2
                                        });
                                    }
                                    parser = (LoadData) objDecodeFromString2;
                                    title2 = parser.getTitle();
                                    if (title2 == null) {
                                        title2 = "Unknown Title";
                                    }
                                    poster = parser.getImage();
                                    if (poster == null) {
                                        poster = "null";
                                    }
                                    poster2 = parser.getPoster();
                                    if (poster2 != null || (backgroundposter = StringsKt.replace$default(poster2, "image-7wk.pages.dev", "image-v1.pages.dev", false, 4, (Object) null)) == null) {
                                        backgroundposter = parser.getImage();
                                        if (backgroundposter == null) {
                                            backgroundposter = "";
                                        }
                                    } else {
                                        if (((StringsKt.isBlank(backgroundposter) || Intrinsics.areEqual(backgroundposter, "null")) ? 0 : 1) == 0) {
                                            backgroundposter = null;
                                        }
                                        if (backgroundposter == null) {
                                            backgroundposter = parser.getImage();
                                            if (backgroundposter == null) {
                                                backgroundposter = "";
                                            }
                                        }
                                    }
                                    description = parser.getDescription();
                                    if (description == null) {
                                        description = "";
                                    }
                                    year = parser.getYear();
                                    if (year != null) {
                                        year2 = StringsKt.toIntOrNull(year);
                                    } else {
                                        year2 = null;
                                    }
                                    status = parser.getStatus();
                                    if (status == null) {
                                        status = "";
                                    }
                                    status2 = getStatus(status);
                                    $this$map$iv = parser.getActors();
                                    rawResponse2 = rawResponse4;
                                    decryptedJson3 = decryptedJson2;
                                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                    $this$mapTo$iv$iv = $this$map$iv;
                                    for (Object item$iv$iv : $this$mapTo$iv$iv) {
                                        ActorItem it4 = (ActorItem) item$iv$iv;
                                        name = it4.getName();
                                        Iterable $this$mapTo$iv$iv3 = $this$mapTo$iv$iv;
                                        if (name == null) {
                                            str3 = "";
                                        } else {
                                            str3 = name;
                                        }
                                        image = it4.getImage();
                                        Iterable $this$map$iv4 = $this$map$iv;
                                        if (image == null) {
                                            str4 = "";
                                        } else {
                                            str4 = image;
                                        }
                                        destination$iv$iv.add(new ActorData(new Actor(str3, str4), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                                        $this$mapTo$iv$iv = $this$mapTo$iv$iv3;
                                        $this$map$iv = $this$map$iv4;
                                    }
                                    actors = (List) destination$iv$iv;
                                    $this$map$iv2 = parser.getGenres();
                                    int $i$f$map = CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10);
                                    destination$iv$iv2 = new ArrayList($i$f$map);
                                    $this$mapTo$iv$iv2 = $this$map$iv2;
                                    for (Object item$iv$iv2 : $this$mapTo$iv$iv2) {
                                        it2 = (String) item$iv$iv2;
                                        if (it2.length() > 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            StringBuilder sb = new StringBuilder();
                                            char p0 = it2.charAt(0);
                                            String strValueOf = String.valueOf(p0);
                                            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                                            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                                            StringBuilder sbAppend = sb.append((Object) upperCase);
                                            String strSubstring = it2.substring(1);
                                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                            string = sbAppend.append(strSubstring).toString();
                                        } else {
                                            string = it2;
                                        }
                                        destination$iv$iv2.add(string);
                                        $this$map$iv2 = $this$map$iv2;
                                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv2;
                                        obj = obj;
                                    }
                                    Object obj16 = obj;
                                    tags = (List) destination$iv$iv2;
                                    isMovie = StringsKt.equals(parser.getType(), "movie", true);
                                    seasonRegex = new Regex("(?i)(?:season\\s*(\\d+)|\\bs(\\d+)\\b)");
                                    seasonMatch = Regex.find$default(seasonRegex, title2, 0, 2, (Object) null);
                                    if (seasonMatch == null && (groupValues2 = seasonMatch.getGroupValues()) != null) {
                                        extractedSeason = 1;
                                        String it5 = (String) CollectionsKt.getOrNull(groupValues2, 1);
                                        if (it5 != null) {
                                            if (StringsKt.isBlank(it5)) {
                                                it5 = null;
                                            }
                                            if (it5 != null && (intOrNull2 = StringsKt.toIntOrNull(it5)) != null) {
                                                extractedSeason = intOrNull2.intValue();
                                            }
                                        }
                                        c00032.L$0 = url2;
                                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson3);
                                        c00032.L$3 = parser;
                                        c00032.L$4 = title2;
                                        c00032.L$5 = poster;
                                        c00032.L$6 = backgroundposter;
                                        c00032.L$7 = description;
                                        c00032.L$8 = year2;
                                        c00032.L$9 = status2;
                                        c00032.L$10 = actors;
                                        c00032.L$11 = tags;
                                        c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex);
                                        c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch);
                                        c00032.Z$0 = isMovie;
                                        c00032.I$0 = extractedSeason;
                                        c00032.label = 4;
                                        oneTouchTV = this;
                                        objFetchTmdbData = oneTouchTV.fetchTmdbData(title2, year2, isMovie, c00032);
                                        $result = obj16;
                                        if (objFetchTmdbData == $result) {
                                            return $result;
                                        }
                                        obj7 = objFetchTmdbData;
                                        parser2 = parser;
                                        seasonMatch2 = seasonMatch;
                                        actors2 = actors;
                                        actors3 = tags;
                                        status3 = status2;
                                        isMovie2 = isMovie;
                                        seasonRegex2 = seasonRegex;
                                        tmdbData = (TmdbData) obj7;
                                        if (!isMovie2 || tmdbData == null) {
                                            String url11 = url2;
                                            obj8 = $result;
                                            String str6 = poster;
                                            tmdbData2 = tmdbData;
                                            extractedSeason2 = extractedSeason;
                                            year3 = year2;
                                            actors4 = actors2;
                                            poster3 = str6;
                                            List list2 = actors3;
                                            description2 = description;
                                            tags2 = list2;
                                            decryptedJson4 = decryptedJson3;
                                            mapEmptyMap = MapsKt.emptyMap();
                                            title3 = title2;
                                            isMovie3 = isMovie2;
                                            status4 = status3;
                                            url4 = url11;
                                            seasonRegex3 = seasonRegex2;
                                            parser3 = parser2;
                                            rawResponse3 = rawResponse2;
                                            seasonMatch3 = seasonMatch2;
                                        } else {
                                            Object obj17 = $result;
                                            int id = tmdbData.getId();
                                            c00032.L$0 = url2;
                                            url5 = url2;
                                            c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                                            c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson3);
                                            c00032.L$3 = parser2;
                                            c00032.L$4 = title2;
                                            c00032.L$5 = poster;
                                            c00032.L$6 = backgroundposter;
                                            c00032.L$7 = description;
                                            c00032.L$8 = year2;
                                            c00032.L$9 = status3;
                                            c00032.L$10 = actors2;
                                            c00032.L$11 = actors3;
                                            c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex2);
                                            c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch2);
                                            c00032.L$14 = tmdbData;
                                            c00032.Z$0 = isMovie2;
                                            c00032.I$0 = extractedSeason;
                                            c00032.label = 5;
                                            $result2 = oneTouchTV.fetchTmdbEpisodes(id, extractedSeason, c00032);
                                            obj8 = obj17;
                                            if ($result2 == obj8) {
                                                return obj8;
                                            }
                                            int i2 = extractedSeason;
                                            tmdbData3 = tmdbData;
                                            seasonRegex4 = seasonRegex2;
                                            extractedSeason3 = i2;
                                            decryptedJson5 = decryptedJson3;
                                            description3 = description;
                                            List list3 = actors2;
                                            poster3 = poster;
                                            tmdbData2 = tmdbData3;
                                            year3 = year2;
                                            actors4 = list3;
                                            mapEmptyMap = (Map) $result2;
                                            title3 = title2;
                                            isMovie3 = isMovie2;
                                            tags2 = actors3;
                                            description2 = description3;
                                            decryptedJson4 = decryptedJson5;
                                            status4 = status3;
                                            url4 = url5;
                                            seasonRegex3 = seasonRegex4;
                                            extractedSeason2 = extractedSeason3;
                                            rawResponse3 = rawResponse2;
                                            parser3 = parser2;
                                            seasonMatch3 = seasonMatch2;
                                        }
                                        tmdbEpisodes = mapEmptyMap;
                                        Iterable $this$mapNotNull$iv = parser3.getEpisodes();
                                        destination$iv$iv3 = new ArrayList();
                                        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                            Object obj18 = obj8;
                                            ep = (EpisodeItem) element$iv$iv$iv;
                                            identifier = ep.getIdentifier();
                                            if (identifier == null && (playId = ep.getPlayId()) != null) {
                                                episode = ep.getEpisode();
                                                if (episode != null) {
                                                    intOrNull3 = StringsKt.toIntOrNull(episode);
                                                } else {
                                                    intOrNull3 = null;
                                                }
                                                epNum = intOrNull3;
                                                if (epNum != null) {
                                                    tmdbEpisodes3 = tmdbEpisodes;
                                                    epNum2 = epNum;
                                                    tmdbEpisode = (TmdbEpisode) tmdbEpisodes3.get(epNum2);
                                                } else {
                                                    tmdbEpisodes3 = tmdbEpisodes;
                                                    epNum2 = epNum;
                                                    tmdbEpisode = null;
                                                }
                                                final TmdbEpisode tmdbEp = tmdbEpisode;
                                                tmdbEpisodes4 = tmdbEpisodes3;
                                                episodeNewEpisode = MainAPIKt.newEpisode(this, getMainUrl() + "/vod/" + identifier + "/episode/" + playId, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda6
                                                    public final Object invoke(Object obj19) {
                                                        return OneTouchTV.load$lambda$7$0(tmdbEp, ep, epNum2, extractedSeason2, (Episode) obj19);
                                                    }
                                                });
                                            } else {
                                                tmdbEpisodes4 = tmdbEpisodes;
                                                episodeNewEpisode = null;
                                                isMovie3 = isMovie3;
                                            }
                                            if (episodeNewEpisode != null) {
                                                destination$iv$iv3.add(episodeNewEpisode);
                                            }
                                            isMovie3 = isMovie3;
                                            obj8 = obj18;
                                            tmdbEpisodes = tmdbEpisodes4;
                                            tmdbData2 = tmdbData2;
                                            tags2 = tags2;
                                            actors4 = actors4;
                                        }
                                        Object obj19 = obj8;
                                        tmdbData4 = tmdbData2;
                                        tags3 = tags2;
                                        actors5 = actors4;
                                        tmdbEpisodes2 = tmdbEpisodes;
                                        isMovie4 = isMovie3;
                                        List episodes4 = (List) destination$iv$iv3;
                                        try {
                                            Requests app3 = MainActivityKt.getApp();
                                            String str7 = getMainUrl() + "/vod/top";
                                            c00032.L$0 = url4;
                                            c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                            c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                                            c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                                            c00032.L$4 = title3;
                                            c00032.L$5 = poster3;
                                            c00032.L$6 = backgroundposter;
                                            c00032.L$7 = description2;
                                            c00032.L$8 = year3;
                                            c00032.L$9 = status4;
                                            try {
                                                c00032.L$10 = actors5;
                                                try {
                                                    c00032.L$11 = tags3;
                                                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                                                    c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch3);
                                                    try {
                                                        c00032.L$14 = tmdbData4;
                                                        c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                                                        c00032.L$16 = episodes4;
                                                        try {
                                                            c00032.Z$0 = isMovie4;
                                                            c00032.I$0 = extractedSeason2;
                                                            c00032.label = 6;
                                                            title4 = title3;
                                                            C00031 c00033 = c00032;
                                                            status5 = status4;
                                                            year4 = year3;
                                                            description4 = description2;
                                                            backgroundposter2 = backgroundposter;
                                                            poster4 = poster3;
                                                            episodes = episodes4;
                                                            url6 = url4;
                                                            obj9 = obj19;
                                                            extractedSeason4 = extractedSeason2;
                                                            try {
                                                                obj10 = Requests.get$default(app3, str7, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00033, 4094, (Object) null);
                                                                c00032 = c00033;
                                                                if (obj10 == obj9) {
                                                                    return obj9;
                                                                }
                                                                obj11 = obj10;
                                                                extractedSeason5 = extractedSeason4;
                                                                url7 = title4;
                                                                description5 = description4;
                                                                status6 = status5;
                                                                year5 = year4;
                                                                backgroundposter3 = backgroundposter2;
                                                                poster5 = poster4;
                                                                isMovie5 = isMovie4;
                                                                url8 = url6;
                                                                tmdbData5 = tmdbData4;
                                                                episodes2 = tags3;
                                                                actors6 = actors5;
                                                                seasonRegex5 = seasonRegex3;
                                                                seasonMatch4 = seasonMatch3;
                                                                try {
                                                                    String rawTopResponse = ((NiceResponse) obj11).getText();
                                                                    try {
                                                                        try {
                                                                            topJson = DecryptionKt.decryptString(rawTopResponse);
                                                                            try {
                                                                                AppUtils appUtils3 = AppUtils.INSTANCE;
                                                                                try {
                                                                                    Result.Companion companion9 = Result.Companion;
                                                                                    KType kTypeTypeOf3 = Reflection.typeOf(OneTouchTVParser.class);
                                                                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                                                    obj12 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                                                                } catch (Throwable th8) {
                                                                                    Result.Companion companion10 = Result.Companion;
                                                                                    obj12 = Result.constructor-impl(ResultKt.createFailure(th8));
                                                                                }
                                                                                if (Result.exceptionOrNull-impl(obj12) == null) {
                                                                                    title5 = url7;
                                                                                    url9 = url8;
                                                                                    url10 = null;
                                                                                } else {
                                                                                    try {
                                                                                        Result.Companion companion11 = Result.Companion;
                                                                                        try {
                                                                                            title5 = url7;
                                                                                            url9 = url8;
                                                                                            url10 = null;
                                                                                            try {
                                                                                                obj12 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(OneTouchTVParser.class), (List) null, 2, (Object) null));
                                                                                                break;
                                                                                            } catch (Throwable th9) {
                                                                                                th = th9;
                                                                                                try {
                                                                                                    Result.Companion companion12 = Result.Companion;
                                                                                                    obj12 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                                                } catch (Exception e4) {
                                                                                                    e = e4;
                                                                                                    throw new ErrorLoadingException(str + e.getMessage());
                                                                                                }
                                                                                            }
                                                                                        } catch (Throwable th10) {
                                                                                            th = th10;
                                                                                            title5 = url7;
                                                                                            url9 = url8;
                                                                                            url10 = null;
                                                                                        }
                                                                                    } catch (Throwable th11) {
                                                                                        th = th11;
                                                                                        title5 = url7;
                                                                                        url9 = url8;
                                                                                        url10 = null;
                                                                                    }
                                                                                }
                                                                                if (Result.isFailure-impl(obj12)) {
                                                                                    obj12 = url10;
                                                                                }
                                                                                deserializationStrategy3 = (KSerializer) obj12;
                                                                                if (deserializationStrategy3 != null) {
                                                                                    try {
                                                                                        objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, topJson);
                                                                                        break;
                                                                                    } catch (SerializationException e5) {
                                                                                        try {
                                                                                            ArchComponentExtKt.logError(e5);
                                                                                            ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                                                                                            objDecodeFromString3 = $this$readValue$iv$iv7.readValue(topJson, new TypeReference<OneTouchTVParser>() { // from class: com.OneTouchTV.OneTouchTV$load$$inlined$parseJson$3
                                                                                            });
                                                                                        } catch (Exception e6) {
                                                                                            e = e6;
                                                                                            throw new ErrorLoadingException(str + e.getMessage());
                                                                                        }
                                                                                    } catch (Throwable th12) {
                                                                                        ObjectMapper $this$readValue$iv$iv8 = MainAPIKt.getMapper();
                                                                                        objDecodeFromString3 = $this$readValue$iv$iv8.readValue(topJson, new TypeReference<OneTouchTVParser>() { // from class: com.OneTouchTV.OneTouchTV$load$$inlined$parseJson$3
                                                                                        });
                                                                                    }
                                                                                } else {
                                                                                    ObjectMapper $this$readValue$iv$iv9 = MainAPIKt.getMapper();
                                                                                    objDecodeFromString3 = $this$readValue$iv$iv9.readValue(topJson, new TypeReference<OneTouchTVParser>() { // from class: com.OneTouchTV.OneTouchTV$load$$inlined$parseJson$3
                                                                                    });
                                                                                }
                                                                                topParser = (OneTouchTVParser) objDecodeFromString3;
                                                                                try {
                                                                                    $this$load_u24lambda_u248 = CollectionsKt.createListBuilder();
                                                                                    $this$forEach$iv = topParser.getDay();
                                                                                    if ($this$forEach$iv != null) {
                                                                                        try {
                                                                                            it3 = $this$forEach$iv.iterator();
                                                                                            while (it3.hasNext()) {
                                                                                                Object element$iv = it3.next();
                                                                                                OneTouchTVParser topParser3 = topParser;
                                                                                                List list4 = $this$load_u24lambda_u248;
                                                                                                Iterator it6 = it3;
                                                                                                try {
                                                                                                    $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Day) element$iv));
                                                                                                    topParser = topParser3;
                                                                                                    it3 = it6;
                                                                                                    $this$load_u24lambda_u248 = list4;
                                                                                                } catch (Exception e7) {
                                                                                                    e = e7;
                                                                                                    throw new ErrorLoadingException("Failed to load recommendations: " + e.getMessage());
                                                                                                }
                                                                                            }
                                                                                            topParser2 = topParser;
                                                                                            list = $this$load_u24lambda_u248;
                                                                                            Unit unit = Unit.INSTANCE;
                                                                                        } catch (Exception e8) {
                                                                                            e = e8;
                                                                                            throw new ErrorLoadingException("Failed to load recommendations: " + e.getMessage());
                                                                                        }
                                                                                    } else {
                                                                                        topParser2 = topParser;
                                                                                        list = $this$load_u24lambda_u248;
                                                                                    }
                                                                                    week = topParser2.getWeek();
                                                                                    if (week != null) {
                                                                                        $this$forEach$iv3 = week;
                                                                                        for (Object element$iv2 : $this$forEach$iv3) {
                                                                                            $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Week) element$iv2));
                                                                                            $this$forEach$iv3 = $this$forEach$iv3;
                                                                                        }
                                                                                        Unit unit2 = Unit.INSTANCE;
                                                                                    }
                                                                                    month = topParser2.getMonth();
                                                                                    if (month != null) {
                                                                                        $this$forEach$iv2 = month;
                                                                                        for (Object element$iv3 : $this$forEach$iv2) {
                                                                                            $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Month) element$iv3));
                                                                                            $this$forEach$iv2 = $this$forEach$iv2;
                                                                                        }
                                                                                        Unit unit3 = Unit.INSTANCE;
                                                                                    }
                                                                                    allMedia = CollectionsKt.build(list);
                                                                                    $this$map$iv3 = allMedia;
                                                                                    destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                                                                                    for (Object item$iv$iv3 : $this$map$iv3) {
                                                                                        List allMedia2 = allMedia;
                                                                                        Iterable $this$map$iv5 = $this$map$iv3;
                                                                                        destination$iv$iv4.add(toSearchResponse((OneTouchMedia) item$iv$iv3));
                                                                                        $this$map$iv3 = $this$map$iv5;
                                                                                        allMedia = allMedia2;
                                                                                    }
                                                                                    recommendation = (List) destination$iv$iv4;
                                                                                    if (isMovie5) {
                                                                                        episode2 = (Episode) CollectionsKt.firstOrNull(episodes);
                                                                                        if (episode2 != null || (data = episode2.getData()) == null) {
                                                                                            epUrl = url9;
                                                                                        } else {
                                                                                            epUrl = data;
                                                                                        }
                                                                                        TvType tvType3 = TvType.Movie;
                                                                                        C00054 c00054 = new C00054(tmdbData5, backgroundposter3, poster5, description5, episodes2, year5, actors6, recommendation, null);
                                                                                        c00032.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                                                                                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                                                                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                                                                                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                                                                                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(title5);
                                                                                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(poster5);
                                                                                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                                                                                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(description5);
                                                                                        c00032.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                                                                                        c00032.L$9 = SpillingKt.nullOutSpilledVariable(status6);
                                                                                        c00032.L$10 = SpillingKt.nullOutSpilledVariable(actors6);
                                                                                        c00032.L$11 = SpillingKt.nullOutSpilledVariable(episodes2);
                                                                                        c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex5);
                                                                                        c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch4);
                                                                                        c00032.L$14 = SpillingKt.nullOutSpilledVariable(tmdbData5);
                                                                                        c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                                                                                        c00032.L$16 = SpillingKt.nullOutSpilledVariable(episodes);
                                                                                        c00032.L$17 = SpillingKt.nullOutSpilledVariable(recommendation);
                                                                                        c00032.L$18 = SpillingKt.nullOutSpilledVariable(epUrl);
                                                                                        c00032.Z$0 = isMovie5;
                                                                                        c00032.I$0 = extractedSeason5;
                                                                                        c00032.label = 7;
                                                                                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title5, url9, tvType3, epUrl, c00054, c00032);
                                                                                        if (objNewMovieLoadResponse == obj9) {
                                                                                            return obj9;
                                                                                        }
                                                                                        obj15 = objNewMovieLoadResponse;
                                                                                        return (LoadResponse) obj15;
                                                                                    }
                                                                                    String title6 = title5;
                                                                                    String url12 = url9;
                                                                                    TvType tvType4 = TvType.TvSeries;
                                                                                    List listReversed = CollectionsKt.reversed(episodes);
                                                                                    obj13 = obj9;
                                                                                    extractedSeason6 = extractedSeason5;
                                                                                    C00065 c00065 = new C00065(tmdbData5, backgroundposter3, poster5, description5, episodes2, status6, year5, actors6, recommendation, null);
                                                                                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(url12);
                                                                                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                                                                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                                                                                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                                                                                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(title6);
                                                                                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(poster5);
                                                                                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                                                                                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(description5);
                                                                                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                                                                                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(status6);
                                                                                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(actors6);
                                                                                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(episodes2);
                                                                                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex5);
                                                                                    c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch4);
                                                                                    c00032.L$14 = SpillingKt.nullOutSpilledVariable(tmdbData5);
                                                                                    c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                                                                                    c00032.L$16 = SpillingKt.nullOutSpilledVariable(episodes);
                                                                                    c00032.L$17 = SpillingKt.nullOutSpilledVariable(recommendation);
                                                                                    c00032.Z$0 = isMovie5;
                                                                                    c00032.I$0 = extractedSeason6;
                                                                                    c00032.label = 8;
                                                                                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title6, url12, tvType4, listReversed, c00065, c00032);
                                                                                    if (objNewTvSeriesLoadResponse == obj13) {
                                                                                        return obj13;
                                                                                    }
                                                                                    obj14 = objNewTvSeriesLoadResponse;
                                                                                    seasonMatch5 = seasonMatch4;
                                                                                    seasonRegex6 = seasonRegex5;
                                                                                    episodes3 = episodes;
                                                                                    tmdbEpisodes5 = tmdbEpisodes2;
                                                                                    tmdbData6 = tmdbData5;
                                                                                    backgroundposter4 = backgroundposter3;
                                                                                    poster6 = poster5;
                                                                                    recommendation2 = recommendation;
                                                                                    return (LoadResponse) obj14;
                                                                                } catch (Exception e9) {
                                                                                    e = e9;
                                                                                }
                                                                            } catch (Exception e10) {
                                                                                e = e10;
                                                                            }
                                                                        } catch (Exception e11) {
                                                                            e = e11;
                                                                        }
                                                                    } catch (Exception e12) {
                                                                        throw new ErrorLoadingException(str2 + e12.getMessage());
                                                                    }
                                                                } catch (Exception e13) {
                                                                    e = e13;
                                                                }
                                                            } catch (Exception e14) {
                                                                e = e14;
                                                                throw new ErrorLoadingException("Failed to load recommendations: " + e.getMessage());
                                                            }
                                                        } catch (Exception e15) {
                                                            e = e15;
                                                        }
                                                    } catch (Exception e16) {
                                                        e = e16;
                                                    }
                                                } catch (Exception e17) {
                                                    e = e17;
                                                }
                                            } catch (Exception e18) {
                                                e = e18;
                                            }
                                        } catch (Exception e19) {
                                            e = e19;
                                        }
                                        break;
                                    } else {
                                        extractedSeason = 1;
                                    }
                                    if (seasonMatch == null && (groupValues = seasonMatch.getGroupValues()) != null) {
                                        String it7 = (String) CollectionsKt.getOrNull(groupValues, 2);
                                        if (it7 != null) {
                                            if (StringsKt.isBlank(it7)) {
                                                it7 = null;
                                            }
                                            intOrNull = it7 != null ? StringsKt.toIntOrNull(it7) : null;
                                        }
                                        if (intOrNull != null) {
                                            extractedSeason = intOrNull.intValue();
                                        }
                                        c00032.L$0 = url2;
                                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson3);
                                        c00032.L$3 = parser;
                                        c00032.L$4 = title2;
                                        c00032.L$5 = poster;
                                        c00032.L$6 = backgroundposter;
                                        c00032.L$7 = description;
                                        c00032.L$8 = year2;
                                        c00032.L$9 = status2;
                                        c00032.L$10 = actors;
                                        c00032.L$11 = tags;
                                        c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex);
                                        c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch);
                                        c00032.Z$0 = isMovie;
                                        c00032.I$0 = extractedSeason;
                                        c00032.label = 4;
                                        oneTouchTV = this;
                                        objFetchTmdbData = oneTouchTV.fetchTmdbData(title2, year2, isMovie, c00032);
                                        $result = obj16;
                                        if (objFetchTmdbData == $result) {
                                            return $result;
                                        }
                                        obj7 = objFetchTmdbData;
                                        parser2 = parser;
                                        seasonMatch2 = seasonMatch;
                                        actors2 = actors;
                                        actors3 = tags;
                                        status3 = status2;
                                        isMovie2 = isMovie;
                                        seasonRegex2 = seasonRegex;
                                        tmdbData = (TmdbData) obj7;
                                        if (isMovie2) {
                                        }
                                        String url13 = url2;
                                        obj8 = $result;
                                        String str8 = poster;
                                        tmdbData2 = tmdbData;
                                        extractedSeason2 = extractedSeason;
                                        year3 = year2;
                                        actors4 = actors2;
                                        poster3 = str8;
                                        List list5 = actors3;
                                        description2 = description;
                                        tags2 = list5;
                                        decryptedJson4 = decryptedJson3;
                                        mapEmptyMap = MapsKt.emptyMap();
                                        title3 = title2;
                                        isMovie3 = isMovie2;
                                        status4 = status3;
                                        url4 = url13;
                                        seasonRegex3 = seasonRegex2;
                                        parser3 = parser2;
                                        rawResponse3 = rawResponse2;
                                        seasonMatch3 = seasonMatch2;
                                        tmdbEpisodes = mapEmptyMap;
                                        Iterable $this$mapNotNull$iv2 = parser3.getEpisodes();
                                        destination$iv$iv3 = new ArrayList();
                                        while (r32.hasNext()) {
                                            Object obj110 = obj8;
                                            ep = (EpisodeItem) element$iv$iv$iv;
                                            identifier = ep.getIdentifier();
                                            if (identifier == null) {
                                                tmdbEpisodes4 = tmdbEpisodes;
                                                episodeNewEpisode = null;
                                                isMovie3 = isMovie3;
                                            } else {
                                                episode = ep.getEpisode();
                                                if (episode != null) {
                                                    intOrNull3 = StringsKt.toIntOrNull(episode);
                                                } else {
                                                    intOrNull3 = null;
                                                }
                                                epNum = intOrNull3;
                                                if (epNum != null) {
                                                    tmdbEpisodes3 = tmdbEpisodes;
                                                    epNum2 = epNum;
                                                    tmdbEpisode = (TmdbEpisode) tmdbEpisodes3.get(epNum2);
                                                } else {
                                                    tmdbEpisodes3 = tmdbEpisodes;
                                                    epNum2 = epNum;
                                                    tmdbEpisode = null;
                                                }
                                                final TmdbEpisode tmdbEp2 = tmdbEpisode;
                                                tmdbEpisodes4 = tmdbEpisodes3;
                                                episodeNewEpisode = MainAPIKt.newEpisode(this, getMainUrl() + "/vod/" + identifier + "/episode/" + playId, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda6
                                                    public final Object invoke(Object obj111) {
                                                        return OneTouchTV.load$lambda$7$0(tmdbEp2, ep, epNum2, extractedSeason2, (Episode) obj111);
                                                    }
                                                });
                                            }
                                            if (episodeNewEpisode != null) {
                                                destination$iv$iv3.add(episodeNewEpisode);
                                            }
                                            isMovie3 = isMovie3;
                                            obj8 = obj110;
                                            tmdbEpisodes = tmdbEpisodes4;
                                            tmdbData2 = tmdbData2;
                                            tags2 = tags2;
                                            actors4 = actors4;
                                        }
                                        Object obj111 = obj8;
                                        tmdbData4 = tmdbData2;
                                        tags3 = tags2;
                                        actors5 = actors4;
                                        tmdbEpisodes2 = tmdbEpisodes;
                                        isMovie4 = isMovie3;
                                        List episodes5 = (List) destination$iv$iv3;
                                        Requests app4 = MainActivityKt.getApp();
                                        String str9 = getMainUrl() + "/vod/top";
                                        c00032.L$0 = url4;
                                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                                        c00032.L$4 = title3;
                                        c00032.L$5 = poster3;
                                        c00032.L$6 = backgroundposter;
                                        c00032.L$7 = description2;
                                        c00032.L$8 = year3;
                                        c00032.L$9 = status4;
                                        c00032.L$10 = actors5;
                                        c00032.L$11 = tags3;
                                        c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                                        c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch3);
                                        c00032.L$14 = tmdbData4;
                                        c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                                        c00032.L$16 = episodes5;
                                        c00032.Z$0 = isMovie4;
                                        c00032.I$0 = extractedSeason2;
                                        c00032.label = 6;
                                        title4 = title3;
                                        C00031 c00034 = c00032;
                                        status5 = status4;
                                        year4 = year3;
                                        description4 = description2;
                                        backgroundposter2 = backgroundposter;
                                        poster4 = poster3;
                                        episodes = episodes5;
                                        url6 = url4;
                                        obj9 = obj111;
                                        extractedSeason4 = extractedSeason2;
                                        obj10 = Requests.get$default(app4, str9, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00034, 4094, (Object) null);
                                        c00032 = c00034;
                                        if (obj10 == obj9) {
                                            return obj9;
                                        }
                                        obj11 = obj10;
                                        extractedSeason5 = extractedSeason4;
                                        url7 = title4;
                                        description5 = description4;
                                        status6 = status5;
                                        year5 = year4;
                                        backgroundposter3 = backgroundposter2;
                                        poster5 = poster4;
                                        isMovie5 = isMovie4;
                                        url8 = url6;
                                        tmdbData5 = tmdbData4;
                                        episodes2 = tags3;
                                        actors6 = actors5;
                                        seasonRegex5 = seasonRegex3;
                                        seasonMatch4 = seasonMatch3;
                                        String rawTopResponse2 = ((NiceResponse) obj11).getText();
                                        topJson = DecryptionKt.decryptString(rawTopResponse2);
                                        AppUtils appUtils4 = AppUtils.INSTANCE;
                                        Result.Companion companion13 = Result.Companion;
                                        KType kTypeTypeOf4 = Reflection.typeOf(OneTouchTVParser.class);
                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                        obj12 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                                        if (Result.exceptionOrNull-impl(obj12) == null) {
                                            Result.Companion companion14 = Result.Companion;
                                            title5 = url7;
                                            url9 = url8;
                                            url10 = null;
                                            obj12 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(OneTouchTVParser.class), (List) null, 2, (Object) null));
                                            break;
                                        } else {
                                            title5 = url7;
                                            url9 = url8;
                                            url10 = null;
                                        }
                                        if (Result.isFailure-impl(obj12)) {
                                            obj12 = url10;
                                        }
                                        deserializationStrategy3 = (KSerializer) obj12;
                                        if (deserializationStrategy3 != null) {
                                            objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, topJson);
                                            break;
                                        } else {
                                            ObjectMapper $this$readValue$iv$iv10 = MainAPIKt.getMapper();
                                            objDecodeFromString3 = $this$readValue$iv$iv10.readValue(topJson, new TypeReference<OneTouchTVParser>() { // from class: com.OneTouchTV.OneTouchTV$load$$inlined$parseJson$3
                                            });
                                        }
                                        topParser = (OneTouchTVParser) objDecodeFromString3;
                                        $this$load_u24lambda_u248 = CollectionsKt.createListBuilder();
                                        $this$forEach$iv = topParser.getDay();
                                        if ($this$forEach$iv != null) {
                                            it3 = $this$forEach$iv.iterator();
                                            while (it3.hasNext()) {
                                                Object element$iv4 = it3.next();
                                                OneTouchTVParser topParser4 = topParser;
                                                List list6 = $this$load_u24lambda_u248;
                                                Iterator it8 = it3;
                                                $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Day) element$iv4));
                                                topParser = topParser4;
                                                it3 = it8;
                                                $this$load_u24lambda_u248 = list6;
                                            }
                                            topParser2 = topParser;
                                            list = $this$load_u24lambda_u248;
                                            Unit unit4 = Unit.INSTANCE;
                                        } else {
                                            topParser2 = topParser;
                                            list = $this$load_u24lambda_u248;
                                        }
                                        week = topParser2.getWeek();
                                        if (week != null) {
                                            $this$forEach$iv3 = week;
                                            while (r6.hasNext()) {
                                                $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Week) element$iv2));
                                                $this$forEach$iv3 = $this$forEach$iv3;
                                            }
                                            Unit unit5 = Unit.INSTANCE;
                                        }
                                        month = topParser2.getMonth();
                                        if (month != null) {
                                            $this$forEach$iv2 = month;
                                            while (r6.hasNext()) {
                                                $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Month) element$iv3));
                                                $this$forEach$iv2 = $this$forEach$iv2;
                                            }
                                            Unit unit6 = Unit.INSTANCE;
                                        }
                                        allMedia = CollectionsKt.build(list);
                                        $this$map$iv3 = allMedia;
                                        destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                                        while (r12.hasNext()) {
                                            List allMedia3 = allMedia;
                                            Iterable $this$map$iv6 = $this$map$iv3;
                                            destination$iv$iv4.add(toSearchResponse((OneTouchMedia) item$iv$iv3));
                                            $this$map$iv3 = $this$map$iv6;
                                            allMedia = allMedia3;
                                        }
                                        recommendation = (List) destination$iv$iv4;
                                        if (isMovie5) {
                                            episode2 = (Episode) CollectionsKt.firstOrNull(episodes);
                                            if (episode2 != null) {
                                                epUrl = url9;
                                            } else {
                                                epUrl = url9;
                                            }
                                            TvType tvType5 = TvType.Movie;
                                            C00054 c00055 = new C00054(tmdbData5, backgroundposter3, poster5, description5, episodes2, year5, actors6, recommendation, null);
                                            c00032.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                                            c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                            c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                                            c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                                            c00032.L$4 = SpillingKt.nullOutSpilledVariable(title5);
                                            c00032.L$5 = SpillingKt.nullOutSpilledVariable(poster5);
                                            c00032.L$6 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                                            c00032.L$7 = SpillingKt.nullOutSpilledVariable(description5);
                                            c00032.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                                            c00032.L$9 = SpillingKt.nullOutSpilledVariable(status6);
                                            c00032.L$10 = SpillingKt.nullOutSpilledVariable(actors6);
                                            c00032.L$11 = SpillingKt.nullOutSpilledVariable(episodes2);
                                            c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex5);
                                            c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch4);
                                            c00032.L$14 = SpillingKt.nullOutSpilledVariable(tmdbData5);
                                            c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                                            c00032.L$16 = SpillingKt.nullOutSpilledVariable(episodes);
                                            c00032.L$17 = SpillingKt.nullOutSpilledVariable(recommendation);
                                            c00032.L$18 = SpillingKt.nullOutSpilledVariable(epUrl);
                                            c00032.Z$0 = isMovie5;
                                            c00032.I$0 = extractedSeason5;
                                            c00032.label = 7;
                                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title5, url9, tvType5, epUrl, c00055, c00032);
                                            if (objNewMovieLoadResponse == obj9) {
                                                return obj9;
                                            }
                                            obj15 = objNewMovieLoadResponse;
                                            return (LoadResponse) obj15;
                                        }
                                        String title7 = title5;
                                        String url14 = url9;
                                        TvType tvType6 = TvType.TvSeries;
                                        List listReversed2 = CollectionsKt.reversed(episodes);
                                        obj13 = obj9;
                                        extractedSeason6 = extractedSeason5;
                                        C00065 c00066 = new C00065(tmdbData5, backgroundposter3, poster5, description5, episodes2, status6, year5, actors6, recommendation, null);
                                        c00032.L$0 = SpillingKt.nullOutSpilledVariable(url14);
                                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(title7);
                                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(poster5);
                                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(description5);
                                        c00032.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                                        c00032.L$9 = SpillingKt.nullOutSpilledVariable(status6);
                                        c00032.L$10 = SpillingKt.nullOutSpilledVariable(actors6);
                                        c00032.L$11 = SpillingKt.nullOutSpilledVariable(episodes2);
                                        c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex5);
                                        c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch4);
                                        c00032.L$14 = SpillingKt.nullOutSpilledVariable(tmdbData5);
                                        c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                                        c00032.L$16 = SpillingKt.nullOutSpilledVariable(episodes);
                                        c00032.L$17 = SpillingKt.nullOutSpilledVariable(recommendation);
                                        c00032.Z$0 = isMovie5;
                                        c00032.I$0 = extractedSeason6;
                                        c00032.label = 8;
                                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title7, url14, tvType6, listReversed2, c00066, c00032);
                                        if (objNewTvSeriesLoadResponse == obj13) {
                                            return obj13;
                                        }
                                        obj14 = objNewTvSeriesLoadResponse;
                                        seasonMatch5 = seasonMatch4;
                                        seasonRegex6 = seasonRegex5;
                                        episodes3 = episodes;
                                        tmdbEpisodes5 = tmdbEpisodes2;
                                        tmdbData6 = tmdbData5;
                                        backgroundposter4 = backgroundposter3;
                                        poster6 = poster5;
                                        recommendation2 = recommendation;
                                        return (LoadResponse) obj14;
                                    }
                                    if (intOrNull != null) {
                                        extractedSeason = intOrNull.intValue();
                                    }
                                    c00032.L$0 = url2;
                                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson3);
                                    c00032.L$3 = parser;
                                    c00032.L$4 = title2;
                                    c00032.L$5 = poster;
                                    c00032.L$6 = backgroundposter;
                                    c00032.L$7 = description;
                                    c00032.L$8 = year2;
                                    c00032.L$9 = status2;
                                    c00032.L$10 = actors;
                                    c00032.L$11 = tags;
                                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex);
                                    c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch);
                                    c00032.Z$0 = isMovie;
                                    c00032.I$0 = extractedSeason;
                                    c00032.label = 4;
                                    oneTouchTV = this;
                                    objFetchTmdbData = oneTouchTV.fetchTmdbData(title2, year2, isMovie, c00032);
                                    $result = obj16;
                                    if (objFetchTmdbData == $result) {
                                        return $result;
                                    }
                                    obj7 = objFetchTmdbData;
                                    parser2 = parser;
                                    seasonMatch2 = seasonMatch;
                                    actors2 = actors;
                                    actors3 = tags;
                                    status3 = status2;
                                    isMovie2 = isMovie;
                                    seasonRegex2 = seasonRegex;
                                    tmdbData = (TmdbData) obj7;
                                    if (isMovie2) {
                                    }
                                    String url15 = url2;
                                    obj8 = $result;
                                    String str10 = poster;
                                    tmdbData2 = tmdbData;
                                    extractedSeason2 = extractedSeason;
                                    year3 = year2;
                                    actors4 = actors2;
                                    poster3 = str10;
                                    List list7 = actors3;
                                    description2 = description;
                                    tags2 = list7;
                                    decryptedJson4 = decryptedJson3;
                                    mapEmptyMap = MapsKt.emptyMap();
                                    title3 = title2;
                                    isMovie3 = isMovie2;
                                    status4 = status3;
                                    url4 = url15;
                                    seasonRegex3 = seasonRegex2;
                                    parser3 = parser2;
                                    rawResponse3 = rawResponse2;
                                    seasonMatch3 = seasonMatch2;
                                    tmdbEpisodes = mapEmptyMap;
                                    Iterable $this$mapNotNull$iv3 = parser3.getEpisodes();
                                    destination$iv$iv3 = new ArrayList();
                                    while (r32.hasNext()) {
                                        Object obj112 = obj8;
                                        ep = (EpisodeItem) element$iv$iv$iv;
                                        identifier = ep.getIdentifier();
                                        if (identifier == null) {
                                            tmdbEpisodes4 = tmdbEpisodes;
                                            episodeNewEpisode = null;
                                            isMovie3 = isMovie3;
                                        } else {
                                            episode = ep.getEpisode();
                                            if (episode != null) {
                                                intOrNull3 = StringsKt.toIntOrNull(episode);
                                            } else {
                                                intOrNull3 = null;
                                            }
                                            epNum = intOrNull3;
                                            if (epNum != null) {
                                                tmdbEpisodes3 = tmdbEpisodes;
                                                epNum2 = epNum;
                                                tmdbEpisode = (TmdbEpisode) tmdbEpisodes3.get(epNum2);
                                            } else {
                                                tmdbEpisodes3 = tmdbEpisodes;
                                                epNum2 = epNum;
                                                tmdbEpisode = null;
                                            }
                                            final TmdbEpisode tmdbEp3 = tmdbEpisode;
                                            tmdbEpisodes4 = tmdbEpisodes3;
                                            episodeNewEpisode = MainAPIKt.newEpisode(this, getMainUrl() + "/vod/" + identifier + "/episode/" + playId, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda6
                                                public final Object invoke(Object obj113) {
                                                    return OneTouchTV.load$lambda$7$0(tmdbEp3, ep, epNum2, extractedSeason2, (Episode) obj113);
                                                }
                                            });
                                        }
                                        if (episodeNewEpisode != null) {
                                            destination$iv$iv3.add(episodeNewEpisode);
                                        }
                                        isMovie3 = isMovie3;
                                        obj8 = obj112;
                                        tmdbEpisodes = tmdbEpisodes4;
                                        tmdbData2 = tmdbData2;
                                        tags2 = tags2;
                                        actors4 = actors4;
                                    }
                                    Object obj113 = obj8;
                                    tmdbData4 = tmdbData2;
                                    tags3 = tags2;
                                    actors5 = actors4;
                                    tmdbEpisodes2 = tmdbEpisodes;
                                    isMovie4 = isMovie3;
                                    List episodes6 = (List) destination$iv$iv3;
                                    Requests app5 = MainActivityKt.getApp();
                                    String str11 = getMainUrl() + "/vod/top";
                                    c00032.L$0 = url4;
                                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                                    c00032.L$4 = title3;
                                    c00032.L$5 = poster3;
                                    c00032.L$6 = backgroundposter;
                                    c00032.L$7 = description2;
                                    c00032.L$8 = year3;
                                    c00032.L$9 = status4;
                                    c00032.L$10 = actors5;
                                    c00032.L$11 = tags3;
                                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                                    c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch3);
                                    c00032.L$14 = tmdbData4;
                                    c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                                    c00032.L$16 = episodes6;
                                    c00032.Z$0 = isMovie4;
                                    c00032.I$0 = extractedSeason2;
                                    c00032.label = 6;
                                    title4 = title3;
                                    C00031 c00035 = c00032;
                                    status5 = status4;
                                    year4 = year3;
                                    description4 = description2;
                                    backgroundposter2 = backgroundposter;
                                    poster4 = poster3;
                                    episodes = episodes6;
                                    url6 = url4;
                                    obj9 = obj113;
                                    extractedSeason4 = extractedSeason2;
                                    obj10 = Requests.get$default(app5, str11, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00035, 4094, (Object) null);
                                    c00032 = c00035;
                                    if (obj10 == obj9) {
                                        return obj9;
                                    }
                                    obj11 = obj10;
                                    extractedSeason5 = extractedSeason4;
                                    url7 = title4;
                                    description5 = description4;
                                    status6 = status5;
                                    year5 = year4;
                                    backgroundposter3 = backgroundposter2;
                                    poster5 = poster4;
                                    isMovie5 = isMovie4;
                                    url8 = url6;
                                    tmdbData5 = tmdbData4;
                                    episodes2 = tags3;
                                    actors6 = actors5;
                                    seasonRegex5 = seasonRegex3;
                                    seasonMatch4 = seasonMatch3;
                                    String rawTopResponse3 = ((NiceResponse) obj11).getText();
                                    topJson = DecryptionKt.decryptString(rawTopResponse3);
                                    AppUtils appUtils5 = AppUtils.INSTANCE;
                                    Result.Companion companion15 = Result.Companion;
                                    KType kTypeTypeOf5 = Reflection.typeOf(OneTouchTVParser.class);
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj12 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                                    if (Result.exceptionOrNull-impl(obj12) == null) {
                                        Result.Companion companion16 = Result.Companion;
                                        title5 = url7;
                                        url9 = url8;
                                        url10 = null;
                                        obj12 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(OneTouchTVParser.class), (List) null, 2, (Object) null));
                                        break;
                                    } else {
                                        title5 = url7;
                                        url9 = url8;
                                        url10 = null;
                                    }
                                    if (Result.isFailure-impl(obj12)) {
                                        obj12 = url10;
                                    }
                                    deserializationStrategy3 = (KSerializer) obj12;
                                    if (deserializationStrategy3 != null) {
                                        objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, topJson);
                                        break;
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv11 = MainAPIKt.getMapper();
                                        objDecodeFromString3 = $this$readValue$iv$iv11.readValue(topJson, new TypeReference<OneTouchTVParser>() { // from class: com.OneTouchTV.OneTouchTV$load$$inlined$parseJson$3
                                        });
                                    }
                                    topParser = (OneTouchTVParser) objDecodeFromString3;
                                    $this$load_u24lambda_u248 = CollectionsKt.createListBuilder();
                                    $this$forEach$iv = topParser.getDay();
                                    if ($this$forEach$iv != null) {
                                        it3 = $this$forEach$iv.iterator();
                                        while (it3.hasNext()) {
                                            Object element$iv5 = it3.next();
                                            OneTouchTVParser topParser5 = topParser;
                                            List list8 = $this$load_u24lambda_u248;
                                            Iterator it9 = it3;
                                            $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Day) element$iv5));
                                            topParser = topParser5;
                                            it3 = it9;
                                            $this$load_u24lambda_u248 = list8;
                                        }
                                        topParser2 = topParser;
                                        list = $this$load_u24lambda_u248;
                                        Unit unit7 = Unit.INSTANCE;
                                    } else {
                                        topParser2 = topParser;
                                        list = $this$load_u24lambda_u248;
                                    }
                                    week = topParser2.getWeek();
                                    if (week != null) {
                                        $this$forEach$iv3 = week;
                                        while (r6.hasNext()) {
                                            $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Week) element$iv2));
                                            $this$forEach$iv3 = $this$forEach$iv3;
                                        }
                                        Unit unit8 = Unit.INSTANCE;
                                    }
                                    month = topParser2.getMonth();
                                    if (month != null) {
                                        $this$forEach$iv2 = month;
                                        while (r6.hasNext()) {
                                            $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Month) element$iv3));
                                            $this$forEach$iv2 = $this$forEach$iv2;
                                        }
                                        Unit unit9 = Unit.INSTANCE;
                                    }
                                    allMedia = CollectionsKt.build(list);
                                    $this$map$iv3 = allMedia;
                                    destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                                    while (r12.hasNext()) {
                                        List allMedia4 = allMedia;
                                        Iterable $this$map$iv7 = $this$map$iv3;
                                        destination$iv$iv4.add(toSearchResponse((OneTouchMedia) item$iv$iv3));
                                        $this$map$iv3 = $this$map$iv7;
                                        allMedia = allMedia4;
                                    }
                                    recommendation = (List) destination$iv$iv4;
                                    if (isMovie5) {
                                        episode2 = (Episode) CollectionsKt.firstOrNull(episodes);
                                        if (episode2 != null) {
                                            epUrl = url9;
                                        } else {
                                            epUrl = url9;
                                        }
                                        TvType tvType7 = TvType.Movie;
                                        C00054 c00056 = new C00054(tmdbData5, backgroundposter3, poster5, description5, episodes2, year5, actors6, recommendation, null);
                                        c00032.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(title5);
                                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(poster5);
                                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(description5);
                                        c00032.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                                        c00032.L$9 = SpillingKt.nullOutSpilledVariable(status6);
                                        c00032.L$10 = SpillingKt.nullOutSpilledVariable(actors6);
                                        c00032.L$11 = SpillingKt.nullOutSpilledVariable(episodes2);
                                        c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex5);
                                        c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch4);
                                        c00032.L$14 = SpillingKt.nullOutSpilledVariable(tmdbData5);
                                        c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                                        c00032.L$16 = SpillingKt.nullOutSpilledVariable(episodes);
                                        c00032.L$17 = SpillingKt.nullOutSpilledVariable(recommendation);
                                        c00032.L$18 = SpillingKt.nullOutSpilledVariable(epUrl);
                                        c00032.Z$0 = isMovie5;
                                        c00032.I$0 = extractedSeason5;
                                        c00032.label = 7;
                                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title5, url9, tvType7, epUrl, c00056, c00032);
                                        if (objNewMovieLoadResponse == obj9) {
                                            return obj9;
                                        }
                                        obj15 = objNewMovieLoadResponse;
                                        return (LoadResponse) obj15;
                                    }
                                    String title8 = title5;
                                    String url16 = url9;
                                    TvType tvType8 = TvType.TvSeries;
                                    List listReversed3 = CollectionsKt.reversed(episodes);
                                    obj13 = obj9;
                                    extractedSeason6 = extractedSeason5;
                                    C00065 c00067 = new C00065(tmdbData5, backgroundposter3, poster5, description5, episodes2, status6, year5, actors6, recommendation, null);
                                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(url16);
                                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(title8);
                                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(poster5);
                                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(description5);
                                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(status6);
                                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(actors6);
                                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(episodes2);
                                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex5);
                                    c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch4);
                                    c00032.L$14 = SpillingKt.nullOutSpilledVariable(tmdbData5);
                                    c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                                    c00032.L$16 = SpillingKt.nullOutSpilledVariable(episodes);
                                    c00032.L$17 = SpillingKt.nullOutSpilledVariable(recommendation);
                                    c00032.Z$0 = isMovie5;
                                    c00032.I$0 = extractedSeason6;
                                    c00032.label = 8;
                                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title8, url16, tvType8, listReversed3, c00067, c00032);
                                    if (objNewTvSeriesLoadResponse == obj13) {
                                        return obj13;
                                    }
                                    obj14 = objNewTvSeriesLoadResponse;
                                    seasonMatch5 = seasonMatch4;
                                    seasonRegex6 = seasonRegex5;
                                    episodes3 = episodes;
                                    tmdbEpisodes5 = tmdbEpisodes2;
                                    tmdbData6 = tmdbData5;
                                    backgroundposter4 = backgroundposter3;
                                    poster6 = poster5;
                                    recommendation2 = recommendation;
                                    return (LoadResponse) obj14;
                                } catch (Exception e20) {
                                    e = e20;
                                }
                            } catch (Exception e21) {
                                throw new ErrorLoadingException(str2 + e21.getMessage());
                            }
                        } catch (Exception e22) {
                            e = e22;
                            throw new ErrorLoadingException("Failed to fetch raw response: " + e.getMessage());
                        }
                    } catch (Exception e23) {
                        e = e23;
                        throw new ErrorLoadingException("Failed to fetch raw response: " + e.getMessage());
                    }
                } catch (Exception e24) {
                    e = e24;
                }
                break;
            case 1:
                String channelId3 = (String) c00032.L$1;
                String url17 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result2);
                obj2 = coroutine_suspended;
                i = 2;
                channelId = channelId3;
                url3 = url17;
                rawResponse = ((NiceResponse) $result2).getText();
                decryptedJson = DecryptionKt.decryptString(rawResponse);
                AppUtils appUtils6 = AppUtils.INSTANCE;
                Result.Companion companion17 = Result.Companion;
                KType kTypeTypeOf6 = Reflection.typeOf(ChannelResponse.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                if (Result.exceptionOrNull-impl(obj3) != null) {
                    Result.Companion companion18 = Result.Companion;
                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ChannelResponse.class), (List) null, i, (Object) null));
                    break;
                }
                obj4 = obj3;
                if (Result.isFailure-impl(obj4)) {
                    obj4 = null;
                }
                deserializationStrategy = (KSerializer) obj4;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decryptedJson);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv12 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv12.readValue(decryptedJson, new TypeReference<ChannelResponse>() { // from class: com.OneTouchTV.OneTouchTV$load$$inlined$parseJson$1
                    });
                }
                channelParser = (ChannelResponse) objDecodeFromString;
                channels = channelParser.getChannels();
                if (channels != null) {
                    it = channels.iterator();
                    do {
                        if (it.hasNext()) {
                            next = it.next();
                        } else {
                            next = null;
                        }
                        channel = (ChannelItem) next;
                        if (channel != null) {
                            OneTouchTV oneTouchTV6 = this;
                            title = channel.getTitle();
                            if (title == null) {
                                title = "Unknown";
                            }
                            TvType tvType9 = TvType.Live;
                            OneTouchTV oneTouchTV7 = this;
                            streamingUrl = channel.getStreamingUrl();
                            if (streamingUrl == null) {
                                streamingUrl = "";
                            }
                            List listListOf3 = CollectionsKt.listOf(MainAPIKt.newEpisode(oneTouchTV7, streamingUrl, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj114) {
                                    return OneTouchTV.load$lambda$1((Episode) obj114);
                                }
                            }));
                            C00043 c00045 = new C00043(channel, null);
                            c00032.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00032.L$1 = SpillingKt.nullOutSpilledVariable(channelId);
                            c00032.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse);
                            c00032.L$3 = SpillingKt.nullOutSpilledVariable(decryptedJson);
                            c00032.L$4 = SpillingKt.nullOutSpilledVariable(channelParser);
                            c00032.L$5 = SpillingKt.nullOutSpilledVariable(channel);
                            c00032.label = i;
                            $result2 = MainAPIKt.newTvSeriesLoadResponse(oneTouchTV6, title, url3, tvType9, listListOf3, c00045, c00032);
                            if ($result2 == obj2) {
                                return obj2;
                            }
                            return $result2;
                        }
                    } while (!Intrinsics.areEqual(((ChannelItem) next).getId(), channelId));
                    channel = (ChannelItem) next;
                    if (channel != null) {
                        OneTouchTV oneTouchTV8 = this;
                        title = channel.getTitle();
                        if (title == null) {
                            title = "Unknown";
                        }
                        TvType tvType10 = TvType.Live;
                        OneTouchTV oneTouchTV9 = this;
                        streamingUrl = channel.getStreamingUrl();
                        if (streamingUrl == null) {
                            streamingUrl = "";
                        }
                        List listListOf4 = CollectionsKt.listOf(MainAPIKt.newEpisode(oneTouchTV9, streamingUrl, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj114) {
                                return OneTouchTV.load$lambda$1((Episode) obj114);
                            }
                        }));
                        C00043 c00046 = new C00043(channel, null);
                        c00032.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(channelId);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(decryptedJson);
                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(channelParser);
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(channel);
                        c00032.label = i;
                        $result2 = MainAPIKt.newTvSeriesLoadResponse(oneTouchTV8, title, url3, tvType10, listListOf4, c00046, c00032);
                        if ($result2 == obj2) {
                            return obj2;
                        }
                        return $result2;
                    }
                }
                throw new ErrorLoadingException("Channel not found");
            case 2:
                ResultKt.throwOnFailure($result2);
                return $result2;
            case 3:
                url2 = (String) c00032.L$0;
                try {
                    ResultKt.throwOnFailure($result2);
                    obj = coroutine_suspended;
                    str = "Failed to parse decrypted JSON: ";
                    str2 = "Failed to decrypt response: ";
                    String rawResponse5 = ((NiceResponse) $result2).getText();
                    decryptedJson2 = DecryptionKt.decryptString(rawResponse5);
                    AppUtils appUtils7 = AppUtils.INSTANCE;
                    Result.Companion companion19 = Result.Companion;
                    KType kTypeTypeOf7 = Reflection.typeOf(LoadData.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf7));
                    if (Result.exceptionOrNull-impl(obj5) == null) {
                        Result.Companion companion20 = Result.Companion;
                        obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LoadData.class), (List) null, 2, (Object) null));
                        break;
                    }
                    obj6 = obj5;
                    if (Result.isFailure-impl(obj6)) {
                        obj6 = null;
                    }
                    deserializationStrategy2 = (KSerializer) obj6;
                    if (deserializationStrategy2 != null) {
                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, decryptedJson2);
                        break;
                    } else {
                        ObjectMapper $this$readValue$iv$iv13 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv13.readValue(decryptedJson2, new TypeReference<LoadData>() { // from class: com.OneTouchTV.OneTouchTV$load$$inlined$parseJson$2
                        });
                    }
                    parser = (LoadData) objDecodeFromString2;
                    title2 = parser.getTitle();
                    if (title2 == null) {
                        title2 = "Unknown Title";
                    }
                    poster = parser.getImage();
                    if (poster == null) {
                        poster = "null";
                    }
                    poster2 = parser.getPoster();
                    if (poster2 != null) {
                        backgroundposter = parser.getImage();
                        if (backgroundposter == null) {
                            backgroundposter = "";
                        }
                    } else {
                        backgroundposter = parser.getImage();
                        if (backgroundposter == null) {
                            backgroundposter = "";
                        }
                    }
                    description = parser.getDescription();
                    if (description == null) {
                        description = "";
                    }
                    year = parser.getYear();
                    if (year != null) {
                        year2 = StringsKt.toIntOrNull(year);
                    } else {
                        year2 = null;
                    }
                    status = parser.getStatus();
                    if (status == null) {
                        status = "";
                    }
                    status2 = getStatus(status);
                    $this$map$iv = parser.getActors();
                    rawResponse2 = rawResponse5;
                    decryptedJson3 = decryptedJson2;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    $this$mapTo$iv$iv = $this$map$iv;
                    while (r19.hasNext()) {
                        ActorItem it10 = (ActorItem) item$iv$iv;
                        name = it10.getName();
                        Iterable $this$mapTo$iv$iv4 = $this$mapTo$iv$iv;
                        if (name == null) {
                            str3 = "";
                        } else {
                            str3 = name;
                        }
                        image = it10.getImage();
                        Iterable $this$map$iv8 = $this$map$iv;
                        if (image == null) {
                            str4 = "";
                        } else {
                            str4 = image;
                        }
                        destination$iv$iv.add(new ActorData(new Actor(str3, str4), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv4;
                        $this$map$iv = $this$map$iv8;
                    }
                    actors = (List) destination$iv$iv;
                    $this$map$iv2 = parser.getGenres();
                    int $i$f$map2 = CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10);
                    destination$iv$iv2 = new ArrayList($i$f$map2);
                    $this$mapTo$iv$iv2 = $this$map$iv2;
                    while (r20.hasNext()) {
                        it2 = (String) item$iv$iv2;
                        if (it2.length() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            StringBuilder sb2 = new StringBuilder();
                            char p1 = it2.charAt(0);
                            String strValueOf2 = String.valueOf(p1);
                            Intrinsics.checkNotNull(strValueOf2, "null cannot be cast to non-null type java.lang.String");
                            String upperCase2 = strValueOf2.toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                            StringBuilder sbAppend2 = sb2.append((Object) upperCase2);
                            String strSubstring2 = it2.substring(1);
                            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                            string = sbAppend2.append(strSubstring2).toString();
                        } else {
                            string = it2;
                        }
                        destination$iv$iv2.add(string);
                        $this$map$iv2 = $this$map$iv2;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv2;
                        obj = obj;
                    }
                    Object obj114 = obj;
                    tags = (List) destination$iv$iv2;
                    isMovie = StringsKt.equals(parser.getType(), "movie", true);
                    seasonRegex = new Regex("(?i)(?:season\\s*(\\d+)|\\bs(\\d+)\\b)");
                    seasonMatch = Regex.find$default(seasonRegex, title2, 0, 2, (Object) null);
                    if (seasonMatch == null) {
                        extractedSeason = 1;
                        if (seasonMatch == null) {
                        }
                        if (intOrNull != null) {
                            extractedSeason = intOrNull.intValue();
                        }
                    } else {
                        extractedSeason = 1;
                        if (seasonMatch == null) {
                        }
                        if (intOrNull != null) {
                            extractedSeason = intOrNull.intValue();
                        }
                    }
                    c00032.L$0 = url2;
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson3);
                    c00032.L$3 = parser;
                    c00032.L$4 = title2;
                    c00032.L$5 = poster;
                    c00032.L$6 = backgroundposter;
                    c00032.L$7 = description;
                    c00032.L$8 = year2;
                    c00032.L$9 = status2;
                    c00032.L$10 = actors;
                    c00032.L$11 = tags;
                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex);
                    c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch);
                    c00032.Z$0 = isMovie;
                    c00032.I$0 = extractedSeason;
                    c00032.label = 4;
                    oneTouchTV = this;
                    objFetchTmdbData = oneTouchTV.fetchTmdbData(title2, year2, isMovie, c00032);
                    $result = obj114;
                    if (objFetchTmdbData == $result) {
                        return $result;
                    }
                    obj7 = objFetchTmdbData;
                    parser2 = parser;
                    seasonMatch2 = seasonMatch;
                    actors2 = actors;
                    actors3 = tags;
                    status3 = status2;
                    isMovie2 = isMovie;
                    seasonRegex2 = seasonRegex;
                    tmdbData = (TmdbData) obj7;
                    if (isMovie2) {
                    }
                    String url18 = url2;
                    obj8 = $result;
                    String str12 = poster;
                    tmdbData2 = tmdbData;
                    extractedSeason2 = extractedSeason;
                    year3 = year2;
                    actors4 = actors2;
                    poster3 = str12;
                    List list9 = actors3;
                    description2 = description;
                    tags2 = list9;
                    decryptedJson4 = decryptedJson3;
                    mapEmptyMap = MapsKt.emptyMap();
                    title3 = title2;
                    isMovie3 = isMovie2;
                    status4 = status3;
                    url4 = url18;
                    seasonRegex3 = seasonRegex2;
                    parser3 = parser2;
                    rawResponse3 = rawResponse2;
                    seasonMatch3 = seasonMatch2;
                    tmdbEpisodes = mapEmptyMap;
                    Iterable $this$mapNotNull$iv4 = parser3.getEpisodes();
                    destination$iv$iv3 = new ArrayList();
                    while (r32.hasNext()) {
                        Object obj115 = obj8;
                        ep = (EpisodeItem) element$iv$iv$iv;
                        identifier = ep.getIdentifier();
                        if (identifier == null) {
                            tmdbEpisodes4 = tmdbEpisodes;
                            episodeNewEpisode = null;
                            isMovie3 = isMovie3;
                        } else {
                            episode = ep.getEpisode();
                            if (episode != null) {
                                intOrNull3 = StringsKt.toIntOrNull(episode);
                            } else {
                                intOrNull3 = null;
                            }
                            epNum = intOrNull3;
                            if (epNum != null) {
                                tmdbEpisodes3 = tmdbEpisodes;
                                epNum2 = epNum;
                                tmdbEpisode = (TmdbEpisode) tmdbEpisodes3.get(epNum2);
                            } else {
                                tmdbEpisodes3 = tmdbEpisodes;
                                epNum2 = epNum;
                                tmdbEpisode = null;
                            }
                            final TmdbEpisode tmdbEp4 = tmdbEpisode;
                            tmdbEpisodes4 = tmdbEpisodes3;
                            episodeNewEpisode = MainAPIKt.newEpisode(this, getMainUrl() + "/vod/" + identifier + "/episode/" + playId, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda6
                                public final Object invoke(Object obj116) {
                                    return OneTouchTV.load$lambda$7$0(tmdbEp4, ep, epNum2, extractedSeason2, (Episode) obj116);
                                }
                            });
                        }
                        if (episodeNewEpisode != null) {
                            destination$iv$iv3.add(episodeNewEpisode);
                        }
                        isMovie3 = isMovie3;
                        obj8 = obj115;
                        tmdbEpisodes = tmdbEpisodes4;
                        tmdbData2 = tmdbData2;
                        tags2 = tags2;
                        actors4 = actors4;
                    }
                    Object obj116 = obj8;
                    tmdbData4 = tmdbData2;
                    tags3 = tags2;
                    actors5 = actors4;
                    tmdbEpisodes2 = tmdbEpisodes;
                    isMovie4 = isMovie3;
                    List episodes7 = (List) destination$iv$iv3;
                    Requests app6 = MainActivityKt.getApp();
                    String str13 = getMainUrl() + "/vod/top";
                    c00032.L$0 = url4;
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                    c00032.L$4 = title3;
                    c00032.L$5 = poster3;
                    c00032.L$6 = backgroundposter;
                    c00032.L$7 = description2;
                    c00032.L$8 = year3;
                    c00032.L$9 = status4;
                    c00032.L$10 = actors5;
                    c00032.L$11 = tags3;
                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                    c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch3);
                    c00032.L$14 = tmdbData4;
                    c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                    c00032.L$16 = episodes7;
                    c00032.Z$0 = isMovie4;
                    c00032.I$0 = extractedSeason2;
                    c00032.label = 6;
                    title4 = title3;
                    C00031 c00036 = c00032;
                    status5 = status4;
                    year4 = year3;
                    description4 = description2;
                    backgroundposter2 = backgroundposter;
                    poster4 = poster3;
                    episodes = episodes7;
                    url6 = url4;
                    obj9 = obj116;
                    extractedSeason4 = extractedSeason2;
                    obj10 = Requests.get$default(app6, str13, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00036, 4094, (Object) null);
                    c00032 = c00036;
                    if (obj10 == obj9) {
                        return obj9;
                    }
                    obj11 = obj10;
                    extractedSeason5 = extractedSeason4;
                    url7 = title4;
                    description5 = description4;
                    status6 = status5;
                    year5 = year4;
                    backgroundposter3 = backgroundposter2;
                    poster5 = poster4;
                    isMovie5 = isMovie4;
                    url8 = url6;
                    tmdbData5 = tmdbData4;
                    episodes2 = tags3;
                    actors6 = actors5;
                    seasonRegex5 = seasonRegex3;
                    seasonMatch4 = seasonMatch3;
                    String rawTopResponse4 = ((NiceResponse) obj11).getText();
                    topJson = DecryptionKt.decryptString(rawTopResponse4);
                    AppUtils appUtils8 = AppUtils.INSTANCE;
                    Result.Companion companion110 = Result.Companion;
                    KType kTypeTypeOf8 = Reflection.typeOf(OneTouchTVParser.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj12 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf8));
                    if (Result.exceptionOrNull-impl(obj12) == null) {
                        Result.Companion companion111 = Result.Companion;
                        title5 = url7;
                        url9 = url8;
                        url10 = null;
                        obj12 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(OneTouchTVParser.class), (List) null, 2, (Object) null));
                        break;
                    } else {
                        title5 = url7;
                        url9 = url8;
                        url10 = null;
                    }
                    if (Result.isFailure-impl(obj12)) {
                        obj12 = url10;
                    }
                    deserializationStrategy3 = (KSerializer) obj12;
                    if (deserializationStrategy3 != null) {
                        objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, topJson);
                        break;
                    } else {
                        ObjectMapper $this$readValue$iv$iv14 = MainAPIKt.getMapper();
                        objDecodeFromString3 = $this$readValue$iv$iv14.readValue(topJson, new TypeReference<OneTouchTVParser>() { // from class: com.OneTouchTV.OneTouchTV$load$$inlined$parseJson$3
                        });
                    }
                    topParser = (OneTouchTVParser) objDecodeFromString3;
                    $this$load_u24lambda_u248 = CollectionsKt.createListBuilder();
                    $this$forEach$iv = topParser.getDay();
                    if ($this$forEach$iv != null) {
                        it3 = $this$forEach$iv.iterator();
                        while (it3.hasNext()) {
                            Object element$iv6 = it3.next();
                            OneTouchTVParser topParser6 = topParser;
                            List list10 = $this$load_u24lambda_u248;
                            Iterator it11 = it3;
                            $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Day) element$iv6));
                            topParser = topParser6;
                            it3 = it11;
                            $this$load_u24lambda_u248 = list10;
                        }
                        topParser2 = topParser;
                        list = $this$load_u24lambda_u248;
                        Unit unit10 = Unit.INSTANCE;
                    } else {
                        topParser2 = topParser;
                        list = $this$load_u24lambda_u248;
                    }
                    week = topParser2.getWeek();
                    if (week != null) {
                        $this$forEach$iv3 = week;
                        while (r6.hasNext()) {
                            $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Week) element$iv2));
                            $this$forEach$iv3 = $this$forEach$iv3;
                        }
                        Unit unit11 = Unit.INSTANCE;
                    }
                    month = topParser2.getMonth();
                    if (month != null) {
                        $this$forEach$iv2 = month;
                        while (r6.hasNext()) {
                            $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Month) element$iv3));
                            $this$forEach$iv2 = $this$forEach$iv2;
                        }
                        Unit unit12 = Unit.INSTANCE;
                    }
                    allMedia = CollectionsKt.build(list);
                    $this$map$iv3 = allMedia;
                    destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                    while (r12.hasNext()) {
                        List allMedia5 = allMedia;
                        Iterable $this$map$iv9 = $this$map$iv3;
                        destination$iv$iv4.add(toSearchResponse((OneTouchMedia) item$iv$iv3));
                        $this$map$iv3 = $this$map$iv9;
                        allMedia = allMedia5;
                    }
                    recommendation = (List) destination$iv$iv4;
                    if (isMovie5) {
                        episode2 = (Episode) CollectionsKt.firstOrNull(episodes);
                        if (episode2 != null) {
                            epUrl = url9;
                        } else {
                            epUrl = url9;
                        }
                        TvType tvType11 = TvType.Movie;
                        C00054 c00057 = new C00054(tmdbData5, backgroundposter3, poster5, description5, episodes2, year5, actors6, recommendation, null);
                        c00032.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(title5);
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(poster5);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(description5);
                        c00032.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                        c00032.L$9 = SpillingKt.nullOutSpilledVariable(status6);
                        c00032.L$10 = SpillingKt.nullOutSpilledVariable(actors6);
                        c00032.L$11 = SpillingKt.nullOutSpilledVariable(episodes2);
                        c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex5);
                        c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch4);
                        c00032.L$14 = SpillingKt.nullOutSpilledVariable(tmdbData5);
                        c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                        c00032.L$16 = SpillingKt.nullOutSpilledVariable(episodes);
                        c00032.L$17 = SpillingKt.nullOutSpilledVariable(recommendation);
                        c00032.L$18 = SpillingKt.nullOutSpilledVariable(epUrl);
                        c00032.Z$0 = isMovie5;
                        c00032.I$0 = extractedSeason5;
                        c00032.label = 7;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title5, url9, tvType11, epUrl, c00057, c00032);
                        if (objNewMovieLoadResponse == obj9) {
                            return obj9;
                        }
                        obj15 = objNewMovieLoadResponse;
                        return (LoadResponse) obj15;
                    }
                    String title9 = title5;
                    String url19 = url9;
                    TvType tvType12 = TvType.TvSeries;
                    List listReversed4 = CollectionsKt.reversed(episodes);
                    obj13 = obj9;
                    extractedSeason6 = extractedSeason5;
                    C00065 c00068 = new C00065(tmdbData5, backgroundposter3, poster5, description5, episodes2, status6, year5, actors6, recommendation, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(url19);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(title9);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(poster5);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(description5);
                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(status6);
                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(actors6);
                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(episodes2);
                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex5);
                    c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch4);
                    c00032.L$14 = SpillingKt.nullOutSpilledVariable(tmdbData5);
                    c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                    c00032.L$16 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00032.L$17 = SpillingKt.nullOutSpilledVariable(recommendation);
                    c00032.Z$0 = isMovie5;
                    c00032.I$0 = extractedSeason6;
                    c00032.label = 8;
                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title9, url19, tvType12, listReversed4, c00068, c00032);
                    if (objNewTvSeriesLoadResponse == obj13) {
                        return obj13;
                    }
                    obj14 = objNewTvSeriesLoadResponse;
                    seasonMatch5 = seasonMatch4;
                    seasonRegex6 = seasonRegex5;
                    episodes3 = episodes;
                    tmdbEpisodes5 = tmdbEpisodes2;
                    tmdbData6 = tmdbData5;
                    backgroundposter4 = backgroundposter3;
                    poster6 = poster5;
                    recommendation2 = recommendation;
                    return (LoadResponse) obj14;
                } catch (Exception e25) {
                    e = e25;
                    throw new ErrorLoadingException("Failed to fetch raw response: " + e.getMessage());
                }
            case 4:
                int extractedSeason7 = c00032.I$0;
                boolean isMovie6 = c00032.Z$0;
                MatchResult seasonMatch6 = (MatchResult) c00032.L$13;
                Regex seasonRegex7 = (Regex) c00032.L$12;
                actors3 = (List) c00032.L$11;
                List actors7 = (List) c00032.L$10;
                ShowStatus status7 = (ShowStatus) c00032.L$9;
                Integer year6 = (Integer) c00032.L$8;
                String description6 = (String) c00032.L$7;
                String backgroundposter5 = (String) c00032.L$6;
                String poster7 = (String) c00032.L$5;
                String title10 = (String) c00032.L$4;
                LoadData parser4 = (LoadData) c00032.L$3;
                String decryptedJson6 = (String) c00032.L$2;
                String rawResponse6 = (String) c00032.L$1;
                String url20 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result2);
                seasonRegex2 = seasonRegex7;
                extractedSeason = extractedSeason7;
                url2 = url20;
                obj7 = $result2;
                str = "Failed to parse decrypted JSON: ";
                str2 = "Failed to decrypt response: ";
                seasonMatch2 = seasonMatch6;
                description = description6;
                poster = poster7;
                parser2 = parser4;
                decryptedJson3 = decryptedJson6;
                rawResponse2 = rawResponse6;
                $result = coroutine_suspended;
                isMovie2 = isMovie6;
                year2 = year6;
                title2 = title10;
                oneTouchTV = this;
                status3 = status7;
                actors2 = actors7;
                backgroundposter = backgroundposter5;
                tmdbData = (TmdbData) obj7;
                if (isMovie2) {
                }
                String url110 = url2;
                obj8 = $result;
                String str14 = poster;
                tmdbData2 = tmdbData;
                extractedSeason2 = extractedSeason;
                year3 = year2;
                actors4 = actors2;
                poster3 = str14;
                List list11 = actors3;
                description2 = description;
                tags2 = list11;
                decryptedJson4 = decryptedJson3;
                mapEmptyMap = MapsKt.emptyMap();
                title3 = title2;
                isMovie3 = isMovie2;
                status4 = status3;
                url4 = url110;
                seasonRegex3 = seasonRegex2;
                parser3 = parser2;
                rawResponse3 = rawResponse2;
                seasonMatch3 = seasonMatch2;
                tmdbEpisodes = mapEmptyMap;
                Iterable $this$mapNotNull$iv5 = parser3.getEpisodes();
                destination$iv$iv3 = new ArrayList();
                while (r32.hasNext()) {
                    Object obj117 = obj8;
                    ep = (EpisodeItem) element$iv$iv$iv;
                    identifier = ep.getIdentifier();
                    if (identifier == null) {
                        tmdbEpisodes4 = tmdbEpisodes;
                        episodeNewEpisode = null;
                        isMovie3 = isMovie3;
                    } else {
                        episode = ep.getEpisode();
                        if (episode != null) {
                            intOrNull3 = StringsKt.toIntOrNull(episode);
                        } else {
                            intOrNull3 = null;
                        }
                        epNum = intOrNull3;
                        if (epNum != null) {
                            tmdbEpisodes3 = tmdbEpisodes;
                            epNum2 = epNum;
                            tmdbEpisode = (TmdbEpisode) tmdbEpisodes3.get(epNum2);
                        } else {
                            tmdbEpisodes3 = tmdbEpisodes;
                            epNum2 = epNum;
                            tmdbEpisode = null;
                        }
                        final TmdbEpisode tmdbEp5 = tmdbEpisode;
                        tmdbEpisodes4 = tmdbEpisodes3;
                        episodeNewEpisode = MainAPIKt.newEpisode(this, getMainUrl() + "/vod/" + identifier + "/episode/" + playId, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj118) {
                                return OneTouchTV.load$lambda$7$0(tmdbEp5, ep, epNum2, extractedSeason2, (Episode) obj118);
                            }
                        });
                    }
                    if (episodeNewEpisode != null) {
                        destination$iv$iv3.add(episodeNewEpisode);
                    }
                    isMovie3 = isMovie3;
                    obj8 = obj117;
                    tmdbEpisodes = tmdbEpisodes4;
                    tmdbData2 = tmdbData2;
                    tags2 = tags2;
                    actors4 = actors4;
                }
                Object obj118 = obj8;
                tmdbData4 = tmdbData2;
                tags3 = tags2;
                actors5 = actors4;
                tmdbEpisodes2 = tmdbEpisodes;
                isMovie4 = isMovie3;
                List episodes8 = (List) destination$iv$iv3;
                Requests app7 = MainActivityKt.getApp();
                String str15 = getMainUrl() + "/vod/top";
                c00032.L$0 = url4;
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                c00032.L$4 = title3;
                c00032.L$5 = poster3;
                c00032.L$6 = backgroundposter;
                c00032.L$7 = description2;
                c00032.L$8 = year3;
                c00032.L$9 = status4;
                c00032.L$10 = actors5;
                c00032.L$11 = tags3;
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch3);
                c00032.L$14 = tmdbData4;
                c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                c00032.L$16 = episodes8;
                c00032.Z$0 = isMovie4;
                c00032.I$0 = extractedSeason2;
                c00032.label = 6;
                title4 = title3;
                C00031 c00037 = c00032;
                status5 = status4;
                year4 = year3;
                description4 = description2;
                backgroundposter2 = backgroundposter;
                poster4 = poster3;
                episodes = episodes8;
                url6 = url4;
                obj9 = obj118;
                extractedSeason4 = extractedSeason2;
                obj10 = Requests.get$default(app7, str15, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00037, 4094, (Object) null);
                c00032 = c00037;
                if (obj10 == obj9) {
                    return obj9;
                }
                obj11 = obj10;
                extractedSeason5 = extractedSeason4;
                url7 = title4;
                description5 = description4;
                status6 = status5;
                year5 = year4;
                backgroundposter3 = backgroundposter2;
                poster5 = poster4;
                isMovie5 = isMovie4;
                url8 = url6;
                tmdbData5 = tmdbData4;
                episodes2 = tags3;
                actors6 = actors5;
                seasonRegex5 = seasonRegex3;
                seasonMatch4 = seasonMatch3;
                String rawTopResponse5 = ((NiceResponse) obj11).getText();
                topJson = DecryptionKt.decryptString(rawTopResponse5);
                AppUtils appUtils9 = AppUtils.INSTANCE;
                Result.Companion companion112 = Result.Companion;
                KType kTypeTypeOf9 = Reflection.typeOf(OneTouchTVParser.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj12 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf9));
                if (Result.exceptionOrNull-impl(obj12) == null) {
                    Result.Companion companion113 = Result.Companion;
                    title5 = url7;
                    url9 = url8;
                    url10 = null;
                    obj12 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(OneTouchTVParser.class), (List) null, 2, (Object) null));
                    break;
                } else {
                    title5 = url7;
                    url9 = url8;
                    url10 = null;
                }
                if (Result.isFailure-impl(obj12)) {
                    obj12 = url10;
                }
                deserializationStrategy3 = (KSerializer) obj12;
                if (deserializationStrategy3 != null) {
                    objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, topJson);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv15 = MainAPIKt.getMapper();
                    objDecodeFromString3 = $this$readValue$iv$iv15.readValue(topJson, new TypeReference<OneTouchTVParser>() { // from class: com.OneTouchTV.OneTouchTV$load$$inlined$parseJson$3
                    });
                }
                topParser = (OneTouchTVParser) objDecodeFromString3;
                $this$load_u24lambda_u248 = CollectionsKt.createListBuilder();
                $this$forEach$iv = topParser.getDay();
                if ($this$forEach$iv != null) {
                    it3 = $this$forEach$iv.iterator();
                    while (it3.hasNext()) {
                        Object element$iv7 = it3.next();
                        OneTouchTVParser topParser7 = topParser;
                        List list12 = $this$load_u24lambda_u248;
                        Iterator it12 = it3;
                        $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Day) element$iv7));
                        topParser = topParser7;
                        it3 = it12;
                        $this$load_u24lambda_u248 = list12;
                    }
                    topParser2 = topParser;
                    list = $this$load_u24lambda_u248;
                    Unit unit13 = Unit.INSTANCE;
                } else {
                    topParser2 = topParser;
                    list = $this$load_u24lambda_u248;
                }
                week = topParser2.getWeek();
                if (week != null) {
                    $this$forEach$iv3 = week;
                    while (r6.hasNext()) {
                        $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Week) element$iv2));
                        $this$forEach$iv3 = $this$forEach$iv3;
                    }
                    Unit unit14 = Unit.INSTANCE;
                }
                month = topParser2.getMonth();
                if (month != null) {
                    $this$forEach$iv2 = month;
                    while (r6.hasNext()) {
                        $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Month) element$iv3));
                        $this$forEach$iv2 = $this$forEach$iv2;
                    }
                    Unit unit15 = Unit.INSTANCE;
                }
                allMedia = CollectionsKt.build(list);
                $this$map$iv3 = allMedia;
                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r12.hasNext()) {
                    List allMedia6 = allMedia;
                    Iterable $this$map$iv10 = $this$map$iv3;
                    destination$iv$iv4.add(toSearchResponse((OneTouchMedia) item$iv$iv3));
                    $this$map$iv3 = $this$map$iv10;
                    allMedia = allMedia6;
                }
                recommendation = (List) destination$iv$iv4;
                if (isMovie5) {
                    episode2 = (Episode) CollectionsKt.firstOrNull(episodes);
                    if (episode2 != null) {
                        epUrl = url9;
                    } else {
                        epUrl = url9;
                    }
                    TvType tvType13 = TvType.Movie;
                    C00054 c00058 = new C00054(tmdbData5, backgroundposter3, poster5, description5, episodes2, year5, actors6, recommendation, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(title5);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(poster5);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(description5);
                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(status6);
                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(actors6);
                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(episodes2);
                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex5);
                    c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch4);
                    c00032.L$14 = SpillingKt.nullOutSpilledVariable(tmdbData5);
                    c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                    c00032.L$16 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00032.L$17 = SpillingKt.nullOutSpilledVariable(recommendation);
                    c00032.L$18 = SpillingKt.nullOutSpilledVariable(epUrl);
                    c00032.Z$0 = isMovie5;
                    c00032.I$0 = extractedSeason5;
                    c00032.label = 7;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title5, url9, tvType13, epUrl, c00058, c00032);
                    if (objNewMovieLoadResponse == obj9) {
                        return obj9;
                    }
                    obj15 = objNewMovieLoadResponse;
                    return (LoadResponse) obj15;
                }
                String title11 = title5;
                String url111 = url9;
                TvType tvType14 = TvType.TvSeries;
                List listReversed5 = CollectionsKt.reversed(episodes);
                obj13 = obj9;
                extractedSeason6 = extractedSeason5;
                C00065 c00069 = new C00065(tmdbData5, backgroundposter3, poster5, description5, episodes2, status6, year5, actors6, recommendation, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(url111);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(title11);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(poster5);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(description5);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(status6);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(actors6);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(episodes2);
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex5);
                c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch4);
                c00032.L$14 = SpillingKt.nullOutSpilledVariable(tmdbData5);
                c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                c00032.L$16 = SpillingKt.nullOutSpilledVariable(episodes);
                c00032.L$17 = SpillingKt.nullOutSpilledVariable(recommendation);
                c00032.Z$0 = isMovie5;
                c00032.I$0 = extractedSeason6;
                c00032.label = 8;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title11, url111, tvType14, listReversed5, c00069, c00032);
                if (objNewTvSeriesLoadResponse == obj13) {
                    return obj13;
                }
                obj14 = objNewTvSeriesLoadResponse;
                seasonMatch5 = seasonMatch4;
                seasonRegex6 = seasonRegex5;
                episodes3 = episodes;
                tmdbEpisodes5 = tmdbEpisodes2;
                tmdbData6 = tmdbData5;
                backgroundposter4 = backgroundposter3;
                poster6 = poster5;
                recommendation2 = recommendation;
                return (LoadResponse) obj14;
            case 5:
                int extractedSeason8 = c00032.I$0;
                isMovie2 = c00032.Z$0;
                tmdbData3 = (TmdbData) c00032.L$14;
                MatchResult seasonMatch7 = (MatchResult) c00032.L$13;
                Regex seasonRegex8 = (Regex) c00032.L$12;
                List tags4 = (List) c00032.L$11;
                List actors8 = (List) c00032.L$10;
                ShowStatus status8 = (ShowStatus) c00032.L$9;
                extractedSeason3 = extractedSeason8;
                Integer year7 = (Integer) c00032.L$8;
                description3 = (String) c00032.L$7;
                String backgroundposter6 = (String) c00032.L$6;
                String poster8 = (String) c00032.L$5;
                String title12 = (String) c00032.L$4;
                LoadData parser5 = (LoadData) c00032.L$3;
                decryptedJson5 = (String) c00032.L$2;
                String rawResponse7 = (String) c00032.L$1;
                String url21 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result2);
                obj8 = coroutine_suspended;
                str = "Failed to parse decrypted JSON: ";
                str2 = "Failed to decrypt response: ";
                seasonMatch2 = seasonMatch7;
                seasonRegex4 = seasonRegex8;
                poster = poster8;
                title2 = title12;
                rawResponse2 = rawResponse7;
                actors2 = actors8;
                status3 = status8;
                backgroundposter = backgroundposter6;
                actors3 = tags4;
                year2 = year7;
                url5 = url21;
                parser2 = parser5;
                List list13 = actors2;
                poster3 = poster;
                tmdbData2 = tmdbData3;
                year3 = year2;
                actors4 = list13;
                mapEmptyMap = (Map) $result2;
                title3 = title2;
                isMovie3 = isMovie2;
                tags2 = actors3;
                description2 = description3;
                decryptedJson4 = decryptedJson5;
                status4 = status3;
                url4 = url5;
                seasonRegex3 = seasonRegex4;
                extractedSeason2 = extractedSeason3;
                rawResponse3 = rawResponse2;
                parser3 = parser2;
                seasonMatch3 = seasonMatch2;
                tmdbEpisodes = mapEmptyMap;
                Iterable $this$mapNotNull$iv6 = parser3.getEpisodes();
                destination$iv$iv3 = new ArrayList();
                while (r32.hasNext()) {
                    Object obj119 = obj8;
                    ep = (EpisodeItem) element$iv$iv$iv;
                    identifier = ep.getIdentifier();
                    if (identifier == null) {
                        tmdbEpisodes4 = tmdbEpisodes;
                        episodeNewEpisode = null;
                        isMovie3 = isMovie3;
                    } else {
                        episode = ep.getEpisode();
                        if (episode != null) {
                            intOrNull3 = StringsKt.toIntOrNull(episode);
                        } else {
                            intOrNull3 = null;
                        }
                        epNum = intOrNull3;
                        if (epNum != null) {
                            tmdbEpisodes3 = tmdbEpisodes;
                            epNum2 = epNum;
                            tmdbEpisode = (TmdbEpisode) tmdbEpisodes3.get(epNum2);
                        } else {
                            tmdbEpisodes3 = tmdbEpisodes;
                            epNum2 = epNum;
                            tmdbEpisode = null;
                        }
                        final TmdbEpisode tmdbEp6 = tmdbEpisode;
                        tmdbEpisodes4 = tmdbEpisodes3;
                        episodeNewEpisode = MainAPIKt.newEpisode(this, getMainUrl() + "/vod/" + identifier + "/episode/" + playId, new Function1() { // from class: com.OneTouchTV.OneTouchTV$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj1110) {
                                return OneTouchTV.load$lambda$7$0(tmdbEp6, ep, epNum2, extractedSeason2, (Episode) obj1110);
                            }
                        });
                    }
                    if (episodeNewEpisode != null) {
                        destination$iv$iv3.add(episodeNewEpisode);
                    }
                    isMovie3 = isMovie3;
                    obj8 = obj119;
                    tmdbEpisodes = tmdbEpisodes4;
                    tmdbData2 = tmdbData2;
                    tags2 = tags2;
                    actors4 = actors4;
                }
                Object obj1110 = obj8;
                tmdbData4 = tmdbData2;
                tags3 = tags2;
                actors5 = actors4;
                tmdbEpisodes2 = tmdbEpisodes;
                isMovie4 = isMovie3;
                List episodes9 = (List) destination$iv$iv3;
                Requests app8 = MainActivityKt.getApp();
                String str16 = getMainUrl() + "/vod/top";
                c00032.L$0 = url4;
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                c00032.L$4 = title3;
                c00032.L$5 = poster3;
                c00032.L$6 = backgroundposter;
                c00032.L$7 = description2;
                c00032.L$8 = year3;
                c00032.L$9 = status4;
                c00032.L$10 = actors5;
                c00032.L$11 = tags3;
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex3);
                c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch3);
                c00032.L$14 = tmdbData4;
                c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                c00032.L$16 = episodes9;
                c00032.Z$0 = isMovie4;
                c00032.I$0 = extractedSeason2;
                c00032.label = 6;
                title4 = title3;
                C00031 c00038 = c00032;
                status5 = status4;
                year4 = year3;
                description4 = description2;
                backgroundposter2 = backgroundposter;
                poster4 = poster3;
                episodes = episodes9;
                url6 = url4;
                obj9 = obj1110;
                extractedSeason4 = extractedSeason2;
                obj10 = Requests.get$default(app8, str16, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00038, 4094, (Object) null);
                c00032 = c00038;
                if (obj10 == obj9) {
                    return obj9;
                }
                obj11 = obj10;
                extractedSeason5 = extractedSeason4;
                url7 = title4;
                description5 = description4;
                status6 = status5;
                year5 = year4;
                backgroundposter3 = backgroundposter2;
                poster5 = poster4;
                isMovie5 = isMovie4;
                url8 = url6;
                tmdbData5 = tmdbData4;
                episodes2 = tags3;
                actors6 = actors5;
                seasonRegex5 = seasonRegex3;
                seasonMatch4 = seasonMatch3;
                String rawTopResponse6 = ((NiceResponse) obj11).getText();
                topJson = DecryptionKt.decryptString(rawTopResponse6);
                AppUtils appUtils10 = AppUtils.INSTANCE;
                Result.Companion companion114 = Result.Companion;
                KType kTypeTypeOf10 = Reflection.typeOf(OneTouchTVParser.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj12 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf10));
                if (Result.exceptionOrNull-impl(obj12) == null) {
                    Result.Companion companion115 = Result.Companion;
                    title5 = url7;
                    url9 = url8;
                    url10 = null;
                    obj12 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(OneTouchTVParser.class), (List) null, 2, (Object) null));
                    break;
                } else {
                    title5 = url7;
                    url9 = url8;
                    url10 = null;
                }
                if (Result.isFailure-impl(obj12)) {
                    obj12 = url10;
                }
                deserializationStrategy3 = (KSerializer) obj12;
                if (deserializationStrategy3 != null) {
                    objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, topJson);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv16 = MainAPIKt.getMapper();
                    objDecodeFromString3 = $this$readValue$iv$iv16.readValue(topJson, new TypeReference<OneTouchTVParser>() { // from class: com.OneTouchTV.OneTouchTV$load$$inlined$parseJson$3
                    });
                }
                topParser = (OneTouchTVParser) objDecodeFromString3;
                $this$load_u24lambda_u248 = CollectionsKt.createListBuilder();
                $this$forEach$iv = topParser.getDay();
                if ($this$forEach$iv != null) {
                    it3 = $this$forEach$iv.iterator();
                    while (it3.hasNext()) {
                        Object element$iv8 = it3.next();
                        OneTouchTVParser topParser8 = topParser;
                        List list14 = $this$load_u24lambda_u248;
                        Iterator it13 = it3;
                        $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Day) element$iv8));
                        topParser = topParser8;
                        it3 = it13;
                        $this$load_u24lambda_u248 = list14;
                    }
                    topParser2 = topParser;
                    list = $this$load_u24lambda_u248;
                    Unit unit16 = Unit.INSTANCE;
                } else {
                    topParser2 = topParser;
                    list = $this$load_u24lambda_u248;
                }
                week = topParser2.getWeek();
                if (week != null) {
                    $this$forEach$iv3 = week;
                    while (r6.hasNext()) {
                        $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Week) element$iv2));
                        $this$forEach$iv3 = $this$forEach$iv3;
                    }
                    Unit unit17 = Unit.INSTANCE;
                }
                month = topParser2.getMonth();
                if (month != null) {
                    $this$forEach$iv2 = month;
                    while (r6.hasNext()) {
                        $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Month) element$iv3));
                        $this$forEach$iv2 = $this$forEach$iv2;
                    }
                    Unit unit18 = Unit.INSTANCE;
                }
                allMedia = CollectionsKt.build(list);
                $this$map$iv3 = allMedia;
                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r12.hasNext()) {
                    List allMedia7 = allMedia;
                    Iterable $this$map$iv11 = $this$map$iv3;
                    destination$iv$iv4.add(toSearchResponse((OneTouchMedia) item$iv$iv3));
                    $this$map$iv3 = $this$map$iv11;
                    allMedia = allMedia7;
                }
                recommendation = (List) destination$iv$iv4;
                if (isMovie5) {
                    episode2 = (Episode) CollectionsKt.firstOrNull(episodes);
                    if (episode2 != null) {
                        epUrl = url9;
                    } else {
                        epUrl = url9;
                    }
                    TvType tvType15 = TvType.Movie;
                    C00054 c00059 = new C00054(tmdbData5, backgroundposter3, poster5, description5, episodes2, year5, actors6, recommendation, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(title5);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(poster5);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(description5);
                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(status6);
                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(actors6);
                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(episodes2);
                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex5);
                    c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch4);
                    c00032.L$14 = SpillingKt.nullOutSpilledVariable(tmdbData5);
                    c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                    c00032.L$16 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00032.L$17 = SpillingKt.nullOutSpilledVariable(recommendation);
                    c00032.L$18 = SpillingKt.nullOutSpilledVariable(epUrl);
                    c00032.Z$0 = isMovie5;
                    c00032.I$0 = extractedSeason5;
                    c00032.label = 7;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title5, url9, tvType15, epUrl, c00059, c00032);
                    if (objNewMovieLoadResponse == obj9) {
                        return obj9;
                    }
                    obj15 = objNewMovieLoadResponse;
                    return (LoadResponse) obj15;
                }
                String title13 = title5;
                String url112 = url9;
                TvType tvType16 = TvType.TvSeries;
                List listReversed6 = CollectionsKt.reversed(episodes);
                obj13 = obj9;
                extractedSeason6 = extractedSeason5;
                C00065 c000610 = new C00065(tmdbData5, backgroundposter3, poster5, description5, episodes2, status6, year5, actors6, recommendation, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(url112);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(title13);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(poster5);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(description5);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(status6);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(actors6);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(episodes2);
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex5);
                c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch4);
                c00032.L$14 = SpillingKt.nullOutSpilledVariable(tmdbData5);
                c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                c00032.L$16 = SpillingKt.nullOutSpilledVariable(episodes);
                c00032.L$17 = SpillingKt.nullOutSpilledVariable(recommendation);
                c00032.Z$0 = isMovie5;
                c00032.I$0 = extractedSeason6;
                c00032.label = 8;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title13, url112, tvType16, listReversed6, c000610, c00032);
                if (objNewTvSeriesLoadResponse == obj13) {
                    return obj13;
                }
                obj14 = objNewTvSeriesLoadResponse;
                seasonMatch5 = seasonMatch4;
                seasonRegex6 = seasonRegex5;
                episodes3 = episodes;
                tmdbEpisodes5 = tmdbEpisodes2;
                tmdbData6 = tmdbData5;
                backgroundposter4 = backgroundposter3;
                poster6 = poster5;
                recommendation2 = recommendation;
                return (LoadResponse) obj14;
            case 6:
                int extractedSeason9 = c00032.I$0;
                boolean isMovie7 = c00032.Z$0;
                List episodes10 = (List) c00032.L$16;
                Map tmdbEpisodes6 = (Map) c00032.L$15;
                TmdbData tmdbData7 = (TmdbData) c00032.L$14;
                MatchResult seasonMatch8 = (MatchResult) c00032.L$13;
                Regex seasonRegex9 = (Regex) c00032.L$12;
                List tags5 = (List) c00032.L$11;
                List actors9 = (List) c00032.L$10;
                ShowStatus status9 = (ShowStatus) c00032.L$9;
                Integer year8 = (Integer) c00032.L$8;
                String description7 = (String) c00032.L$7;
                String backgroundposter7 = (String) c00032.L$6;
                String poster9 = (String) c00032.L$5;
                String title14 = (String) c00032.L$4;
                LoadData parser6 = (LoadData) c00032.L$3;
                decryptedJson4 = (String) c00032.L$2;
                rawResponse3 = (String) c00032.L$1;
                String url22 = (String) c00032.L$0;
                try {
                    ResultKt.throwOnFailure($result2);
                    seasonMatch4 = seasonMatch8;
                    actors6 = actors9;
                    obj11 = $result2;
                    obj9 = coroutine_suspended;
                    str = "Failed to parse decrypted JSON: ";
                    str2 = "Failed to decrypt response: ";
                    extractedSeason5 = extractedSeason9;
                    isMovie5 = isMovie7;
                    episodes = episodes10;
                    tmdbEpisodes2 = tmdbEpisodes6;
                    tmdbData5 = tmdbData7;
                    episodes2 = tags5;
                    status6 = status9;
                    year5 = year8;
                    description5 = description7;
                    backgroundposter3 = backgroundposter7;
                    poster5 = poster9;
                    parser3 = parser6;
                    url8 = url22;
                    seasonRegex5 = seasonRegex9;
                    url7 = title14;
                    String rawTopResponse7 = ((NiceResponse) obj11).getText();
                    topJson = DecryptionKt.decryptString(rawTopResponse7);
                    AppUtils appUtils11 = AppUtils.INSTANCE;
                    Result.Companion companion116 = Result.Companion;
                    KType kTypeTypeOf11 = Reflection.typeOf(OneTouchTVParser.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj12 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf11));
                    if (Result.exceptionOrNull-impl(obj12) == null) {
                        Result.Companion companion117 = Result.Companion;
                        title5 = url7;
                        url9 = url8;
                        url10 = null;
                        obj12 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(OneTouchTVParser.class), (List) null, 2, (Object) null));
                        break;
                    } else {
                        title5 = url7;
                        url9 = url8;
                        url10 = null;
                    }
                    if (Result.isFailure-impl(obj12)) {
                        obj12 = url10;
                    }
                    deserializationStrategy3 = (KSerializer) obj12;
                    if (deserializationStrategy3 != null) {
                        objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, topJson);
                        break;
                    } else {
                        ObjectMapper $this$readValue$iv$iv17 = MainAPIKt.getMapper();
                        objDecodeFromString3 = $this$readValue$iv$iv17.readValue(topJson, new TypeReference<OneTouchTVParser>() { // from class: com.OneTouchTV.OneTouchTV$load$$inlined$parseJson$3
                        });
                    }
                    topParser = (OneTouchTVParser) objDecodeFromString3;
                    $this$load_u24lambda_u248 = CollectionsKt.createListBuilder();
                    $this$forEach$iv = topParser.getDay();
                    if ($this$forEach$iv != null) {
                        it3 = $this$forEach$iv.iterator();
                        while (it3.hasNext()) {
                            Object element$iv9 = it3.next();
                            OneTouchTVParser topParser9 = topParser;
                            List list15 = $this$load_u24lambda_u248;
                            Iterator it14 = it3;
                            $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Day) element$iv9));
                            topParser = topParser9;
                            it3 = it14;
                            $this$load_u24lambda_u248 = list15;
                        }
                        topParser2 = topParser;
                        list = $this$load_u24lambda_u248;
                        Unit unit19 = Unit.INSTANCE;
                    } else {
                        topParser2 = topParser;
                        list = $this$load_u24lambda_u248;
                    }
                    week = topParser2.getWeek();
                    if (week != null) {
                        $this$forEach$iv3 = week;
                        while (r6.hasNext()) {
                            $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Week) element$iv2));
                            $this$forEach$iv3 = $this$forEach$iv3;
                        }
                        Unit unit110 = Unit.INSTANCE;
                    }
                    month = topParser2.getMonth();
                    if (month != null) {
                        $this$forEach$iv2 = month;
                        while (r6.hasNext()) {
                            $this$load_u24lambda_u248.add(toMedia((OneTouchTVParser.Month) element$iv3));
                            $this$forEach$iv2 = $this$forEach$iv2;
                        }
                        Unit unit111 = Unit.INSTANCE;
                    }
                    allMedia = CollectionsKt.build(list);
                    $this$map$iv3 = allMedia;
                    destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                    while (r12.hasNext()) {
                        List allMedia8 = allMedia;
                        Iterable $this$map$iv12 = $this$map$iv3;
                        destination$iv$iv4.add(toSearchResponse((OneTouchMedia) item$iv$iv3));
                        $this$map$iv3 = $this$map$iv12;
                        allMedia = allMedia8;
                    }
                    recommendation = (List) destination$iv$iv4;
                    if (isMovie5) {
                        episode2 = (Episode) CollectionsKt.firstOrNull(episodes);
                        if (episode2 != null) {
                            epUrl = url9;
                        } else {
                            epUrl = url9;
                        }
                        TvType tvType17 = TvType.Movie;
                        C00054 c000510 = new C00054(tmdbData5, backgroundposter3, poster5, description5, episodes2, year5, actors6, recommendation, null);
                        c00032.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(title5);
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(poster5);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(description5);
                        c00032.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                        c00032.L$9 = SpillingKt.nullOutSpilledVariable(status6);
                        c00032.L$10 = SpillingKt.nullOutSpilledVariable(actors6);
                        c00032.L$11 = SpillingKt.nullOutSpilledVariable(episodes2);
                        c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex5);
                        c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch4);
                        c00032.L$14 = SpillingKt.nullOutSpilledVariable(tmdbData5);
                        c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                        c00032.L$16 = SpillingKt.nullOutSpilledVariable(episodes);
                        c00032.L$17 = SpillingKt.nullOutSpilledVariable(recommendation);
                        c00032.L$18 = SpillingKt.nullOutSpilledVariable(epUrl);
                        c00032.Z$0 = isMovie5;
                        c00032.I$0 = extractedSeason5;
                        c00032.label = 7;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title5, url9, tvType17, epUrl, c000510, c00032);
                        if (objNewMovieLoadResponse == obj9) {
                            return obj9;
                        }
                        obj15 = objNewMovieLoadResponse;
                        return (LoadResponse) obj15;
                    }
                    String title15 = title5;
                    String url113 = url9;
                    TvType tvType18 = TvType.TvSeries;
                    List listReversed7 = CollectionsKt.reversed(episodes);
                    obj13 = obj9;
                    extractedSeason6 = extractedSeason5;
                    C00065 c000611 = new C00065(tmdbData5, backgroundposter3, poster5, description5, episodes2, status6, year5, actors6, recommendation, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(url113);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson4);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(parser3);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(title15);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(poster5);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(description5);
                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(status6);
                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(actors6);
                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(episodes2);
                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(seasonRegex5);
                    c00032.L$13 = SpillingKt.nullOutSpilledVariable(seasonMatch4);
                    c00032.L$14 = SpillingKt.nullOutSpilledVariable(tmdbData5);
                    c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbEpisodes2);
                    c00032.L$16 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00032.L$17 = SpillingKt.nullOutSpilledVariable(recommendation);
                    c00032.Z$0 = isMovie5;
                    c00032.I$0 = extractedSeason6;
                    c00032.label = 8;
                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title15, url113, tvType18, listReversed7, c000611, c00032);
                    if (objNewTvSeriesLoadResponse == obj13) {
                        return obj13;
                    }
                    obj14 = objNewTvSeriesLoadResponse;
                    seasonMatch5 = seasonMatch4;
                    seasonRegex6 = seasonRegex5;
                    episodes3 = episodes;
                    tmdbEpisodes5 = tmdbEpisodes2;
                    tmdbData6 = tmdbData5;
                    backgroundposter4 = backgroundposter3;
                    poster6 = poster5;
                    recommendation2 = recommendation;
                    return (LoadResponse) obj14;
                } catch (Exception e26) {
                    e = e26;
                    throw new ErrorLoadingException("Failed to load recommendations: " + e.getMessage());
                }
            case 7:
                int i3 = c00032.I$0;
                boolean z2 = c00032.Z$0;
                ResultKt.throwOnFailure($result2);
                obj15 = $result2;
                return (LoadResponse) obj15;
            case 8:
                int extractedSeason10 = c00032.I$0;
                boolean z3 = c00032.Z$0;
                recommendation2 = (List) c00032.L$17;
                episodes3 = (List) c00032.L$16;
                tmdbEpisodes5 = (Map) c00032.L$15;
                tmdbData6 = (TmdbData) c00032.L$14;
                seasonMatch5 = (MatchResult) c00032.L$13;
                seasonRegex6 = (Regex) c00032.L$12;
                backgroundposter4 = (String) c00032.L$6;
                poster6 = (String) c00032.L$5;
                ResultKt.throwOnFailure($result2);
                obj14 = $result2;
                extractedSeason6 = extractedSeason10;
                return (LoadResponse) obj14;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final Unit load$lambda$1(Episode $this$newEpisode) {
        $this$newEpisode.setName("Live Stream");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.OneTouchTV.OneTouchTV$load$3 */
    /* JADX INFO: compiled from: OneTouchTV.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.OneTouchTV.OneTouchTV$load$3", f = "OneTouchTV.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00043 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChannelItem $channel;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00043(ChannelItem channelItem, Continuation<? super C00043> continuation) {
            super(2, continuation);
            this.$channel = channelItem;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00043 = new C00043(this.$channel, continuation);
            c00043.L$0 = obj;
            return c00043;
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
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$channel.getLogo());
                    $this$newTvSeriesLoadResponse.setPlot(this.$channel.getCategory());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$7$0(TmdbEpisode $tmdbEp, EpisodeItem $ep, Integer $epNum, int $extractedSeason, Episode $this$newEpisode) {
        String string;
        String dateStr;
        Double rating;
        if ($tmdbEp == null || (string = $tmdbEp.getName()) == null) {
            StringBuilder sbAppend = new StringBuilder().append("Episode ");
            String episode = $ep.getEpisode();
            if (episode == null) {
                episode = "?";
            }
            string = sbAppend.append(episode).toString();
        }
        $this$newEpisode.setName(string);
        $this$newEpisode.setEpisode($epNum);
        $this$newEpisode.setSeason(Integer.valueOf($extractedSeason));
        $this$newEpisode.setPosterUrl($tmdbEp != null ? $tmdbEp.getStillPath() : null);
        $this$newEpisode.setDescription($tmdbEp != null ? $tmdbEp.getOverview() : null);
        if ($tmdbEp != null && (rating = $tmdbEp.getRating()) != null) {
            double it = rating.doubleValue();
            $this$newEpisode.setScore(Score.Companion.from10(String.valueOf(it)));
        }
        if ($tmdbEp != null && (dateStr = $tmdbEp.getAirDate()) != null) {
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(dateStr);
                $this$newEpisode.setDate(date != null ? Long.valueOf(date.getTime()) : null);
            } catch (Exception e) {
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.OneTouchTV.OneTouchTV$load$4 */
    /* JADX INFO: compiled from: OneTouchTV.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.OneTouchTV.OneTouchTV$load$4", f = "OneTouchTV.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nOneTouchTV.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneTouchTV.kt\ncom/OneTouchTV/OneTouchTV$load$4\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,745:1\n1#2:746\n*E\n"})
    static final class C00054 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $backgroundposter;
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<SearchResponse> $recommendation;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ TmdbData $tmdbData;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00054(TmdbData tmdbData, String str, String str2, String str3, List<String> list, Integer num, List<ActorData> list2, List<? extends SearchResponse> list3, Continuation<? super C00054> continuation) {
            super(2, continuation);
            this.$tmdbData = tmdbData;
            this.$backgroundposter = str;
            this.$poster = str2;
            this.$description = str3;
            this.$tags = list;
            this.$year = num;
            this.$actors = list2;
            this.$recommendation = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00054 = new C00054(this.$tmdbData, this.$backgroundposter, this.$poster, this.$description, this.$tags, this.$year, this.$actors, this.$recommendation, continuation);
            c00054.L$0 = obj;
            return c00054;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String backdropPath;
            String posterPath;
            String overview;
            Integer intOrNull;
            String strValueOf;
            String releaseDate;
            String strTake;
            MovieLoadResponse $this$newMovieLoadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    TmdbData tmdbData = this.$tmdbData;
                    if (tmdbData == null || (backdropPath = tmdbData.getBackdropPath()) == null) {
                        backdropPath = this.$backgroundposter;
                    }
                    $this$newMovieLoadResponse.setBackgroundPosterUrl(backdropPath);
                    TmdbData tmdbData2 = this.$tmdbData;
                    if (tmdbData2 == null || (posterPath = tmdbData2.getPosterPath()) == null) {
                        posterPath = this.$poster;
                    }
                    $this$newMovieLoadResponse.setPosterUrl(posterPath);
                    TmdbData tmdbData3 = this.$tmdbData;
                    if (tmdbData3 == null || (overview = tmdbData3.getOverview()) == null) {
                        overview = this.$description;
                    }
                    $this$newMovieLoadResponse.setPlot(overview);
                    $this$newMovieLoadResponse.setTags(this.$tags);
                    TmdbData tmdbData4 = this.$tmdbData;
                    if (tmdbData4 == null || (releaseDate = tmdbData4.getReleaseDate()) == null || (strTake = StringsKt.take(releaseDate, 4)) == null || (intOrNull = StringsKt.toIntOrNull(strTake)) == null) {
                        Integer num = this.$year;
                        intOrNull = (num == null || (strValueOf = String.valueOf(num.intValue())) == null) ? null : StringsKt.toIntOrNull(strValueOf);
                    }
                    $this$newMovieLoadResponse.setYear(intOrNull);
                    TmdbData tmdbData5 = this.$tmdbData;
                    if (tmdbData5 != null) {
                        double it = tmdbData5.getRating();
                        $this$newMovieLoadResponse.setScore(Score.Companion.from10(String.valueOf(it)));
                    }
                    $this$newMovieLoadResponse.setActors(this.$actors);
                    $this$newMovieLoadResponse.setRecommendations(this.$recommendation);
                    TmdbData tmdbData6 = this.$tmdbData;
                    if (tmdbData6 != null) {
                        int id = tmdbData6.getId();
                        try {
                            Method method = $this$newMovieLoadResponse.getClass().getMethod("setSyncData", Map.class);
                            method.invoke($this$newMovieLoadResponse, MapsKt.mapOf(TuplesKt.to("tmdb", String.valueOf(id))));
                            break;
                        } catch (Exception e) {
                        }
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.OneTouchTV.OneTouchTV$load$5 */
    /* JADX INFO: compiled from: OneTouchTV.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.OneTouchTV.OneTouchTV$load$5", f = "OneTouchTV.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nOneTouchTV.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneTouchTV.kt\ncom/OneTouchTV/OneTouchTV$load$5\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,745:1\n1#2:746\n*E\n"})
    static final class C00065 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $backgroundposter;
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<SearchResponse> $recommendation;
        final /* synthetic */ ShowStatus $status;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ TmdbData $tmdbData;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00065(TmdbData tmdbData, String str, String str2, String str3, List<String> list, ShowStatus showStatus, Integer num, List<ActorData> list2, List<? extends SearchResponse> list3, Continuation<? super C00065> continuation) {
            super(2, continuation);
            this.$tmdbData = tmdbData;
            this.$backgroundposter = str;
            this.$poster = str2;
            this.$description = str3;
            this.$tags = list;
            this.$status = showStatus;
            this.$year = num;
            this.$actors = list2;
            this.$recommendation = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00065 = new C00065(this.$tmdbData, this.$backgroundposter, this.$poster, this.$description, this.$tags, this.$status, this.$year, this.$actors, this.$recommendation, continuation);
            c00065.L$0 = obj;
            return c00065;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String backdropPath;
            String posterPath;
            String overview;
            Integer intOrNull;
            String strValueOf;
            String releaseDate;
            String strTake;
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    TmdbData tmdbData = this.$tmdbData;
                    if (tmdbData == null || (backdropPath = tmdbData.getBackdropPath()) == null) {
                        backdropPath = this.$backgroundposter;
                    }
                    $this$newTvSeriesLoadResponse.setBackgroundPosterUrl(backdropPath);
                    TmdbData tmdbData2 = this.$tmdbData;
                    if (tmdbData2 == null || (posterPath = tmdbData2.getPosterPath()) == null) {
                        posterPath = this.$poster;
                    }
                    $this$newTvSeriesLoadResponse.setPosterUrl(posterPath);
                    TmdbData tmdbData3 = this.$tmdbData;
                    if (tmdbData3 == null || (overview = tmdbData3.getOverview()) == null) {
                        overview = this.$description;
                    }
                    $this$newTvSeriesLoadResponse.setPlot(overview);
                    $this$newTvSeriesLoadResponse.setTags(this.$tags);
                    $this$newTvSeriesLoadResponse.setShowStatus(this.$status);
                    TmdbData tmdbData4 = this.$tmdbData;
                    if (tmdbData4 == null || (releaseDate = tmdbData4.getReleaseDate()) == null || (strTake = StringsKt.take(releaseDate, 4)) == null || (intOrNull = StringsKt.toIntOrNull(strTake)) == null) {
                        Integer num = this.$year;
                        intOrNull = (num == null || (strValueOf = String.valueOf(num.intValue())) == null) ? null : StringsKt.toIntOrNull(strValueOf);
                    }
                    $this$newTvSeriesLoadResponse.setYear(intOrNull);
                    TmdbData tmdbData5 = this.$tmdbData;
                    if (tmdbData5 != null) {
                        double it = tmdbData5.getRating();
                        $this$newTvSeriesLoadResponse.setScore(Score.Companion.from10(String.valueOf(it)));
                    }
                    $this$newTvSeriesLoadResponse.setActors(this.$actors);
                    $this$newTvSeriesLoadResponse.setRecommendations(this.$recommendation);
                    TmdbData tmdbData6 = this.$tmdbData;
                    if (tmdbData6 != null) {
                        int id = tmdbData6.getId();
                        try {
                            Method method = $this$newTvSeriesLoadResponse.getClass().getMethod("setSyncData", Map.class);
                            method.invoke($this$newTvSeriesLoadResponse, MapsKt.mapOf(TuplesKt.to("tmdb", String.valueOf(id))));
                            break;
                        } catch (Exception e) {
                        }
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.OneTouchTV.OneTouchTV$loadLinks$2 */
    /* JADX INFO: compiled from: OneTouchTV.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.OneTouchTV.OneTouchTV$loadLinks$2", f = "OneTouchTV.kt", i = {0, 0, 1}, l = {574, 585}, m = "invokeSuspend", n = {"$this$coroutineScope", "type", "$this$coroutineScope"}, nl = {573, 586}, s = {"L$0", "L$1", "L$0"}, v = 2)
    static final class C00072 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $data;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00072(String str, Function1<? super ExtractorLink, Unit> function1, Function1<? super SubtitleFile, Unit> function2, Continuation<? super C00072> continuation) {
            super(2, continuation);
            this.$data = str;
            this.$callback = function1;
            this.$subtitleCallback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00072 = new C00072(this.$data, this.$callback, this.$subtitleCallback, continuation);
            c00072.L$0 = obj;
            return c00072;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
        public final Object invokeSuspend(Object $result) throws ErrorLoadingException {
            Object objNewExtractorLink$default;
            Function1<ExtractorLink, Unit> function1;
            Object obj;
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (StringsKt.contains$default(this.$data, ".m3u8", false, 2, (Object) null) || StringsKt.contains$default(this.$data, ".mp4", false, 2, (Object) null)) {
                            ExtractorLinkType type = StringsKt.contains$default(this.$data, ".m3u8", false, 2, (Object) null) ? ExtractorLinkType.M3U8 : ExtractorLinkType.VIDEO;
                            Function1<ExtractorLink, Unit> function2 = this.$callback;
                            this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(type);
                            this.L$2 = function2;
                            this.label = 1;
                            objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("Live", "Live", this.$data, type, (Function2) null, (Continuation) this, 16, (Object) null);
                            if (objNewExtractorLink$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function1 = function2;
                            function1.invoke(objNewExtractorLink$default);
                            return Boxing.boxBoolean(true);
                        }
                        this.L$0 = $this$coroutineScope;
                        this.label = 2;
                        obj = Requests.get$default(MainActivityKt.getApp(), this.$data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        String rawResponse = ((NiceResponse) obj).getText();
                        try {
                            String decryptedJson = DecryptionKt.decryptString(rawResponse);
                            Pair sourcesAndTracks$default = OneTouchTVParserKt.parseSourcesAndTracks$default(decryptedJson, null, null, 6, null);
                            List sources = (List) sourcesAndTracks$default.component1();
                            List tracks = (List) sourcesAndTracks$default.component2();
                            BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(tracks, this.$subtitleCallback, null), 3, (Object) null);
                            BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(sources, this.$callback, null), 3, (Object) null);
                            return Boxing.boxBoolean(true);
                        } catch (Exception e) {
                            throw new ErrorLoadingException("Failed to decrypt response: " + e.getMessage());
                        }
                    case 1:
                        function1 = (Function1) this.L$2;
                        ResultKt.throwOnFailure($result);
                        objNewExtractorLink$default = $result;
                        function1.invoke(objNewExtractorLink$default);
                        return Boxing.boxBoolean(true);
                    case 2:
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        String rawResponse2 = ((NiceResponse) obj).getText();
                        String decryptedJson2 = DecryptionKt.decryptString(rawResponse2);
                        Pair sourcesAndTracks$default2 = OneTouchTVParserKt.parseSourcesAndTracks$default(decryptedJson2, null, null, 6, null);
                        List sources2 = (List) sourcesAndTracks$default2.component1();
                        List tracks2 = (List) sourcesAndTracks$default2.component2();
                        BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(tracks2, this.$subtitleCallback, null), 3, (Object) null);
                        BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(sources2, this.$callback, null), 3, (Object) null);
                        return Boxing.boxBoolean(true);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e2) {
                throw new ErrorLoadingException("Failed to fetch raw response: " + e2.getMessage());
            }
        }

        /* JADX INFO: renamed from: com.OneTouchTV.OneTouchTV$loadLinks$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: OneTouchTV.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.OneTouchTV.OneTouchTV$loadLinks$2$1", f = "OneTouchTV.kt", i = {0}, l = {600}, m = "invokeSuspend", n = {"track"}, nl = {599}, s = {"L$1"}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
            final /* synthetic */ List<TrackItem> $tracks;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(List<TrackItem> list, Function1<? super SubtitleFile, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$tracks = list;
                this.$subtitleCallback = function1;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$tracks, this.$subtitleCallback, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0038  */
            /* JADX WARN: Code duplicated, block: B:12:0x0047  */
            /* JADX WARN: Code duplicated, block: B:18:0x006a A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:19:0x006b  */
            /* JADX WARN: Code duplicated, block: B:24:0x0051 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:26:? A[LOOP:0: B:8:0x0032->B:26:?, LOOP_END, SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006b -> B:20:0x0072). Please report as a decompilation issue!!! */
            /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
                java.lang.StackOverflowError
                	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
                	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
                */
            public final java.lang.Object invokeSuspend(java.lang.Object r14) {
                /*
                    r13 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r13.label
                    switch(r1) {
                        case 0: goto L27;
                        case 1: goto L11;
                        default: goto L9;
                    }
                L9:
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                    r0.<init>(r1)
                    throw r0
                L11:
                    java.lang.Object r1 = r13.L$2
                    kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
                    java.lang.Object r2 = r13.L$1
                    com.OneTouchTV.TrackItem r2 = (com.OneTouchTV.TrackItem) r2
                    java.lang.Object r3 = r13.L$0
                    java.util.Iterator r3 = (java.util.Iterator) r3
                    kotlin.ResultKt.throwOnFailure(r14)
                    r4 = r1
                    r5 = r3
                    r1 = r0
                    r3 = r2
                    r2 = r13
                    r0 = r14
                    goto L72
                L27:
                    kotlin.ResultKt.throwOnFailure(r14)
                    java.util.List<com.OneTouchTV.TrackItem> r1 = r13.$tracks
                    java.util.Iterator r1 = r1.iterator()
                    r3 = r1
                    r1 = r13
                L32:
                    boolean r2 = r3.hasNext()
                    if (r2 == 0) goto L7a
                    java.lang.Object r2 = r3.next()
                    com.OneTouchTV.TrackItem r2 = (com.OneTouchTV.TrackItem) r2
                    kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r4 = r1.$subtitleCallback
                    java.lang.String r5 = r2.getName()
                    if (r5 != 0) goto L49
                    java.lang.String r5 = "Unknown"
                L49:
                    r6 = r5
                    java.lang.String r7 = r2.getFile()
                    if (r7 != 0) goto L51
                    goto L32
                L51:
                    r9 = r1
                    kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                    r1.L$0 = r3
                    java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
                    r1.L$1 = r5
                    r1.L$2 = r4
                    r5 = 1
                    r1.label = r5
                    r8 = 0
                    r10 = 4
                    r11 = 0
                    java.lang.Object r5 = com.lagradost.cloudstream3.MainAPIKt.newSubtitleFile$default(r6, r7, r8, r9, r10, r11)
                    if (r5 != r0) goto L6b
                    return r0
                L6b:
                    r12 = r0
                    r0 = r14
                    r14 = r5
                    r5 = r3
                    r3 = r2
                    r2 = r1
                    r1 = r12
                L72:
                    r4.invoke(r14)
                    r14 = r0
                    r0 = r1
                    r1 = r2
                    r3 = r5
                    goto L32
                L7a:
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.OneTouchTV.OneTouchTV.C00072.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX INFO: renamed from: com.OneTouchTV.OneTouchTV$loadLinks$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: OneTouchTV.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.OneTouchTV.OneTouchTV$loadLinks$2$2", f = "OneTouchTV.kt", i = {0}, l = {610}, m = "invokeSuspend", n = {"src"}, nl = {609}, s = {"L$1"}, v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
            final /* synthetic */ List<SourceItem> $sources;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(List<SourceItem> list, Function1<? super ExtractorLink, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$sources = list;
                this.$callback = function1;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$sources, this.$callback, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0039  */
            /* JADX WARN: Code duplicated, block: B:12:0x004a  */
            /* JADX WARN: Code duplicated, block: B:16:0x0055  */
            /* JADX WARN: Code duplicated, block: B:19:0x005c  */
            /* JADX WARN: Code duplicated, block: B:23:0x0067  */
            /* JADX WARN: Code duplicated, block: B:29:0x0092 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:30:0x0093  */
            /* JADX WARN: Code duplicated, block: B:35:0x006f A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:37:? A[LOOP:0: B:8:0x0033->B:37:?, LOOP_END, SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0093 -> B:31:0x009a). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:19:0x005c
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            public final java.lang.Object invokeSuspend(java.lang.Object r15) {
                /*
                    r14 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r14.label
                    switch(r1) {
                        case 0: goto L28;
                        case 1: goto L11;
                        default: goto L9;
                    }
                L9:
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                    r0.<init>(r1)
                    throw r0
                L11:
                    java.lang.Object r1 = r14.L$2
                    kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
                    java.lang.Object r2 = r14.L$1
                    com.OneTouchTV.SourceItem r2 = (com.OneTouchTV.SourceItem) r2
                    java.lang.Object r3 = r14.L$0
                    java.util.Iterator r3 = (java.util.Iterator) r3
                    kotlin.ResultKt.throwOnFailure(r15)
                    r4 = r1
                    r5 = r3
                    r1 = r0
                    r3 = r2
                    r2 = r14
                    r0 = r15
                    goto L9a
                L28:
                    kotlin.ResultKt.throwOnFailure(r15)
                    java.util.List<com.OneTouchTV.SourceItem> r1 = r14.$sources
                    java.util.Iterator r1 = r1.iterator()
                    r3 = r1
                    r1 = r14
                L33:
                    boolean r2 = r3.hasNext()
                    if (r2 == 0) goto La2
                    java.lang.Object r2 = r3.next()
                    com.OneTouchTV.SourceItem r2 = (com.OneTouchTV.SourceItem) r2
                    kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r4 = r1.$callback
                    java.lang.String r5 = r2.getName()
                    java.lang.String r6 = "Source"
                    if (r5 == 0) goto L55
                    com.lagradost.cloudstream3.APIHolder r7 = com.lagradost.cloudstream3.APIHolder.INSTANCE
                    java.lang.String r5 = r7.capitalize(r5)
                    if (r5 != 0) goto L53
                    goto L55
                L53:
                    r7 = r5
                    goto L56
                L55:
                    r7 = r6
                L56:
                    java.lang.String r5 = r2.getName()
                    if (r5 == 0) goto L67
                    com.lagradost.cloudstream3.APIHolder r8 = com.lagradost.cloudstream3.APIHolder.INSTANCE
                    java.lang.String r5 = r8.capitalize(r5)
                    if (r5 != 0) goto L65
                    goto L67
                L65:
                    r8 = r5
                    goto L68
                L67:
                    r8 = r6
                L68:
                    java.lang.String r9 = r2.getUrl()
                    if (r9 != 0) goto L6f
                    goto L33
                L6f:
                    com.lagradost.cloudstream3.utils.ExtractorLinkType r10 = com.lagradost.cloudstream3.utils.ExtractorApiKt.getINFER_TYPE()
                    com.OneTouchTV.OneTouchTV$loadLinks$2$2$1 r5 = new com.OneTouchTV.OneTouchTV$loadLinks$2$2$1
                    r6 = 0
                    r5.<init>(r2, r6)
                    r11 = r5
                    kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
                    r12 = r1
                    kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
                    r1.L$0 = r3
                    java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
                    r1.L$1 = r5
                    r1.L$2 = r4
                    r5 = 1
                    r1.label = r5
                    java.lang.Object r5 = com.lagradost.cloudstream3.utils.ExtractorApiKt.newExtractorLink(r7, r8, r9, r10, r11, r12)
                    if (r5 != r0) goto L93
                    return r0
                L93:
                    r13 = r0
                    r0 = r15
                    r15 = r5
                    r5 = r3
                    r3 = r2
                    r2 = r1
                    r1 = r13
                L9a:
                    r4.invoke(r15)
                    r15 = r0
                    r0 = r1
                    r1 = r2
                    r3 = r5
                    goto L33
                La2:
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.OneTouchTV.OneTouchTV.C00072.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            /* JADX INFO: renamed from: com.OneTouchTV.OneTouchTV$loadLinks$2$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: OneTouchTV.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
            @DebugMetadata(c = "com.OneTouchTV.OneTouchTV$loadLinks$2$2$1", f = "OneTouchTV.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
            static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
                final /* synthetic */ SourceItem $src;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(SourceItem sourceItem, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$src = sourceItem;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$src, continuation);
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
                            String quality = this.$src.getQuality();
                            if (quality == null) {
                                quality = "";
                            }
                            $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(quality));
                            $this$newExtractorLink.setHeaders(this.$src.getHeaders());
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
        }
    }

    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        return CoroutineScopeKt.coroutineScope(new C00072(data, function2, function1, null), continuation);
    }

    private final ShowStatus getStatus(String t) {
        if (Intrinsics.areEqual(t, "Finished Airing")) {
            return ShowStatus.Completed;
        }
        return Intrinsics.areEqual(t, "ongoing") ? ShowStatus.Ongoing : ShowStatus.Completed;
    }

    /* JADX INFO: compiled from: OneTouchTV.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bHÆ\u0003J\u008d\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bHÆ\u0001J\u0014\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020-HÖ\u0081\u0004J\n\u0010.\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001b¨\u0006/"}, d2 = {"Lcom/OneTouchTV/OneTouchTV$LoadData;", "", "title", "", "image", "poster", "description", "year", "status", "type", "actors", "", "Lcom/OneTouchTV/OneTouchTV$ActorItem;", "genres", "episodes", "Lcom/OneTouchTV/OneTouchTV$EpisodeItem;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getImage", "getPoster", "getDescription", "getYear", "getStatus", "getType", "getActors", "()Ljava/util/List;", "getGenres", "getEpisodes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LoadData {

        @NotNull
        private final List<ActorItem> actors;

        @Nullable
        private final String description;

        @NotNull
        private final List<EpisodeItem> episodes;

        @NotNull
        private final List<String> genres;

        @Nullable
        private final String image;

        @Nullable
        private final String poster;

        @Nullable
        private final String status;

        @Nullable
        private final String title;

        @Nullable
        private final String type;

        @Nullable
        private final String year;

        public LoadData() {
            this(null, null, null, null, null, null, null, null, null, null, 1023, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LoadData copy$default(LoadData loadData, String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadData.title;
            }
            if ((i & 2) != 0) {
                str2 = loadData.image;
            }
            if ((i & 4) != 0) {
                str3 = loadData.poster;
            }
            if ((i & 8) != 0) {
                str4 = loadData.description;
            }
            if ((i & 16) != 0) {
                str5 = loadData.year;
            }
            if ((i & 32) != 0) {
                str6 = loadData.status;
            }
            if ((i & 64) != 0) {
                str7 = loadData.type;
            }
            if ((i & 128) != 0) {
                list = loadData.actors;
            }
            if ((i & 256) != 0) {
                list2 = loadData.genres;
            }
            if ((i & 512) != 0) {
                list3 = loadData.episodes;
            }
            List list4 = list2;
            List list5 = list3;
            String str8 = str7;
            List list6 = list;
            String str9 = str5;
            String str10 = str6;
            return loadData.copy(str, str2, str3, str4, str9, str10, str8, list6, list4, list5);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final List<EpisodeItem> component10() {
            return this.episodes;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final List<ActorItem> component8() {
            return this.actors;
        }

        @NotNull
        public final List<String> component9() {
            return this.genres;
        }

        @NotNull
        public final LoadData copy(@Nullable String title, @Nullable String image, @Nullable String poster, @Nullable String description, @Nullable String year, @Nullable String status, @Nullable String type, @NotNull List<ActorItem> actors, @NotNull List<String> genres, @NotNull List<EpisodeItem> episodes) {
            return new LoadData(title, image, poster, description, year, status, type, actors, genres, episodes);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadData)) {
                return false;
            }
            LoadData loadData = (LoadData) other;
            return Intrinsics.areEqual(this.title, loadData.title) && Intrinsics.areEqual(this.image, loadData.image) && Intrinsics.areEqual(this.poster, loadData.poster) && Intrinsics.areEqual(this.description, loadData.description) && Intrinsics.areEqual(this.year, loadData.year) && Intrinsics.areEqual(this.status, loadData.status) && Intrinsics.areEqual(this.type, loadData.type) && Intrinsics.areEqual(this.actors, loadData.actors) && Intrinsics.areEqual(this.genres, loadData.genres) && Intrinsics.areEqual(this.episodes, loadData.episodes);
        }

        public int hashCode() {
            return ((((((((((((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0)) * 31) + this.actors.hashCode()) * 31) + this.genres.hashCode()) * 31) + this.episodes.hashCode();
        }

        @NotNull
        public String toString() {
            return "LoadData(title=" + this.title + ", image=" + this.image + ", poster=" + this.poster + ", description=" + this.description + ", year=" + this.year + ", status=" + this.status + ", type=" + this.type + ", actors=" + this.actors + ", genres=" + this.genres + ", episodes=" + this.episodes + ')';
        }

        public LoadData(@Nullable String title, @Nullable String image, @Nullable String poster, @Nullable String description, @Nullable String year, @Nullable String status, @Nullable String type, @NotNull List<ActorItem> list, @NotNull List<String> list2, @NotNull List<EpisodeItem> list3) {
            this.title = title;
            this.image = image;
            this.poster = poster;
            this.description = description;
            this.year = year;
            this.status = status;
            this.type = type;
            this.actors = list;
            this.genres = list2;
            this.episodes = list3;
        }

        public /* synthetic */ LoadData(String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? CollectionsKt.emptyList() : list, (i & 256) != 0 ? CollectionsKt.emptyList() : list2, (i & 512) != 0 ? CollectionsKt.emptyList() : list3);
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getImage() {
            return this.image;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getYear() {
            return this.year;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final List<ActorItem> getActors() {
            return this.actors;
        }

        @NotNull
        public final List<String> getGenres() {
            return this.genres;
        }

        @NotNull
        public final List<EpisodeItem> getEpisodes() {
            return this.episodes;
        }
    }

    /* JADX INFO: compiled from: OneTouchTV.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/OneTouchTV/OneTouchTV$ActorItem;", "", "name", "", "image", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getImage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ActorItem {

        @Nullable
        private final String image;

        @Nullable
        private final String name;

        /* JADX WARN: Illegal instructions before constructor call */
        public ActorItem() {
            String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ ActorItem copy$default(ActorItem actorItem, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = actorItem.name;
            }
            if ((i & 2) != 0) {
                str2 = actorItem.image;
            }
            return actorItem.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        @NotNull
        public final ActorItem copy(@Nullable String name, @Nullable String image) {
            return new ActorItem(name, image);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActorItem)) {
                return false;
            }
            ActorItem actorItem = (ActorItem) other;
            return Intrinsics.areEqual(this.name, actorItem.name) && Intrinsics.areEqual(this.image, actorItem.image);
        }

        public int hashCode() {
            return ((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.image != null ? this.image.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "ActorItem(name=" + this.name + ", image=" + this.image + ')';
        }

        public ActorItem(@Nullable String name, @Nullable String image) {
            this.name = name;
            this.image = image;
        }

        public /* synthetic */ ActorItem(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getImage() {
            return this.image;
        }
    }

    /* JADX INFO: compiled from: OneTouchTV.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/OneTouchTV/OneTouchTV$EpisodeItem;", "", "episode", "", "identifier", "playId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEpisode", "()Ljava/lang/String;", "getIdentifier", "getPlayId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class EpisodeItem {

        @Nullable
        private final String episode;

        @Nullable
        private final String identifier;

        @Nullable
        private final String playId;

        public EpisodeItem() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ EpisodeItem copy$default(EpisodeItem episodeItem, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = episodeItem.episode;
            }
            if ((i & 2) != 0) {
                str2 = episodeItem.identifier;
            }
            if ((i & 4) != 0) {
                str3 = episodeItem.playId;
            }
            return episodeItem.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPlayId() {
            return this.playId;
        }

        @NotNull
        public final EpisodeItem copy(@Nullable String episode, @Nullable String identifier, @Nullable String playId) {
            return new EpisodeItem(episode, identifier, playId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EpisodeItem)) {
                return false;
            }
            EpisodeItem episodeItem = (EpisodeItem) other;
            return Intrinsics.areEqual(this.episode, episodeItem.episode) && Intrinsics.areEqual(this.identifier, episodeItem.identifier) && Intrinsics.areEqual(this.playId, episodeItem.playId);
        }

        public int hashCode() {
            return ((((this.episode == null ? 0 : this.episode.hashCode()) * 31) + (this.identifier == null ? 0 : this.identifier.hashCode())) * 31) + (this.playId != null ? this.playId.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "EpisodeItem(episode=" + this.episode + ", identifier=" + this.identifier + ", playId=" + this.playId + ')';
        }

        public EpisodeItem(@Nullable String episode, @Nullable String identifier, @Nullable String playId) {
            this.episode = episode;
            this.identifier = identifier;
            this.playId = playId;
        }

        public /* synthetic */ EpisodeItem(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Nullable
        public final String getEpisode() {
            return this.episode;
        }

        @Nullable
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        public final String getPlayId() {
            return this.playId;
        }
    }

    /* JADX INFO: compiled from: OneTouchTV.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006\""}, d2 = {"Lcom/OneTouchTV/OneTouchTV$TmdbData;", "", "id", "", "posterPath", "", "backdropPath", "overview", "rating", "", "releaseDate", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;)V", "getId", "()I", "getPosterPath", "()Ljava/lang/String;", "getBackdropPath", "getOverview", "getRating", "()D", "getReleaseDate", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class TmdbData {

        @Nullable
        private final String backdropPath;
        private final int id;

        @Nullable
        private final String overview;

        @Nullable
        private final String posterPath;
        private final double rating;

        @Nullable
        private final String releaseDate;

        public static /* synthetic */ TmdbData copy$default(TmdbData tmdbData, int i, String str, String str2, String str3, double d, String str4, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = tmdbData.id;
            }
            if ((i2 & 2) != 0) {
                str = tmdbData.posterPath;
            }
            if ((i2 & 4) != 0) {
                str2 = tmdbData.backdropPath;
            }
            if ((i2 & 8) != 0) {
                str3 = tmdbData.overview;
            }
            if ((i2 & 16) != 0) {
                d = tmdbData.rating;
            }
            if ((i2 & 32) != 0) {
                str4 = tmdbData.releaseDate;
            }
            String str5 = str4;
            double d2 = d;
            return tmdbData.copy(i, str, str2, str3, d2, str5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPosterPath() {
            return this.posterPath;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getBackdropPath() {
            return this.backdropPath;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final double getRating() {
            return this.rating;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getReleaseDate() {
            return this.releaseDate;
        }

        @NotNull
        public final TmdbData copy(int id, @Nullable String posterPath, @Nullable String backdropPath, @Nullable String overview, double rating, @Nullable String releaseDate) {
            return new TmdbData(id, posterPath, backdropPath, overview, rating, releaseDate);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TmdbData)) {
                return false;
            }
            TmdbData tmdbData = (TmdbData) other;
            return this.id == tmdbData.id && Intrinsics.areEqual(this.posterPath, tmdbData.posterPath) && Intrinsics.areEqual(this.backdropPath, tmdbData.backdropPath) && Intrinsics.areEqual(this.overview, tmdbData.overview) && Double.compare(this.rating, tmdbData.rating) == 0 && Intrinsics.areEqual(this.releaseDate, tmdbData.releaseDate);
        }

        public int hashCode() {
            return (((((((((this.id * 31) + (this.posterPath == null ? 0 : this.posterPath.hashCode())) * 31) + (this.backdropPath == null ? 0 : this.backdropPath.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + OneTouchTV$TmdbData$$ExternalSyntheticBackport0.m1m(this.rating)) * 31) + (this.releaseDate != null ? this.releaseDate.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "TmdbData(id=" + this.id + ", posterPath=" + this.posterPath + ", backdropPath=" + this.backdropPath + ", overview=" + this.overview + ", rating=" + this.rating + ", releaseDate=" + this.releaseDate + ')';
        }

        public TmdbData(int id, @Nullable String posterPath, @Nullable String backdropPath, @Nullable String overview, double rating, @Nullable String releaseDate) {
            this.id = id;
            this.posterPath = posterPath;
            this.backdropPath = backdropPath;
            this.overview = overview;
            this.rating = rating;
            this.releaseDate = releaseDate;
        }

        public final int getId() {
            return this.id;
        }

        @Nullable
        public final String getPosterPath() {
            return this.posterPath;
        }

        @Nullable
        public final String getBackdropPath() {
            return this.backdropPath;
        }

        @Nullable
        public final String getOverview() {
            return this.overview;
        }

        public final double getRating() {
            return this.rating;
        }

        @Nullable
        public final String getReleaseDate() {
            return this.releaseDate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:113:0x057f  */
    /* JADX WARN: Code duplicated, block: B:116:0x0583  */
    /* JADX WARN: Code duplicated, block: B:118:0x0588  */
    /* JADX WARN: Code duplicated, block: B:119:0x059e  */
    /* JADX WARN: Code duplicated, block: B:125:0x05b9  */
    /* JADX WARN: Code duplicated, block: B:128:0x05bd  */
    /* JADX WARN: Code duplicated, block: B:130:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:131:0x05d8  */
    /* JADX WARN: Code duplicated, block: B:137:0x05f3  */
    /* JADX WARN: Code duplicated, block: B:140:0x05f7  */
    /* JADX WARN: Code duplicated, block: B:143:0x0603  */
    /* JADX WARN: Code duplicated, block: B:144:0x0606  */
    /* JADX WARN: Code duplicated, block: B:151:0x0623  */
    /* JADX WARN: Code duplicated, block: B:152:0x0625  */
    /* JADX WARN: Code duplicated, block: B:198:0x02d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:59:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:60:0x02f9 A[Catch: Exception -> 0x03b4, TRY_ENTER, TRY_LEAVE, TryCatch #7 {Exception -> 0x03b4, blocks: (B:51:0x02c8, B:60:0x02f9), top: B:190:0x02c8 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0376 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x0377  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:93:0x0483  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 10 */
    public final Object fetchTmdbData(String title, Integer year, boolean isMovie, Continuation<? super TmdbData> continuation) {
        C00001 c00001;
        Object obj;
        C00001 c00002;
        String title2;
        Integer year2;
        String type;
        String tmdbApiKey;
        String encodedTitle;
        String searchUrl;
        String cleanTitle;
        boolean isMovie2;
        String searchUrl2;
        String yearParam;
        String cleanTitle2;
        String type2;
        String tmdbApiKey2;
        Object obj2;
        String encodedTitle2;
        String title3;
        Integer year3;
        boolean isMovie3;
        String encodedTitle3;
        String searchUrl3;
        JSONObject yearJson;
        JSONArray jSONArrayOptJSONArray;
        int length;
        String type3;
        boolean isMovie4;
        String tmdbApiKey3;
        String searchUrl4;
        Object obj3;
        C00001 c00003;
        String searchUrl5;
        boolean isMovie5;
        String tmdbApiKey4;
        String title4;
        Integer year4;
        String tmdbApiKey5;
        String type4;
        JSONArray results;
        boolean z;
        JSONObject first;
        String res;
        JSONObject json;
        int id;
        JSONArray results2;
        boolean isMovie6;
        String detailUrl;
        String it;
        boolean z2;
        String str;
        String it2;
        int i;
        String str2;
        String it3;
        boolean z3;
        String str3;
        String it4;
        String str4;
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
        C00001 c00004 = c00001;
        Object $result = c00004.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String title5 = "results";
        String str5 = "?api_key=";
        switch (c00004.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String type5 = isMovie ? "movie" : "tv";
                String cleanTitle3 = StringsKt.trim(new Regex("\\s+").replace(new Regex("(?i)(?:season\\s*\\d+|\\bs\\d+\\b)").replace(new Regex("\\[.*?]").replace(new Regex("\\(\\d{4}\\)").replace(title, ""), ""), ""), " ")).toString();
                StringUtils $this$fetchTmdbData_u24lambda_u240 = StringUtils.INSTANCE;
                String encodedTitle4 = $this$fetchTmdbData_u24lambda_u240.encodeUri(cleanTitle3);
                String searchUrl6 = "https://api.themoviedb.org/3/search/" + type5 + "?api_key=1865f43a0549ca50d341dd9ab8b29f49&query=" + encodedTitle4;
                if (year != null) {
                    String yearParam2 = isMovie ? "primary_release_year" : "first_air_date_year";
                    try {
                        String yearUrl = searchUrl6 + '&' + yearParam2 + '=' + year.intValue();
                        Requests app = MainActivityKt.getApp();
                        c00004.L$0 = SpillingKt.nullOutSpilledVariable(title);
                        c00004.L$1 = SpillingKt.nullOutSpilledVariable(year);
                        c00004.L$2 = type5;
                        c00004.L$3 = SpillingKt.nullOutSpilledVariable(cleanTitle3);
                        c00004.L$4 = SpillingKt.nullOutSpilledVariable(encodedTitle4);
                        c00004.L$5 = "1865f43a0549ca50d341dd9ab8b29f49";
                        c00004.L$6 = searchUrl6;
                        c00004.L$7 = SpillingKt.nullOutSpilledVariable(yearParam2);
                        c00004.L$8 = SpillingKt.nullOutSpilledVariable(yearUrl);
                        c00004.Z$0 = isMovie;
                        c00004.label = 1;
                        String type6 = type5;
                        searchUrl2 = searchUrl6;
                        yearParam = yearParam2;
                        cleanTitle2 = cleanTitle3;
                        title5 = "results";
                        str5 = "?api_key=";
                        try {
                            Object obj4 = Requests.get$default(app, yearUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00004, 4094, (Object) null);
                            c00002 = c00004;
                            if (obj4 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            type2 = type6;
                            tmdbApiKey2 = "1865f43a0549ca50d341dd9ab8b29f49";
                            obj2 = obj4;
                            encodedTitle2 = encodedTitle4;
                            title3 = title;
                            year3 = year;
                            isMovie3 = isMovie;
                            encodedTitle3 = yearUrl;
                            try {
                                searchUrl3 = ((NiceResponse) obj2).getText();
                                yearJson = new JSONObject(searchUrl3);
                                jSONArrayOptJSONArray = yearJson.optJSONArray(title5);
                                if (jSONArrayOptJSONArray != null) {
                                    try {
                                        length = jSONArrayOptJSONArray.length();
                                        break;
                                    } catch (Exception e) {
                                    }
                                } else {
                                    length = 0;
                                }
                                if (length > 0) {
                                    title4 = title3;
                                    year4 = year3;
                                    isMovie2 = isMovie3;
                                    tmdbApiKey5 = tmdbApiKey2;
                                    type4 = type2;
                                } else {
                                    Requests app2 = MainActivityKt.getApp();
                                    c00002.L$0 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00002.L$1 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00002.L$2 = type2;
                                    c00002.L$3 = SpillingKt.nullOutSpilledVariable(cleanTitle2);
                                    c00002.L$4 = SpillingKt.nullOutSpilledVariable(encodedTitle2);
                                    c00002.L$5 = tmdbApiKey2;
                                    c00002.L$6 = SpillingKt.nullOutSpilledVariable(searchUrl2);
                                    c00002.L$7 = SpillingKt.nullOutSpilledVariable(yearParam);
                                    c00002.L$8 = SpillingKt.nullOutSpilledVariable(encodedTitle3);
                                    c00002.L$9 = SpillingKt.nullOutSpilledVariable(searchUrl3);
                                    c00002.L$10 = SpillingKt.nullOutSpilledVariable(yearJson);
                                    c00002.Z$0 = isMovie3;
                                    c00002.label = 2;
                                    type3 = type2;
                                    isMovie4 = isMovie3;
                                    tmdbApiKey3 = tmdbApiKey2;
                                    C00001 c00005 = c00002;
                                    searchUrl4 = searchUrl2;
                                    try {
                                        obj3 = Requests.get$default(app2, searchUrl4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00005, 4094, (Object) null);
                                        c00003 = c00005;
                                        if (obj3 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        searchUrl5 = searchUrl4;
                                        isMovie5 = isMovie4;
                                        tmdbApiKey4 = type3;
                                        $result = obj3;
                                        try {
                                            String text = ((NiceResponse) $result).getText();
                                            title4 = title3;
                                            year4 = year3;
                                            c00002 = c00003;
                                            searchUrl2 = searchUrl5;
                                            isMovie2 = isMovie5;
                                            tmdbApiKey5 = tmdbApiKey3;
                                            searchUrl3 = text;
                                            type4 = tmdbApiKey4;
                                        } catch (Exception e2) {
                                        }
                                    } catch (Exception e3) {
                                    }
                                }
                                try {
                                    JSONObject json2 = new JSONObject(searchUrl3);
                                    results = json2.optJSONArray(title5);
                                    if (results != null || results.length() <= 0) {
                                        return null;
                                    }
                                    JSONObject first2 = results.optJSONObject(0);
                                    if (first2 == null) {
                                        return null;
                                    }
                                    int id2 = first2.optInt("id");
                                    String detailUrl2 = "https://api.themoviedb.org/3/" + type4 + '/' + id2 + str5 + tmdbApiKey5;
                                    String type7 = type4;
                                    try {
                                        Requests app3 = MainActivityKt.getApp();
                                        c00002.L$0 = SpillingKt.nullOutSpilledVariable(title4);
                                        c00002.L$1 = SpillingKt.nullOutSpilledVariable(year4);
                                        c00002.L$2 = SpillingKt.nullOutSpilledVariable(type7);
                                        c00002.L$3 = SpillingKt.nullOutSpilledVariable(cleanTitle2);
                                        c00002.L$4 = SpillingKt.nullOutSpilledVariable(encodedTitle2);
                                        c00002.L$5 = SpillingKt.nullOutSpilledVariable(tmdbApiKey5);
                                        c00002.L$6 = SpillingKt.nullOutSpilledVariable(searchUrl2);
                                        c00002.L$7 = SpillingKt.nullOutSpilledVariable(searchUrl3);
                                        c00002.L$8 = SpillingKt.nullOutSpilledVariable(json2);
                                        c00002.L$9 = SpillingKt.nullOutSpilledVariable(results);
                                        c00002.L$10 = SpillingKt.nullOutSpilledVariable(first2);
                                        c00002.L$11 = SpillingKt.nullOutSpilledVariable(detailUrl2);
                                        c00002.Z$0 = isMovie2;
                                        c00002.I$0 = id2;
                                        c00002.label = 4;
                                        String res2 = searchUrl3;
                                        z = false;
                                        first = first2;
                                        res = res2;
                                        json = json2;
                                        try {
                                            Object obj5 = Requests.get$default(app3, detailUrl2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                                            if (obj5 == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            id = id2;
                                            results2 = results;
                                            isMovie6 = isMovie2;
                                            detailUrl = detailUrl2;
                                            $result = obj5;
                                            try {
                                                String detailRes = ((NiceResponse) $result).getText();
                                                try {
                                                    JSONObject detailJson = new JSONObject(detailRes);
                                                    it = detailJson.optString("poster_path");
                                                    if (!StringsKt.isBlank(it) || Intrinsics.areEqual(it, "null")) {
                                                        z2 = false;
                                                    } else {
                                                        z2 = true;
                                                    }
                                                    if (!z2) {
                                                        it = null;
                                                    }
                                                    if (it != null) {
                                                        str = "https://image.tmdb.org/t/p/w500" + it;
                                                    } else {
                                                        str = null;
                                                    }
                                                    it2 = detailJson.optString("backdrop_path");
                                                    if (!StringsKt.isBlank(it2) || Intrinsics.areEqual(it2, "null")) {
                                                        i = 0;
                                                    } else {
                                                        i = 1;
                                                    }
                                                    if (i == 0) {
                                                        it2 = null;
                                                    }
                                                    if (it2 != null) {
                                                        str2 = "https://image.tmdb.org/t/p/w1280" + it2;
                                                    } else {
                                                        str2 = null;
                                                    }
                                                    it3 = detailJson.optString("overview");
                                                    if (!StringsKt.isBlank(it3) || Intrinsics.areEqual(it3, "null")) {
                                                        z3 = false;
                                                    } else {
                                                        z3 = true;
                                                    }
                                                    if (!z3) {
                                                        it3 = null;
                                                    }
                                                    double dOptDouble = detailJson.optDouble("vote_average", 0.0d);
                                                    if (isMovie6) {
                                                        str3 = "release_date";
                                                    } else {
                                                        str3 = "first_air_date";
                                                    }
                                                    it4 = detailJson.optString(str3);
                                                    if (!StringsKt.isBlank(it4) && !Intrinsics.areEqual(it4, "null")) {
                                                        z = true;
                                                    }
                                                    if (z) {
                                                        str4 = it4;
                                                    } else {
                                                        str4 = null;
                                                    }
                                                    return new TmdbData(id, str, str2, it3, dOptDouble, str4);
                                                } catch (Exception e4) {
                                                    return null;
                                                }
                                            } catch (Exception e5) {
                                                return null;
                                            }
                                        } catch (Exception e6) {
                                            return null;
                                        }
                                    } catch (Exception e7) {
                                    }
                                } catch (Exception e8) {
                                    return null;
                                }
                            } catch (Exception e9) {
                            }
                        } catch (Exception e10) {
                        }
                    } catch (Exception e11) {
                    }
                } else {
                    String type8 = type5;
                    try {
                        Requests app4 = MainActivityKt.getApp();
                        c00004.L$0 = SpillingKt.nullOutSpilledVariable(title);
                        c00004.L$1 = SpillingKt.nullOutSpilledVariable(year);
                        c00004.L$2 = type8;
                        c00004.L$3 = SpillingKt.nullOutSpilledVariable(cleanTitle3);
                        c00004.L$4 = SpillingKt.nullOutSpilledVariable(encodedTitle4);
                        c00004.L$5 = "1865f43a0549ca50d341dd9ab8b29f49";
                        c00004.L$6 = SpillingKt.nullOutSpilledVariable(searchUrl6);
                        c00004.Z$0 = isMovie;
                        c00004.label = 3;
                        try {
                            obj = Requests.get$default(app4, searchUrl6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00004, 4094, (Object) null);
                            c00002 = c00004;
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            title2 = title;
                            year2 = year;
                            type = type8;
                            tmdbApiKey = "1865f43a0549ca50d341dd9ab8b29f49";
                            encodedTitle = encodedTitle4;
                            searchUrl = searchUrl6;
                            cleanTitle = cleanTitle3;
                            isMovie2 = isMovie;
                            try {
                                String text2 = ((NiceResponse) obj).getText();
                                searchUrl2 = searchUrl;
                                title4 = title2;
                                encodedTitle2 = encodedTitle;
                                cleanTitle2 = cleanTitle;
                                type4 = type;
                                year4 = year2;
                                searchUrl3 = text2;
                                tmdbApiKey5 = tmdbApiKey;
                                JSONObject json3 = new JSONObject(searchUrl3);
                                results = json3.optJSONArray(title5);
                                if (results != null) {
                                }
                                return null;
                            } catch (Exception e12) {
                            }
                        } catch (Exception e13) {
                        }
                    } catch (Exception e14) {
                    }
                }
                return null;
            case 1:
                boolean isMovie7 = c00004.Z$0;
                String yearUrl2 = (String) c00004.L$8;
                String yearParam3 = (String) c00004.L$7;
                String searchUrl7 = (String) c00004.L$6;
                String tmdbApiKey6 = (String) c00004.L$5;
                String encodedTitle5 = (String) c00004.L$4;
                String cleanTitle4 = (String) c00004.L$3;
                String type9 = (String) c00004.L$2;
                Integer year5 = (Integer) c00004.L$1;
                String title6 = (String) c00004.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    title3 = title6;
                    encodedTitle3 = yearUrl2;
                    title5 = "results";
                    str5 = "?api_key=";
                    yearParam = yearParam3;
                    searchUrl2 = searchUrl7;
                    tmdbApiKey2 = tmdbApiKey6;
                    encodedTitle2 = encodedTitle5;
                    cleanTitle2 = cleanTitle4;
                    type2 = type9;
                    year3 = year5;
                    c00002 = c00004;
                    obj2 = $result;
                    isMovie3 = isMovie7;
                    searchUrl3 = ((NiceResponse) obj2).getText();
                    yearJson = new JSONObject(searchUrl3);
                    jSONArrayOptJSONArray = yearJson.optJSONArray(title5);
                    if (jSONArrayOptJSONArray != null) {
                        length = jSONArrayOptJSONArray.length();
                        break;
                    } else {
                        length = 0;
                    }
                    if (length > 0) {
                        title4 = title3;
                        year4 = year3;
                        isMovie2 = isMovie3;
                        tmdbApiKey5 = tmdbApiKey2;
                        type4 = type2;
                    } else {
                        Requests app5 = MainActivityKt.getApp();
                        c00002.L$0 = SpillingKt.nullOutSpilledVariable(title3);
                        c00002.L$1 = SpillingKt.nullOutSpilledVariable(year3);
                        c00002.L$2 = type2;
                        c00002.L$3 = SpillingKt.nullOutSpilledVariable(cleanTitle2);
                        c00002.L$4 = SpillingKt.nullOutSpilledVariable(encodedTitle2);
                        c00002.L$5 = tmdbApiKey2;
                        c00002.L$6 = SpillingKt.nullOutSpilledVariable(searchUrl2);
                        c00002.L$7 = SpillingKt.nullOutSpilledVariable(yearParam);
                        c00002.L$8 = SpillingKt.nullOutSpilledVariable(encodedTitle3);
                        c00002.L$9 = SpillingKt.nullOutSpilledVariable(searchUrl3);
                        c00002.L$10 = SpillingKt.nullOutSpilledVariable(yearJson);
                        c00002.Z$0 = isMovie3;
                        c00002.label = 2;
                        type3 = type2;
                        isMovie4 = isMovie3;
                        tmdbApiKey3 = tmdbApiKey2;
                        C00001 c00006 = c00002;
                        searchUrl4 = searchUrl2;
                        obj3 = Requests.get$default(app5, searchUrl4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00006, 4094, (Object) null);
                        c00003 = c00006;
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        searchUrl5 = searchUrl4;
                        isMovie5 = isMovie4;
                        tmdbApiKey4 = type3;
                        $result = obj3;
                        String text3 = ((NiceResponse) $result).getText();
                        title4 = title3;
                        year4 = year3;
                        c00002 = c00003;
                        searchUrl2 = searchUrl5;
                        isMovie2 = isMovie5;
                        tmdbApiKey5 = tmdbApiKey3;
                        searchUrl3 = text3;
                        type4 = tmdbApiKey4;
                    }
                    JSONObject json4 = new JSONObject(searchUrl3);
                    results = json4.optJSONArray(title5);
                    if (results != null) {
                        break;
                    }
                    return null;
                } catch (Exception e15) {
                }
                break;
            case 2:
                boolean isMovie8 = c00004.Z$0;
                searchUrl5 = (String) c00004.L$6;
                String tmdbApiKey7 = (String) c00004.L$5;
                String encodedTitle6 = (String) c00004.L$4;
                String cleanTitle5 = (String) c00004.L$3;
                isMovie5 = isMovie8;
                String type10 = (String) c00004.L$2;
                Integer year6 = (Integer) c00004.L$1;
                String title7 = (String) c00004.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    year3 = year6;
                    title3 = title7;
                    title5 = "results";
                    str5 = "?api_key=";
                    cleanTitle2 = cleanTitle5;
                    tmdbApiKey3 = tmdbApiKey7;
                    encodedTitle2 = encodedTitle6;
                    tmdbApiKey4 = type10;
                    c00003 = c00004;
                    String text4 = ((NiceResponse) $result).getText();
                    title4 = title3;
                    year4 = year3;
                    c00002 = c00003;
                    searchUrl2 = searchUrl5;
                    isMovie2 = isMovie5;
                    tmdbApiKey5 = tmdbApiKey3;
                    searchUrl3 = text4;
                    type4 = tmdbApiKey4;
                    JSONObject json5 = new JSONObject(searchUrl3);
                    results = json5.optJSONArray(title5);
                    if (results != null) {
                        break;
                    }
                    return null;
                } catch (Exception e16) {
                }
                break;
            case 3:
                boolean isMovie9 = c00004.Z$0;
                searchUrl = (String) c00004.L$6;
                tmdbApiKey = (String) c00004.L$5;
                encodedTitle = (String) c00004.L$4;
                cleanTitle = (String) c00004.L$3;
                type = (String) c00004.L$2;
                year2 = (Integer) c00004.L$1;
                title2 = (String) c00004.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    isMovie2 = isMovie9;
                    c00002 = c00004;
                    obj = $result;
                    String text5 = ((NiceResponse) obj).getText();
                    searchUrl2 = searchUrl;
                    title4 = title2;
                    encodedTitle2 = encodedTitle;
                    cleanTitle2 = cleanTitle;
                    type4 = type;
                    year4 = year2;
                    searchUrl3 = text5;
                    tmdbApiKey5 = tmdbApiKey;
                    JSONObject json6 = new JSONObject(searchUrl3);
                    results = json6.optJSONArray(title5);
                    if (results != null) {
                        break;
                    }
                    return null;
                } catch (Exception e17) {
                }
                break;
            case 4:
                int id3 = c00004.I$0;
                isMovie6 = c00004.Z$0;
                String detailUrl3 = (String) c00004.L$11;
                JSONObject first3 = (JSONObject) c00004.L$10;
                JSONArray results3 = (JSONArray) c00004.L$9;
                JSONObject json7 = (JSONObject) c00004.L$8;
                String res3 = (String) c00004.L$7;
                try {
                    ResultKt.throwOnFailure($result);
                    detailUrl = detailUrl3;
                    first = first3;
                    results2 = results3;
                    json = json7;
                    res = res3;
                    z = false;
                    id = id3;
                    String detailRes2 = ((NiceResponse) $result).getText();
                    JSONObject detailJson2 = new JSONObject(detailRes2);
                    it = detailJson2.optString("poster_path");
                    if (StringsKt.isBlank(it)) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        it = null;
                    }
                    if (it != null) {
                        str = "https://image.tmdb.org/t/p/w500" + it;
                    } else {
                        str = null;
                    }
                    it2 = detailJson2.optString("backdrop_path");
                    if (StringsKt.isBlank(it2)) {
                        i = 0;
                    } else {
                        i = 0;
                    }
                    if (i == 0) {
                        it2 = null;
                    }
                    if (it2 != null) {
                        str2 = "https://image.tmdb.org/t/p/w1280" + it2;
                    } else {
                        str2 = null;
                    }
                    it3 = detailJson2.optString("overview");
                    if (StringsKt.isBlank(it3)) {
                        z3 = false;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        it3 = null;
                    }
                    double dOptDouble2 = detailJson2.optDouble("vote_average", 0.0d);
                    if (isMovie6) {
                        str3 = "release_date";
                    } else {
                        str3 = "first_air_date";
                    }
                    it4 = detailJson2.optString(str3);
                    if (!StringsKt.isBlank(it4)) {
                        z = true;
                    }
                    if (z) {
                        str4 = it4;
                    } else {
                        str4 = null;
                    }
                    return new TmdbData(id, str, str2, it3, dOptDouble2, str4);
                } catch (Exception e18) {
                    return null;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: OneTouchTV.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011JJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/OneTouchTV/OneTouchTV$TmdbEpisode;", "", "name", "", "overview", "stillPath", "airDate", "rating", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "getName", "()Ljava/lang/String;", "getOverview", "getStillPath", "getAirDate", "getRating", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)Lcom/OneTouchTV/OneTouchTV$TmdbEpisode;", "equals", "", "other", "hashCode", "", "toString", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class TmdbEpisode {

        @Nullable
        private final String airDate;

        @Nullable
        private final String name;

        @Nullable
        private final String overview;

        @Nullable
        private final Double rating;

        @Nullable
        private final String stillPath;

        public static /* synthetic */ TmdbEpisode copy$default(TmdbEpisode tmdbEpisode, String str, String str2, String str3, String str4, Double d, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tmdbEpisode.name;
            }
            if ((i & 2) != 0) {
                str2 = tmdbEpisode.overview;
            }
            if ((i & 4) != 0) {
                str3 = tmdbEpisode.stillPath;
            }
            if ((i & 8) != 0) {
                str4 = tmdbEpisode.airDate;
            }
            if ((i & 16) != 0) {
                d = tmdbEpisode.rating;
            }
            Double d2 = d;
            String str5 = str3;
            return tmdbEpisode.copy(str, str2, str5, str4, d2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getStillPath() {
            return this.stillPath;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getAirDate() {
            return this.airDate;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Double getRating() {
            return this.rating;
        }

        @NotNull
        public final TmdbEpisode copy(@Nullable String name, @Nullable String overview, @Nullable String stillPath, @Nullable String airDate, @Nullable Double rating) {
            return new TmdbEpisode(name, overview, stillPath, airDate, rating);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TmdbEpisode)) {
                return false;
            }
            TmdbEpisode tmdbEpisode = (TmdbEpisode) other;
            return Intrinsics.areEqual(this.name, tmdbEpisode.name) && Intrinsics.areEqual(this.overview, tmdbEpisode.overview) && Intrinsics.areEqual(this.stillPath, tmdbEpisode.stillPath) && Intrinsics.areEqual(this.airDate, tmdbEpisode.airDate) && Intrinsics.areEqual(this.rating, tmdbEpisode.rating);
        }

        public int hashCode() {
            return ((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.stillPath == null ? 0 : this.stillPath.hashCode())) * 31) + (this.airDate == null ? 0 : this.airDate.hashCode())) * 31) + (this.rating != null ? this.rating.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "TmdbEpisode(name=" + this.name + ", overview=" + this.overview + ", stillPath=" + this.stillPath + ", airDate=" + this.airDate + ", rating=" + this.rating + ')';
        }

        public TmdbEpisode(@Nullable String name, @Nullable String overview, @Nullable String stillPath, @Nullable String airDate, @Nullable Double rating) {
            this.name = name;
            this.overview = overview;
            this.stillPath = stillPath;
            this.airDate = airDate;
            this.rating = rating;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        public final String getStillPath() {
            return this.stillPath;
        }

        @Nullable
        public final String getAirDate() {
            return this.airDate;
        }

        @Nullable
        public final Double getRating() {
            return this.rating;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:31:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:33:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:35:0x0100  */
    /* JADX WARN: Code duplicated, block: B:36:0x0108  */
    /* JADX WARN: Code duplicated, block: B:41:0x012f  */
    /* JADX WARN: Code duplicated, block: B:45:0x0135  */
    /* JADX WARN: Code duplicated, block: B:51:0x0154  */
    /* JADX WARN: Code duplicated, block: B:53:0x0157  */
    /* JADX WARN: Code duplicated, block: B:54:0x015a  */
    /* JADX WARN: Code duplicated, block: B:60:0x0177  */
    /* JADX WARN: Code duplicated, block: B:63:0x017b  */
    /* JADX WARN: Code duplicated, block: B:65:0x017f  */
    /* JADX WARN: Code duplicated, block: B:66:0x019a  */
    /* JADX WARN: Code duplicated, block: B:72:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:74:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:75:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:82:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:83:0x01e6  */
    public final Object fetchTmdbEpisodes(int tmdbId, int seasonNumber, Continuation<? super Map<Integer, TmdbEpisode>> continuation) {
        C00011 c00011;
        JSONObject json;
        JSONArray episodesArr;
        Map map;
        int i;
        int length;
        JSONObject epObj;
        String it;
        boolean z;
        boolean z2;
        String it2;
        boolean z3;
        String overview;
        String it3;
        boolean z4;
        String stillPath;
        String it4;
        boolean z5;
        String airDate;
        Double dBoxDouble;
        double it5;
        Double rating;
        int tmdbId2 = tmdbId;
        int seasonNumber2 = seasonNumber;
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
                String url = "https://api.themoviedb.org/3/tv/" + tmdbId2 + "/season/" + seasonNumber2 + "?api_key=1865f43a0549ca50d341dd9ab8b29f49";
                try {
                    Requests app = MainActivityKt.getApp();
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable("1865f43a0549ca50d341dd9ab8b29f49");
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00012.I$0 = tmdbId2;
                    c00012.I$1 = seasonNumber2;
                    c00012.label = 1;
                    try {
                        Object obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = obj;
                        try {
                            String res = ((NiceResponse) $result).getText();
                            try {
                                json = new JSONObject(res);
                                episodesArr = json.optJSONArray("episodes");
                                if (episodesArr == null) {
                                    return MapsKt.emptyMap();
                                }
                                map = new LinkedHashMap();
                                i = 0;
                                length = episodesArr.length();
                                while (i < length) {
                                    epObj = episodesArr.optJSONObject(i);
                                    if (epObj == null) {
                                        tmdbId2 = tmdbId2;
                                        seasonNumber2 = seasonNumber2;
                                    } else {
                                        int epNum = epObj.optInt("episode_number");
                                        it = epObj.optString("name");
                                        z = false;
                                        if (!StringsKt.isBlank(it) || Intrinsics.areEqual(it, "null")) {
                                            z2 = false;
                                        } else {
                                            z2 = true;
                                        }
                                        if (!z2) {
                                            it = null;
                                        }
                                        String name = it;
                                        it2 = epObj.optString("overview");
                                        if (!StringsKt.isBlank(it2) || Intrinsics.areEqual(it2, "null")) {
                                            z3 = false;
                                        } else {
                                            z3 = true;
                                        }
                                        if (z3) {
                                            overview = it2;
                                        } else {
                                            overview = null;
                                        }
                                        it3 = epObj.optString("still_path");
                                        if (!StringsKt.isBlank(it3) || Intrinsics.areEqual(it3, "null")) {
                                            z4 = false;
                                        } else {
                                            z4 = true;
                                        }
                                        if (!z4) {
                                            it3 = null;
                                        }
                                        if (it3 != null) {
                                            stillPath = "https://image.tmdb.org/t/p/w500" + it3;
                                        } else {
                                            stillPath = null;
                                        }
                                        it4 = epObj.optString("air_date");
                                        if (!StringsKt.isBlank(it4) || Intrinsics.areEqual(it4, "null")) {
                                            z5 = false;
                                        } else {
                                            z5 = true;
                                        }
                                        if (z5) {
                                            airDate = it4;
                                        } else {
                                            airDate = null;
                                        }
                                        dBoxDouble = Boxing.boxDouble(epObj.optDouble("vote_average"));
                                        it5 = dBoxDouble.doubleValue();
                                        if (!Double.isNaN(it5) && it5 > 0.0d) {
                                            z = true;
                                        }
                                        if (z) {
                                            rating = dBoxDouble;
                                        } else {
                                            rating = null;
                                        }
                                        map.put(Boxing.boxInt(epNum), new TmdbEpisode(name, overview, stillPath, airDate, rating));
                                    }
                                    i++;
                                    json = json;
                                    tmdbId2 = tmdbId2;
                                    seasonNumber2 = seasonNumber2;
                                }
                                return map;
                            } catch (Exception e) {
                                return MapsKt.emptyMap();
                            }
                        } catch (Exception e2) {
                            return MapsKt.emptyMap();
                        }
                    } catch (Exception e3) {
                        return MapsKt.emptyMap();
                    }
                } catch (Exception e4) {
                }
                break;
            case 1:
                seasonNumber2 = c00012.I$1;
                tmdbId2 = c00012.I$0;
                try {
                    ResultKt.throwOnFailure($result);
                    String res2 = ((NiceResponse) $result).getText();
                    json = new JSONObject(res2);
                    episodesArr = json.optJSONArray("episodes");
                    if (episodesArr == null) {
                        return MapsKt.emptyMap();
                    }
                    map = new LinkedHashMap();
                    i = 0;
                    length = episodesArr.length();
                    while (i < length) {
                        epObj = episodesArr.optJSONObject(i);
                        if (epObj == null) {
                            tmdbId2 = tmdbId2;
                            seasonNumber2 = seasonNumber2;
                        } else {
                            int epNum2 = epObj.optInt("episode_number");
                            it = epObj.optString("name");
                            z = false;
                            if (StringsKt.isBlank(it)) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                it = null;
                            }
                            String name2 = it;
                            it2 = epObj.optString("overview");
                            if (StringsKt.isBlank(it2)) {
                                z3 = false;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                overview = it2;
                            } else {
                                overview = null;
                            }
                            it3 = epObj.optString("still_path");
                            if (StringsKt.isBlank(it3)) {
                                z4 = false;
                            } else {
                                z4 = false;
                            }
                            if (!z4) {
                                it3 = null;
                            }
                            if (it3 != null) {
                                stillPath = "https://image.tmdb.org/t/p/w500" + it3;
                            } else {
                                stillPath = null;
                            }
                            it4 = epObj.optString("air_date");
                            if (StringsKt.isBlank(it4)) {
                                z5 = false;
                            } else {
                                z5 = false;
                            }
                            if (z5) {
                                airDate = it4;
                            } else {
                                airDate = null;
                            }
                            dBoxDouble = Boxing.boxDouble(epObj.optDouble("vote_average"));
                            it5 = dBoxDouble.doubleValue();
                            if (!Double.isNaN(it5)) {
                                z = true;
                            }
                            if (z) {
                                rating = dBoxDouble;
                            } else {
                                rating = null;
                            }
                            map.put(Boxing.boxInt(epNum2), new TmdbEpisode(name2, overview, stillPath, airDate, rating));
                        }
                        i++;
                        json = json;
                        tmdbId2 = tmdbId2;
                        seasonNumber2 = seasonNumber2;
                    }
                    return map;
                } catch (Exception e5) {
                    return MapsKt.emptyMap();
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
