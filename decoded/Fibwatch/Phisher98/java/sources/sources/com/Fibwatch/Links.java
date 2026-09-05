package com.Fibwatch;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Fibwatch/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/Fibwatch/Links;", "", "status", "", "current", "", "Lcom/Fibwatch/Current;", "popup", "Lcom/Fibwatch/Popup;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getStatus", "()Ljava/lang/String;", "getCurrent", "()Ljava/util/List;", "getPopup", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Fibwatch"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Links {

    @NotNull
    private final List<Current> current;

    @NotNull
    private final List<Popup> popup;

    @Nullable
    private final String status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Links copy$default(Links links, String str, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = links.status;
        }
        if ((i & 2) != 0) {
            list = links.current;
        }
        if ((i & 4) != 0) {
            list2 = links.popup;
        }
        return links.copy(str, list, list2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final List<Current> component2() {
        return this.current;
    }

    @NotNull
    public final List<Popup> component3() {
        return this.popup;
    }

    @NotNull
    public final Links copy(@Nullable String status, @NotNull List<Current> current, @NotNull List<Popup> popup) {
        return new Links(status, current, popup);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Links)) {
            return false;
        }
        Links links = (Links) other;
        return Intrinsics.areEqual(this.status, links.status) && Intrinsics.areEqual(this.current, links.current) && Intrinsics.areEqual(this.popup, links.popup);
    }

    public int hashCode() {
        return ((((this.status == null ? 0 : this.status.hashCode()) * 31) + this.current.hashCode()) * 31) + this.popup.hashCode();
    }

    @NotNull
    public String toString() {
        return "Links(status=" + this.status + ", current=" + this.current + ", popup=" + this.popup + ')';
    }

    public Links(@Nullable String status, @NotNull List<Current> list, @NotNull List<Popup> list2) {
        this.status = status;
        this.current = list;
        this.popup = list2;
    }

    public /* synthetic */ Links(String str, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2);
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final List<Current> getCurrent() {
        return this.current;
    }

    @NotNull
    public final List<Popup> getPopup() {
        return this.popup;
    }
}
