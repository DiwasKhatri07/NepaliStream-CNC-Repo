package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/TorraStream/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/phisher98/AnimetoshoRelease;", "", "id", "", "title", "", "magnet", "seeders", "resolution", "<init>", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "getMagnet", "getSeeders", "getResolution", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnimetoshoRelease {
    private final long id;

    @NotNull
    private final String magnet;

    @Nullable
    private final String resolution;
    private final long seeders;

    @NotNull
    private final String title;

    public static /* synthetic */ AnimetoshoRelease copy$default(AnimetoshoRelease animetoshoRelease, long j, String str, String str2, long j2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = animetoshoRelease.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = animetoshoRelease.title;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = animetoshoRelease.magnet;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            j2 = animetoshoRelease.seeders;
        }
        long j4 = j2;
        if ((i & 16) != 0) {
            str3 = animetoshoRelease.resolution;
        }
        return animetoshoRelease.copy(j3, str4, str5, j4, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMagnet() {
        return this.magnet;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getSeeders() {
        return this.seeders;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getResolution() {
        return this.resolution;
    }

    @NotNull
    public final AnimetoshoRelease copy(long id, @NotNull String title, @NotNull String magnet, long seeders, @Nullable String resolution) {
        return new AnimetoshoRelease(id, title, magnet, seeders, resolution);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimetoshoRelease)) {
            return false;
        }
        AnimetoshoRelease animetoshoRelease = (AnimetoshoRelease) other;
        return this.id == animetoshoRelease.id && Intrinsics.areEqual(this.title, animetoshoRelease.title) && Intrinsics.areEqual(this.magnet, animetoshoRelease.magnet) && this.seeders == animetoshoRelease.seeders && Intrinsics.areEqual(this.resolution, animetoshoRelease.resolution);
    }

    public int hashCode() {
        return (((((((AnimetoshoRelease$$ExternalSyntheticBackport0.m0m(this.id) * 31) + this.title.hashCode()) * 31) + this.magnet.hashCode()) * 31) + AnimetoshoRelease$$ExternalSyntheticBackport0.m0m(this.seeders)) * 31) + (this.resolution == null ? 0 : this.resolution.hashCode());
    }

    @NotNull
    public String toString() {
        return "AnimetoshoRelease(id=" + this.id + ", title=" + this.title + ", magnet=" + this.magnet + ", seeders=" + this.seeders + ", resolution=" + this.resolution + ')';
    }

    public AnimetoshoRelease(long id, @NotNull String title, @NotNull String magnet, long seeders, @Nullable String resolution) {
        this.id = id;
        this.title = title;
        this.magnet = magnet;
        this.seeders = seeders;
        this.resolution = resolution;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AnimetoshoRelease(long j, String str, String str2, long j2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str4;
        if ((i & 16) == 0) {
            str4 = str3;
        } else {
            str4 = null;
        }
        this(j, str, str2, j2, str4);
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getMagnet() {
        return this.magnet;
    }

    public final long getSeeders() {
        return this.seeders;
    }

    @Nullable
    public final String getResolution() {
        return this.resolution;
    }
}
