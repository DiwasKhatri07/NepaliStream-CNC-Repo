package com.AniVortex;

import android.util.Base64;
import android.util.Log;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.CloudStreamApp;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
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
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002=>B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0012\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\"\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00142\b\b\u0002\u0010\"\u001a\u00020\u000eH\u0002J!\u0010#\u001a\u00020\u00142\u0012\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140%\"\u00020\u0014H\u0002¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0014H\u0002J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0014H\u0002J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u0014H\u0002J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0010\u0010/\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0010\u00100\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0010\u00101\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0014H\u0002J(\u00105\u001a\u0002062\u0006\u0010*\u001a\u00020+2\u0006\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u001dH\u0002J\u0010\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0014H\u0002J\u0010\u0010<\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/AniVortex/AniVortexRegistration;", "", "<init>", "()V", "TAG", "", "BASE_URL", "KEY_ALIAS_DER_CN", "REGISTER_PREFIX", "regHeaders", "", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "hasCredentials", "", "ensureRegistered", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reRegister", "performRegistration", "buildLeafCertificate", "", "privateKey", "Ljava/security/PrivateKey;", "publicKey", "Ljava/security/interfaces/ECPublicKey;", "buildTbsCertificate", "derCnName", "derLength", "len", "", "derTagged", "tag", "", "content", "primitive", "derSequence", "parts", "", "([[B)[B", "derSet", "derExplicitContextZero", "derInteger", "value", "Ljava/math/BigInteger;", "derOid", "oidBytes", "derUtf8String", "derUtcTime", "derGeneralizedTime", "derBitString", "ECDSA_WITH_SHA256", "ID_EC_PUBLIC_KEY", "PRIME256V1", "toFixedLengthBytes", "", "out", "offset", "length", "sha256", "data", "b64UrlNoPad", "ChallengeResponse", "RegisterResponse", "AniVortex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAniVortexRegistration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniVortexRegistration.kt\ncom/AniVortex/AniVortexRegistration\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,327:1\n117#2,10:328\n117#2,10:338\n93#3,2:348\n63#3:350\n64#3,15:352\n95#3,2:369\n93#3,2:371\n63#3:373\n64#3,15:375\n95#3,2:392\n1#4:351\n1#4:374\n1#4:394\n50#5:367\n43#5:368\n50#5:390\n43#5:391\n14512#6,3:395\n*S KotlinDebug\n*F\n+ 1 AniVortexRegistration.kt\ncom/AniVortex/AniVortexRegistration\n*L\n91#1:328,10\n98#1:338,10\n119#1:348,2\n119#1:350\n119#1:352,15\n119#1:369,2\n170#1:371,2\n170#1:373\n170#1:375,15\n170#1:392,2\n119#1:351\n170#1:374\n119#1:367\n119#1:368\n170#1:390\n170#1:391\n273#1:395,3\n*E\n"})
public final class AniVortexRegistration {

    @NotNull
    private static final String BASE_URL = "https://api.anivortex.in";

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
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {0, 1}, l = {332, 93}, m = "ensureRegistered", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, nl = {333, 334}, s = {"L$0", "L$0"}, v = 2)
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
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {110, 160}, m = "performRegistration", n = {"challengeBody", "challengeBody", "challengeResp", "challenge", "challengeId", "challengeB64Url", "challengeBytes", "keyPairGen", "keyPair", "privateKey", "publicKey", "leafDer", "canonical", "signer", "proofSig", "leafB64", "registerBody"}, nl = {115, 165}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15"}, v = 2)
    static final class C00141 extends ContinuationImpl {
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

        C00141(Continuation<? super C00141> continuation) {
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
    @DebugMetadata(c = "com.AniVortex.AniVortexRegistration", f = "AniVortexRegistration.kt", i = {0, 1}, l = {332, 100}, m = "reRegister", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, nl = {333, 334}, s = {"L$0", "L$0"}, v = 2)
    static final class C00151 extends ContinuationImpl {
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
            return AniVortexRegistration.this.reRegister((Continuation) this);
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
                        owner$iv2 = aniVortexRegistration.performRegistration(c00111);
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
                    owner$iv2 = aniVortexRegistration2.performRegistration(c00111);
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
        C00151 c00151;
        Object owner$iv;
        Mutex $this$withLock_u24default$iv;
        Mutex $this$withLock_u24default$iv2;
        Throwable th;
        Object objPerformRegistration;
        if (continuation instanceof C00151) {
            c00151 = (C00151) continuation;
            if ((c00151.label & Integer.MIN_VALUE) != 0) {
                c00151.label -= Integer.MIN_VALUE;
            } else {
                c00151 = new C00151(continuation);
            }
        } else {
            c00151 = new C00151(continuation);
        }
        Object $result = c00151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00151.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Mutex $this$withLock_u24default$iv3 = mutex;
                owner$iv = null;
                c00151.L$0 = $this$withLock_u24default$iv3;
                c00151.label = 1;
                if ($this$withLock_u24default$iv3.lock((Object) null, c00151) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                $this$withLock_u24default$iv2 = null;
                try {
                    AniVortexAuth.INSTANCE.markCurrentCredentialsInvalid();
                    AniVortexRegistration aniVortexRegistration = INSTANCE;
                    c00151.L$0 = $this$withLock_u24default$iv;
                    c00151.label = 2;
                    objPerformRegistration = aniVortexRegistration.performRegistration(c00151);
                    if (objPerformRegistration == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Boolean boolBoxBoolean = Boxing.boxBoolean(((Boolean) objPerformRegistration).booleanValue());
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
                $this$withLock_u24default$iv = (Mutex) c00151.L$0;
                ResultKt.throwOnFailure($result);
                AniVortexAuth.INSTANCE.markCurrentCredentialsInvalid();
                AniVortexRegistration aniVortexRegistration2 = INSTANCE;
                c00151.L$0 = $this$withLock_u24default$iv;
                c00151.label = 2;
                objPerformRegistration = aniVortexRegistration2.performRegistration(c00151);
                if (objPerformRegistration == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Boolean boolBoxBoolean2 = Boxing.boxBoolean(((Boolean) objPerformRegistration).booleanValue());
                $this$withLock_u24default$iv.unlock(owner$iv);
                return boolBoxBoolean2;
            case 2:
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex) c00151.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objPerformRegistration = $result;
                    Boolean boolBoxBoolean3 = Boxing.boxBoolean(((Boolean) objPerformRegistration).booleanValue());
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
    /* JADX WARN: Code duplicated, block: B:104:0x03e0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:105:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:108:0x0401 A[Catch: all -> 0x05b9, TryCatch #15 {all -> 0x05b9, blocks: (B:106:0x03f9, B:108:0x0401, B:110:0x0434, B:160:0x0504, B:162:0x0508, B:164:0x050e, B:166:0x0512, B:172:0x051e, B:174:0x0526, B:181:0x0533, B:182:0x0594, B:119:0x0470, B:131:0x04b0, B:134:0x04b7, B:151:0x04df, B:149:0x04d6, B:130:0x04a6, B:118:0x0466, B:187:0x05bf, B:102:0x03da, B:25:0x0117), top: B:217:0x0117 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0434 A[Catch: all -> 0x05b9, TRY_LEAVE, TryCatch #15 {all -> 0x05b9, blocks: (B:106:0x03f9, B:108:0x0401, B:110:0x0434, B:160:0x0504, B:162:0x0508, B:164:0x050e, B:166:0x0512, B:172:0x051e, B:174:0x0526, B:181:0x0533, B:182:0x0594, B:119:0x0470, B:131:0x04b0, B:134:0x04b7, B:151:0x04df, B:149:0x04d6, B:130:0x04a6, B:118:0x0466, B:187:0x05bf, B:102:0x03da, B:25:0x0117), top: B:217:0x0117 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0442  */
    /* JADX WARN: Code duplicated, block: B:114:0x0447  */
    /* JADX WARN: Code duplicated, block: B:121:0x0476  */
    /* JADX WARN: Code duplicated, block: B:133:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:150:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:162:0x0508 A[Catch: all -> 0x05b9, TryCatch #15 {all -> 0x05b9, blocks: (B:106:0x03f9, B:108:0x0401, B:110:0x0434, B:160:0x0504, B:162:0x0508, B:164:0x050e, B:166:0x0512, B:172:0x051e, B:174:0x0526, B:181:0x0533, B:182:0x0594, B:119:0x0470, B:131:0x04b0, B:134:0x04b7, B:151:0x04df, B:149:0x04d6, B:130:0x04a6, B:118:0x0466, B:187:0x05bf, B:102:0x03da, B:25:0x0117), top: B:217:0x0117 }] */
    /* JADX WARN: Code duplicated, block: B:163:0x050d  */
    /* JADX WARN: Code duplicated, block: B:166:0x0512 A[Catch: all -> 0x05b9, TryCatch #15 {all -> 0x05b9, blocks: (B:106:0x03f9, B:108:0x0401, B:110:0x0434, B:160:0x0504, B:162:0x0508, B:164:0x050e, B:166:0x0512, B:172:0x051e, B:174:0x0526, B:181:0x0533, B:182:0x0594, B:119:0x0470, B:131:0x04b0, B:134:0x04b7, B:151:0x04df, B:149:0x04d6, B:130:0x04a6, B:118:0x0466, B:187:0x05bf, B:102:0x03da, B:25:0x0117), top: B:217:0x0117 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x051b  */
    /* JADX WARN: Code duplicated, block: B:172:0x051e A[Catch: all -> 0x05b9, TryCatch #15 {all -> 0x05b9, blocks: (B:106:0x03f9, B:108:0x0401, B:110:0x0434, B:160:0x0504, B:162:0x0508, B:164:0x050e, B:166:0x0512, B:172:0x051e, B:174:0x0526, B:181:0x0533, B:182:0x0594, B:119:0x0470, B:131:0x04b0, B:134:0x04b7, B:151:0x04df, B:149:0x04d6, B:130:0x04a6, B:118:0x0466, B:187:0x05bf, B:102:0x03da, B:25:0x0117), top: B:217:0x0117 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x0526 A[Catch: all -> 0x05b9, TryCatch #15 {all -> 0x05b9, blocks: (B:106:0x03f9, B:108:0x0401, B:110:0x0434, B:160:0x0504, B:162:0x0508, B:164:0x050e, B:166:0x0512, B:172:0x051e, B:174:0x0526, B:181:0x0533, B:182:0x0594, B:119:0x0470, B:131:0x04b0, B:134:0x04b7, B:151:0x04df, B:149:0x04d6, B:130:0x04a6, B:118:0x0466, B:187:0x05bf, B:102:0x03da, B:25:0x0117), top: B:217:0x0117 }] */
    /* JADX WARN: Code duplicated, block: B:178:0x052f  */
    /* JADX WARN: Code duplicated, block: B:180:0x0532  */
    /* JADX WARN: Code duplicated, block: B:181:0x0533 A[Catch: all -> 0x05b9, TryCatch #15 {all -> 0x05b9, blocks: (B:106:0x03f9, B:108:0x0401, B:110:0x0434, B:160:0x0504, B:162:0x0508, B:164:0x050e, B:166:0x0512, B:172:0x051e, B:174:0x0526, B:181:0x0533, B:182:0x0594, B:119:0x0470, B:131:0x04b0, B:134:0x04b7, B:151:0x04df, B:149:0x04d6, B:130:0x04a6, B:118:0x0466, B:187:0x05bf, B:102:0x03da, B:25:0x0117), top: B:217:0x0117 }] */
    /* JADX WARN: Code duplicated, block: B:186:0x05bb  */
    /* JADX WARN: Code duplicated, block: B:198:0x047c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:223:0x01d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:227:0x04bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x012c A[Catch: all -> 0x015f, TRY_ENTER, TRY_LEAVE, TryCatch #19 {all -> 0x015f, blocks: (B:32:0x012c, B:72:0x0208, B:77:0x0212, B:85:0x0226, B:94:0x026c, B:97:0x0273, B:45:0x0197, B:52:0x01c7, B:55:0x01ce, B:63:0x01e9, B:62:0x01e3, B:51:0x01bc, B:44:0x018d), top: B:222:0x012a }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0164 A[Catch: all -> 0x05e4, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x05e4, blocks: (B:30:0x0122, B:36:0x0164, B:69:0x0203, B:75:0x020e, B:83:0x021e, B:92:0x0238, B:100:0x0285), top: B:200:0x0122 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x016f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0172  */
    /* JADX WARN: Code duplicated, block: B:54:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:63:0x01e9 A[Catch: all -> 0x015f, Exception -> 0x0200, TRY_LEAVE, TryCatch #11 {Exception -> 0x0200, blocks: (B:45:0x0197, B:52:0x01c7, B:55:0x01ce, B:63:0x01e9, B:62:0x01e3, B:51:0x01bc, B:44:0x018d), top: B:211:0x018d }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0208 A[Catch: all -> 0x015f, TRY_ENTER, TRY_LEAVE, TryCatch #19 {all -> 0x015f, blocks: (B:32:0x012c, B:72:0x0208, B:77:0x0212, B:85:0x0226, B:94:0x026c, B:97:0x0273, B:45:0x0197, B:52:0x01c7, B:55:0x01ce, B:63:0x01e9, B:62:0x01e3, B:51:0x01bc, B:44:0x018d), top: B:222:0x012a }] */
    /* JADX WARN: Code duplicated, block: B:74:0x020d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x021b  */
    /* JADX WARN: Code duplicated, block: B:83:0x021e A[Catch: all -> 0x05e4, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x05e4, blocks: (B:30:0x0122, B:36:0x0164, B:69:0x0203, B:75:0x020e, B:83:0x021e, B:92:0x0238, B:100:0x0285), top: B:200:0x0122 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x022f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0232  */
    /* JADX WARN: Code duplicated, block: B:92:0x0238 A[Catch: all -> 0x05e4, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x05e4, blocks: (B:30:0x0122, B:36:0x0164, B:69:0x0203, B:75:0x020e, B:83:0x021e, B:92:0x0238, B:100:0x0285), top: B:200:0x0122 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x026c A[Catch: all -> 0x015f, TRY_ENTER, TryCatch #19 {all -> 0x015f, blocks: (B:32:0x012c, B:72:0x0208, B:77:0x0212, B:85:0x0226, B:94:0x026c, B:97:0x0273, B:45:0x0197, B:52:0x01c7, B:55:0x01ce, B:63:0x01e9, B:62:0x01e3, B:51:0x01bc, B:44:0x018d), top: B:222:0x012a }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0270  */
    /* JADX WARN: Code duplicated, block: B:97:0x0273 A[Catch: all -> 0x015f, TRY_LEAVE, TryCatch #19 {all -> 0x015f, blocks: (B:32:0x012c, B:72:0x0208, B:77:0x0212, B:85:0x0226, B:94:0x026c, B:97:0x0273, B:45:0x0197, B:52:0x01c7, B:55:0x01ce, B:63:0x01e9, B:62:0x01e3, B:51:0x01bc, B:44:0x018d), top: B:222:0x012a }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0282  */
    public final Object performRegistration(Continuation<? super Boolean> continuation) {
        C00141 c00141;
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
        String challengeB64Url;
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
        if (continuation instanceof C00141) {
            c00141 = (C00141) continuation;
            if ((c00141.label & Integer.MIN_VALUE) != 0) {
                c00141.label -= Integer.MIN_VALUE;
            } else {
                c00141 = new C00141(continuation);
            }
        } else {
            c00141 = new C00141(continuation);
        }
        C00141 c00142 = c00141;
        Object $result = c00142.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00142.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        Log.i(TAG, "Starting software-key registration flow...");
                        Requests app = MainActivityKt.getApp();
                        try {
                            Map<String, String> map = regHeaders;
                            RequestBody requestBodyCreate = RequestBody.Companion.create("{\"platform\":\"android\",\"package_name\":\"app.anivortex.mobile\",\"version_name\":\"5.0.1\",\"version_code\":503}", MediaType.Companion.parse("application/json; charset=utf-8"));
                            c00142.L$0 = SpillingKt.nullOutSpilledVariable("{\"platform\":\"android\",\"package_name\":\"app.anivortex.mobile\",\"version_name\":\"5.0.1\",\"version_code\":503}");
                            c00142.label = 1;
                            obj = coroutine_suspended;
                            str = TAG;
                            str2 = "application/json; charset=utf-8";
                            try {
                                $result = Requests.post$default(app, "https://api.anivortex.in/api/v1/install/challenge", map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00142, 65276, (Object) null);
                                c00142 = c00142;
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
                                                    objDecodeFromString = $this$readValue$iv$iv$iv.readValue(value$iv, new TypeReference<ChallengeResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$1
                                                    });
                                                } catch (Throwable th3) {
                                                    ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                                    objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(value$iv, new TypeReference<ChallengeResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$1
                                                    });
                                                }
                                            } else {
                                                ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                                objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(value$iv, new TypeReference<ChallengeResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$1
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
                                                challengeB64Url = challenge.getChallenge();
                                                challengeBytes = Base64.decode(challengeB64Url, 11);
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
                                                c00142.L$0 = SpillingKt.nullOutSpilledVariable(challengeBody);
                                                c00142.L$1 = SpillingKt.nullOutSpilledVariable(challengeResp);
                                                c00142.L$2 = SpillingKt.nullOutSpilledVariable(challenge);
                                                c00142.L$3 = SpillingKt.nullOutSpilledVariable(challengeId);
                                                c00142.L$4 = SpillingKt.nullOutSpilledVariable(challengeB64Url);
                                                c00142.L$5 = SpillingKt.nullOutSpilledVariable(challengeBytes);
                                                c00142.L$6 = SpillingKt.nullOutSpilledVariable(keyPairGen);
                                                c00142.L$7 = SpillingKt.nullOutSpilledVariable(keyPair);
                                                c00142.L$8 = privateKey;
                                                c00142.L$9 = SpillingKt.nullOutSpilledVariable(publicKey2);
                                                c00142.L$10 = SpillingKt.nullOutSpilledVariable(leafDer);
                                                c00142.L$11 = SpillingKt.nullOutSpilledVariable(canonical);
                                                c00142.L$12 = SpillingKt.nullOutSpilledVariable(signer);
                                                c00142.L$13 = SpillingKt.nullOutSpilledVariable(proofSig);
                                                c00142.L$14 = SpillingKt.nullOutSpilledVariable(leafB64);
                                                c00142.L$15 = SpillingKt.nullOutSpilledVariable(registerBody);
                                                c00142.label = 2;
                                                $result = Requests.post$default(app2, "https://api.anivortex.in/api/v1/install/register", map2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00142, 65276, (Object) null);
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
                                                                    CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(false));
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
                                                                objDecodeFromString2 = $this$readValue$iv$iv$iv4.readValue(content$iv$iv$iv, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
                                                                });
                                                            } catch (Throwable th7) {
                                                                ObjectMapper $this$readValue$iv$iv$iv5 = MainAPIKt.getMapper();
                                                                String content$iv$iv$iv2 = value$iv$iv;
                                                                objDecodeFromString2 = $this$readValue$iv$iv$iv5.readValue(content$iv$iv$iv2, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
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
                                                    objDecodeFromString2 = $this$readValue$iv$iv$iv6.readValue(content$iv$iv$iv3, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
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
                                                        CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(false));
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
                    String challengeBody2 = (String) c00142.L$0;
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
                            objDecodeFromString = $this$readValue$iv$iv$iv7.readValue(value$iv, new TypeReference<ChallengeResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$1
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
                            challengeB64Url = challenge.getChallenge();
                            challengeBytes = Base64.decode(challengeB64Url, 11);
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
                            c00142.L$0 = SpillingKt.nullOutSpilledVariable(challengeBody);
                            c00142.L$1 = SpillingKt.nullOutSpilledVariable(challengeResp);
                            c00142.L$2 = SpillingKt.nullOutSpilledVariable(challenge);
                            c00142.L$3 = SpillingKt.nullOutSpilledVariable(challengeId);
                            c00142.L$4 = SpillingKt.nullOutSpilledVariable(challengeB64Url);
                            c00142.L$5 = SpillingKt.nullOutSpilledVariable(challengeBytes);
                            c00142.L$6 = SpillingKt.nullOutSpilledVariable(keyPairGen);
                            c00142.L$7 = SpillingKt.nullOutSpilledVariable(keyPair);
                            c00142.L$8 = privateKey;
                            c00142.L$9 = SpillingKt.nullOutSpilledVariable(publicKey3);
                            c00142.L$10 = SpillingKt.nullOutSpilledVariable(leafDer2);
                            c00142.L$11 = SpillingKt.nullOutSpilledVariable(canonical2);
                            c00142.L$12 = SpillingKt.nullOutSpilledVariable(signer2);
                            c00142.L$13 = SpillingKt.nullOutSpilledVariable(proofSig2);
                            c00142.L$14 = SpillingKt.nullOutSpilledVariable(leafB65);
                            c00142.L$15 = SpillingKt.nullOutSpilledVariable(registerBody2);
                            c00142.label = 2;
                            $result = Requests.post$default(app3, "https://api.anivortex.in/api/v1/install/register", map3, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate3, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00142, 65276, (Object) null);
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
                                objDecodeFromString2 = $this$readValue$iv$iv$iv8.readValue(content$iv$iv$iv4, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
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
                                    CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(false));
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
                    privateKey2 = (PrivateKey) c00142.L$8;
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
                        objDecodeFromString2 = $this$readValue$iv$iv$iv9.readValue(content$iv$iv$iv5, new TypeReference<RegisterResponse>() { // from class: com.AniVortex.AniVortexRegistration$performRegistration$$inlined$tryParseJson$2
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
                            CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", Boxing.boxBoolean(false));
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
        byte[] cnValue = derUtf8String(KEY_ALIAS_DER_CN);
        byte[] atv = derSequence(cnOid, cnValue);
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
