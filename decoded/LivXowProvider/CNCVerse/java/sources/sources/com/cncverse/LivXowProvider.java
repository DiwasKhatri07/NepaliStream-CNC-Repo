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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LiveSearchResponse;
import com.lagradost.cloudstream3.LiveStreamLoadResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DrmExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import java.io.Closeable;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
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
import kotlin.text.Charsets;
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
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LivXowProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/LivXowProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 J2\u00020\u0001:\u0002JKB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\u0004\u0018\u00010\u0003*\u00020\u0003H\u0002J\u000e\u0010)\u001a\u0004\u0018\u00010\u0003*\u00020\u0003H\u0002J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003H\u0002J$\u0010,\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001eH\u0002J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0003H\u0002J\u001e\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u00106J\u001c\u00107\u001a\b\u0012\u0004\u0012\u000209082\u0006\u0010:\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010'J\u0016\u0010;\u001a\u00020<2\u0006\u0010&\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010'J\b\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020>H\u0002J\u0010\u0010@\u001a\u00020>2\u0006\u0010&\u001a\u00020\u0003H\u0002JF\u0010A\u001a\u00020\u00132\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00132\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020>0E2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020>0EH\u0096@¢\u0006\u0002\u0010IR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"¨\u0006L"}, d2 = {"Lcom/cncverse/LivXowProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "customName", "", "customMainUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "lang", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "hasChromecastSupport", "getHasChromecastSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "headers", "", "customHttpClient", "Lokhttp3/OkHttpClient;", "getCustomHttpClient", "()Lokhttp3/OkHttpClient;", "customHttpClient$delegate", "Lkotlin/Lazy;", "getWithCustomHeaders", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base64ToHexOrNull", "hexToBase64UrlOrNull", "decryptContent", "content", "getMpdStream", "customHeaders", "getDRMKeysFromLicenseServer", "kid", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "showSubscriptionPopupIfNeeded", "", "showTelegramPopup", "openInExternalBrowser", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "LoadData", "LivXowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLivXowProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivXowProvider.kt\ncom/cncverse/LivXowProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 6 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 7 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1380:1\n296#2,2:1381\n1586#2:1383\n1661#2,3:1384\n296#2,2:1406\n1512#2:1408\n1538#2,3:1409\n1541#2,3:1419\n1586#2:1425\n1661#2,3:1426\n777#2:1430\n873#2,2:1431\n1586#2:1433\n1661#2,3:1434\n1586#2:1475\n1661#2,3:1476\n63#3:1387\n64#3,15:1389\n63#3:1437\n64#3,15:1439\n63#3:1456\n64#3,15:1458\n1#4:1388\n1#4:1438\n1#4:1457\n1#4:1479\n50#5:1404\n43#5:1405\n50#5:1454\n43#5:1455\n50#5:1473\n43#5:1474\n383#6,7:1412\n129#7:1422\n158#7,2:1423\n160#7:1429\n*S KotlinDebug\n*F\n+ 1 LivXowProvider.kt\ncom/cncverse/LivXowProvider\n*L\n137#1:1381,2\n193#1:1383\n193#1:1384,3\n283#1:1406,2\n301#1:1408\n301#1:1409,3\n301#1:1419,3\n303#1:1425\n303#1:1426,3\n334#1:1430\n334#1:1431,2\n334#1:1433\n334#1:1434,3\n698#1:1475\n698#1:1476,3\n280#1:1387\n280#1:1389,15\n355#1:1437\n355#1:1439,15\n624#1:1456\n624#1:1458,15\n280#1:1388\n355#1:1438\n624#1:1457\n280#1:1404\n280#1:1405\n355#1:1454\n355#1:1455\n624#1:1473\n624#1:1474\n301#1:1412,7\n301#1:1422\n301#1:1423,2\n301#1:1429\n*E\n"})
public final class LivXowProvider extends MainAPI {
    private static final long BROWSER_DEBOUNCE_MS = 10000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EXT_INF = "#EXTINF";

    @NotNull
    public static final String EXT_M3U = "#EXTM3U";

    @NotNull
    public static final String EXT_VLC_OPT = "#EXTVLCOPT";

    @NotNull
    private static final String OMG10 = "aHR0cHM6Ly9vbWcxMC5jb20vNC8xMTEwNDQ4OQ==";

    @Nullable
    private static Context context;
    private static volatile boolean csGuardWasEverActive;
    private static volatile long lastBrowserOpenMs;
    private static volatile boolean subscriptionPopupShown;
    private static volatile boolean telegramPopupShown;

