package com.AniVortex;

import android.content.Context;
import android.util.Base64;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.CloudStreamApp;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DataStore;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniVortexAuth.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0012H\u0002JR\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00160\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00162\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/AniVortex/AniVortexAuth;", "", "<init>", "()V", "DEFAULT_INSTALLATION_ID", "", "DEFAULT_KEY_ID", "DEFAULT_PRIVATE_KEY_PKCS8_B64", "EMPTY_BODY_SHA256", "installationId", "getInstallationId", "()Ljava/lang/String;", "keyId", "getKeyId", "privateKeyB64", "getPrivateKeyB64", "cachedKeyB64", "cachedPrivateKey", "Ljava/security/PrivateKey;", "getPrivateKey", "buildHeaders", "Lkotlin/Pair;", "", "method", "path", "queryParams", "body", "", "sign", "message", "sha256Hex", "data", "AniVortex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAniVortexAuth.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniVortexAuth.kt\ncom/AniVortex/AniVortexAuth\n+ 2 CloudStreamApp.kt\ncom/lagradost/cloudstream3/CloudStreamApp$Companion\n+ 3 DataStore.kt\ncom/lagradost/cloudstream3/utils/DataStore\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 7 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,134:1\n144#2:135\n144#2:161\n144#2:187\n231#3:136\n222#3,3:137\n225#3,2:159\n231#3:162\n222#3,3:163\n225#3,2:185\n231#3:188\n222#3,3:189\n225#3,2:211\n63#4:140\n64#4,15:142\n63#4:166\n64#4,15:168\n63#4:192\n64#4,15:194\n1#5:141\n1#5:167\n1#5:193\n50#6:157\n43#6:158\n50#6:183\n43#6:184\n50#6:209\n43#6:210\n1221#7:213\n*S KotlinDebug\n*F\n+ 1 AniVortexAuth.kt\ncom/AniVortex/AniVortexAuth\n*L\n37#1:135\n42#1:161\n47#1:187\n37#1:136\n37#1:137,3\n37#1:159,2\n42#1:162\n42#1:163,3\n42#1:185,2\n47#1:188\n47#1:189,3\n47#1:211,2\n37#1:140\n37#1:142,15\n42#1:166\n42#1:168,15\n47#1:192\n47#1:194,15\n37#1:141\n42#1:167\n47#1:193\n37#1:157\n37#1:158\n42#1:183\n42#1:184\n47#1:209\n47#1:210\n80#1:213\n*E\n"})
public final class AniVortexAuth {

    @NotNull
    private static final String DEFAULT_INSTALLATION_ID = "bb318836-f481-4ff9-89ff-8e6f980263b1";

    @NotNull
    private static final String DEFAULT_KEY_ID = "560f89c2-e120-4e92-a614-e62b5f0a074f";

    @NotNull
    private static final String DEFAULT_PRIVATE_KEY_PKCS8_B64 = "MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgotCH9aOD0pCzW2gS3wZCKPnUosrlLmF7wba6gWr5FXihRANCAAR9Q66giz/bE3JHpYu+8KgivG4pATjQAznjt+AW1TR1i3lrtJQRofUTheMbupbjclhCxo05uVaW7FeqAvZvlFMC";

    @NotNull
    private static final String EMPTY_BODY_SHA256 = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";

    @NotNull
    public static final AniVortexAuth INSTANCE = new AniVortexAuth();

    @Nullable
    private static volatile String cachedKeyB64;

    @Nullable
    private static volatile PrivateKey cachedPrivateKey;

    private AniVortexAuth() {
    }

