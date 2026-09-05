package com.horis.cncverse;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.io.Closeable;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/CNC_Verse/classes.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086\b¢\u0006\u0002\u0010\r\u001a$\u0010\u000e\u001a\u0004\u0018\u0001H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086\b¢\u0006\u0002\u0010\r\u001a\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f\u001a\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u0014\u001a\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f\u001a\u000e\u0010 \u001a\u00020\fH\u0086@¢\u0006\u0002\u0010!\u001a0\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00162\u0006\u0010#\u001a\u00020\f2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0016\u001a(\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\b\b\u0002\u0010'\u001a\u00020(H\u0086@¢\u0006\u0002\u0010)\u001a\u000e\u0010+\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010!\u001a\u0018\u0010,\u001a\u0004\u0018\u00010\f2\u0006\u0010-\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\u0014\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u000e\u0010\u001f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"JSONParser", "Lcom/lagradost/nicehttp/ResponseParser;", "getJSONParser", "()Lcom/lagradost/nicehttp/ResponseParser;", "app", "Lcom/lagradost/nicehttp/Requests;", "getApp", "()Lcom/lagradost/nicehttp/Requests;", "parseJson", "T", "", "text", "", "(Ljava/lang/String;)Ljava/lang/Object;", "tryParseJson", "convertRuntimeToMinutes", "", "runtime", "bypass", "mainUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newTvBaseHeaders", "", "getNewTvBaseHeaders", "()Ljava/util/Map;", "newTvDomains", "", "getNewTvDomains", "()Ljava/util/List;", "decodeBase64", "value", "resolvedApiUrl", "resolveApiUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildNewTvHeaders", "ott", "extra", "getNewTvUserToken", "apiBase", "forceRefresh", "", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NETMIRROR_TV_URL", "fetchNetmirrorTvHtml", "solveCloudflareInWebView", "url", "CNC Verse_debug"}, k = 2, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/horis/cncverse/UtilsKt\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,773:1\n221#2,2:774\n221#2,2:779\n296#3,2:776\n62#4:778\n67#4,5:781\n67#4,5:787\n1#5:786\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/horis/cncverse/UtilsKt\n*L\n304#1:774,2\n401#1:779,2\n311#1:776,2\n384#1:778\n449#1:781,5\n467#1:787,5\n*E\n"})
public final class UtilsKt {

    @NotNull
    private static final ResponseParser JSONParser = new ResponseParser() { // from class: com.horis.cncverse.UtilsKt$JSONParser$1
        private final ObjectMapper mapper = ExtensionsKt.jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true);

        public final ObjectMapper getMapper() {
            return this.mapper;
        }

        public <T> T parse(String text, KClass<T> kClass) {
            return (T) this.mapper.readValue(text, JvmClassMappingKt.getJavaClass(kClass));
        }

        public <T> T parseSafe(String text, KClass<T> kClass) {
            try {
                return (T) this.mapper.readValue(text, JvmClassMappingKt.getJavaClass(kClass));
            } catch (Exception e) {
                return null;
            }
        }

