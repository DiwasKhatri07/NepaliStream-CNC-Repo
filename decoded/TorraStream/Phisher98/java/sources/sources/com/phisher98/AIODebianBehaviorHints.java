package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/phisher98/AIODebianBehaviorHints;", "", "videoSize", "", "filename", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;)V", "getVideoSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFilename", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/String;)Lcom/phisher98/AIODebianBehaviorHints;", "equals", "", "other", "hashCode", "", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AIODebianBehaviorHints {

    @Nullable
    private final String filename;

    @Nullable
    private final Long videoSize;

    /* JADX WARN: Multi-variable type inference failed */
    public AIODebianBehaviorHints() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AIODebianBehaviorHints copy$default(AIODebianBehaviorHints aIODebianBehaviorHints, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = aIODebianBehaviorHints.videoSize;
        }
        if ((i & 2) != 0) {
            str = aIODebianBehaviorHints.filename;
        }
        return aIODebianBehaviorHints.copy(l, str);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getVideoSize() {
        return this.videoSize;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    @NotNull
    public final AIODebianBehaviorHints copy(@Nullable Long videoSize, @Nullable String filename) {
        return new AIODebianBehaviorHints(videoSize, filename);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIODebianBehaviorHints)) {
            return false;
        }
        AIODebianBehaviorHints aIODebianBehaviorHints = (AIODebianBehaviorHints) other;
        return Intrinsics.areEqual(this.videoSize, aIODebianBehaviorHints.videoSize) && Intrinsics.areEqual(this.filename, aIODebianBehaviorHints.filename);
    }

    public int hashCode() {
        return ((this.videoSize == null ? 0 : this.videoSize.hashCode()) * 31) + (this.filename != null ? this.filename.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AIODebianBehaviorHints(videoSize=" + this.videoSize + ", filename=" + this.filename + ')';
    }

    public AIODebianBehaviorHints(@Nullable Long videoSize, @Nullable String filename) {
        this.videoSize = videoSize;
        this.filename = filename;
    }

    public /* synthetic */ AIODebianBehaviorHints(Long l, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str);
    }

    @Nullable
    public final Long getVideoSize() {
        return this.videoSize;
    }

    @Nullable
    public final String getFilename() {
        return this.filename;
    }
}
