package com.Fibwatch;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Fibwatch/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/Fibwatch/LoadlinksOut;", "", "status", "", "current", "", "Lcom/Fibwatch/LoadItem;", "popup", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getStatus", "()Ljava/lang/String;", "getCurrent", "()Ljava/util/List;", "getPopup", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Fibwatch"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class LoadlinksOut {

    @NotNull
    private final List<LoadItem> current;

    @NotNull
    private final List<LoadItem> popup;

    @NotNull
    private final String status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LoadlinksOut copy$default(LoadlinksOut loadlinksOut, String str, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loadlinksOut.status;
        }
        if ((i & 2) != 0) {
            list = loadlinksOut.current;
        }
        if ((i & 4) != 0) {
            list2 = loadlinksOut.popup;
        }
        return loadlinksOut.copy(str, list, list2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final List<LoadItem> component2() {
        return this.current;
    }

    @NotNull
    public final List<LoadItem> component3() {
        return this.popup;
    }

    @NotNull
    public final LoadlinksOut copy(@NotNull String status, @NotNull List<LoadItem> current, @NotNull List<LoadItem> popup) {
        return new LoadlinksOut(status, current, popup);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadlinksOut)) {
            return false;
        }
        LoadlinksOut loadlinksOut = (LoadlinksOut) other;
        return Intrinsics.areEqual(this.status, loadlinksOut.status) && Intrinsics.areEqual(this.current, loadlinksOut.current) && Intrinsics.areEqual(this.popup, loadlinksOut.popup);
    }

    public int hashCode() {
        return (((this.status.hashCode() * 31) + this.current.hashCode()) * 31) + this.popup.hashCode();
    }

    @NotNull
    public String toString() {
        return "LoadlinksOut(status=" + this.status + ", current=" + this.current + ", popup=" + this.popup + ')';
    }

    public LoadlinksOut(@NotNull String status, @NotNull List<LoadItem> list, @NotNull List<LoadItem> list2) {
        this.status = status;
        this.current = list;
        this.popup = list2;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final List<LoadItem> getCurrent() {
        return this.current;
    }

    @NotNull
    public final List<LoadItem> getPopup() {
        return this.popup;
    }
}
