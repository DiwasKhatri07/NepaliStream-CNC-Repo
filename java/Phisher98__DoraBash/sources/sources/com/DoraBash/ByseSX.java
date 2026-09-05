package com.DoraBash;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import io.ktor.http.CodecsKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.reflect.KType;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/DoraBash/classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\b\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0018J,\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u001fH\u0002J(\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0\u001a2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u001dH\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010'\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020+2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020+H\u0002J$\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u001d2\b\b\u0002\u00100\u001a\u00020\u001fH\u0002J\u0018\u00101\u001a\u0004\u0018\u0001022\u0006\u0010\b\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0018J\u0010\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0002J\u0018\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u000205H\u0082@¢\u0006\u0002\u00107JH\u00108\u001a\u00020*2\u0006\u0010\u0014\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u00010\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020*0;2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020*0;H\u0096@¢\u0006\u0002\u0010?R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006@"}, d2 = {"Lcom/DoraBash/ByseSX;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "b64UrlDecode", "", "s", "urlSafeBase64", "bytes", "getBaseUrl", "url", "getCodeFromUrl", "getDetails", "Lcom/DoraBash/DetailsRoot;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fp", "", "", "x", "", "y", "", "z", "fh", "r", "wn", "ch", "re", "", "t", "e", "ye", "", "", "gr", "wr", "er", "tStr", "rLimit", "getPlayback", "Lcom/DoraBash/PlaybackRoot;", "buildAesKey", "playback", "Lcom/DoraBash/Playback;", "decryptPlayback", "(Lcom/DoraBash/Playback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUrl", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DoraBash"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/DoraBash/ByseSX\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,655:1\n1#2:656\n1#2:721\n73#3,5:657\n73#3,5:662\n73#3,5:667\n73#3,5:672\n73#3,5:677\n73#3,5:682\n73#3,5:687\n73#3,5:692\n73#3,5:697\n73#3,5:702\n73#3,5:741\n73#3,5:746\n1739#4:707\n1814#4,3:708\n2982#4,7:711\n93#5,2:718\n63#5:720\n64#5,15:722\n95#5,2:739\n50#6:737\n43#6:738\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/DoraBash/ByseSX\n*L\n543#1:721\n183#1:657,5\n187#1:662,5\n433#1:667,5\n438#1:672,5\n457#1:677,5\n466#1:682,5\n470#1:687,5\n485#1:692,5\n500#1:697,5\n514#1:702,5\n571#1:741,5\n574#1:746,5\n524#1:707\n524#1:708,3\n524#1:711,7\n543#1:718,2\n543#1:720\n543#1:722,15\n543#1:739,2\n543#1:737\n543#1:738\n*E\n"})
public class ByseSX extends ExtractorApi {

    @NotNull
    private final String name = "Byse";

    @NotNull
    private final String mainUrl = "https://bysevepoin.com";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.DoraBash.ByseSX$getDetails$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.DoraBash.ByseSX", f = "Extractor.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {183, 187}, m = "getDetails", n = {"mainUrl", "base", "code", "url", "mainUrl", "base", "code", "url", "detailsRoot"}, nl = {656, 661}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByseSX.this.getDetails(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.DoraBash.ByseSX$getPlayback$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.DoraBash.ByseSX", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {433, 438, 457, 466, 470, 485, 500, 510}, m = "getPlayback", n = {"mainUrl", "base", "code", "embed", "detailsUrl", "referer", "headers", "mainUrl", "base", "code", "embed", "detailsUrl", "referer", "headers", "details", "mainUrl", "base", "code", "embed", "detailsUrl", "referer", "headers", "details", "detailsRoot", "embedBase", "embedCode", "settingsUrl", "mainUrl", "base", "code", "embed", "detailsUrl", "referer", "headers", "details", "detailsRoot", "embedBase", "embedCode", "settingsUrl", "settingsRes", "fprintData", "finalFprint", "challengeUrl", "mainUrl", "base", "code", "embed", "detailsUrl", "referer", "headers", "details", "detailsRoot", "embedBase", "embedCode", "settingsUrl", "settingsRes", "fprintData", "finalFprint", "challengeUrl", "challengeRes", "attestUrl", "mainUrl", "base", "code", "embed", "detailsUrl", "referer", "headers", "details", "detailsRoot", "embedBase", "embedCode", "settingsUrl", "settingsRes", "fprintData", "finalFprint", "challengeUrl", "challengeRes", "captchaUrl", "mainUrl", "base", "code", "embed", "detailsUrl", "referer", "headers", "details", "detailsRoot", "embedBase", "embedCode", "settingsUrl", "settingsRes", "fprintData", "finalFprint", "challengeUrl", "challengeRes", "captchaUrl", "captchaRes", "powNonce", "powToken", "solution", "verifyUrl", "postData", "powDifficulty", "mainUrl", "base", "code", "embed", "detailsUrl", "referer", "headers", "details", "detailsRoot", "embedBase", "embedCode", "settingsUrl", "settingsRes", "fprintData", "finalFprint", "playbackUrl"}, nl = {656, 661, 666, 671, 676, 681, 686, 514}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15"}, v = 2)
    static final class C00021 extends ContinuationImpl {
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
        Object L$20;
        Object L$21;
        Object L$22;
        Object L$23;
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
            return ByseSX.this.getPlayback(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.DoraBash.ByseSX$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.DoraBash.ByseSX", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {571, 574, 581, 586, 598}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "redirectDomains", "parsedUrl", "finalUrl", "refererUrl", "code", "detailsUrl", "$this", "url", "referer", "subtitleCallback", "callback", "redirectDomains", "parsedUrl", "finalUrl", "refererUrl", "code", "detailsUrl", "details", "$this", "url", "referer", "subtitleCallback", "callback", "redirectDomains", "parsedUrl", "finalUrl", "refererUrl", "code", "detailsUrl", "details", "$this", "url", "referer", "subtitleCallback", "callback", "redirectDomains", "parsedUrl", "finalUrl", "refererUrl", "code", "detailsUrl", "details", "playbackRoot", "$this", "url", "referer", "subtitleCallback", "callback", "redirectDomains", "parsedUrl", "finalUrl", "refererUrl", "code", "detailsUrl", "details", "playbackRoot", "streamUrl", "headers"}, nl = {656, 661, 583, 588, 597}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
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
            return ByseSX.getUrl$suspendImpl(ByseSX.this, null, null, null, null, (Continuation) this);
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

    private final byte[] b64UrlDecode(String s) {
        String fixed = StringsKt.replace$default(StringsKt.replace$default(s, '-', '+', false, 4, (Object) null), '_', '/', false, 4, (Object) null);
        int pad = (4 - (fixed.length() % 4)) % 4;
        return MainAPIKt.base64DecodeArray(fixed + StringsKt.repeat("=", pad));
    }

    private final String urlSafeBase64(byte[] bytes) {
        return StringsKt.trimEnd(StringsKt.replace$default(StringsKt.replace$default(MainAPIKt.base64Encode(bytes), "+", "-", false, 4, (Object) null), "/", "_", false, 4, (Object) null), new char[]{'='});
    }

    private final String getBaseUrl(String url) {
        Url it = URLUtilsKt.Url(url);
        return it.getProtocol().getName() + "://" + it.getHost();
    }

    private final String getCodeFromUrl(String url) {
        String path = CodecsKt.decodeURLPart$default(URLUtilsKt.Url(url).getEncodedPath(), 0, 0, (Charset) null, 7, (Object) null);
        return StringsKt.substringAfterLast$default(StringsKt.trimEnd(path, new char[]{'/'}), '/', (String) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:0x0138  */
    /* JADX WARN: Code duplicated, block: B:27:0x01bd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x01be  */
    /* JADX WARN: Code duplicated, block: B:35:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object getDetails(String mainUrl, Continuation<? super DetailsRoot> continuation) {
        C00011 c00011;
        Object obj;
        String str;
        Object obj2;
        Object obj3;
        C00011 c00012;
        String mainUrl2;
        String base;
        String code;
        Object safe;
        DetailsRoot detailsRoot;
        String url;
        Object obj4;
        String url2;
        String mainUrl3;
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
        C00011 c00013 = c00011;
        Object $result = c00013.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Object safe2 = null;
        switch (c00013.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String base2 = getBaseUrl(mainUrl);
                String code2 = getCodeFromUrl(mainUrl);
                String url3 = base2 + "/api/videos/" + code2 + "/details";
                Requests app = MainActivityKt.getApp();
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("Referer", base2 + '/'));
                c00013.L$0 = SpillingKt.nullOutSpilledVariable(mainUrl);
                c00013.L$1 = base2;
                c00013.L$2 = code2;
                c00013.L$3 = SpillingKt.nullOutSpilledVariable(url3);
                c00013.label = 1;
                obj = "Referer";
                str = "/api/videos/";
                obj2 = coroutine_suspended;
                obj3 = Requests.get$default(app, url3, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4092, (Object) null);
                c00012 = c00013;
                if (obj3 == obj2) {
                    return obj2;
                }
                mainUrl2 = mainUrl;
                base = base2;
                code = code2;
                NiceResponse this_$iv = (NiceResponse) obj3;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(DetailsRoot.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                detailsRoot = (DetailsRoot) safe;
                if (detailsRoot == null) {
                    return detailsRoot;
                }
                url = base + str + code + "/embed/details";
                Requests app2 = MainActivityKt.getApp();
                Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to(obj, base + '/'));
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(mainUrl2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(base);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(code);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(url);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(detailsRoot);
                c00012.label = 2;
                obj4 = Requests.get$default(app2, url, mapMapOf2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4092, (Object) null);
                if (obj4 == obj2) {
                    return obj2;
                }
                url2 = url;
                mainUrl3 = mainUrl2;
                $result = obj4;
                NiceResponse this_$iv2 = (NiceResponse) $result;
                try {
                    ResponseParser parser2 = this_$iv2.getParser();
                    Intrinsics.checkNotNull(parser2);
                    safe2 = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(DetailsRoot.class));
                    break;
                } catch (Exception e$iv2) {
                    e$iv2.printStackTrace();
                }
                return (DetailsRoot) safe2;
            case 1:
                String code3 = (String) c00013.L$2;
                String base3 = (String) c00013.L$1;
                String mainUrl4 = (String) c00013.L$0;
                ResultKt.throwOnFailure($result);
                obj2 = coroutine_suspended;
                obj = "Referer";
                str = "/api/videos/";
                code = code3;
                base = base3;
                mainUrl2 = mainUrl4;
                c00012 = c00013;
                obj3 = $result;
                NiceResponse this_$iv3 = (NiceResponse) obj3;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(DetailsRoot.class));
                detailsRoot = (DetailsRoot) safe;
                if (detailsRoot == null) {
                    return detailsRoot;
                }
                url = base + str + code + "/embed/details";
                Requests app3 = MainActivityKt.getApp();
                Map mapMapOf3 = MapsKt.mapOf(TuplesKt.to(obj, base + '/'));
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(mainUrl2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(base);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(code);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(url);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(detailsRoot);
                c00012.label = 2;
                obj4 = Requests.get$default(app3, url, mapMapOf3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4092, (Object) null);
                if (obj4 == obj2) {
                    return obj2;
                }
                url2 = url;
                mainUrl3 = mainUrl2;
                $result = obj4;
                NiceResponse this_$iv4 = (NiceResponse) $result;
                ResponseParser parser4 = this_$iv4.getParser();
                Intrinsics.checkNotNull(parser4);
                safe2 = parser4.parseSafe(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(DetailsRoot.class));
                return (DetailsRoot) safe2;
            case 2:
                url2 = (String) c00013.L$3;
                mainUrl3 = (String) c00013.L$0;
                ResultKt.throwOnFailure($result);
                NiceResponse this_$iv5 = (NiceResponse) $result;
                ResponseParser parser5 = this_$iv5.getParser();
                Intrinsics.checkNotNull(parser5);
                safe2 = parser5.parseSafe(this_$iv5.getText(), Reflection.getOrCreateKotlinClass(DetailsRoot.class));
                return (DetailsRoot) safe2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: fp */
    private final Map<String, Object> m5fp(int x, double y, double z) throws NoSuchAlgorithmException {
        String vId = CollectionsKt.joinToString$default(new IntRange(1, x), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.DoraBash.ByseSX$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return ByseSX.fp$lambda$0(((Integer) obj).intValue());
            }
        }, 30, (Object) null);
        String dId = CollectionsKt.joinToString$default(new IntRange(1, x), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.DoraBash.ByseSX$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return ByseSX.fp$lambda$1(((Integer) obj).intValue());
            }
        }, 30, (Object) null);
        long ctime = System.currentTimeMillis() / 1000;
        double confidence = Math.rint(Random.Default.nextDouble(y, z) * 100.0d) / 100.0d;
        String tData = "{\"viewer_id\":\"" + vId + "\",\"device_id\":\"" + dId + "\",\"confidence\":" + confidence + ",\"iat\":" + ctime + ",\"exp\":" + (600 + ctime) + '}';
        byte[] bytes = tData.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String tBdata = urlSafeBase64(bytes);
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] bytes2 = tBdata.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        String tSig = urlSafeBase64(md.digest(bytes2));
        String token = tBdata + '.' + tSig;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("fingerprint", MapsKt.mapOf(new Pair[]{TuplesKt.to("viewer_id", vId), TuplesKt.to("device_id", dId), TuplesKt.to("confidence", Double.valueOf(confidence)), TuplesKt.to("token", token)})), TuplesKt.to("vId", vId), TuplesKt.to("dId", dId)});
    }

    static final CharSequence fp$lambda$0(int it) {
        String string = Integer.toString(Random.Default.nextInt(0, 256), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt.padStart(string, 2, '0');
    }

    static final CharSequence fp$lambda$1(int it) {
        String string = Integer.toString(Random.Default.nextInt(0, 256), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt.padStart(string, 2, '0');
    }

    /* JADX INFO: renamed from: fh */
    private final String m4fh(double r) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] bytes = String.valueOf(r).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return urlSafeBase64(md.digest(bytes));
    }

    /* JADX INFO: renamed from: wn */
    private final Map<String, Object> m8wn(Map<String, ? extends Object> ch) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, InvalidAlgorithmParameterException {
        String nonce;
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
        kpg.initialize(new ECGenParameterSpec("secp256r1"));
        KeyPair kp = kpg.generateKeyPair();
        PublicKey publicKey = kp.getPublic();
        Intrinsics.checkNotNull(publicKey, "null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
        ECPublicKey pubKey = (ECPublicKey) publicKey;
        ECPoint w = pubKey.getW();
        byte[] xBytes = wn$pad32(w.getAffineX().toByteArray());
        byte[] yBytes = wn$pad32(w.getAffineY().toByteArray());
        String xBase64 = urlSafeBase64(xBytes);
        String yBase64 = urlSafeBase64(yBytes);
        Object obj = ch.get("nonce");
        if (obj == null || (nonce = obj.toString()) == null) {
            nonce = "";
        }
        Signature sig = Signature.getInstance("SHA256withECDSA");
        sig.initSign(kp.getPrivate());
        byte[] bytes = nonce.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        sig.update(bytes);
        byte[] derSignature = sig.sign();
        int offset = (derSignature[1] == -127 ? 3 : 2) + 1;
        int rLen = derSignature[offset];
        int offset2 = offset + 1;
        byte[] rBytes = ArraysKt.copyOfRange(derSignature, offset2, offset2 + rLen);
        int offset3 = offset2 + rLen + 1;
        int sLen = derSignature[offset3];
        int offset4 = offset3 + 1;
        byte[] sBytes = ArraysKt.copyOfRange(derSignature, offset4, offset4 + sLen);
        byte[] rawSignature = ArraysKt.plus(wn$pad32(rBytes), wn$pad32(sBytes));
        String sigBase64 = urlSafeBase64(rawSignature);
        double rVal = Random.Default.nextDouble();
        Map clientData = MapsKt.mapOf(new Pair[]{TuplesKt.to("user_agent", "Mozilla/5.0 (Linux; Android 10; TX6s) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Mobile Safari/537.36"), TuplesKt.to("architecture", "arm"), TuplesKt.to("bitness", "32"), TuplesKt.to("platform", "Android"), TuplesKt.to("platform_version", "10.0.0"), TuplesKt.to("model", "TX6s"), TuplesKt.to("ua_full_version", "137.0.7337.0"), TuplesKt.to("brand_full_versions", CollectionsKt.listOf(MapsKt.mapOf(new Pair[]{TuplesKt.to("brand", "Chromium"), TuplesKt.to("version", "137.0.7337.0")}))), TuplesKt.to("pixel_ratio", 1), TuplesKt.to("screen_width", 1280), TuplesKt.to("screen_height", 720), TuplesKt.to("color_depth", 24), TuplesKt.to("languages", CollectionsKt.listOf("en-US")), TuplesKt.to("timezone", "America/New_York"), TuplesKt.to("hardware_concurrency", 4), TuplesKt.to("device_memory", 2), TuplesKt.to("touch_points", 1), TuplesKt.to("webgl_vendor", "Google Inc. (ARM)"), TuplesKt.to("webgl_renderer", "ANGLE (ARM, Mali-G31 MP2, OpenGL ES 3.2)"), TuplesKt.to("canvas_hash", m4fh(rVal)), TuplesKt.to("audio_hash", m4fh(rVal + 1.0d)), TuplesKt.to("webgl_params_hash", m4fh(2.0d + rVal)), TuplesKt.to("fonts_hash", m4fh(3.0d + rVal)), TuplesKt.to("codecs_hash", m4fh(4.0d + rVal)), TuplesKt.to("media_devices", "ai1ao1vi4"), TuplesKt.to("pointer_type", "coarse"), TuplesKt.to("extra", MapsKt.mapOf(new Pair[]{TuplesKt.to("vendor", "Google Inc."), TuplesKt.to("appVersion", "5.0 (Linux; Android 10; TX6s) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Mobile Safari/537.36")}))});
        Pair[] pairArr = new Pair[9];
        pairArr[0] = TuplesKt.to("viewer_id", "");
        pairArr[1] = TuplesKt.to("device_id", "");
        Object obj2 = ch.get("challenge_id");
        pairArr[2] = TuplesKt.to("challenge_id", obj2 != null ? obj2 : "");
        pairArr[3] = TuplesKt.to("nonce", nonce);
        pairArr[4] = TuplesKt.to("signature", sigBase64);
        pairArr[5] = TuplesKt.to("public_key", MapsKt.mapOf(new Pair[]{TuplesKt.to("crv", "P-256"), TuplesKt.to("ext", true), TuplesKt.to("key_ops", CollectionsKt.listOf("verify")), TuplesKt.to("kty", "EC"), TuplesKt.to("x", xBase64), TuplesKt.to("y", yBase64)}));
        pairArr[6] = TuplesKt.to("client", clientData);
        pairArr[7] = TuplesKt.to("storage", MapsKt.emptyMap());
        pairArr[8] = TuplesKt.to("attributes", MapsKt.mapOf(TuplesKt.to("entropy", "high")));
        return MapsKt.mapOf(pairArr);
    }

    private static final byte[] wn$pad32(byte[] b) {
        if (b.length == 33 && b[0] == 0) {
            return ArraysKt.copyOfRange(b, 1, 33);
        }
        return b.length < 32 ? ArraysKt.plus(new byte[32 - b.length], b) : b;
    }

    /* JADX INFO: renamed from: re */
    private final long m7re(long t, int e) {
        long t32 = t & 4294967295L;
        return 4294967295L & ((t32 << e) | (t32 >>> (32 - e)));
    }

    /* JADX INFO: renamed from: ye */
    private final void m10ye(long[] t) {
        t[0] = (t[0] + t[1]) & 4294967295L;
        t[3] = m7re(t[3] ^ t[0], 16);
        t[2] = (t[2] + t[3]) & 4294967295L;
        t[1] = m7re(t[1] ^ t[2], 12);
        t[0] = (t[0] + t[1]) & 4294967295L;
        t[3] = m7re(t[3] ^ t[0], 8);
        t[2] = (t[2] + t[3]) & 4294967295L;
        t[1] = m7re(t[1] ^ t[2], 7);
    }

    /* JADX INFO: renamed from: gr */
    private final long[] m6gr(byte[] bytes) {
        int i;
        byte[] bArr = bytes;
        long m = 4294967295L;
        long[] e = {1779033703, 3144134277L, 1013904242, 2773480762L};
        int length = bArr.length;
        int i2 = 0;
        while (i2 < length) {
            byte b = bArr[i2];
            long i3 = ((long) b) & 255;
            e[0] = (e[0] + i3) & m;
            e[0] = m7re(e[0], 7);
            m10ye(e);
            i2++;
            bArr = bytes;
            m = m;
        }
        long m2 = m;
        int i4 = 0;
        while (true) {
            if (i4 >= 8) {
                break;
            }
            m10ye(e);
            i4++;
        }
        long[] r = new long[512];
        for (int i5 = 0; i5 < 512; i5++) {
            m10ye(e);
            r[i5] = (e[0] ^ e[2]) & m2;
        }
        for (int i6 = 0; i6 < 2; i6++) {
            int a = 0;
            while (a < 512) {
                int s = a;
                long c = (r[s] + r[(int) (((long) 511) & r[a])]) & m2;
                long c2 = (m7re(c, 13) ^ ((r[(s + 1) & 511] * 2654435761L) & m2)) & m2;
                r[s] = c2;
                e[0] = (e[0] ^ c2) & m2;
                m10ye(e);
                a = s + 1;
            }
        }
        long[] n = new long[8];
        int o = 512 / 8;
        int i7 = 0;
        for (i = 8; i7 < i; i = 8) {
            m10ye(e);
            long s2 = e[0];
            int a2 = i7 * o;
            int c3 = 0;
            while (c3 < o) {
                long d = r[a2 + c3];
                s2 = (m7re((s2 + d) & m2, 5) ^ ((d * 2246822519L) & m2)) & m2;
                c3++;
                r = r;
            }
            n[i7] = (e[2] ^ s2) & m2;
            i7++;
            r = r;
        }
        return n;
    }

    /* JADX INFO: renamed from: wr */
    private final int m9wr(long[] t) {
        int e = 0;
        for (long n : t) {
            if (n == 0) {
                e += 32;
            } else {
                return Integer.numberOfLeadingZeros((int) n) + e;
            }
        }
        return e;
    }

    static /* synthetic */ String er$default(ByseSX byseSX, String str, int i, double d, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: er");
        }
        if ((i2 & 4) != 0) {
            d = 20.0d;
        }
        return byseSX.m3er(str, i, d);
    }

    /* JADX INFO: renamed from: er */
    private final String m3er(String tStr, int e, double rLimit) {
        if (e <= 0) {
            return "0";
        }
        long start = System.currentTimeMillis();
        int s = 0;
        String prefix = tStr + ':';
        do {
            for (int i = 0; i < 1024; i++) {
                byte[] bytes = (prefix + s).getBytes(Charsets.US_ASCII);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                long[] d = m6gr(bytes);
                if (m9wr(d) < e) {
                    s++;
                } else {
                    return String.valueOf(s);
                }
            }
        } while ((System.currentTimeMillis() - start) / 1000.0d <= rLimit);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:104:0x08f6  */
    /* JADX WARN: Code duplicated, block: B:106:0x0901  */
    /* JADX WARN: Code duplicated, block: B:109:0x0911  */
    /* JADX WARN: Code duplicated, block: B:112:0x0922  */
    /* JADX WARN: Code duplicated, block: B:115:0x0933  */
    /* JADX WARN: Code duplicated, block: B:117:0x0964  */
    /* JADX WARN: Code duplicated, block: B:118:0x097e  */
    /* JADX WARN: Code duplicated, block: B:121:0x0a3a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:122:0x0a3b  */
    /* JADX WARN: Code duplicated, block: B:130:0x0a6b  */
    /* JADX WARN: Code duplicated, block: B:132:0x0a73  */
    /* JADX WARN: Code duplicated, block: B:136:0x0a7c  */
    /* JADX WARN: Code duplicated, block: B:139:0x0a88  */
    /* JADX WARN: Code duplicated, block: B:140:0x0a8b  */
    /* JADX WARN: Code duplicated, block: B:142:0x0a8f  */
    /* JADX WARN: Code duplicated, block: B:143:0x0a95  */
    /* JADX WARN: Code duplicated, block: B:146:0x0a9e  */
    /* JADX WARN: Code duplicated, block: B:152:0x0ac9  */
    /* JADX WARN: Code duplicated, block: B:154:0x0bcd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:155:0x0bce  */
    /* JADX WARN: Code duplicated, block: B:172:0x0c26  */
    /* JADX WARN: Code duplicated, block: B:178:0x0c5a  */
    /* JADX WARN: Code duplicated, block: B:179:0x0c62  */
    /* JADX WARN: Code duplicated, block: B:181:0x0c7e  */
    /* JADX WARN: Code duplicated, block: B:184:0x0d5c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:185:0x0d5d  */
    /* JADX WARN: Code duplicated, block: B:31:0x048f  */
    /* JADX WARN: Code duplicated, block: B:33:0x051a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x051b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0561  */
    /* JADX WARN: Code duplicated, block: B:52:0x0571 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x0572  */
    /* JADX WARN: Code duplicated, block: B:55:0x057f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0588  */
    /* JADX WARN: Code duplicated, block: B:61:0x058b  */
    /* JADX WARN: Code duplicated, block: B:62:0x05cc  */
    /* JADX WARN: Code duplicated, block: B:65:0x0665 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x0666  */
    /* JADX WARN: Code duplicated, block: B:74:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:75:0x0704  */
    /* JADX WARN: Code duplicated, block: B:77:0x0707  */
    /* JADX WARN: Code duplicated, block: B:79:0x07bf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x07c0  */
    /* JADX WARN: Code duplicated, block: B:88:0x07f7  */
    /* JADX WARN: Code duplicated, block: B:90:0x08b2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:91:0x08b3  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r34v14 */
    /* JADX WARN: Type inference failed for: r34v15 */
    /* JADX WARN: Type inference failed for: r34v17 */
    public final Object getPlayback(String str, Continuation<? super PlaybackRoot> continuation) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, InvalidAlgorithmParameterException {
        C00021 c00021;
        Number number;
        String str2;
        Object obj;
        String str3;
        String str4;
        boolean z;
        String str5;
        Map map;
        Object obj2;
        C00021 c00022;
        String str6;
        Object obj3;
        String str7;
        String str8;
        Object safe;
        DetailsRoot detailsRoot;
        String str9;
        String str10;
        char c;
        DetailsRoot detailsRoot2;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        Object obj4;
        String str18;
        Map map2;
        String str19;
        String str20;
        boolean z2;
        DetailsRoot detailsRoot3;
        String str21;
        String str22;
        String embed_frame_url;
        boolean z3;
        String str23;
        String str24;
        String str25;
        String str26;
        Object obj5;
        C00021 c00023;
        DetailsRoot detailsRoot4;
        String str27;
        String str28;
        DetailsRoot detailsRoot5;
        String str29;
        String str30;
        Object obj6;
        String str31;
        String str32;
        String str33;
        String str34;
        boolean z4;
        Map map3;
        String str35;
        Object safe2;
        boolean z5;
        Object safe3;
        Map map4;
        Object obj7;
        String str36;
        Map<String, Object> mapM5fp;
        Map mapMapOf;
        boolean zAreEqual;
        Object obj8;
        String str37;
        Map map5;
        String str38;
        String str39;
        String str40;
        String str41;
        Map<String, Object> map6;
        Map map7;
        String str42;
        String str43;
        String str44;
        String str45;
        String str46;
        Object obj9;
        Object objPost$default;
        C00021 c00024;
        Map map8;
        Object obj10;
        Map map9;
        String str47;
        String str48;
        String str49;
        String str50;
        boolean z6;
        Object safe4;
        Map<String, ? extends Object> map10;
        String str51;
        Object obj11;
        Map mapMapOf2;
        Map map11;
        String str52;
        Object objPost$default2;
        String str53;
        Map map12;
        String str54;
        Map<String, Object> map13;
        DetailsRoot detailsRoot6;
        DetailsRoot detailsRoot7;
        String str55;
        String str56;
        Map map14;
        String str57;
        Map<String, ? extends Object> map15;
        boolean z7;
        String str58;
        Object obj12;
        String str59;
        Map map16;
        Object objPost$default3;
        Map<String, ? extends Object> map17;
        String str60;
        String str61;
        String str62;
        String str63;
        Map map18;
        String str64;
        boolean z8;
        Map<String, ? extends Object> map19;
        Object safe5;
        Map map20;
        Object obj13;
        Object obj14;
        Object obj15;
        Object objBoxDouble;
        ?? r34;
        Object safe6;
        Map map21;
        String str65;
        Map map22;
        Object obj16;
        String str66;
        Object obj17;
        Number number2;
        int iIntValue;
        Object obj18;
        Object obj19;
        Object obj20;
        String str67;
        Object obj21;
        String str68;
        String strEr$default;
        Map mapMapOf3;
        String str69;
        Map map23;
        String str70;
        String str71;
        Object objPost$default4;
        Map map24;
        String str72;
        String str73;
        Map map25;
        Object obj22;
        Map map26;
        String str74;
        String str75;
        Map<String, Object> map27;
        DetailsRoot detailsRoot8;
        DetailsRoot detailsRoot9;
        String str76;
        String str77;
        String str78;
        String string;
        String string2;
        Object obj23;
        Object objPost$default5;
        Object obj24;
        String str79;
        String str80;
        Object safe7;
        Map map28;
        Object obj25;
        String string3;
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
        C00021 c00025 = c00021;
        Object obj26 = c00025.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str81 = "";
        switch (c00025.label) {
            case 0:
                number = null;
                ResultKt.throwOnFailure(obj26);
                String baseUrl = getBaseUrl(str);
                String codeFromUrl = getCodeFromUrl(str);
                str2 = baseUrl + "/api/videos/" + codeFromUrl + "/details";
                String str82 = baseUrl + '/';
                Map mapMutableMapOf = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 10; TX6s) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Mobile Safari/537.36"), TuplesKt.to("Referer", str82), TuplesKt.to("Origin", baseUrl)});
                Requests app = MainActivityKt.getApp();
                c00025.L$0 = str;
                c00025.L$1 = baseUrl;
                c00025.L$2 = codeFromUrl;
                c00025.L$3 = "";
                c00025.L$4 = SpillingKt.nullOutSpilledVariable(str2);
                c00025.L$5 = SpillingKt.nullOutSpilledVariable(str82);
                c00025.L$6 = mapMutableMapOf;
                c00025.label = 1;
                obj = "token";
                str3 = str82;
                str4 = "/api/videos/";
                z = true;
                str5 = "";
                map = mapMutableMapOf;
                obj2 = "fingerprint";
                Object obj27 = Requests.get$default(app, str2, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00025, 4092, (Object) null);
                c00022 = c00025;
                if (obj27 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str6 = codeFromUrl;
                obj3 = obj27;
                str7 = baseUrl;
                str8 = str;
                NiceResponse niceResponse = (NiceResponse) obj3;
                try {
                    ResponseParser parser = niceResponse.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(niceResponse.getText(), Reflection.getOrCreateKotlinClass(DetailsRoot.class));
                } catch (Exception e) {
                    e.printStackTrace();
                    safe = number;
                }
                detailsRoot = (DetailsRoot) safe;
                if (detailsRoot == null) {
                    str14 = str7 + str4 + str6 + "/embed/details";
                    Requests app2 = MainActivityKt.getApp();
                    c00022.L$0 = str8;
                    c00022.L$1 = str7;
                    c00022.L$2 = str6;
                    c00022.L$3 = "embed/";
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(str3);
                    c00022.L$6 = map;
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot);
                    c00022.label = 2;
                    C00021 c00026 = c00022;
                    str15 = str6;
                    str16 = str7;
                    str17 = str8;
                    c = 2;
                    obj4 = Requests.get$default(app2, str14, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00026, 4092, (Object) null);
                    c00022 = c00026;
                    if (obj4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Map map29 = map;
                    str18 = "embed/";
                    map2 = map29;
                    str19 = str15;
                    str20 = str16;
                    z4 = z;
                    NiceResponse niceResponse2 = (NiceResponse) obj4;
                    try {
                        ResponseParser parser2 = niceResponse2.getParser();
                        Intrinsics.checkNotNull(parser2);
                        map3 = map2;
                        try {
                            str35 = str17;
                            try {
                                safe2 = parser2.parseSafe(niceResponse2.getText(), Reflection.getOrCreateKotlinClass(DetailsRoot.class));
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                safe2 = number;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str35 = str17;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        map3 = map2;
                        str35 = str17;
                    }
                    detailsRoot2 = (DetailsRoot) safe2;
                    str11 = str18;
                    str10 = str19;
                    str12 = str20;
                    str9 = str35;
                    map = map3;
                    str13 = str14;
                    z2 = z4;
                } else {
                    str9 = str8;
                    str10 = str6;
                    c = 2;
                    detailsRoot2 = detailsRoot;
                    str11 = str5;
                    str12 = str7;
                    str13 = str2;
                }
                if (detailsRoot2 == null) {
                    z2 = z;
                    return number;
                }
                z2 = z;
                detailsRoot3 = detailsRoot2;
                str21 = str12;
                str22 = str10;
                embed_frame_url = detailsRoot3.getEmbed_frame_url();
                if (embed_frame_url != null || embed_frame_url.length() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    str23 = str21;
                    str24 = str22;
                } else {
                    String baseUrl2 = getBaseUrl(detailsRoot3.getEmbed_frame_url());
                    String codeFromUrl2 = getCodeFromUrl(detailsRoot3.getEmbed_frame_url());
                    String str83 = baseUrl2 + '/';
                    map.put("Referer", str83);
                    map.put("Origin", baseUrl2);
                    map.put("X-Embed-Parent", str9);
                    map.put("X-Embed-Origin", "dorabash.in");
                    map.put("X-Embed-Referer", "https://dorabash.in/");
                    str3 = str83;
                    str23 = baseUrl2;
                    str24 = codeFromUrl2;
                }
                str25 = str23 + str4 + str24 + '/' + str11 + "settings";
                Requests app3 = MainActivityKt.getApp();
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(str12);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str10);
                c00022.L$3 = str11;
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str13);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(str3);
                c00022.L$6 = map;
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot3);
                c00022.L$9 = str23;
                c00022.L$10 = str24;
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str25);
                c00022.label = 3;
                C00021 c00027 = c00022;
                str26 = str11;
                obj5 = Requests.get$default(app3, str25, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00027, 4092, (Object) null);
                c00023 = c00027;
                if (obj5 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                detailsRoot4 = detailsRoot2;
                str27 = str13;
                str28 = str3;
                detailsRoot5 = detailsRoot3;
                str29 = str26;
                str30 = str12;
                obj6 = obj5;
                str31 = str25;
                str32 = str10;
                str33 = str24;
                str34 = str23;
                z5 = z2;
                NiceResponse niceResponse3 = (NiceResponse) obj6;
                try {
                    ResponseParser parser3 = niceResponse3.getParser();
                    Intrinsics.checkNotNull(parser3);
                    safe3 = parser3.parseSafe(niceResponse3.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                } catch (Exception e5) {
                    e5.printStackTrace();
                    safe3 = number;
                }
                map4 = (Map) safe3;
                obj7 = obj;
                str36 = str4;
                mapM5fp = m5fp(16, 0.83d, 0.94d);
                Object obj28 = mapM5fp.get(obj2);
                Intrinsics.checkNotNull(obj28);
                mapMapOf = MapsKt.mapOf(TuplesKt.to(obj2, obj28));
                map.put("Cookie", "byse_viewer_id=" + mapM5fp.get("vId") + "; byse_device_id=" + mapM5fp.get("dId"));
                if (map4 != null) {
                    zAreEqual = Intrinsics.areEqual(map4.get("captcha_required"), Boxing.boxBoolean(z5));
                } else {
                    zAreEqual = false;
                }
                if (zAreEqual) {
                    str43 = str34 + "/api/videos/access/challenge";
                    Requests app4 = MainActivityKt.getApp();
                    Map mapEmptyMap = MapsKt.emptyMap();
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                    c00023.L$3 = str29;
                    c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                    c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                    c00023.L$6 = map;
                    c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                    c00023.L$9 = str34;
                    c00023.L$10 = str33;
                    c00023.L$11 = SpillingKt.nullOutSpilledVariable(str31);
                    c00023.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                    c00023.L$13 = SpillingKt.nullOutSpilledVariable(mapM5fp);
                    c00023.L$14 = mapMapOf;
                    c00023.L$15 = SpillingKt.nullOutSpilledVariable(str43);
                    c00023.label = 4;
                    C00021 c00028 = c00023;
                    str44 = str29;
                    str45 = str33;
                    str46 = str34;
                    obj9 = coroutine_suspended;
                    objPost$default = Requests.post$default(app4, str43, map, (String) null, (Map) null, (Map) null, mapEmptyMap, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00028, 65500, (Object) null);
                    c00024 = c00028;
                    if (objPost$default == obj9) {
                        return obj9;
                    }
                    map8 = map4;
                    obj10 = objPost$default;
                    map9 = mapMapOf;
                    str47 = str44;
                    str48 = str45;
                    str49 = str43;
                    str50 = str31;
                    map6 = mapM5fp;
                    z6 = z5;
                    NiceResponse niceResponse4 = (NiceResponse) obj10;
                    try {
                        ResponseParser parser4 = niceResponse4.getParser();
                        Intrinsics.checkNotNull(parser4);
                        safe4 = parser4.parseSafe(niceResponse4.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        safe4 = number;
                    }
                    map10 = (Map) safe4;
                    if (map10 != null) {
                        String str84 = str46 + "/api/videos/access/attest";
                        Requests app5 = MainActivityKt.getApp();
                        Map<String, Object> mapM8wn = m8wn(map10);
                        c00024.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                        c00024.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                        c00024.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                        c00024.L$3 = str47;
                        c00024.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                        c00024.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                        c00024.L$6 = map;
                        c00024.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                        c00024.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                        c00024.L$9 = str46;
                        c00024.L$10 = str48;
                        c00024.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                        c00024.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                        c00024.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                        c00024.L$14 = map9;
                        c00024.L$15 = SpillingKt.nullOutSpilledVariable(str49);
                        c00024.L$16 = SpillingKt.nullOutSpilledVariable(map10);
                        c00024.L$17 = SpillingKt.nullOutSpilledVariable(str84);
                        c00024.label = 5;
                        C00021 c00029 = c00024;
                        map11 = map9;
                        str52 = str48;
                        objPost$default2 = Requests.post$default(app5, str84, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, mapM8wn, (RequestBody) null, false, 0, (TimeUnit) null, 10000L, (Interceptor) null, false, (ResponseParser) null, c00029, 61308, (Object) null);
                        c00024 = c00029;
                        if (objPost$default2 == obj9) {
                            return obj9;
                        }
                        str53 = str52;
                        map12 = map;
                        str54 = str30;
                        map13 = map6;
                        detailsRoot6 = detailsRoot5;
                        detailsRoot7 = detailsRoot4;
                        str55 = str28;
                        str56 = str27;
                        map14 = map8;
                        str57 = str50;
                        map15 = map10;
                        z8 = z6;
                        NiceResponse niceResponse5 = (NiceResponse) objPost$default2;
                        try {
                            ResponseParser parser5 = niceResponse5.getParser();
                            Intrinsics.checkNotNull(parser5);
                            map19 = map15;
                            try {
                                safe5 = parser5.parseSafe(niceResponse5.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                            } catch (Exception e7) {
                                e = e7;
                                e.printStackTrace();
                                safe5 = number;
                            }
                        } catch (Exception e8) {
                            e = e8;
                            map19 = map15;
                        }
                        map20 = (Map) safe5;
                        if (map20 != null) {
                            Pair[] pairArr = new Pair[4];
                            obj11 = obj7;
                            obj13 = map20.get(obj11);
                            if (obj13 == null) {
                                obj13 = "";
                            }
                            pairArr[0] = TuplesKt.to(obj11, obj13);
                            obj14 = map20.get("viewer_id");
                            if (obj14 == null) {
                                obj14 = "";
                            }
                            pairArr[z8 ? 1 : 0] = TuplesKt.to("viewer_id", obj14);
                            obj15 = map20.get("device_id");
                            if (obj15 == null) {
                                obj15 = "";
                            }
                            pairArr[c] = TuplesKt.to("device_id", obj15);
                            objBoxDouble = map20.get("confidence");
                            if (objBoxDouble == null) {
                                objBoxDouble = Boxing.boxDouble(1.0d);
                            }
                            pairArr[3] = TuplesKt.to("confidence", objBoxDouble);
                            mapMapOf2 = MapsKt.mapOf(TuplesKt.to(obj2, MapsKt.mapOf(pairArr)));
                            map10 = map19;
                            map6 = map13;
                            map8 = map14;
                            str50 = str57;
                            str51 = str53;
                            detailsRoot5 = detailsRoot6;
                            detailsRoot4 = detailsRoot7;
                            map = map12;
                            str28 = str55;
                            str27 = str56;
                            str30 = str54;
                            z7 = z8;
                        } else {
                            obj11 = obj7;
                            map10 = map19;
                            map6 = map13;
                            map8 = map14;
                            str50 = str57;
                            str51 = str53;
                            detailsRoot5 = detailsRoot6;
                            detailsRoot4 = detailsRoot7;
                            map = map12;
                            str28 = str55;
                            str27 = str56;
                            str30 = str54;
                            mapMapOf2 = map11;
                            z7 = z8;
                        }
                    } else {
                        Map map30 = map9;
                        str51 = str48;
                        obj11 = obj7;
                        mapMapOf2 = map30;
                        z7 = z6;
                    }
                    String str85 = str36;
                    str58 = str46 + str85 + str51 + '/' + str47 + "captcha";
                    Object obj29 = obj11;
                    Requests app6 = MainActivityKt.getApp();
                    c00024.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                    c00024.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                    c00024.L$3 = str47;
                    c00024.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                    c00024.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                    c00024.L$6 = map;
                    c00024.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                    c00024.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                    c00024.L$9 = str46;
                    c00024.L$10 = str51;
                    c00024.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                    c00024.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                    c00024.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                    c00024.L$14 = mapMapOf2;
                    c00024.L$15 = SpillingKt.nullOutSpilledVariable(str49);
                    c00024.L$16 = SpillingKt.nullOutSpilledVariable(map10);
                    c00024.L$17 = SpillingKt.nullOutSpilledVariable(str58);
                    c00024.label = 6;
                    C00021 c000210 = c00024;
                    obj12 = obj29;
                    str59 = str85;
                    map16 = mapMapOf2;
                    objPost$default3 = Requests.post$default(app6, str58, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, map16, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000210, 65404, (Object) null);
                    c00023 = c000210;
                    if (objPost$default3 == obj9) {
                        return obj9;
                    }
                    map17 = map10;
                    str60 = str51;
                    str61 = str47;
                    str62 = str49;
                    str63 = str58;
                    map18 = map16;
                    str64 = str46;
                    r34 = z7;
                    NiceResponse niceResponse6 = (NiceResponse) objPost$default3;
                    try {
                        ResponseParser parser6 = niceResponse6.getParser();
                        Intrinsics.checkNotNull(parser6);
                        safe6 = parser6.parseSafe(niceResponse6.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                    } catch (Exception e9) {
                        e9.printStackTrace();
                        safe6 = number;
                    }
                    map21 = (Map) safe6;
                    if (map21 != null) {
                        obj16 = map21.get("pow_nonce");
                        if (obj16 != null || (string2 = obj16.toString()) == null) {
                            str66 = "";
                        } else {
                            str66 = string2;
                        }
                        obj17 = map21.get("pow_difficulty");
                        if (obj17 instanceof Number) {
                            number2 = (Number) obj17;
                        } else {
                            number2 = number;
                        }
                        if (number2 != null) {
                            iIntValue = number2.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        obj18 = map21.get("pow_token");
                        if (obj18 != null && (string = obj18.toString()) != null) {
                            str81 = string;
                        }
                        obj19 = obj2;
                        obj20 = obj9;
                        str67 = str81;
                        str65 = str9;
                        map22 = map;
                        obj21 = obj12;
                        str68 = str59;
                        strEr$default = er$default(this, str66, iIntValue, 0.0d, 4, null);
                        if (strEr$default != null) {
                            String str86 = str64 + str68 + str60 + '/' + str61 + "captcha/verify";
                            Pair[] pairArr2 = new Pair[3];
                            pairArr2[0] = TuplesKt.to("pow_token", str67);
                            pairArr2[r34] = TuplesKt.to("solution", strEr$default);
                            Object obj30 = map18.get(obj19);
                            Intrinsics.checkNotNull(obj30);
                            pairArr2[c] = TuplesKt.to(obj19, obj30);
                            mapMapOf3 = MapsKt.mapOf(pairArr2);
                            Requests app7 = MainActivityKt.getApp();
                            c00023.L$0 = SpillingKt.nullOutSpilledVariable(str65);
                            c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                            c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                            c00023.L$3 = str61;
                            c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                            c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                            c00023.L$6 = map22;
                            c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                            c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                            c00023.L$9 = str64;
                            c00023.L$10 = str60;
                            c00023.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                            c00023.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                            c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                            c00023.L$14 = map18;
                            c00023.L$15 = SpillingKt.nullOutSpilledVariable(str62);
                            c00023.L$16 = SpillingKt.nullOutSpilledVariable(map17);
                            c00023.L$17 = SpillingKt.nullOutSpilledVariable(str63);
                            c00023.L$18 = SpillingKt.nullOutSpilledVariable(map21);
                            c00023.L$19 = SpillingKt.nullOutSpilledVariable(str66);
                            c00023.L$20 = SpillingKt.nullOutSpilledVariable(str67);
                            c00023.L$21 = SpillingKt.nullOutSpilledVariable(strEr$default);
                            c00023.L$22 = SpillingKt.nullOutSpilledVariable(str86);
                            c00023.L$23 = SpillingKt.nullOutSpilledVariable(mapMapOf3);
                            c00023.I$0 = iIntValue;
                            c00023.label = 7;
                            C00021 c000211 = c00023;
                            str69 = str60;
                            map23 = map18;
                            str70 = str61;
                            str37 = str68;
                            str71 = str64;
                            objPost$default4 = Requests.post$default(app7, str86, map22, (String) null, (Map) null, (Map) null, (Map) null, (List) null, mapMapOf3, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000211, 65404, (Object) null);
                            c00023 = c000211;
                            obj8 = obj20;
                            if (objPost$default4 == obj8) {
                                return obj8;
                            }
                            map24 = mapMapOf3;
                            str72 = str70;
                            str73 = str69;
                            map25 = map23;
                            obj22 = objPost$default4;
                            map26 = map22;
                            str74 = str30;
                            str75 = str32;
                            map27 = map6;
                            detailsRoot8 = detailsRoot5;
                            detailsRoot9 = detailsRoot4;
                            str76 = str28;
                            str77 = str27;
                            str78 = str65;
                            NiceResponse niceResponse7 = (NiceResponse) obj22;
                            try {
                                ResponseParser parser7 = niceResponse7.getParser();
                                Intrinsics.checkNotNull(parser7);
                                str80 = str78;
                                try {
                                    try {
                                        safe7 = parser7.parseSafe(niceResponse7.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                                    } catch (Exception e10) {
                                        e = e10;
                                        e.printStackTrace();
                                        safe7 = null;
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                }
                            } catch (Exception e12) {
                                e = e12;
                                str80 = str78;
                            }
                            map28 = (Map) safe7;
                            if (map28 != null && (obj25 = map28.get(obj21)) != null && (string3 = obj25.toString()) != null) {
                                map26.put("X-Captcha-Token", string3);
                                Unit unit = Unit.INSTANCE;
                            }
                            str42 = str80;
                            map = map26;
                            str38 = str71;
                            map5 = map25;
                            map6 = map27;
                            str39 = str73;
                            detailsRoot5 = detailsRoot8;
                            detailsRoot4 = detailsRoot9;
                            str28 = str76;
                            str27 = str77;
                            str41 = str72;
                            str32 = str75;
                            str30 = str74;
                            map7 = map8;
                            str40 = str50;
                        } else {
                            str37 = str68;
                            obj8 = obj20;
                        }
                    } else {
                        str65 = str9;
                        map22 = map;
                        obj8 = obj9;
                        str37 = str59;
                    }
                    str41 = str61;
                    str39 = str60;
                    str42 = str65;
                    str38 = str64;
                    map5 = map18;
                    map = map22;
                    map7 = map8;
                    str40 = str50;
                } else {
                    String str87 = str29;
                    obj8 = coroutine_suspended;
                    str37 = str36;
                    map5 = mapMapOf;
                    str38 = str34;
                    str39 = str33;
                    str40 = str31;
                    str41 = str87;
                    map6 = mapM5fp;
                    map7 = map4;
                    str42 = str9;
                }
                String str88 = str38 + str37 + str39 + '/' + str41 + "playback";
                Requests app8 = MainActivityKt.getApp();
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(str42);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(str41);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(map);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(str39);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(str40);
                c00023.L$12 = SpillingKt.nullOutSpilledVariable(map7);
                c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                c00023.L$14 = SpillingKt.nullOutSpilledVariable(map5);
                c00023.L$15 = SpillingKt.nullOutSpilledVariable(str88);
                c00023.L$16 = null;
                c00023.L$17 = null;
                c00023.L$18 = null;
                c00023.L$19 = null;
                c00023.L$20 = null;
                c00023.L$21 = null;
                c00023.L$22 = null;
                c00023.L$23 = null;
                c00023.label = 8;
                obj23 = obj8;
                objPost$default5 = Requests.post$default(app8, str88, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, map5, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 65404, (Object) null);
                if (objPost$default5 == obj23) {
                    return obj23;
                }
                obj24 = objPost$default5;
                str79 = str42;
                NiceResponse niceResponse8 = (NiceResponse) obj24;
                try {
                    ResponseParser parser8 = niceResponse8.getParser();
                    Intrinsics.checkNotNull(parser8);
                    try {
                        return parser8.parseSafe(niceResponse8.getText(), Reflection.getOrCreateKotlinClass(PlaybackRoot.class));
                    } catch (Exception e13) {
                        e = e13;
                        e.printStackTrace();
                        return null;
                    }
                } catch (Exception e14) {
                    e = e14;
                }
                break;
                break;
                break;
            case 1:
                number = null;
                Map map31 = (Map) c00025.L$6;
                String str89 = (String) c00025.L$5;
                String str90 = (String) c00025.L$4;
                String str91 = (String) c00025.L$3;
                String str92 = (String) c00025.L$2;
                String str93 = (String) c00025.L$1;
                String str94 = (String) c00025.L$0;
                ResultKt.throwOnFailure(obj26);
                str3 = str89;
                obj = "token";
                str5 = str91;
                str8 = str94;
                z = true;
                str2 = str90;
                obj2 = "fingerprint";
                c00022 = c00025;
                str4 = "/api/videos/";
                str7 = str93;
                str6 = str92;
                map = map31;
                obj3 = obj26;
                NiceResponse niceResponse9 = (NiceResponse) obj3;
                ResponseParser parser9 = niceResponse9.getParser();
                Intrinsics.checkNotNull(parser9);
                safe = parser9.parseSafe(niceResponse9.getText(), Reflection.getOrCreateKotlinClass(DetailsRoot.class));
                detailsRoot = (DetailsRoot) safe;
                if (detailsRoot == null) {
                    str14 = str7 + str4 + str6 + "/embed/details";
                    Requests app9 = MainActivityKt.getApp();
                    c00022.L$0 = str8;
                    c00022.L$1 = str7;
                    c00022.L$2 = str6;
                    c00022.L$3 = "embed/";
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(str3);
                    c00022.L$6 = map;
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot);
                    c00022.label = 2;
                    C00021 c000212 = c00022;
                    str15 = str6;
                    str16 = str7;
                    str17 = str8;
                    c = 2;
                    obj4 = Requests.get$default(app9, str14, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000212, 4092, (Object) null);
                    c00022 = c000212;
                    if (obj4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Map map210 = map;
                    str18 = "embed/";
                    map2 = map210;
                    str19 = str15;
                    str20 = str16;
                    z4 = z;
                    NiceResponse niceResponse10 = (NiceResponse) obj4;
                    ResponseParser parser10 = niceResponse10.getParser();
                    Intrinsics.checkNotNull(parser10);
                    map3 = map2;
                    str35 = str17;
                    safe2 = parser10.parseSafe(niceResponse10.getText(), Reflection.getOrCreateKotlinClass(DetailsRoot.class));
                    detailsRoot2 = (DetailsRoot) safe2;
                    str11 = str18;
                    str10 = str19;
                    str12 = str20;
                    str9 = str35;
                    map = map3;
                    str13 = str14;
                    z2 = z4;
                } else {
                    str9 = str8;
                    str10 = str6;
                    c = 2;
                    detailsRoot2 = detailsRoot;
                    str11 = str5;
                    str12 = str7;
                    str13 = str2;
                }
                if (detailsRoot2 == null) {
                    z2 = z;
                    return number;
                }
                z2 = z;
                detailsRoot3 = detailsRoot2;
                str21 = str12;
                str22 = str10;
                embed_frame_url = detailsRoot3.getEmbed_frame_url();
                if (embed_frame_url != null) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (z3) {
                    String baseUrl3 = getBaseUrl(detailsRoot3.getEmbed_frame_url());
                    String codeFromUrl3 = getCodeFromUrl(detailsRoot3.getEmbed_frame_url());
                    String str810 = baseUrl3 + '/';
                    map.put("Referer", str810);
                    map.put("Origin", baseUrl3);
                    map.put("X-Embed-Parent", str9);
                    map.put("X-Embed-Origin", "dorabash.in");
                    map.put("X-Embed-Referer", "https://dorabash.in/");
                    str3 = str810;
                    str23 = baseUrl3;
                    str24 = codeFromUrl3;
                } else {
                    str23 = str21;
                    str24 = str22;
                }
                str25 = str23 + str4 + str24 + '/' + str11 + "settings";
                Requests app10 = MainActivityKt.getApp();
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(str12);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str10);
                c00022.L$3 = str11;
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str13);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(str3);
                c00022.L$6 = map;
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot3);
                c00022.L$9 = str23;
                c00022.L$10 = str24;
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str25);
                c00022.label = 3;
                C00021 c000213 = c00022;
                str26 = str11;
                obj5 = Requests.get$default(app10, str25, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000213, 4092, (Object) null);
                c00023 = c000213;
                if (obj5 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                detailsRoot4 = detailsRoot2;
                str27 = str13;
                str28 = str3;
                detailsRoot5 = detailsRoot3;
                str29 = str26;
                str30 = str12;
                obj6 = obj5;
                str31 = str25;
                str32 = str10;
                str33 = str24;
                str34 = str23;
                z5 = z2;
                NiceResponse niceResponse11 = (NiceResponse) obj6;
                ResponseParser parser11 = niceResponse11.getParser();
                Intrinsics.checkNotNull(parser11);
                safe3 = parser11.parseSafe(niceResponse11.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                map4 = (Map) safe3;
                obj7 = obj;
                str36 = str4;
                mapM5fp = m5fp(16, 0.83d, 0.94d);
                Object obj210 = mapM5fp.get(obj2);
                Intrinsics.checkNotNull(obj210);
                mapMapOf = MapsKt.mapOf(TuplesKt.to(obj2, obj210));
                map.put("Cookie", "byse_viewer_id=" + mapM5fp.get("vId") + "; byse_device_id=" + mapM5fp.get("dId"));
                if (map4 != null) {
                    zAreEqual = Intrinsics.areEqual(map4.get("captcha_required"), Boxing.boxBoolean(z5));
                } else {
                    zAreEqual = false;
                }
                if (zAreEqual) {
                    str43 = str34 + "/api/videos/access/challenge";
                    Requests app11 = MainActivityKt.getApp();
                    Map mapEmptyMap2 = MapsKt.emptyMap();
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                    c00023.L$3 = str29;
                    c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                    c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                    c00023.L$6 = map;
                    c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                    c00023.L$9 = str34;
                    c00023.L$10 = str33;
                    c00023.L$11 = SpillingKt.nullOutSpilledVariable(str31);
                    c00023.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                    c00023.L$13 = SpillingKt.nullOutSpilledVariable(mapM5fp);
                    c00023.L$14 = mapMapOf;
                    c00023.L$15 = SpillingKt.nullOutSpilledVariable(str43);
                    c00023.label = 4;
                    C00021 c000214 = c00023;
                    str44 = str29;
                    str45 = str33;
                    str46 = str34;
                    obj9 = coroutine_suspended;
                    objPost$default = Requests.post$default(app11, str43, map, (String) null, (Map) null, (Map) null, mapEmptyMap2, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000214, 65500, (Object) null);
                    c00024 = c000214;
                    if (objPost$default == obj9) {
                        return obj9;
                    }
                    map8 = map4;
                    obj10 = objPost$default;
                    map9 = mapMapOf;
                    str47 = str44;
                    str48 = str45;
                    str49 = str43;
                    str50 = str31;
                    map6 = mapM5fp;
                    z6 = z5;
                    NiceResponse niceResponse12 = (NiceResponse) obj10;
                    ResponseParser parser12 = niceResponse12.getParser();
                    Intrinsics.checkNotNull(parser12);
                    safe4 = parser12.parseSafe(niceResponse12.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                    map10 = (Map) safe4;
                    if (map10 != null) {
                        String str811 = str46 + "/api/videos/access/attest";
                        Requests app12 = MainActivityKt.getApp();
                        Map<String, Object> mapM8wn2 = m8wn(map10);
                        c00024.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                        c00024.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                        c00024.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                        c00024.L$3 = str47;
                        c00024.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                        c00024.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                        c00024.L$6 = map;
                        c00024.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                        c00024.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                        c00024.L$9 = str46;
                        c00024.L$10 = str48;
                        c00024.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                        c00024.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                        c00024.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                        c00024.L$14 = map9;
                        c00024.L$15 = SpillingKt.nullOutSpilledVariable(str49);
                        c00024.L$16 = SpillingKt.nullOutSpilledVariable(map10);
                        c00024.L$17 = SpillingKt.nullOutSpilledVariable(str811);
                        c00024.label = 5;
                        C00021 c000215 = c00024;
                        map11 = map9;
                        str52 = str48;
                        objPost$default2 = Requests.post$default(app12, str811, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, mapM8wn2, (RequestBody) null, false, 0, (TimeUnit) null, 10000L, (Interceptor) null, false, (ResponseParser) null, c000215, 61308, (Object) null);
                        c00024 = c000215;
                        if (objPost$default2 == obj9) {
                            return obj9;
                        }
                        str53 = str52;
                        map12 = map;
                        str54 = str30;
                        map13 = map6;
                        detailsRoot6 = detailsRoot5;
                        detailsRoot7 = detailsRoot4;
                        str55 = str28;
                        str56 = str27;
                        map14 = map8;
                        str57 = str50;
                        map15 = map10;
                        z8 = z6;
                        NiceResponse niceResponse13 = (NiceResponse) objPost$default2;
                        ResponseParser parser13 = niceResponse13.getParser();
                        Intrinsics.checkNotNull(parser13);
                        map19 = map15;
                        safe5 = parser13.parseSafe(niceResponse13.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                        map20 = (Map) safe5;
                        if (map20 != null) {
                            Pair[] pairArr3 = new Pair[4];
                            obj11 = obj7;
                            obj13 = map20.get(obj11);
                            if (obj13 == null) {
                                obj13 = "";
                            }
                            pairArr3[0] = TuplesKt.to(obj11, obj13);
                            obj14 = map20.get("viewer_id");
                            if (obj14 == null) {
                                obj14 = "";
                            }
                            pairArr3[z8 ? 1 : 0] = TuplesKt.to("viewer_id", obj14);
                            obj15 = map20.get("device_id");
                            if (obj15 == null) {
                                obj15 = "";
                            }
                            pairArr3[c] = TuplesKt.to("device_id", obj15);
                            objBoxDouble = map20.get("confidence");
                            if (objBoxDouble == null) {
                                objBoxDouble = Boxing.boxDouble(1.0d);
                            }
                            pairArr3[3] = TuplesKt.to("confidence", objBoxDouble);
                            mapMapOf2 = MapsKt.mapOf(TuplesKt.to(obj2, MapsKt.mapOf(pairArr3)));
                            map10 = map19;
                            map6 = map13;
                            map8 = map14;
                            str50 = str57;
                            str51 = str53;
                            detailsRoot5 = detailsRoot6;
                            detailsRoot4 = detailsRoot7;
                            map = map12;
                            str28 = str55;
                            str27 = str56;
                            str30 = str54;
                            z7 = z8;
                        } else {
                            obj11 = obj7;
                            map10 = map19;
                            map6 = map13;
                            map8 = map14;
                            str50 = str57;
                            str51 = str53;
                            detailsRoot5 = detailsRoot6;
                            detailsRoot4 = detailsRoot7;
                            map = map12;
                            str28 = str55;
                            str27 = str56;
                            str30 = str54;
                            mapMapOf2 = map11;
                            z7 = z8;
                        }
                    } else {
                        Map map32 = map9;
                        str51 = str48;
                        obj11 = obj7;
                        mapMapOf2 = map32;
                        z7 = z6;
                    }
                    String str812 = str36;
                    str58 = str46 + str812 + str51 + '/' + str47 + "captcha";
                    Object obj211 = obj11;
                    Requests app13 = MainActivityKt.getApp();
                    c00024.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                    c00024.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                    c00024.L$3 = str47;
                    c00024.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                    c00024.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                    c00024.L$6 = map;
                    c00024.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                    c00024.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                    c00024.L$9 = str46;
                    c00024.L$10 = str51;
                    c00024.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                    c00024.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                    c00024.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                    c00024.L$14 = mapMapOf2;
                    c00024.L$15 = SpillingKt.nullOutSpilledVariable(str49);
                    c00024.L$16 = SpillingKt.nullOutSpilledVariable(map10);
                    c00024.L$17 = SpillingKt.nullOutSpilledVariable(str58);
                    c00024.label = 6;
                    C00021 c000216 = c00024;
                    obj12 = obj211;
                    str59 = str812;
                    map16 = mapMapOf2;
                    objPost$default3 = Requests.post$default(app13, str58, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, map16, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000216, 65404, (Object) null);
                    c00023 = c000216;
                    if (objPost$default3 == obj9) {
                        return obj9;
                    }
                    map17 = map10;
                    str60 = str51;
                    str61 = str47;
                    str62 = str49;
                    str63 = str58;
                    map18 = map16;
                    str64 = str46;
                    r34 = z7;
                    NiceResponse niceResponse14 = (NiceResponse) objPost$default3;
                    ResponseParser parser14 = niceResponse14.getParser();
                    Intrinsics.checkNotNull(parser14);
                    safe6 = parser14.parseSafe(niceResponse14.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                    map21 = (Map) safe6;
                    if (map21 != null) {
                        obj16 = map21.get("pow_nonce");
                        if (obj16 != null) {
                            str66 = "";
                        } else {
                            str66 = "";
                        }
                        obj17 = map21.get("pow_difficulty");
                        if (obj17 instanceof Number) {
                            number2 = (Number) obj17;
                        } else {
                            number2 = number;
                        }
                        if (number2 != null) {
                            iIntValue = number2.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        obj18 = map21.get("pow_token");
                        if (obj18 != null) {
                            str81 = string;
                        }
                        obj19 = obj2;
                        obj20 = obj9;
                        str67 = str81;
                        str65 = str9;
                        map22 = map;
                        obj21 = obj12;
                        str68 = str59;
                        strEr$default = er$default(this, str66, iIntValue, 0.0d, 4, null);
                        if (strEr$default != null) {
                            String str813 = str64 + str68 + str60 + '/' + str61 + "captcha/verify";
                            Pair[] pairArr4 = new Pair[3];
                            pairArr4[0] = TuplesKt.to("pow_token", str67);
                            pairArr4[r34] = TuplesKt.to("solution", strEr$default);
                            Object obj31 = map18.get(obj19);
                            Intrinsics.checkNotNull(obj31);
                            pairArr4[c] = TuplesKt.to(obj19, obj31);
                            mapMapOf3 = MapsKt.mapOf(pairArr4);
                            Requests app14 = MainActivityKt.getApp();
                            c00023.L$0 = SpillingKt.nullOutSpilledVariable(str65);
                            c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                            c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                            c00023.L$3 = str61;
                            c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                            c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                            c00023.L$6 = map22;
                            c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                            c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                            c00023.L$9 = str64;
                            c00023.L$10 = str60;
                            c00023.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                            c00023.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                            c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                            c00023.L$14 = map18;
                            c00023.L$15 = SpillingKt.nullOutSpilledVariable(str62);
                            c00023.L$16 = SpillingKt.nullOutSpilledVariable(map17);
                            c00023.L$17 = SpillingKt.nullOutSpilledVariable(str63);
                            c00023.L$18 = SpillingKt.nullOutSpilledVariable(map21);
                            c00023.L$19 = SpillingKt.nullOutSpilledVariable(str66);
                            c00023.L$20 = SpillingKt.nullOutSpilledVariable(str67);
                            c00023.L$21 = SpillingKt.nullOutSpilledVariable(strEr$default);
                            c00023.L$22 = SpillingKt.nullOutSpilledVariable(str813);
                            c00023.L$23 = SpillingKt.nullOutSpilledVariable(mapMapOf3);
                            c00023.I$0 = iIntValue;
                            c00023.label = 7;
                            C00021 c000217 = c00023;
                            str69 = str60;
                            map23 = map18;
                            str70 = str61;
                            str37 = str68;
                            str71 = str64;
                            objPost$default4 = Requests.post$default(app14, str813, map22, (String) null, (Map) null, (Map) null, (Map) null, (List) null, mapMapOf3, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000217, 65404, (Object) null);
                            c00023 = c000217;
                            obj8 = obj20;
                            if (objPost$default4 == obj8) {
                                return obj8;
                            }
                            map24 = mapMapOf3;
                            str72 = str70;
                            str73 = str69;
                            map25 = map23;
                            obj22 = objPost$default4;
                            map26 = map22;
                            str74 = str30;
                            str75 = str32;
                            map27 = map6;
                            detailsRoot8 = detailsRoot5;
                            detailsRoot9 = detailsRoot4;
                            str76 = str28;
                            str77 = str27;
                            str78 = str65;
                            NiceResponse niceResponse15 = (NiceResponse) obj22;
                            ResponseParser parser15 = niceResponse15.getParser();
                            Intrinsics.checkNotNull(parser15);
                            str80 = str78;
                            safe7 = parser15.parseSafe(niceResponse15.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                            map28 = (Map) safe7;
                            if (map28 != null) {
                                map26.put("X-Captcha-Token", string3);
                                Unit unit2 = Unit.INSTANCE;
                            }
                            str42 = str80;
                            map = map26;
                            str38 = str71;
                            map5 = map25;
                            map6 = map27;
                            str39 = str73;
                            detailsRoot5 = detailsRoot8;
                            detailsRoot4 = detailsRoot9;
                            str28 = str76;
                            str27 = str77;
                            str41 = str72;
                            str32 = str75;
                            str30 = str74;
                            map7 = map8;
                            str40 = str50;
                        } else {
                            str37 = str68;
                            obj8 = obj20;
                        }
                    } else {
                        str65 = str9;
                        map22 = map;
                        obj8 = obj9;
                        str37 = str59;
                    }
                    str41 = str61;
                    str39 = str60;
                    str42 = str65;
                    str38 = str64;
                    map5 = map18;
                    map = map22;
                    map7 = map8;
                    str40 = str50;
                } else {
                    String str814 = str29;
                    obj8 = coroutine_suspended;
                    str37 = str36;
                    map5 = mapMapOf;
                    str38 = str34;
                    str39 = str33;
                    str40 = str31;
                    str41 = str814;
                    map6 = mapM5fp;
                    map7 = map4;
                    str42 = str9;
                }
                String str815 = str38 + str37 + str39 + '/' + str41 + "playback";
                Requests app15 = MainActivityKt.getApp();
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(str42);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(str41);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(map);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(str39);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(str40);
                c00023.L$12 = SpillingKt.nullOutSpilledVariable(map7);
                c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                c00023.L$14 = SpillingKt.nullOutSpilledVariable(map5);
                c00023.L$15 = SpillingKt.nullOutSpilledVariable(str815);
                c00023.L$16 = null;
                c00023.L$17 = null;
                c00023.L$18 = null;
                c00023.L$19 = null;
                c00023.L$20 = null;
                c00023.L$21 = null;
                c00023.L$22 = null;
                c00023.L$23 = null;
                c00023.label = 8;
                obj23 = obj8;
                objPost$default5 = Requests.post$default(app15, str815, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, map5, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 65404, (Object) null);
                if (objPost$default5 == obj23) {
                    return obj23;
                }
                obj24 = objPost$default5;
                str79 = str42;
                NiceResponse niceResponse16 = (NiceResponse) obj24;
                ResponseParser parser16 = niceResponse16.getParser();
                Intrinsics.checkNotNull(parser16);
                return parser16.parseSafe(niceResponse16.getText(), Reflection.getOrCreateKotlinClass(PlaybackRoot.class));
            case 2:
                number = null;
                map2 = (Map) c00025.L$6;
                String str95 = (String) c00025.L$5;
                str14 = (String) c00025.L$4;
                str18 = (String) c00025.L$3;
                str19 = (String) c00025.L$2;
                str20 = (String) c00025.L$1;
                String str96 = (String) c00025.L$0;
                ResultKt.throwOnFailure(obj26);
                str17 = str96;
                str3 = str95;
                obj = "token";
                obj2 = "fingerprint";
                obj4 = obj26;
                z4 = true;
                c = 2;
                c00022 = c00025;
                str4 = "/api/videos/";
                NiceResponse niceResponse17 = (NiceResponse) obj4;
                ResponseParser parser17 = niceResponse17.getParser();
                Intrinsics.checkNotNull(parser17);
                map3 = map2;
                str35 = str17;
                safe2 = parser17.parseSafe(niceResponse17.getText(), Reflection.getOrCreateKotlinClass(DetailsRoot.class));
                detailsRoot2 = (DetailsRoot) safe2;
                str11 = str18;
                str10 = str19;
                str12 = str20;
                str9 = str35;
                map = map3;
                str13 = str14;
                z2 = z4;
                if (detailsRoot2 == null) {
                    z2 = z;
                    return number;
                }
                z2 = z;
                detailsRoot3 = detailsRoot2;
                str21 = str12;
                str22 = str10;
                embed_frame_url = detailsRoot3.getEmbed_frame_url();
                if (embed_frame_url != null) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (z3) {
                    String baseUrl4 = getBaseUrl(detailsRoot3.getEmbed_frame_url());
                    String codeFromUrl4 = getCodeFromUrl(detailsRoot3.getEmbed_frame_url());
                    String str816 = baseUrl4 + '/';
                    map.put("Referer", str816);
                    map.put("Origin", baseUrl4);
                    map.put("X-Embed-Parent", str9);
                    map.put("X-Embed-Origin", "dorabash.in");
                    map.put("X-Embed-Referer", "https://dorabash.in/");
                    str3 = str816;
                    str23 = baseUrl4;
                    str24 = codeFromUrl4;
                } else {
                    str23 = str21;
                    str24 = str22;
                }
                str25 = str23 + str4 + str24 + '/' + str11 + "settings";
                Requests app16 = MainActivityKt.getApp();
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(str12);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str10);
                c00022.L$3 = str11;
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str13);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(str3);
                c00022.L$6 = map;
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot3);
                c00022.L$9 = str23;
                c00022.L$10 = str24;
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str25);
                c00022.label = 3;
                C00021 c000218 = c00022;
                str26 = str11;
                obj5 = Requests.get$default(app16, str25, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000218, 4092, (Object) null);
                c00023 = c000218;
                if (obj5 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                detailsRoot4 = detailsRoot2;
                str27 = str13;
                str28 = str3;
                detailsRoot5 = detailsRoot3;
                str29 = str26;
                str30 = str12;
                obj6 = obj5;
                str31 = str25;
                str32 = str10;
                str33 = str24;
                str34 = str23;
                z5 = z2;
                NiceResponse niceResponse18 = (NiceResponse) obj6;
                ResponseParser parser18 = niceResponse18.getParser();
                Intrinsics.checkNotNull(parser18);
                safe3 = parser18.parseSafe(niceResponse18.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                map4 = (Map) safe3;
                obj7 = obj;
                str36 = str4;
                mapM5fp = m5fp(16, 0.83d, 0.94d);
                Object obj212 = mapM5fp.get(obj2);
                Intrinsics.checkNotNull(obj212);
                mapMapOf = MapsKt.mapOf(TuplesKt.to(obj2, obj212));
                map.put("Cookie", "byse_viewer_id=" + mapM5fp.get("vId") + "; byse_device_id=" + mapM5fp.get("dId"));
                if (map4 != null) {
                    zAreEqual = Intrinsics.areEqual(map4.get("captcha_required"), Boxing.boxBoolean(z5));
                } else {
                    zAreEqual = false;
                }
                if (zAreEqual) {
                    str43 = str34 + "/api/videos/access/challenge";
                    Requests app17 = MainActivityKt.getApp();
                    Map mapEmptyMap3 = MapsKt.emptyMap();
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                    c00023.L$3 = str29;
                    c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                    c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                    c00023.L$6 = map;
                    c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                    c00023.L$9 = str34;
                    c00023.L$10 = str33;
                    c00023.L$11 = SpillingKt.nullOutSpilledVariable(str31);
                    c00023.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                    c00023.L$13 = SpillingKt.nullOutSpilledVariable(mapM5fp);
                    c00023.L$14 = mapMapOf;
                    c00023.L$15 = SpillingKt.nullOutSpilledVariable(str43);
                    c00023.label = 4;
                    C00021 c000219 = c00023;
                    str44 = str29;
                    str45 = str33;
                    str46 = str34;
                    obj9 = coroutine_suspended;
                    objPost$default = Requests.post$default(app17, str43, map, (String) null, (Map) null, (Map) null, mapEmptyMap3, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000219, 65500, (Object) null);
                    c00024 = c000219;
                    if (objPost$default == obj9) {
                        return obj9;
                    }
                    map8 = map4;
                    obj10 = objPost$default;
                    map9 = mapMapOf;
                    str47 = str44;
                    str48 = str45;
                    str49 = str43;
                    str50 = str31;
                    map6 = mapM5fp;
                    z6 = z5;
                    NiceResponse niceResponse19 = (NiceResponse) obj10;
                    ResponseParser parser19 = niceResponse19.getParser();
                    Intrinsics.checkNotNull(parser19);
                    safe4 = parser19.parseSafe(niceResponse19.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                    map10 = (Map) safe4;
                    if (map10 != null) {
                        String str817 = str46 + "/api/videos/access/attest";
                        Requests app18 = MainActivityKt.getApp();
                        Map<String, Object> mapM8wn3 = m8wn(map10);
                        c00024.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                        c00024.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                        c00024.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                        c00024.L$3 = str47;
                        c00024.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                        c00024.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                        c00024.L$6 = map;
                        c00024.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                        c00024.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                        c00024.L$9 = str46;
                        c00024.L$10 = str48;
                        c00024.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                        c00024.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                        c00024.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                        c00024.L$14 = map9;
                        c00024.L$15 = SpillingKt.nullOutSpilledVariable(str49);
                        c00024.L$16 = SpillingKt.nullOutSpilledVariable(map10);
                        c00024.L$17 = SpillingKt.nullOutSpilledVariable(str817);
                        c00024.label = 5;
                        C00021 c0002110 = c00024;
                        map11 = map9;
                        str52 = str48;
                        objPost$default2 = Requests.post$default(app18, str817, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, mapM8wn3, (RequestBody) null, false, 0, (TimeUnit) null, 10000L, (Interceptor) null, false, (ResponseParser) null, c0002110, 61308, (Object) null);
                        c00024 = c0002110;
                        if (objPost$default2 == obj9) {
                            return obj9;
                        }
                        str53 = str52;
                        map12 = map;
                        str54 = str30;
                        map13 = map6;
                        detailsRoot6 = detailsRoot5;
                        detailsRoot7 = detailsRoot4;
                        str55 = str28;
                        str56 = str27;
                        map14 = map8;
                        str57 = str50;
                        map15 = map10;
                        z8 = z6;
                        NiceResponse niceResponse110 = (NiceResponse) objPost$default2;
                        ResponseParser parser110 = niceResponse110.getParser();
                        Intrinsics.checkNotNull(parser110);
                        map19 = map15;
                        safe5 = parser110.parseSafe(niceResponse110.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                        map20 = (Map) safe5;
                        if (map20 != null) {
                            Pair[] pairArr5 = new Pair[4];
                            obj11 = obj7;
                            obj13 = map20.get(obj11);
                            if (obj13 == null) {
                                obj13 = "";
                            }
                            pairArr5[0] = TuplesKt.to(obj11, obj13);
                            obj14 = map20.get("viewer_id");
                            if (obj14 == null) {
                                obj14 = "";
                            }
                            pairArr5[z8 ? 1 : 0] = TuplesKt.to("viewer_id", obj14);
                            obj15 = map20.get("device_id");
                            if (obj15 == null) {
                                obj15 = "";
                            }
                            pairArr5[c] = TuplesKt.to("device_id", obj15);
                            objBoxDouble = map20.get("confidence");
                            if (objBoxDouble == null) {
                                objBoxDouble = Boxing.boxDouble(1.0d);
                            }
                            pairArr5[3] = TuplesKt.to("confidence", objBoxDouble);
                            mapMapOf2 = MapsKt.mapOf(TuplesKt.to(obj2, MapsKt.mapOf(pairArr5)));
                            map10 = map19;
                            map6 = map13;
                            map8 = map14;
                            str50 = str57;
                            str51 = str53;
                            detailsRoot5 = detailsRoot6;
                            detailsRoot4 = detailsRoot7;
                            map = map12;
                            str28 = str55;
                            str27 = str56;
                            str30 = str54;
                            z7 = z8;
                        } else {
                            obj11 = obj7;
                            map10 = map19;
                            map6 = map13;
                            map8 = map14;
                            str50 = str57;
                            str51 = str53;
                            detailsRoot5 = detailsRoot6;
                            detailsRoot4 = detailsRoot7;
                            map = map12;
                            str28 = str55;
                            str27 = str56;
                            str30 = str54;
                            mapMapOf2 = map11;
                            z7 = z8;
                        }
                    } else {
                        Map map33 = map9;
                        str51 = str48;
                        obj11 = obj7;
                        mapMapOf2 = map33;
                        z7 = z6;
                    }
                    String str818 = str36;
                    str58 = str46 + str818 + str51 + '/' + str47 + "captcha";
                    Object obj213 = obj11;
                    Requests app19 = MainActivityKt.getApp();
                    c00024.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                    c00024.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                    c00024.L$3 = str47;
                    c00024.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                    c00024.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                    c00024.L$6 = map;
                    c00024.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                    c00024.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                    c00024.L$9 = str46;
                    c00024.L$10 = str51;
                    c00024.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                    c00024.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                    c00024.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                    c00024.L$14 = mapMapOf2;
                    c00024.L$15 = SpillingKt.nullOutSpilledVariable(str49);
                    c00024.L$16 = SpillingKt.nullOutSpilledVariable(map10);
                    c00024.L$17 = SpillingKt.nullOutSpilledVariable(str58);
                    c00024.label = 6;
                    C00021 c0002111 = c00024;
                    obj12 = obj213;
                    str59 = str818;
                    map16 = mapMapOf2;
                    objPost$default3 = Requests.post$default(app19, str58, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, map16, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0002111, 65404, (Object) null);
                    c00023 = c0002111;
                    if (objPost$default3 == obj9) {
                        return obj9;
                    }
                    map17 = map10;
                    str60 = str51;
                    str61 = str47;
                    str62 = str49;
                    str63 = str58;
                    map18 = map16;
                    str64 = str46;
                    r34 = z7;
                    NiceResponse niceResponse111 = (NiceResponse) objPost$default3;
                    ResponseParser parser111 = niceResponse111.getParser();
                    Intrinsics.checkNotNull(parser111);
                    safe6 = parser111.parseSafe(niceResponse111.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                    map21 = (Map) safe6;
                    if (map21 != null) {
                        obj16 = map21.get("pow_nonce");
                        if (obj16 != null) {
                            str66 = "";
                        } else {
                            str66 = "";
                        }
                        obj17 = map21.get("pow_difficulty");
                        if (obj17 instanceof Number) {
                            number2 = (Number) obj17;
                        } else {
                            number2 = number;
                        }
                        if (number2 != null) {
                            iIntValue = number2.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        obj18 = map21.get("pow_token");
                        if (obj18 != null) {
                            str81 = string;
                        }
                        obj19 = obj2;
                        obj20 = obj9;
                        str67 = str81;
                        str65 = str9;
                        map22 = map;
                        obj21 = obj12;
                        str68 = str59;
                        strEr$default = er$default(this, str66, iIntValue, 0.0d, 4, null);
                        if (strEr$default != null) {
                            String str819 = str64 + str68 + str60 + '/' + str61 + "captcha/verify";
                            Pair[] pairArr6 = new Pair[3];
                            pairArr6[0] = TuplesKt.to("pow_token", str67);
                            pairArr6[r34] = TuplesKt.to("solution", strEr$default);
                            Object obj32 = map18.get(obj19);
                            Intrinsics.checkNotNull(obj32);
                            pairArr6[c] = TuplesKt.to(obj19, obj32);
                            mapMapOf3 = MapsKt.mapOf(pairArr6);
                            Requests app110 = MainActivityKt.getApp();
                            c00023.L$0 = SpillingKt.nullOutSpilledVariable(str65);
                            c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                            c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                            c00023.L$3 = str61;
                            c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                            c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                            c00023.L$6 = map22;
                            c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                            c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                            c00023.L$9 = str64;
                            c00023.L$10 = str60;
                            c00023.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                            c00023.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                            c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                            c00023.L$14 = map18;
                            c00023.L$15 = SpillingKt.nullOutSpilledVariable(str62);
                            c00023.L$16 = SpillingKt.nullOutSpilledVariable(map17);
                            c00023.L$17 = SpillingKt.nullOutSpilledVariable(str63);
                            c00023.L$18 = SpillingKt.nullOutSpilledVariable(map21);
                            c00023.L$19 = SpillingKt.nullOutSpilledVariable(str66);
                            c00023.L$20 = SpillingKt.nullOutSpilledVariable(str67);
                            c00023.L$21 = SpillingKt.nullOutSpilledVariable(strEr$default);
                            c00023.L$22 = SpillingKt.nullOutSpilledVariable(str819);
                            c00023.L$23 = SpillingKt.nullOutSpilledVariable(mapMapOf3);
                            c00023.I$0 = iIntValue;
                            c00023.label = 7;
                            C00021 c0002112 = c00023;
                            str69 = str60;
                            map23 = map18;
                            str70 = str61;
                            str37 = str68;
                            str71 = str64;
                            objPost$default4 = Requests.post$default(app110, str819, map22, (String) null, (Map) null, (Map) null, (Map) null, (List) null, mapMapOf3, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0002112, 65404, (Object) null);
                            c00023 = c0002112;
                            obj8 = obj20;
                            if (objPost$default4 == obj8) {
                                return obj8;
                            }
                            map24 = mapMapOf3;
                            str72 = str70;
                            str73 = str69;
                            map25 = map23;
                            obj22 = objPost$default4;
                            map26 = map22;
                            str74 = str30;
                            str75 = str32;
                            map27 = map6;
                            detailsRoot8 = detailsRoot5;
                            detailsRoot9 = detailsRoot4;
                            str76 = str28;
                            str77 = str27;
                            str78 = str65;
                            NiceResponse niceResponse112 = (NiceResponse) obj22;
                            ResponseParser parser112 = niceResponse112.getParser();
                            Intrinsics.checkNotNull(parser112);
                            str80 = str78;
                            safe7 = parser112.parseSafe(niceResponse112.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                            map28 = (Map) safe7;
                            if (map28 != null) {
                                map26.put("X-Captcha-Token", string3);
                                Unit unit3 = Unit.INSTANCE;
                            }
                            str42 = str80;
                            map = map26;
                            str38 = str71;
                            map5 = map25;
                            map6 = map27;
                            str39 = str73;
                            detailsRoot5 = detailsRoot8;
                            detailsRoot4 = detailsRoot9;
                            str28 = str76;
                            str27 = str77;
                            str41 = str72;
                            str32 = str75;
                            str30 = str74;
                            map7 = map8;
                            str40 = str50;
                        } else {
                            str37 = str68;
                            obj8 = obj20;
                        }
                    } else {
                        str65 = str9;
                        map22 = map;
                        obj8 = obj9;
                        str37 = str59;
                    }
                    str41 = str61;
                    str39 = str60;
                    str42 = str65;
                    str38 = str64;
                    map5 = map18;
                    map = map22;
                    map7 = map8;
                    str40 = str50;
                } else {
                    String str8110 = str29;
                    obj8 = coroutine_suspended;
                    str37 = str36;
                    map5 = mapMapOf;
                    str38 = str34;
                    str39 = str33;
                    str40 = str31;
                    str41 = str8110;
                    map6 = mapM5fp;
                    map7 = map4;
                    str42 = str9;
                }
                String str8111 = str38 + str37 + str39 + '/' + str41 + "playback";
                Requests app111 = MainActivityKt.getApp();
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(str42);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(str41);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(map);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(str39);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(str40);
                c00023.L$12 = SpillingKt.nullOutSpilledVariable(map7);
                c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                c00023.L$14 = SpillingKt.nullOutSpilledVariable(map5);
                c00023.L$15 = SpillingKt.nullOutSpilledVariable(str8111);
                c00023.L$16 = null;
                c00023.L$17 = null;
                c00023.L$18 = null;
                c00023.L$19 = null;
                c00023.L$20 = null;
                c00023.L$21 = null;
                c00023.L$22 = null;
                c00023.L$23 = null;
                c00023.label = 8;
                obj23 = obj8;
                objPost$default5 = Requests.post$default(app111, str8111, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, map5, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 65404, (Object) null);
                if (objPost$default5 == obj23) {
                    return obj23;
                }
                obj24 = objPost$default5;
                str79 = str42;
                NiceResponse niceResponse113 = (NiceResponse) obj24;
                ResponseParser parser113 = niceResponse113.getParser();
                Intrinsics.checkNotNull(parser113);
                return parser113.parseSafe(niceResponse113.getText(), Reflection.getOrCreateKotlinClass(PlaybackRoot.class));
            case 3:
                number = null;
                String str97 = (String) c00025.L$11;
                String str98 = (String) c00025.L$10;
                String str99 = (String) c00025.L$9;
                DetailsRoot detailsRoot10 = (DetailsRoot) c00025.L$8;
                DetailsRoot detailsRoot11 = (DetailsRoot) c00025.L$7;
                Map map34 = (Map) c00025.L$6;
                String str100 = (String) c00025.L$5;
                String str101 = (String) c00025.L$4;
                String str102 = (String) c00025.L$3;
                String str103 = (String) c00025.L$2;
                String str104 = (String) c00025.L$1;
                String str105 = (String) c00025.L$0;
                ResultKt.throwOnFailure(obj26);
                str9 = str105;
                detailsRoot5 = detailsRoot10;
                detailsRoot4 = detailsRoot11;
                obj = "token";
                str28 = str100;
                obj2 = "fingerprint";
                str27 = str101;
                str29 = str102;
                str31 = str97;
                str32 = str103;
                str30 = str104;
                obj6 = obj26;
                z5 = true;
                c = 2;
                c00023 = c00025;
                str33 = str98;
                map = map34;
                str4 = "/api/videos/";
                str34 = str99;
                NiceResponse niceResponse114 = (NiceResponse) obj6;
                ResponseParser parser114 = niceResponse114.getParser();
                Intrinsics.checkNotNull(parser114);
                safe3 = parser114.parseSafe(niceResponse114.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                map4 = (Map) safe3;
                obj7 = obj;
                str36 = str4;
                mapM5fp = m5fp(16, 0.83d, 0.94d);
                Object obj214 = mapM5fp.get(obj2);
                Intrinsics.checkNotNull(obj214);
                mapMapOf = MapsKt.mapOf(TuplesKt.to(obj2, obj214));
                map.put("Cookie", "byse_viewer_id=" + mapM5fp.get("vId") + "; byse_device_id=" + mapM5fp.get("dId"));
                if (map4 != null) {
                    zAreEqual = Intrinsics.areEqual(map4.get("captcha_required"), Boxing.boxBoolean(z5));
                } else {
                    zAreEqual = false;
                }
                if (zAreEqual) {
                    str43 = str34 + "/api/videos/access/challenge";
                    Requests app112 = MainActivityKt.getApp();
                    Map mapEmptyMap4 = MapsKt.emptyMap();
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                    c00023.L$3 = str29;
                    c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                    c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                    c00023.L$6 = map;
                    c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                    c00023.L$9 = str34;
                    c00023.L$10 = str33;
                    c00023.L$11 = SpillingKt.nullOutSpilledVariable(str31);
                    c00023.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                    c00023.L$13 = SpillingKt.nullOutSpilledVariable(mapM5fp);
                    c00023.L$14 = mapMapOf;
                    c00023.L$15 = SpillingKt.nullOutSpilledVariable(str43);
                    c00023.label = 4;
                    C00021 c0002113 = c00023;
                    str44 = str29;
                    str45 = str33;
                    str46 = str34;
                    obj9 = coroutine_suspended;
                    objPost$default = Requests.post$default(app112, str43, map, (String) null, (Map) null, (Map) null, mapEmptyMap4, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0002113, 65500, (Object) null);
                    c00024 = c0002113;
                    if (objPost$default == obj9) {
                        return obj9;
                    }
                    map8 = map4;
                    obj10 = objPost$default;
                    map9 = mapMapOf;
                    str47 = str44;
                    str48 = str45;
                    str49 = str43;
                    str50 = str31;
                    map6 = mapM5fp;
                    z6 = z5;
                    NiceResponse niceResponse115 = (NiceResponse) obj10;
                    ResponseParser parser115 = niceResponse115.getParser();
                    Intrinsics.checkNotNull(parser115);
                    safe4 = parser115.parseSafe(niceResponse115.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                    map10 = (Map) safe4;
                    if (map10 != null) {
                        String str8112 = str46 + "/api/videos/access/attest";
                        Requests app113 = MainActivityKt.getApp();
                        Map<String, Object> mapM8wn4 = m8wn(map10);
                        c00024.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                        c00024.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                        c00024.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                        c00024.L$3 = str47;
                        c00024.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                        c00024.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                        c00024.L$6 = map;
                        c00024.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                        c00024.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                        c00024.L$9 = str46;
                        c00024.L$10 = str48;
                        c00024.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                        c00024.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                        c00024.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                        c00024.L$14 = map9;
                        c00024.L$15 = SpillingKt.nullOutSpilledVariable(str49);
                        c00024.L$16 = SpillingKt.nullOutSpilledVariable(map10);
                        c00024.L$17 = SpillingKt.nullOutSpilledVariable(str8112);
                        c00024.label = 5;
                        C00021 c0002114 = c00024;
                        map11 = map9;
                        str52 = str48;
                        objPost$default2 = Requests.post$default(app113, str8112, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, mapM8wn4, (RequestBody) null, false, 0, (TimeUnit) null, 10000L, (Interceptor) null, false, (ResponseParser) null, c0002114, 61308, (Object) null);
                        c00024 = c0002114;
                        if (objPost$default2 == obj9) {
                            return obj9;
                        }
                        str53 = str52;
                        map12 = map;
                        str54 = str30;
                        map13 = map6;
                        detailsRoot6 = detailsRoot5;
                        detailsRoot7 = detailsRoot4;
                        str55 = str28;
                        str56 = str27;
                        map14 = map8;
                        str57 = str50;
                        map15 = map10;
                        z8 = z6;
                        NiceResponse niceResponse116 = (NiceResponse) objPost$default2;
                        ResponseParser parser116 = niceResponse116.getParser();
                        Intrinsics.checkNotNull(parser116);
                        map19 = map15;
                        safe5 = parser116.parseSafe(niceResponse116.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                        map20 = (Map) safe5;
                        if (map20 != null) {
                            Pair[] pairArr7 = new Pair[4];
                            obj11 = obj7;
                            obj13 = map20.get(obj11);
                            if (obj13 == null) {
                                obj13 = "";
                            }
                            pairArr7[0] = TuplesKt.to(obj11, obj13);
                            obj14 = map20.get("viewer_id");
                            if (obj14 == null) {
                                obj14 = "";
                            }
                            pairArr7[z8 ? 1 : 0] = TuplesKt.to("viewer_id", obj14);
                            obj15 = map20.get("device_id");
                            if (obj15 == null) {
                                obj15 = "";
                            }
                            pairArr7[c] = TuplesKt.to("device_id", obj15);
                            objBoxDouble = map20.get("confidence");
                            if (objBoxDouble == null) {
                                objBoxDouble = Boxing.boxDouble(1.0d);
                            }
                            pairArr7[3] = TuplesKt.to("confidence", objBoxDouble);
                            mapMapOf2 = MapsKt.mapOf(TuplesKt.to(obj2, MapsKt.mapOf(pairArr7)));
                            map10 = map19;
                            map6 = map13;
                            map8 = map14;
                            str50 = str57;
                            str51 = str53;
                            detailsRoot5 = detailsRoot6;
                            detailsRoot4 = detailsRoot7;
                            map = map12;
                            str28 = str55;
                            str27 = str56;
                            str30 = str54;
                            z7 = z8;
                        } else {
                            obj11 = obj7;
                            map10 = map19;
                            map6 = map13;
                            map8 = map14;
                            str50 = str57;
                            str51 = str53;
                            detailsRoot5 = detailsRoot6;
                            detailsRoot4 = detailsRoot7;
                            map = map12;
                            str28 = str55;
                            str27 = str56;
                            str30 = str54;
                            mapMapOf2 = map11;
                            z7 = z8;
                        }
                    } else {
                        Map map35 = map9;
                        str51 = str48;
                        obj11 = obj7;
                        mapMapOf2 = map35;
                        z7 = z6;
                    }
                    String str8113 = str36;
                    str58 = str46 + str8113 + str51 + '/' + str47 + "captcha";
                    Object obj215 = obj11;
                    Requests app114 = MainActivityKt.getApp();
                    c00024.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                    c00024.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                    c00024.L$3 = str47;
                    c00024.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                    c00024.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                    c00024.L$6 = map;
                    c00024.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                    c00024.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                    c00024.L$9 = str46;
                    c00024.L$10 = str51;
                    c00024.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                    c00024.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                    c00024.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                    c00024.L$14 = mapMapOf2;
                    c00024.L$15 = SpillingKt.nullOutSpilledVariable(str49);
                    c00024.L$16 = SpillingKt.nullOutSpilledVariable(map10);
                    c00024.L$17 = SpillingKt.nullOutSpilledVariable(str58);
                    c00024.label = 6;
                    C00021 c0002115 = c00024;
                    obj12 = obj215;
                    str59 = str8113;
                    map16 = mapMapOf2;
                    objPost$default3 = Requests.post$default(app114, str58, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, map16, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0002115, 65404, (Object) null);
                    c00023 = c0002115;
                    if (objPost$default3 == obj9) {
                        return obj9;
                    }
                    map17 = map10;
                    str60 = str51;
                    str61 = str47;
                    str62 = str49;
                    str63 = str58;
                    map18 = map16;
                    str64 = str46;
                    r34 = z7;
                    NiceResponse niceResponse117 = (NiceResponse) objPost$default3;
                    ResponseParser parser117 = niceResponse117.getParser();
                    Intrinsics.checkNotNull(parser117);
                    safe6 = parser117.parseSafe(niceResponse117.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                    map21 = (Map) safe6;
                    if (map21 != null) {
                        obj16 = map21.get("pow_nonce");
                        if (obj16 != null) {
                            str66 = "";
                        } else {
                            str66 = "";
                        }
                        obj17 = map21.get("pow_difficulty");
                        if (obj17 instanceof Number) {
                            number2 = (Number) obj17;
                        } else {
                            number2 = number;
                        }
                        if (number2 != null) {
                            iIntValue = number2.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        obj18 = map21.get("pow_token");
                        if (obj18 != null) {
                            str81 = string;
                        }
                        obj19 = obj2;
                        obj20 = obj9;
                        str67 = str81;
                        str65 = str9;
                        map22 = map;
                        obj21 = obj12;
                        str68 = str59;
                        strEr$default = er$default(this, str66, iIntValue, 0.0d, 4, null);
                        if (strEr$default != null) {
                            String str8114 = str64 + str68 + str60 + '/' + str61 + "captcha/verify";
                            Pair[] pairArr8 = new Pair[3];
                            pairArr8[0] = TuplesKt.to("pow_token", str67);
                            pairArr8[r34] = TuplesKt.to("solution", strEr$default);
                            Object obj33 = map18.get(obj19);
                            Intrinsics.checkNotNull(obj33);
                            pairArr8[c] = TuplesKt.to(obj19, obj33);
                            mapMapOf3 = MapsKt.mapOf(pairArr8);
                            Requests app115 = MainActivityKt.getApp();
                            c00023.L$0 = SpillingKt.nullOutSpilledVariable(str65);
                            c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                            c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                            c00023.L$3 = str61;
                            c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                            c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                            c00023.L$6 = map22;
                            c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                            c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                            c00023.L$9 = str64;
                            c00023.L$10 = str60;
                            c00023.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                            c00023.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                            c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                            c00023.L$14 = map18;
                            c00023.L$15 = SpillingKt.nullOutSpilledVariable(str62);
                            c00023.L$16 = SpillingKt.nullOutSpilledVariable(map17);
                            c00023.L$17 = SpillingKt.nullOutSpilledVariable(str63);
                            c00023.L$18 = SpillingKt.nullOutSpilledVariable(map21);
                            c00023.L$19 = SpillingKt.nullOutSpilledVariable(str66);
                            c00023.L$20 = SpillingKt.nullOutSpilledVariable(str67);
                            c00023.L$21 = SpillingKt.nullOutSpilledVariable(strEr$default);
                            c00023.L$22 = SpillingKt.nullOutSpilledVariable(str8114);
                            c00023.L$23 = SpillingKt.nullOutSpilledVariable(mapMapOf3);
                            c00023.I$0 = iIntValue;
                            c00023.label = 7;
                            C00021 c0002116 = c00023;
                            str69 = str60;
                            map23 = map18;
                            str70 = str61;
                            str37 = str68;
                            str71 = str64;
                            objPost$default4 = Requests.post$default(app115, str8114, map22, (String) null, (Map) null, (Map) null, (Map) null, (List) null, mapMapOf3, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0002116, 65404, (Object) null);
                            c00023 = c0002116;
                            obj8 = obj20;
                            if (objPost$default4 == obj8) {
                                return obj8;
                            }
                            map24 = mapMapOf3;
                            str72 = str70;
                            str73 = str69;
                            map25 = map23;
                            obj22 = objPost$default4;
                            map26 = map22;
                            str74 = str30;
                            str75 = str32;
                            map27 = map6;
                            detailsRoot8 = detailsRoot5;
                            detailsRoot9 = detailsRoot4;
                            str76 = str28;
                            str77 = str27;
                            str78 = str65;
                            NiceResponse niceResponse118 = (NiceResponse) obj22;
                            ResponseParser parser118 = niceResponse118.getParser();
                            Intrinsics.checkNotNull(parser118);
                            str80 = str78;
                            safe7 = parser118.parseSafe(niceResponse118.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                            map28 = (Map) safe7;
                            if (map28 != null) {
                                map26.put("X-Captcha-Token", string3);
                                Unit unit4 = Unit.INSTANCE;
                            }
                            str42 = str80;
                            map = map26;
                            str38 = str71;
                            map5 = map25;
                            map6 = map27;
                            str39 = str73;
                            detailsRoot5 = detailsRoot8;
                            detailsRoot4 = detailsRoot9;
                            str28 = str76;
                            str27 = str77;
                            str41 = str72;
                            str32 = str75;
                            str30 = str74;
                            map7 = map8;
                            str40 = str50;
                        } else {
                            str37 = str68;
                            obj8 = obj20;
                        }
                    } else {
                        str65 = str9;
                        map22 = map;
                        obj8 = obj9;
                        str37 = str59;
                    }
                    str41 = str61;
                    str39 = str60;
                    str42 = str65;
                    str38 = str64;
                    map5 = map18;
                    map = map22;
                    map7 = map8;
                    str40 = str50;
                } else {
                    String str8115 = str29;
                    obj8 = coroutine_suspended;
                    str37 = str36;
                    map5 = mapMapOf;
                    str38 = str34;
                    str39 = str33;
                    str40 = str31;
                    str41 = str8115;
                    map6 = mapM5fp;
                    map7 = map4;
                    str42 = str9;
                }
                String str8116 = str38 + str37 + str39 + '/' + str41 + "playback";
                Requests app116 = MainActivityKt.getApp();
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(str42);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(str41);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(map);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(str39);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(str40);
                c00023.L$12 = SpillingKt.nullOutSpilledVariable(map7);
                c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                c00023.L$14 = SpillingKt.nullOutSpilledVariable(map5);
                c00023.L$15 = SpillingKt.nullOutSpilledVariable(str8116);
                c00023.L$16 = null;
                c00023.L$17 = null;
                c00023.L$18 = null;
                c00023.L$19 = null;
                c00023.L$20 = null;
                c00023.L$21 = null;
                c00023.L$22 = null;
                c00023.L$23 = null;
                c00023.label = 8;
                obj23 = obj8;
                objPost$default5 = Requests.post$default(app116, str8116, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, map5, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 65404, (Object) null);
                if (objPost$default5 == obj23) {
                    return obj23;
                }
                obj24 = objPost$default5;
                str79 = str42;
                NiceResponse niceResponse119 = (NiceResponse) obj24;
                ResponseParser parser119 = niceResponse119.getParser();
                Intrinsics.checkNotNull(parser119);
                return parser119.parseSafe(niceResponse119.getText(), Reflection.getOrCreateKotlinClass(PlaybackRoot.class));
            case 4:
                number = null;
                String str106 = (String) c00025.L$15;
                Map map36 = (Map) c00025.L$14;
                Map<String, Object> map37 = (Map) c00025.L$13;
                Map map38 = (Map) c00025.L$12;
                String str107 = (String) c00025.L$11;
                str48 = (String) c00025.L$10;
                String str108 = (String) c00025.L$9;
                DetailsRoot detailsRoot12 = (DetailsRoot) c00025.L$8;
                DetailsRoot detailsRoot13 = (DetailsRoot) c00025.L$7;
                Map map39 = (Map) c00025.L$6;
                String str109 = (String) c00025.L$5;
                String str110 = (String) c00025.L$4;
                String str111 = (String) c00025.L$3;
                String str112 = (String) c00025.L$2;
                String str113 = (String) c00025.L$1;
                String str114 = (String) c00025.L$0;
                ResultKt.throwOnFailure(obj26);
                str9 = str114;
                map6 = map37;
                map8 = map38;
                str50 = str107;
                obj7 = "token";
                str46 = str108;
                obj2 = "fingerprint";
                detailsRoot5 = detailsRoot12;
                str36 = "/api/videos/";
                detailsRoot4 = detailsRoot13;
                str49 = str106;
                map = map39;
                str28 = str109;
                str27 = str110;
                str32 = str112;
                str30 = str113;
                obj10 = obj26;
                z6 = true;
                c = 2;
                c00024 = c00025;
                map9 = map36;
                obj9 = coroutine_suspended;
                str47 = str111;
                NiceResponse niceResponse1110 = (NiceResponse) obj10;
                ResponseParser parser1110 = niceResponse1110.getParser();
                Intrinsics.checkNotNull(parser1110);
                safe4 = parser1110.parseSafe(niceResponse1110.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                map10 = (Map) safe4;
                if (map10 != null) {
                    String str8117 = str46 + "/api/videos/access/attest";
                    Requests app117 = MainActivityKt.getApp();
                    Map<String, Object> mapM8wn5 = m8wn(map10);
                    c00024.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                    c00024.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                    c00024.L$3 = str47;
                    c00024.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                    c00024.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                    c00024.L$6 = map;
                    c00024.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                    c00024.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                    c00024.L$9 = str46;
                    c00024.L$10 = str48;
                    c00024.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                    c00024.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                    c00024.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                    c00024.L$14 = map9;
                    c00024.L$15 = SpillingKt.nullOutSpilledVariable(str49);
                    c00024.L$16 = SpillingKt.nullOutSpilledVariable(map10);
                    c00024.L$17 = SpillingKt.nullOutSpilledVariable(str8117);
                    c00024.label = 5;
                    C00021 c0002117 = c00024;
                    map11 = map9;
                    str52 = str48;
                    objPost$default2 = Requests.post$default(app117, str8117, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, mapM8wn5, (RequestBody) null, false, 0, (TimeUnit) null, 10000L, (Interceptor) null, false, (ResponseParser) null, c0002117, 61308, (Object) null);
                    c00024 = c0002117;
                    if (objPost$default2 == obj9) {
                        return obj9;
                    }
                    str53 = str52;
                    map12 = map;
                    str54 = str30;
                    map13 = map6;
                    detailsRoot6 = detailsRoot5;
                    detailsRoot7 = detailsRoot4;
                    str55 = str28;
                    str56 = str27;
                    map14 = map8;
                    str57 = str50;
                    map15 = map10;
                    z8 = z6;
                    NiceResponse niceResponse1111 = (NiceResponse) objPost$default2;
                    ResponseParser parser1111 = niceResponse1111.getParser();
                    Intrinsics.checkNotNull(parser1111);
                    map19 = map15;
                    safe5 = parser1111.parseSafe(niceResponse1111.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                    map20 = (Map) safe5;
                    if (map20 != null) {
                        Pair[] pairArr9 = new Pair[4];
                        obj11 = obj7;
                        obj13 = map20.get(obj11);
                        if (obj13 == null) {
                            obj13 = "";
                        }
                        pairArr9[0] = TuplesKt.to(obj11, obj13);
                        obj14 = map20.get("viewer_id");
                        if (obj14 == null) {
                            obj14 = "";
                        }
                        pairArr9[z8 ? 1 : 0] = TuplesKt.to("viewer_id", obj14);
                        obj15 = map20.get("device_id");
                        if (obj15 == null) {
                            obj15 = "";
                        }
                        pairArr9[c] = TuplesKt.to("device_id", obj15);
                        objBoxDouble = map20.get("confidence");
                        if (objBoxDouble == null) {
                            objBoxDouble = Boxing.boxDouble(1.0d);
                        }
                        pairArr9[3] = TuplesKt.to("confidence", objBoxDouble);
                        mapMapOf2 = MapsKt.mapOf(TuplesKt.to(obj2, MapsKt.mapOf(pairArr9)));
                        map10 = map19;
                        map6 = map13;
                        map8 = map14;
                        str50 = str57;
                        str51 = str53;
                        detailsRoot5 = detailsRoot6;
                        detailsRoot4 = detailsRoot7;
                        map = map12;
                        str28 = str55;
                        str27 = str56;
                        str30 = str54;
                        z7 = z8;
                    } else {
                        obj11 = obj7;
                        map10 = map19;
                        map6 = map13;
                        map8 = map14;
                        str50 = str57;
                        str51 = str53;
                        detailsRoot5 = detailsRoot6;
                        detailsRoot4 = detailsRoot7;
                        map = map12;
                        str28 = str55;
                        str27 = str56;
                        str30 = str54;
                        mapMapOf2 = map11;
                        z7 = z8;
                    }
                } else {
                    Map map310 = map9;
                    str51 = str48;
                    obj11 = obj7;
                    mapMapOf2 = map310;
                    z7 = z6;
                }
                String str8118 = str36;
                str58 = str46 + str8118 + str51 + '/' + str47 + "captcha";
                Object obj216 = obj11;
                Requests app118 = MainActivityKt.getApp();
                c00024.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                c00024.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                c00024.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                c00024.L$3 = str47;
                c00024.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                c00024.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                c00024.L$6 = map;
                c00024.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                c00024.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                c00024.L$9 = str46;
                c00024.L$10 = str51;
                c00024.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                c00024.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                c00024.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                c00024.L$14 = mapMapOf2;
                c00024.L$15 = SpillingKt.nullOutSpilledVariable(str49);
                c00024.L$16 = SpillingKt.nullOutSpilledVariable(map10);
                c00024.L$17 = SpillingKt.nullOutSpilledVariable(str58);
                c00024.label = 6;
                C00021 c0002118 = c00024;
                obj12 = obj216;
                str59 = str8118;
                map16 = mapMapOf2;
                objPost$default3 = Requests.post$default(app118, str58, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, map16, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0002118, 65404, (Object) null);
                c00023 = c0002118;
                if (objPost$default3 == obj9) {
                    return obj9;
                }
                map17 = map10;
                str60 = str51;
                str61 = str47;
                str62 = str49;
                str63 = str58;
                map18 = map16;
                str64 = str46;
                r34 = z7;
                NiceResponse niceResponse1112 = (NiceResponse) objPost$default3;
                ResponseParser parser1112 = niceResponse1112.getParser();
                Intrinsics.checkNotNull(parser1112);
                safe6 = parser1112.parseSafe(niceResponse1112.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                map21 = (Map) safe6;
                if (map21 != null) {
                    obj16 = map21.get("pow_nonce");
                    if (obj16 != null) {
                        str66 = "";
                    } else {
                        str66 = "";
                    }
                    obj17 = map21.get("pow_difficulty");
                    if (obj17 instanceof Number) {
                        number2 = (Number) obj17;
                    } else {
                        number2 = number;
                    }
                    if (number2 != null) {
                        iIntValue = number2.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    obj18 = map21.get("pow_token");
                    if (obj18 != null) {
                        str81 = string;
                    }
                    obj19 = obj2;
                    obj20 = obj9;
                    str67 = str81;
                    str65 = str9;
                    map22 = map;
                    obj21 = obj12;
                    str68 = str59;
                    strEr$default = er$default(this, str66, iIntValue, 0.0d, 4, null);
                    if (strEr$default != null) {
                        String str8119 = str64 + str68 + str60 + '/' + str61 + "captcha/verify";
                        Pair[] pairArr10 = new Pair[3];
                        pairArr10[0] = TuplesKt.to("pow_token", str67);
                        pairArr10[r34] = TuplesKt.to("solution", strEr$default);
                        Object obj34 = map18.get(obj19);
                        Intrinsics.checkNotNull(obj34);
                        pairArr10[c] = TuplesKt.to(obj19, obj34);
                        mapMapOf3 = MapsKt.mapOf(pairArr10);
                        Requests app119 = MainActivityKt.getApp();
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(str65);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                        c00023.L$3 = str61;
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                        c00023.L$6 = map22;
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                        c00023.L$9 = str64;
                        c00023.L$10 = str60;
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                        c00023.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                        c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                        c00023.L$14 = map18;
                        c00023.L$15 = SpillingKt.nullOutSpilledVariable(str62);
                        c00023.L$16 = SpillingKt.nullOutSpilledVariable(map17);
                        c00023.L$17 = SpillingKt.nullOutSpilledVariable(str63);
                        c00023.L$18 = SpillingKt.nullOutSpilledVariable(map21);
                        c00023.L$19 = SpillingKt.nullOutSpilledVariable(str66);
                        c00023.L$20 = SpillingKt.nullOutSpilledVariable(str67);
                        c00023.L$21 = SpillingKt.nullOutSpilledVariable(strEr$default);
                        c00023.L$22 = SpillingKt.nullOutSpilledVariable(str8119);
                        c00023.L$23 = SpillingKt.nullOutSpilledVariable(mapMapOf3);
                        c00023.I$0 = iIntValue;
                        c00023.label = 7;
                        C00021 c0002119 = c00023;
                        str69 = str60;
                        map23 = map18;
                        str70 = str61;
                        str37 = str68;
                        str71 = str64;
                        objPost$default4 = Requests.post$default(app119, str8119, map22, (String) null, (Map) null, (Map) null, (Map) null, (List) null, mapMapOf3, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0002119, 65404, (Object) null);
                        c00023 = c0002119;
                        obj8 = obj20;
                        if (objPost$default4 == obj8) {
                            return obj8;
                        }
                        map24 = mapMapOf3;
                        str72 = str70;
                        str73 = str69;
                        map25 = map23;
                        obj22 = objPost$default4;
                        map26 = map22;
                        str74 = str30;
                        str75 = str32;
                        map27 = map6;
                        detailsRoot8 = detailsRoot5;
                        detailsRoot9 = detailsRoot4;
                        str76 = str28;
                        str77 = str27;
                        str78 = str65;
                        NiceResponse niceResponse1113 = (NiceResponse) obj22;
                        ResponseParser parser1113 = niceResponse1113.getParser();
                        Intrinsics.checkNotNull(parser1113);
                        str80 = str78;
                        safe7 = parser1113.parseSafe(niceResponse1113.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                        map28 = (Map) safe7;
                        if (map28 != null) {
                            map26.put("X-Captcha-Token", string3);
                            Unit unit5 = Unit.INSTANCE;
                        }
                        str42 = str80;
                        map = map26;
                        str38 = str71;
                        map5 = map25;
                        map6 = map27;
                        str39 = str73;
                        detailsRoot5 = detailsRoot8;
                        detailsRoot4 = detailsRoot9;
                        str28 = str76;
                        str27 = str77;
                        str41 = str72;
                        str32 = str75;
                        str30 = str74;
                        map7 = map8;
                        str40 = str50;
                        String str81110 = str38 + str37 + str39 + '/' + str41 + "playback";
                        Requests app1110 = MainActivityKt.getApp();
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(str42);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(str41);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(map);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                        c00023.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(str39);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(str40);
                        c00023.L$12 = SpillingKt.nullOutSpilledVariable(map7);
                        c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                        c00023.L$14 = SpillingKt.nullOutSpilledVariable(map5);
                        c00023.L$15 = SpillingKt.nullOutSpilledVariable(str81110);
                        c00023.L$16 = null;
                        c00023.L$17 = null;
                        c00023.L$18 = null;
                        c00023.L$19 = null;
                        c00023.L$20 = null;
                        c00023.L$21 = null;
                        c00023.L$22 = null;
                        c00023.L$23 = null;
                        c00023.label = 8;
                        obj23 = obj8;
                        objPost$default5 = Requests.post$default(app1110, str81110, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, map5, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 65404, (Object) null);
                        if (objPost$default5 == obj23) {
                            return obj23;
                        }
                        obj24 = objPost$default5;
                        str79 = str42;
                        NiceResponse niceResponse1114 = (NiceResponse) obj24;
                        ResponseParser parser1114 = niceResponse1114.getParser();
                        Intrinsics.checkNotNull(parser1114);
                        return parser1114.parseSafe(niceResponse1114.getText(), Reflection.getOrCreateKotlinClass(PlaybackRoot.class));
                    }
                    str37 = str68;
                    obj8 = obj20;
                } else {
                    str65 = str9;
                    map22 = map;
                    obj8 = obj9;
                    str37 = str59;
                }
                str41 = str61;
                str39 = str60;
                str42 = str65;
                str38 = str64;
                map5 = map18;
                map = map22;
                map7 = map8;
                str40 = str50;
                String str81111 = str38 + str37 + str39 + '/' + str41 + "playback";
                Requests app1111 = MainActivityKt.getApp();
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(str42);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(str41);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(map);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(str39);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(str40);
                c00023.L$12 = SpillingKt.nullOutSpilledVariable(map7);
                c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                c00023.L$14 = SpillingKt.nullOutSpilledVariable(map5);
                c00023.L$15 = SpillingKt.nullOutSpilledVariable(str81111);
                c00023.L$16 = null;
                c00023.L$17 = null;
                c00023.L$18 = null;
                c00023.L$19 = null;
                c00023.L$20 = null;
                c00023.L$21 = null;
                c00023.L$22 = null;
                c00023.L$23 = null;
                c00023.label = 8;
                obj23 = obj8;
                objPost$default5 = Requests.post$default(app1111, str81111, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, map5, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 65404, (Object) null);
                if (objPost$default5 == obj23) {
                    return obj23;
                }
                obj24 = objPost$default5;
                str79 = str42;
                NiceResponse niceResponse1115 = (NiceResponse) obj24;
                ResponseParser parser1115 = niceResponse1115.getParser();
                Intrinsics.checkNotNull(parser1115);
                return parser1115.parseSafe(niceResponse1115.getText(), Reflection.getOrCreateKotlinClass(PlaybackRoot.class));
            case 5:
                number = null;
                Map<String, ? extends Object> map40 = (Map) c00025.L$16;
                str49 = (String) c00025.L$15;
                Map map41 = (Map) c00025.L$14;
                map13 = (Map) c00025.L$13;
                map14 = (Map) c00025.L$12;
                str57 = (String) c00025.L$11;
                str53 = (String) c00025.L$10;
                String str115 = (String) c00025.L$9;
                detailsRoot6 = (DetailsRoot) c00025.L$8;
                detailsRoot7 = (DetailsRoot) c00025.L$7;
                map12 = (Map) c00025.L$6;
                str55 = (String) c00025.L$5;
                str56 = (String) c00025.L$4;
                String str116 = (String) c00025.L$3;
                String str117 = (String) c00025.L$2;
                str54 = (String) c00025.L$1;
                String str118 = (String) c00025.L$0;
                ResultKt.throwOnFailure(obj26);
                str9 = str118;
                map11 = map41;
                obj7 = "token";
                obj2 = "fingerprint";
                str36 = "/api/videos/";
                str32 = str117;
                objPost$default2 = obj26;
                z8 = true;
                c = 2;
                c00024 = c00025;
                map15 = map40;
                str46 = str115;
                obj9 = coroutine_suspended;
                str47 = str116;
                NiceResponse niceResponse1116 = (NiceResponse) objPost$default2;
                ResponseParser parser1116 = niceResponse1116.getParser();
                Intrinsics.checkNotNull(parser1116);
                map19 = map15;
                safe5 = parser1116.parseSafe(niceResponse1116.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                map20 = (Map) safe5;
                if (map20 != null) {
                    Pair[] pairArr11 = new Pair[4];
                    obj11 = obj7;
                    obj13 = map20.get(obj11);
                    if (obj13 == null) {
                        obj13 = "";
                    }
                    pairArr11[0] = TuplesKt.to(obj11, obj13);
                    obj14 = map20.get("viewer_id");
                    if (obj14 == null) {
                        obj14 = "";
                    }
                    pairArr11[z8 ? 1 : 0] = TuplesKt.to("viewer_id", obj14);
                    obj15 = map20.get("device_id");
                    if (obj15 == null) {
                        obj15 = "";
                    }
                    pairArr11[c] = TuplesKt.to("device_id", obj15);
                    objBoxDouble = map20.get("confidence");
                    if (objBoxDouble == null) {
                        objBoxDouble = Boxing.boxDouble(1.0d);
                    }
                    pairArr11[3] = TuplesKt.to("confidence", objBoxDouble);
                    mapMapOf2 = MapsKt.mapOf(TuplesKt.to(obj2, MapsKt.mapOf(pairArr11)));
                    map10 = map19;
                    map6 = map13;
                    map8 = map14;
                    str50 = str57;
                    str51 = str53;
                    detailsRoot5 = detailsRoot6;
                    detailsRoot4 = detailsRoot7;
                    map = map12;
                    str28 = str55;
                    str27 = str56;
                    str30 = str54;
                    z7 = z8;
                } else {
                    obj11 = obj7;
                    map10 = map19;
                    map6 = map13;
                    map8 = map14;
                    str50 = str57;
                    str51 = str53;
                    detailsRoot5 = detailsRoot6;
                    detailsRoot4 = detailsRoot7;
                    map = map12;
                    str28 = str55;
                    str27 = str56;
                    str30 = str54;
                    mapMapOf2 = map11;
                    z7 = z8;
                }
                String str81112 = str36;
                str58 = str46 + str81112 + str51 + '/' + str47 + "captcha";
                Object obj217 = obj11;
                Requests app1112 = MainActivityKt.getApp();
                c00024.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                c00024.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                c00024.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                c00024.L$3 = str47;
                c00024.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                c00024.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                c00024.L$6 = map;
                c00024.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                c00024.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                c00024.L$9 = str46;
                c00024.L$10 = str51;
                c00024.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                c00024.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                c00024.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                c00024.L$14 = mapMapOf2;
                c00024.L$15 = SpillingKt.nullOutSpilledVariable(str49);
                c00024.L$16 = SpillingKt.nullOutSpilledVariable(map10);
                c00024.L$17 = SpillingKt.nullOutSpilledVariable(str58);
                c00024.label = 6;
                C00021 c00021110 = c00024;
                obj12 = obj217;
                str59 = str81112;
                map16 = mapMapOf2;
                objPost$default3 = Requests.post$default(app1112, str58, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, map16, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021110, 65404, (Object) null);
                c00023 = c00021110;
                if (objPost$default3 == obj9) {
                    return obj9;
                }
                map17 = map10;
                str60 = str51;
                str61 = str47;
                str62 = str49;
                str63 = str58;
                map18 = map16;
                str64 = str46;
                r34 = z7;
                NiceResponse niceResponse1117 = (NiceResponse) objPost$default3;
                ResponseParser parser1117 = niceResponse1117.getParser();
                Intrinsics.checkNotNull(parser1117);
                safe6 = parser1117.parseSafe(niceResponse1117.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                map21 = (Map) safe6;
                if (map21 != null) {
                    obj16 = map21.get("pow_nonce");
                    if (obj16 != null) {
                        str66 = "";
                    } else {
                        str66 = "";
                    }
                    obj17 = map21.get("pow_difficulty");
                    if (obj17 instanceof Number) {
                        number2 = (Number) obj17;
                    } else {
                        number2 = number;
                    }
                    if (number2 != null) {
                        iIntValue = number2.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    obj18 = map21.get("pow_token");
                    if (obj18 != null) {
                        str81 = string;
                    }
                    obj19 = obj2;
                    obj20 = obj9;
                    str67 = str81;
                    str65 = str9;
                    map22 = map;
                    obj21 = obj12;
                    str68 = str59;
                    strEr$default = er$default(this, str66, iIntValue, 0.0d, 4, null);
                    if (strEr$default != null) {
                        String str81113 = str64 + str68 + str60 + '/' + str61 + "captcha/verify";
                        Pair[] pairArr12 = new Pair[3];
                        pairArr12[0] = TuplesKt.to("pow_token", str67);
                        pairArr12[r34] = TuplesKt.to("solution", strEr$default);
                        Object obj35 = map18.get(obj19);
                        Intrinsics.checkNotNull(obj35);
                        pairArr12[c] = TuplesKt.to(obj19, obj35);
                        mapMapOf3 = MapsKt.mapOf(pairArr12);
                        Requests app1113 = MainActivityKt.getApp();
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(str65);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                        c00023.L$3 = str61;
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                        c00023.L$6 = map22;
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                        c00023.L$9 = str64;
                        c00023.L$10 = str60;
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                        c00023.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                        c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                        c00023.L$14 = map18;
                        c00023.L$15 = SpillingKt.nullOutSpilledVariable(str62);
                        c00023.L$16 = SpillingKt.nullOutSpilledVariable(map17);
                        c00023.L$17 = SpillingKt.nullOutSpilledVariable(str63);
                        c00023.L$18 = SpillingKt.nullOutSpilledVariable(map21);
                        c00023.L$19 = SpillingKt.nullOutSpilledVariable(str66);
                        c00023.L$20 = SpillingKt.nullOutSpilledVariable(str67);
                        c00023.L$21 = SpillingKt.nullOutSpilledVariable(strEr$default);
                        c00023.L$22 = SpillingKt.nullOutSpilledVariable(str81113);
                        c00023.L$23 = SpillingKt.nullOutSpilledVariable(mapMapOf3);
                        c00023.I$0 = iIntValue;
                        c00023.label = 7;
                        C00021 c00021111 = c00023;
                        str69 = str60;
                        map23 = map18;
                        str70 = str61;
                        str37 = str68;
                        str71 = str64;
                        objPost$default4 = Requests.post$default(app1113, str81113, map22, (String) null, (Map) null, (Map) null, (Map) null, (List) null, mapMapOf3, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021111, 65404, (Object) null);
                        c00023 = c00021111;
                        obj8 = obj20;
                        if (objPost$default4 == obj8) {
                            return obj8;
                        }
                        map24 = mapMapOf3;
                        str72 = str70;
                        str73 = str69;
                        map25 = map23;
                        obj22 = objPost$default4;
                        map26 = map22;
                        str74 = str30;
                        str75 = str32;
                        map27 = map6;
                        detailsRoot8 = detailsRoot5;
                        detailsRoot9 = detailsRoot4;
                        str76 = str28;
                        str77 = str27;
                        str78 = str65;
                        NiceResponse niceResponse1118 = (NiceResponse) obj22;
                        ResponseParser parser1118 = niceResponse1118.getParser();
                        Intrinsics.checkNotNull(parser1118);
                        str80 = str78;
                        safe7 = parser1118.parseSafe(niceResponse1118.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                        map28 = (Map) safe7;
                        if (map28 != null) {
                            map26.put("X-Captcha-Token", string3);
                            Unit unit6 = Unit.INSTANCE;
                        }
                        str42 = str80;
                        map = map26;
                        str38 = str71;
                        map5 = map25;
                        map6 = map27;
                        str39 = str73;
                        detailsRoot5 = detailsRoot8;
                        detailsRoot4 = detailsRoot9;
                        str28 = str76;
                        str27 = str77;
                        str41 = str72;
                        str32 = str75;
                        str30 = str74;
                        map7 = map8;
                        str40 = str50;
                        String str81114 = str38 + str37 + str39 + '/' + str41 + "playback";
                        Requests app1114 = MainActivityKt.getApp();
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(str42);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(str41);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(map);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                        c00023.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(str39);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(str40);
                        c00023.L$12 = SpillingKt.nullOutSpilledVariable(map7);
                        c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                        c00023.L$14 = SpillingKt.nullOutSpilledVariable(map5);
                        c00023.L$15 = SpillingKt.nullOutSpilledVariable(str81114);
                        c00023.L$16 = null;
                        c00023.L$17 = null;
                        c00023.L$18 = null;
                        c00023.L$19 = null;
                        c00023.L$20 = null;
                        c00023.L$21 = null;
                        c00023.L$22 = null;
                        c00023.L$23 = null;
                        c00023.label = 8;
                        obj23 = obj8;
                        objPost$default5 = Requests.post$default(app1114, str81114, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, map5, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 65404, (Object) null);
                        if (objPost$default5 == obj23) {
                            return obj23;
                        }
                        obj24 = objPost$default5;
                        str79 = str42;
                        NiceResponse niceResponse1119 = (NiceResponse) obj24;
                        ResponseParser parser1119 = niceResponse1119.getParser();
                        Intrinsics.checkNotNull(parser1119);
                        return parser1119.parseSafe(niceResponse1119.getText(), Reflection.getOrCreateKotlinClass(PlaybackRoot.class));
                    }
                    str37 = str68;
                    obj8 = obj20;
                } else {
                    str65 = str9;
                    map22 = map;
                    obj8 = obj9;
                    str37 = str59;
                }
                str41 = str61;
                str39 = str60;
                str42 = str65;
                str38 = str64;
                map5 = map18;
                map = map22;
                map7 = map8;
                str40 = str50;
                String str81115 = str38 + str37 + str39 + '/' + str41 + "playback";
                Requests app1115 = MainActivityKt.getApp();
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(str42);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(str41);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(map);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(str39);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(str40);
                c00023.L$12 = SpillingKt.nullOutSpilledVariable(map7);
                c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                c00023.L$14 = SpillingKt.nullOutSpilledVariable(map5);
                c00023.L$15 = SpillingKt.nullOutSpilledVariable(str81115);
                c00023.L$16 = null;
                c00023.L$17 = null;
                c00023.L$18 = null;
                c00023.L$19 = null;
                c00023.L$20 = null;
                c00023.L$21 = null;
                c00023.L$22 = null;
                c00023.L$23 = null;
                c00023.label = 8;
                obj23 = obj8;
                objPost$default5 = Requests.post$default(app1115, str81115, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, map5, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 65404, (Object) null);
                if (objPost$default5 == obj23) {
                    return obj23;
                }
                obj24 = objPost$default5;
                str79 = str42;
                NiceResponse niceResponse11110 = (NiceResponse) obj24;
                ResponseParser parser11110 = niceResponse11110.getParser();
                Intrinsics.checkNotNull(parser11110);
                return parser11110.parseSafe(niceResponse11110.getText(), Reflection.getOrCreateKotlinClass(PlaybackRoot.class));
            case 6:
                number = null;
                String str119 = (String) c00025.L$17;
                Map<String, ? extends Object> map42 = (Map) c00025.L$16;
                String str120 = (String) c00025.L$15;
                Map map43 = (Map) c00025.L$14;
                Map<String, Object> map44 = (Map) c00025.L$13;
                Map map45 = (Map) c00025.L$12;
                String str121 = (String) c00025.L$11;
                str60 = (String) c00025.L$10;
                String str122 = (String) c00025.L$9;
                DetailsRoot detailsRoot14 = (DetailsRoot) c00025.L$8;
                DetailsRoot detailsRoot15 = (DetailsRoot) c00025.L$7;
                Map map46 = (Map) c00025.L$6;
                String str123 = (String) c00025.L$5;
                String str124 = (String) c00025.L$4;
                String str125 = (String) c00025.L$3;
                String str126 = (String) c00025.L$2;
                String str127 = (String) c00025.L$1;
                String str128 = (String) c00025.L$0;
                ResultKt.throwOnFailure(obj26);
                str9 = str128;
                map17 = map42;
                str62 = str120;
                map6 = map44;
                obj12 = "token";
                str50 = str121;
                str64 = str122;
                obj2 = "fingerprint";
                str59 = "/api/videos/";
                map8 = map45;
                str63 = str119;
                detailsRoot5 = detailsRoot14;
                detailsRoot4 = detailsRoot15;
                map = map46;
                str28 = str123;
                str27 = str124;
                str61 = str125;
                str32 = str126;
                str30 = str127;
                objPost$default3 = obj26;
                r34 = 1;
                c = 2;
                c00023 = c00025;
                obj9 = coroutine_suspended;
                map18 = map43;
                NiceResponse niceResponse11111 = (NiceResponse) objPost$default3;
                ResponseParser parser11111 = niceResponse11111.getParser();
                Intrinsics.checkNotNull(parser11111);
                safe6 = parser11111.parseSafe(niceResponse11111.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                map21 = (Map) safe6;
                if (map21 != null) {
                    obj16 = map21.get("pow_nonce");
                    if (obj16 != null) {
                        str66 = "";
                    } else {
                        str66 = "";
                    }
                    obj17 = map21.get("pow_difficulty");
                    if (obj17 instanceof Number) {
                        number2 = (Number) obj17;
                    } else {
                        number2 = number;
                    }
                    if (number2 != null) {
                        iIntValue = number2.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    obj18 = map21.get("pow_token");
                    if (obj18 != null) {
                        str81 = string;
                    }
                    obj19 = obj2;
                    obj20 = obj9;
                    str67 = str81;
                    str65 = str9;
                    map22 = map;
                    obj21 = obj12;
                    str68 = str59;
                    strEr$default = er$default(this, str66, iIntValue, 0.0d, 4, null);
                    if (strEr$default != null) {
                        String str81116 = str64 + str68 + str60 + '/' + str61 + "captcha/verify";
                        Pair[] pairArr13 = new Pair[3];
                        pairArr13[0] = TuplesKt.to("pow_token", str67);
                        pairArr13[r34] = TuplesKt.to("solution", strEr$default);
                        Object obj36 = map18.get(obj19);
                        Intrinsics.checkNotNull(obj36);
                        pairArr13[c] = TuplesKt.to(obj19, obj36);
                        mapMapOf3 = MapsKt.mapOf(pairArr13);
                        Requests app1116 = MainActivityKt.getApp();
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(str65);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                        c00023.L$3 = str61;
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                        c00023.L$6 = map22;
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                        c00023.L$9 = str64;
                        c00023.L$10 = str60;
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(str50);
                        c00023.L$12 = SpillingKt.nullOutSpilledVariable(map8);
                        c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                        c00023.L$14 = map18;
                        c00023.L$15 = SpillingKt.nullOutSpilledVariable(str62);
                        c00023.L$16 = SpillingKt.nullOutSpilledVariable(map17);
                        c00023.L$17 = SpillingKt.nullOutSpilledVariable(str63);
                        c00023.L$18 = SpillingKt.nullOutSpilledVariable(map21);
                        c00023.L$19 = SpillingKt.nullOutSpilledVariable(str66);
                        c00023.L$20 = SpillingKt.nullOutSpilledVariable(str67);
                        c00023.L$21 = SpillingKt.nullOutSpilledVariable(strEr$default);
                        c00023.L$22 = SpillingKt.nullOutSpilledVariable(str81116);
                        c00023.L$23 = SpillingKt.nullOutSpilledVariable(mapMapOf3);
                        c00023.I$0 = iIntValue;
                        c00023.label = 7;
                        C00021 c00021112 = c00023;
                        str69 = str60;
                        map23 = map18;
                        str70 = str61;
                        str37 = str68;
                        str71 = str64;
                        objPost$default4 = Requests.post$default(app1116, str81116, map22, (String) null, (Map) null, (Map) null, (Map) null, (List) null, mapMapOf3, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021112, 65404, (Object) null);
                        c00023 = c00021112;
                        obj8 = obj20;
                        if (objPost$default4 == obj8) {
                            return obj8;
                        }
                        map24 = mapMapOf3;
                        str72 = str70;
                        str73 = str69;
                        map25 = map23;
                        obj22 = objPost$default4;
                        map26 = map22;
                        str74 = str30;
                        str75 = str32;
                        map27 = map6;
                        detailsRoot8 = detailsRoot5;
                        detailsRoot9 = detailsRoot4;
                        str76 = str28;
                        str77 = str27;
                        str78 = str65;
                        NiceResponse niceResponse11112 = (NiceResponse) obj22;
                        ResponseParser parser11112 = niceResponse11112.getParser();
                        Intrinsics.checkNotNull(parser11112);
                        str80 = str78;
                        safe7 = parser11112.parseSafe(niceResponse11112.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                        map28 = (Map) safe7;
                        if (map28 != null) {
                            map26.put("X-Captcha-Token", string3);
                            Unit unit7 = Unit.INSTANCE;
                        }
                        str42 = str80;
                        map = map26;
                        str38 = str71;
                        map5 = map25;
                        map6 = map27;
                        str39 = str73;
                        detailsRoot5 = detailsRoot8;
                        detailsRoot4 = detailsRoot9;
                        str28 = str76;
                        str27 = str77;
                        str41 = str72;
                        str32 = str75;
                        str30 = str74;
                        map7 = map8;
                        str40 = str50;
                        String str81117 = str38 + str37 + str39 + '/' + str41 + "playback";
                        Requests app1117 = MainActivityKt.getApp();
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(str42);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(str41);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(map);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                        c00023.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(str39);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(str40);
                        c00023.L$12 = SpillingKt.nullOutSpilledVariable(map7);
                        c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                        c00023.L$14 = SpillingKt.nullOutSpilledVariable(map5);
                        c00023.L$15 = SpillingKt.nullOutSpilledVariable(str81117);
                        c00023.L$16 = null;
                        c00023.L$17 = null;
                        c00023.L$18 = null;
                        c00023.L$19 = null;
                        c00023.L$20 = null;
                        c00023.L$21 = null;
                        c00023.L$22 = null;
                        c00023.L$23 = null;
                        c00023.label = 8;
                        obj23 = obj8;
                        objPost$default5 = Requests.post$default(app1117, str81117, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, map5, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 65404, (Object) null);
                        if (objPost$default5 == obj23) {
                            return obj23;
                        }
                        obj24 = objPost$default5;
                        str79 = str42;
                        NiceResponse niceResponse11113 = (NiceResponse) obj24;
                        ResponseParser parser11113 = niceResponse11113.getParser();
                        Intrinsics.checkNotNull(parser11113);
                        return parser11113.parseSafe(niceResponse11113.getText(), Reflection.getOrCreateKotlinClass(PlaybackRoot.class));
                    }
                    str37 = str68;
                    obj8 = obj20;
                } else {
                    str65 = str9;
                    map22 = map;
                    obj8 = obj9;
                    str37 = str59;
                }
                str41 = str61;
                str39 = str60;
                str42 = str65;
                str38 = str64;
                map5 = map18;
                map = map22;
                map7 = map8;
                str40 = str50;
                String str81118 = str38 + str37 + str39 + '/' + str41 + "playback";
                Requests app1118 = MainActivityKt.getApp();
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(str42);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(str41);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(map);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(str39);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(str40);
                c00023.L$12 = SpillingKt.nullOutSpilledVariable(map7);
                c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                c00023.L$14 = SpillingKt.nullOutSpilledVariable(map5);
                c00023.L$15 = SpillingKt.nullOutSpilledVariable(str81118);
                c00023.L$16 = null;
                c00023.L$17 = null;
                c00023.L$18 = null;
                c00023.L$19 = null;
                c00023.L$20 = null;
                c00023.L$21 = null;
                c00023.L$22 = null;
                c00023.L$23 = null;
                c00023.label = 8;
                obj23 = obj8;
                objPost$default5 = Requests.post$default(app1118, str81118, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, map5, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 65404, (Object) null);
                if (objPost$default5 == obj23) {
                    return obj23;
                }
                obj24 = objPost$default5;
                str79 = str42;
                NiceResponse niceResponse11114 = (NiceResponse) obj24;
                ResponseParser parser11114 = niceResponse11114.getParser();
                Intrinsics.checkNotNull(parser11114);
                return parser11114.parseSafe(niceResponse11114.getText(), Reflection.getOrCreateKotlinClass(PlaybackRoot.class));
            case 7:
                int i = c00025.I$0;
                Map map47 = (Map) c00025.L$23;
                map25 = (Map) c00025.L$14;
                map27 = (Map) c00025.L$13;
                Map map48 = (Map) c00025.L$12;
                String str129 = (String) c00025.L$11;
                str73 = (String) c00025.L$10;
                String str130 = (String) c00025.L$9;
                detailsRoot8 = (DetailsRoot) c00025.L$8;
                detailsRoot9 = (DetailsRoot) c00025.L$7;
                Map map49 = (Map) c00025.L$6;
                str76 = (String) c00025.L$5;
                str77 = (String) c00025.L$4;
                str72 = (String) c00025.L$3;
                str75 = (String) c00025.L$2;
                str74 = (String) c00025.L$1;
                String str131 = (String) c00025.L$0;
                ResultKt.throwOnFailure(obj26);
                obj21 = "token";
                map8 = map48;
                str50 = str129;
                map26 = map49;
                obj22 = obj26;
                c00023 = c00025;
                obj8 = coroutine_suspended;
                map24 = map47;
                str37 = "/api/videos/";
                str71 = str130;
                str78 = str131;
                NiceResponse niceResponse11115 = (NiceResponse) obj22;
                ResponseParser parser11115 = niceResponse11115.getParser();
                Intrinsics.checkNotNull(parser11115);
                str80 = str78;
                safe7 = parser11115.parseSafe(niceResponse11115.getText(), Reflection.getOrCreateKotlinClass(Map.class));
                map28 = (Map) safe7;
                if (map28 != null) {
                    map26.put("X-Captcha-Token", string3);
                    Unit unit8 = Unit.INSTANCE;
                }
                str42 = str80;
                map = map26;
                str38 = str71;
                map5 = map25;
                map6 = map27;
                str39 = str73;
                detailsRoot5 = detailsRoot8;
                detailsRoot4 = detailsRoot9;
                str28 = str76;
                str27 = str77;
                str41 = str72;
                str32 = str75;
                str30 = str74;
                map7 = map8;
                str40 = str50;
                String str81119 = str38 + str37 + str39 + '/' + str41 + "playback";
                Requests app1119 = MainActivityKt.getApp();
                c00023.L$0 = SpillingKt.nullOutSpilledVariable(str42);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(str30);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(str32);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(str41);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(str27);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(str28);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(map);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(detailsRoot4);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(detailsRoot5);
                c00023.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                c00023.L$10 = SpillingKt.nullOutSpilledVariable(str39);
                c00023.L$11 = SpillingKt.nullOutSpilledVariable(str40);
                c00023.L$12 = SpillingKt.nullOutSpilledVariable(map7);
                c00023.L$13 = SpillingKt.nullOutSpilledVariable(map6);
                c00023.L$14 = SpillingKt.nullOutSpilledVariable(map5);
                c00023.L$15 = SpillingKt.nullOutSpilledVariable(str81119);
                c00023.L$16 = null;
                c00023.L$17 = null;
                c00023.L$18 = null;
                c00023.L$19 = null;
                c00023.L$20 = null;
                c00023.L$21 = null;
                c00023.L$22 = null;
                c00023.L$23 = null;
                c00023.label = 8;
                obj23 = obj8;
                objPost$default5 = Requests.post$default(app1119, str81119, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, map5, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 65404, (Object) null);
                if (objPost$default5 == obj23) {
                    return obj23;
                }
                obj24 = objPost$default5;
                str79 = str42;
                NiceResponse niceResponse11116 = (NiceResponse) obj24;
                ResponseParser parser11116 = niceResponse11116.getParser();
                Intrinsics.checkNotNull(parser11116);
                return parser11116.parseSafe(niceResponse11116.getText(), Reflection.getOrCreateKotlinClass(PlaybackRoot.class));
            case 8:
                String str132 = (String) c00025.L$0;
                ResultKt.throwOnFailure(obj26);
                obj24 = obj26;
                str79 = str132;
                NiceResponse niceResponse11117 = (NiceResponse) obj24;
                ResponseParser parser11117 = niceResponse11117.getParser();
                Intrinsics.checkNotNull(parser11117);
                return parser11117.parseSafe(niceResponse11117.getText(), Reflection.getOrCreateKotlinClass(PlaybackRoot.class));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final byte[] buildAesKey(Playback playback) {
        Integer version = playback.getVersion();
        int version2 = version != null ? version.intValue() : 0;
        Iterable $this$map$iv = version2 > 0 ? CollectionsKt.listOf(new String[]{playback.getKey_parts().get(version2 - 1), playback.getKey_parts().get(playback.getKey_parts().size() - version2)}) : playback.getKey_parts();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(b64UrlDecode(it));
        }
        Iterable $this$reduce$iv = (List) destination$iv$iv;
        Iterator iterator$iv = $this$reduce$iv.iterator();
        if (!iterator$iv.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object accumulator$iv = iterator$iv.next();
        while (iterator$iv.hasNext()) {
            byte[] bytes = (byte[]) iterator$iv.next();
            byte[] acc = (byte[]) accumulator$iv;
            accumulator$iv = ArraysKt.plus(acc, bytes);
        }
        return (byte[]) accumulator$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object decryptPlayback(Playback playback, Continuation<? super String> continuation) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String jsonStr;
        Object obj;
        Object obj2;
        String value$iv$iv;
        Object objDecodeFromString;
        PlaybackDecrypt root;
        List<PlaybackDecryptSource> sources;
        PlaybackDecryptSource playbackDecryptSource;
        byte[] keyBytes = buildAesKey(playback);
        byte[] ivBytes = b64UrlDecode(playback.getIv());
        byte[] cipherBytes = b64UrlDecode(playback.getPayload());
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(128, ivBytes);
        cipher.init(2, secretKey, gcmParameterSpec);
        byte[] plainBytes = cipher.doFinal(cipherBytes);
        String jsonStr2 = StringsKt.decodeToString(plainBytes);
        if (StringsKt.startsWith$default(jsonStr2, "\ufeff", false, 2, (Object) null)) {
            jsonStr = jsonStr2.substring(1);
            Intrinsics.checkNotNullExpressionValue(jsonStr, "substring(...)");
        } else {
            jsonStr = jsonStr2;
        }
        try {
            AppUtils appUtils = AppUtils.INSTANCE;
            String value$iv = jsonStr;
            if (value$iv == null) {
                obj2 = null;
            } else {
                try {
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(PlaybackDecrypt.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.exceptionOrNull-impl(obj) != null) {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            try {
                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PlaybackDecrypt.class), (List) null, 2, (Object) null));
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    Result.Companion companion4 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Exception e) {
                                    obj2 = null;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    DeserializationStrategy deserializationStrategy = (KSerializer) (Result.isFailure-impl(obj) ? null : obj);
                    if (deserializationStrategy == null) {
                        value$iv$iv = value$iv;
                    } else {
                        try {
                            value$iv$iv = value$iv;
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                            } catch (SerializationException e2) {
                                e$iv$iv = e2;
                                ArchComponentExtKt.logError((Throwable) e$iv$iv);
                                ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                String content$iv$iv$iv = value$iv$iv;
                                objDecodeFromString = $this$readValue$iv$iv$iv.readValue(content$iv$iv$iv, new TypeReference<PlaybackDecrypt>() { // from class: com.DoraBash.ByseSX$decryptPlayback$$inlined$tryParseJson$1
                                });
                            } catch (Throwable th4) {
                                ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                String content$iv$iv$iv2 = value$iv$iv;
                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(content$iv$iv$iv2, new TypeReference<PlaybackDecrypt>() { // from class: com.DoraBash.ByseSX$decryptPlayback$$inlined$tryParseJson$1
                                });
                            }
                        } catch (SerializationException e3) {
                            e$iv$iv = e3;
                            value$iv$iv = value$iv;
                        } catch (Throwable th5) {
                            value$iv$iv = value$iv;
                        }
                        obj2 = objDecodeFromString;
                    }
                    ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                    String content$iv$iv$iv3 = value$iv$iv;
                    objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(content$iv$iv$iv3, new TypeReference<PlaybackDecrypt>() { // from class: com.DoraBash.ByseSX$decryptPlayback$$inlined$tryParseJson$1
                    });
                    obj2 = objDecodeFromString;
                } catch (Exception e4) {
                    obj2 = null;
                    root = (PlaybackDecrypt) obj2;
                    if (root != null) {
                    }
                    return null;
                }
            }
            try {
                root = (PlaybackDecrypt) obj2;
                if (root != null || (sources = root.getSources()) == null || (playbackDecryptSource = (PlaybackDecryptSource) CollectionsKt.firstOrNull(sources)) == null) {
                    return null;
                }
                return playbackDecryptSource.getUrl();
            } catch (Exception e5) {
                return null;
            }
        } catch (Exception e6) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:34:0x0391 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x0392  */
    /* JADX WARN: Code duplicated, block: B:47:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:49:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:51:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:55:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:57:0x0402  */
    /* JADX WARN: Code duplicated, block: B:60:0x044f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:61:0x0450  */
    /* JADX WARN: Code duplicated, block: B:64:0x0465  */
    /* JADX WARN: Code duplicated, block: B:66:0x0468  */
    /* JADX WARN: Code duplicated, block: B:68:0x0470  */
    /* JADX WARN: Code duplicated, block: B:72:0x047a  */
    /* JADX WARN: Code duplicated, block: B:74:0x047e  */
    /* JADX WARN: Code duplicated, block: B:75:0x049a  */
    /* JADX WARN: Code duplicated, block: B:77:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:79:0x04f1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:82:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:84:0x0502  */
    /* JADX WARN: Code duplicated, block: B:86:0x0505  */
    /* JADX WARN: Code duplicated, block: B:89:0x05d3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:90:0x05d4  */
    static /* synthetic */ Object getUrl$suspendImpl(ByseSX $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, InvalidAlgorithmParameterException {
        C00031 c00031;
        char c;
        String str;
        List redirectDomains;
        Object obj;
        Object obj2;
        ByseSX $this2;
        Object obj3;
        String referer2;
        String code;
        Url parsedUrl;
        String finalUrl;
        String finalUrl2;
        String refererUrl;
        String url2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Object safe;
        DetailsRoot details;
        Object obj4;
        String code2;
        String refererUrl2;
        String finalUrl3;
        ByseSX $this3;
        Function1<? super ExtractorLink, Unit> function5;
        String detailsUrl;
        Object obj5;
        Function1<? super ExtractorLink, Unit> function6;
        String url3;
        String referer3;
        Function1<? super SubtitleFile, Unit> function7;
        Url parsedUrl2;
        String finalUrl4;
        String refererUrl3;
        String code3;
        List redirectDomains2;
        Object playback;
        Function1<? super ExtractorLink, Unit> function8;
        String code4;
        String refererUrl4;
        String finalUrl5;
        Function1<? super SubtitleFile, Unit> function9;
        List redirectDomains3;
        DetailsRoot details2;
        ByseSX $this4;
        String detailsUrl2;
        String finalUrl6;
        String referer4;
        Url parsedUrl3;
        String embed_frame_url;
        boolean z;
        Object safe2;
        PlaybackRoot playbackRoot;
        List<PlaybackDecryptSource> sources;
        boolean z2;
        Function1<? super ExtractorLink, Unit> function10;
        String str2;
        String finalUrl7;
        Url parsedUrl4;
        String streamUrl;
        DetailsRoot details3;
        List redirectDomains4;
        String finalUrl8;
        String finalUrl9;
        String refererUrl5;
        String code5;
        Function1<? super ExtractorLink, Unit> function11;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = $this.new C00031(continuation);
            }
        } else {
            c00031 = $this.new C00031(continuation);
        }
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                List redirectDomains5 = CollectionsKt.listOf(new String[]{"boosteradx.online", "byse.sx", "streamlyplayer.online"});
                Url parsedUrl5 = URLUtilsKt.Url(url);
                String finalUrl10 = redirectDomains5.contains(parsedUrl5.getHost()) ? StringsKt.replace$default(url, parsedUrl5.getHost(), "streamlyplayero.online", false, 4, (Object) null) : url;
                String refererUrl6 = $this.getBaseUrl(finalUrl10);
                String code6 = $this.getCodeFromUrl(finalUrl10);
                String detailsUrl3 = refererUrl6 + "/api/videos/" + code6 + "/details";
                Requests app = MainActivityKt.getApp();
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("Referer", refererUrl6 + '/'));
                c00032.L$0 = $this;
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00032.L$4 = function2;
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(redirectDomains5);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(parsedUrl5);
                c00032.L$7 = finalUrl10;
                c00032.L$8 = refererUrl6;
                c00032.L$9 = code6;
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(detailsUrl3);
                c00032.label = 1;
                String finalUrl11 = finalUrl10;
                c = 1;
                str = "/api/videos/";
                redirectDomains = redirectDomains5;
                obj = "Referer";
                obj2 = coroutine_suspended;
                Object obj6 = Requests.get$default(app, detailsUrl3, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00032, 4092, (Object) null);
                c00032 = c00032;
                if (obj6 == obj2) {
                    return obj2;
                }
                $this2 = $this;
                obj3 = obj6;
                referer2 = referer;
                code = detailsUrl3;
                parsedUrl = parsedUrl5;
                finalUrl = finalUrl11;
                finalUrl2 = refererUrl6;
                refererUrl = code6;
                url2 = url;
                function3 = function1;
                function4 = function2;
                NiceResponse this_$iv = (NiceResponse) obj3;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(DetailsRoot.class));
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                details = (DetailsRoot) safe;
                if (details == null) {
                    String detailsUrl4 = finalUrl2 + str + refererUrl + "/embed/details";
                    Requests app2 = MainActivityKt.getApp();
                    Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to(obj, finalUrl2 + '/'));
                    c00032.L$0 = $this2;
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                    c00032.L$4 = function4;
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(redirectDomains);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(parsedUrl);
                    c00032.L$7 = finalUrl;
                    c00032.L$8 = finalUrl2;
                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(refererUrl);
                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(detailsUrl4);
                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(details);
                    c00032.label = 2;
                    code2 = refererUrl;
                    refererUrl2 = finalUrl2;
                    C00031 c00033 = c00032;
                    finalUrl3 = finalUrl;
                    $this3 = $this2;
                    function5 = function4;
                    obj4 = obj;
                    detailsUrl = detailsUrl4;
                    obj5 = Requests.get$default(app2, detailsUrl, mapMapOf2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00033, 4092, (Object) null);
                    c00032 = c00033;
                    if (obj5 == obj2) {
                        return obj2;
                    }
                    function6 = function5;
                    url3 = url2;
                    referer3 = referer2;
                    function7 = function3;
                    parsedUrl2 = parsedUrl;
                    finalUrl4 = finalUrl3;
                    refererUrl3 = refererUrl2;
                    code3 = code2;
                    redirectDomains2 = redirectDomains;
                    NiceResponse this_$iv2 = (NiceResponse) obj5;
                    try {
                        ResponseParser parser2 = this_$iv2.getParser();
                        Intrinsics.checkNotNull(parser2);
                        try {
                            safe2 = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(DetailsRoot.class));
                        } catch (Exception e) {
                            e$iv = e;
                            e$iv.printStackTrace();
                            safe2 = null;
                        }
                    } catch (Exception e2) {
                        e$iv = e2;
                    }
                    details = (DetailsRoot) safe2;
                    parsedUrl = parsedUrl2;
                    redirectDomains = redirectDomains2;
                    function3 = function7;
                    referer2 = referer3;
                    url2 = url3;
                    finalUrl = finalUrl4;
                    finalUrl2 = refererUrl3;
                    refererUrl = code3;
                    code = detailsUrl;
                    function4 = function6;
                    $this2 = $this3;
                    break;
                } else {
                    obj4 = obj;
                }
                if (details != null) {
                    embed_frame_url = details.getEmbed_frame_url();
                    if (embed_frame_url != null || embed_frame_url.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        finalUrl2 = $this2.getBaseUrl(details.getEmbed_frame_url());
                    }
                }
                c00032.L$0 = $this2;
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00032.L$4 = function4;
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(redirectDomains);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(parsedUrl);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(finalUrl);
                c00032.L$8 = finalUrl2;
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(refererUrl);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(code);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(details);
                c00032.label = 3;
                playback = $this2.getPlayback(finalUrl, c00032);
                if (playback == obj2) {
                    return obj2;
                }
                function8 = function4;
                code4 = refererUrl;
                refererUrl4 = finalUrl2;
                finalUrl5 = url2;
                function9 = function3;
                redirectDomains3 = redirectDomains;
                details2 = details;
                $this4 = $this2;
                detailsUrl2 = code;
                finalUrl6 = finalUrl;
                referer4 = referer2;
                parsedUrl3 = parsedUrl;
                playbackRoot = (PlaybackRoot) playback;
                if (playbackRoot == null) {
                    return Unit.INSTANCE;
                }
                sources = playbackRoot.getSources();
                if (sources != null || sources.isEmpty()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (playbackRoot.getPlayback() != null) {
                        Playback playback2 = playbackRoot.getPlayback();
                        c00032.L$0 = $this4;
                        finalUrl7 = finalUrl6;
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(finalUrl5);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(function9);
                        c00032.L$4 = function8;
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(redirectDomains3);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(parsedUrl3);
                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(finalUrl7);
                        c00032.L$8 = refererUrl4;
                        c00032.L$9 = SpillingKt.nullOutSpilledVariable(code4);
                        c00032.L$10 = SpillingKt.nullOutSpilledVariable(detailsUrl2);
                        c00032.L$11 = SpillingKt.nullOutSpilledVariable(details2);
                        c00032.L$12 = SpillingKt.nullOutSpilledVariable(playbackRoot);
                        c00032.label = 4;
                        $result = $this4.decryptPlayback(playback2, c00032);
                        if ($result == obj2) {
                            return obj2;
                        }
                        finalUrl6 = finalUrl7;
                        Function1<? super ExtractorLink, Unit> function12 = function8;
                        str2 = (String) $result;
                        function10 = function12;
                    } else {
                        function10 = function8;
                        str2 = null;
                    }
                    if (str2 == null) {
                        return Unit.INSTANCE;
                    }
                    parsedUrl4 = parsedUrl3;
                    streamUrl = str2;
                    function8 = function10;
                    finalUrl8 = finalUrl6;
                    redirectDomains4 = redirectDomains3;
                    finalUrl9 = refererUrl4;
                    details3 = details2;
                    refererUrl5 = code4;
                    code5 = detailsUrl2;
                } else {
                    parsedUrl4 = parsedUrl3;
                    streamUrl = ((PlaybackDecryptSource) CollectionsKt.first(playbackRoot.getSources())).getUrl();
                    details3 = details2;
                    redirectDomains4 = redirectDomains3;
                    finalUrl8 = finalUrl6;
                    finalUrl9 = refererUrl4;
                    refererUrl5 = code4;
                    code5 = detailsUrl2;
                }
                Pair[] pairArr = new Pair[3];
                pairArr[0] = TuplesKt.to(obj4, finalUrl9 + '/');
                pairArr[c] = TuplesKt.to("Origin", finalUrl9);
                pairArr[2] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 10; TX6s) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Mobile Safari/537.36");
                Map headers = MapsKt.mapOf(pairArr);
                String refererUrl7 = finalUrl9;
                String refererUrl8 = $this4.getName();
                String name = $this4.getName();
                ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                ByseSX $this5 = $this4;
                C00042 c00042 = new C00042(headers, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(finalUrl5);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(function9);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(redirectDomains4);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(parsedUrl4);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(finalUrl8);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(refererUrl7);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(refererUrl5);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(code5);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(details3);
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(playbackRoot);
                c00032.L$13 = SpillingKt.nullOutSpilledVariable(streamUrl);
                c00032.L$14 = SpillingKt.nullOutSpilledVariable(headers);
                c00032.L$15 = function8;
                c00032.label = 5;
                $result = ExtractorApiKt.newExtractorLink(refererUrl8, name, streamUrl, infer_type, c00042, c00032);
                if ($result == obj2) {
                    return obj2;
                }
                function11 = function8;
                function11.invoke($result);
                return Unit.INSTANCE;
            case 1:
                String detailsUrl5 = (String) c00032.L$10;
                String code7 = (String) c00032.L$9;
                String refererUrl9 = (String) c00032.L$8;
                String finalUrl12 = (String) c00032.L$7;
                Url parsedUrl6 = (Url) c00032.L$6;
                List redirectDomains6 = (List) c00032.L$5;
                Function1<? super ExtractorLink, Unit> function13 = (Function1) c00032.L$4;
                Function1<? super SubtitleFile, Unit> function14 = (Function1) c00032.L$3;
                String referer5 = (String) c00032.L$2;
                String url4 = (String) c00032.L$1;
                ByseSX $this6 = (ByseSX) c00032.L$0;
                ResultKt.throwOnFailure($result);
                obj2 = coroutine_suspended;
                parsedUrl = parsedUrl6;
                obj = "Referer";
                redirectDomains = redirectDomains6;
                function3 = function14;
                referer2 = referer5;
                c = 1;
                $this2 = $this6;
                obj3 = $result;
                finalUrl = finalUrl12;
                str = "/api/videos/";
                refererUrl = code7;
                finalUrl2 = refererUrl9;
                function4 = function13;
                code = detailsUrl5;
                url2 = url4;
                NiceResponse this_$iv3 = (NiceResponse) obj3;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(DetailsRoot.class));
                details = (DetailsRoot) safe;
                if (details == null) {
                    String detailsUrl6 = finalUrl2 + str + refererUrl + "/embed/details";
                    Requests app3 = MainActivityKt.getApp();
                    Map mapMapOf3 = MapsKt.mapOf(TuplesKt.to(obj, finalUrl2 + '/'));
                    c00032.L$0 = $this2;
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                    c00032.L$4 = function4;
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(redirectDomains);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(parsedUrl);
                    c00032.L$7 = finalUrl;
                    c00032.L$8 = finalUrl2;
                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(refererUrl);
                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(detailsUrl6);
                    c00032.L$11 = SpillingKt.nullOutSpilledVariable(details);
                    c00032.label = 2;
                    code2 = refererUrl;
                    refererUrl2 = finalUrl2;
                    C00031 c00034 = c00032;
                    finalUrl3 = finalUrl;
                    $this3 = $this2;
                    function5 = function4;
                    obj4 = obj;
                    detailsUrl = detailsUrl6;
                    obj5 = Requests.get$default(app3, detailsUrl, mapMapOf3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00034, 4092, (Object) null);
                    c00032 = c00034;
                    if (obj5 == obj2) {
                        return obj2;
                    }
                    function6 = function5;
                    url3 = url2;
                    referer3 = referer2;
                    function7 = function3;
                    parsedUrl2 = parsedUrl;
                    finalUrl4 = finalUrl3;
                    refererUrl3 = refererUrl2;
                    code3 = code2;
                    redirectDomains2 = redirectDomains;
                    NiceResponse this_$iv4 = (NiceResponse) obj5;
                    ResponseParser parser4 = this_$iv4.getParser();
                    Intrinsics.checkNotNull(parser4);
                    safe2 = parser4.parseSafe(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(DetailsRoot.class));
                    details = (DetailsRoot) safe2;
                    parsedUrl = parsedUrl2;
                    redirectDomains = redirectDomains2;
                    function3 = function7;
                    referer2 = referer3;
                    url2 = url3;
                    finalUrl = finalUrl4;
                    finalUrl2 = refererUrl3;
                    refererUrl = code3;
                    code = detailsUrl;
                    function4 = function6;
                    $this2 = $this3;
                } else {
                    obj4 = obj;
                }
                if (details != null) {
                    embed_frame_url = details.getEmbed_frame_url();
                    if (embed_frame_url != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        finalUrl2 = $this2.getBaseUrl(details.getEmbed_frame_url());
                    }
                }
                c00032.L$0 = $this2;
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00032.L$4 = function4;
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(redirectDomains);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(parsedUrl);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(finalUrl);
                c00032.L$8 = finalUrl2;
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(refererUrl);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(code);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(details);
                c00032.label = 3;
                playback = $this2.getPlayback(finalUrl, c00032);
                if (playback == obj2) {
                    return obj2;
                }
                function8 = function4;
                code4 = refererUrl;
                refererUrl4 = finalUrl2;
                finalUrl5 = url2;
                function9 = function3;
                redirectDomains3 = redirectDomains;
                details2 = details;
                $this4 = $this2;
                detailsUrl2 = code;
                finalUrl6 = finalUrl;
                referer4 = referer2;
                parsedUrl3 = parsedUrl;
                playbackRoot = (PlaybackRoot) playback;
                if (playbackRoot == null) {
                    return Unit.INSTANCE;
                }
                sources = playbackRoot.getSources();
                if (sources != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (z2) {
                    parsedUrl4 = parsedUrl3;
                    streamUrl = ((PlaybackDecryptSource) CollectionsKt.first(playbackRoot.getSources())).getUrl();
                    details3 = details2;
                    redirectDomains4 = redirectDomains3;
                    finalUrl8 = finalUrl6;
                    finalUrl9 = refererUrl4;
                    refererUrl5 = code4;
                    code5 = detailsUrl2;
                } else {
                    if (playbackRoot.getPlayback() != null) {
                        Playback playback3 = playbackRoot.getPlayback();
                        c00032.L$0 = $this4;
                        finalUrl7 = finalUrl6;
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(finalUrl5);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(function9);
                        c00032.L$4 = function8;
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(redirectDomains3);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(parsedUrl3);
                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(finalUrl7);
                        c00032.L$8 = refererUrl4;
                        c00032.L$9 = SpillingKt.nullOutSpilledVariable(code4);
                        c00032.L$10 = SpillingKt.nullOutSpilledVariable(detailsUrl2);
                        c00032.L$11 = SpillingKt.nullOutSpilledVariable(details2);
                        c00032.L$12 = SpillingKt.nullOutSpilledVariable(playbackRoot);
                        c00032.label = 4;
                        $result = $this4.decryptPlayback(playback3, c00032);
                        if ($result == obj2) {
                            return obj2;
                        }
                        finalUrl6 = finalUrl7;
                        Function1<? super ExtractorLink, Unit> function15 = function8;
                        str2 = (String) $result;
                        function10 = function15;
                    } else {
                        function10 = function8;
                        str2 = null;
                    }
                    if (str2 == null) {
                        return Unit.INSTANCE;
                    }
                    parsedUrl4 = parsedUrl3;
                    streamUrl = str2;
                    function8 = function10;
                    finalUrl8 = finalUrl6;
                    redirectDomains4 = redirectDomains3;
                    finalUrl9 = refererUrl4;
                    details3 = details2;
                    refererUrl5 = code4;
                    code5 = detailsUrl2;
                }
                Pair[] pairArr2 = new Pair[3];
                pairArr2[0] = TuplesKt.to(obj4, finalUrl9 + '/');
                pairArr2[c] = TuplesKt.to("Origin", finalUrl9);
                pairArr2[2] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 10; TX6s) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Mobile Safari/537.36");
                Map headers2 = MapsKt.mapOf(pairArr2);
                String refererUrl10 = finalUrl9;
                String refererUrl11 = $this4.getName();
                String name2 = $this4.getName();
                ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                ByseSX $this7 = $this4;
                C00042 c00043 = new C00042(headers2, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable($this7);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(finalUrl5);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(function9);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(redirectDomains4);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(parsedUrl4);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(finalUrl8);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(refererUrl10);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(refererUrl5);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(code5);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(details3);
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(playbackRoot);
                c00032.L$13 = SpillingKt.nullOutSpilledVariable(streamUrl);
                c00032.L$14 = SpillingKt.nullOutSpilledVariable(headers2);
                c00032.L$15 = function8;
                c00032.label = 5;
                $result = ExtractorApiKt.newExtractorLink(refererUrl11, name2, streamUrl, infer_type2, c00043, c00032);
                if ($result == obj2) {
                    return obj2;
                }
                function11 = function8;
                function11.invoke($result);
                return Unit.INSTANCE;
            case 2:
                detailsUrl = (String) c00032.L$10;
                code3 = (String) c00032.L$9;
                refererUrl3 = (String) c00032.L$8;
                finalUrl4 = (String) c00032.L$7;
                parsedUrl2 = (Url) c00032.L$6;
                redirectDomains2 = (List) c00032.L$5;
                function6 = (Function1) c00032.L$4;
                function7 = (Function1) c00032.L$3;
                referer3 = (String) c00032.L$2;
                url3 = (String) c00032.L$1;
                ByseSX $this8 = (ByseSX) c00032.L$0;
                ResultKt.throwOnFailure($result);
                $this3 = $this8;
                obj2 = coroutine_suspended;
                obj4 = "Referer";
                c = 1;
                obj5 = $result;
                NiceResponse this_$iv5 = (NiceResponse) obj5;
                ResponseParser parser5 = this_$iv5.getParser();
                Intrinsics.checkNotNull(parser5);
                safe2 = parser5.parseSafe(this_$iv5.getText(), Reflection.getOrCreateKotlinClass(DetailsRoot.class));
                details = (DetailsRoot) safe2;
                parsedUrl = parsedUrl2;
                redirectDomains = redirectDomains2;
                function3 = function7;
                referer2 = referer3;
                url2 = url3;
                finalUrl = finalUrl4;
                finalUrl2 = refererUrl3;
                refererUrl = code3;
                code = detailsUrl;
                function4 = function6;
                $this2 = $this3;
                if (details != null) {
                    embed_frame_url = details.getEmbed_frame_url();
                    if (embed_frame_url != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        finalUrl2 = $this2.getBaseUrl(details.getEmbed_frame_url());
                    }
                }
                c00032.L$0 = $this2;
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00032.L$4 = function4;
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(redirectDomains);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(parsedUrl);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(finalUrl);
                c00032.L$8 = finalUrl2;
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(refererUrl);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(code);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(details);
                c00032.label = 3;
                playback = $this2.getPlayback(finalUrl, c00032);
                if (playback == obj2) {
                    return obj2;
                }
                function8 = function4;
                code4 = refererUrl;
                refererUrl4 = finalUrl2;
                finalUrl5 = url2;
                function9 = function3;
                redirectDomains3 = redirectDomains;
                details2 = details;
                $this4 = $this2;
                detailsUrl2 = code;
                finalUrl6 = finalUrl;
                referer4 = referer2;
                parsedUrl3 = parsedUrl;
                playbackRoot = (PlaybackRoot) playback;
                if (playbackRoot == null) {
                    return Unit.INSTANCE;
                }
                sources = playbackRoot.getSources();
                if (sources != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (z2) {
                    parsedUrl4 = parsedUrl3;
                    streamUrl = ((PlaybackDecryptSource) CollectionsKt.first(playbackRoot.getSources())).getUrl();
                    details3 = details2;
                    redirectDomains4 = redirectDomains3;
                    finalUrl8 = finalUrl6;
                    finalUrl9 = refererUrl4;
                    refererUrl5 = code4;
                    code5 = detailsUrl2;
                } else {
                    if (playbackRoot.getPlayback() != null) {
                        Playback playback4 = playbackRoot.getPlayback();
                        c00032.L$0 = $this4;
                        finalUrl7 = finalUrl6;
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(finalUrl5);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(function9);
                        c00032.L$4 = function8;
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(redirectDomains3);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(parsedUrl3);
                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(finalUrl7);
                        c00032.L$8 = refererUrl4;
                        c00032.L$9 = SpillingKt.nullOutSpilledVariable(code4);
                        c00032.L$10 = SpillingKt.nullOutSpilledVariable(detailsUrl2);
                        c00032.L$11 = SpillingKt.nullOutSpilledVariable(details2);
                        c00032.L$12 = SpillingKt.nullOutSpilledVariable(playbackRoot);
                        c00032.label = 4;
                        $result = $this4.decryptPlayback(playback4, c00032);
                        if ($result == obj2) {
                            return obj2;
                        }
                        finalUrl6 = finalUrl7;
                        Function1<? super ExtractorLink, Unit> function16 = function8;
                        str2 = (String) $result;
                        function10 = function16;
                    } else {
                        function10 = function8;
                        str2 = null;
                    }
                    if (str2 == null) {
                        return Unit.INSTANCE;
                    }
                    parsedUrl4 = parsedUrl3;
                    streamUrl = str2;
                    function8 = function10;
                    finalUrl8 = finalUrl6;
                    redirectDomains4 = redirectDomains3;
                    finalUrl9 = refererUrl4;
                    details3 = details2;
                    refererUrl5 = code4;
                    code5 = detailsUrl2;
                }
                Pair[] pairArr3 = new Pair[3];
                pairArr3[0] = TuplesKt.to(obj4, finalUrl9 + '/');
                pairArr3[c] = TuplesKt.to("Origin", finalUrl9);
                pairArr3[2] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 10; TX6s) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Mobile Safari/537.36");
                Map headers3 = MapsKt.mapOf(pairArr3);
                String refererUrl12 = finalUrl9;
                String refererUrl13 = $this4.getName();
                String name3 = $this4.getName();
                ExtractorLinkType infer_type3 = ExtractorApiKt.getINFER_TYPE();
                ByseSX $this9 = $this4;
                C00042 c00044 = new C00042(headers3, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable($this9);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(finalUrl5);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(function9);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(redirectDomains4);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(parsedUrl4);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(finalUrl8);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(refererUrl12);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(refererUrl5);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(code5);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(details3);
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(playbackRoot);
                c00032.L$13 = SpillingKt.nullOutSpilledVariable(streamUrl);
                c00032.L$14 = SpillingKt.nullOutSpilledVariable(headers3);
                c00032.L$15 = function8;
                c00032.label = 5;
                $result = ExtractorApiKt.newExtractorLink(refererUrl13, name3, streamUrl, infer_type3, c00044, c00032);
                if ($result == obj2) {
                    return obj2;
                }
                function11 = function8;
                function11.invoke($result);
                return Unit.INSTANCE;
            case 3:
                DetailsRoot details4 = (DetailsRoot) c00032.L$11;
                String detailsUrl7 = (String) c00032.L$10;
                String code8 = (String) c00032.L$9;
                String refererUrl14 = (String) c00032.L$8;
                String finalUrl13 = (String) c00032.L$7;
                Url parsedUrl7 = (Url) c00032.L$6;
                List redirectDomains7 = (List) c00032.L$5;
                Function1<? super ExtractorLink, Unit> function17 = (Function1) c00032.L$4;
                Function1<? super SubtitleFile, Unit> function18 = (Function1) c00032.L$3;
                String referer6 = (String) c00032.L$2;
                finalUrl5 = (String) c00032.L$1;
                $this4 = (ByseSX) c00032.L$0;
                ResultKt.throwOnFailure($result);
                code4 = code8;
                parsedUrl3 = parsedUrl7;
                referer4 = referer6;
                refererUrl4 = refererUrl14;
                redirectDomains3 = redirectDomains7;
                function8 = function17;
                function9 = function18;
                obj2 = coroutine_suspended;
                finalUrl6 = finalUrl13;
                obj4 = "Referer";
                c = 1;
                playback = $result;
                detailsUrl2 = detailsUrl7;
                details2 = details4;
                playbackRoot = (PlaybackRoot) playback;
                if (playbackRoot == null) {
                    return Unit.INSTANCE;
                }
                sources = playbackRoot.getSources();
                if (sources != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (z2) {
                    parsedUrl4 = parsedUrl3;
                    streamUrl = ((PlaybackDecryptSource) CollectionsKt.first(playbackRoot.getSources())).getUrl();
                    details3 = details2;
                    redirectDomains4 = redirectDomains3;
                    finalUrl8 = finalUrl6;
                    finalUrl9 = refererUrl4;
                    refererUrl5 = code4;
                    code5 = detailsUrl2;
                } else {
                    if (playbackRoot.getPlayback() != null) {
                        Playback playback5 = playbackRoot.getPlayback();
                        c00032.L$0 = $this4;
                        finalUrl7 = finalUrl6;
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(finalUrl5);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(function9);
                        c00032.L$4 = function8;
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(redirectDomains3);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(parsedUrl3);
                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(finalUrl7);
                        c00032.L$8 = refererUrl4;
                        c00032.L$9 = SpillingKt.nullOutSpilledVariable(code4);
                        c00032.L$10 = SpillingKt.nullOutSpilledVariable(detailsUrl2);
                        c00032.L$11 = SpillingKt.nullOutSpilledVariable(details2);
                        c00032.L$12 = SpillingKt.nullOutSpilledVariable(playbackRoot);
                        c00032.label = 4;
                        $result = $this4.decryptPlayback(playback5, c00032);
                        if ($result == obj2) {
                            return obj2;
                        }
                        finalUrl6 = finalUrl7;
                        Function1<? super ExtractorLink, Unit> function19 = function8;
                        str2 = (String) $result;
                        function10 = function19;
                    } else {
                        function10 = function8;
                        str2 = null;
                    }
                    if (str2 == null) {
                        return Unit.INSTANCE;
                    }
                    parsedUrl4 = parsedUrl3;
                    streamUrl = str2;
                    function8 = function10;
                    finalUrl8 = finalUrl6;
                    redirectDomains4 = redirectDomains3;
                    finalUrl9 = refererUrl4;
                    details3 = details2;
                    refererUrl5 = code4;
                    code5 = detailsUrl2;
                }
                Pair[] pairArr4 = new Pair[3];
                pairArr4[0] = TuplesKt.to(obj4, finalUrl9 + '/');
                pairArr4[c] = TuplesKt.to("Origin", finalUrl9);
                pairArr4[2] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 10; TX6s) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Mobile Safari/537.36");
                Map headers4 = MapsKt.mapOf(pairArr4);
                String refererUrl15 = finalUrl9;
                String refererUrl16 = $this4.getName();
                String name4 = $this4.getName();
                ExtractorLinkType infer_type4 = ExtractorApiKt.getINFER_TYPE();
                ByseSX $this10 = $this4;
                C00042 c00045 = new C00042(headers4, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable($this10);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(finalUrl5);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(function9);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(redirectDomains4);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(parsedUrl4);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(finalUrl8);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(refererUrl15);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(refererUrl5);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(code5);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(details3);
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(playbackRoot);
                c00032.L$13 = SpillingKt.nullOutSpilledVariable(streamUrl);
                c00032.L$14 = SpillingKt.nullOutSpilledVariable(headers4);
                c00032.L$15 = function8;
                c00032.label = 5;
                $result = ExtractorApiKt.newExtractorLink(refererUrl16, name4, streamUrl, infer_type4, c00045, c00032);
                if ($result == obj2) {
                    return obj2;
                }
                function11 = function8;
                function11.invoke($result);
                return Unit.INSTANCE;
            case 4:
                PlaybackRoot playbackRoot2 = (PlaybackRoot) c00032.L$12;
                details2 = (DetailsRoot) c00032.L$11;
                detailsUrl2 = (String) c00032.L$10;
                code4 = (String) c00032.L$9;
                refererUrl4 = (String) c00032.L$8;
                String finalUrl14 = (String) c00032.L$7;
                parsedUrl3 = (Url) c00032.L$6;
                redirectDomains3 = (List) c00032.L$5;
                function8 = (Function1) c00032.L$4;
                function9 = (Function1) c00032.L$3;
                referer4 = (String) c00032.L$2;
                String url5 = (String) c00032.L$1;
                $this4 = (ByseSX) c00032.L$0;
                ResultKt.throwOnFailure($result);
                obj2 = coroutine_suspended;
                obj4 = "Referer";
                finalUrl6 = finalUrl14;
                playbackRoot = playbackRoot2;
                c = 1;
                finalUrl5 = url5;
                Function1<? super ExtractorLink, Unit> function110 = function8;
                str2 = (String) $result;
                function10 = function110;
                if (str2 == null) {
                    return Unit.INSTANCE;
                }
                parsedUrl4 = parsedUrl3;
                streamUrl = str2;
                function8 = function10;
                finalUrl8 = finalUrl6;
                redirectDomains4 = redirectDomains3;
                finalUrl9 = refererUrl4;
                details3 = details2;
                refererUrl5 = code4;
                code5 = detailsUrl2;
                Pair[] pairArr5 = new Pair[3];
                pairArr5[0] = TuplesKt.to(obj4, finalUrl9 + '/');
                pairArr5[c] = TuplesKt.to("Origin", finalUrl9);
                pairArr5[2] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 10; TX6s) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Mobile Safari/537.36");
                Map headers5 = MapsKt.mapOf(pairArr5);
                String refererUrl17 = finalUrl9;
                String refererUrl18 = $this4.getName();
                String name5 = $this4.getName();
                ExtractorLinkType infer_type5 = ExtractorApiKt.getINFER_TYPE();
                ByseSX $this11 = $this4;
                C00042 c00046 = new C00042(headers5, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable($this11);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(finalUrl5);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(function9);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(redirectDomains4);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(parsedUrl4);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(finalUrl8);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(refererUrl17);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(refererUrl5);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(code5);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(details3);
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(playbackRoot);
                c00032.L$13 = SpillingKt.nullOutSpilledVariable(streamUrl);
                c00032.L$14 = SpillingKt.nullOutSpilledVariable(headers5);
                c00032.L$15 = function8;
                c00032.label = 5;
                $result = ExtractorApiKt.newExtractorLink(refererUrl18, name5, streamUrl, infer_type5, c00046, c00032);
                if ($result == obj2) {
                    return obj2;
                }
                function11 = function8;
                function11.invoke($result);
                return Unit.INSTANCE;
            case 5:
                function11 = (Function1) c00032.L$15;
                ResultKt.throwOnFailure($result);
                function11.invoke($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.DoraBash.ByseSX$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.DoraBash.ByseSX$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(Map<String, String> map, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(this.$headers, continuation);
            c00042.L$0 = obj;
            return c00042;
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
                    $this$newExtractorLink.setHeaders(this.$headers);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
