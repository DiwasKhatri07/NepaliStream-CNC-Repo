package com.phisher98;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UltimaBackupUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u0002H\n¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010\u0011\u001a\u00020\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/phisher98/UltimaEditor;", "", "editor", "Landroid/content/SharedPreferences$Editor;", "<init>", "(Landroid/content/SharedPreferences$Editor;)V", "getEditor", "()Landroid/content/SharedPreferences$Editor;", "setKeyRaw", "", "T", "path", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "isStringSet", "", "apply", "component1", "copy", "equals", "other", "hashCode", "", "toString", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUltimaBackupUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UltimaBackupUtils.kt\ncom/phisher98/UltimaEditor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,949:1\n812#2,12:950\n*S KotlinDebug\n*F\n+ 1 UltimaBackupUtils.kt\ncom/phisher98/UltimaEditor\n*L\n73#1:950,12\n*E\n"})
public final /* data */ class UltimaEditor {

    @NotNull
    private final SharedPreferences.Editor editor;

    public static /* synthetic */ UltimaEditor copy$default(UltimaEditor ultimaEditor, SharedPreferences.Editor editor, int i, Object obj) {
        if ((i & 1) != 0) {
            editor = ultimaEditor.editor;
        }
        return ultimaEditor.copy(editor);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SharedPreferences.Editor getEditor() {
        return this.editor;
    }

    @NotNull
    public final UltimaEditor copy(@NotNull SharedPreferences.Editor editor) {
        return new UltimaEditor(editor);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UltimaEditor) && Intrinsics.areEqual(this.editor, ((UltimaEditor) other).editor);
    }

    public int hashCode() {
        return this.editor.hashCode();
    }

    @NotNull
    public String toString() {
        return "UltimaEditor(editor=" + this.editor + ')';
    }

    public UltimaEditor(@NotNull SharedPreferences.Editor editor) {
        this.editor = editor;
    }

    @NotNull
    public final SharedPreferences.Editor getEditor() {
        return this.editor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void setKeyRaw(@NotNull String path, T value) {
        if (isStringSet(value)) {
            SharedPreferences.Editor editor = this.editor;
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
            editor.putStringSet(path, (Set) value);
            return;
        }
        if (!(value instanceof Boolean)) {
            if (!(value instanceof Integer)) {
                if (!(value instanceof String)) {
                    if (!(value instanceof Float)) {
                        if (value instanceof Long) {
                            this.editor.putLong(path, ((Number) value).longValue());
                            return;
                        }
                        return;
                    }
                    this.editor.putFloat(path, ((Number) value).floatValue());
                    return;
                }
                this.editor.putString(path, (String) value);
                return;
            }
            this.editor.putInt(path, ((Number) value).intValue());
            return;
        }
        this.editor.putBoolean(path, ((Boolean) value).booleanValue());
    }

    private final boolean isStringSet(Object value) {
        if (!(value instanceof Set)) {
            return false;
        }
        Iterable $this$filterIsInstance$iv = (Iterable) value;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof String) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return ((List) destination$iv$iv).size() == ((Set) value).size();
    }

    public final void apply() {
        this.editor.apply();
    }
}
