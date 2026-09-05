package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/KisskhKey;", "", "id", "", "version", "key", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getVersion", "getKey", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class KisskhKey {

    @NotNull
    private final String id;

    @NotNull
    private final String key;

    @NotNull
    private final String version;

    public static /* synthetic */ KisskhKey copy$default(KisskhKey kisskhKey, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = kisskhKey.id;
        }
        if ((i & 2) != 0) {
            str2 = kisskhKey.version;
        }
        if ((i & 4) != 0) {
            str3 = kisskhKey.key;
        }
        return kisskhKey.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @NotNull
    public final KisskhKey copy(@NotNull String id, @NotNull String version, @NotNull String key) {
        return new KisskhKey(id, version, key);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KisskhKey)) {
            return false;
        }
        KisskhKey kisskhKey = (KisskhKey) other;
        return Intrinsics.areEqual(this.id, kisskhKey.id) && Intrinsics.areEqual(this.version, kisskhKey.version) && Intrinsics.areEqual(this.key, kisskhKey.key);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.version.hashCode()) * 31) + this.key.hashCode();
    }

    @NotNull
    public String toString() {
        return "KisskhKey(id=" + this.id + ", version=" + this.version + ", key=" + this.key + ')';
    }

    public KisskhKey(@NotNull String id, @NotNull String version, @NotNull String key) {
        this.id = id;
        this.version = version;
        this.key = key;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }
}
