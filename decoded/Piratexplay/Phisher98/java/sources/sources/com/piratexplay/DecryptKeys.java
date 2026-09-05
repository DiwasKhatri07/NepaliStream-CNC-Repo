package com.piratexplay;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Piratexplay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/piratexplay/DecryptKeys;", "", "edge_1", "", "edge_2", "legacy_fallback", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEdge_1", "()Ljava/lang/String;", "getEdge_2", "getLegacy_fallback", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Piratexplay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class DecryptKeys {

    @NotNull
    private final String edge_1;

    @NotNull
    private final String edge_2;

    @NotNull
    private final String legacy_fallback;

    public static /* synthetic */ DecryptKeys copy$default(DecryptKeys decryptKeys, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = decryptKeys.edge_1;
        }
        if ((i & 2) != 0) {
            str2 = decryptKeys.edge_2;
        }
        if ((i & 4) != 0) {
            str3 = decryptKeys.legacy_fallback;
        }
        return decryptKeys.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEdge_1() {
        return this.edge_1;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEdge_2() {
        return this.edge_2;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLegacy_fallback() {
        return this.legacy_fallback;
    }

    @NotNull
    public final DecryptKeys copy(@NotNull String edge_1, @NotNull String edge_2, @NotNull String legacy_fallback) {
        return new DecryptKeys(edge_1, edge_2, legacy_fallback);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DecryptKeys)) {
            return false;
        }
        DecryptKeys decryptKeys = (DecryptKeys) other;
        return Intrinsics.areEqual(this.edge_1, decryptKeys.edge_1) && Intrinsics.areEqual(this.edge_2, decryptKeys.edge_2) && Intrinsics.areEqual(this.legacy_fallback, decryptKeys.legacy_fallback);
    }

    public int hashCode() {
        return (((this.edge_1.hashCode() * 31) + this.edge_2.hashCode()) * 31) + this.legacy_fallback.hashCode();
    }

    @NotNull
    public String toString() {
        return "DecryptKeys(edge_1=" + this.edge_1 + ", edge_2=" + this.edge_2 + ", legacy_fallback=" + this.legacy_fallback + ')';
    }

    public DecryptKeys(@NotNull String edge_1, @NotNull String edge_2, @NotNull String legacy_fallback) {
        this.edge_1 = edge_1;
        this.edge_2 = edge_2;
        this.legacy_fallback = legacy_fallback;
    }

    @NotNull
    public final String getEdge_1() {
        return this.edge_1;
    }

    @NotNull
    public final String getEdge_2() {
        return this.edge_2;
    }

    @NotNull
    public final String getLegacy_fallback() {
        return this.legacy_fallback;
    }
}
