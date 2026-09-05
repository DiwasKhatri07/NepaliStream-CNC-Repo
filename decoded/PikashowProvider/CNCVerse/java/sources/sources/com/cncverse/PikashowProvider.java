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
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: PikashowProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/PikashowProvider/classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 R2\u00020\u0001:\u0011RSTUVWXYZ[\\]^_`abB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050 H\u0002J\u001e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0096@¢\u0006\u0002\u0010+J\u0014\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00103J\u0018\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00103JF\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u000e2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=0;2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020=0;H\u0096@¢\u0006\u0002\u0010@J2\u0010A\u001a\u00020=2\u0006\u0010B\u001a\u00020C2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020=0;2\u0006\u0010D\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010EJ\u0016\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u00103J\u0010\u0010H\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H\u0002JF\u0010I\u001a\u00020=2\u0006\u0010B\u001a\u00020C2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020=0;2\u0006\u0010D\u001a\u00020\u00052\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050 H\u0082@¢\u0006\u0002\u0010KJ\u0012\u0010L\u001a\u00020(2\b\u0010.\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010M\u001a\u00020(2\b\u0010N\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010O\u001a\u00020=H\u0002J\b\u0010P\u001a\u00020=H\u0002J\u0010\u0010Q\u001a\u00020=2\u0006\u00106\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/cncverse/PikashowProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "apiKey", "hmacSecret", "mapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "deviceUuid", "gaid", "generateSignature", "", "timestampMs", "", "(Ljava/lang/Long;)Ljava/util/Map;", "getPikashowHeaders", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQualityFromString", "Lcom/lagradost/cloudstream3/SearchQuality;", "qualityString", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addVideoLinksToCallback", "videoData", "Lcom/cncverse/PikashowProvider$VideoData;", "contentName", "(Lcom/cncverse/PikashowProvider$VideoData;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseHDBVPlayerUrl", "playerUrl", "extractImdbIdFromUrl", "fallbackToDirectUrls", "finalHeaders", "(Lcom/cncverse/PikashowProvider$VideoData;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQualityValue", "getQualityValueFromLabel", "label", "showSubscriptionPopupIfNeeded", "showTelegramPopup", "openInExternalBrowser", "Companion", "PikashowSeries", "SeasonDetail", "PikashowSeriesResponse", "PikashowMovie", "ClientUrl", "PikashowMovieResponse", "VideoApiResponse", "VideoData", "VideoSeasonDetail", "VideoEpisode", "Resolution", "Language", "Keys", "Season", "HDBVEpisode", "FileData", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPikashowProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PikashowProvider.kt\ncom/cncverse/PikashowProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1278:1\n1915#2:1279\n1642#2,10:1293\n1915#2:1303\n1916#2:1305\n1652#2:1306\n1642#2,10:1320\n1915#2:1330\n1916#2:1332\n1652#2:1333\n1916#2:1334\n1915#2:1335\n1915#2,2:1349\n1915#2,2:1364\n1916#2:1366\n1915#2,2:1381\n1807#2,3:1465\n1807#2,3:1468\n1915#2,2:1471\n1915#2:1473\n1915#2,2:1474\n1916#2:1476\n116#3:1280\n54#3:1281\n117#3:1282\n61#3,8:1283\n71#3:1292\n116#3:1307\n54#3:1308\n117#3:1309\n61#3,8:1310\n71#3:1319\n116#3:1336\n54#3:1337\n117#3:1338\n61#3,8:1339\n71#3:1348\n116#3:1351\n54#3:1352\n117#3:1353\n61#3,8:1354\n71#3:1363\n116#3:1367\n54#3:1368\n117#3:1369\n61#3,8:1370\n71#3:1379\n116#3:1383\n54#3:1384\n117#3:1385\n61#3,8:1386\n71#3:1395\n116#3:1397\n54#3:1398\n117#3:1399\n61#3,8:1400\n71#3:1409\n116#3:1410\n54#3:1411\n117#3:1412\n61#3,8:1413\n71#3:1422\n116#3:1424\n54#3:1425\n117#3:1426\n61#3,8:1427\n71#3:1436\n116#3:1438\n54#3:1439\n117#3:1440\n61#3,8:1441\n71#3:1450\n116#3:1452\n54#3:1453\n117#3:1454\n61#3,8:1455\n71#3:1464\n116#3:1477\n54#3:1478\n117#3:1479\n61#3,8:1480\n71#3:1489\n116#3:1490\n54#3:1491\n117#3:1492\n61#3,8:1493\n71#3:1502\n1#4:1291\n1#4:1304\n1#4:1318\n1#4:1331\n1#4:1347\n1#4:1362\n1#4:1378\n1#4:1380\n1#4:1394\n1#4:1396\n1#4:1408\n1#4:1421\n1#4:1423\n1#4:1435\n1#4:1437\n1#4:1449\n1#4:1451\n1#4:1463\n1#4:1488\n1#4:1501\n1#4:1503\n*S KotlinDebug\n*F\n+ 1 PikashowProvider.kt\ncom/cncverse/PikashowProvider\n*L\n254#1:1279\n274#1:1293,10\n274#1:1303\n274#1:1305\n274#1:1306\n295#1:1320,10\n295#1:1330\n295#1:1332\n295#1:1333\n254#1:1334\n373#1:1335\n393#1:1349,2\n421#1:1364,2\n373#1:1366\n508#1:1381,2\n770#1:1465,3\n771#1:1468,3\n775#1:1471,2\n798#1:1473\n799#1:1474,2\n798#1:1476\n273#1:1280\n273#1:1281\n273#1:1282\n273#1:1283,8\n273#1:1292\n294#1:1307\n294#1:1308\n294#1:1309\n294#1:1310,8\n294#1:1319\n392#1:1336\n392#1:1337\n392#1:1338\n392#1:1339,8\n392#1:1348\n420#1:1351\n420#1:1352\n420#1:1353\n420#1:1354,8\n420#1:1363\n501#1:1367\n501#1:1368\n501#1:1369\n501#1:1370,8\n501#1:1379\n555#1:1383\n555#1:1384\n555#1:1385\n555#1:1386,8\n555#1:1395\n637#1:1397\n637#1:1398\n637#1:1399\n637#1:1400,8\n637#1:1409\n673#1:1410\n673#1:1411\n673#1:1412\n673#1:1413,8\n673#1:1422\n681#1:1424\n681#1:1425\n681#1:1426\n681#1:1427,8\n681#1:1436\n710#1:1438\n710#1:1439\n710#1:1440\n710#1:1441,8\n710#1:1450\n748#1:1452\n748#1:1453\n748#1:1454\n748#1:1455,8\n748#1:1464\n898#1:1477\n898#1:1478\n898#1:1479\n898#1:1480,8\n898#1:1489\n935#1:1490\n935#1:1491\n935#1:1492\n935#1:1493,8\n935#1:1502\n273#1:1291\n274#1:1304\n294#1:1318\n295#1:1331\n392#1:1347\n420#1:1362\n501#1:1378\n555#1:1394\n637#1:1408\n673#1:1421\n681#1:1435\n710#1:1449\n748#1:1463\n898#1:1488\n935#1:1501\n*E\n"})
public final class PikashowProvider extends MainAPI {
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
    private String mainUrl = "https://manoda.co";

    @NotNull
    private String name = "Pikashow";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "ta";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private final String apiKey = "picashow-api-secret-key";

    @NotNull
    private final String hmacSecret = "picashow-api-secret-2025";

    @NotNull
    private final ObjectMapper mapper = ExtensionsKt.jacksonObjectMapper();

    @NotNull
    private final String deviceUuid = UUID.randomUUID().toString();

    @NotNull
    private final String gaid = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: com.cncverse.PikashowProvider$addVideoLinksToCallback$1 */
    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PikashowProvider", f = "PikashowProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6}, l = {783, 808, 826, 830, 843, 848, 852}, m = "addVideoLinksToCallback", n = {"videoData", "callback", "contentName", "baseHeaders", "finalHeaders", "$this$forEach$iv", "element$iv", "resolution", "url", "linkType", "hasResolutions", "hasLanguageResolutions", "$i$f$forEach", "$i$a$-forEach-PikashowProvider$addVideoLinksToCallback$6", "$i$a$-let-PikashowProvider$addVideoLinksToCallback$6$1", "videoData", "callback", "contentName", "baseHeaders", "finalHeaders", "$this$forEach$iv", "element$iv", "lang", "$this$forEach$iv", "element$iv", "resolution", "url", "linkType", "langName", "hasResolutions", "hasLanguageResolutions", "$i$f$forEach", "$i$a$-forEach-PikashowProvider$addVideoLinksToCallback$7", "$i$f$forEach", "$i$a$-forEach-PikashowProvider$addVideoLinksToCallback$7$1", "$i$a$-let-PikashowProvider$addVideoLinksToCallback$7$1$1", "videoData", "callback", "contentName", "baseHeaders", "finalHeaders", "hasResolutions", "hasLanguageResolutions", "videoData", "callback", "contentName", "baseHeaders", "finalHeaders", "streamingUrl", "urlOrigin", "hasResolutions", "hasLanguageResolutions", "videoData", "callback", "contentName", "baseHeaders", "finalHeaders", "streamingUrl", "hasResolutions", "hasLanguageResolutions", "videoData", "callback", "contentName", "baseHeaders", "finalHeaders", "e", "hasResolutions", "hasLanguageResolutions", "videoData", "callback", "contentName", "baseHeaders", "finalHeaders", "hasResolutions", "hasLanguageResolutions"}, nl = {782, 807, 827, 829, 845, 852, 857}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "I$6", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        int I$6;
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
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PikashowProvider.this.addVideoLinksToCallback(null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PikashowProvider$fallbackToDirectUrls$1 */
    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PikashowProvider", f = "PikashowProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {1000}, m = "fallbackToDirectUrls", n = {"videoData", "callback", "contentName", "finalHeaders", "directUrl", "url", "linkType", "$i$a$-let-PikashowProvider$fallbackToDirectUrls$2", "quality"}, nl = {999}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PikashowProvider.this.fallbackToDirectUrls(null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PikashowProvider$getMainPage$1 */
    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PikashowProvider", f = "PikashowProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {262}, m = "getMainPage", n = {"request", "headers", "homePageList", "categories", "$this$forEach$iv", "element$iv", "type", "displayName", "url", "params", "page", "$i$f$forEach", "$i$a$-forEach-PikashowProvider$getMainPage$2"}, nl = {269}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1", "I$2"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
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
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PikashowProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PikashowProvider$load$1 */
    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PikashowProvider", f = "PikashowProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {493, 523, 547, 559}, m = "load", n = {"url", "withoutUrlScheme", "parts", "identifier", "type", "headers", "seriesUrl", "params", "url", "withoutUrlScheme", "parts", "identifier", "type", "headers", "seriesUrl", "params", "response", "seriesResponse", "series", "seriesData", "episodes", "$i$a$-let-PikashowProvider$load$2", "url", "withoutUrlScheme", "parts", "identifier", "type", "headers", "movieUrl", "params", "url", "withoutUrlScheme", "parts", "identifier", "type", "headers", "movieUrl", "params", "response", "movieResponse", "movie", "movieData", "$i$a$-let-PikashowProvider$load$3"}, nl = {500, 534, 554, 570}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        int I$0;
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

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PikashowProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PikashowProvider$loadLinks$1 */
    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PikashowProvider", f = "PikashowProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {629, 639, 660, 703, 713}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "withoutUrlScheme", "headers", "parts", "seriesTitle", "season", "episode", "videoUrl", "params", "isCasting", "data", "subtitleCallback", "callback", "withoutUrlScheme", "headers", "parts", "seriesTitle", "season", "episode", "videoUrl", "params", "response", "videoResponse", "videoData", "isCasting", "$i$a$-let-PikashowProvider$loadLinks$3", "data", "subtitleCallback", "callback", "withoutUrlScheme", "headers", "parts", "identifier", "type", "listUrl", "listParams", "isCasting", "data", "subtitleCallback", "callback", "withoutUrlScheme", "headers", "parts", "identifier", "type", "listUrl", "listParams", "listResponse", "videoId", "title", "safeTitle", "videoUrl", "videoParams", "isCasting", "data", "subtitleCallback", "callback", "withoutUrlScheme", "headers", "parts", "identifier", "type", "listUrl", "listParams", "listResponse", "videoId", "title", "safeTitle", "videoUrl", "videoParams", "videoResponse", "videoApiResponse", "contentNameLocal", "videoData", "isCasting", "$i$a$-let-PikashowProvider$loadLinks$6"}, nl = {636, 640, 667, 709, 714}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "Z$0", "I$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
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
        Object L$19;
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

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PikashowProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PikashowProvider$parseHDBVPlayerUrl$1 */
    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PikashowProvider", f = "PikashowProvider.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {862, 915, 943}, m = "parseHDBVPlayerUrl", n = {"playerUrl", "playerUrl", "response", "doc", "scripts", "script", "regex", "matchResult", "jsonInsideHDVBPlayer", "fileKeys", "origin", "absoluteUrl", "headers", "referer", "playerUrl", "response", "doc", "scripts", "script", "regex", "matchResult", "jsonInsideHDVBPlayer", "fileKeys", "origin", "absoluteUrl", "headers", "referer", "postResponse", "responseText", "jsonArray", "seasons", "episodeDetails", "episode"}, nl = {885, 921, 949}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18"}, v = 2)
    static final class C00071 extends ContinuationImpl {
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
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PikashowProvider.this.parseHDBVPlayerUrl(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PikashowProvider$search$1 */
    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PikashowProvider", f = "PikashowProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {381}, m = "search", n = {"query", "searchResults", "headers", "searchQuery", "categories", "$this$forEach$iv", "element$iv", "type", "tvType", "url", "params", "$i$f$forEach", "$i$a$-forEach-PikashowProvider$search$2"}, nl = {388}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "I$1"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        int I$0;
        int I$1;
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
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PikashowProvider.this.search(null, (Continuation) this);
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

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/cncverse/PikashowProvider$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "OMG10", "", "lastBrowserOpenMs", "", "telegramPopupShown", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPikashowProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PikashowProvider.kt\ncom/cncverse/PikashowProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1278:1\n1#2:1279\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
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
                PikashowProvider.csGuardWasEverActive = true;
            }
            return PikashowProvider.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.PikashowProvider$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PikashowProvider.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getContext() {
            return PikashowProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            PikashowProvider.context = context;
        }
    }

    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003Jh\u0010!\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\u0010\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010'\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0013R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/cncverse/PikashowProvider$PikashowSeries;", "", "title", "", "genre", "year", "", "cover", "imdbRating", "seasons", "details", "", "Lcom/cncverse/PikashowProvider$SeasonDetail;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getGenre", "getYear", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCover", "getImdbRating", "getSeasons", "getDetails", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/cncverse/PikashowProvider$PikashowSeries;", "equals", "", "other", "hashCode", "toString", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class PikashowSeries {

        @JsonProperty("c")
        @Nullable
        private final String cover;

        @JsonProperty("detail")
        @Nullable
        private final List<SeasonDetail> details;

        @JsonProperty("g")
        @Nullable
        private final String genre;

        @JsonProperty("i")
        @Nullable
        private final String imdbRating;

        @JsonProperty("n")
        @Nullable
        private final Integer seasons;

        @JsonProperty("t")
        @Nullable
        private final String title;

        @JsonProperty("y")
        @Nullable
        private final Integer year;

        public PikashowSeries() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PikashowSeries copy$default(PikashowSeries pikashowSeries, String str, String str2, Integer num, String str3, String str4, Integer num2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pikashowSeries.title;
            }
            if ((i & 2) != 0) {
                str2 = pikashowSeries.genre;
            }
            if ((i & 4) != 0) {
                num = pikashowSeries.year;
            }
            if ((i & 8) != 0) {
                str3 = pikashowSeries.cover;
            }
            if ((i & 16) != 0) {
                str4 = pikashowSeries.imdbRating;
            }
            if ((i & 32) != 0) {
                num2 = pikashowSeries.seasons;
            }
            if ((i & 64) != 0) {
                list = pikashowSeries.details;
            }
            Integer num3 = num2;
            List list2 = list;
            String str5 = str4;
            Integer num4 = num;
            return pikashowSeries.copy(str, str2, num4, str3, str5, num3, list2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getGenre() {
            return this.genre;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCover() {
            return this.cover;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getSeasons() {
            return this.seasons;
        }

        @Nullable
        public final List<SeasonDetail> component7() {
            return this.details;
        }

        @NotNull
        public final PikashowSeries copy(@JsonProperty("t") @Nullable String title, @JsonProperty("g") @Nullable String genre, @JsonProperty("y") @Nullable Integer year, @JsonProperty("c") @Nullable String cover, @JsonProperty("i") @Nullable String imdbRating, @JsonProperty("n") @Nullable Integer seasons, @JsonProperty("detail") @Nullable List<SeasonDetail> details) {
            return new PikashowSeries(title, genre, year, cover, imdbRating, seasons, details);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PikashowSeries)) {
                return false;
            }
            PikashowSeries pikashowSeries = (PikashowSeries) other;
            return Intrinsics.areEqual(this.title, pikashowSeries.title) && Intrinsics.areEqual(this.genre, pikashowSeries.genre) && Intrinsics.areEqual(this.year, pikashowSeries.year) && Intrinsics.areEqual(this.cover, pikashowSeries.cover) && Intrinsics.areEqual(this.imdbRating, pikashowSeries.imdbRating) && Intrinsics.areEqual(this.seasons, pikashowSeries.seasons) && Intrinsics.areEqual(this.details, pikashowSeries.details);
        }

        public int hashCode() {
            return ((((((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.genre == null ? 0 : this.genre.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.cover == null ? 0 : this.cover.hashCode())) * 31) + (this.imdbRating == null ? 0 : this.imdbRating.hashCode())) * 31) + (this.seasons == null ? 0 : this.seasons.hashCode())) * 31) + (this.details != null ? this.details.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "PikashowSeries(title=" + this.title + ", genre=" + this.genre + ", year=" + this.year + ", cover=" + this.cover + ", imdbRating=" + this.imdbRating + ", seasons=" + this.seasons + ", details=" + this.details + ')';
        }

        public PikashowSeries(@JsonProperty("t") @Nullable String title, @JsonProperty("g") @Nullable String genre, @JsonProperty("y") @Nullable Integer year, @JsonProperty("c") @Nullable String cover, @JsonProperty("i") @Nullable String imdbRating, @JsonProperty("n") @Nullable Integer seasons, @JsonProperty("detail") @Nullable List<SeasonDetail> list) {
            this.title = title;
            this.genre = genre;
            this.year = year;
            this.cover = cover;
            this.imdbRating = imdbRating;
            this.seasons = seasons;
            this.details = list;
        }

        public /* synthetic */ PikashowSeries(String str, String str2, Integer num, String str3, String str4, Integer num2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : list);
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getGenre() {
            return this.genre;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        public final String getCover() {
            return this.cover;
        }

        @Nullable
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        public final Integer getSeasons() {
            return this.seasons;
        }

        @Nullable
        public final List<SeasonDetail> getDetails() {
            return this.details;
        }
    }

    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/cncverse/PikashowProvider$SeasonDetail;", "", "year", "", "season", "", "episodesCount", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getYear", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeason", "()Ljava/lang/String;", "getEpisodesCount", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/cncverse/PikashowProvider$SeasonDetail;", "equals", "", "other", "hashCode", "toString", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SeasonDetail {

        @JsonProperty("episodes_count")
        @Nullable
        private final Integer episodesCount;

        @JsonProperty("season")
        @Nullable
        private final String season;

        @JsonProperty("year")
        @Nullable
        private final Integer year;

        public SeasonDetail() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ SeasonDetail copy$default(SeasonDetail seasonDetail, Integer num, String str, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = seasonDetail.year;
            }
            if ((i & 2) != 0) {
                str = seasonDetail.season;
            }
            if ((i & 4) != 0) {
                num2 = seasonDetail.episodesCount;
            }
            return seasonDetail.copy(num, str, num2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getEpisodesCount() {
            return this.episodesCount;
        }

        @NotNull
        public final SeasonDetail copy(@JsonProperty("year") @Nullable Integer year, @JsonProperty("season") @Nullable String season, @JsonProperty("episodes_count") @Nullable Integer episodesCount) {
            return new SeasonDetail(year, season, episodesCount);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SeasonDetail)) {
                return false;
            }
            SeasonDetail seasonDetail = (SeasonDetail) other;
            return Intrinsics.areEqual(this.year, seasonDetail.year) && Intrinsics.areEqual(this.season, seasonDetail.season) && Intrinsics.areEqual(this.episodesCount, seasonDetail.episodesCount);
        }

        public int hashCode() {
            return ((((this.year == null ? 0 : this.year.hashCode()) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episodesCount != null ? this.episodesCount.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "SeasonDetail(year=" + this.year + ", season=" + this.season + ", episodesCount=" + this.episodesCount + ')';
        }

        public SeasonDetail(@JsonProperty("year") @Nullable Integer year, @JsonProperty("season") @Nullable String season, @JsonProperty("episodes_count") @Nullable Integer episodesCount) {
            this.year = year;
            this.season = season;
            this.episodesCount = episodesCount;
        }

        public /* synthetic */ SeasonDetail(Integer num, String str, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2);
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        public final Integer getEpisodesCount() {
            return this.episodesCount;
        }
    }

    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/cncverse/PikashowProvider$PikashowSeriesResponse;", "", "series", "", "Lcom/cncverse/PikashowProvider$PikashowSeries;", "<init>", "(Ljava/util/List;)V", "getSeries", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class PikashowSeriesResponse {

        @JsonProperty("series")
        @Nullable
        private final List<PikashowSeries> series;

        /* JADX WARN: Illegal instructions before constructor call */
        public PikashowSeriesResponse() {
            List list = null;
            this(list, 1, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PikashowSeriesResponse copy$default(PikashowSeriesResponse pikashowSeriesResponse, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = pikashowSeriesResponse.series;
            }
            return pikashowSeriesResponse.copy(list);
        }

        @Nullable
        public final List<PikashowSeries> component1() {
            return this.series;
        }

        @NotNull
        public final PikashowSeriesResponse copy(@JsonProperty("series") @Nullable List<PikashowSeries> series) {
            return new PikashowSeriesResponse(series);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PikashowSeriesResponse) && Intrinsics.areEqual(this.series, ((PikashowSeriesResponse) other).series);
        }

        public int hashCode() {
            if (this.series == null) {
                return 0;
            }
            return this.series.hashCode();
        }

        @NotNull
        public String toString() {
            return "PikashowSeriesResponse(series=" + this.series + ')';
        }

        public PikashowSeriesResponse(@JsonProperty("series") @Nullable List<PikashowSeries> list) {
            this.series = list;
        }

        public /* synthetic */ PikashowSeriesResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list);
        }

        @Nullable
        public final List<PikashowSeries> getSeries() {
            return this.series;
        }
    }

    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u0080\u0001\u0010'\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010(J\u0014\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010-\u001a\u00020\u0005HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/cncverse/PikashowProvider$PikashowMovie;", "", "sortOrder", "", "title", "", "genre", "year", "quality", "cover", "url", "format", "clientUrls", "", "Lcom/cncverse/PikashowProvider$ClientUrl;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getSortOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "getGenre", "getYear", "getQuality", "getCover", "getUrl", "getFormat", "getClientUrls", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/cncverse/PikashowProvider$PikashowMovie;", "equals", "", "other", "hashCode", "toString", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class PikashowMovie {

        @JsonProperty("clientUrls")
        @Nullable
        private final List<ClientUrl> clientUrls;

        @JsonProperty("c")
        @Nullable
        private final String cover;

        @JsonProperty("f")
        @Nullable
        private final Integer format;

        @JsonProperty("g")
        @Nullable
        private final String genre;

        @JsonProperty("q")
        @Nullable
        private final String quality;

        @JsonProperty("so")
        @Nullable
        private final Integer sortOrder;

        @JsonProperty("t")
        @Nullable
        private final String title;

        @JsonProperty("url")
        @Nullable
        private final String url;

        @JsonProperty("y")
        @Nullable
        private final Integer year;

        public PikashowMovie() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PikashowMovie copy$default(PikashowMovie pikashowMovie, Integer num, String str, String str2, Integer num2, String str3, String str4, String str5, Integer num3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                num = pikashowMovie.sortOrder;
            }
            if ((i & 2) != 0) {
                str = pikashowMovie.title;
            }
            if ((i & 4) != 0) {
                str2 = pikashowMovie.genre;
            }
            if ((i & 8) != 0) {
                num2 = pikashowMovie.year;
            }
            if ((i & 16) != 0) {
                str3 = pikashowMovie.quality;
            }
            if ((i & 32) != 0) {
                str4 = pikashowMovie.cover;
            }
            if ((i & 64) != 0) {
                str5 = pikashowMovie.url;
            }
            if ((i & 128) != 0) {
                num3 = pikashowMovie.format;
            }
            if ((i & 256) != 0) {
                list = pikashowMovie.clientUrls;
            }
            Integer num4 = num3;
            List list2 = list;
            String str6 = str4;
            String str7 = str5;
            String str8 = str3;
            String str9 = str2;
            return pikashowMovie.copy(num, str, str9, num2, str8, str6, str7, num4, list2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getSortOrder() {
            return this.sortOrder;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getGenre() {
            return this.genre;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getQuality() {
            return this.quality;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getCover() {
            return this.cover;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getFormat() {
            return this.format;
        }

        @Nullable
        public final List<ClientUrl> component9() {
            return this.clientUrls;
        }

        @NotNull
        public final PikashowMovie copy(@JsonProperty("so") @Nullable Integer sortOrder, @JsonProperty("t") @Nullable String title, @JsonProperty("g") @Nullable String genre, @JsonProperty("y") @Nullable Integer year, @JsonProperty("q") @Nullable String quality, @JsonProperty("c") @Nullable String cover, @JsonProperty("url") @Nullable String url, @JsonProperty("f") @Nullable Integer format, @JsonProperty("clientUrls") @Nullable List<ClientUrl> clientUrls) {
            return new PikashowMovie(sortOrder, title, genre, year, quality, cover, url, format, clientUrls);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PikashowMovie)) {
                return false;
            }
            PikashowMovie pikashowMovie = (PikashowMovie) other;
            return Intrinsics.areEqual(this.sortOrder, pikashowMovie.sortOrder) && Intrinsics.areEqual(this.title, pikashowMovie.title) && Intrinsics.areEqual(this.genre, pikashowMovie.genre) && Intrinsics.areEqual(this.year, pikashowMovie.year) && Intrinsics.areEqual(this.quality, pikashowMovie.quality) && Intrinsics.areEqual(this.cover, pikashowMovie.cover) && Intrinsics.areEqual(this.url, pikashowMovie.url) && Intrinsics.areEqual(this.format, pikashowMovie.format) && Intrinsics.areEqual(this.clientUrls, pikashowMovie.clientUrls);
        }

        public int hashCode() {
            return ((((((((((((((((this.sortOrder == null ? 0 : this.sortOrder.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.genre == null ? 0 : this.genre.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.quality == null ? 0 : this.quality.hashCode())) * 31) + (this.cover == null ? 0 : this.cover.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.format == null ? 0 : this.format.hashCode())) * 31) + (this.clientUrls != null ? this.clientUrls.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "PikashowMovie(sortOrder=" + this.sortOrder + ", title=" + this.title + ", genre=" + this.genre + ", year=" + this.year + ", quality=" + this.quality + ", cover=" + this.cover + ", url=" + this.url + ", format=" + this.format + ", clientUrls=" + this.clientUrls + ')';
        }

        public PikashowMovie(@JsonProperty("so") @Nullable Integer sortOrder, @JsonProperty("t") @Nullable String title, @JsonProperty("g") @Nullable String genre, @JsonProperty("y") @Nullable Integer year, @JsonProperty("q") @Nullable String quality, @JsonProperty("c") @Nullable String cover, @JsonProperty("url") @Nullable String url, @JsonProperty("f") @Nullable Integer format, @JsonProperty("clientUrls") @Nullable List<ClientUrl> list) {
            this.sortOrder = sortOrder;
            this.title = title;
            this.genre = genre;
            this.year = year;
            this.quality = quality;
            this.cover = cover;
            this.url = url;
            this.format = format;
            this.clientUrls = list;
        }

        public /* synthetic */ PikashowMovie(Integer num, String str, String str2, Integer num2, String str3, String str4, String str5, Integer num3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : num3, (i & 256) != 0 ? null : list);
        }

        @Nullable
        public final Integer getSortOrder() {
            return this.sortOrder;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getGenre() {
            return this.genre;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        public final String getQuality() {
            return this.quality;
        }

        @Nullable
        public final String getCover() {
            return this.cover;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final Integer getFormat() {
            return this.format;
        }

        @Nullable
        public final List<ClientUrl> getClientUrls() {
            return this.clientUrls;
        }
    }

    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/cncverse/PikashowProvider$ClientUrl;", "", "label", "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ClientUrl {

        @JsonProperty("label")
        @Nullable
        private final String label;

        @JsonProperty("url")
        @Nullable
        private final String url;

        /* JADX WARN: Illegal instructions before constructor call */
        public ClientUrl() {
            String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ ClientUrl copy$default(ClientUrl clientUrl, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = clientUrl.label;
            }
            if ((i & 2) != 0) {
                str2 = clientUrl.url;
            }
            return clientUrl.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final ClientUrl copy(@JsonProperty("label") @Nullable String label, @JsonProperty("url") @Nullable String url) {
            return new ClientUrl(label, url);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClientUrl)) {
                return false;
            }
            ClientUrl clientUrl = (ClientUrl) other;
            return Intrinsics.areEqual(this.label, clientUrl.label) && Intrinsics.areEqual(this.url, clientUrl.url);
        }

        public int hashCode() {
            return ((this.label == null ? 0 : this.label.hashCode()) * 31) + (this.url != null ? this.url.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "ClientUrl(label=" + this.label + ", url=" + this.url + ')';
        }

        public ClientUrl(@JsonProperty("label") @Nullable String label, @JsonProperty("url") @Nullable String url) {
            this.label = label;
            this.url = url;
        }

        public /* synthetic */ ClientUrl(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }
    }

    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/cncverse/PikashowProvider$PikashowMovieResponse;", "", "records", "", "Lcom/cncverse/PikashowProvider$PikashowMovie;", "<init>", "(Ljava/util/List;)V", "getRecords", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class PikashowMovieResponse {

        @JsonProperty("records")
        @Nullable
        private final List<PikashowMovie> records;

        /* JADX WARN: Illegal instructions before constructor call */
        public PikashowMovieResponse() {
            List list = null;
            this(list, 1, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PikashowMovieResponse copy$default(PikashowMovieResponse pikashowMovieResponse, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = pikashowMovieResponse.records;
            }
            return pikashowMovieResponse.copy(list);
        }

        @Nullable
        public final List<PikashowMovie> component1() {
            return this.records;
        }

        @NotNull
        public final PikashowMovieResponse copy(@JsonProperty("records") @Nullable List<PikashowMovie> records) {
            return new PikashowMovieResponse(records);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PikashowMovieResponse) && Intrinsics.areEqual(this.records, ((PikashowMovieResponse) other).records);
        }

        public int hashCode() {
            if (this.records == null) {
                return 0;
            }
            return this.records.hashCode();
        }

        @NotNull
        public String toString() {
            return "PikashowMovieResponse(records=" + this.records + ')';
        }

        public PikashowMovieResponse(@JsonProperty("records") @Nullable List<PikashowMovie> list) {
            this.records = list;
        }

        public /* synthetic */ PikashowMovieResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list);
        }

        @Nullable
        public final List<PikashowMovie> getRecords() {
            return this.records;
        }
    }

    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/cncverse/PikashowProvider$VideoApiResponse;", "", "code", "", "message", "", "data", "Lcom/cncverse/PikashowProvider$VideoData;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/cncverse/PikashowProvider$VideoData;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "getData", "()Lcom/cncverse/PikashowProvider$VideoData;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/cncverse/PikashowProvider$VideoData;)Lcom/cncverse/PikashowProvider$VideoApiResponse;", "equals", "", "other", "hashCode", "toString", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class VideoApiResponse {

        @JsonProperty("code")
        @Nullable
        private final Integer code;

        @JsonProperty("data")
        @Nullable
        private final VideoData data;

        @JsonProperty("message")
        @Nullable
        private final String message;

        public VideoApiResponse() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ VideoApiResponse copy$default(VideoApiResponse videoApiResponse, Integer num, String str, VideoData videoData, int i, Object obj) {
            if ((i & 1) != 0) {
                num = videoApiResponse.code;
            }
            if ((i & 2) != 0) {
                str = videoApiResponse.message;
            }
            if ((i & 4) != 0) {
                videoData = videoApiResponse.data;
            }
            return videoApiResponse.copy(num, str, videoData);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getCode() {
            return this.code;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final VideoData getData() {
            return this.data;
        }

        @NotNull
        public final VideoApiResponse copy(@JsonProperty("code") @Nullable Integer code, @JsonProperty("message") @Nullable String message, @JsonProperty("data") @Nullable VideoData data) {
            return new VideoApiResponse(code, message, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoApiResponse)) {
                return false;
            }
            VideoApiResponse videoApiResponse = (VideoApiResponse) other;
            return Intrinsics.areEqual(this.code, videoApiResponse.code) && Intrinsics.areEqual(this.message, videoApiResponse.message) && Intrinsics.areEqual(this.data, videoApiResponse.data);
        }

        public int hashCode() {
            return ((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.message == null ? 0 : this.message.hashCode())) * 31) + (this.data != null ? this.data.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "VideoApiResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
        }

        public VideoApiResponse(@JsonProperty("code") @Nullable Integer code, @JsonProperty("message") @Nullable String message, @JsonProperty("data") @Nullable VideoData data) {
            this.code = code;
            this.message = message;
            this.data = data;
        }

        public /* synthetic */ VideoApiResponse(Integer num, String str, VideoData videoData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : videoData);
        }

        @Nullable
        public final Integer getCode() {
            return this.code;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        public final VideoData getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\bP\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0003\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0003\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000b\u0012\u0016\b\u0003\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u0012\u0010\b\u0003\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000b\u0012\u0010\b\u0003\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b'\u0010(J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010-J\u0011\u0010Q\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010-J\u0011\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000bHÆ\u0003J\u0017\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018HÆ\u0003J\u0011\u0010[\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000bHÆ\u0003J\u0011\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000bHÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009a\u0003\u0010h\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\u0010\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0010\b\u0003\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000b2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000b2\u0016\b\u0003\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\u0010\b\u0003\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000b2\u0010\b\u0003\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000b2\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010iJ\u0014\u0010j\u001a\u00020k2\b\u0010l\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010m\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010n\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010*R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010*R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b1\u0010-R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b4\u0010-R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010*R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010*R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b7\u0010-R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00103R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010*R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010*R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00103R$\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u00103R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u00103R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010*R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010*R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010*R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010*R\u0018\u0010 \u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010*R\u0018\u0010!\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010*R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010*R\u0018\u0010#\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010*R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u00103R\u0018\u0010%\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010*R\u0018\u0010&\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010*¨\u0006o"}, d2 = {"Lcom/cncverse/PikashowProvider$VideoData;", "", "title", "", "genre", "year", "", "cover", "imdbRating", "seasons", "details", "", "Lcom/cncverse/PikashowProvider$VideoSeasonDetail;", "sortOrder", "quality", "url", "format", "clientUrls", "Lcom/cncverse/PikashowProvider$ClientUrl;", "videoUrl", "playUrl", "resolutions", "Lcom/cncverse/PikashowProvider$Resolution;", "headers", "", "languages", "Lcom/cncverse/PikashowProvider$Language;", "languageOptions", "heastr", "uastr", "uaStr", "headerStr", "sourceType", "host", "file", "key", "supportedLanguages", "season", "episode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getGenre", "getYear", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCover", "getImdbRating", "getSeasons", "getDetails", "()Ljava/util/List;", "getSortOrder", "getQuality", "getUrl", "getFormat", "getClientUrls", "getVideoUrl", "getPlayUrl", "getResolutions", "getHeaders", "()Ljava/util/Map;", "getLanguages", "getLanguageOptions", "getHeastr", "getUastr", "getUaStr", "getHeaderStr", "getSourceType", "getHost", "getFile", "getKey", "getSupportedLanguages", "getSeason", "getEpisode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/cncverse/PikashowProvider$VideoData;", "equals", "", "other", "hashCode", "toString", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class VideoData {

        @JsonProperty("clientUrls")
        @Nullable
        private final List<ClientUrl> clientUrls;

        @JsonProperty("c")
        @Nullable
        private final String cover;

        @JsonProperty("detail")
        @Nullable
        private final List<VideoSeasonDetail> details;

        @JsonProperty("episode")
        @Nullable
        private final String episode;

        @JsonProperty("file")
        @Nullable
        private final String file;

        @JsonProperty("f")
        @Nullable
        private final Integer format;

        @JsonProperty("g")
        @Nullable
        private final String genre;

        @JsonProperty("headerStr")
        @Nullable
        private final String headerStr;

        @JsonProperty("headers")
        @Nullable
        private final Map<String, String> headers;

        @JsonProperty("heastr")
        @Nullable
        private final String heastr;

        @JsonProperty("host")
        @Nullable
        private final String host;

        @JsonProperty("i")
        @Nullable
        private final String imdbRating;

        @JsonProperty("key")
        @Nullable
        private final String key;

        @JsonProperty("languageOptions")
        @Nullable
        private final List<Language> languageOptions;

        @JsonProperty("languages")
        @Nullable
        private final List<Language> languages;

        @JsonProperty("playUrl")
        @Nullable
        private final String playUrl;

        @JsonProperty("q")
        @Nullable
        private final String quality;

        @JsonProperty("resolutions")
        @Nullable
        private final List<Resolution> resolutions;

        @JsonProperty("season")
        @Nullable
        private final String season;

        @JsonProperty("n")
        @Nullable
        private final Integer seasons;

        @JsonProperty("so")
        @Nullable
        private final Integer sortOrder;

        @JsonProperty("sourceType")
        @Nullable
        private final String sourceType;

        @JsonProperty("supportedLanguages")
        @Nullable
        private final List<String> supportedLanguages;

        @JsonProperty("t")
        @Nullable
        private final String title;

        @JsonProperty("uaStr")
        @Nullable
        private final String uaStr;

        @JsonProperty("uastr")
        @Nullable
        private final String uastr;

        @JsonProperty("url")
        @Nullable
        private final String url;

        @JsonProperty("videoUrl")
        @Nullable
        private final String videoUrl;

        @JsonProperty("y")
        @Nullable
        private final Integer year;

        public VideoData() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870911, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VideoData copy$default(VideoData videoData, String str, String str2, Integer num, String str3, String str4, Integer num2, List list, Integer num3, String str5, String str6, Integer num4, List list2, String str7, String str8, List list3, Map map, List list4, List list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, List list6, String str17, String str18, int i, Object obj) {
            String str19;
            String str20;
            String str21 = (i & 1) != 0 ? videoData.title : str;
            String str22 = (i & 2) != 0 ? videoData.genre : str2;
            Integer num5 = (i & 4) != 0 ? videoData.year : num;
            String str23 = (i & 8) != 0 ? videoData.cover : str3;
            String str24 = (i & 16) != 0 ? videoData.imdbRating : str4;
            Integer num6 = (i & 32) != 0 ? videoData.seasons : num2;
            List list7 = (i & 64) != 0 ? videoData.details : list;
            Integer num7 = (i & 128) != 0 ? videoData.sortOrder : num3;
            String str25 = (i & 256) != 0 ? videoData.quality : str5;
            String str26 = (i & 512) != 0 ? videoData.url : str6;
            Integer num8 = (i & 1024) != 0 ? videoData.format : num4;
            List list8 = (i & 2048) != 0 ? videoData.clientUrls : list2;
            String str27 = (i & 4096) != 0 ? videoData.videoUrl : str7;
            String str28 = (i & 8192) != 0 ? videoData.playUrl : str8;
            String str29 = str21;
            List list9 = (i & 16384) != 0 ? videoData.resolutions : list3;
            Map map2 = (i & 32768) != 0 ? videoData.headers : map;
            List list10 = (i & 65536) != 0 ? videoData.languages : list4;
            List list11 = (i & 131072) != 0 ? videoData.languageOptions : list5;
            String str30 = (i & 262144) != 0 ? videoData.heastr : str9;
            String str31 = (i & 524288) != 0 ? videoData.uastr : str10;
            String str32 = (i & 1048576) != 0 ? videoData.uaStr : str11;
            String str33 = (i & 2097152) != 0 ? videoData.headerStr : str12;
            String str34 = (i & 4194304) != 0 ? videoData.sourceType : str13;
            String str35 = (i & 8388608) != 0 ? videoData.host : str14;
            String str36 = (i & 16777216) != 0 ? videoData.file : str15;
            String str37 = (i & 33554432) != 0 ? videoData.key : str16;
            List list12 = (i & 67108864) != 0 ? videoData.supportedLanguages : list6;
            String str38 = (i & 134217728) != 0 ? videoData.season : str17;
            if ((i & 268435456) != 0) {
                str20 = str38;
                str19 = videoData.episode;
            } else {
                str19 = str18;
                str20 = str38;
            }
            return videoData.copy(str29, str22, num5, str23, str24, num6, list7, num7, str25, str26, num8, list8, str27, str28, list9, map2, list10, list11, str30, str31, str32, str33, str34, str35, str36, str37, list12, str20, str19);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Integer getFormat() {
            return this.format;
        }

        @Nullable
        public final List<ClientUrl> component12() {
            return this.clientUrls;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getVideoUrl() {
            return this.videoUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getPlayUrl() {
            return this.playUrl;
        }

        @Nullable
        public final List<Resolution> component15() {
            return this.resolutions;
        }

        @Nullable
        public final Map<String, String> component16() {
            return this.headers;
        }

        @Nullable
        public final List<Language> component17() {
            return this.languages;
        }

        @Nullable
        public final List<Language> component18() {
            return this.languageOptions;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final String getHeastr() {
            return this.heastr;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getGenre() {
            return this.genre;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final String getUastr() {
            return this.uastr;
        }

        @Nullable
        /* JADX INFO: renamed from: component21, reason: from getter */
        public final String getUaStr() {
            return this.uaStr;
        }

        @Nullable
        /* JADX INFO: renamed from: component22, reason: from getter */
        public final String getHeaderStr() {
            return this.headerStr;
        }

        @Nullable
        /* JADX INFO: renamed from: component23, reason: from getter */
        public final String getSourceType() {
            return this.sourceType;
        }

        @Nullable
        /* JADX INFO: renamed from: component24, reason: from getter */
        public final String getHost() {
            return this.host;
        }

        @Nullable
        /* JADX INFO: renamed from: component25, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @Nullable
        /* JADX INFO: renamed from: component26, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        @Nullable
        public final List<String> component27() {
            return this.supportedLanguages;
        }

        @Nullable
        /* JADX INFO: renamed from: component28, reason: from getter */
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component29, reason: from getter */
        public final String getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCover() {
            return this.cover;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getSeasons() {
            return this.seasons;
        }

        @Nullable
        public final List<VideoSeasonDetail> component7() {
            return this.details;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getSortOrder() {
            return this.sortOrder;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getQuality() {
            return this.quality;
        }

        @NotNull
        public final VideoData copy(@JsonProperty("t") @Nullable String title, @JsonProperty("g") @Nullable String genre, @JsonProperty("y") @Nullable Integer year, @JsonProperty("c") @Nullable String cover, @JsonProperty("i") @Nullable String imdbRating, @JsonProperty("n") @Nullable Integer seasons, @JsonProperty("detail") @Nullable List<VideoSeasonDetail> details, @JsonProperty("so") @Nullable Integer sortOrder, @JsonProperty("q") @Nullable String quality, @JsonProperty("url") @Nullable String url, @JsonProperty("f") @Nullable Integer format, @JsonProperty("clientUrls") @Nullable List<ClientUrl> clientUrls, @JsonProperty("videoUrl") @Nullable String videoUrl, @JsonProperty("playUrl") @Nullable String playUrl, @JsonProperty("resolutions") @Nullable List<Resolution> resolutions, @JsonProperty("headers") @Nullable Map<String, String> headers, @JsonProperty("languages") @Nullable List<Language> languages, @JsonProperty("languageOptions") @Nullable List<Language> languageOptions, @JsonProperty("heastr") @Nullable String heastr, @JsonProperty("uastr") @Nullable String uastr, @JsonProperty("uaStr") @Nullable String uaStr, @JsonProperty("headerStr") @Nullable String headerStr, @JsonProperty("sourceType") @Nullable String sourceType, @JsonProperty("host") @Nullable String host, @JsonProperty("file") @Nullable String file, @JsonProperty("key") @Nullable String key, @JsonProperty("supportedLanguages") @Nullable List<String> supportedLanguages, @JsonProperty("season") @Nullable String season, @JsonProperty("episode") @Nullable String episode) {
            return new VideoData(title, genre, year, cover, imdbRating, seasons, details, sortOrder, quality, url, format, clientUrls, videoUrl, playUrl, resolutions, headers, languages, languageOptions, heastr, uastr, uaStr, headerStr, sourceType, host, file, key, supportedLanguages, season, episode);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoData)) {
                return false;
            }
            VideoData videoData = (VideoData) other;
            return Intrinsics.areEqual(this.title, videoData.title) && Intrinsics.areEqual(this.genre, videoData.genre) && Intrinsics.areEqual(this.year, videoData.year) && Intrinsics.areEqual(this.cover, videoData.cover) && Intrinsics.areEqual(this.imdbRating, videoData.imdbRating) && Intrinsics.areEqual(this.seasons, videoData.seasons) && Intrinsics.areEqual(this.details, videoData.details) && Intrinsics.areEqual(this.sortOrder, videoData.sortOrder) && Intrinsics.areEqual(this.quality, videoData.quality) && Intrinsics.areEqual(this.url, videoData.url) && Intrinsics.areEqual(this.format, videoData.format) && Intrinsics.areEqual(this.clientUrls, videoData.clientUrls) && Intrinsics.areEqual(this.videoUrl, videoData.videoUrl) && Intrinsics.areEqual(this.playUrl, videoData.playUrl) && Intrinsics.areEqual(this.resolutions, videoData.resolutions) && Intrinsics.areEqual(this.headers, videoData.headers) && Intrinsics.areEqual(this.languages, videoData.languages) && Intrinsics.areEqual(this.languageOptions, videoData.languageOptions) && Intrinsics.areEqual(this.heastr, videoData.heastr) && Intrinsics.areEqual(this.uastr, videoData.uastr) && Intrinsics.areEqual(this.uaStr, videoData.uaStr) && Intrinsics.areEqual(this.headerStr, videoData.headerStr) && Intrinsics.areEqual(this.sourceType, videoData.sourceType) && Intrinsics.areEqual(this.host, videoData.host) && Intrinsics.areEqual(this.file, videoData.file) && Intrinsics.areEqual(this.key, videoData.key) && Intrinsics.areEqual(this.supportedLanguages, videoData.supportedLanguages) && Intrinsics.areEqual(this.season, videoData.season) && Intrinsics.areEqual(this.episode, videoData.episode);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.genre == null ? 0 : this.genre.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.cover == null ? 0 : this.cover.hashCode())) * 31) + (this.imdbRating == null ? 0 : this.imdbRating.hashCode())) * 31) + (this.seasons == null ? 0 : this.seasons.hashCode())) * 31) + (this.details == null ? 0 : this.details.hashCode())) * 31) + (this.sortOrder == null ? 0 : this.sortOrder.hashCode())) * 31) + (this.quality == null ? 0 : this.quality.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.format == null ? 0 : this.format.hashCode())) * 31) + (this.clientUrls == null ? 0 : this.clientUrls.hashCode())) * 31) + (this.videoUrl == null ? 0 : this.videoUrl.hashCode())) * 31) + (this.playUrl == null ? 0 : this.playUrl.hashCode())) * 31) + (this.resolutions == null ? 0 : this.resolutions.hashCode())) * 31) + (this.headers == null ? 0 : this.headers.hashCode())) * 31) + (this.languages == null ? 0 : this.languages.hashCode())) * 31) + (this.languageOptions == null ? 0 : this.languageOptions.hashCode())) * 31) + (this.heastr == null ? 0 : this.heastr.hashCode())) * 31) + (this.uastr == null ? 0 : this.uastr.hashCode())) * 31) + (this.uaStr == null ? 0 : this.uaStr.hashCode())) * 31) + (this.headerStr == null ? 0 : this.headerStr.hashCode())) * 31) + (this.sourceType == null ? 0 : this.sourceType.hashCode())) * 31) + (this.host == null ? 0 : this.host.hashCode())) * 31) + (this.file == null ? 0 : this.file.hashCode())) * 31) + (this.key == null ? 0 : this.key.hashCode())) * 31) + (this.supportedLanguages == null ? 0 : this.supportedLanguages.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode != null ? this.episode.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("VideoData(title=").append(this.title).append(", genre=").append(this.genre).append(", year=").append(this.year).append(", cover=").append(this.cover).append(", imdbRating=").append(this.imdbRating).append(", seasons=").append(this.seasons).append(", details=").append(this.details).append(", sortOrder=").append(this.sortOrder).append(", quality=").append(this.quality).append(", url=").append(this.url).append(", format=").append(this.format).append(", clientUrls=");
            sb.append(this.clientUrls).append(", videoUrl=").append(this.videoUrl).append(", playUrl=").append(this.playUrl).append(", resolutions=").append(this.resolutions).append(", headers=").append(this.headers).append(", languages=").append(this.languages).append(", languageOptions=").append(this.languageOptions).append(", heastr=").append(this.heastr).append(", uastr=").append(this.uastr).append(", uaStr=").append(this.uaStr).append(", headerStr=").append(this.headerStr).append(", sourceType=").append(this.sourceType);
            sb.append(", host=").append(this.host).append(", file=").append(this.file).append(", key=").append(this.key).append(", supportedLanguages=").append(this.supportedLanguages).append(", season=").append(this.season).append(", episode=").append(this.episode).append(')');
            return sb.toString();
        }

        public VideoData(@JsonProperty("t") @Nullable String title, @JsonProperty("g") @Nullable String genre, @JsonProperty("y") @Nullable Integer year, @JsonProperty("c") @Nullable String cover, @JsonProperty("i") @Nullable String imdbRating, @JsonProperty("n") @Nullable Integer seasons, @JsonProperty("detail") @Nullable List<VideoSeasonDetail> list, @JsonProperty("so") @Nullable Integer sortOrder, @JsonProperty("q") @Nullable String quality, @JsonProperty("url") @Nullable String url, @JsonProperty("f") @Nullable Integer format, @JsonProperty("clientUrls") @Nullable List<ClientUrl> list2, @JsonProperty("videoUrl") @Nullable String videoUrl, @JsonProperty("playUrl") @Nullable String playUrl, @JsonProperty("resolutions") @Nullable List<Resolution> list3, @JsonProperty("headers") @Nullable Map<String, String> map, @JsonProperty("languages") @Nullable List<Language> list4, @JsonProperty("languageOptions") @Nullable List<Language> list5, @JsonProperty("heastr") @Nullable String heastr, @JsonProperty("uastr") @Nullable String uastr, @JsonProperty("uaStr") @Nullable String uaStr, @JsonProperty("headerStr") @Nullable String headerStr, @JsonProperty("sourceType") @Nullable String sourceType, @JsonProperty("host") @Nullable String host, @JsonProperty("file") @Nullable String file, @JsonProperty("key") @Nullable String key, @JsonProperty("supportedLanguages") @Nullable List<String> list6, @JsonProperty("season") @Nullable String season, @JsonProperty("episode") @Nullable String episode) {
            this.title = title;
            this.genre = genre;
            this.year = year;
            this.cover = cover;
            this.imdbRating = imdbRating;
            this.seasons = seasons;
            this.details = list;
            this.sortOrder = sortOrder;
            this.quality = quality;
            this.url = url;
            this.format = format;
            this.clientUrls = list2;
            this.videoUrl = videoUrl;
            this.playUrl = playUrl;
            this.resolutions = list3;
            this.headers = map;
            this.languages = list4;
            this.languageOptions = list5;
            this.heastr = heastr;
            this.uastr = uastr;
            this.uaStr = uaStr;
            this.headerStr = headerStr;
            this.sourceType = sourceType;
            this.host = host;
            this.file = file;
            this.key = key;
            this.supportedLanguages = list6;
            this.season = season;
            this.episode = episode;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ VideoData(String str, String str2, Integer num, String str3, String str4, Integer num2, List list, Integer num3, String str5, String str6, Integer num4, List list2, String str7, String str8, List list3, Map map, List list4, List list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, List list6, String str17, String str18, int i, DefaultConstructorMarker defaultConstructorMarker) {
            String str19 = (i & 1) != 0 ? null : str;
            String str20 = (i & 2) != 0 ? null : str2;
            Integer num5 = (i & 4) != 0 ? null : num;
            String str21 = (i & 8) != 0 ? null : str3;
            String str22 = (i & 16) != 0 ? null : str4;
            Integer num6 = (i & 32) != 0 ? null : num2;
            List list7 = (i & 64) != 0 ? null : list;
            Integer num7 = (i & 128) != 0 ? null : num3;
            String str23 = (i & 256) != 0 ? null : str5;
            String str24 = (i & 512) != 0 ? null : str6;
            Integer num8 = (i & 1024) != 0 ? null : num4;
            List list8 = (i & 2048) != 0 ? null : list2;
            String str25 = (i & 4096) != 0 ? null : str7;
            String str26 = (i & 8192) != 0 ? null : str8;
            List list9 = (i & 16384) != 0 ? null : list3;
            this(str19, str20, num5, str21, str22, num6, list7, num7, str23, str24, num8, list8, str25, str26, list9, (i & 32768) != 0 ? null : map, (i & 65536) != 0 ? null : list4, (i & 131072) != 0 ? null : list5, (i & 262144) != 0 ? null : str9, (i & 524288) != 0 ? null : str10, (i & 1048576) != 0 ? null : str11, (i & 2097152) != 0 ? null : str12, (i & 4194304) != 0 ? null : str13, (i & 8388608) != 0 ? null : str14, (i & 16777216) != 0 ? null : str15, (i & 33554432) != 0 ? null : str16, (i & 67108864) != 0 ? null : list6, (i & 134217728) != 0 ? null : str17, (i & 268435456) != 0 ? null : str18);
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getGenre() {
            return this.genre;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        public final String getCover() {
            return this.cover;
        }

        @Nullable
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        public final Integer getSeasons() {
            return this.seasons;
        }

        @Nullable
        public final List<VideoSeasonDetail> getDetails() {
            return this.details;
        }

        @Nullable
        public final Integer getSortOrder() {
            return this.sortOrder;
        }

        @Nullable
        public final String getQuality() {
            return this.quality;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final Integer getFormat() {
            return this.format;
        }

        @Nullable
        public final List<ClientUrl> getClientUrls() {
            return this.clientUrls;
        }

        @Nullable
        public final String getVideoUrl() {
            return this.videoUrl;
        }

        @Nullable
        public final String getPlayUrl() {
            return this.playUrl;
        }

        @Nullable
        public final List<Resolution> getResolutions() {
            return this.resolutions;
        }

        @Nullable
        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        @Nullable
        public final List<Language> getLanguages() {
            return this.languages;
        }

        @Nullable
        public final List<Language> getLanguageOptions() {
            return this.languageOptions;
        }

        @Nullable
        public final String getHeastr() {
            return this.heastr;
        }

        @Nullable
        public final String getUastr() {
            return this.uastr;
        }

        @Nullable
        public final String getUaStr() {
            return this.uaStr;
        }

        @Nullable
        public final String getHeaderStr() {
            return this.headerStr;
        }

        @Nullable
        public final String getSourceType() {
            return this.sourceType;
        }

        @Nullable
        public final String getHost() {
            return this.host;
        }

        @Nullable
        public final String getFile() {
            return this.file;
        }

        @Nullable
        public final String getKey() {
            return this.key;
        }

        @Nullable
        public final List<String> getSupportedLanguages() {
            return this.supportedLanguages;
        }

        @Nullable
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        public final String getEpisode() {
            return this.episode;
        }
    }

    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J8\u0010\u0015\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/cncverse/PikashowProvider$VideoSeasonDetail;", "", "season", "", "year", "", "episodes", "", "Lcom/cncverse/PikashowProvider$VideoEpisode;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getSeason", "()Ljava/lang/String;", "getYear", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisodes", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/cncverse/PikashowProvider$VideoSeasonDetail;", "equals", "", "other", "hashCode", "toString", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class VideoSeasonDetail {

        @JsonProperty("episodes")
        @Nullable
        private final List<VideoEpisode> episodes;

        @JsonProperty("season")
        @Nullable
        private final String season;

        @JsonProperty("year")
        @Nullable
        private final Integer year;

        public VideoSeasonDetail() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VideoSeasonDetail copy$default(VideoSeasonDetail videoSeasonDetail, String str, Integer num, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = videoSeasonDetail.season;
            }
            if ((i & 2) != 0) {
                num = videoSeasonDetail.year;
            }
            if ((i & 4) != 0) {
                list = videoSeasonDetail.episodes;
            }
            return videoSeasonDetail.copy(str, num, list);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        public final List<VideoEpisode> component3() {
            return this.episodes;
        }

        @NotNull
        public final VideoSeasonDetail copy(@JsonProperty("season") @Nullable String season, @JsonProperty("year") @Nullable Integer year, @JsonProperty("episodes") @Nullable List<VideoEpisode> episodes) {
            return new VideoSeasonDetail(season, year, episodes);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoSeasonDetail)) {
                return false;
            }
            VideoSeasonDetail videoSeasonDetail = (VideoSeasonDetail) other;
            return Intrinsics.areEqual(this.season, videoSeasonDetail.season) && Intrinsics.areEqual(this.year, videoSeasonDetail.year) && Intrinsics.areEqual(this.episodes, videoSeasonDetail.episodes);
        }

        public int hashCode() {
            return ((((this.season == null ? 0 : this.season.hashCode()) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.episodes != null ? this.episodes.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "VideoSeasonDetail(season=" + this.season + ", year=" + this.year + ", episodes=" + this.episodes + ')';
        }

        public VideoSeasonDetail(@JsonProperty("season") @Nullable String season, @JsonProperty("year") @Nullable Integer year, @JsonProperty("episodes") @Nullable List<VideoEpisode> list) {
            this.season = season;
            this.year = year;
            this.episodes = list;
        }

        public /* synthetic */ VideoSeasonDetail(String str, Integer num, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : list);
        }

        @Nullable
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        public final List<VideoEpisode> getEpisodes() {
            return this.episodes;
        }
    }

    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/cncverse/PikashowProvider$VideoEpisode;", "", "episode", "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getEpisode", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class VideoEpisode {

        @JsonProperty("e")
        @Nullable
        private final String episode;

        @JsonProperty("url")
        @Nullable
        private final String url;

        /* JADX WARN: Illegal instructions before constructor call */
        public VideoEpisode() {
            String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ VideoEpisode copy$default(VideoEpisode videoEpisode, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = videoEpisode.episode;
            }
            if ((i & 2) != 0) {
                str2 = videoEpisode.url;
            }
            return videoEpisode.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final VideoEpisode copy(@JsonProperty("e") @Nullable String episode, @JsonProperty("url") @Nullable String url) {
            return new VideoEpisode(episode, url);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoEpisode)) {
                return false;
            }
            VideoEpisode videoEpisode = (VideoEpisode) other;
            return Intrinsics.areEqual(this.episode, videoEpisode.episode) && Intrinsics.areEqual(this.url, videoEpisode.url);
        }

        public int hashCode() {
            return ((this.episode == null ? 0 : this.episode.hashCode()) * 31) + (this.url != null ? this.url.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "VideoEpisode(episode=" + this.episode + ", url=" + this.url + ')';
        }

        public VideoEpisode(@JsonProperty("e") @Nullable String episode, @JsonProperty("url") @Nullable String url) {
            this.episode = episode;
            this.url = url;
        }

        public /* synthetic */ VideoEpisode(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getEpisode() {
            return this.episode;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }
    }

    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/cncverse/PikashowProvider$Resolution;", "", "label", "", "url", "width", "", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getLabel", "()Ljava/lang/String;", "getUrl", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/cncverse/PikashowProvider$Resolution;", "equals", "", "other", "hashCode", "toString", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Resolution {

        @JsonProperty("height")
        @Nullable
        private final Integer height;

        @JsonProperty("label")
        @Nullable
        private final String label;

        @JsonProperty("url")
        @Nullable
        private final String url;

        @JsonProperty("width")
        @Nullable
        private final Integer width;

        public Resolution() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Resolution copy$default(Resolution resolution, String str, String str2, Integer num, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = resolution.label;
            }
            if ((i & 2) != 0) {
                str2 = resolution.url;
            }
            if ((i & 4) != 0) {
                num = resolution.width;
            }
            if ((i & 8) != 0) {
                num2 = resolution.height;
            }
            return resolution.copy(str, str2, num, num2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getWidth() {
            return this.width;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getHeight() {
            return this.height;
        }

        @NotNull
        public final Resolution copy(@JsonProperty("label") @Nullable String label, @JsonProperty("url") @Nullable String url, @JsonProperty("width") @Nullable Integer width, @JsonProperty("height") @Nullable Integer height) {
            return new Resolution(label, url, width, height);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Resolution)) {
                return false;
            }
            Resolution resolution = (Resolution) other;
            return Intrinsics.areEqual(this.label, resolution.label) && Intrinsics.areEqual(this.url, resolution.url) && Intrinsics.areEqual(this.width, resolution.width) && Intrinsics.areEqual(this.height, resolution.height);
        }

        public int hashCode() {
            return ((((((this.label == null ? 0 : this.label.hashCode()) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.width == null ? 0 : this.width.hashCode())) * 31) + (this.height != null ? this.height.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Resolution(label=" + this.label + ", url=" + this.url + ", width=" + this.width + ", height=" + this.height + ')';
        }

        public Resolution(@JsonProperty("label") @Nullable String label, @JsonProperty("url") @Nullable String url, @JsonProperty("width") @Nullable Integer width, @JsonProperty("height") @Nullable Integer height) {
            this.label = label;
            this.url = url;
            this.width = width;
            this.height = height;
        }

        public /* synthetic */ Resolution(String str, String str2, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2);
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final Integer getWidth() {
            return this.width;
        }

        @Nullable
        public final Integer getHeight() {
            return this.height;
        }
    }

    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/cncverse/PikashowProvider$Language;", "", "language", "", "playUrl", "resolutions", "", "Lcom/cncverse/PikashowProvider$Resolution;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getLanguage", "()Ljava/lang/String;", "getPlayUrl", "getResolutions", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Language {

        @JsonProperty("language")
        @Nullable
        private final String language;

        @JsonProperty("playUrl")
        @Nullable
        private final String playUrl;

        @JsonProperty("resolutions")
        @Nullable
        private final List<Resolution> resolutions;

        public Language() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Language copy$default(Language language, String str, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = language.language;
            }
            if ((i & 2) != 0) {
                str2 = language.playUrl;
            }
            if ((i & 4) != 0) {
                list = language.resolutions;
            }
            return language.copy(str, str2, list);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPlayUrl() {
            return this.playUrl;
        }

        @Nullable
        public final List<Resolution> component3() {
            return this.resolutions;
        }

        @NotNull
        public final Language copy(@JsonProperty("language") @Nullable String language, @JsonProperty("playUrl") @Nullable String playUrl, @JsonProperty("resolutions") @Nullable List<Resolution> resolutions) {
            return new Language(language, playUrl, resolutions);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Language)) {
                return false;
            }
            Language language = (Language) other;
            return Intrinsics.areEqual(this.language, language.language) && Intrinsics.areEqual(this.playUrl, language.playUrl) && Intrinsics.areEqual(this.resolutions, language.resolutions);
        }

        public int hashCode() {
            return ((((this.language == null ? 0 : this.language.hashCode()) * 31) + (this.playUrl == null ? 0 : this.playUrl.hashCode())) * 31) + (this.resolutions != null ? this.resolutions.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Language(language=" + this.language + ", playUrl=" + this.playUrl + ", resolutions=" + this.resolutions + ')';
        }

        public Language(@JsonProperty("language") @Nullable String language, @JsonProperty("playUrl") @Nullable String playUrl, @JsonProperty("resolutions") @Nullable List<Resolution> list) {
            this.language = language;
            this.playUrl = playUrl;
            this.resolutions = list;
        }

        public /* synthetic */ Language(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list);
        }

        @Nullable
        public final String getLanguage() {
            return this.language;
        }

        @Nullable
        public final String getPlayUrl() {
            return this.playUrl;
        }

        @Nullable
        public final List<Resolution> getResolutions() {
            return this.resolutions;
        }
    }

    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/cncverse/PikashowProvider$Keys;", "", "file", "", "key", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getKey", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Keys {

        @JsonProperty("file")
        @NotNull
        private final String file;

        @JsonProperty("key")
        @NotNull
        private final String key;

        public static /* synthetic */ Keys copy$default(Keys keys, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = keys.file;
            }
            if ((i & 2) != 0) {
                str2 = keys.key;
            }
            return keys.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        @NotNull
        public final Keys copy(@JsonProperty("file") @NotNull String file, @JsonProperty("key") @NotNull String key) {
            return new Keys(file, key);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Keys)) {
                return false;
            }
            Keys keys = (Keys) other;
            return Intrinsics.areEqual(this.file, keys.file) && Intrinsics.areEqual(this.key, keys.key);
        }

        public int hashCode() {
            return (this.file.hashCode() * 31) + this.key.hashCode();
        }

        @NotNull
        public String toString() {
            return "Keys(file=" + this.file + ", key=" + this.key + ')';
        }

        public Keys(@JsonProperty("file") @NotNull String file, @JsonProperty("key") @NotNull String key) {
            this.file = file;
            this.key = key;
        }

        @NotNull
        public final String getFile() {
            return this.file;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }
    }

    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/cncverse/PikashowProvider$Season;", "", "id", "", "folder", "", "Lcom/cncverse/PikashowProvider$HDBVEpisode;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getFolder", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Season {

        @JsonProperty("folder")
        @NotNull
        private final List<HDBVEpisode> folder;

        @JsonProperty("id")
        @NotNull
        private final String id;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Season copy$default(Season season, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = season.id;
            }
            if ((i & 2) != 0) {
                list = season.folder;
            }
            return season.copy(str, list);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final List<HDBVEpisode> component2() {
            return this.folder;
        }

        @NotNull
        public final Season copy(@JsonProperty("id") @NotNull String id, @JsonProperty("folder") @NotNull List<HDBVEpisode> folder) {
            return new Season(id, folder);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Season)) {
                return false;
            }
            Season season = (Season) other;
            return Intrinsics.areEqual(this.id, season.id) && Intrinsics.areEqual(this.folder, season.folder);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.folder.hashCode();
        }

        @NotNull
        public String toString() {
            return "Season(id=" + this.id + ", folder=" + this.folder + ')';
        }

        public Season(@JsonProperty("id") @NotNull String id, @JsonProperty("folder") @NotNull List<HDBVEpisode> list) {
            this.id = id;
            this.folder = list;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final List<HDBVEpisode> getFolder() {
            return this.folder;
        }
    }

    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/cncverse/PikashowProvider$HDBVEpisode;", "", "episode", "", "folder", "", "Lcom/cncverse/PikashowProvider$FileData;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getEpisode", "()Ljava/lang/String;", "getFolder", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class HDBVEpisode {

        @JsonProperty("episode")
        @NotNull
        private final String episode;

        @JsonProperty("folder")
        @NotNull
        private final List<FileData> folder;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HDBVEpisode copy$default(HDBVEpisode hDBVEpisode, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = hDBVEpisode.episode;
            }
            if ((i & 2) != 0) {
                list = hDBVEpisode.folder;
            }
            return hDBVEpisode.copy(str, list);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEpisode() {
            return this.episode;
        }

        @NotNull
        public final List<FileData> component2() {
            return this.folder;
        }

        @NotNull
        public final HDBVEpisode copy(@JsonProperty("episode") @NotNull String episode, @JsonProperty("folder") @NotNull List<FileData> folder) {
            return new HDBVEpisode(episode, folder);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HDBVEpisode)) {
                return false;
            }
            HDBVEpisode hDBVEpisode = (HDBVEpisode) other;
            return Intrinsics.areEqual(this.episode, hDBVEpisode.episode) && Intrinsics.areEqual(this.folder, hDBVEpisode.folder);
        }

        public int hashCode() {
            return (this.episode.hashCode() * 31) + this.folder.hashCode();
        }

        @NotNull
        public String toString() {
            return "HDBVEpisode(episode=" + this.episode + ", folder=" + this.folder + ')';
        }

        public HDBVEpisode(@JsonProperty("episode") @NotNull String episode, @JsonProperty("folder") @NotNull List<FileData> list) {
            this.episode = episode;
            this.folder = list;
        }

        @NotNull
        public final String getEpisode() {
            return this.episode;
        }

        @NotNull
        public final List<FileData> getFolder() {
            return this.folder;
        }
    }

    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/cncverse/PikashowProvider$FileData;", "", "file", "", "<init>", "(Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "PikashowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class FileData {

        @JsonProperty("file")
        @NotNull
        private final String file;

        public static /* synthetic */ FileData copy$default(FileData fileData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fileData.file;
            }
            return fileData.copy(str);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @NotNull
        public final FileData copy(@JsonProperty("file") @NotNull String file) {
            return new FileData(file);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FileData) && Intrinsics.areEqual(this.file, ((FileData) other).file);
        }

        public int hashCode() {
            return this.file.hashCode();
        }

        @NotNull
        public String toString() {
            return "FileData(file=" + this.file + ')';
        }

        public FileData(@JsonProperty("file") @NotNull String file) {
            this.file = file;
        }

        @NotNull
        public final String getFile() {
            return this.file;
        }
    }

    static /* synthetic */ Map generateSignature$default(PikashowProvider pikashowProvider, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return pikashowProvider.generateSignature(l);
    }

    private final Map<String, String> generateSignature(Long timestampMs) throws NoSuchAlgorithmException, InvalidKeyException {
        long timestamp = timestampMs != null ? timestampMs.longValue() : System.currentTimeMillis();
        long timestampSeconds = timestamp / ((long) 1000);
        String timestampStr = String.valueOf(timestampSeconds);
        String message = this.apiKey + ':' + timestampStr;
        Mac mac = Mac.getInstance("HmacSHA256");
        byte[] bytes = this.hmacSecret.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        SecretKeySpec secretKey = new SecretKeySpec(bytes, "HmacSHA256");
        mac.init(secretKey);
        byte[] bytes2 = message.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        byte[] signature = mac.doFinal(bytes2);
        String signatureHex = ArraysKt.joinToString$default(signature, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.cncverse.PikashowProvider$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                return PikashowProvider.generateSignature$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("X-Timestamp", timestampStr), TuplesKt.to("X-API-Key", this.apiKey), TuplesKt.to("X-Signature", signatureHex)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence generateSignature$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final Map<String, String> getPikashowHeaders() {
        Map sigHeaders = generateSignature$default(this, null, 1, null);
        Object obj = sigHeaders.get("X-API-Key");
        Intrinsics.checkNotNull(obj);
        Object obj2 = sigHeaders.get("X-Signature");
        Intrinsics.checkNotNull(obj2);
        Object obj3 = sigHeaders.get("X-Timestamp");
        Intrinsics.checkNotNull(obj3);
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("Host", "manoda.co"), TuplesKt.to("user-agent", "Pikashow/2509030 (Android 13; Pixel 5; Channel/pikashow; gaid/" + this.gaid + "); Uuid/" + this.deviceUuid), TuplesKt.to("X-API-Key", obj), TuplesKt.to("X-Signature", obj2), TuplesKt.to("X-Timestamp", obj3)});
    }

    /* JADX WARN: Code duplicated, block: B:104:0x03d0 A[Catch: Exception -> 0x04c3, TryCatch #20 {Exception -> 0x04c3, blocks: (B:102:0x03bf, B:104:0x03d0, B:106:0x03f6, B:108:0x0408, B:109:0x0415, B:110:0x0416, B:112:0x0423, B:113:0x0437, B:115:0x043d, B:117:0x0453, B:121:0x04a0, B:123:0x04a9, B:127:0x04be), top: B:224:0x03bf }] */
    /* JADX WARN: Code duplicated, block: B:106:0x03f6 A[Catch: Exception -> 0x04c3, TryCatch #20 {Exception -> 0x04c3, blocks: (B:102:0x03bf, B:104:0x03d0, B:106:0x03f6, B:108:0x0408, B:109:0x0415, B:110:0x0416, B:112:0x0423, B:113:0x0437, B:115:0x043d, B:117:0x0453, B:121:0x04a0, B:123:0x04a9, B:127:0x04be), top: B:224:0x03bf }] */
    /* JADX WARN: Code duplicated, block: B:107:0x0407  */
    /* JADX WARN: Code duplicated, block: B:110:0x0416 A[Catch: Exception -> 0x04c3, TryCatch #20 {Exception -> 0x04c3, blocks: (B:102:0x03bf, B:104:0x03d0, B:106:0x03f6, B:108:0x0408, B:109:0x0415, B:110:0x0416, B:112:0x0423, B:113:0x0437, B:115:0x043d, B:117:0x0453, B:121:0x04a0, B:123:0x04a9, B:127:0x04be), top: B:224:0x03bf }] */
    /* JADX WARN: Code duplicated, block: B:112:0x0423 A[Catch: Exception -> 0x04c3, TryCatch #20 {Exception -> 0x04c3, blocks: (B:102:0x03bf, B:104:0x03d0, B:106:0x03f6, B:108:0x0408, B:109:0x0415, B:110:0x0416, B:112:0x0423, B:113:0x0437, B:115:0x043d, B:117:0x0453, B:121:0x04a0, B:123:0x04a9, B:127:0x04be), top: B:224:0x03bf }] */
    /* JADX WARN: Code duplicated, block: B:115:0x043d A[Catch: Exception -> 0x04c3, TryCatch #20 {Exception -> 0x04c3, blocks: (B:102:0x03bf, B:104:0x03d0, B:106:0x03f6, B:108:0x0408, B:109:0x0415, B:110:0x0416, B:112:0x0423, B:113:0x0437, B:115:0x043d, B:117:0x0453, B:121:0x04a0, B:123:0x04a9, B:127:0x04be), top: B:224:0x03bf }] */
    /* JADX WARN: Code duplicated, block: B:117:0x0453 A[Catch: Exception -> 0x04c3, TryCatch #20 {Exception -> 0x04c3, blocks: (B:102:0x03bf, B:104:0x03d0, B:106:0x03f6, B:108:0x0408, B:109:0x0415, B:110:0x0416, B:112:0x0423, B:113:0x0437, B:115:0x043d, B:117:0x0453, B:121:0x04a0, B:123:0x04a9, B:127:0x04be), top: B:224:0x03bf }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0496  */
    /* JADX WARN: Code duplicated, block: B:121:0x04a0 A[Catch: Exception -> 0x04c3, TryCatch #20 {Exception -> 0x04c3, blocks: (B:102:0x03bf, B:104:0x03d0, B:106:0x03f6, B:108:0x0408, B:109:0x0415, B:110:0x0416, B:112:0x0423, B:113:0x0437, B:115:0x043d, B:117:0x0453, B:121:0x04a0, B:123:0x04a9, B:127:0x04be), top: B:224:0x03bf }] */
    /* JADX WARN: Code duplicated, block: B:125:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:126:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:139:0x0507 A[Catch: Exception -> 0x0555, PHI: r0 r53
      0x0507: PHI (r0v106 java.util.List) = (r0v57 java.util.List), (r0v84 java.util.List), (r0v90 java.util.List), (r0v94 java.util.List), (r0v110 java.util.List) binds: [B:93:0x0383, B:134:0x04e8, B:127:0x04be, B:124:0x04b9, B:138:0x0503] A[DONT_GENERATE, DONT_INLINE]
      0x0507: PHI (r53v12 com.cncverse.PikashowProvider$getMainPage$1) = 
      (r53v8 com.cncverse.PikashowProvider$getMainPage$1)
      (r53v11 com.cncverse.PikashowProvider$getMainPage$1)
      (r53v11 com.cncverse.PikashowProvider$getMainPage$1)
      (r53v11 com.cncverse.PikashowProvider$getMainPage$1)
      (r53v13 com.cncverse.PikashowProvider$getMainPage$1)
     binds: [B:93:0x0383, B:134:0x04e8, B:127:0x04be, B:124:0x04b9, B:138:0x0503] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #5 {Exception -> 0x0555, blocks: (B:138:0x0503, B:139:0x0507), top: B:194:0x0503 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x0511  */
    /* JADX WARN: Code duplicated, block: B:150:0x0550  */
    /* JADX WARN: Code duplicated, block: B:153:0x056e  */
    /* JADX WARN: Code duplicated, block: B:198:0x0243 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:200:0x0218 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:0x0236 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:222:0x03af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:230:0x04a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:233:0x033e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0121 A[Catch: Exception -> 0x06d2, TRY_LEAVE, TryCatch #6 {Exception -> 0x06d2, blocks: (B:24:0x011b, B:26:0x0121), top: B:196:0x011b }] */
    /* JADX WARN: Code duplicated, block: B:42:0x01dd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x01de  */
    /* JADX WARN: Code duplicated, block: B:46:0x0203 A[Catch: Exception -> 0x058d, TRY_LEAVE, TryCatch #1 {Exception -> 0x058d, blocks: (B:44:0x01f9, B:46:0x0203), top: B:186:0x01f9 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0212  */
    /* JADX WARN: Code duplicated, block: B:57:0x023c  */
    /* JADX WARN: Code duplicated, block: B:63:0x0269 A[Catch: Exception -> 0x035d, TryCatch #12 {Exception -> 0x035d, blocks: (B:61:0x025c, B:63:0x0269, B:65:0x028f, B:67:0x02a1, B:68:0x02ae, B:69:0x02af, B:71:0x02bc, B:72:0x02d1, B:74:0x02d7, B:76:0x02ed, B:80:0x033a, B:82:0x0343, B:86:0x0358), top: B:208:0x025c }] */
    /* JADX WARN: Code duplicated, block: B:65:0x028f A[Catch: Exception -> 0x035d, TryCatch #12 {Exception -> 0x035d, blocks: (B:61:0x025c, B:63:0x0269, B:65:0x028f, B:67:0x02a1, B:68:0x02ae, B:69:0x02af, B:71:0x02bc, B:72:0x02d1, B:74:0x02d7, B:76:0x02ed, B:80:0x033a, B:82:0x0343, B:86:0x0358), top: B:208:0x025c }] */
    /* JADX WARN: Code duplicated, block: B:66:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:69:0x02af A[Catch: Exception -> 0x035d, TryCatch #12 {Exception -> 0x035d, blocks: (B:61:0x025c, B:63:0x0269, B:65:0x028f, B:67:0x02a1, B:68:0x02ae, B:69:0x02af, B:71:0x02bc, B:72:0x02d1, B:74:0x02d7, B:76:0x02ed, B:80:0x033a, B:82:0x0343, B:86:0x0358), top: B:208:0x025c }] */
    /* JADX WARN: Code duplicated, block: B:71:0x02bc A[Catch: Exception -> 0x035d, TryCatch #12 {Exception -> 0x035d, blocks: (B:61:0x025c, B:63:0x0269, B:65:0x028f, B:67:0x02a1, B:68:0x02ae, B:69:0x02af, B:71:0x02bc, B:72:0x02d1, B:74:0x02d7, B:76:0x02ed, B:80:0x033a, B:82:0x0343, B:86:0x0358), top: B:208:0x025c }] */
    /* JADX WARN: Code duplicated, block: B:74:0x02d7 A[Catch: Exception -> 0x035d, TryCatch #12 {Exception -> 0x035d, blocks: (B:61:0x025c, B:63:0x0269, B:65:0x028f, B:67:0x02a1, B:68:0x02ae, B:69:0x02af, B:71:0x02bc, B:72:0x02d1, B:74:0x02d7, B:76:0x02ed, B:80:0x033a, B:82:0x0343, B:86:0x0358), top: B:208:0x025c }] */
    /* JADX WARN: Code duplicated, block: B:76:0x02ed A[Catch: Exception -> 0x035d, TryCatch #12 {Exception -> 0x035d, blocks: (B:61:0x025c, B:63:0x0269, B:65:0x028f, B:67:0x02a1, B:68:0x02ae, B:69:0x02af, B:71:0x02bc, B:72:0x02d1, B:74:0x02d7, B:76:0x02ed, B:80:0x033a, B:82:0x0343, B:86:0x0358), top: B:208:0x025c }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0330  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x033a A[Catch: Exception -> 0x035d, TryCatch #12 {Exception -> 0x035d, blocks: (B:61:0x025c, B:63:0x0269, B:65:0x028f, B:67:0x02a1, B:68:0x02ae, B:69:0x02af, B:71:0x02bc, B:72:0x02d1, B:74:0x02d7, B:76:0x02ed, B:80:0x033a, B:82:0x0343, B:86:0x0358), top: B:208:0x025c }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0355  */
    /* JADX WARN: Code duplicated, block: B:85:0x0356  */
    /* JADX WARN: Code duplicated, block: B:93:0x0383 A[PHI: r0 r53
      0x0383: PHI (r0v57 java.util.List) = (r0v56 java.util.List), (r0v63 java.util.List), (r0v67 java.util.List) binds: [B:92:0x0362, B:86:0x0358, B:83:0x0353] A[DONT_GENERATE, DONT_INLINE]
      0x0383: PHI (r53v8 com.cncverse.PikashowProvider$getMainPage$1) = 
      (r53v7 com.cncverse.PikashowProvider$getMainPage$1)
      (r53v9 com.cncverse.PikashowProvider$getMainPage$1)
      (r53v9 com.cncverse.PikashowProvider$getMainPage$1)
     binds: [B:92:0x0362, B:86:0x0358, B:83:0x0353] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:96:0x03a2 A[Catch: Exception -> 0x04ea, TRY_LEAVE, TryCatch #3 {Exception -> 0x04ea, blocks: (B:92:0x0362, B:96:0x03a2, B:133:0x04c8), top: B:190:0x0362 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x03aa  */
    /* JADX WARN: Failed to apply debug info
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 18921. Try increasing type updates limit count.
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.requestUpdate(TypeUpdateInfo.java:61)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:298)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyDebugInfo(TypeUpdate.java:77)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:75)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:170:0x068a -> B:171:0x06a0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x01de -> B:186:0x01f9). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:141:0x0511
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getMainPage(int r51, @org.jetbrains.annotations.NotNull com.lagradost.cloudstream3.MainPageRequest r52, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r53) {
        /*
            Method dump skipped, instruction units count: 1892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.PikashowProvider.getMainPage(int, com.lagradost.cloudstream3.MainPageRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$0$0$0$0(PikashowSeries $series, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($series.getCover());
        $this$newTvSeriesSearchResponse.setYear($series.getYear());
        $this$newTvSeriesSearchResponse.setQuality(SearchQuality.HD);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$0$1$0$0(PikashowMovie $movie, PikashowProvider this$0, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($movie.getCover());
        $this$newMovieSearchResponse.setYear($movie.getYear());
        $this$newMovieSearchResponse.setQuality(this$0.getQualityFromString($movie.getQuality()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$1(MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl((String) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final SearchQuality getQualityFromString(String qualityString) {
        String upperCase;
        if (qualityString != null) {
            upperCase = qualityString.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        } else {
            upperCase = null;
        }
        if (upperCase == null) {
            return null;
        }
        switch (upperCase.hashCode()) {
            case -577968313:
                if (!upperCase.equals("TELECINE")) {
                    return null;
                }
                return SearchQuality.Telecine;
            case -577476283:
                if (!upperCase.equals("TELESYNC")) {
                    return null;
                }
                return SearchQuality.Telesync;
            case -402211300:
                if (!upperCase.equals("WORKPRINT")) {
                    return null;
                }
                return SearchQuality.WorkPrint;
            case 1687:
                if (!upperCase.equals("4K")) {
                    return null;
                }
                return SearchQuality.HD;
            case 2300:
                if (!upperCase.equals("HD")) {
                    return null;
                }
                return SearchQuality.HD;
            case 2671:
                if (!upperCase.equals("TC")) {
                    return null;
                }
                return SearchQuality.Telecine;
            case 2687:
                if (!upperCase.equals("TS")) {
                    return null;
                }
                return SearchQuality.Telesync;
            case 2777:
                if (!upperCase.equals("WP")) {
                    return null;
                }
                return SearchQuality.WorkPrint;
            case 66479:
                if (!upperCase.equals("CAM")) {
                    return null;
                }
                return SearchQuality.Cam;
            case 69570:
                if (!upperCase.equals("FHD")) {
                    return null;
                }
                return SearchQuality.HD;
            case 1688123:
                if (!upperCase.equals("720P")) {
                    return null;
                }
                return SearchQuality.HD;
            case 46737881:
                if (!upperCase.equals("1080P")) {
                    return null;
                }
                return SearchQuality.HD;
            case 47689271:
                if (!upperCase.equals("2160P")) {
                    return null;
                }
                return SearchQuality.HD;
            case 68585779:
                if (upperCase.equals("HDCAM")) {
                    return SearchQuality.HdCam;
                }
                return null;
            case 1980557034:
                if (!upperCase.equals("CAMRIP")) {
                    return null;
                }
                return SearchQuality.Cam;
            default:
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:115:0x0437  */
    /* JADX WARN: Code duplicated, block: B:118:0x0441  */
    /* JADX WARN: Code duplicated, block: B:125:0x046b A[Catch: Exception -> 0x05ab, TryCatch #2 {Exception -> 0x05ab, blocks: (B:123:0x045a, B:125:0x046b, B:127:0x0491, B:129:0x04a3, B:130:0x04b0, B:131:0x04b1, B:133:0x04bc, B:134:0x04c3, B:136:0x04c9, B:138:0x04d8), top: B:221:0x045a }] */
    /* JADX WARN: Code duplicated, block: B:127:0x0491 A[Catch: Exception -> 0x05ab, TryCatch #2 {Exception -> 0x05ab, blocks: (B:123:0x045a, B:125:0x046b, B:127:0x0491, B:129:0x04a3, B:130:0x04b0, B:131:0x04b1, B:133:0x04bc, B:134:0x04c3, B:136:0x04c9, B:138:0x04d8), top: B:221:0x045a }] */
    /* JADX WARN: Code duplicated, block: B:128:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:131:0x04b1 A[Catch: Exception -> 0x05ab, TryCatch #2 {Exception -> 0x05ab, blocks: (B:123:0x045a, B:125:0x046b, B:127:0x0491, B:129:0x04a3, B:130:0x04b0, B:131:0x04b1, B:133:0x04bc, B:134:0x04c3, B:136:0x04c9, B:138:0x04d8), top: B:221:0x045a }] */
    /* JADX WARN: Code duplicated, block: B:133:0x04bc A[Catch: Exception -> 0x05ab, TryCatch #2 {Exception -> 0x05ab, blocks: (B:123:0x045a, B:125:0x046b, B:127:0x0491, B:129:0x04a3, B:130:0x04b0, B:131:0x04b1, B:133:0x04bc, B:134:0x04c3, B:136:0x04c9, B:138:0x04d8), top: B:221:0x045a }] */
    /* JADX WARN: Code duplicated, block: B:136:0x04c9 A[Catch: Exception -> 0x05ab, TryCatch #2 {Exception -> 0x05ab, blocks: (B:123:0x045a, B:125:0x046b, B:127:0x0491, B:129:0x04a3, B:130:0x04b0, B:131:0x04b1, B:133:0x04bc, B:134:0x04c3, B:136:0x04c9, B:138:0x04d8), top: B:221:0x045a }] */
    /* JADX WARN: Code duplicated, block: B:138:0x04d8 A[Catch: Exception -> 0x05ab, TRY_LEAVE, TryCatch #2 {Exception -> 0x05ab, blocks: (B:123:0x045a, B:125:0x046b, B:127:0x0491, B:129:0x04a3, B:130:0x04b0, B:131:0x04b1, B:133:0x04bc, B:134:0x04c3, B:136:0x04c9, B:138:0x04d8), top: B:221:0x045a }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0508 A[Catch: Exception -> 0x0534, TryCatch #6 {Exception -> 0x0534, blocks: (B:142:0x0502, B:144:0x0508, B:146:0x0513), top: B:229:0x0502 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x0513 A[Catch: Exception -> 0x0534, TRY_LEAVE, TryCatch #6 {Exception -> 0x0534, blocks: (B:142:0x0502, B:144:0x0508, B:146:0x0513), top: B:229:0x0502 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x0523  */
    /* JADX WARN: Code duplicated, block: B:154:0x0529  */
    /* JADX WARN: Code duplicated, block: B:158:0x0531  */
    /* JADX WARN: Code duplicated, block: B:161:0x0538  */
    /* JADX WARN: Code duplicated, block: B:167:0x0578  */
    /* JADX WARN: Code duplicated, block: B:170:0x05a3  */
    /* JADX WARN: Code duplicated, block: B:185:0x063e  */
    /* JADX WARN: Code duplicated, block: B:225:0x0230 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:229:0x0502 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:235:0x044a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:253:0x020f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:259:0x0259 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:261:0x0268 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0130 A[Catch: Exception -> 0x07db, TRY_LEAVE, TryCatch #13 {Exception -> 0x07db, blocks: (B:28:0x012a, B:30:0x0130), top: B:243:0x012a }] */
    /* JADX WARN: Code duplicated, block: B:46:0x01ea A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:54:0x0224  */
    /* JADX WARN: Code duplicated, block: B:62:0x025f  */
    /* JADX WARN: Code duplicated, block: B:70:0x0290 A[Catch: Exception -> 0x03c4, TryCatch #25 {Exception -> 0x03c4, blocks: (B:68:0x0283, B:70:0x0290, B:72:0x02b6, B:74:0x02c8, B:75:0x02d5, B:76:0x02d6, B:78:0x02e1, B:79:0x02e8, B:81:0x02ee, B:83:0x0300, B:85:0x032a, B:87:0x0330, B:89:0x033b, B:96:0x0354), top: B:267:0x0283 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x02b6 A[Catch: Exception -> 0x03c4, TryCatch #25 {Exception -> 0x03c4, blocks: (B:68:0x0283, B:70:0x0290, B:72:0x02b6, B:74:0x02c8, B:75:0x02d5, B:76:0x02d6, B:78:0x02e1, B:79:0x02e8, B:81:0x02ee, B:83:0x0300, B:85:0x032a, B:87:0x0330, B:89:0x033b, B:96:0x0354), top: B:267:0x0283 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:76:0x02d6 A[Catch: Exception -> 0x03c4, TryCatch #25 {Exception -> 0x03c4, blocks: (B:68:0x0283, B:70:0x0290, B:72:0x02b6, B:74:0x02c8, B:75:0x02d5, B:76:0x02d6, B:78:0x02e1, B:79:0x02e8, B:81:0x02ee, B:83:0x0300, B:85:0x032a, B:87:0x0330, B:89:0x033b, B:96:0x0354), top: B:267:0x0283 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x02e1 A[Catch: Exception -> 0x03c4, TryCatch #25 {Exception -> 0x03c4, blocks: (B:68:0x0283, B:70:0x0290, B:72:0x02b6, B:74:0x02c8, B:75:0x02d5, B:76:0x02d6, B:78:0x02e1, B:79:0x02e8, B:81:0x02ee, B:83:0x0300, B:85:0x032a, B:87:0x0330, B:89:0x033b, B:96:0x0354), top: B:267:0x0283 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x02ee A[Catch: Exception -> 0x03c4, TryCatch #25 {Exception -> 0x03c4, blocks: (B:68:0x0283, B:70:0x0290, B:72:0x02b6, B:74:0x02c8, B:75:0x02d5, B:76:0x02d6, B:78:0x02e1, B:79:0x02e8, B:81:0x02ee, B:83:0x0300, B:85:0x032a, B:87:0x0330, B:89:0x033b, B:96:0x0354), top: B:267:0x0283 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0300 A[Catch: Exception -> 0x03c4, TryCatch #25 {Exception -> 0x03c4, blocks: (B:68:0x0283, B:70:0x0290, B:72:0x02b6, B:74:0x02c8, B:75:0x02d5, B:76:0x02d6, B:78:0x02e1, B:79:0x02e8, B:81:0x02ee, B:83:0x0300, B:85:0x032a, B:87:0x0330, B:89:0x033b, B:96:0x0354), top: B:267:0x0283 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x032a A[Catch: Exception -> 0x03c4, TryCatch #25 {Exception -> 0x03c4, blocks: (B:68:0x0283, B:70:0x0290, B:72:0x02b6, B:74:0x02c8, B:75:0x02d5, B:76:0x02d6, B:78:0x02e1, B:79:0x02e8, B:81:0x02ee, B:83:0x0300, B:85:0x032a, B:87:0x0330, B:89:0x033b, B:96:0x0354), top: B:267:0x0283 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0330 A[Catch: Exception -> 0x03c4, TryCatch #25 {Exception -> 0x03c4, blocks: (B:68:0x0283, B:70:0x0290, B:72:0x02b6, B:74:0x02c8, B:75:0x02d5, B:76:0x02d6, B:78:0x02e1, B:79:0x02e8, B:81:0x02ee, B:83:0x0300, B:85:0x032a, B:87:0x0330, B:89:0x033b, B:96:0x0354), top: B:267:0x0283 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x033b A[Catch: Exception -> 0x03c4, TryCatch #25 {Exception -> 0x03c4, blocks: (B:68:0x0283, B:70:0x0290, B:72:0x02b6, B:74:0x02c8, B:75:0x02d5, B:76:0x02d6, B:78:0x02e1, B:79:0x02e8, B:81:0x02ee, B:83:0x0300, B:85:0x032a, B:87:0x0330, B:89:0x033b, B:96:0x0354), top: B:267:0x0283 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x034d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0350  */
    /* JADX WARN: Code duplicated, block: B:95:0x0351  */
    /* JADX WARN: Code duplicated, block: B:96:0x0354 A[Catch: Exception -> 0x03c4, TRY_LEAVE, TryCatch #25 {Exception -> 0x03c4, blocks: (B:68:0x0283, B:70:0x0290, B:72:0x02b6, B:74:0x02c8, B:75:0x02d5, B:76:0x02d6, B:78:0x02e1, B:79:0x02e8, B:81:0x02ee, B:83:0x0300, B:85:0x032a, B:87:0x0330, B:89:0x033b, B:96:0x0354), top: B:267:0x0283 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0392  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:205:0x07a3 -> B:206:0x07ad). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x01eb -> B:239:0x0203). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object search(@org.jetbrains.annotations.NotNull java.lang.String r50, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r51) {
        /*
            Method dump skipped, instruction units count: 2122
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.PikashowProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0$0$0(PikashowSeries $series, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($series.getCover());
        $this$newTvSeriesSearchResponse.setYear($series.getYear());
        $this$newTvSeriesSearchResponse.setQuality(SearchQuality.HD);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$1$0$0(PikashowMovie $movie, PikashowProvider this$0, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($movie.getCover());
        $this$newMovieSearchResponse.setYear($movie.getYear());
        $this$newMovieSearchResponse.setQuality(this$0.getQualityFromString($movie.getQuality()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.databind.RuntimeJsonMappingException */
    /* JADX WARN: Code duplicated, block: B:108:0x04b6 A[Catch: Exception -> 0x06e3, TryCatch #11 {Exception -> 0x06e3, blocks: (B:88:0x03dd, B:53:0x0293, B:55:0x029d, B:57:0x02b8, B:59:0x02de, B:61:0x02f0, B:62:0x02fd, B:63:0x02fe, B:65:0x0309, B:66:0x030f, B:68:0x0315, B:72:0x032d, B:75:0x0334, B:78:0x0341, B:106:0x04ac, B:108:0x04b6, B:110:0x04cf, B:112:0x04f5, B:114:0x0507, B:115:0x0514, B:116:0x0515, B:118:0x0520, B:119:0x0526, B:121:0x052c, B:125:0x0540, B:128:0x0547, B:135:0x0574, B:137:0x057a, B:143:0x0589), top: B:204:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x04cf A[Catch: Exception -> 0x06e3, TryCatch #11 {Exception -> 0x06e3, blocks: (B:88:0x03dd, B:53:0x0293, B:55:0x029d, B:57:0x02b8, B:59:0x02de, B:61:0x02f0, B:62:0x02fd, B:63:0x02fe, B:65:0x0309, B:66:0x030f, B:68:0x0315, B:72:0x032d, B:75:0x0334, B:78:0x0341, B:106:0x04ac, B:108:0x04b6, B:110:0x04cf, B:112:0x04f5, B:114:0x0507, B:115:0x0514, B:116:0x0515, B:118:0x0520, B:119:0x0526, B:121:0x052c, B:125:0x0540, B:128:0x0547, B:135:0x0574, B:137:0x057a, B:143:0x0589), top: B:204:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x04f5 A[Catch: Exception -> 0x06e3, TryCatch #11 {Exception -> 0x06e3, blocks: (B:88:0x03dd, B:53:0x0293, B:55:0x029d, B:57:0x02b8, B:59:0x02de, B:61:0x02f0, B:62:0x02fd, B:63:0x02fe, B:65:0x0309, B:66:0x030f, B:68:0x0315, B:72:0x032d, B:75:0x0334, B:78:0x0341, B:106:0x04ac, B:108:0x04b6, B:110:0x04cf, B:112:0x04f5, B:114:0x0507, B:115:0x0514, B:116:0x0515, B:118:0x0520, B:119:0x0526, B:121:0x052c, B:125:0x0540, B:128:0x0547, B:135:0x0574, B:137:0x057a, B:143:0x0589), top: B:204:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0506  */
    /* JADX WARN: Code duplicated, block: B:116:0x0515 A[Catch: Exception -> 0x06e3, TryCatch #11 {Exception -> 0x06e3, blocks: (B:88:0x03dd, B:53:0x0293, B:55:0x029d, B:57:0x02b8, B:59:0x02de, B:61:0x02f0, B:62:0x02fd, B:63:0x02fe, B:65:0x0309, B:66:0x030f, B:68:0x0315, B:72:0x032d, B:75:0x0334, B:78:0x0341, B:106:0x04ac, B:108:0x04b6, B:110:0x04cf, B:112:0x04f5, B:114:0x0507, B:115:0x0514, B:116:0x0515, B:118:0x0520, B:119:0x0526, B:121:0x052c, B:125:0x0540, B:128:0x0547, B:135:0x0574, B:137:0x057a, B:143:0x0589), top: B:204:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0520 A[Catch: Exception -> 0x06e3, TryCatch #11 {Exception -> 0x06e3, blocks: (B:88:0x03dd, B:53:0x0293, B:55:0x029d, B:57:0x02b8, B:59:0x02de, B:61:0x02f0, B:62:0x02fd, B:63:0x02fe, B:65:0x0309, B:66:0x030f, B:68:0x0315, B:72:0x032d, B:75:0x0334, B:78:0x0341, B:106:0x04ac, B:108:0x04b6, B:110:0x04cf, B:112:0x04f5, B:114:0x0507, B:115:0x0514, B:116:0x0515, B:118:0x0520, B:119:0x0526, B:121:0x052c, B:125:0x0540, B:128:0x0547, B:135:0x0574, B:137:0x057a, B:143:0x0589), top: B:204:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x052c A[Catch: Exception -> 0x06e3, TryCatch #11 {Exception -> 0x06e3, blocks: (B:88:0x03dd, B:53:0x0293, B:55:0x029d, B:57:0x02b8, B:59:0x02de, B:61:0x02f0, B:62:0x02fd, B:63:0x02fe, B:65:0x0309, B:66:0x030f, B:68:0x0315, B:72:0x032d, B:75:0x0334, B:78:0x0341, B:106:0x04ac, B:108:0x04b6, B:110:0x04cf, B:112:0x04f5, B:114:0x0507, B:115:0x0514, B:116:0x0515, B:118:0x0520, B:119:0x0526, B:121:0x052c, B:125:0x0540, B:128:0x0547, B:135:0x0574, B:137:0x057a, B:143:0x0589), top: B:204:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0544  */
    /* JADX WARN: Code duplicated, block: B:128:0x0547 A[Catch: Exception -> 0x06e3, TRY_LEAVE, TryCatch #11 {Exception -> 0x06e3, blocks: (B:88:0x03dd, B:53:0x0293, B:55:0x029d, B:57:0x02b8, B:59:0x02de, B:61:0x02f0, B:62:0x02fd, B:63:0x02fe, B:65:0x0309, B:66:0x030f, B:68:0x0315, B:72:0x032d, B:75:0x0334, B:78:0x0341, B:106:0x04ac, B:108:0x04b6, B:110:0x04cf, B:112:0x04f5, B:114:0x0507, B:115:0x0514, B:116:0x0515, B:118:0x0520, B:119:0x0526, B:121:0x052c, B:125:0x0540, B:128:0x0547, B:135:0x0574, B:137:0x057a, B:143:0x0589), top: B:204:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0564 A[Catch: Exception -> 0x0612, TRY_LEAVE, TryCatch #4 {Exception -> 0x0612, blocks: (B:130:0x0557, B:131:0x055e, B:133:0x0564, B:141:0x0583, B:150:0x059c), top: B:209:0x0557 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x057f  */
    /* JADX WARN: Code duplicated, block: B:143:0x0589 A[Catch: Exception -> 0x06e3, TRY_ENTER, TRY_LEAVE, TryCatch #11 {Exception -> 0x06e3, blocks: (B:88:0x03dd, B:53:0x0293, B:55:0x029d, B:57:0x02b8, B:59:0x02de, B:61:0x02f0, B:62:0x02fd, B:63:0x02fe, B:65:0x0309, B:66:0x030f, B:68:0x0315, B:72:0x032d, B:75:0x0334, B:78:0x0341, B:106:0x04ac, B:108:0x04b6, B:110:0x04cf, B:112:0x04f5, B:114:0x0507, B:115:0x0514, B:116:0x0515, B:118:0x0520, B:119:0x0526, B:121:0x052c, B:125:0x0540, B:128:0x0547, B:135:0x0574, B:137:0x057a, B:143:0x0589), top: B:204:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x058e  */
    /* JADX WARN: Code duplicated, block: B:149:0x059a A[LOOP:3: B:149:0x059a->B:154:0x05e1, LOOP_START, PHI: r0 r2 r6 r7 r8 r32
      0x059a: PHI (r0v38 'episodeNum' int) = (r0v36 'episodeNum' int), (r0v39 'episodeNum' int) binds: [B:147:0x0597, B:154:0x05e1] A[DONT_GENERATE, DONT_INLINE]
      0x059a: PHI (r2v30 'series' com.cncverse.PikashowProvider$PikashowSeries) = 
      (r2v28 'series' com.cncverse.PikashowProvider$PikashowSeries)
      (r2v34 'series' com.cncverse.PikashowProvider$PikashowSeries)
     binds: [B:147:0x0597, B:154:0x05e1] A[DONT_GENERATE, DONT_INLINE]
      0x059a: PHI (r6v14 '$this$forEach$iv' java.lang.Iterable) = (r6v12 '$this$forEach$iv' java.lang.Iterable), (r6v23 '$this$forEach$iv' java.lang.Iterable) binds: [B:147:0x0597, B:154:0x05e1] A[DONT_GENERATE, DONT_INLINE]
      0x059a: PHI (r7v21 'identifier' java.lang.String) = (r7v18 'identifier' java.lang.String), (r7v26 'identifier' java.lang.String) binds: [B:147:0x0597, B:154:0x05e1] A[DONT_GENERATE, DONT_INLINE]
      0x059a: PHI (r8v21 'url' java.lang.String) = (r8v19 'url' java.lang.String), (r8v24 'url' java.lang.String) binds: [B:147:0x0597, B:154:0x05e1] A[DONT_GENERATE, DONT_INLINE]
      0x059a: PHI (r32v6 'seasonNumber' int) = (r32v3 'seasonNumber' int), (r32v8 'seasonNumber' int) binds: [B:147:0x0597, B:154:0x05e1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:154:0x05e1 A[LOOP:3: B:149:0x059a->B:154:0x05e1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:155:0x05ee  */
    /* JADX WARN: Code duplicated, block: B:160:0x0618  */
    /* JADX WARN: Code duplicated, block: B:163:0x062a  */
    /* JADX WARN: Code duplicated, block: B:174:0x069c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:175:0x069d  */
    /* JADX WARN: Code duplicated, block: B:184:0x06c6  */
    /* JADX WARN: Code duplicated, block: B:185:0x06d4  */
    /* JADX WARN: Code duplicated, block: B:209:0x0557 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:228:0x053f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01d0, code lost:
    
        if (r15.equals("hollywood") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x01e0, code lost:
    
        if (r15.equals("bollywood") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01e2, code lost:
    
        r27 = r7;
        r30 = r14;
        r26 = r15;
        r8 = r15;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01f5, code lost:
    
        r0 = getMainUrl() + "/v1/api/videos";
        r10 = kotlin.collections.MapsKt.mapOf(new kotlin.Pair[]{kotlin.TuplesKt.to("type", r15), kotlin.TuplesKt.to("channel", "pikashow")});
        r6 = com.lagradost.cloudstream3.MainActivityKt.getApp();
        r12.L$0 = r32;
        r12.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r24);
        r12.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7);
        r12.L$3 = r14;
        r12.L$4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15);
        r12.L$5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15);
        r12.L$6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0);
        r12.L$7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10);
        r12.label = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0251, code lost:
    
        r26 = r15;
        r5 = "Deserialized value did not match the specified type; specified ";
        r4 = r6;
        r3 = " but was ";
        r27 = r7;
        r2 = 200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0282, code lost:
    
        r6 = com.lagradost.nicehttp.Requests.get$default(r6, r0, r15, (java.lang.String) null, r10, (java.util.Map) null, false, 0, (java.util.concurrent.TimeUnit) null, 30, (okhttp3.Interceptor) null, false, (com.lagradost.nicehttp.ResponseParser) null, r12, 3828, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0286, code lost:
    
        r12 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0288, code lost:
    
        if (r6 != r4) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x028a, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x028b, code lost:
    
        r14 = r0;
        r15 = r15;
        r13 = r10;
        r8 = r32;
        r7 = r14;
        r0 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x03e4, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x03e5, code lost:
    
        r2 = null;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws RuntimeJsonMappingException {
        C00051 c00051;
        String url2;
        String withoutUrlScheme;
        String type;
        List parts;
        String identifier;
        String type2;
        Map<String, String> map;
        Object obj;
        int i;
        Object obj2;
        String type3;
        Object obj3;
        String identifier2;
        Map<String, String> map2;
        Map params;
        List parts2;
        String identifier3;
        String url3;
        NiceResponse response;
        TvSeriesLoadResponse tvSeriesLoadResponse;
        Object $this$checkTypeMismatch$iv$iv;
        PikashowSeriesResponse seriesResponse;
        List<PikashowSeries> series;
        PikashowSeries series2;
        PikashowSeries seriesData;
        List episodes;
        Iterable details;
        Iterable $this$forEach$iv;
        PikashowSeriesResponse seriesResponse2;
        PikashowSeries series3;
        String identifier4;
        String url4;
        String season;
        int iIntValue;
        int seasonNumber;
        Integer episodesCount;
        int iIntValue2;
        int episodeCount;
        final int episodeNum;
        PikashowSeries series4;
        Iterable $this$forEach$iv2;
        String identifier5;
        String url5;
        final int seasonNumber2;
        Integer intOrNull;
        String title;
        Object objNewTvSeriesLoadResponse;
        Map<String, String> map3;
        String withoutUrlScheme2;
        String seriesUrl;
        Iterator<T> it;
        Object next;
        PikashowSeries it2;
        String qualifiedName;
        MovieLoadResponse movieLoadResponse;
        PikashowMovie movie;
        Object objNewMovieLoadResponse;
        String withoutUrlScheme3;
        Map<String, String> map4;
        String type4;
        List parts3;
        String identifier6;
        String identifier7;
        Object next2;
        PikashowMovie it3;
        if (continuation instanceof C00051) {
            c00051 = (C00051) continuation;
            if ((c00051.label & Integer.MIN_VALUE) != 0) {
                c00051.label -= Integer.MIN_VALUE;
            } else {
                c00051 = new C00051(continuation);
            }
        } else {
            c00051 = new C00051(continuation);
        }
        C00051 c00052 = c00051;
        Object $result = c00052.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                try {
                    switch (c00052.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            try {
                                withoutUrlScheme = StringsKt.removePrefix(url, getMainUrl() + '/');
                                List parts4 = StringsKt.split$default(withoutUrlScheme, new String[]{":"}, false, 0, 6, (Object) null);
                                if (parts4.size() == 3 && Intrinsics.areEqual(parts4.get(0), "pikashow")) {
                                    String identifier8 = (String) parts4.get(1);
                                    String type5 = (String) parts4.get(2);
                                    Map<String, String> pikashowHeaders = getPikashowHeaders();
                                    switch (type5.hashCode()) {
                                        case -905838985:
                                            parts = parts4;
                                            i = 200;
                                            map = pikashowHeaders;
                                            try {
                                                if (!type5.equals("series")) {
                                                    identifier = identifier8;
                                                    type2 = type5;
                                                    obj = null;
                                                    return obj;
                                                }
                                                String seriesUrl2 = getMainUrl() + "/v1/api/videos";
                                                Map params2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "series"), TuplesKt.to("channel", "pikashow")});
                                                obj2 = coroutine_suspended;
                                                Requests app = MainActivityKt.getApp();
                                                c00052.L$0 = url;
                                                c00052.L$1 = SpillingKt.nullOutSpilledVariable(withoutUrlScheme);
                                                c00052.L$2 = SpillingKt.nullOutSpilledVariable(parts);
                                                c00052.L$3 = identifier8;
                                                c00052.L$4 = SpillingKt.nullOutSpilledVariable(type5);
                                                c00052.L$5 = SpillingKt.nullOutSpilledVariable(map);
                                                c00052.L$6 = SpillingKt.nullOutSpilledVariable(seriesUrl2);
                                                c00052.L$7 = SpillingKt.nullOutSpilledVariable(params2);
                                                c00052.label = 1;
                                                type3 = type5;
                                                try {
                                                    obj3 = Requests.get$default(app, seriesUrl2, map, (String) null, params2, (Map) null, false, 0, (TimeUnit) null, 30L, (Interceptor) null, false, (ResponseParser) null, c00052, 3828, (Object) null);
                                                    c00052 = c00052;
                                                    if (obj3 == obj2) {
                                                        return obj2;
                                                    }
                                                    identifier2 = seriesUrl2;
                                                    map2 = map;
                                                    params = params2;
                                                    parts2 = parts;
                                                    identifier3 = identifier8;
                                                    url3 = url;
                                                    response = (NiceResponse) obj3;
                                                    if (response.getCode() == i) {
                                                        ObjectMapper $this$readValue$iv = this.mapper;
                                                        String content$iv = response.getText();
                                                        $this$checkTypeMismatch$iv$iv = $this$readValue$iv.readValue(content$iv, new TypeReference<PikashowSeriesResponse>() { // from class: com.cncverse.PikashowProvider$load$$inlined$readValue$1
                                                        });
                                                        if (!($this$checkTypeMismatch$iv$iv instanceof PikashowSeriesResponse)) {
                                                            StringBuilder sbAppend = new StringBuilder().append("Deserialized value did not match the specified type; specified ").append(Reflection.getOrCreateKotlinClass(PikashowSeriesResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                                                            if ($this$checkTypeMismatch$iv$iv != null) {
                                                                qualifiedName = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName();
                                                            } else {
                                                                qualifiedName = null;
                                                            }
                                                            throw new RuntimeJsonMappingException(sbAppend.append(qualifiedName).toString());
                                                        }
                                                        seriesResponse = (PikashowSeriesResponse) $this$checkTypeMismatch$iv$iv;
                                                        series = seriesResponse.getSeries();
                                                        if (series != null) {
                                                            it = series.iterator();
                                                            do {
                                                                if (it.hasNext()) {
                                                                    next = it.next();
                                                                    it2 = (PikashowSeries) next;
                                                                } else {
                                                                    next = null;
                                                                }
                                                                series2 = (PikashowSeries) next;
                                                            } while (!Intrinsics.areEqual(it2.getTitle(), identifier3));
                                                            series2 = (PikashowSeries) next;
                                                        } else {
                                                            series2 = null;
                                                        }
                                                        if (series2 != null) {
                                                            seriesData = series2;
                                                            episodes = new ArrayList();
                                                            details = seriesData.getDetails();
                                                            if (details != null) {
                                                                try {
                                                                    $this$forEach$iv = details;
                                                                    for (Object element$iv : $this$forEach$iv) {
                                                                        SeasonDetail seasonDetail = (SeasonDetail) element$iv;
                                                                        season = seasonDetail.getSeason();
                                                                        if (season != null || (intOrNull = StringsKt.toIntOrNull(season)) == null) {
                                                                            iIntValue = 1;
                                                                        } else {
                                                                            iIntValue = intOrNull.intValue();
                                                                        }
                                                                        seasonNumber = iIntValue;
                                                                        episodesCount = seasonDetail.getEpisodesCount();
                                                                        if (episodesCount != null) {
                                                                            iIntValue2 = episodesCount.intValue();
                                                                        } else {
                                                                            iIntValue2 = 1;
                                                                        }
                                                                        episodeCount = iIntValue2;
                                                                        PikashowSeriesResponse seriesResponse3 = seriesResponse;
                                                                        episodeNum = 1;
                                                                        if (1 <= episodeCount) {
                                                                            while (true) {
                                                                                series4 = series2;
                                                                                $this$forEach$iv2 = $this$forEach$iv;
                                                                                identifier5 = identifier3;
                                                                                seasonNumber2 = seasonNumber;
                                                                                url5 = url3;
                                                                                episodes.add(MainAPIKt.newEpisode(this, "pikashow_episode:" + seriesData.getTitle() + ':' + seasonNumber2 + ':' + episodeNum, new Function1() { // from class: com.cncverse.PikashowProvider$$ExternalSyntheticLambda9
                                                                                    public final Object invoke(Object obj4) {
                                                                                        return PikashowProvider.load$lambda$1$0$0(episodeNum, seasonNumber2, (Episode) obj4);
                                                                                    }
                                                                                }));
                                                                                if (episodeNum != episodeCount) {
                                                                                    episodeNum++;
                                                                                    url3 = url5;
                                                                                    seasonNumber = seasonNumber2;
                                                                                    series2 = series4;
                                                                                    $this$forEach$iv = $this$forEach$iv2;
                                                                                    identifier3 = identifier5;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            series4 = series2;
                                                                            $this$forEach$iv2 = $this$forEach$iv;
                                                                            identifier5 = identifier3;
                                                                            url5 = url3;
                                                                        }
                                                                        url3 = url5;
                                                                        seriesResponse = seriesResponse3;
                                                                        series2 = series4;
                                                                        $this$forEach$iv = $this$forEach$iv2;
                                                                        identifier3 = identifier5;
                                                                    }
                                                                    seriesResponse2 = seriesResponse;
                                                                    series3 = series2;
                                                                    identifier4 = identifier3;
                                                                    url4 = url3;
                                                                } catch (Exception e) {
                                                                    e = e;
                                                                    url2 = null;
                                                                }
                                                            } else {
                                                                seriesResponse2 = seriesResponse;
                                                                series3 = series2;
                                                                identifier4 = identifier3;
                                                                url4 = url3;
                                                            }
                                                            try {
                                                                PikashowProvider pikashowProvider = this;
                                                                title = seriesData.getTitle();
                                                                if (title == null) {
                                                                    title = "Unknown Series";
                                                                }
                                                                String str = title;
                                                                TvType tvType = TvType.TvSeries;
                                                                url2 = null;
                                                                try {
                                                                    PikashowProvider$load$2$2 pikashowProvider$load$2$2 = new PikashowProvider$load$2$2(seriesData, null);
                                                                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                                                                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(withoutUrlScheme);
                                                                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(parts2);
                                                                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(identifier4);
                                                                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(type3);
                                                                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                                                                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(identifier2);
                                                                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(params);
                                                                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(response);
                                                                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(seriesResponse2);
                                                                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(series3);
                                                                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(seriesData);
                                                                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(episodes);
                                                                    c00052.I$0 = 0;
                                                                    c00052.label = 2;
                                                                    try {
                                                                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(pikashowProvider, str, url4, tvType, episodes, pikashowProvider$load$2$2, c00052);
                                                                        if (objNewTvSeriesLoadResponse == obj2) {
                                                                            return obj2;
                                                                        }
                                                                        map3 = map2;
                                                                        withoutUrlScheme2 = withoutUrlScheme;
                                                                        seriesUrl = type3;
                                                                        type3 = seriesUrl;
                                                                        tvSeriesLoadResponse = (TvSeriesLoadResponse) objNewTvSeriesLoadResponse;
                                                                    } catch (Exception e2) {
                                                                        e = e2;
                                                                    }
                                                                } catch (Exception e3) {
                                                                    e = e3;
                                                                    System.out.println((Object) ("Error in load function: " + e.getMessage()));
                                                                    return url2;
                                                                }
                                                            } catch (Exception e4) {
                                                                e = e4;
                                                                url2 = null;
                                                            }
                                                        } else {
                                                            url2 = null;
                                                            tvSeriesLoadResponse = null;
                                                        }
                                                    } else {
                                                        url2 = null;
                                                        tvSeriesLoadResponse = null;
                                                    }
                                                    return (LoadResponse) tvSeriesLoadResponse;
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    url2 = null;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                url2 = null;
                                            }
                                            System.out.println((Object) ("Error in load function: " + e.getMessage()));
                                            return url2;
                                        case -584959943:
                                            try {
                                            } catch (Exception e7) {
                                                e = e7;
                                                url2 = null;
                                            }
                                            break;
                                        case 1455215167:
                                            try {
                                            } catch (Exception e8) {
                                                e = e8;
                                                url2 = null;
                                            }
                                            break;
                                        default:
                                            parts = parts4;
                                            identifier = identifier8;
                                            type2 = type5;
                                            map = pikashowHeaders;
                                            obj = null;
                                            return obj;
                                    }
                                }
                                return null;
                            } catch (Exception e9) {
                                e = e9;
                                url2 = null;
                            }
                            break;
                        case 1:
                            Map params3 = (Map) c00052.L$7;
                            String seriesUrl3 = (String) c00052.L$6;
                            Map<String, String> map5 = (Map) c00052.L$5;
                            String type6 = (String) c00052.L$4;
                            String identifier9 = (String) c00052.L$3;
                            parts2 = (List) c00052.L$2;
                            String withoutUrlScheme4 = (String) c00052.L$1;
                            String url6 = (String) c00052.L$0;
                            ResultKt.throwOnFailure($result);
                            params = params3;
                            map2 = map5;
                            type3 = type6;
                            withoutUrlScheme = withoutUrlScheme4;
                            identifier3 = identifier9;
                            url3 = url6;
                            identifier2 = seriesUrl3;
                            obj2 = coroutine_suspended;
                            i = 200;
                            obj3 = $result;
                            response = (NiceResponse) obj3;
                            if (response.getCode() == i) {
                                ObjectMapper $this$readValue$iv2 = this.mapper;
                                String content$iv2 = response.getText();
                                $this$checkTypeMismatch$iv$iv = $this$readValue$iv2.readValue(content$iv2, new TypeReference<PikashowSeriesResponse>() { // from class: com.cncverse.PikashowProvider$load$$inlined$readValue$1
                                });
                                if (!($this$checkTypeMismatch$iv$iv instanceof PikashowSeriesResponse)) {
                                    StringBuilder sbAppend2 = new StringBuilder().append("Deserialized value did not match the specified type; specified ").append(Reflection.getOrCreateKotlinClass(PikashowSeriesResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                                    if ($this$checkTypeMismatch$iv$iv != null) {
                                        qualifiedName = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName();
                                    } else {
                                        qualifiedName = null;
                                    }
                                    throw new RuntimeJsonMappingException(sbAppend2.append(qualifiedName).toString());
                                }
                                seriesResponse = (PikashowSeriesResponse) $this$checkTypeMismatch$iv$iv;
                                series = seriesResponse.getSeries();
                                if (series != null) {
                                    it = series.iterator();
                                    do {
                                        if (it.hasNext()) {
                                            next = it.next();
                                            it2 = (PikashowSeries) next;
                                        } else {
                                            next = null;
                                        }
                                        series2 = (PikashowSeries) next;
                                    } while (!Intrinsics.areEqual(it2.getTitle(), identifier3));
                                    series2 = (PikashowSeries) next;
                                } else {
                                    series2 = null;
                                }
                                if (series2 != null) {
                                    seriesData = series2;
                                    episodes = new ArrayList();
                                    details = seriesData.getDetails();
                                    if (details != null) {
                                        $this$forEach$iv = details;
                                        while (r11.hasNext()) {
                                            SeasonDetail seasonDetail2 = (SeasonDetail) element$iv;
                                            season = seasonDetail2.getSeason();
                                            if (season != null) {
                                                iIntValue = 1;
                                            } else {
                                                iIntValue = 1;
                                            }
                                            seasonNumber = iIntValue;
                                            episodesCount = seasonDetail2.getEpisodesCount();
                                            if (episodesCount != null) {
                                                iIntValue2 = episodesCount.intValue();
                                            } else {
                                                iIntValue2 = 1;
                                            }
                                            episodeCount = iIntValue2;
                                            PikashowSeriesResponse seriesResponse4 = seriesResponse;
                                            episodeNum = 1;
                                            if (1 <= episodeCount) {
                                                while (true) {
                                                    series4 = series2;
                                                    $this$forEach$iv2 = $this$forEach$iv;
                                                    identifier5 = identifier3;
                                                    seasonNumber2 = seasonNumber;
                                                    url5 = url3;
                                                    episodes.add(MainAPIKt.newEpisode(this, "pikashow_episode:" + seriesData.getTitle() + ':' + seasonNumber2 + ':' + episodeNum, new Function1() { // from class: com.cncverse.PikashowProvider$$ExternalSyntheticLambda9
                                                        public final Object invoke(Object obj4) {
                                                            return PikashowProvider.load$lambda$1$0$0(episodeNum, seasonNumber2, (Episode) obj4);
                                                        }
                                                    }));
                                                    if (episodeNum != episodeCount) {
                                                        episodeNum++;
                                                        url3 = url5;
                                                        seasonNumber = seasonNumber2;
                                                        series2 = series4;
                                                        $this$forEach$iv = $this$forEach$iv2;
                                                        identifier3 = identifier5;
                                                    }
                                                }
                                            } else {
                                                series4 = series2;
                                                $this$forEach$iv2 = $this$forEach$iv;
                                                identifier5 = identifier3;
                                                url5 = url3;
                                            }
                                            url3 = url5;
                                            seriesResponse = seriesResponse4;
                                            series2 = series4;
                                            $this$forEach$iv = $this$forEach$iv2;
                                            identifier3 = identifier5;
                                        }
                                        seriesResponse2 = seriesResponse;
                                        series3 = series2;
                                        identifier4 = identifier3;
                                        url4 = url3;
                                    } else {
                                        seriesResponse2 = seriesResponse;
                                        series3 = series2;
                                        identifier4 = identifier3;
                                        url4 = url3;
                                    }
                                    PikashowProvider pikashowProvider2 = this;
                                    title = seriesData.getTitle();
                                    if (title == null) {
                                        title = "Unknown Series";
                                    }
                                    String str2 = title;
                                    TvType tvType2 = TvType.TvSeries;
                                    url2 = null;
                                    PikashowProvider$load$2$2 pikashowProvider$load$2$3 = new PikashowProvider$load$2$2(seriesData, null);
                                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(withoutUrlScheme);
                                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(parts2);
                                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(identifier4);
                                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(type3);
                                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(identifier2);
                                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(params);
                                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(response);
                                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(seriesResponse2);
                                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(series3);
                                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(seriesData);
                                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(episodes);
                                    c00052.I$0 = 0;
                                    c00052.label = 2;
                                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(pikashowProvider2, str2, url4, tvType2, episodes, pikashowProvider$load$2$3, c00052);
                                    if (objNewTvSeriesLoadResponse == obj2) {
                                        return obj2;
                                    }
                                    map3 = map2;
                                    withoutUrlScheme2 = withoutUrlScheme;
                                    seriesUrl = type3;
                                    type3 = seriesUrl;
                                    tvSeriesLoadResponse = (TvSeriesLoadResponse) objNewTvSeriesLoadResponse;
                                } else {
                                    url2 = null;
                                    tvSeriesLoadResponse = null;
                                }
                            } else {
                                url2 = null;
                                tvSeriesLoadResponse = null;
                            }
                            return (LoadResponse) tvSeriesLoadResponse;
                        case 2:
                            int i2 = c00052.I$0;
                            map3 = (Map) c00052.L$5;
                            seriesUrl = (String) c00052.L$4;
                            String identifier10 = (String) c00052.L$3;
                            List parts5 = (List) c00052.L$2;
                            withoutUrlScheme2 = (String) c00052.L$1;
                            ResultKt.throwOnFailure($result);
                            objNewTvSeriesLoadResponse = $result;
                            identifier4 = identifier10;
                            parts2 = parts5;
                            url2 = null;
                            type3 = seriesUrl;
                            tvSeriesLoadResponse = (TvSeriesLoadResponse) objNewTvSeriesLoadResponse;
                            return (LoadResponse) tvSeriesLoadResponse;
                        case 3:
                            Map params4 = (Map) c00052.L$7;
                            String movieUrl = (String) c00052.L$6;
                            Map<String, String> map6 = (Map) c00052.L$5;
                            String type7 = (String) c00052.L$4;
                            String identifier11 = (String) c00052.L$3;
                            List parts6 = (List) c00052.L$2;
                            String withoutUrlScheme5 = (String) c00052.L$1;
                            String url7 = (String) c00052.L$0;
                            ResultKt.throwOnFailure($result);
                            Map params5 = params4;
                            String withoutUrlScheme6 = withoutUrlScheme5;
                            Map<String, String> map7 = map6;
                            String identifier12 = identifier11;
                            String str3 = " but was ";
                            type = type7;
                            List parts7 = parts6;
                            String url8 = url7;
                            String movieUrl2 = movieUrl;
                            Object obj4 = coroutine_suspended;
                            String identifier13 = "Deserialized value did not match the specified type; specified ";
                            int i3 = 200;
                            Object obj5 = $result;
                            NiceResponse response2 = (NiceResponse) obj5;
                            if (response2.getCode() == i3) {
                                ObjectMapper $this$readValue$iv3 = this.mapper;
                                String content$iv3 = response2.getText();
                                Object $this$checkTypeMismatch$iv$iv2 = $this$readValue$iv3.readValue(content$iv3, new TypeReference<PikashowMovieResponse>() { // from class: com.cncverse.PikashowProvider$load$$inlined$readValue$2
                                });
                                String withoutUrlScheme7 = withoutUrlScheme6;
                                if (!($this$checkTypeMismatch$iv$iv2 instanceof PikashowMovieResponse)) {
                                    throw new RuntimeJsonMappingException(identifier13 + Reflection.getOrCreateKotlinClass(PikashowMovieResponse.class).getQualifiedName() + "(non-null)" + str3 + ($this$checkTypeMismatch$iv$iv2 != null ? Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv2.getClass()).getQualifiedName() : null));
                                }
                                PikashowMovieResponse movieResponse = (PikashowMovieResponse) $this$checkTypeMismatch$iv$iv2;
                                List<PikashowMovie> records = movieResponse.getRecords();
                                if (records != null) {
                                    Iterator<T> it4 = records.iterator();
                                    do {
                                        if (it4.hasNext()) {
                                            next2 = it4.next();
                                            it3 = (PikashowMovie) next2;
                                        } else {
                                            next2 = null;
                                        }
                                        movie = (PikashowMovie) next2;
                                    } while (!Intrinsics.areEqual(String.valueOf(it3.getSortOrder()), identifier12));
                                    movie = (PikashowMovie) next2;
                                } else {
                                    movie = null;
                                }
                                if (movie != null) {
                                    PikashowMovie movieData = movie;
                                    PikashowProvider pikashowProvider3 = this;
                                    String title2 = movieData.getTitle();
                                    if (title2 == null) {
                                        title2 = "Unknown Movie";
                                    }
                                    String identifier14 = identifier12;
                                    String identifier15 = title2;
                                    TvType tvType3 = TvType.Movie;
                                    PikashowProvider$load$3$1 pikashowProvider$load$3$1 = new PikashowProvider$load$3$1(movieData, null);
                                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(url8);
                                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(withoutUrlScheme7);
                                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(parts7);
                                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(identifier14);
                                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(type);
                                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(map7);
                                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(movieUrl2);
                                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(params5);
                                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(response2);
                                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(movieResponse);
                                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(movie);
                                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(movieData);
                                    c00052.I$0 = 0;
                                    c00052.label = 4;
                                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(pikashowProvider3, identifier15, url8, tvType3, url8, pikashowProvider$load$3$1, c00052);
                                    if (objNewMovieLoadResponse == obj4) {
                                        return obj4;
                                    }
                                    withoutUrlScheme3 = withoutUrlScheme7;
                                    map4 = map7;
                                    type4 = type;
                                    parts3 = parts7;
                                    identifier6 = identifier14;
                                    identifier7 = url8;
                                    try {
                                        type = type4;
                                        movieLoadResponse = (MovieLoadResponse) objNewMovieLoadResponse;
                                    } catch (Exception e10) {
                                        e = e10;
                                        url2 = null;
                                    }
                                } else {
                                    movieLoadResponse = null;
                                }
                                break;
                            } else {
                                movieLoadResponse = null;
                            }
                            return (LoadResponse) movieLoadResponse;
                        case 4:
                            int i4 = c00052.I$0;
                            map4 = (Map) c00052.L$5;
                            type4 = (String) c00052.L$4;
                            identifier6 = (String) c00052.L$3;
                            parts3 = (List) c00052.L$2;
                            withoutUrlScheme3 = (String) c00052.L$1;
                            identifier7 = (String) c00052.L$0;
                            ResultKt.throwOnFailure($result);
                            objNewMovieLoadResponse = $result;
                            type = type4;
                            movieLoadResponse = (MovieLoadResponse) objNewMovieLoadResponse;
                            return (LoadResponse) movieLoadResponse;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Exception e11) {
                    e = e11;
                    url2 = null;
                }
            } catch (Exception e12) {
                e = e12;
                url2 = null;
            }
        } catch (Exception e13) {
            e = e13;
            url2 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$1$0$0(int $episodeNum, int $seasonNumber, Episode $this$newEpisode) {
        $this$newEpisode.setName("Episode " + $episodeNum);
        $this$newEpisode.setSeason(Integer.valueOf($seasonNumber));
        $this$newEpisode.setEpisode(Integer.valueOf($episodeNum));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.databind.RuntimeJsonMappingException */
    /* JADX WARN: Code duplicated, block: B:101:0x0595  */
    /* JADX WARN: Code duplicated, block: B:106:0x05a8  */
    /* JADX WARN: Code duplicated, block: B:133:0x0733 A[Catch: Exception -> 0x0b4e, TRY_LEAVE, TryCatch #2 {Exception -> 0x0b4e, blocks: (B:131:0x0727, B:133:0x0733, B:192:0x08e2, B:194:0x08e6, B:196:0x08ea), top: B:258:0x0727 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x0744  */
    /* JADX WARN: Code duplicated, block: B:136:0x074a A[Catch: Exception -> 0x0824, TRY_ENTER, TryCatch #18 {Exception -> 0x0824, blocks: (B:136:0x074a, B:142:0x0761, B:144:0x0780, B:146:0x07a8, B:148:0x07bb, B:149:0x07c8, B:150:0x07c9, B:152:0x07d4, B:153:0x07da, B:155:0x07e0, B:160:0x0802, B:163:0x080b, B:139:0x0753, B:167:0x0827, B:170:0x0833, B:172:0x0852, B:174:0x0878, B:176:0x0889, B:177:0x0896, B:178:0x0897, B:180:0x08a2, B:181:0x08a8, B:183:0x08ae, B:188:0x08cc, B:191:0x08d5), top: B:288:0x0741 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0752  */
    /* JADX WARN: Code duplicated, block: B:139:0x0753 A[Catch: Exception -> 0x0824, TryCatch #18 {Exception -> 0x0824, blocks: (B:136:0x074a, B:142:0x0761, B:144:0x0780, B:146:0x07a8, B:148:0x07bb, B:149:0x07c8, B:150:0x07c9, B:152:0x07d4, B:153:0x07da, B:155:0x07e0, B:160:0x0802, B:163:0x080b, B:139:0x0753, B:167:0x0827, B:170:0x0833, B:172:0x0852, B:174:0x0878, B:176:0x0889, B:177:0x0896, B:178:0x0897, B:180:0x08a2, B:181:0x08a8, B:183:0x08ae, B:188:0x08cc, B:191:0x08d5), top: B:288:0x0741 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x075b  */
    /* JADX WARN: Code duplicated, block: B:142:0x0761 A[Catch: Exception -> 0x0824, TryCatch #18 {Exception -> 0x0824, blocks: (B:136:0x074a, B:142:0x0761, B:144:0x0780, B:146:0x07a8, B:148:0x07bb, B:149:0x07c8, B:150:0x07c9, B:152:0x07d4, B:153:0x07da, B:155:0x07e0, B:160:0x0802, B:163:0x080b, B:139:0x0753, B:167:0x0827, B:170:0x0833, B:172:0x0852, B:174:0x0878, B:176:0x0889, B:177:0x0896, B:178:0x0897, B:180:0x08a2, B:181:0x08a8, B:183:0x08ae, B:188:0x08cc, B:191:0x08d5), top: B:288:0x0741 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0780 A[Catch: Exception -> 0x0824, TryCatch #18 {Exception -> 0x0824, blocks: (B:136:0x074a, B:142:0x0761, B:144:0x0780, B:146:0x07a8, B:148:0x07bb, B:149:0x07c8, B:150:0x07c9, B:152:0x07d4, B:153:0x07da, B:155:0x07e0, B:160:0x0802, B:163:0x080b, B:139:0x0753, B:167:0x0827, B:170:0x0833, B:172:0x0852, B:174:0x0878, B:176:0x0889, B:177:0x0896, B:178:0x0897, B:180:0x08a2, B:181:0x08a8, B:183:0x08ae, B:188:0x08cc, B:191:0x08d5), top: B:288:0x0741 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x07a8 A[Catch: Exception -> 0x0824, TryCatch #18 {Exception -> 0x0824, blocks: (B:136:0x074a, B:142:0x0761, B:144:0x0780, B:146:0x07a8, B:148:0x07bb, B:149:0x07c8, B:150:0x07c9, B:152:0x07d4, B:153:0x07da, B:155:0x07e0, B:160:0x0802, B:163:0x080b, B:139:0x0753, B:167:0x0827, B:170:0x0833, B:172:0x0852, B:174:0x0878, B:176:0x0889, B:177:0x0896, B:178:0x0897, B:180:0x08a2, B:181:0x08a8, B:183:0x08ae, B:188:0x08cc, B:191:0x08d5), top: B:288:0x0741 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x07b9  */
    /* JADX WARN: Code duplicated, block: B:150:0x07c9 A[Catch: Exception -> 0x0824, TryCatch #18 {Exception -> 0x0824, blocks: (B:136:0x074a, B:142:0x0761, B:144:0x0780, B:146:0x07a8, B:148:0x07bb, B:149:0x07c8, B:150:0x07c9, B:152:0x07d4, B:153:0x07da, B:155:0x07e0, B:160:0x0802, B:163:0x080b, B:139:0x0753, B:167:0x0827, B:170:0x0833, B:172:0x0852, B:174:0x0878, B:176:0x0889, B:177:0x0896, B:178:0x0897, B:180:0x08a2, B:181:0x08a8, B:183:0x08ae, B:188:0x08cc, B:191:0x08d5), top: B:288:0x0741 }] */
    /* JADX WARN: Code duplicated, block: B:152:0x07d4 A[Catch: Exception -> 0x0824, TryCatch #18 {Exception -> 0x0824, blocks: (B:136:0x074a, B:142:0x0761, B:144:0x0780, B:146:0x07a8, B:148:0x07bb, B:149:0x07c8, B:150:0x07c9, B:152:0x07d4, B:153:0x07da, B:155:0x07e0, B:160:0x0802, B:163:0x080b, B:139:0x0753, B:167:0x0827, B:170:0x0833, B:172:0x0852, B:174:0x0878, B:176:0x0889, B:177:0x0896, B:178:0x0897, B:180:0x08a2, B:181:0x08a8, B:183:0x08ae, B:188:0x08cc, B:191:0x08d5), top: B:288:0x0741 }] */
    /* JADX WARN: Code duplicated, block: B:155:0x07e0 A[Catch: Exception -> 0x0824, TryCatch #18 {Exception -> 0x0824, blocks: (B:136:0x074a, B:142:0x0761, B:144:0x0780, B:146:0x07a8, B:148:0x07bb, B:149:0x07c8, B:150:0x07c9, B:152:0x07d4, B:153:0x07da, B:155:0x07e0, B:160:0x0802, B:163:0x080b, B:139:0x0753, B:167:0x0827, B:170:0x0833, B:172:0x0852, B:174:0x0878, B:176:0x0889, B:177:0x0896, B:178:0x0897, B:180:0x08a2, B:181:0x08a8, B:183:0x08ae, B:188:0x08cc, B:191:0x08d5), top: B:288:0x0741 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x07fb A[LOOP:0: B:153:0x07da->B:158:0x07fb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:161:0x0805  */
    /* JADX WARN: Code duplicated, block: B:163:0x080b A[Catch: Exception -> 0x0824, TryCatch #18 {Exception -> 0x0824, blocks: (B:136:0x074a, B:142:0x0761, B:144:0x0780, B:146:0x07a8, B:148:0x07bb, B:149:0x07c8, B:150:0x07c9, B:152:0x07d4, B:153:0x07da, B:155:0x07e0, B:160:0x0802, B:163:0x080b, B:139:0x0753, B:167:0x0827, B:170:0x0833, B:172:0x0852, B:174:0x0878, B:176:0x0889, B:177:0x0896, B:178:0x0897, B:180:0x08a2, B:181:0x08a8, B:183:0x08ae, B:188:0x08cc, B:191:0x08d5), top: B:288:0x0741 }] */
    /* JADX WARN: Code duplicated, block: B:167:0x0827 A[Catch: Exception -> 0x0824, TryCatch #18 {Exception -> 0x0824, blocks: (B:136:0x074a, B:142:0x0761, B:144:0x0780, B:146:0x07a8, B:148:0x07bb, B:149:0x07c8, B:150:0x07c9, B:152:0x07d4, B:153:0x07da, B:155:0x07e0, B:160:0x0802, B:163:0x080b, B:139:0x0753, B:167:0x0827, B:170:0x0833, B:172:0x0852, B:174:0x0878, B:176:0x0889, B:177:0x0896, B:178:0x0897, B:180:0x08a2, B:181:0x08a8, B:183:0x08ae, B:188:0x08cc, B:191:0x08d5), top: B:288:0x0741 }] */
    /* JADX WARN: Code duplicated, block: B:169:0x0831  */
    /* JADX WARN: Code duplicated, block: B:170:0x0833 A[Catch: Exception -> 0x0824, TryCatch #18 {Exception -> 0x0824, blocks: (B:136:0x074a, B:142:0x0761, B:144:0x0780, B:146:0x07a8, B:148:0x07bb, B:149:0x07c8, B:150:0x07c9, B:152:0x07d4, B:153:0x07da, B:155:0x07e0, B:160:0x0802, B:163:0x080b, B:139:0x0753, B:167:0x0827, B:170:0x0833, B:172:0x0852, B:174:0x0878, B:176:0x0889, B:177:0x0896, B:178:0x0897, B:180:0x08a2, B:181:0x08a8, B:183:0x08ae, B:188:0x08cc, B:191:0x08d5), top: B:288:0x0741 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x0852 A[Catch: Exception -> 0x0824, TryCatch #18 {Exception -> 0x0824, blocks: (B:136:0x074a, B:142:0x0761, B:144:0x0780, B:146:0x07a8, B:148:0x07bb, B:149:0x07c8, B:150:0x07c9, B:152:0x07d4, B:153:0x07da, B:155:0x07e0, B:160:0x0802, B:163:0x080b, B:139:0x0753, B:167:0x0827, B:170:0x0833, B:172:0x0852, B:174:0x0878, B:176:0x0889, B:177:0x0896, B:178:0x0897, B:180:0x08a2, B:181:0x08a8, B:183:0x08ae, B:188:0x08cc, B:191:0x08d5), top: B:288:0x0741 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x0878 A[Catch: Exception -> 0x0824, TryCatch #18 {Exception -> 0x0824, blocks: (B:136:0x074a, B:142:0x0761, B:144:0x0780, B:146:0x07a8, B:148:0x07bb, B:149:0x07c8, B:150:0x07c9, B:152:0x07d4, B:153:0x07da, B:155:0x07e0, B:160:0x0802, B:163:0x080b, B:139:0x0753, B:167:0x0827, B:170:0x0833, B:172:0x0852, B:174:0x0878, B:176:0x0889, B:177:0x0896, B:178:0x0897, B:180:0x08a2, B:181:0x08a8, B:183:0x08ae, B:188:0x08cc, B:191:0x08d5), top: B:288:0x0741 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x0887  */
    /* JADX WARN: Code duplicated, block: B:178:0x0897 A[Catch: Exception -> 0x0824, TryCatch #18 {Exception -> 0x0824, blocks: (B:136:0x074a, B:142:0x0761, B:144:0x0780, B:146:0x07a8, B:148:0x07bb, B:149:0x07c8, B:150:0x07c9, B:152:0x07d4, B:153:0x07da, B:155:0x07e0, B:160:0x0802, B:163:0x080b, B:139:0x0753, B:167:0x0827, B:170:0x0833, B:172:0x0852, B:174:0x0878, B:176:0x0889, B:177:0x0896, B:178:0x0897, B:180:0x08a2, B:181:0x08a8, B:183:0x08ae, B:188:0x08cc, B:191:0x08d5), top: B:288:0x0741 }] */
    /* JADX WARN: Code duplicated, block: B:180:0x08a2 A[Catch: Exception -> 0x0824, TryCatch #18 {Exception -> 0x0824, blocks: (B:136:0x074a, B:142:0x0761, B:144:0x0780, B:146:0x07a8, B:148:0x07bb, B:149:0x07c8, B:150:0x07c9, B:152:0x07d4, B:153:0x07da, B:155:0x07e0, B:160:0x0802, B:163:0x080b, B:139:0x0753, B:167:0x0827, B:170:0x0833, B:172:0x0852, B:174:0x0878, B:176:0x0889, B:177:0x0896, B:178:0x0897, B:180:0x08a2, B:181:0x08a8, B:183:0x08ae, B:188:0x08cc, B:191:0x08d5), top: B:288:0x0741 }] */
    /* JADX WARN: Code duplicated, block: B:183:0x08ae A[Catch: Exception -> 0x0824, TryCatch #18 {Exception -> 0x0824, blocks: (B:136:0x074a, B:142:0x0761, B:144:0x0780, B:146:0x07a8, B:148:0x07bb, B:149:0x07c8, B:150:0x07c9, B:152:0x07d4, B:153:0x07da, B:155:0x07e0, B:160:0x0802, B:163:0x080b, B:139:0x0753, B:167:0x0827, B:170:0x0833, B:172:0x0852, B:174:0x0878, B:176:0x0889, B:177:0x0896, B:178:0x0897, B:180:0x08a2, B:181:0x08a8, B:183:0x08ae, B:188:0x08cc, B:191:0x08d5), top: B:288:0x0741 }] */
    /* JADX WARN: Code duplicated, block: B:186:0x08c5 A[LOOP:1: B:181:0x08a8->B:186:0x08c5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:189:0x08cf  */
    /* JADX WARN: Code duplicated, block: B:191:0x08d5 A[Catch: Exception -> 0x0824, TRY_LEAVE, TryCatch #18 {Exception -> 0x0824, blocks: (B:136:0x074a, B:142:0x0761, B:144:0x0780, B:146:0x07a8, B:148:0x07bb, B:149:0x07c8, B:150:0x07c9, B:152:0x07d4, B:153:0x07da, B:155:0x07e0, B:160:0x0802, B:163:0x080b, B:139:0x0753, B:167:0x0827, B:170:0x0833, B:172:0x0852, B:174:0x0878, B:176:0x0889, B:177:0x0896, B:178:0x0897, B:180:0x08a2, B:181:0x08a8, B:183:0x08ae, B:188:0x08cc, B:191:0x08d5), top: B:288:0x0741 }] */
    /* JADX WARN: Code duplicated, block: B:194:0x08e6 A[Catch: Exception -> 0x0b4e, TryCatch #2 {Exception -> 0x0b4e, blocks: (B:131:0x0727, B:133:0x0733, B:192:0x08e2, B:194:0x08e6, B:196:0x08ea), top: B:258:0x0727 }] */
    /* JADX WARN: Code duplicated, block: B:205:0x0a08 A[Catch: Exception -> 0x0b29, TryCatch #5 {Exception -> 0x0b29, blocks: (B:203:0x09fa, B:205:0x0a08, B:207:0x0a2a, B:209:0x0a50, B:211:0x0a63, B:212:0x0a70, B:213:0x0a71, B:215:0x0a7f), top: B:264:0x09fa }] */
    /* JADX WARN: Code duplicated, block: B:207:0x0a2a A[Catch: Exception -> 0x0b29, TryCatch #5 {Exception -> 0x0b29, blocks: (B:203:0x09fa, B:205:0x0a08, B:207:0x0a2a, B:209:0x0a50, B:211:0x0a63, B:212:0x0a70, B:213:0x0a71, B:215:0x0a7f), top: B:264:0x09fa }] */
    /* JADX WARN: Code duplicated, block: B:209:0x0a50 A[Catch: Exception -> 0x0b29, TryCatch #5 {Exception -> 0x0b29, blocks: (B:203:0x09fa, B:205:0x0a08, B:207:0x0a2a, B:209:0x0a50, B:211:0x0a63, B:212:0x0a70, B:213:0x0a71, B:215:0x0a7f), top: B:264:0x09fa }] */
    /* JADX WARN: Code duplicated, block: B:210:0x0a61  */
    /* JADX WARN: Code duplicated, block: B:213:0x0a71 A[Catch: Exception -> 0x0b29, TryCatch #5 {Exception -> 0x0b29, blocks: (B:203:0x09fa, B:205:0x0a08, B:207:0x0a2a, B:209:0x0a50, B:211:0x0a63, B:212:0x0a70, B:213:0x0a71, B:215:0x0a7f), top: B:264:0x09fa }] */
    /* JADX WARN: Code duplicated, block: B:215:0x0a7f A[Catch: Exception -> 0x0b29, TRY_LEAVE, TryCatch #5 {Exception -> 0x0b29, blocks: (B:203:0x09fa, B:205:0x0a08, B:207:0x0a2a, B:209:0x0a50, B:211:0x0a63, B:212:0x0a70, B:213:0x0a71, B:215:0x0a7f), top: B:264:0x09fa }] */
    /* JADX WARN: Code duplicated, block: B:217:0x0b06 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:218:0x0b07  */
    /* JADX WARN: Code duplicated, block: B:224:0x0b1f  */
    /* JADX WARN: Code duplicated, block: B:231:0x0b45  */
    /* JADX WARN: Code duplicated, block: B:295:0x07fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:296:0x07f9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:297:0x08c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:298:0x08c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x0481  */
    /* JADX WARN: Code duplicated, block: B:85:0x04a5 A[Catch: Exception -> 0x059a, TryCatch #13 {Exception -> 0x059a, blocks: (B:83:0x0494, B:85:0x04a5, B:87:0x04d1, B:89:0x04e4, B:90:0x04f1, B:91:0x04f2, B:93:0x04fe), top: B:279:0x0494 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x04d1 A[Catch: Exception -> 0x059a, TryCatch #13 {Exception -> 0x059a, blocks: (B:83:0x0494, B:85:0x04a5, B:87:0x04d1, B:89:0x04e4, B:90:0x04f1, B:91:0x04f2, B:93:0x04fe), top: B:279:0x0494 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:91:0x04f2 A[Catch: Exception -> 0x059a, TryCatch #13 {Exception -> 0x059a, blocks: (B:83:0x0494, B:85:0x04a5, B:87:0x04d1, B:89:0x04e4, B:90:0x04f1, B:91:0x04f2, B:93:0x04fe), top: B:279:0x0494 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x04fe A[Catch: Exception -> 0x059a, TRY_LEAVE, TryCatch #13 {Exception -> 0x059a, blocks: (B:83:0x0494, B:85:0x04a5, B:87:0x04d1, B:89:0x04e4, B:90:0x04f1, B:91:0x04f2, B:93:0x04fe), top: B:279:0x0494 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0577 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:96:0x0578  */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public Object loadLinks(@NotNull String str, boolean z, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) throws RuntimeJsonMappingException {
        C00061 c00061;
        boolean z2;
        List list;
        boolean z3;
        String str2;
        String str3;
        int i;
        Object obj;
        C00061 c00062;
        Function1<? super SubtitleFile, Unit> function3;
        String str4;
        String str5;
        Map<String, String> map;
        Map map2;
        String str6;
        boolean z4;
        String str7;
        Function1<? super ExtractorLink, Unit> function4;
        String str8;
        boolean z5;
        Function1<? super ExtractorLink, Unit> function5;
        boolean z6;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        char c;
        PikashowSeries pikashowSeries;
        String str9;
        Object obj6;
        String str10;
        C00061 c00063;
        Object obj7;
        Map<String, String> map3;
        Map map4;
        String str11;
        String str12;
        String str13;
        String str14;
        boolean z7;
        Function1<? super SubtitleFile, Unit> function6;
        List list2;
        String str15;
        Function1<? super ExtractorLink, Unit> function7;
        PikashowProvider pikashowProvider;
        NiceResponse niceResponse;
        String str16;
        Object value;
        VideoApiResponse videoApiResponse;
        VideoData data;
        String str17;
        String str18;
        boolean z8;
        Function1<? super ExtractorLink, Unit> function8;
        String qualifiedName;
        NiceResponse niceResponse2;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Map<String, String> map5;
        String str19;
        Object value2;
        PikashowSeriesResponse pikashowSeriesResponse;
        List<PikashowSeries> series;
        PikashowSeries pikashowSeries2;
        Iterator<T> it;
        Object obj8;
        Object next;
        PikashowSeriesResponse pikashowSeriesResponse2;
        String qualifiedName2;
        Object value3;
        String str20;
        List<PikashowMovie> records;
        String str21;
        Object obj9;
        Iterator<T> it2;
        Object obj10;
        Object next2;
        String qualifiedName3;
        String str22;
        Ref.ObjectRef objectRef3;
        String str23;
        C00061 c00064;
        Map<String, String> map6;
        Map map7;
        String str24;
        Ref.ObjectRef objectRef4;
        Map map8;
        String str25;
        NiceResponse niceResponse3;
        String str26;
        String str27;
        Object obj11;
        boolean z9;
        Function1<? super ExtractorLink, Unit> function9;
        NiceResponse niceResponse4;
        String str28;
        String str29;
        Object value4;
        VideoApiResponse videoApiResponse2;
        VideoData data2;
        boolean z10;
        Function1<? super ExtractorLink, Unit> function10;
        String qualifiedName4;
        PikashowProvider pikashowProvider2 = this;
        if (continuation instanceof C00061) {
            c00061 = (C00061) continuation;
            if ((c00061.label & Integer.MIN_VALUE) != 0) {
                c00061.label -= Integer.MIN_VALUE;
            } else {
                c00061 = pikashowProvider2.new C00061(continuation);
            }
        } else {
            c00061 = pikashowProvider2.new C00061(continuation);
        }
        C00061 c00065 = c00061;
        Object obj12 = c00065.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00065.label) {
            case 0:
                ResultKt.throwOnFailure(obj12);
                PikashowProvider pikashowProvider3 = pikashowProvider2;
                final Context context2 = context;
                SharedPreferences sharedPreferences = context2 != null ? context2.getSharedPreferences("CNCVerseSubscription", 0) : null;
                String string = sharedPreferences != null ? sharedPreferences.getString("mode", "ads") : null;
                long j = sharedPreferences != null ? sharedPreferences.getLong("expires_at", 0L) : 0L;
                long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                if (!(Intrinsics.areEqual(string, "subscription") && (j == 0 || j > jCurrentTimeMillis))) {
                    if (Intrinsics.areEqual(string, "subscription") && j > 0 && j <= jCurrentTimeMillis) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.PikashowProvider$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                PikashowProvider.loadLinks$lambda$0$0(context2);
                            }
                        });
                    }
                    pikashowProvider3.openInExternalBrowser(new String(Base64.decode(OMG10, 0), Charsets.UTF_8));
                }
                try {
                    String strRemovePrefix = StringsKt.removePrefix(str, getMainUrl() + '/');
                    Map<String, String> pikashowHeaders = getPikashowHeaders();
                    if (StringsKt.startsWith$default(strRemovePrefix, "pikashow_episode:", false, 2, (Object) null)) {
                        try {
                            List listSplit$default = StringsKt.split$default(strRemovePrefix, new String[]{":"}, false, 0, 6, (Object) null);
                            if (listSplit$default.size() >= 4) {
                                String str30 = (String) listSplit$default.get(1);
                                String str31 = (String) listSplit$default.get(2);
                                String str32 = (String) listSplit$default.get(3);
                                list = listSplit$default;
                                String str33 = getMainUrl() + "/v1/api/video";
                                Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "series"), TuplesKt.to("videoId", "0"), TuplesKt.to("title", str30), TuplesKt.to("noseasons", str31), TuplesKt.to("noepisodes", str32)});
                                Requests app = MainActivityKt.getApp();
                                c00065.L$0 = SpillingKt.nullOutSpilledVariable(str);
                                c00065.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                                c00065.L$2 = function2;
                                c00065.L$3 = SpillingKt.nullOutSpilledVariable(strRemovePrefix);
                                c00065.L$4 = SpillingKt.nullOutSpilledVariable(pikashowHeaders);
                                c00065.L$5 = SpillingKt.nullOutSpilledVariable(list);
                                c00065.L$6 = SpillingKt.nullOutSpilledVariable(str30);
                                c00065.L$7 = SpillingKt.nullOutSpilledVariable(str31);
                                c00065.L$8 = str32;
                                c00065.L$9 = SpillingKt.nullOutSpilledVariable(str33);
                                c00065.L$10 = SpillingKt.nullOutSpilledVariable(mapMapOf);
                                c00065.Z$0 = z;
                                c00065.label = 1;
                                z3 = true;
                                str2 = str31;
                                str3 = "Deserialized value did not match the specified type; specified ";
                                i = 200;
                                try {
                                    obj = Requests.get$default(app, str33, pikashowHeaders, (String) null, mapMapOf, (Map) null, false, 0, (TimeUnit) null, 30L, (Interceptor) null, false, (ResponseParser) null, c00065, 3828, (Object) null);
                                    c00062 = c00065;
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    function3 = function1;
                                    str4 = strRemovePrefix;
                                    str5 = str32;
                                    map = pikashowHeaders;
                                    map2 = mapMapOf;
                                    str6 = str;
                                    z4 = z;
                                    str7 = str30;
                                    function4 = function2;
                                    str8 = str33;
                                    try {
                                        niceResponse = (NiceResponse) obj;
                                        if (niceResponse.getCode() == i) {
                                            pikashowProvider = this;
                                            try {
                                                str16 = str6;
                                                try {
                                                    value = pikashowProvider.mapper.readValue(niceResponse.getText(), new TypeReference<VideoApiResponse>() { // from class: com.cncverse.PikashowProvider$loadLinks$$inlined$readValue$1
                                                    });
                                                    if (!(value instanceof VideoApiResponse)) {
                                                        StringBuilder sbAppend = new StringBuilder().append(str3).append(Reflection.getOrCreateKotlinClass(VideoApiResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                                                        if (value != null) {
                                                            qualifiedName = Reflection.getOrCreateKotlinClass(value.getClass()).getQualifiedName();
                                                        } else {
                                                            qualifiedName = null;
                                                        }
                                                        throw new RuntimeJsonMappingException(sbAppend.append(qualifiedName).toString());
                                                    }
                                                    videoApiResponse = (VideoApiResponse) value;
                                                    data = videoApiResponse.getData();
                                                    if (data != null) {
                                                        String str34 = str7;
                                                        str17 = "Episode " + str5;
                                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                                                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                                                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(str4);
                                                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(map);
                                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(list);
                                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(str34);
                                                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(str2);
                                                        c00062.L$8 = SpillingKt.nullOutSpilledVariable(str5);
                                                        c00062.L$9 = SpillingKt.nullOutSpilledVariable(str8);
                                                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(map2);
                                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(videoApiResponse);
                                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(data);
                                                        c00062.Z$0 = z4;
                                                        c00062.I$0 = 0;
                                                        c00062.label = 2;
                                                        if (pikashowProvider.addVideoLinksToCallback(data, function4, str17, c00062) == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        str18 = str16;
                                                        z8 = z4;
                                                        function8 = function4;
                                                        try {
                                                            return Boxing.boxBoolean(z3);
                                                        } catch (Exception e) {
                                                            e = e;
                                                            z2 = false;
                                                        }
                                                    }
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    z2 = false;
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                z2 = false;
                                            }
                                        } else {
                                            pikashowProvider = this;
                                            str16 = str6;
                                        }
                                        z5 = z4;
                                        function5 = function4;
                                        z2 = false;
                                    } catch (Exception e4) {
                                        e = e4;
                                        pikashowProvider = this;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    z2 = false;
                                }
                            } else {
                                z2 = false;
                                z5 = z;
                                function5 = function2;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            z2 = false;
                        }
                        System.out.println((Object) ("Error in loadLinks: " + e.getMessage()));
                        return Boxing.boxBoolean(z2);
                    }
                    try {
                        if (StringsKt.startsWith$default(strRemovePrefix, "pikashow:", false, 2, (Object) null)) {
                            List listSplit$default2 = StringsKt.split$default(strRemovePrefix, new String[]{":"}, false, 0, 6, (Object) null);
                            z2 = false;
                            z2 = false;
                            z2 = false;
                            z2 = false;
                            z2 = false;
                            if (listSplit$default2.size() >= 3) {
                                try {
                                    String str35 = (String) listSplit$default2.get(1);
                                    z6 = true;
                                    String str36 = (String) listSplit$default2.get(2);
                                    String str37 = getMainUrl() + "/v1/api/videos";
                                    Map mapMapOf2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("type", str36), TuplesKt.to("channel", "pikashow")});
                                    try {
                                        Requests app2 = MainActivityKt.getApp();
                                        c00065.L$0 = SpillingKt.nullOutSpilledVariable(str);
                                        c00065.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                                        c00065.L$2 = function2;
                                        c00065.L$3 = SpillingKt.nullOutSpilledVariable(strRemovePrefix);
                                        c00065.L$4 = pikashowHeaders;
                                        c00065.L$5 = SpillingKt.nullOutSpilledVariable(listSplit$default2);
                                        c00065.L$6 = str35;
                                        c00065.L$7 = str36;
                                        c00065.L$8 = SpillingKt.nullOutSpilledVariable(str37);
                                        c00065.L$9 = SpillingKt.nullOutSpilledVariable(mapMapOf2);
                                        c00065.Z$0 = z;
                                        c00065.label = 3;
                                        obj2 = "noseasons";
                                        obj3 = "series";
                                        obj4 = "0";
                                        obj5 = "type";
                                        c = 3;
                                        pikashowSeries = null;
                                        str9 = "/v1/api/video";
                                        pikashowProvider2 = this;
                                        obj6 = "videoId";
                                        str10 = "Deserialized value did not match the specified type; specified ";
                                        try {
                                            Object obj13 = Requests.get$default(app2, str37, pikashowHeaders, (String) null, mapMapOf2, (Map) null, false, 0, (TimeUnit) null, 30L, (Interceptor) null, false, (ResponseParser) null, c00065, 3828, (Object) null);
                                            c00063 = c00065;
                                            if (obj13 == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            obj7 = obj13;
                                            map3 = pikashowHeaders;
                                            map4 = mapMapOf2;
                                            str11 = str37;
                                            str12 = str36;
                                            str13 = strRemovePrefix;
                                            str14 = str35;
                                            z7 = z;
                                            function6 = function1;
                                            list2 = listSplit$default2;
                                            str15 = str;
                                            function7 = function2;
                                            try {
                                                niceResponse2 = (NiceResponse) obj7;
                                                if (niceResponse2.getCode() == 200) {
                                                    objectRef = new Ref.ObjectRef();
                                                    objectRef2 = new Ref.ObjectRef();
                                                    try {
                                                        switch (str12.hashCode()) {
                                                            case -905838985:
                                                                map5 = map3;
                                                                str19 = r19;
                                                                if (!str12.equals(obj3)) {
                                                                    value2 = pikashowProvider2.mapper.readValue(niceResponse2.getText(), new TypeReference<PikashowSeriesResponse>() { // from class: com.cncverse.PikashowProvider$loadLinks$$inlined$readValue$2
                                                                    });
                                                                    if (!(value2 instanceof PikashowSeriesResponse)) {
                                                                        StringBuilder sbAppend2 = new StringBuilder().append(str10).append(Reflection.getOrCreateKotlinClass(PikashowSeriesResponse.class).getQualifiedName()).append("(non-null)").append(str19);
                                                                        if (value2 != null) {
                                                                            qualifiedName2 = Reflection.getOrCreateKotlinClass(value2.getClass()).getQualifiedName();
                                                                        } else {
                                                                            qualifiedName2 = pikashowSeries;
                                                                        }
                                                                        throw new RuntimeJsonMappingException(sbAppend2.append(qualifiedName2).toString());
                                                                    }
                                                                    pikashowSeriesResponse = (PikashowSeriesResponse) value2;
                                                                    series = pikashowSeriesResponse.getSeries();
                                                                    if (series != null) {
                                                                        it = series.iterator();
                                                                        while (true) {
                                                                            if (it.hasNext()) {
                                                                                next = it.next();
                                                                                pikashowSeriesResponse2 = pikashowSeriesResponse;
                                                                                if (Intrinsics.areEqual(((PikashowSeries) next).getTitle(), str14)) {
                                                                                    obj8 = next;
                                                                                } else {
                                                                                    pikashowSeriesResponse = pikashowSeriesResponse2;
                                                                                }
                                                                            } else {
                                                                                obj8 = pikashowSeries;
                                                                            }
                                                                        }
                                                                        pikashowSeries2 = (PikashowSeries) obj8;
                                                                    } else {
                                                                        pikashowSeries2 = pikashowSeries;
                                                                    }
                                                                    if (pikashowSeries2 != null) {
                                                                        objectRef.element = obj4;
                                                                        objectRef2.element = pikashowSeries2.getTitle();
                                                                        Unit unit = Unit.INSTANCE;
                                                                    }
                                                                }
                                                                if (objectRef.element == null && objectRef2.element != null) {
                                                                    String str38 = (String) objectRef2.element;
                                                                    String str39 = pikashowProvider2.getMainUrl() + str9;
                                                                    Pair[] pairArr = new Pair[5];
                                                                    pairArr[z2 ? 1 : 0] = TuplesKt.to(obj5, str12);
                                                                    String str40 = str14;
                                                                    pairArr[z6 ? 1 : 0] = TuplesKt.to(obj6, objectRef.element);
                                                                    pairArr[2] = TuplesKt.to("title", str38);
                                                                    pairArr[c] = TuplesKt.to(obj2, "1");
                                                                    pairArr[4] = TuplesKt.to("noepisodes", obj4);
                                                                    Map mapMapOf3 = MapsKt.mapOf(pairArr);
                                                                    Requests app3 = MainActivityKt.getApp();
                                                                    c00063.L$0 = SpillingKt.nullOutSpilledVariable(str15);
                                                                    c00063.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                                                                    c00063.L$2 = function7;
                                                                    c00063.L$3 = SpillingKt.nullOutSpilledVariable(str13);
                                                                    c00063.L$4 = SpillingKt.nullOutSpilledVariable(map5);
                                                                    c00063.L$5 = SpillingKt.nullOutSpilledVariable(list2);
                                                                    c00063.L$6 = SpillingKt.nullOutSpilledVariable(str40);
                                                                    c00063.L$7 = SpillingKt.nullOutSpilledVariable(str12);
                                                                    c00063.L$8 = SpillingKt.nullOutSpilledVariable(str11);
                                                                    c00063.L$9 = SpillingKt.nullOutSpilledVariable(map4);
                                                                    c00063.L$10 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                                                                    c00063.L$11 = SpillingKt.nullOutSpilledVariable(objectRef);
                                                                    c00063.L$12 = SpillingKt.nullOutSpilledVariable(objectRef2);
                                                                    c00063.L$13 = str38;
                                                                    c00063.L$14 = SpillingKt.nullOutSpilledVariable(str39);
                                                                    c00063.L$15 = SpillingKt.nullOutSpilledVariable(mapMapOf3);
                                                                    c00063.Z$0 = z7;
                                                                    c00063.label = 4;
                                                                    C00061 c00066 = c00063;
                                                                    boolean z11 = z7;
                                                                    str22 = str40;
                                                                    objectRef3 = objectRef;
                                                                    String str41 = str12;
                                                                    Function1<? super ExtractorLink, Unit> function11 = function7;
                                                                    Map<String, String> map9 = map5;
                                                                    str23 = str19;
                                                                    try {
                                                                        Object obj14 = Requests.get$default(app3, str39, map9, (String) null, mapMapOf3, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00066, 4084, (Object) null);
                                                                        c00064 = c00066;
                                                                        if (obj14 == coroutine_suspended) {
                                                                            return coroutine_suspended;
                                                                        }
                                                                        map6 = map9;
                                                                        map7 = mapMapOf3;
                                                                        str24 = str39;
                                                                        objectRef4 = objectRef2;
                                                                        map8 = map4;
                                                                        str25 = str11;
                                                                        niceResponse3 = niceResponse2;
                                                                        str26 = str38;
                                                                        str27 = str41;
                                                                        obj11 = obj14;
                                                                        z9 = z11;
                                                                        function9 = function11;
                                                                        try {
                                                                            niceResponse4 = (NiceResponse) obj11;
                                                                            str28 = str24;
                                                                            if (niceResponse4.getCode() != 404) {
                                                                                str29 = str26;
                                                                                value4 = pikashowProvider2.mapper.readValue(niceResponse4.getText(), new TypeReference<VideoApiResponse>() { // from class: com.cncverse.PikashowProvider$loadLinks$$inlined$readValue$4
                                                                                });
                                                                                if (!(value4 instanceof VideoApiResponse)) {
                                                                                    StringBuilder sbAppend3 = new StringBuilder().append(str10).append(Reflection.getOrCreateKotlinClass(VideoApiResponse.class).getQualifiedName()).append("(non-null)").append(str23);
                                                                                    if (value4 != null) {
                                                                                        qualifiedName4 = Reflection.getOrCreateKotlinClass(value4.getClass()).getQualifiedName();
                                                                                    } else {
                                                                                        qualifiedName4 = pikashowSeries;
                                                                                    }
                                                                                    throw new RuntimeJsonMappingException(sbAppend3.append(qualifiedName4).toString());
                                                                                }
                                                                                videoApiResponse2 = (VideoApiResponse) value4;
                                                                                data2 = videoApiResponse2.getData();
                                                                                if (data2 != null) {
                                                                                    c00064.L$0 = SpillingKt.nullOutSpilledVariable(str15);
                                                                                    c00064.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                                                                                    c00064.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                                                                                    c00064.L$3 = SpillingKt.nullOutSpilledVariable(str13);
                                                                                    c00064.L$4 = SpillingKt.nullOutSpilledVariable(map6);
                                                                                    c00064.L$5 = SpillingKt.nullOutSpilledVariable(list2);
                                                                                    c00064.L$6 = SpillingKt.nullOutSpilledVariable(str22);
                                                                                    c00064.L$7 = SpillingKt.nullOutSpilledVariable(str27);
                                                                                    c00064.L$8 = SpillingKt.nullOutSpilledVariable(str25);
                                                                                    c00064.L$9 = SpillingKt.nullOutSpilledVariable(map8);
                                                                                    c00064.L$10 = SpillingKt.nullOutSpilledVariable(niceResponse3);
                                                                                    c00064.L$11 = SpillingKt.nullOutSpilledVariable(objectRef3);
                                                                                    c00064.L$12 = SpillingKt.nullOutSpilledVariable(objectRef4);
                                                                                    c00064.L$13 = SpillingKt.nullOutSpilledVariable(str29);
                                                                                    c00064.L$14 = SpillingKt.nullOutSpilledVariable(str28);
                                                                                    c00064.L$15 = SpillingKt.nullOutSpilledVariable(map7);
                                                                                    c00064.L$16 = SpillingKt.nullOutSpilledVariable(niceResponse4);
                                                                                    c00064.L$17 = SpillingKt.nullOutSpilledVariable(videoApiResponse2);
                                                                                    c00064.L$18 = SpillingKt.nullOutSpilledVariable(str29);
                                                                                    c00064.L$19 = SpillingKt.nullOutSpilledVariable(data2);
                                                                                    c00064.Z$0 = z9;
                                                                                    c00064.I$0 = 0;
                                                                                    c00064.label = 5;
                                                                                    if (pikashowProvider2.addVideoLinksToCallback(data2, function9, str29, c00064) == coroutine_suspended) {
                                                                                        return coroutine_suspended;
                                                                                    }
                                                                                    z10 = z9;
                                                                                    function10 = function9;
                                                                                    try {
                                                                                        return Boxing.boxBoolean(z6);
                                                                                    } catch (Exception e7) {
                                                                                        e = e7;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            }
                                                                            z5 = z9;
                                                                            function5 = function9;
                                                                        } catch (Exception e8) {
                                                                            e = e8;
                                                                        }
                                                                    } catch (Exception e9) {
                                                                        e = e9;
                                                                    }
                                                                } else {
                                                                    z5 = z7;
                                                                    function5 = function7;
                                                                }
                                                                break;
                                                            case -584959943:
                                                                if (str12.equals("bollywood")) {
                                                                    map5 = map3;
                                                                    value3 = pikashowProvider2.mapper.readValue(niceResponse2.getText(), new TypeReference<PikashowMovieResponse>() { // from class: com.cncverse.PikashowProvider$loadLinks$$inlined$readValue$3
                                                                    });
                                                                    if (!(value3 instanceof PikashowMovieResponse)) {
                                                                        StringBuilder sbAppend4 = new StringBuilder().append(str10).append(Reflection.getOrCreateKotlinClass(PikashowMovieResponse.class).getQualifiedName()).append("(non-null)").append(r19);
                                                                        if (value3 != null) {
                                                                            qualifiedName3 = Reflection.getOrCreateKotlinClass(value3.getClass()).getQualifiedName();
                                                                        } else {
                                                                            qualifiedName3 = pikashowSeries;
                                                                        }
                                                                        throw new RuntimeJsonMappingException(sbAppend4.append(qualifiedName3).toString());
                                                                    }
                                                                    str20 = r19;
                                                                    records = ((PikashowMovieResponse) value3).getRecords();
                                                                    if (records != null) {
                                                                        it2 = records.iterator();
                                                                        while (true) {
                                                                            if (it2.hasNext()) {
                                                                                next2 = it2.next();
                                                                                str21 = str20;
                                                                                if (Intrinsics.areEqual(String.valueOf(((PikashowMovie) next2).getSortOrder()), str14)) {
                                                                                    obj10 = next2;
                                                                                } else {
                                                                                    str20 = str21;
                                                                                }
                                                                            } else {
                                                                                str21 = str20;
                                                                                obj10 = pikashowSeries;
                                                                            }
                                                                        }
                                                                        obj9 = (PikashowMovie) obj10;
                                                                    } else {
                                                                        str21 = str20;
                                                                        obj9 = pikashowSeries;
                                                                    }
                                                                    if (obj9 != null) {
                                                                        PikashowMovie pikashowMovie = obj9;
                                                                        objectRef.element = String.valueOf(pikashowMovie.getSortOrder());
                                                                        objectRef2.element = pikashowMovie.getTitle();
                                                                        Unit unit2 = Unit.INSTANCE;
                                                                    }
                                                                    str19 = str21;
                                                                } else {
                                                                    map5 = map3;
                                                                    str19 = r19;
                                                                }
                                                                if (objectRef.element == null) {
                                                                }
                                                                z5 = z7;
                                                                function5 = function7;
                                                                break;
                                                            case 1455215167:
                                                                if (str12.equals("hollywood")) {
                                                                    map5 = map3;
                                                                    value3 = pikashowProvider2.mapper.readValue(niceResponse2.getText(), new TypeReference<PikashowMovieResponse>() { // from class: com.cncverse.PikashowProvider$loadLinks$$inlined$readValue$3
                                                                    });
                                                                    if (!(value3 instanceof PikashowMovieResponse)) {
                                                                        StringBuilder sbAppend5 = new StringBuilder().append(str10).append(Reflection.getOrCreateKotlinClass(PikashowMovieResponse.class).getQualifiedName()).append("(non-null)").append(r19);
                                                                        if (value3 != null) {
                                                                            qualifiedName3 = Reflection.getOrCreateKotlinClass(value3.getClass()).getQualifiedName();
                                                                        } else {
                                                                            qualifiedName3 = pikashowSeries;
                                                                        }
                                                                        throw new RuntimeJsonMappingException(sbAppend5.append(qualifiedName3).toString());
                                                                    }
                                                                    str20 = r19;
                                                                    records = ((PikashowMovieResponse) value3).getRecords();
                                                                    if (records != null) {
                                                                        it2 = records.iterator();
                                                                        while (true) {
                                                                            if (it2.hasNext()) {
                                                                                next2 = it2.next();
                                                                                str21 = str20;
                                                                                if (Intrinsics.areEqual(String.valueOf(((PikashowMovie) next2).getSortOrder()), str14)) {
                                                                                    obj10 = next2;
                                                                                } else {
                                                                                    str20 = str21;
                                                                                }
                                                                            } else {
                                                                                str21 = str20;
                                                                                obj10 = pikashowSeries;
                                                                            }
                                                                        }
                                                                        obj9 = (PikashowMovie) obj10;
                                                                    } else {
                                                                        str21 = str20;
                                                                        obj9 = pikashowSeries;
                                                                    }
                                                                    if (obj9 != null) {
                                                                        PikashowMovie pikashowMovie2 = obj9;
                                                                        objectRef.element = String.valueOf(pikashowMovie2.getSortOrder());
                                                                        objectRef2.element = pikashowMovie2.getTitle();
                                                                        Unit unit3 = Unit.INSTANCE;
                                                                    }
                                                                    str19 = str21;
                                                                } else {
                                                                    map5 = map3;
                                                                    str19 = r19;
                                                                }
                                                                if (objectRef.element == null) {
                                                                }
                                                                z5 = z7;
                                                                function5 = function7;
                                                                break;
                                                            default:
                                                                map5 = map3;
                                                                str19 = " but was ";
                                                                if (objectRef.element == null) {
                                                                }
                                                                z5 = z7;
                                                                function5 = function7;
                                                                break;
                                                        }
                                                    } catch (Exception e10) {
                                                        e = e10;
                                                    }
                                                } else {
                                                    z5 = z7;
                                                    function5 = function7;
                                                }
                                            } catch (Exception e11) {
                                                e = e11;
                                            }
                                        } catch (Exception e12) {
                                            e = e12;
                                        }
                                    } catch (Exception e13) {
                                        e = e13;
                                    }
                                } catch (Exception e14) {
                                    e = e14;
                                }
                            }
                            System.out.println((Object) ("Error in loadLinks: " + e.getMessage()));
                            return Boxing.boxBoolean(z2);
                        }
                        z2 = false;
                        z5 = z;
                        function5 = function2;
                    } catch (Exception e15) {
                        e = e15;
                        z2 = false;
                    }
                    try {
                        return Boxing.boxBoolean(z2);
                    } catch (Exception e16) {
                        e = e16;
                    }
                } catch (Exception e17) {
                    e = e17;
                    z2 = false;
                }
                break;
            case 1:
                boolean z12 = c00065.Z$0;
                Map map10 = (Map) c00065.L$10;
                String str42 = (String) c00065.L$9;
                String str43 = (String) c00065.L$8;
                String str44 = (String) c00065.L$7;
                String str45 = (String) c00065.L$6;
                List list3 = (List) c00065.L$5;
                map = (Map) c00065.L$4;
                str4 = (String) c00065.L$3;
                Function1<? super ExtractorLink, Unit> function12 = (Function1) c00065.L$2;
                function3 = (Function1) c00065.L$1;
                String str46 = (String) c00065.L$0;
                try {
                    ResultKt.throwOnFailure(obj12);
                    str6 = str46;
                    function4 = function12;
                    str2 = str44;
                    list = list3;
                    z4 = z12;
                    str3 = "Deserialized value did not match the specified type; specified ";
                    i = 200;
                    z3 = true;
                    c00062 = c00065;
                    obj = obj12;
                    map2 = map10;
                    str5 = str43;
                    str7 = str45;
                    str8 = str42;
                    niceResponse = (NiceResponse) obj;
                    if (niceResponse.getCode() == i) {
                        pikashowProvider = this;
                        str16 = str6;
                        value = pikashowProvider.mapper.readValue(niceResponse.getText(), new TypeReference<VideoApiResponse>() { // from class: com.cncverse.PikashowProvider$loadLinks$$inlined$readValue$1
                        });
                        if (!(value instanceof VideoApiResponse)) {
                            StringBuilder sbAppend6 = new StringBuilder().append(str3).append(Reflection.getOrCreateKotlinClass(VideoApiResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                            if (value != null) {
                                qualifiedName = Reflection.getOrCreateKotlinClass(value.getClass()).getQualifiedName();
                            } else {
                                qualifiedName = null;
                            }
                            throw new RuntimeJsonMappingException(sbAppend6.append(qualifiedName).toString());
                        }
                        videoApiResponse = (VideoApiResponse) value;
                        data = videoApiResponse.getData();
                        if (data != null) {
                            String str310 = str7;
                            str17 = "Episode " + str5;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(str4);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(map);
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(list);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(str310);
                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(str2);
                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(str5);
                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(str8);
                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(map2);
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(niceResponse);
                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(videoApiResponse);
                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(data);
                            c00062.Z$0 = z4;
                            c00062.I$0 = 0;
                            c00062.label = 2;
                            if (pikashowProvider.addVideoLinksToCallback(data, function4, str17, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str18 = str16;
                            z8 = z4;
                            function8 = function4;
                            return Boxing.boxBoolean(z3);
                        }
                    } else {
                        pikashowProvider = this;
                        str16 = str6;
                    }
                    z5 = z4;
                    function5 = function4;
                    z2 = false;
                    return Boxing.boxBoolean(z2);
                } catch (Exception e18) {
                    e = e18;
                    z2 = false;
                }
                break;
            case 2:
                int i2 = c00065.I$0;
                z8 = c00065.Z$0;
                function8 = (Function1) c00065.L$2;
                Function1<? super SubtitleFile, Unit> function13 = (Function1) c00065.L$1;
                str18 = (String) c00065.L$0;
                try {
                    ResultKt.throwOnFailure(obj12);
                    function3 = function13;
                    z3 = true;
                    pikashowProvider = pikashowProvider2;
                    return Boxing.boxBoolean(z3);
                } catch (Exception e19) {
                    e = e19;
                    z2 = false;
                }
                break;
            case 3:
                boolean z13 = c00065.Z$0;
                Map map11 = (Map) c00065.L$9;
                String str47 = (String) c00065.L$8;
                String str48 = (String) c00065.L$7;
                String str49 = (String) c00065.L$6;
                List list4 = (List) c00065.L$5;
                Map<String, String> map12 = (Map) c00065.L$4;
                String str50 = (String) c00065.L$3;
                Function1<? super ExtractorLink, Unit> function14 = (Function1) c00065.L$2;
                Function1<? super SubtitleFile, Unit> function15 = (Function1) c00065.L$1;
                String str51 = (String) c00065.L$0;
                try {
                    ResultKt.throwOnFailure(obj12);
                    str15 = str51;
                    function6 = function15;
                    map4 = map11;
                    obj2 = "noseasons";
                    str9 = "/v1/api/video";
                    obj3 = "series";
                    str11 = str47;
                    obj4 = "0";
                    obj5 = "type";
                    str10 = "Deserialized value did not match the specified type; specified ";
                    str14 = str49;
                    list2 = list4;
                    str13 = str50;
                    z6 = true;
                    c = 3;
                    pikashowSeries = null;
                    z2 = false;
                    obj7 = obj12;
                    obj6 = "videoId";
                    map3 = map12;
                    c00063 = c00065;
                    z7 = z13;
                    str12 = str48;
                    function7 = function14;
                    niceResponse2 = (NiceResponse) obj7;
                    if (niceResponse2.getCode() == 200) {
                        objectRef = new Ref.ObjectRef();
                        objectRef2 = new Ref.ObjectRef();
                        switch (str12.hashCode()) {
                            case -905838985:
                                map5 = map3;
                                str19 = r19;
                                if (!str12.equals(obj3)) {
                                    value2 = pikashowProvider2.mapper.readValue(niceResponse2.getText(), new TypeReference<PikashowSeriesResponse>() { // from class: com.cncverse.PikashowProvider$loadLinks$$inlined$readValue$2
                                    });
                                    if (!(value2 instanceof PikashowSeriesResponse)) {
                                        StringBuilder sbAppend7 = new StringBuilder().append(str10).append(Reflection.getOrCreateKotlinClass(PikashowSeriesResponse.class).getQualifiedName()).append("(non-null)").append(str19);
                                        if (value2 != null) {
                                            qualifiedName2 = Reflection.getOrCreateKotlinClass(value2.getClass()).getQualifiedName();
                                        } else {
                                            qualifiedName2 = pikashowSeries;
                                        }
                                        throw new RuntimeJsonMappingException(sbAppend7.append(qualifiedName2).toString());
                                    }
                                    pikashowSeriesResponse = (PikashowSeriesResponse) value2;
                                    series = pikashowSeriesResponse.getSeries();
                                    if (series != null) {
                                        it = series.iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                next = it.next();
                                                pikashowSeriesResponse2 = pikashowSeriesResponse;
                                                if (Intrinsics.areEqual(((PikashowSeries) next).getTitle(), str14)) {
                                                    obj8 = next;
                                                } else {
                                                    pikashowSeriesResponse = pikashowSeriesResponse2;
                                                }
                                            } else {
                                                obj8 = pikashowSeries;
                                            }
                                        }
                                        pikashowSeries2 = (PikashowSeries) obj8;
                                    } else {
                                        pikashowSeries2 = pikashowSeries;
                                    }
                                    if (pikashowSeries2 != null) {
                                        objectRef.element = obj4;
                                        objectRef2.element = pikashowSeries2.getTitle();
                                        Unit unit4 = Unit.INSTANCE;
                                    }
                                }
                                if (objectRef.element == null) {
                                }
                                z5 = z7;
                                function5 = function7;
                                break;
                            case -584959943:
                                if (str12.equals("bollywood")) {
                                    map5 = map3;
                                    str19 = r19;
                                } else {
                                    map5 = map3;
                                    value3 = pikashowProvider2.mapper.readValue(niceResponse2.getText(), new TypeReference<PikashowMovieResponse>() { // from class: com.cncverse.PikashowProvider$loadLinks$$inlined$readValue$3
                                    });
                                    if (!(value3 instanceof PikashowMovieResponse)) {
                                        StringBuilder sbAppend8 = new StringBuilder().append(str10).append(Reflection.getOrCreateKotlinClass(PikashowMovieResponse.class).getQualifiedName()).append("(non-null)").append(r19);
                                        if (value3 != null) {
                                            qualifiedName3 = Reflection.getOrCreateKotlinClass(value3.getClass()).getQualifiedName();
                                        } else {
                                            qualifiedName3 = pikashowSeries;
                                        }
                                        throw new RuntimeJsonMappingException(sbAppend8.append(qualifiedName3).toString());
                                    }
                                    str20 = r19;
                                    records = ((PikashowMovieResponse) value3).getRecords();
                                    if (records != null) {
                                        it2 = records.iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                next2 = it2.next();
                                                str21 = str20;
                                                if (Intrinsics.areEqual(String.valueOf(((PikashowMovie) next2).getSortOrder()), str14)) {
                                                    obj10 = next2;
                                                } else {
                                                    str20 = str21;
                                                }
                                            } else {
                                                str21 = str20;
                                                obj10 = pikashowSeries;
                                            }
                                        }
                                        obj9 = (PikashowMovie) obj10;
                                    } else {
                                        str21 = str20;
                                        obj9 = pikashowSeries;
                                    }
                                    if (obj9 != null) {
                                        PikashowMovie pikashowMovie3 = obj9;
                                        objectRef.element = String.valueOf(pikashowMovie3.getSortOrder());
                                        objectRef2.element = pikashowMovie3.getTitle();
                                        Unit unit5 = Unit.INSTANCE;
                                    }
                                    str19 = str21;
                                }
                                if (objectRef.element == null) {
                                }
                                z5 = z7;
                                function5 = function7;
                                break;
                            case 1455215167:
                                if (str12.equals("hollywood")) {
                                    map5 = map3;
                                    str19 = r19;
                                } else {
                                    map5 = map3;
                                    value3 = pikashowProvider2.mapper.readValue(niceResponse2.getText(), new TypeReference<PikashowMovieResponse>() { // from class: com.cncverse.PikashowProvider$loadLinks$$inlined$readValue$3
                                    });
                                    if (!(value3 instanceof PikashowMovieResponse)) {
                                        StringBuilder sbAppend9 = new StringBuilder().append(str10).append(Reflection.getOrCreateKotlinClass(PikashowMovieResponse.class).getQualifiedName()).append("(non-null)").append(r19);
                                        if (value3 != null) {
                                            qualifiedName3 = Reflection.getOrCreateKotlinClass(value3.getClass()).getQualifiedName();
                                        } else {
                                            qualifiedName3 = pikashowSeries;
                                        }
                                        throw new RuntimeJsonMappingException(sbAppend9.append(qualifiedName3).toString());
                                    }
                                    str20 = r19;
                                    records = ((PikashowMovieResponse) value3).getRecords();
                                    if (records != null) {
                                        it2 = records.iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                next2 = it2.next();
                                                str21 = str20;
                                                if (Intrinsics.areEqual(String.valueOf(((PikashowMovie) next2).getSortOrder()), str14)) {
                                                    obj10 = next2;
                                                } else {
                                                    str20 = str21;
                                                }
                                            } else {
                                                str21 = str20;
                                                obj10 = pikashowSeries;
                                            }
                                        }
                                        obj9 = (PikashowMovie) obj10;
                                    } else {
                                        str21 = str20;
                                        obj9 = pikashowSeries;
                                    }
                                    if (obj9 != null) {
                                        PikashowMovie pikashowMovie4 = obj9;
                                        objectRef.element = String.valueOf(pikashowMovie4.getSortOrder());
                                        objectRef2.element = pikashowMovie4.getTitle();
                                        Unit unit6 = Unit.INSTANCE;
                                    }
                                    str19 = str21;
                                }
                                if (objectRef.element == null) {
                                }
                                z5 = z7;
                                function5 = function7;
                                break;
                            default:
                                map5 = map3;
                                str19 = " but was ";
                                if (objectRef.element == null) {
                                }
                                z5 = z7;
                                function5 = function7;
                                break;
                        }
                    } else {
                        z5 = z7;
                        function5 = function7;
                    }
                    return Boxing.boxBoolean(z2);
                } catch (Exception e20) {
                    e = e20;
                    z2 = false;
                }
                break;
            case 4:
                boolean z14 = c00065.Z$0;
                Map map13 = (Map) c00065.L$15;
                str24 = (String) c00065.L$14;
                str26 = (String) c00065.L$13;
                objectRef4 = (Ref.ObjectRef) c00065.L$12;
                Ref.ObjectRef objectRef5 = (Ref.ObjectRef) c00065.L$11;
                niceResponse3 = (NiceResponse) c00065.L$10;
                map8 = (Map) c00065.L$9;
                str25 = (String) c00065.L$8;
                str27 = (String) c00065.L$7;
                String str52 = (String) c00065.L$6;
                List list5 = (List) c00065.L$5;
                map6 = (Map) c00065.L$4;
                String str53 = (String) c00065.L$3;
                Function1<? super ExtractorLink, Unit> function16 = (Function1) c00065.L$2;
                Function1<? super SubtitleFile, Unit> function17 = (Function1) c00065.L$1;
                String str54 = (String) c00065.L$0;
                try {
                    ResultKt.throwOnFailure(obj12);
                    str15 = str54;
                    function6 = function17;
                    objectRef3 = objectRef5;
                    z9 = z14;
                    list2 = list5;
                    str23 = " but was ";
                    str10 = "Deserialized value did not match the specified type; specified ";
                    str13 = str53;
                    z6 = true;
                    pikashowSeries = null;
                    z2 = false;
                    str22 = str52;
                    c00064 = c00065;
                    map7 = map13;
                    function9 = function16;
                    obj11 = obj12;
                    niceResponse4 = (NiceResponse) obj11;
                    str28 = str24;
                    if (niceResponse4.getCode() != 404) {
                        str29 = str26;
                        value4 = pikashowProvider2.mapper.readValue(niceResponse4.getText(), new TypeReference<VideoApiResponse>() { // from class: com.cncverse.PikashowProvider$loadLinks$$inlined$readValue$4
                        });
                        if (!(value4 instanceof VideoApiResponse)) {
                            StringBuilder sbAppend10 = new StringBuilder().append(str10).append(Reflection.getOrCreateKotlinClass(VideoApiResponse.class).getQualifiedName()).append("(non-null)").append(str23);
                            if (value4 != null) {
                                qualifiedName4 = Reflection.getOrCreateKotlinClass(value4.getClass()).getQualifiedName();
                            } else {
                                qualifiedName4 = pikashowSeries;
                            }
                            throw new RuntimeJsonMappingException(sbAppend10.append(qualifiedName4).toString());
                        }
                        videoApiResponse2 = (VideoApiResponse) value4;
                        data2 = videoApiResponse2.getData();
                        if (data2 != null) {
                            c00064.L$0 = SpillingKt.nullOutSpilledVariable(str15);
                            c00064.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                            c00064.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                            c00064.L$3 = SpillingKt.nullOutSpilledVariable(str13);
                            c00064.L$4 = SpillingKt.nullOutSpilledVariable(map6);
                            c00064.L$5 = SpillingKt.nullOutSpilledVariable(list2);
                            c00064.L$6 = SpillingKt.nullOutSpilledVariable(str22);
                            c00064.L$7 = SpillingKt.nullOutSpilledVariable(str27);
                            c00064.L$8 = SpillingKt.nullOutSpilledVariable(str25);
                            c00064.L$9 = SpillingKt.nullOutSpilledVariable(map8);
                            c00064.L$10 = SpillingKt.nullOutSpilledVariable(niceResponse3);
                            c00064.L$11 = SpillingKt.nullOutSpilledVariable(objectRef3);
                            c00064.L$12 = SpillingKt.nullOutSpilledVariable(objectRef4);
                            c00064.L$13 = SpillingKt.nullOutSpilledVariable(str29);
                            c00064.L$14 = SpillingKt.nullOutSpilledVariable(str28);
                            c00064.L$15 = SpillingKt.nullOutSpilledVariable(map7);
                            c00064.L$16 = SpillingKt.nullOutSpilledVariable(niceResponse4);
                            c00064.L$17 = SpillingKt.nullOutSpilledVariable(videoApiResponse2);
                            c00064.L$18 = SpillingKt.nullOutSpilledVariable(str29);
                            c00064.L$19 = SpillingKt.nullOutSpilledVariable(data2);
                            c00064.Z$0 = z9;
                            c00064.I$0 = 0;
                            c00064.label = 5;
                            if (pikashowProvider2.addVideoLinksToCallback(data2, function9, str29, c00064) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z10 = z9;
                            function10 = function9;
                            return Boxing.boxBoolean(z6);
                        }
                    }
                    z5 = z9;
                    function5 = function9;
                    return Boxing.boxBoolean(z2);
                } catch (Exception e21) {
                    e = e21;
                    z2 = false;
                }
                break;
            case 5:
                int i3 = c00065.I$0;
                z10 = c00065.Z$0;
                function10 = (Function1) c00065.L$2;
                try {
                    ResultKt.throwOnFailure(obj12);
                    z6 = true;
                    z2 = false;
                    return Boxing.boxBoolean(z6);
                } catch (Exception e22) {
                    e = e22;
                    z2 = false;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:105:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:130:0x0437  */
    /* JADX WARN: Code duplicated, block: B:134:0x043d  */
    /* JADX WARN: Code duplicated, block: B:225:0x06ca  */
    /* JADX WARN: Code duplicated, block: B:227:0x06db  */
    /* JADX WARN: Code duplicated, block: B:229:0x06fa  */
    /* JADX WARN: Code duplicated, block: B:236:0x0719  */
    /* JADX WARN: Code duplicated, block: B:239:0x072e  */
    /* JADX WARN: Code duplicated, block: B:242:0x079d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:243:0x079e  */
    /* JADX WARN: Code duplicated, block: B:245:0x07ca  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:243:0x079e -> B:244:0x07b2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:245:0x07ca -> B:246:0x07e0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:258:0x084c -> B:259:0x086e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:289:0x0995 -> B:290:0x09b7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:291:0x09cf -> B:292:0x09ed). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object addVideoLinksToCallback(com.cncverse.PikashowProvider.VideoData r40, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r41, java.lang.String r42, kotlin.coroutines.Continuation<? super kotlin.Unit> r43) {
        /*
            Method dump skipped, instruction units count: 2658
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.PikashowProvider.addVideoLinksToCallback(com.cncverse.PikashowProvider$VideoData, kotlin.jvm.functions.Function1, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.cncverse.PikashowProvider$addVideoLinksToCallback$8 */
    /* JADX INFO: compiled from: PikashowProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PikashowProvider$addVideoLinksToCallback$8", f = "PikashowProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00018 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $finalHeaders;
        final /* synthetic */ String $urlOrigin;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00018(String str, Map<String, String> map, Continuation<? super C00018> continuation) {
            super(2, continuation);
            this.$urlOrigin = str;
            this.$finalHeaders = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00018 = new C00018(this.$urlOrigin, this.$finalHeaders, continuation);
            c00018.L$0 = obj;
            return c00018;
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
                    $this$newExtractorLink.setReferer(this.$urlOrigin);
                    $this$newExtractorLink.setQuality(Qualities.P720.getValue());
                    $this$newExtractorLink.setHeaders(this.$finalHeaders);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.databind.RuntimeJsonMappingException */
    /* JADX WARN: Code duplicated, block: B:107:0x068a A[Catch: Exception -> 0x069b, TRY_LEAVE, TryCatch #4 {Exception -> 0x069b, blocks: (B:105:0x0680, B:107:0x068a, B:101:0x065f, B:59:0x0479), top: B:137:0x0479 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x069d A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:115:0x06a7  */
    /* JADX WARN: Code duplicated, block: B:120:0x06b8  */
    /* JADX WARN: Code duplicated, block: B:139:0x04a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:152:0x04f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0292 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x0293 A[Catch: Exception -> 0x06c3, TryCatch #9 {Exception -> 0x06c3, blocks: (B:35:0x0288, B:38:0x0293, B:41:0x02aa, B:43:0x02cd, B:55:0x0345), top: B:147:0x0288 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x02a9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x02aa A[Catch: Exception -> 0x06c3, TryCatch #9 {Exception -> 0x06c3, blocks: (B:35:0x0288, B:38:0x0293, B:41:0x02aa, B:43:0x02cd, B:55:0x0345), top: B:147:0x0288 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x02cd A[Catch: Exception -> 0x06c3, TRY_LEAVE, TryCatch #9 {Exception -> 0x06c3, blocks: (B:35:0x0288, B:38:0x0293, B:41:0x02aa, B:43:0x02cd, B:55:0x0345), top: B:147:0x0288 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:48:0x031e A[Catch: Exception -> 0x033c, TryCatch #3 {Exception -> 0x033c, blocks: (B:46:0x02fa, B:48:0x031e, B:50:0x032e, B:51:0x033b), top: B:135:0x02fa }] */
    /* JADX WARN: Code duplicated, block: B:49:0x032d  */
    /* JADX WARN: Code duplicated, block: B:55:0x0345 A[Catch: Exception -> 0x06c3, TRY_ENTER, TRY_LEAVE, TryCatch #9 {Exception -> 0x06c3, blocks: (B:35:0x0288, B:38:0x0293, B:41:0x02aa, B:43:0x02cd, B:55:0x0345), top: B:147:0x0288 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0482 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:63:0x0483  */
    /* JADX WARN: Code duplicated, block: B:66:0x0493 A[Catch: Exception -> 0x06ae, TRY_LEAVE, TryCatch #1 {Exception -> 0x06ae, blocks: (B:64:0x0489, B:66:0x0493, B:73:0x04b3, B:85:0x0550, B:88:0x0559, B:90:0x0565, B:92:0x056b, B:94:0x0573, B:96:0x0579, B:99:0x0592, B:72:0x04af), top: B:131:0x0489 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x04af A[Catch: Exception -> 0x06ae, TRY_ENTER, TryCatch #1 {Exception -> 0x06ae, blocks: (B:64:0x0489, B:66:0x0493, B:73:0x04b3, B:85:0x0550, B:88:0x0559, B:90:0x0565, B:92:0x056b, B:94:0x0573, B:96:0x0579, B:99:0x0592, B:72:0x04af), top: B:131:0x0489 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x04c7 A[Catch: Exception -> 0x04aa, TRY_ENTER, TryCatch #5 {Exception -> 0x04aa, blocks: (B:68:0x04a5, B:75:0x04c7, B:77:0x04f8, B:79:0x051f, B:81:0x0532, B:82:0x053f, B:83:0x0540), top: B:139:0x04a5 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x051f A[Catch: Exception -> 0x04aa, TryCatch #5 {Exception -> 0x04aa, blocks: (B:68:0x04a5, B:75:0x04c7, B:77:0x04f8, B:79:0x051f, B:81:0x0532, B:82:0x053f, B:83:0x0540), top: B:139:0x04a5 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:80:0x0530  */
    /* JADX WARN: Code duplicated, block: B:83:0x0540 A[Catch: Exception -> 0x04aa, TRY_LEAVE, TryCatch #5 {Exception -> 0x04aa, blocks: (B:68:0x04a5, B:75:0x04c7, B:77:0x04f8, B:79:0x051f, B:81:0x0532, B:82:0x053f, B:83:0x0540), top: B:139:0x04a5 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0558 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:88:0x0559 A[Catch: Exception -> 0x06ae, TryCatch #1 {Exception -> 0x06ae, blocks: (B:64:0x0489, B:66:0x0493, B:73:0x04b3, B:85:0x0550, B:88:0x0559, B:90:0x0565, B:92:0x056b, B:94:0x0573, B:96:0x0579, B:99:0x0592, B:72:0x04af), top: B:131:0x0489 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0565 A[Catch: Exception -> 0x06ae, TryCatch #1 {Exception -> 0x06ae, blocks: (B:64:0x0489, B:66:0x0493, B:73:0x04b3, B:85:0x0550, B:88:0x0559, B:90:0x0565, B:92:0x056b, B:94:0x0573, B:96:0x0579, B:99:0x0592, B:72:0x04af), top: B:131:0x0489 }] */
    public final Object parseHDBVPlayerUrl(String playerUrl, Continuation<? super String> continuation) throws RuntimeJsonMappingException {
        C00071 c00071;
        String playerUrl2;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        String str;
        int i;
        C00071 c00072;
        Object obj8;
        String playerUrl3;
        NiceResponse response;
        Document doc;
        Elements scripts;
        String script;
        Regex regex;
        MatchResult matchResult;
        String jsonInsideHDVBPlayer;
        Object $this$checkTypeMismatch$iv$iv;
        Keys fileKeys;
        String origin;
        String absoluteUrl;
        String absoluteUrl2;
        String playerUrl4;
        Map headers;
        Elements scripts2;
        Regex regex2;
        Document doc2;
        String str2;
        C00071 c00073;
        String origin2;
        String origin3;
        String jsonInsideHDVBPlayer2;
        String qualifiedName;
        NiceResponse postResponse;
        String responseText;
        JSONArray jsonArray;
        List seasons;
        int i2;
        int length;
        Season episodeDetails;
        HDBVEpisode hDBVEpisode;
        List<FileData> folder;
        FileData fileData;
        String file;
        String episode;
        Object $this$checkTypeMismatch$iv$iv2;
        String qualifiedName2;
        NiceResponse playlistResponse;
        PikashowProvider pikashowProvider = this;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
            } else {
                c00071 = pikashowProvider.new C00071(continuation);
            }
        } else {
            c00071 = pikashowProvider.new C00071(continuation);
        }
        Object $result = c00071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00071.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    Requests app = MainActivityKt.getApp();
                    Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "*/*"), TuplesKt.to("Accept-Encoding", "gzip, deflate, br"), TuplesKt.to("Accept-Language", "en-CA,en;q=0.9;q=0.8;q=0.7,en-US;q=0.6"), TuplesKt.to("Connection", "keep-alive"), TuplesKt.to("Host", "samui390dod.com"), TuplesKt.to("Icy-MetaData", "1"), TuplesKt.to("Origin", "https://samui390dod.com"), TuplesKt.to("Referer", "https://samui390dod.com/"), TuplesKt.to("sec-ch-ua", "\"Chromium\";v=\"136\", \"Android WebView\";v=\"136\", \"Not.A/Brand\";v=\"99\""), TuplesKt.to("sec-ch-ua-mobile", "?1"), TuplesKt.to("sec-ch-ua-platform", "\"Android\""), TuplesKt.to("Sec-Fetch-Dest", "video"), TuplesKt.to("sec-fetch-mode", "cors"), TuplesKt.to("Sec-Fetch-Site", "cross-site"), TuplesKt.to("sec-fetch-user", "?1"), TuplesKt.to("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 13_5_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.1.1 Mobile/15E148 Safari/604.1"), TuplesKt.to("X-Requested-With", "com.offshore.pikachu")});
                    c00071.L$0 = playerUrl;
                    c00071.label = 1;
                    C00071 c00074 = c00071;
                    obj = coroutine_suspended;
                    obj2 = "Origin";
                    obj3 = "Accept-Language";
                    obj4 = "gzip, deflate, br";
                    obj5 = "Accept-Encoding";
                    obj6 = "*/*";
                    obj7 = "Accept";
                    str = "Deserialized value did not match the specified type; specified ";
                    i = 200;
                    try {
                        Object obj9 = Requests.get$default(app, playerUrl, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00074, 4092, (Object) null);
                        c00072 = c00074;
                        if (obj9 == obj) {
                            return obj;
                        }
                        obj8 = obj9;
                        playerUrl3 = playerUrl;
                        try {
                            response = (NiceResponse) obj8;
                            if (response.getCode() != i) {
                                return "";
                            }
                            doc = Jsoup.parse(response.getText());
                            scripts = doc.getElementsByTag("script");
                            if (scripts.size() < 8) {
                                return "";
                            }
                            script = ((Element) scripts.get(7)).toString();
                            regex = new Regex("HDVBPlayer\\((.*?)\\);");
                            matchResult = Regex.find$default(regex, script, 0, 2, (Object) null);
                            if (matchResult != null) {
                                jsonInsideHDVBPlayer = (String) matchResult.getGroupValues().get(1);
                                ObjectMapper $this$readValue$iv = pikashowProvider.mapper;
                                $this$checkTypeMismatch$iv$iv = $this$readValue$iv.readValue(jsonInsideHDVBPlayer, new TypeReference<Keys>() { // from class: com.cncverse.PikashowProvider$parseHDBVPlayerUrl$$inlined$readValue$1
                                });
                                if ($this$checkTypeMismatch$iv$iv instanceof Keys) {
                                    fileKeys = (Keys) $this$checkTypeMismatch$iv$iv;
                                    origin = StringsKt.substringBefore(playerUrl3, "/", "https://") + "://" + StringsKt.substringBefore$default(StringsKt.substringAfter$default(playerUrl3, "://", (String) null, 2, (Object) null), "/", (String) null, 2, (Object) null) + '/';
                                    absoluteUrl = origin + fileKeys.getFile();
                                    Map headers2 = MapsKt.mapOf(new Pair[]{TuplesKt.to(obj7, obj6), TuplesKt.to(obj5, obj4), TuplesKt.to(obj3, "en-US,en;q=0.9"), TuplesKt.to("Content-Length", "0"), TuplesKt.to("Content-Type", "application/x-www-form-urlencoded"), TuplesKt.to(obj2, origin), TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36"), TuplesKt.to("X-Csrf-Token", fileKeys.getKey())});
                                    absoluteUrl2 = playerUrl3;
                                    playerUrl4 = playerUrl3;
                                    try {
                                        Requests app2 = MainActivityKt.getApp();
                                        c00072.L$0 = SpillingKt.nullOutSpilledVariable(playerUrl4);
                                        c00072.L$1 = SpillingKt.nullOutSpilledVariable(response);
                                        c00072.L$2 = SpillingKt.nullOutSpilledVariable(doc);
                                        c00072.L$3 = SpillingKt.nullOutSpilledVariable(scripts);
                                        c00072.L$4 = SpillingKt.nullOutSpilledVariable(script);
                                        c00072.L$5 = SpillingKt.nullOutSpilledVariable(regex);
                                        c00072.L$6 = SpillingKt.nullOutSpilledVariable(matchResult);
                                        c00072.L$7 = SpillingKt.nullOutSpilledVariable(jsonInsideHDVBPlayer);
                                        c00072.L$8 = SpillingKt.nullOutSpilledVariable(fileKeys);
                                        c00072.L$9 = origin;
                                        c00072.L$10 = SpillingKt.nullOutSpilledVariable(absoluteUrl);
                                        c00072.L$11 = headers2;
                                        c00072.L$12 = absoluteUrl2;
                                        c00072.label = 2;
                                        C00071 c00075 = c00072;
                                        headers = headers2;
                                        scripts2 = scripts;
                                        playerUrl2 = playerUrl4;
                                        regex2 = regex;
                                        doc2 = doc;
                                        str2 = null;
                                        try {
                                            $result = Requests.post$default(app2, absoluteUrl, headers, absoluteUrl2, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00075, 65528, (Object) null);
                                            c00073 = c00075;
                                            if ($result == obj) {
                                                return obj;
                                            }
                                            origin2 = origin;
                                            origin3 = jsonInsideHDVBPlayer;
                                            jsonInsideHDVBPlayer2 = absoluteUrl;
                                            try {
                                                postResponse = (NiceResponse) $result;
                                                if (postResponse.getCode() != i) {
                                                    if (Intrinsics.areEqual(postResponse.getHeaders().get("Content-Encoding"), "gzip")) {
                                                        try {
                                                            responseText = postResponse.getText();
                                                        } catch (Exception e) {
                                                            e = e;
                                                        }
                                                    } else {
                                                        responseText = postResponse.getText();
                                                    }
                                                    jsonArray = new JSONArray(responseText);
                                                    seasons = new ArrayList();
                                                    i2 = 0;
                                                    length = jsonArray.length();
                                                    while (i2 < length) {
                                                        String jsonObject = jsonArray.getJSONObject(i2).toString();
                                                        ObjectMapper $this$readValue$iv2 = pikashowProvider.mapper;
                                                        String content$iv = StringsKt.replace$default(jsonObject, "[]", "", false, 4, (Object) null);
                                                        $this$checkTypeMismatch$iv$iv2 = $this$readValue$iv2.readValue(content$iv, new TypeReference<Season>() { // from class: com.cncverse.PikashowProvider$parseHDBVPlayerUrl$$inlined$readValue$2
                                                        });
                                                        if (!($this$checkTypeMismatch$iv$iv2 instanceof Season)) {
                                                            StringBuilder sbAppend = new StringBuilder().append(str).append(Reflection.getOrCreateKotlinClass(Season.class).getQualifiedName()).append("(non-null)").append(" but was ");
                                                            if ($this$checkTypeMismatch$iv$iv2 != null) {
                                                                qualifiedName2 = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv2.getClass()).getQualifiedName();
                                                            } else {
                                                                qualifiedName2 = str2;
                                                            }
                                                            throw new RuntimeJsonMappingException(sbAppend.append(qualifiedName2).toString());
                                                        }
                                                        Season seasonData = (Season) $this$checkTypeMismatch$iv$iv2;
                                                        seasons.add(seasonData);
                                                        i2++;
                                                        pikashowProvider = this;
                                                    }
                                                    episodeDetails = (Season) CollectionsKt.firstOrNull(seasons);
                                                    if (episodeDetails == null) {
                                                        return "";
                                                    }
                                                    hDBVEpisode = (HDBVEpisode) CollectionsKt.firstOrNull(episodeDetails.getFolder());
                                                    if (hDBVEpisode != null || (folder = hDBVEpisode.getFolder()) == null || (fileData = (FileData) CollectionsKt.firstOrNull(folder)) == null || (file = fileData.getFile()) == null || (episode = StringsKt.replace$default(file, "~", "", false, 4, (Object) null)) == null) {
                                                        return "";
                                                    }
                                                    String responseText2 = responseText;
                                                    Requests app3 = MainActivityKt.getApp();
                                                    String str3 = origin2 + "playlist/" + episode + ".txt";
                                                    c00073.L$0 = SpillingKt.nullOutSpilledVariable(playerUrl2);
                                                    c00073.L$1 = SpillingKt.nullOutSpilledVariable(response);
                                                    c00073.L$2 = SpillingKt.nullOutSpilledVariable(doc2);
                                                    c00073.L$3 = SpillingKt.nullOutSpilledVariable(scripts2);
                                                    c00073.L$4 = SpillingKt.nullOutSpilledVariable(script);
                                                    c00073.L$5 = SpillingKt.nullOutSpilledVariable(regex2);
                                                    c00073.L$6 = SpillingKt.nullOutSpilledVariable(matchResult);
                                                    c00073.L$7 = SpillingKt.nullOutSpilledVariable(origin3);
                                                    c00073.L$8 = SpillingKt.nullOutSpilledVariable(fileKeys);
                                                    c00073.L$9 = SpillingKt.nullOutSpilledVariable(origin2);
                                                    c00073.L$10 = SpillingKt.nullOutSpilledVariable(jsonInsideHDVBPlayer2);
                                                    c00073.L$11 = SpillingKt.nullOutSpilledVariable(headers);
                                                    c00073.L$12 = SpillingKt.nullOutSpilledVariable(absoluteUrl2);
                                                    c00073.L$13 = SpillingKt.nullOutSpilledVariable(postResponse);
                                                    c00073.L$14 = SpillingKt.nullOutSpilledVariable(responseText2);
                                                    c00073.L$15 = SpillingKt.nullOutSpilledVariable(jsonArray);
                                                    c00073.L$16 = SpillingKt.nullOutSpilledVariable(seasons);
                                                    c00073.L$17 = SpillingKt.nullOutSpilledVariable(episodeDetails);
                                                    c00073.L$18 = SpillingKt.nullOutSpilledVariable(episode);
                                                    c00073.label = 3;
                                                    $result = Requests.post$default(app3, str3, headers, absoluteUrl2, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00073, 65528, (Object) null);
                                                    if ($result == obj) {
                                                        return obj;
                                                    }
                                                    playlistResponse = (NiceResponse) $result;
                                                    if (playlistResponse.getCode() == 200) {
                                                        return StringsKt.trim(playlistResponse.getText()).toString();
                                                    }
                                                    return "";
                                                }
                                            } catch (Exception e2) {
                                                e = e2;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        playerUrl2 = playerUrl4;
                                    }
                                } else {
                                    try {
                                        StringBuilder sbAppend2 = new StringBuilder().append(str).append(Reflection.getOrCreateKotlinClass(Keys.class).getQualifiedName()).append("(non-null)").append(" but was ");
                                        if ($this$checkTypeMismatch$iv$iv != null) {
                                            qualifiedName = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName();
                                        } else {
                                            qualifiedName = null;
                                        }
                                        throw new RuntimeJsonMappingException(sbAppend2.append(qualifiedName).toString());
                                    } catch (Exception e5) {
                                        e = e5;
                                        playerUrl2 = playerUrl3;
                                    }
                                }
                            }
                            return "";
                        } catch (Exception e6) {
                            e = e6;
                            playerUrl2 = playerUrl3;
                        }
                        System.out.println((Object) ("Error parsing HDBV player URL: " + e.getMessage()));
                        return "";
                    } catch (Exception e7) {
                        e = e7;
                        playerUrl2 = playerUrl;
                    }
                } catch (Exception e8) {
                    e = e8;
                    playerUrl2 = playerUrl;
                }
                break;
            case 1:
                String playerUrl5 = (String) c00071.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    c00072 = c00071;
                    obj = coroutine_suspended;
                    obj2 = "Origin";
                    obj3 = "Accept-Language";
                    obj4 = "gzip, deflate, br";
                    obj5 = "Accept-Encoding";
                    obj6 = "*/*";
                    obj7 = "Accept";
                    str = "Deserialized value did not match the specified type; specified ";
                    i = 200;
                    playerUrl3 = playerUrl5;
                    obj8 = $result;
                    response = (NiceResponse) obj8;
                    if (response.getCode() != i) {
                        return "";
                    }
                    doc = Jsoup.parse(response.getText());
                    scripts = doc.getElementsByTag("script");
                    if (scripts.size() < 8) {
                        return "";
                    }
                    script = ((Element) scripts.get(7)).toString();
                    regex = new Regex("HDVBPlayer\\((.*?)\\);");
                    matchResult = Regex.find$default(regex, script, 0, 2, (Object) null);
                    if (matchResult != null) {
                        jsonInsideHDVBPlayer = (String) matchResult.getGroupValues().get(1);
                        ObjectMapper $this$readValue$iv3 = pikashowProvider.mapper;
                        $this$checkTypeMismatch$iv$iv = $this$readValue$iv3.readValue(jsonInsideHDVBPlayer, new TypeReference<Keys>() { // from class: com.cncverse.PikashowProvider$parseHDBVPlayerUrl$$inlined$readValue$1
                        });
                        if ($this$checkTypeMismatch$iv$iv instanceof Keys) {
                            StringBuilder sbAppend3 = new StringBuilder().append(str).append(Reflection.getOrCreateKotlinClass(Keys.class).getQualifiedName()).append("(non-null)").append(" but was ");
                            if ($this$checkTypeMismatch$iv$iv != null) {
                                qualifiedName = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName();
                            } else {
                                qualifiedName = null;
                            }
                            throw new RuntimeJsonMappingException(sbAppend3.append(qualifiedName).toString());
                        }
                        fileKeys = (Keys) $this$checkTypeMismatch$iv$iv;
                        origin = StringsKt.substringBefore(playerUrl3, "/", "https://") + "://" + StringsKt.substringBefore$default(StringsKt.substringAfter$default(playerUrl3, "://", (String) null, 2, (Object) null), "/", (String) null, 2, (Object) null) + '/';
                        absoluteUrl = origin + fileKeys.getFile();
                        Map headers3 = MapsKt.mapOf(new Pair[]{TuplesKt.to(obj7, obj6), TuplesKt.to(obj5, obj4), TuplesKt.to(obj3, "en-US,en;q=0.9"), TuplesKt.to("Content-Length", "0"), TuplesKt.to("Content-Type", "application/x-www-form-urlencoded"), TuplesKt.to(obj2, origin), TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36"), TuplesKt.to("X-Csrf-Token", fileKeys.getKey())});
                        absoluteUrl2 = playerUrl3;
                        playerUrl4 = playerUrl3;
                        Requests app4 = MainActivityKt.getApp();
                        c00072.L$0 = SpillingKt.nullOutSpilledVariable(playerUrl4);
                        c00072.L$1 = SpillingKt.nullOutSpilledVariable(response);
                        c00072.L$2 = SpillingKt.nullOutSpilledVariable(doc);
                        c00072.L$3 = SpillingKt.nullOutSpilledVariable(scripts);
                        c00072.L$4 = SpillingKt.nullOutSpilledVariable(script);
                        c00072.L$5 = SpillingKt.nullOutSpilledVariable(regex);
                        c00072.L$6 = SpillingKt.nullOutSpilledVariable(matchResult);
                        c00072.L$7 = SpillingKt.nullOutSpilledVariable(jsonInsideHDVBPlayer);
                        c00072.L$8 = SpillingKt.nullOutSpilledVariable(fileKeys);
                        c00072.L$9 = origin;
                        c00072.L$10 = SpillingKt.nullOutSpilledVariable(absoluteUrl);
                        c00072.L$11 = headers3;
                        c00072.L$12 = absoluteUrl2;
                        c00072.label = 2;
                        C00071 c00076 = c00072;
                        headers = headers3;
                        scripts2 = scripts;
                        playerUrl2 = playerUrl4;
                        regex2 = regex;
                        doc2 = doc;
                        str2 = null;
                        $result = Requests.post$default(app4, absoluteUrl, headers, absoluteUrl2, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00076, 65528, (Object) null);
                        c00073 = c00076;
                        if ($result == obj) {
                            return obj;
                        }
                        origin2 = origin;
                        origin3 = jsonInsideHDVBPlayer;
                        jsonInsideHDVBPlayer2 = absoluteUrl;
                        postResponse = (NiceResponse) $result;
                        if (postResponse.getCode() != i) {
                            if (Intrinsics.areEqual(postResponse.getHeaders().get("Content-Encoding"), "gzip")) {
                                responseText = postResponse.getText();
                            } else {
                                responseText = postResponse.getText();
                            }
                            jsonArray = new JSONArray(responseText);
                            seasons = new ArrayList();
                            i2 = 0;
                            length = jsonArray.length();
                            while (i2 < length) {
                                String jsonObject2 = jsonArray.getJSONObject(i2).toString();
                                ObjectMapper $this$readValue$iv4 = pikashowProvider.mapper;
                                String content$iv2 = StringsKt.replace$default(jsonObject2, "[]", "", false, 4, (Object) null);
                                $this$checkTypeMismatch$iv$iv2 = $this$readValue$iv4.readValue(content$iv2, new TypeReference<Season>() { // from class: com.cncverse.PikashowProvider$parseHDBVPlayerUrl$$inlined$readValue$2
                                });
                                if (!($this$checkTypeMismatch$iv$iv2 instanceof Season)) {
                                    StringBuilder sbAppend4 = new StringBuilder().append(str).append(Reflection.getOrCreateKotlinClass(Season.class).getQualifiedName()).append("(non-null)").append(" but was ");
                                    if ($this$checkTypeMismatch$iv$iv2 != null) {
                                        qualifiedName2 = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv2.getClass()).getQualifiedName();
                                    } else {
                                        qualifiedName2 = str2;
                                    }
                                    throw new RuntimeJsonMappingException(sbAppend4.append(qualifiedName2).toString());
                                }
                                Season seasonData2 = (Season) $this$checkTypeMismatch$iv$iv2;
                                seasons.add(seasonData2);
                                i2++;
                                pikashowProvider = this;
                            }
                            episodeDetails = (Season) CollectionsKt.firstOrNull(seasons);
                            if (episodeDetails == null) {
                                return "";
                            }
                            hDBVEpisode = (HDBVEpisode) CollectionsKt.firstOrNull(episodeDetails.getFolder());
                            if (hDBVEpisode != null) {
                            }
                            return "";
                        }
                    }
                    return "";
                } catch (Exception e9) {
                    e = e9;
                    playerUrl2 = playerUrl5;
                }
                System.out.println((Object) ("Error parsing HDBV player URL: " + e.getMessage()));
                return "";
            case 2:
                String referer = (String) c00071.L$12;
                headers = (Map) c00071.L$11;
                String absoluteUrl3 = (String) c00071.L$10;
                origin2 = (String) c00071.L$9;
                Keys fileKeys2 = (Keys) c00071.L$8;
                String jsonInsideHDVBPlayer3 = (String) c00071.L$7;
                MatchResult matchResult2 = (MatchResult) c00071.L$6;
                Regex regex3 = (Regex) c00071.L$5;
                String script2 = (String) c00071.L$4;
                Elements scripts3 = (Elements) c00071.L$3;
                Document doc3 = (Document) c00071.L$2;
                NiceResponse response2 = (NiceResponse) c00071.L$1;
                String playerUrl6 = (String) c00071.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    c00073 = c00071;
                    obj = coroutine_suspended;
                    jsonInsideHDVBPlayer2 = absoluteUrl3;
                    fileKeys = fileKeys2;
                    origin3 = jsonInsideHDVBPlayer3;
                    matchResult = matchResult2;
                    regex2 = regex3;
                    script = script2;
                    doc2 = doc3;
                    scripts2 = scripts3;
                    str = "Deserialized value did not match the specified type; specified ";
                    absoluteUrl2 = referer;
                    response = response2;
                    playerUrl2 = playerUrl6;
                    i = 200;
                    str2 = null;
                    postResponse = (NiceResponse) $result;
                    if (postResponse.getCode() != i) {
                        return "";
                    }
                    if (Intrinsics.areEqual(postResponse.getHeaders().get("Content-Encoding"), "gzip")) {
                        responseText = postResponse.getText();
                    } else {
                        responseText = postResponse.getText();
                    }
                    jsonArray = new JSONArray(responseText);
                    seasons = new ArrayList();
                    i2 = 0;
                    length = jsonArray.length();
                    while (i2 < length) {
                        String jsonObject3 = jsonArray.getJSONObject(i2).toString();
                        ObjectMapper $this$readValue$iv5 = pikashowProvider.mapper;
                        String content$iv3 = StringsKt.replace$default(jsonObject3, "[]", "", false, 4, (Object) null);
                        $this$checkTypeMismatch$iv$iv2 = $this$readValue$iv5.readValue(content$iv3, new TypeReference<Season>() { // from class: com.cncverse.PikashowProvider$parseHDBVPlayerUrl$$inlined$readValue$2
                        });
                        if (!($this$checkTypeMismatch$iv$iv2 instanceof Season)) {
                            StringBuilder sbAppend5 = new StringBuilder().append(str).append(Reflection.getOrCreateKotlinClass(Season.class).getQualifiedName()).append("(non-null)").append(" but was ");
                            if ($this$checkTypeMismatch$iv$iv2 != null) {
                                qualifiedName2 = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv2.getClass()).getQualifiedName();
                            } else {
                                qualifiedName2 = str2;
                            }
                            throw new RuntimeJsonMappingException(sbAppend5.append(qualifiedName2).toString());
                        }
                        Season seasonData3 = (Season) $this$checkTypeMismatch$iv$iv2;
                        seasons.add(seasonData3);
                        i2++;
                        pikashowProvider = this;
                    }
                    episodeDetails = (Season) CollectionsKt.firstOrNull(seasons);
                    if (episodeDetails == null) {
                        return "";
                    }
                    hDBVEpisode = (HDBVEpisode) CollectionsKt.firstOrNull(episodeDetails.getFolder());
                    if (hDBVEpisode != null) {
                    }
                    return "";
                } catch (Exception e10) {
                    e = e10;
                    playerUrl2 = playerUrl6;
                }
                System.out.println((Object) ("Error parsing HDBV player URL: " + e.getMessage()));
                return "";
            case 3:
                String playerUrl7 = (String) c00071.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    playerUrl2 = playerUrl7;
                    playlistResponse = (NiceResponse) $result;
                    if (playlistResponse.getCode() == 200) {
                        return StringsKt.trim(playlistResponse.getText()).toString();
                    }
                    return "";
                } catch (Exception e11) {
                    e = e11;
                    playerUrl2 = playerUrl7;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final String extractImdbIdFromUrl(String url) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = url.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] hash = messageDigest.digest(bytes);
            return StringsKt.take(ArraysKt.joinToString$default(hash, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.cncverse.PikashowProvider$$ExternalSyntheticLambda13
                public final Object invoke(Object obj) {
                    return PikashowProvider.extractImdbIdFromUrl$lambda$0(((Byte) obj).byteValue());
                }
            }, 30, (Object) null), 10);
        } catch (Exception e) {
            return "default";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence extractImdbIdFromUrl$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:37:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:57:0x011e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object fallbackToDirectUrls(VideoData videoData, Function1<? super ExtractorLink, Unit> function1, String contentName, Map<String, String> map, Continuation<? super Unit> continuation) {
        C00031 c00031;
        PikashowProvider pikashowProvider;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int value;
        ExtractorLinkType linkType;
        Function1<? super ExtractorLink, Unit> function2;
        Object objNewExtractorLink;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
                pikashowProvider = this;
            } else {
                pikashowProvider = this;
                c00031 = pikashowProvider.new C00031(continuation);
            }
        } else {
            pikashowProvider = this;
            c00031 = pikashowProvider.new C00031(continuation);
        }
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String playUrl = videoData.getPlayUrl();
                if (playUrl == null && (playUrl = videoData.getVideoUrl()) == null) {
                    playUrl = videoData.getUrl();
                }
                String directUrl = playUrl;
                if (directUrl != null) {
                    String quality = videoData.getQuality();
                    if (quality != null) {
                        String lowerCase = quality.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        if (lowerCase == null || !StringsKt.contains$default(lowerCase, "hd", false, 2, (Object) null)) {
                            z = false;
                        } else {
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        value = Qualities.P720.getValue();
                    } else {
                        String quality2 = videoData.getQuality();
                        if (quality2 != null) {
                            String lowerCase2 = quality2.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                            if (lowerCase2 == null || !StringsKt.contains$default(lowerCase2, "1080", false, 2, (Object) null)) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            value = Qualities.P1080.getValue();
                        } else {
                            String quality3 = videoData.getQuality();
                            if (quality3 != null) {
                                String lowerCase3 = quality3.toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                if (lowerCase3 == null || !StringsKt.contains$default(lowerCase3, "720", false, 2, (Object) null)) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                value = Qualities.P720.getValue();
                            } else {
                                String quality4 = videoData.getQuality();
                                if (quality4 != null) {
                                    String lowerCase4 = quality4.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                                    if (lowerCase4 == null || !StringsKt.contains$default(lowerCase4, "480", false, 2, (Object) null)) {
                                        z4 = false;
                                    } else {
                                        z4 = true;
                                    }
                                } else {
                                    z4 = false;
                                }
                                value = z4 ? Qualities.P480.getValue() : Qualities.Unknown.getValue();
                            }
                        }
                    }
                    int quality5 = value;
                    if (StringsKt.contains$default(directUrl, "m3u8", false, 2, (Object) null) || Intrinsics.areEqual(videoData.getSourceType(), "hls")) {
                        linkType = ExtractorLinkType.M3U8;
                    } else {
                        linkType = Intrinsics.areEqual(videoData.getSourceType(), "direct") ? ExtractorLinkType.VIDEO : ExtractorLinkType.VIDEO;
                    }
                    String name = pikashowProvider.getName();
                    StringBuilder sbAppend = new StringBuilder().append(contentName).append(" - ");
                    String host = videoData.getHost();
                    if (host == null) {
                        host = "Direct";
                    }
                    String string = sbAppend.append(host).toString();
                    PikashowProvider$fallbackToDirectUrls$2$1 pikashowProvider$fallbackToDirectUrls$2$1 = new PikashowProvider$fallbackToDirectUrls$2$1(quality5, map, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(videoData);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(contentName);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(map);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(directUrl);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(directUrl);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(linkType);
                    function2 = function1;
                    c00032.L$7 = function2;
                    c00032.I$0 = 0;
                    c00032.I$1 = quality5;
                    c00032.label = 1;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, string, directUrl, linkType, pikashowProvider$fallbackToDirectUrls$2$1, c00032);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function2.invoke(objNewExtractorLink);
                }
                return Unit.INSTANCE;
            case 1:
                int i = c00032.I$1;
                int i2 = c00032.I$0;
                Function1<? super ExtractorLink, Unit> function3 = (Function1) c00032.L$7;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function2 = function3;
                function2.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if (r0.equals("2160P") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        if (r0.equals("1080P") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r0.equals("720P") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        if (r0.equals("480P") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        if (r0.equals("FHD") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        if (r0.equals("SD") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0064, code lost:
    
        if (r0.equals("HD") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0074, code lost:
    
        if (r0.equals("4K") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
    
        return com.lagradost.cloudstream3.utils.Qualities.P1080.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        return com.lagradost.cloudstream3.utils.Qualities.P480.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
    
        return com.lagradost.cloudstream3.utils.Qualities.P720.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
    
        return com.lagradost.cloudstream3.utils.Qualities.P2160.getValue();
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int getQualityValue(String qualityString) {
        String upperCase;
        if (qualityString != null) {
            upperCase = qualityString.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        } else {
            upperCase = null;
        }
        if (upperCase != null) {
            switch (upperCase.hashCode()) {
                case 1687:
                    break;
                case 2300:
                    break;
                case 2641:
                    break;
                case 69570:
                    break;
                case 1604516:
                    break;
                case 1688123:
                    break;
                case 46737881:
                    break;
                case 47689271:
                    break;
            }
        }
        return Qualities.Unknown.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int getQualityValueFromLabel(String label) {
        String lowerCase;
        if (label != null) {
            lowerCase = label.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase != null) {
            switch (lowerCase.hashCode()) {
                case 1572835:
                    if (lowerCase.equals("360p")) {
                        return Qualities.P360.getValue();
                    }
                    break;
                case 1604548:
                    if (lowerCase.equals("480p")) {
                        return Qualities.P480.getValue();
                    }
                    break;
                case 1688155:
                    if (lowerCase.equals("720p")) {
                        return Qualities.P720.getValue();
                    }
                    break;
                case 46737913:
                    if (lowerCase.equals("1080p")) {
                        return Qualities.P1080.getValue();
                    }
                    break;
                case 1544803905:
                    if (lowerCase.equals("default")) {
                        return Qualities.P720.getValue();
                    }
                    break;
            }
        }
        return Qualities.Unknown.getValue();
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
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.PikashowProvider$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    PikashowProvider.showSubscriptionPopupIfNeeded$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.PikashowProvider$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PikashowProvider.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.PikashowProvider$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PikashowProvider.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.PikashowProvider$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                PikashowProvider.showTelegramPopup$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.PikashowProvider$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.PikashowProvider$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PikashowProvider.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.PikashowProvider$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                PikashowProvider.openInExternalBrowser$lambda$0(ctx, url);
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
