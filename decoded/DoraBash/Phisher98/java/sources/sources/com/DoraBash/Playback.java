package com.DoraBash;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/DoraBash/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001dJx\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010)J\u0014\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010.\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001d¨\u0006/"}, d2 = {"Lcom/DoraBash/Playback;", "", "algorithm", "", "iv", "payload", "key_parts", "", "expires_at", "decrypt_keys", "Lcom/DoraBash/DecryptKeys;", "iv2", "payload2", "version", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/DoraBash/DecryptKeys;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAlgorithm", "()Ljava/lang/String;", "getIv", "getPayload", "getKey_parts", "()Ljava/util/List;", "getExpires_at", "getDecrypt_keys", "()Lcom/DoraBash/DecryptKeys;", "getIv2", "getPayload2", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/DoraBash/DecryptKeys;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/DoraBash/Playback;", "equals", "", "other", "hashCode", "toString", "DoraBash"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Playback {

    @NotNull
    private final String algorithm;

    @Nullable
    private final DecryptKeys decrypt_keys;

    @Nullable
    private final String expires_at;

    @NotNull
    private final String iv;

    @Nullable
    private final String iv2;

    @NotNull
    private final List<String> key_parts;

    @NotNull
    private final String payload;

    @Nullable
    private final String payload2;

    @Nullable
    private final Integer version;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Playback copy$default(Playback playback, String str, String str2, String str3, List list, String str4, DecryptKeys decryptKeys, String str5, String str6, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playback.algorithm;
        }
        if ((i & 2) != 0) {
            str2 = playback.iv;
        }
        if ((i & 4) != 0) {
            str3 = playback.payload;
        }
        if ((i & 8) != 0) {
            list = playback.key_parts;
        }
        if ((i & 16) != 0) {
            str4 = playback.expires_at;
        }
        if ((i & 32) != 0) {
            decryptKeys = playback.decrypt_keys;
        }
        if ((i & 64) != 0) {
            str5 = playback.iv2;
        }
        if ((i & 128) != 0) {
            str6 = playback.payload2;
        }
        if ((i & 256) != 0) {
            num = playback.version;
        }
        String str7 = str6;
        Integer num2 = num;
        DecryptKeys decryptKeys2 = decryptKeys;
        String str8 = str5;
        String str9 = str4;
        String str10 = str3;
        return playback.copy(str, str2, str10, list, str9, decryptKeys2, str8, str7, num2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAlgorithm() {
        return this.algorithm;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIv() {
        return this.iv;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPayload() {
        return this.payload;
    }

    @NotNull
    public final List<String> component4() {
        return this.key_parts;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getExpires_at() {
        return this.expires_at;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final DecryptKeys getDecrypt_keys() {
        return this.decrypt_keys;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getIv2() {
        return this.iv2;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getPayload2() {
        return this.payload2;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getVersion() {
        return this.version;
    }

    @NotNull
    public final Playback copy(@NotNull String algorithm, @NotNull String iv, @NotNull String payload, @NotNull List<String> key_parts, @Nullable String expires_at, @Nullable DecryptKeys decrypt_keys, @Nullable String iv2, @Nullable String payload2, @Nullable Integer version) {
        return new Playback(algorithm, iv, payload, key_parts, expires_at, decrypt_keys, iv2, payload2, version);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Playback)) {
            return false;
        }
        Playback playback = (Playback) other;
        return Intrinsics.areEqual(this.algorithm, playback.algorithm) && Intrinsics.areEqual(this.iv, playback.iv) && Intrinsics.areEqual(this.payload, playback.payload) && Intrinsics.areEqual(this.key_parts, playback.key_parts) && Intrinsics.areEqual(this.expires_at, playback.expires_at) && Intrinsics.areEqual(this.decrypt_keys, playback.decrypt_keys) && Intrinsics.areEqual(this.iv2, playback.iv2) && Intrinsics.areEqual(this.payload2, playback.payload2) && Intrinsics.areEqual(this.version, playback.version);
    }

    public int hashCode() {
        return (((((((((((((((this.algorithm.hashCode() * 31) + this.iv.hashCode()) * 31) + this.payload.hashCode()) * 31) + this.key_parts.hashCode()) * 31) + (this.expires_at == null ? 0 : this.expires_at.hashCode())) * 31) + (this.decrypt_keys == null ? 0 : this.decrypt_keys.hashCode())) * 31) + (this.iv2 == null ? 0 : this.iv2.hashCode())) * 31) + (this.payload2 == null ? 0 : this.payload2.hashCode())) * 31) + (this.version != null ? this.version.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Playback(algorithm=" + this.algorithm + ", iv=" + this.iv + ", payload=" + this.payload + ", key_parts=" + this.key_parts + ", expires_at=" + this.expires_at + ", decrypt_keys=" + this.decrypt_keys + ", iv2=" + this.iv2 + ", payload2=" + this.payload2 + ", version=" + this.version + ')';
    }

    public Playback(@NotNull String algorithm, @NotNull String iv, @NotNull String payload, @NotNull List<String> list, @Nullable String expires_at, @Nullable DecryptKeys decrypt_keys, @Nullable String iv2, @Nullable String payload2, @Nullable Integer version) {
        this.algorithm = algorithm;
        this.iv = iv;
        this.payload = payload;
        this.key_parts = list;
        this.expires_at = expires_at;
        this.decrypt_keys = decrypt_keys;
        this.iv2 = iv2;
        this.payload2 = payload2;
        this.version = version;
    }

    public /* synthetic */ Playback(String str, String str2, String str3, List list, String str4, DecryptKeys decryptKeys, String str5, String str6, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, list, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : decryptKeys, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : num);
    }

    @NotNull
    public final String getAlgorithm() {
        return this.algorithm;
    }

    @NotNull
    public final String getIv() {
        return this.iv;
    }

    @NotNull
    public final String getPayload() {
        return this.payload;
    }

    @NotNull
    public final List<String> getKey_parts() {
        return this.key_parts;
    }

    @Nullable
    public final String getExpires_at() {
        return this.expires_at;
    }

    @Nullable
    public final DecryptKeys getDecrypt_keys() {
        return this.decrypt_keys;
    }

    @Nullable
    public final String getIv2() {
        return this.iv2;
    }

    @Nullable
    public final String getPayload2() {
        return this.payload2;
    }

    @Nullable
    public final Integer getVersion() {
        return this.version;
    }
}
