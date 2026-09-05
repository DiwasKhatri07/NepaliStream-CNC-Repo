package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/phisher98/AIODebianTorrent;", "", "infoHash", "", "seeders", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "getInfoHash", "()Ljava/lang/String;", "getSeeders", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/phisher98/AIODebianTorrent;", "equals", "", "other", "hashCode", "", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AIODebianTorrent {

    @Nullable
    private final String infoHash;

    @Nullable
    private final Long seeders;

    /* JADX WARN: Multi-variable type inference failed */
    public AIODebianTorrent() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AIODebianTorrent copy$default(AIODebianTorrent aIODebianTorrent, String str, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aIODebianTorrent.infoHash;
        }
        if ((i & 2) != 0) {
            l = aIODebianTorrent.seeders;
        }
        return aIODebianTorrent.copy(str, l);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInfoHash() {
        return this.infoHash;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getSeeders() {
        return this.seeders;
    }

    @NotNull
    public final AIODebianTorrent copy(@Nullable String infoHash, @Nullable Long seeders) {
        return new AIODebianTorrent(infoHash, seeders);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIODebianTorrent)) {
            return false;
        }
        AIODebianTorrent aIODebianTorrent = (AIODebianTorrent) other;
        return Intrinsics.areEqual(this.infoHash, aIODebianTorrent.infoHash) && Intrinsics.areEqual(this.seeders, aIODebianTorrent.seeders);
    }

    public int hashCode() {
        return ((this.infoHash == null ? 0 : this.infoHash.hashCode()) * 31) + (this.seeders != null ? this.seeders.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AIODebianTorrent(infoHash=" + this.infoHash + ", seeders=" + this.seeders + ')';
    }

    public AIODebianTorrent(@Nullable String infoHash, @Nullable Long seeders) {
        this.infoHash = infoHash;
        this.seeders = seeders;
    }

    public /* synthetic */ AIODebianTorrent(String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l);
    }

    @Nullable
    public final String getInfoHash() {
        return this.infoHash;
    }

    @Nullable
    public final Long getSeeders() {
        return this.seeders;
    }
}
