package com.MPlayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MPlayerProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JG\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/MPlayer/MovieDownload2;", "", "expiryDate", "", "requireLoginToDownload", "", "requiredPack", "requireSubscriptionToDownload", "downloadCriteria", "isEligibleForDownload", "<init>", "(Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Z)V", "getExpiryDate", "()Ljava/lang/String;", "getRequireLoginToDownload", "()Z", "getRequiredPack", "getRequireSubscriptionToDownload", "getDownloadCriteria", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MovieDownload2 {

    @NotNull
    private final String downloadCriteria;

    @Nullable
    private final String expiryDate;
    private final boolean isEligibleForDownload;
    private final boolean requireLoginToDownload;
    private final boolean requireSubscriptionToDownload;

    @NotNull
    private final String requiredPack;

    public static /* synthetic */ MovieDownload2 copy$default(MovieDownload2 movieDownload2, String str, boolean z, String str2, boolean z2, String str3, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = movieDownload2.expiryDate;
        }
        if ((i & 2) != 0) {
            z = movieDownload2.requireLoginToDownload;
        }
        if ((i & 4) != 0) {
            str2 = movieDownload2.requiredPack;
        }
        if ((i & 8) != 0) {
            z2 = movieDownload2.requireSubscriptionToDownload;
        }
        if ((i & 16) != 0) {
            str3 = movieDownload2.downloadCriteria;
        }
        if ((i & 32) != 0) {
            z3 = movieDownload2.isEligibleForDownload;
        }
        String str4 = str3;
        boolean z4 = z3;
        return movieDownload2.copy(str, z, str2, z2, str4, z4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getExpiryDate() {
        return this.expiryDate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getRequireLoginToDownload() {
        return this.requireLoginToDownload;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRequiredPack() {
        return this.requiredPack;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getRequireSubscriptionToDownload() {
        return this.requireSubscriptionToDownload;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDownloadCriteria() {
        return this.downloadCriteria;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsEligibleForDownload() {
        return this.isEligibleForDownload;
    }

    @NotNull
    public final MovieDownload2 copy(@Nullable String expiryDate, boolean requireLoginToDownload, @NotNull String requiredPack, boolean requireSubscriptionToDownload, @NotNull String downloadCriteria, boolean isEligibleForDownload) {
        return new MovieDownload2(expiryDate, requireLoginToDownload, requiredPack, requireSubscriptionToDownload, downloadCriteria, isEligibleForDownload);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MovieDownload2)) {
            return false;
        }
        MovieDownload2 movieDownload2 = (MovieDownload2) other;
        return Intrinsics.areEqual(this.expiryDate, movieDownload2.expiryDate) && this.requireLoginToDownload == movieDownload2.requireLoginToDownload && Intrinsics.areEqual(this.requiredPack, movieDownload2.requiredPack) && this.requireSubscriptionToDownload == movieDownload2.requireSubscriptionToDownload && Intrinsics.areEqual(this.downloadCriteria, movieDownload2.downloadCriteria) && this.isEligibleForDownload == movieDownload2.isEligibleForDownload;
    }

    public int hashCode() {
        return ((((((((((this.expiryDate == null ? 0 : this.expiryDate.hashCode()) * 31) + MovieDownload2$$ExternalSyntheticBackport0.m17m(this.requireLoginToDownload)) * 31) + this.requiredPack.hashCode()) * 31) + MovieDownload2$$ExternalSyntheticBackport0.m17m(this.requireSubscriptionToDownload)) * 31) + this.downloadCriteria.hashCode()) * 31) + MovieDownload2$$ExternalSyntheticBackport0.m17m(this.isEligibleForDownload);
    }

    @NotNull
    public String toString() {
        return "MovieDownload2(expiryDate=" + this.expiryDate + ", requireLoginToDownload=" + this.requireLoginToDownload + ", requiredPack=" + this.requiredPack + ", requireSubscriptionToDownload=" + this.requireSubscriptionToDownload + ", downloadCriteria=" + this.downloadCriteria + ", isEligibleForDownload=" + this.isEligibleForDownload + ')';
    }

    public MovieDownload2(@Nullable String expiryDate, boolean requireLoginToDownload, @NotNull String requiredPack, boolean requireSubscriptionToDownload, @NotNull String downloadCriteria, boolean isEligibleForDownload) {
        this.expiryDate = expiryDate;
        this.requireLoginToDownload = requireLoginToDownload;
        this.requiredPack = requiredPack;
        this.requireSubscriptionToDownload = requireSubscriptionToDownload;
        this.downloadCriteria = downloadCriteria;
        this.isEligibleForDownload = isEligibleForDownload;
    }

    @Nullable
    public final String getExpiryDate() {
        return this.expiryDate;
    }

    public final boolean getRequireLoginToDownload() {
        return this.requireLoginToDownload;
    }

    @NotNull
    public final String getRequiredPack() {
        return this.requiredPack;
    }

    public final boolean getRequireSubscriptionToDownload() {
        return this.requireSubscriptionToDownload;
    }

    @NotNull
    public final String getDownloadCriteria() {
        return this.downloadCriteria;
    }

    public final boolean isEligibleForDownload() {
        return this.isEligibleForDownload;
    }
}
