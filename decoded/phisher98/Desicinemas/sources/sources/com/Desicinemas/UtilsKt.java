package com.Desicinemas;

import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Desicinemas/classes.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a$\u0010\b\u001a\u0004\u0018\u0001H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086\b¢\u0006\u0002\u0010\r\u001a\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u0010\u001a\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002\u001ah\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00160\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00160\u001a2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\fH\u0086@¢\u0006\u0002\u0010!\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"JSONParser", "Lcom/lagradost/nicehttp/ResponseParser;", "getJSONParser", "()Lcom/lagradost/nicehttp/ResponseParser;", "app", "Lcom/lagradost/nicehttp/Requests;", "getApp", "()Lcom/lagradost/nicehttp/Requests;", "tryParseJson", "T", "", "text", "", "(Ljava/lang/String;)Ljava/lang/Object;", "resolveIframeSrc", "initialUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBaseUrl", "url", "extractorCallbackScope", "Lkotlinx/coroutines/CoroutineScope;", "loadSourceNameExtractor", "", "source", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "quality", "", "size", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Desicinemas"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/Desicinemas/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,204:1\n1#2:205\n*E\n"})
public final class UtilsKt {

    @NotNull
    private static final ResponseParser JSONParser = new ResponseParser() { // from class: com.Desicinemas.UtilsKt$JSONParser$1
        private final ObjectMapper mapper = ExtensionsKt.jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true).configure(JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES.mappedFeature(), true).configure(JsonReadFeature.ALLOW_TRAILING_COMMA.mappedFeature(), true);

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
    private static final Requests app;

    @NotNull
    private static final CoroutineScope extractorCallbackScope;

