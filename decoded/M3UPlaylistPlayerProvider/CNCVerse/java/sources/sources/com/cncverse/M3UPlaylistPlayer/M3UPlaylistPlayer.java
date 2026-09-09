package com.cncverse.M3UPlaylistPlayer;

import android.content.Context;
import android.util.Base64;
import com.cncverse.donation.DonationManager;
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
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: M3UPlaylistPlayer.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/M3UPlaylistPlayerProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 J2\u00020\u0001:\u0002JKB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\u0004\u0018\u00010\u0003*\u00020\u0003H\u0002J\u000e\u0010)\u001a\u0004\u0018\u00010\u0003*\u00020\u0003H\u0002J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003H\u0002J$\u0010,\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001eH\u0002J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0003H\u0002J\u001e\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u00106J\u001c\u00107\u001a\b\u0012\u0004\u0012\u000209082\u0006\u0010:\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010'J\u0016\u0010;\u001a\u00020<2\u0006\u0010&\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010'JF\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00132\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C0A2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020C0AH\u0096@¢\u0006\u0002\u0010FJ\u0012\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020EH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"¨\u0006L"}, d2 = {"Lcom/cncverse/M3UPlaylistPlayer/M3UPlaylistPlayer;", "Lcom/lagradost/cloudstream3/MainAPI;", "customName", "", "customMainUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "lang", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "hasChromecastSupport", "getHasChromecastSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "headers", "", "customHttpClient", "Lokhttp3/OkHttpClient;", "getCustomHttpClient", "()Lokhttp3/OkHttpClient;", "customHttpClient$delegate", "Lkotlin/Lazy;", "getWithCustomHeaders", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base64ToHexOrNull", "hexToBase64UrlOrNull", "decryptContent", "content", "getMpdStream", "customHeaders", "getDRMKeysFromLicenseServer", "kid", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoInterceptor", "Lokhttp3/Interceptor;", "extractorLink", "Companion", "LoadData", "M3UPlaylistPlayerProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nM3UPlaylistPlayer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 M3UPlaylistPlayer.kt\ncom/cncverse/M3UPlaylistPlayer/M3UPlaylistPlayer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 6 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 7 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1031:1\n296#2,2:1032\n1586#2:1034\n1661#2,3:1035\n296#2,2:1057\n1512#2:1059\n1538#2,3:1060\n1541#2,3:1070\n1586#2:1076\n1661#2,3:1077\n777#2:1081\n873#2,2:1082\n1586#2:1084\n1661#2,3:1085\n1586#2:1126\n1661#2,3:1127\n63#3:1038\n64#3,15:1040\n63#3:1088\n64#3,15:1090\n63#3:1107\n64#3,15:1109\n1#4:1039\n1#4:1089\n1#4:1108\n50#5:1055\n43#5:1056\n50#5:1105\n43#5:1106\n50#5:1124\n43#5:1125\n383#6,7:1063\n129#7:1073\n158#7,2:1074\n160#7:1080\n*S KotlinDebug\n*F\n+ 1 M3UPlaylistPlayer.kt\ncom/cncverse/M3UPlaylistPlayer/M3UPlaylistPlayer\n*L\n108#1:1032,2\n164#1:1034\n164#1:1035,3\n254#1:1057,2\n267#1:1059\n267#1:1060,3\n267#1:1070,3\n269#1:1076\n269#1:1077,3\n299#1:1081\n299#1:1082,2\n299#1:1084\n299#1:1085,3\n422#1:1126\n422#1:1127,3\n251#1:1038\n251#1:1040,15\n320#1:1088\n320#1:1090,15\n348#1:1107\n348#1:1109,15\n251#1:1039\n320#1:1089\n348#1:1108\n251#1:1055\n251#1:1056\n320#1:1105\n320#1:1106\n348#1:1124\n348#1:1125\n267#1:1063,7\n267#1:1073\n267#1:1074,2\n267#1:1080\n*E\n"})
public final class M3UPlaylistPlayer extends MainAPI {

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

