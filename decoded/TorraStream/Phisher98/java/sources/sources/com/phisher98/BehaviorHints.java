package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/phisher98/BehaviorHints;", "", "bingeGroup", "", "filename", "videoSize", "", "videoHash", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getBingeGroup", "()Ljava/lang/String;", "getFilename", "getVideoSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getVideoHash", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/phisher98/BehaviorHints;", "equals", "", "other", "hashCode", "", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class BehaviorHints {

    @Nullable
    private final String bingeGroup;

    @Nullable
    private final String filename;

    @Nullable
    private final String videoHash;

    @Nullable
    private final Long videoSize;

    public static /* synthetic */ BehaviorHints copy$default(BehaviorHints behaviorHints, String str, String str2, Long l, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = behaviorHints.bingeGroup;
        }
        if ((i & 2) != 0) {
            str2 = behaviorHints.filename;
        }
        if ((i & 4) != 0) {
            l = behaviorHints.videoSize;
        }
        if ((i & 8) != 0) {
            str3 = behaviorHints.videoHash;
        }
        return behaviorHints.copy(str, str2, l, str3);
    }

    @Nullable
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

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVideoHash() {
        return this.videoHash;
    }

    @NotNull
    public final BehaviorHints copy(@Nullable String bingeGroup, @Nullable String filename, @Nullable Long videoSize, @Nullable String videoHash) {
        return new BehaviorHints(bingeGroup, filename, videoSize, videoHash);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BehaviorHints)) {
            return false;
        }
        BehaviorHints behaviorHints = (BehaviorHints) other;
        return Intrinsics.areEqual(this.bingeGroup, behaviorHints.bingeGroup) && Intrinsics.areEqual(this.filename, behaviorHints.filename) && Intrinsics.areEqual(this.videoSize, behaviorHints.videoSize) && Intrinsics.areEqual(this.videoHash, behaviorHints.videoHash);
    }

    public int hashCode() {
        return ((((((this.bingeGroup == null ? 0 : this.bingeGroup.hashCode()) * 31) + (this.filename == null ? 0 : this.filename.hashCode())) * 31) + (this.videoSize == null ? 0 : this.videoSize.hashCode())) * 31) + (this.videoHash != null ? this.videoHash.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "BehaviorHints(bingeGroup=" + this.bingeGroup + ", filename=" + this.filename + ", videoSize=" + this.videoSize + ", videoHash=" + this.videoHash + ')';
    }

    public BehaviorHints(@Nullable String bingeGroup, @Nullable String filename, @Nullable Long videoSize, @Nullable String videoHash) {
        this.bingeGroup = bingeGroup;
        this.filename = filename;
        this.videoSize = videoSize;
        this.videoHash = videoHash;
    }

    @Nullable
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

    @Nullable
    public final String getVideoHash() {
        return this.videoHash;
    }
}
