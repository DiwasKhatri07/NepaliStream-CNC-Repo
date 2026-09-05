package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
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
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.jvm.functions.Function0;
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
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KisskhProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/KisskhProvider/classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 B2\u00020\u0001:\tBCDEFGHIJB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001b\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u0004\u0018\u00010$*\u00020%H\u0002J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020$0\u00192\u0006\u0010'\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0018\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010(J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002JF\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000e2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020503H\u0096@¢\u0006\u0002\u00108J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u000207H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b;\u0010<¨\u0006K"}, d2 = {"Lcom/phisher98/KisskhProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResponse", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/phisher98/KisskhProvider$Media;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTitle", "str", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "getLanguage", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CHUNK_REGEX1", "Lkotlin/text/Regex;", "getCHUNK_REGEX1", "()Lkotlin/text/Regex;", "CHUNK_REGEX1$delegate", "Lkotlin/Lazy;", "getVideoInterceptor", "Lokhttp3/Interceptor;", "extractorLink", "Companion", "Data", "Sources", "Subtitle", "Responses", "Media", "Episodes", "MediaDetail", "Key", "KisskhProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nKisskhProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KisskhProvider.kt\ncom/phisher98/KisskhProvider\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,441:1\n73#2,5:442\n73#2,5:497\n73#2,5:526\n73#2,5:531\n73#2,5:536\n1795#3,10:447\n2068#3:457\n2069#3:459\n1805#3:460\n1795#3,10:484\n2068#3,2:494\n1805#3:496\n1739#3:502\n1814#3,2:503\n1816#3:506\n1739#3:564\n1814#3,3:565\n1#4:458\n1#4:464\n1#4:505\n1#4:508\n1#4:544\n93#5,2:461\n63#5:463\n64#5,15:465\n95#5,2:482\n63#5:507\n64#5,15:509\n93#5,2:541\n63#5:543\n64#5,15:545\n95#5,2:562\n50#6:480\n43#6:481\n50#6:524\n43#6:525\n50#6:560\n43#6:561\n*S KotlinDebug\n*F\n+ 1 KisskhProvider.kt\ncom/phisher98/KisskhProvider\n*L\n54#1:442,5\n104#1:497,5\n270#1:526,5\n274#1:531,5\n309#1:536,5\n55#1:447,10\n55#1:457\n55#1:459\n55#1:460\n88#1:484,10\n88#1:494,2\n88#1:496\n156#1:502\n156#1:503,2\n156#1:506\n311#1:564\n311#1:565,3\n55#1:458\n88#1:464\n269#1:508\n311#1:544\n88#1:461,2\n88#1:463\n88#1:465,15\n88#1:482,2\n269#1:507\n269#1:509,15\n311#1:541,2\n311#1:543\n311#1:545,15\n311#1:562,2\n88#1:480\n88#1:481\n269#1:524\n269#1:525\n311#1:560\n311#1:561\n*E\n"})
public final class KisskhProvider extends MainAPI {

    @NotNull
    public static final String TMDBIMAGEBASEURL = "https://image.tmdb.org/t/p/original";

    @NotNull
    private String mainUrl = "https://kisskh.is";