    /* JADX INFO: renamed from: customHttpClient$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy customHttpClient;

    @NotNull
    private final String customMainUrl;

    @NotNull
    private final String customName;
    private final boolean hasChromecastSupport;
    private final boolean hasMainPage;

    @NotNull
    private final Map<String, String> headers;

    @NotNull
    private String lang;

    @NotNull
    private String mainUrl;

    @NotNull
    private String name;

    @NotNull
    private final Set<TvType> supportedTypes;

    /* JADX INFO: renamed from: com.cncverse.LivXowProvider$getMainPage$1 */
    /* JADX INFO: compiled from: LivXowProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProvider", f = "LivXowProvider.kt", i = {0, 0}, l = {298}, m = "getMainPage", n = {"request", "page"}, nl = {299}, s = {"L$0", "I$0"}, v = 2)
    static final class C00331 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00331(Continuation<? super C00331> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LivXowProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowProvider$loadLinks$1 */
    /* JADX INFO: compiled from: LivXowProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProvider", f = "LivXowProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, l = {670, 709, 729, 747, 773, 796, 820}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "loadData", "headers", "normalizedKey", "normalizedKid", "playerKey", "playerKid", "isCasting", "hasValidKeys", "hasLicenseUrl", "data", "subtitleCallback", "callback", "loadData", "headers", "mpdStr", "regex", "matchResult", "drmKid", "drmKidBytes", "drmKidBase64", "keyBase64", "isCasting", "hasValidKeys", "hasLicenseUrl", "data", "subtitleCallback", "callback", "loadData", "headers", "mpdStr", "regex", "matchResult", "drmKid", "drmKidBytes", "drmKidBase64", "keyBase64", "isCasting", "hasValidKeys", "hasLicenseUrl", "data", "subtitleCallback", "callback", "loadData", "headers", "isCasting", "hasValidKeys", "hasLicenseUrl", "data", "subtitleCallback", "callback", "loadData", "headers", "isCasting", "data", "subtitleCallback", "callback", "loadData", "headers", "isCasting", "data", "subtitleCallback", "callback", "loadData", "headers", "isCasting"}, nl = {669, 708, 728, 746, 772, 795, 819}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 2)
    static final class C00351 extends ContinuationImpl {
        int I$0;
        int I$1;
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
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00351(Continuation<? super C00351> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LivXowProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowProvider$search$1 */
    /* JADX INFO: compiled from: LivXowProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProvider", f = "LivXowProvider.kt", i = {0}, l = {331}, m = "search", n = {"query"}, nl = {332}, s = {"L$0"}, v = 2)
    static final class C00431 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00431(Continuation<? super C00431> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LivXowProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LivXowProvider() {
        String str = null;
        this(str, str, 3, str);
    }

    public LivXowProvider(@NotNull String customName, @NotNull String customMainUrl) {
        this.customName = customName;
        this.customMainUrl = customMainUrl;
        this.lang = "ta";
        this.mainUrl = this.customMainUrl;
        this.name = this.customName;
        this.hasMainPage = true;
        this.hasChromecastSupport = true;
        this.supportedTypes = SetsKt.setOf(TvType.Live);
        this.headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("accept", "*/*"), TuplesKt.to("Cache-Control", "no-cache, no-store"), TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; rv:78.0) Gecko/20100101 Firefox/78.0")});
        this.customHttpClient = LazyKt.lazy(new Function0() { // from class: com.cncverse.LivXowProvider$$ExternalSyntheticLambda4
            public final Object invoke() {
                return LivXowProvider.customHttpClient_delegate$lambda$0(this.f$0);
            }
        });
    }

    public /* synthetic */ LivXowProvider(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "IPTV Player" : str, (i & 2) != 0 ? "https://fifabd.site/OPLLX7/LIVE2.m3u" : str2);
    }

    /* JADX INFO: compiled from: LivXowProvider.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/cncverse/LivXowProvider$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "OMG10", "", "lastBrowserOpenMs", "", "telegramPopupShown", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "EXT_M3U", "EXT_INF", "EXT_VLC_OPT", "LivXowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nLivXowProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivXowProvider.kt\ncom/cncverse/LivXowProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1380:1\n1#2:1381\n*E\n"})
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
                LivXowProvider.csGuardWasEverActive = true;
            }
            return LivXowProvider.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.LivXowProvider$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LivXowProvider.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getContext() {
            return LivXowProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            LivXowProvider.context = context;
        }
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
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

    public boolean getHasChromecastSupport() {
        return this.hasChromecastSupport;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    private final OkHttpClient getCustomHttpClient() {
        return (OkHttpClient) this.customHttpClient.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient customHttpClient_delegate$lambda$0(LivXowProvider this$0) {
        return new OkHttpClient.Builder().addInterceptor(new HeaderReplacementInterceptor(this$0.headers)).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getWithCustomHeaders(String url, Continuation<? super String> continuation) {
        boolean hasCustomHeaders;
        String finalUrl;
        OkHttpClient customHttpClient;
        Object element$iv;
        String it;
        Map dynamicHeaders = MapsKt.toMutableMap(this.headers);
        boolean hasCustomHeaders2 = false;
        int i = 0;
        if (!StringsKt.contains$default(url, "|", false, 2, (Object) null)) {
            hasCustomHeaders = false;
            finalUrl = url;
        } else {
            List parts = StringsKt.split$default(url, new String[]{"|"}, false, 2, 2, (Object) null);
            String finalUrl2 = (String) parts.get(0);
            String headersPart = (String) parts.get(1);
            List<String> headerPairs = StringsKt.split$default(headersPart, new String[]{"&"}, false, 0, 6, (Object) null);
            for (String pair : headerPairs) {
                List kv = StringsKt.split$default(pair, new String[]{"="}, false, 2, 2, (Object) null);
                if (kv.size() != 2) {
                    i = 0;
                } else {
                    String key = StringsKt.trim((String) kv.get(i)).toString();
                    String value = StringsKt.trim((String) kv.get(1)).toString();
                    Iterable $this$firstOrNull$iv = dynamicHeaders.keySet();
                    Iterator it2 = $this$firstOrNull$iv.iterator();
                    do {
                        if (!it2.hasNext()) {
                            element$iv = null;
                            break;
                        }
                        element$iv = it2.next();
                        it = (String) element$iv;
                    } while (!StringsKt.equals(it, key, true));
                    String existingKey = (String) element$iv;
                    if (existingKey != null) {
                        dynamicHeaders.remove(existingKey);
                    }
                    dynamicHeaders.put(key, value);
                    hasCustomHeaders2 = true;
                    i = 0;
                }
            }
            hasCustomHeaders = hasCustomHeaders2;
            finalUrl = finalUrl2;
        }
        Request request = new Request.Builder().url(finalUrl).build();
        if (hasCustomHeaders) {
            customHttpClient = new OkHttpClient.Builder().addInterceptor(new HeaderReplacementInterceptor(dynamicHeaders)).build();
        } else {
            customHttpClient = getCustomHttpClient();
        }
        OkHttpClient client = customHttpClient;
        Response response = (Closeable) client.newCall(request).execute();
        try {
            Response response2 = response;
            String strString = response2.body().string();
            CloseableKt.closeFinally(response, (Throwable) null);
            return strString;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(response, th);
                throw th2;
            }
        }
    }

    private final String base64ToHexOrNull(String $this$base64ToHexOrNull) {
        String raw = StringsKt.trim($this$base64ToHexOrNull).toString();
        String normalizedHex = StringsKt.replace$default(raw, "-", "", false, 4, (Object) null);
        if ((normalizedHex.length() > 0) && normalizedHex.length() % 2 == 0) {
            if (new Regex("^[0-9a-fA-F]+$").matches(normalizedHex)) {
                String lowerCase = normalizedHex.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                return lowerCase;
            }
        }
        try {
            String value = StringsKt.replace$default(StringsKt.replace$default(raw, '-', '+', false, 4, (Object) null), '_', '/', false, 4, (Object) null);
            int padding = (4 - (value.length() % 4)) % 4;
            String normalized = value + StringsKt.repeat("=", padding);
            byte[] decoded = Base64.decode(normalized, 0);
            return ArraysKt.joinToString$default(decoded, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.cncverse.LivXowProvider$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    return LivXowProvider.base64ToHexOrNull$lambda$1(((Byte) obj).byteValue());
                }
            }, 30, (Object) null);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence base64ToHexOrNull$lambda$1(byte b) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final String hexToBase64UrlOrNull(String $this$hexToBase64UrlOrNull) {
        String normalizedHex = StringsKt.replace$default(StringsKt.trim($this$hexToBase64UrlOrNull).toString(), "-", "", false, 4, (Object) null);
        if (!(normalizedHex.length() == 0) && normalizedHex.length() % 2 == 0) {
            if (new Regex("^[0-9a-fA-F]+$").matches(normalizedHex)) {
                try {
                    Iterable $this$map$iv = StringsKt.chunked(normalizedHex, 2);
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        String it = (String) item$iv$iv;
                        destination$iv$iv.add(Byte.valueOf((byte) Integer.parseInt(it, CharsKt.checkRadix(16))));
                    }
                    byte[] bytes = CollectionsKt.toByteArray((List) destination$iv$iv);
                    return Base64.encodeToString(bytes, 11);
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return null;
    }

    private final String decryptContent(String content) {
        try {
            if (!StringsKt.startsWith$default(content, EXT_M3U, false, 2, (Object) null) && !StringsKt.startsWith$default(content, EXT_INF, false, 2, (Object) null) && !StringsKt.startsWith$default(content, "#KODIPROP", false, 2, (Object) null)) {
                String trimmedContent = StringsKt.trim(content).toString();
                if (trimmedContent.length() < 79) {
                    return trimmedContent;
                }
                String part1 = trimmedContent.substring(0, 10);
                Intrinsics.checkNotNullExpressionValue(part1, "substring(...)");
                String part2 = trimmedContent.substring(34, trimmedContent.length() - 54);
                Intrinsics.checkNotNullExpressionValue(part2, "substring(...)");
                String part3 = trimmedContent.substring(trimmedContent.length() - 10);
                Intrinsics.checkNotNullExpressionValue(part3, "substring(...)");
                String encryptedData = part1 + part2 + part3;
                String ivBase64 = trimmedContent.substring(10, 34);
                Intrinsics.checkNotNullExpressionValue(ivBase64, "substring(...)");
                String keyBase64 = trimmedContent.substring(trimmedContent.length() - 54, trimmedContent.length() - 10);
                Intrinsics.checkNotNullExpressionValue(keyBase64, "substring(...)");
                byte[] iv = Base64.decode(ivBase64, 0);
                byte[] key = Base64.decode(keyBase64, 0);
                byte[] encrypted = Base64.decode(encryptedData, 0);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
                IvParameterSpec ivSpec = new IvParameterSpec(iv);
                cipher.init(2, secretKey, ivSpec);
                byte[] decrypted = cipher.doFinal(encrypted);
                return new String(decrypted, StandardCharsets.UTF_8);
            }
            return content;
        } catch (Exception e) {
            return content;
        }
    }

    private final String getMpdStream(String url, Map<String, String> customHeaders) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new HeaderReplacementInterceptor(customHeaders)).build();
        Request request = new Request.Builder().url(url).build();
        Response response = (Closeable) client.newCall(request).execute();
        try {
            Response response2 = response;
            String strString = response2.body().string();
            CloseableKt.closeFinally(response, (Throwable) null);
            return strString;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(response, th);
                throw th2;
            }
        }
    }

    private final String getDRMKeysFromLicenseServer(String url, String kid) {
        Throwable th;
        Object obj;
        Object objDecodeFromString;
        List keys;
        Object element$iv;
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new HeaderReplacementInterceptor(MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Dalvik/2.1.0 (Linux; U; Android)"), TuplesKt.to("Content-Type", "application/json;charset=UTF-8")}))).addInterceptor(new LoggingInterceptor()).build();
        String json = "{\"kids\":[\"" + kid + "\"],\"type\":\"temporary\"}";
        MediaType mediaType = MediaType.Companion.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.Companion.create(json, mediaType);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = (Closeable) client.newCall(request).execute();
        try {
            Response response2 = response;
            String responseBody = response2.body().string();
            AppUtils appUtils = AppUtils.INSTANCE;
            try {
                Result.Companion companion = Result.Companion;
                try {
                    try {
                        KType kTypeTypeOf = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Object.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                CloseableKt.closeFinally(response, th);
                                throw th4;
                            }
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
            }
            if (Result.exceptionOrNull-impl(obj) != null) {
                try {
                    Result.Companion companion3 = Result.Companion;
                    try {
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                    } catch (Throwable th7) {
                        th = th7;
                        try {
                            Result.Companion companion4 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        } catch (Throwable th8) {
                            th = th8;
                            throw th;
                        }
                    }
                } catch (Throwable th9) {
                    th = th9;
                }
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            DeserializationStrategy deserializationStrategy = (KSerializer) obj;
            if (deserializationStrategy != null) {
                try {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, responseBody);
                } catch (SerializationException e) {
                    ArchComponentExtKt.logError(e);
                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LivXowProvider$getDRMKeysFromLicenseServer$lambda$0$$inlined$parseJson$1
                    });
                } catch (Throwable th10) {
                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv2.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LivXowProvider$getDRMKeysFromLicenseServer$lambda$0$$inlined$parseJson$1
                    });
                }
            } else {
                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv3.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.LivXowProvider$getDRMKeysFromLicenseServer$lambda$0$$inlined$parseJson$1
                });
            }
            Map jsonResponse = (Map) objDecodeFromString;
            Object obj2 = jsonResponse.get("keys");
            List keys2 = obj2 instanceof List ? (List) obj2 : null;
            if (keys2 != null) {
                Iterable $this$firstOrNull$iv = keys2;
                Iterator it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        keys = keys2;
                        element$iv = null;
                        break;
                    }
                    element$iv = it.next();
                    Map it2 = (Map) element$iv;
                    Map jsonResponse2 = jsonResponse;
                    keys = keys2;
                    if (Intrinsics.areEqual(it2.get("kid"), kid)) {
                        break;
                    }
                    jsonResponse = jsonResponse2;
                    keys2 = keys;
                }
                Map matchedKey = (Map) element$iv;
                if (matchedKey != null || (matchedKey = (Map) CollectionsKt.firstOrNull(keys)) != null) {
                    String str = (String) matchedKey.get("k");
                    String str2 = str != null ? str : "";
                    CloseableKt.closeFinally(response, (Throwable) null);
                    return str2;
                }
            }
            CloseableKt.closeFinally(response, (Throwable) null);
            return "";
        } catch (Throwable th11) {
            th = th11;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00331 c00331;
        int page2;
        Object obj;
        MainPageRequest request2;
        Object answer$iv$iv$iv;
        if (continuation instanceof C00331) {
            c00331 = (C00331) continuation;
            if ((c00331.label & Integer.MIN_VALUE) != 0) {
                c00331.label -= Integer.MIN_VALUE;
            } else {
                c00331 = new C00331(continuation);
            }
        } else {
            c00331 = new C00331(continuation);
        }
        Object $result = c00331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00331.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                showTelegramPopup();
                showSubscriptionPopupIfNeeded();
                String mainUrl = getMainUrl();
                c00331.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00331.I$0 = page;
                c00331.label = 1;
                Object withCustomHeaders = getWithCustomHeaders(mainUrl, c00331);
                if (withCustomHeaders == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page2 = page;
                obj = withCustomHeaders;
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00331.I$0;
                request2 = (MainPageRequest) c00331.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String rawContent = (String) obj;
        String decryptedContent = decryptContent(rawContent);
        Playlist data = new IptvPlaylistParser().parseM3U(decryptedContent);
        Iterable $this$groupBy$iv = data.getItems();
        Map $this$map$iv = new LinkedHashMap();
        for (Object element$iv$iv : $this$groupBy$iv) {
            PlaylistItem it = (PlaylistItem) element$iv$iv;
            String str = it.getAttributes().get("group-title");
            Object value$iv$iv$iv = $this$map$iv.get(str);
            if (value$iv$iv$iv == null) {
                Object answer$iv$iv$iv2 = (List) new ArrayList();
                answer$iv$iv$iv = answer$iv$iv$iv2;
                $this$map$iv.put(str, answer$iv$iv$iv);
            } else {
                answer$iv$iv$iv = value$iv$iv$iv;
            }
            List list$iv$iv = (List) answer$iv$iv$iv;
            list$iv$iv.add(element$iv$iv);
            c00331 = c00331;
        }
        int $i$f$map = 0;
        Collection destination$iv$iv = new ArrayList($this$map$iv.size());
        Map $this$mapTo$iv$iv = $this$map$iv;
        for (Map.Entry item$iv$iv : $this$mapTo$iv$iv.entrySet()) {
            String str2 = (String) item$iv$iv.getKey();
            if (str2 == null) {
                str2 = "";
            }
            String title = str2;
            int $i$f$map2 = $i$f$map;
            Iterable $this$map$iv2 = (Iterable) item$iv$iv.getValue();
            Map $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
            Object $result2 = $result;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            Iterable<PlaylistItem> $this$mapTo$iv$iv3 = $this$map$iv2;
            for (final PlaylistItem channel : $this$mapTo$iv$iv3) {
                Iterable $this$map$iv3 = $this$map$iv2;
                String streamurl = String.valueOf(channel.getUrl());
                String channelname = String.valueOf(channel.getTitle());
                Iterable $this$mapTo$iv$iv4 = $this$mapTo$iv$iv3;
                int page3 = page2;
                final String posterurl = String.valueOf(channel.getAttributes().get("tvg-logo"));
                String nation = String.valueOf(channel.getAttributes().get("group-title"));
                String key = channel.getKey();
                String key2 = key == null ? "" : key;
                String keyid = channel.getKeyid();
                String keyid2 = keyid == null ? "" : keyid;
                String userAgent = channel.getUserAgent();
                String userAgent2 = userAgent == null ? "" : userAgent;
                String cookie = channel.getCookie();
                String cookie2 = cookie == null ? "" : cookie;
                String licenseUrl = channel.getLicenseUrl();
                String licenseUrl2 = licenseUrl == null ? "" : licenseUrl;
                destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, channelname, AppUtils.INSTANCE.toJson(new LoadData(streamurl, channelname, posterurl, nation, key2, keyid2, userAgent2, cookie2, licenseUrl2, channel.getDrmKeys(), channel.getHeaders())), TvType.Live, false, new Function1() { // from class: com.cncverse.LivXowProvider$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        return LivXowProvider.getMainPage$lambda$1$0$0(posterurl, channel, (LiveSearchResponse) obj2);
                    }
                }, 8, (Object) null));
                $this$map$iv2 = $this$map$iv3;
                $this$mapTo$iv$iv3 = $this$mapTo$iv$iv4;
                page2 = page3;
                request2 = request2;
            }
            List show = (List) destination$iv$iv2;
            destination$iv$iv.add(new HomePageList(title, show, true));
            $i$f$map = $i$f$map2;
            $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
            $result = $result2;
            page2 = page2;
        }
        return MainAPIKt.newHomePageResponse((List) destination$iv$iv, Boxing.boxBoolean(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$1$0$0(String $posterurl, PlaylistItem $channel, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl($posterurl);
        $this$newLiveSearchResponse.getApiName();
        $this$newLiveSearchResponse.setLang($channel.getAttributes().get("group-title"));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00431 c00431;
        Object withCustomHeaders;
        String query2;
        LivXowProvider livXowProvider = this;
        if (continuation instanceof C00431) {
            c00431 = (C00431) continuation;
            if ((c00431.label & Integer.MIN_VALUE) != 0) {
                c00431.label -= Integer.MIN_VALUE;
            } else {
                c00431 = livXowProvider.new C00431(continuation);
            }
        } else {
            c00431 = livXowProvider.new C00431(continuation);
        }
        Object $result = c00431.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00431.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return CollectionsKt.emptyList();
                }
                String mainUrl = livXowProvider.getMainUrl();
                c00431.L$0 = query;
                c00431.label = 1;
                withCustomHeaders = livXowProvider.getWithCustomHeaders(mainUrl, c00431);
                if (withCustomHeaders == coroutine_suspended) {
                    return coroutine_suspended;
                }
                query2 = query;
                break;
                break;
            case 1:
                query2 = (String) c00431.L$0;
                ResultKt.throwOnFailure($result);
                withCustomHeaders = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String rawContent = (String) withCustomHeaders;
        String decryptedContent = livXowProvider.decryptContent(rawContent);
        Playlist data = new IptvPlaylistParser().parseM3U(decryptedContent);
        Iterable $this$filter$iv = data.getItems();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            PlaylistItem it = (PlaylistItem) element$iv$iv;
            String title = it.getTitle();
            if (title != null ? StringsKt.contains(title, query2, true) : false) {
                destination$iv$iv.add(element$iv$iv);
            }
            c00431 = c00431;
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            final PlaylistItem channel = (PlaylistItem) item$iv$iv;
            String streamurl = String.valueOf(channel.getUrl());
            String channelname = String.valueOf(channel.getTitle());
            Iterable $this$map$iv2 = $this$map$iv;
            final String posterurl = String.valueOf(channel.getAttributes().get("tvg-logo"));
            String nation = String.valueOf(channel.getAttributes().get("group-title"));
            String key = channel.getKey();
            String key2 = key == null ? "" : key;
            String keyid = channel.getKeyid();
            String keyid2 = keyid == null ? "" : keyid;
            String userAgent = channel.getUserAgent();
            String userAgent2 = userAgent == null ? "" : userAgent;
            String cookie = channel.getCookie();
            String cookie2 = cookie == null ? "" : cookie;
            String licenseUrl = channel.getLicenseUrl();
            String licenseUrl2 = licenseUrl == null ? "" : licenseUrl;
            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(livXowProvider, channelname, AppUtils.INSTANCE.toJson(new LoadData(streamurl, channelname, posterurl, nation, key2, keyid2, userAgent2, cookie2, licenseUrl2, channel.getDrmKeys(), livXowProvider.headers)), TvType.Live, false, new Function1() { // from class: com.cncverse.LivXowProvider$$ExternalSyntheticLambda8
                public final Object invoke(Object obj) {
                    return LivXowProvider.search$lambda$1$0(posterurl, channel, (LiveSearchResponse) obj);
                }
            }, 8, (Object) null));
            livXowProvider = this;
            $this$map$iv = $this$map$iv2;
        }
        return (List) destination$iv$iv2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$1$0(String $posterurl, PlaylistItem $channel, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl($posterurl);
        $this$newLiveSearchResponse.getApiName();
        $this$newLiveSearchResponse.setLang($channel.getAttributes().get("group-title"));
        return Unit.INSTANCE;
    }

    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        Object obj;
        Object objDecodeFromString;
        AppUtils appUtils = AppUtils.INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            KType kTypeTypeOf = Reflection.typeOf(LoadData.class);
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            try {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LoadData.class), (List) null, 2, (Object) null));
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
                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, url);
            } catch (SerializationException e) {
                ArchComponentExtKt.logError(e);
                ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv.readValue(url, new TypeReference<LoadData>() { // from class: com.cncverse.LivXowProvider$load$$inlined$parseJson$1
                });
            } catch (Throwable th3) {
                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv2.readValue(url, new TypeReference<LoadData>() { // from class: com.cncverse.LivXowProvider$load$$inlined$parseJson$1
                });
            }
        } else {
            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
            objDecodeFromString = $this$readValue$iv$iv3.readValue(url, new TypeReference<LoadData>() { // from class: com.cncverse.LivXowProvider$load$$inlined$parseJson$1
            });
        }
        LoadData data = (LoadData) objDecodeFromString;
        return MainAPIKt.newLiveStreamLoadResponse(this, data.getTitle(), url, url, new C00342(data, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowProvider$load$2 */
    /* JADX INFO: compiled from: LivXowProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/LiveStreamLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProvider$load$2", f = "LivXowProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00342 extends SuspendLambda implements Function2<LiveStreamLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ LoadData $data;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00342(LoadData loadData, Continuation<? super C00342> continuation) {
            super(2, continuation);
            this.$data = loadData;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00342 = new C00342(this.$data, continuation);
            c00342.L$0 = obj;
            return c00342;
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
                    $this$newLiveStreamLoadResponse.setPosterUrl(this.$data.getPoster());
                    $this$newLiveStreamLoadResponse.setPlot(this.$data.getNation());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: LivXowProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0015\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u0015\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u008f\u0001\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rHÆ\u0001J\u0014\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020.HÖ\u0081\u0004J\n\u0010/\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001c¨\u00060"}, d2 = {"Lcom/cncverse/LivXowProvider$LoadData;", "", "url", "", "title", "poster", "nation", "key", "keyid", "userAgent", "cookie", "licenseUrl", "drmKeys", "", "headers", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getUrl", "()Ljava/lang/String;", "getTitle", "getPoster", "getNation", "getKey", "getKeyid", "getUserAgent", "getCookie", "getLicenseUrl", "getDrmKeys", "()Ljava/util/Map;", "getHeaders", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "", "toString", "LivXowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class LoadData {

        @NotNull
        private final String cookie;

        @NotNull
        private final Map<String, String> drmKeys;

        @NotNull
        private final Map<String, String> headers;

        @NotNull
        private final String key;

        @NotNull
        private final String keyid;

        @NotNull
        private final String licenseUrl;

        @NotNull
        private final String nation;

        @NotNull
        private final String poster;

        @NotNull
        private final String title;

        @NotNull
        private final String url;

        @NotNull
        private final String userAgent;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LoadData copy$default(LoadData loadData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadData.url;
            }
            if ((i & 2) != 0) {
                str2 = loadData.title;
            }
            if ((i & 4) != 0) {
                str3 = loadData.poster;
            }
            if ((i & 8) != 0) {
                str4 = loadData.nation;
            }
            if ((i & 16) != 0) {
                str5 = loadData.key;
            }
            if ((i & 32) != 0) {
                str6 = loadData.keyid;
            }
            if ((i & 64) != 0) {
                str7 = loadData.userAgent;
            }
            if ((i & 128) != 0) {
                str8 = loadData.cookie;
            }
            if ((i & 256) != 0) {
                str9 = loadData.licenseUrl;
            }
            if ((i & 512) != 0) {
                map = loadData.drmKeys;
            }
            if ((i & 1024) != 0) {
                map2 = loadData.headers;
            }
            Map map3 = map;
            Map map4 = map2;
            String str10 = str8;
            String str11 = str9;
            String str12 = str6;
            String str13 = str7;
            String str14 = str5;
            String str15 = str3;
            return loadData.copy(str, str2, str15, str4, str14, str12, str13, str10, str11, map3, map4);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final Map<String, String> component10() {
            return this.drmKeys;
        }

        @NotNull
        public final Map<String, String> component11() {
            return this.headers;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getNation() {
            return this.nation;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getKeyid() {
            return this.keyid;
        }

        @NotNull
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getUserAgent() {
            return this.userAgent;
        }

        @NotNull
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getCookie() {
            return this.cookie;
        }

        @NotNull
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getLicenseUrl() {
            return this.licenseUrl;
        }

        @NotNull
        public final LoadData copy(@NotNull String url, @NotNull String title, @NotNull String poster, @NotNull String nation, @NotNull String key, @NotNull String keyid, @NotNull String userAgent, @NotNull String cookie, @NotNull String licenseUrl, @NotNull Map<String, String> drmKeys, @NotNull Map<String, String> headers) {
            return new LoadData(url, title, poster, nation, key, keyid, userAgent, cookie, licenseUrl, drmKeys, headers);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadData)) {
                return false;
            }
            LoadData loadData = (LoadData) other;
            return Intrinsics.areEqual(this.url, loadData.url) && Intrinsics.areEqual(this.title, loadData.title) && Intrinsics.areEqual(this.poster, loadData.poster) && Intrinsics.areEqual(this.nation, loadData.nation) && Intrinsics.areEqual(this.key, loadData.key) && Intrinsics.areEqual(this.keyid, loadData.keyid) && Intrinsics.areEqual(this.userAgent, loadData.userAgent) && Intrinsics.areEqual(this.cookie, loadData.cookie) && Intrinsics.areEqual(this.licenseUrl, loadData.licenseUrl) && Intrinsics.areEqual(this.drmKeys, loadData.drmKeys) && Intrinsics.areEqual(this.headers, loadData.headers);
        }

        public int hashCode() {
            return (((((((((((((((((((this.url.hashCode() * 31) + this.title.hashCode()) * 31) + this.poster.hashCode()) * 31) + this.nation.hashCode()) * 31) + this.key.hashCode()) * 31) + this.keyid.hashCode()) * 31) + this.userAgent.hashCode()) * 31) + this.cookie.hashCode()) * 31) + this.licenseUrl.hashCode()) * 31) + this.drmKeys.hashCode()) * 31) + this.headers.hashCode();
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LoadData(url=").append(this.url).append(", title=").append(this.title).append(", poster=").append(this.poster).append(", nation=").append(this.nation).append(", key=").append(this.key).append(", keyid=").append(this.keyid).append(", userAgent=").append(this.userAgent).append(", cookie=").append(this.cookie).append(", licenseUrl=").append(this.licenseUrl).append(", drmKeys=").append(this.drmKeys).append(", headers=").append(this.headers).append(')');
            return sb.toString();
        }

        public LoadData(@NotNull String url, @NotNull String title, @NotNull String poster, @NotNull String nation, @NotNull String key, @NotNull String keyid, @NotNull String userAgent, @NotNull String cookie, @NotNull String licenseUrl, @NotNull Map<String, String> map, @NotNull Map<String, String> map2) {
            this.url = url;
            this.title = title;
            this.poster = poster;
            this.nation = nation;
            this.key = key;
            this.keyid = keyid;
            this.userAgent = userAgent;
            this.cookie = cookie;
            this.licenseUrl = licenseUrl;
            this.drmKeys = map;
            this.headers = map2;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ LoadData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            Map mapEmptyMap;
            if ((i & 512) == 0) {
                mapEmptyMap = map;
            } else {
                mapEmptyMap = MapsKt.emptyMap();
            }
            this(str, str2, str3, str4, str5, str6, str7, str8, str9, mapEmptyMap, map2);
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        public final String getNation() {
            return this.nation;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }

        @NotNull
        public final String getKeyid() {
            return this.keyid;
        }

        @NotNull
        public final String getUserAgent() {
            return this.userAgent;
        }

        @NotNull
        public final String getCookie() {
            return this.cookie;
        }

        @NotNull
        public final String getLicenseUrl() {
            return this.licenseUrl;
        }

        @NotNull
        public final Map<String, String> getDrmKeys() {
            return this.drmKeys;
        }

        @NotNull
        public final Map<String, String> getHeaders() {
            return this.headers;
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
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.LivXowProvider$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LivXowProvider.showSubscriptionPopupIfNeeded$lambda$0(ctx);
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
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setText("All CNCVerse extensions currently run with ads.\n\nSubscribe to remove ads from just ₹30/month.\n\nManage via Settings > Extensions > CNCVerse Cloudstream Repo > Subscription Manager.");
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.LivXowProvider$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LivXowProvider.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.LivXowProvider$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LivXowProvider.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
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
        boolean isTV;
        final Context ctx = context;
        if (ctx == null || telegramPopupShown) {
            return;
        }
        try {
            isTV = Globals.INSTANCE.isLayout(2);
        } catch (Exception e) {
            isTV = false;
        }
        if (isTV) {
            return;
        }
        SharedPreferences prefs = ctx.getSharedPreferences("cncverse_prefs", 0);
        if (prefs.getBoolean("telegram_popup_shown", false)) {
            telegramPopupShown = true;
            return;
        }
        telegramPopupShown = true;
        prefs.edit().putBoolean("telegram_popup_shown", true).apply();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.LivXowProvider$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                LivXowProvider.showTelegramPopup$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.LivXowProvider$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.LivXowProvider$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LivXowProvider.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
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
        boolean isTV;
        final Context ctx = context;
        if (ctx == null) {
            return;
        }
        try {
            isTV = Globals.INSTANCE.isLayout(2);
        } catch (Exception e) {
            isTV = false;
        }
        if (isTV) {
            return;
        }
        long now = System.currentTimeMillis();
        if (now - lastBrowserOpenMs < BROWSER_DEBOUNCE_MS) {
            return;
        }
        lastBrowserOpenMs = now;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.LivXowProvider$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                LivXowProvider.openInExternalBrowser$lambda$0(ctx, url);
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

    /* JADX WARN: Code duplicated, block: B:101:0x034b  */
    /* JADX WARN: Code duplicated, block: B:154:0x044b  */
    /* JADX WARN: Code duplicated, block: B:157:0x0452  */
    /* JADX WARN: Code duplicated, block: B:160:0x04cf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:161:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00351 c00351;
        Object obj;
        Object objDecodeFromString;
        Object objNewExtractorLink;
        String data2;
        Function1<? super SubtitleFile, Unit> function3;
        LoadData loadData;
        boolean isCasting2;
        Function1<? super ExtractorLink, Unit> function4;
        Object objNewExtractorLink2;
        String data3;
        Function1<? super SubtitleFile, Unit> function5;
        LoadData loadData2;
        boolean isCasting3;
        Function1<? super ExtractorLink, Unit> function6;
        Object objNewExtractorLink3;
        String data4;
        Function1<? super SubtitleFile, Unit> function7;
        LoadData loadData3;
        boolean isCasting4;
        Function1<? super ExtractorLink, Unit> function8;
        int i;
        Object objNewExtractorLink4;
        String data5;
        Function1<? super SubtitleFile, Unit> function9;
        LoadData loadData4;
        Function1<? super ExtractorLink, Unit> function10;
        String string;
        Function1<? super ExtractorLink, Unit> function11;
        Function1<? super SubtitleFile, Unit> function12;
        LoadData loadData5;
        Object obj2;
        Function1<? super ExtractorLink, Unit> function13;
        Object objNewDrmExtractorLink;
        Function1<? super ExtractorLink, Unit> function14;
        MatchGroupCollection groups;
        MatchGroup matchGroup;
        String normalizedKey;
        String normalizedKid;
        String mappedKey;
        String mpdKidHex;
        String playerKey;
        String playerKid;
        Object objNewDrmExtractorLink2;
        MatchGroupCollection groups2;
        MatchGroup matchGroup2;
        String value;
        String strReplace$default;
        Function1<? super ExtractorLink, Unit> function15 = function2;
        if (continuation instanceof C00351) {
            c00351 = (C00351) continuation;
            if ((c00351.label & Integer.MIN_VALUE) != 0) {
                c00351.label -= Integer.MIN_VALUE;
            } else {
                c00351 = new C00351(continuation);
            }
        } else {
            c00351 = new C00351(continuation);
        }
        C00351 c00352 = c00351;
        Object $result = c00352.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00352.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LivXowProvider $this$loadLinks_u24lambda_u240 = this;
                final Context _ctx = context;
                SharedPreferences _prefs = _ctx != null ? _ctx.getSharedPreferences("CNCVerseSubscription", 0) : null;
                String _mode = _prefs != null ? _prefs.getString("mode", "ads") : null;
                long _expiresAt = _prefs != null ? _prefs.getLong("expires_at", 0L) : 0L;
                long _nowSec = System.currentTimeMillis() / 1000;
                boolean _isSubscribed = Intrinsics.areEqual(_mode, "subscription") && (_expiresAt == 0 || _expiresAt > _nowSec);
                if (!_isSubscribed) {
                    if (Intrinsics.areEqual(_mode, "subscription") && _expiresAt > 0 && _expiresAt <= _nowSec) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.LivXowProvider$$ExternalSyntheticLambda5
                            @Override // java.lang.Runnable
                            public final void run() {
                                LivXowProvider.loadLinks$lambda$0$0(_ctx);
                            }
                        });
                    }
                    $this$loadLinks_u24lambda_u240.openInExternalBrowser(new String(Base64.decode(OMG10, 0), Charsets.UTF_8));
                }
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(LoadData.class);
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
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LoadData.class), (List) null, 2, (Object) null));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    break;
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<LoadData>() { // from class: com.cncverse.LivXowProvider$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<LoadData>() { // from class: com.cncverse.LivXowProvider$loadLinks$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<LoadData>() { // from class: com.cncverse.LivXowProvider$loadLinks$$inlined$parseJson$1
                    });
                }
                LoadData loadData6 = (LoadData) objDecodeFromString;
                if (!StringsKt.contains$default(loadData6.getUrl(), "mpd", false, 2, (Object) null)) {
                    if (StringsKt.contains$default(loadData6.getUrl(), "&e=.m3u", false, 2, (Object) null)) {
                        Map headers = new LinkedHashMap();
                        headers.putAll(loadData6.getHeaders());
                        if (loadData6.getUserAgent().length() > 0) {
                            headers.put("User-Agent", loadData6.getUserAgent());
                        }
                        if (loadData6.getCookie().length() > 0) {
                            headers.put("Cookie", loadData6.getCookie());
                        }
                        String name = getName();
                        String name2 = getName();
                        String url = loadData6.getUrl();
                        ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                        C00407 c00407 = new C00407(headers, null);
                        c00352.L$0 = SpillingKt.nullOutSpilledVariable(data);
                        c00352.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                        c00352.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                        c00352.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                        c00352.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                        c00352.L$5 = function15;
                        c00352.Z$0 = isCasting;
                        c00352.label = 5;
                        objNewExtractorLink3 = ExtractorApiKt.newExtractorLink(name, name2, url, extractorLinkType, c00407, c00352);
                        if (objNewExtractorLink3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        data4 = data;
                        function7 = function1;
                        loadData3 = loadData6;
                        isCasting4 = isCasting;
                        function8 = function15;
                        function8.invoke(objNewExtractorLink3);
                        return Boxing.boxBoolean(true);
                    }
                    if (StringsKt.contains$default(loadData6.getUrl(), "play.php?", false, 2, (Object) null)) {
                        Map headers2 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("User-Agent", loadData6.getUserAgent())});
                        headers2.putAll(loadData6.getHeaders());
                        if (loadData6.getCookie().length() > 0) {
                            headers2.put("Cookie", loadData6.getCookie());
                        }
                        String name3 = getName();
                        String name4 = getName();
                        String url2 = loadData6.getUrl();
                        ExtractorLinkType extractorLinkType2 = ExtractorLinkType.M3U8;
                        C00418 c00418 = new C00418(headers2, null);
                        c00352.L$0 = SpillingKt.nullOutSpilledVariable(data);
                        c00352.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                        c00352.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                        c00352.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                        c00352.L$4 = SpillingKt.nullOutSpilledVariable(headers2);
                        c00352.L$5 = function15;
                        c00352.Z$0 = isCasting;
                        c00352.label = 6;
                        objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name3, name4, url2, extractorLinkType2, c00418, c00352);
                        if (objNewExtractorLink2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        data3 = data;
                        function5 = function1;
                        loadData2 = loadData6;
                        isCasting3 = isCasting;
                        function6 = function15;
                        function6.invoke(objNewExtractorLink2);
                        return Boxing.boxBoolean(true);
                    }
                    Map headers3 = new LinkedHashMap();
                    headers3.putAll(loadData6.getHeaders());
                    if (loadData6.getUserAgent().length() > 0) {
                        headers3.put("User-Agent", loadData6.getUserAgent());
                    }
                    if (loadData6.getCookie().length() > 0) {
                        headers3.put("Cookie", loadData6.getCookie());
                    }
                    String name5 = getName();
                    String title = loadData6.getTitle();
                    String url3 = loadData6.getUrl();
                    ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                    C00429 c00429 = new C00429(headers3, null);
                    c00352.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00352.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00352.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                    c00352.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                    c00352.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                    c00352.L$5 = function15;
                    c00352.Z$0 = isCasting;
                    c00352.label = 7;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(name5, title, url3, infer_type, c00429, c00352);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    data2 = data;
                    function3 = function1;
                    loadData = loadData6;
                    isCasting2 = isCasting;
                    function4 = function15;
                    function4.invoke(objNewExtractorLink);
                    return Boxing.boxBoolean(true);
                }
                Map headers4 = new LinkedHashMap();
                headers4.putAll(loadData6.getHeaders());
                if (loadData6.getUserAgent().length() > 0) {
                    headers4.put("User-Agent", loadData6.getUserAgent());
                }
                if (loadData6.getCookie().length() > 0) {
                    headers4.put("Cookie", loadData6.getCookie());
                }
                if (!(loadData6.getKey().length() > 0)) {
                    i = 0;
                } else if (!(loadData6.getKeyid().length() > 0) || Intrinsics.areEqual(StringsKt.trim(loadData6.getKey()).toString(), "null") || Intrinsics.areEqual(StringsKt.trim(loadData6.getKeyid()).toString(), "null")) {
                    i = 0;
                } else {
                    i = 1;
                }
                int i2 = i;
                int i3 = (!(loadData6.getLicenseUrl().length() > 0) || Intrinsics.areEqual(StringsKt.trim(loadData6.getLicenseUrl()).toString(), "null")) ? 0 : 1;
                if (i2 != 0) {
                    String normalizedKey2 = base64ToHexOrNull(loadData6.getKey());
                    if (normalizedKey2 == null) {
                        normalizedKey2 = StringsKt.trim(loadData6.getKey()).toString();
                    }
                    String normalizedKid2 = base64ToHexOrNull(loadData6.getKeyid());
                    if (normalizedKid2 == null) {
                        normalizedKid2 = StringsKt.trim(loadData6.getKeyid()).toString();
                    }
                    if (!loadData6.getDrmKeys().isEmpty()) {
                        normalizedKey = normalizedKey2;
                        normalizedKid = normalizedKid2;
                        MatchResult matchResultFind$default = Regex.find$default(new Regex("cenc:default_KID=[\"']([0-9a-fA-F\\-]{36})[\"']"), getMpdStream(loadData6.getUrl(), headers4), 0, 2, (Object) null);
                        if (matchResultFind$default == null || (groups2 = matchResultFind$default.getGroups()) == null || (matchGroup2 = groups2.get(1)) == null || (value = matchGroup2.getValue()) == null || (strReplace$default = StringsKt.replace$default(value, "-", "", false, 4, (Object) null)) == null) {
                            mpdKidHex = null;
                        } else {
                            mpdKidHex = strReplace$default.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(mpdKidHex, "toLowerCase(...)");
                        }
                        String str = mpdKidHex;
                        if (!(str == null || str.length() == 0)) {
                            mappedKey = loadData6.getDrmKeys().get(mpdKidHex);
                            String str2 = mappedKey;
                            if (!(str2 == null || str2.length() == 0)) {
                            }
                        }
                        playerKey = hexToBase64UrlOrNull(mappedKey);
                        if (playerKey == null) {
                            playerKey = mappedKey;
                        }
                        playerKid = hexToBase64UrlOrNull(mpdKidHex);
                        if (playerKid == null) {
                            playerKid = mpdKidHex;
                        }
                        String name6 = getName();
                        String normalizedKey3 = mappedKey;
                        String normalizedKey4 = getName();
                        String playerKey2 = loadData6.getUrl();
                        ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                        UUID clearkey_uuid = ExtractorApiKt.getCLEARKEY_UUID();
                        String normalizedKid3 = mpdKidHex;
                        C00363 c00363 = new C00363(headers4, playerKey, playerKid, null);
                        c00352.L$0 = SpillingKt.nullOutSpilledVariable(data);
                        c00352.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                        c00352.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                        c00352.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                        c00352.L$4 = SpillingKt.nullOutSpilledVariable(headers4);
                        c00352.L$5 = SpillingKt.nullOutSpilledVariable(normalizedKey3);
                        c00352.L$6 = SpillingKt.nullOutSpilledVariable(normalizedKid3);
                        c00352.L$7 = SpillingKt.nullOutSpilledVariable(playerKey);
                        c00352.L$8 = SpillingKt.nullOutSpilledVariable(playerKid);
                        c00352.L$9 = function15;
                        c00352.Z$0 = isCasting;
                        c00352.I$0 = i2;
                        c00352.I$1 = i3;
                        c00352.label = 1;
                        objNewDrmExtractorLink2 = ExtractorApiKt.newDrmExtractorLink(name6, normalizedKey4, playerKey2, infer_type2, clearkey_uuid, c00363, c00352);
                        if (objNewDrmExtractorLink2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function15.invoke(objNewDrmExtractorLink2);
                        return Boxing.boxBoolean(true);
                    }
                    normalizedKey = normalizedKey2;
                    normalizedKid = normalizedKid2;
                    mappedKey = normalizedKey;
                    mpdKidHex = normalizedKid;
                    playerKey = hexToBase64UrlOrNull(mappedKey);
                    if (playerKey == null) {
                        playerKey = mappedKey;
                    }
                    playerKid = hexToBase64UrlOrNull(mpdKidHex);
                    if (playerKid == null) {
                        playerKid = mpdKidHex;
                    }
                    String name7 = getName();
                    String normalizedKey5 = mappedKey;
                    String normalizedKey6 = getName();
                    String playerKey3 = loadData6.getUrl();
                    ExtractorLinkType infer_type3 = ExtractorApiKt.getINFER_TYPE();
                    UUID clearkey_uuid2 = ExtractorApiKt.getCLEARKEY_UUID();
                    String normalizedKid4 = mpdKidHex;
                    C00363 c00364 = new C00363(headers4, playerKey, playerKid, null);
                    c00352.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00352.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00352.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                    c00352.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                    c00352.L$4 = SpillingKt.nullOutSpilledVariable(headers4);
                    c00352.L$5 = SpillingKt.nullOutSpilledVariable(normalizedKey5);
                    c00352.L$6 = SpillingKt.nullOutSpilledVariable(normalizedKid4);
                    c00352.L$7 = SpillingKt.nullOutSpilledVariable(playerKey);
                    c00352.L$8 = SpillingKt.nullOutSpilledVariable(playerKid);
                    c00352.L$9 = function15;
                    c00352.Z$0 = isCasting;
                    c00352.I$0 = i2;
                    c00352.I$1 = i3;
                    c00352.label = 1;
                    objNewDrmExtractorLink2 = ExtractorApiKt.newDrmExtractorLink(name7, normalizedKey6, playerKey3, infer_type3, clearkey_uuid2, c00364, c00352);
                    if (objNewDrmExtractorLink2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function15.invoke(objNewDrmExtractorLink2);
                    return Boxing.boxBoolean(true);
                }
                int i4 = i3;
                if (i4 == 0) {
                    String name8 = getName();
                    String name9 = getName();
                    String url4 = loadData6.getUrl();
                    ExtractorLinkType extractorLinkType3 = ExtractorLinkType.DASH;
                    C00396 c00396 = new C00396(headers4, null);
                    c00352.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00352.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00352.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                    c00352.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                    c00352.L$4 = SpillingKt.nullOutSpilledVariable(headers4);
                    c00352.L$5 = function15;
                    c00352.Z$0 = isCasting;
                    c00352.I$0 = i2;
                    c00352.I$1 = i4;
                    c00352.label = 4;
                    objNewExtractorLink4 = ExtractorApiKt.newExtractorLink(name8, name9, url4, extractorLinkType3, c00396, c00352);
                    if (objNewExtractorLink4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    data5 = data;
                    function9 = function1;
                    loadData4 = loadData6;
                    function10 = function15;
                    function15.invoke(objNewExtractorLink4);
                    return Boxing.boxBoolean(true);
                }
                String mpdStr = getMpdStream(loadData6.getUrl(), headers4);
                Regex regex = new Regex("cenc:default_KID=[\"']([0-9a-fA-F\\-]{36})[\"']");
                MatchResult matchResult = Regex.find$default(regex, mpdStr, 0, 2, (Object) null);
                if (matchResult == null || (groups = matchResult.getGroups()) == null || (matchGroup = groups.get(1)) == null || (string = matchGroup.getValue()) == null) {
                    string = UUID.randomUUID().toString();
                }
                String drmKid = string;
                Iterable $this$map$iv = StringsKt.chunked(StringsKt.replace$default(drmKid, "-", "", false, 4, (Object) null), 2);
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Regex regex2 = regex;
                    String it = (String) item$iv$iv;
                    destination$iv$iv.add(Boxing.boxByte((byte) Integer.parseInt(it, CharsKt.checkRadix(16))));
                    regex = regex2;
                    $this$map$iv = $this$map$iv;
                }
                Regex regex3 = regex;
                byte[] drmKidBytes = CollectionsKt.toByteArray((List) destination$iv$iv);
                String drmKidBase64 = Base64.encodeToString(drmKidBytes, 11);
                String keyBase64 = getDRMKeysFromLicenseServer(loadData6.getLicenseUrl(), drmKidBase64);
                if (keyBase64.length() > 0) {
                    String name10 = getName();
                    String drmKidBase65 = getName();
                    String keyBase65 = loadData6.getUrl();
                    ExtractorLinkType infer_type4 = ExtractorApiKt.getINFER_TYPE();
                    UUID clearkey_uuid3 = ExtractorApiKt.getCLEARKEY_UUID();
                    C00374 c00374 = new C00374(headers4, keyBase64, drmKidBase64, null);
                    c00352.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00352.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00352.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                    c00352.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                    c00352.L$4 = SpillingKt.nullOutSpilledVariable(headers4);
                    c00352.L$5 = SpillingKt.nullOutSpilledVariable(mpdStr);
                    c00352.L$6 = SpillingKt.nullOutSpilledVariable(regex3);
                    c00352.L$7 = SpillingKt.nullOutSpilledVariable(matchResult);
                    c00352.L$8 = SpillingKt.nullOutSpilledVariable(drmKid);
                    c00352.L$9 = SpillingKt.nullOutSpilledVariable(drmKidBytes);
                    c00352.L$10 = SpillingKt.nullOutSpilledVariable(drmKidBase64);
                    c00352.L$11 = SpillingKt.nullOutSpilledVariable(keyBase64);
                    c00352.L$12 = function15;
                    c00352.Z$0 = isCasting;
                    c00352.I$0 = i2;
                    c00352.I$1 = i4;
                    c00352.label = 2;
                    objNewDrmExtractorLink = ExtractorApiKt.newDrmExtractorLink(name10, drmKidBase65, keyBase65, infer_type4, clearkey_uuid3, c00374, c00352);
                    if (objNewDrmExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function14 = function15;
                    function14.invoke(objNewDrmExtractorLink);
                    return Boxing.boxBoolean(true);
                }
                String name11 = getName();
                String name12 = getName();
                String url5 = loadData6.getUrl();
                ExtractorLinkType infer_type5 = ExtractorApiKt.getINFER_TYPE();
                UUID clearkey_uuid4 = ExtractorApiKt.getCLEARKEY_UUID();
                C00385 c00385 = new C00385(headers4, loadData6, null);
                c00352.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00352.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00352.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                c00352.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                c00352.L$4 = SpillingKt.nullOutSpilledVariable(headers4);
                c00352.L$5 = SpillingKt.nullOutSpilledVariable(mpdStr);
                c00352.L$6 = SpillingKt.nullOutSpilledVariable(regex3);
                c00352.L$7 = SpillingKt.nullOutSpilledVariable(matchResult);
                c00352.L$8 = SpillingKt.nullOutSpilledVariable(drmKid);
                c00352.L$9 = SpillingKt.nullOutSpilledVariable(drmKidBytes);
                c00352.L$10 = SpillingKt.nullOutSpilledVariable(drmKidBase64);
                c00352.L$11 = SpillingKt.nullOutSpilledVariable(keyBase64);
                c00352.L$12 = function15;
                c00352.Z$0 = isCasting;
                c00352.I$0 = i2;
                c00352.I$1 = i4;
                c00352.label = 3;
                Object objNewDrmExtractorLink3 = ExtractorApiKt.newDrmExtractorLink(name11, name12, url5, infer_type5, clearkey_uuid4, c00385, c00352);
                if (objNewDrmExtractorLink3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function11 = function15;
                function12 = function1;
                loadData5 = loadData6;
                obj2 = objNewDrmExtractorLink3;
                function13 = function11;
                function11.invoke(obj2);
                return Boxing.boxBoolean(true);
            case 1:
                int i5 = c00352.I$1;
                int i6 = c00352.I$0;
                boolean z = c00352.Z$0;
                Function1<? super ExtractorLink, Unit> function16 = (Function1) c00352.L$9;
                ResultKt.throwOnFailure($result);
                function15 = function16;
                objNewDrmExtractorLink2 = $result;
                function15.invoke(objNewDrmExtractorLink2);
                return Boxing.boxBoolean(true);
            case 2:
                int i7 = c00352.I$1;
                int i8 = c00352.I$0;
                boolean z2 = c00352.Z$0;
                function14 = (Function1) c00352.L$12;
                ResultKt.throwOnFailure($result);
                objNewDrmExtractorLink = $result;
                function14.invoke(objNewDrmExtractorLink);
                return Boxing.boxBoolean(true);
            case 3:
                int i9 = c00352.I$1;
                int i10 = c00352.I$0;
                boolean z3 = c00352.Z$0;
                function11 = (Function1) c00352.L$12;
                loadData5 = (LoadData) c00352.L$3;
                Function1<? super ExtractorLink, Unit> function17 = (Function1) c00352.L$2;
                function12 = (Function1) c00352.L$1;
                ResultKt.throwOnFailure($result);
                function13 = function17;
                obj2 = $result;
                function11.invoke(obj2);
                return Boxing.boxBoolean(true);
            case 4:
                int i11 = c00352.I$1;
                int i12 = c00352.I$0;
                boolean z4 = c00352.Z$0;
                Function1<? super ExtractorLink, Unit> function18 = (Function1) c00352.L$5;
                loadData4 = (LoadData) c00352.L$3;
                Function1<? super ExtractorLink, Unit> function19 = (Function1) c00352.L$2;
                function9 = (Function1) c00352.L$1;
                data5 = (String) c00352.L$0;
                ResultKt.throwOnFailure($result);
                function10 = function19;
                function15 = function18;
                objNewExtractorLink4 = $result;
                function15.invoke(objNewExtractorLink4);
                return Boxing.boxBoolean(true);
            case 5:
                isCasting4 = c00352.Z$0;
                function8 = (Function1) c00352.L$5;
                loadData3 = (LoadData) c00352.L$3;
                function15 = (Function1) c00352.L$2;
                function7 = (Function1) c00352.L$1;
                data4 = (String) c00352.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink3 = $result;
                function8.invoke(objNewExtractorLink3);
                return Boxing.boxBoolean(true);
            case 6:
                isCasting3 = c00352.Z$0;
                function6 = (Function1) c00352.L$5;
                loadData2 = (LoadData) c00352.L$3;
                function15 = (Function1) c00352.L$2;
                function5 = (Function1) c00352.L$1;
                data3 = (String) c00352.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink2 = $result;
                function6.invoke(objNewExtractorLink2);
                return Boxing.boxBoolean(true);
            case 7:
                isCasting2 = c00352.Z$0;
                function4 = (Function1) c00352.L$5;
                loadData = (LoadData) c00352.L$3;
                function15 = (Function1) c00352.L$2;
                function3 = (Function1) c00352.L$1;
                data2 = (String) c00352.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function4.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowProvider$loadLinks$3 */
    /* JADX INFO: compiled from: LivXowProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/DrmExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProvider$loadLinks$3", f = "LivXowProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00363 extends SuspendLambda implements Function2<DrmExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        final /* synthetic */ String $playerKey;
        final /* synthetic */ String $playerKid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00363(Map<String, String> map, String str, String str2, Continuation<? super C00363> continuation) {
            super(2, continuation);
            this.$headers = map;
            this.$playerKey = str;
            this.$playerKid = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00363 = new C00363(this.$headers, this.$playerKey, this.$playerKid, continuation);
            c00363.L$0 = obj;
            return c00363;
        }

        public final Object invoke(DrmExtractorLink drmExtractorLink, Continuation<? super Unit> continuation) {
            return create(drmExtractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            DrmExtractorLink $this$newDrmExtractorLink = (DrmExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newDrmExtractorLink.setQuality(Qualities.Unknown.getValue());
                    if (!this.$headers.isEmpty()) {
                        $this$newDrmExtractorLink.setHeaders(this.$headers);
                    }
                    $this$newDrmExtractorLink.setKey(this.$playerKey);
                    $this$newDrmExtractorLink.setKid(this.$playerKid);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowProvider$loadLinks$4 */
    /* JADX INFO: compiled from: LivXowProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/DrmExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProvider$loadLinks$4", f = "LivXowProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00374 extends SuspendLambda implements Function2<DrmExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $drmKidBase64;
        final /* synthetic */ Map<String, String> $headers;
        final /* synthetic */ String $keyBase64;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00374(Map<String, String> map, String str, String str2, Continuation<? super C00374> continuation) {
            super(2, continuation);
            this.$headers = map;
            this.$keyBase64 = str;
            this.$drmKidBase64 = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00374 = new C00374(this.$headers, this.$keyBase64, this.$drmKidBase64, continuation);
            c00374.L$0 = obj;
            return c00374;
        }

        public final Object invoke(DrmExtractorLink drmExtractorLink, Continuation<? super Unit> continuation) {
            return create(drmExtractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            DrmExtractorLink $this$newDrmExtractorLink = (DrmExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newDrmExtractorLink.setQuality(Qualities.Unknown.getValue());
                    if (!this.$headers.isEmpty()) {
                        $this$newDrmExtractorLink.setHeaders(this.$headers);
                    }
                    $this$newDrmExtractorLink.setKey(StringsKt.trim(this.$keyBase64).toString());
                    $this$newDrmExtractorLink.setKid(StringsKt.trim(this.$drmKidBase64).toString());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowProvider$loadLinks$5 */
    /* JADX INFO: compiled from: LivXowProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/DrmExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProvider$loadLinks$5", f = "LivXowProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00385 extends SuspendLambda implements Function2<DrmExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        final /* synthetic */ LoadData $loadData;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00385(Map<String, String> map, LoadData loadData, Continuation<? super C00385> continuation) {
            super(2, continuation);
            this.$headers = map;
            this.$loadData = loadData;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00385 = new C00385(this.$headers, this.$loadData, continuation);
            c00385.L$0 = obj;
            return c00385;
        }

        public final Object invoke(DrmExtractorLink drmExtractorLink, Continuation<? super Unit> continuation) {
            return create(drmExtractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            DrmExtractorLink $this$newDrmExtractorLink = (DrmExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newDrmExtractorLink.setQuality(Qualities.Unknown.getValue());
                    if (!this.$headers.isEmpty()) {
                        $this$newDrmExtractorLink.setHeaders(this.$headers);
                    }
                    $this$newDrmExtractorLink.setLicenseUrl(StringsKt.trim(this.$loadData.getLicenseUrl()).toString());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowProvider$loadLinks$6 */
    /* JADX INFO: compiled from: LivXowProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProvider$loadLinks$6", f = "LivXowProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00396 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00396(Map<String, String> map, Continuation<? super C00396> continuation) {
            super(2, continuation);
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00396 = new C00396(this.$headers, continuation);
            c00396.L$0 = obj;
            return c00396;
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
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    if (!this.$headers.isEmpty()) {
                        $this$newExtractorLink.setHeaders(this.$headers);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowProvider$loadLinks$7 */
    /* JADX INFO: compiled from: LivXowProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProvider$loadLinks$7", f = "LivXowProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00407 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00407(Map<String, String> map, Continuation<? super C00407> continuation) {
            super(2, continuation);
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00407 = new C00407(this.$headers, continuation);
            c00407.L$0 = obj;
            return c00407;
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
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    if (!this.$headers.isEmpty()) {
                        $this$newExtractorLink.setHeaders(this.$headers);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowProvider$loadLinks$8 */
    /* JADX INFO: compiled from: LivXowProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProvider$loadLinks$8", f = "LivXowProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00418 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00418(Map<String, String> map, Continuation<? super C00418> continuation) {
            super(2, continuation);
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00418 = new C00418(this.$headers, continuation);
            c00418.L$0 = obj;
            return c00418;
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
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    $this$newExtractorLink.setHeaders(this.$headers);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowProvider$loadLinks$9 */
    /* JADX INFO: compiled from: LivXowProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProvider$loadLinks$9", f = "LivXowProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00429 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00429(Map<String, String> map, Continuation<? super C00429> continuation) {
            super(2, continuation);
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00429 = new C00429(this.$headers, continuation);
            c00429.L$0 = obj;
            return c00429;
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
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    if (!this.$headers.isEmpty()) {
                        $this$newExtractorLink.setHeaders(this.$headers);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
