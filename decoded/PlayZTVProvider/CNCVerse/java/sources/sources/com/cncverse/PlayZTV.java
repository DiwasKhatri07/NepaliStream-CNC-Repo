package com.cncverse;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
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

/* JADX INFO: compiled from: PlayZTV.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/PlayZTVProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 G2\u00020\u0001:\u0002GHB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\u0004\u0018\u00010\u0003*\u00020\u0003H\u0002J\u000e\u0010)\u001a\u0004\u0018\u00010\u0003*\u00020\u0003H\u0002J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003H\u0002J$\u0010,\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001eH\u0002J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0003H\u0002J\u001e\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u00106J\u001c\u00107\u001a\b\u0012\u0004\u0012\u000209082\u0006\u0010:\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010'J\u0016\u0010;\u001a\u00020<2\u0006\u0010&\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010'JF\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00132\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C0A2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020C0AH\u0096@¢\u0006\u0002\u0010FR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"¨\u0006I"}, d2 = {"Lcom/cncverse/PlayZTV;", "Lcom/lagradost/cloudstream3/MainAPI;", "customName", "", "customMainUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "lang", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "hasChromecastSupport", "getHasChromecastSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "headers", "", "customHttpClient", "Lokhttp3/OkHttpClient;", "getCustomHttpClient", "()Lokhttp3/OkHttpClient;", "customHttpClient$delegate", "Lkotlin/Lazy;", "getWithCustomHeaders", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base64ToHexOrNull", "hexToBase64UrlOrNull", "decryptContent", "content", "getMpdStream", "customHeaders", "getDRMKeysFromLicenseServer", "kid", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "LoadData", "PlayZTVProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlayZTV.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayZTV.kt\ncom/cncverse/PlayZTV\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 6 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 7 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1167:1\n296#2,2:1168\n1586#2:1170\n1661#2,3:1171\n1642#2,10:1193\n1915#2:1203\n1916#2:1224\n1652#2:1225\n777#2:1226\n873#2,2:1227\n1924#2,3:1229\n296#2,2:1251\n1512#2:1253\n1538#2,3:1254\n1541#2,3:1264\n1586#2:1270\n1661#2,3:1271\n777#2:1275\n873#2,2:1276\n1586#2:1278\n1661#2,3:1279\n1586#2:1320\n1661#2,3:1321\n63#3:1174\n64#3,15:1176\n63#3:1204\n64#3,15:1206\n63#3:1232\n64#3,15:1234\n63#3:1282\n64#3,15:1284\n63#3:1301\n64#3,15:1303\n1#4:1175\n1#4:1205\n1#4:1223\n1#4:1233\n1#4:1283\n1#4:1302\n50#5:1191\n43#5:1192\n50#5:1221\n43#5:1222\n50#5:1249\n43#5:1250\n50#5:1299\n43#5:1300\n50#5:1318\n43#5:1319\n383#6,7:1257\n129#7:1267\n158#7,2:1268\n160#7:1274\n*S KotlinDebug\n*F\n+ 1 PlayZTV.kt\ncom/cncverse/PlayZTV\n*L\n131#1:1168,2\n187#1:1170\n187#1:1171,3\n212#1:1193,10\n212#1:1203\n212#1:1224\n212#1:1225\n216#1:1226\n216#1:1227,2\n225#1:1229,3\n318#1:1251,2\n333#1:1253\n333#1:1254,3\n333#1:1264,3\n335#1:1270\n335#1:1271,3\n365#1:1275\n365#1:1276,2\n365#1:1278\n365#1:1279,3\n485#1:1320\n485#1:1321,3\n211#1:1174\n211#1:1176,15\n214#1:1204\n214#1:1206,15\n315#1:1232\n315#1:1234,15\n385#1:1282\n385#1:1284,15\n411#1:1301\n411#1:1303,15\n211#1:1175\n214#1:1205\n212#1:1223\n315#1:1233\n385#1:1283\n411#1:1302\n211#1:1191\n211#1:1192\n214#1:1221\n214#1:1222\n315#1:1249\n315#1:1250\n385#1:1299\n385#1:1300\n411#1:1318\n411#1:1319\n333#1:1257,7\n333#1:1267\n333#1:1268,2\n333#1:1274\n*E\n"})
public final class PlayZTV extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EXT_INF = "#EXTINF";

    @NotNull
    public static final String EXT_M3U = "#EXTM3U";

    @NotNull
    public static final String EXT_VLC_OPT = "#EXTVLCOPT";

    @Nullable
    private static Context context;
    private static volatile boolean csGuardWasEverActive;

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

    /* JADX INFO: renamed from: com.cncverse.PlayZTV$getMainPage$1 */
    /* JADX INFO: compiled from: PlayZTV.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTV", f = "PlayZTV.kt", i = {0, 0}, l = {330}, m = "getMainPage", n = {"request", "page"}, nl = {331}, s = {"L$0", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
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
            return PlayZTV.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayZTV$loadLinks$1 */
    /* JADX INFO: compiled from: PlayZTV.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTV", f = "PlayZTV.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, l = {457, 496, 516, 534, 560, 583, 607}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "loadData", "headers", "normalizedKey", "normalizedKid", "playerKey", "playerKid", "isCasting", "hasValidKeys", "hasLicenseUrl", "data", "subtitleCallback", "callback", "loadData", "headers", "mpdStr", "regex", "matchResult", "drmKid", "drmKidBytes", "drmKidBase64", "keyBase64", "isCasting", "hasValidKeys", "hasLicenseUrl", "data", "subtitleCallback", "callback", "loadData", "headers", "mpdStr", "regex", "matchResult", "drmKid", "drmKidBytes", "drmKidBase64", "keyBase64", "isCasting", "hasValidKeys", "hasLicenseUrl", "data", "subtitleCallback", "callback", "loadData", "headers", "isCasting", "hasValidKeys", "hasLicenseUrl", "data", "subtitleCallback", "callback", "loadData", "headers", "isCasting", "data", "subtitleCallback", "callback", "loadData", "headers", "isCasting", "data", "subtitleCallback", "callback", "loadData", "headers", "isCasting"}, nl = {456, 495, 515, 533, 559, 582, 606}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
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

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayZTV.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayZTV$search$1 */
    /* JADX INFO: compiled from: PlayZTV.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTV", f = "PlayZTV.kt", i = {0}, l = {362}, m = "search", n = {"query"}, nl = {363}, s = {"L$0"}, v = 2)
    static final class C00111 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00111(Continuation<? super C00111> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayZTV.this.search(null, (Continuation) this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PlayZTV() {
        String str = null;
        this(str, str, 3, str);
    }

    public PlayZTV(@NotNull String customName, @NotNull String customMainUrl) {
        this.customName = customName;
        this.customMainUrl = customMainUrl;
        this.lang = "ta";
        this.mainUrl = this.customMainUrl;
        this.name = this.customName;
        this.hasMainPage = true;
        this.hasChromecastSupport = true;
        this.supportedTypes = SetsKt.setOf(TvType.Live);
        this.headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("accept", "*/*"), TuplesKt.to("Cache-Control", "no-cache, no-store"), TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; rv:78.0) Gecko/20100101 Firefox/78.0")});
        this.customHttpClient = LazyKt.lazy(new Function0() { // from class: com.cncverse.PlayZTV$$ExternalSyntheticLambda3
            public final Object invoke() {
                return PlayZTV.customHttpClient_delegate$lambda$0(this.f$0);
            }
        });
    }

    public /* synthetic */ PlayZTV(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "IPTV Player" : str, (i & 2) != 0 ? "https://fifabd.site/OPLLX7/LIVE2.m3u" : str2);
    }

    /* JADX INFO: compiled from: PlayZTV.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/cncverse/PlayZTV$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "EXT_M3U", "", "EXT_INF", "EXT_VLC_OPT", "PlayZTVProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPlayZTV.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayZTV.kt\ncom/cncverse/PlayZTV$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1167:1\n1#2:1168\n*E\n"})
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
                PlayZTV.csGuardWasEverActive = true;
            }
            return PlayZTV.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.PlayZTV$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PlayZTV.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getContext() {
            return PlayZTV.context;
        }

        public final void setContext(@Nullable Context context) {
            PlayZTV.context = context;
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
    public static final OkHttpClient customHttpClient_delegate$lambda$0(PlayZTV this$0) {
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
            return ArraysKt.joinToString$default(decoded, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.cncverse.PlayZTV$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return PlayZTV.base64ToHexOrNull$lambda$1(((Byte) obj).byteValue());
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

    /* JADX WARN: Code duplicated, block: B:106:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:112:0x020f A[Catch: Exception -> 0x039c, TryCatch #11 {Exception -> 0x039c, blocks: (B:27:0x0063, B:33:0x0095, B:40:0x00c2, B:43:0x00c9, B:53:0x00ff, B:54:0x0117, B:56:0x011d, B:107:0x01e9, B:109:0x01f2, B:110:0x0209, B:112:0x020f, B:114:0x0225, B:116:0x022d, B:125:0x023e, B:126:0x0242, B:128:0x0251, B:129:0x025c, B:131:0x0262, B:133:0x026e, B:136:0x027c, B:140:0x0285, B:142:0x028b, B:149:0x02af, B:150:0x02bc, B:152:0x02c2, B:154:0x02ca, B:155:0x02cd, B:160:0x02f2, B:163:0x02ff, B:166:0x0309, B:171:0x0342, B:167:0x031a, B:169:0x0321, B:144:0x02a3, B:148:0x02ab, B:175:0x038e, B:52:0x00e6, B:51:0x00e0, B:39:0x00b7, B:32:0x008b, B:29:0x0068, B:36:0x009c, B:46:0x00cf), top: B:202:0x0063, inners: #3, #12, #15 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0225 A[Catch: Exception -> 0x039c, TryCatch #11 {Exception -> 0x039c, blocks: (B:27:0x0063, B:33:0x0095, B:40:0x00c2, B:43:0x00c9, B:53:0x00ff, B:54:0x0117, B:56:0x011d, B:107:0x01e9, B:109:0x01f2, B:110:0x0209, B:112:0x020f, B:114:0x0225, B:116:0x022d, B:125:0x023e, B:126:0x0242, B:128:0x0251, B:129:0x025c, B:131:0x0262, B:133:0x026e, B:136:0x027c, B:140:0x0285, B:142:0x028b, B:149:0x02af, B:150:0x02bc, B:152:0x02c2, B:154:0x02ca, B:155:0x02cd, B:160:0x02f2, B:163:0x02ff, B:166:0x0309, B:171:0x0342, B:167:0x031a, B:169:0x0321, B:144:0x02a3, B:148:0x02ab, B:175:0x038e, B:52:0x00e6, B:51:0x00e0, B:39:0x00b7, B:32:0x008b, B:29:0x0068, B:36:0x009c, B:46:0x00cf), top: B:202:0x0063, inners: #3, #12, #15 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x0236  */
    /* JADX WARN: Code duplicated, block: B:122:0x0239  */
    /* JADX WARN: Code duplicated, block: B:123:0x023b  */
    /* JADX WARN: Code duplicated, block: B:128:0x0251 A[Catch: Exception -> 0x039c, TryCatch #11 {Exception -> 0x039c, blocks: (B:27:0x0063, B:33:0x0095, B:40:0x00c2, B:43:0x00c9, B:53:0x00ff, B:54:0x0117, B:56:0x011d, B:107:0x01e9, B:109:0x01f2, B:110:0x0209, B:112:0x020f, B:114:0x0225, B:116:0x022d, B:125:0x023e, B:126:0x0242, B:128:0x0251, B:129:0x025c, B:131:0x0262, B:133:0x026e, B:136:0x027c, B:140:0x0285, B:142:0x028b, B:149:0x02af, B:150:0x02bc, B:152:0x02c2, B:154:0x02ca, B:155:0x02cd, B:160:0x02f2, B:163:0x02ff, B:166:0x0309, B:171:0x0342, B:167:0x031a, B:169:0x0321, B:144:0x02a3, B:148:0x02ab, B:175:0x038e, B:52:0x00e6, B:51:0x00e0, B:39:0x00b7, B:32:0x008b, B:29:0x0068, B:36:0x009c, B:46:0x00cf), top: B:202:0x0063, inners: #3, #12, #15 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x0262 A[Catch: Exception -> 0x039c, TryCatch #11 {Exception -> 0x039c, blocks: (B:27:0x0063, B:33:0x0095, B:40:0x00c2, B:43:0x00c9, B:53:0x00ff, B:54:0x0117, B:56:0x011d, B:107:0x01e9, B:109:0x01f2, B:110:0x0209, B:112:0x020f, B:114:0x0225, B:116:0x022d, B:125:0x023e, B:126:0x0242, B:128:0x0251, B:129:0x025c, B:131:0x0262, B:133:0x026e, B:136:0x027c, B:140:0x0285, B:142:0x028b, B:149:0x02af, B:150:0x02bc, B:152:0x02c2, B:154:0x02ca, B:155:0x02cd, B:160:0x02f2, B:163:0x02ff, B:166:0x0309, B:171:0x0342, B:167:0x031a, B:169:0x0321, B:144:0x02a3, B:148:0x02ab, B:175:0x038e, B:52:0x00e6, B:51:0x00e0, B:39:0x00b7, B:32:0x008b, B:29:0x0068, B:36:0x009c, B:46:0x00cf), top: B:202:0x0063, inners: #3, #12, #15 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x027a  */
    /* JADX WARN: Code duplicated, block: B:139:0x0284  */
    /* JADX WARN: Code duplicated, block: B:144:0x02a3 A[Catch: Exception -> 0x039c, TryCatch #11 {Exception -> 0x039c, blocks: (B:27:0x0063, B:33:0x0095, B:40:0x00c2, B:43:0x00c9, B:53:0x00ff, B:54:0x0117, B:56:0x011d, B:107:0x01e9, B:109:0x01f2, B:110:0x0209, B:112:0x020f, B:114:0x0225, B:116:0x022d, B:125:0x023e, B:126:0x0242, B:128:0x0251, B:129:0x025c, B:131:0x0262, B:133:0x026e, B:136:0x027c, B:140:0x0285, B:142:0x028b, B:149:0x02af, B:150:0x02bc, B:152:0x02c2, B:154:0x02ca, B:155:0x02cd, B:160:0x02f2, B:163:0x02ff, B:166:0x0309, B:171:0x0342, B:167:0x031a, B:169:0x0321, B:144:0x02a3, B:148:0x02ab, B:175:0x038e, B:52:0x00e6, B:51:0x00e0, B:39:0x00b7, B:32:0x008b, B:29:0x0068, B:36:0x009c, B:46:0x00cf), top: B:202:0x0063, inners: #3, #12, #15 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:147:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:152:0x02c2 A[Catch: Exception -> 0x039c, TryCatch #11 {Exception -> 0x039c, blocks: (B:27:0x0063, B:33:0x0095, B:40:0x00c2, B:43:0x00c9, B:53:0x00ff, B:54:0x0117, B:56:0x011d, B:107:0x01e9, B:109:0x01f2, B:110:0x0209, B:112:0x020f, B:114:0x0225, B:116:0x022d, B:125:0x023e, B:126:0x0242, B:128:0x0251, B:129:0x025c, B:131:0x0262, B:133:0x026e, B:136:0x027c, B:140:0x0285, B:142:0x028b, B:149:0x02af, B:150:0x02bc, B:152:0x02c2, B:154:0x02ca, B:155:0x02cd, B:160:0x02f2, B:163:0x02ff, B:166:0x0309, B:171:0x0342, B:167:0x031a, B:169:0x0321, B:144:0x02a3, B:148:0x02ab, B:175:0x038e, B:52:0x00e6, B:51:0x00e0, B:39:0x00b7, B:32:0x008b, B:29:0x0068, B:36:0x009c, B:46:0x00cf), top: B:202:0x0063, inners: #3, #12, #15 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x02ca A[Catch: Exception -> 0x039c, TryCatch #11 {Exception -> 0x039c, blocks: (B:27:0x0063, B:33:0x0095, B:40:0x00c2, B:43:0x00c9, B:53:0x00ff, B:54:0x0117, B:56:0x011d, B:107:0x01e9, B:109:0x01f2, B:110:0x0209, B:112:0x020f, B:114:0x0225, B:116:0x022d, B:125:0x023e, B:126:0x0242, B:128:0x0251, B:129:0x025c, B:131:0x0262, B:133:0x026e, B:136:0x027c, B:140:0x0285, B:142:0x028b, B:149:0x02af, B:150:0x02bc, B:152:0x02c2, B:154:0x02ca, B:155:0x02cd, B:160:0x02f2, B:163:0x02ff, B:166:0x0309, B:171:0x0342, B:167:0x031a, B:169:0x0321, B:144:0x02a3, B:148:0x02ab, B:175:0x038e, B:52:0x00e6, B:51:0x00e0, B:39:0x00b7, B:32:0x008b, B:29:0x0068, B:36:0x009c, B:46:0x00cf), top: B:202:0x0063, inners: #3, #12, #15 }] */
    /* JADX WARN: Code duplicated, block: B:157:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:158:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:160:0x02f2 A[Catch: Exception -> 0x039c, TryCatch #11 {Exception -> 0x039c, blocks: (B:27:0x0063, B:33:0x0095, B:40:0x00c2, B:43:0x00c9, B:53:0x00ff, B:54:0x0117, B:56:0x011d, B:107:0x01e9, B:109:0x01f2, B:110:0x0209, B:112:0x020f, B:114:0x0225, B:116:0x022d, B:125:0x023e, B:126:0x0242, B:128:0x0251, B:129:0x025c, B:131:0x0262, B:133:0x026e, B:136:0x027c, B:140:0x0285, B:142:0x028b, B:149:0x02af, B:150:0x02bc, B:152:0x02c2, B:154:0x02ca, B:155:0x02cd, B:160:0x02f2, B:163:0x02ff, B:166:0x0309, B:171:0x0342, B:167:0x031a, B:169:0x0321, B:144:0x02a3, B:148:0x02ab, B:175:0x038e, B:52:0x00e6, B:51:0x00e0, B:39:0x00b7, B:32:0x008b, B:29:0x0068, B:36:0x009c, B:46:0x00cf), top: B:202:0x0063, inners: #3, #12, #15 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x02fd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:163:0x02ff A[Catch: Exception -> 0x039c, TryCatch #11 {Exception -> 0x039c, blocks: (B:27:0x0063, B:33:0x0095, B:40:0x00c2, B:43:0x00c9, B:53:0x00ff, B:54:0x0117, B:56:0x011d, B:107:0x01e9, B:109:0x01f2, B:110:0x0209, B:112:0x020f, B:114:0x0225, B:116:0x022d, B:125:0x023e, B:126:0x0242, B:128:0x0251, B:129:0x025c, B:131:0x0262, B:133:0x026e, B:136:0x027c, B:140:0x0285, B:142:0x028b, B:149:0x02af, B:150:0x02bc, B:152:0x02c2, B:154:0x02ca, B:155:0x02cd, B:160:0x02f2, B:163:0x02ff, B:166:0x0309, B:171:0x0342, B:167:0x031a, B:169:0x0321, B:144:0x02a3, B:148:0x02ab, B:175:0x038e, B:52:0x00e6, B:51:0x00e0, B:39:0x00b7, B:32:0x008b, B:29:0x0068, B:36:0x009c, B:46:0x00cf), top: B:202:0x0063, inners: #3, #12, #15 }] */
    /* JADX WARN: Code duplicated, block: B:164:0x0306  */
    /* JADX WARN: Code duplicated, block: B:166:0x0309 A[Catch: Exception -> 0x039c, TryCatch #11 {Exception -> 0x039c, blocks: (B:27:0x0063, B:33:0x0095, B:40:0x00c2, B:43:0x00c9, B:53:0x00ff, B:54:0x0117, B:56:0x011d, B:107:0x01e9, B:109:0x01f2, B:110:0x0209, B:112:0x020f, B:114:0x0225, B:116:0x022d, B:125:0x023e, B:126:0x0242, B:128:0x0251, B:129:0x025c, B:131:0x0262, B:133:0x026e, B:136:0x027c, B:140:0x0285, B:142:0x028b, B:149:0x02af, B:150:0x02bc, B:152:0x02c2, B:154:0x02ca, B:155:0x02cd, B:160:0x02f2, B:163:0x02ff, B:166:0x0309, B:171:0x0342, B:167:0x031a, B:169:0x0321, B:144:0x02a3, B:148:0x02ab, B:175:0x038e, B:52:0x00e6, B:51:0x00e0, B:39:0x00b7, B:32:0x008b, B:29:0x0068, B:36:0x009c, B:46:0x00cf), top: B:202:0x0063, inners: #3, #12, #15 }] */
    /* JADX WARN: Code duplicated, block: B:167:0x031a A[Catch: Exception -> 0x039c, TryCatch #11 {Exception -> 0x039c, blocks: (B:27:0x0063, B:33:0x0095, B:40:0x00c2, B:43:0x00c9, B:53:0x00ff, B:54:0x0117, B:56:0x011d, B:107:0x01e9, B:109:0x01f2, B:110:0x0209, B:112:0x020f, B:114:0x0225, B:116:0x022d, B:125:0x023e, B:126:0x0242, B:128:0x0251, B:129:0x025c, B:131:0x0262, B:133:0x026e, B:136:0x027c, B:140:0x0285, B:142:0x028b, B:149:0x02af, B:150:0x02bc, B:152:0x02c2, B:154:0x02ca, B:155:0x02cd, B:160:0x02f2, B:163:0x02ff, B:166:0x0309, B:171:0x0342, B:167:0x031a, B:169:0x0321, B:144:0x02a3, B:148:0x02ab, B:175:0x038e, B:52:0x00e6, B:51:0x00e0, B:39:0x00b7, B:32:0x008b, B:29:0x0068, B:36:0x009c, B:46:0x00cf), top: B:202:0x0063, inners: #3, #12, #15 }] */
    /* JADX WARN: Code duplicated, block: B:169:0x0321 A[Catch: Exception -> 0x039c, TryCatch #11 {Exception -> 0x039c, blocks: (B:27:0x0063, B:33:0x0095, B:40:0x00c2, B:43:0x00c9, B:53:0x00ff, B:54:0x0117, B:56:0x011d, B:107:0x01e9, B:109:0x01f2, B:110:0x0209, B:112:0x020f, B:114:0x0225, B:116:0x022d, B:125:0x023e, B:126:0x0242, B:128:0x0251, B:129:0x025c, B:131:0x0262, B:133:0x026e, B:136:0x027c, B:140:0x0285, B:142:0x028b, B:149:0x02af, B:150:0x02bc, B:152:0x02c2, B:154:0x02ca, B:155:0x02cd, B:160:0x02f2, B:163:0x02ff, B:166:0x0309, B:171:0x0342, B:167:0x031a, B:169:0x0321, B:144:0x02a3, B:148:0x02ab, B:175:0x038e, B:52:0x00e6, B:51:0x00e0, B:39:0x00b7, B:32:0x008b, B:29:0x0068, B:36:0x009c, B:46:0x00cf), top: B:202:0x0063, inners: #3, #12, #15 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x0341  */
    /* JADX WARN: Code duplicated, block: B:172:0x0373  */
    /* JADX WARN: Code duplicated, block: B:177:0x0397  */
    /* JADX WARN: Code duplicated, block: B:193:0x0168 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:210:0x01a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:0x01ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:0x023e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:220:0x0209 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x011d A[Catch: Exception -> 0x039c, TRY_LEAVE, TryCatch #11 {Exception -> 0x039c, blocks: (B:27:0x0063, B:33:0x0095, B:40:0x00c2, B:43:0x00c9, B:53:0x00ff, B:54:0x0117, B:56:0x011d, B:107:0x01e9, B:109:0x01f2, B:110:0x0209, B:112:0x020f, B:114:0x0225, B:116:0x022d, B:125:0x023e, B:126:0x0242, B:128:0x0251, B:129:0x025c, B:131:0x0262, B:133:0x026e, B:136:0x027c, B:140:0x0285, B:142:0x028b, B:149:0x02af, B:150:0x02bc, B:152:0x02c2, B:154:0x02ca, B:155:0x02cd, B:160:0x02f2, B:163:0x02ff, B:166:0x0309, B:171:0x0342, B:167:0x031a, B:169:0x0321, B:144:0x02a3, B:148:0x02ab, B:175:0x038e, B:52:0x00e6, B:51:0x00e0, B:39:0x00b7, B:32:0x008b, B:29:0x0068, B:36:0x009c, B:46:0x00cf), top: B:202:0x0063, inners: #3, #12, #15 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0165  */
    /* JADX WARN: Code duplicated, block: B:78:0x019a  */
    /* JADX WARN: Code duplicated, block: B:95:0x01c1  */
    private final String decryptContent(String content) {
        Object obj;
        Object objDecodeFromString;
        boolean z;
        List channelWrappers;
        Collection destination$iv$iv;
        Collection destination$iv$iv2;
        List validChannels;
        StringBuilder sb;
        Iterator it;
        PlayZTVChannelData ch;
        String name;
        String name2;
        String logo;
        String str;
        String links;
        String links2;
        List links3;
        List<String> link_names;
        int idx;
        String l;
        boolean z2;
        String title;
        String str2;
        PlayZTVChannelData it2;
        boolean z3;
        String links4;
        boolean z4;
        String str3;
        PlayZTVChannelData playZTVChannelData;
        String value$iv;
        Object obj2;
        DeserializationStrategy deserializationStrategy;
        String value$iv2;
        Object objDecodeFromString2;
        String str4 = "kotlinx.serialization.serializer.simple";
        try {
            String trimmedContent = StringsKt.trim(content).toString();
            List list = null;
            if (!StringsKt.startsWith$default(trimmedContent, EXT_M3U, false, 2, (Object) null) && !StringsKt.startsWith$default(trimmedContent, EXT_INF, false, 2, (Object) null) && !StringsKt.startsWith$default(trimmedContent, "#KODIPROP", false, 2, (Object) null)) {
                String playzDecrypted = PlayZTVCryptoUtils.INSTANCE.decryptPlayZTV(trimmedContent);
                String str5 = playzDecrypted;
                if (str5 == null || StringsKt.isBlank(str5)) {
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
                if (!StringsKt.startsWith$default(playzDecrypted, EXT_M3U, false, 2, (Object) null) && !StringsKt.startsWith$default(playzDecrypted, EXT_INF, false, 2, (Object) null) && !StringsKt.startsWith$default(playzDecrypted, "#KODIPROP", false, 2, (Object) null) && StringsKt.startsWith$default(playzDecrypted, "[", false, 2, (Object) null)) {
                    try {
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PlayZTVChannelWrapper.class)));
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            } catch (Throwable th2) {
                                Result.Companion companion4 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th2));
                            }
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        DeserializationStrategy deserializationStrategy2 = (KSerializer) obj;
                        if (deserializationStrategy2 != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, playzDecrypted);
                                z = false;
                            } catch (SerializationException e) {
                                ArchComponentExtKt.logError(e);
                                ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                z = false;
                                objDecodeFromString = $this$readValue$iv$iv.readValue(playzDecrypted, new TypeReference<List<? extends PlayZTVChannelWrapper>>() { // from class: com.cncverse.PlayZTV$decryptContent$$inlined$parseJson$1
                                });
                            } catch (Throwable th3) {
                                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                z = false;
                                objDecodeFromString = $this$readValue$iv$iv2.readValue(playzDecrypted, new TypeReference<List<? extends PlayZTVChannelWrapper>>() { // from class: com.cncverse.PlayZTV$decryptContent$$inlined$parseJson$1
                                });
                            }
                            channelWrappers = (List) objDecodeFromString;
                            List $this$mapNotNull$iv = channelWrappers;
                            destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                PlayZTVChannelWrapper cw = (PlayZTVChannelWrapper) element$iv$iv$iv;
                                try {
                                    AppUtils appUtils2 = AppUtils.INSTANCE;
                                    value$iv = cw.getChannel();
                                    try {
                                        Result.Companion companion5 = Result.Companion;
                                        KType kTypeTypeOf2 = Reflection.typeOf(PlayZTVChannelData.class);
                                        MagicApiIntrinsics.voidMagicApiCall(str4);
                                        obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                    } catch (Throwable th4) {
                                        Result.Companion companion6 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th4));
                                    }
                                    if (Result.exceptionOrNull-impl(obj2) == null) {
                                        str3 = str4;
                                    } else {
                                        try {
                                            Result.Companion companion7 = Result.Companion;
                                            str3 = str4;
                                            try {
                                                obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PlayZTVChannelData.class), list, 2, list));
                                            } catch (Throwable th5) {
                                                th = th5;
                                                Result.Companion companion8 = Result.Companion;
                                                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            str3 = str4;
                                        }
                                    }
                                    try {
                                        if (Result.isFailure-impl(obj2)) {
                                            obj2 = list;
                                        }
                                        deserializationStrategy = (KSerializer) obj2;
                                        if (deserializationStrategy != null) {
                                            try {
                                                value$iv2 = value$iv;
                                                try {
                                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv2);
                                                } catch (SerializationException e2) {
                                                    e$iv = e2;
                                                    ArchComponentExtKt.logError((Throwable) e$iv);
                                                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                                    String content$iv$iv = value$iv2;
                                                    objDecodeFromString2 = $this$readValue$iv$iv3.readValue(content$iv$iv, new TypeReference<PlayZTVChannelData>() { // from class: com.cncverse.PlayZTV$decryptContent$lambda$0$$inlined$parseJson$1
                                                    });
                                                } catch (Throwable th7) {
                                                    ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                                    String content$iv$iv2 = value$iv2;
                                                    objDecodeFromString2 = $this$readValue$iv$iv4.readValue(content$iv$iv2, new TypeReference<PlayZTVChannelData>() { // from class: com.cncverse.PlayZTV$decryptContent$lambda$0$$inlined$parseJson$1
                                                    });
                                                }
                                            } catch (SerializationException e3) {
                                                e$iv = e3;
                                                value$iv2 = value$iv;
                                            } catch (Throwable th8) {
                                                value$iv2 = value$iv;
                                            }
                                            playZTVChannelData = (PlayZTVChannelData) objDecodeFromString2;
                                            if (playZTVChannelData != null) {
                                                destination$iv$iv.add(playZTVChannelData);
                                            }
                                            str4 = str3;
                                            list = null;
                                        } else {
                                            value$iv2 = value$iv;
                                        }
                                        ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                        String content$iv$iv3 = value$iv2;
                                        objDecodeFromString2 = $this$readValue$iv$iv5.readValue(content$iv$iv3, new TypeReference<PlayZTVChannelData>() { // from class: com.cncverse.PlayZTV$decryptContent$lambda$0$$inlined$parseJson$1
                                        });
                                        playZTVChannelData = (PlayZTVChannelData) objDecodeFromString2;
                                    } catch (Exception e4) {
                                        playZTVChannelData = null;
                                    }
                                } catch (Exception e5) {
                                    str3 = str4;
                                    playZTVChannelData = null;
                                    if (playZTVChannelData != null) {
                                        destination$iv$iv.add(playZTVChannelData);
                                    }
                                    str4 = str3;
                                    list = null;
                                }
                                if (playZTVChannelData != null) {
                                    destination$iv$iv.add(playZTVChannelData);
                                }
                                str4 = str3;
                                list = null;
                            }
                            Iterable $this$filter$iv = (List) destination$iv$iv;
                            destination$iv$iv2 = new ArrayList();
                            for (Object element$iv$iv : $this$filter$iv) {
                                it2 = (PlayZTVChannelData) element$iv$iv;
                                if (Intrinsics.areEqual(it2.getVisible(), Boolean.valueOf(z))) {
                                    z3 = false;
                                } else {
                                    links4 = it2.getLinks();
                                    if (links4 != null || StringsKt.isBlank(links4)) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z4) {
                                        z3 = false;
                                    } else {
                                        z3 = true;
                                    }
                                }
                                if (z3) {
                                    destination$iv$iv2.add(element$iv$iv);
                                }
                            }
                            validChannels = (List) destination$iv$iv2;
                            if (!validChannels.isEmpty()) {
                                sb = new StringBuilder("#EXTM3U\n");
                                it = validChannels.iterator();
                                while (it.hasNext()) {
                                    ch = (PlayZTVChannelData) it.next();
                                    name = ch.getName();
                                    if (name != null || (name2 = StringsKt.trim(name).toString()) == null) {
                                        name2 = "Channel";
                                    }
                                    logo = ch.getLogo();
                                    str = "";
                                    if (logo == null) {
                                        logo = "";
                                    }
                                    links = ch.getLinks();
                                    if (links != null || (links3 = StringsKt.split$default(links, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                                        links2 = ch.getLinks();
                                        if (links2 != null) {
                                            str = links2;
                                        }
                                        links3 = CollectionsKt.listOf(str);
                                    }
                                    link_names = ch.getLink_names();
                                    Iterable $this$forEachIndexed$iv = links3;
                                    idx = 0;
                                    for (Object item$iv : $this$forEachIndexed$iv) {
                                        int index$iv = idx + 1;
                                        if (idx < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        String link = (String) item$iv;
                                        l = StringsKt.trim(link).toString();
                                        if (l.length() > 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (!z2) {
                                            if (links3.size() <= 1) {
                                                if (link_names != null) {
                                                    str2 = (String) CollectionsKt.getOrNull(link_names, idx);
                                                } else {
                                                    str2 = null;
                                                }
                                                if (str2 != null) {
                                                    title = StringsKt.trim(link_names.get(idx)).toString();
                                                } else if (links3.size() > 1) {
                                                    title = name2 + " (" + (idx + 1) + ')';
                                                } else {
                                                    title = name2;
                                                }
                                            } else if (links3.size() > 1) {
                                                title = name2 + " (" + (idx + 1) + ')';
                                            } else {
                                                title = name2;
                                            }
                                            sb.append("#EXTINF:-1 tvg-logo=\"" + logo + "\" group-title=\"Live\"," + title).append("\n");
                                            sb.append(l).append("\n");
                                        }
                                        idx = index$iv;
                                        it = it;
                                        channelWrappers = channelWrappers;
                                        validChannels = validChannels;
                                    }
                                }
                                return sb.toString();
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                            z = false;
                            objDecodeFromString = $this$readValue$iv$iv6.readValue(playzDecrypted, new TypeReference<List<? extends PlayZTVChannelWrapper>>() { // from class: com.cncverse.PlayZTV$decryptContent$$inlined$parseJson$1
                            });
                            channelWrappers = (List) objDecodeFromString;
                            List $this$mapNotNull$iv2 = channelWrappers;
                            destination$iv$iv = new ArrayList();
                            while (r16.hasNext()) {
                                PlayZTVChannelWrapper cw2 = (PlayZTVChannelWrapper) element$iv$iv$iv;
                                AppUtils appUtils3 = AppUtils.INSTANCE;
                                value$iv = cw2.getChannel();
                                Result.Companion companion9 = Result.Companion;
                                KType kTypeTypeOf3 = Reflection.typeOf(PlayZTVChannelData.class);
                                MagicApiIntrinsics.voidMagicApiCall(str4);
                                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                if (Result.exceptionOrNull-impl(obj2) == null) {
                                    str3 = str4;
                                } else {
                                    Result.Companion companion10 = Result.Companion;
                                    str3 = str4;
                                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PlayZTVChannelData.class), list, 2, list));
                                }
                                if (Result.isFailure-impl(obj2)) {
                                    obj2 = list;
                                }
                                deserializationStrategy = (KSerializer) obj2;
                                if (deserializationStrategy != null) {
                                    value$iv2 = value$iv;
                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv2);
                                    playZTVChannelData = (PlayZTVChannelData) objDecodeFromString2;
                                    if (playZTVChannelData != null) {
                                        destination$iv$iv.add(playZTVChannelData);
                                    }
                                    str4 = str3;
                                    list = null;
                                } else {
                                    value$iv2 = value$iv;
                                }
                                ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                                String content$iv$iv4 = value$iv2;
                                objDecodeFromString2 = $this$readValue$iv$iv7.readValue(content$iv$iv4, new TypeReference<PlayZTVChannelData>() { // from class: com.cncverse.PlayZTV$decryptContent$lambda$0$$inlined$parseJson$1
                                });
                                playZTVChannelData = (PlayZTVChannelData) objDecodeFromString2;
                                if (playZTVChannelData != null) {
                                    destination$iv$iv.add(playZTVChannelData);
                                }
                                str4 = str3;
                                list = null;
                            }
                            Iterable $this$filter$iv2 = (List) destination$iv$iv;
                            destination$iv$iv2 = new ArrayList();
                            while (r8.hasNext()) {
                                it2 = (PlayZTVChannelData) element$iv$iv;
                                if (Intrinsics.areEqual(it2.getVisible(), Boolean.valueOf(z))) {
                                    z3 = false;
                                } else {
                                    links4 = it2.getLinks();
                                    if (links4 != null) {
                                        z4 = true;
                                    } else {
                                        z4 = true;
                                    }
                                    if (z4) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                }
                                if (z3) {
                                    destination$iv$iv2.add(element$iv$iv);
                                }
                            }
                            validChannels = (List) destination$iv$iv2;
                            if (!validChannels.isEmpty()) {
                                sb = new StringBuilder("#EXTM3U\n");
                                it = validChannels.iterator();
                                while (it.hasNext()) {
                                    ch = (PlayZTVChannelData) it.next();
                                    name = ch.getName();
                                    if (name != null) {
                                        name2 = "Channel";
                                    } else {
                                        name2 = "Channel";
                                    }
                                    logo = ch.getLogo();
                                    str = "";
                                    if (logo == null) {
                                        logo = "";
                                    }
                                    links = ch.getLinks();
                                    if (links != null) {
                                        links2 = ch.getLinks();
                                        if (links2 != null) {
                                            str = links2;
                                        }
                                        links3 = CollectionsKt.listOf(str);
                                    } else {
                                        links2 = ch.getLinks();
                                        if (links2 != null) {
                                            str = links2;
                                        }
                                        links3 = CollectionsKt.listOf(str);
                                    }
                                    link_names = ch.getLink_names();
                                    Iterable $this$forEachIndexed$iv2 = links3;
                                    idx = 0;
                                    while (r15.hasNext()) {
                                        int index$iv2 = idx + 1;
                                        if (idx < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        String link2 = (String) item$iv;
                                        l = StringsKt.trim(link2).toString();
                                        if (l.length() > 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (!z2) {
                                            if (links3.size() <= 1) {
                                                if (link_names != null) {
                                                    str2 = (String) CollectionsKt.getOrNull(link_names, idx);
                                                } else {
                                                    str2 = null;
                                                }
                                                if (str2 != null) {
                                                    title = StringsKt.trim(link_names.get(idx)).toString();
                                                } else if (links3.size() > 1) {
                                                    title = name2 + " (" + (idx + 1) + ')';
                                                } else {
                                                    title = name2;
                                                }
                                            } else if (links3.size() > 1) {
                                                title = name2 + " (" + (idx + 1) + ')';
                                            } else {
                                                title = name2;
                                            }
                                            sb.append("#EXTINF:-1 tvg-logo=\"" + logo + "\" group-title=\"Live\"," + title).append("\n");
                                            sb.append(l).append("\n");
                                        }
                                        idx = index$iv2;
                                        it = it;
                                        channelWrappers = channelWrappers;
                                        validChannels = validChannels;
                                    }
                                }
                                return sb.toString();
                            }
                        }
                    } catch (Exception e6) {
                    }
                }
                return playzDecrypted;
            }
            return trimmedContent;
        } catch (Exception e7) {
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
                    objDecodeFromString = $this$readValue$iv$iv.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.PlayZTV$getDRMKeysFromLicenseServer$lambda$0$$inlined$parseJson$1
                    });
                } catch (Throwable th10) {
                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv2.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.PlayZTV$getDRMKeysFromLicenseServer$lambda$0$$inlined$parseJson$1
                    });
                }
            } else {
                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv3.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.PlayZTV$getDRMKeysFromLicenseServer$lambda$0$$inlined$parseJson$1
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
        C00011 c00011;
        int page2;
        Object obj;
        MainPageRequest request2;
        Object answer$iv$iv$iv;
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
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                String mainUrl = getMainUrl();
                c00011.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00011.I$0 = page;
                c00011.label = 1;
                Object withCustomHeaders = getWithCustomHeaders(mainUrl, c00011);
                if (withCustomHeaders == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page2 = page;
                obj = withCustomHeaders;
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00011.I$0;
                request2 = (MainPageRequest) c00011.L$0;
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
            c00011 = c00011;
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
                destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, channelname, AppUtils.INSTANCE.toJson(new LoadData(streamurl, channelname, posterurl, nation, key2, keyid2, userAgent2, cookie2, licenseUrl2, channel.getDrmKeys(), channel.getHeaders())), TvType.Live, false, new Function1() { // from class: com.cncverse.PlayZTV$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        return PlayZTV.getMainPage$lambda$1$0$0(posterurl, channel, (LiveSearchResponse) obj2);
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
        C00111 c00111;
        Object withCustomHeaders;
        String query2;
        PlayZTV playZTV = this;
        if (continuation instanceof C00111) {
            c00111 = (C00111) continuation;
            if ((c00111.label & Integer.MIN_VALUE) != 0) {
                c00111.label -= Integer.MIN_VALUE;
            } else {
                c00111 = playZTV.new C00111(continuation);
            }
        } else {
            c00111 = playZTV.new C00111(continuation);
        }
        Object $result = c00111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00111.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return CollectionsKt.emptyList();
                }
                String mainUrl = playZTV.getMainUrl();
                c00111.L$0 = query;
                c00111.label = 1;
                withCustomHeaders = playZTV.getWithCustomHeaders(mainUrl, c00111);
                if (withCustomHeaders == coroutine_suspended) {
                    return coroutine_suspended;
                }
                query2 = query;
                break;
                break;
            case 1:
                query2 = (String) c00111.L$0;
                ResultKt.throwOnFailure($result);
                withCustomHeaders = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String rawContent = (String) withCustomHeaders;
        String decryptedContent = playZTV.decryptContent(rawContent);
        Playlist data = new IptvPlaylistParser().parseM3U(decryptedContent);
        Iterable $this$filter$iv = data.getItems();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            PlaylistItem it = (PlaylistItem) element$iv$iv;
            String title = it.getTitle();
            if (title != null ? StringsKt.contains(title, query2, true) : false) {
                destination$iv$iv.add(element$iv$iv);
            }
            c00111 = c00111;
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
            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(playZTV, channelname, AppUtils.INSTANCE.toJson(new LoadData(streamurl, channelname, posterurl, nation, key2, keyid2, userAgent2, cookie2, licenseUrl2, channel.getDrmKeys(), playZTV.headers)), TvType.Live, false, new Function1() { // from class: com.cncverse.PlayZTV$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    return PlayZTV.search$lambda$1$0(posterurl, channel, (LiveSearchResponse) obj);
                }
            }, 8, (Object) null));
            playZTV = this;
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
                objDecodeFromString = $this$readValue$iv$iv.readValue(url, new TypeReference<LoadData>() { // from class: com.cncverse.PlayZTV$load$$inlined$parseJson$1
                });
            } catch (Throwable th3) {
                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv2.readValue(url, new TypeReference<LoadData>() { // from class: com.cncverse.PlayZTV$load$$inlined$parseJson$1
                });
            }
        } else {
            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
            objDecodeFromString = $this$readValue$iv$iv3.readValue(url, new TypeReference<LoadData>() { // from class: com.cncverse.PlayZTV$load$$inlined$parseJson$1
            });
        }
        LoadData data = (LoadData) objDecodeFromString;
        return MainAPIKt.newLiveStreamLoadResponse(this, data.getTitle(), url, url, new C00022(data, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.PlayZTV$load$2 */
    /* JADX INFO: compiled from: PlayZTV.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/LiveStreamLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTV$load$2", f = "PlayZTV.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00022 extends SuspendLambda implements Function2<LiveStreamLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ LoadData $data;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(LoadData loadData, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$data = loadData;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$data, continuation);
            c00022.L$0 = obj;
            return c00022;
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

    /* JADX INFO: compiled from: PlayZTV.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0015\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u0015\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u008f\u0001\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rHÆ\u0001J\u0014\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020.HÖ\u0081\u0004J\n\u0010/\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001c¨\u00060"}, d2 = {"Lcom/cncverse/PlayZTV$LoadData;", "", "url", "", "title", "poster", "nation", "key", "keyid", "userAgent", "cookie", "licenseUrl", "drmKeys", "", "headers", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getUrl", "()Ljava/lang/String;", "getTitle", "getPoster", "getNation", "getKey", "getKeyid", "getUserAgent", "getCookie", "getLicenseUrl", "getDrmKeys", "()Ljava/util/Map;", "getHeaders", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "", "toString", "PlayZTVProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX WARN: Code duplicated, block: B:126:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:129:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:132:0x0452 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:133:0x0453  */
    /* JADX WARN: Code duplicated, block: B:73:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00031 c00031;
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
        LoadData loadData5;
        Function1<? super ExtractorLink, Unit> function11;
        Function1<? super SubtitleFile, Unit> function12;
        Object obj2;
        Function1<? super ExtractorLink, Unit> function13;
        Object objNewDrmExtractorLink;
        Function1<? super ExtractorLink, Unit> function14;
        MatchGroupCollection groups;
        MatchGroup matchGroup;
        String normalizedKey;
        String mpdKidHex;
        String mappedKey;
        String playerKey;
        String playerKid;
        Object objNewDrmExtractorLink2;
        MatchGroupCollection groups2;
        MatchGroup matchGroup2;
        String value;
        String strReplace$default;
        Function1<? super ExtractorLink, Unit> function15 = function2;
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
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
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
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<LoadData>() { // from class: com.cncverse.PlayZTV$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<LoadData>() { // from class: com.cncverse.PlayZTV$loadLinks$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<LoadData>() { // from class: com.cncverse.PlayZTV$loadLinks$$inlined$parseJson$1
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
                        C00086 c00086 = new C00086(headers, null);
                        c00032.L$0 = SpillingKt.nullOutSpilledVariable(data);
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                        c00032.L$5 = function15;
                        c00032.Z$0 = isCasting;
                        c00032.label = 5;
                        objNewExtractorLink3 = ExtractorApiKt.newExtractorLink(name, name2, url, extractorLinkType, c00086, c00032);
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
                        C00097 c00097 = new C00097(headers2, null);
                        c00032.L$0 = SpillingKt.nullOutSpilledVariable(data);
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(headers2);
                        c00032.L$5 = function15;
                        c00032.Z$0 = isCasting;
                        c00032.label = 6;
                        objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name3, name4, url2, extractorLinkType2, c00097, c00032);
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
                    C00108 c00108 = new C00108(headers3, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                    c00032.L$5 = function15;
                    c00032.Z$0 = isCasting;
                    c00032.label = 7;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(name5, title, url3, infer_type, c00108, c00032);
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
                    String normalizedKid = base64ToHexOrNull(loadData6.getKeyid());
                    if (normalizedKid == null) {
                        normalizedKid = StringsKt.trim(loadData6.getKeyid()).toString();
                    }
                    if (!loadData6.getDrmKeys().isEmpty()) {
                        normalizedKey = normalizedKey2;
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
                        String normalizedKid2 = mpdKidHex;
                        C00042 c00042 = new C00042(headers4, playerKey, playerKid, null);
                        c00032.L$0 = SpillingKt.nullOutSpilledVariable(data);
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(headers4);
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(normalizedKey3);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(normalizedKid2);
                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(playerKey);
                        c00032.L$8 = SpillingKt.nullOutSpilledVariable(playerKid);
                        c00032.L$9 = function15;
                        c00032.Z$0 = isCasting;
                        c00032.I$0 = i2;
                        c00032.I$1 = i3;
                        c00032.label = 1;
                        objNewDrmExtractorLink2 = ExtractorApiKt.newDrmExtractorLink(name6, normalizedKey4, playerKey2, infer_type2, clearkey_uuid, c00042, c00032);
                        if (objNewDrmExtractorLink2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function15.invoke(objNewDrmExtractorLink2);
                        return Boxing.boxBoolean(true);
                    }
                    normalizedKey = normalizedKey2;
                    mpdKidHex = normalizedKid;
                    mappedKey = normalizedKey;
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
                    String normalizedKid3 = mpdKidHex;
                    C00042 c00043 = new C00042(headers4, playerKey, playerKid, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(headers4);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(normalizedKey5);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(normalizedKid3);
                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(playerKey);
                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(playerKid);
                    c00032.L$9 = function15;
                    c00032.Z$0 = isCasting;
                    c00032.I$0 = i2;
                    c00032.I$1 = i3;
                    c00032.label = 1;
                    objNewDrmExtractorLink2 = ExtractorApiKt.newDrmExtractorLink(name7, normalizedKey6, playerKey3, infer_type3, clearkey_uuid2, c00043, c00032);
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
                    C00075 c00075 = new C00075(headers4, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(headers4);
                    c00032.L$5 = function15;
                    c00032.Z$0 = isCasting;
                    c00032.I$0 = i2;
                    c00032.I$1 = i4;
                    c00032.label = 4;
                    objNewExtractorLink4 = ExtractorApiKt.newExtractorLink(name8, name9, url4, extractorLinkType3, c00075, c00032);
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
                    C00053 c00053 = new C00053(headers4, keyBase64, drmKidBase64, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(headers4);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(mpdStr);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(regex3);
                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(matchResult);
                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(drmKid);
                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(drmKidBytes);
                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(drmKidBase64);
                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(keyBase64);
                    c00032.L$12 = function15;
                    c00032.Z$0 = isCasting;
                    c00032.I$0 = i2;
                    c00032.I$1 = i4;
                    c00032.label = 2;
                    objNewDrmExtractorLink = ExtractorApiKt.newDrmExtractorLink(name10, drmKidBase65, keyBase65, infer_type4, clearkey_uuid3, c00053, c00032);
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
                C00064 c00064 = new C00064(headers4, loadData6, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(headers4);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(mpdStr);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(regex3);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(matchResult);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(drmKid);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(drmKidBytes);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(drmKidBase64);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(keyBase64);
                c00032.L$12 = function15;
                c00032.Z$0 = isCasting;
                c00032.I$0 = i2;
                c00032.I$1 = i4;
                c00032.label = 3;
                Object objNewDrmExtractorLink3 = ExtractorApiKt.newDrmExtractorLink(name11, name12, url5, infer_type5, clearkey_uuid4, c00064, c00032);
                if (objNewDrmExtractorLink3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                loadData5 = loadData6;
                function11 = function15;
                function12 = function1;
                obj2 = objNewDrmExtractorLink3;
                function13 = function11;
                function11.invoke(obj2);
                return Boxing.boxBoolean(true);
            case 1:
                int i5 = c00032.I$1;
                int i6 = c00032.I$0;
                boolean z = c00032.Z$0;
                Function1<? super ExtractorLink, Unit> function16 = (Function1) c00032.L$9;
                ResultKt.throwOnFailure($result);
                function15 = function16;
                objNewDrmExtractorLink2 = $result;
                function15.invoke(objNewDrmExtractorLink2);
                return Boxing.boxBoolean(true);
            case 2:
                int i7 = c00032.I$1;
                int i8 = c00032.I$0;
                boolean z2 = c00032.Z$0;
                function14 = (Function1) c00032.L$12;
                ResultKt.throwOnFailure($result);
                objNewDrmExtractorLink = $result;
                function14.invoke(objNewDrmExtractorLink);
                return Boxing.boxBoolean(true);
            case 3:
                int i9 = c00032.I$1;
                int i10 = c00032.I$0;
                boolean z3 = c00032.Z$0;
                function11 = (Function1) c00032.L$12;
                loadData5 = (LoadData) c00032.L$3;
                Function1<? super ExtractorLink, Unit> function17 = (Function1) c00032.L$2;
                function12 = (Function1) c00032.L$1;
                ResultKt.throwOnFailure($result);
                function13 = function17;
                obj2 = $result;
                function11.invoke(obj2);
                return Boxing.boxBoolean(true);
            case 4:
                int i11 = c00032.I$1;
                int i12 = c00032.I$0;
                boolean z4 = c00032.Z$0;
                Function1<? super ExtractorLink, Unit> function18 = (Function1) c00032.L$5;
                loadData4 = (LoadData) c00032.L$3;
                Function1<? super ExtractorLink, Unit> function19 = (Function1) c00032.L$2;
                function9 = (Function1) c00032.L$1;
                data5 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                function10 = function19;
                function15 = function18;
                objNewExtractorLink4 = $result;
                function15.invoke(objNewExtractorLink4);
                return Boxing.boxBoolean(true);
            case 5:
                isCasting4 = c00032.Z$0;
                function8 = (Function1) c00032.L$5;
                loadData3 = (LoadData) c00032.L$3;
                function15 = (Function1) c00032.L$2;
                function7 = (Function1) c00032.L$1;
                data4 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink3 = $result;
                function8.invoke(objNewExtractorLink3);
                return Boxing.boxBoolean(true);
            case 6:
                isCasting3 = c00032.Z$0;
                function6 = (Function1) c00032.L$5;
                loadData2 = (LoadData) c00032.L$3;
                function15 = (Function1) c00032.L$2;
                function5 = (Function1) c00032.L$1;
                data3 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink2 = $result;
                function6.invoke(objNewExtractorLink2);
                return Boxing.boxBoolean(true);
            case 7:
                isCasting2 = c00032.Z$0;
                function4 = (Function1) c00032.L$5;
                loadData = (LoadData) c00032.L$3;
                function15 = (Function1) c00032.L$2;
                function3 = (Function1) c00032.L$1;
                data2 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function4.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayZTV$loadLinks$2 */
    /* JADX INFO: compiled from: PlayZTV.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/DrmExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTV$loadLinks$2", f = "PlayZTV.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<DrmExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        final /* synthetic */ String $playerKey;
        final /* synthetic */ String $playerKid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(Map<String, String> map, String str, String str2, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$headers = map;
            this.$playerKey = str;
            this.$playerKid = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(this.$headers, this.$playerKey, this.$playerKid, continuation);
            c00042.L$0 = obj;
            return c00042;
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

    /* JADX INFO: renamed from: com.cncverse.PlayZTV$loadLinks$3 */
    /* JADX INFO: compiled from: PlayZTV.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/DrmExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTV$loadLinks$3", f = "PlayZTV.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00053 extends SuspendLambda implements Function2<DrmExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $drmKidBase64;
        final /* synthetic */ Map<String, String> $headers;
        final /* synthetic */ String $keyBase64;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00053(Map<String, String> map, String str, String str2, Continuation<? super C00053> continuation) {
            super(2, continuation);
            this.$headers = map;
            this.$keyBase64 = str;
            this.$drmKidBase64 = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00053 = new C00053(this.$headers, this.$keyBase64, this.$drmKidBase64, continuation);
            c00053.L$0 = obj;
            return c00053;
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

    /* JADX INFO: renamed from: com.cncverse.PlayZTV$loadLinks$4 */
    /* JADX INFO: compiled from: PlayZTV.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/DrmExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTV$loadLinks$4", f = "PlayZTV.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00064 extends SuspendLambda implements Function2<DrmExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        final /* synthetic */ LoadData $loadData;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00064(Map<String, String> map, LoadData loadData, Continuation<? super C00064> continuation) {
            super(2, continuation);
            this.$headers = map;
            this.$loadData = loadData;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00064 = new C00064(this.$headers, this.$loadData, continuation);
            c00064.L$0 = obj;
            return c00064;
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

    /* JADX INFO: renamed from: com.cncverse.PlayZTV$loadLinks$5 */
    /* JADX INFO: compiled from: PlayZTV.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTV$loadLinks$5", f = "PlayZTV.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00075 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00075(Map<String, String> map, Continuation<? super C00075> continuation) {
            super(2, continuation);
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00075 = new C00075(this.$headers, continuation);
            c00075.L$0 = obj;
            return c00075;
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

    /* JADX INFO: renamed from: com.cncverse.PlayZTV$loadLinks$6 */
    /* JADX INFO: compiled from: PlayZTV.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTV$loadLinks$6", f = "PlayZTV.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00086 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00086(Map<String, String> map, Continuation<? super C00086> continuation) {
            super(2, continuation);
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00086 = new C00086(this.$headers, continuation);
            c00086.L$0 = obj;
            return c00086;
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

    /* JADX INFO: renamed from: com.cncverse.PlayZTV$loadLinks$7 */
    /* JADX INFO: compiled from: PlayZTV.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTV$loadLinks$7", f = "PlayZTV.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00097 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00097(Map<String, String> map, Continuation<? super C00097> continuation) {
            super(2, continuation);
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00097 = new C00097(this.$headers, continuation);
            c00097.L$0 = obj;
            return c00097;
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

    /* JADX INFO: renamed from: com.cncverse.PlayZTV$loadLinks$8 */
    /* JADX INFO: compiled from: PlayZTV.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTV$loadLinks$8", f = "PlayZTV.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00108 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00108(Map<String, String> map, Continuation<? super C00108> continuation) {
            super(2, continuation);
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00108 = new C00108(this.$headers, continuation);
            c00108.L$0 = obj;
            return c00108;
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