    @NotNull
    private String name = "Kisskh";
    private final boolean hasMainPage = true;
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.AsianDrama, TvType.Anime});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("&type=0&sub=0&country=0&status=0&order=2", "Latest"), TuplesKt.to("&type=0&sub=0&country=2&status=0&order=1", "Top K-Drama"), TuplesKt.to("&type=0&sub=0&country=1&status=0&order=1", "Top C-Drama"), TuplesKt.to("&type=2&sub=0&country=2&status=0&order=1", "Movie Popular"), TuplesKt.to("&type=2&sub=0&country=2&status=0&order=2", "Movie Last Update"), TuplesKt.to("&type=1&sub=0&country=2&status=0&order=1", "TVSeries Popular"), TuplesKt.to("&type=1&sub=0&country=2&status=0&order=2", "TVSeries Last Update"), TuplesKt.to("&type=3&sub=0&country=0&status=0&order=1", "Anime Popular"), TuplesKt.to("&type=3&sub=0&country=0&status=0&order=2", "Anime Latest Update"), TuplesKt.to("&type=4&sub=0&country=0&status=0&order=1", "Hollywood Popular"), TuplesKt.to("&type=4&sub=0&country=0&status=0&order=2", "Hollywood Last Update"), TuplesKt.to("&type=0&sub=0&country=0&status=3&order=2", "Upcoming")});

    /* JADX INFO: renamed from: CHUNK_REGEX1$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy CHUNK_REGEX1 = LazyKt.lazy(new Function0() { // from class: com.phisher98.KisskhProvider$$ExternalSyntheticLambda1
        public final Object invoke() {
            return KisskhProvider.CHUNK_REGEX1_delegate$lambda$0();
        }
    });

    /* JADX INFO: renamed from: com.phisher98.KisskhProvider$getMainPage$1 */
    /* JADX INFO: compiled from: KisskhProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.KisskhProvider", f = "KisskhProvider.kt", i = {0, 0}, l = {53}, m = "getMainPage", n = {"request", "page"}, nl = {54}, s = {"L$0", "I$0"}, v = 2)
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
            return KisskhProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.KisskhProvider$load$1 */
    /* JADX INFO: compiled from: KisskhProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.KisskhProvider", f = "KisskhProvider.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {99, 129, 151, 200, 233}, m = "load", n = {"url", "id", "url", "id", "res", "cleanTitle", "year", "type", "$this$load_u24lambda_u240", "isMovie", "url", "id", "res", "cleanTitle", "year", "type", "tmdbId", "tmdbOverview", "tmdbPoster", "tmdbBackdrop", "tmdbActors", "tmdbSeasonCache", "seasonsToFetch", "$this$load_u24lambda_u241", "s", "url", "id", "res", "cleanTitle", "year", "type", "tmdbId", "tmdbOverview", "tmdbPoster", "tmdbBackdrop", "tmdbActors", "tmdbSeasonCache", "episodes", "type", "$this$load_u24lambda_u243", "url", "id", "res", "cleanTitle", "year", "type", "tmdbId", "tmdbTitle", "tmdbOverview", "tmdbYear", "tmdbRating", "tmdbPoster", "tmdbBackdrop", "tmdbActors", "tmdbSeasonCache", "episodes"}, nl = {104, 133, 150, 201, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$16", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15"}, v = 2)
    static final class C00021 extends ContinuationImpl {
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

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KisskhProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.KisskhProvider$loadLinks$1 */
    /* JADX INFO: compiled from: KisskhProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.KisskhProvider", f = "KisskhProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {270, 271, 275, 309, 310, 314, 322}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "KisskhAPI", "KisskhSub", "loadData", "isCasting", "data", "subtitleCallback", "callback", "KisskhAPI", "KisskhSub", "loadData", "kkey", "isCasting", "data", "subtitleCallback", "callback", "KisskhAPI", "KisskhSub", "loadData", "kkey", "source", "isCasting", "data", "subtitleCallback", "callback", "KisskhAPI", "KisskhSub", "loadData", "kkey", "isCasting", "data", "subtitleCallback", "callback", "KisskhAPI", "KisskhSub", "loadData", "kkey", "kkey1", "isCasting", "data", "subtitleCallback", "callback", "KisskhAPI", "KisskhSub", "loadData", "kkey", "kkey1", "res", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "sub", "isCasting", "data", "subtitleCallback", "callback", "KisskhAPI", "KisskhSub", "loadData", "kkey", "kkey1", "res", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "sub", "isCasting"}, nl = {461, 274, 306, 471, 311, 313, 321}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "Z$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
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

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KisskhProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.KisskhProvider$search$1 */
    /* JADX INFO: compiled from: KisskhProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.KisskhProvider", f = "KisskhProvider.kt", i = {0}, l = {87}, m = "search", n = {"query"}, nl = {86}, s = {"L$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
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
            return KisskhProvider.this.search(null, (Continuation) this);
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
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws ErrorLoadingException {
        C00001 c00001;
        boolean z;
        MainPageRequest request2;
        Object safe;
        Iterable data;
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
                String str = getMainUrl() + "/api/DramaList/List?page=" + page + request.getData();
                c00001.L$0 = request;
                c00001.I$0 = page;
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
                int i = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Responses.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        Responses responses = (Responses) safe;
        if (responses == null || (data = responses.getData()) == null) {
            throw new ErrorLoadingException("Invalid Json reponse");
        }
        Iterable $this$mapNotNull$iv = data;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Media media = (Media) element$iv$iv$iv;
            SearchResponse searchResponse = toSearchResponse(media);
            if (searchResponse != null) {
                destination$iv$iv.add(searchResponse);
            }
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), home, z), Boxing.boxBoolean(z));
    }

    private final SearchResponse toSearchResponse(final Media $this$toSearchResponse) {
        if (!MainAPI.Companion.getSettingsForProvider().getEnableAdult()) {
            String label = $this$toSearchResponse.getLabel();
            Intrinsics.checkNotNull(label);
            if (StringsKt.contains$default(label, "RAW", false, 2, (Object) null)) {
                return null;
            }
        }
        KisskhProvider kisskhProvider = this;
        String title = $this$toSearchResponse.getTitle();
        if (title == null) {
            return null;
        }
        return MainAPIKt.newAnimeSearchResponse$default(kisskhProvider, title, $this$toSearchResponse.getTitle() + '/' + $this$toSearchResponse.getId(), TvType.TvSeries, false, new Function1() { // from class: com.phisher98.KisskhProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return KisskhProvider.toSearchResponse$lambda$0($this$toSearchResponse, (AnimeSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResponse$lambda$0(Media $this_toSearchResponse, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($this_toSearchResponse.getThumbnail());
        MainAPIKt.addSub($this$newAnimeSearchResponse, $this_toSearchResponse.getEpisodesCount());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws ErrorLoadingException {
        C00061 c00061;
        Object obj;
        Object objDecodeFromString;
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
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/api/DramaList/Search?q=" + query + "&type=0";
                String str2 = getMainUrl() + '/';
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00062.label = 1;
                $result = Requests.get$default(app, str, (Map) null, str2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4090, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String value$iv = ((NiceResponse) $result).getText();
        AppUtils appUtils = AppUtils.INSTANCE;
        Object obj2 = null;
        if (value$iv != null) {
            try {
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(ArrayList.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Media.class)));
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ArrayList.class), (List) null, 2, (Object) null));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv.readValue(value$iv, new TypeReference<ArrayList<Media>>() { // from class: com.phisher98.KisskhProvider$search$$inlined$tryParseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(value$iv, new TypeReference<ArrayList<Media>>() { // from class: com.phisher98.KisskhProvider$search$$inlined$tryParseJson$1
                        });
                    }
                } else {
                    ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(value$iv, new TypeReference<ArrayList<Media>>() { // from class: com.phisher98.KisskhProvider$search$$inlined$tryParseJson$1
                    });
                }
                obj2 = objDecodeFromString;
            } catch (Exception e2) {
                obj2 = null;
            }
        }
        Iterable iterable = (ArrayList) obj2;
        if (iterable == null) {
            throw new ErrorLoadingException("Invalid Json reponse");
        }
        Iterable $this$mapNotNull$iv = iterable;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Media media = (Media) element$iv$iv$iv;
            SearchResponse searchResponse = toSearchResponse(media);
            if (searchResponse != null) {
                destination$iv$iv.add(searchResponse);
            }
        }
        return (List) destination$iv$iv;
    }

    private final String getTitle(String str) {
        return new Regex("[^a-zA-Z0-9]").replace(str, "-");
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0629  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:86:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:93:0x0598 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:94:0x0599  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0611 -> B:110:0x0623). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x0599 -> B:367:0x05ae). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r69, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r70) {
        /*
            Method dump skipped, instruction units count: 3644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.KisskhProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2$2(Ref.ObjectRef $epName, String $displayNumber, Episodes $eps, Ref.ObjectRef $epOverview, Ref.ObjectRef $epThumb, Ref.ObjectRef $epRating, Ref.ObjectRef $epAir, Episode $this$newEpisode) {
        String str = (String) $epName.element;
        if (str == null) {
            str = "Episode " + $displayNumber;
        }
        $this$newEpisode.setName(str);
        Double number = $eps.getNumber();
        $this$newEpisode.setEpisode(number != null ? Integer.valueOf((int) number.doubleValue()) : null);
        $this$newEpisode.setDescription((String) $epOverview.element);
        $this$newEpisode.setPosterUrl((String) $epThumb.element);
        $this$newEpisode.setScore(Score.Companion.from10((Double) $epRating.element));
        MainAPIKt.addDate$default($this$newEpisode, (String) $epAir.element, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.KisskhProvider$load$12 */
    /* JADX INFO: compiled from: KisskhProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.KisskhProvider$load$12", f = "KisskhProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C000312 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ MediaDetail $res;
        final /* synthetic */ Ref.ObjectRef<List<ActorData>> $tmdbActors;
        final /* synthetic */ Ref.ObjectRef<String> $tmdbBackdrop;
        final /* synthetic */ Ref.ObjectRef<String> $tmdbOverview;
        final /* synthetic */ Ref.ObjectRef<String> $tmdbPoster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C000312(Ref.ObjectRef<String> objectRef, MediaDetail mediaDetail, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3, Ref.ObjectRef<List<ActorData>> objectRef4, Continuation<? super C000312> continuation) {
            super(2, continuation);
            this.$tmdbPoster = objectRef;
            this.$res = mediaDetail;
            this.$tmdbBackdrop = objectRef2;
            this.$tmdbOverview = objectRef3;
            this.$tmdbActors = objectRef4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c000312 = new C000312(this.$tmdbPoster, this.$res, this.$tmdbBackdrop, this.$tmdbOverview, this.$tmdbActors, continuation);
            c000312.L$0 = obj;
            return c000312;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            List listSplit$default;
            String str;
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String thumbnail = (String) this.$tmdbPoster.element;
                    if (thumbnail == null) {
                        thumbnail = this.$res.getThumbnail();
                    }
                    $this$newTvSeriesLoadResponse.setPosterUrl(thumbnail);
                    String thumbnail2 = (String) this.$tmdbBackdrop.element;
                    if (thumbnail2 == null && (thumbnail2 = (String) this.$tmdbPoster.element) == null) {
                        thumbnail2 = this.$res.getThumbnail();
                    }
                    $this$newTvSeriesLoadResponse.setBackgroundPosterUrl(thumbnail2);
                    String releaseDate = this.$res.getReleaseDate();
                    ShowStatus showStatus = null;
                    $this$newTvSeriesLoadResponse.setYear((releaseDate == null || (listSplit$default = StringsKt.split$default(releaseDate, new String[]{"-"}, false, 0, 6, (Object) null)) == null || (str = (String) CollectionsKt.first(listSplit$default)) == null) ? null : StringsKt.toIntOrNull(str));
                    String description = this.$res.getDescription();
                    if (description == null) {
                        description = (String) this.$tmdbOverview.element;
                    }
                    $this$newTvSeriesLoadResponse.setPlot(description);
                    $this$newTvSeriesLoadResponse.setTags(CollectionsKt.listOf(new String[]{String.valueOf(this.$res.getCountry()), String.valueOf(this.$res.getStatus()), String.valueOf(this.$res.getType())}));
                    $this$newTvSeriesLoadResponse.setActors((List) this.$tmdbActors.element);
                    String status = this.$res.getStatus();
                    if (Intrinsics.areEqual(status, "Completed")) {
                        showStatus = ShowStatus.Completed;
                    } else if (Intrinsics.areEqual(status, "Ongoing")) {
                        showStatus = ShowStatus.Ongoing;
                    }
                    $this$newTvSeriesLoadResponse.setShowStatus(showStatus);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final String getLanguage(String str) {
        return Intrinsics.areEqual(str, "Indonesia") ? "Indonesian" : str;
    }

    /* JADX WARN: Code duplicated, block: B:155:0x0748  */
    /* JADX WARN: Code duplicated, block: B:157:0x0778  */
    /* JADX WARN: Code duplicated, block: B:159:0x077e  */
    /* JADX WARN: Code duplicated, block: B:160:0x0783  */
    /* JADX WARN: Code duplicated, block: B:162:0x07fc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:163:0x07fd  */
    /* JADX WARN: Code duplicated, block: B:165:0x0841  */
    /* JADX WARN: Code duplicated, block: B:167:0x084b  */
    /* JADX WARN: Code duplicated, block: B:168:0x086b  */
    /* JADX WARN: Code duplicated, block: B:170:0x08d8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:171:0x08d9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:171:0x08d9 -> B:172:0x08fa). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r35, boolean r36, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r37, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r38, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r39) {
        /*
            Method dump skipped, instruction units count: 2418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.KisskhProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static final Regex CHUNK_REGEX1_delegate$lambda$0() {
        return new Regex("^\\d+$", RegexOption.MULTILINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Regex getCHUNK_REGEX1() {
        return (Regex) this.CHUNK_REGEX1.getValue();
    }

    /* JADX INFO: renamed from: com.phisher98.KisskhProvider$getVideoInterceptor$1 */
    /* JADX INFO: compiled from: KisskhProvider.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/phisher98/KisskhProvider$getVideoInterceptor$1", "Lokhttp3/Interceptor;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "KisskhProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nKisskhProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KisskhProvider.kt\ncom/phisher98/KisskhProvider$getVideoInterceptor$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,441:1\n777#2:442\n873#2,2:443\n1739#2:445\n1814#2,3:446\n1749#2:449\n1782#2,4:450\n777#2:454\n873#2,2:455\n*S KotlinDebug\n*F\n+ 1 KisskhProvider.kt\ncom/phisher98/KisskhProvider$getVideoInterceptor$1\n*L\n358#1:442\n358#1:443,2\n359#1:445\n359#1:446,3\n360#1:449\n360#1:450,4\n375#1:454\n375#1:455,2\n*E\n"})
    public static final class C00011 implements Interceptor {
        C00011() {
        }

        public Response intercept(Interceptor.Chain chain) {
            String strJoinToString$default;
            Request request = chain.request().newBuilder().build();
            Response response = chain.proceed(request);
            if (!StringsKt.contains$default(response.request().url().toString(), ".txt", false, 2, (Object) null)) {
                return response;
            }
            String responseBody = response.body().toString();
            Iterable $this$filter$iv = KisskhProvider.this.getCHUNK_REGEX1().split(responseBody, 0);
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                String p0 = (String) element$iv$iv;
                if (!StringsKt.isBlank(p0)) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$map$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String p1 = (String) item$iv$iv;
                destination$iv$iv2.add(StringsKt.trim(p1).toString());
            }
            Iterable chunks = (List) destination$iv$iv2;
            Iterable $this$mapIndexed$iv = chunks;
            Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            int index$iv$iv = 0;
            for (Object item$iv$iv2 : $this$mapIndexed$iv) {
                int index$iv$iv2 = index$iv$iv + 1;
                if (index$iv$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String chunk = (String) item$iv$iv2;
                if (StringsKt.isBlank(chunk)) {
                    strJoinToString$default = "";
                } else {
                    List parts = StringsKt.split$default(chunk, new String[]{"\n"}, false, 0, 6, (Object) null);
                    if (parts.isEmpty()) {
                        strJoinToString$default = "";
                    } else {
                        String header = (String) CollectionsKt.first(parts);
                        List text = CollectionsKt.drop(parts, 1);
                        String d = CollectionsKt.joinToString$default(text, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.KisskhProvider$getVideoInterceptor$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                return KisskhProvider.C00011.intercept$lambda$0$0((String) obj);
                            }
                        }, 30, (Object) null);
                        strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOf(new Object[]{Integer.valueOf(index$iv$iv + 1), header, d}), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                    }
                }
                destination$iv$iv3.add(strJoinToString$default);
                index$iv$iv = index$iv$iv2;
            }
            Iterable $this$filter$iv2 = (List) destination$iv$iv3;
            Collection destination$iv$iv4 = new ArrayList();
            for (Object element$iv$iv2 : $this$filter$iv2) {
                String it = (String) element$iv$iv2;
                if (it.length() > 0) {
                    destination$iv$iv4.add(element$iv$iv2);
                }
            }
            String decrypted = CollectionsKt.joinToString$default((List) destination$iv$iv4, "\n\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            ResponseBody newBody = ResponseBody.Companion.create(decrypted, response.body().contentType());
            return response.newBuilder().body(newBody).build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence intercept$lambda$0$0(String line) {
            try {
                return SubDecryptorKt.decrypt(line);
            } catch (Exception e) {
                return "DECRYPT_ERROR:" + e.getMessage();
            }
        }
    }

    @NotNull
    public Interceptor getVideoInterceptor(@NotNull ExtractorLink extractorLink) {
        return new C00011();
    }

    /* JADX INFO: compiled from: KisskhProvider.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/phisher98/KisskhProvider$Data;", "", "title", "", "eps", "", "id", "epsId", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getTitle", "()Ljava/lang/String;", "getEps", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getEpsId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/KisskhProvider$Data;", "equals", "", "other", "hashCode", "toString", "KisskhProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Data {

        @Nullable
        private final Integer eps;

        @Nullable
        private final Integer epsId;

        @Nullable
        private final Integer id;

        @Nullable
        private final String title;

        public static /* synthetic */ Data copy$default(Data data, String str, Integer num, Integer num2, Integer num3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = data.title;
            }
            if ((i & 2) != 0) {
                num = data.eps;
            }
            if ((i & 4) != 0) {
                num2 = data.id;
            }
            if ((i & 8) != 0) {
                num3 = data.epsId;
            }
            return data.copy(str, num, num2, num3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getEps() {
            return this.eps;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getEpsId() {
            return this.epsId;
        }

        @NotNull
        public final Data copy(@Nullable String title, @Nullable Integer eps, @Nullable Integer id, @Nullable Integer epsId) {
            return new Data(title, eps, id, epsId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return Intrinsics.areEqual(this.title, data.title) && Intrinsics.areEqual(this.eps, data.eps) && Intrinsics.areEqual(this.id, data.id) && Intrinsics.areEqual(this.epsId, data.epsId);
        }

        public int hashCode() {
            return ((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.eps == null ? 0 : this.eps.hashCode())) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.epsId != null ? this.epsId.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Data(title=" + this.title + ", eps=" + this.eps + ", id=" + this.id + ", epsId=" + this.epsId + ')';
        }

        public Data(@Nullable String title, @Nullable Integer eps, @Nullable Integer id, @Nullable Integer epsId) {
            this.title = title;
            this.eps = eps;
            this.id = id;
            this.epsId = epsId;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final Integer getEps() {
            return this.eps;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final Integer getEpsId() {
            return this.epsId;
        }
    }

    /* JADX INFO: compiled from: KisskhProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0010\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/phisher98/KisskhProvider$Sources;", "", "video", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Video", "thirdParty", "ThirdParty", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getVideo", "()Ljava/lang/String;", "getThirdParty", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "KisskhProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Sources {

        @Nullable
        private final String thirdParty;

        @Nullable
        private final String video;

        public static /* synthetic */ Sources copy$default(Sources sources, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sources.video;
            }
            if ((i & 2) != 0) {
                str2 = sources.thirdParty;
            }
            return sources.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getVideo() {
            return this.video;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getThirdParty() {
            return this.thirdParty;
        }

        @NotNull
        public final Sources copy(@JsonProperty("Video") @Nullable String video, @JsonProperty("ThirdParty") @Nullable String thirdParty) {
            return new Sources(video, thirdParty);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Sources)) {
                return false;
            }
            Sources sources = (Sources) other;
            return Intrinsics.areEqual(this.video, sources.video) && Intrinsics.areEqual(this.thirdParty, sources.thirdParty);
        }

        public int hashCode() {
            return ((this.video == null ? 0 : this.video.hashCode()) * 31) + (this.thirdParty != null ? this.thirdParty.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Sources(video=" + this.video + ", thirdParty=" + this.thirdParty + ')';
        }

        public Sources(@JsonProperty("Video") @Nullable String video, @JsonProperty("ThirdParty") @Nullable String thirdParty) {
            this.video = video;
            this.thirdParty = thirdParty;
        }

        @Nullable
        public final String getVideo() {
            return this.video;
        }

        @Nullable
        public final String getThirdParty() {
            return this.thirdParty;
        }
    }

    /* JADX INFO: compiled from: KisskhProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u000e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/phisher98/KisskhProvider$Subtitle;", "", "src", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "label", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSrc", "()Ljava/lang/String;", "getLabel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "KisskhProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Subtitle {

        @Nullable
        private final String label;

        @Nullable
        private final String src;

        public static /* synthetic */ Subtitle copy$default(Subtitle subtitle, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subtitle.src;
            }
            if ((i & 2) != 0) {
                str2 = subtitle.label;
            }
            return subtitle.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSrc() {
            return this.src;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        @NotNull
        public final Subtitle copy(@JsonProperty("src") @Nullable String src, @JsonProperty("label") @Nullable String label) {
            return new Subtitle(src, label);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Subtitle)) {
                return false;
            }
            Subtitle subtitle = (Subtitle) other;
            return Intrinsics.areEqual(this.src, subtitle.src) && Intrinsics.areEqual(this.label, subtitle.label);
        }

        public int hashCode() {
            return ((this.src == null ? 0 : this.src.hashCode()) * 31) + (this.label != null ? this.label.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Subtitle(src=" + this.src + ", label=" + this.label + ')';
        }

        public Subtitle(@JsonProperty("src") @Nullable String src, @JsonProperty("label") @Nullable String label) {
            this.src = src;
            this.label = label;
        }

        @Nullable
        public final String getSrc() {
            return this.src;
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }
    }

    /* JADX INFO: compiled from: KisskhProvider.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/KisskhProvider$Responses;", "", "data", "Ljava/util/ArrayList;", "Lcom/phisher98/KisskhProvider$Media;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getData", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "KisskhProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Responses {

        @Nullable
        private final ArrayList<Media> data;

        /* JADX WARN: Illegal instructions before constructor call */
        public Responses() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Responses copy$default(Responses responses, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = responses.data;
            }
            return responses.copy(arrayList);
        }

        @Nullable
        public final ArrayList<Media> component1() {
            return this.data;
        }

        @NotNull
        public final Responses copy(@JsonProperty("data") @Nullable ArrayList<Media> data) {
            return new Responses(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Responses) && Intrinsics.areEqual(this.data, ((Responses) other).data);
        }

        public int hashCode() {
            if (this.data == null) {
                return 0;
            }
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "Responses(data=" + this.data + ')';
        }

        public Responses(@JsonProperty("data") @Nullable ArrayList<Media> arrayList) {
            this.data = arrayList;
        }

        public /* synthetic */ Responses(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final ArrayList<Media> getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: KisskhProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0090\u0001\u0010\u001a\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\nHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006!"}, d2 = {"Lcom/phisher98/KisskhProvider$Media;", "", "episodesCount", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "thumbnail", "", "label", "id", "title", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getEpisodesCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getThumbnail", "()Ljava/lang/String;", "getLabel", "getId", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/KisskhProvider$Media;", "equals", "", "other", "hashCode", "toString", "KisskhProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Media {

        @Nullable
        private final Integer episodesCount;

        @Nullable
        private final Integer id;

        @Nullable
        private final String label;

        @Nullable
        private final String thumbnail;

        @Nullable
        private final String title;

        public static /* synthetic */ Media copy$default(Media media, Integer num, String str, String str2, Integer num2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                num = media.episodesCount;
            }
            if ((i & 2) != 0) {
                str = media.thumbnail;
            }
            if ((i & 4) != 0) {
                str2 = media.label;
            }
            if ((i & 8) != 0) {
                num2 = media.id;
            }
            if ((i & 16) != 0) {
                str3 = media.title;
            }
            String str4 = str3;
            String str5 = str2;
            return media.copy(num, str, str5, num2, str4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getEpisodesCount() {
            return this.episodesCount;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getThumbnail() {
            return this.thumbnail;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final Media copy(@JsonProperty("episodesCount") @Nullable Integer episodesCount, @JsonProperty("thumbnail") @Nullable String thumbnail, @JsonProperty("label") @Nullable String label, @JsonProperty("id") @Nullable Integer id, @JsonProperty("title") @Nullable String title) {
            return new Media(episodesCount, thumbnail, label, id, title);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Media)) {
                return false;
            }
            Media media = (Media) other;
            return Intrinsics.areEqual(this.episodesCount, media.episodesCount) && Intrinsics.areEqual(this.thumbnail, media.thumbnail) && Intrinsics.areEqual(this.label, media.label) && Intrinsics.areEqual(this.id, media.id) && Intrinsics.areEqual(this.title, media.title);
        }

        public int hashCode() {
            return ((((((((this.episodesCount == null ? 0 : this.episodesCount.hashCode()) * 31) + (this.thumbnail == null ? 0 : this.thumbnail.hashCode())) * 31) + (this.label == null ? 0 : this.label.hashCode())) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.title != null ? this.title.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Media(episodesCount=" + this.episodesCount + ", thumbnail=" + this.thumbnail + ", label=" + this.label + ", id=" + this.id + ", title=" + this.title + ')';
        }

        public Media(@JsonProperty("episodesCount") @Nullable Integer episodesCount, @JsonProperty("thumbnail") @Nullable String thumbnail, @JsonProperty("label") @Nullable String label, @JsonProperty("id") @Nullable Integer id, @JsonProperty("title") @Nullable String title) {
            this.episodesCount = episodesCount;
            this.thumbnail = thumbnail;
            this.label = label;
            this.id = id;
            this.title = title;
        }

        @Nullable
        public final Integer getEpisodesCount() {
            return this.episodesCount;
        }

        @Nullable
        public final String getThumbnail() {
            return this.thumbnail;
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }
    }

    /* JADX INFO: compiled from: KisskhProvider.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\\\u0010\u0015\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/phisher98/KisskhProvider$Episodes;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "number", "", "sub", "<init>", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNumber", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSub", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;)Lcom/phisher98/KisskhProvider$Episodes;", "equals", "", "other", "hashCode", "toString", "", "KisskhProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Episodes {

        @Nullable
        private final Integer id;

        @Nullable
        private final Double number;

        @Nullable
        private final Integer sub;

        public static /* synthetic */ Episodes copy$default(Episodes episodes, Integer num, Double d, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = episodes.id;
            }
            if ((i & 2) != 0) {
                d = episodes.number;
            }
            if ((i & 4) != 0) {
                num2 = episodes.sub;
            }
            return episodes.copy(num, d, num2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Double getNumber() {
            return this.number;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getSub() {
            return this.sub;
        }

        @NotNull
        public final Episodes copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("number") @Nullable Double number, @JsonProperty("sub") @Nullable Integer sub) {
            return new Episodes(id, number, sub);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Episodes)) {
                return false;
            }
            Episodes episodes = (Episodes) other;
            return Intrinsics.areEqual(this.id, episodes.id) && Intrinsics.areEqual(this.number, episodes.number) && Intrinsics.areEqual(this.sub, episodes.sub);
        }

        public int hashCode() {
            return ((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.number == null ? 0 : this.number.hashCode())) * 31) + (this.sub != null ? this.sub.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Episodes(id=" + this.id + ", number=" + this.number + ", sub=" + this.sub + ')';
        }

        public Episodes(@JsonProperty("id") @Nullable Integer id, @JsonProperty("number") @Nullable Double number, @JsonProperty("sub") @Nullable Integer sub) {
            this.id = id;
            this.number = number;
            this.sub = sub;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final Double getNumber() {
            return this.number;
        }

        @Nullable
        public final Integer getSub() {
            return this.sub;
        }
    }

    /* JADX INFO: compiled from: KisskhProvider.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0002\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012*\b\u0003\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008a\u0002\u0010*\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2*\b\u0003\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011HÆ\u0001¢\u0006\u0002\u0010+J\u0014\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010/\u001a\u00020\u0010HÖ\u0081\u0004J\n\u00100\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R%\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015¨\u00061"}, d2 = {"Lcom/phisher98/KisskhProvider$MediaDetail;", "", "description", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "releaseDate", "status", "type", "country", "episodes", "Ljava/util/ArrayList;", "Lcom/phisher98/KisskhProvider$Episodes;", "Lkotlin/collections/ArrayList;", "thumbnail", "id", "", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getReleaseDate", "getStatus", "getType", "getCountry", "getEpisodes", "()Ljava/util/ArrayList;", "getThumbnail", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/KisskhProvider$MediaDetail;", "equals", "", "other", "hashCode", "toString", "KisskhProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class MediaDetail {

        @Nullable
        private final String country;

        @Nullable
        private final String description;

        @Nullable
        private final ArrayList<Episodes> episodes;

        @Nullable
        private final Integer id;

        @Nullable
        private final String releaseDate;

        @Nullable
        private final String status;

        @Nullable
        private final String thumbnail;

        @Nullable
        private final String title;

        @Nullable
        private final String type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MediaDetail copy$default(MediaDetail mediaDetail, String str, String str2, String str3, String str4, String str5, ArrayList arrayList, String str6, Integer num, String str7, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mediaDetail.description;
            }
            if ((i & 2) != 0) {
                str2 = mediaDetail.releaseDate;
            }
            if ((i & 4) != 0) {
                str3 = mediaDetail.status;
            }
            if ((i & 8) != 0) {
                str4 = mediaDetail.type;
            }
            if ((i & 16) != 0) {
                str5 = mediaDetail.country;
            }
            if ((i & 32) != 0) {
                arrayList = mediaDetail.episodes;
            }
            if ((i & 64) != 0) {
                str6 = mediaDetail.thumbnail;
            }
            if ((i & 128) != 0) {
                num = mediaDetail.id;
            }
            if ((i & 256) != 0) {
                str7 = mediaDetail.title;
            }
            Integer num2 = num;
            String str8 = str7;
            ArrayList arrayList2 = arrayList;
            String str9 = str6;
            String str10 = str5;
            String str11 = str3;
            return mediaDetail.copy(str, str2, str11, str4, str10, arrayList2, str9, num2, str8);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getReleaseDate() {
            return this.releaseDate;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getStatus() {
            return this.status;
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
        public final ArrayList<Episodes> component6() {
            return this.episodes;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getThumbnail() {
            return this.thumbnail;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final MediaDetail copy(@JsonProperty("description") @Nullable String description, @JsonProperty("releaseDate") @Nullable String releaseDate, @JsonProperty("status") @Nullable String status, @JsonProperty("type") @Nullable String type, @JsonProperty("country") @Nullable String country, @JsonProperty("episodes") @Nullable ArrayList<Episodes> episodes, @JsonProperty("thumbnail") @Nullable String thumbnail, @JsonProperty("id") @Nullable Integer id, @JsonProperty("title") @Nullable String title) {
            return new MediaDetail(description, releaseDate, status, type, country, episodes, thumbnail, id, title);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MediaDetail)) {
                return false;
            }
            MediaDetail mediaDetail = (MediaDetail) other;
            return Intrinsics.areEqual(this.description, mediaDetail.description) && Intrinsics.areEqual(this.releaseDate, mediaDetail.releaseDate) && Intrinsics.areEqual(this.status, mediaDetail.status) && Intrinsics.areEqual(this.type, mediaDetail.type) && Intrinsics.areEqual(this.country, mediaDetail.country) && Intrinsics.areEqual(this.episodes, mediaDetail.episodes) && Intrinsics.areEqual(this.thumbnail, mediaDetail.thumbnail) && Intrinsics.areEqual(this.id, mediaDetail.id) && Intrinsics.areEqual(this.title, mediaDetail.title);
        }

        public int hashCode() {
            return ((((((((((((((((this.description == null ? 0 : this.description.hashCode()) * 31) + (this.releaseDate == null ? 0 : this.releaseDate.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.country == null ? 0 : this.country.hashCode())) * 31) + (this.episodes == null ? 0 : this.episodes.hashCode())) * 31) + (this.thumbnail == null ? 0 : this.thumbnail.hashCode())) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.title != null ? this.title.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "MediaDetail(description=" + this.description + ", releaseDate=" + this.releaseDate + ", status=" + this.status + ", type=" + this.type + ", country=" + this.country + ", episodes=" + this.episodes + ", thumbnail=" + this.thumbnail + ", id=" + this.id + ", title=" + this.title + ')';
        }

        public MediaDetail(@JsonProperty("description") @Nullable String description, @JsonProperty("releaseDate") @Nullable String releaseDate, @JsonProperty("status") @Nullable String status, @JsonProperty("type") @Nullable String type, @JsonProperty("country") @Nullable String country, @JsonProperty("episodes") @Nullable ArrayList<Episodes> arrayList, @JsonProperty("thumbnail") @Nullable String thumbnail, @JsonProperty("id") @Nullable Integer id, @JsonProperty("title") @Nullable String title) {
            this.description = description;
            this.releaseDate = releaseDate;
            this.status = status;
            this.type = type;
            this.country = country;
            this.episodes = arrayList;
            this.thumbnail = thumbnail;
            this.id = id;
            this.title = title;
        }

        public /* synthetic */ MediaDetail(String str, String str2, String str3, String str4, String str5, ArrayList arrayList, String str6, Integer num, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
            ArrayList arrayList2;
            if ((i & 32) == 0) {
                arrayList2 = arrayList;
            } else {
                arrayList2 = new ArrayList();
            }
            this(str, str2, str3, str4, str5, arrayList2, str6, num, str7);
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getReleaseDate() {
            return this.releaseDate;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
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
        public final ArrayList<Episodes> getEpisodes() {
            return this.episodes;
        }

        @Nullable
        public final String getThumbnail() {
            return this.thumbnail;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }
    }

    /* JADX INFO: compiled from: KisskhProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/KisskhProvider$Key;", "", "id", "", "version", "key", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getVersion", "getKey", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "KisskhProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Key {

        @NotNull
        private final String id;

        @NotNull
        private final String key;

        @NotNull
        private final String version;

        public static /* synthetic */ Key copy$default(Key key, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = key.id;
            }
            if ((i & 2) != 0) {
                str2 = key.version;
            }
            if ((i & 4) != 0) {
                str3 = key.key;
            }
            return key.copy(str, str2, str3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getVersion() {
            return this.version;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        @NotNull
        public final Key copy(@NotNull String id, @NotNull String version, @NotNull String key) {
            return new Key(id, version, key);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Key)) {
                return false;
            }
            Key key = (Key) other;
            return Intrinsics.areEqual(this.id, key.id) && Intrinsics.areEqual(this.version, key.version) && Intrinsics.areEqual(this.key, key.key);
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.version.hashCode()) * 31) + this.key.hashCode();
        }

        @NotNull
        public String toString() {
            return "Key(id=" + this.id + ", version=" + this.version + ", key=" + this.key + ')';
        }

        public Key(@NotNull String id, @NotNull String version, @NotNull String key) {
            this.id = id;
            this.version = version;
            this.key = key;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getVersion() {
            return this.version;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }
    }
}
