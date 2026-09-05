package com.Anichi;

import android.annotation.SuppressLint;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorRole;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.syncproviders.SyncIdName;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.StringUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
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
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Anichi.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Anichi/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 X2\u00020\u0001:\u0001XB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u001e\u00100\u001a\u0002052\u0006\u00106\u001a\u00020&2\u0006\u00107\u001a\u000208H\u0096@¢\u0006\u0002\u00109J\u0018\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010=J\u0014\u0010>\u001a\u0004\u0018\u00010\u00052\b\u0010?\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010@\u001a\u0004\u0018\u00010A*\u00020BH\u0002J\u001e\u0010C\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010.2\u0006\u0010E\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010=J \u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010E\u001a\u00020\u00052\u0006\u00106\u001a\u00020&H\u0096@¢\u0006\u0002\u0010HJ \u0010I\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00172\u0006\u0010J\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010KJ\u0018\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010<\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010=JF\u0010N\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u000b2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020T0R2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020T0RH\u0096@¢\u0006\u0002\u0010WR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0011\u0010+\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0007R/\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.8\u0016X\u0097\u0004\u0092\u0002\u0010\b2\u0012\f\b3\u0012\b\b\fJ\u0004\b\b(4¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u0006Y"}, d2 = {"Lcom/Anichi/Anichi;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "instantLinkLoading", "", "getInstantLinkLoading", "()Z", "hasQuickSearch", "getHasQuickSearch", "hasMainPage", "getHasMainPage", "getStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "t", "supportedSyncNames", "", "Lcom/lagradost/cloudstream3/syncproviders/SyncIdName;", "getSupportedSyncNames", "()Ljava/util/Set;", "supportedTypes", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "popularTitle", "animeRecentTitle", "donghuaRecentTitle", "movieTitle", "calendar", "Ljava/util/Calendar;", "getCalendar", "()Ljava/util/Calendar;", "year", "", "getYear", "()I", "month", "getMonth", "season", "getSeason", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Landroid/annotation/SuppressLint;", "value", "NewApi", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchQuery", "Lcom/Anichi/AnichiParser$AnichiQuery;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPosterUrl", "thumbnail", "toSearchResponse", "Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "Lcom/Anichi/AnichiParser$Edges;", "quickSearch", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLoadUrl", "id", "(Lcom/lagradost/cloudstream3/syncproviders/SyncIdName;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnichi.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Anichi.kt\ncom/Anichi/Anichi\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,376:1\n1739#2:377\n1814#2,3:378\n777#2:381\n873#2,2:382\n1795#2,10:384\n2068#2:394\n2069#2:396\n1805#2:397\n777#2:423\n873#2,2:424\n1795#2,10:426\n2068#2:436\n2069#2:438\n1805#2:439\n296#2,2:450\n1739#2:452\n1814#2,3:453\n1739#2:475\n1814#2,2:476\n1816#2:479\n1#3:395\n1#3:403\n1#3:405\n1#3:437\n1#3:457\n1#3:478\n73#4,5:398\n73#4,5:440\n73#4,5:445\n63#5:404\n64#5,15:406\n63#5:456\n64#5,15:458\n50#6:421\n43#6:422\n50#6:473\n43#6:474\n*S KotlinDebug\n*F\n+ 1 Anichi.kt\ncom/Anichi/Anichi\n*L\n112#1:377\n112#1:378,3\n116#1:381\n116#1:382,2\n122#1:384,10\n122#1:394\n122#1:396\n122#1:397\n180#1:423\n180#1:424,2\n187#1:426,10\n187#1:436\n187#1:438\n187#1:439\n258#1:450,2\n296#1:452\n296#1:453,3\n276#1:475\n276#1:476,2\n276#1:479\n122#1:395\n177#1:405\n187#1:437\n343#1:457\n135#1:398,5\n198#1:440,5\n227#1:445,5\n177#1:404\n177#1:406,15\n343#1:456\n343#1:458,15\n177#1:421\n177#1:422\n343#1:473\n343#1:474\n*E\n"})
public class Anichi extends MainAPI {

    @NotNull
    public static final String anilistApi = "https://graphql.anilist.co";

    @NotNull
    public static final String apiEndPoint = "https://allanime.day";

    @NotNull
    public static final String apiUrl = "https://api.allanime.day/api";

    @NotNull
    private static final String detailHash = "bb263f91e5bdd048c1c978f324613aeccdfe2cbc694a419466a31edb58c0cc0b";

    @NotNull
    public static final String jikanApi = "https://api.jikan.moe/v4";

    @NotNull
    private static final String mainHash = "e42a4466d984b2c0a2cecae5dd13aa68867f634b16ee0f17b380047d14482406";

    @NotNull
    public static final String maipageshaHash = "a24c500a1b765c68ae1d8dd85174931f661c71369c89b92b88b75a725afc471c";

    @NotNull
    private static final String popularHash = "60f50b84bb545fa25ee7f7c8c0adbf8f5cea40f7b1ef8501cbbff70e38589489";

    @NotNull
    public static final String serverHash = "d405d0edd690624b66baba3068e0edc3ac90f1597d898a1ec8db4e5c43c00fec";

    @SuppressLint({"NewApi"})
    @NotNull
    private final List<MainPageData> mainPage;

    @NotNull
    private final String season;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Map<String, String> headers = MapsKt.mapOf(TuplesKt.to("Referer", "https://mkissa.to"));

    @NotNull
    private String name = "Anichi";
    private final boolean instantLinkLoading = true;
    private final boolean hasQuickSearch = true;
    private final boolean hasMainPage = true;

    @NotNull
    private final Set<SyncIdName> supportedSyncNames = SetsKt.setOf(new SyncIdName[]{SyncIdName.Anilist, SyncIdName.MyAnimeList});

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie});

    @NotNull
    private final String popularTitle = "Popular";

    @NotNull
    private final String animeRecentTitle = "Latest Anime";

    @NotNull
    private final String donghuaRecentTitle = "Latest Donghua";

    @NotNull
    private final String movieTitle = "Movie";

    @NotNull
    private final Calendar calendar = Calendar.getInstance();
    private final int year = this.calendar.get(1);
    private final int month = this.calendar.get(2) + 1;

    /* JADX INFO: renamed from: com.Anichi.Anichi$fetchQuery$1 */
    /* JADX INFO: compiled from: Anichi.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.Anichi", f = "Anichi.kt", i = {0}, l = {135}, m = "fetchQuery", n = {"url"}, nl = {377}, s = {"L$0"}, v = 2)
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
            return Anichi.this.fetchQuery(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Anichi.Anichi$getLoadUrl$1 */
    /* JADX INFO: compiled from: Anichi.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.Anichi", f = "Anichi.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {196, 198, 200}, m = "getLoadUrl$suspendImpl", n = {"$this", "name", "id", "syncId", "$this", "name", "id", "syncId", "malId", "$this", "name", "id", "syncId", "malId", "media", "link"}, nl = {193, 377, 202}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Anichi.getLoadUrl$suspendImpl(Anichi.this, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Anichi.Anichi$getMainPage$1 */
    /* JADX INFO: compiled from: Anichi.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.Anichi", f = "Anichi.kt", i = {0, 0, 0, 0}, l = {108}, m = "getMainPage$suspendImpl", n = {"$this", "request", "url", "page"}, nl = {109}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Anichi.getMainPage$suspendImpl(Anichi.this, 0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Anichi.Anichi$load$1 */
    /* JADX INFO: compiled from: Anichi.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.Anichi", f = "Anichi.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {226, 234, 242, 267, 311}, m = "load$suspendImpl", n = {"$this", "url", "id", "body", "$this", "url", "id", "body", "res", "showData", "title", "description", "$this", "url", "id", "body", "res", "showData", "title", "description", "trackers", "$this", "url", "id", "body", "res", "showData", "title", "description", "trackers", "data", "animeMetadata", "fanart", "engtitle", "backgroundposter", "logotvType", "tmdbid", "$this", "url", "id", "body", "res", "showData", "title", "description", "trackers", "data", "animeMetadata", "fanart", "engtitle", "backgroundposter", "logotvType", "tmdbid", "logoUrl", "poster", "episodes", "subEpisodes", "dubEpisodes", "characters", "tvType"}, nl = {227, 233, 257, 275, -1}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22"}, v = 2)
    static final class C00031 extends ContinuationImpl {
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
            return Anichi.load$suspendImpl(Anichi.this, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Anichi.Anichi$loadLinks$1 */
    /* JADX INFO: compiled from: Anichi.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.Anichi", f = "Anichi.kt", i = {0, 0, 0, 0, 0, 0}, l = {344}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "loadData", "isCasting"}, nl = {352}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 2)
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
            return Anichi.loadLinks$suspendImpl(Anichi.this, null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Anichi.Anichi$quickSearch$1 */
    /* JADX INFO: compiled from: Anichi.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.Anichi", f = "Anichi.kt", i = {0, 0, 1, 1}, l = {160, 159}, m = "quickSearch$suspendImpl", n = {"$this", "query", "$this", "query"}, nl = {164, 165}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Anichi.quickSearch$suspendImpl(Anichi.this, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Anichi.Anichi$search$1 */
    /* JADX INFO: compiled from: Anichi.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.Anichi", f = "Anichi.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {169, 174}, m = "search$suspendImpl", n = {"$this", "query", "page", "$this", "query", "encodedQuery", "link", "page"}, nl = {173, 175}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        int I$0;
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
            return Anichi.search$suspendImpl(Anichi.this, null, 0, (Continuation) this);
        }
    }

    @Nullable
    public Object getLoadUrl(@NotNull SyncIdName syncIdName, @NotNull String str, @NotNull Continuation<? super String> continuation) {
        return getLoadUrl$suspendImpl(this, syncIdName, str, continuation);
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
    public Object quickSearch(@NotNull String str, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        return quickSearch$suspendImpl(this, str, continuation);
    }

    @Nullable
    public Object search(@NotNull String str, int i, @NotNull Continuation<? super SearchResponseList> continuation) {
        return search$suspendImpl(this, str, i, continuation);
    }

    public Anichi() {
        String str;
        int i = this.month;
        if (1 <= i && i < 4) {
            str = "Winter";
        } else {
            if (4 <= i && i < 7) {
                str = "Spring";
            } else {
                str = 7 <= i && i < 10 ? "Summer" : "Fall";
            }
        }
        this.season = str;
        this.mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("https://api.allanime.day/api?variables={\"search\":{\"season\":\"" + this.season + "\",\"year\":" + this.year + "},\"limit\":26,\"page\":%d,\"translationType\":\"sub\",\"countryOrigin\":\"ALL\"}&extensions={\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"a24c500a1b765c68ae1d8dd85174931f661c71369c89b92b88b75a725afc471c\"}}", "New Series"), TuplesKt.to("https://api.allanime.day/api?variables={\"search\":{},\"limit\":26,\"page\":%d,\"translationType\":\"sub\",\"countryOrigin\":\"ALL\"}&extensions={\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"a24c500a1b765c68ae1d8dd85174931f661c71369c89b92b88b75a725afc471c\"}}", this.animeRecentTitle), TuplesKt.to("https://api.allanime.day/api?variables={\"search\":{},\"limit\":26,\"page\":%d,\"translationType\":\"sub\",\"countryOrigin\":\"CN\"}&extensions={\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"a24c500a1b765c68ae1d8dd85174931f661c71369c89b92b88b75a725afc471c\"}}", this.donghuaRecentTitle), TuplesKt.to("https://api.allanime.day/api?variables={\"type\":\"anime\",\"size\":30,\"dateRange\":1,\"page\":%d,\"allowAdult\":" + MainAPI.Companion.getSettingsForProvider().getEnableAdult() + ",\"allowUnknown\":false}&extensions={\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"60f50b84bb545fa25ee7f7c8c0adbf8f5cea40f7b1ef8501cbbff70e38589489\"}}", this.popularTitle), TuplesKt.to("https://api.allanime.day/api?variables={\"search\":{\"types\":[\"Movie\"]},\"limit\":26,\"page\":%d,\"translationType\":\"sub\",\"countryOrigin\":\"ALL\"}&extensions={\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"a24c500a1b765c68ae1d8dd85174931f661c71369c89b92b88b75a725afc471c\"}}", this.movieTitle)});
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    public boolean getInstantLinkLoading() {
        return this.instantLinkLoading;
    }

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShowStatus getStatus(String t) {
        if (Intrinsics.areEqual(t, "Finished")) {
            return ShowStatus.Completed;
        }
        return Intrinsics.areEqual(t, "Releasing") ? ShowStatus.Ongoing : ShowStatus.Completed;
    }

    @NotNull
    public Set<SyncIdName> getSupportedSyncNames() {
        return this.supportedSyncNames;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public final Calendar getCalendar() {
        return this.calendar;
    }

    public final int getYear() {
        return this.year;
    }

    public final int getMonth() {
        return this.month;
    }

    @NotNull
    public final String getSeason() {
        return this.season;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getMainPage$suspendImpl(Anichi $this, int page, MainPageRequest request, Continuation<? super HomePageResponse> continuation) {
        C00021 c00021;
        String url;
        MainPageRequest request2;
        Object objFetchQuery;
        AnichiParser.Shows query;
        List card;
        List listEmptyList;
        AnichiParser.AvailableEpisodes availableEpisodes;
        Iterable recommendations;
        Anichi $this2 = $this;
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
        Object $result = c00021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00021.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (StringsKt.contains$default(request.getData(), "%d", false, 2, (Object) null)) {
                    url = String.format(request.getData(), Arrays.copyOf(new Object[]{Boxing.boxInt(page)}, 1));
                    Intrinsics.checkNotNullExpressionValue(url, "format(...)");
                } else {
                    url = request.getData();
                }
                c00021.L$0 = $this2;
                request2 = request;
                c00021.L$1 = request2;
                c00021.L$2 = SpillingKt.nullOutSpilledVariable(url);
                c00021.I$0 = page;
                c00021.label = 1;
                objFetchQuery = $this2.fetchQuery(url, c00021);
                if (objFetchQuery == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00021.I$0;
                request2 = (MainPageRequest) c00021.L$1;
                $this2 = (Anichi) c00021.L$0;
                ResultKt.throwOnFailure($result);
                objFetchQuery = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AnichiParser.AnichiQuery anichiQuery = (AnichiParser.AnichiQuery) objFetchQuery;
        AnichiParser.Data res = anichiQuery != null ? anichiQuery.getData() : null;
        if (res == null || (query = res.getShows()) == null) {
            query = res != null ? res.getQueryPopular() : null;
            if (query == null) {
                query = res != null ? res.getQueryListForTag() : null;
            }
        }
        if (!Intrinsics.areEqual(request2.getName(), $this2.popularTitle)) {
            card = query != null ? query.getEdges() : null;
        } else if (query == null || (recommendations = query.getRecommendations()) == null) {
            card = null;
        } else {
            Iterable $this$map$iv = recommendations;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                destination$iv$iv.add(((AnichiParser.EdgesCard) item$iv$iv).getAnyCard());
            }
            card = (List) destination$iv$iv;
        }
        if (card != null) {
            List $this$filter$iv = card;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                AnichiParser.Edges it = (AnichiParser.Edges) element$iv$iv;
                if (((it != null && (availableEpisodes = it.getAvailableEpisodes()) != null && availableEpisodes.getRaw() == 0) && it.getAvailableEpisodes().getSub() == 0 && it.getAvailableEpisodes().getDub() == 0) ? false : true) {
                    destination$iv$iv2.add(element$iv$iv);
                }
            }
            Iterable $this$mapNotNull$iv = (List) destination$iv$iv2;
            Collection destination$iv$iv3 = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                AnichiParser.Edges media = (AnichiParser.Edges) element$iv$iv$iv;
                AnimeSearchResponse searchResponse = media != null ? $this2.toSearchResponse(media) : null;
                if (searchResponse != null) {
                    destination$iv$iv3.add(searchResponse);
                }
            }
            listEmptyList = (List) destination$iv$iv3;
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        List home = listEmptyList;
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), home, false, 4, (DefaultConstructorMarker) null), Boxing.boxBoolean(!home.isEmpty()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object fetchQuery(String url, Continuation<? super AnichiParser.AnichiQuery> continuation) {
        C00001 c00001;
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
                Object obj = Requests.get$default(app, url, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4092, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result = obj;
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            return parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(AnichiParser.AnichiQuery.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            return null;
        }
    }

    private final String getPosterUrl(String thumbnail) {
        if (thumbnail != null) {
            return StringsKt.startsWith$default(thumbnail, "http", false, 2, (Object) null) ? thumbnail : "https://wp.youtube-anime.com/aln.youtube-anime.com/" + thumbnail;
        }
        return null;
    }

    private final AnimeSearchResponse toSearchResponse(final AnichiParser.Edges $this$toSearchResponse) {
        Anichi anichi = this;
        String englishName = $this$toSearchResponse.getEnglishName();
        if (englishName == null && (englishName = $this$toSearchResponse.getName()) == null && (englishName = $this$toSearchResponse.getNativeName()) == null) {
            englishName = "";
        }
        String id = $this$toSearchResponse.getId();
        if (id == null) {
            return null;
        }
        return MainAPIKt.newAnimeSearchResponse$default(anichi, englishName, id, (TvType) null, false, new Function1() { // from class: com.Anichi.Anichi$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Anichi.toSearchResponse$lambda$0(this.f$0, $this$toSearchResponse, (AnimeSearchResponse) obj);
            }
        }, 4, (Object) null);
    }

    static final Unit toSearchResponse$lambda$0(Anichi this$0, AnichiParser.Edges $this_toSearchResponse, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl(this$0.getPosterUrl($this_toSearchResponse.getThumbnail()));
        AnichiParser.AiredStart airedStart = $this_toSearchResponse.getAiredStart();
        $this$newAnimeSearchResponse.setYear(airedStart != null ? Integer.valueOf(airedStart.getYear()) : null);
        $this$newAnimeSearchResponse.setOtherName($this_toSearchResponse.getEnglishName());
        AnichiParser.AvailableEpisodes availableEpisodes = $this_toSearchResponse.getAvailableEpisodes();
        MainAPIKt.addDub($this$newAnimeSearchResponse, availableEpisodes != null ? Integer.valueOf(availableEpisodes.getDub()) : null);
        AnichiParser.AvailableEpisodes availableEpisodes2 = $this_toSearchResponse.getAvailableEpisodes();
        MainAPIKt.addSub($this$newAnimeSearchResponse, availableEpisodes2 != null ? Integer.valueOf(availableEpisodes2.getSub()) : null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x009d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object quickSearch$suspendImpl(Anichi $this, String query, Continuation<? super List<? extends SearchResponse>> continuation) {
        C00071 c00071;
        Object obj;
        String query2;
        Anichi $this2;
        Object objSearch;
        SearchResponseList searchResponseList;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
            } else {
                c00071 = $this.new C00071(continuation);
            }
        } else {
            c00071 = $this.new C00071(continuation);
        }
        Object $result = c00071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00071.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineContext io = Dispatchers.getIO();
                C00082 c00082 = new C00082(query, null);
                c00071.L$0 = SpillingKt.nullOutSpilledVariable($this);
                c00071.L$1 = SpillingKt.nullOutSpilledVariable(query);
                c00071.L$2 = $this;
                c00071.label = 1;
                Object objWithContext = BuildersKt.withContext(io, c00082, c00071);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objWithContext;
                query2 = query;
                $this2 = $this;
                c00071.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00071.L$1 = SpillingKt.nullOutSpilledVariable(query2);
                c00071.L$2 = null;
                c00071.label = 2;
                objSearch = $this.search((String) obj, 1, c00071);
                if (objSearch == coroutine_suspended) {
                    return coroutine_suspended;
                }
                searchResponseList = (SearchResponseList) objSearch;
                if (searchResponseList != null) {
                    return searchResponseList.getItems();
                }
                return null;
            case 1:
                Anichi anichi = (Anichi) c00071.L$2;
                String query3 = (String) c00071.L$1;
                Anichi $this3 = (Anichi) c00071.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this3;
                $this = anichi;
                query2 = query3;
                obj = $result;
                c00071.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00071.L$1 = SpillingKt.nullOutSpilledVariable(query2);
                c00071.L$2 = null;
                c00071.label = 2;
                objSearch = $this.search((String) obj, 1, c00071);
                if (objSearch == coroutine_suspended) {
                    return coroutine_suspended;
                }
                searchResponseList = (SearchResponseList) objSearch;
                if (searchResponseList != null) {
                    return searchResponseList.getItems();
                }
                return null;
            case 2:
                ResultKt.throwOnFailure($result);
                objSearch = $result;
                searchResponseList = (SearchResponseList) objSearch;
                if (searchResponseList != null) {
                    return searchResponseList.getItems();
                }
                return null;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Anichi.Anichi$quickSearch$2 */
    /* JADX INFO: compiled from: Anichi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.Anichi$quickSearch$2", f = "Anichi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nAnichi.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Anichi.kt\ncom/Anichi/Anichi$quickSearch$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,376:1\n1#2:377\n*E\n"})
    static final class C00082 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $query;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00082(String str, Continuation<? super C00082> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00082(this.$query, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    StringUtils $this$invokeSuspend_u24lambda_u240 = StringUtils.INSTANCE;
                    return $this$invokeSuspend_u24lambda_u240.encodeUrl(this.$query);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x025d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x010a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x010b  */
    /* JADX WARN: Code duplicated, block: B:25:0x012b  */
    /* JADX WARN: Code duplicated, block: B:27:0x012e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x012f  */
    /* JADX WARN: Code duplicated, block: B:42:0x018b  */
    /* JADX WARN: Code duplicated, block: B:51:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:54:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:78:0x0225  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x0229  */
    /* JADX WARN: Code duplicated, block: B:84:0x0242  */
    /* JADX WARN: Code duplicated, block: B:86:0x0258  */
    /* JADX WARN: Code duplicated, block: B:89:0x026f  */
    /* JADX WARN: Code duplicated, block: B:91:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x0192 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static /* synthetic */ Object search$suspendImpl(Anichi $this, String query, int page, Continuation<? super SearchResponseList> continuation) {
        C00091 c00091;
        Object obj;
        String query2;
        int page2;
        int i;
        Anichi $this2;
        String responseText;
        String value$iv;
        Object obj2;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        AnichiParser.AnichiQuery response;
        AnichiParser.Data data;
        Collection destination$iv$iv;
        Collection destination$iv$iv2;
        AnimeSearchResponse searchResponse;
        AnichiParser.Shows shows;
        Iterable edges;
        Anichi $this3 = $this;
        if (continuation instanceof C00091) {
            c00091 = (C00091) continuation;
            if ((c00091.label & Integer.MIN_VALUE) != 0) {
                c00091.label -= Integer.MIN_VALUE;
            } else {
                c00091 = $this3.new C00091(continuation);
            }
        } else {
            c00091 = $this3.new C00091(continuation);
        }
        Object $result = c00091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00091.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineContext io = Dispatchers.getIO();
                Anichi$search$encodedQuery$1 anichi$search$encodedQuery$1 = new Anichi$search$encodedQuery$1(query, null);
                c00091.L$0 = $this3;
                c00091.L$1 = SpillingKt.nullOutSpilledVariable(query);
                c00091.I$0 = page;
                c00091.label = 1;
                Object objWithContext = BuildersKt.withContext(io, anichi$search$encodedQuery$1, c00091);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objWithContext;
                query2 = query;
                page2 = page;
                String encodedQuery = (String) obj;
                String link = "https://api.allanime.day/api?variables={\"search\":{\"query\":\"" + encodedQuery + "\"},\"limit\":26,\"page\":" + page2 + ",\"translationType\":\"sub\",\"countryOrigin\":\"ALL\"}&extensions={\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"a24c500a1b765c68ae1d8dd85174931f661c71369c89b92b88b75a725afc471c\"}}";
                Requests app = MainActivityKt.getApp();
                Map<String, String> map = headers;
                c00091.L$0 = $this3;
                c00091.L$1 = SpillingKt.nullOutSpilledVariable(query2);
                c00091.L$2 = SpillingKt.nullOutSpilledVariable(encodedQuery);
                c00091.L$3 = SpillingKt.nullOutSpilledVariable(link);
                c00091.I$0 = page2;
                c00091.label = 2;
                i = 2;
                $result = Requests.get$default(app, link, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00091, 4092, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this2 = $this3;
                responseText = ((NiceResponse) $result).getText();
                if (StringsKt.contains$default(responseText, "PERSISTED_QUERY_NOT_FOUND", false, i, (Object) null)) {
                    responseText = null;
                }
                if (responseText == null) {
                    return null;
                }
                AppUtils appUtils = AppUtils.INSTANCE;
                value$iv = responseText;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(AnichiParser.AnichiQuery.class);
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
                        obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.AnichiQuery.class), (List) null, i, (Object) null));
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
                        objDecodeFromString = $this$readValue$iv$iv.readValue(value$iv, new TypeReference<AnichiParser.AnichiQuery>() { // from class: com.Anichi.Anichi$search$suspendImpl$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(value$iv, new TypeReference<AnichiParser.AnichiQuery>() { // from class: com.Anichi.Anichi$search$suspendImpl$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(value$iv, new TypeReference<AnichiParser.AnichiQuery>() { // from class: com.Anichi.Anichi$search$suspendImpl$$inlined$parseJson$1
                    });
                }
                response = (AnichiParser.AnichiQuery) objDecodeFromString;
                data = response.getData();
                if (data != null || (shows = data.getShows()) == null || (edges = shows.getEdges()) == null) {
                    destination$iv$iv = null;
                } else {
                    Iterable $this$filter$iv = edges;
                    Collection destination$iv$iv3 = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        AnichiParser.Edges it = (AnichiParser.Edges) element$iv$iv;
                        AnichiParser.AvailableEpisodes availableEpisodes = it.getAvailableEpisodes();
                        if (((availableEpisodes != null && availableEpisodes.getRaw() == 0) && it.getAvailableEpisodes().getSub() == 0 && it.getAvailableEpisodes().getDub() == 0) ? false : true) {
                            destination$iv$iv3.add(element$iv$iv);
                        }
                    }
                    destination$iv$iv = (List) destination$iv$iv3;
                }
                if (destination$iv$iv == null) {
                    return null;
                }
                Collection $this$mapNotNull$iv = destination$iv$iv;
                destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    AnichiParser.AnichiQuery response2 = response;
                    searchResponse = $this2.toSearchResponse((AnichiParser.Edges) element$iv$iv$iv);
                    if (searchResponse != null) {
                        destination$iv$iv2.add(searchResponse);
                    }
                    response = response2;
                }
                return MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv2, (Boolean) null, 1, (Object) null);
            case 1:
                page2 = c00091.I$0;
                String query3 = (String) c00091.L$1;
                $this3 = (Anichi) c00091.L$0;
                ResultKt.throwOnFailure($result);
                query2 = query3;
                obj = $result;
                String encodedQuery2 = (String) obj;
                String link2 = "https://api.allanime.day/api?variables={\"search\":{\"query\":\"" + encodedQuery2 + "\"},\"limit\":26,\"page\":" + page2 + ",\"translationType\":\"sub\",\"countryOrigin\":\"ALL\"}&extensions={\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"a24c500a1b765c68ae1d8dd85174931f661c71369c89b92b88b75a725afc471c\"}}";
                Requests app2 = MainActivityKt.getApp();
                Map<String, String> map2 = headers;
                c00091.L$0 = $this3;
                c00091.L$1 = SpillingKt.nullOutSpilledVariable(query2);
                c00091.L$2 = SpillingKt.nullOutSpilledVariable(encodedQuery2);
                c00091.L$3 = SpillingKt.nullOutSpilledVariable(link2);
                c00091.I$0 = page2;
                c00091.label = 2;
                i = 2;
                $result = Requests.get$default(app2, link2, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00091, 4092, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this2 = $this3;
                responseText = ((NiceResponse) $result).getText();
                if (StringsKt.contains$default(responseText, "PERSISTED_QUERY_NOT_FOUND", false, i, (Object) null)) {
                    responseText = null;
                }
                if (responseText == null) {
                    return null;
                }
                AppUtils appUtils2 = AppUtils.INSTANCE;
                value$iv = responseText;
                Result.Companion companion5 = Result.Companion;
                KType kTypeTypeOf2 = Reflection.typeOf(AnichiParser.AnichiQuery.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                if (Result.exceptionOrNull-impl(obj2) != null) {
                    Result.Companion companion6 = Result.Companion;
                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.AnichiQuery.class), (List) null, i, (Object) null));
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
                    ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv4.readValue(value$iv, new TypeReference<AnichiParser.AnichiQuery>() { // from class: com.Anichi.Anichi$search$suspendImpl$$inlined$parseJson$1
                    });
                }
                response = (AnichiParser.AnichiQuery) objDecodeFromString;
                data = response.getData();
                if (data != null) {
                    destination$iv$iv = null;
                } else {
                    destination$iv$iv = null;
                }
                if (destination$iv$iv == null) {
                    return null;
                }
                Collection $this$mapNotNull$iv2 = destination$iv$iv;
                destination$iv$iv2 = new ArrayList();
                while (r15.hasNext()) {
                    AnichiParser.AnichiQuery response3 = response;
                    searchResponse = $this2.toSearchResponse((AnichiParser.Edges) element$iv$iv$iv);
                    if (searchResponse != null) {
                        destination$iv$iv2.add(searchResponse);
                    }
                    response = response3;
                }
                return MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv2, (Boolean) null, 1, (Object) null);
            case 2:
                int i2 = c00091.I$0;
                Anichi $this4 = (Anichi) c00091.L$0;
                ResultKt.throwOnFailure($result);
                i = 2;
                $this2 = $this4;
                responseText = ((NiceResponse) $result).getText();
                if (StringsKt.contains$default(responseText, "PERSISTED_QUERY_NOT_FOUND", false, i, (Object) null)) {
                    responseText = null;
                }
                if (responseText == null) {
                    return null;
                }
                AppUtils appUtils3 = AppUtils.INSTANCE;
                value$iv = responseText;
                Result.Companion companion7 = Result.Companion;
                KType kTypeTypeOf3 = Reflection.typeOf(AnichiParser.AnichiQuery.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                if (Result.exceptionOrNull-impl(obj2) != null) {
                    Result.Companion companion8 = Result.Companion;
                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.AnichiQuery.class), (List) null, i, (Object) null));
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
                    ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv5.readValue(value$iv, new TypeReference<AnichiParser.AnichiQuery>() { // from class: com.Anichi.Anichi$search$suspendImpl$$inlined$parseJson$1
                    });
                }
                response = (AnichiParser.AnichiQuery) objDecodeFromString;
                data = response.getData();
                if (data != null) {
                    destination$iv$iv = null;
                } else {
                    destination$iv$iv = null;
                }
                if (destination$iv$iv == null) {
                    return null;
                }
                Collection $this$mapNotNull$iv3 = destination$iv$iv;
                destination$iv$iv2 = new ArrayList();
                while (r15.hasNext()) {
                    AnichiParser.AnichiQuery response4 = response;
                    searchResponse = $this2.toSearchResponse((AnichiParser.Edges) element$iv$iv$iv);
                    if (searchResponse != null) {
                        destination$iv$iv2.add(searchResponse);
                    }
                    response = response4;
                }
                return MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv2, (Boolean) null, 1, (Object) null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x015a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x015b  */
    /* JADX WARN: Code duplicated, block: B:34:0x018c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0191  */
    /* JADX WARN: Code duplicated, block: B:38:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:39:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:42:0x01e5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:46:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:51:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:54:0x0204  */
    /* JADX WARN: Code duplicated, block: B:57:0x0211  */
    /* JADX WARN: Code duplicated, block: B:59:0x021f  */
    /* JADX WARN: Code duplicated, block: B:60:0x0224  */
    /* JADX WARN: Code duplicated, block: B:63:0x022d  */
    /* JADX WARN: Code duplicated, block: B:65:0x0233  */
    /* JADX WARN: Code duplicated, block: B:66:0x0238  */
    /* JADX WARN: Code duplicated, block: B:69:0x0240  */
    /* JADX WARN: Code duplicated, block: B:71:0x0246  */
    /* JADX WARN: Code duplicated, block: B:72:0x024b  */
    /* JADX WARN: Code duplicated, block: B:75:0x0253  */
    /* JADX WARN: Code duplicated, block: B:77:0x0259  */
    /* JADX WARN: Code duplicated, block: B:78:0x0262  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x0266  */
    /* JADX WARN: Code duplicated, block: B:81:0x026b  */
    /* JADX WARN: Code duplicated, block: B:84:0x0273  */
    /* JADX WARN: Code duplicated, block: B:85:0x0275  */
    /* JADX WARN: Code duplicated, block: B:92:0x0283  */
    /* JADX WARN: Code duplicated, block: B:98:0x027c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:? A[RETURN, SYNTHETIC] */
    static /* synthetic */ Object getLoadUrl$suspendImpl(Anichi $this, SyncIdName name, String id, Continuation<? super String> continuation) {
        C00011 c00011;
        String syncId;
        SyncIdName name2;
        Object obj;
        String id2;
        String id3;
        String syncId2;
        SyncIdName name3;
        String malId;
        Object obj2;
        Object obj3;
        C00011 c00012;
        Anichi $this2;
        Object obj4;
        SyncIdName name4;
        String id4;
        String id5;
        String syncId3;
        Object safe;
        AnichiParser.JikanResponse jikanResponse;
        AnichiParser.JikanData data;
        AnichiParser.JikanData media;
        String title;
        Object objFetchQuery;
        AnichiParser.AnichiQuery anichiQuery;
        List<AnichiParser.Edges> edges;
        Iterator<T> it;
        Object next;
        AnichiParser.Edges edges2;
        AnichiParser.Edges it2;
        String name5;
        String title2;
        AnichiParser.AiredStart airedStart;
        Integer numBoxInt;
        Integer year;
        boolean z;
        String englishName;
        String title_english;
        String nativeName;
        String title_japanese;
        AnichiParser.Data data2;
        AnichiParser.Shows shows;
        Anichi $this3 = $this;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = $this3.new C00011(continuation);
            }
        } else {
            c00011 = $this3.new C00011(continuation);
        }
        Object $result = c00011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00011.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                syncId = (String) CollectionsKt.last(StringsKt.split$default(id, new String[]{"/"}, false, 0, 6, (Object) null));
                name2 = name;
                if (name2 == SyncIdName.MyAnimeList) {
                    id3 = id;
                    syncId2 = syncId;
                    name3 = name2;
                } else {
                    AnichiUtils anichiUtils = AnichiUtils.INSTANCE;
                    c00011.L$0 = $this3;
                    c00011.L$1 = SpillingKt.nullOutSpilledVariable(name2);
                    c00011.L$2 = SpillingKt.nullOutSpilledVariable(id);
                    c00011.L$3 = SpillingKt.nullOutSpilledVariable(syncId);
                    c00011.label = 1;
                    Object objAniToMal = anichiUtils.aniToMal(syncId, c00011);
                    if (objAniToMal == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objAniToMal;
                    id2 = id;
                    syncId2 = syncId;
                    id3 = id2;
                    syncId = (String) obj;
                    name3 = name2;
                }
                c00011.L$0 = $this3;
                c00011.L$1 = SpillingKt.nullOutSpilledVariable(name3);
                c00011.L$2 = SpillingKt.nullOutSpilledVariable(id3);
                c00011.L$3 = SpillingKt.nullOutSpilledVariable(syncId2);
                c00011.L$4 = SpillingKt.nullOutSpilledVariable(syncId);
                c00011.label = 2;
                malId = syncId;
                C00011 c00013 = c00011;
                obj2 = coroutine_suspended;
                obj3 = Requests.get$default(MainActivityKt.getApp(), "https://api.jikan.moe/v4/anime/" + syncId, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                c00012 = c00013;
                if (obj3 == obj2) {
                    return obj2;
                }
                $this2 = $this3;
                obj4 = obj3;
                name4 = name3;
                id4 = id3;
                id5 = syncId2;
                syncId3 = malId;
                NiceResponse this_$iv = (NiceResponse) obj4;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(AnichiParser.JikanResponse.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                jikanResponse = (AnichiParser.JikanResponse) safe;
                if (jikanResponse != null) {
                    data = jikanResponse.getData();
                } else {
                    data = null;
                }
                media = data;
                StringBuilder sbAppend = new StringBuilder().append("https://api.allanime.day/api?variables={\"search\":{\"allowAdult\":false,\"allowUnknown\":false,\"query\":\"");
                if (media != null) {
                    title = media.getTitle();
                } else {
                    title = null;
                }
                String link = sbAppend.append(title).append("\"},\"limit\":26,\"page\":1,\"translationType\":\"sub\",\"countryOrigin\":\"ALL\"}&extensions={\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"e42a4466d984b2c0a2cecae5dd13aa68867f634b16ee0f17b380047d14482406\"}}").toString();
                c00012.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(name4);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(id4);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(id5);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(syncId3);
                c00012.L$5 = media;
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(link);
                c00012.label = 3;
                objFetchQuery = $this2.fetchQuery(link, c00012);
                if (objFetchQuery == obj2) {
                    return obj2;
                }
                $result = objFetchQuery;
                anichiQuery = (AnichiParser.AnichiQuery) $result;
                if (anichiQuery != null || (data2 = anichiQuery.getData()) == null || (shows = data2.getShows()) == null) {
                    edges = null;
                } else {
                    edges = shows.getEdges();
                }
                if (edges != null) {
                    return null;
                }
                it = edges.iterator();
                do {
                    if (it.hasNext()) {
                        next = it.next();
                        it2 = (AnichiParser.Edges) next;
                        name5 = it2.getName();
                        if (media != null) {
                            title2 = media.getTitle();
                        } else {
                            title2 = null;
                        }
                        if (StringsKt.equals(name5, title2, true)) {
                            airedStart = it2.getAiredStart();
                            if (airedStart != null) {
                                numBoxInt = Boxing.boxInt(airedStart.getYear());
                            } else {
                                numBoxInt = null;
                            }
                            if (media != null) {
                                year = media.getYear();
                            } else {
                                year = null;
                            }
                            if (Intrinsics.areEqual(numBoxInt, year)) {
                                z = true;
                            } else {
                                z = false;
                            }
                        } else {
                            englishName = it2.getEnglishName();
                            if (media != null) {
                                title_english = media.getTitle_english();
                            } else {
                                title_english = null;
                            }
                            if (StringsKt.equals(englishName, title_english, true)) {
                                airedStart = it2.getAiredStart();
                                if (airedStart != null) {
                                    numBoxInt = Boxing.boxInt(airedStart.getYear());
                                } else {
                                    numBoxInt = null;
                                }
                                if (media != null) {
                                    year = media.getYear();
                                } else {
                                    year = null;
                                }
                                if (Intrinsics.areEqual(numBoxInt, year)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            } else {
                                nativeName = it2.getNativeName();
                                if (media != null) {
                                    title_japanese = media.getTitle_japanese();
                                } else {
                                    title_japanese = null;
                                }
                                if (StringsKt.equals(nativeName, title_japanese, true)) {
                                    airedStart = it2.getAiredStart();
                                    if (airedStart != null) {
                                        numBoxInt = Boxing.boxInt(airedStart.getYear());
                                    } else {
                                        numBoxInt = null;
                                    }
                                    if (media != null) {
                                        year = media.getYear();
                                    } else {
                                        year = null;
                                    }
                                    if (Intrinsics.areEqual(numBoxInt, year)) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                } else {
                                    z = false;
                                }
                            }
                        }
                    } else {
                        next = null;
                    }
                    edges2 = (AnichiParser.Edges) next;
                    if (edges2 != null) {
                        return edges2.getId();
                    }
                    return null;
                } while (!z);
                edges2 = (AnichiParser.Edges) next;
                if (edges2 != null) {
                    return edges2.getId();
                }
                return null;
            case 1:
                syncId = (String) c00011.L$3;
                id2 = (String) c00011.L$2;
                name2 = (SyncIdName) c00011.L$1;
                $this3 = (Anichi) c00011.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                syncId2 = syncId;
                id3 = id2;
                syncId = (String) obj;
                name3 = name2;
                c00011.L$0 = $this3;
                c00011.L$1 = SpillingKt.nullOutSpilledVariable(name3);
                c00011.L$2 = SpillingKt.nullOutSpilledVariable(id3);
                c00011.L$3 = SpillingKt.nullOutSpilledVariable(syncId2);
                c00011.L$4 = SpillingKt.nullOutSpilledVariable(syncId);
                c00011.label = 2;
                malId = syncId;
                C00011 c00014 = c00011;
                obj2 = coroutine_suspended;
                obj3 = Requests.get$default(MainActivityKt.getApp(), "https://api.jikan.moe/v4/anime/" + syncId, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00014, 4094, (Object) null);
                c00012 = c00014;
                if (obj3 == obj2) {
                    return obj2;
                }
                $this2 = $this3;
                obj4 = obj3;
                name4 = name3;
                id4 = id3;
                id5 = syncId2;
                syncId3 = malId;
                NiceResponse this_$iv2 = (NiceResponse) obj4;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(AnichiParser.JikanResponse.class));
                jikanResponse = (AnichiParser.JikanResponse) safe;
                if (jikanResponse != null) {
                    data = jikanResponse.getData();
                } else {
                    data = null;
                }
                media = data;
                StringBuilder sbAppend2 = new StringBuilder().append("https://api.allanime.day/api?variables={\"search\":{\"allowAdult\":false,\"allowUnknown\":false,\"query\":\"");
                if (media != null) {
                    title = media.getTitle();
                } else {
                    title = null;
                }
                String link2 = sbAppend2.append(title).append("\"},\"limit\":26,\"page\":1,\"translationType\":\"sub\",\"countryOrigin\":\"ALL\"}&extensions={\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"e42a4466d984b2c0a2cecae5dd13aa68867f634b16ee0f17b380047d14482406\"}}").toString();
                c00012.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(name4);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(id4);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(id5);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(syncId3);
                c00012.L$5 = media;
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(link2);
                c00012.label = 3;
                objFetchQuery = $this2.fetchQuery(link2, c00012);
                if (objFetchQuery == obj2) {
                    return obj2;
                }
                $result = objFetchQuery;
                anichiQuery = (AnichiParser.AnichiQuery) $result;
                if (anichiQuery != null) {
                    edges = null;
                } else {
                    edges = null;
                }
                if (edges != null) {
                    return null;
                }
                it = edges.iterator();
                do {
                    if (it.hasNext()) {
                        next = it.next();
                        it2 = (AnichiParser.Edges) next;
                        name5 = it2.getName();
                        if (media != null) {
                            title2 = media.getTitle();
                        } else {
                            title2 = null;
                        }
                        if (StringsKt.equals(name5, title2, true)) {
                            englishName = it2.getEnglishName();
                            if (media != null) {
                                title_english = media.getTitle_english();
                            } else {
                                title_english = null;
                            }
                            if (StringsKt.equals(englishName, title_english, true)) {
                                nativeName = it2.getNativeName();
                                if (media != null) {
                                    title_japanese = media.getTitle_japanese();
                                } else {
                                    title_japanese = null;
                                }
                                if (StringsKt.equals(nativeName, title_japanese, true)) {
                                    airedStart = it2.getAiredStart();
                                    if (airedStart != null) {
                                        numBoxInt = Boxing.boxInt(airedStart.getYear());
                                    } else {
                                        numBoxInt = null;
                                    }
                                    if (media != null) {
                                        year = media.getYear();
                                    } else {
                                        year = null;
                                    }
                                    if (Intrinsics.areEqual(numBoxInt, year)) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                } else {
                                    z = false;
                                }
                            } else {
                                airedStart = it2.getAiredStart();
                                if (airedStart != null) {
                                    numBoxInt = Boxing.boxInt(airedStart.getYear());
                                } else {
                                    numBoxInt = null;
                                }
                                if (media != null) {
                                    year = media.getYear();
                                } else {
                                    year = null;
                                }
                                if (Intrinsics.areEqual(numBoxInt, year)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            }
                        } else {
                            airedStart = it2.getAiredStart();
                            if (airedStart != null) {
                                numBoxInt = Boxing.boxInt(airedStart.getYear());
                            } else {
                                numBoxInt = null;
                            }
                            if (media != null) {
                                year = media.getYear();
                            } else {
                                year = null;
                            }
                            if (Intrinsics.areEqual(numBoxInt, year)) {
                                z = true;
                            } else {
                                z = false;
                            }
                        }
                    } else {
                        next = null;
                    }
                    edges2 = (AnichiParser.Edges) next;
                    if (edges2 != null) {
                        return edges2.getId();
                    }
                    return null;
                } while (!z);
                edges2 = (AnichiParser.Edges) next;
                if (edges2 != null) {
                    return edges2.getId();
                }
                return null;
            case 2:
                String malId2 = (String) c00011.L$4;
                String syncId4 = (String) c00011.L$3;
                String id6 = (String) c00011.L$2;
                SyncIdName name6 = (SyncIdName) c00011.L$1;
                Anichi $this4 = (Anichi) c00011.L$0;
                ResultKt.throwOnFailure($result);
                c00012 = c00011;
                obj2 = coroutine_suspended;
                name4 = name6;
                $this2 = $this4;
                obj4 = $result;
                id4 = id6;
                id5 = syncId4;
                syncId3 = malId2;
                NiceResponse this_$iv3 = (NiceResponse) obj4;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(AnichiParser.JikanResponse.class));
                jikanResponse = (AnichiParser.JikanResponse) safe;
                if (jikanResponse != null) {
                    data = jikanResponse.getData();
                } else {
                    data = null;
                }
                media = data;
                StringBuilder sbAppend3 = new StringBuilder().append("https://api.allanime.day/api?variables={\"search\":{\"allowAdult\":false,\"allowUnknown\":false,\"query\":\"");
                if (media != null) {
                    title = media.getTitle();
                } else {
                    title = null;
                }
                String link3 = sbAppend3.append(title).append("\"},\"limit\":26,\"page\":1,\"translationType\":\"sub\",\"countryOrigin\":\"ALL\"}&extensions={\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"e42a4466d984b2c0a2cecae5dd13aa68867f634b16ee0f17b380047d14482406\"}}").toString();
                c00012.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(name4);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(id4);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(id5);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(syncId3);
                c00012.L$5 = media;
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(link3);
                c00012.label = 3;
                objFetchQuery = $this2.fetchQuery(link3, c00012);
                if (objFetchQuery == obj2) {
                    return obj2;
                }
                $result = objFetchQuery;
                anichiQuery = (AnichiParser.AnichiQuery) $result;
                if (anichiQuery != null) {
                    edges = null;
                } else {
                    edges = null;
                }
                if (edges != null) {
                    return null;
                }
                it = edges.iterator();
                do {
                    if (it.hasNext()) {
                        next = it.next();
                        it2 = (AnichiParser.Edges) next;
                        name5 = it2.getName();
                        if (media != null) {
                            title2 = media.getTitle();
                        } else {
                            title2 = null;
                        }
                        if (StringsKt.equals(name5, title2, true)) {
                            englishName = it2.getEnglishName();
                            if (media != null) {
                                title_english = media.getTitle_english();
                            } else {
                                title_english = null;
                            }
                            if (StringsKt.equals(englishName, title_english, true)) {
                                nativeName = it2.getNativeName();
                                if (media != null) {
                                    title_japanese = media.getTitle_japanese();
                                } else {
                                    title_japanese = null;
                                }
                                if (StringsKt.equals(nativeName, title_japanese, true)) {
                                    airedStart = it2.getAiredStart();
                                    if (airedStart != null) {
                                        numBoxInt = Boxing.boxInt(airedStart.getYear());
                                    } else {
                                        numBoxInt = null;
                                    }
                                    if (media != null) {
                                        year = media.getYear();
                                    } else {
                                        year = null;
                                    }
                                    if (Intrinsics.areEqual(numBoxInt, year)) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                } else {
                                    z = false;
                                }
                            } else {
                                airedStart = it2.getAiredStart();
                                if (airedStart != null) {
                                    numBoxInt = Boxing.boxInt(airedStart.getYear());
                                } else {
                                    numBoxInt = null;
                                }
                                if (media != null) {
                                    year = media.getYear();
                                } else {
                                    year = null;
                                }
                                if (Intrinsics.areEqual(numBoxInt, year)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            }
                        } else {
                            airedStart = it2.getAiredStart();
                            if (airedStart != null) {
                                numBoxInt = Boxing.boxInt(airedStart.getYear());
                            } else {
                                numBoxInt = null;
                            }
                            if (media != null) {
                                year = media.getYear();
                            } else {
                                year = null;
                            }
                            if (Intrinsics.areEqual(numBoxInt, year)) {
                                z = true;
                            } else {
                                z = false;
                            }
                        }
                    } else {
                        next = null;
                    }
                    edges2 = (AnichiParser.Edges) next;
                    if (edges2 != null) {
                        return edges2.getId();
                    }
                    return null;
                } while (!z);
                edges2 = (AnichiParser.Edges) next;
                if (edges2 != null) {
                    return edges2.getId();
                }
                return null;
            case 3:
                media = (AnichiParser.JikanData) c00011.L$5;
                ResultKt.throwOnFailure($result);
                anichiQuery = (AnichiParser.AnichiQuery) $result;
                if (anichiQuery != null) {
                    edges = null;
                } else {
                    edges = null;
                }
                if (edges != null) {
                    return null;
                }
                it = edges.iterator();
                do {
                    if (it.hasNext()) {
                        next = it.next();
                        it2 = (AnichiParser.Edges) next;
                        name5 = it2.getName();
                        if (media != null) {
                            title2 = media.getTitle();
                        } else {
                            title2 = null;
                        }
                        if (StringsKt.equals(name5, title2, true)) {
                            englishName = it2.getEnglishName();
                            if (media != null) {
                                title_english = media.getTitle_english();
                            } else {
                                title_english = null;
                            }
                            if (StringsKt.equals(englishName, title_english, true)) {
                                nativeName = it2.getNativeName();
                                if (media != null) {
                                    title_japanese = media.getTitle_japanese();
                                } else {
                                    title_japanese = null;
                                }
                                if (StringsKt.equals(nativeName, title_japanese, true)) {
                                    airedStart = it2.getAiredStart();
                                    if (airedStart != null) {
                                        numBoxInt = Boxing.boxInt(airedStart.getYear());
                                    } else {
                                        numBoxInt = null;
                                    }
                                    if (media != null) {
                                        year = media.getYear();
                                    } else {
                                        year = null;
                                    }
                                    if (Intrinsics.areEqual(numBoxInt, year)) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                } else {
                                    z = false;
                                }
                            } else {
                                airedStart = it2.getAiredStart();
                                if (airedStart != null) {
                                    numBoxInt = Boxing.boxInt(airedStart.getYear());
                                } else {
                                    numBoxInt = null;
                                }
                                if (media != null) {
                                    year = media.getYear();
                                } else {
                                    year = null;
                                }
                                if (Intrinsics.areEqual(numBoxInt, year)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            }
                        } else {
                            airedStart = it2.getAiredStart();
                            if (airedStart != null) {
                                numBoxInt = Boxing.boxInt(airedStart.getYear());
                            } else {
                                numBoxInt = null;
                            }
                            if (media != null) {
                                year = media.getYear();
                            } else {
                                year = null;
                            }
                            if (Intrinsics.areEqual(numBoxInt, year)) {
                                z = true;
                            } else {
                                z = false;
                            }
                        }
                    } else {
                        next = null;
                    }
                    edges2 = (AnichiParser.Edges) next;
                    if (edges2 != null) {
                        return edges2.getId();
                    }
                    return null;
                } while (!z);
                edges2 = (AnichiParser.Edges) next;
                if (edges2 != null) {
                    return edges2.getId();
                }
                return null;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:101:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:104:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:106:0x040b  */
    /* JADX WARN: Code duplicated, block: B:107:0x040d  */
    /* JADX WARN: Code duplicated, block: B:110:0x0414  */
    /* JADX WARN: Code duplicated, block: B:111:0x0417  */
    /* JADX WARN: Code duplicated, block: B:113:0x041b  */
    /* JADX WARN: Code duplicated, block: B:118:0x042c  */
    /* JADX WARN: Code duplicated, block: B:121:0x048a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:122:0x048b  */
    /* JADX WARN: Code duplicated, block: B:125:0x04af  */
    /* JADX WARN: Code duplicated, block: B:126:0x04da  */
    /* JADX WARN: Code duplicated, block: B:129:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:130:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:133:0x050b  */
    /* JADX WARN: Code duplicated, block: B:136:0x0528  */
    /* JADX WARN: Code duplicated, block: B:138:0x053a  */
    /* JADX WARN: Code duplicated, block: B:141:0x0542  */
    /* JADX WARN: Code duplicated, block: B:144:0x054d  */
    /* JADX WARN: Code duplicated, block: B:145:0x0550  */
    /* JADX WARN: Code duplicated, block: B:148:0x055b  */
    /* JADX WARN: Code duplicated, block: B:149:0x055e  */
    /* JADX WARN: Code duplicated, block: B:151:0x0568  */
    /* JADX WARN: Code duplicated, block: B:152:0x056b  */
    /* JADX WARN: Code duplicated, block: B:153:0x056d A[PHI: r45
      0x056d: PHI (r45v11 'title' java.lang.String) = 
      (r45v10 'title' java.lang.String)
      (r45v13 'title' java.lang.String)
      (r45v14 'title' java.lang.String)
      (r45v15 'title' java.lang.String)
     binds: [B:152:0x056b, B:150:0x0566, B:146:0x0558, B:142:0x054a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:156:0x0576  */
    /* JADX WARN: Code duplicated, block: B:158:0x057c  */
    /* JADX WARN: Code duplicated, block: B:160:0x0582  */
    /* JADX WARN: Code duplicated, block: B:161:0x0587  */
    /* JADX WARN: Code duplicated, block: B:163:0x058a  */
    /* JADX WARN: Code duplicated, block: B:166:0x0591  */
    /* JADX WARN: Code duplicated, block: B:168:0x0597  */
    /* JADX WARN: Code duplicated, block: B:170:0x059d  */
    /* JADX WARN: Code duplicated, block: B:171:0x05a2  */
    /* JADX WARN: Code duplicated, block: B:174:0x05d7  */
    /* JADX WARN: Code duplicated, block: B:177:0x05e8  */
    /* JADX WARN: Code duplicated, block: B:181:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:182:0x05fc  */
    /* JADX WARN: Code duplicated, block: B:185:0x0604 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:186:0x0606  */
    /* JADX WARN: Code duplicated, block: B:187:0x0608  */
    /* JADX WARN: Code duplicated, block: B:188:0x060b  */
    /* JADX WARN: Code duplicated, block: B:191:0x06c5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:192:0x06c6  */
    /* JADX WARN: Code duplicated, block: B:51:0x0327 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x0328  */
    /* JADX WARN: Code duplicated, block: B:55:0x0343  */
    /* JADX WARN: Code duplicated, block: B:69:0x0392 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:73:0x0398  */
    /* JADX WARN: Code duplicated, block: B:77:0x03a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:83:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:84:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:87:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:89:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:90:0x03d7 A[PHI: r8
      0x03d7: PHI (r8v31 java.lang.String) = (r8v30 java.lang.String), (r8v33 java.lang.String) binds: [B:82:0x03bb, B:88:0x03d0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:92:0x03da A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:94:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:96:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:97:0x03e6  */
    static /* synthetic */ Object load$suspendImpl(Anichi $this, String url, Continuation<? super LoadResponse> continuation) {
        C00031 c00031;
        RequestBody body;
        Object obj;
        Object objPost$default;
        String url2;
        String id;
        Anichi $this2;
        NiceResponse res;
        Object safe;
        AnichiParser.Detail detail;
        AnichiParser.DetailShow data;
        String title;
        String description;
        Object tracker;
        AnichiParser.Edges showData;
        Anichi $this3;
        String id2;
        NiceResponse res2;
        AnichiParser.AniMedia trackers;
        Object objCoroutineScope;
        String id3;
        RequestBody body2;
        String title2;
        AnichiParser.Edges showData2;
        String id4;
        NiceResponse res3;
        AnilistAPIResponse.anilistMedia data2;
        MetaAnimeData animeMetadata;
        String fanart;
        String str;
        String engtitle;
        Map<String, String> titles;
        Map<String, String> titles2;
        String backgroundposter;
        String type;
        String fanart2;
        NiceResponse res4;
        boolean z;
        TvType logotvType;
        Integer tmdbid;
        AnichiParser.AniMedia trackers2;
        String description2;
        String backgroundposter2;
        TvType logotvType2;
        String engtitle2;
        Integer tmdbid2;
        C00031 c00032;
        Object objFetchTmdbLogoUrl;
        NiceResponse res5;
        Anichi $this4;
        String id5;
        MetaAnimeData animeMetadata2;
        Object $result;
        String id6;
        AnichiParser.Edges showData3;
        AnichiParser.AniMedia trackers3;
        AnilistAPIResponse.anilistMedia data3;
        String description3;
        String fanart3;
        TvType logotvType3;
        String backgroundposter3;
        MetaMappings mappings;
        String themoviedbId;
        AnichiParser.CoverImage coverImage;
        Map<String, String> titles3;
        Iterable images;
        Object obj2;
        String poster;
        AnichiParser.AvailableEpisodesDetail detail2;
        Pair pair;
        Pair episodes;
        Pair pair2;
        Iterable characters;
        String fanart4;
        String title3;
        Object tmdbid3;
        String poster2;
        List characters2;
        String type2;
        TvType tvType;
        String str2;
        Object objNewAnimeLoadResponse$default;
        Iterable $this$map$iv;
        Collection destination$iv$iv;
        AnichiParser.Characters it;
        String fanart5;
        String title4;
        ActorRole role;
        AnichiParser.CharacterName name;
        AnichiParser.CharacterName name2;
        String name3;
        AnichiParser.CharacterImage image;
        AnichiParser.CharacterImage image2;
        String medium;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = $this.new C00031(continuation);
            }
        } else {
            c00031 = $this.new C00031(continuation);
        }
        C00031 c00033 = c00031;
        Object $result2 = c00033.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = false;
        switch (c00033.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                String id7 = StringsKt.substringAfterLast$default(url, "/", (String) null, 2, (Object) null);
                body = RequestBody.Companion.create(StringsKt.trim(StringsKt.trimIndent("\n        {\n            \"query\": \"                        query(\\n                      $_id: String!\\n                    ) {\\n                      show(\\n                        _id: $_id\\n                      ) {\\n                          _id\\n                          name\\n                          description\\n                          thumbnail\\n                          thumbnails\\n                          lastEpisodeInfo\\n                          lastEpisodeDate       \\n                          type\\n                          genres\\n                          score\\n                          status\\n                          season\\n                          altNames  \\n                          averageScore\\n                          rating\\n                          episodeCount\\n                          episodeDuration\\n                          broadcastInterval\\n                          banner\\n                          airedEnd\\n                          airedStart \\n                          studios\\n                          characters\\n                          availableEpisodesDetail\\n                          availableEpisodes\\n                          prevideos\\n                          nameOnlyString\\n                          relatedShows\\n                          relatedMangas\\n                          musics\\n                          isAdult\\n                          \\n                          tags\\n                          countryOfOrigin\\n\\n                          pageStatus{\\n                            _id\\n                            notes\\n                            pageId\\n                            showId\\n                            \\n                              # ranks:[Object]\\n    views\\n    likesCount\\n    commentCount\\n    dislikesCount\\n    reviewCount\\n    userScoreCount\\n    userScoreTotalValue\\n    userScoreAverValue\\n    viewers{\\n        firstViewers{\\n          viewCount\\n          lastWatchedDate\\n        user{\\n          _id\\n          displayName\\n          picture\\n          # description\\n          hideMe\\n          # createdAt\\n          # badges\\n          brief\\n        }\\n      \\n      }\\n      recViewers{\\n        viewCount\\n          lastWatchedDate\\n        user{\\n          _id\\n          displayName\\n          picture\\n          # description\\n          hideMe\\n          # createdAt\\n          # badges\\n          brief\\n        }\\n      \\n      }\\n      }\\n\\n                        }\\n                      }\\n                    }\",\n            \"extensions\": \"{\\\"persistedQuery\\\":{\\\"version\\\":1,\\\"sha256Hash\\\":\\\"bb263f91e5bdd048c1c978f324613aeccdfe2cbc694a419466a31edb58c0cc0b\\\"}}\",\n            \"variables\": \"{\\\"_id\\\":\\\"" + id7 + "\\\"}\"\n        }\n    ")).toString(), MediaType.Companion.parse("application/json;charset=utf-8"));
                Requests app = MainActivityKt.getApp();
                Map<String, String> map = headers;
                c00033.L$0 = $this;
                c00033.L$1 = url;
                c00033.L$2 = id7;
                c00033.L$3 = SpillingKt.nullOutSpilledVariable(body);
                c00033.label = 1;
                obj = coroutine_suspended;
                objPost$default = Requests.post$default(app, apiUrl, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, body, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00033, 65276, (Object) null);
                c00033 = c00033;
                if (objPost$default == obj) {
                    return obj;
                }
                url2 = url;
                id = id7;
                $this2 = $this;
                res = (NiceResponse) objPost$default;
                try {
                    ResponseParser parser = res.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(res.getText(), Reflection.getOrCreateKotlinClass(AnichiParser.Detail.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                detail = (AnichiParser.Detail) safe;
                if (detail != null || (data = detail.getData()) == null) {
                    return null;
                }
                AnichiParser.Edges showData4 = data.getShow();
                if (showData4 == null) {
                    return null;
                }
                title = showData4.getName();
                String description4 = showData4.getDescription();
                AnichiUtils anichiUtils = AnichiUtils.INSTANCE;
                List<String> altNames = showData4.getAltNames();
                String str3 = altNames != null ? (String) CollectionsKt.firstOrNull(altNames) : null;
                AnichiParser.AiredStart airedStart = showData4.getAiredStart();
                Integer numBoxInt = airedStart != null ? Boxing.boxInt(airedStart.getYear()) : null;
                AnichiParser.Season season = showData4.getSeason();
                String quarter = season != null ? season.getQuarter() : null;
                String type3 = showData4.getType();
                c00033.L$0 = $this2;
                c00033.L$1 = url2;
                c00033.L$2 = id;
                c00033.L$3 = SpillingKt.nullOutSpilledVariable(body);
                c00033.L$4 = SpillingKt.nullOutSpilledVariable(res);
                c00033.L$5 = showData4;
                c00033.L$6 = title;
                c00033.L$7 = description4;
                c00033.label = 2;
                description = description4;
                tracker = anichiUtils.getTracker(title, str3, numBoxInt, quarter, type3, c00033);
                if (tracker == obj) {
                    return obj;
                }
                showData = showData4;
                $this3 = $this2;
                id2 = id;
                res2 = res;
                trackers = (AnichiParser.AniMedia) tracker;
                C00042 c00042 = new C00042(trackers, null);
                c00033.L$0 = $this3;
                c00033.L$1 = url2;
                c00033.L$2 = id2;
                c00033.L$3 = SpillingKt.nullOutSpilledVariable(body);
                c00033.L$4 = SpillingKt.nullOutSpilledVariable(res2);
                c00033.L$5 = showData;
                c00033.L$6 = title;
                c00033.L$7 = description;
                c00033.L$8 = trackers;
                c00033.label = 3;
                objCoroutineScope = CoroutineScopeKt.coroutineScope(c00042, c00033);
                if (objCoroutineScope == obj) {
                    return obj;
                }
                id3 = title;
                body2 = body;
                title2 = description;
                showData2 = showData;
                id4 = id2;
                res3 = res2;
                Pair pair3 = (Pair) objCoroutineScope;
                data2 = (AnilistAPIResponse.anilistMedia) pair3.component1();
                animeMetadata = (MetaAnimeData) pair3.component2();
                if (animeMetadata == null && (images = animeMetadata.getImages()) != null) {
                    Iterable $this$firstOrNull$iv = images;
                    int $i$f$firstOrNull = 0;
                    Iterator it2 = $this$firstOrNull$iv.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Object element$iv = it2.next();
                            Object $result3 = $result2;
                            Iterable $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                            int $i$f$firstOrNull2 = $i$f$firstOrNull;
                            if (StringsKt.equals(((Image) element$iv).getCoverType(), "Fanart", true)) {
                                obj2 = element$iv;
                            } else {
                                $this$firstOrNull$iv = $this$firstOrNull$iv2;
                                $i$f$firstOrNull = $i$f$firstOrNull2;
                                $result2 = $result3;
                            }
                        } else {
                            obj2 = null;
                        }
                    }
                    Image image3 = (Image) obj2;
                    String url3 = image3 != null ? image3.getUrl() : null;
                    fanart = url3;
                    if (animeMetadata != null || (titles3 = animeMetadata.getTitles()) == null || (engtitle = titles3.get("en")) == null) {
                        if (animeMetadata != null || (titles2 = animeMetadata.getTitles()) == null) {
                            str = null;
                        } else {
                            str = titles2.get("x-jat");
                        }
                        if (str != null) {
                            engtitle = str;
                        } else {
                            if (animeMetadata != null || (titles = animeMetadata.getTitles()) == null) {
                                str = null;
                            } else {
                                str = titles.get("ja");
                            }
                            if (str == null) {
                                engtitle = showData2.getEnglishName();
                            } else {
                                engtitle = str;
                            }
                        }
                    }
                    if (fanart == null) {
                        if (data2 != null) {
                            backgroundposter = data2.getBannerImage();
                        } else {
                            backgroundposter = null;
                        }
                        if (backgroundposter == null) {
                            if (trackers != null || (coverImage = trackers.getCoverImage()) == null) {
                                backgroundposter = null;
                            } else {
                                backgroundposter = coverImage.getLarge();
                            }
                        }
                    } else {
                        backgroundposter = fanart;
                    }
                    type = showData2.getType();
                    if (type != null) {
                        fanart2 = fanart;
                        res4 = res3;
                        z = StringsKt.contains(type, "movie", true);
                        if (z) {
                            logotvType = TvType.AnimeMovie;
                        } else {
                            logotvType = TvType.Anime;
                        }
                        if (animeMetadata != null || (mappings = animeMetadata.getMappings()) == null || (themoviedbId = mappings.getThemoviedbId()) == null) {
                            tmdbid = null;
                        } else {
                            tmdbid = StringsKt.toIntOrNull(themoviedbId);
                        }
                        c00033.L$0 = $this3;
                        c00033.L$1 = url2;
                        c00033.L$2 = id4;
                        c00033.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                        c00033.L$4 = SpillingKt.nullOutSpilledVariable(res4);
                        c00033.L$5 = showData2;
                        c00033.L$6 = id3;
                        c00033.L$7 = title2;
                        c00033.L$8 = trackers;
                        c00033.L$9 = SpillingKt.nullOutSpilledVariable(data2);
                        c00033.L$10 = animeMetadata;
                        c00033.L$11 = SpillingKt.nullOutSpilledVariable(fanart2);
                        c00033.L$12 = engtitle;
                        c00033.L$13 = backgroundposter;
                        c00033.L$14 = SpillingKt.nullOutSpilledVariable(logotvType);
                        c00033.L$15 = SpillingKt.nullOutSpilledVariable(tmdbid);
                        c00033.label = 4;
                        trackers2 = trackers;
                        description2 = title2;
                        backgroundposter2 = backgroundposter;
                        logotvType2 = logotvType;
                        C00031 c00034 = c00033;
                        engtitle2 = engtitle;
                        tmdbid2 = tmdbid;
                        c00032 = c00034;
                        objFetchTmdbLogoUrl = AnichiUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", logotvType2, tmdbid2, "en", c00032);
                        if (objFetchTmdbLogoUrl == obj) {
                            return obj;
                        }
                        res5 = res4;
                        $this4 = $this3;
                        id5 = id4;
                        animeMetadata2 = animeMetadata;
                        $result = tmdbid2;
                        id6 = id3;
                        showData3 = showData2;
                        trackers3 = trackers2;
                        data3 = data2;
                        description3 = description2;
                        fanart3 = fanart2;
                        logotvType3 = logotvType2;
                        backgroundposter3 = url2;
                        String logoUrl = (String) objFetchTmdbLogoUrl;
                        poster = showData3.getThumbnail();
                        detail2 = showData3.getAvailableEpisodesDetail();
                        if (detail2 != null) {
                            pair = new Pair(CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getSub(), "sub")), CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getDub(), "dub")));
                        } else {
                            pair = null;
                        }
                        episodes = pair;
                        if (episodes == null) {
                            pair2 = new Pair(CollectionsKt.emptyList(), CollectionsKt.emptyList());
                        } else {
                            pair2 = episodes;
                        }
                        List subEpisodes = (List) pair2.component1();
                        List dubEpisodes = (List) pair2.component2();
                        characters = showData3.getCharacters();
                        if (characters != null) {
                            $this$map$iv = characters;
                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                it = (AnichiParser.Characters) item$iv$iv;
                                String fanart6 = fanart3;
                                fanart5 = it.getRole();
                                if (fanart5 != null) {
                                    switch (fanart5.hashCode()) {
                                        case 2390489:
                                            title4 = id6;
                                            if (fanart5.equals("Main")) {
                                                role = ActorRole.Main;
                                            } else {
                                                role = null;
                                            }
                                            break;
                                        case 661270862:
                                            title4 = id6;
                                            if (fanart5.equals("Background")) {
                                                role = ActorRole.Background;
                                            } else {
                                                role = null;
                                            }
                                            break;
                                        case 1379577299:
                                            title4 = id6;
                                            if (fanart5.equals("Supporting")) {
                                                role = ActorRole.Supporting;
                                            } else {
                                                role = null;
                                            }
                                            break;
                                        default:
                                            title4 = id6;
                                            role = null;
                                            break;
                                    }
                                } else {
                                    title4 = id6;
                                    role = null;
                                }
                                name = it.getName();
                                if (name != null || (name3 = name.getFull()) == null) {
                                    name2 = it.getName();
                                    if (name2 != null) {
                                        name3 = name2.getNative();
                                    } else {
                                        name3 = null;
                                    }
                                    if (name3 == null) {
                                        name3 = "";
                                    }
                                }
                                image = it.getImage();
                                if (image != null || (medium = image.getLarge()) == null) {
                                    image2 = it.getImage();
                                    if (image2 != null) {
                                        medium = image2.getMedium();
                                    } else {
                                        medium = null;
                                    }
                                }
                                String image4 = medium;
                                Object tmdbid4 = $result;
                                destination$iv$iv.add(new Pair(new Actor(name3, image4), role));
                                fanart3 = fanart6;
                                id6 = title4;
                                poster = poster;
                                $this$map$iv = $this$map$iv;
                                $result = tmdbid4;
                            }
                            fanart4 = fanart3;
                            title3 = id6;
                            tmdbid3 = $result;
                            poster2 = poster;
                            characters2 = (List) destination$iv$iv;
                        } else {
                            fanart4 = fanart3;
                            title3 = id6;
                            tmdbid3 = $result;
                            poster2 = poster;
                            characters2 = null;
                        }
                        type2 = showData3.getType();
                        if (type2 != null && StringsKt.contains(type2, "movie", true)) {
                            z2 = true;
                        }
                        if (z2) {
                            tvType = TvType.AnimeMovie;
                        } else {
                            tvType = TvType.Anime;
                        }
                        Anichi anichi = $this4;
                        if (engtitle2 != null) {
                            str2 = engtitle2;
                        } else if (title3 == null) {
                            str2 = "";
                        } else {
                            str2 = title3;
                        }
                        Anichi $this5 = $this4;
                        String engtitle3 = engtitle2;
                        AnichiParser.AniMedia trackers4 = trackers3;
                        String poster3 = poster2;
                        AnichiParser.Edges showData5 = showData3;
                        C00053 c00053 = new C00053(engtitle3, poster3, trackers4, backgroundposter2, showData5, subEpisodes, dubEpisodes, characters2, $this5, description3, null);
                        c00032.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(id5);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(res5);
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(showData5);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(description3);
                        c00032.L$8 = SpillingKt.nullOutSpilledVariable(trackers4);
                        c00032.L$9 = SpillingKt.nullOutSpilledVariable(data3);
                        c00032.L$10 = SpillingKt.nullOutSpilledVariable(animeMetadata2);
                        c00032.L$11 = SpillingKt.nullOutSpilledVariable(fanart4);
                        c00032.L$12 = SpillingKt.nullOutSpilledVariable(engtitle3);
                        c00032.L$13 = SpillingKt.nullOutSpilledVariable(backgroundposter2);
                        c00032.L$14 = SpillingKt.nullOutSpilledVariable(logotvType3);
                        c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                        c00032.L$16 = SpillingKt.nullOutSpilledVariable(logoUrl);
                        c00032.L$17 = SpillingKt.nullOutSpilledVariable(poster3);
                        c00032.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                        c00032.L$19 = SpillingKt.nullOutSpilledVariable(subEpisodes);
                        c00032.L$20 = SpillingKt.nullOutSpilledVariable(dubEpisodes);
                        c00032.L$21 = SpillingKt.nullOutSpilledVariable(characters2);
                        c00032.L$22 = SpillingKt.nullOutSpilledVariable(tvType);
                        c00032.label = 5;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anichi, str2, backgroundposter3, tvType, false, c00053, c00032, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == obj) {
                            return obj;
                        }
                        return objNewAnimeLoadResponse$default;
                    }
                    fanart2 = fanart;
                    res4 = res3;
                    if (z) {
                        logotvType = TvType.AnimeMovie;
                    } else {
                        logotvType = TvType.Anime;
                    }
                    if (animeMetadata != null) {
                        tmdbid = null;
                    } else {
                        tmdbid = null;
                    }
                    c00033.L$0 = $this3;
                    c00033.L$1 = url2;
                    c00033.L$2 = id4;
                    c00033.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                    c00033.L$4 = SpillingKt.nullOutSpilledVariable(res4);
                    c00033.L$5 = showData2;
                    c00033.L$6 = id3;
                    c00033.L$7 = title2;
                    c00033.L$8 = trackers;
                    c00033.L$9 = SpillingKt.nullOutSpilledVariable(data2);
                    c00033.L$10 = animeMetadata;
                    c00033.L$11 = SpillingKt.nullOutSpilledVariable(fanart2);
                    c00033.L$12 = engtitle;
                    c00033.L$13 = backgroundposter;
                    c00033.L$14 = SpillingKt.nullOutSpilledVariable(logotvType);
                    c00033.L$15 = SpillingKt.nullOutSpilledVariable(tmdbid);
                    c00033.label = 4;
                    trackers2 = trackers;
                    description2 = title2;
                    backgroundposter2 = backgroundposter;
                    logotvType2 = logotvType;
                    C00031 c00035 = c00033;
                    engtitle2 = engtitle;
                    tmdbid2 = tmdbid;
                    c00032 = c00035;
                    objFetchTmdbLogoUrl = AnichiUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", logotvType2, tmdbid2, "en", c00032);
                    if (objFetchTmdbLogoUrl == obj) {
                        return obj;
                    }
                    res5 = res4;
                    $this4 = $this3;
                    id5 = id4;
                    animeMetadata2 = animeMetadata;
                    $result = tmdbid2;
                    id6 = id3;
                    showData3 = showData2;
                    trackers3 = trackers2;
                    data3 = data2;
                    description3 = description2;
                    fanart3 = fanart2;
                    logotvType3 = logotvType2;
                    backgroundposter3 = url2;
                    String logoUrl2 = (String) objFetchTmdbLogoUrl;
                    poster = showData3.getThumbnail();
                    detail2 = showData3.getAvailableEpisodesDetail();
                    if (detail2 != null) {
                        pair = new Pair(CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getSub(), "sub")), CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getDub(), "dub")));
                    } else {
                        pair = null;
                    }
                    episodes = pair;
                    if (episodes == null) {
                        pair2 = new Pair(CollectionsKt.emptyList(), CollectionsKt.emptyList());
                    } else {
                        pair2 = episodes;
                    }
                    List subEpisodes2 = (List) pair2.component1();
                    List dubEpisodes2 = (List) pair2.component2();
                    characters = showData3.getCharacters();
                    if (characters != null) {
                        $this$map$iv = characters;
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        while (r24.hasNext()) {
                            it = (AnichiParser.Characters) item$iv$iv;
                            String fanart7 = fanart3;
                            fanart5 = it.getRole();
                            if (fanart5 != null) {
                                switch (fanart5.hashCode()) {
                                    case 2390489:
                                        title4 = id6;
                                        if (fanart5.equals("Main")) {
                                            role = ActorRole.Main;
                                        } else {
                                            role = null;
                                        }
                                        break;
                                    case 661270862:
                                        title4 = id6;
                                        if (fanart5.equals("Background")) {
                                            role = null;
                                        } else {
                                            role = ActorRole.Background;
                                        }
                                        break;
                                    case 1379577299:
                                        title4 = id6;
                                        if (fanart5.equals("Supporting")) {
                                            role = null;
                                        } else {
                                            role = ActorRole.Supporting;
                                        }
                                        break;
                                    default:
                                        title4 = id6;
                                        role = null;
                                        break;
                                }
                            } else {
                                title4 = id6;
                                role = null;
                            }
                            name = it.getName();
                            if (name != null) {
                                name2 = it.getName();
                                if (name2 != null) {
                                    name3 = name2.getNative();
                                } else {
                                    name3 = null;
                                }
                                if (name3 == null) {
                                    name3 = "";
                                }
                            } else {
                                name2 = it.getName();
                                if (name2 != null) {
                                    name3 = name2.getNative();
                                } else {
                                    name3 = null;
                                }
                                if (name3 == null) {
                                    name3 = "";
                                }
                            }
                            image = it.getImage();
                            if (image != null) {
                                image2 = it.getImage();
                                if (image2 != null) {
                                    medium = image2.getMedium();
                                } else {
                                    medium = null;
                                }
                            } else {
                                image2 = it.getImage();
                                if (image2 != null) {
                                    medium = image2.getMedium();
                                } else {
                                    medium = null;
                                }
                            }
                            String image5 = medium;
                            Object tmdbid5 = $result;
                            destination$iv$iv.add(new Pair(new Actor(name3, image5), role));
                            fanart3 = fanart7;
                            id6 = title4;
                            poster = poster;
                            $this$map$iv = $this$map$iv;
                            $result = tmdbid5;
                        }
                        fanart4 = fanart3;
                        title3 = id6;
                        tmdbid3 = $result;
                        poster2 = poster;
                        characters2 = (List) destination$iv$iv;
                    } else {
                        fanart4 = fanart3;
                        title3 = id6;
                        tmdbid3 = $result;
                        poster2 = poster;
                        characters2 = null;
                    }
                    type2 = showData3.getType();
                    if (type2 != null) {
                        z2 = true;
                    }
                    if (z2) {
                        tvType = TvType.AnimeMovie;
                    } else {
                        tvType = TvType.Anime;
                    }
                    Anichi anichi2 = $this4;
                    if (engtitle2 != null) {
                        str2 = engtitle2;
                    } else if (title3 == null) {
                        str2 = "";
                    } else {
                        str2 = title3;
                    }
                    Anichi $this6 = $this4;
                    String engtitle4 = engtitle2;
                    AnichiParser.AniMedia trackers5 = trackers3;
                    String poster4 = poster2;
                    AnichiParser.Edges showData6 = showData3;
                    C00053 c00054 = new C00053(engtitle4, poster4, trackers5, backgroundposter2, showData6, subEpisodes2, dubEpisodes2, characters2, $this6, description3, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable($this6);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(id5);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(res5);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(showData6);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(description3);
                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(trackers5);
                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(data3);
                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(animeMetadata2);
                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(fanart4);
                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(engtitle4);
                    c00032.L$13 = SpillingKt.nullOutSpilledVariable(backgroundposter2);
                    c00032.L$14 = SpillingKt.nullOutSpilledVariable(logotvType3);
                    c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                    c00032.L$16 = SpillingKt.nullOutSpilledVariable(logoUrl2);
                    c00032.L$17 = SpillingKt.nullOutSpilledVariable(poster4);
                    c00032.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00032.L$19 = SpillingKt.nullOutSpilledVariable(subEpisodes2);
                    c00032.L$20 = SpillingKt.nullOutSpilledVariable(dubEpisodes2);
                    c00032.L$21 = SpillingKt.nullOutSpilledVariable(characters2);
                    c00032.L$22 = SpillingKt.nullOutSpilledVariable(tvType);
                    c00032.label = 5;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anichi2, str2, backgroundposter3, tvType, false, c00054, c00032, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj) {
                        return obj;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                fanart = url3;
                if (animeMetadata != null) {
                    if (animeMetadata != null) {
                        str = null;
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        engtitle = str;
                    } else {
                        if (animeMetadata != null) {
                            str = null;
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            engtitle = showData2.getEnglishName();
                        } else {
                            engtitle = str;
                        }
                    }
                } else {
                    if (animeMetadata != null) {
                        str = null;
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        engtitle = str;
                    } else {
                        if (animeMetadata != null) {
                            str = null;
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            engtitle = showData2.getEnglishName();
                        } else {
                            engtitle = str;
                        }
                    }
                }
                if (fanart == null) {
                    if (data2 != null) {
                        backgroundposter = data2.getBannerImage();
                    } else {
                        backgroundposter = null;
                    }
                    if (backgroundposter == null) {
                        if (trackers != null) {
                            backgroundposter = null;
                        } else {
                            backgroundposter = null;
                        }
                    }
                } else {
                    backgroundposter = fanart;
                }
                type = showData2.getType();
                if (type != null) {
                    fanart2 = fanart;
                    res4 = res3;
                    if (StringsKt.contains(type, "movie", true)) {
                    }
                    if (z) {
                        logotvType = TvType.AnimeMovie;
                    } else {
                        logotvType = TvType.Anime;
                    }
                    if (animeMetadata != null) {
                        tmdbid = null;
                    } else {
                        tmdbid = null;
                    }
                    c00033.L$0 = $this3;
                    c00033.L$1 = url2;
                    c00033.L$2 = id4;
                    c00033.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                    c00033.L$4 = SpillingKt.nullOutSpilledVariable(res4);
                    c00033.L$5 = showData2;
                    c00033.L$6 = id3;
                    c00033.L$7 = title2;
                    c00033.L$8 = trackers;
                    c00033.L$9 = SpillingKt.nullOutSpilledVariable(data2);
                    c00033.L$10 = animeMetadata;
                    c00033.L$11 = SpillingKt.nullOutSpilledVariable(fanart2);
                    c00033.L$12 = engtitle;
                    c00033.L$13 = backgroundposter;
                    c00033.L$14 = SpillingKt.nullOutSpilledVariable(logotvType);
                    c00033.L$15 = SpillingKt.nullOutSpilledVariable(tmdbid);
                    c00033.label = 4;
                    trackers2 = trackers;
                    description2 = title2;
                    backgroundposter2 = backgroundposter;
                    logotvType2 = logotvType;
                    C00031 c00036 = c00033;
                    engtitle2 = engtitle;
                    tmdbid2 = tmdbid;
                    c00032 = c00036;
                    objFetchTmdbLogoUrl = AnichiUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", logotvType2, tmdbid2, "en", c00032);
                    if (objFetchTmdbLogoUrl == obj) {
                        return obj;
                    }
                    res5 = res4;
                    $this4 = $this3;
                    id5 = id4;
                    animeMetadata2 = animeMetadata;
                    $result = tmdbid2;
                    id6 = id3;
                    showData3 = showData2;
                    trackers3 = trackers2;
                    data3 = data2;
                    description3 = description2;
                    fanart3 = fanart2;
                    logotvType3 = logotvType2;
                    backgroundposter3 = url2;
                    String logoUrl3 = (String) objFetchTmdbLogoUrl;
                    poster = showData3.getThumbnail();
                    detail2 = showData3.getAvailableEpisodesDetail();
                    if (detail2 != null) {
                        pair = new Pair(CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getSub(), "sub")), CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getDub(), "dub")));
                    } else {
                        pair = null;
                    }
                    episodes = pair;
                    if (episodes == null) {
                        pair2 = new Pair(CollectionsKt.emptyList(), CollectionsKt.emptyList());
                    } else {
                        pair2 = episodes;
                    }
                    List subEpisodes3 = (List) pair2.component1();
                    List dubEpisodes3 = (List) pair2.component2();
                    characters = showData3.getCharacters();
                    if (characters != null) {
                        $this$map$iv = characters;
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        while (r24.hasNext()) {
                            it = (AnichiParser.Characters) item$iv$iv;
                            String fanart8 = fanart3;
                            fanart5 = it.getRole();
                            if (fanart5 != null) {
                                switch (fanart5.hashCode()) {
                                    case 2390489:
                                        title4 = id6;
                                        if (fanart5.equals("Main")) {
                                            role = ActorRole.Main;
                                        } else {
                                            role = null;
                                        }
                                        break;
                                    case 661270862:
                                        title4 = id6;
                                        if (fanart5.equals("Background")) {
                                            role = null;
                                        } else {
                                            role = ActorRole.Background;
                                        }
                                        break;
                                    case 1379577299:
                                        title4 = id6;
                                        if (fanart5.equals("Supporting")) {
                                            role = null;
                                        } else {
                                            role = ActorRole.Supporting;
                                        }
                                        break;
                                    default:
                                        title4 = id6;
                                        role = null;
                                        break;
                                }
                            } else {
                                title4 = id6;
                                role = null;
                            }
                            name = it.getName();
                            if (name != null) {
                                name2 = it.getName();
                                if (name2 != null) {
                                    name3 = name2.getNative();
                                } else {
                                    name3 = null;
                                }
                                if (name3 == null) {
                                    name3 = "";
                                }
                            } else {
                                name2 = it.getName();
                                if (name2 != null) {
                                    name3 = name2.getNative();
                                } else {
                                    name3 = null;
                                }
                                if (name3 == null) {
                                    name3 = "";
                                }
                            }
                            image = it.getImage();
                            if (image != null) {
                                image2 = it.getImage();
                                if (image2 != null) {
                                    medium = image2.getMedium();
                                } else {
                                    medium = null;
                                }
                            } else {
                                image2 = it.getImage();
                                if (image2 != null) {
                                    medium = image2.getMedium();
                                } else {
                                    medium = null;
                                }
                            }
                            String image6 = medium;
                            Object tmdbid6 = $result;
                            destination$iv$iv.add(new Pair(new Actor(name3, image6), role));
                            fanart3 = fanart8;
                            id6 = title4;
                            poster = poster;
                            $this$map$iv = $this$map$iv;
                            $result = tmdbid6;
                        }
                        fanart4 = fanart3;
                        title3 = id6;
                        tmdbid3 = $result;
                        poster2 = poster;
                        characters2 = (List) destination$iv$iv;
                    } else {
                        fanart4 = fanart3;
                        title3 = id6;
                        tmdbid3 = $result;
                        poster2 = poster;
                        characters2 = null;
                    }
                    type2 = showData3.getType();
                    if (type2 != null) {
                        z2 = true;
                    }
                    if (z2) {
                        tvType = TvType.AnimeMovie;
                    } else {
                        tvType = TvType.Anime;
                    }
                    Anichi anichi3 = $this4;
                    if (engtitle2 != null) {
                        str2 = engtitle2;
                    } else if (title3 == null) {
                        str2 = "";
                    } else {
                        str2 = title3;
                    }
                    Anichi $this7 = $this4;
                    String engtitle5 = engtitle2;
                    AnichiParser.AniMedia trackers6 = trackers3;
                    String poster5 = poster2;
                    AnichiParser.Edges showData7 = showData3;
                    C00053 c00055 = new C00053(engtitle5, poster5, trackers6, backgroundposter2, showData7, subEpisodes3, dubEpisodes3, characters2, $this7, description3, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable($this7);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(id5);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(res5);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(showData7);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(description3);
                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(trackers6);
                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(data3);
                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(animeMetadata2);
                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(fanart4);
                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(engtitle5);
                    c00032.L$13 = SpillingKt.nullOutSpilledVariable(backgroundposter2);
                    c00032.L$14 = SpillingKt.nullOutSpilledVariable(logotvType3);
                    c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                    c00032.L$16 = SpillingKt.nullOutSpilledVariable(logoUrl3);
                    c00032.L$17 = SpillingKt.nullOutSpilledVariable(poster5);
                    c00032.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00032.L$19 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                    c00032.L$20 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                    c00032.L$21 = SpillingKt.nullOutSpilledVariable(characters2);
                    c00032.L$22 = SpillingKt.nullOutSpilledVariable(tvType);
                    c00032.label = 5;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anichi3, str2, backgroundposter3, tvType, false, c00055, c00032, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj) {
                        return obj;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                fanart2 = fanart;
                res4 = res3;
                if (z) {
                    logotvType = TvType.AnimeMovie;
                } else {
                    logotvType = TvType.Anime;
                }
                if (animeMetadata != null) {
                    tmdbid = null;
                } else {
                    tmdbid = null;
                }
                c00033.L$0 = $this3;
                c00033.L$1 = url2;
                c00033.L$2 = id4;
                c00033.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                c00033.L$4 = SpillingKt.nullOutSpilledVariable(res4);
                c00033.L$5 = showData2;
                c00033.L$6 = id3;
                c00033.L$7 = title2;
                c00033.L$8 = trackers;
                c00033.L$9 = SpillingKt.nullOutSpilledVariable(data2);
                c00033.L$10 = animeMetadata;
                c00033.L$11 = SpillingKt.nullOutSpilledVariable(fanart2);
                c00033.L$12 = engtitle;
                c00033.L$13 = backgroundposter;
                c00033.L$14 = SpillingKt.nullOutSpilledVariable(logotvType);
                c00033.L$15 = SpillingKt.nullOutSpilledVariable(tmdbid);
                c00033.label = 4;
                trackers2 = trackers;
                description2 = title2;
                backgroundposter2 = backgroundposter;
                logotvType2 = logotvType;
                C00031 c00037 = c00033;
                engtitle2 = engtitle;
                tmdbid2 = tmdbid;
                c00032 = c00037;
                objFetchTmdbLogoUrl = AnichiUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", logotvType2, tmdbid2, "en", c00032);
                if (objFetchTmdbLogoUrl == obj) {
                    return obj;
                }
                res5 = res4;
                $this4 = $this3;
                id5 = id4;
                animeMetadata2 = animeMetadata;
                $result = tmdbid2;
                id6 = id3;
                showData3 = showData2;
                trackers3 = trackers2;
                data3 = data2;
                description3 = description2;
                fanart3 = fanart2;
                logotvType3 = logotvType2;
                backgroundposter3 = url2;
                String logoUrl4 = (String) objFetchTmdbLogoUrl;
                poster = showData3.getThumbnail();
                detail2 = showData3.getAvailableEpisodesDetail();
                if (detail2 != null) {
                    pair = new Pair(CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getSub(), "sub")), CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getDub(), "dub")));
                } else {
                    pair = null;
                }
                episodes = pair;
                if (episodes == null) {
                    pair2 = new Pair(CollectionsKt.emptyList(), CollectionsKt.emptyList());
                } else {
                    pair2 = episodes;
                }
                List subEpisodes4 = (List) pair2.component1();
                List dubEpisodes4 = (List) pair2.component2();
                characters = showData3.getCharacters();
                if (characters != null) {
                    $this$map$iv = characters;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    while (r24.hasNext()) {
                        it = (AnichiParser.Characters) item$iv$iv;
                        String fanart9 = fanart3;
                        fanart5 = it.getRole();
                        if (fanart5 != null) {
                            switch (fanart5.hashCode()) {
                                case 2390489:
                                    title4 = id6;
                                    if (fanart5.equals("Main")) {
                                        role = ActorRole.Main;
                                    } else {
                                        role = null;
                                    }
                                    break;
                                case 661270862:
                                    title4 = id6;
                                    if (fanart5.equals("Background")) {
                                        role = null;
                                    } else {
                                        role = ActorRole.Background;
                                    }
                                    break;
                                case 1379577299:
                                    title4 = id6;
                                    if (fanart5.equals("Supporting")) {
                                        role = null;
                                    } else {
                                        role = ActorRole.Supporting;
                                    }
                                    break;
                                default:
                                    title4 = id6;
                                    role = null;
                                    break;
                            }
                        } else {
                            title4 = id6;
                            role = null;
                        }
                        name = it.getName();
                        if (name != null) {
                            name2 = it.getName();
                            if (name2 != null) {
                                name3 = name2.getNative();
                            } else {
                                name3 = null;
                            }
                            if (name3 == null) {
                                name3 = "";
                            }
                        } else {
                            name2 = it.getName();
                            if (name2 != null) {
                                name3 = name2.getNative();
                            } else {
                                name3 = null;
                            }
                            if (name3 == null) {
                                name3 = "";
                            }
                        }
                        image = it.getImage();
                        if (image != null) {
                            image2 = it.getImage();
                            if (image2 != null) {
                                medium = image2.getMedium();
                            } else {
                                medium = null;
                            }
                        } else {
                            image2 = it.getImage();
                            if (image2 != null) {
                                medium = image2.getMedium();
                            } else {
                                medium = null;
                            }
                        }
                        String image7 = medium;
                        Object tmdbid7 = $result;
                        destination$iv$iv.add(new Pair(new Actor(name3, image7), role));
                        fanart3 = fanart9;
                        id6 = title4;
                        poster = poster;
                        $this$map$iv = $this$map$iv;
                        $result = tmdbid7;
                    }
                    fanart4 = fanart3;
                    title3 = id6;
                    tmdbid3 = $result;
                    poster2 = poster;
                    characters2 = (List) destination$iv$iv;
                } else {
                    fanart4 = fanart3;
                    title3 = id6;
                    tmdbid3 = $result;
                    poster2 = poster;
                    characters2 = null;
                }
                type2 = showData3.getType();
                if (type2 != null) {
                    z2 = true;
                }
                if (z2) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.Anime;
                }
                Anichi anichi4 = $this4;
                if (engtitle2 != null) {
                    str2 = engtitle2;
                } else if (title3 == null) {
                    str2 = "";
                } else {
                    str2 = title3;
                }
                Anichi $this8 = $this4;
                String engtitle6 = engtitle2;
                AnichiParser.AniMedia trackers7 = trackers3;
                String poster6 = poster2;
                AnichiParser.Edges showData8 = showData3;
                C00053 c00056 = new C00053(engtitle6, poster6, trackers7, backgroundposter2, showData8, subEpisodes4, dubEpisodes4, characters2, $this8, description3, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable($this8);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(id5);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(res5);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(showData8);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(description3);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(trackers7);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(data3);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(animeMetadata2);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(fanart4);
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(engtitle6);
                c00032.L$13 = SpillingKt.nullOutSpilledVariable(backgroundposter2);
                c00032.L$14 = SpillingKt.nullOutSpilledVariable(logotvType3);
                c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                c00032.L$16 = SpillingKt.nullOutSpilledVariable(logoUrl4);
                c00032.L$17 = SpillingKt.nullOutSpilledVariable(poster6);
                c00032.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                c00032.L$19 = SpillingKt.nullOutSpilledVariable(subEpisodes4);
                c00032.L$20 = SpillingKt.nullOutSpilledVariable(dubEpisodes4);
                c00032.L$21 = SpillingKt.nullOutSpilledVariable(characters2);
                c00032.L$22 = SpillingKt.nullOutSpilledVariable(tvType);
                c00032.label = 5;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anichi4, str2, backgroundposter3, tvType, false, c00056, c00032, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj) {
                    return obj;
                }
                return objNewAnimeLoadResponse$default;
            case 1:
                RequestBody body3 = (RequestBody) c00033.L$3;
                String id8 = (String) c00033.L$2;
                String url4 = (String) c00033.L$1;
                Anichi $this9 = (Anichi) c00033.L$0;
                ResultKt.throwOnFailure($result2);
                url2 = url4;
                body = body3;
                obj = coroutine_suspended;
                id = id8;
                objPost$default = $result2;
                $this2 = $this9;
                res = (NiceResponse) objPost$default;
                ResponseParser parser2 = res.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(res.getText(), Reflection.getOrCreateKotlinClass(AnichiParser.Detail.class));
                detail = (AnichiParser.Detail) safe;
                if (detail != null) {
                    break;
                }
                return null;
            case 2:
                description = (String) c00033.L$7;
                title = (String) c00033.L$6;
                showData = (AnichiParser.Edges) c00033.L$5;
                NiceResponse res6 = (NiceResponse) c00033.L$4;
                RequestBody body4 = (RequestBody) c00033.L$3;
                id2 = (String) c00033.L$2;
                String url5 = (String) c00033.L$1;
                $this3 = (Anichi) c00033.L$0;
                ResultKt.throwOnFailure($result2);
                url2 = url5;
                obj = coroutine_suspended;
                body = body4;
                tracker = $result2;
                res2 = res6;
                trackers = (AnichiParser.AniMedia) tracker;
                C00042 c00043 = new C00042(trackers, null);
                c00033.L$0 = $this3;
                c00033.L$1 = url2;
                c00033.L$2 = id2;
                c00033.L$3 = SpillingKt.nullOutSpilledVariable(body);
                c00033.L$4 = SpillingKt.nullOutSpilledVariable(res2);
                c00033.L$5 = showData;
                c00033.L$6 = title;
                c00033.L$7 = description;
                c00033.L$8 = trackers;
                c00033.label = 3;
                objCoroutineScope = CoroutineScopeKt.coroutineScope(c00043, c00033);
                if (objCoroutineScope == obj) {
                    return obj;
                }
                id3 = title;
                body2 = body;
                title2 = description;
                showData2 = showData;
                id4 = id2;
                res3 = res2;
                Pair pair4 = (Pair) objCoroutineScope;
                data2 = (AnilistAPIResponse.anilistMedia) pair4.component1();
                animeMetadata = (MetaAnimeData) pair4.component2();
                if (animeMetadata == null) {
                }
                fanart = url3;
                if (animeMetadata != null) {
                    if (animeMetadata != null) {
                        str = null;
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        engtitle = str;
                    } else {
                        if (animeMetadata != null) {
                            str = null;
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            engtitle = showData2.getEnglishName();
                        } else {
                            engtitle = str;
                        }
                    }
                } else {
                    if (animeMetadata != null) {
                        str = null;
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        engtitle = str;
                    } else {
                        if (animeMetadata != null) {
                            str = null;
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            engtitle = showData2.getEnglishName();
                        } else {
                            engtitle = str;
                        }
                    }
                }
                if (fanart == null) {
                    if (data2 != null) {
                        backgroundposter = data2.getBannerImage();
                    } else {
                        backgroundposter = null;
                    }
                    if (backgroundposter == null) {
                        if (trackers != null) {
                            backgroundposter = null;
                        } else {
                            backgroundposter = null;
                        }
                    }
                } else {
                    backgroundposter = fanart;
                }
                type = showData2.getType();
                if (type != null) {
                    fanart2 = fanart;
                    res4 = res3;
                    if (StringsKt.contains(type, "movie", true)) {
                    }
                    if (z) {
                        logotvType = TvType.AnimeMovie;
                    } else {
                        logotvType = TvType.Anime;
                    }
                    if (animeMetadata != null) {
                        tmdbid = null;
                    } else {
                        tmdbid = null;
                    }
                    c00033.L$0 = $this3;
                    c00033.L$1 = url2;
                    c00033.L$2 = id4;
                    c00033.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                    c00033.L$4 = SpillingKt.nullOutSpilledVariable(res4);
                    c00033.L$5 = showData2;
                    c00033.L$6 = id3;
                    c00033.L$7 = title2;
                    c00033.L$8 = trackers;
                    c00033.L$9 = SpillingKt.nullOutSpilledVariable(data2);
                    c00033.L$10 = animeMetadata;
                    c00033.L$11 = SpillingKt.nullOutSpilledVariable(fanart2);
                    c00033.L$12 = engtitle;
                    c00033.L$13 = backgroundposter;
                    c00033.L$14 = SpillingKt.nullOutSpilledVariable(logotvType);
                    c00033.L$15 = SpillingKt.nullOutSpilledVariable(tmdbid);
                    c00033.label = 4;
                    trackers2 = trackers;
                    description2 = title2;
                    backgroundposter2 = backgroundposter;
                    logotvType2 = logotvType;
                    C00031 c00038 = c00033;
                    engtitle2 = engtitle;
                    tmdbid2 = tmdbid;
                    c00032 = c00038;
                    objFetchTmdbLogoUrl = AnichiUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", logotvType2, tmdbid2, "en", c00032);
                    if (objFetchTmdbLogoUrl == obj) {
                        return obj;
                    }
                    res5 = res4;
                    $this4 = $this3;
                    id5 = id4;
                    animeMetadata2 = animeMetadata;
                    $result = tmdbid2;
                    id6 = id3;
                    showData3 = showData2;
                    trackers3 = trackers2;
                    data3 = data2;
                    description3 = description2;
                    fanart3 = fanart2;
                    logotvType3 = logotvType2;
                    backgroundposter3 = url2;
                    String logoUrl5 = (String) objFetchTmdbLogoUrl;
                    poster = showData3.getThumbnail();
                    detail2 = showData3.getAvailableEpisodesDetail();
                    if (detail2 != null) {
                        pair = new Pair(CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getSub(), "sub")), CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getDub(), "dub")));
                    } else {
                        pair = null;
                    }
                    episodes = pair;
                    if (episodes == null) {
                        pair2 = new Pair(CollectionsKt.emptyList(), CollectionsKt.emptyList());
                    } else {
                        pair2 = episodes;
                    }
                    List subEpisodes5 = (List) pair2.component1();
                    List dubEpisodes5 = (List) pair2.component2();
                    characters = showData3.getCharacters();
                    if (characters != null) {
                        $this$map$iv = characters;
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        while (r24.hasNext()) {
                            it = (AnichiParser.Characters) item$iv$iv;
                            String fanart10 = fanart3;
                            fanart5 = it.getRole();
                            if (fanart5 != null) {
                                switch (fanart5.hashCode()) {
                                    case 2390489:
                                        title4 = id6;
                                        if (fanart5.equals("Main")) {
                                            role = ActorRole.Main;
                                        } else {
                                            role = null;
                                        }
                                        break;
                                    case 661270862:
                                        title4 = id6;
                                        if (fanart5.equals("Background")) {
                                            role = null;
                                        } else {
                                            role = ActorRole.Background;
                                        }
                                        break;
                                    case 1379577299:
                                        title4 = id6;
                                        if (fanart5.equals("Supporting")) {
                                            role = null;
                                        } else {
                                            role = ActorRole.Supporting;
                                        }
                                        break;
                                    default:
                                        title4 = id6;
                                        role = null;
                                        break;
                                }
                            } else {
                                title4 = id6;
                                role = null;
                            }
                            name = it.getName();
                            if (name != null) {
                                name2 = it.getName();
                                if (name2 != null) {
                                    name3 = name2.getNative();
                                } else {
                                    name3 = null;
                                }
                                if (name3 == null) {
                                    name3 = "";
                                }
                            } else {
                                name2 = it.getName();
                                if (name2 != null) {
                                    name3 = name2.getNative();
                                } else {
                                    name3 = null;
                                }
                                if (name3 == null) {
                                    name3 = "";
                                }
                            }
                            image = it.getImage();
                            if (image != null) {
                                image2 = it.getImage();
                                if (image2 != null) {
                                    medium = image2.getMedium();
                                } else {
                                    medium = null;
                                }
                            } else {
                                image2 = it.getImage();
                                if (image2 != null) {
                                    medium = image2.getMedium();
                                } else {
                                    medium = null;
                                }
                            }
                            String image8 = medium;
                            Object tmdbid8 = $result;
                            destination$iv$iv.add(new Pair(new Actor(name3, image8), role));
                            fanart3 = fanart10;
                            id6 = title4;
                            poster = poster;
                            $this$map$iv = $this$map$iv;
                            $result = tmdbid8;
                        }
                        fanart4 = fanart3;
                        title3 = id6;
                        tmdbid3 = $result;
                        poster2 = poster;
                        characters2 = (List) destination$iv$iv;
                    } else {
                        fanart4 = fanart3;
                        title3 = id6;
                        tmdbid3 = $result;
                        poster2 = poster;
                        characters2 = null;
                    }
                    type2 = showData3.getType();
                    if (type2 != null) {
                        z2 = true;
                    }
                    if (z2) {
                        tvType = TvType.AnimeMovie;
                    } else {
                        tvType = TvType.Anime;
                    }
                    Anichi anichi5 = $this4;
                    if (engtitle2 != null) {
                        str2 = engtitle2;
                    } else if (title3 == null) {
                        str2 = "";
                    } else {
                        str2 = title3;
                    }
                    Anichi $this10 = $this4;
                    String engtitle7 = engtitle2;
                    AnichiParser.AniMedia trackers8 = trackers3;
                    String poster7 = poster2;
                    AnichiParser.Edges showData9 = showData3;
                    C00053 c00057 = new C00053(engtitle7, poster7, trackers8, backgroundposter2, showData9, subEpisodes5, dubEpisodes5, characters2, $this10, description3, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable($this10);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(id5);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(res5);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(showData9);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(description3);
                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(trackers8);
                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(data3);
                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(animeMetadata2);
                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(fanart4);
                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(engtitle7);
                    c00032.L$13 = SpillingKt.nullOutSpilledVariable(backgroundposter2);
                    c00032.L$14 = SpillingKt.nullOutSpilledVariable(logotvType3);
                    c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                    c00032.L$16 = SpillingKt.nullOutSpilledVariable(logoUrl5);
                    c00032.L$17 = SpillingKt.nullOutSpilledVariable(poster7);
                    c00032.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00032.L$19 = SpillingKt.nullOutSpilledVariable(subEpisodes5);
                    c00032.L$20 = SpillingKt.nullOutSpilledVariable(dubEpisodes5);
                    c00032.L$21 = SpillingKt.nullOutSpilledVariable(characters2);
                    c00032.L$22 = SpillingKt.nullOutSpilledVariable(tvType);
                    c00032.label = 5;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anichi5, str2, backgroundposter3, tvType, false, c00057, c00032, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj) {
                        return obj;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                fanart2 = fanart;
                res4 = res3;
                if (z) {
                    logotvType = TvType.AnimeMovie;
                } else {
                    logotvType = TvType.Anime;
                }
                if (animeMetadata != null) {
                    tmdbid = null;
                } else {
                    tmdbid = null;
                }
                c00033.L$0 = $this3;
                c00033.L$1 = url2;
                c00033.L$2 = id4;
                c00033.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                c00033.L$4 = SpillingKt.nullOutSpilledVariable(res4);
                c00033.L$5 = showData2;
                c00033.L$6 = id3;
                c00033.L$7 = title2;
                c00033.L$8 = trackers;
                c00033.L$9 = SpillingKt.nullOutSpilledVariable(data2);
                c00033.L$10 = animeMetadata;
                c00033.L$11 = SpillingKt.nullOutSpilledVariable(fanart2);
                c00033.L$12 = engtitle;
                c00033.L$13 = backgroundposter;
                c00033.L$14 = SpillingKt.nullOutSpilledVariable(logotvType);
                c00033.L$15 = SpillingKt.nullOutSpilledVariable(tmdbid);
                c00033.label = 4;
                trackers2 = trackers;
                description2 = title2;
                backgroundposter2 = backgroundposter;
                logotvType2 = logotvType;
                C00031 c00039 = c00033;
                engtitle2 = engtitle;
                tmdbid2 = tmdbid;
                c00032 = c00039;
                objFetchTmdbLogoUrl = AnichiUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", logotvType2, tmdbid2, "en", c00032);
                if (objFetchTmdbLogoUrl == obj) {
                    return obj;
                }
                res5 = res4;
                $this4 = $this3;
                id5 = id4;
                animeMetadata2 = animeMetadata;
                $result = tmdbid2;
                id6 = id3;
                showData3 = showData2;
                trackers3 = trackers2;
                data3 = data2;
                description3 = description2;
                fanart3 = fanart2;
                logotvType3 = logotvType2;
                backgroundposter3 = url2;
                String logoUrl6 = (String) objFetchTmdbLogoUrl;
                poster = showData3.getThumbnail();
                detail2 = showData3.getAvailableEpisodesDetail();
                if (detail2 != null) {
                    pair = new Pair(CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getSub(), "sub")), CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getDub(), "dub")));
                } else {
                    pair = null;
                }
                episodes = pair;
                if (episodes == null) {
                    pair2 = new Pair(CollectionsKt.emptyList(), CollectionsKt.emptyList());
                } else {
                    pair2 = episodes;
                }
                List subEpisodes6 = (List) pair2.component1();
                List dubEpisodes6 = (List) pair2.component2();
                characters = showData3.getCharacters();
                if (characters != null) {
                    $this$map$iv = characters;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    while (r24.hasNext()) {
                        it = (AnichiParser.Characters) item$iv$iv;
                        String fanart11 = fanart3;
                        fanart5 = it.getRole();
                        if (fanart5 != null) {
                            switch (fanart5.hashCode()) {
                                case 2390489:
                                    title4 = id6;
                                    if (fanart5.equals("Main")) {
                                        role = ActorRole.Main;
                                    } else {
                                        role = null;
                                    }
                                    break;
                                case 661270862:
                                    title4 = id6;
                                    if (fanart5.equals("Background")) {
                                        role = null;
                                    } else {
                                        role = ActorRole.Background;
                                    }
                                    break;
                                case 1379577299:
                                    title4 = id6;
                                    if (fanart5.equals("Supporting")) {
                                        role = null;
                                    } else {
                                        role = ActorRole.Supporting;
                                    }
                                    break;
                                default:
                                    title4 = id6;
                                    role = null;
                                    break;
                            }
                        } else {
                            title4 = id6;
                            role = null;
                        }
                        name = it.getName();
                        if (name != null) {
                            name2 = it.getName();
                            if (name2 != null) {
                                name3 = name2.getNative();
                            } else {
                                name3 = null;
                            }
                            if (name3 == null) {
                                name3 = "";
                            }
                        } else {
                            name2 = it.getName();
                            if (name2 != null) {
                                name3 = name2.getNative();
                            } else {
                                name3 = null;
                            }
                            if (name3 == null) {
                                name3 = "";
                            }
                        }
                        image = it.getImage();
                        if (image != null) {
                            image2 = it.getImage();
                            if (image2 != null) {
                                medium = image2.getMedium();
                            } else {
                                medium = null;
                            }
                        } else {
                            image2 = it.getImage();
                            if (image2 != null) {
                                medium = image2.getMedium();
                            } else {
                                medium = null;
                            }
                        }
                        String image9 = medium;
                        Object tmdbid9 = $result;
                        destination$iv$iv.add(new Pair(new Actor(name3, image9), role));
                        fanart3 = fanart11;
                        id6 = title4;
                        poster = poster;
                        $this$map$iv = $this$map$iv;
                        $result = tmdbid9;
                    }
                    fanart4 = fanart3;
                    title3 = id6;
                    tmdbid3 = $result;
                    poster2 = poster;
                    characters2 = (List) destination$iv$iv;
                } else {
                    fanart4 = fanart3;
                    title3 = id6;
                    tmdbid3 = $result;
                    poster2 = poster;
                    characters2 = null;
                }
                type2 = showData3.getType();
                if (type2 != null) {
                    z2 = true;
                }
                if (z2) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.Anime;
                }
                Anichi anichi6 = $this4;
                if (engtitle2 != null) {
                    str2 = engtitle2;
                } else if (title3 == null) {
                    str2 = "";
                } else {
                    str2 = title3;
                }
                Anichi $this11 = $this4;
                String engtitle8 = engtitle2;
                AnichiParser.AniMedia trackers9 = trackers3;
                String poster8 = poster2;
                AnichiParser.Edges showData10 = showData3;
                C00053 c00058 = new C00053(engtitle8, poster8, trackers9, backgroundposter2, showData10, subEpisodes6, dubEpisodes6, characters2, $this11, description3, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable($this11);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(id5);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(res5);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(showData10);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(description3);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(trackers9);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(data3);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(animeMetadata2);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(fanart4);
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(engtitle8);
                c00032.L$13 = SpillingKt.nullOutSpilledVariable(backgroundposter2);
                c00032.L$14 = SpillingKt.nullOutSpilledVariable(logotvType3);
                c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                c00032.L$16 = SpillingKt.nullOutSpilledVariable(logoUrl6);
                c00032.L$17 = SpillingKt.nullOutSpilledVariable(poster8);
                c00032.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                c00032.L$19 = SpillingKt.nullOutSpilledVariable(subEpisodes6);
                c00032.L$20 = SpillingKt.nullOutSpilledVariable(dubEpisodes6);
                c00032.L$21 = SpillingKt.nullOutSpilledVariable(characters2);
                c00032.L$22 = SpillingKt.nullOutSpilledVariable(tvType);
                c00032.label = 5;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anichi6, str2, backgroundposter3, tvType, false, c00058, c00032, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj) {
                    return obj;
                }
                return objNewAnimeLoadResponse$default;
            case 3:
                AnichiParser.AniMedia trackers10 = (AnichiParser.AniMedia) c00033.L$8;
                title2 = (String) c00033.L$7;
                String title5 = (String) c00033.L$6;
                AnichiParser.Edges showData11 = (AnichiParser.Edges) c00033.L$5;
                NiceResponse res7 = (NiceResponse) c00033.L$4;
                RequestBody body5 = (RequestBody) c00033.L$3;
                String id9 = (String) c00033.L$2;
                String url6 = (String) c00033.L$1;
                $this3 = (Anichi) c00033.L$0;
                ResultKt.throwOnFailure($result2);
                url2 = url6;
                obj = coroutine_suspended;
                showData2 = showData11;
                body2 = body5;
                trackers = trackers10;
                objCoroutineScope = $result2;
                id4 = id9;
                id3 = title5;
                res3 = res7;
                Pair pair5 = (Pair) objCoroutineScope;
                data2 = (AnilistAPIResponse.anilistMedia) pair5.component1();
                animeMetadata = (MetaAnimeData) pair5.component2();
                if (animeMetadata == null) {
                }
                fanart = url3;
                if (animeMetadata != null) {
                    if (animeMetadata != null) {
                        str = null;
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        engtitle = str;
                    } else {
                        if (animeMetadata != null) {
                            str = null;
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            engtitle = showData2.getEnglishName();
                        } else {
                            engtitle = str;
                        }
                    }
                } else {
                    if (animeMetadata != null) {
                        str = null;
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        engtitle = str;
                    } else {
                        if (animeMetadata != null) {
                            str = null;
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            engtitle = showData2.getEnglishName();
                        } else {
                            engtitle = str;
                        }
                    }
                }
                if (fanart == null) {
                    if (data2 != null) {
                        backgroundposter = data2.getBannerImage();
                    } else {
                        backgroundposter = null;
                    }
                    if (backgroundposter == null) {
                        if (trackers != null) {
                            backgroundposter = null;
                        } else {
                            backgroundposter = null;
                        }
                    }
                } else {
                    backgroundposter = fanart;
                }
                type = showData2.getType();
                if (type != null) {
                    fanart2 = fanart;
                    res4 = res3;
                    if (StringsKt.contains(type, "movie", true)) {
                    }
                    if (z) {
                        logotvType = TvType.AnimeMovie;
                    } else {
                        logotvType = TvType.Anime;
                    }
                    if (animeMetadata != null) {
                        tmdbid = null;
                    } else {
                        tmdbid = null;
                    }
                    c00033.L$0 = $this3;
                    c00033.L$1 = url2;
                    c00033.L$2 = id4;
                    c00033.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                    c00033.L$4 = SpillingKt.nullOutSpilledVariable(res4);
                    c00033.L$5 = showData2;
                    c00033.L$6 = id3;
                    c00033.L$7 = title2;
                    c00033.L$8 = trackers;
                    c00033.L$9 = SpillingKt.nullOutSpilledVariable(data2);
                    c00033.L$10 = animeMetadata;
                    c00033.L$11 = SpillingKt.nullOutSpilledVariable(fanart2);
                    c00033.L$12 = engtitle;
                    c00033.L$13 = backgroundposter;
                    c00033.L$14 = SpillingKt.nullOutSpilledVariable(logotvType);
                    c00033.L$15 = SpillingKt.nullOutSpilledVariable(tmdbid);
                    c00033.label = 4;
                    trackers2 = trackers;
                    description2 = title2;
                    backgroundposter2 = backgroundposter;
                    logotvType2 = logotvType;
                    C00031 c000310 = c00033;
                    engtitle2 = engtitle;
                    tmdbid2 = tmdbid;
                    c00032 = c000310;
                    objFetchTmdbLogoUrl = AnichiUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", logotvType2, tmdbid2, "en", c00032);
                    if (objFetchTmdbLogoUrl == obj) {
                        return obj;
                    }
                    res5 = res4;
                    $this4 = $this3;
                    id5 = id4;
                    animeMetadata2 = animeMetadata;
                    $result = tmdbid2;
                    id6 = id3;
                    showData3 = showData2;
                    trackers3 = trackers2;
                    data3 = data2;
                    description3 = description2;
                    fanart3 = fanart2;
                    logotvType3 = logotvType2;
                    backgroundposter3 = url2;
                    String logoUrl7 = (String) objFetchTmdbLogoUrl;
                    poster = showData3.getThumbnail();
                    detail2 = showData3.getAvailableEpisodesDetail();
                    if (detail2 != null) {
                        pair = new Pair(CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getSub(), "sub")), CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getDub(), "dub")));
                    } else {
                        pair = null;
                    }
                    episodes = pair;
                    if (episodes == null) {
                        pair2 = new Pair(CollectionsKt.emptyList(), CollectionsKt.emptyList());
                    } else {
                        pair2 = episodes;
                    }
                    List subEpisodes7 = (List) pair2.component1();
                    List dubEpisodes7 = (List) pair2.component2();
                    characters = showData3.getCharacters();
                    if (characters != null) {
                        $this$map$iv = characters;
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        while (r24.hasNext()) {
                            it = (AnichiParser.Characters) item$iv$iv;
                            String fanart12 = fanart3;
                            fanart5 = it.getRole();
                            if (fanart5 != null) {
                                switch (fanart5.hashCode()) {
                                    case 2390489:
                                        title4 = id6;
                                        if (fanart5.equals("Main")) {
                                            role = ActorRole.Main;
                                        } else {
                                            role = null;
                                        }
                                        break;
                                    case 661270862:
                                        title4 = id6;
                                        if (fanart5.equals("Background")) {
                                            role = null;
                                        } else {
                                            role = ActorRole.Background;
                                        }
                                        break;
                                    case 1379577299:
                                        title4 = id6;
                                        if (fanart5.equals("Supporting")) {
                                            role = null;
                                        } else {
                                            role = ActorRole.Supporting;
                                        }
                                        break;
                                    default:
                                        title4 = id6;
                                        role = null;
                                        break;
                                }
                            } else {
                                title4 = id6;
                                role = null;
                            }
                            name = it.getName();
                            if (name != null) {
                                name2 = it.getName();
                                if (name2 != null) {
                                    name3 = name2.getNative();
                                } else {
                                    name3 = null;
                                }
                                if (name3 == null) {
                                    name3 = "";
                                }
                            } else {
                                name2 = it.getName();
                                if (name2 != null) {
                                    name3 = name2.getNative();
                                } else {
                                    name3 = null;
                                }
                                if (name3 == null) {
                                    name3 = "";
                                }
                            }
                            image = it.getImage();
                            if (image != null) {
                                image2 = it.getImage();
                                if (image2 != null) {
                                    medium = image2.getMedium();
                                } else {
                                    medium = null;
                                }
                            } else {
                                image2 = it.getImage();
                                if (image2 != null) {
                                    medium = image2.getMedium();
                                } else {
                                    medium = null;
                                }
                            }
                            String image10 = medium;
                            Object tmdbid10 = $result;
                            destination$iv$iv.add(new Pair(new Actor(name3, image10), role));
                            fanart3 = fanart12;
                            id6 = title4;
                            poster = poster;
                            $this$map$iv = $this$map$iv;
                            $result = tmdbid10;
                        }
                        fanart4 = fanart3;
                        title3 = id6;
                        tmdbid3 = $result;
                        poster2 = poster;
                        characters2 = (List) destination$iv$iv;
                    } else {
                        fanart4 = fanart3;
                        title3 = id6;
                        tmdbid3 = $result;
                        poster2 = poster;
                        characters2 = null;
                    }
                    type2 = showData3.getType();
                    if (type2 != null) {
                        z2 = true;
                    }
                    if (z2) {
                        tvType = TvType.AnimeMovie;
                    } else {
                        tvType = TvType.Anime;
                    }
                    Anichi anichi7 = $this4;
                    if (engtitle2 != null) {
                        str2 = engtitle2;
                    } else if (title3 == null) {
                        str2 = "";
                    } else {
                        str2 = title3;
                    }
                    Anichi $this12 = $this4;
                    String engtitle9 = engtitle2;
                    AnichiParser.AniMedia trackers11 = trackers3;
                    String poster9 = poster2;
                    AnichiParser.Edges showData12 = showData3;
                    C00053 c00059 = new C00053(engtitle9, poster9, trackers11, backgroundposter2, showData12, subEpisodes7, dubEpisodes7, characters2, $this12, description3, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable($this12);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(id5);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(res5);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(showData12);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(description3);
                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(trackers11);
                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(data3);
                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(animeMetadata2);
                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(fanart4);
                    c00032.L$12 = SpillingKt.nullOutSpilledVariable(engtitle9);
                    c00032.L$13 = SpillingKt.nullOutSpilledVariable(backgroundposter2);
                    c00032.L$14 = SpillingKt.nullOutSpilledVariable(logotvType3);
                    c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                    c00032.L$16 = SpillingKt.nullOutSpilledVariable(logoUrl7);
                    c00032.L$17 = SpillingKt.nullOutSpilledVariable(poster9);
                    c00032.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00032.L$19 = SpillingKt.nullOutSpilledVariable(subEpisodes7);
                    c00032.L$20 = SpillingKt.nullOutSpilledVariable(dubEpisodes7);
                    c00032.L$21 = SpillingKt.nullOutSpilledVariable(characters2);
                    c00032.L$22 = SpillingKt.nullOutSpilledVariable(tvType);
                    c00032.label = 5;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anichi7, str2, backgroundposter3, tvType, false, c00059, c00032, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj) {
                        return obj;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                fanart2 = fanart;
                res4 = res3;
                if (z) {
                    logotvType = TvType.AnimeMovie;
                } else {
                    logotvType = TvType.Anime;
                }
                if (animeMetadata != null) {
                    tmdbid = null;
                } else {
                    tmdbid = null;
                }
                c00033.L$0 = $this3;
                c00033.L$1 = url2;
                c00033.L$2 = id4;
                c00033.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                c00033.L$4 = SpillingKt.nullOutSpilledVariable(res4);
                c00033.L$5 = showData2;
                c00033.L$6 = id3;
                c00033.L$7 = title2;
                c00033.L$8 = trackers;
                c00033.L$9 = SpillingKt.nullOutSpilledVariable(data2);
                c00033.L$10 = animeMetadata;
                c00033.L$11 = SpillingKt.nullOutSpilledVariable(fanart2);
                c00033.L$12 = engtitle;
                c00033.L$13 = backgroundposter;
                c00033.L$14 = SpillingKt.nullOutSpilledVariable(logotvType);
                c00033.L$15 = SpillingKt.nullOutSpilledVariable(tmdbid);
                c00033.label = 4;
                trackers2 = trackers;
                description2 = title2;
                backgroundposter2 = backgroundposter;
                logotvType2 = logotvType;
                C00031 c000311 = c00033;
                engtitle2 = engtitle;
                tmdbid2 = tmdbid;
                c00032 = c000311;
                objFetchTmdbLogoUrl = AnichiUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", logotvType2, tmdbid2, "en", c00032);
                if (objFetchTmdbLogoUrl == obj) {
                    return obj;
                }
                res5 = res4;
                $this4 = $this3;
                id5 = id4;
                animeMetadata2 = animeMetadata;
                $result = tmdbid2;
                id6 = id3;
                showData3 = showData2;
                trackers3 = trackers2;
                data3 = data2;
                description3 = description2;
                fanart3 = fanart2;
                logotvType3 = logotvType2;
                backgroundposter3 = url2;
                String logoUrl8 = (String) objFetchTmdbLogoUrl;
                poster = showData3.getThumbnail();
                detail2 = showData3.getAvailableEpisodesDetail();
                if (detail2 != null) {
                    pair = new Pair(CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getSub(), "sub")), CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getDub(), "dub")));
                } else {
                    pair = null;
                }
                episodes = pair;
                if (episodes == null) {
                    pair2 = new Pair(CollectionsKt.emptyList(), CollectionsKt.emptyList());
                } else {
                    pair2 = episodes;
                }
                List subEpisodes8 = (List) pair2.component1();
                List dubEpisodes8 = (List) pair2.component2();
                characters = showData3.getCharacters();
                if (characters != null) {
                    $this$map$iv = characters;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    while (r24.hasNext()) {
                        it = (AnichiParser.Characters) item$iv$iv;
                        String fanart13 = fanart3;
                        fanart5 = it.getRole();
                        if (fanart5 != null) {
                            switch (fanart5.hashCode()) {
                                case 2390489:
                                    title4 = id6;
                                    if (fanart5.equals("Main")) {
                                        role = ActorRole.Main;
                                    } else {
                                        role = null;
                                    }
                                    break;
                                case 661270862:
                                    title4 = id6;
                                    if (fanart5.equals("Background")) {
                                        role = null;
                                    } else {
                                        role = ActorRole.Background;
                                    }
                                    break;
                                case 1379577299:
                                    title4 = id6;
                                    if (fanart5.equals("Supporting")) {
                                        role = null;
                                    } else {
                                        role = ActorRole.Supporting;
                                    }
                                    break;
                                default:
                                    title4 = id6;
                                    role = null;
                                    break;
                            }
                        } else {
                            title4 = id6;
                            role = null;
                        }
                        name = it.getName();
                        if (name != null) {
                            name2 = it.getName();
                            if (name2 != null) {
                                name3 = name2.getNative();
                            } else {
                                name3 = null;
                            }
                            if (name3 == null) {
                                name3 = "";
                            }
                        } else {
                            name2 = it.getName();
                            if (name2 != null) {
                                name3 = name2.getNative();
                            } else {
                                name3 = null;
                            }
                            if (name3 == null) {
                                name3 = "";
                            }
                        }
                        image = it.getImage();
                        if (image != null) {
                            image2 = it.getImage();
                            if (image2 != null) {
                                medium = image2.getMedium();
                            } else {
                                medium = null;
                            }
                        } else {
                            image2 = it.getImage();
                            if (image2 != null) {
                                medium = image2.getMedium();
                            } else {
                                medium = null;
                            }
                        }
                        String image11 = medium;
                        Object tmdbid11 = $result;
                        destination$iv$iv.add(new Pair(new Actor(name3, image11), role));
                        fanart3 = fanart13;
                        id6 = title4;
                        poster = poster;
                        $this$map$iv = $this$map$iv;
                        $result = tmdbid11;
                    }
                    fanart4 = fanart3;
                    title3 = id6;
                    tmdbid3 = $result;
                    poster2 = poster;
                    characters2 = (List) destination$iv$iv;
                } else {
                    fanart4 = fanart3;
                    title3 = id6;
                    tmdbid3 = $result;
                    poster2 = poster;
                    characters2 = null;
                }
                type2 = showData3.getType();
                if (type2 != null) {
                    z2 = true;
                }
                if (z2) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.Anime;
                }
                Anichi anichi8 = $this4;
                if (engtitle2 != null) {
                    str2 = engtitle2;
                } else if (title3 == null) {
                    str2 = "";
                } else {
                    str2 = title3;
                }
                Anichi $this13 = $this4;
                String engtitle10 = engtitle2;
                AnichiParser.AniMedia trackers12 = trackers3;
                String poster10 = poster2;
                AnichiParser.Edges showData13 = showData3;
                C00053 c000510 = new C00053(engtitle10, poster10, trackers12, backgroundposter2, showData13, subEpisodes8, dubEpisodes8, characters2, $this13, description3, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable($this13);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(id5);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(res5);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(showData13);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(description3);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(trackers12);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(data3);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(animeMetadata2);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(fanart4);
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(engtitle10);
                c00032.L$13 = SpillingKt.nullOutSpilledVariable(backgroundposter2);
                c00032.L$14 = SpillingKt.nullOutSpilledVariable(logotvType3);
                c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                c00032.L$16 = SpillingKt.nullOutSpilledVariable(logoUrl8);
                c00032.L$17 = SpillingKt.nullOutSpilledVariable(poster10);
                c00032.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                c00032.L$19 = SpillingKt.nullOutSpilledVariable(subEpisodes8);
                c00032.L$20 = SpillingKt.nullOutSpilledVariable(dubEpisodes8);
                c00032.L$21 = SpillingKt.nullOutSpilledVariable(characters2);
                c00032.L$22 = SpillingKt.nullOutSpilledVariable(tvType);
                c00032.label = 5;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anichi8, str2, backgroundposter3, tvType, false, c000510, c00032, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj) {
                    return obj;
                }
                return objNewAnimeLoadResponse$default;
            case 4:
                Object tmdbid12 = (Integer) c00033.L$15;
                TvType logotvType4 = (TvType) c00033.L$14;
                String backgroundposter4 = (String) c00033.L$13;
                String engtitle11 = (String) c00033.L$12;
                String fanart14 = (String) c00033.L$11;
                MetaAnimeData animeMetadata3 = (MetaAnimeData) c00033.L$10;
                data3 = (AnilistAPIResponse.anilistMedia) c00033.L$9;
                AnichiParser.AniMedia trackers13 = (AnichiParser.AniMedia) c00033.L$8;
                String description5 = (String) c00033.L$7;
                String title6 = (String) c00033.L$6;
                AnichiParser.Edges showData14 = (AnichiParser.Edges) c00033.L$5;
                res5 = (NiceResponse) c00033.L$4;
                RequestBody body6 = (RequestBody) c00033.L$3;
                String id10 = (String) c00033.L$2;
                String url7 = (String) c00033.L$1;
                Anichi $this14 = (Anichi) c00033.L$0;
                ResultKt.throwOnFailure($result2);
                engtitle2 = engtitle11;
                c00032 = c00033;
                $this4 = $this14;
                id6 = title6;
                showData3 = showData14;
                fanart3 = fanart14;
                animeMetadata2 = animeMetadata3;
                trackers3 = trackers13;
                description3 = description5;
                body2 = body6;
                id5 = id10;
                logotvType3 = logotvType4;
                $result = tmdbid12;
                backgroundposter2 = backgroundposter4;
                backgroundposter3 = url7;
                obj = coroutine_suspended;
                objFetchTmdbLogoUrl = $result2;
                String logoUrl9 = (String) objFetchTmdbLogoUrl;
                poster = showData3.getThumbnail();
                detail2 = showData3.getAvailableEpisodesDetail();
                if (detail2 != null) {
                    pair = new Pair(CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getSub(), "sub")), CollectionsKt.reversed(load$buildEpisodes($this4, id5, trackers3, animeMetadata2, showData3, detail2.getDub(), "dub")));
                } else {
                    pair = null;
                }
                episodes = pair;
                if (episodes == null) {
                    pair2 = new Pair(CollectionsKt.emptyList(), CollectionsKt.emptyList());
                } else {
                    pair2 = episodes;
                }
                List subEpisodes9 = (List) pair2.component1();
                List dubEpisodes9 = (List) pair2.component2();
                characters = showData3.getCharacters();
                if (characters != null) {
                    $this$map$iv = characters;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    while (r24.hasNext()) {
                        it = (AnichiParser.Characters) item$iv$iv;
                        String fanart15 = fanart3;
                        fanart5 = it.getRole();
                        if (fanart5 != null) {
                            switch (fanart5.hashCode()) {
                                case 2390489:
                                    title4 = id6;
                                    if (fanart5.equals("Main")) {
                                        role = ActorRole.Main;
                                    } else {
                                        role = null;
                                    }
                                    break;
                                case 661270862:
                                    title4 = id6;
                                    if (fanart5.equals("Background")) {
                                        role = null;
                                    } else {
                                        role = ActorRole.Background;
                                    }
                                    break;
                                case 1379577299:
                                    title4 = id6;
                                    if (fanart5.equals("Supporting")) {
                                        role = null;
                                    } else {
                                        role = ActorRole.Supporting;
                                    }
                                    break;
                                default:
                                    title4 = id6;
                                    role = null;
                                    break;
                            }
                        } else {
                            title4 = id6;
                            role = null;
                        }
                        name = it.getName();
                        if (name != null) {
                            name2 = it.getName();
                            if (name2 != null) {
                                name3 = name2.getNative();
                            } else {
                                name3 = null;
                            }
                            if (name3 == null) {
                                name3 = "";
                            }
                        } else {
                            name2 = it.getName();
                            if (name2 != null) {
                                name3 = name2.getNative();
                            } else {
                                name3 = null;
                            }
                            if (name3 == null) {
                                name3 = "";
                            }
                        }
                        image = it.getImage();
                        if (image != null) {
                            image2 = it.getImage();
                            if (image2 != null) {
                                medium = image2.getMedium();
                            } else {
                                medium = null;
                            }
                        } else {
                            image2 = it.getImage();
                            if (image2 != null) {
                                medium = image2.getMedium();
                            } else {
                                medium = null;
                            }
                        }
                        String image12 = medium;
                        Object tmdbid13 = $result;
                        destination$iv$iv.add(new Pair(new Actor(name3, image12), role));
                        fanart3 = fanart15;
                        id6 = title4;
                        poster = poster;
                        $this$map$iv = $this$map$iv;
                        $result = tmdbid13;
                    }
                    fanart4 = fanart3;
                    title3 = id6;
                    tmdbid3 = $result;
                    poster2 = poster;
                    characters2 = (List) destination$iv$iv;
                } else {
                    fanart4 = fanart3;
                    title3 = id6;
                    tmdbid3 = $result;
                    poster2 = poster;
                    characters2 = null;
                }
                type2 = showData3.getType();
                if (type2 != null) {
                    z2 = true;
                }
                if (z2) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.Anime;
                }
                Anichi anichi9 = $this4;
                if (engtitle2 != null) {
                    str2 = engtitle2;
                } else if (title3 == null) {
                    str2 = "";
                } else {
                    str2 = title3;
                }
                Anichi $this15 = $this4;
                String engtitle12 = engtitle2;
                AnichiParser.AniMedia trackers14 = trackers3;
                String poster11 = poster2;
                AnichiParser.Edges showData15 = showData3;
                C00053 c000511 = new C00053(engtitle12, poster11, trackers14, backgroundposter2, showData15, subEpisodes9, dubEpisodes9, characters2, $this15, description3, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable($this15);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(backgroundposter3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(id5);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(res5);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(showData15);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(description3);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(trackers14);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(data3);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(animeMetadata2);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(fanart4);
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(engtitle12);
                c00032.L$13 = SpillingKt.nullOutSpilledVariable(backgroundposter2);
                c00032.L$14 = SpillingKt.nullOutSpilledVariable(logotvType3);
                c00032.L$15 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                c00032.L$16 = SpillingKt.nullOutSpilledVariable(logoUrl9);
                c00032.L$17 = SpillingKt.nullOutSpilledVariable(poster11);
                c00032.L$18 = SpillingKt.nullOutSpilledVariable(episodes);
                c00032.L$19 = SpillingKt.nullOutSpilledVariable(subEpisodes9);
                c00032.L$20 = SpillingKt.nullOutSpilledVariable(dubEpisodes9);
                c00032.L$21 = SpillingKt.nullOutSpilledVariable(characters2);
                c00032.L$22 = SpillingKt.nullOutSpilledVariable(tvType);
                c00032.label = 5;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anichi9, str2, backgroundposter3, tvType, false, c000511, c00032, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj) {
                    return obj;
                }
                return objNewAnimeLoadResponse$default;
            case 5:
                ResultKt.throwOnFailure($result2);
                return $result2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Anichi.Anichi$load$2 */
    /* JADX INFO: compiled from: Anichi.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/Anichi/AnilistAPIResponse$anilistMedia;", "Lcom/Anichi/MetaAnimeData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.Anichi$load$2", f = "Anichi.kt", i = {0, 0, 0, 1, 1, 1}, l = {255, 255}, m = "invokeSuspend", n = {"$this$coroutineScope", "anilistDeferred", "metadataDeferred", "$this$coroutineScope", "anilistDeferred", "metadataDeferred"}, nl = {255, -1}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends AnilistAPIResponse.anilistMedia, ? extends MetaAnimeData>>, Object> {
        final /* synthetic */ AnichiParser.AniMedia $trackers;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(AnichiParser.AniMedia aniMedia, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$trackers = aniMedia;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(this.$trackers, continuation);
            c00042.L$0 = obj;
            return c00042;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<AnilistAPIResponse.anilistMedia, MetaAnimeData>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0095 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x0096  */
        public final Object invokeSuspend(Object $result) {
            Deferred anilistDeferred;
            Deferred metadataDeferred;
            Object objAwait;
            Object objAwait2;
            Object obj;
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    anilistDeferred = BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new Anichi$load$2$anilistDeferred$1(this.$trackers, null), 3, (Object) null);
                    metadataDeferred = BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new Anichi$load$2$metadataDeferred$1(this.$trackers, null), 3, (Object) null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(anilistDeferred);
                    this.L$2 = metadataDeferred;
                    this.label = 1;
                    objAwait = anilistDeferred.await((Continuation) this);
                    if (objAwait == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(anilistDeferred);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(metadataDeferred);
                    this.L$3 = objAwait;
                    this.label = 2;
                    objAwait2 = metadataDeferred.await((Continuation) this);
                    if (objAwait2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objAwait;
                    return TuplesKt.to(obj, objAwait2);
                case 1:
                    metadataDeferred = (Deferred) this.L$2;
                    Deferred anilistDeferred2 = (Deferred) this.L$1;
                    ResultKt.throwOnFailure($result);
                    anilistDeferred = anilistDeferred2;
                    objAwait = $result;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(anilistDeferred);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(metadataDeferred);
                    this.L$3 = objAwait;
                    this.label = 2;
                    objAwait2 = metadataDeferred.await((Continuation) this);
                    if (objAwait2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objAwait;
                    return TuplesKt.to(obj, objAwait2);
                case 2:
                    obj = this.L$3;
                    ResultKt.throwOnFailure($result);
                    objAwait2 = $result;
                    return TuplesKt.to(obj, objAwait2);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private static final List<Episode> load$buildEpisodes(Anichi this$0, String id, AnichiParser.AniMedia trackers, MetaAnimeData animeMetadata, final AnichiParser.Edges showData, List<String> list, String dubStatus) {
        final EpisodeInfo meta;
        Map<String, EpisodeInfo> episodes;
        List<String> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            final String eps = (String) item$iv$iv;
            final Integer epNum = StringsKt.toIntOrNull(eps);
            Integer idMal = null;
            if (epNum != null) {
                int it = epNum.intValue();
                meta = (animeMetadata == null || (episodes = animeMetadata.getEpisodes()) == null) ? null : episodes.get(String.valueOf(it));
            } else {
                meta = null;
            }
            Anichi anichi = this$0;
            AppUtils appUtils = AppUtils.INSTANCE;
            if (trackers != null) {
                idMal = trackers.getIdMal();
            }
            destination$iv$iv.add(MainAPIKt.newEpisode(anichi, appUtils.toJson(new AnichiParser.AnichiLoadData(id, dubStatus, eps, idMal)), new Function1() { // from class: com.Anichi.Anichi$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return Anichi.load$buildEpisodes$lambda$1$1(epNum, meta, eps, showData, (Episode) obj);
                }
            }));
            $this$map$iv = $this$map$iv;
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$buildEpisodes$lambda$1$1(Integer $epNum, EpisodeInfo $meta, String $eps, AnichiParser.Edges $showData, Episode $this$newEpisode) {
        String str;
        Map<String, String> title;
        Map<String, String> title2;
        String thumbnail;
        String overview;
        Map<String, String> title3;
        $this$newEpisode.setEpisode($epNum);
        if ($meta == null || (title3 = $meta.getTitle()) == null || (str = title3.get("en")) == null) {
            str = ($meta == null || (title2 = $meta.getTitle()) == null) ? null : title2.get("x-jat");
            if (str == null) {
                str = ($meta == null || (title = $meta.getTitle()) == null) ? null : title.get("ja");
                if (str == null) {
                    str = "Episode " + $eps;
                }
            }
        }
        $this$newEpisode.setName(str);
        $this$newEpisode.setScore(Score.Companion.from10($meta != null ? $meta.getRating() : null));
        if ($meta == null || (thumbnail = $meta.getImage()) == null) {
            thumbnail = $showData.getThumbnail();
        }
        $this$newEpisode.setPosterUrl(thumbnail);
        if ($meta == null || (overview = $meta.getOverview()) == null) {
            overview = "No summary available";
        }
        $this$newEpisode.setDescription(overview);
        MainAPIKt.addDate$default($this$newEpisode, $meta != null ? $meta.getAirDateUtc() : null, (String) null, 2, (Object) null);
        $this$newEpisode.setRunTime($meta != null ? $meta.getRuntime() : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Anichi.Anichi$load$3 */
    /* JADX INFO: compiled from: Anichi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.Anichi$load$3", f = "Anichi.kt", i = {0}, l = {319}, m = "invokeSuspend", n = {"$this$newAnimeLoadResponse"}, nl = {324}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nAnichi.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Anichi.kt\ncom/Anichi/Anichi$load$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,376:1\n777#2:377\n873#2,2:378\n1739#2:380\n1814#2,3:381\n*S KotlinDebug\n*F\n+ 1 Anichi.kt\ncom/Anichi/Anichi$load$3\n*L\n320#1:377\n320#1:378,2\n320#1:380\n320#1:381,3\n*E\n"})
    static final class C00053 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $backgroundposter;
        final /* synthetic */ List<Pair<Actor, ActorRole>> $characters;
        final /* synthetic */ String $description;
        final /* synthetic */ List<Episode> $dubEpisodes;
        final /* synthetic */ String $engtitle;
        final /* synthetic */ String $poster;
        final /* synthetic */ AnichiParser.Edges $showData;
        final /* synthetic */ List<Episode> $subEpisodes;
        final /* synthetic */ AnichiParser.AniMedia $trackers;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ Anichi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00053(String str, String str2, AnichiParser.AniMedia aniMedia, String str3, AnichiParser.Edges edges, List<Episode> list, List<Episode> list2, List<? extends Pair<Actor, ? extends ActorRole>> list3, Anichi anichi, String str4, Continuation<? super C00053> continuation) {
            super(2, continuation);
            this.$engtitle = str;
            this.$poster = str2;
            this.$trackers = aniMedia;
            this.$backgroundposter = str3;
            this.$showData = edges;
            this.$subEpisodes = list;
            this.$dubEpisodes = list2;
            this.$characters = list3;
            this.this$0 = anichi;
            this.$description = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00053 = new C00053(this.$engtitle, this.$poster, this.$trackers, this.$backgroundposter, this.$showData, this.$subEpisodes, this.$dubEpisodes, this.$characters, this.this$0, this.$description, continuation);
            c00053.L$0 = obj;
            return c00053;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            AnichiParser.CoverImage coverImage;
            AnichiParser.CoverImage coverImage2;
            AnichiParser.CoverImage coverImage3;
            LoadResponse loadResponse = (AnimeLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setEngName(this.$engtitle);
                    String extraLarge = this.$poster;
                    if (extraLarge == null) {
                        AnichiParser.AniMedia aniMedia = this.$trackers;
                        extraLarge = (aniMedia == null || (coverImage3 = aniMedia.getCoverImage()) == null) ? null : coverImage3.getExtraLarge();
                        if (extraLarge == null) {
                            AnichiParser.AniMedia aniMedia2 = this.$trackers;
                            extraLarge = (aniMedia2 == null || (coverImage2 = aniMedia2.getCoverImage()) == null) ? null : coverImage2.getLarge();
                        }
                    }
                    loadResponse.setPosterUrl(extraLarge);
                    String extraLarge2 = this.$backgroundposter;
                    if (extraLarge2 == null) {
                        AnichiParser.AniMedia aniMedia3 = this.$trackers;
                        extraLarge2 = (aniMedia3 == null || (coverImage = aniMedia3.getCoverImage()) == null) ? null : coverImage.getExtraLarge();
                    }
                    loadResponse.setBackgroundPosterUrl(extraLarge2);
                    loadResponse.setScore(Score.Companion.from100(this.$showData.getAverageScore()));
                    loadResponse.setTags(this.$showData.getGenres());
                    AnichiParser.AiredStart airedStart = this.$showData.getAiredStart();
                    loadResponse.setYear(airedStart != null ? Boxing.boxInt(airedStart.getYear()) : null);
                    Integer episodeDuration = this.$showData.getEpisodeDuration();
                    loadResponse.setDuration(episodeDuration != null ? Boxing.boxInt(episodeDuration.intValue() / 60000) : null);
                    LoadResponse.Companion companion = LoadResponse.Companion;
                    LoadResponse loadResponse2 = loadResponse;
                    Iterable $this$filter$iv = this.$showData.getPrevideos();
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        String it = (String) element$iv$iv;
                        if (!StringsKt.isBlank(it)) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                    Iterable $this$map$iv = (List) destination$iv$iv;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        String it2 = (String) item$iv$iv;
                        destination$iv$iv2.add("https://www.youtube.com/watch?v=" + it2);
                    }
                    this.L$0 = loadResponse;
                    this.label = 1;
                    if (LoadResponse.Companion.addTrailer$default(companion, loadResponse2, (List) destination$iv$iv2, (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$subEpisodes);
            MainAPIKt.addEpisodes(loadResponse, DubStatus.Dubbed, this.$dubEpisodes);
            LoadResponse.Companion.addActorsRole(loadResponse, this.$characters);
            loadResponse.setShowStatus(this.this$0.getStatus(String.valueOf(this.$showData.getStatus())));
            LoadResponse.Companion companion2 = LoadResponse.Companion;
            LoadResponse loadResponse3 = loadResponse;
            AnichiParser.AniMedia aniMedia4 = this.$trackers;
            companion2.addMalId(loadResponse3, aniMedia4 != null ? aniMedia4.getIdMal() : null);
            LoadResponse.Companion companion3 = LoadResponse.Companion;
            LoadResponse loadResponse4 = loadResponse;
            AnichiParser.AniMedia aniMedia5 = this.$trackers;
            companion3.addAniListId(loadResponse4, aniMedia5 != null ? Boxing.boxInt(aniMedia5.getId()) : null);
            String str = this.$description;
            loadResponse.setPlot(str != null ? new Regex("<(.*?)>").replace(str, "") : null);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    static /* synthetic */ Object loadLinks$suspendImpl(Anichi $this, String data, boolean isCasting, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Boolean> continuation) {
        C00061 c00061;
        Object obj;
        Object objDecodeFromString;
        if (continuation instanceof C00061) {
            c00061 = (C00061) continuation;
            if ((c00061.label & Integer.MIN_VALUE) != 0) {
                c00061.label -= Integer.MIN_VALUE;
            } else {
                c00061 = $this.new C00061(continuation);
            }
        } else {
            c00061 = $this.new C00061(continuation);
        }
        C00061 c00062 = c00061;
        Object $result = c00062.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00062.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(AnichiParser.AnichiLoadData.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.AnichiLoadData.class), (List) null, 2, (Object) null));
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
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<AnichiParser.AnichiLoadData>() { // from class: com.Anichi.Anichi$loadLinks$suspendImpl$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<AnichiParser.AnichiLoadData>() { // from class: com.Anichi.Anichi$loadLinks$suspendImpl$$inlined$parseJson$1
                        });
                    }
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<AnichiParser.AnichiLoadData>() { // from class: com.Anichi.Anichi$loadLinks$suspendImpl$$inlined$parseJson$1
                    });
                }
                AnichiParser.AnichiLoadData loadData = (AnichiParser.AnichiLoadData) objDecodeFromString;
                AnichiExtractors anichiExtractors = AnichiExtractors.INSTANCE;
                String hash = loadData.getHash();
                String dubStatus = loadData.getDubStatus();
                String episode = loadData.getEpisode();
                c00062.L$0 = SpillingKt.nullOutSpilledVariable($this);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(data);
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(function2);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(loadData);
                c00062.Z$0 = isCasting;
                c00062.label = 1;
                if (anichiExtractors.invokeInternalSources(hash, dubStatus, episode, function1, function2, c00062) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                boolean z = c00062.Z$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: compiled from: Anichi.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/Anichi/Anichi$Companion;", "", "<init>", "()V", "apiUrl", "", "apiEndPoint", "anilistApi", "jikanApi", "mainHash", "popularHash", "detailHash", "serverHash", "maipageshaHash", "headers", "", "getHeaders", "()Ljava/util/Map;", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Map<String, String> getHeaders() {
            return Anichi.headers;
        }
    }
}