    /* JADX INFO: renamed from: com.Desicinemas.UtilsKt$loadSourceNameExtractor$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Desicinemas.UtilsKt", f = "Utils.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {171}, m = "loadSourceNameExtractor", n = {"source", "url", "referer", "subtitleCallback", "callback", "quality", "size", "provider", "sizePart"}, nl = {200}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C00181 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C00181(Continuation<? super C00181> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.loadSourceNameExtractor(null, null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Desicinemas.UtilsKt$resolveIframeSrc$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Desicinemas.UtilsKt", f = "Utils.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {62, 101, 110}, m = "resolveIframeSrc", n = {"initialUrl", "initialUrl", "initialResponse", "metaContent", "rawRefreshUrl", "refreshUrl", "initialUrl", "initialResponse", "metaContent", "rawRefreshUrl", "refreshUrl", "refreshResponse", "cookieHeader", "redirectBaseUrl"}, nl = {67, 104, 119}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00201 extends ContinuationImpl {
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

        C00201(Continuation<? super C00201> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.resolveIframeSrc(null, (Continuation) this);
        }
    }

    static {
        Requests $this$app_u24lambda_u240 = new Requests((OkHttpClient) null, (Map) null, (String) null, (Map) null, (Map) null, 0, (TimeUnit) null, 0L, JSONParser, 255, (DefaultConstructorMarker) null);
        $this$app_u24lambda_u240.setDefaultHeaders(MapsKt.mapOf(TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/149.0.0.0 Safari/537.36")));
        app = $this$app_u24lambda_u240;
        extractorCallbackScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    @NotNull
    public static final ResponseParser getJSONParser() {
        return JSONParser;
    }

    @NotNull
    public static final Requests getApp() {
        return app;
    }

    public static final /* synthetic */ <T> T tryParseJson(String str) {
        try {
            ResponseParser jSONParser = getJSONParser();
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) jSONParser.parse(str, Reflection.getOrCreateKotlinClass(Object.class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0368 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:103:0x0369  */
    /* JADX WARN: Code duplicated, block: B:108:0x0391 A[Catch: Exception -> 0x039c, TRY_LEAVE, TryCatch #11 {Exception -> 0x039c, blocks: (B:106:0x0389, B:108:0x0391, B:116:0x03aa, B:122:0x03b6, B:132:0x03d4, B:137:0x03f1), top: B:199:0x0389 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:116:0x03aa A[Catch: Exception -> 0x039c, TRY_ENTER, TryCatch #11 {Exception -> 0x039c, blocks: (B:106:0x0389, B:108:0x0391, B:116:0x03aa, B:122:0x03b6, B:132:0x03d4, B:137:0x03f1), top: B:199:0x0389 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:122:0x03b6 A[Catch: Exception -> 0x039c, TRY_LEAVE, TryCatch #11 {Exception -> 0x039c, blocks: (B:106:0x0389, B:108:0x0391, B:116:0x03aa, B:122:0x03b6, B:132:0x03d4, B:137:0x03f1), top: B:199:0x0389 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:128:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:129:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:132:0x03d4 A[Catch: Exception -> 0x039c, TRY_ENTER, TRY_LEAVE, TryCatch #11 {Exception -> 0x039c, blocks: (B:106:0x0389, B:108:0x0391, B:116:0x03aa, B:122:0x03b6, B:132:0x03d4, B:137:0x03f1), top: B:199:0x0389 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:137:0x03f1 A[Catch: Exception -> 0x039c, TRY_ENTER, TRY_LEAVE, TryCatch #11 {Exception -> 0x039c, blocks: (B:106:0x0389, B:108:0x0391, B:116:0x03aa, B:122:0x03b6, B:132:0x03d4, B:137:0x03f1), top: B:199:0x0389 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0407 A[Catch: Exception -> 0x0472, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0472, blocks: (B:104:0x0378, B:114:0x03a5, B:126:0x03c2, B:143:0x0434, B:139:0x0407), top: B:189:0x0378 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x0434 A[Catch: Exception -> 0x0472, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0472, blocks: (B:104:0x0378, B:114:0x03a5, B:126:0x03c2, B:143:0x0434, B:139:0x0407), top: B:189:0x0378 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x044f  */
    /* JADX WARN: Code duplicated, block: B:193:0x02f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:199:0x0389 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:206:0x0212 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x013a A[Catch: Exception -> 0x0145, TRY_LEAVE, TryCatch #14 {Exception -> 0x0145, blocks: (B:36:0x0132, B:38:0x013a, B:46:0x0152, B:52:0x015e, B:57:0x01a4), top: B:203:0x0132 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x014a  */
    /* JADX WARN: Code duplicated, block: B:46:0x0152 A[Catch: Exception -> 0x0145, TRY_ENTER, TryCatch #14 {Exception -> 0x0145, blocks: (B:36:0x0132, B:38:0x013a, B:46:0x0152, B:52:0x015e, B:57:0x01a4), top: B:203:0x0132 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x015b  */
    /* JADX WARN: Code duplicated, block: B:52:0x015e A[Catch: Exception -> 0x0145, TRY_LEAVE, TryCatch #14 {Exception -> 0x0145, blocks: (B:36:0x0132, B:38:0x013a, B:46:0x0152, B:52:0x015e, B:57:0x01a4), top: B:203:0x0132 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0169 A[Catch: Exception -> 0x049c, TRY_ENTER, TRY_LEAVE, TryCatch #10 {Exception -> 0x049c, blocks: (B:34:0x011f, B:44:0x014d, B:55:0x0169, B:60:0x01b0), top: B:197:0x011f }] */
    /* JADX WARN: Code duplicated, block: B:57:0x01a4 A[Catch: Exception -> 0x0145, TRY_ENTER, TRY_LEAVE, TryCatch #14 {Exception -> 0x0145, blocks: (B:36:0x0132, B:38:0x013a, B:46:0x0152, B:52:0x015e, B:57:0x01a4), top: B:203:0x0132 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:62:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:63:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:66:0x01cf A[Catch: Exception -> 0x01e8, TRY_ENTER, TRY_LEAVE, TryCatch #13 {Exception -> 0x01e8, blocks: (B:79:0x023e, B:66:0x01cf, B:73:0x01fa), top: B:201:0x01b4 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:73:0x01fa A[Catch: Exception -> 0x01e8, TRY_ENTER, TRY_LEAVE, TryCatch #13 {Exception -> 0x01e8, blocks: (B:79:0x023e, B:66:0x01cf, B:73:0x01fa), top: B:201:0x01b4 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x023e A[Catch: Exception -> 0x01e8, TRY_ENTER, TRY_LEAVE, TryCatch #13 {Exception -> 0x01e8, blocks: (B:79:0x023e, B:66:0x01cf, B:73:0x01fa), top: B:201:0x01b4 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:82:0x0259  */
    /* JADX WARN: Code duplicated, block: B:88:0x02b5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:89:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:96:0x0307 A[Catch: Exception -> 0x047e, TRY_ENTER, TryCatch #9 {Exception -> 0x047e, blocks: (B:90:0x02be, B:97:0x030b, B:96:0x0307), top: B:195:0x02be }] */
    /* JADX WARN: Not initialized variable reg: 19, insn: 0x00c1: MOVE (r21 I:??[OBJECT, ARRAY]) = (r19 I:??[OBJECT, ARRAY]), block:B:22:0x00bb */
    @Nullable
    public static final Object resolveIframeSrc(@NotNull String initialUrl, @NotNull Continuation<? super String> continuation) {
        C00201 c00201;
        String initialUrl2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Object obj;
        String str6;
        NiceResponse initialResponse;
        Element elementSelectFirst;
        String strAttr;
        String string;
        String metaContent;
        String str7;
        boolean z;
        String rawRefreshUrl;
        String refreshUrl;
        String str8;
        String str9;
        int i;
        boolean z2;
        String str10;
        String str11;
        String refreshUrl2;
        String str12;
        String refreshUrl3;
        C00201 c00202;
        String str13;
        String redirectBaseUrl;
        String str14;
        Object obj2;
        C00201 c00203;
        NiceResponse initialResponse2;
        String metaContent2;
        String metaContent3;
        String refreshUrl4;
        String cookieHeader;
        Map mapMapOf;
        String redirectBaseUrl2;
        Object obj3;
        Object obj4;
        String initialUrl3;
        Element elementSelectFirst2;
        String strAttr2;
        String rawIframe;
        String str15;
        boolean z3;
        boolean z4;
        String str16;
        String iframeSrc;
        if (continuation instanceof C00201) {
            c00201 = (C00201) continuation;
            if ((c00201.label & Integer.MIN_VALUE) != 0) {
                c00201.label -= Integer.MIN_VALUE;
            } else {
                c00201 = new C00201(continuation);
            }
        } else {
            c00201 = new C00201(continuation);
        }
        Object $result = c00201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00201.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        if (StringsKt.isBlank(initialUrl)) {
                            return null;
                        }
                        Requests requests = app;
                        c00201.L$0 = initialUrl;
                        c00201.label = 1;
                        C00201 c00204 = c00201;
                        str3 = "/";
                        str4 = "//";
                        str5 = "http";
                        obj = coroutine_suspended;
                        str6 = "https:";
                        str2 = null;
                        try {
                            $result = Requests.get$default(requests, initialUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00204, 4062, (Object) null);
                            c00201 = c00204;
                            if ($result == obj) {
                                return obj;
                            }
                            initialUrl2 = initialUrl;
                            try {
                                initialResponse = (NiceResponse) $result;
                                elementSelectFirst = initialResponse.getDocument().selectFirst("meta[http-equiv=refresh]");
                                if (elementSelectFirst == null) {
                                    try {
                                        strAttr = elementSelectFirst.attr("content");
                                        if (strAttr != null) {
                                            string = StringsKt.trim(strAttr).toString();
                                        } else {
                                            string = str2;
                                        }
                                        metaContent = string;
                                        str7 = metaContent;
                                        if (str7 != null || StringsKt.isBlank(str7)) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            System.out.println((Object) "⚠️ No refresh meta tag found");
                                            return str2;
                                        }
                                        rawRefreshUrl = StringsKt.trim(StringsKt.removeSurrounding(StringsKt.removeSurrounding(StringsKt.trim(StringsKt.substringAfter(StringsKt.substringAfter(metaContent, "url=", ""), "URL=", "")).toString(), "'"), "\"")).toString();
                                        if (StringsKt.isBlank(rawRefreshUrl)) {
                                            System.out.println((Object) "⚠️ Refresh URL empty");
                                            return str2;
                                        }
                                        refreshUrl = str5;
                                        try {
                                            if (StringsKt.startsWith(rawRefreshUrl, refreshUrl, true)) {
                                                refreshUrl2 = rawRefreshUrl;
                                                str10 = str6;
                                                str11 = str3;
                                                str9 = str4;
                                                i = 2;
                                                z2 = false;
                                            } else {
                                                str8 = str2;
                                                str9 = str4;
                                                i = 2;
                                                z2 = false;
                                                try {
                                                    if (StringsKt.startsWith$default(rawRefreshUrl, str9, false, 2, str8)) {
                                                        str10 = str6;
                                                        refreshUrl2 = str10 + rawRefreshUrl;
                                                        str11 = str3;
                                                    } else {
                                                        str10 = str6;
                                                        str11 = str3;
                                                        try {
                                                            if (StringsKt.startsWith$default(rawRefreshUrl, str11, false, 2, (Object) null)) {
                                                                refreshUrl2 = getBaseUrl(initialUrl2) + rawRefreshUrl;
                                                            } else {
                                                                try {
                                                                    refreshUrl2 = StringsKt.trimEnd(getBaseUrl(initialUrl2), new char[]{'/'}) + '/' + rawRefreshUrl;
                                                                } catch (Exception e) {
                                                                    e = e;
                                                                    str2 = null;
                                                                }
                                                            }
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                            str2 = null;
                                                        }
                                                    }
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    str2 = str8;
                                                }
                                            }
                                            try {
                                                if (!StringsKt.startsWith$default(refreshUrl2, refreshUrl, z2, i, (Object) null)) {
                                                    System.out.println((Object) ("⚠️ Invalid refresh URL: " + refreshUrl2));
                                                    return null;
                                                }
                                                Requests requests2 = app;
                                                c00201.L$0 = SpillingKt.nullOutSpilledVariable(initialUrl2);
                                                c00201.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse);
                                                c00201.L$2 = SpillingKt.nullOutSpilledVariable(metaContent);
                                                c00201.L$3 = SpillingKt.nullOutSpilledVariable(rawRefreshUrl);
                                                c00201.L$4 = refreshUrl2;
                                                c00201.label = i;
                                                str12 = str11;
                                                refreshUrl3 = refreshUrl2;
                                                c00202 = c00201;
                                                str13 = str10;
                                                redirectBaseUrl = str9;
                                                str14 = refreshUrl;
                                                try {
                                                    obj2 = Requests.get$default(requests2, refreshUrl3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00202, 4062, (Object) null);
                                                    c00203 = c00202;
                                                    if (obj2 == obj) {
                                                        return obj;
                                                    }
                                                    initialResponse2 = initialResponse;
                                                    metaContent2 = metaContent;
                                                    metaContent3 = rawRefreshUrl;
                                                    refreshUrl4 = refreshUrl3;
                                                    try {
                                                        NiceResponse refreshResponse = (NiceResponse) obj2;
                                                        cookieHeader = CollectionsKt.joinToString$default(refreshResponse.getHeaders().values("set-cookie"), "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.Desicinemas.UtilsKt$$ExternalSyntheticLambda0
                                                            public final Object invoke(Object obj5) {
                                                                return StringsKt.substringBefore$default((String) obj5, ";", (String) null, 2, (Object) null);
                                                            }
                                                        }, 30, (Object) null);
                                                        String redirectBaseUrl3 = getBaseUrl(refreshUrl4);
                                                        Requests requests3 = app;
                                                        if (StringsKt.isBlank(cookieHeader)) {
                                                            mapMapOf = MapsKt.emptyMap();
                                                        } else {
                                                            try {
                                                                mapMapOf = MapsKt.mapOf(TuplesKt.to("cookie", cookieHeader));
                                                            } catch (Exception e4) {
                                                                e = e4;
                                                                str2 = null;
                                                            }
                                                        }
                                                        c00203.L$0 = SpillingKt.nullOutSpilledVariable(initialUrl2);
                                                        c00203.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse2);
                                                        c00203.L$2 = SpillingKt.nullOutSpilledVariable(metaContent2);
                                                        c00203.L$3 = SpillingKt.nullOutSpilledVariable(metaContent3);
                                                        c00203.L$4 = SpillingKt.nullOutSpilledVariable(refreshUrl4);
                                                        c00203.L$5 = SpillingKt.nullOutSpilledVariable(refreshResponse);
                                                        c00203.L$6 = SpillingKt.nullOutSpilledVariable(cookieHeader);
                                                        c00203.L$7 = redirectBaseUrl3;
                                                        c00203.label = 3;
                                                        C00201 c00205 = c00203;
                                                        redirectBaseUrl2 = redirectBaseUrl3;
                                                        c00202 = c00205;
                                                        obj3 = Requests.get$default(requests3, redirectBaseUrl2, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00202, 4092, (Object) null);
                                                        if (obj3 == obj) {
                                                            return obj;
                                                        }
                                                        obj4 = obj3;
                                                        initialUrl3 = initialUrl2;
                                                        try {
                                                            NiceResponse finalResponse = (NiceResponse) obj4;
                                                            elementSelectFirst2 = finalResponse.getDocument().selectFirst("iframe");
                                                            if (elementSelectFirst2 != null) {
                                                                try {
                                                                    strAttr2 = elementSelectFirst2.attr("src");
                                                                    if (strAttr2 != null) {
                                                                        rawIframe = StringsKt.trim(strAttr2).toString();
                                                                    } else {
                                                                        rawIframe = null;
                                                                    }
                                                                } catch (Exception e5) {
                                                                    e = e5;
                                                                    initialUrl2 = initialUrl3;
                                                                    str2 = null;
                                                                }
                                                            } else {
                                                                rawIframe = null;
                                                            }
                                                            str15 = rawIframe;
                                                            if (str15 != null || StringsKt.isBlank(str15)) {
                                                                z3 = true;
                                                            } else {
                                                                z3 = false;
                                                            }
                                                            if (z3) {
                                                                System.out.println((Object) "⚠️ Iframe src not found");
                                                                return null;
                                                            }
                                                            if (StringsKt.startsWith(rawIframe, str14, true)) {
                                                                iframeSrc = rawIframe;
                                                                z4 = false;
                                                            } else {
                                                                z4 = false;
                                                                str16 = null;
                                                                try {
                                                                    if (StringsKt.startsWith$default(rawIframe, redirectBaseUrl, false, 2, (Object) null)) {
                                                                        iframeSrc = str13 + rawIframe;
                                                                    } else if (StringsKt.startsWith$default(rawIframe, str12, false, 2, (Object) null)) {
                                                                        iframeSrc = getBaseUrl(redirectBaseUrl2) + rawIframe;
                                                                    } else {
                                                                        iframeSrc = StringsKt.trimEnd(getBaseUrl(redirectBaseUrl2), new char[]{'/'}) + '/' + rawIframe;
                                                                    }
                                                                } catch (Exception e6) {
                                                                    e = e6;
                                                                    str2 = str16;
                                                                }
                                                            }
                                                            str16 = null;
                                                            if (!StringsKt.startsWith$default(iframeSrc, str14, z4, 2, (Object) null)) {
                                                                System.out.println((Object) ("⚠️ Invalid iframe URL: " + iframeSrc));
                                                                return null;
                                                            }
                                                            str2 = null;
                                                            try {
                                                                System.out.println((Object) ("✅ Found iframe src: " + iframeSrc));
                                                                return iframeSrc;
                                                            } catch (Exception e7) {
                                                                e = e7;
                                                            }
                                                        } catch (Exception e8) {
                                                            e = e8;
                                                            str2 = null;
                                                        }
                                                        initialUrl2 = initialUrl3;
                                                    } catch (Exception e9) {
                                                        e = e9;
                                                        str2 = null;
                                                    }
                                                } catch (Exception e10) {
                                                    e = e10;
                                                    str2 = null;
                                                }
                                            } catch (Exception e11) {
                                                e = e11;
                                                str2 = null;
                                            }
                                        } catch (Exception e12) {
                                            e = e12;
                                            str2 = null;
                                        }
                                    } catch (Exception e13) {
                                        e = e13;
                                    }
                                } else {
                                    string = str2;
                                    metaContent = string;
                                    str7 = metaContent;
                                    if (str7 != null) {
                                        z = true;
                                    } else {
                                        z = true;
                                    }
                                    if (z) {
                                        System.out.println((Object) "⚠️ No refresh meta tag found");
                                        return str2;
                                    }
                                    rawRefreshUrl = StringsKt.trim(StringsKt.removeSurrounding(StringsKt.removeSurrounding(StringsKt.trim(StringsKt.substringAfter(StringsKt.substringAfter(metaContent, "url=", ""), "URL=", "")).toString(), "'"), "\"")).toString();
                                    if (StringsKt.isBlank(rawRefreshUrl)) {
                                        System.out.println((Object) "⚠️ Refresh URL empty");
                                        return str2;
                                    }
                                    refreshUrl = str5;
                                    if (StringsKt.startsWith(rawRefreshUrl, refreshUrl, true)) {
                                        refreshUrl2 = rawRefreshUrl;
                                        str10 = str6;
                                        str11 = str3;
                                        str9 = str4;
                                        i = 2;
                                        z2 = false;
                                    } else {
                                        str8 = str2;
                                        str9 = str4;
                                        i = 2;
                                        z2 = false;
                                        if (StringsKt.startsWith$default(rawRefreshUrl, str9, false, 2, str8)) {
                                            str10 = str6;
                                            refreshUrl2 = str10 + rawRefreshUrl;
                                            str11 = str3;
                                        } else {
                                            str10 = str6;
                                            str11 = str3;
                                            if (StringsKt.startsWith$default(rawRefreshUrl, str11, false, 2, (Object) null)) {
                                                refreshUrl2 = getBaseUrl(initialUrl2) + rawRefreshUrl;
                                            } else {
                                                refreshUrl2 = StringsKt.trimEnd(getBaseUrl(initialUrl2), new char[]{'/'}) + '/' + rawRefreshUrl;
                                            }
                                        }
                                    }
                                    if (!StringsKt.startsWith$default(refreshUrl2, refreshUrl, z2, i, (Object) null)) {
                                        System.out.println((Object) ("⚠️ Invalid refresh URL: " + refreshUrl2));
                                        return null;
                                    }
                                    Requests requests4 = app;
                                    c00201.L$0 = SpillingKt.nullOutSpilledVariable(initialUrl2);
                                    c00201.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse);
                                    c00201.L$2 = SpillingKt.nullOutSpilledVariable(metaContent);
                                    c00201.L$3 = SpillingKt.nullOutSpilledVariable(rawRefreshUrl);
                                    c00201.L$4 = refreshUrl2;
                                    c00201.label = i;
                                    str12 = str11;
                                    refreshUrl3 = refreshUrl2;
                                    c00202 = c00201;
                                    str13 = str10;
                                    redirectBaseUrl = str9;
                                    str14 = refreshUrl;
                                    obj2 = Requests.get$default(requests4, refreshUrl3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00202, 4062, (Object) null);
                                    c00203 = c00202;
                                    if (obj2 == obj) {
                                        return obj;
                                    }
                                    initialResponse2 = initialResponse;
                                    metaContent2 = metaContent;
                                    metaContent3 = rawRefreshUrl;
                                    refreshUrl4 = refreshUrl3;
                                    NiceResponse refreshResponse2 = (NiceResponse) obj2;
                                    cookieHeader = CollectionsKt.joinToString$default(refreshResponse2.getHeaders().values("set-cookie"), "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.Desicinemas.UtilsKt$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj5) {
                                            return StringsKt.substringBefore$default((String) obj5, ";", (String) null, 2, (Object) null);
                                        }
                                    }, 30, (Object) null);
                                    String redirectBaseUrl4 = getBaseUrl(refreshUrl4);
                                    Requests requests5 = app;
                                    if (StringsKt.isBlank(cookieHeader)) {
                                        mapMapOf = MapsKt.mapOf(TuplesKt.to("cookie", cookieHeader));
                                    } else {
                                        mapMapOf = MapsKt.emptyMap();
                                    }
                                    c00203.L$0 = SpillingKt.nullOutSpilledVariable(initialUrl2);
                                    c00203.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse2);
                                    c00203.L$2 = SpillingKt.nullOutSpilledVariable(metaContent2);
                                    c00203.L$3 = SpillingKt.nullOutSpilledVariable(metaContent3);
                                    c00203.L$4 = SpillingKt.nullOutSpilledVariable(refreshUrl4);
                                    c00203.L$5 = SpillingKt.nullOutSpilledVariable(refreshResponse2);
                                    c00203.L$6 = SpillingKt.nullOutSpilledVariable(cookieHeader);
                                    c00203.L$7 = redirectBaseUrl4;
                                    c00203.label = 3;
                                    C00201 c00206 = c00203;
                                    redirectBaseUrl2 = redirectBaseUrl4;
                                    c00202 = c00206;
                                    obj3 = Requests.get$default(requests5, redirectBaseUrl2, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00202, 4092, (Object) null);
                                    if (obj3 == obj) {
                                        return obj;
                                    }
                                    obj4 = obj3;
                                    initialUrl3 = initialUrl2;
                                    NiceResponse finalResponse2 = (NiceResponse) obj4;
                                    elementSelectFirst2 = finalResponse2.getDocument().selectFirst("iframe");
                                    if (elementSelectFirst2 != null) {
                                        strAttr2 = elementSelectFirst2.attr("src");
                                        if (strAttr2 != null) {
                                            rawIframe = StringsKt.trim(strAttr2).toString();
                                        } else {
                                            rawIframe = null;
                                        }
                                    } else {
                                        rawIframe = null;
                                    }
                                    str15 = rawIframe;
                                    if (str15 != null) {
                                        z3 = true;
                                    } else {
                                        z3 = true;
                                    }
                                    if (z3) {
                                        System.out.println((Object) "⚠️ Iframe src not found");
                                        return null;
                                    }
                                    if (StringsKt.startsWith(rawIframe, str14, true)) {
                                        iframeSrc = rawIframe;
                                        z4 = false;
                                    } else {
                                        z4 = false;
                                        str16 = null;
                                        if (StringsKt.startsWith$default(rawIframe, redirectBaseUrl, false, 2, (Object) null)) {
                                            iframeSrc = str13 + rawIframe;
                                        } else if (StringsKt.startsWith$default(rawIframe, str12, false, 2, (Object) null)) {
                                            iframeSrc = getBaseUrl(redirectBaseUrl2) + rawIframe;
                                        } else {
                                            iframeSrc = StringsKt.trimEnd(getBaseUrl(redirectBaseUrl2), new char[]{'/'}) + '/' + rawIframe;
                                        }
                                    }
                                    str16 = null;
                                    if (!StringsKt.startsWith$default(iframeSrc, str14, z4, 2, (Object) null)) {
                                        System.out.println((Object) ("⚠️ Invalid iframe URL: " + iframeSrc));
                                        return null;
                                    }
                                    str2 = null;
                                    System.out.println((Object) ("✅ Found iframe src: " + iframeSrc));
                                    return iframeSrc;
                                    initialUrl2 = initialUrl3;
                                }
                            } catch (Exception e14) {
                                e = e14;
                            }
                        } catch (Exception e15) {
                            e = e15;
                            initialUrl2 = initialUrl;
                        }
                        break;
                    } catch (Exception e16) {
                        e = e16;
                        str2 = null;
                        initialUrl2 = initialUrl;
                    }
                    System.out.println((Object) ("❌ Error resolving iframe: " + e.getMessage()));
                    return str2;
                case 1:
                    String initialUrl4 = (String) c00201.L$0;
                    ResultKt.throwOnFailure($result);
                    initialUrl2 = initialUrl4;
                    obj = coroutine_suspended;
                    str6 = "https:";
                    str3 = "/";
                    str4 = "//";
                    str5 = "http";
                    str2 = null;
                    initialResponse = (NiceResponse) $result;
                    elementSelectFirst = initialResponse.getDocument().selectFirst("meta[http-equiv=refresh]");
                    if (elementSelectFirst == null) {
                        string = str2;
                        metaContent = string;
                        str7 = metaContent;
                        if (str7 != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (z) {
                            System.out.println((Object) "⚠️ No refresh meta tag found");
                            return str2;
                        }
                        rawRefreshUrl = StringsKt.trim(StringsKt.removeSurrounding(StringsKt.removeSurrounding(StringsKt.trim(StringsKt.substringAfter(StringsKt.substringAfter(metaContent, "url=", ""), "URL=", "")).toString(), "'"), "\"")).toString();
                        if (StringsKt.isBlank(rawRefreshUrl)) {
                            System.out.println((Object) "⚠️ Refresh URL empty");
                            return str2;
                        }
                        refreshUrl = str5;
                        if (StringsKt.startsWith(rawRefreshUrl, refreshUrl, true)) {
                            refreshUrl2 = rawRefreshUrl;
                            str10 = str6;
                            str11 = str3;
                            str9 = str4;
                            i = 2;
                            z2 = false;
                        } else {
                            str8 = str2;
                            str9 = str4;
                            i = 2;
                            z2 = false;
                            if (StringsKt.startsWith$default(rawRefreshUrl, str9, false, 2, str8)) {
                                str10 = str6;
                                refreshUrl2 = str10 + rawRefreshUrl;
                                str11 = str3;
                            } else {
                                str10 = str6;
                                str11 = str3;
                                if (StringsKt.startsWith$default(rawRefreshUrl, str11, false, 2, (Object) null)) {
                                    refreshUrl2 = getBaseUrl(initialUrl2) + rawRefreshUrl;
                                } else {
                                    refreshUrl2 = StringsKt.trimEnd(getBaseUrl(initialUrl2), new char[]{'/'}) + '/' + rawRefreshUrl;
                                }
                            }
                        }
                        if (!StringsKt.startsWith$default(refreshUrl2, refreshUrl, z2, i, (Object) null)) {
                            System.out.println((Object) ("⚠️ Invalid refresh URL: " + refreshUrl2));
                            return null;
                        }
                        Requests requests6 = app;
                        c00201.L$0 = SpillingKt.nullOutSpilledVariable(initialUrl2);
                        c00201.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse);
                        c00201.L$2 = SpillingKt.nullOutSpilledVariable(metaContent);
                        c00201.L$3 = SpillingKt.nullOutSpilledVariable(rawRefreshUrl);
                        c00201.L$4 = refreshUrl2;
                        c00201.label = i;
                        str12 = str11;
                        refreshUrl3 = refreshUrl2;
                        c00202 = c00201;
                        str13 = str10;
                        redirectBaseUrl = str9;
                        str14 = refreshUrl;
                        obj2 = Requests.get$default(requests6, refreshUrl3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00202, 4062, (Object) null);
                        c00203 = c00202;
                        if (obj2 == obj) {
                            return obj;
                        }
                        initialResponse2 = initialResponse;
                        metaContent2 = metaContent;
                        metaContent3 = rawRefreshUrl;
                        refreshUrl4 = refreshUrl3;
                        NiceResponse refreshResponse3 = (NiceResponse) obj2;
                        cookieHeader = CollectionsKt.joinToString$default(refreshResponse3.getHeaders().values("set-cookie"), "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.Desicinemas.UtilsKt$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj5) {
                                return StringsKt.substringBefore$default((String) obj5, ";", (String) null, 2, (Object) null);
                            }
                        }, 30, (Object) null);
                        String redirectBaseUrl5 = getBaseUrl(refreshUrl4);
                        Requests requests7 = app;
                        if (StringsKt.isBlank(cookieHeader)) {
                            mapMapOf = MapsKt.mapOf(TuplesKt.to("cookie", cookieHeader));
                        } else {
                            mapMapOf = MapsKt.emptyMap();
                        }
                        c00203.L$0 = SpillingKt.nullOutSpilledVariable(initialUrl2);
                        c00203.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse2);
                        c00203.L$2 = SpillingKt.nullOutSpilledVariable(metaContent2);
                        c00203.L$3 = SpillingKt.nullOutSpilledVariable(metaContent3);
                        c00203.L$4 = SpillingKt.nullOutSpilledVariable(refreshUrl4);
                        c00203.L$5 = SpillingKt.nullOutSpilledVariable(refreshResponse3);
                        c00203.L$6 = SpillingKt.nullOutSpilledVariable(cookieHeader);
                        c00203.L$7 = redirectBaseUrl5;
                        c00203.label = 3;
                        C00201 c00207 = c00203;
                        redirectBaseUrl2 = redirectBaseUrl5;
                        c00202 = c00207;
                        obj3 = Requests.get$default(requests7, redirectBaseUrl2, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00202, 4092, (Object) null);
                        if (obj3 == obj) {
                            return obj;
                        }
                        obj4 = obj3;
                        initialUrl3 = initialUrl2;
                        NiceResponse finalResponse3 = (NiceResponse) obj4;
                        elementSelectFirst2 = finalResponse3.getDocument().selectFirst("iframe");
                        if (elementSelectFirst2 != null) {
                            strAttr2 = elementSelectFirst2.attr("src");
                            if (strAttr2 != null) {
                                rawIframe = StringsKt.trim(strAttr2).toString();
                            } else {
                                rawIframe = null;
                            }
                        } else {
                            rawIframe = null;
                        }
                        str15 = rawIframe;
                        if (str15 != null) {
                            z3 = true;
                        } else {
                            z3 = true;
                        }
                        if (z3) {
                            System.out.println((Object) "⚠️ Iframe src not found");
                            return null;
                        }
                        if (StringsKt.startsWith(rawIframe, str14, true)) {
                            iframeSrc = rawIframe;
                            z4 = false;
                        } else {
                            z4 = false;
                            str16 = null;
                            if (StringsKt.startsWith$default(rawIframe, redirectBaseUrl, false, 2, (Object) null)) {
                                iframeSrc = str13 + rawIframe;
                            } else if (StringsKt.startsWith$default(rawIframe, str12, false, 2, (Object) null)) {
                                iframeSrc = getBaseUrl(redirectBaseUrl2) + rawIframe;
                            } else {
                                iframeSrc = StringsKt.trimEnd(getBaseUrl(redirectBaseUrl2), new char[]{'/'}) + '/' + rawIframe;
                            }
                        }
                        str16 = null;
                        if (!StringsKt.startsWith$default(iframeSrc, str14, z4, 2, (Object) null)) {
                            System.out.println((Object) ("⚠️ Invalid iframe URL: " + iframeSrc));
                            return null;
                        }
                        str2 = null;
                        System.out.println((Object) ("✅ Found iframe src: " + iframeSrc));
                        return iframeSrc;
                        initialUrl2 = initialUrl3;
                        break;
                    } else {
                        strAttr = elementSelectFirst.attr("content");
                        if (strAttr != null) {
                            string = StringsKt.trim(strAttr).toString();
                        } else {
                            string = str2;
                        }
                        metaContent = string;
                        str7 = metaContent;
                        if (str7 != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (z) {
                            System.out.println((Object) "⚠️ No refresh meta tag found");
                            return str2;
                        }
                        rawRefreshUrl = StringsKt.trim(StringsKt.removeSurrounding(StringsKt.removeSurrounding(StringsKt.trim(StringsKt.substringAfter(StringsKt.substringAfter(metaContent, "url=", ""), "URL=", "")).toString(), "'"), "\"")).toString();
                        if (StringsKt.isBlank(rawRefreshUrl)) {
                            System.out.println((Object) "⚠️ Refresh URL empty");
                            return str2;
                        }
                        refreshUrl = str5;
                        if (StringsKt.startsWith(rawRefreshUrl, refreshUrl, true)) {
                            refreshUrl2 = rawRefreshUrl;
                            str10 = str6;
                            str11 = str3;
                            str9 = str4;
                            i = 2;
                            z2 = false;
                        } else {
                            str8 = str2;
                            str9 = str4;
                            i = 2;
                            z2 = false;
                            if (StringsKt.startsWith$default(rawRefreshUrl, str9, false, 2, str8)) {
                                str10 = str6;
                                refreshUrl2 = str10 + rawRefreshUrl;
                                str11 = str3;
                            } else {
                                str10 = str6;
                                str11 = str3;
                                if (StringsKt.startsWith$default(rawRefreshUrl, str11, false, 2, (Object) null)) {
                                    refreshUrl2 = getBaseUrl(initialUrl2) + rawRefreshUrl;
                                } else {
                                    refreshUrl2 = StringsKt.trimEnd(getBaseUrl(initialUrl2), new char[]{'/'}) + '/' + rawRefreshUrl;
                                }
                            }
                        }
                        if (!StringsKt.startsWith$default(refreshUrl2, refreshUrl, z2, i, (Object) null)) {
                            System.out.println((Object) ("⚠️ Invalid refresh URL: " + refreshUrl2));
                            return null;
                        }
                        Requests requests8 = app;
                        c00201.L$0 = SpillingKt.nullOutSpilledVariable(initialUrl2);
                        c00201.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse);
                        c00201.L$2 = SpillingKt.nullOutSpilledVariable(metaContent);
                        c00201.L$3 = SpillingKt.nullOutSpilledVariable(rawRefreshUrl);
                        c00201.L$4 = refreshUrl2;
                        c00201.label = i;
                        str12 = str11;
                        refreshUrl3 = refreshUrl2;
                        c00202 = c00201;
                        str13 = str10;
                        redirectBaseUrl = str9;
                        str14 = refreshUrl;
                        obj2 = Requests.get$default(requests8, refreshUrl3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00202, 4062, (Object) null);
                        c00203 = c00202;
                        if (obj2 == obj) {
                            return obj;
                        }
                        initialResponse2 = initialResponse;
                        metaContent2 = metaContent;
                        metaContent3 = rawRefreshUrl;
                        refreshUrl4 = refreshUrl3;
                        NiceResponse refreshResponse4 = (NiceResponse) obj2;
                        cookieHeader = CollectionsKt.joinToString$default(refreshResponse4.getHeaders().values("set-cookie"), "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.Desicinemas.UtilsKt$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj5) {
                                return StringsKt.substringBefore$default((String) obj5, ";", (String) null, 2, (Object) null);
                            }
                        }, 30, (Object) null);
                        String redirectBaseUrl6 = getBaseUrl(refreshUrl4);
                        Requests requests9 = app;
                        if (StringsKt.isBlank(cookieHeader)) {
                            mapMapOf = MapsKt.mapOf(TuplesKt.to("cookie", cookieHeader));
                        } else {
                            mapMapOf = MapsKt.emptyMap();
                        }
                        c00203.L$0 = SpillingKt.nullOutSpilledVariable(initialUrl2);
                        c00203.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse2);
                        c00203.L$2 = SpillingKt.nullOutSpilledVariable(metaContent2);
                        c00203.L$3 = SpillingKt.nullOutSpilledVariable(metaContent3);
                        c00203.L$4 = SpillingKt.nullOutSpilledVariable(refreshUrl4);
                        c00203.L$5 = SpillingKt.nullOutSpilledVariable(refreshResponse4);
                        c00203.L$6 = SpillingKt.nullOutSpilledVariable(cookieHeader);
                        c00203.L$7 = redirectBaseUrl6;
                        c00203.label = 3;
                        C00201 c00208 = c00203;
                        redirectBaseUrl2 = redirectBaseUrl6;
                        c00202 = c00208;
                        obj3 = Requests.get$default(requests9, redirectBaseUrl2, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00202, 4092, (Object) null);
                        if (obj3 == obj) {
                            return obj;
                        }
                        obj4 = obj3;
                        initialUrl3 = initialUrl2;
                        NiceResponse finalResponse4 = (NiceResponse) obj4;
                        elementSelectFirst2 = finalResponse4.getDocument().selectFirst("iframe");
                        if (elementSelectFirst2 != null) {
                            strAttr2 = elementSelectFirst2.attr("src");
                            if (strAttr2 != null) {
                                rawIframe = StringsKt.trim(strAttr2).toString();
                            } else {
                                rawIframe = null;
                            }
                        } else {
                            rawIframe = null;
                        }
                        str15 = rawIframe;
                        if (str15 != null) {
                            z3 = true;
                        } else {
                            z3 = true;
                        }
                        if (z3) {
                            System.out.println((Object) "⚠️ Iframe src not found");
                            return null;
                        }
                        if (StringsKt.startsWith(rawIframe, str14, true)) {
                            iframeSrc = rawIframe;
                            z4 = false;
                        } else {
                            z4 = false;
                            str16 = null;
                            if (StringsKt.startsWith$default(rawIframe, redirectBaseUrl, false, 2, (Object) null)) {
                                iframeSrc = str13 + rawIframe;
                            } else if (StringsKt.startsWith$default(rawIframe, str12, false, 2, (Object) null)) {
                                iframeSrc = getBaseUrl(redirectBaseUrl2) + rawIframe;
                            } else {
                                iframeSrc = StringsKt.trimEnd(getBaseUrl(redirectBaseUrl2), new char[]{'/'}) + '/' + rawIframe;
                            }
                        }
                        str16 = null;
                        if (!StringsKt.startsWith$default(iframeSrc, str14, z4, 2, (Object) null)) {
                            System.out.println((Object) ("⚠️ Invalid iframe URL: " + iframeSrc));
                            return null;
                        }
                        str2 = null;
                        System.out.println((Object) ("✅ Found iframe src: " + iframeSrc));
                        return iframeSrc;
                        initialUrl2 = initialUrl3;
                        break;
                    }
                    System.out.println((Object) ("❌ Error resolving iframe: " + e.getMessage()));
                    return str2;
                case 2:
                    String refreshUrl5 = (String) c00201.L$4;
                    String rawRefreshUrl2 = (String) c00201.L$3;
                    String metaContent4 = (String) c00201.L$2;
                    NiceResponse initialResponse3 = (NiceResponse) c00201.L$1;
                    String initialUrl5 = (String) c00201.L$0;
                    ResultKt.throwOnFailure($result);
                    refreshUrl4 = refreshUrl5;
                    initialUrl2 = initialUrl5;
                    obj2 = $result;
                    obj = coroutine_suspended;
                    metaContent3 = rawRefreshUrl2;
                    str13 = "https:";
                    str12 = "/";
                    redirectBaseUrl = "//";
                    metaContent2 = metaContent4;
                    initialResponse2 = initialResponse3;
                    c00203 = c00201;
                    str14 = "http";
                    NiceResponse refreshResponse5 = (NiceResponse) obj2;
                    cookieHeader = CollectionsKt.joinToString$default(refreshResponse5.getHeaders().values("set-cookie"), "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.Desicinemas.UtilsKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj5) {
                            return StringsKt.substringBefore$default((String) obj5, ";", (String) null, 2, (Object) null);
                        }
                    }, 30, (Object) null);
                    String redirectBaseUrl7 = getBaseUrl(refreshUrl4);
                    Requests requests10 = app;
                    if (StringsKt.isBlank(cookieHeader)) {
                        mapMapOf = MapsKt.mapOf(TuplesKt.to("cookie", cookieHeader));
                        break;
                    } else {
                        mapMapOf = MapsKt.emptyMap();
                    }
                    c00203.L$0 = SpillingKt.nullOutSpilledVariable(initialUrl2);
                    c00203.L$1 = SpillingKt.nullOutSpilledVariable(initialResponse2);
                    c00203.L$2 = SpillingKt.nullOutSpilledVariable(metaContent2);
                    c00203.L$3 = SpillingKt.nullOutSpilledVariable(metaContent3);
                    c00203.L$4 = SpillingKt.nullOutSpilledVariable(refreshUrl4);
                    c00203.L$5 = SpillingKt.nullOutSpilledVariable(refreshResponse5);
                    c00203.L$6 = SpillingKt.nullOutSpilledVariable(cookieHeader);
                    c00203.L$7 = redirectBaseUrl7;
                    c00203.label = 3;
                    C00201 c00209 = c00203;
                    redirectBaseUrl2 = redirectBaseUrl7;
                    c00202 = c00209;
                    obj3 = Requests.get$default(requests10, redirectBaseUrl2, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00202, 4092, (Object) null);
                    if (obj3 == obj) {
                        return obj;
                    }
                    obj4 = obj3;
                    initialUrl3 = initialUrl2;
                    NiceResponse finalResponse5 = (NiceResponse) obj4;
                    elementSelectFirst2 = finalResponse5.getDocument().selectFirst("iframe");
                    if (elementSelectFirst2 != null) {
                        strAttr2 = elementSelectFirst2.attr("src");
                        if (strAttr2 != null) {
                            rawIframe = StringsKt.trim(strAttr2).toString();
                        } else {
                            rawIframe = null;
                        }
                    } else {
                        rawIframe = null;
                    }
                    str15 = rawIframe;
                    if (str15 != null) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        System.out.println((Object) "⚠️ Iframe src not found");
                        return null;
                    }
                    if (StringsKt.startsWith(rawIframe, str14, true)) {
                        iframeSrc = rawIframe;
                        z4 = false;
                    } else {
                        z4 = false;
                        str16 = null;
                        if (StringsKt.startsWith$default(rawIframe, redirectBaseUrl, false, 2, (Object) null)) {
                            iframeSrc = str13 + rawIframe;
                        } else if (StringsKt.startsWith$default(rawIframe, str12, false, 2, (Object) null)) {
                            iframeSrc = getBaseUrl(redirectBaseUrl2) + rawIframe;
                        } else {
                            iframeSrc = StringsKt.trimEnd(getBaseUrl(redirectBaseUrl2), new char[]{'/'}) + '/' + rawIframe;
                        }
                    }
                    str16 = null;
                    if (!StringsKt.startsWith$default(iframeSrc, str14, z4, 2, (Object) null)) {
                        System.out.println((Object) ("⚠️ Invalid iframe URL: " + iframeSrc));
                        return null;
                    }
                    str2 = null;
                    System.out.println((Object) ("✅ Found iframe src: " + iframeSrc));
                    return iframeSrc;
                    initialUrl2 = initialUrl3;
                    System.out.println((Object) ("❌ Error resolving iframe: " + e.getMessage()));
                    return str2;
                case 3:
                    String redirectBaseUrl8 = (String) c00201.L$7;
                    initialUrl3 = (String) c00201.L$0;
                    ResultKt.throwOnFailure($result);
                    obj4 = $result;
                    str13 = "https:";
                    str12 = "/";
                    str14 = "http";
                    redirectBaseUrl2 = redirectBaseUrl8;
                    redirectBaseUrl = "//";
                    NiceResponse finalResponse6 = (NiceResponse) obj4;
                    elementSelectFirst2 = finalResponse6.getDocument().selectFirst("iframe");
                    if (elementSelectFirst2 != null) {
                        strAttr2 = elementSelectFirst2.attr("src");
                        if (strAttr2 != null) {
                            rawIframe = StringsKt.trim(strAttr2).toString();
                        } else {
                            rawIframe = null;
                        }
                    } else {
                        rawIframe = null;
                    }
                    str15 = rawIframe;
                    if (str15 != null) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        System.out.println((Object) "⚠️ Iframe src not found");
                        return null;
                    }
                    if (StringsKt.startsWith(rawIframe, str14, true)) {
                        iframeSrc = rawIframe;
                        z4 = false;
                    } else {
                        z4 = false;
                        str16 = null;
                        if (StringsKt.startsWith$default(rawIframe, redirectBaseUrl, false, 2, (Object) null)) {
                            iframeSrc = str13 + rawIframe;
                        } else if (StringsKt.startsWith$default(rawIframe, str12, false, 2, (Object) null)) {
                            iframeSrc = getBaseUrl(redirectBaseUrl2) + rawIframe;
                        } else {
                            iframeSrc = StringsKt.trimEnd(getBaseUrl(redirectBaseUrl2), new char[]{'/'}) + '/' + rawIframe;
                        }
                    }
                    str16 = null;
                    if (!StringsKt.startsWith$default(iframeSrc, str14, z4, 2, (Object) null)) {
                        System.out.println((Object) ("⚠️ Invalid iframe URL: " + iframeSrc));
                        return null;
                    }
                    str2 = null;
                    System.out.println((Object) ("✅ Found iframe src: " + iframeSrc));
                    return iframeSrc;
                    initialUrl2 = initialUrl3;
                    System.out.println((Object) ("❌ Error resolving iframe: " + e.getMessage()));
                    return str2;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e17) {
            e = e17;
            initialUrl2 = initialUrl;
            str2 = str;
        }
    }

    private static final String getBaseUrl(String url) {
        try {
            Url it = URLUtilsKt.Url(url);
            return it.getProtocol().getName() + "://" + it.getHost();
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public static final Object loadSourceNameExtractor(@NotNull String source, @NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull final Function1<? super ExtractorLink, Unit> function2, @Nullable final Integer quality, @NotNull String size, @NotNull Continuation<? super Unit> continuation) {
        C00181 c00181;
        if (continuation instanceof C00181) {
            c00181 = (C00181) continuation;
            if ((c00181.label & Integer.MIN_VALUE) != 0) {
                c00181.label -= Integer.MIN_VALUE;
            } else {
                c00181 = new C00181(continuation);
            }
        } else {
            c00181 = new C00181(continuation);
        }
        Object $result = c00181.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00181.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final String provider = StringsKt.trim(source).toString();
                if (StringsKt.isBlank(provider)) {
                    provider = null;
                }
                String it = StringsKt.trim(size).toString();
                final String sizePart = StringsKt.isBlank(it) ? null : it;
                Function1 function3 = new Function1() { // from class: com.Desicinemas.UtilsKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        return UtilsKt.loadSourceNameExtractor$lambda$2(function2, provider, sizePart, quality, (ExtractorLink) obj);
                    }
                };
                c00181.L$0 = SpillingKt.nullOutSpilledVariable(source);
                c00181.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00181.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00181.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00181.L$4 = SpillingKt.nullOutSpilledVariable(function2);
                c00181.L$5 = SpillingKt.nullOutSpilledVariable(quality);
                c00181.L$6 = SpillingKt.nullOutSpilledVariable(size);
                c00181.L$7 = SpillingKt.nullOutSpilledVariable(provider);
                c00181.L$8 = SpillingKt.nullOutSpilledVariable(sizePart);
                c00181.label = 1;
                if (ExtractorApiKt.loadExtractor(url, referer, function1, function3, c00181) == coroutine_suspended) {
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

    public static /* synthetic */ Object loadSourceNameExtractor$default(String str, String str2, String str3, Function1 function1, Function1 function2, Integer num, String str4, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 32) != 0) {
            num = null;
        }
        if ((i & 64) != 0) {
            str4 = "";
        }
        return loadSourceNameExtractor(str, str2, str3, function1, function2, num, str4, continuation);
    }

    static final Unit loadSourceNameExtractor$lambda$2(Function1 $callback, String $provider, String $sizePart, Integer $quality, ExtractorLink link) {
        BuildersKt.launch$default(extractorCallbackScope, (CoroutineContext) null, (CoroutineStart) null, new UtilsKt$loadSourceNameExtractor$2$1($callback, link, $provider, $sizePart, $quality, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}
