package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/phisher98/TorrentsDBBehaviorHints;", "", "bingeGroup", "", "filename", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBingeGroup", "()Ljava/lang/String;", "getFilename", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TorrentsDBBehaviorHints {

    @Nullable
    private final String bingeGroup;

    @Nullable
    private final String filename;

    public static /* synthetic */ TorrentsDBBehaviorHints copy$default(TorrentsDBBehaviorHints torrentsDBBehaviorHints, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = torrentsDBBehaviorHints.bingeGroup;
        }
        if ((i & 2) != 0) {
            str2 = torrentsDBBehaviorHints.filename;
        }
        return torrentsDBBehaviorHints.copy(str, str2);
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

    @NotNull
    public final TorrentsDBBehaviorHints copy(@Nullable String bingeGroup, @Nullable String filename) {
        return new TorrentsDBBehaviorHints(bingeGroup, filename);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TorrentsDBBehaviorHints)) {
            return false;
        }
        TorrentsDBBehaviorHints torrentsDBBehaviorHints = (TorrentsDBBehaviorHints) other;
        return Intrinsics.areEqual(this.bingeGroup, torrentsDBBehaviorHints.bingeGroup) && Intrinsics.areEqual(this.filename, torrentsDBBehaviorHints.filename);
    }

    public int hashCode() {
        return ((this.bingeGroup == null ? 0 : this.bingeGroup.hashCode()) * 31) + (this.filename != null ? this.filename.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TorrentsDBBehaviorHints(bingeGroup=" + this.bingeGroup + ", filename=" + this.filename + ')';
    }

    public TorrentsDBBehaviorHints(@Nullable String bingeGroup, @Nullable String filename) {
        this.bingeGroup = bingeGroup;
        this.filename = filename;
    }

    @Nullable
    public final String getBingeGroup() {
        return this.bingeGroup;
    }

    @Nullable
    public final String getFilename() {
        return this.filename;
    }
}