    @NotNull
    public final String getInstallationId() {
        String str;
        Object obj;
        Object objDecodeFromString;
        Object obj2;
        CloudStreamApp.Companion this_$iv;
        try {
            CloudStreamApp.Companion this_$iv2 = CloudStreamApp.Companion;
            Context context = this_$iv2.getContext();
            if (context != null) {
                obj = null;
                try {
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIVORTEX_INSTALL_ID", null);
                    if (string != null) {
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(String.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj2) == null) {
                            this_$iv = null;
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                try {
                                    this_$iv = null;
                                    try {
                                        obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(String.class), (List) null, 2, (Object) null));
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
                                    this_$iv = null;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                this_$iv = null;
                            }
                        }
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = this_$iv;
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) obj2;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, string);
                            } catch (SerializationException e2) {
                                ArchComponentExtKt.logError(e2);
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.AniVortex.AniVortexAuth$special$$inlined$getKey$1
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.AniVortex.AniVortexAuth$special$$inlined$getKey$1
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.AniVortex.AniVortexAuth$special$$inlined$getKey$1
                            });
                        }
                        obj = objDecodeFromString;
                    }
                } catch (Exception e3) {
                }
            } else {
                obj = null;
            }
            str = (String) obj;
        } catch (Throwable th6) {
            str = null;
        }
        return str == null ? DEFAULT_INSTALLATION_ID : str;
    }

    @NotNull
    public final String getKeyId() {
        String str;
        Object obj;
        Object objDecodeFromString;
        Object obj2;
        CloudStreamApp.Companion this_$iv;
        try {
            CloudStreamApp.Companion this_$iv2 = CloudStreamApp.Companion;
            Context context = this_$iv2.getContext();
            if (context != null) {
                obj = null;
                try {
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIVORTEX_KEY_ID", null);
                    if (string != null) {
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(String.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj2) == null) {
                            this_$iv = null;
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                try {
                                    this_$iv = null;
                                    try {
                                        obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(String.class), (List) null, 2, (Object) null));
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
                                    this_$iv = null;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                this_$iv = null;
                            }
                        }
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = this_$iv;
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) obj2;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, string);
                            } catch (SerializationException e2) {
                                ArchComponentExtKt.logError(e2);
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.AniVortex.AniVortexAuth$special$$inlined$getKey$2
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.AniVortex.AniVortexAuth$special$$inlined$getKey$2
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.AniVortex.AniVortexAuth$special$$inlined$getKey$2
                            });
                        }
                        obj = objDecodeFromString;
                    }
                } catch (Exception e3) {
                }
            } else {
                obj = null;
            }
            str = (String) obj;
        } catch (Throwable th6) {
            str = null;
        }
        return str == null ? DEFAULT_KEY_ID : str;
    }

    private final String getPrivateKeyB64() {
        String str;
        Object obj;
        Object objDecodeFromString;
        Object obj2;
        CloudStreamApp.Companion this_$iv;
        try {
            CloudStreamApp.Companion this_$iv2 = CloudStreamApp.Companion;
            Context context = this_$iv2.getContext();
            if (context != null) {
                obj = null;
                try {
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIVORTEX_PRIVATE_KEY", null);
                    if (string != null) {
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(String.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj2) == null) {
                            this_$iv = null;
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                try {
                                    this_$iv = null;
                                    try {
                                        obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(String.class), (List) null, 2, (Object) null));
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
                                    this_$iv = null;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                this_$iv = null;
                            }
                        }
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = this_$iv;
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) obj2;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, string);
                            } catch (SerializationException e2) {
                                ArchComponentExtKt.logError(e2);
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.AniVortex.AniVortexAuth$special$$inlined$getKey$3
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.AniVortex.AniVortexAuth$special$$inlined$getKey$3
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.AniVortex.AniVortexAuth$special$$inlined$getKey$3
                            });
                        }
                        obj = objDecodeFromString;
                    }
                } catch (Exception e3) {
                }
            } else {
                obj = null;
            }
            str = (String) obj;
        } catch (Throwable th6) {
            str = null;
        }
        return str == null ? DEFAULT_PRIVATE_KEY_PKCS8_B64 : str;
    }

    private final PrivateKey getPrivateKey() throws InvalidKeySpecException {
        String currentB64 = getPrivateKeyB64();
        if (Intrinsics.areEqual(cachedKeyB64, currentB64) && cachedPrivateKey != null) {
            PrivateKey privateKey = cachedPrivateKey;
            Intrinsics.checkNotNull(privateKey);
            return privateKey;
        }
        byte[] keyBytes = Base64.decode(currentB64, 0);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        PrivateKey key = KeyFactory.getInstance("EC").generatePrivate(spec);
        cachedKeyB64 = currentB64;
        cachedPrivateKey = key;
        return key;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pair buildHeaders$default(AniVortexAuth aniVortexAuth, String str, String str2, Map map, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "GET";
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 8) != 0) {
            bArr = null;
        }
        return aniVortexAuth.buildHeaders(str, str2, map, bArr);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0065  */
    @NotNull
    public final Pair<String, Map<String, String>> buildHeaders(@NotNull String method, @NotNull String path, @NotNull Map<String, String> queryParams, @Nullable byte[] body) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        String strJoinToString$default;
        String strSha256Hex;
        if (queryParams.isEmpty()) {
            strJoinToString$default = "";
        } else {
            Iterable $this$sortedBy$iv = queryParams.entrySet();
            strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.AniVortex.AniVortexAuth$buildHeaders$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Map.Entry it = (Map.Entry) t;
                    String str = (String) it.getKey();
                    Map.Entry it2 = (Map.Entry) t2;
                    return ComparisonsKt.compareValues(str, (String) it2.getKey());
                }
            }), "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.AniVortex.AniVortexAuth$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return AniVortexAuth.buildHeaders$lambda$1((Map.Entry) obj);
                }
            }, 30, (Object) null);
        }
        String sortedQuery = strJoinToString$default;
        String currentInstallId = getInstallationId();
        String currentKeyId = getKeyId();
        String requestId = UUID.randomUUID().toString();
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        if (body == null) {
            strSha256Hex = EMPTY_BODY_SHA256;
        } else {
            if (body.length == 0) {
                strSha256Hex = EMPTY_BODY_SHA256;
            } else {
                strSha256Hex = sha256Hex(body);
            }
        }
        String bodySha256 = strSha256Hex;
        String upperCase = method.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String canonicalMessage = CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{"ANIVORTEX-SIGNED-REQUEST-V1", currentInstallId, currentKeyId, timestamp, requestId, upperCase, path, sortedQuery, bodySha256}), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        String signature = sign(canonicalMessage);
        Map headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("user-agent", "Dart/3.10 (dart:io)"), TuplesKt.to("x-anivortex-installation-id", currentInstallId), TuplesKt.to("x-anivortex-key-id", currentKeyId), TuplesKt.to("x-anivortex-request-id", requestId), TuplesKt.to("x-anivortex-timestamp", timestamp), TuplesKt.to("x-anivortex-signature", signature)});
        return new Pair<>(sortedQuery, headers);
    }

    static final CharSequence buildHeaders$lambda$1(Map.Entry entry) {
        String key = (String) entry.getKey();
        String value = (String) entry.getValue();
        String encodedVal = StringsKt.replace$default(URLEncoder.encode(value, "UTF-8"), "+", "%20", false, 4, (Object) null);
        return key + '=' + encodedVal;
    }

    private final String sign(String message) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        Signature signer = Signature.getInstance("SHA256withECDSA");
        signer.initSign(getPrivateKey());
        byte[] bytes = message.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        signer.update(bytes);
        byte[] derSig = signer.sign();
        return StringsKt.trimEnd(Base64.encodeToString(derSig, 11), new char[]{'='});
    }

    private final String sha256Hex(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return ArraysKt.joinToString$default(digest.digest(data), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.AniVortex.AniVortexAuth$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return AniVortexAuth.sha256Hex$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence sha256Hex$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
