package com.phisher98;

import android.app.Activity;
import android.content.SharedPreferences;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.CommonActivity;
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
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.syncproviders.AccountManager;
import com.lagradost.cloudstream3.syncproviders.SyncAPI;
import com.lagradost.cloudstream3.syncproviders.SyncIdName;
import com.lagradost.cloudstream3.syncproviders.SyncRepo;
import com.lagradost.cloudstream3.syncproviders.providers.AniListApi;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.UiText;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import com.phisher98.donation.DonationManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import kotlin.collections.IntIterator;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KType;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
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

/* JADX INFO: compiled from: StreamPlayAnime.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0003defB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010+\u001a\u00020\u001dH\u0002J\f\u0010,\u001a\u00020\u0007*\u00020-H\u0004J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u00101J\f\u00102\u001a\u000203*\u000204H\u0002J,\u00105\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020307\u0012\u0004\u0012\u00020\u001d06*\u0002082\u0006\u00109\u001a\u00020&H\u0082@¢\u0006\u0002\u0010:J\u001e\u0010@\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001072\u0006\u00100\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00101J\u001e\u0010A\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001072\u0006\u00100\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00101J \u0010A\u001a\u0004\u0018\u00010B2\u0006\u00100\u001a\u00020\u00072\u0006\u00109\u001a\u00020&H\u0096@¢\u0006\u0002\u0010CJ\u001e\u0010>\u001a\u00020D2\u0006\u00109\u001a\u00020&2\u0006\u0010E\u001a\u000208H\u0096@¢\u0006\u0002\u0010FJ\u0016\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00101J\u001e\u0010J\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010LJ\u001e\u0010M\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010LJF\u0010O\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u001d2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020U0S2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020U0SH\u0096@¢\u0006\u0002\u0010XJ\u0010\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\u0007J*\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010\u00072\b\u0010_\u001a\u0004\u0018\u00010&2\u0006\u0010`\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010aJ\u0017\u0010b\u001a\u0004\u0018\u00010&2\u0006\u0010^\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010cR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u001dX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001dX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020=07X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?¨\u0006g"}, d2 = {"Lcom/phisher98/StreamPlayAnime;", "Lcom/lagradost/cloudstream3/MainAPI;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "setSupportedTypes", "(Ljava/util/Set;)V", "lang", "getLang", "setLang", "supportedSyncNames", "Lcom/lagradost/cloudstream3/syncproviders/SyncIdName;", "getSupportedSyncNames", "hasMainPage", "", "getHasMainPage", "()Z", "hasQuickSearch", "getHasQuickSearch", "repo", "Lcom/lagradost/cloudstream3/syncproviders/SyncRepo;", "apiUrl", "mediaLimit", "", "isAdult", "headerJSON", "", "isAnilistDown", "shouldUseKitsu", "toStringData", "", "anilistAPICall", "Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResponse", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/phisher98/StreamPlayAnime$Media;", "toSearchResponseList", "Lkotlin/Pair;", "", "Lcom/lagradost/cloudstream3/MainPageRequest;", "page", "(Lcom/lagradost/cloudstream3/MainPageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentYear", "mainPage", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "quickSearch", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "request", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadFromAnilist", "id", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFromKitsu", "rawId", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "t", "tmdbToAnimeId", "Lcom/phisher98/AniIds;", "title", "year", "type", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/TvType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractSeason", "(Ljava/lang/String;)Ljava/lang/Integer;", "AnilistAPIResponse", "LinkData", "Media", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStreamPlayAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayAnime.kt\ncom/phisher98/StreamPlayAnime\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,781:1\n73#2,5:782\n73#2,5:897\n73#2,5:902\n73#2,5:907\n73#2,5:913\n1739#3:787\n1814#3,3:788\n1739#3:791\n1814#3,3:792\n1795#3,10:795\n2068#3:805\n2069#3:807\n1805#3:808\n1453#3,2:809\n1468#3,4:811\n1453#3,2:815\n1468#3,4:817\n1739#3:821\n1814#3,3:822\n1749#3:825\n1782#3,4:826\n296#3,2:831\n296#3,2:833\n1453#3,2:835\n1468#3,4:837\n1453#3,2:841\n1468#3,4:843\n1749#3:847\n1782#3,4:848\n1739#3:852\n1814#3,3:853\n1749#3:856\n1782#3,4:857\n777#3:861\n873#3,2:862\n1795#3,10:864\n2068#3:874\n2069#3:876\n1805#3:877\n1#4:806\n1#4:830\n1#4:875\n1#4:879\n1#4:912\n63#5:878\n64#5,15:880\n50#6:895\n43#6:896\n*S KotlinDebug\n*F\n+ 1 StreamPlayAnime.kt\ncom/phisher98/StreamPlayAnime\n*L\n93#1:782,5\n565#1:897,5\n567#1:902,5\n569#1:907,5\n767#1:913,5\n114#1:787\n114#1:788,3\n148#1:791\n148#1:792,3\n170#1:795,10\n170#1:805\n170#1:807\n170#1:808\n263#1:809,2\n263#1:811,4\n264#1:815,2\n264#1:817,4\n293#1:821\n293#1:822,3\n321#1:825\n321#1:826,4\n424#1:831,2\n425#1:833,2\n429#1:835,2\n429#1:837,4\n432#1:841,2\n432#1:843,4\n495#1:847\n495#1:848,4\n497#1:852\n497#1:853,3\n500#1:856\n500#1:857,4\n506#1:861\n506#1:862,2\n506#1:864,10\n506#1:874\n506#1:876\n506#1:877\n170#1:806\n506#1:875\n554#1:879\n554#1:878\n554#1:880,15\n554#1:895\n554#1:896\n*E\n"})
public final class StreamPlayAnime extends MainAPI {

    @NotNull
    private final String apiUrl;
    private final int currentYear;
    private final boolean hasMainPage;
    private final boolean hasQuickSearch;

    @NotNull
    private final Map<String, String> headerJSON;
    private final boolean isAdult;
    private boolean isAnilistDown;

    @NotNull
    private String lang;

    @NotNull
    private final List<MainPageData> mainPage;

    @NotNull
    private String mainUrl;
    private final int mediaLimit;

    @NotNull
    private String name;

    @NotNull
    private final SyncRepo repo;

    @Nullable
    private final SharedPreferences sharedPref;

    @NotNull
    private final Set<SyncIdName> supportedSyncNames;

    @NotNull
    private Set<? extends TvType> supportedTypes;

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$anilistAPICall$1 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0, 0}, l = {91}, m = "anilistAPICall", n = {"query", "data"}, nl = {93}, s = {"L$0", "L$1"}, v = 2)
    static final class C00801 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00801(Continuation<? super C00801> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.anilistAPICall(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$getMainPage$1 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 4}, l = {170, 180, 184, 192, 198}, m = "getMainPage", n = {"request", "page", "request", "catalogId", "page", "request", "e", "page", "request", "page", "request", "e", "catalogId", "page"}, nl = {170, 181, 185, 193, 199}, s = {"L$0", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00811 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00811(Continuation<? super C00811> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$load$1 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3}, l = {212, 217, 221, 225}, m = "load", n = {"url", "id", "isKitsu", "url", "id", "e", "isKitsu", "url", "id", "isKitsu", "url", "id", "e", "isKitsu"}, nl = {213, 211, 222, 227}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00821 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00821(Continuation<? super C00821> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadFromAnilist$1 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {233, 243, 247, 254, 340, 354}, m = "loadFromAnilist", n = {"url", "id", "url", "id", "data", "anititle", "posterurl", "backgroundUrl", "anitype", "aniyear", "url", "id", "data", "anititle", "posterurl", "backgroundUrl", "anitype", "ids", "jpTitle", "aniyear", "url", "id", "data", "anititle", "posterurl", "backgroundUrl", "anitype", "ids", "jpTitle", "syncMetaData", "animeMetaData", "tmdbid", "kitsuid", "type", "aniyear", "url", "id", "data", "anititle", "posterurl", "backgroundUrl", "anitype", "ids", "jpTitle", "syncMetaData", "animeMetaData", "tmdbid", "kitsuid", "type", "logoUrl", "anidbEidMap", "epMetaMap", "fallbackPoster", "fallbackTitle", "href", "episodes", "episodesDub", "aniyear", "totalEps", "anidbEid", "url", "id", "data", "anititle", "posterurl", "backgroundUrl", "anitype", "ids", "jpTitle", "syncMetaData", "animeMetaData", "tmdbid", "kitsuid", "type", "logoUrl", "anidbEidMap", "epMetaMap", "fallbackPoster", "fallbackTitle", "href", "episodes", "episodesDub", "aniyear", "totalEps", "anidbEid"}, nl = {235, 245, 248, 262, 354, 339}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0", "I$1", "I$2"}, v = 2)
    static final class C00831 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
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

        C00831(Continuation<? super C00831> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.loadFromAnilist(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadFromKitsu$1 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}, l = {383, 385, 387, 387, 393, 405, 416, 514, 527}, m = "loadFromKitsu", n = {"url", "rawId", "url", "rawId", "url", "rawId", "url", "rawId", "url", "rawId", "kitsuMeta", "numericKitsuId", "queryParam", "url", "rawId", "kitsuMeta", "numericKitsuId", "syncMetaData", "animeMetaData", "tmdbid", "kitsuid", "type", "anitype", "anititle", "aniyear", "isMovie", "url", "rawId", "kitsuMeta", "numericKitsuId", "syncMetaData", "animeMetaData", "tmdbid", "kitsuid", "type", "anitype", "anititle", "aniyear", "logoUrl", "aniListId", "malId", "isMovie", "url", "rawId", "kitsuMeta", "numericKitsuId", "syncMetaData", "animeMetaData", "tmdbid", "kitsuid", "type", "anitype", "anititle", "aniyear", "logoUrl", "aniListId", "malId", "ids", "finalAniId", "finalMalId", "jpTitle", "posterurl", "backgroundUrl", "videos", "anidbEidMap", "epMetaMap", "fallbackPoster", "fallbackTitle", "href", "episodes", "episodesDub", "recs", "isMovie", "totalEps", "anidbEid", "scoreValue", "url", "rawId", "kitsuMeta", "numericKitsuId", "syncMetaData", "animeMetaData", "tmdbid", "kitsuid", "type", "anitype", "anititle", "aniyear", "logoUrl", "aniListId", "malId", "ids", "finalAniId", "finalMalId", "jpTitle", "posterurl", "backgroundUrl", "videos", "anidbEidMap", "epMetaMap", "fallbackPoster", "fallbackTitle", "href", "episodes", "episodesDub", "recs", "isMovie", "totalEps", "anidbEid", "scoreValue"}, nl = {384, 387, 387, 382, 394, 413, 418, 527, 513}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "I$0", "I$1", "I$2", "I$3"}, v = 2)
    static final class C00861 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
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
        Object L$28;
        Object L$29;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00861(Continuation<? super C00861> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.loadFromKitsu(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$1 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {565, 567, 569, 580}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "mediaData", "malId", "episode", "jpTitle", "anititle", "anidbEid", "aniid", "year", "kitsuId", "isCasting", "data", "subtitleCallback", "callback", "mediaData", "malId", "episode", "jpTitle", "anititle", "anidbEid", "aniid", "year", "kitsuId", "isCasting", "data", "subtitleCallback", "callback", "mediaData", "malId", "episode", "jpTitle", "anititle", "anidbEid", "aniid", "year", "kitsuId", "isCasting", "data", "subtitleCallback", "callback", "mediaData", "malId", "episode", "jpTitle", "anititle", "anidbEid", "aniid", "year", "kitsuId", "malsync", "kaasSlug", "dubStatus", "isCasting"}, nl = {801, 806, 811, 611}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0"}, v = 2)
    static final class C00891 extends ContinuationImpl {
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
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00891(Continuation<? super C00891> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$quickSearch$1 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0}, l = {135}, m = "quickSearch", n = {"query"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class C01011 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01011(Continuation<? super C01011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.quickSearch(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$search$1 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0}, l = {137}, m = "search", n = {"query"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class C01021 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01021(Continuation<? super C01021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$search$2 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0, 0, 1, 1, 2, 2, 2}, l = {141, 145, 152}, m = "search", n = {"query", "page", "query", "page", "query", "e", "page"}, nl = {143, 144, 154}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "L$1", "I$0"}, v = 2)
    static final class C01032 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01032(Continuation<? super C01032> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.search(null, 0, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$tmdbToAnimeId$1 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0, 0, 0, 0, 0, 0}, l = {766}, m = "tmdbToAnimeId", n = {"title", "year", "type", "query", "variables", "data"}, nl = {767}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C01041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C01041(Continuation<? super C01041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.tmdbToAnimeId(null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$toSearchResponseList$1 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0, 0}, l = {112}, m = "toSearchResponseList", n = {"$this$toSearchResponseList", "page"}, nl = {114}, s = {"L$0", "I$0"}, v = 2)
    static final class C01051 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01051(Continuation<? super C01051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.toSearchResponseList(null, 0, (Continuation) this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public StreamPlayAnime() {
        SharedPreferences sharedPreferences = null;
        this(sharedPreferences, 1, sharedPreferences);
    }

    public StreamPlayAnime(@Nullable SharedPreferences sharedPref) {
        this.sharedPref = sharedPref;
        this.name = "StreamPlay-Anime";
        this.mainUrl = "https://anilist.co";
        this.supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie, TvType.OVA});
        this.lang = "en";
        this.supportedSyncNames = SetsKt.setOf(new SyncIdName[]{SyncIdName.Anilist, SyncIdName.MyAnimeList});
        this.hasMainPage = true;
        this.hasQuickSearch = true;
        this.repo = new SyncRepo(AccountManager.Companion.getAniListApi());
        this.apiUrl = StreamPlay.anilistAPI;
        this.mediaLimit = 20;
        this.headerJSON = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "application/json"), TuplesKt.to("Content-Type", "application/json")});
        this.isAnilistDown = true;
        this.currentYear = Calendar.getInstance().get(1);
        this.mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("query ($page: Int = ###, $sort: [MediaSort] = [TRENDING_DESC, POPULARITY_DESC], $isAdult: Boolean = " + this.isAdult + ") { Page(page: $page, perPage: " + this.mediaLimit + ") { pageInfo { total perPage currentPage lastPage hasNextPage } media(sort: $sort, isAdult: $isAdult, type: ANIME) { id idMal season seasonYear format episodes chapters averageScore title { english romaji } coverImage { extraLarge large medium } synonyms nextAiringEpisode { timeUntilAiring episode } } } }", "Trending Now"), TuplesKt.to("query ($page: Int = ###, $seasonYear: Int = " + this.currentYear + ", $sort: [MediaSort] = [TRENDING_DESC, POPULARITY_DESC], $isAdult: Boolean = " + this.isAdult + ") { Page(page: $page, perPage: " + this.mediaLimit + ") { pageInfo { total perPage currentPage lastPage hasNextPage } media(sort: $sort, seasonYear: $seasonYear, season: SPRING, isAdult: $isAdult, type: ANIME) { id idMal season seasonYear format episodes chapters averageScore title { english romaji } coverImage { extraLarge large medium } synonyms nextAiringEpisode { timeUntilAiring episode } } } }", "Popular This Season"), TuplesKt.to("query ($page: Int = ###, $sort: [MediaSort] = [POPULARITY_DESC], $isAdult: Boolean = " + this.isAdult + ") { Page(page: $page, perPage: " + this.mediaLimit + ") { pageInfo { total perPage currentPage lastPage hasNextPage } media(sort: $sort, isAdult: $isAdult, type: ANIME) { id idMal season seasonYear format episodes chapters averageScore title { english romaji } coverImage { extraLarge large medium } synonyms nextAiringEpisode { timeUntilAiring episode } } } }", "All Time Popular"), TuplesKt.to("query ($page: Int = ###, $sort: [MediaSort] = [SCORE_DESC], $isAdult: Boolean = " + this.isAdult + ") { Page(page: $page, perPage: " + this.mediaLimit + ") { pageInfo { total perPage currentPage lastPage hasNextPage } media(sort: $sort, isAdult: $isAdult, type: ANIME) { id idMal season seasonYear format episodes chapters averageScore title { english romaji } coverImage { extraLarge large medium } synonyms nextAiringEpisode { timeUntilAiring episode } } } }", "Top 100 Anime"), TuplesKt.to("Personal", "Personal")});
    }

    public /* synthetic */ StreamPlayAnime(SharedPreferences sharedPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : sharedPreferences);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    public void setSupportedTypes(@NotNull Set<? extends TvType> set) {
        this.supportedTypes = set;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    @NotNull
    public Set<SyncIdName> getSupportedSyncNames() {
        return this.supportedSyncNames;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    private final boolean shouldUseKitsu() {
        String pref;
        SharedPreferences sharedPreferences = this.sharedPref;
        if (sharedPreferences == null || (pref = sharedPreferences.getString("anime_metadata_source", "kitsu")) == null) {
            pref = "kitsu";
        }
        return Intrinsics.areEqual(pref, "kitsu") || (!Intrinsics.areEqual(pref, "anilist") && this.isAnilistDown);
    }

    @NotNull
    protected final String toStringData(@NotNull Object $this$toStringData) {
        return MainAPIKt.getMapper().writeValueAsString($this$toStringData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object anilistAPICall(String query, Continuation<? super AnilistAPIResponse> continuation) throws Exception {
        C00801 c00801;
        Object safe;
        if (continuation instanceof C00801) {
            c00801 = (C00801) continuation;
            if ((c00801.label & Integer.MIN_VALUE) != 0) {
                c00801.label -= Integer.MIN_VALUE;
            } else {
                c00801 = new C00801(continuation);
            }
        } else {
            c00801 = new C00801(continuation);
        }
        C00801 c00802 = c00801;
        Object $result = c00802.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00802.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Map data = MapsKt.mapOf(TuplesKt.to("query", query));
                Requests app = MainActivityKt.getApp();
                String str = this.apiUrl;
                Map<String, String> map = this.headerJSON;
                c00802.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00802.L$1 = SpillingKt.nullOutSpilledVariable(data);
                c00802.label = 1;
                $result = Requests.post$default(app, str, map, (String) null, (Map) null, (Map) null, data, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00802, 65500, (Object) null);
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
        NiceResponse test = (NiceResponse) $result;
        try {
            ResponseParser parser = test.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(test.getText(), Reflection.getOrCreateKotlinClass(AnilistAPIResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        AnilistAPIResponse res = (AnilistAPIResponse) safe;
        if (res == null) {
            throw new Exception("Unable to fetch or parse Anilist api response");
        }
        return res;
    }

    private final SearchResponse toSearchResponse(Media $this$toSearchResponse) {
        String english = $this$toSearchResponse.getTitle().getEnglish();
        if (english == null && (english = $this$toSearchResponse.getTitle().getRomaji()) == null) {
            english = "";
        }
        String title = english;
        String url = getMainUrl() + "/anime/" + $this$toSearchResponse.getId();
        final String posterUrl = $this$toSearchResponse.getCoverImage().getLarge();
        final int rating = $this$toSearchResponse.getAverageScore();
        return MainAPIKt.newAnimeSearchResponse$default(this, title, url, TvType.Anime, false, new Function1() { // from class: com.phisher98.StreamPlayAnime$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return StreamPlayAnime.toSearchResponse$lambda$0(posterUrl, rating, (AnimeSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResponse$lambda$0(String $posterUrl, int $rating, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($posterUrl);
        $this$newAnimeSearchResponse.setScore(Score.Companion.from100(Integer.valueOf($rating)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object toSearchResponseList(MainPageRequest $this$toSearchResponseList, int page, Continuation<? super Pair<? extends List<? extends SearchResponse>, Boolean>> continuation) throws Exception {
        C01051 c01051;
        Object obj;
        Iterable media;
        if (continuation instanceof C01051) {
            c01051 = (C01051) continuation;
            if ((c01051.label & Integer.MIN_VALUE) != 0) {
                c01051.label -= Integer.MIN_VALUE;
            } else {
                c01051 = new C01051(continuation);
            }
        } else {
            c01051 = new C01051(continuation);
        }
        Object $result = c01051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c01051.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String strReplace$default = StringsKt.replace$default($this$toSearchResponseList.getData(), "###", String.valueOf(page), false, 4, (Object) null);
                c01051.L$0 = SpillingKt.nullOutSpilledVariable($this$toSearchResponseList);
                c01051.I$0 = page;
                c01051.label = 1;
                Object objAnilistAPICall = anilistAPICall(strReplace$default, c01051);
                if (objAnilistAPICall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objAnilistAPICall;
                break;
                break;
            case 1:
                int i = c01051.I$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AnilistAPIResponse res = (AnilistAPIResponse) obj;
        AnilistAPIResponse.AnilistData.AnilistPage page2 = res.getData().getPage();
        if (page2 == null || (media = page2.getMedia()) == null) {
            throw new Exception("Unable to read media data");
        }
        Iterable $this$map$iv = media;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Media it = (Media) item$iv$iv;
            destination$iv$iv.add(toSearchResponse(it));
        }
        List data = (List) destination$iv$iv;
        Boolean hasNextPage = res.getData().getPage().getPageInfo().getHasNextPage();
        boolean hasNextPage2 = hasNextPage != null ? hasNextPage.booleanValue() : false;
        return TuplesKt.to(data, Boxing.boxBoolean(hasNextPage2));
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object quickSearch(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C01011 c01011;
        Object objSearch;
        if (continuation instanceof C01011) {
            c01011 = (C01011) continuation;
            if ((c01011.label & Integer.MIN_VALUE) != 0) {
                c01011.label -= Integer.MIN_VALUE;
            } else {
                c01011 = new C01011(continuation);
            }
        } else {
            c01011 = new C01011(continuation);
        }
        Object $result = c01011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c01011.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c01011.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c01011.label = 1;
                objSearch = search(query, 1, c01011);
                if (objSearch == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objSearch = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SearchResponseList searchResponseList = (SearchResponseList) objSearch;
        if (searchResponseList != null) {
            return searchResponseList.getItems();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C01021 c01021;
        Object objSearch;
        if (continuation instanceof C01021) {
            c01021 = (C01021) continuation;
            if ((c01021.label & Integer.MIN_VALUE) != 0) {
                c01021.label -= Integer.MIN_VALUE;
            } else {
                c01021 = new C01021(continuation);
            }
        } else {
            c01021 = new C01021(continuation);
        }
        Object $result = c01021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c01021.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c01021.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c01021.label = 1;
                objSearch = search(query, 1, c01021);
                if (objSearch == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objSearch = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SearchResponseList searchResponseList = (SearchResponseList) objSearch;
        if (searchResponseList != null) {
            return searchResponseList.getItems();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0134  */
    /* JADX WARN: Code duplicated, block: B:46:0x013d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0146  */
    /* JADX WARN: Code duplicated, block: B:51:0x0165 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x0166  */
    /* JADX WARN: Code duplicated, block: B:54:0x0179  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C01032 c01032;
        Object objAnilistAPICall;
        Object obj;
        SharedPreferences sharedPreferences;
        String string;
        Object objSearch;
        Throwable e;
        int page2;
        AnilistAPIResponse.AnilistData.AnilistPage page3;
        Iterable media;
        String query2 = query;
        int page4 = page;
        if (continuation instanceof C01032) {
            c01032 = (C01032) continuation;
            if ((c01032.label & Integer.MIN_VALUE) != 0) {
                c01032.label -= Integer.MIN_VALUE;
            } else {
                c01032 = new C01032(continuation);
            }
        } else {
            c01032 = new C01032(continuation);
        }
        C01032 c01033 = c01032;
        Object $result = c01033.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c01033.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (shouldUseKitsu()) {
                    c01033.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                    c01033.I$0 = page4;
                    c01033.label = 1;
                    Object objSearch2 = StreamPlayKitsuHelper.INSTANCE.search(this, query2, page4, c01033);
                    if (objSearch2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objSearch2;
                    return MainAPIKt.toNewSearchResponseList$default((List) obj, (Boolean) null, 1, (Object) null);
                }
                try {
                    String str = "query ($search: String = \"" + query2 + "\") { Page(page: " + page4 + ", perPage: " + this.mediaLimit + ") { pageInfo { total perPage currentPage lastPage hasNextPage } media(search: $search, isAdult: " + this.isAdult + ", type: ANIME) { id idMal season seasonYear format episodes chapters title { english romaji } coverImage { extraLarge large medium } synonyms nextAiringEpisode { timeUntilAiring episode } } } }";
                    c01033.L$0 = query2;
                    c01033.I$0 = page4;
                    c01033.label = 2;
                    objAnilistAPICall = anilistAPICall(str, c01033);
                    if (objAnilistAPICall == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    AnilistAPIResponse res = (AnilistAPIResponse) objAnilistAPICall;
                    page3 = res.getData().getPage();
                    if (page3 != null || (media = page3.getMedia()) == null) {
                        return null;
                    }
                    Iterable $this$map$iv = media;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        Media it = (Media) item$iv$iv;
                        destination$iv$iv.add(toSearchResponse(it));
                    }
                    return MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv, (Boolean) null, 1, (Object) null);
                } catch (Throwable th) {
                    e = th;
                    sharedPreferences = this.sharedPref;
                    if (sharedPreferences != null) {
                        string = sharedPreferences.getString("anime_metadata_source", "kitsu");
                    } else {
                        string = null;
                    }
                    if (!Intrinsics.areEqual(string, "anilist")) {
                        return null;
                    }
                    this.isAnilistDown = true;
                    c01033.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                    c01033.L$1 = SpillingKt.nullOutSpilledVariable(e);
                    c01033.I$0 = page4;
                    c01033.label = 3;
                    objSearch = StreamPlayKitsuHelper.INSTANCE.search(this, query2, page4, c01033);
                    if (objSearch == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i = page4;
                    e = e;
                    page2 = i;
                    return MainAPIKt.toNewSearchResponseList$default((List) objSearch, (Boolean) null, 1, (Object) null);
                }
            case 1:
                int i2 = c01033.I$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                return MainAPIKt.toNewSearchResponseList$default((List) obj, (Boolean) null, 1, (Object) null);
            case 2:
                page4 = c01033.I$0;
                query2 = (String) c01033.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objAnilistAPICall = $result;
                    AnilistAPIResponse res2 = (AnilistAPIResponse) objAnilistAPICall;
                    page3 = res2.getData().getPage();
                    if (page3 != null) {
                        break;
                    }
                    return null;
                } catch (Throwable th2) {
                    e = th2;
                    sharedPreferences = this.sharedPref;
                    if (sharedPreferences != null) {
                        string = sharedPreferences.getString("anime_metadata_source", "kitsu");
                    } else {
                        string = null;
                    }
                    if (!Intrinsics.areEqual(string, "anilist")) {
                        return null;
                    }
                    this.isAnilistDown = true;
                    c01033.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                    c01033.L$1 = SpillingKt.nullOutSpilledVariable(e);
                    c01033.I$0 = page4;
                    c01033.label = 3;
                    objSearch = StreamPlayKitsuHelper.INSTANCE.search(this, query2, page4, c01033);
                    if (objSearch == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i3 = page4;
                    e = e;
                    page2 = i3;
                    return MainAPIKt.toNewSearchResponseList$default((List) objSearch, (Boolean) null, 1, (Object) null);
                }
            case 3:
                page2 = c01033.I$0;
                e = (Throwable) c01033.L$1;
                ResultKt.throwOnFailure($result);
                objSearch = $result;
                return MainAPIKt.toNewSearchResponseList$default((List) objSearch, (Boolean) null, 1, (Object) null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:110:0x017a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0109  */
    /* JADX WARN: Code duplicated, block: B:40:0x0121  */
    /* JADX WARN: Code duplicated, block: B:41:0x0128  */
    /* JADX WARN: Code duplicated, block: B:43:0x0134  */
    /* JADX WARN: Code duplicated, block: B:44:0x013b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0174  */
    /* JADX WARN: Code duplicated, block: B:57:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:58:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:66:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:67:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:70:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:72:0x0207 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:73:0x0208  */
    /* JADX WARN: Code duplicated, block: B:75:0x022a  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:87:0x0267  */
    /* JADX WARN: Code duplicated, block: B:88:0x026c  */
    /* JADX WARN: Code duplicated, block: B:91:0x0275  */
    /* JADX WARN: Code duplicated, block: B:93:0x029f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:94:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:97:0x02c4  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws Exception {
        C00811 c00811;
        boolean z;
        Object catalog;
        Object searchResponseList;
        Object obj;
        int page2;
        MainPageRequest request2;
        Collection destination$iv$iv;
        SyncAPI.LibraryList it;
        UiText name;
        Activity activity;
        HomePageList homePageList;
        SharedPreferences sharedPreferences;
        String string;
        Object searchResponseList2;
        Throwable e;
        int page3;
        boolean hasNext;
        SharedPreferences sharedPreferences2;
        String string2;
        Object catalog2;
        int page4;
        int page5 = page;
        MainPageRequest request3 = request;
        if (continuation instanceof C00811) {
            c00811 = (C00811) continuation;
            if ((c00811.label & Integer.MIN_VALUE) != 0) {
                c00811.label -= Integer.MIN_VALUE;
            } else {
                c00811 = new C00811(continuation);
            }
        } else {
            c00811 = new C00811(continuation);
        }
        C00811 c00812 = c00811;
        Object $result = c00812.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        HomePageList homePageList2 = null;
        switch (c00812.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DonationManager.INSTANCE.checkAndShow(getName());
                if (StringsKt.contains$default(request3.getName(), "Personal", false, 2, (Object) null)) {
                    if (this.repo.authUser() == null) {
                        return MainAPIKt.newHomePageResponse("Login required for personal content.", CollectionsKt.emptyList(), Boxing.boxBoolean(false));
                    }
                    SyncRepo syncRepo = this.repo;
                    c00812.L$0 = request3;
                    c00812.I$0 = page5;
                    c00812.label = 1;
                    Object obj2 = syncRepo.library-IoAF18A(c00812);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = obj2;
                    page2 = page5;
                    request2 = request3;
                    ResultKt.throwOnFailure(obj);
                    Intrinsics.checkNotNull(obj);
                    Iterable $this$mapNotNull$iv = ((SyncAPI.LibraryMetadata) obj).getAllLibraryLists();
                    destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        it = (SyncAPI.LibraryList) element$iv$iv$iv;
                        if (it.getItems().isEmpty()) {
                            homePageList = homePageList2;
                        } else {
                            name = it.getName();
                            activity = CommonActivity.INSTANCE.getActivity();
                            if (activity == null) {
                                homePageList = null;
                            } else {
                                String libraryName = name.asString(activity);
                                homePageList = new HomePageList(request2.getName() + ": " + libraryName, it.getItems(), false, 4, (DefaultConstructorMarker) null);
                            }
                        }
                        if (homePageList != null) {
                            destination$iv$iv.add(homePageList);
                        }
                        page2 = page2;
                        homePageList2 = null;
                    }
                    List homePageList3 = (List) destination$iv$iv;
                    return MainAPIKt.newHomePageResponse(homePageList3, Boxing.boxBoolean(false));
                }
                z = false;
                if (!shouldUseKitsu()) {
                    try {
                        c00812.L$0 = request3;
                        c00812.I$0 = page5;
                        c00812.label = 4;
                        searchResponseList = toSearchResponseList(request3, page5, c00812);
                        if (searchResponseList == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Pair data = (Pair) searchResponseList;
                        return MainAPIKt.newHomePageResponse(request3.getName(), (List) data.getFirst(), (Boolean) data.getSecond());
                    } catch (Throwable th) {
                        e = th;
                        sharedPreferences2 = this.sharedPref;
                        if (sharedPreferences2 != null) {
                            string2 = sharedPreferences2.getString("anime_metadata_source", "kitsu");
                        } else {
                            string2 = null;
                        }
                        if (!Intrinsics.areEqual(string2, "anilist")) {
                            throw e;
                        }
                        this.isAnilistDown = true;
                        String catalogId = StreamPlayKitsuHelper.INSTANCE.mapSectionToKitsuCatalog(request3.getName());
                        c00812.L$0 = request3;
                        c00812.L$1 = SpillingKt.nullOutSpilledVariable(e);
                        c00812.L$2 = SpillingKt.nullOutSpilledVariable(catalogId);
                        c00812.I$0 = page5;
                        c00812.label = 5;
                        catalog2 = StreamPlayKitsuHelper.INSTANCE.getCatalog(this, catalogId, page5, c00812);
                        if (catalog2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        page4 = page5;
                        Pair pair = (Pair) catalog2;
                        List items = (List) pair.component1();
                        boolean hasNext2 = ((Boolean) pair.component2()).booleanValue();
                        return MainAPIKt.newHomePageResponse(request3.getName(), items, Boxing.boxBoolean(hasNext2));
                    }
                }
                try {
                    String catalogId2 = StreamPlayKitsuHelper.INSTANCE.mapSectionToKitsuCatalog(request3.getName());
                    c00812.L$0 = request3;
                    c00812.L$1 = SpillingKt.nullOutSpilledVariable(catalogId2);
                    c00812.I$0 = page5;
                    c00812.label = 2;
                    catalog = StreamPlayKitsuHelper.INSTANCE.getCatalog(this, catalogId2, page5, c00812);
                    if (catalog == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    try {
                        Pair pair2 = (Pair) catalog;
                        List items2 = (List) pair2.component1();
                        hasNext = ((Boolean) pair2.component2()).booleanValue();
                        String name2 = request3.getName();
                        if (hasNext) {
                            z2 = false;
                        }
                        return MainAPIKt.newHomePageResponse(name2, items2, Boxing.boxBoolean(z2));
                    } catch (Throwable th2) {
                        e = th2;
                        sharedPreferences = this.sharedPref;
                        if (sharedPreferences != null) {
                            string = sharedPreferences.getString("anime_metadata_source", "kitsu");
                        } else {
                            string = null;
                        }
                        if (Intrinsics.areEqual(string, "kitsu")) {
                            return MainAPIKt.newHomePageResponse(request3.getName(), CollectionsKt.emptyList(), Boxing.boxBoolean(z));
                        }
                        c00812.L$0 = request3;
                        c00812.L$1 = SpillingKt.nullOutSpilledVariable(e);
                        c00812.I$0 = page5;
                        c00812.label = 3;
                        searchResponseList2 = toSearchResponseList(request3, page5, c00812);
                        if (searchResponseList2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int i = page5;
                        e = e;
                        page3 = i;
                        Pair data2 = (Pair) searchResponseList2;
                        return MainAPIKt.newHomePageResponse(request3.getName(), (List) data2.getFirst(), (Boolean) data2.getSecond());
                    }
                } catch (Throwable th3) {
                    e = th3;
                    sharedPreferences = this.sharedPref;
                    if (sharedPreferences != null) {
                        string = sharedPreferences.getString("anime_metadata_source", "kitsu");
                    } else {
                        string = null;
                    }
                    if (Intrinsics.areEqual(string, "kitsu")) {
                        return MainAPIKt.newHomePageResponse(request3.getName(), CollectionsKt.emptyList(), Boxing.boxBoolean(z));
                    }
                    c00812.L$0 = request3;
                    c00812.L$1 = SpillingKt.nullOutSpilledVariable(e);
                    c00812.I$0 = page5;
                    c00812.label = 3;
                    searchResponseList2 = toSearchResponseList(request3, page5, c00812);
                    if (searchResponseList2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i2 = page5;
                    e = e;
                    page3 = i2;
                    Pair data3 = (Pair) searchResponseList2;
                    return MainAPIKt.newHomePageResponse(request3.getName(), (List) data3.getFirst(), (Boolean) data3.getSecond());
                }
            case 1:
                page2 = c00812.I$0;
                request2 = (MainPageRequest) c00812.L$0;
                ResultKt.throwOnFailure($result);
                obj = ((Result) $result).unbox-impl();
                ResultKt.throwOnFailure(obj);
                Intrinsics.checkNotNull(obj);
                Iterable $this$mapNotNull$iv2 = ((SyncAPI.LibraryMetadata) obj).getAllLibraryLists();
                destination$iv$iv = new ArrayList();
                while (r15.hasNext()) {
                    it = (SyncAPI.LibraryList) element$iv$iv$iv;
                    if (it.getItems().isEmpty()) {
                        homePageList = homePageList2;
                    } else {
                        name = it.getName();
                        activity = CommonActivity.INSTANCE.getActivity();
                        if (activity == null) {
                            homePageList = null;
                        } else {
                            String libraryName2 = name.asString(activity);
                            homePageList = new HomePageList(request2.getName() + ": " + libraryName2, it.getItems(), false, 4, (DefaultConstructorMarker) null);
                        }
                    }
                    if (homePageList != null) {
                        destination$iv$iv.add(homePageList);
                    }
                    page2 = page2;
                    homePageList2 = null;
                }
                List homePageList4 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(homePageList4, Boxing.boxBoolean(false));
            case 2:
                page5 = c00812.I$0;
                request3 = (MainPageRequest) c00812.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    catalog = $result;
                    z = false;
                    Pair pair3 = (Pair) catalog;
                    List items3 = (List) pair3.component1();
                    hasNext = ((Boolean) pair3.component2()).booleanValue();
                    String name3 = request3.getName();
                    if (hasNext) {
                        z2 = false;
                    }
                    return MainAPIKt.newHomePageResponse(name3, items3, Boxing.boxBoolean(z2));
                } catch (Throwable th4) {
                    e = th4;
                    z = false;
                    sharedPreferences = this.sharedPref;
                    if (sharedPreferences != null) {
                        string = sharedPreferences.getString("anime_metadata_source", "kitsu");
                    } else {
                        string = null;
                    }
                    if (Intrinsics.areEqual(string, "kitsu")) {
                        return MainAPIKt.newHomePageResponse(request3.getName(), CollectionsKt.emptyList(), Boxing.boxBoolean(z));
                    }
                    c00812.L$0 = request3;
                    c00812.L$1 = SpillingKt.nullOutSpilledVariable(e);
                    c00812.I$0 = page5;
                    c00812.label = 3;
                    searchResponseList2 = toSearchResponseList(request3, page5, c00812);
                    if (searchResponseList2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i3 = page5;
                    e = e;
                    page3 = i3;
                    Pair data4 = (Pair) searchResponseList2;
                    return MainAPIKt.newHomePageResponse(request3.getName(), (List) data4.getFirst(), (Boolean) data4.getSecond());
                }
            case 3:
                page3 = c00812.I$0;
                e = (Throwable) c00812.L$1;
                request3 = (MainPageRequest) c00812.L$0;
                ResultKt.throwOnFailure($result);
                searchResponseList2 = $result;
                Pair data5 = (Pair) searchResponseList2;
                return MainAPIKt.newHomePageResponse(request3.getName(), (List) data5.getFirst(), (Boolean) data5.getSecond());
            case 4:
                page5 = c00812.I$0;
                request3 = (MainPageRequest) c00812.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    searchResponseList = $result;
                    Pair data6 = (Pair) searchResponseList;
                    return MainAPIKt.newHomePageResponse(request3.getName(), (List) data6.getFirst(), (Boolean) data6.getSecond());
                } catch (Throwable th5) {
                    e = th5;
                    sharedPreferences2 = this.sharedPref;
                    if (sharedPreferences2 != null) {
                        string2 = sharedPreferences2.getString("anime_metadata_source", "kitsu");
                    } else {
                        string2 = null;
                    }
                    if (!Intrinsics.areEqual(string2, "anilist")) {
                        throw e;
                    }
                    this.isAnilistDown = true;
                    String catalogId3 = StreamPlayKitsuHelper.INSTANCE.mapSectionToKitsuCatalog(request3.getName());
                    c00812.L$0 = request3;
                    c00812.L$1 = SpillingKt.nullOutSpilledVariable(e);
                    c00812.L$2 = SpillingKt.nullOutSpilledVariable(catalogId3);
                    c00812.I$0 = page5;
                    c00812.label = 5;
                    catalog2 = StreamPlayKitsuHelper.INSTANCE.getCatalog(this, catalogId3, page5, c00812);
                    if (catalog2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    page4 = page5;
                    Pair pair4 = (Pair) catalog2;
                    List items4 = (List) pair4.component1();
                    boolean hasNext3 = ((Boolean) pair4.component2()).booleanValue();
                    return MainAPIKt.newHomePageResponse(request3.getName(), items4, Boxing.boxBoolean(hasNext3));
                }
            case 5:
                page4 = c00812.I$0;
                request3 = (MainPageRequest) c00812.L$0;
                ResultKt.throwOnFailure($result);
                catalog2 = $result;
                Pair pair5 = (Pair) catalog2;
                List items5 = (List) pair5.component1();
                boolean hasNext4 = ((Boolean) pair5.component2()).booleanValue();
                return MainAPIKt.newHomePageResponse(request3.getName(), items5, Boxing.boxBoolean(hasNext4));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:48:0x00fe A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:52:0x0108  */
    /* JADX WARN: Code duplicated, block: B:65:0x0129  */
    /* JADX WARN: Code duplicated, block: B:68:0x0135  */
    /* JADX WARN: Code duplicated, block: B:70:0x0154 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:71:0x0155  */
    /* JADX WARN: Code duplicated, block: B:74:0x015e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws Exception {
        C00821 c00821;
        String id;
        int i;
        Object objLoadFromAnilist;
        String id2;
        int i2;
        Object objLoadFromKitsu;
        String id3;
        int i3;
        SharedPreferences sharedPreferences;
        Object objLoadFromAnilist2;
        String id4;
        int i4;
        SharedPreferences sharedPreferences2;
        Object objLoadFromKitsu2;
        String id5;
        int i5;
        if (continuation instanceof C00821) {
            c00821 = (C00821) continuation;
            if ((c00821.label & Integer.MIN_VALUE) != 0) {
                c00821.label -= Integer.MIN_VALUE;
            } else {
                c00821 = new C00821(continuation);
            }
        } else {
            c00821 = new C00821(continuation);
        }
        Object $result = c00821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00821.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                id = StringsKt.substringAfterLast$default(StringsKt.removeSuffix(url, "/"), "/", (String) null, 2, (Object) null);
                i = (StringsKt.contains$default(url, "kitsu", false, 2, (Object) null) || StringsKt.startsWith$default(id, "kitsu:", false, 2, (Object) null) || shouldUseKitsu()) ? 1 : 0;
                if (i != 0) {
                    try {
                        c00821.L$0 = url;
                        c00821.L$1 = id;
                        c00821.I$0 = i;
                        c00821.label = 1;
                        objLoadFromKitsu = loadFromKitsu(url, id, c00821);
                        if (objLoadFromKitsu == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        id3 = id;
                        i3 = i;
                        try {
                            return (LoadResponse) objLoadFromKitsu;
                        } catch (Throwable th) {
                            i = i3;
                            id = id3;
                            e = th;
                            sharedPreferences = this.sharedPref;
                            if (Intrinsics.areEqual(sharedPreferences != null ? sharedPreferences.getString("anime_metadata_source", "kitsu") : null, "kitsu")) {
                                throw e;
                            }
                            c00821.L$0 = SpillingKt.nullOutSpilledVariable(url);
                            c00821.L$1 = SpillingKt.nullOutSpilledVariable(id);
                            c00821.L$2 = SpillingKt.nullOutSpilledVariable(e);
                            c00821.I$0 = i;
                            c00821.label = 2;
                            objLoadFromAnilist2 = loadFromAnilist(url, id, c00821);
                            if (objLoadFromAnilist2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            id4 = id;
                            i4 = i;
                            return (LoadResponse) objLoadFromAnilist2;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        sharedPreferences = this.sharedPref;
                        if (Intrinsics.areEqual(sharedPreferences != null ? sharedPreferences.getString("anime_metadata_source", "kitsu") : null, "kitsu")) {
                            throw e;
                        }
                        c00821.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        c00821.L$1 = SpillingKt.nullOutSpilledVariable(id);
                        c00821.L$2 = SpillingKt.nullOutSpilledVariable(e);
                        c00821.I$0 = i;
                        c00821.label = 2;
                        objLoadFromAnilist2 = loadFromAnilist(url, id, c00821);
                        if (objLoadFromAnilist2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        id4 = id;
                        i4 = i;
                        return (LoadResponse) objLoadFromAnilist2;
                    }
                }
                try {
                    c00821.L$0 = url;
                    c00821.L$1 = id;
                    c00821.I$0 = i;
                    c00821.label = 3;
                    objLoadFromAnilist = loadFromAnilist(url, id, c00821);
                    if (objLoadFromAnilist == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    id2 = id;
                    i2 = i;
                    try {
                        return (LoadResponse) objLoadFromAnilist;
                    } catch (Throwable th3) {
                        i = i2;
                        id = id2;
                        e = th3;
                        sharedPreferences2 = this.sharedPref;
                        if (Intrinsics.areEqual(sharedPreferences2 != null ? sharedPreferences2.getString("anime_metadata_source", "kitsu") : null, "anilist")) {
                            throw e;
                        }
                        this.isAnilistDown = true;
                        c00821.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        c00821.L$1 = SpillingKt.nullOutSpilledVariable(id);
                        c00821.L$2 = SpillingKt.nullOutSpilledVariable(e);
                        c00821.I$0 = i;
                        c00821.label = 4;
                        objLoadFromKitsu2 = loadFromKitsu(url, id, c00821);
                        if (objLoadFromKitsu2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        id5 = id;
                        i5 = i;
                        return (LoadResponse) objLoadFromKitsu2;
                    }
                } catch (Throwable th4) {
                    e = th4;
                    sharedPreferences2 = this.sharedPref;
                    if (Intrinsics.areEqual(sharedPreferences2 != null ? sharedPreferences2.getString("anime_metadata_source", "kitsu") : null, "anilist")) {
                        throw e;
                    }
                    this.isAnilistDown = true;
                    c00821.L$0 = SpillingKt.nullOutSpilledVariable(url);
                    c00821.L$1 = SpillingKt.nullOutSpilledVariable(id);
                    c00821.L$2 = SpillingKt.nullOutSpilledVariable(e);
                    c00821.I$0 = i;
                    c00821.label = 4;
                    objLoadFromKitsu2 = loadFromKitsu(url, id, c00821);
                    if (objLoadFromKitsu2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    id5 = id;
                    i5 = i;
                    return (LoadResponse) objLoadFromKitsu2;
                }
            case 1:
                i3 = c00821.I$0;
                String id6 = (String) c00821.L$1;
                url = (String) c00821.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    id3 = id6;
                    objLoadFromKitsu = $result;
                    return (LoadResponse) objLoadFromKitsu;
                } catch (Throwable th5) {
                    e = th5;
                    i = i3;
                    id = id6;
                    sharedPreferences = this.sharedPref;
                    if (Intrinsics.areEqual(sharedPreferences != null ? sharedPreferences.getString("anime_metadata_source", "kitsu") : null, "kitsu")) {
                        throw e;
                    }
                    c00821.L$0 = SpillingKt.nullOutSpilledVariable(url);
                    c00821.L$1 = SpillingKt.nullOutSpilledVariable(id);
                    c00821.L$2 = SpillingKt.nullOutSpilledVariable(e);
                    c00821.I$0 = i;
                    c00821.label = 2;
                    objLoadFromAnilist2 = loadFromAnilist(url, id, c00821);
                    if (objLoadFromAnilist2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    id4 = id;
                    i4 = i;
                    return (LoadResponse) objLoadFromAnilist2;
                }
            case 2:
                i4 = c00821.I$0;
                String id7 = (String) c00821.L$1;
                ResultKt.throwOnFailure($result);
                id4 = id7;
                objLoadFromAnilist2 = $result;
                return (LoadResponse) objLoadFromAnilist2;
            case 3:
                i2 = c00821.I$0;
                String id8 = (String) c00821.L$1;
                url = (String) c00821.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    id2 = id8;
                    objLoadFromAnilist = $result;
                    return (LoadResponse) objLoadFromAnilist;
                } catch (Throwable th6) {
                    e = th6;
                    i = i2;
                    id = id8;
                    sharedPreferences2 = this.sharedPref;
                    if (Intrinsics.areEqual(sharedPreferences2 != null ? sharedPreferences2.getString("anime_metadata_source", "kitsu") : null, "anilist")) {
                        throw e;
                    }
                    this.isAnilistDown = true;
                    c00821.L$0 = SpillingKt.nullOutSpilledVariable(url);
                    c00821.L$1 = SpillingKt.nullOutSpilledVariable(id);
                    c00821.L$2 = SpillingKt.nullOutSpilledVariable(e);
                    c00821.I$0 = i;
                    c00821.label = 4;
                    objLoadFromKitsu2 = loadFromKitsu(url, id, c00821);
                    if (objLoadFromKitsu2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    id5 = id;
                    i5 = i;
                    return (LoadResponse) objLoadFromKitsu2;
                }
            case 4:
                i5 = c00821.I$0;
                String id9 = (String) c00821.L$1;
                ResultKt.throwOnFailure($result);
                id5 = id9;
                objLoadFromKitsu2 = $result;
                return (LoadResponse) objLoadFromKitsu2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:0x0555  */
    /* JADX WARN: Code duplicated, block: B:107:0x0569  */
    /* JADX WARN: Code duplicated, block: B:108:0x056e  */
    /* JADX WARN: Code duplicated, block: B:111:0x057a  */
    /* JADX WARN: Code duplicated, block: B:112:0x0581  */
    /* JADX WARN: Code duplicated, block: B:116:0x0607  */
    /* JADX WARN: Code duplicated, block: B:118:0x062a  */
    /* JADX WARN: Code duplicated, block: B:119:0x0631  */
    /* JADX WARN: Code duplicated, block: B:122:0x064d  */
    /* JADX WARN: Code duplicated, block: B:123:0x0652  */
    /* JADX WARN: Code duplicated, block: B:128:0x06f4  */
    /* JADX WARN: Code duplicated, block: B:130:0x06fc  */
    /* JADX WARN: Code duplicated, block: B:133:0x0712  */
    /* JADX WARN: Code duplicated, block: B:134:0x0719  */
    /* JADX WARN: Code duplicated, block: B:137:0x0735  */
    /* JADX WARN: Code duplicated, block: B:138:0x073a  */
    /* JADX WARN: Code duplicated, block: B:142:0x07bd  */
    /* JADX WARN: Code duplicated, block: B:144:0x0874 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:145:0x0875  */
    /* JADX WARN: Code duplicated, block: B:147:0x088e  */
    /* JADX WARN: Code duplicated, block: B:149:0x0964 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:150:0x0965  */
    /* JADX WARN: Code duplicated, block: B:153:0x099d  */
    /* JADX WARN: Code duplicated, block: B:155:0x048a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x047e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x027f  */
    /* JADX WARN: Code duplicated, block: B:26:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:27:0x02af  */
    /* JADX WARN: Code duplicated, block: B:30:0x02d6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:34:0x0360 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x0361  */
    /* JADX WARN: Code duplicated, block: B:38:0x0379  */
    /* JADX WARN: Code duplicated, block: B:43:0x038a  */
    /* JADX WARN: Code duplicated, block: B:45:0x038e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0399  */
    /* JADX WARN: Code duplicated, block: B:51:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:52:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:55:0x040f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x0410  */
    /* JADX WARN: Code duplicated, block: B:60:0x0460  */
    /* JADX WARN: Code duplicated, block: B:62:0x047a  */
    /* JADX WARN: Code duplicated, block: B:67:0x04bf  */
    /* JADX WARN: Code duplicated, block: B:69:0x04d1  */
    /* JADX WARN: Code duplicated, block: B:71:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:72:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:73:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:78:0x0505  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:84:0x0519  */
    /* JADX WARN: Code duplicated, block: B:86:0x051c  */
    /* JADX WARN: Code duplicated, block: B:91:0x052d A[PHI: r5
      0x052d: PHI (r5v35 java.lang.String) = (r5v15 java.lang.String), (r5v17 java.lang.String), (r5v38 java.lang.String) binds: [B:97:0x0542, B:103:0x0557, B:89:0x052a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:92:0x052f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x0531  */
    /* JADX WARN: Code duplicated, block: B:96:0x0540  */
    /* JADX WARN: Code duplicated, block: B:98:0x0544  */
    /* JADX WARN: Code duplicated, block: B:99:0x0546  */
    public final Object loadFromAnilist(String url, String id, Continuation<? super LoadResponse> continuation) throws Exception {
        C00831 c00831;
        Object obj;
        String url2;
        AnilistAPIResponse.anilistMedia media;
        AnilistAPIResponse.anilistMedia data;
        String anititle;
        int aniyear;
        String posterurl;
        String backgroundUrl;
        String format;
        TvType anitype;
        Object objTmdbToAnimeId;
        String url3;
        int aniyear2;
        String backgroundUrl2;
        String backgroundUrl3;
        TvType anitype2;
        AniIds ids;
        String jpTitle;
        TvType anitype3;
        Object obj2;
        C00831 c00832;
        TvType anitype4;
        String posterurl2;
        String anititle2;
        AniIds ids2;
        String anititle3;
        String jpTitle2;
        Object obj3;
        int aniyear3;
        AnilistAPIResponse.anilistMedia data2;
        String url4;
        MetaAnimeData animeMetaData;
        Integer tmdbid;
        String kitsuid;
        String kitsuid2;
        Integer tmdbid2;
        TvType anitype5;
        TvType type;
        String backgroundUrl4;
        String jpTitle3;
        String id2;
        int i;
        AniIds ids3;
        TvType type2;
        C00831 c00833;
        String backgroundUrl5;
        Object objFetchTmdbLogoUrl;
        AnilistAPIResponse.anilistMedia data3;
        String posterurl3;
        String backgroundUrl6;
        String posterurl4;
        TvType anitype6;
        AniIds ids4;
        MetaAnimeData animeMetaData2;
        String jpTitle4;
        String url5;
        int aniyear4;
        TvType type3;
        String kitsuid3;
        Integer tmdbid3;
        MetaMappings mappings;
        MetaMappings mappings2;
        String themoviedbId;
        String logoUrl;
        int totalEps;
        LinkedHashMap result$iv;
        String id3;
        String kitsuid4;
        LinkedHashMap destination$iv$iv;
        Iterator it;
        int iIntValue;
        int $i$f$associateWith;
        LinkedHashMap result$iv2;
        LinkedHashMap epMetaMap;
        String url6;
        final String fallbackPoster;
        String str;
        Map<String, String> titles;
        Map<String, String> titles2;
        final String fallbackTitle;
        Integer num;
        int anidbEid;
        Integer intOrNull;
        String href;
        Iterable $this$map$iv;
        Integer tmdbid4;
        TvType type4;
        Collection destination$iv$iv2;
        Iterable $this$mapTo$iv$iv;
        int $i$f$mapTo;
        IntIterator it2;
        Map epMetaMap2;
        TvType anitype7;
        List episodes;
        Collection destination$iv$iv3;
        int index$iv$iv;
        List episodes2;
        List episodesDub;
        String fallbackTitle2;
        String logoUrl2;
        int anidbEid2;
        String syncMetaData;
        String url7;
        Object objNewAnimeLoadResponse$default;
        List episodes3;
        List episodesDub2;
        Object obj4;
        int totalEps2;
        int anidbEid3;
        String href2;
        String fallbackTitle3;
        Map anidbEidMap;
        String logoUrl3;
        String fallbackPoster2;
        String anititle4;
        TvType type5;
        String syncMetaData2;
        Object objNewMovieLoadResponse;
        Integer intOrNull2;
        Integer num2;
        int iIntValue2;
        Integer intOrNull3;
        Integer num3;
        int iIntValue3;
        Map<String, String> titles3;
        List<ImageData> images;
        ImageData imageData;
        int it3;
        String url8;
        MetaEpisode metaEpisode;
        Map<String, MetaEpisode> episodes4;
        Integer anidbEid4;
        String id4 = id;
        if (continuation instanceof C00831) {
            c00831 = (C00831) continuation;
            if ((c00831.label & Integer.MIN_VALUE) != 0) {
                c00831.label -= Integer.MIN_VALUE;
            } else {
                c00831 = new C00831(continuation);
            }
        } else {
            c00831 = new C00831(continuation);
        }
        C00831 c00834 = c00831;
        Object $result = c00834.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00834.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00834.L$0 = url;
                c00834.L$1 = id4;
                c00834.label = 1;
                Object objAnilistAPICall = anilistAPICall("query ($id: Int = " + id4 + ") { Media(id: $id, type: ANIME) { id title { romaji english } startDate { year } genres description averageScore status bannerImage coverImage { extraLarge large medium } bannerImage episodes format nextAiringEpisode { episode } airingSchedule { nodes { episode } } recommendations { edges { node { id mediaRecommendation { id title { romaji english } coverImage { extraLarge large medium } } } } } } }", c00834);
                if (objAnilistAPICall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objAnilistAPICall;
                url2 = url;
                media = ((AnilistAPIResponse) obj).getData().getMedia();
                if (media != null) {
                    throw new Exception("Unable to fetch media details");
                }
                data = media;
                anititle = data.m46getTitle();
                aniyear = data.getStartDate().getYear();
                posterurl = data.getCoverImage().getExtraLarge();
                backgroundUrl = data.getBannerImage();
                format = data.getFormat();
                Intrinsics.checkNotNull(format);
                if (StringsKt.contains(format, "MOVIE", true)) {
                    anitype = TvType.AnimeMovie;
                } else {
                    anitype = TvType.TvSeries;
                }
                Integer numBoxInt = Boxing.boxInt(aniyear);
                c00834.L$0 = url2;
                c00834.L$1 = id4;
                c00834.L$2 = data;
                c00834.L$3 = SpillingKt.nullOutSpilledVariable(anititle);
                c00834.L$4 = posterurl;
                c00834.L$5 = backgroundUrl;
                c00834.L$6 = SpillingKt.nullOutSpilledVariable(anitype);
                c00834.I$0 = aniyear;
                c00834.label = 2;
                objTmdbToAnimeId = tmdbToAnimeId(anititle, numBoxInt, anitype, c00834);
                if (objTmdbToAnimeId == coroutine_suspended) {
                    return coroutine_suspended;
                }
                TvType tvType = anitype;
                url3 = url2;
                aniyear2 = aniyear;
                backgroundUrl2 = backgroundUrl;
                backgroundUrl3 = anititle;
                anitype2 = tvType;
                ids = (AniIds) objTmdbToAnimeId;
                jpTitle = data.getTitle().getRomaji();
                anitype3 = anitype2;
                c00834.L$0 = url3;
                c00834.L$1 = id4;
                c00834.L$2 = data;
                c00834.L$3 = SpillingKt.nullOutSpilledVariable(backgroundUrl3);
                c00834.L$4 = posterurl;
                c00834.L$5 = backgroundUrl2;
                c00834.L$6 = SpillingKt.nullOutSpilledVariable(anitype3);
                c00834.L$7 = ids;
                c00834.L$8 = jpTitle;
                c00834.I$0 = aniyear2;
                c00834.label = 3;
                obj2 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?anilist_id=" + id4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00834, 4094, (Object) null);
                c00832 = c00834;
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anitype4 = anitype3;
                posterurl2 = posterurl;
                anititle2 = backgroundUrl3;
                ids2 = ids;
                anititle3 = backgroundUrl2;
                jpTitle2 = jpTitle;
                obj3 = obj2;
                aniyear3 = aniyear2;
                data2 = data;
                url4 = url3;
                String syncMetaData3 = ((NiceResponse) obj3).getText();
                animeMetaData = StreamPlayUtilsKt.parseAnimeData(syncMetaData3);
                if (animeMetaData != null || (mappings2 = animeMetaData.getMappings()) == null || (themoviedbId = mappings2.getThemoviedbId()) == null) {
                    tmdbid = null;
                } else {
                    tmdbid = StringsKt.toIntOrNull(themoviedbId);
                }
                if (animeMetaData != null || (mappings = animeMetaData.getMappings()) == null) {
                    kitsuid = null;
                } else {
                    kitsuid = mappings.getKitsuid();
                }
                kitsuid2 = kitsuid;
                tmdbid2 = tmdbid;
                anitype5 = anitype4;
                if (StringsKt.contains(data2.getFormat(), "Movie", true)) {
                    type = TvType.Movie;
                } else {
                    type = TvType.TvSeries;
                }
                c00832.L$0 = url4;
                c00832.L$1 = id4;
                c00832.L$2 = data2;
                c00832.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                c00832.L$4 = posterurl2;
                c00832.L$5 = anititle3;
                c00832.L$6 = SpillingKt.nullOutSpilledVariable(anitype5);
                c00832.L$7 = ids2;
                c00832.L$8 = jpTitle2;
                c00832.L$9 = syncMetaData3;
                c00832.L$10 = animeMetaData;
                c00832.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid2);
                c00832.L$12 = kitsuid2;
                c00832.L$13 = SpillingKt.nullOutSpilledVariable(type);
                c00832.I$0 = aniyear3;
                c00832.label = 4;
                backgroundUrl4 = syncMetaData3;
                jpTitle3 = jpTitle2;
                id2 = id4;
                i = 1;
                ids3 = ids2;
                type2 = type;
                c00833 = c00832;
                backgroundUrl5 = anititle3;
                objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", type2, tmdbid2, "en", c00833);
                if (objFetchTmdbLogoUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data3 = data2;
                posterurl3 = kitsuid2;
                backgroundUrl6 = backgroundUrl5;
                posterurl4 = posterurl2;
                anitype6 = anitype5;
                ids4 = ids3;
                animeMetaData2 = animeMetaData;
                jpTitle4 = jpTitle3;
                url5 = id2;
                aniyear4 = aniyear3;
                type3 = type2;
                kitsuid3 = url4;
                tmdbid3 = tmdbid2;
                logoUrl = (String) objFetchTmdbLogoUrl;
                totalEps = data3.totalEpisodes();
                Iterable $this$associateWith$iv = new IntRange(i, totalEps);
                id3 = url5;
                kitsuid4 = posterurl3;
                result$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv, 10)), 16));
                destination$iv$iv = result$iv;
                it = $this$associateWith$iv.iterator();
                while (true) {
                    iIntValue = 0;
                    if (!it.hasNext()) {
                        Iterable $this$associateWith$iv2 = new IntRange(1, totalEps);
                        $i$f$associateWith = 0;
                        result$iv2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv2, 10)), 16));
                        epMetaMap = result$iv2;
                        for (Object element$iv$iv : $this$associateWith$iv2) {
                            int $i$f$associateWith2 = $i$f$associateWith;
                            it3 = ((Number) element$iv$iv).intValue();
                            if (animeMetaData2 != null) {
                                url8 = kitsuid3;
                                episodes4 = animeMetaData2.getEpisodes();
                                if (episodes4 != null) {
                                    result$iv2 = result$iv2;
                                    metaEpisode = episodes4.get(String.valueOf(it3));
                                }
                                epMetaMap.put(element$iv$iv, metaEpisode);
                                $i$f$associateWith = $i$f$associateWith2;
                                kitsuid3 = url8;
                                result$iv2 = result$iv2;
                            } else {
                                url8 = kitsuid3;
                            }
                            metaEpisode = null;
                            epMetaMap.put(element$iv$iv, metaEpisode);
                            $i$f$associateWith = $i$f$associateWith2;
                            kitsuid3 = url8;
                            result$iv2 = result$iv2;
                        }
                        url6 = kitsuid3;
                        if (animeMetaData2 != null || (images = animeMetaData2.getImages()) == null || (imageData = (ImageData) CollectionsKt.firstOrNull(images)) == null || (fallbackPoster = imageData.getUrl()) == null) {
                            fallbackPoster = "";
                        }
                        if (animeMetaData2 != null || (titles3 = animeMetaData2.getTitles()) == null || (str = titles3.get("en")) == null) {
                            if (animeMetaData2 != null || (titles2 = animeMetaData2.getTitles()) == null) {
                                str = null;
                            } else {
                                str = titles2.get("ja");
                            }
                            if (str == null) {
                                if (animeMetaData2 != null || (titles = animeMetaData2.getTitles()) == null) {
                                    str = null;
                                } else {
                                    str = titles.get("x-jat");
                                }
                                fallbackTitle = str != null ? str : "";
                            }
                        }
                        num = (Integer) destination$iv$iv.get(Boxing.boxInt(1));
                        if (num != null) {
                            anidbEid = num.intValue();
                        } else {
                            anidbEid = 0;
                        }
                        Integer idMal = ids4.getIdMal();
                        Integer id5 = ids4.getId();
                        if (kitsuid4 != null) {
                            intOrNull = StringsKt.toIntOrNull(kitsuid4);
                        } else {
                            intOrNull = null;
                        }
                        href = toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), id5, idMal, data3.m46getTitle(), Boxing.boxInt(data3.getStartDate().getYear()), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(anidbEid), intOrNull, 16633983, null));
                        $this$map$iv = new IntRange(1, totalEps);
                        tmdbid4 = tmdbid3;
                        type4 = type3;
                        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        $this$mapTo$iv$iv = $this$map$iv;
                        $i$f$mapTo = 0;
                        it2 = $this$mapTo$iv$iv.iterator();
                        while (it2.hasNext()) {
                            final int item$iv$iv = it2.nextInt();
                            Iterable $this$map$iv2 = $this$map$iv;
                            final MetaEpisode epData = (MetaEpisode) epMetaMap.get(Boxing.boxInt(item$iv$iv));
                            Integer idMal2 = ids4.getIdMal();
                            Integer id6 = ids4.getId();
                            if (kitsuid4 != null) {
                                intOrNull3 = StringsKt.toIntOrNull(kitsuid4);
                            } else {
                                intOrNull3 = null;
                            }
                            String strM46getTitle = data3.m46getTitle();
                            int year = data3.getStartDate().getYear();
                            Map epMetaMap3 = epMetaMap;
                            num3 = (Integer) destination$iv$iv.get(Boxing.boxInt(item$iv$iv));
                            if (num3 != null) {
                                iIntValue3 = num3.intValue();
                            } else {
                                iIntValue3 = 0;
                            }
                            String linkData = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(item$iv$iv), id6, idMal2, strM46getTitle, Boxing.boxInt(year), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(iIntValue3), intOrNull3, 8245311, null));
                            destination$iv$iv2.add(MainAPIKt.newEpisode(this, linkData, new Function1() { // from class: com.phisher98.StreamPlayAnime$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj5) {
                                    return StreamPlayAnime.loadFromAnilist$lambda$3$0(item$iv$iv, epData, fallbackPoster, fallbackTitle, (Episode) obj5);
                                }
                            }));
                            $this$map$iv = $this$map$iv2;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                            $i$f$mapTo = $i$f$mapTo;
                            epMetaMap = epMetaMap3;
                            anitype6 = anitype6;
                        }
                        epMetaMap2 = epMetaMap;
                        anitype7 = anitype6;
                        episodes = (List) destination$iv$iv2;
                        List $this$mapIndexed$iv = episodes;
                        destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                        index$iv$iv = 0;
                        for (Object item$iv$iv2 : $this$mapIndexed$iv) {
                            int index$iv$iv2 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            Episode ep = (Episode) item$iv$iv2;
                            int i2 = index$iv$iv + 1;
                            Integer idMal3 = ids4.getIdMal();
                            Integer id7 = ids4.getId();
                            if (kitsuid4 != null) {
                                intOrNull2 = StringsKt.toIntOrNull(kitsuid4);
                            } else {
                                intOrNull2 = null;
                            }
                            String strM46getTitle2 = data3.m46getTitle();
                            int year2 = data3.getStartDate().getYear();
                            List episodes5 = episodes;
                            num2 = (Integer) destination$iv$iv.get(Boxing.boxInt(i2));
                            if (num2 != null) {
                                iIntValue2 = num2.intValue();
                            } else {
                                iIntValue2 = 0;
                            }
                            String dubLinkData = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(i2), id7, idMal3, strM46getTitle2, Boxing.boxInt(year2), null, true, null, null, null, jpTitle4, null, null, false, false, false, true, Boxing.boxInt(iIntValue2), intOrNull2, 8245311, null));
                            destination$iv$iv3.add(Episode.copy$default(ep, dubLinkData, (String) null, (Integer) null, (Integer) null, (String) null, (Score) null, (String) null, (Long) null, (Integer) null, 510, (Object) null));
                            episodes = episodes5;
                            index$iv$iv = index$iv$iv2;
                        }
                        episodes2 = episodes;
                        episodesDub = (List) destination$iv$iv3;
                        if (StringsKt.contains(data3.getFormat(), "Movie", true)) {
                            String fallbackTitle4 = fallbackTitle;
                            String fallbackTitle5 = data3.m46getTitle();
                            TvType tvType2 = TvType.AnimeMovie;
                            C00842 c00842 = new C00842(id3, ids4, kitsuid4, data3, backgroundUrl6, animeMetaData2, posterurl4, logoUrl, null);
                            c00833.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                            c00833.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                            c00833.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                            c00833.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                            c00833.L$4 = SpillingKt.nullOutSpilledVariable(posterurl4);
                            c00833.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl6);
                            c00833.L$6 = SpillingKt.nullOutSpilledVariable(anitype7);
                            c00833.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                            c00833.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                            c00833.L$9 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                            c00833.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                            c00833.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid4);
                            c00833.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                            c00833.L$13 = SpillingKt.nullOutSpilledVariable(type4);
                            c00833.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                            c00833.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                            c00833.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                            c00833.L$17 = SpillingKt.nullOutSpilledVariable(fallbackPoster);
                            c00833.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle4);
                            c00833.L$19 = SpillingKt.nullOutSpilledVariable(href);
                            c00833.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                            c00833.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                            c00833.I$0 = aniyear4;
                            c00833.I$1 = totalEps;
                            c00833.I$2 = anidbEid;
                            c00833.label = 5;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, fallbackTitle5, url6, tvType2, href, c00842, c00833);
                            if (objNewMovieLoadResponse == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        fallbackTitle2 = fallbackTitle;
                        logoUrl2 = fallbackPoster;
                        anidbEid2 = anidbEid;
                        String strM46getTitle3 = data3.m46getTitle();
                        TvType tvType3 = TvType.Anime;
                        syncMetaData = backgroundUrl4;
                        C00831 c00835 = c00833;
                        C00853 c00853 = new C00853(id3, ids4, kitsuid4, episodes2, episodesDub, logoUrl, data3, animeMetaData2, this, null);
                        c00835.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00835.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                        c00835.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                        c00835.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                        c00835.L$4 = SpillingKt.nullOutSpilledVariable(posterurl4);
                        c00835.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl6);
                        c00835.L$6 = SpillingKt.nullOutSpilledVariable(anitype7);
                        c00835.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                        c00835.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                        c00835.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                        c00835.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                        c00835.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid4);
                        c00835.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                        c00835.L$13 = SpillingKt.nullOutSpilledVariable(type4);
                        c00835.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                        c00835.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                        c00835.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                        c00835.L$17 = SpillingKt.nullOutSpilledVariable(logoUrl2);
                        c00835.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle2);
                        c00835.L$19 = SpillingKt.nullOutSpilledVariable(href);
                        c00835.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                        c00835.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                        c00835.I$0 = aniyear4;
                        c00835.I$1 = totalEps;
                        c00835.I$2 = anidbEid2;
                        c00835.label = 6;
                        url7 = url6;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, strM46getTitle3, url7, tvType3, false, c00853, c00835, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        episodes3 = episodes2;
                        episodesDub2 = episodesDub;
                        obj4 = objNewAnimeLoadResponse$default;
                        totalEps2 = totalEps;
                        anidbEid3 = anidbEid2;
                        href2 = href;
                        fallbackTitle3 = fallbackTitle2;
                        anidbEidMap = destination$iv$iv;
                        logoUrl3 = logoUrl;
                        fallbackPoster2 = logoUrl2;
                        anititle4 = anititle2;
                        type5 = type4;
                        syncMetaData2 = syncMetaData;
                        return (LoadResponse) obj4;
                    }
                    Object element$iv$iv2 = it.next();
                    int it4 = ((Number) element$iv$iv2).intValue();
                    LinkedHashMap result$iv3 = result$iv;
                    anidbEid4 = StreamPlayUtilsKt.getAnidbEid(backgroundUrl4, Boxing.boxInt(it4));
                    if (anidbEid4 != null) {
                        iIntValue = anidbEid4.intValue();
                    }
                    destination$iv$iv.put(element$iv$iv2, Boxing.boxInt(iIntValue));
                    result$iv = result$iv3;
                }
                break;
            case 1:
                id4 = (String) c00834.L$1;
                url2 = (String) c00834.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                media = ((AnilistAPIResponse) obj).getData().getMedia();
                if (media != null) {
                    throw new Exception("Unable to fetch media details");
                }
                data = media;
                anititle = data.m46getTitle();
                aniyear = data.getStartDate().getYear();
                posterurl = data.getCoverImage().getExtraLarge();
                backgroundUrl = data.getBannerImage();
                format = data.getFormat();
                Intrinsics.checkNotNull(format);
                if (StringsKt.contains(format, "MOVIE", true)) {
                    anitype = TvType.AnimeMovie;
                } else {
                    anitype = TvType.TvSeries;
                }
                Integer numBoxInt2 = Boxing.boxInt(aniyear);
                c00834.L$0 = url2;
                c00834.L$1 = id4;
                c00834.L$2 = data;
                c00834.L$3 = SpillingKt.nullOutSpilledVariable(anititle);
                c00834.L$4 = posterurl;
                c00834.L$5 = backgroundUrl;
                c00834.L$6 = SpillingKt.nullOutSpilledVariable(anitype);
                c00834.I$0 = aniyear;
                c00834.label = 2;
                objTmdbToAnimeId = tmdbToAnimeId(anititle, numBoxInt2, anitype, c00834);
                if (objTmdbToAnimeId == coroutine_suspended) {
                    return coroutine_suspended;
                }
                TvType tvType4 = anitype;
                url3 = url2;
                aniyear2 = aniyear;
                backgroundUrl2 = backgroundUrl;
                backgroundUrl3 = anititle;
                anitype2 = tvType4;
                ids = (AniIds) objTmdbToAnimeId;
                jpTitle = data.getTitle().getRomaji();
                anitype3 = anitype2;
                c00834.L$0 = url3;
                c00834.L$1 = id4;
                c00834.L$2 = data;
                c00834.L$3 = SpillingKt.nullOutSpilledVariable(backgroundUrl3);
                c00834.L$4 = posterurl;
                c00834.L$5 = backgroundUrl2;
                c00834.L$6 = SpillingKt.nullOutSpilledVariable(anitype3);
                c00834.L$7 = ids;
                c00834.L$8 = jpTitle;
                c00834.I$0 = aniyear2;
                c00834.label = 3;
                obj2 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?anilist_id=" + id4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00834, 4094, (Object) null);
                c00832 = c00834;
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anitype4 = anitype3;
                posterurl2 = posterurl;
                anititle2 = backgroundUrl3;
                ids2 = ids;
                anititle3 = backgroundUrl2;
                jpTitle2 = jpTitle;
                obj3 = obj2;
                aniyear3 = aniyear2;
                data2 = data;
                url4 = url3;
                String syncMetaData4 = ((NiceResponse) obj3).getText();
                animeMetaData = StreamPlayUtilsKt.parseAnimeData(syncMetaData4);
                if (animeMetaData != null) {
                    tmdbid = null;
                } else {
                    tmdbid = null;
                }
                if (animeMetaData != null) {
                    kitsuid = null;
                } else {
                    kitsuid = null;
                }
                kitsuid2 = kitsuid;
                tmdbid2 = tmdbid;
                anitype5 = anitype4;
                if (StringsKt.contains(data2.getFormat(), "Movie", true)) {
                    type = TvType.Movie;
                } else {
                    type = TvType.TvSeries;
                }
                c00832.L$0 = url4;
                c00832.L$1 = id4;
                c00832.L$2 = data2;
                c00832.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                c00832.L$4 = posterurl2;
                c00832.L$5 = anititle3;
                c00832.L$6 = SpillingKt.nullOutSpilledVariable(anitype5);
                c00832.L$7 = ids2;
                c00832.L$8 = jpTitle2;
                c00832.L$9 = syncMetaData4;
                c00832.L$10 = animeMetaData;
                c00832.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid2);
                c00832.L$12 = kitsuid2;
                c00832.L$13 = SpillingKt.nullOutSpilledVariable(type);
                c00832.I$0 = aniyear3;
                c00832.label = 4;
                backgroundUrl4 = syncMetaData4;
                jpTitle3 = jpTitle2;
                id2 = id4;
                i = 1;
                ids3 = ids2;
                type2 = type;
                c00833 = c00832;
                backgroundUrl5 = anititle3;
                objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", type2, tmdbid2, "en", c00833);
                if (objFetchTmdbLogoUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data3 = data2;
                posterurl3 = kitsuid2;
                backgroundUrl6 = backgroundUrl5;
                posterurl4 = posterurl2;
                anitype6 = anitype5;
                ids4 = ids3;
                animeMetaData2 = animeMetaData;
                jpTitle4 = jpTitle3;
                url5 = id2;
                aniyear4 = aniyear3;
                type3 = type2;
                kitsuid3 = url4;
                tmdbid3 = tmdbid2;
                logoUrl = (String) objFetchTmdbLogoUrl;
                totalEps = data3.totalEpisodes();
                Iterable $this$associateWith$iv3 = new IntRange(i, totalEps);
                id3 = url5;
                kitsuid4 = posterurl3;
                result$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv3, 10)), 16));
                destination$iv$iv = result$iv;
                it = $this$associateWith$iv3.iterator();
                while (true) {
                    iIntValue = 0;
                    if (!it.hasNext()) {
                        Iterable $this$associateWith$iv4 = new IntRange(1, totalEps);
                        $i$f$associateWith = 0;
                        result$iv2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv4, 10)), 16));
                        epMetaMap = result$iv2;
                        while (r19.hasNext()) {
                            int $i$f$associateWith3 = $i$f$associateWith;
                            it3 = ((Number) element$iv$iv).intValue();
                            if (animeMetaData2 != null) {
                                url8 = kitsuid3;
                                episodes4 = animeMetaData2.getEpisodes();
                                if (episodes4 != null) {
                                    result$iv2 = result$iv2;
                                    metaEpisode = episodes4.get(String.valueOf(it3));
                                }
                                epMetaMap.put(element$iv$iv, metaEpisode);
                                $i$f$associateWith = $i$f$associateWith3;
                                kitsuid3 = url8;
                                result$iv2 = result$iv2;
                            } else {
                                url8 = kitsuid3;
                            }
                            metaEpisode = null;
                            epMetaMap.put(element$iv$iv, metaEpisode);
                            $i$f$associateWith = $i$f$associateWith3;
                            kitsuid3 = url8;
                            result$iv2 = result$iv2;
                        }
                        url6 = kitsuid3;
                        if (animeMetaData2 != null) {
                            fallbackPoster = "";
                        } else {
                            fallbackPoster = "";
                        }
                        if (animeMetaData2 != null) {
                            if (animeMetaData2 != null) {
                                str = null;
                            } else {
                                str = null;
                            }
                            if (str == null) {
                                if (animeMetaData2 != null) {
                                    str = null;
                                } else {
                                    str = null;
                                }
                                if (str != null) {
                                }
                            }
                        } else {
                            if (animeMetaData2 != null) {
                                str = null;
                            } else {
                                str = null;
                            }
                            if (str == null) {
                                if (animeMetaData2 != null) {
                                    str = null;
                                } else {
                                    str = null;
                                }
                                if (str != null) {
                                }
                            }
                        }
                        num = (Integer) destination$iv$iv.get(Boxing.boxInt(1));
                        if (num != null) {
                            anidbEid = num.intValue();
                        } else {
                            anidbEid = 0;
                        }
                        Integer idMal4 = ids4.getIdMal();
                        Integer id8 = ids4.getId();
                        if (kitsuid4 != null) {
                            intOrNull = StringsKt.toIntOrNull(kitsuid4);
                        } else {
                            intOrNull = null;
                        }
                        href = toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), id8, idMal4, data3.m46getTitle(), Boxing.boxInt(data3.getStartDate().getYear()), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(anidbEid), intOrNull, 16633983, null));
                        $this$map$iv = new IntRange(1, totalEps);
                        tmdbid4 = tmdbid3;
                        type4 = type3;
                        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        $this$mapTo$iv$iv = $this$map$iv;
                        $i$f$mapTo = 0;
                        it2 = $this$mapTo$iv$iv.iterator();
                        while (it2.hasNext()) {
                            final int item$iv$iv3 = it2.nextInt();
                            Iterable $this$map$iv3 = $this$map$iv;
                            final MetaEpisode epData2 = (MetaEpisode) epMetaMap.get(Boxing.boxInt(item$iv$iv3));
                            Integer idMal5 = ids4.getIdMal();
                            Integer id9 = ids4.getId();
                            if (kitsuid4 != null) {
                                intOrNull3 = StringsKt.toIntOrNull(kitsuid4);
                            } else {
                                intOrNull3 = null;
                            }
                            String strM46getTitle4 = data3.m46getTitle();
                            int year3 = data3.getStartDate().getYear();
                            Map epMetaMap4 = epMetaMap;
                            num3 = (Integer) destination$iv$iv.get(Boxing.boxInt(item$iv$iv3));
                            if (num3 != null) {
                                iIntValue3 = num3.intValue();
                            } else {
                                iIntValue3 = 0;
                            }
                            String linkData2 = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(item$iv$iv3), id9, idMal5, strM46getTitle4, Boxing.boxInt(year3), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(iIntValue3), intOrNull3, 8245311, null));
                            destination$iv$iv2.add(MainAPIKt.newEpisode(this, linkData2, new Function1() { // from class: com.phisher98.StreamPlayAnime$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj5) {
                                    return StreamPlayAnime.loadFromAnilist$lambda$3$0(item$iv$iv3, epData2, fallbackPoster, fallbackTitle, (Episode) obj5);
                                }
                            }));
                            $this$map$iv = $this$map$iv3;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                            $i$f$mapTo = $i$f$mapTo;
                            epMetaMap = epMetaMap4;
                            anitype6 = anitype6;
                        }
                        epMetaMap2 = epMetaMap;
                        anitype7 = anitype6;
                        episodes = (List) destination$iv$iv2;
                        List $this$mapIndexed$iv2 = episodes;
                        destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
                        index$iv$iv = 0;
                        while (r22.hasNext()) {
                            int index$iv$iv3 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            Episode ep2 = (Episode) item$iv$iv2;
                            int i3 = index$iv$iv + 1;
                            Integer idMal6 = ids4.getIdMal();
                            Integer id10 = ids4.getId();
                            if (kitsuid4 != null) {
                                intOrNull2 = StringsKt.toIntOrNull(kitsuid4);
                            } else {
                                intOrNull2 = null;
                            }
                            String strM46getTitle5 = data3.m46getTitle();
                            int year4 = data3.getStartDate().getYear();
                            List episodes6 = episodes;
                            num2 = (Integer) destination$iv$iv.get(Boxing.boxInt(i3));
                            if (num2 != null) {
                                iIntValue2 = num2.intValue();
                            } else {
                                iIntValue2 = 0;
                            }
                            String dubLinkData2 = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(i3), id10, idMal6, strM46getTitle5, Boxing.boxInt(year4), null, true, null, null, null, jpTitle4, null, null, false, false, false, true, Boxing.boxInt(iIntValue2), intOrNull2, 8245311, null));
                            destination$iv$iv3.add(Episode.copy$default(ep2, dubLinkData2, (String) null, (Integer) null, (Integer) null, (String) null, (Score) null, (String) null, (Long) null, (Integer) null, 510, (Object) null));
                            episodes = episodes6;
                            index$iv$iv = index$iv$iv3;
                        }
                        episodes2 = episodes;
                        episodesDub = (List) destination$iv$iv3;
                        if (StringsKt.contains(data3.getFormat(), "Movie", true)) {
                            String fallbackTitle6 = fallbackTitle;
                            String fallbackTitle7 = data3.m46getTitle();
                            TvType tvType5 = TvType.AnimeMovie;
                            C00842 c00843 = new C00842(id3, ids4, kitsuid4, data3, backgroundUrl6, animeMetaData2, posterurl4, logoUrl, null);
                            c00833.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                            c00833.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                            c00833.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                            c00833.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                            c00833.L$4 = SpillingKt.nullOutSpilledVariable(posterurl4);
                            c00833.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl6);
                            c00833.L$6 = SpillingKt.nullOutSpilledVariable(anitype7);
                            c00833.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                            c00833.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                            c00833.L$9 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                            c00833.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                            c00833.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid4);
                            c00833.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                            c00833.L$13 = SpillingKt.nullOutSpilledVariable(type4);
                            c00833.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                            c00833.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                            c00833.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                            c00833.L$17 = SpillingKt.nullOutSpilledVariable(fallbackPoster);
                            c00833.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle6);
                            c00833.L$19 = SpillingKt.nullOutSpilledVariable(href);
                            c00833.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                            c00833.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                            c00833.I$0 = aniyear4;
                            c00833.I$1 = totalEps;
                            c00833.I$2 = anidbEid;
                            c00833.label = 5;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, fallbackTitle7, url6, tvType5, href, c00843, c00833);
                            if (objNewMovieLoadResponse == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        fallbackTitle2 = fallbackTitle;
                        logoUrl2 = fallbackPoster;
                        anidbEid2 = anidbEid;
                        String strM46getTitle6 = data3.m46getTitle();
                        TvType tvType6 = TvType.Anime;
                        syncMetaData = backgroundUrl4;
                        C00831 c00836 = c00833;
                        C00853 c00854 = new C00853(id3, ids4, kitsuid4, episodes2, episodesDub, logoUrl, data3, animeMetaData2, this, null);
                        c00836.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00836.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                        c00836.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                        c00836.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                        c00836.L$4 = SpillingKt.nullOutSpilledVariable(posterurl4);
                        c00836.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl6);
                        c00836.L$6 = SpillingKt.nullOutSpilledVariable(anitype7);
                        c00836.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                        c00836.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                        c00836.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                        c00836.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                        c00836.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid4);
                        c00836.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                        c00836.L$13 = SpillingKt.nullOutSpilledVariable(type4);
                        c00836.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                        c00836.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                        c00836.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                        c00836.L$17 = SpillingKt.nullOutSpilledVariable(logoUrl2);
                        c00836.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle2);
                        c00836.L$19 = SpillingKt.nullOutSpilledVariable(href);
                        c00836.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                        c00836.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                        c00836.I$0 = aniyear4;
                        c00836.I$1 = totalEps;
                        c00836.I$2 = anidbEid2;
                        c00836.label = 6;
                        url7 = url6;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, strM46getTitle6, url7, tvType6, false, c00854, c00836, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        episodes3 = episodes2;
                        episodesDub2 = episodesDub;
                        obj4 = objNewAnimeLoadResponse$default;
                        totalEps2 = totalEps;
                        anidbEid3 = anidbEid2;
                        href2 = href;
                        fallbackTitle3 = fallbackTitle2;
                        anidbEidMap = destination$iv$iv;
                        logoUrl3 = logoUrl;
                        fallbackPoster2 = logoUrl2;
                        anititle4 = anititle2;
                        type5 = type4;
                        syncMetaData2 = syncMetaData;
                        return (LoadResponse) obj4;
                    }
                    Object element$iv$iv3 = it.next();
                    int it5 = ((Number) element$iv$iv3).intValue();
                    LinkedHashMap result$iv4 = result$iv;
                    anidbEid4 = StreamPlayUtilsKt.getAnidbEid(backgroundUrl4, Boxing.boxInt(it5));
                    if (anidbEid4 != null) {
                        iIntValue = anidbEid4.intValue();
                    }
                    destination$iv$iv.put(element$iv$iv3, Boxing.boxInt(iIntValue));
                    result$iv = result$iv4;
                }
                break;
            case 2:
                aniyear2 = c00834.I$0;
                anitype2 = (TvType) c00834.L$6;
                backgroundUrl2 = (String) c00834.L$5;
                posterurl = (String) c00834.L$4;
                backgroundUrl3 = (String) c00834.L$3;
                data = (AnilistAPIResponse.anilistMedia) c00834.L$2;
                id4 = (String) c00834.L$1;
                url3 = (String) c00834.L$0;
                ResultKt.throwOnFailure($result);
                objTmdbToAnimeId = $result;
                ids = (AniIds) objTmdbToAnimeId;
                jpTitle = data.getTitle().getRomaji();
                anitype3 = anitype2;
                c00834.L$0 = url3;
                c00834.L$1 = id4;
                c00834.L$2 = data;
                c00834.L$3 = SpillingKt.nullOutSpilledVariable(backgroundUrl3);
                c00834.L$4 = posterurl;
                c00834.L$5 = backgroundUrl2;
                c00834.L$6 = SpillingKt.nullOutSpilledVariable(anitype3);
                c00834.L$7 = ids;
                c00834.L$8 = jpTitle;
                c00834.I$0 = aniyear2;
                c00834.label = 3;
                obj2 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?anilist_id=" + id4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00834, 4094, (Object) null);
                c00832 = c00834;
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anitype4 = anitype3;
                posterurl2 = posterurl;
                anititle2 = backgroundUrl3;
                ids2 = ids;
                anititle3 = backgroundUrl2;
                jpTitle2 = jpTitle;
                obj3 = obj2;
                aniyear3 = aniyear2;
                data2 = data;
                url4 = url3;
                String syncMetaData5 = ((NiceResponse) obj3).getText();
                animeMetaData = StreamPlayUtilsKt.parseAnimeData(syncMetaData5);
                if (animeMetaData != null) {
                    tmdbid = null;
                } else {
                    tmdbid = null;
                }
                if (animeMetaData != null) {
                    kitsuid = null;
                } else {
                    kitsuid = null;
                }
                kitsuid2 = kitsuid;
                tmdbid2 = tmdbid;
                anitype5 = anitype4;
                if (StringsKt.contains(data2.getFormat(), "Movie", true)) {
                    type = TvType.Movie;
                } else {
                    type = TvType.TvSeries;
                }
                c00832.L$0 = url4;
                c00832.L$1 = id4;
                c00832.L$2 = data2;
                c00832.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                c00832.L$4 = posterurl2;
                c00832.L$5 = anititle3;
                c00832.L$6 = SpillingKt.nullOutSpilledVariable(anitype5);
                c00832.L$7 = ids2;
                c00832.L$8 = jpTitle2;
                c00832.L$9 = syncMetaData5;
                c00832.L$10 = animeMetaData;
                c00832.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid2);
                c00832.L$12 = kitsuid2;
                c00832.L$13 = SpillingKt.nullOutSpilledVariable(type);
                c00832.I$0 = aniyear3;
                c00832.label = 4;
                backgroundUrl4 = syncMetaData5;
                jpTitle3 = jpTitle2;
                id2 = id4;
                i = 1;
                ids3 = ids2;
                type2 = type;
                c00833 = c00832;
                backgroundUrl5 = anititle3;
                objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", type2, tmdbid2, "en", c00833);
                if (objFetchTmdbLogoUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data3 = data2;
                posterurl3 = kitsuid2;
                backgroundUrl6 = backgroundUrl5;
                posterurl4 = posterurl2;
                anitype6 = anitype5;
                ids4 = ids3;
                animeMetaData2 = animeMetaData;
                jpTitle4 = jpTitle3;
                url5 = id2;
                aniyear4 = aniyear3;
                type3 = type2;
                kitsuid3 = url4;
                tmdbid3 = tmdbid2;
                logoUrl = (String) objFetchTmdbLogoUrl;
                totalEps = data3.totalEpisodes();
                Iterable $this$associateWith$iv5 = new IntRange(i, totalEps);
                id3 = url5;
                kitsuid4 = posterurl3;
                result$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv5, 10)), 16));
                destination$iv$iv = result$iv;
                it = $this$associateWith$iv5.iterator();
                while (true) {
                    iIntValue = 0;
                    if (!it.hasNext()) {
                        Iterable $this$associateWith$iv6 = new IntRange(1, totalEps);
                        $i$f$associateWith = 0;
                        result$iv2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv6, 10)), 16));
                        epMetaMap = result$iv2;
                        while (r19.hasNext()) {
                            int $i$f$associateWith4 = $i$f$associateWith;
                            it3 = ((Number) element$iv$iv).intValue();
                            if (animeMetaData2 != null) {
                                url8 = kitsuid3;
                                episodes4 = animeMetaData2.getEpisodes();
                                if (episodes4 != null) {
                                    result$iv2 = result$iv2;
                                    metaEpisode = episodes4.get(String.valueOf(it3));
                                }
                                epMetaMap.put(element$iv$iv, metaEpisode);
                                $i$f$associateWith = $i$f$associateWith4;
                                kitsuid3 = url8;
                                result$iv2 = result$iv2;
                            } else {
                                url8 = kitsuid3;
                            }
                            metaEpisode = null;
                            epMetaMap.put(element$iv$iv, metaEpisode);
                            $i$f$associateWith = $i$f$associateWith4;
                            kitsuid3 = url8;
                            result$iv2 = result$iv2;
                        }
                        url6 = kitsuid3;
                        if (animeMetaData2 != null) {
                            fallbackPoster = "";
                        } else {
                            fallbackPoster = "";
                        }
                        if (animeMetaData2 != null) {
                            if (animeMetaData2 != null) {
                                str = null;
                            } else {
                                str = null;
                            }
                            if (str == null) {
                                if (animeMetaData2 != null) {
                                    str = null;
                                } else {
                                    str = null;
                                }
                                if (str != null) {
                                }
                            }
                        } else {
                            if (animeMetaData2 != null) {
                                str = null;
                            } else {
                                str = null;
                            }
                            if (str == null) {
                                if (animeMetaData2 != null) {
                                    str = null;
                                } else {
                                    str = null;
                                }
                                if (str != null) {
                                }
                            }
                        }
                        num = (Integer) destination$iv$iv.get(Boxing.boxInt(1));
                        if (num != null) {
                            anidbEid = num.intValue();
                        } else {
                            anidbEid = 0;
                        }
                        Integer idMal7 = ids4.getIdMal();
                        Integer id11 = ids4.getId();
                        if (kitsuid4 != null) {
                            intOrNull = StringsKt.toIntOrNull(kitsuid4);
                        } else {
                            intOrNull = null;
                        }
                        href = toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), id11, idMal7, data3.m46getTitle(), Boxing.boxInt(data3.getStartDate().getYear()), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(anidbEid), intOrNull, 16633983, null));
                        $this$map$iv = new IntRange(1, totalEps);
                        tmdbid4 = tmdbid3;
                        type4 = type3;
                        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        $this$mapTo$iv$iv = $this$map$iv;
                        $i$f$mapTo = 0;
                        it2 = $this$mapTo$iv$iv.iterator();
                        while (it2.hasNext()) {
                            final int item$iv$iv4 = it2.nextInt();
                            Iterable $this$map$iv4 = $this$map$iv;
                            final MetaEpisode epData3 = (MetaEpisode) epMetaMap.get(Boxing.boxInt(item$iv$iv4));
                            Integer idMal8 = ids4.getIdMal();
                            Integer id12 = ids4.getId();
                            if (kitsuid4 != null) {
                                intOrNull3 = StringsKt.toIntOrNull(kitsuid4);
                            } else {
                                intOrNull3 = null;
                            }
                            String strM46getTitle7 = data3.m46getTitle();
                            int year5 = data3.getStartDate().getYear();
                            Map epMetaMap5 = epMetaMap;
                            num3 = (Integer) destination$iv$iv.get(Boxing.boxInt(item$iv$iv4));
                            if (num3 != null) {
                                iIntValue3 = num3.intValue();
                            } else {
                                iIntValue3 = 0;
                            }
                            String linkData3 = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(item$iv$iv4), id12, idMal8, strM46getTitle7, Boxing.boxInt(year5), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(iIntValue3), intOrNull3, 8245311, null));
                            destination$iv$iv2.add(MainAPIKt.newEpisode(this, linkData3, new Function1() { // from class: com.phisher98.StreamPlayAnime$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj5) {
                                    return StreamPlayAnime.loadFromAnilist$lambda$3$0(item$iv$iv4, epData3, fallbackPoster, fallbackTitle, (Episode) obj5);
                                }
                            }));
                            $this$map$iv = $this$map$iv4;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                            $i$f$mapTo = $i$f$mapTo;
                            epMetaMap = epMetaMap5;
                            anitype6 = anitype6;
                        }
                        epMetaMap2 = epMetaMap;
                        anitype7 = anitype6;
                        episodes = (List) destination$iv$iv2;
                        List $this$mapIndexed$iv3 = episodes;
                        destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv3, 10));
                        index$iv$iv = 0;
                        while (r22.hasNext()) {
                            int index$iv$iv4 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            Episode ep3 = (Episode) item$iv$iv2;
                            int i4 = index$iv$iv + 1;
                            Integer idMal9 = ids4.getIdMal();
                            Integer id13 = ids4.getId();
                            if (kitsuid4 != null) {
                                intOrNull2 = StringsKt.toIntOrNull(kitsuid4);
                            } else {
                                intOrNull2 = null;
                            }
                            String strM46getTitle8 = data3.m46getTitle();
                            int year6 = data3.getStartDate().getYear();
                            List episodes7 = episodes;
                            num2 = (Integer) destination$iv$iv.get(Boxing.boxInt(i4));
                            if (num2 != null) {
                                iIntValue2 = num2.intValue();
                            } else {
                                iIntValue2 = 0;
                            }
                            String dubLinkData3 = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(i4), id13, idMal9, strM46getTitle8, Boxing.boxInt(year6), null, true, null, null, null, jpTitle4, null, null, false, false, false, true, Boxing.boxInt(iIntValue2), intOrNull2, 8245311, null));
                            destination$iv$iv3.add(Episode.copy$default(ep3, dubLinkData3, (String) null, (Integer) null, (Integer) null, (String) null, (Score) null, (String) null, (Long) null, (Integer) null, 510, (Object) null));
                            episodes = episodes7;
                            index$iv$iv = index$iv$iv4;
                        }
                        episodes2 = episodes;
                        episodesDub = (List) destination$iv$iv3;
                        if (StringsKt.contains(data3.getFormat(), "Movie", true)) {
                            String fallbackTitle8 = fallbackTitle;
                            String fallbackTitle9 = data3.m46getTitle();
                            TvType tvType7 = TvType.AnimeMovie;
                            C00842 c00844 = new C00842(id3, ids4, kitsuid4, data3, backgroundUrl6, animeMetaData2, posterurl4, logoUrl, null);
                            c00833.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                            c00833.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                            c00833.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                            c00833.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                            c00833.L$4 = SpillingKt.nullOutSpilledVariable(posterurl4);
                            c00833.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl6);
                            c00833.L$6 = SpillingKt.nullOutSpilledVariable(anitype7);
                            c00833.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                            c00833.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                            c00833.L$9 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                            c00833.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                            c00833.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid4);
                            c00833.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                            c00833.L$13 = SpillingKt.nullOutSpilledVariable(type4);
                            c00833.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                            c00833.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                            c00833.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                            c00833.L$17 = SpillingKt.nullOutSpilledVariable(fallbackPoster);
                            c00833.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle8);
                            c00833.L$19 = SpillingKt.nullOutSpilledVariable(href);
                            c00833.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                            c00833.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                            c00833.I$0 = aniyear4;
                            c00833.I$1 = totalEps;
                            c00833.I$2 = anidbEid;
                            c00833.label = 5;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, fallbackTitle9, url6, tvType7, href, c00844, c00833);
                            if (objNewMovieLoadResponse == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        fallbackTitle2 = fallbackTitle;
                        logoUrl2 = fallbackPoster;
                        anidbEid2 = anidbEid;
                        String strM46getTitle9 = data3.m46getTitle();
                        TvType tvType8 = TvType.Anime;
                        syncMetaData = backgroundUrl4;
                        C00831 c00837 = c00833;
                        C00853 c00855 = new C00853(id3, ids4, kitsuid4, episodes2, episodesDub, logoUrl, data3, animeMetaData2, this, null);
                        c00837.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00837.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                        c00837.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                        c00837.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                        c00837.L$4 = SpillingKt.nullOutSpilledVariable(posterurl4);
                        c00837.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl6);
                        c00837.L$6 = SpillingKt.nullOutSpilledVariable(anitype7);
                        c00837.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                        c00837.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                        c00837.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                        c00837.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                        c00837.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid4);
                        c00837.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                        c00837.L$13 = SpillingKt.nullOutSpilledVariable(type4);
                        c00837.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                        c00837.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                        c00837.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                        c00837.L$17 = SpillingKt.nullOutSpilledVariable(logoUrl2);
                        c00837.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle2);
                        c00837.L$19 = SpillingKt.nullOutSpilledVariable(href);
                        c00837.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                        c00837.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                        c00837.I$0 = aniyear4;
                        c00837.I$1 = totalEps;
                        c00837.I$2 = anidbEid2;
                        c00837.label = 6;
                        url7 = url6;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, strM46getTitle9, url7, tvType8, false, c00855, c00837, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        episodes3 = episodes2;
                        episodesDub2 = episodesDub;
                        obj4 = objNewAnimeLoadResponse$default;
                        totalEps2 = totalEps;
                        anidbEid3 = anidbEid2;
                        href2 = href;
                        fallbackTitle3 = fallbackTitle2;
                        anidbEidMap = destination$iv$iv;
                        logoUrl3 = logoUrl;
                        fallbackPoster2 = logoUrl2;
                        anititle4 = anititle2;
                        type5 = type4;
                        syncMetaData2 = syncMetaData;
                        return (LoadResponse) obj4;
                    }
                    Object element$iv$iv4 = it.next();
                    int it6 = ((Number) element$iv$iv4).intValue();
                    LinkedHashMap result$iv5 = result$iv;
                    anidbEid4 = StreamPlayUtilsKt.getAnidbEid(backgroundUrl4, Boxing.boxInt(it6));
                    if (anidbEid4 != null) {
                        iIntValue = anidbEid4.intValue();
                    }
                    destination$iv$iv.put(element$iv$iv4, Boxing.boxInt(iIntValue));
                    result$iv = result$iv5;
                }
                break;
            case 3:
                int aniyear5 = c00834.I$0;
                String jpTitle5 = (String) c00834.L$8;
                AniIds ids5 = (AniIds) c00834.L$7;
                TvType anitype8 = (TvType) c00834.L$6;
                anititle3 = (String) c00834.L$5;
                String posterurl5 = (String) c00834.L$4;
                String anititle5 = (String) c00834.L$3;
                AnilistAPIResponse.anilistMedia data4 = (AnilistAPIResponse.anilistMedia) c00834.L$2;
                id4 = (String) c00834.L$1;
                String url9 = (String) c00834.L$0;
                ResultKt.throwOnFailure($result);
                aniyear3 = aniyear5;
                data2 = data4;
                c00832 = c00834;
                url4 = url9;
                anitype4 = anitype8;
                posterurl2 = posterurl5;
                anititle2 = anititle5;
                ids2 = ids5;
                jpTitle2 = jpTitle5;
                obj3 = $result;
                String syncMetaData6 = ((NiceResponse) obj3).getText();
                animeMetaData = StreamPlayUtilsKt.parseAnimeData(syncMetaData6);
                if (animeMetaData != null) {
                    tmdbid = null;
                } else {
                    tmdbid = null;
                }
                if (animeMetaData != null) {
                    kitsuid = null;
                } else {
                    kitsuid = null;
                }
                kitsuid2 = kitsuid;
                tmdbid2 = tmdbid;
                anitype5 = anitype4;
                if (StringsKt.contains(data2.getFormat(), "Movie", true)) {
                    type = TvType.Movie;
                } else {
                    type = TvType.TvSeries;
                }
                c00832.L$0 = url4;
                c00832.L$1 = id4;
                c00832.L$2 = data2;
                c00832.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                c00832.L$4 = posterurl2;
                c00832.L$5 = anititle3;
                c00832.L$6 = SpillingKt.nullOutSpilledVariable(anitype5);
                c00832.L$7 = ids2;
                c00832.L$8 = jpTitle2;
                c00832.L$9 = syncMetaData6;
                c00832.L$10 = animeMetaData;
                c00832.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid2);
                c00832.L$12 = kitsuid2;
                c00832.L$13 = SpillingKt.nullOutSpilledVariable(type);
                c00832.I$0 = aniyear3;
                c00832.label = 4;
                backgroundUrl4 = syncMetaData6;
                jpTitle3 = jpTitle2;
                id2 = id4;
                i = 1;
                ids3 = ids2;
                type2 = type;
                c00833 = c00832;
                backgroundUrl5 = anititle3;
                objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", type2, tmdbid2, "en", c00833);
                if (objFetchTmdbLogoUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data3 = data2;
                posterurl3 = kitsuid2;
                backgroundUrl6 = backgroundUrl5;
                posterurl4 = posterurl2;
                anitype6 = anitype5;
                ids4 = ids3;
                animeMetaData2 = animeMetaData;
                jpTitle4 = jpTitle3;
                url5 = id2;
                aniyear4 = aniyear3;
                type3 = type2;
                kitsuid3 = url4;
                tmdbid3 = tmdbid2;
                logoUrl = (String) objFetchTmdbLogoUrl;
                totalEps = data3.totalEpisodes();
                Iterable $this$associateWith$iv7 = new IntRange(i, totalEps);
                id3 = url5;
                kitsuid4 = posterurl3;
                result$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv7, 10)), 16));
                destination$iv$iv = result$iv;
                it = $this$associateWith$iv7.iterator();
                while (true) {
                    iIntValue = 0;
                    if (!it.hasNext()) {
                        Iterable $this$associateWith$iv8 = new IntRange(1, totalEps);
                        $i$f$associateWith = 0;
                        result$iv2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv8, 10)), 16));
                        epMetaMap = result$iv2;
                        while (r19.hasNext()) {
                            int $i$f$associateWith5 = $i$f$associateWith;
                            it3 = ((Number) element$iv$iv).intValue();
                            if (animeMetaData2 != null) {
                                url8 = kitsuid3;
                                episodes4 = animeMetaData2.getEpisodes();
                                if (episodes4 != null) {
                                    result$iv2 = result$iv2;
                                    metaEpisode = episodes4.get(String.valueOf(it3));
                                }
                                epMetaMap.put(element$iv$iv, metaEpisode);
                                $i$f$associateWith = $i$f$associateWith5;
                                kitsuid3 = url8;
                                result$iv2 = result$iv2;
                            } else {
                                url8 = kitsuid3;
                            }
                            metaEpisode = null;
                            epMetaMap.put(element$iv$iv, metaEpisode);
                            $i$f$associateWith = $i$f$associateWith5;
                            kitsuid3 = url8;
                            result$iv2 = result$iv2;
                        }
                        url6 = kitsuid3;
                        if (animeMetaData2 != null) {
                            fallbackPoster = "";
                        } else {
                            fallbackPoster = "";
                        }
                        if (animeMetaData2 != null) {
                            if (animeMetaData2 != null) {
                                str = null;
                            } else {
                                str = null;
                            }
                            if (str == null) {
                                if (animeMetaData2 != null) {
                                    str = null;
                                } else {
                                    str = null;
                                }
                                if (str != null) {
                                }
                            }
                        } else {
                            if (animeMetaData2 != null) {
                                str = null;
                            } else {
                                str = null;
                            }
                            if (str == null) {
                                if (animeMetaData2 != null) {
                                    str = null;
                                } else {
                                    str = null;
                                }
                                if (str != null) {
                                }
                            }
                        }
                        num = (Integer) destination$iv$iv.get(Boxing.boxInt(1));
                        if (num != null) {
                            anidbEid = num.intValue();
                        } else {
                            anidbEid = 0;
                        }
                        Integer idMal10 = ids4.getIdMal();
                        Integer id14 = ids4.getId();
                        if (kitsuid4 != null) {
                            intOrNull = StringsKt.toIntOrNull(kitsuid4);
                        } else {
                            intOrNull = null;
                        }
                        href = toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), id14, idMal10, data3.m46getTitle(), Boxing.boxInt(data3.getStartDate().getYear()), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(anidbEid), intOrNull, 16633983, null));
                        $this$map$iv = new IntRange(1, totalEps);
                        tmdbid4 = tmdbid3;
                        type4 = type3;
                        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        $this$mapTo$iv$iv = $this$map$iv;
                        $i$f$mapTo = 0;
                        it2 = $this$mapTo$iv$iv.iterator();
                        while (it2.hasNext()) {
                            final int item$iv$iv5 = it2.nextInt();
                            Iterable $this$map$iv5 = $this$map$iv;
                            final MetaEpisode epData4 = (MetaEpisode) epMetaMap.get(Boxing.boxInt(item$iv$iv5));
                            Integer idMal11 = ids4.getIdMal();
                            Integer id15 = ids4.getId();
                            if (kitsuid4 != null) {
                                intOrNull3 = StringsKt.toIntOrNull(kitsuid4);
                            } else {
                                intOrNull3 = null;
                            }
                            String strM46getTitle10 = data3.m46getTitle();
                            int year7 = data3.getStartDate().getYear();
                            Map epMetaMap6 = epMetaMap;
                            num3 = (Integer) destination$iv$iv.get(Boxing.boxInt(item$iv$iv5));
                            if (num3 != null) {
                                iIntValue3 = num3.intValue();
                            } else {
                                iIntValue3 = 0;
                            }
                            String linkData4 = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(item$iv$iv5), id15, idMal11, strM46getTitle10, Boxing.boxInt(year7), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(iIntValue3), intOrNull3, 8245311, null));
                            destination$iv$iv2.add(MainAPIKt.newEpisode(this, linkData4, new Function1() { // from class: com.phisher98.StreamPlayAnime$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj5) {
                                    return StreamPlayAnime.loadFromAnilist$lambda$3$0(item$iv$iv5, epData4, fallbackPoster, fallbackTitle, (Episode) obj5);
                                }
                            }));
                            $this$map$iv = $this$map$iv5;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                            $i$f$mapTo = $i$f$mapTo;
                            epMetaMap = epMetaMap6;
                            anitype6 = anitype6;
                        }
                        epMetaMap2 = epMetaMap;
                        anitype7 = anitype6;
                        episodes = (List) destination$iv$iv2;
                        List $this$mapIndexed$iv4 = episodes;
                        destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv4, 10));
                        index$iv$iv = 0;
                        while (r22.hasNext()) {
                            int index$iv$iv5 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            Episode ep4 = (Episode) item$iv$iv2;
                            int i5 = index$iv$iv + 1;
                            Integer idMal12 = ids4.getIdMal();
                            Integer id16 = ids4.getId();
                            if (kitsuid4 != null) {
                                intOrNull2 = StringsKt.toIntOrNull(kitsuid4);
                            } else {
                                intOrNull2 = null;
                            }
                            String strM46getTitle11 = data3.m46getTitle();
                            int year8 = data3.getStartDate().getYear();
                            List episodes8 = episodes;
                            num2 = (Integer) destination$iv$iv.get(Boxing.boxInt(i5));
                            if (num2 != null) {
                                iIntValue2 = num2.intValue();
                            } else {
                                iIntValue2 = 0;
                            }
                            String dubLinkData4 = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(i5), id16, idMal12, strM46getTitle11, Boxing.boxInt(year8), null, true, null, null, null, jpTitle4, null, null, false, false, false, true, Boxing.boxInt(iIntValue2), intOrNull2, 8245311, null));
                            destination$iv$iv3.add(Episode.copy$default(ep4, dubLinkData4, (String) null, (Integer) null, (Integer) null, (String) null, (Score) null, (String) null, (Long) null, (Integer) null, 510, (Object) null));
                            episodes = episodes8;
                            index$iv$iv = index$iv$iv5;
                        }
                        episodes2 = episodes;
                        episodesDub = (List) destination$iv$iv3;
                        if (StringsKt.contains(data3.getFormat(), "Movie", true)) {
                            String fallbackTitle10 = fallbackTitle;
                            String fallbackTitle11 = data3.m46getTitle();
                            TvType tvType9 = TvType.AnimeMovie;
                            C00842 c00845 = new C00842(id3, ids4, kitsuid4, data3, backgroundUrl6, animeMetaData2, posterurl4, logoUrl, null);
                            c00833.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                            c00833.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                            c00833.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                            c00833.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                            c00833.L$4 = SpillingKt.nullOutSpilledVariable(posterurl4);
                            c00833.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl6);
                            c00833.L$6 = SpillingKt.nullOutSpilledVariable(anitype7);
                            c00833.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                            c00833.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                            c00833.L$9 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                            c00833.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                            c00833.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid4);
                            c00833.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                            c00833.L$13 = SpillingKt.nullOutSpilledVariable(type4);
                            c00833.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                            c00833.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                            c00833.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                            c00833.L$17 = SpillingKt.nullOutSpilledVariable(fallbackPoster);
                            c00833.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle10);
                            c00833.L$19 = SpillingKt.nullOutSpilledVariable(href);
                            c00833.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                            c00833.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                            c00833.I$0 = aniyear4;
                            c00833.I$1 = totalEps;
                            c00833.I$2 = anidbEid;
                            c00833.label = 5;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, fallbackTitle11, url6, tvType9, href, c00845, c00833);
                            if (objNewMovieLoadResponse == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        fallbackTitle2 = fallbackTitle;
                        logoUrl2 = fallbackPoster;
                        anidbEid2 = anidbEid;
                        String strM46getTitle12 = data3.m46getTitle();
                        TvType tvType10 = TvType.Anime;
                        syncMetaData = backgroundUrl4;
                        C00831 c00838 = c00833;
                        C00853 c00856 = new C00853(id3, ids4, kitsuid4, episodes2, episodesDub, logoUrl, data3, animeMetaData2, this, null);
                        c00838.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00838.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                        c00838.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                        c00838.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                        c00838.L$4 = SpillingKt.nullOutSpilledVariable(posterurl4);
                        c00838.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl6);
                        c00838.L$6 = SpillingKt.nullOutSpilledVariable(anitype7);
                        c00838.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                        c00838.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                        c00838.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                        c00838.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                        c00838.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid4);
                        c00838.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                        c00838.L$13 = SpillingKt.nullOutSpilledVariable(type4);
                        c00838.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                        c00838.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                        c00838.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                        c00838.L$17 = SpillingKt.nullOutSpilledVariable(logoUrl2);
                        c00838.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle2);
                        c00838.L$19 = SpillingKt.nullOutSpilledVariable(href);
                        c00838.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                        c00838.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                        c00838.I$0 = aniyear4;
                        c00838.I$1 = totalEps;
                        c00838.I$2 = anidbEid2;
                        c00838.label = 6;
                        url7 = url6;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, strM46getTitle12, url7, tvType10, false, c00856, c00838, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        episodes3 = episodes2;
                        episodesDub2 = episodesDub;
                        obj4 = objNewAnimeLoadResponse$default;
                        totalEps2 = totalEps;
                        anidbEid3 = anidbEid2;
                        href2 = href;
                        fallbackTitle3 = fallbackTitle2;
                        anidbEidMap = destination$iv$iv;
                        logoUrl3 = logoUrl;
                        fallbackPoster2 = logoUrl2;
                        anititle4 = anititle2;
                        type5 = type4;
                        syncMetaData2 = syncMetaData;
                        return (LoadResponse) obj4;
                    }
                    Object element$iv$iv5 = it.next();
                    int it7 = ((Number) element$iv$iv5).intValue();
                    LinkedHashMap result$iv6 = result$iv;
                    anidbEid4 = StreamPlayUtilsKt.getAnidbEid(backgroundUrl4, Boxing.boxInt(it7));
                    if (anidbEid4 != null) {
                        iIntValue = anidbEid4.intValue();
                    }
                    destination$iv$iv.put(element$iv$iv5, Boxing.boxInt(iIntValue));
                    result$iv = result$iv6;
                }
                break;
            case 4:
                int aniyear6 = c00834.I$0;
                TvType type6 = (TvType) c00834.L$13;
                String kitsuid5 = (String) c00834.L$12;
                Integer tmdbid5 = (Integer) c00834.L$11;
                MetaAnimeData animeMetaData3 = (MetaAnimeData) c00834.L$10;
                String syncMetaData7 = (String) c00834.L$9;
                String jpTitle6 = (String) c00834.L$8;
                AniIds ids6 = (AniIds) c00834.L$7;
                anitype6 = (TvType) c00834.L$6;
                String backgroundUrl7 = (String) c00834.L$5;
                String posterurl6 = (String) c00834.L$4;
                String anititle6 = (String) c00834.L$3;
                AnilistAPIResponse.anilistMedia data5 = (AnilistAPIResponse.anilistMedia) c00834.L$2;
                String id17 = (String) c00834.L$1;
                String url10 = (String) c00834.L$0;
                ResultKt.throwOnFailure($result);
                posterurl4 = posterurl6;
                posterurl3 = kitsuid5;
                animeMetaData2 = animeMetaData3;
                jpTitle4 = jpTitle6;
                ids4 = ids6;
                backgroundUrl6 = backgroundUrl7;
                aniyear4 = aniyear6;
                anititle2 = anititle6;
                data3 = data5;
                kitsuid3 = url10;
                type3 = type6;
                backgroundUrl4 = syncMetaData7;
                c00833 = c00834;
                objFetchTmdbLogoUrl = $result;
                url5 = id17;
                i = 1;
                tmdbid3 = tmdbid5;
                logoUrl = (String) objFetchTmdbLogoUrl;
                totalEps = data3.totalEpisodes();
                Iterable $this$associateWith$iv9 = new IntRange(i, totalEps);
                id3 = url5;
                kitsuid4 = posterurl3;
                result$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv9, 10)), 16));
                destination$iv$iv = result$iv;
                it = $this$associateWith$iv9.iterator();
                while (true) {
                    iIntValue = 0;
                    if (!it.hasNext()) {
                        Iterable $this$associateWith$iv10 = new IntRange(1, totalEps);
                        $i$f$associateWith = 0;
                        result$iv2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv10, 10)), 16));
                        epMetaMap = result$iv2;
                        while (r19.hasNext()) {
                            int $i$f$associateWith6 = $i$f$associateWith;
                            it3 = ((Number) element$iv$iv).intValue();
                            if (animeMetaData2 != null) {
                                url8 = kitsuid3;
                                episodes4 = animeMetaData2.getEpisodes();
                                if (episodes4 != null) {
                                    result$iv2 = result$iv2;
                                    metaEpisode = episodes4.get(String.valueOf(it3));
                                }
                                epMetaMap.put(element$iv$iv, metaEpisode);
                                $i$f$associateWith = $i$f$associateWith6;
                                kitsuid3 = url8;
                                result$iv2 = result$iv2;
                            } else {
                                url8 = kitsuid3;
                            }
                            metaEpisode = null;
                            epMetaMap.put(element$iv$iv, metaEpisode);
                            $i$f$associateWith = $i$f$associateWith6;
                            kitsuid3 = url8;
                            result$iv2 = result$iv2;
                        }
                        url6 = kitsuid3;
                        if (animeMetaData2 != null) {
                            fallbackPoster = "";
                        } else {
                            fallbackPoster = "";
                        }
                        if (animeMetaData2 != null) {
                            if (animeMetaData2 != null) {
                                str = null;
                            } else {
                                str = null;
                            }
                            if (str == null) {
                                if (animeMetaData2 != null) {
                                    str = null;
                                } else {
                                    str = null;
                                }
                                if (str != null) {
                                }
                            }
                        } else {
                            if (animeMetaData2 != null) {
                                str = null;
                            } else {
                                str = null;
                            }
                            if (str == null) {
                                if (animeMetaData2 != null) {
                                    str = null;
                                } else {
                                    str = null;
                                }
                                if (str != null) {
                                }
                            }
                        }
                        num = (Integer) destination$iv$iv.get(Boxing.boxInt(1));
                        if (num != null) {
                            anidbEid = num.intValue();
                        } else {
                            anidbEid = 0;
                        }
                        Integer idMal13 = ids4.getIdMal();
                        Integer id18 = ids4.getId();
                        if (kitsuid4 != null) {
                            intOrNull = StringsKt.toIntOrNull(kitsuid4);
                        } else {
                            intOrNull = null;
                        }
                        href = toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), id18, idMal13, data3.m46getTitle(), Boxing.boxInt(data3.getStartDate().getYear()), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(anidbEid), intOrNull, 16633983, null));
                        $this$map$iv = new IntRange(1, totalEps);
                        tmdbid4 = tmdbid3;
                        type4 = type3;
                        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        $this$mapTo$iv$iv = $this$map$iv;
                        $i$f$mapTo = 0;
                        it2 = $this$mapTo$iv$iv.iterator();
                        while (it2.hasNext()) {
                            final int item$iv$iv6 = it2.nextInt();
                            Iterable $this$map$iv6 = $this$map$iv;
                            final MetaEpisode epData5 = (MetaEpisode) epMetaMap.get(Boxing.boxInt(item$iv$iv6));
                            Integer idMal14 = ids4.getIdMal();
                            Integer id19 = ids4.getId();
                            if (kitsuid4 != null) {
                                intOrNull3 = StringsKt.toIntOrNull(kitsuid4);
                            } else {
                                intOrNull3 = null;
                            }
                            String strM46getTitle13 = data3.m46getTitle();
                            int year9 = data3.getStartDate().getYear();
                            Map epMetaMap7 = epMetaMap;
                            num3 = (Integer) destination$iv$iv.get(Boxing.boxInt(item$iv$iv6));
                            if (num3 != null) {
                                iIntValue3 = num3.intValue();
                            } else {
                                iIntValue3 = 0;
                            }
                            String linkData5 = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(item$iv$iv6), id19, idMal14, strM46getTitle13, Boxing.boxInt(year9), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(iIntValue3), intOrNull3, 8245311, null));
                            destination$iv$iv2.add(MainAPIKt.newEpisode(this, linkData5, new Function1() { // from class: com.phisher98.StreamPlayAnime$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj5) {
                                    return StreamPlayAnime.loadFromAnilist$lambda$3$0(item$iv$iv6, epData5, fallbackPoster, fallbackTitle, (Episode) obj5);
                                }
                            }));
                            $this$map$iv = $this$map$iv6;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                            $i$f$mapTo = $i$f$mapTo;
                            epMetaMap = epMetaMap7;
                            anitype6 = anitype6;
                        }
                        epMetaMap2 = epMetaMap;
                        anitype7 = anitype6;
                        episodes = (List) destination$iv$iv2;
                        List $this$mapIndexed$iv5 = episodes;
                        destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv5, 10));
                        index$iv$iv = 0;
                        while (r22.hasNext()) {
                            int index$iv$iv6 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            Episode ep5 = (Episode) item$iv$iv2;
                            int i6 = index$iv$iv + 1;
                            Integer idMal15 = ids4.getIdMal();
                            Integer id110 = ids4.getId();
                            if (kitsuid4 != null) {
                                intOrNull2 = StringsKt.toIntOrNull(kitsuid4);
                            } else {
                                intOrNull2 = null;
                            }
                            String strM46getTitle14 = data3.m46getTitle();
                            int year10 = data3.getStartDate().getYear();
                            List episodes9 = episodes;
                            num2 = (Integer) destination$iv$iv.get(Boxing.boxInt(i6));
                            if (num2 != null) {
                                iIntValue2 = num2.intValue();
                            } else {
                                iIntValue2 = 0;
                            }
                            String dubLinkData5 = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(i6), id110, idMal15, strM46getTitle14, Boxing.boxInt(year10), null, true, null, null, null, jpTitle4, null, null, false, false, false, true, Boxing.boxInt(iIntValue2), intOrNull2, 8245311, null));
                            destination$iv$iv3.add(Episode.copy$default(ep5, dubLinkData5, (String) null, (Integer) null, (Integer) null, (String) null, (Score) null, (String) null, (Long) null, (Integer) null, 510, (Object) null));
                            episodes = episodes9;
                            index$iv$iv = index$iv$iv6;
                        }
                        episodes2 = episodes;
                        episodesDub = (List) destination$iv$iv3;
                        if (StringsKt.contains(data3.getFormat(), "Movie", true)) {
                            String fallbackTitle12 = fallbackTitle;
                            String fallbackTitle13 = data3.m46getTitle();
                            TvType tvType11 = TvType.AnimeMovie;
                            C00842 c00846 = new C00842(id3, ids4, kitsuid4, data3, backgroundUrl6, animeMetaData2, posterurl4, logoUrl, null);
                            c00833.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                            c00833.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                            c00833.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                            c00833.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                            c00833.L$4 = SpillingKt.nullOutSpilledVariable(posterurl4);
                            c00833.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl6);
                            c00833.L$6 = SpillingKt.nullOutSpilledVariable(anitype7);
                            c00833.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                            c00833.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                            c00833.L$9 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                            c00833.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                            c00833.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid4);
                            c00833.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                            c00833.L$13 = SpillingKt.nullOutSpilledVariable(type4);
                            c00833.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                            c00833.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                            c00833.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                            c00833.L$17 = SpillingKt.nullOutSpilledVariable(fallbackPoster);
                            c00833.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle12);
                            c00833.L$19 = SpillingKt.nullOutSpilledVariable(href);
                            c00833.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                            c00833.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                            c00833.I$0 = aniyear4;
                            c00833.I$1 = totalEps;
                            c00833.I$2 = anidbEid;
                            c00833.label = 5;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, fallbackTitle13, url6, tvType11, href, c00846, c00833);
                            if (objNewMovieLoadResponse == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        fallbackTitle2 = fallbackTitle;
                        logoUrl2 = fallbackPoster;
                        anidbEid2 = anidbEid;
                        String strM46getTitle15 = data3.m46getTitle();
                        TvType tvType12 = TvType.Anime;
                        syncMetaData = backgroundUrl4;
                        C00831 c00839 = c00833;
                        C00853 c00857 = new C00853(id3, ids4, kitsuid4, episodes2, episodesDub, logoUrl, data3, animeMetaData2, this, null);
                        c00839.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00839.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                        c00839.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                        c00839.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                        c00839.L$4 = SpillingKt.nullOutSpilledVariable(posterurl4);
                        c00839.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl6);
                        c00839.L$6 = SpillingKt.nullOutSpilledVariable(anitype7);
                        c00839.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                        c00839.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                        c00839.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                        c00839.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                        c00839.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid4);
                        c00839.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                        c00839.L$13 = SpillingKt.nullOutSpilledVariable(type4);
                        c00839.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                        c00839.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                        c00839.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                        c00839.L$17 = SpillingKt.nullOutSpilledVariable(logoUrl2);
                        c00839.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle2);
                        c00839.L$19 = SpillingKt.nullOutSpilledVariable(href);
                        c00839.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                        c00839.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                        c00839.I$0 = aniyear4;
                        c00839.I$1 = totalEps;
                        c00839.I$2 = anidbEid2;
                        c00839.label = 6;
                        url7 = url6;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, strM46getTitle15, url7, tvType12, false, c00857, c00839, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        episodes3 = episodes2;
                        episodesDub2 = episodesDub;
                        obj4 = objNewAnimeLoadResponse$default;
                        totalEps2 = totalEps;
                        anidbEid3 = anidbEid2;
                        href2 = href;
                        fallbackTitle3 = fallbackTitle2;
                        anidbEidMap = destination$iv$iv;
                        logoUrl3 = logoUrl;
                        fallbackPoster2 = logoUrl2;
                        anititle4 = anititle2;
                        type5 = type4;
                        syncMetaData2 = syncMetaData;
                        return (LoadResponse) obj4;
                    }
                    Object element$iv$iv6 = it.next();
                    int it8 = ((Number) element$iv$iv6).intValue();
                    LinkedHashMap result$iv7 = result$iv;
                    anidbEid4 = StreamPlayUtilsKt.getAnidbEid(backgroundUrl4, Boxing.boxInt(it8));
                    if (anidbEid4 != null) {
                        iIntValue = anidbEid4.intValue();
                    }
                    destination$iv$iv.put(element$iv$iv6, Boxing.boxInt(iIntValue));
                    result$iv = result$iv7;
                }
                break;
            case 5:
                int i7 = c00834.I$2;
                int i8 = c00834.I$1;
                int i9 = c00834.I$0;
                ResultKt.throwOnFailure($result);
                objNewMovieLoadResponse = $result;
                return (LoadResponse) objNewMovieLoadResponse;
            case 6:
                anidbEid3 = c00834.I$2;
                totalEps2 = c00834.I$1;
                int aniyear7 = c00834.I$0;
                episodesDub2 = (List) c00834.L$21;
                episodes3 = (List) c00834.L$20;
                String href3 = (String) c00834.L$19;
                fallbackTitle3 = (String) c00834.L$18;
                fallbackPoster2 = (String) c00834.L$17;
                anidbEidMap = (Map) c00834.L$15;
                logoUrl3 = (String) c00834.L$14;
                type5 = (TvType) c00834.L$13;
                syncMetaData2 = (String) c00834.L$9;
                anititle4 = (String) c00834.L$3;
                AnilistAPIResponse.anilistMedia data6 = (AnilistAPIResponse.anilistMedia) c00834.L$2;
                String url11 = (String) c00834.L$0;
                ResultKt.throwOnFailure($result);
                href2 = href3;
                data3 = data6;
                aniyear4 = aniyear7;
                url7 = url11;
                obj4 = $result;
                return (LoadResponse) obj4;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final String loadFromAnilist$resolveTitle(String fallbackTitle, MetaEpisode epData) {
        String jsonTitle;
        Map<String, String> title;
        Map<String, String> title2;
        String episode;
        Map<String, String> title3;
        if (epData == null || (title3 = epData.getTitle()) == null || (jsonTitle = title3.get("en")) == null) {
            jsonTitle = null;
            String str = (epData == null || (title2 = epData.getTitle()) == null) ? null : title2.get("ja");
            if (str == null) {
                if (epData != null && (title = epData.getTitle()) != null) {
                    jsonTitle = title.get("x-jat");
                }
                if (jsonTitle == null) {
                    jsonTitle = fallbackTitle;
                }
            } else {
                jsonTitle = str;
            }
        }
        String string = jsonTitle;
        if (StringsKt.isBlank(string)) {
            StringBuilder sbAppend = new StringBuilder().append("Episode ");
            if (epData == null || (episode = epData.getEpisode()) == null) {
                episode = "";
            }
            string = sbAppend.append(episode).toString();
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadFromAnilist$lambda$3$0(int $i, MetaEpisode $epData, String $fallbackPoster, String $fallbackTitle, Episode $this$newEpisode) {
        String image;
        String overview;
        $this$newEpisode.setSeason(1);
        $this$newEpisode.setEpisode(Integer.valueOf($i));
        $this$newEpisode.setName(loadFromAnilist$resolveTitle($fallbackTitle, $epData));
        if ($epData == null || (image = $epData.getImage()) == null) {
            image = $fallbackPoster;
        }
        $this$newEpisode.setPosterUrl(image);
        if ($epData == null || (overview = $epData.getOverview()) == null) {
            overview = "No summary available";
        }
        $this$newEpisode.setDescription(overview);
        $this$newEpisode.setScore(Score.Companion.from10($epData != null ? $epData.getRating() : null));
        $this$newEpisode.setRunTime($epData != null ? $epData.getRuntime() : null);
        MainAPIKt.addDate$default($this$newEpisode, $epData != null ? $epData.getAirdate() : null, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadFromAnilist$2 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadFromAnilist$2", f = "StreamPlayAnime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayAnime.kt\ncom/phisher98/StreamPlayAnime$loadFromAnilist$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,781:1\n296#2,2:782\n296#2,2:784\n*S KotlinDebug\n*F\n+ 1 StreamPlayAnime.kt\ncom/phisher98/StreamPlayAnime$loadFromAnilist$2\n*L\n346#1:782,2\n348#1:784,2\n*E\n"})
    static final class C00842 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ MetaAnimeData $animeMetaData;
        final /* synthetic */ String $backgroundUrl;
        final /* synthetic */ AnilistAPIResponse.anilistMedia $data;
        final /* synthetic */ String $id;
        final /* synthetic */ AniIds $ids;
        final /* synthetic */ String $kitsuid;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ String $posterurl;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00842(String str, AniIds aniIds, String str2, AnilistAPIResponse.anilistMedia anilistmedia, String str3, MetaAnimeData metaAnimeData, String str4, String str5, Continuation<? super C00842> continuation) {
            super(2, continuation);
            this.$id = str;
            this.$ids = aniIds;
            this.$kitsuid = str2;
            this.$data = anilistmedia;
            this.$backgroundUrl = str3;
            this.$animeMetaData = metaAnimeData;
            this.$posterurl = str4;
            this.$logoUrl = str5;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00842 = new C00842(this.$id, this.$ids, this.$kitsuid, this.$data, this.$backgroundUrl, this.$animeMetaData, this.$posterurl, this.$logoUrl, continuation);
            c00842.L$0 = obj;
            return c00842;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0093  */
        /* JADX WARN: Code duplicated, block: B:26:0x0098  */
        /* JADX WARN: Code duplicated, block: B:46:0x00e5  */
        public final Object invokeSuspend(Object $result) {
            Iterable images;
            Object element$iv;
            ImageData imageData;
            ImageData it;
            Iterable images2;
            Object element$iv2;
            ImageData imageData2;
            ImageData it2;
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    LoadResponse.Companion.addAniListId(loadResponse, Boxing.boxInt(Integer.parseInt(this.$id)));
                    LoadResponse.Companion.addMalId(loadResponse, this.$ids.getIdMal());
                    try {
                        LoadResponse.Companion.addKitsuId(loadResponse, this.$kitsuid);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setYear(Boxing.boxInt(this.$data.getStartDate().getYear()));
                    loadResponse.setPlot(this.$data.getDescription());
                    String bannerImage = this.$backgroundUrl;
                    String url = null;
                    if (bannerImage == null) {
                        MetaAnimeData metaAnimeData = this.$animeMetaData;
                        if (metaAnimeData == null || (images2 = metaAnimeData.getImages()) == null) {
                            bannerImage = null;
                        } else {
                            Iterable $this$firstOrNull$iv = images2;
                            Iterator it3 = $this$firstOrNull$iv.iterator();
                            do {
                                if (it3.hasNext()) {
                                    element$iv2 = it3.next();
                                    it2 = (ImageData) element$iv2;
                                } else {
                                    element$iv2 = null;
                                }
                                imageData2 = (ImageData) element$iv2;
                                if (imageData2 != null) {
                                    bannerImage = imageData2.getUrl();
                                } else {
                                    bannerImage = null;
                                }
                            } while (!Intrinsics.areEqual(it2.getCoverType(), "Fanart"));
                            imageData2 = (ImageData) element$iv2;
                            if (imageData2 != null) {
                                bannerImage = imageData2.getUrl();
                            } else {
                                bannerImage = null;
                            }
                        }
                        if (bannerImage == null) {
                            bannerImage = this.$data.getBannerImage();
                        }
                    }
                    loadResponse.setBackgroundPosterUrl(bannerImage);
                    String strM45getCoverImage = this.$posterurl;
                    if (strM45getCoverImage == null && (strM45getCoverImage = this.$data.m45getCoverImage()) == null) {
                        MetaAnimeData metaAnimeData2 = this.$animeMetaData;
                        if (metaAnimeData2 != null && (images = metaAnimeData2.getImages()) != null) {
                            Iterable $this$firstOrNull$iv2 = images;
                            Iterator it4 = $this$firstOrNull$iv2.iterator();
                            do {
                                if (it4.hasNext()) {
                                    element$iv = it4.next();
                                    it = (ImageData) element$iv;
                                } else {
                                    element$iv = null;
                                }
                                imageData = (ImageData) element$iv;
                                if (imageData != null) {
                                    url = imageData.getUrl();
                                }
                            } while (!StringsKt.equals(it.getCoverType(), "Poster", true));
                            imageData = (ImageData) element$iv;
                            if (imageData != null) {
                                url = imageData.getUrl();
                            }
                        }
                    } else {
                        url = strM45getCoverImage;
                    }
                    loadResponse.setPosterUrl(url);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th2) {
                    }
                    loadResponse.setTags(this.$data.getGenres());
                    loadResponse.setScore(Score.Companion.from100(Boxing.boxInt(this.$data.getAverageScore())));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadFromAnilist$3 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadFromAnilist$3", f = "StreamPlayAnime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayAnime.kt\ncom/phisher98/StreamPlayAnime$loadFromAnilist$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,781:1\n296#2,2:782\n296#2,2:784\n1795#2,10:786\n2068#2:796\n2069#2:798\n1805#2:799\n1#3:797\n*S KotlinDebug\n*F\n+ 1 StreamPlayAnime.kt\ncom/phisher98/StreamPlayAnime$loadFromAnilist$3\n*L\n363#1:782,2\n365#1:784,2\n370#1:786,10\n370#1:796\n370#1:798\n370#1:799\n370#1:797\n*E\n"})
    static final class C00853 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ MetaAnimeData $animeMetaData;
        final /* synthetic */ AnilistAPIResponse.anilistMedia $data;
        final /* synthetic */ List<Episode> $episodes;
        final /* synthetic */ List<Episode> $episodesDub;
        final /* synthetic */ String $id;
        final /* synthetic */ AniIds $ids;
        final /* synthetic */ String $kitsuid;
        final /* synthetic */ String $logoUrl;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ StreamPlayAnime this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00853(String str, AniIds aniIds, String str2, List<Episode> list, List<Episode> list2, String str3, AnilistAPIResponse.anilistMedia anilistmedia, MetaAnimeData metaAnimeData, StreamPlayAnime streamPlayAnime, Continuation<? super C00853> continuation) {
            super(2, continuation);
            this.$id = str;
            this.$ids = aniIds;
            this.$kitsuid = str2;
            this.$episodes = list;
            this.$episodesDub = list2;
            this.$logoUrl = str3;
            this.$data = anilistmedia;
            this.$animeMetaData = metaAnimeData;
            this.this$0 = streamPlayAnime;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00853 = new C00853(this.$id, this.$ids, this.$kitsuid, this.$episodes, this.$episodesDub, this.$logoUrl, this.$data, this.$animeMetaData, this.this$0, continuation);
            c00853.L$0 = obj;
            return c00853;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x00ac  */
        /* JADX WARN: Code duplicated, block: B:45:0x00f2  */
        /* JADX WARN: Code duplicated, block: B:46:0x00f7  */
        public final Object invokeSuspend(Object $result) {
            String bannerImage;
            ArrayList arrayList;
            Iterable edges;
            String romaji;
            AnimeSearchResponse animeSearchResponse;
            Iterable images;
            Object element$iv;
            ImageData imageData;
            ImageData it;
            Iterable images2;
            Object element$iv2;
            ImageData imageData2;
            ImageData it2;
            LoadResponse loadResponse = (AnimeLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    LoadResponse.Companion.addAniListId(loadResponse, Boxing.boxInt(Integer.parseInt(this.$id)));
                    LoadResponse.Companion.addMalId(loadResponse, this.$ids.getIdMal());
                    try {
                        LoadResponse.Companion.addKitsuId(loadResponse, this.$kitsuid);
                        break;
                    } catch (Throwable th) {
                    }
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$episodes);
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Dubbed, this.$episodesDub);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th2) {
                    }
                    loadResponse.setYear(Boxing.boxInt(this.$data.getStartDate().getYear()));
                    loadResponse.setPlot(this.$data.getDescription());
                    MetaAnimeData metaAnimeData = this.$animeMetaData;
                    if (metaAnimeData == null || (images2 = metaAnimeData.getImages()) == null) {
                        bannerImage = this.$data.getBannerImage();
                    } else {
                        Iterable $this$firstOrNull$iv = images2;
                        Iterator it3 = $this$firstOrNull$iv.iterator();
                        do {
                            if (it3.hasNext()) {
                                element$iv2 = it3.next();
                                it2 = (ImageData) element$iv2;
                            } else {
                                element$iv2 = null;
                            }
                            imageData2 = (ImageData) element$iv2;
                            if (imageData2 != null || (bannerImage = imageData2.getUrl()) == null) {
                                bannerImage = this.$data.getBannerImage();
                            }
                        } while (!Intrinsics.areEqual(it2.getCoverType(), "Fanart"));
                        imageData2 = (ImageData) element$iv2;
                        if (imageData2 != null) {
                            bannerImage = this.$data.getBannerImage();
                        } else {
                            bannerImage = this.$data.getBannerImage();
                        }
                    }
                    loadResponse.setBackgroundPosterUrl(bannerImage);
                    String strM45getCoverImage = this.$data.m45getCoverImage();
                    if (strM45getCoverImage == null) {
                        MetaAnimeData metaAnimeData2 = this.$animeMetaData;
                        if (metaAnimeData2 == null || (images = metaAnimeData2.getImages()) == null) {
                            strM45getCoverImage = null;
                        } else {
                            Iterable $this$firstOrNull$iv2 = images;
                            Iterator it4 = $this$firstOrNull$iv2.iterator();
                            do {
                                if (it4.hasNext()) {
                                    element$iv = it4.next();
                                    it = (ImageData) element$iv;
                                } else {
                                    element$iv = null;
                                }
                                imageData = (ImageData) element$iv;
                                if (imageData != null) {
                                    strM45getCoverImage = imageData.getUrl();
                                } else {
                                    strM45getCoverImage = null;
                                }
                            } while (!StringsKt.equals(it.getCoverType(), "Poster", true));
                            imageData = (ImageData) element$iv;
                            if (imageData != null) {
                                strM45getCoverImage = imageData.getUrl();
                            } else {
                                strM45getCoverImage = null;
                            }
                        }
                    }
                    loadResponse.setPosterUrl(strM45getCoverImage);
                    loadResponse.setTags(this.$data.getGenres());
                    loadResponse.setScore(Score.Companion.from100(Boxing.boxInt(this.$data.getAverageScore())));
                    loadResponse.setShowStatus(this.this$0.getStatus(this.$data.getStatus()));
                    AniListApi.RecommendationConnection recommendations = this.$data.getRecommendations();
                    if (recommendations == null || (edges = recommendations.getEdges()) == null) {
                        arrayList = null;
                    } else {
                        Iterable $this$mapNotNull$iv = edges;
                        StreamPlayAnime streamPlayAnime = this.this$0;
                        Collection destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                            AniListApi.RecommendationEdge edge = (AniListApi.RecommendationEdge) element$iv$iv$iv;
                            AniListApi.RecommendedMedia recommendation = edge.getNode().getMediaRecommendation();
                            if (recommendation == null) {
                                animeSearchResponse = null;
                            } else {
                                AniListApi.MediaTitle title = recommendation.getTitle();
                                if (title == null || (romaji = title.getEnglish()) == null) {
                                    AniListApi.MediaTitle title2 = recommendation.getTitle();
                                    romaji = title2 != null ? title2.getRomaji() : null;
                                    if (romaji == null) {
                                        romaji = "Unknown";
                                    }
                                }
                                String title3 = romaji;
                                AnimeSearchResponse $this$invokeSuspend_u24lambda_u242_u240 = MainAPIKt.newAnimeSearchResponse$default(streamPlayAnime, title3, streamPlayAnime.getMainUrl() + "/anime/" + recommendation.getId(), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                AniListApi.MediaCoverImage coverImage = recommendation.getCoverImage();
                                $this$invokeSuspend_u24lambda_u242_u240.setPosterUrl(coverImage != null ? coverImage.getLarge() : null);
                                animeSearchResponse = $this$invokeSuspend_u24lambda_u242_u240;
                            }
                            if (animeSearchResponse != null) {
                                destination$iv$iv.add(animeSearchResponse);
                            }
                            $this$mapNotNull$iv = $this$mapNotNull$iv;
                        }
                        arrayList = (List) destination$iv$iv;
                    }
                    loadResponse.setRecommendations(arrayList);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x049a  */
    /* JADX WARN: Code duplicated, block: B:102:0x049e  */
    /* JADX WARN: Code duplicated, block: B:103:0x04a1  */
    /* JADX WARN: Code duplicated, block: B:106:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:108:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:109:0x04b8  */
    /* JADX WARN: Code duplicated, block: B:111:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:114:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:115:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:124:0x04ec  */
    /* JADX WARN: Code duplicated, block: B:126:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:129:0x0550 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:130:0x0551  */
    /* JADX WARN: Code duplicated, block: B:133:0x056d  */
    /* JADX WARN: Code duplicated, block: B:139:0x0582  */
    /* JADX WARN: Code duplicated, block: B:141:0x0588  */
    /* JADX WARN: Code duplicated, block: B:143:0x0598  */
    /* JADX WARN: Code duplicated, block: B:144:0x059d  */
    /* JADX WARN: Code duplicated, block: B:147:0x05a5  */
    /* JADX WARN: Code duplicated, block: B:150:0x05b0  */
    /* JADX WARN: Code duplicated, block: B:152:0x05b3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:161:0x066b  */
    /* JADX WARN: Code duplicated, block: B:162:0x066e  */
    /* JADX WARN: Code duplicated, block: B:165:0x0676  */
    /* JADX WARN: Code duplicated, block: B:166:0x0679  */
    /* JADX WARN: Code duplicated, block: B:169:0x0680  */
    /* JADX WARN: Code duplicated, block: B:174:0x068f A[PHI: r9
      0x068f: PHI (r9v70 java.lang.String) = (r9v34 java.lang.String), (r9v37 java.lang.String), (r9v73 java.lang.String) binds: [B:180:0x06a2, B:185:0x06b2, B:172:0x068c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:175:0x0692 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:176:0x0694  */
    /* JADX WARN: Code duplicated, block: B:179:0x06a1  */
    /* JADX WARN: Code duplicated, block: B:181:0x06a4  */
    /* JADX WARN: Code duplicated, block: B:183:0x06aa  */
    /* JADX WARN: Code duplicated, block: B:184:0x06b1  */
    /* JADX WARN: Code duplicated, block: B:186:0x06b4  */
    /* JADX WARN: Code duplicated, block: B:189:0x06bc  */
    /* JADX WARN: Code duplicated, block: B:190:0x06be  */
    /* JADX WARN: Code duplicated, block: B:203:0x0707  */
    /* JADX WARN: Code duplicated, block: B:205:0x0710  */
    /* JADX WARN: Code duplicated, block: B:208:0x071e  */
    /* JADX WARN: Code duplicated, block: B:209:0x0720  */
    /* JADX WARN: Code duplicated, block: B:214:0x0733  */
    /* JADX WARN: Code duplicated, block: B:217:0x074b A[LOOP:1: B:212:0x072d->B:217:0x074b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:221:0x0755  */
    /* JADX WARN: Code duplicated, block: B:223:0x075c A[PHI: r3
      0x075c: PHI (r3v6 java.lang.String) = (r3v5 java.lang.String), (r3v61 java.lang.String) binds: [B:207:0x071c, B:221:0x0755] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:226:0x0765  */
    /* JADX WARN: Code duplicated, block: B:229:0x0772  */
    /* JADX WARN: Code duplicated, block: B:230:0x0777  */
    /* JADX WARN: Code duplicated, block: B:231:0x0779  */
    /* JADX WARN: Code duplicated, block: B:234:0x0784  */
    /* JADX WARN: Code duplicated, block: B:238:0x07b4  */
    /* JADX WARN: Code duplicated, block: B:240:0x07c4  */
    /* JADX WARN: Code duplicated, block: B:242:0x07d6  */
    /* JADX WARN: Code duplicated, block: B:243:0x07db  */
    /* JADX WARN: Code duplicated, block: B:249:0x081d  */
    /* JADX WARN: Code duplicated, block: B:251:0x082f  */
    /* JADX WARN: Code duplicated, block: B:253:0x0837  */
    /* JADX WARN: Code duplicated, block: B:254:0x0844  */
    /* JADX WARN: Code duplicated, block: B:255:0x0847  */
    /* JADX WARN: Code duplicated, block: B:260:0x0860  */
    /* JADX WARN: Code duplicated, block: B:261:0x0862  */
    /* JADX WARN: Code duplicated, block: B:266:0x0875  */
    /* JADX WARN: Code duplicated, block: B:268:0x0878  */
    /* JADX WARN: Code duplicated, block: B:270:0x087c  */
    /* JADX WARN: Code duplicated, block: B:272:0x0880  */
    /* JADX WARN: Code duplicated, block: B:276:0x0890 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:277:0x0892  */
    /* JADX WARN: Code duplicated, block: B:280:0x089f  */
    /* JADX WARN: Code duplicated, block: B:282:0x08a2  */
    /* JADX WARN: Code duplicated, block: B:283:0x08a4  */
    /* JADX WARN: Code duplicated, block: B:286:0x08b1  */
    /* JADX WARN: Code duplicated, block: B:288:0x08b4  */
    /* JADX WARN: Code duplicated, block: B:289:0x08b7  */
    /* JADX WARN: Code duplicated, block: B:290:0x08b9  */
    /* JADX WARN: Code duplicated, block: B:293:0x08c9  */
    /* JADX WARN: Code duplicated, block: B:294:0x08ce  */
    /* JADX WARN: Code duplicated, block: B:297:0x092e  */
    /* JADX WARN: Code duplicated, block: B:300:0x0950  */
    /* JADX WARN: Code duplicated, block: B:302:0x0958  */
    /* JADX WARN: Code duplicated, block: B:305:0x096c  */
    /* JADX WARN: Code duplicated, block: B:306:0x0971  */
    /* JADX WARN: Code duplicated, block: B:309:0x09ce  */
    /* JADX WARN: Code duplicated, block: B:312:0x0a08 A[LOOP:8: B:310:0x0a02->B:312:0x0a08, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:317:0x0a61  */
    /* JADX WARN: Code duplicated, block: B:319:0x0a69  */
    /* JADX WARN: Code duplicated, block: B:322:0x0a7c  */
    /* JADX WARN: Code duplicated, block: B:325:0x0a87  */
    /* JADX WARN: Code duplicated, block: B:329:0x0ac6  */
    /* JADX WARN: Code duplicated, block: B:332:0x0adb  */
    /* JADX WARN: Code duplicated, block: B:335:0x0ae3  */
    /* JADX WARN: Code duplicated, block: B:338:0x0af9  */
    /* JADX WARN: Code duplicated, block: B:340:0x0b12  */
    /* JADX WARN: Code duplicated, block: B:345:0x0b3a  */
    /* JADX WARN: Code duplicated, block: B:347:0x0b4c  */
    /* JADX WARN: Code duplicated, block: B:348:0x0b57  */
    /* JADX WARN: Code duplicated, block: B:350:0x0b61  */
    /* JADX WARN: Code duplicated, block: B:353:0x0b72  */
    /* JADX WARN: Code duplicated, block: B:354:0x0ba2  */
    /* JADX WARN: Code duplicated, block: B:357:0x0bac  */
    /* JADX WARN: Code duplicated, block: B:360:0x0bca  */
    /* JADX WARN: Code duplicated, block: B:363:0x0bd6  */
    /* JADX WARN: Code duplicated, block: B:365:0x0cc7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:366:0x0cc8  */
    /* JADX WARN: Code duplicated, block: B:368:0x0cf7  */
    /* JADX WARN: Code duplicated, block: B:370:0x0e1c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:371:0x0e1d  */
    /* JADX WARN: Code duplicated, block: B:374:0x0e5a  */
    /* JADX WARN: Code duplicated, block: B:386:0x074e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:387:0x0751 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:402:0x0b15 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:405:0x0bb2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x036b  */
    /* JADX WARN: Code duplicated, block: B:45:0x038a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x038f  */
    /* JADX WARN: Code duplicated, block: B:53:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:55:0x03ad A[Catch: all -> 0x0436, TRY_ENTER, TryCatch #1 {all -> 0x0436, blocks: (B:55:0x03ad, B:57:0x03d0, B:56:0x03c1), top: B:378:0x03ab }] */
    /* JADX WARN: Code duplicated, block: B:56:0x03c1 A[Catch: all -> 0x0436, TryCatch #1 {all -> 0x0436, blocks: (B:55:0x03ad, B:57:0x03d0, B:56:0x03c1), top: B:378:0x03ab }] */
    /* JADX WARN: Code duplicated, block: B:61:0x041e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x041f  */
    /* JADX WARN: Code duplicated, block: B:74:0x043f  */
    /* JADX WARN: Code duplicated, block: B:75:0x0446  */
    /* JADX WARN: Code duplicated, block: B:77:0x0449  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:82:0x045a  */
    /* JADX WARN: Code duplicated, block: B:84:0x045d  */
    /* JADX WARN: Code duplicated, block: B:88:0x0469 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x046b  */
    /* JADX WARN: Code duplicated, block: B:90:0x0474  */
    /* JADX WARN: Code duplicated, block: B:93:0x0487  */
    /* JADX WARN: Code duplicated, block: B:97:0x0494  */
    /* JADX WARN: Code duplicated, block: B:99:0x0497  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v24 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r19v10 */
    /* JADX WARN: Type inference failed for: r19v12 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r21v4, types: [com.phisher98.MetaAnimeData, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r21v6 */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r23v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r23v5 */
    /* JADX WARN: Type inference failed for: r34v1 */
    /* JADX WARN: Type inference failed for: r34v2 */
    /* JADX WARN: Type inference failed for: r35v1 */
    /* JADX WARN: Type inference failed for: r35v2 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v25, types: [com.phisher98.MetaAnimeData, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r85v1, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19, types: [com.phisher98.MetaAnimeData, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v53 */
    public final Object loadFromKitsu(String str, String str2, Continuation<? super LoadResponse> continuation) throws Exception {
        C00861 c00861;
        String str3;
        Object meta;
        Object meta2;
        Object meta3;
        StreamPlayKitsuHelper.KitsuMeta kitsuMeta;
        String str4;
        Object meta4;
        Integer numericKitsuId;
        Integer num;
        StringBuilder sbAppend;
        Object obj;
        String str5;
        StreamPlayKitsuHelper.KitsuMeta kitsuMeta2;
        StreamPlayKitsuHelper.KitsuMeta kitsuMeta3;
        Integer num2;
        String text;
        String str6;
        ?? r8;
        Object intOrNull;
        String strValueOf;
        String str7;
        ?? r85;
        int i;
        TvType tvType;
        TvType tvType2;
        TvType tvType3;
        String name;
        String str8;
        Integer yearInt;
        TvType tvType4;
        Integer num3;
        String str9;
        Integer num4;
        int i2;
        ?? r19;
        String str10;
        TvType tvType5;
        StreamPlayKitsuHelper.KitsuMeta kitsuMeta4;
        Integer num5;
        boolean z;
        Object objFetchTmdbLogoUrl;
        C00861 c00862;
        String str11;
        String str12;
        TvType tvType6;
        String str13;
        Integer num6;
        int i3;
        Integer num7;
        String str14;
        TvType tvType7;
        ?? r16;
        ?? r6;
        StreamPlayKitsuHelper.KitsuMeta kitsuMeta5;
        Map<String, MetaEpisode> episodes;
        String airDateUtc;
        String strTake;
        List<String> aliases;
        MetaMappings mappings;
        MetaMappings mappings2;
        String themoviedbId;
        MetaAnimeData animeData;
        String str15;
        String str16;
        CharSequence charSequence;
        Integer intOrNull2;
        Integer malId;
        String str17;
        AniIds aniIds;
        String str18;
        TvType tvType8;
        ?? r21;
        StreamPlayKitsuHelper.KitsuMeta kitsuMeta6;
        String str19;
        String str20;
        Integer num8;
        ?? r23;
        TvType tvType9;
        int i4;
        String str21;
        Integer num9;
        String str22;
        Integer num10;
        String str23;
        Object objTmdbToAnimeId;
        StreamPlayKitsuHelper.KitsuMeta kitsuMeta7;
        Integer num11;
        TvType tvType10;
        TvType tvType11;
        String str24;
        String str25;
        String str26;
        ?? r110;
        String str27;
        Integer num12;
        String str28;
        MetaMappings mappings3;
        MetaMappings mappings4;
        Integer anilistId;
        AniIds aniIds2;
        Integer id;
        Integer num13;
        Integer idMal;
        Integer num14;
        String str29;
        List<String> aliases2;
        String str30;
        Map<String, String> titles;
        String poster;
        Object obj2;
        Integer num15;
        C00861 c00863;
        String url;
        String background;
        String str31;
        String str32;
        List<StreamPlayKitsuHelper.KitsuVideo> videos;
        int size;
        Map<String, MetaEpisode> episodes2;
        LinkedHashMap linkedHashMap;
        List<StreamPlayKitsuHelper.KitsuVideo> list;
        Iterable intRange;
        int i5;
        LinkedHashMap linkedHashMap2;
        int i6;
        String str33;
        String str34;
        String str35;
        String str36;
        Map<String, String> titles2;
        Map<String, String> titles3;
        Integer num16;
        int iIntValue;
        int i7;
        Integer num17;
        String str37;
        String str38;
        String stringData;
        int i8;
        int i9;
        LinkedHashMap linkedHashMap3;
        LinkedHashMap linkedHashMap4;
        CharSequence charSequence2;
        Integer num18;
        Integer num19;
        int i10;
        String str39;
        Integer num20;
        Iterable intRange2;
        ArrayList arrayList;
        IntIterator it;
        int i11;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        int i12;
        LinkedHashMap linkedHashMap5;
        LinkedHashMap linkedHashMap6;
        Integer num21;
        String str40;
        String str41;
        ArrayList arrayList6;
        String imdbRating;
        int iFloatValue;
        List<StreamPlayKitsuHelper.KitsuLink> links;
        ArrayList arrayList7;
        Integer num22;
        Integer num23;
        List list2;
        int i13;
        Object obj3;
        int i14;
        Object objNewAnimeLoadResponse$default;
        String str42;
        String str43;
        int i15;
        Object objNewMovieLoadResponse;
        Object obj4;
        List<StreamPlayKitsuHelper.KitsuLink> list3;
        ArrayList arrayList8;
        ArrayList<StreamPlayKitsuHelper.KitsuLink> arrayList9;
        int i16;
        ArrayList arrayList10;
        String name2;
        ArrayList arrayList11;
        String url2;
        int i17;
        Integer num24;
        Integer num25;
        AnimeSearchResponse animeSearchResponseNewAnimeSearchResponse$default;
        String strSubstringAfterLast$default;
        Float floatOrNull;
        StreamPlayKitsuHelper.KitsuVideo kitsuVideo;
        int iIntValue2;
        Integer episode;
        List<StreamPlayKitsuHelper.KitsuVideo> list4;
        ArrayList arrayList12;
        int i18;
        int i19;
        Integer episode2;
        int iIntValue3;
        Map<String, String> titles4;
        String url3;
        List<ImageData> images;
        ImageData imageData;
        int iIntValue4;
        int i20;
        MetaEpisode metaEpisode;
        Map<String, MetaEpisode> episodes3;
        int iIntValue5;
        List<StreamPlayKitsuHelper.KitsuVideo> list5;
        List<ImageData> images2;
        List<ImageData> list6;
        Iterator it2;
        Object next;
        ImageData imageData2;
        List<ImageData> list7;
        List<ImageData> images3;
        Object next2;
        Map<String, String> titles5;
        ?? r17;
        StreamPlayAnime streamPlayAnime = this;
        String str44 = str;
        String str45 = str2;
        if (continuation instanceof C00861) {
            c00861 = (C00861) continuation;
            if ((c00861.label & Integer.MIN_VALUE) != 0) {
                c00861.label -= Integer.MIN_VALUE;
            } else {
                c00861 = streamPlayAnime.new C00861(continuation);
            }
        } else {
            c00861 = streamPlayAnime.new C00861(continuation);
        }
        C00861 c00864 = c00861;
        Object obj5 = c00864.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00864.label) {
            case 0:
                ResultKt.throwOnFailure(obj5);
                str3 = null;
                if (!StringsKt.startsWith$default(str45, "kitsu:", false, 2, (Object) null) && !StringsKt.startsWith$default(str45, "anilist:", false, 2, (Object) null) && !StringsKt.startsWith$default(str45, "mal:", false, 2, (Object) null)) {
                    if (StringsKt.contains$default(str44, "kitsu", false, 2, (Object) null)) {
                        c00864.L$0 = str44;
                        c00864.L$1 = str45;
                        c00864.label = 2;
                        meta3 = StreamPlayKitsuHelper.INSTANCE.getMeta("kitsu:" + str45, c00864);
                        if (meta3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        kitsuMeta = (StreamPlayKitsuHelper.KitsuMeta) meta3;
                        str4 = str44;
                        if (kitsuMeta == null) {
                            throw new Exception("Unable to fetch Kitsu anime metadata for " + str45);
                        }
                        numericKitsuId = kitsuMeta.getNumericKitsuId();
                        if (numericKitsuId != null) {
                            sbAppend = new StringBuilder().append("kitsu_id=").append(numericKitsuId.intValue());
                        } else {
                            sbAppend = new StringBuilder().append("anilist_id=").append(str45);
                        }
                        String string = sbAppend.toString();
                        Requests app = MainActivityKt.getApp();
                        String str46 = "https://api.ani.zip/mappings?" + string;
                        c00864.L$0 = str4;
                        c00864.L$1 = str45;
                        c00864.L$2 = kitsuMeta;
                        c00864.L$3 = numericKitsuId;
                        c00864.L$4 = SpillingKt.nullOutSpilledVariable(string);
                        c00864.label = 5;
                        obj = Requests.get$default(app, str46, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00864, 4094, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str5 = str4;
                        kitsuMeta2 = kitsuMeta;
                        text = ((NiceResponse) obj).getText();
                        num2 = numericKitsuId;
                        str6 = str5;
                        kitsuMeta3 = kitsuMeta2;
                        if (text != null) {
                            animeData = StreamPlayUtilsKt.parseAnimeData(text);
                        } else {
                            r8 = str3;
                        }
                        if (r8 != 0) {
                            r8 = animeData;
                            r8 = animeData;
                            r8 = animeData;
                            intOrNull = str3;
                        } else {
                            r8 = animeData;
                            r8 = animeData;
                            r8 = animeData;
                            intOrNull = str3;
                        }
                        if (r8 != 0) {
                            if (num2 != null) {
                                strValueOf = String.valueOf(num2.intValue());
                            } else {
                                strValueOf = str3;
                            }
                        } else if (num2 != null) {
                            strValueOf = String.valueOf(num2.intValue());
                        } else {
                            strValueOf = str3;
                        }
                        r8 = animeData;
                        str7 = strValueOf;
                        r85 = intOrNull;
                        if (StringsKt.equals(kitsuMeta3.getType(), "movie", true)) {
                            i = 1;
                        } else {
                            i = 1;
                        }
                        if (i != 0) {
                            tvType = TvType.Movie;
                        } else {
                            tvType = TvType.TvSeries;
                        }
                        if (i != 0) {
                            tvType2 = TvType.AnimeMovie;
                        } else {
                            tvType2 = TvType.TvSeries;
                        }
                        tvType3 = tvType2;
                        name = kitsuMeta3.getName();
                        if (name == null) {
                            aliases = kitsuMeta3.getAliases();
                            if (aliases != null) {
                                name = (String) CollectionsKt.firstOrNull(aliases);
                            } else {
                                name = null;
                            }
                            if (name == null) {
                                name = "Unknown";
                            }
                        }
                        str8 = name;
                        yearInt = kitsuMeta3.getYearInt();
                        if (yearInt != null) {
                            tvType4 = tvType;
                        } else if (r8 != 0) {
                            tvType4 = tvType;
                            yearInt = null;
                        } else {
                            tvType4 = tvType;
                            yearInt = null;
                        }
                        num3 = yearInt;
                        c00864.L$0 = str6;
                        c00864.L$1 = str45;
                        c00864.L$2 = kitsuMeta3;
                        c00864.L$3 = num2;
                        c00864.L$4 = text;
                        c00864.L$5 = r8;
                        c00864.L$6 = SpillingKt.nullOutSpilledVariable((Object) r85);
                        c00864.L$7 = str7;
                        str9 = text;
                        c00864.L$8 = SpillingKt.nullOutSpilledVariable(tvType4);
                        c00864.L$9 = tvType3;
                        c00864.L$10 = str8;
                        c00864.L$11 = num3;
                        c00864.I$0 = i;
                        c00864.label = 6;
                        num4 = num2;
                        i2 = i;
                        r19 = r8;
                        str10 = str6;
                        tvType5 = tvType4;
                        kitsuMeta4 = kitsuMeta3;
                        num5 = null;
                        C00861 c00865 = c00864;
                        z = false;
                        objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", tvType5, r85, "en", c00865);
                        c00862 = c00865;
                        if (objFetchTmdbLogoUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str11 = str9;
                        str12 = str7;
                        tvType6 = tvType3;
                        str13 = str8;
                        num6 = num4;
                        i3 = i2;
                        num7 = num3;
                        str14 = str10;
                        tvType7 = tvType5;
                        r16 = r85;
                        r6 = r19;
                        kitsuMeta5 = kitsuMeta4;
                        str15 = (String) objFetchTmdbLogoUrl;
                        if (r6 != 0) {
                            if (StringsKt.toIntOrNull(str45) != null) {
                                str16 = str45;
                                charSequence = "kitsu:";
                                if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                                    intOrNull2 = StringsKt.toIntOrNull(str16);
                                }
                            } else {
                                str16 = str45;
                                charSequence = "kitsu:";
                            }
                            intOrNull2 = num5;
                        } else {
                            if (StringsKt.toIntOrNull(str45) != null) {
                                str16 = str45;
                                charSequence = "kitsu:";
                                if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                                    intOrNull2 = StringsKt.toIntOrNull(str16);
                                }
                            } else {
                                str16 = str45;
                                charSequence = "kitsu:";
                            }
                            intOrNull2 = num5;
                        }
                        if (r6 != 0) {
                            malId = num5;
                        } else {
                            malId = num5;
                        }
                        if (malId == null) {
                        }
                        str17 = str14;
                        int i21 = i3;
                        Integer num26 = num7;
                        aniIds = new AniIds(intOrNull2, malId);
                        str18 = str15;
                        tvType8 = tvType6;
                        r21 = r6;
                        kitsuMeta6 = kitsuMeta5;
                        str19 = str11;
                        str20 = str12;
                        num8 = num26;
                        r23 = r16;
                        tvType9 = tvType7;
                        i4 = i21;
                        str21 = str16;
                        num9 = intOrNull2;
                        str22 = str13;
                        num10 = malId;
                        aniIds2 = aniIds;
                        id = aniIds2.getId();
                        if (id == null) {
                            num13 = num9;
                        } else {
                            num13 = id;
                        }
                        idMal = aniIds2.getIdMal();
                        if (idMal == null) {
                            num14 = num10;
                        } else {
                            num14 = idMal;
                        }
                        if (r21 != 0) {
                            if (r21 != 0) {
                                str29 = null;
                            } else {
                                str29 = null;
                            }
                            if (str29 != null) {
                                str30 = str29;
                            } else {
                                aliases2 = kitsuMeta6.getAliases();
                                if (aliases2 != null) {
                                    str29 = (String) CollectionsKt.firstOrNull(aliases2);
                                } else {
                                    str29 = null;
                                }
                                if (str29 == null) {
                                    str30 = str22;
                                } else {
                                    str30 = str29;
                                }
                            }
                        } else {
                            if (r21 != 0) {
                                str29 = null;
                            } else {
                                str29 = null;
                            }
                            if (str29 != null) {
                                str30 = str29;
                            } else {
                                aliases2 = kitsuMeta6.getAliases();
                                if (aliases2 != null) {
                                    str29 = (String) CollectionsKt.firstOrNull(aliases2);
                                } else {
                                    str29 = null;
                                }
                                if (str29 == null) {
                                    str30 = str22;
                                } else {
                                    str30 = str29;
                                }
                            }
                        }
                        poster = kitsuMeta6.getPoster();
                        if (poster != null) {
                            obj2 = coroutine_suspended;
                            num15 = num14;
                            c00863 = c00862;
                            url = poster;
                        } else if (r21 != 0) {
                            obj2 = coroutine_suspended;
                            num15 = num14;
                            c00863 = c00862;
                            url = null;
                        } else {
                            obj2 = coroutine_suspended;
                            num15 = num14;
                            c00863 = c00862;
                            url = null;
                        }
                        background = kitsuMeta6.getBackground();
                        if (background != null) {
                            str31 = background;
                        } else {
                            if (r21 != 0) {
                                list6 = images2;
                                it2 = list6.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        next = it2.next();
                                        list7 = list6;
                                        if (StringsKt.equals(((ImageData) next).getCoverType(), "Fanart", true)) {
                                            list6 = list7;
                                        }
                                    } else {
                                        next = null;
                                    }
                                }
                                imageData2 = (ImageData) next;
                                if (imageData2 != null) {
                                    background = imageData2.getUrl();
                                    str31 = background;
                                }
                            }
                            str31 = null;
                        }
                        str32 = str31;
                        videos = kitsuMeta6.getVideos();
                        if (videos == null) {
                            videos = CollectionsKt.emptyList();
                        }
                        if (!videos.isEmpty()) {
                            size = videos.size();
                        } else if (r21 != 0) {
                            size = 1;
                        } else {
                            size = 1;
                        }
                        Iterable intRange3 = new IntRange(1, size);
                        linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange3, 10)), 16));
                        for (Object obj6 : intRange3) {
                            iIntValue5 = ((Number) obj6).intValue();
                            if (str19 != null) {
                                list5 = videos;
                                Integer anidbEid = StreamPlayUtilsKt.getAnidbEid(str19, Boxing.boxInt(iIntValue5));
                                if (anidbEid != null) {
                                }
                                linkedHashMap.put(obj6, Boxing.boxInt(iIntValue));
                                videos = list5;
                            } else {
                                list5 = videos;
                            }
                            linkedHashMap.put(obj6, Boxing.boxInt(iIntValue));
                            videos = list5;
                        }
                        list = videos;
                        intRange = new IntRange(1, size);
                        i5 = 0;
                        linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange, 10)), 16));
                        for (Object obj7 : intRange) {
                            Iterable iterable = intRange;
                            iIntValue4 = ((Number) obj7).intValue();
                            if (r21 != 0) {
                                i20 = size;
                                episodes3 = r21.getEpisodes();
                                if (episodes3 != null) {
                                    i5 = i5;
                                    metaEpisode = episodes3.get(String.valueOf(iIntValue4));
                                }
                                linkedHashMap2.put(obj7, metaEpisode);
                                intRange = iterable;
                                size = i20;
                                i5 = i5;
                            } else {
                                i20 = size;
                            }
                            metaEpisode = null;
                            linkedHashMap2.put(obj7, metaEpisode);
                            intRange = iterable;
                            size = i20;
                            i5 = i5;
                        }
                        i6 = size;
                        if (url == null) {
                            if (r21 != 0) {
                                url3 = null;
                            } else {
                                url3 = null;
                            }
                            if (url3 == null) {
                                url3 = "";
                            }
                            str33 = url3;
                        } else {
                            str33 = url;
                        }
                        if (r21 != 0) {
                            if (r21 != 0) {
                                str34 = null;
                            } else {
                                str34 = null;
                            }
                            if (str34 == null) {
                                if (r21 != 0) {
                                    str36 = null;
                                } else {
                                    str36 = null;
                                }
                                if (str36 == null) {
                                    str35 = str22;
                                } else {
                                    str35 = str36;
                                }
                            } else {
                                str35 = str34;
                            }
                        } else {
                            if (r21 != 0) {
                                str34 = null;
                            } else {
                                str34 = null;
                            }
                            if (str34 == null) {
                                if (r21 != 0) {
                                    str36 = null;
                                } else {
                                    str36 = null;
                                }
                                if (str36 == null) {
                                    str35 = str22;
                                } else {
                                    str35 = str36;
                                }
                            } else {
                                str35 = str34;
                            }
                        }
                        num16 = (Integer) linkedHashMap.get(Boxing.boxInt(1));
                        if (num16 != null) {
                            iIntValue = num16.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        i7 = iIntValue;
                        num17 = num8;
                        str37 = str22;
                        str38 = str30;
                        stringData = streamPlayAnime.toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), num13, num15, str22, num17, null, true, null, null, null, str30, null, null, false, false, false, false, Boxing.boxInt(i7), num6, 16633983, null));
                        if (list.isEmpty()) {
                            i8 = i7;
                            i9 = i4;
                            linkedHashMap3 = linkedHashMap2;
                            linkedHashMap4 = linkedHashMap;
                            charSequence2 = charSequence;
                            num18 = num15;
                            num19 = num17;
                            i10 = i6;
                            str39 = str35;
                            num20 = num13;
                            intRange2 = new IntRange(1, i10);
                            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
                            it = intRange2.iterator();
                            while (it.hasNext()) {
                                ArrayList arrayList13 = arrayList;
                                arrayList13.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, it.nextInt(), null, false));
                                i10 = i10;
                                arrayList = arrayList13;
                                intRange2 = intRange2;
                            }
                            i6 = i10;
                            i11 = 10;
                            arrayList2 = arrayList;
                        } else {
                            list4 = list;
                            arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                            i18 = 0;
                            for (Object obj8 : list4) {
                                int i22 = i18 + 1;
                                if (i18 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                ArrayList arrayList14 = arrayList12;
                                LinkedHashMap linkedHashMap7 = linkedHashMap;
                                StreamPlayKitsuHelper.KitsuVideo kitsuVideo2 = (StreamPlayKitsuHelper.KitsuVideo) obj8;
                                i19 = i18;
                                episode2 = kitsuVideo2.getEpisode();
                                if (episode2 != null) {
                                    iIntValue3 = episode2.intValue();
                                } else {
                                    iIntValue3 = i19 + 1;
                                }
                                CharSequence charSequence3 = charSequence;
                                List<StreamPlayKitsuHelper.KitsuVideo> list8 = list4;
                                LinkedHashMap linkedHashMap8 = linkedHashMap2;
                                String str47 = str35;
                                arrayList14.add(loadFromKitsu$createEpisode(linkedHashMap8, streamPlayAnime, linkedHashMap7, num13, num15, str37, num17, str38, num6, str33, str47, iIntValue3, kitsuVideo2, false));
                                streamPlayAnime = this;
                                linkedHashMap = linkedHashMap7;
                                str35 = str47;
                                arrayList12 = arrayList14;
                                i18 = i22;
                                obj5 = obj5;
                                i7 = i7;
                                i4 = i4;
                                linkedHashMap2 = linkedHashMap8;
                                list4 = list8;
                                charSequence = charSequence3;
                            }
                            ArrayList arrayList15 = arrayList12;
                            i8 = i7;
                            i9 = i4;
                            linkedHashMap4 = linkedHashMap;
                            charSequence2 = charSequence;
                            num18 = num15;
                            num19 = num17;
                            linkedHashMap3 = linkedHashMap2;
                            str39 = str35;
                            num20 = num13;
                            arrayList2 = arrayList15;
                            i11 = 10;
                        }
                        arrayList3 = arrayList2;
                        arrayList4 = arrayList3;
                        arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, i11));
                        i12 = 0;
                        for (Object obj9 : arrayList4) {
                            int i23 = i12 + 1;
                            if (i12 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            List<StreamPlayKitsuHelper.KitsuVideo> list9 = list;
                            kitsuVideo = (StreamPlayKitsuHelper.KitsuVideo) CollectionsKt.getOrNull(list9, i12);
                            if (kitsuVideo != null) {
                                iIntValue2 = i12 + 1;
                            } else {
                                iIntValue2 = i12 + 1;
                            }
                            list = list9;
                            arrayList5.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, iIntValue2, kitsuVideo, true));
                            i12 = i23;
                            arrayList4 = arrayList4;
                        }
                        linkedHashMap5 = linkedHashMap3;
                        linkedHashMap6 = linkedHashMap4;
                        num21 = num6;
                        str40 = str33;
                        str41 = str39;
                        arrayList6 = arrayList5;
                        imdbRating = kitsuMeta6.getImdbRating();
                        if (imdbRating != null) {
                            iFloatValue = 0;
                        } else {
                            iFloatValue = 0;
                        }
                        links = kitsuMeta6.getLinks();
                        if (links != null) {
                            list3 = links;
                            arrayList8 = new ArrayList();
                            for (Object obj10 : list3) {
                                ArrayList arrayList16 = arrayList6;
                                List<StreamPlayKitsuHelper.KitsuLink> list10 = list3;
                                if (StringsKt.equals(((StreamPlayKitsuHelper.KitsuLink) obj10).getCategory(), "Franchise", true)) {
                                    arrayList8.add(obj10);
                                }
                                arrayList6 = arrayList16;
                                list3 = list10;
                            }
                            arrayList7 = arrayList6;
                            arrayList9 = arrayList8;
                            i16 = 0;
                            arrayList10 = new ArrayList();
                            for (StreamPlayKitsuHelper.KitsuLink kitsuLink : arrayList9) {
                                name2 = kitsuLink.getName();
                                if (name2 == null) {
                                    arrayList11 = arrayList9;
                                    i17 = i16;
                                    num24 = num20;
                                    num25 = num18;
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                } else {
                                    arrayList11 = arrayList9;
                                    url2 = kitsuLink.getUrl();
                                    if (url2 != null) {
                                        i17 = i16;
                                        num24 = num20;
                                        num25 = num18;
                                        strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                        if (strSubstringAfterLast$default == null) {
                                            animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                        }
                                    } else {
                                        i17 = i16;
                                        num24 = num20;
                                        num25 = num18;
                                    }
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                }
                                if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                    arrayList10.add(animeSearchResponseNewAnimeSearchResponse$default);
                                }
                                arrayList9 = arrayList11;
                                i16 = i17;
                                num20 = num24;
                                num18 = num25;
                            }
                            num22 = num20;
                            num23 = num18;
                            list2 = arrayList10;
                        } else {
                            arrayList7 = arrayList6;
                            num22 = num20;
                            num23 = num18;
                            list2 = null;
                        }
                        i13 = i9;
                        if (i13 != 0) {
                            TvType tvType12 = TvType.AnimeMovie;
                            Integer num27 = num19;
                            C00872 c00872 = new C00872(num22, num23, str20, num27, kitsuMeta6, str32, url, str18, iFloatValue, null);
                            C00861 c00866 = c00863;
                            c00866.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                            c00866.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                            c00866.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                            c00866.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                            c00866.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                            c00866.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                            c00866.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                            c00866.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                            c00866.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                            c00866.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                            c00866.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                            c00866.L$11 = SpillingKt.nullOutSpilledVariable(num27);
                            c00866.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                            c00866.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                            c00866.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                            c00866.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                            c00866.L$16 = SpillingKt.nullOutSpilledVariable(num22);
                            c00866.L$17 = SpillingKt.nullOutSpilledVariable(num23);
                            c00866.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                            c00866.L$19 = SpillingKt.nullOutSpilledVariable(url);
                            c00866.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                            c00866.L$21 = SpillingKt.nullOutSpilledVariable(list);
                            c00866.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                            c00866.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                            c00866.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                            c00866.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                            c00866.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                            c00866.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                            c00866.L$28 = SpillingKt.nullOutSpilledVariable(arrayList7);
                            c00866.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                            c00866.I$0 = i13;
                            c00866.I$1 = i6;
                            c00866.I$2 = i8;
                            c00866.I$3 = iFloatValue;
                            c00866.label = 8;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str37, str17, tvType12, stringData, c00872, c00866);
                            obj4 = obj2;
                            if (objNewMovieLoadResponse == obj4) {
                                return obj4;
                            }
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        Integer num28 = num19;
                        obj3 = obj2;
                        C00861 c00867 = c00863;
                        Integer num29 = num22;
                        Integer num30 = num23;
                        i14 = iFloatValue;
                        TvType tvType13 = TvType.Anime;
                        ArrayList arrayList17 = arrayList7;
                        C00883 c00883 = new C00883(num29, num30, str20, arrayList3, arrayList17, str18, num28, kitsuMeta6, str32, url, i14, this, list2, null);
                        c00867.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                        c00867.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                        c00867.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                        c00867.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                        c00867.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                        c00867.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                        c00867.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c00867.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                        c00867.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                        c00867.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                        c00867.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                        c00867.L$11 = SpillingKt.nullOutSpilledVariable(num28);
                        c00867.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                        c00867.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                        c00867.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                        c00867.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c00867.L$16 = SpillingKt.nullOutSpilledVariable(num29);
                        c00867.L$17 = SpillingKt.nullOutSpilledVariable(num30);
                        c00867.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                        c00867.L$19 = SpillingKt.nullOutSpilledVariable(url);
                        c00867.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                        c00867.L$21 = SpillingKt.nullOutSpilledVariable(list);
                        c00867.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                        c00867.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                        c00867.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                        c00867.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                        c00867.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                        c00867.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c00867.L$28 = SpillingKt.nullOutSpilledVariable(arrayList17);
                        c00867.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                        c00867.I$0 = i13;
                        c00867.I$1 = i6;
                        c00867.I$2 = i8;
                        c00867.I$3 = i14;
                        c00867.label = 9;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, str37, str17, tvType13, false, c00883, c00867, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == obj3) {
                            return obj3;
                        }
                        str42 = str21;
                        str43 = stringData;
                        i15 = i14;
                        obj5 = objNewAnimeLoadResponse$default;
                        return (LoadResponse) obj5;
                    }
                    c00864.L$0 = str44;
                    c00864.L$1 = str45;
                    c00864.label = 3;
                    meta2 = StreamPlayKitsuHelper.INSTANCE.getMeta("anilist:" + str45, c00864);
                    if (meta2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    kitsuMeta = (StreamPlayKitsuHelper.KitsuMeta) meta2;
                    if (kitsuMeta == null) {
                        c00864.L$0 = str44;
                        c00864.L$1 = str45;
                        c00864.label = 4;
                        meta4 = StreamPlayKitsuHelper.INSTANCE.getMeta("kitsu:" + str45, c00864);
                        if (meta4 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        kitsuMeta = (StreamPlayKitsuHelper.KitsuMeta) meta4;
                        str4 = str44;
                    } else {
                        str4 = str44;
                    }
                    if (kitsuMeta == null) {
                        throw new Exception("Unable to fetch Kitsu anime metadata for " + str45);
                    }
                    numericKitsuId = kitsuMeta.getNumericKitsuId();
                    if (numericKitsuId != null) {
                        sbAppend = new StringBuilder().append("kitsu_id=").append(numericKitsuId.intValue());
                    } else {
                        sbAppend = new StringBuilder().append("anilist_id=").append(str45);
                    }
                    String string2 = sbAppend.toString();
                    Requests app2 = MainActivityKt.getApp();
                    String str48 = "https://api.ani.zip/mappings?" + string2;
                    c00864.L$0 = str4;
                    c00864.L$1 = str45;
                    c00864.L$2 = kitsuMeta;
                    c00864.L$3 = numericKitsuId;
                    c00864.L$4 = SpillingKt.nullOutSpilledVariable(string2);
                    c00864.label = 5;
                    obj = Requests.get$default(app2, str48, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00864, 4094, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str5 = str4;
                    kitsuMeta2 = kitsuMeta;
                    text = ((NiceResponse) obj).getText();
                    num2 = numericKitsuId;
                    str6 = str5;
                    kitsuMeta3 = kitsuMeta2;
                    if (text != null) {
                        animeData = StreamPlayUtilsKt.parseAnimeData(text);
                    } else {
                        r8 = str3;
                    }
                    if (r8 != 0) {
                        r8 = animeData;
                        r8 = animeData;
                        r8 = animeData;
                        intOrNull = str3;
                    } else {
                        r8 = animeData;
                        r8 = animeData;
                        r8 = animeData;
                        intOrNull = str3;
                    }
                    if (r8 != 0) {
                        if (num2 != null) {
                            strValueOf = String.valueOf(num2.intValue());
                        } else {
                            strValueOf = str3;
                        }
                    } else if (num2 != null) {
                        strValueOf = String.valueOf(num2.intValue());
                    } else {
                        strValueOf = str3;
                    }
                    r8 = animeData;
                    str7 = strValueOf;
                    r85 = intOrNull;
                    if (StringsKt.equals(kitsuMeta3.getType(), "movie", true)) {
                        i = 1;
                    } else {
                        i = 1;
                    }
                    if (i != 0) {
                        tvType = TvType.Movie;
                    } else {
                        tvType = TvType.TvSeries;
                    }
                    if (i != 0) {
                        tvType2 = TvType.AnimeMovie;
                    } else {
                        tvType2 = TvType.TvSeries;
                    }
                    tvType3 = tvType2;
                    name = kitsuMeta3.getName();
                    if (name == null) {
                        aliases = kitsuMeta3.getAliases();
                        if (aliases != null) {
                            name = (String) CollectionsKt.firstOrNull(aliases);
                        } else {
                            name = null;
                        }
                        if (name == null) {
                            name = "Unknown";
                        }
                    }
                    str8 = name;
                    yearInt = kitsuMeta3.getYearInt();
                    if (yearInt != null) {
                        tvType4 = tvType;
                    } else if (r8 != 0) {
                        tvType4 = tvType;
                        yearInt = null;
                    } else {
                        tvType4 = tvType;
                        yearInt = null;
                    }
                    num3 = yearInt;
                    c00864.L$0 = str6;
                    c00864.L$1 = str45;
                    c00864.L$2 = kitsuMeta3;
                    c00864.L$3 = num2;
                    c00864.L$4 = text;
                    c00864.L$5 = r8;
                    c00864.L$6 = SpillingKt.nullOutSpilledVariable((Object) r85);
                    c00864.L$7 = str7;
                    str9 = text;
                    c00864.L$8 = SpillingKt.nullOutSpilledVariable(tvType4);
                    c00864.L$9 = tvType3;
                    c00864.L$10 = str8;
                    c00864.L$11 = num3;
                    c00864.I$0 = i;
                    c00864.label = 6;
                    num4 = num2;
                    i2 = i;
                    r19 = r8;
                    str10 = str6;
                    tvType5 = tvType4;
                    kitsuMeta4 = kitsuMeta3;
                    num5 = null;
                    C00861 c00868 = c00864;
                    z = false;
                    objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", tvType5, r85, "en", c00868);
                    c00862 = c00868;
                    if (objFetchTmdbLogoUrl == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str11 = str9;
                    str12 = str7;
                    tvType6 = tvType3;
                    str13 = str8;
                    num6 = num4;
                    i3 = i2;
                    num7 = num3;
                    str14 = str10;
                    tvType7 = tvType5;
                    r16 = r85;
                    r6 = r19;
                    kitsuMeta5 = kitsuMeta4;
                    str15 = (String) objFetchTmdbLogoUrl;
                    if (r6 != 0) {
                        if (StringsKt.toIntOrNull(str45) != null) {
                            str16 = str45;
                            charSequence = "kitsu:";
                            if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                                intOrNull2 = StringsKt.toIntOrNull(str16);
                            }
                        } else {
                            str16 = str45;
                            charSequence = "kitsu:";
                        }
                        intOrNull2 = num5;
                    } else {
                        if (StringsKt.toIntOrNull(str45) != null) {
                            str16 = str45;
                            charSequence = "kitsu:";
                            if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                                intOrNull2 = StringsKt.toIntOrNull(str16);
                            }
                        } else {
                            str16 = str45;
                            charSequence = "kitsu:";
                        }
                        intOrNull2 = num5;
                    }
                    if (r6 != 0) {
                        malId = num5;
                    } else {
                        malId = num5;
                    }
                    if (malId == null) {
                    }
                    str17 = str14;
                    int i24 = i3;
                    Integer num210 = num7;
                    aniIds = new AniIds(intOrNull2, malId);
                    str18 = str15;
                    tvType8 = tvType6;
                    r21 = r6;
                    kitsuMeta6 = kitsuMeta5;
                    str19 = str11;
                    str20 = str12;
                    num8 = num210;
                    r23 = r16;
                    tvType9 = tvType7;
                    i4 = i24;
                    str21 = str16;
                    num9 = intOrNull2;
                    str22 = str13;
                    num10 = malId;
                    aniIds2 = aniIds;
                    id = aniIds2.getId();
                    if (id == null) {
                        num13 = num9;
                    } else {
                        num13 = id;
                    }
                    idMal = aniIds2.getIdMal();
                    if (idMal == null) {
                        num14 = num10;
                    } else {
                        num14 = idMal;
                    }
                    if (r21 != 0) {
                        if (r21 != 0) {
                            str29 = null;
                        } else {
                            str29 = null;
                        }
                        if (str29 != null) {
                            str30 = str29;
                        } else {
                            aliases2 = kitsuMeta6.getAliases();
                            if (aliases2 != null) {
                                str29 = (String) CollectionsKt.firstOrNull(aliases2);
                            } else {
                                str29 = null;
                            }
                            if (str29 == null) {
                                str30 = str22;
                            } else {
                                str30 = str29;
                            }
                        }
                    } else {
                        if (r21 != 0) {
                            str29 = null;
                        } else {
                            str29 = null;
                        }
                        if (str29 != null) {
                            str30 = str29;
                        } else {
                            aliases2 = kitsuMeta6.getAliases();
                            if (aliases2 != null) {
                                str29 = (String) CollectionsKt.firstOrNull(aliases2);
                            } else {
                                str29 = null;
                            }
                            if (str29 == null) {
                                str30 = str22;
                            } else {
                                str30 = str29;
                            }
                        }
                    }
                    poster = kitsuMeta6.getPoster();
                    if (poster != null) {
                        obj2 = coroutine_suspended;
                        num15 = num14;
                        c00863 = c00862;
                        url = poster;
                    } else if (r21 != 0) {
                        obj2 = coroutine_suspended;
                        num15 = num14;
                        c00863 = c00862;
                        url = null;
                    } else {
                        obj2 = coroutine_suspended;
                        num15 = num14;
                        c00863 = c00862;
                        url = null;
                    }
                    background = kitsuMeta6.getBackground();
                    if (background != null) {
                        str31 = background;
                    } else {
                        if (r21 != 0) {
                            list6 = images2;
                            it2 = list6.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    next = it2.next();
                                    list7 = list6;
                                    if (StringsKt.equals(((ImageData) next).getCoverType(), "Fanart", true)) {
                                        list6 = list7;
                                    }
                                } else {
                                    next = null;
                                }
                            }
                            imageData2 = (ImageData) next;
                            if (imageData2 != null) {
                                background = imageData2.getUrl();
                                str31 = background;
                            }
                        }
                        str31 = null;
                    }
                    str32 = str31;
                    videos = kitsuMeta6.getVideos();
                    if (videos == null) {
                        videos = CollectionsKt.emptyList();
                    }
                    if (!videos.isEmpty()) {
                        size = videos.size();
                    } else if (r21 != 0) {
                        size = 1;
                    } else {
                        size = 1;
                    }
                    Iterable intRange4 = new IntRange(1, size);
                    linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange4, 10)), 16));
                    while (r31.hasNext()) {
                        iIntValue5 = ((Number) obj6).intValue();
                        if (str19 != null) {
                            list5 = videos;
                            Integer anidbEid2 = StreamPlayUtilsKt.getAnidbEid(str19, Boxing.boxInt(iIntValue5));
                            if (anidbEid2 != null) {
                            }
                            linkedHashMap.put(obj6, Boxing.boxInt(iIntValue));
                            videos = list5;
                        } else {
                            list5 = videos;
                        }
                        linkedHashMap.put(obj6, Boxing.boxInt(iIntValue));
                        videos = list5;
                    }
                    list = videos;
                    intRange = new IntRange(1, size);
                    i5 = 0;
                    linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange, 10)), 16));
                    while (r27.hasNext()) {
                        Iterable iterable2 = intRange;
                        iIntValue4 = ((Number) obj7).intValue();
                        if (r21 != 0) {
                            i20 = size;
                            episodes3 = r21.getEpisodes();
                            if (episodes3 != null) {
                                i5 = i5;
                                metaEpisode = episodes3.get(String.valueOf(iIntValue4));
                            }
                            linkedHashMap2.put(obj7, metaEpisode);
                            intRange = iterable2;
                            size = i20;
                            i5 = i5;
                        } else {
                            i20 = size;
                        }
                        metaEpisode = null;
                        linkedHashMap2.put(obj7, metaEpisode);
                        intRange = iterable2;
                        size = i20;
                        i5 = i5;
                    }
                    i6 = size;
                    if (url == null) {
                        if (r21 != 0) {
                            url3 = null;
                        } else {
                            url3 = null;
                        }
                        if (url3 == null) {
                            url3 = "";
                        }
                        str33 = url3;
                    } else {
                        str33 = url;
                    }
                    if (r21 != 0) {
                        if (r21 != 0) {
                            str34 = null;
                        } else {
                            str34 = null;
                        }
                        if (str34 == null) {
                            if (r21 != 0) {
                                str36 = null;
                            } else {
                                str36 = null;
                            }
                            if (str36 == null) {
                                str35 = str22;
                            } else {
                                str35 = str36;
                            }
                        } else {
                            str35 = str34;
                        }
                    } else {
                        if (r21 != 0) {
                            str34 = null;
                        } else {
                            str34 = null;
                        }
                        if (str34 == null) {
                            if (r21 != 0) {
                                str36 = null;
                            } else {
                                str36 = null;
                            }
                            if (str36 == null) {
                                str35 = str22;
                            } else {
                                str35 = str36;
                            }
                        } else {
                            str35 = str34;
                        }
                    }
                    num16 = (Integer) linkedHashMap.get(Boxing.boxInt(1));
                    if (num16 != null) {
                        iIntValue = num16.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    i7 = iIntValue;
                    num17 = num8;
                    str37 = str22;
                    str38 = str30;
                    stringData = streamPlayAnime.toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), num13, num15, str22, num17, null, true, null, null, null, str30, null, null, false, false, false, false, Boxing.boxInt(i7), num6, 16633983, null));
                    if (list.isEmpty()) {
                        list4 = list;
                        arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                        i18 = 0;
                        while (r37.hasNext()) {
                            int i25 = i18 + 1;
                            if (i18 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            ArrayList arrayList18 = arrayList12;
                            LinkedHashMap linkedHashMap9 = linkedHashMap;
                            StreamPlayKitsuHelper.KitsuVideo kitsuVideo3 = (StreamPlayKitsuHelper.KitsuVideo) obj8;
                            i19 = i18;
                            episode2 = kitsuVideo3.getEpisode();
                            if (episode2 != null) {
                                iIntValue3 = episode2.intValue();
                            } else {
                                iIntValue3 = i19 + 1;
                            }
                            CharSequence charSequence4 = charSequence;
                            List<StreamPlayKitsuHelper.KitsuVideo> list11 = list4;
                            LinkedHashMap linkedHashMap10 = linkedHashMap2;
                            String str49 = str35;
                            arrayList18.add(loadFromKitsu$createEpisode(linkedHashMap10, streamPlayAnime, linkedHashMap9, num13, num15, str37, num17, str38, num6, str33, str49, iIntValue3, kitsuVideo3, false));
                            streamPlayAnime = this;
                            linkedHashMap = linkedHashMap9;
                            str35 = str49;
                            arrayList12 = arrayList18;
                            i18 = i25;
                            obj5 = obj5;
                            i7 = i7;
                            i4 = i4;
                            linkedHashMap2 = linkedHashMap10;
                            list4 = list11;
                            charSequence = charSequence4;
                        }
                        ArrayList arrayList19 = arrayList12;
                        i8 = i7;
                        i9 = i4;
                        linkedHashMap4 = linkedHashMap;
                        charSequence2 = charSequence;
                        num18 = num15;
                        num19 = num17;
                        linkedHashMap3 = linkedHashMap2;
                        str39 = str35;
                        num20 = num13;
                        arrayList2 = arrayList19;
                        i11 = 10;
                    } else {
                        i8 = i7;
                        i9 = i4;
                        linkedHashMap3 = linkedHashMap2;
                        linkedHashMap4 = linkedHashMap;
                        charSequence2 = charSequence;
                        num18 = num15;
                        num19 = num17;
                        i10 = i6;
                        str39 = str35;
                        num20 = num13;
                        intRange2 = new IntRange(1, i10);
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
                        it = intRange2.iterator();
                        while (it.hasNext()) {
                            ArrayList arrayList110 = arrayList;
                            arrayList110.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, it.nextInt(), null, false));
                            i10 = i10;
                            arrayList = arrayList110;
                            intRange2 = intRange2;
                        }
                        i6 = i10;
                        i11 = 10;
                        arrayList2 = arrayList;
                    }
                    arrayList3 = arrayList2;
                    arrayList4 = arrayList3;
                    arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, i11));
                    i12 = 0;
                    while (r32.hasNext()) {
                        int i26 = i12 + 1;
                        if (i12 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        List<StreamPlayKitsuHelper.KitsuVideo> list12 = list;
                        kitsuVideo = (StreamPlayKitsuHelper.KitsuVideo) CollectionsKt.getOrNull(list12, i12);
                        if (kitsuVideo != null) {
                            iIntValue2 = i12 + 1;
                        } else {
                            iIntValue2 = i12 + 1;
                        }
                        list = list12;
                        arrayList5.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, iIntValue2, kitsuVideo, true));
                        i12 = i26;
                        arrayList4 = arrayList4;
                    }
                    linkedHashMap5 = linkedHashMap3;
                    linkedHashMap6 = linkedHashMap4;
                    num21 = num6;
                    str40 = str33;
                    str41 = str39;
                    arrayList6 = arrayList5;
                    imdbRating = kitsuMeta6.getImdbRating();
                    if (imdbRating != null) {
                        iFloatValue = 0;
                    } else {
                        iFloatValue = 0;
                    }
                    links = kitsuMeta6.getLinks();
                    if (links != null) {
                        list3 = links;
                        arrayList8 = new ArrayList();
                        while (r10.hasNext()) {
                            ArrayList arrayList111 = arrayList6;
                            List<StreamPlayKitsuHelper.KitsuLink> list13 = list3;
                            if (StringsKt.equals(((StreamPlayKitsuHelper.KitsuLink) obj10).getCategory(), "Franchise", true)) {
                                arrayList8.add(obj10);
                            }
                            arrayList6 = arrayList111;
                            list3 = list13;
                        }
                        arrayList7 = arrayList6;
                        arrayList9 = arrayList8;
                        i16 = 0;
                        arrayList10 = new ArrayList();
                        while (r11.hasNext()) {
                            name2 = kitsuLink.getName();
                            if (name2 == null) {
                                arrayList11 = arrayList9;
                                i17 = i16;
                                num24 = num20;
                                num25 = num18;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                            } else {
                                arrayList11 = arrayList9;
                                url2 = kitsuLink.getUrl();
                                if (url2 != null) {
                                    i17 = i16;
                                    num24 = num20;
                                    num25 = num18;
                                    strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                    if (strSubstringAfterLast$default == null) {
                                        animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                    }
                                } else {
                                    i17 = i16;
                                    num24 = num20;
                                    num25 = num18;
                                }
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                            }
                            if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                arrayList10.add(animeSearchResponseNewAnimeSearchResponse$default);
                            }
                            arrayList9 = arrayList11;
                            i16 = i17;
                            num20 = num24;
                            num18 = num25;
                        }
                        num22 = num20;
                        num23 = num18;
                        list2 = arrayList10;
                    } else {
                        arrayList7 = arrayList6;
                        num22 = num20;
                        num23 = num18;
                        list2 = null;
                    }
                    i13 = i9;
                    if (i13 != 0) {
                        TvType tvType14 = TvType.AnimeMovie;
                        Integer num211 = num19;
                        C00872 c00873 = new C00872(num22, num23, str20, num211, kitsuMeta6, str32, url, str18, iFloatValue, null);
                        C00861 c00869 = c00863;
                        c00869.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                        c00869.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                        c00869.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                        c00869.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                        c00869.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                        c00869.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                        c00869.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c00869.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                        c00869.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                        c00869.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                        c00869.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                        c00869.L$11 = SpillingKt.nullOutSpilledVariable(num211);
                        c00869.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                        c00869.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                        c00869.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                        c00869.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c00869.L$16 = SpillingKt.nullOutSpilledVariable(num22);
                        c00869.L$17 = SpillingKt.nullOutSpilledVariable(num23);
                        c00869.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                        c00869.L$19 = SpillingKt.nullOutSpilledVariable(url);
                        c00869.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                        c00869.L$21 = SpillingKt.nullOutSpilledVariable(list);
                        c00869.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                        c00869.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                        c00869.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                        c00869.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                        c00869.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                        c00869.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c00869.L$28 = SpillingKt.nullOutSpilledVariable(arrayList7);
                        c00869.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                        c00869.I$0 = i13;
                        c00869.I$1 = i6;
                        c00869.I$2 = i8;
                        c00869.I$3 = iFloatValue;
                        c00869.label = 8;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str37, str17, tvType14, stringData, c00873, c00869);
                        obj4 = obj2;
                        if (objNewMovieLoadResponse == obj4) {
                            return obj4;
                        }
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    Integer num212 = num19;
                    obj3 = obj2;
                    C00861 c008610 = c00863;
                    Integer num213 = num22;
                    Integer num31 = num23;
                    i14 = iFloatValue;
                    TvType tvType15 = TvType.Anime;
                    ArrayList arrayList112 = arrayList7;
                    C00883 c00884 = new C00883(num213, num31, str20, arrayList3, arrayList112, str18, num212, kitsuMeta6, str32, url, i14, this, list2, null);
                    c008610.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                    c008610.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                    c008610.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                    c008610.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                    c008610.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                    c008610.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                    c008610.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c008610.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                    c008610.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                    c008610.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                    c008610.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                    c008610.L$11 = SpillingKt.nullOutSpilledVariable(num212);
                    c008610.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                    c008610.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                    c008610.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                    c008610.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c008610.L$16 = SpillingKt.nullOutSpilledVariable(num213);
                    c008610.L$17 = SpillingKt.nullOutSpilledVariable(num31);
                    c008610.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                    c008610.L$19 = SpillingKt.nullOutSpilledVariable(url);
                    c008610.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                    c008610.L$21 = SpillingKt.nullOutSpilledVariable(list);
                    c008610.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                    c008610.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                    c008610.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                    c008610.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                    c008610.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                    c008610.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c008610.L$28 = SpillingKt.nullOutSpilledVariable(arrayList112);
                    c008610.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                    c008610.I$0 = i13;
                    c008610.I$1 = i6;
                    c008610.I$2 = i8;
                    c008610.I$3 = i14;
                    c008610.label = 9;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, str37, str17, tvType15, false, c00884, c008610, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj3) {
                        return obj3;
                    }
                    str42 = str21;
                    str43 = stringData;
                    i15 = i14;
                    obj5 = objNewAnimeLoadResponse$default;
                    return (LoadResponse) obj5;
                }
                StreamPlayKitsuHelper streamPlayKitsuHelper = StreamPlayKitsuHelper.INSTANCE;
                c00864.L$0 = str44;
                c00864.L$1 = str45;
                c00864.label = 1;
                meta = streamPlayKitsuHelper.getMeta(str45, c00864);
                if (meta == coroutine_suspended) {
                    return coroutine_suspended;
                }
                kitsuMeta = (StreamPlayKitsuHelper.KitsuMeta) meta;
                str4 = str44;
                if (kitsuMeta == null) {
                    throw new Exception("Unable to fetch Kitsu anime metadata for " + str45);
                }
                numericKitsuId = kitsuMeta.getNumericKitsuId();
                try {
                    if (numericKitsuId != null) {
                        sbAppend = new StringBuilder().append("kitsu_id=").append(numericKitsuId.intValue());
                    } else {
                        sbAppend = new StringBuilder().append("anilist_id=").append(str45);
                    }
                    String string3 = sbAppend.toString();
                    Requests app3 = MainActivityKt.getApp();
                    String str410 = "https://api.ani.zip/mappings?" + string3;
                    c00864.L$0 = str4;
                    c00864.L$1 = str45;
                    c00864.L$2 = kitsuMeta;
                    c00864.L$3 = numericKitsuId;
                    c00864.L$4 = SpillingKt.nullOutSpilledVariable(string3);
                    c00864.label = 5;
                    try {
                        obj = Requests.get$default(app3, str410, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00864, 4094, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str5 = str4;
                        kitsuMeta2 = kitsuMeta;
                        try {
                            text = ((NiceResponse) obj).getText();
                            num2 = numericKitsuId;
                            str6 = str5;
                            kitsuMeta3 = kitsuMeta2;
                        } catch (Throwable th) {
                            kitsuMeta = kitsuMeta2;
                            num = numericKitsuId;
                            str4 = str5;
                            kitsuMeta3 = kitsuMeta;
                            num2 = num;
                            text = str3;
                            str6 = str4;
                        }
                        if (text != null) {
                            animeData = StreamPlayUtilsKt.parseAnimeData(text);
                        } else {
                            r8 = str3;
                        }
                        if (r8 != 0 || (mappings2 = r8.getMappings()) == null || (themoviedbId = mappings2.getThemoviedbId()) == null) {
                            r8 = animeData;
                            r8 = animeData;
                            r8 = animeData;
                            intOrNull = str3;
                        } else {
                            intOrNull = StringsKt.toIntOrNull(themoviedbId);
                        }
                        if (r8 != 0 || (mappings = r8.getMappings()) == null || (strValueOf = mappings.getKitsuid()) == null) {
                            if (num2 != null) {
                                strValueOf = String.valueOf(num2.intValue());
                            } else {
                                strValueOf = str3;
                            }
                        }
                        r8 = animeData;
                        str7 = strValueOf;
                        r85 = intOrNull;
                        if (StringsKt.equals(kitsuMeta3.getType(), "movie", true) || StringsKt.equals(kitsuMeta3.getAnimeType(), "movie", true)) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (i != 0) {
                            tvType = TvType.Movie;
                        } else {
                            tvType = TvType.TvSeries;
                        }
                        if (i != 0) {
                            tvType2 = TvType.AnimeMovie;
                        } else {
                            tvType2 = TvType.TvSeries;
                        }
                        tvType3 = tvType2;
                        name = kitsuMeta3.getName();
                        if (name == null) {
                            aliases = kitsuMeta3.getAliases();
                            if (aliases != null) {
                                name = (String) CollectionsKt.firstOrNull(aliases);
                            } else {
                                name = null;
                            }
                            if (name == null) {
                                name = "Unknown";
                            }
                        }
                        str8 = name;
                        yearInt = kitsuMeta3.getYearInt();
                        if (yearInt != null) {
                            if (r8 != 0 || (episodes = r8.getEpisodes()) == null) {
                                tvType4 = tvType;
                            } else {
                                tvType4 = tvType;
                                MetaEpisode metaEpisode2 = episodes.get("1");
                                if (metaEpisode2 != null && (airDateUtc = metaEpisode2.getAirDateUtc()) != null && (strTake = StringsKt.take(airDateUtc, 4)) != null) {
                                    yearInt = StringsKt.toIntOrNull(strTake);
                                }
                            }
                            yearInt = null;
                        } else {
                            tvType4 = tvType;
                        }
                        num3 = yearInt;
                        c00864.L$0 = str6;
                        c00864.L$1 = str45;
                        c00864.L$2 = kitsuMeta3;
                        c00864.L$3 = num2;
                        c00864.L$4 = text;
                        c00864.L$5 = r8;
                        c00864.L$6 = SpillingKt.nullOutSpilledVariable((Object) r85);
                        c00864.L$7 = str7;
                        str9 = text;
                        c00864.L$8 = SpillingKt.nullOutSpilledVariable(tvType4);
                        c00864.L$9 = tvType3;
                        c00864.L$10 = str8;
                        c00864.L$11 = num3;
                        c00864.I$0 = i;
                        c00864.label = 6;
                        num4 = num2;
                        i2 = i;
                        r19 = r8;
                        str10 = str6;
                        tvType5 = tvType4;
                        kitsuMeta4 = kitsuMeta3;
                        num5 = null;
                        C00861 c008611 = c00864;
                        z = false;
                        objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", tvType5, r85, "en", c008611);
                        c00862 = c008611;
                        if (objFetchTmdbLogoUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str11 = str9;
                        str12 = str7;
                        tvType6 = tvType3;
                        str13 = str8;
                        num6 = num4;
                        i3 = i2;
                        num7 = num3;
                        str14 = str10;
                        tvType7 = tvType5;
                        r16 = r85;
                        r6 = r19;
                        kitsuMeta5 = kitsuMeta4;
                        str15 = (String) objFetchTmdbLogoUrl;
                        if (r6 != 0 || (mappings4 = r6.getMappings()) == null || (anilistId = mappings4.getAnilistId()) == null) {
                            if (StringsKt.toIntOrNull(str45) != null) {
                                str16 = str45;
                                charSequence = "kitsu:";
                                if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                                    intOrNull2 = StringsKt.toIntOrNull(str16);
                                }
                            } else {
                                str16 = str45;
                                charSequence = "kitsu:";
                            }
                            intOrNull2 = num5;
                        } else {
                            str16 = str45;
                            intOrNull2 = anilistId;
                            charSequence = "kitsu:";
                        }
                        if (r6 != 0 || (mappings3 = r6.getMappings()) == null) {
                            malId = num5;
                        } else {
                            malId = mappings3.getMalId();
                        }
                        if (malId == null || intOrNull2 != null) {
                            str17 = str14;
                            int i27 = i3;
                            Integer num214 = num7;
                            aniIds = new AniIds(intOrNull2, malId);
                            str18 = str15;
                            tvType8 = tvType6;
                            r21 = r6;
                            kitsuMeta6 = kitsuMeta5;
                            str19 = str11;
                            str20 = str12;
                            num8 = num214;
                            r23 = r16;
                            tvType9 = tvType7;
                            i4 = i27;
                            str21 = str16;
                            num9 = intOrNull2;
                            str22 = str13;
                            num10 = malId;
                        } else {
                            c00862.L$0 = str14;
                            c00862.L$1 = SpillingKt.nullOutSpilledVariable(str16);
                            c00862.L$2 = kitsuMeta5;
                            c00862.L$3 = num6;
                            c00862.L$4 = str11;
                            c00862.L$5 = r6;
                            c00862.L$6 = SpillingKt.nullOutSpilledVariable((Object) r16);
                            String str50 = str12;
                            c00862.L$7 = str50;
                            c00862.L$8 = SpillingKt.nullOutSpilledVariable(tvType7);
                            c00862.L$9 = SpillingKt.nullOutSpilledVariable(tvType6);
                            str23 = str13;
                            c00862.L$10 = str23;
                            Integer num32 = num7;
                            c00862.L$11 = num32;
                            c00862.L$12 = str15;
                            c00862.L$13 = intOrNull2;
                            c00862.L$14 = malId;
                            String str51 = str14;
                            int i28 = i3;
                            c00862.I$0 = i28;
                            c00862.label = 7;
                            TvType tvType16 = tvType6;
                            objTmdbToAnimeId = streamPlayAnime.tmdbToAnimeId(str23, num32, tvType16, c00862);
                            if (objTmdbToAnimeId == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            kitsuMeta7 = kitsuMeta5;
                            num11 = num6;
                            num8 = num32;
                            tvType10 = tvType7;
                            tvType11 = tvType16;
                            str24 = str50;
                            str25 = str51;
                            str26 = str15;
                            r110 = r6;
                            i4 = i28;
                            str27 = str11;
                            num12 = intOrNull2;
                            str28 = str16;
                            r17 = r16;
                            aniIds = (AniIds) objTmdbToAnimeId;
                            tvType8 = tvType11;
                            str18 = str26;
                            tvType9 = tvType10;
                            r23 = r17;
                            str20 = str24;
                            num6 = num11;
                            kitsuMeta6 = kitsuMeta7;
                            str21 = str28;
                            num9 = num12;
                            r21 = r110;
                            str19 = str27;
                            str17 = str25;
                            str22 = str23;
                            num10 = malId;
                        }
                        aniIds2 = aniIds;
                        id = aniIds2.getId();
                        if (id == null) {
                            num13 = num9;
                        } else {
                            num13 = id;
                        }
                        idMal = aniIds2.getIdMal();
                        if (idMal == null) {
                            num14 = num10;
                        } else {
                            num14 = idMal;
                        }
                        if (r21 != 0 || (titles5 = r21.getTitles()) == null || (str29 = titles5.get("ja")) == null) {
                            if (r21 != 0 || (titles = r21.getTitles()) == null) {
                                str29 = null;
                            } else {
                                str29 = titles.get("x-jat");
                            }
                            if (str29 != null) {
                                str30 = str29;
                            } else {
                                aliases2 = kitsuMeta6.getAliases();
                                if (aliases2 != null) {
                                    str29 = (String) CollectionsKt.firstOrNull(aliases2);
                                } else {
                                    str29 = null;
                                }
                                if (str29 == null) {
                                    str30 = str22;
                                } else {
                                    str30 = str29;
                                }
                            }
                        } else {
                            str30 = str29;
                        }
                        poster = kitsuMeta6.getPoster();
                        if (poster != null) {
                            if (r21 != 0 || (images3 = r21.getImages()) == null) {
                                obj2 = coroutine_suspended;
                                num15 = num14;
                                c00863 = c00862;
                            } else {
                                Iterator it3 = images3.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        next2 = it3.next();
                                        obj2 = coroutine_suspended;
                                        num15 = num14;
                                        c00863 = c00862;
                                        if (!StringsKt.equals(((ImageData) next2).getCoverType(), "Poster", true)) {
                                            coroutine_suspended = obj2;
                                            c00862 = c00863;
                                            num14 = num15;
                                        }
                                    } else {
                                        obj2 = coroutine_suspended;
                                        num15 = num14;
                                        c00863 = c00862;
                                        next2 = null;
                                    }
                                }
                                ImageData imageData3 = (ImageData) next2;
                                if (imageData3 != null) {
                                    url = imageData3.getUrl();
                                }
                            }
                            url = null;
                        } else {
                            obj2 = coroutine_suspended;
                            num15 = num14;
                            c00863 = c00862;
                            url = poster;
                        }
                        background = kitsuMeta6.getBackground();
                        if (background != null) {
                            str31 = background;
                        } else {
                            if (r21 != 0 && (images2 = r21.getImages()) != null) {
                                list6 = images2;
                                it2 = list6.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        next = it2.next();
                                        list7 = list6;
                                        if (StringsKt.equals(((ImageData) next).getCoverType(), "Fanart", true)) {
                                            list6 = list7;
                                        }
                                    } else {
                                        next = null;
                                    }
                                }
                                imageData2 = (ImageData) next;
                                if (imageData2 != null) {
                                    background = imageData2.getUrl();
                                    str31 = background;
                                }
                            }
                            str31 = null;
                        }
                        str32 = str31;
                        videos = kitsuMeta6.getVideos();
                        if (videos == null) {
                            videos = CollectionsKt.emptyList();
                        }
                        if (!videos.isEmpty()) {
                            size = videos.size();
                        } else if (r21 != 0 || (episodes2 = r21.getEpisodes()) == null) {
                            size = 1;
                        } else {
                            size = episodes2.size();
                        }
                        Iterable intRange5 = new IntRange(1, size);
                        linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange5, 10)), 16));
                        while (r31.hasNext()) {
                            iIntValue5 = ((Number) obj6).intValue();
                            if (str19 != null) {
                                list5 = videos;
                                Integer anidbEid3 = StreamPlayUtilsKt.getAnidbEid(str19, Boxing.boxInt(iIntValue5));
                                int iIntValue6 = anidbEid3 != null ? anidbEid3.intValue() : 0;
                                linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                                videos = list5;
                            } else {
                                list5 = videos;
                            }
                            linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                            videos = list5;
                        }
                        list = videos;
                        intRange = new IntRange(1, size);
                        i5 = 0;
                        linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange, 10)), 16));
                        while (r27.hasNext()) {
                            Iterable iterable3 = intRange;
                            iIntValue4 = ((Number) obj7).intValue();
                            if (r21 != 0) {
                                i20 = size;
                                episodes3 = r21.getEpisodes();
                                if (episodes3 != null) {
                                    i5 = i5;
                                    metaEpisode = episodes3.get(String.valueOf(iIntValue4));
                                }
                                linkedHashMap2.put(obj7, metaEpisode);
                                intRange = iterable3;
                                size = i20;
                                i5 = i5;
                            } else {
                                i20 = size;
                            }
                            metaEpisode = null;
                            linkedHashMap2.put(obj7, metaEpisode);
                            intRange = iterable3;
                            size = i20;
                            i5 = i5;
                        }
                        i6 = size;
                        if (url == null) {
                            if (r21 != 0 || (images = r21.getImages()) == null || (imageData = (ImageData) CollectionsKt.firstOrNull(images)) == null) {
                                url3 = null;
                            } else {
                                url3 = imageData.getUrl();
                            }
                            if (url3 == null) {
                                url3 = "";
                            }
                            str33 = url3;
                        } else {
                            str33 = url;
                        }
                        if (r21 != 0 || (titles4 = r21.getTitles()) == null || (str35 = titles4.get("en")) == null) {
                            if (r21 != 0 || (titles3 = r21.getTitles()) == null) {
                                str34 = null;
                            } else {
                                str34 = titles3.get("ja");
                            }
                            if (str34 == null) {
                                if (r21 != 0 || (titles2 = r21.getTitles()) == null) {
                                    str36 = null;
                                } else {
                                    str36 = titles2.get("x-jat");
                                }
                                if (str36 == null) {
                                    str35 = str22;
                                } else {
                                    str35 = str36;
                                }
                            } else {
                                str35 = str34;
                            }
                        }
                        num16 = (Integer) linkedHashMap.get(Boxing.boxInt(1));
                        if (num16 != null) {
                            iIntValue = num16.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        i7 = iIntValue;
                        num17 = num8;
                        str37 = str22;
                        str38 = str30;
                        stringData = streamPlayAnime.toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), num13, num15, str22, num17, null, true, null, null, null, str30, null, null, false, false, false, false, Boxing.boxInt(i7), num6, 16633983, null));
                        if (list.isEmpty()) {
                            list4 = list;
                            arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                            i18 = 0;
                            while (r37.hasNext()) {
                                int i29 = i18 + 1;
                                if (i18 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                ArrayList arrayList113 = arrayList12;
                                LinkedHashMap linkedHashMap11 = linkedHashMap;
                                StreamPlayKitsuHelper.KitsuVideo kitsuVideo4 = (StreamPlayKitsuHelper.KitsuVideo) obj8;
                                i19 = i18;
                                episode2 = kitsuVideo4.getEpisode();
                                if (episode2 != null) {
                                    iIntValue3 = episode2.intValue();
                                } else {
                                    iIntValue3 = i19 + 1;
                                }
                                CharSequence charSequence5 = charSequence;
                                List<StreamPlayKitsuHelper.KitsuVideo> list14 = list4;
                                LinkedHashMap linkedHashMap12 = linkedHashMap2;
                                String str411 = str35;
                                arrayList113.add(loadFromKitsu$createEpisode(linkedHashMap12, streamPlayAnime, linkedHashMap11, num13, num15, str37, num17, str38, num6, str33, str411, iIntValue3, kitsuVideo4, false));
                                streamPlayAnime = this;
                                linkedHashMap = linkedHashMap11;
                                str35 = str411;
                                arrayList12 = arrayList113;
                                i18 = i29;
                                obj5 = obj5;
                                i7 = i7;
                                i4 = i4;
                                linkedHashMap2 = linkedHashMap12;
                                list4 = list14;
                                charSequence = charSequence5;
                            }
                            ArrayList arrayList114 = arrayList12;
                            i8 = i7;
                            i9 = i4;
                            linkedHashMap4 = linkedHashMap;
                            charSequence2 = charSequence;
                            num18 = num15;
                            num19 = num17;
                            linkedHashMap3 = linkedHashMap2;
                            str39 = str35;
                            num20 = num13;
                            arrayList2 = arrayList114;
                            i11 = 10;
                        } else {
                            i8 = i7;
                            i9 = i4;
                            linkedHashMap3 = linkedHashMap2;
                            linkedHashMap4 = linkedHashMap;
                            charSequence2 = charSequence;
                            num18 = num15;
                            num19 = num17;
                            i10 = i6;
                            str39 = str35;
                            num20 = num13;
                            intRange2 = new IntRange(1, i10);
                            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
                            it = intRange2.iterator();
                            while (it.hasNext()) {
                                ArrayList arrayList115 = arrayList;
                                arrayList115.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, it.nextInt(), null, false));
                                i10 = i10;
                                arrayList = arrayList115;
                                intRange2 = intRange2;
                            }
                            i6 = i10;
                            i11 = 10;
                            arrayList2 = arrayList;
                        }
                        arrayList3 = arrayList2;
                        arrayList4 = arrayList3;
                        arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, i11));
                        i12 = 0;
                        while (r32.hasNext()) {
                            int i210 = i12 + 1;
                            if (i12 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            List<StreamPlayKitsuHelper.KitsuVideo> list15 = list;
                            kitsuVideo = (StreamPlayKitsuHelper.KitsuVideo) CollectionsKt.getOrNull(list15, i12);
                            if (kitsuVideo != null || (episode = kitsuVideo.getEpisode()) == null) {
                                iIntValue2 = i12 + 1;
                            } else {
                                iIntValue2 = episode.intValue();
                            }
                            list = list15;
                            arrayList5.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, iIntValue2, kitsuVideo, true));
                            i12 = i210;
                            arrayList4 = arrayList4;
                        }
                        linkedHashMap5 = linkedHashMap3;
                        linkedHashMap6 = linkedHashMap4;
                        num21 = num6;
                        str40 = str33;
                        str41 = str39;
                        arrayList6 = arrayList5;
                        imdbRating = kitsuMeta6.getImdbRating();
                        if (imdbRating != null || (floatOrNull = StringsKt.toFloatOrNull(imdbRating)) == null) {
                            iFloatValue = 0;
                        } else {
                            iFloatValue = (int) (10.0f * floatOrNull.floatValue());
                        }
                        links = kitsuMeta6.getLinks();
                        if (links != null) {
                            list3 = links;
                            arrayList8 = new ArrayList();
                            while (r10.hasNext()) {
                                ArrayList arrayList116 = arrayList6;
                                List<StreamPlayKitsuHelper.KitsuLink> list16 = list3;
                                if (StringsKt.equals(((StreamPlayKitsuHelper.KitsuLink) obj10).getCategory(), "Franchise", true)) {
                                    arrayList8.add(obj10);
                                }
                                arrayList6 = arrayList116;
                                list3 = list16;
                            }
                            arrayList7 = arrayList6;
                            arrayList9 = arrayList8;
                            i16 = 0;
                            arrayList10 = new ArrayList();
                            while (r11.hasNext()) {
                                name2 = kitsuLink.getName();
                                if (name2 == null) {
                                    arrayList11 = arrayList9;
                                    i17 = i16;
                                    num24 = num20;
                                    num25 = num18;
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                } else {
                                    arrayList11 = arrayList9;
                                    url2 = kitsuLink.getUrl();
                                    if (url2 != null) {
                                        i17 = i16;
                                        num24 = num20;
                                        num25 = num18;
                                        strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                        if (strSubstringAfterLast$default == null) {
                                            animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                        }
                                    } else {
                                        i17 = i16;
                                        num24 = num20;
                                        num25 = num18;
                                    }
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                }
                                if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                    arrayList10.add(animeSearchResponseNewAnimeSearchResponse$default);
                                }
                                arrayList9 = arrayList11;
                                i16 = i17;
                                num20 = num24;
                                num18 = num25;
                            }
                            num22 = num20;
                            num23 = num18;
                            list2 = arrayList10;
                        } else {
                            arrayList7 = arrayList6;
                            num22 = num20;
                            num23 = num18;
                            list2 = null;
                        }
                        i13 = i9;
                        if (i13 != 0) {
                            TvType tvType17 = TvType.AnimeMovie;
                            Integer num215 = num19;
                            C00872 c00874 = new C00872(num22, num23, str20, num215, kitsuMeta6, str32, url, str18, iFloatValue, null);
                            C00861 c008612 = c00863;
                            c008612.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                            c008612.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                            c008612.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                            c008612.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                            c008612.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                            c008612.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                            c008612.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                            c008612.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                            c008612.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                            c008612.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                            c008612.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                            c008612.L$11 = SpillingKt.nullOutSpilledVariable(num215);
                            c008612.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                            c008612.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                            c008612.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                            c008612.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                            c008612.L$16 = SpillingKt.nullOutSpilledVariable(num22);
                            c008612.L$17 = SpillingKt.nullOutSpilledVariable(num23);
                            c008612.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                            c008612.L$19 = SpillingKt.nullOutSpilledVariable(url);
                            c008612.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                            c008612.L$21 = SpillingKt.nullOutSpilledVariable(list);
                            c008612.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                            c008612.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                            c008612.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                            c008612.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                            c008612.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                            c008612.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                            c008612.L$28 = SpillingKt.nullOutSpilledVariable(arrayList7);
                            c008612.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                            c008612.I$0 = i13;
                            c008612.I$1 = i6;
                            c008612.I$2 = i8;
                            c008612.I$3 = iFloatValue;
                            c008612.label = 8;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str37, str17, tvType17, stringData, c00874, c008612);
                            obj4 = obj2;
                            if (objNewMovieLoadResponse == obj4) {
                                return obj4;
                            }
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        Integer num216 = num19;
                        obj3 = obj2;
                        C00861 c008613 = c00863;
                        Integer num217 = num22;
                        Integer num33 = num23;
                        i14 = iFloatValue;
                        TvType tvType18 = TvType.Anime;
                        ArrayList arrayList117 = arrayList7;
                        C00883 c00885 = new C00883(num217, num33, str20, arrayList3, arrayList117, str18, num216, kitsuMeta6, str32, url, i14, this, list2, null);
                        c008613.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                        c008613.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                        c008613.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                        c008613.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                        c008613.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                        c008613.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                        c008613.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c008613.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                        c008613.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                        c008613.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                        c008613.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                        c008613.L$11 = SpillingKt.nullOutSpilledVariable(num216);
                        c008613.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                        c008613.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                        c008613.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                        c008613.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c008613.L$16 = SpillingKt.nullOutSpilledVariable(num217);
                        c008613.L$17 = SpillingKt.nullOutSpilledVariable(num33);
                        c008613.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                        c008613.L$19 = SpillingKt.nullOutSpilledVariable(url);
                        c008613.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                        c008613.L$21 = SpillingKt.nullOutSpilledVariable(list);
                        c008613.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                        c008613.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                        c008613.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                        c008613.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                        c008613.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                        c008613.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c008613.L$28 = SpillingKt.nullOutSpilledVariable(arrayList117);
                        c008613.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                        c008613.I$0 = i13;
                        c008613.I$1 = i6;
                        c008613.I$2 = i8;
                        c008613.I$3 = i14;
                        c008613.label = 9;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, str37, str17, tvType18, false, c00885, c008613, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == obj3) {
                            return obj3;
                        }
                        str42 = str21;
                        str43 = stringData;
                        i15 = i14;
                        obj5 = objNewAnimeLoadResponse$default;
                        return (LoadResponse) obj5;
                    } catch (Throwable th2) {
                        c00864 = c00864;
                        num = numericKitsuId;
                        kitsuMeta3 = kitsuMeta;
                        num2 = num;
                        text = str3;
                        str6 = str4;
                        if (text != null) {
                            animeData = StreamPlayUtilsKt.parseAnimeData(text);
                        } else {
                            r8 = str3;
                        }
                        if (r8 != 0) {
                            r8 = animeData;
                            r8 = animeData;
                            r8 = animeData;
                            intOrNull = str3;
                        } else {
                            r8 = animeData;
                            r8 = animeData;
                            r8 = animeData;
                            intOrNull = str3;
                        }
                        if (r8 != 0) {
                            if (num2 != null) {
                                strValueOf = String.valueOf(num2.intValue());
                            } else {
                                strValueOf = str3;
                            }
                        } else if (num2 != null) {
                            strValueOf = String.valueOf(num2.intValue());
                        } else {
                            strValueOf = str3;
                        }
                        r8 = animeData;
                        str7 = strValueOf;
                        r85 = intOrNull;
                        if (StringsKt.equals(kitsuMeta3.getType(), "movie", true)) {
                            i = 1;
                        } else {
                            i = 1;
                        }
                        if (i != 0) {
                            tvType = TvType.Movie;
                        } else {
                            tvType = TvType.TvSeries;
                        }
                        if (i != 0) {
                            tvType2 = TvType.AnimeMovie;
                        } else {
                            tvType2 = TvType.TvSeries;
                        }
                        tvType3 = tvType2;
                        name = kitsuMeta3.getName();
                        if (name == null) {
                            aliases = kitsuMeta3.getAliases();
                            if (aliases != null) {
                                name = (String) CollectionsKt.firstOrNull(aliases);
                            } else {
                                name = null;
                            }
                            if (name == null) {
                                name = "Unknown";
                            }
                        }
                        str8 = name;
                        yearInt = kitsuMeta3.getYearInt();
                        if (yearInt != null) {
                            tvType4 = tvType;
                        } else if (r8 != 0) {
                            tvType4 = tvType;
                            yearInt = null;
                        } else {
                            tvType4 = tvType;
                            yearInt = null;
                        }
                        num3 = yearInt;
                        c00864.L$0 = str6;
                        c00864.L$1 = str45;
                        c00864.L$2 = kitsuMeta3;
                        c00864.L$3 = num2;
                        c00864.L$4 = text;
                        c00864.L$5 = r8;
                        c00864.L$6 = SpillingKt.nullOutSpilledVariable((Object) r85);
                        c00864.L$7 = str7;
                        str9 = text;
                        c00864.L$8 = SpillingKt.nullOutSpilledVariable(tvType4);
                        c00864.L$9 = tvType3;
                        c00864.L$10 = str8;
                        c00864.L$11 = num3;
                        c00864.I$0 = i;
                        c00864.label = 6;
                        num4 = num2;
                        i2 = i;
                        r19 = r8;
                        str10 = str6;
                        tvType5 = tvType4;
                        kitsuMeta4 = kitsuMeta3;
                        num5 = null;
                        C00861 c008614 = c00864;
                        z = false;
                        objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", tvType5, r85, "en", c008614);
                        c00862 = c008614;
                        if (objFetchTmdbLogoUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str11 = str9;
                        str12 = str7;
                        tvType6 = tvType3;
                        str13 = str8;
                        num6 = num4;
                        i3 = i2;
                        num7 = num3;
                        str14 = str10;
                        tvType7 = tvType5;
                        r16 = r85;
                        r6 = r19;
                        kitsuMeta5 = kitsuMeta4;
                        str15 = (String) objFetchTmdbLogoUrl;
                        if (r6 != 0) {
                            if (StringsKt.toIntOrNull(str45) != null) {
                                str16 = str45;
                                charSequence = "kitsu:";
                                if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                                    intOrNull2 = StringsKt.toIntOrNull(str16);
                                }
                            } else {
                                str16 = str45;
                                charSequence = "kitsu:";
                            }
                            intOrNull2 = num5;
                        } else {
                            if (StringsKt.toIntOrNull(str45) != null) {
                                str16 = str45;
                                charSequence = "kitsu:";
                                if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                                    intOrNull2 = StringsKt.toIntOrNull(str16);
                                }
                            } else {
                                str16 = str45;
                                charSequence = "kitsu:";
                            }
                            intOrNull2 = num5;
                        }
                        if (r6 != 0) {
                            malId = num5;
                        } else {
                            malId = num5;
                        }
                        if (malId == null) {
                        }
                        str17 = str14;
                        int i211 = i3;
                        Integer num218 = num7;
                        aniIds = new AniIds(intOrNull2, malId);
                        str18 = str15;
                        tvType8 = tvType6;
                        r21 = r6;
                        kitsuMeta6 = kitsuMeta5;
                        str19 = str11;
                        str20 = str12;
                        num8 = num218;
                        r23 = r16;
                        tvType9 = tvType7;
                        i4 = i211;
                        str21 = str16;
                        num9 = intOrNull2;
                        str22 = str13;
                        num10 = malId;
                        aniIds2 = aniIds;
                        id = aniIds2.getId();
                        if (id == null) {
                            num13 = num9;
                        } else {
                            num13 = id;
                        }
                        idMal = aniIds2.getIdMal();
                        if (idMal == null) {
                            num14 = num10;
                        } else {
                            num14 = idMal;
                        }
                        if (r21 != 0) {
                            if (r21 != 0) {
                                str29 = null;
                            } else {
                                str29 = null;
                            }
                            if (str29 != null) {
                                str30 = str29;
                            } else {
                                aliases2 = kitsuMeta6.getAliases();
                                if (aliases2 != null) {
                                    str29 = (String) CollectionsKt.firstOrNull(aliases2);
                                } else {
                                    str29 = null;
                                }
                                if (str29 == null) {
                                    str30 = str22;
                                } else {
                                    str30 = str29;
                                }
                            }
                        } else {
                            if (r21 != 0) {
                                str29 = null;
                            } else {
                                str29 = null;
                            }
                            if (str29 != null) {
                                str30 = str29;
                            } else {
                                aliases2 = kitsuMeta6.getAliases();
                                if (aliases2 != null) {
                                    str29 = (String) CollectionsKt.firstOrNull(aliases2);
                                } else {
                                    str29 = null;
                                }
                                if (str29 == null) {
                                    str30 = str22;
                                } else {
                                    str30 = str29;
                                }
                            }
                        }
                        poster = kitsuMeta6.getPoster();
                        if (poster != null) {
                            obj2 = coroutine_suspended;
                            num15 = num14;
                            c00863 = c00862;
                            url = poster;
                        } else if (r21 != 0) {
                            obj2 = coroutine_suspended;
                            num15 = num14;
                            c00863 = c00862;
                            url = null;
                        } else {
                            obj2 = coroutine_suspended;
                            num15 = num14;
                            c00863 = c00862;
                            url = null;
                        }
                        background = kitsuMeta6.getBackground();
                        if (background != null) {
                            str31 = background;
                        } else {
                            if (r21 != 0) {
                                list6 = images2;
                                it2 = list6.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        next = it2.next();
                                        list7 = list6;
                                        if (StringsKt.equals(((ImageData) next).getCoverType(), "Fanart", true)) {
                                            list6 = list7;
                                        }
                                    } else {
                                        next = null;
                                    }
                                }
                                imageData2 = (ImageData) next;
                                if (imageData2 != null) {
                                    background = imageData2.getUrl();
                                    str31 = background;
                                }
                            }
                            str31 = null;
                        }
                        str32 = str31;
                        videos = kitsuMeta6.getVideos();
                        if (videos == null) {
                            videos = CollectionsKt.emptyList();
                        }
                        if (!videos.isEmpty()) {
                            size = videos.size();
                        } else if (r21 != 0) {
                            size = 1;
                        } else {
                            size = 1;
                        }
                        Iterable intRange6 = new IntRange(1, size);
                        linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange6, 10)), 16));
                        while (r31.hasNext()) {
                            iIntValue5 = ((Number) obj6).intValue();
                            if (str19 != null) {
                                list5 = videos;
                                Integer anidbEid4 = StreamPlayUtilsKt.getAnidbEid(str19, Boxing.boxInt(iIntValue5));
                                if (anidbEid4 != null) {
                                }
                                linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                                videos = list5;
                            } else {
                                list5 = videos;
                            }
                            linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                            videos = list5;
                        }
                        list = videos;
                        intRange = new IntRange(1, size);
                        i5 = 0;
                        linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange, 10)), 16));
                        while (r27.hasNext()) {
                            Iterable iterable4 = intRange;
                            iIntValue4 = ((Number) obj7).intValue();
                            if (r21 != 0) {
                                i20 = size;
                                episodes3 = r21.getEpisodes();
                                if (episodes3 != null) {
                                    i5 = i5;
                                    metaEpisode = episodes3.get(String.valueOf(iIntValue4));
                                }
                                linkedHashMap2.put(obj7, metaEpisode);
                                intRange = iterable4;
                                size = i20;
                                i5 = i5;
                            } else {
                                i20 = size;
                            }
                            metaEpisode = null;
                            linkedHashMap2.put(obj7, metaEpisode);
                            intRange = iterable4;
                            size = i20;
                            i5 = i5;
                        }
                        i6 = size;
                        if (url == null) {
                            if (r21 != 0) {
                                url3 = null;
                            } else {
                                url3 = null;
                            }
                            if (url3 == null) {
                                url3 = "";
                            }
                            str33 = url3;
                        } else {
                            str33 = url;
                        }
                        if (r21 != 0) {
                            if (r21 != 0) {
                                str34 = null;
                            } else {
                                str34 = null;
                            }
                            if (str34 == null) {
                                if (r21 != 0) {
                                    str36 = null;
                                } else {
                                    str36 = null;
                                }
                                if (str36 == null) {
                                    str35 = str22;
                                } else {
                                    str35 = str36;
                                }
                            } else {
                                str35 = str34;
                            }
                        } else {
                            if (r21 != 0) {
                                str34 = null;
                            } else {
                                str34 = null;
                            }
                            if (str34 == null) {
                                if (r21 != 0) {
                                    str36 = null;
                                } else {
                                    str36 = null;
                                }
                                if (str36 == null) {
                                    str35 = str22;
                                } else {
                                    str35 = str36;
                                }
                            } else {
                                str35 = str34;
                            }
                        }
                        num16 = (Integer) linkedHashMap.get(Boxing.boxInt(1));
                        if (num16 != null) {
                            iIntValue = num16.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        i7 = iIntValue;
                        num17 = num8;
                        str37 = str22;
                        str38 = str30;
                        stringData = streamPlayAnime.toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), num13, num15, str22, num17, null, true, null, null, null, str30, null, null, false, false, false, false, Boxing.boxInt(i7), num6, 16633983, null));
                        if (list.isEmpty()) {
                            list4 = list;
                            arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                            i18 = 0;
                            while (r37.hasNext()) {
                                int i212 = i18 + 1;
                                if (i18 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                ArrayList arrayList118 = arrayList12;
                                LinkedHashMap linkedHashMap13 = linkedHashMap;
                                StreamPlayKitsuHelper.KitsuVideo kitsuVideo5 = (StreamPlayKitsuHelper.KitsuVideo) obj8;
                                i19 = i18;
                                episode2 = kitsuVideo5.getEpisode();
                                if (episode2 != null) {
                                    iIntValue3 = episode2.intValue();
                                } else {
                                    iIntValue3 = i19 + 1;
                                }
                                CharSequence charSequence6 = charSequence;
                                List<StreamPlayKitsuHelper.KitsuVideo> list17 = list4;
                                LinkedHashMap linkedHashMap14 = linkedHashMap2;
                                String str412 = str35;
                                arrayList118.add(loadFromKitsu$createEpisode(linkedHashMap14, streamPlayAnime, linkedHashMap13, num13, num15, str37, num17, str38, num6, str33, str412, iIntValue3, kitsuVideo5, false));
                                streamPlayAnime = this;
                                linkedHashMap = linkedHashMap13;
                                str35 = str412;
                                arrayList12 = arrayList118;
                                i18 = i212;
                                obj5 = obj5;
                                i7 = i7;
                                i4 = i4;
                                linkedHashMap2 = linkedHashMap14;
                                list4 = list17;
                                charSequence = charSequence6;
                            }
                            ArrayList arrayList119 = arrayList12;
                            i8 = i7;
                            i9 = i4;
                            linkedHashMap4 = linkedHashMap;
                            charSequence2 = charSequence;
                            num18 = num15;
                            num19 = num17;
                            linkedHashMap3 = linkedHashMap2;
                            str39 = str35;
                            num20 = num13;
                            arrayList2 = arrayList119;
                            i11 = 10;
                        } else {
                            i8 = i7;
                            i9 = i4;
                            linkedHashMap3 = linkedHashMap2;
                            linkedHashMap4 = linkedHashMap;
                            charSequence2 = charSequence;
                            num18 = num15;
                            num19 = num17;
                            i10 = i6;
                            str39 = str35;
                            num20 = num13;
                            intRange2 = new IntRange(1, i10);
                            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
                            it = intRange2.iterator();
                            while (it.hasNext()) {
                                ArrayList arrayList1110 = arrayList;
                                arrayList1110.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, it.nextInt(), null, false));
                                i10 = i10;
                                arrayList = arrayList1110;
                                intRange2 = intRange2;
                            }
                            i6 = i10;
                            i11 = 10;
                            arrayList2 = arrayList;
                        }
                        arrayList3 = arrayList2;
                        arrayList4 = arrayList3;
                        arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, i11));
                        i12 = 0;
                        while (r32.hasNext()) {
                            int i213 = i12 + 1;
                            if (i12 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            List<StreamPlayKitsuHelper.KitsuVideo> list18 = list;
                            kitsuVideo = (StreamPlayKitsuHelper.KitsuVideo) CollectionsKt.getOrNull(list18, i12);
                            if (kitsuVideo != null) {
                                iIntValue2 = i12 + 1;
                            } else {
                                iIntValue2 = i12 + 1;
                            }
                            list = list18;
                            arrayList5.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, iIntValue2, kitsuVideo, true));
                            i12 = i213;
                            arrayList4 = arrayList4;
                        }
                        linkedHashMap5 = linkedHashMap3;
                        linkedHashMap6 = linkedHashMap4;
                        num21 = num6;
                        str40 = str33;
                        str41 = str39;
                        arrayList6 = arrayList5;
                        imdbRating = kitsuMeta6.getImdbRating();
                        if (imdbRating != null) {
                            iFloatValue = 0;
                        } else {
                            iFloatValue = 0;
                        }
                        links = kitsuMeta6.getLinks();
                        if (links != null) {
                            list3 = links;
                            arrayList8 = new ArrayList();
                            while (r10.hasNext()) {
                                ArrayList arrayList1111 = arrayList6;
                                List<StreamPlayKitsuHelper.KitsuLink> list19 = list3;
                                if (StringsKt.equals(((StreamPlayKitsuHelper.KitsuLink) obj10).getCategory(), "Franchise", true)) {
                                    arrayList8.add(obj10);
                                }
                                arrayList6 = arrayList1111;
                                list3 = list19;
                            }
                            arrayList7 = arrayList6;
                            arrayList9 = arrayList8;
                            i16 = 0;
                            arrayList10 = new ArrayList();
                            while (r11.hasNext()) {
                                name2 = kitsuLink.getName();
                                if (name2 == null) {
                                    arrayList11 = arrayList9;
                                    i17 = i16;
                                    num24 = num20;
                                    num25 = num18;
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                } else {
                                    arrayList11 = arrayList9;
                                    url2 = kitsuLink.getUrl();
                                    if (url2 != null) {
                                        i17 = i16;
                                        num24 = num20;
                                        num25 = num18;
                                        strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                        if (strSubstringAfterLast$default == null) {
                                            animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                        }
                                    } else {
                                        i17 = i16;
                                        num24 = num20;
                                        num25 = num18;
                                    }
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                }
                                if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                    arrayList10.add(animeSearchResponseNewAnimeSearchResponse$default);
                                }
                                arrayList9 = arrayList11;
                                i16 = i17;
                                num20 = num24;
                                num18 = num25;
                            }
                            num22 = num20;
                            num23 = num18;
                            list2 = arrayList10;
                        } else {
                            arrayList7 = arrayList6;
                            num22 = num20;
                            num23 = num18;
                            list2 = null;
                        }
                        i13 = i9;
                        if (i13 != 0) {
                            TvType tvType19 = TvType.AnimeMovie;
                            Integer num219 = num19;
                            C00872 c00875 = new C00872(num22, num23, str20, num219, kitsuMeta6, str32, url, str18, iFloatValue, null);
                            C00861 c008615 = c00863;
                            c008615.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                            c008615.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                            c008615.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                            c008615.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                            c008615.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                            c008615.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                            c008615.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                            c008615.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                            c008615.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                            c008615.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                            c008615.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                            c008615.L$11 = SpillingKt.nullOutSpilledVariable(num219);
                            c008615.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                            c008615.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                            c008615.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                            c008615.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                            c008615.L$16 = SpillingKt.nullOutSpilledVariable(num22);
                            c008615.L$17 = SpillingKt.nullOutSpilledVariable(num23);
                            c008615.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                            c008615.L$19 = SpillingKt.nullOutSpilledVariable(url);
                            c008615.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                            c008615.L$21 = SpillingKt.nullOutSpilledVariable(list);
                            c008615.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                            c008615.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                            c008615.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                            c008615.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                            c008615.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                            c008615.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                            c008615.L$28 = SpillingKt.nullOutSpilledVariable(arrayList7);
                            c008615.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                            c008615.I$0 = i13;
                            c008615.I$1 = i6;
                            c008615.I$2 = i8;
                            c008615.I$3 = iFloatValue;
                            c008615.label = 8;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str37, str17, tvType19, stringData, c00875, c008615);
                            obj4 = obj2;
                            if (objNewMovieLoadResponse == obj4) {
                                return obj4;
                            }
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        Integer num2110 = num19;
                        obj3 = obj2;
                        C00861 c008616 = c00863;
                        Integer num2111 = num22;
                        Integer num34 = num23;
                        i14 = iFloatValue;
                        TvType tvType110 = TvType.Anime;
                        ArrayList arrayList1112 = arrayList7;
                        C00883 c00886 = new C00883(num2111, num34, str20, arrayList3, arrayList1112, str18, num2110, kitsuMeta6, str32, url, i14, this, list2, null);
                        c008616.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                        c008616.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                        c008616.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                        c008616.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                        c008616.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                        c008616.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                        c008616.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c008616.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                        c008616.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                        c008616.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                        c008616.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                        c008616.L$11 = SpillingKt.nullOutSpilledVariable(num2110);
                        c008616.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                        c008616.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                        c008616.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                        c008616.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c008616.L$16 = SpillingKt.nullOutSpilledVariable(num2111);
                        c008616.L$17 = SpillingKt.nullOutSpilledVariable(num34);
                        c008616.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                        c008616.L$19 = SpillingKt.nullOutSpilledVariable(url);
                        c008616.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                        c008616.L$21 = SpillingKt.nullOutSpilledVariable(list);
                        c008616.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                        c008616.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                        c008616.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                        c008616.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                        c008616.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                        c008616.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c008616.L$28 = SpillingKt.nullOutSpilledVariable(arrayList1112);
                        c008616.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                        c008616.I$0 = i13;
                        c008616.I$1 = i6;
                        c008616.I$2 = i8;
                        c008616.I$3 = i14;
                        c008616.label = 9;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, str37, str17, tvType110, false, c00886, c008616, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == obj3) {
                            return obj3;
                        }
                        str42 = str21;
                        str43 = stringData;
                        i15 = i14;
                        obj5 = objNewAnimeLoadResponse$default;
                        return (LoadResponse) obj5;
                    }
                } catch (Throwable th3) {
                    num = numericKitsuId;
                }
                break;
            case 1:
                str45 = (String) c00864.L$1;
                str44 = (String) c00864.L$0;
                ResultKt.throwOnFailure(obj5);
                meta = obj5;
                str3 = null;
                kitsuMeta = (StreamPlayKitsuHelper.KitsuMeta) meta;
                str4 = str44;
                if (kitsuMeta == null) {
                    throw new Exception("Unable to fetch Kitsu anime metadata for " + str45);
                }
                numericKitsuId = kitsuMeta.getNumericKitsuId();
                if (numericKitsuId != null) {
                    sbAppend = new StringBuilder().append("kitsu_id=").append(numericKitsuId.intValue());
                } else {
                    sbAppend = new StringBuilder().append("anilist_id=").append(str45);
                }
                String string4 = sbAppend.toString();
                Requests app4 = MainActivityKt.getApp();
                String str413 = "https://api.ani.zip/mappings?" + string4;
                c00864.L$0 = str4;
                c00864.L$1 = str45;
                c00864.L$2 = kitsuMeta;
                c00864.L$3 = numericKitsuId;
                c00864.L$4 = SpillingKt.nullOutSpilledVariable(string4);
                c00864.label = 5;
                obj = Requests.get$default(app4, str413, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00864, 4094, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str5 = str4;
                kitsuMeta2 = kitsuMeta;
                text = ((NiceResponse) obj).getText();
                num2 = numericKitsuId;
                str6 = str5;
                kitsuMeta3 = kitsuMeta2;
                if (text != null) {
                    animeData = StreamPlayUtilsKt.parseAnimeData(text);
                } else {
                    r8 = str3;
                }
                if (r8 != 0) {
                    r8 = animeData;
                    r8 = animeData;
                    r8 = animeData;
                    intOrNull = str3;
                } else {
                    r8 = animeData;
                    r8 = animeData;
                    r8 = animeData;
                    intOrNull = str3;
                }
                if (r8 != 0) {
                    if (num2 != null) {
                        strValueOf = String.valueOf(num2.intValue());
                    } else {
                        strValueOf = str3;
                    }
                } else if (num2 != null) {
                    strValueOf = String.valueOf(num2.intValue());
                } else {
                    strValueOf = str3;
                }
                r8 = animeData;
                str7 = strValueOf;
                r85 = intOrNull;
                if (StringsKt.equals(kitsuMeta3.getType(), "movie", true)) {
                    i = 1;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                if (i != 0) {
                    tvType2 = TvType.AnimeMovie;
                } else {
                    tvType2 = TvType.TvSeries;
                }
                tvType3 = tvType2;
                name = kitsuMeta3.getName();
                if (name == null) {
                    aliases = kitsuMeta3.getAliases();
                    if (aliases != null) {
                        name = (String) CollectionsKt.firstOrNull(aliases);
                    } else {
                        name = null;
                    }
                    if (name == null) {
                        name = "Unknown";
                    }
                }
                str8 = name;
                yearInt = kitsuMeta3.getYearInt();
                if (yearInt != null) {
                    tvType4 = tvType;
                } else if (r8 != 0) {
                    tvType4 = tvType;
                    yearInt = null;
                } else {
                    tvType4 = tvType;
                    yearInt = null;
                }
                num3 = yearInt;
                c00864.L$0 = str6;
                c00864.L$1 = str45;
                c00864.L$2 = kitsuMeta3;
                c00864.L$3 = num2;
                c00864.L$4 = text;
                c00864.L$5 = r8;
                c00864.L$6 = SpillingKt.nullOutSpilledVariable((Object) r85);
                c00864.L$7 = str7;
                str9 = text;
                c00864.L$8 = SpillingKt.nullOutSpilledVariable(tvType4);
                c00864.L$9 = tvType3;
                c00864.L$10 = str8;
                c00864.L$11 = num3;
                c00864.I$0 = i;
                c00864.label = 6;
                num4 = num2;
                i2 = i;
                r19 = r8;
                str10 = str6;
                tvType5 = tvType4;
                kitsuMeta4 = kitsuMeta3;
                num5 = null;
                C00861 c008617 = c00864;
                z = false;
                objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", tvType5, r85, "en", c008617);
                c00862 = c008617;
                if (objFetchTmdbLogoUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str11 = str9;
                str12 = str7;
                tvType6 = tvType3;
                str13 = str8;
                num6 = num4;
                i3 = i2;
                num7 = num3;
                str14 = str10;
                tvType7 = tvType5;
                r16 = r85;
                r6 = r19;
                kitsuMeta5 = kitsuMeta4;
                str15 = (String) objFetchTmdbLogoUrl;
                if (r6 != 0) {
                    if (StringsKt.toIntOrNull(str45) != null) {
                        str16 = str45;
                        charSequence = "kitsu:";
                        if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                            intOrNull2 = StringsKt.toIntOrNull(str16);
                        }
                    } else {
                        str16 = str45;
                        charSequence = "kitsu:";
                    }
                    intOrNull2 = num5;
                } else {
                    if (StringsKt.toIntOrNull(str45) != null) {
                        str16 = str45;
                        charSequence = "kitsu:";
                        if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                            intOrNull2 = StringsKt.toIntOrNull(str16);
                        }
                    } else {
                        str16 = str45;
                        charSequence = "kitsu:";
                    }
                    intOrNull2 = num5;
                }
                if (r6 != 0) {
                    malId = num5;
                } else {
                    malId = num5;
                }
                if (malId == null) {
                }
                str17 = str14;
                int i214 = i3;
                Integer num2112 = num7;
                aniIds = new AniIds(intOrNull2, malId);
                str18 = str15;
                tvType8 = tvType6;
                r21 = r6;
                kitsuMeta6 = kitsuMeta5;
                str19 = str11;
                str20 = str12;
                num8 = num2112;
                r23 = r16;
                tvType9 = tvType7;
                i4 = i214;
                str21 = str16;
                num9 = intOrNull2;
                str22 = str13;
                num10 = malId;
                aniIds2 = aniIds;
                id = aniIds2.getId();
                if (id == null) {
                    num13 = num9;
                } else {
                    num13 = id;
                }
                idMal = aniIds2.getIdMal();
                if (idMal == null) {
                    num14 = num10;
                } else {
                    num14 = idMal;
                }
                if (r21 != 0) {
                    if (r21 != 0) {
                        str29 = null;
                    } else {
                        str29 = null;
                    }
                    if (str29 != null) {
                        str30 = str29;
                    } else {
                        aliases2 = kitsuMeta6.getAliases();
                        if (aliases2 != null) {
                            str29 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str29 = null;
                        }
                        if (str29 == null) {
                            str30 = str22;
                        } else {
                            str30 = str29;
                        }
                    }
                } else {
                    if (r21 != 0) {
                        str29 = null;
                    } else {
                        str29 = null;
                    }
                    if (str29 != null) {
                        str30 = str29;
                    } else {
                        aliases2 = kitsuMeta6.getAliases();
                        if (aliases2 != null) {
                            str29 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str29 = null;
                        }
                        if (str29 == null) {
                            str30 = str22;
                        } else {
                            str30 = str29;
                        }
                    }
                }
                poster = kitsuMeta6.getPoster();
                if (poster != null) {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = poster;
                } else if (r21 != 0) {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = null;
                } else {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = null;
                }
                background = kitsuMeta6.getBackground();
                if (background != null) {
                    str31 = background;
                } else {
                    if (r21 != 0) {
                        list6 = images2;
                        it2 = list6.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                next = it2.next();
                                list7 = list6;
                                if (StringsKt.equals(((ImageData) next).getCoverType(), "Fanart", true)) {
                                    list6 = list7;
                                }
                            } else {
                                next = null;
                            }
                        }
                        imageData2 = (ImageData) next;
                        if (imageData2 != null) {
                            background = imageData2.getUrl();
                            str31 = background;
                        }
                    }
                    str31 = null;
                }
                str32 = str31;
                videos = kitsuMeta6.getVideos();
                if (videos == null) {
                    videos = CollectionsKt.emptyList();
                }
                if (!videos.isEmpty()) {
                    size = videos.size();
                } else if (r21 != 0) {
                    size = 1;
                } else {
                    size = 1;
                }
                Iterable intRange7 = new IntRange(1, size);
                linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange7, 10)), 16));
                while (r31.hasNext()) {
                    iIntValue5 = ((Number) obj6).intValue();
                    if (str19 != null) {
                        list5 = videos;
                        Integer anidbEid5 = StreamPlayUtilsKt.getAnidbEid(str19, Boxing.boxInt(iIntValue5));
                        if (anidbEid5 != null) {
                        }
                        linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                        videos = list5;
                    } else {
                        list5 = videos;
                    }
                    linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                    videos = list5;
                }
                list = videos;
                intRange = new IntRange(1, size);
                i5 = 0;
                linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange, 10)), 16));
                while (r27.hasNext()) {
                    Iterable iterable5 = intRange;
                    iIntValue4 = ((Number) obj7).intValue();
                    if (r21 != 0) {
                        i20 = size;
                        episodes3 = r21.getEpisodes();
                        if (episodes3 != null) {
                            i5 = i5;
                            metaEpisode = episodes3.get(String.valueOf(iIntValue4));
                        }
                        linkedHashMap2.put(obj7, metaEpisode);
                        intRange = iterable5;
                        size = i20;
                        i5 = i5;
                    } else {
                        i20 = size;
                    }
                    metaEpisode = null;
                    linkedHashMap2.put(obj7, metaEpisode);
                    intRange = iterable5;
                    size = i20;
                    i5 = i5;
                }
                i6 = size;
                if (url == null) {
                    if (r21 != 0) {
                        url3 = null;
                    } else {
                        url3 = null;
                    }
                    if (url3 == null) {
                        url3 = "";
                    }
                    str33 = url3;
                } else {
                    str33 = url;
                }
                if (r21 != 0) {
                    if (r21 != 0) {
                        str34 = null;
                    } else {
                        str34 = null;
                    }
                    if (str34 == null) {
                        if (r21 != 0) {
                            str36 = null;
                        } else {
                            str36 = null;
                        }
                        if (str36 == null) {
                            str35 = str22;
                        } else {
                            str35 = str36;
                        }
                    } else {
                        str35 = str34;
                    }
                } else {
                    if (r21 != 0) {
                        str34 = null;
                    } else {
                        str34 = null;
                    }
                    if (str34 == null) {
                        if (r21 != 0) {
                            str36 = null;
                        } else {
                            str36 = null;
                        }
                        if (str36 == null) {
                            str35 = str22;
                        } else {
                            str35 = str36;
                        }
                    } else {
                        str35 = str34;
                    }
                }
                num16 = (Integer) linkedHashMap.get(Boxing.boxInt(1));
                if (num16 != null) {
                    iIntValue = num16.intValue();
                } else {
                    iIntValue = 0;
                }
                i7 = iIntValue;
                num17 = num8;
                str37 = str22;
                str38 = str30;
                stringData = streamPlayAnime.toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), num13, num15, str22, num17, null, true, null, null, null, str30, null, null, false, false, false, false, Boxing.boxInt(i7), num6, 16633983, null));
                if (list.isEmpty()) {
                    list4 = list;
                    arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                    i18 = 0;
                    while (r37.hasNext()) {
                        int i215 = i18 + 1;
                        if (i18 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ArrayList arrayList1113 = arrayList12;
                        LinkedHashMap linkedHashMap15 = linkedHashMap;
                        StreamPlayKitsuHelper.KitsuVideo kitsuVideo6 = (StreamPlayKitsuHelper.KitsuVideo) obj8;
                        i19 = i18;
                        episode2 = kitsuVideo6.getEpisode();
                        if (episode2 != null) {
                            iIntValue3 = episode2.intValue();
                        } else {
                            iIntValue3 = i19 + 1;
                        }
                        CharSequence charSequence7 = charSequence;
                        List<StreamPlayKitsuHelper.KitsuVideo> list110 = list4;
                        LinkedHashMap linkedHashMap16 = linkedHashMap2;
                        String str414 = str35;
                        arrayList1113.add(loadFromKitsu$createEpisode(linkedHashMap16, streamPlayAnime, linkedHashMap15, num13, num15, str37, num17, str38, num6, str33, str414, iIntValue3, kitsuVideo6, false));
                        streamPlayAnime = this;
                        linkedHashMap = linkedHashMap15;
                        str35 = str414;
                        arrayList12 = arrayList1113;
                        i18 = i215;
                        obj5 = obj5;
                        i7 = i7;
                        i4 = i4;
                        linkedHashMap2 = linkedHashMap16;
                        list4 = list110;
                        charSequence = charSequence7;
                    }
                    ArrayList arrayList1114 = arrayList12;
                    i8 = i7;
                    i9 = i4;
                    linkedHashMap4 = linkedHashMap;
                    charSequence2 = charSequence;
                    num18 = num15;
                    num19 = num17;
                    linkedHashMap3 = linkedHashMap2;
                    str39 = str35;
                    num20 = num13;
                    arrayList2 = arrayList1114;
                    i11 = 10;
                } else {
                    i8 = i7;
                    i9 = i4;
                    linkedHashMap3 = linkedHashMap2;
                    linkedHashMap4 = linkedHashMap;
                    charSequence2 = charSequence;
                    num18 = num15;
                    num19 = num17;
                    i10 = i6;
                    str39 = str35;
                    num20 = num13;
                    intRange2 = new IntRange(1, i10);
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
                    it = intRange2.iterator();
                    while (it.hasNext()) {
                        ArrayList arrayList1115 = arrayList;
                        arrayList1115.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, it.nextInt(), null, false));
                        i10 = i10;
                        arrayList = arrayList1115;
                        intRange2 = intRange2;
                    }
                    i6 = i10;
                    i11 = 10;
                    arrayList2 = arrayList;
                }
                arrayList3 = arrayList2;
                arrayList4 = arrayList3;
                arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, i11));
                i12 = 0;
                while (r32.hasNext()) {
                    int i216 = i12 + 1;
                    if (i12 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    List<StreamPlayKitsuHelper.KitsuVideo> list111 = list;
                    kitsuVideo = (StreamPlayKitsuHelper.KitsuVideo) CollectionsKt.getOrNull(list111, i12);
                    if (kitsuVideo != null) {
                        iIntValue2 = i12 + 1;
                    } else {
                        iIntValue2 = i12 + 1;
                    }
                    list = list111;
                    arrayList5.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, iIntValue2, kitsuVideo, true));
                    i12 = i216;
                    arrayList4 = arrayList4;
                }
                linkedHashMap5 = linkedHashMap3;
                linkedHashMap6 = linkedHashMap4;
                num21 = num6;
                str40 = str33;
                str41 = str39;
                arrayList6 = arrayList5;
                imdbRating = kitsuMeta6.getImdbRating();
                if (imdbRating != null) {
                    iFloatValue = 0;
                } else {
                    iFloatValue = 0;
                }
                links = kitsuMeta6.getLinks();
                if (links != null) {
                    list3 = links;
                    arrayList8 = new ArrayList();
                    while (r10.hasNext()) {
                        ArrayList arrayList1116 = arrayList6;
                        List<StreamPlayKitsuHelper.KitsuLink> list112 = list3;
                        if (StringsKt.equals(((StreamPlayKitsuHelper.KitsuLink) obj10).getCategory(), "Franchise", true)) {
                            arrayList8.add(obj10);
                        }
                        arrayList6 = arrayList1116;
                        list3 = list112;
                    }
                    arrayList7 = arrayList6;
                    arrayList9 = arrayList8;
                    i16 = 0;
                    arrayList10 = new ArrayList();
                    while (r11.hasNext()) {
                        name2 = kitsuLink.getName();
                        if (name2 == null) {
                            arrayList11 = arrayList9;
                            i17 = i16;
                            num24 = num20;
                            num25 = num18;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        } else {
                            arrayList11 = arrayList9;
                            url2 = kitsuLink.getUrl();
                            if (url2 != null) {
                                i17 = i16;
                                num24 = num20;
                                num25 = num18;
                                strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                if (strSubstringAfterLast$default == null) {
                                    animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                }
                            } else {
                                i17 = i16;
                                num24 = num20;
                                num25 = num18;
                            }
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        }
                        if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                            arrayList10.add(animeSearchResponseNewAnimeSearchResponse$default);
                        }
                        arrayList9 = arrayList11;
                        i16 = i17;
                        num20 = num24;
                        num18 = num25;
                    }
                    num22 = num20;
                    num23 = num18;
                    list2 = arrayList10;
                } else {
                    arrayList7 = arrayList6;
                    num22 = num20;
                    num23 = num18;
                    list2 = null;
                }
                i13 = i9;
                if (i13 != 0) {
                    TvType tvType111 = TvType.AnimeMovie;
                    Integer num2113 = num19;
                    C00872 c00876 = new C00872(num22, num23, str20, num2113, kitsuMeta6, str32, url, str18, iFloatValue, null);
                    C00861 c008618 = c00863;
                    c008618.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                    c008618.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                    c008618.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                    c008618.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                    c008618.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                    c008618.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                    c008618.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c008618.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                    c008618.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                    c008618.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                    c008618.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                    c008618.L$11 = SpillingKt.nullOutSpilledVariable(num2113);
                    c008618.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                    c008618.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                    c008618.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                    c008618.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c008618.L$16 = SpillingKt.nullOutSpilledVariable(num22);
                    c008618.L$17 = SpillingKt.nullOutSpilledVariable(num23);
                    c008618.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                    c008618.L$19 = SpillingKt.nullOutSpilledVariable(url);
                    c008618.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                    c008618.L$21 = SpillingKt.nullOutSpilledVariable(list);
                    c008618.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                    c008618.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                    c008618.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                    c008618.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                    c008618.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                    c008618.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c008618.L$28 = SpillingKt.nullOutSpilledVariable(arrayList7);
                    c008618.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                    c008618.I$0 = i13;
                    c008618.I$1 = i6;
                    c008618.I$2 = i8;
                    c008618.I$3 = iFloatValue;
                    c008618.label = 8;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str37, str17, tvType111, stringData, c00876, c008618);
                    obj4 = obj2;
                    if (objNewMovieLoadResponse == obj4) {
                        return obj4;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                Integer num2114 = num19;
                obj3 = obj2;
                C00861 c008619 = c00863;
                Integer num2115 = num22;
                Integer num35 = num23;
                i14 = iFloatValue;
                TvType tvType112 = TvType.Anime;
                ArrayList arrayList1117 = arrayList7;
                C00883 c00887 = new C00883(num2115, num35, str20, arrayList3, arrayList1117, str18, num2114, kitsuMeta6, str32, url, i14, this, list2, null);
                c008619.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                c008619.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                c008619.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                c008619.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                c008619.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                c008619.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                c008619.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                c008619.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                c008619.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                c008619.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                c008619.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                c008619.L$11 = SpillingKt.nullOutSpilledVariable(num2114);
                c008619.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                c008619.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                c008619.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                c008619.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                c008619.L$16 = SpillingKt.nullOutSpilledVariable(num2115);
                c008619.L$17 = SpillingKt.nullOutSpilledVariable(num35);
                c008619.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                c008619.L$19 = SpillingKt.nullOutSpilledVariable(url);
                c008619.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                c008619.L$21 = SpillingKt.nullOutSpilledVariable(list);
                c008619.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                c008619.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                c008619.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                c008619.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                c008619.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                c008619.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                c008619.L$28 = SpillingKt.nullOutSpilledVariable(arrayList1117);
                c008619.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                c008619.I$0 = i13;
                c008619.I$1 = i6;
                c008619.I$2 = i8;
                c008619.I$3 = i14;
                c008619.label = 9;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, str37, str17, tvType112, false, c00887, c008619, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj3) {
                    return obj3;
                }
                str42 = str21;
                str43 = stringData;
                i15 = i14;
                obj5 = objNewAnimeLoadResponse$default;
                return (LoadResponse) obj5;
            case 2:
                str45 = (String) c00864.L$1;
                str44 = (String) c00864.L$0;
                ResultKt.throwOnFailure(obj5);
                meta3 = obj5;
                str3 = null;
                kitsuMeta = (StreamPlayKitsuHelper.KitsuMeta) meta3;
                str4 = str44;
                if (kitsuMeta == null) {
                    throw new Exception("Unable to fetch Kitsu anime metadata for " + str45);
                }
                numericKitsuId = kitsuMeta.getNumericKitsuId();
                if (numericKitsuId != null) {
                    sbAppend = new StringBuilder().append("kitsu_id=").append(numericKitsuId.intValue());
                } else {
                    sbAppend = new StringBuilder().append("anilist_id=").append(str45);
                }
                String string5 = sbAppend.toString();
                Requests app5 = MainActivityKt.getApp();
                String str415 = "https://api.ani.zip/mappings?" + string5;
                c00864.L$0 = str4;
                c00864.L$1 = str45;
                c00864.L$2 = kitsuMeta;
                c00864.L$3 = numericKitsuId;
                c00864.L$4 = SpillingKt.nullOutSpilledVariable(string5);
                c00864.label = 5;
                obj = Requests.get$default(app5, str415, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00864, 4094, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str5 = str4;
                kitsuMeta2 = kitsuMeta;
                text = ((NiceResponse) obj).getText();
                num2 = numericKitsuId;
                str6 = str5;
                kitsuMeta3 = kitsuMeta2;
                if (text != null) {
                    animeData = StreamPlayUtilsKt.parseAnimeData(text);
                } else {
                    r8 = str3;
                }
                if (r8 != 0) {
                    r8 = animeData;
                    r8 = animeData;
                    r8 = animeData;
                    intOrNull = str3;
                } else {
                    r8 = animeData;
                    r8 = animeData;
                    r8 = animeData;
                    intOrNull = str3;
                }
                if (r8 != 0) {
                    if (num2 != null) {
                        strValueOf = String.valueOf(num2.intValue());
                    } else {
                        strValueOf = str3;
                    }
                } else if (num2 != null) {
                    strValueOf = String.valueOf(num2.intValue());
                } else {
                    strValueOf = str3;
                }
                r8 = animeData;
                str7 = strValueOf;
                r85 = intOrNull;
                if (StringsKt.equals(kitsuMeta3.getType(), "movie", true)) {
                    i = 1;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                if (i != 0) {
                    tvType2 = TvType.AnimeMovie;
                } else {
                    tvType2 = TvType.TvSeries;
                }
                tvType3 = tvType2;
                name = kitsuMeta3.getName();
                if (name == null) {
                    aliases = kitsuMeta3.getAliases();
                    if (aliases != null) {
                        name = (String) CollectionsKt.firstOrNull(aliases);
                    } else {
                        name = null;
                    }
                    if (name == null) {
                        name = "Unknown";
                    }
                }
                str8 = name;
                yearInt = kitsuMeta3.getYearInt();
                if (yearInt != null) {
                    tvType4 = tvType;
                } else if (r8 != 0) {
                    tvType4 = tvType;
                    yearInt = null;
                } else {
                    tvType4 = tvType;
                    yearInt = null;
                }
                num3 = yearInt;
                c00864.L$0 = str6;
                c00864.L$1 = str45;
                c00864.L$2 = kitsuMeta3;
                c00864.L$3 = num2;
                c00864.L$4 = text;
                c00864.L$5 = r8;
                c00864.L$6 = SpillingKt.nullOutSpilledVariable((Object) r85);
                c00864.L$7 = str7;
                str9 = text;
                c00864.L$8 = SpillingKt.nullOutSpilledVariable(tvType4);
                c00864.L$9 = tvType3;
                c00864.L$10 = str8;
                c00864.L$11 = num3;
                c00864.I$0 = i;
                c00864.label = 6;
                num4 = num2;
                i2 = i;
                r19 = r8;
                str10 = str6;
                tvType5 = tvType4;
                kitsuMeta4 = kitsuMeta3;
                num5 = null;
                C00861 c0086110 = c00864;
                z = false;
                objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", tvType5, r85, "en", c0086110);
                c00862 = c0086110;
                if (objFetchTmdbLogoUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str11 = str9;
                str12 = str7;
                tvType6 = tvType3;
                str13 = str8;
                num6 = num4;
                i3 = i2;
                num7 = num3;
                str14 = str10;
                tvType7 = tvType5;
                r16 = r85;
                r6 = r19;
                kitsuMeta5 = kitsuMeta4;
                str15 = (String) objFetchTmdbLogoUrl;
                if (r6 != 0) {
                    if (StringsKt.toIntOrNull(str45) != null) {
                        str16 = str45;
                        charSequence = "kitsu:";
                        if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                            intOrNull2 = StringsKt.toIntOrNull(str16);
                        }
                    } else {
                        str16 = str45;
                        charSequence = "kitsu:";
                    }
                    intOrNull2 = num5;
                } else {
                    if (StringsKt.toIntOrNull(str45) != null) {
                        str16 = str45;
                        charSequence = "kitsu:";
                        if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                            intOrNull2 = StringsKt.toIntOrNull(str16);
                        }
                    } else {
                        str16 = str45;
                        charSequence = "kitsu:";
                    }
                    intOrNull2 = num5;
                }
                if (r6 != 0) {
                    malId = num5;
                } else {
                    malId = num5;
                }
                if (malId == null) {
                }
                str17 = str14;
                int i217 = i3;
                Integer num2116 = num7;
                aniIds = new AniIds(intOrNull2, malId);
                str18 = str15;
                tvType8 = tvType6;
                r21 = r6;
                kitsuMeta6 = kitsuMeta5;
                str19 = str11;
                str20 = str12;
                num8 = num2116;
                r23 = r16;
                tvType9 = tvType7;
                i4 = i217;
                str21 = str16;
                num9 = intOrNull2;
                str22 = str13;
                num10 = malId;
                aniIds2 = aniIds;
                id = aniIds2.getId();
                if (id == null) {
                    num13 = num9;
                } else {
                    num13 = id;
                }
                idMal = aniIds2.getIdMal();
                if (idMal == null) {
                    num14 = num10;
                } else {
                    num14 = idMal;
                }
                if (r21 != 0) {
                    if (r21 != 0) {
                        str29 = null;
                    } else {
                        str29 = null;
                    }
                    if (str29 != null) {
                        str30 = str29;
                    } else {
                        aliases2 = kitsuMeta6.getAliases();
                        if (aliases2 != null) {
                            str29 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str29 = null;
                        }
                        if (str29 == null) {
                            str30 = str22;
                        } else {
                            str30 = str29;
                        }
                    }
                } else {
                    if (r21 != 0) {
                        str29 = null;
                    } else {
                        str29 = null;
                    }
                    if (str29 != null) {
                        str30 = str29;
                    } else {
                        aliases2 = kitsuMeta6.getAliases();
                        if (aliases2 != null) {
                            str29 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str29 = null;
                        }
                        if (str29 == null) {
                            str30 = str22;
                        } else {
                            str30 = str29;
                        }
                    }
                }
                poster = kitsuMeta6.getPoster();
                if (poster != null) {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = poster;
                } else if (r21 != 0) {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = null;
                } else {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = null;
                }
                background = kitsuMeta6.getBackground();
                if (background != null) {
                    str31 = background;
                } else {
                    if (r21 != 0) {
                        list6 = images2;
                        it2 = list6.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                next = it2.next();
                                list7 = list6;
                                if (StringsKt.equals(((ImageData) next).getCoverType(), "Fanart", true)) {
                                    list6 = list7;
                                }
                            } else {
                                next = null;
                            }
                        }
                        imageData2 = (ImageData) next;
                        if (imageData2 != null) {
                            background = imageData2.getUrl();
                            str31 = background;
                        }
                    }
                    str31 = null;
                }
                str32 = str31;
                videos = kitsuMeta6.getVideos();
                if (videos == null) {
                    videos = CollectionsKt.emptyList();
                }
                if (!videos.isEmpty()) {
                    size = videos.size();
                } else if (r21 != 0) {
                    size = 1;
                } else {
                    size = 1;
                }
                Iterable intRange8 = new IntRange(1, size);
                linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange8, 10)), 16));
                while (r31.hasNext()) {
                    iIntValue5 = ((Number) obj6).intValue();
                    if (str19 != null) {
                        list5 = videos;
                        Integer anidbEid6 = StreamPlayUtilsKt.getAnidbEid(str19, Boxing.boxInt(iIntValue5));
                        if (anidbEid6 != null) {
                        }
                        linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                        videos = list5;
                    } else {
                        list5 = videos;
                    }
                    linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                    videos = list5;
                }
                list = videos;
                intRange = new IntRange(1, size);
                i5 = 0;
                linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange, 10)), 16));
                while (r27.hasNext()) {
                    Iterable iterable6 = intRange;
                    iIntValue4 = ((Number) obj7).intValue();
                    if (r21 != 0) {
                        i20 = size;
                        episodes3 = r21.getEpisodes();
                        if (episodes3 != null) {
                            i5 = i5;
                            metaEpisode = episodes3.get(String.valueOf(iIntValue4));
                        }
                        linkedHashMap2.put(obj7, metaEpisode);
                        intRange = iterable6;
                        size = i20;
                        i5 = i5;
                    } else {
                        i20 = size;
                    }
                    metaEpisode = null;
                    linkedHashMap2.put(obj7, metaEpisode);
                    intRange = iterable6;
                    size = i20;
                    i5 = i5;
                }
                i6 = size;
                if (url == null) {
                    if (r21 != 0) {
                        url3 = null;
                    } else {
                        url3 = null;
                    }
                    if (url3 == null) {
                        url3 = "";
                    }
                    str33 = url3;
                } else {
                    str33 = url;
                }
                if (r21 != 0) {
                    if (r21 != 0) {
                        str34 = null;
                    } else {
                        str34 = null;
                    }
                    if (str34 == null) {
                        if (r21 != 0) {
                            str36 = null;
                        } else {
                            str36 = null;
                        }
                        if (str36 == null) {
                            str35 = str22;
                        } else {
                            str35 = str36;
                        }
                    } else {
                        str35 = str34;
                    }
                } else {
                    if (r21 != 0) {
                        str34 = null;
                    } else {
                        str34 = null;
                    }
                    if (str34 == null) {
                        if (r21 != 0) {
                            str36 = null;
                        } else {
                            str36 = null;
                        }
                        if (str36 == null) {
                            str35 = str22;
                        } else {
                            str35 = str36;
                        }
                    } else {
                        str35 = str34;
                    }
                }
                num16 = (Integer) linkedHashMap.get(Boxing.boxInt(1));
                if (num16 != null) {
                    iIntValue = num16.intValue();
                } else {
                    iIntValue = 0;
                }
                i7 = iIntValue;
                num17 = num8;
                str37 = str22;
                str38 = str30;
                stringData = streamPlayAnime.toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), num13, num15, str22, num17, null, true, null, null, null, str30, null, null, false, false, false, false, Boxing.boxInt(i7), num6, 16633983, null));
                if (list.isEmpty()) {
                    list4 = list;
                    arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                    i18 = 0;
                    while (r37.hasNext()) {
                        int i218 = i18 + 1;
                        if (i18 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ArrayList arrayList1118 = arrayList12;
                        LinkedHashMap linkedHashMap17 = linkedHashMap;
                        StreamPlayKitsuHelper.KitsuVideo kitsuVideo7 = (StreamPlayKitsuHelper.KitsuVideo) obj8;
                        i19 = i18;
                        episode2 = kitsuVideo7.getEpisode();
                        if (episode2 != null) {
                            iIntValue3 = episode2.intValue();
                        } else {
                            iIntValue3 = i19 + 1;
                        }
                        CharSequence charSequence8 = charSequence;
                        List<StreamPlayKitsuHelper.KitsuVideo> list113 = list4;
                        LinkedHashMap linkedHashMap18 = linkedHashMap2;
                        String str416 = str35;
                        arrayList1118.add(loadFromKitsu$createEpisode(linkedHashMap18, streamPlayAnime, linkedHashMap17, num13, num15, str37, num17, str38, num6, str33, str416, iIntValue3, kitsuVideo7, false));
                        streamPlayAnime = this;
                        linkedHashMap = linkedHashMap17;
                        str35 = str416;
                        arrayList12 = arrayList1118;
                        i18 = i218;
                        obj5 = obj5;
                        i7 = i7;
                        i4 = i4;
                        linkedHashMap2 = linkedHashMap18;
                        list4 = list113;
                        charSequence = charSequence8;
                    }
                    ArrayList arrayList1119 = arrayList12;
                    i8 = i7;
                    i9 = i4;
                    linkedHashMap4 = linkedHashMap;
                    charSequence2 = charSequence;
                    num18 = num15;
                    num19 = num17;
                    linkedHashMap3 = linkedHashMap2;
                    str39 = str35;
                    num20 = num13;
                    arrayList2 = arrayList1119;
                    i11 = 10;
                } else {
                    i8 = i7;
                    i9 = i4;
                    linkedHashMap3 = linkedHashMap2;
                    linkedHashMap4 = linkedHashMap;
                    charSequence2 = charSequence;
                    num18 = num15;
                    num19 = num17;
                    i10 = i6;
                    str39 = str35;
                    num20 = num13;
                    intRange2 = new IntRange(1, i10);
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
                    it = intRange2.iterator();
                    while (it.hasNext()) {
                        ArrayList arrayList11110 = arrayList;
                        arrayList11110.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, it.nextInt(), null, false));
                        i10 = i10;
                        arrayList = arrayList11110;
                        intRange2 = intRange2;
                    }
                    i6 = i10;
                    i11 = 10;
                    arrayList2 = arrayList;
                }
                arrayList3 = arrayList2;
                arrayList4 = arrayList3;
                arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, i11));
                i12 = 0;
                while (r32.hasNext()) {
                    int i219 = i12 + 1;
                    if (i12 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    List<StreamPlayKitsuHelper.KitsuVideo> list114 = list;
                    kitsuVideo = (StreamPlayKitsuHelper.KitsuVideo) CollectionsKt.getOrNull(list114, i12);
                    if (kitsuVideo != null) {
                        iIntValue2 = i12 + 1;
                    } else {
                        iIntValue2 = i12 + 1;
                    }
                    list = list114;
                    arrayList5.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, iIntValue2, kitsuVideo, true));
                    i12 = i219;
                    arrayList4 = arrayList4;
                }
                linkedHashMap5 = linkedHashMap3;
                linkedHashMap6 = linkedHashMap4;
                num21 = num6;
                str40 = str33;
                str41 = str39;
                arrayList6 = arrayList5;
                imdbRating = kitsuMeta6.getImdbRating();
                if (imdbRating != null) {
                    iFloatValue = 0;
                } else {
                    iFloatValue = 0;
                }
                links = kitsuMeta6.getLinks();
                if (links != null) {
                    list3 = links;
                    arrayList8 = new ArrayList();
                    while (r10.hasNext()) {
                        ArrayList arrayList11111 = arrayList6;
                        List<StreamPlayKitsuHelper.KitsuLink> list115 = list3;
                        if (StringsKt.equals(((StreamPlayKitsuHelper.KitsuLink) obj10).getCategory(), "Franchise", true)) {
                            arrayList8.add(obj10);
                        }
                        arrayList6 = arrayList11111;
                        list3 = list115;
                    }
                    arrayList7 = arrayList6;
                    arrayList9 = arrayList8;
                    i16 = 0;
                    arrayList10 = new ArrayList();
                    while (r11.hasNext()) {
                        name2 = kitsuLink.getName();
                        if (name2 == null) {
                            arrayList11 = arrayList9;
                            i17 = i16;
                            num24 = num20;
                            num25 = num18;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        } else {
                            arrayList11 = arrayList9;
                            url2 = kitsuLink.getUrl();
                            if (url2 != null) {
                                i17 = i16;
                                num24 = num20;
                                num25 = num18;
                                strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                if (strSubstringAfterLast$default == null) {
                                    animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                }
                            } else {
                                i17 = i16;
                                num24 = num20;
                                num25 = num18;
                            }
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        }
                        if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                            arrayList10.add(animeSearchResponseNewAnimeSearchResponse$default);
                        }
                        arrayList9 = arrayList11;
                        i16 = i17;
                        num20 = num24;
                        num18 = num25;
                    }
                    num22 = num20;
                    num23 = num18;
                    list2 = arrayList10;
                } else {
                    arrayList7 = arrayList6;
                    num22 = num20;
                    num23 = num18;
                    list2 = null;
                }
                i13 = i9;
                if (i13 != 0) {
                    TvType tvType113 = TvType.AnimeMovie;
                    Integer num2117 = num19;
                    C00872 c00877 = new C00872(num22, num23, str20, num2117, kitsuMeta6, str32, url, str18, iFloatValue, null);
                    C00861 c0086111 = c00863;
                    c0086111.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                    c0086111.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                    c0086111.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                    c0086111.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                    c0086111.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                    c0086111.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                    c0086111.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c0086111.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                    c0086111.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                    c0086111.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                    c0086111.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                    c0086111.L$11 = SpillingKt.nullOutSpilledVariable(num2117);
                    c0086111.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                    c0086111.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                    c0086111.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                    c0086111.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c0086111.L$16 = SpillingKt.nullOutSpilledVariable(num22);
                    c0086111.L$17 = SpillingKt.nullOutSpilledVariable(num23);
                    c0086111.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                    c0086111.L$19 = SpillingKt.nullOutSpilledVariable(url);
                    c0086111.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                    c0086111.L$21 = SpillingKt.nullOutSpilledVariable(list);
                    c0086111.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                    c0086111.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                    c0086111.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                    c0086111.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                    c0086111.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                    c0086111.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c0086111.L$28 = SpillingKt.nullOutSpilledVariable(arrayList7);
                    c0086111.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                    c0086111.I$0 = i13;
                    c0086111.I$1 = i6;
                    c0086111.I$2 = i8;
                    c0086111.I$3 = iFloatValue;
                    c0086111.label = 8;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str37, str17, tvType113, stringData, c00877, c0086111);
                    obj4 = obj2;
                    if (objNewMovieLoadResponse == obj4) {
                        return obj4;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                Integer num2118 = num19;
                obj3 = obj2;
                C00861 c0086112 = c00863;
                Integer num2119 = num22;
                Integer num36 = num23;
                i14 = iFloatValue;
                TvType tvType114 = TvType.Anime;
                ArrayList arrayList11112 = arrayList7;
                C00883 c00888 = new C00883(num2119, num36, str20, arrayList3, arrayList11112, str18, num2118, kitsuMeta6, str32, url, i14, this, list2, null);
                c0086112.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                c0086112.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                c0086112.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                c0086112.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                c0086112.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                c0086112.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                c0086112.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                c0086112.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                c0086112.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                c0086112.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                c0086112.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                c0086112.L$11 = SpillingKt.nullOutSpilledVariable(num2118);
                c0086112.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                c0086112.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                c0086112.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                c0086112.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                c0086112.L$16 = SpillingKt.nullOutSpilledVariable(num2119);
                c0086112.L$17 = SpillingKt.nullOutSpilledVariable(num36);
                c0086112.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                c0086112.L$19 = SpillingKt.nullOutSpilledVariable(url);
                c0086112.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                c0086112.L$21 = SpillingKt.nullOutSpilledVariable(list);
                c0086112.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                c0086112.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                c0086112.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                c0086112.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                c0086112.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                c0086112.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                c0086112.L$28 = SpillingKt.nullOutSpilledVariable(arrayList11112);
                c0086112.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                c0086112.I$0 = i13;
                c0086112.I$1 = i6;
                c0086112.I$2 = i8;
                c0086112.I$3 = i14;
                c0086112.label = 9;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, str37, str17, tvType114, false, c00888, c0086112, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj3) {
                    return obj3;
                }
                str42 = str21;
                str43 = stringData;
                i15 = i14;
                obj5 = objNewAnimeLoadResponse$default;
                return (LoadResponse) obj5;
            case 3:
                str45 = (String) c00864.L$1;
                str44 = (String) c00864.L$0;
                ResultKt.throwOnFailure(obj5);
                meta2 = obj5;
                str3 = null;
                kitsuMeta = (StreamPlayKitsuHelper.KitsuMeta) meta2;
                if (kitsuMeta == null) {
                    c00864.L$0 = str44;
                    c00864.L$1 = str45;
                    c00864.label = 4;
                    meta4 = StreamPlayKitsuHelper.INSTANCE.getMeta("kitsu:" + str45, c00864);
                    if (meta4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    kitsuMeta = (StreamPlayKitsuHelper.KitsuMeta) meta4;
                    str4 = str44;
                } else {
                    str4 = str44;
                }
                if (kitsuMeta == null) {
                    throw new Exception("Unable to fetch Kitsu anime metadata for " + str45);
                }
                numericKitsuId = kitsuMeta.getNumericKitsuId();
                if (numericKitsuId != null) {
                    sbAppend = new StringBuilder().append("kitsu_id=").append(numericKitsuId.intValue());
                } else {
                    sbAppend = new StringBuilder().append("anilist_id=").append(str45);
                }
                String string6 = sbAppend.toString();
                Requests app6 = MainActivityKt.getApp();
                String str417 = "https://api.ani.zip/mappings?" + string6;
                c00864.L$0 = str4;
                c00864.L$1 = str45;
                c00864.L$2 = kitsuMeta;
                c00864.L$3 = numericKitsuId;
                c00864.L$4 = SpillingKt.nullOutSpilledVariable(string6);
                c00864.label = 5;
                obj = Requests.get$default(app6, str417, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00864, 4094, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str5 = str4;
                kitsuMeta2 = kitsuMeta;
                text = ((NiceResponse) obj).getText();
                num2 = numericKitsuId;
                str6 = str5;
                kitsuMeta3 = kitsuMeta2;
                if (text != null) {
                    animeData = StreamPlayUtilsKt.parseAnimeData(text);
                } else {
                    r8 = str3;
                }
                if (r8 != 0) {
                    r8 = animeData;
                    r8 = animeData;
                    r8 = animeData;
                    intOrNull = str3;
                } else {
                    r8 = animeData;
                    r8 = animeData;
                    r8 = animeData;
                    intOrNull = str3;
                }
                if (r8 != 0) {
                    if (num2 != null) {
                        strValueOf = String.valueOf(num2.intValue());
                    } else {
                        strValueOf = str3;
                    }
                } else if (num2 != null) {
                    strValueOf = String.valueOf(num2.intValue());
                } else {
                    strValueOf = str3;
                }
                r8 = animeData;
                str7 = strValueOf;
                r85 = intOrNull;
                if (StringsKt.equals(kitsuMeta3.getType(), "movie", true)) {
                    i = 1;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                if (i != 0) {
                    tvType2 = TvType.AnimeMovie;
                } else {
                    tvType2 = TvType.TvSeries;
                }
                tvType3 = tvType2;
                name = kitsuMeta3.getName();
                if (name == null) {
                    aliases = kitsuMeta3.getAliases();
                    if (aliases != null) {
                        name = (String) CollectionsKt.firstOrNull(aliases);
                    } else {
                        name = null;
                    }
                    if (name == null) {
                        name = "Unknown";
                    }
                }
                str8 = name;
                yearInt = kitsuMeta3.getYearInt();
                if (yearInt != null) {
                    tvType4 = tvType;
                } else if (r8 != 0) {
                    tvType4 = tvType;
                    yearInt = null;
                } else {
                    tvType4 = tvType;
                    yearInt = null;
                }
                num3 = yearInt;
                c00864.L$0 = str6;
                c00864.L$1 = str45;
                c00864.L$2 = kitsuMeta3;
                c00864.L$3 = num2;
                c00864.L$4 = text;
                c00864.L$5 = r8;
                c00864.L$6 = SpillingKt.nullOutSpilledVariable((Object) r85);
                c00864.L$7 = str7;
                str9 = text;
                c00864.L$8 = SpillingKt.nullOutSpilledVariable(tvType4);
                c00864.L$9 = tvType3;
                c00864.L$10 = str8;
                c00864.L$11 = num3;
                c00864.I$0 = i;
                c00864.label = 6;
                num4 = num2;
                i2 = i;
                r19 = r8;
                str10 = str6;
                tvType5 = tvType4;
                kitsuMeta4 = kitsuMeta3;
                num5 = null;
                C00861 c0086113 = c00864;
                z = false;
                objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", tvType5, r85, "en", c0086113);
                c00862 = c0086113;
                if (objFetchTmdbLogoUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str11 = str9;
                str12 = str7;
                tvType6 = tvType3;
                str13 = str8;
                num6 = num4;
                i3 = i2;
                num7 = num3;
                str14 = str10;
                tvType7 = tvType5;
                r16 = r85;
                r6 = r19;
                kitsuMeta5 = kitsuMeta4;
                str15 = (String) objFetchTmdbLogoUrl;
                if (r6 != 0) {
                    if (StringsKt.toIntOrNull(str45) != null) {
                        str16 = str45;
                        charSequence = "kitsu:";
                        if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                            intOrNull2 = StringsKt.toIntOrNull(str16);
                        }
                    } else {
                        str16 = str45;
                        charSequence = "kitsu:";
                    }
                    intOrNull2 = num5;
                } else {
                    if (StringsKt.toIntOrNull(str45) != null) {
                        str16 = str45;
                        charSequence = "kitsu:";
                        if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                            intOrNull2 = StringsKt.toIntOrNull(str16);
                        }
                    } else {
                        str16 = str45;
                        charSequence = "kitsu:";
                    }
                    intOrNull2 = num5;
                }
                if (r6 != 0) {
                    malId = num5;
                } else {
                    malId = num5;
                }
                if (malId == null) {
                }
                str17 = str14;
                int i2110 = i3;
                Integer num21110 = num7;
                aniIds = new AniIds(intOrNull2, malId);
                str18 = str15;
                tvType8 = tvType6;
                r21 = r6;
                kitsuMeta6 = kitsuMeta5;
                str19 = str11;
                str20 = str12;
                num8 = num21110;
                r23 = r16;
                tvType9 = tvType7;
                i4 = i2110;
                str21 = str16;
                num9 = intOrNull2;
                str22 = str13;
                num10 = malId;
                aniIds2 = aniIds;
                id = aniIds2.getId();
                if (id == null) {
                    num13 = num9;
                } else {
                    num13 = id;
                }
                idMal = aniIds2.getIdMal();
                if (idMal == null) {
                    num14 = num10;
                } else {
                    num14 = idMal;
                }
                if (r21 != 0) {
                    if (r21 != 0) {
                        str29 = null;
                    } else {
                        str29 = null;
                    }
                    if (str29 != null) {
                        str30 = str29;
                    } else {
                        aliases2 = kitsuMeta6.getAliases();
                        if (aliases2 != null) {
                            str29 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str29 = null;
                        }
                        if (str29 == null) {
                            str30 = str22;
                        } else {
                            str30 = str29;
                        }
                    }
                } else {
                    if (r21 != 0) {
                        str29 = null;
                    } else {
                        str29 = null;
                    }
                    if (str29 != null) {
                        str30 = str29;
                    } else {
                        aliases2 = kitsuMeta6.getAliases();
                        if (aliases2 != null) {
                            str29 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str29 = null;
                        }
                        if (str29 == null) {
                            str30 = str22;
                        } else {
                            str30 = str29;
                        }
                    }
                }
                poster = kitsuMeta6.getPoster();
                if (poster != null) {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = poster;
                } else if (r21 != 0) {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = null;
                } else {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = null;
                }
                background = kitsuMeta6.getBackground();
                if (background != null) {
                    str31 = background;
                } else {
                    if (r21 != 0) {
                        list6 = images2;
                        it2 = list6.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                next = it2.next();
                                list7 = list6;
                                if (StringsKt.equals(((ImageData) next).getCoverType(), "Fanart", true)) {
                                    list6 = list7;
                                }
                            } else {
                                next = null;
                            }
                        }
                        imageData2 = (ImageData) next;
                        if (imageData2 != null) {
                            background = imageData2.getUrl();
                            str31 = background;
                        }
                    }
                    str31 = null;
                }
                str32 = str31;
                videos = kitsuMeta6.getVideos();
                if (videos == null) {
                    videos = CollectionsKt.emptyList();
                }
                if (!videos.isEmpty()) {
                    size = videos.size();
                } else if (r21 != 0) {
                    size = 1;
                } else {
                    size = 1;
                }
                Iterable intRange9 = new IntRange(1, size);
                linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange9, 10)), 16));
                while (r31.hasNext()) {
                    iIntValue5 = ((Number) obj6).intValue();
                    if (str19 != null) {
                        list5 = videos;
                        Integer anidbEid7 = StreamPlayUtilsKt.getAnidbEid(str19, Boxing.boxInt(iIntValue5));
                        if (anidbEid7 != null) {
                        }
                        linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                        videos = list5;
                    } else {
                        list5 = videos;
                    }
                    linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                    videos = list5;
                }
                list = videos;
                intRange = new IntRange(1, size);
                i5 = 0;
                linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange, 10)), 16));
                while (r27.hasNext()) {
                    Iterable iterable7 = intRange;
                    iIntValue4 = ((Number) obj7).intValue();
                    if (r21 != 0) {
                        i20 = size;
                        episodes3 = r21.getEpisodes();
                        if (episodes3 != null) {
                            i5 = i5;
                            metaEpisode = episodes3.get(String.valueOf(iIntValue4));
                        }
                        linkedHashMap2.put(obj7, metaEpisode);
                        intRange = iterable7;
                        size = i20;
                        i5 = i5;
                    } else {
                        i20 = size;
                    }
                    metaEpisode = null;
                    linkedHashMap2.put(obj7, metaEpisode);
                    intRange = iterable7;
                    size = i20;
                    i5 = i5;
                }
                i6 = size;
                if (url == null) {
                    if (r21 != 0) {
                        url3 = null;
                    } else {
                        url3 = null;
                    }
                    if (url3 == null) {
                        url3 = "";
                    }
                    str33 = url3;
                } else {
                    str33 = url;
                }
                if (r21 != 0) {
                    if (r21 != 0) {
                        str34 = null;
                    } else {
                        str34 = null;
                    }
                    if (str34 == null) {
                        if (r21 != 0) {
                            str36 = null;
                        } else {
                            str36 = null;
                        }
                        if (str36 == null) {
                            str35 = str22;
                        } else {
                            str35 = str36;
                        }
                    } else {
                        str35 = str34;
                    }
                } else {
                    if (r21 != 0) {
                        str34 = null;
                    } else {
                        str34 = null;
                    }
                    if (str34 == null) {
                        if (r21 != 0) {
                            str36 = null;
                        } else {
                            str36 = null;
                        }
                        if (str36 == null) {
                            str35 = str22;
                        } else {
                            str35 = str36;
                        }
                    } else {
                        str35 = str34;
                    }
                }
                num16 = (Integer) linkedHashMap.get(Boxing.boxInt(1));
                if (num16 != null) {
                    iIntValue = num16.intValue();
                } else {
                    iIntValue = 0;
                }
                i7 = iIntValue;
                num17 = num8;
                str37 = str22;
                str38 = str30;
                stringData = streamPlayAnime.toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), num13, num15, str22, num17, null, true, null, null, null, str30, null, null, false, false, false, false, Boxing.boxInt(i7), num6, 16633983, null));
                if (list.isEmpty()) {
                    list4 = list;
                    arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                    i18 = 0;
                    while (r37.hasNext()) {
                        int i2111 = i18 + 1;
                        if (i18 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ArrayList arrayList11113 = arrayList12;
                        LinkedHashMap linkedHashMap19 = linkedHashMap;
                        StreamPlayKitsuHelper.KitsuVideo kitsuVideo8 = (StreamPlayKitsuHelper.KitsuVideo) obj8;
                        i19 = i18;
                        episode2 = kitsuVideo8.getEpisode();
                        if (episode2 != null) {
                            iIntValue3 = episode2.intValue();
                        } else {
                            iIntValue3 = i19 + 1;
                        }
                        CharSequence charSequence9 = charSequence;
                        List<StreamPlayKitsuHelper.KitsuVideo> list116 = list4;
                        LinkedHashMap linkedHashMap110 = linkedHashMap2;
                        String str418 = str35;
                        arrayList11113.add(loadFromKitsu$createEpisode(linkedHashMap110, streamPlayAnime, linkedHashMap19, num13, num15, str37, num17, str38, num6, str33, str418, iIntValue3, kitsuVideo8, false));
                        streamPlayAnime = this;
                        linkedHashMap = linkedHashMap19;
                        str35 = str418;
                        arrayList12 = arrayList11113;
                        i18 = i2111;
                        obj5 = obj5;
                        i7 = i7;
                        i4 = i4;
                        linkedHashMap2 = linkedHashMap110;
                        list4 = list116;
                        charSequence = charSequence9;
                    }
                    ArrayList arrayList11114 = arrayList12;
                    i8 = i7;
                    i9 = i4;
                    linkedHashMap4 = linkedHashMap;
                    charSequence2 = charSequence;
                    num18 = num15;
                    num19 = num17;
                    linkedHashMap3 = linkedHashMap2;
                    str39 = str35;
                    num20 = num13;
                    arrayList2 = arrayList11114;
                    i11 = 10;
                } else {
                    i8 = i7;
                    i9 = i4;
                    linkedHashMap3 = linkedHashMap2;
                    linkedHashMap4 = linkedHashMap;
                    charSequence2 = charSequence;
                    num18 = num15;
                    num19 = num17;
                    i10 = i6;
                    str39 = str35;
                    num20 = num13;
                    intRange2 = new IntRange(1, i10);
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
                    it = intRange2.iterator();
                    while (it.hasNext()) {
                        ArrayList arrayList11115 = arrayList;
                        arrayList11115.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, it.nextInt(), null, false));
                        i10 = i10;
                        arrayList = arrayList11115;
                        intRange2 = intRange2;
                    }
                    i6 = i10;
                    i11 = 10;
                    arrayList2 = arrayList;
                }
                arrayList3 = arrayList2;
                arrayList4 = arrayList3;
                arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, i11));
                i12 = 0;
                while (r32.hasNext()) {
                    int i2112 = i12 + 1;
                    if (i12 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    List<StreamPlayKitsuHelper.KitsuVideo> list117 = list;
                    kitsuVideo = (StreamPlayKitsuHelper.KitsuVideo) CollectionsKt.getOrNull(list117, i12);
                    if (kitsuVideo != null) {
                        iIntValue2 = i12 + 1;
                    } else {
                        iIntValue2 = i12 + 1;
                    }
                    list = list117;
                    arrayList5.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, iIntValue2, kitsuVideo, true));
                    i12 = i2112;
                    arrayList4 = arrayList4;
                }
                linkedHashMap5 = linkedHashMap3;
                linkedHashMap6 = linkedHashMap4;
                num21 = num6;
                str40 = str33;
                str41 = str39;
                arrayList6 = arrayList5;
                imdbRating = kitsuMeta6.getImdbRating();
                if (imdbRating != null) {
                    iFloatValue = 0;
                } else {
                    iFloatValue = 0;
                }
                links = kitsuMeta6.getLinks();
                if (links != null) {
                    list3 = links;
                    arrayList8 = new ArrayList();
                    while (r10.hasNext()) {
                        ArrayList arrayList11116 = arrayList6;
                        List<StreamPlayKitsuHelper.KitsuLink> list118 = list3;
                        if (StringsKt.equals(((StreamPlayKitsuHelper.KitsuLink) obj10).getCategory(), "Franchise", true)) {
                            arrayList8.add(obj10);
                        }
                        arrayList6 = arrayList11116;
                        list3 = list118;
                    }
                    arrayList7 = arrayList6;
                    arrayList9 = arrayList8;
                    i16 = 0;
                    arrayList10 = new ArrayList();
                    while (r11.hasNext()) {
                        name2 = kitsuLink.getName();
                        if (name2 == null) {
                            arrayList11 = arrayList9;
                            i17 = i16;
                            num24 = num20;
                            num25 = num18;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        } else {
                            arrayList11 = arrayList9;
                            url2 = kitsuLink.getUrl();
                            if (url2 != null) {
                                i17 = i16;
                                num24 = num20;
                                num25 = num18;
                                strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                if (strSubstringAfterLast$default == null) {
                                    animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                }
                            } else {
                                i17 = i16;
                                num24 = num20;
                                num25 = num18;
                            }
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        }
                        if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                            arrayList10.add(animeSearchResponseNewAnimeSearchResponse$default);
                        }
                        arrayList9 = arrayList11;
                        i16 = i17;
                        num20 = num24;
                        num18 = num25;
                    }
                    num22 = num20;
                    num23 = num18;
                    list2 = arrayList10;
                } else {
                    arrayList7 = arrayList6;
                    num22 = num20;
                    num23 = num18;
                    list2 = null;
                }
                i13 = i9;
                if (i13 != 0) {
                    TvType tvType115 = TvType.AnimeMovie;
                    Integer num21111 = num19;
                    C00872 c00878 = new C00872(num22, num23, str20, num21111, kitsuMeta6, str32, url, str18, iFloatValue, null);
                    C00861 c0086114 = c00863;
                    c0086114.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                    c0086114.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                    c0086114.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                    c0086114.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                    c0086114.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                    c0086114.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                    c0086114.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c0086114.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                    c0086114.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                    c0086114.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                    c0086114.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                    c0086114.L$11 = SpillingKt.nullOutSpilledVariable(num21111);
                    c0086114.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                    c0086114.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                    c0086114.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                    c0086114.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c0086114.L$16 = SpillingKt.nullOutSpilledVariable(num22);
                    c0086114.L$17 = SpillingKt.nullOutSpilledVariable(num23);
                    c0086114.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                    c0086114.L$19 = SpillingKt.nullOutSpilledVariable(url);
                    c0086114.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                    c0086114.L$21 = SpillingKt.nullOutSpilledVariable(list);
                    c0086114.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                    c0086114.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                    c0086114.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                    c0086114.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                    c0086114.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                    c0086114.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c0086114.L$28 = SpillingKt.nullOutSpilledVariable(arrayList7);
                    c0086114.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                    c0086114.I$0 = i13;
                    c0086114.I$1 = i6;
                    c0086114.I$2 = i8;
                    c0086114.I$3 = iFloatValue;
                    c0086114.label = 8;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str37, str17, tvType115, stringData, c00878, c0086114);
                    obj4 = obj2;
                    if (objNewMovieLoadResponse == obj4) {
                        return obj4;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                Integer num21112 = num19;
                obj3 = obj2;
                C00861 c0086115 = c00863;
                Integer num21113 = num22;
                Integer num37 = num23;
                i14 = iFloatValue;
                TvType tvType116 = TvType.Anime;
                ArrayList arrayList11117 = arrayList7;
                C00883 c00889 = new C00883(num21113, num37, str20, arrayList3, arrayList11117, str18, num21112, kitsuMeta6, str32, url, i14, this, list2, null);
                c0086115.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                c0086115.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                c0086115.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                c0086115.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                c0086115.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                c0086115.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                c0086115.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                c0086115.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                c0086115.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                c0086115.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                c0086115.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                c0086115.L$11 = SpillingKt.nullOutSpilledVariable(num21112);
                c0086115.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                c0086115.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                c0086115.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                c0086115.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                c0086115.L$16 = SpillingKt.nullOutSpilledVariable(num21113);
                c0086115.L$17 = SpillingKt.nullOutSpilledVariable(num37);
                c0086115.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                c0086115.L$19 = SpillingKt.nullOutSpilledVariable(url);
                c0086115.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                c0086115.L$21 = SpillingKt.nullOutSpilledVariable(list);
                c0086115.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                c0086115.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                c0086115.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                c0086115.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                c0086115.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                c0086115.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                c0086115.L$28 = SpillingKt.nullOutSpilledVariable(arrayList11117);
                c0086115.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                c0086115.I$0 = i13;
                c0086115.I$1 = i6;
                c0086115.I$2 = i8;
                c0086115.I$3 = i14;
                c0086115.label = 9;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, str37, str17, tvType116, false, c00889, c0086115, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj3) {
                    return obj3;
                }
                str42 = str21;
                str43 = stringData;
                i15 = i14;
                obj5 = objNewAnimeLoadResponse$default;
                return (LoadResponse) obj5;
            case 4:
                str45 = (String) c00864.L$1;
                str44 = (String) c00864.L$0;
                ResultKt.throwOnFailure(obj5);
                meta4 = obj5;
                str3 = null;
                kitsuMeta = (StreamPlayKitsuHelper.KitsuMeta) meta4;
                str4 = str44;
                if (kitsuMeta == null) {
                    throw new Exception("Unable to fetch Kitsu anime metadata for " + str45);
                }
                numericKitsuId = kitsuMeta.getNumericKitsuId();
                if (numericKitsuId != null) {
                    sbAppend = new StringBuilder().append("kitsu_id=").append(numericKitsuId.intValue());
                } else {
                    sbAppend = new StringBuilder().append("anilist_id=").append(str45);
                }
                String string7 = sbAppend.toString();
                Requests app7 = MainActivityKt.getApp();
                String str419 = "https://api.ani.zip/mappings?" + string7;
                c00864.L$0 = str4;
                c00864.L$1 = str45;
                c00864.L$2 = kitsuMeta;
                c00864.L$3 = numericKitsuId;
                c00864.L$4 = SpillingKt.nullOutSpilledVariable(string7);
                c00864.label = 5;
                obj = Requests.get$default(app7, str419, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00864, 4094, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str5 = str4;
                kitsuMeta2 = kitsuMeta;
                text = ((NiceResponse) obj).getText();
                num2 = numericKitsuId;
                str6 = str5;
                kitsuMeta3 = kitsuMeta2;
                if (text != null) {
                    animeData = StreamPlayUtilsKt.parseAnimeData(text);
                } else {
                    r8 = str3;
                }
                if (r8 != 0) {
                    r8 = animeData;
                    r8 = animeData;
                    r8 = animeData;
                    intOrNull = str3;
                } else {
                    r8 = animeData;
                    r8 = animeData;
                    r8 = animeData;
                    intOrNull = str3;
                }
                if (r8 != 0) {
                    if (num2 != null) {
                        strValueOf = String.valueOf(num2.intValue());
                    } else {
                        strValueOf = str3;
                    }
                } else if (num2 != null) {
                    strValueOf = String.valueOf(num2.intValue());
                } else {
                    strValueOf = str3;
                }
                r8 = animeData;
                str7 = strValueOf;
                r85 = intOrNull;
                if (StringsKt.equals(kitsuMeta3.getType(), "movie", true)) {
                    i = 1;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                if (i != 0) {
                    tvType2 = TvType.AnimeMovie;
                } else {
                    tvType2 = TvType.TvSeries;
                }
                tvType3 = tvType2;
                name = kitsuMeta3.getName();
                if (name == null) {
                    aliases = kitsuMeta3.getAliases();
                    if (aliases != null) {
                        name = (String) CollectionsKt.firstOrNull(aliases);
                    } else {
                        name = null;
                    }
                    if (name == null) {
                        name = "Unknown";
                    }
                }
                str8 = name;
                yearInt = kitsuMeta3.getYearInt();
                if (yearInt != null) {
                    tvType4 = tvType;
                } else if (r8 != 0) {
                    tvType4 = tvType;
                    yearInt = null;
                } else {
                    tvType4 = tvType;
                    yearInt = null;
                }
                num3 = yearInt;
                c00864.L$0 = str6;
                c00864.L$1 = str45;
                c00864.L$2 = kitsuMeta3;
                c00864.L$3 = num2;
                c00864.L$4 = text;
                c00864.L$5 = r8;
                c00864.L$6 = SpillingKt.nullOutSpilledVariable((Object) r85);
                c00864.L$7 = str7;
                str9 = text;
                c00864.L$8 = SpillingKt.nullOutSpilledVariable(tvType4);
                c00864.L$9 = tvType3;
                c00864.L$10 = str8;
                c00864.L$11 = num3;
                c00864.I$0 = i;
                c00864.label = 6;
                num4 = num2;
                i2 = i;
                r19 = r8;
                str10 = str6;
                tvType5 = tvType4;
                kitsuMeta4 = kitsuMeta3;
                num5 = null;
                C00861 c0086116 = c00864;
                z = false;
                objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", tvType5, r85, "en", c0086116);
                c00862 = c0086116;
                if (objFetchTmdbLogoUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str11 = str9;
                str12 = str7;
                tvType6 = tvType3;
                str13 = str8;
                num6 = num4;
                i3 = i2;
                num7 = num3;
                str14 = str10;
                tvType7 = tvType5;
                r16 = r85;
                r6 = r19;
                kitsuMeta5 = kitsuMeta4;
                str15 = (String) objFetchTmdbLogoUrl;
                if (r6 != 0) {
                    if (StringsKt.toIntOrNull(str45) != null) {
                        str16 = str45;
                        charSequence = "kitsu:";
                        if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                            intOrNull2 = StringsKt.toIntOrNull(str16);
                        }
                    } else {
                        str16 = str45;
                        charSequence = "kitsu:";
                    }
                    intOrNull2 = num5;
                } else {
                    if (StringsKt.toIntOrNull(str45) != null) {
                        str16 = str45;
                        charSequence = "kitsu:";
                        if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                            intOrNull2 = StringsKt.toIntOrNull(str16);
                        }
                    } else {
                        str16 = str45;
                        charSequence = "kitsu:";
                    }
                    intOrNull2 = num5;
                }
                if (r6 != 0) {
                    malId = num5;
                } else {
                    malId = num5;
                }
                if (malId == null) {
                }
                str17 = str14;
                int i2113 = i3;
                Integer num21114 = num7;
                aniIds = new AniIds(intOrNull2, malId);
                str18 = str15;
                tvType8 = tvType6;
                r21 = r6;
                kitsuMeta6 = kitsuMeta5;
                str19 = str11;
                str20 = str12;
                num8 = num21114;
                r23 = r16;
                tvType9 = tvType7;
                i4 = i2113;
                str21 = str16;
                num9 = intOrNull2;
                str22 = str13;
                num10 = malId;
                aniIds2 = aniIds;
                id = aniIds2.getId();
                if (id == null) {
                    num13 = num9;
                } else {
                    num13 = id;
                }
                idMal = aniIds2.getIdMal();
                if (idMal == null) {
                    num14 = num10;
                } else {
                    num14 = idMal;
                }
                if (r21 != 0) {
                    if (r21 != 0) {
                        str29 = null;
                    } else {
                        str29 = null;
                    }
                    if (str29 != null) {
                        str30 = str29;
                    } else {
                        aliases2 = kitsuMeta6.getAliases();
                        if (aliases2 != null) {
                            str29 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str29 = null;
                        }
                        if (str29 == null) {
                            str30 = str22;
                        } else {
                            str30 = str29;
                        }
                    }
                } else {
                    if (r21 != 0) {
                        str29 = null;
                    } else {
                        str29 = null;
                    }
                    if (str29 != null) {
                        str30 = str29;
                    } else {
                        aliases2 = kitsuMeta6.getAliases();
                        if (aliases2 != null) {
                            str29 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str29 = null;
                        }
                        if (str29 == null) {
                            str30 = str22;
                        } else {
                            str30 = str29;
                        }
                    }
                }
                poster = kitsuMeta6.getPoster();
                if (poster != null) {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = poster;
                } else if (r21 != 0) {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = null;
                } else {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = null;
                }
                background = kitsuMeta6.getBackground();
                if (background != null) {
                    str31 = background;
                } else {
                    if (r21 != 0) {
                        list6 = images2;
                        it2 = list6.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                next = it2.next();
                                list7 = list6;
                                if (StringsKt.equals(((ImageData) next).getCoverType(), "Fanart", true)) {
                                    list6 = list7;
                                }
                            } else {
                                next = null;
                            }
                        }
                        imageData2 = (ImageData) next;
                        if (imageData2 != null) {
                            background = imageData2.getUrl();
                            str31 = background;
                        }
                    }
                    str31 = null;
                }
                str32 = str31;
                videos = kitsuMeta6.getVideos();
                if (videos == null) {
                    videos = CollectionsKt.emptyList();
                }
                if (!videos.isEmpty()) {
                    size = videos.size();
                } else if (r21 != 0) {
                    size = 1;
                } else {
                    size = 1;
                }
                Iterable intRange10 = new IntRange(1, size);
                linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange10, 10)), 16));
                while (r31.hasNext()) {
                    iIntValue5 = ((Number) obj6).intValue();
                    if (str19 != null) {
                        list5 = videos;
                        Integer anidbEid8 = StreamPlayUtilsKt.getAnidbEid(str19, Boxing.boxInt(iIntValue5));
                        if (anidbEid8 != null) {
                        }
                        linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                        videos = list5;
                    } else {
                        list5 = videos;
                    }
                    linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                    videos = list5;
                }
                list = videos;
                intRange = new IntRange(1, size);
                i5 = 0;
                linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange, 10)), 16));
                while (r27.hasNext()) {
                    Iterable iterable8 = intRange;
                    iIntValue4 = ((Number) obj7).intValue();
                    if (r21 != 0) {
                        i20 = size;
                        episodes3 = r21.getEpisodes();
                        if (episodes3 != null) {
                            i5 = i5;
                            metaEpisode = episodes3.get(String.valueOf(iIntValue4));
                        }
                        linkedHashMap2.put(obj7, metaEpisode);
                        intRange = iterable8;
                        size = i20;
                        i5 = i5;
                    } else {
                        i20 = size;
                    }
                    metaEpisode = null;
                    linkedHashMap2.put(obj7, metaEpisode);
                    intRange = iterable8;
                    size = i20;
                    i5 = i5;
                }
                i6 = size;
                if (url == null) {
                    if (r21 != 0) {
                        url3 = null;
                    } else {
                        url3 = null;
                    }
                    if (url3 == null) {
                        url3 = "";
                    }
                    str33 = url3;
                } else {
                    str33 = url;
                }
                if (r21 != 0) {
                    if (r21 != 0) {
                        str34 = null;
                    } else {
                        str34 = null;
                    }
                    if (str34 == null) {
                        if (r21 != 0) {
                            str36 = null;
                        } else {
                            str36 = null;
                        }
                        if (str36 == null) {
                            str35 = str22;
                        } else {
                            str35 = str36;
                        }
                    } else {
                        str35 = str34;
                    }
                } else {
                    if (r21 != 0) {
                        str34 = null;
                    } else {
                        str34 = null;
                    }
                    if (str34 == null) {
                        if (r21 != 0) {
                            str36 = null;
                        } else {
                            str36 = null;
                        }
                        if (str36 == null) {
                            str35 = str22;
                        } else {
                            str35 = str36;
                        }
                    } else {
                        str35 = str34;
                    }
                }
                num16 = (Integer) linkedHashMap.get(Boxing.boxInt(1));
                if (num16 != null) {
                    iIntValue = num16.intValue();
                } else {
                    iIntValue = 0;
                }
                i7 = iIntValue;
                num17 = num8;
                str37 = str22;
                str38 = str30;
                stringData = streamPlayAnime.toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), num13, num15, str22, num17, null, true, null, null, null, str30, null, null, false, false, false, false, Boxing.boxInt(i7), num6, 16633983, null));
                if (list.isEmpty()) {
                    list4 = list;
                    arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                    i18 = 0;
                    while (r37.hasNext()) {
                        int i2114 = i18 + 1;
                        if (i18 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ArrayList arrayList11118 = arrayList12;
                        LinkedHashMap linkedHashMap111 = linkedHashMap;
                        StreamPlayKitsuHelper.KitsuVideo kitsuVideo9 = (StreamPlayKitsuHelper.KitsuVideo) obj8;
                        i19 = i18;
                        episode2 = kitsuVideo9.getEpisode();
                        if (episode2 != null) {
                            iIntValue3 = episode2.intValue();
                        } else {
                            iIntValue3 = i19 + 1;
                        }
                        CharSequence charSequence10 = charSequence;
                        List<StreamPlayKitsuHelper.KitsuVideo> list119 = list4;
                        LinkedHashMap linkedHashMap112 = linkedHashMap2;
                        String str4110 = str35;
                        arrayList11118.add(loadFromKitsu$createEpisode(linkedHashMap112, streamPlayAnime, linkedHashMap111, num13, num15, str37, num17, str38, num6, str33, str4110, iIntValue3, kitsuVideo9, false));
                        streamPlayAnime = this;
                        linkedHashMap = linkedHashMap111;
                        str35 = str4110;
                        arrayList12 = arrayList11118;
                        i18 = i2114;
                        obj5 = obj5;
                        i7 = i7;
                        i4 = i4;
                        linkedHashMap2 = linkedHashMap112;
                        list4 = list119;
                        charSequence = charSequence10;
                    }
                    ArrayList arrayList11119 = arrayList12;
                    i8 = i7;
                    i9 = i4;
                    linkedHashMap4 = linkedHashMap;
                    charSequence2 = charSequence;
                    num18 = num15;
                    num19 = num17;
                    linkedHashMap3 = linkedHashMap2;
                    str39 = str35;
                    num20 = num13;
                    arrayList2 = arrayList11119;
                    i11 = 10;
                } else {
                    i8 = i7;
                    i9 = i4;
                    linkedHashMap3 = linkedHashMap2;
                    linkedHashMap4 = linkedHashMap;
                    charSequence2 = charSequence;
                    num18 = num15;
                    num19 = num17;
                    i10 = i6;
                    str39 = str35;
                    num20 = num13;
                    intRange2 = new IntRange(1, i10);
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
                    it = intRange2.iterator();
                    while (it.hasNext()) {
                        ArrayList arrayList111110 = arrayList;
                        arrayList111110.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, it.nextInt(), null, false));
                        i10 = i10;
                        arrayList = arrayList111110;
                        intRange2 = intRange2;
                    }
                    i6 = i10;
                    i11 = 10;
                    arrayList2 = arrayList;
                }
                arrayList3 = arrayList2;
                arrayList4 = arrayList3;
                arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, i11));
                i12 = 0;
                while (r32.hasNext()) {
                    int i2115 = i12 + 1;
                    if (i12 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    List<StreamPlayKitsuHelper.KitsuVideo> list1110 = list;
                    kitsuVideo = (StreamPlayKitsuHelper.KitsuVideo) CollectionsKt.getOrNull(list1110, i12);
                    if (kitsuVideo != null) {
                        iIntValue2 = i12 + 1;
                    } else {
                        iIntValue2 = i12 + 1;
                    }
                    list = list1110;
                    arrayList5.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, iIntValue2, kitsuVideo, true));
                    i12 = i2115;
                    arrayList4 = arrayList4;
                }
                linkedHashMap5 = linkedHashMap3;
                linkedHashMap6 = linkedHashMap4;
                num21 = num6;
                str40 = str33;
                str41 = str39;
                arrayList6 = arrayList5;
                imdbRating = kitsuMeta6.getImdbRating();
                if (imdbRating != null) {
                    iFloatValue = 0;
                } else {
                    iFloatValue = 0;
                }
                links = kitsuMeta6.getLinks();
                if (links != null) {
                    list3 = links;
                    arrayList8 = new ArrayList();
                    while (r10.hasNext()) {
                        ArrayList arrayList111111 = arrayList6;
                        List<StreamPlayKitsuHelper.KitsuLink> list1111 = list3;
                        if (StringsKt.equals(((StreamPlayKitsuHelper.KitsuLink) obj10).getCategory(), "Franchise", true)) {
                            arrayList8.add(obj10);
                        }
                        arrayList6 = arrayList111111;
                        list3 = list1111;
                    }
                    arrayList7 = arrayList6;
                    arrayList9 = arrayList8;
                    i16 = 0;
                    arrayList10 = new ArrayList();
                    while (r11.hasNext()) {
                        name2 = kitsuLink.getName();
                        if (name2 == null) {
                            arrayList11 = arrayList9;
                            i17 = i16;
                            num24 = num20;
                            num25 = num18;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        } else {
                            arrayList11 = arrayList9;
                            url2 = kitsuLink.getUrl();
                            if (url2 != null) {
                                i17 = i16;
                                num24 = num20;
                                num25 = num18;
                                strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                if (strSubstringAfterLast$default == null) {
                                    animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                }
                            } else {
                                i17 = i16;
                                num24 = num20;
                                num25 = num18;
                            }
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        }
                        if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                            arrayList10.add(animeSearchResponseNewAnimeSearchResponse$default);
                        }
                        arrayList9 = arrayList11;
                        i16 = i17;
                        num20 = num24;
                        num18 = num25;
                    }
                    num22 = num20;
                    num23 = num18;
                    list2 = arrayList10;
                } else {
                    arrayList7 = arrayList6;
                    num22 = num20;
                    num23 = num18;
                    list2 = null;
                }
                i13 = i9;
                if (i13 != 0) {
                    TvType tvType117 = TvType.AnimeMovie;
                    Integer num21115 = num19;
                    C00872 c00879 = new C00872(num22, num23, str20, num21115, kitsuMeta6, str32, url, str18, iFloatValue, null);
                    C00861 c0086117 = c00863;
                    c0086117.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                    c0086117.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                    c0086117.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                    c0086117.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                    c0086117.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                    c0086117.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                    c0086117.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c0086117.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                    c0086117.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                    c0086117.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                    c0086117.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                    c0086117.L$11 = SpillingKt.nullOutSpilledVariable(num21115);
                    c0086117.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                    c0086117.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                    c0086117.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                    c0086117.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c0086117.L$16 = SpillingKt.nullOutSpilledVariable(num22);
                    c0086117.L$17 = SpillingKt.nullOutSpilledVariable(num23);
                    c0086117.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                    c0086117.L$19 = SpillingKt.nullOutSpilledVariable(url);
                    c0086117.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                    c0086117.L$21 = SpillingKt.nullOutSpilledVariable(list);
                    c0086117.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                    c0086117.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                    c0086117.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                    c0086117.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                    c0086117.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                    c0086117.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c0086117.L$28 = SpillingKt.nullOutSpilledVariable(arrayList7);
                    c0086117.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                    c0086117.I$0 = i13;
                    c0086117.I$1 = i6;
                    c0086117.I$2 = i8;
                    c0086117.I$3 = iFloatValue;
                    c0086117.label = 8;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str37, str17, tvType117, stringData, c00879, c0086117);
                    obj4 = obj2;
                    if (objNewMovieLoadResponse == obj4) {
                        return obj4;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                Integer num21116 = num19;
                obj3 = obj2;
                C00861 c0086118 = c00863;
                Integer num21117 = num22;
                Integer num38 = num23;
                i14 = iFloatValue;
                TvType tvType118 = TvType.Anime;
                ArrayList arrayList111112 = arrayList7;
                C00883 c008810 = new C00883(num21117, num38, str20, arrayList3, arrayList111112, str18, num21116, kitsuMeta6, str32, url, i14, this, list2, null);
                c0086118.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                c0086118.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                c0086118.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                c0086118.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                c0086118.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                c0086118.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                c0086118.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                c0086118.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                c0086118.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                c0086118.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                c0086118.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                c0086118.L$11 = SpillingKt.nullOutSpilledVariable(num21116);
                c0086118.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                c0086118.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                c0086118.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                c0086118.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                c0086118.L$16 = SpillingKt.nullOutSpilledVariable(num21117);
                c0086118.L$17 = SpillingKt.nullOutSpilledVariable(num38);
                c0086118.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                c0086118.L$19 = SpillingKt.nullOutSpilledVariable(url);
                c0086118.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                c0086118.L$21 = SpillingKt.nullOutSpilledVariable(list);
                c0086118.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                c0086118.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                c0086118.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                c0086118.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                c0086118.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                c0086118.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                c0086118.L$28 = SpillingKt.nullOutSpilledVariable(arrayList111112);
                c0086118.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                c0086118.I$0 = i13;
                c0086118.I$1 = i6;
                c0086118.I$2 = i8;
                c0086118.I$3 = i14;
                c0086118.label = 9;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, str37, str17, tvType118, false, c008810, c0086118, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj3) {
                    return obj3;
                }
                str42 = str21;
                str43 = stringData;
                i15 = i14;
                obj5 = objNewAnimeLoadResponse$default;
                return (LoadResponse) obj5;
            case 5:
                num = (Integer) c00864.L$3;
                StreamPlayKitsuHelper.KitsuMeta kitsuMeta8 = (StreamPlayKitsuHelper.KitsuMeta) c00864.L$2;
                str45 = (String) c00864.L$1;
                str4 = (String) c00864.L$0;
                try {
                    ResultKt.throwOnFailure(obj5);
                    numericKitsuId = num;
                    str5 = str4;
                    obj = obj5;
                    kitsuMeta2 = kitsuMeta8;
                    str3 = null;
                    text = ((NiceResponse) obj).getText();
                    num2 = numericKitsuId;
                    str6 = str5;
                    kitsuMeta3 = kitsuMeta2;
                } catch (Throwable th4) {
                    kitsuMeta = kitsuMeta8;
                    str3 = null;
                    kitsuMeta3 = kitsuMeta;
                    num2 = num;
                    text = str3;
                    str6 = str4;
                    if (text != null) {
                        animeData = StreamPlayUtilsKt.parseAnimeData(text);
                    } else {
                        r8 = str3;
                    }
                    if (r8 != 0) {
                        r8 = animeData;
                        r8 = animeData;
                        r8 = animeData;
                        intOrNull = str3;
                    } else {
                        r8 = animeData;
                        r8 = animeData;
                        r8 = animeData;
                        intOrNull = str3;
                    }
                    if (r8 != 0) {
                        if (num2 != null) {
                            strValueOf = String.valueOf(num2.intValue());
                        } else {
                            strValueOf = str3;
                        }
                    } else if (num2 != null) {
                        strValueOf = String.valueOf(num2.intValue());
                    } else {
                        strValueOf = str3;
                    }
                    r8 = animeData;
                    str7 = strValueOf;
                    r85 = intOrNull;
                    if (StringsKt.equals(kitsuMeta3.getType(), "movie", true)) {
                        i = 1;
                    } else {
                        i = 1;
                    }
                    if (i != 0) {
                        tvType = TvType.Movie;
                    } else {
                        tvType = TvType.TvSeries;
                    }
                    if (i != 0) {
                        tvType2 = TvType.AnimeMovie;
                    } else {
                        tvType2 = TvType.TvSeries;
                    }
                    tvType3 = tvType2;
                    name = kitsuMeta3.getName();
                    if (name == null) {
                        aliases = kitsuMeta3.getAliases();
                        if (aliases != null) {
                            name = (String) CollectionsKt.firstOrNull(aliases);
                        } else {
                            name = null;
                        }
                        if (name == null) {
                            name = "Unknown";
                        }
                    }
                    str8 = name;
                    yearInt = kitsuMeta3.getYearInt();
                    if (yearInt != null) {
                        tvType4 = tvType;
                    } else if (r8 != 0) {
                        tvType4 = tvType;
                        yearInt = null;
                    } else {
                        tvType4 = tvType;
                        yearInt = null;
                    }
                    num3 = yearInt;
                    c00864.L$0 = str6;
                    c00864.L$1 = str45;
                    c00864.L$2 = kitsuMeta3;
                    c00864.L$3 = num2;
                    c00864.L$4 = text;
                    c00864.L$5 = r8;
                    c00864.L$6 = SpillingKt.nullOutSpilledVariable((Object) r85);
                    c00864.L$7 = str7;
                    str9 = text;
                    c00864.L$8 = SpillingKt.nullOutSpilledVariable(tvType4);
                    c00864.L$9 = tvType3;
                    c00864.L$10 = str8;
                    c00864.L$11 = num3;
                    c00864.I$0 = i;
                    c00864.label = 6;
                    num4 = num2;
                    i2 = i;
                    r19 = r8;
                    str10 = str6;
                    tvType5 = tvType4;
                    kitsuMeta4 = kitsuMeta3;
                    num5 = null;
                    C00861 c0086119 = c00864;
                    z = false;
                    objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", tvType5, r85, "en", c0086119);
                    c00862 = c0086119;
                    if (objFetchTmdbLogoUrl == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str11 = str9;
                    str12 = str7;
                    tvType6 = tvType3;
                    str13 = str8;
                    num6 = num4;
                    i3 = i2;
                    num7 = num3;
                    str14 = str10;
                    tvType7 = tvType5;
                    r16 = r85;
                    r6 = r19;
                    kitsuMeta5 = kitsuMeta4;
                    str15 = (String) objFetchTmdbLogoUrl;
                    if (r6 != 0) {
                        if (StringsKt.toIntOrNull(str45) != null) {
                            str16 = str45;
                            charSequence = "kitsu:";
                            if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                                intOrNull2 = StringsKt.toIntOrNull(str16);
                            }
                        } else {
                            str16 = str45;
                            charSequence = "kitsu:";
                        }
                        intOrNull2 = num5;
                    } else {
                        if (StringsKt.toIntOrNull(str45) != null) {
                            str16 = str45;
                            charSequence = "kitsu:";
                            if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                                intOrNull2 = StringsKt.toIntOrNull(str16);
                            }
                        } else {
                            str16 = str45;
                            charSequence = "kitsu:";
                        }
                        intOrNull2 = num5;
                    }
                    if (r6 != 0) {
                        malId = num5;
                    } else {
                        malId = num5;
                    }
                    if (malId == null) {
                    }
                    str17 = str14;
                    int i2116 = i3;
                    Integer num21118 = num7;
                    aniIds = new AniIds(intOrNull2, malId);
                    str18 = str15;
                    tvType8 = tvType6;
                    r21 = r6;
                    kitsuMeta6 = kitsuMeta5;
                    str19 = str11;
                    str20 = str12;
                    num8 = num21118;
                    r23 = r16;
                    tvType9 = tvType7;
                    i4 = i2116;
                    str21 = str16;
                    num9 = intOrNull2;
                    str22 = str13;
                    num10 = malId;
                    aniIds2 = aniIds;
                    id = aniIds2.getId();
                    if (id == null) {
                        num13 = num9;
                    } else {
                        num13 = id;
                    }
                    idMal = aniIds2.getIdMal();
                    if (idMal == null) {
                        num14 = num10;
                    } else {
                        num14 = idMal;
                    }
                    if (r21 != 0) {
                        if (r21 != 0) {
                            str29 = null;
                        } else {
                            str29 = null;
                        }
                        if (str29 != null) {
                            str30 = str29;
                        } else {
                            aliases2 = kitsuMeta6.getAliases();
                            if (aliases2 != null) {
                                str29 = (String) CollectionsKt.firstOrNull(aliases2);
                            } else {
                                str29 = null;
                            }
                            if (str29 == null) {
                                str30 = str22;
                            } else {
                                str30 = str29;
                            }
                        }
                    } else {
                        if (r21 != 0) {
                            str29 = null;
                        } else {
                            str29 = null;
                        }
                        if (str29 != null) {
                            str30 = str29;
                        } else {
                            aliases2 = kitsuMeta6.getAliases();
                            if (aliases2 != null) {
                                str29 = (String) CollectionsKt.firstOrNull(aliases2);
                            } else {
                                str29 = null;
                            }
                            if (str29 == null) {
                                str30 = str22;
                            } else {
                                str30 = str29;
                            }
                        }
                    }
                    poster = kitsuMeta6.getPoster();
                    if (poster != null) {
                        obj2 = coroutine_suspended;
                        num15 = num14;
                        c00863 = c00862;
                        url = poster;
                    } else if (r21 != 0) {
                        obj2 = coroutine_suspended;
                        num15 = num14;
                        c00863 = c00862;
                        url = null;
                    } else {
                        obj2 = coroutine_suspended;
                        num15 = num14;
                        c00863 = c00862;
                        url = null;
                    }
                    background = kitsuMeta6.getBackground();
                    if (background != null) {
                        str31 = background;
                    } else {
                        if (r21 != 0) {
                            list6 = images2;
                            it2 = list6.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    next = it2.next();
                                    list7 = list6;
                                    if (StringsKt.equals(((ImageData) next).getCoverType(), "Fanart", true)) {
                                        list6 = list7;
                                    }
                                } else {
                                    next = null;
                                }
                            }
                            imageData2 = (ImageData) next;
                            if (imageData2 != null) {
                                background = imageData2.getUrl();
                                str31 = background;
                            }
                        }
                        str31 = null;
                    }
                    str32 = str31;
                    videos = kitsuMeta6.getVideos();
                    if (videos == null) {
                        videos = CollectionsKt.emptyList();
                    }
                    if (!videos.isEmpty()) {
                        size = videos.size();
                    } else if (r21 != 0) {
                        size = 1;
                    } else {
                        size = 1;
                    }
                    Iterable intRange11 = new IntRange(1, size);
                    linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange11, 10)), 16));
                    while (r31.hasNext()) {
                        iIntValue5 = ((Number) obj6).intValue();
                        if (str19 != null) {
                            list5 = videos;
                            Integer anidbEid9 = StreamPlayUtilsKt.getAnidbEid(str19, Boxing.boxInt(iIntValue5));
                            if (anidbEid9 != null) {
                            }
                            linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                            videos = list5;
                        } else {
                            list5 = videos;
                        }
                        linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                        videos = list5;
                    }
                    list = videos;
                    intRange = new IntRange(1, size);
                    i5 = 0;
                    linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange, 10)), 16));
                    while (r27.hasNext()) {
                        Iterable iterable9 = intRange;
                        iIntValue4 = ((Number) obj7).intValue();
                        if (r21 != 0) {
                            i20 = size;
                            episodes3 = r21.getEpisodes();
                            if (episodes3 != null) {
                                i5 = i5;
                                metaEpisode = episodes3.get(String.valueOf(iIntValue4));
                            }
                            linkedHashMap2.put(obj7, metaEpisode);
                            intRange = iterable9;
                            size = i20;
                            i5 = i5;
                        } else {
                            i20 = size;
                        }
                        metaEpisode = null;
                        linkedHashMap2.put(obj7, metaEpisode);
                        intRange = iterable9;
                        size = i20;
                        i5 = i5;
                    }
                    i6 = size;
                    if (url == null) {
                        if (r21 != 0) {
                            url3 = null;
                        } else {
                            url3 = null;
                        }
                        if (url3 == null) {
                            url3 = "";
                        }
                        str33 = url3;
                    } else {
                        str33 = url;
                    }
                    if (r21 != 0) {
                        if (r21 != 0) {
                            str34 = null;
                        } else {
                            str34 = null;
                        }
                        if (str34 == null) {
                            if (r21 != 0) {
                                str36 = null;
                            } else {
                                str36 = null;
                            }
                            if (str36 == null) {
                                str35 = str22;
                            } else {
                                str35 = str36;
                            }
                        } else {
                            str35 = str34;
                        }
                    } else {
                        if (r21 != 0) {
                            str34 = null;
                        } else {
                            str34 = null;
                        }
                        if (str34 == null) {
                            if (r21 != 0) {
                                str36 = null;
                            } else {
                                str36 = null;
                            }
                            if (str36 == null) {
                                str35 = str22;
                            } else {
                                str35 = str36;
                            }
                        } else {
                            str35 = str34;
                        }
                    }
                    num16 = (Integer) linkedHashMap.get(Boxing.boxInt(1));
                    if (num16 != null) {
                        iIntValue = num16.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    i7 = iIntValue;
                    num17 = num8;
                    str37 = str22;
                    str38 = str30;
                    stringData = streamPlayAnime.toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), num13, num15, str22, num17, null, true, null, null, null, str30, null, null, false, false, false, false, Boxing.boxInt(i7), num6, 16633983, null));
                    if (list.isEmpty()) {
                        list4 = list;
                        arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                        i18 = 0;
                        while (r37.hasNext()) {
                            int i2117 = i18 + 1;
                            if (i18 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            ArrayList arrayList111113 = arrayList12;
                            LinkedHashMap linkedHashMap113 = linkedHashMap;
                            StreamPlayKitsuHelper.KitsuVideo kitsuVideo10 = (StreamPlayKitsuHelper.KitsuVideo) obj8;
                            i19 = i18;
                            episode2 = kitsuVideo10.getEpisode();
                            if (episode2 != null) {
                                iIntValue3 = episode2.intValue();
                            } else {
                                iIntValue3 = i19 + 1;
                            }
                            CharSequence charSequence11 = charSequence;
                            List<StreamPlayKitsuHelper.KitsuVideo> list1112 = list4;
                            LinkedHashMap linkedHashMap114 = linkedHashMap2;
                            String str4111 = str35;
                            arrayList111113.add(loadFromKitsu$createEpisode(linkedHashMap114, streamPlayAnime, linkedHashMap113, num13, num15, str37, num17, str38, num6, str33, str4111, iIntValue3, kitsuVideo10, false));
                            streamPlayAnime = this;
                            linkedHashMap = linkedHashMap113;
                            str35 = str4111;
                            arrayList12 = arrayList111113;
                            i18 = i2117;
                            obj5 = obj5;
                            i7 = i7;
                            i4 = i4;
                            linkedHashMap2 = linkedHashMap114;
                            list4 = list1112;
                            charSequence = charSequence11;
                        }
                        ArrayList arrayList111114 = arrayList12;
                        i8 = i7;
                        i9 = i4;
                        linkedHashMap4 = linkedHashMap;
                        charSequence2 = charSequence;
                        num18 = num15;
                        num19 = num17;
                        linkedHashMap3 = linkedHashMap2;
                        str39 = str35;
                        num20 = num13;
                        arrayList2 = arrayList111114;
                        i11 = 10;
                    } else {
                        i8 = i7;
                        i9 = i4;
                        linkedHashMap3 = linkedHashMap2;
                        linkedHashMap4 = linkedHashMap;
                        charSequence2 = charSequence;
                        num18 = num15;
                        num19 = num17;
                        i10 = i6;
                        str39 = str35;
                        num20 = num13;
                        intRange2 = new IntRange(1, i10);
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
                        it = intRange2.iterator();
                        while (it.hasNext()) {
                            ArrayList arrayList111115 = arrayList;
                            arrayList111115.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, it.nextInt(), null, false));
                            i10 = i10;
                            arrayList = arrayList111115;
                            intRange2 = intRange2;
                        }
                        i6 = i10;
                        i11 = 10;
                        arrayList2 = arrayList;
                    }
                    arrayList3 = arrayList2;
                    arrayList4 = arrayList3;
                    arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, i11));
                    i12 = 0;
                    while (r32.hasNext()) {
                        int i2118 = i12 + 1;
                        if (i12 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        List<StreamPlayKitsuHelper.KitsuVideo> list1113 = list;
                        kitsuVideo = (StreamPlayKitsuHelper.KitsuVideo) CollectionsKt.getOrNull(list1113, i12);
                        if (kitsuVideo != null) {
                            iIntValue2 = i12 + 1;
                        } else {
                            iIntValue2 = i12 + 1;
                        }
                        list = list1113;
                        arrayList5.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, iIntValue2, kitsuVideo, true));
                        i12 = i2118;
                        arrayList4 = arrayList4;
                    }
                    linkedHashMap5 = linkedHashMap3;
                    linkedHashMap6 = linkedHashMap4;
                    num21 = num6;
                    str40 = str33;
                    str41 = str39;
                    arrayList6 = arrayList5;
                    imdbRating = kitsuMeta6.getImdbRating();
                    if (imdbRating != null) {
                        iFloatValue = 0;
                    } else {
                        iFloatValue = 0;
                    }
                    links = kitsuMeta6.getLinks();
                    if (links != null) {
                        list3 = links;
                        arrayList8 = new ArrayList();
                        while (r10.hasNext()) {
                            ArrayList arrayList111116 = arrayList6;
                            List<StreamPlayKitsuHelper.KitsuLink> list1114 = list3;
                            if (StringsKt.equals(((StreamPlayKitsuHelper.KitsuLink) obj10).getCategory(), "Franchise", true)) {
                                arrayList8.add(obj10);
                            }
                            arrayList6 = arrayList111116;
                            list3 = list1114;
                        }
                        arrayList7 = arrayList6;
                        arrayList9 = arrayList8;
                        i16 = 0;
                        arrayList10 = new ArrayList();
                        while (r11.hasNext()) {
                            name2 = kitsuLink.getName();
                            if (name2 == null) {
                                arrayList11 = arrayList9;
                                i17 = i16;
                                num24 = num20;
                                num25 = num18;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                            } else {
                                arrayList11 = arrayList9;
                                url2 = kitsuLink.getUrl();
                                if (url2 != null) {
                                    i17 = i16;
                                    num24 = num20;
                                    num25 = num18;
                                    strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                    if (strSubstringAfterLast$default == null) {
                                        animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                    }
                                } else {
                                    i17 = i16;
                                    num24 = num20;
                                    num25 = num18;
                                }
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                            }
                            if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                arrayList10.add(animeSearchResponseNewAnimeSearchResponse$default);
                            }
                            arrayList9 = arrayList11;
                            i16 = i17;
                            num20 = num24;
                            num18 = num25;
                        }
                        num22 = num20;
                        num23 = num18;
                        list2 = arrayList10;
                    } else {
                        arrayList7 = arrayList6;
                        num22 = num20;
                        num23 = num18;
                        list2 = null;
                    }
                    i13 = i9;
                    if (i13 != 0) {
                        TvType tvType119 = TvType.AnimeMovie;
                        Integer num21119 = num19;
                        C00872 c008710 = new C00872(num22, num23, str20, num21119, kitsuMeta6, str32, url, str18, iFloatValue, null);
                        C00861 c00861110 = c00863;
                        c00861110.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                        c00861110.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                        c00861110.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                        c00861110.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                        c00861110.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                        c00861110.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                        c00861110.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c00861110.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                        c00861110.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                        c00861110.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                        c00861110.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                        c00861110.L$11 = SpillingKt.nullOutSpilledVariable(num21119);
                        c00861110.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                        c00861110.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                        c00861110.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                        c00861110.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c00861110.L$16 = SpillingKt.nullOutSpilledVariable(num22);
                        c00861110.L$17 = SpillingKt.nullOutSpilledVariable(num23);
                        c00861110.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                        c00861110.L$19 = SpillingKt.nullOutSpilledVariable(url);
                        c00861110.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                        c00861110.L$21 = SpillingKt.nullOutSpilledVariable(list);
                        c00861110.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                        c00861110.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                        c00861110.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                        c00861110.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                        c00861110.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                        c00861110.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c00861110.L$28 = SpillingKt.nullOutSpilledVariable(arrayList7);
                        c00861110.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                        c00861110.I$0 = i13;
                        c00861110.I$1 = i6;
                        c00861110.I$2 = i8;
                        c00861110.I$3 = iFloatValue;
                        c00861110.label = 8;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str37, str17, tvType119, stringData, c008710, c00861110);
                        obj4 = obj2;
                        if (objNewMovieLoadResponse == obj4) {
                            return obj4;
                        }
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    Integer num211110 = num19;
                    obj3 = obj2;
                    C00861 c00861111 = c00863;
                    Integer num211111 = num22;
                    Integer num39 = num23;
                    i14 = iFloatValue;
                    TvType tvType1110 = TvType.Anime;
                    ArrayList arrayList111117 = arrayList7;
                    C00883 c008811 = new C00883(num211111, num39, str20, arrayList3, arrayList111117, str18, num211110, kitsuMeta6, str32, url, i14, this, list2, null);
                    c00861111.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                    c00861111.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                    c00861111.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                    c00861111.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                    c00861111.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                    c00861111.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                    c00861111.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c00861111.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                    c00861111.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                    c00861111.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                    c00861111.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                    c00861111.L$11 = SpillingKt.nullOutSpilledVariable(num211110);
                    c00861111.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                    c00861111.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                    c00861111.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                    c00861111.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c00861111.L$16 = SpillingKt.nullOutSpilledVariable(num211111);
                    c00861111.L$17 = SpillingKt.nullOutSpilledVariable(num39);
                    c00861111.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                    c00861111.L$19 = SpillingKt.nullOutSpilledVariable(url);
                    c00861111.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                    c00861111.L$21 = SpillingKt.nullOutSpilledVariable(list);
                    c00861111.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                    c00861111.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                    c00861111.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                    c00861111.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                    c00861111.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                    c00861111.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c00861111.L$28 = SpillingKt.nullOutSpilledVariable(arrayList111117);
                    c00861111.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                    c00861111.I$0 = i13;
                    c00861111.I$1 = i6;
                    c00861111.I$2 = i8;
                    c00861111.I$3 = i14;
                    c00861111.label = 9;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, str37, str17, tvType1110, false, c008811, c00861111, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj3) {
                        return obj3;
                    }
                    str42 = str21;
                    str43 = stringData;
                    i15 = i14;
                    obj5 = objNewAnimeLoadResponse$default;
                    return (LoadResponse) obj5;
                }
                if (text != null) {
                    animeData = StreamPlayUtilsKt.parseAnimeData(text);
                } else {
                    r8 = str3;
                }
                if (r8 != 0) {
                    r8 = animeData;
                    r8 = animeData;
                    r8 = animeData;
                    intOrNull = str3;
                } else {
                    r8 = animeData;
                    r8 = animeData;
                    r8 = animeData;
                    intOrNull = str3;
                }
                if (r8 != 0) {
                    if (num2 != null) {
                        strValueOf = String.valueOf(num2.intValue());
                    } else {
                        strValueOf = str3;
                    }
                } else if (num2 != null) {
                    strValueOf = String.valueOf(num2.intValue());
                } else {
                    strValueOf = str3;
                }
                r8 = animeData;
                str7 = strValueOf;
                r85 = intOrNull;
                if (StringsKt.equals(kitsuMeta3.getType(), "movie", true)) {
                    i = 1;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                if (i != 0) {
                    tvType2 = TvType.AnimeMovie;
                } else {
                    tvType2 = TvType.TvSeries;
                }
                tvType3 = tvType2;
                name = kitsuMeta3.getName();
                if (name == null) {
                    aliases = kitsuMeta3.getAliases();
                    if (aliases != null) {
                        name = (String) CollectionsKt.firstOrNull(aliases);
                    } else {
                        name = null;
                    }
                    if (name == null) {
                        name = "Unknown";
                    }
                }
                str8 = name;
                yearInt = kitsuMeta3.getYearInt();
                if (yearInt != null) {
                    tvType4 = tvType;
                } else if (r8 != 0) {
                    tvType4 = tvType;
                    yearInt = null;
                } else {
                    tvType4 = tvType;
                    yearInt = null;
                }
                num3 = yearInt;
                c00864.L$0 = str6;
                c00864.L$1 = str45;
                c00864.L$2 = kitsuMeta3;
                c00864.L$3 = num2;
                c00864.L$4 = text;
                c00864.L$5 = r8;
                c00864.L$6 = SpillingKt.nullOutSpilledVariable((Object) r85);
                c00864.L$7 = str7;
                str9 = text;
                c00864.L$8 = SpillingKt.nullOutSpilledVariable(tvType4);
                c00864.L$9 = tvType3;
                c00864.L$10 = str8;
                c00864.L$11 = num3;
                c00864.I$0 = i;
                c00864.label = 6;
                num4 = num2;
                i2 = i;
                r19 = r8;
                str10 = str6;
                tvType5 = tvType4;
                kitsuMeta4 = kitsuMeta3;
                num5 = null;
                C00861 c00861112 = c00864;
                z = false;
                objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", tvType5, r85, "en", c00861112);
                c00862 = c00861112;
                if (objFetchTmdbLogoUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str11 = str9;
                str12 = str7;
                tvType6 = tvType3;
                str13 = str8;
                num6 = num4;
                i3 = i2;
                num7 = num3;
                str14 = str10;
                tvType7 = tvType5;
                r16 = r85;
                r6 = r19;
                kitsuMeta5 = kitsuMeta4;
                str15 = (String) objFetchTmdbLogoUrl;
                if (r6 != 0) {
                    if (StringsKt.toIntOrNull(str45) != null) {
                        str16 = str45;
                        charSequence = "kitsu:";
                        if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                            intOrNull2 = StringsKt.toIntOrNull(str16);
                        }
                    } else {
                        str16 = str45;
                        charSequence = "kitsu:";
                    }
                    intOrNull2 = num5;
                } else {
                    if (StringsKt.toIntOrNull(str45) != null) {
                        str16 = str45;
                        charSequence = "kitsu:";
                        if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                            intOrNull2 = StringsKt.toIntOrNull(str16);
                        }
                    } else {
                        str16 = str45;
                        charSequence = "kitsu:";
                    }
                    intOrNull2 = num5;
                }
                if (r6 != 0) {
                    malId = num5;
                } else {
                    malId = num5;
                }
                if (malId == null) {
                }
                str17 = str14;
                int i2119 = i3;
                Integer num211112 = num7;
                aniIds = new AniIds(intOrNull2, malId);
                str18 = str15;
                tvType8 = tvType6;
                r21 = r6;
                kitsuMeta6 = kitsuMeta5;
                str19 = str11;
                str20 = str12;
                num8 = num211112;
                r23 = r16;
                tvType9 = tvType7;
                i4 = i2119;
                str21 = str16;
                num9 = intOrNull2;
                str22 = str13;
                num10 = malId;
                aniIds2 = aniIds;
                id = aniIds2.getId();
                if (id == null) {
                    num13 = num9;
                } else {
                    num13 = id;
                }
                idMal = aniIds2.getIdMal();
                if (idMal == null) {
                    num14 = num10;
                } else {
                    num14 = idMal;
                }
                if (r21 != 0) {
                    if (r21 != 0) {
                        str29 = null;
                    } else {
                        str29 = null;
                    }
                    if (str29 != null) {
                        str30 = str29;
                    } else {
                        aliases2 = kitsuMeta6.getAliases();
                        if (aliases2 != null) {
                            str29 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str29 = null;
                        }
                        if (str29 == null) {
                            str30 = str22;
                        } else {
                            str30 = str29;
                        }
                    }
                } else {
                    if (r21 != 0) {
                        str29 = null;
                    } else {
                        str29 = null;
                    }
                    if (str29 != null) {
                        str30 = str29;
                    } else {
                        aliases2 = kitsuMeta6.getAliases();
                        if (aliases2 != null) {
                            str29 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str29 = null;
                        }
                        if (str29 == null) {
                            str30 = str22;
                        } else {
                            str30 = str29;
                        }
                    }
                }
                poster = kitsuMeta6.getPoster();
                if (poster != null) {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = poster;
                } else if (r21 != 0) {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = null;
                } else {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = null;
                }
                background = kitsuMeta6.getBackground();
                if (background != null) {
                    str31 = background;
                } else {
                    if (r21 != 0) {
                        list6 = images2;
                        it2 = list6.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                next = it2.next();
                                list7 = list6;
                                if (StringsKt.equals(((ImageData) next).getCoverType(), "Fanart", true)) {
                                    list6 = list7;
                                }
                            } else {
                                next = null;
                            }
                        }
                        imageData2 = (ImageData) next;
                        if (imageData2 != null) {
                            background = imageData2.getUrl();
                            str31 = background;
                        }
                    }
                    str31 = null;
                }
                str32 = str31;
                videos = kitsuMeta6.getVideos();
                if (videos == null) {
                    videos = CollectionsKt.emptyList();
                }
                if (!videos.isEmpty()) {
                    size = videos.size();
                } else if (r21 != 0) {
                    size = 1;
                } else {
                    size = 1;
                }
                Iterable intRange12 = new IntRange(1, size);
                linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange12, 10)), 16));
                while (r31.hasNext()) {
                    iIntValue5 = ((Number) obj6).intValue();
                    if (str19 != null) {
                        list5 = videos;
                        Integer anidbEid10 = StreamPlayUtilsKt.getAnidbEid(str19, Boxing.boxInt(iIntValue5));
                        if (anidbEid10 != null) {
                        }
                        linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                        videos = list5;
                    } else {
                        list5 = videos;
                    }
                    linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                    videos = list5;
                }
                list = videos;
                intRange = new IntRange(1, size);
                i5 = 0;
                linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange, 10)), 16));
                while (r27.hasNext()) {
                    Iterable iterable10 = intRange;
                    iIntValue4 = ((Number) obj7).intValue();
                    if (r21 != 0) {
                        i20 = size;
                        episodes3 = r21.getEpisodes();
                        if (episodes3 != null) {
                            i5 = i5;
                            metaEpisode = episodes3.get(String.valueOf(iIntValue4));
                        }
                        linkedHashMap2.put(obj7, metaEpisode);
                        intRange = iterable10;
                        size = i20;
                        i5 = i5;
                    } else {
                        i20 = size;
                    }
                    metaEpisode = null;
                    linkedHashMap2.put(obj7, metaEpisode);
                    intRange = iterable10;
                    size = i20;
                    i5 = i5;
                }
                i6 = size;
                if (url == null) {
                    if (r21 != 0) {
                        url3 = null;
                    } else {
                        url3 = null;
                    }
                    if (url3 == null) {
                        url3 = "";
                    }
                    str33 = url3;
                } else {
                    str33 = url;
                }
                if (r21 != 0) {
                    if (r21 != 0) {
                        str34 = null;
                    } else {
                        str34 = null;
                    }
                    if (str34 == null) {
                        if (r21 != 0) {
                            str36 = null;
                        } else {
                            str36 = null;
                        }
                        if (str36 == null) {
                            str35 = str22;
                        } else {
                            str35 = str36;
                        }
                    } else {
                        str35 = str34;
                    }
                } else {
                    if (r21 != 0) {
                        str34 = null;
                    } else {
                        str34 = null;
                    }
                    if (str34 == null) {
                        if (r21 != 0) {
                            str36 = null;
                        } else {
                            str36 = null;
                        }
                        if (str36 == null) {
                            str35 = str22;
                        } else {
                            str35 = str36;
                        }
                    } else {
                        str35 = str34;
                    }
                }
                num16 = (Integer) linkedHashMap.get(Boxing.boxInt(1));
                if (num16 != null) {
                    iIntValue = num16.intValue();
                } else {
                    iIntValue = 0;
                }
                i7 = iIntValue;
                num17 = num8;
                str37 = str22;
                str38 = str30;
                stringData = streamPlayAnime.toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), num13, num15, str22, num17, null, true, null, null, null, str30, null, null, false, false, false, false, Boxing.boxInt(i7), num6, 16633983, null));
                if (list.isEmpty()) {
                    list4 = list;
                    arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                    i18 = 0;
                    while (r37.hasNext()) {
                        int i21110 = i18 + 1;
                        if (i18 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ArrayList arrayList111118 = arrayList12;
                        LinkedHashMap linkedHashMap115 = linkedHashMap;
                        StreamPlayKitsuHelper.KitsuVideo kitsuVideo11 = (StreamPlayKitsuHelper.KitsuVideo) obj8;
                        i19 = i18;
                        episode2 = kitsuVideo11.getEpisode();
                        if (episode2 != null) {
                            iIntValue3 = episode2.intValue();
                        } else {
                            iIntValue3 = i19 + 1;
                        }
                        CharSequence charSequence12 = charSequence;
                        List<StreamPlayKitsuHelper.KitsuVideo> list1115 = list4;
                        LinkedHashMap linkedHashMap116 = linkedHashMap2;
                        String str4112 = str35;
                        arrayList111118.add(loadFromKitsu$createEpisode(linkedHashMap116, streamPlayAnime, linkedHashMap115, num13, num15, str37, num17, str38, num6, str33, str4112, iIntValue3, kitsuVideo11, false));
                        streamPlayAnime = this;
                        linkedHashMap = linkedHashMap115;
                        str35 = str4112;
                        arrayList12 = arrayList111118;
                        i18 = i21110;
                        obj5 = obj5;
                        i7 = i7;
                        i4 = i4;
                        linkedHashMap2 = linkedHashMap116;
                        list4 = list1115;
                        charSequence = charSequence12;
                    }
                    ArrayList arrayList111119 = arrayList12;
                    i8 = i7;
                    i9 = i4;
                    linkedHashMap4 = linkedHashMap;
                    charSequence2 = charSequence;
                    num18 = num15;
                    num19 = num17;
                    linkedHashMap3 = linkedHashMap2;
                    str39 = str35;
                    num20 = num13;
                    arrayList2 = arrayList111119;
                    i11 = 10;
                } else {
                    i8 = i7;
                    i9 = i4;
                    linkedHashMap3 = linkedHashMap2;
                    linkedHashMap4 = linkedHashMap;
                    charSequence2 = charSequence;
                    num18 = num15;
                    num19 = num17;
                    i10 = i6;
                    str39 = str35;
                    num20 = num13;
                    intRange2 = new IntRange(1, i10);
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
                    it = intRange2.iterator();
                    while (it.hasNext()) {
                        ArrayList arrayList1111110 = arrayList;
                        arrayList1111110.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, it.nextInt(), null, false));
                        i10 = i10;
                        arrayList = arrayList1111110;
                        intRange2 = intRange2;
                    }
                    i6 = i10;
                    i11 = 10;
                    arrayList2 = arrayList;
                }
                arrayList3 = arrayList2;
                arrayList4 = arrayList3;
                arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, i11));
                i12 = 0;
                while (r32.hasNext()) {
                    int i21111 = i12 + 1;
                    if (i12 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    List<StreamPlayKitsuHelper.KitsuVideo> list1116 = list;
                    kitsuVideo = (StreamPlayKitsuHelper.KitsuVideo) CollectionsKt.getOrNull(list1116, i12);
                    if (kitsuVideo != null) {
                        iIntValue2 = i12 + 1;
                    } else {
                        iIntValue2 = i12 + 1;
                    }
                    list = list1116;
                    arrayList5.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, iIntValue2, kitsuVideo, true));
                    i12 = i21111;
                    arrayList4 = arrayList4;
                }
                linkedHashMap5 = linkedHashMap3;
                linkedHashMap6 = linkedHashMap4;
                num21 = num6;
                str40 = str33;
                str41 = str39;
                arrayList6 = arrayList5;
                imdbRating = kitsuMeta6.getImdbRating();
                if (imdbRating != null) {
                    iFloatValue = 0;
                } else {
                    iFloatValue = 0;
                }
                links = kitsuMeta6.getLinks();
                if (links != null) {
                    list3 = links;
                    arrayList8 = new ArrayList();
                    while (r10.hasNext()) {
                        ArrayList arrayList1111111 = arrayList6;
                        List<StreamPlayKitsuHelper.KitsuLink> list1117 = list3;
                        if (StringsKt.equals(((StreamPlayKitsuHelper.KitsuLink) obj10).getCategory(), "Franchise", true)) {
                            arrayList8.add(obj10);
                        }
                        arrayList6 = arrayList1111111;
                        list3 = list1117;
                    }
                    arrayList7 = arrayList6;
                    arrayList9 = arrayList8;
                    i16 = 0;
                    arrayList10 = new ArrayList();
                    while (r11.hasNext()) {
                        name2 = kitsuLink.getName();
                        if (name2 == null) {
                            arrayList11 = arrayList9;
                            i17 = i16;
                            num24 = num20;
                            num25 = num18;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        } else {
                            arrayList11 = arrayList9;
                            url2 = kitsuLink.getUrl();
                            if (url2 != null) {
                                i17 = i16;
                                num24 = num20;
                                num25 = num18;
                                strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                if (strSubstringAfterLast$default == null) {
                                    animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                }
                            } else {
                                i17 = i16;
                                num24 = num20;
                                num25 = num18;
                            }
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        }
                        if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                            arrayList10.add(animeSearchResponseNewAnimeSearchResponse$default);
                        }
                        arrayList9 = arrayList11;
                        i16 = i17;
                        num20 = num24;
                        num18 = num25;
                    }
                    num22 = num20;
                    num23 = num18;
                    list2 = arrayList10;
                } else {
                    arrayList7 = arrayList6;
                    num22 = num20;
                    num23 = num18;
                    list2 = null;
                }
                i13 = i9;
                if (i13 != 0) {
                    TvType tvType1111 = TvType.AnimeMovie;
                    Integer num211113 = num19;
                    C00872 c008711 = new C00872(num22, num23, str20, num211113, kitsuMeta6, str32, url, str18, iFloatValue, null);
                    C00861 c00861113 = c00863;
                    c00861113.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                    c00861113.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                    c00861113.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                    c00861113.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                    c00861113.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                    c00861113.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                    c00861113.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c00861113.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                    c00861113.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                    c00861113.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                    c00861113.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                    c00861113.L$11 = SpillingKt.nullOutSpilledVariable(num211113);
                    c00861113.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                    c00861113.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                    c00861113.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                    c00861113.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c00861113.L$16 = SpillingKt.nullOutSpilledVariable(num22);
                    c00861113.L$17 = SpillingKt.nullOutSpilledVariable(num23);
                    c00861113.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                    c00861113.L$19 = SpillingKt.nullOutSpilledVariable(url);
                    c00861113.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                    c00861113.L$21 = SpillingKt.nullOutSpilledVariable(list);
                    c00861113.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                    c00861113.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                    c00861113.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                    c00861113.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                    c00861113.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                    c00861113.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c00861113.L$28 = SpillingKt.nullOutSpilledVariable(arrayList7);
                    c00861113.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                    c00861113.I$0 = i13;
                    c00861113.I$1 = i6;
                    c00861113.I$2 = i8;
                    c00861113.I$3 = iFloatValue;
                    c00861113.label = 8;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str37, str17, tvType1111, stringData, c008711, c00861113);
                    obj4 = obj2;
                    if (objNewMovieLoadResponse == obj4) {
                        return obj4;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                Integer num211114 = num19;
                obj3 = obj2;
                C00861 c00861114 = c00863;
                Integer num211115 = num22;
                Integer num310 = num23;
                i14 = iFloatValue;
                TvType tvType1112 = TvType.Anime;
                ArrayList arrayList1111112 = arrayList7;
                C00883 c008812 = new C00883(num211115, num310, str20, arrayList3, arrayList1111112, str18, num211114, kitsuMeta6, str32, url, i14, this, list2, null);
                c00861114.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                c00861114.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                c00861114.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                c00861114.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                c00861114.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                c00861114.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                c00861114.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                c00861114.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                c00861114.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                c00861114.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                c00861114.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                c00861114.L$11 = SpillingKt.nullOutSpilledVariable(num211114);
                c00861114.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                c00861114.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                c00861114.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                c00861114.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                c00861114.L$16 = SpillingKt.nullOutSpilledVariable(num211115);
                c00861114.L$17 = SpillingKt.nullOutSpilledVariable(num310);
                c00861114.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                c00861114.L$19 = SpillingKt.nullOutSpilledVariable(url);
                c00861114.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                c00861114.L$21 = SpillingKt.nullOutSpilledVariable(list);
                c00861114.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                c00861114.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                c00861114.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                c00861114.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                c00861114.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                c00861114.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                c00861114.L$28 = SpillingKt.nullOutSpilledVariable(arrayList1111112);
                c00861114.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                c00861114.I$0 = i13;
                c00861114.I$1 = i6;
                c00861114.I$2 = i8;
                c00861114.I$3 = i14;
                c00861114.label = 9;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, str37, str17, tvType1112, false, c008812, c00861114, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj3) {
                    return obj3;
                }
                str42 = str21;
                str43 = stringData;
                i15 = i14;
                obj5 = objNewAnimeLoadResponse$default;
                return (LoadResponse) obj5;
            case 6:
                int i30 = c00864.I$0;
                Integer num40 = (Integer) c00864.L$11;
                String str52 = (String) c00864.L$10;
                TvType tvType20 = (TvType) c00864.L$9;
                TvType tvType21 = (TvType) c00864.L$8;
                String str53 = (String) c00864.L$7;
                Integer num41 = (Integer) c00864.L$6;
                MetaAnimeData metaAnimeData = (MetaAnimeData) c00864.L$5;
                String str54 = (String) c00864.L$4;
                Integer num42 = (Integer) c00864.L$3;
                StreamPlayKitsuHelper.KitsuMeta kitsuMeta9 = (StreamPlayKitsuHelper.KitsuMeta) c00864.L$2;
                str45 = (String) c00864.L$1;
                str14 = (String) c00864.L$0;
                ResultKt.throwOnFailure(obj5);
                num7 = num40;
                str13 = str52;
                tvType6 = tvType20;
                str12 = str53;
                c00862 = c00864;
                objFetchTmdbLogoUrl = obj5;
                i3 = i30;
                r6 = metaAnimeData;
                str11 = str54;
                kitsuMeta5 = kitsuMeta9;
                z = false;
                tvType7 = tvType21;
                r16 = num41;
                num6 = num42;
                num5 = null;
                str15 = (String) objFetchTmdbLogoUrl;
                if (r6 != 0) {
                    if (StringsKt.toIntOrNull(str45) != null) {
                        str16 = str45;
                        charSequence = "kitsu:";
                        if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                            intOrNull2 = StringsKt.toIntOrNull(str16);
                        }
                    } else {
                        str16 = str45;
                        charSequence = "kitsu:";
                    }
                    intOrNull2 = num5;
                } else {
                    if (StringsKt.toIntOrNull(str45) != null) {
                        str16 = str45;
                        charSequence = "kitsu:";
                        if (!StringsKt.contains$default(str14, "kitsu", z, 2, num5)) {
                            intOrNull2 = StringsKt.toIntOrNull(str16);
                        }
                    } else {
                        str16 = str45;
                        charSequence = "kitsu:";
                    }
                    intOrNull2 = num5;
                }
                if (r6 != 0) {
                    malId = num5;
                } else {
                    malId = num5;
                }
                if (malId == null) {
                }
                str17 = str14;
                int i21112 = i3;
                Integer num211116 = num7;
                aniIds = new AniIds(intOrNull2, malId);
                str18 = str15;
                tvType8 = tvType6;
                r21 = r6;
                kitsuMeta6 = kitsuMeta5;
                str19 = str11;
                str20 = str12;
                num8 = num211116;
                r23 = r16;
                tvType9 = tvType7;
                i4 = i21112;
                str21 = str16;
                num9 = intOrNull2;
                str22 = str13;
                num10 = malId;
                aniIds2 = aniIds;
                id = aniIds2.getId();
                if (id == null) {
                    num13 = num9;
                } else {
                    num13 = id;
                }
                idMal = aniIds2.getIdMal();
                if (idMal == null) {
                    num14 = num10;
                } else {
                    num14 = idMal;
                }
                if (r21 != 0) {
                    if (r21 != 0) {
                        str29 = null;
                    } else {
                        str29 = null;
                    }
                    if (str29 != null) {
                        str30 = str29;
                    } else {
                        aliases2 = kitsuMeta6.getAliases();
                        if (aliases2 != null) {
                            str29 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str29 = null;
                        }
                        if (str29 == null) {
                            str30 = str22;
                        } else {
                            str30 = str29;
                        }
                    }
                } else {
                    if (r21 != 0) {
                        str29 = null;
                    } else {
                        str29 = null;
                    }
                    if (str29 != null) {
                        str30 = str29;
                    } else {
                        aliases2 = kitsuMeta6.getAliases();
                        if (aliases2 != null) {
                            str29 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str29 = null;
                        }
                        if (str29 == null) {
                            str30 = str22;
                        } else {
                            str30 = str29;
                        }
                    }
                }
                poster = kitsuMeta6.getPoster();
                if (poster != null) {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = poster;
                } else if (r21 != 0) {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = null;
                } else {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = null;
                }
                background = kitsuMeta6.getBackground();
                if (background != null) {
                    str31 = background;
                } else {
                    if (r21 != 0) {
                        list6 = images2;
                        it2 = list6.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                next = it2.next();
                                list7 = list6;
                                if (StringsKt.equals(((ImageData) next).getCoverType(), "Fanart", true)) {
                                    list6 = list7;
                                }
                            } else {
                                next = null;
                            }
                        }
                        imageData2 = (ImageData) next;
                        if (imageData2 != null) {
                            background = imageData2.getUrl();
                            str31 = background;
                        }
                    }
                    str31 = null;
                }
                str32 = str31;
                videos = kitsuMeta6.getVideos();
                if (videos == null) {
                    videos = CollectionsKt.emptyList();
                }
                if (!videos.isEmpty()) {
                    size = videos.size();
                } else if (r21 != 0) {
                    size = 1;
                } else {
                    size = 1;
                }
                Iterable intRange13 = new IntRange(1, size);
                linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange13, 10)), 16));
                while (r31.hasNext()) {
                    iIntValue5 = ((Number) obj6).intValue();
                    if (str19 != null) {
                        list5 = videos;
                        Integer anidbEid11 = StreamPlayUtilsKt.getAnidbEid(str19, Boxing.boxInt(iIntValue5));
                        if (anidbEid11 != null) {
                        }
                        linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                        videos = list5;
                    } else {
                        list5 = videos;
                    }
                    linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                    videos = list5;
                }
                list = videos;
                intRange = new IntRange(1, size);
                i5 = 0;
                linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange, 10)), 16));
                while (r27.hasNext()) {
                    Iterable iterable11 = intRange;
                    iIntValue4 = ((Number) obj7).intValue();
                    if (r21 != 0) {
                        i20 = size;
                        episodes3 = r21.getEpisodes();
                        if (episodes3 != null) {
                            i5 = i5;
                            metaEpisode = episodes3.get(String.valueOf(iIntValue4));
                        }
                        linkedHashMap2.put(obj7, metaEpisode);
                        intRange = iterable11;
                        size = i20;
                        i5 = i5;
                    } else {
                        i20 = size;
                    }
                    metaEpisode = null;
                    linkedHashMap2.put(obj7, metaEpisode);
                    intRange = iterable11;
                    size = i20;
                    i5 = i5;
                }
                i6 = size;
                if (url == null) {
                    if (r21 != 0) {
                        url3 = null;
                    } else {
                        url3 = null;
                    }
                    if (url3 == null) {
                        url3 = "";
                    }
                    str33 = url3;
                } else {
                    str33 = url;
                }
                if (r21 != 0) {
                    if (r21 != 0) {
                        str34 = null;
                    } else {
                        str34 = null;
                    }
                    if (str34 == null) {
                        if (r21 != 0) {
                            str36 = null;
                        } else {
                            str36 = null;
                        }
                        if (str36 == null) {
                            str35 = str22;
                        } else {
                            str35 = str36;
                        }
                    } else {
                        str35 = str34;
                    }
                } else {
                    if (r21 != 0) {
                        str34 = null;
                    } else {
                        str34 = null;
                    }
                    if (str34 == null) {
                        if (r21 != 0) {
                            str36 = null;
                        } else {
                            str36 = null;
                        }
                        if (str36 == null) {
                            str35 = str22;
                        } else {
                            str35 = str36;
                        }
                    } else {
                        str35 = str34;
                    }
                }
                num16 = (Integer) linkedHashMap.get(Boxing.boxInt(1));
                if (num16 != null) {
                    iIntValue = num16.intValue();
                } else {
                    iIntValue = 0;
                }
                i7 = iIntValue;
                num17 = num8;
                str37 = str22;
                str38 = str30;
                stringData = streamPlayAnime.toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), num13, num15, str22, num17, null, true, null, null, null, str30, null, null, false, false, false, false, Boxing.boxInt(i7), num6, 16633983, null));
                if (list.isEmpty()) {
                    list4 = list;
                    arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                    i18 = 0;
                    while (r37.hasNext()) {
                        int i21113 = i18 + 1;
                        if (i18 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ArrayList arrayList1111113 = arrayList12;
                        LinkedHashMap linkedHashMap117 = linkedHashMap;
                        StreamPlayKitsuHelper.KitsuVideo kitsuVideo12 = (StreamPlayKitsuHelper.KitsuVideo) obj8;
                        i19 = i18;
                        episode2 = kitsuVideo12.getEpisode();
                        if (episode2 != null) {
                            iIntValue3 = episode2.intValue();
                        } else {
                            iIntValue3 = i19 + 1;
                        }
                        CharSequence charSequence13 = charSequence;
                        List<StreamPlayKitsuHelper.KitsuVideo> list1118 = list4;
                        LinkedHashMap linkedHashMap118 = linkedHashMap2;
                        String str4113 = str35;
                        arrayList1111113.add(loadFromKitsu$createEpisode(linkedHashMap118, streamPlayAnime, linkedHashMap117, num13, num15, str37, num17, str38, num6, str33, str4113, iIntValue3, kitsuVideo12, false));
                        streamPlayAnime = this;
                        linkedHashMap = linkedHashMap117;
                        str35 = str4113;
                        arrayList12 = arrayList1111113;
                        i18 = i21113;
                        obj5 = obj5;
                        i7 = i7;
                        i4 = i4;
                        linkedHashMap2 = linkedHashMap118;
                        list4 = list1118;
                        charSequence = charSequence13;
                    }
                    ArrayList arrayList1111114 = arrayList12;
                    i8 = i7;
                    i9 = i4;
                    linkedHashMap4 = linkedHashMap;
                    charSequence2 = charSequence;
                    num18 = num15;
                    num19 = num17;
                    linkedHashMap3 = linkedHashMap2;
                    str39 = str35;
                    num20 = num13;
                    arrayList2 = arrayList1111114;
                    i11 = 10;
                } else {
                    i8 = i7;
                    i9 = i4;
                    linkedHashMap3 = linkedHashMap2;
                    linkedHashMap4 = linkedHashMap;
                    charSequence2 = charSequence;
                    num18 = num15;
                    num19 = num17;
                    i10 = i6;
                    str39 = str35;
                    num20 = num13;
                    intRange2 = new IntRange(1, i10);
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
                    it = intRange2.iterator();
                    while (it.hasNext()) {
                        ArrayList arrayList1111115 = arrayList;
                        arrayList1111115.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, it.nextInt(), null, false));
                        i10 = i10;
                        arrayList = arrayList1111115;
                        intRange2 = intRange2;
                    }
                    i6 = i10;
                    i11 = 10;
                    arrayList2 = arrayList;
                }
                arrayList3 = arrayList2;
                arrayList4 = arrayList3;
                arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, i11));
                i12 = 0;
                while (r32.hasNext()) {
                    int i21114 = i12 + 1;
                    if (i12 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    List<StreamPlayKitsuHelper.KitsuVideo> list1119 = list;
                    kitsuVideo = (StreamPlayKitsuHelper.KitsuVideo) CollectionsKt.getOrNull(list1119, i12);
                    if (kitsuVideo != null) {
                        iIntValue2 = i12 + 1;
                    } else {
                        iIntValue2 = i12 + 1;
                    }
                    list = list1119;
                    arrayList5.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, iIntValue2, kitsuVideo, true));
                    i12 = i21114;
                    arrayList4 = arrayList4;
                }
                linkedHashMap5 = linkedHashMap3;
                linkedHashMap6 = linkedHashMap4;
                num21 = num6;
                str40 = str33;
                str41 = str39;
                arrayList6 = arrayList5;
                imdbRating = kitsuMeta6.getImdbRating();
                if (imdbRating != null) {
                    iFloatValue = 0;
                } else {
                    iFloatValue = 0;
                }
                links = kitsuMeta6.getLinks();
                if (links != null) {
                    list3 = links;
                    arrayList8 = new ArrayList();
                    while (r10.hasNext()) {
                        ArrayList arrayList1111116 = arrayList6;
                        List<StreamPlayKitsuHelper.KitsuLink> list11110 = list3;
                        if (StringsKt.equals(((StreamPlayKitsuHelper.KitsuLink) obj10).getCategory(), "Franchise", true)) {
                            arrayList8.add(obj10);
                        }
                        arrayList6 = arrayList1111116;
                        list3 = list11110;
                    }
                    arrayList7 = arrayList6;
                    arrayList9 = arrayList8;
                    i16 = 0;
                    arrayList10 = new ArrayList();
                    while (r11.hasNext()) {
                        name2 = kitsuLink.getName();
                        if (name2 == null) {
                            arrayList11 = arrayList9;
                            i17 = i16;
                            num24 = num20;
                            num25 = num18;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        } else {
                            arrayList11 = arrayList9;
                            url2 = kitsuLink.getUrl();
                            if (url2 != null) {
                                i17 = i16;
                                num24 = num20;
                                num25 = num18;
                                strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                if (strSubstringAfterLast$default == null) {
                                    animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                }
                            } else {
                                i17 = i16;
                                num24 = num20;
                                num25 = num18;
                            }
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        }
                        if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                            arrayList10.add(animeSearchResponseNewAnimeSearchResponse$default);
                        }
                        arrayList9 = arrayList11;
                        i16 = i17;
                        num20 = num24;
                        num18 = num25;
                    }
                    num22 = num20;
                    num23 = num18;
                    list2 = arrayList10;
                } else {
                    arrayList7 = arrayList6;
                    num22 = num20;
                    num23 = num18;
                    list2 = null;
                }
                i13 = i9;
                if (i13 != 0) {
                    TvType tvType1113 = TvType.AnimeMovie;
                    Integer num211117 = num19;
                    C00872 c008712 = new C00872(num22, num23, str20, num211117, kitsuMeta6, str32, url, str18, iFloatValue, null);
                    C00861 c00861115 = c00863;
                    c00861115.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                    c00861115.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                    c00861115.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                    c00861115.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                    c00861115.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                    c00861115.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                    c00861115.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c00861115.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                    c00861115.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                    c00861115.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                    c00861115.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                    c00861115.L$11 = SpillingKt.nullOutSpilledVariable(num211117);
                    c00861115.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                    c00861115.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                    c00861115.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                    c00861115.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c00861115.L$16 = SpillingKt.nullOutSpilledVariable(num22);
                    c00861115.L$17 = SpillingKt.nullOutSpilledVariable(num23);
                    c00861115.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                    c00861115.L$19 = SpillingKt.nullOutSpilledVariable(url);
                    c00861115.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                    c00861115.L$21 = SpillingKt.nullOutSpilledVariable(list);
                    c00861115.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                    c00861115.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                    c00861115.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                    c00861115.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                    c00861115.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                    c00861115.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c00861115.L$28 = SpillingKt.nullOutSpilledVariable(arrayList7);
                    c00861115.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                    c00861115.I$0 = i13;
                    c00861115.I$1 = i6;
                    c00861115.I$2 = i8;
                    c00861115.I$3 = iFloatValue;
                    c00861115.label = 8;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str37, str17, tvType1113, stringData, c008712, c00861115);
                    obj4 = obj2;
                    if (objNewMovieLoadResponse == obj4) {
                        return obj4;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                Integer num211118 = num19;
                obj3 = obj2;
                C00861 c00861116 = c00863;
                Integer num211119 = num22;
                Integer num311 = num23;
                i14 = iFloatValue;
                TvType tvType1114 = TvType.Anime;
                ArrayList arrayList1111117 = arrayList7;
                C00883 c008813 = new C00883(num211119, num311, str20, arrayList3, arrayList1111117, str18, num211118, kitsuMeta6, str32, url, i14, this, list2, null);
                c00861116.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                c00861116.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                c00861116.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                c00861116.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                c00861116.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                c00861116.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                c00861116.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                c00861116.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                c00861116.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                c00861116.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                c00861116.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                c00861116.L$11 = SpillingKt.nullOutSpilledVariable(num211118);
                c00861116.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                c00861116.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                c00861116.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                c00861116.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                c00861116.L$16 = SpillingKt.nullOutSpilledVariable(num211119);
                c00861116.L$17 = SpillingKt.nullOutSpilledVariable(num311);
                c00861116.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                c00861116.L$19 = SpillingKt.nullOutSpilledVariable(url);
                c00861116.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                c00861116.L$21 = SpillingKt.nullOutSpilledVariable(list);
                c00861116.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                c00861116.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                c00861116.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                c00861116.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                c00861116.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                c00861116.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                c00861116.L$28 = SpillingKt.nullOutSpilledVariable(arrayList1111117);
                c00861116.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                c00861116.I$0 = i13;
                c00861116.I$1 = i6;
                c00861116.I$2 = i8;
                c00861116.I$3 = i14;
                c00861116.label = 9;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, str37, str17, tvType1114, false, c008813, c00861116, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj3) {
                    return obj3;
                }
                str42 = str21;
                str43 = stringData;
                i15 = i14;
                obj5 = objNewAnimeLoadResponse$default;
                return (LoadResponse) obj5;
            case 7:
                int i31 = c00864.I$0;
                Integer num43 = (Integer) c00864.L$14;
                num12 = (Integer) c00864.L$13;
                String str55 = (String) c00864.L$12;
                num8 = (Integer) c00864.L$11;
                String str56 = (String) c00864.L$10;
                tvType11 = (TvType) c00864.L$9;
                tvType10 = (TvType) c00864.L$8;
                str24 = (String) c00864.L$7;
                Integer num44 = (Integer) c00864.L$6;
                r110 = (MetaAnimeData) c00864.L$5;
                str27 = (String) c00864.L$4;
                num11 = (Integer) c00864.L$3;
                kitsuMeta7 = (StreamPlayKitsuHelper.KitsuMeta) c00864.L$2;
                str28 = (String) c00864.L$1;
                str25 = (String) c00864.L$0;
                ResultKt.throwOnFailure(obj5);
                malId = num43;
                c00862 = c00864;
                str26 = str55;
                str23 = str56;
                i4 = i31;
                r17 = num44;
                charSequence = "kitsu:";
                objTmdbToAnimeId = obj5;
                aniIds = (AniIds) objTmdbToAnimeId;
                tvType8 = tvType11;
                str18 = str26;
                tvType9 = tvType10;
                r23 = r17;
                str20 = str24;
                num6 = num11;
                kitsuMeta6 = kitsuMeta7;
                str21 = str28;
                num9 = num12;
                r21 = r110;
                str19 = str27;
                str17 = str25;
                str22 = str23;
                num10 = malId;
                aniIds2 = aniIds;
                id = aniIds2.getId();
                if (id == null) {
                    num13 = num9;
                } else {
                    num13 = id;
                }
                idMal = aniIds2.getIdMal();
                if (idMal == null) {
                    num14 = num10;
                } else {
                    num14 = idMal;
                }
                if (r21 != 0) {
                    if (r21 != 0) {
                        str29 = null;
                    } else {
                        str29 = null;
                    }
                    if (str29 != null) {
                        str30 = str29;
                    } else {
                        aliases2 = kitsuMeta6.getAliases();
                        if (aliases2 != null) {
                            str29 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str29 = null;
                        }
                        if (str29 == null) {
                            str30 = str22;
                        } else {
                            str30 = str29;
                        }
                    }
                } else {
                    if (r21 != 0) {
                        str29 = null;
                    } else {
                        str29 = null;
                    }
                    if (str29 != null) {
                        str30 = str29;
                    } else {
                        aliases2 = kitsuMeta6.getAliases();
                        if (aliases2 != null) {
                            str29 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str29 = null;
                        }
                        if (str29 == null) {
                            str30 = str22;
                        } else {
                            str30 = str29;
                        }
                    }
                }
                poster = kitsuMeta6.getPoster();
                if (poster != null) {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = poster;
                } else if (r21 != 0) {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = null;
                } else {
                    obj2 = coroutine_suspended;
                    num15 = num14;
                    c00863 = c00862;
                    url = null;
                }
                background = kitsuMeta6.getBackground();
                if (background != null) {
                    str31 = background;
                } else {
                    if (r21 != 0) {
                        list6 = images2;
                        it2 = list6.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                next = it2.next();
                                list7 = list6;
                                if (StringsKt.equals(((ImageData) next).getCoverType(), "Fanart", true)) {
                                    list6 = list7;
                                }
                            } else {
                                next = null;
                            }
                        }
                        imageData2 = (ImageData) next;
                        if (imageData2 != null) {
                            background = imageData2.getUrl();
                            str31 = background;
                        }
                    }
                    str31 = null;
                }
                str32 = str31;
                videos = kitsuMeta6.getVideos();
                if (videos == null) {
                    videos = CollectionsKt.emptyList();
                }
                if (!videos.isEmpty()) {
                    size = videos.size();
                } else if (r21 != 0) {
                    size = 1;
                } else {
                    size = 1;
                }
                Iterable intRange14 = new IntRange(1, size);
                linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange14, 10)), 16));
                while (r31.hasNext()) {
                    iIntValue5 = ((Number) obj6).intValue();
                    if (str19 != null) {
                        list5 = videos;
                        Integer anidbEid12 = StreamPlayUtilsKt.getAnidbEid(str19, Boxing.boxInt(iIntValue5));
                        if (anidbEid12 != null) {
                        }
                        linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                        videos = list5;
                    } else {
                        list5 = videos;
                    }
                    linkedHashMap.put(obj6, Boxing.boxInt(iIntValue6));
                    videos = list5;
                }
                list = videos;
                intRange = new IntRange(1, size);
                i5 = 0;
                linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange, 10)), 16));
                while (r27.hasNext()) {
                    Iterable iterable12 = intRange;
                    iIntValue4 = ((Number) obj7).intValue();
                    if (r21 != 0) {
                        i20 = size;
                        episodes3 = r21.getEpisodes();
                        if (episodes3 != null) {
                            i5 = i5;
                            metaEpisode = episodes3.get(String.valueOf(iIntValue4));
                        }
                        linkedHashMap2.put(obj7, metaEpisode);
                        intRange = iterable12;
                        size = i20;
                        i5 = i5;
                    } else {
                        i20 = size;
                    }
                    metaEpisode = null;
                    linkedHashMap2.put(obj7, metaEpisode);
                    intRange = iterable12;
                    size = i20;
                    i5 = i5;
                }
                i6 = size;
                if (url == null) {
                    if (r21 != 0) {
                        url3 = null;
                    } else {
                        url3 = null;
                    }
                    if (url3 == null) {
                        url3 = "";
                    }
                    str33 = url3;
                } else {
                    str33 = url;
                }
                if (r21 != 0) {
                    if (r21 != 0) {
                        str34 = null;
                    } else {
                        str34 = null;
                    }
                    if (str34 == null) {
                        if (r21 != 0) {
                            str36 = null;
                        } else {
                            str36 = null;
                        }
                        if (str36 == null) {
                            str35 = str22;
                        } else {
                            str35 = str36;
                        }
                    } else {
                        str35 = str34;
                    }
                } else {
                    if (r21 != 0) {
                        str34 = null;
                    } else {
                        str34 = null;
                    }
                    if (str34 == null) {
                        if (r21 != 0) {
                            str36 = null;
                        } else {
                            str36 = null;
                        }
                        if (str36 == null) {
                            str35 = str22;
                        } else {
                            str35 = str36;
                        }
                    } else {
                        str35 = str34;
                    }
                }
                num16 = (Integer) linkedHashMap.get(Boxing.boxInt(1));
                if (num16 != null) {
                    iIntValue = num16.intValue();
                } else {
                    iIntValue = 0;
                }
                i7 = iIntValue;
                num17 = num8;
                str37 = str22;
                str38 = str30;
                stringData = streamPlayAnime.toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), num13, num15, str22, num17, null, true, null, null, null, str30, null, null, false, false, false, false, Boxing.boxInt(i7), num6, 16633983, null));
                if (list.isEmpty()) {
                    list4 = list;
                    arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                    i18 = 0;
                    while (r37.hasNext()) {
                        int i21115 = i18 + 1;
                        if (i18 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ArrayList arrayList1111118 = arrayList12;
                        LinkedHashMap linkedHashMap119 = linkedHashMap;
                        StreamPlayKitsuHelper.KitsuVideo kitsuVideo13 = (StreamPlayKitsuHelper.KitsuVideo) obj8;
                        i19 = i18;
                        episode2 = kitsuVideo13.getEpisode();
                        if (episode2 != null) {
                            iIntValue3 = episode2.intValue();
                        } else {
                            iIntValue3 = i19 + 1;
                        }
                        CharSequence charSequence14 = charSequence;
                        List<StreamPlayKitsuHelper.KitsuVideo> list11111 = list4;
                        LinkedHashMap linkedHashMap1110 = linkedHashMap2;
                        String str4114 = str35;
                        arrayList1111118.add(loadFromKitsu$createEpisode(linkedHashMap1110, streamPlayAnime, linkedHashMap119, num13, num15, str37, num17, str38, num6, str33, str4114, iIntValue3, kitsuVideo13, false));
                        streamPlayAnime = this;
                        linkedHashMap = linkedHashMap119;
                        str35 = str4114;
                        arrayList12 = arrayList1111118;
                        i18 = i21115;
                        obj5 = obj5;
                        i7 = i7;
                        i4 = i4;
                        linkedHashMap2 = linkedHashMap1110;
                        list4 = list11111;
                        charSequence = charSequence14;
                    }
                    ArrayList arrayList1111119 = arrayList12;
                    i8 = i7;
                    i9 = i4;
                    linkedHashMap4 = linkedHashMap;
                    charSequence2 = charSequence;
                    num18 = num15;
                    num19 = num17;
                    linkedHashMap3 = linkedHashMap2;
                    str39 = str35;
                    num20 = num13;
                    arrayList2 = arrayList1111119;
                    i11 = 10;
                } else {
                    i8 = i7;
                    i9 = i4;
                    linkedHashMap3 = linkedHashMap2;
                    linkedHashMap4 = linkedHashMap;
                    charSequence2 = charSequence;
                    num18 = num15;
                    num19 = num17;
                    i10 = i6;
                    str39 = str35;
                    num20 = num13;
                    intRange2 = new IntRange(1, i10);
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
                    it = intRange2.iterator();
                    while (it.hasNext()) {
                        ArrayList arrayList11111110 = arrayList;
                        arrayList11111110.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, it.nextInt(), null, false));
                        i10 = i10;
                        arrayList = arrayList11111110;
                        intRange2 = intRange2;
                    }
                    i6 = i10;
                    i11 = 10;
                    arrayList2 = arrayList;
                }
                arrayList3 = arrayList2;
                arrayList4 = arrayList3;
                arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, i11));
                i12 = 0;
                while (r32.hasNext()) {
                    int i21116 = i12 + 1;
                    if (i12 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    List<StreamPlayKitsuHelper.KitsuVideo> list11112 = list;
                    kitsuVideo = (StreamPlayKitsuHelper.KitsuVideo) CollectionsKt.getOrNull(list11112, i12);
                    if (kitsuVideo != null) {
                        iIntValue2 = i12 + 1;
                    } else {
                        iIntValue2 = i12 + 1;
                    }
                    list = list11112;
                    arrayList5.add(loadFromKitsu$createEpisode(linkedHashMap3, this, linkedHashMap4, num20, num18, str37, num19, str38, num6, str33, str39, iIntValue2, kitsuVideo, true));
                    i12 = i21116;
                    arrayList4 = arrayList4;
                }
                linkedHashMap5 = linkedHashMap3;
                linkedHashMap6 = linkedHashMap4;
                num21 = num6;
                str40 = str33;
                str41 = str39;
                arrayList6 = arrayList5;
                imdbRating = kitsuMeta6.getImdbRating();
                if (imdbRating != null) {
                    iFloatValue = 0;
                } else {
                    iFloatValue = 0;
                }
                links = kitsuMeta6.getLinks();
                if (links != null) {
                    list3 = links;
                    arrayList8 = new ArrayList();
                    while (r10.hasNext()) {
                        ArrayList arrayList11111111 = arrayList6;
                        List<StreamPlayKitsuHelper.KitsuLink> list11113 = list3;
                        if (StringsKt.equals(((StreamPlayKitsuHelper.KitsuLink) obj10).getCategory(), "Franchise", true)) {
                            arrayList8.add(obj10);
                        }
                        arrayList6 = arrayList11111111;
                        list3 = list11113;
                    }
                    arrayList7 = arrayList6;
                    arrayList9 = arrayList8;
                    i16 = 0;
                    arrayList10 = new ArrayList();
                    while (r11.hasNext()) {
                        name2 = kitsuLink.getName();
                        if (name2 == null) {
                            arrayList11 = arrayList9;
                            i17 = i16;
                            num24 = num20;
                            num25 = num18;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        } else {
                            arrayList11 = arrayList9;
                            url2 = kitsuLink.getUrl();
                            if (url2 != null) {
                                i17 = i16;
                                num24 = num20;
                                num25 = num18;
                                strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                if (strSubstringAfterLast$default == null) {
                                    animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                }
                            } else {
                                i17 = i16;
                                num24 = num20;
                                num25 = num18;
                            }
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        }
                        if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                            arrayList10.add(animeSearchResponseNewAnimeSearchResponse$default);
                        }
                        arrayList9 = arrayList11;
                        i16 = i17;
                        num20 = num24;
                        num18 = num25;
                    }
                    num22 = num20;
                    num23 = num18;
                    list2 = arrayList10;
                } else {
                    arrayList7 = arrayList6;
                    num22 = num20;
                    num23 = num18;
                    list2 = null;
                }
                i13 = i9;
                if (i13 != 0) {
                    TvType tvType1115 = TvType.AnimeMovie;
                    Integer num2111110 = num19;
                    C00872 c008713 = new C00872(num22, num23, str20, num2111110, kitsuMeta6, str32, url, str18, iFloatValue, null);
                    C00861 c00861117 = c00863;
                    c00861117.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                    c00861117.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                    c00861117.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                    c00861117.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                    c00861117.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                    c00861117.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                    c00861117.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c00861117.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                    c00861117.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                    c00861117.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                    c00861117.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                    c00861117.L$11 = SpillingKt.nullOutSpilledVariable(num2111110);
                    c00861117.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                    c00861117.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                    c00861117.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                    c00861117.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c00861117.L$16 = SpillingKt.nullOutSpilledVariable(num22);
                    c00861117.L$17 = SpillingKt.nullOutSpilledVariable(num23);
                    c00861117.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                    c00861117.L$19 = SpillingKt.nullOutSpilledVariable(url);
                    c00861117.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                    c00861117.L$21 = SpillingKt.nullOutSpilledVariable(list);
                    c00861117.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                    c00861117.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                    c00861117.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                    c00861117.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                    c00861117.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                    c00861117.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c00861117.L$28 = SpillingKt.nullOutSpilledVariable(arrayList7);
                    c00861117.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                    c00861117.I$0 = i13;
                    c00861117.I$1 = i6;
                    c00861117.I$2 = i8;
                    c00861117.I$3 = iFloatValue;
                    c00861117.label = 8;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str37, str17, tvType1115, stringData, c008713, c00861117);
                    obj4 = obj2;
                    if (objNewMovieLoadResponse == obj4) {
                        return obj4;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                Integer num2111111 = num19;
                obj3 = obj2;
                C00861 c00861118 = c00863;
                Integer num2111112 = num22;
                Integer num312 = num23;
                i14 = iFloatValue;
                TvType tvType1116 = TvType.Anime;
                ArrayList arrayList11111112 = arrayList7;
                C00883 c008814 = new C00883(num2111112, num312, str20, arrayList3, arrayList11111112, str18, num2111111, kitsuMeta6, str32, url, i14, this, list2, null);
                c00861118.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                c00861118.L$1 = SpillingKt.nullOutSpilledVariable(str21);
                c00861118.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta6);
                c00861118.L$3 = SpillingKt.nullOutSpilledVariable(num21);
                c00861118.L$4 = SpillingKt.nullOutSpilledVariable(str19);
                c00861118.L$5 = SpillingKt.nullOutSpilledVariable((Object) r21);
                c00861118.L$6 = SpillingKt.nullOutSpilledVariable((Object) r23);
                c00861118.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                c00861118.L$8 = SpillingKt.nullOutSpilledVariable(tvType9);
                c00861118.L$9 = SpillingKt.nullOutSpilledVariable(tvType8);
                c00861118.L$10 = SpillingKt.nullOutSpilledVariable(str37);
                c00861118.L$11 = SpillingKt.nullOutSpilledVariable(num2111111);
                c00861118.L$12 = SpillingKt.nullOutSpilledVariable(str18);
                c00861118.L$13 = SpillingKt.nullOutSpilledVariable(num9);
                c00861118.L$14 = SpillingKt.nullOutSpilledVariable(num10);
                c00861118.L$15 = SpillingKt.nullOutSpilledVariable(aniIds2);
                c00861118.L$16 = SpillingKt.nullOutSpilledVariable(num2111112);
                c00861118.L$17 = SpillingKt.nullOutSpilledVariable(num312);
                c00861118.L$18 = SpillingKt.nullOutSpilledVariable(str38);
                c00861118.L$19 = SpillingKt.nullOutSpilledVariable(url);
                c00861118.L$20 = SpillingKt.nullOutSpilledVariable(str32);
                c00861118.L$21 = SpillingKt.nullOutSpilledVariable(list);
                c00861118.L$22 = SpillingKt.nullOutSpilledVariable(linkedHashMap6);
                c00861118.L$23 = SpillingKt.nullOutSpilledVariable(linkedHashMap5);
                c00861118.L$24 = SpillingKt.nullOutSpilledVariable(str40);
                c00861118.L$25 = SpillingKt.nullOutSpilledVariable(str41);
                c00861118.L$26 = SpillingKt.nullOutSpilledVariable(stringData);
                c00861118.L$27 = SpillingKt.nullOutSpilledVariable(arrayList3);
                c00861118.L$28 = SpillingKt.nullOutSpilledVariable(arrayList11111112);
                c00861118.L$29 = SpillingKt.nullOutSpilledVariable(list2);
                c00861118.I$0 = i13;
                c00861118.I$1 = i6;
                c00861118.I$2 = i8;
                c00861118.I$3 = i14;
                c00861118.label = 9;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, str37, str17, tvType1116, false, c008814, c00861118, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj3) {
                    return obj3;
                }
                str42 = str21;
                str43 = stringData;
                i15 = i14;
                obj5 = objNewAnimeLoadResponse$default;
                return (LoadResponse) obj5;
            case 8:
                int i32 = c00864.I$3;
                int i33 = c00864.I$2;
                int i34 = c00864.I$1;
                int i35 = c00864.I$0;
                ResultKt.throwOnFailure(obj5);
                objNewMovieLoadResponse = obj5;
                return (LoadResponse) objNewMovieLoadResponse;
            case 9:
                int i36 = c00864.I$3;
                int i37 = c00864.I$2;
                int i38 = c00864.I$1;
                int i39 = c00864.I$0;
                str43 = (String) c00864.L$26;
                i15 = i36;
                str42 = (String) c00864.L$1;
                ResultKt.throwOnFailure(obj5);
                return (LoadResponse) obj5;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final String loadFromKitsu$resolveTitle(String fallbackTitle, MetaEpisode epData, StreamPlayKitsuHelper.KitsuVideo video) {
        String jsonTitle;
        Map<String, String> title;
        Map<String, String> title2;
        Object episode;
        Map<String, String> title3;
        if (epData == null || (title3 = epData.getTitle()) == null || (jsonTitle = title3.get("en")) == null) {
            jsonTitle = (epData == null || (title2 = epData.getTitle()) == null) ? null : title2.get("ja");
            if (jsonTitle == null) {
                jsonTitle = (epData == null || (title = epData.getTitle()) == null) ? null : title.get("x-jat");
                if (jsonTitle == null) {
                    jsonTitle = video != null ? video.getTitle() : null;
                    if (jsonTitle == null) {
                        jsonTitle = fallbackTitle;
                    }
                }
            }
        }
        String string = jsonTitle;
        if (StringsKt.isBlank(string)) {
            StringBuilder sbAppend = new StringBuilder().append("Episode ");
            if (video == null || (episode = video.getEpisode()) == null) {
                String episode2 = epData != null ? epData.getEpisode() : null;
                episode = episode2 == null ? "" : episode2;
            }
            string = sbAppend.append(episode).toString();
        }
        return string;
    }

    private static final Episode loadFromKitsu$createEpisode(Map<Integer, MetaEpisode> map, StreamPlayAnime this$0, Map<Integer, Integer> map2, Integer finalAniId, Integer finalMalId, String anititle, Integer aniyear, String jpTitle, Integer numericKitsuId, final String fallbackPoster, final String fallbackTitle, int i, final StreamPlayKitsuHelper.KitsuVideo video, boolean isDub) {
        Integer season;
        Integer episode;
        final MetaEpisode epData = map.get(Integer.valueOf(i));
        final int epNum = (video == null || (episode = video.getEpisode()) == null) ? i : episode.intValue();
        final int seasonNum = (video == null || (season = video.getSeason()) == null) ? 1 : season.intValue();
        Integer num = map2.get(Integer.valueOf(i));
        String linkData = this$0.toStringData(new LinkData(null, null, null, null, null, null, Integer.valueOf(seasonNum), Integer.valueOf(epNum), finalAniId, finalMalId, anititle, aniyear, null, true, null, null, null, jpTitle, null, null, false, false, false, isDub, Integer.valueOf(num != null ? num.intValue() : 0), numericKitsuId, 8245311, null));
        return MainAPIKt.newEpisode(this$0, linkData, new Function1() { // from class: com.phisher98.StreamPlayAnime$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return StreamPlayAnime.loadFromKitsu$createEpisode$lambda$6(seasonNum, epNum, epData, video, fallbackPoster, fallbackTitle, (Episode) obj);
            }
        });
    }

    static final Unit loadFromKitsu$createEpisode$lambda$6(int $seasonNum, int $epNum, MetaEpisode $epData, StreamPlayKitsuHelper.KitsuVideo $video, String $fallbackPoster, String $fallbackTitle, Episode $this$newEpisode) {
        String image;
        String overview;
        String airdate;
        $this$newEpisode.setSeason(Integer.valueOf($seasonNum));
        $this$newEpisode.setEpisode(Integer.valueOf($epNum));
        $this$newEpisode.setName(loadFromKitsu$resolveTitle($fallbackTitle, $epData, $video));
        if ($video == null || (image = $video.getThumbnail()) == null) {
            image = $epData != null ? $epData.getImage() : null;
            if (image == null) {
                image = $fallbackPoster;
            }
        }
        $this$newEpisode.setPosterUrl(image);
        if ($video == null || (overview = $video.getOverview()) == null) {
            overview = $epData != null ? $epData.getOverview() : null;
            if (overview == null) {
                overview = "No summary available";
            }
        }
        $this$newEpisode.setDescription(overview);
        $this$newEpisode.setScore(Score.Companion.from10($epData != null ? $epData.getRating() : null));
        $this$newEpisode.setRunTime($epData != null ? $epData.getRuntime() : null);
        if ($video == null || (airdate = $video.getReleased()) == null) {
            airdate = $epData != null ? $epData.getAirdate() : null;
        }
        MainAPIKt.addDate$default($this$newEpisode, airdate, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadFromKitsu$2 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadFromKitsu$2", f = "StreamPlayAnime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayAnime.kt\ncom/phisher98/StreamPlayAnime$loadFromKitsu$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,781:1\n1#2:782\n*E\n"})
    static final class C00872 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $aniyear;
        final /* synthetic */ String $backgroundUrl;
        final /* synthetic */ Integer $finalAniId;
        final /* synthetic */ Integer $finalMalId;
        final /* synthetic */ StreamPlayKitsuHelper.KitsuMeta $kitsuMeta;
        final /* synthetic */ String $kitsuid;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ String $posterurl;
        final /* synthetic */ int $scoreValue;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00872(Integer num, Integer num2, String str, Integer num3, StreamPlayKitsuHelper.KitsuMeta kitsuMeta, String str2, String str3, String str4, int i, Continuation<? super C00872> continuation) {
            super(2, continuation);
            this.$finalAniId = num;
            this.$finalMalId = num2;
            this.$kitsuid = str;
            this.$aniyear = num3;
            this.$kitsuMeta = kitsuMeta;
            this.$backgroundUrl = str2;
            this.$posterurl = str3;
            this.$logoUrl = str4;
            this.$scoreValue = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00872 = new C00872(this.$finalAniId, this.$finalMalId, this.$kitsuid, this.$aniyear, this.$kitsuMeta, this.$backgroundUrl, this.$posterurl, this.$logoUrl, this.$scoreValue, continuation);
            c00872.L$0 = obj;
            return c00872;
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
                    Integer num = this.$finalAniId;
                    if (num != null) {
                        int it = num.intValue();
                        LoadResponse.Companion.addAniListId(loadResponse, Boxing.boxInt(it));
                    }
                    Integer num2 = this.$finalMalId;
                    if (num2 != null) {
                        int it2 = num2.intValue();
                        LoadResponse.Companion.addMalId(loadResponse, Boxing.boxInt(it2));
                    }
                    try {
                        LoadResponse.Companion.addKitsuId(loadResponse, this.$kitsuid);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setYear(this.$aniyear);
                    loadResponse.setPlot(this.$kitsuMeta.getDescription());
                    loadResponse.setBackgroundPosterUrl(this.$backgroundUrl);
                    loadResponse.setPosterUrl(this.$posterurl);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th2) {
                    }
                    loadResponse.setTags(this.$kitsuMeta.getGenres());
                    loadResponse.setScore(Score.Companion.from100(Boxing.boxInt(this.$scoreValue)));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadFromKitsu$3 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadFromKitsu$3", f = "StreamPlayAnime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayAnime.kt\ncom/phisher98/StreamPlayAnime$loadFromKitsu$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,781:1\n1#2:782\n*E\n"})
    static final class C00883 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $aniyear;
        final /* synthetic */ String $backgroundUrl;
        final /* synthetic */ List<Episode> $episodes;
        final /* synthetic */ List<Episode> $episodesDub;
        final /* synthetic */ Integer $finalAniId;
        final /* synthetic */ Integer $finalMalId;
        final /* synthetic */ StreamPlayKitsuHelper.KitsuMeta $kitsuMeta;
        final /* synthetic */ String $kitsuid;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ String $posterurl;
        final /* synthetic */ List<AnimeSearchResponse> $recs;
        final /* synthetic */ int $scoreValue;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ StreamPlayAnime this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00883(Integer num, Integer num2, String str, List<Episode> list, List<Episode> list2, String str2, Integer num3, StreamPlayKitsuHelper.KitsuMeta kitsuMeta, String str3, String str4, int i, StreamPlayAnime streamPlayAnime, List<AnimeSearchResponse> list3, Continuation<? super C00883> continuation) {
            super(2, continuation);
            this.$finalAniId = num;
            this.$finalMalId = num2;
            this.$kitsuid = str;
            this.$episodes = list;
            this.$episodesDub = list2;
            this.$logoUrl = str2;
            this.$aniyear = num3;
            this.$kitsuMeta = kitsuMeta;
            this.$backgroundUrl = str3;
            this.$posterurl = str4;
            this.$scoreValue = i;
            this.this$0 = streamPlayAnime;
            this.$recs = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00883 = new C00883(this.$finalAniId, this.$finalMalId, this.$kitsuid, this.$episodes, this.$episodesDub, this.$logoUrl, this.$aniyear, this.$kitsuMeta, this.$backgroundUrl, this.$posterurl, this.$scoreValue, this.this$0, this.$recs, continuation);
            c00883.L$0 = obj;
            return c00883;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (AnimeLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Integer num = this.$finalAniId;
                    if (num != null) {
                        int it = num.intValue();
                        LoadResponse.Companion.addAniListId(loadResponse, Boxing.boxInt(it));
                    }
                    Integer num2 = this.$finalMalId;
                    if (num2 != null) {
                        int it2 = num2.intValue();
                        LoadResponse.Companion.addMalId(loadResponse, Boxing.boxInt(it2));
                    }
                    try {
                        LoadResponse.Companion.addKitsuId(loadResponse, this.$kitsuid);
                        break;
                    } catch (Throwable th) {
                    }
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$episodes);
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Dubbed, this.$episodesDub);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th2) {
                    }
                    loadResponse.setYear(this.$aniyear);
                    loadResponse.setPlot(this.$kitsuMeta.getDescription());
                    loadResponse.setBackgroundPosterUrl(this.$backgroundUrl);
                    loadResponse.setPosterUrl(this.$posterurl);
                    loadResponse.setTags(this.$kitsuMeta.getGenres());
                    loadResponse.setScore(Score.Companion.from100(Boxing.boxInt(this.$scoreValue)));
                    loadResponse.setShowStatus(this.this$0.getStatus(this.$kitsuMeta.getStatus()));
                    List<AnimeSearchResponse> list = this.$recs;
                    if (!(list == null || list.isEmpty())) {
                        loadResponse.setRecommendations(this.$recs);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0507  */
    /* JADX WARN: Code duplicated, block: B:116:0x051d  */
    /* JADX WARN: Code duplicated, block: B:120:0x054c  */
    /* JADX WARN: Code duplicated, block: B:130:0x0577  */
    /* JADX WARN: Code duplicated, block: B:133:0x0581  */
    /* JADX WARN: Code duplicated, block: B:134:0x0585  */
    /* JADX WARN: Code duplicated, block: B:136:0x058b  */
    /* JADX WARN: Code duplicated, block: B:137:0x058f  */
    /* JADX WARN: Code duplicated, block: B:140:0x06d4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:141:0x06d5  */
    /* JADX WARN: Code duplicated, block: B:67:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:68:0x031b  */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Code duplicated, block: B:91:0x040b  */
    /* JADX WARN: Code duplicated, block: B:92:0x0425  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v52, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r17v3, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r29v13 */
    @Nullable
    public Object loadLinks(@NotNull String str, boolean z, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00891 c00891;
        Object obj;
        Object obj2;
        Object objDecodeFromString;
        Integer kitsuId;
        Object obj3;
        boolean z2;
        MALSyncSites mALSyncSites;
        char c;
        String str2;
        Integer num;
        Integer num2;
        char c2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Integer num3;
        Integer num4;
        MALSyncSites sites;
        Integer num5;
        String str3;
        boolean z3;
        LinkData linkData;
        String str4;
        boolean z4;
        Integer num6;
        Integer num7;
        Integer num8;
        Integer num9;
        String str5;
        Integer num10;
        Function1<? super ExtractorLink, Unit> function5;
        String str6;
        boolean z5;
        Integer num11;
        Integer num12;
        Integer num13;
        String str7;
        String str8;
        Integer num14;
        Integer num15;
        Function1<? super ExtractorLink, Unit> function6;
        String str9;
        boolean z6;
        Integer num16;
        Integer num17;
        String str10;
        String str11;
        Integer num18;
        Integer num19;
        Integer num20;
        Function1<? super ExtractorLink, Unit> function7;
        String str12;
        Function1<? super SubtitleFile, Unit> function8;
        String str13;
        Object safe;
        MALSyncResponses mALSyncResponses;
        Function1<? super SubtitleFile, Unit> function9;
        String str14;
        Object safe2;
        MALSyncResponses mALSyncResponses2;
        MALSyncSites mALSyncSites2;
        ?? r12;
        String str15;
        Function1[] function1Arr;
        HashMap<String, HashMap<String, String>> kickAssAnime;
        Collection<HashMap<String, String>> collectionValues;
        Function1<? super SubtitleFile, Unit> function10;
        String str16;
        Object safe3;
        MALSyncResponses mALSyncResponses3;
        Function1<? super SubtitleFile, Unit> function11 = function1;
        if (continuation instanceof C00891) {
            c00891 = (C00891) continuation;
            if ((c00891.label & Integer.MIN_VALUE) != 0) {
                c00891.label -= Integer.MIN_VALUE;
            } else {
                c00891 = new C00891(continuation);
            }
        } else {
            c00891 = new C00891(continuation);
        }
        C00891 c00892 = c00891;
        Object obj4 = c00892.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00892.label) {
            case 0:
                ResultKt.throwOnFailure(obj4);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(LinkData.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    break;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj2 = null;
                        try {
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LinkData.class), (List) null, 2, (Object) null));
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion4 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        obj2 = null;
                    }
                    break;
                } else {
                    obj2 = null;
                }
                if (Result.isFailure-impl(obj)) {
                    obj = obj2;
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<LinkData>() { // from class: com.phisher98.StreamPlayAnime$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th4) {
                        objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<LinkData>() { // from class: com.phisher98.StreamPlayAnime$loadLinks$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<LinkData>() { // from class: com.phisher98.StreamPlayAnime$loadLinks$$inlined$parseJson$1
                    });
                }
                LinkData linkData2 = (LinkData) objDecodeFromString;
                Integer malId = linkData2.getMalId();
                Integer episode = linkData2.getEpisode();
                String jpTitle = linkData2.getJpTitle();
                String title = linkData2.getTitle();
                Integer anidbEid = linkData2.getAnidbEid();
                Integer aniId = linkData2.getAniId();
                Integer year = linkData2.getYear();
                kitsuId = linkData2.getKitsuId();
                if (malId == null) {
                    obj3 = coroutine_suspended;
                    z2 = true;
                    z2 = true;
                    z2 = true;
                    mALSyncSites = null;
                    if (kitsuId != null) {
                        Requests app = MainActivityKt.getApp();
                        String str17 = "https://api.malsync.moe/kitsu/anime/" + kitsuId.intValue();
                        c00892.L$0 = SpillingKt.nullOutSpilledVariable(str);
                        c00892.L$1 = function11;
                        c00892.L$2 = function2;
                        c00892.L$3 = linkData2;
                        c00892.L$4 = malId;
                        c00892.L$5 = episode;
                        c00892.L$6 = jpTitle;
                        c00892.L$7 = title;
                        c00892.L$8 = anidbEid;
                        c00892.L$9 = aniId;
                        c00892.L$10 = year;
                        c00892.L$11 = SpillingKt.nullOutSpilledVariable(kitsuId);
                        c00892.Z$0 = z;
                        c00892.label = 2;
                        c = 2;
                        obj4 = Requests.get$default(app, str17, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00892, 4094, (Object) null);
                        if (obj4 == obj3) {
                            c00892 = c00892;
                            return obj3;
                        }
                        c00892 = c00892;
                        z5 = z;
                        num11 = malId;
                        num12 = aniId;
                        num13 = episode;
                        str7 = jpTitle;
                        str8 = title;
                        num14 = anidbEid;
                        num15 = year;
                        linkData = linkData2;
                        function6 = function2;
                        str9 = str;
                        NiceResponse niceResponse = (NiceResponse) obj4;
                        try {
                            ResponseParser parser = niceResponse.getParser();
                            Intrinsics.checkNotNull(parser);
                            function9 = function11;
                            try {
                                str14 = str9;
                                try {
                                    safe2 = parser.parseSafe(niceResponse.getText(), Reflection.getOrCreateKotlinClass(MALSyncResponses.class));
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    safe2 = mALSyncSites;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                str14 = str9;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            function9 = function11;
                            str14 = str9;
                        }
                        mALSyncResponses2 = (MALSyncResponses) safe2;
                        if (mALSyncResponses2 != null) {
                            num2 = num15;
                            num4 = num12;
                            num = num14;
                            str2 = str7;
                            num5 = num13;
                            num3 = num11;
                            z3 = z5;
                            c2 = 3;
                            function3 = function9;
                            function4 = function6;
                            str3 = str8;
                            sites = mALSyncResponses2.getSites();
                            str4 = str14;
                        } else {
                            str4 = str14;
                            num2 = num15;
                            num4 = num12;
                            num = num14;
                            str2 = str7;
                            num5 = num13;
                            num3 = num11;
                            z3 = z5;
                            c2 = 3;
                            function3 = function9;
                            function4 = function6;
                            str3 = str8;
                            sites = mALSyncSites;
                        }
                    } else {
                        c = 2;
                        if (aniId != null) {
                            Requests app2 = MainActivityKt.getApp();
                            String str18 = "https://api.malsync.moe/anilist/anime/" + aniId.intValue();
                            c00892.L$0 = SpillingKt.nullOutSpilledVariable(str);
                            c00892.L$1 = function11;
                            c00892.L$2 = function2;
                            c00892.L$3 = linkData2;
                            c00892.L$4 = malId;
                            c00892.L$5 = episode;
                            c00892.L$6 = jpTitle;
                            c00892.L$7 = title;
                            c00892.L$8 = anidbEid;
                            c00892.L$9 = aniId;
                            c00892.L$10 = year;
                            c00892.L$11 = SpillingKt.nullOutSpilledVariable(kitsuId);
                            c00892.Z$0 = z;
                            c00892.label = 3;
                            c2 = 3;
                            obj4 = Requests.get$default(app2, str18, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00892, 4094, (Object) null);
                            if (obj4 == obj3) {
                                c00892 = c00892;
                                return obj3;
                            }
                            c00892 = c00892;
                            z4 = z;
                            num6 = malId;
                            num7 = aniId;
                            num8 = year;
                            num9 = episode;
                            str5 = jpTitle;
                            str3 = title;
                            num10 = anidbEid;
                            linkData = linkData2;
                            function5 = function2;
                            str6 = str;
                            NiceResponse niceResponse2 = (NiceResponse) obj4;
                            try {
                                ResponseParser parser2 = niceResponse2.getParser();
                                Intrinsics.checkNotNull(parser2);
                                function10 = function11;
                                try {
                                    str16 = str6;
                                    try {
                                        safe3 = parser2.parseSafe(niceResponse2.getText(), Reflection.getOrCreateKotlinClass(MALSyncResponses.class));
                                    } catch (Exception e5) {
                                        e = e5;
                                        e.printStackTrace();
                                        safe3 = mALSyncSites;
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    str16 = str6;
                                }
                            } catch (Exception e7) {
                                e = e7;
                                function10 = function11;
                                str16 = str6;
                            }
                            mALSyncResponses3 = (MALSyncResponses) safe3;
                            if (mALSyncResponses3 != null) {
                                str2 = str5;
                                num5 = num9;
                                num2 = num8;
                                num3 = num6;
                                num4 = num7;
                                num = num10;
                                z3 = z4;
                                function3 = function10;
                                sites = mALSyncResponses3.getSites();
                                function4 = function5;
                                str4 = str16;
                            } else {
                                str4 = str16;
                                str2 = str5;
                                num5 = num9;
                                num2 = num8;
                                num3 = num6;
                                num4 = num7;
                                num = num10;
                                z3 = z4;
                                sites = mALSyncSites;
                                function3 = function10;
                                function4 = function5;
                            }
                        } else {
                            str2 = jpTitle;
                            num = anidbEid;
                            num2 = year;
                            c2 = 3;
                            function3 = function11;
                            function4 = function2;
                            num3 = malId;
                            num4 = aniId;
                            sites = null;
                            num5 = episode;
                            str3 = title;
                            z3 = z;
                            linkData = linkData2;
                            str4 = str;
                        }
                    }
                    break;
                } else {
                    Requests app3 = MainActivityKt.getApp();
                    String str19 = "https://api.malsync.moe/mal/anime/" + malId.intValue();
                    c00892.L$0 = SpillingKt.nullOutSpilledVariable(str);
                    c00892.L$1 = function11;
                    c00892.L$2 = function2;
                    c00892.L$3 = linkData2;
                    c00892.L$4 = malId;
                    c00892.L$5 = episode;
                    c00892.L$6 = jpTitle;
                    c00892.L$7 = title;
                    c00892.L$8 = anidbEid;
                    c00892.L$9 = aniId;
                    c00892.L$10 = year;
                    c00892.L$11 = SpillingKt.nullOutSpilledVariable(kitsuId);
                    c00892.Z$0 = z;
                    c00892.label = 1;
                    z2 = true;
                    mALSyncSites = null;
                    obj3 = coroutine_suspended;
                    obj4 = Requests.get$default(app3, str19, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00892, 4094, (Object) null);
                    if (obj4 == obj3) {
                        c00892 = c00892;
                        return obj3;
                    }
                    c00892 = c00892;
                    z6 = z;
                    num16 = malId;
                    num17 = episode;
                    str10 = jpTitle;
                    str11 = title;
                    num18 = anidbEid;
                    num19 = aniId;
                    num20 = year;
                    linkData = linkData2;
                    function7 = function2;
                    str12 = str;
                    NiceResponse niceResponse3 = (NiceResponse) obj4;
                    try {
                        ResponseParser parser3 = niceResponse3.getParser();
                        Intrinsics.checkNotNull(parser3);
                        function8 = function11;
                        try {
                            str13 = str12;
                            try {
                                safe = parser3.parseSafe(niceResponse3.getText(), Reflection.getOrCreateKotlinClass(MALSyncResponses.class));
                            } catch (Exception e8) {
                                e = e8;
                                e.printStackTrace();
                                safe = mALSyncSites;
                            }
                        } catch (Exception e9) {
                            e = e9;
                            str13 = str12;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        function8 = function11;
                        str13 = str12;
                    }
                    mALSyncResponses = (MALSyncResponses) safe;
                    if (mALSyncResponses != null) {
                        num2 = num20;
                        num4 = num19;
                        num = num18;
                        str2 = str10;
                        num5 = num17;
                        num3 = num16;
                        z3 = z6;
                        c2 = 3;
                        c = 2;
                        function3 = function8;
                        function4 = function7;
                        str3 = str11;
                        sites = mALSyncResponses.getSites();
                        str4 = str13;
                    } else {
                        str4 = str13;
                        num2 = num20;
                        num4 = num19;
                        num = num18;
                        str2 = str10;
                        num5 = num17;
                        num3 = num16;
                        z3 = z6;
                        c2 = 3;
                        c = 2;
                        function3 = function8;
                        function4 = function7;
                        str3 = str11;
                        sites = mALSyncSites;
                    }
                    break;
                }
                mALSyncSites2 = sites;
                if (mALSyncSites2 != null || (kickAssAnime = mALSyncSites2.getKickAssAnime()) == null || (collectionValues = kickAssAnime.values()) == null) {
                    r12 = mALSyncSites;
                } else {
                    Iterator it = collectionValues.iterator();
                    do {
                        if (it.hasNext()) {
                            r12 = (String) ((HashMap) it.next()).get("identifier");
                        } else {
                            r12 = mALSyncSites;
                        }
                    } while (r12 == null);
                }
                ?? r17 = r12;
                if (linkData.getSeason() == null) {
                    str15 = "Movie";
                } else if (linkData.isDub()) {
                    str15 = "DUB";
                } else {
                    str15 = "SUB";
                }
                function1Arr = new Function1[11];
                Integer num21 = num3;
                function1Arr[0] = new C00932(num3, num5, function3, function4, str15, null);
                function1Arr[z2 ? 1 : 0] = new C00943(mALSyncSites2, num5, function3, function4, str15, null);
                String str20 = str2;
                function1Arr[c] = new C00954(str20, num5, function3, function4, str15, null);
                Function1<? super ExtractorLink, Unit> function12 = function4;
                Integer num22 = num5;
                String str21 = str3;
                Integer num23 = num4;
                String str22 = str15;
                Function1<? super SubtitleFile, Unit> function13 = function3;
                function1Arr[c2] = new C00965(num23, str21, str20, num22, function13, function12, str22, null);
                function1Arr[4] = new C00976(num23, str21, str20, num22, function13, function12, str22, num21, null);
                function1Arr[5] = new C00987(str20, str21, num2, num22, function13, function12, str22, null);
                function1Arr[6] = new C00998(str20, r17, num22, function13, function12, str22, null);
                function1Arr[7] = new C01009(num21, num23, str20, num22, function13, function12, str22, null);
                function1Arr[8] = new C009010(num21, function13, function12, str22, num, null);
                function1Arr[9] = new C009111(num23, num22, function13, function12, str22, null);
                function1Arr[10] = new C009212(str21, str20, num22, function13, function12, str22, null);
                c00892.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                c00892.L$1 = SpillingKt.nullOutSpilledVariable(function13);
                c00892.L$2 = SpillingKt.nullOutSpilledVariable(function12);
                c00892.L$3 = SpillingKt.nullOutSpilledVariable(linkData);
                c00892.L$4 = SpillingKt.nullOutSpilledVariable(num21);
                c00892.L$5 = SpillingKt.nullOutSpilledVariable(num22);
                c00892.L$6 = SpillingKt.nullOutSpilledVariable(str20);
                c00892.L$7 = SpillingKt.nullOutSpilledVariable(str21);
                c00892.L$8 = SpillingKt.nullOutSpilledVariable(num);
                c00892.L$9 = SpillingKt.nullOutSpilledVariable(num23);
                c00892.L$10 = SpillingKt.nullOutSpilledVariable(num2);
                c00892.L$11 = SpillingKt.nullOutSpilledVariable(kitsuId);
                c00892.L$12 = SpillingKt.nullOutSpilledVariable(mALSyncSites2);
                c00892.L$13 = SpillingKt.nullOutSpilledVariable((Object) r17);
                c00892.L$14 = SpillingKt.nullOutSpilledVariable(str22);
                c00892.Z$0 = z3;
                c00892.label = 4;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00892) == obj3) {
                    return obj3;
                }
                return Boxing.boxBoolean(z2);
            case 1:
                boolean z7 = c00892.Z$0;
                Integer num24 = (Integer) c00892.L$11;
                num20 = (Integer) c00892.L$10;
                num19 = (Integer) c00892.L$9;
                num18 = (Integer) c00892.L$8;
                str11 = (String) c00892.L$7;
                str10 = (String) c00892.L$6;
                num17 = (Integer) c00892.L$5;
                num16 = (Integer) c00892.L$4;
                z6 = z7;
                LinkData linkData3 = (LinkData) c00892.L$3;
                Function1<? super ExtractorLink, Unit> function14 = (Function1) c00892.L$2;
                function11 = (Function1) c00892.L$1;
                str12 = (String) c00892.L$0;
                ResultKt.throwOnFailure(obj4);
                linkData = linkData3;
                function7 = function14;
                kitsuId = num24;
                obj3 = coroutine_suspended;
                z2 = true;
                mALSyncSites = null;
                NiceResponse niceResponse4 = (NiceResponse) obj4;
                ResponseParser parser4 = niceResponse4.getParser();
                Intrinsics.checkNotNull(parser4);
                function8 = function11;
                str13 = str12;
                safe = parser4.parseSafe(niceResponse4.getText(), Reflection.getOrCreateKotlinClass(MALSyncResponses.class));
                mALSyncResponses = (MALSyncResponses) safe;
                if (mALSyncResponses != null) {
                    num2 = num20;
                    num4 = num19;
                    num = num18;
                    str2 = str10;
                    num5 = num17;
                    num3 = num16;
                    z3 = z6;
                    c2 = 3;
                    c = 2;
                    function3 = function8;
                    function4 = function7;
                    str3 = str11;
                    sites = mALSyncResponses.getSites();
                    str4 = str13;
                } else {
                    str4 = str13;
                    num2 = num20;
                    num4 = num19;
                    num = num18;
                    str2 = str10;
                    num5 = num17;
                    num3 = num16;
                    z3 = z6;
                    c2 = 3;
                    c = 2;
                    function3 = function8;
                    function4 = function7;
                    str3 = str11;
                    sites = mALSyncSites;
                }
                mALSyncSites2 = sites;
                if (mALSyncSites2 != null) {
                    r12 = mALSyncSites;
                } else {
                    r12 = mALSyncSites;
                }
                ?? r18 = r12;
                if (linkData.getSeason() == null) {
                    str15 = "Movie";
                } else if (linkData.isDub()) {
                    str15 = "DUB";
                } else {
                    str15 = "SUB";
                }
                function1Arr = new Function1[11];
                Integer num25 = num3;
                function1Arr[0] = new C00932(num3, num5, function3, function4, str15, null);
                function1Arr[z2 ? 1 : 0] = new C00943(mALSyncSites2, num5, function3, function4, str15, null);
                String str23 = str2;
                function1Arr[c] = new C00954(str23, num5, function3, function4, str15, null);
                Function1<? super ExtractorLink, Unit> function15 = function4;
                Integer num26 = num5;
                String str24 = str3;
                Integer num27 = num4;
                String str25 = str15;
                Function1<? super SubtitleFile, Unit> function16 = function3;
                function1Arr[c2] = new C00965(num27, str24, str23, num26, function16, function15, str25, null);
                function1Arr[4] = new C00976(num27, str24, str23, num26, function16, function15, str25, num25, null);
                function1Arr[5] = new C00987(str23, str24, num2, num26, function16, function15, str25, null);
                function1Arr[6] = new C00998(str23, r18, num26, function16, function15, str25, null);
                function1Arr[7] = new C01009(num25, num27, str23, num26, function16, function15, str25, null);
                function1Arr[8] = new C009010(num25, function16, function15, str25, num, null);
                function1Arr[9] = new C009111(num27, num26, function16, function15, str25, null);
                function1Arr[10] = new C009212(str24, str23, num26, function16, function15, str25, null);
                c00892.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                c00892.L$1 = SpillingKt.nullOutSpilledVariable(function16);
                c00892.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                c00892.L$3 = SpillingKt.nullOutSpilledVariable(linkData);
                c00892.L$4 = SpillingKt.nullOutSpilledVariable(num25);
                c00892.L$5 = SpillingKt.nullOutSpilledVariable(num26);
                c00892.L$6 = SpillingKt.nullOutSpilledVariable(str23);
                c00892.L$7 = SpillingKt.nullOutSpilledVariable(str24);
                c00892.L$8 = SpillingKt.nullOutSpilledVariable(num);
                c00892.L$9 = SpillingKt.nullOutSpilledVariable(num27);
                c00892.L$10 = SpillingKt.nullOutSpilledVariable(num2);
                c00892.L$11 = SpillingKt.nullOutSpilledVariable(kitsuId);
                c00892.L$12 = SpillingKt.nullOutSpilledVariable(mALSyncSites2);
                c00892.L$13 = SpillingKt.nullOutSpilledVariable((Object) r18);
                c00892.L$14 = SpillingKt.nullOutSpilledVariable(str25);
                c00892.Z$0 = z3;
                c00892.label = 4;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00892) == obj3) {
                    return obj3;
                }
                return Boxing.boxBoolean(z2);
            case 2:
                boolean z8 = c00892.Z$0;
                Integer num28 = (Integer) c00892.L$11;
                num15 = (Integer) c00892.L$10;
                num12 = (Integer) c00892.L$9;
                num14 = (Integer) c00892.L$8;
                str8 = (String) c00892.L$7;
                str7 = (String) c00892.L$6;
                num13 = (Integer) c00892.L$5;
                num11 = (Integer) c00892.L$4;
                z5 = z8;
                LinkData linkData4 = (LinkData) c00892.L$3;
                Function1<? super ExtractorLink, Unit> function17 = (Function1) c00892.L$2;
                function11 = (Function1) c00892.L$1;
                str9 = (String) c00892.L$0;
                ResultKt.throwOnFailure(obj4);
                linkData = linkData4;
                function6 = function17;
                kitsuId = num28;
                obj3 = coroutine_suspended;
                z2 = true;
                mALSyncSites = null;
                c = 2;
                NiceResponse niceResponse5 = (NiceResponse) obj4;
                ResponseParser parser5 = niceResponse5.getParser();
                Intrinsics.checkNotNull(parser5);
                function9 = function11;
                str14 = str9;
                safe2 = parser5.parseSafe(niceResponse5.getText(), Reflection.getOrCreateKotlinClass(MALSyncResponses.class));
                mALSyncResponses2 = (MALSyncResponses) safe2;
                if (mALSyncResponses2 != null) {
                    num2 = num15;
                    num4 = num12;
                    num = num14;
                    str2 = str7;
                    num5 = num13;
                    num3 = num11;
                    z3 = z5;
                    c2 = 3;
                    function3 = function9;
                    function4 = function6;
                    str3 = str8;
                    sites = mALSyncResponses2.getSites();
                    str4 = str14;
                } else {
                    str4 = str14;
                    num2 = num15;
                    num4 = num12;
                    num = num14;
                    str2 = str7;
                    num5 = num13;
                    num3 = num11;
                    z3 = z5;
                    c2 = 3;
                    function3 = function9;
                    function4 = function6;
                    str3 = str8;
                    sites = mALSyncSites;
                }
                mALSyncSites2 = sites;
                if (mALSyncSites2 != null) {
                    r12 = mALSyncSites;
                } else {
                    r12 = mALSyncSites;
                }
                ?? r19 = r12;
                if (linkData.getSeason() == null) {
                    str15 = "Movie";
                } else if (linkData.isDub()) {
                    str15 = "DUB";
                } else {
                    str15 = "SUB";
                }
                function1Arr = new Function1[11];
                Integer num29 = num3;
                function1Arr[0] = new C00932(num3, num5, function3, function4, str15, null);
                function1Arr[z2 ? 1 : 0] = new C00943(mALSyncSites2, num5, function3, function4, str15, null);
                String str26 = str2;
                function1Arr[c] = new C00954(str26, num5, function3, function4, str15, null);
                Function1<? super ExtractorLink, Unit> function18 = function4;
                Integer num210 = num5;
                String str27 = str3;
                Integer num211 = num4;
                String str28 = str15;
                Function1<? super SubtitleFile, Unit> function19 = function3;
                function1Arr[c2] = new C00965(num211, str27, str26, num210, function19, function18, str28, null);
                function1Arr[4] = new C00976(num211, str27, str26, num210, function19, function18, str28, num29, null);
                function1Arr[5] = new C00987(str26, str27, num2, num210, function19, function18, str28, null);
                function1Arr[6] = new C00998(str26, r19, num210, function19, function18, str28, null);
                function1Arr[7] = new C01009(num29, num211, str26, num210, function19, function18, str28, null);
                function1Arr[8] = new C009010(num29, function19, function18, str28, num, null);
                function1Arr[9] = new C009111(num211, num210, function19, function18, str28, null);
                function1Arr[10] = new C009212(str27, str26, num210, function19, function18, str28, null);
                c00892.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                c00892.L$1 = SpillingKt.nullOutSpilledVariable(function19);
                c00892.L$2 = SpillingKt.nullOutSpilledVariable(function18);
                c00892.L$3 = SpillingKt.nullOutSpilledVariable(linkData);
                c00892.L$4 = SpillingKt.nullOutSpilledVariable(num29);
                c00892.L$5 = SpillingKt.nullOutSpilledVariable(num210);
                c00892.L$6 = SpillingKt.nullOutSpilledVariable(str26);
                c00892.L$7 = SpillingKt.nullOutSpilledVariable(str27);
                c00892.L$8 = SpillingKt.nullOutSpilledVariable(num);
                c00892.L$9 = SpillingKt.nullOutSpilledVariable(num211);
                c00892.L$10 = SpillingKt.nullOutSpilledVariable(num2);
                c00892.L$11 = SpillingKt.nullOutSpilledVariable(kitsuId);
                c00892.L$12 = SpillingKt.nullOutSpilledVariable(mALSyncSites2);
                c00892.L$13 = SpillingKt.nullOutSpilledVariable((Object) r19);
                c00892.L$14 = SpillingKt.nullOutSpilledVariable(str28);
                c00892.Z$0 = z3;
                c00892.label = 4;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00892) == obj3) {
                    return obj3;
                }
                return Boxing.boxBoolean(z2);
            case 3:
                boolean z9 = c00892.Z$0;
                Integer num30 = (Integer) c00892.L$11;
                num8 = (Integer) c00892.L$10;
                num7 = (Integer) c00892.L$9;
                num10 = (Integer) c00892.L$8;
                str3 = (String) c00892.L$7;
                str5 = (String) c00892.L$6;
                num9 = (Integer) c00892.L$5;
                num6 = (Integer) c00892.L$4;
                z4 = z9;
                LinkData linkData5 = (LinkData) c00892.L$3;
                Function1<? super ExtractorLink, Unit> function20 = (Function1) c00892.L$2;
                function11 = (Function1) c00892.L$1;
                str6 = (String) c00892.L$0;
                ResultKt.throwOnFailure(obj4);
                linkData = linkData5;
                function5 = function20;
                kitsuId = num30;
                obj3 = coroutine_suspended;
                z2 = true;
                c2 = 3;
                mALSyncSites = null;
                c = 2;
                NiceResponse niceResponse6 = (NiceResponse) obj4;
                ResponseParser parser6 = niceResponse6.getParser();
                Intrinsics.checkNotNull(parser6);
                function10 = function11;
                str16 = str6;
                safe3 = parser6.parseSafe(niceResponse6.getText(), Reflection.getOrCreateKotlinClass(MALSyncResponses.class));
                mALSyncResponses3 = (MALSyncResponses) safe3;
                if (mALSyncResponses3 != null) {
                    str2 = str5;
                    num5 = num9;
                    num2 = num8;
                    num3 = num6;
                    num4 = num7;
                    num = num10;
                    z3 = z4;
                    function3 = function10;
                    sites = mALSyncResponses3.getSites();
                    function4 = function5;
                    str4 = str16;
                } else {
                    str4 = str16;
                    str2 = str5;
                    num5 = num9;
                    num2 = num8;
                    num3 = num6;
                    num4 = num7;
                    num = num10;
                    z3 = z4;
                    sites = mALSyncSites;
                    function3 = function10;
                    function4 = function5;
                }
                mALSyncSites2 = sites;
                if (mALSyncSites2 != null) {
                    r12 = mALSyncSites;
                } else {
                    r12 = mALSyncSites;
                }
                ?? r110 = r12;
                if (linkData.getSeason() == null) {
                    str15 = "Movie";
                } else if (linkData.isDub()) {
                    str15 = "DUB";
                } else {
                    str15 = "SUB";
                }
                function1Arr = new Function1[11];
                Integer num212 = num3;
                function1Arr[0] = new C00932(num3, num5, function3, function4, str15, null);
                function1Arr[z2 ? 1 : 0] = new C00943(mALSyncSites2, num5, function3, function4, str15, null);
                String str29 = str2;
                function1Arr[c] = new C00954(str29, num5, function3, function4, str15, null);
                Function1<? super ExtractorLink, Unit> function110 = function4;
                Integer num213 = num5;
                String str210 = str3;
                Integer num214 = num4;
                String str211 = str15;
                Function1<? super SubtitleFile, Unit> function111 = function3;
                function1Arr[c2] = new C00965(num214, str210, str29, num213, function111, function110, str211, null);
                function1Arr[4] = new C00976(num214, str210, str29, num213, function111, function110, str211, num212, null);
                function1Arr[5] = new C00987(str29, str210, num2, num213, function111, function110, str211, null);
                function1Arr[6] = new C00998(str29, r110, num213, function111, function110, str211, null);
                function1Arr[7] = new C01009(num212, num214, str29, num213, function111, function110, str211, null);
                function1Arr[8] = new C009010(num212, function111, function110, str211, num, null);
                function1Arr[9] = new C009111(num214, num213, function111, function110, str211, null);
                function1Arr[10] = new C009212(str210, str29, num213, function111, function110, str211, null);
                c00892.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                c00892.L$1 = SpillingKt.nullOutSpilledVariable(function111);
                c00892.L$2 = SpillingKt.nullOutSpilledVariable(function110);
                c00892.L$3 = SpillingKt.nullOutSpilledVariable(linkData);
                c00892.L$4 = SpillingKt.nullOutSpilledVariable(num212);
                c00892.L$5 = SpillingKt.nullOutSpilledVariable(num213);
                c00892.L$6 = SpillingKt.nullOutSpilledVariable(str29);
                c00892.L$7 = SpillingKt.nullOutSpilledVariable(str210);
                c00892.L$8 = SpillingKt.nullOutSpilledVariable(num);
                c00892.L$9 = SpillingKt.nullOutSpilledVariable(num214);
                c00892.L$10 = SpillingKt.nullOutSpilledVariable(num2);
                c00892.L$11 = SpillingKt.nullOutSpilledVariable(kitsuId);
                c00892.L$12 = SpillingKt.nullOutSpilledVariable(mALSyncSites2);
                c00892.L$13 = SpillingKt.nullOutSpilledVariable((Object) r110);
                c00892.L$14 = SpillingKt.nullOutSpilledVariable(str211);
                c00892.Z$0 = z3;
                c00892.label = 4;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00892) == obj3) {
                    return obj3;
                }
                return Boxing.boxBoolean(z2);
            case 4:
                boolean z10 = c00892.Z$0;
                ResultKt.throwOnFailure(obj4);
                z2 = true;
                return Boxing.boxBoolean(z2);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$2 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$2", f = "StreamPlayAnime.kt", i = {}, l = {581}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00932 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ Integer $malId;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00932(Integer num, Integer num2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str, Continuation<? super C00932> continuation) {
            super(1, continuation);
            this.$malId = num;
            this.$episode = num2;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00932(this.$malId, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (StreamPlayExtractor.INSTANCE.invokeHianime(this.$malId, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$3 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$3", f = "StreamPlayAnime.kt", i = {0}, l = {584}, m = "invokeSuspend", n = {"it"}, nl = {585}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayAnime.kt\ncom/phisher98/StreamPlayAnime$loadLinks$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,781:1\n1#2:782\n*E\n"})
    static final class C00943 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ MALSyncSites $malsync;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00943(MALSyncSites mALSyncSites, Integer num, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str, Continuation<? super C00943> continuation) {
            super(1, continuation);
            this.$malsync = mALSyncSites;
            this.$episode = num;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00943(this.$malsync, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x004f  */
        /* JADX WARN: Code duplicated, block: B:23:0x006b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:24:0x006c  */
        /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
        /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r5v4 java.lang.String, still in use, count: 2, list:
              (r5v4 java.lang.String) from 0x0049: IF  (r5v4 java.lang.String) == (null java.lang.String)  -> B:29:? A[HIDDEN]
              (r5v4 java.lang.String) from 0x004d: PHI (r5 I:??) = (r5v0 java.lang.String), (r5v4 java.lang.String) binds: [B:19:0x004c, B:27:0x004d] A[DONT_GENERATE, DONT_INLINE]
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
            	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
            	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
            	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
            	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
            	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
            	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
            	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.label
                switch(r1) {
                    case 0: goto L1a;
                    case 1: goto L11;
                    default: goto L9;
                }
            L9:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L11:
                r0 = 0
                java.lang.Object r1 = r13.L$0
                java.lang.String r1 = (java.lang.String) r1
                kotlin.ResultKt.throwOnFailure(r14)
                goto L6e
            L1a:
                kotlin.ResultKt.throwOnFailure(r14)
                com.phisher98.MALSyncSites r1 = r13.$malsync
                r2 = 0
                if (r1 == 0) goto L71
                java.util.HashMap r1 = r1.getAnimepahe()
                if (r1 == 0) goto L71
                java.util.Collection r1 = r1.values()
                if (r1 == 0) goto L71
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Iterator r1 = r1.iterator()
            L34:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L4c
                java.lang.Object r3 = r1.next()
                java.util.HashMap r3 = (java.util.HashMap) r3
                r4 = 0
                java.lang.String r5 = "url"
                java.lang.Object r5 = r3.get(r5)
                java.lang.String r5 = (java.lang.String) r5
                if (r5 == 0) goto L34
                goto L4d
            L4c:
                r5 = r2
            L4d:
                if (r5 == 0) goto L71
                java.lang.Integer r8 = r13.$episode
                kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r9 = r13.$subtitleCallback
                kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r10 = r13.$callback
                java.lang.String r11 = r13.$dubStatus
                r7 = r5
                r1 = 0
                com.phisher98.StreamPlayExtractor r6 = com.phisher98.StreamPlayExtractor.INSTANCE
                java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r13.L$0 = r2
                r2 = 1
                r13.label = r2
                r12 = r13
                java.lang.Object r2 = r6.invokeAnimepahe(r7, r8, r9, r10, r11, r12)
                if (r2 != r0) goto L6c
                return r0
            L6c:
                r0 = r1
                r1 = r7
            L6e:
                kotlin.Unit r2 = kotlin.Unit.INSTANCE
            L71:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StreamPlayAnime.C00943.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$4 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$4", f = "StreamPlayAnime.kt", i = {}, l = {588}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00954 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ String $jpTitle;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00954(String str, Integer num, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str2, Continuation<? super C00954> continuation) {
            super(1, continuation);
            this.$jpTitle = str;
            this.$episode = num;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str2;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00954(this.$jpTitle, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (StreamPlayExtractor.INSTANCE.invokeAnizone(this.$jpTitle, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$5 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$5", f = "StreamPlayAnime.kt", i = {}, l = {589}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00965 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $aniid;
        final /* synthetic */ String $anititle;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ String $jpTitle;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00965(Integer num, String str, String str2, Integer num2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str3, Continuation<? super C00965> continuation) {
            super(1, continuation);
            this.$aniid = num;
            this.$anititle = str;
            this.$jpTitle = str2;
            this.$episode = num2;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str3;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00965(this.$aniid, this.$anititle, this.$jpTitle, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    StreamPlayExtractor streamPlayExtractor = StreamPlayExtractor.INSTANCE;
                    Integer num = this.$aniid;
                    String str = this.$anititle;
                    if (str == null) {
                        str = this.$jpTitle;
                    }
                    this.label = 1;
                    if (streamPlayExtractor.invokeAnikage(num, str, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$6 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$6", f = "StreamPlayAnime.kt", i = {}, l = {590}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00976 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $aniid;
        final /* synthetic */ String $anititle;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ String $jpTitle;
        final /* synthetic */ Integer $malId;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00976(Integer num, String str, String str2, Integer num2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str3, Integer num3, Continuation<? super C00976> continuation) {
            super(1, continuation);
            this.$aniid = num;
            this.$anititle = str;
            this.$jpTitle = str2;
            this.$episode = num2;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str3;
            this.$malId = num3;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00976(this.$aniid, this.$anititle, this.$jpTitle, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, this.$malId, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    StreamPlayExtractor streamPlayExtractor = StreamPlayExtractor.INSTANCE;
                    Integer num = this.$aniid;
                    String str = this.$anititle;
                    if (str == null) {
                        str = this.$jpTitle;
                    }
                    this.label = 1;
                    if (streamPlayExtractor.invokeAnikoto(num, str, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, this.$malId, this.$jpTitle, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$7 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$7", f = "StreamPlayAnime.kt", i = {}, l = {591}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00987 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $anititle;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ String $jpTitle;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ Integer $year;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00987(String str, String str2, Integer num, Integer num2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str3, Continuation<? super C00987> continuation) {
            super(1, continuation);
            this.$jpTitle = str;
            this.$anititle = str2;
            this.$year = num;
            this.$episode = num2;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str3;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00987(this.$jpTitle, this.$anititle, this.$year, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (StreamPlayExtractor.INSTANCE.invokeAnichi(this.$jpTitle, this.$anititle, this.$year, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$8 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$8", f = "StreamPlayAnime.kt", i = {}, l = {592}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00998 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ String $jpTitle;
        final /* synthetic */ String $kaasSlug;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00998(String str, String str2, Integer num, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str3, Continuation<? super C00998> continuation) {
            super(1, continuation);
            this.$jpTitle = str;
            this.$kaasSlug = str2;
            this.$episode = num;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str3;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00998(this.$jpTitle, this.$kaasSlug, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (StreamPlayExtractor.INSTANCE.invokeKickAssAnime(this.$jpTitle, this.$kaasSlug, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$9 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$9", f = "StreamPlayAnime.kt", i = {}, l = {593}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C01009 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $aniid;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ String $jpTitle;
        final /* synthetic */ Integer $malId;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01009(Integer num, Integer num2, String str, Integer num3, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str2, Continuation<? super C01009> continuation) {
            super(1, continuation);
            this.$malId = num;
            this.$aniid = num2;
            this.$jpTitle = str;
            this.$episode = num3;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str2;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C01009(this.$malId, this.$aniid, this.$jpTitle, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (StreamPlayExtractor.INSTANCE.invokeAnimex(this.$malId, this.$aniid, this.$jpTitle, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$10 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$10", f = "StreamPlayAnime.kt", i = {0}, l = {596}, m = "invokeSuspend", n = {"it"}, nl = {602}, s = {"I$0"}, v = 2)
    static final class C009010 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $anidbEid;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $malId;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int I$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C009010(Integer num, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str, Integer num2, Continuation<? super C009010> continuation) {
            super(1, continuation);
            this.$malId = num;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str;
            this.$anidbEid = num2;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C009010(this.$malId, this.$subtitleCallback, this.$callback, this.$dubStatus, this.$anidbEid, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Integer num = this.$malId;
                    if (num == null) {
                        return null;
                    }
                    Function1<? super SubtitleFile, Unit> function1 = this.$subtitleCallback;
                    Function1<? super ExtractorLink, Unit> function2 = this.$callback;
                    String str = this.$dubStatus;
                    Integer num2 = this.$anidbEid;
                    int it = num.intValue();
                    StreamPlayExtractor streamPlayExtractor = StreamPlayExtractor.INSTANCE;
                    this.I$0 = it;
                    this.label = 1;
                    if (streamPlayExtractor.invokeAnimetosho(function1, function2, str, num2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                    break;
                case 1:
                    int i = this.I$0;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$11 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$11", f = "StreamPlayAnime.kt", i = {}, l = {605}, m = "invokeSuspend", n = {}, nl = {606}, s = {}, v = 2)
    static final class C009111 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $aniid;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C009111(Integer num, Integer num2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str, Continuation<? super C009111> continuation) {
            super(1, continuation);
            this.$aniid = num;
            this.$episode = num2;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C009111(this.$aniid, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (StreamPlayExtractor.INSTANCE.invokeReAnime(this.$aniid, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$12 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$12", f = "StreamPlayAnime.kt", i = {}, l = {608}, m = "invokeSuspend", n = {}, nl = {609}, s = {}, v = 2)
    static final class C009212 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $anititle;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ String $jpTitle;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C009212(String str, String str2, Integer num, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str3, Continuation<? super C009212> continuation) {
            super(1, continuation);
            this.$anititle = str;
            this.$jpTitle = str2;
            this.$episode = num;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str3;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C009212(this.$anititle, this.$jpTitle, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (StreamPlayExtractor.INSTANCE.invokeAnineko(this.$anititle, this.$jpTitle, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, (Continuation) this) == coroutine_suspended) {
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

    @NotNull
    public final ShowStatus getStatus(@Nullable String t) {
        boolean z = false;
        if (t != null && StringsKt.contains(t, "Returning", true)) {
            return ShowStatus.Ongoing;
        }
        if (t != null && StringsKt.contains(t, "RELEASING", true)) {
            return ShowStatus.Ongoing;
        }
        if (t != null && StringsKt.contains(t, "current", true)) {
            z = true;
        }
        return z ? ShowStatus.Ongoing : ShowStatus.Completed;
    }

    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u001f\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse;", "", "data", "Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$AnilistData;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$AnilistData;)V", "getData", "()Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$AnilistData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AnilistData", "anilistMedia", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AnilistAPIResponse {

        @NotNull
        private final AnilistData data;

        public static /* synthetic */ AnilistAPIResponse copy$default(AnilistAPIResponse anilistAPIResponse, AnilistData anilistData, int i, Object obj) {
            if ((i & 1) != 0) {
                anilistData = anilistAPIResponse.data;
            }
            return anilistAPIResponse.copy(anilistData);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AnilistData getData() {
            return this.data;
        }

        @NotNull
        public final AnilistAPIResponse copy(@JsonProperty("data") @NotNull AnilistData data) {
            return new AnilistAPIResponse(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AnilistAPIResponse) && Intrinsics.areEqual(this.data, ((AnilistAPIResponse) other).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "AnilistAPIResponse(data=" + this.data + ')';
        }

        public AnilistAPIResponse(@JsonProperty("data") @NotNull AnilistData data) {
            this.data = data;
        }

        @NotNull
        public final AnilistData getData() {
            return this.data;
        }

        /* JADX INFO: compiled from: StreamPlayAnime.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001aB;\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0003J=\u0010\u0012\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\tHÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$AnilistData;", "", "page", "Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$AnilistData$AnilistPage;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Page", "media", "Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia;", "Media", "<init>", "(Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$AnilistData$AnilistPage;Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia;)V", "getPage", "()Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$AnilistData$AnilistPage;", "getMedia", "()Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AnilistPage", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class AnilistData {

            @Nullable
            private final anilistMedia media;

            @Nullable
            private final AnilistPage page;

            public static /* synthetic */ AnilistData copy$default(AnilistData anilistData, AnilistPage anilistPage, anilistMedia anilistmedia, int i, Object obj) {
                if ((i & 1) != 0) {
                    anilistPage = anilistData.page;
                }
                if ((i & 2) != 0) {
                    anilistmedia = anilistData.media;
                }
                return anilistData.copy(anilistPage, anilistmedia);
            }

            @Nullable
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AnilistPage getPage() {
                return this.page;
            }

            @Nullable
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final anilistMedia getMedia() {
                return this.media;
            }

            @NotNull
            public final AnilistData copy(@JsonProperty("Page") @Nullable AnilistPage page, @JsonProperty("Media") @Nullable anilistMedia media) {
                return new AnilistData(page, media);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AnilistData)) {
                    return false;
                }
                AnilistData anilistData = (AnilistData) other;
                return Intrinsics.areEqual(this.page, anilistData.page) && Intrinsics.areEqual(this.media, anilistData.media);
            }

            public int hashCode() {
                return ((this.page == null ? 0 : this.page.hashCode()) * 31) + (this.media != null ? this.media.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "AnilistData(page=" + this.page + ", media=" + this.media + ')';
            }

            public AnilistData(@JsonProperty("Page") @Nullable AnilistPage page, @JsonProperty("Media") @Nullable anilistMedia media) {
                this.page = page;
                this.media = media;
            }

            @Nullable
            public final AnilistPage getPage() {
                return this.page;
            }

            @Nullable
            public final anilistMedia getMedia() {
                return this.media;
            }

            /* JADX INFO: compiled from: StreamPlayAnime.kt */
            @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u001c\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J?\u0010\u0011\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u001c\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$AnilistData$AnilistPage;", "", "pageInfo", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikePageInfo;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "media", "", "Lcom/phisher98/StreamPlayAnime$Media;", "<init>", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikePageInfo;Ljava/util/List;)V", "getPageInfo", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikePageInfo;", "getMedia", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final /* data */ class AnilistPage {

                @NotNull
                private final List<Media> media;

                @NotNull
                private final AniListApi.LikePageInfo pageInfo;

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ AnilistPage copy$default(AnilistPage anilistPage, AniListApi.LikePageInfo likePageInfo, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        likePageInfo = anilistPage.pageInfo;
                    }
                    if ((i & 2) != 0) {
                        list = anilistPage.media;
                    }
                    return anilistPage.copy(likePageInfo, list);
                }

                @NotNull
                /* JADX INFO: renamed from: component1, reason: from getter */
                public final AniListApi.LikePageInfo getPageInfo() {
                    return this.pageInfo;
                }

                @NotNull
                public final List<Media> component2() {
                    return this.media;
                }

                @NotNull
                public final AnilistPage copy(@JsonProperty("pageInfo") @NotNull AniListApi.LikePageInfo pageInfo, @JsonProperty("media") @NotNull List<Media> media) {
                    return new AnilistPage(pageInfo, media);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof AnilistPage)) {
                        return false;
                    }
                    AnilistPage anilistPage = (AnilistPage) other;
                    return Intrinsics.areEqual(this.pageInfo, anilistPage.pageInfo) && Intrinsics.areEqual(this.media, anilistPage.media);
                }

                public int hashCode() {
                    return (this.pageInfo.hashCode() * 31) + this.media.hashCode();
                }

                @NotNull
                public String toString() {
                    return "AnilistPage(pageInfo=" + this.pageInfo + ", media=" + this.media + ')';
                }

                public AnilistPage(@JsonProperty("pageInfo") @NotNull AniListApi.LikePageInfo pageInfo, @JsonProperty("media") @NotNull List<Media> list) {
                    this.pageInfo = pageInfo;
                    this.media = list;
                }

                @NotNull
                public final AniListApi.LikePageInfo getPageInfo() {
                    return this.pageInfo;
                }

                @NotNull
                public final List<Media> getMedia() {
                    return this.media;
                }
            }
        }

        /* JADX INFO: compiled from: StreamPlayAnime.kt */
        @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0002OPB\u0085\u0003\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0001\u0010\u0006\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0016\b\u0001\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u001c\b\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0016\b\u0001\u0010\u000f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0016\b\u0001\u0010\u0010\u001a\u00020\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0018\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0016\b\u0001\u0010\u0012\u001a\u00020\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u0018\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0016:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0018\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0018:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u0018\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u001a:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019\u0012\u0018\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u00108\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020\fJ\b\u0010.\u001a\u0004\u0018\u00010\fJ\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010<\u001a\u00020\nHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\f0\u000eHÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\fHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010B\u001a\u00020\u0013HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\fHÆ\u0003J\u008c\u0003\u0010H\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0016\b\u0003\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u001c\b\u0003\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0016\b\u0003\u0010\u000f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0016\b\u0003\u0010\u0010\u001a\u00020\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0016\b\u0003\u0010\u0012\u001a\u00020\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00142\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0016:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00152\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0018:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00172\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u001a:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00192\u0018\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001bHÆ\u0001¢\u0006\u0002\u0010IJ\u0014\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010M\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010N\u001a\u00020\fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b7\u0010(¨\u0006Q"}, d2 = {"Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "startDate", "Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$StartDate;", "episodes", "title", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "season", "", "genres", "", "averageScore", "status", "description", "coverImage", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "bannerImage", "nextAiringEpisode", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "airingSchedule", "Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$AiringScheduleNodes;", "recommendations", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;", "format", "<init>", "(ILcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$StartDate;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$AiringScheduleNodes;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;Ljava/lang/String;)V", "getId", "()I", "getStartDate", "()Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$StartDate;", "getEpisodes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "getSeason", "()Ljava/lang/String;", "getGenres", "()Ljava/util/List;", "getAverageScore", "getStatus", "getDescription", "getCoverImage", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "getBannerImage", "getNextAiringEpisode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "getAiringSchedule", "()Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$AiringScheduleNodes;", "getRecommendations", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;", "getFormat", "totalEpisodes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(ILcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$StartDate;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$AiringScheduleNodes;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;Ljava/lang/String;)Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia;", "equals", "", "other", "hashCode", "toString", "StartDate", "AiringScheduleNodes", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class anilistMedia {

            @Nullable
            private final AiringScheduleNodes airingSchedule;
            private final int averageScore;

            @Nullable
            private final String bannerImage;

            @NotNull
            private final AniListApi.CoverImage coverImage;

            @Nullable
            private final String description;

            @Nullable
            private final Integer episodes;

            @Nullable
            private final String format;

            @NotNull
            private final List<String> genres;
            private final int id;

            @Nullable
            private final AniListApi.SeasonNextAiringEpisode nextAiringEpisode;

            @Nullable
            private final AniListApi.RecommendationConnection recommendations;

            @Nullable
            private final String season;

            @NotNull
            private final StartDate startDate;

            @NotNull
            private final String status;

            @NotNull
            private final AniListApi.Title title;

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getId() {
                return this.id;
            }

            @NotNull
            /* JADX INFO: renamed from: component10, reason: from getter */
            public final AniListApi.CoverImage getCoverImage() {
                return this.coverImage;
            }

            @Nullable
            /* JADX INFO: renamed from: component11, reason: from getter */
            public final String getBannerImage() {
                return this.bannerImage;
            }

            @Nullable
            /* JADX INFO: renamed from: component12, reason: from getter */
            public final AniListApi.SeasonNextAiringEpisode getNextAiringEpisode() {
                return this.nextAiringEpisode;
            }

            @Nullable
            /* JADX INFO: renamed from: component13, reason: from getter */
            public final AiringScheduleNodes getAiringSchedule() {
                return this.airingSchedule;
            }

            @Nullable
            /* JADX INFO: renamed from: component14, reason: from getter */
            public final AniListApi.RecommendationConnection getRecommendations() {
                return this.recommendations;
            }

            @Nullable
            /* JADX INFO: renamed from: component15, reason: from getter */
            public final String getFormat() {
                return this.format;
            }

            @NotNull
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final StartDate getStartDate() {
                return this.startDate;
            }

            @Nullable
            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Integer getEpisodes() {
                return this.episodes;
            }

            @NotNull
            /* JADX INFO: renamed from: component4, reason: from getter */
            public final AniListApi.Title getTitle() {
                return this.title;
            }

            @Nullable
            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getSeason() {
                return this.season;
            }

            @NotNull
            public final List<String> component6() {
                return this.genres;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final int getAverageScore() {
                return this.averageScore;
            }

            @NotNull
            /* JADX INFO: renamed from: component8, reason: from getter */
            public final String getStatus() {
                return this.status;
            }

            @Nullable
            /* JADX INFO: renamed from: component9, reason: from getter */
            public final String getDescription() {
                return this.description;
            }

            @NotNull
            public final anilistMedia copy(@JsonProperty("id") int id, @JsonProperty("startDate") @NotNull StartDate startDate, @JsonProperty("episodes") @Nullable Integer episodes, @JsonProperty("title") @NotNull AniListApi.Title title, @JsonProperty("season") @Nullable String season, @JsonProperty("genres") @NotNull List<String> genres, @JsonProperty("averageScore") int averageScore, @JsonProperty("status") @NotNull String status, @JsonProperty("description") @Nullable String description, @JsonProperty("coverImage") @NotNull AniListApi.CoverImage coverImage, @JsonProperty("bannerImage") @Nullable String bannerImage, @JsonProperty("nextAiringEpisode") @Nullable AniListApi.SeasonNextAiringEpisode nextAiringEpisode, @JsonProperty("airingSchedule") @Nullable AiringScheduleNodes airingSchedule, @JsonProperty("recommendations") @Nullable AniListApi.RecommendationConnection recommendations, @JsonProperty("format") @Nullable String format) {
                return new anilistMedia(id, startDate, episodes, title, season, genres, averageScore, status, description, coverImage, bannerImage, nextAiringEpisode, airingSchedule, recommendations, format);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof anilistMedia)) {
                    return false;
                }
                anilistMedia anilistmedia = (anilistMedia) other;
                return this.id == anilistmedia.id && Intrinsics.areEqual(this.startDate, anilistmedia.startDate) && Intrinsics.areEqual(this.episodes, anilistmedia.episodes) && Intrinsics.areEqual(this.title, anilistmedia.title) && Intrinsics.areEqual(this.season, anilistmedia.season) && Intrinsics.areEqual(this.genres, anilistmedia.genres) && this.averageScore == anilistmedia.averageScore && Intrinsics.areEqual(this.status, anilistmedia.status) && Intrinsics.areEqual(this.description, anilistmedia.description) && Intrinsics.areEqual(this.coverImage, anilistmedia.coverImage) && Intrinsics.areEqual(this.bannerImage, anilistmedia.bannerImage) && Intrinsics.areEqual(this.nextAiringEpisode, anilistmedia.nextAiringEpisode) && Intrinsics.areEqual(this.airingSchedule, anilistmedia.airingSchedule) && Intrinsics.areEqual(this.recommendations, anilistmedia.recommendations) && Intrinsics.areEqual(this.format, anilistmedia.format);
            }

            public int hashCode() {
                return (((((((((((((((((((((((((((this.id * 31) + this.startDate.hashCode()) * 31) + (this.episodes == null ? 0 : this.episodes.hashCode())) * 31) + this.title.hashCode()) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + this.genres.hashCode()) * 31) + this.averageScore) * 31) + this.status.hashCode()) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + this.coverImage.hashCode()) * 31) + (this.bannerImage == null ? 0 : this.bannerImage.hashCode())) * 31) + (this.nextAiringEpisode == null ? 0 : this.nextAiringEpisode.hashCode())) * 31) + (this.airingSchedule == null ? 0 : this.airingSchedule.hashCode())) * 31) + (this.recommendations == null ? 0 : this.recommendations.hashCode())) * 31) + (this.format != null ? this.format.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("anilistMedia(id=").append(this.id).append(", startDate=").append(this.startDate).append(", episodes=").append(this.episodes).append(", title=").append(this.title).append(", season=").append(this.season).append(", genres=").append(this.genres).append(", averageScore=").append(this.averageScore).append(", status=").append(this.status).append(", description=").append(this.description).append(", coverImage=").append(this.coverImage).append(", bannerImage=").append(this.bannerImage).append(", nextAiringEpisode=");
                sb.append(this.nextAiringEpisode).append(", airingSchedule=").append(this.airingSchedule).append(", recommendations=").append(this.recommendations).append(", format=").append(this.format).append(')');
                return sb.toString();
            }

            public anilistMedia(@JsonProperty("id") int id, @JsonProperty("startDate") @NotNull StartDate startDate, @JsonProperty("episodes") @Nullable Integer episodes, @JsonProperty("title") @NotNull AniListApi.Title title, @JsonProperty("season") @Nullable String season, @JsonProperty("genres") @NotNull List<String> list, @JsonProperty("averageScore") int averageScore, @JsonProperty("status") @NotNull String status, @JsonProperty("description") @Nullable String description, @JsonProperty("coverImage") @NotNull AniListApi.CoverImage coverImage, @JsonProperty("bannerImage") @Nullable String bannerImage, @JsonProperty("nextAiringEpisode") @Nullable AniListApi.SeasonNextAiringEpisode nextAiringEpisode, @JsonProperty("airingSchedule") @Nullable AiringScheduleNodes airingSchedule, @JsonProperty("recommendations") @Nullable AniListApi.RecommendationConnection recommendations, @JsonProperty("format") @Nullable String format) {
                this.id = id;
                this.startDate = startDate;
                this.episodes = episodes;
                this.title = title;
                this.season = season;
                this.genres = list;
                this.averageScore = averageScore;
                this.status = status;
                this.description = description;
                this.coverImage = coverImage;
                this.bannerImage = bannerImage;
                this.nextAiringEpisode = nextAiringEpisode;
                this.airingSchedule = airingSchedule;
                this.recommendations = recommendations;
                this.format = format;
            }

            public final int getId() {
                return this.id;
            }

            @NotNull
            public final StartDate getStartDate() {
                return this.startDate;
            }

            @Nullable
            public final Integer getEpisodes() {
                return this.episodes;
            }

            @NotNull
            public final AniListApi.Title getTitle() {
                return this.title;
            }

            @Nullable
            public final String getSeason() {
                return this.season;
            }

            @NotNull
            public final List<String> getGenres() {
                return this.genres;
            }

            public final int getAverageScore() {
                return this.averageScore;
            }

            @NotNull
            public final String getStatus() {
                return this.status;
            }

            @Nullable
            public final String getDescription() {
                return this.description;
            }

            @NotNull
            public final AniListApi.CoverImage getCoverImage() {
                return this.coverImage;
            }

            @Nullable
            public final String getBannerImage() {
                return this.bannerImage;
            }

            @Nullable
            public final AniListApi.SeasonNextAiringEpisode getNextAiringEpisode() {
                return this.nextAiringEpisode;
            }

            @Nullable
            public final AiringScheduleNodes getAiringSchedule() {
                return this.airingSchedule;
            }

            @Nullable
            public final AniListApi.RecommendationConnection getRecommendations() {
                return this.recommendations;
            }

            @Nullable
            public final String getFormat() {
                return this.format;
            }

            /* JADX INFO: compiled from: StreamPlayAnime.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$StartDate;", "", "year", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(I)V", "getYear", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final /* data */ class StartDate {
                private final int year;

                public static /* synthetic */ StartDate copy$default(StartDate startDate, int i, int i2, Object obj) {
                    if ((i2 & 1) != 0) {
                        i = startDate.year;
                    }
                    return startDate.copy(i);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final int getYear() {
                    return this.year;
                }

                @NotNull
                public final StartDate copy(@JsonProperty("year") int year) {
                    return new StartDate(year);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof StartDate) && this.year == ((StartDate) other).year;
                }

                public int hashCode() {
                    return this.year;
                }

                @NotNull
                public String toString() {
                    return "StartDate(year=" + this.year + ')';
                }

                public StartDate(@JsonProperty("year") int year) {
                    this.year = year;
                }

                public final int getYear() {
                    return this.year;
                }
            }

            /* JADX INFO: compiled from: StreamPlayAnime.kt */
            @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u001e\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$AiringScheduleNodes;", "", "nodes", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/List;)V", "getNodes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final /* data */ class AiringScheduleNodes {

                @Nullable
                private final List<AniListApi.SeasonNextAiringEpisode> nodes;

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ AiringScheduleNodes copy$default(AiringScheduleNodes airingScheduleNodes, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = airingScheduleNodes.nodes;
                    }
                    return airingScheduleNodes.copy(list);
                }

                @Nullable
                public final List<AniListApi.SeasonNextAiringEpisode> component1() {
                    return this.nodes;
                }

                @NotNull
                public final AiringScheduleNodes copy(@JsonProperty("nodes") @Nullable List<AniListApi.SeasonNextAiringEpisode> nodes) {
                    return new AiringScheduleNodes(nodes);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof AiringScheduleNodes) && Intrinsics.areEqual(this.nodes, ((AiringScheduleNodes) other).nodes);
                }

                public int hashCode() {
                    if (this.nodes == null) {
                        return 0;
                    }
                    return this.nodes.hashCode();
                }

                @NotNull
                public String toString() {
                    return "AiringScheduleNodes(nodes=" + this.nodes + ')';
                }

                public AiringScheduleNodes(@JsonProperty("nodes") @Nullable List<AniListApi.SeasonNextAiringEpisode> list) {
                    this.nodes = list;
                }

                @Nullable
                public final List<AniListApi.SeasonNextAiringEpisode> getNodes() {
                    return this.nodes;
                }
            }

            public final int totalEpisodes() {
                List<AniListApi.SeasonNextAiringEpisode> nodes;
                AniListApi.SeasonNextAiringEpisode seasonNextAiringEpisode;
                Integer episode;
                AniListApi.SeasonNextAiringEpisode seasonNextAiringEpisode2 = this.nextAiringEpisode;
                if (seasonNextAiringEpisode2 != null && (episode = seasonNextAiringEpisode2.getEpisode()) != null) {
                    return episode.intValue() - 1;
                }
                Integer episode2 = this.episodes;
                if (episode2 == null) {
                    AiringScheduleNodes airingScheduleNodes = this.airingSchedule;
                    episode2 = (airingScheduleNodes == null || (nodes = airingScheduleNodes.getNodes()) == null || (seasonNextAiringEpisode = (AniListApi.SeasonNextAiringEpisode) CollectionsKt.getOrNull(nodes, 0)) == null) ? null : seasonNextAiringEpisode.getEpisode();
                    if (episode2 == null) {
                        return 0;
                    }
                }
                return episode2.intValue();
            }

            @NotNull
            /* JADX INFO: renamed from: getTitle, reason: collision with other method in class */
            public final String m46getTitle() throws Exception {
                String english = this.title.getEnglish();
                if (english != null || (english = this.title.getRomaji()) != null) {
                    return english;
                }
                throw new Exception("Unable to calculate total episodes");
            }

            @Nullable
            /* JADX INFO: renamed from: getCoverImage, reason: collision with other method in class */
            public final String m45getCoverImage() {
                String extraLarge = this.coverImage.getExtraLarge();
                if (extraLarge != null) {
                    return extraLarge;
                }
                String large = this.coverImage.getLarge();
                return large == null ? this.coverImage.getMedium() : large;
            }
        }
    }

    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\bH\b\u0086\b\u0018\u00002\u00020\u0001B¡\u0005\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0016\b\u0003\u0010\u0013\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u0018\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0018\u0012\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019\u0012\u0018\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a\u0012\u0016\b\u0003\u0010\u001b\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b\u0012\u0016\b\u0003\u0010\u001c\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c\u0012\u0016\b\u0003\u0010\u001d\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d\u0012\u0016\b\u0003\u0010\u001e\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001e\u0012\u0018\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f\u0012\u0018\b\u0003\u0010 \u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b( ¢\u0006\u0004\b!\u0010\"J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010A\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010F\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010H\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010I\u001a\u00020\u0014HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010L\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010P\u001a\u00020\u0014HÆ\u0003J\t\u0010Q\u001a\u00020\u0014HÆ\u0003J\t\u0010R\u001a\u00020\u0014HÆ\u0003J\t\u0010S\u001a\u00020\u0014HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J¨\u0005\u0010V\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0016\b\u0003\u0010\u0013\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00132\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00152\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00162\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00172\u0018\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00182\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00192\u0018\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a2\u0016\b\u0003\u0010\u001b\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b2\u0016\b\u0003\u0010\u001c\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c2\u0016\b\u0003\u0010\u001d\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d2\u0016\b\u0003\u0010\u001e\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001e2\u0018\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f2\u0018\b\u0003\u0010 \u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b( HÆ\u0001¢\u0006\u0002\u0010WJ\u0014\u0010X\u001a\u00020\u00142\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010Z\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010[\u001a\u00020\bHÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b&\u0010$R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b)\u0010$R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b*\u0010$R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b,\u0010$R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b-\u0010$R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b.\u0010$R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b/\u0010$R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b1\u0010$R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010(R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u00103R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b4\u0010$R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b5\u0010$R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b7\u0010(R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b8\u0010(R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010(R\u0011\u0010\u001b\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u00103R\u0011\u0010\u001c\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u00103R\u0011\u0010\u001d\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u00103R\u0011\u0010\u001e\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u00103R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b:\u0010$R\u0015\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b;\u0010$¨\u0006\\"}, d2 = {"Lcom/phisher98/StreamPlayAnime$LinkData;", "", "simklId", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "traktId", "imdbId", "", "tmdbId", "tvdbId", "type", "season", "episode", "aniId", "malId", "title", "year", "orgTitle", "isAnime", "", "airedYear", "lastSeason", "epsTitle", "jpTitle", "date", "airedDate", "isAsian", "isBollywood", "isCartoon", "isDub", "anidbEid", "kitsuId", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZLjava/lang/Integer;Ljava/lang/Integer;)V", "getSimklId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTraktId", "getImdbId", "()Ljava/lang/String;", "getTmdbId", "getTvdbId", "getType", "getSeason", "getEpisode", "getAniId", "getMalId", "getTitle", "getYear", "getOrgTitle", "()Z", "getAiredYear", "getLastSeason", "getEpsTitle", "getJpTitle", "getDate", "getAiredDate", "getAnidbEid", "getKitsuId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZLjava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/StreamPlayAnime$LinkData;", "equals", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LinkData {

        @Nullable
        private final String airedDate;

        @Nullable
        private final Integer airedYear;

        @Nullable
        private final Integer aniId;

        @Nullable
        private final Integer anidbEid;

        @Nullable
        private final String date;

        @Nullable
        private final Integer episode;

        @Nullable
        private final String epsTitle;

        @Nullable
        private final String imdbId;
        private final boolean isAnime;
        private final boolean isAsian;
        private final boolean isBollywood;
        private final boolean isCartoon;
        private final boolean isDub;

        @Nullable
        private final String jpTitle;

        @Nullable
        private final Integer kitsuId;

        @Nullable
        private final Integer lastSeason;

        @Nullable
        private final Integer malId;

        @Nullable
        private final String orgTitle;

        @Nullable
        private final Integer season;

        @Nullable
        private final Integer simklId;

        @Nullable
        private final String title;

        @Nullable
        private final Integer tmdbId;

        @Nullable
        private final Integer traktId;

        @Nullable
        private final Integer tvdbId;

        @Nullable
        private final String type;

        @Nullable
        private final Integer year;

        public LinkData() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, false, false, false, false, null, null, 67108863, null);
        }

        public static /* synthetic */ LinkData copy$default(LinkData linkData, Integer num, Integer num2, String str, Integer num3, Integer num4, String str2, Integer num5, Integer num6, Integer num7, Integer num8, String str3, Integer num9, String str4, boolean z, Integer num10, Integer num11, String str5, String str6, String str7, String str8, boolean z2, boolean z3, boolean z4, boolean z5, Integer num12, Integer num13, int i, Object obj) {
            Integer num14;
            Integer num15;
            Integer num16 = (i & 1) != 0 ? linkData.simklId : num;
            Integer num17 = (i & 2) != 0 ? linkData.traktId : num2;
            String str9 = (i & 4) != 0 ? linkData.imdbId : str;
            Integer num18 = (i & 8) != 0 ? linkData.tmdbId : num3;
            Integer num19 = (i & 16) != 0 ? linkData.tvdbId : num4;
            String str10 = (i & 32) != 0 ? linkData.type : str2;
            Integer num20 = (i & 64) != 0 ? linkData.season : num5;
            Integer num21 = (i & 128) != 0 ? linkData.episode : num6;
            Integer num22 = (i & 256) != 0 ? linkData.aniId : num7;
            Integer num23 = (i & 512) != 0 ? linkData.malId : num8;
            String str11 = (i & 1024) != 0 ? linkData.title : str3;
            Integer num24 = (i & 2048) != 0 ? linkData.year : num9;
            String str12 = (i & 4096) != 0 ? linkData.orgTitle : str4;
            boolean z6 = (i & 8192) != 0 ? linkData.isAnime : z;
            Integer num25 = num16;
            Integer num26 = (i & 16384) != 0 ? linkData.airedYear : num10;
            Integer num27 = (i & 32768) != 0 ? linkData.lastSeason : num11;
            String str13 = (i & 65536) != 0 ? linkData.epsTitle : str5;
            String str14 = (i & 131072) != 0 ? linkData.jpTitle : str6;
            String str15 = (i & 262144) != 0 ? linkData.date : str7;
            String str16 = (i & 524288) != 0 ? linkData.airedDate : str8;
            boolean z7 = (i & 1048576) != 0 ? linkData.isAsian : z2;
            boolean z8 = (i & 2097152) != 0 ? linkData.isBollywood : z3;
            boolean z9 = (i & 4194304) != 0 ? linkData.isCartoon : z4;
            boolean z10 = (i & 8388608) != 0 ? linkData.isDub : z5;
            Integer num28 = (i & 16777216) != 0 ? linkData.anidbEid : num12;
            if ((i & 33554432) != 0) {
                num15 = num28;
                num14 = linkData.kitsuId;
            } else {
                num14 = num13;
                num15 = num28;
            }
            return linkData.copy(num25, num17, str9, num18, num19, str10, num20, num21, num22, num23, str11, num24, str12, z6, num26, num27, str13, str14, str15, str16, z7, z8, z9, z10, num15, num14);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getSimklId() {
            return this.simklId;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getMalId() {
            return this.malId;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getOrgTitle() {
            return this.orgTitle;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final boolean getIsAnime() {
            return this.isAnime;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Integer getAiredYear() {
            return this.airedYear;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Integer getLastSeason() {
            return this.lastSeason;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getEpsTitle() {
            return this.epsTitle;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final String getJpTitle() {
            return this.jpTitle;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final String getDate() {
            return this.date;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTraktId() {
            return this.traktId;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final String getAiredDate() {
            return this.airedDate;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final boolean getIsAsian() {
            return this.isAsian;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final boolean getIsBollywood() {
            return this.isBollywood;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final boolean getIsCartoon() {
            return this.isCartoon;
        }

        /* JADX INFO: renamed from: component24, reason: from getter */
        public final boolean getIsDub() {
            return this.isDub;
        }

        @Nullable
        /* JADX INFO: renamed from: component25, reason: from getter */
        public final Integer getAnidbEid() {
            return this.anidbEid;
        }

        @Nullable
        /* JADX INFO: renamed from: component26, reason: from getter */
        public final Integer getKitsuId() {
            return this.kitsuId;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getTvdbId() {
            return this.tvdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getAniId() {
            return this.aniId;
        }

        @NotNull
        public final LinkData copy(@JsonProperty("simklId") @Nullable Integer simklId, @JsonProperty("traktId") @Nullable Integer traktId, @JsonProperty("imdbId") @Nullable String imdbId, @JsonProperty("tmdbId") @Nullable Integer tmdbId, @JsonProperty("tvdbId") @Nullable Integer tvdbId, @JsonProperty("type") @Nullable String type, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("aniId") @Nullable Integer aniId, @JsonProperty("malId") @Nullable Integer malId, @JsonProperty("title") @Nullable String title, @JsonProperty("year") @Nullable Integer year, @JsonProperty("orgTitle") @Nullable String orgTitle, @JsonProperty("isAnime") boolean isAnime, @JsonProperty("airedYear") @Nullable Integer airedYear, @JsonProperty("lastSeason") @Nullable Integer lastSeason, @JsonProperty("epsTitle") @Nullable String epsTitle, @JsonProperty("jpTitle") @Nullable String jpTitle, @JsonProperty("date") @Nullable String date, @JsonProperty("airedDate") @Nullable String airedDate, @JsonProperty("isAsian") boolean isAsian, @JsonProperty("isBollywood") boolean isBollywood, @JsonProperty("isCartoon") boolean isCartoon, @JsonProperty("isDub") boolean isDub, @JsonProperty("anidbEid") @Nullable Integer anidbEid, @JsonProperty("kitsuId") @Nullable Integer kitsuId) {
            return new LinkData(simklId, traktId, imdbId, tmdbId, tvdbId, type, season, episode, aniId, malId, title, year, orgTitle, isAnime, airedYear, lastSeason, epsTitle, jpTitle, date, airedDate, isAsian, isBollywood, isCartoon, isDub, anidbEid, kitsuId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkData)) {
                return false;
            }
            LinkData linkData = (LinkData) other;
            return Intrinsics.areEqual(this.simklId, linkData.simklId) && Intrinsics.areEqual(this.traktId, linkData.traktId) && Intrinsics.areEqual(this.imdbId, linkData.imdbId) && Intrinsics.areEqual(this.tmdbId, linkData.tmdbId) && Intrinsics.areEqual(this.tvdbId, linkData.tvdbId) && Intrinsics.areEqual(this.type, linkData.type) && Intrinsics.areEqual(this.season, linkData.season) && Intrinsics.areEqual(this.episode, linkData.episode) && Intrinsics.areEqual(this.aniId, linkData.aniId) && Intrinsics.areEqual(this.malId, linkData.malId) && Intrinsics.areEqual(this.title, linkData.title) && Intrinsics.areEqual(this.year, linkData.year) && Intrinsics.areEqual(this.orgTitle, linkData.orgTitle) && this.isAnime == linkData.isAnime && Intrinsics.areEqual(this.airedYear, linkData.airedYear) && Intrinsics.areEqual(this.lastSeason, linkData.lastSeason) && Intrinsics.areEqual(this.epsTitle, linkData.epsTitle) && Intrinsics.areEqual(this.jpTitle, linkData.jpTitle) && Intrinsics.areEqual(this.date, linkData.date) && Intrinsics.areEqual(this.airedDate, linkData.airedDate) && this.isAsian == linkData.isAsian && this.isBollywood == linkData.isBollywood && this.isCartoon == linkData.isCartoon && this.isDub == linkData.isDub && Intrinsics.areEqual(this.anidbEid, linkData.anidbEid) && Intrinsics.areEqual(this.kitsuId, linkData.kitsuId);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((((((((((this.simklId == null ? 0 : this.simklId.hashCode()) * 31) + (this.traktId == null ? 0 : this.traktId.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.tmdbId == null ? 0 : this.tmdbId.hashCode())) * 31) + (this.tvdbId == null ? 0 : this.tvdbId.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.aniId == null ? 0 : this.aniId.hashCode())) * 31) + (this.malId == null ? 0 : this.malId.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.orgTitle == null ? 0 : this.orgTitle.hashCode())) * 31) + StreamPlayAnime$LinkData$$ExternalSyntheticBackport0.m22m(this.isAnime)) * 31) + (this.airedYear == null ? 0 : this.airedYear.hashCode())) * 31) + (this.lastSeason == null ? 0 : this.lastSeason.hashCode())) * 31) + (this.epsTitle == null ? 0 : this.epsTitle.hashCode())) * 31) + (this.jpTitle == null ? 0 : this.jpTitle.hashCode())) * 31) + (this.date == null ? 0 : this.date.hashCode())) * 31) + (this.airedDate == null ? 0 : this.airedDate.hashCode())) * 31) + StreamPlayAnime$LinkData$$ExternalSyntheticBackport0.m22m(this.isAsian)) * 31) + StreamPlayAnime$LinkData$$ExternalSyntheticBackport0.m22m(this.isBollywood)) * 31) + StreamPlayAnime$LinkData$$ExternalSyntheticBackport0.m22m(this.isCartoon)) * 31) + StreamPlayAnime$LinkData$$ExternalSyntheticBackport0.m22m(this.isDub)) * 31) + (this.anidbEid == null ? 0 : this.anidbEid.hashCode())) * 31) + (this.kitsuId != null ? this.kitsuId.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LinkData(simklId=").append(this.simklId).append(", traktId=").append(this.traktId).append(", imdbId=").append(this.imdbId).append(", tmdbId=").append(this.tmdbId).append(", tvdbId=").append(this.tvdbId).append(", type=").append(this.type).append(", season=").append(this.season).append(", episode=").append(this.episode).append(", aniId=").append(this.aniId).append(", malId=").append(this.malId).append(", title=").append(this.title).append(", year=");
            sb.append(this.year).append(", orgTitle=").append(this.orgTitle).append(", isAnime=").append(this.isAnime).append(", airedYear=").append(this.airedYear).append(", lastSeason=").append(this.lastSeason).append(", epsTitle=").append(this.epsTitle).append(", jpTitle=").append(this.jpTitle).append(", date=").append(this.date).append(", airedDate=").append(this.airedDate).append(", isAsian=").append(this.isAsian).append(", isBollywood=").append(this.isBollywood).append(", isCartoon=").append(this.isCartoon);
            sb.append(", isDub=").append(this.isDub).append(", anidbEid=").append(this.anidbEid).append(", kitsuId=").append(this.kitsuId).append(')');
            return sb.toString();
        }

        public LinkData(@JsonProperty("simklId") @Nullable Integer simklId, @JsonProperty("traktId") @Nullable Integer traktId, @JsonProperty("imdbId") @Nullable String imdbId, @JsonProperty("tmdbId") @Nullable Integer tmdbId, @JsonProperty("tvdbId") @Nullable Integer tvdbId, @JsonProperty("type") @Nullable String type, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("aniId") @Nullable Integer aniId, @JsonProperty("malId") @Nullable Integer malId, @JsonProperty("title") @Nullable String title, @JsonProperty("year") @Nullable Integer year, @JsonProperty("orgTitle") @Nullable String orgTitle, @JsonProperty("isAnime") boolean isAnime, @JsonProperty("airedYear") @Nullable Integer airedYear, @JsonProperty("lastSeason") @Nullable Integer lastSeason, @JsonProperty("epsTitle") @Nullable String epsTitle, @JsonProperty("jpTitle") @Nullable String jpTitle, @JsonProperty("date") @Nullable String date, @JsonProperty("airedDate") @Nullable String airedDate, @JsonProperty("isAsian") boolean isAsian, @JsonProperty("isBollywood") boolean isBollywood, @JsonProperty("isCartoon") boolean isCartoon, @JsonProperty("isDub") boolean isDub, @JsonProperty("anidbEid") @Nullable Integer anidbEid, @JsonProperty("kitsuId") @Nullable Integer kitsuId) {
            this.simklId = simklId;
            this.traktId = traktId;
            this.imdbId = imdbId;
            this.tmdbId = tmdbId;
            this.tvdbId = tvdbId;
            this.type = type;
            this.season = season;
            this.episode = episode;
            this.aniId = aniId;
            this.malId = malId;
            this.title = title;
            this.year = year;
            this.orgTitle = orgTitle;
            this.isAnime = isAnime;
            this.airedYear = airedYear;
            this.lastSeason = lastSeason;
            this.epsTitle = epsTitle;
            this.jpTitle = jpTitle;
            this.date = date;
            this.airedDate = airedDate;
            this.isAsian = isAsian;
            this.isBollywood = isBollywood;
            this.isCartoon = isCartoon;
            this.isDub = isDub;
            this.anidbEid = anidbEid;
            this.kitsuId = kitsuId;
        }

        public /* synthetic */ LinkData(Integer num, Integer num2, String str, Integer num3, Integer num4, String str2, Integer num5, Integer num6, Integer num7, Integer num8, String str3, Integer num9, String str4, boolean z, Integer num10, Integer num11, String str5, String str6, String str7, String str8, boolean z2, boolean z3, boolean z4, boolean z5, Integer num12, Integer num13, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : num5, (i & 128) != 0 ? null : num6, (i & 256) != 0 ? null : num7, (i & 512) != 0 ? null : num8, (i & 1024) != 0 ? null : str3, (i & 2048) != 0 ? null : num9, (i & 4096) != 0 ? null : str4, (i & 8192) != 0 ? false : z, (i & 16384) != 0 ? null : num10, (i & 32768) != 0 ? null : num11, (i & 65536) != 0 ? null : str5, (i & 131072) != 0 ? null : str6, (i & 262144) != 0 ? null : str7, (i & 524288) != 0 ? null : str8, (i & 1048576) != 0 ? false : z2, (i & 2097152) != 0 ? false : z3, (i & 4194304) != 0 ? false : z4, (i & 8388608) == 0 ? z5 : false, (i & 16777216) != 0 ? null : num12, (i & 33554432) != 0 ? null : num13);
        }

        @Nullable
        public final Integer getSimklId() {
            return this.simklId;
        }

        @Nullable
        public final Integer getTraktId() {
            return this.traktId;
        }

        @Nullable
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @Nullable
        public final Integer getTvdbId() {
            return this.tvdbId;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        public final Integer getAniId() {
            return this.aniId;
        }

        @Nullable
        public final Integer getMalId() {
            return this.malId;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        public final String getOrgTitle() {
            return this.orgTitle;
        }

        public final boolean isAnime() {
            return this.isAnime;
        }

        @Nullable
        public final Integer getAiredYear() {
            return this.airedYear;
        }

        @Nullable
        public final Integer getLastSeason() {
            return this.lastSeason;
        }

        @Nullable
        public final String getEpsTitle() {
            return this.epsTitle;
        }

        @Nullable
        public final String getJpTitle() {
            return this.jpTitle;
        }

        @Nullable
        public final String getDate() {
            return this.date;
        }

        @Nullable
        public final String getAiredDate() {
            return this.airedDate;
        }

        public final boolean isAsian() {
            return this.isAsian;
        }

        public final boolean isBollywood() {
            return this.isBollywood;
        }

        public final boolean isCartoon() {
            return this.isCartoon;
        }

        public final boolean isDub() {
            return this.isDub;
        }

        @Nullable
        public final Integer getAnidbEid() {
            return this.anidbEid;
        }

        @Nullable
        public final Integer getKitsuId() {
            return this.kitsuId;
        }
    }

    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B·\u0002\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0016\b\u0001\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0001\u0010\n\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0016\b\u0001\u0010\u000b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0016\b\u0001\u0010\f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0016\b\u0001\u0010\r\u001a\u00020\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0016\b\u0001\u0010\u0010\u001a\u00020\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u001c\b\u0001\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u000eHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00105\u001a\u00020\u0011HÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\b0\u0013HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0015HÆ\u0003J¾\u0002\u00108\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0016\b\u0003\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0016\b\u0003\u0010\u000b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0016\b\u0003\u0010\f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0016\b\u0003\u0010\r\u001a\u00020\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0016\b\u0003\u0010\u0010\u001a\u00020\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u001c\b\u0003\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0015:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014HÆ\u0001¢\u0006\u0002\u00109J\u0014\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010=\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010>\u001a\u00020\bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006?"}, d2 = {"Lcom/phisher98/StreamPlayAnime$Media;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "idMal", "season", "", "seasonYear", "format", "averageScore", "episodes", "title", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "description", "coverImage", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "synonyms", "", "nextAiringEpisode", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "<init>", "(ILjava/lang/Integer;Ljava/lang/String;ILjava/lang/String;IILcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/util/List;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;)V", "getId", "()I", "getIdMal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeason", "()Ljava/lang/String;", "getSeasonYear", "getFormat", "getAverageScore", "getEpisodes", "getTitle", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "getDescription", "getCoverImage", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "getSynonyms", "()Ljava/util/List;", "getNextAiringEpisode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(ILjava/lang/Integer;Ljava/lang/String;ILjava/lang/String;IILcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/util/List;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;)Lcom/phisher98/StreamPlayAnime$Media;", "equals", "", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Media {
        private final int averageScore;

        @NotNull
        private final AniListApi.CoverImage coverImage;

        @Nullable
        private final String description;
        private final int episodes;

        @Nullable
        private final String format;
        private final int id;

        @Nullable
        private final Integer idMal;

        @Nullable
        private final AniListApi.SeasonNextAiringEpisode nextAiringEpisode;

        @Nullable
        private final String season;
        private final int seasonYear;

        @NotNull
        private final List<String> synonyms;

        @NotNull
        private final AniListApi.Title title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Media copy$default(Media media, int i, Integer num, String str, int i2, String str2, int i3, int i4, AniListApi.Title title, String str3, AniListApi.CoverImage coverImage, List list, AniListApi.SeasonNextAiringEpisode seasonNextAiringEpisode, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = media.id;
            }
            if ((i5 & 2) != 0) {
                num = media.idMal;
            }
            if ((i5 & 4) != 0) {
                str = media.season;
            }
            if ((i5 & 8) != 0) {
                i2 = media.seasonYear;
            }
            if ((i5 & 16) != 0) {
                str2 = media.format;
            }
            if ((i5 & 32) != 0) {
                i3 = media.averageScore;
            }
            if ((i5 & 64) != 0) {
                i4 = media.episodes;
            }
            if ((i5 & 128) != 0) {
                title = media.title;
            }
            if ((i5 & 256) != 0) {
                str3 = media.description;
            }
            if ((i5 & 512) != 0) {
                coverImage = media.coverImage;
            }
            if ((i5 & 1024) != 0) {
                list = media.synonyms;
            }
            if ((i5 & 2048) != 0) {
                seasonNextAiringEpisode = media.nextAiringEpisode;
            }
            List list2 = list;
            AniListApi.SeasonNextAiringEpisode seasonNextAiringEpisode2 = seasonNextAiringEpisode;
            String str4 = str3;
            AniListApi.CoverImage coverImage2 = coverImage;
            int i6 = i4;
            AniListApi.Title title2 = title;
            String str5 = str2;
            int i7 = i3;
            return media.copy(i, num, str, i2, str5, i7, i6, title2, str4, coverImage2, list2, seasonNextAiringEpisode2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final AniListApi.CoverImage getCoverImage() {
            return this.coverImage;
        }

        @NotNull
        public final List<String> component11() {
            return this.synonyms;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final AniListApi.SeasonNextAiringEpisode getNextAiringEpisode() {
            return this.nextAiringEpisode;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getIdMal() {
            return this.idMal;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSeason() {
            return this.season;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getSeasonYear() {
            return this.seasonYear;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getFormat() {
            return this.format;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getAverageScore() {
            return this.averageScore;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getEpisodes() {
            return this.episodes;
        }

        @NotNull
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final AniListApi.Title getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final Media copy(@JsonProperty("id") int id, @JsonProperty("idMal") @Nullable Integer idMal, @JsonProperty("season") @Nullable String season, @JsonProperty("seasonYear") int seasonYear, @JsonProperty("format") @Nullable String format, @JsonProperty("averageScore") int averageScore, @JsonProperty("episodes") int episodes, @JsonProperty("title") @NotNull AniListApi.Title title, @JsonProperty("description") @Nullable String description, @JsonProperty("coverImage") @NotNull AniListApi.CoverImage coverImage, @JsonProperty("synonyms") @NotNull List<String> synonyms, @JsonProperty("nextAiringEpisode") @Nullable AniListApi.SeasonNextAiringEpisode nextAiringEpisode) {
            return new Media(id, idMal, season, seasonYear, format, averageScore, episodes, title, description, coverImage, synonyms, nextAiringEpisode);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Media)) {
                return false;
            }
            Media media = (Media) other;
            return this.id == media.id && Intrinsics.areEqual(this.idMal, media.idMal) && Intrinsics.areEqual(this.season, media.season) && this.seasonYear == media.seasonYear && Intrinsics.areEqual(this.format, media.format) && this.averageScore == media.averageScore && this.episodes == media.episodes && Intrinsics.areEqual(this.title, media.title) && Intrinsics.areEqual(this.description, media.description) && Intrinsics.areEqual(this.coverImage, media.coverImage) && Intrinsics.areEqual(this.synonyms, media.synonyms) && Intrinsics.areEqual(this.nextAiringEpisode, media.nextAiringEpisode);
        }

        public int hashCode() {
            return (((((((((((((((((((((this.id * 31) + (this.idMal == null ? 0 : this.idMal.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + this.seasonYear) * 31) + (this.format == null ? 0 : this.format.hashCode())) * 31) + this.averageScore) * 31) + this.episodes) * 31) + this.title.hashCode()) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + this.coverImage.hashCode()) * 31) + this.synonyms.hashCode()) * 31) + (this.nextAiringEpisode != null ? this.nextAiringEpisode.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Media(id=").append(this.id).append(", idMal=").append(this.idMal).append(", season=").append(this.season).append(", seasonYear=").append(this.seasonYear).append(", format=").append(this.format).append(", averageScore=").append(this.averageScore).append(", episodes=").append(this.episodes).append(", title=").append(this.title).append(", description=").append(this.description).append(", coverImage=").append(this.coverImage).append(", synonyms=").append(this.synonyms).append(", nextAiringEpisode=");
            sb.append(this.nextAiringEpisode).append(')');
            return sb.toString();
        }

        public Media(@JsonProperty("id") int id, @JsonProperty("idMal") @Nullable Integer idMal, @JsonProperty("season") @Nullable String season, @JsonProperty("seasonYear") int seasonYear, @JsonProperty("format") @Nullable String format, @JsonProperty("averageScore") int averageScore, @JsonProperty("episodes") int episodes, @JsonProperty("title") @NotNull AniListApi.Title title, @JsonProperty("description") @Nullable String description, @JsonProperty("coverImage") @NotNull AniListApi.CoverImage coverImage, @JsonProperty("synonyms") @NotNull List<String> list, @JsonProperty("nextAiringEpisode") @Nullable AniListApi.SeasonNextAiringEpisode nextAiringEpisode) {
            this.id = id;
            this.idMal = idMal;
            this.season = season;
            this.seasonYear = seasonYear;
            this.format = format;
            this.averageScore = averageScore;
            this.episodes = episodes;
            this.title = title;
            this.description = description;
            this.coverImage = coverImage;
            this.synonyms = list;
            this.nextAiringEpisode = nextAiringEpisode;
        }

        public final int getId() {
            return this.id;
        }

        @Nullable
        public final Integer getIdMal() {
            return this.idMal;
        }

        @Nullable
        public final String getSeason() {
            return this.season;
        }

        public final int getSeasonYear() {
            return this.seasonYear;
        }

        @Nullable
        public final String getFormat() {
            return this.format;
        }

        public final int getAverageScore() {
            return this.averageScore;
        }

        public final int getEpisodes() {
            return this.episodes;
        }

        @NotNull
        public final AniListApi.Title getTitle() {
            return this.title;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final AniListApi.CoverImage getCoverImage() {
            return this.coverImage;
        }

        @NotNull
        public final List<String> getSynonyms() {
            return this.synonyms;
        }

        @Nullable
        public final AniListApi.SeasonNextAiringEpisode getNextAiringEpisode() {
            return this.nextAiringEpisode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:47:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object tmdbToAnimeId(String title, Integer year, TvType type, Continuation<? super AniIds> continuation) {
        C01041 c01041;
        AniMedia aniMedia;
        Object obj;
        Object safe;
        AniMedia res;
        AniData it;
        ArrayList<AniMedia> media;
        if (continuation instanceof C01041) {
            c01041 = (C01041) continuation;
            if ((c01041.label & Integer.MIN_VALUE) != 0) {
                c01041.label -= Integer.MIN_VALUE;
            } else {
                c01041 = new C01041(continuation);
            }
        } else {
            c01041 = new C01041(continuation);
        }
        Object $result = c01041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c01041.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String str = title;
                if (str == null || StringsKt.isBlank(str)) {
                    return new AniIds(null, null);
                }
                Pair[] pairArr = new Pair[4];
                pairArr[0] = TuplesKt.to("search", title);
                pairArr[1] = TuplesKt.to("sort", CollectionsKt.listOf("SEARCH_MATCH"));
                pairArr[2] = TuplesKt.to("type", "ANIME");
                pairArr[3] = TuplesKt.to("format", CollectionsKt.listOf(new String[]{type == TvType.AnimeMovie ? "MOVIE" : "TV", "ONA", "OVA"}));
                Map variables = MapsKt.mutableMapOf(pairArr);
                RequestBody data = RequestBody.Companion.create(AppUtils.INSTANCE.toJson(MapsKt.mapOf(new Pair[]{TuplesKt.to("query", "query (\n  $page: Int = 1\n  $search: String\n  $sort: [MediaSort] = [POPULARITY_DESC, SCORE_DESC]\n  $type: MediaType\n  $season: MediaSeason\n  $seasonYear: Int\n  $format: [MediaFormat]\n) {\n  Page(page: $page, perPage: 20) {\n    media(\n      search: $search\n      sort: $sort\n      type: $type\n      season: $season\n      seasonYear: $seasonYear\n      format_in: $format\n    ) {\n      id\n      idMal\n    }\n  }\n}"), TuplesKt.to("variables", variables)})), MediaType.Companion.parse("application/json;charset=utf-8"));
                Requests app = MainActivityKt.getApp();
                c01041.L$0 = SpillingKt.nullOutSpilledVariable(title);
                c01041.L$1 = SpillingKt.nullOutSpilledVariable(year);
                c01041.L$2 = SpillingKt.nullOutSpilledVariable(type);
                c01041.L$3 = SpillingKt.nullOutSpilledVariable("query (\n  $page: Int = 1\n  $search: String\n  $sort: [MediaSort] = [POPULARITY_DESC, SCORE_DESC]\n  $type: MediaType\n  $season: MediaSeason\n  $seasonYear: Int\n  $format: [MediaFormat]\n) {\n  Page(page: $page, perPage: 20) {\n    media(\n      search: $search\n      sort: $sort\n      type: $type\n      season: $season\n      seasonYear: $seasonYear\n      format_in: $format\n    ) {\n      id\n      idMal\n    }\n  }\n}");
                c01041.L$4 = SpillingKt.nullOutSpilledVariable(variables);
                c01041.L$5 = SpillingKt.nullOutSpilledVariable(data);
                c01041.label = 1;
                aniMedia = null;
                Object objPost$default = Requests.post$default(app, StreamPlay.anilistAPI, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, data, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c01041, 65278, (Object) null);
                if (objPost$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objPost$default;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                aniMedia = null;
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) obj;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(AniSearch.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = aniMedia;
        }
        AniSearch aniSearch = (AniSearch) safe;
        if (aniSearch == null || (it = aniSearch.getData()) == null) {
            res = aniMedia;
        } else {
            AniPage page = it.getPage();
            if (page == null || (media = page.getMedia()) == null) {
                media = it.getMedia();
            }
            if (media != null) {
                res = (AniMedia) CollectionsKt.firstOrNull(media);
            } else {
                res = aniMedia;
            }
        }
        return new AniIds(res != null ? res.getId() : aniMedia, res != null ? res.getIdMal() : aniMedia);
    }

    private final Integer extractSeason(String title) {
        String seasonStr;
        MatchGroupCollection groups;
        MatchGroup matchGroup;
        MatchGroupCollection groups2;
        MatchGroup matchGroup2;
        Regex regex = new Regex("(?i)(?:season\\s*(\\d+)|(\\d+)(?:st|nd|rd|th)?\\s*season)");
        MatchResult match = Regex.find$default(regex, title, 0, 2, (Object) null);
        if (match == null || (groups2 = match.getGroups()) == null || (matchGroup2 = groups2.get(1)) == null || (seasonStr = matchGroup2.getValue()) == null) {
            seasonStr = (match == null || (groups = match.getGroups()) == null || (matchGroup = groups.get(2)) == null) ? "1" : matchGroup.getValue();
        }
        return StringsKt.toIntOrNull(seasonStr);
    }
}
