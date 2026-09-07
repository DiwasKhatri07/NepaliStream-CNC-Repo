package com.AniVortex;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import android.util.Log;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
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
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
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
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002BCB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0015\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0016\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0002J\"\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001a2\b\b\u0002\u0010'\u001a\u00020\u000fH\u0002J!\u0010(\u001a\u00020\u001a2\u0012\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0*\"\u00020\u001aH\u0002¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001aH\u0002J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001aH\u0002J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u001aH\u0002J\u0010\u00103\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u0005H\u0002J\u0010\u00104\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u0005H\u0002J\u0010\u00105\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u0005H\u0002J\u0010\u00106\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001aH\u0002J(\u0010:\u001a\u00020;2\u0006\u0010/\u001a\u0002002\u0006\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020\"2\u0006\u0010>\u001a\u00020\"H\u0002J\u0010\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020\u001aH\u0002J\u0010\u0010A\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/AniVortex/AniVortexRegistration;", "", "<init>", "()V", "TAG", "", "BASE_URL", "KEY_ALIAS_DER_CN", "REGISTER_PREFIX", "KEYSTORE_ALIAS", "regHeaders", "", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "hasCredentials", "", "getKeystorePrivateKey", "Ljava/security/PrivateKey;", "ensureRegistered", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reRegister", "resolveCredentials", "performRegistration", "attested", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildLeafCertificate", "", "privateKey", "publicKey", "Ljava/security/interfaces/ECPublicKey;", "buildTbsCertificate", "derCnName", "derLength", "len", "", "derTagged", "tag", "", "content", "primitive", "derSequence", "parts", "", "([[B)[B", "derSet", "derExplicitContextZero", "derInteger", "value", "Ljava/math/BigInteger;", "derOid", "oidBytes", "derUtf8String", "derUtcTime", "derGeneralizedTime", "derBitString", "ECDSA_WITH_SHA256", "ID_EC_PUBLIC_KEY", "PRIME256V1", "toFixedLengthBytes", "", "out", "offset", "length", "sha256", "data", "b64UrlNoPad", "ChallengeResponse", "RegisterResponse", "AniVortex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAniVortexRegistration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniVortexRegistration.kt\ncom/AniVortex/AniVortexRegistration\n+ 2 CloudStreamApp.kt\ncom/lagradost/cloudstream3/CloudStreamApp$Companion\n+ 3 DataStore.kt\ncom/lagradost/cloudstream3/utils/DataStore\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 7 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 8 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,445:1\n144#2:446\n231#3:447\n222#3,3:448\n225#3,2:470\n63#4:451\n64#4,15:453\n93#4,2:493\n63#4:495\n64#4,15:497\n95#4,2:514\n93#4,2:521\n63#4:523\n64#4,15:525\n95#4,2:542\n93#4,2:544\n63#4:546\n64#4,15:548\n95#4,2:565\n93#4,2:567\n63#4:569\n64#4,15:571\n95#4,2:588\n1#5:452\n1#5:472\n1#5:496\n1#5:516\n1#5:524\n1#5:547\n1#5:570\n1#5:590\n50#6:468\n43#6:469\n50#6:512\n43#6:513\n50#6:540\n43#6:541\n50#6:563\n43#6:564\n50#6:586\n43#6:587\n117#7,10:473\n117#7,10:483\n12746#8:517\n13093#8,3:518\n14512#8,3:591\n*S KotlinDebug\n*F\n+ 1 AniVortexRegistration.kt\ncom/AniVortex/AniVortexRegistration\n*L\n81#1:446\n81#1:447\n81#1:448,3\n81#1:470,2\n81#1:451\n81#1:453,15\n133#1:493,2\n133#1:495\n133#1:497,15\n133#1:514,2\n217#1:521,2\n217#1:523\n217#1:525,15\n217#1:542,2\n258#1:544,2\n258#1:546\n258#1:548,15\n258#1:565,2\n304#1:567,2\n304#1:569\n304#1:571,15\n304#1:588,2\n81#1:452\n133#1:496\n217#1:524\n258#1:547\n304#1:570\n81#1:468\n81#1:469\n133#1:512\n133#1:513\n217#1:540\n217#1:541\n258#1:563\n258#1:564\n304#1:586\n304#1:587\n94#1:473,10\n102#1:483,10\n173#1:517\n173#1:518,3\n393#1:591,3\n*E\n"})
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

    /* JADX INFO: renamed from: com.AniVortex.AniVortexRegistration$ensureRegistered$1 */
    /* JADX INFO: compiled from: AniVortexRegistration.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {0, 1}, l = {450, 96}, m = "ensureRegistered", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, nl = {451, 452}, s = {"L$0", "L$0"}, v = 2)
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
            return AniVortexRegistration.this.ensureRegistered((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexRegistration$performRegistration$1 */
    /* JADX INFO: compiled from: AniVortexRegistration.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {124, 207}, m = "performRegistration", n = {"challengeBody", "attested", "challengeBody", "challengeResp", "challenge", "challengeId", "challengeBytes", "privateKey", "chainB64", "canonical", "signer", "proofSig", "chainJson", "registerBody", "attested"}, nl = {129, 212}, s = {"L$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0"}, v = 2)
    static final class C00161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
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

        C00161(Continuation<? super C00161> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexRegistration.this.performRegistration(false, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexRegistration$performRegistration$3 */
    /* JADX INFO: compiled from: AniVortexRegistration.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {249, 294}, m = "performRegistration", n = {"challengeBody", "challengeBody", "challengeResp", "challenge", "challengeId", "challengeBytes", "keyPairGen", "keyPair", "privateKey", "publicKey", "leafDer", "canonical", "signer", "proofSig", "leafB64", "registerBody"}, nl = {254, 299}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14"}, v = 2)
    static final class C00173 extends ContinuationImpl {
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
        int label;
        /* synthetic */ Object result;

        C00173(Continuation<? super C00173> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexRegistration.this.performRegistration((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexRegistration$reRegister$1 */
    /* JADX INFO: compiled from: AniVortexRegistration.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {0, 1}, l = {450, 104}, m = "reRegister", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, nl = {451, 452}, s = {"L$0", "L$0"}, v = 2)
    static final class C00181 extends ContinuationImpl {
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
            return AniVortexRegistration.this.reRegister((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexRegistration$resolveCredentials$1 */
    /* JADX INFO: compiled from: AniVortexRegistration.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {}, l = {115, 116}, m = "resolveCredentials", n = {}, nl = {116, -1}, s = {}, v = 2)
    static final class C00191 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00191(Continuation<? super C00191> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexRegistration.this.resolveCredentials((Continuation) this);
        }
    }

    private AniVortexRegistration() {
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

    /* JADX WARN: Code duplicated, block: B:29:0x0072  */
    /* JADX WARN: Code duplicated, block: B:30:0x0074 A[Catch: all -> 0x0099, TRY_LEAVE, TryCatch #1 {all -> 0x0099, blocks: (B:27:0x006a, B:30:0x0074), top: B:46:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0081 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x0082  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object ensureRegistered(@NotNull Continuation<? super Boolean> continuation) throws Throwable {
        C00111 c00111;
        Mutex $this$withLock_u24default$iv;
        Mutex $this$withLock_u24default$iv2;
        Mutex $this$withLock_u24default$iv3;
        Throwable th;
        Mutex owner$iv;
        Mutex $this$withLock_u24default$iv4;
        Object owner$iv2;
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
        Object $result = c00111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean zBooleanValue = true;
        switch (c00111.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (hasCredentials()) {
                    return Boxing.boxBoolean(true);
                }
                Mutex $this$withLock_u24default$iv5 = mutex;
                $this$withLock_u24default$iv = null;
                c00111.L$0 = $this$withLock_u24default$iv5;
                c00111.label = 1;
                if ($this$withLock_u24default$iv5.lock((Object) null, c00111) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$withLock_u24default$iv2 = $this$withLock_u24default$iv5;
                $this$withLock_u24default$iv3 = null;
                try {
                    if (INSTANCE.hasCredentials()) {
                        AniVortexRegistration aniVortexRegistration = INSTANCE;
                        c00111.L$0 = $this$withLock_u24default$iv2;
                        c00111.label = 2;
                        owner$iv2 = aniVortexRegistration.resolveCredentials(c00111);
                        if (owner$iv2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        try {
                            zBooleanValue = ((Boolean) owner$iv2).booleanValue();
                        } catch (Throwable th2) {
                            th = th2;
                            owner$iv = $this$withLock_u24default$iv;
                            $this$withLock_u24default$iv4 = $this$withLock_u24default$iv2;
                            $this$withLock_u24default$iv4.unlock(owner$iv);
                            throw th;
                        }
                    }
                    Boolean boolBoxBoolean = Boxing.boxBoolean(zBooleanValue);
                    $this$withLock_u24default$iv2.unlock($this$withLock_u24default$iv);
                    return boolBoxBoolean;
                } catch (Throwable th3) {
                    th = th3;
                    owner$iv = $this$withLock_u24default$iv;
                    $this$withLock_u24default$iv4 = $this$withLock_u24default$iv2;
                    $this$withLock_u24default$iv4.unlock(owner$iv);
                    throw th;
                }
            case 1:
                $this$withLock_u24default$iv3 = null;
                $this$withLock_u24default$iv = null;
                $this$withLock_u24default$iv2 = (Mutex) c00111.L$0;
                ResultKt.throwOnFailure($result);
                if (INSTANCE.hasCredentials()) {
                    AniVortexRegistration aniVortexRegistration2 = INSTANCE;
                    c00111.L$0 = $this$withLock_u24default$iv2;
                    c00111.label = 2;
                    owner$iv2 = aniVortexRegistration2.resolveCredentials(c00111);
                    if (owner$iv2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    zBooleanValue = ((Boolean) owner$iv2).booleanValue();
                }
                Boolean boolBoxBoolean2 = Boxing.boxBoolean(zBooleanValue);
                $this$withLock_u24default$iv2.unlock($this$withLock_u24default$iv);
                return boolBoxBoolean2;
            case 2:
                owner$iv = null;
                $this$withLock_u24default$iv4 = (Mutex) c00111.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    $this$withLock_u24default$iv2 = $this$withLock_u24default$iv4;
                    $this$withLock_u24default$iv = null;
                    owner$iv2 = $result;
                    zBooleanValue = ((Boolean) owner$iv2).booleanValue();
                    Boolean boolBoxBoolean3 = Boxing.boxBoolean(zBooleanValue);
                    $this$withLock_u24default$iv2.unlock($this$withLock_u24default$iv);
                    return boolBoxBoolean3;
                } catch (Throwable th4) {
                    th = th4;
                    $this$withLock_u24default$iv4.unlock(owner$iv);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object reRegister(@NotNull Continuation<? super Boolean> continuation) throws Throwable {
        C00181 c00181;
        Object owner$iv;
        Mutex $this$withLock_u24default$iv;
        Mutex $this$withLock_u24default$iv2;
        Throwable th;
        Object objResolveCredentials;
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
                Mutex $this$withLock_u24default$iv3 = mutex;
                owner$iv = null;
                c00181.L$0 = $this$withLock_u24default$iv3;
                c00181.label = 1;
                if ($this$withLock_u24default$iv3.lock((Object) null, c00181) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                $this$withLock_u24default$iv2 = null;
                try {
                    AniVortexAuth.INSTANCE.markCurrentCredentialsInvalid();
                    AniVortexRegistration aniVortexRegistration = INSTANCE;
                    c00181.L$0 = $this$withLock_u24default$iv;
                    c00181.label = 2;
                    objResolveCredentials = aniVortexRegistration.resolveCredentials(c00181);
                    if (objResolveCredentials == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Boolean boolBoxBoolean = Boxing.boxBoolean(((Boolean) objResolveCredentials).booleanValue());
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
                $this$withLock_u24default$iv = (Mutex) c00181.L$0;
                ResultKt.throwOnFailure($result);
                AniVortexAuth.INSTANCE.markCurrentCredentialsInvalid();
                AniVortexRegistration aniVortexRegistration2 = INSTANCE;
                c00181.L$0 = $this$withLock_u24default$iv;
                c00181.label = 2;
                objResolveCredentials = aniVortexRegistration2.resolveCredentials(c00181);
                if (objResolveCredentials == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Boolean boolBoxBoolean2 = Boxing.boxBoolean(((Boolean) objResolveCredentials).booleanValue());
                $this$withLock_u24default$iv.unlock(owner$iv);
                return boolBoxBoolean2;
            case 2:
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex) c00181.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objResolveCredentials = $result;
                    Boolean boolBoxBoolean3 = Boxing.boxBoolean(((Boolean) objResolveCredentials).booleanValue());
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
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object resolveCredentials(Continuation<? super Boolean> continuation) {
        C00191 c00191;
        Object objPerformRegistration;
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
                c00191.label = 1;
                objPerformRegistration = performRegistration(true, c00191);
                if (objPerformRegistration == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objPerformRegistration = $result;
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) objPerformRegistration).booleanValue()) {
            return Boxing.boxBoolean(true);
        }
        c00191.label = 2;
        Object objPerformRegistration2 = performRegistration(false, c00191);
        if (objPerformRegistration2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        return objPerformRegistration2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:0x026c  */
    /* JADX WARN: Code duplicated, block: B:104:0x026f  */
    /* JADX WARN: Code duplicated, block: B:105:0x0276 A[Catch: all -> 0x074e, TRY_ENTER, TRY_LEAVE, TryCatch #20 {all -> 0x074e, blocks: (B:34:0x0141, B:40:0x0186, B:82:0x023f, B:88:0x024b, B:96:0x025b, B:105:0x0276, B:159:0x03e1, B:150:0x038b, B:158:0x03bf), top: B:297:0x0141 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x02f8 A[Catch: all -> 0x02ac, TRY_ENTER, TryCatch #11 {all -> 0x02ac, blocks: (B:112:0x02a8, B:118:0x02f8, B:127:0x0306, B:132:0x0319), top: B:293:0x02a8 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:121:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:123:0x0300  */
    /* JADX WARN: Code duplicated, block: B:124:0x0301  */
    /* JADX WARN: Code duplicated, block: B:125:0x0303  */
    /* JADX WARN: Code duplicated, block: B:127:0x0306 A[Catch: all -> 0x02ac, TRY_LEAVE, TryCatch #11 {all -> 0x02ac, blocks: (B:112:0x02a8, B:118:0x02f8, B:127:0x0306, B:132:0x0319), top: B:293:0x02a8 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x0310  */
    /* JADX WARN: Code duplicated, block: B:132:0x0319 A[Catch: all -> 0x02ac, TRY_ENTER, TRY_LEAVE, TryCatch #11 {all -> 0x02ac, blocks: (B:112:0x02a8, B:118:0x02f8, B:127:0x0306, B:132:0x0319), top: B:293:0x02a8 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x031c  */
    /* JADX WARN: Code duplicated, block: B:138:0x0336 A[Catch: all -> 0x035a, LOOP:0: B:137:0x0334->B:138:0x0336, LOOP_END, TryCatch #24 {all -> 0x035a, blocks: (B:136:0x0321, B:138:0x0336, B:139:0x0352), top: B:303:0x0321 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x0387  */
    /* JADX WARN: Code duplicated, block: B:152:0x03a9 A[Catch: all -> 0x017e, TRY_ENTER, TryCatch #16 {all -> 0x017e, blocks: (B:36:0x014b, B:85:0x0245, B:90:0x024f, B:98:0x0263, B:147:0x0368, B:152:0x03a9, B:155:0x03b0, B:49:0x01b9, B:62:0x01f9, B:65:0x0200, B:73:0x021b, B:72:0x0215, B:60:0x01ee, B:48:0x01af), top: B:296:0x0149 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:155:0x03b0 A[Catch: all -> 0x017e, TRY_LEAVE, TryCatch #16 {all -> 0x017e, blocks: (B:36:0x014b, B:85:0x0245, B:90:0x024f, B:98:0x0263, B:147:0x0368, B:152:0x03a9, B:155:0x03b0, B:49:0x01b9, B:62:0x01f9, B:65:0x0200, B:73:0x021b, B:72:0x0215, B:60:0x01ee, B:48:0x01af), top: B:296:0x0149 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x03bf A[Catch: all -> 0x074e, TRY_ENTER, TryCatch #20 {all -> 0x074e, blocks: (B:34:0x0141, B:40:0x0186, B:82:0x023f, B:88:0x024b, B:96:0x025b, B:105:0x0276, B:159:0x03e1, B:150:0x038b, B:158:0x03bf), top: B:297:0x0141 }] */
    /* JADX WARN: Code duplicated, block: B:163:0x0521 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:164:0x0522  */
    /* JADX WARN: Code duplicated, block: B:167:0x0539 A[Catch: all -> 0x056c, TRY_ENTER, TRY_LEAVE, TryCatch #12 {all -> 0x056c, blocks: (B:167:0x0539, B:260:0x0729, B:161:0x051b), top: B:277:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:171:0x056f  */
    /* JADX WARN: Code duplicated, block: B:175:0x057d  */
    /* JADX WARN: Code duplicated, block: B:176:0x0582  */
    /* JADX WARN: Code duplicated, block: B:183:0x05b1  */
    /* JADX WARN: Code duplicated, block: B:195:0x05f1  */
    /* JADX WARN: Code duplicated, block: B:212:0x0618  */
    /* JADX WARN: Code duplicated, block: B:224:0x0643 A[Catch: all -> 0x071c, TryCatch #27 {all -> 0x071c, blocks: (B:222:0x063f, B:224:0x0643, B:226:0x064c, B:228:0x0650, B:234:0x065c, B:236:0x0664, B:243:0x0672, B:246:0x068e, B:248:0x06b6, B:252:0x06e7, B:247:0x069f, B:253:0x06f7, B:193:0x05eb, B:196:0x05f2, B:213:0x061a, B:211:0x0611, B:192:0x05e1), top: B:291:0x05e1 }] */
    /* JADX WARN: Code duplicated, block: B:225:0x064a  */
    /* JADX WARN: Code duplicated, block: B:228:0x0650 A[Catch: all -> 0x071c, TryCatch #27 {all -> 0x071c, blocks: (B:222:0x063f, B:224:0x0643, B:226:0x064c, B:228:0x0650, B:234:0x065c, B:236:0x0664, B:243:0x0672, B:246:0x068e, B:248:0x06b6, B:252:0x06e7, B:247:0x069f, B:253:0x06f7, B:193:0x05eb, B:196:0x05f2, B:213:0x061a, B:211:0x0611, B:192:0x05e1), top: B:291:0x05e1 }] */
    /* JADX WARN: Code duplicated, block: B:232:0x0659  */
    /* JADX WARN: Code duplicated, block: B:234:0x065c A[Catch: all -> 0x071c, TryCatch #27 {all -> 0x071c, blocks: (B:222:0x063f, B:224:0x0643, B:226:0x064c, B:228:0x0650, B:234:0x065c, B:236:0x0664, B:243:0x0672, B:246:0x068e, B:248:0x06b6, B:252:0x06e7, B:247:0x069f, B:253:0x06f7, B:193:0x05eb, B:196:0x05f2, B:213:0x061a, B:211:0x0611, B:192:0x05e1), top: B:291:0x05e1 }] */
    /* JADX WARN: Code duplicated, block: B:236:0x0664 A[Catch: all -> 0x071c, TryCatch #27 {all -> 0x071c, blocks: (B:222:0x063f, B:224:0x0643, B:226:0x064c, B:228:0x0650, B:234:0x065c, B:236:0x0664, B:243:0x0672, B:246:0x068e, B:248:0x06b6, B:252:0x06e7, B:247:0x069f, B:253:0x06f7, B:193:0x05eb, B:196:0x05f2, B:213:0x061a, B:211:0x0611, B:192:0x05e1), top: B:291:0x05e1 }] */
    /* JADX WARN: Code duplicated, block: B:240:0x066d  */
    /* JADX WARN: Code duplicated, block: B:242:0x0670  */
    /* JADX WARN: Code duplicated, block: B:243:0x0672 A[Catch: all -> 0x071c, TRY_LEAVE, TryCatch #27 {all -> 0x071c, blocks: (B:222:0x063f, B:224:0x0643, B:226:0x064c, B:228:0x0650, B:234:0x065c, B:236:0x0664, B:243:0x0672, B:246:0x068e, B:248:0x06b6, B:252:0x06e7, B:247:0x069f, B:253:0x06f7, B:193:0x05eb, B:196:0x05f2, B:213:0x061a, B:211:0x0611, B:192:0x05e1), top: B:291:0x05e1 }] */
    /* JADX WARN: Code duplicated, block: B:246:0x068e A[Catch: all -> 0x071c, TRY_ENTER, TryCatch #27 {all -> 0x071c, blocks: (B:222:0x063f, B:224:0x0643, B:226:0x064c, B:228:0x0650, B:234:0x065c, B:236:0x0664, B:243:0x0672, B:246:0x068e, B:248:0x06b6, B:252:0x06e7, B:247:0x069f, B:253:0x06f7, B:193:0x05eb, B:196:0x05f2, B:213:0x061a, B:211:0x0611, B:192:0x05e1), top: B:291:0x05e1 }] */
    /* JADX WARN: Code duplicated, block: B:247:0x069f A[Catch: all -> 0x071c, TryCatch #27 {all -> 0x071c, blocks: (B:222:0x063f, B:224:0x0643, B:226:0x064c, B:228:0x0650, B:234:0x065c, B:236:0x0664, B:243:0x0672, B:246:0x068e, B:248:0x06b6, B:252:0x06e7, B:247:0x069f, B:253:0x06f7, B:193:0x05eb, B:196:0x05f2, B:213:0x061a, B:211:0x0611, B:192:0x05e1), top: B:291:0x05e1 }] */
    /* JADX WARN: Code duplicated, block: B:250:0x06e4  */
    /* JADX WARN: Code duplicated, block: B:251:0x06e6  */
    /* JADX WARN: Code duplicated, block: B:259:0x0724  */
    /* JADX WARN: Code duplicated, block: B:278:0x0296 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:287:0x01c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:293:0x02a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:307:0x05b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:311:0x05f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:315:0x0206 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x014b A[Catch: all -> 0x017e, TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x017e, blocks: (B:36:0x014b, B:85:0x0245, B:90:0x024f, B:98:0x0263, B:147:0x0368, B:152:0x03a9, B:155:0x03b0, B:49:0x01b9, B:62:0x01f9, B:65:0x0200, B:73:0x021b, B:72:0x0215, B:60:0x01ee, B:48:0x01af), top: B:296:0x0149 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0186 A[Catch: all -> 0x074e, TRY_ENTER, TRY_LEAVE, TryCatch #20 {all -> 0x074e, blocks: (B:34:0x0141, B:40:0x0186, B:82:0x023f, B:88:0x024b, B:96:0x025b, B:105:0x0276, B:159:0x03e1, B:150:0x038b, B:158:0x03bf), top: B:297:0x0141 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0191  */
    /* JADX WARN: Code duplicated, block: B:44:0x0194  */
    /* JADX WARN: Code duplicated, block: B:51:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:64:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:73:0x021b A[Catch: all -> 0x017e, Exception -> 0x0236, TRY_LEAVE, TryCatch #9 {Exception -> 0x0236, blocks: (B:62:0x01f9, B:65:0x0200, B:73:0x021b, B:72:0x0215, B:60:0x01ee), top: B:289:0x01ee }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Code duplicated, block: B:85:0x0245 A[Catch: all -> 0x017e, TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x017e, blocks: (B:36:0x014b, B:85:0x0245, B:90:0x024f, B:98:0x0263, B:147:0x0368, B:152:0x03a9, B:155:0x03b0, B:49:0x01b9, B:62:0x01f9, B:65:0x0200, B:73:0x021b, B:72:0x0215, B:60:0x01ee, B:48:0x01af), top: B:296:0x0149 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x024a  */
    /* JADX WARN: Code duplicated, block: B:90:0x024f A[Catch: all -> 0x017e, TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x017e, blocks: (B:36:0x014b, B:85:0x0245, B:90:0x024f, B:98:0x0263, B:147:0x0368, B:152:0x03a9, B:155:0x03b0, B:49:0x01b9, B:62:0x01f9, B:65:0x0200, B:73:0x021b, B:72:0x0215, B:60:0x01ee, B:48:0x01af), top: B:296:0x0149 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0258  */
    /* JADX WARN: Code duplicated, block: B:96:0x025b A[Catch: all -> 0x074e, TRY_ENTER, TRY_LEAVE, TryCatch #20 {all -> 0x074e, blocks: (B:34:0x0141, B:40:0x0186, B:82:0x023f, B:88:0x024b, B:96:0x025b, B:105:0x0276, B:159:0x03e1, B:150:0x038b, B:158:0x03bf), top: B:297:0x0141 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0263 A[Catch: all -> 0x017e, TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x017e, blocks: (B:36:0x014b, B:85:0x0245, B:90:0x024f, B:98:0x0263, B:147:0x0368, B:152:0x03a9, B:155:0x03b0, B:49:0x01b9, B:62:0x01f9, B:65:0x0200, B:73:0x021b, B:72:0x0215, B:60:0x01ee, B:48:0x01af), top: B:296:0x0149 }] */
    public final Object performRegistration(boolean attested, Continuation<? super Boolean> continuation) {
        C00161 c00161;
        boolean z;
        String canonical;
        boolean z2;
        boolean z3;
        Object obj;
        String challengeBody;
        Object obj2;
        boolean attested2;
        NiceResponse challengeResp;
        String value$iv;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        ChallengeResponse challenge;
        String challenge_id;
        String str;
        boolean z4;
        boolean z5;
        String challenge2;
        boolean z6;
        byte[] challengeBytes;
        boolean z7;
        KeyStore ks;
        KeyStore ks2;
        Certificate[] chain;
        boolean z8;
        Key key;
        PrivateKey privateKey;
        Collection destination$iv$iv;
        int length;
        int i;
        List chainB64;
        boolean z9;
        boolean z10;
        boolean attested3;
        PrivateKey privateKey2;
        PublicKey publicKey;
        ECPublicKey publicKey2;
        NiceResponse registerResp;
        String value$iv2;
        Object obj7;
        boolean attested4;
        Object objDecodeFromString2;
        String value$iv3;
        DeserializationStrategy deserializationStrategy2;
        String value$iv$iv;
        RegisterResponse reg;
        String installation_id;
        String str2;
        boolean z11;
        String key_id;
        boolean z12;
        boolean z13;
        Continuation<? super Boolean> continuation2 = continuation;
        if (continuation2 instanceof C00161) {
            c00161 = (C00161) continuation2;
            if ((c00161.label & Integer.MIN_VALUE) != 0) {
                c00161.label -= Integer.MIN_VALUE;
            } else {
                c00161 = new C00161(continuation2);
            }
        } else {
            c00161 = new C00161(continuation2);
        }
        C00161 c00162 = c00161;
        Object $result = c00162.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                switch (c00162.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            Log.i(TAG, "Attempting registration flow (attested=" + (attested) + ")...");
                            Requests app = MainActivityKt.getApp();
                            try {
                                Map<String, String> map = regHeaders;
                                RequestBody requestBodyCreate = RequestBody.Companion.create("{\"platform\":\"android\",\"package_name\":\"app.anivortex.mobile\",\"version_name\":\"5.0.1\",\"version_code\":503}", MediaType.Companion.parse("application/json; charset=utf-8"));
                                c00162.L$0 = SpillingKt.nullOutSpilledVariable("{\"platform\":\"android\",\"package_name\":\"app.anivortex.mobile\",\"version_name\":\"5.0.1\",\"version_code\":503}");
                                c00162.Z$0 = attested;
                                c00162.label = 1;
                                canonical = "application/json; charset=utf-8";
                                z2 = false;
                                z3 = true;
                                continuation2 = TAG;
                                obj = coroutine_suspended;
                                try {
                                    Object objPost$default = Requests.post$default(app, "https://api.anivortex.in/api/v1/install/challenge", map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00162, 65276, (Object) null);
                                    c00162 = c00162;
                                    if (objPost$default == obj) {
                                        return obj;
                                    }
                                    challengeBody = "{\"platform\":\"android\",\"package_name\":\"app.anivortex.mobile\",\"version_name\":\"5.0.1\",\"version_code\":503}";
                                    obj2 = objPost$default;
                                    attested2 = attested;
                                    try {
                                        challengeResp = (NiceResponse) obj2;
                                        try {
                                            if (!challengeResp.isSuccessful()) {
                                                Log.w((String) continuation2, "Challenge request returned " + challengeResp.getCode() + ": " + StringsKt.take(challengeResp.getText(), 200));
                                                return Boxing.boxBoolean(z2);
                                            }
                                            AppUtils appUtils = AppUtils.INSTANCE;
                                            value$iv = challengeResp.getText();
                                            if (value$iv == null) {
                                                try {
                                                    Result.Companion companion = Result.Companion;
                                                    KType kTypeTypeOf = Reflection.typeOf(ChallengeResponse.class);
                                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                    obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                                    break;
                                                } catch (Throwable th) {
                                                    try {
                                                        Result.Companion companion2 = Result.Companion;
                                                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                                    } catch (Exception e) {
                                                        obj4 = null;
                                                        challenge = (ChallengeResponse) obj4;
                                                        if (challenge != null) {
                                                            challenge_id = challenge.getChallenge_id();
                                                        } else {
                                                            challenge_id = null;
                                                        }
                                                        str = challenge_id;
                                                        if (str != null) {
                                                            z4 = true;
                                                        } else {
                                                            z4 = true;
                                                        }
                                                        if (!z4) {
                                                            challenge2 = challenge.getChallenge();
                                                            if (challenge2 != null) {
                                                                z6 = true;
                                                            } else {
                                                                z6 = true;
                                                            }
                                                            if (z6) {
                                                                z5 = false;
                                                            } else {
                                                                String challengeId = challenge.getChallenge_id();
                                                                Intrinsics.checkNotNull(challengeId);
                                                                String challenge3 = challenge.getChallenge();
                                                                Intrinsics.checkNotNull(challenge3);
                                                                challengeBytes = Base64.decode(challenge3, 11);
                                                                if (attested2) {
                                                                    try {
                                                                        ks = KeyStore.getInstance("AndroidKeyStore");
                                                                        try {
                                                                            ks.load(null);
                                                                            if (ks.containsAlias(KEYSTORE_ALIAS)) {
                                                                                try {
                                                                                    ks.deleteEntry(KEYSTORE_ALIAS);
                                                                                } catch (Throwable th2) {
                                                                                    e = th2;
                                                                                    z7 = false;
                                                                                }
                                                                            }
                                                                            KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
                                                                            kpg.initialize(new KeyGenParameterSpec.Builder(KEYSTORE_ALIAS, 4).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests("SHA-256").setUserAuthenticationRequired(false).setAttestationChallenge(challengeBytes).build());
                                                                            kpg.generateKeyPair();
                                                                            ks2 = KeyStore.getInstance("AndroidKeyStore");
                                                                            ks2.load(null);
                                                                            chain = ks2.getCertificateChain(KEYSTORE_ALIAS);
                                                                            if (chain == null) {
                                                                                z8 = true;
                                                                            } else {
                                                                                if (chain.length == 0) {
                                                                                    z9 = true;
                                                                                } else {
                                                                                    z9 = false;
                                                                                }
                                                                                if (z9) {
                                                                                    z8 = true;
                                                                                } else {
                                                                                    z8 = false;
                                                                                }
                                                                            }
                                                                            if (z8) {
                                                                                Log.w((String) continuation2, "AndroidKeyStore returned no attestation chain");
                                                                                return Boxing.boxBoolean(false);
                                                                            }
                                                                            key = ks2.getKey(KEYSTORE_ALIAS, null);
                                                                            if (key instanceof PrivateKey) {
                                                                                privateKey = (PrivateKey) key;
                                                                            } else {
                                                                                privateKey = null;
                                                                            }
                                                                            z7 = false;
                                                                            try {
                                                                                destination$iv$iv = new ArrayList(chain.length);
                                                                                i = 0;
                                                                                for (length = chain.length; i < length; length = length) {
                                                                                    destination$iv$iv.add(Base64.encodeToString(chain[i].getEncoded(), 2));
                                                                                    i++;
                                                                                }
                                                                                chainB64 = (List) destination$iv$iv;
                                                                            } catch (Throwable th3) {
                                                                                e = th3;
                                                                            }
                                                                        } catch (Throwable th4) {
                                                                            e = th4;
                                                                            z7 = false;
                                                                        }
                                                                        break;
                                                                    } catch (Throwable th5) {
                                                                        e = th5;
                                                                        z7 = false;
                                                                    }
                                                                    Log.w((String) continuation2, "Attested key generation failed: " + e.getMessage());
                                                                    return Boxing.boxBoolean(z7);
                                                                }
                                                                KeyPairGenerator kpg2 = KeyPairGenerator.getInstance("EC");
                                                                kpg2.initialize(new ECGenParameterSpec("secp256r1"));
                                                                KeyPair keyPair = kpg2.generateKeyPair();
                                                                privateKey = keyPair.getPrivate();
                                                                publicKey = keyPair.getPublic();
                                                                if (publicKey instanceof ECPublicKey) {
                                                                    publicKey2 = (ECPublicKey) publicKey;
                                                                } else {
                                                                    publicKey2 = null;
                                                                }
                                                                if (publicKey2 == null) {
                                                                    AniVortexRegistration aniVortexRegistration = this;
                                                                    Log.w((String) continuation2, "Generated key is not EC");
                                                                    return Boxing.boxBoolean(false);
                                                                }
                                                                byte[] leafDer = buildLeafCertificate(privateKey, publicKey2);
                                                                CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(leafDer));
                                                                String leafB64 = Base64.encodeToString(leafDer, 2);
                                                                List chainB65 = CollectionsKt.listOf(new String[]{leafB64, leafB64});
                                                                chainB64 = chainB65;
                                                                String canonical2 = "ANIVORTEX-INSTALL-REGISTER-V1\n" + challengeId + '\n' + b64UrlNoPad(sha256(challengeBytes));
                                                                Signature signer = Signature.getInstance("SHA256withECDSA");
                                                                Intrinsics.checkNotNull(privateKey);
                                                                signer.initSign(privateKey);
                                                                byte[] bytes = canonical2.getBytes(Charsets.UTF_8);
                                                                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                                                                signer.update(bytes);
                                                                String proofSig = b64UrlNoPad(signer.sign());
                                                                String chainJson = CollectionsKt.joinToString$default(chainB64, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.AniVortex.AniVortexRegistration$$ExternalSyntheticLambda0
                                                                    public final Object invoke(Object obj8) {
                                                                        return AniVortexRegistration.performRegistration$lambda$4((String) obj8);
                                                                    }
                                                                }, 30, (Object) null);
                                                                String registerBody = "{\"challenge_id\":\"" + challengeId + "\",\"certificate_chain\":[" + chainJson + "],\"proof_signature\":\"" + proofSig + "\"}";
                                                                Requests app2 = MainActivityKt.getApp();
                                                                Map<String, String> map2 = regHeaders;
                                                                List chainB66 = chainB64;
                                                                RequestBody requestBodyCreate2 = RequestBody.Companion.create(registerBody, MediaType.Companion.parse(canonical));
                                                                c00162.L$0 = SpillingKt.nullOutSpilledVariable(challengeBody);
                                                                c00162.L$1 = SpillingKt.nullOutSpilledVariable(challengeResp);
                                                                c00162.L$2 = SpillingKt.nullOutSpilledVariable(challenge);
                                                                c00162.L$3 = SpillingKt.nullOutSpilledVariable(challengeId);
                                                                c00162.L$4 = SpillingKt.nullOutSpilledVariable(challengeBytes);
                                                                c00162.L$5 = privateKey;
                                                                c00162.L$6 = SpillingKt.nullOutSpilledVariable(chainB66);
                                                                c00162.L$7 = SpillingKt.nullOutSpilledVariable(canonical2);
                                                                c00162.L$8 = SpillingKt.nullOutSpilledVariable(signer);
                                                                c00162.L$9 = SpillingKt.nullOutSpilledVariable(proofSig);
                                                                c00162.L$10 = SpillingKt.nullOutSpilledVariable(chainJson);
                                                                c00162.L$11 = SpillingKt.nullOutSpilledVariable(registerBody);
                                                                c00162.Z$0 = attested2;
                                                                c00162.label = 2;
                                                                z10 = false;
                                                                attested3 = attested2;
                                                                $result = Requests.post$default(app2, "https://api.anivortex.in/api/v1/install/register", map2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00162, 65276, (Object) null);
                                                                if ($result == obj) {
                                                                    return obj;
                                                                }
                                                                privateKey2 = privateKey;
                                                                try {
                                                                    registerResp = (NiceResponse) $result;
                                                                    if (!registerResp.isSuccessful()) {
                                                                        Log.w((String) continuation2, "Register returned (" + registerResp.getCode() + "): " + StringsKt.take(registerResp.getText(), 300));
                                                                        return Boxing.boxBoolean(z10);
                                                                    }
                                                                    AppUtils appUtils2 = AppUtils.INSTANCE;
                                                                    value$iv2 = registerResp.getText();
                                                                    if (value$iv2 == null) {
                                                                        try {
                                                                            Result.Companion companion3 = Result.Companion;
                                                                            KType kTypeTypeOf2 = Reflection.typeOf(RegisterResponse.class);
                                                                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                                            obj7 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                                                            break;
                                                                        } catch (Throwable th6) {
                                                                            try {
                                                                                Result.Companion companion4 = Result.Companion;
                                                                                obj7 = Result.constructor-impl(ResultKt.createFailure(th6));
                                                                            } catch (Exception e2) {
                                                                                attested4 = attested3;
                                                                                objDecodeFromString2 = null;
                                                                                reg = (RegisterResponse) objDecodeFromString2;
                                                                                if (reg != null) {
                                                                                    installation_id = reg.getInstallation_id();
                                                                                } else {
                                                                                    installation_id = null;
                                                                                }
                                                                                str2 = installation_id;
                                                                                if (str2 != null) {
                                                                                    z11 = true;
                                                                                } else {
                                                                                    z11 = true;
                                                                                }
                                                                                if (!z11) {
                                                                                    key_id = reg.getKey_id();
                                                                                    if (key_id != null) {
                                                                                        z12 = true;
                                                                                    } else {
                                                                                        z12 = true;
                                                                                    }
                                                                                    if (!z12) {
                                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", reg.getInstallation_id());
                                                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", reg.getKey_id());
                                                                                        if (attested4) {
                                                                                            CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z3));
                                                                                            CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", "");
                                                                                        } else {
                                                                                            CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z10));
                                                                                            CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey2.getEncoded(), 2));
                                                                                        }
                                                                                        AniVortexAuth.INSTANCE.invalidateCache();
                                                                                        StringBuilder sbAppend = new StringBuilder().append("Registration complete! installation_id=").append(reg.getInstallation_id()).append(" key_id=").append(reg.getKey_id()).append(" attested=");
                                                                                        if (attested4) {
                                                                                            z13 = true;
                                                                                        } else {
                                                                                            z13 = false;
                                                                                        }
                                                                                        Log.i(continuation2, sbAppend.append(z13).toString());
                                                                                        z = true;
                                                                                        return Boxing.boxBoolean(z);
                                                                                    }
                                                                                }
                                                                                Log.w((String) continuation2, "Register response missing fields: " + StringsKt.take(registerResp.getText(), 300));
                                                                                return Boxing.boxBoolean(z10);
                                                                            }
                                                                        }
                                                                        if (Result.exceptionOrNull-impl(obj7) != null) {
                                                                            attested4 = attested3;
                                                                            value$iv3 = null;
                                                                        } else {
                                                                            try {
                                                                                Result.Companion companion5 = Result.Companion;
                                                                                attested4 = attested3;
                                                                                value$iv3 = null;
                                                                                try {
                                                                                    obj7 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(RegisterResponse.class), (List) null, 2, (Object) null));
                                                                                    break;
                                                                                } catch (Throwable th7) {
                                                                                    th = th7;
                                                                                    try {
                                                                                        try {
                                                                                            Result.Companion companion6 = Result.Companion;
                                                                                            obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                                        } catch (Exception e3) {
                                                                                            objDecodeFromString2 = null;
                                                                                        }
                                                                                    } catch (Throwable th8) {
                                                                                        e = th8;
                                                                                        Log.w((String) continuation2, "Registration failed: " + e.getMessage());
                                                                                        z = false;
                                                                                    }
                                                                                }
                                                                            } catch (Throwable th9) {
                                                                                th = th9;
                                                                                attested4 = attested3;
                                                                                value$iv3 = null;
                                                                            }
                                                                        }
                                                                        if (Result.isFailure-impl(obj7)) {
                                                                            obj7 = value$iv3;
                                                                        }
                                                                        deserializationStrategy2 = (KSerializer) obj7;
                                                                        if (deserializationStrategy2 != null) {
                                                                            try {
                                                                                value$iv$iv = value$iv2;
                                                                                try {
                                                                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv$iv);
                                                                                } catch (SerializationException e4) {
                                                                                    e$iv$iv = e4;
                                                                                    ArchComponentExtKt.logError((Throwable) e$iv$iv);
                                                                                    ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                                                                    String content$iv$iv$iv = value$iv$iv;
                                                                                    objDecodeFromString2 = $this$readValue$iv$iv$iv.readValue(content$iv$iv$iv, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                                                                                    });
                                                                                } catch (Throwable th10) {
                                                                                    ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                                                                    String content$iv$iv$iv2 = value$iv$iv;
                                                                                    objDecodeFromString2 = $this$readValue$iv$iv$iv2.readValue(content$iv$iv$iv2, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                                                                                    });
                                                                                }
                                                                            } catch (SerializationException e5) {
                                                                                e$iv$iv = e5;
                                                                                value$iv$iv = value$iv2;
                                                                            } catch (Throwable th11) {
                                                                                value$iv$iv = value$iv2;
                                                                            }
                                                                        } else {
                                                                            value$iv$iv = value$iv2;
                                                                        }
                                                                        ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                                                        String content$iv$iv$iv3 = value$iv$iv;
                                                                        objDecodeFromString2 = $this$readValue$iv$iv$iv3.readValue(content$iv$iv$iv3, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                                                                        });
                                                                        break;
                                                                    } else {
                                                                        attested4 = attested3;
                                                                        objDecodeFromString2 = null;
                                                                    }
                                                                    reg = (RegisterResponse) objDecodeFromString2;
                                                                    if (reg != null) {
                                                                        installation_id = reg.getInstallation_id();
                                                                    } else {
                                                                        installation_id = null;
                                                                    }
                                                                    str2 = installation_id;
                                                                    if (str2 != null) {
                                                                        z11 = true;
                                                                    } else {
                                                                        z11 = true;
                                                                    }
                                                                    if (!z11) {
                                                                        key_id = reg.getKey_id();
                                                                        if (key_id != null) {
                                                                            z12 = true;
                                                                        } else {
                                                                            z12 = true;
                                                                        }
                                                                        if (!z12) {
                                                                            CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", reg.getInstallation_id());
                                                                            CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", reg.getKey_id());
                                                                            if (attested4) {
                                                                                CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z3));
                                                                                CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", "");
                                                                            } else {
                                                                                CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z10));
                                                                                CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey2.getEncoded(), 2));
                                                                            }
                                                                            AniVortexAuth.INSTANCE.invalidateCache();
                                                                            StringBuilder sbAppend2 = new StringBuilder().append("Registration complete! installation_id=").append(reg.getInstallation_id()).append(" key_id=").append(reg.getKey_id()).append(" attested=");
                                                                            if (attested4) {
                                                                                z13 = true;
                                                                            } else {
                                                                                z13 = false;
                                                                            }
                                                                            Log.i(continuation2, sbAppend2.append(z13).toString());
                                                                            z = true;
                                                                            return Boxing.boxBoolean(z);
                                                                        }
                                                                    }
                                                                    Log.w((String) continuation2, "Register response missing fields: " + StringsKt.take(registerResp.getText(), 300));
                                                                    return Boxing.boxBoolean(z10);
                                                                } catch (Throwable th12) {
                                                                    e = th12;
                                                                }
                                                            }
                                                            Log.w((String) continuation2, "Registration failed: " + e.getMessage());
                                                            z = false;
                                                            return Boxing.boxBoolean(z);
                                                        }
                                                        z5 = false;
                                                        Log.w((String) continuation2, "Invalid challenge response: " + StringsKt.take(challengeResp.getText(), 300));
                                                        return Boxing.boxBoolean(z5);
                                                    }
                                                }
                                                if (Result.exceptionOrNull-impl(obj3) == null) {
                                                    obj6 = obj3;
                                                } else {
                                                    try {
                                                        Result.Companion companion7 = Result.Companion;
                                                        try {
                                                            obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ChallengeResponse.class), (List) null, 2, (Object) null));
                                                            break;
                                                        } catch (Throwable th13) {
                                                            th = th13;
                                                            try {
                                                                Result.Companion companion8 = Result.Companion;
                                                                obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                                            } catch (Exception e6) {
                                                                obj4 = null;
                                                            }
                                                        }
                                                    } catch (Throwable th14) {
                                                        th = th14;
                                                    }
                                                    obj6 = obj5;
                                                }
                                                if (Result.isFailure-impl(obj6)) {
                                                    obj6 = null;
                                                }
                                                deserializationStrategy = (KSerializer) obj6;
                                                if (deserializationStrategy != null) {
                                                    try {
                                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                                    } catch (SerializationException e7) {
                                                        ArchComponentExtKt.logError(e7);
                                                        ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                                                        objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(value$iv, new TypeReference<ChallengeResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$1
                                                        });
                                                    } catch (Throwable th15) {
                                                        ObjectMapper $this$readValue$iv$iv$iv5 = MainAPIKt.getMapper();
                                                        objDecodeFromString = $this$readValue$iv$iv$iv5.readValue(value$iv, new TypeReference<ChallengeResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$1
                                                        });
                                                    }
                                                } else {
                                                    ObjectMapper $this$readValue$iv$iv$iv6 = MainAPIKt.getMapper();
                                                    objDecodeFromString = $this$readValue$iv$iv$iv6.readValue(value$iv, new TypeReference<ChallengeResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$1
                                                    });
                                                }
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
                                            str = challenge_id;
                                            if (str != null || str.length() == 0) {
                                                z4 = true;
                                            } else {
                                                z4 = false;
                                            }
                                            if (!z4) {
                                                challenge2 = challenge.getChallenge();
                                                if (challenge2 != null || challenge2.length() == 0) {
                                                    z6 = true;
                                                } else {
                                                    z6 = false;
                                                }
                                                if (z6) {
                                                    String challengeId2 = challenge.getChallenge_id();
                                                    Intrinsics.checkNotNull(challengeId2);
                                                    String challenge4 = challenge.getChallenge();
                                                    Intrinsics.checkNotNull(challenge4);
                                                    challengeBytes = Base64.decode(challenge4, 11);
                                                    if (attested2) {
                                                        ks = KeyStore.getInstance("AndroidKeyStore");
                                                        ks.load(null);
                                                        if (ks.containsAlias(KEYSTORE_ALIAS)) {
                                                            ks.deleteEntry(KEYSTORE_ALIAS);
                                                        }
                                                        KeyPairGenerator kpg3 = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
                                                        kpg3.initialize(new KeyGenParameterSpec.Builder(KEYSTORE_ALIAS, 4).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests("SHA-256").setUserAuthenticationRequired(false).setAttestationChallenge(challengeBytes).build());
                                                        kpg3.generateKeyPair();
                                                        ks2 = KeyStore.getInstance("AndroidKeyStore");
                                                        ks2.load(null);
                                                        chain = ks2.getCertificateChain(KEYSTORE_ALIAS);
                                                        if (chain == null) {
                                                            z8 = true;
                                                        } else {
                                                            if (chain.length == 0) {
                                                                z9 = true;
                                                            } else {
                                                                z9 = false;
                                                            }
                                                            if (z9) {
                                                                z8 = true;
                                                            } else {
                                                                z8 = false;
                                                            }
                                                        }
                                                        if (z8) {
                                                            Log.w((String) continuation2, "AndroidKeyStore returned no attestation chain");
                                                            return Boxing.boxBoolean(false);
                                                        }
                                                        key = ks2.getKey(KEYSTORE_ALIAS, null);
                                                        if (key instanceof PrivateKey) {
                                                            privateKey = (PrivateKey) key;
                                                        } else {
                                                            privateKey = null;
                                                        }
                                                        z7 = false;
                                                        destination$iv$iv = new ArrayList(chain.length);
                                                        i = 0;
                                                        while (i < length) {
                                                            destination$iv$iv.add(Base64.encodeToString(chain[i].getEncoded(), 2));
                                                            i++;
                                                        }
                                                        chainB64 = (List) destination$iv$iv;
                                                        break;
                                                        Log.w((String) continuation2, "Attested key generation failed: " + e.getMessage());
                                                        return Boxing.boxBoolean(z7);
                                                    }
                                                    KeyPairGenerator kpg4 = KeyPairGenerator.getInstance("EC");
                                                    kpg4.initialize(new ECGenParameterSpec("secp256r1"));
                                                    KeyPair keyPair2 = kpg4.generateKeyPair();
                                                    privateKey = keyPair2.getPrivate();
                                                    publicKey = keyPair2.getPublic();
                                                    if (publicKey instanceof ECPublicKey) {
                                                        publicKey2 = (ECPublicKey) publicKey;
                                                    } else {
                                                        publicKey2 = null;
                                                    }
                                                    if (publicKey2 == null) {
                                                        AniVortexRegistration aniVortexRegistration2 = this;
                                                        Log.w((String) continuation2, "Generated key is not EC");
                                                        return Boxing.boxBoolean(false);
                                                    }
                                                    byte[] leafDer2 = buildLeafCertificate(privateKey, publicKey2);
                                                    CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(leafDer2));
                                                    String leafB65 = Base64.encodeToString(leafDer2, 2);
                                                    List chainB67 = CollectionsKt.listOf(new String[]{leafB65, leafB65});
                                                    chainB64 = chainB67;
                                                    String canonical3 = "ANIVORTEX-INSTALL-REGISTER-V1\n" + challengeId2 + '\n' + b64UrlNoPad(sha256(challengeBytes));
                                                    Signature signer2 = Signature.getInstance("SHA256withECDSA");
                                                    Intrinsics.checkNotNull(privateKey);
                                                    signer2.initSign(privateKey);
                                                    byte[] bytes2 = canonical3.getBytes(Charsets.UTF_8);
                                                    Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                                                    signer2.update(bytes2);
                                                    String proofSig2 = b64UrlNoPad(signer2.sign());
                                                    String chainJson2 = CollectionsKt.joinToString$default(chainB64, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.AniVortex.AniVortexRegistration$$ExternalSyntheticLambda0
                                                        public final Object invoke(Object obj8) {
                                                            return AniVortexRegistration.performRegistration$lambda$4((String) obj8);
                                                        }
                                                    }, 30, (Object) null);
                                                    String registerBody2 = "{\"challenge_id\":\"" + challengeId2 + "\",\"certificate_chain\":[" + chainJson2 + "],\"proof_signature\":\"" + proofSig2 + "\"}";
                                                    Requests app3 = MainActivityKt.getApp();
                                                    Map<String, String> map3 = regHeaders;
                                                    List chainB68 = chainB64;
                                                    RequestBody requestBodyCreate3 = RequestBody.Companion.create(registerBody2, MediaType.Companion.parse(canonical));
                                                    c00162.L$0 = SpillingKt.nullOutSpilledVariable(challengeBody);
                                                    c00162.L$1 = SpillingKt.nullOutSpilledVariable(challengeResp);
                                                    c00162.L$2 = SpillingKt.nullOutSpilledVariable(challenge);
                                                    c00162.L$3 = SpillingKt.nullOutSpilledVariable(challengeId2);
                                                    c00162.L$4 = SpillingKt.nullOutSpilledVariable(challengeBytes);
                                                    c00162.L$5 = privateKey;
                                                    c00162.L$6 = SpillingKt.nullOutSpilledVariable(chainB68);
                                                    c00162.L$7 = SpillingKt.nullOutSpilledVariable(canonical3);
                                                    c00162.L$8 = SpillingKt.nullOutSpilledVariable(signer2);
                                                    c00162.L$9 = SpillingKt.nullOutSpilledVariable(proofSig2);
                                                    c00162.L$10 = SpillingKt.nullOutSpilledVariable(chainJson2);
                                                    c00162.L$11 = SpillingKt.nullOutSpilledVariable(registerBody2);
                                                    c00162.Z$0 = attested2;
                                                    c00162.label = 2;
                                                    z10 = false;
                                                    attested3 = attested2;
                                                    $result = Requests.post$default(app3, "https://api.anivortex.in/api/v1/install/register", map3, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate3, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00162, 65276, (Object) null);
                                                    if ($result == obj) {
                                                        return obj;
                                                    }
                                                    privateKey2 = privateKey;
                                                    registerResp = (NiceResponse) $result;
                                                    if (!registerResp.isSuccessful()) {
                                                        Log.w((String) continuation2, "Register returned (" + registerResp.getCode() + "): " + StringsKt.take(registerResp.getText(), 300));
                                                        return Boxing.boxBoolean(z10);
                                                    }
                                                    AppUtils appUtils3 = AppUtils.INSTANCE;
                                                    value$iv2 = registerResp.getText();
                                                    if (value$iv2 == null) {
                                                        Result.Companion companion9 = Result.Companion;
                                                        KType kTypeTypeOf3 = Reflection.typeOf(RegisterResponse.class);
                                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                        obj7 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                                        if (Result.exceptionOrNull-impl(obj7) != null) {
                                                            Result.Companion companion10 = Result.Companion;
                                                            attested4 = attested3;
                                                            value$iv3 = null;
                                                            obj7 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(RegisterResponse.class), (List) null, 2, (Object) null));
                                                        } else {
                                                            attested4 = attested3;
                                                            value$iv3 = null;
                                                        }
                                                        if (Result.isFailure-impl(obj7)) {
                                                            obj7 = value$iv3;
                                                        }
                                                        deserializationStrategy2 = (KSerializer) obj7;
                                                        if (deserializationStrategy2 != null) {
                                                            value$iv$iv = value$iv2;
                                                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv$iv);
                                                        } else {
                                                            value$iv$iv = value$iv2;
                                                        }
                                                        ObjectMapper $this$readValue$iv$iv$iv7 = MainAPIKt.getMapper();
                                                        String content$iv$iv$iv4 = value$iv$iv;
                                                        objDecodeFromString2 = $this$readValue$iv$iv$iv7.readValue(content$iv$iv$iv4, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                                                        });
                                                        break;
                                                    } else {
                                                        attested4 = attested3;
                                                        objDecodeFromString2 = null;
                                                    }
                                                    reg = (RegisterResponse) objDecodeFromString2;
                                                    if (reg != null) {
                                                        installation_id = reg.getInstallation_id();
                                                    } else {
                                                        installation_id = null;
                                                    }
                                                    str2 = installation_id;
                                                    if (str2 != null || str2.length() == 0) {
                                                        z11 = true;
                                                    } else {
                                                        z11 = false;
                                                    }
                                                    if (!z11) {
                                                        key_id = reg.getKey_id();
                                                        if (key_id != null || key_id.length() == 0) {
                                                            z12 = true;
                                                        } else {
                                                            z12 = false;
                                                        }
                                                        if (!z12) {
                                                            CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", reg.getInstallation_id());
                                                            CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", reg.getKey_id());
                                                            if (attested4) {
                                                                CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z3));
                                                                CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", "");
                                                            } else {
                                                                CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z10));
                                                                CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey2.getEncoded(), 2));
                                                            }
                                                            AniVortexAuth.INSTANCE.invalidateCache();
                                                            StringBuilder sbAppend3 = new StringBuilder().append("Registration complete! installation_id=").append(reg.getInstallation_id()).append(" key_id=").append(reg.getKey_id()).append(" attested=");
                                                            if (attested4) {
                                                                z13 = true;
                                                            } else {
                                                                z13 = false;
                                                            }
                                                            Log.i(continuation2, sbAppend3.append(z13).toString());
                                                            z = true;
                                                            return Boxing.boxBoolean(z);
                                                        }
                                                    }
                                                    Log.w((String) continuation2, "Register response missing fields: " + StringsKt.take(registerResp.getText(), 300));
                                                    return Boxing.boxBoolean(z10);
                                                }
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            Log.w((String) continuation2, "Invalid challenge response: " + StringsKt.take(challengeResp.getText(), 300));
                                            return Boxing.boxBoolean(z5);
                                        } catch (Throwable th16) {
                                            e = th16;
                                        }
                                    } catch (Throwable th17) {
                                        e = th17;
                                    }
                                    Log.w((String) continuation2, "Registration failed: " + e.getMessage());
                                    z = false;
                                    return Boxing.boxBoolean(z);
                                } catch (Throwable th18) {
                                    e = th18;
                                }
                            } catch (Throwable th19) {
                                e = th19;
                                continuation2 = TAG;
                            }
                        } catch (Throwable th20) {
                            e = th20;
                            continuation2 = TAG;
                        }
                        break;
                    case 1:
                        boolean attested5 = c00162.Z$0;
                        String challengeBody2 = (String) c00162.L$0;
                        ResultKt.throwOnFailure($result);
                        challengeBody = challengeBody2;
                        obj2 = $result;
                        canonical = "application/json; charset=utf-8";
                        continuation2 = TAG;
                        z2 = false;
                        z3 = true;
                        attested2 = attested5;
                        obj = coroutine_suspended;
                        challengeResp = (NiceResponse) obj2;
                        if (!challengeResp.isSuccessful()) {
                            Log.w((String) continuation2, "Challenge request returned " + challengeResp.getCode() + ": " + StringsKt.take(challengeResp.getText(), 200));
                            return Boxing.boxBoolean(z2);
                        }
                        AppUtils appUtils4 = AppUtils.INSTANCE;
                        value$iv = challengeResp.getText();
                        if (value$iv == null) {
                            Result.Companion companion11 = Result.Companion;
                            KType kTypeTypeOf4 = Reflection.typeOf(ChallengeResponse.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                            if (Result.exceptionOrNull-impl(obj3) == null) {
                                obj6 = obj3;
                            } else {
                                Result.Companion companion12 = Result.Companion;
                                obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ChallengeResponse.class), (List) null, 2, (Object) null));
                                obj6 = obj5;
                            }
                            if (Result.isFailure-impl(obj6)) {
                                obj6 = null;
                            }
                            deserializationStrategy = (KSerializer) obj6;
                            if (deserializationStrategy != null) {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv8 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv8.readValue(value$iv, new TypeReference<ChallengeResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$1
                                });
                            }
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
                        str = challenge_id;
                        if (str != null) {
                            z4 = true;
                        } else {
                            z4 = true;
                        }
                        if (!z4) {
                            challenge2 = challenge.getChallenge();
                            if (challenge2 != null) {
                                z6 = true;
                            } else {
                                z6 = true;
                            }
                            if (z6) {
                                String challengeId3 = challenge.getChallenge_id();
                                Intrinsics.checkNotNull(challengeId3);
                                String challenge5 = challenge.getChallenge();
                                Intrinsics.checkNotNull(challenge5);
                                challengeBytes = Base64.decode(challenge5, 11);
                                if (attested2) {
                                    ks = KeyStore.getInstance("AndroidKeyStore");
                                    ks.load(null);
                                    if (ks.containsAlias(KEYSTORE_ALIAS)) {
                                        ks.deleteEntry(KEYSTORE_ALIAS);
                                    }
                                    KeyPairGenerator kpg5 = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
                                    kpg5.initialize(new KeyGenParameterSpec.Builder(KEYSTORE_ALIAS, 4).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests("SHA-256").setUserAuthenticationRequired(false).setAttestationChallenge(challengeBytes).build());
                                    kpg5.generateKeyPair();
                                    ks2 = KeyStore.getInstance("AndroidKeyStore");
                                    ks2.load(null);
                                    chain = ks2.getCertificateChain(KEYSTORE_ALIAS);
                                    if (chain == null) {
                                        z8 = true;
                                    } else {
                                        if (chain.length == 0) {
                                            z9 = true;
                                        } else {
                                            z9 = false;
                                        }
                                        if (z9) {
                                            z8 = true;
                                        } else {
                                            z8 = false;
                                        }
                                    }
                                    if (z8) {
                                        Log.w((String) continuation2, "AndroidKeyStore returned no attestation chain");
                                        return Boxing.boxBoolean(false);
                                    }
                                    key = ks2.getKey(KEYSTORE_ALIAS, null);
                                    if (key instanceof PrivateKey) {
                                        privateKey = (PrivateKey) key;
                                    } else {
                                        privateKey = null;
                                    }
                                    z7 = false;
                                    destination$iv$iv = new ArrayList(chain.length);
                                    i = 0;
                                    while (i < length) {
                                        destination$iv$iv.add(Base64.encodeToString(chain[i].getEncoded(), 2));
                                        i++;
                                    }
                                    chainB64 = (List) destination$iv$iv;
                                    break;
                                    Log.w((String) continuation2, "Attested key generation failed: " + e.getMessage());
                                    return Boxing.boxBoolean(z7);
                                }
                                KeyPairGenerator kpg6 = KeyPairGenerator.getInstance("EC");
                                kpg6.initialize(new ECGenParameterSpec("secp256r1"));
                                KeyPair keyPair3 = kpg6.generateKeyPair();
                                privateKey = keyPair3.getPrivate();
                                publicKey = keyPair3.getPublic();
                                if (publicKey instanceof ECPublicKey) {
                                    publicKey2 = (ECPublicKey) publicKey;
                                } else {
                                    publicKey2 = null;
                                }
                                if (publicKey2 == null) {
                                    AniVortexRegistration aniVortexRegistration3 = this;
                                    Log.w((String) continuation2, "Generated key is not EC");
                                    return Boxing.boxBoolean(false);
                                }
                                byte[] leafDer3 = buildLeafCertificate(privateKey, publicKey2);
                                CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(leafDer3));
                                String leafB66 = Base64.encodeToString(leafDer3, 2);
                                List chainB69 = CollectionsKt.listOf(new String[]{leafB66, leafB66});
                                chainB64 = chainB69;
                                String canonical4 = "ANIVORTEX-INSTALL-REGISTER-V1\n" + challengeId3 + '\n' + b64UrlNoPad(sha256(challengeBytes));
                                Signature signer3 = Signature.getInstance("SHA256withECDSA");
                                Intrinsics.checkNotNull(privateKey);
                                signer3.initSign(privateKey);
                                byte[] bytes3 = canonical4.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
                                signer3.update(bytes3);
                                String proofSig3 = b64UrlNoPad(signer3.sign());
                                String chainJson3 = CollectionsKt.joinToString$default(chainB64, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.AniVortex.AniVortexRegistration$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj8) {
                                        return AniVortexRegistration.performRegistration$lambda$4((String) obj8);
                                    }
                                }, 30, (Object) null);
                                String registerBody3 = "{\"challenge_id\":\"" + challengeId3 + "\",\"certificate_chain\":[" + chainJson3 + "],\"proof_signature\":\"" + proofSig3 + "\"}";
                                Requests app4 = MainActivityKt.getApp();
                                Map<String, String> map4 = regHeaders;
                                List chainB610 = chainB64;
                                RequestBody requestBodyCreate4 = RequestBody.Companion.create(registerBody3, MediaType.Companion.parse(canonical));
                                c00162.L$0 = SpillingKt.nullOutSpilledVariable(challengeBody);
                                c00162.L$1 = SpillingKt.nullOutSpilledVariable(challengeResp);
                                c00162.L$2 = SpillingKt.nullOutSpilledVariable(challenge);
                                c00162.L$3 = SpillingKt.nullOutSpilledVariable(challengeId3);
                                c00162.L$4 = SpillingKt.nullOutSpilledVariable(challengeBytes);
                                c00162.L$5 = privateKey;
                                c00162.L$6 = SpillingKt.nullOutSpilledVariable(chainB610);
                                c00162.L$7 = SpillingKt.nullOutSpilledVariable(canonical4);
                                c00162.L$8 = SpillingKt.nullOutSpilledVariable(signer3);
                                c00162.L$9 = SpillingKt.nullOutSpilledVariable(proofSig3);
                                c00162.L$10 = SpillingKt.nullOutSpilledVariable(chainJson3);
                                c00162.L$11 = SpillingKt.nullOutSpilledVariable(registerBody3);
                                c00162.Z$0 = attested2;
                                c00162.label = 2;
                                z10 = false;
                                attested3 = attested2;
                                $result = Requests.post$default(app4, "https://api.anivortex.in/api/v1/install/register", map4, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate4, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00162, 65276, (Object) null);
                                if ($result == obj) {
                                    return obj;
                                }
                                privateKey2 = privateKey;
                                registerResp = (NiceResponse) $result;
                                if (!registerResp.isSuccessful()) {
                                    Log.w((String) continuation2, "Register returned (" + registerResp.getCode() + "): " + StringsKt.take(registerResp.getText(), 300));
                                    return Boxing.boxBoolean(z10);
                                }
                                AppUtils appUtils5 = AppUtils.INSTANCE;
                                value$iv2 = registerResp.getText();
                                if (value$iv2 == null) {
                                    Result.Companion companion13 = Result.Companion;
                                    KType kTypeTypeOf5 = Reflection.typeOf(RegisterResponse.class);
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj7 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                                    if (Result.exceptionOrNull-impl(obj7) != null) {
                                        Result.Companion companion14 = Result.Companion;
                                        attested4 = attested3;
                                        value$iv3 = null;
                                        obj7 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(RegisterResponse.class), (List) null, 2, (Object) null));
                                    } else {
                                        attested4 = attested3;
                                        value$iv3 = null;
                                    }
                                    if (Result.isFailure-impl(obj7)) {
                                        obj7 = value$iv3;
                                    }
                                    deserializationStrategy2 = (KSerializer) obj7;
                                    if (deserializationStrategy2 != null) {
                                        value$iv$iv = value$iv2;
                                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv$iv);
                                    } else {
                                        value$iv$iv = value$iv2;
                                    }
                                    ObjectMapper $this$readValue$iv$iv$iv9 = MainAPIKt.getMapper();
                                    String content$iv$iv$iv5 = value$iv$iv;
                                    objDecodeFromString2 = $this$readValue$iv$iv$iv9.readValue(content$iv$iv$iv5, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                                    });
                                    break;
                                } else {
                                    attested4 = attested3;
                                    objDecodeFromString2 = null;
                                }
                                reg = (RegisterResponse) objDecodeFromString2;
                                if (reg != null) {
                                    installation_id = reg.getInstallation_id();
                                } else {
                                    installation_id = null;
                                }
                                str2 = installation_id;
                                if (str2 != null) {
                                    z11 = true;
                                } else {
                                    z11 = true;
                                }
                                if (!z11) {
                                    key_id = reg.getKey_id();
                                    if (key_id != null) {
                                        z12 = true;
                                    } else {
                                        z12 = true;
                                    }
                                    if (!z12) {
                                        CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", reg.getInstallation_id());
                                        CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", reg.getKey_id());
                                        if (attested4) {
                                            CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z3));
                                            CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", "");
                                        } else {
                                            CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z10));
                                            CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey2.getEncoded(), 2));
                                        }
                                        AniVortexAuth.INSTANCE.invalidateCache();
                                        StringBuilder sbAppend4 = new StringBuilder().append("Registration complete! installation_id=").append(reg.getInstallation_id()).append(" key_id=").append(reg.getKey_id()).append(" attested=");
                                        if (attested4) {
                                            z13 = true;
                                        } else {
                                            z13 = false;
                                        }
                                        Log.i(continuation2, sbAppend4.append(z13).toString());
                                        z = true;
                                        return Boxing.boxBoolean(z);
                                    }
                                }
                                Log.w((String) continuation2, "Register response missing fields: " + StringsKt.take(registerResp.getText(), 300));
                                return Boxing.boxBoolean(z10);
                            }
                            z5 = false;
                        } else {
                            z5 = false;
                        }
                        Log.w((String) continuation2, "Invalid challenge response: " + StringsKt.take(challengeResp.getText(), 300));
                        return Boxing.boxBoolean(z5);
                        Log.w((String) continuation2, "Registration failed: " + e.getMessage());
                        z = false;
                        return Boxing.boxBoolean(z);
                    case 2:
                        boolean attested6 = c00162.Z$0;
                        privateKey2 = (PrivateKey) c00162.L$5;
                        ResultKt.throwOnFailure($result);
                        attested3 = attested6;
                        continuation2 = TAG;
                        z3 = true;
                        z10 = false;
                        registerResp = (NiceResponse) $result;
                        if (!registerResp.isSuccessful()) {
                            Log.w((String) continuation2, "Register returned (" + registerResp.getCode() + "): " + StringsKt.take(registerResp.getText(), 300));
                            return Boxing.boxBoolean(z10);
                        }
                        AppUtils appUtils6 = AppUtils.INSTANCE;
                        value$iv2 = registerResp.getText();
                        if (value$iv2 == null) {
                            Result.Companion companion15 = Result.Companion;
                            KType kTypeTypeOf6 = Reflection.typeOf(RegisterResponse.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj7 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                            if (Result.exceptionOrNull-impl(obj7) != null) {
                                Result.Companion companion16 = Result.Companion;
                                attested4 = attested3;
                                value$iv3 = null;
                                obj7 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(RegisterResponse.class), (List) null, 2, (Object) null));
                            } else {
                                attested4 = attested3;
                                value$iv3 = null;
                            }
                            if (Result.isFailure-impl(obj7)) {
                                obj7 = value$iv3;
                            }
                            deserializationStrategy2 = (KSerializer) obj7;
                            if (deserializationStrategy2 != null) {
                                value$iv$iv = value$iv2;
                                objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv$iv);
                            } else {
                                value$iv$iv = value$iv2;
                            }
                            ObjectMapper $this$readValue$iv$iv$iv10 = MainAPIKt.getMapper();
                            String content$iv$iv$iv6 = value$iv$iv;
                            objDecodeFromString2 = $this$readValue$iv$iv$iv10.readValue(content$iv$iv$iv6, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                            });
                            break;
                        } else {
                            attested4 = attested3;
                            objDecodeFromString2 = null;
                        }
                        reg = (RegisterResponse) objDecodeFromString2;
                        if (reg != null) {
                            installation_id = reg.getInstallation_id();
                        } else {
                            installation_id = null;
                        }
                        str2 = installation_id;
                        if (str2 != null) {
                            z11 = true;
                        } else {
                            z11 = true;
                        }
                        if (!z11) {
                            key_id = reg.getKey_id();
                            if (key_id != null) {
                                z12 = true;
                            } else {
                                z12 = true;
                            }
                            if (!z12) {
                                CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", reg.getInstallation_id());
                                CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", reg.getKey_id());
                                if (attested4) {
                                    CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z3));
                                    CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", "");
                                } else {
                                    CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(z10));
                                    CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey2.getEncoded(), 2));
                                }
                                AniVortexAuth.INSTANCE.invalidateCache();
                                StringBuilder sbAppend5 = new StringBuilder().append("Registration complete! installation_id=").append(reg.getInstallation_id()).append(" key_id=").append(reg.getKey_id()).append(" attested=");
                                if (attested4) {
                                    z13 = true;
                                } else {
                                    z13 = false;
                                }
                                Log.i(continuation2, sbAppend5.append(z13).toString());
                                z = true;
                                return Boxing.boxBoolean(z);
                            }
                        }
                        Log.w((String) continuation2, "Register response missing fields: " + StringsKt.take(registerResp.getText(), 300));
                        return Boxing.boxBoolean(z10);
                        Log.w((String) continuation2, "Registration failed: " + e.getMessage());
                        z = false;
                        return Boxing.boxBoolean(z);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th21) {
                e = th21;
                continuation2 = TAG;
            }
        } catch (Throwable th22) {
            e = th22;
        }
    }

    static final CharSequence performRegistration$lambda$4(String it) {
        return '\"' + it + '\"';
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:104:0x03d3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:105:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:108:0x03f4 A[Catch: all -> 0x05a1, TryCatch #2 {all -> 0x05a1, blocks: (B:106:0x03ec, B:108:0x03f4, B:110:0x0427, B:160:0x04f7, B:162:0x04fb, B:164:0x0501, B:166:0x0505, B:172:0x0511, B:174:0x0519, B:181:0x0526, B:182:0x057c, B:119:0x0463, B:131:0x04a3, B:134:0x04aa, B:151:0x04d2, B:149:0x04c9, B:130:0x0499, B:118:0x0459, B:187:0x05a7, B:102:0x03cd, B:25:0x010f), top: B:200:0x010f }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0427 A[Catch: all -> 0x05a1, TRY_LEAVE, TryCatch #2 {all -> 0x05a1, blocks: (B:106:0x03ec, B:108:0x03f4, B:110:0x0427, B:160:0x04f7, B:162:0x04fb, B:164:0x0501, B:166:0x0505, B:172:0x0511, B:174:0x0519, B:181:0x0526, B:182:0x057c, B:119:0x0463, B:131:0x04a3, B:134:0x04aa, B:151:0x04d2, B:149:0x04c9, B:130:0x0499, B:118:0x0459, B:187:0x05a7, B:102:0x03cd, B:25:0x010f), top: B:200:0x010f }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0435  */
    /* JADX WARN: Code duplicated, block: B:114:0x043a  */
    /* JADX WARN: Code duplicated, block: B:121:0x0469  */
    /* JADX WARN: Code duplicated, block: B:133:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:150:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:162:0x04fb A[Catch: all -> 0x05a1, TryCatch #2 {all -> 0x05a1, blocks: (B:106:0x03ec, B:108:0x03f4, B:110:0x0427, B:160:0x04f7, B:162:0x04fb, B:164:0x0501, B:166:0x0505, B:172:0x0511, B:174:0x0519, B:181:0x0526, B:182:0x057c, B:119:0x0463, B:131:0x04a3, B:134:0x04aa, B:151:0x04d2, B:149:0x04c9, B:130:0x0499, B:118:0x0459, B:187:0x05a7, B:102:0x03cd, B:25:0x010f), top: B:200:0x010f }] */
    /* JADX WARN: Code duplicated, block: B:163:0x0500  */
    /* JADX WARN: Code duplicated, block: B:166:0x0505 A[Catch: all -> 0x05a1, TryCatch #2 {all -> 0x05a1, blocks: (B:106:0x03ec, B:108:0x03f4, B:110:0x0427, B:160:0x04f7, B:162:0x04fb, B:164:0x0501, B:166:0x0505, B:172:0x0511, B:174:0x0519, B:181:0x0526, B:182:0x057c, B:119:0x0463, B:131:0x04a3, B:134:0x04aa, B:151:0x04d2, B:149:0x04c9, B:130:0x0499, B:118:0x0459, B:187:0x05a7, B:102:0x03cd, B:25:0x010f), top: B:200:0x010f }] */
    /* JADX WARN: Code duplicated, block: B:170:0x050e  */
    /* JADX WARN: Code duplicated, block: B:172:0x0511 A[Catch: all -> 0x05a1, TryCatch #2 {all -> 0x05a1, blocks: (B:106:0x03ec, B:108:0x03f4, B:110:0x0427, B:160:0x04f7, B:162:0x04fb, B:164:0x0501, B:166:0x0505, B:172:0x0511, B:174:0x0519, B:181:0x0526, B:182:0x057c, B:119:0x0463, B:131:0x04a3, B:134:0x04aa, B:151:0x04d2, B:149:0x04c9, B:130:0x0499, B:118:0x0459, B:187:0x05a7, B:102:0x03cd, B:25:0x010f), top: B:200:0x010f }] */
    /* JADX WARN: Code duplicated, block: B:174:0x0519 A[Catch: all -> 0x05a1, TryCatch #2 {all -> 0x05a1, blocks: (B:106:0x03ec, B:108:0x03f4, B:110:0x0427, B:160:0x04f7, B:162:0x04fb, B:164:0x0501, B:166:0x0505, B:172:0x0511, B:174:0x0519, B:181:0x0526, B:182:0x057c, B:119:0x0463, B:131:0x04a3, B:134:0x04aa, B:151:0x04d2, B:149:0x04c9, B:130:0x0499, B:118:0x0459, B:187:0x05a7, B:102:0x03cd, B:25:0x010f), top: B:200:0x010f }] */
    /* JADX WARN: Code duplicated, block: B:178:0x0522  */
    /* JADX WARN: Code duplicated, block: B:180:0x0525  */
    /* JADX WARN: Code duplicated, block: B:181:0x0526 A[Catch: all -> 0x05a1, TryCatch #2 {all -> 0x05a1, blocks: (B:106:0x03ec, B:108:0x03f4, B:110:0x0427, B:160:0x04f7, B:162:0x04fb, B:164:0x0501, B:166:0x0505, B:172:0x0511, B:174:0x0519, B:181:0x0526, B:182:0x057c, B:119:0x0463, B:131:0x04a3, B:134:0x04aa, B:151:0x04d2, B:149:0x04c9, B:130:0x0499, B:118:0x0459, B:187:0x05a7, B:102:0x03cd, B:25:0x010f), top: B:200:0x010f }] */
    /* JADX WARN: Code duplicated, block: B:186:0x05a3  */
    /* JADX WARN: Code duplicated, block: B:214:0x0197 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:0x046f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:225:0x04b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:227:0x01cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x0124 A[Catch: all -> 0x0157, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x0157, blocks: (B:32:0x0124, B:72:0x0200, B:77:0x020a, B:85:0x021e, B:94:0x0269, B:97:0x0270, B:45:0x018f, B:52:0x01bf, B:55:0x01c6, B:63:0x01e1, B:62:0x01db, B:51:0x01b4, B:44:0x0185), top: B:220:0x0122 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x015c A[Catch: all -> 0x05cc, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x05cc, blocks: (B:30:0x011a, B:36:0x015c, B:69:0x01fb, B:75:0x0206, B:83:0x0216, B:92:0x0230, B:100:0x0282), top: B:208:0x011a }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0167  */
    /* JADX WARN: Code duplicated, block: B:40:0x016a  */
    /* JADX WARN: Code duplicated, block: B:54:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:63:0x01e1 A[Catch: all -> 0x0157, Exception -> 0x01f8, TRY_LEAVE, TryCatch #8 {Exception -> 0x01f8, blocks: (B:45:0x018f, B:52:0x01bf, B:55:0x01c6, B:63:0x01e1, B:62:0x01db, B:51:0x01b4, B:44:0x0185), top: B:206:0x0185 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0200 A[Catch: all -> 0x0157, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x0157, blocks: (B:32:0x0124, B:72:0x0200, B:77:0x020a, B:85:0x021e, B:94:0x0269, B:97:0x0270, B:45:0x018f, B:52:0x01bf, B:55:0x01c6, B:63:0x01e1, B:62:0x01db, B:51:0x01b4, B:44:0x0185), top: B:220:0x0122 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0205  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x0213  */
    /* JADX WARN: Code duplicated, block: B:83:0x0216 A[Catch: all -> 0x05cc, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x05cc, blocks: (B:30:0x011a, B:36:0x015c, B:69:0x01fb, B:75:0x0206, B:83:0x0216, B:92:0x0230, B:100:0x0282), top: B:208:0x011a }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0227  */
    /* JADX WARN: Code duplicated, block: B:91:0x022a  */
    /* JADX WARN: Code duplicated, block: B:92:0x0230 A[Catch: all -> 0x05cc, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x05cc, blocks: (B:30:0x011a, B:36:0x015c, B:69:0x01fb, B:75:0x0206, B:83:0x0216, B:92:0x0230, B:100:0x0282), top: B:208:0x011a }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0269 A[Catch: all -> 0x0157, TRY_ENTER, TryCatch #15 {all -> 0x0157, blocks: (B:32:0x0124, B:72:0x0200, B:77:0x020a, B:85:0x021e, B:94:0x0269, B:97:0x0270, B:45:0x018f, B:52:0x01bf, B:55:0x01c6, B:63:0x01e1, B:62:0x01db, B:51:0x01b4, B:44:0x0185), top: B:220:0x0122 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x026d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0270 A[Catch: all -> 0x0157, TRY_LEAVE, TryCatch #15 {all -> 0x0157, blocks: (B:32:0x0124, B:72:0x0200, B:77:0x020a, B:85:0x021e, B:94:0x0269, B:97:0x0270, B:45:0x018f, B:52:0x01bf, B:55:0x01c6, B:63:0x01e1, B:62:0x01db, B:51:0x01b4, B:44:0x0185), top: B:220:0x0122 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x027f  */
    public final Object performRegistration(Continuation<? super Boolean> continuation) {
        C00173 c00173;
        String str;
        boolean z;
        Object obj;
        String str2;
        String challengeBody;
        NiceResponse challengeResp;
        String value$iv;
        Object obj2;
        Object obj3;
        Object obj4;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        ChallengeResponse challenge;
        String challenge_id;
        String str3;
        boolean z2;
        String challenge2;
        boolean z3;
        String challengeId;
        byte[] challengeBytes;
        KeyPairGenerator keyPairGen;
        KeyPair keyPair;
        PrivateKey privateKey;
        PublicKey publicKey;
        ECPublicKey eCPublicKey;
        PrivateKey privateKey2;
        NiceResponse registerResp;
        String value$iv2;
        Object obj5;
        NiceResponse registerResp2;
        Object objDecodeFromString2;
        NiceResponse registerResp3;
        DeserializationStrategy deserializationStrategy2;
        String value$iv$iv;
        RegisterResponse reg;
        String installation_id;
        String str4;
        boolean z4;
        String key_id;
        boolean z5;
        if (continuation instanceof C00173) {
            c00173 = (C00173) continuation;
            if ((c00173.label & Integer.MIN_VALUE) != 0) {
                c00173.label -= Integer.MIN_VALUE;
            } else {
                c00173 = new C00173(continuation);
            }
        } else {
            c00173 = new C00173(continuation);
        }
        C00173 c00174 = c00173;
        Object $result = c00174.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00174.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        Log.i(TAG, "Attempting software-key registration flow...");
                        Requests app = MainActivityKt.getApp();
                        try {
                            Map<String, String> map = regHeaders;
                            RequestBody requestBodyCreate = RequestBody.Companion.create("{\"platform\":\"android\",\"package_name\":\"app.anivortex.mobile\",\"version_name\":\"5.0.1\",\"version_code\":503}", MediaType.Companion.parse("application/json; charset=utf-8"));
                            c00174.L$0 = SpillingKt.nullOutSpilledVariable("{\"platform\":\"android\",\"package_name\":\"app.anivortex.mobile\",\"version_name\":\"5.0.1\",\"version_code\":503}");
                            c00174.label = 1;
                            obj = coroutine_suspended;
                            str = TAG;
                            str2 = "application/json; charset=utf-8";
                            try {
                                $result = Requests.post$default(app, "https://api.anivortex.in/api/v1/install/challenge", map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00174, 65276, (Object) null);
                                c00174 = c00174;
                                if ($result == obj) {
                                    return obj;
                                }
                                challengeBody = "{\"platform\":\"android\",\"package_name\":\"app.anivortex.mobile\",\"version_name\":\"5.0.1\",\"version_code\":503}";
                                try {
                                    challengeResp = (NiceResponse) $result;
                                    try {
                                        if (!challengeResp.isSuccessful()) {
                                            Log.w(str, "Challenge request returned " + challengeResp.getCode() + ": " + StringsKt.take(challengeResp.getText(), 200));
                                            return Boxing.boxBoolean(false);
                                        }
                                        AppUtils appUtils = AppUtils.INSTANCE;
                                        value$iv = challengeResp.getText();
                                        if (value$iv == null) {
                                            try {
                                                Result.Companion companion = Result.Companion;
                                                KType kTypeTypeOf = Reflection.typeOf(ChallengeResponse.class);
                                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                                break;
                                            } catch (Throwable th) {
                                                try {
                                                    Result.Companion companion2 = Result.Companion;
                                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                                } catch (Exception e) {
                                                    obj3 = null;
                                                }
                                            }
                                            if (Result.exceptionOrNull-impl(obj2) != null) {
                                                try {
                                                    Result.Companion companion3 = Result.Companion;
                                                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ChallengeResponse.class), (List) null, 2, (Object) null));
                                                } catch (Throwable th2) {
                                                    Result.Companion companion4 = Result.Companion;
                                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                                                }
                                            }
                                            obj4 = obj2;
                                            if (Result.isFailure-impl(obj4)) {
                                                obj4 = null;
                                            }
                                            deserializationStrategy = (KSerializer) obj4;
                                            if (deserializationStrategy != null) {
                                                try {
                                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                                } catch (SerializationException e2) {
                                                    ArchComponentExtKt.logError(e2);
                                                    ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                                    objDecodeFromString = $this$readValue$iv$iv$iv.readValue(value$iv, new TypeReference<ChallengeResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$3
                                                    });
                                                } catch (Throwable th3) {
                                                    ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                                    objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(value$iv, new TypeReference<ChallengeResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$3
                                                    });
                                                }
                                            } else {
                                                ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                                objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(value$iv, new TypeReference<ChallengeResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$3
                                                });
                                            }
                                            obj3 = objDecodeFromString;
                                            break;
                                        } else {
                                            obj3 = null;
                                        }
                                        challenge = (ChallengeResponse) obj3;
                                        if (challenge != null) {
                                            challenge_id = challenge.getChallenge_id();
                                        } else {
                                            challenge_id = null;
                                        }
                                        str3 = challenge_id;
                                        if (str3 != null || str3.length() == 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            challenge2 = challenge.getChallenge();
                                            if (challenge2 != null || challenge2.length() == 0) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            if (z3) {
                                                challengeId = challenge.getChallenge_id();
                                                Intrinsics.checkNotNull(challengeId);
                                                String challenge3 = challenge.getChallenge();
                                                Intrinsics.checkNotNull(challenge3);
                                                challengeBytes = Base64.decode(challenge3, 11);
                                                keyPairGen = KeyPairGenerator.getInstance("EC");
                                                keyPairGen.initialize(new ECGenParameterSpec("secp256r1"));
                                                keyPair = keyPairGen.generateKeyPair();
                                                privateKey = keyPair.getPrivate();
                                                publicKey = keyPair.getPublic();
                                                if (publicKey instanceof ECPublicKey) {
                                                    eCPublicKey = (ECPublicKey) publicKey;
                                                } else {
                                                    eCPublicKey = null;
                                                }
                                                if (eCPublicKey == null) {
                                                    AniVortexRegistration aniVortexRegistration = this;
                                                    Log.w(str, "Generated key is not EC");
                                                    return Boxing.boxBoolean(false);
                                                }
                                                ECPublicKey publicKey2 = eCPublicKey;
                                                byte[] leafDer = buildLeafCertificate(privateKey, publicKey2);
                                                CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(leafDer));
                                                String canonical = "ANIVORTEX-INSTALL-REGISTER-V1\n" + challengeId + '\n' + b64UrlNoPad(sha256(challengeBytes));
                                                Signature signer = Signature.getInstance("SHA256withECDSA");
                                                signer.initSign(privateKey);
                                                byte[] bytes = canonical.getBytes(Charsets.UTF_8);
                                                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                                                signer.update(bytes);
                                                String proofSig = b64UrlNoPad(signer.sign());
                                                String leafB64 = Base64.encodeToString(leafDer, 2);
                                                String registerBody = "{\"challenge_id\":\"" + challengeId + "\",\"certificate_chain\":[\"" + leafB64 + "\",\"" + leafB64 + "\"],\"proof_signature\":\"" + proofSig + "\"}";
                                                Requests app2 = MainActivityKt.getApp();
                                                Map<String, String> map2 = regHeaders;
                                                RequestBody requestBodyCreate2 = RequestBody.Companion.create(registerBody, MediaType.Companion.parse(str2));
                                                c00174.L$0 = SpillingKt.nullOutSpilledVariable(challengeBody);
                                                c00174.L$1 = SpillingKt.nullOutSpilledVariable(challengeResp);
                                                c00174.L$2 = SpillingKt.nullOutSpilledVariable(challenge);
                                                c00174.L$3 = SpillingKt.nullOutSpilledVariable(challengeId);
                                                c00174.L$4 = SpillingKt.nullOutSpilledVariable(challengeBytes);
                                                c00174.L$5 = SpillingKt.nullOutSpilledVariable(keyPairGen);
                                                c00174.L$6 = SpillingKt.nullOutSpilledVariable(keyPair);
                                                c00174.L$7 = privateKey;
                                                c00174.L$8 = SpillingKt.nullOutSpilledVariable(publicKey2);
                                                c00174.L$9 = SpillingKt.nullOutSpilledVariable(leafDer);
                                                c00174.L$10 = SpillingKt.nullOutSpilledVariable(canonical);
                                                c00174.L$11 = SpillingKt.nullOutSpilledVariable(signer);
                                                c00174.L$12 = SpillingKt.nullOutSpilledVariable(proofSig);
                                                c00174.L$13 = SpillingKt.nullOutSpilledVariable(leafB64);
                                                c00174.L$14 = SpillingKt.nullOutSpilledVariable(registerBody);
                                                c00174.label = 2;
                                                $result = Requests.post$default(app2, "https://api.anivortex.in/api/v1/install/register", map2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00174, 65276, (Object) null);
                                                if ($result == obj) {
                                                    return obj;
                                                }
                                                privateKey2 = privateKey;
                                                registerResp = (NiceResponse) $result;
                                                if (!registerResp.isSuccessful()) {
                                                    Log.w(str, "Register returned (" + registerResp.getCode() + "): " + StringsKt.take(registerResp.getText(), 300));
                                                    return Boxing.boxBoolean(false);
                                                }
                                                AppUtils appUtils2 = AppUtils.INSTANCE;
                                                value$iv2 = registerResp.getText();
                                                if (value$iv2 != null) {
                                                    try {
                                                        Result.Companion companion5 = Result.Companion;
                                                        KType kTypeTypeOf2 = Reflection.typeOf(RegisterResponse.class);
                                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                        obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                                        break;
                                                    } catch (Throwable th4) {
                                                        try {
                                                            Result.Companion companion6 = Result.Companion;
                                                            obj5 = Result.constructor-impl(ResultKt.createFailure(th4));
                                                        } catch (Exception e3) {
                                                            registerResp2 = registerResp;
                                                            objDecodeFromString2 = null;
                                                            reg = (RegisterResponse) objDecodeFromString2;
                                                            if (reg != null) {
                                                                installation_id = reg.getInstallation_id();
                                                            } else {
                                                                installation_id = null;
                                                            }
                                                            str4 = installation_id;
                                                            if (str4 != null) {
                                                                z4 = true;
                                                            } else {
                                                                z4 = true;
                                                            }
                                                            if (!z4) {
                                                                key_id = reg.getKey_id();
                                                                if (key_id != null) {
                                                                    z5 = true;
                                                                } else {
                                                                    z5 = true;
                                                                }
                                                                if (z5) {
                                                                    CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", reg.getInstallation_id());
                                                                    CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", reg.getKey_id());
                                                                    CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey2.getEncoded(), 2));
                                                                    AniVortexAuth.INSTANCE.invalidateCache();
                                                                    Log.i(str, "Registration complete! installation_id=" + reg.getInstallation_id() + " key_id=" + reg.getKey_id());
                                                                    z = true;
                                                                    return Boxing.boxBoolean(z);
                                                                }
                                                            }
                                                            Log.w(str, "Register response missing fields: " + StringsKt.take(registerResp2.getText(), 300));
                                                            return Boxing.boxBoolean(false);
                                                        }
                                                    }
                                                    if (Result.exceptionOrNull-impl(obj5) == null) {
                                                        registerResp2 = registerResp;
                                                        registerResp3 = null;
                                                    } else {
                                                        try {
                                                            Result.Companion companion7 = Result.Companion;
                                                            registerResp2 = registerResp;
                                                            registerResp3 = null;
                                                            try {
                                                                obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(RegisterResponse.class), (List) null, 2, (Object) null));
                                                                break;
                                                            } catch (Throwable th5) {
                                                                th = th5;
                                                                try {
                                                                    Result.Companion companion8 = Result.Companion;
                                                                    obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                } catch (Exception e4) {
                                                                    objDecodeFromString2 = null;
                                                                }
                                                            }
                                                        } catch (Throwable th6) {
                                                            th = th6;
                                                            registerResp2 = registerResp;
                                                            registerResp3 = null;
                                                        }
                                                    }
                                                    if (Result.isFailure-impl(obj5)) {
                                                        obj5 = registerResp3;
                                                    }
                                                    deserializationStrategy2 = (KSerializer) obj5;
                                                    if (deserializationStrategy2 != null) {
                                                        try {
                                                            value$iv$iv = value$iv2;
                                                            try {
                                                                objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv$iv);
                                                            } catch (SerializationException e5) {
                                                                e$iv$iv = e5;
                                                                ArchComponentExtKt.logError((Throwable) e$iv$iv);
                                                                ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                                                                String content$iv$iv$iv = value$iv$iv;
                                                                objDecodeFromString2 = $this$readValue$iv$iv$iv4.readValue(content$iv$iv$iv, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$4
                                                                });
                                                            } catch (Throwable th7) {
                                                                ObjectMapper $this$readValue$iv$iv$iv5 = MainAPIKt.getMapper();
                                                                String content$iv$iv$iv2 = value$iv$iv;
                                                                objDecodeFromString2 = $this$readValue$iv$iv$iv5.readValue(content$iv$iv$iv2, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$4
                                                                });
                                                            }
                                                        } catch (SerializationException e6) {
                                                            e$iv$iv = e6;
                                                            value$iv$iv = value$iv2;
                                                        } catch (Throwable th8) {
                                                            value$iv$iv = value$iv2;
                                                        }
                                                    } else {
                                                        value$iv$iv = value$iv2;
                                                    }
                                                    ObjectMapper $this$readValue$iv$iv$iv6 = MainAPIKt.getMapper();
                                                    String content$iv$iv$iv3 = value$iv$iv;
                                                    objDecodeFromString2 = $this$readValue$iv$iv$iv6.readValue(content$iv$iv$iv3, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$4
                                                    });
                                                    break;
                                                } else {
                                                    registerResp2 = registerResp;
                                                    objDecodeFromString2 = null;
                                                }
                                                reg = (RegisterResponse) objDecodeFromString2;
                                                if (reg != null) {
                                                    installation_id = reg.getInstallation_id();
                                                } else {
                                                    installation_id = null;
                                                }
                                                str4 = installation_id;
                                                if (str4 != null || str4.length() == 0) {
                                                    z4 = true;
                                                } else {
                                                    z4 = false;
                                                }
                                                if (!z4) {
                                                    key_id = reg.getKey_id();
                                                    if (key_id != null || key_id.length() == 0) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    if (z5) {
                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", reg.getInstallation_id());
                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", reg.getKey_id());
                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey2.getEncoded(), 2));
                                                        AniVortexAuth.INSTANCE.invalidateCache();
                                                        Log.i(str, "Registration complete! installation_id=" + reg.getInstallation_id() + " key_id=" + reg.getKey_id());
                                                        z = true;
                                                        return Boxing.boxBoolean(z);
                                                    }
                                                }
                                                Log.w(str, "Register response missing fields: " + StringsKt.take(registerResp2.getText(), 300));
                                                return Boxing.boxBoolean(false);
                                            }
                                        }
                                        Log.w(str, "Invalid challenge response: " + StringsKt.take(challengeResp.getText(), 300));
                                        return Boxing.boxBoolean(false);
                                    } catch (Throwable th9) {
                                        e = th9;
                                        Log.w(str, "Registration failed: " + e.getMessage());
                                        z = false;
                                    }
                                } catch (Throwable th10) {
                                    e = th10;
                                }
                                Log.w(str, "Registration failed: " + e.getMessage());
                                z = false;
                                return Boxing.boxBoolean(z);
                            } catch (Throwable th11) {
                                e = th11;
                            }
                        } catch (Throwable th12) {
                            e = th12;
                            str = TAG;
                        }
                    } catch (Throwable th13) {
                        e = th13;
                        str = TAG;
                    }
                    break;
                case 1:
                    String challengeBody2 = (String) c00174.L$0;
                    ResultKt.throwOnFailure($result);
                    obj = coroutine_suspended;
                    str2 = "application/json; charset=utf-8";
                    str = TAG;
                    challengeBody = challengeBody2;
                    challengeResp = (NiceResponse) $result;
                    if (!challengeResp.isSuccessful()) {
                        Log.w(str, "Challenge request returned " + challengeResp.getCode() + ": " + StringsKt.take(challengeResp.getText(), 200));
                        return Boxing.boxBoolean(false);
                    }
                    AppUtils appUtils3 = AppUtils.INSTANCE;
                    value$iv = challengeResp.getText();
                    if (value$iv == null) {
                        Result.Companion companion9 = Result.Companion;
                        KType kTypeTypeOf3 = Reflection.typeOf(ChallengeResponse.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                        if (Result.exceptionOrNull-impl(obj2) != null) {
                            Result.Companion companion10 = Result.Companion;
                            obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ChallengeResponse.class), (List) null, 2, (Object) null));
                        }
                        obj4 = obj2;
                        if (Result.isFailure-impl(obj4)) {
                            obj4 = null;
                        }
                        deserializationStrategy = (KSerializer) obj4;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv7 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv7.readValue(value$iv, new TypeReference<ChallengeResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$3
                            });
                        }
                        obj3 = objDecodeFromString;
                        break;
                    } else {
                        obj3 = null;
                    }
                    challenge = (ChallengeResponse) obj3;
                    if (challenge != null) {
                        challenge_id = challenge.getChallenge_id();
                    } else {
                        challenge_id = null;
                    }
                    str3 = challenge_id;
                    if (str3 != null) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        challenge2 = challenge.getChallenge();
                        if (challenge2 != null) {
                            z3 = true;
                        } else {
                            z3 = true;
                        }
                        if (z3) {
                            challengeId = challenge.getChallenge_id();
                            Intrinsics.checkNotNull(challengeId);
                            String challenge4 = challenge.getChallenge();
                            Intrinsics.checkNotNull(challenge4);
                            challengeBytes = Base64.decode(challenge4, 11);
                            keyPairGen = KeyPairGenerator.getInstance("EC");
                            keyPairGen.initialize(new ECGenParameterSpec("secp256r1"));
                            keyPair = keyPairGen.generateKeyPair();
                            privateKey = keyPair.getPrivate();
                            publicKey = keyPair.getPublic();
                            if (publicKey instanceof ECPublicKey) {
                                eCPublicKey = (ECPublicKey) publicKey;
                            } else {
                                eCPublicKey = null;
                            }
                            if (eCPublicKey == null) {
                                AniVortexRegistration aniVortexRegistration2 = this;
                                Log.w(str, "Generated key is not EC");
                                return Boxing.boxBoolean(false);
                            }
                            ECPublicKey publicKey3 = eCPublicKey;
                            byte[] leafDer2 = buildLeafCertificate(privateKey, publicKey3);
                            CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(leafDer2));
                            String canonical2 = "ANIVORTEX-INSTALL-REGISTER-V1\n" + challengeId + '\n' + b64UrlNoPad(sha256(challengeBytes));
                            Signature signer2 = Signature.getInstance("SHA256withECDSA");
                            signer2.initSign(privateKey);
                            byte[] bytes2 = canonical2.getBytes(Charsets.UTF_8);
                            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                            signer2.update(bytes2);
                            String proofSig2 = b64UrlNoPad(signer2.sign());
                            String leafB65 = Base64.encodeToString(leafDer2, 2);
                            String registerBody2 = "{\"challenge_id\":\"" + challengeId + "\",\"certificate_chain\":[\"" + leafB65 + "\",\"" + leafB65 + "\"],\"proof_signature\":\"" + proofSig2 + "\"}";
                            Requests app3 = MainActivityKt.getApp();
                            Map<String, String> map3 = regHeaders;
                            RequestBody requestBodyCreate3 = RequestBody.Companion.create(registerBody2, MediaType.Companion.parse(str2));
                            c00174.L$0 = SpillingKt.nullOutSpilledVariable(challengeBody);
                            c00174.L$1 = SpillingKt.nullOutSpilledVariable(challengeResp);
                            c00174.L$2 = SpillingKt.nullOutSpilledVariable(challenge);
                            c00174.L$3 = SpillingKt.nullOutSpilledVariable(challengeId);
                            c00174.L$4 = SpillingKt.nullOutSpilledVariable(challengeBytes);
                            c00174.L$5 = SpillingKt.nullOutSpilledVariable(keyPairGen);
                            c00174.L$6 = SpillingKt.nullOutSpilledVariable(keyPair);
                            c00174.L$7 = privateKey;
                            c00174.L$8 = SpillingKt.nullOutSpilledVariable(publicKey3);
                            c00174.L$9 = SpillingKt.nullOutSpilledVariable(leafDer2);
                            c00174.L$10 = SpillingKt.nullOutSpilledVariable(canonical2);
                            c00174.L$11 = SpillingKt.nullOutSpilledVariable(signer2);
                            c00174.L$12 = SpillingKt.nullOutSpilledVariable(proofSig2);
                            c00174.L$13 = SpillingKt.nullOutSpilledVariable(leafB65);
                            c00174.L$14 = SpillingKt.nullOutSpilledVariable(registerBody2);
                            c00174.label = 2;
                            $result = Requests.post$default(app3, "https://api.anivortex.in/api/v1/install/register", map3, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate3, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00174, 65276, (Object) null);
                            if ($result == obj) {
                                return obj;
                            }
                            privateKey2 = privateKey;
                            registerResp = (NiceResponse) $result;
                            if (!registerResp.isSuccessful()) {
                                Log.w(str, "Register returned (" + registerResp.getCode() + "): " + StringsKt.take(registerResp.getText(), 300));
                                return Boxing.boxBoolean(false);
                            }
                            AppUtils appUtils4 = AppUtils.INSTANCE;
                            value$iv2 = registerResp.getText();
                            if (value$iv2 != null) {
                                Result.Companion companion11 = Result.Companion;
                                KType kTypeTypeOf4 = Reflection.typeOf(RegisterResponse.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                                if (Result.exceptionOrNull-impl(obj5) == null) {
                                    Result.Companion companion12 = Result.Companion;
                                    registerResp2 = registerResp;
                                    registerResp3 = null;
                                    obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(RegisterResponse.class), (List) null, 2, (Object) null));
                                } else {
                                    registerResp2 = registerResp;
                                    registerResp3 = null;
                                }
                                if (Result.isFailure-impl(obj5)) {
                                    obj5 = registerResp3;
                                }
                                deserializationStrategy2 = (KSerializer) obj5;
                                if (deserializationStrategy2 != null) {
                                    value$iv$iv = value$iv2;
                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv$iv);
                                } else {
                                    value$iv$iv = value$iv2;
                                }
                                ObjectMapper $this$readValue$iv$iv$iv8 = MainAPIKt.getMapper();
                                String content$iv$iv$iv4 = value$iv$iv;
                                objDecodeFromString2 = $this$readValue$iv$iv$iv8.readValue(content$iv$iv$iv4, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$4
                                });
                                break;
                            } else {
                                registerResp2 = registerResp;
                                objDecodeFromString2 = null;
                            }
                            reg = (RegisterResponse) objDecodeFromString2;
                            if (reg != null) {
                                installation_id = reg.getInstallation_id();
                            } else {
                                installation_id = null;
                            }
                            str4 = installation_id;
                            if (str4 != null) {
                                z4 = true;
                            } else {
                                z4 = true;
                            }
                            if (!z4) {
                                key_id = reg.getKey_id();
                                if (key_id != null) {
                                    z5 = true;
                                } else {
                                    z5 = true;
                                }
                                if (z5) {
                                    CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", reg.getInstallation_id());
                                    CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", reg.getKey_id());
                                    CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey2.getEncoded(), 2));
                                    AniVortexAuth.INSTANCE.invalidateCache();
                                    Log.i(str, "Registration complete! installation_id=" + reg.getInstallation_id() + " key_id=" + reg.getKey_id());
                                    z = true;
                                    return Boxing.boxBoolean(z);
                                }
                            }
                            Log.w(str, "Register response missing fields: " + StringsKt.take(registerResp2.getText(), 300));
                            return Boxing.boxBoolean(false);
                        }
                    }
                    Log.w(str, "Invalid challenge response: " + StringsKt.take(challengeResp.getText(), 300));
                    return Boxing.boxBoolean(false);
                    Log.w(str, "Registration failed: " + e.getMessage());
                    z = false;
                    return Boxing.boxBoolean(z);
                case 2:
                    privateKey2 = (PrivateKey) c00174.L$7;
                    ResultKt.throwOnFailure($result);
                    str = TAG;
                    registerResp = (NiceResponse) $result;
                    if (!registerResp.isSuccessful()) {
                        Log.w(str, "Register returned (" + registerResp.getCode() + "): " + StringsKt.take(registerResp.getText(), 300));
                        return Boxing.boxBoolean(false);
                    }
                    AppUtils appUtils5 = AppUtils.INSTANCE;
                    value$iv2 = registerResp.getText();
                    if (value$iv2 != null) {
                        Result.Companion companion13 = Result.Companion;
                        KType kTypeTypeOf5 = Reflection.typeOf(RegisterResponse.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                        if (Result.exceptionOrNull-impl(obj5) == null) {
                            Result.Companion companion14 = Result.Companion;
                            registerResp2 = registerResp;
                            registerResp3 = null;
                            obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(RegisterResponse.class), (List) null, 2, (Object) null));
                        } else {
                            registerResp2 = registerResp;
                            registerResp3 = null;
                        }
                        if (Result.isFailure-impl(obj5)) {
                            obj5 = registerResp3;
                        }
                        deserializationStrategy2 = (KSerializer) obj5;
                        if (deserializationStrategy2 != null) {
                            value$iv$iv = value$iv2;
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv$iv);
                        } else {
                            value$iv$iv = value$iv2;
                        }
                        ObjectMapper $this$readValue$iv$iv$iv9 = MainAPIKt.getMapper();
                        String content$iv$iv$iv5 = value$iv$iv;
                        objDecodeFromString2 = $this$readValue$iv$iv$iv9.readValue(content$iv$iv$iv5, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$4
                        });
                        break;
                    } else {
                        registerResp2 = registerResp;
                        objDecodeFromString2 = null;
                    }
                    reg = (RegisterResponse) objDecodeFromString2;
                    if (reg != null) {
                        installation_id = reg.getInstallation_id();
                    } else {
                        installation_id = null;
                    }
                    str4 = installation_id;
                    if (str4 != null) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (!z4) {
                        key_id = reg.getKey_id();
                        if (key_id != null) {
                            z5 = true;
                        } else {
                            z5 = true;
                        }
                        if (z5) {
                            CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", reg.getInstallation_id());
                            CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", reg.getKey_id());
                            CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", Base64.encodeToString(privateKey2.getEncoded(), 2));
                            AniVortexAuth.INSTANCE.invalidateCache();
                            Log.i(str, "Registration complete! installation_id=" + reg.getInstallation_id() + " key_id=" + reg.getKey_id());
                            z = true;
                            return Boxing.boxBoolean(z);
                        }
                    }
                    Log.w(str, "Register response missing fields: " + StringsKt.take(registerResp2.getText(), 300));
                    return Boxing.boxBoolean(false);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th14) {
            e = th14;
            str = TAG;
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
        return derSequence(derExplicitContextZero(derInteger(BigInteger.valueOf(2L))), derInteger(BigInteger.ONE), derSequence(derOid(ECDSA_WITH_SHA256)), derCnName(), derSequence(derUtcTime("700101000000Z"), derGeneralizedTime("99991231235959Z")), derCnName(), derSequence(derSequence(derOid(ID_EC_PUBLIC_KEY), derOid(PRIME256V1)), derBitString(point)));
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
