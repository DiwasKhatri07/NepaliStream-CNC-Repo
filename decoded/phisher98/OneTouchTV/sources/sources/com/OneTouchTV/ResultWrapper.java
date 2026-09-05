package com.OneTouchTV;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OneTouchTVParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/OneTouchTV/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/OneTouchTV/ResultWrapper;", "", "randomSlideShow", "", "Lcom/OneTouchTV/RandomSlideShow;", "recents", "Lcom/OneTouchTV/Recent;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getRandomSlideShow", "()Ljava/util/List;", "getRecents", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ResultWrapper {

    @Nullable
    private final List<RandomSlideShow> randomSlideShow;

    @Nullable
    private final List<Recent> recents;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResultWrapper copy$default(ResultWrapper resultWrapper, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = resultWrapper.randomSlideShow;
        }
        if ((i & 2) != 0) {
            list2 = resultWrapper.recents;
        }
        return resultWrapper.copy(list, list2);
    }

    @Nullable
    public final List<RandomSlideShow> component1() {
        return this.randomSlideShow;
    }

    @Nullable
    public final List<Recent> component2() {
        return this.recents;
    }

    @NotNull
    public final ResultWrapper copy(@Nullable List<RandomSlideShow> randomSlideShow, @Nullable List<Recent> recents) {
        return new ResultWrapper(randomSlideShow, recents);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResultWrapper)) {
            return false;
        }
        ResultWrapper resultWrapper = (ResultWrapper) other;
        return Intrinsics.areEqual(this.randomSlideShow, resultWrapper.randomSlideShow) && Intrinsics.areEqual(this.recents, resultWrapper.recents);
    }

    public int hashCode() {
        return ((this.randomSlideShow == null ? 0 : this.randomSlideShow.hashCode()) * 31) + (this.recents != null ? this.recents.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ResultWrapper(randomSlideShow=" + this.randomSlideShow + ", recents=" + this.recents + ')';
    }

    public ResultWrapper(@Nullable List<RandomSlideShow> list, @Nullable List<Recent> list2) {
        this.randomSlideShow = list;
        this.recents = list2;
    }

    @Nullable
    public final List<RandomSlideShow> getRandomSlideShow() {
        return this.randomSlideShow;
    }

    @Nullable
    public final List<Recent> getRecents() {
        return this.recents;
    }
}
