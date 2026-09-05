package com.cncverse;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
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
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CastleTvProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CastleTvProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 B2\u00020\u0001:\u0015BCDEFGHIJKLMNOPQRSTUVB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005H\u0002J\u001a\u0010!\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J\u001e\u0010&\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020/0$2\u0006\u00100\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00101J\u0018\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00101JF\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u000e2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;092\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020;09H\u0096@¢\u0006\u0002\u0010>J\b\u0010?\u001a\u00020;H\u0002J\b\u0010@\u001a\u00020;H\u0002J\u0010\u0010A\u001a\u00020;2\u0006\u00104\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006W"}, d2 = {"Lcom/cncverse/CastleTvProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "keySupFixx", "mapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "getSecurityKey", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deriveKey", "", "apiKeyB64", "decryptData", "encryptedB64", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showSubscriptionPopupIfNeeded", "showTelegramPopup", "openInExternalBrowser", "Companion", "CastleApiResponse", "SecurityKeyResponse", "DecryptedResponse", "HomePageData", "HomePageRow", "ContentItem", "MovieDetailsResponse", "MovieDetails", "Person", "ApiEpisode", "VideoQuality", "Track", "Season", "Titbit", "SearchApiResponse", "SearchData", "SearchResultItem", "VideoResponse", "VideoData", "SubtitleData", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCastleTvProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CastleTvProvider.kt\ncom/cncverse/CastleTvProvider\n+ 2 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1105:1\n116#2:1106\n54#2:1107\n117#2:1108\n61#2,8:1109\n71#2:1118\n116#2:1119\n54#2:1120\n117#2:1121\n61#2,8:1122\n71#2:1131\n116#2:1132\n54#2:1133\n117#2:1134\n61#2,8:1135\n71#2:1144\n116#2:1173\n54#2:1174\n117#2:1175\n61#2,8:1176\n71#2:1185\n116#2:1200\n54#2:1201\n117#2:1202\n61#2,8:1203\n71#2:1212\n116#2:1217\n54#2:1218\n117#2:1219\n61#2,8:1220\n71#2:1229\n116#2:1235\n54#2:1236\n117#2:1237\n61#2,8:1238\n71#2:1247\n116#2:1266\n54#2:1267\n117#2:1268\n61#2,8:1269\n71#2:1278\n116#2:1281\n54#2:1282\n117#2:1283\n61#2,8:1284\n71#2:1293\n1#3:1117\n1#3:1130\n1#3:1143\n1#3:1167\n1#3:1170\n1#3:1184\n1#3:1197\n1#3:1211\n1#3:1228\n1#3:1246\n1#3:1248\n1#3:1263\n1#3:1277\n1#3:1292\n1#3:1296\n1642#4,10:1145\n1915#4:1155\n1642#4,10:1156\n1915#4:1166\n1916#4:1168\n1652#4:1169\n1916#4:1171\n1652#4:1172\n1642#4,10:1186\n1915#4:1196\n1916#4:1198\n1652#4:1199\n1586#4:1213\n1661#4,3:1214\n1915#4,2:1230\n1924#4,3:1232\n1807#4,3:1249\n1642#4,10:1252\n1915#4:1262\n1916#4:1264\n1652#4:1265\n1915#4,2:1279\n1915#4,2:1294\n*S KotlinDebug\n*F\n+ 1 CastleTvProvider.kt\ncom/cncverse/CastleTvProvider\n*L\n303#1:1106\n303#1:1107\n303#1:1108\n303#1:1109,8\n303#1:1118\n363#1:1119\n363#1:1120\n363#1:1121\n363#1:1122,8\n363#1:1131\n377#1:1132\n377#1:1133\n377#1:1134\n377#1:1135,8\n377#1:1144\n439#1:1173\n439#1:1174\n439#1:1175\n439#1:1176,8\n439#1:1185\n490#1:1200\n490#1:1201\n490#1:1202\n490#1:1203,8\n490#1:1212\n534#1:1217\n534#1:1218\n534#1:1219\n534#1:1220,8\n534#1:1229\n652#1:1235\n652#1:1236\n652#1:1237\n652#1:1238,8\n652#1:1247\n709#1:1266\n709#1:1267\n709#1:1268\n709#1:1269,8\n709#1:1278\n801#1:1281\n801#1:1282\n801#1:1283\n801#1:1284,8\n801#1:1293\n303#1:1117\n363#1:1130\n377#1:1143\n382#1:1167\n380#1:1170\n439#1:1184\n442#1:1197\n490#1:1211\n534#1:1228\n652#1:1246\n674#1:1263\n709#1:1277\n801#1:1292\n380#1:1145,10\n380#1:1155\n382#1:1156,10\n382#1:1166\n382#1:1168\n382#1:1169\n380#1:1171\n380#1:1172\n442#1:1186,10\n442#1:1196\n442#1:1198\n442#1:1199\n502#1:1213\n502#1:1214,3\n536#1:1230,2\n554#1:1232,3\n670#1:1249,3\n674#1:1252,10\n674#1:1262\n674#1:1264\n674#1:1265\n742#1:1279,2\n834#1:1294,2\n*E\n"})
public final class CastleTvProvider extends MainAPI {
    private static final long BROWSER_DEBOUNCE_MS = 10000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String OMG10 = "aHR0cHM6Ly9vbWcxMC5jb20vNC8xMTEwNDQ4OQ==";

    @Nullable
    private static Context context;
    private static volatile boolean csGuardWasEverActive;
    private static volatile long lastBrowserOpenMs;
    private static volatile boolean subscriptionPopupShown;
    private static volatile boolean telegramPopupShown;

    @NotNull
    private final List<MainPageData> mainPage;

    @NotNull
    private final ObjectMapper mapper;

    @NotNull
    private String mainUrl = "https://api.hlowb.com";

    @NotNull
    private String name = "Castle TV (Use VLC)";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "ta";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private final String keySupFixx = "T!BgJB";