        public String writeValueAsString(Object obj) {
            return this.mapper.writeValueAsString(obj);
        }
    };

    @NotNull
    private static final String NETMIRROR_TV_URL = "https://netmirror.gg/tv";

    @NotNull
    private static final Requests app;

    @NotNull
    private static final Map<String, String> newTvBaseHeaders;

    @NotNull
    private static final List<String> newTvDomains;

    @NotNull
    private static String resolvedApiUrl;

    /* JADX INFO: renamed from: com.horis.cncverse.UtilsKt$fetchNetmirrorTvHtml$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.UtilsKt", f = "Utils.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {534, 547, 554}, m = "fetchNetmirrorTvHtml", n = {"netmirrorTvUrl", "savedCf", "cfCookieToUse", "savedCfTs", "netmirrorTvUrl", "savedCf", "cfCookieToUse", "firstResponse", "savedCfTs", "netmirrorTvUrl", "savedCf", "cfCookieToUse", "firstResponse", "cfClearance", "savedCfTs"}, nl = {535, 548, 555}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0"}, v = 2)
    static final class C00381 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00381(Continuation<? super C00381> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.fetchNetmirrorTvHtml((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.UtilsKt$getNewTvUserToken$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.UtilsKt", f = "Utils.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {446, 455, 464, 474}, m = "getNewTvUserToken", n = {"apiBase", "ott", "savedToken", "currentOtp", "otpHeaders", "forceRefresh", "savedTimestamp", "apiBase", "ott", "savedToken", "currentOtp", "otpHeaders", "otpResponse", "forceRefresh", "savedTimestamp", "maxCaptchaAttempts", "attempt", "apiBase", "ott", "savedToken", "currentOtp", "otpHeaders", "otpResponse", "tvHtml", "otpMatch", "newOtp", "forceRefresh", "savedTimestamp", "maxCaptchaAttempts", "attempt", "apiBase", "ott", "savedToken", "currentOtp", "otpHeaders", "otpResponse", "tvHtml", "otpMatch", "forceRefresh", "savedTimestamp", "maxCaptchaAttempts", "attempt"}, nl = {449, 456, 467, 454}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "J$0", "I$0", "I$1"}, v = 2)
    static final class C00391 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00391(Continuation<? super C00391> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.getNewTvUserToken(null, null, false, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.UtilsKt$resolveApiUrl$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.UtilsKt", f = "Utils.kt", i = {0, 0, 0, 0}, l = {383}, m = "resolveApiUrl", n = {"savedApiBase", "encoded", "base", "savedTimestamp"}, nl = {384}, s = {"L$0", "L$2", "L$3", "J$0"}, v = 2)
    static final class C00401 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00401(Continuation<? super C00401> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.resolveApiUrl((Continuation) this);
        }
    }

    static {
        Requests $this$app_u24lambda_u240 = new Requests((OkHttpClient) null, (Map) null, (String) null, (Map) null, (Map) null, 0, (TimeUnit) null, 0L, JSONParser, 255, (DefaultConstructorMarker) null);
        $this$app_u24lambda_u240.setDefaultHeaders(MapsKt.mapOf(TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/149.0.0.0 Safari/537.36")));
        app = $this$app_u24lambda_u240;
        newTvBaseHeaders = MapsKt.mapOf(new Pair[]{TuplesKt.to("Cache-Control", "no-cache, no-store, must-revalidate"), TuplesKt.to("Pragma", "no-cache"), TuplesKt.to("Expires", "0"), TuplesKt.to("X-Requested-With", "NetmirrorNewTV v1.0"), TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0 /OS.GatuNewTV v1.0"), TuplesKt.to("Accept", "application/json, text/plain, */*")});
        newTvDomains = CollectionsKt.listOf(new String[]{"aHR0cHM6Ly9tb2JpbGVkZXRlY3RzLmNvbQ==", "aHR0cHM6Ly9tb2JpbGVkZXRlY3QuYXBw", "aHR0cHM6Ly9tb2JpZGV0ZWN0LmFydA==", "aHR0cHM6Ly9tb2JpZGV0ZWN0LmNj", "aHR0cHM6Ly9tb2JpZGV0ZWN0LmNsaWNr", "aHR0cHM6Ly9tb2JpZGV0ZWN0Lmluaw==", "aHR0cHM6Ly9tb2JpZGV0ZWN0LmxpdmU=", "aHR0cHM6Ly9tb2JpZGV0ZWN0LnBybw==", "aHR0cHM6Ly9tb2JpZGV0ZWN0LnNob3A=", "aHR0cHM6Ly9tb2JpZGV0ZWN0LnNpdGU=", "aHR0cHM6Ly9tb2JpZGV0ZWN0LnNwYWNl", "aHR0cHM6Ly9tb2JpZGV0ZWN0LnN0b3Jl", "aHR0cHM6Ly9tb2JpZGV0ZWN0LnZpcA==", "aHR0cHM6Ly9tb2JpZGV0ZWN0Lndpa2k=", "aHR0cHM6Ly9tb2JpZGV0ZWN0Lnh5eg==", "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5hcnQ=", "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5jYw==", "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5pbmZv", "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5pbms=", "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5saXZl", "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5wcm8=", "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5zdG9yZQ==", "aHR0cHM6Ly9tb2JpZGV0ZWN0cy50b3A=", "aHR0cHM6Ly9tb2JpZGV0ZWN0cy54eXo="});
        resolvedApiUrl = "";
    }

    @NotNull
    public static final ResponseParser getJSONParser() {
        return JSONParser;
    }

    @NotNull
    public static final Requests getApp() {
        return app;
    }

    public static final /* synthetic */ <T> T parseJson(String str) {
        ResponseParser jSONParser = getJSONParser();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) jSONParser.parse(str, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public static final /* synthetic */ <T> T tryParseJson(String str) {
        try {
            ResponseParser jSONParser = getJSONParser();
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) jSONParser.parseSafe(str, Reflection.getOrCreateKotlinClass(Object.class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final int convertRuntimeToMinutes(@NotNull String runtime) {
        int minutes;
        int totalMinutes = 0;
        List<String> parts = StringsKt.split$default(runtime, new String[]{" "}, false, 0, 6, (Object) null);
        for (String part : parts) {
            if (StringsKt.endsWith$default(part, "h", false, 2, (Object) null)) {
                Integer intOrNull = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.removeSuffix(part, "h")).toString());
                minutes = intOrNull != null ? intOrNull.intValue() : 0;
                totalMinutes += minutes * 60;
            } else if (StringsKt.endsWith$default(part, "m", false, 2, (Object) null)) {
                Integer intOrNull2 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.removeSuffix(part, "m")).toString());
                minutes = intOrNull2 != null ? intOrNull2.intValue() : 0;
                totalMinutes += minutes;
            }
        }
        return totalMinutes;
    }

    @Nullable
    public static final Object bypass(@NotNull String mainUrl, @NotNull Continuation<? super String> continuation) throws Exception {
        Throwable th;
        Object element$iv;
        String strSubstringAfter$default;
        Pair<String, Long> cookie = NetflixMirrorStorage.INSTANCE.getCookie();
        String savedCookie = (String) cookie.component1();
        long savedTimestamp = ((Number) cookie.component2()).longValue();
        String str = savedCookie;
        if (!(str == null || str.length() == 0) && System.currentTimeMillis() - savedTimestamp < 54000000) {
            return savedCookie;
        }
        try {
            Map headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"), TuplesKt.to("Accept-Encoding", "gzip, deflate, br, zstd"), TuplesKt.to("Accept-Language", "en-US,en;q=0.9"), TuplesKt.to("Cache-Control", "max-age=0"), TuplesKt.to("Connection", "keep-alive"), TuplesKt.to("Content-Type", "application/x-www-form-urlencoded"), TuplesKt.to("Origin", "https://net22.cc"), TuplesKt.to("Referer", "https://net22.cc/verify2"), TuplesKt.to("sec-ch-ua", "\"Google Chrome\";v=\"147\", \"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"147\""), TuplesKt.to("sec-ch-ua-mobile", "?0"), TuplesKt.to("sec-ch-ua-platform", "\"Windows\""), TuplesKt.to("Sec-Fetch-Dest", "document"), TuplesKt.to("Sec-Fetch-Mode", "navigate"), TuplesKt.to("Sec-Fetch-Site", "same-origin"), TuplesKt.to("Sec-Fetch-User", "?1"), TuplesKt.to("Upgrade-Insecure-Requests", "1"), TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/147.0.0.0 Safari/537.36")});
            RequestBody requestBodyBuild = new FormBody.Builder((Charset) null, 1, (DefaultConstructorMarker) null).add("g-recaptcha-response", UUID.randomUUID().toString()).build();
            OkHttpClient client = app.getBaseClient().newBuilder().followRedirects(false).followSslRedirects(false).build();
            Request.Builder $this$bypass_u24lambda_u240 = new Request.Builder().url("https://net52.cc/verify.php").post(requestBodyBuild);
            for (Map.Entry element$iv2 : headers.entrySet()) {
                try {
                    String key = (String) element$iv2.getKey();
                    String value = (String) element$iv2.getValue();
                    $this$bypass_u24lambda_u240.addHeader(key, value);
                } catch (Exception e) {
                    e = e;
                    NetflixMirrorStorage.INSTANCE.clearCookie();
                    throw e;
                }
            }
            try {
                Request request = $this$bypass_u24lambda_u240.build();
                Response response = (Closeable) client.newCall(request).execute();
                try {
                    Response response2 = response;
                    Iterable $this$firstOrNull$iv = response2.headers("Set-Cookie");
                    Iterator it = $this$firstOrNull$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            element$iv = null;
                            break;
                        }
                        element$iv = it.next();
                        String it2 = (String) element$iv;
                        Response response3 = response2;
                        String savedCookie2 = savedCookie;
                        long savedTimestamp2 = savedTimestamp;
                        try {
                            if (StringsKt.startsWith$default(it2, "t_hash_t=", false, 2, (Object) null)) {
                                break;
                            }
                            savedCookie = savedCookie2;
                            response2 = response3;
                            savedTimestamp = savedTimestamp2;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                CloseableKt.closeFinally(response, th);
                                throw th3;
                            }
                        }
                    }
                    String str2 = (String) element$iv;
                    String newCookie = (str2 == null || (strSubstringAfter$default = StringsKt.substringAfter$default(str2, "t_hash_t=", (String) null, 2, (Object) null)) == null) ? null : StringsKt.substringBefore$default(strSubstringAfter$default, ";", (String) null, 2, (Object) null);
                    if (newCookie == null) {
                        newCookie = "";
                    }
                    CloseableKt.closeFinally(response, (Throwable) null);
                    if (newCookie.length() > 0) {
                        NetflixMirrorStorage.INSTANCE.saveCookie(newCookie);
                    }
                    return newCookie;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception e2) {
                e = e2;
                NetflixMirrorStorage.INSTANCE.clearCookie();
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    @NotNull
    public static final Map<String, String> getNewTvBaseHeaders() {
        return newTvBaseHeaders;
    }

    @NotNull
    public static final List<String> getNewTvDomains() {
        return newTvDomains;
    }

    @NotNull
    public static final String decodeBase64(@NotNull String value) {
        return new String(Base64.getDecoder().decode(value), Charsets.UTF_8);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:41:0x012c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x012d  */
    /* JADX WARN: Code duplicated, block: B:45:0x015a A[Catch: Exception -> 0x018d, TryCatch #1 {Exception -> 0x018d, blocks: (B:43:0x0135, B:45:0x015a, B:51:0x0166, B:53:0x016e), top: B:69:0x0135 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0163  */
    /* JADX WARN: Code duplicated, block: B:51:0x0166 A[Catch: Exception -> 0x018d, TRY_LEAVE, TryCatch #1 {Exception -> 0x018d, blocks: (B:43:0x0135, B:45:0x015a, B:51:0x0166, B:53:0x016e), top: B:69:0x0135 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0187  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x012d -> B:69:0x0135). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0197 -> B:64:0x01b0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x01a2 -> B:64:0x01b0). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object resolveApiUrl(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r30) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cncverse.UtilsKt.resolveApiUrl(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Map buildNewTvHeaders$default(String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return buildNewTvHeaders(str, map);
    }

    @NotNull
    public static final Map<String, String> buildNewTvHeaders(@NotNull String ott, @NotNull Map<String, String> map) {
        Map<String, String> mutableMap = MapsKt.toMutableMap(newTvBaseHeaders);
        mutableMap.put("Ott", ott);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            mutableMap.put(key, value);
        }
        return mutableMap;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x02f5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:54:0x0323  */
    /* JADX WARN: Code duplicated, block: B:56:0x0350  */
    /* JADX WARN: Code duplicated, block: B:57:0x0352  */
    /* JADX WARN: Code duplicated, block: B:59:0x0355  */
    /* JADX WARN: Code duplicated, block: B:61:0x03e6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:78:0x043a  */
    /* JADX WARN: Code duplicated, block: B:79:0x0443  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:82:0x0450  */
    /* JADX WARN: Code duplicated, block: B:84:0x0488 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:85:0x0489  */
    /* JADX WARN: Code duplicated, block: B:87:0x049c  */
    /* JADX WARN: Code duplicated, block: B:89:0x04b0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x0489 -> B:86:0x0494). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x049c -> B:88:0x04ae). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object getNewTvUserToken(@org.jetbrains.annotations.NotNull java.lang.String r57, @org.jetbrains.annotations.NotNull java.lang.String r58, boolean r59, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r60) {
        /*
            Method dump skipped, instruction units count: 1278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cncverse.UtilsKt.getNewTvUserToken(java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object getNewTvUserToken$default(String str, String str2, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return getNewTvUserToken(str, str2, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x013e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0143 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x0145  */
    /* JADX WARN: Code duplicated, block: B:54:0x0165 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x0166  */
    /* JADX WARN: Code duplicated, block: B:58:0x0173  */
    /* JADX WARN: Code duplicated, block: B:60:0x0179  */
    /* JADX WARN: Code duplicated, block: B:62:0x017d  */
    /* JADX WARN: Code duplicated, block: B:64:0x0182  */
    /* JADX WARN: Code duplicated, block: B:69:0x01d4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:74:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:76:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public static final Object fetchNetmirrorTvHtml(@NotNull Continuation<? super String> continuation) {
        C00381 c00381;
        String cfCookieToUse;
        C00381 c00382;
        String netmirrorTvUrl;
        String savedCf;
        long savedCfTs;
        NiceResponse firstResponse;
        Object objSolveCloudflareInWebView;
        String savedCf2;
        NiceResponse firstResponse2;
        long savedCfTs2;
        String cfClearance;
        String str;
        NiceResponse firstResponse3;
        NiceResponse firstResponse4;
        Object obj;
        NiceResponse retryResponse;
        if (continuation instanceof C00381) {
            c00381 = (C00381) continuation;
            if ((c00381.label & Integer.MIN_VALUE) != 0) {
                c00381.label -= Integer.MIN_VALUE;
            } else {
                c00381 = new C00381(continuation);
            }
        } else {
            c00381 = new C00381(continuation);
        }
        C00381 c00383 = c00381;
        Object $result = c00383.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00383.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Pair<String, Long> cfCookie = NetflixMirrorStorage.INSTANCE.getCfCookie();
                String savedCf3 = (String) cfCookie.component1();
                long savedCfTs3 = ((Number) cfCookie.component2()).longValue();
                String str2 = savedCf3;
                String cfCookieToUse2 = ((str2 == null || str2.length() == 0) || System.currentTimeMillis() - savedCfTs3 >= 82800000) ? null : savedCf3;
                try {
                    Requests requests = app;
                    try {
                        Map<String, String> mapFetchNetmirrorTvHtml$buildHeaders = fetchNetmirrorTvHtml$buildHeaders(cfCookieToUse2);
                        c00383.L$0 = NETMIRROR_TV_URL;
                        c00383.L$1 = SpillingKt.nullOutSpilledVariable(savedCf3);
                        c00383.L$2 = cfCookieToUse2;
                        c00383.J$0 = savedCfTs3;
                        c00383.label = 1;
                        cfCookieToUse = cfCookieToUse2;
                        try {
                            Object obj2 = Requests.get$default(requests, NETMIRROR_TV_URL, mapFetchNetmirrorTvHtml$buildHeaders, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00383, 4092, (Object) null);
                            c00382 = c00383;
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            netmirrorTvUrl = NETMIRROR_TV_URL;
                            savedCf = savedCf3;
                            savedCfTs = savedCfTs3;
                            $result = obj2;
                            try {
                                firstResponse = (NiceResponse) $result;
                                if (!fetchNetmirrorTvHtml$isCloudflare(firstResponse.getText(), firstResponse.getCode())) {
                                    return firstResponse.getText();
                                }
                                if (cfCookieToUse != null) {
                                    NetflixMirrorStorage.INSTANCE.clearCfCookie();
                                }
                                c00382.L$0 = netmirrorTvUrl;
                                c00382.L$1 = SpillingKt.nullOutSpilledVariable(savedCf);
                                c00382.L$2 = SpillingKt.nullOutSpilledVariable(cfCookieToUse);
                                c00382.L$3 = firstResponse;
                                c00382.J$0 = savedCfTs;
                                c00382.label = 2;
                                objSolveCloudflareInWebView = solveCloudflareInWebView(netmirrorTvUrl, c00382);
                                if (objSolveCloudflareInWebView == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result = objSolveCloudflareInWebView;
                                savedCf2 = savedCf;
                                firstResponse2 = firstResponse;
                                savedCfTs2 = savedCfTs;
                                cfClearance = (String) $result;
                                str = cfClearance;
                                if (str != null || str.length() == 0) {
                                    return firstResponse2.getText();
                                }
                                NetflixMirrorStorage.INSTANCE.saveCfCookie(cfClearance);
                                try {
                                    Requests requests2 = app;
                                    Map<String, String> mapFetchNetmirrorTvHtml$buildHeaders2 = fetchNetmirrorTvHtml$buildHeaders(cfClearance);
                                    c00382.L$0 = SpillingKt.nullOutSpilledVariable(netmirrorTvUrl);
                                    c00382.L$1 = SpillingKt.nullOutSpilledVariable(savedCf2);
                                    c00382.L$2 = SpillingKt.nullOutSpilledVariable(cfCookieToUse);
                                    c00382.L$3 = firstResponse2;
                                    c00382.L$4 = SpillingKt.nullOutSpilledVariable(cfClearance);
                                    c00382.J$0 = savedCfTs2;
                                    c00382.label = 3;
                                    firstResponse4 = firstResponse2;
                                    try {
                                        obj = Requests.get$default(requests2, netmirrorTvUrl, mapFetchNetmirrorTvHtml$buildHeaders2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00382, 4092, (Object) null);
                                        if (obj == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        firstResponse3 = firstResponse4;
                                        $result = obj;
                                        try {
                                            retryResponse = (NiceResponse) $result;
                                            if (fetchNetmirrorTvHtml$isCloudflare(retryResponse.getText(), retryResponse.getCode())) {
                                                return retryResponse.getText();
                                            }
                                            NetflixMirrorStorage.INSTANCE.clearCfCookie();
                                            return "";
                                        } catch (Exception e) {
                                            return firstResponse3.getText();
                                        }
                                    } catch (Exception e2) {
                                        firstResponse3 = firstResponse4;
                                        return firstResponse3.getText();
                                    }
                                } catch (Exception e3) {
                                    firstResponse3 = firstResponse2;
                                }
                            } catch (Exception e4) {
                                return "";
                            }
                        } catch (Exception e5) {
                            return "";
                        }
                    } catch (Exception e6) {
                    }
                } catch (Exception e7) {
                }
                break;
            case 1:
                savedCfTs = c00383.J$0;
                String cfCookieToUse3 = (String) c00383.L$2;
                savedCf = (String) c00383.L$1;
                String netmirrorTvUrl2 = (String) c00383.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    cfCookieToUse = cfCookieToUse3;
                    netmirrorTvUrl = netmirrorTvUrl2;
                    c00382 = c00383;
                    firstResponse = (NiceResponse) $result;
                    if (!fetchNetmirrorTvHtml$isCloudflare(firstResponse.getText(), firstResponse.getCode())) {
                        return firstResponse.getText();
                    }
                    if (cfCookieToUse != null) {
                        NetflixMirrorStorage.INSTANCE.clearCfCookie();
                    }
                    c00382.L$0 = netmirrorTvUrl;
                    c00382.L$1 = SpillingKt.nullOutSpilledVariable(savedCf);
                    c00382.L$2 = SpillingKt.nullOutSpilledVariable(cfCookieToUse);
                    c00382.L$3 = firstResponse;
                    c00382.J$0 = savedCfTs;
                    c00382.label = 2;
                    objSolveCloudflareInWebView = solveCloudflareInWebView(netmirrorTvUrl, c00382);
                    if (objSolveCloudflareInWebView == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objSolveCloudflareInWebView;
                    savedCf2 = savedCf;
                    firstResponse2 = firstResponse;
                    savedCfTs2 = savedCfTs;
                    cfClearance = (String) $result;
                    str = cfClearance;
                    if (str != null || str.length() == 0) {
                        return firstResponse2.getText();
                    }
                    NetflixMirrorStorage.INSTANCE.saveCfCookie(cfClearance);
                    Requests requests3 = app;
                    Map<String, String> mapFetchNetmirrorTvHtml$buildHeaders3 = fetchNetmirrorTvHtml$buildHeaders(cfClearance);
                    c00382.L$0 = SpillingKt.nullOutSpilledVariable(netmirrorTvUrl);
                    c00382.L$1 = SpillingKt.nullOutSpilledVariable(savedCf2);
                    c00382.L$2 = SpillingKt.nullOutSpilledVariable(cfCookieToUse);
                    c00382.L$3 = firstResponse2;
                    c00382.L$4 = SpillingKt.nullOutSpilledVariable(cfClearance);
                    c00382.J$0 = savedCfTs2;
                    c00382.label = 3;
                    firstResponse4 = firstResponse2;
                    obj = Requests.get$default(requests3, netmirrorTvUrl, mapFetchNetmirrorTvHtml$buildHeaders3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00382, 4092, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    firstResponse3 = firstResponse4;
                    $result = obj;
                    retryResponse = (NiceResponse) $result;
                    if (fetchNetmirrorTvHtml$isCloudflare(retryResponse.getText(), retryResponse.getCode())) {
                        return retryResponse.getText();
                    }
                    NetflixMirrorStorage.INSTANCE.clearCfCookie();
                    return "";
                } catch (Exception e8) {
                    return "";
                }
            case 2:
                long savedCfTs4 = c00383.J$0;
                NiceResponse firstResponse5 = (NiceResponse) c00383.L$3;
                String cfCookieToUse4 = (String) c00383.L$2;
                String savedCf4 = (String) c00383.L$1;
                netmirrorTvUrl = (String) c00383.L$0;
                ResultKt.throwOnFailure($result);
                c00382 = c00383;
                cfCookieToUse = cfCookieToUse4;
                savedCf2 = savedCf4;
                firstResponse2 = firstResponse5;
                savedCfTs2 = savedCfTs4;
                cfClearance = (String) $result;
                str = cfClearance;
                if (str != null || str.length() == 0) {
                    return firstResponse2.getText();
                }
                NetflixMirrorStorage.INSTANCE.saveCfCookie(cfClearance);
                Requests requests4 = app;
                Map<String, String> mapFetchNetmirrorTvHtml$buildHeaders4 = fetchNetmirrorTvHtml$buildHeaders(cfClearance);
                c00382.L$0 = SpillingKt.nullOutSpilledVariable(netmirrorTvUrl);
                c00382.L$1 = SpillingKt.nullOutSpilledVariable(savedCf2);
                c00382.L$2 = SpillingKt.nullOutSpilledVariable(cfCookieToUse);
                c00382.L$3 = firstResponse2;
                c00382.L$4 = SpillingKt.nullOutSpilledVariable(cfClearance);
                c00382.J$0 = savedCfTs2;
                c00382.label = 3;
                firstResponse4 = firstResponse2;
                obj = Requests.get$default(requests4, netmirrorTvUrl, mapFetchNetmirrorTvHtml$buildHeaders4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00382, 4092, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                firstResponse3 = firstResponse4;
                $result = obj;
                retryResponse = (NiceResponse) $result;
                if (fetchNetmirrorTvHtml$isCloudflare(retryResponse.getText(), retryResponse.getCode())) {
                    return retryResponse.getText();
                }
                NetflixMirrorStorage.INSTANCE.clearCfCookie();
                return "";
            case 3:
                long j = c00383.J$0;
                firstResponse3 = (NiceResponse) c00383.L$3;
                try {
                    ResultKt.throwOnFailure($result);
                    retryResponse = (NiceResponse) $result;
                    if (fetchNetmirrorTvHtml$isCloudflare(retryResponse.getText(), retryResponse.getCode())) {
                        return retryResponse.getText();
                    }
                    NetflixMirrorStorage.INSTANCE.clearCfCookie();
                    return "";
                } catch (Exception e9) {
                    return firstResponse3.getText();
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static /* synthetic */ Map fetchNetmirrorTvHtml$buildHeaders$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return fetchNetmirrorTvHtml$buildHeaders(str);
    }

    private static final Map<String, String> fetchNetmirrorTvHtml$buildHeaders(String cfClearance) {
        Map<String, String> mapMutableMapOf = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 13; Pixel 5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36"), TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"), TuplesKt.to("Accept-Language", "en-US,en;q=0.9")});
        String str = cfClearance;
        if (!(str == null || str.length() == 0)) {
            mapMutableMapOf.put("Cookie", "cf_clearance=" + cfClearance);
        }
        return mapMutableMapOf;
    }

    private static final boolean fetchNetmirrorTvHtml$isCloudflare(String html, int statusCode) {
        switch (statusCode) {
            case 403:
            case 503:
                return true;
            default:
                if (StringsKt.contains(html, "netmirror.gg/tv", true)) {
                    if (StringsKt.contains(html, "cf-browser-verification", true) || StringsKt.contains(html, "Checking if the site connection is secure", true) || StringsKt.contains(html, "Just a moment", true) || StringsKt.contains(html, "cloudflare", true)) {
                        return true;
                    }
                    return false;
                }
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object solveCloudflareInWebView(String url, Continuation<? super String> continuation) {
        Context ctx = NetflixMirrorProvider.Companion.getContext();
        if (ctx == null) {
            return null;
        }
        return BuildersKt.withContext(Dispatchers.getMain(), new C00412(ctx, url, null), continuation);
    }

    /* JADX INFO: renamed from: com.horis.cncverse.UtilsKt$solveCloudflareInWebView$2 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.UtilsKt$solveCloudflareInWebView$2", f = "Utils.kt", i = {}, l = {577}, m = "invokeSuspend", n = {}, nl = {771}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/horis/cncverse/UtilsKt$solveCloudflareInWebView$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,773:1\n1#2:774\n*E\n"})
    static final class C00412 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ Context $ctx;
        final /* synthetic */ String $url;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00412(Context context, String str, Continuation<? super C00412> continuation) {
            super(2, continuation);
            this.$ctx = context;
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00412(this.$ctx, this.$url, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v18 */
        /* JADX WARN: Type inference failed for: r3v19, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r3v24 */
        public final Object invokeSuspend(Object $result) {
            SafeContinuation safeContinuation;
            Object obj;
            View view;
            FrameLayout container;
            ?? r3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Context context = this.$ctx;
                    final String str = this.$url;
                    this.L$0 = context;
                    this.L$1 = str;
                    this.label = 1;
                    SafeContinuation safeContinuation2 = new SafeContinuation(IntrinsicsKt.intercepted((Continuation) this));
                    final Continuation cont = (Continuation) safeContinuation2;
                    try {
                        final CookieManager cookieManager = CookieManager.getInstance();
                        cookieManager.setAcceptCookie(true);
                        final WebView wv = new WebView(context);
                        cookieManager.setAcceptThirdPartyCookies(wv, true);
                        WebSettings $this$invokeSuspend_u24lambda_u240_u240 = wv.getSettings();
                        $this$invokeSuspend_u24lambda_u240_u240.setJavaScriptEnabled(true);
                        $this$invokeSuspend_u24lambda_u240_u240.setDomStorageEnabled(true);
                        $this$invokeSuspend_u24lambda_u240_u240.setMixedContentMode(0);
                        $this$invokeSuspend_u24lambda_u240_u240.setUserAgentString("Mozilla/5.0 (Linux; Android 13; Pixel 5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36");
                        $this$invokeSuspend_u24lambda_u240_u240.setMediaPlaybackRequiresUserGesture(false);
                        wv.setWebChromeClient(new WebChromeClient());
                        final Ref.BooleanRef resolved = new Ref.BooleanRef();
                        wv.setWebViewClient(new WebViewClient() { // from class: com.horis.cncverse.UtilsKt$solveCloudflareInWebView$2$1$2
                            @Override // android.webkit.WebViewClient
                            public void onPageFinished(WebView view2, String pageUrl) {
                                super.onPageFinished(view2, pageUrl);
                                UtilsKt.C00412.invokeSuspend$lambda$0$extractAndFinish(resolved, cookieManager, str, wv, cont);
                                if (!resolved.element) {
                                    Handler handler = new Handler(Looper.getMainLooper());
                                    final Ref.BooleanRef booleanRef = resolved;
                                    final CookieManager cookieManager2 = cookieManager;
                                    final String str2 = str;
                                    final WebView webView = wv;
                                    final Continuation<String> continuation = cont;
                                    handler.postDelayed(new Runnable() { // from class: com.horis.cncverse.UtilsKt$solveCloudflareInWebView$2$1$2$onPageFinished$1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (!booleanRef.element) {
                                                UtilsKt.C00412.invokeSuspend$lambda$0$extractAndFinish(booleanRef, cookieManager2, str2, webView, continuation);
                                                if (!booleanRef.element) {
                                                    new Handler(Looper.getMainLooper()).postDelayed(this, 1000L);
                                                }
                                            }
                                        }
                                    }, 1000L);
                                }
                            }
                        });
                        final float dp = context.getResources().getDisplayMetrics().density;
                        Object systemService = context.getSystemService("window");
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                        WindowManager wm = (WindowManager) systemService;
                        Point metrics = new Point();
                        obj = null;
                        try {
                            wm.getDefaultDisplay().getSize(metrics);
                            WindowManager.LayoutParams params = new WindowManager.LayoutParams((int) (metrics.x * 0.95f), (int) (metrics.y * 0.9f));
                            LinearLayout wrapper = new LinearLayout(context);
                            wrapper.setOrientation(1);
                            wrapper.setMinimumWidth((int) (metrics.x * 0.95f));
                            wrapper.setMinimumHeight((int) (metrics.y * 0.9f));
                            TextView $this$invokeSuspend_u24lambda_u240_u242 = new TextView(context);
                            $this$invokeSuspend_u24lambda_u240_u242.setText("🔐 Solve the Cloudflare captcha — use D-pad to move cursor, OK to click.");
                            $this$invokeSuspend_u24lambda_u240_u242.setTextColor(-1);
                            $this$invokeSuspend_u24lambda_u240_u242.setBackgroundColor(Color.parseColor("#1A1A2E"));
                            $this$invokeSuspend_u24lambda_u240_u242.setTextSize(13.0f);
                            int p = (int) (10 * dp);
                            $this$invokeSuspend_u24lambda_u240_u242.setPadding(p, p, p, p);
                            $this$invokeSuspend_u24lambda_u240_u242.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                            boolean isTv = Globals.INSTANCE.isLayout(2);
                            final int cursorSize = (int) (22 * dp);
                            if (!isTv) {
                                safeContinuation = safeContinuation2;
                                view = null;
                            } else {
                                View $this$invokeSuspend_u24lambda_u240_u243 = new View(context);
                                $this$invokeSuspend_u24lambda_u240_u243.setLayoutParams(new FrameLayout.LayoutParams(cursorSize, cursorSize));
                                GradientDrawable $this$invokeSuspend_u24lambda_u240_u243_u240 = new GradientDrawable();
                                $this$invokeSuspend_u24lambda_u240_u243_u240.setShape(1);
                                safeContinuation = safeContinuation2;
                                try {
                                    $this$invokeSuspend_u24lambda_u240_u243_u240.setColor(Color.argb(160, 255, 50, 50));
                                    $this$invokeSuspend_u24lambda_u240_u243_u240.setStroke((int) (2 * dp), -1);
                                    $this$invokeSuspend_u24lambda_u240_u243.setBackground($this$invokeSuspend_u24lambda_u240_u243_u240);
                                    $this$invokeSuspend_u24lambda_u240_u243.setElevation(999.0f);
                                    view = $this$invokeSuspend_u24lambda_u240_u243;
                                } catch (Exception e) {
                                    e = e;
                                    try {
                                        Result.Companion companion = Result.Companion;
                                        cont.resumeWith(Result.constructor-impl(obj));
                                        break;
                                    } catch (Exception e2) {
                                    }
                                }
                            }
                            final View cursorView = view;
                            final FrameLayout $this$invokeSuspend_u24lambda_u240_u244 = new FrameLayout(context);
                            LinearLayout.LayoutParams $this$invokeSuspend_u24lambda_u240_u244_u240 = new LinearLayout.LayoutParams(-1, -1);
                            $this$invokeSuspend_u24lambda_u240_u244_u240.weight = 1.0f;
                            $this$invokeSuspend_u24lambda_u240_u244.setLayoutParams($this$invokeSuspend_u24lambda_u240_u244_u240);
                            $this$invokeSuspend_u24lambda_u240_u244.setFocusable(true);
                            $this$invokeSuspend_u24lambda_u240_u244.setFocusableInTouchMode(true);
                            wv.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                            $this$invokeSuspend_u24lambda_u240_u244.addView(wv);
                            if (cursorView == null) {
                                container = $this$invokeSuspend_u24lambda_u240_u244;
                                r3 = 0;
                            } else {
                                $this$invokeSuspend_u24lambda_u240_u244.addView(cursorView);
                                final Ref.FloatRef cursorX = new Ref.FloatRef();
                                cursorX.element = (metrics.x * 0.95f) / 2.0f;
                                final Ref.FloatRef cursorY = new Ref.FloatRef();
                                cursorY.element = (metrics.y * 0.9f) / 2.0f;
                                $this$invokeSuspend_u24lambda_u240_u244.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.horis.cncverse.UtilsKt$solveCloudflareInWebView$2$1$3
                                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                                    public void onGlobalLayout() {
                                        $this$invokeSuspend_u24lambda_u240_u244.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                        cursorX.element = $this$invokeSuspend_u24lambda_u240_u244.getWidth() / 2.0f;
                                        cursorY.element = $this$invokeSuspend_u24lambda_u240_u244.getHeight() / 2.0f;
                                        cursorView.setTranslationX(cursorX.element - (cursorSize / 2.0f));
                                        cursorView.setTranslationY(cursorY.element - (cursorSize / 2.0f));
                                    }
                                });
                                r3 = 0;
                                View.OnKeyListener onKeyListener = new View.OnKeyListener() { // from class: com.horis.cncverse.UtilsKt$solveCloudflareInWebView$2$1$4
                                    @Override // android.view.View.OnKeyListener
                                    public final boolean onKey(View view2, int keyCode, KeyEvent event) {
                                        if (event.getAction() != 0) {
                                            return false;
                                        }
                                        float step = dp * 10.0f;
                                        switch (keyCode) {
                                            case 19:
                                                UtilsKt.C00412.invokeSuspend$lambda$0$moveCursor(cursorX, $this$invokeSuspend_u24lambda_u240_u244, cursorY, cursorView, cursorSize, 0.0f, -step);
                                                return true;
                                            case 20:
                                                UtilsKt.C00412.invokeSuspend$lambda$0$moveCursor(cursorX, $this$invokeSuspend_u24lambda_u240_u244, cursorY, cursorView, cursorSize, 0.0f, step);
                                                return true;
                                            case 21:
                                                UtilsKt.C00412.invokeSuspend$lambda$0$moveCursor(cursorX, $this$invokeSuspend_u24lambda_u240_u244, cursorY, cursorView, cursorSize, -step, 0.0f);
                                                return true;
                                            case 22:
                                                UtilsKt.C00412.invokeSuspend$lambda$0$moveCursor(cursorX, $this$invokeSuspend_u24lambda_u240_u244, cursorY, cursorView, cursorSize, step, 0.0f);
                                                return true;
                                            case 23:
                                            case 66:
                                                UtilsKt.C00412.invokeSuspend$lambda$0$clickAtCursor(cursorX, cursorY, wv);
                                                return true;
                                            default:
                                                return false;
                                        }
                                    }
                                };
                                container = $this$invokeSuspend_u24lambda_u240_u244;
                                container.setOnKeyListener(onKeyListener);
                            }
                            wrapper.addView($this$invokeSuspend_u24lambda_u240_u242);
                            wrapper.addView(container);
                            final AlertDialog dialog = new AlertDialog.Builder(context).setView(wrapper).setCancelable(r3).create();
                            Window $this$invokeSuspend_u24lambda_u240_u245 = dialog.getWindow();
                            if ($this$invokeSuspend_u24lambda_u240_u245 != null) {
                                $this$invokeSuspend_u24lambda_u240_u245.setBackgroundDrawable(new ColorDrawable(r3));
                                $this$invokeSuspend_u24lambda_u240_u245.setLayout(params.width, params.height);
                            }
                            wv.setTag(dialog);
                            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.horis.cncverse.UtilsKt$solveCloudflareInWebView$2$1$6
                                @Override // android.content.DialogInterface.OnDismissListener
                                public final void onDismiss(DialogInterface it) {
                                    if (!resolved.element) {
                                        resolved.element = true;
                                        try {
                                            wv.destroy();
                                        } catch (Exception e3) {
                                        }
                                        Continuation<String> continuation = cont;
                                        Result.Companion companion2 = Result.Companion;
                                        continuation.resumeWith(Result.constructor-impl((Object) null));
                                    }
                                }
                            });
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.horis.cncverse.UtilsKt$solveCloudflareInWebView$2$1$7
                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (!resolved.element) {
                                        resolved.element = true;
                                        try {
                                            wv.destroy();
                                        } catch (Exception e3) {
                                        }
                                        try {
                                            dialog.dismiss();
                                        } catch (Exception e4) {
                                        }
                                        try {
                                            Continuation<String> continuation = cont;
                                            Result.Companion companion2 = Result.Companion;
                                            continuation.resumeWith(Result.constructor-impl((Object) null));
                                        } catch (Exception e5) {
                                        }
                                    }
                                }
                            }, 120000L);
                            dialog.show();
                            wv.loadUrl(str);
                        } catch (Exception e3) {
                            e = e3;
                            safeContinuation = safeContinuation2;
                        }
                        break;
                    } catch (Exception e4) {
                        e = e4;
                        safeContinuation = safeContinuation2;
                        obj = null;
                    }
                    Object orThrow = safeContinuation.getOrThrow();
                    if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended((Continuation) this);
                    }
                    if (orThrow == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return orThrow;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0$extractAndFinish(Ref.BooleanRef resolved, CookieManager cookieManager, String $url, WebView wv, Continuation<? super String> continuation) {
            List groupValues;
            if (resolved.element) {
                return;
            }
            String cookies = cookieManager.getCookie($url);
            if (cookies == null) {
                cookies = "";
            }
            MatchResult matchResultFind$default = Regex.find$default(new Regex("cf_clearance=([^;]+)"), cookies, 0, 2, (Object) null);
            String cf = (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) ? null : (String) groupValues.get(1);
            String str = cf;
            if (!(str == null || str.length() == 0)) {
                resolved.element = true;
                try {
                    wv.destroy();
                } catch (Exception e) {
                }
                try {
                    Object tag = wv.getTag();
                    Dialog dialog = tag instanceof Dialog ? (Dialog) tag : null;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                } catch (Exception e2) {
                }
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.constructor-impl(cf));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0$moveCursor(Ref.FloatRef cursorX, FrameLayout container, Ref.FloatRef cursorY, View cursorView, int cursorSize, float dx, float dy) {
            cursorX.element = RangesKt.coerceIn(cursorX.element + dx, 0.0f, container.getWidth());
            cursorY.element = RangesKt.coerceIn(cursorY.element + dy, 0.0f, container.getHeight());
            cursorView.setTranslationX(cursorX.element - (cursorSize / 2.0f));
            cursorView.setTranslationY(cursorY.element - (cursorSize / 2.0f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0$clickAtCursor(Ref.FloatRef cursorX, Ref.FloatRef cursorY, WebView wv) {
            long t = SystemClock.uptimeMillis();
            MotionEvent down = MotionEvent.obtain(t, t, 0, cursorX.element, cursorY.element, 0);
            MotionEvent up = MotionEvent.obtain(t, ((long) 120) + t, 1, cursorX.element, cursorY.element, 0);
            wv.dispatchTouchEvent(down);
            wv.dispatchTouchEvent(up);
            down.recycle();
            up.recycle();
        }
    }
}
