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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
import com.lagradost.cloudstream3.Episode;
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
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
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
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CineTvProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CineTvProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\u0018\u0000 g2\u00020\u0001:\u000eghijklmnopqrstB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0002J \u0010/\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005H\u0002J\u0010\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005H\u0002J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0002J\u0018\u0010:\u001a\u00020\u00052\b\b\u0002\u0010;\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010<J&\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001d2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u0010<J\u001a\u0010>\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010@\u001a\u00020AH\u0082@¢\u0006\u0002\u0010BJ(\u0010C\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010\u001e2\u0006\u0010E\u001a\u00020A2\b\b\u0002\u0010@\u001a\u00020AH\u0082@¢\u0006\u0002\u0010FJ\"\u0010G\u001a\u0004\u0018\u00010?2\u0006\u0010H\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020AH\u0082@¢\u0006\u0002\u0010IJ\"\u0010J\u001a\u0004\u0018\u00010K2\u0006\u00100\u001a\u00020\u00052\b\b\u0002\u0010L\u001a\u00020AH\u0082@¢\u0006\u0002\u0010IJ\u001e\u0010O\u001a\u00020Q2\u0006\u0010R\u001a\u00020A2\u0006\u0010S\u001a\u00020TH\u0096@¢\u0006\u0002\u0010UJ\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u001e2\u0006\u0010X\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010<J\u0018\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u00103\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010<JF\u0010[\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\u000e2\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020a0_2\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020a0_H\u0096@¢\u0006\u0002\u0010cJ\b\u0010d\u001a\u00020aH\u0002J\b\u0010e\u001a\u00020aH\u0002J\u0010\u0010f\u001a\u00020a2\u0006\u00103\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010P¨\u0006u"}, d2 = {"Lcom/cncverse/CineTvProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "random", "Ljava/security/SecureRandom;", "generateDeviceId", "brandModels", "", "", "randomBrandModel", "Lcom/cncverse/CineTvProvider$BrandModel;", "deviceId", "brandModel", "mobMfr", "mobModel", "gaid", "token", "mapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "des3Decrypt", "encryptedText", "md5Hash", "text", "generateSign", "curTime", "generateP2pToken", "vodId", "timestamp", "signVideoUrl", "url", "getVideoInterceptor", "Lokhttp3/Interceptor;", "extractorLink", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "aesDecrypt", "encryptedBase64", "fetchDeviceToken", "invitedBy", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHeaders", "searchRecommend", "Lcom/cncverse/CineTvProvider$ApiResponse;", "pageNumber", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "topicVodList", "Lcom/cncverse/CineTvProvider$VodItem;", "topicId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchVod", "keyword", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVodInfo", "Lcom/cncverse/CineTvProvider$VodInfoResponse;", "audioType", "mainPage", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showSubscriptionPopupIfNeeded", "showTelegramPopup", "openInExternalBrowser", "Companion", "BrandModel", "VodItem", "ApiResponse", "TopicResult", "TopicApiResponse", "InitResponse", "InitResult", "UserInfo", "VodCollection", "AudioTypeOption", "SeriesInfo", "VodInfoResult", "VodInfoResponse", "CineTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCineTvProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CineTvProvider.kt\ncom/cncverse/CineTvProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1021:1\n1#2:1022\n1#2:1036\n1#2:1051\n1#2:1066\n1#2:1081\n1#2:1096\n221#3,2:1023\n221#3,2:1038\n221#3,2:1053\n221#3,2:1068\n221#3,2:1083\n116#4:1025\n54#4:1026\n117#4:1027\n61#4,8:1028\n71#4:1037\n116#4:1040\n54#4:1041\n117#4:1042\n61#4,8:1043\n71#4:1052\n116#4:1055\n54#4:1056\n117#4:1057\n61#4,8:1058\n71#4:1067\n116#4:1070\n54#4:1071\n117#4:1072\n61#4,8:1073\n71#4:1082\n116#4:1085\n54#4:1086\n117#4:1087\n61#4,8:1088\n71#4:1097\n1915#5,2:1098\n1915#5,2:1100\n1586#5:1102\n1661#5,3:1103\n1586#5:1106\n1661#5,3:1107\n1586#5:1110\n1661#5,3:1111\n*S KotlinDebug\n*F\n+ 1 CineTvProvider.kt\ncom/cncverse/CineTvProvider\n*L\n375#1:1036\n447#1:1051\n482#1:1066\n518#1:1081\n558#1:1096\n357#1:1023,2\n436#1:1038,2\n471#1:1053,2\n507#1:1068,2\n547#1:1083,2\n375#1:1025\n375#1:1026\n375#1:1027\n375#1:1028,8\n375#1:1037\n447#1:1040\n447#1:1041\n447#1:1042\n447#1:1043,8\n447#1:1052\n482#1:1055\n482#1:1056\n482#1:1057\n482#1:1058,8\n482#1:1067\n518#1:1070\n518#1:1071\n518#1:1072\n518#1:1073,8\n518#1:1082\n558#1:1085\n558#1:1086\n558#1:1087\n558#1:1088,8\n558#1:1097\n582#1:1098,2\n625#1:1100,2\n677#1:1102\n677#1:1103,3\n678#1:1106\n678#1:1107,3\n700#1:1110\n700#1:1111,3\n*E\n"})
public final class CineTvProvider extends MainAPI {
    private static final long BROWSER_DEBOUNCE_MS = 10000;

    @NotNull
    private static final String OMG10 = "aHR0cHM6Ly9vbWcxMC5jb20vNC8xMTEwNDQ4OQ==";

    @Nullable
    private static Context context;
    private static volatile boolean csGuardWasEverActive;
    private static volatile long lastBrowserOpenMs;
    private static volatile boolean subscriptionPopupShown;
    private static volatile boolean telegramPopupShown;

    @Nullable
    private String token;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String SECRET_KEY_ENCRYPTED = "MxASAkl/yHTGg+/Tw1R7u96nGqkWsOZ2";

    @NotNull
    private static final String DES_KEY = "dsawdf634eebGFHITR5UT9kS0";

    @NotNull
    private static final String DES_IV = "32456738";

    @NotNull
    private static final String AES_KEY = "0123456789123456";

    @NotNull
    private static final String AES_IV = "2015030120123456";

    @NotNull
    private static final String WS_SECRET = "00b5f05c40b4f1d91dbc9b3fd8a059ef";

    @NotNull
    private String mainUrl = "https://filmin.ajfysu.com";

    @NotNull
    private String name = "CineTv";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "ta";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private final SecureRandom random = new SecureRandom();

    @NotNull
    private final Map<String, List<String>> brandModels = MapsKt.mapOf(new Pair[]{TuplesKt.to("Samsung", CollectionsKt.listOf(new String[]{"SM-S918B", "SM-A528B", "SM-M336B"})), TuplesKt.to("Xiaomi", CollectionsKt.listOf(new String[]{"2201117TI", "M2012K11AI", "Redmi Note 11"})), TuplesKt.to("OnePlus", CollectionsKt.listOf(new String[]{"LE2111", "CPH2449", "IN2023"})), TuplesKt.to("Google", CollectionsKt.listOf(new String[]{"Pixel 6", "Pixel 7", "Pixel 8"})), TuplesKt.to("Realme", CollectionsKt.listOf(new String[]{"RMX3085", "RMX3360", "RMX3551"}))});

    @NotNull
    private final String deviceId = generateDeviceId();

    @NotNull
    private final BrandModel brandModel = randomBrandModel();

    @NotNull
    private final String mobMfr = this.brandModel.getBrand();

    @NotNull
    private final String mobModel = this.brandModel.getModel();

    @NotNull
    private final String gaid = "";

    @NotNull
    private final ObjectMapper mapper = ExtensionsKt.jacksonObjectMapper();

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("1", "Recommended")});

    /* JADX INFO: renamed from: com.cncverse.CineTvProvider$getHeaders$1 */
    /* JADX INFO: compiled from: CineTvProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CineTvProvider", f = "CineTvProvider.kt", i = {0, 0}, l = {390}, m = "getHeaders", n = {"curTime", "timestamp"}, nl = {394}, s = {"L$0", "L$1"}, v = 2)
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
            return CineTvProvider.this.getHeaders(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.CineTvProvider$getMainPage$1 */
    /* JADX INFO: compiled from: CineTvProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CineTvProvider", f = "CineTvProvider.kt", i = {0, 0, 1, 1}, l = {575, 577}, m = "getMainPage", n = {"request", "page", "request", "page"}, nl = {577, 574}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 2)
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
            return CineTvProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.CineTvProvider$getVodInfo$1 */
    /* JADX INFO: compiled from: CineTvProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CineTvProvider", f = "CineTvProvider.kt", i = {0, 0, 0, 0}, l = {531}, m = "getVodInfo", n = {"vodId", "url", "curTime", "audioType"}, nl = {534}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
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
            return CineTvProvider.this.getVodInfo(null, 0, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.CineTvProvider$load$1 */
    /* JADX INFO: compiled from: CineTvProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CineTvProvider", f = "CineTvProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {669, 689, 708}, m = "load", n = {"url", "parts", "vodId", "typePid", "url", "parts", "vodId", "vodInfoResponse", "vodInfo", "name", "posterUrl", "year", "plot", "score", "tags", "actors", "movieData", "typePid", "url", "parts", "vodId", "vodInfoResponse", "vodInfo", "name", "posterUrl", "year", "plot", "score", "tags", "actors", "episodes", "typePid"}, nl = {670, 700, 717}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "I$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
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

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CineTvProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.CineTvProvider$loadLinks$1 */
    /* JADX INFO: compiled from: CineTvProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CineTvProvider", f = "CineTvProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {751, 764}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "parts", "vodId", "isCasting", "collection", "data", "subtitleCallback", "callback", "parts", "vodId", "vodInfoResponse", "vodInfo", "episode", "videoUrl", "signedUrl", "isCasting", "collection"}, nl = {752, 763}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0", "I$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        int I$0;
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
            return CineTvProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.CineTvProvider$search$1 */
    /* JADX INFO: compiled from: CineTvProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CineTvProvider", f = "CineTvProvider.kt", i = {0}, l = {620}, m = "search", n = {"query"}, nl = {621}, s = {"L$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CineTvProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.CineTvProvider$searchRecommend$1 */
    /* JADX INFO: compiled from: CineTvProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CineTvProvider", f = "CineTvProvider.kt", i = {0, 0, 0}, l = {426}, m = "searchRecommend", n = {"url", "curTime", "pageNumber"}, nl = {428}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CineTvProvider.this.searchRecommend(0, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.CineTvProvider$searchVod$1 */
    /* JADX INFO: compiled from: CineTvProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CineTvProvider", f = "CineTvProvider.kt", i = {0, 0, 0, 0}, l = {496}, m = "searchVod", n = {"keyword", "url", "curTime", "pageNumber"}, nl = {498}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CineTvProvider.this.searchVod(null, 0, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.CineTvProvider$topicVodList$1 */
    /* JADX INFO: compiled from: CineTvProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CineTvProvider", f = "CineTvProvider.kt", i = {0, 0, 0, 0}, l = {460}, m = "topicVodList", n = {"url", "curTime", "topicId", "pageNumber"}, nl = {462}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 2)
    static final class C00111 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00111(Continuation<? super C00111> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CineTvProvider.this.topicVodList(0, 0, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: CineTvProvider.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/cncverse/CineTvProvider$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "SECRET_KEY_ENCRYPTED", "", "DES_KEY", "DES_IV", "AES_KEY", "AES_IV", "WS_SECRET", "OMG10", "lastBrowserOpenMs", "", "telegramPopupShown", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "CineTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nCineTvProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CineTvProvider.kt\ncom/cncverse/CineTvProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1021:1\n1#2:1022\n*E\n"})
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
                CineTvProvider.csGuardWasEverActive = true;
            }
            return CineTvProvider.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.CineTvProvider$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CineTvProvider.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getContext() {
            return CineTvProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            CineTvProvider.context = context;
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

    private final String generateDeviceId() {
        byte[] bytes = new byte[16];
        this.random.nextBytes(bytes);
        return ArraysKt.joinToString$default(bytes, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return CineTvProvider.generateDeviceId$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence generateDeviceId$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX INFO: compiled from: CineTvProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/cncverse/CineTvProvider$BrandModel;", "", "brand", "", "model", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBrand", "()Ljava/lang/String;", "getModel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CineTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class BrandModel {

        @NotNull
        private final String brand;

        @NotNull
        private final String model;

        public static /* synthetic */ BrandModel copy$default(BrandModel brandModel, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = brandModel.brand;
            }
            if ((i & 2) != 0) {
                str2 = brandModel.model;
            }
            return brandModel.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getBrand() {
            return this.brand;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getModel() {
            return this.model;
        }

        @NotNull
        public final BrandModel copy(@NotNull String brand, @NotNull String model) {
            return new BrandModel(brand, model);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BrandModel)) {
                return false;
            }
            BrandModel brandModel = (BrandModel) other;
            return Intrinsics.areEqual(this.brand, brandModel.brand) && Intrinsics.areEqual(this.model, brandModel.model);
        }

        public int hashCode() {
            return (this.brand.hashCode() * 31) + this.model.hashCode();
        }

        @NotNull
        public String toString() {
            return "BrandModel(brand=" + this.brand + ", model=" + this.model + ')';
        }

        public BrandModel(@NotNull String brand, @NotNull String model) {
            this.brand = brand;
            this.model = model;
        }

        @NotNull
        public final String getBrand() {
            return this.brand;
        }

        @NotNull
        public final String getModel() {
            return this.model;
        }
    }

    private final BrandModel randomBrandModel() {
        String brand = (String) CollectionsKt.random(this.brandModels.keySet(), Random.Default);
        List<String> list = this.brandModels.get(brand);
        Intrinsics.checkNotNull(list);
        String model = (String) CollectionsKt.random(list, Random.Default);
        return new BrandModel(brand, model);
    }

    /* JADX INFO: compiled from: CineTvProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B©\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00103\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J°\u0001\u00107\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u000b\u001a\u00020\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00108J\u0014\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010<\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010=\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\"\u0010 R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018¨\u0006>"}, d2 = {"Lcom/cncverse/CineTvProvider$VodItem;", "", "id", "", "vodName", "", "vodPic", "vodYear", "vodActor", "vodDirector", "vodBlurb", "typePid", "vodTotal", "vodSerial", "vodDoubanScore", "", "vodEn", "audioLanguageTag", "vodArea", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getVodName", "()Ljava/lang/String;", "getVodPic", "getVodYear", "getVodActor", "getVodDirector", "getVodBlurb", "getTypePid", "getVodTotal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVodSerial", "getVodDoubanScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVodEn", "getAudioLanguageTag", "getVodArea", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/cncverse/CineTvProvider$VodItem;", "equals", "", "other", "hashCode", "toString", "CineTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class VodItem {

        @JsonProperty("audio_language_tag")
        @Nullable
        private final String audioLanguageTag;

        @JsonProperty("id")
        private final int id;

        @JsonProperty("type_pid")
        private final int typePid;

        @JsonProperty("vod_actor")
        @Nullable
        private final String vodActor;

        @JsonProperty("vod_area")
        @Nullable
        private final String vodArea;

        @JsonProperty("vod_blurb")
        @Nullable
        private final String vodBlurb;

        @JsonProperty("vod_director")
        @Nullable
        private final String vodDirector;

        @JsonProperty("vod_douban_score")
        @Nullable
        private final Double vodDoubanScore;

        @JsonProperty("vod_en")
        @Nullable
        private final String vodEn;

        @JsonProperty("vod_name")
        @NotNull
        private final String vodName;

        @JsonProperty("vod_pic")
        @Nullable
        private final String vodPic;

        @JsonProperty("vod_serial")
        @Nullable
        private final Integer vodSerial;

        @JsonProperty("vod_total")
        @Nullable
        private final Integer vodTotal;

        @JsonProperty("vod_year")
        @Nullable
        private final String vodYear;

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getVodSerial() {
            return this.vodSerial;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Double getVodDoubanScore() {
            return this.vodDoubanScore;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getVodEn() {
            return this.vodEn;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getAudioLanguageTag() {
            return this.audioLanguageTag;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getVodArea() {
            return this.vodArea;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getVodName() {
            return this.vodName;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getVodPic() {
            return this.vodPic;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getVodYear() {
            return this.vodYear;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getVodActor() {
            return this.vodActor;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getVodDirector() {
            return this.vodDirector;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getVodBlurb() {
            return this.vodBlurb;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getTypePid() {
            return this.typePid;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getVodTotal() {
            return this.vodTotal;
        }

        @NotNull
        public final VodItem copy(@JsonProperty("id") int id, @JsonProperty("vod_name") @NotNull String vodName, @JsonProperty("vod_pic") @Nullable String vodPic, @JsonProperty("vod_year") @Nullable String vodYear, @JsonProperty("vod_actor") @Nullable String vodActor, @JsonProperty("vod_director") @Nullable String vodDirector, @JsonProperty("vod_blurb") @Nullable String vodBlurb, @JsonProperty("type_pid") int typePid, @JsonProperty("vod_total") @Nullable Integer vodTotal, @JsonProperty("vod_serial") @Nullable Integer vodSerial, @JsonProperty("vod_douban_score") @Nullable Double vodDoubanScore, @JsonProperty("vod_en") @Nullable String vodEn, @JsonProperty("audio_language_tag") @Nullable String audioLanguageTag, @JsonProperty("vod_area") @Nullable String vodArea) {
            return new VodItem(id, vodName, vodPic, vodYear, vodActor, vodDirector, vodBlurb, typePid, vodTotal, vodSerial, vodDoubanScore, vodEn, audioLanguageTag, vodArea);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VodItem)) {
                return false;
            }
            VodItem vodItem = (VodItem) other;
            return this.id == vodItem.id && Intrinsics.areEqual(this.vodName, vodItem.vodName) && Intrinsics.areEqual(this.vodPic, vodItem.vodPic) && Intrinsics.areEqual(this.vodYear, vodItem.vodYear) && Intrinsics.areEqual(this.vodActor, vodItem.vodActor) && Intrinsics.areEqual(this.vodDirector, vodItem.vodDirector) && Intrinsics.areEqual(this.vodBlurb, vodItem.vodBlurb) && this.typePid == vodItem.typePid && Intrinsics.areEqual(this.vodTotal, vodItem.vodTotal) && Intrinsics.areEqual(this.vodSerial, vodItem.vodSerial) && Intrinsics.areEqual(this.vodDoubanScore, vodItem.vodDoubanScore) && Intrinsics.areEqual(this.vodEn, vodItem.vodEn) && Intrinsics.areEqual(this.audioLanguageTag, vodItem.audioLanguageTag) && Intrinsics.areEqual(this.vodArea, vodItem.vodArea);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((this.id * 31) + this.vodName.hashCode()) * 31) + (this.vodPic == null ? 0 : this.vodPic.hashCode())) * 31) + (this.vodYear == null ? 0 : this.vodYear.hashCode())) * 31) + (this.vodActor == null ? 0 : this.vodActor.hashCode())) * 31) + (this.vodDirector == null ? 0 : this.vodDirector.hashCode())) * 31) + (this.vodBlurb == null ? 0 : this.vodBlurb.hashCode())) * 31) + this.typePid) * 31) + (this.vodTotal == null ? 0 : this.vodTotal.hashCode())) * 31) + (this.vodSerial == null ? 0 : this.vodSerial.hashCode())) * 31) + (this.vodDoubanScore == null ? 0 : this.vodDoubanScore.hashCode())) * 31) + (this.vodEn == null ? 0 : this.vodEn.hashCode())) * 31) + (this.audioLanguageTag == null ? 0 : this.audioLanguageTag.hashCode())) * 31) + (this.vodArea != null ? this.vodArea.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("VodItem(id=").append(this.id).append(", vodName=").append(this.vodName).append(", vodPic=").append(this.vodPic).append(", vodYear=").append(this.vodYear).append(", vodActor=").append(this.vodActor).append(", vodDirector=").append(this.vodDirector).append(", vodBlurb=").append(this.vodBlurb).append(", typePid=").append(this.typePid).append(", vodTotal=").append(this.vodTotal).append(", vodSerial=").append(this.vodSerial).append(", vodDoubanScore=").append(this.vodDoubanScore).append(", vodEn=");
            sb.append(this.vodEn).append(", audioLanguageTag=").append(this.audioLanguageTag).append(", vodArea=").append(this.vodArea).append(')');
            return sb.toString();
        }

        public VodItem(@JsonProperty("id") int id, @JsonProperty("vod_name") @NotNull String vodName, @JsonProperty("vod_pic") @Nullable String vodPic, @JsonProperty("vod_year") @Nullable String vodYear, @JsonProperty("vod_actor") @Nullable String vodActor, @JsonProperty("vod_director") @Nullable String vodDirector, @JsonProperty("vod_blurb") @Nullable String vodBlurb, @JsonProperty("type_pid") int typePid, @JsonProperty("vod_total") @Nullable Integer vodTotal, @JsonProperty("vod_serial") @Nullable Integer vodSerial, @JsonProperty("vod_douban_score") @Nullable Double vodDoubanScore, @JsonProperty("vod_en") @Nullable String vodEn, @JsonProperty("audio_language_tag") @Nullable String audioLanguageTag, @JsonProperty("vod_area") @Nullable String vodArea) {
            this.id = id;
            this.vodName = vodName;
            this.vodPic = vodPic;
            this.vodYear = vodYear;
            this.vodActor = vodActor;
            this.vodDirector = vodDirector;
            this.vodBlurb = vodBlurb;
            this.typePid = typePid;
            this.vodTotal = vodTotal;
            this.vodSerial = vodSerial;
            this.vodDoubanScore = vodDoubanScore;
            this.vodEn = vodEn;
            this.audioLanguageTag = audioLanguageTag;
            this.vodArea = vodArea;
        }

        public final int getId() {
            return this.id;
        }

        @NotNull
        public final String getVodName() {
            return this.vodName;
        }

        @Nullable
        public final String getVodPic() {
            return this.vodPic;
        }

        @Nullable
        public final String getVodYear() {
            return this.vodYear;
        }

        @Nullable
        public final String getVodActor() {
            return this.vodActor;
        }

        @Nullable
        public final String getVodDirector() {
            return this.vodDirector;
        }

        @Nullable
        public final String getVodBlurb() {
            return this.vodBlurb;
        }

        public final int getTypePid() {
            return this.typePid;
        }

        @Nullable
        public final Integer getVodTotal() {
            return this.vodTotal;
        }

        @Nullable
        public final Integer getVodSerial() {
            return this.vodSerial;
        }

        @Nullable
        public final Double getVodDoubanScore() {
            return this.vodDoubanScore;
        }

        @Nullable
        public final String getVodEn() {
            return this.vodEn;
        }

        @Nullable
        public final String getAudioLanguageTag() {
            return this.audioLanguageTag;
        }

        @Nullable
        public final String getVodArea() {
            return this.vodArea;
        }
    }

    /* JADX INFO: compiled from: CineTvProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/cncverse/CineTvProvider$ApiResponse;", "", "code", "", "message", "", "result", "", "Lcom/cncverse/CineTvProvider$VodItem;", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getResult", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CineTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ApiResponse {

        @JsonProperty("code")
        private final int code;

        @JsonProperty("message")
        @NotNull
        private final String message;

        @JsonProperty("result")
        @Nullable
        private final List<VodItem> result;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ApiResponse copy$default(ApiResponse apiResponse, int i, String str, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = apiResponse.code;
            }
            if ((i2 & 2) != 0) {
                str = apiResponse.message;
            }
            if ((i2 & 4) != 0) {
                list = apiResponse.result;
            }
            return apiResponse.copy(i, str, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        public final List<VodItem> component3() {
            return this.result;
        }

        @NotNull
        public final ApiResponse copy(@JsonProperty("code") int code, @JsonProperty("message") @NotNull String message, @JsonProperty("result") @Nullable List<VodItem> result) {
            return new ApiResponse(code, message, result);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ApiResponse)) {
                return false;
            }
            ApiResponse apiResponse = (ApiResponse) other;
            return this.code == apiResponse.code && Intrinsics.areEqual(this.message, apiResponse.message) && Intrinsics.areEqual(this.result, apiResponse.result);
        }

        public int hashCode() {
            return (((this.code * 31) + this.message.hashCode()) * 31) + (this.result == null ? 0 : this.result.hashCode());
        }

        @NotNull
        public String toString() {
            return "ApiResponse(code=" + this.code + ", message=" + this.message + ", result=" + this.result + ')';
        }

        public ApiResponse(@JsonProperty("code") int code, @JsonProperty("message") @NotNull String message, @JsonProperty("result") @Nullable List<VodItem> list) {
            this.code = code;
            this.message = message;
            this.result = list;
        }

        public final int getCode() {
            return this.code;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        public final List<VodItem> getResult() {
            return this.result;
        }
    }

    /* JADX INFO: compiled from: CineTvProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0001\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JD\u0010\u0018\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0006HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/cncverse/CineTvProvider$TopicResult;", "", "id", "", "typeId", "name", "", "vodList", "", "Lcom/cncverse/CineTvProvider$VodItem;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTypeId", "getName", "()Ljava/lang/String;", "getVodList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/cncverse/CineTvProvider$TopicResult;", "equals", "", "other", "hashCode", "toString", "CineTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class TopicResult {

        @JsonProperty("id")
        @Nullable
        private final Integer id;

        @JsonProperty("name")
        @Nullable
        private final String name;

        @JsonProperty("type_id")
        @Nullable
        private final Integer typeId;

        @JsonProperty("vod_list")
        @Nullable
        private final List<VodItem> vodList;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TopicResult copy$default(TopicResult topicResult, Integer num, Integer num2, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                num = topicResult.id;
            }
            if ((i & 2) != 0) {
                num2 = topicResult.typeId;
            }
            if ((i & 4) != 0) {
                str = topicResult.name;
            }
            if ((i & 8) != 0) {
                list = topicResult.vodList;
            }
            return topicResult.copy(num, num2, str, list);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTypeId() {
            return this.typeId;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final List<VodItem> component4() {
            return this.vodList;
        }

        @NotNull
        public final TopicResult copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("type_id") @Nullable Integer typeId, @JsonProperty("name") @Nullable String name, @JsonProperty("vod_list") @Nullable List<VodItem> vodList) {
            return new TopicResult(id, typeId, name, vodList);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TopicResult)) {
                return false;
            }
            TopicResult topicResult = (TopicResult) other;
            return Intrinsics.areEqual(this.id, topicResult.id) && Intrinsics.areEqual(this.typeId, topicResult.typeId) && Intrinsics.areEqual(this.name, topicResult.name) && Intrinsics.areEqual(this.vodList, topicResult.vodList);
        }

        public int hashCode() {
            return ((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.typeId == null ? 0 : this.typeId.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.vodList != null ? this.vodList.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "TopicResult(id=" + this.id + ", typeId=" + this.typeId + ", name=" + this.name + ", vodList=" + this.vodList + ')';
        }

        public TopicResult(@JsonProperty("id") @Nullable Integer id, @JsonProperty("type_id") @Nullable Integer typeId, @JsonProperty("name") @Nullable String name, @JsonProperty("vod_list") @Nullable List<VodItem> list) {
            this.id = id;
            this.typeId = typeId;
            this.name = name;
            this.vodList = list;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final Integer getTypeId() {
            return this.typeId;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final List<VodItem> getVodList() {
            return this.vodList;
        }
    }

    /* JADX INFO: compiled from: CineTvProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/cncverse/CineTvProvider$TopicApiResponse;", "", "code", "", "message", "", "result", "Lcom/cncverse/CineTvProvider$TopicResult;", "<init>", "(ILjava/lang/String;Lcom/cncverse/CineTvProvider$TopicResult;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getResult", "()Lcom/cncverse/CineTvProvider$TopicResult;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CineTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class TopicApiResponse {

        @JsonProperty("code")
        private final int code;

        @JsonProperty("message")
        @NotNull
        private final String message;

        @JsonProperty("result")
        @Nullable
        private final TopicResult result;

        public static /* synthetic */ TopicApiResponse copy$default(TopicApiResponse topicApiResponse, int i, String str, TopicResult topicResult, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = topicApiResponse.code;
            }
            if ((i2 & 2) != 0) {
                str = topicApiResponse.message;
            }
            if ((i2 & 4) != 0) {
                topicResult = topicApiResponse.result;
            }
            return topicApiResponse.copy(i, str, topicResult);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final TopicResult getResult() {
            return this.result;
        }

        @NotNull
        public final TopicApiResponse copy(@JsonProperty("code") int code, @JsonProperty("message") @NotNull String message, @JsonProperty("result") @Nullable TopicResult result) {
            return new TopicApiResponse(code, message, result);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TopicApiResponse)) {
                return false;
            }
            TopicApiResponse topicApiResponse = (TopicApiResponse) other;
            return this.code == topicApiResponse.code && Intrinsics.areEqual(this.message, topicApiResponse.message) && Intrinsics.areEqual(this.result, topicApiResponse.result);
        }

        public int hashCode() {
            return (((this.code * 31) + this.message.hashCode()) * 31) + (this.result == null ? 0 : this.result.hashCode());
        }

        @NotNull
        public String toString() {
            return "TopicApiResponse(code=" + this.code + ", message=" + this.message + ", result=" + this.result + ')';
        }

        public TopicApiResponse(@JsonProperty("code") int code, @JsonProperty("message") @NotNull String message, @JsonProperty("result") @Nullable TopicResult result) {
            this.code = code;
            this.message = message;
            this.result = result;
        }

        public final int getCode() {
            return this.code;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        public final TopicResult getResult() {
            return this.result;
        }
    }

    /* JADX INFO: compiled from: CineTvProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/cncverse/CineTvProvider$InitResponse;", "", "code", "", "result", "Lcom/cncverse/CineTvProvider$InitResult;", "<init>", "(ILcom/cncverse/CineTvProvider$InitResult;)V", "getCode", "()I", "getResult", "()Lcom/cncverse/CineTvProvider$InitResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "CineTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class InitResponse {

        @JsonProperty("code")
        private final int code;

        @JsonProperty("result")
        @Nullable
        private final InitResult result;

        public static /* synthetic */ InitResponse copy$default(InitResponse initResponse, int i, InitResult initResult, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = initResponse.code;
            }
            if ((i2 & 2) != 0) {
                initResult = initResponse.result;
            }
            return initResponse.copy(i, initResult);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final InitResult getResult() {
            return this.result;
        }

        @NotNull
        public final InitResponse copy(@JsonProperty("code") int code, @JsonProperty("result") @Nullable InitResult result) {
            return new InitResponse(code, result);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InitResponse)) {
                return false;
            }
            InitResponse initResponse = (InitResponse) other;
            return this.code == initResponse.code && Intrinsics.areEqual(this.result, initResponse.result);
        }

        public int hashCode() {
            return (this.code * 31) + (this.result == null ? 0 : this.result.hashCode());
        }

        @NotNull
        public String toString() {
            return "InitResponse(code=" + this.code + ", result=" + this.result + ')';
        }

        public InitResponse(@JsonProperty("code") int code, @JsonProperty("result") @Nullable InitResult result) {
            this.code = code;
            this.result = result;
        }

        public final int getCode() {
            return this.code;
        }

        @Nullable
        public final InitResult getResult() {
            return this.result;
        }
    }

    /* JADX INFO: compiled from: CineTvProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/cncverse/CineTvProvider$InitResult;", "", "userInfo", "Lcom/cncverse/CineTvProvider$UserInfo;", "<init>", "(Lcom/cncverse/CineTvProvider$UserInfo;)V", "getUserInfo", "()Lcom/cncverse/CineTvProvider$UserInfo;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CineTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class InitResult {

        @JsonProperty("user_info")
        @Nullable
        private final UserInfo userInfo;

        public static /* synthetic */ InitResult copy$default(InitResult initResult, UserInfo userInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                userInfo = initResult.userInfo;
            }
            return initResult.copy(userInfo);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final UserInfo getUserInfo() {
            return this.userInfo;
        }

        @NotNull
        public final InitResult copy(@JsonProperty("user_info") @Nullable UserInfo userInfo) {
            return new InitResult(userInfo);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InitResult) && Intrinsics.areEqual(this.userInfo, ((InitResult) other).userInfo);
        }

        public int hashCode() {
            if (this.userInfo == null) {
                return 0;
            }
            return this.userInfo.hashCode();
        }

        @NotNull
        public String toString() {
            return "InitResult(userInfo=" + this.userInfo + ')';
        }

        public InitResult(@JsonProperty("user_info") @Nullable UserInfo userInfo) {
            this.userInfo = userInfo;
        }

        @Nullable
        public final UserInfo getUserInfo() {
            return this.userInfo;
        }
    }

    /* JADX INFO: compiled from: CineTvProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/cncverse/CineTvProvider$UserInfo;", "", "token", "", "<init>", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "CineTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class UserInfo {

        @JsonProperty("token")
        @Nullable
        private final String token;

        public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = userInfo.token;
            }
            return userInfo.copy(str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        @NotNull
        public final UserInfo copy(@JsonProperty("token") @Nullable String token) {
            return new UserInfo(token);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UserInfo) && Intrinsics.areEqual(this.token, ((UserInfo) other).token);
        }

        public int hashCode() {
            if (this.token == null) {
                return 0;
            }
            return this.token.hashCode();
        }

        @NotNull
        public String toString() {
            return "UserInfo(token=" + this.token + ')';
        }

        public UserInfo(@JsonProperty("token") @Nullable String token) {
            this.token = token;
        }

        @Nullable
        public final String getToken() {
            return this.token;
        }
    }

    /* JADX INFO: compiled from: CineTvProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJn\u0010 \u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0005HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0016\u0010\u000fR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0017\u0010\u000fR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000b\u0010\u000f¨\u0006'"}, d2 = {"Lcom/cncverse/CineTvProvider$VodCollection;", "", "id", "", "title", "", "vodUrl", "downUrl", "duration", "vodDuration", "collection", "isP2p", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "getVodUrl", "getDownUrl", "getDuration", "getVodDuration", "getCollection", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/cncverse/CineTvProvider$VodCollection;", "equals", "", "other", "hashCode", "toString", "CineTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class VodCollection {

        @JsonProperty("collection")
        @Nullable
        private final Integer collection;

        @JsonProperty("down_url")
        @Nullable
        private final String downUrl;

        @JsonProperty("duration")
        @Nullable
        private final String duration;

        @JsonProperty("id")
        @Nullable
        private final Integer id;

        @JsonProperty("is_p2p")
        @Nullable
        private final Integer isP2p;

        @JsonProperty("title")
        @Nullable
        private final String title;

        @JsonProperty("vod_duration")
        @Nullable
        private final Integer vodDuration;

        @JsonProperty("vod_url")
        @Nullable
        private final String vodUrl;

        public static /* synthetic */ VodCollection copy$default(VodCollection vodCollection, Integer num, String str, String str2, String str3, String str4, Integer num2, Integer num3, Integer num4, int i, Object obj) {
            if ((i & 1) != 0) {
                num = vodCollection.id;
            }
            if ((i & 2) != 0) {
                str = vodCollection.title;
            }
            if ((i & 4) != 0) {
                str2 = vodCollection.vodUrl;
            }
            if ((i & 8) != 0) {
                str3 = vodCollection.downUrl;
            }
            if ((i & 16) != 0) {
                str4 = vodCollection.duration;
            }
            if ((i & 32) != 0) {
                num2 = vodCollection.vodDuration;
            }
            if ((i & 64) != 0) {
                num3 = vodCollection.collection;
            }
            if ((i & 128) != 0) {
                num4 = vodCollection.isP2p;
            }
            Integer num5 = num3;
            Integer num6 = num4;
            String str5 = str4;
            Integer num7 = num2;
            return vodCollection.copy(num, str, str2, str3, str5, num7, num5, num6);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getVodUrl() {
            return this.vodUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getDownUrl() {
            return this.downUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getDuration() {
            return this.duration;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getVodDuration() {
            return this.vodDuration;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getCollection() {
            return this.collection;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getIsP2p() {
            return this.isP2p;
        }

        @NotNull
        public final VodCollection copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("title") @Nullable String title, @JsonProperty("vod_url") @Nullable String vodUrl, @JsonProperty("down_url") @Nullable String downUrl, @JsonProperty("duration") @Nullable String duration, @JsonProperty("vod_duration") @Nullable Integer vodDuration, @JsonProperty("collection") @Nullable Integer collection, @JsonProperty("is_p2p") @Nullable Integer isP2p) {
            return new VodCollection(id, title, vodUrl, downUrl, duration, vodDuration, collection, isP2p);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VodCollection)) {
                return false;
            }
            VodCollection vodCollection = (VodCollection) other;
            return Intrinsics.areEqual(this.id, vodCollection.id) && Intrinsics.areEqual(this.title, vodCollection.title) && Intrinsics.areEqual(this.vodUrl, vodCollection.vodUrl) && Intrinsics.areEqual(this.downUrl, vodCollection.downUrl) && Intrinsics.areEqual(this.duration, vodCollection.duration) && Intrinsics.areEqual(this.vodDuration, vodCollection.vodDuration) && Intrinsics.areEqual(this.collection, vodCollection.collection) && Intrinsics.areEqual(this.isP2p, vodCollection.isP2p);
        }

        public int hashCode() {
            return ((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.vodUrl == null ? 0 : this.vodUrl.hashCode())) * 31) + (this.downUrl == null ? 0 : this.downUrl.hashCode())) * 31) + (this.duration == null ? 0 : this.duration.hashCode())) * 31) + (this.vodDuration == null ? 0 : this.vodDuration.hashCode())) * 31) + (this.collection == null ? 0 : this.collection.hashCode())) * 31) + (this.isP2p != null ? this.isP2p.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "VodCollection(id=" + this.id + ", title=" + this.title + ", vodUrl=" + this.vodUrl + ", downUrl=" + this.downUrl + ", duration=" + this.duration + ", vodDuration=" + this.vodDuration + ", collection=" + this.collection + ", isP2p=" + this.isP2p + ')';
        }

        public VodCollection(@JsonProperty("id") @Nullable Integer id, @JsonProperty("title") @Nullable String title, @JsonProperty("vod_url") @Nullable String vodUrl, @JsonProperty("down_url") @Nullable String downUrl, @JsonProperty("duration") @Nullable String duration, @JsonProperty("vod_duration") @Nullable Integer vodDuration, @JsonProperty("collection") @Nullable Integer collection, @JsonProperty("is_p2p") @Nullable Integer isP2p) {
            this.id = id;
            this.title = title;
            this.vodUrl = vodUrl;
            this.downUrl = downUrl;
            this.duration = duration;
            this.vodDuration = vodDuration;
            this.collection = collection;
            this.isP2p = isP2p;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getVodUrl() {
            return this.vodUrl;
        }

        @Nullable
        public final String getDownUrl() {
            return this.downUrl;
        }

        @Nullable
        public final String getDuration() {
            return this.duration;
        }

        @Nullable
        public final Integer getVodDuration() {
            return this.vodDuration;
        }

        @Nullable
        public final Integer getCollection() {
            return this.collection;
        }

        @Nullable
        public final Integer isP2p() {
            return this.isP2p;
        }
    }

    /* JADX INFO: compiled from: CineTvProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/cncverse/CineTvProvider$AudioTypeOption;", "", "type", "", "typeName", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTypeName", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/cncverse/CineTvProvider$AudioTypeOption;", "equals", "", "other", "hashCode", "toString", "CineTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class AudioTypeOption {

        @JsonProperty("type")
        @Nullable
        private final Integer type;

        @JsonProperty("type_name")
        @Nullable
        private final String typeName;

        public static /* synthetic */ AudioTypeOption copy$default(AudioTypeOption audioTypeOption, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                num = audioTypeOption.type;
            }
            if ((i & 2) != 0) {
                str = audioTypeOption.typeName;
            }
            return audioTypeOption.copy(num, str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTypeName() {
            return this.typeName;
        }

        @NotNull
        public final AudioTypeOption copy(@JsonProperty("type") @Nullable Integer type, @JsonProperty("type_name") @Nullable String typeName) {
            return new AudioTypeOption(type, typeName);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AudioTypeOption)) {
                return false;
            }
            AudioTypeOption audioTypeOption = (AudioTypeOption) other;
            return Intrinsics.areEqual(this.type, audioTypeOption.type) && Intrinsics.areEqual(this.typeName, audioTypeOption.typeName);
        }

        public int hashCode() {
            return ((this.type == null ? 0 : this.type.hashCode()) * 31) + (this.typeName != null ? this.typeName.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AudioTypeOption(type=" + this.type + ", typeName=" + this.typeName + ')';
        }

        public AudioTypeOption(@JsonProperty("type") @Nullable Integer type, @JsonProperty("type_name") @Nullable String typeName) {
            this.type = type;
            this.typeName = typeName;
        }

        @Nullable
        public final Integer getType() {
            return this.type;
        }

        @Nullable
        public final String getTypeName() {
            return this.typeName;
        }
    }

    /* JADX INFO: compiled from: CineTvProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u0015\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/cncverse/CineTvProvider$SeriesInfo;", "", "vodId", "", "series", "", "default", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V", "getVodId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeries", "()Ljava/lang/String;", "getDefault", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/cncverse/CineTvProvider$SeriesInfo;", "equals", "other", "hashCode", "toString", "CineTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SeriesInfo {

        @JsonProperty("default")
        @Nullable
        private final Boolean default;

        @JsonProperty("series")
        @Nullable
        private final String series;

        @JsonProperty("vod_id")
        @Nullable
        private final Integer vodId;

        public static /* synthetic */ SeriesInfo copy$default(SeriesInfo seriesInfo, Integer num, String str, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                num = seriesInfo.vodId;
            }
            if ((i & 2) != 0) {
                str = seriesInfo.series;
            }
            if ((i & 4) != 0) {
                bool = seriesInfo.default;
            }
            return seriesInfo.copy(num, str, bool);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getVodId() {
            return this.vodId;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSeries() {
            return this.series;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getDefault() {
            return this.default;
        }

        @NotNull
        public final SeriesInfo copy(@JsonProperty("vod_id") @Nullable Integer vodId, @JsonProperty("series") @Nullable String series, @JsonProperty("default") @Nullable Boolean bool) {
            return new SeriesInfo(vodId, series, bool);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SeriesInfo)) {
                return false;
            }
            SeriesInfo seriesInfo = (SeriesInfo) other;
            return Intrinsics.areEqual(this.vodId, seriesInfo.vodId) && Intrinsics.areEqual(this.series, seriesInfo.series) && Intrinsics.areEqual(this.default, seriesInfo.default);
        }

        public int hashCode() {
            return ((((this.vodId == null ? 0 : this.vodId.hashCode()) * 31) + (this.series == null ? 0 : this.series.hashCode())) * 31) + (this.default != null ? this.default.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "SeriesInfo(vodId=" + this.vodId + ", series=" + this.series + ", default=" + this.default + ')';
        }

        public SeriesInfo(@JsonProperty("vod_id") @Nullable Integer vodId, @JsonProperty("series") @Nullable String series, @JsonProperty("default") @Nullable Boolean bool) {
            this.vodId = vodId;
            this.series = series;
            this.default = bool;
        }

        @Nullable
        public final Integer getVodId() {
            return this.vodId;
        }

        @Nullable
        public final String getSeries() {
            return this.series;
        }

        @Nullable
        public final Boolean getDefault() {
            return this.default;
        }
    }

    /* JADX INFO: compiled from: CineTvProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bå\u0001\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\u0010\b\u0001\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012\u0012\u0010\b\u0001\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010=\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012HÆ\u0003J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jì\u0001\u0010D\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0010\b\u0003\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00122\u0010\b\u0003\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00122\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010EJ\u0014\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010I\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010J\u001a\u00020\u0005HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b&\u0010\u001dR\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b'\u0010\u001dR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b(\u0010\u001dR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 ¨\u0006K"}, d2 = {"Lcom/cncverse/CineTvProvider$VodInfoResult;", "", "id", "", "vodName", "", "vodPic", "vodYear", "vodActor", "vodDirector", "vodBlurb", "typePid", "vodTotal", "vodSerial", "vodDoubanScore", "", "vodTag", "vodCollection", "", "Lcom/cncverse/CineTvProvider$VodCollection;", "audioTypeOption", "Lcom/cncverse/CineTvProvider$AudioTypeOption;", "seriesInfo", "Lcom/cncverse/CineTvProvider$SeriesInfo;", "audioLanguageTag", "vodArea", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVodName", "()Ljava/lang/String;", "getVodPic", "getVodYear", "getVodActor", "getVodDirector", "getVodBlurb", "getTypePid", "getVodTotal", "getVodSerial", "getVodDoubanScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVodTag", "getVodCollection", "()Ljava/util/List;", "getAudioTypeOption", "getSeriesInfo", "getAudioLanguageTag", "getVodArea", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/cncverse/CineTvProvider$VodInfoResult;", "equals", "", "other", "hashCode", "toString", "CineTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class VodInfoResult {

        @JsonProperty("audio_language_tag")
        @Nullable
        private final String audioLanguageTag;

        @JsonProperty("audio_type_option")
        @Nullable
        private final List<AudioTypeOption> audioTypeOption;

        @JsonProperty("id")
        @Nullable
        private final Integer id;

        @JsonProperty("series_info")
        @Nullable
        private final List<SeriesInfo> seriesInfo;

        @JsonProperty("type_pid")
        @Nullable
        private final Integer typePid;

        @JsonProperty("vod_actor")
        @Nullable
        private final String vodActor;

        @JsonProperty("vod_area")
        @Nullable
        private final String vodArea;

        @JsonProperty("vod_blurb")
        @Nullable
        private final String vodBlurb;

        @JsonProperty("vod_collection")
        @Nullable
        private final List<VodCollection> vodCollection;

        @JsonProperty("vod_director")
        @Nullable
        private final String vodDirector;

        @JsonProperty("vod_douban_score")
        @Nullable
        private final Double vodDoubanScore;

        @JsonProperty("vod_name")
        @Nullable
        private final String vodName;

        @JsonProperty("vod_pic")
        @Nullable
        private final String vodPic;

        @JsonProperty("vod_serial")
        @Nullable
        private final Integer vodSerial;

        @JsonProperty("vod_tag")
        @Nullable
        private final String vodTag;

        @JsonProperty("vod_total")
        @Nullable
        private final Integer vodTotal;

        @JsonProperty("vod_year")
        @Nullable
        private final String vodYear;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VodInfoResult copy$default(VodInfoResult vodInfoResult, Integer num, String str, String str2, String str3, String str4, String str5, String str6, Integer num2, Integer num3, Integer num4, Double d, String str7, List list, List list2, List list3, String str8, String str9, int i, Object obj) {
            String str10;
            String str11;
            Integer num5 = (i & 1) != 0 ? vodInfoResult.id : num;
            String str12 = (i & 2) != 0 ? vodInfoResult.vodName : str;
            String str13 = (i & 4) != 0 ? vodInfoResult.vodPic : str2;
            String str14 = (i & 8) != 0 ? vodInfoResult.vodYear : str3;
            String str15 = (i & 16) != 0 ? vodInfoResult.vodActor : str4;
            String str16 = (i & 32) != 0 ? vodInfoResult.vodDirector : str5;
            String str17 = (i & 64) != 0 ? vodInfoResult.vodBlurb : str6;
            Integer num6 = (i & 128) != 0 ? vodInfoResult.typePid : num2;
            Integer num7 = (i & 256) != 0 ? vodInfoResult.vodTotal : num3;
            Integer num8 = (i & 512) != 0 ? vodInfoResult.vodSerial : num4;
            Double d2 = (i & 1024) != 0 ? vodInfoResult.vodDoubanScore : d;
            String str18 = (i & 2048) != 0 ? vodInfoResult.vodTag : str7;
            List list4 = (i & 4096) != 0 ? vodInfoResult.vodCollection : list;
            List list5 = (i & 8192) != 0 ? vodInfoResult.audioTypeOption : list2;
            Integer num9 = num5;
            List list6 = (i & 16384) != 0 ? vodInfoResult.seriesInfo : list3;
            String str19 = (i & 32768) != 0 ? vodInfoResult.audioLanguageTag : str8;
            if ((i & 65536) != 0) {
                str11 = str19;
                str10 = vodInfoResult.vodArea;
            } else {
                str10 = str9;
                str11 = str19;
            }
            return vodInfoResult.copy(num9, str12, str13, str14, str15, str16, str17, num6, num7, num8, d2, str18, list4, list5, list6, str11, str10);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getVodSerial() {
            return this.vodSerial;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Double getVodDoubanScore() {
            return this.vodDoubanScore;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getVodTag() {
            return this.vodTag;
        }

        @Nullable
        public final List<VodCollection> component13() {
            return this.vodCollection;
        }

        @Nullable
        public final List<AudioTypeOption> component14() {
            return this.audioTypeOption;
        }

        @Nullable
        public final List<SeriesInfo> component15() {
            return this.seriesInfo;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final String getAudioLanguageTag() {
            return this.audioLanguageTag;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getVodArea() {
            return this.vodArea;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getVodName() {
            return this.vodName;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getVodPic() {
            return this.vodPic;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getVodYear() {
            return this.vodYear;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getVodActor() {
            return this.vodActor;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getVodDirector() {
            return this.vodDirector;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getVodBlurb() {
            return this.vodBlurb;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getTypePid() {
            return this.typePid;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getVodTotal() {
            return this.vodTotal;
        }

        @NotNull
        public final VodInfoResult copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("vod_name") @Nullable String vodName, @JsonProperty("vod_pic") @Nullable String vodPic, @JsonProperty("vod_year") @Nullable String vodYear, @JsonProperty("vod_actor") @Nullable String vodActor, @JsonProperty("vod_director") @Nullable String vodDirector, @JsonProperty("vod_blurb") @Nullable String vodBlurb, @JsonProperty("type_pid") @Nullable Integer typePid, @JsonProperty("vod_total") @Nullable Integer vodTotal, @JsonProperty("vod_serial") @Nullable Integer vodSerial, @JsonProperty("vod_douban_score") @Nullable Double vodDoubanScore, @JsonProperty("vod_tag") @Nullable String vodTag, @JsonProperty("vod_collection") @Nullable List<VodCollection> vodCollection, @JsonProperty("audio_type_option") @Nullable List<AudioTypeOption> audioTypeOption, @JsonProperty("series_info") @Nullable List<SeriesInfo> seriesInfo, @JsonProperty("audio_language_tag") @Nullable String audioLanguageTag, @JsonProperty("vod_area") @Nullable String vodArea) {
            return new VodInfoResult(id, vodName, vodPic, vodYear, vodActor, vodDirector, vodBlurb, typePid, vodTotal, vodSerial, vodDoubanScore, vodTag, vodCollection, audioTypeOption, seriesInfo, audioLanguageTag, vodArea);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VodInfoResult)) {
                return false;
            }
            VodInfoResult vodInfoResult = (VodInfoResult) other;
            return Intrinsics.areEqual(this.id, vodInfoResult.id) && Intrinsics.areEqual(this.vodName, vodInfoResult.vodName) && Intrinsics.areEqual(this.vodPic, vodInfoResult.vodPic) && Intrinsics.areEqual(this.vodYear, vodInfoResult.vodYear) && Intrinsics.areEqual(this.vodActor, vodInfoResult.vodActor) && Intrinsics.areEqual(this.vodDirector, vodInfoResult.vodDirector) && Intrinsics.areEqual(this.vodBlurb, vodInfoResult.vodBlurb) && Intrinsics.areEqual(this.typePid, vodInfoResult.typePid) && Intrinsics.areEqual(this.vodTotal, vodInfoResult.vodTotal) && Intrinsics.areEqual(this.vodSerial, vodInfoResult.vodSerial) && Intrinsics.areEqual(this.vodDoubanScore, vodInfoResult.vodDoubanScore) && Intrinsics.areEqual(this.vodTag, vodInfoResult.vodTag) && Intrinsics.areEqual(this.vodCollection, vodInfoResult.vodCollection) && Intrinsics.areEqual(this.audioTypeOption, vodInfoResult.audioTypeOption) && Intrinsics.areEqual(this.seriesInfo, vodInfoResult.seriesInfo) && Intrinsics.areEqual(this.audioLanguageTag, vodInfoResult.audioLanguageTag) && Intrinsics.areEqual(this.vodArea, vodInfoResult.vodArea);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.vodName == null ? 0 : this.vodName.hashCode())) * 31) + (this.vodPic == null ? 0 : this.vodPic.hashCode())) * 31) + (this.vodYear == null ? 0 : this.vodYear.hashCode())) * 31) + (this.vodActor == null ? 0 : this.vodActor.hashCode())) * 31) + (this.vodDirector == null ? 0 : this.vodDirector.hashCode())) * 31) + (this.vodBlurb == null ? 0 : this.vodBlurb.hashCode())) * 31) + (this.typePid == null ? 0 : this.typePid.hashCode())) * 31) + (this.vodTotal == null ? 0 : this.vodTotal.hashCode())) * 31) + (this.vodSerial == null ? 0 : this.vodSerial.hashCode())) * 31) + (this.vodDoubanScore == null ? 0 : this.vodDoubanScore.hashCode())) * 31) + (this.vodTag == null ? 0 : this.vodTag.hashCode())) * 31) + (this.vodCollection == null ? 0 : this.vodCollection.hashCode())) * 31) + (this.audioTypeOption == null ? 0 : this.audioTypeOption.hashCode())) * 31) + (this.seriesInfo == null ? 0 : this.seriesInfo.hashCode())) * 31) + (this.audioLanguageTag == null ? 0 : this.audioLanguageTag.hashCode())) * 31) + (this.vodArea != null ? this.vodArea.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("VodInfoResult(id=").append(this.id).append(", vodName=").append(this.vodName).append(", vodPic=").append(this.vodPic).append(", vodYear=").append(this.vodYear).append(", vodActor=").append(this.vodActor).append(", vodDirector=").append(this.vodDirector).append(", vodBlurb=").append(this.vodBlurb).append(", typePid=").append(this.typePid).append(", vodTotal=").append(this.vodTotal).append(", vodSerial=").append(this.vodSerial).append(", vodDoubanScore=").append(this.vodDoubanScore).append(", vodTag=");
            sb.append(this.vodTag).append(", vodCollection=").append(this.vodCollection).append(", audioTypeOption=").append(this.audioTypeOption).append(", seriesInfo=").append(this.seriesInfo).append(", audioLanguageTag=").append(this.audioLanguageTag).append(", vodArea=").append(this.vodArea).append(')');
            return sb.toString();
        }

        public VodInfoResult(@JsonProperty("id") @Nullable Integer id, @JsonProperty("vod_name") @Nullable String vodName, @JsonProperty("vod_pic") @Nullable String vodPic, @JsonProperty("vod_year") @Nullable String vodYear, @JsonProperty("vod_actor") @Nullable String vodActor, @JsonProperty("vod_director") @Nullable String vodDirector, @JsonProperty("vod_blurb") @Nullable String vodBlurb, @JsonProperty("type_pid") @Nullable Integer typePid, @JsonProperty("vod_total") @Nullable Integer vodTotal, @JsonProperty("vod_serial") @Nullable Integer vodSerial, @JsonProperty("vod_douban_score") @Nullable Double vodDoubanScore, @JsonProperty("vod_tag") @Nullable String vodTag, @JsonProperty("vod_collection") @Nullable List<VodCollection> list, @JsonProperty("audio_type_option") @Nullable List<AudioTypeOption> list2, @JsonProperty("series_info") @Nullable List<SeriesInfo> list3, @JsonProperty("audio_language_tag") @Nullable String audioLanguageTag, @JsonProperty("vod_area") @Nullable String vodArea) {
            this.id = id;
            this.vodName = vodName;
            this.vodPic = vodPic;
            this.vodYear = vodYear;
            this.vodActor = vodActor;
            this.vodDirector = vodDirector;
            this.vodBlurb = vodBlurb;
            this.typePid = typePid;
            this.vodTotal = vodTotal;
            this.vodSerial = vodSerial;
            this.vodDoubanScore = vodDoubanScore;
            this.vodTag = vodTag;
            this.vodCollection = list;
            this.audioTypeOption = list2;
            this.seriesInfo = list3;
            this.audioLanguageTag = audioLanguageTag;
            this.vodArea = vodArea;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final String getVodName() {
            return this.vodName;
        }

        @Nullable
        public final String getVodPic() {
            return this.vodPic;
        }

        @Nullable
        public final String getVodYear() {
            return this.vodYear;
        }

        @Nullable
        public final String getVodActor() {
            return this.vodActor;
        }

        @Nullable
        public final String getVodDirector() {
            return this.vodDirector;
        }

        @Nullable
        public final String getVodBlurb() {
            return this.vodBlurb;
        }

        @Nullable
        public final Integer getTypePid() {
            return this.typePid;
        }

        @Nullable
        public final Integer getVodTotal() {
            return this.vodTotal;
        }

        @Nullable
        public final Integer getVodSerial() {
            return this.vodSerial;
        }

        @Nullable
        public final Double getVodDoubanScore() {
            return this.vodDoubanScore;
        }

        @Nullable
        public final String getVodTag() {
            return this.vodTag;
        }

        @Nullable
        public final List<VodCollection> getVodCollection() {
            return this.vodCollection;
        }

        @Nullable
        public final List<AudioTypeOption> getAudioTypeOption() {
            return this.audioTypeOption;
        }

        @Nullable
        public final List<SeriesInfo> getSeriesInfo() {
            return this.seriesInfo;
        }

        @Nullable
        public final String getAudioLanguageTag() {
            return this.audioLanguageTag;
        }

        @Nullable
        public final String getVodArea() {
            return this.vodArea;
        }
    }

    /* JADX INFO: compiled from: CineTvProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/cncverse/CineTvProvider$VodInfoResponse;", "", "code", "", "message", "", "result", "Lcom/cncverse/CineTvProvider$VodInfoResult;", "<init>", "(ILjava/lang/String;Lcom/cncverse/CineTvProvider$VodInfoResult;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getResult", "()Lcom/cncverse/CineTvProvider$VodInfoResult;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CineTvProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class VodInfoResponse {

        @JsonProperty("code")
        private final int code;

        @JsonProperty("message")
        @Nullable
        private final String message;

        @JsonProperty("result")
        @Nullable
        private final VodInfoResult result;

        public static /* synthetic */ VodInfoResponse copy$default(VodInfoResponse vodInfoResponse, int i, String str, VodInfoResult vodInfoResult, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = vodInfoResponse.code;
            }
            if ((i2 & 2) != 0) {
                str = vodInfoResponse.message;
            }
            if ((i2 & 4) != 0) {
                vodInfoResult = vodInfoResponse.result;
            }
            return vodInfoResponse.copy(i, str, vodInfoResult);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final VodInfoResult getResult() {
            return this.result;
        }

        @NotNull
        public final VodInfoResponse copy(@JsonProperty("code") int code, @JsonProperty("message") @Nullable String message, @JsonProperty("result") @Nullable VodInfoResult result) {
            return new VodInfoResponse(code, message, result);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VodInfoResponse)) {
                return false;
            }
            VodInfoResponse vodInfoResponse = (VodInfoResponse) other;
            return this.code == vodInfoResponse.code && Intrinsics.areEqual(this.message, vodInfoResponse.message) && Intrinsics.areEqual(this.result, vodInfoResponse.result);
        }

        public int hashCode() {
            return (((this.code * 31) + (this.message == null ? 0 : this.message.hashCode())) * 31) + (this.result != null ? this.result.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "VodInfoResponse(code=" + this.code + ", message=" + this.message + ", result=" + this.result + ')';
        }

        public VodInfoResponse(@JsonProperty("code") int code, @JsonProperty("message") @Nullable String message, @JsonProperty("result") @Nullable VodInfoResult result) {
            this.code = code;
            this.message = message;
            this.result = result;
        }

        public final int getCode() {
            return this.code;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        public final VodInfoResult getResult() {
            return this.result;
        }
    }

    private final String des3Decrypt(String encryptedText) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            byte[] bytes = DES_KEY.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bArrCopyOf = Arrays.copyOf(bytes, 24);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
            SecretKeySpec keySpec = new SecretKeySpec(bArrCopyOf, "DESede");
            byte[] bytes2 = DES_IV.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            IvParameterSpec ivSpec = new IvParameterSpec(bytes2);
            cipher.init(2, keySpec, ivSpec);
            byte[] encryptedData = Base64.decode(encryptedText, 0);
            byte[] decryptedData = cipher.doFinal(encryptedData);
            return new String(decryptedData, Charsets.UTF_8);
        } catch (Exception e) {
            throw new Exception("DES3 decryption failed: " + e.getMessage());
        }
    }

    private final String md5Hash(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = text.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] digest = md.digest(bytes);
        return ArraysKt.joinToString$default(digest, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return CineTvProvider.md5Hash$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence md5Hash$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final String generateSign(String curTime) throws Exception {
        String decryptedSecret = des3Decrypt(SECRET_KEY_ENCRYPTED);
        String signString = decryptedSecret + this.deviceId + curTime;
        String upperCase = md5Hash(signString).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private final String generateP2pToken(String deviceId, String vodId, String timestamp) {
        String concatenated = "Zox882LYjEn4Rqpa" + deviceId + vodId + timestamp;
        String upperCase = md5Hash(concatenated).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private final String signVideoUrl(String url) throws NoSuchAlgorithmException {
        URI uri = new URI(url);
        String path = uri.getPath();
        String wsTime = Long.toHexString((System.currentTimeMillis() / ((long) 1000)) + ((long) 60));
        String raw = WS_SECRET + path + wsTime;
        String wsSecret = md5Hash(raw);
        String separator = StringsKt.contains$default(url, "?", false, 2, (Object) null) ? "&" : "?";
        return url + separator + "wsSecret=" + wsSecret + "&wsTime=" + wsTime;
    }

    @NotNull
    public Interceptor getVideoInterceptor(@NotNull ExtractorLink extractorLink) {
        return new Interceptor() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda13
            public final Response intercept(Interceptor.Chain chain) {
                return CineTvProvider.getVideoInterceptor$lambda$0(this.f$0, chain);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response getVideoInterceptor$lambda$0(CineTvProvider this$0, Interceptor.Chain chain) throws NoSuchAlgorithmException {
        Request request = chain.request();
        String newUrl = this$0.signVideoUrl(request.url().toString());
        Request newRequest = request.newBuilder().url(newUrl).build();
        return chain.proceed(newRequest);
    }

    private final String aesDecrypt(String encryptedBase64) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bytes = AES_KEY.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            SecretKeySpec keySpec = new SecretKeySpec(bytes, "AES");
            byte[] bytes2 = AES_IV.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            IvParameterSpec ivSpec = new IvParameterSpec(bytes2);
            cipher.init(2, keySpec, ivSpec);
            byte[] encryptedData = Base64.decode(encryptedBase64, 0);
            byte[] decryptedData = cipher.doFinal(encryptedData);
            if (decryptedData.length >= 2 && decryptedData[0] == 31 && decryptedData[1] == -117) {
                GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(decryptedData));
                Reader inputStreamReader = new InputStreamReader(gzipInputStream, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    BufferedReader it = bufferedReader;
                    String text = TextStreamsKt.readText(it);
                    CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                    return text;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            }
            return new String(decryptedData, Charsets.UTF_8);
        } catch (Exception e) {
            throw new Exception("AES decryption failed: " + e.getMessage());
        }
    }

    static /* synthetic */ Object fetchDeviceToken$default(CineTvProvider cineTvProvider, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return cineTvProvider.fetchDeviceToken(str, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.databind.RuntimeJsonMappingException */
    public final Object fetchDeviceToken(String invitedBy, Continuation<? super String> continuation) throws Exception {
        String responseText;
        UserInfo userInfo;
        String token;
        String strString;
        String url = getMainUrl() + "/api/public/init";
        String curTime = String.valueOf(System.currentTimeMillis());
        Map headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("androidid", this.deviceId), TuplesKt.to("app_id", "filmin"), TuplesKt.to("app_language", "en"), TuplesKt.to("channel_code", "filmin_sh_1000"), TuplesKt.to("Connection", "Keep-Alive"), TuplesKt.to("Content-Type", "application/x-www-form-urlencoded"), TuplesKt.to("cur_time", curTime), TuplesKt.to("device_id", this.deviceId), TuplesKt.to("en_al", "0"), TuplesKt.to("gaid", this.gaid), TuplesKt.to("Host", "filmin.ajfysu.com"), TuplesKt.to("is_display", "GMT+05:30"), TuplesKt.to("is_language", "en"), TuplesKt.to("is_vvv", "0"), TuplesKt.to("log-header", "I am the log request header."), TuplesKt.to("mob_mfr", this.mobMfr), TuplesKt.to("mobmodel", this.mobModel), TuplesKt.to("package_name", "com.dramarush.shortin"), TuplesKt.to("sign", generateSign(curTime)), TuplesKt.to("sys_platform", "2"), TuplesKt.to("sysrelease", "13"), TuplesKt.to("token", ""), TuplesKt.to("User-Agent", "okhttp/4.11.0"), TuplesKt.to("version", "30000")});
        Request.Builder $this$fetchDeviceToken_u24lambda_u240 = new Request.Builder().url(url).post(new FormBody.Builder((Charset) null, 1, (DefaultConstructorMarker) null).add("invited_by", invitedBy).add("is_install", "1").build());
        for (Map.Entry element$iv : headers.entrySet()) {
            String key = (String) element$iv.getKey();
            String value = (String) element$iv.getValue();
            $this$fetchDeviceToken_u24lambda_u240.addHeader(key, value);
        }
        Request request = $this$fetchDeviceToken_u24lambda_u240.build();
        try {
            Response response = MainActivityKt.getApp().getBaseClient().newCall(request).execute();
            if (!response.isSuccessful()) {
                return "";
            }
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody == null || (strString = responseBodyBody.string()) == null || (responseText = StringsKt.trim(strString).toString()) == null) {
                responseText = "";
            }
            String jsonText = (!(responseText.length() > 0) || StringsKt.startsWith$default(responseText, "{", false, 2, (Object) null)) ? responseText : aesDecrypt(responseText);
            ObjectMapper $this$readValue$iv = this.mapper;
            String content$iv = jsonText;
            Object $this$checkTypeMismatch$iv$iv = $this$readValue$iv.readValue(content$iv, new TypeReference<InitResponse>() { // from class: com.cncverse.CineTvProvider$fetchDeviceToken$$inlined$readValue$1
            });
            if (!($this$checkTypeMismatch$iv$iv instanceof InitResponse)) {
                throw new RuntimeJsonMappingException("Deserialized value did not match the specified type; specified " + Reflection.getOrCreateKotlinClass(InitResponse.class).getQualifiedName() + "(non-null) but was " + ($this$checkTypeMismatch$iv$iv != null ? Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName() : null));
            }
            InitResponse initResponse = (InitResponse) $this$checkTypeMismatch$iv$iv;
            InitResult result = initResponse.getResult();
            return (result == null || (userInfo = result.getUserInfo()) == null || (token = userInfo.getToken()) == null) ? "" : token;
        } catch (Exception e) {
            throw new Exception("Failed to fetch device token: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x018e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getHeaders(String curTime, Continuation<? super Map<String, String>> continuation) {
        C00001 c00001;
        String timestamp;
        Object objFetchDeviceToken$default;
        CineTvProvider cineTvProvider;
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
                timestamp = curTime == null ? String.valueOf(System.currentTimeMillis()) : curTime;
                if (this.token == null || Intrinsics.areEqual(this.token, "")) {
                    c00001.L$0 = SpillingKt.nullOutSpilledVariable(curTime);
                    c00001.L$1 = timestamp;
                    c00001.L$2 = this;
                    c00001.label = 1;
                    objFetchDeviceToken$default = fetchDeviceToken$default(this, null, c00001, 1, null);
                    if (objFetchDeviceToken$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cineTvProvider = this;
                    cineTvProvider.token = (String) objFetchDeviceToken$default;
                }
                Pair[] pairArr = new Pair[25];
                pairArr[0] = TuplesKt.to("Accept-Encoding", "identity");
                pairArr[1] = TuplesKt.to("androidid", this.deviceId);
                pairArr[2] = TuplesKt.to("app_id", "filmin");
                pairArr[3] = TuplesKt.to("app_language", "en");
                pairArr[4] = TuplesKt.to("channel_code", "filmin_sh_1000");
                pairArr[5] = TuplesKt.to("Connection", "Keep-Alive");
                pairArr[6] = TuplesKt.to("Content-Type", "application/x-www-form-urlencoded");
                pairArr[7] = TuplesKt.to("cur_time", timestamp);
                pairArr[8] = TuplesKt.to("device_id", this.deviceId);
                pairArr[9] = TuplesKt.to("en_al", "0");
                pairArr[10] = TuplesKt.to("gaid", this.gaid);
                pairArr[11] = TuplesKt.to("Host", "filmin.ajfysu.com");
                pairArr[12] = TuplesKt.to("is_display", "GMT+05:30");
                pairArr[13] = TuplesKt.to("is_language", "en");
                pairArr[14] = TuplesKt.to("is_vvv", "0");
                pairArr[15] = TuplesKt.to("log-header", "I am the log request header.");
                pairArr[16] = TuplesKt.to("mob_mfr", this.mobMfr);
                pairArr[17] = TuplesKt.to("mobmodel", this.mobModel);
                pairArr[18] = TuplesKt.to("package_name", "com.dramarush.shortin");
                pairArr[19] = TuplesKt.to("sign", generateSign(timestamp));
                pairArr[20] = TuplesKt.to("sys_platform", "2");
                pairArr[21] = TuplesKt.to("sysrelease", "13");
                String str = this.token;
                pairArr[22] = TuplesKt.to("token", str != null ? str : "");
                pairArr[23] = TuplesKt.to("User-Agent", "okhttp/4.11.0");
                pairArr[24] = TuplesKt.to("version", "30000");
                return MapsKt.mapOf(pairArr);
            case 1:
                cineTvProvider = (CineTvProvider) c00001.L$2;
                timestamp = (String) c00001.L$1;
                ResultKt.throwOnFailure($result);
                objFetchDeviceToken$default = $result;
                cineTvProvider.token = (String) objFetchDeviceToken$default;
                Pair[] pairArr2 = new Pair[25];
                pairArr2[0] = TuplesKt.to("Accept-Encoding", "identity");
                pairArr2[1] = TuplesKt.to("androidid", this.deviceId);
                pairArr2[2] = TuplesKt.to("app_id", "filmin");
                pairArr2[3] = TuplesKt.to("app_language", "en");
                pairArr2[4] = TuplesKt.to("channel_code", "filmin_sh_1000");
                pairArr2[5] = TuplesKt.to("Connection", "Keep-Alive");
                pairArr2[6] = TuplesKt.to("Content-Type", "application/x-www-form-urlencoded");
                pairArr2[7] = TuplesKt.to("cur_time", timestamp);
                pairArr2[8] = TuplesKt.to("device_id", this.deviceId);
                pairArr2[9] = TuplesKt.to("en_al", "0");
                pairArr2[10] = TuplesKt.to("gaid", this.gaid);
                pairArr2[11] = TuplesKt.to("Host", "filmin.ajfysu.com");
                pairArr2[12] = TuplesKt.to("is_display", "GMT+05:30");
                pairArr2[13] = TuplesKt.to("is_language", "en");
                pairArr2[14] = TuplesKt.to("is_vvv", "0");
                pairArr2[15] = TuplesKt.to("log-header", "I am the log request header.");
                pairArr2[16] = TuplesKt.to("mob_mfr", this.mobMfr);
                pairArr2[17] = TuplesKt.to("mobmodel", this.mobModel);
                pairArr2[18] = TuplesKt.to("package_name", "com.dramarush.shortin");
                pairArr2[19] = TuplesKt.to("sign", generateSign(timestamp));
                pairArr2[20] = TuplesKt.to("sys_platform", "2");
                pairArr2[21] = TuplesKt.to("sysrelease", "13");
                String str2 = this.token;
                pairArr2[22] = TuplesKt.to("token", str2 != null ? str2 : "");
                pairArr2[23] = TuplesKt.to("User-Agent", "okhttp/4.11.0");
                pairArr2[24] = TuplesKt.to("version", "30000");
                return MapsKt.mapOf(pairArr2);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static /* synthetic */ Object getHeaders$default(CineTvProvider cineTvProvider, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return cineTvProvider.getHeaders(str, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.databind.RuntimeJsonMappingException */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object searchRecommend(int pageNumber, Continuation<? super ApiResponse> continuation) throws RuntimeJsonMappingException {
        C00091 c00091;
        String url;
        int pageNumber2;
        Object headers;
        ResponseBody responseBodyBody;
        String encryptedText;
        if (continuation instanceof C00091) {
            c00091 = (C00091) continuation;
            if ((c00091.label & Integer.MIN_VALUE) != 0) {
                c00091.label -= Integer.MIN_VALUE;
            } else {
                c00091 = new C00091(continuation);
            }
        } else {
            c00091 = new C00091(continuation);
        }
        C00091 c00092 = c00091;
        Object $result = c00092.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00092.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                url = getMainUrl() + "/api/search/recommend";
                String curTime = String.valueOf(System.currentTimeMillis());
                c00092.L$0 = url;
                c00092.L$1 = SpillingKt.nullOutSpilledVariable(curTime);
                pageNumber2 = pageNumber;
                c00092.I$0 = pageNumber2;
                c00092.label = 1;
                headers = getHeaders(curTime, c00092);
                if (headers == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                int pageNumber3 = c00092.I$0;
                url = (String) c00092.L$0;
                ResultKt.throwOnFailure($result);
                pageNumber2 = pageNumber3;
                headers = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Map headers2 = (Map) headers;
        String key = null;
        Request.Builder $this$searchRecommend_u24lambda_u240 = new Request.Builder().url(url).post(new FormBody.Builder((Charset) null, 1, (DefaultConstructorMarker) null).add("pn", String.valueOf(pageNumber2)).build());
        for (Map.Entry element$iv : headers2.entrySet()) {
            String str = key;
            String key2 = (String) element$iv.getKey();
            Request.Builder builder = $this$searchRecommend_u24lambda_u240;
            String value = (String) element$iv.getValue();
            $this$searchRecommend_u24lambda_u240.addHeader(key2, value);
            key = str;
            $this$searchRecommend_u24lambda_u240 = builder;
        }
        String str2 = key;
        Request request = $this$searchRecommend_u24lambda_u240.build();
        try {
            Response response = MainActivityKt.getApp().getBaseClient().newCall(request).execute();
            if (response.isSuccessful() && (responseBodyBody = response.body()) != null && (encryptedText = responseBodyBody.string()) != null) {
                String decryptedJson = aesDecrypt(encryptedText);
                ObjectMapper $this$readValue$iv = this.mapper;
                Object $this$checkTypeMismatch$iv$iv = $this$readValue$iv.readValue(decryptedJson, new TypeReference<ApiResponse>() { // from class: com.cncverse.CineTvProvider$searchRecommend$$inlined$readValue$1
                });
                if ($this$checkTypeMismatch$iv$iv instanceof ApiResponse) {
                    return (ApiResponse) $this$checkTypeMismatch$iv$iv;
                }
                throw new RuntimeJsonMappingException("Deserialized value did not match the specified type; specified " + Reflection.getOrCreateKotlinClass(ApiResponse.class).getQualifiedName() + "(non-null) but was " + ($this$checkTypeMismatch$iv$iv != null ? Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName() : str2));
            }
            return str2;
        } catch (Exception e) {
            return str2;
        }
    }

    static /* synthetic */ Object searchRecommend$default(CineTvProvider cineTvProvider, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return cineTvProvider.searchRecommend(i, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.databind.RuntimeJsonMappingException */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object topicVodList(int topicId, int pageNumber, Continuation<? super List<VodItem>> continuation) throws RuntimeJsonMappingException {
        C00111 c00111;
        String url;
        int topicId2;
        int pageNumber2;
        Object headers;
        ResponseBody responseBodyBody;
        String encryptedText;
        if (continuation instanceof C00111) {
            c00111 = (C00111) continuation;
            if ((c00111.label & Integer.MIN_VALUE) != 0) {
                c00111.label -= Integer.MIN_VALUE;
            } else {
                c00111 = new C00111(continuation);
            }
        } else {
            c00111 = new C00111(continuation);
        }
        C00111 c00112 = c00111;
        Object $result = c00112.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00112.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                url = getMainUrl() + "/api/topic/vod_list";
                String curTime = String.valueOf(System.currentTimeMillis());
                c00112.L$0 = url;
                c00112.L$1 = SpillingKt.nullOutSpilledVariable(curTime);
                topicId2 = topicId;
                c00112.I$0 = topicId2;
                pageNumber2 = pageNumber;
                c00112.I$1 = pageNumber2;
                c00112.label = 1;
                headers = getHeaders(curTime, c00112);
                if (headers == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                int pageNumber3 = c00112.I$1;
                topicId2 = c00112.I$0;
                url = (String) c00112.L$0;
                ResultKt.throwOnFailure($result);
                pageNumber2 = pageNumber3;
                headers = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Map headers2 = (Map) headers;
        String key = null;
        Request.Builder $this$topicVodList_u24lambda_u240 = new Request.Builder().url(url).post(new FormBody.Builder((Charset) null, 1, (DefaultConstructorMarker) null).add("topic_id", String.valueOf(topicId2)).add("pn", String.valueOf(pageNumber2)).build());
        for (Map.Entry element$iv : headers2.entrySet()) {
            String str = key;
            String key2 = (String) element$iv.getKey();
            Request.Builder builder = $this$topicVodList_u24lambda_u240;
            String value = (String) element$iv.getValue();
            $this$topicVodList_u24lambda_u240.addHeader(key2, value);
            key = str;
            $this$topicVodList_u24lambda_u240 = builder;
        }
        String str2 = key;
        Request request = $this$topicVodList_u24lambda_u240.build();
        try {
            Response response = MainActivityKt.getApp().getBaseClient().newCall(request).execute();
            if (response.isSuccessful() && (responseBodyBody = response.body()) != null && (encryptedText = responseBodyBody.string()) != null) {
                String decryptedJson = aesDecrypt(encryptedText);
                ObjectMapper $this$readValue$iv = this.mapper;
                Object $this$checkTypeMismatch$iv$iv = $this$readValue$iv.readValue(decryptedJson, new TypeReference<TopicApiResponse>() { // from class: com.cncverse.CineTvProvider$topicVodList$$inlined$readValue$1
                });
                if (!($this$checkTypeMismatch$iv$iv instanceof TopicApiResponse)) {
                    throw new RuntimeJsonMappingException("Deserialized value did not match the specified type; specified " + Reflection.getOrCreateKotlinClass(TopicApiResponse.class).getQualifiedName() + "(non-null) but was " + ($this$checkTypeMismatch$iv$iv != null ? Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName() : str2));
                }
                TopicApiResponse topicResponse = (TopicApiResponse) $this$checkTypeMismatch$iv$iv;
                TopicResult result = topicResponse.getResult();
                return result != null ? result.getVodList() : str2;
            }
            return str2;
        } catch (Exception e) {
            return str2;
        }
    }

    static /* synthetic */ Object topicVodList$default(CineTvProvider cineTvProvider, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        return cineTvProvider.topicVodList(i, i2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.databind.RuntimeJsonMappingException */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object searchVod(String keyword, int pageNumber, Continuation<? super ApiResponse> continuation) throws RuntimeJsonMappingException {
        C00101 c00101;
        String url;
        String keyword2;
        int pageNumber2;
        Object headers;
        ResponseBody responseBodyBody;
        String encryptedText;
        if (continuation instanceof C00101) {
            c00101 = (C00101) continuation;
            if ((c00101.label & Integer.MIN_VALUE) != 0) {
                c00101.label -= Integer.MIN_VALUE;
            } else {
                c00101 = new C00101(continuation);
            }
        } else {
            c00101 = new C00101(continuation);
        }
        C00101 c00102 = c00101;
        Object $result = c00102.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00102.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                url = getMainUrl() + "/api/search/result";
                String curTime = String.valueOf(System.currentTimeMillis());
                keyword2 = keyword;
                c00102.L$0 = keyword2;
                c00102.L$1 = url;
                c00102.L$2 = SpillingKt.nullOutSpilledVariable(curTime);
                pageNumber2 = pageNumber;
                c00102.I$0 = pageNumber2;
                c00102.label = 1;
                headers = getHeaders(curTime, c00102);
                if (headers == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                int pageNumber3 = c00102.I$0;
                url = (String) c00102.L$1;
                keyword2 = (String) c00102.L$0;
                ResultKt.throwOnFailure($result);
                pageNumber2 = pageNumber3;
                headers = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Map headers2 = (Map) headers;
        String key = null;
        Request.Builder $this$searchVod_u24lambda_u240 = new Request.Builder().url(url).post(new FormBody.Builder((Charset) null, 1, (DefaultConstructorMarker) null).add("kw", keyword2).add("pn", String.valueOf(pageNumber2)).build());
        for (Map.Entry element$iv : headers2.entrySet()) {
            String str = key;
            String key2 = (String) element$iv.getKey();
            Request.Builder builder = $this$searchVod_u24lambda_u240;
            String value = (String) element$iv.getValue();
            $this$searchVod_u24lambda_u240.addHeader(key2, value);
            key = str;
            $this$searchVod_u24lambda_u240 = builder;
        }
        String str2 = key;
        Request request = $this$searchVod_u24lambda_u240.build();
        try {
            Response response = MainActivityKt.getApp().getBaseClient().newCall(request).execute();
            if (response.isSuccessful() && (responseBodyBody = response.body()) != null && (encryptedText = responseBodyBody.string()) != null) {
                String decryptedJson = aesDecrypt(encryptedText);
                ObjectMapper $this$readValue$iv = this.mapper;
                Object $this$checkTypeMismatch$iv$iv = $this$readValue$iv.readValue(decryptedJson, new TypeReference<ApiResponse>() { // from class: com.cncverse.CineTvProvider$searchVod$$inlined$readValue$1
                });
                if ($this$checkTypeMismatch$iv$iv instanceof ApiResponse) {
                    return (ApiResponse) $this$checkTypeMismatch$iv$iv;
                }
                throw new RuntimeJsonMappingException("Deserialized value did not match the specified type; specified " + Reflection.getOrCreateKotlinClass(ApiResponse.class).getQualifiedName() + "(non-null) but was " + ($this$checkTypeMismatch$iv$iv != null ? Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName() : str2));
            }
            return str2;
        } catch (Exception e) {
            return str2;
        }
    }

    static /* synthetic */ Object searchVod$default(CineTvProvider cineTvProvider, String str, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        return cineTvProvider.searchVod(str, i, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.databind.RuntimeJsonMappingException */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object getVodInfo(String vodId, int audioType, Continuation<? super VodInfoResponse> continuation) throws RuntimeJsonMappingException {
        C00021 c00021;
        String url;
        String curTime;
        String vodId2;
        int audioType2;
        Object headers;
        ResponseBody responseBodyBody;
        String encryptedText;
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
                url = getMainUrl() + "/api/vod/info_new";
                curTime = String.valueOf(System.currentTimeMillis());
                vodId2 = vodId;
                c00022.L$0 = vodId2;
                c00022.L$1 = url;
                c00022.L$2 = curTime;
                audioType2 = audioType;
                c00022.I$0 = audioType2;
                c00022.label = 1;
                headers = getHeaders(curTime, c00022);
                if (headers == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                int audioType3 = c00022.I$0;
                curTime = (String) c00022.L$2;
                url = (String) c00022.L$1;
                vodId2 = (String) c00022.L$0;
                ResultKt.throwOnFailure($result);
                audioType2 = audioType3;
                headers = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Map headers2 = (Map) headers;
        String p2pToken = generateP2pToken(this.deviceId, vodId2, curTime);
        String key = null;
        Request.Builder $this$getVodInfo_u24lambda_u240 = new Request.Builder().url(url).post(new FormBody.Builder((Charset) null, 1, (DefaultConstructorMarker) null).add("sign", p2pToken).add("vod_id", vodId2).add("cur_time", curTime).add("audio_type", String.valueOf(audioType2)).build());
        for (Map.Entry element$iv : headers2.entrySet()) {
            String str = key;
            String key2 = (String) element$iv.getKey();
            Request.Builder builder = $this$getVodInfo_u24lambda_u240;
            String value = (String) element$iv.getValue();
            $this$getVodInfo_u24lambda_u240.addHeader(key2, value);
            key = str;
            $this$getVodInfo_u24lambda_u240 = builder;
        }
        String str2 = key;
        Request request = $this$getVodInfo_u24lambda_u240.build();
        try {
            Response response = MainActivityKt.getApp().getBaseClient().newCall(request).execute();
            if (response.isSuccessful() && (responseBodyBody = response.body()) != null && (encryptedText = responseBodyBody.string()) != null) {
                String decryptedJson = aesDecrypt(encryptedText);
                ObjectMapper $this$readValue$iv = this.mapper;
                Object $this$checkTypeMismatch$iv$iv = $this$readValue$iv.readValue(decryptedJson, new TypeReference<VodInfoResponse>() { // from class: com.cncverse.CineTvProvider$getVodInfo$$inlined$readValue$1
                });
                if ($this$checkTypeMismatch$iv$iv instanceof VodInfoResponse) {
                    return (VodInfoResponse) $this$checkTypeMismatch$iv$iv;
                }
                throw new RuntimeJsonMappingException("Deserialized value did not match the specified type; specified " + Reflection.getOrCreateKotlinClass(VodInfoResponse.class).getQualifiedName() + "(non-null) but was " + ($this$checkTypeMismatch$iv$iv != null ? Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName() : str2));
            }
            return str2;
        } catch (Exception e) {
            return str2;
        }
    }

    static /* synthetic */ Object getVodInfo$default(CineTvProvider cineTvProvider, String str, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return cineTvProvider.getVodInfo(str, i, continuation);
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.databind.RuntimeJsonMappingException */
    /* JADX WARN: Code duplicated, block: B:25:0x008d  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d1 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:38:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:39:0x010d  */
    /* JADX WARN: Code duplicated, block: B:42:0x014c  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws RuntimeJsonMappingException {
        C00011 c00011;
        Object obj;
        Object objSearchRecommend;
        ApiResponse apiResponse;
        List items;
        boolean z;
        final VodItem vod;
        CineTvProvider cineTvProvider = this;
        MainPageRequest request2 = request;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = cineTvProvider.new C00011(continuation);
            }
        } else {
            c00011 = cineTvProvider.new C00011(continuation);
        }
        Object $result = c00011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Iterable result = null;
        switch (c00011.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                cineTvProvider.showTelegramPopup();
                cineTvProvider.showSubscriptionPopupIfNeeded();
                if (Intrinsics.areEqual(request2.getData(), "1")) {
                    c00011.L$0 = request2;
                    c00011.I$0 = page;
                    c00011.label = 1;
                    objSearchRecommend = cineTvProvider.searchRecommend(page, c00011);
                    if (objSearchRecommend == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    apiResponse = (ApiResponse) objSearchRecommend;
                    if (apiResponse != null) {
                        result = apiResponse.getResult();
                    }
                    items = new ArrayList();
                    if (result != null) {
                        z = true;
                    } else {
                        Iterable $this$forEach$iv = result;
                        for (Object element$iv : $this$forEach$iv) {
                            vod = (VodItem) element$iv;
                            switch (vod.getTypePid()) {
                                case 1:
                                    items.add(MainAPIKt.newMovieSearchResponse$default(cineTvProvider, vod.getVodName(), vod.getId() + ",1", TvType.Movie, false, new Function1() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda10
                                        public final Object invoke(Object obj2) {
                                            return CineTvProvider.getMainPage$lambda$0$0(vod, (MovieSearchResponse) obj2);
                                        }
                                    }, 8, (Object) null));
                                    break;
                                case 2:
                                    items.add(MainAPIKt.newTvSeriesSearchResponse$default(cineTvProvider, vod.getVodName(), vod.getId() + ",2", TvType.TvSeries, false, new Function1() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda11
                                        public final Object invoke(Object obj2) {
                                            return CineTvProvider.getMainPage$lambda$0$1(vod, (TvSeriesSearchResponse) obj2);
                                        }
                                    }, 8, (Object) null));
                                    break;
                            }
                            cineTvProvider = this;
                        }
                        z = true;
                    }
                    return MainAPIKt.newHomePageResponse(request2.getName(), items, Boxing.boxBoolean(z));
                }
                int i = Integer.parseInt(request2.getData());
                c00011.L$0 = request2;
                c00011.I$0 = page;
                c00011.label = 2;
                obj = cineTvProvider.topicVodList(i, page, c00011);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result = (List) obj;
                items = new ArrayList();
                if (result != null) {
                    z = true;
                } else {
                    Iterable $this$forEach$iv2 = result;
                    while (r11.hasNext()) {
                        vod = (VodItem) element$iv;
                        switch (vod.getTypePid()) {
                            case 1:
                                items.add(MainAPIKt.newMovieSearchResponse$default(cineTvProvider, vod.getVodName(), vod.getId() + ",1", TvType.Movie, false, new Function1() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda10
                                    public final Object invoke(Object obj2) {
                                        return CineTvProvider.getMainPage$lambda$0$0(vod, (MovieSearchResponse) obj2);
                                    }
                                }, 8, (Object) null));
                                break;
                            case 2:
                                items.add(MainAPIKt.newTvSeriesSearchResponse$default(cineTvProvider, vod.getVodName(), vod.getId() + ",2", TvType.TvSeries, false, new Function1() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda11
                                    public final Object invoke(Object obj2) {
                                        return CineTvProvider.getMainPage$lambda$0$1(vod, (TvSeriesSearchResponse) obj2);
                                    }
                                }, 8, (Object) null));
                                break;
                        }
                        cineTvProvider = this;
                    }
                    z = true;
                }
                return MainAPIKt.newHomePageResponse(request2.getName(), items, Boxing.boxBoolean(z));
            case 1:
                int page2 = c00011.I$0;
                request2 = (MainPageRequest) c00011.L$0;
                ResultKt.throwOnFailure($result);
                objSearchRecommend = $result;
                apiResponse = (ApiResponse) objSearchRecommend;
                if (apiResponse != null) {
                    result = apiResponse.getResult();
                }
                items = new ArrayList();
                if (result != null) {
                    z = true;
                } else {
                    Iterable $this$forEach$iv3 = result;
                    while (r11.hasNext()) {
                        vod = (VodItem) element$iv;
                        switch (vod.getTypePid()) {
                            case 1:
                                items.add(MainAPIKt.newMovieSearchResponse$default(cineTvProvider, vod.getVodName(), vod.getId() + ",1", TvType.Movie, false, new Function1() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda10
                                    public final Object invoke(Object obj2) {
                                        return CineTvProvider.getMainPage$lambda$0$0(vod, (MovieSearchResponse) obj2);
                                    }
                                }, 8, (Object) null));
                                break;
                            case 2:
                                items.add(MainAPIKt.newTvSeriesSearchResponse$default(cineTvProvider, vod.getVodName(), vod.getId() + ",2", TvType.TvSeries, false, new Function1() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda11
                                    public final Object invoke(Object obj2) {
                                        return CineTvProvider.getMainPage$lambda$0$1(vod, (TvSeriesSearchResponse) obj2);
                                    }
                                }, 8, (Object) null));
                                break;
                        }
                        cineTvProvider = this;
                    }
                    z = true;
                }
                return MainAPIKt.newHomePageResponse(request2.getName(), items, Boxing.boxBoolean(z));
            case 2:
                int i2 = c00011.I$0;
                request2 = (MainPageRequest) c00011.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                result = (List) obj;
                items = new ArrayList();
                if (result != null) {
                    z = true;
                } else {
                    Iterable $this$forEach$iv4 = result;
                    while (r11.hasNext()) {
                        vod = (VodItem) element$iv;
                        switch (vod.getTypePid()) {
                            case 1:
                                items.add(MainAPIKt.newMovieSearchResponse$default(cineTvProvider, vod.getVodName(), vod.getId() + ",1", TvType.Movie, false, new Function1() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda10
                                    public final Object invoke(Object obj2) {
                                        return CineTvProvider.getMainPage$lambda$0$0(vod, (MovieSearchResponse) obj2);
                                    }
                                }, 8, (Object) null));
                                break;
                            case 2:
                                items.add(MainAPIKt.newTvSeriesSearchResponse$default(cineTvProvider, vod.getVodName(), vod.getId() + ",2", TvType.TvSeries, false, new Function1() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda11
                                    public final Object invoke(Object obj2) {
                                        return CineTvProvider.getMainPage$lambda$0$1(vod, (TvSeriesSearchResponse) obj2);
                                    }
                                }, 8, (Object) null));
                                break;
                        }
                        cineTvProvider = this;
                    }
                    z = true;
                }
                return MainAPIKt.newHomePageResponse(request2.getName(), items, Boxing.boxBoolean(z));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$0$0(VodItem $vod, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($vod.getVodPic());
        String vodYear = $vod.getVodYear();
        $this$newMovieSearchResponse.setYear(vodYear != null ? StringsKt.toIntOrNull(vodYear) : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$0$1(VodItem $vod, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($vod.getVodPic());
        String vodYear = $vod.getVodYear();
        $this$newTvSeriesSearchResponse.setYear(vodYear != null ? StringsKt.toIntOrNull(vodYear) : null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00081 c00081;
        Object objSearchVod$default;
        List vodItems;
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
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return CollectionsKt.emptyList();
                }
                if (StringsKt.isBlank(query)) {
                    return CollectionsKt.emptyList();
                }
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00082.label = 1;
                objSearchVod$default = searchVod$default(this, query, 0, c00082, 2, null);
                if (objSearchVod$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objSearchVod$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ApiResponse searchResponse = (ApiResponse) objSearchVod$default;
        if (searchResponse != null && (vodItems = searchResponse.getResult()) != null) {
            List items = new ArrayList();
            List $this$forEach$iv = vodItems;
            for (Object element$iv : $this$forEach$iv) {
                final VodItem vod = (VodItem) element$iv;
                switch (vod.getTypePid()) {
                    case 1:
                        items.add(MainAPIKt.newMovieSearchResponse$default(this, vod.getVodName(), vod.getId() + ",1", TvType.Movie, false, new Function1() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda14
                            public final Object invoke(Object obj) {
                                return CineTvProvider.search$lambda$0$0(vod, (MovieSearchResponse) obj);
                            }
                        }, 8, (Object) null));
                        break;
                    case 2:
                        items.add(MainAPIKt.newTvSeriesSearchResponse$default(this, vod.getVodName(), vod.getId() + ",2", TvType.TvSeries, false, new Function1() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda15
                            public final Object invoke(Object obj) {
                                return CineTvProvider.search$lambda$0$1(vod, (TvSeriesSearchResponse) obj);
                            }
                        }, 8, (Object) null));
                        break;
                }
                vodItems = vodItems;
            }
            return items;
        }
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(VodItem $vod, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($vod.getVodPic());
        String vodYear = $vod.getVodYear();
        $this$newMovieSearchResponse.setYear(vodYear != null ? StringsKt.toIntOrNull(vodYear) : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$1(VodItem $vod, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($vod.getVodPic());
        String vodYear = $vod.getVodYear();
        $this$newTvSeriesSearchResponse.setYear(vodYear != null ? StringsKt.toIntOrNull(vodYear) : null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0153  */
    /* JADX WARN: Code duplicated, block: B:36:0x015a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0166  */
    /* JADX WARN: Code duplicated, block: B:40:0x017b  */
    /* JADX WARN: Code duplicated, block: B:50:0x01db  */
    /* JADX WARN: Code duplicated, block: B:60:0x0269  */
    /* JADX WARN: Code duplicated, block: B:63:0x0274  */
    /* JADX WARN: Code duplicated, block: B:64:0x0284  */
    /* JADX WARN: Code duplicated, block: B:66:0x028a  */
    /* JADX WARN: Code duplicated, block: B:69:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:71:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:72:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:75:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:78:0x0375 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:79:0x0376  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:93:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:96:0x0466 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:97:0x0467  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00031 c00031;
        C00031 c00032;
        String vodId;
        Object obj;
        List parts;
        int typePid;
        VodInfoResponse vodInfoResponse;
        VodInfoResult vodInfo;
        String name;
        String posterUrl;
        String vodYear;
        Integer year;
        String plot;
        Double vodDoubanScore;
        Score score;
        String vodTag;
        List tags;
        String vodActor;
        VodInfoResponse vodInfoResponse2;
        VodInfoResult vodInfo2;
        String url2;
        List actors;
        List actors2;
        String url3;
        List<VodCollection> vodCollection;
        String movieData;
        Object objNewMovieLoadResponse;
        String vodId2;
        int typePid2;
        String vodId3;
        Integer year2;
        String plot2;
        List actors3;
        VodInfoResult vodInfo3;
        VodInfoResponse vodInfoResponse3;
        String url4;
        String name2;
        List parts2;
        VodCollection collection;
        Iterable vodCollection2;
        List actors4;
        List episodes;
        String url5;
        Object objNewTvSeriesLoadResponse;
        String vodId4;
        String name3;
        String vodId5;
        String url6;
        Integer year3;
        String plot3;
        Score score2;
        List tags2;
        VodInfoResult vodInfo4;
        List parts3;
        Iterable $this$map$iv;
        int $i$f$map;
        Collection destination$iv$iv;
        Integer collection2;
        int iIntValue;
        Iterable iterableSplit$default;
        Iterable iterableSplit$default2;
        String url7 = url;
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
        C00031 c00033 = c00031;
        Object $result = c00033.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00033.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                List parts4 = StringsKt.split$default(url7, new String[]{","}, false, 0, 6, (Object) null);
                if (parts4.size() != 2) {
                    return null;
                }
                String vodId6 = StringsKt.substringAfterLast$default((String) parts4.get(0), "/", (String) null, 2, (Object) null);
                Integer intOrNull = StringsKt.toIntOrNull((String) parts4.get(1));
                if (intOrNull == null) {
                    return null;
                }
                int typePid3 = intOrNull.intValue();
                c00033.L$0 = url7;
                c00033.L$1 = SpillingKt.nullOutSpilledVariable(parts4);
                c00033.L$2 = vodId6;
                c00033.I$0 = typePid3;
                c00033.label = 1;
                c00032 = c00033;
                Object vodInfo$default = getVodInfo$default(this, vodId6, 0, c00032, 2, null);
                if (vodInfo$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                vodId = vodId6;
                obj = vodInfo$default;
                parts = parts4;
                typePid = typePid3;
                vodInfoResponse = (VodInfoResponse) obj;
                if (vodInfoResponse != null || (vodInfo = vodInfoResponse.getResult()) == null || (name = vodInfo.getVodName()) == null) {
                    return null;
                }
                posterUrl = vodInfo.getVodPic();
                vodYear = vodInfo.getVodYear();
                if (vodYear != null) {
                    year = StringsKt.toIntOrNull(vodYear);
                } else {
                    year = null;
                }
                plot = vodInfo.getVodBlurb();
                vodDoubanScore = vodInfo.getVodDoubanScore();
                if (vodDoubanScore != null) {
                    double it = vodDoubanScore.doubleValue();
                    score = Score.Companion.from10(Boxing.boxDouble(it));
                } else {
                    score = null;
                }
                vodTag = vodInfo.getVodTag();
                if (vodTag != null || (iterableSplit$default2 = StringsKt.split$default(vodTag, new String[]{"/"}, false, 0, 6, (Object) null)) == null) {
                    tags = null;
                } else {
                    Iterable $this$map$iv2 = iterableSplit$default2;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    for (Object item$iv$iv : $this$map$iv2) {
                        String it2 = (String) item$iv$iv;
                        destination$iv$iv2.add(StringsKt.trim(it2).toString());
                    }
                    tags = (List) destination$iv$iv2;
                }
                vodActor = vodInfo.getVodActor();
                if (vodActor != null || (iterableSplit$default = StringsKt.split$default(vodActor, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                    vodInfoResponse2 = vodInfoResponse;
                    vodInfo2 = vodInfo;
                    url2 = url7;
                    actors = null;
                } else {
                    Iterable $this$map$iv3 = iterableSplit$default;
                    Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                    for (Object item$iv$iv2 : $this$map$iv3) {
                        String actorName = (String) item$iv$iv2;
                        destination$iv$iv3.add(new ActorData(new Actor(StringsKt.trim(actorName).toString(), (String) null, 2, (DefaultConstructorMarker) null), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                        $this$map$iv3 = $this$map$iv3;
                        vodInfo = vodInfo;
                        vodInfoResponse = vodInfoResponse;
                        url7 = url7;
                    }
                    vodInfoResponse2 = vodInfoResponse;
                    vodInfo2 = vodInfo;
                    url2 = url7;
                    actors = (List) destination$iv$iv3;
                }
                switch (typePid) {
                    case 1:
                        actors2 = actors;
                        url3 = url2;
                        C00031 c00034 = c00032;
                        vodCollection = vodInfo2.getVodCollection();
                        if (vodCollection != null || (collection = (VodCollection) CollectionsKt.firstOrNull(vodCollection)) == null) {
                            movieData = vodId + "|1";
                        } else {
                            StringBuilder sbAppend = new StringBuilder().append(vodId).append('|');
                            Integer collection3 = collection.getCollection();
                            String string = sbAppend.append(collection3 != null ? collection3.intValue() : 1).toString();
                            if (string == null) {
                                movieData = vodId + "|1";
                            } else {
                                movieData = string;
                            }
                        }
                        TvType tvType = TvType.Movie;
                        C00042 c00042 = new C00042(posterUrl, year, plot, score, tags, actors2, null);
                        c00034.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        c00034.L$1 = SpillingKt.nullOutSpilledVariable(parts);
                        c00034.L$2 = SpillingKt.nullOutSpilledVariable(vodId);
                        c00034.L$3 = SpillingKt.nullOutSpilledVariable(vodInfoResponse2);
                        c00034.L$4 = SpillingKt.nullOutSpilledVariable(vodInfo2);
                        c00034.L$5 = SpillingKt.nullOutSpilledVariable(name);
                        c00034.L$6 = SpillingKt.nullOutSpilledVariable(posterUrl);
                        c00034.L$7 = SpillingKt.nullOutSpilledVariable(year);
                        c00034.L$8 = SpillingKt.nullOutSpilledVariable(plot);
                        c00034.L$9 = SpillingKt.nullOutSpilledVariable(score);
                        c00034.L$10 = SpillingKt.nullOutSpilledVariable(tags);
                        c00034.L$11 = SpillingKt.nullOutSpilledVariable(actors2);
                        c00034.L$12 = SpillingKt.nullOutSpilledVariable(movieData);
                        c00034.I$0 = typePid;
                        c00034.label = 2;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, name, url3, tvType, movieData, c00042, c00034);
                        if (objNewMovieLoadResponse == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        vodId2 = vodId;
                        typePid2 = typePid;
                        vodId3 = url3;
                        year2 = year;
                        plot2 = plot;
                        actors3 = actors2;
                        vodInfo3 = vodInfo2;
                        vodInfoResponse3 = vodInfoResponse2;
                        url4 = name;
                        name2 = posterUrl;
                        parts2 = parts;
                        return (LoadResponse) objNewMovieLoadResponse;
                    case 2:
                        vodCollection2 = vodInfo2.getVodCollection();
                        if (vodCollection2 != null) {
                            $this$map$iv = vodCollection2;
                            $i$f$map = 0;
                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv3 : $this$map$iv) {
                                final VodCollection collection4 = (VodCollection) item$iv$iv3;
                                Iterable $this$map$iv4 = $this$map$iv;
                                CineTvProvider cineTvProvider = this;
                                int $i$f$map2 = $i$f$map;
                                List actors5 = actors;
                                StringBuilder sbAppend2 = new StringBuilder().append(vodId).append('|');
                                collection2 = collection4.getCollection();
                                if (collection2 != null) {
                                    iIntValue = collection2.intValue();
                                } else {
                                    iIntValue = 1;
                                }
                                destination$iv$iv.add(MainAPIKt.newEpisode(cineTvProvider, sbAppend2.append(iIntValue).toString(), new Function1() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda12
                                    public final Object invoke(Object obj2) {
                                        return CineTvProvider.load$lambda$4$0(collection4, (Episode) obj2);
                                    }
                                }));
                                $this$map$iv = $this$map$iv4;
                                $i$f$map = $i$f$map2;
                                actors = actors5;
                            }
                            actors4 = actors;
                            episodes = (List) destination$iv$iv;
                        } else {
                            actors4 = actors;
                            episodes = CollectionsKt.emptyList();
                        }
                        TvType tvType2 = TvType.TvSeries;
                        C00053 c00053 = new C00053(posterUrl, year, plot, score, tags, actors4, null);
                        c00032.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(parts);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(vodId);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(vodInfoResponse2);
                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(vodInfo2);
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(name);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(posterUrl);
                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(year);
                        c00032.L$8 = SpillingKt.nullOutSpilledVariable(plot);
                        c00032.L$9 = SpillingKt.nullOutSpilledVariable(score);
                        c00032.L$10 = SpillingKt.nullOutSpilledVariable(tags);
                        c00032.L$11 = SpillingKt.nullOutSpilledVariable(actors4);
                        c00032.L$12 = SpillingKt.nullOutSpilledVariable(episodes);
                        c00032.I$0 = typePid;
                        c00032.label = 3;
                        url5 = url2;
                        c00033 = c00032;
                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, name, url5, tvType2, episodes, c00053, c00033);
                        if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        vodId4 = vodId;
                        name3 = name;
                        vodId5 = url5;
                        url6 = posterUrl;
                        year3 = year;
                        plot3 = plot;
                        score2 = score;
                        tags2 = tags;
                        vodInfo4 = vodInfo2;
                        parts3 = parts;
                        return (LoadResponse) objNewTvSeriesLoadResponse;
                    default:
                        return null;
                }
            case 1:
                int typePid4 = c00033.I$0;
                String vodId7 = (String) c00033.L$2;
                parts = (List) c00033.L$1;
                String url8 = (String) c00033.L$0;
                ResultKt.throwOnFailure($result);
                typePid = typePid4;
                vodId = vodId7;
                url7 = url8;
                c00032 = c00033;
                obj = $result;
                vodInfoResponse = (VodInfoResponse) obj;
                if (vodInfoResponse != null) {
                    return null;
                }
                posterUrl = vodInfo.getVodPic();
                vodYear = vodInfo.getVodYear();
                if (vodYear != null) {
                    year = StringsKt.toIntOrNull(vodYear);
                } else {
                    year = null;
                }
                plot = vodInfo.getVodBlurb();
                vodDoubanScore = vodInfo.getVodDoubanScore();
                if (vodDoubanScore != null) {
                    double it3 = vodDoubanScore.doubleValue();
                    score = Score.Companion.from10(Boxing.boxDouble(it3));
                } else {
                    score = null;
                }
                vodTag = vodInfo.getVodTag();
                if (vodTag != null) {
                    tags = null;
                } else {
                    tags = null;
                }
                vodActor = vodInfo.getVodActor();
                if (vodActor != null) {
                    vodInfoResponse2 = vodInfoResponse;
                    vodInfo2 = vodInfo;
                    url2 = url7;
                    actors = null;
                } else {
                    vodInfoResponse2 = vodInfoResponse;
                    vodInfo2 = vodInfo;
                    url2 = url7;
                    actors = null;
                }
                switch (typePid) {
                    case 1:
                        actors2 = actors;
                        url3 = url2;
                        C00031 c00035 = c00032;
                        vodCollection = vodInfo2.getVodCollection();
                        if (vodCollection != null) {
                            movieData = vodId + "|1";
                        } else {
                            movieData = vodId + "|1";
                        }
                        TvType tvType3 = TvType.Movie;
                        C00042 c00043 = new C00042(posterUrl, year, plot, score, tags, actors2, null);
                        c00035.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        c00035.L$1 = SpillingKt.nullOutSpilledVariable(parts);
                        c00035.L$2 = SpillingKt.nullOutSpilledVariable(vodId);
                        c00035.L$3 = SpillingKt.nullOutSpilledVariable(vodInfoResponse2);
                        c00035.L$4 = SpillingKt.nullOutSpilledVariable(vodInfo2);
                        c00035.L$5 = SpillingKt.nullOutSpilledVariable(name);
                        c00035.L$6 = SpillingKt.nullOutSpilledVariable(posterUrl);
                        c00035.L$7 = SpillingKt.nullOutSpilledVariable(year);
                        c00035.L$8 = SpillingKt.nullOutSpilledVariable(plot);
                        c00035.L$9 = SpillingKt.nullOutSpilledVariable(score);
                        c00035.L$10 = SpillingKt.nullOutSpilledVariable(tags);
                        c00035.L$11 = SpillingKt.nullOutSpilledVariable(actors2);
                        c00035.L$12 = SpillingKt.nullOutSpilledVariable(movieData);
                        c00035.I$0 = typePid;
                        c00035.label = 2;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, name, url3, tvType3, movieData, c00043, c00035);
                        if (objNewMovieLoadResponse == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        vodId2 = vodId;
                        typePid2 = typePid;
                        vodId3 = url3;
                        year2 = year;
                        plot2 = plot;
                        actors3 = actors2;
                        vodInfo3 = vodInfo2;
                        vodInfoResponse3 = vodInfoResponse2;
                        url4 = name;
                        name2 = posterUrl;
                        parts2 = parts;
                        return (LoadResponse) objNewMovieLoadResponse;
                    case 2:
                        vodCollection2 = vodInfo2.getVodCollection();
                        if (vodCollection2 != null) {
                            $this$map$iv = vodCollection2;
                            $i$f$map = 0;
                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            while (r12.hasNext()) {
                                final VodCollection collection5 = (VodCollection) item$iv$iv3;
                                Iterable $this$map$iv5 = $this$map$iv;
                                CineTvProvider cineTvProvider2 = this;
                                int $i$f$map3 = $i$f$map;
                                List actors6 = actors;
                                StringBuilder sbAppend3 = new StringBuilder().append(vodId).append('|');
                                collection2 = collection5.getCollection();
                                if (collection2 != null) {
                                    iIntValue = collection2.intValue();
                                } else {
                                    iIntValue = 1;
                                }
                                destination$iv$iv.add(MainAPIKt.newEpisode(cineTvProvider2, sbAppend3.append(iIntValue).toString(), new Function1() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda12
                                    public final Object invoke(Object obj2) {
                                        return CineTvProvider.load$lambda$4$0(collection5, (Episode) obj2);
                                    }
                                }));
                                $this$map$iv = $this$map$iv5;
                                $i$f$map = $i$f$map3;
                                actors = actors6;
                            }
                            actors4 = actors;
                            episodes = (List) destination$iv$iv;
                        } else {
                            actors4 = actors;
                            episodes = CollectionsKt.emptyList();
                        }
                        TvType tvType4 = TvType.TvSeries;
                        C00053 c00054 = new C00053(posterUrl, year, plot, score, tags, actors4, null);
                        c00032.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(parts);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(vodId);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(vodInfoResponse2);
                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(vodInfo2);
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(name);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(posterUrl);
                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(year);
                        c00032.L$8 = SpillingKt.nullOutSpilledVariable(plot);
                        c00032.L$9 = SpillingKt.nullOutSpilledVariable(score);
                        c00032.L$10 = SpillingKt.nullOutSpilledVariable(tags);
                        c00032.L$11 = SpillingKt.nullOutSpilledVariable(actors4);
                        c00032.L$12 = SpillingKt.nullOutSpilledVariable(episodes);
                        c00032.I$0 = typePid;
                        c00032.label = 3;
                        url5 = url2;
                        c00033 = c00032;
                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, name, url5, tvType4, episodes, c00054, c00033);
                        if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        vodId4 = vodId;
                        name3 = name;
                        vodId5 = url5;
                        url6 = posterUrl;
                        year3 = year;
                        plot3 = plot;
                        score2 = score;
                        tags2 = tags;
                        vodInfo4 = vodInfo2;
                        parts3 = parts;
                        return (LoadResponse) objNewTvSeriesLoadResponse;
                    default:
                        return null;
                }
            case 2:
                int typePid5 = c00033.I$0;
                actors3 = (List) c00033.L$11;
                plot2 = (String) c00033.L$8;
                year2 = (Integer) c00033.L$7;
                name2 = (String) c00033.L$6;
                url4 = (String) c00033.L$5;
                vodInfo3 = (VodInfoResult) c00033.L$4;
                vodInfoResponse3 = (VodInfoResponse) c00033.L$3;
                vodId2 = (String) c00033.L$2;
                typePid2 = typePid5;
                parts2 = (List) c00033.L$1;
                vodId3 = (String) c00033.L$0;
                ResultKt.throwOnFailure($result);
                objNewMovieLoadResponse = $result;
                return (LoadResponse) objNewMovieLoadResponse;
            case 3:
                int i = c00033.I$0;
                List actors7 = (List) c00033.L$11;
                tags2 = (List) c00033.L$10;
                score2 = (Score) c00033.L$9;
                plot3 = (String) c00033.L$8;
                year3 = (Integer) c00033.L$7;
                url6 = (String) c00033.L$6;
                name3 = (String) c00033.L$5;
                vodInfo4 = (VodInfoResult) c00033.L$4;
                vodId4 = (String) c00033.L$2;
                parts3 = (List) c00033.L$1;
                vodId5 = (String) c00033.L$0;
                ResultKt.throwOnFailure($result);
                actors4 = actors7;
                objNewTvSeriesLoadResponse = $result;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.cncverse.CineTvProvider$load$2 */
    /* JADX INFO: compiled from: CineTvProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CineTvProvider$load$2", f = "CineTvProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $plot;
        final /* synthetic */ String $posterUrl;
        final /* synthetic */ Score $score;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(String str, Integer num, String str2, Score score, List<String> list, List<ActorData> list2, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$posterUrl = str;
            this.$year = num;
            this.$plot = str2;
            this.$score = score;
            this.$tags = list;
            this.$actors = list2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(this.$posterUrl, this.$year, this.$plot, this.$score, this.$tags, this.$actors, continuation);
            c00042.L$0 = obj;
            return c00042;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MovieLoadResponse $this$newMovieLoadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newMovieLoadResponse.setPosterUrl(this.$posterUrl);
                    $this$newMovieLoadResponse.setYear(this.$year);
                    $this$newMovieLoadResponse.setPlot(this.$plot);
                    $this$newMovieLoadResponse.setScore(this.$score);
                    $this$newMovieLoadResponse.setTags(this.$tags);
                    $this$newMovieLoadResponse.setActors(this.$actors);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$4$0(VodCollection $collection, Episode $this$newEpisode) {
        $this$newEpisode.setName("Episode " + $collection.getTitle());
        $this$newEpisode.setSeason(1);
        $this$newEpisode.setEpisode($collection.getCollection());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.cncverse.CineTvProvider$load$3 */
    /* JADX INFO: compiled from: CineTvProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CineTvProvider$load$3", f = "CineTvProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00053 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $plot;
        final /* synthetic */ String $posterUrl;
        final /* synthetic */ Score $score;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00053(String str, Integer num, String str2, Score score, List<String> list, List<ActorData> list2, Continuation<? super C00053> continuation) {
            super(2, continuation);
            this.$posterUrl = str;
            this.$year = num;
            this.$plot = str2;
            this.$score = score;
            this.$tags = list;
            this.$actors = list2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00053 = new C00053(this.$posterUrl, this.$year, this.$plot, this.$score, this.$tags, this.$actors, continuation);
            c00053.L$0 = obj;
            return c00053;
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
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$posterUrl);
                    $this$newTvSeriesLoadResponse.setYear(this.$year);
                    $this$newTvSeriesLoadResponse.setPlot(this.$plot);
                    $this$newTvSeriesLoadResponse.setScore(this.$score);
                    $this$newTvSeriesLoadResponse.setTags(this.$tags);
                    $this$newTvSeriesLoadResponse.setActors(this.$actors);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:62:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:65:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:71:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:79:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:87:0x0264 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:88:0x0265  */
    /* JADX WARN: Code duplicated, block: B:91:0x027d  */
    /* JADX WARN: Code duplicated, block: B:96:0x01de A[SYNTHETIC] */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) throws NoSuchAlgorithmException {
        C00061 c00061;
        Function1<? super ExtractorLink, Unit> function3;
        CineTvProvider cineTvProvider;
        Function1<? super SubtitleFile, Unit> function4;
        String vodId;
        Object obj;
        List parts;
        int collection;
        String data2;
        boolean isCasting2;
        VodInfoResponse vodInfoResponse;
        VodInfoResult vodInfo;
        List<VodCollection> vodCollection;
        boolean z;
        Iterator<T> it;
        Object next;
        VodCollection episode;
        String videoUrl;
        Object objNewExtractorLink;
        Integer collection2;
        boolean z2;
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
                CineTvProvider $this$loadLinks_u24lambda_u240 = this;
                final Context _ctx = context;
                SharedPreferences _prefs = _ctx != null ? _ctx.getSharedPreferences("CNCVerseSubscription", 0) : null;
                String _mode = _prefs != null ? _prefs.getString("mode", "ads") : null;
                long _expiresAt = _prefs != null ? _prefs.getLong("expires_at", 0L) : 0L;
                long _nowSec = System.currentTimeMillis() / 1000;
                boolean _isSubscribed = Intrinsics.areEqual(_mode, "subscription") && (_expiresAt == 0 || _expiresAt > _nowSec);
                if (!_isSubscribed) {
                    if (Intrinsics.areEqual(_mode, "subscription") && _expiresAt > 0 && _expiresAt <= _nowSec) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda5
                            @Override // java.lang.Runnable
                            public final void run() {
                                CineTvProvider.loadLinks$lambda$0$0(_ctx);
                            }
                        });
                    }
                    $this$loadLinks_u24lambda_u240.openInExternalBrowser(new String(Base64.decode(OMG10, 0), Charsets.UTF_8));
                }
                List parts2 = StringsKt.split$default(data, new String[]{"|"}, false, 0, 6, (Object) null);
                if (parts2.size() != 2) {
                    return Boxing.boxBoolean(false);
                }
                String vodId2 = StringsKt.substringAfterLast$default((String) parts2.get(0), "/", (String) null, 2, (Object) null);
                Integer intOrNull = StringsKt.toIntOrNull((String) parts2.get(1));
                if (intOrNull == null) {
                    return Boxing.boxBoolean(false);
                }
                int collection3 = intOrNull.intValue();
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                function3 = function2;
                c00062.L$2 = function3;
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts2);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(vodId2);
                c00062.Z$0 = isCasting;
                c00062.I$0 = collection3;
                c00062.label = 1;
                cineTvProvider = this;
                Object vodInfo$default = getVodInfo$default(cineTvProvider, vodId2, 0, c00062, 2, null);
                if (vodInfo$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function4 = function1;
                vodId = vodId2;
                obj = vodInfo$default;
                parts = parts2;
                collection = collection3;
                data2 = data;
                isCasting2 = isCasting;
                vodInfoResponse = (VodInfoResponse) obj;
                if (vodInfoResponse == null && (vodInfo = vodInfoResponse.getResult()) != null) {
                    vodCollection = vodInfo.getVodCollection();
                    if (vodCollection != null) {
                        it = vodCollection.iterator();
                        do {
                            if (it.hasNext()) {
                                next = it.next();
                                VodCollection it2 = (VodCollection) next;
                                collection2 = it2.getCollection();
                                z = false;
                                if (collection2 == null && collection2.intValue() == collection) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                            } else {
                                z = false;
                                next = null;
                            }
                            episode = (VodCollection) next;
                            if (episode != null) {
                                videoUrl = episode.getVodUrl();
                                if (videoUrl != null && (videoUrl = episode.getDownUrl()) == null) {
                                    return Boxing.boxBoolean(z);
                                }
                                String videoUrl2 = videoUrl;
                                String signedUrl = cineTvProvider.signVideoUrl(videoUrl2);
                                String name = cineTvProvider.getName();
                                String name2 = cineTvProvider.getName();
                                ExtractorLinkType extractorLinkType = ExtractorLinkType.VIDEO;
                                C00073 c00073 = cineTvProvider.new C00073(null);
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(vodId);
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(vodInfoResponse);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(vodInfo);
                                c00062.L$7 = SpillingKt.nullOutSpilledVariable(episode);
                                c00062.L$8 = SpillingKt.nullOutSpilledVariable(videoUrl2);
                                c00062.L$9 = SpillingKt.nullOutSpilledVariable(signedUrl);
                                c00062.L$10 = function3;
                                c00062.Z$0 = isCasting2;
                                c00062.I$0 = collection;
                                c00062.label = 2;
                                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, signedUrl, extractorLinkType, c00073, c00062);
                                if (objNewExtractorLink == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                function3.invoke(objNewExtractorLink);
                                return Boxing.boxBoolean(true);
                            }
                        } while (!z2);
                        episode = (VodCollection) next;
                        if (episode != null) {
                            videoUrl = episode.getVodUrl();
                            if (videoUrl != null) {
                            }
                            String videoUrl3 = videoUrl;
                            String signedUrl2 = cineTvProvider.signVideoUrl(videoUrl3);
                            String name3 = cineTvProvider.getName();
                            String name4 = cineTvProvider.getName();
                            ExtractorLinkType extractorLinkType2 = ExtractorLinkType.VIDEO;
                            C00073 c00074 = cineTvProvider.new C00073(null);
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(vodId);
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(vodInfoResponse);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(vodInfo);
                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(episode);
                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(videoUrl3);
                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(signedUrl2);
                            c00062.L$10 = function3;
                            c00062.Z$0 = isCasting2;
                            c00062.I$0 = collection;
                            c00062.label = 2;
                            objNewExtractorLink = ExtractorApiKt.newExtractorLink(name3, name4, signedUrl2, extractorLinkType2, c00074, c00062);
                            if (objNewExtractorLink == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function3.invoke(objNewExtractorLink);
                            return Boxing.boxBoolean(true);
                        }
                    } else {
                        z = false;
                    }
                    return Boxing.boxBoolean(z);
                }
                return Boxing.boxBoolean(false);
            case 1:
                int collection4 = c00062.I$0;
                boolean isCasting3 = c00062.Z$0;
                String vodId3 = (String) c00062.L$4;
                List parts3 = (List) c00062.L$3;
                Function1<? super ExtractorLink, Unit> function5 = (Function1) c00062.L$2;
                function4 = (Function1) c00062.L$1;
                String data3 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                vodId = vodId3;
                parts = parts3;
                function3 = function5;
                obj = $result;
                collection = collection4;
                isCasting2 = isCasting3;
                data2 = data3;
                cineTvProvider = this;
                vodInfoResponse = (VodInfoResponse) obj;
                if (vodInfoResponse == null) {
                    return Boxing.boxBoolean(false);
                }
                vodCollection = vodInfo.getVodCollection();
                if (vodCollection != null) {
                    it = vodCollection.iterator();
                    do {
                        if (it.hasNext()) {
                            next = it.next();
                            VodCollection it3 = (VodCollection) next;
                            collection2 = it3.getCollection();
                            z = false;
                            if (collection2 == null) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                        } else {
                            z = false;
                            next = null;
                        }
                        episode = (VodCollection) next;
                        if (episode != null) {
                            videoUrl = episode.getVodUrl();
                            if (videoUrl != null) {
                                break;
                            }
                            String videoUrl4 = videoUrl;
                            String signedUrl3 = cineTvProvider.signVideoUrl(videoUrl4);
                            String name5 = cineTvProvider.getName();
                            String name6 = cineTvProvider.getName();
                            ExtractorLinkType extractorLinkType3 = ExtractorLinkType.VIDEO;
                            C00073 c00075 = cineTvProvider.new C00073(null);
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(vodId);
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(vodInfoResponse);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(vodInfo);
                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(episode);
                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(videoUrl4);
                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(signedUrl3);
                            c00062.L$10 = function3;
                            c00062.Z$0 = isCasting2;
                            c00062.I$0 = collection;
                            c00062.label = 2;
                            objNewExtractorLink = ExtractorApiKt.newExtractorLink(name5, name6, signedUrl3, extractorLinkType3, c00075, c00062);
                            if (objNewExtractorLink == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function3.invoke(objNewExtractorLink);
                            return Boxing.boxBoolean(true);
                        }
                    } while (!z2);
                    episode = (VodCollection) next;
                    if (episode != null) {
                        videoUrl = episode.getVodUrl();
                        if (videoUrl != null) {
                            break;
                        }
                        String videoUrl5 = videoUrl;
                        String signedUrl4 = cineTvProvider.signVideoUrl(videoUrl5);
                        String name7 = cineTvProvider.getName();
                        String name8 = cineTvProvider.getName();
                        ExtractorLinkType extractorLinkType4 = ExtractorLinkType.VIDEO;
                        C00073 c00076 = cineTvProvider.new C00073(null);
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(vodId);
                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(vodInfoResponse);
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(vodInfo);
                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(episode);
                        c00062.L$8 = SpillingKt.nullOutSpilledVariable(videoUrl5);
                        c00062.L$9 = SpillingKt.nullOutSpilledVariable(signedUrl4);
                        c00062.L$10 = function3;
                        c00062.Z$0 = isCasting2;
                        c00062.I$0 = collection;
                        c00062.label = 2;
                        objNewExtractorLink = ExtractorApiKt.newExtractorLink(name7, name8, signedUrl4, extractorLinkType4, c00076, c00062);
                        if (objNewExtractorLink == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function3.invoke(objNewExtractorLink);
                        return Boxing.boxBoolean(true);
                    }
                } else {
                    z = false;
                }
                return Boxing.boxBoolean(z);
            case 2:
                int i = c00062.I$0;
                boolean z3 = c00062.Z$0;
                Function1<? super ExtractorLink, Unit> function6 = (Function1) c00062.L$10;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function3 = function6;
                function3.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    /* JADX INFO: renamed from: com.cncverse.CineTvProvider$loadLinks$3 */
    /* JADX INFO: compiled from: CineTvProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.CineTvProvider$loadLinks$3", f = "CineTvProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00073 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00073(Continuation<? super C00073> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00073 = CineTvProvider.this.new C00073(continuation);
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
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    $this$newExtractorLink.setReferer(CineTvProvider.this.getMainUrl());
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
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    CineTvProvider.showSubscriptionPopupIfNeeded$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CineTvProvider.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CineTvProvider.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                CineTvProvider.showTelegramPopup$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CineTvProvider.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.CineTvProvider$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                CineTvProvider.openInExternalBrowser$lambda$0(ctx, url);
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
