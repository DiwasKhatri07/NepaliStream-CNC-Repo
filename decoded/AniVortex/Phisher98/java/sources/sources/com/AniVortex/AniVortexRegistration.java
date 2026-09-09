package com.AniVortex;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.CloudStreamApp;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniVortexRegistration.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003PQRB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u001b\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001e\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u001cJ,\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H\u0083@b\f\b$\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010.¢\u0006\u0002\u0010#J\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050&H\u0086@¢\u0006\u0002\u0010\u001cJ\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020(2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020(H\u0002J\u0010\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u000200H\u0002J\"\u00101\u001a\u00020(2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020(2\b\b\u0002\u00105\u001a\u00020\u0013H\u0002J!\u00106\u001a\u00020(2\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020(08\"\u00020(H\u0002¢\u0006\u0002\u00109J\u0010\u0010:\u001a\u00020(2\u0006\u00104\u001a\u00020(H\u0002J\u0010\u0010;\u001a\u00020(2\u0006\u00104\u001a\u00020(H\u0002J\u0010\u0010<\u001a\u00020(2\u0006\u0010\u000e\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020(H\u0002J\u0010\u0010@\u001a\u00020(2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0019H\u0002J\u0010\u0010C\u001a\u00020(2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010D\u001a\u00020(2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010E\u001a\u00020(2\u0006\u00104\u001a\u00020(H\u0002J(\u0010I\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020=2\u0006\u0010J\u001a\u00020(2\u0006\u0010K\u001a\u0002002\u0006\u0010L\u001a\u000200H\u0002J\u0010\u0010M\u001a\u00020(2\u0006\u0010N\u001a\u00020(H\u0002J\u0010\u0010O\u001a\u00020\u00052\u0006\u0010N\u001a\u00020(H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/AniVortex/AniVortexRegistration;", "", "<init>", "()V", "TAG", "", "BASE_URL", "KEY_ALIAS_DER_CN", "REGISTER_PREFIX", "KEYSTORE_ALIAS", "regHeaders", "", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "value", "lastFailure", "getLastFailure", "()Ljava/lang/String;", "hasCredentials", "", "clearKeystoreKey", "", "getKeystorePrivateKey", "Ljava/security/PrivateKey;", "lastAttemptMs", "", "rateLimitUntilMs", "ensureRegistered", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reRegister", "resolveCredentials", "performRegistration", "Lcom/AniVortex/AniVortexRegistration$RegOutcome;", "attested", "includeDeviceProps", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/annotation/RequiresApi;", "testApiConnection", "Lkotlin/Pair;", "buildLeafCertificate", "", "privateKey", "publicKey", "Ljava/security/interfaces/ECPublicKey;", "buildTbsCertificate", "derCnName", "derLength", "len", "", "derTagged", "tag", "", "content", "primitive", "derSequence", "parts", "", "([[B)[B", "derSet", "derExplicitContextZero", "derInteger", "Ljava/math/BigInteger;", "derOid", "oidBytes", "derUtf8String", "getUtcTime", "epochMs", "derUtcTime", "derGeneralizedTime", "derBitString", "ECDSA_WITH_SHA256", "ID_EC_PUBLIC_KEY", "PRIME256V1", "toFixedLengthBytes", "out", "offset", "length", "sha256", "data", "b64UrlNoPad", "ChallengeResponse", "RegisterResponse", "RegOutcome", "AniVortex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAniVortexRegistration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniVortexRegistration.kt\ncom/AniVortex/AniVortexRegistration\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CloudStreamApp.kt\ncom/lagradost/cloudstream3/CloudStreamApp$Companion\n+ 4 DataStore.kt\ncom/lagradost/cloudstream3/utils/DataStore\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 7 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 8 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,498:1\n1#2:499\n1#2:506\n1#2:549\n1#2:576\n144#3:500\n231#4:501\n222#4,3:502\n225#4,2:524\n63#5:505\n64#5,15:507\n93#5,2:546\n63#5:548\n64#5,15:550\n95#5,2:567\n93#5,2:573\n63#5:575\n64#5,15:577\n95#5,2:594\n50#6:522\n43#6:523\n50#6:565\n43#6:566\n50#6:592\n43#6:593\n117#7,10:526\n117#7,10:536\n12746#8:569\n13093#8,3:570\n14512#8,3:596\n*S KotlinDebug\n*F\n+ 1 AniVortexRegistration.kt\ncom/AniVortex/AniVortexRegistration\n*L\n100#1:506\n204#1:549\n306#1:576\n100#1:500\n100#1:501\n100#1:502,3\n100#1:524,2\n100#1:505\n100#1:507,15\n204#1:546,2\n204#1:548\n204#1:550,15\n204#1:567,2\n306#1:573,2\n306#1:575\n306#1:577,15\n306#1:594,2\n100#1:522\n100#1:523\n204#1:565\n204#1:566\n306#1:592\n306#1:593\n129#1:526,10\n144#1:536,10\n251#1:569\n251#1:570,3\n440#1:596,3\n*E\n"})
public final class AniVortexRegistration {

    @NotNull
    private static final String BASE_URL = "https://api.anivortex.in";

    @NotNull
    private static final String KEYSTORE_ALIAS = "anivortex_cs3_v1";

    @NotNull
    private static final String KEY_ALIAS_DER_CN = "Android Keystore Key";

    @NotNull
    private static final String REGISTER_PREFIX = "ANIVORTEX-INSTALL-REGISTER-V1";

    @NotNull
    private static final String TAG = "AniVortexReg";
    private static volatile long lastAttemptMs;

    @Nullable
    private static volatile String lastFailure;
    private static volatile long rateLimitUntilMs;

    @NotNull
    public static final AniVortexRegistration INSTANCE = new AniVortexRegistration();

    @NotNull
    private static final Map<String, String> regHeaders = MapsKt.mapOf(new Pair[]{TuplesKt.to("user-agent", "Dart/3.10 (dart:io)"), TuplesKt.to("content-type", "application/json"), TuplesKt.to("accept", "application/json")});

    @NotNull
    private static final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @NotNull
    private static final byte[] ECDSA_WITH_SHA256 = {42, -122, 72, -50, 61, 4, 3, 2};

    @NotNull
    private static final byte[] ID_EC_PUBLIC_KEY = {42, -122, 72, -50, 61, 2, 1};

    @NotNull
    private static final byte[] PRIME256V1 = {42, -122, 72, -50, 61, 3, 1, 7};

