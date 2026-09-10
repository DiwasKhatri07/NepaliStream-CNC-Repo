package com.AniVortex;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import android.util.Log;
import com.fasterxml.jackson.core.type.TypeReference;
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
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import kotlin.Unit;
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
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003VWXB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u001b\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001e\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010#J\u0018\u0010%\u001a\u00020\u00132\b\b\u0002\u0010&\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010'J\u0018\u0010(\u001a\u00020\u00152\b\b\u0002\u0010)\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010*J\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050,H\u0086@¢\u0006\u0002\u0010\u001cJ\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020.2\u0006\u00100\u001a\u000201H\u0002J\b\u00103\u001a\u00020.H\u0002J\u0010\u00104\u001a\u00020.2\u0006\u00105\u001a\u000206H\u0002J\"\u00107\u001a\u00020.2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020.2\b\b\u0002\u0010;\u001a\u00020\u0013H\u0002J!\u0010<\u001a\u00020.2\u0012\u0010=\u001a\n\u0012\u0006\b\u0001\u0012\u00020.0>\"\u00020.H\u0002¢\u0006\u0002\u0010?J\u0010\u0010@\u001a\u00020.2\u0006\u0010:\u001a\u00020.H\u0002J\u0010\u0010A\u001a\u00020.2\u0006\u0010:\u001a\u00020.H\u0002J\u0010\u0010B\u001a\u00020.2\u0006\u0010\u000e\u001a\u00020CH\u0002J\u0010\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020.H\u0002J\u0010\u0010F\u001a\u00020.2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u0019H\u0002J\u0010\u0010I\u001a\u00020.2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010J\u001a\u00020.2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010K\u001a\u00020.2\u0006\u0010:\u001a\u00020.H\u0002J(\u0010O\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020C2\u0006\u0010P\u001a\u00020.2\u0006\u0010Q\u001a\u0002062\u0006\u0010R\u001a\u000206H\u0002J\u0010\u0010S\u001a\u00020.2\u0006\u0010T\u001a\u00020.H\u0002J\u0010\u0010U\u001a\u00020\u00052\u0006\u0010T\u001a\u00020.H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/AniVortex/AniVortexRegistration;", "", "<init>", "()V", "TAG", "", "BASE_URL", "KEY_ALIAS_DER_CN", "REGISTER_PREFIX", "KEYSTORE_ALIAS", "regHeaders", "", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "value", "lastFailure", "getLastFailure", "()Ljava/lang/String;", "hasCredentials", "", "clearKeystoreKey", "", "getKeystorePrivateKey", "Ljava/security/PrivateKey;", "lastAttemptMs", "", "rateLimitUntilMs", "ensureRegistered", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reRegister", "resolveCredentials", "performRegistration", "Lcom/AniVortex/AniVortexRegistration$RegOutcome;", "attested", "includeDeviceProps", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pushSyncMutex", "syncInstallationPush", "force", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncInstallationPushIfNeeded", "minIntervalMs", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "testApiConnection", "Lkotlin/Pair;", "buildLeafCertificate", "", "privateKey", "publicKey", "Ljava/security/interfaces/ECPublicKey;", "buildTbsCertificate", "derCnName", "derLength", "len", "", "derTagged", "tag", "", "content", "primitive", "derSequence", "parts", "", "([[B)[B", "derSet", "derExplicitContextZero", "derInteger", "Ljava/math/BigInteger;", "derOid", "oidBytes", "derUtf8String", "getUtcTime", "epochMs", "derUtcTime", "derGeneralizedTime", "derBitString", "ECDSA_WITH_SHA256", "ID_EC_PUBLIC_KEY", "PRIME256V1", "toFixedLengthBytes", "out", "offset", "length", "sha256", "data", "b64UrlNoPad", "ChallengeResponse", "RegisterResponse", "RegOutcome", "AniVortex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAniVortexRegistration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniVortexRegistration.kt\ncom/AniVortex/AniVortexRegistration\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CloudStreamApp.kt\ncom/lagradost/cloudstream3/CloudStreamApp$Companion\n+ 4 DataStore.kt\ncom/lagradost/cloudstream3/utils/DataStore\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 7 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 8 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,567:1\n1#2:568\n1#2:575\n1#2:618\n1#2:645\n1#2:678\n1#2:706\n144#3:569\n144#3:672\n144#3:700\n231#4:570\n222#4,3:571\n225#4,2:593\n231#4:673\n222#4,3:674\n225#4,2:696\n231#4:701\n222#4,3:702\n225#4,2:724\n63#5:574\n64#5,15:576\n93#5,2:615\n63#5:617\n64#5,15:619\n95#5,2:636\n93#5,2:642\n63#5:644\n64#5,15:646\n95#5,2:663\n63#5:677\n64#5,15:679\n63#5:705\n64#5,15:707\n50#6:591\n43#6:592\n50#6:634\n43#6:635\n50#6:661\n43#6:662\n50#6:694\n43#6:695\n50#6:722\n43#6:723\n117#7,10:595\n117#7,10:605\n117#7,7:665\n125#7,2:698\n12746#8:638\n13093#8,3:639\n14512#8,3:726\n*S KotlinDebug\n*F\n+ 1 AniVortexRegistration.kt\ncom/AniVortex/AniVortexRegistration\n*L\n102#1:575\n199#1:618\n312#1:645\n355#1:678\n397#1:706\n102#1:569\n355#1:672\n397#1:700\n102#1:570\n102#1:571,3\n102#1:593,2\n355#1:673\n355#1:674,3\n355#1:696,2\n397#1:701\n397#1:702,3\n397#1:724,2\n102#1:574\n102#1:576,15\n199#1:615,2\n199#1:617\n199#1:619,15\n199#1:636,2\n312#1:642,2\n312#1:644\n312#1:646,15\n312#1:663,2\n355#1:677\n355#1:679,15\n397#1:705\n397#1:707,15\n102#1:591\n102#1:592\n199#1:634\n199#1:635\n312#1:661\n312#1:662\n355#1:694\n355#1:695\n397#1:722\n397#1:723\n128#1:595,10\n141#1:605,10\n352#1:665,7\n352#1:698,2\n256#1:638\n256#1:639,3\n509#1:726,3\n*E\n"})
public final class AniVortexRegistration {

    @NotNull
    private static final String BASE_URL = "https://api.anivortex.in";

    @NotNull
    private static final String KEYSTORE_ALIAS = "anivortex_install_signing_v1";

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
    private static final Mutex pushSyncMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @NotNull
    private static final byte[] ECDSA_WITH_SHA256 = {42, -122, 72, -50, 61, 4, 3, 2};

    @NotNull
    private static final byte[] ID_EC_PUBLIC_KEY = {42, -122, 72, -50, 61, 2, 1};

    @NotNull
    private static final byte[] PRIME256V1 = {42, -122, 72, -50, 61, 3, 1, 7};

    /* JADX INFO: compiled from: AniVortexRegistration.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/AniVortex/AniVortexRegistration$RegOutcome;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "RATE_LIMITED", "SERVER_REJECTED", "FAILED", "AniVortex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private enum RegOutcome {
        SUCCESS,
        RATE_LIMITED,
        SERVER_REJECTED,
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
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {0, 1, 1}, l = {572, 135}, m = "ensureRegistered", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "now"}, nl = {573, 574}, s = {"L$0", "L$0", "J$0"}, v = 2)
    static final class C00151 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00151(Continuation<? super C00151> continuation) {
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
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {182, 294, 334}, m = "performRegistration", n = {"challengeBody", "attested", "includeDeviceProps", "challengeBody", "challengeResp", "challenge", "challengeId", "challengeStr", "challengeBytes", "privateKey", "chainB64", "canonical", "signer", "proofSig", "chainJson", "registerBody", "attested", "includeDeviceProps", "challengeBody", "challengeResp", "challenge", "challengeId", "challengeStr", "challengeBytes", "privateKey", "chainB64", "canonical", "signer", "proofSig", "chainJson", "registerBody", "registerResp", "reg", "attested", "includeDeviceProps"}, nl = {187, 299, 335}, s = {"L$0", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0", "Z$1"}, v = 2)
    static final class C00181 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
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

        C00181(Continuation<? super C00181> continuation) {
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
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {0, 1}, l = {572, 145}, m = "reRegister", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, nl = {573, 574}, s = {"L$0", "L$0"}, v = 2)
    static final class C00191 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00191(Continuation<? super C00191> continuation) {
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
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {0, 1, 1}, l = {166, 171}, m = "resolveCredentials", n = {"now", "outcome", "now"}, nl = {169, 174}, s = {"J$0", "L$0", "J$0"}, v = 2)
    static final class C00201 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00201(Continuation<? super C00201> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexRegistration.this.resolveCredentials((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexRegistration$syncInstallationPush$1 */
    /* JADX INFO: compiled from: AniVortexRegistration.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {572, 374}, m = "syncInstallationPush", n = {"$this$withLock_u24default$iv", "force", "$this$withLock_u24default$iv", "isoTime", "jsonBody", "bodyBytes", "headers", "sdf", "force", "now", "lastSync"}, nl = {573, 379}, s = {"L$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "J$0", "J$1"}, v = 2)
    static final class C00211 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00211(Continuation<? super C00211> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexRegistration.this.syncInstallationPush(false, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexRegistration$syncInstallationPushIfNeeded$1 */
    /* JADX INFO: compiled from: AniVortexRegistration.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {0, 0}, l = {400}, m = "syncInstallationPushIfNeeded", n = {"minIntervalMs", "lastSync"}, nl = {402}, s = {"J$0", "J$1"}, v = 2)
    static final class C00241 extends ContinuationImpl {
        long J$0;
        long J$1;
        int label;
        /* synthetic */ Object result;

