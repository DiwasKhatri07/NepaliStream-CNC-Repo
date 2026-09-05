package com.Kartoons;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KartoonsParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/Kartoons/EpisodeCreatedAt;", "", "iso", "", "timestamp", "", "timezone", "<init>", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)V", "getIso", "()Ljava/lang/String;", "getTimestamp", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getTimezone", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)Lcom/Kartoons/EpisodeCreatedAt;", "equals", "", "other", "hashCode", "", "toString", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodeCreatedAt {

    @Nullable
    private final String iso;

    @Nullable
    private final Double timestamp;

    @Nullable
    private final String timezone;

    public EpisodeCreatedAt() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ EpisodeCreatedAt copy$default(EpisodeCreatedAt episodeCreatedAt, String str, Double d, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = episodeCreatedAt.iso;
        }
        if ((i & 2) != 0) {
            d = episodeCreatedAt.timestamp;
        }
        if ((i & 4) != 0) {
            str2 = episodeCreatedAt.timezone;
        }
        return episodeCreatedAt.copy(str, d, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIso() {
        return this.iso;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTimezone() {
        return this.timezone;
    }

    @NotNull
    public final EpisodeCreatedAt copy(@Nullable String iso, @Nullable Double timestamp, @Nullable String timezone) {
        return new EpisodeCreatedAt(iso, timestamp, timezone);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodeCreatedAt)) {
            return false;
        }
        EpisodeCreatedAt episodeCreatedAt = (EpisodeCreatedAt) other;
        return Intrinsics.areEqual(this.iso, episodeCreatedAt.iso) && Intrinsics.areEqual(this.timestamp, episodeCreatedAt.timestamp) && Intrinsics.areEqual(this.timezone, episodeCreatedAt.timezone);
    }

    public int hashCode() {
        return ((((this.iso == null ? 0 : this.iso.hashCode()) * 31) + (this.timestamp == null ? 0 : this.timestamp.hashCode())) * 31) + (this.timezone != null ? this.timezone.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EpisodeCreatedAt(iso=" + this.iso + ", timestamp=" + this.timestamp + ", timezone=" + this.timezone + ')';
    }

    public EpisodeCreatedAt(@Nullable String iso, @Nullable Double timestamp, @Nullable String timezone) {
        this.iso = iso;
        this.timestamp = timestamp;
        this.timezone = timezone;
    }

    public /* synthetic */ EpisodeCreatedAt(String str, Double d, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : str2);
    }

    @Nullable
    public final String getIso() {
        return this.iso;
    }

    @Nullable
    public final Double getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    public final String getTimezone() {
        return this.timezone;
    }
}
