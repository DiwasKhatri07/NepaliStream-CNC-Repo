package com.OneTouchTV;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OneTouchTVParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/OneTouchTV/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/OneTouchTV/MediaResult;", "", "randomSlideShow", "", "Lcom/OneTouchTV/RandomSlideShow;", "recents", "Lcom/OneTouchTV/Recent;", "result", "Lcom/OneTouchTV/ResultWrapper;", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/OneTouchTV/ResultWrapper;)V", "getRandomSlideShow", "()Ljava/util/List;", "getRecents", "getResult", "()Lcom/OneTouchTV/ResultWrapper;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MediaResult {

    @Nullable
    private final List<RandomSlideShow> randomSlideShow;

    @Nullable
    private final List<Recent> recents;

    @Nullable
    private final ResultWrapper result;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MediaResult copy$default(MediaResult mediaResult, List list, List list2, ResultWrapper resultWrapper, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mediaResult.randomSlideShow;
        }
        if ((i & 2) != 0) {
            list2 = mediaResult.recents;
        }
        if ((i & 4) != 0) {
            resultWrapper = mediaResult.result;
        }
        return mediaResult.copy(list, list2, resultWrapper);
    }

    @Nullable
    public final List<RandomSlideShow> component1() {
        return this.randomSlideShow;
    }

    @Nullable
    public final List<Recent> component2() {
        return this.recents;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ResultWrapper getResult() {
        return this.result;
    }

    @NotNull
    public final MediaResult copy(@Nullable List<RandomSlideShow> randomSlideShow, @Nullable List<Recent> recents, @Nullable ResultWrapper result) {
        return new MediaResult(randomSlideShow, recents, result);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaResult)) {
            return false;
        }
        MediaResult mediaResult = (MediaResult) other;
        return Intrinsics.areEqual(this.randomSlideShow, mediaResult.randomSlideShow) && Intrinsics.areEqual(this.recents, mediaResult.recents) && Intrinsics.areEqual(this.result, mediaResult.result);
    }

    public int hashCode() {
        return ((((this.randomSlideShow == null ? 0 : this.randomSlideShow.hashCode()) * 31) + (this.recents == null ? 0 : this.recents.hashCode())) * 31) + (this.result != null ? this.result.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MediaResult(randomSlideShow=" + this.randomSlideShow + ", recents=" + this.recents + ", result=" + this.result + ')';
    }

    public MediaResult(@Nullable List<RandomSlideShow> list, @Nullable List<Recent> list2, @Nullable ResultWrapper result) {
        this.randomSlideShow = list;
        this.recents = list2;
        this.result = result;
    }

    @Nullable
    public final List<RandomSlideShow> getRandomSlideShow() {
        return this.randomSlideShow;
    }

    @Nullable
    public final List<Recent> getRecents() {
        return this.recents;
    }

    @Nullable
    public final ResultWrapper getResult() {
        return this.result;
    }
}