    /* JADX INFO: compiled from: AniVortexRegistration.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/AniVortex/AniVortexRegistration$RegOutcome;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "RATE_LIMITED", "FAILED", "AniVortex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private enum RegOutcome {
        SUCCESS,
        RATE_LIMITED,
        FAILED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        @NotNull
        public static EnumEntries<RegOutcome> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexRegistration$ensureRegistered$1 */
    /* JADX INFO: compiled from: AniVortexRegistration.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {0, 1}, l = {503, 138}, m = "ensureRegistered", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, nl = {504, 505}, s = {"L$0", "L$0"}, v = 2)
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
            return AniVortexRegistration.this.ensureRegistered((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexRegistration$performRegistration$1 */
    /* JADX INFO: compiled from: AniVortexRegistration.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {187, 288}, m = "performRegistration", n = {"challengeBody", "attested", "includeDeviceProps", "challengeBody", "challengeResp", "challenge", "challengeId", "challengeStr", "challengeBytes", "privateKey", "chainB64", "canonical", "signer", "proofSig", "chainJson", "registerBody", "attested", "includeDeviceProps"}, nl = {192, 293}, s = {"L$0", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "Z$0", "Z$1"}, v = 2)
    static final class C00161 extends ContinuationImpl {
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
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        C00161(Continuation<? super C00161> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexRegistration.this.performRegistration(false, false, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexRegistration$reRegister$1 */
    /* JADX INFO: compiled from: AniVortexRegistration.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {0, 1}, l = {503, 148}, m = "reRegister", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, nl = {504, 505}, s = {"L$0", "L$0"}, v = 2)
    static final class C00171 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00171(Continuation<? super C00171> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexRegistration.this.reRegister((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexRegistration$resolveCredentials$1 */
    /* JADX INFO: compiled from: AniVortexRegistration.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {0, 1, 1}, l = {170, 175}, m = "resolveCredentials", n = {"now", "outcome", "now"}, nl = {173, 178}, s = {"J$0", "L$0", "J$0"}, v = 2)
    static final class C00181 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00181(Continuation<? super C00181> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexRegistration.this.resolveCredentials((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexRegistration$testApiConnection$1 */
    /* JADX INFO: compiled from: AniVortexRegistration.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {1, 1, 1, 1}, l = {342, 353}, m = "testApiConnection", n = {"query", "headers", "url", "registered"}, nl = {343, 354}, s = {"L$0", "L$1", "L$2", "Z$0"}, v = 2)
    static final class C00191 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00191(Continuation<? super C00191> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexRegistration.this.testApiConnection((Continuation) this);
        }
    }

    private AniVortexRegistration() {
    }

    @Nullable
    public final String getLastFailure() {
        return lastFailure;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AniVortexRegistration.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/AniVortex/AniVortexRegistration$ChallengeResponse;", "", "challenge_id", "", "challenge", "expires_at", "server_time", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallenge_id", "()Ljava/lang/String;", "getChallenge", "getExpires_at", "getServer_time", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "AniVortex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class ChallengeResponse {

        @Nullable
        private final String challenge;

        @Nullable
        private final String challenge_id;

        @Nullable
        private final String expires_at;

        @Nullable
        private final String server_time;

        public static /* synthetic */ ChallengeResponse copy$default(ChallengeResponse challengeResponse, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = challengeResponse.challenge_id;
            }
            if ((i & 2) != 0) {
                str2 = challengeResponse.challenge;
            }
            if ((i & 4) != 0) {
                str3 = challengeResponse.expires_at;
            }
            if ((i & 8) != 0) {
                str4 = challengeResponse.server_time;
            }
            return challengeResponse.copy(str, str2, str3, str4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getChallenge_id() {
            return this.challenge_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getChallenge() {
            return this.challenge;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getExpires_at() {
            return this.expires_at;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getServer_time() {
            return this.server_time;
        }

        @NotNull
        public final ChallengeResponse copy(@Nullable String challenge_id, @Nullable String challenge, @Nullable String expires_at, @Nullable String server_time) {
            return new ChallengeResponse(challenge_id, challenge, expires_at, server_time);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChallengeResponse)) {
                return false;
            }
            ChallengeResponse challengeResponse = (ChallengeResponse) other;
            return Intrinsics.areEqual(this.challenge_id, challengeResponse.challenge_id) && Intrinsics.areEqual(this.challenge, challengeResponse.challenge) && Intrinsics.areEqual(this.expires_at, challengeResponse.expires_at) && Intrinsics.areEqual(this.server_time, challengeResponse.server_time);
        }

        public int hashCode() {
            return ((((((this.challenge_id == null ? 0 : this.challenge_id.hashCode()) * 31) + (this.challenge == null ? 0 : this.challenge.hashCode())) * 31) + (this.expires_at == null ? 0 : this.expires_at.hashCode())) * 31) + (this.server_time != null ? this.server_time.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "ChallengeResponse(challenge_id=" + this.challenge_id + ", challenge=" + this.challenge + ", expires_at=" + this.expires_at + ", server_time=" + this.server_time + ')';
        }

        public ChallengeResponse(@Nullable String challenge_id, @Nullable String challenge, @Nullable String expires_at, @Nullable String server_time) {
            this.challenge_id = challenge_id;
            this.challenge = challenge;
            this.expires_at = expires_at;
            this.server_time = server_time;
        }

        @Nullable
        public final String getChallenge_id() {
            return this.challenge_id;
        }

        @Nullable
        public final String getChallenge() {
            return this.challenge;
        }

        @Nullable
        public final String getExpires_at() {
            return this.expires_at;
        }

        @Nullable
        public final String getServer_time() {
            return this.server_time;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AniVortexRegistration.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/AniVortex/AniVortexRegistration$RegisterResponse;", "", "installation_id", "", "key_id", "registered_at", "server_time", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInstallation_id", "()Ljava/lang/String;", "getKey_id", "getRegistered_at", "getServer_time", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "AniVortex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class RegisterResponse {

        @Nullable
        private final String installation_id;

        @Nullable
        private final String key_id;

        @Nullable
        private final String registered_at;

        @Nullable
        private final String server_time;

        public static /* synthetic */ RegisterResponse copy$default(RegisterResponse registerResponse, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = registerResponse.installation_id;
            }
            if ((i & 2) != 0) {
                str2 = registerResponse.key_id;
            }
            if ((i & 4) != 0) {
                str3 = registerResponse.registered_at;
            }
            if ((i & 8) != 0) {
                str4 = registerResponse.server_time;
            }
            return registerResponse.copy(str, str2, str3, str4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getInstallation_id() {
            return this.installation_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getKey_id() {
            return this.key_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getRegistered_at() {
            return this.registered_at;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getServer_time() {
            return this.server_time;
        }

        @NotNull
        public final RegisterResponse copy(@Nullable String installation_id, @Nullable String key_id, @Nullable String registered_at, @Nullable String server_time) {
            return new RegisterResponse(installation_id, key_id, registered_at, server_time);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RegisterResponse)) {
                return false;
            }
            RegisterResponse registerResponse = (RegisterResponse) other;
            return Intrinsics.areEqual(this.installation_id, registerResponse.installation_id) && Intrinsics.areEqual(this.key_id, registerResponse.key_id) && Intrinsics.areEqual(this.registered_at, registerResponse.registered_at) && Intrinsics.areEqual(this.server_time, registerResponse.server_time);
        }

        public int hashCode() {
            return ((((((this.installation_id == null ? 0 : this.installation_id.hashCode()) * 31) + (this.key_id == null ? 0 : this.key_id.hashCode())) * 31) + (this.registered_at == null ? 0 : this.registered_at.hashCode())) * 31) + (this.server_time != null ? this.server_time.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "RegisterResponse(installation_id=" + this.installation_id + ", key_id=" + this.key_id + ", registered_at=" + this.registered_at + ", server_time=" + this.server_time + ')';
        }

        public RegisterResponse(@Nullable String installation_id, @Nullable String key_id, @Nullable String registered_at, @Nullable String server_time) {
            this.installation_id = installation_id;
            this.key_id = key_id;
            this.registered_at = registered_at;
            this.server_time = server_time;
        }

        @Nullable
        public final String getInstallation_id() {
            return this.installation_id;
        }

        @Nullable
        public final String getKey_id() {
            return this.key_id;
        }

        @Nullable
        public final String getRegistered_at() {
            return this.registered_at;
        }

        @Nullable
        public final String getServer_time() {
            return this.server_time;
        }
    }

    public final boolean hasCredentials() {
        return AniVortexAuth.INSTANCE.hasValidCredentials();
    }

    public final void clearKeystoreKey() {
        try {
            KeyStore ks = KeyStore.getInstance("AndroidKeyStore");
            ks.load(null);
            if (ks.containsAlias(KEYSTORE_ALIAS)) {
                ks.deleteEntry(KEYSTORE_ALIAS);
            }
        } catch (Throwable e) {
            Log.w(TAG, "Failed to clear keystore key: " + e.getMessage());
        }
    }

    @Nullable
    public final PrivateKey getKeystorePrivateKey() {
        Boolean bool;
        boolean useKs;
        PrivateKey privateKey;
        Object obj;
        Object objDecodeFromString;
        Object obj2;
        String str;
        try {
            CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
            Context context = this_$iv.getContext();
            if (context != null) {
                obj = null;
                try {
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIVORTEX_USE_KEYSTORE", null);
                    if (string != null) {
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(Boolean.TYPE);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj2) != null) {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                try {
                                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Boolean.class), (List) null, 2, (Object) null));
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        Result.Companion companion4 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                    } catch (Exception e) {
                                        objDecodeFromString = null;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = null;
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) obj2;
                        if (deserializationStrategy != null) {
                            try {
                                str = string;
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str);
                                } catch (SerializationException e2) {
                                    e = e2;
                                    ArchComponentExtKt.logError((Throwable) e);
                                    objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<Boolean>() { // from class: com.AniVortex.AniVortexRegistration$getKeystorePrivateKey$$inlined$getKey$1
                                    });
                                } catch (Throwable th4) {
                                    objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<Boolean>() { // from class: com.AniVortex.AniVortexRegistration$getKeystorePrivateKey$$inlined$getKey$1
                                    });
                                }
                            } catch (SerializationException e3) {
                                e = e3;
                                str = string;
                            } catch (Throwable th5) {
                                str = string;
                            }
                            obj = objDecodeFromString;
                        } else {
                            str = string;
                        }
                        objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<Boolean>() { // from class: com.AniVortex.AniVortexRegistration$getKeystorePrivateKey$$inlined$getKey$1
                        });
                        obj = objDecodeFromString;
                    }
                } catch (Exception e4) {
                }
            } else {
                obj = null;
            }
            bool = (Boolean) obj;
        } catch (Throwable th6) {
            bool = null;
        }
        if (bool == null) {
            useKs = false;
        } else {
            try {
                useKs = bool.booleanValue();
            } catch (Throwable th7) {
                e = th7;
                privateKey = null;
                Log.e(TAG, "Failed to get keystore key: " + e.getMessage());
                return privateKey;
            }
        }
        if (!useKs) {
            return null;
        }
        KeyStore ks = KeyStore.getInstance("AndroidKeyStore");
        try {
            ks.load(null);
            if (!ks.containsAlias(KEYSTORE_ALIAS)) {
                return null;
            }
            privateKey = null;
            try {
                Key key = ks.getKey(KEYSTORE_ALIAS, null);
                if (key instanceof PrivateKey) {
                    return (PrivateKey) key;
                }
                return null;
            } catch (Throwable th8) {
                e = th8;
                Log.e(TAG, "Failed to get keystore key: " + e.getMessage());
                return privateKey;
            }
        } catch (Throwable th9) {
            e = th9;
            privateKey = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x008e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0091 A[Catch: all -> 0x00d2, TryCatch #0 {all -> 0x00d2, blocks: (B:31:0x0086, B:34:0x0091, B:37:0x009e), top: B:51:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x009c  */
    /* JADX WARN: Code duplicated, block: B:37:0x009e A[Catch: all -> 0x00d2, TRY_LEAVE, TryCatch #0 {all -> 0x00d2, blocks: (B:31:0x0086, B:34:0x0091, B:37:0x009e), top: B:51:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00bb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object ensureRegistered(@NotNull Continuation<? super Boolean> continuation) throws Throwable {
        C00131 c00131;
        AniVortexRegistration aniVortexRegistration;
        Object owner$iv;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv2;
        Mutex $this$withLock_u24default$iv2;
        Object owner$iv3;
        if (continuation instanceof C00131) {
            c00131 = (C00131) continuation;
            if ((c00131.label & Integer.MIN_VALUE) != 0) {
                c00131.label -= Integer.MIN_VALUE;
                aniVortexRegistration = this;
            } else {
                aniVortexRegistration = this;
                c00131 = aniVortexRegistration.new C00131(continuation);
            }
        } else {
            aniVortexRegistration = this;
            c00131 = aniVortexRegistration.new C00131(continuation);
        }
        C00131 c00132 = c00131;
        Object $result = c00132.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean zBooleanValue = false;
        switch (c00132.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (aniVortexRegistration.hasCredentials()) {
                    return Boxing.boxBoolean(true);
                }
                if (System.currentTimeMillis() - lastAttemptMs < 15000) {
                    return Boxing.boxBoolean(false);
                }
                Mutex $this$withLock_u24default$iv3 = mutex;
                owner$iv = null;
                c00132.L$0 = $this$withLock_u24default$iv3;
                c00132.label = 1;
                if ($this$withLock_u24default$iv3.lock((Object) null, c00132) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                try {
                    if (INSTANCE.hasCredentials()) {
                        $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                        zBooleanValue = true;
                    } else if (System.currentTimeMillis() - lastAttemptMs < 15000) {
                        $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                    } else {
                        lastAttemptMs = System.currentTimeMillis();
                        CoroutineContext coroutineContext = NonCancellable.INSTANCE;
                        AniVortexRegistration$ensureRegistered$2$1 aniVortexRegistration$ensureRegistered$2$1 = new AniVortexRegistration$ensureRegistered$2$1(null);
                        c00132.L$0 = $this$withLock_u24default$iv;
                        c00132.label = 2;
                        owner$iv3 = BuildersKt.withContext(coroutineContext, aniVortexRegistration$ensureRegistered$2$1, c00132);
                        if (owner$iv3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                        try {
                            zBooleanValue = ((Boolean) owner$iv3).booleanValue();
                        } catch (Throwable th) {
                            th = th;
                            owner$iv2 = owner$iv;
                            $this$withLock_u24default$iv2.unlock(owner$iv2);
                            throw th;
                        }
                    }
                    Boolean boolBoxBoolean = Boxing.boxBoolean(zBooleanValue);
                    $this$withLock_u24default$iv2.unlock(owner$iv);
                    return boolBoxBoolean;
                } catch (Throwable th2) {
                    th = th2;
                    owner$iv2 = owner$iv;
                    $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                    $this$withLock_u24default$iv2.unlock(owner$iv2);
                    throw th;
                }
            case 1:
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex) c00132.L$0;
                ResultKt.throwOnFailure($result);
                if (INSTANCE.hasCredentials()) {
                    $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                    zBooleanValue = true;
                } else if (System.currentTimeMillis() - lastAttemptMs < 15000) {
                    $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                } else {
                    lastAttemptMs = System.currentTimeMillis();
                    CoroutineContext coroutineContext2 = NonCancellable.INSTANCE;
                    AniVortexRegistration$ensureRegistered$2$1 aniVortexRegistration$ensureRegistered$2$2 = new AniVortexRegistration$ensureRegistered$2$1(null);
                    c00132.L$0 = $this$withLock_u24default$iv;
                    c00132.label = 2;
                    owner$iv3 = BuildersKt.withContext(coroutineContext2, aniVortexRegistration$ensureRegistered$2$2, c00132);
                    if (owner$iv3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                    zBooleanValue = ((Boolean) owner$iv3).booleanValue();
                }
                Boolean boolBoxBoolean2 = Boxing.boxBoolean(zBooleanValue);
                $this$withLock_u24default$iv2.unlock(owner$iv);
                return boolBoxBoolean2;
            case 2:
                owner$iv2 = null;
                $this$withLock_u24default$iv2 = (Mutex) c00132.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    owner$iv = null;
                    owner$iv3 = $result;
                    zBooleanValue = ((Boolean) owner$iv3).booleanValue();
                    Boolean boolBoxBoolean3 = Boxing.boxBoolean(zBooleanValue);
                    $this$withLock_u24default$iv2.unlock(owner$iv);
                    return boolBoxBoolean3;
                } catch (Throwable th3) {
                    th = th3;
                    $this$withLock_u24default$iv2.unlock(owner$iv2);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x007e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x007f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object reRegister(@NotNull Continuation<? super Boolean> continuation) throws Throwable {
        C00171 c00171;
        Object owner$iv;
        Mutex $this$withLock_u24default$iv;
        Mutex $this$withLock_u24default$iv2;
        Throwable th;
        Object objWithContext;
        if (continuation instanceof C00171) {
            c00171 = (C00171) continuation;
            if ((c00171.label & Integer.MIN_VALUE) != 0) {
                c00171.label -= Integer.MIN_VALUE;
            } else {
                c00171 = new C00171(continuation);
            }
        } else {
            c00171 = new C00171(continuation);
        }
        Object $result = c00171.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00171.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Mutex $this$withLock_u24default$iv3 = mutex;
                owner$iv = null;
                c00171.L$0 = $this$withLock_u24default$iv3;
                c00171.label = 1;
                if ($this$withLock_u24default$iv3.lock((Object) null, c00171) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                $this$withLock_u24default$iv2 = null;
                try {
                    lastAttemptMs = 0L;
                    rateLimitUntilMs = 0L;
                    AniVortexAuth.INSTANCE.markCurrentCredentialsInvalid();
                    CoroutineContext coroutineContext = NonCancellable.INSTANCE;
                    AniVortexRegistration$reRegister$2$1 aniVortexRegistration$reRegister$2$1 = new AniVortexRegistration$reRegister$2$1(null);
                    c00171.L$0 = $this$withLock_u24default$iv;
                    c00171.label = 2;
                    objWithContext = BuildersKt.withContext(coroutineContext, aniVortexRegistration$reRegister$2$1, c00171);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Boolean boolBoxBoolean = Boxing.boxBoolean(((Boolean) objWithContext).booleanValue());
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    return boolBoxBoolean;
                } catch (Throwable th2) {
                    th = th2;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    throw th;
                }
            case 1:
                $this$withLock_u24default$iv2 = null;
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex) c00171.L$0;
                ResultKt.throwOnFailure($result);
                lastAttemptMs = 0L;
                rateLimitUntilMs = 0L;
                AniVortexAuth.INSTANCE.markCurrentCredentialsInvalid();
                CoroutineContext coroutineContext2 = NonCancellable.INSTANCE;
                AniVortexRegistration$reRegister$2$1 aniVortexRegistration$reRegister$2$2 = new AniVortexRegistration$reRegister$2$1(null);
                c00171.L$0 = $this$withLock_u24default$iv;
                c00171.label = 2;
                objWithContext = BuildersKt.withContext(coroutineContext2, aniVortexRegistration$reRegister$2$2, c00171);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Boolean boolBoxBoolean2 = Boxing.boxBoolean(((Boolean) objWithContext).booleanValue());
                $this$withLock_u24default$iv.unlock(owner$iv);
                return boolBoxBoolean2;
            case 2:
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex) c00171.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objWithContext = $result;
                    Boolean boolBoxBoolean3 = Boxing.boxBoolean(((Boolean) objWithContext).booleanValue());
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    return boolBoxBoolean3;
                } catch (Throwable th3) {
                    th = th3;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x0099  */
    /* JADX WARN: Code duplicated, block: B:25:0x00af A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object resolveCredentials(Continuation<? super Boolean> continuation) {
        C00181 c00181;
        long now;
        Object objPerformRegistration;
        RegOutcome outcome;
        Object objPerformRegistration2;
        long now2;
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
                lastFailure = null;
                now = System.currentTimeMillis();
                if (now < rateLimitUntilMs) {
                    long waitSec = RangesKt.coerceAtLeast((rateLimitUntilMs - now) / 1000, 1L);
                    lastFailure = "Server rate-limited (HTTP 429: too many requests). Please wait " + waitSec + " seconds before retrying.";
                    String str = lastFailure;
                    Intrinsics.checkNotNull(str);
                    Log.w(TAG, str);
                    return Boxing.boxBoolean(false);
                }
                c00181.J$0 = now;
                c00181.label = 1;
                objPerformRegistration = performRegistration(false, false, c00181);
                if (objPerformRegistration == coroutine_suspended) {
                    return coroutine_suspended;
                }
                outcome = (RegOutcome) objPerformRegistration;
                if (outcome == RegOutcome.FAILED) {
                    Log.i(TAG, "Software key registration failed, attempting KeyStore attestation fallback...");
                    c00181.L$0 = SpillingKt.nullOutSpilledVariable(outcome);
                    c00181.J$0 = now;
                    c00181.label = 2;
                    objPerformRegistration2 = performRegistration(true, false, c00181);
                    if (objPerformRegistration2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    now2 = now;
                    outcome = (RegOutcome) objPerformRegistration2;
                }
                return Boxing.boxBoolean(outcome == RegOutcome.SUCCESS);
            case 1:
                now = c00181.J$0;
                ResultKt.throwOnFailure($result);
                objPerformRegistration = $result;
                outcome = (RegOutcome) objPerformRegistration;
                if (outcome == RegOutcome.FAILED) {
                    Log.i(TAG, "Software key registration failed, attempting KeyStore attestation fallback...");
                    c00181.L$0 = SpillingKt.nullOutSpilledVariable(outcome);
                    c00181.J$0 = now;
                    c00181.label = 2;
                    objPerformRegistration2 = performRegistration(true, false, c00181);
                    if (objPerformRegistration2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    now2 = now;
                    outcome = (RegOutcome) objPerformRegistration2;
                }
                return Boxing.boxBoolean(outcome == RegOutcome.SUCCESS);
            case 2:
                now2 = c00181.J$0;
                ResultKt.throwOnFailure($result);
                objPerformRegistration2 = $result;
                outcome = (RegOutcome) objPerformRegistration2;
                return Boxing.boxBoolean(outcome == RegOutcome.SUCCESS);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:105:0x031d  */
    /* JADX WARN: Code duplicated, block: B:118:0x0348 A[Catch: all -> 0x026d, TRY_ENTER, TryCatch #9 {all -> 0x026d, blocks: (B:53:0x021b, B:60:0x0235, B:118:0x0348, B:122:0x0351, B:127:0x035c, B:135:0x036d, B:189:0x048f, B:193:0x049f, B:198:0x04e0, B:201:0x04e6, B:74:0x02b2, B:86:0x02f0, B:89:0x02f7, B:106:0x031f, B:104:0x0316, B:85:0x02e6, B:73:0x02a8), top: B:340:0x01ae }] */
    /* JADX WARN: Code duplicated, block: B:119:0x034d  */
    /* JADX WARN: Code duplicated, block: B:122:0x0351 A[Catch: all -> 0x026d, TRY_LEAVE, TryCatch #9 {all -> 0x026d, blocks: (B:53:0x021b, B:60:0x0235, B:118:0x0348, B:122:0x0351, B:127:0x035c, B:135:0x036d, B:189:0x048f, B:193:0x049f, B:198:0x04e0, B:201:0x04e6, B:74:0x02b2, B:86:0x02f0, B:89:0x02f7, B:106:0x031f, B:104:0x0316, B:85:0x02e6, B:73:0x02a8), top: B:340:0x01ae }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0356  */
    /* JADX WARN: Code duplicated, block: B:127:0x035c A[Catch: all -> 0x026d, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x026d, blocks: (B:53:0x021b, B:60:0x0235, B:118:0x0348, B:122:0x0351, B:127:0x035c, B:135:0x036d, B:189:0x048f, B:193:0x049f, B:198:0x04e0, B:201:0x04e6, B:74:0x02b2, B:86:0x02f0, B:89:0x02f7, B:106:0x031f, B:104:0x0316, B:85:0x02e6, B:73:0x02a8), top: B:340:0x01ae }] */
    /* JADX WARN: Code duplicated, block: B:131:0x0365  */
    /* JADX WARN: Code duplicated, block: B:133:0x0368 A[Catch: all -> 0x092f, TRY_ENTER, TRY_LEAVE, TryCatch #11 {all -> 0x092f, blocks: (B:58:0x022f, B:65:0x027b, B:115:0x0343, B:125:0x0357, B:133:0x0368, B:143:0x038c, B:205:0x052b, B:196:0x04c2, B:204:0x04fd), top: B:343:0x022f }] */
    /* JADX WARN: Code duplicated, block: B:135:0x036d A[Catch: all -> 0x026d, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x026d, blocks: (B:53:0x021b, B:60:0x0235, B:118:0x0348, B:122:0x0351, B:127:0x035c, B:135:0x036d, B:189:0x048f, B:193:0x049f, B:198:0x04e0, B:201:0x04e6, B:74:0x02b2, B:86:0x02f0, B:89:0x02f7, B:106:0x031f, B:104:0x0316, B:85:0x02e6, B:73:0x02a8), top: B:340:0x01ae }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0376  */
    /* JADX WARN: Code duplicated, block: B:141:0x0379  */
    /* JADX WARN: Code duplicated, block: B:142:0x0388  */
    /* JADX WARN: Code duplicated, block: B:159:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:163:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:167:0x0426 A[Catch: all -> 0x0484, TryCatch #17 {all -> 0x0484, blocks: (B:165:0x040e, B:167:0x0426, B:176:0x0434, B:178:0x0443, B:180:0x045d, B:181:0x0479), top: B:353:0x040e }] */
    /* JADX WARN: Code duplicated, block: B:169:0x0429  */
    /* JADX WARN: Code duplicated, block: B:170:0x042b  */
    /* JADX WARN: Code duplicated, block: B:172:0x042e  */
    /* JADX WARN: Code duplicated, block: B:173:0x042f  */
    /* JADX WARN: Code duplicated, block: B:174:0x0431  */
    /* JADX WARN: Code duplicated, block: B:176:0x0434 A[Catch: all -> 0x0484, TryCatch #17 {all -> 0x0484, blocks: (B:165:0x040e, B:167:0x0426, B:176:0x0434, B:178:0x0443, B:180:0x045d, B:181:0x0479), top: B:353:0x040e }] */
    /* JADX WARN: Code duplicated, block: B:178:0x0443 A[Catch: all -> 0x0484, TryCatch #17 {all -> 0x0484, blocks: (B:165:0x040e, B:167:0x0426, B:176:0x0434, B:178:0x0443, B:180:0x045d, B:181:0x0479), top: B:353:0x040e }] */
    /* JADX WARN: Code duplicated, block: B:180:0x045d A[Catch: all -> 0x0484, LOOP:0: B:179:0x045b->B:180:0x045d, LOOP_END, TryCatch #17 {all -> 0x0484, blocks: (B:165:0x040e, B:167:0x0426, B:176:0x0434, B:178:0x0443, B:180:0x045d, B:181:0x0479), top: B:353:0x040e }] */
    /* JADX WARN: Code duplicated, block: B:191:0x049c  */
    /* JADX WARN: Code duplicated, block: B:192:0x049e  */
    /* JADX WARN: Code duplicated, block: B:195:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:198:0x04e0 A[Catch: all -> 0x026d, TRY_ENTER, TryCatch #9 {all -> 0x026d, blocks: (B:53:0x021b, B:60:0x0235, B:118:0x0348, B:122:0x0351, B:127:0x035c, B:135:0x036d, B:189:0x048f, B:193:0x049f, B:198:0x04e0, B:201:0x04e6, B:74:0x02b2, B:86:0x02f0, B:89:0x02f7, B:106:0x031f, B:104:0x0316, B:85:0x02e6, B:73:0x02a8), top: B:340:0x01ae }] */
    /* JADX WARN: Code duplicated, block: B:199:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:201:0x04e6 A[Catch: all -> 0x026d, TRY_LEAVE, TryCatch #9 {all -> 0x026d, blocks: (B:53:0x021b, B:60:0x0235, B:118:0x0348, B:122:0x0351, B:127:0x035c, B:135:0x036d, B:189:0x048f, B:193:0x049f, B:198:0x04e0, B:201:0x04e6, B:74:0x02b2, B:86:0x02f0, B:89:0x02f7, B:106:0x031f, B:104:0x0316, B:85:0x02e6, B:73:0x02a8), top: B:340:0x01ae }] */
    /* JADX WARN: Code duplicated, block: B:203:0x04fa  */
    /* JADX WARN: Code duplicated, block: B:211:0x0685 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:212:0x0686  */
    /* JADX WARN: Code duplicated, block: B:215:0x069f A[Catch: all -> 0x08eb, TryCatch #8 {all -> 0x08eb, blocks: (B:213:0x0695, B:215:0x069f, B:217:0x06a9, B:219:0x06af, B:220:0x06b3, B:222:0x06ff, B:224:0x0705, B:226:0x073b, B:272:0x0802, B:274:0x0806, B:276:0x080e, B:282:0x081a, B:284:0x0822, B:291:0x0830, B:294:0x084a, B:296:0x087d, B:300:0x08b2, B:295:0x085f, B:301:0x08c1, B:235:0x076e, B:251:0x07bb, B:254:0x07c2, B:263:0x07dd, B:262:0x07d7, B:250:0x07b1, B:234:0x0764, B:308:0x0905, B:209:0x067f), top: B:339:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:217:0x06a9 A[Catch: all -> 0x08eb, TryCatch #8 {all -> 0x08eb, blocks: (B:213:0x0695, B:215:0x069f, B:217:0x06a9, B:219:0x06af, B:220:0x06b3, B:222:0x06ff, B:224:0x0705, B:226:0x073b, B:272:0x0802, B:274:0x0806, B:276:0x080e, B:282:0x081a, B:284:0x0822, B:291:0x0830, B:294:0x084a, B:296:0x087d, B:300:0x08b2, B:295:0x085f, B:301:0x08c1, B:235:0x076e, B:251:0x07bb, B:254:0x07c2, B:263:0x07dd, B:262:0x07d7, B:250:0x07b1, B:234:0x0764, B:308:0x0905, B:209:0x067f), top: B:339:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:222:0x06ff A[Catch: all -> 0x08eb, TryCatch #8 {all -> 0x08eb, blocks: (B:213:0x0695, B:215:0x069f, B:217:0x06a9, B:219:0x06af, B:220:0x06b3, B:222:0x06ff, B:224:0x0705, B:226:0x073b, B:272:0x0802, B:274:0x0806, B:276:0x080e, B:282:0x081a, B:284:0x0822, B:291:0x0830, B:294:0x084a, B:296:0x087d, B:300:0x08b2, B:295:0x085f, B:301:0x08c1, B:235:0x076e, B:251:0x07bb, B:254:0x07c2, B:263:0x07dd, B:262:0x07d7, B:250:0x07b1, B:234:0x0764, B:308:0x0905, B:209:0x067f), top: B:339:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:224:0x0705 A[Catch: all -> 0x08eb, TryCatch #8 {all -> 0x08eb, blocks: (B:213:0x0695, B:215:0x069f, B:217:0x06a9, B:219:0x06af, B:220:0x06b3, B:222:0x06ff, B:224:0x0705, B:226:0x073b, B:272:0x0802, B:274:0x0806, B:276:0x080e, B:282:0x081a, B:284:0x0822, B:291:0x0830, B:294:0x084a, B:296:0x087d, B:300:0x08b2, B:295:0x085f, B:301:0x08c1, B:235:0x076e, B:251:0x07bb, B:254:0x07c2, B:263:0x07dd, B:262:0x07d7, B:250:0x07b1, B:234:0x0764, B:308:0x0905, B:209:0x067f), top: B:339:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:226:0x073b A[Catch: all -> 0x08eb, TRY_LEAVE, TryCatch #8 {all -> 0x08eb, blocks: (B:213:0x0695, B:215:0x069f, B:217:0x06a9, B:219:0x06af, B:220:0x06b3, B:222:0x06ff, B:224:0x0705, B:226:0x073b, B:272:0x0802, B:274:0x0806, B:276:0x080e, B:282:0x081a, B:284:0x0822, B:291:0x0830, B:294:0x084a, B:296:0x087d, B:300:0x08b2, B:295:0x085f, B:301:0x08c1, B:235:0x076e, B:251:0x07bb, B:254:0x07c2, B:263:0x07dd, B:262:0x07d7, B:250:0x07b1, B:234:0x0764, B:308:0x0905, B:209:0x067f), top: B:339:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:229:0x0746  */
    /* JADX WARN: Code duplicated, block: B:230:0x0749  */
    /* JADX WARN: Code duplicated, block: B:237:0x0774  */
    /* JADX WARN: Code duplicated, block: B:253:0x07c1  */
    /* JADX WARN: Code duplicated, block: B:263:0x07dd A[Catch: Exception -> 0x07f7, all -> 0x08eb, TRY_LEAVE, TryCatch #7 {Exception -> 0x07f7, blocks: (B:251:0x07bb, B:254:0x07c2, B:263:0x07dd, B:262:0x07d7, B:250:0x07b1), top: B:337:0x07b1 }] */
    /* JADX WARN: Code duplicated, block: B:274:0x0806 A[Catch: all -> 0x08eb, TryCatch #8 {all -> 0x08eb, blocks: (B:213:0x0695, B:215:0x069f, B:217:0x06a9, B:219:0x06af, B:220:0x06b3, B:222:0x06ff, B:224:0x0705, B:226:0x073b, B:272:0x0802, B:274:0x0806, B:276:0x080e, B:282:0x081a, B:284:0x0822, B:291:0x0830, B:294:0x084a, B:296:0x087d, B:300:0x08b2, B:295:0x085f, B:301:0x08c1, B:235:0x076e, B:251:0x07bb, B:254:0x07c2, B:263:0x07dd, B:262:0x07d7, B:250:0x07b1, B:234:0x0764, B:308:0x0905, B:209:0x067f), top: B:339:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:276:0x080e A[Catch: all -> 0x08eb, TryCatch #8 {all -> 0x08eb, blocks: (B:213:0x0695, B:215:0x069f, B:217:0x06a9, B:219:0x06af, B:220:0x06b3, B:222:0x06ff, B:224:0x0705, B:226:0x073b, B:272:0x0802, B:274:0x0806, B:276:0x080e, B:282:0x081a, B:284:0x0822, B:291:0x0830, B:294:0x084a, B:296:0x087d, B:300:0x08b2, B:295:0x085f, B:301:0x08c1, B:235:0x076e, B:251:0x07bb, B:254:0x07c2, B:263:0x07dd, B:262:0x07d7, B:250:0x07b1, B:234:0x0764, B:308:0x0905, B:209:0x067f), top: B:339:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:280:0x0817  */
    /* JADX WARN: Code duplicated, block: B:282:0x081a A[Catch: all -> 0x08eb, TryCatch #8 {all -> 0x08eb, blocks: (B:213:0x0695, B:215:0x069f, B:217:0x06a9, B:219:0x06af, B:220:0x06b3, B:222:0x06ff, B:224:0x0705, B:226:0x073b, B:272:0x0802, B:274:0x0806, B:276:0x080e, B:282:0x081a, B:284:0x0822, B:291:0x0830, B:294:0x084a, B:296:0x087d, B:300:0x08b2, B:295:0x085f, B:301:0x08c1, B:235:0x076e, B:251:0x07bb, B:254:0x07c2, B:263:0x07dd, B:262:0x07d7, B:250:0x07b1, B:234:0x0764, B:308:0x0905, B:209:0x067f), top: B:339:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:284:0x0822 A[Catch: all -> 0x08eb, TryCatch #8 {all -> 0x08eb, blocks: (B:213:0x0695, B:215:0x069f, B:217:0x06a9, B:219:0x06af, B:220:0x06b3, B:222:0x06ff, B:224:0x0705, B:226:0x073b, B:272:0x0802, B:274:0x0806, B:276:0x080e, B:282:0x081a, B:284:0x0822, B:291:0x0830, B:294:0x084a, B:296:0x087d, B:300:0x08b2, B:295:0x085f, B:301:0x08c1, B:235:0x076e, B:251:0x07bb, B:254:0x07c2, B:263:0x07dd, B:262:0x07d7, B:250:0x07b1, B:234:0x0764, B:308:0x0905, B:209:0x067f), top: B:339:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:288:0x082b  */
    /* JADX WARN: Code duplicated, block: B:290:0x082e  */
    /* JADX WARN: Code duplicated, block: B:291:0x0830 A[Catch: all -> 0x08eb, TRY_LEAVE, TryCatch #8 {all -> 0x08eb, blocks: (B:213:0x0695, B:215:0x069f, B:217:0x06a9, B:219:0x06af, B:220:0x06b3, B:222:0x06ff, B:224:0x0705, B:226:0x073b, B:272:0x0802, B:274:0x0806, B:276:0x080e, B:282:0x081a, B:284:0x0822, B:291:0x0830, B:294:0x084a, B:296:0x087d, B:300:0x08b2, B:295:0x085f, B:301:0x08c1, B:235:0x076e, B:251:0x07bb, B:254:0x07c2, B:263:0x07dd, B:262:0x07d7, B:250:0x07b1, B:234:0x0764, B:308:0x0905, B:209:0x067f), top: B:339:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:294:0x084a A[Catch: all -> 0x08eb, TRY_ENTER, TryCatch #8 {all -> 0x08eb, blocks: (B:213:0x0695, B:215:0x069f, B:217:0x06a9, B:219:0x06af, B:220:0x06b3, B:222:0x06ff, B:224:0x0705, B:226:0x073b, B:272:0x0802, B:274:0x0806, B:276:0x080e, B:282:0x081a, B:284:0x0822, B:291:0x0830, B:294:0x084a, B:296:0x087d, B:300:0x08b2, B:295:0x085f, B:301:0x08c1, B:235:0x076e, B:251:0x07bb, B:254:0x07c2, B:263:0x07dd, B:262:0x07d7, B:250:0x07b1, B:234:0x0764, B:308:0x0905, B:209:0x067f), top: B:339:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:295:0x085f A[Catch: all -> 0x08eb, TryCatch #8 {all -> 0x08eb, blocks: (B:213:0x0695, B:215:0x069f, B:217:0x06a9, B:219:0x06af, B:220:0x06b3, B:222:0x06ff, B:224:0x0705, B:226:0x073b, B:272:0x0802, B:274:0x0806, B:276:0x080e, B:282:0x081a, B:284:0x0822, B:291:0x0830, B:294:0x084a, B:296:0x087d, B:300:0x08b2, B:295:0x085f, B:301:0x08c1, B:235:0x076e, B:251:0x07bb, B:254:0x07c2, B:263:0x07dd, B:262:0x07d7, B:250:0x07b1, B:234:0x0764, B:308:0x0905, B:209:0x067f), top: B:339:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:298:0x08af  */
    /* JADX WARN: Code duplicated, block: B:299:0x08b1  */
    /* JADX WARN: Code duplicated, block: B:307:0x08f8  */
    /* JADX WARN: Code duplicated, block: B:323:0x02be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:327:0x01b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:335:0x077c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:345:0x03ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:349:0x03b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:354:0x01ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:360:0x039f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:374:0x07c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:376:0x02fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x01c0 A[Catch: all -> 0x01c5, TRY_LEAVE, TryCatch #18 {all -> 0x01c5, blocks: (B:42:0x01ba, B:44:0x01c0), top: B:354:0x01ba }] */
    /* JADX WARN: Code duplicated, block: B:57:0x022d  */
    /* JADX WARN: Code duplicated, block: B:60:0x0235 A[Catch: all -> 0x026d, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x026d, blocks: (B:53:0x021b, B:60:0x0235, B:118:0x0348, B:122:0x0351, B:127:0x035c, B:135:0x036d, B:189:0x048f, B:193:0x049f, B:198:0x04e0, B:201:0x04e6, B:74:0x02b2, B:86:0x02f0, B:89:0x02f7, B:106:0x031f, B:104:0x0316, B:85:0x02e6, B:73:0x02a8), top: B:340:0x01ae }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0277  */
    /* JADX WARN: Code duplicated, block: B:68:0x0286  */
    /* JADX WARN: Code duplicated, block: B:69:0x0289  */
    /* JADX WARN: Code duplicated, block: B:76:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    /* JADX WARN: Code duplicated, block: B:88:0x02f6  */
    @RequiresApi(23)
    public final Object performRegistration(boolean attested, boolean includeDeviceProps, Continuation<? super RegOutcome> continuation) {
        C00161 c00161;
        String str;
        Object obj;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i;
        boolean includeDeviceProps2;
        String challengeBody;
        Object obj2;
        boolean attested2;
        NiceResponse challengeResp;
        String str7;
        Long longOrNull;
        String str8;
        String str9;
        String value$iv;
        Object obj3;
        Object obj4;
        DeserializationStrategy deserializationStrategy;
        String value$iv$iv;
        Object objDecodeFromString;
        ChallengeResponse challenge;
        String challenge_id;
        String challengeId;
        String challengeStr;
        String str10;
        boolean z;
        String str11;
        boolean z2;
        byte[] challengeBytes;
        boolean z3;
        KeyStore $this$performRegistration_u24lambda_u240;
        KeyGenParameterSpec.Builder specBuilder;
        PrivateKey privateKey;
        Certificate[] chain;
        boolean z4;
        Collection destination$iv$iv;
        int length;
        int i2;
        List chainB64;
        AniVortexRegistration aniVortexRegistration;
        PrivateKey privateKey2;
        boolean z5;
        boolean z6;
        boolean attested3;
        PrivateKey privateKey3;
        String chainJson;
        String proofSig;
        PrivateKey privateKey4;
        PrivateKey privateKey5;
        PublicKey publicKey;
        ECPublicKey publicKey2;
        NiceResponse registerResp;
        String value$iv2;
        Object obj5;
        Object objDecodeFromString2;
        DeserializationStrategy deserializationStrategy2;
        RegisterResponse reg;
        String installation_id;
        boolean z7;
        String key_id;
        boolean z8;
        boolean z9;
        String str12;
        Long longOrNull2;
        String str13 = KEYSTORE_ALIAS;
        if (continuation instanceof C00161) {
            c00161 = (C00161) continuation;
            if ((c00161.label & Integer.MIN_VALUE) != 0) {
                c00161.label -= Integer.MIN_VALUE;
            } else {
                c00161 = new C00161(continuation);
            }
        } else {
            c00161 = new C00161(continuation);
        }
        C00161 c00162 = c00161;
        Object $result = c00162.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c00162.label;
        long jLongValue = 60;
        String str14 = TAG;
        try {
            try {
                switch (i3) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            Log.i(TAG, "Attempting registration flow (attested=" + (attested) + ", deviceProps=" + (includeDeviceProps) + ")...");
                            Requests app = MainActivityKt.getApp();
                            try {
                                Map<String, String> map = regHeaders;
                                RequestBody requestBodyCreate = RequestBody.Companion.create("{\"platform\":\"android\",\"package_name\":\"app.anivortex.mobile\",\"version_name\":\"5.0.1\",\"version_code\":503}", MediaType.Companion.parse("application/json; charset=utf-8"));
                                c00162.L$0 = SpillingKt.nullOutSpilledVariable("{\"platform\":\"android\",\"package_name\":\"app.anivortex.mobile\",\"version_name\":\"5.0.1\",\"version_code\":503}");
                                c00162.Z$0 = attested;
                                c00162.Z$1 = includeDeviceProps;
                                c00162.label = 1;
                                str14 = null;
                                str = "retry-after";
                                obj = coroutine_suspended;
                                str2 = "): ";
                                str3 = " (headers: ";
                                str4 = " seconds.";
                                str5 = TAG;
                                str6 = "application/json; charset=utf-8";
                                i = 429;
                                try {
                                    Object objPost$default = Requests.post$default(app, "https://api.anivortex.in/api/v1/install/challenge", map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00162, 65276, (Object) null);
                                    c00162 = c00162;
                                    if (objPost$default == obj) {
                                        return obj;
                                    }
                                    includeDeviceProps2 = includeDeviceProps;
                                    challengeBody = "{\"platform\":\"android\",\"package_name\":\"app.anivortex.mobile\",\"version_name\":\"5.0.1\",\"version_code\":503}";
                                    obj2 = objPost$default;
                                    attested2 = attested;
                                    try {
                                        challengeResp = (NiceResponse) obj2;
                                        try {
                                            if (challengeResp.getCode() == i) {
                                                try {
                                                    str7 = challengeResp.getHeaders().get(str);
                                                    if (str7 != null) {
                                                        try {
                                                            longOrNull = StringsKt.toLongOrNull(str7);
                                                            if (longOrNull != null) {
                                                                jLongValue = longOrNull.longValue();
                                                            }
                                                        } catch (Throwable th) {
                                                            e = th;
                                                            str13 = str5;
                                                        }
                                                        break;
                                                    }
                                                    long retryAfterSec = jLongValue;
                                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                                    Long.signum(retryAfterSec);
                                                    rateLimitUntilMs = jCurrentTimeMillis + (1000 * retryAfterSec);
                                                    lastFailure = "Challenge rate-limited (HTTP 429: too many requests). Server throttled your IP. Please wait " + retryAfterSec + str4;
                                                    Log.w(str5, lastFailure + str3 + challengeResp.getHeaders() + ')');
                                                    return RegOutcome.RATE_LIMITED;
                                                } catch (Throwable th2) {
                                                    e = th2;
                                                    str13 = str5;
                                                }
                                            } else {
                                                str8 = str5;
                                                try {
                                                    if (!challengeResp.isSuccessful()) {
                                                        lastFailure = "Challenge failed (HTTP " + challengeResp.getCode() + str2 + StringsKt.take(challengeResp.getText(), 120);
                                                        String str15 = lastFailure;
                                                        Intrinsics.checkNotNull(str15);
                                                        Log.w(str8, str15);
                                                        return RegOutcome.FAILED;
                                                    }
                                                    str9 = str2;
                                                    AppUtils appUtils = AppUtils.INSTANCE;
                                                    value$iv = challengeResp.getText();
                                                    if (value$iv != null) {
                                                        try {
                                                            Result.Companion companion = Result.Companion;
                                                            KType kTypeTypeOf = Reflection.typeOf(ChallengeResponse.class);
                                                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                            obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                                            break;
                                                        } catch (Throwable th3) {
                                                            try {
                                                                Result.Companion companion2 = Result.Companion;
                                                                obj3 = Result.constructor-impl(ResultKt.createFailure(th3));
                                                            } catch (Exception e) {
                                                                obj4 = null;
                                                                challenge = (ChallengeResponse) obj4;
                                                                if (challenge != null) {
                                                                    challenge_id = challenge.getChallenge_id();
                                                                } else {
                                                                    challenge_id = null;
                                                                }
                                                                challengeId = challenge_id;
                                                                if (challenge != null) {
                                                                    challengeStr = challenge.getChallenge();
                                                                } else {
                                                                    challengeStr = null;
                                                                }
                                                                str10 = challengeId;
                                                                if (str10 != null) {
                                                                    z = true;
                                                                } else {
                                                                    z = true;
                                                                }
                                                                if (!z) {
                                                                    str11 = challengeStr;
                                                                    if (str11 != null) {
                                                                        z2 = true;
                                                                    } else {
                                                                        z2 = true;
                                                                    }
                                                                    if (!z2) {
                                                                        challengeBytes = Base64.decode(challengeStr, 11);
                                                                        String challengeStr2 = challengeStr;
                                                                        if (attested2) {
                                                                            try {
                                                                                $this$performRegistration_u24lambda_u240 = KeyStore.getInstance(r5);
                                                                                $this$performRegistration_u24lambda_u240.load(null);
                                                                                if ($this$performRegistration_u24lambda_u240.containsAlias(KEYSTORE_ALIAS)) {
                                                                                    try {
                                                                                        $this$performRegistration_u24lambda_u240.deleteEntry(KEYSTORE_ALIAS);
                                                                                        break;
                                                                                    } catch (Throwable th4) {
                                                                                    }
                                                                                }
                                                                                KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
                                                                                specBuilder = new KeyGenParameterSpec.Builder(KEYSTORE_ALIAS, 4).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests("SHA-256").setUserAuthenticationRequired(false).setAttestationChallenge(challengeBytes);
                                                                                if (includeDeviceProps2) {
                                                                                    try {
                                                                                        if (Build.VERSION.SDK_INT >= 31) {
                                                                                            specBuilder.setDevicePropertiesAttestationIncluded(true);
                                                                                        }
                                                                                    } catch (Throwable th5) {
                                                                                        e = th5;
                                                                                        StringBuilder sbAppend = new StringBuilder().append("Attested keygen failed (deviceProps=");
                                                                                        if (includeDeviceProps2) {
                                                                                            z3 = true;
                                                                                        } else {
                                                                                            z3 = false;
                                                                                        }
                                                                                        lastFailure = sbAppend.append(z3).append(str9).append(e.getMessage()).toString();
                                                                                        String str16 = lastFailure;
                                                                                        Intrinsics.checkNotNull(str16);
                                                                                        Log.w(str8, str16);
                                                                                        return RegOutcome.FAILED;
                                                                                    }
                                                                                }
                                                                                kpg.initialize(specBuilder.build());
                                                                                privateKey = kpg.generateKeyPair().getPrivate();
                                                                                try {
                                                                                    KeyStore $this$performRegistration_u24lambda_u241 = KeyStore.getInstance("AndroidKeyStore");
                                                                                    $this$performRegistration_u24lambda_u241.load(null);
                                                                                    chain = $this$performRegistration_u24lambda_u241.getCertificateChain(KEYSTORE_ALIAS);
                                                                                    if (chain == null) {
                                                                                        z4 = true;
                                                                                    } else {
                                                                                        if (chain.length == 0) {
                                                                                            z5 = true;
                                                                                        } else {
                                                                                            z5 = false;
                                                                                        }
                                                                                        if (z5) {
                                                                                            z4 = true;
                                                                                        } else {
                                                                                            z4 = false;
                                                                                        }
                                                                                    }
                                                                                    if (z4) {
                                                                                        lastFailure = "AndroidKeyStore returned no attestation chain";
                                                                                        String str17 = lastFailure;
                                                                                        Intrinsics.checkNotNull(str17);
                                                                                        Log.w(str8, str17);
                                                                                        return RegOutcome.FAILED;
                                                                                    }
                                                                                    destination$iv$iv = new ArrayList(chain.length);
                                                                                    i2 = 0;
                                                                                    for (length = chain.length; i2 < length; length = length) {
                                                                                        destination$iv$iv.add(Base64.encodeToString(chain[i2].getEncoded(), 2));
                                                                                        i2++;
                                                                                    }
                                                                                    chainB64 = (List) destination$iv$iv;
                                                                                    aniVortexRegistration = this;
                                                                                    privateKey2 = privateKey;
                                                                                } catch (Throwable th6) {
                                                                                    e = th6;
                                                                                    StringBuilder sbAppend2 = new StringBuilder().append("Attested keygen failed (deviceProps=");
                                                                                    if (includeDeviceProps2) {
                                                                                        z3 = true;
                                                                                    } else {
                                                                                        z3 = false;
                                                                                    }
                                                                                    lastFailure = sbAppend2.append(z3).append(str9).append(e.getMessage()).toString();
                                                                                    String str18 = lastFailure;
                                                                                    Intrinsics.checkNotNull(str18);
                                                                                    Log.w(str8, str18);
                                                                                    return RegOutcome.FAILED;
                                                                                }
                                                                            } catch (Throwable th7) {
                                                                                e = th7;
                                                                            }
                                                                        } else {
                                                                            KeyPairGenerator kpg2 = KeyPairGenerator.getInstance("EC");
                                                                            kpg2.initialize(new ECGenParameterSpec("secp256r1"));
                                                                            KeyPair keyPair = kpg2.generateKeyPair();
                                                                            privateKey5 = keyPair.getPrivate();
                                                                            publicKey = keyPair.getPublic();
                                                                            if (publicKey instanceof ECPublicKey) {
                                                                                publicKey2 = (ECPublicKey) publicKey;
                                                                            } else {
                                                                                publicKey2 = null;
                                                                            }
                                                                            if (publicKey2 == null) {
                                                                                AniVortexRegistration aniVortexRegistration2 = this;
                                                                                lastFailure = "Generated software key is not EC";
                                                                                String str19 = lastFailure;
                                                                                Intrinsics.checkNotNull(str19);
                                                                                Log.w(str8, str19);
                                                                                return RegOutcome.FAILED;
                                                                            }
                                                                            aniVortexRegistration = this;
                                                                            byte[] leafDer = aniVortexRegistration.buildLeafCertificate(privateKey5, publicKey2);
                                                                            CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(leafDer));
                                                                            String leafB64 = Base64.encodeToString(leafDer, 2);
                                                                            List chainB65 = CollectionsKt.listOf(new String[]{leafB64, leafB64});
                                                                            chainB64 = chainB65;
                                                                            privateKey2 = privateKey5;
                                                                        }
                                                                        String canonical = "ANIVORTEX-INSTALL-REGISTER-V1\n" + challengeId + '\n' + aniVortexRegistration.b64UrlNoPad(aniVortexRegistration.sha256(challengeBytes));
                                                                        Signature signer = Signature.getInstance("SHA256withECDSA");
                                                                        signer.initSign(privateKey2);
                                                                        List chainB66 = chainB64;
                                                                        byte[] bytes = canonical.getBytes(Charsets.UTF_8);
                                                                        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                                                                        signer.update(bytes);
                                                                        String proofSig2 = aniVortexRegistration.b64UrlNoPad(signer.sign());
                                                                        String chainJson2 = CollectionsKt.joinToString$default(chainB66, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.AniVortex.AniVortexRegistration$$ExternalSyntheticLambda0
                                                                            public final Object invoke(Object obj6) {
                                                                                return AniVortexRegistration.performRegistration$lambda$4((String) obj6);
                                                                            }
                                                                        }, 30, (Object) null);
                                                                        try {
                                                                            String registerBody = "{\"challenge_id\":\"" + challengeId + "\",\"certificate_chain\":[" + chainJson2 + "],\"proof_signature\":\"" + proofSig2 + "\"}";
                                                                            Requests app2 = MainActivityKt.getApp();
                                                                            Map<String, String> map2 = regHeaders;
                                                                            RequestBody requestBodyCreate2 = RequestBody.Companion.create(registerBody, MediaType.Companion.parse(str6));
                                                                            c00162.L$0 = SpillingKt.nullOutSpilledVariable(challengeBody);
                                                                            c00162.L$1 = SpillingKt.nullOutSpilledVariable(challengeResp);
                                                                            c00162.L$2 = SpillingKt.nullOutSpilledVariable(challenge);
                                                                            c00162.L$3 = SpillingKt.nullOutSpilledVariable(challengeId);
                                                                            c00162.L$4 = SpillingKt.nullOutSpilledVariable(challengeStr2);
                                                                            c00162.L$5 = SpillingKt.nullOutSpilledVariable(challengeBytes);
                                                                            c00162.L$6 = privateKey2;
                                                                            c00162.L$7 = SpillingKt.nullOutSpilledVariable(chainB66);
                                                                            c00162.L$8 = SpillingKt.nullOutSpilledVariable(canonical);
                                                                            c00162.L$9 = SpillingKt.nullOutSpilledVariable(signer);
                                                                            c00162.L$10 = SpillingKt.nullOutSpilledVariable(proofSig2);
                                                                            c00162.L$11 = SpillingKt.nullOutSpilledVariable(chainJson2);
                                                                            c00162.L$12 = SpillingKt.nullOutSpilledVariable(registerBody);
                                                                            c00162.Z$0 = attested2;
                                                                            c00162.Z$1 = includeDeviceProps2;
                                                                            c00162.label = 2;
                                                                            z6 = true;
                                                                            attested3 = attested2;
                                                                            privateKey3 = privateKey2;
                                                                            chainJson = str9;
                                                                            proofSig = str8;
                                                                            $result = Requests.post$default(app2, "https://api.anivortex.in/api/v1/install/register", map2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00162, 65276, (Object) null);
                                                                            if ($result == obj) {
                                                                                return obj;
                                                                            }
                                                                            privateKey4 = privateKey3;
                                                                            registerResp = (NiceResponse) $result;
                                                                            if (registerResp.getCode() == 429) {
                                                                                str12 = registerResp.getHeaders().get(str);
                                                                                if (str12 != null) {
                                                                                    jLongValue = longOrNull2.longValue();
                                                                                }
                                                                                long retryAfterSec2 = jLongValue;
                                                                                rateLimitUntilMs = System.currentTimeMillis() + (1000 * retryAfterSec2);
                                                                                lastFailure = "Registration rate-limited (HTTP 429: too many requests). Server throttled your IP. Please wait " + retryAfterSec2 + str4;
                                                                                Log.w(proofSig, lastFailure + str3 + registerResp.getHeaders() + ')');
                                                                                return RegOutcome.RATE_LIMITED;
                                                                            }
                                                                            if (!registerResp.isSuccessful()) {
                                                                                lastFailure = "Register rejected (HTTP " + registerResp.getCode() + chainJson + StringsKt.take(registerResp.getText(), 120);
                                                                                String str20 = lastFailure;
                                                                                Intrinsics.checkNotNull(str20);
                                                                                Log.w(proofSig, str20);
                                                                                return RegOutcome.FAILED;
                                                                            }
                                                                            AppUtils appUtils2 = AppUtils.INSTANCE;
                                                                            value$iv2 = registerResp.getText();
                                                                            if (value$iv2 == null) {
                                                                                try {
                                                                                    Result.Companion companion3 = Result.Companion;
                                                                                    KType kTypeTypeOf2 = Reflection.typeOf(RegisterResponse.class);
                                                                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                                                    obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                                                                    break;
                                                                                } catch (Throwable th8) {
                                                                                    try {
                                                                                        Result.Companion companion4 = Result.Companion;
                                                                                        obj5 = Result.constructor-impl(ResultKt.createFailure(th8));
                                                                                    } catch (Exception e2) {
                                                                                        objDecodeFromString2 = null;
                                                                                        reg = (RegisterResponse) objDecodeFromString2;
                                                                                        if (reg != null) {
                                                                                            installation_id = reg.getInstallation_id();
                                                                                            if (installation_id != null) {
                                                                                                z7 = true;
                                                                                            } else {
                                                                                                z7 = true;
                                                                                            }
                                                                                            if (!z7) {
                                                                                                key_id = reg.getKey_id();
                                                                                                if (key_id != null) {
                                                                                                    z8 = true;
                                                                                                } else {
                                                                                                    z8 = true;
                                                                                                }
                                                                                                if (!z8) {
                                                                                                    CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", reg.getInstallation_id());
                                                                                                    CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", reg.getKey_id());
                                                                                                    if (attested3) {
                                                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z6));
                                                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", "");
                                                                                                    } else {
                                                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(false));
                                                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey4.getEncoded(), 2));
                                                                                                        clearKeystoreKey();
                                                                                                    }
                                                                                                    AniVortexAuth.INSTANCE.invalidateCache();
                                                                                                    lastFailure = null;
                                                                                                    StringBuilder sbAppend3 = new StringBuilder().append("Registration complete! installation_id=").append(reg.getInstallation_id()).append(" key_id=").append(reg.getKey_id()).append(" attested=");
                                                                                                    if (attested3) {
                                                                                                        z9 = true;
                                                                                                    } else {
                                                                                                        z9 = false;
                                                                                                    }
                                                                                                    Log.i(proofSig, sbAppend3.append(z9).toString());
                                                                                                    return RegOutcome.SUCCESS;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        lastFailure = "Register response missing fields: " + StringsKt.take(registerResp.getText(), 120);
                                                                                        String str21 = lastFailure;
                                                                                        Intrinsics.checkNotNull(str21);
                                                                                        Log.w(proofSig, str21);
                                                                                        return RegOutcome.FAILED;
                                                                                    }
                                                                                }
                                                                                if (Result.exceptionOrNull-impl(obj5) == null) {
                                                                                    try {
                                                                                        Result.Companion companion5 = Result.Companion;
                                                                                        try {
                                                                                            try {
                                                                                                obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(RegisterResponse.class), (List) null, 2, (Object) null));
                                                                                                break;
                                                                                            } catch (Throwable th9) {
                                                                                                th = th9;
                                                                                                try {
                                                                                                    Result.Companion companion6 = Result.Companion;
                                                                                                    obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                                                } catch (Exception e3) {
                                                                                                    objDecodeFromString2 = null;
                                                                                                }
                                                                                            }
                                                                                        } catch (Throwable th10) {
                                                                                            th = th10;
                                                                                        }
                                                                                    } catch (Throwable th11) {
                                                                                        th = th11;
                                                                                    }
                                                                                }
                                                                                if (Result.isFailure-impl(obj5)) {
                                                                                    obj5 = null;
                                                                                }
                                                                                deserializationStrategy2 = (KSerializer) obj5;
                                                                                if (deserializationStrategy2 != null) {
                                                                                    try {
                                                                                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                                                                    } catch (SerializationException e4) {
                                                                                        ArchComponentExtKt.logError(e4);
                                                                                        ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                                                                        objDecodeFromString2 = $this$readValue$iv$iv$iv.readValue(value$iv2, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                                                                                        });
                                                                                    } catch (Throwable th12) {
                                                                                        ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                                                                        objDecodeFromString2 = $this$readValue$iv$iv$iv2.readValue(value$iv2, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                                                                                        });
                                                                                    }
                                                                                } else {
                                                                                    ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                                                                    objDecodeFromString2 = $this$readValue$iv$iv$iv3.readValue(value$iv2, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                                                                                    });
                                                                                }
                                                                                break;
                                                                            } else {
                                                                                objDecodeFromString2 = null;
                                                                            }
                                                                            reg = (RegisterResponse) objDecodeFromString2;
                                                                            if (reg != null) {
                                                                                installation_id = reg.getInstallation_id();
                                                                                if (installation_id != null) {
                                                                                    z7 = true;
                                                                                } else {
                                                                                    z7 = true;
                                                                                }
                                                                                if (!z7) {
                                                                                    key_id = reg.getKey_id();
                                                                                    if (key_id != null) {
                                                                                        z8 = true;
                                                                                    } else {
                                                                                        z8 = true;
                                                                                    }
                                                                                    if (!z8) {
                                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", reg.getInstallation_id());
                                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", reg.getKey_id());
                                                                                        if (attested3) {
                                                                                            CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z6));
                                                                                            CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", "");
                                                                                        } else {
                                                                                            CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(false));
                                                                                            CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey4.getEncoded(), 2));
                                                                                            clearKeystoreKey();
                                                                                        }
                                                                                        AniVortexAuth.INSTANCE.invalidateCache();
                                                                                        lastFailure = null;
                                                                                        StringBuilder sbAppend4 = new StringBuilder().append("Registration complete! installation_id=").append(reg.getInstallation_id()).append(" key_id=").append(reg.getKey_id()).append(" attested=");
                                                                                        if (attested3) {
                                                                                            z9 = true;
                                                                                        } else {
                                                                                            z9 = false;
                                                                                        }
                                                                                        Log.i(proofSig, sbAppend4.append(z9).toString());
                                                                                        return RegOutcome.SUCCESS;
                                                                                    }
                                                                                }
                                                                            }
                                                                            lastFailure = "Register response missing fields: " + StringsKt.take(registerResp.getText(), 120);
                                                                            String str22 = lastFailure;
                                                                            Intrinsics.checkNotNull(str22);
                                                                            Log.w(proofSig, str22);
                                                                            return RegOutcome.FAILED;
                                                                        } catch (Throwable th13) {
                                                                            e = th13;
                                                                            str13 = str8;
                                                                        }
                                                                    }
                                                                    lastFailure = "Registration error: " + e.getMessage();
                                                                    String str23 = lastFailure;
                                                                    Intrinsics.checkNotNull(str23);
                                                                    Log.w(str13, str23);
                                                                    Log.d(str13, "Registration failed stacktrace", e);
                                                                    return RegOutcome.FAILED;
                                                                }
                                                                lastFailure = "Invalid challenge response: " + StringsKt.take(challengeResp.getText(), 120);
                                                                String str24 = lastFailure;
                                                                Intrinsics.checkNotNull(str24);
                                                                Log.w(str8, str24);
                                                                return RegOutcome.FAILED;
                                                            }
                                                        }
                                                        if (Result.exceptionOrNull-impl(obj3) == null) {
                                                            try {
                                                                Result.Companion companion7 = Result.Companion;
                                                                try {
                                                                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ChallengeResponse.class), (List) null, 2, (Object) null));
                                                                    break;
                                                                } catch (Throwable th14) {
                                                                    th = th14;
                                                                    try {
                                                                        Result.Companion companion8 = Result.Companion;
                                                                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                    } catch (Exception e5) {
                                                                        obj4 = null;
                                                                    }
                                                                }
                                                            } catch (Throwable th15) {
                                                                th = th15;
                                                            }
                                                        }
                                                        if (Result.isFailure-impl(obj3)) {
                                                            obj3 = null;
                                                        }
                                                        deserializationStrategy = (KSerializer) obj3;
                                                        if (deserializationStrategy != null) {
                                                            try {
                                                                value$iv$iv = value$iv;
                                                                try {
                                                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                                                                } catch (SerializationException e6) {
                                                                    e$iv$iv = e6;
                                                                    ArchComponentExtKt.logError((Throwable) e$iv$iv);
                                                                    ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                                                                    String content$iv$iv$iv = value$iv$iv;
                                                                    objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(content$iv$iv$iv, new TypeReference<ChallengeResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$1
                                                                    });
                                                                } catch (Throwable th16) {
                                                                    ObjectMapper $this$readValue$iv$iv$iv5 = MainAPIKt.getMapper();
                                                                    String content$iv$iv$iv2 = value$iv$iv;
                                                                    objDecodeFromString = $this$readValue$iv$iv$iv5.readValue(content$iv$iv$iv2, new TypeReference<ChallengeResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$1
                                                                    });
                                                                }
                                                            } catch (SerializationException e7) {
                                                                e$iv$iv = e7;
                                                                value$iv$iv = value$iv;
                                                            } catch (Throwable th17) {
                                                                value$iv$iv = value$iv;
                                                            }
                                                            obj4 = objDecodeFromString;
                                                        } else {
                                                            value$iv$iv = value$iv;
                                                        }
                                                        ObjectMapper $this$readValue$iv$iv$iv6 = MainAPIKt.getMapper();
                                                        String content$iv$iv$iv3 = value$iv$iv;
                                                        objDecodeFromString = $this$readValue$iv$iv$iv6.readValue(content$iv$iv$iv3, new TypeReference<ChallengeResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$1
                                                        });
                                                        obj4 = objDecodeFromString;
                                                        break;
                                                    } else {
                                                        obj4 = null;
                                                    }
                                                    challenge = (ChallengeResponse) obj4;
                                                    if (challenge != null) {
                                                        challenge_id = challenge.getChallenge_id();
                                                    } else {
                                                        challenge_id = null;
                                                    }
                                                    challengeId = challenge_id;
                                                    if (challenge != null) {
                                                        challengeStr = challenge.getChallenge();
                                                    } else {
                                                        challengeStr = null;
                                                    }
                                                    str10 = challengeId;
                                                    if (str10 != null || str10.length() == 0) {
                                                        z = true;
                                                    } else {
                                                        z = false;
                                                    }
                                                    if (!z) {
                                                        str11 = challengeStr;
                                                        if (str11 != null || str11.length() == 0) {
                                                            z2 = true;
                                                        } else {
                                                            z2 = false;
                                                        }
                                                        if (!z2) {
                                                            challengeBytes = Base64.decode(challengeStr, 11);
                                                            String challengeStr3 = challengeStr;
                                                            if (attested2) {
                                                                $this$performRegistration_u24lambda_u240 = KeyStore.getInstance(r5);
                                                                $this$performRegistration_u24lambda_u240.load(null);
                                                                if ($this$performRegistration_u24lambda_u240.containsAlias(KEYSTORE_ALIAS)) {
                                                                    $this$performRegistration_u24lambda_u240.deleteEntry(KEYSTORE_ALIAS);
                                                                }
                                                                KeyPairGenerator kpg3 = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
                                                                specBuilder = new KeyGenParameterSpec.Builder(KEYSTORE_ALIAS, 4).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests("SHA-256").setUserAuthenticationRequired(false).setAttestationChallenge(challengeBytes);
                                                                if (includeDeviceProps2) {
                                                                    if (Build.VERSION.SDK_INT >= 31) {
                                                                        specBuilder.setDevicePropertiesAttestationIncluded(true);
                                                                    }
                                                                }
                                                                kpg3.initialize(specBuilder.build());
                                                                privateKey = kpg3.generateKeyPair().getPrivate();
                                                                KeyStore $this$performRegistration_u24lambda_u242 = KeyStore.getInstance("AndroidKeyStore");
                                                                $this$performRegistration_u24lambda_u242.load(null);
                                                                chain = $this$performRegistration_u24lambda_u242.getCertificateChain(KEYSTORE_ALIAS);
                                                                if (chain == null) {
                                                                    z4 = true;
                                                                } else {
                                                                    if (chain.length == 0) {
                                                                        z5 = true;
                                                                    } else {
                                                                        z5 = false;
                                                                    }
                                                                    if (z5) {
                                                                        z4 = true;
                                                                    } else {
                                                                        z4 = false;
                                                                    }
                                                                }
                                                                if (z4) {
                                                                    lastFailure = "AndroidKeyStore returned no attestation chain";
                                                                    String str110 = lastFailure;
                                                                    Intrinsics.checkNotNull(str110);
                                                                    Log.w(str8, str110);
                                                                    return RegOutcome.FAILED;
                                                                }
                                                                destination$iv$iv = new ArrayList(chain.length);
                                                                i2 = 0;
                                                                while (i2 < length) {
                                                                    destination$iv$iv.add(Base64.encodeToString(chain[i2].getEncoded(), 2));
                                                                    i2++;
                                                                }
                                                                chainB64 = (List) destination$iv$iv;
                                                                aniVortexRegistration = this;
                                                                privateKey2 = privateKey;
                                                                break;
                                                            } else {
                                                                KeyPairGenerator kpg4 = KeyPairGenerator.getInstance("EC");
                                                                kpg4.initialize(new ECGenParameterSpec("secp256r1"));
                                                                KeyPair keyPair2 = kpg4.generateKeyPair();
                                                                privateKey5 = keyPair2.getPrivate();
                                                                publicKey = keyPair2.getPublic();
                                                                if (publicKey instanceof ECPublicKey) {
                                                                    publicKey2 = (ECPublicKey) publicKey;
                                                                } else {
                                                                    publicKey2 = null;
                                                                }
                                                                if (publicKey2 == null) {
                                                                    AniVortexRegistration aniVortexRegistration3 = this;
                                                                    lastFailure = "Generated software key is not EC";
                                                                    String str111 = lastFailure;
                                                                    Intrinsics.checkNotNull(str111);
                                                                    Log.w(str8, str111);
                                                                    return RegOutcome.FAILED;
                                                                }
                                                                aniVortexRegistration = this;
                                                                byte[] leafDer2 = aniVortexRegistration.buildLeafCertificate(privateKey5, publicKey2);
                                                                CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(leafDer2));
                                                                String leafB65 = Base64.encodeToString(leafDer2, 2);
                                                                List chainB67 = CollectionsKt.listOf(new String[]{leafB65, leafB65});
                                                                chainB64 = chainB67;
                                                                privateKey2 = privateKey5;
                                                            }
                                                            String canonical2 = "ANIVORTEX-INSTALL-REGISTER-V1\n" + challengeId + '\n' + aniVortexRegistration.b64UrlNoPad(aniVortexRegistration.sha256(challengeBytes));
                                                            Signature signer2 = Signature.getInstance("SHA256withECDSA");
                                                            signer2.initSign(privateKey2);
                                                            List chainB68 = chainB64;
                                                            byte[] bytes2 = canonical2.getBytes(Charsets.UTF_8);
                                                            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                                                            signer2.update(bytes2);
                                                            String proofSig3 = aniVortexRegistration.b64UrlNoPad(signer2.sign());
                                                            String chainJson3 = CollectionsKt.joinToString$default(chainB68, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.AniVortex.AniVortexRegistration$$ExternalSyntheticLambda0
                                                                public final Object invoke(Object obj6) {
                                                                    return AniVortexRegistration.performRegistration$lambda$4((String) obj6);
                                                                }
                                                            }, 30, (Object) null);
                                                            String registerBody2 = "{\"challenge_id\":\"" + challengeId + "\",\"certificate_chain\":[" + chainJson3 + "],\"proof_signature\":\"" + proofSig3 + "\"}";
                                                            Requests app3 = MainActivityKt.getApp();
                                                            Map<String, String> map3 = regHeaders;
                                                            RequestBody requestBodyCreate3 = RequestBody.Companion.create(registerBody2, MediaType.Companion.parse(str6));
                                                            c00162.L$0 = SpillingKt.nullOutSpilledVariable(challengeBody);
                                                            c00162.L$1 = SpillingKt.nullOutSpilledVariable(challengeResp);
                                                            c00162.L$2 = SpillingKt.nullOutSpilledVariable(challenge);
                                                            c00162.L$3 = SpillingKt.nullOutSpilledVariable(challengeId);
                                                            c00162.L$4 = SpillingKt.nullOutSpilledVariable(challengeStr3);
                                                            c00162.L$5 = SpillingKt.nullOutSpilledVariable(challengeBytes);
                                                            c00162.L$6 = privateKey2;
                                                            c00162.L$7 = SpillingKt.nullOutSpilledVariable(chainB68);
                                                            c00162.L$8 = SpillingKt.nullOutSpilledVariable(canonical2);
                                                            c00162.L$9 = SpillingKt.nullOutSpilledVariable(signer2);
                                                            c00162.L$10 = SpillingKt.nullOutSpilledVariable(proofSig3);
                                                            c00162.L$11 = SpillingKt.nullOutSpilledVariable(chainJson3);
                                                            c00162.L$12 = SpillingKt.nullOutSpilledVariable(registerBody2);
                                                            c00162.Z$0 = attested2;
                                                            c00162.Z$1 = includeDeviceProps2;
                                                            c00162.label = 2;
                                                            z6 = true;
                                                            attested3 = attested2;
                                                            privateKey3 = privateKey2;
                                                            chainJson = str9;
                                                            proofSig = str8;
                                                            $result = Requests.post$default(app3, "https://api.anivortex.in/api/v1/install/register", map3, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate3, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00162, 65276, (Object) null);
                                                            if ($result == obj) {
                                                                return obj;
                                                            }
                                                            privateKey4 = privateKey3;
                                                            registerResp = (NiceResponse) $result;
                                                            if (registerResp.getCode() == 429) {
                                                                str12 = registerResp.getHeaders().get(str);
                                                                if (str12 != null && (longOrNull2 = StringsKt.toLongOrNull(str12)) != null) {
                                                                    jLongValue = longOrNull2.longValue();
                                                                }
                                                                long retryAfterSec3 = jLongValue;
                                                                rateLimitUntilMs = System.currentTimeMillis() + (1000 * retryAfterSec3);
                                                                lastFailure = "Registration rate-limited (HTTP 429: too many requests). Server throttled your IP. Please wait " + retryAfterSec3 + str4;
                                                                Log.w(proofSig, lastFailure + str3 + registerResp.getHeaders() + ')');
                                                                return RegOutcome.RATE_LIMITED;
                                                            }
                                                            if (!registerResp.isSuccessful()) {
                                                                lastFailure = "Register rejected (HTTP " + registerResp.getCode() + chainJson + StringsKt.take(registerResp.getText(), 120);
                                                                String str25 = lastFailure;
                                                                Intrinsics.checkNotNull(str25);
                                                                Log.w(proofSig, str25);
                                                                return RegOutcome.FAILED;
                                                            }
                                                            AppUtils appUtils3 = AppUtils.INSTANCE;
                                                            value$iv2 = registerResp.getText();
                                                            if (value$iv2 == null) {
                                                                Result.Companion companion9 = Result.Companion;
                                                                KType kTypeTypeOf3 = Reflection.typeOf(RegisterResponse.class);
                                                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                                obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                                                if (Result.exceptionOrNull-impl(obj5) == null) {
                                                                    Result.Companion companion10 = Result.Companion;
                                                                    obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(RegisterResponse.class), (List) null, 2, (Object) null));
                                                                    break;
                                                                }
                                                                if (Result.isFailure-impl(obj5)) {
                                                                    obj5 = null;
                                                                }
                                                                deserializationStrategy2 = (KSerializer) obj5;
                                                                if (deserializationStrategy2 != null) {
                                                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                                                } else {
                                                                    ObjectMapper $this$readValue$iv$iv$iv7 = MainAPIKt.getMapper();
                                                                    objDecodeFromString2 = $this$readValue$iv$iv$iv7.readValue(value$iv2, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                                                                    });
                                                                }
                                                                break;
                                                            } else {
                                                                objDecodeFromString2 = null;
                                                            }
                                                            reg = (RegisterResponse) objDecodeFromString2;
                                                            if (reg != null) {
                                                                installation_id = reg.getInstallation_id();
                                                                if (installation_id != null || installation_id.length() == 0) {
                                                                    z7 = true;
                                                                } else {
                                                                    z7 = false;
                                                                }
                                                                if (!z7) {
                                                                    key_id = reg.getKey_id();
                                                                    if (key_id != null || key_id.length() == 0) {
                                                                        z8 = true;
                                                                    } else {
                                                                        z8 = false;
                                                                    }
                                                                    if (!z8) {
                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", reg.getInstallation_id());
                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", reg.getKey_id());
                                                                        if (attested3) {
                                                                            CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z6));
                                                                            CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", "");
                                                                        } else {
                                                                            CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(false));
                                                                            CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey4.getEncoded(), 2));
                                                                            clearKeystoreKey();
                                                                        }
                                                                        AniVortexAuth.INSTANCE.invalidateCache();
                                                                        lastFailure = null;
                                                                        StringBuilder sbAppend5 = new StringBuilder().append("Registration complete! installation_id=").append(reg.getInstallation_id()).append(" key_id=").append(reg.getKey_id()).append(" attested=");
                                                                        if (attested3) {
                                                                            z9 = true;
                                                                        } else {
                                                                            z9 = false;
                                                                        }
                                                                        Log.i(proofSig, sbAppend5.append(z9).toString());
                                                                        return RegOutcome.SUCCESS;
                                                                    }
                                                                }
                                                            }
                                                            lastFailure = "Register response missing fields: " + StringsKt.take(registerResp.getText(), 120);
                                                            String str26 = lastFailure;
                                                            Intrinsics.checkNotNull(str26);
                                                            Log.w(proofSig, str26);
                                                            return RegOutcome.FAILED;
                                                        }
                                                    }
                                                    lastFailure = "Invalid challenge response: " + StringsKt.take(challengeResp.getText(), 120);
                                                    String str27 = lastFailure;
                                                    Intrinsics.checkNotNull(str27);
                                                    Log.w(str8, str27);
                                                    return RegOutcome.FAILED;
                                                } catch (Throwable th18) {
                                                    e = th18;
                                                    str13 = str8;
                                                }
                                            }
                                        } catch (Throwable th19) {
                                            e = th19;
                                            str13 = str14;
                                        }
                                    } catch (Throwable th20) {
                                        e = th20;
                                        str13 = str5;
                                    }
                                    lastFailure = "Registration error: " + e.getMessage();
                                    String str28 = lastFailure;
                                    Intrinsics.checkNotNull(str28);
                                    Log.w(str13, str28);
                                    Log.d(str13, "Registration failed stacktrace", e);
                                    return RegOutcome.FAILED;
                                } catch (Throwable th21) {
                                    e = th21;
                                    str13 = str5;
                                }
                            } catch (Throwable th22) {
                                e = th22;
                                str13 = TAG;
                            }
                        } catch (Throwable th23) {
                            e = th23;
                            str13 = TAG;
                        }
                        break;
                    case 1:
                        boolean includeDeviceProps3 = c00162.Z$1;
                        boolean attested4 = c00162.Z$0;
                        String challengeBody2 = (String) c00162.L$0;
                        ResultKt.throwOnFailure($result);
                        challengeBody = challengeBody2;
                        obj2 = $result;
                        obj = coroutine_suspended;
                        str5 = TAG;
                        str6 = "application/json; charset=utf-8";
                        str = "retry-after";
                        str2 = "): ";
                        i = 429;
                        attested2 = attested4;
                        includeDeviceProps2 = includeDeviceProps3;
                        str3 = " (headers: ";
                        str4 = " seconds.";
                        challengeResp = (NiceResponse) obj2;
                        if (challengeResp.getCode() == i) {
                            str7 = challengeResp.getHeaders().get(str);
                            if (str7 != null) {
                                longOrNull = StringsKt.toLongOrNull(str7);
                                if (longOrNull != null) {
                                    jLongValue = longOrNull.longValue();
                                }
                                break;
                            }
                            long retryAfterSec4 = jLongValue;
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            Long.signum(retryAfterSec4);
                            rateLimitUntilMs = jCurrentTimeMillis2 + (1000 * retryAfterSec4);
                            lastFailure = "Challenge rate-limited (HTTP 429: too many requests). Server throttled your IP. Please wait " + retryAfterSec4 + str4;
                            Log.w(str5, lastFailure + str3 + challengeResp.getHeaders() + ')');
                            return RegOutcome.RATE_LIMITED;
                        }
                        str8 = str5;
                        if (!challengeResp.isSuccessful()) {
                            lastFailure = "Challenge failed (HTTP " + challengeResp.getCode() + str2 + StringsKt.take(challengeResp.getText(), 120);
                            String str112 = lastFailure;
                            Intrinsics.checkNotNull(str112);
                            Log.w(str8, str112);
                            return RegOutcome.FAILED;
                        }
                        str9 = str2;
                        AppUtils appUtils4 = AppUtils.INSTANCE;
                        value$iv = challengeResp.getText();
                        if (value$iv != null) {
                            obj4 = null;
                        } else {
                            Result.Companion companion11 = Result.Companion;
                            KType kTypeTypeOf4 = Reflection.typeOf(ChallengeResponse.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                            if (Result.exceptionOrNull-impl(obj3) == null) {
                                Result.Companion companion12 = Result.Companion;
                                obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ChallengeResponse.class), (List) null, 2, (Object) null));
                                break;
                            }
                            if (Result.isFailure-impl(obj3)) {
                                obj3 = null;
                            }
                            deserializationStrategy = (KSerializer) obj3;
                            if (deserializationStrategy != null) {
                                value$iv$iv = value$iv;
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                                obj4 = objDecodeFromString;
                            } else {
                                value$iv$iv = value$iv;
                            }
                            ObjectMapper $this$readValue$iv$iv$iv8 = MainAPIKt.getMapper();
                            String content$iv$iv$iv4 = value$iv$iv;
                            objDecodeFromString = $this$readValue$iv$iv$iv8.readValue(content$iv$iv$iv4, new TypeReference<ChallengeResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$1
                            });
                            obj4 = objDecodeFromString;
                        }
                        challenge = (ChallengeResponse) obj4;
                        if (challenge != null) {
                            challenge_id = challenge.getChallenge_id();
                        } else {
                            challenge_id = null;
                        }
                        challengeId = challenge_id;
                        if (challenge != null) {
                            challengeStr = challenge.getChallenge();
                        } else {
                            challengeStr = null;
                        }
                        str10 = challengeId;
                        if (str10 != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            str11 = challengeStr;
                            if (str11 != null) {
                                z2 = true;
                            } else {
                                z2 = true;
                            }
                            if (!z2) {
                                challengeBytes = Base64.decode(challengeStr, 11);
                                String challengeStr4 = challengeStr;
                                if (attested2) {
                                    $this$performRegistration_u24lambda_u240 = KeyStore.getInstance(r5);
                                    $this$performRegistration_u24lambda_u240.load(null);
                                    if ($this$performRegistration_u24lambda_u240.containsAlias(KEYSTORE_ALIAS)) {
                                        $this$performRegistration_u24lambda_u240.deleteEntry(KEYSTORE_ALIAS);
                                    }
                                    KeyPairGenerator kpg5 = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
                                    specBuilder = new KeyGenParameterSpec.Builder(KEYSTORE_ALIAS, 4).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests("SHA-256").setUserAuthenticationRequired(false).setAttestationChallenge(challengeBytes);
                                    if (includeDeviceProps2) {
                                        if (Build.VERSION.SDK_INT >= 31) {
                                            specBuilder.setDevicePropertiesAttestationIncluded(true);
                                        }
                                    }
                                    kpg5.initialize(specBuilder.build());
                                    privateKey = kpg5.generateKeyPair().getPrivate();
                                    KeyStore $this$performRegistration_u24lambda_u243 = KeyStore.getInstance("AndroidKeyStore");
                                    $this$performRegistration_u24lambda_u243.load(null);
                                    chain = $this$performRegistration_u24lambda_u243.getCertificateChain(KEYSTORE_ALIAS);
                                    if (chain == null) {
                                        z4 = true;
                                    } else {
                                        if (chain.length == 0) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        if (z5) {
                                            z4 = true;
                                        } else {
                                            z4 = false;
                                        }
                                    }
                                    if (z4) {
                                        lastFailure = "AndroidKeyStore returned no attestation chain";
                                        String str113 = lastFailure;
                                        Intrinsics.checkNotNull(str113);
                                        Log.w(str8, str113);
                                        return RegOutcome.FAILED;
                                    }
                                    destination$iv$iv = new ArrayList(chain.length);
                                    i2 = 0;
                                    while (i2 < length) {
                                        destination$iv$iv.add(Base64.encodeToString(chain[i2].getEncoded(), 2));
                                        i2++;
                                    }
                                    chainB64 = (List) destination$iv$iv;
                                    aniVortexRegistration = this;
                                    privateKey2 = privateKey;
                                    break;
                                } else {
                                    KeyPairGenerator kpg6 = KeyPairGenerator.getInstance("EC");
                                    kpg6.initialize(new ECGenParameterSpec("secp256r1"));
                                    KeyPair keyPair3 = kpg6.generateKeyPair();
                                    privateKey5 = keyPair3.getPrivate();
                                    publicKey = keyPair3.getPublic();
                                    if (publicKey instanceof ECPublicKey) {
                                        publicKey2 = (ECPublicKey) publicKey;
                                    } else {
                                        publicKey2 = null;
                                    }
                                    if (publicKey2 == null) {
                                        AniVortexRegistration aniVortexRegistration4 = this;
                                        lastFailure = "Generated software key is not EC";
                                        String str114 = lastFailure;
                                        Intrinsics.checkNotNull(str114);
                                        Log.w(str8, str114);
                                        return RegOutcome.FAILED;
                                    }
                                    aniVortexRegistration = this;
                                    byte[] leafDer3 = aniVortexRegistration.buildLeafCertificate(privateKey5, publicKey2);
                                    CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(leafDer3));
                                    String leafB66 = Base64.encodeToString(leafDer3, 2);
                                    List chainB69 = CollectionsKt.listOf(new String[]{leafB66, leafB66});
                                    chainB64 = chainB69;
                                    privateKey2 = privateKey5;
                                }
                                String canonical3 = "ANIVORTEX-INSTALL-REGISTER-V1\n" + challengeId + '\n' + aniVortexRegistration.b64UrlNoPad(aniVortexRegistration.sha256(challengeBytes));
                                Signature signer3 = Signature.getInstance("SHA256withECDSA");
                                signer3.initSign(privateKey2);
                                List chainB610 = chainB64;
                                byte[] bytes3 = canonical3.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
                                signer3.update(bytes3);
                                String proofSig4 = aniVortexRegistration.b64UrlNoPad(signer3.sign());
                                String chainJson4 = CollectionsKt.joinToString$default(chainB610, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.AniVortex.AniVortexRegistration$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj6) {
                                        return AniVortexRegistration.performRegistration$lambda$4((String) obj6);
                                    }
                                }, 30, (Object) null);
                                String registerBody3 = "{\"challenge_id\":\"" + challengeId + "\",\"certificate_chain\":[" + chainJson4 + "],\"proof_signature\":\"" + proofSig4 + "\"}";
                                Requests app4 = MainActivityKt.getApp();
                                Map<String, String> map4 = regHeaders;
                                RequestBody requestBodyCreate4 = RequestBody.Companion.create(registerBody3, MediaType.Companion.parse(str6));
                                c00162.L$0 = SpillingKt.nullOutSpilledVariable(challengeBody);
                                c00162.L$1 = SpillingKt.nullOutSpilledVariable(challengeResp);
                                c00162.L$2 = SpillingKt.nullOutSpilledVariable(challenge);
                                c00162.L$3 = SpillingKt.nullOutSpilledVariable(challengeId);
                                c00162.L$4 = SpillingKt.nullOutSpilledVariable(challengeStr4);
                                c00162.L$5 = SpillingKt.nullOutSpilledVariable(challengeBytes);
                                c00162.L$6 = privateKey2;
                                c00162.L$7 = SpillingKt.nullOutSpilledVariable(chainB610);
                                c00162.L$8 = SpillingKt.nullOutSpilledVariable(canonical3);
                                c00162.L$9 = SpillingKt.nullOutSpilledVariable(signer3);
                                c00162.L$10 = SpillingKt.nullOutSpilledVariable(proofSig4);
                                c00162.L$11 = SpillingKt.nullOutSpilledVariable(chainJson4);
                                c00162.L$12 = SpillingKt.nullOutSpilledVariable(registerBody3);
                                c00162.Z$0 = attested2;
                                c00162.Z$1 = includeDeviceProps2;
                                c00162.label = 2;
                                z6 = true;
                                attested3 = attested2;
                                privateKey3 = privateKey2;
                                chainJson = str9;
                                proofSig = str8;
                                $result = Requests.post$default(app4, "https://api.anivortex.in/api/v1/install/register", map4, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate4, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00162, 65276, (Object) null);
                                if ($result == obj) {
                                    return obj;
                                }
                                privateKey4 = privateKey3;
                                registerResp = (NiceResponse) $result;
                                if (registerResp.getCode() == 429) {
                                    str12 = registerResp.getHeaders().get(str);
                                    if (str12 != null) {
                                        jLongValue = longOrNull2.longValue();
                                    }
                                    long retryAfterSec5 = jLongValue;
                                    rateLimitUntilMs = System.currentTimeMillis() + (1000 * retryAfterSec5);
                                    lastFailure = "Registration rate-limited (HTTP 429: too many requests). Server throttled your IP. Please wait " + retryAfterSec5 + str4;
                                    Log.w(proofSig, lastFailure + str3 + registerResp.getHeaders() + ')');
                                    return RegOutcome.RATE_LIMITED;
                                }
                                if (!registerResp.isSuccessful()) {
                                    lastFailure = "Register rejected (HTTP " + registerResp.getCode() + chainJson + StringsKt.take(registerResp.getText(), 120);
                                    String str29 = lastFailure;
                                    Intrinsics.checkNotNull(str29);
                                    Log.w(proofSig, str29);
                                    return RegOutcome.FAILED;
                                }
                                AppUtils appUtils5 = AppUtils.INSTANCE;
                                value$iv2 = registerResp.getText();
                                if (value$iv2 == null) {
                                    Result.Companion companion13 = Result.Companion;
                                    KType kTypeTypeOf5 = Reflection.typeOf(RegisterResponse.class);
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                                    if (Result.exceptionOrNull-impl(obj5) == null) {
                                        Result.Companion companion14 = Result.Companion;
                                        obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(RegisterResponse.class), (List) null, 2, (Object) null));
                                        break;
                                    }
                                    if (Result.isFailure-impl(obj5)) {
                                        obj5 = null;
                                    }
                                    deserializationStrategy2 = (KSerializer) obj5;
                                    if (deserializationStrategy2 != null) {
                                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv$iv9 = MainAPIKt.getMapper();
                                        objDecodeFromString2 = $this$readValue$iv$iv$iv9.readValue(value$iv2, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                                        });
                                    }
                                    break;
                                } else {
                                    objDecodeFromString2 = null;
                                }
                                reg = (RegisterResponse) objDecodeFromString2;
                                if (reg != null) {
                                    installation_id = reg.getInstallation_id();
                                    if (installation_id != null) {
                                        z7 = true;
                                    } else {
                                        z7 = true;
                                    }
                                    if (!z7) {
                                        key_id = reg.getKey_id();
                                        if (key_id != null) {
                                            z8 = true;
                                        } else {
                                            z8 = true;
                                        }
                                        if (!z8) {
                                            CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", reg.getInstallation_id());
                                            CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", reg.getKey_id());
                                            if (attested3) {
                                                CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z6));
                                                CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", "");
                                            } else {
                                                CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(false));
                                                CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey4.getEncoded(), 2));
                                                clearKeystoreKey();
                                            }
                                            AniVortexAuth.INSTANCE.invalidateCache();
                                            lastFailure = null;
                                            StringBuilder sbAppend6 = new StringBuilder().append("Registration complete! installation_id=").append(reg.getInstallation_id()).append(" key_id=").append(reg.getKey_id()).append(" attested=");
                                            if (attested3) {
                                                z9 = true;
                                            } else {
                                                z9 = false;
                                            }
                                            Log.i(proofSig, sbAppend6.append(z9).toString());
                                            return RegOutcome.SUCCESS;
                                        }
                                    }
                                }
                                lastFailure = "Register response missing fields: " + StringsKt.take(registerResp.getText(), 120);
                                String str210 = lastFailure;
                                Intrinsics.checkNotNull(str210);
                                Log.w(proofSig, str210);
                                return RegOutcome.FAILED;
                            }
                        }
                        lastFailure = "Invalid challenge response: " + StringsKt.take(challengeResp.getText(), 120);
                        String str211 = lastFailure;
                        Intrinsics.checkNotNull(str211);
                        Log.w(str8, str211);
                        return RegOutcome.FAILED;
                        lastFailure = "Registration error: " + e.getMessage();
                        String str212 = lastFailure;
                        Intrinsics.checkNotNull(str212);
                        Log.w(str13, str212);
                        Log.d(str13, "Registration failed stacktrace", e);
                        return RegOutcome.FAILED;
                    case 2:
                        boolean z10 = c00162.Z$1;
                        boolean attested5 = c00162.Z$0;
                        privateKey4 = (PrivateKey) c00162.L$6;
                        ResultKt.throwOnFailure($result);
                        attested3 = attested5;
                        proofSig = TAG;
                        str = "retry-after";
                        chainJson = "): ";
                        str3 = " (headers: ";
                        str4 = " seconds.";
                        z6 = true;
                        registerResp = (NiceResponse) $result;
                        if (registerResp.getCode() == 429) {
                            str12 = registerResp.getHeaders().get(str);
                            if (str12 != null) {
                                jLongValue = longOrNull2.longValue();
                            }
                            long retryAfterSec6 = jLongValue;
                            rateLimitUntilMs = System.currentTimeMillis() + (1000 * retryAfterSec6);
                            lastFailure = "Registration rate-limited (HTTP 429: too many requests). Server throttled your IP. Please wait " + retryAfterSec6 + str4;
                            Log.w(proofSig, lastFailure + str3 + registerResp.getHeaders() + ')');
                            return RegOutcome.RATE_LIMITED;
                        }
                        if (!registerResp.isSuccessful()) {
                            lastFailure = "Register rejected (HTTP " + registerResp.getCode() + chainJson + StringsKt.take(registerResp.getText(), 120);
                            String str213 = lastFailure;
                            Intrinsics.checkNotNull(str213);
                            Log.w(proofSig, str213);
                            return RegOutcome.FAILED;
                        }
                        AppUtils appUtils6 = AppUtils.INSTANCE;
                        value$iv2 = registerResp.getText();
                        if (value$iv2 == null) {
                            Result.Companion companion15 = Result.Companion;
                            KType kTypeTypeOf6 = Reflection.typeOf(RegisterResponse.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                            if (Result.exceptionOrNull-impl(obj5) == null) {
                                Result.Companion companion16 = Result.Companion;
                                obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(RegisterResponse.class), (List) null, 2, (Object) null));
                                break;
                            }
                            if (Result.isFailure-impl(obj5)) {
                                obj5 = null;
                            }
                            deserializationStrategy2 = (KSerializer) obj5;
                            if (deserializationStrategy2 != null) {
                                objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv10 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv$iv10.readValue(value$iv2, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                                });
                            }
                            break;
                        } else {
                            objDecodeFromString2 = null;
                        }
                        reg = (RegisterResponse) objDecodeFromString2;
                        if (reg != null) {
                            installation_id = reg.getInstallation_id();
                            if (installation_id != null) {
                                z7 = true;
                            } else {
                                z7 = true;
                            }
                            if (!z7) {
                                key_id = reg.getKey_id();
                                if (key_id != null) {
                                    z8 = true;
                                } else {
                                    z8 = true;
                                }
                                if (!z8) {
                                    CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", reg.getInstallation_id());
                                    CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", reg.getKey_id());
                                    if (attested3) {
                                        CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z6));
                                        CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", "");
                                    } else {
                                        CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(false));
                                        CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey4.getEncoded(), 2));
                                        clearKeystoreKey();
                                    }
                                    AniVortexAuth.INSTANCE.invalidateCache();
                                    lastFailure = null;
                                    StringBuilder sbAppend7 = new StringBuilder().append("Registration complete! installation_id=").append(reg.getInstallation_id()).append(" key_id=").append(reg.getKey_id()).append(" attested=");
                                    if (attested3) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    Log.i(proofSig, sbAppend7.append(z9).toString());
                                    return RegOutcome.SUCCESS;
                                }
                            }
                        }
                        lastFailure = "Register response missing fields: " + StringsKt.take(registerResp.getText(), 120);
                        String str214 = lastFailure;
                        Intrinsics.checkNotNull(str214);
                        Log.w(proofSig, str214);
                        return RegOutcome.FAILED;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th24) {
                e = th24;
            }
        } catch (Throwable th25) {
            e = th25;
            str13 = TAG;
        }
    }

    static final CharSequence performRegistration$lambda$4(String it) {
        return '\"' + it + '\"';
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0084  */
    /* JADX WARN: Code duplicated, block: B:33:0x0115 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x0116  */
    /* JADX WARN: Code duplicated, block: B:37:0x0125 A[Catch: all -> 0x01ab, TryCatch #1 {all -> 0x01ab, blocks: (B:35:0x011d, B:37:0x0125, B:38:0x0176), top: B:51:0x011d }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0176 A[Catch: all -> 0x01ab, TRY_LEAVE, TryCatch #1 {all -> 0x01ab, blocks: (B:35:0x011d, B:37:0x0125, B:38:0x0176), top: B:51:0x011d }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object testApiConnection(@NotNull Continuation<? super Pair<Boolean, String>> continuation) throws Throwable {
        C00191 c00191;
        Object objEnsureRegistered;
        boolean registered;
        boolean z;
        Object obj;
        String str;
        NiceResponse resp;
        Pair pair;
        if (continuation instanceof C00191) {
            c00191 = (C00191) continuation;
            if ((c00191.label & Integer.MIN_VALUE) != 0) {
                c00191.label -= Integer.MIN_VALUE;
            } else {
                c00191 = new C00191(continuation);
            }
        } else {
            c00191 = new C00191(continuation);
        }
        C00191 c00192 = c00191;
        Object $result = c00192.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00192.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00192.label = 1;
                objEnsureRegistered = ensureRegistered(c00192);
                if (objEnsureRegistered == coroutine_suspended) {
                    return coroutine_suspended;
                }
                registered = ((Boolean) objEnsureRegistered).booleanValue();
                if (!registered) {
                    Boolean boolBoxBoolean = Boxing.boxBoolean(false);
                    StringBuilder sbAppend = new StringBuilder().append("Registration failed: ");
                    str = lastFailure;
                    if (str == null) {
                        str = "unknown error";
                    }
                    return new Pair(boolBoxBoolean, sbAppend.append(str).toString());
                }
                try {
                    Pair pairBuildHeaders$default = AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "GET", "/api/v1/catalog/ott-platforms/netflix/titles", MapsKt.mapOf(TuplesKt.to("limit", "1")), null, 8, null);
                    String query = (String) pairBuildHeaders$default.component1();
                    Map headers = (Map) pairBuildHeaders$default.component2();
                    String url = "https://api.anivortex.in/api/v1/catalog/ott-platforms/netflix/titles?" + query;
                    Requests app = MainActivityKt.getApp();
                    c00192.L$0 = SpillingKt.nullOutSpilledVariable(query);
                    c00192.L$1 = SpillingKt.nullOutSpilledVariable(headers);
                    c00192.L$2 = SpillingKt.nullOutSpilledVariable(url);
                    c00192.Z$0 = registered;
                    c00192.label = 2;
                    z = true;
                    try {
                        obj = Requests.get$default(app, url, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00192, 4092, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = obj;
                        try {
                            resp = (NiceResponse) $result;
                            if (resp.isSuccessful()) {
                                pair = new Pair(Boxing.boxBoolean(z), "API connection OK (HTTP " + resp.getCode() + ")!\n\nInstall ID: " + StringsKt.take(AniVortexAuth.INSTANCE.getInstallationId(), 16) + "…\nKey ID: " + StringsKt.take(AniVortexAuth.INSTANCE.getKeyId(), 16) + "…\nSigned requests are working properly.");
                            } else {
                                pair = new Pair(Boxing.boxBoolean(false), "API test returned HTTP " + resp.getCode() + ": " + StringsKt.take(resp.getText(), 150));
                            }
                            return pair;
                        } catch (Throwable th) {
                            e = th;
                            return new Pair(Boxing.boxBoolean(false), "API test exception: " + e.getMessage());
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        return new Pair(Boxing.boxBoolean(false), "API test exception: " + e.getMessage());
                    }
                } catch (Throwable th3) {
                    e = th3;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objEnsureRegistered = $result;
                registered = ((Boolean) objEnsureRegistered).booleanValue();
                if (!registered) {
                    Boolean boolBoxBoolean2 = Boxing.boxBoolean(false);
                    StringBuilder sbAppend2 = new StringBuilder().append("Registration failed: ");
                    str = lastFailure;
                    if (str == null) {
                        str = "unknown error";
                    }
                    return new Pair(boolBoxBoolean2, sbAppend2.append(str).toString());
                }
                Pair pairBuildHeaders$default2 = AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "GET", "/api/v1/catalog/ott-platforms/netflix/titles", MapsKt.mapOf(TuplesKt.to("limit", "1")), null, 8, null);
                String query2 = (String) pairBuildHeaders$default2.component1();
                Map headers2 = (Map) pairBuildHeaders$default2.component2();
                String url2 = "https://api.anivortex.in/api/v1/catalog/ott-platforms/netflix/titles?" + query2;
                Requests app2 = MainActivityKt.getApp();
                c00192.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00192.L$1 = SpillingKt.nullOutSpilledVariable(headers2);
                c00192.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                c00192.Z$0 = registered;
                c00192.label = 2;
                z = true;
                obj = Requests.get$default(app2, url2, headers2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00192, 4092, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result = obj;
                resp = (NiceResponse) $result;
                if (resp.isSuccessful()) {
                    pair = new Pair(Boxing.boxBoolean(z), "API connection OK (HTTP " + resp.getCode() + ")!\n\nInstall ID: " + StringsKt.take(AniVortexAuth.INSTANCE.getInstallationId(), 16) + "…\nKey ID: " + StringsKt.take(AniVortexAuth.INSTANCE.getKeyId(), 16) + "…\nSigned requests are working properly.");
                } else {
                    pair = new Pair(Boxing.boxBoolean(false), "API test returned HTTP " + resp.getCode() + ": " + StringsKt.take(resp.getText(), 150));
                }
                return pair;
            case 2:
                boolean z2 = c00192.Z$0;
                try {
                    ResultKt.throwOnFailure($result);
                    z = true;
                    resp = (NiceResponse) $result;
                    if (resp.isSuccessful()) {
                        pair = new Pair(Boxing.boxBoolean(z), "API connection OK (HTTP " + resp.getCode() + ")!\n\nInstall ID: " + StringsKt.take(AniVortexAuth.INSTANCE.getInstallationId(), 16) + "…\nKey ID: " + StringsKt.take(AniVortexAuth.INSTANCE.getKeyId(), 16) + "…\nSigned requests are working properly.");
                    } else {
                        pair = new Pair(Boxing.boxBoolean(false), "API test returned HTTP " + resp.getCode() + ": " + StringsKt.take(resp.getText(), 150));
                    }
                    return pair;
                } catch (Throwable th4) {
                    e = th4;
                    return new Pair(Boxing.boxBoolean(false), "API test exception: " + e.getMessage());
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final byte[] buildLeafCertificate(PrivateKey privateKey, ECPublicKey publicKey) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        byte[] tbs = buildTbsCertificate(publicKey);
        Signature signer = Signature.getInstance("SHA256withECDSA");
        signer.initSign(privateKey);
        signer.update(tbs);
        byte[] certSig = signer.sign();
        return derSequence(tbs, derSequence(derOid(ECDSA_WITH_SHA256)), derBitString(certSig));
    }

    private final byte[] buildTbsCertificate(ECPublicKey publicKey) {
        byte[] point = new byte[65];
        point[0] = 4;
        toFixedLengthBytes(publicKey.getW().getAffineX(), point, 1, 32);
        toFixedLengthBytes(publicKey.getW().getAffineY(), point, 33, 32);
        return derSequence(derExplicitContextZero(derInteger(BigInteger.valueOf(2L))), derInteger(BigInteger.ONE), derSequence(derOid(ECDSA_WITH_SHA256)), derCnName(), derSequence(derUtcTime(getUtcTime(System.currentTimeMillis() - 86400000)), derUtcTime(getUtcTime(System.currentTimeMillis() + 31536000000L))), derCnName(), derSequence(derSequence(derOid(ID_EC_PUBLIC_KEY), derOid(PRIME256V1)), derBitString(point)));
    }

    private final byte[] derCnName() {
        byte[] cnOid = {6, 3, 85, 4, 3};
        byte[] atv = derSequence(cnOid, derUtf8String(KEY_ALIAS_DER_CN));
        return derSequence(derSet(atv));
    }

    private final byte[] derLength(int len) {
        if (len < 128) {
            return new byte[]{(byte) len};
        }
        byte[] it = BigInteger.valueOf(len).toByteArray();
        if (it.length > 1 && it[0] == 0) {
            it = ArraysKt.copyOfRange(it, 1, it.length);
        }
        return ArraysKt.plus(new byte[]{(byte) (128 | it.length)}, it);
    }

    static /* synthetic */ byte[] derTagged$default(AniVortexRegistration aniVortexRegistration, byte b, byte[] bArr, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return aniVortexRegistration.derTagged(b, bArr, z);
    }

    private final byte[] derTagged(byte tag, byte[] content, boolean primitive) {
        int constructed = primitive ? 0 : 32;
        return ArraysKt.plus(ArraysKt.plus(new byte[]{(byte) (tag | constructed)}, derLength(content.length)), content);
    }

    private final byte[] derSequence(byte[]... parts) {
        byte[][] $this$fold$iv = parts;
        byte[] bArrPlus = new byte[0];
        for (Object element$iv : $this$fold$iv) {
            byte[] b = (byte[]) element$iv;
            byte[] acc = bArrPlus;
            bArrPlus = ArraysKt.plus(acc, b);
        }
        return derTagged$default(this, (byte) 48, bArrPlus, false, 4, null);
    }

    private final byte[] derSet(byte[] content) {
        return derTagged$default(this, (byte) 49, content, false, 4, null);
    }

    private final byte[] derExplicitContextZero(byte[] content) {
        return derTagged$default(this, (byte) -96, content, false, 4, null);
    }

    private final byte[] derInteger(BigInteger value) {
        byte[] bytes = value.toByteArray();
        if (bytes.length == 0) {
            bytes = new byte[]{0};
        }
        if ((bytes[0] & 128) != 0) {
            bytes = ArraysKt.plus(new byte[]{0}, bytes);
        }
        return derTagged((byte) 2, bytes, true);
    }

    private final byte[] derOid(byte[] oidBytes) {
        return derTagged((byte) 6, oidBytes, true);
    }

    private final byte[] derUtf8String(String value) {
        byte[] bytes = value.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return derTagged((byte) 12, bytes, true);
    }

    private final String getUtcTime(long epochMs) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss'Z'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(new Date(epochMs));
    }

    private final byte[] derUtcTime(String value) {
        byte[] bytes = value.getBytes(Charsets.US_ASCII);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return derTagged((byte) 23, bytes, true);
    }

    private final byte[] derGeneralizedTime(String value) {
        byte[] bytes = value.getBytes(Charsets.US_ASCII);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return derTagged((byte) 24, bytes, true);
    }

    private final byte[] derBitString(byte[] content) {
        return derTagged((byte) 3, ArraysKt.plus(new byte[]{0}, content), true);
    }

    private final void toFixedLengthBytes(BigInteger value, byte[] out, int offset, int length) {
        byte[] raw = value.toByteArray();
        byte[] rawNoSign = (raw.length <= 1 || raw[0] != 0) ? raw : ArraysKt.copyOfRange(raw, 1, raw.length);
        Arrays.fill(out, offset, offset + length, (byte) 0);
        if (rawNoSign.length <= length) {
            System.arraycopy(rawNoSign, 0, out, (length - rawNoSign.length) + offset, rawNoSign.length);
        } else {
            System.arraycopy(rawNoSign, rawNoSign.length - length, out, offset, length);
        }
    }

    private final byte[] sha256(byte[] data) {
        return MessageDigest.getInstance("SHA-256").digest(data);
    }

    private final String b64UrlNoPad(byte[] data) {
        return Base64.encodeToString(data, 11);
    }
}
