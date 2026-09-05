package com.Kartoons;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KartoonsParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J,\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/Kartoons/Home;", "", "success", "", "data", "", "Lcom/Kartoons/Data;", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;)V", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getData", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/List;)Lcom/Kartoons/Home;", "equals", "other", "hashCode", "", "toString", "", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Home {

    @Nullable
    private final List<Data> data;

    @Nullable
    private final Boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public Home() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Home copy$default(Home home, Boolean bool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = home.success;
        }
        if ((i & 2) != 0) {
            list = home.data;
        }
        return home.copy(bool, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    @Nullable
    public final List<Data> component2() {
        return this.data;
    }

    @NotNull
    public final Home copy(@Nullable Boolean success, @Nullable List<Data> data) {
        return new Home(success, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Home)) {
            return false;
        }
        Home home = (Home) other;
        return Intrinsics.areEqual(this.success, home.success) && Intrinsics.areEqual(this.data, home.data);
    }

    public int hashCode() {
        return ((this.success == null ? 0 : this.success.hashCode()) * 31) + (this.data != null ? this.data.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Home(success=" + this.success + ", data=" + this.data + ')';
    }

    public Home(@Nullable Boolean success, @Nullable List<Data> list) {
        this.success = success;
        this.data = list;
    }

    public /* synthetic */ Home(Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : list);
    }

    @Nullable
    public final Boolean getSuccess() {
        return this.success;
    }

    @Nullable
    public final List<Data> getData() {
        return this.data;
    }
}
