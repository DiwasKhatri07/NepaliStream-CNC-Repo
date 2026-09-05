package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URI;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00100\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00100\u0014H\u0096@¢\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0018\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J$\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u001f\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002J\f\u0010&\u001a\u00020\u0005*\u00020$H\u0002J\f\u0010'\u001a\u00020$*\u00020\u0005H\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/phisher98/PpzjYoutube;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "apiUrl", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildPayloadJson", "fileId", "userId", "domain", "encryptHexAES", "plaintext", "password", "decryptHexAES", "hex", "deriveKeyIv", "Lkotlin/Pair;", "", "salt", "toHex", "hexToBytes", "md5", "input", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/PpzjYoutube\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,4003:1\n1#2:4004\n73#3,5:4005\n2068#4,2:4010\n1739#4:4012\n1814#4,3:4013\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/PpzjYoutube\n*L\n2662#1:4005,5\n2682#1:4010,2\n2812#1:4012\n2812#1:4013,3\n*E\n"})
public class PpzjYoutube extends ExtractorApi {

    @NotNull
    private final String name = "PpzjYoutube";

    @NotNull
    private final String mainUrl = "https://if9.ppzj-youtube.cfd";
    private final boolean requiresReferer = true;

    @NotNull
    private final String apiUrl = "https://api-play-270325.ppzj-youtube.cfd/api/tp1rd/playiframe";