    @NotNull
    private final String customMainUrl;

    @NotNull
    private final String customName;

    @NotNull
    private String mainUrl;

    @NotNull
    private String name;

    @NotNull
    private String lang = "en";
    private final boolean hasMainPage = true;
    private final boolean hasChromecastSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Live);

    @NotNull
    private final Map<String, String> headers = MapsKt.mapOf(TuplesKt.to("User-Agent", "OTT Navigator/1.7.1.4 (Linux;Android 13; en; 1fin92n)"));

    /* JADX INFO: renamed from: customHttpClient$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy customHttpClient = LazyKt.lazy(new Function0() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$$ExternalSyntheticLambda1
        public final Object invoke() {
            return M3UPlaylistPlayer.customHttpClient_delegate$lambda$0(this.f$0);
        }
    });

    /* JADX INFO: renamed from: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$getMainPage$1 */
    /* JADX INFO: compiled from: M3UPlaylistPlayer.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer", f = "M3UPlaylistPlayer.kt", i = {0, 0}, l = {264}, m = "getMainPage", n = {"request", "page"}, nl = {265}, s = {"L$0", "I$0"}, v = 2)
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
            return M3UPlaylistPlayer.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$1 */
    /* JADX INFO: compiled from: M3UPlaylistPlayer.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer", f = "M3UPlaylistPlayer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, l = {394, 433, 453, 471, 497, 518, 541}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "loadData", "headers", "normalizedKey", "normalizedKid", "playerKey", "playerKid", "isCasting", "hasValidKeys", "hasLicenseUrl", "data", "subtitleCallback", "callback", "loadData", "headers", "mpdStr", "regex", "matchResult", "drmKid", "drmKidBytes", "drmKidBase64", "keyBase64", "isCasting", "hasValidKeys", "hasLicenseUrl", "data", "subtitleCallback", "callback", "loadData", "headers", "mpdStr", "regex", "matchResult", "drmKid", "drmKidBytes", "drmKidBase64", "keyBase64", "isCasting", "hasValidKeys", "hasLicenseUrl", "data", "subtitleCallback", "callback", "loadData", "headers", "isCasting", "hasValidKeys", "hasLicenseUrl", "data", "subtitleCallback", "callback", "loadData", "headers", "isCasting", "data", "subtitleCallback", "callback", "loadData", "userAgent", "headers", "isCasting", "data", "subtitleCallback", "callback", "loadData", "headers", "isCasting"}, nl = {393, 432, 452, 470, 496, 517, 540}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
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

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return M3UPlaylistPlayer.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$search$1 */
    /* JADX INFO: compiled from: M3UPlaylistPlayer.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer", f = "M3UPlaylistPlayer.kt", i = {0}, l = {296}, m = "search", n = {"query"}, nl = {297}, s = {"L$0"}, v = 2)
    static final class C00131 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00131(Continuation<? super C00131> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return M3UPlaylistPlayer.this.search(null, (Continuation) this);
        }
    }

    public M3UPlaylistPlayer(@NotNull String customName, @NotNull String customMainUrl) {
        this.customName = customName;
        this.customMainUrl = customMainUrl;
        this.mainUrl = this.customMainUrl;
        this.name = this.customName;
    }

    /* JADX INFO: compiled from: M3UPlaylistPlayer.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/cncverse/M3UPlaylistPlayer/M3UPlaylistPlayer$Companion;", "", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "EXT_M3U", "", "EXT_INF", "EXT_VLC_OPT", "M3UPlaylistPlayerProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Context getContext() {
            return M3UPlaylistPlayer.context;
        }

        public final void setContext(@Nullable Context context) {
            M3UPlaylistPlayer.context = context;
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
    public static final OkHttpClient customHttpClient_delegate$lambda$0(M3UPlaylistPlayer this$0) {
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
            return ArraysKt.joinToString$default(decoded, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    return M3UPlaylistPlayer.base64ToHexOrNull$lambda$1(((Byte) obj).byteValue());
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
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new HeaderReplacementInterceptor(MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "OTT Navigator/1.7.1.4 (Linux;Android 13; en; 1fin92n)"), TuplesKt.to("Content-Type", "application/json")}))).addInterceptor(new LoggingInterceptor()).build();
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
                    objDecodeFromString = $this$readValue$iv$iv.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$getDRMKeysFromLicenseServer$lambda$0$$inlined$parseJson$1
                    });
                } catch (Throwable th10) {
                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv2.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$getDRMKeysFromLicenseServer$lambda$0$$inlined$parseJson$1
                    });
                }
            } else {
                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv3.readValue(responseBody, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$getDRMKeysFromLicenseServer$lambda$0$$inlined$parseJson$1
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
                DonationManager.INSTANCE.checkAndShow(getName());
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
                str2 = "Channels";
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
                destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, channelname, AppUtils.INSTANCE.toJson(new LoadData(streamurl, channelname, posterurl, nation, key2, keyid2, userAgent2, cookie2, licenseUrl2, channel.getDrmKeys(), channel.getHeaders())), TvType.Live, false, new Function1() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        return M3UPlaylistPlayer.getMainPage$lambda$1$0$0(posterurl, channel, (LiveSearchResponse) obj2);
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
        C00131 c00131;
        Object withCustomHeaders;
        String query2;
        if (continuation instanceof C00131) {
            c00131 = (C00131) continuation;
            if ((c00131.label & Integer.MIN_VALUE) != 0) {
                c00131.label -= Integer.MIN_VALUE;
            } else {
                c00131 = new C00131(continuation);
            }
        } else {
            c00131 = new C00131(continuation);
        }
        Object $result = c00131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00131.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String mainUrl = getMainUrl();
                c00131.L$0 = query;
                c00131.label = 1;
                withCustomHeaders = getWithCustomHeaders(mainUrl, c00131);
                if (withCustomHeaders == coroutine_suspended) {
                    return coroutine_suspended;
                }
                query2 = query;
                break;
                break;
            case 1:
                query2 = (String) c00131.L$0;
                ResultKt.throwOnFailure($result);
                withCustomHeaders = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String rawContent = (String) withCustomHeaders;
        String decryptedContent = decryptContent(rawContent);
        Playlist data = new IptvPlaylistParser().parseM3U(decryptedContent);
        Iterable $this$filter$iv = data.getItems();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            PlaylistItem it = (PlaylistItem) element$iv$iv;
            String title = it.getTitle();
            if (title != null ? StringsKt.contains(title, query2, true) : false) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        int $i$f$map = 0;
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
            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, channelname, AppUtils.INSTANCE.toJson(new LoadData(streamurl, channelname, posterurl, nation, key2, keyid2, userAgent2, cookie2, licenseUrl2, channel.getDrmKeys(), channel.getHeaders())), TvType.Live, false, new Function1() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    return M3UPlaylistPlayer.search$lambda$1$0(posterurl, channel, (LiveSearchResponse) obj);
                }
            }, 8, (Object) null));
            $this$map$iv = $this$map$iv2;
            $i$f$map = $i$f$map;
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
                objDecodeFromString = $this$readValue$iv$iv.readValue(url, new TypeReference<LoadData>() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$load$$inlined$parseJson$1
                });
            } catch (Throwable th3) {
                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv2.readValue(url, new TypeReference<LoadData>() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$load$$inlined$parseJson$1
                });
            }
        } else {
            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
            objDecodeFromString = $this$readValue$iv$iv3.readValue(url, new TypeReference<LoadData>() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$load$$inlined$parseJson$1
            });
        }
        LoadData data = (LoadData) objDecodeFromString;
        return MainAPIKt.newLiveStreamLoadResponse(this, data.getTitle(), url, url, new C00042(data, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$load$2 */
    /* JADX INFO: compiled from: M3UPlaylistPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/LiveStreamLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$load$2", f = "M3UPlaylistPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<LiveStreamLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ LoadData $data;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(LoadData loadData, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$data = loadData;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(this.$data, continuation);
            c00042.L$0 = obj;
            return c00042;
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

    /* JADX INFO: compiled from: M3UPlaylistPlayer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0015\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u0015\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u008f\u0001\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rHÆ\u0001J\u0014\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020.HÖ\u0081\u0004J\n\u0010/\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001c¨\u00060"}, d2 = {"Lcom/cncverse/M3UPlaylistPlayer/M3UPlaylistPlayer$LoadData;", "", "url", "", "title", "poster", "nation", "key", "keyid", "userAgent", "cookie", "licenseUrl", "drmKeys", "", "headers", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getUrl", "()Ljava/lang/String;", "getTitle", "getPoster", "getNation", "getKey", "getKeyid", "getUserAgent", "getCookie", "getLicenseUrl", "getDrmKeys", "()Ljava/util/Map;", "getHeaders", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "", "toString", "M3UPlaylistPlayerProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX WARN: Code duplicated, block: B:127:0x03da  */
    /* JADX WARN: Code duplicated, block: B:130:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:133:0x045d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:134:0x045e  */
    /* JADX WARN: Code duplicated, block: B:74:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00051 c00051;
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
        switch (c00052.label) {
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
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<LoadData>() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<LoadData>() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<LoadData>() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$$inlined$parseJson$1
                    });
                }
                LoadData loadData6 = (LoadData) objDecodeFromString;
                if (!StringsKt.contains$default(loadData6.getUrl(), "mpd", false, 2, (Object) null)) {
                    if (StringsKt.contains$default(loadData6.getUrl(), "&e=.m3u", false, 2, (Object) null)) {
                        Map headers = new LinkedHashMap();
                        headers.putAll(loadData6.getHeaders());
                        if (loadData6.getUserAgent().length() > 0) {
                            headers.put("User-Agent", loadData6.getUserAgent());
                        } else {
                            headers.put("User-Agent", "OTT Navigator/1.7.1.4 (Linux;Android 13; en; 1fin92n)");
                        }
                        if (loadData6.getCookie().length() > 0) {
                            headers.put("Cookie", loadData6.getCookie());
                        }
                        String name = getName();
                        String name2 = getName();
                        String url = loadData6.getUrl();
                        ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                        C00106 c00106 = new C00106(headers, null);
                        c00052.L$0 = SpillingKt.nullOutSpilledVariable(data);
                        c00052.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                        c00052.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                        c00052.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                        c00052.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                        c00052.L$5 = function15;
                        c00052.Z$0 = isCasting;
                        c00052.label = 5;
                        objNewExtractorLink3 = ExtractorApiKt.newExtractorLink(name, name2, url, extractorLinkType, c00106, c00052);
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
                        String userAgent = loadData6.getUserAgent().length() > 0 ? loadData6.getUserAgent() : "OTT Navigator/1.7.1.4 (Linux;Android 13; en; 1fin92n)";
                        Map headers2 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("User-Agent", userAgent)});
                        headers2.putAll(loadData6.getHeaders());
                        if (loadData6.getCookie().length() > 0) {
                            headers2.put("Cookie", loadData6.getCookie());
                        }
                        String name3 = getName();
                        String name4 = getName();
                        String url2 = loadData6.getUrl();
                        ExtractorLinkType extractorLinkType2 = ExtractorLinkType.M3U8;
                        C00117 c00117 = new C00117(headers2, null);
                        c00052.L$0 = SpillingKt.nullOutSpilledVariable(data);
                        c00052.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                        c00052.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                        c00052.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                        c00052.L$4 = SpillingKt.nullOutSpilledVariable(userAgent);
                        c00052.L$5 = SpillingKt.nullOutSpilledVariable(headers2);
                        c00052.L$6 = function15;
                        c00052.Z$0 = isCasting;
                        c00052.label = 6;
                        objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name3, name4, url2, extractorLinkType2, c00117, c00052);
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
                    } else {
                        headers3.put("User-Agent", "OTT Navigator/1.7.1.4 (Linux;Android 13; en; 1fin92n)");
                    }
                    if (loadData6.getCookie().length() > 0) {
                        headers3.put("Cookie", loadData6.getCookie());
                    }
                    String name5 = getName();
                    String title = loadData6.getTitle();
                    String url3 = loadData6.getUrl();
                    ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                    C00128 c00128 = new C00128(headers3, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                    c00052.L$5 = function15;
                    c00052.Z$0 = isCasting;
                    c00052.label = 7;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(name5, title, url3, infer_type, c00128, c00052);
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
                } else {
                    headers4.put("User-Agent", "OTT Navigator/1.7.1.4 (Linux;Android 13; en; 1fin92n)");
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
                        C00062 c00062 = new C00062(headers4, playerKey, playerKid, null);
                        c00052.L$0 = SpillingKt.nullOutSpilledVariable(data);
                        c00052.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                        c00052.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                        c00052.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                        c00052.L$4 = SpillingKt.nullOutSpilledVariable(headers4);
                        c00052.L$5 = SpillingKt.nullOutSpilledVariable(normalizedKey3);
                        c00052.L$6 = SpillingKt.nullOutSpilledVariable(normalizedKid2);
                        c00052.L$7 = SpillingKt.nullOutSpilledVariable(playerKey);
                        c00052.L$8 = SpillingKt.nullOutSpilledVariable(playerKid);
                        c00052.L$9 = function15;
                        c00052.Z$0 = isCasting;
                        c00052.I$0 = i2;
                        c00052.I$1 = i3;
                        c00052.label = 1;
                        objNewDrmExtractorLink2 = ExtractorApiKt.newDrmExtractorLink(name6, normalizedKey4, playerKey2, infer_type2, clearkey_uuid, c00062, c00052);
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
                    C00062 c00063 = new C00062(headers4, playerKey, playerKid, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(headers4);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(normalizedKey5);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(normalizedKid3);
                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(playerKey);
                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(playerKid);
                    c00052.L$9 = function15;
                    c00052.Z$0 = isCasting;
                    c00052.I$0 = i2;
                    c00052.I$1 = i3;
                    c00052.label = 1;
                    objNewDrmExtractorLink2 = ExtractorApiKt.newDrmExtractorLink(name7, normalizedKey6, playerKey3, infer_type3, clearkey_uuid2, c00063, c00052);
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
                    C00095 c00095 = new C00095(headers4, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(headers4);
                    c00052.L$5 = function15;
                    c00052.Z$0 = isCasting;
                    c00052.I$0 = i2;
                    c00052.I$1 = i4;
                    c00052.label = 4;
                    objNewExtractorLink4 = ExtractorApiKt.newExtractorLink(name8, name9, url4, extractorLinkType3, c00095, c00052);
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
                    C00073 c00073 = new C00073(headers4, keyBase64, drmKidBase64, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(headers4);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(mpdStr);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(regex3);
                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(matchResult);
                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(drmKid);
                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(drmKidBytes);
                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(drmKidBase64);
                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(keyBase64);
                    c00052.L$12 = function15;
                    c00052.Z$0 = isCasting;
                    c00052.I$0 = i2;
                    c00052.I$1 = i4;
                    c00052.label = 2;
                    objNewDrmExtractorLink = ExtractorApiKt.newDrmExtractorLink(name10, drmKidBase65, keyBase65, infer_type4, clearkey_uuid3, c00073, c00052);
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
                C00084 c00084 = new C00084(headers4, loadData6, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(function15);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(loadData6);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(headers4);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(mpdStr);
                c00052.L$6 = SpillingKt.nullOutSpilledVariable(regex3);
                c00052.L$7 = SpillingKt.nullOutSpilledVariable(matchResult);
                c00052.L$8 = SpillingKt.nullOutSpilledVariable(drmKid);
                c00052.L$9 = SpillingKt.nullOutSpilledVariable(drmKidBytes);
                c00052.L$10 = SpillingKt.nullOutSpilledVariable(drmKidBase64);
                c00052.L$11 = SpillingKt.nullOutSpilledVariable(keyBase64);
                c00052.L$12 = function15;
                c00052.Z$0 = isCasting;
                c00052.I$0 = i2;
                c00052.I$1 = i4;
                c00052.label = 3;
                Object objNewDrmExtractorLink3 = ExtractorApiKt.newDrmExtractorLink(name11, name12, url5, infer_type5, clearkey_uuid4, c00084, c00052);
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
                int i5 = c00052.I$1;
                int i6 = c00052.I$0;
                boolean z = c00052.Z$0;
                Function1<? super ExtractorLink, Unit> function16 = (Function1) c00052.L$9;
                ResultKt.throwOnFailure($result);
                function15 = function16;
                objNewDrmExtractorLink2 = $result;
                function15.invoke(objNewDrmExtractorLink2);
                return Boxing.boxBoolean(true);
            case 2:
                int i7 = c00052.I$1;
                int i8 = c00052.I$0;
                boolean z2 = c00052.Z$0;
                function14 = (Function1) c00052.L$12;
                ResultKt.throwOnFailure($result);
                objNewDrmExtractorLink = $result;
                function14.invoke(objNewDrmExtractorLink);
                return Boxing.boxBoolean(true);
            case 3:
                int i9 = c00052.I$1;
                int i10 = c00052.I$0;
                boolean z3 = c00052.Z$0;
                function11 = (Function1) c00052.L$12;
                loadData5 = (LoadData) c00052.L$3;
                Function1<? super ExtractorLink, Unit> function17 = (Function1) c00052.L$2;
                function12 = (Function1) c00052.L$1;
                ResultKt.throwOnFailure($result);
                function13 = function17;
                obj2 = $result;
                function11.invoke(obj2);
                return Boxing.boxBoolean(true);
            case 4:
                int i11 = c00052.I$1;
                int i12 = c00052.I$0;
                boolean z4 = c00052.Z$0;
                Function1<? super ExtractorLink, Unit> function18 = (Function1) c00052.L$5;
                loadData4 = (LoadData) c00052.L$3;
                Function1<? super ExtractorLink, Unit> function19 = (Function1) c00052.L$2;
                function9 = (Function1) c00052.L$1;
                data5 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result);
                function10 = function19;
                function15 = function18;
                objNewExtractorLink4 = $result;
                function15.invoke(objNewExtractorLink4);
                return Boxing.boxBoolean(true);
            case 5:
                isCasting4 = c00052.Z$0;
                function8 = (Function1) c00052.L$5;
                loadData3 = (LoadData) c00052.L$3;
                function15 = (Function1) c00052.L$2;
                function7 = (Function1) c00052.L$1;
                data4 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink3 = $result;
                function8.invoke(objNewExtractorLink3);
                return Boxing.boxBoolean(true);
            case 6:
                isCasting3 = c00052.Z$0;
                function6 = (Function1) c00052.L$6;
                loadData2 = (LoadData) c00052.L$3;
                function15 = (Function1) c00052.L$2;
                function5 = (Function1) c00052.L$1;
                data3 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink2 = $result;
                function6.invoke(objNewExtractorLink2);
                return Boxing.boxBoolean(true);
            case 7:
                isCasting2 = c00052.Z$0;
                function4 = (Function1) c00052.L$5;
                loadData = (LoadData) c00052.L$3;
                function15 = (Function1) c00052.L$2;
                function3 = (Function1) c00052.L$1;
                data2 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function4.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$2 */
    /* JADX INFO: compiled from: M3UPlaylistPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/DrmExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$2", f = "M3UPlaylistPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00062 extends SuspendLambda implements Function2<DrmExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        final /* synthetic */ String $playerKey;
        final /* synthetic */ String $playerKid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00062(Map<String, String> map, String str, String str2, Continuation<? super C00062> continuation) {
            super(2, continuation);
            this.$headers = map;
            this.$playerKey = str;
            this.$playerKid = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00062 = new C00062(this.$headers, this.$playerKey, this.$playerKid, continuation);
            c00062.L$0 = obj;
            return c00062;
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

    /* JADX INFO: renamed from: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$3 */
    /* JADX INFO: compiled from: M3UPlaylistPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/DrmExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$3", f = "M3UPlaylistPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00073 extends SuspendLambda implements Function2<DrmExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $drmKidBase64;
        final /* synthetic */ Map<String, String> $headers;
        final /* synthetic */ String $keyBase64;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00073(Map<String, String> map, String str, String str2, Continuation<? super C00073> continuation) {
            super(2, continuation);
            this.$headers = map;
            this.$keyBase64 = str;
            this.$drmKidBase64 = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00073 = new C00073(this.$headers, this.$keyBase64, this.$drmKidBase64, continuation);
            c00073.L$0 = obj;
            return c00073;
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

    /* JADX INFO: renamed from: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$4 */
    /* JADX INFO: compiled from: M3UPlaylistPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/DrmExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$4", f = "M3UPlaylistPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00084 extends SuspendLambda implements Function2<DrmExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        final /* synthetic */ LoadData $loadData;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00084(Map<String, String> map, LoadData loadData, Continuation<? super C00084> continuation) {
            super(2, continuation);
            this.$headers = map;
            this.$loadData = loadData;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00084 = new C00084(this.$headers, this.$loadData, continuation);
            c00084.L$0 = obj;
            return c00084;
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

    /* JADX INFO: renamed from: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$5 */
    /* JADX INFO: compiled from: M3UPlaylistPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$5", f = "M3UPlaylistPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00095 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00095(Map<String, String> map, Continuation<? super C00095> continuation) {
            super(2, continuation);
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00095 = new C00095(this.$headers, continuation);
            c00095.L$0 = obj;
            return c00095;
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

    /* JADX INFO: renamed from: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$6 */
    /* JADX INFO: compiled from: M3UPlaylistPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$6", f = "M3UPlaylistPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00106 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00106(Map<String, String> map, Continuation<? super C00106> continuation) {
            super(2, continuation);
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00106 = new C00106(this.$headers, continuation);
            c00106.L$0 = obj;
            return c00106;
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

    /* JADX INFO: renamed from: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$7 */
    /* JADX INFO: compiled from: M3UPlaylistPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$7", f = "M3UPlaylistPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00117 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00117(Map<String, String> map, Continuation<? super C00117> continuation) {
            super(2, continuation);
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00117 = new C00117(this.$headers, continuation);
            c00117.L$0 = obj;
            return c00117;
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

    /* JADX INFO: renamed from: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$8 */
    /* JADX INFO: compiled from: M3UPlaylistPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$loadLinks$8", f = "M3UPlaylistPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00128 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00128(Map<String, String> map, Continuation<? super C00128> continuation) {
            super(2, continuation);
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00128 = new C00128(this.$headers, continuation);
            c00128.L$0 = obj;
            return c00128;
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

    /* JADX INFO: renamed from: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$getVideoInterceptor$1 */
    /* JADX INFO: compiled from: M3UPlaylistPlayer.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"com/cncverse/M3UPlaylistPlayer/M3UPlaylistPlayer$getVideoInterceptor$1", "Lokhttp3/Interceptor;", "currentCookie", "", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "M3UPlaylistPlayerProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nM3UPlaylistPlayer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 M3UPlaylistPlayer.kt\ncom/cncverse/M3UPlaylistPlayer/M3UPlaylistPlayer$getVideoInterceptor$1\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1031:1\n221#2,2:1032\n1586#3:1034\n1661#3,3:1035\n1915#3,2:1038\n1915#3,2:1040\n*S KotlinDebug\n*F\n+ 1 M3UPlaylistPlayer.kt\ncom/cncverse/M3UPlaylistPlayer/M3UPlaylistPlayer$getVideoInterceptor$1\n*L\n579#1:1032,2\n596#1:1034\n596#1:1035,3\n600#1:1038,2\n608#1:1040,2\n*E\n"})
    public static final class C00021 implements Interceptor {
        final /* synthetic */ ExtractorLink $extractorLink;
        private String currentCookie;

        C00021(ExtractorLink $extractorLink) {
            this.$extractorLink = $extractorLink;
            this.currentCookie = (String) $extractorLink.getHeaders().get("Cookie");
        }

        public Response intercept(Interceptor.Chain chain) {
            List newCookies;
            Request request = chain.request();
            Request.Builder builder = request.newBuilder();
            String rangeHeader = request.header("Range");
            builder.headers(new Headers.Builder().build());
            if (rangeHeader != null) {
                builder.addHeader("Range", rangeHeader);
            }
            Map $this$forEach$iv = this.$extractorLink.getHeaders();
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                String key = (String) element$iv.getKey();
                String value = (String) element$iv.getValue();
                builder.addHeader(key, value);
            }
            String str = this.currentCookie;
            if (!(str == null || str.length() == 0)) {
                builder.removeHeader("Cookie");
                String str2 = this.currentCookie;
                Intrinsics.checkNotNull(str2);
                builder.addHeader("Cookie", str2);
            }
            Request request2 = builder.build();
            Response response = chain.proceed(request2);
            Iterable setCookies = response.headers("Set-Cookie");
            if (!((Collection) setCookies).isEmpty()) {
                Iterable $this$map$iv = setCookies;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    String it = (String) item$iv$iv;
                    destination$iv$iv.add(StringsKt.substringBefore$default(it, ";", (String) null, 2, (Object) null));
                    request2 = request2;
                    builder = builder;
                }
                List newCookies2 = (List) destination$iv$iv;
                Map cookieMap = new LinkedHashMap();
                String str3 = this.currentCookie;
                if (str3 == null || str3.length() == 0) {
                    newCookies = newCookies2;
                } else {
                    String str4 = this.currentCookie;
                    Intrinsics.checkNotNull(str4);
                    Iterable $this$forEach$iv2 = StringsKt.split$default(str4, new String[]{";"}, false, 0, 6, (Object) null);
                    for (Object element$iv2 : $this$forEach$iv2) {
                        String it2 = (String) element$iv2;
                        List parts = StringsKt.split$default(StringsKt.trim(it2).toString(), new String[]{"="}, false, 2, 2, (Object) null);
                        List newCookies3 = newCookies2;
                        if (parts.size() == 2) {
                            cookieMap.put(parts.get(0), parts.get(1));
                        }
                        newCookies2 = newCookies3;
                    }
                    newCookies = newCookies2;
                }
                List $this$forEach$iv3 = newCookies;
                for (Object element$iv3 : $this$forEach$iv3) {
                    String it3 = (String) element$iv3;
                    List parts2 = StringsKt.split$default(StringsKt.trim(it3).toString(), new String[]{"="}, false, 2, 2, (Object) null);
                    if (parts2.size() == 2) {
                        cookieMap.put(parts2.get(0), parts2.get(1));
                    }
                }
                Iterable $this$forEach$iv4 = cookieMap.entrySet();
                this.currentCookie = CollectionsKt.joinToString$default($this$forEach$iv4, "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayer$getVideoInterceptor$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return M3UPlaylistPlayer.C00021.intercept$lambda$4((Map.Entry) obj);
                    }
                }, 30, (Object) null);
            }
            return response;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence intercept$lambda$4(Map.Entry it) {
            return ((String) it.getKey()) + '=' + ((String) it.getValue());
        }
    }

    @Nullable
    public Interceptor getVideoInterceptor(@NotNull ExtractorLink extractorLink) {
        return new C00021(extractorLink);
    }
}
