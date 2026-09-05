package com.Kartoons;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KartoonsParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJd\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020'HÖ\u0081\u0004J\n\u0010(\u001a\u00020)HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lcom/Kartoons/Load;", "", "success", "", "data", "Lcom/Kartoons/LoadData;", "related", "", "Lcom/Kartoons/Related;", "watchHistory", "userRating", "totalRatings", "", "<init>", "(Ljava/lang/Boolean;Lcom/Kartoons/LoadData;Ljava/util/List;Ljava/util/List;Ljava/lang/Object;Ljava/lang/Long;)V", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getData", "()Lcom/Kartoons/LoadData;", "getRelated", "()Ljava/util/List;", "getWatchHistory", "getUserRating", "()Ljava/lang/Object;", "getTotalRatings", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Lcom/Kartoons/LoadData;Ljava/util/List;Ljava/util/List;Ljava/lang/Object;Ljava/lang/Long;)Lcom/Kartoons/Load;", "equals", "other", "hashCode", "", "toString", "", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Load {

    @Nullable
    private final LoadData data;

    @Nullable
    private final List<Related> related;

    @Nullable
    private final Boolean success;

    @Nullable
    private final Long totalRatings;

    @Nullable
    private final Object userRating;

    @Nullable
    private final List<Object> watchHistory;

    public Load() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Load copy$default(Load load, Boolean bool, LoadData loadData, List list, List list2, Object obj, Long l, int i, Object obj2) {
        if ((i & 1) != 0) {
            bool = load.success;
        }
        if ((i & 2) != 0) {
            loadData = load.data;
        }
        if ((i & 4) != 0) {
            list = load.related;
        }
        if ((i & 8) != 0) {
            list2 = load.watchHistory;
        }
        if ((i & 16) != 0) {
            obj = load.userRating;
        }
        if ((i & 32) != 0) {
            l = load.totalRatings;
        }
        Object obj3 = obj;
        Long l2 = l;
        return load.copy(bool, loadData, list, list2, obj3, l2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LoadData getData() {
        return this.data;
    }

    @Nullable
    public final List<Related> component3() {
        return this.related;
    }

    @Nullable
    public final List<Object> component4() {
        return this.watchHistory;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Object getUserRating() {
        return this.userRating;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getTotalRatings() {
        return this.totalRatings;
    }

    @NotNull
    public final Load copy(@Nullable Boolean success, @Nullable LoadData data, @Nullable List<Related> related, @Nullable List<? extends Object> watchHistory, @Nullable Object userRating, @Nullable Long totalRatings) {
        return new Load(success, data, related, watchHistory, userRating, totalRatings);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Load)) {
            return false;
        }
        Load load = (Load) other;
        return Intrinsics.areEqual(this.success, load.success) && Intrinsics.areEqual(this.data, load.data) && Intrinsics.areEqual(this.related, load.related) && Intrinsics.areEqual(this.watchHistory, load.watchHistory) && Intrinsics.areEqual(this.userRating, load.userRating) && Intrinsics.areEqual(this.totalRatings, load.totalRatings);
    }

    public int hashCode() {
        return ((((((((((this.success == null ? 0 : this.success.hashCode()) * 31) + (this.data == null ? 0 : this.data.hashCode())) * 31) + (this.related == null ? 0 : this.related.hashCode())) * 31) + (this.watchHistory == null ? 0 : this.watchHistory.hashCode())) * 31) + (this.userRating == null ? 0 : this.userRating.hashCode())) * 31) + (this.totalRatings != null ? this.totalRatings.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Load(success=" + this.success + ", data=" + this.data + ", related=" + this.related + ", watchHistory=" + this.watchHistory + ", userRating=" + this.userRating + ", totalRatings=" + this.totalRatings + ')';
    }

    public Load(@Nullable Boolean success, @Nullable LoadData data, @Nullable List<Related> list, @Nullable List<? extends Object> list2, @Nullable Object userRating, @Nullable Long totalRatings) {
        this.success = success;
        this.data = data;
        this.related = list;
        this.watchHistory = list2;
        this.userRating = userRating;
        this.totalRatings = totalRatings;
    }

    public /* synthetic */ Load(Boolean bool, LoadData loadData, List list, List list2, Object obj, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : loadData, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : obj, (i & 32) != 0 ? null : l);
    }

    @Nullable
    public final Boolean getSuccess() {
        return this.success;
    }

    @Nullable
    public final LoadData getData() {
        return this.data;
    }

    @Nullable
    public final List<Related> getRelated() {
        return this.related;
    }

    @Nullable
    public final List<Object> getWatchHistory() {
        return this.watchHistory;
    }

    @Nullable
    public final Object getUserRating() {
        return this.userRating;
    }

    @Nullable
    public final Long getTotalRatings() {
        return this.totalRatings;
    }
}