        C00241(Continuation<? super C00241> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexRegistration.this.syncInstallationPushIfNeeded(0L, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexRegistration$testApiConnection$1 */
    /* JADX INFO: compiled from: AniVortexRegistration.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {1, 1, 1, 1}, l = {409, 420}, m = "testApiConnection", n = {"query", "headers", "url", "registered"}, nl = {410, 421}, s = {"L$0", "L$1", "L$2", "Z$0"}, v = 2)
    static final class C00251 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00251(Continuation<? super C00251> continuation) {
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
            if (ks.containsAlias("anivortex_cs3_v1")) {
                ks.deleteEntry("anivortex_cs3_v1");
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

    /* JADX WARN: Code duplicated, block: B:29:0x007d  */
    /* JADX WARN: Code duplicated, block: B:30:0x007e A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:13:0x003d, B:37:0x00ab, B:38:0x00b1, B:27:0x0075, B:30:0x007e, B:33:0x008e), top: B:43:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x008c  */
    /* JADX WARN: Code duplicated, block: B:33:0x008e A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:13:0x003d, B:37:0x00ab, B:38:0x00b1, B:27:0x0075, B:30:0x007e, B:33:0x008e), top: B:43:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00a9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object ensureRegistered(@NotNull Continuation<? super Boolean> continuation) {
        C00151 c00151;
        AniVortexRegistration aniVortexRegistration;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        long now;
        Object objWithContext;
        if (continuation instanceof C00151) {
            c00151 = (C00151) continuation;
            if ((c00151.label & Integer.MIN_VALUE) != 0) {
                c00151.label -= Integer.MIN_VALUE;
                aniVortexRegistration = this;
            } else {
                aniVortexRegistration = this;
                c00151 = aniVortexRegistration.new C00151(continuation);
            }
        } else {
            aniVortexRegistration = this;
            c00151 = aniVortexRegistration.new C00151(continuation);
        }
        C00151 c00152 = c00151;
        Object $result = c00152.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean zBooleanValue = true;
        try {
            switch (c00152.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (aniVortexRegistration.hasCredentials()) {
                        return Boxing.boxBoolean(true);
                    }
                    Mutex $this$withLock_u24default$iv2 = mutex;
                    c00152.L$0 = $this$withLock_u24default$iv2;
                    c00152.label = 1;
                    if ($this$withLock_u24default$iv2.lock((Object) null, c00152) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                    owner$iv = null;
                    if (INSTANCE.hasCredentials()) {
                        now = System.currentTimeMillis();
                        if (now - lastAttemptMs < 5000) {
                            zBooleanValue = false;
                        } else {
                            lastAttemptMs = now;
                            CoroutineContext coroutineContext = NonCancellable.INSTANCE;
                            AniVortexRegistration$ensureRegistered$2$1 aniVortexRegistration$ensureRegistered$2$1 = new AniVortexRegistration$ensureRegistered$2$1(null);
                            c00152.L$0 = $this$withLock_u24default$iv;
                            c00152.J$0 = now;
                            c00152.label = 2;
                            objWithContext = BuildersKt.withContext(coroutineContext, aniVortexRegistration$ensureRegistered$2$1, c00152);
                            if (objWithContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            zBooleanValue = ((Boolean) objWithContext).booleanValue();
                        }
                    }
                    Boolean boolBoxBoolean = Boxing.boxBoolean(zBooleanValue);
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    return boolBoxBoolean;
                case 1:
                    Mutex $this$withLock_u24default$iv3 = (Mutex) c00152.L$0;
                    ResultKt.throwOnFailure($result);
                    $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                    owner$iv = null;
                    if (INSTANCE.hasCredentials()) {
                        now = System.currentTimeMillis();
                        if (now - lastAttemptMs < 5000) {
                            zBooleanValue = false;
                        } else {
                            lastAttemptMs = now;
                            CoroutineContext coroutineContext2 = NonCancellable.INSTANCE;
                            AniVortexRegistration$ensureRegistered$2$1 aniVortexRegistration$ensureRegistered$2$2 = new AniVortexRegistration$ensureRegistered$2$1(null);
                            c00152.L$0 = $this$withLock_u24default$iv;
                            c00152.J$0 = now;
                            c00152.label = 2;
                            objWithContext = BuildersKt.withContext(coroutineContext2, aniVortexRegistration$ensureRegistered$2$2, c00152);
                            if (objWithContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            zBooleanValue = ((Boolean) objWithContext).booleanValue();
                        }
                    }
                    Boolean boolBoxBoolean2 = Boxing.boxBoolean(zBooleanValue);
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    return boolBoxBoolean2;
                case 2:
                    long j = c00152.J$0;
                    owner$iv = null;
                    $this$withLock_u24default$iv = (Mutex) c00152.L$0;
                    ResultKt.throwOnFailure($result);
                    objWithContext = $result;
                    zBooleanValue = ((Boolean) objWithContext).booleanValue();
                    Boolean boolBoxBoolean3 = Boxing.boxBoolean(zBooleanValue);
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    return boolBoxBoolean3;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th) {
            $this$withLock_u24default$iv.unlock(owner$iv);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x007e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x007f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object reRegister(@NotNull Continuation<? super Boolean> continuation) throws Throwable {
        C00191 c00191;
        Object owner$iv;
        Mutex $this$withLock_u24default$iv;
        Mutex $this$withLock_u24default$iv2;
        Throwable th;
        Object objWithContext;
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
        Object $result = c00191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00191.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Mutex $this$withLock_u24default$iv3 = mutex;
                owner$iv = null;
                c00191.L$0 = $this$withLock_u24default$iv3;
                c00191.label = 1;
                if ($this$withLock_u24default$iv3.lock((Object) null, c00191) == coroutine_suspended) {
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
                    c00191.L$0 = $this$withLock_u24default$iv;
                    c00191.label = 2;
                    objWithContext = BuildersKt.withContext(coroutineContext, aniVortexRegistration$reRegister$2$1, c00191);
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
                $this$withLock_u24default$iv = (Mutex) c00191.L$0;
                ResultKt.throwOnFailure($result);
                lastAttemptMs = 0L;
                rateLimitUntilMs = 0L;
                AniVortexAuth.INSTANCE.markCurrentCredentialsInvalid();
                CoroutineContext coroutineContext2 = NonCancellable.INSTANCE;
                AniVortexRegistration$reRegister$2$1 aniVortexRegistration$reRegister$2$2 = new AniVortexRegistration$reRegister$2$1(null);
                c00191.L$0 = $this$withLock_u24default$iv;
                c00191.label = 2;
                objWithContext = BuildersKt.withContext(coroutineContext2, aniVortexRegistration$reRegister$2$2, c00191);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Boolean boolBoxBoolean2 = Boxing.boxBoolean(((Boolean) objWithContext).booleanValue());
                $this$withLock_u24default$iv.unlock(owner$iv);
                return boolBoxBoolean2;
            case 2:
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex) c00191.L$0;
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
    /* JADX WARN: Code duplicated, block: B:25:0x00c8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:31:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object resolveCredentials(Continuation<? super Boolean> continuation) {
        C00201 c00201;
        long now;
        Object objPerformRegistration;
        RegOutcome outcome;
        Object objPerformRegistration2;
        long now2;
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
        switch (c00201.label) {
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
                c00201.J$0 = now;
                c00201.label = 1;
                objPerformRegistration = performRegistration(false, false, c00201);
                if (objPerformRegistration == coroutine_suspended) {
                    return coroutine_suspended;
                }
                outcome = (RegOutcome) objPerformRegistration;
                if (outcome == RegOutcome.FAILED) {
                    Log.i(TAG, "Software registration failed (" + lastFailure + "), attempting hardware attestation fallback...");
                    c00201.L$0 = SpillingKt.nullOutSpilledVariable(outcome);
                    c00201.J$0 = now;
                    c00201.label = 2;
                    objPerformRegistration2 = performRegistration(true, false, c00201);
                    if (objPerformRegistration2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    now2 = now;
                    outcome = (RegOutcome) objPerformRegistration2;
                }
                return Boxing.boxBoolean(outcome == RegOutcome.SUCCESS);
            case 1:
                now = c00201.J$0;
                ResultKt.throwOnFailure($result);
                objPerformRegistration = $result;
                outcome = (RegOutcome) objPerformRegistration;
                if (outcome == RegOutcome.FAILED) {
                    Log.i(TAG, "Software registration failed (" + lastFailure + "), attempting hardware attestation fallback...");
                    c00201.L$0 = SpillingKt.nullOutSpilledVariable(outcome);
                    c00201.J$0 = now;
                    c00201.label = 2;
                    objPerformRegistration2 = performRegistration(true, false, c00201);
                    if (objPerformRegistration2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    now2 = now;
                    outcome = (RegOutcome) objPerformRegistration2;
                }
                return Boxing.boxBoolean(outcome == RegOutcome.SUCCESS);
            case 2:
                now2 = c00201.J$0;
                ResultKt.throwOnFailure($result);
                objPerformRegistration2 = $result;
                outcome = (RegOutcome) objPerformRegistration2;
                return Boxing.boxBoolean(outcome == RegOutcome.SUCCESS);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:104:0x035b A[Catch: all -> 0x02b9, Exception -> 0x0375, TRY_LEAVE, TryCatch #8 {Exception -> 0x0375, blocks: (B:93:0x0339, B:96:0x0340, B:104:0x035b, B:103:0x0355, B:92:0x032e), top: B:372:0x032e }] */
    /* JADX WARN: Code duplicated, block: B:116:0x0383 A[Catch: all -> 0x02b9, TRY_ENTER, TryCatch #15 {all -> 0x02b9, blocks: (B:216:0x06f8, B:223:0x070b, B:280:0x081e, B:288:0x0832, B:298:0x0862, B:235:0x077d, B:247:0x07bd, B:250:0x07c4, B:267:0x07ec, B:265:0x07e3, B:246:0x07b3, B:234:0x0773, B:58:0x026a, B:66:0x0281, B:116:0x0383, B:120:0x038c, B:126:0x0398, B:134:0x03a9, B:181:0x0488, B:186:0x04d3, B:189:0x04d9, B:80:0x02f9, B:93:0x0339, B:96:0x0340, B:104:0x035b, B:103:0x0355, B:92:0x032e, B:79:0x02ef), top: B:386:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x0388  */
    /* JADX WARN: Code duplicated, block: B:120:0x038c A[Catch: all -> 0x02b9, TRY_LEAVE, TryCatch #15 {all -> 0x02b9, blocks: (B:216:0x06f8, B:223:0x070b, B:280:0x081e, B:288:0x0832, B:298:0x0862, B:235:0x077d, B:247:0x07bd, B:250:0x07c4, B:267:0x07ec, B:265:0x07e3, B:246:0x07b3, B:234:0x0773, B:58:0x026a, B:66:0x0281, B:116:0x0383, B:120:0x038c, B:126:0x0398, B:134:0x03a9, B:181:0x0488, B:186:0x04d3, B:189:0x04d9, B:80:0x02f9, B:93:0x0339, B:96:0x0340, B:104:0x035b, B:103:0x0355, B:92:0x032e, B:79:0x02ef), top: B:386:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0391  */
    /* JADX WARN: Code duplicated, block: B:126:0x0398 A[Catch: all -> 0x02b9, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x02b9, blocks: (B:216:0x06f8, B:223:0x070b, B:280:0x081e, B:288:0x0832, B:298:0x0862, B:235:0x077d, B:247:0x07bd, B:250:0x07c4, B:267:0x07ec, B:265:0x07e3, B:246:0x07b3, B:234:0x0773, B:58:0x026a, B:66:0x0281, B:116:0x0383, B:120:0x038c, B:126:0x0398, B:134:0x03a9, B:181:0x0488, B:186:0x04d3, B:189:0x04d9, B:80:0x02f9, B:93:0x0339, B:96:0x0340, B:104:0x035b, B:103:0x0355, B:92:0x032e, B:79:0x02ef), top: B:386:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:132:0x03a4 A[Catch: all -> 0x0a00, TRY_ENTER, TRY_LEAVE, TryCatch #21 {all -> 0x0a00, blocks: (B:64:0x027b, B:71:0x02bf, B:113:0x037e, B:124:0x0393, B:132:0x03a4, B:142:0x03c7, B:184:0x04b0), top: B:397:0x027b }] */
    /* JADX WARN: Code duplicated, block: B:134:0x03a9 A[Catch: all -> 0x02b9, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x02b9, blocks: (B:216:0x06f8, B:223:0x070b, B:280:0x081e, B:288:0x0832, B:298:0x0862, B:235:0x077d, B:247:0x07bd, B:250:0x07c4, B:267:0x07ec, B:265:0x07e3, B:246:0x07b3, B:234:0x0773, B:58:0x026a, B:66:0x0281, B:116:0x0383, B:120:0x038c, B:126:0x0398, B:134:0x03a9, B:181:0x0488, B:186:0x04d3, B:189:0x04d9, B:80:0x02f9, B:93:0x0339, B:96:0x0340, B:104:0x035b, B:103:0x0355, B:92:0x032e, B:79:0x02ef), top: B:386:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:140:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:141:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:145:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:156:0x041f  */
    /* JADX WARN: Code duplicated, block: B:157:0x0421  */
    /* JADX WARN: Code duplicated, block: B:159:0x0424  */
    /* JADX WARN: Code duplicated, block: B:160:0x0425  */
    /* JADX WARN: Code duplicated, block: B:163:0x042b  */
    /* JADX WARN: Code duplicated, block: B:165:0x042e A[Catch: all -> 0x0427, TRY_LEAVE, TryCatch #3 {all -> 0x0427, blocks: (B:154:0x041c, B:165:0x042e), top: B:362:0x041c }] */
    /* JADX WARN: Code duplicated, block: B:167:0x043d  */
    /* JADX WARN: Code duplicated, block: B:172:0x0457 A[Catch: all -> 0x047d, LOOP:0: B:171:0x0455->B:172:0x0457, LOOP_END, TryCatch #18 {all -> 0x047d, blocks: (B:170:0x0451, B:172:0x0457, B:173:0x0473), top: B:391:0x0451 }] */
    /* JADX WARN: Code duplicated, block: B:183:0x04ac  */
    /* JADX WARN: Code duplicated, block: B:186:0x04d3 A[Catch: all -> 0x02b9, TRY_ENTER, TryCatch #15 {all -> 0x02b9, blocks: (B:216:0x06f8, B:223:0x070b, B:280:0x081e, B:288:0x0832, B:298:0x0862, B:235:0x077d, B:247:0x07bd, B:250:0x07c4, B:267:0x07ec, B:265:0x07e3, B:246:0x07b3, B:234:0x0773, B:58:0x026a, B:66:0x0281, B:116:0x0383, B:120:0x038c, B:126:0x0398, B:134:0x03a9, B:181:0x0488, B:186:0x04d3, B:189:0x04d9, B:80:0x02f9, B:93:0x0339, B:96:0x0340, B:104:0x035b, B:103:0x0355, B:92:0x032e, B:79:0x02ef), top: B:386:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:189:0x04d9 A[Catch: all -> 0x02b9, TRY_LEAVE, TryCatch #15 {all -> 0x02b9, blocks: (B:216:0x06f8, B:223:0x070b, B:280:0x081e, B:288:0x0832, B:298:0x0862, B:235:0x077d, B:247:0x07bd, B:250:0x07c4, B:267:0x07ec, B:265:0x07e3, B:246:0x07b3, B:234:0x0773, B:58:0x026a, B:66:0x0281, B:116:0x0383, B:120:0x038c, B:126:0x0398, B:134:0x03a9, B:181:0x0488, B:186:0x04d3, B:189:0x04d9, B:80:0x02f9, B:93:0x0339, B:96:0x0340, B:104:0x035b, B:103:0x0355, B:92:0x032e, B:79:0x02ef), top: B:386:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:191:0x04ed  */
    /* JADX WARN: Code duplicated, block: B:200:0x066a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:201:0x066b  */
    /* JADX WARN: Code duplicated, block: B:209:0x06a4 A[Catch: all -> 0x06a9, TRY_LEAVE, TryCatch #7 {all -> 0x06a9, blocks: (B:207:0x069e, B:209:0x06a4), top: B:370:0x069e }] */
    /* JADX WARN: Code duplicated, block: B:220:0x0703  */
    /* JADX WARN: Code duplicated, block: B:223:0x070b A[Catch: all -> 0x02b9, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x02b9, blocks: (B:216:0x06f8, B:223:0x070b, B:280:0x081e, B:288:0x0832, B:298:0x0862, B:235:0x077d, B:247:0x07bd, B:250:0x07c4, B:267:0x07ec, B:265:0x07e3, B:246:0x07b3, B:234:0x0773, B:58:0x026a, B:66:0x0281, B:116:0x0383, B:120:0x038c, B:126:0x0398, B:134:0x03a9, B:181:0x0488, B:186:0x04d3, B:189:0x04d9, B:80:0x02f9, B:93:0x0339, B:96:0x0340, B:104:0x035b, B:103:0x0355, B:92:0x032e, B:79:0x02ef), top: B:386:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:225:0x0743  */
    /* JADX WARN: Code duplicated, block: B:229:0x0751  */
    /* JADX WARN: Code duplicated, block: B:230:0x0754  */
    /* JADX WARN: Code duplicated, block: B:237:0x0783  */
    /* JADX WARN: Code duplicated, block: B:249:0x07c3  */
    /* JADX WARN: Code duplicated, block: B:266:0x07ea  */
    /* JADX WARN: Code duplicated, block: B:278:0x0816 A[Catch: all -> 0x0998, TRY_LEAVE, TryCatch #38 {all -> 0x0998, blocks: (B:221:0x0705, B:226:0x0745, B:276:0x0811, B:278:0x0816, B:286:0x082a, B:295:0x0846, B:302:0x0893, B:306:0x08c8, B:301:0x0877), top: B:418:0x0705 }] */
    /* JADX WARN: Code duplicated, block: B:280:0x081e A[Catch: all -> 0x02b9, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x02b9, blocks: (B:216:0x06f8, B:223:0x070b, B:280:0x081e, B:288:0x0832, B:298:0x0862, B:235:0x077d, B:247:0x07bd, B:250:0x07c4, B:267:0x07ec, B:265:0x07e3, B:246:0x07b3, B:234:0x0773, B:58:0x026a, B:66:0x0281, B:116:0x0383, B:120:0x038c, B:126:0x0398, B:134:0x03a9, B:181:0x0488, B:186:0x04d3, B:189:0x04d9, B:80:0x02f9, B:93:0x0339, B:96:0x0340, B:104:0x035b, B:103:0x0355, B:92:0x032e, B:79:0x02ef), top: B:386:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:284:0x0827  */
    /* JADX WARN: Code duplicated, block: B:286:0x082a A[Catch: all -> 0x0998, TRY_ENTER, TRY_LEAVE, TryCatch #38 {all -> 0x0998, blocks: (B:221:0x0705, B:226:0x0745, B:276:0x0811, B:278:0x0816, B:286:0x082a, B:295:0x0846, B:302:0x0893, B:306:0x08c8, B:301:0x0877), top: B:418:0x0705 }] */
    /* JADX WARN: Code duplicated, block: B:288:0x0832 A[Catch: all -> 0x02b9, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x02b9, blocks: (B:216:0x06f8, B:223:0x070b, B:280:0x081e, B:288:0x0832, B:298:0x0862, B:235:0x077d, B:247:0x07bd, B:250:0x07c4, B:267:0x07ec, B:265:0x07e3, B:246:0x07b3, B:234:0x0773, B:58:0x026a, B:66:0x0281, B:116:0x0383, B:120:0x038c, B:126:0x0398, B:134:0x03a9, B:181:0x0488, B:186:0x04d3, B:189:0x04d9, B:80:0x02f9, B:93:0x0339, B:96:0x0340, B:104:0x035b, B:103:0x0355, B:92:0x032e, B:79:0x02ef), top: B:386:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:292:0x083b  */
    /* JADX WARN: Code duplicated, block: B:294:0x083e  */
    /* JADX WARN: Code duplicated, block: B:295:0x0846 A[Catch: all -> 0x0998, TRY_ENTER, TRY_LEAVE, TryCatch #38 {all -> 0x0998, blocks: (B:221:0x0705, B:226:0x0745, B:276:0x0811, B:278:0x0816, B:286:0x082a, B:295:0x0846, B:302:0x0893, B:306:0x08c8, B:301:0x0877), top: B:418:0x0705 }] */
    /* JADX WARN: Code duplicated, block: B:298:0x0862 A[Catch: all -> 0x02b9, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x02b9, blocks: (B:216:0x06f8, B:223:0x070b, B:280:0x081e, B:288:0x0832, B:298:0x0862, B:235:0x077d, B:247:0x07bd, B:250:0x07c4, B:267:0x07ec, B:265:0x07e3, B:246:0x07b3, B:234:0x0773, B:58:0x026a, B:66:0x0281, B:116:0x0383, B:120:0x038c, B:126:0x0398, B:134:0x03a9, B:181:0x0488, B:186:0x04d3, B:189:0x04d9, B:80:0x02f9, B:93:0x0339, B:96:0x0340, B:104:0x035b, B:103:0x0355, B:92:0x032e, B:79:0x02ef), top: B:386:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:300:0x0875  */
    /* JADX WARN: Code duplicated, block: B:304:0x08c5  */
    /* JADX WARN: Code duplicated, block: B:305:0x08c7  */
    /* JADX WARN: Code duplicated, block: B:311:0x0941 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:312:0x0942  */
    /* JADX WARN: Code duplicated, block: B:322:0x0963  */
    /* JADX WARN: Code duplicated, block: B:338:0x09c4  */
    /* JADX WARN: Code duplicated, block: B:362:0x041c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:364:0x0306 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:370:0x069e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:376:0x0789 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:380:0x0201 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:393:0x0694 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:413:0x020b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:426:0x07ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:430:0x0346 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0211 A[Catch: all -> 0x0216, TRY_LEAVE, TryCatch #34 {all -> 0x0216, blocks: (B:47:0x020b, B:49:0x0211), top: B:413:0x020b }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0277  */
    /* JADX WARN: Code duplicated, block: B:66:0x0281 A[Catch: all -> 0x02b9, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x02b9, blocks: (B:216:0x06f8, B:223:0x070b, B:280:0x081e, B:288:0x0832, B:298:0x0862, B:235:0x077d, B:247:0x07bd, B:250:0x07c4, B:267:0x07ec, B:265:0x07e3, B:246:0x07b3, B:234:0x0773, B:58:0x026a, B:66:0x0281, B:116:0x0383, B:120:0x038c, B:126:0x0398, B:134:0x03a9, B:181:0x0488, B:186:0x04d3, B:189:0x04d9, B:80:0x02f9, B:93:0x0339, B:96:0x0340, B:104:0x035b, B:103:0x0355, B:92:0x032e, B:79:0x02ef), top: B:386:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:74:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:75:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:82:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:95:0x033f  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v123 */
    /* JADX WARN: Type inference failed for: r0v124 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v248 */
    /* JADX WARN: Type inference failed for: r0v96 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r44v1 */
    /* JADX WARN: Type inference failed for: r44v2 */
    /* JADX WARN: Type inference failed for: r44v5 */
    /* JADX WARN: Type inference failed for: r44v8 */
    /* JADX WARN: Type inference failed for: r44v9 */
    /* JADX WARN: Type inference failed for: r45v0 */
    /* JADX WARN: Type inference failed for: r45v1 */
    /* JADX WARN: Type inference failed for: r45v4 */
    /* JADX WARN: Type inference failed for: r45v6 */
    /* JADX WARN: Type inference failed for: r45v7 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r58v10 */
    /* JADX WARN: Type inference failed for: r58v4 */
    /* JADX WARN: Type inference failed for: r58v5 */
    /* JADX WARN: Type inference failed for: r58v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [boolean] */
    public final Object performRegistration(boolean z, boolean z2, Continuation<? super RegOutcome> continuation) {
        C00181 c00181;
        ?? r7;
        ?? r6;
        String str;
        String str2;
        String str3;
        int i;
        String str4;
        ?? r0;
        ?? r4;
        NiceResponse niceResponse;
        String str5;
        Long longOrNull;
        String text;
        Object obj;
        String str6;
        String str7;
        Object obj2;
        Object obj3;
        ChallengeResponse challengeResponse;
        String challenge_id;
        String str8;
        String challenge;
        String str9;
        String str10;
        boolean z3;
        String str11;
        boolean z4;
        byte[] bArrDecode;
        PrivateKey privateKey;
        PublicKey publicKey;
        ECPublicKey eCPublicKey;
        AniVortexRegistration aniVortexRegistration;
        ArrayList arrayListListOf;
        PrivateKey privateKey2;
        String str12;
        Signature signature;
        String strB64UrlNoPad;
        String strJoinToString$default;
        List list;
        String str13;
        ?? r44;
        ?? r45;
        PrivateKey privateKey3;
        String str14;
        String str15;
        String str16;
        boolean z5;
        Object objPost$default;
        ChallengeResponse challengeResponse2;
        List list2;
        String str17;
        ?? r1;
        byte[] bArr;
        String str18;
        NiceResponse niceResponse2;
        Signature signature2;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        PrivateKey privateKey4;
        KeyPair keyPairPerformRegistration$generateAttestedKey;
        PrivateKey privateKey5;
        Certificate[] certificateChain;
        boolean z6;
        boolean z7;
        ArrayList arrayList;
        int length;
        int i2;
        ?? r5;
        NiceResponse niceResponse3;
        String str24;
        Long longOrNull2;
        String text2;
        Object obj4;
        Object objDecodeFromString;
        DeserializationStrategy deserializationStrategy;
        String str25;
        RegisterResponse registerResponse;
        String installation_id;
        boolean z8;
        String key_id;
        boolean z9;
        boolean z10;
        boolean z11;
        ?? r3;
        ?? r58;
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
        C00181 c00182 = c00181;
        ?? r8 = c00182.result;
        ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c00182.label;
        long jLongValue = 60;
        String str26 = TAG;
        try {
            try {
                switch (i3) {
                    case 0:
                        ResultKt.throwOnFailure((Object) r8);
                        try {
                            Log.i(TAG, "Attempting registration flow (attested=" + (z) + ", deviceProps=" + (z2) + ")...");
                            Requests app = MainActivityKt.getApp();
                            try {
                                Map<String, String> map = regHeaders;
                                RequestBody requestBodyCreate = RequestBody.Companion.create("{\"platform\":\"android\",\"package_name\":\"app.anivortex.mobile\",\"version_name\":\"5.0.1\",\"version_code\":503}", MediaType.Companion.parse("application/json; charset=utf-8"));
                                c00182.L$0 = SpillingKt.nullOutSpilledVariable("{\"platform\":\"android\",\"package_name\":\"app.anivortex.mobile\",\"version_name\":\"5.0.1\",\"version_code\":503}");
                                c00182.Z$0 = z;
                                c00182.Z$1 = z2;
                                c00182.label = 1;
                                ?? r9 = coroutine_suspended;
                                str = "retry-after";
                                str2 = " seconds.";
                                str3 = TAG;
                                i = 429;
                                try {
                                    Object objPost$default2 = Requests.post$default(app, "https://api.anivortex.in/api/v1/install/challenge", map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00182, 65276, (Object) null);
                                    c00182 = c00182;
                                    if (objPost$default2 == r9) {
                                        return r9;
                                    }
                                    coroutine_suspended = z2;
                                    str4 = "{\"platform\":\"android\",\"package_name\":\"app.anivortex.mobile\",\"version_name\":\"5.0.1\",\"version_code\":503}";
                                    r0 = objPost$default2;
                                    r8 = z;
                                    r4 = r9;
                                    try {
                                        niceResponse = (NiceResponse) r0;
                                        if (niceResponse.getCode() != i) {
                                            str26 = str3;
                                            try {
                                                if (!niceResponse.isSuccessful()) {
                                                    lastFailure = "Challenge failed (HTTP " + niceResponse.getCode() + "): " + StringsKt.take(niceResponse.getText(), 120);
                                                    String str27 = lastFailure;
                                                    Intrinsics.checkNotNull(str27);
                                                    Log.w(str26, str27);
                                                    return RegOutcome.SERVER_REJECTED;
                                                }
                                                AppUtils appUtils = AppUtils.INSTANCE;
                                                text = niceResponse.getText();
                                                if (text != null) {
                                                    str6 = " (headers: ";
                                                    str7 = "): ";
                                                    obj2 = null;
                                                } else {
                                                    try {
                                                        Result.Companion companion = Result.Companion;
                                                        KType kTypeTypeOf = Reflection.typeOf(ChallengeResponse.class);
                                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                                        break;
                                                    } catch (Throwable th) {
                                                        try {
                                                            Result.Companion companion2 = Result.Companion;
                                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                                        } catch (Exception e) {
                                                            str6 = " (headers: ";
                                                            str7 = "): ";
                                                            obj2 = null;
                                                            challengeResponse = (ChallengeResponse) obj2;
                                                            if (challengeResponse != null) {
                                                                challenge_id = challengeResponse.getChallenge_id();
                                                            } else {
                                                                challenge_id = null;
                                                            }
                                                            str8 = challenge_id;
                                                            if (challengeResponse != null) {
                                                                challenge = challengeResponse.getChallenge();
                                                            } else {
                                                                challenge = null;
                                                            }
                                                            str9 = challenge;
                                                            str10 = str8;
                                                            if (str10 != null) {
                                                                z3 = true;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            if (!z3) {
                                                                str11 = str9;
                                                                if (str11 != null) {
                                                                    z4 = true;
                                                                } else {
                                                                    z4 = true;
                                                                }
                                                                if (!z4) {
                                                                    bArrDecode = Base64.decode(str9, 11);
                                                                    if (r8 != 0) {
                                                                        try {
                                                                            try {
                                                                                keyPairPerformRegistration$generateAttestedKey = performRegistration$generateAttestedKey(bArrDecode, true);
                                                                            } catch (Throwable th2) {
                                                                                th = th2;
                                                                            }
                                                                        } catch (Throwable th3) {
                                                                            Log.i(str26, "StrongBox unavailable (" + th3.getMessage() + "), falling back to standard TEE KeyStore...");
                                                                            keyPairPerformRegistration$generateAttestedKey = performRegistration$generateAttestedKey(bArrDecode, false);
                                                                        }
                                                                        privateKey5 = keyPairPerformRegistration$generateAttestedKey.getPrivate();
                                                                        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                                                                        try {
                                                                            keyStore.load(null);
                                                                            certificateChain = keyStore.getCertificateChain(KEYSTORE_ALIAS);
                                                                            if (certificateChain == null) {
                                                                                z7 = true;
                                                                                if (z7) {
                                                                                    lastFailure = "AndroidKeyStore returned no attestation chain";
                                                                                    String str28 = lastFailure;
                                                                                    Intrinsics.checkNotNull(str28);
                                                                                    Log.w(str26, str28);
                                                                                    return RegOutcome.FAILED;
                                                                                }
                                                                                arrayList = new ArrayList(certificateChain.length);
                                                                                i2 = 0;
                                                                                for (length = certificateChain.length; i2 < length; length = length) {
                                                                                    arrayList.add(Base64.encodeToString(certificateChain[i2].getEncoded(), 2));
                                                                                    i2++;
                                                                                }
                                                                                arrayListListOf = arrayList;
                                                                                aniVortexRegistration = this;
                                                                                privateKey2 = privateKey5;
                                                                                lastFailure = "Attested keygen failed: " + th.getMessage();
                                                                                String str29 = lastFailure;
                                                                                Intrinsics.checkNotNull(str29);
                                                                                Log.w(str26, str29);
                                                                                return RegOutcome.FAILED;
                                                                            }
                                                                            try {
                                                                                if (certificateChain.length == 0) {
                                                                                    z6 = true;
                                                                                } else {
                                                                                    z6 = false;
                                                                                }
                                                                                if (z6) {
                                                                                    z7 = true;
                                                                                } else {
                                                                                    z7 = false;
                                                                                }
                                                                                if (z7) {
                                                                                    lastFailure = "AndroidKeyStore returned no attestation chain";
                                                                                    String str210 = lastFailure;
                                                                                    Intrinsics.checkNotNull(str210);
                                                                                    Log.w(str26, str210);
                                                                                    return RegOutcome.FAILED;
                                                                                }
                                                                                arrayList = new ArrayList(certificateChain.length);
                                                                                try {
                                                                                    i2 = 0;
                                                                                    while (i2 < length) {
                                                                                        arrayList.add(Base64.encodeToString(certificateChain[i2].getEncoded(), 2));
                                                                                        i2++;
                                                                                    }
                                                                                    arrayListListOf = arrayList;
                                                                                    aniVortexRegistration = this;
                                                                                    privateKey2 = privateKey5;
                                                                                } catch (Throwable th4) {
                                                                                    th = th4;
                                                                                }
                                                                            } catch (Throwable th5) {
                                                                                th = th5;
                                                                            }
                                                                            lastFailure = "Attested keygen failed: " + th.getMessage();
                                                                            String str211 = lastFailure;
                                                                            Intrinsics.checkNotNull(str211);
                                                                            Log.w(str26, str211);
                                                                            return RegOutcome.FAILED;
                                                                        } catch (Throwable th6) {
                                                                            th = th6;
                                                                        }
                                                                        break;
                                                                    } else {
                                                                        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
                                                                        keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1"));
                                                                        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
                                                                        privateKey = keyPairGenerateKeyPair.getPrivate();
                                                                        publicKey = keyPairGenerateKeyPair.getPublic();
                                                                        if (publicKey instanceof ECPublicKey) {
                                                                            eCPublicKey = (ECPublicKey) publicKey;
                                                                        } else {
                                                                            eCPublicKey = null;
                                                                        }
                                                                        if (eCPublicKey == null) {
                                                                            AniVortexRegistration aniVortexRegistration2 = this;
                                                                            lastFailure = "Generated software key is not EC";
                                                                            String str30 = lastFailure;
                                                                            Intrinsics.checkNotNull(str30);
                                                                            Log.w(str26, str30);
                                                                            return RegOutcome.FAILED;
                                                                        }
                                                                        aniVortexRegistration = this;
                                                                        try {
                                                                            byte[] bArrBuildLeafCertificate = aniVortexRegistration.buildLeafCertificate(privateKey, eCPublicKey);
                                                                            CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArrBuildLeafCertificate));
                                                                            String strEncodeToString = Base64.encodeToString(bArrBuildLeafCertificate, 2);
                                                                            arrayListListOf = CollectionsKt.listOf(new String[]{strEncodeToString, strEncodeToString});
                                                                            privateKey2 = privateKey;
                                                                        } catch (Throwable th7) {
                                                                            th = th7;
                                                                            r6 = r8;
                                                                            r7 = coroutine_suspended;
                                                                        }
                                                                    }
                                                                    str12 = "ANIVORTEX-INSTALL-REGISTER-V1\n" + str8 + '\n' + aniVortexRegistration.b64UrlNoPad(aniVortexRegistration.sha256(bArrDecode));
                                                                    signature = Signature.getInstance("SHA256withECDSA");
                                                                    signature.initSign(privateKey2);
                                                                    byte[] bytes = str12.getBytes(Charsets.UTF_8);
                                                                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                                                                    signature.update(bytes);
                                                                    strB64UrlNoPad = aniVortexRegistration.b64UrlNoPad(signature.sign());
                                                                    strJoinToString$default = CollectionsKt.joinToString$default(arrayListListOf, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.AniVortex.AniVortexRegistration$$ExternalSyntheticLambda0
                                                                        public final Object invoke(Object obj5) {
                                                                            return AniVortexRegistration.performRegistration$lambda$4((String) obj5);
                                                                        }
                                                                    }, 30, (Object) null);
                                                                    list = arrayListListOf;
                                                                    try {
                                                                        str13 = "{\"challenge_id\":\"" + str8 + "\",\"certificate_chain\":[" + strJoinToString$default + "],\"proof_signature\":\"" + strB64UrlNoPad + "\"}";
                                                                        Requests app2 = MainActivityKt.getApp();
                                                                        Map<String, String> map2 = regHeaders;
                                                                        RequestBody requestBodyCreate2 = RequestBody.Companion.create(str13, MediaType.Companion.parse("application/json; charset=utf-8"));
                                                                        c00182.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                                                                        c00182.L$1 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                                                        c00182.L$2 = SpillingKt.nullOutSpilledVariable((Object) r2);
                                                                        c00182.L$3 = SpillingKt.nullOutSpilledVariable(str8);
                                                                        c00182.L$4 = SpillingKt.nullOutSpilledVariable(str9);
                                                                        c00182.L$5 = SpillingKt.nullOutSpilledVariable(bArrDecode);
                                                                        c00182.L$6 = privateKey2;
                                                                        c00182.L$7 = SpillingKt.nullOutSpilledVariable(list);
                                                                        c00182.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                                                        c00182.L$9 = SpillingKt.nullOutSpilledVariable(signature);
                                                                        c00182.L$10 = SpillingKt.nullOutSpilledVariable(strB64UrlNoPad);
                                                                        c00182.L$11 = SpillingKt.nullOutSpilledVariable(strJoinToString$default);
                                                                        c00182.L$12 = SpillingKt.nullOutSpilledVariable(str13);
                                                                        c00182.Z$0 = r8;
                                                                        c00182.Z$1 = coroutine_suspended;
                                                                        c00182.label = 2;
                                                                        r44 = r8;
                                                                        r45 = coroutine_suspended;
                                                                        C00181 c00183 = c00182;
                                                                        privateKey3 = privateKey2;
                                                                        str14 = str7;
                                                                        str15 = str6;
                                                                        str16 = str26;
                                                                        z5 = true;
                                                                        try {
                                                                            objPost$default = Requests.post$default(app2, "https://api.anivortex.in/api/v1/install/register", map2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00183, 65276, (Object) null);
                                                                            c00182 = c00183;
                                                                            if (objPost$default == r4) {
                                                                                return r4;
                                                                            }
                                                                            challengeResponse2 = challengeResponse;
                                                                            list2 = list;
                                                                            str17 = str13;
                                                                            r1 = objPost$default;
                                                                            bArr = bArrDecode;
                                                                            str18 = str4;
                                                                            niceResponse2 = niceResponse;
                                                                            signature2 = signature;
                                                                            str19 = strB64UrlNoPad;
                                                                            str20 = strJoinToString$default;
                                                                            r8 = r44 == true ? 1 : 0;
                                                                            coroutine_suspended = r45 == true ? 1 : 0;
                                                                            str21 = str8;
                                                                            str22 = str9;
                                                                            str23 = str12;
                                                                            privateKey4 = privateKey3;
                                                                            r5 = r4;
                                                                            try {
                                                                                niceResponse3 = (NiceResponse) r1;
                                                                                if (niceResponse3.getCode() != 429) {
                                                                                    str26 = str16;
                                                                                    try {
                                                                                        if (!niceResponse3.isSuccessful()) {
                                                                                            lastFailure = "Register rejected (HTTP " + niceResponse3.getCode() + str14 + StringsKt.take(niceResponse3.getText(), 120);
                                                                                            String str31 = lastFailure;
                                                                                            Intrinsics.checkNotNull(str31);
                                                                                            Log.w(str26, str31);
                                                                                            return RegOutcome.SERVER_REJECTED;
                                                                                        }
                                                                                        AppUtils appUtils2 = AppUtils.INSTANCE;
                                                                                        text2 = niceResponse3.getText();
                                                                                        if (text2 != null) {
                                                                                            objDecodeFromString = null;
                                                                                        } else {
                                                                                            try {
                                                                                                Result.Companion companion3 = Result.Companion;
                                                                                                KType kTypeTypeOf2 = Reflection.typeOf(RegisterResponse.class);
                                                                                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                                                                obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                                                                                break;
                                                                                            } catch (Throwable th8) {
                                                                                                try {
                                                                                                    Result.Companion companion4 = Result.Companion;
                                                                                                    obj4 = Result.constructor-impl(ResultKt.createFailure(th8));
                                                                                                } catch (Exception e2) {
                                                                                                    objDecodeFromString = null;
                                                                                                    registerResponse = (RegisterResponse) objDecodeFromString;
                                                                                                    if (registerResponse != null) {
                                                                                                        installation_id = registerResponse.getInstallation_id();
                                                                                                        if (installation_id != null) {
                                                                                                            z8 = true;
                                                                                                        } else {
                                                                                                            z8 = true;
                                                                                                        }
                                                                                                        if (!z8) {
                                                                                                            key_id = registerResponse.getKey_id();
                                                                                                            if (key_id != null) {
                                                                                                                z9 = true;
                                                                                                            } else {
                                                                                                                z9 = true;
                                                                                                            }
                                                                                                            if (!z9) {
                                                                                                                CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", registerResponse.getInstallation_id());
                                                                                                                CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", registerResponse.getKey_id());
                                                                                                                if (r8 != 0) {
                                                                                                                    CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z5));
                                                                                                                    CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", "");
                                                                                                                } else {
                                                                                                                    CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(false));
                                                                                                                    CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey4.getEncoded(), 2));
                                                                                                                    clearKeystoreKey();
                                                                                                                }
                                                                                                                AniVortexAuth.INSTANCE.invalidateCache();
                                                                                                                lastFailure = null;
                                                                                                                StringBuilder sbAppend = new StringBuilder().append("Registration complete! installation_id=").append(r1.getInstallation_id()).append(" key_id=").append(r1.getKey_id()).append(" attested=");
                                                                                                                if (r8 != 0) {
                                                                                                                    z10 = true;
                                                                                                                } else {
                                                                                                                    z10 = false;
                                                                                                                }
                                                                                                                Log.i(str26, sbAppend.append(z10).toString());
                                                                                                                try {
                                                                                                                    c00182.L$0 = SpillingKt.nullOutSpilledVariable(str18);
                                                                                                                    c00182.L$1 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                                                                                                                    c00182.L$2 = SpillingKt.nullOutSpilledVariable(challengeResponse2);
                                                                                                                    c00182.L$3 = SpillingKt.nullOutSpilledVariable(str21);
                                                                                                                    c00182.L$4 = SpillingKt.nullOutSpilledVariable(str22);
                                                                                                                    c00182.L$5 = SpillingKt.nullOutSpilledVariable(bArr);
                                                                                                                    c00182.L$6 = SpillingKt.nullOutSpilledVariable(privateKey4);
                                                                                                                    c00182.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                                                                                                                    c00182.L$8 = SpillingKt.nullOutSpilledVariable(str23);
                                                                                                                    c00182.L$9 = SpillingKt.nullOutSpilledVariable(signature2);
                                                                                                                    c00182.L$10 = SpillingKt.nullOutSpilledVariable(str19);
                                                                                                                    c00182.L$11 = SpillingKt.nullOutSpilledVariable(str20);
                                                                                                                    c00182.L$12 = SpillingKt.nullOutSpilledVariable(str17);
                                                                                                                    c00182.L$13 = SpillingKt.nullOutSpilledVariable(niceResponse3);
                                                                                                                    c00182.L$14 = SpillingKt.nullOutSpilledVariable((Object) r1);
                                                                                                                    c00182.Z$0 = r8;
                                                                                                                    c00182.Z$1 = coroutine_suspended;
                                                                                                                    c00182.label = 3;
                                                                                                                    r58 = r8;
                                                                                                                    try {
                                                                                                                        if (syncInstallationPush$default(this, false, c00182, 1, null) == r5) {
                                                                                                                            return r5;
                                                                                                                        }
                                                                                                                        z11 = r58 == true ? 1 : 0;
                                                                                                                        r3 = coroutine_suspended;
                                                                                                                        try {
                                                                                                                            return RegOutcome.SUCCESS;
                                                                                                                        } catch (Throwable th9) {
                                                                                                                            th = th9;
                                                                                                                            r6 = z11;
                                                                                                                            r7 = r3;
                                                                                                                        }
                                                                                                                    } catch (Throwable th10) {
                                                                                                                        z11 = r58 == true ? 1 : 0;
                                                                                                                        r3 = coroutine_suspended;
                                                                                                                    }
                                                                                                                } catch (Throwable th11) {
                                                                                                                    z11 = r8 == true ? 1 : 0;
                                                                                                                    r3 = coroutine_suspended;
                                                                                                                }
                                                                                                            }
                                                                                                            lastFailure = "Registration error: " + th.getMessage();
                                                                                                            String str32 = lastFailure;
                                                                                                            Intrinsics.checkNotNull(str32);
                                                                                                            Log.w(str26, str32);
                                                                                                            Log.d(str26, "Registration failed stacktrace", th);
                                                                                                            return RegOutcome.FAILED;
                                                                                                        }
                                                                                                    }
                                                                                                    lastFailure = "Register response missing fields: " + StringsKt.take(niceResponse3.getText(), 120);
                                                                                                    String str33 = lastFailure;
                                                                                                    Intrinsics.checkNotNull(str33);
                                                                                                    Log.w(str26, str33);
                                                                                                    return RegOutcome.FAILED;
                                                                                                }
                                                                                            }
                                                                                            if (Result.exceptionOrNull-impl(obj4) == null) {
                                                                                                try {
                                                                                                    Result.Companion companion5 = Result.Companion;
                                                                                                    try {
                                                                                                        obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(RegisterResponse.class), (List) null, 2, (Object) null));
                                                                                                        break;
                                                                                                    } catch (Throwable th12) {
                                                                                                        th = th12;
                                                                                                        try {
                                                                                                            Result.Companion companion6 = Result.Companion;
                                                                                                            obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                                                        } catch (Exception e3) {
                                                                                                            objDecodeFromString = null;
                                                                                                        }
                                                                                                    }
                                                                                                } catch (Throwable th13) {
                                                                                                    th = th13;
                                                                                                }
                                                                                            }
                                                                                            if (Result.isFailure-impl(obj4)) {
                                                                                                obj4 = null;
                                                                                            }
                                                                                            deserializationStrategy = (KSerializer) obj4;
                                                                                            if (deserializationStrategy != null) {
                                                                                                try {
                                                                                                    str25 = text2;
                                                                                                    try {
                                                                                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str25);
                                                                                                    } catch (SerializationException e4) {
                                                                                                        e = e4;
                                                                                                        ArchComponentExtKt.logError((Throwable) e);
                                                                                                        objDecodeFromString = MainAPIKt.getMapper().readValue(str25, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                                                                                                        });
                                                                                                    } catch (Throwable th14) {
                                                                                                        objDecodeFromString = MainAPIKt.getMapper().readValue(str25, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                                                                                                        });
                                                                                                    }
                                                                                                } catch (SerializationException e5) {
                                                                                                    e = e5;
                                                                                                    str25 = text2;
                                                                                                } catch (Throwable th15) {
                                                                                                    str25 = text2;
                                                                                                }
                                                                                            } else {
                                                                                                str25 = text2;
                                                                                            }
                                                                                            objDecodeFromString = MainAPIKt.getMapper().readValue(str25, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                                                                                            });
                                                                                        }
                                                                                        registerResponse = (RegisterResponse) objDecodeFromString;
                                                                                        if (registerResponse != null) {
                                                                                            installation_id = registerResponse.getInstallation_id();
                                                                                            if (installation_id != null) {
                                                                                                z8 = true;
                                                                                            } else {
                                                                                                z8 = true;
                                                                                            }
                                                                                            if (!z8) {
                                                                                                key_id = registerResponse.getKey_id();
                                                                                                if (key_id != null) {
                                                                                                    z9 = true;
                                                                                                } else {
                                                                                                    z9 = true;
                                                                                                }
                                                                                                if (!z9) {
                                                                                                    CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", registerResponse.getInstallation_id());
                                                                                                    CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", registerResponse.getKey_id());
                                                                                                    if (r8 != 0) {
                                                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z5));
                                                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", "");
                                                                                                    } else {
                                                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(false));
                                                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey4.getEncoded(), 2));
                                                                                                        clearKeystoreKey();
                                                                                                    }
                                                                                                    AniVortexAuth.INSTANCE.invalidateCache();
                                                                                                    lastFailure = null;
                                                                                                    StringBuilder sbAppend2 = new StringBuilder().append("Registration complete! installation_id=").append(r1.getInstallation_id()).append(" key_id=").append(r1.getKey_id()).append(" attested=");
                                                                                                    if (r8 != 0) {
                                                                                                        z10 = true;
                                                                                                    } else {
                                                                                                        z10 = false;
                                                                                                    }
                                                                                                    Log.i(str26, sbAppend2.append(z10).toString());
                                                                                                    c00182.L$0 = SpillingKt.nullOutSpilledVariable(str18);
                                                                                                    c00182.L$1 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                                                                                                    c00182.L$2 = SpillingKt.nullOutSpilledVariable(challengeResponse2);
                                                                                                    c00182.L$3 = SpillingKt.nullOutSpilledVariable(str21);
                                                                                                    c00182.L$4 = SpillingKt.nullOutSpilledVariable(str22);
                                                                                                    c00182.L$5 = SpillingKt.nullOutSpilledVariable(bArr);
                                                                                                    c00182.L$6 = SpillingKt.nullOutSpilledVariable(privateKey4);
                                                                                                    c00182.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                                                                                                    c00182.L$8 = SpillingKt.nullOutSpilledVariable(str23);
                                                                                                    c00182.L$9 = SpillingKt.nullOutSpilledVariable(signature2);
                                                                                                    c00182.L$10 = SpillingKt.nullOutSpilledVariable(str19);
                                                                                                    c00182.L$11 = SpillingKt.nullOutSpilledVariable(str20);
                                                                                                    c00182.L$12 = SpillingKt.nullOutSpilledVariable(str17);
                                                                                                    c00182.L$13 = SpillingKt.nullOutSpilledVariable(niceResponse3);
                                                                                                    c00182.L$14 = SpillingKt.nullOutSpilledVariable((Object) r1);
                                                                                                    c00182.Z$0 = r8;
                                                                                                    c00182.Z$1 = coroutine_suspended;
                                                                                                    c00182.label = 3;
                                                                                                    r58 = r8;
                                                                                                    if (syncInstallationPush$default(this, false, c00182, 1, null) == r5) {
                                                                                                        return r5;
                                                                                                    }
                                                                                                    z11 = r58 == true ? 1 : 0;
                                                                                                    r3 = coroutine_suspended;
                                                                                                    return RegOutcome.SUCCESS;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        try {
                                                                                            lastFailure = "Register response missing fields: " + StringsKt.take(niceResponse3.getText(), 120);
                                                                                            String str34 = lastFailure;
                                                                                            Intrinsics.checkNotNull(str34);
                                                                                            Log.w(str26, str34);
                                                                                            return RegOutcome.FAILED;
                                                                                        } catch (Throwable th16) {
                                                                                            th = th16;
                                                                                            r6 = r8;
                                                                                            r7 = coroutine_suspended;
                                                                                        }
                                                                                    } catch (Throwable th17) {
                                                                                        th = th17;
                                                                                        r6 = r8;
                                                                                        r7 = coroutine_suspended;
                                                                                    }
                                                                                    break;
                                                                                } else {
                                                                                    try {
                                                                                        str24 = niceResponse3.getHeaders().get(str);
                                                                                        if (str24 != null) {
                                                                                            try {
                                                                                                longOrNull2 = StringsKt.toLongOrNull(str24);
                                                                                                if (longOrNull2 != null) {
                                                                                                    jLongValue = longOrNull2.longValue();
                                                                                                }
                                                                                            } catch (Throwable th18) {
                                                                                                th = th18;
                                                                                                str26 = str16;
                                                                                                r6 = r8;
                                                                                                r7 = coroutine_suspended;
                                                                                            }
                                                                                            break;
                                                                                        }
                                                                                        long j = jLongValue;
                                                                                        rateLimitUntilMs = System.currentTimeMillis() + (1000 * j);
                                                                                        lastFailure = "Registration rate-limited (HTTP 429: too many requests). Server throttled your IP. Please wait " + j + str2;
                                                                                        Log.w(str16, lastFailure + str15 + niceResponse3.getHeaders() + ')');
                                                                                        return RegOutcome.RATE_LIMITED;
                                                                                    } catch (Throwable th19) {
                                                                                        th = th19;
                                                                                        str26 = str16;
                                                                                        r6 = r8;
                                                                                        r7 = coroutine_suspended;
                                                                                    }
                                                                                }
                                                                            } catch (Throwable th20) {
                                                                                th = th20;
                                                                                str26 = str16;
                                                                                r6 = r8;
                                                                                r7 = coroutine_suspended;
                                                                            }
                                                                        } catch (Throwable th21) {
                                                                            th = th21;
                                                                            str26 = str16;
                                                                            r6 = r44 == true ? 1 : 0;
                                                                            r7 = r45 == true ? 1 : 0;
                                                                        }
                                                                    } catch (Throwable th22) {
                                                                        th = th22;
                                                                        str26 = str26;
                                                                        r6 = r8;
                                                                        r7 = coroutine_suspended;
                                                                    }
                                                                }
                                                                lastFailure = "Registration error: " + th.getMessage();
                                                                String str35 = lastFailure;
                                                                Intrinsics.checkNotNull(str35);
                                                                Log.w(str26, str35);
                                                                Log.d(str26, "Registration failed stacktrace", th);
                                                                return RegOutcome.FAILED;
                                                            }
                                                            lastFailure = "Invalid challenge response: " + StringsKt.take(niceResponse.getText(), 120);
                                                            String str36 = lastFailure;
                                                            Intrinsics.checkNotNull(str36);
                                                            Log.w(str26, str36);
                                                            return RegOutcome.FAILED;
                                                        }
                                                    }
                                                    if (Result.exceptionOrNull-impl(obj) != null) {
                                                        str6 = " (headers: ";
                                                        str7 = "): ";
                                                    } else {
                                                        try {
                                                            Result.Companion companion7 = Result.Companion;
                                                            str6 = " (headers: ";
                                                            str7 = "): ";
                                                            try {
                                                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ChallengeResponse.class), (List) null, 2, (Object) null));
                                                                break;
                                                            } catch (Throwable th23) {
                                                                th = th23;
                                                                try {
                                                                    Result.Companion companion8 = Result.Companion;
                                                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                                                } catch (Exception e6) {
                                                                    obj2 = null;
                                                                }
                                                            }
                                                        } catch (Throwable th24) {
                                                            th = th24;
                                                            str6 = " (headers: ";
                                                            str7 = "): ";
                                                        }
                                                    }
                                                    obj3 = obj;
                                                    if (Result.isFailure-impl(obj3)) {
                                                        obj3 = null;
                                                    }
                                                    DeserializationStrategy deserializationStrategy2 = (KSerializer) obj3;
                                                    if (deserializationStrategy2 != null) {
                                                        try {
                                                        } catch (SerializationException e7) {
                                                            ArchComponentExtKt.logError(e7);
                                                        } catch (Throwable th25) {
                                                        }
                                                    }
                                                    obj2 = objDecodeFromString;
                                                }
                                                challengeResponse = (ChallengeResponse) obj2;
                                                if (challengeResponse != null) {
                                                    challenge_id = challengeResponse.getChallenge_id();
                                                } else {
                                                    challenge_id = null;
                                                }
                                                str8 = challenge_id;
                                                if (challengeResponse != null) {
                                                    challenge = challengeResponse.getChallenge();
                                                } else {
                                                    challenge = null;
                                                }
                                                str9 = challenge;
                                                str10 = str8;
                                                if (str10 != null || str10.length() == 0) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                if (!z3) {
                                                    str11 = str9;
                                                    if (str11 != null || str11.length() == 0) {
                                                        z4 = true;
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    if (!z4) {
                                                        bArrDecode = Base64.decode(str9, 11);
                                                        if (r8 != 0) {
                                                            keyPairPerformRegistration$generateAttestedKey = performRegistration$generateAttestedKey(bArrDecode, true);
                                                            privateKey5 = keyPairPerformRegistration$generateAttestedKey.getPrivate();
                                                            KeyStore keyStore2 = KeyStore.getInstance("AndroidKeyStore");
                                                            keyStore2.load(null);
                                                            certificateChain = keyStore2.getCertificateChain(KEYSTORE_ALIAS);
                                                            if (certificateChain == null) {
                                                                z7 = true;
                                                                if (z7) {
                                                                    lastFailure = "AndroidKeyStore returned no attestation chain";
                                                                    String str212 = lastFailure;
                                                                    Intrinsics.checkNotNull(str212);
                                                                    Log.w(str26, str212);
                                                                    return RegOutcome.FAILED;
                                                                }
                                                                arrayList = new ArrayList(certificateChain.length);
                                                                i2 = 0;
                                                                while (i2 < length) {
                                                                    arrayList.add(Base64.encodeToString(certificateChain[i2].getEncoded(), 2));
                                                                    i2++;
                                                                }
                                                                arrayListListOf = arrayList;
                                                                aniVortexRegistration = this;
                                                                privateKey2 = privateKey5;
                                                                lastFailure = "Attested keygen failed: " + th.getMessage();
                                                                String str213 = lastFailure;
                                                                Intrinsics.checkNotNull(str213);
                                                                Log.w(str26, str213);
                                                                return RegOutcome.FAILED;
                                                            }
                                                            if (certificateChain.length == 0) {
                                                                z6 = true;
                                                            } else {
                                                                z6 = false;
                                                            }
                                                            if (z6) {
                                                                z7 = true;
                                                            } else {
                                                                z7 = false;
                                                            }
                                                            if (z7) {
                                                                lastFailure = "AndroidKeyStore returned no attestation chain";
                                                                String str214 = lastFailure;
                                                                Intrinsics.checkNotNull(str214);
                                                                Log.w(str26, str214);
                                                                return RegOutcome.FAILED;
                                                            }
                                                            arrayList = new ArrayList(certificateChain.length);
                                                            i2 = 0;
                                                            while (i2 < length) {
                                                                arrayList.add(Base64.encodeToString(certificateChain[i2].getEncoded(), 2));
                                                                i2++;
                                                            }
                                                            arrayListListOf = arrayList;
                                                            aniVortexRegistration = this;
                                                            privateKey2 = privateKey5;
                                                            lastFailure = "Attested keygen failed: " + th.getMessage();
                                                            String str215 = lastFailure;
                                                            Intrinsics.checkNotNull(str215);
                                                            Log.w(str26, str215);
                                                            return RegOutcome.FAILED;
                                                        }
                                                        KeyPairGenerator keyPairGenerator2 = KeyPairGenerator.getInstance("EC");
                                                        keyPairGenerator2.initialize(new ECGenParameterSpec("secp256r1"));
                                                        KeyPair keyPairGenerateKeyPair2 = keyPairGenerator2.generateKeyPair();
                                                        privateKey = keyPairGenerateKeyPair2.getPrivate();
                                                        publicKey = keyPairGenerateKeyPair2.getPublic();
                                                        if (publicKey instanceof ECPublicKey) {
                                                            eCPublicKey = (ECPublicKey) publicKey;
                                                        } else {
                                                            eCPublicKey = null;
                                                        }
                                                        if (eCPublicKey == null) {
                                                            AniVortexRegistration aniVortexRegistration3 = this;
                                                            lastFailure = "Generated software key is not EC";
                                                            String str37 = lastFailure;
                                                            Intrinsics.checkNotNull(str37);
                                                            Log.w(str26, str37);
                                                            return RegOutcome.FAILED;
                                                        }
                                                        aniVortexRegistration = this;
                                                        byte[] bArrBuildLeafCertificate2 = aniVortexRegistration.buildLeafCertificate(privateKey, eCPublicKey);
                                                        CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArrBuildLeafCertificate2));
                                                        String strEncodeToString2 = Base64.encodeToString(bArrBuildLeafCertificate2, 2);
                                                        arrayListListOf = CollectionsKt.listOf(new String[]{strEncodeToString2, strEncodeToString2});
                                                        privateKey2 = privateKey;
                                                        str12 = "ANIVORTEX-INSTALL-REGISTER-V1\n" + str8 + '\n' + aniVortexRegistration.b64UrlNoPad(aniVortexRegistration.sha256(bArrDecode));
                                                        signature = Signature.getInstance("SHA256withECDSA");
                                                        signature.initSign(privateKey2);
                                                        byte[] bytes2 = str12.getBytes(Charsets.UTF_8);
                                                        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                                                        signature.update(bytes2);
                                                        strB64UrlNoPad = aniVortexRegistration.b64UrlNoPad(signature.sign());
                                                        strJoinToString$default = CollectionsKt.joinToString$default(arrayListListOf, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.AniVortex.AniVortexRegistration$$ExternalSyntheticLambda0
                                                            public final Object invoke(Object obj5) {
                                                                return AniVortexRegistration.performRegistration$lambda$4((String) obj5);
                                                            }
                                                        }, 30, (Object) null);
                                                        list = arrayListListOf;
                                                        str13 = "{\"challenge_id\":\"" + str8 + "\",\"certificate_chain\":[" + strJoinToString$default + "],\"proof_signature\":\"" + strB64UrlNoPad + "\"}";
                                                        Requests app3 = MainActivityKt.getApp();
                                                        Map<String, String> map3 = regHeaders;
                                                        RequestBody requestBodyCreate3 = RequestBody.Companion.create(str13, MediaType.Companion.parse("application/json; charset=utf-8"));
                                                        c00182.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                                                        c00182.L$1 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                                        c00182.L$2 = SpillingKt.nullOutSpilledVariable((Object) r2);
                                                        c00182.L$3 = SpillingKt.nullOutSpilledVariable(str8);
                                                        c00182.L$4 = SpillingKt.nullOutSpilledVariable(str9);
                                                        c00182.L$5 = SpillingKt.nullOutSpilledVariable(bArrDecode);
                                                        c00182.L$6 = privateKey2;
                                                        c00182.L$7 = SpillingKt.nullOutSpilledVariable(list);
                                                        c00182.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                                        c00182.L$9 = SpillingKt.nullOutSpilledVariable(signature);
                                                        c00182.L$10 = SpillingKt.nullOutSpilledVariable(strB64UrlNoPad);
                                                        c00182.L$11 = SpillingKt.nullOutSpilledVariable(strJoinToString$default);
                                                        c00182.L$12 = SpillingKt.nullOutSpilledVariable(str13);
                                                        c00182.Z$0 = r8;
                                                        c00182.Z$1 = coroutine_suspended;
                                                        c00182.label = 2;
                                                        r44 = r8;
                                                        r45 = coroutine_suspended;
                                                        C00181 c00184 = c00182;
                                                        privateKey3 = privateKey2;
                                                        str14 = str7;
                                                        str15 = str6;
                                                        str16 = str26;
                                                        z5 = true;
                                                        objPost$default = Requests.post$default(app3, "https://api.anivortex.in/api/v1/install/register", map3, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate3, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00184, 65276, (Object) null);
                                                        c00182 = c00184;
                                                        if (objPost$default == r4) {
                                                            return r4;
                                                        }
                                                        challengeResponse2 = challengeResponse;
                                                        list2 = list;
                                                        str17 = str13;
                                                        r1 = objPost$default;
                                                        bArr = bArrDecode;
                                                        str18 = str4;
                                                        niceResponse2 = niceResponse;
                                                        signature2 = signature;
                                                        str19 = strB64UrlNoPad;
                                                        str20 = strJoinToString$default;
                                                        r8 = r44 == true ? 1 : 0;
                                                        coroutine_suspended = r45 == true ? 1 : 0;
                                                        str21 = str8;
                                                        str22 = str9;
                                                        str23 = str12;
                                                        privateKey4 = privateKey3;
                                                        r5 = r4;
                                                        niceResponse3 = (NiceResponse) r1;
                                                        if (niceResponse3.getCode() != 429) {
                                                            str24 = niceResponse3.getHeaders().get(str);
                                                            if (str24 != null) {
                                                                longOrNull2 = StringsKt.toLongOrNull(str24);
                                                                if (longOrNull2 != null) {
                                                                    jLongValue = longOrNull2.longValue();
                                                                }
                                                                break;
                                                            }
                                                            long j2 = jLongValue;
                                                            rateLimitUntilMs = System.currentTimeMillis() + (1000 * j2);
                                                            lastFailure = "Registration rate-limited (HTTP 429: too many requests). Server throttled your IP. Please wait " + j2 + str2;
                                                            Log.w(str16, lastFailure + str15 + niceResponse3.getHeaders() + ')');
                                                            return RegOutcome.RATE_LIMITED;
                                                        }
                                                        str26 = str16;
                                                        if (!niceResponse3.isSuccessful()) {
                                                            lastFailure = "Register rejected (HTTP " + niceResponse3.getCode() + str14 + StringsKt.take(niceResponse3.getText(), 120);
                                                            String str38 = lastFailure;
                                                            Intrinsics.checkNotNull(str38);
                                                            Log.w(str26, str38);
                                                            return RegOutcome.SERVER_REJECTED;
                                                        }
                                                        AppUtils appUtils3 = AppUtils.INSTANCE;
                                                        text2 = niceResponse3.getText();
                                                        if (text2 != null) {
                                                            Result.Companion companion9 = Result.Companion;
                                                            KType kTypeTypeOf3 = Reflection.typeOf(RegisterResponse.class);
                                                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                            obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                                            if (Result.exceptionOrNull-impl(obj4) == null) {
                                                                Result.Companion companion10 = Result.Companion;
                                                                obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(RegisterResponse.class), (List) null, 2, (Object) null));
                                                                break;
                                                            }
                                                            if (Result.isFailure-impl(obj4)) {
                                                                obj4 = null;
                                                            }
                                                            deserializationStrategy = (KSerializer) obj4;
                                                            if (deserializationStrategy != null) {
                                                                str25 = text2;
                                                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str25);
                                                            } else {
                                                                str25 = text2;
                                                            }
                                                            objDecodeFromString = MainAPIKt.getMapper().readValue(str25, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                                                            });
                                                            break;
                                                        } else {
                                                            objDecodeFromString = null;
                                                        }
                                                        registerResponse = (RegisterResponse) objDecodeFromString;
                                                        if (registerResponse != null) {
                                                            installation_id = registerResponse.getInstallation_id();
                                                            if (installation_id != null || installation_id.length() == 0) {
                                                                z8 = true;
                                                            } else {
                                                                z8 = false;
                                                            }
                                                            if (!z8) {
                                                                key_id = registerResponse.getKey_id();
                                                                if (key_id != null || key_id.length() == 0) {
                                                                    z9 = true;
                                                                } else {
                                                                    z9 = false;
                                                                }
                                                                if (!z9) {
                                                                    CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", registerResponse.getInstallation_id());
                                                                    CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", registerResponse.getKey_id());
                                                                    if (r8 != 0) {
                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z5));
                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", "");
                                                                    } else {
                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(false));
                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey4.getEncoded(), 2));
                                                                        clearKeystoreKey();
                                                                    }
                                                                    AniVortexAuth.INSTANCE.invalidateCache();
                                                                    lastFailure = null;
                                                                    StringBuilder sbAppend3 = new StringBuilder().append("Registration complete! installation_id=").append(r1.getInstallation_id()).append(" key_id=").append(r1.getKey_id()).append(" attested=");
                                                                    if (r8 != 0) {
                                                                        z10 = true;
                                                                    } else {
                                                                        z10 = false;
                                                                    }
                                                                    Log.i(str26, sbAppend3.append(z10).toString());
                                                                    c00182.L$0 = SpillingKt.nullOutSpilledVariable(str18);
                                                                    c00182.L$1 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                                                                    c00182.L$2 = SpillingKt.nullOutSpilledVariable(challengeResponse2);
                                                                    c00182.L$3 = SpillingKt.nullOutSpilledVariable(str21);
                                                                    c00182.L$4 = SpillingKt.nullOutSpilledVariable(str22);
                                                                    c00182.L$5 = SpillingKt.nullOutSpilledVariable(bArr);
                                                                    c00182.L$6 = SpillingKt.nullOutSpilledVariable(privateKey4);
                                                                    c00182.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                                                                    c00182.L$8 = SpillingKt.nullOutSpilledVariable(str23);
                                                                    c00182.L$9 = SpillingKt.nullOutSpilledVariable(signature2);
                                                                    c00182.L$10 = SpillingKt.nullOutSpilledVariable(str19);
                                                                    c00182.L$11 = SpillingKt.nullOutSpilledVariable(str20);
                                                                    c00182.L$12 = SpillingKt.nullOutSpilledVariable(str17);
                                                                    c00182.L$13 = SpillingKt.nullOutSpilledVariable(niceResponse3);
                                                                    c00182.L$14 = SpillingKt.nullOutSpilledVariable((Object) r1);
                                                                    c00182.Z$0 = r8;
                                                                    c00182.Z$1 = coroutine_suspended;
                                                                    c00182.label = 3;
                                                                    r58 = r8;
                                                                    if (syncInstallationPush$default(this, false, c00182, 1, null) == r5) {
                                                                        return r5;
                                                                    }
                                                                    z11 = r58 == true ? 1 : 0;
                                                                    r3 = coroutine_suspended;
                                                                    return RegOutcome.SUCCESS;
                                                                }
                                                            }
                                                        }
                                                        lastFailure = "Register response missing fields: " + StringsKt.take(niceResponse3.getText(), 120);
                                                        String str39 = lastFailure;
                                                        Intrinsics.checkNotNull(str39);
                                                        Log.w(str26, str39);
                                                        return RegOutcome.FAILED;
                                                    }
                                                }
                                                try {
                                                    lastFailure = "Invalid challenge response: " + StringsKt.take(niceResponse.getText(), 120);
                                                    String str310 = lastFailure;
                                                    Intrinsics.checkNotNull(str310);
                                                    Log.w(str26, str310);
                                                    return RegOutcome.FAILED;
                                                } catch (Throwable th26) {
                                                    th = th26;
                                                    r6 = r8;
                                                    r7 = coroutine_suspended;
                                                }
                                            } catch (Throwable th27) {
                                                th = th27;
                                                r6 = r8;
                                                r7 = coroutine_suspended;
                                            }
                                            break;
                                        } else {
                                            try {
                                                str5 = niceResponse.getHeaders().get(str);
                                                if (str5 != null) {
                                                    try {
                                                        longOrNull = StringsKt.toLongOrNull(str5);
                                                        if (longOrNull != null) {
                                                            jLongValue = longOrNull.longValue();
                                                        }
                                                    } catch (Throwable th28) {
                                                        th = th28;
                                                        str26 = str3;
                                                        r6 = r8;
                                                        r7 = coroutine_suspended;
                                                    }
                                                    break;
                                                }
                                                long j3 = jLongValue;
                                                long jCurrentTimeMillis = System.currentTimeMillis();
                                                Long.signum(j3);
                                                rateLimitUntilMs = jCurrentTimeMillis + (1000 * j3);
                                                lastFailure = "Challenge rate-limited (HTTP 429: too many requests). Server throttled your IP. Please wait " + j3 + str2;
                                                Log.w(str3, lastFailure + r19 + niceResponse.getHeaders() + ')');
                                                return RegOutcome.RATE_LIMITED;
                                            } catch (Throwable th29) {
                                                th = th29;
                                                str26 = str3;
                                                r6 = r8;
                                                r7 = coroutine_suspended;
                                            }
                                        }
                                    } catch (Throwable th30) {
                                        th = th30;
                                        str26 = str3;
                                        r6 = r8;
                                        r7 = coroutine_suspended;
                                    }
                                    lastFailure = "Registration error: " + th.getMessage();
                                    String str311 = lastFailure;
                                    Intrinsics.checkNotNull(str311);
                                    Log.w(str26, str311);
                                    Log.d(str26, "Registration failed stacktrace", th);
                                    return RegOutcome.FAILED;
                                } catch (Throwable th31) {
                                    th = th31;
                                    str26 = str3;
                                    r6 = z;
                                    r7 = z2;
                                }
                            } catch (Throwable th32) {
                                th = th32;
                                r6 = z;
                                r7 = z2;
                            }
                        } catch (Throwable th33) {
                            th = th33;
                            r6 = z;
                            r7 = z2;
                        }
                        break;
                    case 1:
                        boolean z12 = c00182.Z$1;
                        boolean z13 = c00182.Z$0;
                        String str40 = (String) c00182.L$0;
                        ResultKt.throwOnFailure((Object) r8);
                        str4 = str40;
                        r0 = r8;
                        r4 = coroutine_suspended;
                        str3 = TAG;
                        str = "retry-after";
                        r8 = z13;
                        coroutine_suspended = z12;
                        str2 = " seconds.";
                        i = 429;
                        niceResponse = (NiceResponse) r0;
                        if (niceResponse.getCode() != i) {
                            str5 = niceResponse.getHeaders().get(str);
                            if (str5 != null) {
                                longOrNull = StringsKt.toLongOrNull(str5);
                                if (longOrNull != null) {
                                    jLongValue = longOrNull.longValue();
                                }
                                break;
                            }
                            long j4 = jLongValue;
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            Long.signum(j4);
                            rateLimitUntilMs = jCurrentTimeMillis2 + (1000 * j4);
                            lastFailure = "Challenge rate-limited (HTTP 429: too many requests). Server throttled your IP. Please wait " + j4 + str2;
                            Log.w(str3, lastFailure + r19 + niceResponse.getHeaders() + ')');
                            return RegOutcome.RATE_LIMITED;
                        }
                        str26 = str3;
                        if (!niceResponse.isSuccessful()) {
                            lastFailure = "Challenge failed (HTTP " + niceResponse.getCode() + "): " + StringsKt.take(niceResponse.getText(), 120);
                            String str216 = lastFailure;
                            Intrinsics.checkNotNull(str216);
                            Log.w(str26, str216);
                            return RegOutcome.SERVER_REJECTED;
                        }
                        AppUtils appUtils4 = AppUtils.INSTANCE;
                        text = niceResponse.getText();
                        if (text != null) {
                            Result.Companion companion11 = Result.Companion;
                            KType kTypeTypeOf4 = Reflection.typeOf(ChallengeResponse.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                            if (Result.exceptionOrNull-impl(obj) != null) {
                                Result.Companion companion12 = Result.Companion;
                                str6 = " (headers: ";
                                str7 = "): ";
                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ChallengeResponse.class), (List) null, 2, (Object) null));
                            } else {
                                str6 = " (headers: ";
                                str7 = "): ";
                            }
                            obj3 = obj;
                            if (Result.isFailure-impl(obj3)) {
                                obj3 = null;
                            }
                            DeserializationStrategy deserializationStrategy3 = (KSerializer) obj3;
                            Object objDecodeFromString2 = deserializationStrategy3 != null ? MainAPIKt.getJson().decodeFromString(deserializationStrategy3, text) : MainAPIKt.getMapper().readValue(text, new TypeReference<ChallengeResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$1
                            });
                            obj2 = objDecodeFromString2;
                            break;
                        } else {
                            str6 = " (headers: ";
                            str7 = "): ";
                            obj2 = null;
                        }
                        challengeResponse = (ChallengeResponse) obj2;
                        if (challengeResponse != null) {
                            challenge_id = challengeResponse.getChallenge_id();
                        } else {
                            challenge_id = null;
                        }
                        str8 = challenge_id;
                        if (challengeResponse != null) {
                            challenge = challengeResponse.getChallenge();
                        } else {
                            challenge = null;
                        }
                        str9 = challenge;
                        str10 = str8;
                        if (str10 != null) {
                            z3 = true;
                        } else {
                            z3 = true;
                        }
                        if (!z3) {
                            str11 = str9;
                            if (str11 != null) {
                                z4 = true;
                            } else {
                                z4 = true;
                            }
                            if (!z4) {
                                bArrDecode = Base64.decode(str9, 11);
                                if (r8 != 0) {
                                    keyPairPerformRegistration$generateAttestedKey = performRegistration$generateAttestedKey(bArrDecode, true);
                                    privateKey5 = keyPairPerformRegistration$generateAttestedKey.getPrivate();
                                    KeyStore keyStore3 = KeyStore.getInstance("AndroidKeyStore");
                                    keyStore3.load(null);
                                    certificateChain = keyStore3.getCertificateChain(KEYSTORE_ALIAS);
                                    if (certificateChain == null) {
                                        z7 = true;
                                        if (z7) {
                                            lastFailure = "AndroidKeyStore returned no attestation chain";
                                            String str217 = lastFailure;
                                            Intrinsics.checkNotNull(str217);
                                            Log.w(str26, str217);
                                            return RegOutcome.FAILED;
                                        }
                                        arrayList = new ArrayList(certificateChain.length);
                                        i2 = 0;
                                        while (i2 < length) {
                                            arrayList.add(Base64.encodeToString(certificateChain[i2].getEncoded(), 2));
                                            i2++;
                                        }
                                        arrayListListOf = arrayList;
                                        aniVortexRegistration = this;
                                        privateKey2 = privateKey5;
                                        lastFailure = "Attested keygen failed: " + th.getMessage();
                                        String str218 = lastFailure;
                                        Intrinsics.checkNotNull(str218);
                                        Log.w(str26, str218);
                                        return RegOutcome.FAILED;
                                    }
                                    if (certificateChain.length == 0) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    if (z6) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    if (z7) {
                                        lastFailure = "AndroidKeyStore returned no attestation chain";
                                        String str219 = lastFailure;
                                        Intrinsics.checkNotNull(str219);
                                        Log.w(str26, str219);
                                        return RegOutcome.FAILED;
                                    }
                                    arrayList = new ArrayList(certificateChain.length);
                                    i2 = 0;
                                    while (i2 < length) {
                                        arrayList.add(Base64.encodeToString(certificateChain[i2].getEncoded(), 2));
                                        i2++;
                                    }
                                    arrayListListOf = arrayList;
                                    aniVortexRegistration = this;
                                    privateKey2 = privateKey5;
                                    lastFailure = "Attested keygen failed: " + th.getMessage();
                                    String str2110 = lastFailure;
                                    Intrinsics.checkNotNull(str2110);
                                    Log.w(str26, str2110);
                                    return RegOutcome.FAILED;
                                }
                                KeyPairGenerator keyPairGenerator3 = KeyPairGenerator.getInstance("EC");
                                keyPairGenerator3.initialize(new ECGenParameterSpec("secp256r1"));
                                KeyPair keyPairGenerateKeyPair3 = keyPairGenerator3.generateKeyPair();
                                privateKey = keyPairGenerateKeyPair3.getPrivate();
                                publicKey = keyPairGenerateKeyPair3.getPublic();
                                if (publicKey instanceof ECPublicKey) {
                                    eCPublicKey = (ECPublicKey) publicKey;
                                } else {
                                    eCPublicKey = null;
                                }
                                if (eCPublicKey == null) {
                                    AniVortexRegistration aniVortexRegistration4 = this;
                                    lastFailure = "Generated software key is not EC";
                                    String str312 = lastFailure;
                                    Intrinsics.checkNotNull(str312);
                                    Log.w(str26, str312);
                                    return RegOutcome.FAILED;
                                }
                                aniVortexRegistration = this;
                                byte[] bArrBuildLeafCertificate3 = aniVortexRegistration.buildLeafCertificate(privateKey, eCPublicKey);
                                CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArrBuildLeafCertificate3));
                                String strEncodeToString3 = Base64.encodeToString(bArrBuildLeafCertificate3, 2);
                                arrayListListOf = CollectionsKt.listOf(new String[]{strEncodeToString3, strEncodeToString3});
                                privateKey2 = privateKey;
                                str12 = "ANIVORTEX-INSTALL-REGISTER-V1\n" + str8 + '\n' + aniVortexRegistration.b64UrlNoPad(aniVortexRegistration.sha256(bArrDecode));
                                signature = Signature.getInstance("SHA256withECDSA");
                                signature.initSign(privateKey2);
                                byte[] bytes3 = str12.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
                                signature.update(bytes3);
                                strB64UrlNoPad = aniVortexRegistration.b64UrlNoPad(signature.sign());
                                strJoinToString$default = CollectionsKt.joinToString$default(arrayListListOf, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.AniVortex.AniVortexRegistration$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj5) {
                                        return AniVortexRegistration.performRegistration$lambda$4((String) obj5);
                                    }
                                }, 30, (Object) null);
                                list = arrayListListOf;
                                str13 = "{\"challenge_id\":\"" + str8 + "\",\"certificate_chain\":[" + strJoinToString$default + "],\"proof_signature\":\"" + strB64UrlNoPad + "\"}";
                                Requests app4 = MainActivityKt.getApp();
                                Map<String, String> map4 = regHeaders;
                                RequestBody requestBodyCreate4 = RequestBody.Companion.create(str13, MediaType.Companion.parse("application/json; charset=utf-8"));
                                c00182.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                                c00182.L$1 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                c00182.L$2 = SpillingKt.nullOutSpilledVariable((Object) r2);
                                c00182.L$3 = SpillingKt.nullOutSpilledVariable(str8);
                                c00182.L$4 = SpillingKt.nullOutSpilledVariable(str9);
                                c00182.L$5 = SpillingKt.nullOutSpilledVariable(bArrDecode);
                                c00182.L$6 = privateKey2;
                                c00182.L$7 = SpillingKt.nullOutSpilledVariable(list);
                                c00182.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                c00182.L$9 = SpillingKt.nullOutSpilledVariable(signature);
                                c00182.L$10 = SpillingKt.nullOutSpilledVariable(strB64UrlNoPad);
                                c00182.L$11 = SpillingKt.nullOutSpilledVariable(strJoinToString$default);
                                c00182.L$12 = SpillingKt.nullOutSpilledVariable(str13);
                                c00182.Z$0 = r8;
                                c00182.Z$1 = coroutine_suspended;
                                c00182.label = 2;
                                r44 = r8;
                                r45 = coroutine_suspended;
                                C00181 c00185 = c00182;
                                privateKey3 = privateKey2;
                                str14 = str7;
                                str15 = str6;
                                str16 = str26;
                                z5 = true;
                                objPost$default = Requests.post$default(app4, "https://api.anivortex.in/api/v1/install/register", map4, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate4, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00185, 65276, (Object) null);
                                c00182 = c00185;
                                if (objPost$default == r4) {
                                    return r4;
                                }
                                challengeResponse2 = challengeResponse;
                                list2 = list;
                                str17 = str13;
                                r1 = objPost$default;
                                bArr = bArrDecode;
                                str18 = str4;
                                niceResponse2 = niceResponse;
                                signature2 = signature;
                                str19 = strB64UrlNoPad;
                                str20 = strJoinToString$default;
                                r8 = r44 == true ? 1 : 0;
                                coroutine_suspended = r45 == true ? 1 : 0;
                                str21 = str8;
                                str22 = str9;
                                str23 = str12;
                                privateKey4 = privateKey3;
                                r5 = r4;
                                niceResponse3 = (NiceResponse) r1;
                                if (niceResponse3.getCode() != 429) {
                                    str24 = niceResponse3.getHeaders().get(str);
                                    if (str24 != null) {
                                        longOrNull2 = StringsKt.toLongOrNull(str24);
                                        if (longOrNull2 != null) {
                                            jLongValue = longOrNull2.longValue();
                                        }
                                        break;
                                    }
                                    long j5 = jLongValue;
                                    rateLimitUntilMs = System.currentTimeMillis() + (1000 * j5);
                                    lastFailure = "Registration rate-limited (HTTP 429: too many requests). Server throttled your IP. Please wait " + j5 + str2;
                                    Log.w(str16, lastFailure + str15 + niceResponse3.getHeaders() + ')');
                                    return RegOutcome.RATE_LIMITED;
                                }
                                str26 = str16;
                                if (!niceResponse3.isSuccessful()) {
                                    lastFailure = "Register rejected (HTTP " + niceResponse3.getCode() + str14 + StringsKt.take(niceResponse3.getText(), 120);
                                    String str313 = lastFailure;
                                    Intrinsics.checkNotNull(str313);
                                    Log.w(str26, str313);
                                    return RegOutcome.SERVER_REJECTED;
                                }
                                AppUtils appUtils5 = AppUtils.INSTANCE;
                                text2 = niceResponse3.getText();
                                if (text2 != null) {
                                    Result.Companion companion13 = Result.Companion;
                                    KType kTypeTypeOf5 = Reflection.typeOf(RegisterResponse.class);
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                                    if (Result.exceptionOrNull-impl(obj4) == null) {
                                        Result.Companion companion14 = Result.Companion;
                                        obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(RegisterResponse.class), (List) null, 2, (Object) null));
                                        break;
                                    }
                                    if (Result.isFailure-impl(obj4)) {
                                        obj4 = null;
                                    }
                                    deserializationStrategy = (KSerializer) obj4;
                                    if (deserializationStrategy != null) {
                                        str25 = text2;
                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str25);
                                    } else {
                                        str25 = text2;
                                    }
                                    objDecodeFromString = MainAPIKt.getMapper().readValue(str25, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                                    });
                                    break;
                                } else {
                                    objDecodeFromString = null;
                                }
                                registerResponse = (RegisterResponse) objDecodeFromString;
                                if (registerResponse != null) {
                                    installation_id = registerResponse.getInstallation_id();
                                    if (installation_id != null) {
                                        z8 = true;
                                    } else {
                                        z8 = true;
                                    }
                                    if (!z8) {
                                        key_id = registerResponse.getKey_id();
                                        if (key_id != null) {
                                            z9 = true;
                                        } else {
                                            z9 = true;
                                        }
                                        if (!z9) {
                                            CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", registerResponse.getInstallation_id());
                                            CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", registerResponse.getKey_id());
                                            if (r8 != 0) {
                                                CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z5));
                                                CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", "");
                                            } else {
                                                CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(false));
                                                CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey4.getEncoded(), 2));
                                                clearKeystoreKey();
                                            }
                                            AniVortexAuth.INSTANCE.invalidateCache();
                                            lastFailure = null;
                                            StringBuilder sbAppend4 = new StringBuilder().append("Registration complete! installation_id=").append(r1.getInstallation_id()).append(" key_id=").append(r1.getKey_id()).append(" attested=");
                                            if (r8 != 0) {
                                                z10 = true;
                                            } else {
                                                z10 = false;
                                            }
                                            Log.i(str26, sbAppend4.append(z10).toString());
                                            c00182.L$0 = SpillingKt.nullOutSpilledVariable(str18);
                                            c00182.L$1 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                                            c00182.L$2 = SpillingKt.nullOutSpilledVariable(challengeResponse2);
                                            c00182.L$3 = SpillingKt.nullOutSpilledVariable(str21);
                                            c00182.L$4 = SpillingKt.nullOutSpilledVariable(str22);
                                            c00182.L$5 = SpillingKt.nullOutSpilledVariable(bArr);
                                            c00182.L$6 = SpillingKt.nullOutSpilledVariable(privateKey4);
                                            c00182.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                                            c00182.L$8 = SpillingKt.nullOutSpilledVariable(str23);
                                            c00182.L$9 = SpillingKt.nullOutSpilledVariable(signature2);
                                            c00182.L$10 = SpillingKt.nullOutSpilledVariable(str19);
                                            c00182.L$11 = SpillingKt.nullOutSpilledVariable(str20);
                                            c00182.L$12 = SpillingKt.nullOutSpilledVariable(str17);
                                            c00182.L$13 = SpillingKt.nullOutSpilledVariable(niceResponse3);
                                            c00182.L$14 = SpillingKt.nullOutSpilledVariable((Object) r1);
                                            c00182.Z$0 = r8;
                                            c00182.Z$1 = coroutine_suspended;
                                            c00182.label = 3;
                                            r58 = r8;
                                            if (syncInstallationPush$default(this, false, c00182, 1, null) == r5) {
                                                return r5;
                                            }
                                            z11 = r58 == true ? 1 : 0;
                                            r3 = coroutine_suspended;
                                            return RegOutcome.SUCCESS;
                                        }
                                    }
                                }
                                lastFailure = "Register response missing fields: " + StringsKt.take(niceResponse3.getText(), 120);
                                String str314 = lastFailure;
                                Intrinsics.checkNotNull(str314);
                                Log.w(str26, str314);
                                return RegOutcome.FAILED;
                            }
                        }
                        lastFailure = "Invalid challenge response: " + StringsKt.take(niceResponse.getText(), 120);
                        String str315 = lastFailure;
                        Intrinsics.checkNotNull(str315);
                        Log.w(str26, str315);
                        return RegOutcome.FAILED;
                        lastFailure = "Registration error: " + th.getMessage();
                        String str316 = lastFailure;
                        Intrinsics.checkNotNull(str316);
                        Log.w(str26, str316);
                        Log.d(str26, "Registration failed stacktrace", th);
                        return RegOutcome.FAILED;
                    case 2:
                        boolean z14 = c00182.Z$1;
                        boolean z15 = c00182.Z$0;
                        String str41 = (String) c00182.L$12;
                        String str42 = (String) c00182.L$11;
                        String str43 = (String) c00182.L$10;
                        Signature signature3 = (Signature) c00182.L$9;
                        String str44 = (String) c00182.L$8;
                        List list3 = (List) c00182.L$7;
                        PrivateKey privateKey6 = (PrivateKey) c00182.L$6;
                        byte[] bArr2 = (byte[]) c00182.L$5;
                        String str45 = (String) c00182.L$4;
                        String str46 = (String) c00182.L$3;
                        ChallengeResponse challengeResponse3 = (ChallengeResponse) c00182.L$2;
                        NiceResponse niceResponse4 = (NiceResponse) c00182.L$1;
                        String str47 = (String) c00182.L$0;
                        ResultKt.throwOnFailure((Object) r8);
                        privateKey4 = privateKey6;
                        str18 = str47;
                        r1 = r8;
                        r5 = coroutine_suspended;
                        str16 = TAG;
                        str14 = "): ";
                        str = "retry-after";
                        signature2 = signature3;
                        str23 = str44;
                        bArr = bArr2;
                        str22 = str45;
                        niceResponse2 = niceResponse4;
                        z5 = true;
                        r8 = z15;
                        coroutine_suspended = z14;
                        list2 = list3;
                        str19 = str43;
                        str15 = " (headers: ";
                        str2 = " seconds.";
                        str21 = str46;
                        challengeResponse2 = challengeResponse3;
                        str20 = str42;
                        str17 = str41;
                        niceResponse3 = (NiceResponse) r1;
                        if (niceResponse3.getCode() != 429) {
                            str24 = niceResponse3.getHeaders().get(str);
                            if (str24 != null) {
                                longOrNull2 = StringsKt.toLongOrNull(str24);
                                if (longOrNull2 != null) {
                                    jLongValue = longOrNull2.longValue();
                                }
                                break;
                            }
                            long j6 = jLongValue;
                            rateLimitUntilMs = System.currentTimeMillis() + (1000 * j6);
                            lastFailure = "Registration rate-limited (HTTP 429: too many requests). Server throttled your IP. Please wait " + j6 + str2;
                            Log.w(str16, lastFailure + str15 + niceResponse3.getHeaders() + ')');
                            return RegOutcome.RATE_LIMITED;
                        }
                        str26 = str16;
                        if (!niceResponse3.isSuccessful()) {
                            lastFailure = "Register rejected (HTTP " + niceResponse3.getCode() + str14 + StringsKt.take(niceResponse3.getText(), 120);
                            String str317 = lastFailure;
                            Intrinsics.checkNotNull(str317);
                            Log.w(str26, str317);
                            return RegOutcome.SERVER_REJECTED;
                        }
                        AppUtils appUtils6 = AppUtils.INSTANCE;
                        text2 = niceResponse3.getText();
                        if (text2 != null) {
                            Result.Companion companion15 = Result.Companion;
                            KType kTypeTypeOf6 = Reflection.typeOf(RegisterResponse.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                            if (Result.exceptionOrNull-impl(obj4) == null) {
                                Result.Companion companion16 = Result.Companion;
                                obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(RegisterResponse.class), (List) null, 2, (Object) null));
                                break;
                            }
                            if (Result.isFailure-impl(obj4)) {
                                obj4 = null;
                            }
                            deserializationStrategy = (KSerializer) obj4;
                            if (deserializationStrategy != null) {
                                str25 = text2;
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str25);
                            } else {
                                str25 = text2;
                            }
                            objDecodeFromString = MainAPIKt.getMapper().readValue(str25, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                            });
                            break;
                        } else {
                            objDecodeFromString = null;
                        }
                        registerResponse = (RegisterResponse) objDecodeFromString;
                        if (registerResponse != null) {
                            installation_id = registerResponse.getInstallation_id();
                            if (installation_id != null) {
                                z8 = true;
                            } else {
                                z8 = true;
                            }
                            if (!z8) {
                                key_id = registerResponse.getKey_id();
                                if (key_id != null) {
                                    z9 = true;
                                } else {
                                    z9 = true;
                                }
                                if (!z9) {
                                    CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", registerResponse.getInstallation_id());
                                    CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", registerResponse.getKey_id());
                                    if (r8 != 0) {
                                        CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z5));
                                        CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", "");
                                    } else {
                                        CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(false));
                                        CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey4.getEncoded(), 2));
                                        clearKeystoreKey();
                                    }
                                    AniVortexAuth.INSTANCE.invalidateCache();
                                    lastFailure = null;
                                    StringBuilder sbAppend5 = new StringBuilder().append("Registration complete! installation_id=").append(r1.getInstallation_id()).append(" key_id=").append(r1.getKey_id()).append(" attested=");
                                    if (r8 != 0) {
                                        z10 = true;
                                    } else {
                                        z10 = false;
                                    }
                                    Log.i(str26, sbAppend5.append(z10).toString());
                                    c00182.L$0 = SpillingKt.nullOutSpilledVariable(str18);
                                    c00182.L$1 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                                    c00182.L$2 = SpillingKt.nullOutSpilledVariable(challengeResponse2);
                                    c00182.L$3 = SpillingKt.nullOutSpilledVariable(str21);
                                    c00182.L$4 = SpillingKt.nullOutSpilledVariable(str22);
                                    c00182.L$5 = SpillingKt.nullOutSpilledVariable(bArr);
                                    c00182.L$6 = SpillingKt.nullOutSpilledVariable(privateKey4);
                                    c00182.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                                    c00182.L$8 = SpillingKt.nullOutSpilledVariable(str23);
                                    c00182.L$9 = SpillingKt.nullOutSpilledVariable(signature2);
                                    c00182.L$10 = SpillingKt.nullOutSpilledVariable(str19);
                                    c00182.L$11 = SpillingKt.nullOutSpilledVariable(str20);
                                    c00182.L$12 = SpillingKt.nullOutSpilledVariable(str17);
                                    c00182.L$13 = SpillingKt.nullOutSpilledVariable(niceResponse3);
                                    c00182.L$14 = SpillingKt.nullOutSpilledVariable((Object) r1);
                                    c00182.Z$0 = r8;
                                    c00182.Z$1 = coroutine_suspended;
                                    c00182.label = 3;
                                    r58 = r8;
                                    if (syncInstallationPush$default(this, false, c00182, 1, null) == r5) {
                                        return r5;
                                    }
                                    z11 = r58 == true ? 1 : 0;
                                    r3 = coroutine_suspended;
                                    return RegOutcome.SUCCESS;
                                }
                            }
                        }
                        lastFailure = "Register response missing fields: " + StringsKt.take(niceResponse3.getText(), 120);
                        String str318 = lastFailure;
                        Intrinsics.checkNotNull(str318);
                        Log.w(str26, str318);
                        return RegOutcome.FAILED;
                        lastFailure = "Registration error: " + th.getMessage();
                        String str319 = lastFailure;
                        Intrinsics.checkNotNull(str319);
                        Log.w(str26, str319);
                        Log.d(str26, "Registration failed stacktrace", th);
                        return RegOutcome.FAILED;
                    case 3:
                        boolean z16 = c00182.Z$1;
                        z11 = c00182.Z$0;
                        ResultKt.throwOnFailure((Object) r8);
                        r3 = z16;
                        return RegOutcome.SUCCESS;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th34) {
                th = th34;
            }
        } catch (Throwable th35) {
            th = th35;
            r7 = z2;
            r6 = z;
        }
    }

    private static final KeyPair performRegistration$generateAttestedKey(byte[] challengeBytes, boolean strongbox) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyStore ks = KeyStore.getInstance("AndroidKeyStore");
        ks.load(null);
        if (ks.containsAlias(KEYSTORE_ALIAS)) {
            try {
                ks.deleteEntry(KEYSTORE_ALIAS);
            } catch (Throwable th) {
            }
        }
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
        KeyGenParameterSpec.Builder specBuilder = new KeyGenParameterSpec.Builder(KEYSTORE_ALIAS, 4).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests("SHA-256").setUserAuthenticationRequired(false).setAttestationChallenge(challengeBytes);
        if (strongbox && Build.VERSION.SDK_INT >= 28) {
            specBuilder.setIsStrongBoxBacked(true);
        }
        kpg.initialize(specBuilder.build());
        return kpg.generateKeyPair();
    }

    static final CharSequence performRegistration$lambda$4(String it) {
        return '\"' + it + '\"';
    }

    public static /* synthetic */ Object syncInstallationPush$default(AniVortexRegistration aniVortexRegistration, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return aniVortexRegistration.syncInstallationPush(z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:114:0x02db A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:115:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:118:0x02f9 A[Catch: all -> 0x0360, TRY_LEAVE, TryCatch #1 {all -> 0x0360, blocks: (B:116:0x02f1, B:118:0x02f9), top: B:146:0x02f1 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x032b A[Catch: all -> 0x035e, TRY_LEAVE, TryCatch #21 {all -> 0x035e, blocks: (B:120:0x0325, B:121:0x032b), top: B:181:0x02f7 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x01c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x00cd A[Catch: all -> 0x01c1, TRY_LEAVE, TryCatch #2 {all -> 0x01c1, blocks: (B:29:0x00c0, B:31:0x00cd, B:33:0x00e5, B:35:0x00eb, B:92:0x01bc, B:38:0x00f3, B:44:0x0122, B:59:0x0161, B:62:0x0168, B:79:0x0190, B:77:0x0187, B:58:0x0157, B:43:0x0118), top: B:148:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:38:0x00f3 A[Catch: Exception -> 0x01ae, all -> 0x01c1, TRY_LEAVE, TryCatch #2 {all -> 0x01c1, blocks: (B:29:0x00c0, B:31:0x00cd, B:33:0x00e5, B:35:0x00eb, B:92:0x01bc, B:38:0x00f3, B:44:0x0122, B:59:0x0161, B:62:0x0168, B:79:0x0190, B:77:0x0187, B:58:0x0157, B:43:0x0118), top: B:148:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0128  */
    /* JADX WARN: Code duplicated, block: B:61:0x0167  */
    /* JADX WARN: Code duplicated, block: B:78:0x018e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:91:0x01ba  */
    @Nullable
    public final Object syncInstallationPush(boolean force, @NotNull Continuation<? super Boolean> continuation) throws Throwable {
        C00211 c00211;
        AniVortexRegistration aniVortexRegistration;
        Object owner$iv;
        int $i$f$withLock;
        boolean force2;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv2;
        long now;
        Long l;
        long jLongValue;
        long lastSync;
        String str;
        int $i$f$withLock2;
        Object owner$iv3;
        boolean force3;
        Mutex $this$withLock_u24default$iv2;
        boolean force4;
        Mutex $this$withLock_u24default$iv3;
        String str2;
        boolean force5;
        Context context;
        Object obj;
        Object objDecodeFromString;
        String string;
        Object obj2;
        Object obj3;
        DeserializationStrategy deserializationStrategy;
        String str3;
        NiceResponse resp;
        if (continuation instanceof C00211) {
            c00211 = (C00211) continuation;
            if ((c00211.label & Integer.MIN_VALUE) != 0) {
                c00211.label -= Integer.MIN_VALUE;
                aniVortexRegistration = this;
            } else {
                aniVortexRegistration = this;
                c00211 = aniVortexRegistration.new C00211(continuation);
            }
        } else {
            aniVortexRegistration = this;
            c00211 = aniVortexRegistration.new C00211(continuation);
        }
        C00211 c00212 = c00211;
        Object $result = c00212.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = false;
        switch (c00212.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!aniVortexRegistration.hasCredentials()) {
                    return Boxing.boxBoolean(false);
                }
                Mutex $this$withLock_u24default$iv4 = pushSyncMutex;
                c00212.L$0 = $this$withLock_u24default$iv4;
                c00212.Z$0 = force;
                c00212.label = 1;
                if ($this$withLock_u24default$iv4.lock((Object) null, c00212) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                owner$iv = null;
                $i$f$withLock = 0;
                force2 = force;
                $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                try {
                    now = System.currentTimeMillis();
                    try {
                        CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
                        context = this_$iv.getContext();
                        if (context != null) {
                            obj = null;
                            try {
                                try {
                                    string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIVORTEX_LAST_PUSH_SYNC", null);
                                    if (string == null) {
                                        AppUtils appUtils = AppUtils.INSTANCE;
                                        try {
                                            Result.Companion companion = Result.Companion;
                                            KType kTypeTypeOf = Reflection.typeOf(Long.TYPE);
                                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                            obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                        } catch (Throwable th) {
                                            Result.Companion companion2 = Result.Companion;
                                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                        }
                                        if (Result.exceptionOrNull-impl(obj2) != null) {
                                            obj3 = null;
                                        } else {
                                            try {
                                                Result.Companion companion3 = Result.Companion;
                                                try {
                                                    obj3 = null;
                                                    try {
                                                        obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Long.class), (List) null, 2, (Object) null));
                                                        break;
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
                                                    obj3 = null;
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                obj3 = null;
                                            }
                                        }
                                        if (Result.isFailure-impl(obj2)) {
                                            obj2 = obj3;
                                        }
                                        deserializationStrategy = (KSerializer) obj2;
                                        if (deserializationStrategy != null) {
                                            try {
                                                str3 = string;
                                                try {
                                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str3);
                                                } catch (SerializationException e2) {
                                                    e = e2;
                                                    ArchComponentExtKt.logError((Throwable) e);
                                                    objDecodeFromString = MainAPIKt.getMapper().readValue(str3, new TypeReference<Long>() { // from class: com.AniVortex.AniVortexRegistration$syncInstallationPush$lambda$0$$inlined$getKey$1
                                                    });
                                                } catch (Throwable th5) {
                                                    objDecodeFromString = MainAPIKt.getMapper().readValue(str3, new TypeReference<Long>() { // from class: com.AniVortex.AniVortexRegistration$syncInstallationPush$lambda$0$$inlined$getKey$1
                                                    });
                                                }
                                            } catch (SerializationException e3) {
                                                e = e3;
                                                str3 = string;
                                            } catch (Throwable th6) {
                                                str3 = string;
                                            }
                                            obj = objDecodeFromString;
                                        } else {
                                            str3 = string;
                                        }
                                        objDecodeFromString = MainAPIKt.getMapper().readValue(str3, new TypeReference<Long>() { // from class: com.AniVortex.AniVortexRegistration$syncInstallationPush$lambda$0$$inlined$getKey$1
                                        });
                                        obj = objDecodeFromString;
                                        break;
                                    }
                                } catch (Exception e4) {
                                }
                            } catch (Exception e5) {
                            }
                        } else {
                            obj = null;
                        }
                        l = (Long) obj;
                    } catch (Throwable th7) {
                        l = null;
                    }
                    if (l != null) {
                        try {
                            jLongValue = l.longValue();
                        } catch (Throwable th8) {
                            th = th8;
                            owner$iv2 = owner$iv;
                            $this$withLock_u24default$iv.unlock(owner$iv2);
                            throw th;
                        }
                    } else {
                        jLongValue = 0;
                    }
                    lastSync = jLongValue;
                    if (!force2 || now - lastSync >= 10000) {
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
                            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                            String isoTime = sdf.format(new Date());
                            String jsonBody = "{\"environment\":\"prod\",\"platform\":\"android\",\"version_code\":503,\"notification_status\":\"authorized\",\"movie_series_subscribed\":true,\"anime_subscribed\":false,\"synchronized_at\":\"" + isoTime + "\"}";
                            byte[] bodyBytes = jsonBody.getBytes(Charsets.UTF_8);
                            Intrinsics.checkNotNullExpressionValue(bodyBytes, "getBytes(...)");
                            Map headers = (Map) AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "PUT", "/api/v1/push/installation", null, bodyBytes, 4, null).component2();
                            Requests app = MainActivityKt.getApp();
                            try {
                                RequestBody requestBodyCreate = RequestBody.Companion.create(jsonBody, MediaType.Companion.parse("application/json; charset=utf-8"));
                                c00212.L$0 = $this$withLock_u24default$iv;
                                c00212.L$1 = SpillingKt.nullOutSpilledVariable(isoTime);
                                c00212.L$2 = SpillingKt.nullOutSpilledVariable(jsonBody);
                                c00212.L$3 = SpillingKt.nullOutSpilledVariable(bodyBytes);
                                c00212.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                                c00212.L$5 = SpillingKt.nullOutSpilledVariable(sdf);
                                c00212.Z$0 = force2;
                                c00212.J$0 = now;
                                c00212.J$1 = lastSync;
                                c00212.label = 2;
                                force4 = force2;
                                $this$withLock_u24default$iv3 = $this$withLock_u24default$iv;
                                str2 = TAG;
                                str = "ANIVORTEX_LAST_PUSH_SYNC";
                                try {
                                    $result = Requests.put$default(app, "https://api.anivortex.in/api/v1/push/installation", headers, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00212, 65276, (Object) null);
                                    if ($result == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $i$f$withLock2 = $i$f$withLock;
                                    owner$iv3 = owner$iv;
                                    force3 = force4;
                                    $this$withLock_u24default$iv2 = $this$withLock_u24default$iv3;
                                    try {
                                        resp = (NiceResponse) $result;
                                        try {
                                            if (resp.isSuccessful()) {
                                                CloudStreamApp.Companion.setKey(str, Boxing.boxLong(System.currentTimeMillis()));
                                                str = str2;
                                                Log.i(str, "Push installation sync succeeded (HTTP " + resp.getCode() + ')');
                                                z = true;
                                            } else {
                                                str = str2;
                                                Log.w(str, "Push installation sync responded with HTTP " + resp.getCode() + ": " + StringsKt.take(resp.getText(), 120));
                                            }
                                        } catch (Throwable th9) {
                                            e = th9;
                                            try {
                                                Log.w(str, "Push installation sync error: " + e.getMessage());
                                            } catch (Throwable th10) {
                                                th = th10;
                                                owner$iv2 = owner$iv3;
                                                $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                                                $this$withLock_u24default$iv.unlock(owner$iv2);
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th11) {
                                        e = th11;
                                        str = str2;
                                    }
                                    owner$iv2 = owner$iv3;
                                    $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                                    force5 = z;
                                } catch (Throwable th12) {
                                    e = th12;
                                    str = str2;
                                    $i$f$withLock2 = $i$f$withLock;
                                    owner$iv3 = owner$iv;
                                    force3 = force4;
                                    $this$withLock_u24default$iv2 = $this$withLock_u24default$iv3;
                                    Log.w(str, "Push installation sync error: " + e.getMessage());
                                    owner$iv2 = owner$iv3;
                                    $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                                    force5 = z;
                                    Boolean boolBoxBoolean = Boxing.boxBoolean(force5);
                                    $this$withLock_u24default$iv.unlock(owner$iv2);
                                    return boolBoxBoolean;
                                }
                            } catch (Throwable th13) {
                                e = th13;
                                str = TAG;
                                $i$f$withLock2 = $i$f$withLock;
                                owner$iv3 = owner$iv;
                                force3 = force2;
                                $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                            }
                        } catch (Throwable th14) {
                            e = th14;
                            str = TAG;
                            $i$f$withLock2 = $i$f$withLock;
                            owner$iv3 = owner$iv;
                            force3 = force2;
                            $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                        }
                    } else {
                        force3 = force2;
                        owner$iv2 = owner$iv;
                        force5 = true;
                    }
                    try {
                        Boolean boolBoxBoolean2 = Boxing.boxBoolean(force5);
                        $this$withLock_u24default$iv.unlock(owner$iv2);
                        return boolBoxBoolean2;
                    } catch (Throwable th15) {
                        th = th15;
                        $this$withLock_u24default$iv.unlock(owner$iv2);
                        throw th;
                    }
                } catch (Throwable th16) {
                    th = th16;
                    owner$iv2 = owner$iv;
                }
                break;
                break;
            case 1:
                force2 = c00212.Z$0;
                Mutex $this$withLock_u24default$iv5 = (Mutex) c00212.L$0;
                ResultKt.throwOnFailure($result);
                $i$f$withLock = 0;
                owner$iv = null;
                $this$withLock_u24default$iv = $this$withLock_u24default$iv5;
                now = System.currentTimeMillis();
                CloudStreamApp.Companion this_$iv2 = CloudStreamApp.Companion;
                context = this_$iv2.getContext();
                if (context != null) {
                    obj = null;
                    string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIVORTEX_LAST_PUSH_SYNC", null);
                    if (string == null) {
                        AppUtils appUtils2 = AppUtils.INSTANCE;
                        Result.Companion companion5 = Result.Companion;
                        KType kTypeTypeOf2 = Reflection.typeOf(Long.TYPE);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                        if (Result.exceptionOrNull-impl(obj2) != null) {
                            Result.Companion companion6 = Result.Companion;
                            obj3 = null;
                            obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Long.class), (List) null, 2, (Object) null));
                        } else {
                            obj3 = null;
                        }
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = obj3;
                        }
                        deserializationStrategy = (KSerializer) obj2;
                        if (deserializationStrategy != null) {
                            str3 = string;
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str3);
                            obj = objDecodeFromString;
                        } else {
                            str3 = string;
                        }
                        objDecodeFromString = MainAPIKt.getMapper().readValue(str3, new TypeReference<Long>() { // from class: com.AniVortex.AniVortexRegistration$syncInstallationPush$lambda$0$$inlined$getKey$1
                        });
                        obj = objDecodeFromString;
                        break;
                    }
                } else {
                    obj = null;
                }
                l = (Long) obj;
                if (l != null) {
                    jLongValue = l.longValue();
                    break;
                } else {
                    jLongValue = 0;
                }
                lastSync = jLongValue;
                if (force2) {
                    break;
                }
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
                sdf2.setTimeZone(TimeZone.getTimeZone("UTC"));
                String isoTime2 = sdf2.format(new Date());
                String jsonBody2 = "{\"environment\":\"prod\",\"platform\":\"android\",\"version_code\":503,\"notification_status\":\"authorized\",\"movie_series_subscribed\":true,\"anime_subscribed\":false,\"synchronized_at\":\"" + isoTime2 + "\"}";
                byte[] bodyBytes2 = jsonBody2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bodyBytes2, "getBytes(...)");
                Map headers2 = (Map) AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "PUT", "/api/v1/push/installation", null, bodyBytes2, 4, null).component2();
                Requests app2 = MainActivityKt.getApp();
                RequestBody requestBodyCreate2 = RequestBody.Companion.create(jsonBody2, MediaType.Companion.parse("application/json; charset=utf-8"));
                c00212.L$0 = $this$withLock_u24default$iv;
                c00212.L$1 = SpillingKt.nullOutSpilledVariable(isoTime2);
                c00212.L$2 = SpillingKt.nullOutSpilledVariable(jsonBody2);
                c00212.L$3 = SpillingKt.nullOutSpilledVariable(bodyBytes2);
                c00212.L$4 = SpillingKt.nullOutSpilledVariable(headers2);
                c00212.L$5 = SpillingKt.nullOutSpilledVariable(sdf2);
                c00212.Z$0 = force2;
                c00212.J$0 = now;
                c00212.J$1 = lastSync;
                c00212.label = 2;
                force4 = force2;
                $this$withLock_u24default$iv3 = $this$withLock_u24default$iv;
                str2 = TAG;
                str = "ANIVORTEX_LAST_PUSH_SYNC";
                $result = Requests.put$default(app2, "https://api.anivortex.in/api/v1/push/installation", headers2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00212, 65276, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $i$f$withLock2 = $i$f$withLock;
                owner$iv3 = owner$iv;
                force3 = force4;
                $this$withLock_u24default$iv2 = $this$withLock_u24default$iv3;
                resp = (NiceResponse) $result;
                if (resp.isSuccessful()) {
                    CloudStreamApp.Companion.setKey(str, Boxing.boxLong(System.currentTimeMillis()));
                    str = str2;
                    Log.i(str, "Push installation sync succeeded (HTTP " + resp.getCode() + ')');
                    z = true;
                } else {
                    str = str2;
                    Log.w(str, "Push installation sync responded with HTTP " + resp.getCode() + ": " + StringsKt.take(resp.getText(), 120));
                }
                owner$iv2 = owner$iv3;
                $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                force5 = z;
                Boolean boolBoxBoolean3 = Boxing.boxBoolean(force5);
                $this$withLock_u24default$iv.unlock(owner$iv2);
                return boolBoxBoolean3;
            case 2:
                $i$f$withLock2 = 0;
                long j = c00212.J$1;
                long j2 = c00212.J$0;
                force3 = c00212.Z$0;
                owner$iv3 = null;
                $this$withLock_u24default$iv2 = (Mutex) c00212.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    str = "ANIVORTEX_LAST_PUSH_SYNC";
                    str2 = TAG;
                    resp = (NiceResponse) $result;
                    if (resp.isSuccessful()) {
                        CloudStreamApp.Companion.setKey(str, Boxing.boxLong(System.currentTimeMillis()));
                        str = str2;
                        Log.i(str, "Push installation sync succeeded (HTTP " + resp.getCode() + ')');
                        z = true;
                    } else {
                        str = str2;
                        Log.w(str, "Push installation sync responded with HTTP " + resp.getCode() + ": " + StringsKt.take(resp.getText(), 120));
                    }
                    break;
                } catch (Throwable th17) {
                    e = th17;
                    str = TAG;
                    Log.w(str, "Push installation sync error: " + e.getMessage());
                    owner$iv2 = owner$iv3;
                    $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                    force5 = z;
                    Boolean boolBoxBoolean4 = Boxing.boxBoolean(force5);
                    $this$withLock_u24default$iv.unlock(owner$iv2);
                    return boolBoxBoolean4;
                }
                owner$iv2 = owner$iv3;
                $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                force5 = z;
                Boolean boolBoxBoolean5 = Boxing.boxBoolean(force5);
                $this$withLock_u24default$iv.unlock(owner$iv2);
                return boolBoxBoolean5;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Object syncInstallationPushIfNeeded$default(AniVortexRegistration aniVortexRegistration, long j, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 600000;
        }
        return aniVortexRegistration.syncInstallationPushIfNeeded(j, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public final Object syncInstallationPushIfNeeded(long minIntervalMs, @NotNull Continuation<? super Unit> continuation) {
        C00241 c00241;
        Long l;
        Object $result;
        Object $result2;
        Object obj;
        Object obj2;
        Object obj3;
        String str;
        if (continuation instanceof C00241) {
            c00241 = (C00241) continuation;
            if ((c00241.label & Integer.MIN_VALUE) != 0) {
                c00241.label -= Integer.MIN_VALUE;
            } else {
                c00241 = new C00241(continuation);
            }
        } else {
            c00241 = new C00241(continuation);
        }
        C00241 c00242 = c00241;
        Object $result3 = c00242.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00242.label) {
            case 0:
                ResultKt.throwOnFailure($result3);
                if (!hasCredentials()) {
                    return Unit.INSTANCE;
                }
                try {
                    CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
                    Context context = this_$iv.getContext();
                    if (context != null) {
                        Object obj4 = null;
                        try {
                            try {
                                try {
                                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIVORTEX_LAST_PUSH_SYNC", null);
                                    if (string != null) {
                                        AppUtils appUtils = AppUtils.INSTANCE;
                                        try {
                                            Result.Companion companion = Result.Companion;
                                            KType kTypeTypeOf = Reflection.typeOf(Long.TYPE);
                                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                        } catch (Throwable th) {
                                            Result.Companion companion2 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                        }
                                        if (Result.exceptionOrNull-impl(obj) == null) {
                                            obj3 = obj;
                                        } else {
                                            try {
                                                Result.Companion companion3 = Result.Companion;
                                                try {
                                                    try {
                                                        obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Long.class), (List) null, 2, (Object) null));
                                                        break;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        try {
                                                            Result.Companion companion4 = Result.Companion;
                                                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                                        } catch (Exception e) {
                                                            $result2 = null;
                                                        }
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                            }
                                            obj3 = obj2;
                                        }
                                        if (Result.isFailure-impl(obj3)) {
                                            obj3 = null;
                                        }
                                        DeserializationStrategy deserializationStrategy = (KSerializer) obj3;
                                        if (deserializationStrategy == null) {
                                            str = string;
                                        } else {
                                            try {
                                                str = string;
                                                try {
                                                    $result2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str);
                                                } catch (SerializationException e2) {
                                                    e = e2;
                                                    ArchComponentExtKt.logError((Throwable) e);
                                                    $result2 = MainAPIKt.getMapper().readValue(str, new TypeReference<Long>() { // from class: com.AniVortex.AniVortexRegistration$syncInstallationPushIfNeeded$$inlined$getKey$1
                                                    });
                                                } catch (Throwable th5) {
                                                    $result2 = MainAPIKt.getMapper().readValue(str, new TypeReference<Long>() { // from class: com.AniVortex.AniVortexRegistration$syncInstallationPushIfNeeded$$inlined$getKey$1
                                                    });
                                                }
                                            } catch (SerializationException e3) {
                                                e = e3;
                                                str = string;
                                            } catch (Throwable th6) {
                                                str = string;
                                            }
                                            obj4 = $result2;
                                        }
                                        $result2 = MainAPIKt.getMapper().readValue(str, new TypeReference<Long>() { // from class: com.AniVortex.AniVortexRegistration$syncInstallationPushIfNeeded$$inlined$getKey$1
                                        });
                                        obj4 = $result2;
                                        break;
                                    }
                                } catch (Throwable th7) {
                                    l = null;
                                }
                            } catch (Exception e4) {
                            }
                        } catch (Exception e5) {
                        }
                        $result = obj4;
                    } else {
                        $result = null;
                    }
                    l = (Long) $result;
                    break;
                } catch (Throwable th8) {
                }
                long lastSync = l != null ? l.longValue() : 0L;
                if (System.currentTimeMillis() - lastSync <= minIntervalMs) {
                    return Unit.INSTANCE;
                }
                c00242.J$0 = minIntervalMs;
                c00242.J$1 = lastSync;
                c00242.label = 1;
                if (syncInstallationPush$default(this, false, c00242, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                long j = c00242.J$1;
                long j2 = c00242.J$0;
                ResultKt.throwOnFailure($result3);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
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
    public final Object testApiConnection(@NotNull Continuation<? super Pair<Boolean, String>> continuation) {
        C00251 c00251;
        Object objEnsureRegistered;
        boolean registered;
        boolean z;
        Object obj;
        String str;
        NiceResponse resp;
        Pair pair;
        if (continuation instanceof C00251) {
            c00251 = (C00251) continuation;
            if ((c00251.label & Integer.MIN_VALUE) != 0) {
                c00251.label -= Integer.MIN_VALUE;
            } else {
                c00251 = new C00251(continuation);
            }
        } else {
            c00251 = new C00251(continuation);
        }
        C00251 c00252 = c00251;
        Object $result = c00252.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00252.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00252.label = 1;
                objEnsureRegistered = ensureRegistered(c00252);
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
                    c00252.L$0 = SpillingKt.nullOutSpilledVariable(query);
                    c00252.L$1 = SpillingKt.nullOutSpilledVariable(headers);
                    c00252.L$2 = SpillingKt.nullOutSpilledVariable(url);
                    c00252.Z$0 = registered;
                    c00252.label = 2;
                    z = true;
                    try {
                        obj = Requests.get$default(app, url, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00252, 4092, (Object) null);
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
                c00252.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00252.L$1 = SpillingKt.nullOutSpilledVariable(headers2);
                c00252.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                c00252.Z$0 = registered;
                c00252.label = 2;
                z = true;
                obj = Requests.get$default(app2, url2, headers2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00252, 4092, (Object) null);
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
                boolean z2 = c00252.Z$0;
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
        BigInteger serial = new BigInteger(159, new SecureRandom()).abs().add(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(serial, "add(...)");
        return derSequence(derExplicitContextZero(derInteger(BigInteger.valueOf(2L))), derInteger(serial), derSequence(derOid(ECDSA_WITH_SHA256)), derCnName(), derSequence(derUtcTime(getUtcTime(System.currentTimeMillis() - 86400000)), derUtcTime(getUtcTime(System.currentTimeMillis() + 31536000000L))), derCnName(), derSequence(derSequence(derOid(ID_EC_PUBLIC_KEY), derOid(PRIME256V1)), derBitString(point)));
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