    /* JADX INFO: renamed from: com.phisher98.PpzjYoutube$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.PpzjYoutube", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2641, 2658, 2677}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "TAG", "domain", "headers", "$this", "url", "referer", "subtitleCallback", "callback", "TAG", "domain", "headers", "html", "matches", "encryptedFileId", "encryptedUserId", "fileId", "userId", "payload", "encryptedPayload", "signatureInput", "signature", "body", "$this", "url", "referer", "subtitleCallback", "callback", "TAG", "domain", "headers", "html", "matches", "encryptedFileId", "encryptedUserId", "fileId", "userId", "payload", "encryptedPayload", "signatureInput", "signature", "body", "response", "encryptedVideo", "videoUrl"}, nl = {2642, 2662, 2682}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21"}, v = 2)
    static final class C00581 extends ContinuationImpl {
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

        C00581(Continuation<? super C00581> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PpzjYoutube.getUrl$suspendImpl(PpzjYoutube.this, null, null, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:43:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:49:0x03e5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:59:0x041c A[Catch: Exception -> 0x041f, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x041f, blocks: (B:59:0x041c, B:66:0x042f, B:69:0x0436, B:73:0x0443), top: B:113:0x041a }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0424  */
    /* JADX WARN: Code duplicated, block: B:66:0x042f A[Catch: Exception -> 0x041f, TRY_ENTER, TryCatch #3 {Exception -> 0x041f, blocks: (B:59:0x041c, B:66:0x042f, B:69:0x0436, B:73:0x0443), top: B:113:0x041a }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0433  */
    /* JADX WARN: Code duplicated, block: B:69:0x0436 A[Catch: Exception -> 0x041f, TryCatch #3 {Exception -> 0x041f, blocks: (B:59:0x041c, B:66:0x042f, B:69:0x0436, B:73:0x0443), top: B:113:0x041a }] */
    /* JADX WARN: Code duplicated, block: B:70:0x043e  */
    /* JADX WARN: Code duplicated, block: B:73:0x0443 A[Catch: Exception -> 0x041f, TRY_LEAVE, TryCatch #3 {Exception -> 0x041f, blocks: (B:59:0x041c, B:66:0x042f, B:69:0x0436, B:73:0x0443), top: B:113:0x041a }] */
    /* JADX WARN: Code duplicated, block: B:76:0x046b A[Catch: Exception -> 0x0556, TRY_ENTER, TRY_LEAVE, TryCatch #9 {Exception -> 0x0556, blocks: (B:51:0x03f7, B:57:0x0418, B:64:0x0425, B:76:0x046b, B:56:0x0413, B:53:0x03fc), top: B:124:0x03f7, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x0511 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:81:0x0512  */
    /* JADX WARN: Code duplicated, block: B:85:0x0535 A[Catch: Exception -> 0x0549, TRY_LEAVE, TryCatch #7 {Exception -> 0x0549, blocks: (B:82:0x0527, B:83:0x052f, B:85:0x0535), top: B:120:0x0527 }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    static /* synthetic */ Object getUrl$suspendImpl(PpzjYoutube $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00581 c00581;
        Function1<? super ExtractorLink, Unit> function3;
        String TAG;
        Map headers;
        Object obj;
        int i;
        String domain;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function4;
        Function1<? super ExtractorLink, Unit> function5;
        Object obj2;
        String TAG2;
        String domain2;
        PpzjYoutube $this2;
        String html;
        List matches;
        String encryptedFileId;
        String str;
        String signatureInput;
        Map headers2;
        RequestBody body;
        String domain3;
        String TAG3;
        String encryptedUserId;
        String signature;
        String userId;
        String payload;
        String encryptedPayload;
        String fileId;
        PpzjYoutube $this3;
        int i2;
        String encryptedFileId2;
        String signatureInput2;
        PpzjYoutube $this4;
        List matches2;
        Map headers3;
        RequestBody body2;
        Function1<? super ExtractorLink, Unit> function6;
        String encryptedFileId3;
        Object safe;
        Map response;
        Object obj3;
        String str2;
        String strSubstringBefore$default;
        String encryptedVideo;
        String TAG4;
        String TAG5;
        String element$iv;
        if (continuation instanceof C00581) {
            c00581 = (C00581) continuation;
            if ((c00581.label & Integer.MIN_VALUE) != 0) {
                c00581.label -= Integer.MIN_VALUE;
            } else {
                c00581 = $this.new C00581(continuation);
            }
        } else {
            c00581 = $this.new C00581(continuation);
        }
        C00581 c00582 = c00581;
        Object $result = c00582.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00582.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    URI it = new URI(url);
                    String domain4 = it.getScheme() + "://" + it.getHost();
                    Map headers4 = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/149.0.0.0 Safari/537.36"), TuplesKt.to("Referer", domain4), TuplesKt.to("X-Requested-With", "XMLHttpRequest"), TuplesKt.to("Content-Type", "application/x-www-form-urlencoded")});
                    try {
                        Requests app = MainActivityKt.getApp();
                        c00582.L$0 = $this;
                        c00582.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        c00582.L$2 = referer;
                        c00582.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                        c00582.L$4 = function2;
                        c00582.L$5 = "PpzjYoutube";
                        c00582.L$6 = domain4;
                        c00582.L$7 = headers4;
                        c00582.label = 1;
                        headers = headers4;
                        obj = coroutine_suspended;
                        i = 0;
                        domain = "application/x-www-form-urlencoded";
                        try {
                            Object obj4 = Requests.get$default(app, url, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00582, 4092, (Object) null);
                            c00582 = c00582;
                            if (obj4 == obj) {
                                return obj;
                            }
                            url2 = url;
                            referer2 = referer;
                            function4 = function1;
                            function5 = function2;
                            obj2 = obj4;
                            TAG2 = "PpzjYoutube";
                            domain2 = domain4;
                            $this2 = $this;
                            try {
                                html = ((NiceResponse) obj2).getText();
                                matches = SequencesKt.toList(SequencesKt.map(Regex.findAll$default(new Regex("const\\s*id(?:User|file)_enc\\s*=\\s*\"([^\"]+)\""), html, i, 2, (Object) null), new Function1() { // from class: com.phisher98.PpzjYoutube$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj5) {
                                        return PpzjYoutube.getUrl$lambda$1((MatchResult) obj5);
                                    }
                                }));
                                encryptedFileId = (String) matches.get(i);
                                String encryptedUserId2 = (String) matches.get(1);
                                String fileId2 = $this2.decryptHexAES(encryptedFileId, "jcLycoRJT6OWjoWspgLMOZwS3aSS0lEn");
                                String userId2 = $this2.decryptHexAES(encryptedUserId2, "PZZ3J3LDbLT0GY7qSA5wW5vchqgpO36O");
                                if (referer2 == null) {
                                    str = "https://m4uhd.vip";
                                } else {
                                    str = referer2;
                                }
                                String payload2 = $this2.buildPayloadJson(fileId2, userId2, str);
                                String encryptedPayload2 = $this2.encryptHexAES(payload2, "vlVbUQhkOhoSfyteyzGeeDzU0BHoeTyZ");
                                signatureInput = encryptedPayload2 + "KRWN3AdgmxEMcd2vLN1ju9qKe8Feco5h";
                                String signature2 = $this2.md5(signatureInput);
                                headers2 = headers;
                                body = RequestBody.Companion.create("data=" + encryptedPayload2 + "%7C" + signature2, MediaType.Companion.get(domain));
                                Requests app2 = MainActivityKt.getApp();
                                String str3 = $this2.apiUrl;
                                c00582.L$0 = $this2;
                                c00582.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                                c00582.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                                c00582.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                                c00582.L$4 = function5;
                                c00582.L$5 = TAG2;
                                c00582.L$6 = domain2;
                                c00582.L$7 = SpillingKt.nullOutSpilledVariable(headers2);
                                c00582.L$8 = SpillingKt.nullOutSpilledVariable(html);
                                c00582.L$9 = SpillingKt.nullOutSpilledVariable(matches);
                                c00582.L$10 = SpillingKt.nullOutSpilledVariable(encryptedFileId);
                                c00582.L$11 = SpillingKt.nullOutSpilledVariable(encryptedUserId2);
                                c00582.L$12 = SpillingKt.nullOutSpilledVariable(fileId2);
                                c00582.L$13 = SpillingKt.nullOutSpilledVariable(userId2);
                                c00582.L$14 = SpillingKt.nullOutSpilledVariable(payload2);
                                c00582.L$15 = SpillingKt.nullOutSpilledVariable(encryptedPayload2);
                                c00582.L$16 = SpillingKt.nullOutSpilledVariable(signatureInput);
                                c00582.L$17 = SpillingKt.nullOutSpilledVariable(signature2);
                                c00582.L$18 = SpillingKt.nullOutSpilledVariable(body);
                                c00582.label = 2;
                                domain3 = domain2;
                                TAG3 = TAG2;
                                C00581 c00583 = c00582;
                                encryptedUserId = encryptedUserId2;
                                signature = signature2;
                                userId = userId2;
                                payload = payload2;
                                encryptedPayload = encryptedPayload2;
                                function3 = function5;
                                fileId = fileId2;
                                $this3 = $this2;
                                i2 = 2;
                                try {
                                    $result = Requests.post$default(app2, str3, headers2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, body, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00583, 65276, (Object) null);
                                    c00582 = c00583;
                                    if ($result == obj) {
                                        return obj;
                                    }
                                    encryptedFileId2 = encryptedFileId;
                                    signatureInput2 = signatureInput;
                                    $this4 = $this3;
                                    matches2 = matches;
                                    headers3 = headers2;
                                    body2 = body;
                                    function6 = function3;
                                    TAG = TAG3;
                                    encryptedFileId3 = domain3;
                                    try {
                                        NiceResponse this_$iv = (NiceResponse) $result;
                                        try {
                                            ResponseParser parser = this_$iv.getParser();
                                            Intrinsics.checkNotNull(parser);
                                            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                                        } catch (Exception e$iv) {
                                            e$iv.printStackTrace();
                                            safe = null;
                                        }
                                        response = (Map) safe;
                                        try {
                                            if (response == null) {
                                                return Unit.INSTANCE;
                                            }
                                            obj3 = response.get("data");
                                            if (obj3 instanceof String) {
                                                str2 = (String) obj3;
                                            } else {
                                                str2 = null;
                                            }
                                            if (str2 != null) {
                                                strSubstringBefore$default = StringsKt.substringBefore$default(str2, "|", (String) null, i2, (Object) null);
                                            } else {
                                                strSubstringBefore$default = null;
                                            }
                                            encryptedVideo = strSubstringBefore$default;
                                            if (encryptedVideo == null) {
                                                Log.INSTANCE.e(TAG, "ERROR: No 'data' field in response or data is null");
                                                Log.INSTANCE.d(TAG, "Response keys: " + response.keySet());
                                                return Unit.INSTANCE;
                                            }
                                            String videoUrl = $this4.decryptHexAES(encryptedVideo, "oJwmvmVBajMaRCTklxbfjavpQO7SZpsL");
                                            M3u8Helper.Companion companion = M3u8Helper.Companion;
                                            String name = $this4.getName();
                                            Integer numBoxInt = Boxing.boxInt(Qualities.P1080.getValue());
                                            c00582.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                                            c00582.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                                            c00582.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                                            c00582.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                                            c00582.L$4 = function6;
                                            c00582.L$5 = TAG;
                                            c00582.L$6 = SpillingKt.nullOutSpilledVariable(encryptedFileId3);
                                            c00582.L$7 = SpillingKt.nullOutSpilledVariable(headers3);
                                            c00582.L$8 = SpillingKt.nullOutSpilledVariable(html);
                                            c00582.L$9 = SpillingKt.nullOutSpilledVariable(matches2);
                                            c00582.L$10 = SpillingKt.nullOutSpilledVariable(encryptedFileId2);
                                            c00582.L$11 = SpillingKt.nullOutSpilledVariable(encryptedUserId);
                                            c00582.L$12 = SpillingKt.nullOutSpilledVariable(fileId);
                                            c00582.L$13 = SpillingKt.nullOutSpilledVariable(userId);
                                            c00582.L$14 = SpillingKt.nullOutSpilledVariable(payload);
                                            c00582.L$15 = SpillingKt.nullOutSpilledVariable(encryptedPayload);
                                            c00582.L$16 = SpillingKt.nullOutSpilledVariable(signatureInput2);
                                            c00582.L$17 = SpillingKt.nullOutSpilledVariable(signature);
                                            c00582.L$18 = SpillingKt.nullOutSpilledVariable(body2);
                                            c00582.L$19 = SpillingKt.nullOutSpilledVariable(response);
                                            c00582.L$20 = SpillingKt.nullOutSpilledVariable(encryptedVideo);
                                            c00582.L$21 = SpillingKt.nullOutSpilledVariable(videoUrl);
                                            c00582.label = 3;
                                            TAG4 = TAG;
                                            try {
                                                $result = M3u8Helper.Companion.generateM3u8$default(companion, name, videoUrl, encryptedFileId3, numBoxInt, (Map) null, (String) null, c00582, 48, (Object) null);
                                                if ($result == obj) {
                                                    return obj;
                                                }
                                                TAG5 = TAG4;
                                                element$iv = encryptedFileId3;
                                                try {
                                                    Iterable $this$forEach$iv = (Iterable) $result;
                                                    for (Object element$iv2 : $this$forEach$iv) {
                                                        String domain5 = element$iv;
                                                        function6.invoke(element$iv2);
                                                        element$iv = domain5;
                                                    }
                                                } catch (Exception e) {
                                                    e = e;
                                                    function3 = function6;
                                                    TAG = TAG5;
                                                    Log.INSTANCE.e(TAG, "==================== ERROR ====================");
                                                    Log.INSTANCE.e(TAG, "Exception occurred: " + e.getMessage());
                                                    Log.INSTANCE.e(TAG, "Exception: " + ExceptionsKt.stackTraceToString(e));
                                                }
                                                return Unit.INSTANCE;
                                            } catch (Exception e2) {
                                                e = e2;
                                                function3 = function6;
                                                TAG = TAG4;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            function3 = function6;
                                        }
                                        break;
                                    } catch (Exception e4) {
                                        e = e4;
                                        function3 = function6;
                                    }
                                    Log.INSTANCE.e(TAG, "==================== ERROR ====================");
                                    Log.INSTANCE.e(TAG, "Exception occurred: " + e.getMessage());
                                    Log.INSTANCE.e(TAG, "Exception: " + ExceptionsKt.stackTraceToString(e));
                                    return Unit.INSTANCE;
                                } catch (Exception e5) {
                                    e = e5;
                                    TAG = TAG3;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                function3 = function5;
                                TAG = TAG2;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            function3 = function2;
                            TAG = "PpzjYoutube";
                        }
                    } catch (Exception e8) {
                        e = e8;
                        function3 = function2;
                        TAG = "PpzjYoutube";
                    }
                } catch (Exception e9) {
                    e = e9;
                    function3 = function2;
                    TAG = "PpzjYoutube";
                }
                break;
            case 1:
                Map headers5 = (Map) c00582.L$7;
                domain2 = (String) c00582.L$6;
                String TAG6 = (String) c00582.L$5;
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c00582.L$4;
                Function1<? super SubtitleFile, Unit> function8 = (Function1) c00582.L$3;
                String referer3 = (String) c00582.L$2;
                String url3 = (String) c00582.L$1;
                PpzjYoutube $this5 = (PpzjYoutube) c00582.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    headers = headers5;
                    domain = "application/x-www-form-urlencoded";
                    obj2 = $result;
                    function4 = function8;
                    referer2 = referer3;
                    url2 = url3;
                    TAG2 = TAG6;
                    i = 0;
                    $this2 = $this5;
                    obj = coroutine_suspended;
                    function5 = function7;
                    html = ((NiceResponse) obj2).getText();
                    matches = SequencesKt.toList(SequencesKt.map(Regex.findAll$default(new Regex("const\\s*id(?:User|file)_enc\\s*=\\s*\"([^\"]+)\""), html, i, 2, (Object) null), new Function1() { // from class: com.phisher98.PpzjYoutube$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj5) {
                            return PpzjYoutube.getUrl$lambda$1((MatchResult) obj5);
                        }
                    }));
                    encryptedFileId = (String) matches.get(i);
                    String encryptedUserId3 = (String) matches.get(1);
                    String fileId3 = $this2.decryptHexAES(encryptedFileId, "jcLycoRJT6OWjoWspgLMOZwS3aSS0lEn");
                    String userId3 = $this2.decryptHexAES(encryptedUserId3, "PZZ3J3LDbLT0GY7qSA5wW5vchqgpO36O");
                    if (referer2 == null) {
                        str = "https://m4uhd.vip";
                    } else {
                        str = referer2;
                    }
                    String payload3 = $this2.buildPayloadJson(fileId3, userId3, str);
                    String encryptedPayload3 = $this2.encryptHexAES(payload3, "vlVbUQhkOhoSfyteyzGeeDzU0BHoeTyZ");
                    signatureInput = encryptedPayload3 + "KRWN3AdgmxEMcd2vLN1ju9qKe8Feco5h";
                    String signature3 = $this2.md5(signatureInput);
                    headers2 = headers;
                    body = RequestBody.Companion.create("data=" + encryptedPayload3 + "%7C" + signature3, MediaType.Companion.get(domain));
                    Requests app3 = MainActivityKt.getApp();
                    String str4 = $this2.apiUrl;
                    c00582.L$0 = $this2;
                    c00582.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    c00582.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00582.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                    c00582.L$4 = function5;
                    c00582.L$5 = TAG2;
                    c00582.L$6 = domain2;
                    c00582.L$7 = SpillingKt.nullOutSpilledVariable(headers2);
                    c00582.L$8 = SpillingKt.nullOutSpilledVariable(html);
                    c00582.L$9 = SpillingKt.nullOutSpilledVariable(matches);
                    c00582.L$10 = SpillingKt.nullOutSpilledVariable(encryptedFileId);
                    c00582.L$11 = SpillingKt.nullOutSpilledVariable(encryptedUserId3);
                    c00582.L$12 = SpillingKt.nullOutSpilledVariable(fileId3);
                    c00582.L$13 = SpillingKt.nullOutSpilledVariable(userId3);
                    c00582.L$14 = SpillingKt.nullOutSpilledVariable(payload3);
                    c00582.L$15 = SpillingKt.nullOutSpilledVariable(encryptedPayload3);
                    c00582.L$16 = SpillingKt.nullOutSpilledVariable(signatureInput);
                    c00582.L$17 = SpillingKt.nullOutSpilledVariable(signature3);
                    c00582.L$18 = SpillingKt.nullOutSpilledVariable(body);
                    c00582.label = 2;
                    domain3 = domain2;
                    TAG3 = TAG2;
                    C00581 c00584 = c00582;
                    encryptedUserId = encryptedUserId3;
                    signature = signature3;
                    userId = userId3;
                    payload = payload3;
                    encryptedPayload = encryptedPayload3;
                    function3 = function5;
                    fileId = fileId3;
                    $this3 = $this2;
                    i2 = 2;
                    $result = Requests.post$default(app3, str4, headers2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, body, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00584, 65276, (Object) null);
                    c00582 = c00584;
                    if ($result == obj) {
                        return obj;
                    }
                    encryptedFileId2 = encryptedFileId;
                    signatureInput2 = signatureInput;
                    $this4 = $this3;
                    matches2 = matches;
                    headers3 = headers2;
                    body2 = body;
                    function6 = function3;
                    TAG = TAG3;
                    encryptedFileId3 = domain3;
                    NiceResponse this_$iv2 = (NiceResponse) $result;
                    ResponseParser parser2 = this_$iv2.getParser();
                    Intrinsics.checkNotNull(parser2);
                    safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                    response = (Map) safe;
                    if (response == null) {
                        return Unit.INSTANCE;
                    }
                    obj3 = response.get("data");
                    if (obj3 instanceof String) {
                        str2 = (String) obj3;
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        strSubstringBefore$default = StringsKt.substringBefore$default(str2, "|", (String) null, i2, (Object) null);
                    } else {
                        strSubstringBefore$default = null;
                    }
                    encryptedVideo = strSubstringBefore$default;
                    if (encryptedVideo == null) {
                        Log.INSTANCE.e(TAG, "ERROR: No 'data' field in response or data is null");
                        Log.INSTANCE.d(TAG, "Response keys: " + response.keySet());
                        return Unit.INSTANCE;
                    }
                    String videoUrl2 = $this4.decryptHexAES(encryptedVideo, "oJwmvmVBajMaRCTklxbfjavpQO7SZpsL");
                    M3u8Helper.Companion companion2 = M3u8Helper.Companion;
                    String name2 = $this4.getName();
                    Integer numBoxInt2 = Boxing.boxInt(Qualities.P1080.getValue());
                    c00582.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                    c00582.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    c00582.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00582.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                    c00582.L$4 = function6;
                    c00582.L$5 = TAG;
                    c00582.L$6 = SpillingKt.nullOutSpilledVariable(encryptedFileId3);
                    c00582.L$7 = SpillingKt.nullOutSpilledVariable(headers3);
                    c00582.L$8 = SpillingKt.nullOutSpilledVariable(html);
                    c00582.L$9 = SpillingKt.nullOutSpilledVariable(matches2);
                    c00582.L$10 = SpillingKt.nullOutSpilledVariable(encryptedFileId2);
                    c00582.L$11 = SpillingKt.nullOutSpilledVariable(encryptedUserId);
                    c00582.L$12 = SpillingKt.nullOutSpilledVariable(fileId);
                    c00582.L$13 = SpillingKt.nullOutSpilledVariable(userId);
                    c00582.L$14 = SpillingKt.nullOutSpilledVariable(payload);
                    c00582.L$15 = SpillingKt.nullOutSpilledVariable(encryptedPayload);
                    c00582.L$16 = SpillingKt.nullOutSpilledVariable(signatureInput2);
                    c00582.L$17 = SpillingKt.nullOutSpilledVariable(signature);
                    c00582.L$18 = SpillingKt.nullOutSpilledVariable(body2);
                    c00582.L$19 = SpillingKt.nullOutSpilledVariable(response);
                    c00582.L$20 = SpillingKt.nullOutSpilledVariable(encryptedVideo);
                    c00582.L$21 = SpillingKt.nullOutSpilledVariable(videoUrl2);
                    c00582.label = 3;
                    TAG4 = TAG;
                    $result = M3u8Helper.Companion.generateM3u8$default(companion2, name2, videoUrl2, encryptedFileId3, numBoxInt2, (Map) null, (String) null, c00582, 48, (Object) null);
                    if ($result == obj) {
                        return obj;
                    }
                    TAG5 = TAG4;
                    element$iv = encryptedFileId3;
                    Iterable $this$forEach$iv2 = (Iterable) $result;
                    while (r2.hasNext()) {
                        String domain6 = element$iv;
                        function6.invoke(element$iv2);
                        element$iv = domain6;
                    }
                    return Unit.INSTANCE;
                    Log.INSTANCE.e(TAG, "==================== ERROR ====================");
                    Log.INSTANCE.e(TAG, "Exception occurred: " + e.getMessage());
                    Log.INSTANCE.e(TAG, "Exception: " + ExceptionsKt.stackTraceToString(e));
                    return Unit.INSTANCE;
                } catch (Exception e10) {
                    e = e10;
                    function3 = function7;
                    TAG = TAG6;
                }
                break;
            case 2:
                RequestBody body3 = (RequestBody) c00582.L$18;
                String signature4 = (String) c00582.L$17;
                String signatureInput3 = (String) c00582.L$16;
                String encryptedPayload4 = (String) c00582.L$15;
                String payload4 = (String) c00582.L$14;
                String userId4 = (String) c00582.L$13;
                String fileId4 = (String) c00582.L$12;
                String encryptedUserId4 = (String) c00582.L$11;
                String encryptedFileId4 = (String) c00582.L$10;
                List matches3 = (List) c00582.L$9;
                String html2 = (String) c00582.L$8;
                body2 = body3;
                headers3 = (Map) c00582.L$7;
                String domain7 = (String) c00582.L$6;
                String TAG7 = (String) c00582.L$5;
                Function1<? super ExtractorLink, Unit> function9 = (Function1) c00582.L$4;
                Function1<? super SubtitleFile, Unit> function10 = (Function1) c00582.L$3;
                String referer4 = (String) c00582.L$2;
                String url4 = (String) c00582.L$1;
                PpzjYoutube $this6 = (PpzjYoutube) c00582.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    signature = signature4;
                    encryptedFileId2 = encryptedFileId4;
                    signatureInput2 = signatureInput3;
                    encryptedPayload = encryptedPayload4;
                    html = html2;
                    payload = payload4;
                    userId = userId4;
                    fileId = fileId4;
                    encryptedUserId = encryptedUserId4;
                    encryptedFileId3 = domain7;
                    function6 = function9;
                    function4 = function10;
                    referer2 = referer4;
                    url2 = url4;
                    i2 = 2;
                    $this4 = $this6;
                    obj = coroutine_suspended;
                    matches2 = matches3;
                    TAG = TAG7;
                    NiceResponse this_$iv3 = (NiceResponse) $result;
                    ResponseParser parser3 = this_$iv3.getParser();
                    Intrinsics.checkNotNull(parser3);
                    safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                    response = (Map) safe;
                    if (response == null) {
                        return Unit.INSTANCE;
                    }
                    obj3 = response.get("data");
                    if (obj3 instanceof String) {
                        str2 = (String) obj3;
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        strSubstringBefore$default = StringsKt.substringBefore$default(str2, "|", (String) null, i2, (Object) null);
                    } else {
                        strSubstringBefore$default = null;
                    }
                    encryptedVideo = strSubstringBefore$default;
                    if (encryptedVideo == null) {
                        Log.INSTANCE.e(TAG, "ERROR: No 'data' field in response or data is null");
                        Log.INSTANCE.d(TAG, "Response keys: " + response.keySet());
                        return Unit.INSTANCE;
                    }
                    String videoUrl3 = $this4.decryptHexAES(encryptedVideo, "oJwmvmVBajMaRCTklxbfjavpQO7SZpsL");
                    M3u8Helper.Companion companion3 = M3u8Helper.Companion;
                    String name3 = $this4.getName();
                    Integer numBoxInt3 = Boxing.boxInt(Qualities.P1080.getValue());
                    c00582.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                    c00582.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    c00582.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00582.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                    c00582.L$4 = function6;
                    c00582.L$5 = TAG;
                    c00582.L$6 = SpillingKt.nullOutSpilledVariable(encryptedFileId3);
                    c00582.L$7 = SpillingKt.nullOutSpilledVariable(headers3);
                    c00582.L$8 = SpillingKt.nullOutSpilledVariable(html);
                    c00582.L$9 = SpillingKt.nullOutSpilledVariable(matches2);
                    c00582.L$10 = SpillingKt.nullOutSpilledVariable(encryptedFileId2);
                    c00582.L$11 = SpillingKt.nullOutSpilledVariable(encryptedUserId);
                    c00582.L$12 = SpillingKt.nullOutSpilledVariable(fileId);
                    c00582.L$13 = SpillingKt.nullOutSpilledVariable(userId);
                    c00582.L$14 = SpillingKt.nullOutSpilledVariable(payload);
                    c00582.L$15 = SpillingKt.nullOutSpilledVariable(encryptedPayload);
                    c00582.L$16 = SpillingKt.nullOutSpilledVariable(signatureInput2);
                    c00582.L$17 = SpillingKt.nullOutSpilledVariable(signature);
                    c00582.L$18 = SpillingKt.nullOutSpilledVariable(body2);
                    c00582.L$19 = SpillingKt.nullOutSpilledVariable(response);
                    c00582.L$20 = SpillingKt.nullOutSpilledVariable(encryptedVideo);
                    c00582.L$21 = SpillingKt.nullOutSpilledVariable(videoUrl3);
                    c00582.label = 3;
                    TAG4 = TAG;
                    $result = M3u8Helper.Companion.generateM3u8$default(companion3, name3, videoUrl3, encryptedFileId3, numBoxInt3, (Map) null, (String) null, c00582, 48, (Object) null);
                    if ($result == obj) {
                        return obj;
                    }
                    TAG5 = TAG4;
                    element$iv = encryptedFileId3;
                    Iterable $this$forEach$iv3 = (Iterable) $result;
                    while (r2.hasNext()) {
                        String domain8 = element$iv;
                        function6.invoke(element$iv2);
                        element$iv = domain8;
                    }
                    return Unit.INSTANCE;
                } catch (Exception e11) {
                    e = e11;
                    TAG = TAG7;
                    function3 = function9;
                }
                Log.INSTANCE.e(TAG, "==================== ERROR ====================");
                Log.INSTANCE.e(TAG, "Exception occurred: " + e.getMessage());
                Log.INSTANCE.e(TAG, "Exception: " + ExceptionsKt.stackTraceToString(e));
                return Unit.INSTANCE;
            case 3:
                String domain9 = (String) c00582.L$6;
                TAG5 = (String) c00582.L$5;
                Function1<? super ExtractorLink, Unit> function11 = (Function1) c00582.L$4;
                try {
                    ResultKt.throwOnFailure($result);
                    element$iv = domain9;
                    function6 = function11;
                    Iterable $this$forEach$iv4 = (Iterable) $result;
                    while (r2.hasNext()) {
                        String domain10 = element$iv;
                        function6.invoke(element$iv2);
                        element$iv = domain10;
                    }
                } catch (Exception e12) {
                    e = e12;
                    TAG = TAG5;
                    function3 = function11;
                    break;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final String getUrl$lambda$1(MatchResult it) {
        return (String) it.getGroupValues().get(1);
    }

    private final String buildPayloadJson(String fileId, String userId, String domain) {
        String payload = StringsKt.replace$default(StringsKt.replace$default(StringsKt.trimIndent("\n        {\n          \"idfile\":\"" + fileId + "\",\n          \"iduser\":\"" + userId + "\",\n          \"domain_play\":\"" + domain + "\",\n          \"platform\":\"Linux armv81\",\n          \"hlsSupport\":true,\n          \"jwplayer\":{\n            \"Browser\":{\n              \"androidNative\":false,\n              \"chrome\":true,\n              \"edge\":false,\n              \"facebook\":false,\n              \"firefox\":false,\n              \"ie\":false,\n              \"msie\":false,\n              \"safari\":false,\n              \"version\":{\n                \"version\":\"137.0.0.0\",\n                \"major\":137,\n                \"minor\":0\n              }\n            },\n            \"OS\":{\n              \"android\":true,\n              \"iOS\":false,\n              \"mobile\":true,\n              \"mac\":false,\n              \"iPad\":false,\n              \"iPhone\":false,\n              \"windows\":false,\n              \"tizen\":false,\n              \"tizenApp\":false,\n              \"version\":{\n                \"version\":\"10\",\n                \"major\":10,\n                \"minor\":null\n              }\n            },\n            \"Features\":{\n              \"iframe\":false,\n              \"passiveEvents\":true,\n              \"backgroundLoading\":true\n            }\n          }\n        }\n        "), "\n", "", false, 4, (Object) null), "  ", "", false, 4, (Object) null);
        return payload;
    }

    private final String encryptHexAES(String plaintext, String password) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] salt = new byte[8];
        new SecureRandom().nextBytes(salt);
        byte[] bytes = password.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        Pair<byte[], byte[]> pairDeriveKeyIv = deriveKeyIv(bytes, salt);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, new SecretKeySpec((byte[]) pairDeriveKeyIv.getFirst(), "AES"), new IvParameterSpec((byte[]) pairDeriveKeyIv.getSecond()));
        byte[] bytes2 = plaintext.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        byte[] encrypted = cipher.doFinal(bytes2);
        byte[] bytes3 = "Salted__".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
        byte[] result = ArraysKt.plus(ArraysKt.plus(bytes3, salt), encrypted);
        return toHex(result);
    }

    private final String decryptHexAES(String hex, String password) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bytes = hexToBytes(hex);
        byte[] salt = ArraysKt.copyOfRange(bytes, 8, 16);
        byte[] ciphertext = ArraysKt.copyOfRange(bytes, 16, bytes.length);
        byte[] bytes2 = password.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        Pair<byte[], byte[]> pairDeriveKeyIv = deriveKeyIv(bytes2, salt);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, new SecretKeySpec((byte[]) pairDeriveKeyIv.getFirst(), "AES"), new IvParameterSpec((byte[]) pairDeriveKeyIv.getSecond()));
        return new String(cipher.doFinal(ciphertext), Charsets.UTF_8);
    }

    private final Pair<byte[], byte[]> deriveKeyIv(byte[] password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] keyIv = new byte[48];
        byte[] prev = new byte[0];
        int generated = 0;
        while (generated < 48) {
            md5.reset();
            md5.update(prev);
            md5.update(password);
            md5.update(salt);
            prev = md5.digest();
            System.arraycopy(prev, 0, keyIv, generated, prev.length);
            generated += prev.length;
        }
        return new Pair<>(ArraysKt.copyOfRange(keyIv, 0, 32), ArraysKt.copyOfRange(keyIv, 32, 48));
    }

    private final String toHex(byte[] $this$toHex) {
        return ArraysKt.joinToString$default($this$toHex, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.PpzjYoutube$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return PpzjYoutube.toHex$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence toHex$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final byte[] hexToBytes(String $this$hexToBytes) {
        Iterable $this$map$iv = StringsKt.chunked($this$hexToBytes, 2);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(Byte.valueOf((byte) Integer.parseInt(it, CharsKt.checkRadix(16))));
        }
        return CollectionsKt.toByteArray((List) destination$iv$iv);
    }

    private final String md5(String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = input.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return ArraysKt.joinToString$default(messageDigest.digest(bytes), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.PpzjYoutube$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return PpzjYoutube.md5$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence md5$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