    /* JADX INFO: renamed from: com.cncverse.CastleTvProvider$getMainPage$1 */
    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CastleTvProvider", f = "CastleTvProvider.kt", i = {0, 0, 1, 1, 1, 1}, l = {359, 361}, m = "getMainPage", n = {"request", "page", "request", "securityKey", "url", "page"}, nl = {360, 362}, s = {"L$0", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
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
            return CastleTvProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.CastleTvProvider$getSecurityKey$1 */
    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CastleTvProvider", f = "CastleTvProvider.kt", i = {0}, l = {302}, m = "getSecurityKey", n = {"url"}, nl = {303}, s = {"L$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CastleTvProvider.this.getSecurityKey((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.CastleTvProvider$load$1 */
    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CastleTvProvider", f = "CastleTvProvider.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {475, 478, 528, 566, 590}, m = "load", n = {"url", "movieId", "url", "movieId", "securityKey", "detailsUrl", "url", "movieId", "securityKey", "detailsUrl", "response", "encryptedData", "decryptedJson", "detailsResponse", "details", "title", "posterUrl", "backgroundPosterUrl", "plot", "year", "rating", "tags", "actors", "recommendations", "allEpisodes", "season", "seasonId", "seasonUrl", "isSeriesLike", "seasonNumber", "url", "movieId", "securityKey", "detailsUrl", "response", "encryptedData", "decryptedJson", "detailsResponse", "details", "title", "posterUrl", "backgroundPosterUrl", "plot", "year", "rating", "tags", "actors", "recommendations", "allEpisodes", "isSeriesLike", "url", "movieId", "securityKey", "detailsUrl", "response", "encryptedData", "decryptedJson", "detailsResponse", "details", "title", "posterUrl", "backgroundPosterUrl", "plot", "year", "rating", "tags", "actors", "recommendations", "episode", "isSeriesLike"}, nl = {476, 479, 529, 589, 609}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$20", "L$21", "L$22", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "I$0"}, v = 2)
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

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CastleTvProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.CastleTvProvider$loadLinks$1 */
    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CastleTvProvider", f = "CastleTvProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {648, 650, 695, 720, 745, 785, 812, 837}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "parts", "movieId", "episodeId", "isCasting", "data", "subtitleCallback", "callback", "parts", "movieId", "episodeId", "securityKey", "detailsUrl", "isCasting", "data", "subtitleCallback", "callback", "parts", "movieId", "episodeId", "securityKey", "detailsUrl", "detailsResponse", "detailsDecrypted", "details", "episode", "availableTracks", "resolutions", "firstTrack", "allLanguageNames", "videoUrl", "postBody", "isCasting", "videoLoaded", "hasIndividualVideo", "languageId", "resolution", "data", "subtitleCallback", "callback", "parts", "movieId", "episodeId", "securityKey", "detailsUrl", "detailsResponse", "detailsDecrypted", "details", "episode", "availableTracks", "resolutions", "firstTrack", "allLanguageNames", "videoUrl", "postBody", "videoResponse", "encryptedData", "decryptedJson", "videoData", "qualityName", "isCasting", "videoLoaded", "hasIndividualVideo", "languageId", "resolution", "data", "subtitleCallback", "callback", "parts", "movieId", "episodeId", "securityKey", "detailsUrl", "detailsResponse", "detailsDecrypted", "details", "episode", "availableTracks", "resolutions", "firstTrack", "allLanguageNames", "videoUrl", "postBody", "videoResponse", "encryptedData", "decryptedJson", "videoData", "qualityName", "$this$forEach$iv", "element$iv", "subtitle", "isCasting", "videoLoaded", "hasIndividualVideo", "languageId", "resolution", "$i$f$forEach", "$i$a$-forEach-CastleTvProvider$loadLinks$4", "data", "subtitleCallback", "callback", "parts", "movieId", "episodeId", "securityKey", "detailsUrl", "detailsResponse", "detailsDecrypted", "details", "episode", "availableTracks", "resolutions", "track", "languageName", "videoUrl", "postBody", "isCasting", "videoLoaded", "hasIndividualVideo", "languageId", "resolution", "data", "subtitleCallback", "callback", "parts", "movieId", "episodeId", "securityKey", "detailsUrl", "detailsResponse", "detailsDecrypted", "details", "episode", "availableTracks", "resolutions", "track", "languageName", "videoUrl", "postBody", "videoResponse", "encryptedData", "decryptedJson", "videoData", "qualityName", "isCasting", "videoLoaded", "hasIndividualVideo", "languageId", "resolution", "data", "subtitleCallback", "callback", "parts", "movieId", "episodeId", "securityKey", "detailsUrl", "detailsResponse", "detailsDecrypted", "details", "episode", "availableTracks", "resolutions", "track", "languageName", "videoUrl", "postBody", "videoResponse", "encryptedData", "decryptedJson", "videoData", "qualityName", "$this$forEach$iv", "element$iv", "subtitle", "isCasting", "videoLoaded", "hasIndividualVideo", "languageId", "resolution", "$i$f$forEach", "$i$a$-forEach-CastleTvProvider$loadLinks$6"}, nl = {649, 651, 700, 719, 744, 790, 811, 836}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$17", "L$18", "Z$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "Z$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$26", "L$27", "Z$0", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16", "L$18", "L$19", "Z$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "Z$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$27", "L$28", "Z$0", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
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
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CastleTvProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.CastleTvProvider$search$1 */
    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CastleTvProvider", f = "CastleTvProvider.kt", i = {0, 1, 1, 1}, l = {424, 427}, m = "search", n = {"query", "query", "securityKey", "searchUrl"}, nl = {425, 428}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CastleTvProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fJ\b\u0010\u0015\u001a\u00020\u0016H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/cncverse/CastleTvProvider$Companion;", "", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "OMG10", "", "lastBrowserOpenMs", "", "telegramPopupShown", "", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "csGuardWasEverActive", "isCsGuardActive", "isCsGuardBlocked", "showCsGuardToast", "", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nCastleTvProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CastleTvProvider.kt\ncom/cncverse/CastleTvProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1105:1\n1#2:1106\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Context getContext() {
            return CastleTvProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            CastleTvProvider.context = context;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0042  */
        public final boolean isCsGuardActive() {
            String name;
            Class<?> cls;
            String name2;
            try {
                Class<?> cls2 = Class.forName("android.app.ActivityThread");
                Object thread = cls2.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field field = cls2.getDeclaredField("mInstrumentation");
                field.setAccessible(true);
                Object obj = field.get(thread);
                if (obj == null || (cls = obj.getClass()) == null || (name2 = cls.getName()) == null) {
                    name = "";
                } else {
                    name = name2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(name, "toLowerCase(...)");
                    if (name == null) {
                        name = "";
                    }
                }
                return StringsKt.contains$default(name, "guard", false, 2, (Object) null) || StringsKt.contains$default(name, "csguard", false, 2, (Object) null);
            } catch (Throwable th) {
                return false;
            }
        }

        public final boolean isCsGuardBlocked() {
            if (isCsGuardActive()) {
                CastleTvProvider.csGuardWasEverActive = true;
            }
            return CastleTvProvider.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast() {
            final Context ctx = getContext();
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.CastleTvProvider$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CastleTvProvider.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $ctx) {
            Toast.makeText($ctx, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }
    }

    public CastleTvProvider() {
        ObjectMapper $this$mapper_u24lambda_u240 = ExtensionsKt.jacksonObjectMapper();
        $this$mapper_u24lambda_u240.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper = $this$mapper_u24lambda_u240;
        this.mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("1", "Home")});
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

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/cncverse/CastleTvProvider$CastleApiResponse;", "", "code", "", "msg", "", "data", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getData", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class CastleApiResponse {
        private final int code;

        @Nullable
        private final String data;

        @NotNull
        private final String msg;

        public static /* synthetic */ CastleApiResponse copy$default(CastleApiResponse castleApiResponse, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = castleApiResponse.code;
            }
            if ((i2 & 2) != 0) {
                str = castleApiResponse.msg;
            }
            if ((i2 & 4) != 0) {
                str2 = castleApiResponse.data;
            }
            return castleApiResponse.copy(i, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getData() {
            return this.data;
        }

        @NotNull
        public final CastleApiResponse copy(int code, @NotNull String msg, @Nullable String data) {
            return new CastleApiResponse(code, msg, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CastleApiResponse)) {
                return false;
            }
            CastleApiResponse castleApiResponse = (CastleApiResponse) other;
            return this.code == castleApiResponse.code && Intrinsics.areEqual(this.msg, castleApiResponse.msg) && Intrinsics.areEqual(this.data, castleApiResponse.data);
        }

        public int hashCode() {
            return (((this.code * 31) + this.msg.hashCode()) * 31) + (this.data == null ? 0 : this.data.hashCode());
        }

        @NotNull
        public String toString() {
            return "CastleApiResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public CastleApiResponse(int code, @NotNull String msg, @Nullable String data) {
            this.code = code;
            this.msg = msg;
            this.data = data;
        }

        public /* synthetic */ CastleApiResponse(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, (i2 & 4) != 0 ? null : str2);
        }

        public final int getCode() {
            return this.code;
        }

        @NotNull
        public final String getMsg() {
            return this.msg;
        }

        @Nullable
        public final String getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/cncverse/CastleTvProvider$SecurityKeyResponse;", "", "code", "", "msg", "", "data", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getData", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SecurityKeyResponse {
        private final int code;

        @NotNull
        private final String data;

        @NotNull
        private final String msg;

        public static /* synthetic */ SecurityKeyResponse copy$default(SecurityKeyResponse securityKeyResponse, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = securityKeyResponse.code;
            }
            if ((i2 & 2) != 0) {
                str = securityKeyResponse.msg;
            }
            if ((i2 & 4) != 0) {
                str2 = securityKeyResponse.data;
            }
            return securityKeyResponse.copy(i, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getData() {
            return this.data;
        }

        @NotNull
        public final SecurityKeyResponse copy(int code, @NotNull String msg, @NotNull String data) {
            return new SecurityKeyResponse(code, msg, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SecurityKeyResponse)) {
                return false;
            }
            SecurityKeyResponse securityKeyResponse = (SecurityKeyResponse) other;
            return this.code == securityKeyResponse.code && Intrinsics.areEqual(this.msg, securityKeyResponse.msg) && Intrinsics.areEqual(this.data, securityKeyResponse.data);
        }

        public int hashCode() {
            return (((this.code * 31) + this.msg.hashCode()) * 31) + this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "SecurityKeyResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public SecurityKeyResponse(int code, @NotNull String msg, @NotNull String data) {
            this.code = code;
            this.msg = msg;
            this.data = data;
        }

        public final int getCode() {
            return this.code;
        }

        @NotNull
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        public final String getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/cncverse/CastleTvProvider$DecryptedResponse;", "", "code", "", "msg", "", "data", "Lcom/cncverse/CastleTvProvider$HomePageData;", "<init>", "(ILjava/lang/String;Lcom/cncverse/CastleTvProvider$HomePageData;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/cncverse/CastleTvProvider$HomePageData;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class DecryptedResponse {
        private final int code;

        @NotNull
        private final HomePageData data;

        @NotNull
        private final String msg;

        public static /* synthetic */ DecryptedResponse copy$default(DecryptedResponse decryptedResponse, int i, String str, HomePageData homePageData, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = decryptedResponse.code;
            }
            if ((i2 & 2) != 0) {
                str = decryptedResponse.msg;
            }
            if ((i2 & 4) != 0) {
                homePageData = decryptedResponse.data;
            }
            return decryptedResponse.copy(i, str, homePageData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final HomePageData getData() {
            return this.data;
        }

        @NotNull
        public final DecryptedResponse copy(int code, @NotNull String msg, @NotNull HomePageData data) {
            return new DecryptedResponse(code, msg, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DecryptedResponse)) {
                return false;
            }
            DecryptedResponse decryptedResponse = (DecryptedResponse) other;
            return this.code == decryptedResponse.code && Intrinsics.areEqual(this.msg, decryptedResponse.msg) && Intrinsics.areEqual(this.data, decryptedResponse.data);
        }

        public int hashCode() {
            return (((this.code * 31) + this.msg.hashCode()) * 31) + this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "DecryptedResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public DecryptedResponse(int code, @NotNull String msg, @NotNull HomePageData data) {
            this.code = code;
            this.msg = msg;
            this.data = data;
        }

        public final int getCode() {
            return this.code;
        }

        @NotNull
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        public final HomePageData getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JP\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/cncverse/CastleTvProvider$HomePageData;", "", "page", "", "pages", "size", "total", "rows", "", "Lcom/cncverse/CastleTvProvider$HomePageRow;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getPage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPages", "getSize", "getTotal", "getRows", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/cncverse/CastleTvProvider$HomePageData;", "equals", "", "other", "hashCode", "toString", "", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class HomePageData {

        @Nullable
        private final Integer page;

        @Nullable
        private final Integer pages;

        @Nullable
        private final List<HomePageRow> rows;

        @Nullable
        private final Integer size;

        @Nullable
        private final Integer total;

        public HomePageData() {
            this(null, null, null, null, null, 31, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HomePageData copy$default(HomePageData homePageData, Integer num, Integer num2, Integer num3, Integer num4, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                num = homePageData.page;
            }
            if ((i & 2) != 0) {
                num2 = homePageData.pages;
            }
            if ((i & 4) != 0) {
                num3 = homePageData.size;
            }
            if ((i & 8) != 0) {
                num4 = homePageData.total;
            }
            if ((i & 16) != 0) {
                list = homePageData.rows;
            }
            List list2 = list;
            Integer num5 = num3;
            return homePageData.copy(num, num2, num5, num4, list2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getPage() {
            return this.page;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getPages() {
            return this.pages;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getSize() {
            return this.size;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getTotal() {
            return this.total;
        }

        @Nullable
        public final List<HomePageRow> component5() {
            return this.rows;
        }

        @NotNull
        public final HomePageData copy(@Nullable Integer page, @Nullable Integer pages, @Nullable Integer size, @Nullable Integer total, @Nullable List<HomePageRow> rows) {
            return new HomePageData(page, pages, size, total, rows);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HomePageData)) {
                return false;
            }
            HomePageData homePageData = (HomePageData) other;
            return Intrinsics.areEqual(this.page, homePageData.page) && Intrinsics.areEqual(this.pages, homePageData.pages) && Intrinsics.areEqual(this.size, homePageData.size) && Intrinsics.areEqual(this.total, homePageData.total) && Intrinsics.areEqual(this.rows, homePageData.rows);
        }

        public int hashCode() {
            return ((((((((this.page == null ? 0 : this.page.hashCode()) * 31) + (this.pages == null ? 0 : this.pages.hashCode())) * 31) + (this.size == null ? 0 : this.size.hashCode())) * 31) + (this.total == null ? 0 : this.total.hashCode())) * 31) + (this.rows != null ? this.rows.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "HomePageData(page=" + this.page + ", pages=" + this.pages + ", size=" + this.size + ", total=" + this.total + ", rows=" + this.rows + ')';
        }

        public HomePageData(@Nullable Integer page, @Nullable Integer pages, @Nullable Integer size, @Nullable Integer total, @Nullable List<HomePageRow> list) {
            this.page = page;
            this.pages = pages;
            this.size = size;
            this.total = total;
            this.rows = list;
        }

        public /* synthetic */ HomePageData(Integer num, Integer num2, Integer num3, Integer num4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : list);
        }

        @Nullable
        public final Integer getPage() {
            return this.page;
        }

        @Nullable
        public final Integer getPages() {
            return this.pages;
        }

        @Nullable
        public final Integer getSize() {
            return this.size;
        }

        @Nullable
        public final Integer getTotal() {
            return this.total;
        }

        @Nullable
        public final List<HomePageRow> getRows() {
            return this.rows;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0080\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010+J\u0014\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010/\u001a\u00020\bHÖ\u0081\u0004J\n\u00100\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00061"}, d2 = {"Lcom/cncverse/CastleTvProvider$HomePageRow;", "", "id", "", "name", "", "coverImage", "coverImageHeight", "", "coverImageWidth", "type", "redirectType", "briefIntroduction", "contents", "", "Lcom/cncverse/CastleTvProvider$ContentItem;", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "getCoverImage", "getCoverImageHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCoverImageWidth", "getType", "getRedirectType", "getBriefIntroduction", "getContents", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/cncverse/CastleTvProvider$HomePageRow;", "equals", "", "other", "hashCode", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class HomePageRow {

        @Nullable
        private final String briefIntroduction;

        @Nullable
        private final List<ContentItem> contents;

        @Nullable
        private final String coverImage;

        @Nullable
        private final Integer coverImageHeight;

        @Nullable
        private final Integer coverImageWidth;

        @Nullable
        private final Long id;

        @Nullable
        private final String name;

        @Nullable
        private final Integer redirectType;

        @Nullable
        private final Integer type;

        public HomePageRow() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HomePageRow copy$default(HomePageRow homePageRow, Long l, String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                l = homePageRow.id;
            }
            if ((i & 2) != 0) {
                str = homePageRow.name;
            }
            if ((i & 4) != 0) {
                str2 = homePageRow.coverImage;
            }
            if ((i & 8) != 0) {
                num = homePageRow.coverImageHeight;
            }
            if ((i & 16) != 0) {
                num2 = homePageRow.coverImageWidth;
            }
            if ((i & 32) != 0) {
                num3 = homePageRow.type;
            }
            if ((i & 64) != 0) {
                num4 = homePageRow.redirectType;
            }
            if ((i & 128) != 0) {
                str3 = homePageRow.briefIntroduction;
            }
            if ((i & 256) != 0) {
                list = homePageRow.contents;
            }
            String str4 = str3;
            List list2 = list;
            Integer num5 = num3;
            Integer num6 = num4;
            Integer num7 = num2;
            String str5 = str2;
            return homePageRow.copy(l, str, str5, num, num7, num5, num6, str4, list2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getCoverImageHeight() {
            return this.coverImageHeight;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getCoverImageWidth() {
            return this.coverImageWidth;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getRedirectType() {
            return this.redirectType;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getBriefIntroduction() {
            return this.briefIntroduction;
        }

        @Nullable
        public final List<ContentItem> component9() {
            return this.contents;
        }

        @NotNull
        public final HomePageRow copy(@Nullable Long id, @Nullable String name, @Nullable String coverImage, @Nullable Integer coverImageHeight, @Nullable Integer coverImageWidth, @Nullable Integer type, @Nullable Integer redirectType, @Nullable String briefIntroduction, @Nullable List<ContentItem> contents) {
            return new HomePageRow(id, name, coverImage, coverImageHeight, coverImageWidth, type, redirectType, briefIntroduction, contents);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HomePageRow)) {
                return false;
            }
            HomePageRow homePageRow = (HomePageRow) other;
            return Intrinsics.areEqual(this.id, homePageRow.id) && Intrinsics.areEqual(this.name, homePageRow.name) && Intrinsics.areEqual(this.coverImage, homePageRow.coverImage) && Intrinsics.areEqual(this.coverImageHeight, homePageRow.coverImageHeight) && Intrinsics.areEqual(this.coverImageWidth, homePageRow.coverImageWidth) && Intrinsics.areEqual(this.type, homePageRow.type) && Intrinsics.areEqual(this.redirectType, homePageRow.redirectType) && Intrinsics.areEqual(this.briefIntroduction, homePageRow.briefIntroduction) && Intrinsics.areEqual(this.contents, homePageRow.contents);
        }

        public int hashCode() {
            return ((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.coverImage == null ? 0 : this.coverImage.hashCode())) * 31) + (this.coverImageHeight == null ? 0 : this.coverImageHeight.hashCode())) * 31) + (this.coverImageWidth == null ? 0 : this.coverImageWidth.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.redirectType == null ? 0 : this.redirectType.hashCode())) * 31) + (this.briefIntroduction == null ? 0 : this.briefIntroduction.hashCode())) * 31) + (this.contents != null ? this.contents.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "HomePageRow(id=" + this.id + ", name=" + this.name + ", coverImage=" + this.coverImage + ", coverImageHeight=" + this.coverImageHeight + ", coverImageWidth=" + this.coverImageWidth + ", type=" + this.type + ", redirectType=" + this.redirectType + ", briefIntroduction=" + this.briefIntroduction + ", contents=" + this.contents + ')';
        }

        public HomePageRow(@Nullable Long id, @Nullable String name, @Nullable String coverImage, @Nullable Integer coverImageHeight, @Nullable Integer coverImageWidth, @Nullable Integer type, @Nullable Integer redirectType, @Nullable String briefIntroduction, @Nullable List<ContentItem> list) {
            this.id = id;
            this.name = name;
            this.coverImage = coverImage;
            this.coverImageHeight = coverImageHeight;
            this.coverImageWidth = coverImageWidth;
            this.type = type;
            this.redirectType = redirectType;
            this.briefIntroduction = briefIntroduction;
            this.contents = list;
        }

        public /* synthetic */ HomePageRow(Long l, String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : num3, (i & 64) != 0 ? null : num4, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : list);
        }

        @Nullable
        public final Long getId() {
            return this.id;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        public final Integer getCoverImageHeight() {
            return this.coverImageHeight;
        }

        @Nullable
        public final Integer getCoverImageWidth() {
            return this.coverImageWidth;
        }

        @Nullable
        public final Integer getType() {
            return this.type;
        }

        @Nullable
        public final Integer getRedirectType() {
            return this.redirectType;
        }

        @Nullable
        public final String getBriefIntroduction() {
            return this.briefIntroduction;
        }

        @Nullable
        public final List<ContentItem> getContents() {
            return this.contents;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\bE\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010A\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010B\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010C\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010E\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010F\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010/J\u0011\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012HÆ\u0003J\u0011\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010J\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010M\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010N\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010O\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010P\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u008a\u0002\u0010Q\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0002\u0010RJ\u0014\u0010S\u001a\u00020\u00102\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010U\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010V\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010#\u001a\u0004\b'\u0010\"R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0015\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010&\u001a\u0004\b+\u0010%R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010#\u001a\u0004\b,\u0010\"R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010#\u001a\u0004\b-\u0010\"R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010#\u001a\u0004\b4\u0010\"R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010&\u001a\u0004\b5\u0010%R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001fR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010&\u001a\u0004\b7\u0010%R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010#\u001a\u0004\b8\u0010\"R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010#\u001a\u0004\b9\u0010\"R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010&\u001a\u0004\b:\u0010%R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<¨\u0006W"}, d2 = {"Lcom/cncverse/CastleTvProvider$ContentItem;", "", "title", "", "coverImage", "redirectType", "", "redirectId", "", "movieType", "score", "", "publishTime", "heat", "order", "unlockPlayback", "", "languages", "", "excludeChannelIds", "memberLevel", "standardExpireTime", "indiaResolutionLabel", "standardNewExpireTime", "countdownHourNew", "countdownHour", "serverTime", "woolUser", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Object;)V", "getTitle", "()Ljava/lang/String;", "getCoverImage", "getRedirectType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRedirectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMovieType", "getScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getPublishTime", "getHeat", "getOrder", "getUnlockPlayback", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLanguages", "()Ljava/util/List;", "getExcludeChannelIds", "getMemberLevel", "getStandardExpireTime", "getIndiaResolutionLabel", "getStandardNewExpireTime", "getCountdownHourNew", "getCountdownHour", "getServerTime", "getWoolUser", "()Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Object;)Lcom/cncverse/CastleTvProvider$ContentItem;", "equals", "other", "hashCode", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ContentItem {

        @Nullable
        private final Integer countdownHour;

        @Nullable
        private final Integer countdownHourNew;

        @Nullable
        private final String coverImage;

        @Nullable
        private final List<String> excludeChannelIds;

        @Nullable
        private final Integer heat;

        @Nullable
        private final String indiaResolutionLabel;

        @Nullable
        private final List<String> languages;

        @Nullable
        private final Integer memberLevel;

        @Nullable
        private final Integer movieType;

        @Nullable
        private final Integer order;

        @Nullable
        private final Long publishTime;

        @Nullable
        private final Long redirectId;

        @Nullable
        private final Integer redirectType;

        @Nullable
        private final Double score;

        @Nullable
        private final Long serverTime;

        @Nullable
        private final Long standardExpireTime;

        @Nullable
        private final Long standardNewExpireTime;

        @Nullable
        private final String title;

        @Nullable
        private final Boolean unlockPlayback;

        @Nullable
        private final Object woolUser;

        public ContentItem() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ContentItem copy$default(ContentItem contentItem, String str, String str2, Integer num, Long l, Integer num2, Double d, Long l2, Integer num3, Integer num4, Boolean bool, List list, List list2, Integer num5, Long l3, String str3, Long l4, Integer num6, Integer num7, Long l5, Object obj, int i, Object obj2) {
            Object obj3;
            Long l6;
            String str4 = (i & 1) != 0 ? contentItem.title : str;
            String str5 = (i & 2) != 0 ? contentItem.coverImage : str2;
            Integer num8 = (i & 4) != 0 ? contentItem.redirectType : num;
            Long l7 = (i & 8) != 0 ? contentItem.redirectId : l;
            Integer num9 = (i & 16) != 0 ? contentItem.movieType : num2;
            Double d2 = (i & 32) != 0 ? contentItem.score : d;
            Long l8 = (i & 64) != 0 ? contentItem.publishTime : l2;
            Integer num10 = (i & 128) != 0 ? contentItem.heat : num3;
            Integer num11 = (i & 256) != 0 ? contentItem.order : num4;
            Boolean bool2 = (i & 512) != 0 ? contentItem.unlockPlayback : bool;
            List list3 = (i & 1024) != 0 ? contentItem.languages : list;
            List list4 = (i & 2048) != 0 ? contentItem.excludeChannelIds : list2;
            Integer num12 = (i & 4096) != 0 ? contentItem.memberLevel : num5;
            Long l9 = (i & 8192) != 0 ? contentItem.standardExpireTime : l3;
            String str6 = str4;
            String str7 = (i & 16384) != 0 ? contentItem.indiaResolutionLabel : str3;
            Long l10 = (i & 32768) != 0 ? contentItem.standardNewExpireTime : l4;
            Integer num13 = (i & 65536) != 0 ? contentItem.countdownHourNew : num6;
            Integer num14 = (i & 131072) != 0 ? contentItem.countdownHour : num7;
            Long l11 = (i & 262144) != 0 ? contentItem.serverTime : l5;
            if ((i & 524288) != 0) {
                l6 = l11;
                obj3 = contentItem.woolUser;
            } else {
                obj3 = obj;
                l6 = l11;
            }
            return contentItem.copy(str6, str5, num8, l7, num9, d2, l8, num10, num11, bool2, list3, list4, num12, l9, str7, l10, num13, num14, l6, obj3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Boolean getUnlockPlayback() {
            return this.unlockPlayback;
        }

        @Nullable
        public final List<String> component11() {
            return this.languages;
        }

        @Nullable
        public final List<String> component12() {
            return this.excludeChannelIds;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Integer getMemberLevel() {
            return this.memberLevel;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Long getStandardExpireTime() {
            return this.standardExpireTime;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getIndiaResolutionLabel() {
            return this.indiaResolutionLabel;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Long getStandardNewExpireTime() {
            return this.standardNewExpireTime;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final Integer getCountdownHourNew() {
            return this.countdownHourNew;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final Integer getCountdownHour() {
            return this.countdownHour;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final Long getServerTime() {
            return this.serverTime;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final Object getWoolUser() {
            return this.woolUser;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getRedirectType() {
            return this.redirectType;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getRedirectId() {
            return this.redirectId;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getMovieType() {
            return this.movieType;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Double getScore() {
            return this.score;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Long getPublishTime() {
            return this.publishTime;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getHeat() {
            return this.heat;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getOrder() {
            return this.order;
        }

        @NotNull
        public final ContentItem copy(@Nullable String title, @Nullable String coverImage, @Nullable Integer redirectType, @Nullable Long redirectId, @Nullable Integer movieType, @Nullable Double score, @Nullable Long publishTime, @Nullable Integer heat, @Nullable Integer order, @Nullable Boolean unlockPlayback, @Nullable List<String> languages, @Nullable List<String> excludeChannelIds, @Nullable Integer memberLevel, @Nullable Long standardExpireTime, @Nullable String indiaResolutionLabel, @Nullable Long standardNewExpireTime, @Nullable Integer countdownHourNew, @Nullable Integer countdownHour, @Nullable Long serverTime, @Nullable Object woolUser) {
            return new ContentItem(title, coverImage, redirectType, redirectId, movieType, score, publishTime, heat, order, unlockPlayback, languages, excludeChannelIds, memberLevel, standardExpireTime, indiaResolutionLabel, standardNewExpireTime, countdownHourNew, countdownHour, serverTime, woolUser);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ContentItem)) {
                return false;
            }
            ContentItem contentItem = (ContentItem) other;
            return Intrinsics.areEqual(this.title, contentItem.title) && Intrinsics.areEqual(this.coverImage, contentItem.coverImage) && Intrinsics.areEqual(this.redirectType, contentItem.redirectType) && Intrinsics.areEqual(this.redirectId, contentItem.redirectId) && Intrinsics.areEqual(this.movieType, contentItem.movieType) && Intrinsics.areEqual(this.score, contentItem.score) && Intrinsics.areEqual(this.publishTime, contentItem.publishTime) && Intrinsics.areEqual(this.heat, contentItem.heat) && Intrinsics.areEqual(this.order, contentItem.order) && Intrinsics.areEqual(this.unlockPlayback, contentItem.unlockPlayback) && Intrinsics.areEqual(this.languages, contentItem.languages) && Intrinsics.areEqual(this.excludeChannelIds, contentItem.excludeChannelIds) && Intrinsics.areEqual(this.memberLevel, contentItem.memberLevel) && Intrinsics.areEqual(this.standardExpireTime, contentItem.standardExpireTime) && Intrinsics.areEqual(this.indiaResolutionLabel, contentItem.indiaResolutionLabel) && Intrinsics.areEqual(this.standardNewExpireTime, contentItem.standardNewExpireTime) && Intrinsics.areEqual(this.countdownHourNew, contentItem.countdownHourNew) && Intrinsics.areEqual(this.countdownHour, contentItem.countdownHour) && Intrinsics.areEqual(this.serverTime, contentItem.serverTime) && Intrinsics.areEqual(this.woolUser, contentItem.woolUser);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.coverImage == null ? 0 : this.coverImage.hashCode())) * 31) + (this.redirectType == null ? 0 : this.redirectType.hashCode())) * 31) + (this.redirectId == null ? 0 : this.redirectId.hashCode())) * 31) + (this.movieType == null ? 0 : this.movieType.hashCode())) * 31) + (this.score == null ? 0 : this.score.hashCode())) * 31) + (this.publishTime == null ? 0 : this.publishTime.hashCode())) * 31) + (this.heat == null ? 0 : this.heat.hashCode())) * 31) + (this.order == null ? 0 : this.order.hashCode())) * 31) + (this.unlockPlayback == null ? 0 : this.unlockPlayback.hashCode())) * 31) + (this.languages == null ? 0 : this.languages.hashCode())) * 31) + (this.excludeChannelIds == null ? 0 : this.excludeChannelIds.hashCode())) * 31) + (this.memberLevel == null ? 0 : this.memberLevel.hashCode())) * 31) + (this.standardExpireTime == null ? 0 : this.standardExpireTime.hashCode())) * 31) + (this.indiaResolutionLabel == null ? 0 : this.indiaResolutionLabel.hashCode())) * 31) + (this.standardNewExpireTime == null ? 0 : this.standardNewExpireTime.hashCode())) * 31) + (this.countdownHourNew == null ? 0 : this.countdownHourNew.hashCode())) * 31) + (this.countdownHour == null ? 0 : this.countdownHour.hashCode())) * 31) + (this.serverTime == null ? 0 : this.serverTime.hashCode())) * 31) + (this.woolUser != null ? this.woolUser.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ContentItem(title=").append(this.title).append(", coverImage=").append(this.coverImage).append(", redirectType=").append(this.redirectType).append(", redirectId=").append(this.redirectId).append(", movieType=").append(this.movieType).append(", score=").append(this.score).append(", publishTime=").append(this.publishTime).append(", heat=").append(this.heat).append(", order=").append(this.order).append(", unlockPlayback=").append(this.unlockPlayback).append(", languages=").append(this.languages).append(", excludeChannelIds=");
            sb.append(this.excludeChannelIds).append(", memberLevel=").append(this.memberLevel).append(", standardExpireTime=").append(this.standardExpireTime).append(", indiaResolutionLabel=").append(this.indiaResolutionLabel).append(", standardNewExpireTime=").append(this.standardNewExpireTime).append(", countdownHourNew=").append(this.countdownHourNew).append(", countdownHour=").append(this.countdownHour).append(", serverTime=").append(this.serverTime).append(", woolUser=").append(this.woolUser).append(')');
            return sb.toString();
        }

        public ContentItem(@Nullable String title, @Nullable String coverImage, @Nullable Integer redirectType, @Nullable Long redirectId, @Nullable Integer movieType, @Nullable Double score, @Nullable Long publishTime, @Nullable Integer heat, @Nullable Integer order, @Nullable Boolean unlockPlayback, @Nullable List<String> list, @Nullable List<String> list2, @Nullable Integer memberLevel, @Nullable Long standardExpireTime, @Nullable String indiaResolutionLabel, @Nullable Long standardNewExpireTime, @Nullable Integer countdownHourNew, @Nullable Integer countdownHour, @Nullable Long serverTime, @Nullable Object woolUser) {
            this.title = title;
            this.coverImage = coverImage;
            this.redirectType = redirectType;
            this.redirectId = redirectId;
            this.movieType = movieType;
            this.score = score;
            this.publishTime = publishTime;
            this.heat = heat;
            this.order = order;
            this.unlockPlayback = unlockPlayback;
            this.languages = list;
            this.excludeChannelIds = list2;
            this.memberLevel = memberLevel;
            this.standardExpireTime = standardExpireTime;
            this.indiaResolutionLabel = indiaResolutionLabel;
            this.standardNewExpireTime = standardNewExpireTime;
            this.countdownHourNew = countdownHourNew;
            this.countdownHour = countdownHour;
            this.serverTime = serverTime;
            this.woolUser = woolUser;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ ContentItem(String str, String str2, Integer num, Long l, Integer num2, Double d, Long l2, Integer num3, Integer num4, Boolean bool, List list, List list2, Integer num5, Long l3, String str3, Long l4, Integer num6, Integer num7, Long l5, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
            String str4 = (i & 1) != 0 ? null : str;
            String str5 = (i & 2) != 0 ? null : str2;
            Integer num8 = (i & 4) != 0 ? null : num;
            Long l6 = (i & 8) != 0 ? null : l;
            Integer num9 = (i & 16) != 0 ? null : num2;
            Double d2 = (i & 32) != 0 ? null : d;
            Long l7 = (i & 64) != 0 ? null : l2;
            Integer num10 = (i & 128) != 0 ? null : num3;
            Integer num11 = (i & 256) != 0 ? null : num4;
            Boolean bool2 = (i & 512) != 0 ? null : bool;
            List list3 = (i & 1024) != 0 ? null : list;
            List list4 = (i & 2048) != 0 ? null : list2;
            Integer num12 = (i & 4096) != 0 ? null : num5;
            Long l8 = (i & 8192) != 0 ? null : l3;
            String str6 = (i & 16384) != 0 ? null : str3;
            this(str4, str5, num8, l6, num9, d2, l7, num10, num11, bool2, list3, list4, num12, l8, str6, (i & 32768) != 0 ? null : l4, (i & 65536) != 0 ? null : num6, (i & 131072) != 0 ? null : num7, (i & 262144) != 0 ? null : l5, (i & 524288) != 0 ? null : obj);
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        public final Integer getRedirectType() {
            return this.redirectType;
        }

        @Nullable
        public final Long getRedirectId() {
            return this.redirectId;
        }

        @Nullable
        public final Integer getMovieType() {
            return this.movieType;
        }

        @Nullable
        public final Double getScore() {
            return this.score;
        }

        @Nullable
        public final Long getPublishTime() {
            return this.publishTime;
        }

        @Nullable
        public final Integer getHeat() {
            return this.heat;
        }

        @Nullable
        public final Integer getOrder() {
            return this.order;
        }

        @Nullable
        public final Boolean getUnlockPlayback() {
            return this.unlockPlayback;
        }

        @Nullable
        public final List<String> getLanguages() {
            return this.languages;
        }

        @Nullable
        public final List<String> getExcludeChannelIds() {
            return this.excludeChannelIds;
        }

        @Nullable
        public final Integer getMemberLevel() {
            return this.memberLevel;
        }

        @Nullable
        public final Long getStandardExpireTime() {
            return this.standardExpireTime;
        }

        @Nullable
        public final String getIndiaResolutionLabel() {
            return this.indiaResolutionLabel;
        }

        @Nullable
        public final Long getStandardNewExpireTime() {
            return this.standardNewExpireTime;
        }

        @Nullable
        public final Integer getCountdownHourNew() {
            return this.countdownHourNew;
        }

        @Nullable
        public final Integer getCountdownHour() {
            return this.countdownHour;
        }

        @Nullable
        public final Long getServerTime() {
            return this.serverTime;
        }

        @Nullable
        public final Object getWoolUser() {
            return this.woolUser;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/cncverse/CastleTvProvider$MovieDetailsResponse;", "", "code", "", "msg", "", "data", "Lcom/cncverse/CastleTvProvider$MovieDetails;", "<init>", "(ILjava/lang/String;Lcom/cncverse/CastleTvProvider$MovieDetails;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/cncverse/CastleTvProvider$MovieDetails;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class MovieDetailsResponse {
        private final int code;

        @NotNull
        private final MovieDetails data;

        @NotNull
        private final String msg;

        public static /* synthetic */ MovieDetailsResponse copy$default(MovieDetailsResponse movieDetailsResponse, int i, String str, MovieDetails movieDetails, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = movieDetailsResponse.code;
            }
            if ((i2 & 2) != 0) {
                str = movieDetailsResponse.msg;
            }
            if ((i2 & 4) != 0) {
                movieDetails = movieDetailsResponse.data;
            }
            return movieDetailsResponse.copy(i, str, movieDetails);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final MovieDetails getData() {
            return this.data;
        }

        @NotNull
        public final MovieDetailsResponse copy(int code, @NotNull String msg, @NotNull MovieDetails data) {
            return new MovieDetailsResponse(code, msg, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MovieDetailsResponse)) {
                return false;
            }
            MovieDetailsResponse movieDetailsResponse = (MovieDetailsResponse) other;
            return this.code == movieDetailsResponse.code && Intrinsics.areEqual(this.msg, movieDetailsResponse.msg) && Intrinsics.areEqual(this.data, movieDetailsResponse.data);
        }

        public int hashCode() {
            return (((this.code * 31) + this.msg.hashCode()) * 31) + this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "MovieDetailsResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public MovieDetailsResponse(int code, @NotNull String msg, @NotNull MovieDetails data) {
            this.code = code;
            this.msg = msg;
            this.data = data;
        }

        public final int getCode() {
            return this.code;
        }

        @NotNull
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        public final MovieDetails getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b_\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0011\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u0011\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b1\u00102J\u0010\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00109J\u0010\u0010e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010<J\u000b\u0010f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010i\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010BJ\u000b\u0010j\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010k\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010<J\u0010\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010<J\u0010\u0010o\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010BJ\u000b\u0010p\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00104J\u0011\u0010r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\u0011\u0010s\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\u0010\u0010t\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010BJ\u000b\u0010u\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010v\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0011HÆ\u0003J\u0011\u0010w\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0011HÆ\u0003J\u0011\u0010x\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0011HÆ\u0003J\u0010\u0010y\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010<J\u0010\u0010z\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010<J\u0010\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010|\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010<J\u0010\u0010}\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010<J\u0011\u0010~\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0011HÆ\u0003J\u0011\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\u0012\u0010\u0080\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011HÆ\u0003J\u0012\u0010\u0081\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011HÆ\u0003J\u0011\u0010\u0082\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010<J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0012\u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u0011HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u008e\u0004\u0010\u0087\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00112\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00112\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00112\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00112\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u00112\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0003\u0010\u0088\u0001J\u0016\u0010\u0089\u0001\u001a\u00020\u000e2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\u000b\u0010\u008b\u0001\u001a\u00020\tHÖ\u0081\u0004J\u000b\u0010\u008c\u0001\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010=\u001a\u0004\b;\u0010<R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u00107R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u00107R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u00107R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010C\u001a\u0004\bA\u0010BR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bD\u00107R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010=\u001a\u0004\bG\u0010<R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00105\u001a\u0004\bH\u00104R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010=\u001a\u0004\bI\u0010<R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010C\u001a\u0004\bJ\u0010BR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u00107R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00105\u001a\u0004\bL\u00104R\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\bM\u0010FR\u0019\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\bN\u0010FR\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010C\u001a\u0004\b\u001a\u0010BR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bO\u00107R\u0019\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\bP\u0010FR\u0019\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010FR\u0019\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\bR\u0010FR\u0015\u0010!\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010=\u001a\u0004\bS\u0010<R\u0015\u0010\"\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010=\u001a\u0004\bT\u0010<R\u0015\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00105\u001a\u0004\bU\u00104R\u0015\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010=\u001a\u0004\bV\u0010<R\u0015\u0010%\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010=\u001a\u0004\bW\u0010<R\u0019\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\bX\u0010FR\u0019\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\bY\u0010FR\u0019\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010FR\u0019\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b[\u0010FR\u0015\u0010+\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010=\u001a\u0004\b\\\u0010<R\u0013\u0010,\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b]\u00107R\u0019\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b^\u0010FR\u0013\u0010/\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`R\u0013\u00100\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\ba\u0010`¨\u0006\u008d\u0001"}, d2 = {"Lcom/cncverse/CastleTvProvider$MovieDetails;", "", "id", "", "title", "", "score", "", "movieType", "", "movieTypeName", "coverHorizontalImage", "coverVerticalImage", "unlockPlayback", "", "seasonDescription", "languages", "", "lastEpisodeCount", "serverTime", "totalNumber", "woolUser", "briefIntroduction", "publishTime", "tags", "countries", "isAuthorized", "originalTitle", "directors", "Lcom/cncverse/CastleTvProvider$Person;", "actors", "episodes", "Lcom/cncverse/CastleTvProvider$ApiEpisode;", "seasonNumber", "updateNumber", "watchCount", "commentTotal", "previewTime", "seasons", "Lcom/cncverse/CastleTvProvider$Season;", "audioTags", "countryIds", "tagIds", "resolution", "indiaResolutionLabel", "titbits", "Lcom/cncverse/CastleTvProvider$Titbit;", "honorTag", "downloadTag", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTitle", "()Ljava/lang/String;", "getScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMovieType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMovieTypeName", "getCoverHorizontalImage", "getCoverVerticalImage", "getUnlockPlayback", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSeasonDescription", "getLanguages", "()Ljava/util/List;", "getLastEpisodeCount", "getServerTime", "getTotalNumber", "getWoolUser", "getBriefIntroduction", "getPublishTime", "getTags", "getCountries", "getOriginalTitle", "getDirectors", "getActors", "getEpisodes", "getSeasonNumber", "getUpdateNumber", "getWatchCount", "getCommentTotal", "getPreviewTime", "getSeasons", "getAudioTags", "getCountryIds", "getTagIds", "getResolution", "getIndiaResolutionLabel", "getTitbits", "getHonorTag", "()Ljava/lang/Object;", "getDownloadTag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)Lcom/cncverse/CastleTvProvider$MovieDetails;", "equals", "other", "hashCode", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class MovieDetails {

        @Nullable
        private final List<Person> actors;

        @Nullable
        private final List<String> audioTags;

        @Nullable
        private final String briefIntroduction;

        @Nullable
        private final Integer commentTotal;

        @Nullable
        private final List<String> countries;

        @Nullable
        private final List<Long> countryIds;

        @Nullable
        private final String coverHorizontalImage;

        @Nullable
        private final String coverVerticalImage;

        @Nullable
        private final List<Person> directors;

        @Nullable
        private final Object downloadTag;

        @Nullable
        private final List<ApiEpisode> episodes;

        @Nullable
        private final Object honorTag;

        @Nullable
        private final Long id;

        @Nullable
        private final String indiaResolutionLabel;

        @Nullable
        private final Boolean isAuthorized;

        @Nullable
        private final List<String> languages;

        @Nullable
        private final Integer lastEpisodeCount;

        @Nullable
        private final Integer movieType;

        @Nullable
        private final String movieTypeName;

        @Nullable
        private final String originalTitle;

        @Nullable
        private final Integer previewTime;

        @Nullable
        private final Long publishTime;

        @Nullable
        private final Integer resolution;

        @Nullable
        private final Double score;

        @Nullable
        private final String seasonDescription;

        @Nullable
        private final Integer seasonNumber;

        @Nullable
        private final List<Season> seasons;

        @Nullable
        private final Long serverTime;

        @Nullable
        private final List<Long> tagIds;

        @Nullable
        private final List<String> tags;

        @Nullable
        private final List<Titbit> titbits;

        @Nullable
        private final String title;

        @Nullable
        private final Integer totalNumber;

        @Nullable
        private final Boolean unlockPlayback;

        @Nullable
        private final Integer updateNumber;

        @Nullable
        private final Long watchCount;

        @Nullable
        private final Boolean woolUser;

        public MovieDetails() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MovieDetails copy$default(MovieDetails movieDetails, Long l, String str, Double d, Integer num, String str2, String str3, String str4, Boolean bool, String str5, List list, Integer num2, Long l2, Integer num3, Boolean bool2, String str6, Long l3, List list2, List list3, Boolean bool3, String str7, List list4, List list5, List list6, Integer num4, Integer num5, Long l4, Integer num6, Integer num7, List list7, List list8, List list9, List list10, Integer num8, String str8, List list11, Object obj, Object obj2, int i, int i2, Object obj3) {
            Object obj4;
            Object obj5;
            Long l5 = (i & 1) != 0 ? movieDetails.id : l;
            String str9 = (i & 2) != 0 ? movieDetails.title : str;
            Double d2 = (i & 4) != 0 ? movieDetails.score : d;
            Integer num9 = (i & 8) != 0 ? movieDetails.movieType : num;
            String str10 = (i & 16) != 0 ? movieDetails.movieTypeName : str2;
            String str11 = (i & 32) != 0 ? movieDetails.coverHorizontalImage : str3;
            String str12 = (i & 64) != 0 ? movieDetails.coverVerticalImage : str4;
            Boolean bool4 = (i & 128) != 0 ? movieDetails.unlockPlayback : bool;
            String str13 = (i & 256) != 0 ? movieDetails.seasonDescription : str5;
            List list12 = (i & 512) != 0 ? movieDetails.languages : list;
            Integer num10 = (i & 1024) != 0 ? movieDetails.lastEpisodeCount : num2;
            Long l6 = (i & 2048) != 0 ? movieDetails.serverTime : l2;
            Integer num11 = (i & 4096) != 0 ? movieDetails.totalNumber : num3;
            Boolean bool5 = (i & 8192) != 0 ? movieDetails.woolUser : bool2;
            Long l7 = l5;
            String str14 = (i & 16384) != 0 ? movieDetails.briefIntroduction : str6;
            Long l8 = (i & 32768) != 0 ? movieDetails.publishTime : l3;
            List list13 = (i & 65536) != 0 ? movieDetails.tags : list2;
            List list14 = (i & 131072) != 0 ? movieDetails.countries : list3;
            Boolean bool6 = (i & 262144) != 0 ? movieDetails.isAuthorized : bool3;
            String str15 = (i & 524288) != 0 ? movieDetails.originalTitle : str7;
            List list15 = (i & 1048576) != 0 ? movieDetails.directors : list4;
            List list16 = (i & 2097152) != 0 ? movieDetails.actors : list5;
            List list17 = (i & 4194304) != 0 ? movieDetails.episodes : list6;
            Integer num12 = (i & 8388608) != 0 ? movieDetails.seasonNumber : num4;
            Integer num13 = (i & 16777216) != 0 ? movieDetails.updateNumber : num5;
            Long l9 = (i & 33554432) != 0 ? movieDetails.watchCount : l4;
            Integer num14 = (i & 67108864) != 0 ? movieDetails.commentTotal : num6;
            Integer num15 = (i & 134217728) != 0 ? movieDetails.previewTime : num7;
            List list18 = (i & 268435456) != 0 ? movieDetails.seasons : list7;
            List list19 = (i & 536870912) != 0 ? movieDetails.audioTags : list8;
            List list20 = (i & 1073741824) != 0 ? movieDetails.countryIds : list9;
            List list21 = (i & Integer.MIN_VALUE) != 0 ? movieDetails.tagIds : list10;
            Integer num16 = (i2 & 1) != 0 ? movieDetails.resolution : num8;
            String str16 = (i2 & 2) != 0 ? movieDetails.indiaResolutionLabel : str8;
            List list22 = (i2 & 4) != 0 ? movieDetails.titbits : list11;
            Object obj6 = (i2 & 8) != 0 ? movieDetails.honorTag : obj;
            if ((i2 & 16) != 0) {
                obj5 = obj6;
                obj4 = movieDetails.downloadTag;
            } else {
                obj4 = obj2;
                obj5 = obj6;
            }
            return movieDetails.copy(l7, str9, d2, num9, str10, str11, str12, bool4, str13, list12, num10, l6, num11, bool5, str14, l8, list13, list14, bool6, str15, list15, list16, list17, num12, num13, l9, num14, num15, list18, list19, list20, list21, num16, str16, list22, obj5, obj4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getId() {
            return this.id;
        }

        @Nullable
        public final List<String> component10() {
            return this.languages;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Integer getLastEpisodeCount() {
            return this.lastEpisodeCount;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Long getServerTime() {
            return this.serverTime;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Integer getTotalNumber() {
            return this.totalNumber;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Boolean getWoolUser() {
            return this.woolUser;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getBriefIntroduction() {
            return this.briefIntroduction;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Long getPublishTime() {
            return this.publishTime;
        }

        @Nullable
        public final List<String> component17() {
            return this.tags;
        }

        @Nullable
        public final List<String> component18() {
            return this.countries;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final Boolean getIsAuthorized() {
            return this.isAuthorized;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final String getOriginalTitle() {
            return this.originalTitle;
        }

        @Nullable
        public final List<Person> component21() {
            return this.directors;
        }

        @Nullable
        public final List<Person> component22() {
            return this.actors;
        }

        @Nullable
        public final List<ApiEpisode> component23() {
            return this.episodes;
        }

        @Nullable
        /* JADX INFO: renamed from: component24, reason: from getter */
        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        @Nullable
        /* JADX INFO: renamed from: component25, reason: from getter */
        public final Integer getUpdateNumber() {
            return this.updateNumber;
        }

        @Nullable
        /* JADX INFO: renamed from: component26, reason: from getter */
        public final Long getWatchCount() {
            return this.watchCount;
        }

        @Nullable
        /* JADX INFO: renamed from: component27, reason: from getter */
        public final Integer getCommentTotal() {
            return this.commentTotal;
        }

        @Nullable
        /* JADX INFO: renamed from: component28, reason: from getter */
        public final Integer getPreviewTime() {
            return this.previewTime;
        }

        @Nullable
        public final List<Season> component29() {
            return this.seasons;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Double getScore() {
            return this.score;
        }

        @Nullable
        public final List<String> component30() {
            return this.audioTags;
        }

        @Nullable
        public final List<Long> component31() {
            return this.countryIds;
        }

        @Nullable
        public final List<Long> component32() {
            return this.tagIds;
        }

        @Nullable
        /* JADX INFO: renamed from: component33, reason: from getter */
        public final Integer getResolution() {
            return this.resolution;
        }

        @Nullable
        /* JADX INFO: renamed from: component34, reason: from getter */
        public final String getIndiaResolutionLabel() {
            return this.indiaResolutionLabel;
        }

        @Nullable
        public final List<Titbit> component35() {
            return this.titbits;
        }

        @Nullable
        /* JADX INFO: renamed from: component36, reason: from getter */
        public final Object getHonorTag() {
            return this.honorTag;
        }

        @Nullable
        /* JADX INFO: renamed from: component37, reason: from getter */
        public final Object getDownloadTag() {
            return this.downloadTag;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getMovieType() {
            return this.movieType;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getMovieTypeName() {
            return this.movieTypeName;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getCoverHorizontalImage() {
            return this.coverHorizontalImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getCoverVerticalImage() {
            return this.coverVerticalImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getUnlockPlayback() {
            return this.unlockPlayback;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getSeasonDescription() {
            return this.seasonDescription;
        }

        @NotNull
        public final MovieDetails copy(@Nullable Long id, @Nullable String title, @Nullable Double score, @Nullable Integer movieType, @Nullable String movieTypeName, @Nullable String coverHorizontalImage, @Nullable String coverVerticalImage, @Nullable Boolean unlockPlayback, @Nullable String seasonDescription, @Nullable List<String> languages, @Nullable Integer lastEpisodeCount, @Nullable Long serverTime, @Nullable Integer totalNumber, @Nullable Boolean woolUser, @Nullable String briefIntroduction, @Nullable Long publishTime, @Nullable List<String> tags, @Nullable List<String> countries, @Nullable Boolean isAuthorized, @Nullable String originalTitle, @Nullable List<Person> directors, @Nullable List<Person> actors, @Nullable List<ApiEpisode> episodes, @Nullable Integer seasonNumber, @Nullable Integer updateNumber, @Nullable Long watchCount, @Nullable Integer commentTotal, @Nullable Integer previewTime, @Nullable List<Season> seasons, @Nullable List<String> audioTags, @Nullable List<Long> countryIds, @Nullable List<Long> tagIds, @Nullable Integer resolution, @Nullable String indiaResolutionLabel, @Nullable List<Titbit> titbits, @Nullable Object honorTag, @Nullable Object downloadTag) {
            return new MovieDetails(id, title, score, movieType, movieTypeName, coverHorizontalImage, coverVerticalImage, unlockPlayback, seasonDescription, languages, lastEpisodeCount, serverTime, totalNumber, woolUser, briefIntroduction, publishTime, tags, countries, isAuthorized, originalTitle, directors, actors, episodes, seasonNumber, updateNumber, watchCount, commentTotal, previewTime, seasons, audioTags, countryIds, tagIds, resolution, indiaResolutionLabel, titbits, honorTag, downloadTag);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MovieDetails)) {
                return false;
            }
            MovieDetails movieDetails = (MovieDetails) other;
            return Intrinsics.areEqual(this.id, movieDetails.id) && Intrinsics.areEqual(this.title, movieDetails.title) && Intrinsics.areEqual(this.score, movieDetails.score) && Intrinsics.areEqual(this.movieType, movieDetails.movieType) && Intrinsics.areEqual(this.movieTypeName, movieDetails.movieTypeName) && Intrinsics.areEqual(this.coverHorizontalImage, movieDetails.coverHorizontalImage) && Intrinsics.areEqual(this.coverVerticalImage, movieDetails.coverVerticalImage) && Intrinsics.areEqual(this.unlockPlayback, movieDetails.unlockPlayback) && Intrinsics.areEqual(this.seasonDescription, movieDetails.seasonDescription) && Intrinsics.areEqual(this.languages, movieDetails.languages) && Intrinsics.areEqual(this.lastEpisodeCount, movieDetails.lastEpisodeCount) && Intrinsics.areEqual(this.serverTime, movieDetails.serverTime) && Intrinsics.areEqual(this.totalNumber, movieDetails.totalNumber) && Intrinsics.areEqual(this.woolUser, movieDetails.woolUser) && Intrinsics.areEqual(this.briefIntroduction, movieDetails.briefIntroduction) && Intrinsics.areEqual(this.publishTime, movieDetails.publishTime) && Intrinsics.areEqual(this.tags, movieDetails.tags) && Intrinsics.areEqual(this.countries, movieDetails.countries) && Intrinsics.areEqual(this.isAuthorized, movieDetails.isAuthorized) && Intrinsics.areEqual(this.originalTitle, movieDetails.originalTitle) && Intrinsics.areEqual(this.directors, movieDetails.directors) && Intrinsics.areEqual(this.actors, movieDetails.actors) && Intrinsics.areEqual(this.episodes, movieDetails.episodes) && Intrinsics.areEqual(this.seasonNumber, movieDetails.seasonNumber) && Intrinsics.areEqual(this.updateNumber, movieDetails.updateNumber) && Intrinsics.areEqual(this.watchCount, movieDetails.watchCount) && Intrinsics.areEqual(this.commentTotal, movieDetails.commentTotal) && Intrinsics.areEqual(this.previewTime, movieDetails.previewTime) && Intrinsics.areEqual(this.seasons, movieDetails.seasons) && Intrinsics.areEqual(this.audioTags, movieDetails.audioTags) && Intrinsics.areEqual(this.countryIds, movieDetails.countryIds) && Intrinsics.areEqual(this.tagIds, movieDetails.tagIds) && Intrinsics.areEqual(this.resolution, movieDetails.resolution) && Intrinsics.areEqual(this.indiaResolutionLabel, movieDetails.indiaResolutionLabel) && Intrinsics.areEqual(this.titbits, movieDetails.titbits) && Intrinsics.areEqual(this.honorTag, movieDetails.honorTag) && Intrinsics.areEqual(this.downloadTag, movieDetails.downloadTag);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.score == null ? 0 : this.score.hashCode())) * 31) + (this.movieType == null ? 0 : this.movieType.hashCode())) * 31) + (this.movieTypeName == null ? 0 : this.movieTypeName.hashCode())) * 31) + (this.coverHorizontalImage == null ? 0 : this.coverHorizontalImage.hashCode())) * 31) + (this.coverVerticalImage == null ? 0 : this.coverVerticalImage.hashCode())) * 31) + (this.unlockPlayback == null ? 0 : this.unlockPlayback.hashCode())) * 31) + (this.seasonDescription == null ? 0 : this.seasonDescription.hashCode())) * 31) + (this.languages == null ? 0 : this.languages.hashCode())) * 31) + (this.lastEpisodeCount == null ? 0 : this.lastEpisodeCount.hashCode())) * 31) + (this.serverTime == null ? 0 : this.serverTime.hashCode())) * 31) + (this.totalNumber == null ? 0 : this.totalNumber.hashCode())) * 31) + (this.woolUser == null ? 0 : this.woolUser.hashCode())) * 31) + (this.briefIntroduction == null ? 0 : this.briefIntroduction.hashCode())) * 31) + (this.publishTime == null ? 0 : this.publishTime.hashCode())) * 31) + (this.tags == null ? 0 : this.tags.hashCode())) * 31) + (this.countries == null ? 0 : this.countries.hashCode())) * 31) + (this.isAuthorized == null ? 0 : this.isAuthorized.hashCode())) * 31) + (this.originalTitle == null ? 0 : this.originalTitle.hashCode())) * 31) + (this.directors == null ? 0 : this.directors.hashCode())) * 31) + (this.actors == null ? 0 : this.actors.hashCode())) * 31) + (this.episodes == null ? 0 : this.episodes.hashCode())) * 31) + (this.seasonNumber == null ? 0 : this.seasonNumber.hashCode())) * 31) + (this.updateNumber == null ? 0 : this.updateNumber.hashCode())) * 31) + (this.watchCount == null ? 0 : this.watchCount.hashCode())) * 31) + (this.commentTotal == null ? 0 : this.commentTotal.hashCode())) * 31) + (this.previewTime == null ? 0 : this.previewTime.hashCode())) * 31) + (this.seasons == null ? 0 : this.seasons.hashCode())) * 31) + (this.audioTags == null ? 0 : this.audioTags.hashCode())) * 31) + (this.countryIds == null ? 0 : this.countryIds.hashCode())) * 31) + (this.tagIds == null ? 0 : this.tagIds.hashCode())) * 31) + (this.resolution == null ? 0 : this.resolution.hashCode())) * 31) + (this.indiaResolutionLabel == null ? 0 : this.indiaResolutionLabel.hashCode())) * 31) + (this.titbits == null ? 0 : this.titbits.hashCode())) * 31) + (this.honorTag == null ? 0 : this.honorTag.hashCode())) * 31) + (this.downloadTag != null ? this.downloadTag.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MovieDetails(id=").append(this.id).append(", title=").append(this.title).append(", score=").append(this.score).append(", movieType=").append(this.movieType).append(", movieTypeName=").append(this.movieTypeName).append(", coverHorizontalImage=").append(this.coverHorizontalImage).append(", coverVerticalImage=").append(this.coverVerticalImage).append(", unlockPlayback=").append(this.unlockPlayback).append(", seasonDescription=").append(this.seasonDescription).append(", languages=").append(this.languages).append(", lastEpisodeCount=").append(this.lastEpisodeCount).append(", serverTime=");
            sb.append(this.serverTime).append(", totalNumber=").append(this.totalNumber).append(", woolUser=").append(this.woolUser).append(", briefIntroduction=").append(this.briefIntroduction).append(", publishTime=").append(this.publishTime).append(", tags=").append(this.tags).append(", countries=").append(this.countries).append(", isAuthorized=").append(this.isAuthorized).append(", originalTitle=").append(this.originalTitle).append(", directors=").append(this.directors).append(", actors=").append(this.actors).append(", episodes=").append(this.episodes);
            sb.append(", seasonNumber=").append(this.seasonNumber).append(", updateNumber=").append(this.updateNumber).append(", watchCount=").append(this.watchCount).append(", commentTotal=").append(this.commentTotal).append(", previewTime=").append(this.previewTime).append(", seasons=").append(this.seasons).append(", audioTags=").append(this.audioTags).append(", countryIds=").append(this.countryIds).append(", tagIds=").append(this.tagIds).append(", resolution=").append(this.resolution).append(", indiaResolutionLabel=").append(this.indiaResolutionLabel).append(", titbits=");
            sb.append(this.titbits).append(", honorTag=").append(this.honorTag).append(", downloadTag=").append(this.downloadTag).append(')');
            return sb.toString();
        }

        public MovieDetails(@Nullable Long id, @Nullable String title, @Nullable Double score, @Nullable Integer movieType, @Nullable String movieTypeName, @Nullable String coverHorizontalImage, @Nullable String coverVerticalImage, @Nullable Boolean unlockPlayback, @Nullable String seasonDescription, @Nullable List<String> list, @Nullable Integer lastEpisodeCount, @Nullable Long serverTime, @Nullable Integer totalNumber, @Nullable Boolean woolUser, @Nullable String briefIntroduction, @Nullable Long publishTime, @Nullable List<String> list2, @Nullable List<String> list3, @Nullable Boolean isAuthorized, @Nullable String originalTitle, @Nullable List<Person> list4, @Nullable List<Person> list5, @Nullable List<ApiEpisode> list6, @Nullable Integer seasonNumber, @Nullable Integer updateNumber, @Nullable Long watchCount, @Nullable Integer commentTotal, @Nullable Integer previewTime, @Nullable List<Season> list7, @Nullable List<String> list8, @Nullable List<Long> list9, @Nullable List<Long> list10, @Nullable Integer resolution, @Nullable String indiaResolutionLabel, @Nullable List<Titbit> list11, @Nullable Object honorTag, @Nullable Object downloadTag) {
            this.id = id;
            this.title = title;
            this.score = score;
            this.movieType = movieType;
            this.movieTypeName = movieTypeName;
            this.coverHorizontalImage = coverHorizontalImage;
            this.coverVerticalImage = coverVerticalImage;
            this.unlockPlayback = unlockPlayback;
            this.seasonDescription = seasonDescription;
            this.languages = list;
            this.lastEpisodeCount = lastEpisodeCount;
            this.serverTime = serverTime;
            this.totalNumber = totalNumber;
            this.woolUser = woolUser;
            this.briefIntroduction = briefIntroduction;
            this.publishTime = publishTime;
            this.tags = list2;
            this.countries = list3;
            this.isAuthorized = isAuthorized;
            this.originalTitle = originalTitle;
            this.directors = list4;
            this.actors = list5;
            this.episodes = list6;
            this.seasonNumber = seasonNumber;
            this.updateNumber = updateNumber;
            this.watchCount = watchCount;
            this.commentTotal = commentTotal;
            this.previewTime = previewTime;
            this.seasons = list7;
            this.audioTags = list8;
            this.countryIds = list9;
            this.tagIds = list10;
            this.resolution = resolution;
            this.indiaResolutionLabel = indiaResolutionLabel;
            this.titbits = list11;
            this.honorTag = honorTag;
            this.downloadTag = downloadTag;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ MovieDetails(Long l, String str, Double d, Integer num, String str2, String str3, String str4, Boolean bool, String str5, List list, Integer num2, Long l2, Integer num3, Boolean bool2, String str6, Long l3, List list2, List list3, Boolean bool3, String str7, List list4, List list5, List list6, Integer num4, Integer num5, Long l4, Integer num6, Integer num7, List list7, List list8, List list9, List list10, Integer num8, String str8, List list11, Object obj, Object obj2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            Long l5 = (i & 1) != 0 ? null : l;
            String str9 = (i & 2) != 0 ? null : str;
            Double d2 = (i & 4) != 0 ? null : d;
            Integer num9 = (i & 8) != 0 ? null : num;
            String str10 = (i & 16) != 0 ? null : str2;
            String str11 = (i & 32) != 0 ? null : str3;
            String str12 = (i & 64) != 0 ? null : str4;
            Boolean bool4 = (i & 128) != 0 ? null : bool;
            String str13 = (i & 256) != 0 ? null : str5;
            List list12 = (i & 512) != 0 ? null : list;
            Integer num10 = (i & 1024) != 0 ? null : num2;
            Long l6 = (i & 2048) != 0 ? null : l2;
            Integer num11 = (i & 4096) != 0 ? null : num3;
            Boolean bool5 = (i & 8192) != 0 ? null : bool2;
            String str14 = (i & 16384) != 0 ? null : str6;
            this(l5, str9, d2, num9, str10, str11, str12, bool4, str13, list12, num10, l6, num11, bool5, str14, (i & 32768) != 0 ? null : l3, (i & 65536) != 0 ? null : list2, (i & 131072) != 0 ? null : list3, (i & 262144) != 0 ? null : bool3, (i & 524288) != 0 ? null : str7, (i & 1048576) != 0 ? null : list4, (i & 2097152) != 0 ? null : list5, (i & 4194304) != 0 ? null : list6, (i & 8388608) != 0 ? null : num4, (i & 16777216) != 0 ? null : num5, (i & 33554432) != 0 ? null : l4, (i & 67108864) != 0 ? null : num6, (i & 134217728) != 0 ? null : num7, (i & 268435456) != 0 ? null : list7, (i & 536870912) != 0 ? null : list8, (i & 1073741824) != 0 ? null : list9, (i & Integer.MIN_VALUE) != 0 ? null : list10, (i2 & 1) != 0 ? null : num8, (i2 & 2) != 0 ? null : str8, (i2 & 4) != 0 ? null : list11, (i2 & 8) != 0 ? null : obj, (i2 & 16) != 0 ? null : obj2);
        }

        @Nullable
        public final Long getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final Double getScore() {
            return this.score;
        }

        @Nullable
        public final Integer getMovieType() {
            return this.movieType;
        }

        @Nullable
        public final String getMovieTypeName() {
            return this.movieTypeName;
        }

        @Nullable
        public final String getCoverHorizontalImage() {
            return this.coverHorizontalImage;
        }

        @Nullable
        public final String getCoverVerticalImage() {
            return this.coverVerticalImage;
        }

        @Nullable
        public final Boolean getUnlockPlayback() {
            return this.unlockPlayback;
        }

        @Nullable
        public final String getSeasonDescription() {
            return this.seasonDescription;
        }

        @Nullable
        public final List<String> getLanguages() {
            return this.languages;
        }

        @Nullable
        public final Integer getLastEpisodeCount() {
            return this.lastEpisodeCount;
        }

        @Nullable
        public final Long getServerTime() {
            return this.serverTime;
        }

        @Nullable
        public final Integer getTotalNumber() {
            return this.totalNumber;
        }

        @Nullable
        public final Boolean getWoolUser() {
            return this.woolUser;
        }

        @Nullable
        public final String getBriefIntroduction() {
            return this.briefIntroduction;
        }

        @Nullable
        public final Long getPublishTime() {
            return this.publishTime;
        }

        @Nullable
        public final List<String> getTags() {
            return this.tags;
        }

        @Nullable
        public final List<String> getCountries() {
            return this.countries;
        }

        @Nullable
        public final Boolean isAuthorized() {
            return this.isAuthorized;
        }

        @Nullable
        public final String getOriginalTitle() {
            return this.originalTitle;
        }

        @Nullable
        public final List<Person> getDirectors() {
            return this.directors;
        }

        @Nullable
        public final List<Person> getActors() {
            return this.actors;
        }

        @Nullable
        public final List<ApiEpisode> getEpisodes() {
            return this.episodes;
        }

        @Nullable
        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        @Nullable
        public final Integer getUpdateNumber() {
            return this.updateNumber;
        }

        @Nullable
        public final Long getWatchCount() {
            return this.watchCount;
        }

        @Nullable
        public final Integer getCommentTotal() {
            return this.commentTotal;
        }

        @Nullable
        public final Integer getPreviewTime() {
            return this.previewTime;
        }

        @Nullable
        public final List<Season> getSeasons() {
            return this.seasons;
        }

        @Nullable
        public final List<String> getAudioTags() {
            return this.audioTags;
        }

        @Nullable
        public final List<Long> getCountryIds() {
            return this.countryIds;
        }

        @Nullable
        public final List<Long> getTagIds() {
            return this.tagIds;
        }

        @Nullable
        public final Integer getResolution() {
            return this.resolution;
        }

        @Nullable
        public final String getIndiaResolutionLabel() {
            return this.indiaResolutionLabel;
        }

        @Nullable
        public final List<Titbit> getTitbits() {
            return this.titbits;
        }

        @Nullable
        public final Object getHonorTag() {
            return this.honorTag;
        }

        @Nullable
        public final Object getDownloadTag() {
            return this.downloadTag;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/cncverse/CastleTvProvider$Person;", "", "id", "", "name", "", "avatar", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "getAvatar", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/cncverse/CastleTvProvider$Person;", "equals", "", "other", "hashCode", "", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Person {

        @Nullable
        private final String avatar;

        @Nullable
        private final Long id;

        @Nullable
        private final String name;

        public Person() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Person copy$default(Person person, Long l, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                l = person.id;
            }
            if ((i & 2) != 0) {
                str = person.name;
            }
            if ((i & 4) != 0) {
                str2 = person.avatar;
            }
            return person.copy(l, str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getAvatar() {
            return this.avatar;
        }

        @NotNull
        public final Person copy(@Nullable Long id, @Nullable String name, @Nullable String avatar) {
            return new Person(id, name, avatar);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Person)) {
                return false;
            }
            Person person = (Person) other;
            return Intrinsics.areEqual(this.id, person.id) && Intrinsics.areEqual(this.name, person.name) && Intrinsics.areEqual(this.avatar, person.avatar);
        }

        public int hashCode() {
            return ((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.avatar != null ? this.avatar.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Person(id=" + this.id + ", name=" + this.name + ", avatar=" + this.avatar + ')';
        }

        public Person(@Nullable Long id, @Nullable String name, @Nullable String avatar) {
            this.id = id;
            this.name = name;
            this.avatar = avatar;
        }

        public /* synthetic */ Person(Long l, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
        }

        @Nullable
        public final Long getId() {
            return this.id;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getAvatar() {
            return this.avatar;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0092\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010/J\u0014\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00103\u001a\u00020\u0007HÖ\u0081\u0004J\n\u00104\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u001aR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b!\u0010\u001aR\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b#\u0010\u0015¨\u00065"}, d2 = {"Lcom/cncverse/CastleTvProvider$ApiEpisode;", "", "id", "", "title", "", "number", "", "coverImage", "duration", "videos", "", "Lcom/cncverse/CastleTvProvider$VideoQuality;", "playResolution", "mobileTrafficPlayResolution", "tracks", "Lcom/cncverse/CastleTvProvider$Track;", "onlineTime", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Long;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTitle", "()Ljava/lang/String;", "getNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCoverImage", "getDuration", "getVideos", "()Ljava/util/List;", "getPlayResolution", "getMobileTrafficPlayResolution", "getTracks", "getOnlineTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Long;)Lcom/cncverse/CastleTvProvider$ApiEpisode;", "equals", "", "other", "hashCode", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ApiEpisode {

        @Nullable
        private final String coverImage;

        @Nullable
        private final Integer duration;

        @Nullable
        private final Long id;

        @Nullable
        private final Integer mobileTrafficPlayResolution;

        @Nullable
        private final Integer number;

        @Nullable
        private final Long onlineTime;

        @Nullable
        private final Integer playResolution;

        @Nullable
        private final String title;

        @Nullable
        private final List<Track> tracks;

        @Nullable
        private final List<VideoQuality> videos;

        public ApiEpisode() {
            this(null, null, null, null, null, null, null, null, null, null, 1023, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ApiEpisode copy$default(ApiEpisode apiEpisode, Long l, String str, Integer num, String str2, Integer num2, List list, Integer num3, Integer num4, List list2, Long l2, int i, Object obj) {
            if ((i & 1) != 0) {
                l = apiEpisode.id;
            }
            if ((i & 2) != 0) {
                str = apiEpisode.title;
            }
            if ((i & 4) != 0) {
                num = apiEpisode.number;
            }
            if ((i & 8) != 0) {
                str2 = apiEpisode.coverImage;
            }
            if ((i & 16) != 0) {
                num2 = apiEpisode.duration;
            }
            if ((i & 32) != 0) {
                list = apiEpisode.videos;
            }
            if ((i & 64) != 0) {
                num3 = apiEpisode.playResolution;
            }
            if ((i & 128) != 0) {
                num4 = apiEpisode.mobileTrafficPlayResolution;
            }
            if ((i & 256) != 0) {
                list2 = apiEpisode.tracks;
            }
            if ((i & 512) != 0) {
                l2 = apiEpisode.onlineTime;
            }
            List list3 = list2;
            Long l3 = l2;
            Integer num5 = num3;
            Integer num6 = num4;
            Integer num7 = num2;
            List list4 = list;
            return apiEpisode.copy(l, str, num, str2, num7, list4, num5, num6, list3, l3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Long getOnlineTime() {
            return this.onlineTime;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getNumber() {
            return this.number;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getDuration() {
            return this.duration;
        }

        @Nullable
        public final List<VideoQuality> component6() {
            return this.videos;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getPlayResolution() {
            return this.playResolution;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getMobileTrafficPlayResolution() {
            return this.mobileTrafficPlayResolution;
        }

        @Nullable
        public final List<Track> component9() {
            return this.tracks;
        }

        @NotNull
        public final ApiEpisode copy(@Nullable Long id, @Nullable String title, @Nullable Integer number, @Nullable String coverImage, @Nullable Integer duration, @Nullable List<VideoQuality> videos, @Nullable Integer playResolution, @Nullable Integer mobileTrafficPlayResolution, @Nullable List<Track> tracks, @Nullable Long onlineTime) {
            return new ApiEpisode(id, title, number, coverImage, duration, videos, playResolution, mobileTrafficPlayResolution, tracks, onlineTime);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ApiEpisode)) {
                return false;
            }
            ApiEpisode apiEpisode = (ApiEpisode) other;
            return Intrinsics.areEqual(this.id, apiEpisode.id) && Intrinsics.areEqual(this.title, apiEpisode.title) && Intrinsics.areEqual(this.number, apiEpisode.number) && Intrinsics.areEqual(this.coverImage, apiEpisode.coverImage) && Intrinsics.areEqual(this.duration, apiEpisode.duration) && Intrinsics.areEqual(this.videos, apiEpisode.videos) && Intrinsics.areEqual(this.playResolution, apiEpisode.playResolution) && Intrinsics.areEqual(this.mobileTrafficPlayResolution, apiEpisode.mobileTrafficPlayResolution) && Intrinsics.areEqual(this.tracks, apiEpisode.tracks) && Intrinsics.areEqual(this.onlineTime, apiEpisode.onlineTime);
        }

        public int hashCode() {
            return ((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.number == null ? 0 : this.number.hashCode())) * 31) + (this.coverImage == null ? 0 : this.coverImage.hashCode())) * 31) + (this.duration == null ? 0 : this.duration.hashCode())) * 31) + (this.videos == null ? 0 : this.videos.hashCode())) * 31) + (this.playResolution == null ? 0 : this.playResolution.hashCode())) * 31) + (this.mobileTrafficPlayResolution == null ? 0 : this.mobileTrafficPlayResolution.hashCode())) * 31) + (this.tracks == null ? 0 : this.tracks.hashCode())) * 31) + (this.onlineTime != null ? this.onlineTime.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "ApiEpisode(id=" + this.id + ", title=" + this.title + ", number=" + this.number + ", coverImage=" + this.coverImage + ", duration=" + this.duration + ", videos=" + this.videos + ", playResolution=" + this.playResolution + ", mobileTrafficPlayResolution=" + this.mobileTrafficPlayResolution + ", tracks=" + this.tracks + ", onlineTime=" + this.onlineTime + ')';
        }

        public ApiEpisode(@Nullable Long id, @Nullable String title, @Nullable Integer number, @Nullable String coverImage, @Nullable Integer duration, @Nullable List<VideoQuality> list, @Nullable Integer playResolution, @Nullable Integer mobileTrafficPlayResolution, @Nullable List<Track> list2, @Nullable Long onlineTime) {
            this.id = id;
            this.title = title;
            this.number = number;
            this.coverImage = coverImage;
            this.duration = duration;
            this.videos = list;
            this.playResolution = playResolution;
            this.mobileTrafficPlayResolution = mobileTrafficPlayResolution;
            this.tracks = list2;
            this.onlineTime = onlineTime;
        }

        public /* synthetic */ ApiEpisode(Long l, String str, Integer num, String str2, Integer num2, List list, Integer num3, Integer num4, List list2, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : num3, (i & 128) != 0 ? null : num4, (i & 256) != 0 ? null : list2, (i & 512) != 0 ? null : l2);
        }

        @Nullable
        public final Long getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final Integer getNumber() {
            return this.number;
        }

        @Nullable
        public final String getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        public final Integer getDuration() {
            return this.duration;
        }

        @Nullable
        public final List<VideoQuality> getVideos() {
            return this.videos;
        }

        @Nullable
        public final Integer getPlayResolution() {
            return this.playResolution;
        }

        @Nullable
        public final Integer getMobileTrafficPlayResolution() {
            return this.mobileTrafficPlayResolution;
        }

        @Nullable
        public final List<Track> getTracks() {
            return this.tracks;
        }

        @Nullable
        public final Long getOnlineTime() {
            return this.onlineTime;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/cncverse/CastleTvProvider$VideoQuality;", "", "resolution", "", "resolutionDescription", "", "size", "", "premiumProPermission", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getResolution", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResolutionDescription", "()Ljava/lang/String;", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPremiumProPermission", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/cncverse/CastleTvProvider$VideoQuality;", "equals", "other", "hashCode", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class VideoQuality {

        @Nullable
        private final Boolean premiumProPermission;

        @Nullable
        private final Integer resolution;

        @Nullable
        private final String resolutionDescription;

        @Nullable
        private final Long size;

        public VideoQuality() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ VideoQuality copy$default(VideoQuality videoQuality, Integer num, String str, Long l, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                num = videoQuality.resolution;
            }
            if ((i & 2) != 0) {
                str = videoQuality.resolutionDescription;
            }
            if ((i & 4) != 0) {
                l = videoQuality.size;
            }
            if ((i & 8) != 0) {
                bool = videoQuality.premiumProPermission;
            }
            return videoQuality.copy(num, str, l, bool);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getResolution() {
            return this.resolution;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getResolutionDescription() {
            return this.resolutionDescription;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getSize() {
            return this.size;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getPremiumProPermission() {
            return this.premiumProPermission;
        }

        @NotNull
        public final VideoQuality copy(@Nullable Integer resolution, @Nullable String resolutionDescription, @Nullable Long size, @Nullable Boolean premiumProPermission) {
            return new VideoQuality(resolution, resolutionDescription, size, premiumProPermission);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoQuality)) {
                return false;
            }
            VideoQuality videoQuality = (VideoQuality) other;
            return Intrinsics.areEqual(this.resolution, videoQuality.resolution) && Intrinsics.areEqual(this.resolutionDescription, videoQuality.resolutionDescription) && Intrinsics.areEqual(this.size, videoQuality.size) && Intrinsics.areEqual(this.premiumProPermission, videoQuality.premiumProPermission);
        }

        public int hashCode() {
            return ((((((this.resolution == null ? 0 : this.resolution.hashCode()) * 31) + (this.resolutionDescription == null ? 0 : this.resolutionDescription.hashCode())) * 31) + (this.size == null ? 0 : this.size.hashCode())) * 31) + (this.premiumProPermission != null ? this.premiumProPermission.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "VideoQuality(resolution=" + this.resolution + ", resolutionDescription=" + this.resolutionDescription + ", size=" + this.size + ", premiumProPermission=" + this.premiumProPermission + ')';
        }

        public VideoQuality(@Nullable Integer resolution, @Nullable String resolutionDescription, @Nullable Long size, @Nullable Boolean premiumProPermission) {
            this.resolution = resolution;
            this.resolutionDescription = resolutionDescription;
            this.size = size;
            this.premiumProPermission = premiumProPermission;
        }

        public /* synthetic */ VideoQuality(Integer num, String str, Long l, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : bool);
        }

        @Nullable
        public final Integer getResolution() {
            return this.resolution;
        }

        @Nullable
        public final String getResolutionDescription() {
            return this.resolutionDescription;
        }

        @Nullable
        public final Long getSize() {
            return this.size;
        }

        @Nullable
        public final Boolean getPremiumProPermission() {
            return this.premiumProPermission;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011Jt\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010&J\u0014\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010)\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010*\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0007\u0010\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u0011R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u0011¨\u0006+"}, d2 = {"Lcom/cncverse/CastleTvProvider$Track;", "", "languageId", "", "languageName", "", "abbreviate", "isDefault", "", "existIndividualVideo", "subtitles", "", "order", "index", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getLanguageId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLanguageName", "()Ljava/lang/String;", "getAbbreviate", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getExistIndividualVideo", "getSubtitles", "()Ljava/util/List;", "getOrder", "getIndex", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/cncverse/CastleTvProvider$Track;", "equals", "other", "hashCode", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Track {

        @Nullable
        private final String abbreviate;

        @Nullable
        private final Boolean existIndividualVideo;

        @Nullable
        private final Integer index;

        @Nullable
        private final Boolean isDefault;

        @Nullable
        private final Integer languageId;

        @Nullable
        private final String languageName;

        @Nullable
        private final Integer order;

        @Nullable
        private final List<Object> subtitles;

        public Track() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Track copy$default(Track track, Integer num, String str, String str2, Boolean bool, Boolean bool2, List list, Integer num2, Integer num3, int i, Object obj) {
            if ((i & 1) != 0) {
                num = track.languageId;
            }
            if ((i & 2) != 0) {
                str = track.languageName;
            }
            if ((i & 4) != 0) {
                str2 = track.abbreviate;
            }
            if ((i & 8) != 0) {
                bool = track.isDefault;
            }
            if ((i & 16) != 0) {
                bool2 = track.existIndividualVideo;
            }
            if ((i & 32) != 0) {
                list = track.subtitles;
            }
            if ((i & 64) != 0) {
                num2 = track.order;
            }
            if ((i & 128) != 0) {
                num3 = track.index;
            }
            Integer num4 = num2;
            Integer num5 = num3;
            Boolean bool3 = bool2;
            List list2 = list;
            return track.copy(num, str, str2, bool, bool3, list2, num4, num5);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getLanguageId() {
            return this.languageId;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLanguageName() {
            return this.languageName;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getAbbreviate() {
            return this.abbreviate;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getIsDefault() {
            return this.isDefault;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getExistIndividualVideo() {
            return this.existIndividualVideo;
        }

        @Nullable
        public final List<Object> component6() {
            return this.subtitles;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getOrder() {
            return this.order;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getIndex() {
            return this.index;
        }

        @NotNull
        public final Track copy(@Nullable Integer languageId, @Nullable String languageName, @Nullable String abbreviate, @Nullable Boolean isDefault, @Nullable Boolean existIndividualVideo, @Nullable List<? extends Object> subtitles, @Nullable Integer order, @Nullable Integer index) {
            return new Track(languageId, languageName, abbreviate, isDefault, existIndividualVideo, subtitles, order, index);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Track)) {
                return false;
            }
            Track track = (Track) other;
            return Intrinsics.areEqual(this.languageId, track.languageId) && Intrinsics.areEqual(this.languageName, track.languageName) && Intrinsics.areEqual(this.abbreviate, track.abbreviate) && Intrinsics.areEqual(this.isDefault, track.isDefault) && Intrinsics.areEqual(this.existIndividualVideo, track.existIndividualVideo) && Intrinsics.areEqual(this.subtitles, track.subtitles) && Intrinsics.areEqual(this.order, track.order) && Intrinsics.areEqual(this.index, track.index);
        }

        public int hashCode() {
            return ((((((((((((((this.languageId == null ? 0 : this.languageId.hashCode()) * 31) + (this.languageName == null ? 0 : this.languageName.hashCode())) * 31) + (this.abbreviate == null ? 0 : this.abbreviate.hashCode())) * 31) + (this.isDefault == null ? 0 : this.isDefault.hashCode())) * 31) + (this.existIndividualVideo == null ? 0 : this.existIndividualVideo.hashCode())) * 31) + (this.subtitles == null ? 0 : this.subtitles.hashCode())) * 31) + (this.order == null ? 0 : this.order.hashCode())) * 31) + (this.index != null ? this.index.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Track(languageId=" + this.languageId + ", languageName=" + this.languageName + ", abbreviate=" + this.abbreviate + ", isDefault=" + this.isDefault + ", existIndividualVideo=" + this.existIndividualVideo + ", subtitles=" + this.subtitles + ", order=" + this.order + ", index=" + this.index + ')';
        }

        public Track(@Nullable Integer languageId, @Nullable String languageName, @Nullable String abbreviate, @Nullable Boolean isDefault, @Nullable Boolean existIndividualVideo, @Nullable List<? extends Object> list, @Nullable Integer order, @Nullable Integer index) {
            this.languageId = languageId;
            this.languageName = languageName;
            this.abbreviate = abbreviate;
            this.isDefault = isDefault;
            this.existIndividualVideo = existIndividualVideo;
            this.subtitles = list;
            this.order = order;
            this.index = index;
        }

        public /* synthetic */ Track(Integer num, String str, String str2, Boolean bool, Boolean bool2, List list, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : bool2, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : num2, (i & 128) != 0 ? null : num3);
        }

        @Nullable
        public final Integer getLanguageId() {
            return this.languageId;
        }

        @Nullable
        public final String getLanguageName() {
            return this.languageName;
        }

        @Nullable
        public final String getAbbreviate() {
            return this.abbreviate;
        }

        @Nullable
        public final Boolean isDefault() {
            return this.isDefault;
        }

        @Nullable
        public final Boolean getExistIndividualVideo() {
            return this.existIndividualVideo;
        }

        @Nullable
        public final List<Object> getSubtitles() {
            return this.subtitles;
        }

        @Nullable
        public final Integer getOrder() {
            return this.order;
        }

        @Nullable
        public final Integer getIndex() {
            return this.index;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\b\u0010\u0014¨\u0006 "}, d2 = {"Lcom/cncverse/CastleTvProvider$Season;", "", "movieId", "", "number", "", "description", "", "isCurrent", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V", "getMovieId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDescription", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/cncverse/CastleTvProvider$Season;", "equals", "other", "hashCode", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Season {

        @Nullable
        private final String description;

        @Nullable
        private final Boolean isCurrent;

        @Nullable
        private final Long movieId;

        @Nullable
        private final Integer number;

        public Season() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Season copy$default(Season season, Long l, Integer num, String str, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                l = season.movieId;
            }
            if ((i & 2) != 0) {
                num = season.number;
            }
            if ((i & 4) != 0) {
                str = season.description;
            }
            if ((i & 8) != 0) {
                bool = season.isCurrent;
            }
            return season.copy(l, num, str, bool);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getMovieId() {
            return this.movieId;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getNumber() {
            return this.number;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getIsCurrent() {
            return this.isCurrent;
        }

        @NotNull
        public final Season copy(@Nullable Long movieId, @Nullable Integer number, @Nullable String description, @Nullable Boolean isCurrent) {
            return new Season(movieId, number, description, isCurrent);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Season)) {
                return false;
            }
            Season season = (Season) other;
            return Intrinsics.areEqual(this.movieId, season.movieId) && Intrinsics.areEqual(this.number, season.number) && Intrinsics.areEqual(this.description, season.description) && Intrinsics.areEqual(this.isCurrent, season.isCurrent);
        }

        public int hashCode() {
            return ((((((this.movieId == null ? 0 : this.movieId.hashCode()) * 31) + (this.number == null ? 0 : this.number.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.isCurrent != null ? this.isCurrent.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Season(movieId=" + this.movieId + ", number=" + this.number + ", description=" + this.description + ", isCurrent=" + this.isCurrent + ')';
        }

        public Season(@Nullable Long movieId, @Nullable Integer number, @Nullable String description, @Nullable Boolean isCurrent) {
            this.movieId = movieId;
            this.number = number;
            this.description = description;
            this.isCurrent = isCurrent;
        }

        public /* synthetic */ Season(Long l, Integer num, String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : bool);
        }

        @Nullable
        public final Long getMovieId() {
            return this.movieId;
        }

        @Nullable
        public final Integer getNumber() {
            return this.number;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final Boolean isCurrent() {
            return this.isCurrent;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/cncverse/CastleTvProvider$Titbit;", "", "id", "", "name", "videoCategory", "", "coverImage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getVideoCategory", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCoverImage", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/cncverse/CastleTvProvider$Titbit;", "equals", "", "other", "hashCode", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Titbit {

        @Nullable
        private final String coverImage;

        @Nullable
        private final String id;

        @Nullable
        private final String name;

        @Nullable
        private final Integer videoCategory;

        public Titbit() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Titbit copy$default(Titbit titbit, String str, String str2, Integer num, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = titbit.id;
            }
            if ((i & 2) != 0) {
                str2 = titbit.name;
            }
            if ((i & 4) != 0) {
                num = titbit.videoCategory;
            }
            if ((i & 8) != 0) {
                str3 = titbit.coverImage;
            }
            return titbit.copy(str, str2, num, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getVideoCategory() {
            return this.videoCategory;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCoverImage() {
            return this.coverImage;
        }

        @NotNull
        public final Titbit copy(@Nullable String id, @Nullable String name, @Nullable Integer videoCategory, @Nullable String coverImage) {
            return new Titbit(id, name, videoCategory, coverImage);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Titbit)) {
                return false;
            }
            Titbit titbit = (Titbit) other;
            return Intrinsics.areEqual(this.id, titbit.id) && Intrinsics.areEqual(this.name, titbit.name) && Intrinsics.areEqual(this.videoCategory, titbit.videoCategory) && Intrinsics.areEqual(this.coverImage, titbit.coverImage);
        }

        public int hashCode() {
            return ((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.videoCategory == null ? 0 : this.videoCategory.hashCode())) * 31) + (this.coverImage != null ? this.coverImage.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Titbit(id=" + this.id + ", name=" + this.name + ", videoCategory=" + this.videoCategory + ", coverImage=" + this.coverImage + ')';
        }

        public Titbit(@Nullable String id, @Nullable String name, @Nullable Integer videoCategory, @Nullable String coverImage) {
            this.id = id;
            this.name = name;
            this.videoCategory = videoCategory;
            this.coverImage = coverImage;
        }

        public /* synthetic */ Titbit(String str, String str2, Integer num, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str3);
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final Integer getVideoCategory() {
            return this.videoCategory;
        }

        @Nullable
        public final String getCoverImage() {
            return this.coverImage;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/cncverse/CastleTvProvider$SearchApiResponse;", "", "code", "", "msg", "", "data", "Lcom/cncverse/CastleTvProvider$SearchData;", "<init>", "(ILjava/lang/String;Lcom/cncverse/CastleTvProvider$SearchData;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/cncverse/CastleTvProvider$SearchData;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SearchApiResponse {
        private final int code;

        @NotNull
        private final SearchData data;

        @NotNull
        private final String msg;

        public static /* synthetic */ SearchApiResponse copy$default(SearchApiResponse searchApiResponse, int i, String str, SearchData searchData, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = searchApiResponse.code;
            }
            if ((i2 & 2) != 0) {
                str = searchApiResponse.msg;
            }
            if ((i2 & 4) != 0) {
                searchData = searchApiResponse.data;
            }
            return searchApiResponse.copy(i, str, searchData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final SearchData getData() {
            return this.data;
        }

        @NotNull
        public final SearchApiResponse copy(int code, @NotNull String msg, @NotNull SearchData data) {
            return new SearchApiResponse(code, msg, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchApiResponse)) {
                return false;
            }
            SearchApiResponse searchApiResponse = (SearchApiResponse) other;
            return this.code == searchApiResponse.code && Intrinsics.areEqual(this.msg, searchApiResponse.msg) && Intrinsics.areEqual(this.data, searchApiResponse.data);
        }

        public int hashCode() {
            return (((this.code * 31) + this.msg.hashCode()) * 31) + this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "SearchApiResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public SearchApiResponse(int code, @NotNull String msg, @NotNull SearchData data) {
            this.code = code;
            this.msg = msg;
            this.data = data;
        }

        public final int getCode() {
            return this.code;
        }

        @NotNull
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        public final SearchData getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JP\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/cncverse/CastleTvProvider$SearchData;", "", "page", "", "pages", "size", "total", "rows", "", "Lcom/cncverse/CastleTvProvider$SearchResultItem;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getPage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPages", "getSize", "getTotal", "getRows", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/cncverse/CastleTvProvider$SearchData;", "equals", "", "other", "hashCode", "toString", "", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SearchData {

        @Nullable
        private final Integer page;

        @Nullable
        private final Integer pages;

        @Nullable
        private final List<SearchResultItem> rows;

        @Nullable
        private final Integer size;

        @Nullable
        private final Integer total;

        public SearchData() {
            this(null, null, null, null, null, 31, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SearchData copy$default(SearchData searchData, Integer num, Integer num2, Integer num3, Integer num4, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                num = searchData.page;
            }
            if ((i & 2) != 0) {
                num2 = searchData.pages;
            }
            if ((i & 4) != 0) {
                num3 = searchData.size;
            }
            if ((i & 8) != 0) {
                num4 = searchData.total;
            }
            if ((i & 16) != 0) {
                list = searchData.rows;
            }
            List list2 = list;
            Integer num5 = num3;
            return searchData.copy(num, num2, num5, num4, list2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getPage() {
            return this.page;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getPages() {
            return this.pages;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getSize() {
            return this.size;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getTotal() {
            return this.total;
        }

        @Nullable
        public final List<SearchResultItem> component5() {
            return this.rows;
        }

        @NotNull
        public final SearchData copy(@Nullable Integer page, @Nullable Integer pages, @Nullable Integer size, @Nullable Integer total, @Nullable List<SearchResultItem> rows) {
            return new SearchData(page, pages, size, total, rows);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchData)) {
                return false;
            }
            SearchData searchData = (SearchData) other;
            return Intrinsics.areEqual(this.page, searchData.page) && Intrinsics.areEqual(this.pages, searchData.pages) && Intrinsics.areEqual(this.size, searchData.size) && Intrinsics.areEqual(this.total, searchData.total) && Intrinsics.areEqual(this.rows, searchData.rows);
        }

        public int hashCode() {
            return ((((((((this.page == null ? 0 : this.page.hashCode()) * 31) + (this.pages == null ? 0 : this.pages.hashCode())) * 31) + (this.size == null ? 0 : this.size.hashCode())) * 31) + (this.total == null ? 0 : this.total.hashCode())) * 31) + (this.rows != null ? this.rows.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "SearchData(page=" + this.page + ", pages=" + this.pages + ", size=" + this.size + ", total=" + this.total + ", rows=" + this.rows + ')';
        }

        public SearchData(@Nullable Integer page, @Nullable Integer pages, @Nullable Integer size, @Nullable Integer total, @Nullable List<SearchResultItem> list) {
            this.page = page;
            this.pages = pages;
            this.size = size;
            this.total = total;
            this.rows = list;
        }

        public /* synthetic */ SearchData(Integer num, Integer num2, Integer num3, Integer num4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : list);
        }

        @Nullable
        public final Integer getPage() {
            return this.page;
        }

        @Nullable
        public final Integer getPages() {
            return this.pages;
        }

        @Nullable
        public final Integer getSize() {
            return this.size;
        }

        @Nullable
        public final Integer getTotal() {
            return this.total;
        }

        @Nullable
        public final List<SearchResultItem> getRows() {
            return this.rows;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b<\b\u0086\b\u0018\u00002\u00020\u0001Bå\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00109\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010B\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0011\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003Jì\u0001\u0010G\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010HJ\u0014\u0010I\u001a\u00020\u000e2\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010K\u001a\u00020\tHÖ\u0081\u0004J\n\u0010L\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010%\u001a\u0004\b/\u0010$R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b0\u0010\u001cR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010+\u001a\u0004\b1\u0010*R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b3\u0010\u001cR\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b4\u0010.R\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b5\u0010.¨\u0006M"}, d2 = {"Lcom/cncverse/CastleTvProvider$SearchResultItem;", "", "id", "", "title", "", "score", "", "movieType", "", "movieTypeName", "coverHorizontalImage", "coverVerticalImage", "unlockPlayback", "", "seasonDescription", "languages", "", "lastEpisodeCount", "serverTime", "woolUser", "briefIntroduction", "publishTime", "tags", "countries", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTitle", "()Ljava/lang/String;", "getScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMovieType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMovieTypeName", "getCoverHorizontalImage", "getCoverVerticalImage", "getUnlockPlayback", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSeasonDescription", "getLanguages", "()Ljava/util/List;", "getLastEpisodeCount", "getServerTime", "getWoolUser", "getBriefIntroduction", "getPublishTime", "getTags", "getCountries", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;)Lcom/cncverse/CastleTvProvider$SearchResultItem;", "equals", "other", "hashCode", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SearchResultItem {

        @Nullable
        private final String briefIntroduction;

        @Nullable
        private final List<String> countries;

        @Nullable
        private final String coverHorizontalImage;

        @Nullable
        private final String coverVerticalImage;

        @Nullable
        private final Long id;

        @Nullable
        private final List<String> languages;

        @Nullable
        private final Integer lastEpisodeCount;

        @Nullable
        private final Integer movieType;

        @Nullable
        private final String movieTypeName;

        @Nullable
        private final Long publishTime;

        @Nullable
        private final Double score;

        @Nullable
        private final String seasonDescription;

        @Nullable
        private final Long serverTime;

        @Nullable
        private final List<String> tags;

        @Nullable
        private final String title;

        @Nullable
        private final Boolean unlockPlayback;

        @Nullable
        private final Boolean woolUser;

        public SearchResultItem() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SearchResultItem copy$default(SearchResultItem searchResultItem, Long l, String str, Double d, Integer num, String str2, String str3, String str4, Boolean bool, String str5, List list, Integer num2, Long l2, Boolean bool2, String str6, Long l3, List list2, List list3, int i, Object obj) {
            List list4;
            List list5;
            Long l4 = (i & 1) != 0 ? searchResultItem.id : l;
            String str7 = (i & 2) != 0 ? searchResultItem.title : str;
            Double d2 = (i & 4) != 0 ? searchResultItem.score : d;
            Integer num3 = (i & 8) != 0 ? searchResultItem.movieType : num;
            String str8 = (i & 16) != 0 ? searchResultItem.movieTypeName : str2;
            String str9 = (i & 32) != 0 ? searchResultItem.coverHorizontalImage : str3;
            String str10 = (i & 64) != 0 ? searchResultItem.coverVerticalImage : str4;
            Boolean bool3 = (i & 128) != 0 ? searchResultItem.unlockPlayback : bool;
            String str11 = (i & 256) != 0 ? searchResultItem.seasonDescription : str5;
            List list6 = (i & 512) != 0 ? searchResultItem.languages : list;
            Integer num4 = (i & 1024) != 0 ? searchResultItem.lastEpisodeCount : num2;
            Long l5 = (i & 2048) != 0 ? searchResultItem.serverTime : l2;
            Boolean bool4 = (i & 4096) != 0 ? searchResultItem.woolUser : bool2;
            String str12 = (i & 8192) != 0 ? searchResultItem.briefIntroduction : str6;
            Long l6 = l4;
            Long l7 = (i & 16384) != 0 ? searchResultItem.publishTime : l3;
            List list7 = (i & 32768) != 0 ? searchResultItem.tags : list2;
            if ((i & 65536) != 0) {
                list5 = list7;
                list4 = searchResultItem.countries;
            } else {
                list4 = list3;
                list5 = list7;
            }
            return searchResultItem.copy(l6, str7, d2, num3, str8, str9, str10, bool3, str11, list6, num4, l5, bool4, str12, l7, list5, list4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getId() {
            return this.id;
        }

        @Nullable
        public final List<String> component10() {
            return this.languages;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Integer getLastEpisodeCount() {
            return this.lastEpisodeCount;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Long getServerTime() {
            return this.serverTime;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Boolean getWoolUser() {
            return this.woolUser;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getBriefIntroduction() {
            return this.briefIntroduction;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Long getPublishTime() {
            return this.publishTime;
        }

        @Nullable
        public final List<String> component16() {
            return this.tags;
        }

        @Nullable
        public final List<String> component17() {
            return this.countries;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Double getScore() {
            return this.score;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getMovieType() {
            return this.movieType;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getMovieTypeName() {
            return this.movieTypeName;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getCoverHorizontalImage() {
            return this.coverHorizontalImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getCoverVerticalImage() {
            return this.coverVerticalImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getUnlockPlayback() {
            return this.unlockPlayback;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getSeasonDescription() {
            return this.seasonDescription;
        }

        @NotNull
        public final SearchResultItem copy(@Nullable Long id, @Nullable String title, @Nullable Double score, @Nullable Integer movieType, @Nullable String movieTypeName, @Nullable String coverHorizontalImage, @Nullable String coverVerticalImage, @Nullable Boolean unlockPlayback, @Nullable String seasonDescription, @Nullable List<String> languages, @Nullable Integer lastEpisodeCount, @Nullable Long serverTime, @Nullable Boolean woolUser, @Nullable String briefIntroduction, @Nullable Long publishTime, @Nullable List<String> tags, @Nullable List<String> countries) {
            return new SearchResultItem(id, title, score, movieType, movieTypeName, coverHorizontalImage, coverVerticalImage, unlockPlayback, seasonDescription, languages, lastEpisodeCount, serverTime, woolUser, briefIntroduction, publishTime, tags, countries);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchResultItem)) {
                return false;
            }
            SearchResultItem searchResultItem = (SearchResultItem) other;
            return Intrinsics.areEqual(this.id, searchResultItem.id) && Intrinsics.areEqual(this.title, searchResultItem.title) && Intrinsics.areEqual(this.score, searchResultItem.score) && Intrinsics.areEqual(this.movieType, searchResultItem.movieType) && Intrinsics.areEqual(this.movieTypeName, searchResultItem.movieTypeName) && Intrinsics.areEqual(this.coverHorizontalImage, searchResultItem.coverHorizontalImage) && Intrinsics.areEqual(this.coverVerticalImage, searchResultItem.coverVerticalImage) && Intrinsics.areEqual(this.unlockPlayback, searchResultItem.unlockPlayback) && Intrinsics.areEqual(this.seasonDescription, searchResultItem.seasonDescription) && Intrinsics.areEqual(this.languages, searchResultItem.languages) && Intrinsics.areEqual(this.lastEpisodeCount, searchResultItem.lastEpisodeCount) && Intrinsics.areEqual(this.serverTime, searchResultItem.serverTime) && Intrinsics.areEqual(this.woolUser, searchResultItem.woolUser) && Intrinsics.areEqual(this.briefIntroduction, searchResultItem.briefIntroduction) && Intrinsics.areEqual(this.publishTime, searchResultItem.publishTime) && Intrinsics.areEqual(this.tags, searchResultItem.tags) && Intrinsics.areEqual(this.countries, searchResultItem.countries);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.score == null ? 0 : this.score.hashCode())) * 31) + (this.movieType == null ? 0 : this.movieType.hashCode())) * 31) + (this.movieTypeName == null ? 0 : this.movieTypeName.hashCode())) * 31) + (this.coverHorizontalImage == null ? 0 : this.coverHorizontalImage.hashCode())) * 31) + (this.coverVerticalImage == null ? 0 : this.coverVerticalImage.hashCode())) * 31) + (this.unlockPlayback == null ? 0 : this.unlockPlayback.hashCode())) * 31) + (this.seasonDescription == null ? 0 : this.seasonDescription.hashCode())) * 31) + (this.languages == null ? 0 : this.languages.hashCode())) * 31) + (this.lastEpisodeCount == null ? 0 : this.lastEpisodeCount.hashCode())) * 31) + (this.serverTime == null ? 0 : this.serverTime.hashCode())) * 31) + (this.woolUser == null ? 0 : this.woolUser.hashCode())) * 31) + (this.briefIntroduction == null ? 0 : this.briefIntroduction.hashCode())) * 31) + (this.publishTime == null ? 0 : this.publishTime.hashCode())) * 31) + (this.tags == null ? 0 : this.tags.hashCode())) * 31) + (this.countries != null ? this.countries.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SearchResultItem(id=").append(this.id).append(", title=").append(this.title).append(", score=").append(this.score).append(", movieType=").append(this.movieType).append(", movieTypeName=").append(this.movieTypeName).append(", coverHorizontalImage=").append(this.coverHorizontalImage).append(", coverVerticalImage=").append(this.coverVerticalImage).append(", unlockPlayback=").append(this.unlockPlayback).append(", seasonDescription=").append(this.seasonDescription).append(", languages=").append(this.languages).append(", lastEpisodeCount=").append(this.lastEpisodeCount).append(", serverTime=");
            sb.append(this.serverTime).append(", woolUser=").append(this.woolUser).append(", briefIntroduction=").append(this.briefIntroduction).append(", publishTime=").append(this.publishTime).append(", tags=").append(this.tags).append(", countries=").append(this.countries).append(')');
            return sb.toString();
        }

        public SearchResultItem(@Nullable Long id, @Nullable String title, @Nullable Double score, @Nullable Integer movieType, @Nullable String movieTypeName, @Nullable String coverHorizontalImage, @Nullable String coverVerticalImage, @Nullable Boolean unlockPlayback, @Nullable String seasonDescription, @Nullable List<String> list, @Nullable Integer lastEpisodeCount, @Nullable Long serverTime, @Nullable Boolean woolUser, @Nullable String briefIntroduction, @Nullable Long publishTime, @Nullable List<String> list2, @Nullable List<String> list3) {
            this.id = id;
            this.title = title;
            this.score = score;
            this.movieType = movieType;
            this.movieTypeName = movieTypeName;
            this.coverHorizontalImage = coverHorizontalImage;
            this.coverVerticalImage = coverVerticalImage;
            this.unlockPlayback = unlockPlayback;
            this.seasonDescription = seasonDescription;
            this.languages = list;
            this.lastEpisodeCount = lastEpisodeCount;
            this.serverTime = serverTime;
            this.woolUser = woolUser;
            this.briefIntroduction = briefIntroduction;
            this.publishTime = publishTime;
            this.tags = list2;
            this.countries = list3;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ SearchResultItem(Long l, String str, Double d, Integer num, String str2, String str3, String str4, Boolean bool, String str5, List list, Integer num2, Long l2, Boolean bool2, String str6, Long l3, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            Long l4 = (i & 1) != 0 ? null : l;
            String str7 = (i & 2) != 0 ? null : str;
            Double d2 = (i & 4) != 0 ? null : d;
            Integer num3 = (i & 8) != 0 ? null : num;
            String str8 = (i & 16) != 0 ? null : str2;
            String str9 = (i & 32) != 0 ? null : str3;
            String str10 = (i & 64) != 0 ? null : str4;
            Boolean bool3 = (i & 128) != 0 ? null : bool;
            String str11 = (i & 256) != 0 ? null : str5;
            List list4 = (i & 512) != 0 ? null : list;
            Integer num4 = (i & 1024) != 0 ? null : num2;
            Long l5 = (i & 2048) != 0 ? null : l2;
            Boolean bool4 = (i & 4096) != 0 ? null : bool2;
            String str12 = (i & 8192) != 0 ? null : str6;
            Long l6 = (i & 16384) != 0 ? null : l3;
            this(l4, str7, d2, num3, str8, str9, str10, bool3, str11, list4, num4, l5, bool4, str12, l6, (i & 32768) != 0 ? null : list2, (i & 65536) != 0 ? null : list3);
        }

        @Nullable
        public final Long getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final Double getScore() {
            return this.score;
        }

        @Nullable
        public final Integer getMovieType() {
            return this.movieType;
        }

        @Nullable
        public final String getMovieTypeName() {
            return this.movieTypeName;
        }

        @Nullable
        public final String getCoverHorizontalImage() {
            return this.coverHorizontalImage;
        }

        @Nullable
        public final String getCoverVerticalImage() {
            return this.coverVerticalImage;
        }

        @Nullable
        public final Boolean getUnlockPlayback() {
            return this.unlockPlayback;
        }

        @Nullable
        public final String getSeasonDescription() {
            return this.seasonDescription;
        }

        @Nullable
        public final List<String> getLanguages() {
            return this.languages;
        }

        @Nullable
        public final Integer getLastEpisodeCount() {
            return this.lastEpisodeCount;
        }

        @Nullable
        public final Long getServerTime() {
            return this.serverTime;
        }

        @Nullable
        public final Boolean getWoolUser() {
            return this.woolUser;
        }

        @Nullable
        public final String getBriefIntroduction() {
            return this.briefIntroduction;
        }

        @Nullable
        public final Long getPublishTime() {
            return this.publishTime;
        }

        @Nullable
        public final List<String> getTags() {
            return this.tags;
        }

        @Nullable
        public final List<String> getCountries() {
            return this.countries;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/cncverse/CastleTvProvider$VideoResponse;", "", "code", "", "msg", "", "data", "Lcom/cncverse/CastleTvProvider$VideoData;", "<init>", "(ILjava/lang/String;Lcom/cncverse/CastleTvProvider$VideoData;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/cncverse/CastleTvProvider$VideoData;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class VideoResponse {
        private final int code;

        @NotNull
        private final VideoData data;

        @NotNull
        private final String msg;

        public static /* synthetic */ VideoResponse copy$default(VideoResponse videoResponse, int i, String str, VideoData videoData, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = videoResponse.code;
            }
            if ((i2 & 2) != 0) {
                str = videoResponse.msg;
            }
            if ((i2 & 4) != 0) {
                videoData = videoResponse.data;
            }
            return videoResponse.copy(i, str, videoData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final VideoData getData() {
            return this.data;
        }

        @NotNull
        public final VideoResponse copy(int code, @NotNull String msg, @NotNull VideoData data) {
            return new VideoResponse(code, msg, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoResponse)) {
                return false;
            }
            VideoResponse videoResponse = (VideoResponse) other;
            return this.code == videoResponse.code && Intrinsics.areEqual(this.msg, videoResponse.msg) && Intrinsics.areEqual(this.data, videoResponse.data);
        }

        public int hashCode() {
            return (((this.code * 31) + this.msg.hashCode()) * 31) + this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "VideoResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public VideoResponse(int code, @NotNull String msg, @NotNull VideoData data) {
            this.code = code;
            this.msg = msg;
            this.data = data;
        }

        public final int getCode() {
            return this.code;
        }

        @NotNull
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        public final VideoData getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016Jn\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010%J\u0014\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020)HÖ\u0081\u0004J\n\u0010*\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0006\u0010\u0016R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0016¨\u0006+"}, d2 = {"Lcom/cncverse/CastleTvProvider$VideoData;", "", "videoUrl", "", "expireTime", "", "isPreview", "", "videos", "", "Lcom/cncverse/CastleTvProvider$VideoQuality;", "subtitles", "Lcom/cncverse/CastleTvProvider$SubtitleData;", "inBlacklist", "permissionDenied", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getVideoUrl", "()Ljava/lang/String;", "getExpireTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getVideos", "()Ljava/util/List;", "getSubtitles", "getInBlacklist", "getPermissionDenied", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/cncverse/CastleTvProvider$VideoData;", "equals", "other", "hashCode", "", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class VideoData {

        @Nullable
        private final Long expireTime;

        @Nullable
        private final Boolean inBlacklist;

        @Nullable
        private final Boolean isPreview;

        @Nullable
        private final Boolean permissionDenied;

        @Nullable
        private final List<SubtitleData> subtitles;

        @Nullable
        private final String videoUrl;

        @Nullable
        private final List<VideoQuality> videos;

        public VideoData() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VideoData copy$default(VideoData videoData, String str, Long l, Boolean bool, List list, List list2, Boolean bool2, Boolean bool3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = videoData.videoUrl;
            }
            if ((i & 2) != 0) {
                l = videoData.expireTime;
            }
            if ((i & 4) != 0) {
                bool = videoData.isPreview;
            }
            if ((i & 8) != 0) {
                list = videoData.videos;
            }
            if ((i & 16) != 0) {
                list2 = videoData.subtitles;
            }
            if ((i & 32) != 0) {
                bool2 = videoData.inBlacklist;
            }
            if ((i & 64) != 0) {
                bool3 = videoData.permissionDenied;
            }
            Boolean bool4 = bool2;
            Boolean bool5 = bool3;
            List list3 = list2;
            Boolean bool6 = bool;
            return videoData.copy(str, l, bool6, list, list3, bool4, bool5);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getVideoUrl() {
            return this.videoUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getExpireTime() {
            return this.expireTime;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getIsPreview() {
            return this.isPreview;
        }

        @Nullable
        public final List<VideoQuality> component4() {
            return this.videos;
        }

        @Nullable
        public final List<SubtitleData> component5() {
            return this.subtitles;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getInBlacklist() {
            return this.inBlacklist;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getPermissionDenied() {
            return this.permissionDenied;
        }

        @NotNull
        public final VideoData copy(@Nullable String videoUrl, @Nullable Long expireTime, @Nullable Boolean isPreview, @Nullable List<VideoQuality> videos, @Nullable List<SubtitleData> subtitles, @Nullable Boolean inBlacklist, @Nullable Boolean permissionDenied) {
            return new VideoData(videoUrl, expireTime, isPreview, videos, subtitles, inBlacklist, permissionDenied);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoData)) {
                return false;
            }
            VideoData videoData = (VideoData) other;
            return Intrinsics.areEqual(this.videoUrl, videoData.videoUrl) && Intrinsics.areEqual(this.expireTime, videoData.expireTime) && Intrinsics.areEqual(this.isPreview, videoData.isPreview) && Intrinsics.areEqual(this.videos, videoData.videos) && Intrinsics.areEqual(this.subtitles, videoData.subtitles) && Intrinsics.areEqual(this.inBlacklist, videoData.inBlacklist) && Intrinsics.areEqual(this.permissionDenied, videoData.permissionDenied);
        }

        public int hashCode() {
            return ((((((((((((this.videoUrl == null ? 0 : this.videoUrl.hashCode()) * 31) + (this.expireTime == null ? 0 : this.expireTime.hashCode())) * 31) + (this.isPreview == null ? 0 : this.isPreview.hashCode())) * 31) + (this.videos == null ? 0 : this.videos.hashCode())) * 31) + (this.subtitles == null ? 0 : this.subtitles.hashCode())) * 31) + (this.inBlacklist == null ? 0 : this.inBlacklist.hashCode())) * 31) + (this.permissionDenied != null ? this.permissionDenied.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "VideoData(videoUrl=" + this.videoUrl + ", expireTime=" + this.expireTime + ", isPreview=" + this.isPreview + ", videos=" + this.videos + ", subtitles=" + this.subtitles + ", inBlacklist=" + this.inBlacklist + ", permissionDenied=" + this.permissionDenied + ')';
        }

        public VideoData(@Nullable String videoUrl, @Nullable Long expireTime, @Nullable Boolean isPreview, @Nullable List<VideoQuality> list, @Nullable List<SubtitleData> list2, @Nullable Boolean inBlacklist, @Nullable Boolean permissionDenied) {
            this.videoUrl = videoUrl;
            this.expireTime = expireTime;
            this.isPreview = isPreview;
            this.videos = list;
            this.subtitles = list2;
            this.inBlacklist = inBlacklist;
            this.permissionDenied = permissionDenied;
        }

        public /* synthetic */ VideoData(String str, Long l, Boolean bool, List list, List list2, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : list2, (i & 32) != 0 ? null : bool2, (i & 64) != 0 ? null : bool3);
        }

        @Nullable
        public final String getVideoUrl() {
            return this.videoUrl;
        }

        @Nullable
        public final Long getExpireTime() {
            return this.expireTime;
        }

        @Nullable
        public final Boolean isPreview() {
            return this.isPreview;
        }

        @Nullable
        public final List<VideoQuality> getVideos() {
            return this.videos;
        }

        @Nullable
        public final List<SubtitleData> getSubtitles() {
            return this.subtitles;
        }

        @Nullable
        public final Boolean getInBlacklist() {
            return this.inBlacklist;
        }

        @Nullable
        public final Boolean getPermissionDenied() {
            return this.permissionDenied;
        }
    }

    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\b\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\n\u0010\u000e¨\u0006\""}, d2 = {"Lcom/cncverse/CastleTvProvider$SubtitleData;", "", "languageId", "", "abbreviate", "", "title", "url", "isDefault", "", "isAI", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getLanguageId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAbbreviate", "()Ljava/lang/String;", "getTitle", "getUrl", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/cncverse/CastleTvProvider$SubtitleData;", "equals", "other", "hashCode", "toString", "CastleTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SubtitleData {

        @Nullable
        private final String abbreviate;

        @Nullable
        private final Integer isAI;

        @Nullable
        private final Boolean isDefault;

        @Nullable
        private final Integer languageId;

        @Nullable
        private final String title;

        @Nullable
        private final String url;

        public SubtitleData() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ SubtitleData copy$default(SubtitleData subtitleData, Integer num, String str, String str2, String str3, Boolean bool, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = subtitleData.languageId;
            }
            if ((i & 2) != 0) {
                str = subtitleData.abbreviate;
            }
            if ((i & 4) != 0) {
                str2 = subtitleData.title;
            }
            if ((i & 8) != 0) {
                str3 = subtitleData.url;
            }
            if ((i & 16) != 0) {
                bool = subtitleData.isDefault;
            }
            if ((i & 32) != 0) {
                num2 = subtitleData.isAI;
            }
            Boolean bool2 = bool;
            Integer num3 = num2;
            return subtitleData.copy(num, str, str2, str3, bool2, num3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getLanguageId() {
            return this.languageId;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getAbbreviate() {
            return this.abbreviate;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getIsDefault() {
            return this.isDefault;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getIsAI() {
            return this.isAI;
        }

        @NotNull
        public final SubtitleData copy(@Nullable Integer languageId, @Nullable String abbreviate, @Nullable String title, @Nullable String url, @Nullable Boolean isDefault, @Nullable Integer isAI) {
            return new SubtitleData(languageId, abbreviate, title, url, isDefault, isAI);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubtitleData)) {
                return false;
            }
            SubtitleData subtitleData = (SubtitleData) other;
            return Intrinsics.areEqual(this.languageId, subtitleData.languageId) && Intrinsics.areEqual(this.abbreviate, subtitleData.abbreviate) && Intrinsics.areEqual(this.title, subtitleData.title) && Intrinsics.areEqual(this.url, subtitleData.url) && Intrinsics.areEqual(this.isDefault, subtitleData.isDefault) && Intrinsics.areEqual(this.isAI, subtitleData.isAI);
        }

        public int hashCode() {
            return ((((((((((this.languageId == null ? 0 : this.languageId.hashCode()) * 31) + (this.abbreviate == null ? 0 : this.abbreviate.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.isDefault == null ? 0 : this.isDefault.hashCode())) * 31) + (this.isAI != null ? this.isAI.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "SubtitleData(languageId=" + this.languageId + ", abbreviate=" + this.abbreviate + ", title=" + this.title + ", url=" + this.url + ", isDefault=" + this.isDefault + ", isAI=" + this.isAI + ')';
        }

        public SubtitleData(@Nullable Integer languageId, @Nullable String abbreviate, @Nullable String title, @Nullable String url, @Nullable Boolean isDefault, @Nullable Integer isAI) {
            this.languageId = languageId;
            this.abbreviate = abbreviate;
            this.title = title;
            this.url = url;
            this.isDefault = isDefault;
            this.isAI = isAI;
        }

        public /* synthetic */ SubtitleData(Integer num, String str, String str2, String str3, Boolean bool, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : num2);
        }

        @Nullable
        public final Integer getLanguageId() {
            return this.languageId;
        }

        @Nullable
        public final String getAbbreviate() {
            return this.abbreviate;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final Boolean isDefault() {
            return this.isDefault;
        }

        @Nullable
        public final Integer isAI() {
            return this.isAI;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.databind.RuntimeJsonMappingException */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object getSecurityKey(Continuation<? super String> continuation) throws RuntimeJsonMappingException {
        C00011 c00011;
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
                try {
                    String url = getMainUrl() + "/v0.1/system/getSecurityKey/1?channel=IndiaA&clientType=1&lang=en-US";
                    Requests app = MainActivityKt.getApp();
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url);
                    c00012.label = 1;
                    try {
                        Object obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = obj;
                    } catch (Exception e) {
                        return null;
                    }
                } catch (Exception e2) {
                    return null;
                }
                break;
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                } catch (Exception e3) {
                    return null;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse response = (NiceResponse) $result;
        ObjectMapper $this$readValue$iv = this.mapper;
        String content$iv = response.getText();
        Object $this$checkTypeMismatch$iv$iv = $this$readValue$iv.readValue(content$iv, new TypeReference<SecurityKeyResponse>() { // from class: com.cncverse.CastleTvProvider$getSecurityKey$$inlined$readValue$1
        });
        if (!($this$checkTypeMismatch$iv$iv instanceof SecurityKeyResponse)) {
            throw new RuntimeJsonMappingException("Deserialized value did not match the specified type; specified " + Reflection.getOrCreateKotlinClass(SecurityKeyResponse.class).getQualifiedName() + "(non-null) but was " + ($this$checkTypeMismatch$iv$iv != null ? Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName() : null));
        }
        SecurityKeyResponse securityResponse = (SecurityKeyResponse) $this$checkTypeMismatch$iv$iv;
        if (securityResponse.getCode() == 200) {
            return securityResponse.getData();
        }
        return null;
    }

    private final byte[] deriveKey(String apiKeyB64) {
        byte[] apiKeyBytes = MainAPIKt.base64DecodeArray(apiKeyB64);
        byte[] bytes = this.keySupFixx.getBytes(StandardCharsets.US_ASCII);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] keyMaterial = ArraysKt.plus(apiKeyBytes, bytes);
        if (keyMaterial.length < 16) {
            return ArraysKt.plus(keyMaterial, new byte[16 - keyMaterial.length]);
        }
        return keyMaterial.length > 16 ? ArraysKt.copyOfRange(keyMaterial, 0, 16) : keyMaterial;
    }

    private final String decryptData(String encryptedB64, String apiKeyB64) {
        try {
            byte[] aesKey = deriveKey(apiKeyB64);
            byte[] encryptedData = MainAPIKt.base64DecodeArray(encryptedB64);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(aesKey, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(aesKey);
            cipher.init(2, secretKey, ivSpec);
            byte[] decrypted = cipher.doFinal(encryptedData);
            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return null;
        }
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.databind.RuntimeJsonMappingException */
    /* JADX WARN: Code duplicated, block: B:122:0x031c A[Catch: Exception -> 0x03bc, PHI: r51
      0x031c: PHI (r51v8 'decryptedResponse' com.cncverse.CastleTvProvider$DecryptedResponse) = 
      (r51v7 'decryptedResponse' com.cncverse.CastleTvProvider$DecryptedResponse)
      (r51v10 'decryptedResponse' com.cncverse.CastleTvProvider$DecryptedResponse)
      (r51v10 'decryptedResponse' com.cncverse.CastleTvProvider$DecryptedResponse)
     binds: [B:105:0x02f0, B:109:0x02fa, B:115:0x0307] A[DONT_GENERATE, DONT_INLINE], TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x033c A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:127:0x0341 A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x034a  */
    /* JADX WARN: Code duplicated, block: B:131:0x0360 A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x0373 A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x037d A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x0395  */
    /* JADX WARN: Code duplicated, block: B:143:0x039a A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x03ae A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:171:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x03a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x00c6 A[Catch: Exception -> 0x03c2, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x03c2, blocks: (B:33:0x00ae, B:39:0x00c6), top: B:176:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:43:0x013a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:44:0x013b  */
    /* JADX WARN: Code duplicated, block: B:48:0x015b A[Catch: Exception -> 0x01a8, TryCatch #7 {Exception -> 0x01a8, blocks: (B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:175:0x0142, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0181 A[Catch: Exception -> 0x01a8, TryCatch #7 {Exception -> 0x01a8, blocks: (B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:175:0x0142, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0193  */
    /* JADX WARN: Code duplicated, block: B:54:0x01a2 A[Catch: Exception -> 0x01a8, TRY_LEAVE, TryCatch #7 {Exception -> 0x01a8, blocks: (B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:175:0x0142, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x01c1 A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:66:0x01cd A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01d7 A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x01dd A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x01e7 A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x01fd A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0225 A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0236  */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Code duplicated, block: B:80:0x0245 A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0255 A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x026d A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0281  */
    /* JADX WARN: Code duplicated, block: B:90:0x028b A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x02aa A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x02be  */
    /* JADX WARN: Code duplicated, block: B:96:0x02c3 A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x02cb A[Catch: Exception -> 0x03bc, TryCatch #4 {Exception -> 0x03bc, blocks: (B:45:0x013f, B:58:0x01b7, B:60:0x01c1, B:66:0x01cd, B:68:0x01d7, B:70:0x01dd, B:72:0x01e7, B:74:0x01fd, B:76:0x0225, B:78:0x0237, B:79:0x0244, B:80:0x0245, B:82:0x0255, B:83:0x0267, B:85:0x026d, B:88:0x0283, B:90:0x028b, B:91:0x02a4, B:93:0x02aa, B:127:0x0341, B:96:0x02c3, B:98:0x02cb, B:101:0x02d9, B:121:0x0317, B:123:0x0320, B:118:0x030b, B:120:0x0312, B:113:0x0300, B:122:0x031c, B:108:0x02f5, B:104:0x02e9, B:130:0x0354, B:132:0x0368, B:134:0x0373, B:136:0x037d, B:138:0x0385, B:143:0x039a, B:131:0x0360, B:145:0x03a6, B:147:0x03b4, B:146:0x03ae, B:57:0x01a9, B:46:0x0142, B:48:0x015b, B:50:0x0181, B:52:0x0194, B:53:0x01a1, B:54:0x01a2), top: B:170:0x013f, inners: #7 }] */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws RuntimeJsonMappingException {
        C00001 c00001;
        int page2;
        Object securityKey;
        MainPageRequest request2;
        String securityKey2;
        int i;
        Object obj;
        String securityKey3;
        NiceResponse response;
        CastleApiResponse apiResponse;
        String encryptedData;
        String str;
        boolean z;
        String decryptedJson;
        Object $this$checkTypeMismatch$iv$iv;
        DecryptedResponse decryptedResponse;
        Iterable rows;
        List homePageLists;
        Collection destination$iv$iv;
        String name;
        String rowName;
        Iterable contents;
        DecryptedResponse decryptedResponse2;
        List contents2;
        HomePageList homePageList;
        Collection destination$iv$iv2;
        ContentItem content;
        String title;
        Long redirectId;
        MovieSearchResponse movieSearchResponseNewMovieSearchResponse$default;
        String id;
        TvType type;
        Collection destination$iv$iv3;
        String qualifiedName;
        Object $this$checkTypeMismatch$iv$iv2;
        String qualifiedName2;
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
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast();
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                showTelegramPopup();
                showSubscriptionPopupIfNeeded();
                try {
                    c00002.L$0 = SpillingKt.nullOutSpilledVariable(request);
                    page2 = page;
                    try {
                        c00002.I$0 = page2;
                        c00002.label = 1;
                        securityKey = getSecurityKey(c00002);
                        if (securityKey == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        request2 = request;
                        try {
                            securityKey2 = (String) securityKey;
                            if (securityKey2 == null) {
                                try {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                                } catch (Exception e) {
                                }
                            } else {
                                String url = getMainUrl() + "/film-api/v0.1/category/home?channel=IndiaA&clientType=1&clientType=1&lang=en-US&locationId=1001&mode=1&packageName=com.external.castle&page=" + page2 + "&size=17";
                                Requests app = MainActivityKt.getApp();
                                c00002.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                                c00002.L$1 = securityKey2;
                                c00002.L$2 = SpillingKt.nullOutSpilledVariable(url);
                                c00002.I$0 = page2;
                                c00002.label = 2;
                                i = 2;
                                try {
                                    obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    securityKey3 = securityKey2;
                                    try {
                                        response = (NiceResponse) obj;
                                        try {
                                            ObjectMapper $this$readValue$iv = this.mapper;
                                            String content$iv = response.getText();
                                            $this$checkTypeMismatch$iv$iv2 = $this$readValue$iv.readValue(content$iv, new TypeReference<CastleApiResponse>() { // from class: com.cncverse.CastleTvProvider$getMainPage$$inlined$readValue$1
                                            });
                                            if (!($this$checkTypeMismatch$iv$iv2 instanceof CastleApiResponse)) {
                                                StringBuilder sbAppend = new StringBuilder().append("Deserialized value did not match the specified type; specified ").append(Reflection.getOrCreateKotlinClass(CastleApiResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                                                if ($this$checkTypeMismatch$iv$iv2 != null) {
                                                    qualifiedName2 = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv2.getClass()).getQualifiedName();
                                                } else {
                                                    qualifiedName2 = null;
                                                }
                                                throw new RuntimeJsonMappingException(sbAppend.append(qualifiedName2).toString());
                                            }
                                            apiResponse = (CastleApiResponse) $this$checkTypeMismatch$iv$iv2;
                                            encryptedData = apiResponse.getData();
                                            str = encryptedData;
                                            if (str != null || StringsKt.isBlank(str)) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            if (z) {
                                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, i, (Object) null);
                                            }
                                            decryptedJson = decryptData(encryptedData, securityKey3);
                                            if (decryptedJson == null) {
                                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, i, (Object) null);
                                            }
                                            ObjectMapper $this$readValue$iv2 = this.mapper;
                                            $this$checkTypeMismatch$iv$iv = $this$readValue$iv2.readValue(decryptedJson, new TypeReference<DecryptedResponse>() { // from class: com.cncverse.CastleTvProvider$getMainPage$$inlined$readValue$2
                                            });
                                            if (!($this$checkTypeMismatch$iv$iv instanceof DecryptedResponse)) {
                                                StringBuilder sbAppend2 = new StringBuilder().append("Deserialized value did not match the specified type; specified ").append(Reflection.getOrCreateKotlinClass(DecryptedResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                                                if ($this$checkTypeMismatch$iv$iv != null) {
                                                    qualifiedName = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName();
                                                } else {
                                                    qualifiedName = null;
                                                }
                                                throw new RuntimeJsonMappingException(sbAppend2.append(qualifiedName).toString());
                                            }
                                            decryptedResponse = (DecryptedResponse) $this$checkTypeMismatch$iv$iv;
                                            HomePageData homePageData = decryptedResponse.getData();
                                            rows = homePageData.getRows();
                                            if (rows != null) {
                                                Iterable $this$mapNotNull$iv = rows;
                                                destination$iv$iv = new ArrayList();
                                                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                                    HomePageRow row = (HomePageRow) element$iv$iv$iv;
                                                    name = row.getName();
                                                    if (name == null) {
                                                        name = "Unknown Category";
                                                    }
                                                    rowName = name;
                                                    contents = row.getContents();
                                                    if (contents != null) {
                                                        Iterable $this$mapNotNull$iv2 = contents;
                                                        destination$iv$iv2 = new ArrayList();
                                                        for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
                                                            content = (ContentItem) element$iv$iv$iv2;
                                                            title = content.getTitle();
                                                            if (title == null) {
                                                                decryptedResponse = decryptedResponse;
                                                                movieSearchResponseNewMovieSearchResponse$default = null;
                                                            } else {
                                                                redirectId = content.getRedirectId();
                                                                if (redirectId != null || (id = String.valueOf(redirectId.longValue())) == null) {
                                                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                                                } else {
                                                                    final String coverImg = content.getCoverImage();
                                                                    Integer movieType = content.getMovieType();
                                                                    if (movieType == null) {
                                                                        decryptedResponse = decryptedResponse;
                                                                    } else {
                                                                        decryptedResponse = decryptedResponse;
                                                                        if (movieType.intValue() == 1) {
                                                                            type = TvType.TvSeries;
                                                                        }
                                                                        movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(this, title, id, type, false, new Function1() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda0
                                                                            public final Object invoke(Object obj2) {
                                                                                return CastleTvProvider.getMainPage$lambda$0$0$0(coverImg, (MovieSearchResponse) obj2);
                                                                            }
                                                                        }, 8, (Object) null);
                                                                    }
                                                                    if (movieType != null && movieType.intValue() == 3) {
                                                                        type = TvType.TvSeries;
                                                                    } else if (movieType != null && movieType.intValue() == 5) {
                                                                        type = TvType.TvSeries;
                                                                    } else {
                                                                        type = (movieType != null && movieType.intValue() == 2) ? TvType.Movie : TvType.Movie;
                                                                    }
                                                                    movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(this, title, id, type, false, new Function1() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda0
                                                                        public final Object invoke(Object obj2) {
                                                                            return CastleTvProvider.getMainPage$lambda$0$0$0(coverImg, (MovieSearchResponse) obj2);
                                                                        }
                                                                    }, 8, (Object) null);
                                                                }
                                                            }
                                                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                                                destination$iv$iv3 = destination$iv$iv2;
                                                                destination$iv$iv3.add(movieSearchResponseNewMovieSearchResponse$default);
                                                            } else {
                                                                destination$iv$iv3 = destination$iv$iv2;
                                                            }
                                                            destination$iv$iv2 = destination$iv$iv3;
                                                            decryptedResponse = decryptedResponse;
                                                        }
                                                        decryptedResponse2 = decryptedResponse;
                                                        contents2 = (List) destination$iv$iv2;
                                                    } else {
                                                        decryptedResponse2 = decryptedResponse;
                                                        contents2 = CollectionsKt.emptyList();
                                                    }
                                                    if (contents2.isEmpty()) {
                                                        homePageList = null;
                                                    } else if (!Intrinsics.areEqual(rowName, "Hot Erotic Series") || Intrinsics.areEqual(rowName, "Bollywood Star")) {
                                                        homePageList = null;
                                                    } else {
                                                        homePageList = new HomePageList(rowName, contents2, false, 4, (DefaultConstructorMarker) null);
                                                    }
                                                    if (homePageList != null) {
                                                        destination$iv$iv.add(homePageList);
                                                    }
                                                    decryptedResponse = decryptedResponse2;
                                                }
                                                homePageLists = (List) destination$iv$iv;
                                            } else {
                                                homePageLists = CollectionsKt.emptyList();
                                            }
                                            return MainAPIKt.newHomePageResponse$default(homePageLists, (Boolean) null, 2, (Object) null);
                                        } catch (Exception e2) {
                                            apiResponse = new CastleApiResponse(200, "OK", response.getText());
                                        }
                                    } catch (Exception e3) {
                                    }
                                } catch (Exception e4) {
                                }
                            }
                        } catch (Exception e5) {
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                    } catch (Exception e6) {
                    }
                } catch (Exception e7) {
                    page2 = page;
                }
                break;
            case 1:
                page2 = c00002.I$0;
                MainPageRequest request3 = (MainPageRequest) c00002.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    request2 = request3;
                    securityKey = $result;
                    securityKey2 = (String) securityKey;
                    if (securityKey2 == null) {
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                    }
                    String url2 = getMainUrl() + "/film-api/v0.1/category/home?channel=IndiaA&clientType=1&clientType=1&lang=en-US&locationId=1001&mode=1&packageName=com.external.castle&page=" + page2 + "&size=17";
                    Requests app2 = MainActivityKt.getApp();
                    c00002.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                    c00002.L$1 = securityKey2;
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                    c00002.I$0 = page2;
                    c00002.label = 2;
                    i = 2;
                    obj = Requests.get$default(app2, url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    securityKey3 = securityKey2;
                    response = (NiceResponse) obj;
                    ObjectMapper $this$readValue$iv3 = this.mapper;
                    String content$iv2 = response.getText();
                    $this$checkTypeMismatch$iv$iv2 = $this$readValue$iv3.readValue(content$iv2, new TypeReference<CastleApiResponse>() { // from class: com.cncverse.CastleTvProvider$getMainPage$$inlined$readValue$1
                    });
                    if (!($this$checkTypeMismatch$iv$iv2 instanceof CastleApiResponse)) {
                        StringBuilder sbAppend3 = new StringBuilder().append("Deserialized value did not match the specified type; specified ").append(Reflection.getOrCreateKotlinClass(CastleApiResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                        if ($this$checkTypeMismatch$iv$iv2 != null) {
                            qualifiedName2 = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv2.getClass()).getQualifiedName();
                        } else {
                            qualifiedName2 = null;
                        }
                        throw new RuntimeJsonMappingException(sbAppend3.append(qualifiedName2).toString());
                    }
                    apiResponse = (CastleApiResponse) $this$checkTypeMismatch$iv$iv2;
                    encryptedData = apiResponse.getData();
                    str = encryptedData;
                    if (str != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (z) {
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, i, (Object) null);
                    }
                    decryptedJson = decryptData(encryptedData, securityKey3);
                    if (decryptedJson == null) {
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, i, (Object) null);
                    }
                    ObjectMapper $this$readValue$iv4 = this.mapper;
                    $this$checkTypeMismatch$iv$iv = $this$readValue$iv4.readValue(decryptedJson, new TypeReference<DecryptedResponse>() { // from class: com.cncverse.CastleTvProvider$getMainPage$$inlined$readValue$2
                    });
                    if (!($this$checkTypeMismatch$iv$iv instanceof DecryptedResponse)) {
                        StringBuilder sbAppend4 = new StringBuilder().append("Deserialized value did not match the specified type; specified ").append(Reflection.getOrCreateKotlinClass(DecryptedResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                        if ($this$checkTypeMismatch$iv$iv != null) {
                            qualifiedName = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName();
                        } else {
                            qualifiedName = null;
                        }
                        throw new RuntimeJsonMappingException(sbAppend4.append(qualifiedName).toString());
                    }
                    decryptedResponse = (DecryptedResponse) $this$checkTypeMismatch$iv$iv;
                    HomePageData homePageData2 = decryptedResponse.getData();
                    rows = homePageData2.getRows();
                    if (rows != null) {
                        Iterable $this$mapNotNull$iv3 = rows;
                        destination$iv$iv = new ArrayList();
                        while (r16.hasNext()) {
                            HomePageRow row2 = (HomePageRow) element$iv$iv$iv;
                            name = row2.getName();
                            if (name == null) {
                                name = "Unknown Category";
                            }
                            rowName = name;
                            contents = row2.getContents();
                            if (contents != null) {
                                Iterable $this$mapNotNull$iv4 = contents;
                                destination$iv$iv2 = new ArrayList();
                                while (r35.hasNext()) {
                                    content = (ContentItem) element$iv$iv$iv2;
                                    title = content.getTitle();
                                    if (title == null) {
                                        decryptedResponse = decryptedResponse;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        redirectId = content.getRedirectId();
                                        if (redirectId != null) {
                                        }
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                        destination$iv$iv3 = destination$iv$iv2;
                                        destination$iv$iv3.add(movieSearchResponseNewMovieSearchResponse$default);
                                    } else {
                                        destination$iv$iv3 = destination$iv$iv2;
                                    }
                                    destination$iv$iv2 = destination$iv$iv3;
                                    decryptedResponse = decryptedResponse;
                                }
                                decryptedResponse2 = decryptedResponse;
                                contents2 = (List) destination$iv$iv2;
                            } else {
                                decryptedResponse2 = decryptedResponse;
                                contents2 = CollectionsKt.emptyList();
                            }
                            if (contents2.isEmpty()) {
                                homePageList = null;
                            } else {
                                if (Intrinsics.areEqual(rowName, "Hot Erotic Series")) {
                                }
                                homePageList = null;
                            }
                            if (homePageList != null) {
                                destination$iv$iv.add(homePageList);
                            }
                            decryptedResponse = decryptedResponse2;
                            break;
                        }
                        homePageLists = (List) destination$iv$iv;
                    } else {
                        homePageLists = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(homePageLists, (Boolean) null, 2, (Object) null);
                } catch (Exception e8) {
                }
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
            case 2:
                int i2 = c00002.I$0;
                securityKey3 = (String) c00002.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    i = 2;
                    response = (NiceResponse) obj;
                    ObjectMapper $this$readValue$iv5 = this.mapper;
                    String content$iv3 = response.getText();
                    $this$checkTypeMismatch$iv$iv2 = $this$readValue$iv5.readValue(content$iv3, new TypeReference<CastleApiResponse>() { // from class: com.cncverse.CastleTvProvider$getMainPage$$inlined$readValue$1
                    });
                    if (!($this$checkTypeMismatch$iv$iv2 instanceof CastleApiResponse)) {
                        StringBuilder sbAppend5 = new StringBuilder().append("Deserialized value did not match the specified type; specified ").append(Reflection.getOrCreateKotlinClass(CastleApiResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                        if ($this$checkTypeMismatch$iv$iv2 != null) {
                            qualifiedName2 = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv2.getClass()).getQualifiedName();
                        } else {
                            qualifiedName2 = null;
                        }
                        throw new RuntimeJsonMappingException(sbAppend5.append(qualifiedName2).toString());
                    }
                    apiResponse = (CastleApiResponse) $this$checkTypeMismatch$iv$iv2;
                    encryptedData = apiResponse.getData();
                    str = encryptedData;
                    if (str != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (z) {
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, i, (Object) null);
                    }
                    decryptedJson = decryptData(encryptedData, securityKey3);
                    if (decryptedJson == null) {
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, i, (Object) null);
                    }
                    ObjectMapper $this$readValue$iv6 = this.mapper;
                    $this$checkTypeMismatch$iv$iv = $this$readValue$iv6.readValue(decryptedJson, new TypeReference<DecryptedResponse>() { // from class: com.cncverse.CastleTvProvider$getMainPage$$inlined$readValue$2
                    });
                    if (!($this$checkTypeMismatch$iv$iv instanceof DecryptedResponse)) {
                        StringBuilder sbAppend6 = new StringBuilder().append("Deserialized value did not match the specified type; specified ").append(Reflection.getOrCreateKotlinClass(DecryptedResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                        if ($this$checkTypeMismatch$iv$iv != null) {
                            qualifiedName = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName();
                        } else {
                            qualifiedName = null;
                        }
                        throw new RuntimeJsonMappingException(sbAppend6.append(qualifiedName).toString());
                    }
                    decryptedResponse = (DecryptedResponse) $this$checkTypeMismatch$iv$iv;
                    HomePageData homePageData3 = decryptedResponse.getData();
                    rows = homePageData3.getRows();
                    if (rows != null) {
                        Iterable $this$mapNotNull$iv5 = rows;
                        destination$iv$iv = new ArrayList();
                        while (r16.hasNext()) {
                            HomePageRow row3 = (HomePageRow) element$iv$iv$iv;
                            name = row3.getName();
                            if (name == null) {
                                name = "Unknown Category";
                            }
                            rowName = name;
                            contents = row3.getContents();
                            if (contents != null) {
                                Iterable $this$mapNotNull$iv6 = contents;
                                destination$iv$iv2 = new ArrayList();
                                while (r35.hasNext()) {
                                    content = (ContentItem) element$iv$iv$iv2;
                                    title = content.getTitle();
                                    if (title == null) {
                                        decryptedResponse = decryptedResponse;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        redirectId = content.getRedirectId();
                                        if (redirectId != null) {
                                        }
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                        destination$iv$iv3 = destination$iv$iv2;
                                        destination$iv$iv3.add(movieSearchResponseNewMovieSearchResponse$default);
                                    } else {
                                        destination$iv$iv3 = destination$iv$iv2;
                                    }
                                    destination$iv$iv2 = destination$iv$iv3;
                                    decryptedResponse = decryptedResponse;
                                }
                                decryptedResponse2 = decryptedResponse;
                                contents2 = (List) destination$iv$iv2;
                            } else {
                                decryptedResponse2 = decryptedResponse;
                                contents2 = CollectionsKt.emptyList();
                            }
                            if (contents2.isEmpty()) {
                                homePageList = null;
                            } else {
                                if (Intrinsics.areEqual(rowName, "Hot Erotic Series")) {
                                }
                                homePageList = null;
                            }
                            if (homePageList != null) {
                                destination$iv$iv.add(homePageList);
                            }
                            decryptedResponse = decryptedResponse2;
                            break;
                        }
                        homePageLists = (List) destination$iv$iv;
                    } else {
                        homePageLists = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(homePageLists, (Boolean) null, 2, (Object) null);
                } catch (Exception e9) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$0$0$0(String $coverImg, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($coverImg);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.databind.RuntimeJsonMappingException */
    /* JADX WARN: Code duplicated, block: B:103:0x0243 A[PHI: r36
      0x0243: PHI (r36v5 'searchUrl' java.lang.String) = (r36v4 'searchUrl' java.lang.String), (r36v8 'searchUrl' java.lang.String) binds: [B:86:0x0215, B:90:0x021f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:106:0x0266 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:109:0x026d A[Catch: Exception -> 0x0287, TryCatch #3 {Exception -> 0x0287, blocks: (B:44:0x0115, B:46:0x0120, B:52:0x012c, B:54:0x0131, B:56:0x0137, B:58:0x013c, B:60:0x0152, B:62:0x017b, B:64:0x018e, B:65:0x019b, B:66:0x019c, B:68:0x01ab, B:69:0x01bf, B:71:0x01c5, B:109:0x026d, B:74:0x01e0, B:76:0x01e8, B:79:0x01f8, B:81:0x01fe, B:82:0x0202, B:102:0x023e, B:105:0x0248, B:99:0x0232, B:101:0x0239, B:94:0x0225, B:104:0x0244, B:89:0x021a, B:85:0x020e, B:111:0x0278, B:112:0x0280), top: B:130:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x0280 A[Catch: Exception -> 0x0287, TRY_LEAVE, TryCatch #3 {Exception -> 0x0287, blocks: (B:44:0x0115, B:46:0x0120, B:52:0x012c, B:54:0x0131, B:56:0x0137, B:58:0x013c, B:60:0x0152, B:62:0x017b, B:64:0x018e, B:65:0x019b, B:66:0x019c, B:68:0x01ab, B:69:0x01bf, B:71:0x01c5, B:109:0x026d, B:74:0x01e0, B:76:0x01e8, B:79:0x01f8, B:81:0x01fe, B:82:0x0202, B:102:0x023e, B:105:0x0248, B:99:0x0232, B:101:0x0239, B:94:0x0225, B:104:0x0244, B:89:0x021a, B:85:0x020e, B:111:0x0278, B:112:0x0280), top: B:130:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x0271 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x009a A[Catch: Exception -> 0x0057, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x0057, blocks: (B:13:0x0042, B:16:0x0052, B:36:0x009a), top: B:131:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:38:0x009f A[Catch: Exception -> 0x028d, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x028d, blocks: (B:34:0x0096, B:38:0x009f), top: B:124:0x0096 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x010e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x010f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0120 A[Catch: Exception -> 0x0287, TryCatch #3 {Exception -> 0x0287, blocks: (B:44:0x0115, B:46:0x0120, B:52:0x012c, B:54:0x0131, B:56:0x0137, B:58:0x013c, B:60:0x0152, B:62:0x017b, B:64:0x018e, B:65:0x019b, B:66:0x019c, B:68:0x01ab, B:69:0x01bf, B:71:0x01c5, B:109:0x026d, B:74:0x01e0, B:76:0x01e8, B:79:0x01f8, B:81:0x01fe, B:82:0x0202, B:102:0x023e, B:105:0x0248, B:99:0x0232, B:101:0x0239, B:94:0x0225, B:104:0x0244, B:89:0x021a, B:85:0x020e, B:111:0x0278, B:112:0x0280), top: B:130:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0129  */
    /* JADX WARN: Code duplicated, block: B:52:0x012c A[Catch: Exception -> 0x0287, TryCatch #3 {Exception -> 0x0287, blocks: (B:44:0x0115, B:46:0x0120, B:52:0x012c, B:54:0x0131, B:56:0x0137, B:58:0x013c, B:60:0x0152, B:62:0x017b, B:64:0x018e, B:65:0x019b, B:66:0x019c, B:68:0x01ab, B:69:0x01bf, B:71:0x01c5, B:109:0x026d, B:74:0x01e0, B:76:0x01e8, B:79:0x01f8, B:81:0x01fe, B:82:0x0202, B:102:0x023e, B:105:0x0248, B:99:0x0232, B:101:0x0239, B:94:0x0225, B:104:0x0244, B:89:0x021a, B:85:0x020e, B:111:0x0278, B:112:0x0280), top: B:130:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0131 A[Catch: Exception -> 0x0287, TryCatch #3 {Exception -> 0x0287, blocks: (B:44:0x0115, B:46:0x0120, B:52:0x012c, B:54:0x0131, B:56:0x0137, B:58:0x013c, B:60:0x0152, B:62:0x017b, B:64:0x018e, B:65:0x019b, B:66:0x019c, B:68:0x01ab, B:69:0x01bf, B:71:0x01c5, B:109:0x026d, B:74:0x01e0, B:76:0x01e8, B:79:0x01f8, B:81:0x01fe, B:82:0x0202, B:102:0x023e, B:105:0x0248, B:99:0x0232, B:101:0x0239, B:94:0x0225, B:104:0x0244, B:89:0x021a, B:85:0x020e, B:111:0x0278, B:112:0x0280), top: B:130:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0137 A[Catch: Exception -> 0x0287, TryCatch #3 {Exception -> 0x0287, blocks: (B:44:0x0115, B:46:0x0120, B:52:0x012c, B:54:0x0131, B:56:0x0137, B:58:0x013c, B:60:0x0152, B:62:0x017b, B:64:0x018e, B:65:0x019b, B:66:0x019c, B:68:0x01ab, B:69:0x01bf, B:71:0x01c5, B:109:0x026d, B:74:0x01e0, B:76:0x01e8, B:79:0x01f8, B:81:0x01fe, B:82:0x0202, B:102:0x023e, B:105:0x0248, B:99:0x0232, B:101:0x0239, B:94:0x0225, B:104:0x0244, B:89:0x021a, B:85:0x020e, B:111:0x0278, B:112:0x0280), top: B:130:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x013c A[Catch: Exception -> 0x0287, TryCatch #3 {Exception -> 0x0287, blocks: (B:44:0x0115, B:46:0x0120, B:52:0x012c, B:54:0x0131, B:56:0x0137, B:58:0x013c, B:60:0x0152, B:62:0x017b, B:64:0x018e, B:65:0x019b, B:66:0x019c, B:68:0x01ab, B:69:0x01bf, B:71:0x01c5, B:109:0x026d, B:74:0x01e0, B:76:0x01e8, B:79:0x01f8, B:81:0x01fe, B:82:0x0202, B:102:0x023e, B:105:0x0248, B:99:0x0232, B:101:0x0239, B:94:0x0225, B:104:0x0244, B:89:0x021a, B:85:0x020e, B:111:0x0278, B:112:0x0280), top: B:130:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0152 A[Catch: Exception -> 0x0287, TryCatch #3 {Exception -> 0x0287, blocks: (B:44:0x0115, B:46:0x0120, B:52:0x012c, B:54:0x0131, B:56:0x0137, B:58:0x013c, B:60:0x0152, B:62:0x017b, B:64:0x018e, B:65:0x019b, B:66:0x019c, B:68:0x01ab, B:69:0x01bf, B:71:0x01c5, B:109:0x026d, B:74:0x01e0, B:76:0x01e8, B:79:0x01f8, B:81:0x01fe, B:82:0x0202, B:102:0x023e, B:105:0x0248, B:99:0x0232, B:101:0x0239, B:94:0x0225, B:104:0x0244, B:89:0x021a, B:85:0x020e, B:111:0x0278, B:112:0x0280), top: B:130:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x017b A[Catch: Exception -> 0x0287, TryCatch #3 {Exception -> 0x0287, blocks: (B:44:0x0115, B:46:0x0120, B:52:0x012c, B:54:0x0131, B:56:0x0137, B:58:0x013c, B:60:0x0152, B:62:0x017b, B:64:0x018e, B:65:0x019b, B:66:0x019c, B:68:0x01ab, B:69:0x01bf, B:71:0x01c5, B:109:0x026d, B:74:0x01e0, B:76:0x01e8, B:79:0x01f8, B:81:0x01fe, B:82:0x0202, B:102:0x023e, B:105:0x0248, B:99:0x0232, B:101:0x0239, B:94:0x0225, B:104:0x0244, B:89:0x021a, B:85:0x020e, B:111:0x0278, B:112:0x0280), top: B:130:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x018d  */
    /* JADX WARN: Code duplicated, block: B:66:0x019c A[Catch: Exception -> 0x0287, TryCatch #3 {Exception -> 0x0287, blocks: (B:44:0x0115, B:46:0x0120, B:52:0x012c, B:54:0x0131, B:56:0x0137, B:58:0x013c, B:60:0x0152, B:62:0x017b, B:64:0x018e, B:65:0x019b, B:66:0x019c, B:68:0x01ab, B:69:0x01bf, B:71:0x01c5, B:109:0x026d, B:74:0x01e0, B:76:0x01e8, B:79:0x01f8, B:81:0x01fe, B:82:0x0202, B:102:0x023e, B:105:0x0248, B:99:0x0232, B:101:0x0239, B:94:0x0225, B:104:0x0244, B:89:0x021a, B:85:0x020e, B:111:0x0278, B:112:0x0280), top: B:130:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01ab A[Catch: Exception -> 0x0287, TryCatch #3 {Exception -> 0x0287, blocks: (B:44:0x0115, B:46:0x0120, B:52:0x012c, B:54:0x0131, B:56:0x0137, B:58:0x013c, B:60:0x0152, B:62:0x017b, B:64:0x018e, B:65:0x019b, B:66:0x019c, B:68:0x01ab, B:69:0x01bf, B:71:0x01c5, B:109:0x026d, B:74:0x01e0, B:76:0x01e8, B:79:0x01f8, B:81:0x01fe, B:82:0x0202, B:102:0x023e, B:105:0x0248, B:99:0x0232, B:101:0x0239, B:94:0x0225, B:104:0x0244, B:89:0x021a, B:85:0x020e, B:111:0x0278, B:112:0x0280), top: B:130:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x01c5 A[Catch: Exception -> 0x0287, TryCatch #3 {Exception -> 0x0287, blocks: (B:44:0x0115, B:46:0x0120, B:52:0x012c, B:54:0x0131, B:56:0x0137, B:58:0x013c, B:60:0x0152, B:62:0x017b, B:64:0x018e, B:65:0x019b, B:66:0x019c, B:68:0x01ab, B:69:0x01bf, B:71:0x01c5, B:109:0x026d, B:74:0x01e0, B:76:0x01e8, B:79:0x01f8, B:81:0x01fe, B:82:0x0202, B:102:0x023e, B:105:0x0248, B:99:0x0232, B:101:0x0239, B:94:0x0225, B:104:0x0244, B:89:0x021a, B:85:0x020e, B:111:0x0278, B:112:0x0280), top: B:130:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01db  */
    /* JADX WARN: Code duplicated, block: B:74:0x01e0 A[Catch: Exception -> 0x0287, TryCatch #3 {Exception -> 0x0287, blocks: (B:44:0x0115, B:46:0x0120, B:52:0x012c, B:54:0x0131, B:56:0x0137, B:58:0x013c, B:60:0x0152, B:62:0x017b, B:64:0x018e, B:65:0x019b, B:66:0x019c, B:68:0x01ab, B:69:0x01bf, B:71:0x01c5, B:109:0x026d, B:74:0x01e0, B:76:0x01e8, B:79:0x01f8, B:81:0x01fe, B:82:0x0202, B:102:0x023e, B:105:0x0248, B:99:0x0232, B:101:0x0239, B:94:0x0225, B:104:0x0244, B:89:0x021a, B:85:0x020e, B:111:0x0278, B:112:0x0280), top: B:130:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x01e8 A[Catch: Exception -> 0x0287, TryCatch #3 {Exception -> 0x0287, blocks: (B:44:0x0115, B:46:0x0120, B:52:0x012c, B:54:0x0131, B:56:0x0137, B:58:0x013c, B:60:0x0152, B:62:0x017b, B:64:0x018e, B:65:0x019b, B:66:0x019c, B:68:0x01ab, B:69:0x01bf, B:71:0x01c5, B:109:0x026d, B:74:0x01e0, B:76:0x01e8, B:79:0x01f8, B:81:0x01fe, B:82:0x0202, B:102:0x023e, B:105:0x0248, B:99:0x0232, B:101:0x0239, B:94:0x0225, B:104:0x0244, B:89:0x021a, B:85:0x020e, B:111:0x0278, B:112:0x0280), top: B:130:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws RuntimeJsonMappingException {
        C00081 c00081;
        Object securityKey;
        String securityKey2;
        String searchUrl;
        Object obj;
        String searchUrl2;
        String securityKey3;
        String encryptedData;
        String str;
        boolean z;
        String decryptedJson;
        Object $this$checkTypeMismatch$iv$iv;
        Iterable rows;
        Collection destination$iv$iv;
        final SearchResultItem item;
        String title;
        Long id;
        MovieSearchResponse movieSearchResponseNewMovieSearchResponse$default;
        String id2;
        TvType type;
        String qualifiedName;
        CastleTvProvider castleTvProvider = this;
        String query2 = query;
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
            } else {
                c00081 = castleTvProvider.new C00081(continuation);
            }
        } else {
            c00081 = castleTvProvider.new C00081(continuation);
        }
        C00081 c00082 = c00081;
        Object $result = c00082.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00082.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (INSTANCE.isCsGuardBlocked()) {
                        INSTANCE.showCsGuardToast();
                        return CollectionsKt.emptyList();
                    }
                    try {
                        if (StringsKt.isBlank(query2)) {
                            try {
                                return CollectionsKt.emptyList();
                            } catch (Exception e) {
                            }
                        } else {
                            c00082.L$0 = query2;
                            c00082.label = 1;
                            securityKey = castleTvProvider.getSecurityKey(c00082);
                            if (securityKey == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            try {
                                securityKey2 = (String) securityKey;
                                if (securityKey2 == null) {
                                    return CollectionsKt.emptyList();
                                }
                                searchUrl = castleTvProvider.getMainUrl() + "/film-api/v1.1.0/movie/searchByKeyword?channel=IndiaA&clientType=1&clientType=1&keyword=" + URLEncoder.encode(query2, "UTF-8") + "&lang=en-US&mode=1&packageName=com.external.castle&page=1&size=30";
                                Requests app = MainActivityKt.getApp();
                                c00082.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                                c00082.L$1 = securityKey2;
                                c00082.L$2 = SpillingKt.nullOutSpilledVariable(searchUrl);
                                c00082.label = 2;
                                try {
                                    obj = Requests.get$default(app, searchUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 4094, (Object) null);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    searchUrl2 = searchUrl;
                                    securityKey3 = securityKey2;
                                    $result = obj;
                                    try {
                                        NiceResponse response = (NiceResponse) $result;
                                        encryptedData = response.getText();
                                        str = encryptedData;
                                        if (str != null || StringsKt.isBlank(str)) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            return CollectionsKt.emptyList();
                                        }
                                        decryptedJson = castleTvProvider.decryptData(encryptedData, securityKey3);
                                        if (decryptedJson == null) {
                                            return CollectionsKt.emptyList();
                                        }
                                        ObjectMapper $this$readValue$iv = castleTvProvider.mapper;
                                        $this$checkTypeMismatch$iv$iv = $this$readValue$iv.readValue(decryptedJson, new TypeReference<SearchApiResponse>() { // from class: com.cncverse.CastleTvProvider$search$$inlined$readValue$1
                                        });
                                        if (!($this$checkTypeMismatch$iv$iv instanceof SearchApiResponse)) {
                                            StringBuilder sbAppend = new StringBuilder().append("Deserialized value did not match the specified type; specified ").append(Reflection.getOrCreateKotlinClass(SearchApiResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                                            if ($this$checkTypeMismatch$iv$iv != null) {
                                                qualifiedName = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName();
                                            } else {
                                                qualifiedName = null;
                                            }
                                            throw new RuntimeJsonMappingException(sbAppend.append(qualifiedName).toString());
                                        }
                                        SearchApiResponse searchResponse = (SearchApiResponse) $this$checkTypeMismatch$iv$iv;
                                        SearchData searchData = searchResponse.getData();
                                        rows = searchData.getRows();
                                        if (rows == null) {
                                            return CollectionsKt.emptyList();
                                        }
                                        Iterable $this$mapNotNull$iv = rows;
                                        destination$iv$iv = new ArrayList();
                                        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                            item = (SearchResultItem) element$iv$iv$iv;
                                            title = item.getTitle();
                                            if (title == null) {
                                                searchUrl2 = searchUrl2;
                                                movieSearchResponseNewMovieSearchResponse$default = null;
                                            } else {
                                                id = item.getId();
                                                if (id != null || (id2 = String.valueOf(id.longValue())) == null) {
                                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                                } else {
                                                    String coverVerticalImage = item.getCoverVerticalImage();
                                                    if (coverVerticalImage == null) {
                                                        coverVerticalImage = item.getCoverHorizontalImage();
                                                    }
                                                    final String posterUrl = coverVerticalImage;
                                                    Integer movieType = item.getMovieType();
                                                    if (movieType == null) {
                                                        searchUrl2 = searchUrl2;
                                                    } else {
                                                        searchUrl2 = searchUrl2;
                                                        if (movieType.intValue() == 1) {
                                                            type = TvType.TvSeries;
                                                        }
                                                        movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(castleTvProvider, title, id2, type, false, new Function1() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda5
                                                            public final Object invoke(Object obj2) {
                                                                return CastleTvProvider.search$lambda$0$0(posterUrl, item, (MovieSearchResponse) obj2);
                                                            }
                                                        }, 8, (Object) null);
                                                    }
                                                    if (movieType == null || movieType.intValue() != 3) {
                                                        if (movieType == null || movieType.intValue() != 5) {
                                                            type = (movieType != null && movieType.intValue() == 2) ? TvType.Movie : TvType.Movie;
                                                        }
                                                        movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(castleTvProvider, title, id2, type, false, new Function1() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda5
                                                            public final Object invoke(Object obj2) {
                                                                return CastleTvProvider.search$lambda$0$0(posterUrl, item, (MovieSearchResponse) obj2);
                                                            }
                                                        }, 8, (Object) null);
                                                    }
                                                    type = TvType.TvSeries;
                                                    movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(castleTvProvider, title, id2, type, false, new Function1() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda5
                                                        public final Object invoke(Object obj2) {
                                                            return CastleTvProvider.search$lambda$0$0(posterUrl, item, (MovieSearchResponse) obj2);
                                                        }
                                                    }, 8, (Object) null);
                                                }
                                            }
                                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                                destination$iv$iv.add(movieSearchResponseNewMovieSearchResponse$default);
                                            }
                                            castleTvProvider = this;
                                            searchUrl2 = searchUrl2;
                                        }
                                        return (List) destination$iv$iv;
                                    } catch (Exception e2) {
                                    }
                                } catch (Exception e3) {
                                }
                            } catch (Exception e4) {
                            }
                        }
                    } catch (Exception e5) {
                    }
                    return CollectionsKt.emptyList();
                case 1:
                    query2 = (String) c00082.L$0;
                    ResultKt.throwOnFailure($result);
                    securityKey = $result;
                    securityKey2 = (String) securityKey;
                    if (securityKey2 == null) {
                        return CollectionsKt.emptyList();
                    }
                    searchUrl = castleTvProvider.getMainUrl() + "/film-api/v1.1.0/movie/searchByKeyword?channel=IndiaA&clientType=1&clientType=1&keyword=" + URLEncoder.encode(query2, "UTF-8") + "&lang=en-US&mode=1&packageName=com.external.castle&page=1&size=30";
                    Requests app2 = MainActivityKt.getApp();
                    c00082.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                    c00082.L$1 = securityKey2;
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(searchUrl);
                    c00082.label = 2;
                    obj = Requests.get$default(app2, searchUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 4094, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    searchUrl2 = searchUrl;
                    securityKey3 = securityKey2;
                    $result = obj;
                    NiceResponse response2 = (NiceResponse) $result;
                    encryptedData = response2.getText();
                    str = encryptedData;
                    if (str != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (z) {
                        return CollectionsKt.emptyList();
                    }
                    decryptedJson = castleTvProvider.decryptData(encryptedData, securityKey3);
                    if (decryptedJson == null) {
                        return CollectionsKt.emptyList();
                    }
                    ObjectMapper $this$readValue$iv2 = castleTvProvider.mapper;
                    $this$checkTypeMismatch$iv$iv = $this$readValue$iv2.readValue(decryptedJson, new TypeReference<SearchApiResponse>() { // from class: com.cncverse.CastleTvProvider$search$$inlined$readValue$1
                    });
                    if (!($this$checkTypeMismatch$iv$iv instanceof SearchApiResponse)) {
                        StringBuilder sbAppend2 = new StringBuilder().append("Deserialized value did not match the specified type; specified ").append(Reflection.getOrCreateKotlinClass(SearchApiResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                        if ($this$checkTypeMismatch$iv$iv != null) {
                            qualifiedName = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName();
                        } else {
                            qualifiedName = null;
                        }
                        throw new RuntimeJsonMappingException(sbAppend2.append(qualifiedName).toString());
                    }
                    SearchApiResponse searchResponse2 = (SearchApiResponse) $this$checkTypeMismatch$iv$iv;
                    SearchData searchData2 = searchResponse2.getData();
                    rows = searchData2.getRows();
                    if (rows == null) {
                        return CollectionsKt.emptyList();
                    }
                    Iterable $this$mapNotNull$iv2 = rows;
                    destination$iv$iv = new ArrayList();
                    while (r19.hasNext()) {
                        item = (SearchResultItem) element$iv$iv$iv;
                        title = item.getTitle();
                        if (title == null) {
                            searchUrl2 = searchUrl2;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            id = item.getId();
                            if (id != null) {
                            }
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv.add(movieSearchResponseNewMovieSearchResponse$default);
                        }
                        castleTvProvider = this;
                        searchUrl2 = searchUrl2;
                    }
                    return (List) destination$iv$iv;
                    return CollectionsKt.emptyList();
                case 2:
                    searchUrl2 = (String) c00082.L$2;
                    securityKey3 = (String) c00082.L$1;
                    ResultKt.throwOnFailure($result);
                    NiceResponse response3 = (NiceResponse) $result;
                    encryptedData = response3.getText();
                    str = encryptedData;
                    if (str != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (z) {
                        return CollectionsKt.emptyList();
                    }
                    decryptedJson = castleTvProvider.decryptData(encryptedData, securityKey3);
                    if (decryptedJson == null) {
                        return CollectionsKt.emptyList();
                    }
                    ObjectMapper $this$readValue$iv3 = castleTvProvider.mapper;
                    $this$checkTypeMismatch$iv$iv = $this$readValue$iv3.readValue(decryptedJson, new TypeReference<SearchApiResponse>() { // from class: com.cncverse.CastleTvProvider$search$$inlined$readValue$1
                    });
                    if (!($this$checkTypeMismatch$iv$iv instanceof SearchApiResponse)) {
                        StringBuilder sbAppend3 = new StringBuilder().append("Deserialized value did not match the specified type; specified ").append(Reflection.getOrCreateKotlinClass(SearchApiResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                        if ($this$checkTypeMismatch$iv$iv != null) {
                            qualifiedName = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName();
                        } else {
                            qualifiedName = null;
                        }
                        throw new RuntimeJsonMappingException(sbAppend3.append(qualifiedName).toString());
                    }
                    SearchApiResponse searchResponse3 = (SearchApiResponse) $this$checkTypeMismatch$iv$iv;
                    SearchData searchData3 = searchResponse3.getData();
                    rows = searchData3.getRows();
                    if (rows == null) {
                        return CollectionsKt.emptyList();
                    }
                    Iterable $this$mapNotNull$iv3 = rows;
                    destination$iv$iv = new ArrayList();
                    while (r19.hasNext()) {
                        item = (SearchResultItem) element$iv$iv$iv;
                        title = item.getTitle();
                        if (title == null) {
                            searchUrl2 = searchUrl2;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            id = item.getId();
                            if (id != null) {
                            }
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv.add(movieSearchResponseNewMovieSearchResponse$default);
                        }
                        castleTvProvider = this;
                        searchUrl2 = searchUrl2;
                    }
                    return (List) destination$iv$iv;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e6) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(String $posterUrl, SearchResultItem $item, MovieSearchResponse $this$newMovieSearchResponse) {
        Integer numValueOf;
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        Long publishTime = $item.getPublishTime();
        if (publishTime != null) {
            long timestamp = publishTime.longValue();
            numValueOf = Integer.valueOf(Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).getYear());
        } else {
            numValueOf = null;
        }
        $this$newMovieSearchResponse.setYear(numValueOf);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.databind.RuntimeJsonMappingException */
    /* JADX WARN: Can't wrap try/catch for region: R(10:203|204|400|205|206|404|207|(15:209|398|210|211|402|212|213|431|214|215|367|216|(1:218)(1:219)|220|221)(4:230|412|231|(4:233|(9:236|237|395|238|239|375|240|458|234)|457|243)(1:247))|286|456) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:209|398|210|211|402|212|213|431|214|215|367|216|(1:218)(1:219)|220|221) */
    /* JADX WARN: Can't wrap try/catch for region: R(37:451|163|164|426|165|166|443|167|168|435|169|170|416|171|172|441|173|174|418|175|176|393|177|178|373|179|180|439|181|182|377|183|184|414|185|186|(1:188)(8:189|383|190|(6:408|192|(0)(1:195)|(1:256)(10:203|204|400|205|206|404|207|(15:209|398|210|211|402|212|213|431|214|215|367|216|(1:218)(1:219)|220|221)(4:230|412|231|(4:233|(9:236|237|395|238|239|375|240|458|234)|457|243)(1:247))|286|456)|258|456)|198|(3:200|201|256)(1:257)|258|456)) */
    /* JADX WARN: Can't wrap try/catch for region: R(4:230|412|231|(4:233|(9:236|237|395|238|239|375|240|458|234)|457|243)(1:247)) */
    /* JADX WARN: Can't wrap try/catch for region: R(6:408|192|(0)(1:195)|(1:256)(10:203|204|400|205|206|404|207|(15:209|398|210|211|402|212|213|431|214|215|367|216|(1:218)(1:219)|220|221)(4:230|412|231|(4:233|(9:236|237|395|238|239|375|240|458|234)|457|243)(1:247))|286|456)|258|456) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:189|383|190|(6:408|192|(0)(1:195)|(1:256)(10:203|204|400|205|206|404|207|(15:209|398|210|211|402|212|213|431|214|215|367|216|(1:218)(1:219)|220|221)(4:230|412|231|(4:233|(9:236|237|395|238|239|375|240|458|234)|457|243)(1:247))|286|456)|258|456)|198|(3:200|201|256)(1:257)|258|456) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:236|237|395|238|239|375|240|458|234) */
    /* JADX WARN: Code duplicated, block: B:103:0x0404  */
    /* JADX WARN: Code duplicated, block: B:106:0x0411 A[Catch: Exception -> 0x03f0, TRY_ENTER, TryCatch #0 {Exception -> 0x03f0, blocks: (B:97:0x03e9, B:106:0x0411, B:107:0x0427, B:109:0x042d, B:112:0x0445, B:113:0x046e, B:124:0x0491, B:130:0x04a0, B:136:0x04ae, B:138:0x04b4, B:133:0x04a7, B:127:0x0498), top: B:365:0x03e9 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x042d A[Catch: Exception -> 0x03f0, TryCatch #0 {Exception -> 0x03f0, blocks: (B:97:0x03e9, B:106:0x0411, B:107:0x0427, B:109:0x042d, B:112:0x0445, B:113:0x046e, B:124:0x0491, B:130:0x04a0, B:136:0x04ae, B:138:0x04b4, B:133:0x04a7, B:127:0x0498), top: B:365:0x03e9 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x0443  */
    /* JADX WARN: Code duplicated, block: B:115:0x047a  */
    /* JADX WARN: Code duplicated, block: B:119:0x0488  */
    /* JADX WARN: Code duplicated, block: B:120:0x0489 A[Catch: Exception -> 0x0cdf, TRY_LEAVE, TryCatch #11 {Exception -> 0x0cdf, blocks: (B:104:0x0407, B:117:0x047d, B:320:0x0bd7, B:328:0x0bf3, B:333:0x0c17, B:120:0x0489), top: B:387:0x0407 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:150:0x04d2 A[Catch: Exception -> 0x0be6, TRY_ENTER, TryCatch #16 {Exception -> 0x0be6, blocks: (B:150:0x04d2, B:152:0x04dd, B:299:0x0a68, B:300:0x0a70, B:302:0x0a76, B:304:0x0a7e, B:305:0x0a81, B:306:0x0acd, B:322:0x0bdd, B:330:0x0c10), top: B:397:0x04c3 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x051b A[Catch: Exception -> 0x0a58, TryCatch #28 {Exception -> 0x0a58, blocks: (B:154:0x0515, B:156:0x051b, B:158:0x0529, B:161:0x0547, B:163:0x054f), top: B:420:0x0515 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x0529 A[Catch: Exception -> 0x0a58, TryCatch #28 {Exception -> 0x0a58, blocks: (B:154:0x0515, B:156:0x051b, B:158:0x0529, B:161:0x0547, B:163:0x054f), top: B:420:0x0515 }] */
    /* JADX WARN: Code duplicated, block: B:195:0x064b  */
    /* JADX WARN: Code duplicated, block: B:200:0x0667  */
    /* JADX WARN: Code duplicated, block: B:257:0x0801 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:288:0x09f2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:299:0x0a68 A[Catch: Exception -> 0x0be6, TRY_ENTER, TryCatch #16 {Exception -> 0x0be6, blocks: (B:150:0x04d2, B:152:0x04dd, B:299:0x0a68, B:300:0x0a70, B:302:0x0a76, B:304:0x0a7e, B:305:0x0a81, B:306:0x0acd, B:322:0x0bdd, B:330:0x0c10), top: B:397:0x04c3 }] */
    /* JADX WARN: Code duplicated, block: B:302:0x0a76 A[Catch: Exception -> 0x0be6, TryCatch #16 {Exception -> 0x0be6, blocks: (B:150:0x04d2, B:152:0x04dd, B:299:0x0a68, B:300:0x0a70, B:302:0x0a76, B:304:0x0a7e, B:305:0x0a81, B:306:0x0acd, B:322:0x0bdd, B:330:0x0c10), top: B:397:0x04c3 }] */
    /* JADX WARN: Code duplicated, block: B:304:0x0a7e A[Catch: Exception -> 0x0be6, TryCatch #16 {Exception -> 0x0be6, blocks: (B:150:0x04d2, B:152:0x04dd, B:299:0x0a68, B:300:0x0a70, B:302:0x0a76, B:304:0x0a7e, B:305:0x0a81, B:306:0x0acd, B:322:0x0bdd, B:330:0x0c10), top: B:397:0x04c3 }] */
    /* JADX WARN: Code duplicated, block: B:310:0x0b90 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:311:0x0b91  */
    /* JADX WARN: Code duplicated, block: B:320:0x0bd7 A[Catch: Exception -> 0x0cdf, TRY_ENTER, TRY_LEAVE, TryCatch #11 {Exception -> 0x0cdf, blocks: (B:104:0x0407, B:117:0x047d, B:320:0x0bd7, B:328:0x0bf3, B:333:0x0c17, B:120:0x0489), top: B:387:0x0407 }] */
    /* JADX WARN: Code duplicated, block: B:322:0x0bdd A[Catch: Exception -> 0x0be6, TRY_ENTER, TRY_LEAVE, TryCatch #16 {Exception -> 0x0be6, blocks: (B:150:0x04d2, B:152:0x04dd, B:299:0x0a68, B:300:0x0a70, B:302:0x0a76, B:304:0x0a7e, B:305:0x0a81, B:306:0x0acd, B:322:0x0bdd, B:330:0x0c10), top: B:397:0x04c3 }] */
    /* JADX WARN: Code duplicated, block: B:326:0x0bf0  */
    /* JADX WARN: Code duplicated, block: B:330:0x0c10 A[Catch: Exception -> 0x0be6, TRY_ENTER, TRY_LEAVE, TryCatch #16 {Exception -> 0x0be6, blocks: (B:150:0x04d2, B:152:0x04dd, B:299:0x0a68, B:300:0x0a70, B:302:0x0a76, B:304:0x0a7e, B:305:0x0a81, B:306:0x0acd, B:322:0x0bdd, B:330:0x0c10), top: B:397:0x04c3 }] */
    /* JADX WARN: Code duplicated, block: B:332:0x0c15  */
    /* JADX WARN: Code duplicated, block: B:338:0x0cab A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:339:0x0cac  */
    /* JADX WARN: Code duplicated, block: B:38:0x0266 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:408:0x0644 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0269  */
    /* JADX WARN: Code duplicated, block: B:410:0x04c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:433:0x02f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:437:0x03de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:445:0x0394 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:452:0x0a18 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:461:0x0445 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:464:0x0a81 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x02df A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:55:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:60:0x0307 A[ADDED_TO_REGION, REMOVE, RETURN] */
    /* JADX WARN: Code duplicated, block: B:61:0x0308 A[Catch: Exception -> 0x0ceb, TRY_ENTER, TryCatch #3 {Exception -> 0x0ceb, blocks: (B:50:0x02e5, B:61:0x0308, B:64:0x0310, B:74:0x0375, B:80:0x038e, B:84:0x039a, B:88:0x03a6, B:93:0x03d8, B:335:0x0ca3), top: B:371:0x02e5 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0328  */
    /* JADX WARN: Code duplicated, block: B:69:0x0350 A[Catch: Exception -> 0x02fb, TryCatch #35 {Exception -> 0x02fb, blocks: (B:52:0x02f2, B:67:0x032b, B:69:0x0350, B:71:0x0364, B:72:0x0371), top: B:433:0x02f2 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0362  */
    /* JADX WARN: Code duplicated, block: B:73:0x0372  */
    /* JADX WARN: Code duplicated, block: B:76:0x0382  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:86:0x03a0 A[Catch: Exception -> 0x0385, TRY_ENTER, TRY_LEAVE, TryCatch #41 {Exception -> 0x0385, blocks: (B:82:0x0394, B:86:0x03a0, B:90:0x03b0), top: B:445:0x0394 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x03b0 A[Catch: Exception -> 0x0385, TRY_ENTER, TRY_LEAVE, TryCatch #41 {Exception -> 0x0385, blocks: (B:82:0x0394, B:86:0x03a0, B:90:0x03b0), top: B:445:0x0394 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x03d2  */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x064f, code lost:
    
        r45 = r1;
        r43 = r2;
        r50 = r3;
        r48 = r20;
        r51 = r26;
        r1 = r31;
        r3 = r32;
        r5 = r33;
        r2 = r61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x06f1, code lost:
    
        r51 = r2;
        r50 = r3;
        r1 = r31;
        r3 = r32;
        r5 = r33;
        r2 = r61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0700, code lost:
    
        r51 = r26;
        r50 = r3;
        r1 = r31;
        r3 = r32;
        r5 = r33;
        r2 = r61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0711, code lost:
    
        r48 = r2;
        r51 = r26;
        r50 = r3;
        r1 = r31;
        r3 = r32;
        r5 = r33;
        r2 = r61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0724, code lost:
    
        r48 = r20;
        r51 = r26;
        r50 = r3;
        r1 = r31;
        r3 = r32;
        r5 = r33;
        r2 = r61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x07a8, code lost:
    
        r51 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x07b7, code lost:
    
        r2 = r61;
        r1 = r31;
        r3 = r32;
        r5 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x07cb, code lost:
    
        r51 = r2;
        r50 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x07d1, code lost:
    
        r50 = r3;
        r48 = r20;
        r51 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x07d7, code lost:
    
        r2 = r61;
        r1 = r31;
        r3 = r32;
        r5 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x07e2, code lost:
    
        r43 = r2;
        r50 = r3;
        r48 = r20;
        r51 = r26;
        r2 = r61;
        r1 = r31;
        r3 = r32;
        r5 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0836, code lost:
    
        r45 = r1;
        r43 = r2;
        r50 = r3;
        r48 = r20;
        r51 = r26;
        r2 = r61;
        r1 = r31;
        r3 = r32;
        r5 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x084b, code lost:
    
        r48 = r20;
        r51 = r26;
        r50 = r61;
        r45 = r15;
        r43 = r18;
        r15 = r27;
        r1 = r28;
        r28 = r7;
        r27 = r13;
        r18 = r1;
        r24 = r8;
        r17 = r16;
        r13 = r12;
        r10 = r57;
        r8 = r6;
        r6 = r4;
        r4 = r62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x087a, code lost:
    
        r48 = r20;
        r51 = r26;
        r50 = r61;
        r45 = r15;
        r43 = r18;
        r15 = r27;
        r1 = r28;
        r28 = r7;
        r27 = r13;
        r18 = r1;
        r24 = r8;
        r17 = r16;
        r13 = r12;
        r10 = r10;
        r8 = r6;
        r6 = r4;
        r4 = r62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x08aa, code lost:
    
        r48 = r20;
        r51 = r26;
        r50 = r61;
        r45 = r15;
        r43 = r18;
        r15 = r27;
        r1 = r28;
        r28 = r7;
        r27 = r13;
        r18 = r1;
        r24 = r8;
        r17 = r16;
        r13 = r12;
        r10 = r10;
        r8 = r6;
        r6 = r4;
        r4 = r62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x08da, code lost:
    
        r48 = r20;
        r51 = r26;
        r50 = r61;
        r45 = r15;
        r43 = r18;
        r15 = r27;
        r1 = r28;
        r28 = r7;
        r27 = r13;
        r18 = r17;
        r24 = r8;
        r17 = r16;
        r13 = r12;
        r10 = r10;
        r8 = r6;
        r6 = r4;
        r4 = r62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x090c, code lost:
    
        r48 = r20;
        r51 = r26;
        r50 = r61;
        r45 = r15;
        r43 = r18;
        r15 = r27;
        r1 = r28;
        r28 = r7;
        r27 = r13;
        r18 = r1;
        r24 = r8;
        r17 = r16;
        r13 = r12;
        r10 = r10;
        r8 = r6;
        r6 = r4;
        r4 = r62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x093a, code lost:
    
        r48 = r20;
        r51 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x094b, code lost:
    
        r48 = r20;
        r51 = r26;
        r14 = r41;
        r50 = r61;
        r45 = r15;
        r43 = r18;
        r15 = r27;
        r28 = r7;
        r27 = r13;
        r18 = r17;
        r24 = r8;
        r17 = r16;
        r13 = r12;
        r10 = r10;
        r8 = r6;
        r6 = r4;
        r4 = r62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x097c, code lost:
    
        r42 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0992, code lost:
    
        r27 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x099c, code lost:
    
        r48 = r20;
        r51 = r26;
        r14 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x09a4, code lost:
    
        r50 = r61;
        r45 = r15;
        r43 = r18;
        r15 = r27;
        r28 = r7;
        r27 = r13;
        r18 = r17;
        r24 = r8;
        r17 = r16;
        r13 = r12;
        r10 = r10;
        r8 = r6;
        r6 = r4;
        r4 = r62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:449:0x09c1, code lost:
    
        r48 = r20;
        r51 = r26;
        r50 = r61;
        r45 = r15;
        r43 = r18;
        r15 = r27;
        r1 = r28;
        r28 = r7;
        r27 = r13;
        r18 = r17;
        r24 = r8;
        r17 = r16;
        r13 = r12;
        r10 = r10;
        r8 = r6;
        r6 = r4;
        r4 = r62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:450:0x09c1, code lost:
    
        r50 = r61;
        r45 = r15;
        r43 = r18;
        r15 = r27;
        r28 = r7;
        r27 = r13;
        r18 = r17;
        r24 = r8;
        r17 = r16;
        r13 = r12;
        r10 = r10;
        r8 = r6;
        r6 = r4;
        r4 = r62;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:433:0x02f2, B:58:0x0304], limit reached: 453 */
    /* JADX WARN: Type inference failed for: r0v130 */
    /* JADX WARN: Type inference failed for: r0v131, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v134 */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r1v60, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v6, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r24v7 */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v43, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r50v0 */
    /* JADX WARN: Type inference failed for: r50v1, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r50v2 */
    /* JADX WARN: Type inference failed for: r52v0 */
    /* JADX WARN: Type inference failed for: r52v1, types: [com.cncverse.CastleTvProvider$ApiEpisode, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r52v2 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:189:0x060f -> B:383:0x0636). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:262:0x084b -> B:286:0x09c1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:266:0x087a -> B:286:0x09c1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:268:0x08aa -> B:286:0x09c1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:270:0x08da -> B:286:0x09c1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:277:0x094b -> B:286:0x09c1). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object load(@NotNull String str, @NotNull Continuation<? super LoadResponse> continuation) throws RuntimeJsonMappingException {
        C00021 c00021;
        CastleTvProvider castleTvProvider;
        String str2;
        Continuation<? super LoadResponse> continuation2;
        Integer num;
        String strSubstringAfterLast$default;
        Object securityKey;
        String str3;
        String str4;
        String str5;
        Object obj;
        String str6;
        String str7;
        String str8;
        String str9;
        Object obj2;
        String str10;
        String str11;
        NiceResponse niceResponse;
        String text;
        String str12;
        boolean z;
        String strDecryptData;
        Object value;
        String str13;
        MovieDetailsResponse movieDetailsResponse;
        final MovieDetails data;
        String title;
        String coverVerticalImage;
        String str14;
        String coverHorizontalImage;
        String str15;
        String briefIntroduction;
        Long publishTime;
        Integer numBoxInt;
        Double score;
        String str16;
        Integer numBoxInt2;
        List<String> tags;
        List<Person> actors;
        ?? r50;
        List listEmptyList;
        Integer movieType;
        int i;
        ArrayList arrayList;
        List<ApiEpisode> episodes;
        MovieDetails movieDetails;
        String str17;
        C00021 c00022;
        String str18;
        String str19;
        String str20;
        String str21;
        Integer num2;
        Integer num3;
        List<String> list;
        ?? r24;
        List list2;
        int i2;
        Object obj3;
        String str22;
        String str23;
        CastleTvProvider castleTvProvider2;
        String str24;
        String str25;
        List<ApiEpisode> list3;
        int i3;
        final int i4;
        Iterator it;
        String str26;
        Continuation<? super LoadResponse> continuation3;
        String str27;
        String str28;
        NiceResponse niceResponse2;
        String str29;
        MovieDetailsResponse movieDetailsResponse2;
        String str30;
        Object obj4;
        String str31;
        Integer num4;
        Integer num5;
        List<String> list4;
        List list5;
        int i5;
        Object obj5;
        Iterator<Season> it2;
        String str32;
        ?? r11;
        List list6;
        MovieDetails movieDetails2;
        String str33;
        List<ApiEpisode> episodes2;
        ?? r52;
        Object id;
        C00021 c00023;
        String str34;
        Integer movieType2;
        List<Person> list7;
        int i6;
        ArrayList arrayList2;
        List<Person> list8;
        String name;
        ?? qualifiedName;
        String str35;
        CastleTvProvider castleTvProvider3;
        Long movieId;
        String strValueOf;
        Integer number;
        String str36;
        String str37;
        String str38;
        Continuation<? super LoadResponse> continuation4;
        String str39;
        CastleTvProvider castleTvProvider4;
        Iterator<Season> it3;
        Integer num6;
        Integer num7;
        int i7;
        List list9;
        Object obj6;
        List<String> list10;
        final List list11;
        String str40;
        String str41;
        MovieDetails movieDetails3;
        String str42;
        String str43;
        Object obj7;
        String str44;
        CastleTvProvider castleTvProvider5;
        String str45;
        String str46;
        final int i8;
        String str47;
        boolean z2;
        Continuation<? super LoadResponse> continuation5;
        String str48;
        String strDecryptData2;
        String str49 = str;
        Continuation<? super LoadResponse> continuation6 = continuation;
        if (continuation6 instanceof C00021) {
            c00021 = (C00021) continuation6;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
            } else {
                c00021 = new C00021(continuation6);
            }
        } else {
            c00021 = new C00021(continuation6);
        }
        C00021 c00024 = c00021;
        Object objNewMovieLoadResponse = c00024.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00024.label) {
                case 0:
                    ResultKt.throwOnFailure(objNewMovieLoadResponse);
                    try {
                        strSubstringAfterLast$default = StringsKt.substringAfterLast$default(str49, '/', (String) null, 2, (Object) null);
                        try {
                            c00024.L$0 = str49;
                            c00024.L$1 = strSubstringAfterLast$default;
                            c00024.label = 1;
                            securityKey = getSecurityKey(c00024);
                            if (securityKey == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            try {
                                str3 = (String) securityKey;
                                if (str3 == null) {
                                    return null;
                                }
                                try {
                                    str4 = getMainUrl() + "/film-api/v1.9.9/movie?channel=IndiaA&clientType=1&clientType=1&lang=en-US&movieId=" + strSubstringAfterLast$default + "&packageName=com.external.castle";
                                    try {
                                        Requests app = MainActivityKt.getApp();
                                        c00024.L$0 = str49;
                                        c00024.L$1 = SpillingKt.nullOutSpilledVariable(strSubstringAfterLast$default);
                                        c00024.L$2 = str3;
                                        c00024.L$3 = SpillingKt.nullOutSpilledVariable(str4);
                                        c00024.label = 2;
                                        str5 = " but was ";
                                        obj = objNewMovieLoadResponse;
                                        num = null;
                                        str6 = "&packageName=com.external.castle";
                                        str7 = "/film-api/v1.9.9/movie?channel=IndiaA&clientType=1&clientType=1&lang=en-US&movieId=";
                                        str8 = "Deserialized value did not match the specified type; specified ";
                                        str9 = str49;
                                        obj2 = coroutine_suspended;
                                        try {
                                            objNewMovieLoadResponse = Requests.get$default(app, str4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00024, 4094, (Object) null);
                                            c00024 = c00024;
                                            if (objNewMovieLoadResponse == obj2) {
                                                return obj2;
                                            }
                                            str10 = str4;
                                            str2 = str9;
                                            str11 = str3;
                                            try {
                                                niceResponse = (NiceResponse) objNewMovieLoadResponse;
                                                text = niceResponse.getText();
                                                str12 = text;
                                                if (str12 != null) {
                                                    try {
                                                        if (!StringsKt.isBlank(str12)) {
                                                            z = false;
                                                        }
                                                        if (!z || (strDecryptData = decryptData(text, str11)) == null) {
                                                            return num;
                                                        }
                                                        value = this.mapper.readValue(strDecryptData, new TypeReference<MovieDetailsResponse>() { // from class: com.cncverse.CastleTvProvider$load$$inlined$readValue$1
                                                        });
                                                        str13 = strSubstringAfterLast$default;
                                                        if (!(value instanceof MovieDetailsResponse)) {
                                                            ?? Append = new StringBuilder().append(str8).append(Reflection.getOrCreateKotlinClass(MovieDetailsResponse.class).getQualifiedName()).append("(non-null)").append(str5);
                                                            if (value != null) {
                                                                qualifiedName = Reflection.getOrCreateKotlinClass(value.getClass()).getQualifiedName();
                                                            } else {
                                                                qualifiedName = num;
                                                            }
                                                            throw new RuntimeJsonMappingException(Append.append(qualifiedName).toString());
                                                        }
                                                        String str50 = str5;
                                                        movieDetailsResponse = (MovieDetailsResponse) value;
                                                        data = movieDetailsResponse.getData();
                                                        title = data.getTitle();
                                                        if (title == null) {
                                                            title = "Unknown Title";
                                                        }
                                                        coverVerticalImage = data.getCoverVerticalImage();
                                                        if (coverVerticalImage == null) {
                                                            try {
                                                                coverVerticalImage = data.getCoverHorizontalImage();
                                                            } catch (Exception e) {
                                                                e = e;
                                                                castleTvProvider = this;
                                                                continuation2 = continuation;
                                                            }
                                                        }
                                                        str14 = coverVerticalImage;
                                                        coverHorizontalImage = data.getCoverHorizontalImage();
                                                        if (coverHorizontalImage == null) {
                                                            coverHorizontalImage = data.getCoverVerticalImage();
                                                        }
                                                        str15 = coverHorizontalImage;
                                                        briefIntroduction = data.getBriefIntroduction();
                                                        publishTime = data.getPublishTime();
                                                        if (publishTime != null) {
                                                            numBoxInt = Boxing.boxInt(Instant.ofEpochMilli(publishTime.longValue()).atZone(ZoneId.systemDefault()).getYear());
                                                        } else {
                                                            numBoxInt = num;
                                                        }
                                                        score = data.getScore();
                                                        if (score != null) {
                                                            try {
                                                                str16 = str2;
                                                                try {
                                                                    numBoxInt2 = Boxing.boxInt((int) (score.doubleValue() * ((double) 1000)));
                                                                } catch (Exception e2) {
                                                                    e = e2;
                                                                    castleTvProvider = this;
                                                                    continuation2 = continuation;
                                                                    str2 = str16;
                                                                }
                                                            } catch (Exception e3) {
                                                                e = e3;
                                                                castleTvProvider = this;
                                                                continuation2 = continuation;
                                                            }
                                                        } else {
                                                            str16 = str2;
                                                            numBoxInt2 = num;
                                                        }
                                                        try {
                                                            tags = data.getTags();
                                                            actors = data.getActors();
                                                            if (actors != null) {
                                                                list7 = actors;
                                                                i6 = 0;
                                                                arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                                                                list8 = list7;
                                                                for (Person person : list8) {
                                                                    List<Person> list12 = list7;
                                                                    name = person.getName();
                                                                    if (name == null) {
                                                                        name = "";
                                                                    }
                                                                    arrayList2.add(new ActorData(new Actor(name, person.getAvatar()), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                                                                    list7 = list12;
                                                                    list8 = list8;
                                                                    i6 = i6;
                                                                }
                                                                r50 = arrayList2;
                                                            } else {
                                                                r50 = num;
                                                            }
                                                            listEmptyList = CollectionsKt.emptyList();
                                                            movieType = data.getMovieType();
                                                            if ((movieType == null && movieType.intValue() == 1) || ((movieType2 = data.getMovieType()) != null && movieType2.intValue() == 3)) {
                                                                i = 1;
                                                            } else {
                                                                Integer movieType3 = data.getMovieType();
                                                                if (movieType3 != null && movieType3.intValue() == 5) {
                                                                    i = 1;
                                                                } else {
                                                                    List<ApiEpisode> episodes3 = data.getEpisodes();
                                                                    if ((episodes3 != null ? episodes3.size() : 0) > 1) {
                                                                        i = 1;
                                                                    } else {
                                                                        i = 0;
                                                                    }
                                                                }
                                                            }
                                                            try {
                                                                if (i == 0) {
                                                                    try {
                                                                        arrayList = new ArrayList();
                                                                        if (data.getSeasons() != null || data.getSeasons().size() <= 1) {
                                                                            episodes = data.getEpisodes();
                                                                            if (episodes != null) {
                                                                                list3 = episodes;
                                                                                i3 = 0;
                                                                                i4 = 0;
                                                                                for (it = list3.iterator(); it.hasNext(); it = it) {
                                                                                    Object next = it.next();
                                                                                    int i9 = i4 + 1;
                                                                                    if (i4 < 0) {
                                                                                        CollectionsKt.throwIndexOverflow();
                                                                                    }
                                                                                    final ApiEpisode apiEpisode = (ApiEpisode) next;
                                                                                    arrayList.add(MainAPIKt.newEpisode(this, new StringBuilder().append(data.getId()).append('_').append(apiEpisode.getId()).toString(), new Function1() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda7
                                                                                        public final Object invoke(Object obj8) {
                                                                                            return CastleTvProvider.load$lambda$3$0(apiEpisode, i4, data, (Episode) obj8);
                                                                                        }
                                                                                    }));
                                                                                    i4 = i9;
                                                                                    list3 = list3;
                                                                                    i3 = i3;
                                                                                }
                                                                                Unit unit = Unit.INSTANCE;
                                                                            }
                                                                            continuation2 = continuation;
                                                                            movieDetails = data;
                                                                            str17 = str16;
                                                                            c00022 = c00024;
                                                                            str18 = str10;
                                                                            str19 = strDecryptData;
                                                                            str20 = str14;
                                                                            str21 = str15;
                                                                            num2 = numBoxInt;
                                                                            num3 = numBoxInt2;
                                                                            list = tags;
                                                                            r24 = r50;
                                                                            list2 = listEmptyList;
                                                                            i2 = i;
                                                                            obj3 = obj2;
                                                                            str22 = str11;
                                                                            str23 = title;
                                                                            castleTvProvider2 = this;
                                                                            str24 = str13;
                                                                            str25 = briefIntroduction;
                                                                        } else {
                                                                            castleTvProvider = this;
                                                                            str26 = str13;
                                                                            continuation3 = continuation;
                                                                            str27 = str50;
                                                                            str28 = str8;
                                                                            str18 = str10;
                                                                            niceResponse2 = niceResponse;
                                                                            str29 = text;
                                                                            str19 = strDecryptData;
                                                                            movieDetailsResponse2 = movieDetailsResponse;
                                                                            str30 = title;
                                                                            obj4 = obj;
                                                                            str31 = str14;
                                                                            num4 = numBoxInt;
                                                                            num5 = numBoxInt2;
                                                                            list4 = tags;
                                                                            list5 = listEmptyList;
                                                                            i5 = i;
                                                                            obj5 = obj2;
                                                                            it2 = data.getSeasons().iterator();
                                                                            str22 = str11;
                                                                            str32 = briefIntroduction;
                                                                            r11 = r50;
                                                                            list6 = arrayList;
                                                                            movieDetails2 = data;
                                                                            str33 = str15;
                                                                            while (true) {
                                                                                try {
                                                                                    if (it2.hasNext()) {
                                                                                        Season next2 = it2.next();
                                                                                        movieId = next2.getMovieId();
                                                                                        if (movieId != null || (strValueOf = String.valueOf(movieId.longValue())) == null || (number = next2.getNumber()) == null) {
                                                                                            obj5 = obj5;
                                                                                            str6 = str6;
                                                                                            it2 = it2;
                                                                                            str31 = str31;
                                                                                            str30 = str30;
                                                                                            str32 = str32;
                                                                                            str28 = str28;
                                                                                            str27 = str27;
                                                                                            c00024 = c00024;
                                                                                        } else {
                                                                                            int iIntValue = number.intValue();
                                                                                            Iterator<Season> it4 = it2;
                                                                                            String str51 = str7;
                                                                                            str7 = str51;
                                                                                            StringBuilder sbAppend = new StringBuilder().append(castleTvProvider.getMainUrl()).append(str51).append(strValueOf);
                                                                                            str38 = str6;
                                                                                            String string = sbAppend.append(str38).toString();
                                                                                            Requests app2 = MainActivityKt.getApp();
                                                                                            c00024.L$0 = str16;
                                                                                            c00024.L$1 = SpillingKt.nullOutSpilledVariable(str26);
                                                                                            c00024.L$2 = str22;
                                                                                            c00024.L$3 = SpillingKt.nullOutSpilledVariable(str18);
                                                                                            c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                                                                                            c00024.L$5 = SpillingKt.nullOutSpilledVariable(str29);
                                                                                            c00024.L$6 = SpillingKt.nullOutSpilledVariable(str19);
                                                                                            c00024.L$7 = SpillingKt.nullOutSpilledVariable(movieDetailsResponse2);
                                                                                            c00024.L$8 = movieDetails2;
                                                                                            c00024.L$9 = str30;
                                                                                            c00024.L$10 = str31;
                                                                                            c00024.L$11 = str33;
                                                                                            c00024.L$12 = str32;
                                                                                            c00024.L$13 = num4;
                                                                                            c00024.L$14 = num5;
                                                                                            c00024.L$15 = list4;
                                                                                            c00024.L$16 = r11;
                                                                                            c00024.L$17 = list5;
                                                                                            c00024.L$18 = list6;
                                                                                            String str52 = str31;
                                                                                            c00024.L$19 = it4;
                                                                                            c00024.L$20 = SpillingKt.nullOutSpilledVariable(next2);
                                                                                            c00024.L$21 = strValueOf;
                                                                                            c00024.L$22 = SpillingKt.nullOutSpilledVariable(string);
                                                                                            int i10 = i5;
                                                                                            c00024.I$0 = i10;
                                                                                            c00024.I$1 = iIntValue;
                                                                                            c00024.label = 3;
                                                                                            C00021 c00025 = c00024;
                                                                                            Object obj8 = Requests.get$default(app2, string, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00025, 4094, (Object) null);
                                                                                            Object obj9 = obj5;
                                                                                            if (obj8 == obj9) {
                                                                                                return obj9;
                                                                                            }
                                                                                            str41 = str30;
                                                                                            movieDetails3 = movieDetails2;
                                                                                            str42 = str22;
                                                                                            it3 = it4;
                                                                                            str43 = str52;
                                                                                            continuation6 = continuation3;
                                                                                            obj7 = obj8;
                                                                                            str44 = str32;
                                                                                            num6 = num4;
                                                                                            num7 = num5;
                                                                                            castleTvProvider5 = castleTvProvider;
                                                                                            str45 = strValueOf;
                                                                                            str46 = string;
                                                                                            list9 = list5;
                                                                                            list10 = list4;
                                                                                            i7 = i10;
                                                                                            i8 = iIntValue;
                                                                                            list11 = list6;
                                                                                            obj6 = obj9;
                                                                                            c00024 = c00025;
                                                                                            str40 = str33;
                                                                                            objNewMovieLoadResponse = obj4;
                                                                                            r11 = r11;
                                                                                            String text2 = ((NiceResponse) obj7).getText();
                                                                                            str47 = text2;
                                                                                            if (str47 != null) {
                                                                                                if (StringsKt.isBlank(str47)) {
                                                                                                    z2 = false;
                                                                                                }
                                                                                                if (!z2 || (strDecryptData2 = castleTvProvider5.decryptData(text2, str42)) == null) {
                                                                                                    str39 = str42;
                                                                                                    castleTvProvider4 = castleTvProvider5;
                                                                                                    continuation5 = continuation6;
                                                                                                    str36 = str28;
                                                                                                    str48 = str27;
                                                                                                } else {
                                                                                                    str39 = str42;
                                                                                                    castleTvProvider4 = castleTvProvider5;
                                                                                                    Object value2 = castleTvProvider5.mapper.readValue(strDecryptData2, new TypeReference<MovieDetailsResponse>() { // from class: com.cncverse.CastleTvProvider$load$$inlined$readValue$2
                                                                                                    });
                                                                                                    if (!(value2 instanceof MovieDetailsResponse)) {
                                                                                                        String str53 = str28;
                                                                                                        StringBuilder sbAppend2 = new StringBuilder().append(str53);
                                                                                                        str36 = str53;
                                                                                                        String str54 = str27;
                                                                                                        throw new RuntimeJsonMappingException(sbAppend2.append(Reflection.getOrCreateKotlinClass(MovieDetailsResponse.class).getQualifiedName()).append("(non-null)").append(str54).append(value2 != null ? Reflection.getOrCreateKotlinClass(value2.getClass()).getQualifiedName() : num).toString());
                                                                                                    }
                                                                                                    str36 = str28;
                                                                                                    String str55 = str27;
                                                                                                    MovieDetailsResponse movieDetailsResponse3 = (MovieDetailsResponse) value2;
                                                                                                    MovieDetails data2 = movieDetailsResponse3.getData();
                                                                                                    List<ApiEpisode> episodes4 = data2.getEpisodes();
                                                                                                    if (episodes4 != null) {
                                                                                                        for (final ApiEpisode apiEpisode2 : episodes4) {
                                                                                                            MovieDetailsResponse movieDetailsResponse4 = movieDetailsResponse3;
                                                                                                            MovieDetails movieDetails4 = data2;
                                                                                                            continuation4 = continuation6;
                                                                                                            str37 = str55;
                                                                                                            list11.add(MainAPIKt.newEpisode(castleTvProvider4, str45 + '_' + apiEpisode2.getId(), new Function1() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda6
                                                                                                                public final Object invoke(Object obj10) {
                                                                                                                    return CastleTvProvider.load$lambda$2$0(apiEpisode2, list11, i8, (Episode) obj10);
                                                                                                                }
                                                                                                            }));
                                                                                                            movieDetailsResponse3 = movieDetailsResponse4;
                                                                                                            data2 = movieDetails4;
                                                                                                            continuation6 = continuation4;
                                                                                                            str55 = str37;
                                                                                                        }
                                                                                                        str48 = str55;
                                                                                                        continuation5 = continuation6;
                                                                                                        Unit unit2 = Unit.INSTANCE;
                                                                                                    } else {
                                                                                                        str48 = str55;
                                                                                                        continuation5 = continuation6;
                                                                                                    }
                                                                                                    obj4 = objNewMovieLoadResponse;
                                                                                                    str33 = str40;
                                                                                                    list6 = list11;
                                                                                                    list4 = list10;
                                                                                                    str6 = str38;
                                                                                                    it2 = it3;
                                                                                                    obj5 = obj6;
                                                                                                    i5 = i7;
                                                                                                    list5 = list9;
                                                                                                    num5 = num7;
                                                                                                    num4 = num6;
                                                                                                    castleTvProvider = castleTvProvider4;
                                                                                                    str22 = str39;
                                                                                                    str28 = str36;
                                                                                                    continuation3 = continuation4;
                                                                                                    str27 = str37;
                                                                                                    r11 = r11;
                                                                                                }
                                                                                                str32 = str44;
                                                                                                obj4 = objNewMovieLoadResponse;
                                                                                                str33 = str40;
                                                                                                list6 = list11;
                                                                                                list4 = list10;
                                                                                                str6 = str38;
                                                                                                it2 = it3;
                                                                                                obj5 = obj6;
                                                                                                i5 = i7;
                                                                                                list5 = list9;
                                                                                                num5 = num7;
                                                                                                num4 = num6;
                                                                                                str31 = str43;
                                                                                                str30 = str41;
                                                                                                movieDetails2 = movieDetails3;
                                                                                                castleTvProvider = castleTvProvider4;
                                                                                                str22 = str39;
                                                                                                str28 = str36;
                                                                                                continuation3 = continuation5;
                                                                                                str27 = str48;
                                                                                                r11 = r11;
                                                                                            }
                                                                                            z2 = true;
                                                                                            if (z2) {
                                                                                                str39 = str42;
                                                                                                castleTvProvider4 = castleTvProvider5;
                                                                                                continuation5 = continuation6;
                                                                                                str36 = str28;
                                                                                                str48 = str27;
                                                                                            } else {
                                                                                                str39 = str42;
                                                                                                castleTvProvider4 = castleTvProvider5;
                                                                                                continuation5 = continuation6;
                                                                                                str36 = str28;
                                                                                                str48 = str27;
                                                                                            }
                                                                                            str32 = str44;
                                                                                            obj4 = objNewMovieLoadResponse;
                                                                                            str33 = str40;
                                                                                            list6 = list11;
                                                                                            list4 = list10;
                                                                                            str6 = str38;
                                                                                            it2 = it3;
                                                                                            obj5 = obj6;
                                                                                            i5 = i7;
                                                                                            list5 = list9;
                                                                                            num5 = num7;
                                                                                            num4 = num6;
                                                                                            str31 = str43;
                                                                                            str30 = str41;
                                                                                            movieDetails2 = movieDetails3;
                                                                                            castleTvProvider = castleTvProvider4;
                                                                                            str22 = str39;
                                                                                            str28 = str36;
                                                                                            continuation3 = continuation5;
                                                                                            str27 = str48;
                                                                                            r11 = r11;
                                                                                        }
                                                                                        if (it2.hasNext()) {
                                                                                            String str56 = str31;
                                                                                            String str57 = str32;
                                                                                            String str58 = str30;
                                                                                            C00021 c00026 = c00024;
                                                                                            obj3 = obj5;
                                                                                            Unit unit3 = Unit.INSTANCE;
                                                                                            obj = obj4;
                                                                                            str21 = str33;
                                                                                            movieDetails = movieDetails2;
                                                                                            arrayList = list6;
                                                                                            num2 = num4;
                                                                                            list2 = list5;
                                                                                            str17 = str16;
                                                                                            r24 = r11;
                                                                                            list = list4;
                                                                                            num3 = num5;
                                                                                            i2 = i5;
                                                                                            castleTvProvider2 = castleTvProvider;
                                                                                            str20 = str56;
                                                                                            str23 = str58;
                                                                                            movieDetailsResponse = movieDetailsResponse2;
                                                                                            text = str29;
                                                                                            niceResponse = niceResponse2;
                                                                                            str24 = str26;
                                                                                            c00022 = c00026;
                                                                                            continuation2 = continuation3;
                                                                                            str25 = str57;
                                                                                        } else {
                                                                                            Season next3 = it2.next();
                                                                                            movieId = next3.getMovieId();
                                                                                            if (movieId != null) {
                                                                                            }
                                                                                            obj5 = obj5;
                                                                                            str6 = str6;
                                                                                            it2 = it2;
                                                                                            str31 = str31;
                                                                                            str30 = str30;
                                                                                            str32 = str32;
                                                                                            str28 = str28;
                                                                                            str27 = str27;
                                                                                            c00024 = c00024;
                                                                                        }
                                                                                    } else {
                                                                                        String str59 = str31;
                                                                                        String str510 = str32;
                                                                                        String str511 = str30;
                                                                                        C00021 c00027 = c00024;
                                                                                        obj3 = obj5;
                                                                                        try {
                                                                                            Unit unit4 = Unit.INSTANCE;
                                                                                            obj = obj4;
                                                                                            str21 = str33;
                                                                                            movieDetails = movieDetails2;
                                                                                            arrayList = list6;
                                                                                            num2 = num4;
                                                                                            list2 = list5;
                                                                                            str17 = str16;
                                                                                            r24 = r11;
                                                                                            list = list4;
                                                                                            num3 = num5;
                                                                                            i2 = i5;
                                                                                            castleTvProvider2 = castleTvProvider;
                                                                                            str20 = str59;
                                                                                            str23 = str511;
                                                                                            movieDetailsResponse = movieDetailsResponse2;
                                                                                            text = str29;
                                                                                            niceResponse = niceResponse2;
                                                                                            str24 = str26;
                                                                                            c00022 = c00027;
                                                                                            continuation2 = continuation3;
                                                                                            str25 = str510;
                                                                                        } catch (Exception e4) {
                                                                                            e = e4;
                                                                                            continuation2 = continuation3;
                                                                                            str2 = str16;
                                                                                        }
                                                                                    }
                                                                                } catch (Exception e5) {
                                                                                    e = e5;
                                                                                    continuation2 = continuation3;
                                                                                    str2 = str16;
                                                                                }
                                                                            }
                                                                        }
                                                                        try {
                                                                            TvType tvType = TvType.TvSeries;
                                                                            C00034 c00034 = new C00034(str20, str21, str25, num2, num3, list, r24, list2, movieDetails, null);
                                                                            c00022.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                                                                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(str24);
                                                                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(str22);
                                                                            c00022.L$3 = SpillingKt.nullOutSpilledVariable(str18);
                                                                            c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                                                            c00022.L$5 = SpillingKt.nullOutSpilledVariable(text);
                                                                            c00022.L$6 = SpillingKt.nullOutSpilledVariable(str19);
                                                                            c00022.L$7 = SpillingKt.nullOutSpilledVariable(movieDetailsResponse);
                                                                            c00022.L$8 = SpillingKt.nullOutSpilledVariable(movieDetails);
                                                                            c00022.L$9 = SpillingKt.nullOutSpilledVariable(str23);
                                                                            c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                                                                            c00022.L$11 = SpillingKt.nullOutSpilledVariable(str21);
                                                                            c00022.L$12 = SpillingKt.nullOutSpilledVariable(str25);
                                                                            c00022.L$13 = SpillingKt.nullOutSpilledVariable(num2);
                                                                            c00022.L$14 = SpillingKt.nullOutSpilledVariable(num3);
                                                                            c00022.L$15 = SpillingKt.nullOutSpilledVariable(list);
                                                                            c00022.L$16 = SpillingKt.nullOutSpilledVariable((Object) r24);
                                                                            c00022.L$17 = SpillingKt.nullOutSpilledVariable(list2);
                                                                            c00022.L$18 = SpillingKt.nullOutSpilledVariable(arrayList);
                                                                            Integer num8 = num;
                                                                            c00022.L$19 = num8;
                                                                            c00022.L$20 = num8;
                                                                            c00022.L$21 = num8;
                                                                            c00022.L$22 = num8;
                                                                            c00022.I$0 = i2;
                                                                            c00022.label = 4;
                                                                            objNewMovieLoadResponse = MainAPIKt.newTvSeriesLoadResponse(castleTvProvider2, str23, str17, tvType, arrayList, c00034, c00022);
                                                                            if (objNewMovieLoadResponse == obj3) {
                                                                                return obj3;
                                                                            }
                                                                            str35 = str17;
                                                                            continuation6 = continuation2;
                                                                            castleTvProvider3 = castleTvProvider2;
                                                                            try {
                                                                                return (LoadResponse) objNewMovieLoadResponse;
                                                                            } catch (Exception e6) {
                                                                                e = e6;
                                                                                str2 = str35;
                                                                                continuation2 = continuation6;
                                                                                castleTvProvider = castleTvProvider3;
                                                                                num = null;
                                                                            }
                                                                        } catch (Exception e7) {
                                                                            e = e7;
                                                                            str2 = str17;
                                                                            castleTvProvider = castleTvProvider2;
                                                                            num = null;
                                                                        }
                                                                    } catch (Exception e8) {
                                                                        e = e8;
                                                                        castleTvProvider = this;
                                                                        continuation2 = continuation;
                                                                        str2 = str16;
                                                                        num = null;
                                                                    }
                                                                } else {
                                                                    episodes2 = data.getEpisodes();
                                                                    if (episodes2 != null) {
                                                                        r52 = (ApiEpisode) CollectionsKt.firstOrNull(episodes2);
                                                                    } else {
                                                                        r52 = num;
                                                                    }
                                                                    CastleTvProvider castleTvProvider6 = this;
                                                                    TvType tvType2 = TvType.Movie;
                                                                    StringBuilder sbAppend3 = new StringBuilder().append(data.getId()).append('_');
                                                                    if (r52 != 0) {
                                                                        id = r52.getId();
                                                                    } else {
                                                                        id = num;
                                                                    }
                                                                    String string2 = sbAppend3.append(id).toString();
                                                                    C00045 c00045 = new C00045(str14, str15, briefIntroduction, numBoxInt, numBoxInt2, tags, r50, listEmptyList, r52, null);
                                                                    c00024.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                                                                    c00024.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                                                                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(str11);
                                                                    c00024.L$3 = SpillingKt.nullOutSpilledVariable(str10);
                                                                    c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                                                    c00024.L$5 = SpillingKt.nullOutSpilledVariable(text);
                                                                    c00024.L$6 = SpillingKt.nullOutSpilledVariable(strDecryptData);
                                                                    c00024.L$7 = SpillingKt.nullOutSpilledVariable(movieDetailsResponse);
                                                                    c00024.L$8 = SpillingKt.nullOutSpilledVariable(data);
                                                                    c00024.L$9 = SpillingKt.nullOutSpilledVariable(title);
                                                                    c00024.L$10 = SpillingKt.nullOutSpilledVariable(str14);
                                                                    c00024.L$11 = SpillingKt.nullOutSpilledVariable(str15);
                                                                    c00024.L$12 = SpillingKt.nullOutSpilledVariable(briefIntroduction);
                                                                    c00024.L$13 = SpillingKt.nullOutSpilledVariable(numBoxInt);
                                                                    c00024.L$14 = SpillingKt.nullOutSpilledVariable(numBoxInt2);
                                                                    c00024.L$15 = SpillingKt.nullOutSpilledVariable(tags);
                                                                    c00024.L$16 = SpillingKt.nullOutSpilledVariable((Object) r50);
                                                                    c00024.L$17 = SpillingKt.nullOutSpilledVariable(listEmptyList);
                                                                    c00024.L$18 = SpillingKt.nullOutSpilledVariable((Object) r52);
                                                                    c00024.I$0 = i;
                                                                    c00024.label = 5;
                                                                    str2 = str16;
                                                                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(castleTvProvider6, title, str2, tvType2, string2, c00045, c00024);
                                                                    c00023 = c00024;
                                                                    if (objNewMovieLoadResponse == obj2) {
                                                                        return obj2;
                                                                    }
                                                                    str34 = str2;
                                                                    try {
                                                                        return (LoadResponse) objNewMovieLoadResponse;
                                                                    } catch (Exception e9) {
                                                                        e = e9;
                                                                        continuation2 = continuation;
                                                                        str2 = str34;
                                                                        castleTvProvider = this;
                                                                    }
                                                                }
                                                            } catch (Exception e10) {
                                                                e = e10;
                                                                castleTvProvider = this;
                                                                continuation2 = continuation;
                                                                str2 = str16;
                                                            }
                                                        } catch (Exception e11) {
                                                            e = e11;
                                                            str2 = str16;
                                                            continuation2 = continuation;
                                                            castleTvProvider = this;
                                                        }
                                                        break;
                                                    } catch (Exception e12) {
                                                        e = e12;
                                                        continuation2 = continuation;
                                                        castleTvProvider = this;
                                                    }
                                                    e.printStackTrace();
                                                    return num;
                                                }
                                                z = true;
                                                if (!z) {
                                                    return num;
                                                }
                                                value = this.mapper.readValue(strDecryptData, new TypeReference<MovieDetailsResponse>() { // from class: com.cncverse.CastleTvProvider$load$$inlined$readValue$1
                                                });
                                                str13 = strSubstringAfterLast$default;
                                                if (!(value instanceof MovieDetailsResponse)) {
                                                    ?? Append2 = new StringBuilder().append(str8).append(Reflection.getOrCreateKotlinClass(MovieDetailsResponse.class).getQualifiedName()).append("(non-null)").append(str5);
                                                    if (value != null) {
                                                        qualifiedName = Reflection.getOrCreateKotlinClass(value.getClass()).getQualifiedName();
                                                    } else {
                                                        qualifiedName = num;
                                                    }
                                                    throw new RuntimeJsonMappingException(Append2.append(qualifiedName).toString());
                                                }
                                                String str512 = str5;
                                                movieDetailsResponse = (MovieDetailsResponse) value;
                                                data = movieDetailsResponse.getData();
                                                title = data.getTitle();
                                                if (title == null) {
                                                    title = "Unknown Title";
                                                }
                                                coverVerticalImage = data.getCoverVerticalImage();
                                                if (coverVerticalImage == null) {
                                                    coverVerticalImage = data.getCoverHorizontalImage();
                                                }
                                                str14 = coverVerticalImage;
                                                coverHorizontalImage = data.getCoverHorizontalImage();
                                                if (coverHorizontalImage == null) {
                                                    coverHorizontalImage = data.getCoverVerticalImage();
                                                }
                                                str15 = coverHorizontalImage;
                                                briefIntroduction = data.getBriefIntroduction();
                                                publishTime = data.getPublishTime();
                                                if (publishTime != null) {
                                                    numBoxInt = Boxing.boxInt(Instant.ofEpochMilli(publishTime.longValue()).atZone(ZoneId.systemDefault()).getYear());
                                                } else {
                                                    numBoxInt = num;
                                                }
                                                score = data.getScore();
                                                if (score != null) {
                                                    str16 = str2;
                                                    numBoxInt2 = Boxing.boxInt((int) (score.doubleValue() * ((double) 1000)));
                                                } else {
                                                    str16 = str2;
                                                    numBoxInt2 = num;
                                                }
                                                tags = data.getTags();
                                                actors = data.getActors();
                                                if (actors != null) {
                                                    list7 = actors;
                                                    i6 = 0;
                                                    arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                                                    list8 = list7;
                                                    while (r18.hasNext()) {
                                                        List<Person> list13 = list7;
                                                        name = person.getName();
                                                        if (name == null) {
                                                            name = "";
                                                        }
                                                        arrayList2.add(new ActorData(new Actor(name, person.getAvatar()), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                                                        list7 = list13;
                                                        list8 = list8;
                                                        i6 = i6;
                                                    }
                                                    r50 = arrayList2;
                                                } else {
                                                    r50 = num;
                                                }
                                                listEmptyList = CollectionsKt.emptyList();
                                                movieType = data.getMovieType();
                                                if (movieType == null) {
                                                    i = 1;
                                                } else {
                                                    i = 1;
                                                }
                                                if (i == 0) {
                                                    episodes2 = data.getEpisodes();
                                                    if (episodes2 != null) {
                                                        r52 = (ApiEpisode) CollectionsKt.firstOrNull(episodes2);
                                                    } else {
                                                        r52 = num;
                                                    }
                                                    CastleTvProvider castleTvProvider7 = this;
                                                    TvType tvType3 = TvType.Movie;
                                                    StringBuilder sbAppend4 = new StringBuilder().append(data.getId()).append('_');
                                                    if (r52 != 0) {
                                                        id = r52.getId();
                                                    } else {
                                                        id = num;
                                                    }
                                                    String string3 = sbAppend4.append(id).toString();
                                                    C00045 c00046 = new C00045(str14, str15, briefIntroduction, numBoxInt, numBoxInt2, tags, r50, listEmptyList, r52, null);
                                                    c00024.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                                                    c00024.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                                                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(str11);
                                                    c00024.L$3 = SpillingKt.nullOutSpilledVariable(str10);
                                                    c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                                    c00024.L$5 = SpillingKt.nullOutSpilledVariable(text);
                                                    c00024.L$6 = SpillingKt.nullOutSpilledVariable(strDecryptData);
                                                    c00024.L$7 = SpillingKt.nullOutSpilledVariable(movieDetailsResponse);
                                                    c00024.L$8 = SpillingKt.nullOutSpilledVariable(data);
                                                    c00024.L$9 = SpillingKt.nullOutSpilledVariable(title);
                                                    c00024.L$10 = SpillingKt.nullOutSpilledVariable(str14);
                                                    c00024.L$11 = SpillingKt.nullOutSpilledVariable(str15);
                                                    c00024.L$12 = SpillingKt.nullOutSpilledVariable(briefIntroduction);
                                                    c00024.L$13 = SpillingKt.nullOutSpilledVariable(numBoxInt);
                                                    c00024.L$14 = SpillingKt.nullOutSpilledVariable(numBoxInt2);
                                                    c00024.L$15 = SpillingKt.nullOutSpilledVariable(tags);
                                                    c00024.L$16 = SpillingKt.nullOutSpilledVariable((Object) r50);
                                                    c00024.L$17 = SpillingKt.nullOutSpilledVariable(listEmptyList);
                                                    c00024.L$18 = SpillingKt.nullOutSpilledVariable((Object) r52);
                                                    c00024.I$0 = i;
                                                    c00024.label = 5;
                                                    str2 = str16;
                                                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(castleTvProvider7, title, str2, tvType3, string3, c00046, c00024);
                                                    c00023 = c00024;
                                                    if (objNewMovieLoadResponse == obj2) {
                                                        return obj2;
                                                    }
                                                    str34 = str2;
                                                    return (LoadResponse) objNewMovieLoadResponse;
                                                }
                                                arrayList = new ArrayList();
                                                if (data.getSeasons() != null) {
                                                }
                                                episodes = data.getEpisodes();
                                                if (episodes != null) {
                                                    list3 = episodes;
                                                    i3 = 0;
                                                    i4 = 0;
                                                    while (it.hasNext()) {
                                                        Object next4 = it.next();
                                                        int i11 = i4 + 1;
                                                        if (i4 < 0) {
                                                            CollectionsKt.throwIndexOverflow();
                                                        }
                                                        final ApiEpisode apiEpisode3 = (ApiEpisode) next4;
                                                        arrayList.add(MainAPIKt.newEpisode(this, new StringBuilder().append(data.getId()).append('_').append(apiEpisode3.getId()).toString(), new Function1() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda7
                                                            public final Object invoke(Object obj10) {
                                                                return CastleTvProvider.load$lambda$3$0(apiEpisode3, i4, data, (Episode) obj10);
                                                            }
                                                        }));
                                                        i4 = i11;
                                                        list3 = list3;
                                                        i3 = i3;
                                                    }
                                                    Unit unit5 = Unit.INSTANCE;
                                                }
                                                continuation2 = continuation;
                                                movieDetails = data;
                                                str17 = str16;
                                                c00022 = c00024;
                                                str18 = str10;
                                                str19 = strDecryptData;
                                                str20 = str14;
                                                str21 = str15;
                                                num2 = numBoxInt;
                                                num3 = numBoxInt2;
                                                list = tags;
                                                r24 = r50;
                                                list2 = listEmptyList;
                                                i2 = i;
                                                obj3 = obj2;
                                                str22 = str11;
                                                str23 = title;
                                                castleTvProvider2 = this;
                                                str24 = str13;
                                                str25 = briefIntroduction;
                                                TvType tvType4 = TvType.TvSeries;
                                                C00034 c00035 = new C00034(str20, str21, str25, num2, num3, list, r24, list2, movieDetails, null);
                                                c00022.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                                                c00022.L$1 = SpillingKt.nullOutSpilledVariable(str24);
                                                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str22);
                                                c00022.L$3 = SpillingKt.nullOutSpilledVariable(str18);
                                                c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                                c00022.L$5 = SpillingKt.nullOutSpilledVariable(text);
                                                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str19);
                                                c00022.L$7 = SpillingKt.nullOutSpilledVariable(movieDetailsResponse);
                                                c00022.L$8 = SpillingKt.nullOutSpilledVariable(movieDetails);
                                                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str23);
                                                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                                                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str21);
                                                c00022.L$12 = SpillingKt.nullOutSpilledVariable(str25);
                                                c00022.L$13 = SpillingKt.nullOutSpilledVariable(num2);
                                                c00022.L$14 = SpillingKt.nullOutSpilledVariable(num3);
                                                c00022.L$15 = SpillingKt.nullOutSpilledVariable(list);
                                                c00022.L$16 = SpillingKt.nullOutSpilledVariable((Object) r24);
                                                c00022.L$17 = SpillingKt.nullOutSpilledVariable(list2);
                                                c00022.L$18 = SpillingKt.nullOutSpilledVariable(arrayList);
                                                Integer num9 = num;
                                                c00022.L$19 = num9;
                                                c00022.L$20 = num9;
                                                c00022.L$21 = num9;
                                                c00022.L$22 = num9;
                                                c00022.I$0 = i2;
                                                c00022.label = 4;
                                                objNewMovieLoadResponse = MainAPIKt.newTvSeriesLoadResponse(castleTvProvider2, str23, str17, tvType4, arrayList, c00035, c00022);
                                                if (objNewMovieLoadResponse == obj3) {
                                                    return obj3;
                                                }
                                                str35 = str17;
                                                continuation6 = continuation2;
                                                castleTvProvider3 = castleTvProvider2;
                                                return (LoadResponse) objNewMovieLoadResponse;
                                            } catch (Exception e13) {
                                                e = e13;
                                                continuation2 = continuation;
                                                castleTvProvider = this;
                                            }
                                            e.printStackTrace();
                                            return num;
                                        } catch (Exception e14) {
                                            e = e14;
                                            continuation2 = continuation;
                                            str2 = str9;
                                            castleTvProvider = this;
                                        }
                                    } catch (Exception e15) {
                                        e = e15;
                                        num = null;
                                        continuation2 = continuation;
                                        str2 = str49;
                                        castleTvProvider = this;
                                    }
                                } catch (Exception e16) {
                                    e = e16;
                                    num = null;
                                    continuation2 = continuation;
                                    str2 = str49;
                                    castleTvProvider = this;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                num = null;
                            }
                        } catch (Exception e18) {
                            e = e18;
                            num = null;
                            continuation2 = continuation;
                            str2 = str49;
                            castleTvProvider = this;
                        }
                    } catch (Exception e19) {
                        e = e19;
                        num = null;
                    }
                    break;
                case 1:
                    strSubstringAfterLast$default = (String) c00024.L$1;
                    str49 = (String) c00024.L$0;
                    ResultKt.throwOnFailure(objNewMovieLoadResponse);
                    securityKey = objNewMovieLoadResponse;
                    str3 = (String) securityKey;
                    if (str3 == null) {
                        return null;
                    }
                    str4 = getMainUrl() + "/film-api/v1.9.9/movie?channel=IndiaA&clientType=1&clientType=1&lang=en-US&movieId=" + strSubstringAfterLast$default + "&packageName=com.external.castle";
                    Requests app3 = MainActivityKt.getApp();
                    c00024.L$0 = str49;
                    c00024.L$1 = SpillingKt.nullOutSpilledVariable(strSubstringAfterLast$default);
                    c00024.L$2 = str3;
                    c00024.L$3 = SpillingKt.nullOutSpilledVariable(str4);
                    c00024.label = 2;
                    str5 = " but was ";
                    obj = objNewMovieLoadResponse;
                    num = null;
                    str6 = "&packageName=com.external.castle";
                    str7 = "/film-api/v1.9.9/movie?channel=IndiaA&clientType=1&clientType=1&lang=en-US&movieId=";
                    str8 = "Deserialized value did not match the specified type; specified ";
                    str9 = str49;
                    obj2 = coroutine_suspended;
                    objNewMovieLoadResponse = Requests.get$default(app3, str4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00024, 4094, (Object) null);
                    c00024 = c00024;
                    if (objNewMovieLoadResponse == obj2) {
                        return obj2;
                    }
                    str10 = str4;
                    str2 = str9;
                    str11 = str3;
                    niceResponse = (NiceResponse) objNewMovieLoadResponse;
                    text = niceResponse.getText();
                    str12 = text;
                    if (str12 != null) {
                        if (!StringsKt.isBlank(str12)) {
                            z = false;
                        }
                        if (!z) {
                            return num;
                        }
                        value = this.mapper.readValue(strDecryptData, new TypeReference<MovieDetailsResponse>() { // from class: com.cncverse.CastleTvProvider$load$$inlined$readValue$1
                        });
                        str13 = strSubstringAfterLast$default;
                        if (!(value instanceof MovieDetailsResponse)) {
                            ?? Append3 = new StringBuilder().append(str8).append(Reflection.getOrCreateKotlinClass(MovieDetailsResponse.class).getQualifiedName()).append("(non-null)").append(str5);
                            if (value != null) {
                                qualifiedName = Reflection.getOrCreateKotlinClass(value.getClass()).getQualifiedName();
                            } else {
                                qualifiedName = num;
                            }
                            throw new RuntimeJsonMappingException(Append3.append(qualifiedName).toString());
                        }
                        String str513 = str5;
                        movieDetailsResponse = (MovieDetailsResponse) value;
                        data = movieDetailsResponse.getData();
                        title = data.getTitle();
                        if (title == null) {
                            title = "Unknown Title";
                        }
                        coverVerticalImage = data.getCoverVerticalImage();
                        if (coverVerticalImage == null) {
                            coverVerticalImage = data.getCoverHorizontalImage();
                        }
                        str14 = coverVerticalImage;
                        coverHorizontalImage = data.getCoverHorizontalImage();
                        if (coverHorizontalImage == null) {
                            coverHorizontalImage = data.getCoverVerticalImage();
                        }
                        str15 = coverHorizontalImage;
                        briefIntroduction = data.getBriefIntroduction();
                        publishTime = data.getPublishTime();
                        if (publishTime != null) {
                            numBoxInt = Boxing.boxInt(Instant.ofEpochMilli(publishTime.longValue()).atZone(ZoneId.systemDefault()).getYear());
                        } else {
                            numBoxInt = num;
                        }
                        score = data.getScore();
                        if (score != null) {
                            str16 = str2;
                            numBoxInt2 = Boxing.boxInt((int) (score.doubleValue() * ((double) 1000)));
                        } else {
                            str16 = str2;
                            numBoxInt2 = num;
                        }
                        tags = data.getTags();
                        actors = data.getActors();
                        if (actors != null) {
                            list7 = actors;
                            i6 = 0;
                            arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                            list8 = list7;
                            while (r18.hasNext()) {
                                List<Person> list14 = list7;
                                name = person.getName();
                                if (name == null) {
                                    name = "";
                                }
                                arrayList2.add(new ActorData(new Actor(name, person.getAvatar()), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                                list7 = list14;
                                list8 = list8;
                                i6 = i6;
                            }
                            r50 = arrayList2;
                        } else {
                            r50 = num;
                        }
                        listEmptyList = CollectionsKt.emptyList();
                        movieType = data.getMovieType();
                        if (movieType == null) {
                            i = 1;
                        } else {
                            i = 1;
                        }
                        if (i == 0) {
                            episodes2 = data.getEpisodes();
                            if (episodes2 != null) {
                                r52 = (ApiEpisode) CollectionsKt.firstOrNull(episodes2);
                            } else {
                                r52 = num;
                            }
                            CastleTvProvider castleTvProvider8 = this;
                            TvType tvType5 = TvType.Movie;
                            StringBuilder sbAppend5 = new StringBuilder().append(data.getId()).append('_');
                            if (r52 != 0) {
                                id = r52.getId();
                            } else {
                                id = num;
                            }
                            String string4 = sbAppend5.append(id).toString();
                            C00045 c00047 = new C00045(str14, str15, briefIntroduction, numBoxInt, numBoxInt2, tags, r50, listEmptyList, r52, null);
                            c00024.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                            c00024.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                            c00024.L$2 = SpillingKt.nullOutSpilledVariable(str11);
                            c00024.L$3 = SpillingKt.nullOutSpilledVariable(str10);
                            c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse);
                            c00024.L$5 = SpillingKt.nullOutSpilledVariable(text);
                            c00024.L$6 = SpillingKt.nullOutSpilledVariable(strDecryptData);
                            c00024.L$7 = SpillingKt.nullOutSpilledVariable(movieDetailsResponse);
                            c00024.L$8 = SpillingKt.nullOutSpilledVariable(data);
                            c00024.L$9 = SpillingKt.nullOutSpilledVariable(title);
                            c00024.L$10 = SpillingKt.nullOutSpilledVariable(str14);
                            c00024.L$11 = SpillingKt.nullOutSpilledVariable(str15);
                            c00024.L$12 = SpillingKt.nullOutSpilledVariable(briefIntroduction);
                            c00024.L$13 = SpillingKt.nullOutSpilledVariable(numBoxInt);
                            c00024.L$14 = SpillingKt.nullOutSpilledVariable(numBoxInt2);
                            c00024.L$15 = SpillingKt.nullOutSpilledVariable(tags);
                            c00024.L$16 = SpillingKt.nullOutSpilledVariable((Object) r50);
                            c00024.L$17 = SpillingKt.nullOutSpilledVariable(listEmptyList);
                            c00024.L$18 = SpillingKt.nullOutSpilledVariable((Object) r52);
                            c00024.I$0 = i;
                            c00024.label = 5;
                            str2 = str16;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(castleTvProvider8, title, str2, tvType5, string4, c00047, c00024);
                            c00023 = c00024;
                            if (objNewMovieLoadResponse == obj2) {
                                return obj2;
                            }
                            str34 = str2;
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        arrayList = new ArrayList();
                        if (data.getSeasons() != null) {
                            break;
                        }
                        episodes = data.getEpisodes();
                        if (episodes != null) {
                            list3 = episodes;
                            i3 = 0;
                            i4 = 0;
                            while (it.hasNext()) {
                                Object next5 = it.next();
                                int i12 = i4 + 1;
                                if (i4 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                final ApiEpisode apiEpisode4 = (ApiEpisode) next5;
                                arrayList.add(MainAPIKt.newEpisode(this, new StringBuilder().append(data.getId()).append('_').append(apiEpisode4.getId()).toString(), new Function1() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda7
                                    public final Object invoke(Object obj10) {
                                        return CastleTvProvider.load$lambda$3$0(apiEpisode4, i4, data, (Episode) obj10);
                                    }
                                }));
                                i4 = i12;
                                list3 = list3;
                                i3 = i3;
                            }
                            Unit unit6 = Unit.INSTANCE;
                        }
                        continuation2 = continuation;
                        movieDetails = data;
                        str17 = str16;
                        c00022 = c00024;
                        str18 = str10;
                        str19 = strDecryptData;
                        str20 = str14;
                        str21 = str15;
                        num2 = numBoxInt;
                        num3 = numBoxInt2;
                        list = tags;
                        r24 = r50;
                        list2 = listEmptyList;
                        i2 = i;
                        obj3 = obj2;
                        str22 = str11;
                        str23 = title;
                        castleTvProvider2 = this;
                        str24 = str13;
                        str25 = briefIntroduction;
                        TvType tvType6 = TvType.TvSeries;
                        C00034 c00036 = new C00034(str20, str21, str25, num2, num3, list, r24, list2, movieDetails, null);
                        c00022.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(str24);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str22);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(str18);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(text);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str19);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(movieDetailsResponse);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(movieDetails);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str23);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str21);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(str25);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(num2);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(num3);
                        c00022.L$15 = SpillingKt.nullOutSpilledVariable(list);
                        c00022.L$16 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c00022.L$17 = SpillingKt.nullOutSpilledVariable(list2);
                        c00022.L$18 = SpillingKt.nullOutSpilledVariable(arrayList);
                        Integer num10 = num;
                        c00022.L$19 = num10;
                        c00022.L$20 = num10;
                        c00022.L$21 = num10;
                        c00022.L$22 = num10;
                        c00022.I$0 = i2;
                        c00022.label = 4;
                        objNewMovieLoadResponse = MainAPIKt.newTvSeriesLoadResponse(castleTvProvider2, str23, str17, tvType6, arrayList, c00036, c00022);
                        if (objNewMovieLoadResponse == obj3) {
                            return obj3;
                        }
                        str35 = str17;
                        continuation6 = continuation2;
                        castleTvProvider3 = castleTvProvider2;
                        return (LoadResponse) objNewMovieLoadResponse;
                        e.printStackTrace();
                        return num;
                    }
                    z = true;
                    if (!z) {
                        return num;
                    }
                    value = this.mapper.readValue(strDecryptData, new TypeReference<MovieDetailsResponse>() { // from class: com.cncverse.CastleTvProvider$load$$inlined$readValue$1
                    });
                    str13 = strSubstringAfterLast$default;
                    if (!(value instanceof MovieDetailsResponse)) {
                        ?? Append4 = new StringBuilder().append(str8).append(Reflection.getOrCreateKotlinClass(MovieDetailsResponse.class).getQualifiedName()).append("(non-null)").append(str5);
                        if (value != null) {
                            qualifiedName = Reflection.getOrCreateKotlinClass(value.getClass()).getQualifiedName();
                        } else {
                            qualifiedName = num;
                        }
                        throw new RuntimeJsonMappingException(Append4.append(qualifiedName).toString());
                    }
                    String str514 = str5;
                    movieDetailsResponse = (MovieDetailsResponse) value;
                    data = movieDetailsResponse.getData();
                    title = data.getTitle();
                    if (title == null) {
                        title = "Unknown Title";
                    }
                    coverVerticalImage = data.getCoverVerticalImage();
                    if (coverVerticalImage == null) {
                        coverVerticalImage = data.getCoverHorizontalImage();
                    }
                    str14 = coverVerticalImage;
                    coverHorizontalImage = data.getCoverHorizontalImage();
                    if (coverHorizontalImage == null) {
                        coverHorizontalImage = data.getCoverVerticalImage();
                    }
                    str15 = coverHorizontalImage;
                    briefIntroduction = data.getBriefIntroduction();
                    publishTime = data.getPublishTime();
                    if (publishTime != null) {
                        numBoxInt = Boxing.boxInt(Instant.ofEpochMilli(publishTime.longValue()).atZone(ZoneId.systemDefault()).getYear());
                    } else {
                        numBoxInt = num;
                    }
                    score = data.getScore();
                    if (score != null) {
                        str16 = str2;
                        numBoxInt2 = Boxing.boxInt((int) (score.doubleValue() * ((double) 1000)));
                    } else {
                        str16 = str2;
                        numBoxInt2 = num;
                    }
                    tags = data.getTags();
                    actors = data.getActors();
                    if (actors != null) {
                        list7 = actors;
                        i6 = 0;
                        arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                        list8 = list7;
                        while (r18.hasNext()) {
                            List<Person> list15 = list7;
                            name = person.getName();
                            if (name == null) {
                                name = "";
                            }
                            arrayList2.add(new ActorData(new Actor(name, person.getAvatar()), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                            list7 = list15;
                            list8 = list8;
                            i6 = i6;
                        }
                        r50 = arrayList2;
                    } else {
                        r50 = num;
                    }
                    listEmptyList = CollectionsKt.emptyList();
                    movieType = data.getMovieType();
                    if (movieType == null) {
                        i = 1;
                    } else {
                        i = 1;
                    }
                    if (i == 0) {
                        episodes2 = data.getEpisodes();
                        if (episodes2 != null) {
                            r52 = (ApiEpisode) CollectionsKt.firstOrNull(episodes2);
                        } else {
                            r52 = num;
                        }
                        CastleTvProvider castleTvProvider9 = this;
                        TvType tvType7 = TvType.Movie;
                        StringBuilder sbAppend6 = new StringBuilder().append(data.getId()).append('_');
                        if (r52 != 0) {
                            id = r52.getId();
                        } else {
                            id = num;
                        }
                        String string5 = sbAppend6.append(id).toString();
                        C00045 c00048 = new C00045(str14, str15, briefIntroduction, numBoxInt, numBoxInt2, tags, r50, listEmptyList, r52, null);
                        c00024.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                        c00024.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c00024.L$2 = SpillingKt.nullOutSpilledVariable(str11);
                        c00024.L$3 = SpillingKt.nullOutSpilledVariable(str10);
                        c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse);
                        c00024.L$5 = SpillingKt.nullOutSpilledVariable(text);
                        c00024.L$6 = SpillingKt.nullOutSpilledVariable(strDecryptData);
                        c00024.L$7 = SpillingKt.nullOutSpilledVariable(movieDetailsResponse);
                        c00024.L$8 = SpillingKt.nullOutSpilledVariable(data);
                        c00024.L$9 = SpillingKt.nullOutSpilledVariable(title);
                        c00024.L$10 = SpillingKt.nullOutSpilledVariable(str14);
                        c00024.L$11 = SpillingKt.nullOutSpilledVariable(str15);
                        c00024.L$12 = SpillingKt.nullOutSpilledVariable(briefIntroduction);
                        c00024.L$13 = SpillingKt.nullOutSpilledVariable(numBoxInt);
                        c00024.L$14 = SpillingKt.nullOutSpilledVariable(numBoxInt2);
                        c00024.L$15 = SpillingKt.nullOutSpilledVariable(tags);
                        c00024.L$16 = SpillingKt.nullOutSpilledVariable((Object) r50);
                        c00024.L$17 = SpillingKt.nullOutSpilledVariable(listEmptyList);
                        c00024.L$18 = SpillingKt.nullOutSpilledVariable((Object) r52);
                        c00024.I$0 = i;
                        c00024.label = 5;
                        str2 = str16;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(castleTvProvider9, title, str2, tvType7, string5, c00048, c00024);
                        c00023 = c00024;
                        if (objNewMovieLoadResponse == obj2) {
                            return obj2;
                        }
                        str34 = str2;
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    arrayList = new ArrayList();
                    if (data.getSeasons() != null) {
                        break;
                    }
                    episodes = data.getEpisodes();
                    if (episodes != null) {
                        list3 = episodes;
                        i3 = 0;
                        i4 = 0;
                        while (it.hasNext()) {
                            Object next6 = it.next();
                            int i13 = i4 + 1;
                            if (i4 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            final ApiEpisode apiEpisode5 = (ApiEpisode) next6;
                            arrayList.add(MainAPIKt.newEpisode(this, new StringBuilder().append(data.getId()).append('_').append(apiEpisode5.getId()).toString(), new Function1() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda7
                                public final Object invoke(Object obj10) {
                                    return CastleTvProvider.load$lambda$3$0(apiEpisode5, i4, data, (Episode) obj10);
                                }
                            }));
                            i4 = i13;
                            list3 = list3;
                            i3 = i3;
                        }
                        Unit unit7 = Unit.INSTANCE;
                    }
                    continuation2 = continuation;
                    movieDetails = data;
                    str17 = str16;
                    c00022 = c00024;
                    str18 = str10;
                    str19 = strDecryptData;
                    str20 = str14;
                    str21 = str15;
                    num2 = numBoxInt;
                    num3 = numBoxInt2;
                    list = tags;
                    r24 = r50;
                    list2 = listEmptyList;
                    i2 = i;
                    obj3 = obj2;
                    str22 = str11;
                    str23 = title;
                    castleTvProvider2 = this;
                    str24 = str13;
                    str25 = briefIntroduction;
                    TvType tvType8 = TvType.TvSeries;
                    C00034 c00037 = new C00034(str20, str21, str25, num2, num3, list, r24, list2, movieDetails, null);
                    c00022.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str24);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str22);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(str18);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(text);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str19);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(movieDetailsResponse);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(movieDetails);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str23);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str21);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(str25);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(num2);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(num3);
                    c00022.L$15 = SpillingKt.nullOutSpilledVariable(list);
                    c00022.L$16 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c00022.L$17 = SpillingKt.nullOutSpilledVariable(list2);
                    c00022.L$18 = SpillingKt.nullOutSpilledVariable(arrayList);
                    Integer num11 = num;
                    c00022.L$19 = num11;
                    c00022.L$20 = num11;
                    c00022.L$21 = num11;
                    c00022.L$22 = num11;
                    c00022.I$0 = i2;
                    c00022.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newTvSeriesLoadResponse(castleTvProvider2, str23, str17, tvType8, arrayList, c00037, c00022);
                    if (objNewMovieLoadResponse == obj3) {
                        return obj3;
                    }
                    str35 = str17;
                    continuation6 = continuation2;
                    castleTvProvider3 = castleTvProvider2;
                    return (LoadResponse) objNewMovieLoadResponse;
                    e.printStackTrace();
                    return num;
                case 2:
                    String str60 = (String) c00024.L$3;
                    String str61 = (String) c00024.L$2;
                    String str62 = (String) c00024.L$1;
                    String str63 = (String) c00024.L$0;
                    ResultKt.throwOnFailure(objNewMovieLoadResponse);
                    str10 = str60;
                    strSubstringAfterLast$default = str62;
                    obj = objNewMovieLoadResponse;
                    str5 = " but was ";
                    str8 = "Deserialized value did not match the specified type; specified ";
                    str6 = "&packageName=com.external.castle";
                    str7 = "/film-api/v1.9.9/movie?channel=IndiaA&clientType=1&clientType=1&lang=en-US&movieId=";
                    num = null;
                    str11 = str61;
                    str2 = str63;
                    obj2 = coroutine_suspended;
                    niceResponse = (NiceResponse) objNewMovieLoadResponse;
                    text = niceResponse.getText();
                    str12 = text;
                    if (str12 != null) {
                        if (!StringsKt.isBlank(str12)) {
                            z = false;
                        }
                        if (!z) {
                            return num;
                        }
                        value = this.mapper.readValue(strDecryptData, new TypeReference<MovieDetailsResponse>() { // from class: com.cncverse.CastleTvProvider$load$$inlined$readValue$1
                        });
                        str13 = strSubstringAfterLast$default;
                        if (!(value instanceof MovieDetailsResponse)) {
                            ?? Append5 = new StringBuilder().append(str8).append(Reflection.getOrCreateKotlinClass(MovieDetailsResponse.class).getQualifiedName()).append("(non-null)").append(str5);
                            if (value != null) {
                                qualifiedName = Reflection.getOrCreateKotlinClass(value.getClass()).getQualifiedName();
                            } else {
                                qualifiedName = num;
                            }
                            throw new RuntimeJsonMappingException(Append5.append(qualifiedName).toString());
                        }
                        String str515 = str5;
                        movieDetailsResponse = (MovieDetailsResponse) value;
                        data = movieDetailsResponse.getData();
                        title = data.getTitle();
                        if (title == null) {
                            title = "Unknown Title";
                        }
                        coverVerticalImage = data.getCoverVerticalImage();
                        if (coverVerticalImage == null) {
                            coverVerticalImage = data.getCoverHorizontalImage();
                        }
                        str14 = coverVerticalImage;
                        coverHorizontalImage = data.getCoverHorizontalImage();
                        if (coverHorizontalImage == null) {
                            coverHorizontalImage = data.getCoverVerticalImage();
                        }
                        str15 = coverHorizontalImage;
                        briefIntroduction = data.getBriefIntroduction();
                        publishTime = data.getPublishTime();
                        if (publishTime != null) {
                            numBoxInt = Boxing.boxInt(Instant.ofEpochMilli(publishTime.longValue()).atZone(ZoneId.systemDefault()).getYear());
                        } else {
                            numBoxInt = num;
                        }
                        score = data.getScore();
                        if (score != null) {
                            str16 = str2;
                            numBoxInt2 = Boxing.boxInt((int) (score.doubleValue() * ((double) 1000)));
                        } else {
                            str16 = str2;
                            numBoxInt2 = num;
                        }
                        tags = data.getTags();
                        actors = data.getActors();
                        if (actors != null) {
                            list7 = actors;
                            i6 = 0;
                            arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                            list8 = list7;
                            while (r18.hasNext()) {
                                List<Person> list16 = list7;
                                name = person.getName();
                                if (name == null) {
                                    name = "";
                                }
                                arrayList2.add(new ActorData(new Actor(name, person.getAvatar()), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                                list7 = list16;
                                list8 = list8;
                                i6 = i6;
                            }
                            r50 = arrayList2;
                        } else {
                            r50 = num;
                        }
                        listEmptyList = CollectionsKt.emptyList();
                        movieType = data.getMovieType();
                        if (movieType == null) {
                            i = 1;
                        } else {
                            i = 1;
                        }
                        if (i == 0) {
                            episodes2 = data.getEpisodes();
                            if (episodes2 != null) {
                                r52 = (ApiEpisode) CollectionsKt.firstOrNull(episodes2);
                            } else {
                                r52 = num;
                            }
                            CastleTvProvider castleTvProvider10 = this;
                            TvType tvType9 = TvType.Movie;
                            StringBuilder sbAppend7 = new StringBuilder().append(data.getId()).append('_');
                            if (r52 != 0) {
                                id = r52.getId();
                            } else {
                                id = num;
                            }
                            String string6 = sbAppend7.append(id).toString();
                            C00045 c00049 = new C00045(str14, str15, briefIntroduction, numBoxInt, numBoxInt2, tags, r50, listEmptyList, r52, null);
                            c00024.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                            c00024.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                            c00024.L$2 = SpillingKt.nullOutSpilledVariable(str11);
                            c00024.L$3 = SpillingKt.nullOutSpilledVariable(str10);
                            c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse);
                            c00024.L$5 = SpillingKt.nullOutSpilledVariable(text);
                            c00024.L$6 = SpillingKt.nullOutSpilledVariable(strDecryptData);
                            c00024.L$7 = SpillingKt.nullOutSpilledVariable(movieDetailsResponse);
                            c00024.L$8 = SpillingKt.nullOutSpilledVariable(data);
                            c00024.L$9 = SpillingKt.nullOutSpilledVariable(title);
                            c00024.L$10 = SpillingKt.nullOutSpilledVariable(str14);
                            c00024.L$11 = SpillingKt.nullOutSpilledVariable(str15);
                            c00024.L$12 = SpillingKt.nullOutSpilledVariable(briefIntroduction);
                            c00024.L$13 = SpillingKt.nullOutSpilledVariable(numBoxInt);
                            c00024.L$14 = SpillingKt.nullOutSpilledVariable(numBoxInt2);
                            c00024.L$15 = SpillingKt.nullOutSpilledVariable(tags);
                            c00024.L$16 = SpillingKt.nullOutSpilledVariable((Object) r50);
                            c00024.L$17 = SpillingKt.nullOutSpilledVariable(listEmptyList);
                            c00024.L$18 = SpillingKt.nullOutSpilledVariable((Object) r52);
                            c00024.I$0 = i;
                            c00024.label = 5;
                            str2 = str16;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(castleTvProvider10, title, str2, tvType9, string6, c00049, c00024);
                            c00023 = c00024;
                            if (objNewMovieLoadResponse == obj2) {
                                return obj2;
                            }
                            str34 = str2;
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        arrayList = new ArrayList();
                        if (data.getSeasons() != null) {
                            break;
                        }
                        episodes = data.getEpisodes();
                        if (episodes != null) {
                            list3 = episodes;
                            i3 = 0;
                            i4 = 0;
                            while (it.hasNext()) {
                                Object next7 = it.next();
                                int i14 = i4 + 1;
                                if (i4 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                final ApiEpisode apiEpisode6 = (ApiEpisode) next7;
                                arrayList.add(MainAPIKt.newEpisode(this, new StringBuilder().append(data.getId()).append('_').append(apiEpisode6.getId()).toString(), new Function1() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda7
                                    public final Object invoke(Object obj10) {
                                        return CastleTvProvider.load$lambda$3$0(apiEpisode6, i4, data, (Episode) obj10);
                                    }
                                }));
                                i4 = i14;
                                list3 = list3;
                                i3 = i3;
                            }
                            Unit unit8 = Unit.INSTANCE;
                        }
                        continuation2 = continuation;
                        movieDetails = data;
                        str17 = str16;
                        c00022 = c00024;
                        str18 = str10;
                        str19 = strDecryptData;
                        str20 = str14;
                        str21 = str15;
                        num2 = numBoxInt;
                        num3 = numBoxInt2;
                        list = tags;
                        r24 = r50;
                        list2 = listEmptyList;
                        i2 = i;
                        obj3 = obj2;
                        str22 = str11;
                        str23 = title;
                        castleTvProvider2 = this;
                        str24 = str13;
                        str25 = briefIntroduction;
                        TvType tvType10 = TvType.TvSeries;
                        C00034 c00038 = new C00034(str20, str21, str25, num2, num3, list, r24, list2, movieDetails, null);
                        c00022.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(str24);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str22);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(str18);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(text);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str19);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(movieDetailsResponse);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(movieDetails);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str23);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str21);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(str25);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(num2);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(num3);
                        c00022.L$15 = SpillingKt.nullOutSpilledVariable(list);
                        c00022.L$16 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c00022.L$17 = SpillingKt.nullOutSpilledVariable(list2);
                        c00022.L$18 = SpillingKt.nullOutSpilledVariable(arrayList);
                        Integer num12 = num;
                        c00022.L$19 = num12;
                        c00022.L$20 = num12;
                        c00022.L$21 = num12;
                        c00022.L$22 = num12;
                        c00022.I$0 = i2;
                        c00022.label = 4;
                        objNewMovieLoadResponse = MainAPIKt.newTvSeriesLoadResponse(castleTvProvider2, str23, str17, tvType10, arrayList, c00038, c00022);
                        if (objNewMovieLoadResponse == obj3) {
                            return obj3;
                        }
                        str35 = str17;
                        continuation6 = continuation2;
                        castleTvProvider3 = castleTvProvider2;
                        return (LoadResponse) objNewMovieLoadResponse;
                        e.printStackTrace();
                        return num;
                    }
                    z = true;
                    if (!z) {
                        return num;
                    }
                    value = this.mapper.readValue(strDecryptData, new TypeReference<MovieDetailsResponse>() { // from class: com.cncverse.CastleTvProvider$load$$inlined$readValue$1
                    });
                    str13 = strSubstringAfterLast$default;
                    if (!(value instanceof MovieDetailsResponse)) {
                        ?? Append6 = new StringBuilder().append(str8).append(Reflection.getOrCreateKotlinClass(MovieDetailsResponse.class).getQualifiedName()).append("(non-null)").append(str5);
                        if (value != null) {
                            qualifiedName = Reflection.getOrCreateKotlinClass(value.getClass()).getQualifiedName();
                        } else {
                            qualifiedName = num;
                        }
                        throw new RuntimeJsonMappingException(Append6.append(qualifiedName).toString());
                    }
                    String str516 = str5;
                    movieDetailsResponse = (MovieDetailsResponse) value;
                    data = movieDetailsResponse.getData();
                    title = data.getTitle();
                    if (title == null) {
                        title = "Unknown Title";
                    }
                    coverVerticalImage = data.getCoverVerticalImage();
                    if (coverVerticalImage == null) {
                        coverVerticalImage = data.getCoverHorizontalImage();
                    }
                    str14 = coverVerticalImage;
                    coverHorizontalImage = data.getCoverHorizontalImage();
                    if (coverHorizontalImage == null) {
                        coverHorizontalImage = data.getCoverVerticalImage();
                    }
                    str15 = coverHorizontalImage;
                    briefIntroduction = data.getBriefIntroduction();
                    publishTime = data.getPublishTime();
                    if (publishTime != null) {
                        numBoxInt = Boxing.boxInt(Instant.ofEpochMilli(publishTime.longValue()).atZone(ZoneId.systemDefault()).getYear());
                    } else {
                        numBoxInt = num;
                    }
                    score = data.getScore();
                    if (score != null) {
                        str16 = str2;
                        numBoxInt2 = Boxing.boxInt((int) (score.doubleValue() * ((double) 1000)));
                    } else {
                        str16 = str2;
                        numBoxInt2 = num;
                    }
                    tags = data.getTags();
                    actors = data.getActors();
                    if (actors != null) {
                        list7 = actors;
                        i6 = 0;
                        arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                        list8 = list7;
                        while (r18.hasNext()) {
                            List<Person> list17 = list7;
                            name = person.getName();
                            if (name == null) {
                                name = "";
                            }
                            arrayList2.add(new ActorData(new Actor(name, person.getAvatar()), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                            list7 = list17;
                            list8 = list8;
                            i6 = i6;
                        }
                        r50 = arrayList2;
                    } else {
                        r50 = num;
                    }
                    listEmptyList = CollectionsKt.emptyList();
                    movieType = data.getMovieType();
                    if (movieType == null) {
                        i = 1;
                    } else {
                        i = 1;
                    }
                    if (i == 0) {
                        episodes2 = data.getEpisodes();
                        if (episodes2 != null) {
                            r52 = (ApiEpisode) CollectionsKt.firstOrNull(episodes2);
                        } else {
                            r52 = num;
                        }
                        CastleTvProvider castleTvProvider11 = this;
                        TvType tvType11 = TvType.Movie;
                        StringBuilder sbAppend8 = new StringBuilder().append(data.getId()).append('_');
                        if (r52 != 0) {
                            id = r52.getId();
                        } else {
                            id = num;
                        }
                        String string7 = sbAppend8.append(id).toString();
                        C00045 c000410 = new C00045(str14, str15, briefIntroduction, numBoxInt, numBoxInt2, tags, r50, listEmptyList, r52, null);
                        c00024.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                        c00024.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c00024.L$2 = SpillingKt.nullOutSpilledVariable(str11);
                        c00024.L$3 = SpillingKt.nullOutSpilledVariable(str10);
                        c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse);
                        c00024.L$5 = SpillingKt.nullOutSpilledVariable(text);
                        c00024.L$6 = SpillingKt.nullOutSpilledVariable(strDecryptData);
                        c00024.L$7 = SpillingKt.nullOutSpilledVariable(movieDetailsResponse);
                        c00024.L$8 = SpillingKt.nullOutSpilledVariable(data);
                        c00024.L$9 = SpillingKt.nullOutSpilledVariable(title);
                        c00024.L$10 = SpillingKt.nullOutSpilledVariable(str14);
                        c00024.L$11 = SpillingKt.nullOutSpilledVariable(str15);
                        c00024.L$12 = SpillingKt.nullOutSpilledVariable(briefIntroduction);
                        c00024.L$13 = SpillingKt.nullOutSpilledVariable(numBoxInt);
                        c00024.L$14 = SpillingKt.nullOutSpilledVariable(numBoxInt2);
                        c00024.L$15 = SpillingKt.nullOutSpilledVariable(tags);
                        c00024.L$16 = SpillingKt.nullOutSpilledVariable((Object) r50);
                        c00024.L$17 = SpillingKt.nullOutSpilledVariable(listEmptyList);
                        c00024.L$18 = SpillingKt.nullOutSpilledVariable((Object) r52);
                        c00024.I$0 = i;
                        c00024.label = 5;
                        str2 = str16;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(castleTvProvider11, title, str2, tvType11, string7, c000410, c00024);
                        c00023 = c00024;
                        if (objNewMovieLoadResponse == obj2) {
                            return obj2;
                        }
                        str34 = str2;
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    arrayList = new ArrayList();
                    if (data.getSeasons() != null) {
                        break;
                    }
                    episodes = data.getEpisodes();
                    if (episodes != null) {
                        list3 = episodes;
                        i3 = 0;
                        i4 = 0;
                        while (it.hasNext()) {
                            Object next8 = it.next();
                            int i15 = i4 + 1;
                            if (i4 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            final ApiEpisode apiEpisode7 = (ApiEpisode) next8;
                            arrayList.add(MainAPIKt.newEpisode(this, new StringBuilder().append(data.getId()).append('_').append(apiEpisode7.getId()).toString(), new Function1() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda7
                                public final Object invoke(Object obj10) {
                                    return CastleTvProvider.load$lambda$3$0(apiEpisode7, i4, data, (Episode) obj10);
                                }
                            }));
                            i4 = i15;
                            list3 = list3;
                            i3 = i3;
                        }
                        Unit unit9 = Unit.INSTANCE;
                    }
                    continuation2 = continuation;
                    movieDetails = data;
                    str17 = str16;
                    c00022 = c00024;
                    str18 = str10;
                    str19 = strDecryptData;
                    str20 = str14;
                    str21 = str15;
                    num2 = numBoxInt;
                    num3 = numBoxInt2;
                    list = tags;
                    r24 = r50;
                    list2 = listEmptyList;
                    i2 = i;
                    obj3 = obj2;
                    str22 = str11;
                    str23 = title;
                    castleTvProvider2 = this;
                    str24 = str13;
                    str25 = briefIntroduction;
                    TvType tvType12 = TvType.TvSeries;
                    C00034 c00039 = new C00034(str20, str21, str25, num2, num3, list, r24, list2, movieDetails, null);
                    c00022.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str24);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str22);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(str18);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(text);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str19);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(movieDetailsResponse);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(movieDetails);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str23);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str21);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(str25);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(num2);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(num3);
                    c00022.L$15 = SpillingKt.nullOutSpilledVariable(list);
                    c00022.L$16 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c00022.L$17 = SpillingKt.nullOutSpilledVariable(list2);
                    c00022.L$18 = SpillingKt.nullOutSpilledVariable(arrayList);
                    Integer num13 = num;
                    c00022.L$19 = num13;
                    c00022.L$20 = num13;
                    c00022.L$21 = num13;
                    c00022.L$22 = num13;
                    c00022.I$0 = i2;
                    c00022.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newTvSeriesLoadResponse(castleTvProvider2, str23, str17, tvType12, arrayList, c00039, c00022);
                    if (objNewMovieLoadResponse == obj3) {
                        return obj3;
                    }
                    str35 = str17;
                    continuation6 = continuation2;
                    castleTvProvider3 = castleTvProvider2;
                    return (LoadResponse) objNewMovieLoadResponse;
                    e.printStackTrace();
                    return num;
                case 3:
                    i8 = c00024.I$1;
                    int i16 = c00024.I$0;
                    String str64 = (String) c00024.L$22;
                    String str65 = (String) c00024.L$21;
                    Iterator<Season> it5 = (Iterator) c00024.L$19;
                    List list18 = (List) c00024.L$18;
                    list9 = (List) c00024.L$17;
                    List list19 = (List) c00024.L$16;
                    List<String> list20 = (List) c00024.L$15;
                    num7 = (Integer) c00024.L$14;
                    num6 = (Integer) c00024.L$13;
                    String str66 = (String) c00024.L$12;
                    String str67 = (String) c00024.L$11;
                    str43 = (String) c00024.L$10;
                    str41 = (String) c00024.L$9;
                    movieDetails3 = (MovieDetails) c00024.L$8;
                    movieDetailsResponse2 = (MovieDetailsResponse) c00024.L$7;
                    str19 = (String) c00024.L$6;
                    str29 = (String) c00024.L$5;
                    niceResponse2 = (NiceResponse) c00024.L$4;
                    str18 = (String) c00024.L$3;
                    String str68 = (String) c00024.L$2;
                    str26 = (String) c00024.L$1;
                    String str69 = (String) c00024.L$0;
                    try {
                        ResultKt.throwOnFailure(objNewMovieLoadResponse);
                        obj6 = coroutine_suspended;
                        str7 = "/film-api/v1.9.9/movie?channel=IndiaA&clientType=1&clientType=1&lang=en-US&movieId=";
                        i7 = i16;
                        str46 = str64;
                        r11 = list19;
                        str44 = str66;
                        obj7 = objNewMovieLoadResponse;
                        str28 = "Deserialized value did not match the specified type; specified ";
                        it3 = it5;
                        list11 = list18;
                        str38 = "&packageName=com.external.castle";
                        list10 = list20;
                        str16 = str69;
                        str27 = " but was ";
                        castleTvProvider5 = this;
                        str45 = str65;
                        str40 = str67;
                        str42 = str68;
                        num = null;
                        while (true) {
                            if (it2.hasNext()) {
                                String str517 = str31;
                                String str518 = str32;
                                String str519 = str30;
                                C00021 c00028 = c00024;
                                obj3 = obj5;
                                Unit unit10 = Unit.INSTANCE;
                                obj = obj4;
                                str21 = str33;
                                movieDetails = movieDetails2;
                                arrayList = list6;
                                num2 = num4;
                                list2 = list5;
                                str17 = str16;
                                r24 = r11;
                                list = list4;
                                num3 = num5;
                                i2 = i5;
                                castleTvProvider2 = castleTvProvider;
                                str20 = str517;
                                str23 = str519;
                                movieDetailsResponse = movieDetailsResponse2;
                                text = str29;
                                niceResponse = niceResponse2;
                                str24 = str26;
                                c00022 = c00028;
                                continuation2 = continuation3;
                                str25 = str518;
                                TvType tvType13 = TvType.TvSeries;
                                C00034 c000310 = new C00034(str20, str21, str25, num2, num3, list, r24, list2, movieDetails, null);
                                c00022.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                                c00022.L$1 = SpillingKt.nullOutSpilledVariable(str24);
                                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str22);
                                c00022.L$3 = SpillingKt.nullOutSpilledVariable(str18);
                                c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                c00022.L$5 = SpillingKt.nullOutSpilledVariable(text);
                                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str19);
                                c00022.L$7 = SpillingKt.nullOutSpilledVariable(movieDetailsResponse);
                                c00022.L$8 = SpillingKt.nullOutSpilledVariable(movieDetails);
                                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str23);
                                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str21);
                                c00022.L$12 = SpillingKt.nullOutSpilledVariable(str25);
                                c00022.L$13 = SpillingKt.nullOutSpilledVariable(num2);
                                c00022.L$14 = SpillingKt.nullOutSpilledVariable(num3);
                                c00022.L$15 = SpillingKt.nullOutSpilledVariable(list);
                                c00022.L$16 = SpillingKt.nullOutSpilledVariable((Object) r24);
                                c00022.L$17 = SpillingKt.nullOutSpilledVariable(list2);
                                c00022.L$18 = SpillingKt.nullOutSpilledVariable(arrayList);
                                Integer num14 = num;
                                c00022.L$19 = num14;
                                c00022.L$20 = num14;
                                c00022.L$21 = num14;
                                c00022.L$22 = num14;
                                c00022.I$0 = i2;
                                c00022.label = 4;
                                objNewMovieLoadResponse = MainAPIKt.newTvSeriesLoadResponse(castleTvProvider2, str23, str17, tvType13, arrayList, c000310, c00022);
                                if (objNewMovieLoadResponse == obj3) {
                                    return obj3;
                                }
                                str35 = str17;
                                continuation6 = continuation2;
                                castleTvProvider3 = castleTvProvider2;
                                return (LoadResponse) objNewMovieLoadResponse;
                            }
                            Season next9 = it2.next();
                            movieId = next9.getMovieId();
                            if (movieId != null) {
                            }
                            obj5 = obj5;
                            str6 = str6;
                            it2 = it2;
                            str31 = str31;
                            str30 = str30;
                            str32 = str32;
                            str28 = str28;
                            str27 = str27;
                            c00024 = c00024;
                            e.printStackTrace();
                            return num;
                        }
                    } catch (Exception e20) {
                        castleTvProvider4 = this;
                        continuation4 = continuation6;
                        obj6 = coroutine_suspended;
                        str37 = " but was ";
                        str36 = "Deserialized value did not match the specified type; specified ";
                        str7 = "/film-api/v1.9.9/movie?channel=IndiaA&clientType=1&clientType=1&lang=en-US&movieId=";
                        i7 = i16;
                        list11 = list18;
                        r11 = list19;
                        str31 = str43;
                        str30 = str41;
                        movieDetails2 = movieDetails3;
                        str39 = str68;
                        it3 = it5;
                        list10 = list20;
                        str40 = str67;
                        num = null;
                        str38 = "&packageName=com.external.castle";
                        str16 = str69;
                        str32 = str66;
                        obj4 = objNewMovieLoadResponse;
                        str33 = str40;
                        list6 = list11;
                        list4 = list10;
                        str6 = str38;
                        it2 = it3;
                        obj5 = obj6;
                        i5 = i7;
                        list5 = list9;
                        num5 = num7;
                        num4 = num6;
                        castleTvProvider = castleTvProvider4;
                        str22 = str39;
                        str28 = str36;
                        continuation3 = continuation4;
                        str27 = str37;
                        r11 = r11;
                        while (true) {
                            if (it2.hasNext()) {
                                String str5110 = str31;
                                String str5111 = str32;
                                String str5112 = str30;
                                C00021 c00029 = c00024;
                                obj3 = obj5;
                                Unit unit11 = Unit.INSTANCE;
                                obj = obj4;
                                str21 = str33;
                                movieDetails = movieDetails2;
                                arrayList = list6;
                                num2 = num4;
                                list2 = list5;
                                str17 = str16;
                                r24 = r11;
                                list = list4;
                                num3 = num5;
                                i2 = i5;
                                castleTvProvider2 = castleTvProvider;
                                str20 = str5110;
                                str23 = str5112;
                                movieDetailsResponse = movieDetailsResponse2;
                                text = str29;
                                niceResponse = niceResponse2;
                                str24 = str26;
                                c00022 = c00029;
                                continuation2 = continuation3;
                                str25 = str5111;
                                TvType tvType14 = TvType.TvSeries;
                                C00034 c000311 = new C00034(str20, str21, str25, num2, num3, list, r24, list2, movieDetails, null);
                                c00022.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                                c00022.L$1 = SpillingKt.nullOutSpilledVariable(str24);
                                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str22);
                                c00022.L$3 = SpillingKt.nullOutSpilledVariable(str18);
                                c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                c00022.L$5 = SpillingKt.nullOutSpilledVariable(text);
                                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str19);
                                c00022.L$7 = SpillingKt.nullOutSpilledVariable(movieDetailsResponse);
                                c00022.L$8 = SpillingKt.nullOutSpilledVariable(movieDetails);
                                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str23);
                                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str21);
                                c00022.L$12 = SpillingKt.nullOutSpilledVariable(str25);
                                c00022.L$13 = SpillingKt.nullOutSpilledVariable(num2);
                                c00022.L$14 = SpillingKt.nullOutSpilledVariable(num3);
                                c00022.L$15 = SpillingKt.nullOutSpilledVariable(list);
                                c00022.L$16 = SpillingKt.nullOutSpilledVariable((Object) r24);
                                c00022.L$17 = SpillingKt.nullOutSpilledVariable(list2);
                                c00022.L$18 = SpillingKt.nullOutSpilledVariable(arrayList);
                                Integer num15 = num;
                                c00022.L$19 = num15;
                                c00022.L$20 = num15;
                                c00022.L$21 = num15;
                                c00022.L$22 = num15;
                                c00022.I$0 = i2;
                                c00022.label = 4;
                                objNewMovieLoadResponse = MainAPIKt.newTvSeriesLoadResponse(castleTvProvider2, str23, str17, tvType14, arrayList, c000311, c00022);
                                if (objNewMovieLoadResponse == obj3) {
                                    return obj3;
                                }
                                str35 = str17;
                                continuation6 = continuation2;
                                castleTvProvider3 = castleTvProvider2;
                                return (LoadResponse) objNewMovieLoadResponse;
                            }
                            Season next10 = it2.next();
                            movieId = next10.getMovieId();
                            if (movieId != null) {
                            }
                            obj5 = obj5;
                            str6 = str6;
                            it2 = it2;
                            str31 = str31;
                            str30 = str30;
                            str32 = str32;
                            str28 = str28;
                            str27 = str27;
                            c00024 = c00024;
                            e.printStackTrace();
                            return num;
                        }
                    }
                    String text3 = ((NiceResponse) obj7).getText();
                    str47 = text3;
                    if (str47 != null) {
                        if (StringsKt.isBlank(str47)) {
                            z2 = false;
                        }
                        if (z2) {
                            str39 = str42;
                            castleTvProvider4 = castleTvProvider5;
                            continuation5 = continuation6;
                            str36 = str28;
                            str48 = str27;
                        } else {
                            str39 = str42;
                            castleTvProvider4 = castleTvProvider5;
                            continuation5 = continuation6;
                            str36 = str28;
                            str48 = str27;
                        }
                        str32 = str44;
                        obj4 = objNewMovieLoadResponse;
                        str33 = str40;
                        list6 = list11;
                        list4 = list10;
                        str6 = str38;
                        it2 = it3;
                        obj5 = obj6;
                        i5 = i7;
                        list5 = list9;
                        num5 = num7;
                        num4 = num6;
                        str31 = str43;
                        str30 = str41;
                        movieDetails2 = movieDetails3;
                        castleTvProvider = castleTvProvider4;
                        str22 = str39;
                        str28 = str36;
                        continuation3 = continuation5;
                        str27 = str48;
                        r11 = r11;
                        while (true) {
                            if (it2.hasNext()) {
                                String str5113 = str31;
                                String str5114 = str32;
                                String str5115 = str30;
                                C00021 c000210 = c00024;
                                obj3 = obj5;
                                Unit unit12 = Unit.INSTANCE;
                                obj = obj4;
                                str21 = str33;
                                movieDetails = movieDetails2;
                                arrayList = list6;
                                num2 = num4;
                                list2 = list5;
                                str17 = str16;
                                r24 = r11;
                                list = list4;
                                num3 = num5;
                                i2 = i5;
                                castleTvProvider2 = castleTvProvider;
                                str20 = str5113;
                                str23 = str5115;
                                movieDetailsResponse = movieDetailsResponse2;
                                text = str29;
                                niceResponse = niceResponse2;
                                str24 = str26;
                                c00022 = c000210;
                                continuation2 = continuation3;
                                str25 = str5114;
                                TvType tvType15 = TvType.TvSeries;
                                C00034 c000312 = new C00034(str20, str21, str25, num2, num3, list, r24, list2, movieDetails, null);
                                c00022.L$0 = SpillingKt.nullOutSpilledVariable(str17);
                                c00022.L$1 = SpillingKt.nullOutSpilledVariable(str24);
                                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str22);
                                c00022.L$3 = SpillingKt.nullOutSpilledVariable(str18);
                                c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                c00022.L$5 = SpillingKt.nullOutSpilledVariable(text);
                                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str19);
                                c00022.L$7 = SpillingKt.nullOutSpilledVariable(movieDetailsResponse);
                                c00022.L$8 = SpillingKt.nullOutSpilledVariable(movieDetails);
                                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str23);
                                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str21);
                                c00022.L$12 = SpillingKt.nullOutSpilledVariable(str25);
                                c00022.L$13 = SpillingKt.nullOutSpilledVariable(num2);
                                c00022.L$14 = SpillingKt.nullOutSpilledVariable(num3);
                                c00022.L$15 = SpillingKt.nullOutSpilledVariable(list);
                                c00022.L$16 = SpillingKt.nullOutSpilledVariable((Object) r24);
                                c00022.L$17 = SpillingKt.nullOutSpilledVariable(list2);
                                c00022.L$18 = SpillingKt.nullOutSpilledVariable(arrayList);
                                Integer num16 = num;
                                c00022.L$19 = num16;
                                c00022.L$20 = num16;
                                c00022.L$21 = num16;
                                c00022.L$22 = num16;
                                c00022.I$0 = i2;
                                c00022.label = 4;
                                objNewMovieLoadResponse = MainAPIKt.newTvSeriesLoadResponse(castleTvProvider2, str23, str17, tvType15, arrayList, c000312, c00022);
                                if (objNewMovieLoadResponse == obj3) {
                                    return obj3;
                                }
                                str35 = str17;
                                continuation6 = continuation2;
                                castleTvProvider3 = castleTvProvider2;
                                return (LoadResponse) objNewMovieLoadResponse;
                            }
                            Season next11 = it2.next();
                            movieId = next11.getMovieId();
                            if (movieId != null) {
                            }
                            obj5 = obj5;
                            str6 = str6;
                            it2 = it2;
                            str31 = str31;
                            str30 = str30;
                            str32 = str32;
                            str28 = str28;
                            str27 = str27;
                            c00024 = c00024;
                            e.printStackTrace();
                            return num;
                        }
                    }
                    z2 = true;
                    if (z2) {
                        str39 = str42;
                        castleTvProvider4 = castleTvProvider5;
                        continuation5 = continuation6;
                        str36 = str28;
                        str48 = str27;
                    } else {
                        str39 = str42;
                        castleTvProvider4 = castleTvProvider5;
                        continuation5 = continuation6;
                        str36 = str28;
                        str48 = str27;
                    }
                    str32 = str44;
                    obj4 = objNewMovieLoadResponse;
                    str33 = str40;
                    list6 = list11;
                    list4 = list10;
                    str6 = str38;
                    it2 = it3;
                    obj5 = obj6;
                    i5 = i7;
                    list5 = list9;
                    num5 = num7;
                    num4 = num6;
                    str31 = str43;
                    str30 = str41;
                    movieDetails2 = movieDetails3;
                    castleTvProvider = castleTvProvider4;
                    str22 = str39;
                    str28 = str36;
                    continuation3 = continuation5;
                    str27 = str48;
                    r11 = r11;
                case 4:
                    int i17 = c00024.I$0;
                    str35 = (String) c00024.L$0;
                    ResultKt.throwOnFailure(objNewMovieLoadResponse);
                    obj = objNewMovieLoadResponse;
                    castleTvProvider3 = this;
                    return (LoadResponse) objNewMovieLoadResponse;
                case 5:
                    int i18 = c00024.I$0;
                    str34 = (String) c00024.L$0;
                    ResultKt.throwOnFailure(objNewMovieLoadResponse);
                    obj = objNewMovieLoadResponse;
                    num = null;
                    c00023 = c00024;
                    return (LoadResponse) objNewMovieLoadResponse;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e21) {
            e = e21;
            castleTvProvider = this;
            str2 = str49;
            continuation2 = continuation6;
            num = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2$0(ApiEpisode $episode, List $allEpisodes, int $seasonNumber, Episode $this$newEpisode) {
        String title = $episode.getTitle();
        if (title == null) {
            StringBuilder sbAppend = new StringBuilder().append("Episode ");
            Integer number = $episode.getNumber();
            title = sbAppend.append(number != null ? number.intValue() : $allEpisodes.size() + 1).toString();
        }
        $this$newEpisode.setName(title);
        $this$newEpisode.setSeason(Integer.valueOf($seasonNumber));
        Integer number2 = $episode.getNumber();
        if (number2 == null) {
            number2 = Integer.valueOf($allEpisodes.size() + 1);
        }
        $this$newEpisode.setEpisode(number2);
        $this$newEpisode.setPosterUrl($episode.getCoverImage());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$3$0(ApiEpisode $episode, int $index, MovieDetails $details, Episode $this$newEpisode) {
        String title = $episode.getTitle();
        if (title == null) {
            StringBuilder sbAppend = new StringBuilder().append("Episode ");
            Integer number = $episode.getNumber();
            title = sbAppend.append(number != null ? number.intValue() : $index + 1).toString();
        }
        $this$newEpisode.setName(title);
        $this$newEpisode.setSeason($details.getSeasonNumber());
        Integer number2 = $episode.getNumber();
        if (number2 == null) {
            number2 = Integer.valueOf($index + 1);
        }
        $this$newEpisode.setEpisode(number2);
        $this$newEpisode.setPosterUrl($episode.getCoverImage());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.cncverse.CastleTvProvider$load$4 */
    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CastleTvProvider$load$4", f = "CastleTvProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00034 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $backgroundPosterUrl;
        final /* synthetic */ MovieDetails $details;
        final /* synthetic */ String $plot;
        final /* synthetic */ String $posterUrl;
        final /* synthetic */ Integer $rating;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00034(String str, String str2, String str3, Integer num, Integer num2, List<String> list, List<ActorData> list2, List<? extends SearchResponse> list3, MovieDetails movieDetails, Continuation<? super C00034> continuation) {
            super(2, continuation);
            this.$posterUrl = str;
            this.$backgroundPosterUrl = str2;
            this.$plot = str3;
            this.$year = num;
            this.$rating = num2;
            this.$tags = list;
            this.$actors = list2;
            this.$recommendations = list3;
            this.$details = movieDetails;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00034 = new C00034(this.$posterUrl, this.$backgroundPosterUrl, this.$plot, this.$year, this.$rating, this.$tags, this.$actors, this.$recommendations, this.$details, continuation);
            c00034.L$0 = obj;
            return c00034;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ShowStatus showStatus;
            ApiEpisode apiEpisode;
            Integer duration;
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$posterUrl);
                    $this$newTvSeriesLoadResponse.setBackgroundPosterUrl(this.$backgroundPosterUrl);
                    $this$newTvSeriesLoadResponse.setPlot(this.$plot);
                    $this$newTvSeriesLoadResponse.setYear(this.$year);
                    $this$newTvSeriesLoadResponse.setScore(Score.Companion.from(this.$rating, 1000));
                    $this$newTvSeriesLoadResponse.setTags(this.$tags);
                    $this$newTvSeriesLoadResponse.setActors(this.$actors);
                    $this$newTvSeriesLoadResponse.setRecommendations(this.$recommendations);
                    List<ApiEpisode> episodes = this.$details.getEpisodes();
                    $this$newTvSeriesLoadResponse.setDuration((episodes == null || (apiEpisode = (ApiEpisode) CollectionsKt.firstOrNull(episodes)) == null || (duration = apiEpisode.getDuration()) == null) ? null : Boxing.boxInt(duration.intValue() / 60));
                    String seasonDescription = this.$details.getSeasonDescription();
                    boolean z = false;
                    if (seasonDescription != null && StringsKt.contains(seasonDescription, "season", true)) {
                        z = true;
                    }
                    if (z) {
                        showStatus = ShowStatus.Ongoing;
                    } else {
                        showStatus = ShowStatus.Completed;
                    }
                    $this$newTvSeriesLoadResponse.setShowStatus(showStatus);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.CastleTvProvider$load$5 */
    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CastleTvProvider$load$5", f = "CastleTvProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00045 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $backgroundPosterUrl;
        final /* synthetic */ ApiEpisode $episode;
        final /* synthetic */ String $plot;
        final /* synthetic */ String $posterUrl;
        final /* synthetic */ Integer $rating;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00045(String str, String str2, String str3, Integer num, Integer num2, List<String> list, List<ActorData> list2, List<? extends SearchResponse> list3, ApiEpisode apiEpisode, Continuation<? super C00045> continuation) {
            super(2, continuation);
            this.$posterUrl = str;
            this.$backgroundPosterUrl = str2;
            this.$plot = str3;
            this.$year = num;
            this.$rating = num2;
            this.$tags = list;
            this.$actors = list2;
            this.$recommendations = list3;
            this.$episode = apiEpisode;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00045 = new C00045(this.$posterUrl, this.$backgroundPosterUrl, this.$plot, this.$year, this.$rating, this.$tags, this.$actors, this.$recommendations, this.$episode, continuation);
            c00045.L$0 = obj;
            return c00045;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Integer duration;
            MovieLoadResponse $this$newMovieLoadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newMovieLoadResponse.setPosterUrl(this.$posterUrl);
                    $this$newMovieLoadResponse.setBackgroundPosterUrl(this.$backgroundPosterUrl);
                    $this$newMovieLoadResponse.setPlot(this.$plot);
                    $this$newMovieLoadResponse.setYear(this.$year);
                    $this$newMovieLoadResponse.setScore(Score.Companion.from(this.$rating, 1000));
                    $this$newMovieLoadResponse.setTags(this.$tags);
                    $this$newMovieLoadResponse.setActors(this.$actors);
                    $this$newMovieLoadResponse.setRecommendations(this.$recommendations);
                    ApiEpisode apiEpisode = this.$episode;
                    $this$newMovieLoadResponse.setDuration((apiEpisode == null || (duration = apiEpisode.getDuration()) == null) ? null : Boxing.boxInt(duration.intValue() / 60));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:461:0x16db A[Catch: Exception -> 0x2282, TRY_LEAVE, TryCatch #79 {Exception -> 0x2282, blocks: (B:459:0x16d5, B:461:0x16db), top: B:904:0x16d5 }] */
    /* JADX WARN: Code duplicated, block: B:493:0x180a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:494:0x180b  */
    /* JADX WARN: Code duplicated, block: B:500:0x1847  */
    /* JADX WARN: Code duplicated, block: B:505:0x186f  */
    /* JADX WARN: Code duplicated, block: B:506:0x187c  */
    /* JADX WARN: Code duplicated, block: B:511:0x18a8  */
    /* JADX WARN: Code duplicated, block: B:512:0x18b1 A[Catch: Exception -> 0x2052, TRY_LEAVE, TryCatch #97 {Exception -> 0x2052, blocks: (B:509:0x188f, B:512:0x18b1), top: B:940:0x188f }] */
    /* JADX WARN: Code duplicated, block: B:516:0x18d1  */
    /* JADX WARN: Code duplicated, block: B:525:0x1901 A[Catch: Exception -> 0x1927, TryCatch #86 {Exception -> 0x1927, blocks: (B:523:0x18fb, B:525:0x1901, B:527:0x1919, B:528:0x1926), top: B:918:0x18fb }] */
    /* JADX WARN: Code duplicated, block: B:526:0x1916  */
    /* JADX WARN: Code duplicated, block: B:535:0x1989  */
    /* JADX WARN: Code duplicated, block: B:538:0x199e A[Catch: Exception -> 0x2026, TRY_LEAVE, TryCatch #87 {Exception -> 0x2026, blocks: (B:536:0x1990, B:538:0x199e), top: B:920:0x1990 }] */
    /* JADX WARN: Code duplicated, block: B:542:0x19ae A[Catch: Exception -> 0x202e, TryCatch #82 {Exception -> 0x202e, blocks: (B:514:0x18c0, B:540:0x19a4, B:542:0x19ae, B:543:0x19b1, B:547:0x19c3, B:548:0x19d4), top: B:910:0x18c0 }] */
    /* JADX WARN: Code duplicated, block: B:543:0x19b1 A[Catch: Exception -> 0x202e, TryCatch #82 {Exception -> 0x202e, blocks: (B:514:0x18c0, B:540:0x19a4, B:542:0x19ae, B:543:0x19b1, B:547:0x19c3, B:548:0x19d4), top: B:910:0x18c0 }] */
    /* JADX WARN: Code duplicated, block: B:544:0x19b4  */
    /* JADX WARN: Code duplicated, block: B:545:0x19b9  */
    /* JADX WARN: Code duplicated, block: B:546:0x19be  */
    /* JADX WARN: Code duplicated, block: B:562:0x1a7e  */
    /* JADX WARN: Code duplicated, block: B:581:0x1b48 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:582:0x1b49  */
    /* JADX WARN: Code duplicated, block: B:646:0x1ebe  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:884:0x19f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:930:0x1840 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Failed to apply debug info
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 91201. Try increasing type updates limit count.
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.requestUpdate(TypeUpdateInfo.java:61)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:298)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyDebugInfo(TypeUpdate.java:77)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:75)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v102 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v144 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v68, names: [data], types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v376, names: [$completion], types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r84v2, names: [data], types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r84v33 */
    /* JADX WARN: Type inference failed for: r84v34 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:236:0x0d00 -> B:439:0x1619). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:263:0x0dd1 -> B:439:0x1619). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:265:0x0deb -> B:439:0x1619). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:267:0x0e07 -> B:439:0x1619). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:269:0x0e25 -> B:439:0x1619). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:325:0x101a -> B:845:0x1046). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:354:0x1155 -> B:810:0x1189). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:363:0x121b -> B:364:0x1244). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:380:0x1331 -> B:439:0x1619). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:382:0x1352 -> B:439:0x1619). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:384:0x1370 -> B:439:0x1619). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:386:0x1396 -> B:439:0x1619). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:388:0x13bc -> B:439:0x1619). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:390:0x13e4 -> B:439:0x1619). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:403:0x1473 -> B:950:0x0ba4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:411:0x14d4 -> B:439:0x1619). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:413:0x14fe -> B:439:0x1619). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:415:0x1528 -> B:439:0x1619). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:417:0x154a -> B:439:0x1619). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:419:0x156c -> B:439:0x1619). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:458:0x16ac -> B:904:0x16d5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:502:0x184b -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:530:0x1928 -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:532:0x1948 -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:534:0x196a -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:557:0x1a19 -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:559:0x1a3b -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:561:0x1a5d -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:588:0x1b87 -> B:902:0x1bad). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:621:0x1cd1 -> B:946:0x1d14). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:632:0x1da6 -> B:633:0x1dd8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:649:0x1eef -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:651:0x1f13 -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:653:0x1f33 -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:655:0x1f55 -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:657:0x1f79 -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:659:0x1f9d -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:661:0x1fc1 -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:670:0x2003 -> B:904:0x16d5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:675:0x2033 -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:677:0x2053 -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:679:0x2076 -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:681:0x209b -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:683:0x20c2 -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:685:0x20e5 -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:687:0x210a -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:689:0x2131 -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:691:0x2158 -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:698:0x21b4 -> B:709:0x2238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:700:0x21db -> B:709:0x2238). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r83, boolean r84, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r85, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r86, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r87) {
        /*
            Method dump skipped, instruction units count: 9120
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.CastleTvProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    /* JADX INFO: renamed from: com.cncverse.CastleTvProvider$loadLinks$3 */
    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CastleTvProvider$loadLinks$3", f = "CastleTvProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00063 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $resolution;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00063(int i, Continuation<? super C00063> continuation) {
            super(2, continuation);
            this.$resolution = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00063 = CastleTvProvider.this.new C00063(this.$resolution, continuation);
            c00063.L$0 = obj;
            return c00063;
        }

        public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
            return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            int i;
            ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newExtractorLink.setHeaders(MapsKt.mapOf(TuplesKt.to("Referer", CastleTvProvider.this.getMainUrl())));
                    switch (this.$resolution) {
                        case 1:
                            i = 480;
                            break;
                        case 2:
                            i = 720;
                            break;
                        case 3:
                            i = 1080;
                            break;
                        default:
                            i = this.$resolution * 240;
                            break;
                    }
                    $this$newExtractorLink.setQuality(i);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.CastleTvProvider$loadLinks$5 */
    /* JADX INFO: compiled from: CastleTvProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CastleTvProvider$loadLinks$5", f = "CastleTvProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00075 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $resolution;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00075(int i, Continuation<? super C00075> continuation) {
            super(2, continuation);
            this.$resolution = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00075 = CastleTvProvider.this.new C00075(this.$resolution, continuation);
            c00075.L$0 = obj;
            return c00075;
        }

        public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
            return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            int i;
            ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newExtractorLink.setHeaders(MapsKt.mapOf(TuplesKt.to("Referer", CastleTvProvider.this.getMainUrl())));
                    switch (this.$resolution) {
                        case 1:
                            i = 480;
                            break;
                        case 2:
                            i = 720;
                            break;
                        case 3:
                            i = 1080;
                            break;
                        default:
                            i = this.$resolution * 240;
                            break;
                    }
                    $this$newExtractorLink.setQuality(i);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void showSubscriptionPopupIfNeeded() {
        final Context ctx = context;
        if (ctx == null || subscriptionPopupShown) {
            return;
        }
        try {
            boolean isTV = Globals.INSTANCE.isLayout(2);
            if (isTV) {
                return;
            }
        } catch (Exception e) {
        }
        SharedPreferences sharedPreferences = ctx.getSharedPreferences("CNCVerseSubscription", 0);
        boolean isSubscribed = Intrinsics.areEqual(sharedPreferences != null ? sharedPreferences.getString("mode", "ads") : null, "subscription");
        if (isSubscribed) {
            return;
        }
        SharedPreferences _dontShowPrefs = ctx.getSharedPreferences("CNCVerseSubscription", 0);
        if (_dontShowPrefs.getBoolean("dont_show_ads_popup", false)) {
            subscriptionPopupShown = true;
        } else {
            subscriptionPopupShown = true;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    CastleTvProvider.showSubscriptionPopupIfNeeded$lambda$0(ctx);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubscriptionPopupIfNeeded$lambda$0(final Context $ctx) {
        try {
            float dp = $ctx.getResources().getDisplayMetrics().density;
            GradientDrawable $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240 = new GradientDrawable();
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240.setColor(Color.parseColor("#1A1A2E"));
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240.setCornerRadius(16.0f * dp);
            LinearLayout root = new LinearLayout($ctx);
            root.setOrientation(1);
            float f = 24;
            root.setPadding((int) (f * dp), (int) (20 * dp), (int) (f * dp), (int) (16 * dp));
            root.setBackground($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240);
            TextView $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242 = new TextView($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setText("📺 You're in Ads Mode");
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setTextColor(-1);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setTextSize(17.0f);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams it = new LinearLayout.LayoutParams(-1, -2);
            it.bottomMargin = (int) (8 * dp);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setLayoutParams(it);
            View divider = new View($ctx);
            divider.setBackgroundColor(Color.parseColor("#2D2D4A"));
            LinearLayout.LayoutParams it2 = new LinearLayout.LayoutParams(-1, 1);
            it2.bottomMargin = (int) (12 * dp);
            divider.setLayoutParams(it2);
            TextView $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244 = new TextView($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setText("All CNCVerse extensions currently run with ads.\n\nSubscribe to remove ads from just ₹20/month.\n\nManage via Settings > Extensions > CNCVerse Cloudstream Repo > Subscription Manager.");
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setTextColor(Color.parseColor("#A0A0A8"));
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setTextSize(14.0f);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setLineSpacing(0.0f, 1.4f);
            LinearLayout.LayoutParams it3 = new LinearLayout.LayoutParams(-1, -2);
            it3.bottomMargin = (int) (18 * dp);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setLayoutParams(it3);
            LinearLayout btnRow = new LinearLayout($ctx);
            btnRow.setOrientation(0);
            btnRow.setGravity(8388613);
            TextView laterTv = new TextView($ctx);
            laterTv.setText("Maybe Later");
            laterTv.setTextColor(Color.parseColor("#808090"));
            laterTv.setTextSize(14.0f);
            float f2 = 10;
            int p = (int) (f2 * dp);
            laterTv.setPadding(p, p, p, p);
            laterTv.setClickable(true);
            laterTv.setFocusable(true);
            TextView subscribeTv = new TextView($ctx);
            subscribeTv.setText("Subscribe Now");
            subscribeTv.setTextColor(Color.parseColor("#A78BFA"));
            subscribeTv.setTextSize(14.0f);
            subscribeTv.setTypeface(Typeface.DEFAULT_BOLD);
            int p2 = (int) (f2 * dp);
            subscribeTv.setPadding(p2, p2, 0, p2);
            subscribeTv.setClickable(true);
            subscribeTv.setFocusable(true);
            LinearLayout $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248 = new LinearLayout($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.setOrientation(0);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.setGravity(8388627);
            LinearLayout.LayoutParams it4 = new LinearLayout.LayoutParams(-1, -2);
            it4.bottomMargin = (int) (f2 * dp);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.setLayoutParams(it4);
            final CheckBox $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249 = new CheckBox($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249.setChecked(false);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#A78BFA")));
            TextView $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410 = new TextView($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setText("Don't show me again");
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setTextColor(Color.parseColor("#A0A0A8"));
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setTextSize(13.0f);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setPadding((int) (6 * dp), 0, 0, 0);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410);
            btnRow.addView(laterTv);
            btnRow.addView(subscribeTv);
            root.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242);
            root.addView(divider);
            root.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244);
            root.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248);
            root.addView(btnRow);
            final AlertDialog dialog = new AlertDialog.Builder($ctx).setView(root).setCancelable(true).create();
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CastleTvProvider.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CastleTvProvider.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
                }
            });
            dialog.show();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubscriptionPopupIfNeeded$lambda$0$11(CheckBox $dontShowCb, Context $ctx, AlertDialog $dialog, View it) {
        if ($dontShowCb.isChecked()) {
            $ctx.getSharedPreferences("CNCVerseSubscription", 0).edit().putBoolean("dont_show_ads_popup", true).apply();
        }
        $dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubscriptionPopupIfNeeded$lambda$0$12(AlertDialog $dialog, Context $ctx, View it) {
        $dialog.dismiss();
        try {
            Intent i = new Intent("android.intent.action.VIEW", Uri.parse("https://cncverse-sub.pages.dev"));
            i.addFlags(268435456);
            $ctx.startActivity(i);
        } catch (Exception e) {
        }
    }

    private final void showTelegramPopup() {
        final Context ctx;
        if (Globals.INSTANCE.isLayout(2) || (ctx = context) == null || telegramPopupShown) {
            return;
        }
        SharedPreferences prefs = ctx.getSharedPreferences("cncverse_prefs", 0);
        if (prefs.getBoolean("telegram_popup_shown", false)) {
            telegramPopupShown = true;
            return;
        }
        telegramPopupShown = true;
        prefs.edit().putBoolean("telegram_popup_shown", true).apply();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                CastleTvProvider.showTelegramPopup$lambda$0(ctx);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTelegramPopup$lambda$0(final Context $ctx) {
        try {
            float dp = $ctx.getResources().getDisplayMetrics().density;
            GradientDrawable $this$showTelegramPopup_u24lambda_u240_u240 = new GradientDrawable();
            $this$showTelegramPopup_u24lambda_u240_u240.setColor(Color.parseColor("#1A1A2E"));
            $this$showTelegramPopup_u24lambda_u240_u240.setCornerRadius(16.0f * dp);
            LinearLayout root = new LinearLayout($ctx);
            root.setOrientation(1);
            float f = 24;
            root.setPadding((int) (f * dp), (int) (20 * dp), (int) (f * dp), (int) (16 * dp));
            root.setBackground($this$showTelegramPopup_u24lambda_u240_u240);
            TextView $this$showTelegramPopup_u24lambda_u240_u242 = new TextView($ctx);
            $this$showTelegramPopup_u24lambda_u240_u242.setText("💬 Join CNCVerse Community");
            $this$showTelegramPopup_u24lambda_u240_u242.setTextColor(-1);
            $this$showTelegramPopup_u24lambda_u240_u242.setTextSize(17.0f);
            $this$showTelegramPopup_u24lambda_u240_u242.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams it = new LinearLayout.LayoutParams(-1, -2);
            float f2 = 10;
            it.bottomMargin = (int) (f2 * dp);
            $this$showTelegramPopup_u24lambda_u240_u242.setLayoutParams(it);
            View dividerV = new View($ctx);
            dividerV.setBackgroundColor(Color.parseColor("#2D2D4A"));
            LinearLayout.LayoutParams it2 = new LinearLayout.LayoutParams(-1, 1);
            it2.bottomMargin = (int) (14 * dp);
            dividerV.setLayoutParams(it2);
            TextView $this$showTelegramPopup_u24lambda_u240_u244 = new TextView($ctx);
            $this$showTelegramPopup_u24lambda_u240_u244.setText("Join our Telegram group to discuss and share your opinion!");
            $this$showTelegramPopup_u24lambda_u240_u244.setTextColor(Color.parseColor("#A0A0A8"));
            $this$showTelegramPopup_u24lambda_u240_u244.setTextSize(14.0f);
            $this$showTelegramPopup_u24lambda_u240_u244.setLineSpacing(0.0f, 1.4f);
            LinearLayout.LayoutParams it3 = new LinearLayout.LayoutParams(-1, -2);
            it3.bottomMargin = (int) (18 * dp);
            $this$showTelegramPopup_u24lambda_u240_u244.setLayoutParams(it3);
            LinearLayout btnRow = new LinearLayout($ctx);
            btnRow.setOrientation(0);
            btnRow.setGravity(8388613);
            TextView laterTv = new TextView($ctx);
            laterTv.setText("Later");
            laterTv.setTextColor(Color.parseColor("#808090"));
            laterTv.setTextSize(14.0f);
            int p = (int) (f2 * dp);
            laterTv.setPadding(p, p, p, p);
            laterTv.setClickable(true);
            laterTv.setFocusable(true);
            TextView joinTv = new TextView($ctx);
            joinTv.setText("Join Telegram");
            joinTv.setTextColor(Color.parseColor("#5B9BF5"));
            joinTv.setTextSize(14.0f);
            joinTv.setTypeface(Typeface.DEFAULT_BOLD);
            int p2 = (int) (f2 * dp);
            joinTv.setPadding(p2, p2, 0, p2);
            joinTv.setClickable(true);
            joinTv.setFocusable(true);
            btnRow.addView(laterTv);
            btnRow.addView(joinTv);
            root.addView($this$showTelegramPopup_u24lambda_u240_u242);
            root.addView(dividerV);
            root.addView($this$showTelegramPopup_u24lambda_u240_u244);
            root.addView(btnRow);
            final AlertDialog dialog = new AlertDialog.Builder($ctx).setView(root).setCancelable(true).create();
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CastleTvProvider.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
                }
            });
            dialog.show();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTelegramPopup$lambda$0$9(AlertDialog $dialog, Context $ctx, View it) {
        $dialog.dismiss();
        try {
            Intent i = new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/cncverse"));
            i.addFlags(268435456);
            $ctx.startActivity(i);
        } catch (Exception e) {
        }
    }

    private final void openInExternalBrowser(final String url) {
        final Context ctx;
        if (Globals.INSTANCE.isLayout(2) || (ctx = context) == null) {
            return;
        }
        long now = System.currentTimeMillis();
        if (now - lastBrowserOpenMs < BROWSER_DEBOUNCE_MS) {
            return;
        }
        lastBrowserOpenMs = now;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.CastleTvProvider$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                CastleTvProvider.openInExternalBrowser$lambda$0(ctx, url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openInExternalBrowser$lambda$0(Context $ctx, String $url) {
        try {
            Intent $this$openInExternalBrowser_u24lambda_u240_u240 = new Intent("android.intent.action.VIEW", Uri.parse($url));
            $this$openInExternalBrowser_u24lambda_u240_u240.addFlags(268435456);
            $ctx.startActivity($this$openInExternalBrowser_u24lambda_u240_u240);
        } catch (Exception e) {
        }
    }
}
