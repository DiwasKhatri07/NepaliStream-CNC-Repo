package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/TorraStream/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/phisher98/MeteorBehaviorHints;", "", "bingeGroup", "", "filename", "videoSize", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getBingeGroup", "()Ljava/lang/String;", "getFilename", "getVideoSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/phisher98/MeteorBehaviorHints;", "equals", "", "other", "hashCode", "", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MeteorBehaviorHints {

    @NotNull
    private final String bingeGroup;

    @Nullable
    private final String filename;

    @Nullable
    private final Long videoSize;

    public static /* synthetic */ MeteorBehaviorHints copy$default(MeteorBehaviorHints meteorBehaviorHints, String str, String str2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = meteorBehaviorHints.bingeGroup;
        }
        if ((i & 2) != 0) {
            str2 = meteorBehaviorHints.filename;
        }
        if ((i & 4) != 0) {
            l = meteorBehaviorHints.videoSize;
        }
        return meteorBehaviorHints.copy(str, str2, l);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBingeGroup() {
        return this.bingeGroup;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getVideoSize() {
        return this.videoSize;
    }

    @NotNull
    public final MeteorBehaviorHints copy(@NotNull String bingeGroup, @Nullable String filename, @Nullable Long videoSize) {
        return new MeteorBehaviorHints(bingeGroup, filename, videoSize);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MeteorBehaviorHints)) {
            return false;
        }
        MeteorBehaviorHints meteorBehaviorHints = (MeteorBehaviorHints) other;
        return Intrinsics.areEqual(this.bingeGroup, meteorBehaviorHints.bingeGroup) && Intrinsics.areEqual(this.filename, meteorBehaviorHints.filename) && Intrinsics.areEqual(this.videoSize, meteorBehaviorHints.videoSize);
    }

    public int hashCode() {
        return (((this.bingeGroup.hashCode() * 31) + (this.filename == null ? 0 : this.filename.hashCode())) * 31) + (this.videoSize != null ? this.videoSize.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MeteorBehaviorHints(bingeGroup=" + this.bingeGroup + ", filename=" + this.filename + ", videoSize=" + this.videoSize + ')';
    }

    public MeteorBehaviorHints(@NotNull String bingeGroup, @Nullable String filename, @Nullable Long videoSize) {
        this.bingeGroup = bingeGroup;
        this.filename = filename;
        this.videoSize = videoSize;
    }

    @NotNull
    public final String getBingeGroup() {
        return this.bingeGroup;
    }

    @Nullable
    public final String getFilename() {
        return this.filename;
    }

    @Nullable
    public final Long getVideoSize() {
        return this.videoSize;
    }
}
